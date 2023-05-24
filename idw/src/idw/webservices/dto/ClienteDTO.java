package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.PpCliente;

@SuppressWarnings("serial")
public class ClienteDTO extends PpCliente implements Serializable {
	
	private ResultadoDTO resultadoDTO;
	
	
	public ClienteDTO() {
	}
	public ClienteDTO(PpCliente ppcliente) {
		this.setCdCliente(ppcliente.getCdCliente());
		this.setCidade(ppcliente.getCidade());
		this.setCnpjCpf(ppcliente.getCnpjCpf());
		this.setContato(ppcliente.getContato());
		this.setDtRevisao(ppcliente.getDtRevisao());
		this.setDtStativo(ppcliente.getDtStativo());
		this.setEndereco(ppcliente.getEndereco());
		this.setEstado(ppcliente.getEstado());
		this.setHrLeadtime(ppcliente.getHrLeadtime());
		this.setNmCliente(ppcliente.getNmCliente());
		this.setOmContatos(ppcliente.getOmContatos());
		this.setOmProdutos(ppcliente.getOmProdutos());
		this.setOmUsrByIdUsrrevisao(ppcliente.getOmUsrByIdUsrrevisao());
		this.setOmUsrByIdUsrstativo(ppcliente.getOmUsrByIdUsrstativo());
		this.setPais(ppcliente.getPais());
		this.setPpCps(ppcliente.getPpCps());
		this.setPpNecs(ppcliente.getPpNecs());
		this.setRevisao(ppcliente.getRevisao());
		this.setStAtivo(ppcliente.getStAtivo());
		this.setTelefoneum(ppcliente.getTelefoneum());
		this.setTelefonedois(ppcliente.getTelefonedois());
		this.setTelefonetres(ppcliente.getTelefonetres());
		this.setTpCliente(ppcliente.getTpCliente());
		this.setUrlSite(ppcliente.getUrlSite());
	}

	public void setResultadoDTO(ResultadoDTO resultadoDTO) {
		this.resultadoDTO = resultadoDTO;
	}

	public ResultadoDTO getResultadoDTO() {
		return resultadoDTO;
	}

}
