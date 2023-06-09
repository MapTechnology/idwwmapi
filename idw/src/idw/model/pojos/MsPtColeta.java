package idw.model.pojos;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MsPtColeta generated by hbm2java
 */
@Entity
@Table(name="ms_pt_coleta"
)
public class MsPtColeta  implements java.io.Serializable {


     /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 private Long idPt;
     private DwTAcao dwTAcao;
     private DwTJust dwTJust;
     private OmUsr omUsrByIdUsrTecnicoResp;
     private OmPt omPt;
     private OmUsr omUsrByIdUsrTecnicoDois;
     private OmUsr omUsrByIdUsrTecnicoUm;
     private DwTParada dwTParada;
     private DwTCausa dwTCausa;
     private Date dthrHeartbeat;
     private Date dthrIparada;
     private Date dthrFparada;
     private String nrop;
     private Boolean isParada;
     
     private Set<MsPtColetaLogin> msPtColetaLogins = new HashSet<MsPtColetaLogin>(0);

    public MsPtColeta() {
    }

	
    public MsPtColeta(OmPt omPt) {
        this.omPt = omPt;
    }
    public MsPtColeta(DwTAcao dwTAcao, DwTJust dwTJust, OmUsr omUsrByIdUsrTecnicoResp, OmPt omPt, OmUsr omUsrByIdUsrTecnicoDois, OmUsr omUsrByIdUsrTecnicoUm, DwTParada dwTParada, DwTCausa dwTCausa, Date dthrHeartbeat, Date dthrIparada, Date dthrFparada, String nrop, Set<MsPtColetaLogin> msPtColetaLogins) {
       this.dwTAcao = dwTAcao;
       this.dwTJust = dwTJust;
       this.omUsrByIdUsrTecnicoResp = omUsrByIdUsrTecnicoResp;
       this.omPt = omPt;
       this.omUsrByIdUsrTecnicoDois = omUsrByIdUsrTecnicoDois;
       this.omUsrByIdUsrTecnicoUm = omUsrByIdUsrTecnicoUm;
       this.dwTParada = dwTParada;
       this.dwTCausa = dwTCausa;
       this.dthrHeartbeat = dthrHeartbeat;
       this.dthrIparada = dthrIparada;
       this.dthrFparada = dthrFparada;
       this.nrop = nrop;
       this.msPtColetaLogins = msPtColetaLogins;
    }
   
    @Id 
    @Column(name="id_pt", unique=true, nullable=false)
    public Long getIdPt() {
        return this.idPt;
    }
    
    public void setIdPt(Long idPt) {
        this.idPt = idPt;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tacao")
    public DwTAcao getDwTAcao() {
        return this.dwTAcao;
    }
    
    public void setDwTAcao(DwTAcao dwTAcao) {
        this.dwTAcao = dwTAcao;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tjust")
    public DwTJust getDwTJust() {
        return this.dwTJust;
    }
    
    public void setDwTJust(DwTJust dwTJust) {
        this.dwTJust = dwTJust;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_usrTecnicoResp")
    public OmUsr getOmUsrByIdUsrTecnicoResp() {
        return this.omUsrByIdUsrTecnicoResp;
    }
    
    public void setOmUsrByIdUsrTecnicoResp(OmUsr omUsrByIdUsrTecnicoResp) {
        this.omUsrByIdUsrTecnicoResp = omUsrByIdUsrTecnicoResp;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public OmPt getOmPt() {
        return this.omPt;
    }
    
    public void setOmPt(OmPt omPt) {
        this.omPt = omPt;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_usrTecnicoDois")
    public OmUsr getOmUsrByIdUsrTecnicoDois() {
        return this.omUsrByIdUsrTecnicoDois;
    }
    
    public void setOmUsrByIdUsrTecnicoDois(OmUsr omUsrByIdUsrTecnicoDois) {
        this.omUsrByIdUsrTecnicoDois = omUsrByIdUsrTecnicoDois;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_usrTecnicoUm")
    public OmUsr getOmUsrByIdUsrTecnicoUm() {
        return this.omUsrByIdUsrTecnicoUm;
    }
    
    public void setOmUsrByIdUsrTecnicoUm(OmUsr omUsrByIdUsrTecnicoUm) {
        this.omUsrByIdUsrTecnicoUm = omUsrByIdUsrTecnicoUm;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tparada")
    public DwTParada getDwTParada() {
        return this.dwTParada;
    }
    
    public void setDwTParada(DwTParada dwTParada) {
        this.dwTParada = dwTParada;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_tcausa")
    public DwTCausa getDwTCausa() {
        return this.dwTCausa;
    }
    
    public void setDwTCausa(DwTCausa dwTCausa) {
        this.dwTCausa = dwTCausa;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dthr_heartbeat", length=23)
    public Date getDthrHeartbeat() {
        return this.dthrHeartbeat;
    }
    
    public void setDthrHeartbeat(Date dthrHeartbeat) {
        this.dthrHeartbeat = dthrHeartbeat;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dthr_iparada", length=23)
    public Date getDthrIparada() {
        return this.dthrIparada;
    }
    
    public void setDthrIparada(Date dthrIparada) {
        this.dthrIparada = dthrIparada;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dthr_fparada", length=23)
    public Date getDthrFparada() {
        return this.dthrFparada;
    }
    
    public void setDthrFparada(Date dthrFparada) {
        this.dthrFparada = dthrFparada;
    }

    
    @Column(name="nrop", length=100)
    public String getNrop() {
        return this.nrop;
    }
    
    public void setNrop(String nrop) {
        this.nrop = nrop;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="msPtColeta")
    public Set<MsPtColetaLogin> getMsPtColetaLogins() {
        return this.msPtColetaLogins;
    }
    
    public void setMsPtColetaLogins(Set<MsPtColetaLogin> msPtColetaLogins) {
        this.msPtColetaLogins = msPtColetaLogins;
    }
	@Column(name = "IS_PARADA", precision = 1)
	public Boolean getIsParada() {
		return isParada;
	}

	public void setIsParada(Boolean is) {
		this.isParada = is;
	}
}
