package idw.model.rn.web.taylormade;

import java.math.BigDecimal;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.PpCpDAO;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.DataHoraRN;
import idw.webservices.rest.dto.monitorizacao.FiltroPtCpDTO;
import idw.webservices.rest.taylormade.dto.OpInicioFimDTO;

public class ConsultasWebTaylorMadeRN extends AbstractWebTaylorMadeRN {
	
	//private final String formatoData;
	//private final String formatoDataHora;

	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
	

	public ConsultasWebTaylorMadeRN(DAOGenerico dao) {
		super(dao, FORMATO_DATA, FORMATO_DATA_HORA);
    }
	
	public ConsultasWebTaylorMadeRN(String formatoData, String formatoDataHora) {
        //this(new DAOGenerico(), formatoData, formatoDataHora);
		super(formatoData, formatoDataHora);
    }

    public ConsultasWebTaylorMadeRN(
			DAOGenerico dao, 
			String formatoData,
			String formatoDataHora) {
		super(dao, formatoData, formatoDataHora);
	}
    
    public Long getProducaoIdCpIdPt(FiltroPtCpDTO filtro){
    	 
    	Long idCp = 0L;
    	Long idPt = 0L;
    	String cdCp = "";
    	
    	if (filtro!=null){
    		idCp = filtro.getIdCp();
    		idPt = filtro.getIdPt();
    		cdCp = filtro.getCdCp();
    	}

		Long lRetorno = 0L; 
		
		if (cdCp!=null){ cdCp = cdCp.trim(); }
		if (cdCp!=null && cdCp.equals("")){ cdCp = null; }
		if (cdCp!=null && cdCp.equals("0")){ cdCp = null; }
		if (cdCp!=null){// se foi informado um cdCp
			if (idPt == null || idPt.equals(0L)) { // testa se informado junto o idPt, pois vai precisar
				return lRetorno;
			}
		}

		if (cdCp==null){
			if ( idCp == null || idCp.equals(0L)) {
				return lRetorno;
			}			
		}
		
		MapQuery q = new MapQuery(this.getDaoSession());

		q.append(" SELECT SUM( isnull(p.pcsAutoProducaobruta, 0) - isnull(p.pcsAutoProducaorefugada,0)) as p ");
		q.append(" from DwConsol p ");
		q.append(" WHERE ");
		q.append(" p.dwConsolid.tpId = 1 ");
		if (cdCp!=null){
			q.append(" and p.dwConsolid.ppCp.cdCp = :cdCp and p.dwConsolid.ppCp.stAtivo=1 ");
		} else {
			q.append(" and p.dwConsolid.ppCp.idCp = :idCp ");			
		}
		if (idPt != null && idPt!=0L) {
			q.append(" and p.dwConsolid.omPt.idPt = :idPt ");
		}
		if (cdCp!=null){
			q.defineParametro("cdCp", cdCp);	
		} else {
			q.defineParametro("idCp", idCp);			
		}

		if (idPt != null && idPt!=0L) {
			q.defineParametro("idPt", idPt);
		}


		try {
			lRetorno = ((BigDecimal) q.query().uniqueResult()).longValue() ;
		} catch (NullPointerException e) {
			lRetorno = null;
			e.printStackTrace();
		}

		q = null;

		return lRetorno;
    	
    }
    

    public OpInicioFimDTO getInicioFimCpIdCpIdPt(FiltroPtCpDTO filtro){
   	 
    	Long idCp = 0L;
    	Long idPt = 0L;
    	String cdCp = "";
    	
    	if (filtro!=null){
    		idCp = filtro.getIdCp();
    		idPt = filtro.getIdPt();
    		cdCp = filtro.getCdCp();
    	}

    	OpInicioFimDTO retorno = new OpInicioFimDTO();

		if (cdCp!=null){ cdCp = cdCp.trim(); }
		if (cdCp!=null && cdCp.equals("")){ cdCp = null; }
		if (cdCp!=null && cdCp.equals("0")){ cdCp = null; }
		if (cdCp!=null){// se foi informado um cdCp
			if (idPt == null || idPt.equals(0L)) { // testa se informado junto o idPt, pois vai precisar
				return retorno;
			}
		}
    	
		if (cdCp==null){
			if ( idCp == null || idCp.equals(0L)) {
				return retorno;
			}			
		}

    	
    	PpCpDAO ppCpDAO = new PpCpDAO(getDaoSession());
    	PpCp ppCp = new PpCp();

    	if (cdCp!=null){
    		ppCp = ppCpDAO.getPpCpPorCdCpIdPtOrdeByIdDesc(cdCp, idPt);
    	} else {
        	if (idCp!=null && idCp!=0L){
        		ppCp = ppCpDAO.getPpCpPorId(idCp);	
        	}    		
    	}

    	ppCpDAO = null;
    	
    	if (ppCp==null){ return retorno;}
    	if (ppCp.getIdCp()==null){ return retorno;}
    	if (ppCp.getCdCp()==null){ return retorno;}

		try {
			retorno.setCdCp(ppCp.getCdCp());
			retorno.setIdCp(ppCp.getIdCp().toString());
			if (ppCp.getDthrInicioreal()!=null){
				retorno.setDthrInicio( DataHoraRN.dateToString(ppCp.getDthrInicioreal(), this.formatoDataHora)  );
			}
			if (ppCp.getDthrFinalreal()!=null){
				retorno.setDthrFim( DataHoraRN.dateToString(ppCp.getDthrFinalreal(), this.formatoDataHora)  );
			}
			if (ppCp.getStCp()!=null){
				retorno.setStatusCp(ppCp.getStCp().toString());
				// para este SWITCH, consultar em PpCpTemplate.StCp.
				switch (ppCp.getStCp().intValue()){
					case 0:
						retorno.setNomeStatusCp("CADASTRADA");
						break;
					case 1:
						retorno.setNomeStatusCp("FIRMADA");
						break;
					case 2:
						retorno.setNomeStatusCp("SUSPENSA");
						break;
					case 3:
						retorno.setNomeStatusCp("CANCELADA");
						break;
					case 4:
						retorno.setNomeStatusCp("CONCLUIDA");
						break;
					case 5:
						retorno.setNomeStatusCp("EMSETUP");
						break;
					case 6:
						retorno.setNomeStatusCp("INICIADA");
						break;
					default:
						retorno.setNomeStatusCp("INDEFINIDO");
						break;
				}
			}
			
			
		} catch (NullPointerException e) {
			retorno = null;
			e.printStackTrace();
		}


		return retorno;
    	
    }
    
    
}
