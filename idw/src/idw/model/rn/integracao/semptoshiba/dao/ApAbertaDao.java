package idw.model.rn.integracao.semptoshiba.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.erp.DAOGenericoErp;
import idw.model.rn.AbstractRN;
import idw.model.rn.integracao.semptoshiba.pojos.ApAberta;

public final class ApAbertaDao extends AbstractRN<DAOGenericoErp>{


	private enum Campos{
		COD_FAB(0),
		NUM_AP(1),
		COD_MODELO(2),		
		QTD_PLANEJADA(3),		
		QTD_PRODUCAO_BRUTA(4),
		STATUS(5),
		DT(6),
		TIPO(7);
		private final int id;
		
		Campos(final int id){
			this.id = id;
		
		}
		
		public int getId(){
			return this.id;
		}
		
		
	}
	
	private enum TipoAPAberta{
		NORMAL("N"), DAT("D");
		private final String id;
		
		TipoAPAberta(final String id){
			this.id = id;
		}
		
		public String getId(){
			return id;
		}
	}
	
	private enum Status{ 
		EMITIDO(1),
		EMITIDO_PAGAMENTO(2),
		LIBERADO_PRODUCAO(3);
		
		private final int id;
		private Status(final int id){
			this.id = id;
		}
		
		public boolean equals(Integer id){
			return this.id == id;
		}
		
		public boolean equals(String id){
			return equals(Integer.valueOf(id));
		}
		
	}
	
	private final static String STORE_PROCEDURE_NAME = "spc_MAPApsAbertas";
	
	public ApAbertaDao(DAOGenericoErp dao){
		super(dao);
	}
	
	private ApAberta toApAberta(Object[] registro){
		
		final String codFab = (String) registro[Campos.COD_FAB.getId()];
		final String numAp = (String) registro[Campos.NUM_AP.getId()];
		final String codModelo = (String) registro[Campos.COD_MODELO.getId()];
		Integer qtdPlanejada = 0;
		try {
			
			qtdPlanejada = (Integer) registro[Campos.QTD_PLANEJADA.getId()];
		} catch (ClassCastException e) {
			qtdPlanejada = ( (BigDecimal) registro[Campos.QTD_PLANEJADA.getId()]).intValue();
		}
		Integer qtdProducaoBruta = 0;
		try {
			qtdProducaoBruta = (Integer) registro[Campos.QTD_PRODUCAO_BRUTA.getId()];;
		} catch (ClassCastException e) {
			qtdProducaoBruta = ( (BigDecimal) registro[Campos.QTD_PRODUCAO_BRUTA.getId()]).intValue();
		}
		final String status = (String) registro[Campos.STATUS.getId()];
		final Date dtReferencia = (Date) registro[Campos.DT.getId()];
		final String tipo = (String) registro[Campos.TIPO.getId()];	
				
		
		if(codFab != null && numAp != null && codModelo != null && qtdPlanejada != null 
				&& qtdProducaoBruta != null && status != null && dtReferencia != null && tipo != null){

			boolean isDat = tipo.equals(TipoAPAberta.DAT.getId());
			boolean isLiberado = Status.LIBERADO_PRODUCAO.equals(status);
			ApAberta apAberta = new ApAberta(codFab, numAp, codModelo, qtdPlanejada, qtdProducaoBruta, status, dtReferencia, isDat, isLiberado);
			
			return apAberta;
			
		}
		
		return null;

		
	}
	
	public List<ApAberta> getApsAbertas(){
				
		Query q = getDao().createSQLQueryBaseadoStoreProcedure(STORE_PROCEDURE_NAME, 1);
		//q.setParameter(0, DataHoraRN.toStringYYYYMMDD(DataHoraRN.getDataHoraAtual()));
		q.setParameter(0, "");
		
		List<ApAberta> listaApsAbertas = new ArrayList<ApAberta>();
		
		Iterator<?> res = q.list().iterator();
	
		while (res.hasNext()) {
			
			Object[] registro = (Object[]) res.next();
			
			ApAberta apAberta = toApAberta(registro);
			
			if(apAberta != null){
				listaApsAbertas.add(apAberta);
			}
			
		}
		
		return listaApsAbertas;
		
	}

	
}
