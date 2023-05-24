package injetws.webservices.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class IwsListaInspecoesAutoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5084685612907741592L;
	private List<IwsInspecaoAutoDTO> inspecoes=null;
	private boolean isInicializado=false;
	
	public boolean isInicializado() {
		return isInicializado;
	}

	public void setInicializado(boolean isInicializado) {
		this.isInicializado = isInicializado;
	}

	public List<IwsInspecaoAutoDTO> getInspecoes() {
		return inspecoes;
	}
	
	public void setInspecoes(List<IwsInspecaoAutoDTO> inspecoes) {
		this.inspecoes = inspecoes;
	}
	
	public void addInspecoes(List<IwsInspecaoAutoDTO> inspecs) {
		if(inspecoes==null){
			inspecoes = new ArrayList<IwsInspecaoAutoDTO>();
		}
		inspecoes.addAll(inspecs);
	}
	
	public void addInspecao(IwsInspecaoAutoDTO inspec) {
		if(inspecoes==null){
			inspecoes = new ArrayList<IwsInspecaoAutoDTO>();
		}
		inspecoes.add(inspec);
	}	

}
