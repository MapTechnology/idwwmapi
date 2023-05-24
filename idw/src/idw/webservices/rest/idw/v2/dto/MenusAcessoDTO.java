package idw.webservices.rest.idw.v2.dto;

import java.util.List;

public class MenusAcessoDTO {
	private String cdMenu;
	private List<MenusAcessoDTO> itensMenu;
	
	public String getCdMenu() {
		return cdMenu;
	}
	public void setCdMenu(String cdMenu) {
		this.cdMenu = cdMenu;
	}
	public List<MenusAcessoDTO> getItensMenu() {
		return itensMenu;
	}
	public void setItensMenu(List<MenusAcessoDTO> itensMenu) {
		this.itensMenu = itensMenu;
	}
	
	
}
