package idw.model.rn.integracao.semptoshiba.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.StoreProcedure;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.rn.DataHoraRN;

public final class SPApontamento extends StoreProcedure{

	private enum Campos{
		ID(0),
		COD_PLACA(1),		
		QTD_PRODUZIDO(2),		
		DAT_PRODUCAO(3);
		private final int id;
		
		Campos(final int id){
			this.id = id;
		}
		
		public int getId(){
			return this.id;
		}
		
	}
	
	private final static String STORE_PROCEDURE_NAME = "spc_MAPApontamento";
	
	public SPApontamento(DAOGenericoErp dao){
		super(dao);
	}

	
	public List<Apontamento> getResultado(){
	
		List<Apontamento> listaApontamentos = new ArrayList<Apontamento>();
		Query resul = getQuery();
	
		Iterator<?> res = resul.list().iterator();
	
		while (res.hasNext()) {
			
			Object[] registro = (Object[]) res.next();
	
			String cdPlaca = (String) registro[Campos.COD_PLACA.getId()];
			BigDecimal qtdProduzido = (BigDecimal) registro[Campos.QTD_PRODUZIDO.getId()];
			Date dataProducao = (Date) registro[Campos.DAT_PRODUCAO.getId()];
			String id = (String) registro[Campos.ID.getId()];
	
			
			if(id != null && dataProducao != null && qtdProduzido != null && cdPlaca != null){
				Apontamento apontamento= new Apontamento(id, cdPlaca, qtdProduzido, dataProducao);
				listaApontamentos.add(apontamento);
			}
			
		}
		
		if(listaApontamentos.isEmpty() == false){
			
			Comparator<Apontamento> comparadorDiaApontamento = new Comparator<Apontamento>() {
				@Override
				public int compare(Apontamento o1, Apontamento o2) {
					return DataHoraRN.compareTo(o1.getDataApontamento(), o2.getDataApontamento());
				}
			};
			
			Collections.sort(listaApontamentos, comparadorDiaApontamento);
			
		}
		
		return listaApontamentos;
		
	}

	@Override
	public String getName() {
		return STORE_PROCEDURE_NAME;
	}			
	

	
	

	
	
}
