package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaCalendariosDTO {

	private List<CalendarioDTO2> items;
	private MetaDTO meta;
	
	public List<CalendarioDTO2> getItems() {
		return items;
	}
	public void setItems(List<CalendarioDTO2> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}

}
