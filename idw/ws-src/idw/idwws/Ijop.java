/**
 * Ijop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijop  implements java.io.Serializable {
    private java.util.Calendar dtentrega;

    private java.util.Calendar dthrfprevista;

    private java.util.Calendar dthriprevista;

    private java.util.Calendar dthrireal;

    private java.util.Calendar dthrpriciclo;

    private java.util.Calendar dthrsaida;

    private idw.idwws.Exportacao001[] exportacao001S;

    private idw.idwws.Exportacao002[] exportacao002S;

    private idw.idwws.Exportacao003[] exportacao003S;

    private idw.idwws.Exportacao004[] exportacao004S;

    private idw.idwws.Exportacao006[] exportacao006S;

    private idw.idwws.Ijacumpar[] ijacumpars;

    private idw.idwws.Ijacumprod[] ijacumprods;

    private idw.idwws.Ijacumref[] ijacumrefs;

    private idw.idwws.Ijalertasauto[] ijalertasautos;

    private idw.idwws.Ijcncop[] ijcncops;

    private idw.idwws.Ijcncturno[] ijcncturnos;

    private idw.idwws.Ijctrlcgq[] ijctrlcgqs;

    private idw.idwws.Ijctrliniprocprod[] ijctrliniprocprods;

    private idw.idwws.Ijctrliniproc[] ijctrliniprocs;

    private idw.idwws.Ijctrliniproctemp[] ijctrliniproctemps;

    private idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocas;

    private idw.idwws.Ijctrlresnegqld1[] ijctrlresnegqld1S;

    private idw.idwws.Ijctrlresnegqld2[] ijctrlresnegqld2S;

    private idw.idwws.Ijembapont[] ijembaponts;

    private idw.idwws.Ijentsaiopmaq[] ijentsaiopmaqs;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijetqfaixa[] ijetqfaixas;

    private idw.idwws.Ijetqproduto[] ijetqprodutos;

    private idw.idwws.Ijfreqmanutprevop[] ijfreqmanutprevops;

    private idw.idwws.Ijiniopinj[] ijiniopinjs;

    private idw.idwws.Ijinspecao[] ijinspecaos;

    private idw.idwws.Ijkanbanlote[] ijkanbanlotes;

    private idw.idwws.Ijmdoalocop[] ijmdoalocops;

    private idw.idwws.Ijmovpostos[] ijmovpostoses;

    private idw.idwws.Ijocorreploteins[] ijocorreploteinses;

    private idw.idwws.Ijocorvarritmo[] ijocorvarritmos;

    private idw.idwws.Ijopagrupada[] ijopagrupadas;

    private idw.idwws.Ijopagrup[] ijopagrups;

    private idw.idwws.Ijopbloq[] ijopbloqs;

    private idw.idwws.Ijopcgq[] ijopcgqs;

    private idw.idwws.Ijopintrasa[] ijopintrasas;

    private idw.idwws.Ijoplotefab[] ijoplotefabs;

    private idw.idwws.Ijoplotes[] ijoploteses;

    private idw.idwws.Ijopmprima[] ijopmprimas;

    private idw.idwws.Ijopopermaq[] ijopopermaqs;

    private idw.idwws.Ijoppmedioprod[] ijoppmedioprods;

    private idw.idwws.Ijopprodutos[] ijopprodutoses;

    private idw.idwws.Ijopproqtope[] ijopproqtopes;

    private idw.idwws.Ijoproteiro[] ijoproteiros;

    private idw.idwws.Ijoprotoper[] ijoprotopers;

    private idw.idwws.Ijopsagrupprod[] ijopsagrupprods;

    private idw.idwws.Ijopversaopro[] ijopversaopros;

    private idw.idwws.Ijplano ijplano;

    private idw.idwws.Ijplanop[] ijplanops;

    private idw.idwws.Ijproultop[] ijproultops;

    private idw.idwws.Ijqldinspecao[] ijqldinspecaos;

    private idw.idwws.Ijqldprodinsplote[] ijqldprodinsplotes;

    private idw.idwws.Ijreacicop[] ijreacicops;

    private idw.idwws.Ijreacic[] ijreacics;

    private idw.idwws.Ijreainspprod[] ijreainspprods;

    private idw.idwws.Ijreapar[] ijreapars;

    private idw.idwws.Ijreapeso[] ijreapesos;

    private idw.idwws.Ijrearea[] ijreareas;

    private idw.idwws.Ijrefextra[] ijrefextras;

    private idw.idwws.Ijrefman[] ijrefmans;

    private idw.idwws.Ijregultinspqld1[] ijregultinspqld1S;

    private idw.idwws.Ijregultinspqld2[] ijregultinspqld2S;

    private idw.idwws.Ijregultocorop[] ijregultocorops;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbinjultop[] ijtbinjultops;

    private idw.idwws.Ijtbstop ijtbstop;

    private idw.idwws.Ijtmpsetup[] ijtmpsetupsForNropentrada;

    private idw.idwws.Ijtmpsetup[] ijtmpsetupsForNropsaida;

    private idw.idwws.Ijtmpultst[] ijtmpultsts;

    private java.lang.String nrop;

    private java.lang.String nropcoorp;

    private java.lang.String nropestendido;

    private double nrseq;

    private java.math.BigDecimal numsmnentrega;

    private org.apache.axis.types.UnsignedShort opcritica;

    private double toleranciaplano;

    private org.apache.axis.types.UnsignedShort tpacabamento;

    private org.apache.axis.types.UnsignedShort tpordemproducao;

    public Ijop() {
    }

    public Ijop(
           java.util.Calendar dtentrega,
           java.util.Calendar dthrfprevista,
           java.util.Calendar dthriprevista,
           java.util.Calendar dthrireal,
           java.util.Calendar dthrpriciclo,
           java.util.Calendar dthrsaida,
           idw.idwws.Exportacao001[] exportacao001S,
           idw.idwws.Exportacao002[] exportacao002S,
           idw.idwws.Exportacao003[] exportacao003S,
           idw.idwws.Exportacao004[] exportacao004S,
           idw.idwws.Exportacao006[] exportacao006S,
           idw.idwws.Ijacumpar[] ijacumpars,
           idw.idwws.Ijacumprod[] ijacumprods,
           idw.idwws.Ijacumref[] ijacumrefs,
           idw.idwws.Ijalertasauto[] ijalertasautos,
           idw.idwws.Ijcncop[] ijcncops,
           idw.idwws.Ijcncturno[] ijcncturnos,
           idw.idwws.Ijctrlcgq[] ijctrlcgqs,
           idw.idwws.Ijctrliniprocprod[] ijctrliniprocprods,
           idw.idwws.Ijctrliniproc[] ijctrliniprocs,
           idw.idwws.Ijctrliniproctemp[] ijctrliniproctemps,
           idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocas,
           idw.idwws.Ijctrlresnegqld1[] ijctrlresnegqld1S,
           idw.idwws.Ijctrlresnegqld2[] ijctrlresnegqld2S,
           idw.idwws.Ijembapont[] ijembaponts,
           idw.idwws.Ijentsaiopmaq[] ijentsaiopmaqs,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijetqfaixa[] ijetqfaixas,
           idw.idwws.Ijetqproduto[] ijetqprodutos,
           idw.idwws.Ijfreqmanutprevop[] ijfreqmanutprevops,
           idw.idwws.Ijiniopinj[] ijiniopinjs,
           idw.idwws.Ijinspecao[] ijinspecaos,
           idw.idwws.Ijkanbanlote[] ijkanbanlotes,
           idw.idwws.Ijmdoalocop[] ijmdoalocops,
           idw.idwws.Ijmovpostos[] ijmovpostoses,
           idw.idwws.Ijocorreploteins[] ijocorreploteinses,
           idw.idwws.Ijocorvarritmo[] ijocorvarritmos,
           idw.idwws.Ijopagrupada[] ijopagrupadas,
           idw.idwws.Ijopagrup[] ijopagrups,
           idw.idwws.Ijopbloq[] ijopbloqs,
           idw.idwws.Ijopcgq[] ijopcgqs,
           idw.idwws.Ijopintrasa[] ijopintrasas,
           idw.idwws.Ijoplotefab[] ijoplotefabs,
           idw.idwws.Ijoplotes[] ijoploteses,
           idw.idwws.Ijopmprima[] ijopmprimas,
           idw.idwws.Ijopopermaq[] ijopopermaqs,
           idw.idwws.Ijoppmedioprod[] ijoppmedioprods,
           idw.idwws.Ijopprodutos[] ijopprodutoses,
           idw.idwws.Ijopproqtope[] ijopproqtopes,
           idw.idwws.Ijoproteiro[] ijoproteiros,
           idw.idwws.Ijoprotoper[] ijoprotopers,
           idw.idwws.Ijopsagrupprod[] ijopsagrupprods,
           idw.idwws.Ijopversaopro[] ijopversaopros,
           idw.idwws.Ijplano ijplano,
           idw.idwws.Ijplanop[] ijplanops,
           idw.idwws.Ijproultop[] ijproultops,
           idw.idwws.Ijqldinspecao[] ijqldinspecaos,
           idw.idwws.Ijqldprodinsplote[] ijqldprodinsplotes,
           idw.idwws.Ijreacicop[] ijreacicops,
           idw.idwws.Ijreacic[] ijreacics,
           idw.idwws.Ijreainspprod[] ijreainspprods,
           idw.idwws.Ijreapar[] ijreapars,
           idw.idwws.Ijreapeso[] ijreapesos,
           idw.idwws.Ijrearea[] ijreareas,
           idw.idwws.Ijrefextra[] ijrefextras,
           idw.idwws.Ijrefman[] ijrefmans,
           idw.idwws.Ijregultinspqld1[] ijregultinspqld1S,
           idw.idwws.Ijregultinspqld2[] ijregultinspqld2S,
           idw.idwws.Ijregultocorop[] ijregultocorops,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbinjultop[] ijtbinjultops,
           idw.idwws.Ijtbstop ijtbstop,
           idw.idwws.Ijtmpsetup[] ijtmpsetupsForNropentrada,
           idw.idwws.Ijtmpsetup[] ijtmpsetupsForNropsaida,
           idw.idwws.Ijtmpultst[] ijtmpultsts,
           java.lang.String nrop,
           java.lang.String nropcoorp,
           java.lang.String nropestendido,
           double nrseq,
           java.math.BigDecimal numsmnentrega,
           org.apache.axis.types.UnsignedShort opcritica,
           double toleranciaplano,
           org.apache.axis.types.UnsignedShort tpacabamento,
           org.apache.axis.types.UnsignedShort tpordemproducao) {
           this.dtentrega = dtentrega;
           this.dthrfprevista = dthrfprevista;
           this.dthriprevista = dthriprevista;
           this.dthrireal = dthrireal;
           this.dthrpriciclo = dthrpriciclo;
           this.dthrsaida = dthrsaida;
           this.exportacao001S = exportacao001S;
           this.exportacao002S = exportacao002S;
           this.exportacao003S = exportacao003S;
           this.exportacao004S = exportacao004S;
           this.exportacao006S = exportacao006S;
           this.ijacumpars = ijacumpars;
           this.ijacumprods = ijacumprods;
           this.ijacumrefs = ijacumrefs;
           this.ijalertasautos = ijalertasautos;
           this.ijcncops = ijcncops;
           this.ijcncturnos = ijcncturnos;
           this.ijctrlcgqs = ijctrlcgqs;
           this.ijctrliniprocprods = ijctrliniprocprods;
           this.ijctrliniprocs = ijctrliniprocs;
           this.ijctrliniproctemps = ijctrliniproctemps;
           this.ijctrliniproctrocas = ijctrliniproctrocas;
           this.ijctrlresnegqld1S = ijctrlresnegqld1S;
           this.ijctrlresnegqld2S = ijctrlresnegqld2S;
           this.ijembaponts = ijembaponts;
           this.ijentsaiopmaqs = ijentsaiopmaqs;
           this.ijestmol = ijestmol;
           this.ijetqfaixas = ijetqfaixas;
           this.ijetqprodutos = ijetqprodutos;
           this.ijfreqmanutprevops = ijfreqmanutprevops;
           this.ijiniopinjs = ijiniopinjs;
           this.ijinspecaos = ijinspecaos;
           this.ijkanbanlotes = ijkanbanlotes;
           this.ijmdoalocops = ijmdoalocops;
           this.ijmovpostoses = ijmovpostoses;
           this.ijocorreploteinses = ijocorreploteinses;
           this.ijocorvarritmos = ijocorvarritmos;
           this.ijopagrupadas = ijopagrupadas;
           this.ijopagrups = ijopagrups;
           this.ijopbloqs = ijopbloqs;
           this.ijopcgqs = ijopcgqs;
           this.ijopintrasas = ijopintrasas;
           this.ijoplotefabs = ijoplotefabs;
           this.ijoploteses = ijoploteses;
           this.ijopmprimas = ijopmprimas;
           this.ijopopermaqs = ijopopermaqs;
           this.ijoppmedioprods = ijoppmedioprods;
           this.ijopprodutoses = ijopprodutoses;
           this.ijopproqtopes = ijopproqtopes;
           this.ijoproteiros = ijoproteiros;
           this.ijoprotopers = ijoprotopers;
           this.ijopsagrupprods = ijopsagrupprods;
           this.ijopversaopros = ijopversaopros;
           this.ijplano = ijplano;
           this.ijplanops = ijplanops;
           this.ijproultops = ijproultops;
           this.ijqldinspecaos = ijqldinspecaos;
           this.ijqldprodinsplotes = ijqldprodinsplotes;
           this.ijreacicops = ijreacicops;
           this.ijreacics = ijreacics;
           this.ijreainspprods = ijreainspprods;
           this.ijreapars = ijreapars;
           this.ijreapesos = ijreapesos;
           this.ijreareas = ijreareas;
           this.ijrefextras = ijrefextras;
           this.ijrefmans = ijrefmans;
           this.ijregultinspqld1S = ijregultinspqld1S;
           this.ijregultinspqld2S = ijregultinspqld2S;
           this.ijregultocorops = ijregultocorops;
           this.ijtbinj = ijtbinj;
           this.ijtbinjultops = ijtbinjultops;
           this.ijtbstop = ijtbstop;
           this.ijtmpsetupsForNropentrada = ijtmpsetupsForNropentrada;
           this.ijtmpsetupsForNropsaida = ijtmpsetupsForNropsaida;
           this.ijtmpultsts = ijtmpultsts;
           this.nrop = nrop;
           this.nropcoorp = nropcoorp;
           this.nropestendido = nropestendido;
           this.nrseq = nrseq;
           this.numsmnentrega = numsmnentrega;
           this.opcritica = opcritica;
           this.toleranciaplano = toleranciaplano;
           this.tpacabamento = tpacabamento;
           this.tpordemproducao = tpordemproducao;
    }


    /**
     * Gets the dtentrega value for this Ijop.
     * 
     * @return dtentrega
     */
    public java.util.Calendar getDtentrega() {
        return dtentrega;
    }


    /**
     * Sets the dtentrega value for this Ijop.
     * 
     * @param dtentrega
     */
    public void setDtentrega(java.util.Calendar dtentrega) {
        this.dtentrega = dtentrega;
    }


    /**
     * Gets the dthrfprevista value for this Ijop.
     * 
     * @return dthrfprevista
     */
    public java.util.Calendar getDthrfprevista() {
        return dthrfprevista;
    }


    /**
     * Sets the dthrfprevista value for this Ijop.
     * 
     * @param dthrfprevista
     */
    public void setDthrfprevista(java.util.Calendar dthrfprevista) {
        this.dthrfprevista = dthrfprevista;
    }


    /**
     * Gets the dthriprevista value for this Ijop.
     * 
     * @return dthriprevista
     */
    public java.util.Calendar getDthriprevista() {
        return dthriprevista;
    }


    /**
     * Sets the dthriprevista value for this Ijop.
     * 
     * @param dthriprevista
     */
    public void setDthriprevista(java.util.Calendar dthriprevista) {
        this.dthriprevista = dthriprevista;
    }


    /**
     * Gets the dthrireal value for this Ijop.
     * 
     * @return dthrireal
     */
    public java.util.Calendar getDthrireal() {
        return dthrireal;
    }


    /**
     * Sets the dthrireal value for this Ijop.
     * 
     * @param dthrireal
     */
    public void setDthrireal(java.util.Calendar dthrireal) {
        this.dthrireal = dthrireal;
    }


    /**
     * Gets the dthrpriciclo value for this Ijop.
     * 
     * @return dthrpriciclo
     */
    public java.util.Calendar getDthrpriciclo() {
        return dthrpriciclo;
    }


    /**
     * Sets the dthrpriciclo value for this Ijop.
     * 
     * @param dthrpriciclo
     */
    public void setDthrpriciclo(java.util.Calendar dthrpriciclo) {
        this.dthrpriciclo = dthrpriciclo;
    }


    /**
     * Gets the dthrsaida value for this Ijop.
     * 
     * @return dthrsaida
     */
    public java.util.Calendar getDthrsaida() {
        return dthrsaida;
    }


    /**
     * Sets the dthrsaida value for this Ijop.
     * 
     * @param dthrsaida
     */
    public void setDthrsaida(java.util.Calendar dthrsaida) {
        this.dthrsaida = dthrsaida;
    }


    /**
     * Gets the exportacao001S value for this Ijop.
     * 
     * @return exportacao001S
     */
    public idw.idwws.Exportacao001[] getExportacao001S() {
        return exportacao001S;
    }


    /**
     * Sets the exportacao001S value for this Ijop.
     * 
     * @param exportacao001S
     */
    public void setExportacao001S(idw.idwws.Exportacao001[] exportacao001S) {
        this.exportacao001S = exportacao001S;
    }

    public idw.idwws.Exportacao001 getExportacao001S(int i) {
        return this.exportacao001S[i];
    }

    public void setExportacao001S(int i, idw.idwws.Exportacao001 _value) {
        this.exportacao001S[i] = _value;
    }


    /**
     * Gets the exportacao002S value for this Ijop.
     * 
     * @return exportacao002S
     */
    public idw.idwws.Exportacao002[] getExportacao002S() {
        return exportacao002S;
    }


    /**
     * Sets the exportacao002S value for this Ijop.
     * 
     * @param exportacao002S
     */
    public void setExportacao002S(idw.idwws.Exportacao002[] exportacao002S) {
        this.exportacao002S = exportacao002S;
    }

    public idw.idwws.Exportacao002 getExportacao002S(int i) {
        return this.exportacao002S[i];
    }

    public void setExportacao002S(int i, idw.idwws.Exportacao002 _value) {
        this.exportacao002S[i] = _value;
    }


    /**
     * Gets the exportacao003S value for this Ijop.
     * 
     * @return exportacao003S
     */
    public idw.idwws.Exportacao003[] getExportacao003S() {
        return exportacao003S;
    }


    /**
     * Sets the exportacao003S value for this Ijop.
     * 
     * @param exportacao003S
     */
    public void setExportacao003S(idw.idwws.Exportacao003[] exportacao003S) {
        this.exportacao003S = exportacao003S;
    }

    public idw.idwws.Exportacao003 getExportacao003S(int i) {
        return this.exportacao003S[i];
    }

    public void setExportacao003S(int i, idw.idwws.Exportacao003 _value) {
        this.exportacao003S[i] = _value;
    }


    /**
     * Gets the exportacao004S value for this Ijop.
     * 
     * @return exportacao004S
     */
    public idw.idwws.Exportacao004[] getExportacao004S() {
        return exportacao004S;
    }


    /**
     * Sets the exportacao004S value for this Ijop.
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
     * Gets the exportacao006S value for this Ijop.
     * 
     * @return exportacao006S
     */
    public idw.idwws.Exportacao006[] getExportacao006S() {
        return exportacao006S;
    }


    /**
     * Sets the exportacao006S value for this Ijop.
     * 
     * @param exportacao006S
     */
    public void setExportacao006S(idw.idwws.Exportacao006[] exportacao006S) {
        this.exportacao006S = exportacao006S;
    }

    public idw.idwws.Exportacao006 getExportacao006S(int i) {
        return this.exportacao006S[i];
    }

    public void setExportacao006S(int i, idw.idwws.Exportacao006 _value) {
        this.exportacao006S[i] = _value;
    }


    /**
     * Gets the ijacumpars value for this Ijop.
     * 
     * @return ijacumpars
     */
    public idw.idwws.Ijacumpar[] getIjacumpars() {
        return ijacumpars;
    }


    /**
     * Sets the ijacumpars value for this Ijop.
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
     * Gets the ijacumprods value for this Ijop.
     * 
     * @return ijacumprods
     */
    public idw.idwws.Ijacumprod[] getIjacumprods() {
        return ijacumprods;
    }


    /**
     * Sets the ijacumprods value for this Ijop.
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
     * Gets the ijacumrefs value for this Ijop.
     * 
     * @return ijacumrefs
     */
    public idw.idwws.Ijacumref[] getIjacumrefs() {
        return ijacumrefs;
    }


    /**
     * Sets the ijacumrefs value for this Ijop.
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
     * Gets the ijalertasautos value for this Ijop.
     * 
     * @return ijalertasautos
     */
    public idw.idwws.Ijalertasauto[] getIjalertasautos() {
        return ijalertasautos;
    }


    /**
     * Sets the ijalertasautos value for this Ijop.
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
     * Gets the ijcncops value for this Ijop.
     * 
     * @return ijcncops
     */
    public idw.idwws.Ijcncop[] getIjcncops() {
        return ijcncops;
    }


    /**
     * Sets the ijcncops value for this Ijop.
     * 
     * @param ijcncops
     */
    public void setIjcncops(idw.idwws.Ijcncop[] ijcncops) {
        this.ijcncops = ijcncops;
    }

    public idw.idwws.Ijcncop getIjcncops(int i) {
        return this.ijcncops[i];
    }

    public void setIjcncops(int i, idw.idwws.Ijcncop _value) {
        this.ijcncops[i] = _value;
    }


    /**
     * Gets the ijcncturnos value for this Ijop.
     * 
     * @return ijcncturnos
     */
    public idw.idwws.Ijcncturno[] getIjcncturnos() {
        return ijcncturnos;
    }


    /**
     * Sets the ijcncturnos value for this Ijop.
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
     * Gets the ijctrlcgqs value for this Ijop.
     * 
     * @return ijctrlcgqs
     */
    public idw.idwws.Ijctrlcgq[] getIjctrlcgqs() {
        return ijctrlcgqs;
    }


    /**
     * Sets the ijctrlcgqs value for this Ijop.
     * 
     * @param ijctrlcgqs
     */
    public void setIjctrlcgqs(idw.idwws.Ijctrlcgq[] ijctrlcgqs) {
        this.ijctrlcgqs = ijctrlcgqs;
    }

    public idw.idwws.Ijctrlcgq getIjctrlcgqs(int i) {
        return this.ijctrlcgqs[i];
    }

    public void setIjctrlcgqs(int i, idw.idwws.Ijctrlcgq _value) {
        this.ijctrlcgqs[i] = _value;
    }


    /**
     * Gets the ijctrliniprocprods value for this Ijop.
     * 
     * @return ijctrliniprocprods
     */
    public idw.idwws.Ijctrliniprocprod[] getIjctrliniprocprods() {
        return ijctrliniprocprods;
    }


    /**
     * Sets the ijctrliniprocprods value for this Ijop.
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
     * Gets the ijctrliniprocs value for this Ijop.
     * 
     * @return ijctrliniprocs
     */
    public idw.idwws.Ijctrliniproc[] getIjctrliniprocs() {
        return ijctrliniprocs;
    }


    /**
     * Sets the ijctrliniprocs value for this Ijop.
     * 
     * @param ijctrliniprocs
     */
    public void setIjctrliniprocs(idw.idwws.Ijctrliniproc[] ijctrliniprocs) {
        this.ijctrliniprocs = ijctrliniprocs;
    }

    public idw.idwws.Ijctrliniproc getIjctrliniprocs(int i) {
        return this.ijctrliniprocs[i];
    }

    public void setIjctrliniprocs(int i, idw.idwws.Ijctrliniproc _value) {
        this.ijctrliniprocs[i] = _value;
    }


    /**
     * Gets the ijctrliniproctemps value for this Ijop.
     * 
     * @return ijctrliniproctemps
     */
    public idw.idwws.Ijctrliniproctemp[] getIjctrliniproctemps() {
        return ijctrliniproctemps;
    }


    /**
     * Sets the ijctrliniproctemps value for this Ijop.
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
     * Gets the ijctrliniproctrocas value for this Ijop.
     * 
     * @return ijctrliniproctrocas
     */
    public idw.idwws.Ijctrliniproctroca[] getIjctrliniproctrocas() {
        return ijctrliniproctrocas;
    }


    /**
     * Sets the ijctrliniproctrocas value for this Ijop.
     * 
     * @param ijctrliniproctrocas
     */
    public void setIjctrliniproctrocas(idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocas) {
        this.ijctrliniproctrocas = ijctrliniproctrocas;
    }

    public idw.idwws.Ijctrliniproctroca getIjctrliniproctrocas(int i) {
        return this.ijctrliniproctrocas[i];
    }

    public void setIjctrliniproctrocas(int i, idw.idwws.Ijctrliniproctroca _value) {
        this.ijctrliniproctrocas[i] = _value;
    }


    /**
     * Gets the ijctrlresnegqld1S value for this Ijop.
     * 
     * @return ijctrlresnegqld1S
     */
    public idw.idwws.Ijctrlresnegqld1[] getIjctrlresnegqld1S() {
        return ijctrlresnegqld1S;
    }


    /**
     * Sets the ijctrlresnegqld1S value for this Ijop.
     * 
     * @param ijctrlresnegqld1S
     */
    public void setIjctrlresnegqld1S(idw.idwws.Ijctrlresnegqld1[] ijctrlresnegqld1S) {
        this.ijctrlresnegqld1S = ijctrlresnegqld1S;
    }

    public idw.idwws.Ijctrlresnegqld1 getIjctrlresnegqld1S(int i) {
        return this.ijctrlresnegqld1S[i];
    }

    public void setIjctrlresnegqld1S(int i, idw.idwws.Ijctrlresnegqld1 _value) {
        this.ijctrlresnegqld1S[i] = _value;
    }


    /**
     * Gets the ijctrlresnegqld2S value for this Ijop.
     * 
     * @return ijctrlresnegqld2S
     */
    public idw.idwws.Ijctrlresnegqld2[] getIjctrlresnegqld2S() {
        return ijctrlresnegqld2S;
    }


    /**
     * Sets the ijctrlresnegqld2S value for this Ijop.
     * 
     * @param ijctrlresnegqld2S
     */
    public void setIjctrlresnegqld2S(idw.idwws.Ijctrlresnegqld2[] ijctrlresnegqld2S) {
        this.ijctrlresnegqld2S = ijctrlresnegqld2S;
    }

    public idw.idwws.Ijctrlresnegqld2 getIjctrlresnegqld2S(int i) {
        return this.ijctrlresnegqld2S[i];
    }

    public void setIjctrlresnegqld2S(int i, idw.idwws.Ijctrlresnegqld2 _value) {
        this.ijctrlresnegqld2S[i] = _value;
    }


    /**
     * Gets the ijembaponts value for this Ijop.
     * 
     * @return ijembaponts
     */
    public idw.idwws.Ijembapont[] getIjembaponts() {
        return ijembaponts;
    }


    /**
     * Sets the ijembaponts value for this Ijop.
     * 
     * @param ijembaponts
     */
    public void setIjembaponts(idw.idwws.Ijembapont[] ijembaponts) {
        this.ijembaponts = ijembaponts;
    }

    public idw.idwws.Ijembapont getIjembaponts(int i) {
        return this.ijembaponts[i];
    }

    public void setIjembaponts(int i, idw.idwws.Ijembapont _value) {
        this.ijembaponts[i] = _value;
    }


    /**
     * Gets the ijentsaiopmaqs value for this Ijop.
     * 
     * @return ijentsaiopmaqs
     */
    public idw.idwws.Ijentsaiopmaq[] getIjentsaiopmaqs() {
        return ijentsaiopmaqs;
    }


    /**
     * Sets the ijentsaiopmaqs value for this Ijop.
     * 
     * @param ijentsaiopmaqs
     */
    public void setIjentsaiopmaqs(idw.idwws.Ijentsaiopmaq[] ijentsaiopmaqs) {
        this.ijentsaiopmaqs = ijentsaiopmaqs;
    }

    public idw.idwws.Ijentsaiopmaq getIjentsaiopmaqs(int i) {
        return this.ijentsaiopmaqs[i];
    }

    public void setIjentsaiopmaqs(int i, idw.idwws.Ijentsaiopmaq _value) {
        this.ijentsaiopmaqs[i] = _value;
    }


    /**
     * Gets the ijestmol value for this Ijop.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijop.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijetqfaixas value for this Ijop.
     * 
     * @return ijetqfaixas
     */
    public idw.idwws.Ijetqfaixa[] getIjetqfaixas() {
        return ijetqfaixas;
    }


    /**
     * Sets the ijetqfaixas value for this Ijop.
     * 
     * @param ijetqfaixas
     */
    public void setIjetqfaixas(idw.idwws.Ijetqfaixa[] ijetqfaixas) {
        this.ijetqfaixas = ijetqfaixas;
    }

    public idw.idwws.Ijetqfaixa getIjetqfaixas(int i) {
        return this.ijetqfaixas[i];
    }

    public void setIjetqfaixas(int i, idw.idwws.Ijetqfaixa _value) {
        this.ijetqfaixas[i] = _value;
    }


    /**
     * Gets the ijetqprodutos value for this Ijop.
     * 
     * @return ijetqprodutos
     */
    public idw.idwws.Ijetqproduto[] getIjetqprodutos() {
        return ijetqprodutos;
    }


    /**
     * Sets the ijetqprodutos value for this Ijop.
     * 
     * @param ijetqprodutos
     */
    public void setIjetqprodutos(idw.idwws.Ijetqproduto[] ijetqprodutos) {
        this.ijetqprodutos = ijetqprodutos;
    }

    public idw.idwws.Ijetqproduto getIjetqprodutos(int i) {
        return this.ijetqprodutos[i];
    }

    public void setIjetqprodutos(int i, idw.idwws.Ijetqproduto _value) {
        this.ijetqprodutos[i] = _value;
    }


    /**
     * Gets the ijfreqmanutprevops value for this Ijop.
     * 
     * @return ijfreqmanutprevops
     */
    public idw.idwws.Ijfreqmanutprevop[] getIjfreqmanutprevops() {
        return ijfreqmanutprevops;
    }


    /**
     * Sets the ijfreqmanutprevops value for this Ijop.
     * 
     * @param ijfreqmanutprevops
     */
    public void setIjfreqmanutprevops(idw.idwws.Ijfreqmanutprevop[] ijfreqmanutprevops) {
        this.ijfreqmanutprevops = ijfreqmanutprevops;
    }

    public idw.idwws.Ijfreqmanutprevop getIjfreqmanutprevops(int i) {
        return this.ijfreqmanutprevops[i];
    }

    public void setIjfreqmanutprevops(int i, idw.idwws.Ijfreqmanutprevop _value) {
        this.ijfreqmanutprevops[i] = _value;
    }


    /**
     * Gets the ijiniopinjs value for this Ijop.
     * 
     * @return ijiniopinjs
     */
    public idw.idwws.Ijiniopinj[] getIjiniopinjs() {
        return ijiniopinjs;
    }


    /**
     * Sets the ijiniopinjs value for this Ijop.
     * 
     * @param ijiniopinjs
     */
    public void setIjiniopinjs(idw.idwws.Ijiniopinj[] ijiniopinjs) {
        this.ijiniopinjs = ijiniopinjs;
    }

    public idw.idwws.Ijiniopinj getIjiniopinjs(int i) {
        return this.ijiniopinjs[i];
    }

    public void setIjiniopinjs(int i, idw.idwws.Ijiniopinj _value) {
        this.ijiniopinjs[i] = _value;
    }


    /**
     * Gets the ijinspecaos value for this Ijop.
     * 
     * @return ijinspecaos
     */
    public idw.idwws.Ijinspecao[] getIjinspecaos() {
        return ijinspecaos;
    }


    /**
     * Sets the ijinspecaos value for this Ijop.
     * 
     * @param ijinspecaos
     */
    public void setIjinspecaos(idw.idwws.Ijinspecao[] ijinspecaos) {
        this.ijinspecaos = ijinspecaos;
    }

    public idw.idwws.Ijinspecao getIjinspecaos(int i) {
        return this.ijinspecaos[i];
    }

    public void setIjinspecaos(int i, idw.idwws.Ijinspecao _value) {
        this.ijinspecaos[i] = _value;
    }


    /**
     * Gets the ijkanbanlotes value for this Ijop.
     * 
     * @return ijkanbanlotes
     */
    public idw.idwws.Ijkanbanlote[] getIjkanbanlotes() {
        return ijkanbanlotes;
    }


    /**
     * Sets the ijkanbanlotes value for this Ijop.
     * 
     * @param ijkanbanlotes
     */
    public void setIjkanbanlotes(idw.idwws.Ijkanbanlote[] ijkanbanlotes) {
        this.ijkanbanlotes = ijkanbanlotes;
    }

    public idw.idwws.Ijkanbanlote getIjkanbanlotes(int i) {
        return this.ijkanbanlotes[i];
    }

    public void setIjkanbanlotes(int i, idw.idwws.Ijkanbanlote _value) {
        this.ijkanbanlotes[i] = _value;
    }


    /**
     * Gets the ijmdoalocops value for this Ijop.
     * 
     * @return ijmdoalocops
     */
    public idw.idwws.Ijmdoalocop[] getIjmdoalocops() {
        return ijmdoalocops;
    }


    /**
     * Sets the ijmdoalocops value for this Ijop.
     * 
     * @param ijmdoalocops
     */
    public void setIjmdoalocops(idw.idwws.Ijmdoalocop[] ijmdoalocops) {
        this.ijmdoalocops = ijmdoalocops;
    }

    public idw.idwws.Ijmdoalocop getIjmdoalocops(int i) {
        return this.ijmdoalocops[i];
    }

    public void setIjmdoalocops(int i, idw.idwws.Ijmdoalocop _value) {
        this.ijmdoalocops[i] = _value;
    }


    /**
     * Gets the ijmovpostoses value for this Ijop.
     * 
     * @return ijmovpostoses
     */
    public idw.idwws.Ijmovpostos[] getIjmovpostoses() {
        return ijmovpostoses;
    }


    /**
     * Sets the ijmovpostoses value for this Ijop.
     * 
     * @param ijmovpostoses
     */
    public void setIjmovpostoses(idw.idwws.Ijmovpostos[] ijmovpostoses) {
        this.ijmovpostoses = ijmovpostoses;
    }

    public idw.idwws.Ijmovpostos getIjmovpostoses(int i) {
        return this.ijmovpostoses[i];
    }

    public void setIjmovpostoses(int i, idw.idwws.Ijmovpostos _value) {
        this.ijmovpostoses[i] = _value;
    }


    /**
     * Gets the ijocorreploteinses value for this Ijop.
     * 
     * @return ijocorreploteinses
     */
    public idw.idwws.Ijocorreploteins[] getIjocorreploteinses() {
        return ijocorreploteinses;
    }


    /**
     * Sets the ijocorreploteinses value for this Ijop.
     * 
     * @param ijocorreploteinses
     */
    public void setIjocorreploteinses(idw.idwws.Ijocorreploteins[] ijocorreploteinses) {
        this.ijocorreploteinses = ijocorreploteinses;
    }

    public idw.idwws.Ijocorreploteins getIjocorreploteinses(int i) {
        return this.ijocorreploteinses[i];
    }

    public void setIjocorreploteinses(int i, idw.idwws.Ijocorreploteins _value) {
        this.ijocorreploteinses[i] = _value;
    }


    /**
     * Gets the ijocorvarritmos value for this Ijop.
     * 
     * @return ijocorvarritmos
     */
    public idw.idwws.Ijocorvarritmo[] getIjocorvarritmos() {
        return ijocorvarritmos;
    }


    /**
     * Sets the ijocorvarritmos value for this Ijop.
     * 
     * @param ijocorvarritmos
     */
    public void setIjocorvarritmos(idw.idwws.Ijocorvarritmo[] ijocorvarritmos) {
        this.ijocorvarritmos = ijocorvarritmos;
    }

    public idw.idwws.Ijocorvarritmo getIjocorvarritmos(int i) {
        return this.ijocorvarritmos[i];
    }

    public void setIjocorvarritmos(int i, idw.idwws.Ijocorvarritmo _value) {
        this.ijocorvarritmos[i] = _value;
    }


    /**
     * Gets the ijopagrupadas value for this Ijop.
     * 
     * @return ijopagrupadas
     */
    public idw.idwws.Ijopagrupada[] getIjopagrupadas() {
        return ijopagrupadas;
    }


    /**
     * Sets the ijopagrupadas value for this Ijop.
     * 
     * @param ijopagrupadas
     */
    public void setIjopagrupadas(idw.idwws.Ijopagrupada[] ijopagrupadas) {
        this.ijopagrupadas = ijopagrupadas;
    }

    public idw.idwws.Ijopagrupada getIjopagrupadas(int i) {
        return this.ijopagrupadas[i];
    }

    public void setIjopagrupadas(int i, idw.idwws.Ijopagrupada _value) {
        this.ijopagrupadas[i] = _value;
    }


    /**
     * Gets the ijopagrups value for this Ijop.
     * 
     * @return ijopagrups
     */
    public idw.idwws.Ijopagrup[] getIjopagrups() {
        return ijopagrups;
    }


    /**
     * Sets the ijopagrups value for this Ijop.
     * 
     * @param ijopagrups
     */
    public void setIjopagrups(idw.idwws.Ijopagrup[] ijopagrups) {
        this.ijopagrups = ijopagrups;
    }

    public idw.idwws.Ijopagrup getIjopagrups(int i) {
        return this.ijopagrups[i];
    }

    public void setIjopagrups(int i, idw.idwws.Ijopagrup _value) {
        this.ijopagrups[i] = _value;
    }


    /**
     * Gets the ijopbloqs value for this Ijop.
     * 
     * @return ijopbloqs
     */
    public idw.idwws.Ijopbloq[] getIjopbloqs() {
        return ijopbloqs;
    }


    /**
     * Sets the ijopbloqs value for this Ijop.
     * 
     * @param ijopbloqs
     */
    public void setIjopbloqs(idw.idwws.Ijopbloq[] ijopbloqs) {
        this.ijopbloqs = ijopbloqs;
    }

    public idw.idwws.Ijopbloq getIjopbloqs(int i) {
        return this.ijopbloqs[i];
    }

    public void setIjopbloqs(int i, idw.idwws.Ijopbloq _value) {
        this.ijopbloqs[i] = _value;
    }


    /**
     * Gets the ijopcgqs value for this Ijop.
     * 
     * @return ijopcgqs
     */
    public idw.idwws.Ijopcgq[] getIjopcgqs() {
        return ijopcgqs;
    }


    /**
     * Sets the ijopcgqs value for this Ijop.
     * 
     * @param ijopcgqs
     */
    public void setIjopcgqs(idw.idwws.Ijopcgq[] ijopcgqs) {
        this.ijopcgqs = ijopcgqs;
    }

    public idw.idwws.Ijopcgq getIjopcgqs(int i) {
        return this.ijopcgqs[i];
    }

    public void setIjopcgqs(int i, idw.idwws.Ijopcgq _value) {
        this.ijopcgqs[i] = _value;
    }


    /**
     * Gets the ijopintrasas value for this Ijop.
     * 
     * @return ijopintrasas
     */
    public idw.idwws.Ijopintrasa[] getIjopintrasas() {
        return ijopintrasas;
    }


    /**
     * Sets the ijopintrasas value for this Ijop.
     * 
     * @param ijopintrasas
     */
    public void setIjopintrasas(idw.idwws.Ijopintrasa[] ijopintrasas) {
        this.ijopintrasas = ijopintrasas;
    }

    public idw.idwws.Ijopintrasa getIjopintrasas(int i) {
        return this.ijopintrasas[i];
    }

    public void setIjopintrasas(int i, idw.idwws.Ijopintrasa _value) {
        this.ijopintrasas[i] = _value;
    }


    /**
     * Gets the ijoplotefabs value for this Ijop.
     * 
     * @return ijoplotefabs
     */
    public idw.idwws.Ijoplotefab[] getIjoplotefabs() {
        return ijoplotefabs;
    }


    /**
     * Sets the ijoplotefabs value for this Ijop.
     * 
     * @param ijoplotefabs
     */
    public void setIjoplotefabs(idw.idwws.Ijoplotefab[] ijoplotefabs) {
        this.ijoplotefabs = ijoplotefabs;
    }

    public idw.idwws.Ijoplotefab getIjoplotefabs(int i) {
        return this.ijoplotefabs[i];
    }

    public void setIjoplotefabs(int i, idw.idwws.Ijoplotefab _value) {
        this.ijoplotefabs[i] = _value;
    }


    /**
     * Gets the ijoploteses value for this Ijop.
     * 
     * @return ijoploteses
     */
    public idw.idwws.Ijoplotes[] getIjoploteses() {
        return ijoploteses;
    }


    /**
     * Sets the ijoploteses value for this Ijop.
     * 
     * @param ijoploteses
     */
    public void setIjoploteses(idw.idwws.Ijoplotes[] ijoploteses) {
        this.ijoploteses = ijoploteses;
    }

    public idw.idwws.Ijoplotes getIjoploteses(int i) {
        return this.ijoploteses[i];
    }

    public void setIjoploteses(int i, idw.idwws.Ijoplotes _value) {
        this.ijoploteses[i] = _value;
    }


    /**
     * Gets the ijopmprimas value for this Ijop.
     * 
     * @return ijopmprimas
     */
    public idw.idwws.Ijopmprima[] getIjopmprimas() {
        return ijopmprimas;
    }


    /**
     * Sets the ijopmprimas value for this Ijop.
     * 
     * @param ijopmprimas
     */
    public void setIjopmprimas(idw.idwws.Ijopmprima[] ijopmprimas) {
        this.ijopmprimas = ijopmprimas;
    }

    public idw.idwws.Ijopmprima getIjopmprimas(int i) {
        return this.ijopmprimas[i];
    }

    public void setIjopmprimas(int i, idw.idwws.Ijopmprima _value) {
        this.ijopmprimas[i] = _value;
    }


    /**
     * Gets the ijopopermaqs value for this Ijop.
     * 
     * @return ijopopermaqs
     */
    public idw.idwws.Ijopopermaq[] getIjopopermaqs() {
        return ijopopermaqs;
    }


    /**
     * Sets the ijopopermaqs value for this Ijop.
     * 
     * @param ijopopermaqs
     */
    public void setIjopopermaqs(idw.idwws.Ijopopermaq[] ijopopermaqs) {
        this.ijopopermaqs = ijopopermaqs;
    }

    public idw.idwws.Ijopopermaq getIjopopermaqs(int i) {
        return this.ijopopermaqs[i];
    }

    public void setIjopopermaqs(int i, idw.idwws.Ijopopermaq _value) {
        this.ijopopermaqs[i] = _value;
    }


    /**
     * Gets the ijoppmedioprods value for this Ijop.
     * 
     * @return ijoppmedioprods
     */
    public idw.idwws.Ijoppmedioprod[] getIjoppmedioprods() {
        return ijoppmedioprods;
    }


    /**
     * Sets the ijoppmedioprods value for this Ijop.
     * 
     * @param ijoppmedioprods
     */
    public void setIjoppmedioprods(idw.idwws.Ijoppmedioprod[] ijoppmedioprods) {
        this.ijoppmedioprods = ijoppmedioprods;
    }

    public idw.idwws.Ijoppmedioprod getIjoppmedioprods(int i) {
        return this.ijoppmedioprods[i];
    }

    public void setIjoppmedioprods(int i, idw.idwws.Ijoppmedioprod _value) {
        this.ijoppmedioprods[i] = _value;
    }


    /**
     * Gets the ijopprodutoses value for this Ijop.
     * 
     * @return ijopprodutoses
     */
    public idw.idwws.Ijopprodutos[] getIjopprodutoses() {
        return ijopprodutoses;
    }


    /**
     * Sets the ijopprodutoses value for this Ijop.
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
     * Gets the ijopproqtopes value for this Ijop.
     * 
     * @return ijopproqtopes
     */
    public idw.idwws.Ijopproqtope[] getIjopproqtopes() {
        return ijopproqtopes;
    }


    /**
     * Sets the ijopproqtopes value for this Ijop.
     * 
     * @param ijopproqtopes
     */
    public void setIjopproqtopes(idw.idwws.Ijopproqtope[] ijopproqtopes) {
        this.ijopproqtopes = ijopproqtopes;
    }

    public idw.idwws.Ijopproqtope getIjopproqtopes(int i) {
        return this.ijopproqtopes[i];
    }

    public void setIjopproqtopes(int i, idw.idwws.Ijopproqtope _value) {
        this.ijopproqtopes[i] = _value;
    }


    /**
     * Gets the ijoproteiros value for this Ijop.
     * 
     * @return ijoproteiros
     */
    public idw.idwws.Ijoproteiro[] getIjoproteiros() {
        return ijoproteiros;
    }


    /**
     * Sets the ijoproteiros value for this Ijop.
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
     * Gets the ijoprotopers value for this Ijop.
     * 
     * @return ijoprotopers
     */
    public idw.idwws.Ijoprotoper[] getIjoprotopers() {
        return ijoprotopers;
    }


    /**
     * Sets the ijoprotopers value for this Ijop.
     * 
     * @param ijoprotopers
     */
    public void setIjoprotopers(idw.idwws.Ijoprotoper[] ijoprotopers) {
        this.ijoprotopers = ijoprotopers;
    }

    public idw.idwws.Ijoprotoper getIjoprotopers(int i) {
        return this.ijoprotopers[i];
    }

    public void setIjoprotopers(int i, idw.idwws.Ijoprotoper _value) {
        this.ijoprotopers[i] = _value;
    }


    /**
     * Gets the ijopsagrupprods value for this Ijop.
     * 
     * @return ijopsagrupprods
     */
    public idw.idwws.Ijopsagrupprod[] getIjopsagrupprods() {
        return ijopsagrupprods;
    }


    /**
     * Sets the ijopsagrupprods value for this Ijop.
     * 
     * @param ijopsagrupprods
     */
    public void setIjopsagrupprods(idw.idwws.Ijopsagrupprod[] ijopsagrupprods) {
        this.ijopsagrupprods = ijopsagrupprods;
    }

    public idw.idwws.Ijopsagrupprod getIjopsagrupprods(int i) {
        return this.ijopsagrupprods[i];
    }

    public void setIjopsagrupprods(int i, idw.idwws.Ijopsagrupprod _value) {
        this.ijopsagrupprods[i] = _value;
    }


    /**
     * Gets the ijopversaopros value for this Ijop.
     * 
     * @return ijopversaopros
     */
    public idw.idwws.Ijopversaopro[] getIjopversaopros() {
        return ijopversaopros;
    }


    /**
     * Sets the ijopversaopros value for this Ijop.
     * 
     * @param ijopversaopros
     */
    public void setIjopversaopros(idw.idwws.Ijopversaopro[] ijopversaopros) {
        this.ijopversaopros = ijopversaopros;
    }

    public idw.idwws.Ijopversaopro getIjopversaopros(int i) {
        return this.ijopversaopros[i];
    }

    public void setIjopversaopros(int i, idw.idwws.Ijopversaopro _value) {
        this.ijopversaopros[i] = _value;
    }


    /**
     * Gets the ijplano value for this Ijop.
     * 
     * @return ijplano
     */
    public idw.idwws.Ijplano getIjplano() {
        return ijplano;
    }


    /**
     * Sets the ijplano value for this Ijop.
     * 
     * @param ijplano
     */
    public void setIjplano(idw.idwws.Ijplano ijplano) {
        this.ijplano = ijplano;
    }


    /**
     * Gets the ijplanops value for this Ijop.
     * 
     * @return ijplanops
     */
    public idw.idwws.Ijplanop[] getIjplanops() {
        return ijplanops;
    }


    /**
     * Sets the ijplanops value for this Ijop.
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
     * Gets the ijproultops value for this Ijop.
     * 
     * @return ijproultops
     */
    public idw.idwws.Ijproultop[] getIjproultops() {
        return ijproultops;
    }


    /**
     * Sets the ijproultops value for this Ijop.
     * 
     * @param ijproultops
     */
    public void setIjproultops(idw.idwws.Ijproultop[] ijproultops) {
        this.ijproultops = ijproultops;
    }

    public idw.idwws.Ijproultop getIjproultops(int i) {
        return this.ijproultops[i];
    }

    public void setIjproultops(int i, idw.idwws.Ijproultop _value) {
        this.ijproultops[i] = _value;
    }


    /**
     * Gets the ijqldinspecaos value for this Ijop.
     * 
     * @return ijqldinspecaos
     */
    public idw.idwws.Ijqldinspecao[] getIjqldinspecaos() {
        return ijqldinspecaos;
    }


    /**
     * Sets the ijqldinspecaos value for this Ijop.
     * 
     * @param ijqldinspecaos
     */
    public void setIjqldinspecaos(idw.idwws.Ijqldinspecao[] ijqldinspecaos) {
        this.ijqldinspecaos = ijqldinspecaos;
    }

    public idw.idwws.Ijqldinspecao getIjqldinspecaos(int i) {
        return this.ijqldinspecaos[i];
    }

    public void setIjqldinspecaos(int i, idw.idwws.Ijqldinspecao _value) {
        this.ijqldinspecaos[i] = _value;
    }


    /**
     * Gets the ijqldprodinsplotes value for this Ijop.
     * 
     * @return ijqldprodinsplotes
     */
    public idw.idwws.Ijqldprodinsplote[] getIjqldprodinsplotes() {
        return ijqldprodinsplotes;
    }


    /**
     * Sets the ijqldprodinsplotes value for this Ijop.
     * 
     * @param ijqldprodinsplotes
     */
    public void setIjqldprodinsplotes(idw.idwws.Ijqldprodinsplote[] ijqldprodinsplotes) {
        this.ijqldprodinsplotes = ijqldprodinsplotes;
    }

    public idw.idwws.Ijqldprodinsplote getIjqldprodinsplotes(int i) {
        return this.ijqldprodinsplotes[i];
    }

    public void setIjqldprodinsplotes(int i, idw.idwws.Ijqldprodinsplote _value) {
        this.ijqldprodinsplotes[i] = _value;
    }


    /**
     * Gets the ijreacicops value for this Ijop.
     * 
     * @return ijreacicops
     */
    public idw.idwws.Ijreacicop[] getIjreacicops() {
        return ijreacicops;
    }


    /**
     * Sets the ijreacicops value for this Ijop.
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
     * Gets the ijreacics value for this Ijop.
     * 
     * @return ijreacics
     */
    public idw.idwws.Ijreacic[] getIjreacics() {
        return ijreacics;
    }


    /**
     * Sets the ijreacics value for this Ijop.
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
     * Gets the ijreainspprods value for this Ijop.
     * 
     * @return ijreainspprods
     */
    public idw.idwws.Ijreainspprod[] getIjreainspprods() {
        return ijreainspprods;
    }


    /**
     * Sets the ijreainspprods value for this Ijop.
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
     * Gets the ijreapars value for this Ijop.
     * 
     * @return ijreapars
     */
    public idw.idwws.Ijreapar[] getIjreapars() {
        return ijreapars;
    }


    /**
     * Sets the ijreapars value for this Ijop.
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
     * Gets the ijreapesos value for this Ijop.
     * 
     * @return ijreapesos
     */
    public idw.idwws.Ijreapeso[] getIjreapesos() {
        return ijreapesos;
    }


    /**
     * Sets the ijreapesos value for this Ijop.
     * 
     * @param ijreapesos
     */
    public void setIjreapesos(idw.idwws.Ijreapeso[] ijreapesos) {
        this.ijreapesos = ijreapesos;
    }

    public idw.idwws.Ijreapeso getIjreapesos(int i) {
        return this.ijreapesos[i];
    }

    public void setIjreapesos(int i, idw.idwws.Ijreapeso _value) {
        this.ijreapesos[i] = _value;
    }


    /**
     * Gets the ijreareas value for this Ijop.
     * 
     * @return ijreareas
     */
    public idw.idwws.Ijrearea[] getIjreareas() {
        return ijreareas;
    }


    /**
     * Sets the ijreareas value for this Ijop.
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
     * Gets the ijrefextras value for this Ijop.
     * 
     * @return ijrefextras
     */
    public idw.idwws.Ijrefextra[] getIjrefextras() {
        return ijrefextras;
    }


    /**
     * Sets the ijrefextras value for this Ijop.
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
     * Gets the ijrefmans value for this Ijop.
     * 
     * @return ijrefmans
     */
    public idw.idwws.Ijrefman[] getIjrefmans() {
        return ijrefmans;
    }


    /**
     * Sets the ijrefmans value for this Ijop.
     * 
     * @param ijrefmans
     */
    public void setIjrefmans(idw.idwws.Ijrefman[] ijrefmans) {
        this.ijrefmans = ijrefmans;
    }

    public idw.idwws.Ijrefman getIjrefmans(int i) {
        return this.ijrefmans[i];
    }

    public void setIjrefmans(int i, idw.idwws.Ijrefman _value) {
        this.ijrefmans[i] = _value;
    }


    /**
     * Gets the ijregultinspqld1S value for this Ijop.
     * 
     * @return ijregultinspqld1S
     */
    public idw.idwws.Ijregultinspqld1[] getIjregultinspqld1S() {
        return ijregultinspqld1S;
    }


    /**
     * Sets the ijregultinspqld1S value for this Ijop.
     * 
     * @param ijregultinspqld1S
     */
    public void setIjregultinspqld1S(idw.idwws.Ijregultinspqld1[] ijregultinspqld1S) {
        this.ijregultinspqld1S = ijregultinspqld1S;
    }

    public idw.idwws.Ijregultinspqld1 getIjregultinspqld1S(int i) {
        return this.ijregultinspqld1S[i];
    }

    public void setIjregultinspqld1S(int i, idw.idwws.Ijregultinspqld1 _value) {
        this.ijregultinspqld1S[i] = _value;
    }


    /**
     * Gets the ijregultinspqld2S value for this Ijop.
     * 
     * @return ijregultinspqld2S
     */
    public idw.idwws.Ijregultinspqld2[] getIjregultinspqld2S() {
        return ijregultinspqld2S;
    }


    /**
     * Sets the ijregultinspqld2S value for this Ijop.
     * 
     * @param ijregultinspqld2S
     */
    public void setIjregultinspqld2S(idw.idwws.Ijregultinspqld2[] ijregultinspqld2S) {
        this.ijregultinspqld2S = ijregultinspqld2S;
    }

    public idw.idwws.Ijregultinspqld2 getIjregultinspqld2S(int i) {
        return this.ijregultinspqld2S[i];
    }

    public void setIjregultinspqld2S(int i, idw.idwws.Ijregultinspqld2 _value) {
        this.ijregultinspqld2S[i] = _value;
    }


    /**
     * Gets the ijregultocorops value for this Ijop.
     * 
     * @return ijregultocorops
     */
    public idw.idwws.Ijregultocorop[] getIjregultocorops() {
        return ijregultocorops;
    }


    /**
     * Sets the ijregultocorops value for this Ijop.
     * 
     * @param ijregultocorops
     */
    public void setIjregultocorops(idw.idwws.Ijregultocorop[] ijregultocorops) {
        this.ijregultocorops = ijregultocorops;
    }

    public idw.idwws.Ijregultocorop getIjregultocorops(int i) {
        return this.ijregultocorops[i];
    }

    public void setIjregultocorops(int i, idw.idwws.Ijregultocorop _value) {
        this.ijregultocorops[i] = _value;
    }


    /**
     * Gets the ijtbinj value for this Ijop.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijop.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbinjultops value for this Ijop.
     * 
     * @return ijtbinjultops
     */
    public idw.idwws.Ijtbinjultop[] getIjtbinjultops() {
        return ijtbinjultops;
    }


    /**
     * Sets the ijtbinjultops value for this Ijop.
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
     * Gets the ijtbstop value for this Ijop.
     * 
     * @return ijtbstop
     */
    public idw.idwws.Ijtbstop getIjtbstop() {
        return ijtbstop;
    }


    /**
     * Sets the ijtbstop value for this Ijop.
     * 
     * @param ijtbstop
     */
    public void setIjtbstop(idw.idwws.Ijtbstop ijtbstop) {
        this.ijtbstop = ijtbstop;
    }


    /**
     * Gets the ijtmpsetupsForNropentrada value for this Ijop.
     * 
     * @return ijtmpsetupsForNropentrada
     */
    public idw.idwws.Ijtmpsetup[] getIjtmpsetupsForNropentrada() {
        return ijtmpsetupsForNropentrada;
    }


    /**
     * Sets the ijtmpsetupsForNropentrada value for this Ijop.
     * 
     * @param ijtmpsetupsForNropentrada
     */
    public void setIjtmpsetupsForNropentrada(idw.idwws.Ijtmpsetup[] ijtmpsetupsForNropentrada) {
        this.ijtmpsetupsForNropentrada = ijtmpsetupsForNropentrada;
    }

    public idw.idwws.Ijtmpsetup getIjtmpsetupsForNropentrada(int i) {
        return this.ijtmpsetupsForNropentrada[i];
    }

    public void setIjtmpsetupsForNropentrada(int i, idw.idwws.Ijtmpsetup _value) {
        this.ijtmpsetupsForNropentrada[i] = _value;
    }


    /**
     * Gets the ijtmpsetupsForNropsaida value for this Ijop.
     * 
     * @return ijtmpsetupsForNropsaida
     */
    public idw.idwws.Ijtmpsetup[] getIjtmpsetupsForNropsaida() {
        return ijtmpsetupsForNropsaida;
    }


    /**
     * Sets the ijtmpsetupsForNropsaida value for this Ijop.
     * 
     * @param ijtmpsetupsForNropsaida
     */
    public void setIjtmpsetupsForNropsaida(idw.idwws.Ijtmpsetup[] ijtmpsetupsForNropsaida) {
        this.ijtmpsetupsForNropsaida = ijtmpsetupsForNropsaida;
    }

    public idw.idwws.Ijtmpsetup getIjtmpsetupsForNropsaida(int i) {
        return this.ijtmpsetupsForNropsaida[i];
    }

    public void setIjtmpsetupsForNropsaida(int i, idw.idwws.Ijtmpsetup _value) {
        this.ijtmpsetupsForNropsaida[i] = _value;
    }


    /**
     * Gets the ijtmpultsts value for this Ijop.
     * 
     * @return ijtmpultsts
     */
    public idw.idwws.Ijtmpultst[] getIjtmpultsts() {
        return ijtmpultsts;
    }


    /**
     * Sets the ijtmpultsts value for this Ijop.
     * 
     * @param ijtmpultsts
     */
    public void setIjtmpultsts(idw.idwws.Ijtmpultst[] ijtmpultsts) {
        this.ijtmpultsts = ijtmpultsts;
    }

    public idw.idwws.Ijtmpultst getIjtmpultsts(int i) {
        return this.ijtmpultsts[i];
    }

    public void setIjtmpultsts(int i, idw.idwws.Ijtmpultst _value) {
        this.ijtmpultsts[i] = _value;
    }


    /**
     * Gets the nrop value for this Ijop.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this Ijop.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the nropcoorp value for this Ijop.
     * 
     * @return nropcoorp
     */
    public java.lang.String getNropcoorp() {
        return nropcoorp;
    }


    /**
     * Sets the nropcoorp value for this Ijop.
     * 
     * @param nropcoorp
     */
    public void setNropcoorp(java.lang.String nropcoorp) {
        this.nropcoorp = nropcoorp;
    }


    /**
     * Gets the nropestendido value for this Ijop.
     * 
     * @return nropestendido
     */
    public java.lang.String getNropestendido() {
        return nropestendido;
    }


    /**
     * Sets the nropestendido value for this Ijop.
     * 
     * @param nropestendido
     */
    public void setNropestendido(java.lang.String nropestendido) {
        this.nropestendido = nropestendido;
    }


    /**
     * Gets the nrseq value for this Ijop.
     * 
     * @return nrseq
     */
    public double getNrseq() {
        return nrseq;
    }


    /**
     * Sets the nrseq value for this Ijop.
     * 
     * @param nrseq
     */
    public void setNrseq(double nrseq) {
        this.nrseq = nrseq;
    }


    /**
     * Gets the numsmnentrega value for this Ijop.
     * 
     * @return numsmnentrega
     */
    public java.math.BigDecimal getNumsmnentrega() {
        return numsmnentrega;
    }


    /**
     * Sets the numsmnentrega value for this Ijop.
     * 
     * @param numsmnentrega
     */
    public void setNumsmnentrega(java.math.BigDecimal numsmnentrega) {
        this.numsmnentrega = numsmnentrega;
    }


    /**
     * Gets the opcritica value for this Ijop.
     * 
     * @return opcritica
     */
    public org.apache.axis.types.UnsignedShort getOpcritica() {
        return opcritica;
    }


    /**
     * Sets the opcritica value for this Ijop.
     * 
     * @param opcritica
     */
    public void setOpcritica(org.apache.axis.types.UnsignedShort opcritica) {
        this.opcritica = opcritica;
    }


    /**
     * Gets the toleranciaplano value for this Ijop.
     * 
     * @return toleranciaplano
     */
    public double getToleranciaplano() {
        return toleranciaplano;
    }


    /**
     * Sets the toleranciaplano value for this Ijop.
     * 
     * @param toleranciaplano
     */
    public void setToleranciaplano(double toleranciaplano) {
        this.toleranciaplano = toleranciaplano;
    }


    /**
     * Gets the tpacabamento value for this Ijop.
     * 
     * @return tpacabamento
     */
    public org.apache.axis.types.UnsignedShort getTpacabamento() {
        return tpacabamento;
    }


    /**
     * Sets the tpacabamento value for this Ijop.
     * 
     * @param tpacabamento
     */
    public void setTpacabamento(org.apache.axis.types.UnsignedShort tpacabamento) {
        this.tpacabamento = tpacabamento;
    }


    /**
     * Gets the tpordemproducao value for this Ijop.
     * 
     * @return tpordemproducao
     */
    public org.apache.axis.types.UnsignedShort getTpordemproducao() {
        return tpordemproducao;
    }


    /**
     * Sets the tpordemproducao value for this Ijop.
     * 
     * @param tpordemproducao
     */
    public void setTpordemproducao(org.apache.axis.types.UnsignedShort tpordemproducao) {
        this.tpordemproducao = tpordemproducao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijop)) return false;
        Ijop other = (Ijop) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dtentrega==null && other.getDtentrega()==null) || 
             (this.dtentrega!=null &&
              this.dtentrega.equals(other.getDtentrega()))) &&
            ((this.dthrfprevista==null && other.getDthrfprevista()==null) || 
             (this.dthrfprevista!=null &&
              this.dthrfprevista.equals(other.getDthrfprevista()))) &&
            ((this.dthriprevista==null && other.getDthriprevista()==null) || 
             (this.dthriprevista!=null &&
              this.dthriprevista.equals(other.getDthriprevista()))) &&
            ((this.dthrireal==null && other.getDthrireal()==null) || 
             (this.dthrireal!=null &&
              this.dthrireal.equals(other.getDthrireal()))) &&
            ((this.dthrpriciclo==null && other.getDthrpriciclo()==null) || 
             (this.dthrpriciclo!=null &&
              this.dthrpriciclo.equals(other.getDthrpriciclo()))) &&
            ((this.dthrsaida==null && other.getDthrsaida()==null) || 
             (this.dthrsaida!=null &&
              this.dthrsaida.equals(other.getDthrsaida()))) &&
            ((this.exportacao001S==null && other.getExportacao001S()==null) || 
             (this.exportacao001S!=null &&
              java.util.Arrays.equals(this.exportacao001S, other.getExportacao001S()))) &&
            ((this.exportacao002S==null && other.getExportacao002S()==null) || 
             (this.exportacao002S!=null &&
              java.util.Arrays.equals(this.exportacao002S, other.getExportacao002S()))) &&
            ((this.exportacao003S==null && other.getExportacao003S()==null) || 
             (this.exportacao003S!=null &&
              java.util.Arrays.equals(this.exportacao003S, other.getExportacao003S()))) &&
            ((this.exportacao004S==null && other.getExportacao004S()==null) || 
             (this.exportacao004S!=null &&
              java.util.Arrays.equals(this.exportacao004S, other.getExportacao004S()))) &&
            ((this.exportacao006S==null && other.getExportacao006S()==null) || 
             (this.exportacao006S!=null &&
              java.util.Arrays.equals(this.exportacao006S, other.getExportacao006S()))) &&
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
            ((this.ijcncops==null && other.getIjcncops()==null) || 
             (this.ijcncops!=null &&
              java.util.Arrays.equals(this.ijcncops, other.getIjcncops()))) &&
            ((this.ijcncturnos==null && other.getIjcncturnos()==null) || 
             (this.ijcncturnos!=null &&
              java.util.Arrays.equals(this.ijcncturnos, other.getIjcncturnos()))) &&
            ((this.ijctrlcgqs==null && other.getIjctrlcgqs()==null) || 
             (this.ijctrlcgqs!=null &&
              java.util.Arrays.equals(this.ijctrlcgqs, other.getIjctrlcgqs()))) &&
            ((this.ijctrliniprocprods==null && other.getIjctrliniprocprods()==null) || 
             (this.ijctrliniprocprods!=null &&
              java.util.Arrays.equals(this.ijctrliniprocprods, other.getIjctrliniprocprods()))) &&
            ((this.ijctrliniprocs==null && other.getIjctrliniprocs()==null) || 
             (this.ijctrliniprocs!=null &&
              java.util.Arrays.equals(this.ijctrliniprocs, other.getIjctrliniprocs()))) &&
            ((this.ijctrliniproctemps==null && other.getIjctrliniproctemps()==null) || 
             (this.ijctrliniproctemps!=null &&
              java.util.Arrays.equals(this.ijctrliniproctemps, other.getIjctrliniproctemps()))) &&
            ((this.ijctrliniproctrocas==null && other.getIjctrliniproctrocas()==null) || 
             (this.ijctrliniproctrocas!=null &&
              java.util.Arrays.equals(this.ijctrliniproctrocas, other.getIjctrliniproctrocas()))) &&
            ((this.ijctrlresnegqld1S==null && other.getIjctrlresnegqld1S()==null) || 
             (this.ijctrlresnegqld1S!=null &&
              java.util.Arrays.equals(this.ijctrlresnegqld1S, other.getIjctrlresnegqld1S()))) &&
            ((this.ijctrlresnegqld2S==null && other.getIjctrlresnegqld2S()==null) || 
             (this.ijctrlresnegqld2S!=null &&
              java.util.Arrays.equals(this.ijctrlresnegqld2S, other.getIjctrlresnegqld2S()))) &&
            ((this.ijembaponts==null && other.getIjembaponts()==null) || 
             (this.ijembaponts!=null &&
              java.util.Arrays.equals(this.ijembaponts, other.getIjembaponts()))) &&
            ((this.ijentsaiopmaqs==null && other.getIjentsaiopmaqs()==null) || 
             (this.ijentsaiopmaqs!=null &&
              java.util.Arrays.equals(this.ijentsaiopmaqs, other.getIjentsaiopmaqs()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijetqfaixas==null && other.getIjetqfaixas()==null) || 
             (this.ijetqfaixas!=null &&
              java.util.Arrays.equals(this.ijetqfaixas, other.getIjetqfaixas()))) &&
            ((this.ijetqprodutos==null && other.getIjetqprodutos()==null) || 
             (this.ijetqprodutos!=null &&
              java.util.Arrays.equals(this.ijetqprodutos, other.getIjetqprodutos()))) &&
            ((this.ijfreqmanutprevops==null && other.getIjfreqmanutprevops()==null) || 
             (this.ijfreqmanutprevops!=null &&
              java.util.Arrays.equals(this.ijfreqmanutprevops, other.getIjfreqmanutprevops()))) &&
            ((this.ijiniopinjs==null && other.getIjiniopinjs()==null) || 
             (this.ijiniopinjs!=null &&
              java.util.Arrays.equals(this.ijiniopinjs, other.getIjiniopinjs()))) &&
            ((this.ijinspecaos==null && other.getIjinspecaos()==null) || 
             (this.ijinspecaos!=null &&
              java.util.Arrays.equals(this.ijinspecaos, other.getIjinspecaos()))) &&
            ((this.ijkanbanlotes==null && other.getIjkanbanlotes()==null) || 
             (this.ijkanbanlotes!=null &&
              java.util.Arrays.equals(this.ijkanbanlotes, other.getIjkanbanlotes()))) &&
            ((this.ijmdoalocops==null && other.getIjmdoalocops()==null) || 
             (this.ijmdoalocops!=null &&
              java.util.Arrays.equals(this.ijmdoalocops, other.getIjmdoalocops()))) &&
            ((this.ijmovpostoses==null && other.getIjmovpostoses()==null) || 
             (this.ijmovpostoses!=null &&
              java.util.Arrays.equals(this.ijmovpostoses, other.getIjmovpostoses()))) &&
            ((this.ijocorreploteinses==null && other.getIjocorreploteinses()==null) || 
             (this.ijocorreploteinses!=null &&
              java.util.Arrays.equals(this.ijocorreploteinses, other.getIjocorreploteinses()))) &&
            ((this.ijocorvarritmos==null && other.getIjocorvarritmos()==null) || 
             (this.ijocorvarritmos!=null &&
              java.util.Arrays.equals(this.ijocorvarritmos, other.getIjocorvarritmos()))) &&
            ((this.ijopagrupadas==null && other.getIjopagrupadas()==null) || 
             (this.ijopagrupadas!=null &&
              java.util.Arrays.equals(this.ijopagrupadas, other.getIjopagrupadas()))) &&
            ((this.ijopagrups==null && other.getIjopagrups()==null) || 
             (this.ijopagrups!=null &&
              java.util.Arrays.equals(this.ijopagrups, other.getIjopagrups()))) &&
            ((this.ijopbloqs==null && other.getIjopbloqs()==null) || 
             (this.ijopbloqs!=null &&
              java.util.Arrays.equals(this.ijopbloqs, other.getIjopbloqs()))) &&
            ((this.ijopcgqs==null && other.getIjopcgqs()==null) || 
             (this.ijopcgqs!=null &&
              java.util.Arrays.equals(this.ijopcgqs, other.getIjopcgqs()))) &&
            ((this.ijopintrasas==null && other.getIjopintrasas()==null) || 
             (this.ijopintrasas!=null &&
              java.util.Arrays.equals(this.ijopintrasas, other.getIjopintrasas()))) &&
            ((this.ijoplotefabs==null && other.getIjoplotefabs()==null) || 
             (this.ijoplotefabs!=null &&
              java.util.Arrays.equals(this.ijoplotefabs, other.getIjoplotefabs()))) &&
            ((this.ijoploteses==null && other.getIjoploteses()==null) || 
             (this.ijoploteses!=null &&
              java.util.Arrays.equals(this.ijoploteses, other.getIjoploteses()))) &&
            ((this.ijopmprimas==null && other.getIjopmprimas()==null) || 
             (this.ijopmprimas!=null &&
              java.util.Arrays.equals(this.ijopmprimas, other.getIjopmprimas()))) &&
            ((this.ijopopermaqs==null && other.getIjopopermaqs()==null) || 
             (this.ijopopermaqs!=null &&
              java.util.Arrays.equals(this.ijopopermaqs, other.getIjopopermaqs()))) &&
            ((this.ijoppmedioprods==null && other.getIjoppmedioprods()==null) || 
             (this.ijoppmedioprods!=null &&
              java.util.Arrays.equals(this.ijoppmedioprods, other.getIjoppmedioprods()))) &&
            ((this.ijopprodutoses==null && other.getIjopprodutoses()==null) || 
             (this.ijopprodutoses!=null &&
              java.util.Arrays.equals(this.ijopprodutoses, other.getIjopprodutoses()))) &&
            ((this.ijopproqtopes==null && other.getIjopproqtopes()==null) || 
             (this.ijopproqtopes!=null &&
              java.util.Arrays.equals(this.ijopproqtopes, other.getIjopproqtopes()))) &&
            ((this.ijoproteiros==null && other.getIjoproteiros()==null) || 
             (this.ijoproteiros!=null &&
              java.util.Arrays.equals(this.ijoproteiros, other.getIjoproteiros()))) &&
            ((this.ijoprotopers==null && other.getIjoprotopers()==null) || 
             (this.ijoprotopers!=null &&
              java.util.Arrays.equals(this.ijoprotopers, other.getIjoprotopers()))) &&
            ((this.ijopsagrupprods==null && other.getIjopsagrupprods()==null) || 
             (this.ijopsagrupprods!=null &&
              java.util.Arrays.equals(this.ijopsagrupprods, other.getIjopsagrupprods()))) &&
            ((this.ijopversaopros==null && other.getIjopversaopros()==null) || 
             (this.ijopversaopros!=null &&
              java.util.Arrays.equals(this.ijopversaopros, other.getIjopversaopros()))) &&
            ((this.ijplano==null && other.getIjplano()==null) || 
             (this.ijplano!=null &&
              this.ijplano.equals(other.getIjplano()))) &&
            ((this.ijplanops==null && other.getIjplanops()==null) || 
             (this.ijplanops!=null &&
              java.util.Arrays.equals(this.ijplanops, other.getIjplanops()))) &&
            ((this.ijproultops==null && other.getIjproultops()==null) || 
             (this.ijproultops!=null &&
              java.util.Arrays.equals(this.ijproultops, other.getIjproultops()))) &&
            ((this.ijqldinspecaos==null && other.getIjqldinspecaos()==null) || 
             (this.ijqldinspecaos!=null &&
              java.util.Arrays.equals(this.ijqldinspecaos, other.getIjqldinspecaos()))) &&
            ((this.ijqldprodinsplotes==null && other.getIjqldprodinsplotes()==null) || 
             (this.ijqldprodinsplotes!=null &&
              java.util.Arrays.equals(this.ijqldprodinsplotes, other.getIjqldprodinsplotes()))) &&
            ((this.ijreacicops==null && other.getIjreacicops()==null) || 
             (this.ijreacicops!=null &&
              java.util.Arrays.equals(this.ijreacicops, other.getIjreacicops()))) &&
            ((this.ijreacics==null && other.getIjreacics()==null) || 
             (this.ijreacics!=null &&
              java.util.Arrays.equals(this.ijreacics, other.getIjreacics()))) &&
            ((this.ijreainspprods==null && other.getIjreainspprods()==null) || 
             (this.ijreainspprods!=null &&
              java.util.Arrays.equals(this.ijreainspprods, other.getIjreainspprods()))) &&
            ((this.ijreapars==null && other.getIjreapars()==null) || 
             (this.ijreapars!=null &&
              java.util.Arrays.equals(this.ijreapars, other.getIjreapars()))) &&
            ((this.ijreapesos==null && other.getIjreapesos()==null) || 
             (this.ijreapesos!=null &&
              java.util.Arrays.equals(this.ijreapesos, other.getIjreapesos()))) &&
            ((this.ijreareas==null && other.getIjreareas()==null) || 
             (this.ijreareas!=null &&
              java.util.Arrays.equals(this.ijreareas, other.getIjreareas()))) &&
            ((this.ijrefextras==null && other.getIjrefextras()==null) || 
             (this.ijrefextras!=null &&
              java.util.Arrays.equals(this.ijrefextras, other.getIjrefextras()))) &&
            ((this.ijrefmans==null && other.getIjrefmans()==null) || 
             (this.ijrefmans!=null &&
              java.util.Arrays.equals(this.ijrefmans, other.getIjrefmans()))) &&
            ((this.ijregultinspqld1S==null && other.getIjregultinspqld1S()==null) || 
             (this.ijregultinspqld1S!=null &&
              java.util.Arrays.equals(this.ijregultinspqld1S, other.getIjregultinspqld1S()))) &&
            ((this.ijregultinspqld2S==null && other.getIjregultinspqld2S()==null) || 
             (this.ijregultinspqld2S!=null &&
              java.util.Arrays.equals(this.ijregultinspqld2S, other.getIjregultinspqld2S()))) &&
            ((this.ijregultocorops==null && other.getIjregultocorops()==null) || 
             (this.ijregultocorops!=null &&
              java.util.Arrays.equals(this.ijregultocorops, other.getIjregultocorops()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbinjultops==null && other.getIjtbinjultops()==null) || 
             (this.ijtbinjultops!=null &&
              java.util.Arrays.equals(this.ijtbinjultops, other.getIjtbinjultops()))) &&
            ((this.ijtbstop==null && other.getIjtbstop()==null) || 
             (this.ijtbstop!=null &&
              this.ijtbstop.equals(other.getIjtbstop()))) &&
            ((this.ijtmpsetupsForNropentrada==null && other.getIjtmpsetupsForNropentrada()==null) || 
             (this.ijtmpsetupsForNropentrada!=null &&
              java.util.Arrays.equals(this.ijtmpsetupsForNropentrada, other.getIjtmpsetupsForNropentrada()))) &&
            ((this.ijtmpsetupsForNropsaida==null && other.getIjtmpsetupsForNropsaida()==null) || 
             (this.ijtmpsetupsForNropsaida!=null &&
              java.util.Arrays.equals(this.ijtmpsetupsForNropsaida, other.getIjtmpsetupsForNropsaida()))) &&
            ((this.ijtmpultsts==null && other.getIjtmpultsts()==null) || 
             (this.ijtmpultsts!=null &&
              java.util.Arrays.equals(this.ijtmpultsts, other.getIjtmpultsts()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.nropcoorp==null && other.getNropcoorp()==null) || 
             (this.nropcoorp!=null &&
              this.nropcoorp.equals(other.getNropcoorp()))) &&
            ((this.nropestendido==null && other.getNropestendido()==null) || 
             (this.nropestendido!=null &&
              this.nropestendido.equals(other.getNropestendido()))) &&
            this.nrseq == other.getNrseq() &&
            ((this.numsmnentrega==null && other.getNumsmnentrega()==null) || 
             (this.numsmnentrega!=null &&
              this.numsmnentrega.equals(other.getNumsmnentrega()))) &&
            ((this.opcritica==null && other.getOpcritica()==null) || 
             (this.opcritica!=null &&
              this.opcritica.equals(other.getOpcritica()))) &&
            this.toleranciaplano == other.getToleranciaplano() &&
            ((this.tpacabamento==null && other.getTpacabamento()==null) || 
             (this.tpacabamento!=null &&
              this.tpacabamento.equals(other.getTpacabamento()))) &&
            ((this.tpordemproducao==null && other.getTpordemproducao()==null) || 
             (this.tpordemproducao!=null &&
              this.tpordemproducao.equals(other.getTpordemproducao())));
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
        if (getDtentrega() != null) {
            _hashCode += getDtentrega().hashCode();
        }
        if (getDthrfprevista() != null) {
            _hashCode += getDthrfprevista().hashCode();
        }
        if (getDthriprevista() != null) {
            _hashCode += getDthriprevista().hashCode();
        }
        if (getDthrireal() != null) {
            _hashCode += getDthrireal().hashCode();
        }
        if (getDthrpriciclo() != null) {
            _hashCode += getDthrpriciclo().hashCode();
        }
        if (getDthrsaida() != null) {
            _hashCode += getDthrsaida().hashCode();
        }
        if (getExportacao001S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao001S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao001S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExportacao002S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao002S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao002S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExportacao003S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao003S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao003S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getExportacao006S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao006S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao006S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getIjcncops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcncops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcncops(), i);
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
        if (getIjctrlcgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlcgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlcgqs(), i);
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
        if (getIjctrliniprocs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrliniprocs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrliniprocs(), i);
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
        if (getIjctrliniproctrocas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrliniproctrocas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrliniproctrocas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrlresnegqld1S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlresnegqld1S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlresnegqld1S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrlresnegqld2S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrlresnegqld2S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrlresnegqld2S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjembaponts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjembaponts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjembaponts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjentsaiopmaqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjentsaiopmaqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjentsaiopmaqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjetqfaixas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjetqfaixas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjetqfaixas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjetqprodutos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjetqprodutos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjetqprodutos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjfreqmanutprevops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfreqmanutprevops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfreqmanutprevops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjiniopinjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjiniopinjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjiniopinjs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjinspecaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjinspecaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjinspecaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanlotes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanlotes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanlotes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmdoalocops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmdoalocops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmdoalocops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmovpostoses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmovpostoses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmovpostoses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjocorreploteinses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjocorreploteinses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjocorreploteinses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjocorvarritmos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjocorvarritmos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjocorvarritmos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopagrupadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopagrupadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopagrupadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopagrups() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopagrups());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopagrups(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopbloqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopbloqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopbloqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopcgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopcgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopcgqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopintrasas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopintrasas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopintrasas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjoplotefabs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjoplotefabs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjoplotefabs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjoploteses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjoploteses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjoploteses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopmprimas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopmprimas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopmprimas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopopermaqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopopermaqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopopermaqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjoppmedioprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjoppmedioprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjoppmedioprods(), i);
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
        if (getIjopproqtopes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopproqtopes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopproqtopes(), i);
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
        if (getIjoprotopers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjoprotopers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjoprotopers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopsagrupprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopsagrupprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopsagrupprods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjopversaopros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjopversaopros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjopversaopros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjplano() != null) {
            _hashCode += getIjplano().hashCode();
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
        if (getIjproultops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjproultops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjproultops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjqldinspecaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjqldinspecaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjqldinspecaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjqldprodinsplotes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjqldprodinsplotes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjqldprodinsplotes(), i);
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
        if (getIjreapesos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreapesos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreapesos(), i);
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
        if (getIjrefmans() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrefmans());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrefmans(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjregultinspqld1S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjregultinspqld1S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjregultinspqld1S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjregultinspqld2S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjregultinspqld2S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjregultinspqld2S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjregultocorops() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjregultocorops());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjregultocorops(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
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
        if (getIjtbstop() != null) {
            _hashCode += getIjtbstop().hashCode();
        }
        if (getIjtmpsetupsForNropentrada() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtmpsetupsForNropentrada());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtmpsetupsForNropentrada(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtmpsetupsForNropsaida() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtmpsetupsForNropsaida());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtmpsetupsForNropsaida(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtmpultsts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtmpultsts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtmpultsts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getNropcoorp() != null) {
            _hashCode += getNropcoorp().hashCode();
        }
        if (getNropestendido() != null) {
            _hashCode += getNropestendido().hashCode();
        }
        _hashCode += new Double(getNrseq()).hashCode();
        if (getNumsmnentrega() != null) {
            _hashCode += getNumsmnentrega().hashCode();
        }
        if (getOpcritica() != null) {
            _hashCode += getOpcritica().hashCode();
        }
        _hashCode += new Double(getToleranciaplano()).hashCode();
        if (getTpacabamento() != null) {
            _hashCode += getTpacabamento().hashCode();
        }
        if (getTpordemproducao() != null) {
            _hashCode += getTpordemproducao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijop.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtentrega");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtentrega"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfprevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfprevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriprevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriprevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrireal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrireal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrpriciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrpriciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrsaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrsaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao001S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao001s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao001"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao002S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao002s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao002"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao003S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao003s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao003"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("exportacao006S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao006s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao006"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("ijcncops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcncops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcncop"));
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
        elemField.setFieldName("ijctrlcgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlcgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlcgq"));
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
        elemField.setFieldName("ijctrliniprocs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniprocs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproc"));
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
        elemField.setFieldName("ijctrliniproctrocas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniproctrocas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproctroca"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlresnegqld1S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlresnegqld1s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlresnegqld1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrlresnegqld2S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrlresnegqld2s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrlresnegqld2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijembaponts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijembaponts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijembapont"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijentsaiopmaqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijentsaiopmaqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijentsaiopmaq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijetqfaixas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijetqfaixas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijetqfaixa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijetqprodutos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijetqprodutos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijetqproduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfreqmanutprevops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfreqmanutprevops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfreqmanutprevop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijiniopinjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijiniopinjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijiniopinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijinspecaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijinspecaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinspecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanlotes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanlotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlote"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmdoalocops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmdoalocops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmdoalocop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmovpostoses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmovpostoses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmovpostos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijocorreploteinses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijocorreploteinses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijocorreploteins"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijocorvarritmos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijocorvarritmos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijocorvarritmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopagrupadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopagrupadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopagrupada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopagrups");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopagrups"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopagrup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopbloqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopbloqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopbloq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopcgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopcgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopcgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopintrasas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopintrasas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopintrasa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijoplotefabs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoplotefabs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotefab"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijoploteses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoploteses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopmprimas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopmprimas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopmprima"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopopermaqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopopermaqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopopermaq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijoppmedioprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoppmedioprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoppmedioprod"));
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
        elemField.setFieldName("ijopproqtopes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopproqtopes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopproqtope"));
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
        elemField.setFieldName("ijoprotopers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoprotopers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoprotoper"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopsagrupprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopsagrupprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopsagrupprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopversaopros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopversaopros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijopversaopro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijplano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijplano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijplano"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("ijproultops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijproultops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijproultop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijqldinspecaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijqldinspecaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldinspecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijqldprodinsplotes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijqldprodinsplotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldprodinsplote"));
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
        elemField.setFieldName("ijreainspprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreainspprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreainspprod"));
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
        elemField.setFieldName("ijreapesos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapesos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapeso"));
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
        elemField.setFieldName("ijrefextras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrefextras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrefextra"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrefmans");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrefmans"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrefman"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijregultinspqld1S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijregultinspqld1s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijregultinspqld1"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijregultinspqld2S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijregultinspqld2s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijregultinspqld2"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijregultocorops");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijregultocorops"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijregultocorop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("ijtbstop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbstop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbstop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtmpsetupsForNropentrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtmpsetupsForNropentrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtmpsetup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtmpsetupsForNropsaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtmpsetupsForNropsaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtmpsetup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtmpultsts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtmpultsts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtmpultst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nropcoorp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nropcoorp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nropestendido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nropestendido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrseq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrseq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numsmnentrega");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numsmnentrega"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("opcritica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "opcritica"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toleranciaplano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "toleranciaplano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpacabamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpacabamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpordemproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpordemproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
