package injetws.webservices.dto;



import java.math.BigDecimal;

import injetws.model.pojos.PrUpProdutoMatPrima;
import injetws.model.pojos.PrUpProdutoMatPrimaUsada;

@SuppressWarnings("serial")
public class IwsProdMateriaPrimaDTO implements java.io.Serializable {
	
	private String idUp;
	private String cdProduto;
	private String dsProduto;
	private String cdMateriaPrima;
	private String dsMateriaPrima;
	private String unidade;
	private String lote;
	private String estoque;
	private Double quantidade;
	private int stregistro;
	private boolean controlalote;
	private BigDecimal idRegistro; //adicionado para referencia do registro do TDBA
	private Integer erro = null;
	
	public void setIdUp(String idUp) {
		this.idUp = idUp;
	}
	
	public String getIdUp() {
		return idUp;
	}

	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getCdProduto() {
		return cdProduto;
	}

	public void setCdMateriaPrima(String cdMateriaPrima) {
		this.cdMateriaPrima = cdMateriaPrima;
	}

	public String getCdMateriaPrima() {
		return cdMateriaPrima;
	}

	public void setDsMateriaPrima(String dsMateriaPrima) {
		this.dsMateriaPrima = dsMateriaPrima;
	}

	public String getDsMateriaPrima() {
		return dsMateriaPrima;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}

	public String getDsProduto() {
		return dsProduto;
	}
	
	public String getLote() {
		return this.lote;
	}

	public void setLote(String nrlote) {
		this.lote = nrlote;
	}
	
	public Double getQtd() {
		return this.quantidade;
	}

	public void setQtd(Double qtd) {
		this.quantidade = qtd;
	}
	
	public int getStregistro() {
		return this.stregistro;
	}

	public void setStregistro(int stregistro) {
		this.stregistro = stregistro;
	}
	

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

	public String getEstoque() {
		return estoque;
	}
	
	public void setControlalote(boolean controlalote) {
		this.controlalote = controlalote;
	}
	
	public boolean getControlalote() {
		return controlalote;
	}
	
	public void copyPrUpProdMatPrima(PrUpProdutoMatPrima matprima) {
		this.cdMateriaPrima = matprima.getCdmateriaprima();
		this.dsMateriaPrima = matprima.getDsmateriaprima();
		this.cdProduto = matprima.getCdproduto();
		this.dsProduto = null;
		this.idUp = matprima.getPrUp().getIdup().toString();
		this.unidade = matprima.getUnidade();
		this.lote = matprima.getNrlote();
		this.quantidade = null;
		this.stregistro = 0;
		this.estoque = matprima.getCdestoque();
		if(matprima.getControlalote() == '1')
			this.controlalote = true;
		else
			this.controlalote = false;
	}
	
	public void copyProdUltimaMatPrima(PrUpProdutoMatPrimaUsada matprima) {
		if(matprima != null) {
			this.cdMateriaPrima = matprima.getCdmateriaprima();
			this.dsMateriaPrima = matprima.getDsmateriaprima();
			this.cdProduto = matprima.getCdproduto();
			this.dsProduto = null;
			this.idUp = matprima.getIdup();
			this.unidade = matprima.getUnidade();
			this.lote = matprima.getNrlote();
			this.quantidade = matprima.getQtd();
			this.stregistro = Integer.valueOf(matprima.getStregistro());
			this.estoque = matprima.getCdestoque();			
		}
		else {
			this.cdMateriaPrima = null;
			this.dsMateriaPrima = null;
			this.cdProduto = null;
			this.dsProduto = null;
			this.idUp = null;
			this.unidade = null;
			this.lote = null;
			this.quantidade = null;
			this.stregistro = '0';
			this.estoque = null;
		}
	}

	public Integer getErro() {
		return erro;
	}
	public void setErro(Integer erro) {
		this.erro = erro;
	}

	public BigDecimal getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(BigDecimal idRegistro) {
		this.idRegistro = idRegistro;
	}
	
	
}
