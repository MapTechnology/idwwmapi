package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmUsr;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.LeituraCODTO;

public class OmUsrDAO {

	private Session session;
	
	public OmUsrDAO(Session session){
		this.session = session;
	}
	
	public OmUsr getOmUsrPorId(LeituraCODTO leitura){
		return getOmUsrPorId(leitura.getIdUsuario());
	}
	
	public OmUsr getOmUsrPorId(long idUsr){
		return getOmUsr(idUsr, null);
	}
	
	public List<OmUsr> getOmUsrs(OmUsr filtro){
		MapQuery q = new MapQuery(session);
		q.append("SELECT t");
		q.append("FROM OmUsr t");
		q.append("WHERE 1 = 1");
		
		if (filtro.getIdUsr() != 0){
			q.append("AND t.idUsr = :idUsr");
		}else{
			if ((filtro.getCdUsr() != null) && !filtro.getCdUsr().equals("")){
				q.append("AND t.cdUsr = :cdUsr");
			}
			if ((filtro.getDsApelido() != null) && !filtro.getDsApelido().equals("")){
				q.append("AND t.dsApelido = :dsApelido");
			}
			if ((filtro.getDsNome() != null) && !filtro.getDsNome().equals("")){
				q.append("AND t.dsNome = :dsNome");
			}
			if (filtro.getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF");
			}
			if (filtro.getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF");
			}
			if ((filtro.getLogin() != null) && !filtro.getLogin().equals("")){
				q.append("AND t.login = :login");
			}
			if ((filtro.getOmCc() != null) && !filtro.getOmCc().getCdCc().equals("")){
				q.append("AND t.omCc.cdCc = :cdCc");
			}
			if ((filtro.getOmCargo() != null) && !filtro.getOmCargo().getDsCargo().equals("")){
				q.append("AND t.omCargo.dsCargo = :dsCargo");
			}
			if ((filtro.getOmCargo() != null) && !filtro.getOmCargo().getCdCargo().equals("")){
				q.append("AND t.omCargo.cdCargo = :cdCargo");
			}
			if ((filtro.getOmCc() != null) && !filtro.getOmCc().getDsCc().equals("")){
				q.append("AND t.omCc.dsCc = :dsCc");
			}
			if ((filtro.getOmUsrByIdUsrrevisao() != null) && !filtro.getOmUsrByIdUsrrevisao().getCdUsr().equals("")){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr = :cdUsrRev");
			}
			if ((filtro.getOmUsrByIdUsrrevisao() != null) && !filtro.getOmUsrByIdUsrrevisao().getDsNome().equals("")){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome = :dsNomeRev");
			}
			if ((filtro.getOmUsrByIdUsrstativo() != null) && !filtro.getOmUsrByIdUsrstativo().getCdUsr().equals("")){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr = :cdUsrSt");
			}
			if ((filtro.getOmUsrByIdUsrstativo() != null) && !filtro.getOmUsrByIdUsrstativo().getDsNome().equals("")){
				q.append("AND t.omUsrByIdUsrstativo.dsNome = :dsNomeSt");
			}
			if ((filtro.getOmUsrgrp() != null) && !filtro.getOmUsrgrp().getCdUsrgrp().equals("")){
				q.append("AND t.omUsrgrp.cdUsrgrp = :cdUsrgrp");
			}
			if (filtro.getRevisao() != null){
				q.append("AND t.revisao = :revisao");
			}
			if ((filtro.getStAtivo() != null) && (filtro.getStAtivo() < (byte)2)){
				q.append("AND t.stAtivo = :stAtivo");
			}
		}
		
		q.defineParametro("idUsr", filtro.getIdUsr());
		q.defineParametro("cdUsr", filtro.getCdUsr());
		q.defineParametro("dsApelido", filtro.getDsApelido());
		q.defineParametro("dsNome", filtro.getDsNome());
		q.defineParametro("login", filtro.getLogin());
		q.defineParametro("revisao", filtro.getRevisao());
		q.defineParametro("stAtivo", filtro.getStAtivo());
		if (filtro.getOmCc() != null){
			q.defineParametro("cdCc", filtro.getOmCc().getCdCc());
			q.defineParametro("dsCc", filtro.getOmCc().getDsCc());
		}
		if (filtro.getOmCargo() != null){
			q.defineParametro("cdCargo", filtro.getOmCargo().getCdCargo());
			q.defineParametro("dsCargo", filtro.getOmCargo().getDsCargo());
		}
		if (filtro.getOmUsrByIdUsrrevisao() != null){
			q.defineParametro("cdUsrRev", filtro.getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getOmUsrByIdUsrstativo().getDsNome());
		}
		if (filtro.getOmUsrgrp() != null){
			q.defineParametro("cdUsrgrp", filtro.getOmUsrgrp().getCdUsrgrp());
			q.defineParametro("dsUsrGrp", filtro.getOmUsrgrp().getDsUsrGrp());
		}
		try {
			q.defineParametroTimestamp("dtRevisao", filtro.getDtRevisao());
			q.defineParametroTimestamp("dtRevisaoF", DataHoraRN.getDataHora235959(filtro.getDtRevisao()));
		} catch (Exception e) {}
		try {
			q.defineParametroTimestamp("dtStativo", filtro.getDtStativo());
			q.defineParametroTimestamp("dtStativoF", DataHoraRN.getDataHora235959(filtro.getDtStativo()));
		} catch (Exception e) {}
		
		return q.list();
	}

	private OmUsr getOmUsr(long idUsr, Byte stAtivo){
		MapQuery q = new MapQuery(session);
		
		q.append("FROM OmUsr t");
		q.append("WHERE t.idUsr =:idUsr");
		
		if(stAtivo != null){
			q.append("AND t.stAtivo = :stAtivo");
		}
		
		q.defineParametro("idUsr", idUsr);
		q.defineParametro("stAtivo", stAtivo);
		
		q.setMaxResults(1);
		
		return (OmUsr) q.uniqueResult();
	}
	
	public OmUsr getOmUsrPorCd(String cdUsr){
		return getOmUsr(cdUsr, null);
	}
	
	public OmUsr getOmUsrPorCdAtivo(String cdUsr){
		return getOmUsr(cdUsr, (byte)1);
	}
	
	private OmUsr getOmUsr(String cdUsr, Byte stAtivo){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmUsr u");
		q.append("WHERE u.cdUsr = :cdUsr");
		if(stAtivo != null){
			q.append("AND u.stAtivo = :stAtivo");
		}
		q.defineParametro("cdUsr", cdUsr);	
		q.defineParametro("stAtivo", stAtivo);	
		return (OmUsr) q.uniqueResult();
	}
	
	public OmUsr getOmUsrPorCdAtivoOrderById(String cdUsr){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmUsr u");
		q.append("WHERE u.cdUsr = :cdUsr");
		q.append("AND u.stAtivo = :stAtivo");
		q.append("ORDER BY u.idUsr");
		q.defineParametro("cdUsr", cdUsr);	
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmUsr) q.uniqueResult();
	}
	
	public OmUsr getOmUsrPorCdeLogin(String cdUsr, String login){
		MapQuery q = new MapQuery(session);
		q.append("FROM OmUsr omusr");
		q.append("WHERE omusr.login = :login");
		q.append("AND omusr.cdUsr <> :cdusr");
		q.append("AND omusr.stAtivo = :stAtivo");
		q.defineParametro("cdusr", cdUsr);
		q.defineParametro("login", login);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmUsr) q.uniqueResult();
	}
	
	public List<OmUsr> getOperadoresAtivos() {
		long ID_GRP_OPERADORES = 4;
		MapQuery q = new MapQuery(session);
		q.append("FROM OmUsr omusr");
		q.append("WHERE omusr.stAtivo = :stativo");
		q.append("AND omusr.omUsrgrp.idUsrgrp = :idgrpusr");
		q.defineParametro("stativo", (byte)1);
		q.defineParametro("idgrpusr", ID_GRP_OPERADORES);
		return q.list();
	}
	
	public OmUsr getOmUsrPorLoginSenha(String login, String senha){
		MapQuery q = new MapQuery(session);
		q.append("SELECT omusr");
		q.append("FROM OmUsr omusr");
		q.append("WHERE omusr.login = :login");
		q.append("AND omusr.senha = :senha");
		q.append("AND omusr.stAtivo = :stAtivo");
		q.defineParametro("login", login);
		q.defineParametro("senha", senha);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (OmUsr) q.uniqueResult();
	}
	
	public List<OmUsr> getTodosOmUsrAtivosOrdenadoPorNome(String exclusiveEsteLogin) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT omusr");
		q.append("FROM OmUsr omusr");
		q.append("WHERE omusr.stAtivo = 1 ");
		if (exclusiveEsteLogin!=null){
			exclusiveEsteLogin = exclusiveEsteLogin.trim();
			if (!exclusiveEsteLogin.equals("")){
				q.append(" AND (omusr.login <> :exclusiveEsteLogin) ");
				q.defineParametro("exclusiveEsteLogin", exclusiveEsteLogin);
			}
		}
		q.append("ORDER BY omusr.dsNome");
		return q.list();
	}
	
}