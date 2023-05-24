package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.erp.DAOGenericoErp;
import idw.model.pojos.PpCpproduto;
import idw.util.IdwLogger;

public class CpViewRN  extends AbstractRN<DAOGenericoErp>{

	private DAOGenericoErp dao;
	
	public CpViewRN(){
		this(new DAOGenericoErp());
	}
	
	public CpViewRN(DAOGenericoErp dao) {
		super(dao);
		this.dao = dao;
	}
	
	public List<PpCpproduto> verificaApAberta(IdwLogger log, int idLog, int identacao){
		log.info(idLog, identacao, "VerificaApsAbertas");
		List<PpCpproduto> retorno = new ArrayList<PpCpproduto>();
		//String stringData = DataHoraRN.dateToString(new Date(), "yyyy-MM-dd");
		String stringData = DataHoraRN.dateToString(DataHoraRN.getPrimeiroDiaDoMesDaData(new Date()), "yyyy-MM-dd");
		
		try{
			Query resul = dao.getSession().createSQLQuery("{call spc_MAPApsAbertas(?)}");
			
			//CallableStatement resul = dao.getSession().connection().prepareCall("{call spc_MAPApsAbertas(?)}");
			resul.setString(1, stringData);
			//ResultSet res = resul.executeQuery();
			Iterator res = resul.list().iterator();
			  
			while (res.hasNext()){
				Object registro = res.next();
				/*
				if (res.getString(6).equals("03")){
					PpCpproduto ppcpProduto = new PpCpproduto();
					OmProduto omProduto = new OmProduto();
					omProduto.setCdProduto(res.getString(3));
					
					PpCp novo = new PpCp();
					novo.setCdCp(res.getString(2));
					novo.setDtRevisao(res.getDate(7));
					
					ppcpProduto.setOmProduto(omProduto);
					ppcpProduto.setPcsProducaoplanejada(res.getDouble(4));
					ppcpProduto.setPcsProducaobruta(res.getDouble(5));
					ppcpProduto.setPpCp(novo);
					
					retorno.add(ppcpProduto);
				}*/								
			}
		}catch (Exception e) {
			return null;
		}
			
		return retorno;
	}
	
	  

}
