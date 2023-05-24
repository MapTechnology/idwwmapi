/**
 * Ijmolpro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmolpro  extends idw.idwws.IjmolproTemplate  implements java.io.Serializable {
    private java.lang.String cdidentificacao;

    private java.util.Calendar dthrfval;

    private idw.idwws.IjmolproId id;

    private idw.idwws.Ijctrlresnegqld1[] ijctrlresnegqld1S;

    private idw.idwws.Ijctrlresnegqld2[] ijctrlresnegqld2S;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijinspecao[] ijinspecaos;

    private idw.idwws.Ijmolproagrup[] ijmolproagrups;

    private idw.idwws.Ijmolproidcav[] ijmolproidcavs;

    private idw.idwws.Ijqldinspecao[] ijqldinspecaos;

    private idw.idwws.Ijqldprodinsplote[] ijqldprodinsplotes;

    private idw.idwws.Ijreapeso[] ijreapesos;

    private idw.idwws.Ijrefman[] ijrefmans;

    private idw.idwws.Ijtbpro ijtbpro;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.lang.Double pbrutomedio;

    private java.lang.Double pliquidomedio;

    private java.lang.Double qtcavativas;

    private java.lang.Double qtcavidades;

    public Ijmolpro() {
    }

    public Ijmolpro(
           java.lang.String cdidentificacao,
           java.util.Calendar dthrfval,
           idw.idwws.IjmolproId id,
           idw.idwws.Ijctrlresnegqld1[] ijctrlresnegqld1S,
           idw.idwws.Ijctrlresnegqld2[] ijctrlresnegqld2S,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijinspecao[] ijinspecaos,
           idw.idwws.Ijmolproagrup[] ijmolproagrups,
           idw.idwws.Ijmolproidcav[] ijmolproidcavs,
           idw.idwws.Ijqldinspecao[] ijqldinspecaos,
           idw.idwws.Ijqldprodinsplote[] ijqldprodinsplotes,
           idw.idwws.Ijreapeso[] ijreapesos,
           idw.idwws.Ijrefman[] ijrefmans,
           idw.idwws.Ijtbpro ijtbpro,
           idw.idwws.Ijtbusu ijtbusu,
           java.lang.Double pbrutomedio,
           java.lang.Double pliquidomedio,
           java.lang.Double qtcavativas,
           java.lang.Double qtcavidades) {
        this.cdidentificacao = cdidentificacao;
        this.dthrfval = dthrfval;
        this.id = id;
        this.ijctrlresnegqld1S = ijctrlresnegqld1S;
        this.ijctrlresnegqld2S = ijctrlresnegqld2S;
        this.ijestmol = ijestmol;
        this.ijinspecaos = ijinspecaos;
        this.ijmolproagrups = ijmolproagrups;
        this.ijmolproidcavs = ijmolproidcavs;
        this.ijqldinspecaos = ijqldinspecaos;
        this.ijqldprodinsplotes = ijqldprodinsplotes;
        this.ijreapesos = ijreapesos;
        this.ijrefmans = ijrefmans;
        this.ijtbpro = ijtbpro;
        this.ijtbusu = ijtbusu;
        this.pbrutomedio = pbrutomedio;
        this.pliquidomedio = pliquidomedio;
        this.qtcavativas = qtcavativas;
        this.qtcavidades = qtcavidades;
    }


    /**
     * Gets the cdidentificacao value for this Ijmolpro.
     * 
     * @return cdidentificacao
     */
    public java.lang.String getCdidentificacao() {
        return cdidentificacao;
    }


    /**
     * Sets the cdidentificacao value for this Ijmolpro.
     * 
     * @param cdidentificacao
     */
    public void setCdidentificacao(java.lang.String cdidentificacao) {
        this.cdidentificacao = cdidentificacao;
    }


    /**
     * Gets the dthrfval value for this Ijmolpro.
     * 
     * @return dthrfval
     */
    public java.util.Calendar getDthrfval() {
        return dthrfval;
    }


    /**
     * Sets the dthrfval value for this Ijmolpro.
     * 
     * @param dthrfval
     */
    public void setDthrfval(java.util.Calendar dthrfval) {
        this.dthrfval = dthrfval;
    }


    /**
     * Gets the id value for this Ijmolpro.
     * 
     * @return id
     */
    public idw.idwws.IjmolproId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmolpro.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmolproId id) {
        this.id = id;
    }


    /**
     * Gets the ijctrlresnegqld1S value for this Ijmolpro.
     * 
     * @return ijctrlresnegqld1S
     */
    public idw.idwws.Ijctrlresnegqld1[] getIjctrlresnegqld1S() {
        return ijctrlresnegqld1S;
    }


    /**
     * Sets the ijctrlresnegqld1S value for this Ijmolpro.
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
     * Gets the ijctrlresnegqld2S value for this Ijmolpro.
     * 
     * @return ijctrlresnegqld2S
     */
    public idw.idwws.Ijctrlresnegqld2[] getIjctrlresnegqld2S() {
        return ijctrlresnegqld2S;
    }


    /**
     * Sets the ijctrlresnegqld2S value for this Ijmolpro.
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
     * Gets the ijestmol value for this Ijmolpro.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijmolpro.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijinspecaos value for this Ijmolpro.
     * 
     * @return ijinspecaos
     */
    public idw.idwws.Ijinspecao[] getIjinspecaos() {
        return ijinspecaos;
    }


    /**
     * Sets the ijinspecaos value for this Ijmolpro.
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
     * Gets the ijmolproagrups value for this Ijmolpro.
     * 
     * @return ijmolproagrups
     */
    public idw.idwws.Ijmolproagrup[] getIjmolproagrups() {
        return ijmolproagrups;
    }


    /**
     * Sets the ijmolproagrups value for this Ijmolpro.
     * 
     * @param ijmolproagrups
     */
    public void setIjmolproagrups(idw.idwws.Ijmolproagrup[] ijmolproagrups) {
        this.ijmolproagrups = ijmolproagrups;
    }

    public idw.idwws.Ijmolproagrup getIjmolproagrups(int i) {
        return this.ijmolproagrups[i];
    }

    public void setIjmolproagrups(int i, idw.idwws.Ijmolproagrup _value) {
        this.ijmolproagrups[i] = _value;
    }


    /**
     * Gets the ijmolproidcavs value for this Ijmolpro.
     * 
     * @return ijmolproidcavs
     */
    public idw.idwws.Ijmolproidcav[] getIjmolproidcavs() {
        return ijmolproidcavs;
    }


    /**
     * Sets the ijmolproidcavs value for this Ijmolpro.
     * 
     * @param ijmolproidcavs
     */
    public void setIjmolproidcavs(idw.idwws.Ijmolproidcav[] ijmolproidcavs) {
        this.ijmolproidcavs = ijmolproidcavs;
    }

    public idw.idwws.Ijmolproidcav getIjmolproidcavs(int i) {
        return this.ijmolproidcavs[i];
    }

    public void setIjmolproidcavs(int i, idw.idwws.Ijmolproidcav _value) {
        this.ijmolproidcavs[i] = _value;
    }


    /**
     * Gets the ijqldinspecaos value for this Ijmolpro.
     * 
     * @return ijqldinspecaos
     */
    public idw.idwws.Ijqldinspecao[] getIjqldinspecaos() {
        return ijqldinspecaos;
    }


    /**
     * Sets the ijqldinspecaos value for this Ijmolpro.
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
     * Gets the ijqldprodinsplotes value for this Ijmolpro.
     * 
     * @return ijqldprodinsplotes
     */
    public idw.idwws.Ijqldprodinsplote[] getIjqldprodinsplotes() {
        return ijqldprodinsplotes;
    }


    /**
     * Sets the ijqldprodinsplotes value for this Ijmolpro.
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
     * Gets the ijreapesos value for this Ijmolpro.
     * 
     * @return ijreapesos
     */
    public idw.idwws.Ijreapeso[] getIjreapesos() {
        return ijreapesos;
    }


    /**
     * Sets the ijreapesos value for this Ijmolpro.
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
     * Gets the ijrefmans value for this Ijmolpro.
     * 
     * @return ijrefmans
     */
    public idw.idwws.Ijrefman[] getIjrefmans() {
        return ijrefmans;
    }


    /**
     * Sets the ijrefmans value for this Ijmolpro.
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
     * Gets the ijtbpro value for this Ijmolpro.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijmolpro.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the ijtbusu value for this Ijmolpro.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijmolpro.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the pbrutomedio value for this Ijmolpro.
     * 
     * @return pbrutomedio
     */
    public java.lang.Double getPbrutomedio() {
        return pbrutomedio;
    }


    /**
     * Sets the pbrutomedio value for this Ijmolpro.
     * 
     * @param pbrutomedio
     */
    public void setPbrutomedio(java.lang.Double pbrutomedio) {
        this.pbrutomedio = pbrutomedio;
    }


    /**
     * Gets the pliquidomedio value for this Ijmolpro.
     * 
     * @return pliquidomedio
     */
    public java.lang.Double getPliquidomedio() {
        return pliquidomedio;
    }


    /**
     * Sets the pliquidomedio value for this Ijmolpro.
     * 
     * @param pliquidomedio
     */
    public void setPliquidomedio(java.lang.Double pliquidomedio) {
        this.pliquidomedio = pliquidomedio;
    }


    /**
     * Gets the qtcavativas value for this Ijmolpro.
     * 
     * @return qtcavativas
     */
    public java.lang.Double getQtcavativas() {
        return qtcavativas;
    }


    /**
     * Sets the qtcavativas value for this Ijmolpro.
     * 
     * @param qtcavativas
     */
    public void setQtcavativas(java.lang.Double qtcavativas) {
        this.qtcavativas = qtcavativas;
    }


    /**
     * Gets the qtcavidades value for this Ijmolpro.
     * 
     * @return qtcavidades
     */
    public java.lang.Double getQtcavidades() {
        return qtcavidades;
    }


    /**
     * Sets the qtcavidades value for this Ijmolpro.
     * 
     * @param qtcavidades
     */
    public void setQtcavidades(java.lang.Double qtcavidades) {
        this.qtcavidades = qtcavidades;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmolpro)) return false;
        Ijmolpro other = (Ijmolpro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdidentificacao==null && other.getCdidentificacao()==null) || 
             (this.cdidentificacao!=null &&
              this.cdidentificacao.equals(other.getCdidentificacao()))) &&
            ((this.dthrfval==null && other.getDthrfval()==null) || 
             (this.dthrfval!=null &&
              this.dthrfval.equals(other.getDthrfval()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijctrlresnegqld1S==null && other.getIjctrlresnegqld1S()==null) || 
             (this.ijctrlresnegqld1S!=null &&
              java.util.Arrays.equals(this.ijctrlresnegqld1S, other.getIjctrlresnegqld1S()))) &&
            ((this.ijctrlresnegqld2S==null && other.getIjctrlresnegqld2S()==null) || 
             (this.ijctrlresnegqld2S!=null &&
              java.util.Arrays.equals(this.ijctrlresnegqld2S, other.getIjctrlresnegqld2S()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijinspecaos==null && other.getIjinspecaos()==null) || 
             (this.ijinspecaos!=null &&
              java.util.Arrays.equals(this.ijinspecaos, other.getIjinspecaos()))) &&
            ((this.ijmolproagrups==null && other.getIjmolproagrups()==null) || 
             (this.ijmolproagrups!=null &&
              java.util.Arrays.equals(this.ijmolproagrups, other.getIjmolproagrups()))) &&
            ((this.ijmolproidcavs==null && other.getIjmolproidcavs()==null) || 
             (this.ijmolproidcavs!=null &&
              java.util.Arrays.equals(this.ijmolproidcavs, other.getIjmolproidcavs()))) &&
            ((this.ijqldinspecaos==null && other.getIjqldinspecaos()==null) || 
             (this.ijqldinspecaos!=null &&
              java.util.Arrays.equals(this.ijqldinspecaos, other.getIjqldinspecaos()))) &&
            ((this.ijqldprodinsplotes==null && other.getIjqldprodinsplotes()==null) || 
             (this.ijqldprodinsplotes!=null &&
              java.util.Arrays.equals(this.ijqldprodinsplotes, other.getIjqldprodinsplotes()))) &&
            ((this.ijreapesos==null && other.getIjreapesos()==null) || 
             (this.ijreapesos!=null &&
              java.util.Arrays.equals(this.ijreapesos, other.getIjreapesos()))) &&
            ((this.ijrefmans==null && other.getIjrefmans()==null) || 
             (this.ijrefmans!=null &&
              java.util.Arrays.equals(this.ijrefmans, other.getIjrefmans()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.pbrutomedio==null && other.getPbrutomedio()==null) || 
             (this.pbrutomedio!=null &&
              this.pbrutomedio.equals(other.getPbrutomedio()))) &&
            ((this.pliquidomedio==null && other.getPliquidomedio()==null) || 
             (this.pliquidomedio!=null &&
              this.pliquidomedio.equals(other.getPliquidomedio()))) &&
            ((this.qtcavativas==null && other.getQtcavativas()==null) || 
             (this.qtcavativas!=null &&
              this.qtcavativas.equals(other.getQtcavativas()))) &&
            ((this.qtcavidades==null && other.getQtcavidades()==null) || 
             (this.qtcavidades!=null &&
              this.qtcavidades.equals(other.getQtcavidades())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCdidentificacao() != null) {
            _hashCode += getCdidentificacao().hashCode();
        }
        if (getDthrfval() != null) {
            _hashCode += getDthrfval().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
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
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
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
        if (getIjmolproagrups() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmolproagrups());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmolproagrups(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmolproidcavs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmolproidcavs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmolproidcavs(), i);
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
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getPbrutomedio() != null) {
            _hashCode += getPbrutomedio().hashCode();
        }
        if (getPliquidomedio() != null) {
            _hashCode += getPliquidomedio().hashCode();
        }
        if (getQtcavativas() != null) {
            _hashCode += getQtcavativas().hashCode();
        }
        if (getQtcavidades() != null) {
            _hashCode += getQtcavidades().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmolpro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolpro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdidentificacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdidentificacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfval");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfval"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("ijestmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("ijmolproagrups");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolproagrups"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproagrup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmolproidcavs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmolproidcavs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmolproidcav"));
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
        elemField.setFieldName("ijreapesos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapesos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapeso"));
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
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pbrutomedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pbrutomedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pliquidomedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pliquidomedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcavativas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcavativas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcavidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcavidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
