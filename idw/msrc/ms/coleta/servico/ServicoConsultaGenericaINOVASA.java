package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.MsFacade;
import ms.model.dto.EventoColetado;

public class ServicoConsultaGenericaINOVASA implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {

		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();

		log.iniciaAvaliacao(idLog, "Chamando ServicoConsultaGenericaINOVASA");

		log.info(idLog, identacao,"ServicoConsultaGenericaINOVASA - INI");
		log.info(idLog, identacao, "ServicoConsultaGenericaINOVASA para " + mensagem.getIp());

		MensagemEnviada m = preparacaoConsulta(sessao, mensagem);

		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);

		log.paraAvaliacao();
		log.info("ServicoConsultaGenericaINOVASA - FIM - " + log.getAvaliacaoCompleta());
		
		return null;
	}

	private MensagemEnviada preparacaoConsulta(Session sessao, MensagemRecebida mensagem) {
		//EventoColetado evt = new EventoColetado();
		EventoColetado evt = mensagem.getEventoColetado();
		//evt.setUp(mensagem.getEventoColetado().getUp());
		//evt.setTipoEvento(Integer.parseInt(mensagem.getEventoColetado().getCdconsulta()));
		//evt.setLog(mensagem.getLog());
		ConsultaInovaSADTO retorno = MsFacade.getInstancia().consultaGenericaINOVASA(evt);

		MensagemEnviada m = new MensagemEnviada(mensagem);
		m.setTipoServico(evt.getTipoEvento());
		
		if(retorno != null) {
			int cdConsulta = Integer.parseInt(evt.getCdconsulta());
			switch (cdConsulta){

			case ServicoFactory._PROD_LIQ_EFI_REAL_TURNO:
			case ServicoFactory._PROD_LIQ_EFI_REAL_OP:
			case ServicoFactory._PRODLIQ_EFI_REAL_TODAS_OP:
			case ServicoFactory._PRODLIQ_EFI_REAL_HR:
				if(retorno.getProducaoLiquida() != null)
					m.setProdLiquida(retorno.getProducaoLiquida());
				else
					m.setProdLiquida(0);
				if(retorno.getEfiRealizacao() != null)
					m.setEfiRealizacao(retorno.getEfiRealizacao());
				else
					m.setEfiRealizacao(0);
				m.setConsultaOK(true);
				break;

			case ServicoFactory._QTD_REF_INDI_REF_OP:
			case ServicoFactory._QTD_REF_INDI_REF_TODAS_OP:
			case ServicoFactory._QTD_REF_INDI_REF_TURNO:
				if(retorno.getProducaoRefugada() != null)
					m.setProducaoRefugada(retorno.getProducaoRefugada());
				else
					m.setProducaoRefugada(0);
				if(retorno.getIndiceRefugos() != null)
					m.setIndiceRefugo(retorno.getIndiceRefugos());
				else
					m.setIndiceRefugo(0);
				m.setConsultaOK(true);
				break;

			case ServicoFactory._A_PRDZR_NUM_OP_MLD_OR_EST_OR_CDPROD:
				if(retorno.getSaldoAProduzir() != null)
					m.setSaldoAProduzir(retorno.getSaldoAProduzir());
				else
					m.setSaldoAProduzir(0);
				if(retorno.getCdFolha() != null)
					m.setCdFolha(retorno.getCdFolha());
				else
					m.setCdFolha("");
				if(retorno.getUltimaOp() != null)
					m.setNrOp(retorno.getUltimaOp());
				else
					m.setNrOp("");
				m.setConsultaOK(true);
				break;

			case ServicoFactory._CICLO_MED_CICLO_PAD_TURNO:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				if(retorno.getCicloPadrao() != null)
					m.setCicloPadrao(retorno.getCicloPadrao().longValue());
				else
					m.setCicloPadrao(0);
				if(retorno.getCicloMedio() != null)
					m.setCicloMedio(retorno.getCicloMedio().longValue());
				else
					m.setCicloMedio(0);
				m.setConsultaOK(true);
				break;

			case ServicoFactory._INDC_PAR_TURNO_INDC_PAR_OP:
			case ServicoFactory._IND_PAR_TURNO_TODAS_OP_E_ATUAL:
				if(retorno.getIndiceParadasPorTurno() != null)
					m.setIndiceParadasPorTurno(retorno.getIndiceParadasPorTurno());
				else
					m.setIndiceParadasPorTurno(0);
				if(retorno.getIndiceParadasPorOP() != null)
					m.setIndiceParadasPorOP(retorno.getIndiceParadasPorOP());
				else
					m.setIndiceParadasPorOP(0);
				m.setConsultaOK(true);
				break;

			case ServicoFactory._EFI_CICLO_TURNO_E_OP:
			case ServicoFactory._EFI_CICLO_TURNO_TODAS_OP_E_ATUAL:
				if(retorno.getEfiCiclosTurno() != null)
					m.setEfiCiclosTurno(retorno.getEfiCiclosTurno());
				else
					m.setEfiCiclosTurno(0);
				if(retorno.getEfiCiclosOP() != null)
					m.setEfiCiclosOP(retorno.getEfiCiclosOP());
				else
					m.setEfiCiclosOP(0);
				m.setConsultaOK(true);
				break;

			case ServicoFactory._TIME_INTERV_META_PROD_HR:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				if(retorno.getMetaProdHora() != null)
					m.setMetaProdHora(retorno.getMetaProdHora());
				else
					m.setMetaProdHora(0);
				if(retorno.getIntervaloHora() != null)
					m.setIntervaloHora(retorno.getIntervaloHora());
				else
					m.setIntervaloHora("");
				m.setConsultaOK(true);
				break;

			case ServicoFactory._TURNO_DTHR_ATUAL:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA (ESSA CONSULTA PODE SER LOCAL ACREDITO)
				if(retorno.getDsTurno() != null)
					m.setDsTurno(retorno.getDsTurno());
				else
					m.setDsTurno("");
				m.setConsultaOK(true);
				break;

			case ServicoFactory._COD_E_DES_ULTIMA_PAR:
				//TODO: NENHUMA INFORMACAO NO DOCUMENTO SOBRE ESSA CONSULTA IMPLEMENTAR
				m.setConsultaOK(false);
				break;

			case ServicoFactory._PRODUTOS_DA_OP:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				m.setListProdutos(retorno.getListaProdutos());
				m.setConsultaOK(true);
				break;

			case ServicoFactory._CIP_DTHR_DURATION:
				m.setCip(retorno.isCIP());
				m.setCipDthrIni(retorno.getCipDthrIni());
				m.setCipDuration(retorno.getCipDuration());
				m.setConsultaOK(true);
				break;

			case ServicoFactory._CIP_DTHR_PROD_REF:
				m.setCip(retorno.isCIP());
				m.setCipDthrIni(retorno.getCipDthrIni());
				if(retorno.getProducaoLiquida() != null)
					m.setProdLiquida(retorno.getProducaoLiquida());
				else
					m.setProdLiquida(0);
				if(retorno.getProducaoRefugada() != null)
					m.setProducaoRefugada(retorno.getProducaoRefugada());
				else
					m.setProducaoRefugada(0);
				m.setConsultaOK(true);
				break;

			case ServicoFactory._OEE_TURNO:
			case ServicoFactory._OEE_ULTIMA_HR:
				if(retorno.getProdutividadeOEE() != null)
					m.setProdutividadeOEE(retorno.getProdutividadeOEE());
				else
					m.setProdutividadeOEE(0);
				if(retorno.getIndOEE() != null)
					m.setMetaOEE(retorno.getIndOEE());
				else
					m.setMetaOEE(0);

				if(retorno.getIndiceParadas() != null)
					m.setIndiceUtilizacao(100.00-retorno.getIndiceParadas());
				else
					m.setIndiceUtilizacao(0);

				if(retorno.getIndiceProducao() != null)
					m.setIndiceProducao(retorno.getIndiceProducao());
				else
					m.setIndiceProducao(0);

				if(retorno.getIndiceRefugos() != null)
					m.setIndiceQualidade((100.00-retorno.getIndiceRefugos()));
				else
					m.setIndiceQualidade(0);
				m.setConsultaOK(true);
				break;
			case ServicoFactory._PERFIL_ANDON:
				// 2019-08-05: Ailton
				// se cdConsulta for "25", trata-se de uma consulta ao perfil do Andon
				m.setMsPerfilAndon(retorno.getMsPerfilAndon());
				m.setConsultaOK(true);
				break;
			default:
				m.setConsultaOK(false);
				break;
			}
		} else {
			m.setConsultaOK(false);
		}

		return m;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		//System.out.println("_EVT_CONSULTA_INOVASA");
		retorno.setCdconsulta(evtArgs.get("1"));
		//System.out.println("cdConsulta="+retorno.getCdconsulta());
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		String retorno = "";
		String status = "[resp]\nst=1\n";
		

		if(mensagem.isConsultaOK() == true) {
			status = "[resp]\nst=0\n";
			String respNumber = "";
			switch (Integer.parseInt(mensagem.getMensagemRecebida().getEventoColetado().getCdconsulta())){
			
			case ServicoFactory._PROD_LIQ_EFI_REAL_TURNO:
			case ServicoFactory._PROD_LIQ_EFI_REAL_OP:
			case ServicoFactory._PRODLIQ_EFI_REAL_TODAS_OP:
			case ServicoFactory._PRODLIQ_EFI_REAL_HR:
				respNumber = "n=2\n";
				String prodLiq = "1=" +  String.format("%.0f", mensagem.getProdLiquida()) + "\n";
				String efiReal = "2=" + String.format("%.2f", mensagem.getEfiRealizacao()) + "\n";
				retorno = respNumber + prodLiq + efiReal;
				break;
				
			case ServicoFactory._QTD_REF_INDI_REF_OP:
			case ServicoFactory._QTD_REF_INDI_REF_TODAS_OP:
			case ServicoFactory._QTD_REF_INDI_REF_TURNO:
				respNumber = "n=2\n";
				String prodRef = "1=" + String.format("%.0f", mensagem.getProducaoRefugada()) + "\n";
				String indidRef = "2=" + String.format("%.2f", mensagem.getIndiceRefugo()) + "\n";
				retorno = respNumber + prodRef + indidRef;
				break;
				
			case ServicoFactory._A_PRDZR_NUM_OP_MLD_OR_EST_OR_CDPROD:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				respNumber = "n=3\n";
				String aProduzir = "1=" + String.format("%.0f", mensagem.getSaldoAProduzir()) + "\n";
				String nrOp = "2=" + mensagem.getNrOp() + "\n";
				String cdProduto = "3=" + mensagem.getCdFolha() + "\n";
				retorno = respNumber + aProduzir + nrOp + cdProduto;
				break;
				
			case ServicoFactory._CICLO_MED_CICLO_PAD_TURNO:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				respNumber = "n=2\n";
				String cicloPadrao = "1=" + mensagem.getCicloPadrao() + "\n";
				String cicloMedio = "2=" + mensagem.getCicloMedio() + "\n";
				retorno = respNumber + cicloPadrao + cicloMedio;
				break;
				
			case ServicoFactory._INDC_PAR_TURNO_INDC_PAR_OP:
			case ServicoFactory._IND_PAR_TURNO_TODAS_OP_E_ATUAL:
				respNumber = "n=2\n";
				String indParTur = "1=" + String.format("%.2f", mensagem.getIndiceParadasPorTurno()) + "\n";
				String indParOP = "2=" + String.format("%.2f", mensagem.getIndiceParadasPorOP()) + "\n";
				retorno = respNumber + indParTur + indParOP;
				break;
				
			case ServicoFactory._EFI_CICLO_TURNO_E_OP:
			case ServicoFactory._EFI_CICLO_TURNO_TODAS_OP_E_ATUAL:
				respNumber = "n=2\n";
				String efiCicTur = "1=" + String.format("%.2f", mensagem.getEfiCiclosTurno()) + "\n";
				String efiCicOP = "2=" + String.format("%.2f", mensagem.getEfiCiclosOP()) + "\n";
				retorno = respNumber + efiCicTur + efiCicOP;
				break;
				
			case ServicoFactory._TIME_INTERV_META_PROD_HR:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				respNumber = "n=2\n";
				String intervalo = "1=" + mensagem.getIntervaloHora() + "\n";
				String metaHora = "2=" + mensagem.getMetaProdHora() + "\n";
				retorno = respNumber + intervalo + metaHora;
				break;
				
			case ServicoFactory._TURNO_DTHR_ATUAL:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA (ESSA CONSULTA PODE SER LOCAL ACREDITO)
				respNumber = "n=1\n";
				String dsTurno = "1=" + mensagem.getDsTurno() + "\n";
				retorno = respNumber + dsTurno;
				break;
				
			case ServicoFactory._COD_E_DES_ULTIMA_PAR:
				//TODO: NENHUMA INFORMACAO NO DOCUMENTO SOBRE ESSA CONSULTA IMPLEMENTAR
				status = "[resp]\nst=1\n";
				break;
				
			case ServicoFactory._PRODUTOS_DA_OP:
				//TODO: RETORNO DEVE SER PREENCHIDO EM UpRN.consultaGenericaINOVASA PARA ESTA CONSULTA
				int sizeListProdutos = 0;
				if(mensagem.getListProdutos() != null)
					sizeListProdutos = mensagem.getListProdutos().size();
				String qtdProdutos = "n=" + sizeListProdutos + "\n";
				String produtos = "";
				int i = 0;
				for(String cdProd : mensagem.getListProdutos()) {
					if(cdProd != null) {
						produtos += (i+1) + "=" + cdProd + "\n";
						i++;
					}
				}
				retorno = respNumber + qtdProdutos + produtos;
				break;
			
			case ServicoFactory._CIP_DTHR_DURATION:
				respNumber = "n=3\n";
				String isCIP = "1=" + mensagem.isCip() + "\n";
				String cipDthrIni = "2=" + mensagem.getCipDthrIni() + "\n";
				String cipDuration = "3=" + mensagem.getCipDuration() + "\n";
				retorno = respNumber + isCIP + cipDthrIni + cipDuration;
				break;
				
			case ServicoFactory._CIP_DTHR_PROD_REF:
				respNumber = "n=4\n";
				String isCIP2 = "1=" + mensagem.isCip() + "\n";
				String cipDthrIni2 = "2=" + mensagem.getCipDthrIni() + "\n";
				String prodLiqCIP = "3=" + String.format("%.2f", mensagem.getProdLiquida()) + "\n";
				String prodRefCIP = "4=" + String.format("%.2f", mensagem.getProducaoRefugada()) + "\n";
				retorno = respNumber + isCIP2 + cipDthrIni2 + prodLiqCIP + prodRefCIP;
				break;
				
			case ServicoFactory._OEE_TURNO:
			case ServicoFactory._OEE_ULTIMA_HR:
				respNumber = "n=5\n";
				String prodOee = "1=" + String.format("%.2f", mensagem.getProdutividadeOEE()) + "\n";
				String metaOee = "2=" + String.format("%.2f", mensagem.getMetaOEE()) + "\n";
				String indQld = "3=" + String.format("%.2f", mensagem.getIndiceQualidade()) + "\n";
				String indUtl = "4=" + String.format("%.2f", mensagem.getIndiceUtilizacao()) + "\n";
				String indEfc = "5=" + String.format("%.2f", mensagem.getIndiceProducao()) + "\n";
				retorno = respNumber + prodOee + metaOee + indQld + indUtl + indEfc;
				break;
			default:
				status = "[resp]\nst=1\n";
				break;
			}
		}

		retorno=status+retorno;	
		//System.out.println("construirMsgConsultaINOVASAGenerica = " + retorno);
		return retorno;
	}
}