package idw.webservices.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.OmUsr;
import idw.model.pojos.PpNecimp;
import idw.model.pojos.PpNecimplog;
import idw.model.pojos.PpNecimpurl;

public class PpNecListDTO {
	
	private Date dthrInicioGeral;
	private Integer mesReferencia;
	private Integer anoReferencia;
	private PpNecimp ppnecimp;
	private OmUsr omusr;
	private Date dthrIimportacao;
	private Date dthrFimportacao;
	private String urlArquivo;
	private PpNecimpurl ppnecimpurl;
	private Byte stImp;
	private String dsErro;
	private String aba;
	private List<PpNecDTO> ppNecDTO =  new ArrayList<PpNecDTO>();
	private ResultadoDTO resultadoDTO = new ResultadoDTO();
	private PpNecimplog ppnecimplog; // armazena
	
	private List<ProdutoDTO> resultadoIntegProdutos = new ArrayList<ProdutoDTO>(); 
	
	
	public List<ProdutoDTO> getResultadoIntegProdutos() {
		return resultadoIntegProdutos;
	}

	public void setResultadoIntegProdutos(List<ProdutoDTO> resultadoIntegProdutos) {
		this.resultadoIntegProdutos = resultadoIntegProdutos;
	}

	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}

	public Date getDthrIimportacao() {
		return dthrIimportacao;
	}

	public void setDthrIimportacao(Date dthrIimportacao) {
		this.dthrIimportacao = dthrIimportacao;
	}

	public Date getDthrFimportacao() {
		return dthrFimportacao;
	}

	public void setDthrFimportacao(Date dthrFimportacao) {
		this.dthrFimportacao = dthrFimportacao;
	}

	public String getUrlArquivo() {
		return urlArquivo;
	}

	public void setUrlArquivo(String urlArquivo) {
		this.urlArquivo = urlArquivo;
	}

	public PpNecimpurl getPpnecimpurl() {
		return ppnecimpurl;
	}

	public void setPpnecimpurl(PpNecimpurl ppnecimpurl) {
		this.ppnecimpurl = ppnecimpurl;
	}

	public Byte getStImp() {
		return stImp;
	}

	public void setStImp(Byte stImp) {
		this.stImp = stImp;
	}

	public String getDsErro() {
		return dsErro;
	}

	public void setDsErro(String dsErro) {
		this.dsErro = dsErro;
	}

	public List<PpNecDTO> getPpNecDTO() {
		return ppNecDTO;
	}

	public void setPpNecDTO(List<PpNecDTO> ppNecDTO) {
		this.ppNecDTO = ppNecDTO;
	}

	public void setDthrInicioGeral(Date dthrInicioGeral) {
		this.dthrInicioGeral = dthrInicioGeral;
	}

	public Date getDthrInicioGeral() {
		return dthrInicioGeral;
	}

	public void setMesReferencia(Integer mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Integer getMesReferencia() {
		return mesReferencia;
	}

	public void setAnoReferencia(Integer anoReferencia) {
		this.anoReferencia = anoReferencia;
	}

	public Integer getAnoReferencia() {
		return anoReferencia;
	}

	public void setPpnecimp(PpNecimp ppnecimp) {
		this.ppnecimp = ppnecimp;
	}

	public PpNecimp getPpnecimp() {
		return ppnecimp;
	}

	public void setOmusr(OmUsr omusr) {
		this.omusr = omusr;
	}

	public OmUsr getOmusr() {
		return omusr;
	}

	public void setAba(String aba) {
		this.aba = aba;
	}

	public String getAba() {
		return aba;
	}

	public PpNecimplog getPpnecimplog() {
		return ppnecimplog;
	}

	public void setPpnecimplog(PpNecimplog ppnecimplog) {
		this.ppnecimplog = ppnecimplog;
	}

}
