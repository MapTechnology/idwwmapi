package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaCargosDTO {
	private List<CargoDTO> items;
	private MetaDTO meta;
	
	public List<CargoDTO> getItems() {
		return items;
	}
	public void setItems(List<CargoDTO> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}

}
