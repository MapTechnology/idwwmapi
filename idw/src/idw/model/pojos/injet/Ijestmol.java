package idw.model.pojos.injet;

// Generated 28/08/2012 14:05:59 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ijestmol generated by hbm2java
 */
@Entity
@Table(name = "IJESTMOL")
public class Ijestmol implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4643660636859036788L;
	private IjestmolId id;
	private Ijtbmol ijtbmol;
	private char estruturaativa;
	private Set<Ijacumpar> ijacumpars = new HashSet<Ijacumpar>(0);
	private Set<Exportacao004> exportacao004s = new HashSet<Exportacao004>(0);
	private Set<Ijlogope> ijlogopes = new HashSet<Ijlogope>(0);
	private Set<Ijfictecconfig> ijfictecconfigs = new HashSet<Ijfictecconfig>(0);
	private Set<Ijreacic> ijreacics = new HashSet<Ijreacic>(0);
	private Set<Ijreacicop> ijreacicops = new HashSet<Ijreacicop>(0);
	private Set<Ijplanop> ijplanops = new HashSet<Ijplanop>(0);
	private Set<Ijpromolestpadrao> ijpromolestpadraos = new HashSet<Ijpromolestpadrao>(
			0);
	private Set<Ijopprodutos> ijopprodutoses = new HashSet<Ijopprodutos>(0);
	private Set<Ijoproteiro> ijoproteiros = new HashSet<Ijoproteiro>(0);
	private Set<Ijmolproautorizmod> ijmolproautorizmods = new HashSet<Ijmolproautorizmod>(
			0);
	private Set<Ijop> ijops = new HashSet<Ijop>(0);
	private Set<Ijacumref> ijacumrefs = new HashSet<Ijacumref>(0);
	private Set<Ijalertas> ijalertases = new HashSet<Ijalertas>(0);
	private Set<Ijacumprod> ijacumprods = new HashSet<Ijacumprod>(0);
	private Set<Ijctrliniprocprod> ijctrliniprocprods = new HashSet<Ijctrliniprocprod>(
			0);
	private Set<Ijctrliniproctemp> ijctrliniproctemps = new HashSet<Ijctrliniproctemp>(
			0);
	private Set<Ijalertasauto> ijalertasautos = new HashSet<Ijalertasauto>(0);
	private Set<Ijcncturno> ijcncturnos = new HashSet<Ijcncturno>(0);
	private Set<Ijreacnc> ijreacncs = new HashSet<Ijreacnc>(0);
	private Set<Ijreainspprod> ijreainspprods = new HashSet<Ijreainspprod>(0);
	private Set<Ijctrliniproctroca> ijctrliniproctrocasForSysC0013002 = new HashSet<Ijctrliniproctroca>(
			0);
	private Set<Ijctrliniproctroca> ijctrliniproctrocasForSysC0013001 = new HashSet<Ijctrliniproctroca>(
			0);
	private Set<Ijmolpro> ijmolpros = new HashSet<Ijmolpro>(0);
	private Set<Ijrefextra> ijrefextras = new HashSet<Ijrefextra>(0);
	private Set<Ijrearef> ijrearefs = new HashSet<Ijrearef>(0);
	private Set<Ijrearea> ijreareas = new HashSet<Ijrearea>(0);
	private Set<Ijreapar> ijreapars = new HashSet<Ijreapar>(0);
	private Set<Ijtmpsetup> ijtmpsetupsForSysC0012982 = new HashSet<Ijtmpsetup>(
			0);
	private Set<Ijtmpsetup> ijtmpsetupsForSysC0012983 = new HashSet<Ijtmpsetup>(
			0);
	private Set<Ijtbinjultop> ijtbinjultops = new HashSet<Ijtbinjultop>(0);
	private Set<Ijreajuscav> ijreajuscavs = new HashSet<Ijreajuscav>(0);
	private Set<Ijengleituraciclos> ijengleituracicloses = new HashSet<Ijengleituraciclos>(
			0);
	private Set<Ijenglogciclos> ijenglogcicloses = new HashSet<Ijenglogciclos>(
			0);
	private Set<Ijficcnc> ijficcncs = new HashSet<Ijficcnc>(0);
	private Set<Ijfictec> ijfictecs = new HashSet<Ijfictec>(0);

	public Ijestmol() {
	}

	public Ijestmol(IjestmolId id, Ijtbmol ijtbmol, char estruturaativa) {
		this.id = id;
		this.ijtbmol = ijtbmol;
		this.estruturaativa = estruturaativa;
	}

	public Ijestmol(IjestmolId id, Ijtbmol ijtbmol, char estruturaativa,
			Set<Ijacumpar> ijacumpars, Set<Exportacao004> exportacao004s,
			Set<Ijlogope> ijlogopes, Set<Ijfictecconfig> ijfictecconfigs,
			Set<Ijreacic> ijreacics, Set<Ijreacicop> ijreacicops,
			Set<Ijplanop> ijplanops, Set<Ijpromolestpadrao> ijpromolestpadraos,
			Set<Ijopprodutos> ijopprodutoses, Set<Ijoproteiro> ijoproteiros,
			Set<Ijmolproautorizmod> ijmolproautorizmods, Set<Ijop> ijops,
			Set<Ijacumref> ijacumrefs, Set<Ijalertas> ijalertases,
			Set<Ijacumprod> ijacumprods,
			Set<Ijctrliniprocprod> ijctrliniprocprods,
			Set<Ijctrliniproctemp> ijctrliniproctemps,
			Set<Ijalertasauto> ijalertasautos, Set<Ijcncturno> ijcncturnos,
			Set<Ijreacnc> ijreacncs, Set<Ijreainspprod> ijreainspprods,
			Set<Ijctrliniproctroca> ijctrliniproctrocasForSysC0013002,
			Set<Ijctrliniproctroca> ijctrliniproctrocasForSysC0013001,
			Set<Ijmolpro> ijmolpros, Set<Ijrefextra> ijrefextras,
			Set<Ijrearef> ijrearefs, Set<Ijrearea> ijreareas,
			Set<Ijreapar> ijreapars, Set<Ijtmpsetup> ijtmpsetupsForSysC0012982,
			Set<Ijtmpsetup> ijtmpsetupsForSysC0012983,
			Set<Ijtbinjultop> ijtbinjultops, Set<Ijreajuscav> ijreajuscavs,
			Set<Ijengleituraciclos> ijengleituracicloses,
			Set<Ijenglogciclos> ijenglogcicloses, Set<Ijficcnc> ijficcncs,
			Set<Ijfictec> ijfictecs) {
		this.id = id;
		this.ijtbmol = ijtbmol;
		this.estruturaativa = estruturaativa;
		this.ijacumpars = ijacumpars;
		this.exportacao004s = exportacao004s;
		this.ijlogopes = ijlogopes;
		this.ijfictecconfigs = ijfictecconfigs;
		this.ijreacics = ijreacics;
		this.ijreacicops = ijreacicops;
		this.ijplanops = ijplanops;
		this.ijpromolestpadraos = ijpromolestpadraos;
		this.ijopprodutoses = ijopprodutoses;
		this.ijoproteiros = ijoproteiros;
		this.ijmolproautorizmods = ijmolproautorizmods;
		this.ijops = ijops;
		this.ijacumrefs = ijacumrefs;
		this.ijalertases = ijalertases;
		this.ijacumprods = ijacumprods;
		this.ijctrliniprocprods = ijctrliniprocprods;
		this.ijctrliniproctemps = ijctrliniproctemps;
		this.ijalertasautos = ijalertasautos;
		this.ijcncturnos = ijcncturnos;
		this.ijreacncs = ijreacncs;
		this.ijreainspprods = ijreainspprods;
		this.ijctrliniproctrocasForSysC0013002 = ijctrliniproctrocasForSysC0013002;
		this.ijctrliniproctrocasForSysC0013001 = ijctrliniproctrocasForSysC0013001;
		this.ijmolpros = ijmolpros;
		this.ijrefextras = ijrefextras;
		this.ijrearefs = ijrearefs;
		this.ijreareas = ijreareas;
		this.ijreapars = ijreapars;
		this.ijtmpsetupsForSysC0012982 = ijtmpsetupsForSysC0012982;
		this.ijtmpsetupsForSysC0012983 = ijtmpsetupsForSysC0012983;
		this.ijtbinjultops = ijtbinjultops;
		this.ijreajuscavs = ijreajuscavs;
		this.ijengleituracicloses = ijengleituracicloses;
		this.ijenglogcicloses = ijenglogcicloses;
		this.ijficcncs = ijficcncs;
		this.ijfictecs = ijfictecs;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cdmolde", column = @Column(name = "CDMOLDE", nullable = false, length = 6)),
			@AttributeOverride(name = "cdestrutura", column = @Column(name = "CDESTRUTURA", nullable = false, length = 4)) })
	public IjestmolId getId() {
		return this.id;
	}

	public void setId(IjestmolId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDMOLDE", nullable = false, insertable = false, updatable = false)
	public Ijtbmol getIjtbmol() {
		return this.ijtbmol;
	}

	public void setIjtbmol(Ijtbmol ijtbmol) {
		this.ijtbmol = ijtbmol;
	}

	@Column(name = "ESTRUTURAATIVA", nullable = false, length = 1)
	public char getEstruturaativa() {
		return this.estruturaativa;
	}

	public void setEstruturaativa(char estruturaativa) {
		this.estruturaativa = estruturaativa;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijacumpar> getIjacumpars() {
		return this.ijacumpars;
	}

	public void setIjacumpars(Set<Ijacumpar> ijacumpars) {
		this.ijacumpars = ijacumpars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Exportacao004> getExportacao004s() {
		return this.exportacao004s;
	}

	public void setExportacao004s(Set<Exportacao004> exportacao004s) {
		this.exportacao004s = exportacao004s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijlogope> getIjlogopes() {
		return this.ijlogopes;
	}

	public void setIjlogopes(Set<Ijlogope> ijlogopes) {
		this.ijlogopes = ijlogopes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijfictecconfig> getIjfictecconfigs() {
		return this.ijfictecconfigs;
	}

	public void setIjfictecconfigs(Set<Ijfictecconfig> ijfictecconfigs) {
		this.ijfictecconfigs = ijfictecconfigs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijreacic> getIjreacics() {
		return this.ijreacics;
	}

	public void setIjreacics(Set<Ijreacic> ijreacics) {
		this.ijreacics = ijreacics;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijreacicop> getIjreacicops() {
		return this.ijreacicops;
	}

	public void setIjreacicops(Set<Ijreacicop> ijreacicops) {
		this.ijreacicops = ijreacicops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijplanop> getIjplanops() {
		return this.ijplanops;
	}

	public void setIjplanops(Set<Ijplanop> ijplanops) {
		this.ijplanops = ijplanops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijpromolestpadrao> getIjpromolestpadraos() {
		return this.ijpromolestpadraos;
	}

	public void setIjpromolestpadraos(Set<Ijpromolestpadrao> ijpromolestpadraos) {
		this.ijpromolestpadraos = ijpromolestpadraos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijopprodutos> getIjopprodutoses() {
		return this.ijopprodutoses;
	}

	public void setIjopprodutoses(Set<Ijopprodutos> ijopprodutoses) {
		this.ijopprodutoses = ijopprodutoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijoproteiro> getIjoproteiros() {
		return this.ijoproteiros;
	}

	public void setIjoproteiros(Set<Ijoproteiro> ijoproteiros) {
		this.ijoproteiros = ijoproteiros;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijmolproautorizmod> getIjmolproautorizmods() {
		return this.ijmolproautorizmods;
	}

	public void setIjmolproautorizmods(
			Set<Ijmolproautorizmod> ijmolproautorizmods) {
		this.ijmolproautorizmods = ijmolproautorizmods;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijop> getIjops() {
		return this.ijops;
	}

	public void setIjops(Set<Ijop> ijops) {
		this.ijops = ijops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijacumref> getIjacumrefs() {
		return this.ijacumrefs;
	}

	public void setIjacumrefs(Set<Ijacumref> ijacumrefs) {
		this.ijacumrefs = ijacumrefs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijalertas> getIjalertases() {
		return this.ijalertases;
	}

	public void setIjalertases(Set<Ijalertas> ijalertases) {
		this.ijalertases = ijalertases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijacumprod> getIjacumprods() {
		return this.ijacumprods;
	}

	public void setIjacumprods(Set<Ijacumprod> ijacumprods) {
		this.ijacumprods = ijacumprods;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijctrliniprocprod> getIjctrliniprocprods() {
		return this.ijctrliniprocprods;
	}

	public void setIjctrliniprocprods(Set<Ijctrliniprocprod> ijctrliniprocprods) {
		this.ijctrliniprocprods = ijctrliniprocprods;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijctrliniproctemp> getIjctrliniproctemps() {
		return this.ijctrliniproctemps;
	}

	public void setIjctrliniproctemps(Set<Ijctrliniproctemp> ijctrliniproctemps) {
		this.ijctrliniproctemps = ijctrliniproctemps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijalertasauto> getIjalertasautos() {
		return this.ijalertasautos;
	}

	public void setIjalertasautos(Set<Ijalertasauto> ijalertasautos) {
		this.ijalertasautos = ijalertasautos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijcncturno> getIjcncturnos() {
		return this.ijcncturnos;
	}

	public void setIjcncturnos(Set<Ijcncturno> ijcncturnos) {
		this.ijcncturnos = ijcncturnos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijreacnc> getIjreacncs() {
		return this.ijreacncs;
	}

	public void setIjreacncs(Set<Ijreacnc> ijreacncs) {
		this.ijreacncs = ijreacncs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijreainspprod> getIjreainspprods() {
		return this.ijreainspprods;
	}

	public void setIjreainspprods(Set<Ijreainspprod> ijreainspprods) {
		this.ijreainspprods = ijreainspprods;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmolBySysC0013002")
	public Set<Ijctrliniproctroca> getIjctrliniproctrocasForSysC0013002() {
		return this.ijctrliniproctrocasForSysC0013002;
	}

	public void setIjctrliniproctrocasForSysC0013002(
			Set<Ijctrliniproctroca> ijctrliniproctrocasForSysC0013002) {
		this.ijctrliniproctrocasForSysC0013002 = ijctrliniproctrocasForSysC0013002;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmolBySysC0013001")
	public Set<Ijctrliniproctroca> getIjctrliniproctrocasForSysC0013001() {
		return this.ijctrliniproctrocasForSysC0013001;
	}

	public void setIjctrliniproctrocasForSysC0013001(
			Set<Ijctrliniproctroca> ijctrliniproctrocasForSysC0013001) {
		this.ijctrliniproctrocasForSysC0013001 = ijctrliniproctrocasForSysC0013001;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijmolpro> getIjmolpros() {
		return this.ijmolpros;
	}

	public void setIjmolpros(Set<Ijmolpro> ijmolpros) {
		this.ijmolpros = ijmolpros;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijrefextra> getIjrefextras() {
		return this.ijrefextras;
	}

	public void setIjrefextras(Set<Ijrefextra> ijrefextras) {
		this.ijrefextras = ijrefextras;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijrearef> getIjrearefs() {
		return this.ijrearefs;
	}

	public void setIjrearefs(Set<Ijrearef> ijrearefs) {
		this.ijrearefs = ijrearefs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijrearea> getIjreareas() {
		return this.ijreareas;
	}

	public void setIjreareas(Set<Ijrearea> ijreareas) {
		this.ijreareas = ijreareas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijreapar> getIjreapars() {
		return this.ijreapars;
	}

	public void setIjreapars(Set<Ijreapar> ijreapars) {
		this.ijreapars = ijreapars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmolBySysC0012982")
	public Set<Ijtmpsetup> getIjtmpsetupsForSysC0012982() {
		return this.ijtmpsetupsForSysC0012982;
	}

	public void setIjtmpsetupsForSysC0012982(
			Set<Ijtmpsetup> ijtmpsetupsForSysC0012982) {
		this.ijtmpsetupsForSysC0012982 = ijtmpsetupsForSysC0012982;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmolBySysC0012983")
	public Set<Ijtmpsetup> getIjtmpsetupsForSysC0012983() {
		return this.ijtmpsetupsForSysC0012983;
	}

	public void setIjtmpsetupsForSysC0012983(
			Set<Ijtmpsetup> ijtmpsetupsForSysC0012983) {
		this.ijtmpsetupsForSysC0012983 = ijtmpsetupsForSysC0012983;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijtbinjultop> getIjtbinjultops() {
		return this.ijtbinjultops;
	}

	public void setIjtbinjultops(Set<Ijtbinjultop> ijtbinjultops) {
		this.ijtbinjultops = ijtbinjultops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijreajuscav> getIjreajuscavs() {
		return this.ijreajuscavs;
	}

	public void setIjreajuscavs(Set<Ijreajuscav> ijreajuscavs) {
		this.ijreajuscavs = ijreajuscavs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijengleituraciclos> getIjengleituracicloses() {
		return this.ijengleituracicloses;
	}

	public void setIjengleituracicloses(
			Set<Ijengleituraciclos> ijengleituracicloses) {
		this.ijengleituracicloses = ijengleituracicloses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijenglogciclos> getIjenglogcicloses() {
		return this.ijenglogcicloses;
	}

	public void setIjenglogcicloses(Set<Ijenglogciclos> ijenglogcicloses) {
		this.ijenglogcicloses = ijenglogcicloses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijficcnc> getIjficcncs() {
		return this.ijficcncs;
	}

	public void setIjficcncs(Set<Ijficcnc> ijficcncs) {
		this.ijficcncs = ijficcncs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ijestmol")
	public Set<Ijfictec> getIjfictecs() {
		return this.ijfictecs;
	}

	public void setIjfictecs(Set<Ijfictec> ijfictecs) {
		this.ijfictecs = ijfictecs;
	}

}