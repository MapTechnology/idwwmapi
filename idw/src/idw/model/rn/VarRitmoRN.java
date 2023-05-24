package idw.model.rn;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.util.IdwLogger;
import ms.model.dto.EventoColetado;
import ms.model.rn.EventoRN;

public class VarRitmoRN implements IDao {
	private DAOGenerico dao;

	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		dao.iniciaSessao();
		dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		dao.finalizaTransacao();
		dao.finalizaSessao();
	}

	public VarRitmoRN() {
		if (dao == null) {
			dao = new DAOGenerico();
		}

	}

	public void setDaosession(Session sessao) {
		dao.setSession(sessao);
	}
	
	public Session getDaosession() {
		return dao.getSession();
	}

	public VarRitmoRN(DAOGenerico dao) {
		this.dao = dao;
	}
	
	public boolean iniciarVarRitmo(EventoColetado evento) {
		IdwLogger log = evento.getLog();
		boolean retorno = false;

		// Lancar evento de inicio de cip
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaosession());
		MsEvt msevt = null;
		log.iniciaAvaliacao("incluirEvento");
		msevt = eventoRN.incluirEvento(log, 0, 0, evento, MsTpevtTemplate.Type.INICIA_VARRITMO.getId(), null);

		if (msevt != null) {
			log.paraAvaliacao(msevt.getIdEvt());
			retorno = true;
		}
		
		log.info(log.getAvaliacaoCompleta());

		return retorno;
	}
	
	public boolean informaMotivoVarRitmo(EventoColetado evento) {
		IdwLogger log = evento.getLog();
		boolean retorno = false;

		// Lancar evento de inicio de cip
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaosession());
		MsEvt msevt = null;
		log.iniciaAvaliacao("incluirEvento");
		msevt = eventoRN.incluirEvento(log, 0, 0, evento, MsTpevtTemplate.Type.MOTIVO_VARRITMO.getId(), null);

		if (msevt != null) {
			log.paraAvaliacao(msevt.getIdEvt());
			retorno = true;
		}
		
		log.info(log.getAvaliacaoCompleta());

		return retorno;
	}
	
	public boolean finalizarVarRitmo(EventoColetado evento) {
		IdwLogger log = evento.getLog();
		boolean retorno = false;

		// Lancar evento de inicio de cip
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaosession());
		MsEvt msevt = null;
		log.iniciaAvaliacao("incluirEvento");
		msevt = eventoRN.incluirEvento(log, 0, 0, evento, MsTpevtTemplate.Type.FIM_VARRITMO.getId(), null);

		if (msevt != null) {
			log.paraAvaliacao(msevt.getIdEvt());
			retorno = true;
		}
		
		log.info(log.getAvaliacaoCompleta());

		return retorno;
	}
	
}
