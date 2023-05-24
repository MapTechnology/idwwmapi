package idw.webservices.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;

public class IndicadoresPtDTO {
	
	private OmPt omPt;
	private IndicadoresDTO indicadoresDTO;
	private boolean gargalosAgrupados; //default=false (não agrupados); // true: agrupará barras de gargalos
	// gargalosAgrupados; //default=false (não agrupados); // true: agrupará barras de gargalos cujos PTs são de natureza semelhante . Exemplo: "5g_01_LIN01", "5g_02_LIN01", etc.
	


	public static IndicadoresPtDTO newInstance(DwConsolid dwConsolid, OmCfg omcfg, DAOGenerico dao){
		IndicadoresPtDTO indicadoresPtDTO = new IndicadoresPtDTO();
		indicadoresPtDTO.setOmPt(dwConsolid.getOmPt());
		indicadoresPtDTO.setIndicadoresDTO(IndicadoresDTO.newInstance(dwConsolid, omcfg, dao));
		return indicadoresPtDTO;
	}
	public static IndicadoresPtDTO newInstance(DwConsolid dwConsolid, OmCfg omcfg, DAOGenerico dao, boolean isGargalosAgrupados){
		IndicadoresPtDTO indicadoresPtDTO = new IndicadoresPtDTO();
		indicadoresPtDTO.setOmPt(dwConsolid.getOmPt());
		indicadoresPtDTO.setIndicadoresDTO(IndicadoresDTO.newInstance(dwConsolid, omcfg, dao, true));
		return indicadoresPtDTO;
	}
	
	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("omPt", (omPt != null? omPt.getIdPt(): "null"))
			.append("indicadoresDTO", indicadoresDTO.toString())
			.toString();
	}
		
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	public IndicadoresDTO getIndicadoresDTO() {
		return indicadoresDTO;
	}
	public void setIndicadoresDTO(IndicadoresDTO indicadoresDTO) {
		this.indicadoresDTO = indicadoresDTO;
	}	
	
	public void prepararSerializacao(){
		OmPt aux = this.omPt;
		this.omPt = new OmPt();
		this.omPt.setId(aux.getId());
		this.omPt.setCdPt(aux.getCdPt());
		this.omPt.setDsPt(aux.getDsPt());
		aux = null;
	}

	public boolean isGargalosAgrupados() {
		return gargalosAgrupados;
	}

	public void setGargalosAgrupados(boolean gargalosAgrupados) {
		this.gargalosAgrupados = gargalosAgrupados;
	}
	
}