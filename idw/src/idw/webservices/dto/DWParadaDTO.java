package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwTParada;

/**
 * 
 * @author luan
 *Esta classe esta com o nome DWParadaDTO, pois estava dando conflito de nomes ao atualizar webservice
 */
@SuppressWarnings("serial")
public class DWParadaDTO implements Serializable {
	
   private DwTParada dwTParada ;
   private ResultadoDTO resultado = new ResultadoDTO();

   public DwTParada getDwTParada() {
	  return dwTParada;
   }

   public void setDwTParada(DwTParada dwTParada) {
	  this.dwTParada = dwTParada;
   }

public ResultadoDTO getResultado() {
	return resultado;
}

public void setResultado(ResultadoDTO resultado) {
	this.resultado = resultado;
}
   
   
}
