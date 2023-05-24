package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhasetup;
import idw.model.pojos.DwRotapasso;

public class DwRotapassoDAO {
	private final Session session;
	
	public DwRotapassoDAO(Session session){
		this.session = session;
	}
	
	public List<DwRotapasso> getRotaPassosComFolha(String cdFolha){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwRotapasso FROM DwRotapasso dwRotapasso ");
		q.append("INNER JOIN dwRotapasso.dwRota dwRota ");
		q.append("INNER JOIN dwRotapasso.dwFolha dwFolha ");
		q.append("WHERE dwRota.stAtivo = :stAtivo");
		q.append("AND dwFolha.cdFolha = :cdFolha");
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("cdFolha", cdFolha);
		return q.list();
	}
	
	public void alterarDwFolhaTodosPassos(String cdFolha, DwFolha dwFolha){
//		MapQuery q = new MapQuery(session);
//		q.append("update DwRotapasso dwRotapasso");
//		q.append(" set dwRotapasso.dwFolha = :dwFolha");
//		q.append(" where dwRotapasso.dwFolha.cdFolha = :cdFolha");
//		q.defineParametro("dwFolha", dwFolha);
//		q.defineParametro("cdFolha", cdFolha);
//		q.query().executeUpdate();
		
		List<DwRotapasso> listaDwRotapasso = getRotaPassosComFolha(cdFolha);
		for(DwRotapasso dwRotapasso: listaDwRotapasso){
			dwRotapasso.setDwFolha(dwFolha);
		}
		
	}
	
	public void alterarDwFolhaTodasSetupsaindo(DwFolha anterior, DwFolha nova) {
		for (DwFolhasetup setup : anterior.getDwFolhasetupsForIdFolhasaindo()) {
			setup.setDwFolhaByIdFolhasaindo(nova);
		}
	}
	
}
