package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class ListaGruposAcessoUsrDTO {
	private List<GrupoUsrDTO> items;
	private MetaDTO meta;
	
	public List<GrupoUsrDTO> getItems() {
		return items;
	}
	public void setItems(List<GrupoUsrDTO> items) {
		this.items = items;
	}
	public MetaDTO getMeta() {
		return meta;
	}
	public void setMeta(MetaDTO meta) {
		this.meta = meta;
	}
}
