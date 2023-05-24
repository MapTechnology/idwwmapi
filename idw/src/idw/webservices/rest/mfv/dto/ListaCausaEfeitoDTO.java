package idw.webservices.rest.mfv.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import idw.webservices.rest.mfv.dto.CausaEfeitoDTO;

@XmlRootElement(name="listaCausaEfeito")
public class ListaCausaEfeitoDTO implements Serializable {

	@XmlTransient
	private static final long serialVersionUID = 1L;

	private List<CausaEfeitoDTO> listacausaefeito;

	public List<CausaEfeitoDTO> getListaCausaEfeito() {
		return listacausaefeito;
	}
	public void setListaCausaEfeito(List<CausaEfeitoDTO> listacausaefeito) {
		this.listacausaefeito = listacausaefeito;
	}
}
