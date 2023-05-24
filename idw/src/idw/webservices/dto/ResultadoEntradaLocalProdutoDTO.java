package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ResultadoEntradaLocalProdutoDTO extends ResultadoMovimentacaoLocalEstoqueDTO implements Serializable{

	public static final Integer _erro_localorigem_desconhecido = 1;
	public static final Integer _erro_localdestino_desconhecido = 2;
	public static final Integer _erro_produto_desconhecido = 3;
	public static final Integer _erro_entrada_desconhecido = 4;
	public static final Integer _erro_saida_maiortotal = 5;
	public static final Integer _erro_usuario_desconhecido = 6;
	public static final Integer _erro_sem_calendario = 7;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idErro = 0;
	
	public Integer getIdErro() {
		return idErro;
	}
	public void setIdErro(Integer idErro) {
		this.idErro = idErro;
	}
}
