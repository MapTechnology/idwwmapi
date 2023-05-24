package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class PesquisaDTO implements Serializable{
    /**
	 * 
	 */
	private String codigo = "";
    private String descricao = "";
    private Object registro;
    
    // Adicao de mais detalhes no dwTParada
    private int requercancelamento = 1;
    private int  requerjustificativ = 1;
    private int  requercausa = 1;
    private int  requeracao = 1;
    private int  pededrtresponsa = 1;
    private int  pededrttecnico1 = 1;
    private int  pededrttecnico2 = 1;
    private int  teprogramado = 1; // campo equivalente ao isAtivo
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
	public Object getRegistro() {
		return registro;
	}

	public void setRegistro(Object registro) {
		this.registro = registro;
	}

	public int getRequercancelamento() {
		return requercancelamento;
	}

	public void setRequercancelamento(int requercancelamento) {
		this.requercancelamento = requercancelamento;
	}

	public int getRequerjustificativ() {
		return requerjustificativ;
	}

	public void setRequerjustificativ(int requerjustificativ) {
		this.requerjustificativ = requerjustificativ;
	}

	public int getRequercausa() {
		return requercausa;
	}

	public void setRequercausa(int requercausa) {
		this.requercausa = requercausa;
	}

	public int getRequeracao() {
		return requeracao;
	}

	public void setRequeracao(int requeracao) {
		this.requeracao = requeracao;
	}

	public int getPededrtresponsa() {
		return pededrtresponsa;
	}

	public void setPededrtresponsa(int pededrtresponsa) {
		this.pededrtresponsa = pededrtresponsa;
	}

	public int getPededrttecnico1() {
		return pededrttecnico1;
	}

	public void setPededrttecnico1(int pededrttecnico1) {
		this.pededrttecnico1 = pededrttecnico1;
	}

	public int getPededrttecnico2() {
		return pededrttecnico2;
	}

	public void setPededrttecnico2(int pededrttecnico2) {
		this.pededrttecnico2 = pededrttecnico2;
	}

	public int getTeprogramado() {
		return teprogramado;
	}

	public void setTeprogramado(int teprogramado) {
		this.teprogramado = teprogramado;
	}

	

}