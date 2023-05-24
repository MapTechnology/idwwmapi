package idw.model.rn;

import java.util.Date;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwConsolciplog;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.util.IdwLogger;
import ms.model.dto.EventoColetado;
import ms.model.rn.EventoRN;

public class CIPRN implements IDao {
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

	public CIPRN() {
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

	public CIPRN(DAOGenerico dao) {
		this.dao = dao;
	}
	
	public MsEvt iniciarCIP(EventoColetado evento) {
		IdwLogger log = evento.getLog();

		// Lancar evento de inicio de cip
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaosession());
		MsEvt msevt = null;
		msevt = eventoRN.incluirEvento(log, 0, 0, evento, MsTpevtTemplate.Type.INICIO_CIP.getId(), null);
		return msevt;
	}
	
	public MsEvt finalizarCIP(EventoColetado evento) {
		IdwLogger log = evento.getLog();
		
		
		// Lancar evento de inicio de cip
		EventoRN eventoRN = new EventoRN();
		eventoRN.setSession(getDaosession());
		MsEvt msevt = null;
		log.iniciaAvaliacao("incluirEvento");
		msevt = eventoRN.incluirEvento(log, 0, 0, evento, MsTpevtTemplate.Type.FIM_CIP.getId(), null);

		/* Alessandre em 04-05-22 o trecho abaixo foi comentado pois o CIP pode ser finalizado durante uma parada de regulagem
		 * nesse caso, a parada sera fechada e aberta novamente na consolidacao do fim do cip
		if (msevt != null) {
			log.paraAvaliacao(msevt.getIdEvt());
			
			// Verificar se o posto esta em parada de regulagem. Se tiver retornar null para 
			// o coletor poder dar a mensagem NAO REALIZADO
			PTRN prn = new PTRN(dao);
			OmPt ompt;
			try {
				ompt = prn.getOmPt(evento.getIcUpDTO().getUpDTO().getCd_up());
			} catch (RegistroDesconhecidoException e) {
				ompt = null;
			}
			if (ompt != null && ompt.getMsPtColeta() != null && ompt.getMsPtColeta().getIsParada() && ompt.getMsPtColeta().getDwTParada() != null) {
				if (ompt.getMsPtColeta().getDwTParada().getIsRegulagem() != null && ompt.getMsPtColeta().getDwTParada().getIsRegulagem()){
					msevt = null;
				}
			}
		}
		 */
		
		log.info(log.getAvaliacaoCompleta());

		return msevt;
	}
	
	public DwConsolciplog getUltimoCIPByOmPt(OmPt ompt) {
		DwConsolciplog retorno = null;
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("select dwConsolciplog");
		q.append("from DwConsolciplog dwConsolciplog");
		q.append("where dwConsolciplog.omPt.idPt = :idpt ");
		q.append("and dwConsolciplog.dwConsolidByIdConsolidInicio.ppCp.idCp = :idcp");
		q.append("order by dwConsolciplog.dthrIcip desc");
		
		q.defineParametro("idpt", ompt.getIdPt());
		q.defineParametro("idcp", ompt.getPpCp().getIdCp());

		q.setMaxResults(1);
		
		retorno = (DwConsolciplog) q.uniqueResult();
		
		return retorno;
	}
	
	public DwConsolciplog getUltimoCIPByOmPtEDthr(OmPt ompt, Date date) {
		DwConsolciplog retorno = null;
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("select dwConsolciplog");
		q.append("from DwConsolciplog dwConsolciplog");
		q.append("where dwConsolciplog.omPt.idPt = :idpt ");
		q.append("and dwConsolciplog.dwConsolidByIdConsolidInicio.ppCp.idCp = :idcp");
		q.append("and dwConsolciplog.dthrIcip >= :dthr");
		q.append("order by dwConsolciplog.dthrIcip desc");
		
		q.defineParametro("idpt", ompt.getIdPt());
		q.defineParametro("idcp", ompt.getPpCp().getIdCp());
		q.defineParametroTimestamp("dthr", date);

		q.setMaxResults(1);
		
		retorno = (DwConsolciplog) q.uniqueResult();
		
		return retorno;
	}
	
	public static void main(String args[]) {
		ConsolidaRN consolRN = new ConsolidaRN();
		CIPRN cipRN = new CIPRN();
		
		consolRN.iniciaConexaoBanco();
		cipRN.setDaosession(consolRN.getDaoSession());
		
		OmPt ompt = new OmPt();
		ompt.setIdPt(100l);

		DwConsolciplog ciplog = cipRN.getUltimoCIPByOmPt(ompt);
		System.out.println("DthrIcip = " + ciplog.getDthrIcip());
		
		consolRN.finalizaConexaoBanco();
	}
}
