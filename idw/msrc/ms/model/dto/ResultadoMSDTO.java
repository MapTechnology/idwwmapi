package ms.model.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResultadoMSDTO implements Serializable{
	
	private int idMensagem;
	private String complemento;
	
	public final int ERRO_DESCONHECIDO = 0;
	public final int COM_SUCESSO = 1;
	public final int ERRO_CDIC_DESCONHECIDO = 2;
	public final int ERRO_EXCLUI_STATIVO_ZERO = 3;
	public final int ERRO_URL_DESCONHECIDA = 4;
	public final int ERRO_CDMS_DESCONHECIDO = 5;
	public final int ERRO_LISTA_VAZIA = 6;
	public final int ERRO_CDUP_DESCONHECIDO = 7;
	public final int ERRO_SALVA_STATIVO_ZERO = 8;
	public final int ERRO_USUARIO_DESCONHECIDO = 9;
	public final int ERRO_TPIC_INVALIDO = 10;
	public final int ERRO_IMPORTACAO_JA_OCORREU = 11;
	public final int ERRO_IHM_JA_VINCULADO = 12;
	public final int ERRO_URL_CONEXAO_JA_CADASTRADA = 13;
	public final int ERRO_IP_JA_CADASTRADA = 14;
	public final int ERRO_IC_JA_CADASTRADO = 15;
	public final int ERRO_UP_EXCLUIDA = 16;
	
	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}
	public int getIdMensagem() {
		return idMensagem;
	}
	public boolean isComSucesso(){
		return (idMensagem == COM_SUCESSO);
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getERRO_UP_EXCLUIDA() {
		return ERRO_UP_EXCLUIDA;
	}
}
