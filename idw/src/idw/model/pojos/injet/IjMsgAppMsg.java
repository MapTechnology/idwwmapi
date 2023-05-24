package idw.model.pojos.injet;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ijmsgappmsg")
public class IjMsgAppMsg implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idregistro;
	private String telefone;
	private String pastaanexo;
	private String titulo;
	private String mensagem;
	private Integer stenvio;
	private Date dthrregistro;
	
	
	@Id
	@Column(name = "idregistro", unique = true, nullable = false)
	public Long getIdregistro() {
		return idregistro;
	}
	public void setIdregistro(Long idregistro) {
		this.idregistro = idregistro;
	}
	
	@Column(name = "telefone")
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "pastaanexo")
	public String getPastaanexo() {
		return pastaanexo;
	}
	public void setPastaanexo(String pastaanexo) {
		this.pastaanexo = pastaanexo;
	}

	@Column(name = "titulo")
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "mensagem")
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
	@Column(name = "stenvio")
	public Integer getStenvio() {
		return stenvio;
	}
	public void setStenvio(Integer stenvio) {
		this.stenvio = stenvio;
	}

	@Column(name = "dthrregistro")
	public Date getDthrregistro() {
		return dthrregistro;
	}
	public void setDthrregistro(Date dthrregistro) {
		this.dthrregistro = dthrregistro;
	}
	
	

}
