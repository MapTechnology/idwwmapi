package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaAreaRespDTO {
	private List<AreaResponsavelDTO> items;
	private MetaDTO meta;
	public List<AreaResponsavelDTO> getItems() {
		return items;
	}
	public void setItems(List<AreaResponsavelDTO> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
	
	
}
