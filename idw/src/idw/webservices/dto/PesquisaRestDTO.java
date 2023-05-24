package idw.webservices.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.DwTJust;
import idw.model.pojos.DwTParada;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.OmProduto;

@SuppressWarnings("serial")
@XmlRootElement
@XmlSeeAlso({ DwTParada.class, DwTRefugo.class, DwTDefeito.class, DwTCausa.class, DwTAcao.class, DwTJust.class, OmProduto.class })
public class PesquisaRestDTO extends PesquisaDTO {

	public PesquisaRestDTO() {
	}

	public PesquisaRestDTO(PesquisaDTO pesquisa) {
		this.setCodigo(pesquisa.getCodigo());
		this.setDescricao(pesquisa.getDescricao());
		this.setRegistro(pesquisa.getRegistro());
		
		this.setRequercancelamento(pesquisa.getRequercancelamento());
		this.setRequerjustificativ(pesquisa.getRequerjustificativ());
		this.setRequercausa(pesquisa.getRequercausa());
		this.setRequeracao(pesquisa.getRequeracao());
		this.setPededrtresponsa(pesquisa.getPededrtresponsa());
		this.setPededrttecnico1(pesquisa.getPededrttecnico1());
		this.setPededrttecnico2(pesquisa.getPededrttecnico2());
		this.setTeprogramado(pesquisa.getTeprogramado());
	}

}
