package idw.model.rn.injet;

import java.io.Serializable;
import java.util.Date;

import idw.model.pojos.injet.Ijtbtur;
import idw.model.rn.DataHoraRN;

@SuppressWarnings("serial")
public class TurnoInjetDTO implements Serializable{

	private Date dtReferencia;
	private Ijtbtur ijtbtur;
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = DataHoraRN.normalize(dtReferencia, DataHoraRN._DAY);
	}
	public Ijtbtur getIjtbtur() {
		return ijtbtur;
	}
	public void setIjtbtur(Ijtbtur ijtbtur) {
		this.ijtbtur = ijtbtur;
	}
	
	
}
