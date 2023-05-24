package idw.model.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import idw.model.pojos.template.DwEstmovRapTemplate;

@XmlRootElement
@Entity
@Table(name = "DW_ESTMOV_RAP")
public class DwEstmovRap extends DwEstmovRapTemplate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idEstmovrap;
	private Date dthrMovimentacao;
	
	private DwRap dwRap;
	private DwEstlocal dwEstlocalOrigem;
	private DwEstlocal dwEstlocalDestino;
	private OmUsr omUsr;
	
	
	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "DW_ESTMOV_RAP_SEQ")
	@javax.persistence.SequenceGenerator(name = "DW_ESTMOV_RAP_SEQ", sequenceName = "DW_ESTMOV_RAP_SEQ")
	@Column(name = "ID_ESTMOV", nullable = false, precision = 22, scale = 0)
	public Long getIdEstmovrap() {
		return idEstmovrap;
	}
	public void setIdEstmovrap(Long idEstmovrap) {
		this.idEstmovrap = idEstmovrap;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DTHR_MOVIMENTACAO", length = 23)
	public Date getDthrMovimentacao() {
		return dthrMovimentacao;
	}
	public void setDthrMovimentacao(Date dthrMovimentacao) {
		this.dthrMovimentacao = dthrMovimentacao;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_rap")
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estlocalorigem")
	public DwEstlocal getDwEstlocalOrigem() {
		return dwEstlocalOrigem;
	}
	public void setDwEstlocalOrigem(DwEstlocal dwEstlocalOrigem) {
		this.dwEstlocalOrigem = dwEstlocalOrigem;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estlocaldestino")
	public DwEstlocal getDwEstlocalDestino() {
		return dwEstlocalDestino;
	}
	public void setDwEstlocalDestino(DwEstlocal dwEstlocalDestino) {
		this.dwEstlocalDestino = dwEstlocalDestino;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usr")
	public OmUsr getOmUsr() {
		return omUsr;
	}
	public void setOmUsr(OmUsr omUsr) {
		this.omUsr = omUsr;
	}
}
