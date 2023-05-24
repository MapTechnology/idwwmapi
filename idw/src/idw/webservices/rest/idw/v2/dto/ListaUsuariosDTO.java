package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaUsuariosDTO {
	private List<UsrDTO> items;
	private MetaDTO meta;
	
	public List<UsrDTO> getItems() {
		return items;
	}
	public void setItems(List<UsrDTO> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	} 
}
