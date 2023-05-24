package idw.model.pojos.template;

import java.util.Date;

import idw.model.pojos.DwMacrange;
import idw.model.rn.DataHoraRN;
import idw.util.CloneUtil;

public abstract class DwMacrangeTemplate extends AbstractTemplate<DwMacrange> {
	
	public enum TpRegra {
		ZTE(1, "ZTE"),
		MITRASTAR(2, "MITRASTAR"),
		LIMITEGLOBAL(3, "LIMITE GLOBAL");
		
		private final int id;
		private final String ds;
		
		TpRegra(int id, String ds) {
			this.id = id;
			this.ds = ds;
		}		
		
		public int getId() {
			return id;
		}

		public String getDs() {
			return ds;
		}

		public static TpRegra get(int id) {
			for(TpRegra item: TpRegra.values()) {
				if(item.getId() == id) {
					return item;
				}
			}
			return null;
		}
		
		public static TpRegra get(String ds) {
			for(TpRegra item: TpRegra.values()) {
				if(item.getDs().equals(ds)) {
					return item;
				}
			}
			return null;
		}
	}
	
	public enum StMacrange {
		COM_MAC_DISPONIVEL(1, "COM_MAC_DISPONIVEL"),
		SEM_MAC_DISPONIVEL(2, "SEM_MAC_DISPONIVEL");
		
		private final int id;
		private final String ds;
		
		StMacrange(int id, String ds) {
			this.id = id;
			this.ds = ds;
		}		
		
		public int getId() {
			return id;
		}

		public String getDs() {
			return ds;
		}

		public static StMacrange get(int id) {
			for(StMacrange item: StMacrange.values()) {
				if(item.getId() == id) {
					return item;
				}
			}
			return null;
		}
		
		public static StMacrange get(String ds) {
			for(StMacrange item: StMacrange.values()) {
				if(item.getDs().equals(ds)) {
					return item;
				}
			}
			return null;
		}
	}

	@Override
	protected DwMacrange atribuir(DwMacrange itemGet, DwMacrange itemSet,
			boolean isCopiarFK) {

		if(itemSet == null){
			itemSet = new DwMacrange();
		}
		
		itemSet.setIdMacrange(itemGet.getIdMacrange());
		itemSet.setCdMacInicial(itemGet.getCdMacInicial());
		itemSet.setCdMacFinal(itemGet.getCdMacFinal());
		itemSet.setCdModelo(itemGet.getCdModelo());
		itemSet.setQtPorpeca(itemGet.getQtPorpeca());
		itemSet.setTpRegra(itemGet.getTpRegra());
		itemSet.setStMacrange(itemGet.getStMacrange());
		itemSet.setDthrCadastro(itemGet.getDthrCadastro());
		itemSet.setCdUltimomacusado(itemGet.getCdUltimomacusado());
		itemSet.setDthrUltimomacusado(itemGet.getDthrUltimomacusado());
		
		if(isCopiarFK) {
			itemSet.setOmUsr(CloneUtil.clone(itemGet.getOmUsr(), false));
			itemSet.setOmGt(CloneUtil.clone(itemGet.getOmGt(), false));
		}
		
		return itemSet;
	}
	
	public void setTpRegraUsandoTemplate(String dsRegra) {
		if(dsRegra == null) {
			dsRegra = "";
		}
		
		TpRegra regra = TpRegra.get(dsRegra);
		if(regra != null) {
			getInstanceT().setTpRegra(regra.getId());
		} else {
			getInstanceT().setTpRegra(0);
		}
	}	
	
	public String getTpRegraFormatado() {
		TpRegra regra = TpRegra.get(getInstanceT().getTpRegra());
		if(regra != null) {
			return regra.getDs();
		}
		return "";
	}
	
	public void setStMacrangeUsandoTemplate(String dsSt) {
		if(dsSt == null) {
			dsSt = "";
		}
		
		StMacrange st = StMacrange.get(dsSt);
		if(st != null) {
			getInstanceT().setStMacrange(st.getId());
		} else {
			getInstanceT().setStMacrange(0);
		}
	}
	
	public String getStMacrangeFormatado() {
		StMacrange st = StMacrange.get(getInstanceT().getStMacrange());
		if(st != null) {
			return st.getDs();
		}
		return "";
	}
	
	public void setDthrCadastroUsandoTemplate(String dthr, String formatoData) {
		if(dthr != null) {
			Date data = DataHoraRN.stringToDate(dthr, formatoData);
			getInstanceT().setDthrCadastro(data);
		} else {
			getInstanceT().setDthrCadastro(null);
		}		
	}
	
	public String getDthrCadastroFormatado(String formatoData) {
		Date data = getInstanceT().getDthrCadastro();
		if(data == null) {
			return "";
		}
		return DataHoraRN.dateToString(data, formatoData);
	}
	
	public void setDthrUltimomacusadoUsandoTemplate(String dthr, String formatoData) {
		if(dthr != null) {
			Date data = DataHoraRN.stringToDate(dthr, formatoData);
			getInstanceT().setDthrUltimomacusado(data);
		} else {
			getInstanceT().setDthrUltimomacusado(null);
		}		
	}
	
	public String getDthrUltimomacusadoFormatado(String formatoData) {
		Date data = getInstanceT().getDthrUltimomacusado();
		if(data == null) {
			return "";
		}
		return DataHoraRN.dateToString(data, formatoData);
	}

}
