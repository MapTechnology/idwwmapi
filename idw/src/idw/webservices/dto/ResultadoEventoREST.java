package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultadoEventoREST implements Serializable{
		
	private static final long serialVersionUID = -7676313148656207133L;
	
	private int EVENTO_BEM_SUCEDIDO = 1;
	private int EVENTO_MAL_SUCEDIDO = 0;
	private int EVENTO_DESCONHECIDO = 2;
	
	private int resultadoEvento;
	private String stringData;
	private int intData;
	private Date dthr;
	
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}	
	public int getEVENTO_MAL_SUCEDIDO() {
		return EVENTO_MAL_SUCEDIDO;
	}
	public void setEVENTO_MAL_SUCEDIDO(int eVENTO_MAL_SUCEDIDO) {
		EVENTO_MAL_SUCEDIDO = eVENTO_MAL_SUCEDIDO;
	}	
	public int getEVENTO_DESCONHECIDO() {
		return EVENTO_DESCONHECIDO;
	}
	public void setEVENTO_DESCONHECIDO(int eVENTO_DESCONHECIDO) {
		EVENTO_DESCONHECIDO = eVENTO_DESCONHECIDO;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}	
	public String getStringData() {
		return stringData;
	}
	public void setStringData(String stringData) {
		this.stringData = stringData;
	}
	public int getIntData() {
		return intData;
	}
	public void setIntData(int intData) {
		this.intData = intData;
	}
	public Date getDthr() {
		return dthr;
	}
	public void setDthr(Date dthr) {
		this.dthr = dthr;
	}	
}
