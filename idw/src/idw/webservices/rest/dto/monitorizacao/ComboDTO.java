package idw.webservices.rest.dto.monitorizacao;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="combo")
public class ComboDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String dsView;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDsView() {
		return dsView;
	}
	public void setDsView(String dsView) {
		this.dsView = dsView;
	}
	
}
