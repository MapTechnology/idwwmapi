package idw.webservices.dto;

public class PrevisaoDTO {
	
	private String maquina;
	private String produto;
	private String slot;
	private long qtd;
	private long ritmo;
	
	public PrevisaoDTO(String maquina, String produto, String slot, long qtd,long ritmo) {
		super();
		this.maquina = maquina;
		this.produto = produto;
		this.slot = slot;
		this.qtd = qtd;
		this.ritmo = ritmo;
	}

	public String getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public long getRitmo() {
		return ritmo;
	}

	public void setRitmo(long ritmo) {
		this.ritmo = ritmo;
	}
	
	
	
	

}
