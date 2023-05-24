package injetws.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import injetws.model.pojos.PrUpAndonIndicadores;
import injetws.webservices.dto.IwsAndonIndicadorDTO;

@SuppressWarnings("serial")
public class IwsAndonIndicadoresDTO implements Serializable {
	List<IwsAndonIndicadorDTO> listaIwsAndonIndicador = new ArrayList<IwsAndonIndicadorDTO>();

	public List<IwsAndonIndicadorDTO> getListaIwsAndonIndicador() {
		return listaIwsAndonIndicador;
	}
	
	public IwsAndonIndicadorDTO getIwsAndonIndicador(BigDecimal indicador) {
		IwsAndonIndicadorDTO retorno = null;
		for (IwsAndonIndicadorDTO obj:this.listaIwsAndonIndicador){
			if(indicador.equals(obj.getIdindicador())){
				retorno=obj;
				break;
			}
		}
		return retorno;
	}
		
	public void setListaIwsAndonIndicador(List<PrUpAndonIndicadores> listaIndicadores) {
		// considerando que a lista vem progressiva vou utilizar este método
		this.listaIwsAndonIndicador = new ArrayList<IwsAndonIndicadorDTO>();
		IwsAndonIndicadorDTO dto= null;
		int i=0;
		for(PrUpAndonIndicadores obj :listaIndicadores){
			if(dto==null || !dto.getIdindicador().equals(obj.getId().getIdindicador())){
				dto=new IwsAndonIndicadorDTO();
				i=0;
			}
			i++;
			dto.setIwsAndonIndicadoresDTO(obj);
			if(i>=2)
				this.listaIwsAndonIndicador.add(dto);			
		}		
	}
}
