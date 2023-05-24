package idw.model.rn;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.AbstractDAOGenerico;
import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.excessoes.MonitorDesconhecidoException;
import idw.model.pojos.MsMonitor;
import idw.webservices.dto.ListaMonitorDTO;

public class MonitorRN implements IDao {
	private AbstractDAOGenerico dao;
	
	public MonitorRN(){
		this.dao = new DAOGenerico();
	}
	
	public MonitorRN(AbstractDAOGenerico dao){
		this.dao = dao;
	}
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}

	public void incluirMonitor(String idAtividade, Date dti, Date dtf, BigDecimal consumoMemoriaPressumido, BigDecimal memoriaLivreInicial, BigDecimal memoriaLivreFinal, BigDecimal segTranscorridos, BigDecimal idEvt){
		MsMonitor msmonitor = new MsMonitor();

		msmonitor.setDsItemMonitorado(idAtividade);
		msmonitor.setDthrFim(dtf);
		msmonitor.setDthrInicio(dti);
		msmonitor.setIdMonitor(null);
		msmonitor.setMemConsumida(consumoMemoriaPressumido);
		msmonitor.setMemfFreeEmbyte(memoriaLivreFinal);
		msmonitor.setMemiFreeEmbyte(memoriaLivreInicial);
		msmonitor.setMiliDuracao(segTranscorridos);
		msmonitor.setMsEvt(null);

		// Se o id do Evento for enviado, enao encontra-lo
		if ((idEvt != null) && (idEvt.intValue() > 0)){
//			EventoRN eventoRN = new EventoRN();
//			eventoRN.setDao(dao);
//			MsEvt msevt = null;
//			msevt = eventoRN.pesquisarMsEvtById(idEvt);
//			msmonitor.setMsEvt(msevt);
//			eventoRN = null;
		}

		this.dao.makePersistent(msmonitor);
	}

	public ListaMonitorDTO pesquisarMonitorPorEvento(Long idEvento) throws MonitorDesconhecidoException{
	   ListaMonitorDTO retorno = new ListaMonitorDTO();

	   try{
	    	MapQuery query = new MapQuery(this.dao.getSession());
			query.append("select monitor");
			query.append("from MsMonitor monitor");
			query.append("left join fetch monitor.msEvt evt");

			query.appendWhere(MapQuery._NULL, "evt.idEvt =:idevt" , idEvento != null);

			if(idEvento != null){
			query.defineParametro("idevt",idEvento);
			}
			retorno.setLista(new ArrayList<MsMonitor>());

			List<MsMonitor> lista = query.list();
			retorno.setLista(new ArrayList<MsMonitor>());

			for (MsMonitor m :lista){
				retorno.getLista().add(m.clone(true));
			}
	    	return retorno ;

	    }catch (Exception e) {
	    	e.printStackTrace();
		  	throw new MonitorDesconhecidoException();
	    }

	}
	public void setDao(AbstractDAOGenerico dao){
		this.dao = dao;
	}
}
