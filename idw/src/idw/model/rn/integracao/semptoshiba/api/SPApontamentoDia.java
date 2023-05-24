package idw.model.rn.integracao.semptoshiba.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.erp.DAOGenericoErp;
import idw.model.rn.DataHoraRN;

public class SPApontamentoDia {

	private enum Campos{
		COD_PLACA(0),		
		QTD_PRODUZIDO(1),		
		DAT_PRODUCAO(2),		
		COD_LINHA_DEST(3),		
		T1(4),
		T2(5),
		T3(6),
		T4(7);
		private final int id;
		
		Campos(final int id){
			this.id = id;
		}
		
		public int getId(){
			return this.id;
		}
		
	}
	
	private final static String STORE_PROCEDURE_NAME = "spc_MAPApontamentoDia";
	
	private SPApontamentoDia(){		
	}

	private static Query getQuery(DAOGenericoErp dao, Date inicio, Date fim){
	  Query query = dao.createSQLQueryBaseadoStoreProcedure(
			  STORE_PROCEDURE_NAME,
			  2);
	  
	  query.setString(0, DataHoraRN.toStringYYYYMMDD(inicio));
	  query.setString(1, DataHoraRN.toStringYYYYMMDD(fim));
	  
	  return query;			  
	}			
	
	public static List<ApontamentoDia> getResultado(DAOGenericoErp dao, Date inicio, Date fim){
	
		List<ApontamentoDia> listaApontamentos = new ArrayList<ApontamentoDia>();
		Query resul = SPApontamentoDia.getQuery(dao, inicio, fim);
	
		Iterator<?> res = resul.list().iterator();
	
		while (res.hasNext()) {
			
			Object[] registro = (Object[]) res.next();
	
			String cdPlaca = (String) registro[Campos.COD_PLACA.getId()];
			BigDecimal qtdProduzido = (BigDecimal) registro[Campos.QTD_PRODUZIDO.getId()];
			Date dataProducao = (Date) registro[Campos.DAT_PRODUCAO.getId()];
			String codLinhaDest = (String) registro[Campos.COD_LINHA_DEST.getId()];
			BigDecimal t1 = (BigDecimal) registro[Campos.T1.getId()];
			BigDecimal t2 = (BigDecimal) registro[Campos.T2.getId()];
			BigDecimal t3 = (BigDecimal) registro[Campos.T3.getId()];
			BigDecimal t4 = (BigDecimal) registro[Campos.T4.getId()];
			
			if(dataProducao != null && qtdProduzido != null && cdPlaca != null){
				ApontamentoDia apontamentoDia = new ApontamentoDia(cdPlaca, qtdProduzido, dataProducao, codLinhaDest, t1, t2, t3, t4);
				listaApontamentos.add(apontamentoDia);
			}
			
		}
		
		if(listaApontamentos.isEmpty() == false){
			
			Comparator<ApontamentoDia> comparadorDiaApontamento = new Comparator<ApontamentoDia>() {
				@Override
				public int compare(ApontamentoDia o1, ApontamentoDia o2) {
					return DataHoraRN.compareTo(o1.getDataProducaoSemHora(), o2.getDataProducaoSemHora());
				}
			};
			
			Collections.sort(listaApontamentos, comparadorDiaApontamento);
			
		}
		
		return listaApontamentos;
		
	}			
	
}



