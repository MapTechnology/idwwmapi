package injetws.webservices.dto;

import injetws.model.pojos.PrUpCtrlExecinspecao;
import injetws.model.pojos.PrUpExecinspecao;

import java.math.BigDecimal;

public class IwsDadosInspDTO {
	public static int DRV_MARPOSS_E4N = 1;
	public static int DRV_MULTIINSTRUMENTO = 2;
	
	private String idExecInpecao;	
	private PrUpCtrlExecinspecao prUpCtrlExecinspecao;	
	private String idInspecao;
	private int ordemLeitura;
	private String idParametro;
	private Character tpParametro;
	private String dsParametro;
	private String cdProduto;
	private String dsProduto;
	private Integer tamAmostra;
	private BigDecimal idCavidade;
	private String nmCavidade;
	private int amostra;
	private Integer subAmostra;
	private Float vlLido;
	private Character stExecucao;
	private String idParametroComp;
	private Integer tpEntradaVlr;
	private String idDriver;
	private String porta;
	private String lipercTolerancia;
	private String lspercTolerancia;
	
	public IwsDadosInspDTO(){
	}
	
	public  void copyPrUpExecinspecao(PrUpExecinspecao execinsp) {
			
//			String idExecInpecao,
//			String idInspecao, int ordemLeitura,
//			String idParametro, char tpParametro, String dsParametro,
//			String cdProduto, String dsProduto, Integer tamAmostra,
//			BigDecimal idCavidade, String nmCavidade, int amostra,
//			Integer subAmostra, Float vlLido, char stExecucao,
//			String idParametroComp, Integer tpEntradaVlr, String idDriver,
//			BigDecimal lipercTolerancia, BigDecimal lspercTolerancia) {
		this.idExecInpecao = execinsp.getIdExecInpecao();		
		this.idInspecao = execinsp.getIdInspecao();
		this.ordemLeitura = execinsp.getOrdemLeitura();
		this.idParametro = execinsp.getIdParametro();
		this.tpParametro = execinsp.getTpParametro();
		this.dsParametro = execinsp.getDsParametro();
		this.cdProduto = execinsp.getCdProduto();
		this.dsProduto = execinsp.getDsProduto();
		this.tamAmostra = execinsp.getTamAmostra();
		this.idCavidade = execinsp.getIdCavidade();
		this.nmCavidade = execinsp.getNmCavidade();
		this.amostra = execinsp.getAmostra();
		this.subAmostra = execinsp.getSubAmostra();
		this.vlLido = execinsp.getVlLido();
		this.stExecucao = execinsp.getStExecucao();
		this.idParametroComp = execinsp.getIdParametroComp();
		this.tpEntradaVlr = execinsp.getTpEntradaVlr();
		this.idDriver = execinsp.getIdDriver();
		this.lipercTolerancia = execinsp.getLipercTolerancia().toString();
		this.lspercTolerancia = execinsp.getLspercTolerancia().toString();
	}
	
	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getIdExecInpecao() {
		return this.idExecInpecao;
	}

	public void setIdExecInpecao(String idExecInpecao) {
		this.idExecInpecao = idExecInpecao;
	}


	public String getIdInspecao() {
		return this.idInspecao;
	}

	public void setIdInspecao(String idInspecao) {
		this.idInspecao = idInspecao;
	}


	public int getOrdemLeitura() {
		return this.ordemLeitura;
	}

	public void setOrdemLeitura(int ordemLeitura) {
		this.ordemLeitura = ordemLeitura;
	}


	public String getIdParametro() {
		return this.idParametro;
	}

	public void setIdParametro(String idParametro) {
		this.idParametro = idParametro;
	}


	public char getTpParametro() {
		return this.tpParametro;
	}

	public void setTpParametro(char tpParametro) {
		this.tpParametro = tpParametro;
	}


	public String getDsParametro() {
		return this.dsParametro;
	}

	public void setDsParametro(String dsParametro) {
		this.dsParametro = dsParametro;
	}


	public String getCdProduto() {
		return this.cdProduto;
	}

	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}


	public String getDsProduto() {
		return this.dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}


	public Integer getTamAmostra() {
		return this.tamAmostra;
	}

	public void setTamAmostra(Integer tamAmostra) {
		this.tamAmostra = tamAmostra;
	}


	public BigDecimal getIdCavidade() {
		return this.idCavidade;
	}

	public void setIdCavidade(BigDecimal idCavidade) {
		this.idCavidade = idCavidade;
	}


	public String getNmCavidade() {
		return this.nmCavidade;
	}

	public void setNmCavidade(String nmCavidade) {
		this.nmCavidade = nmCavidade;
	}


	public int getAmostra() {
		return this.amostra;
	}

	public void setAmostra(int amostra) {
		this.amostra = amostra;
	}


	public Integer getSubAmostra() {
		return this.subAmostra;
	}

	public void setSubAmostra(Integer subAmostra) {
		this.subAmostra = subAmostra;
	}


	public Float getVlLido() {
		return this.vlLido;
	}

	public void setVlLido(Float vlLido) {
		this.vlLido = vlLido;
	}


	public char getStExecucao() {
		return this.stExecucao;
	}

	public void setStExecucao(char stExecucao) {
		this.stExecucao = stExecucao;
	}


	public String getIdParametroComp() {
		return this.idParametroComp;
	}

	public void setIdParametroComp(String idParametroComp) {
		this.idParametroComp = idParametroComp;
	}


	public Integer getTpEntradaVlr() {
		return this.tpEntradaVlr;
	}

	public void setTpEntradaVlr(Integer tpEntradaVlr) {
		this.tpEntradaVlr = tpEntradaVlr;
	}


	public String getIdDriver() {
		return this.idDriver;
	}

	public void setIdDriver(String idDriver) {
		this.idDriver = idDriver;
	}


	public String getLipercTolerancia() {
		return this.lipercTolerancia;
	}

	public void setLipercTolerancia(String lipercTolerancia) {
		if(lipercTolerancia != null)
			this.lipercTolerancia = lipercTolerancia;
		else
			this.lipercTolerancia = null;
	}


	public String getLspercTolerancia() {
		return this.lspercTolerancia;
	}

	public void setLspercTolerancia(String lspercTolerancia) {
		if(lspercTolerancia != null)
			this.lspercTolerancia = lspercTolerancia;
		else
			this.lspercTolerancia = null;
	}

	public PrUpCtrlExecinspecao getPrUpCtrlExecinspecao() {
		return this.prUpCtrlExecinspecao;
	}

	public void setPrUpCtrlExecinspecao(PrUpCtrlExecinspecao prUp) {
		this.prUpCtrlExecinspecao = prUp;
	}

}
