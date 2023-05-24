package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaGrupoFerramentasDTO {
	private List<GrupoFerramentasDTO2> items;
	private MetaDTO meta;
	
	public List<GrupoFerramentasDTO2> getItems() {
		return items;
	}
	public void setItems(List<GrupoFerramentasDTO2> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
			
  
}
