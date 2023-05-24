package idw.model.rn.geraplano.dtos;

import idw.model.pojos.DwRota;
import idw.model.pojos.PpPlano;

public class PassosOperacoesDTO extends PassosDTO {
	public PassosOperacoesDTO(DwRota rota){
		super(new PpPlano());
		this.dwrota = rota;
	}
}
