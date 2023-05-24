package idw.model.rn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.CompareToBuilder;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolal;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolaloco;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmo;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolmooco;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpamo;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolprmo;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwConsolreoco;
import idw.model.pojos.DwConsolvaritmolog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.DwTurno;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpPlano;
import idw.model.pojos.PpTpplano;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwPeproTemplate;
import idw.model.pojos.template.OmTpptTemplate;
import idw.model.pojos.template.PpCpTemplate;
import idw.util.AritmeticaUtil;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.DwConsolidDTO;
import idw.webservices.dto.DwConsolidDTOs;
import idw.webservices.dto.PassagemDTO;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;
import ms.coleta.ic.inova.Stubdelegate;

/**
 *
 * TODO milton - Preparar procedimento para consolidaçãoo de parada aberta
 * TODO milton - rever exceptions
 */
public class ConsolidaRN extends AbstractRN<DAOGenerico> {

	public static final boolean MAQUINA_INSERSORA_CONSIDERA_PARADA_COMO_TEMPO_ATIVO = false;
	protected static final boolean TRATAR_CORRECAO_TEMPO_ATIVO = true;

	/** 
	 * Marcado como false, pois os eventos de parada não estão sendo marcados em dwconsolpt.getdthrf, 
	 * MAQUINA_INSERSORA_CONSIDERA_PARADA_COMO_TEMPO_ATIVO está false, quando são de SMD. 
	 * Como pode ocorrer de periodos de parada que não estejam dentro de ciclo,
	 * acabava considerando o intervalo do Último ciclo até o atual, e se intervalo estivesse com paradas,
	 * considerava um tempo a mais de CTA, e incrementava o ciclo real com este tempo, 
	 * gerando um tempo a mais no período 
	 * 
	 */
	protected static final boolean TRATAR_CORRECAO_TEMPO_ATIVO_CICLO_COMPARANDO_ULT_DTHRF_PT = false;

	private static final String NR_OP_DEFAULT = "0";
	public ConsolidaRN(){
		this(null);
	}

	public ConsolidaRN(DAOGenerico dao){
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
			this.setDao(dao);
		}
	}

	/**
	 * Esse metodo foi criado para servir de apoio ao metodo obtemPpCp. 
	 * <br>Quando nao existe ppCp devemos incluir uma nova e usar obtemDwFolha para pesquisar a folha ou criar uma nova.
	 * <p> Para a pesquisar a folha Ã© usado o {@link FolhaRN#pesquisaFolhaByCdEStSemRota(String)} 
	 * <br>usando como cÃ³digo de folha {@code msevt.getNrop() + "-" + ompt.getOmTppt().getCdTppt())} 
	 * <br>Isso foi feito para a coleta do insert
	 */
	public DwFolha obtemDwFolha(OmPt ompt, String nrop, String cdProduto, String cdFolha, OmCfg omcfg, BigDecimal segCiclopadrao){
		FolhaRN rn = new FolhaRN(getDao());
		// Alessandre: em 23-01-15 comentei a linha abaixo usando o cdProduto para gerar a folha ao inves da OP que eh o programa
		// Com isso para os clientes com INSERT o script 93 deve ser executado para tornar a mascara do cdproduto igual ao da nrop
		// Na verdade nao pode deixar as mascaras iguais pois senao o produto nao eh encontrado corretamente. Assim uma nova
		// mascara foi criada para a folha especificamente
		//String cdFolha = nrop + "-" + ompt.getOmTppt().getCdTppt();
		//String cdFolha = cdProduto.trim() + "-" + ompt.getOmTppt().getCdTppt();
		DwFolha dwfolha = rn.pesquisaFolhaByCdEStSemRota(cdFolha);

		if (dwfolha == null) {
			// se nao existe a folha entao vou criar uma
			dwfolha = new DwFolha();
			dwfolha.setIdFolha(null);
			dwfolha.setCdFolha(cdFolha);
			dwfolha.setDsFolha("Cadastrada automaticamente pela coleta");
			dwfolha.setDtRevisao(DataHoraRN.getDataHoraAtual());
			dwfolha.setDtStativo(DataHoraRN.getDataHoraAtual());
			if (ompt.getOmGt() != null)
				dwfolha.setOmGt(ompt.getOmGt());
			else
				dwfolha.setOmGt(omcfg.getOmGtimpcic());
			dwfolha.setOmTppt(ompt.getOmTppt());
			dwfolha.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			dwfolha.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
			dwfolha.setRevisao(1l);
			dwfolha.setSegCiclominimo(new BigDecimal(0));
			
			if (segCiclopadrao != null) {
				dwfolha.setSegCiclopadrao(segCiclopadrao);
			} else {
				dwfolha.setSegCiclopadrao(new BigDecimal(60));
			}
			
			
			dwfolha.setSegCiclotimeout(new BigDecimal(200));
			dwfolha.setSegSetup(3600);
			dwfolha.setStAtivo((byte) 1);
			dwfolha.setTpFolha((byte) 6); // Por enquanto o tipo criado eh Programa IAC

			// Incluir em dwfolhaiac o produto com a producao por ciclo = 1
			ProdutoRN pRN = new ProdutoRN(getDao());
			OmProduto omproduto;
			omproduto = pRN.getProdutoByCdEStAtivo(cdProduto.trim());
			if (omproduto == null) {
				omproduto = new OmProduto();
				omproduto.setCdProduto(cdProduto.trim());
				omproduto.setDsProduto("Incluido automaticamente pelo obtem ppcp");
				omproduto.setDtRevisao(DataHoraRN.getDataHoraAtual());
				omproduto.setDtStativo(DataHoraRN.getDataHoraAtual());
				omproduto.setRevisao(1l);
				omproduto.setTpProduto((byte) 3); // Semiacabado
				omproduto.setTpProducao(BigDecimal.ZERO);
				omproduto.setStAtivo((byte) 1);
				omproduto.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
				omproduto.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
				omproduto.setIsRastreabilidade(true);
				getDao().makePersistent(omproduto);
			}
			DwFolhaiac dwfolhaiac = new DwFolhaiac();
			dwfolhaiac.setIdFolhaiac(null);
			dwfolhaiac.setDwFolha(dwfolha);
			dwfolhaiac.setOmPrg(null);
			dwfolhaiac.setOmProduto(omproduto);
			dwfolhaiac.setQtAtiva(BigDecimal.ONE);
			dwfolhaiac.setQtMpporciclo(null);

			dwfolha.setDwFolhaiacs(new HashSet<DwFolhaiac>());
			dwfolha.getDwFolhaiacs().add(dwfolhaiac);
			getDao().makePersistent(dwfolha);
		}

		return dwfolha;
	}


	protected PpCp obtemPpCp(IdwLogger log, int idLog, int identacao, OmPt ompt, List<DwCalsem> dwCalsems, MsEvt msevt, OmCfg omcfg){
		String cdProduto = msevt.getNrop();
		String cdFolha = msevt.getNrop();
		if (msevt.getCdProduto() != null && msevt.getCdProduto().equals("") == false) {
			cdProduto = msevt.getCdProduto();
		} else if (omcfg.getMascaracdprodutoCF() != null){
			cdProduto = Util.extraiPorMascara(msevt.getNrop(), omcfg.getMascaracdprodutoCF());
		}
		cdFolha = Util.extraiPorMascara(msevt.getNrop(), omcfg.getMascarafolha());
		cdFolha += "-" + ompt.getOmTppt().getCdTppt();
		return obtemPpCp(log, idLog, identacao, ompt, dwCalsems, msevt.getNrop(), cdProduto, cdFolha, msevt.getDthrEvento(), omcfg, msevt.getSegCiclopadrao());
	}


	public PpCp obtemPpCp(IdwLogger log, int idLog, int identacao, OmPt ompt, List<DwCalsem> dwCalsems, String nrop, String cdProduto, String cdFolha, Date dtHrEvt, OmCfg omcfg, BigDecimal segCiclopadrao){


		String cdCp = nrop;

		// se cdCp for null eh pq nao existe nrop no evento
		if (cdCp == null){
			cdCp = ConsolidaRN.NR_OP_DEFAULT;
		}

		// Se o cdCp for o default, buscar o Último cÃ³digo de Cp de DwRt
		if(cdCp.equals(ConsolidaRN.NR_OP_DEFAULT)){
			DwRt dwRt = obtemUltimoDwRt(ompt.getIdPt());
			if(dwRt != null && dwRt.getPpCp() != null){
				return dwRt.getPpCp();
			}
		}


		CpRN rncp = new CpRN(getDao());
		// Obtem 1o o Ompt a partir do ompt passado
		OmPt omptPesquisado = getDao().findById(OmPt.class, ompt.getIdPt(), false);
		OmCfg omcfgPesquisada = Util.getConfigGeral(getDao().getSession());


		PpCp ppCp = null;
		log.info(idLog, identacao, "Pesquisando nrDoc op [" + cdCp + "] para o pt [" + ompt.getCdPt() + "]");
		ppCp = rncp.pesquisarPpCpByNrDocCdPt(cdCp, ompt.getCdPt());

		if (ppCp == null) {
			log.info(idLog, identacao, "Não encontrou nrDoc. Pesquisando cdCp op [" + cdCp + "] para o pt [" + ompt.getCdPt() + "]");
			// Se for null procurar entao pelo NrDoc
			ppCp = rncp.pesquisarPpCpByCdCpCdPt(cdCp, ompt.getCdPt());
		}

		if (ppCp == null){

			// Alessandre: em 22-7-13 acrescentei o if abaixo para saber se a op esta vindo do concentrador do injet. Nessa caso, devemos importar a op
			// do injet antes de continuar. Se nao for do injet entao continua nos proximos passos
			log.info(idLog, identacao, "ppCp esta null vou incluir nova ppcp para " + cdCp + " para o pt " + ompt.getCdPt());
			// Alessandre em 25-05-22 acrescentei o teste para retornar null quando a configuracao geral ou do omtppt permitir a troca da OP
			// assim evita de criar nova op caso a op atual esteja sendo alterada  (desativando no processo).
			if ( (Stubdelegate.getInstancia().isInjetAtivo() == true && omptPesquisado.getOmTppt().isMaquinaCiclica()) ||
					(omcfg.getIsIhmtrocaop() != null && omcfg.getIsIhmtrocaop() && (ompt.getOmTppt().getIsIhmtrocaop() == null || ompt.getOmTppt().getIsIhmtrocaop() ) ) ||
					(ompt.getOmTppt().getIsIhmtrocaop() != null && ompt.getOmTppt().getIsIhmtrocaop())
					){
				// Integrar a ordem de producao vind ado injet
				ppCp = null; // vou retornar null para que nao se processe o evento

			} else  {
				// Alessandre: acrescentei esse caatch em 04-10-12 com o objetivo de cadastrar uma ppCp qdo ela nao for encontrada,
				// isso por causa da coleta do Insert que ainda não temos uma geracao de ppCp. Usarei o Nome do programa para o turno
				//
				DwFolha dwFolha = null;


				dwFolha = obtemDwFolha(omptPesquisado, nrop, cdProduto, cdFolha, omcfgPesquisada, segCiclopadrao);

				ppCp = new PpCp();
				ppCp.setIdCp(null);
				ppCp.setCdCp(cdCp);
				ppCp.setDthrInicio(DataHoraRN.getDataHoraAtual());
				ppCp.setDwFolha(dwFolha);
				ppCp.setDtRevisao(DataHoraRN.getDataHoraAtual());
				ppCp.setDtStativo(DataHoraRN.getDataHoraAtual());
				ppCp.setOmPt(omptPesquisado);
				ppCp.setOmGt(omptPesquisado.getOmGt());
				ppCp.setOmUsrByIdUsrrevisao(omcfgPesquisada.getOmUsrimpprog());
				ppCp.setOmUsrByIdUsrstativo(omcfgPesquisada.getOmUsrimpprog());
				ppCp.setRevisao(1l);
				ppCp.setStAtivo((byte) 1);
				/* Alessandre em 26-02-16 as duas linhas abaixo serve para remover a op criada do sistema SMED
				 * 
				 */
				ppCp.setDthrIsetup(DataHoraRN.getDataHoraAtual());
				ppCp.setDthrFsetup(ppCp.getDthrIsetup());
				
				
				ppCp.setStCp(PpCpTemplate.StCp.INICIADA.getValue()); // firmada
				ppCp.setTpCp(0); // tipo 0 = ordem de producao

				TurnoRN oTurnoRN = new TurnoRN(this.getDao());
				TurnoAtualDTO oTurnoAtualDTO = null;

				oTurnoAtualDTO = oTurnoRN.getTurnoAtualDTO(dwCalsems, dtHrEvt);

				ppCp.setDwCal(oTurnoAtualDTO.getDwcal());

				// Cadastra um plano generico se for necessario
				PpPlano ppplano = obtemPpPlano(omcfg);
				ppCp.setPpPlano(ppplano);

				ProdutoRN pRN = new ProdutoRN(getDao());
				OmProduto omproduto;
				omproduto = pRN.getProdutoByCdEStAtivo(cdProduto.trim());
				if (omproduto == null) {
					omproduto = new OmProduto();
					omproduto.setCdProduto(cdProduto.trim());
					omproduto.setDsProduto("Incluido automaticamente pelo obtem ppcp");
					omproduto.setDtRevisao(DataHoraRN.getDataHoraAtual());
					omproduto.setDtStativo(DataHoraRN.getDataHoraAtual());
					omproduto.setRevisao(1l);
					omproduto.setTpProduto((byte) 3); // Semiacabado
					omproduto.setTpProducao(BigDecimal.ZERO);
					omproduto.setStAtivo((byte) 1);
					omproduto.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
					omproduto.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
					omproduto.setIsRastreabilidade(true);
					getDao().makePersistent(omproduto);
				}

				Validate.validState(omproduto != null, " Produto não encontrado, ao gerar novo PpCp. " + "Verifique a mascara para produto iac, e se há¡ produto padrão na config geral");

				ppCp.setPpCpprodutos(new HashSet<PpCpproduto>());

				getDao().makePersistent(ppCp);

				// Cadastrar o PpCpProduto e ppcp
				FolhaRN fRN = new FolhaRN(getDao());
				List<OmProduto> listaProdutos = fRN.getProdutosFromDwFolha(dwFolha);
				if (listaProdutos == null || listaProdutos.size() <= 0) {
					listaProdutos = new ArrayList<>();
					if (omproduto != null)
						listaProdutos.add(omproduto);
				}

				for (OmProduto omprodutoAux : listaProdutos) {
					PpCpproduto ppcpproduto = new PpCpproduto();
					ppcpproduto.setPpCp(ppCp);
					ppcpproduto.setIdCpproduto(null);
					ppcpproduto.setOmProduto(omprodutoAux);
					ppcpproduto.setPcsProducaoplanejada(new BigDecimal(5000));
					ppcpproduto.setPpCpDatas(null);
					if (cdCp.length() > 40)
						ppcpproduto.setNrDoc(cdCp.substring(0, 40));
					else
						ppcpproduto.setNrDoc(cdCp);
	
					getDao().makePersistent(ppcpproduto);
				}
				
				// TODO milton inserir a quantidade de cavidades ativas para o produto
			}
		}
		// Alessandre em 02-10-15 verificar se o ppCp eh o mesmo em OmPt.ppCp. Se nao for atualizar ompt
		// ppcp em ompt foi criada para resolver o problema da op q entra no turno, sai e entra novamente, fazendo o dwrt ser encontraodo de forma errada
		if (omptPesquisado.getPpCp() == null || omptPesquisado.getPpCp().getIdCp().equals(ppCp.getIdCp()) == false ) {
			omptPesquisado.setPpCp(ppCp);
			log.info(idLog, identacao, "Alterando ompt.ppcp para " + ppCp.getIdCp());
			getDao().getSession().update(omptPesquisado);
		}

		return ppCp;
	}

	private PpPlano obtemPpPlano(OmCfg omcfg){
		PpPlano ppplano = null;

		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select ppplano from PpPlano ppplano");

		q.appendWhere(MapQuery._NULL, "ppplano.cdPlano = :cdplano", true);
		q.appendWhere(MapQuery._AND, "ppplano.stAtivo = 1", true);

		q.defineParametro("cdplano", "planogenerico");

		q.setMaxResults(1);

		ppplano = (PpPlano) q.uniqueResult();

		if (ppplano == null) {
			ppplano = new PpPlano();

			ppplano.setIdPlano(null);
			ppplano.setCdPlano("planogenerico");
			ppplano.setDsPlano("Plano criado pela coleta Insert");
			ppplano.setStAtivo(1);
			ppplano.setStPlano(1);
			ppplano.setRevisao(1);
			ppplano.setDtRevisao(DataHoraRN.getDataHoraAtual());
			ppplano.setDtStativo(DataHoraRN.getDataHoraAtual());
			ppplano.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			ppplano.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());

			q.novaConsulta();

			q.append("from PpTpplano");
			q.setMaxResults(1);

			PpTpplano ppTpplano = (PpTpplano) q.uniqueResult();

			ppplano.setPpTpplano(ppTpplano);

			this.getDao().makePersistent(ppplano);

		}

		return ppplano;
	}

	public DwConsolid obtemConsolIdTurno(IdwLogger log, int idLog, int identacao, PassagemDTO passagem, DwFolha oDwFolha) throws SemCalendarioException, SemSGBDException {


		// obtem a referencia do turno correspondente ao PT e hora do evento
		TurnoRN oTurnoRN = new TurnoRN(getDao());

		OmCfg omcfg = Util.getConfigGeral(this.getDao().getSession());

		OmPt ompt = getDao().findById(OmPt.class, passagem.getIdPt(), false);
		TurnoAtualDTO oTurnoAtualDTO = null;
		List<DwCalsem> dwCalsems = oTurnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(ompt, passagem.getDtHrEvento());
		
		oTurnoAtualDTO = oTurnoRN.getTurnoAtualDTO(dwCalsems, passagem.getDtHrEvento());

		if(oTurnoAtualDTO == null || oTurnoAtualDTO.getIdTurno() <= 0) {
			throw new SemCalendarioException();
		}

		// Nesse ponto devemos obter a OP caso ela nao exista definida no CB
		String cdProduto = obtemPrimeirProduto(oDwFolha).getCdProduto();
		StringBuilder cdCp = new StringBuilder();
		cdCp.append(DataHoraRN.dateToString(oTurnoAtualDTO.getDtReferencia(), "yyyy-mm-dd"));
		cdCp.append("/");
		cdCp.append(oTurnoAtualDTO.getCdTurno());
		cdCp.append("-");
		cdCp.append(cdProduto);

		PpCp ppcp = obtemPpCp(log, idLog, identacao, ompt, dwCalsems, cdCp.toString(), cdProduto, oDwFolha.getCdFolha(), passagem.getDtHrEvento(), omcfg, null); // null para o ciclo padrao. Como a folha existe nunca sera cadastrada uma nova

		// obtem o rt
		TempoRealRN trn = new TempoRealRN(getDao());
		DwRt oDwRt = null;
		oDwRt = trn.getDwRt(oTurnoAtualDTO.getDtReferencia(), oTurnoAtualDTO.getIdTurno(), passagem.getIdPt(), ppcp,  oDwFolha);

		// se nao encontrar registro algum
		if(oDwRt == null) {
			// inserir registro
			oDwRt = trn.insertDwRt(log, idLog, identacao, oTurnoAtualDTO, passagem, oDwFolha);
			oDwRt.setPpCp(ppcp);
			oDwRt.setIsSemplanejamento(false);
			getDao().makePersistent(oDwRt);
		}


		DwConsolid oDwConsolid = null;

		// obtem dwConsolId

		oDwConsolid = this.getConsolIdTurno(oTurnoAtualDTO.getDtReferencia(), oTurnoAtualDTO.getIdCal(), oTurnoAtualDTO.getIdTurno(), passagem.getIdPt(), oDwFolha.getIdFolha(), ppcp.getIdCp(), null);

		// se nao encontrar registro algum
		if (oDwConsolid == null) {
			// inserir registro
			try {
				oDwConsolid = this.insertDwConsolidTurno(oTurnoAtualDTO, passagem.getIdPt(), oDwFolha, oDwRt, ppcp, null);
			} catch (SemCicloPadraoException e) {
				// nao deve cair neste ponto, porque não terÃ¡ tratamento para o
				// ciclo padrão
				e.printStackTrace();
			}
		}

		return(oDwConsolid);
	}
	

	public void consolidarMaquinaOnOff(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, MsEvt msEvt, OmCfg omcfg, IdwLogger log, boolean isOnline, int idLog, int identacao) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {

		Validate.notNull(omPt, "Posto de trablaho esta nulo");
		Validate.notNull(omPt.getIdPt(), "idPt esta nulo");


		// Se a Cp nao existir, incluir uma nova isso foi feito por causa do insert
		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msEvt, omcfg);
		Validate.notNull(ppCp, "ppCp não pode ser nulo");
		ppCp.mudarDthrIniciorealIfNull(msEvt.getDthrEvento());
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"não tem folha ativa para o ppCp");
		
		DwPepro dwPepro = (msEvt == null ? null : msEvt.getDwPepro());
		
		// Pega ConsolId
		DwConsolid dwConsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, msEvt.getDthrEvento(), omcfg, dwPepro);

		DwRt dwRt = dwConsolid.getDwRt();

		if(dwRt != null){
			log.info(idLog, 0, "dwrt.isOffline = " + (isOnline ? false : true) + " para o pt "+ omPt.getCdPt()); 
			dwRt.setIsOffline(!isOnline);
			this.getDao().makePersistent(dwRt);
		}			
	}	

	public DwConsolid obtemConsolIdTurno(IdwLogger log, int idLog, int identacao, OmPt omPt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, Date dtHrRef, OmCfg omcfg, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException{
		Validate.notNull(omPt);
		Validate.notNull(ppCp);
		Validate.notNull(ppCp.getDwFolha());
		Validate.notNull(dtHrRef);

		// obtem a referencia do turno correspondente ao PT e hora do evento
		TurnoRN oTurnoRN = new TurnoRN(getDao());

		TurnoAtualDTO oTurnoAtualDTO = null;
		oTurnoAtualDTO = oTurnoRN.getTurnoAtualDTO(dwCalsems, dtHrRef);

		if(oTurnoAtualDTO == null || oTurnoAtualDTO.getIdTurno() <= 0) {
			throw new SemCalendarioException("Data-hora " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrRef) + " no pt " + omPt.getCdPt());
		}

		return obtemConsolIdTurno(log, idLog, identacao, omPt, ppCp, dwFolha, oTurnoAtualDTO, dwPepro);

	}

	/**
	 * Obtem o DwConsolid com base na hora, se não encontrar, inclui um novo registro
	 * @param omPt
	 * @param dwCalsems
	 * @param ppCp
	 * @param dtHrRef
	 * @param omcfg
	 * @return
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 * @see #obtemConsolIdHora(OmPt, PpCp, DwFolha, Date, TurnoAtualDTO)
	 */
	public DwConsolid obtemConsolIdHora(OmPt omPt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwFolha, Date dtHrRef, OmCfg omcfg, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		TurnoRN turnoRN = new TurnoRN(this.getDao());
		//TurnoAtualDTO turnoAtualDTO = turnoRN.obtemTurnoAtual(omPt.getIdPt(), dtHrRef, null, 0, 0, omcfg);
		TurnoAtualDTO turnoAtualDTO = turnoRN.getTurnoAtualDTO(dwCalsems, dtHrRef);
		return obtemConsolIdHora(omPt, ppCp, dwFolha, dtHrRef, turnoAtualDTO, dwPepro);
	}

	/**
	 * Obtem o DwConsolid com base na hora, se não encontrar, inclui um novo registro
	 * @param omPt
	 * @param ppCp
	 * @param dwFolha
	 * @param dtHrRef
	 * @param turnoAtualDTO
	 * @return
	 * @throws SemCalendarioException
	 * @throws SemSGBDException
	 */
	public DwConsolid obtemConsolIdHora(OmPt omPt, PpCp ppCp, DwFolha dwFolha, Date dtHrRef, TurnoAtualDTO turnoAtualDTO, DwPepro dwpepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		// obtem o consolid apenas do turno (hora acumulado e mes não serão implementados)

		Validate.notNull(omPt);
		Validate.notNull(ppCp);
		Validate.notNull(ppCp.getDwFolha());
		Validate.notNull(dtHrRef);

		PeriodoDTO periodoDTO = null;
		periodoDTO = obtemPeriodoDaHoraAtual(dtHrRef);

		DwConsolid dwConsolid = null;

		// obtem dwConsolId
		dwConsolid = this.getConsolIdHora(periodoDTO.getDtHrInicio(), omPt.getIdPt(), ppCp.getIdCp(), dwFolha.getIdFolha(), turnoAtualDTO, dwpepro);

		// se nao encontrar registro algum
		if(dwConsolid == null) {
			dwConsolid = this.insertDwConsolidHora(periodoDTO, omPt.getIdPt(), dwFolha, ppCp, turnoAtualDTO, dwpepro);
		}

		return(dwConsolid);
	}

	public DwConsolid obtemConsolIdAcumulado(OmPt omPt, PpCp ppCp, DwFolha dwfolha, TurnoAtualDTO turnoAtualDTO) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		// obtem o consolid apenas do turno (hora acumulado e mes não serão implementados)

		Validate.notNull(omPt);
		Validate.notNull(ppCp);
		Validate.notNull(dwfolha);
		DwConsolid dwConsolid = null;

		// obtem dwConsolId
		dwConsolid = this.getConsolIdAcumulado(omPt.getIdPt(), ppCp.getIdCp(), dwfolha.getIdFolha());
		

		// se nao encontrar registro algum
		if(dwConsolid == null) {
			dwConsolid = this.insertDwConsolidAcumulado(omPt.getIdPt(), ppCp, dwfolha, turnoAtualDTO);
		}

		return(dwConsolid);
	}
	
	public DwConsolid obtemConsolIdAcumulado(OmPt omPt, List<DwCalsem> dwCalsems, PpCp ppCp, DwFolha dwfolha, Date dtHrRef) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		// obtem a referencia do turno correspondente ao PT e hora do evento
		TurnoRN oTurnoRN = new TurnoRN(getDao());

		TurnoAtualDTO oTurnoAtualDTO = null;
		oTurnoAtualDTO = oTurnoRN.getTurnoAtualDTO(dwCalsems, dtHrRef);

		if(oTurnoAtualDTO == null || oTurnoAtualDTO.getIdTurno() <= 0) {
			throw new SemCalendarioException("Data-hora " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrRef) + " no pt " + omPt.getCdPt());
		}

		return obtemConsolIdAcumulado(omPt, ppCp, dwfolha, oTurnoAtualDTO);
	}
	private DwConsolid insertDwConsolidAcumulado(long idPt, PpCp ppcp, DwFolha dwfolha, TurnoAtualDTO turnoAtualDTO) throws SemCicloPadraoException {
		return(insertDwConsolid(
				DwConsolidTemplate.TpId.ACUMULADO, 
				null, //turnoAtualDTO.getDtReferencia(), 
				turnoAtualDTO.getIdTurno(),
				null, //turnoAtualDTO.getDtHrITurno(), 
				null, //turnoAtualDTO.getDtHrFTurno(), 
				turnoAtualDTO.getIdCal(), 
				null, //periodoDTO.getDtHrInicio(), 
				null, //periodoDTO.getDtHrFim(),
				null, //ano, 
				null, //mes, 
				idPt, 
				dwfolha, 
				null, 
				ppcp, 
				null)); //dwpepro));

	}

	private DwConsolid getConsolIdAcumulado(Long idPt, Long idCp, Long idfolha) {
		MapQuery q = new MapQuery(getDaoSession());

		q.append("SELECT dwconsolid ");
		q.append("FROM DwConsolid dwconsolid ");
		q.append("WHERE tpId = :tpId AND ");
		q.append("dwconsolid.omPt.idPt = :idPt ");
		q.append("and dwconsolid.stAtivo is null"); 
		q.append(" AND dwconsolid.ppCp.idCp = :idCp ");
		q.append("and dwconsolid.dwFolha.idFolha = :idfolha");

		q.defineParametro("tpId", DwConsolidTemplate.TpId.ACUMULADO.getValue());
		q.defineParametro("idPt", idPt);
		q.defineParametro("idCp", idCp);
		q.defineParametro("idfolha", idfolha);
		q.query().setMaxResults(1);

		DwConsolid oDwConsolid = null;
		oDwConsolid = (DwConsolid) q.query().uniqueResult();

		q = null;

		return(oDwConsolid);
	}

	public DwConsolid obtemConsolIdTurno(IdwLogger log, int idLog, int identacao, OmPt omPt, PpCp ppCp, DwFolha dwFolha, TurnoAtualDTO oTurnoAtualDTO, DwPepro dwPepro) throws SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		Validate.notNull(omPt);
		Validate.notNull(ppCp);
		Validate.notNull(ppCp.getDwFolha());

		// Abaixo eh que parou
		TempoRealRN trn = new TempoRealRN(getDao());
		
		DwRt dwRt = null;
		
		// Se o periodo produtivo for diferente de REGULAGEM entao pegar dw rt. Se for REGULAGEM nao podemos definir o dwrt para nao impactar no realtime
		if (dwPepro == null || (dwPepro != null && dwPepro.getIdPepro() != DwPeproTemplate.Type.REGULAGEM.getId()))
			dwRt = trn.obtemDwRt(log, idLog, identacao, oTurnoAtualDTO, omPt, ppCp, dwFolha);
		
		return obtemConsolIdTurno(log, idLog, omPt, ppCp, dwFolha, oTurnoAtualDTO, dwPepro, dwRt);
		
	}

	public DwConsolid obtemConsolIdTurno(IdwLogger log, int idLog, OmPt omPt, PpCp ppCp, DwFolha dwFolha, TurnoAtualDTO oTurnoAtualDTO, DwPepro dwPepro, DwRt dwRt) throws SemCicloPadraoException{
		// obtem o consolid apenas do turno (hora acumulado e mes não serão implementados)

		DwConsolid oDwConsolid = null;

		Long idCp = (ppCp != null? ppCp.getIdCp(): null);

		// obtem dwConsolId
		oDwConsolid = this.getConsolIdTurno(oTurnoAtualDTO.getDtReferencia(), oTurnoAtualDTO.getIdCal(), oTurnoAtualDTO.getIdTurno(), omPt.getIdPt(), dwFolha.getIdFolha(), idCp, dwPepro);

		// se nao encontrar registro algum
		if(oDwConsolid == null) {
			oDwConsolid = this.insertDwConsolidTurno(oTurnoAtualDTO, omPt.getIdPt() , dwFolha, dwRt, ppCp, dwPepro);
		}

		// Se o dwrt do dwConsolid for diferen do dwRt encontrado anteriormente, entao
		// Isso foi feito para a PST pois o dtreferencia do dwrt estava sendo modificado a cada evento
		// e os dados do turno estavam com divergencia entre o dwconsolid e o dwdw
		if (dwRt != null && oDwConsolid.getDwRt().getIdRt() != dwRt.getIdRt()){
			oDwConsolid.setDwRt(dwRt);
			getDao().makePersistent(oDwConsolid);
		}

		return(oDwConsolid);
	}

	/**
	 * Inclui DwConsolid para o turno
	 * @param oTurnoAtualDTO
	 * @param idPt
	 * @param dwFolha
	 * @param oDwRt
	 * @param ppcp
	 * @return
	 */
	private DwConsolid insertDwConsolidTurno(TurnoAtualDTO oTurnoAtualDTO, long idPt, DwFolha dwFolha, DwRt oDwRt, PpCp ppcp, DwPepro dwPepro) throws SemCicloPadraoException {
		int mes = DataHoraRN.getApenasMes(oTurnoAtualDTO.getDtReferencia());
		int ano = DataHoraRN.getApenasAno(oTurnoAtualDTO.getDtReferencia());
		return(insertDwConsolid( DwConsolidTemplate.TpId.TURNO, oTurnoAtualDTO.getDtReferencia(), oTurnoAtualDTO.getIdTurno(),
				oTurnoAtualDTO.getDtHrITurno(), oTurnoAtualDTO.getDtHrFTurno(), oTurnoAtualDTO.getIdCal(), null, null, ano, mes, idPt, dwFolha, oDwRt, ppcp, dwPepro));
	}

	/**
	 * Inclui DwConsolid para a hora
	 * @param periodoDTO
	 * @param idPt
	 * @param dwFolha
	 * @param ppcp
	 * @param turnoAtualDTO
	 * @param temCicloPadrao
	 * @return
	 */
	public DwConsolid insertDwConsolidHora(PeriodoDTO periodoDTO, long idPt, DwFolha dwFolha, PpCp ppcp, TurnoAtualDTO turnoAtualDTO, DwPepro dwpepro) throws SemCicloPadraoException {
		int mes = DataHoraRN.getApenasMes(turnoAtualDTO.getDtReferencia());
		int ano = DataHoraRN.getApenasAno(turnoAtualDTO.getDtReferencia());
		return(insertDwConsolid(DwConsolidTemplate.TpId.HORA, turnoAtualDTO.getDtReferencia(), turnoAtualDTO.getIdTurno(),
				turnoAtualDTO.getDtHrITurno(), turnoAtualDTO.getDtHrFTurno(), turnoAtualDTO.getIdCal(), periodoDTO.getDtHrInicio(), periodoDTO.getDtHrFim(),
				ano, mes, idPt, dwFolha, null, ppcp, dwpepro));

	}
	/**
	 * Inclui DwConsolid para o mês
	 * @param oTurnoAtualDTO
	 * @param idPt
	 * @param dwFolha
	 * @param ppcp
	 * @param temCicloPadrao se tem ciclo padrão
	 * @return
	 */
	public DwConsolid insertDwConsolidMes(TurnoAtualDTO oTurnoAtualDTO, long idPt, DwFolha dwFolha, PpCp ppcp, DwPepro dwpepro) throws SemCicloPadraoException {
		int mes = DataHoraRN.getApenasMes(oTurnoAtualDTO.getDtReferencia());
		int ano = DataHoraRN.getApenasAno(oTurnoAtualDTO.getDtReferencia());
		return(insertDwConsolid( DwConsolidTemplate.TpId.MES, oTurnoAtualDTO.getDtReferencia(), oTurnoAtualDTO.getIdTurno(),
				oTurnoAtualDTO.getDtHrITurno(), oTurnoAtualDTO.getDtHrFTurno(), oTurnoAtualDTO.getIdCal(), null, null, ano, mes, idPt, dwFolha, null, ppcp, dwpepro));
	}

	protected DwConsol insertDwConsol(DwConsolid dwConsolid){

		DwConsol dwConsol = new DwConsol();
		dwConsol.setDwConsolid(dwConsolid);
		BigDecimal tempoCalendario = new BigDecimal(0);

		//Atualiza tempo de calendÃ¡rio
		if(DwConsolidTemplate.TpId.TURNO.equals(dwConsolid.getTpId())){
			tempoCalendario = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dwConsolid.getDthrIturno(), dwConsolid.getDthrFturno());
		} else if(DwConsolidTemplate.TpId.HORA.equals(dwConsolid.getTpId())){
			tempoCalendario = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dwConsolid.getDthrIhora(), dwConsolid.getDthrFhora());
		}

		dwConsol.setSegAutoTempocalendario(tempoCalendario);
		dwConsol.setSegManuTempocalendario(BigDecimal.ZERO);

		// Guarda o ciclo padrão

		BigDecimal cicloPadrao;
		try {
			cicloPadrao = this.getCicloPadrao(dwConsolid.getOmPt(), dwConsolid.getDwFolha());
		} catch (SemCicloPadraoException e) {
			IdwLogger log = new IdwLogger(ConsolidaRN.class.getSimpleName()); 
			log.info("Ciclo não encontrado ao gerar dw_consol, assume 1 segundo", e);				
			cicloPadrao = BigDecimal.ONE;
		}
		dwConsol.setSegAutoCiclopadrao(cicloPadrao);
		
		DwFolha dwFolha = dwConsolid.getDwFolha();
		BigDecimal cavAtiva =  this.getCavAtivas(dwFolha);
		BigDecimal  cavTotal = this.getCavTotais(dwFolha);
		dwConsol.setQtAutoCavativas(cavAtiva);
		dwConsol.setQtAutoCavtotal(cavTotal);		
		
		// Inserir dwconsolpr
		dwConsol.setDwConsolprs(new HashSet<DwConsolpr>());
		PpCp ppcp = dwConsolid.getPpCp();
		if (ppcp != null) {
			if (dwConsolid.getPpCp().getPpCpprodutos() == null || dwConsolid.getPpCp().getPpCpprodutos().size() <= 0) {
				ppcp = getDao().findById(PpCp.class, ppcp.getIdCp(), false);
				ppcp.getPpCpprodutos();
			}
			for (PpCpproduto ppcpproduto : ppcp.getPpCpprodutos()){
				DwConsolpr dwconsolpr = new DwConsolpr();
				dwconsolpr.setDwConsol(dwConsol);
				dwconsolpr.setOmProduto(ppcpproduto.getOmProduto());

				// Se ja existir o produto na lista, nao incluir novamente
				boolean isExiste = false;
				for (DwConsolpr pr : dwConsol.getDwConsolprs()) {
					if (pr.getOmProduto().getIdProduto() == ppcpproduto.getOmProduto().getIdProduto())
						isExiste = true;

				}
				if (isExiste == false)
					dwConsol.getDwConsolprs().add(dwconsolpr);
			}
		}
		getDao().makePersistent(dwConsol);

		/* Milton
		 * Comentado pois faz a inclusão de DwConsolpr, se baseando no DwFolharap, mas estes dados jÃ¡ foram inseridos
		 * no trecho acima, que foi baseado nos produtos ligados a op
		 */
		//insertDwConsolpr(dwConsol);

		dwConsolid.getDwConsols().add(dwConsol);

		return dwConsol;
	}



	public DwConsolid getConsolIdTurno(Date dtReferencia, Long idCal, Long idTurno, Long idPt, Long idFolha, Long idCp, DwPepro dwpepro) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT dwconsolid ");
		q.append("FROM DwConsolid dwconsolid ");
		q.append("WHERE tpId = :tpId AND "); // (Maquina turno)
		q.append("dwconsolid.dtReferencia = :dtReferencia AND ");
		q.append("dwconsolid.dwCal.idCal = :idCal AND ");
		q.append("dwconsolid.dwTurno.idTurno = :idTurno AND ");
		q.append("dwconsolid.omPt.idPt = :idPt AND ");
		q.append("dwconsolid.dwFolha.idFolha = :idFolha ");
		if(idCp != null){
			q.append(" AND dwconsolid.ppCp.idCp = :idCp ");
		}
		if (dwpepro != null) {
			q.append("and dwconsolid.dwPepro.idPepro = :idpepro");
			if (dwpepro.getIdPepro() == DwPeproTemplate.Type.REGULAGEM.getId())
				q.append("and dwconsolid.stAtivo = 0");
		} else {
			q.append("and dwconsolid.stAtivo is null"); 
		}

		q.defineParametro("tpId", DwConsolidTemplate.TpId.TURNO.getValue());
		q.defineParametro("idPt", idPt);
		q.defineParametro("idFolha", idFolha);
		q.defineParametro("idCal", idCal);
		q.defineParametro("idTurno", idTurno);
		if (dwpepro != null)
			q.defineParametro("idpepro", dwpepro.getIdPepro());
		q.defineParametroData("dtReferencia", dtReferencia);
		if(idCp != null){
			q.defineParametro("idCp", idCp);
		}
		q.query().setMaxResults(1);

		DwConsolid oDwConsolid = null;
		oDwConsolid = (DwConsolid) q.query().uniqueResult();

		q = null;

		return(oDwConsolid);
	}

	public DwConsolid getConsolIdHora(Date dthrIhora, Long idPt, Long idCp, Long idFolha, TurnoAtualDTO turnoAtualDTO, DwPepro dwpepro) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT dwconsolid ");
		q.append("FROM DwConsolid dwconsolid ");
		q.append("WHERE tpId = :tpId AND ");
		q.append("dwconsolid.dthrIhora = :dthrIhora AND ");
		q.append("dwconsolid.dwTurno.idTurno = :idturno and");
		q.append("dwconsolid.omPt.idPt = :idPt ");
		if (dwpepro != null) {
			q.append("and dwconsolid.dwPepro.idPepro = :dwpepro");
			if (dwpepro.getIdPepro() == DwPeproTemplate.Type.REGULAGEM.getId())
				q.append("and dwconsolid.stAtivo = 0"); 
		} else {
			q.append("and dwconsolid.stAtivo is null"); 
		}

		if(idFolha != null){
			q.append(" AND dwconsolid.dwFolha.idFolha = :idFolha ");
		}

		if(idCp != null){
			q.append(" AND dwconsolid.ppCp.idCp = :idCp ");
		}

		q.defineParametro("idturno", turnoAtualDTO.getIdTurno());
		q.defineParametro("tpId", DwConsolidTemplate.TpId.HORA.getValue());
		q.defineParametro("idPt", idPt);
		if (dwpepro != null)
			q.defineParametro("dwpepro", dwpepro.getIdPepro());
		if(idCp != null){
			q.defineParametro("idCp", idCp);
		}
		if(idFolha != null){
			q.defineParametro("idFolha", idFolha);
		}

		q.defineParametroTimestamp("dthrIhora", dthrIhora);
		q.query().setMaxResults(1);

		DwConsolid oDwConsolid = null;
		oDwConsolid = (DwConsolid) q.query().uniqueResult();

		q = null;

		return(oDwConsolid);
	}

	public List<DwConsolid> getConsolIdHoraLista(Date dthrIhora, Long idPt, Long idCp, Long idFolha, TurnoAtualDTO turnoAtualDTO, DwPepro dwpepro) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT dwconsolid ");
		q.append("FROM DwConsolid dwconsolid ");
		q.append("WHERE tpId = :tpId AND ");
		q.append("dwconsolid.dthrIhora = :dthrIhora AND ");
		q.append("dwconsolid.dwTurno.idTurno = :idturno and");
		q.append("dwconsolid.omPt.idPt = :idPt ");
		if (dwpepro != null) {
			q.append("and dwconsolid.dwPepro.idPepro = :dwpepro");
			if (dwpepro.getIdPepro() == DwPeproTemplate.Type.REGULAGEM.getId())
				q.append("and dwconsolid.stAtivo = 0"); 
		} else {
			q.append("and dwconsolid.stAtivo is null"); 
		}

		if(idFolha != null){
			q.append(" AND dwconsolid.dwFolha.idFolha = :idFolha ");
		}

		if(idCp != null){
			q.append(" AND dwconsolid.ppCp.idCp = :idCp ");
		}

		q.defineParametro("idturno", turnoAtualDTO.getIdTurno());
		q.defineParametro("tpId", DwConsolidTemplate.TpId.HORA.getValue());
		q.defineParametro("idPt", idPt);
		if (dwpepro != null)
			q.defineParametro("dwpepro", dwpepro.getIdPepro());
		if(idCp != null){
			q.defineParametro("idCp", idCp);
		}
		if(idFolha != null){
			q.defineParametro("idFolha", idFolha);
		}

		q.defineParametroTimestamp("dthrIhora", dthrIhora);
		q.query().setMaxResults(1);

		List<DwConsolid> retorno = q.list();
		
		q = null;

		return retorno;
	}

	/**
	 * Pega Ãºltima parada da maquina 
	 * Inicialmente pega a Ãºltima parada do Último {@code DwRt}, caso não tenha, pesquisa direto em {@code DwConsolpalog} pegando a Ãºltima ocorrencia 
	 * @param omPt
	 * @return
	 */
	public DwConsolpalog getUltimaParadaFromDwConsolpalog(OmPt omPt){
		return  getUltimaParada(omPt, null);
	}
	
	
	public DwConsolrelog getUltimoRefugoFromDwConsolrelog(OmPt omPt, PpCp ppCp) {
		DwConsolrelog dwConsolrelog = null;

		if(dwConsolrelog == null){
			dwConsolrelog = getUltimoRefugo(omPt, ppCp);
		}
		return dwConsolrelog;
	}
	
	public DwConsolvaritmolog getUltimoVarRitmoFromDwConsolvaritmolog(OmPt omPt) {
		DwConsolvaritmolog dwConsolvaritmolog = null;

		dwConsolvaritmolog = getUltimoVarritmolog(omPt);
		
		return dwConsolvaritmolog;
	}
	
	public DwRtcic getUltimoCicloFechadoAntesDaDataFromDwRtCic(Date dthr, OmPt ompt, PpCp ppcp) {
		DwRtcic dwRtcic = null;
		TempoRealRN trn = new TempoRealRN(getDao());
		dwRtcic = trn.getUltimoDwRtcic(dthr, ompt, ppcp);
		
		return dwRtcic;
	}
	
	public DwPassagem getUltimoRefugoFromDwPassagem(OmPt omPt, PpCp ppCp) {
		DwPassagem dwPassagem = null;

		if(dwPassagem == null){
			dwPassagem = getUltimoRefugoPassagem(omPt, ppCp);
		}
		return dwPassagem;
	}

	public DwConsolpalog getUltimaParadaFromDwRt(OmPt omPt){
		TempoRealRN trn = new TempoRealRN(getDao());
		DwRt dwRt = trn.getUltimoDwRt(omPt.getIdPt());
		if(dwRt != null){
			return dwRt.getDwConsolpalog();
		}else{
			return null;
		}
	}

	public DwConsolpalog getUltimaParada(OmPt omPt, Date dtHrRef){
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT dwConsolpalog ");
		q.append("FROM DwConsolpalog dwConsolpalog ");
		q.append("left join fetch dwConsolpalog.dwTParada dwtparada");
		q.append("where dwConsolpalog.omPt.idPt = :idPt ");
		if(dtHrRef != null){
			q.append("AND (dwConsolpalog.dthrIparada <= :dtHrRef OR dwConsolpalog.dthrFparada <= :dtHrRef OR dwConsolpalog.dthrFparadaAb <= :dtHrRef)");
		}
		q.append("ORDER BY dwConsolpalog.idConsolpalog DESC");

		q.defineParametro("idPt", omPt.getIdPt());
		if(dtHrRef != null){
			q.defineParametroTimestamp("dtHrRef" , dtHrRef);
		}

		q.setMaxResults(1);

		DwConsolpalog dwConsolpalog = (DwConsolpalog) q.query().uniqueResult();

		return dwConsolpalog;

	}

	
	public static void main(String[] args) {
		ConsolidaRN rn = new ConsolidaRN();
		rn.iniciaConexaoBanco();
		TurnoRN trn = new TurnoRN(rn.getDao());
		PTRN prn = new PTRN(rn.getDao());
		OmPt ompt = null;
		try {
			ompt = prn.getOmPt("000004");
		} catch (RegistroDesconhecidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TurnoAtualDTO atual = null;
		try {
			atual = trn.getTurnoAtualDTOSemClone(ompt, DataHoraRN.getDataHora(2017, 5, 14, 0, 30, 22, 693));
		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TurnoAtualDTO anterior;
		try {
			anterior = trn.getTurnoAnteriorDTOPassandoIdPtEDtTurnoEIdTurno(ompt, atual.getDtReferencia(), atual.getDwturno().getIdTurno(), atual);
			System.out.println("Turno Atual = " + atual.toString());
			System.out.println("Turno anterior = " + anterior.toString());
			
		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rn.getUltimoRefugo(ompt, ompt.getPpCp());
		
		rn.finalizaConexaoBanco();

	}

	public DwConsolrelog getUltimoRefugo(OmPt omPt, PpCp ppCp) {
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("SELECT distinct dwConsolrelog ");
		q.append("FROM DwConsolrelog dwConsolrelog ");
		q.append("left join fetch dwConsolrelog.omPt omPt");
		q.append("left join fetch dwConsolrelog.dwTRefugo dwTRefugo");
		q.append("left join fetch dwConsolrelog.dwTAcao dwTAcao");
		q.append("left join fetch dwConsolrelog.dwTCausa dwTCausa");
		q.append("left join fetch dwConsolrelog.dwConsolreocos dwConsolreocos");
		q.append("left join fetch dwConsolreocos.dwConsolre dwConsolre");
		q.append("left join fetch dwConsolre.dwConsol dwConsol");
		q.append("left join fetch dwConsol.dwConsolid dwConsolid");
		q.append("left join fetch dwConsolid.ppCp ppCp");
		q.append("where omPt.idPt = :idPt ");
		q.append("and dwTRefugo.idTrefugo != :idTrefugo");
		q.append("and ppCp.idCp = :idCp");
		// Alessandre em 20-10-17 comentei a linha abaixo e substitui pela seguinte
		// pois qdo o apontamento manual de refugo via tm cria novo refugo tambem entra em dwconsolrelog
		// e se o coletor for reiniciado vai pegar ele
		//q.append("ORDER BY dwConsolrelog.idConsolrelog DESC");
		q.append("ORDER BY dwConsolrelog.dthrRefugo DESC");

		q.defineParametro("idPt", omPt.getIdPt());
		if (ppCp != null)
			q.defineParametro("idCp", ppCp.getIdCp());
		else
			return null;
					
		q.defineParametro("idTrefugo", Util.getConfigGeral(this.getDaoSession()).getDwTRefugo().getIdTrefugo());

		q.setMaxResults(1);

		DwConsolrelog dwConsolrelog = (DwConsolrelog) q.query().uniqueResult();

		return dwConsolrelog;
	}
	
	public DwConsolvaritmolog getUltimoVarritmolog(OmPt omPt) {
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("SELECT distinct dwConsolvaritmolog ");
		q.append("FROM DwConsolvaritmolog dwConsolvaritmolog ");
		q.append("left join fetch dwConsolvaritmolog.omPt omPt");
		q.append("where dwConsolvaritmolog.omPt.idPt = :idPt ");
		//q.append("and dwConsolvaritmolog.dthrFvaritmo is NULL");
		q.append("ORDER BY dwConsolvaritmolog.dthrIvaritmo DESC");

		q.defineParametro("idPt", omPt.getIdPt());

		q.setMaxResults(1);

		DwConsolvaritmolog dwConsolvaritmolog = (DwConsolvaritmolog) q.query().uniqueResult();
		
		return dwConsolvaritmolog;
	}
	
	public DwPassagem getUltimoRefugoPassagem(OmPt omPt, PpCp ppCp) {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT dwPassagem ");
		q.append("FROM DwPassagem dwPassagem ");
		q.append("left join fetch dwPassagem.dwNserie dwNserie");
		q.append("left join fetch dwPassagem.dwConsolid dwConsolid");
		q.append("left join fetch dwPassagem.dwEst dwEst");
		q.append("left join fetch dwPassagem.omPt omPt");
		q.append("left join fetch dwConsolid.ppCp ppCp");
		q.append("where omPt.idPt = :idPt ");
		q.append("AND ppCp.idCp = :idCp");
		q.append("AND dwEst.idEst = 4");
		q.append("ORDER BY dwPassagem.dthr DESC");

		q.defineParametro("idPt", omPt.getIdPt());
		q.defineParametro("idCp", ppCp.getIdCp());

		q.setMaxResults(1);

		DwPassagem dwPassagem = (DwPassagem) q.query().uniqueResult();
		
		return dwPassagem;
	}

	public DwRtcic getUltimoCiclo(OmPt omPt, DwRt dwRt, Date dtHrRef){

		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("SELECT dwrtcic ");
		q.append("FROM DwRtcic dwrtcic ");
		q.append("left join dwrtcic.dwRt dwrt ");
		q.append("where dwrt.omPt.idPt = :idPt ");

		if(dwRt != null){
			q.append("and dwrt.idRt = :idRt");
		}

		if(dtHrRef != null){
			q.append("and dwrtcic.dthrFciclo <= :dthrFciclo");
		}

		q.append("ORDER BY dwrtcic.idRtcic DESC");

		q.defineParametro("idPt", omPt.getIdPt());

		if(dwRt != null){
			q.defineParametro("idRt", dwRt.getIdRt());
		}

		if(dtHrRef != null){
			q.defineParametroTimestamp("dthrFciclo", dtHrRef);
		}
		q.setMaxResults(1);

		DwRtcic dwRtcic = (DwRtcic) q.query().uniqueResult();

		return(dwRtcic);

	}


	public DwConsolid getUltimoDwConsolidTurnoByCdUp(String cdUp) {
		PTRN ptrn = new PTRN(getDao());
		OmPt ompt = ptrn.pesquisarPtByCdPtStAtivo(cdUp);
		return getUltimoDwConsolidTurno(ompt.getIdPt());
	}

	public DwConsolid getUltimoDwConsolidTurno(Long idPt) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT dwconsolid ");
		q.append("FROM DwConsolid dwconsolid ");
		q.append("where dwconsolid.omPt.idPt = :idPt ");
		q.append("and dwconsolid.tpId = 1 and dwconsolid.stAtivo is null ");
		q.append("ORDER BY dwconsolid.idConsolid DESC");

		q.defineParametro("idPt", idPt);
		q.setMaxResults(1);

		DwConsolid dwconsolid = null;
		dwconsolid = (DwConsolid) q.query().uniqueResult();
		q = null;
		return(dwconsolid);
	}
	
	public DwConsolid getUltimoDwConsolid(List<DwConsolid> lista) {
		if(lista == null || lista.isEmpty()) {
			return null;
		}
		
		List<DwConsolid> listaLocal = new ArrayList<DwConsolid>();
		listaLocal.addAll(lista);
		
		Collections.sort(listaLocal, new Comparator<DwConsolid>() {
			@Override
			public int compare(final DwConsolid o1, final DwConsolid o2) {
				
				return new CompareToBuilder()
						.append(o1.getDthrFconsol(), o2.getDthrFconsol())
						.append(o1.getIdConsolid(), o2.getIdConsolid())
						.toComparison() * -1;
			
			}
		});
		
		return listaLocal.get(0);
	}
	
	public DwConsolid getUltimoDwConsolidTurnoDwRtPpCp(Long idpt) {
		DwRt dwrt = obtemUltimoDwRt(idpt);
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwConsolid a");
		q.append("where a.dwRt = :dwrt");
		q.append("and a.omPt.idPt = :idpt");
		q.append("and a.tpId = 1");
		q.append("order by a.idConsolid desc");
		
		q.defineParametro("dwrt", dwrt);
		q.defineParametro("idpt", idpt);
		q.setMaxResults(1);
		
		return (DwConsolid) q.uniqueResult();
	}

	public DwConsolid pesquisarDwConsolid(Date dtReferencia, Long idTurno, Long idPt, DwFolha dwfolha){
		OmPt ompt = new OmPt();
		ompt.setIdPt(idPt);
		return pesquisarDwConsolid(dtReferencia, idTurno, ompt, null, dwfolha);
	}

	public List<DwConsolid> pesquisarDwConsolid(Date dtReferencia, String cdTurno, DwFolha dwfolha){
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select dwconsolid");
		q.append("from DwConsolid dwconsolid");
		q.append("join dwconsolid.dwFolha dwfolha");
		q.append("where dwconsolid.dtReferencia = :dtreferencia");
		q.append("and dwconsolid.dwTurno.cdTurno = :cdturno");
		q.append("and dwconsolid.stAtivo is null");
		q.append("and dwconsolid.tpId = 1");
		q.append("and dwfolha.cdFolha = :dwfolha");

		q.defineParametroData("dtreferencia", dtReferencia);
		q.defineParametro("cdturno", cdTurno);
		q.defineParametro("dwfolha", dwfolha.getCdFolha());

		return q.list();
	}

	public DwConsolid pesquisarDwConsolid(Date dtReferencia, Long idTurno, OmPt ompt, OmGt omgt, DwFolha dwfolha){
		MapQuery q = new MapQuery(getDao().getSession());

		q.append("select dwconsolid");
		q.append("from DwConsolid dwconsolid");
		q.append("join dwconsolid.dwTurno dwturno");
		q.append("left join dwconsolid.omPt ompt");
		q.append("left join dwconsolid.omGt omgt");
		q.append("join dwconsolid.dwFolha folha");
		q.append("where dwconsolid.dtReferencia = :dtReferencia");
		q.append("and dwturno.idTurno = :dwturno");
		q.append("and folha.idFolha = :dwfolha");
		if (omgt != null){
			q.append("and omgt.idGt = :omgt");
			q.defineParametro("omgt", omgt.getIdGt());
		}

		if (ompt != null){
			q.append("and ompt.idPt = :ompt");
			q.defineParametro("ompt", ompt.getIdPt());
		}

		q.defineParametroData("dtReferencia", dtReferencia);
		q.defineParametro("dwturno", idTurno);
		q.defineParametro("dwfolha", dwfolha.getIdFolha());

		q.setMaxResults(1);

		return (DwConsolid) q.uniqueResult();
	}

	public List<DwConsolid> pesquisarDwConsolid(Date dtReferencia, Long idTurno, OmPt ompt, Date dthr){
		MapQuery q = new MapQuery(getDao().getSession());

		q.append("select dwconsolid");
		q.append("from DwConsolid dwconsolid");
		q.append("join dwconsolid.dwTurno dwturno");
		q.append("left join dwconsolid.omPt ompt");
		q.append("where dwconsolid.dtReferencia = :dtReferencia");
		q.append("and dwturno.idTurno = :dwturno");
		q.append("and dwconsolid.tpId = 1");
		q.append("and (dwconsolid.dthrIconsol >= :dthr or :dthr between dwconsolid.dthrIconsol and dwconsolid.dthrFconsol)");

		if (ompt != null){
			q.append("and ompt.idPt = :ompt");
			q.defineParametro("ompt", ompt.getIdPt());
		}

		q.defineParametroData("dtReferencia", dtReferencia);
		q.defineParametro("dwturno", idTurno);
		q.defineParametroTimestamp("dthr", dthr);


		return q.list();
	}


	public List<DwConsolid> pesquisarDwConsolidByHora(Date dthri, Date dthrf, OmPt ompt, Date dthr){
		MapQuery q = new MapQuery(getDao().getSession());

		q.append("select dwconsolid");
		q.append("from DwConsolid dwconsolid");
		q.append("join dwconsolid.dwTurno dwturno");
		q.append("left join dwconsolid.omPt ompt");
		q.append("where dwconsolid.dthrIhora = :dthr");
		q.append("and dwconsolid.tpId = 0");
		q.append("and (dwconsolid.dthrIconsol >= :dthr or :dthr between dwconsolid.dthrIconsol and dwconsolid.dthrFconsol)");

		if (ompt != null){
			q.append("and ompt.idPt = :ompt");
			q.defineParametro("ompt", ompt.getIdPt());
		}

		q.defineParametroData("dthr", dthri);


		return q.list();
	}

	/* Esse metodo é usado para a correcao da producao bruta ou refugada hora a hora
	 * 
	 */
	public DwConsolidDTOs pesquisarDwConsolidByHoraApontamentoManualRefugo(Date dtReferencia, DwTurno dwturno, OmPt ompt, PpCp ppcp, 
																		   String cdProduto, DwPepro dwpepro, DwFolha dwfolha, DwCal dwcal){
		
		MapQuery q = new MapQuery(getDao().getSession());

		q.append("select distinct dwconsolid");
		q.append("from DwConsolid dwconsolid");
		q.append("join fetch dwconsolid.dwTurno dwturno");
		q.append("join fetch dwconsolid.omPt ompt");
		q.append("join fetch dwconsolid.dwConsols dwconsol");
		q.append("join fetch dwconsol.dwConsolprs dwconsolpr");
		q.append("left join fetch dwconsol.dwConsolres dwconsolre");
		q.append("left join fetch dwconsolre.dwConsolreocos dwconsolreoco");
		q.append("left join fetch dwconsolreoco.dwConsolrelog dwconsolrelog");
		q.append("join fetch dwconsolid.ppCp ppcp");
		q.append("join fetch ppcp.ppCpprodutos ppcpproduto");
		q.append("where dwconsolid.dtReferencia = :dt");
		q.append("and dwconsolid.tpId = 0");
		q.append("and dwconsolid.dwTurno = :dwturno");
		q.append("and dwconsolid.omPt = :ompt");
		q.append("and dwconsolid.ppCp = :ppcp");
		q.append("and dwconsolpr.omProduto.cdProduto = :cdproduto");
		q.append("and dwconsolid.dwPepro = :dwpepro");
		q.append("and dwconsolid.dwFolha = :dwfolha");
		q.append("and dwconsolid.dwCal = :dwcal");

		q.defineParametro("ompt", ompt);
		q.defineParametroData("dt", dtReferencia);
		q.defineParametro("dwturno", dwturno);
		q.defineParametro("ppcp", ppcp);
		q.defineParametro("cdproduto", cdProduto);
		q.defineParametro("dwpepro", dwpepro);
		q.defineParametro("dwfolha", dwfolha);
		q.defineParametro("dwcal", dwcal);
		
		List<DwConsolid> ids = q.list();
		
		DwConsolidDTOs retorno = new DwConsolidDTOs();
		
		retorno.setListaDwConsolidDTO(new ArrayList<DwConsolidDTO>());
		/*
		int contHoras = 0;
		int contDwConsolre = 0;
		int contDwConsolresocos = 0;
		int contProdutos = 0;
		
		PrintStream out;
		
		try {
			out = new PrintStream(new File("c://temp//LogPesquisa.txt"));
			System.setOut(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		for (DwConsolid id : ids) {
			
			DwConsolidDTO dto = new DwConsolidDTO();
			
			dto.setDwConsolid(id.clone());
			dto.getDwConsolid().getOmPt().setOmTppt(id.getOmPt().getOmTppt().clone(false));;
			
			// Clonar dwconsolpr
			DwConsol dwconsolClone = id.getDwConsol().clone(false);
			DwConsolpr dwconsolprClone = null;
			for (DwConsolpr dwconsolpr : id.getDwConsol().getDwConsolprs()) {
				//DwConsolpr dwconsolprClone = dwconsolpr.clone();
				dwconsolprClone = dwconsolpr.clone();
				dwconsolClone.getDwConsolprs().add(dwconsolprClone);
			}
			
			dto.getDwConsolid().setDwConsols(new HashSet<DwConsol>());
			dto.getDwConsolid().getDwConsols().add(dwconsolClone);
			
			// Clonar ppcp
			PpCp ppcpClone = id.getPpCp().clone();
			
			for (PpCpproduto ppcpproduto : id.getPpCp().getPpCpprodutos()) {
				PpCpproduto ppcpprodutoClone = ppcpproduto.clone();
				ppcpClone.getPpCpprodutos().add(ppcpprodutoClone);
			}
			
			dto.getDwConsolid().setPpCp(ppcpClone);
			
			// Clonar motivos de refugo
			for (DwConsolre dwconsolre : id.getDwConsol().getDwConsolres()) {
				
				DwConsolre dwconsolreClone = dwconsolre.clone();
				// Contar a producao refugada em dwconsolrelog (que esta filtrada pelo produto solicitado) ao inves de usar a producao de dwconsolre que tem de todos os produtos
				BigDecimal producaoRefugadaAuto = BigDecimal.ZERO;
				BigDecimal producaoRefugadaManu = BigDecimal.ZERO;
				
				//contDwConsolresocos = 0;

				for (DwConsolreoco oco : dwconsolre.getDwConsolreocos()) {
					// Pegar apenas do produto avaliado
					if (oco.getDwConsolrelog().getOmProduto().getCdProduto().equals(cdProduto)) {
						
						DwConsolreoco ocoClone = oco.clone(false);
						ocoClone.setDwConsolrelog(oco.getDwConsolrelog().clone());
						dwconsolreClone.getDwConsolreocos().add(ocoClone);

						if (oco.getDwConsolrelog().getPcsAutoProducaorefugada() != null)
							producaoRefugadaAuto = producaoRefugadaAuto.add(oco.getDwConsolrelog().getPcsAutoProducaorefugada());
						if (oco.getDwConsolrelog().getPcsManuProducaorefugada() != null)
							producaoRefugadaManu = producaoRefugadaManu.add(oco.getDwConsolrelog().getPcsManuProducaorefugada());
						
					}/*else {
						
						System.out.println("-----------------------------------------------------------  PRODUTOS DIFERENTES ---------------------------------------------------------------------------------------------");
						System.out.println("cdProduto                                           :" + cdProduto);
						System.out.println("oco.getDwConsolrelog().getOmProduto().getCdProduto():" + oco.getDwConsolrelog().getOmProduto().getCdProduto());
						System.out.println("-----------------------------------------------------------  PRODUTOS DIFERENTES ---------------------------------------------------------------------------------------------");
						
					}
					
					//if (dwconsolreClone.getIdConsolre() == 146829) {
					System.out.println("******************************************************************************************************************************************************************************");
					//}
					 */
				}
				
				dwconsolreClone.setPcsAutoProducaorefugada(producaoRefugadaAuto);
				dwconsolreClone.setPcsManuProducaorefugada(producaoRefugadaManu);
				/*
				//if (dwconsolreClone.getIdConsolre() == 146829) {
				System.out.println("dwconsolreClone.getPcsAutoProducaorefugada()        :" + dwconsolreClone.getPcsAutoProducaorefugada());
				System.out.println("dwconsolreClone.getPcsManuProducaorefugada()        :" + dwconsolreClone.getPcsManuProducaorefugada());
				//}
				*/
				// Se tiver producao refugada entao retornar. Se nao nao retorna para evitar que apareca o motivo do refugo com valor zero
				if ( (producaoRefugadaAuto != null && producaoRefugadaAuto.equals(BigDecimal.ZERO) == false ) || 
					 (producaoRefugadaManu != null && producaoRefugadaManu.equals(BigDecimal.ZERO) == false ) ) {

					dwconsolClone.getDwConsolres().add(dwconsolreClone);
					
				}/*else{
					System.out.println("..............................................................................................................................................................................");
					System.out.println("NOT ADD dwconsolClone.getDwConsolres().add(dwconsolreClone)");
					System.out.println("..............................................................................................................................................................................");
				}
				
				//if (dwconsolreClone.getIdConsolre() == 146829) {
				System.out.println("==============================================================================================================================================================================");
				System.out.println("");
				//}
				*/
			}
			
			retorno.getListaDwConsolidDTO().add(dto);
		}
		
		return retorno;
	
	}
	
	/* Esse metodo é usado para a correcao da producao bruta ou refugada hora a hora. Porém com um ajuste para diferença de refugo (SONY)
	 * 
	 */
	public DwConsolidDTOs pesquisarDwConsolidByHoraApontamentoManualRefugo_SONY(Date dtReferencia, DwTurno dwturno, OmPt ompt, PpCp ppcp, 
																		   		String cdProduto, DwPepro dwpepro, DwFolha dwfolha, DwCal dwcal) {
		
		MapQuery q = new MapQuery(getDao().getSession());

		q.append("select distinct dwconsolid");
		q.append("from DwConsolid dwconsolid");
		q.append("join fetch dwconsolid.dwTurno dwturno");
		q.append("join fetch dwconsolid.omPt ompt");
		q.append("join fetch dwconsolid.dwConsols dwconsol");
		q.append("join fetch dwconsol.dwConsolprs dwconsolpr");
		q.append("left join fetch dwconsol.dwConsolres dwconsolre");
		q.append("left join fetch dwconsolre.dwConsolreocos dwconsolreoco");
		q.append("left join fetch dwconsolreoco.dwConsolrelog dwconsolrelog");
		q.append("join fetch dwconsolid.ppCp ppcp");
		q.append("join fetch ppcp.ppCpprodutos ppcpproduto");
		q.append("where dwconsolid.dtReferencia = :dt");
		q.append("and dwconsolid.tpId = 0");
		q.append("and dwconsolid.dwTurno = :dwturno");
		q.append("and dwconsolid.omPt = :ompt");
		q.append("and dwconsolid.ppCp = :ppcp");
		q.append("and dwconsolpr.omProduto.cdProduto = :cdproduto");
		q.append("and dwconsolid.dwPepro = :dwpepro");
		q.append("and dwconsolid.dwFolha = :dwfolha");
		q.append("and dwconsolid.dwCal = :dwcal");

		q.defineParametro("ompt", ompt);
		q.defineParametroData("dt", dtReferencia);
		q.defineParametro("dwturno", dwturno);
		q.defineParametro("ppcp", ppcp);
		q.defineParametro("cdproduto", cdProduto);
		q.defineParametro("dwpepro", dwpepro);
		q.defineParametro("dwfolha", dwfolha);
		q.defineParametro("dwcal", dwcal);
		
		List<DwConsolid> ids = q.list();
		
		DwConsolidDTOs retorno = new DwConsolidDTOs();
		
		retorno.setListaDwConsolidDTO(new ArrayList<DwConsolidDTO>()); 
		
		int contHoras = 0;
		int contDwConsolre = 0;
		int contDwConsolresocos = 0;
		int contProdutos = 0;
		
		PrintStream out;
		
		try {
			out = new PrintStream(new File("c://temp//LogPesquisa.txt"));
			System.setOut(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (DwConsolid id : ids) { //cada registro aqui é uma linha da grade de hora
			
			DwConsolidDTO dto = new DwConsolidDTO();
			
			dto.setDwConsolid(id.clone());
			dto.getDwConsolid().getOmPt().setOmTppt(id.getOmPt().getOmTppt().clone(false));;
			
			// Clonar dwconsolpr
			DwConsol dwconsolClone = id.getDwConsol().clone(false);
			DwConsolpr dwconsolprClone = null;
			
			for (DwConsolpr dwconsolpr : id.getDwConsol().getDwConsolprs()) {
				dwconsolprClone = dwconsolpr.clone();
				dwconsolClone.getDwConsolprs().add(dwconsolprClone);
			}
			
			//INI: Ajustes de diferença entre Produção Refugada Hora e Produção Refugada Hora Detalhe - Obter produção refugada hora
            //Obter produção refugada hora para comparar com total detalhes
            BigDecimal producaoRefugadaHora = BigDecimal.ZERO;

			if (dwconsolprClone.getPcsAutoProducaorefugada() != null)
                producaoRefugadaHora = dwconsolprClone.getPcsAutoProducaorefugada();
            if (dwconsolprClone.getPcsManuProducaorefugada() != null)
                producaoRefugadaHora = producaoRefugadaHora.add(dwconsolprClone.getPcsManuProducaorefugada());
			//FIM: Ajustes de diferença entre Produção Refugada Hora e Produção Refugada Hora Detalhe - Obter produção refugada hora
            
			dto.getDwConsolid().setDwConsols(new HashSet<DwConsol>());
			dto.getDwConsolid().getDwConsols().add(dwconsolClone);
			
			// Clonar ppcp
			PpCp ppcpClone = id.getPpCp().clone();
			
			for (PpCpproduto ppcpproduto : id.getPpCp().getPpCpprodutos()) {
				PpCpproduto ppcpprodutoClone = ppcpproduto.clone();
				ppcpClone.getPpCpprodutos().add(ppcpprodutoClone);
			}
			
			dto.getDwConsolid().setPpCp(ppcpClone);
			
            BigDecimal producaoRefugadaDetalhe = BigDecimal.ZERO;
            
            DwConsolre dwconsolreClone = null;
            
			contHoras++; 
			
			contDwConsolre = 0;
			
			// Clonar motivos de refugo
			for (DwConsolre dwconsolre : id.getDwConsol().getDwConsolres()) {
			
				dwconsolreClone = dwconsolre.clone();
				
				// Contar a producao refugada em dwconsolrelog (que esta filtrada pelo produto solicitado) ao inves de usar a producao de dwconsolre que tem de todos os produtos
				BigDecimal producaoRefugadaAuto = BigDecimal.ZERO;
				BigDecimal producaoRefugadaManu = BigDecimal.ZERO;

				for (DwConsolreoco oco : dwconsolre.getDwConsolreocos()) {
					
					contDwConsolresocos++;
					
					//if (dwconsolreClone.getIdConsolre() == 146829) {
					System.out.println("contDwConsolresocos                                 :" + StringUtils.leftPad(String.valueOf(contDwConsolresocos),2,"0"));
					System.out.println("dwconsolreClone.getIdConsolre()                     :" + dwconsolreClone.getIdConsolre());
					//System.out.println("oco.getDwConsolrelog().getDwTRefugo()               :" + oco.getDwConsolrelog().getDwTRefugo().getCdTrefugo() + " - " + oco.getDwConsolrelog().getDwTRefugo().getDsTrefugo());				
					System.out.println("oco.getDwConsolrelog().getPcsAutoProducaorefugada() :" + oco.getDwConsolrelog().getPcsAutoProducaorefugada());
					System.out.println("oco.getDwConsolrelog().getPcsManuProducaorefugada() :" + oco.getDwConsolrelog().getPcsManuProducaorefugada());
					//}
					
					// Pegar apenas do produto avaliado
					if (oco.getDwConsolrelog().getOmProduto().getCdProduto().equals(cdProduto)) {
						
						DwConsolreoco ocoClone = oco.clone(false);
						ocoClone.setDwConsolrelog(oco.getDwConsolrelog().clone());
						dwconsolreClone.getDwConsolreocos().add(ocoClone);
						
						if (oco.getDwConsolrelog().getPcsAutoProducaorefugada() != null)
							producaoRefugadaAuto = producaoRefugadaAuto.add(oco.getDwConsolrelog().getPcsAutoProducaorefugada());
						if (oco.getDwConsolrelog().getPcsManuProducaorefugada() != null)
							producaoRefugadaManu = producaoRefugadaManu.add(oco.getDwConsolrelog().getPcsManuProducaorefugada());
					
					}
				
				}
				
				dwconsolreClone.setPcsAutoProducaorefugada(producaoRefugadaAuto);
				dwconsolreClone.setPcsManuProducaorefugada(producaoRefugadaManu);

				//if (dwconsolreClone.getIdConsolre() == 146829) {
				System.out.println("dwconsolreClone.getPcsAutoProducaorefugada()        :" + dwconsolreClone.getPcsAutoProducaorefugada());
				System.out.println("dwconsolreClone.getPcsManuProducaorefugada()        :" + dwconsolreClone.getPcsManuProducaorefugada());
				//}
					
				// Se tiver producao refugada entao retornar. Se nao nao retorna para evitar que apareca o motivo do refugo com valor zero
				if ( (producaoRefugadaAuto != null && producaoRefugadaAuto.equals(BigDecimal.ZERO) == false ) || 
					 (producaoRefugadaManu != null && producaoRefugadaManu.equals(BigDecimal.ZERO) == false ) ) {
					
					dwconsolClone.getDwConsolres().add(dwconsolreClone);
					
					//INI: Ajustes de diferença entre Produção Refugada Hora e Produção Refugada Hora Detalhe - Obter produção refugada hora
	                BigDecimal producaoRefugadaDetalheAux = BigDecimal.ZERO;

	                if (producaoRefugadaAuto != null)
	                    producaoRefugadaDetalheAux = producaoRefugadaAuto;
	                if (producaoRefugadaManu != null)
	                    producaoRefugadaDetalheAux = producaoRefugadaDetalheAux.add(producaoRefugadaManu);

	                producaoRefugadaDetalhe = producaoRefugadaDetalhe.add(producaoRefugadaDetalheAux);
		            //FIM: Ajustes de diferença entre Produção Refugada Hora e Produção Refugada Hora Detalhe - Obter produção refugada hora
				
				}
			
			}
			
			//INI: Ajustes de diferença entre Produção Refugada Hora e Produção Refugada Hora Detalhe - Obter produção refugada hora
			BigDecimal producaoRefugadaAjuste = BigDecimal.ZERO;			
            
			producaoRefugadaAjuste = producaoRefugadaHora.subtract(producaoRefugadaDetalhe);
			
            if (producaoRefugadaAjuste.intValue() != 0) {
            	
    			/* Trecho onde é adicionado na coleção refugo @@@@@@ Ajuste Refugo Apontamento Manual */
            	PesquisaDTO pesquisaDTO = new PesquisaDTO();
                
                pesquisaDTO.setCodigo("@@@@@@");
                pesquisaDTO.setRegistro(ompt.getOmTppt());
                
                PesquisasDTO pesquisasDTO = IdwFacade.getInstancia().pesquisaDwTRefugo(pesquisaDTO);
                
                DwTRefugo dwTRefugoAjuste = (DwTRefugo) pesquisasDTO.getPesquisa().get(0).getRegistro();
                
                System.out.println(dwTRefugoAjuste.getCdTrefugo() + "-" + dwTRefugoAjuste.getDsTrefugo());
            	
            	DwConsolrelog dwConsolrelogAjuste = new DwConsolrelog();
            	
            	dwConsolrelogAjuste.setIsCancelado(false);//relog.setIsCancelado(false);
            	dwConsolrelogAjuste.setIdConsolrelog(0l);
            	dwConsolrelogAjuste.setDwTAcao(null);
            	dwConsolrelogAjuste.setDwTCausa(null);
            	dwConsolrelogAjuste.setDwTRefugo(dwTRefugoAjuste);//relog.setDwTRefugo(consolre.getDwTRefugo());
            	dwConsolrelogAjuste.setOmProduto(dwconsolprClone.getOmProduto());//relog.setOmProduto(consolpr.getOmProduto());
            	//dwConsolrelogAjuste.setOmPt(id.getOmPt());
            	dwConsolrelogAjuste.setDthrRefugo(id.getDthrIhora());//relog.setDthrRefugo(consolid.getDthrIhora());
            	dwConsolrelogAjuste.setPcsAutoProducaorefugada(BigDecimal.ZERO);//relog.setPcsAutoProducaorefugada(BigDecimal.ZERO);
            	dwConsolrelogAjuste.setPcsManuProducaorefugada(producaoRefugadaAjuste);
            	            	
            	DwConsolreoco dwConsolreocoAjuste = new DwConsolreoco();
            	
            	dwConsolreocoAjuste.setDwConsolrelog(dwConsolrelogAjuste);
            	dwConsolreocoAjuste.setIdConsolreoco(0l);
            	
            	DwConsolre dwconsolreAjuste = new DwConsolre();
            	
            	dwconsolreAjuste.setIdConsolre(0l);
            	dwconsolreAjuste.setPcsAutoProducaorefugada(BigDecimal.ZERO);//consolre.setPcsAutoProducaorefugada(null);
            	dwconsolreAjuste.setPcsManuProducaorefugada(producaoRefugadaAjuste);//consolre.setPcsManuProducaorefugada(BigDecimal.ZERO);
            	dwconsolreAjuste.setDwTRefugo(dwTRefugoAjuste);//consolre.setDwTRefugo(mot.getDwTRefugo());
            	dwconsolreAjuste.getDwConsolreocos().add(dwConsolreocoAjuste);
            	
            	dwconsolClone.getDwConsolres().add(dwconsolreAjuste);
            	
            }
			//FIM: Ajustes de diferença entre Produção Refugada Hora e Produção Refugada Hora Detalhe - Obter produção refugada hora
			
			retorno.getListaDwConsolidDTO().add(dto);
		
		}
		
		return retorno;
		
	}
	
	public List<DwConsolpr> getDwConsolpr(Long idDwConsol){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolpr FROM DwConsolpr dwConsolpr");
		q.append("where dwConsolpr.dwConsol.idConsol = :idConsol");
		q.defineParametro("idConsol", idDwConsol);
		return q.list();
	}


	public List<DwConsolmolog> getDwConsolmologComLoginAbertoByCdUp(String cdup){
		PTRN ptrn = new PTRN(getDao());
		OmPt ompt = ptrn.pesquisarPtByCdPtStAtivo(cdup);

		Validate.notNull(ompt, "OmPt esta nulo para cdup " + cdup);

		return getDwConsolmologComLoginAberto(ompt.getIdPt());
	}

	public List<DwConsolmolog> getDwConsolmologComLoginAberto(Long idPt){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolmolog FROM DwConsolmolog dwConsolmolog");
		q.append("where dwConsolmolog.omPt.idPt = :idPt");
		q.append("and dwConsolmolog.dthrFlogin is null");
		q.append("order by dwConsolmolog.dthrIlogin");
		q.defineParametro("idPt", idPt);
		return q.list();
	}

	public DwConsolmolog getDwConsolmologComLoginAbertoECdLogin(Long idPt, String login){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolmolog FROM DwConsolmolog dwConsolmolog");
		q.append("join dwConsolmolog.omUsr omusr");
		q.append("where dwConsolmolog.omPt.idPt = :idPt");
		q.append("and dwConsolmolog.dthrFlogin is null");
		q.append("and omusr.login = :login");
		q.append("order by dwConsolmolog.dthrIlogin");
		q.defineParametro("idPt", idPt);
		q.defineParametro("login", login);
		q.setMaxResults(1);
		return (DwConsolmolog) q.uniqueResult();
	}

	public DwConsolmolog getDwConsolmologComLoginAbertoECdLogin(String login){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolmolog FROM DwConsolmolog dwConsolmolog");
		q.append("join dwConsolmolog.omUsr omusr");
		q.append("where");
		q.append("dwConsolmolog.dthrFlogin is null");
		q.append("and omusr.login = :login");
		q.append("order by dwConsolmolog.dthrIlogin");
		q.defineParametro("login", login);
		q.setMaxResults(1);
		return (DwConsolmolog) q.uniqueResult();
	}

	public List<DwConsolmo> getDwConsolmoComLoginAberto(Long idConsol){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolmo FROM DwConsolmo dwConsolmo");
		//q.append("join dwConsolmo.dwConsol dwconsol");
		q.append("join dwConsolmo.dwConsolmoocos dwconsolmooco");
		q.append("join dwconsolmooco.dwConsolmolog dwconsolmolog");
		q.append("where dwConsolmo.dwConsol.idConsol = :idConsol");
		q.append("and dwconsolmolog.dthrFlogin is null");
		q.defineParametro("idConsol", idConsol);
		return q.list();
	}

	public List<DwConsolallog> getDwConsolalComAlertaAberto(OmPt ompt){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwconsolallog");
		q.append("FROM DwConsolallog dwconsolallog");
		q.append("join dwconsolallog.omPt ompt");
		q.append("where ompt.cdPt = :ompt");
		q.append("and dwconsolallog.dthrFalerta is null");
		q.defineParametro("ompt", ompt.getCdPt());
		return q.list();
	}

	public DwConsolallog getDwConsolalLogComAlertaAberto(OmPt ompt, DwTAlerta dwtalerta){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwconsolallog");
		q.append("FROM DwConsolallog dwconsolallog");
		q.append("where dwconsolallog.omPt = :ompt");
		q.append("and dwconsolallog.dwTAlerta = :dwtalerta");
		q.append("and dwconsolallog.dthrFalerta is null");
		q.defineParametro("ompt", ompt);
		q.defineParametro("dwtalerta", dwtalerta);
		q.setMaxResults(1);
		return (DwConsolallog)  q.uniqueResult();
	}

	public DwConsolallog getDwConsolalLogAbertoDepoisDoHorario(OmPt ompt, DwTAlerta dwtalerta, Date dthriReferencia){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwconsolallog");
		q.append("FROM DwConsolallog dwconsolallog");
		q.append("where dwconsolallog.omPt.cdPt = :ompt");
		q.append("and dwconsolallog.dwTAlerta.cdTalerta = :dwtalerta");
		q.append("and dwconsolallog.dthrIalerta >= :dthr");
		q.defineParametro("ompt", ompt.getCdPt());
		q.defineParametro("dwtalerta", dwtalerta.getCdTalerta());
		q.defineParametroTimestamp("dthr", dthriReferencia);
		q.setMaxResults(1);
		return (DwConsolallog)  q.uniqueResult();
	}

	public List<DwConsolallog> getDwConsolalManuaisComAlertaAberto(OmPt ompt){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwconsolallog");
		q.append("FROM DwConsolallog dwconsolallog");
		q.append("join dwconsolallog.dwTAlerta dwtalerta");
		q.append("where dwconsolallog.omPt.cdPt = :ompt");
		q.append("and dwconsolallog.dthrFalerta is null");
		q.append("and ( dwtalerta.isAutomatico = :isalerta or dwtalerta.isAutomatico is null) ");
		q.defineParametro("ompt", ompt.getCdPt());
		q.defineParametro("isalerta", false);
		return q.list();
	}


	public List<DwConsolallog> getDwConsolalComAlertaAberto(String cdPt){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwconsolallog");
		q.append("FROM DwConsolallog dwconsolallog");
		q.append("join fetch dwconsolallog.dwTAlerta b");
		q.append("where dwconsolallog.omPt.cdPt = :cdPt");
		q.append("and dwconsolallog.dthrFalerta is null");
		q.defineParametro("cdPt", cdPt);
		return q.list();
	}

	public List<DwConsolprmo> getDwConsolprmo(Long idConsolpr, Long idConsolmo){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolprmo FROM DwConsolmolog dwConsolprmo");
		q.append("where dwConsolprmo.dwConsolpr.idConsolpr = :idConsolpr");
		q.append("and dwConsolprmo.dwConsolmo.idConsolmo = :idConsolmo");
		q.defineParametro("idConsolpr", idConsolpr);
		q.defineParametro("idConsolmo", idConsolmo);
		return q.list();
	}

	public DwConsolpa getDwConsolpaSeNaoEncontrarGerarNovo(DwConsol dwConsol, DwTParada dwTParada){
		DwConsolpa dwConsolpa = this.getDwConsolpa(dwConsol.getIdConsol(), dwTParada.getIdTparada());
		if(dwConsolpa == null){
			dwConsolpa = new DwConsolpa();
			dwConsolpa.setIdConsolpa(null);
			dwConsolpa.setDwConsol(dwConsol);
			dwConsolpa.setDwTParada(dwTParada);
			getDao().makePersistent(dwConsolpa);
		}
		return dwConsolpa;
	}

	public DwConsolpa getDwConsolpa(long idConsol, long idTParada){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolpa FROM DwConsolpa dwConsolpa");
		q.append("where dwConsolpa.dwConsol.idConsol = :idConsol");
		q.append("and dwConsolpa.dwTParada.idTparada = :idTParada");
		q.defineParametro("idConsol", idConsol);
		q.defineParametro("idTParada", idTParada);
		q.setMaxResults(1);
		return (DwConsolpa) q.uniqueResult();
	}

	public DwConsolal getDwConsolal(long idConsol, long idTalerta){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolal FROM DwConsolal dwConsolal");
		q.append("where dwConsolal.dwConsol.idConsol = :idConsol");
		q.append("and dwConsolal.dwTAlerta.idTalerta = :idTalerta");
		q.defineParametro("idConsol", idConsol);
		q.defineParametro("idTalerta", idTalerta);
		q.setMaxResults(1);
		return (DwConsolal) q.uniqueResult();
	}

	public DwConsolmo getDwConsolmo(long idConsol, long idUsr){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolmo FROM DwConsolmo dwConsolmo");
		q.append("where dwConsolmo.dwConsol.idConsol = :idConsol");
		q.append("and dwConsolmo.omUsr.idUsr = :idUsr");
		q.defineParametro("idConsol", idConsol);
		q.defineParametro("idUsr", idUsr);
		q.setMaxResults(1);
		return (DwConsolmo) q.uniqueResult();
	}


	public DwConsolpaoco getDwConsolpaoco(long idConsolpa, long idConsolpalog){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolpaoco FROM DwConsolpaoco dwConsolpaoco");
		q.append("where dwConsolpaoco.dwConsolpa.idConsolpa = :idConsolpa");
		q.append("and dwConsolpaoco.dwConsolpalog.idConsolpalog = :idConsolpalog");
		q.defineParametro("idConsolpa", idConsolpa);
		q.defineParametro("idConsolpalog", idConsolpalog);
		q.setMaxResults(1);
		return (DwConsolpaoco) q.uniqueResult();
	}

	public List<DwConsolpaoco> getDwConsolpaoco(OmPt ompt, Date dthrICiclo, Date dthrFCiclo){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select distinct dwConsolpaoco FROM DwConsolpaoco dwConsolpaoco");
		q.append("join dwConsolpaoco.dwConsolpalog dwconsolpalog");
		q.append("join dwConsolpaoco.dwConsolpa dwconsolpa");
		q.append("join dwconsolpa.dwConsol dwconsol");
		q.append("join dwconsol.dwConsolid dwconsolid");
		q.append("join dwconsolid.omPt ompt");
		q.append("where ompt = :ompt");
		q.append("and dwConsolpaoco.dthrIparada between :inicio and :fim ");
		q.append("and dwconsolid.tpId = 1");
		q.defineParametro("ompt", ompt); // ompt.getIdPt()
		q.defineParametroTimestamp("inicio", dthrICiclo);
		q.defineParametroTimestamp("fim", dthrFCiclo);
		return q.list();
	}

	public DwConsolmooco getDwConsolmooco(long idConsolmo, long idConsolmolog){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolmooco FROM DwConsolmooco dwConsolmooco");
		q.append("where dwConsolmooco.dwConsolmo.idConsolmo = :idConsolmo");
		q.append("and dwConsolmooco.dwConsolmolog.idConsolmolog = :idConsolmolog");
		q.defineParametro("idConsolmo", idConsolmo);
		q.defineParametro("idConsolmolog", idConsolmolog);
		q.setMaxResults(1);
		return (DwConsolmooco) q.uniqueResult();
	}

	public DwConsolaloco getDwConsolaloco(long idConsolal, long idConsolallog){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolaloco FROM DwConsolaloco dwConsolaloco");
		q.append("where dwConsolaloco.dwConsolal.idConsolal = :idConsolal");
		q.append("and dwConsolaloco.dwConsolallog.idConsolallog = :idConsolallog");
		q.defineParametro("idConsolal", idConsolal);
		q.defineParametro("idConsolallog", idConsolallog);
		q.setMaxResults(1);
		return (DwConsolaloco) q.uniqueResult();
	}

	public DwConsolpamo getDwConsolpamoSeNaoEncontrarNovo(DwConsolpa dwConsolpa, DwConsolmo dwConsolmo){
		DwConsolpamo dwConsolpamo = this.getDwConsolpamo(dwConsolpa.getIdConsolpa(), dwConsolmo.getIdConsolmo());
		if(dwConsolpamo == null){
			dwConsolpamo = new DwConsolpamo();
			dwConsolpamo.setDwConsolmo(dwConsolmo);
			dwConsolpamo.setDwConsolpa(dwConsolpa);
			this.getDao().makePersistent(dwConsolpamo);
		}		
		return dwConsolpamo;
	}

	public DwConsolpamo getDwConsolpamo(long idConsolpa, long idConsolmo){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwConsolpamo FROM DwConsolpamo dwConsolpamo");
		q.append("where dwConsolpamo.dwConsolpa.idConsolpa = :idConsolpa");
		q.append("and dwConsolpamo.dwConsolmo.idConsolmo = :idConsolmo");
		q.defineParametro("idConsolpa", idConsolpa);
		q.defineParametro("idConsolmo", idConsolmo);
		q.setMaxResults(1);
		return (DwConsolpamo) q.uniqueResult();
	}

	/**
	 * Pega Último DwRt de OmPt
	 * @param idPt
	 * @param joinParada pega dados da parada
	 * @return
	 */
	public DwRt obtemUltimoDwRt(long idPt, boolean joinParada){
		OmPt ompt = getDao().findById(OmPt.class, idPt, false);
		
		// Busca Último DwRt de OmPt
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select dwRt from DwRt dwRt ");
		q.append("left join fetch dwRt.dwConsolpalog");
		q.append("where dwRt.omPt.idPt = :idPt");
		if (ompt != null && ompt.getPpCp()!= null)
			q.append("and dwRt.ppCp = :ppcp");
		
		q.append("order by dwRt.idRt desc");
		q.defineParametro("idPt", idPt);
		if (ompt != null && ompt.getPpCp()!= null)
			q.defineParametro("ppcp", ompt.getPpCp());
		
		q.setMaxResults(1);
		return (DwRt) q.uniqueResult();
	}

	/**
	 * Obtem Último DwRt de OmPt
	 * @param idPt
	 * @return
	 */
	public DwRt obtemUltimoDwRt(long idPt){
		return obtemUltimoDwRt(idPt, false);
	}

	/**
	 * Pega planejamento atual da mÃ¡quina
	 * @param idPt
	 * @return
	 * @throws SemPlanejamentoException
	 */
	public PpCp pesquisarPlanejamentoAtualOmPt(Long idPt) throws SemPlanejamentoException{

		DwRt dwRt = obtemUltimoDwRt(idPt);

		PpCp ppCp = null;

		// pega o PpCp do Último DwRt do Ompt
		if(dwRt != null){
			ppCp = dwRt.getPpCp();
		}

		if(ppCp == null){
			throw new SemPlanejamentoException();
		}

		return ppCp;

	}


	/**
	 * Pega fim do Último evento produtivo (parada ou ciclo), pegando direto da tabela de ocorrencia.
	 * @param omPt
	 * @param dwConsolpt tem o Último  
	 * @param dtHrRef
	 * @return
	 */
	public Date getFimUltimoEventoProdutivo(OmPt omPt, Date dtHrMaiorFimProdutivo, Date dtHrRef){

		Date dthFimUltimoCiclo = null;
		DwRtcic ultimoCiclo = getUltimoCiclo(omPt, null, dtHrRef);
		if(ultimoCiclo != null){
			dthFimUltimoCiclo = ultimoCiclo.getDthrFciclo();
		}

		Date dtHrFimUltimaParada = null;
		DwConsolpalog dwConsolpalog = getUltimaParada(omPt, dtHrRef);
		if(dwConsolpalog != null){
			dtHrFimUltimaParada = dwConsolpalog.getDthrFparada();
		}

		Date maiorDthr = DataHoraRN.getMaiorData(dtHrMaiorFimProdutivo,  dthFimUltimoCiclo, dtHrFimUltimaParada);

		return maiorDthr;

	}






	/**
	 * Verifica se evento estÃ¡ em perÃ­odo anterior ao Último evento consolidado
	 * @param dwConsolpt se estiver nulo ou seu fim estiver nulo, retorna 
	 * @param dtHr	
	 * @throws IllegalStateException se {@code dtHr < dwConsolpt.getDtHrfim()}
	 */
	protected void validarEventoDeveSerMaiorUltimoEventoConsolidado(DwConsolpt dwConsolpt, Date dtHr) {

		Validate.notNull(dtHr, "Data hora deve ser informada para saber se eh anterior ao periodo consolidado");

		if(dwConsolpt != null && dwConsolpt.getDthrFim() != null){

			// Data/hora de referencia deve ser maior ou igual ao fim da Ãºltima consolidaçãoo da mÃ¡quina
//			Validate.validState(DataHoraRN.compareTo(dtHr, dwConsolpt.getDthrFim()) >=0 , 
//					(new StringBuilder())
//					.append("Evento desprezado, data/hora de referencia < data/hora ultima consolidacao. ")
//					.append(" idPt=")
//					.append(dwConsolpt.getOmPt().getIdPt())						
//					.append(" dwConsolpt.dwhrfim=")
//					.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dwConsolpt.getDthrFim()))
//					.append(" > dthrref=")
//					.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dtHr))
//					.toString());

		}

	}

	/**
	 * @param omPt
	 * @return
	 */
	public boolean isMaquinaComTempoParadaDentroTempoCiclo(OmPt omPt){

		Validate.notNull(omPt, " omPt nao pode ser nulo");
		Validate.notNull(omPt.getOmTppt(), " omPt.getOmTppt() nao pode ser nulo");

		// se constante estiver ativa, indica que não precisa validar se parada conta para o tempo ativo
		// atualmente apenas, para as mÃ¡quina insersoras que pode ou não considerar o tempo de para isso
		if(ConsolidaRN.MAQUINA_INSERSORA_CONSIDERA_PARADA_COMO_TEMPO_ATIVO){
			return false;
		}

		// Se mÃ¡quina for insersora, não irÃ¡ considerar o tempo de parada com peso como tempo ativo. Tem parada dentro do tempo de ciclo
		return OmTpptTemplate.Type.IAC.equals(omPt.getOmTppt().getIdTppt());

	}


	/**
	 * Pega o ciclo padrão
	 * @param omPt
	 * @param dwFolha
	 * @return
	 */
	public BigDecimal getCicloPadrao(OmPt omPt, DwFolha dwFolha) throws SemCicloPadraoException{
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		return folhaRN.getCicloPadrao(dwFolha, omPt);
	}

	/**
	 * Pega cavidades ativas da folha
	 * @param dwFolha
	 * @return
	 */
	public BigDecimal getCavAtivas(DwFolha dwFolha){
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		try {
			return folhaRN.getPcsPorCicloAtivas(dwFolha);
		} catch (SemPcsPorCicloAtivasException e) {
			return BigDecimal.ONE;
		}
	}

	public BigDecimal getCavAtivasAjustaDwConsolSenaoTiver(DwConsol dwConsol) {
		BigDecimal cavAtivaDwConsol = setCavAtivasDwConsolSeNulo(dwConsol);
		return cavAtivaDwConsol;
	}

	public BigDecimal setCavAtivasDwConsolSeNulo(DwConsol dwConsol) {
		DwFolha dwFolha = dwConsol.getDwConsolid().getDwFolha();		
		BigDecimal cavAtivaDwConsol = dwConsol.getQtAutoCavativas();
		if (cavAtivaDwConsol == null) {
			cavAtivaDwConsol = this.getCavAtivas(dwFolha);
			dwConsol.setQtAutoCavativas(cavAtivaDwConsol);			
		}
		return cavAtivaDwConsol;
	}
	
	public BigDecimal getCavTotais(DwFolha dwFolha){
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		try {
			return folhaRN.getPcsPorCicloTotais(dwFolha);
		} catch (SemPcsPorCicloAtivasException e) {
			return BigDecimal.ONE;
		}
	}
	
	public BigDecimal getCavTotaisAjustaDwConsolSenaoTiver(DwConsol dwConsol) {
		BigDecimal cavTotalDwConsol = setCavTotaisDwConsolSeNulo(dwConsol);
		return cavTotalDwConsol;
	}

	public BigDecimal setCavTotaisDwConsolSeNulo(DwConsol dwConsol) {
		DwFolha dwFolha = dwConsol.getDwConsolid().getDwFolha();
		BigDecimal cavTotalDwConsol = dwConsol.getQtAutoCavtotal();
		if (cavTotalDwConsol == null) {
			cavTotalDwConsol = this.getCavTotais(dwFolha);
			dwConsol.setQtAutoCavtotal(cavTotalDwConsol);
		}
		return cavTotalDwConsol;
	}
	
	/**
	 * Consolida o cancelamento do refugo
	 * @param omPt
	 * @param dwConsolpt
	 * @param dwCalsems
	 * @param msevt
	 * @param omcfg
	 * @param log
	 * @throws RegistroDesconhecidoException
	 * @throws SemCicloPadraoException
	 * @throws SemSGBDException
	 * @throws SemCalendarioException
	 */
	public void consolidarCancelamentoRefugo(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, MsEvt msevt, OmCfg omcfg, IdwLogger log, int idLog, int identacao) throws RegistroDesconhecidoException, SemCalendarioException, SemSGBDException, SemCicloPadraoException{
	}

	public List<DwConsolid> pesquisarDwConsolidPorPpCp(Date dtReferencia, PpCp cp){
		MapQuery q = new MapQuery(getDaoSession());

		q.append("select dwconsolid ");
		q.append("from DwConsolid dwconsolid ");
		q.append("left join dwconsolid.dwConsols consol");
		q.append("left join consol.dwConsolpas");
		q.append("left join dwconsolid.dwFolha f ");
		if (cp.getOmPt() !=null) {
			q.append("join dwconsolid.omPt pt ");
		}
		if (cp.getOmGt() != null) {
			q.append("join dwconsolid.omGt gt ");
		}

		q.append("where f.cdFolha = :cdF ");

		q.append("and f.stAtivo = 1 ");
		if (cp.getOmPt() !=null) {
			q.append("and pt.idPt = :idPT ");
		}
		if (cp.getOmGt() != null) {
			q.append("and gt.idGt = :idGT ");
		}

		q.append("and dwconsolid.stAtivo is null ");
		q.append("and dwconsolid.dtReferencia between :dtRefInicio and :dtRefFim ");

		q.defineParametro("cdF", cp.getDwFolha().getCd());
		q.defineParametroTimestamp("dtRefInicio", DataHoraRN.getDataSemHora(dtReferencia));
		q.defineParametroTimestamp("dtRefFim", DataHoraRN.getDataHora235959(dtReferencia));
		if (cp.getOmPt() !=null) {
			q.defineParametro("idPT", cp.getOmPt().getIdPt());
		}
		if (cp.getOmGt() != null) {
			q.defineParametro("idGT", cp.getOmGt().getIdGt());
		}

		//q.setMaxResults(1);
		List<DwConsolid> retorno =q.list();

		return retorno;
	}

	public PeriodoDTO obtemPeriodoDaHoraAtual(Date dtHr){
		return PeriodoRN.obtemPeriodoDaHoraAtual(dtHr);
	}

	public List<PeriodoDTO> obtemHorasPeriodo(Date dtHrIni, Date dtHrFim){
		return PeriodoRN.obtemHorasPeriodo(dtHrIni, dtHrFim);
	}

	private DwConsolid insertDwConsolid(DwConsolidTemplate.TpId tpId, Date dtReferencia, Long idTurno, Date dthrIturno, Date dthrFturno, Long idCal, Date dthrIhora,
			Date dthrFhora, Integer ano, Integer mes, long idPt, DwFolha dwFolha, DwRt oDwRt, PpCp ppcp, DwPepro dwpepro) throws SemCicloPadraoException {

		if(tpId.equals(DwConsolidTemplate.TpId.HORA)){
			if(dthrIhora == null){

			}
		}else if(tpId.equals(DwConsolidTemplate.TpId.TURNO)){
			// não guarda a hora
			dthrIhora = null;
			dthrFhora = null;
		}else if(tpId.equals(DwConsolidTemplate.TpId.MES)){
			// não guarda a data de referencia
			dtReferencia = null;
		}else if(tpId.equals(DwConsolidTemplate.TpId.ACUMULADO)){
			// não guarda a data de referencia
			dtReferencia = null;

			// não guarda ano e mÃªs
			ano = null;
			mes = null;
		}

		DwConsolid dwConsolid = new DwConsolid();

		dwConsolid.setTpId(tpId.getValue());
		dwConsolid.setDthrCadastro(DataHoraRN.getDataHoraAtual());
		dwConsolid.setDtReferencia(dtReferencia);
		dwConsolid.setAno(ano);
		dwConsolid.setMes(mes);
		dwConsolid.setDthrIhora(dthrIhora);
		dwConsolid.setDthrFhora(dthrFhora);
		dwConsolid.setDthrIturno(dthrIturno);
		dwConsolid.setDthrFturno(dthrFturno);
		dwConsolid.setPpCp(ppcp);

		if (dwpepro == null) {
			// Utilizar o periodo produtivo normal
			if (oDwRt != null && oDwRt.getIsCip() != null && oDwRt.getIsCip())
				dwpepro = getDao().findById(DwPepro.class, DwPeproTemplate.Type.CONTROLE_REINICIO_DE_PROCESSO.getId(), false);
			else
				dwpepro = getDao().findById(DwPepro.class, DwPeproTemplate.Type.NORMAL.getId(), false);
		} else {
			// Se o periodo vier verificar se eh REGULAGEM. Se for seta para 0 o stativo
			if (dwpepro.getIdPepro() == DwPeproTemplate.Type.REGULAGEM.getId()) {
				dwConsolid.setStAtivo((byte) 0);
			}
		}
		dwConsolid.setDwPepro(dwpepro);
		if (idCal != null)
			dwConsolid.setDwCal((DwCal) this.getDao().getSession().get(DwCal.class, idCal));
		else
			dwConsolid.setDwCal(null);
		if (idTurno != null)
			dwConsolid.setDwTurno((DwTurno) this.getDao().getSession().get(DwTurno.class, idTurno));
		else
			dwConsolid.setDwTurno(null);
		
		OmPt omPt = (OmPt) this.getDao().getSession().get(OmPt.class, idPt);
		dwConsolid.setOmPt(omPt);
		
		if (dwFolha != null)
			dwConsolid.setDwFolha((DwFolha) this.getDao().getSession().get(DwFolha.class, dwFolha.getIdFolha()));
		else
			dwConsolid.setDwFolha(ppcp.getDwFolha());
		
		dwConsolid.setDwRt(oDwRt);

		// Se o posto aponta em gt, indicar o gt no consolidado
		if(omPt != null && omPt.getIsApongt() != null && omPt.getIsApongt()){
			dwConsolid.setOmGt(omPt.getOmGt());
		}

		getDao().makePersistent(dwConsolid);

		insertDwConsol(dwConsolid);

		return(dwConsolid);
	}

	/* Esse metodo verifica se o intervalo do registro que está sendo consolidado é diferente do tempo ja consolidado com o tempo da parada sem peso
	 * 
	 */
	public void checarTempoTotal(String msg, IdwLogger log, int idLog, int identacao, DwConsolid dwConsolid, OmPt omPt, DwConsol dwConsol) {
		if (dwConsolid.getDthrIconsol() != null && dwConsolid.getDthrFconsol() != null &&
				(DwConsolidTemplate.TpId.HORA.equals(dwConsolid) || DwConsolidTemplate.TpId.TURNO.equals(dwConsolid))) {
			
			BigDecimal tempoPeriodo = DataHoraRN.getQuantidadeSegundosComMilisegundosNoPeriodoComScale5(dwConsolid.getDthrIconsol(), dwConsolid.getDthrFconsol());
			BigDecimal tempoTotal = AritmeticaUtil.somar(dwConsol.getSegAutoTempoativo(), dwConsol.getSegAutoTempoparadaSp());
			tempoTotal.setScale(5);
			if (!tempoTotal.equals(tempoPeriodo)) {
				log.info(idLog, identacao, "checarTempoTotal: " + msg + "."
						+ "Tempo total da producao diferente do tempo do periodo." 
						+ "Pt: " + omPt.getCdPt() + " " 
						+ "Periodo: " + DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dwConsolid.getDthrIconsol()) + " - " 
						+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(dwConsolid.getDthrFconsol()) + " "  
						+ "TempoPeriodo: " + tempoPeriodo + " " 
						+ "TempoTotal: " + tempoTotal + " "
						+ "TempoCalendario: " + dwConsol.getSegAutoTempocalendario());
			}
		}
	}

	public OmProduto obtemPrimeirProduto(DwFolha dwfolha) {
		OmProduto retorno = null;
		if (dwfolha.getDwFolhaiacs() != null && dwfolha.getDwFolhaiacs().size() > 0) {
			DwFolhaiac dwfolhaiac = dwfolha.getDwFolhaiacs().iterator().next();
			retorno = dwfolhaiac.getOmProduto();
		} else {
			for (DwFolharap rap : dwfolha.getDwFolharaps()) {
				for (DwFolharapcom com : rap.getDwFolharapcoms() ) {
					retorno = com.getOmProduto();
				}
			}
		}
		return retorno;
	}

	public DwConsolpr obtemDwConsolprByIdPt(Long idPt){
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT dwconsolpr ");
		q.append("FROM DwConsolpr dwconsolpr ");
		q.append("join fetch dwconsolpr.dwConsol dwconsol");
		q.append("join fetch dwconsol.dwConsolid dwconsolid");
		q.append("join fetch dwconsolid.ppCp ppcp");
		q.append("join fetch ppcp.omPt ompt");
		q.append("where ompt.idPt = :idPt");
		q.append("ORDER BY dwconsolpr.idConsolpr DESC ");
		
		q.defineParametro("idPt", idPt);
		q.query().setMaxResults(1);
		
		DwConsolpr retorno = (DwConsolpr) q.query().uniqueResult();

		q = null;
		
		return retorno;
		
	}

	public List<DwConsolpa> getDwconsolPas(DwConsol dwConsol) {

		MapQuery q = new MapQuery(getDao().getSession());

		q.append("SELECT DISTINCT consolPa");
		q.append("  FROM DwConsolpa consolPa");
		q.append("  JOIN FETCH consolPa.dwTParada par ");
		q.append(" WHERE consolPa.dwConsol.idConsol =:consol ");
		q.defineParametro("consol", dwConsol.getIdConsol());

		List<DwConsolpa> listaPas = q.list();

		return listaPas;
	}

}
