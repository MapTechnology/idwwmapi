package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class GraficoDTO implements Serializable{

	List<SerieDTO> seriesDTO = new ArrayList<SerieDTO>();

	public void add(SerieDTO serie){
		this.seriesDTO.add(serie);
	}
	public List<SerieDTO> getSeriesDTO() {
		return seriesDTO;
	}

	public void setSeriesDTO(List<SerieDTO> seriesDTO) {
		this.seriesDTO = seriesDTO;
	}
}
