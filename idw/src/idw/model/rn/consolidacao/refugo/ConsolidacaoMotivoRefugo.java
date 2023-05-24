package idw.model.rn.consolidacao.refugo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.ReprocessarMsEvtException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwPassagemTemplate;
import idw.model.rn.AcaoRN;
import idw.model.rn.CausaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.NumeroSerieRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.RefugoRN;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;
import ms.util.ConversaoTipos;

public class ConsolidacaoMotivoRefugo extends ConsolidacaoRefugoRN implements IConsolidacao{

	public static void main(String[] args) {
		FolhaRN folhaRN = new FolhaRN();
		folhaRN.iniciaConexaoBanco();
		
		DwFolha dwFolha = folhaRN.pesquisaFolhaByCdEStSemRota("A05");

		String cdProduto = "A";
		
		for (DwFolharap dwfolharap : dwFolha.getDwFolharaps()) {
			for (DwFolharapcom dwfolharapcom : dwfolharap.getDwFolharapcoms()) {
				Byte cdreduzido = ConversaoTipos.converterParaByte(cdProduto);
				int idred = Integer.valueOf(dwfolharapcom.getIdredzproduto());
				char cdreduzido2 = (char) idred;
				System.out.println("Comparando refugo " + cdreduzido + " com idredzFolha = " + cdreduzido2);
				if ( cdreduzido.equals(ConversaoTipos.converterParaByte(cdreduzido2)) == true) {
					System.out.println("deb");
				}
			}
		}

		folhaRN.finalizaConexaoBanco();
	}
	
	
	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolpt,
			List<DwCalsem> dwCalsems, MsEvt msevt, OmCfg omcfg, IdwLogger log,
			int idLog, int identacao) 
		throws 
			SemCalendarioException,
			SemSGBDException, SemCicloPadraoException,
			SemPlanejamentoException, RegistroDesconhecidoException,
			EventoInvalidoException, ReprocessarMsEvtException,
			NumeroSerieIrregularException {

		
		String cdCp = msevt.getNrop();
		Date dthrRefugo = msevt.getDthrEvento();
		String cdRefugo =  msevt.getCdRefugo();
		String cdProduto = msevt.getCdProdutoredz();
		BigDecimal qtde = msevt.getQtde();
		String cdCausa = msevt.getCdCausa();
		String cdAcao = msevt.getCdAcao();
		String cb = msevt.getCb();
		
		Validate.notNull(omcfg, "Sem configuracao");

		// Se o motivo do refugo veio null entao avaliar se na configuracao gerao do sistema existe um motivo default
		if (cdRefugo == null || (cdRefugo != null && cdRefugo.trim().equals("")) ) {
			if (omcfg.getDwTRefugo() != null)
				cdRefugo = omcfg.getDwTRefugo().getCdTrefugo();
		}

		Validate.notNull(omPt, "OmPt esta nulo");
		Validate.notBlank(cdCp, "CdCp esta nulo");
		Validate.notNull(dthrRefugo, "DthrEvento esta nulo");
		Validate.notBlank(cdRefugo, "cdRefugo esta nulo");
		// Alessandre: comentei a validacao abaixo pois o produto para o inova veio vazio
		//Validate.notBlank(cdProduto, "cdProdutoredz está nulo");
		Validate.notNull(qtde, "Qtd esta nulo");
		Validate.isTrue(qtde.signum() > 0, "Quantidade refugada deve ser maior que zero");

		// Pega referencia da ordem de produ��oo
		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msevt, omcfg);
		Validate.notNull(ppCp, "PpCp esta nulo");
		ppCp.mudarDthrIniciorealIfNull(dthrRefugo);
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(ppCp, "nao encontrou dwFolha ativa para PpCp");


		// Pega referencia do refugo
		DwTRefugo dwTRefugo = null;

		try {
			RefugoRN refugoRN = new RefugoRN();
			refugoRN.setDaoSession(this.getDao().getSession());
			dwTRefugo = refugoRN.getDwTRefugo(cdRefugo, omPt.getOmTppt());
		} catch (RegistroDesconhecidoException e) {
			throw new RegistroDesconhecidoException("Refugo nao encontrada. refugo:" + cdRefugo + " idOmTppt:" + omPt.getOmTppt().getIdTppt());
		}

		/*
		 * Se o codigo de barras vier preenchido entao � o refugo de um determinado numero de serie. Nesse caso o NS deve ser direcionado para um ESTOQUE de refugos
		 */
		if (cb != null && cb.trim().equals("") == false && ( (omPt.getIsSolicitaqtde() != null && omPt.getIsSolicitaqtde() == false) || omPt.getIsSolicitaqtde() == null ) ) {
			Validate.notNull(omcfg.getDwEstByIdEstrefugo(), "Sem configuracao estoque refugo");
			
			// Localiza o numero de serie e aloca ele para o estoque de refugos
			NumeroSerieRN rn = new NumeroSerieRN(getDao());
			DwNserie dwnseriedb = null;
			dwnseriedb = rn.getDwNserieCb(msevt.getCb());

			if (dwnseriedb != null) {
				log.info("Expressao = " + (dwnseriedb.getDwEst() != null && dwnseriedb.getDwEst().getCdEst().equals(omcfg.getDwEstByIdEstrefugo().getCdEst())));
				Validate.isTrue(!(dwnseriedb.getDwEst() != null && dwnseriedb.getDwEst().getCdEst().equals(omcfg.getDwEstByIdEstrefugo().getCdEst())), "Produto ja refugado");
				dwnseriedb.setDwEst(omcfg.getDwEstByIdEstrefugo());
				getDao().makePersistent(dwnseriedb);

				// Obter o ultimo operador logado que permanece logado
				List<DwConsolmolog> lista = getDwConsolmologComLoginAberto(omPt.getIdPt());
				OmUsr omusr = null;
				if (lista != null && lista.isEmpty() == false) {
					omusr = lista.get(lista.size()-1).getOmUsr();
				}

				// Obter dwConsolid
				DwConsolid dwconsolid = null;
				dwconsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, msevt.getDthrEvento(), omcfg, msevt.getDwPepro());

				// Lancar uma passagem de REFUGO para registrar na rastreabilidade
				DwPassagem dwpassagem = new DwPassagem();
				dwpassagem.setDthr(msevt.getDthrEvento());
				dwpassagem.setDthrInicio(msevt.getDthrEvento());
				dwpassagem.setDwConsolid(dwconsolid);
				dwpassagem.setDwEst(omcfg.getDwEstByIdEstrefugo());
				dwpassagem.setDwNserie(dwnseriedb);
				dwpassagem.setIdPassagem(0l);
				dwpassagem.setIsTfFinalizado(true);
				dwpassagem.setMsDthr(DataHoraRN.getApenasMilisegundos(msevt.getDthrEvento()));
				dwpassagem.setMsDthrinicio(DataHoraRN.getApenasMilisegundos(msevt.getDthrEvento()));
				dwpassagem.setOmPt(omPt);
				dwpassagem.setOmUsrByIdUsroperador(omusr);
				dwpassagem.setOmUsrByIdUsrsupervisor(null);
				dwpassagem.setSegCiclo(new BigDecimal(DataHoraRN.getQuantidadeSegundosNoPeriodo(dwpassagem.getDthrInicio(), dwpassagem.getDthr())));
				dwpassagem.setDsDiariobordo(dwTRefugo.getCdTrefugo() + "-" + dwTRefugo.getDsTrefugo());
				dwpassagem.setStNserie(DwPassagemTemplate.StNserie.NAO_CONFORME.getValue());

				getDao().makePersistent(dwpassagem);
			}
		}

		/*
		 * Se o CB vim preenchido e o pt solicita a qdte entao considerar o CB como sendo o codigo do produto e nao o cd_produto
		 */
		if (cb != null && cb.trim().equals("") == false && cb.trim().equals("null") == false && omPt.getIsSolicitaqtde() != null && omPt.getIsSolicitaqtde() == true) {
			cdProduto = cb;
		}

		// Pegar referencia do produto
		ProdutoRN produtoRN = new ProdutoRN(getDao());
		OmProduto omProduto = null;
		
		if (cdProduto == null) {
			cdProduto = msevt.getCdProduto();
		}

		
		
		// Prioriza procurar o produto como codigo reduzido. Testa==2 pois no cdProduto vem 48 etc
		if (omProduto == null) {
			for (DwFolharap dwfolharap : dwFolha.getDwFolharaps()) {
				for (DwFolharapcom dwfolharapcom : dwfolharap.getDwFolharapcoms()) {
					char cdreduzido = '\0';
					if (cdProduto.length() > 1) {
						if (StringUtils.isNumeric(cdProduto)) {
							cdreduzido = (char) Integer.valueOf(cdProduto).intValue();
						}
					} else {
						cdreduzido = (char) cdProduto.charAt(0);
					}
					char cdreduzido2 = (char) dwfolharapcom.getIdredzproduto().byteValue();
					if ( cdreduzido == cdreduzido2) {
						log.info(idLog, 0, "Valores iguais");
						omProduto = dwfolharapcom.getOmProduto();
					}
				}
			}
		}
		
		if (cdProduto != null && cdProduto.equals("") == false && omProduto == null) {
			try {
				omProduto = produtoRN.getOmProduto(cdProduto);
			} catch (RegistroDesconhecidoException e) {
				omProduto = null;
			}
		} 

		// Se nao encontrou o produto, entao procurar o codigo na lista de produtos da CP
		if (omProduto == null) {
			for (PpCpproduto ppcpproduto : ppCp.getPpCpprodutos()) {
				if (ppcpproduto.getOmProduto().getCdProduto().equals(cdProduto)) {
					omProduto = ppcpproduto.getOmProduto();	
				}
			}
		}
		

		
		/* Se mesmo assim nao tiver encontrado o produto, verificar se o idReduzido eh 1. Se for e tiver apenas um produto
		 * utilizar esse 1 produto
		 */
		if (cdProduto != null && cdProduto.equals("1") && ppCp.getPpCpprodutos().size() == 1) {
			log.info(idLog, 0, "Vou utilizar o produto de ppcpproduto");
			for (PpCpproduto ppcpproduto : ppCp.getPpCpprodutos()) {
				omProduto = ppcpproduto.getOmProduto();
			}
		}
		
		Validate.notNull(omProduto, "Produto " + cdProduto + " a ser refugado nao encontrado");

		
		DwTCausa dwTCausa = null;
		if (cdCausa != null && cdCausa.trim().equals("") == false) {
			try {
				CausaRN causaRN = new CausaRN();
				causaRN.setDaoSession(this.getDao().getSession());
				dwTCausa = causaRN.getDwTCausa(cdCausa, omPt.getOmTppt());
			} catch (RegistroDesconhecidoException e) {
			}
		}
		
		DwTAcao dwTAcao = null;
		if (cdAcao != null && cdAcao.trim().equals("") == false) {
			try {
				AcaoRN acaoRN = new AcaoRN();
				acaoRN.setDaoSession(this.getDao().getSession());
				dwTAcao = acaoRN.getDwTAcao(cdAcao, omPt.getOmTppt());
			} catch (RegistroDesconhecidoException e) {
			}
		}
		
		DwConsolrelog dwConsolrelog = new DwConsolrelog();
		dwConsolrelog.setDwTRefugo(dwTRefugo);
		dwConsolrelog.setDthrRefugo(dthrRefugo);
		dwConsolrelog.setDwTAcao(dwTAcao);
		dwConsolrelog.setDwTCausa(dwTCausa);
		dwConsolrelog.setOmProduto(omProduto);
		dwConsolrelog.setOmPt(omPt);
		dwConsolrelog.setDwTRefugo(dwTRefugo);
		dwConsolrelog.setPcsAutoProducaorefugada(qtde);
		this.getDao().makePersistent(dwConsolrelog);


		consolidarRefugoTodosPeriodos(omPt, dwconsolpt, dwCalsems, ppCp, dwFolha, dwConsolrelog, omcfg, log, idLog, identacao, msevt.getDwPepro());

		
		// APos consolidar o refugo, atualizar a producao refugada em ppCpProduto
		for (PpCpproduto cpproduto : ppCp.getPpCpprodutos()) {
			if (dwConsolrelog.getOmProduto().equals(cpproduto.getOmProduto())) {
				BigDecimal producaoRefugada = cpproduto.getPcsProducaorefugada();
				if (producaoRefugada == null)
					producaoRefugada = BigDecimal.ZERO;
				
				producaoRefugada = producaoRefugada.add(dwConsolrelog.getPcsAutoProducaorefugada());
				cpproduto.setPcsProducaorefugada(producaoRefugada);
				getDao().makePersistent(cpproduto);
			}
		}
	}
}
