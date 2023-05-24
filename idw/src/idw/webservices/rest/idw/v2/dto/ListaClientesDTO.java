package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaClientesDTO {
	private List<ClienteDTO2> items;
	private MetaDTO meta;
	public List<ClienteDTO2> getItems() {
		return items;
	}
	public void setItems(List<ClienteDTO2> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
	
}
