package idw.model.rn.impprog;

import java.util.ArrayList;
import java.util.List;

public class MaquinaSMDPanasonic {

	private String nomeMaquina;
	private String linha;
	private List<String> prefixoFeeders = new ArrayList<String>();
	private double cicloPadrao;
	
	/*
	 * Alessandre> em 10-09-13 removi do nome da maquina a identificacao da linha pois era feita baseando-se no
	 * nome do arquivo, mas nao eh uma boa pratica, entao usaremos a maq para obter uma lista
	 */
	public String getNomeMaquina() {
		return nomeMaquina;
	}
	public void setNomeMaquina(String nomeMaquina) {
		this.nomeMaquina = nomeMaquina;
	}
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	public void addPrefixoFeeders(String prefixoFeeders) {
		this.prefixoFeeders.add(prefixoFeeders);
	}
	
	@Override
	public int hashCode(){
		return 42;
	}
	
	@Override
	public boolean equals(Object obj2){
		if (this == obj2)
			return true;
		
		if (! (obj2 instanceof MaquinaSMDPanasonic) )
			return false;
		
		boolean retorno = false;
		MaquinaSMDPanasonic obj1 = (MaquinaSMDPanasonic) obj2;
		if (
				this.linha.equals(obj1.getLinha()) && 
				this.getNomeMaquina().equals(obj1.getNomeMaquina())
			)
			
			retorno = true;
		
		return retorno;
	}
	public boolean isFeederPertenceAMaquina(String pu, String side){
		String prefixoPu = null;
		if (pu.length() - 4 <= 0)
			prefixoPu = "";
		else
			prefixoPu = pu.substring(0, pu.length() - 4);
		if (prefixoFeeders.contains(prefixoPu)){
			return true;
		}else{
			return false;
		}
	}
	public double getCicloPadrao() {
		return cicloPadrao;
	}
	public void setCicloPadrao(double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}
	
}
