package idw.webservices.dto;

import java.io.Serializable;
import java.util.HashSet;

import idw.model.pojos.DwRap;
import idw.model.pojos.DwRapGrupo;
import idw.model.pojos.PpIndispRappt;

@SuppressWarnings("serial")
public class DwRapDTO extends DwRap implements Serializable{

	private DwRap rap;
	
	private ResultadoDTO resultadoDTO;
	
	public DwRapDTO(){
		
	}
	
	public DwRapDTO(DwRap dwRap){
		this.setCdRap(dwRap.getCdRap());
		this.setDsRap(dwRap.getDsRap());
		this.setDtRevisao(dwRap.getDtRevisao());
		this.setDtStativo(dwRap.getDtStativo());
		this.setDwFolharaps(dwRap.getDwFolharaps());
		this.setIdRap(dwRap.getIdRap());
		this.setQtAlocada(dwRap.getQtAlocada());
		this.setQtTotal(dwRap.getQtTotal());
		this.setRevisao(dwRap.getRevisao());
		this.setStAtivo(dwRap.getStAtivo());
		this.setDepara(dwRap.getDepara());
		this.setSegTempoliberacao(dwRap.getSegTempoliberacao());
		this.setOmUsrByIdUsrrevisao(dwRap.getOmUsrByIdUsrrevisao());
		this.setOmUsrByIdUsrstativo(dwRap.getOmUsrByIdUsrstativo());
		this.setQtCiclosEntreManutencao(dwRap.getQtCiclosEntreManutencao());
		
		if (dwRap.getPpCliente() != null)
			this.setPpCliente(dwRap.getPpCliente().clone());
		
		if (dwRap.getDwRap() != null){
			this.setDwRap(dwRap.getDwRap().clone());
		}
		
		if (dwRap.getDwRaps() != null){
			this.setDwRaps(new HashSet<DwRap>());
			for(DwRap dwR : dwRap.getDwRaps()){
				this.getDwRaps().add(dwR.clone());
			}
		}
		
		if (dwRap.getPpIndispRappts() != null){
			this.setPpIndispRappts(new HashSet<PpIndispRappt>());
			for(PpIndispRappt ppI : dwRap.getPpIndispRappts()){
				this.getPpIndispRappts().add(ppI.clone());
			}
		}		
				
		if(dwRap.getDwRapGrupos() != null) {
			this.setDwRapGrupos(new HashSet<DwRapGrupo>());
			for(DwRapGrupo dwRapGrupo : dwRap.getDwRapGrupos()) {
				this.getDwRapGrupos().add(dwRapGrupo.clone());
			}
		}
	}
	
	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}
	
	
}