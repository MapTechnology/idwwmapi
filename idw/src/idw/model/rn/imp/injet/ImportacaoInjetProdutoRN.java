package idw.model.rn.imp.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmProcomestDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.DigestFileException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUnidmedida;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijestruprod;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.pojos.injet.Ijtbpro;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.pojos.template.OmProgrpTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.injet.ProdutoInjetRN;
import idw.util.IdwLogger;

/**
 *
 * @author milton
 *
 */
public class ImportacaoInjetProdutoRN extends ImportacaoInjetRN {

	private final ProdutoInjetRN produtoInjetRN;
	private final ProdutoRN produtoRN;
	private final static String _CD_PROGRP = "0"; // Grupo de produto;

	public ImportacaoInjetProdutoRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.produtoInjetRN = new ProdutoInjetRN(daoInjet);
		this.produtoRN =  new ProdutoRN(dao);

	}

	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		return ijtbmestres.getAtualizartabprousu() != null && ijtbmestres.getAtualizartabprousu().equals(BigDecimal.ONE);
	}

	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt) {
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importa��oo da tabela de produto");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de usuario disponíveis na base do injet
			List<Ijtbpro> listProdutosInjet = this.produtoInjetRN.listaProdutosAtivos();

			if(listProdutosInjet.size() > 0){

				List<String> listCdProdutoInjet = new ArrayList<>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijtbpro ijtbpro: listProdutosInjet){
					try {
						this.importar(ijtbpro, date, omUsr);
					} catch (RegistroDesconhecidoException e) {
						// TODO Milton - Log informando que usuário n�o foi importado porque n�o existe grupo de usuário default CD_USRGRP_DEFAULT
						this.getLog().info(this.getIdLog(), this.getIdentacao(),"Produto " + ijtbpro.getCdproduto() + " n�o importado porque n�o existe OmProgrp default (" + ImportacaoInjetProdutoRN._CD_PROGRP + ")" );
					}
					listCdProdutoInjet.add(ijtbpro.getCdproduto());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listProdutosInjet.size() + " registros");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos as " + DataHoraRN.getDataHoraAtual());
				this.produtoRN.desativarOmProdutos(listCdProdutoInjet, date, omUsr);

				// Importar as estruturas diferentes
				for(Ijtbpro ijtbpro: listProdutosInjet){
					try {
						this.importarEstrutura(ijtbpro, date, omUsr);
					} catch (RegistroDesconhecidoException e) {
					}
				}

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.produtoRN.desativarOmProdutos(DataHoraRN.getDataHoraAtual(), omUsr);
			}
		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importacao nao eh necessaria. Nao marcado para importacao");
		}

		this.getLog().mostrarAvaliacaoCompleta();

	}

	/**
	 * Importa os dados de {@code ijtbinj} para {@code omPt}
	 * @param ijtbinj
	 * @param dateOperacao
	 * @param omUsrOperacao
	 * @throws RegistroDesconhecidoException quando grupo para máquina n�o é encontrado
	 * @throws DigestFileException
	 */
	private void importar(Ijtbpro ijtbpro, Date dateOperacao, OmUsr omUsrOperacao) throws RegistroDesconhecidoException{

		Validate.notNull(ijtbpro, "ijtbpro");
		Validate.notNull(omUsrOperacao, "omUsrOperacao");

		OmProduto omProduto = new OmProduto();

		ProdutoRN rn = new ProdutoRN();
		rn.setDao(getDao());

		// Pega os campos que n�o est�o no banco do injet
		OmProduto omProdutoDB = null;
		try {
			omProdutoDB = this.getDao().findByCd(OmProduto.class, ijtbpro.getCdproduto(), OmProdutoTemplate._FIELD_NAME_CD, true);

			// Atualizar omproduto somente se houver mudanca em cdproduto ou dsproduto
			if (omProdutoDB.getDsProduto().equals(ijtbpro.getDsproduto()))
				return;

			omProduto.set(
					0,
					omProdutoDB.getCdProduto(),
					null,
					omProdutoDB.getDsProduto(),
					null,
					null,
					(byte) 0,
					omProdutoDB.getTpProduto(),
					omProdutoDB.getMinValposalim(),
					omProdutoDB.getDsComplemento(),
					omProdutoDB.getDepara(),
					omProdutoDB.getHrLeadtimeentrada(),
					omProdutoDB.getHrLeadtimesaida(),
					omProdutoDB.getTpProducao(),
					omProdutoDB.getIndPerdaproducao(),
					omProdutoDB.getDsCurta(),
					new BigDecimal(1),
					new BigDecimal(1),
					omProdutoDB.getDwEst(),
					omProdutoDB.getOmFor(),
					omUsrOperacao,
					omProdutoDB.getOmProgrp(),
					omUsrOperacao,
					omProdutoDB.getOmCc(),
					omProdutoDB.getOmProdutoByIdProdutoagru(),
					omProdutoDB.getPpCliente(),
					omProdutoDB.getOmUnidmedida(),
					omProdutoDB.getTpOrigem(),
					omProdutoDB.getVlCustounit(),
					omProdutoDB.getQtLoteminprod(),
					null,
					omProdutoDB.getIsDat(),
					omProdutoDB.getIsConsumido(),
					omProdutoDB.getTpClasseabc(),
					omProdutoDB.getCdSap(), omProdutoDB.getCdCaixa(), omProdutoDB.getQtEmpilhamento(),
					omProdutoDB.getCdModelo(), omProdutoDB.getCdPartnumber(),
					omProdutoDB.getIsRequerroteiro(),
					omProdutoDB.getIsRastreabilidade()
					);

			omProdutoDB.setDsProduto(ijtbpro.getDsproduto());

			getDao().makePersistent(omProdutoDB);

		} catch (RegistroDesconhecidoException e) {

			// Se nao encontrar dispara RegistroDesconhecidoException
			OmProgrp omProgrp = this.getDao().findByCd(OmProgrp.class, ImportacaoInjetProdutoRN._CD_PROGRP, OmProgrpTemplate._FIELD_NAME_CD, true);

			// Procurar a unidade do produto
			OmUnidmedida omunidade = null;
			omunidade = rn.getOmUnidmedidaGeraNovoSeNaoEncontrar(ijtbpro.getUnproduto(), dateOperacao, omUsrOperacao);


			omProduto.set(
					0, // long idProduto
					ijtbpro.getCdproduto(), // String cdProduto
					null, // Long revisao
					ijtbpro.getDsproduto(), // String dsProduto
					null, // Date dtRevisao
					null, // Date dtStativo
					(byte) 1, // Byte stAtivo
					OmProdutoTemplate.TpProduto.SEMI_ACABADO.getId(), // Byte tpProduto
					null, // BigDecimal minValposalim
					null, // String dsComplemento
					null, // String depara
					null, // BigDecimal hrLeadtimeentrada
					null, // BigDecimal hrLeadtimesaida
					null, // BigDecimal tpProducao
					null, // BigDecimal indPerdaproducao
					null, // String dsCurta
					ijtbpro.getPbrutomedio(), // BigDecimal gPesoBruto
					ijtbpro.getPliquidomedio(), // BigDecimal gPesoLiquido
					null, // DwEst dwEst
					null, // OmFor omFor
					omUsrOperacao, // OmUsr omUsrByIdUsrstativo
					omProgrp, // OmProgrp omProgrp
					omUsrOperacao, // OmUsr omUsrByIdUsrrevisao
					null, // OmCc omCc
					null, // OmProduto omProdutoByIdProdutoagru
					null, // PpCliente ppCliente
					omunidade, // OmUnidmedida omUnidmedida
					null, //Integer tpOrigem
					ijtbpro.getVlproduto(), // BigDecimal vlCustounit
					null, // BigDecimal qtLoteminprod
					null, // Byte tpSemiacabado
					null, // Boolean isDat
					null, // Boolean isConsumido
					(byte) 0, // Byte tpClasseabc
					null, // cdSap
					null, // cdCaixa
					null, // qtEmpilhamento
					null, // cdModelo
					null, // cdPartnumber
					null, // requer roteiro
					null
					);

		}
		omProduto.limitarStrings();

		omProduto = getDao().makePersistent(omProduto);
	}



	private void importarEstrutura(Ijtbpro ijtbpro, Date dateOperacao, OmUsr omUsrOperacao) throws RegistroDesconhecidoException{
		OmProcomestDAO dao = new OmProcomestDAO(getDao().getSession());
		ProdutoRN rn = new ProdutoRN(getDao());
		// Pesquisar omProduto
		OmProduto omprodutoPai = rn.getOmProduto(ijtbpro.getCdproduto(), true, false, false);

		for (Ijestruprod estrutura : ijtbpro.getIjestruprodsForCdproduto()) {
			// Pesquisar omPRodutoFilho
			OmProduto omprodutoFilho = rn.getOmProduto(estrutura.getIjtbproByCdprodutoseq().getCdproduto(), true, false, false);

			// Pesquisar se existe OmProComEst. Se nao existir, incluir
			OmProcomest omprocomest = dao.getOmProcomest(omprodutoPai, omprodutoFilho);
			if (omprocomest == null) {
				omprocomest = new OmProcomest();
				omprocomest.setConjunto(1);
				omprocomest.setIdProcomest(null);
				omprocomest.setOmProdutoByIdProduto(omprodutoPai);
				omprocomest.setOmProdutoByIdProdutomp(omprodutoFilho);
				omprocomest.setQtUsada(new BigDecimal(estrutura.getQtitens()));
				omprocomest.setTpProcomest(1); // Sempre semiacabado

				getDao().makePersistent(omprocomest);
			}
		}
	}

}
