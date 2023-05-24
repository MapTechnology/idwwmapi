package idw.webservices.dto;

import java.util.List;

import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwTestesub;


public class FolhaEtapaDTO {
	private DwFtEtapa etapa;
    private int ordem;
    private List<DwTestesub> testesSub;
	
    public DwFtEtapa getEtapa() {
		return etapa;
	}
	public void setEtapa(DwFtEtapa etapa) {
		this.etapa = etapa;
	}
	public int getOrdem() {
		return ordem;
	}
	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	public List<DwTestesub> getTestesSub() {
		return testesSub;
	}
	public void setTestesSub(List<DwTestesub> testesSub) {
		this.testesSub = testesSub;
	}
        
}
