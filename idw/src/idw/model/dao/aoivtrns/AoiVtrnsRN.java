package idw.model.dao.aoivtrns;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.dto.EventosColetados;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class AoiVtrnsRN extends AbstractRN<DAOGenericoAoiVtrns>{

	public AoiVtrnsRN() {
		super(new DAOGenericoAoiVtrns());
	}
	
	public AoiVtrnsRN(DAOGenericoAoiVtrns dao) {
		super(dao);
	}

	
	public EventosColetados obterEventos(IcUpDTO icupdto, String cdposto, BigDecimal idEvento) {
		EventosColetados retorno = new EventosColetados();
		try {
			iniciaConexaoBanco();
			
			MapQuery q = new MapQuery(getDaoSession());
	
			q.append("select c.PROGRAM_NAME, b.machine_name, a.INSPECTION_ID, b.INSPECTION_END_TIME, a.REWORK_RESULT, a.TOTAL_COMP_NG, d.COMP_NUMBER, d.COMP_NAME, d.USER_FAULT_CODE, b.PCB_BARCODE"); 
			q.append("from REWORK_RESULT a");
			q.append("join INSPECTION_RESULT b on b.INSPECTION_ID = a.INSPECTION_ID");
			q.append("join PROGRAM_INFO c on c.PROGRAM_ID = b.PROGRAM_ID");
			q.append("left join REWORK_COMPONENTS d on d.INSPECTION_ID = b.INSPECTION_ID");
			q.append("where");
			q.append("b.MACHINE_NAME = :cdposto");
			q.append("and a.INSPECTION_ID > :id");
			q.append("and b.INSPECTION_END_TIME > :dthr");
			q.append("order by a.inspection_id");
	
			
			Date dthrReferencia = DataHoraRN.getDataHoraAtual();
			dthrReferencia = DataHoraRN.subtraiDiasDaData(dthrReferencia, 1);
			
			q.querySQL().setString("cdposto", cdposto);
			q.querySQL().setBigDecimal("id", idEvento);
			q.querySQL().setTimestamp("dthr", dthrReferencia);
			
			
			
			BigDecimal idAnterior = null;
			
			List<Object> listaResultadoConsulta = q.querySQL().list();
			
			for (Object registro : listaResultadoConsulta) {
				Object[] colunas = (Object[]) registro;
				String programName = colunas[0].toString();
				String machineName = colunas[1].toString();
				BigDecimal id = (BigDecimal) colunas[2];
				Date inspectionEndTime = (Date) colunas[3];
				BigDecimal rework_result = (BigDecimal) colunas[4];
				String compName;
				try {
					compName = colunas[7].toString();
				} catch (NullPointerException e) {
					compName = "";
				}
				String userFaultCode;
				
				if (colunas[8] != null)
					userFaultCode = colunas[8].toString();
				else
					userFaultCode = "";
				
				String pcbBarcode = null;
				if (colunas[9] != null) {
					pcbBarcode = colunas[9].toString().trim();
				}
				if (pcbBarcode == null || (pcbBarcode != null && pcbBarcode.equals("")) )
					pcbBarcode = "NS" + DataHoraRN.getDataHoraAtualFormatada();
			
				
				 // Temporariamente vamos tirar 4 horas da data e hora do evento, depois q corrigirem esse dado remover essa linha
				inspectionEndTime = DataHoraRN.subtraiHorasDaData(inspectionEndTime, 4);
								
				EventoColetado eventoPassagem = new EventoColetado();
				
				eventoPassagem.setIdEvt(id);
				eventoPassagem.setTipoEvento(ServicoFactory._PASSAGEM);
				eventoPassagem.setDthrEvento(inspectionEndTime);
				eventoPassagem.setCb(pcbBarcode);
				eventoPassagem.setOrigem(getOrigem(id, programName, machineName, inspectionEndTime, rework_result, compName, userFaultCode));
				eventoPassagem.setCdop(programName);
				eventoPassagem.setIcUpDTO(icupdto);
				

				if (rework_result.compareTo(BigDecimal.ZERO) == 0) {
					List<DefeitoDTO> defeitos = new ArrayList<>();
					DefeitoDTO defeito = new DefeitoDTO();
					defeito.setCdDefeito(userFaultCode);
					defeito.setCdOrigem(compName);
					defeitos.add(defeito);
					eventoPassagem.setDefeitos(defeitos);
				}
				
				
				retorno.setUltimoID(id);
				
				EventoColetado eventoPesquisado = null;
				
				if (idAnterior != null && id.compareTo(idAnterior) == 0)
					eventoPesquisado = getEventoRetorno(retorno, eventoPassagem);
				
				if (eventoPesquisado !=  null) {
					eventoPesquisado.getDefeitos().addAll(eventoPassagem.getDefeitos());
				} else {
					retorno.addEventoColetado(eventoPassagem);
				
					EventoColetado eventoCiclo = new EventoColetado();
					eventoCiclo.setIdEvt(id);
					eventoCiclo.setTipoEvento(ServicoFactory._FIM_CICLO);
					eventoCiclo.setDthrEvento(eventoPassagem.getDthrEvento()); // inspectionEndTime);
					eventoCiclo.setCb(pcbBarcode);
					eventoCiclo.setOrigem(eventoPassagem.getOrigem());
					eventoCiclo.setCdop(programName);
					eventoCiclo.setIcUpDTO(icupdto);
	
					retorno.addEventoColetado(eventoCiclo);
				}
				
				idAnterior = id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finalizaConexaoBanco();
		}
		
		return retorno;
	}

	/* Esse metodo tem como objetivo encontrar no retorno do metodo principal da classe um determinado evento de passagem
	 * 
	 */
	private EventoColetado getEventoRetorno(EventosColetados eventos, EventoColetado eventoPassagem) {
		EventoColetado retorno = null;
		
		if (eventoPassagem != null && eventoPassagem.getIdEvt() != null) {
			for (EventoColetado evento : eventos.getEventosColetados()) {
				if (evento.getIdEvt().compareTo(eventoPassagem.getIdEvt()) == 0) {
					retorno = evento;
					break;
				}
			}
		}
		
		return retorno;
	}

	private String getOrigem(BigDecimal id, String programName, String machineName, Date inspectionEndTime, BigDecimal rework_result,
			String compName, String userFaultCode) {
		StringBuilder retorno = new StringBuilder();
		
		retorno.append("id=");
		retorno.append(id);
		retorno.append(" programName=");
		retorno.append(programName);
		retorno.append(" machineName=");
		retorno.append(machineName);
		retorno.append(" inspectionEndTime=");
		retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(inspectionEndTime));
		retorno.append(" rework_result=");
		retorno.append(rework_result);
		retorno.append(" compName=");
		retorno.append(compName);
		retorno.append(" userFaultCode=");
		retorno.append(userFaultCode);
		
		return retorno.toString();
	}
	
	
}
