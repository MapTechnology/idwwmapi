package idw.model.rn.pdba;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.excessoes.CicloJaContabilizadoException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwPeproTemplate;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.rn.AcaoRN;
import idw.model.rn.CausaRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.RefugoRN;
import idw.model.rn.TurnoRN;
import idw.util.IdwLogger;
import idw.webservices.dto.PeriodoDTO;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.FalhaSnapshot;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.webservices.dto.IwsProdutoDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsRegistroBarCodeDTO;
import injetws.webservices.dto.IwsReleDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.model.rn.EventoRN;
import ms.model.rn.UpRN;
import ms.util.ConversaoTipos;

public class ProducaoPdbaMsEvtRN extends AbstractPdbaMsEvtRN{

	public IwsCicloDTO setTr_CicloInicioComInfo(String idUp, Date dthr, IwsDadosApontamentoDTO dados) {
		IwsCicloDTO retorno = null;
		
		retorno = new IwsCicloDTO();
		PTRN rn = new PTRN();
		CpRN crn = new CpRN();
		UpRN urn = new UpRN();
		try {
			rn.iniciaConexaoBanco();
			crn.setDao(rn.getDao());
			urn.setDaoPdba(rn.getDao());
			
			MsUp msup = urn.pesquisarMsUpPorIdUp(new BigDecimal(idUp));
			
			OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msup.getCdUp());

			IdwLogger log = new IdwLogger(msup.getCdUp());
			int idLog = log.getIdAleatorio();

			/* 
			 * Avaliar se o posto está com ciclo em aberto. Se estiver lancar como final de ciclo ao inves de inicio
			 */
			int tipoServico = ServicoFactory._INICIO_CICLO;
			if (msup.getMsEvtByIdEvtiniciociclo() != null)
				tipoServico = ServicoFactory._FIM_CICLO;
			
			MsEvt msevt =executarServico(rn.getDaoSession(), ompt.getCdPt(), null, dthr, null, dados, tipoServico, "setTr_CicloInicio " + DataHoraRN.getDataHoraAtualFormatada());
			if (msevt == null) {
				log.info(idLog, 0, "nao incluiu evento de inicio de ciclo para pt " + ompt.getCdPt());
			}
			PpCp ppcp = crn.pesquisarPpCpByNrDocCdPt(msevt.getNrop(), ompt.getCdPt());
			boolean isOpCumpriuPlanejado = ppcp.getSaldoAProduzir() <= 0d;

			// Obtem quantidade de ciclos da op
			OmPtcp omptcp = obtemPtCp(ompt, ppcp, rn.getDao());
			retorno.setCicloValido(!msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal())); // TRUE se o ciclo foi consolidado com sucesso
			retorno.setFinaizouOP(isOpCumpriuPlanejado);
			if (omptcp != null && omptcp.getQtCiclos() != null)
				retorno.setNumeroCiclosCont(ConversaoTipos.converterParaBigDecimal(omptcp.getQtCiclos())); // Se o CICLO foi validado com SUCESSo entao soma +1 aqui ao total de ciclos no TURNO
			else
				retorno.setNumeroCiclosCont(BigDecimal.ZERO);

			if (omptcp != null && omptcp.getQtCiclosregulagem() != null)
				retorno.setNumeroCiclosCont(retorno.getNumeroCiclosCont().add(new BigDecimal(omptcp.getQtCiclosregulagem())));

			retorno.setVlEficUltCiclo(0d);
		} catch (Exception e){
			e.printStackTrace();
			retorno.setCicloValido(false);
			retorno.setFinaizouOP(false);
			retorno.setNumeroCiclosCont(BigDecimal.ZERO);
			retorno.setVlEficUltCiclo(0d);
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}
	
	
	public IwsReleDTO setTr_CicloFim(String idUp, Date dthr, IwsDadosApontamentoDTO dados) throws FalhaSnapshot {
		IwsReleDTO retorno = null;
		
		// Soh executa o servico se o injet estiver desativado, pois o injet ja
		// chama o servico abaixo
		retorno = new IwsReleDTO();
		retorno.setDadosUltCiclo(new IwsCicloDTO());
		
		PTRN rn = new PTRN();
		CpRN crn = new CpRN();
		UpRN urn = new UpRN();
		OmPt ompt = null;
		try {
			rn.iniciaConexaoBanco();
			crn.setDao(rn.getDao());
			urn.setDaoPdba(rn.getDao());
			
			MsUp msup = urn.pesquisarMsUpPorIdUp(new BigDecimal(idUp));

			ompt = rn.pesquisarPtByCdPtStAtivo(msup.getCdUp());

			IdwLogger log = new IdwLogger(msup.getCdUp());
			int idLog = log.getIdAleatorio();
			
			log.info(idLog, 0, "setTrCicloFim para ompt.cdPt = " + ompt.getCdPt());

			/* Alessandre em 1-4-17 caso dados tenha infoadicional com o CB da passagem entao abaixo devemos enviar o evento de passagem ao inves
			 * de ciclo
			 */
			MsEvt msevt = executarServico(rn.getDaoSession(), ompt.getCdPt(), null, dthr, null, dados, ServicoFactory._FIM_CICLO, "setTr_CicloFim " + DataHoraRN.getDataHoraAtualFormatada());
			
			// msevt pode retornar null qdo o evento nao foi incluido
			if (msevt == null) {
				throw new CicloJaContabilizadoException();
			}
			
			PpCp ppcp = crn.pesquisarPpCpByNrDocCdPt(msevt.getNrop(), ompt.getCdPt());
			boolean isOpCumpriuPlanejado = ppcp.getSaldoAProduzir() <= 0d;

			// Obtem quantidade de ciclos da op
			OmPtcp omptcp = obtemPtCp(ompt, ppcp, rn.getDao());
			
			retorno.getDadosUltCiclo().setCicloValido(!msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal()));
			retorno.getDadosUltCiclo().setFinaizouOP(isOpCumpriuPlanejado);
			if (omptcp != null && omptcp.getQtCiclos() != null)
				retorno.getDadosUltCiclo().setNumeroCiclosCont(ConversaoTipos.converterParaBigDecimal(omptcp.getQtCiclos())); // Se o CICLO foi validado com SUCESSo entao soma +1 aqui ao total de ciclos no TURNO
			else
				retorno.getDadosUltCiclo().setNumeroCiclosCont(BigDecimal.ZERO);

			if (omptcp != null && omptcp.getQtCiclosregulagem() != null)
				retorno.getDadosUltCiclo().setNumeroCiclosCont(retorno.getDadosUltCiclo().getNumeroCiclosCont().add(new BigDecimal(omptcp.getQtCiclosregulagem())));

			retorno.getDadosUltCiclo().setVlEficUltCiclo(0d); //calcular a eficiencia por causa do andon);;
			retorno.seterro(false);
			retorno.setINF01("");
			retorno.setINF02("");
			retorno.setINF03("");
			retorno.setINF04("");
			retorno.setINF05("");
			retorno.settmpLimParNaoInf("");
			retorno.setvlRefEficUltCiclo("");

		} catch (CicloJaContabilizadoException e) {
			retorno.getDadosUltCiclo().setCicloValido(false);
			retorno.seterro(false);
			retorno.setINF01("");
			retorno.setINF02("");
			retorno.setINF03("");
			retorno.setINF04("");
			retorno.setINF05("");
			retorno.settmpLimParNaoInf("");
			retorno.setvlRefEficUltCiclo("");

		} catch (Exception e) {
			
			retorno.getDadosUltCiclo().setCicloValido(false);
			retorno.seterro(true);
			retorno.setINF01("");
			retorno.setINF02("");
			retorno.setINF03("");
			retorno.setINF04("");
			retorno.setINF05("");
			retorno.settmpLimParNaoInf("");
			retorno.setvlRefEficUltCiclo("");

			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		return retorno;
	}



	public boolean fimPlanejamento(String idUp, Date dthr,int batidas) {
		boolean retorno = true;
		
		PTRN rn = new PTRN();
		UpRN urn = new UpRN();
		EventoRN ern = new EventoRN();

		MsEvt msevt = null;
		try {
			
			rn.iniciaConexaoBanco();
			urn.setDaoPdba(rn.getDao());

			MsUp msup = urn.pesquisarMsUpPorIdUp(new BigDecimal(idUp));
			OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msup.getCdUp());

			
			if(batidas > 0){
				IwsDadosApontamentoDTO dados = new IwsDadosApontamentoDTO();
				dados.setBatidas(batidas);
				executarServico(rn.getDaoSession(), ompt.getCdPt(), null, dthr, null, dados, ServicoFactory._FIM_CICLO, "fimPlanejamento " + DataHoraRN.getDataHoraAtualFormatada());
			}

			
			msevt = executarServico(null, idUp, null, dthr, null, null, ServicoFactory._FINALIZA_OP, "fimPlanejamento " + DataHoraRN.getDataHoraAtualFormatada());
			
			
		} catch (Exception e){
			e.printStackTrace();
			retorno = false;
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		
		try {
			// Se ms_evt for criado, aguardar um tempo o stEvt ser consolidado com sucesso ou fracasso
			if (msevt != null) {
				// avalia o tempo transcorrido acima de 1min cancelar
				Date dthri = DataHoraRN.getDataHoraAtual();

				MsEvt msevtAux;
				ern.iniciaConexaoBanco();
				do {
					msevtAux = ern.pesquisarMsEvtById(msevt.getIdEvt());

					if (msevtAux.getStEvt().compareTo(BigDecimal.ZERO) != 0) {
//						System.out.println("msevt.stEvt = " + msevtAux.getStEvt());
						retorno = !msevtAux.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal());
						break;
					}
					Date dthrf = DataHoraRN.getDataHoraAtual();
					if (DataHoraRN.getQuantidadeSegundosNoPeriodo(dthri, dthrf) > 5) {
						retorno = false;
						break;
					}
					
					// Pegar atualizacao de MsEvt

//					System.out.println(msevtAux.getIdEvt() + " - msevt.stevet = " + msevtAux.getStEvt());

				} while (msevtAux.getStEvt().compareTo(BigDecimal.ZERO) == 0 );
				
			} else {
//				System.out.println("msevt retornou null");
				retorno = false;
			}
			
			
//			System.out.println("retorno fim planejamento " + retorno);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ern.finalizaConexaoBanco();
		}
		
		return retorno;
	}

//
//	public static void main(String[] args) {
//		String idUp = "|00051";
//		IwsCpDTO dto = new IwsCpDTO();
//		Date dthr = DataHoraRN.getDataHoraAtual();
//		
//		dto.setStCriacaoCP("5");
//		dto.setCdmolde("004503");
//		dto.setCdestrutura("0001");
//		dto.setQtciclos("100");
//		dto.setProducaoPlanejada("100");
//		
//		/* inicializa thread (/
//		 * 
//		 */
//		MSThread msthread = new MSThread();
//		msthread.start();
//		
//		Stubedelegate.getInstancia().setMsthread(msthread);
//		UtilsThreads.pausaNaThread(20000);
//		
//		IdwFacade.getInstancia().setIDWAtivo(true);
//		
//		IwsCpDTO ret = IdwFacade.getInstancia().getTr_planejamento(idUp, dto, dthr);
//		
//		if (ret != null)
//			System.out.println(ret);
//	}
	public IwsCpDTO getTr_planejamento(String idUp, IwsCpDTO cpEntrada,Date dthr){
		IwsCpDTO retorno = null;
		
		retorno = new IwsCpDTO();

		PTRN rn = new PTRN();
		CpRN crn = new CpRN();
		FolhaRN frn = new FolhaRN();
		UpRN urn = new UpRN();

		try {
			rn.iniciaConexaoBanco();
			crn.setDao(rn.getDao());
			frn.setDao(rn.getDao());
			urn.setDaoPdba(rn.getDao());
			
			MsUp msup = null;
			try {
				msup = urn.pesquisarMsUpPorIdUp(new BigDecimal(idUp)); 
			} catch (Exception e) {
				msup = null;
			}
			if (msup == null)
				msup = urn.pesquisarMsUpPorCdUpStAtivo(idUp);

			OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msup.getCdUp());
			
			IdwLogger log = new IdwLogger(msup.getCdUp());
			int idLog = log.getIdAleatorio();

			log.info(idLog, 0, "getTr_planejamento");
			
			// Redefine o tipo da sessao da sessao do Injet para ficar igual ao cadastro do IDW
			
			cpEntrada.setStCriacaoCP(ConversaoTipos.converterParaString(ompt.getTpSessao()));

			MsEvt msevt = executarServico(rn.getDaoSession(), ompt.getCdPt(), dthr, ServicoFactory._NOVA_OP, cpEntrada);
			
			// Pode ocorrer de nao ter msevt quando o tipo da sessao for por molde e nao exisitr uma op pra entrar
			if (msevt == null)
				throw new SemPlanejamentoException();
			
			PpCp ppcp = crn.pesquisarPpCpByNrDocCdPt(msevt.getNrop(), ompt.getCdPt());
			boolean isOpCumpriuPlanejado = ppcp.getSaldoAProduzir() <= 0d;

			// Obtem quantidade de ciclos da op
			OmPtcp omptcp = obtemPtCp(ompt, ppcp, rn.getDao());

			String cdMolde = "";
			String cdEstrutura = "0001"; // avaliar se pode ser fixo

			if (ppcp.getDwFolha().getDwFolharaps().isEmpty() == false) {
				for (DwFolharap rap : ppcp.getDwFolha().getDwFolharaps()) {
					cdMolde = rap.getDwRap().getCdRap();
				}
			} else {
				cdMolde = ppcp.getDwFolha().getCdFolha();
			}
			
			retorno.setCdmolde(cdMolde);
			retorno.setCdestrutura(cdEstrutura);
			retorno.setCdmoldeestendido(retorno.getCdmolde());
			retorno.setcdParadaSemProd("");
			retorno.setCdProduto("");

			retorno.setCicloPadrao(frn.getCicloPadraoFromDwFolha(ppcp.getDwFolha(), ompt).floatValue());

			retorno.setCfgPercToleranciaSinalCiclo(0f);
			retorno.setCfgTamanhoUmPacoteCiclos(0f);
			retorno.setCfgTolerTmpCicloParAuto(0l);
			try {
				retorno.setCfgPercTmpCicloParAuto(frn.getCicloMaximoFromDwFolha(ppcp.getDwFolha(), ompt).floatValue());
			} catch (SemCicloPadraoException e) {
				retorno.setCfgPercTmpCicloParAuto(200f);
			}

			
			retorno.setDthrIPlanejamento(ppcp.getDthrInicio());

			retorno.setIsApntSAPAtivo("0");
			retorno.setIsBloqueioParadaSemConexao(false);
			retorno.setIsOpcomloteInsumo(false);
			retorno.setIsOpSemColeta(true);
			retorno.setIsProducaoValida(true);
			retorno.setIsSGBDOnline(true);
			
			/* O parametro abaixo qdo setado fara o coletor trabalhar com pacote de ciclo.
			 * No Idw essa informacao vira da folha de processo
			 */
			Integer pacoteCiclo = null;
			try {
				pacoteCiclo = frn.getPacoteCicloFromDwFolha(ppcp.getDwFolha(), ompt);
			} catch (SemPacoteOuFatorException e) {
				pacoteCiclo = null;
			}
			
			if (pacoteCiclo != null)
				retorno.setCfgTamanhoUmPacoteCiclos(pacoteCiclo.floatValue());

			retorno.setNrop(ppcp.getNrop());
			retorno.setNropestendido(retorno.getNrop());
			retorno.setPlanClose(isOpCumpriuPlanejado);
			retorno.setProducaoPlanejada(ConversaoTipos.converteParaString(ppcp.getQtPecasProduzir(), 0));
			
			List<IwsProdutoDTO> produtos = new ArrayList<>();
			
			for (PpCpproduto cpprod : ppcp.getPpCpprodutos()) {
				// Procura o codigo reduzido do produto na folha
				DwFolharapcom com = null;
				try {
					com = frn.getFolharapcom(ppcp.getDwFolha(), cpprod.getOmProduto());
				} catch (RegistroDesconhecidoException e) {
					com = null;
				}
				
				
				IwsProdutoDTO produto = new IwsProdutoDTO();
				produto.setCdProduto(cpprod.getOmProduto().getCdProduto());
				if (com != null && com.getIdredzproduto() != null)
					produto.setCdReduzido(ConversaoTipos.converterParaString(com.getIdredzproduto()));
				else
					produto.setCdReduzido("1");
				
				produto.setDsProduto(cpprod.getOmProduto().getDsProduto());
				produto.setProducaoPlanejada(cpprod.getPcsProducaoplanejada().floatValue());
				produto.setProducaoLiquida(cpprod.getProducaoLiquida().floatValue());
				produtos.add(produto);
			}			
			
			retorno.setProdutos(produtos);
			
			retorno.setQtcartoes("");
			retorno.setQtcavidades("");
			
			
			if (omptcp != null && omptcp.getQtCiclos() != null)
				retorno.setQtciclos(omptcp.getQtCiclos().toString()); // Se o CICLO foi validado com SUCESSo entao soma +1 aqui ao total de ciclos no TURNO
			else
				retorno.setQtciclos("0");

			retorno.setStApntSAP("");
			retorno.setStCriacaoCP("");
			retorno.setTxtMensagem("");
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setCdestrutura("");
			retorno.setCdmolde("");
			retorno.setCdmoldeestendido("");
			retorno.setcdParadaSemProd("");
			retorno.setCdProduto("");
			retorno.setCfgPercTmpCicloParAuto(0f);
			retorno.setCfgPercToleranciaSinalCiclo(0f);
			retorno.setCfgTamanhoUmPacoteCiclos(0f);
			retorno.setCfgTolerTmpCicloParAuto(0l);
			retorno.setCicloPadrao(0f);
			retorno.setDthrIPlanejamento(null);
			retorno.setIsApntSAPAtivo("");
			retorno.setIsBloqueioParadaSemConexao(false);
			retorno.setIsOpcomloteInsumo(false);
			retorno.setIsOpSemColeta(false);
			retorno.setIsProducaoValida(false);
			retorno.setIsSGBDOnline(true);
			
			retorno.setNrop("");
			retorno.setNropestendido("");
			retorno.setPlanClose(false);
			retorno.setProducaoPlanejada("");
			retorno.setProdutos(null);
			retorno.setQtcartoes("");
			retorno.setQtcavidades("");
			retorno.setQtciclos("");
			retorno.setStApntSAP("");
			retorno.setStCriacaoCP("");
			retorno.setTxtMensagem("OP DESCONHECIDA");
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	
	
	/*
	public static void main(String[] args) {
		ProducaoPdbaMsEvtRN rn = new ProducaoPdbaMsEvtRN();
		rn.getTr_ValidaCodRefugo("000004", "1");
	}*/

	public IwsRefugoDTO getTr_ValidaCodRefugo(String cdMaquina, String cdRefugo){
		
		IwsRefugoDTO retorno = null;

		retorno = new IwsRefugoDTO();
		RefugoRN rn = new RefugoRN();
		try {
			rn.iniciaConexaoBanco();
			DwTRefugo dwtrefugo = rn.getDwTRefugoByMsUpCdRefugo(cdMaquina, cdRefugo);
			
			// se nao encontrar usar o padrao 
			if (dwtrefugo != null) {
				retorno.setCdRefugo(dwtrefugo.getCdTrefugo());
				retorno.setIdRefugo(dwtrefugo.getIdTrefugo().intValue());
				retorno.setIsAbate(true);
				retorno.setIsConverte(false);
				retorno.setIsRefugoValido(true);
				retorno.setPedeAcao(dwtrefugo.getIsRequerAcao());
				retorno.setPedeCausa(dwtrefugo.getIsRequerCausa());
				retorno.setPedeJust(false);
				retorno.setStRefugoCau((short) 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setCdRefugo("");
			retorno.setIsRefugoValido(false);
		} finally {
			rn.finalizaConexaoBanco();
		}

		return retorno;
	}

	public static void main(String[] args) {
		RefugoRN rn = new RefugoRN();
		rn.iniciaConexaoBanco();
		MapQuery q = new MapQuery(rn.getDaoSession());
		q.append("select a");
		q.append("from DwFolharapcom a");
		String idRdzProduto = "a";
		List<DwFolharapcom> lista = q.list();
		Byte emByte = (byte) idRdzProduto.charAt(0);
		for (DwFolharapcom com : lista) {
			if (com.getIdredzproduto().equals(emByte))
				System.out.println(com.getIdredzproduto() + " = " + emByte);
		}
		rn.finalizaConexaoBanco();
	}
	
	public IwsRefugoDTO setTr_LancaEventoRefugo(String cdRefugo,String cdCausa,String cdAcao,String qtdeRefugada, String idUp,String idRdzProduto,Date dthrAtual){
		
		IwsRefugoDTO retorno = null;
		retorno = new IwsRefugoDTO();

		RefugoRN rn = new RefugoRN();
		// Vereificar se o produto informado é valido para a folha

		try {
			rn.iniciaConexaoBanco();
			
			PTRN prn = new PTRN(rn.getDao());
			UpRN mrn = new UpRN(rn.getDao(), null);

			
			MsUp msup = null;
			OmPt ompt = null;

			BigDecimal idup;
			try {
				idup = new BigDecimal(idUp);
				msup = mrn.pesquisarMsUpPorIdUp(idup);
			} catch (Exception e){
				msup = null;
			}
			
			if (msup == null)
				msup = mrn.pesquisarMsUpPorCdUpStAtivo(idUp);
			
			try {
				ompt = prn.getOmPt(msup.getCdUp());
			} catch (RegistroDesconhecidoException e) {
				e.printStackTrace();
			}
			
			/* Se a causa for preenchida avaliar se existe
			 * 
			 */
			if (cdCausa != null && cdCausa.trim().equals("") == false) {
				CausaRN crn = new CausaRN(rn.getDao());
				DwTCausa dwt = crn.getDwTCausa(cdCausa);
				if (dwt == null) {
					retorno.setIsRefugoValido(false);
					return retorno;
				}
			}
			
			
			/* Se a acao for preenchida avaliar se existe
			 * 
			 */
			if (cdAcao != null && cdAcao.trim().equals("") == false) {
				AcaoRN arn = new AcaoRN(rn.getDao());
				DwTAcao dwtacao = arn.getDwTAcao(cdAcao);
				
				if (dwtacao == null) {
					retorno.setIsRefugoValido(false);
					return retorno;
				}
			}
			
			
			/*
			 * Verificar se existe produção suficiente na hora
			 */

			DwFolha dwfolha = null;
			
			if (ompt != null && ompt.getPpCp() != null)
				dwfolha = ompt.getPpCp().getDwFolha();
			
			boolean isEncontrouProduto = false;
			String cdproduto = null;
			
			if (dwfolha != null) {
				for (DwFolharap rap : dwfolha.getDwFolharaps()) {
					for (DwFolharapcom com : rap.getDwFolharapcoms()) {
						// Se tiver mais de uma posicao eh pq a string esta enviando o valor numerico do caracter
						char cdreduzido;
						if (idRdzProduto.length() > 1) {
							cdreduzido = (char) Integer.valueOf(idRdzProduto).intValue();
						} else {
							cdreduzido = (char) idRdzProduto.charAt(0);
						}
						
						char cdreduzido2 = (char) com.getIdredzproduto().byteValue();
						if ( cdreduzido == cdreduzido2) {
							isEncontrouProduto = true;
							cdproduto = com.getOmProduto().getCdProduto();
						}
					}
				}
				
				// Se nao encontrou em dwfolharap, avaliar se o produto esta em dwfolhaiac
				if (isEncontrouProduto == false) {
					if (dwfolha.getDwFolhaiacs().isEmpty() == false) {
						isEncontrouProduto = true;
						cdproduto = dwfolha.getDwFolhaiacs().iterator().next().getOmProduto().getCdProduto();
					}
				}
			} else
				isEncontrouProduto = true;
			
			/* Avaliar se existe produção suficiente na hora para efetuar o refugo
			 * 
			 */
			DwPepro dwpepro = new DwPepro();
			
			if (ompt.getIsCipAtivado() != null && ompt.getIsCipAtivado()) {
				dwpepro.setIdPepro(DwPeproTemplate.Type.CONTROLE_REINICIO_DE_PROCESSO.getId());
			} else {
				dwpepro.setIdPepro(DwPeproTemplate.Type.NORMAL.getId());
			}
			
			TurnoRN turnoRN = new TurnoRN(rn.getDao());

			List<DwCalsem> dwCalsems = turnoRN.getCalendarioSemanalComTurnosIndefinidosParaPt(ompt, dthrAtual);
			
			TurnoAtualDTO turnoAtualDTO = turnoRN.getTurnoAtualDTO(dwCalsems, dthrAtual);
			ConsolidaRN crn = new ConsolidaRN(rn.getDao());
			PeriodoDTO periodoDTO = null;
			periodoDTO = crn.obtemPeriodoDaHoraAtual(dthrAtual);
			

			List<DwConsolid> ids = crn.getConsolIdHoraLista(
					periodoDTO.getDtHrInicio(), 
					ompt.getIdPt(), 
					ompt.getPpCp().getIdCp(), 
					null, 
					turnoAtualDTO, 
					dwpepro);

			BigDecimal producaoLiquida = BigDecimal.ZERO;
			for (DwConsolid id : ids) {
				for (DwConsol consol : id.getDwConsols()) {
					for (DwConsolpr consolpr : consol.getDwConsolprs()) {
						if (consolpr.getOmProduto().getCdProduto().equals(cdproduto)) {
							producaoLiquida = producaoLiquida.add(consolpr.getPcsProducaoLiquida());
						}
					}
				}
			}
			// Se nao tiver producao suficiente na hora entao nao pode refugar
			if (producaoLiquida.equals(BigDecimal.ZERO) || producaoLiquida.compareTo(ConversaoTipos.converterParaBigDecimal(qtdeRefugada)) < 0) {
				isEncontrouProduto = false;
			}
			
			MsEvt msevt = null;
			
			if (isEncontrouProduto)
				msevt = executarServico(rn.getDaoSession(), cdRefugo, cdCausa, cdAcao, qtdeRefugada, idUp, idRdzProduto, dthrAtual);
			
			if (msevt == null || msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal())) {
				retorno.setIsRefugoValido(false);
				retorno.setCdRefugo("");
			} else {
				retorno.setCdRefugo(cdRefugo);
				retorno.setDthrUltRefugo(msevt.getDthrEvento());
				retorno.setIsRefugoValido(true);
				// Alessandre 02-01-17 os parametros abaixo acho q nao sao necessarios para o CPFlex, confirmar com beto
				//retorno.setIdReduzidaProd(Idreduzida);
				//retorno.setIdRefugo(idRefugo);
				//retorno.setIdRevisao(idRevisao);
				//retorno.setIsAbate(isAbate);
				//retorno.setIsConverte(isConverte);
				//retorno.setMilissegundos(Valor);
				//retorno.setPedeAcao(pedeAcao);
				//retorno.setPedeCausa(pedeCausa);
				//retorno.setPedeJust(pedeJust);
				//retorno.setStRefugoCau(stRefugoCau);
			}
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setIsRefugoValido(false);
			retorno.setCdRefugo("");
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}


	public IwsRefugoDTO getInfoUltimoRefugo(String idUp){
		IwsRefugoDTO retorno = null;
		retorno = new IwsRefugoDTO();

		RefugoRN rn = new RefugoRN();

		try {
			rn.iniciaConexaoBanco();
			
			retorno = rn.getInfoUltimoRefugo(idUp);
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setIsRefugoValido(false);
			retorno.setCdRefugo("");
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}

	public boolean setTr_ApagaUltimoRefugo(String cdRefugo,	String idRdzProduto,Date DthrUltRefugo,String milisec,String IdUp,Date DataHrAtual){
		boolean retorno = false;
		
		UpRN rn = new UpRN();
		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(IdUp);
		IdwLogger log = new IdwLogger(icupdto.getUpDTO().getCd_up());
		int idLog = log.getIdAleatorio();

		try {
			rn.iniciaConexaoBanco();
			
			EventoColetado evento = new EventoColetado();
			evento.setIdentacao(0);
			evento.setDthrEvento(DataHrAtual);
			evento.setIcUpDTO(icupdto);


			evento.setLog(log);
			evento.setIdLog(idLog);
			
			retorno = rn.apagaUltimoRefugo(evento);
			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		} finally {
			rn.finalizaConexaoBanco(log);
		}
		return retorno;
	}


	// Metodo chamado pelo INOVA para registro dos codigos de barras lidos
	// Esse metodo deve gerar um evento do tipo PASSAGEM em ms_evt atraves do servicoPassagem
	public boolean setRegistroBarCode(IwsRegistroBarCodeDTO barcodeDTO){
		System.out.println("setRegistroBarCode chamado");
		// Inicializa evento
		EventoColetado evento = new EventoColetado();
		evento.setDthrEvento(barcodeDTO.getDthrleitura());
		evento.setCb(barcodeDTO.getBarcode());
		evento.setTipoEvento(ServicoFactory._PASSAGEM);
		evento.setChamarInjetWs(false);
		// Alessandre: em 22-2-13 a linha abaixo nao pode ser comentada pois eh
		// ela que encontra o IcUp necessario para a linha seguinte
		evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(barcodeDTO.getIdlinha()));
		evento.setLog(evento.getIcUpDTO().getIc().getLog());
		evento.setIdLog(evento.getLog().getIdAleatorio());
		evento.setIdentacao(0);
		evento.setOrigem("setRegistroBarCode " + DataHoraRN.getDataHoraAtualFormatada());

		// Inicializa MensagemRecebida
		MensagemRecebida mensagem = new MensagemRecebida(evento);
		mensagem.setLog(evento.getLog());
		mensagem.setIdLog(evento.getIdLog());
		mensagem.setIdentacao(evento.getIdentacao());
		
		
		// Alessandre: por algum motivo a linha abaixo estava comentada,
		// descomentei em 04-12-12 para funcionar na AmazonAco
		mensagem.setDadosIcDTO(Stubedelegate.getInstancia().getMsthread().getIcDTOdaListaByCdUp(barcodeDTO.getIdlinha()));

		// Chama o servico de alerta
		MsEvt msevt;
		try {
			msevt = ServicoFactory.getInstancia().executaServico(null, mensagem);
		} catch (ServicoFalhouException e) {
			msevt = null;
		}
		return msevt != null;
	}

}
