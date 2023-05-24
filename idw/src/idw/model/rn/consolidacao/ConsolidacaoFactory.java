package idw.model.rn.consolidacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolptDAO;
import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.rn.PTRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.consolidacao.alerta.ConsolidacaoFimAlerta;
import idw.model.rn.consolidacao.alerta.ConsolidacaoInicioAlerta;
import idw.model.rn.consolidacao.cip.ConsolidacaoFimCIP;
import idw.model.rn.consolidacao.cip.ConsolidacaoInicioCIP;
import idw.model.rn.consolidacao.operador.ConsolidacaoLoginOperador;
import idw.model.rn.consolidacao.operador.ConsolidacaoLogoutOperador;
import idw.model.rn.consolidacao.parada.ConsolidacaoFimParada;
import idw.model.rn.consolidacao.parada.ConsolidacaoInicioParada;
import idw.model.rn.consolidacao.parada.ConsolidacaoMotivoParada;
import idw.model.rn.consolidacao.parametromedicao.ConsolidacaoParametroMedicao;
import idw.model.rn.consolidacao.perdamp.ConsolidacaoPerdaMP;
import idw.model.rn.consolidacao.planejamento.ConsolidacaoFimPlanejamento;
import idw.model.rn.consolidacao.planejamento.ConsolidacaoInicioPlanejamento;
import idw.model.rn.consolidacao.producao.ConsolidacaoFimCiclo;
import idw.model.rn.consolidacao.producao.ConsolidacaoFimCicloEmRegulagem;
import idw.model.rn.consolidacao.producao.ConsolidacaoInicioCiclo;
import idw.model.rn.consolidacao.producao.ConsolidacaoPassagem;
import idw.model.rn.consolidacao.refugo.ConsolidacaoCancelamentoRefugo;
import idw.model.rn.consolidacao.refugo.ConsolidacaoMotivoRefugo;
import idw.model.rn.consolidacao.variacaoritmo.ConsolidacaoFimVariacaoRitmo;
import idw.model.rn.consolidacao.variacaoritmo.ConsolidacaoInicioVariacaoRitmo;
import idw.model.rn.consolidacao.variacaoritmo.ConsolidacaoMotivoVariacaoRitmo;
import idw.util.IdwLogger;
import idw.util.Util;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoFactory {
	private static ConsolidacaoFactory instancia;

	private final Map<MsTpevtTemplate.Type, Class<? extends IConsolidacao>> consolidacoesDisponiveis = new HashMap<MsTpevtTemplate.Type, Class<? extends IConsolidacao>>();

	public ConsolidacaoFactory() {
		super();
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.INICIO_CICLO, ConsolidacaoInicioCiclo.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.FIM_CICLO, ConsolidacaoFimCiclo.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.PERDA_MATERIA_PRIMA, ConsolidacaoPerdaMP.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.INICIO_LOGIN, ConsolidacaoLoginOperador.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.FIM_LOGIN, ConsolidacaoLogoutOperador.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.INICIO_PARADA, ConsolidacaoInicioParada.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.MOTIVO_PARADA, ConsolidacaoMotivoParada.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.FIM_PARADA, ConsolidacaoFimParada.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.PASSAGEM, ConsolidacaoPassagem.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.FINAL_SAIDA_PLANEJAMENTO, ConsolidacaoFimPlanejamento.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.ENTRADA_PLANEJAMENTO, ConsolidacaoInicioPlanejamento.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.PARAMETRO_MEDICAO, ConsolidacaoParametroMedicao.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.MOTIVO_REFUGO, ConsolidacaoMotivoRefugo.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.CANCELAMENTO_REFUGO, ConsolidacaoCancelamentoRefugo.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.INICIO_CIP, ConsolidacaoInicioCIP.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.FIM_CIP, ConsolidacaoFimCIP.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.INICIA_VARRITMO, ConsolidacaoInicioVariacaoRitmo.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.MOTIVO_VARRITMO, ConsolidacaoMotivoVariacaoRitmo.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.FIM_VARRITMO, ConsolidacaoFimVariacaoRitmo.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.FIM_ALERTA, ConsolidacaoFimAlerta.class);
		consolidacoesDisponiveis.put(MsTpevtTemplate.Type.INICIO_ALERTA, ConsolidacaoInicioAlerta.class);
	}
	
	public static ConsolidacaoFactory getInstancia() {
		if (instancia == null)
			instancia = new ConsolidacaoFactory();
		return instancia;
	}

	/**
	 * Metodo para execucao de qualquer servico que chegue nele
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws RegistroDesconhecidoException 
	 * @throws SemPlanejamentoException 
	 * @throws SemCicloPadraoException 
	 * @throws SemSGBDException 
	 * @throws SemCalendarioException 
	 * @throws NumeroSerieIrregularException 
	 */
	public void executarConsolidacao(DAOGenerico dao, OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msEvt, OmCfg omcfg, IdwLogger log, int idLog, int identacao) throws InstantiationException, IllegalAccessException, SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException, RegistroDesconhecidoException, EventoInvalidoException, ReprocessarMsEvtException, NumeroSerieIrregularException, CicloJaContabilizadoException {
		
		MsTpevtTemplate.Type tpEvt = MsTpevtTemplate.Type.getType(msEvt.getMsTpevt().getIdTpevt().intValue());
		
		Class<? extends IConsolidacao> classConsolidacao =  consolidacoesDisponiveis.get(tpEvt);
		
		if(classConsolidacao == null){
			throw new IllegalArgumentException("N�o ha consolidacao para tpevt " + msEvt.getMsTpevt().getIdTpevt());
		}
		
			
		IConsolidacao rn = classConsolidacao.newInstance();
		rn.setDao(dao);
		rn.executarConsolidacao(omPt, dwconsolpt, dwCalsems, msEvt, omcfg, log, idLog, identacao);
	}

	public void executarConsolidacaoEmRegulagem(DAOGenerico dao, OmPt omPt, DwConsolpt dwconsolpt, List<DwCalsem> dwCalsems, MsEvt msEvt, OmCfg omcfg, IdwLogger log, int idLog, int identacao) throws InstantiationException, IllegalAccessException, SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException, RegistroDesconhecidoException, EventoInvalidoException, ReprocessarMsEvtException, NumeroSerieIrregularException, CicloJaContabilizadoException {
		
		MsTpevtTemplate.Type tpEvt = MsTpevtTemplate.Type.getType(msEvt.getMsTpevt().getIdTpevt().intValue());

		IConsolidacao rn = null;

		if (tpEvt.getId() == MsTpevtTemplate.Type.INICIO_CICLO.getId()) {
			// Alessandre em 16-06-17 comentei a linha abaixo pois a coleta via Concentrador usa o inicio de ciclo como fim de ciclo
			//rn = new ConsolidacaoInicioCicloEmRegulagem();
			rn = new ConsolidacaoFimCicloEmRegulagem();
		} else if (tpEvt.getId() == MsTpevtTemplate.Type.FIM_CICLO.getId()) {
			rn = new ConsolidacaoFimCicloEmRegulagem();
		} else {
			throw new IllegalArgumentException("Nao ha consolidacao para tpevt " + msEvt.getMsTpevt().getIdTpevt());
		}
			
		rn.setDao(dao);
		rn.executarConsolidacao(omPt, dwconsolpt, dwCalsems, msEvt, omcfg, log, idLog, identacao);
	}

	public Map<MsTpevtTemplate.Type, Class<? extends IConsolidacao>> getConsolidacoesDisponiveis() {
		return this.consolidacoesDisponiveis;
	}


	// Metodo para testar a consolidacao de determinado evento e analisar pq nao esta sendo consolidado
	// eh necessario alterar os valores do teste
	public static void main(String[] args) {
		IdwLogger log = new IdwLogger("teste");
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		PTRN prn = new PTRN();
		prn.iniciaConexaoBanco();
		OmPt ompt = null;
		try {
			ompt = prn.getOmPt("AOIL06");
		} catch (RegistroDesconhecidoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		OmCfg omcfg = Util.getConfigGeral(prn.getDaoSession());
		
		MsEvt msEvt = prn.getDao().findById(MsEvt.class, (long) 4344637, false);
		
		TurnoRN turnoRN = new TurnoRN(prn.getDao());
		List<DwCalsem> dwCalsems = null;
		try {
			dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(ompt, msEvt.getDthrEvento());
		} catch (SemCalendarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DwConsolptDAO dwConsolptDAO = new DwConsolptDAO(prn.getDaoSession());
		DwConsolpt dwConsolpt = dwConsolptDAO.getDwConsolptSeNaoEncontraCria(ompt);

		
		ConsolidacaoPassagem rn = new ConsolidacaoPassagem();
		rn.setDao(prn.getDao());
		try {
			rn.executarConsolidacao(ompt, dwConsolpt, dwCalsems, msEvt, omcfg, log, idLog, identacao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rn.finalizaConexaoBanco();
	}
}
