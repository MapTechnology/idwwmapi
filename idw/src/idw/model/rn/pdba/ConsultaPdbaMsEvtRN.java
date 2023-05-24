package idw.model.rn.pdba;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import idw.util.IdwLogger;
import injetws.webservices.dto.IwsConsultaDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.ic.inovastandalone.ConsultaInovaSADTO;
import ms.model.MsFacade;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class ConsultaPdbaMsEvtRN extends AbstractPdbaMsEvtRN{


	@SuppressWarnings("rawtypes")
	private Map<String, Class> consultas = new HashMap<>();
	
	public ConsultaPdbaMsEvtRN() {
		super();
		
		consultas.put("001", ConsultaPdbaMsEvt001.class);
		consultas.put("002", ConsultaPdbaMsEvt002.class);
		consultas.put("003", ConsultaPdbaMsEvt003.class);
		consultas.put("004", ConsultaPdbaMsEvt004.class);
		consultas.put("005", ConsultaPdbaMsEvt005.class);
		consultas.put("006", ConsultaPdbaMsEvt006.class);
		consultas.put("007", ConsultaPdbaMsEvt007.class);
		consultas.put("008", ConsultaPdbaMsEvt008.class);
		consultas.put("009", ConsultaPdbaMsEvt009.class);
		consultas.put("010", ConsultaPdbaMsEvt010.class);
		consultas.put("011", ConsultaPdbaMsEvt011.class);
		consultas.put("012", ConsultaPdbaMsEvt012.class);
		consultas.put("013", ConsultaPdbaMsEvt013.class);
		consultas.put("014", ConsultaPdbaMsEvt014.class);
		consultas.put("015", ConsultaPdbaMsEvt015.class);
		consultas.put("016", ConsultaPdbaMsEvt016.class);
		consultas.put("017", ConsultaPdbaMsEvt017.class);
		consultas.put("018", ConsultaPdbaMsEvt018.class);
		consultas.put("019", ConsultaPdbaMsEvt019.class);
		consultas.put("020", ConsultaPdbaMsEvt020.class);
		consultas.put("021", ConsultaPdbaMsEvt021.class);
		consultas.put("022", ConsultaPdbaMsEvt022.class);
		
	}
	
	public IwsConsultaDTO setTr_Consulta(String cdconsulta, String idup,Date dthr) {
		IdwLogger log = new IdwLogger("setTrConsulta");
		
		IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(idup);
		
		EventoColetado evt = new EventoColetado();
		evt.setUp(icupdto.getUpDTO().getCd_up());
		evt.setCdconsulta(cdconsulta);
		evt.setLog(log);
		
		ConsultaInovaSADTO consulta = MsFacade.getInstancia().consultaGenericaINOVASA(evt);
		IConsultaMsEvtRN fact = null;
		IwsConsultaDTO retorno = null;
		try {
			fact = (IConsultaMsEvtRN) consultas.get(cdconsulta).newInstance();
			retorno = fact.getConsulta(consulta);
		} catch (InstantiationException | IllegalAccessException | NullPointerException e) {
			retorno = new IwsConsultaDTO();
			retorno.setResposta(false);
		}
		
		
		return retorno;
	}
}
