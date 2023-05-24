package injetws.webservices.dto;

import java.io.Serializable;

public class IwsFitesaDadosDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private int subcoletor=0;
	private int larguranomminal =0; //em mm
	private String op;
	
	public int getSubcoletor() {
		return subcoletor;
	}
	public void setSubcoletor(int subcoletor) {
		this.subcoletor = subcoletor;
	}
	public int getLarguranomminal() {
		return larguranomminal;
	}
	public void setLarguranomminal(int larguranomminal) {
		this.larguranomminal = larguranomminal;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
}
