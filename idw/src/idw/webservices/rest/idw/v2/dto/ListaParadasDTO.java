package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaParadasDTO {
	private List<ParadaCadDTO> items;
	private MetaDTO meta;
	public List<ParadaCadDTO> getItems() {
		return items;
	}
	public void setItems(List<ParadaCadDTO> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
	
	
}
