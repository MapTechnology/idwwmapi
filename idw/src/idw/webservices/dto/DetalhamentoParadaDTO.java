package idw.webservices.dto;

import java.util.List;

import javax.lang.model.type.NoType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmUsr;
@JsonTypeInfo(use=JsonTypeInfo.Id.NONE)
@JsonDeserialize(as=NoType.class)
@XmlRootElement
@XmlSeeAlso( { DwTParada.class })
public class DetalhamentoParadaDTO {
	
	private String parada;
	private String duracaoParadas;
	private DwConsolpalog dwConsolpalog;
	private List<DetalheParadaDTO> listaparadas;
	private OmUsr usuarioLogado;
	
	public String getParada() {
		return parada;
	}

	public void setParada(String parada) {
		this.parada = parada;
	}
	
	public String getDuracaoParadas() {
		return duracaoParadas;
	}

	public void setDuracaoParadas(String duracaoParadas) {
		this.duracaoParadas = duracaoParadas;
	}
	
	public DwConsolpalog getDwConsolpalog() {
		return dwConsolpalog;
	}

	public void setDwConsolpalog(DwConsolpalog dwConsolpalog) {
		this.dwConsolpalog = dwConsolpalog;
	}

	public List<DetalheParadaDTO> getListaparadas() {
		return listaparadas;
	}

	public void setListaparadas(List<DetalheParadaDTO> listaparadas) {
		this.listaparadas = listaparadas;
	}

	public OmUsr getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(OmUsr usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}
