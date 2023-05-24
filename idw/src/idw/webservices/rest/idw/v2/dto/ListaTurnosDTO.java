package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaTurnosDTO {
	private List<TurnoDTO2> items;
	private MetaDTO meta;
	
	public List<TurnoDTO2> getItems() {
		return items;
	}
	public void setItems(List<TurnoDTO2> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}

	
}
