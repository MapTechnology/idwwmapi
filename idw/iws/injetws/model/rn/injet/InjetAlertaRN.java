package injetws.model.rn.injet;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.util.IdwLogger;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import idw.model.rn.DataHoraRN;
import injetws.webservices.dto.IwsAlertaDTO;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.MapQuery;
import ms.model.dao.AbstractInjetDAO;
import idw.model.pojos.injet.Ijalertas;
import idw.model.pojos.injet.Ijtbale;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;

public class InjetAlertaRN extends AbstractInjetDAO {
	
	public InjetAlertaRN(DAOGenericoInjet daoInjet) {
		Validate.notNull(daoInjet);
		
		this.setDaoInjet(daoInjet);
	}

	public List<IwsAlertaDTO> pesquisaAlertasEmAberto(IdwLogger log, int idLog, String cdMaquina) throws SemSGBDException, IllegalArgumentException {
		return pesquisaAlertas(log, idLog, cdMaquina, false,false,null,0);
	}
	
	public List<IwsAlertaDTO> pesquisaAlertasAptDiariodeBordo(IdwLogger log, int idLog, String cdMaquina) throws SemSGBDException, IllegalArgumentException {
		return pesquisaAlertas(log, idLog, cdMaquina, true,false,null,0);
	}
	
	public List<IwsAlertaDTO> pesquisaAlertasProblemaQualidade(IdwLogger log, int idLog, String cdMaquina) throws SemSGBDException, IllegalArgumentException {
		return pesquisaAlertas(log, idLog, cdMaquina, false,true,null,1);
	}
	
	public IwsAlertaDTO pesquisaAlertaEspecifico(IdwLogger log, int idLog, String cdMaquina,String cdALerta) throws SemSGBDException, IllegalArgumentException {
		return pesquisaAlertas(log, idLog, cdMaquina, false,false,cdALerta,1).get(0);
	}

	public List<IwsAlertaDTO> pesquisaAlertas(IdwLogger log, int idLog, String cdMaquina,boolean getDBQ001,boolean getQLD001,String cdALerta,int maxresult) throws SemSGBDException, IllegalArgumentException {
		if (cdMaquina == null) { // se nao conseguir pegar o codigo de maquina
			// lancar a exception, argumento invalido
			throw new IllegalArgumentException("Nao foi possivel pegar o codigo da maquina");
		}
		List<IwsAlertaDTO> retorno= null;
		MapQuery q = new MapQuery(getDaoInjet().getSession());
		
		q.append("from Ijalertas oijale ");
		if(getDBQ001)
			q.append("left join fetch oijale.ijaledbqlds oijaleqld ");
		q.append("where (oijale.dthrfalerta IS NULL) " );
		
		if(getDBQ001){ // alerta de apontamento de di�rio de bordo pendente
			q.append("and (oijaleqld.anotado='0') ");
			q.append("and (oijale.id.cdalerta='DBQ001') ");
		}else if(getQLD001){ // alerta de problema de qualidade
			q.append("and (oijale.id.cdalerta='QLD001') ");
		}else if(cdALerta!=null)// busca um alerta especifico
			q.append("and (oijale.id.cdalerta=:cdAlerta ) ");
		
		q.append("and (oijale.id.cdinjetora=:cdMaquina) ");		
		q.append("order by oijale.id.dthrialerta ");
		
		if(cdALerta!=null)
			q.defineParametro("cdAlerta", cdALerta);
		q.defineParametro("cdMaquina", cdMaquina);		
		if(maxresult>0)
			q.setMaxResults(maxresult);
		
		try{
			List<Ijalertas> listaAlertas=q.list();
			if(listaAlertas.size()>0){
				retorno= new ArrayList<IwsAlertaDTO>();
				for(Ijalertas otbl: listaAlertas ){
					IwsAlertaDTO dto = new IwsAlertaDTO();
					dto.setCdAlerta(otbl.getId().getCdalerta());
					dto.setDsAlerta(otbl.getIjtbale().getDsalerta());
					dto.setdthrinialerta(otbl.getId().getDthrialerta());
					dto.setmsDtHrIniAlerta(DataHoraRN.getApenasMilisegundos(otbl.getId().getDthrialerta()));
					dto.setIdAlerta(otbl.getId().getCdalerta());
					dto.setTpAlerta(otbl.getLgeradoautomatico().intValue());
					retorno.add(dto);
				}
			}
		}catch(Exception e){
			log.info("Exception ao tentar obter a lista de alertas: " + cdMaquina);
		}	
		return retorno;
	}
	
	public IwsAlertaDTO getTr_TabAlertaSetaCod(String cdAlerta)
			throws RegistroDesconhecidoException {

		Ijtbale ijtbale = getIjtbale(cdAlerta);

		IwsAlertaDTO alertaDTO = new IwsAlertaDTO();
		// copiando dados para o DTO
		if (ijtbale != null) {
			alertaDTO.setCdAlerta(ijtbale.getCdalerta());
			alertaDTO.setDsAlerta(ijtbale.getDsalerta());
			alertaDTO.setIdAlerta(ijtbale.getCdalerta());
		}

		return (alertaDTO);
	}

	/**
	 * Recuperar alerta de ijtbale
	 * 
	 * @param cdAlerta
	 *            C�digo do alerta
	 * @return Alerta
	 * @throws RegistroDesconhecidoException
	 */
	public Ijtbale getIjtbale(String cdAlerta)
			throws RegistroDesconhecidoException {

		StringBuilder hql = new StringBuilder();
		hql.append(" SELECT ijtbale ");
		hql.append(" FROM Ijtbale ijtbale ");
		hql.append(" WHERE (ijtbale.cdalerta= :cdAlerta) ");
		hql.append(" AND (ijtbale.cdalerta <> '999999') ");
		hql.append(" AND (ijtbale.cdalerta <> 'EXT001') ");
		hql.append(" AND (ijtbale.cdalerta <> 'EXT002') ");
		hql.append(" AND (ijtbale.cdalerta <> 'QLD001') ");
		hql.append(" AND (ijtbale.cdalerta <> 'DBQ001') ");

		Query q = this.getDaoInjet().getSession().createQuery(hql.toString());

		// Atualiza parametros
		q.setParameter("cdAlerta", cdAlerta);

		Ijtbale ijtbale = null;
		ijtbale = (Ijtbale) q.uniqueResult();
		if (ijtbale == null && !cdAlerta.equals("QLD001")) {
			throw new RegistroDesconhecidoException();
		}
		return ijtbale;
	}
	
	public IwsAlertaDTO getIwsAlertaDTOByCdAlerta(String cdAlerta)
			throws RegistroDesconhecidoException {

		Ijtbale ijtbale = getIjtbaleIncluindoDefault(cdAlerta);

		IwsAlertaDTO alertaDTO = new IwsAlertaDTO();
		// copiando dados para o DTO
		if (ijtbale != null) {
			alertaDTO.setCdAlerta(ijtbale.getCdalerta());
			alertaDTO.setDsAlerta(ijtbale.getDsalerta());
			alertaDTO.setIdAlerta(ijtbale.getCdalerta());
		}

		return (alertaDTO);
	}
	
	
	/**
	 * Recuperar alerta de ijtbale
	 * 
	 * @param cdAlerta
	 *            C�digo do alerta
	 * @return Alerta
	 * @throws RegistroDesconhecidoException
	 */
	public Ijtbale getIjtbaleIncluindoDefault(String cdAlerta)
			throws RegistroDesconhecidoException {

		StringBuilder hql = new StringBuilder();
		hql.append(" SELECT ijtbale ");
		hql.append(" FROM Ijtbale ijtbale ");
		hql.append(" WHERE (ijtbale.cdalerta= :cdAlerta) ");

		Query q = this.getDaoInjet().getSession().createQuery(hql.toString());

		// Atualiza parametros
		q.setParameter("cdAlerta", cdAlerta);

		Ijtbale ijtbale = null;
		ijtbale = (Ijtbale) q.uniqueResult();
		if (ijtbale == null ) {
			throw new RegistroDesconhecidoException();
		}
		return ijtbale;
	}

}
