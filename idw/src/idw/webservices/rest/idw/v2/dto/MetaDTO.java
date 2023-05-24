package idw.webservices.rest.idw.v2.dto;

public class MetaDTO {
	private int totalItems;
	private int itemCount;
	private int itemsPerPage;
	private int totalPages;
	private int currentPage;
	
	public MetaDTO(FiltroPesquisaDTO filtro) {
		setCurrentPage(filtro.getPagina());
		setItemsPerPage(filtro.getRegistrosPorPagina());
	}
	
	
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public int getItemsPerPage() {
		return itemsPerPage;
	}
	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
