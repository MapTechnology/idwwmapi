package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import idw.model.pojos.OmGt;
import idw.model.pojos.OmObj;
import idw.model.rn.indicador.IndicadorValorMinMetaMaxDTO;

@SuppressWarnings("serial")
public class MonitorizacaoHierarquicaDTO implements Serializable{
	private OmGt omGt;	
	private OmObj omObj;
	private String cdCp;
	private Date dtHrUltimaImportacao;
	private List<IndicadorValorMinMetaMaxDTO> indicadorValorMinMetaMaxDTOs;
	private List<MonitorizacaoHierarquicaDTO> monitorizacaoHierarquicaDTOs;

	public OmGt getOmGt() {
		return omGt;
	}
	public void setOmGt(OmGt omGt) {
		this.omGt = omGt;
	}
	public OmObj getOmObj() {
		return omObj;
	}
	public void setOmObj(OmObj omObj) {
		this.omObj = omObj;
	}
	
	public Date getDtHrUltimaImportacao() {
		return dtHrUltimaImportacao;
	}
	public void setDtHrUltimaImportacao(Date dtHrUltimaImportacao) {
		this.dtHrUltimaImportacao = dtHrUltimaImportacao;
	}	
	public List<IndicadorValorMinMetaMaxDTO> getIndicadorValorMinMetaMaxDTOs() {
		return indicadorValorMinMetaMaxDTOs;
	}
	public void setIndicadorValorMinMetaMaxDTOs(
			List<IndicadorValorMinMetaMaxDTO> indicadorValorMinMetaMaxDTOs) {
		this.indicadorValorMinMetaMaxDTOs = indicadorValorMinMetaMaxDTOs;
	}
	public List<MonitorizacaoHierarquicaDTO> getMonitorizacaoHierarquicaDTOs() {
		return monitorizacaoHierarquicaDTOs;
	}
	public void setMonitorizacaoHierarquicaDTOs(
			List<MonitorizacaoHierarquicaDTO> monitorizacaoHierarquicaDTOs) {
		this.monitorizacaoHierarquicaDTOs = monitorizacaoHierarquicaDTOs;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		
		retorno.append(" GT=");
		if (getOmGt() != null)
			retorno.append(getOmGt().getCdGt());
		retorno.append(" PT=");
		if (getOmObj() != null && getOmObj().getOmPt() != null)
			retorno.append(getOmObj().getOmPt().getCdPt());
		retorno.append(" GTFilho=");
		if (getOmObj() != null && getOmObj().getOmGtByIdGtfilho() != null)
			retorno.append(getOmObj().getOmGtByIdGtfilho().getCdGt());
		retorno.append(" CP=");
		retorno.append(getCdCp());
		
		return retorno.toString();
	}
	
	public void imprimirArvore() {
		System.out.println(toString());
		if (getMonitorizacaoHierarquicaDTOs() != null)
			for (MonitorizacaoHierarquicaDTO dto : getMonitorizacaoHierarquicaDTOs()) {
				dto.imprimirArvore();
			}
	}
}
