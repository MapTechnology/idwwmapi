package injetws.webservices.dto;

import java.io.Serializable;
import java.util.Date;

public class IwsHorarioDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date data;
	private Integer hora;
	private IwsListaUpDTO listaUpDTO;

    private short byteAtualizacao;
		// bit 0 = Nenhuma atualizacao necessaria
		// bit 1 = Atualizar lista de AlertaDTO
		// bit 2 = Atualizar lista de DesvioDTO
		// bit 3 = Atualizar lista de ParadaDTO
		// bit 4 = Atualizar lista de ProducaoControleDTO
		// bit 5 = Atualizar lista de ProdutosDTO
		// bit 6 = Atualizar lista de TecnicosDTO
		// bit 7 = Atualizar lista de TurnoDTO
	
		// bit 0 = Atualizar lista de UnidadeDTO
		// bit 1 = Atualizar lista de UpDTO

    private byte byteRele;
            // bit 0 - rele 1
            // bit 1 - rele 2
            // bit 2 - rele 3
            // bit 3 - rele 4
            // bit 4 - rele 5
            // bit 5 - rele 6
    private byte byteTipoRele;
            // bit 0 - rele 1 (0=temporizado, 1=determinado pelo WS)
            // bit 1 - rele 2 (0=temporizado, 1=determinado pelo WS)
            // bit 2 - rele 3 (0=temporizado, 1=determinado pelo WS)
            // bit 3 - rele 4 (0=temporizado, 1=determinado pelo WS)
            // bit 4 - rele 5 (0=temporizado, 1=determinado pelo WS)
            // bit 5 - rele 6 (0=temporizado, 1=determinado pelo WS)
    private Integer tempoRele;

    public IwsListaUpDTO getListaUpDTO() {
		return listaUpDTO;
	}

	public void setListaUpDTO(IwsListaUpDTO listaUpDTO) {
		this.listaUpDTO = listaUpDTO;
	}
    
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public short getByteAtualizacao() {
		return byteAtualizacao;
	}

	public void setByteAtualizacao(short byteAtualizacao) {
		this.byteAtualizacao = byteAtualizacao;
	}

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

	public Integer getTempoRele() {
		return tempoRele;
	}

	public void setTempoRele(Integer tempoRele) {
		this.tempoRele = tempoRele;
	}
}
