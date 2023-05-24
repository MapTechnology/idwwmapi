package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class TpptAnteriorDTO implements Serializable{

	private int tppt;
	private List<Integer> tpptImediatamenteAnterior = new ArrayList<Integer>();

	public int getTppt() {
		return tppt;
	}
	public void setTppt(int tppt) {
		this.tppt = tppt;
	}
	public List<Integer> getTpptImediatamenteAnterior() {
		return tpptImediatamenteAnterior;
	}
	public void setTpptImediatamenteAnterior(List<Integer> tpptImediatamenteAnterior) {
		this.tpptImediatamenteAnterior = tpptImediatamenteAnterior;
	}
}
