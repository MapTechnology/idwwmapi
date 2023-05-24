package idw.model.rn.integracao.tdba;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwFolhaTemplate;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.GTRN;
import idw.model.rn.PTRN;
import idw.model.rn.ProdutoRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.CpDTO;
import idw.webservices.dto.FolhaDTO;
import idw.webservices.dto.ListaCPDTO;

public class IntegracaoTDBAOPRN extends AIntegracaoTDBA {

	public IntegracaoTDBAOPRN(DAOGenerico dao, DAOGenericoErp daoERP) {
		super(dao, daoERP);
	}

	@Override
	public boolean integrar(OmJoblog joblog, OmJobdet det, IdwLogger log, int idLog) {
		boolean retorno = true;

		MapQuery q = new MapQuery(daoERP.getSession());
		q.append("select id, idempresa, idarea, nr_ord_prod, sequencia, cd_posto, cd_ferramenta, revisao, cd_produto, qt_ordem, tempo_setup, dthr_inicio, dthr_termino from mi_ord_prod where st_registro = 0 order by id");

		List<Object> lista = q.querySQL().list();

		// Abrir DAO com session
		DAOGenerico daoSessao = new DAOGenerico();

		BigInteger id = BigInteger.ZERO;

		try {

			daoSessao.iniciaConexaoBanco();

			for (Object linha : lista) {
				Date dthr = DataHoraRN.getDataHoraAtual();
				Object[] registro = (Object[]) linha;

				id = (BigInteger) registro[0];
				// String idEmpresa = registro[1].toString();
				String idArea = registro[2].toString().trim();
				String nrop = registro[3].toString();
				Integer sequencia = (Integer) registro[4];
				String cdposto = registro[5].toString();
				String cdferramenta = registro[6].toString();
				String revisao = registro[7].toString();
				String cdproduto = registro[8].toString();
				BigDecimal qtOrdem = (BigDecimal) registro[9];
				BigDecimal temposetup = (BigDecimal) registro[10];

				Date dthrinicio = null;
				if (registro[11] != null)
					dthrinicio = (Date) registro[11];

				Date dthrtermino = null;
				if (registro[12] != null)
					dthrtermino = (Date) registro[12];

				// Inclusao/
				incluirOP(daoSessao, id, idArea, nrop, sequencia, cdposto, cdferramenta, revisao, cdproduto, qtOrdem, temposetup, dthrinicio, dthrtermino);

				// se falhou alguma importacao setar retorno como false
				if (getStregistro() != 1)
					retorno = false;

				// Incluir o resultado da importação do registro
				OmJobdetlog detlog = new OmJobdetlog();
				detlog.setIdJobdetlog(null);
				detlog.setDsExecucao(getResultado());
				detlog.setDthrIexecucao(dthr);
				detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());
				detlog.setOmJoblog(joblog);
				detlog.setOmJobdet(det);
				detlog.setUrlOrigem("id " + id + " em mi_ord_prod");
				detlog.setStExecucao((byte) (getStregistro() == 1 ? 1 : 0));

				dao.makePersistent(detlog);

			}
		} catch (Exception e) {
			e.printStackTrace();
			atualizarResultado(id, 2, "OP com erro desconhecido " + e.getMessage(), "mi_ord_prod");
		} finally {
			daoSessao.finalizaConexaoBanco();
		}

		return retorno;
	}

	private void incluirOP(DAOGenerico daoSessao, BigInteger id, String idArea, String nrop, Integer sequencia, String cdposto,
			String cdferramenta, String revisao, String cdproduto, BigDecimal qtOrdem, BigDecimal temposetup, Date dthrinicio,
			Date dthrtermino) {
		
		// Verifica se existe o posto
		PTRN rn = new PTRN(daoSessao);
		GTRN grn = new GTRN();
		grn.setDao(daoSessao);
		grn.setSession(daoSessao.getSession());

		omcfg = Util.getConfigGeral(daoSessao.getSession());

		// pesquisa PT. Se nao existir marcar como erro na importacao
		OmPt ompt;
		try {
			ompt = rn.getOmPt(cdposto);
		} catch (Exception e) {
			ompt = null;
		}
		if (ompt == null) {
			atualizarResultado(id, 2, "Posto " + cdposto + " desconhecido no idw.", "mi_ord_prod");
			return;
		}
		
		
		
		// Verifica se existe o produto
		ProdutoRN prn = new ProdutoRN(daoSessao);
		OmProduto omproduto;
		try {
			omproduto = prn.getOmProduto(cdproduto);
		} catch (RegistroDesconhecidoException e) {
			omproduto = null;
		}
		if (omproduto == null) {
			atualizarResultado(id, 2, "Produto " + cdproduto + " desconhecido no idw.", "mi_ord_prod");
			return;
		}
		
		
		
		// Verifica se existe a área da OP. Se não, retornar erro
		OmGt omgt = grn.getOmGtByCdGt(idArea);
		if (omgt == null) {
			atualizarResultado(id, 2, "OP " + nrop + " não encontrou grupo " + idArea, "mi_ord_prod");
			return;
		}
		
		/*
		Alessandre em 12-07-22, se nao encontrar a folha pela ferramenta e o produto, entao incluir uma nova para a Op. procurar qual o ciclo padrao na importacao.
		
		// Verifica se existe a folha de processo para a ferramenta e o produto. Se não retornar erro
		FolhaRN frn = new FolhaRN(daoSessao);
		DwFolha dwfolha = frn.pesquisaFolhaByCdEStSemRota(cdferramenta + "-" + revisao);
		if (dwfolha == null) {
			atualizarResultado(id, 2, "OP " + nrop + " não encontrou folha " + cdferramenta+"-"+revisao, "mi_ord_prod");
			return;
		} */
		
		FolhaRN frn = new FolhaRN(daoSessao);
		DwFolha dwfolha = frn.pesquisarDwFolhaByCdProduto(cdproduto, cdposto);
		if (dwfolha == null) {
			
			// Incluir a folha
//			atualizarResultado(id, 2, "OP " + nrop + " não encontrou folha para o produto" + cdproduto +" e posto "+cdposto, "mi_ord_prod");
//			return;
			
			FolhaDTO dto = new FolhaDTO();
			dwfolha = new DwFolha();
			
			dwfolha.setIdFolha(null);
			dwfolha.setCdFolha(cdferramenta + "-" + revisao);
			dwfolha.setRevisao(1l);
			dwfolha.setDtRevisao(DataHoraRN.getDataHoraAtual());
			dwfolha.setDtStativo(dwfolha.getDtRevisao());
			dwfolha.setStAtivo((byte) 1);
			dwfolha.setDsFolha(omproduto.getDsProduto());
			dwfolha.setOmTppt(ompt.getOmTppt());
			dwfolha.setSegCiclominimo(BigDecimal.ZERO);
			dwfolha.setSegCiclopadrao(new BigDecimal(60));
			dwfolha.setSegCiclotimeout(new BigDecimal(200));
			dwfolha.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			dwfolha.setOmUsrByIdUsrstativo(dwfolha.getOmUsrByIdUsrrevisao());
			dwfolha.setTpFolha(DwFolhaTemplate.TpFolha.APENAS_REGISTRO_PASSAGEM.getValue());
			dwfolha.setTpProducao(DwFolhaTemplate._TP_PRODUCAO._TP_PRODUCAO_AUTOMATICA.getValue());
			dwfolha.setOmGt(omgt);

			DwFolhaiac dwfolhaiac = new DwFolhaiac();
			dwfolhaiac.setDwFolha(dwfolha);
			dwfolhaiac.setIdFolhaiac(null);
			dwfolhaiac.setOmProduto(omproduto);
			

			dwfolha.setDwFolhaiacs(new HashSet<DwFolhaiac>());
			dwfolha.getDwFolhaiacs().add(dwfolhaiac);
			
			dwfolha = daoSessao.makePersistent(dwfolha);
		}
		
		/* Alessandre em 12-07-22 comentada a verificação pois a folha agora eh encontrada considerando o produto
		// Verifica se o produto em questão faz parte da estrutura da ferramenta da folha
		boolean isExiste = false;
		for (DwFolharap dwfolharapAux : dwfolha.getDwFolharaps()) {
			for (DwFolharapcom dwfolharapcom : dwfolharapAux.getDwFolharapcoms()) {
				if (dwfolharapcom.getOmProduto().getCdProduto().equals(cdproduto)) {
					isExiste = true;
				}
			}
		}
		if (isExiste == false) {
			atualizarResultado(id, 2, "OP " + nrop + " não encontrou produto " + cdproduto + " na folha " + cdferramenta+"-"+revisao, "mi_ord_prod");
			return;
		} */

		
		
		// Verifica se existe a OP. Se nao exisitr incluir.
		CpRN crn = new CpRN(daoSessao);
		PpCp ppcp = crn.pesquisarPpCpByNrDocCdPt(nrop, cdposto);
		if (ppcp == null) {
			ppcp = new PpCp();
			ppcp.setIdCp(null);
			ppcp.setCdCp(nrop + "-" + sequencia);
			ppcp.setDthrInicio(dthrinicio);
			ppcp.setDthrFinal(dthrtermino);
			ppcp.setOmPt(ompt);
			ppcp.setDwFolha(dwfolha);
			ppcp.setStCp(PpCpTemplate.StCp.CADASTRADA.getValue());
			ppcp.setTpCp(PpCpTemplate.TpCp.PRODUCAO.getValue());
			ppcp.setOmGt(omgt);
			ppcp.setPpCpprodutos(new HashSet<PpCpproduto>());
			PpCpproduto cpproduto = new PpCpproduto();
			cpproduto.setIdCpproduto(null);
			cpproduto.setNrDoc(nrop);
			cpproduto.setOmProduto(omproduto);
			cpproduto.setPcsProducaoplanejada(qtOrdem);
			cpproduto.setPpCp(ppcp);
			ppcp.getPpCpprodutos().add(cpproduto);
			
			
			// incluir a OP
			ListaCPDTO listaCPDTO = new ListaCPDTO();
			CpDTO cpdto = new CpDTO();
			cpdto.setCp(ppcp);
			listaCPDTO.getListaCps().add(cpdto);
			
			listaCPDTO = crn.salvarPpCpOrdemProducao(listaCPDTO);
			if (listaCPDTO.getResultado().getIdmensagem() != listaCPDTO.getResultado().COM_SUCESSO) {
				atualizarResultado(id, 2, "OP " + nrop + " erro " + listaCPDTO.getResultado().getDescricaoMensagem(), "mi_ord_prod");
				return;
			}
			
		} else {
			boolean isExiste = false;
			// Se exisitir verifica se tem o produto em questão. Se não incluir.
			for (PpCpproduto cpproduto : ppcp.getPpCpprodutos()) {
				if (cpproduto.getOmProduto().getCdProduto().equals(cdproduto)) {
					isExiste = true;
				}
			}
			if (isExiste == false) {
				// Incluir o produto na OP
				PpCpproduto cpproduto = new PpCpproduto();
				cpproduto.setIdCpproduto(null);
				cpproduto.setNrDoc(nrop);
				cpproduto.setOmProduto(omproduto);
				cpproduto.setPcsProducaoplanejada(qtOrdem);
				cpproduto.setPpCp(ppcp);
				daoSessao.makePersistent(cpproduto);
			} else {
				atualizarResultado(id, 2, "OP " + nrop + " já existe no idw.", "mi_ord_prod");
				return;
			}
		}
		
		// Informar finalização da inclusao da OP com sucesso
		atualizarResultado(id, 1, "OP " + nrop + " incluida com sucesso.", "mi_ord_prod");
	}

}
