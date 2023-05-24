package injetws.model.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PR_UP_ULTIMA_PARADA")
public class PrUpUltimaParada {
	
	private String idup;
	private Date dtHrIParada;
	private Date dtHrFParada;
	private String cdParada;
	private String cdCausa;
	private String cdAcao;
	private String cdJustificativa;
	private String cdTecnico1;
	private String cdTecnico2;
	private String cdTecnicoResponsavel;
	private Character isParadaRegulagem;
	private String cdlocalparada;
	private Character isparadaperiodosemconexao;
	private String txtanotacao;
	
	public PrUpUltimaParada(String IdUP, Date DtHrIParada, Date DtHrFParada,
			String CdParada, String CdCausa, String CdAcao, String CdJustificativa,
			String CdTecnico1, String CdTecnico2, String CdTecnicoResponsavel,
			Character isParadaRegulagem,String cdlocalparada,char isparadaperiodosemconexao,
			String txtanotacao) {
		this.idup = IdUP;
		this.dtHrIParada = DtHrIParada;
		this.dtHrFParada = DtHrFParada;
		this.cdParada = CdParada;
		this.cdCausa = CdCausa;
		this.cdAcao = CdAcao;
		this.cdJustificativa = CdJustificativa;
		this.cdTecnico1 = CdTecnico1;
		this.cdTecnico2 = CdTecnico2;
		this.cdTecnicoResponsavel = CdTecnicoResponsavel;
		this.isParadaRegulagem = isParadaRegulagem;
		this.cdlocalparada = cdlocalparada;
		this.isparadaperiodosemconexao=isparadaperiodosemconexao;
		this.txtanotacao = txtanotacao;
	}
	
	public PrUpUltimaParada(String IdUP, Date DtHrIParada) {
		this.idup = IdUP;
		this.dtHrIParada = DtHrIParada;		
	}
	
	public PrUpUltimaParada() {
	}
	
	
	@Id
	@Column(name = "IdUP", unique = true, nullable = false, length = 36)
	public String getIdup() {
		return idup;
	}	

	public void setIdup(String IdUP) {
		this.idup = IdUP;
	}
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DtHrIParada")
	public Date getDtHrIParada() {
		return this.dtHrIParada;
	}

	public void setDtHrIParada(Date DtHrIParada) {
		this.dtHrIParada = DtHrIParada;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DtHrFParada")
	public Date getDtHrFParada() {
		return this.dtHrFParada;
	}

	public void setDtHrFParada(Date DtHrFParada) {
		this.dtHrFParada = DtHrFParada;
	}

	
	@Column(name = "CdParada", nullable = true, length = 6)
	public String getCdParada() {
		return cdParada;
	}	

	public void setCdParada(String CdParada) {
		this.cdParada = CdParada;
	}
	
	
	@Column(name = "CdCausa", nullable = true, length = 6)
	public String getCdCausa() {
		return cdCausa;
	}	

	public void setCdCausa(String CdCausa) {
		this.cdCausa = CdCausa;
	}
	
	
	@Column(name = "CdAcao", nullable = true, length = 6)
	public String getCdAcao() {
		return cdAcao;
	}	

	public void setCdAcao(String CdAcao) {
		this.cdAcao = CdAcao;
	}
	
	
	@Column(name = "CdJustificativa", nullable = true, length = 6)
	public String getCdJustificativa() {
		return cdJustificativa;
	}	

	public void setCdJustificativa(String CdJustificativa) {
		this.cdJustificativa = CdJustificativa;
	}
	
	
	@Column(name = "CdTecnico1", nullable = true, length = 6)
	public String getCdTecnico1() {
		return cdTecnico1;
	}	

	public void setCdTecnico1(String CdTecnico1) {
		this.cdTecnico1 = CdTecnico1;
	}
	
	
	@Column(name = "CdTecnico2", nullable = true, length = 6)
	public String getCdTecnico2() {
		return cdTecnico2;
	}	

	public void setCdTecnico2(String CdTecnico2) {
		this.cdTecnico2 = CdTecnico2;
	}
	
	
	@Column(name = "CdTecnicoResponsavel", nullable = true, length = 6)
	public String getCdTecnicoResponsavel() {
		return cdTecnicoResponsavel;
	}	

	public void setCdTecnicoResponsavel(String CdTecnicoResponsavel) {
		this.cdTecnicoResponsavel = CdTecnicoResponsavel;
	}
	
	
	@Column(name = "isParadaRegulagem", nullable = true, length = 1)
	public Character getisParadaRegulagem() {
		return isParadaRegulagem;
	}	

	public void setisParadaRegulagem(Character isParadaRegulagem) {
		this.isParadaRegulagem = isParadaRegulagem;
	}

	@Column(name = "CDLOCALPARADA", nullable = true, length = 6)
	public String getCdLocalParada() {
		return cdlocalparada;
	}	

	public void setCdLocalParada(String cdlocalparada) {
		this.cdlocalparada = cdlocalparada;
	}
	
	@Column(name = "IsParadaPeriodoSemConexao", nullable = true, length = 1)
	public Character getIsParadaPeriodoSemConexao() {
		return isparadaperiodosemconexao;
	}	

	public void setIsParadaPeriodoSemConexao(Character isparadaperiodosemconexao) {
		this.isparadaperiodosemconexao = isparadaperiodosemconexao;
	}	
	
	@Column(name = "TxtAnotacao", nullable = true, length = 500)
	public String getTxtAnotacao() {
		return txtanotacao;
	}	

	public void setTxtAnotacao(String txtanotacao) {
		this.txtanotacao = txtanotacao;
	}	
}
