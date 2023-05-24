package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwGrupoFerramenta;

public class DwGrupoFerramentaDAO {

	private final Session session;
	
	public DwGrupoFerramentaDAO(Session session){
		this.session = session;
	}
	
	public List<DwGrupoFerramenta> getDwGrupoFerramenta(DwGrupoFerramenta filtro) {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwGrupoFerramenta gpFerramenta");
		q.append("WHERE 1 = 1");
		if(filtro.getIdGrupoFerramenta() != null) {
			q.append("AND gpFerramenta.idGrupoFerramenta = :id");
		} else {
			if(filtro.getCdGrupoFerramenta() != null && !filtro.getCdGrupoFerramenta().equals("")) {
				q.append("AND gpFerramenta.cdGrupoFerramenta = :cd");
			}
			if(filtro.getDsGrupoFerramenta() != null && !filtro.getDsGrupoFerramenta().equals("")) {
				q.append("AND gpFerramenta.dsGrupoFerramenta = :ds");
			}
			if(filtro.getStAtivo() != null) {
				q.append("AND gpFerramenta.stAtivo = :st");
			}
			if(filtro.getRevisao() != null) {
				q.append("AND gpFerramenta.revisao = :rev");
			}
			if(filtro.getOmUsrByIdUsrstativo() != null && !filtro.getOmUsrByIdUsrstativo().getCdUsr().equals("")) {
				q.append("AND gpFerramenta.omUsrByIdUsrstativo = :usrAti");
			}
			if(filtro.getOmUsrByIdUsrrevisao() != null && !filtro.getOmUsrByIdUsrrevisao().getCdUsr().equals("")) {
				q.append("AND gpFerramenta.omUsrByIdUsrrevisao = :usrRev");
			}
		}
		if(filtro.getIdGrupoFerramenta() != null) {
			q.defineParametro("id", filtro.getIdGrupoFerramenta());
		}
		if(filtro.getCdGrupoFerramenta() != null && !filtro.getCdGrupoFerramenta().equals("")) {
			q.defineParametro("cd", filtro.getCdGrupoFerramenta());
		}
		if(filtro.getDsGrupoFerramenta() != null && !filtro.getDsGrupoFerramenta().equals("")) {
			q.defineParametro("ds", filtro.getDsGrupoFerramenta());
		}
		if(filtro.getStAtivo() != null) {
			q.defineParametro("st", filtro.getStAtivo());
		}
		if(filtro.getRevisao() != null) {
			q.defineParametro("rev", filtro.getRevisao());
		}
		if(filtro.getOmUsrByIdUsrstativo() != null && !filtro.getOmUsrByIdUsrstativo().getCdUsr().equals("")) {
			q.defineParametro("usrAti", filtro.getOmUsrByIdUsrstativo());
		}
		if(filtro.getOmUsrByIdUsrrevisao() != null && !filtro.getOmUsrByIdUsrrevisao().getCdUsr().equals("")) {
			q.defineParametro("usrRev", filtro.getOmUsrByIdUsrrevisao());
		}
		return q.list();
	}
	
	public DwGrupoFerramenta getDwGrupoFerramentaPorId(Long id) {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwGrupoFerramenta gpFerramenta");
		q.append("WHERE gpFerramenta.idGrupoFerramenta = :id");
		q.defineParametro("id", id);
		return (DwGrupoFerramenta) q.uniqueResult();
	}
	
	public DwGrupoFerramenta getDwGrupoFerramentatPorCdAtivoOrderById(String cd) {
		MapQuery q = new MapQuery(session);
		q.append("FROM DwGrupoFerramenta gpFerramenta");
		q.append("WHERE gpFerramenta.cdGrupoFerramenta = :cd");
		q.append("AND gpFerramenta.stAtivo = :st");
		q.append("ORDER BY gpFerramenta.idGrupoFerramenta");
		q.defineParametro("cd", cd);
		q.defineParametro("st", (byte)1);
		q.setMaxResults(1);
		return (DwGrupoFerramenta) q.uniqueResult();
	}
	
	public List<DwGrupoFerramenta> pesquisaDwGrupoFerramenta(String codigo, String descricao) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT r");
		q.append("FROM DwGrupoFerramenta r");
		q.appendWhere(q._NULL, "r.stAtivo = 1", true);
		q.appendWhere(q._AND, "r.cdGrupoFerramenta = :cdGrupoFerramenta", !codigo.equals(""));
		q.appendWhere(q._AND, "r.dsGrupoFerramenta = :dsGrupoFerramenta", !descricao.equals(""));
		if(!codigo.equals("")) {
			q.defineParametro("cdGrupoFerramenta", codigo);
		}
		if(!descricao.equals("")) {
			q.defineParametro("dsGrupoFerramenta", descricao);
		}
		return q.list();
	}
	
}
