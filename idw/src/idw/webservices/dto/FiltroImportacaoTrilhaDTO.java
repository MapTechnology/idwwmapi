package idw.webservices.dto;

import idw.model.rn.integracao.semptoshiba.trilha.ArquivoTrilhaDTO;

public class FiltroImportacaoTrilhaDTO extends FiltroExportacaoTrilhaDTO{

	private ArquivoTrilhaDTO arquivo;
	private UsuarioDTO usuarioLogado;

	public ArquivoTrilhaDTO getArquivo() {
		return arquivo;
	}

	public void setArquivo(ArquivoTrilhaDTO arquivo) {
		this.arquivo = arquivo;
	}

	public UsuarioDTO getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioDTO usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	
}
