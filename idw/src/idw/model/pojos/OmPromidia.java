package idw.model.pojos;

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

import idw.model.pojos.template.OmPromidiaTemplate;

/**
 * OmPromidia generated by hbm2java
 */
@Entity
@Table(name = "om_promidia")
public class OmPromidia extends OmPromidiaTemplate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idPromidia;
	private OmProduto omProduto;
	private String dsPromidia;
	private byte[] midia;
	private String extensaoArquivo;
	
	private Date dthrCadastro;
	private Date dthrIvalidade;
	private Date dthrFvalidade;
	
	private Byte stAtivo;
	private Byte tpMidia;
	private String nomearquivo;
	
	private OmPt omPt;
	private OmTppt omTppt;
	private OmUsr omUsr;
	

	public OmPromidia() {
	}

	public OmPromidia(Long idPromidia, OmProduto omProduto) {
		this.idPromidia = idPromidia;
		this.omProduto = omProduto;
	}

	public OmPromidia(Long idPromidia, OmProduto omProduto, String dsPromidia, byte[] midia) {
		this.idPromidia = idPromidia;
		this.omProduto = omProduto;
		this.dsPromidia = dsPromidia;
		this.midia = midia;
	}

	@Id
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.AUTO, generator = "OM_PROMIDIA_SEQ")
	@javax.persistence.SequenceGenerator(name = "OM_PROMIDIA_SEQ", sequenceName = "OM_PROMIDIA_SEQ")
	@Column(name = "id_promidia", unique = true, nullable = false)
	public Long getIdPromidia() {
		return this.idPromidia;
	}

	public void setIdPromidia(Long idPromidia) {
		this.idPromidia = idPromidia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_produto", nullable = false)
	public OmProduto getOmProduto() {
		return this.omProduto;
	}

	public void setOmProduto(OmProduto omProduto) {
		this.omProduto = omProduto;
	}

	@Column(name = "ds_promidia", length = 256)
	public String getDsPromidia() {
		return this.dsPromidia;
	}

	public void setDsPromidia(String dsPromidia) {
		this.dsPromidia = dsPromidia;
	}

	@Column(name = "midia")
	public byte[] getMidia() {
		return this.midia;
	}

	public void setMidia(byte[] midia) {
		this.midia = midia;
	}
	
	@Column(name = "extensaoarquivo", length = 60)
	public String getExtensaoArquivo() {
		return this.extensaoArquivo;
	}

	public void setExtensaoArquivo(String extensaoArquivo) {
		this.extensaoArquivo = extensaoArquivo;
	}

	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		
		retorno.append("OmPromidia\n");
		
		if(this.idPromidia == null) {
			retorno.append("	id: null\n");
		} else {
			retorno.append("	id: ");
			retorno.append(this.idPromidia);
			retorno.append("\n");
		}
		
		if(this.omProduto == null){
			retorno.append("	produto: null\n");
		} else {
			retorno.append("	produto: ");
			retorno.append(omProduto.getCdProduto());
			retorno.append("\n");
		}
		
		if(this.dsPromidia == null){
			retorno.append("	descricao: null\n");
		} else {
			retorno.append("	descricao: ");
			retorno.append(this.dsPromidia);
			retorno.append("\n");
		}
		
		if(this.midia == null){
			retorno.append("	midia: null\n");
		} else {
			retorno.append("	midia: ");
			retorno.append(midia.length);
			retorno.append("\n");
		}
		
		if(this.extensaoArquivo == null){
			retorno.append("	extensaoArquivo: null\n");
		} else {
			retorno.append("	extensaoArquivo: ");
			retorno.append(extensaoArquivo);
			retorno.append("\n");
		}
		
		return retorno.toString();
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_cadastro", length = 23)
	public Date getDthrCadastro() {
		return dthrCadastro;
	}

	public void setDthrCadastro(Date dthrCadastro) {
		this.dthrCadastro = dthrCadastro;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_ivalidade", length = 23)
	public Date getDthrIvalidade() {
		return dthrIvalidade;
	}

	public void setDthrIvalidade(Date dthrIvalidade) {
		this.dthrIvalidade = dthrIvalidade;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dthr_fvalidade", length = 23)
	public Date getDthrFvalidade() {
		return dthrFvalidade;
	}

	public void setDthrFvalidade(Date dthrFvalidade) {
		this.dthrFvalidade = dthrFvalidade;
	}

	@Column(name = "nomearquivo", length = 256)
	public String getNomearquivo() {
		return nomearquivo;
	}

	public void setNomearquivo(String nomearquivo) {
		this.nomearquivo = nomearquivo;
	}
	

	@Column(name = "st_ativo")
	public Byte getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(Byte stAtivo) {
		this.stAtivo = stAtivo;
	}

	@Column(name = "tp_midia")
	public Byte getTpMidia() {
		return tpMidia;
	}

	public void setTpMidia(Byte tpMidia) {
		this.tpMidia = tpMidia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usr", nullable = false)
	public OmUsr getOmUsr() {
		return omUsr;
	}

	public void setOmUsr(OmUsr omUsr) {
		this.omUsr = omUsr;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PT")
	public OmPt getOmPt() {
		return this.omPt;
	}

	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TPPT")
	public OmTppt getOmTppt() {
		return this.omTppt;
	}

	public void setOmTppt(OmTppt omTppt) {
		this.omTppt = omTppt;
	}

}