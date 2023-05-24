package idw.model.rn;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolrelog;
import idw.model.pojos.OmPt;

public class IhmMobileRN extends AbstractRN<DAOGenerico> {
	
	public IhmMobileRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public DwConsolrelog getUltimoRefugoPt(OmPt omPt) {
		MapQuery q = new MapQuery(this.getDaoSession());
		
		
		q.append("SELECT distinct dwConsolrelog ");
		q.append("FROM DwConsolrelog dwConsolrelog ");
		q.append("left join fetch dwConsolrelog.omProduto pro");
		q.append("left join fetch dwConsolrelog.omPt omPt");
		q.append("left join fetch dwConsolrelog.dwTRefugo dwTRefugo"); 
		q.append("left join fetch dwConsolrelog.dwConsolreocos dwConsolreocos");
		q.append("left join fetch dwConsolreocos.dwConsolre dwConsolre");
		q.append("left join fetch dwConsolre.dwConsol dwConsol");
		q.append("left join fetch dwConsol.dwConsolid dwConsolid");
		q.append("left join fetch dwConsolid.ppCp ppCp");
		q.append("where omPt.idPt = :idPt ");		
		q.append("and (dwConsolrelog.isLancadotm IS NULL OR (dwConsolrelog.isLancadotm IS NOT NULL AND dwConsolrelog.isLancadotm <> true) ) ");
		q.append("and (dwConsolrelog.isCancelado IS NULL OR (dwConsolrelog.isCancelado IS NOT NULL AND dwConsolrelog.isCancelado <> true) ) ");
		q.append("and ppCp.idCp = omPt.ppCp.idCp ");
		q.append("ORDER BY dwConsolrelog.dthrRefugo DESC");

		
		q.defineParametro("idPt", omPt.getIdPt());
	
		q.setMaxResults(1);

		DwConsolrelog reLog = (DwConsolrelog) q.query().uniqueResult();

		return reLog;
	}
	
	public DwConsolpalog getUltimaParadaPt(OmPt omPt) {
		MapQuery q = new MapQuery(this.getDaoSession());
		
		
		q.append("SELECT distinct dwConsolpalog ");
		q.append("FROM DwConsolpalog dwConsolpalog "); 
		q.append("left join fetch dwConsolpalog.omPt omPt");
		q.append("left join fetch dwConsolpalog.dwTParada dwTParada"); 
		q.append("left join fetch dwConsolpalog.ppCp ppCp");
		q.append("left join fetch ppCp.dwFolha dwFolha");
		q.append("left join fetch dwFolha.dwFolharaps dwFolharaps");
		q.append("left join fetch dwFolharaps.dwRap dwRap");
		q.append("where omPt.idPt = :idPt ");		
		q.append("and ppCp.idCp = omPt.ppCp.idCp ");
		q.append("ORDER BY dwConsolpalog.dthrIparada DESC");
	
		q.defineParametro("idPt", omPt.getIdPt());
	
		q.setMaxResults(1);

		DwConsolpalog paLog = (DwConsolpalog) q.query().uniqueResult();

		return paLog;
	}
}
