package ms.coleta.ic.aoikyzl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;
import idw.util.IdwLogger;
import idw.model.dao.MapQuery;
import idw.model.dao.aoikyzl.DAOGenericoAoiKyZl;
import idw.model.pojos.aoiky.*;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.ic.coletalogs.BufferedEventos;
import ms.coleta.servico.ServicoFactory;
import ms.model.dao.AbstractAoiKyZlDAO;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsThreads;

import java.util.Date;

public class AoiKyZlSqlRN extends AbstractAoiKyZlDAO  {
	
	private BufferedEventos bufferEvento;
	private TB_AOIResult ultimaLinhaProcessada = null;
	
	public AoiKyZlSqlRN(DAOGenericoAoiKyZl daoAoiKyZl) {
		Validate.notNull(daoAoiKyZl);
		
		this.setDaoAoiKyZl(daoAoiKyZl);
	}

	//métodos para validar os pojos
	public List<TB_AOIResult> getAoiResult (){
		
		List<TB_AOIResult> linhas1 = new ArrayList<TB_AOIResult>();
		List<TB_AOIResult> linhas2 = new ArrayList<TB_AOIResult>();
	  				
		MapQuery q1 = new MapQuery(this.getDaoAoiKyZl().getSession());
		q1.append("select t from TB_AOIResult t ");
		q1.append("order by pcbid desc");
		q1.setMaxResults(20);
		linhas1 = q1.list();
		
		UtilsThreads.pausaNaThread(1000);
		this.getDaoAoiKyZl().getSession().flush();
		//this.getDaoAoiKyZl().getSession().clear();
		
		for (TB_AOIResult linha:linhas1){
			//TB_AOIResult obj = (TB_AOIResult)this.getDaoAoiKyZl().getSession().get(TB_AOIResult.class,linha.getPcbGuid());
			this.getDaoAoiKyZl().getSession().refresh(linha);
		}
						
		/*MapQuery q2 = new MapQuery(this.getDaoAoiKyZl().getSession());
		q2.append("select t from TB_AOIResult t ");
		q2.append("order by pcbid desc");
		q2.setMaxResults(20);
		linhas2 = q2.list();*/
		
		return linhas1;
			
	}
	
	public List<TB_AOIDefect> getAoiDefect (String placa){
		List<TB_AOIDefect> linhas = new ArrayList<TB_AOIDefect>();
		
		MapQuery q = new MapQuery(this.getDaoAoiKyZl().getSession());
		q.append("select pcbguid,componentGuid,uname,partNumber from TB_AOIDefect  ");
		q.append("where pcbguid = :placa");
		q.defineParametro("placa", placa);
		q.setMaxResults(10);
		linhas = q.list();
				
		return linhas;
	}
	
	public List<TB_AOIDefectDetail> getAoiDefectDetail (String placa){
		List<TB_AOIDefectDetail> linhas = new ArrayList<TB_AOIDefectDetail>();
		
		MapQuery q = new MapQuery(this.getDaoAoiKyZl().getSession());
		q.append("select t from TB_AOIDefectDetail t  ");
		q.append("where pcbguid = :placa");
		q.defineParametro("placa", placa);
		q.setMaxResults(10);
		linhas = q.list();
				
		return linhas;
	}
	
	public List<ResultDetailDTO> joinResultDetail(String placa){
		
		List<ResultDetailDTO> linhas = new ArrayList<ResultDetailDTO>();
		
		MapQuery q = new MapQuery(this.getDaoAoiKyZl().getSession());
		q.append("select r.pcbguid, r.pcbid, r.machineId, r.endDateTime, r.pcbResultBefore,r.pcbResultAfter,");
		q.append("r.pcbRepair, r.allBarCode, r.pcbModel, d.componentGuid,d.defect");
		//q.append("select r");
		q.append("from TB_AOIResult r, TB_AOIDefectDetail d");
		//q.append("join r.pcbguid d");
		q.append("where r.pcbguid =:placa");
		q.append("and r.pcbguid = d.pcbguid");
		q.defineParametro("placa", placa);
		q.setMaxResults(10);
		linhas = q.list();
		
		
		
		return linhas;
	}
	
	public Iterator<Object> joinResultDefeitoDetail(String placa){
							
		List<ResultDefeitoDetailDTO> linhas = new ArrayList<ResultDefeitoDetailDTO>();
		Iterator<Object> iterator;
		MapQuery q = new MapQuery(this.getDaoAoiKyZl().getSession());
		q.append("select r.pcbguid, r.pcbid, r.machineId, r.endDateTime, r.pcbResultBefore,r.pcbResultAfter,");
		q.append("r.pcbRepair, r.allBarCode, r.pcbModel, d.componentGuid,d.defect, c.uname, c.partNumber, r.reviewUserId");
		q.append("from TB_AOIResult r, TB_AOIDefectDetail d, TB_AOIDefect c");
		q.append("where r.pcbguid =:placa");
		q.append("and r.pcbguid = d.pcbguid");
		q.append("and d.componentGuid = c.componentGuid");
		q.defineParametro("placa", placa);
		q.setMaxResults(10);
		linhas = q.list();
		iterator = q.list().iterator();
								
		return iterator;
	
	}
			
	//public EventoColetado criaEventoColetadoTesteDefeito(List<ResultDefeitoDetailDTO> linhas,  IcUpDTO icUpDTO,IdwLogger log) {
	public EventoColetado criaEventoColetadoTesteDefeito(Iterator<Object> it,  IcUpDTO icUpDTO,IdwLogger log) {
		EventoColetado ev = new EventoColetado();
		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		Object[] lista;
		boolean isDeveSetar = true;
		
		
		while(it.hasNext()){
			lista = (Object[])it.next();
			if(isDeveSetar){
				ev.setCb( (String)lista[7] );
				if (ev.getCb().equals("") || ev.getCb().equals("Fail") ){
					ev.setCb("NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + ((Date)lista[3]).toString() );					
					
				}
				ev.setCdop( (String)lista[8] );
				ev.setUp(icUpDTO.getUpDTO().getCd_up());
				ev.setIcUpDTO(icUpDTO);
				ev.setQtde("1");
				ev.setIsCbConforme(false);
				ev.setDthrEvento((Date)lista[3]);
				ev.setLog(log);
				ev.setTipoEvento(ServicoFactory._PASSAGEM); // // Passagem
				ev.setOrigem((String)lista[0] + " " + (String)lista[2] + " " + ((Date)lista[3]).toString());
				isDeveSetar = false;
			}
					
		// Validacao
		
		    			
			DefeitoDTO defeito = new DefeitoDTO();
			
			defeito.setCdDefeito(Integer.toString((int) lista[10]));
			defeito.setDthrDefeito((Date)lista[3]);
			defeito.setCb((String)lista[7]); // codigo do barras
			defeito.setPosicoes((String)lista[11]); // Posicao Mecanica
			defeitos.add(defeito);
					
				
		}	
		
		if (defeitos.size() > 0)
			ev.setDefeitos(defeitos);
		
		return ev;
	}
	
	public EventoColetado criaEventoColetadoTesteSimples(TB_AOIResult linha, IcUpDTO icUpDTO,IdwLogger log) {
		EventoColetado ev = new EventoColetado();
		
		ev.setCb(linha.getAllBarCode());
		if (ev.getCb().equals("") || ev.getCb().equals("Fail") ){
			ev.setCb("NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + linha.getEndDateTime().toString());					
		}
		
		//ev.setCdop(linha.getPcbModel());
		ev.setCdop(linha.getPcbModel());
		ev.setUp(icUpDTO.getUpDTO().getCd_up());
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde("1");
		ev.setIsCbConforme(true);
		ev.setDthrEvento(linha.getEndDateTime());
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
		ev.setOrigem(linha.getPcbGuid() + " " + linha.getMAchineId() + " " + linha.getEndDateTime().toString());
		
		return ev;
	}
	
	public void setBufferEvento(BufferedEventos bufferEvento) {
		this.bufferEvento = bufferEvento;
	}
	
	public TB_AOIResult getUltimaLinha(){
		return this.ultimaLinhaProcessada;
	}
	
	public void setUltimaLinha(TB_AOIResult linha){
		this.ultimaLinhaProcessada = linha;
		
	}
	
}
	
	
	
	


	
