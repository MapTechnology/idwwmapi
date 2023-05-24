package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionException;

import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;

public class DwFolharapTemplate extends AbstractTemplate<DwFolharap> {

	/**
	 * Pega o peso bruto do produto de DwFolharapcom
	 * @return
	 */
	public BigDecimal gPesoBrutoProd(long idProduto){
		BigDecimal retorno = new BigDecimal(0);
		
		DwFolharap dwFolharap = (DwFolharap) this;
		
		for(DwFolharapcom dwFolharapcom: dwFolharap.getDwFolharapcoms() ){
			if(dwFolharapcom.getOmProduto() != null && dwFolharapcom.getOmProduto().getIdProduto() == idProduto){
				retorno.add(dwFolharapcom.getOmProduto().getGPesoBruto());
			}
		}
		return retorno;
		
	}
	
	/**
	 * Pega o peso l�quido do produto de DwFolharapcom
	 * @return
	 */
	public BigDecimal gPesoLiquidoProd(long idProduto){
		BigDecimal retorno = new BigDecimal(0);
		
		DwFolharap dwFolharap = (DwFolharap) this;
		
		for(DwFolharapcom dwFolharapcom: dwFolharap.getDwFolharapcoms() ){
			if(dwFolharapcom.getOmProduto() != null 
					&& dwFolharapcom.getOmProduto().getIdProduto() == idProduto 
					&& dwFolharapcom.getOmProduto().getGPesoLiquido() != null){
				retorno.add(dwFolharapcom.getOmProduto().getGPesoLiquido());
			}
		}
		return retorno;
		
	}	
	
	
	/**
	 * Pega o peso bruto de DwFolharapcom
	 * @return
	 */
	public BigDecimal gPesoBruto(){
		BigDecimal retorno = new BigDecimal(0);
		
		DwFolharap dwFolharap = (DwFolharap) this;
		
		for(DwFolharapcom dwFolharapcom: dwFolharap.getDwFolharapcoms() ){
			if(dwFolharapcom.getOmProduto() != null && dwFolharapcom.getOmProduto().getGPesoBruto() != null){
				retorno.add(dwFolharapcom.getOmProduto().getGPesoBruto());
			}
		}
		return retorno;
		
	}
	
	/**
	 * Pega o peso l�quido do produto de DwFolharapcom
	 * @return
	 */
	public BigDecimal gPesoLiquido(){
		BigDecimal retorno = new BigDecimal(0);
		
		DwFolharap dwFolharap = (DwFolharap) this;
		
		for(DwFolharapcom dwFolharapcom: dwFolharap.getDwFolharapcoms() ){
			if(dwFolharapcom.getOmProduto() != null && dwFolharapcom.getOmProduto().getGPesoLiquido() != null){
				retorno.add(dwFolharapcom.getOmProduto().getGPesoLiquido());
			}
		}
		return retorno;
		
	}	
	
	/**
	 * Pega a quantidade de cavidade ativa de DwFolharapcom
	 * @return
	 */
	public BigDecimal qtAtivaProd(long idProduto){
		BigDecimal retorno = new BigDecimal(0);
		
		DwFolharap dwFolharap = (DwFolharap) this;
		
		for(DwFolharapcom dwFolharapcom: dwFolharap.getDwFolharapcoms() ){
			if(dwFolharapcom.getOmProduto() != null 
					&& dwFolharapcom.getOmProduto().getIdProduto() == idProduto
					&& dwFolharapcom.getQtAtiva() != null){
				retorno.add(dwFolharapcom.getQtAtiva());
			}
		}
		return retorno;
		
	}
	
	/**
	 * Pega a quantidade de cavidade total de DwFolharapcom
	 * @return
	 */
	public BigDecimal qtTotalProd(long idProduto){
		BigDecimal retorno = new BigDecimal(0);
		
		DwFolharap dwFolharap = (DwFolharap) this;
		
		for(DwFolharapcom dwFolharapcom: dwFolharap.getDwFolharapcoms() ){
			if(dwFolharapcom.getOmProduto() != null 
					&& dwFolharapcom.getOmProduto().getIdProduto() == idProduto
					&& dwFolharapcom.getQtTotal() != null){
				retorno.add(dwFolharapcom.getQtTotal());
			}
		}
		return retorno;
		
	}	
	
	/**
	 * Pega a quantidade ativa de cada DwFolharapcom
	 * @return
	 */
	public BigDecimal totalQtAtiva(){
		BigDecimal retorno = new BigDecimal(0);
		
		DwFolharap dwFolharap = (DwFolharap) this;
		
		for(DwFolharapcom dwFolharapcom: dwFolharap.getDwFolharapcoms() ){
			if(dwFolharapcom.getQtAtiva() != null){
				retorno.add(dwFolharapcom.getQtAtiva());
			}
		}
		return retorno;
		
	}
	
	/**
	 * Pega a quantidade total de cada DwFolharapcom
	 * @return
	 */
	public BigDecimal totalQtTotal(){
		BigDecimal retorno = new BigDecimal(0);
		
		DwFolharap dwFolharap = (DwFolharap) this;
		
		for(DwFolharapcom dwFolharapcom: dwFolharap.getDwFolharapcoms() ){
			if(dwFolharapcom.getQtTotal() != null){
				retorno.add(dwFolharapcom.getQtTotal());
			}
		}
		return retorno;
		
	}

	
	@Override
	protected DwFolharap atribuir(DwFolharap from, DwFolharap to, boolean isCopiarFK) {
		if (to == null)
			to = new DwFolharap();

		/*
		if (to.getDwFolha()!= null){
			to.setDwFolha((DwFolha) from.getDwFolha().clone());
		}
		*/
		to.setIdFolharap(from.getIdFolharap());
		to.setQtUsada(from.getQtUsada());
		to.setSegTempopreparacao(from.getSegTempopreparacao());

		if (isCopiarFK == true) {
			if(from.getDwFolharapcoms() != null) {
				try {
					Set<DwFolharapcom> lista  = new HashSet<DwFolharapcom>();
					for(DwFolharapcom rapcom : from.getDwFolharapcoms()) {
						lista.add(rapcom.clone());
					}
					to.setDwFolharapcoms(lista);
				}catch(SessionException e) {
					to.setDwFolharapcoms(null);
				}
			}
			
			if(from.getDwRap() != null) {
				try {
					to.setDwRap(from.getDwRap().clone(false));
				}catch(SessionException e) {
					to.setDwRap(null);
				}
			}
		}
		
		return to;
	}
}
