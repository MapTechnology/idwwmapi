package idw.model.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.template.DwDetativTemplate;

/**
 * DwDetativ generated by hbm2java
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "dw_detativ")
public class DwDetativ extends DwDetativTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idDetativ;
	private DwProcativ dwProcativ;
	private Integer ordem;
	private Short tpDetativ;// 0 = texto; 1= foto;
	private String texto;
	
	private byte[] foto;

	public DwDetativ() {
	}

	public DwDetativ(long idDetativ, DwProcativ dwProcativ) {
		this.idDetativ = idDetativ;
		this.dwProcativ = dwProcativ;
	}


	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_DETATIV_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_DETATIV_SEQ", sequenceName = "DW_DETATIV_SEQ")
	@Column(name = "id_detativ", unique = true, nullable = false)
	public long getIdDetativ() {
		return this.idDetativ;
	}

	public void setIdDetativ(long idDetativ) {
		this.idDetativ = idDetativ;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_procativ", nullable = false)
	public DwProcativ getDwProcativ() {
		return this.dwProcativ;
	}

	public void setDwProcativ(DwProcativ dwProcativ) {
		this.dwProcativ = dwProcativ;
	}

	@Column(name = "ordem")
	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	@Column(name = "tp_detativ")
	public Short getTpDetativ() {
		return this.tpDetativ;
	}

	public void setTpDetativ(Short tpDetativ) {
		this.tpDetativ = tpDetativ;
	}

	@Column(name = "texto")
	@Lob
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Column(name = "foto")
	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
