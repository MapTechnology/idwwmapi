package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwProcedimento;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.DwProcedimentoDTO;
import idw.webservices.dto.PesquisaDTO;

public class DwProcedimentoDAO {

	private Session session;
	
	public DwProcedimentoDAO(Session session){
		this.session = session;
	}
	
	public List<DwProcedimento> getListaProcedimentos(PesquisaDTO pesquisa) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT t");
		q.append("FROM DwProcedimento t");
		q.append("WHERE t.stAtivo = :stAtivo");
		if (!pesquisa.getCodigo().equals("") && !pesquisa.getDescricao().equals("")) {
			q.append("AND (t.cdProcedimento = :cdProcedimento OR t.dsProcedimento = :dsProcedimento)");
		} else if (!pesquisa.getCodigo().equals("")) {
			q.append("AND t.cdProcedimento = :cdProcedimento");
		} else if (!pesquisa.getDescricao().equals("")) {
			q.append("AND t.dsProcedimento = :dsProcedimento");
		}
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdProcedimento", pesquisa.getCodigo());
		q.defineParametro("dsProcedimento", pesquisa.getDescricao());
		return q.list();
	}
	
	public DwProcedimento getDwProcedimentoFromCd(String cdProcedimento){
		MapQuery q = new MapQuery(session);
		if(!cdProcedimento.equals("")){
			q.append("FROM DwProcedimento t");
			q.append("WHERE t.cdProcedimento = :cdProcedimento");
			q.append("AND t.stAtivo = :stAtivo");
			q.append("ORDER BY t.idProcedimento");
			q.defineParametro("cdProcedimento", cdProcedimento);
			q.defineParametro("stAtivo",(byte) 1);
			q.setMaxResults(1);
			return (DwProcedimento) q.uniqueResult();
		}
		return null;
	}
	
	public DwProcedimento getDwProcedimentoPorId(Long id){
		MapQuery q = new MapQuery(session);
		q.append("FROM DwProcedimento procedimento");
		q.append("WHERE procedimento.idProcedimento = :id");
		q.defineParametro("id", id);
		return (DwProcedimento) q.uniqueResult();
	}
	
	public List<DwProcedimento> getDwProcedimento(DwProcedimentoDTO filtro){
		MapQuery q = new MapQuery(session);
		q.append("SELECT DISTINCT t ");
		q.append("FROM DwProcedimento t ");
		q.append("LEFT JOIN FETCH t.dwProcativs dwProcativ ");
		q.append("LEFT JOIN FETCH t.dwProcarhoms dwProcarhoms ");
		q.append("WHERE 1 = 1 ");
		
		if(filtro.getDwProcedimento().getIdProcedimento() != null && !filtro.getDwProcedimento().getIdProcedimento().equals(0L)){
			q.append("AND t.idProcedimento=:idProcedimento ");
		}else{
			if(filtro.getDwProcedimento().getCdProcedimento() != null && !filtro.getDwProcedimento().getCdProcedimento().equals("")){
				q.append("AND t.cdProcedimento = :cdProcedimento ");
			}
			if(filtro.getDwProcedimento().getDsProcedimento() != null && !filtro.getDwProcedimento().getDsProcedimento().equals("")){
				q.append("AND t.dsProcedimento = :dsProcedimento ");
			}
			if((filtro.getDwProcedimento().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwProcedimento().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getDwProcedimento().getOmUsrByIdUsrstativo().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr = :cdUsrSt ");
			}
			if((filtro.getDwProcedimento().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getDwProcedimento().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getDwProcedimento().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome = :dsNomeSt ");
			}
			if((filtro.getDwProcedimento().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwProcedimento().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getDwProcedimento().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr = :cdUsrRev ");
			}
			if((filtro.getDwProcedimento().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getDwProcedimento().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getDwProcedimento().getOmUsrByIdUsrrevisao().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome = :dsNomeRev ");
			}
			if(filtro.getDwProcedimento().getDtRevisao() != null ){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if(filtro.getDwProcedimento().getDtStativo() != null ){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getDwProcedimento().getRevisao() != null){
				q.append("AND t.revisao = :revisao ");
			}
			if (filtro.getDwProcedimento().getStAtivo() != null && filtro.getDwProcedimento().getStAtivo() < (byte)2){
				q.append("AND t.stAtivo = :stAtivo ");
			}
		}
		if(filtro.getDwProcedimento().getIdProcedimento() != null){
			q.defineParametro("idProcedimento", filtro.getDwProcedimento().getIdProcedimento());
		}
		if(filtro.getDwProcedimento().getCdProcedimento() != null && filtro.getDwProcedimento().getCdProcedimento().equals("") == false){
			q.defineParametro("cdProcedimento", filtro.getDwProcedimento().getCdProcedimento());
		}
		if(filtro.getDwProcedimento().getDsProcedimento() != null){
			q.defineParametro("dsProcedimento", filtro.getDwProcedimento().getDsProcedimento());
		}
		if(filtro.getDwProcedimento().getDtRevisao() != null){
			q.defineParametro("dtRevisao", filtro.getDwProcedimento().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getDwProcedimento().getDtRevisao()));
		}

		if(filtro.getDwProcedimento().getDtStativo() != null){
			q.defineParametro("dtStativo", filtro.getDwProcedimento().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getDwProcedimento().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getDwProcedimento().getRevisao());
		q.defineParametro("stAtivo", filtro.getDwProcedimento().getStAtivo());

		if (filtro.getDwProcedimento().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getDwProcedimento().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getDwProcedimento().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getDwProcedimento().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getDwProcedimento().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getDwProcedimento().getOmUsrByIdUsrstativo().getDsNome());
		}
		return q.list();
	}
	
}
