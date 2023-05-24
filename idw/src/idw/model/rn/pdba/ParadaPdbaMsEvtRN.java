package idw.model.rn.pdba;

import java.math.BigDecimal;
import java.util.Date;

import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwTParada;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsPtColeta;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.MsEvtTemplate;
import idw.model.rn.CpRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.ParadaRN;
import idw.util.IdwLogger;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.webservices.dto.IwsParadaDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.IcUpDTO;
import ms.model.rn.UpRN;
import ms.util.ConversaoTipos;

public class ParadaPdbaMsEvtRN extends AbstractPdbaMsEvtRN{

	public IwsCicloDTO setTr_paradaInicio(String idUp, Date dthrInicio, Boolean isParadaAutomatica, Boolean isParadaPersistente, Boolean isParPeriodSemConex) {
		IwsCicloDTO retorno = null;
		
		// Soh chama o servico de inicio de parada se o injet estiver
		// desativado, pois se estiver ativo o mesmo ja chama o inicio parada
		retorno = new IwsCicloDTO();
		PTRN rn = new PTRN();
		CpRN crn = new CpRN();
		try {
			rn.iniciaConexaoBanco();
			crn.setDao(rn.getDao());
			// Alessandre-tanto o inicio da parada qto o final da para estao
			// chamando o mesmo servico, e o servico ira executar inicio ou fim
			// da parada dependendo do
			// status de funcionamento da maquina. Encontrar uma forma de dizer
			// q a maq esta trabalhando
			// aqui para q o servico inicio uma parada
			IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(idUp);
			if (icupdto == null)
				System.out.println("setTr_paradaInicio - nao encontrou icupdto " + idUp);
			
			icupdto.getUpDTO().setUpTrabalhando(true);
			
			/* Se parada fecha ciclo, entao lancar um evento de final de ciclo antes de abrir uma nova parada.
			 * Tanto o servico de fim de parada quanto inicio de ciclo devem 
			 * 
			 */
			OmPt ompt = rn.getOmPt(icupdto.getUpDTO().getCd_up());
			
			IdwLogger log = new IdwLogger(ompt.getCdPt());
			int idLog = log.getIdAleatorio();
			
			log.info(idLog, 0, "setTr_paradaInicio");
			
			// Obtem dwrt para saber o posto está parado ou produzindo. Se estiver produzindo o fim de ciclo poderá ser lancado
			// Mas se estiver parada nao lancar um final de ciclo
			
			UpRN urn = new UpRN(rn.getDao(), null);
			MsUp msup = urn.pesquisarMsUpPorCdUpStAtivo(ompt.getCdPt());
			MsPtColeta ptcoleta = ompt.getMsPtColeta();

			/* Se o posto estiver parado por regulagem, esse inicio de parada deve ser descartado
			 * 
			 */
			if (ptcoleta.getIsParada() != null && ptcoleta.getIsParada() && ptcoleta.getDwTParada() != null && ptcoleta.getDwTParada().getIsRegulagem() != null && ptcoleta.getDwTParada().getIsRegulagem()) {
				retorno.setCicloValido(false);
				retorno.setFinaizouOP(false);
			} else {
				
				// O Fim de ciclo deve ser lancado se a parada fechar ciclo e se tiver um ciclo em aberto
				if (ompt.getIsParadaFechaciclo() != null && ompt.getIsParadaFechaciclo() && ptcoleta.getIsParada() != null && ptcoleta.getIsParada() == false){
					
					/* Alessandre em 08-06-17 Se o ciclo fechado abrutamente for com um tempo inferior ao minimo, entao não lancar evento de fim
					 * de ciclo
					 */
					FolhaRN frn = new FolhaRN(rn.getDao());
					BigDecimal cicloMinimo = null;
					try {
						cicloMinimo = frn.getCicloMinimoFromDwFolha(ompt.getPpCp().getDwFolha(), ompt);
					} catch (SemCicloPadraoException e) {
						cicloMinimo = null;
					}
					if (cicloMinimo == null)
						cicloMinimo = BigDecimal.ZERO;
					
					int tempoCiclo = 0;
					if (msup.getMsEvtByIdEvtiniciociclo() != null)
						tempoCiclo = DataHoraRN.getQuantidadeSegundosNoPeriodo(msup.getMsEvtByIdEvtiniciociclo().getDthrEvento(), dthrInicio);
					if (tempoCiclo > cicloMinimo.intValue()) {
						log.info(idLog, 0, "Lancando ciclo de " + tempoCiclo + " pois eh superior ao ciclo minimo " + cicloMinimo + " inicio "+ DataHoraRN.dateToStringYYYYMMDDHHMMSS(msup.getMsEvtByIdEvtiniciociclo().getDthrEvento()) + " - " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrInicio));
						MsEvt msevtFimCiclo = executarServico(rn.getDaoSession(), idUp, null, dthrInicio, null, null, ServicoFactory._FIM_CICLO, "setTr_paradaInicio " + DataHoraRN.getDataHoraAtualFormatada());
						
						// Obtem saldo da op
						PpCp ppcp = crn.pesquisarPpCpByNrDocCdPt(msevtFimCiclo.getNrop(), ompt.getCdPt());
						
						// Obtem quantidade de ciclos da op
						OmPtcp omptcp = obtemPtCp(ompt, ppcp, rn.getDao());
						retorno.setCicloValido(!msevtFimCiclo.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal())); // TRUE se o ciclo foi consolidado com sucesso
						retorno.setFinaizouOP(false); // TRUE se a producao da OP foi concluida
						if (omptcp != null && omptcp.getQtCiclos() != null)
							retorno.setNumeroCiclosCont(ConversaoTipos.converterParaBigDecimal(omptcp.getQtCiclos())); // Se o CICLO foi validado com SUCESSo entao soma +1 aqui ao total de ciclos no TURNO
						else
							retorno.setNumeroCiclosCont(BigDecimal.ZERO);
						retorno.setVlEficUltCiclo(0d); // Esse valor foi setado com a eficiencia de ciclo medio
					} else {
						log.info(idLog, 0, "Ciclo " + tempoCiclo + " finalizado por parada ignorado pois eh inferior ao ciclo minimo " + cicloMinimo);
					}
				}
				
				// Se estiver parado, fechar a parada antes de abrir uma nova
				if (ptcoleta.getIsParada() != null && ptcoleta.getIsParada()) {
					executarServico(rn.getDaoSession(), idUp, null, dthrInicio, null, null, ServicoFactory._FIM_PARADA, "setTr_paradaInicio " + DataHoraRN.getDataHoraAtualFormatada());
				}
				
				MsEvt msevt = executarServico(rn.getDaoSession(), idUp, null, dthrInicio, null, null, ServicoFactory._INICIO_PARADA, "setTr_paradaInicio " + DataHoraRN.getDataHoraAtualFormatada());
	
				// Se a parada nao fechar ciclo o q retornar ao coletor?????
				// Obtem saldo da op
				if (msevt != null && (ompt.getIsParadaFechaciclo() == null || (ompt.getIsParadaFechaciclo() != null && ompt.getIsParadaFechaciclo() == false) ) ) {
					PpCp ppcp = crn.pesquisarPpCpByNrDocCdPt(msevt.getNrop(), ompt.getCdPt());
					// Obtem quantidade de ciclos da op
					OmPtcp omptcp = obtemPtCp(ompt, ppcp, rn.getDao());
		
					// Se a parada nao fechar ciclo, entao o q retornar ao coletor?????
					retorno.setCicloValido(false); // TRUE se o ciclo foi consolidado com sucesso
					retorno.setFinaizouOP(false); // TRUE se a producao da OP foi concluida
	
					if (omptcp != null && omptcp.getQtCiclos() != null)
						retorno.setNumeroCiclosCont(ConversaoTipos.converterParaBigDecimal(omptcp.getQtCiclos())); // Se o CICLO foi validado com SUCESSo entao soma +1 aqui ao total de ciclos no TURNO
					else
						retorno.setNumeroCiclosCont(BigDecimal.ZERO);
					retorno.setVlEficUltCiclo(0d); // Esse valor foi setado com a eficiencia de ciclo medio
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
	

	
	public boolean setTr_paradaFim(String idUp, Date dthrFim) {
		boolean retorno = true;

//		PTRN rn = new PTRN();
		// soh chama o servico de fim parada se o injet estiver desativado, pois
		// se estiver ativo ele ja chama o servico
		try {
			// Alessandre-tanto o inicio da parada qto o final da para estao
			// chamando o mesmo servico, e o servico ira executar inicio ou fim
			// da parada dependendo do
			// status de funcionamento da maquina. Encontrar uma forma de dizer
			// q a maq esta trabalhando
			// aqui para q o servico inicio uma parada
			IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(idUp);

			icupdto.getUpDTO().setUpTrabalhando(false);

			IdwLogger log = new IdwLogger(icupdto.getUpDTO().getCd_up());
			int idLog = log.getIdAleatorio();
			

			MsEvt msevt = executarServico(null, idUp, null, dthrFim, null, null, ServicoFactory._FIM_PARADA, "setTr_paradaFim " + DataHoraRN.getDataHoraAtualFormatada());
			
			retorno = !msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal());

			log.info(idLog, 0, "setTr_paradaFim com retorno = " + retorno + " para idup=" + idUp + " em " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrFim));

			/* Alessandre em 17-06-20 comentei esse trecho pois não esta fazendo nada alem de pesuquisar o ompt
			rn.iniciaConexaoBanco();
			OmPt ompt = rn.getOmPt(icupdto.getUpDTO().getCd_up());

			/* Se a parada fechar o ciclo entao um inicio de ciclo deve ser lancado para que o proximo ciclo
			 * nao incorpore tambem o ciclo anterior
			// O Fim de ciclo deve ser lancado se a parada fechar ciclo e se tiver um ciclo em aberto
			if (ompt.getIsParadaFechaciclo() != null && ompt.getIsParadaFechaciclo()) {
				// Aparentemente o inova ja esta mandando esse incio de ciclo
			}
			 */

			
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		} finally {
			//rn.finalizaConexaoBanco();
		}

		return retorno;
	}
	

	public boolean setTr_paradaMotivo(String idUp, Date dthr, String idParada,
			String idAcao, String idCausa, String idJustificativa,
			String idTecnicoResponsavel, String idTecnicoUm,
			String idTecnicoDois, String idLocal, boolean isParadaRegulagem, String tipoParPreConfig,int batidas){
		
		boolean retorno = true;
		
		PTRN rn = new PTRN();
		UpRN urn = new UpRN();

		try {
			rn.iniciaConexaoBanco();
			urn.setDaoPdba(rn.getDao());

			MsUp msup;
			try {
				msup = urn.pesquisarMsUpPorIdUp(new BigDecimal(idUp));				
			} catch (Exception e) {
				msup = urn.pesquisarMsUpPorCdUpStAtivo(idUp);
			}
			OmPt ompt = rn.pesquisarPtByCdPtStAtivo(msup.getCdUp());
			
			/* Se for uma parada de regulagem o ciclco deve ser finalizado
			 * 
			*/
			if(isParadaRegulagem && batidas > 0){
				IwsDadosApontamentoDTO dados = new IwsDadosApontamentoDTO();
				dados.setBatidas(batidas);
				dados.setInfoAdicional("FIMPACOTE"); // Estou usando esse campo para evitar que o ServicoFimCiclo retira a máquina de parada
				// A data e hora para lancamento do fim do ciclo deve ser igual ao inicio da
				// parada e nao do motivo da parada
				MsPtColeta pcoleta = ompt.getMsPtColeta();
				Date dthrIparada = dthr;
				if (pcoleta != null)
					dthrIparada = pcoleta.getDthrIparada();
				executarServico(rn.getDaoSession(), ompt.getCdPt(), null, dthrIparada, null, dados, ServicoFactory._FIM_CICLO, "setTr_paradaMotivo " + DataHoraRN.getDataHoraAtualFormatada());
			}
	
			
			MsEvt msevt = executarServico(null, idUp, idParada, dthr, null, ServicoFactory._MOTIVO_PARADA, idParada, idAcao, idCausa, idJustificativa, idTecnicoUm, idTecnicoDois, idTecnicoResponsavel, null, "setTr_paradaMotivo " + DataHoraRN.getDataHoraAtualFormatada());
			retorno = msevt != null && !msevt.getStEvt().equals(MsEvtTemplate.StEvt.REJEITADO.getValueBigDecimal());
		
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}

	public static void main(String[] args) {
		ParadaPdbaMsEvtRN rn = new ParadaPdbaMsEvtRN();
		IwsParadaDTO dto = rn.getTr_TabParadaSetaCod("15337_N38", "0");
		System.out.println(dto.getIsPodeAlterarCdPar());
//		rn.setTr_paradaMotivo("15337_N38", new Date(), "2", null, null, null, null, null, null, null, false, null, 0);
//		System.out.println("1234567890".substring(0, 20));
	}

	public IwsParadaDTO getTr_TabParadaSetaCod(String idUp,String cdParada){
		IwsParadaDTO retorno = null;

		retorno = new IwsParadaDTO();

		ParadaRN rn = new ParadaRN();
		try {
			rn.iniciaConexaoBanco();
			DwTParada dwtparada = null;
			try { 
				//nao aceitar parada sem peso para op crita
				dwtparada = rn.getDwTParadaByMsUpCdParada(new BigDecimal(idUp), cdParada);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (dwtparada == null)
				dwtparada = rn.getDwTParadaByMsUpCdParada(idUp, cdParada);

			if (dwtparada != null) {
				retorno.setCdParada(dwtparada.getCdTparada());
				if (dwtparada.getDsTparada().trim().length() > 40)
					retorno.setDsParada(dwtparada.getDsTparada().trim().substring(0, 40));
				else
					retorno.setDsParada(dwtparada.getDsTparada().trim());
				
				retorno.setIdParada(dwtparada.getIdTparada().toString());
				/* Alessandre em 27-04-17 o isRegulagem abaixo estava sempre false. O comentario era que se fosse true
				 * iria impactar no ihm desktop, mas verifiquei que o ihm desktop nao utiliza esse metodo
				 * Por isso voltei o uso do isRegulagem em dwtparada
				 */
				retorno.setIsRegulagem(dwtparada.getIsRegulagem());
				retorno.setIsPedeAcao(dwtparada.getIsRequerAcao());
				retorno.setIsPedeCausa(dwtparada.getIsRequerCausa());
				retorno.setIsPedeFechamento(dwtparada.getIsRegulagem());
				retorno.setIsPedeJust(dwtparada.getIsRequerJust());
				retorno.setIsPedeLocal(false);
				retorno.setIsPeriodoSemConexao(false);
				retorno.setIsPersistente(false);
				retorno.setIsPesaCalculo(dwtparada.getIsPesa());
				retorno.setIsPesaMeanTime(false);
				retorno.setIsPodeAlterarCdPar(dwtparada.getIsPermitecorrecao() != null && dwtparada.getIsPermitecorrecao() == true);
				retorno.setIsTecnicoArea(false);
				retorno.setQtMinimaTecnicos(0);
				if (dwtparada.getQtTec() != null && dwtparada.getQtTec() == 1)
					retorno.setQtMinimaTecnicos(1);
				if (dwtparada.getQtTec() != null && dwtparada.getQtTec() == 2)
					retorno.setQtMinimaTecnicos(3);
				if (dwtparada.getQtTec() != null && dwtparada.getQtTec() == 3) {
					retorno.setQtMinimaTecnicos(3);
					retorno.setIsTecnicoArea(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}

}
