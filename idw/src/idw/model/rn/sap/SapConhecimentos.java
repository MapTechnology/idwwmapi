package idw.model.rn.sap;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmUsr;
import idw.model.pojos.TtSapCon;
import idw.util.IdwLogger;
import idw.webservices.dto.SapConhecimentoDTO;
import idw.webservices.dto.SapConhecimentosDTO;

public class SapConhecimentos {
	
	private DAOGenerico dao;
	
	public SapConhecimentos(DAOGenerico dao) {
		this.dao = dao;
	}
	
	public List<TtSapCon> getListaPojosSapConhecimentos(SapConhecimentoDTO filtro) {
		List<TtSapCon> retorno = null;
		
		MapQuery q = new MapQuery(this.dao.getSession());
		
		q.append("select t ");
		q.append("from TtSapCon t ");
		q.appendWhere(MapQuery._NULL, " (t.isImportado is null) OR  (t.isImportado=0) ", true );
		q.appendWhere(MapQuery._NULL, " AND t.idSapcon=:idSapcon ", (filtro!=null && filtro.getSapconhecimento()!=null && filtro.getSapconhecimento().getIdSapcon()!=null && filtro.getSapconhecimento().getIdSapcon().intValue() != 0) );
		q.appendWhere(MapQuery._NULL, " AND t.deposito=':deposito' ", (filtro!=null && filtro.getSapconhecimento()!=null && !filtro.getSapconhecimento().getDeposito().equals("")) );
		q.appendWhere(MapQuery._NULL, " AND t.conhecimento=:conhecimento ", (filtro!=null && filtro.getSapconhecimento()!=null && !filtro.getSapconhecimento().getConhecimento().equals("")) );
		q.appendWhere(MapQuery._NULL, " AND t.dthrReferencia=:dthrReferencia ", (filtro!=null && filtro.getSapconhecimento()!=null) );
		q.appendWhere(MapQuery._NULL, " AND t.dtConhecimento=:dtConhecimento ", (filtro!=null && filtro.getSapconhecimento()!=null) );
		q.appendWhere(MapQuery._NULL, " AND t.centro= ':centro' ", (filtro!=null && filtro.getSapconhecimento()!=null && filtro.getSapconhecimento().getCentro() != null) );
		q.appendWhere(MapQuery._NULL, " AND t.isImportado=:isImportado ", (filtro!=null && filtro.getSapconhecimento()!=null && filtro.getSapconhecimento().getIsImportado() != null) );
		q.appendWhere(MapQuery._NULL, " AND t.dsErro= ':dserro' ", (filtro!=null && filtro.getSapconhecimento()!=null && filtro.getSapconhecimento().getDsErro() != null) );
		if (filtro!=null && filtro.getSapconhecimento()!=null){
			q.defineParametro("idSapcon", String.valueOf(filtro.getSapconhecimento().getIdSapcon()));
			q.defineParametro("deposito", filtro.getSapconhecimento().getDeposito());
			q.defineParametro("conhecimento", String.valueOf(filtro.getSapconhecimento().getConhecimento()));
			q.defineParametroData("dthrReferencia", filtro.getSapconhecimento().getDthrReferencia());
			q.defineParametroData("dtConhecimento", filtro.getSapconhecimento().getDtConhecimento());
			q.defineParametro("centro", filtro.getSapconhecimento().getCentro());
			q.defineParametro("isImportado", String.valueOf(filtro.getSapconhecimento().getIsImportado()));
			q.defineParametro("dserro", filtro.getSapconhecimento().getDsErro());
		}
		retorno = q.list();
		
		return retorno;
	}
	
	public void importarSapConhecimentos(IdwLogger log, int idLog, OmCfg omcfg, OmUsr omusr, SapConhecimentosDTO sapconhecimentosdto) {
		log.info(idLog, 0, "Iniciando avaliacao dos SAP Conhecimentos");
        log.iniciaAvaliacao("SAP Conhecimentos");
    	// SapConhecimentosDTO ... (aqui apenas retorna o j� recebido)
        List<TtSapCon> listasapconhecimentos;
        listasapconhecimentos = getListaPojosSapConhecimentos(null);
        if (listasapconhecimentos!=null)
        {
        	SapConhecimentoDTO newdto = null;
        	List<SapConhecimentoDTO> newlistadto =  new ArrayList<SapConhecimentoDTO>(); 
            for (TtSapCon i : listasapconhecimentos)
            {
            	newdto = new SapConhecimentoDTO();
            	newdto.setSapconhecimento((TtSapCon)i.clone());
            	newlistadto.add(newdto);
            }
            sapconhecimentosdto.setSapconhecimentos(newlistadto);//"fatiriza"
        }
        log.paraAvaliacao();
        log.info(idLog, 0, "Finalizando avaliacao dos SAP Conhecimentos");
        log.info(idLog, 10, "Avaliacao Completa da avaliacao SAP Conhecimentos:");
        log.info(idLog, 20, log.getAvaliacaoCompleta());
        log.info(idLog, 0, "\n\n");
	}
	
}
