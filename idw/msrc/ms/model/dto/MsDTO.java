package ms.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.MsMs;
import idw.model.pojos.OmCfg;

@SuppressWarnings("serial")
public class MsDTO implements Serializable{
	private BigDecimal idMs = BigDecimal.ZERO;
	
	private String cd_ms;
	private String url_Conexao;
	private String ds_ms;
	private Integer revisao;
	private Date dthr_stativo;
	private Date dthr_revisao;
	private Date dthr_heart_beat;
	private Integer st_ativo;
	private String loginUsuario;
	private List<IhmDTO> ihmsRegistrados = new ArrayList<IhmDTO>();
	private List<IcUpDTO> icsColetados = new ArrayList<IcUpDTO>();
	private Integer tpCalculoAndon; // 0 - Calculo hora
								// 1 - Calculo turno
	private OmCfg omcfg; // Ser� usada pelos drivers que necessitam acessar as configuracoes do sistema
	
	public MsDTO() {
		
	}
	public MsDTO(MsMs msms) {
		this.setIdMs(msms.getIdMs());
		this.setCd_ms(msms.getCdMs());
		this.setDs_ms(msms.getDsMs());
		this.setUrlConexao(msms.getUrlConexao());
		this.setTpCalculoAndon(msms.getTpCalculoandon());
		this.setRevisao(msms.getRevisao().intValue());
		this.setDthr_revisao(msms.getDthrRevisao());
		this.setDthr_stativo(msms.getDthrStativo());
		this.setDthr_heart_beat(msms.getDthrHeartbeat());
		this.setSt_ativo(msms.getStAtivo().intValue());
		this.setLoginUsuario(msms.getMsUsr().getLogin());
	}
	
	public String getUrlConexao() {
		return url_Conexao;
	}

	public void setUrlConexao(String url_Conexao) {
		this.url_Conexao = url_Conexao;
	}

	public Integer getTpCalculoAndon() {
		return tpCalculoAndon;
	}

	public void setTpCalculoAndon(Integer tpCalculoAndon) {
		this.tpCalculoAndon = tpCalculoAndon;
	}

	public List<IhmDTO> getIhmsRegistrados() {
		return ihmsRegistrados;
	}

	public void setIhmsRegistrados(List<IhmDTO> ihmsRegistrados) {
		this.ihmsRegistrados = ihmsRegistrados;
	}

	public BigDecimal getIdMs() {
		return idMs;
	}

	public void setIdMs(BigDecimal idMs) {
		this.idMs = idMs;
	}

	public List<IcUpDTO> getIcsColetados() {
		return icsColetados;
	}

	public void setIcsColetados(List<IcUpDTO> icsColetados) {
		this.icsColetados = icsColetados;
	}

	public void setCd_ms(String cd_ms) {
		this.cd_ms = cd_ms;
	}

	public String getCd_ms() {
		return cd_ms;
	}

	public void setDs_ms(String ds_ms) {
		this.ds_ms = ds_ms;
	}

	public String getDs_ms() {
		return ds_ms;
	}

	public void setRevisao(Integer revisao) {
		this.revisao = revisao;
	}

	public Integer getRevisao() {
		return revisao;
	}

	public void setDthr_stativo(Date dthr_stativo) {
		this.dthr_stativo = dthr_stativo;
	}

	public Date getDthr_stativo() {
		return dthr_stativo;
	}

	public void setDthr_revisao(Date dthr_revisao) {
		this.dthr_revisao = dthr_revisao;
	}

	public Date getDthr_revisao() {
		return dthr_revisao;
	}

	public void setDthr_heart_beat(Date dthr_heart_beat) {
		this.dthr_heart_beat = dthr_heart_beat;
	}

	public Date getDthr_heart_beat() {
		return dthr_heart_beat;
	}

	public void setSt_ativo(Integer st_ativo) {
		this.st_ativo = st_ativo;
	}

	public Integer getSt_ativo() {
		return st_ativo;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}
	public OmCfg getOmcfg() {
		return omcfg;
	}
	public void setOmcfg(OmCfg omcfg) {
		this.omcfg = omcfg;
	}
}
