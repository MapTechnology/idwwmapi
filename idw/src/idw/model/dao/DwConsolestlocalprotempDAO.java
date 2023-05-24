package idw.model.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsolestlocalprotemp;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmUsr;

public class DwConsolestlocalprotempDAO {
	private final Session session;
	
	public DwConsolestlocalprotempDAO(Session session){
		
		this.session = session;
	}
	
	public List<DwConsolestlocalprotemp> getDwConsolestlocalprotemp(int qtRegistros){
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwConsolestlocalprotemp FROM DwConsolestlocalprotemp dwConsolestlocalprotemp ");
		q.append("ORDER BY dwConsolestlocalprotemp.idConsolestlocalprotemp");
		q.setMaxResults(qtRegistros);
		return q.list();
	}
	
	public DwConsolestlocalprotemp incluirDwConsolestlocalprotemp(DwCal dwCal, DwTurno dwTurno, Date dtReferencia, 
			DwEstlocalpro dwEstlocalpro, Date dthrIturno, Date dthrFturno, Integer ano, Integer mes, Byte tpAjusteEstoque, BigDecimal qt, OmUsr omUsr, Date dthr){
		DwConsolestlocalprotemp dwConsolestlocalprotemp = new DwConsolestlocalprotemp();
		dwConsolestlocalprotemp.setDwCal(dwCal);
		dwConsolestlocalprotemp.setDwTurno(dwTurno);
		dwConsolestlocalprotemp.setDtReferencia(dtReferencia);
		dwConsolestlocalprotemp.setDwEstlocalpro(dwEstlocalpro);
		dwConsolestlocalprotemp.setDthrIturno(dthrIturno);
		dwConsolestlocalprotemp.setDthrFturno(dthrFturno);			
		dwConsolestlocalprotemp.setMes(mes) ;
		dwConsolestlocalprotemp.setAno(ano);
		dwConsolestlocalprotemp.setTpAjusteestoque(tpAjusteEstoque);
		dwConsolestlocalprotemp.setQt(qt);
		dwConsolestlocalprotemp.setOmUsr(omUsr);
		dwConsolestlocalprotemp.setDthr(dthr);
		session.saveOrUpdate(dwConsolestlocalprotemp);
		return dwConsolestlocalprotemp;
		
	}
	
	public void excluir(DwConsolestlocalprotemp dwConsolestlocalprotemp){	
		session.delete(dwConsolestlocalprotemp);
	}
	
}
