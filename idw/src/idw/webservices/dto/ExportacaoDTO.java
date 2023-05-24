package idw.webservices.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ExportacaoDTO implements Serializable {
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private int SEM_CONFIGURACAO = 2;
	private int ERRO_IO = 3;
	private int ERRO_SEM_INFORMACAO = 4;

	
	public int getERRO_SEM_INFORMACAO() {
		return ERRO_SEM_INFORMACAO;
	}

	public void setERRO_SEM_INFORMACAO(int eRROSEMINFORMACAO) {
		ERRO_SEM_INFORMACAO = eRROSEMINFORMACAO;
	}

	public int getERRO_IO() {
		return ERRO_IO;
	}

	public void setERRO_IO(int eRROIO) {
		ERRO_IO = eRROIO;
	}

	public int getSEM_CONFIGURACAO() {
		return SEM_CONFIGURACAO;
	}

	public void setSEM_CONFIGURACAO(int sEMCONFIGURACAO) {
		SEM_CONFIGURACAO = sEMCONFIGURACAO;
	}

	private int resultadoEvento;
	
	private List<ExpArquivoExportadoDTO> arquivos;

	public List<ExpArquivoExportadoDTO> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<ExpArquivoExportadoDTO> arquivos) {
		this.arquivos = arquivos;
	}

	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int eVENTOBEMSUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTOBEMSUCEDIDO;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setERRO_DESCONHECIDO(int eRRODESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRODESCONHECIDO;
	}

	public int getResultadoEvento() {
		return resultadoEvento;
	}

	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	
	
}
