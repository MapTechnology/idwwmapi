package idw.webservices.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;

public class AlertaDTO {
	
	private OmPt maquina;
	private PpCp ordemproducao;
	private DwTAlerta dwTAlerta;
	private Date dthrIalerta;
	private Byte msDthrialerta;
	private Date dthrFalerta;
	private Byte msDthrfalerta;
	private DwConsolallog dwConsolallog;
	private String Observacao;
	private String usuario;
	private String dthrFinal;
	
	private ResultadoDTO resultado = new ResultadoDTO();


	public ResultadoDTO getResultado() {
		return resultado;
	}
	public void setResultado(ResultadoDTO resultado) {
		this.resultado = resultado;
	}
	public DwTAlerta getDwTAlerta() {
		return dwTAlerta;
	}
	public void setDwTAlerta(DwTAlerta dwTAlerta) {
		this.dwTAlerta = dwTAlerta;
	}
	
	public Date getDthrIalerta() {
		return dthrIalerta;
	}
	public void setDthrIalerta(Date dthrIalerta) {
		this.dthrIalerta = dthrIalerta;
	}
	public Byte getMsDthrialerta() {
		return msDthrialerta;
	}
	public void setMsDthrialerta(Byte msDthrialerta) {
		this.msDthrialerta = msDthrialerta;
	}
	public Date getDthrFalerta() {
		return dthrFalerta;
	}
	public void setDthrFalerta(Date dthrFalerta) {
		this.dthrFalerta = dthrFalerta;
	}
	public Byte getMsDthrfalerta() {
		return msDthrfalerta;
	}
	public void setMsDthrfalerta(Byte msDthrfalerta) {
		this.msDthrfalerta = msDthrfalerta;
	}
	public OmPt getMaquina() {
		return maquina;
	}
	public void setMaquina(OmPt maquina) {
		this.maquina = maquina;
	}
	public PpCp getOrdemproducao() {
		return ordemproducao;
	}
	public void setOrdemproducao(PpCp ordemproducao) {
		this.ordemproducao = ordemproducao;
	}
	public DwConsolallog getDwConsolallog() {
		return dwConsolallog;
	}
	public void setDwConsolallog(DwConsolallog dwConsolallog) {
		this.dwConsolallog = dwConsolallog;
	}
	public String getObservacao() {
		return Observacao;
	}
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getDthrFinal() {
		return dthrFinal;
	}
	public void setDthrFinal(String dthrFinal) {
		this.dthrFinal = dthrFinal;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlertaDTO other = (AlertaDTO) obj;
		
		if (maquina == null) {
			if (other.maquina != null)
				return false;
		} else if (!maquina.getCdPt().equals(other.maquina.getCdPt()))
			return false;
		
		if (dwTAlerta == null) {
			if (other.dwTAlerta != null)
				return false;
		} else if (!dwTAlerta.getCdTalerta().equals(other.dwTAlerta.getCdTalerta()))
			return false;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		if (dthrIalerta == null) {
			if (other.dthrIalerta != null)
				return false;
		} else if (!sdf.format(dthrIalerta).equals(sdf.format(other.dthrIalerta)))
			return false;
		
//		if (dthrFalerta == null) {
//			if (other.dthrFalerta != null)
//				return false;
//		} else if (!sdf.format(dthrFalerta).equals(sdf.format(other.dthrFalerta)))
//			return false;
		
		if (Observacao == null) {
			if (other.Observacao != null)
				return false;
		} else if (!Observacao.equals(other.Observacao))
			return false;
		
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		
		String retorno;
		
		retorno = "AlertaDTO ["; 
		
		retorno += "maquina=" + this.maquina + ", " +
				   "ordemproducao=" + this.ordemproducao + ", ";
		
		retorno += "dwTAlerta=";
		
		if (this.dwTAlerta != null) {
			retorno += this.dwTAlerta.getCd() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "dthrIalerta=" + this.dthrIalerta + ", " +
				   "msDthrialerta=" + this.msDthrialerta + ", " +
				   "dthrFalerta=" + this.dthrFalerta + ", " +
				   "msDthrfalerta=" + this.msDthrfalerta + ", ";

		retorno += "dwConsolallog=";
		
		if (this.dwConsolallog != null) {
			retorno += this.dwConsolallog.getIdConsolallog() + ", ";
		} else {
			retorno += "null, ";
		}
		
		retorno += "Observacao=" + this.Observacao + ", " +
				   "usuario=" + this.usuario + ", " +
				   "dthrFinal=" + this.dthrFinal + ", " +
				   "resultado=" + this.resultado + "] ";
		
		return retorno;
		/*
		return "AlertaDTO [maquina=" + maquina + ", ordemproducao=" + ordemproducao + ", dwTAlerta=" + dwTAlerta + ", dthrIalerta="
				+ dthrIalerta + ", msDthrialerta=" + msDthrialerta + ", dthrFalerta=" + dthrFalerta + ", msDthrfalerta=" + msDthrfalerta
				+ ", dwConsolallog=" + dwConsolallog + ", Observacao=" + Observacao + ", usuario=" + usuario + ", dthrFinal=" + dthrFinal
				+ ", resultado=" + resultado + "]";
		*/
	}
	
}
