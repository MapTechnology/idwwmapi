package ms.model.dto;

import java.util.ArrayList;
import java.util.List;

public class WebXMLDTO {
	private List<String> classesInicializaveis;
	private List<String> classesNaoInicializaveis;
	private String versaoMobile;
	
	public WebXMLDTO(){
		this.classesInicializaveis = new ArrayList<String>();
		this.classesNaoInicializaveis = new ArrayList<String>();
	}
	
	public void setClassesInicializaveis(List<String> classes) {
		this.classesInicializaveis = classes;
	}
	public List<String> getClassesInicializaveis() {
		return classesInicializaveis;
	}
	public void setVersaoMobile(String versaoMobile) {
		this.versaoMobile = versaoMobile;
	}
	public String getVersaoMobile() {
		return versaoMobile;
	}
	public void setClassesNaoInicializaveis(List<String> classesNaoInicializaveis) {
		this.classesNaoInicializaveis = classesNaoInicializaveis;
	}
	public List<String> getClassesNaoInicializaveis() {
		return classesNaoInicializaveis;
	}
}
