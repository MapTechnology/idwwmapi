package injetws.webservices.dto;

import java.io.Serializable;

public class IwsMensagemRetornoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private byte byteRele;
            // bit 0 - rele 1
            // bit 1 - rele 2
            // bit 2 - rele 3
            // bit 3 - rele 4
            // bit 4 - rele 5
            // bit 5 - rele 6

    private byte byteTipoRele;
            // bit 0 - rele 1 (0=temporizado, 1=desligamento determinado pelo WS)
            // bit 1 - rele 2 (0=temporizado, 1=desligamento determinado pelo WS)
            // bit 2 - rele 3 (0=temporizado, 1=desligamento determinado pelo WS)
            // bit 3 - rele 4 (0=temporizado, 1=desligamento determinado pelo WS)
            // bit 4 - rele 5 (0=temporizado, 1=desligamento determinado pelo WS)
            // bit 5 - rele 6 (0=temporizado, 1=desligamento determinado pelo WS)


    private byte byteAcendimento;
		// bit 0 - rele 1 (0=aceso continuamente, 1=aceso de forma intermitente)
		// bit 1 - rele 2 (0=aceso continuamente, 1=aceso de forma intermitente)
		// bit 2 - rele 3 (0=aceso continuamente, 1=aceso de forma intermitente)
		// bit 3 - rele 4 (0=aceso continuamente, 1=aceso de forma intermitente)
		// bit 4 - rele 5 (0=aceso continuamente, 1=aceso de forma intermitente)
		// bit 5 - rele 6 (0=aceso continuamente, 1=aceso de forma intermitente)

	private Integer tempoRele;
		// tempo que o relé fica aceso, caso tipo relé for temporizado; observar que vale para todos os reles marcados como temporizado.
	
	private String mensagem;

	public byte getByteRele() {
		return byteRele;
	}

	public void setByteRele(byte byteRele) {
		this.byteRele = byteRele;
	}

	public byte getByteTipoRele() {
		return byteTipoRele;
	}

	public void setByteTipoRele(byte byteTipoRele) {
		this.byteTipoRele = byteTipoRele;
	}

	public byte getByteAcendimento() {
		return byteAcendimento;
	}

	public void setByteAcendimento(byte byteAcendimento) {
		this.byteAcendimento = byteAcendimento;
	}

	public Integer getTempoRele() {
		return tempoRele;
	}

	public void setTempoRele(Integer tempoRele) {
		this.tempoRele = tempoRele;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
