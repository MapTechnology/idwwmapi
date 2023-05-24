package idw.model.rn.integracao.siflex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;
import idw.webservices.rest.dto.integracao.siflex.IntegracaoSiflexOcorrenciaParadaDTO;
import idw.webservices.rest.dto.integracao.siflex.IntegracaoSiflexPTDTO;
import idw.webservices.rest.dto.integracao.siflex.IntegracaoSiflexParadaDTO;
import idw.webservices.rest.dto.integracao.siflex.IntegracaoSiflexRAPDTO;
import ms.util.ConversaoTipos;

public class IntegracaoSiflexRN extends AbstractRN<DAOGenerico>{
	public IntegracaoSiflexRN(DAOGenerico dao) {
		super(dao);
		// TODO Auto-generated constructor stub
	}
	
	public IntegracaoSiflexRN() {
		super(new DAOGenerico());
		// TODO Auto-generated constructor stub
	}
	
	private String getParadasAtivas() {
		String strSQL = "";
		strSQL = strSQL.concat(" SELECT par.cd_tparada, par.ds_tparada, tppt.cd_tppt, tppt.ds_tppt, ta.cd_area, ta.ds_area ");
		strSQL = strSQL.concat(" FROM dw_t_parada par ");
		strSQL = strSQL.concat(" JOIN om_tppt tppt ON (tppt.id_tppt = par.id_tppt) ");
		strSQL = strSQL.concat(" JOIN dw_t_area ta ON (ta.id_area = par.id_area) ");
		strSQL = strSQL.concat(" WHERE par.st_ativo = 1 ");
		strSQL = strSQL.concat(" ORDER BY par.cd_tparada, tppt.cd_tppt ");
		
		return strSQL;
	}
	
	private String getPTS() {
		String strSQL = "";
		strSQL = strSQL.concat(" SELECT pt.cd_pt, pt.ds_pt, pt.ds_curta, cc.cd_cc, cc.ds_cc, gt.cd_gt, gt.ds_gt, (CASE WHEN cns.qtdciclos IS NULL THEN 0 ELSE cns.qtdciclos END) as qtdcic ");
		strSQL = strSQL.concat("   FROM om_pt pt ");
		strSQL = strSQL.concat("   LEFT JOIN om_cc cc ON (cc.id_cc = pt.id_cc) ");
		strSQL = strSQL.concat("   LEFT JOIN om_gt gt ON (gt.id_gt = pt.id_gt) ");
		
		
		strSQL = strSQL.concat("   LEFT JOIN (SELECT pt.cd_pt, ");
		strSQL = strSQL.concat("   					 SUM((CASE WHEN dc.qt_auto_cicloprodutivo IS NULL THEN 0 ELSE dc.qt_auto_cicloprodutivo END) + "); 
		strSQL = strSQL.concat("   					     (CASE WHEN dc.qt_manu_cicloprodutivo IS NULL THEN 0 ELSE dc.qt_manu_cicloprodutivo END) + "); 
		strSQL = strSQL.concat("   					     (CASE WHEN dc.qt_auto_cicloimprodutivo IS NULL THEN 0 ELSE dc.qt_auto_cicloimprodutivo END) +  ");
		strSQL = strSQL.concat("   						 (CASE WHEN dc.qt_manu_cicloimprodutivo IS NULL THEN 0 ELSE dc.qt_manu_cicloimprodutivo END) + ");
		strSQL = strSQL.concat("   						 (CASE WHEN dc.qt_auto_cicloregulagem IS NULL THEN 0 ELSE dc.qt_auto_cicloregulagem END) + ");
		strSQL = strSQL.concat("   						 (CASE WHEN dc.qt_manu_cicloregulagem IS NULL THEN 0 ELSE dc.qt_manu_cicloregulagem END)) as qtdciclos ");
		strSQL = strSQL.concat("   			   FROM dw_consolid dci ");
		strSQL = strSQL.concat("   			   JOIN dw_consol dc ON (dc.id_consolid = dci.id_consolid) ");  
		strSQL = strSQL.concat("   			   JOIN om_pt pt ON (pt.id_pt = dci.id_pt) ");
		strSQL = strSQL.concat("   			  WHERE dci.tp_id = 1 ");
		strSQL = strSQL.concat("   			  GROUP BY pt.cd_pt) cns ON (cns.cd_pt = pt.cd_pt) ");

		
		strSQL = strSQL.concat(" WHERE pt.st_ativo = 1 ");
		strSQL = strSQL.concat(" ORDER BY pt.cd_pt ");
		
		return strSQL;
	}
	
	private String getRAPs() {
		String strSQL = "";
		strSQL = strSQL.concat(" SELECT rap.cd_rap, rap.ds_rap, tr.cd_tprap, tr.ds_tprap, (CASE WHEN cns.qtdciclos IS NULL THEN 0 ELSE cns.qtdciclos END) as qtdcic ");
		strSQL = strSQL.concat(" FROM dw_rap rap ");
		strSQL = strSQL.concat(" LEFT JOIN dw_tprap tr ON (tr.id_tprap = rap.id_tprap) ");

		strSQL = strSQL.concat("   LEFT JOIN (SELECT drap.cd_rap, ");
		strSQL = strSQL.concat("   					 SUM((CASE WHEN dc.qt_auto_cicloprodutivo IS NULL THEN 0 ELSE dc.qt_auto_cicloprodutivo END) + "); 
		strSQL = strSQL.concat("   					     (CASE WHEN dc.qt_manu_cicloprodutivo IS NULL THEN 0 ELSE dc.qt_manu_cicloprodutivo END) + "); 
		strSQL = strSQL.concat("   					     (CASE WHEN dc.qt_auto_cicloimprodutivo IS NULL THEN 0 ELSE dc.qt_auto_cicloimprodutivo END) +  ");
		strSQL = strSQL.concat("   						 (CASE WHEN dc.qt_manu_cicloimprodutivo IS NULL THEN 0 ELSE dc.qt_manu_cicloimprodutivo END) + ");
		strSQL = strSQL.concat("   						 (CASE WHEN dc.qt_auto_cicloregulagem IS NULL THEN 0 ELSE dc.qt_auto_cicloregulagem END) + ");
		strSQL = strSQL.concat("   						 (CASE WHEN dc.qt_manu_cicloregulagem IS NULL THEN 0 ELSE dc.qt_manu_cicloregulagem END)) as qtdciclos ");
		strSQL = strSQL.concat("   			   FROM dw_consolid dci ");
		strSQL = strSQL.concat("   			   JOIN dw_consol dc ON (dc.id_consolid = dci.id_consolid) ");
		strSQL = strSQL.concat("   			   JOIN dw_folha df ON (df.id_folha = dci.id_folha) ");
		strSQL = strSQL.concat("   			   JOIN dw_folharap dfr ON (dfr.id_folha = df.id_folha) ");
		strSQL = strSQL.concat("   			   JOIN dw_rap drap ON (drap.id_rap = dfr.id_rap) ");
		strSQL = strSQL.concat("   			  WHERE dci.tp_id = 1 ");
		strSQL = strSQL.concat("   			  GROUP BY drap.cd_rap) cns ON (cns.cd_rap = rap.cd_rap)");
		
		strSQL = strSQL.concat(" WHERE rap.st_ativo = 1 ");
		strSQL = strSQL.concat(" ORDER BY rap.cd_rap ");
		
		return strSQL;
	}
	
	private String getOcorrenciaParada() {
		String strSQL = "";
		strSQL = strSQL.concat(" SELECT ocor.id_consolpalog, pt.cd_pt, par.cd_tparada, tp.cd_tppt, ocor.dthr_iparada, ocor.dthr_fparada ");
		strSQL = strSQL.concat(" FROM dw_consolpalog ocor ");
		strSQL = strSQL.concat(" JOIN dw_t_parada par ON (par.id_tparada = ocor.id_tparada) ");
		strSQL = strSQL.concat(" JOIN om_tppt tp ON (tp.id_tppt = par.id_tppt) ");
		strSQL = strSQL.concat(" JOIN om_pt pt ON (pt.id_pt = ocor.id_pt) ");
		strSQL = strSQL.concat(" WHERE ocor.dthr_iparada BETWEEN :dthrIni AND :dthrFim ");
		strSQL = strSQL.concat(" ORDER BY ocor.id_consolpalog ");
		
		return strSQL;
	}
		
	public SQLQuery setDataHoraParada(SQLQuery q, String dthrIni,String dthrFim) {
		
		try {
			
			Date dthrIniD = DataHoraRN.toDateFromYYYYMMDDHHMISS(dthrIni);
			Date dthrFimD = DataHoraRN.toDateFromYYYYMMDDHHMISS(dthrFim);
			q.setTimestamp("dthrIni", dthrIniD);
			q.setTimestamp("dthrFim", dthrFimD);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return q;
	}
	
	@SuppressWarnings("unchecked")
	public List<IntegracaoSiflexParadaDTO> paradasAtivas() {
		List<IntegracaoSiflexParadaDTO> retorno = new ArrayList<IntegracaoSiflexParadaDTO>();

		int _cdpar = 0;
		int _dspar = _cdpar + 1;
		int _cdtppt = _dspar + 1;
		int _dstppt = _cdtppt + 1;
		int _cdarea = _dstppt + 1;
		int _dsarea = _cdarea + 1;
		
		String strSQL = "";		
		List<Object>  lista = new ArrayList<Object>();
		strSQL = getParadasAtivas();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		lista = q.list();

		for (Object reg : lista) {
			IntegracaoSiflexParadaDTO registro = new IntegracaoSiflexParadaDTO();
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdParada((String) registroLido[_cdpar]);
			registro.setDsParada((String) registroLido[_dspar]);
			registro.setCdTpPT((String) registroLido[_cdtppt]);
			registro.setDsTpPT((String) registroLido[_dstppt]); 			
			registro.setCdArea((String) registroLido[_cdarea]);
			registro.setDsArea((String) registroLido[_dsarea]); 
			
			retorno.add(registro);
			
		}
		q = null;
		lista = null;
		
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<IntegracaoSiflexPTDTO> listaPTDTO(){
		List<IntegracaoSiflexPTDTO> retorno = new ArrayList<IntegracaoSiflexPTDTO>();
		
		int _cdpt = 0;
		int _dspt = _cdpt + 1;
		int _dscurta = _dspt + 1;
		int _cdcc = _dscurta + 1;
		int _dscc = _cdcc + 1;
		int _cdgt = _dscc + 1;
		int _dsgt = _cdgt + 1;
		int _qtcic = _dsgt + 1;
		
		String strSQL = "";		
		List<Object>  lista = new ArrayList<Object>();
		strSQL = getPTS();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		lista = q.list();

		for (Object reg : lista) {
			IntegracaoSiflexPTDTO registro = new IntegracaoSiflexPTDTO();
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdPT((String) registroLido[_cdpt]);
			registro.setDsPT((String) registroLido[_dspt]);
			registro.setDsCurta((String) registroLido[_dscurta]);
			
			registro.setCdCC("");
			registro.setDsCC("");
			registro.setCdGT("");
			registro.setDsGT("");
			
			if (registroLido[_cdcc] != null) {
				registro.setCdCC((String) registroLido[_cdcc]);
				registro.setDsCC((String) registroLido[_dscc]);				
			} 
			 
			if (registroLido[_cdgt] != null) {
				registro.setCdGT((String) registroLido[_cdgt]);
				registro.setDsGT((String) registroLido[_dsgt]);				
			} 
			
			registro.setCiclosExec(ConversaoTipos.converterParaBigDecimal(registroLido[_qtcic]).intValue());

			retorno.add(registro);
			
		}
		q = null;
		lista = null;
		
		return retorno;	
	}
	
	@SuppressWarnings("unchecked")
	public List<IntegracaoSiflexRAPDTO> listaRAPs(){
		List<IntegracaoSiflexRAPDTO> retorno = new ArrayList<IntegracaoSiflexRAPDTO>();
		
		int _cdrap = 0;
		int _dsrap = _cdrap + 1;
		int _cdtprap = _dsrap + 1;
		int _dstprap = _cdtprap +1;
		int _qtcic = _dstprap + 1;
		
		String strSQL = "";		
		List<Object>  lista = new ArrayList<Object>();
		strSQL = getRAPs();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		lista = q.list();

		for (Object reg : lista) {
			IntegracaoSiflexRAPDTO registro = new IntegracaoSiflexRAPDTO();
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;

			registro.setCdRap((String) registroLido[_cdrap]);
			registro.setDsRap((String) registroLido[_dsrap]); 
			
			registro.setCdTpRAP("");
			registro.setDsTpRAP("");
			if (registroLido[_cdtprap] != null) {
				registro.setCdTpRAP((String) registroLido[_cdtprap]);
				registro.setDsTpRAP((String) registroLido[_dstprap]);				
			} 
			
			registro.setCiclosExec(ConversaoTipos.converterParaBigDecimal(registroLido[_qtcic]).intValue());
			
			
			retorno.add(registro);
		}
		q = null;
		lista = null;
		
		return retorno;	
	}
	
	@SuppressWarnings("unchecked")
	public List<IntegracaoSiflexOcorrenciaParadaDTO> listaOcorrenciaParadaMaquina(String dthrIni, String dthrFim){
		List<IntegracaoSiflexOcorrenciaParadaDTO> retorno = new ArrayList<IntegracaoSiflexOcorrenciaParadaDTO>();
		
		int _idparlog = 0;
		int _cdtparada = _idparlog + 1;
		int _cdpt = _cdtparada + 1;
		int _cdtppt = _cdpt + 1;
		int _dthriparada = _cdtppt + 1;
		int _dthrfparada = _dthriparada + 1;
		
		String strSQL = "";		
		List<Object>  lista = new ArrayList<Object>();
		strSQL = getOcorrenciaParada();
		SQLQuery q = this.getDaoSession().createSQLQuery(strSQL);
		q = setDataHoraParada(q, dthrIni, dthrFim);
		lista = q.list();

		for (Object reg : lista) {
			IntegracaoSiflexOcorrenciaParadaDTO registro = new IntegracaoSiflexOcorrenciaParadaDTO();
			Object[] registroLido = null;
			Object registroLidoAux = (Object) reg;
			registroLido = (Object[]) registroLidoAux;
			
			registro.setIdOcorPar(ConversaoTipos.converterParaBigDecimal(registroLido[_idparlog]).intValue());
			registro.setCdParada((String) registroLido[_cdtparada]);
			registro.setCdPT((String) registroLido[_cdpt]); 
			registro.setCdTpPT((String) registroLido[_cdtppt]);
			
			registro.setDthrIniPar(DataHoraRN.dateToStringYYYYDDMMHHMMSS((Date) registroLido[_dthriparada]));
			if (registroLido[_dthrfparada] != null) {
				registro.setDthrFimPar(DataHoraRN.dateToStringYYYYDDMMHHMMSS((Date) registroLido[_dthrfparada]));
			} else {
				registro.setDthrFimPar("");
			}
			
			retorno.add(registro);
		}
		q = null;
		lista = null;
		
		return retorno;	
	}
}
