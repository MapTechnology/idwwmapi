/**
 * Ijestmol.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijestmol  implements java.io.Serializable {
    private org.apache.axis.types.UnsignedShort estruturaativa;

    private idw.idwws.Exportacao004[] exportacao004S;

    private idw.idwws.IjestmolId id;

    private idw.idwws.Ijacumpar[] ijacumpars;

    private idw.idwws.Ijacumprod[] ijacumprods;

    private idw.idwws.Ijacumref[] ijacumrefs;

    private idw.idwws.Ijalertasauto[] ijalertasautos;

    private idw.idwws.Ijalertas[] ijalertases;

    private idw.idwws.Ijcncturno[] ijcncturnos;

    private idw.idwws.Ijctrliniprocprod[] ijctrliniprocprods;

    private idw.idwws.Ijctrliniproctemp[] ijctrliniproctemps;

    private idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocasForSysC0013001;

    private idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocasForSysC0013002;

    private idw.idwws.Ijengleituraciclos[] ijengleituracicloses;

    private idw.idwws.Ijenglogciclos[] ijenglogcicloses;

    private idw.idwws.Ijficcnc[] ijficcncs;

    private idw.idwws.Ijfictecconfig[] ijfictecconfigs;

    private idw.idwws.Ijfictec[] ijfictecs;

    private idw.idwws.Ijlogope[] ijlogopes;

    private idw.idwws.Ijmolproautorizmod[] ijmolproautorizmods;

    private idw.idwws.Ijmolpro[] ijmolpros;

    private idw.idwws.Ijopprodutos[] ijopprodutoses;

    private idw.idwws.Ijoproteiro[] ijoproteiros;

    private idw.idwws.Ijop[] ijops;

    private idw.idwws.Ijplanop[] ijplanops;

    private idw.idwws.Ijpromolestpadrao[] ijpromolestpadraos;

    private idw.idwws.Ijreacicop[] ijreacicops;

    private idw.idwws.Ijreacic[] ijreacics;

    private idw.idwws.Ijreacnc[] ijreacncs;

    private idw.idwws.Ijreainspprod[] ijreainspprods;

    private idw.idwws.Ijreajuscav[] ijreajuscavs;

    private idw.idwws.Ijreapar[] ijreapars;

    private idw.idwws.Ijrearea[] ijreareas;

    private idw.idwws.Ijrearef[] ijrearefs;

    private idw.idwws.Ijrefextra[] ijrefextras;

    private idw.idwws.Ijtbinjultop[] ijtbinjultops;

    private idw.idwws.Ijtbmol ijtbmol;

    private idw.idwws.Ijtmpsetup[] ijtmpsetupsForSysC0012982;

    private idw.idwws.Ijtmpsetup[] ijtmpsetupsForSysC0012983;

    public Ijestmol() {
    }

    public Ijestmol(
           org.apache.axis.types.UnsignedShort estruturaativa,
           idw.idwws.Exportacao004[] exportacao004S,
           idw.idwws.IjestmolId id,
           idw.idwws.Ijacumpar[] ijacumpars,
           idw.idwws.Ijacumprod[] ijacumprods,
           idw.idwws.Ijacumref[] ijacumrefs,
           idw.idwws.Ijalertasauto[] ijalertasautos,
           idw.idwws.Ijalertas[] ijalertases,
           idw.idwws.Ijcncturno[] ijcncturnos,
           idw.idwws.Ijctrliniprocprod[] ijctrliniprocprods,
           idw.idwws.Ijctrliniproctemp[] ijctrliniproctemps,
           idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocasForSysC0013001,
           idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocasForSysC0013002,
           idw.idwws.Ijengleituraciclos[] ijengleituracicloses,
           idw.idwws.Ijenglogciclos[] ijenglogcicloses,
           idw.idwws.Ijficcnc[] ijficcncs,
           idw.idwws.Ijfictecconfig[] ijfictecconfigs,
           idw.idwws.Ijfictec[] ijfictecs,
           idw.idwws.Ijlogope[] ijlogopes,
           idw.idwws.Ijmolproautorizmod[] ijmolproautorizmods,
           idw.idwws.Ijmolpro[] ijmolpros,
           idw.idwws.Ijopprodutos[] ijopprodutoses,
           idw.idwws.Ijoproteiro[] ijoproteiros,
           idw.idwws.Ijop[] ijops,
           idw.idwws.Ijplanop[] ijplanops,
           idw.idwws.Ijpromolestpadrao[] ijpromolestpadraos,
           idw.idwws.Ijreacicop[] ijreacicops,
           idw.idwws.Ijreacic[] ijreacics,
           idw.idwws.Ijreacnc[] ijreacncs,
           idw.idwws.Ijreainspprod[] ijreainspprods,
           idw.idwws.Ijreajuscav[] ijreajuscavs,
           idw.idwws.Ijreapar[] ijreapars,
           idw.idwws.Ijrearea[] ijreareas,
           idw.idwws.Ijrearef[] ijrearefs,
           idw.idwws.Ijrefextra[] ijrefextras,
           idw.idwws.Ijtbinjultop[] ijtbinjultops,
           idw.idwws.Ijtbmol ijtbmol,
           idw.idwws.Ijtmpsetup[] ijtmpsetupsForSysC0012982,
           idw.idwws.Ijtmpsetup[] ijtmpsetupsForSysC0012983) {
           this.estruturaativa = estruturaativa;
           this.exportacao004S = exportacao004S;
           this.id = id;
           this.ijacumpars = ijacumpars;
           this.ijacumprods = ijacumprods;
           this.ijacumrefs = ijacumrefs;
           this.ijalertasautos = ijalertasautos;
           this.ijalertases = ijalertases;
           this.ijcncturnos = ijcncturnos;
           this.ijctrliniprocprods = ijctrliniprocprods;
           this.ijctrliniproctemps = ijctrliniproctemps;
           this.ijctrliniproctrocasForSysC0013001 = ijctrliniproctrocasForSysC0013001;
           this.ijctrliniproctrocasForSysC0013002 = ijctrliniproctrocasForSysC0013002;
           this.ijengleituracicloses = ijengleituracicloses;
           this.ijenglogcicloses = ijenglogcicloses;
           this.ijficcncs = ijficcncs;
           this.ijfictecconfigs = ijfictecconfigs;
           this.ijfictecs = ijfictecs;
           this.ijlogopes = ijlogopes;
           this.ijmolproautorizmods = ijmolproautorizmods;
           this.ijmolpros = ijmolpros;
           this.ijopprodutoses = ijopprodutoses;
           this.ijoproteiros = ijoproteiros;
           this.ijops = ijops;
           this.ijplanops = ijplanops;
           this.ijpromolestpadraos = ijpromolestpadraos;
           this.ijreacicops = ijreacicops;
           this.ijreacics = ijreacics;
           this.ijreacncs = ijreacncs;
           this.ijreainspprods = ijreainspprods;
           this.ijreajuscavs = ijreajuscavs;
           this.ijreapars = ijreapars;
           this.ijreareas = ijreareas;
           this.ijrearefs = ijrearefs;
           this.ijrefextras = ijrefextras;
           this.ijtbinjultops = ijtbinjultops;
           this.ijtbmol = ijtbmol;
           this.ijtmpsetupsForSysC0012982 = ijtmpsetupsForSysC0012982;
           this.ijtmpsetupsForSysC0012983 = ijtmpsetupsForSysC0012983;
    }


    /**
     * Gets the estruturaativa value for this Ijestmol.
     * 
     * @return estruturaativa
     */
    public org.apache.axis.types.UnsignedShort getEstruturaativa() {
        return estruturaativa;
    }


    /**
     * Sets the estruturaativa value for this Ijestmol.
     * 
     * @param estruturaativa
     */
    public void setEstruturaativa(org.apache.axis.types.UnsignedShort estruturaativa) {
        this.estruturaativa = estruturaativa;
    }


    /**
     * Gets the exportacao004S value for this Ijestmol.
     * 
     * @return exportacao004S
     */
    public idw.idwws.Exportacao004[] getExportacao004S() {
        return exportacao004S;
    }


    /**
     * Sets the exportacao004S value for this Ijestmol.
     * 
     * @param exportacao004S
     */
    public void setExportacao004S(idw.idwws.Exportacao004[] exportacao004S) {
        this.exportacao004S = exportacao004S;
    }

    public idw.idwws.Exportacao004 getExportacao004S(int i) {
        return this.exportacao004S[i];
    }

    public void setExportacao004S(int i, idw.idwws.Exportacao004 _value) {
        this.exportacao004S[i] = _value;
    }


    /**
     * Gets the id value for this Ijestmol.
     * 
     * @return id
     */
    public idw.idwws.IjestmolId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijestmol.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjestmolId id) {
        this.id = id;
    }


    /**
     * Gets the ijacumpars value for this Ijestmol.
     * 
     * @return ijacumpars
     */
    public idw.idwws.Ijacumpar[] getIjacumpars() {
        return ijacumpars;
    }


    /**
     * Sets the ijacumpars value for this Ijestmol.
     * 
     * @param ijacumpars
     */
    public void setIjacumpars(idw.idwws.Ijacumpar[] ijacumpars) {
        this.ijacumpars = ijacumpars;
    }

    public idw.idwws.Ijacumpar getIjacumpars(int i) {
        return this.ijacumpars[i];
    }

    public void setIjacumpars(int i, idw.idwws.Ijacumpar _value) {
        this.ijacumpars[i] = _value;
    }


    /**
     * Gets the ijacumprods value for this Ijestmol.
     * 
     * @return ijacumprods
     */
    public idw.idwws.Ijacumprod[] getIjacumprods() {
        return ijacumprods;
    }


    /**
     * Sets the ijacumprods value for this Ijestmol.
     * 
     * @param ijacumprods
     */
    public void setIjacumprods(idw.idwws.Ijacumprod[] ijacumprods) {
        this.ijacumprods = ijacumprods;
    }

    public idw.idwws.Ijacumprod getIjacumprods(int i) {
        return this.ijacumprods[i];
    }

    public void setIjacumprods(int i, idw.idwws.Ijacumprod _value) {
        this.ijacumprods[i] = _value;
    }


    /**
     * Gets the ijacumrefs value for this Ijestmol.
     * 
     * @return ijacumrefs
     */
    public idw.idwws.Ijacumref[] getIjacumrefs() {
        return ijacumrefs;
    }


    /**
     * Sets the ijacumrefs value for this Ijestmol.
     * 
     * @param ijacumrefs
     */
    public void setIjacumrefs(idw.idwws.Ijacumref[] ijacumrefs) {
        this.ijacumrefs = ijacumrefs;
    }

    public idw.idwws.Ijacumref getIjacumrefs(int i) {
        return this.ijacumrefs[i];
    }

    public void setIjacumrefs(int i, idw.idwws.Ijacumref _value) {
        this.ijacumrefs[i] = _value;
    }


    /**
     * Gets the ijalertasautos value for this Ijestmol.
     * 
     * @return ijalertasautos
     */
    public idw.idwws.Ijalertasauto[] getIjalertasautos() {
        return ijalertasautos;
    }


    /**
     * Sets the ijalertasautos value for this Ijestmol.
     * 
     * @param ijalertasautos
     */
    public void setIjalertasautos(idw.idwws.Ijalertasauto[] ijalertasautos) {
        this.ijalertasautos = ijalertasautos;
    }

    public idw.idwws.Ijalertasauto getIjalertasautos(int i) {
        return this.ijalertasautos[i];
    }

    public void setIjalertasautos(int i, idw.idwws.Ijalertasauto _value) {
        this.ijalertasautos[i] = _value;
    }


    /**
     * Gets the ijalertases value for this Ijestmol.
     * 
     * @return ijalertases
     */
    public idw.idwws.Ijalertas[] getIjalertases() {
        return ijalertases;
    }


    /**
     * Sets the ijalertases value for this Ijestmol.
     * 
     * @param ijalertases
     */
    public void setIjalertases(idw.idwws.Ijalertas[] ijalertases) {
        this.ijalertases = ijalertases;
    }

    public idw.idwws.Ijalertas getIjalertases(int i) {
        return this.ijalertases[i];
    }

    public void setIjalertases(int i, idw.idwws.Ijalertas _value) {
        this.ijalertases[i] = _value;
    }


    /**
     * Gets the ijcncturnos value for this Ijestmol.
     * 
     * @return ijcncturnos
     */
    public idw.idwws.Ijcncturno[] getIjcncturnos() {
        return ijcncturnos;
    }


    /**
     * Sets the ijcncturnos value for this Ijestmol.
     * 
     * @param ijcncturnos
     */
    public void setIjcncturnos(idw.idwws.Ijcncturno[] ijcncturnos) {
        this.ijcncturnos = ijcncturnos;
    }

    public idw.idwws.Ijcncturno getIjcncturnos(int i) {
        return this.ijcncturnos[i];
    }

    public void setIjcncturnos(int i, idw.idwws.Ijcncturno _value) {
        this.ijcncturnos[i] = _value;
    }


    /**
     * Gets the ijctrliniprocprods value for this Ijestmol.
     * 
     * @return ijctrliniprocprods
     */
    public idw.idwws.Ijctrliniprocprod[] getIjctrliniprocprods() {
        return ijctrliniprocprods;
    }


    /**
     * Sets the ijctrliniprocprods value for this Ijestmol.
     * 
     * @param ijctrliniprocprods
     */
    public void setIjctrliniprocprods(idw.idwws.Ijctrliniprocprod[] ijctrliniprocprods) {
        this.ijctrliniprocprods = ijctrliniprocprods;
    }

    public idw.idwws.Ijctrliniprocprod getIjctrliniprocprods(int i) {
        return this.ijctrliniprocprods[i];
    }

    public void setIjctrliniprocprods(int i, idw.idwws.Ijctrliniprocprod _value) {
        this.ijctrliniprocprods[i] = _value;
    }


    /**
     * Gets the ijctrliniproctemps value for this Ijestmol.
     * 
     * @return ijctrliniproctemps
     */
    public idw.idwws.Ijctrliniproctemp[] getIjctrliniproctemps() {
        return ijctrliniproctemps;
    }


    /**
     * Sets the ijctrliniproctemps value for this Ijestmol.
     * 
     * @param ijctrliniproctemps
     */
    public void setIjctrliniproctemps(idw.idwws.Ijctrliniproctemp[] ijctrliniproctemps) {
        this.ijctrliniproctemps = ijctrliniproctemps;
    }

    public idw.idwws.Ijctrliniproctemp getIjctrliniproctemps(int i) {
        return this.ijctrliniproctemps[i];
    }

    public void setIjctrliniproctemps(int i, idw.idwws.Ijctrliniproctemp _value) {
        this.ijctrliniproctemps[i] = _value;
    }


    /**
     * Gets the ijctrliniproctrocasForSysC0013001 value for this Ijestmol.
     * 
     * @return ijctrliniproctrocasForSysC0013001
     */
    public idw.idwws.Ijctrliniproctroca[] getIjctrliniproctrocasForSysC0013001() {
        return ijctrliniproctrocasForSysC0013001;
    }


    /**
     * Sets the ijctrliniproctrocasForSysC0013001 value for this Ijestmol.
     * 
     * @param ijctrliniproctrocasForSysC0013001
     */
    public void setIjctrliniproctrocasForSysC0013001(idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocasForSysC0013001) {
        this.ijctrliniproctrocasForSysC0013001 = ijctrliniproctrocasForSysC0013001;
    }

    public idw.idwws.Ijctrliniproctroca getIjctrliniproctrocasForSysC0013001(int i) {
        return this.ijctrliniproctrocasForSysC0013001[i];
    }

    public void setIjctrliniproctrocasForSysC0013001(int i, idw.idwws.Ijctrliniproctroca _value) {
        this.ijctrliniproctrocasForSysC0013001[i] = _value;
    }


    /**
     * Gets the ijctrliniproctrocasForSysC0013002 value for this Ijestmol.
     * 
     * @return ijctrliniproctrocasForSysC0013002
     */
    public idw.idwws.Ijctrliniproctroca[] getIjctrliniproctrocasForSysC0013002() {
        return ijctrliniproctrocasForSysC0013002;
    }


    /**
     * Sets the ijctrliniproctrocasForSysC0013002 value for this Ijestmol.
     * 
     * @param ijctrliniproctrocasForSysC0013002
     */
    public void setIjctrliniproctrocasForSysC0013002(idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocasForSysC0013002) {
        this.ijctrliniproctrocasForSysC0013002 = ijctrliniproctrocasForSysC0013002;
    }

    public idw.idwws.Ijctrliniproctroca getIjctrliniproctrocasForSysC0013002(int i) {
        return this.ijctrliniproctrocasForSysC0013002[i];
    }

    public void setIjctrliniproctrocasForSysC0013002(int i, idw.idwws.Ijctrliniproctroca _value) {
        this.ijctrliniproctrocasForSysC0013002[i] = _value;
    }


    /**
     * Gets the ijengleituracicloses value for this Ijestmol.
     * 
     * @return ijengleituracicloses
     */
    public idw.idwws.Ijengleituraciclos[] getIjengleituracicloses() {
        return ijengleituracicloses;
    }


    /**
     * Sets the ijengleituracicloses value for this Ijestmol.
     * 
     * @param ijengleituracicloses
     */
    public void setIjengleituracicloses(idw.idwws.Ijengleituraciclos[] ijengleituracicloses) {
        this.ijengleituracicloses = ijengleituracicloses;
    }

    public idw.idwws.Ijengleituraciclos getIjengleituracicloses(int i) {
        return this.ijengleituracicloses[i];
    }

    public void setIjengleituracicloses(int i, idw.idwws.Ijengleituraciclos _value) {
        this.ijengleituracicloses[i] = _value;
    }


    /**
     * Gets the ijenglogcicloses value for this Ijestmol.
     * 
     * @return ijenglogcicloses
     */
    public idw.idwws.Ijenglogciclos[] getIjenglogcicloses() {
        return ijenglogcicloses;
    }


    /**
     * Sets the ijenglogcicloses value for this Ijestmol.
     * 
     * @param ijenglogcicloses
     */
    public void setIjenglogcicloses(idw.idwws.Ijenglogciclos[] ijenglogcicloses) {
        this.ijenglogcicloses = ijenglogcicloses;
    }

    public idw.idwws.Ijenglogciclos getIjenglogcicloses(int i) {
        return this.ijenglogcicloses[i];
    }

    public void setIjenglogcicloses(int i, idw.idwws.Ijenglogciclos _value) {
        this.ijenglogcicloses[i] = _value;
    }


    /**
     * Gets the ijficcncs value for this Ijestmol.
     * 
     * @return ijficcncs
     */
    public idw.idwws.Ijficcnc[] getIjficcncs() {
        return ijficcncs;
    }


    /**
     * Sets the ijficcncs value for this Ijestmol.
     * 
     * @param ijficcncs
     */
    public void setIjficcncs(idw.idwws.Ijficcnc[] ijficcncs) {
        this.ijficcncs = ijficcncs;
    }

    public idw.idwws.Ijficcnc getIjficcncs(int i) {
        return this.ijficcncs[i];
    }

    public void setIjficcncs(int i, idw.idwws.Ijficcnc _value) {
        this.ijficcncs[i] = _value;
    }


    /**
     * Gets the ijfictecconfigs value for this Ijestmol.
     * 
     * @return ijfictecconfigs
     */
    public idw.idwws.Ijfictecconfig[] getIjfictecconfigs() {
        return ijfictecconfigs;
    }


    /**
     * Sets the ijfictecconfigs value for this Ijestmol.
     * 
     * @param ijfictecconfigs
     */
    public void setIjfictecconfigs(idw.idwws.Ijfictecconfig[] ijfictecconfigs) {
        this.ijfictecconfigs = ijfictecconfigs;
    }

    public idw.idwws.Ijfictecconfig getIjfictecconfigs(int i) {
        return this.ijfictecconfigs[i];
    }

    public void setIjfictecconfigs(int i, idw.idwws.Ijfictecconfig _value) {
        this.ijfictecconfigs[i] = _value;
    }


    /**
     * Gets the ijfictecs value for this Ijestmol.
     * 
     * @return ijfictecs
     */
    public idw.idwws.Ijfictec[] getIjfictecs() {
        return ijfictecs;
    }


    /**
     * Sets the ijfictecs value for this Ijestmol.
     * 
     * @param ijfictecs
     */
    public void setIjfictecs(idw.idwws.Ijfictec[] ijfictecs) {
        this.ijfictecs = ijfictecs;
    }

    public idw.idwws.Ijfictec getIjfictecs(int i) {
        return this.ijfictecs[i];
    }

    public void setIjfictecs(int i, idw.idwws.Ijfictec _value) {
        this.ijfictecs[i] = _value;
    }


    /**
     * Gets the ijlogopes value for this Ijestmol.
     * 
     * @return ijlogopes
     */
    public idw.idwws.Ijlogope[] getIjlogopes() {
        return ijlogopes;
    }


    /**
     * Sets the ijlogopes value for this Ijestmol.
     * 
     * @param ijlogopes
     */
    public void setIjlogopes(idw.idwws.Ijlogope[] ijlogopes) {
        this.ijlogopes = ijlogopes;
    }

    public idw.idwws.Ijlogope getIjlogopes(int i) {
        return this.ijlogopes[i];
    }

    public void setIjlogopes(int i, idw.idwws.Ijlogope _value) {
        this.ijlogopes[i] = _value;
    }


    /**
     * Gets the ijmolproautorizmods value for this Ijestmol.
     * 
     * @return ijmolproautorizmods
     */
    public idw.idwws.Ijmolproautorizmod[] getIjmolproautorizmods() {
        return ijmolproautorizmods;
    }


    /**
     * Sets the ijmolproautorizmods value for this Ijestmol.
     * 
     * @param ijmolproautorizmods
     */
    public void setIjmolproautorizmods(idw.idwws.Ijmolproautorizmod[] ijmolproautorizmods) {
        this.ijmolproautorizmods = ijmolproautorizmods;
    }

    public idw.idwws.Ijmolproautorizmod getIjmolproautorizmods(int i) {
        return this.ijmolproautorizmods[i];
    }

    public void setIjmolproautorizmods(int i, idw.idwws.Ijmolproautorizmod _value) {
        this.ijmolproautorizmods[i] = _value;
    }


    /**
     * Gets the ijmolpros value for this Ijestmol.
     * 
     * @return ijmolpros
     */
    public idw.idwws.Ijmolpro[] getIjmolpros() {
        return ijmolpros;
    }


    /**
     * Sets the ijmolpros value for this Ijestmol.
     * 
     * @param ijmolpros
     */
    public void setIjmolpros(idw.idwws.Ijmolpro[] ijmolpros) {
        this.ijmolpros = ijmolpros;
    }

    public idw.idwws.Ijmolpro getIjmolpros(int i) {
        return this.ijmolpros[i];
    }

    public void setIjmolpros(int i, idw.idwws.Ijmolpro _value) {
        this.ijmolpros[i] = _value;
    }


    /**
     * Gets the ijopprodutoses value for this Ijestmol.
     * 
     * @return ijopprodutoses
     */
    public idw.idwws.Ijopprodutos[] getIjopprodutoses() {
        return ijopprodutoses;
    }


    /**
     * Sets the ijopprodutoses value for this Ijestmol.
     * 
     * @param ijopprodutoses
     */
    public void setIjopprodutoses(idw.idwws.Ijopprodutos[] ijopprodutoses) {
        this.ijopprodutoses = ijopprodutoses;
    }

    public idw.idwws.Ijopprodutos getIjopprodutoses(int i) {
        return this.ijopprodutoses[i];
    }

    public void setIjopprodutoses(int i, idw.idwws.Ijopprodutos _value) {
        this.ijopprodutoses[i] = _value;
    }


    /**
     * Gets the ijoproteiros value for this Ijestmol.
     * 
     * @return ijoproteiros
     */
    public idw.idwws.Ijoproteiro[] getIjoproteiros() {
        return ijoproteiros;
    }


    /**
     * Sets the ijoproteiros value for this Ijestmol.
     * 
     * @param ijoproteiros
     */
    public void setIjoproteiros(idw.idwws.Ijoproteiro[] ijoproteiros) {
        this.ijoproteiros = ijoproteiros;
    }

    public idw.idwws.Ijoproteiro getIjoproteiros(int i) {
        return this.ijoproteiros[i];
    }

    public void setIjoproteiros(int i, idw.idwws.Ijoproteiro _value) {
        this.ijoproteiros[i] = _value;
    }


    /**
     * Gets the ijops value for this Ijestmol.
     * 
     * @return ijops
     */
    public idw.idwws.Ijop[] getIjops() {
        return ijops;
    }


    /**
     * Sets the ijops value for this Ijestmol.
     * 
     * @param ijops
     */
    public void setIjops(idw.idwws.Ijop[] ijops) {
        this.ijops = ijops;
    }

    public idw.idwws.Ijop getIjops(int i) {
        return this.ijops[i];
    }

    public void setIjops(int i, idw.idwws.Ijop _value) {
        this.ijops[i] = _value;
    }


    /**
     * Gets the ijplanops value for this Ijestmol.
     * 
     * @return ijplanops
     */
    public idw.idwws.Ijplanop[] getIjplanops() {
        return ijplanops;
    }


    /**
     * Sets the ijplanops value for this Ijestmol.
     * 
     * @param ijplanops
     */
    public void setIjplanops(idw.idwws.Ijplanop[] ijplanops) {
        this.ijplanops = ijplanops;
    }

    public idw.idwws.Ijplanop getIjplanops(int i) {
        return this.ijplanops[i];
    }

    public void setIjplanops(int i, idw.idwws.Ijplanop _value) {
        this.ijplanops[i] = _value;
    }


    /**
     * Gets the ijpromolestpadraos value for this Ijestmol.
     * 
     * @return ijpromolestpadraos
     */
    public idw.idwws.Ijpromolestpadrao[] getIjpromolestpadraos() {
        return ijpromolestpadraos;
    }


    /**
     * Sets the ijpromolestpadraos value for this Ijestmol.
     * 
     * @param ijpromolestpadraos
     */
    public void setIjpromolestpadraos(idw.idwws.Ijpromolestpadrao[] ijpromolestpadraos) {
        this.ijpromolestpadraos = ijpromolestpadraos;
    }

    public idw.idwws.Ijpromolestpadrao getIjpromolestpadraos(int i) {
        return this.ijpromolestpadraos[i];
    }

    public void setIjpromolestpadraos(int i, idw.idwws.Ijpromolestpadrao _value) {
        this.ijpromolestpadraos[i] = _value;
    }


    /**
     * Gets the ijreacicops value for this Ijestmol.
     * 
     * @return ijreacicops
     */
    public idw.idwws.Ijreacicop[] getIjreacicops() {
        return ijreacicops;
    }


    /**
     * Sets the ijreacicops value for this Ijestmol.
     * 
     * @param ijreacicops
     */
    public void setIjreacicops(idw.idwws.Ijreacicop[] ijreacicops) {
        this.ijreacicops = ijreacicops;
    }

    public idw.idwws.Ijreacicop getIjreacicops(int i) {
        return this.ijreacicops[i];
    }

    public void setIjreacicops(int i, idw.idwws.Ijreacicop _value) {
        this.ijreacicops[i] = _value;
    }


    /**
     * Gets the ijreacics value for this Ijestmol.
     * 
     * @return ijreacics
     */
    public idw.idwws.Ijreacic[] getIjreacics() {
        return ijreacics;
    }


    /**
     * Sets the ijreacics value for this Ijestmol.
     * 
     * @param ijreacics
     */
    public void setIjreacics(idw.idwws.Ijreacic[] ijreacics) {
        this.ijreacics = ijreacics;
    }

    public idw.idwws.Ijreacic getIjreacics(int i) {
        return this.ijreacics[i];
    }

    public void setIjreacics(int i, idw.idwws.Ijreacic _value) {
        this.ijreacics[i] = _value;
    }


    /**
     * Gets the ijreacncs value for this Ijestmol.
     * 
     * @return ijreacncs
     */
    public idw.idwws.Ijreacnc[] getIjreacncs() {
        return ijreacncs;
    }


    /**
     * Sets the ijreacncs value for this Ijestmol.
     * 
     * @param ijreacncs
     */
    public void setIjreacncs(idw.idwws.Ijreacnc[] ijreacncs) {
        this.ijreacncs = ijreacncs;
    }

    public idw.idwws.Ijreacnc getIjreacncs(int i) {
        return this.ijreacncs[i];
    }

    public void setIjreacncs(int i, idw.idwws.Ijreacnc _value) {
        this.ijreacncs[i] = _value;
    }


    /**
     * Gets the ijreainspprods value for this Ijestmol.
     * 
     * @return ijreainspprods
     */
    public idw.idwws.Ijreainspprod[] getIjreainspprods() {
        return ijreainspprods;
    }


    /**
     * Sets the ijreainspprods value for this Ijestmol.
     * 
     * @param ijreainspprods
     */
    public void setIjreainspprods(idw.idwws.Ijreainspprod[] ijreainspprods) {
        this.ijreainspprods = ijreainspprods;
    }

    public idw.idwws.Ijreainspprod getIjreainspprods(int i) {
        return this.ijreainspprods[i];
    }

    public void setIjreainspprods(int i, idw.idwws.Ijreainspprod _value) {
        this.ijreainspprods[i] = _value;
    }


    /**
     * Gets the ijreajuscavs value for this Ijestmol.
     * 
     * @return ijreajuscavs
     */
    public idw.idwws.Ijreajuscav[] getIjreajuscavs() {
        return ijreajuscavs;
    }


    /**
     * Sets the ijreajuscavs value for this Ijestmol.
     * 
     * @param ijreajuscavs
     */
    public void setIjreajuscavs(idw.idwws.Ijreajuscav[] ijreajuscavs) {
        this.ijreajuscavs = ijreajuscavs;
    }

    public idw.idwws.Ijreajuscav getIjreajuscavs(int i) {
        return this.ijreajuscavs[i];
    }

    public void setIjreajuscavs(int i, idw.idwws.Ijreajuscav _value) {
        this.ijreajuscavs[i] = _value;
    }


    /**
     * Gets the ijreapars value for this Ijestmol.
     * 
     * @return ijreapars
     */
    public idw.idwws.Ijreapar[] getIjreapars() {
        return ijreapars;
    }


    /**
     * Sets the ijreapars value for this Ijestmol.
     * 
     * @param ijreapars
     */
    public void setIjreapars(idw.idwws.Ijreapar[] ijreapars) {
        this.ijreapars = ijreapars;
    }

    public idw.idwws.Ijreapar getIjreapars(int i) {
        return this.ijreapars[i];
    }

    public void setIjreapars(int i, idw.idwws.Ijreapar _value) {
        this.ijreapars[i] = _value;
    }


    /**
     * Gets the ijreareas value for this Ijestmol.
     * 
     * @return ijreareas
     */
    public idw.idwws.Ijrearea[] getIjreareas() {
        return ijreareas;
    }


    /**
     * Sets the ijreareas value for this Ijestmol.
     * 
     * @param ijreareas
     */
    public void setIjreareas(idw.idwws.Ijrearea[] ijreareas) {
        this.ijreareas = ijreareas;
    }

    public idw.idwws.Ijrearea getIjreareas(int i) {
        return this.ijreareas[i];
    }

    public void setIjreareas(int i, idw.idwws.Ijrearea _value) {
        this.ijreareas[i] = _value;
    }


    /**
     * Gets the ijrearefs value for this Ijestmol.
     * 
     * @return ijrearefs
     */
    public idw.idwws.Ijrearef[] getIjrearefs() {
        return ijrearefs;
    }


    /**
     * Sets the ijrearefs value for this Ijestmol.
     * 
     * @param ijrearefs
     */
    public void setIjrearefs(idw.idwws.Ijrearef[] ijrearefs) {
        this.ijrearefs = ijrearefs;
    }

    public idw.idwws.Ijrearef getIjrearefs(int i) {
        return this.ijrearefs[i];
    }

    public void setIjrearefs(int i, idw.idwws.Ijrearef _value) {
        this.ijrearefs[i] = _value;
    }


    /**
     * Gets the ijrefextras value for this Ijestmol.
     * 
     * @return ijrefextras
     */
    public idw.idwws.Ijrefextra[] getIjrefextras() {
        return ijrefextras;
    }


    /**
     * Sets the ijrefextras value for this Ijestmol.
     * 
     * @param ijrefextras
     */
    public void setIjrefextras(idw.idwws.Ijrefextra[] ijrefextras) {
        this.ijrefextras = ijrefextras;
    }

    public idw.idwws.Ijrefextra getIjrefextras(int i) {
        return this.ijrefextras[i];
    }

    public void setIjrefextras(int i, idw.idwws.Ijrefextra _value) {
        this.ijrefextras[i] = _value;
    }


    /**
     * Gets the ijtbinjultops value for this Ijestmol.
     * 
     * @return ijtbinjultops
     */
    public idw.idwws.Ijtbinjultop[] getIjtbinjultops() {
        return ijtbinjultops;
    }


    /**
     * Sets the ijtbinjultops value for this Ijestmol.
     * 
     * @param ijtbinjultops
     */
    public void setIjtbinjultops(idw.idwws.Ijtbinjultop[] ijtbinjultops) {
        this.ijtbinjultops = ijtbinjultops;
    }

    public idw.idwws.Ijtbinjultop getIjtbinjultops(int i) {
        return this.ijtbinjultops[i];
    }

    public void setIjtbinjultops(int i, idw.idwws.Ijtbinjultop _value) {
        this.ijtbinjultops[i] = _value;
    }


    /**
     * Gets the ijtbmol value for this Ijestmol.
     * 
     * @return ijtbmol
     */
    public idw.idwws.Ijtbmol getIjtbmol() {
        return ijtbmol;
    }


    /**
     * Sets the ijtbmol value for this Ijestmol.
     * 
     * @param ijtbmol
     */
    public void setIjtbmol(idw.idwws.Ijtbmol ijtbmol) {
        this.ijtbmol = ijtbmol;
    }


    /**
     * Gets the ijtmpsetupsForSysC0012982 value for this Ijestmol.
     * 
     * @return ijtmpsetupsForSysC0012982
     */
    public idw.idwws.Ijtmpsetup[] getIjtmpsetupsForSysC0012982() {
        return ijtmpsetupsForSysC0012982;
    }


    /**
     * Sets the ijtmpsetupsForSysC0012982 value for this Ijestmol.
     * 
     * @param ijtmpsetupsForSysC0012982
     */
    public void setIjtmpsetupsForSysC0012982(idw.idwws.Ijtmpsetup[] ijtmpsetupsForSysC0012982) {
        this.ijtmpsetupsForSysC0012982 = ijtmpsetupsForSysC0012982;
    }

    public idw.idwws.Ijtmpsetup getIjtmpsetupsForSysC0012982(int i) {
        return this.ijtmpsetupsForSysC0012982[i];
    }

    public void setIjtmpsetupsForSysC0012982(int i, idw.idwws.Ijtmpsetup _value) {
        this.ijtmpsetupsForSysC0012982[i] = _value;
    }


    /**
     * Gets the ijtmpsetupsForSysC0012983 value for this Ijestmol.
     * 
     * @return ijtmpsetupsForSysC0012983
     */
    public idw.idwws.Ijtmpsetup[] getIjtmpsetupsForSysC0012983() {
        return ijtmpsetupsForSysC0012983;
    }


    /**
     * Sets the ijtmpsetupsForSysC0012983 value for this Ijestmol.
     * 
     * @param ijtmpsetupsForSysC0012983
     */
    public void setIjtmpsetupsForSysC0012983(idw.idwws.Ijtmpsetup[] ijtmpsetupsForSysC0012983) {
        this.ijtmpsetupsForSysC0012983 = ijtmpsetupsForSysC0012983;
    }

    public idw.idwws.Ijtmpsetup getIjtmpsetupsForSysC0012983(int i) {
        return this.ijtmpsetupsForSysC0012983[i];
    }

    public void setIjtmpsetupsForSysC0012983(int i, idw.idwws.Ijtmpsetup _value) {
        this.ijtmpsetupsForSysC0012983[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijestmol)) return false;
        Ijestmol other = (Ijestmol) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.estruturaativa==null && other.getEstruturaativa()==null) || 
             (this.estruturaativa!=null &&
              this.estruturaativa.equals(other.getEstruturaativa()))) &&
            ((this.exportacao004S==null && other.getExportacao004S()==null) || 
             (this.exportacao004S!=null &&
              java.util.Arrays.equals(this.exportacao004S, other.getExportacao004S()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijacumpars==null && other.getIjacumpars()==null) || 
             (this.ijacumpars!=null &&
              java.util.Arrays.equals(this.ijacumpars, other.getIjacumpars()))) &&
            ((this.ijacumprods==null && other.getIjacumprods()==null) || 
             (this.ijacumprods!=null &&
              java.util.Arrays.equals(this.ijacumprods, other.getIjacumprods()))) &&
            ((this.ijacumrefs==null && other.getIjacumrefs()==null) || 
             (this.ijacumrefs!=null &&
              java.util.Arrays.equals(this.ijacumrefs, other.getIjacumrefs()))) &&
            ((this.ijalertasautos==null && other.getIjalertasautos()==null) || 
             (this.ijalertasautos!=null &&
              java.util.Arrays.equals(this.ijalertasautos, other.getIjalertasautos()))) &&
            ((this.ijalertases==null && other.getIjalertases()==null) || 
             (this.ijalertases!=null &&
              java.util.Arrays.equals(this.ijalertases, other.getIjalertases()))) &&
            ((this.ijcncturnos==null && other.getIjcncturnos()==null) || 
             (this.ijcncturnos!=null &&
              java.util.Arrays.equals(this.ijcncturnos, other.getIjcncturnos()))) &&
            ((this.ijctrliniprocprods==null && other.getIjctrliniprocprods()==null) || 
             (this.ijctrliniprocprods!=null &&
              java.util.Arrays.equals(this.ijctrliniprocprods, other.getIjctrliniprocprods()))) &&
            ((this.ijctrliniproctemps==null && other.getIjctrliniproctemps()==null) || 
             (this.ijctrliniproctemps!=null &&
              java.util.Arrays.equals(this.ijctrliniproctemps, other.getIjctrliniproctemps()))) &&
            ((this.ijctrliniproctrocasForSysC0013001==null && other.getIjctrliniproctrocasForSysC0013001()==null) || 
             (this.ijctrliniproctrocasForSysC0013001!=null &&
              java.util.Arrays.equals(this.ijctrliniproctrocasForSysC0013001, other.getIjctrliniproctrocasForSysC0013001()))) &&
            ((this.ijctrliniproctrocasForSysC0013002==null && other.getIjctrliniproctrocasForSysC0013002()==null) || 
             (this.ijctrliniproctrocasForSysC0013002!=null &&
              java.util.Arrays.equals(this.ijctrliniproctrocasForSysC0013002, other.getIjctrliniproctrocasForSysC0013002()))) &&
            ((this.ijengleituracicloses==null && other.getIjengleituracicloses()==null) || 
             (this.ijengleituracicloses!=null &&
              java.util.Arrays.equals(this.ijengleituracicloses, other.getIjengleituracicloses()))) &&
            ((this.ijenglogcicloses==null && other.getIjenglogcicloses()==null) || 
             (this.ijenglogcicloses!=null &&
              java.util.Arrays.equals(this.ijenglogcicloses, other.getIjenglogcicloses()))) &&
            ((this.ijficcncs==null && other.getIjficcncs()==null) || 
             (this.ijficcncs!=null &&
              java.util.Arrays.equals(this.ijficcncs, other.getIjficcncs()))) &&
            ((this.ijfictecconfigs==null && other.getIjfictecconfigs()==null) || 
             (this.ijfictecconfigs!=null &&
              java.util.Arrays.equals(this.ijfictecconfigs, other.getIjfictecconfigs()))) &&
            ((this.ijfictecs==null && other.getIjfictecs()==null) || 
             (this.ijfictecs!=null &&
              java.util.Arrays.equals(this.ijfictecs, other.getIjfictecs()))) &&
            ((this.ijlogopes==null && other.getIjlogopes()==null) || 
             (this.ijlogopes!=null &&
              java.util.Arrays.equals(this.ijlogopes, other.getIjlogopes()))) &&
            ((this.ijmolproautorizmods==null && other.getIjmolproautorizmods()==null) || 
             (this.ijmolproautorizmods!=null &&
              java.util.Arrays.equals(this.ijmolproautorizmods, other.getIjmolproautorizmods()))) &&
            ((this.ijmolpros==null && other.getIjmolpros()==null) || 
             (this.ijmolpros!=null &&
              java.util.Arrays.equals(this.ijmolpros, other.getIjmolpros()))) &&
            ((this.ijopprodutoses==null && other.getIjopprodutoses()==null) || 
             (this.ijopprodutoses!=null &&
              java.util.Arrays.equals(this.ijopprodutoses, other.getIjopprodutoses()))) &&
            ((this.ijoproteiros==null && other.getIjoproteiros()==null) || 
             (this.ijoproteiros!=null &&
              java.util.Arrays.equals(this.ijoproteiros, other.getIjoproteiros()))) &&
            ((this.ijops==null && other.getIjops()==null) || 
             (this.ijops!=null &&
              java.util.Arrays.equals(this.ijops, other.getIjops()))) &&
            ((this.ijplanops==null && other.getIjplanops()==null) || 
             (this.ijplanops!=null &&
              java.util.Arrays.equals(this.ijplanops, other.getIjplanops()))) &&
            ((this.ijpromolestpadraos==null && other.getIjpromolestpadraos()==null) || 
             (this.ijpromolestpadraos!=null &&
              java.util.Arrays.equals(this.ijpromolestpadraos, other.getIjpromolestpadraos()))) &&
            ((this.ijreacicops==null && other.getIjreacicops()==null) || 
             (this.ijreacicops!=null &&
              java.util.Arrays.equals(this.ijreacicops, other.getIjreacicops()))) &&
            ((this.ijreacics==null && other.getIjreacics()==null) || 
             (this.ijreacics!=null &&
              java.util.Arrays.equals(this.ijreacics, other.getIjreacics()))) &&
            ((this.ijreacncs==null && other.getIjreacncs()==null) || 
             (this.ijreacncs!=null &&
              java.util.Arrays.equals(this.ijreacncs, other.getIjreacncs()))) &&
            ((this.ijreainspprods==null && other.getIjreainspprods()==null) || 
             (this.ijreainspprods!=null &&
              java.util.Arrays.equals(this.ijreainspprods, other.getIjreainspprods()))) &&
            ((this.ijreajuscavs==null && other.getIjreajuscavs()==null) || 
             (this.ijreajuscavs!=null &&
              java.util.Arrays.equals(this.ijreajuscavs, other.getIjreajuscavs()))) &&
            ((this.ijreapars==null && other.getIjreapars()==null) || 
             (this.ijreapars!=null &&
              java.util.Arrays.equals(this.ijreapars, other.getIjreapars()))) &&
            ((this.ijreareas==null && other.getIjreareas()==null) || 
             (this.ijreareas!=null &&
              java.util.Arrays.equals(this.ijreareas, other.getIjreareas()))) &&
            ((this.ijrearefs==null && other.getIjrearefs()==null) || 
             (this.ijrearefs!=null &&
              java.util.Arrays.equals(this.ijrearefs, other.getIjrearefs()))) &&
            ((this.ijrefextras==null && other.getIjrefextras()==null) || 
             (this.ijrefextras!=null &&
              java.util.Arrays.equals(this.ijrefextras, other.getIjrefextras()))) &&
            ((this.ijtbinjultops==null && other.getIjtbinjultops()==null) || 
             (this.ijtbinjultops!=null &&
              java.util.Arrays.equals(this.ijtbinjultops, other.getIjtbinjultops()))) &&
            ((this.ijtbmol==null && other.getIjtbmol()==null) || 
             (this.ijtbmol!=null &&
              this.ijtbmol.equals(other.getIjtbmol()))) &&
            ((this.ijtmpsetupsForSysC0012982==null && other.getIjtmpsetupsForSysC0012982()==null) || 
             (this.ijtmpsetupsForSysC0012982!=null &&
              java.util.Arrays.equals(this.ijtmpsetupsForSysC0012982, other.getIjtmpsetupsForSysC0012982()))) &&
            ((this.ijtmpsetupsForSysC0012983==null && other.getIjtmpsetupsForSysC0012983()==null) || 
             (this.ijtmpsetupsForSysC0012983!=null &&
              java.util.Arrays.equals(this.ijtmpsetupsForSysC0012983, other.getIjtmpsetupsForSysC0012983())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getEstruturaativa() != null) {
            _hashCode += getEstruturaativa().hashCode();
        }
        if (getExportacao004S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao004S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao004S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjacumpars() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjacumpars());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjacumpars(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjacumprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjacumprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjacumprods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjacumrefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjacumrefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjacumrefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjalertasautos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjalertasautos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjalertasautos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjalertases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjalertases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjalertases(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjcncturnos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcncturnos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcncturnos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrliniprocprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrliniprocprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrliniprocprods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrliniproctemps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrliniproctemps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrliniproctemps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrliniproctrocasForSysC0013001() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrliniproctrocasForSysC0013001());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrliniproctrocasForSysC0013001(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrliniproctrocasForSysC0013002() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrliniproctrocasForSysC0013002());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrliniproctrocasForSysC0013002(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjengleituracicloses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjengleituracicloses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjengleituracicloses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjenglogcicloses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjenglogcicloses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjenglogcicloses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjficcncs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjficcncs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjficcncs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjfictecconfigs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfictecconfigs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfictecconfigs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjfictecs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfictecs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfictecs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjlogopes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjlogopes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjlogopes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmolproautorizmods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmolproautorizmods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmolproautorizmods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmolpros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmolpros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmolpros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopprodutoses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopprodutoses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopprodutoses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjoproteiros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjoproteiros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjoproteiros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjplanops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjplanops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjplanops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpromolestpadraos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpromolestpadraos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpromolestpadraos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreacicops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreacicops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreacicops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreacics() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreacics());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreacics(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreacncs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreacncs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreacncs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreainspprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreainspprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreainspprods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreajuscavs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreajuscavs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreajuscavs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreapars() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreapars());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreapars(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreareas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreareas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreareas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrearefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrearefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrearefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrefextras() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrefextras());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrefextras(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinjultops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbinjultops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbinjultops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmol() != null) {
            _hashCode += getIjtbmol().hashCode();
        }
        if (getIjtmpsetupsForSysC0012982() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtmpsetupsForSysC0012982());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtmpsetupsForSysC0012982(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtmpsetupsForSysC0012983() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtmpsetupsForSysC0012983());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtmpsetupsForSysC0012983(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijestmol.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estruturaativa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estruturaativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao004S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao004s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao004"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmolId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijacumpars");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijacumpars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijacumpar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijacumprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijacumprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijacumprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijacumrefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijacumrefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijacumref"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijalertasautos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijalertasautos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalertasauto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijalertases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijalertases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalertas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcncturnos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcncturnos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcncturno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrliniprocprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniprocprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniprocprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrliniproctemps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniproctemps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproctemp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrliniproctrocasForSysC0013001");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniproctrocasForSysC0013001"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproctroca"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrliniproctrocasForSysC0013002");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniproctrocasForSysC0013002"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproctroca"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijengleituracicloses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijengleituracicloses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijengleituraciclos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijenglogcicloses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijenglogcicloses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijenglogciclos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijficcncs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijficcncs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijficcnc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfictecconfigs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfictecconfigs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictecconfig"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfictecs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfictecs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijlogopes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijlogopes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijlogope"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolproautorizmods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolproautorizmods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproautorizmod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolpros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolpros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopprodutoses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopprodutoses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopprodutos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijoproteiros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoproteiros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoproteiro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijplanops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijplanops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijplanop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpromolestpadraos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpromolestpadraos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpromolestpadrao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreacicops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreacicops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacicop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreacics");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreacics"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacic"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreacncs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreacncs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacnc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreainspprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreainspprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreainspprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreajuscavs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreajuscavs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreajuscav"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreapars");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreareas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreareas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrearefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrearefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearef"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrefextras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrefextras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrefextra"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinjultops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinjultops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinjultop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtmpsetupsForSysC0012982");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtmpsetupsForSysC0012982"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtmpsetup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtmpsetupsForSysC0012983");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtmpsetupsForSysC0012983"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtmpsetup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
