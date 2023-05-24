/**
 * Ijfictec.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijfictec  implements java.io.Serializable {
    private double ciclopadrao;

    private java.util.Calendar dthrfvalcic;

    private java.util.Calendar dthrivalestru;

    private idw.idwws.IjfictecId id;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijfictecautorizmod[] ijfictecautorizmods;

    private idw.idwws.Ijfictectmpsemesp[] ijfictectmpsemesps;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.lang.String justificativa;

    private java.math.BigDecimal ordpriorid;

    private double varmax;

    private double varmin;

    public Ijfictec() {
    }

    public Ijfictec(
           double ciclopadrao,
           java.util.Calendar dthrfvalcic,
           java.util.Calendar dthrivalestru,
           idw.idwws.IjfictecId id,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijfictecautorizmod[] ijfictecautorizmods,
           idw.idwws.Ijfictectmpsemesp[] ijfictectmpsemesps,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbusu ijtbusu,
           java.lang.String justificativa,
           java.math.BigDecimal ordpriorid,
           double varmax,
           double varmin) {
           this.ciclopadrao = ciclopadrao;
           this.dthrfvalcic = dthrfvalcic;
           this.dthrivalestru = dthrivalestru;
           this.id = id;
           this.ijestmol = ijestmol;
           this.ijfictecautorizmods = ijfictecautorizmods;
           this.ijfictectmpsemesps = ijfictectmpsemesps;
           this.ijtbinj = ijtbinj;
           this.ijtbusu = ijtbusu;
           this.justificativa = justificativa;
           this.ordpriorid = ordpriorid;
           this.varmax = varmax;
           this.varmin = varmin;
    }


    /**
     * Gets the ciclopadrao value for this Ijfictec.
     * 
     * @return ciclopadrao
     */
    public double getCiclopadrao() {
        return ciclopadrao;
    }


    /**
     * Sets the ciclopadrao value for this Ijfictec.
     * 
     * @param ciclopadrao
     */
    public void setCiclopadrao(double ciclopadrao) {
        this.ciclopadrao = ciclopadrao;
    }


    /**
     * Gets the dthrfvalcic value for this Ijfictec.
     * 
     * @return dthrfvalcic
     */
    public java.util.Calendar getDthrfvalcic() {
        return dthrfvalcic;
    }


    /**
     * Sets the dthrfvalcic value for this Ijfictec.
     * 
     * @param dthrfvalcic
     */
    public void setDthrfvalcic(java.util.Calendar dthrfvalcic) {
        this.dthrfvalcic = dthrfvalcic;
    }


    /**
     * Gets the dthrivalestru value for this Ijfictec.
     * 
     * @return dthrivalestru
     */
    public java.util.Calendar getDthrivalestru() {
        return dthrivalestru;
    }


    /**
     * Sets the dthrivalestru value for this Ijfictec.
     * 
     * @param dthrivalestru
     */
    public void setDthrivalestru(java.util.Calendar dthrivalestru) {
        this.dthrivalestru = dthrivalestru;
    }


    /**
     * Gets the id value for this Ijfictec.
     * 
     * @return id
     */
    public idw.idwws.IjfictecId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijfictec.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjfictecId id) {
        this.id = id;
    }


    /**
     * Gets the ijestmol value for this Ijfictec.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijfictec.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijfictecautorizmods value for this Ijfictec.
     * 
     * @return ijfictecautorizmods
     */
    public idw.idwws.Ijfictecautorizmod[] getIjfictecautorizmods() {
        return ijfictecautorizmods;
    }


    /**
     * Sets the ijfictecautorizmods value for this Ijfictec.
     * 
     * @param ijfictecautorizmods
     */
    public void setIjfictecautorizmods(idw.idwws.Ijfictecautorizmod[] ijfictecautorizmods) {
        this.ijfictecautorizmods = ijfictecautorizmods;
    }

    public idw.idwws.Ijfictecautorizmod getIjfictecautorizmods(int i) {
        return this.ijfictecautorizmods[i];
    }

    public void setIjfictecautorizmods(int i, idw.idwws.Ijfictecautorizmod _value) {
        this.ijfictecautorizmods[i] = _value;
    }


    /**
     * Gets the ijfictectmpsemesps value for this Ijfictec.
     * 
     * @return ijfictectmpsemesps
     */
    public idw.idwws.Ijfictectmpsemesp[] getIjfictectmpsemesps() {
        return ijfictectmpsemesps;
    }


    /**
     * Sets the ijfictectmpsemesps value for this Ijfictec.
     * 
     * @param ijfictectmpsemesps
     */
    public void setIjfictectmpsemesps(idw.idwws.Ijfictectmpsemesp[] ijfictectmpsemesps) {
        this.ijfictectmpsemesps = ijfictectmpsemesps;
    }

    public idw.idwws.Ijfictectmpsemesp getIjfictectmpsemesps(int i) {
        return this.ijfictectmpsemesps[i];
    }

    public void setIjfictectmpsemesps(int i, idw.idwws.Ijfictectmpsemesp _value) {
        this.ijfictectmpsemesps[i] = _value;
    }


    /**
     * Gets the ijtbinj value for this Ijfictec.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijfictec.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbusu value for this Ijfictec.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijfictec.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the justificativa value for this Ijfictec.
     * 
     * @return justificativa
     */
    public java.lang.String getJustificativa() {
        return justificativa;
    }


    /**
     * Sets the justificativa value for this Ijfictec.
     * 
     * @param justificativa
     */
    public void setJustificativa(java.lang.String justificativa) {
        this.justificativa = justificativa;
    }


    /**
     * Gets the ordpriorid value for this Ijfictec.
     * 
     * @return ordpriorid
     */
    public java.math.BigDecimal getOrdpriorid() {
        return ordpriorid;
    }


    /**
     * Sets the ordpriorid value for this Ijfictec.
     * 
     * @param ordpriorid
     */
    public void setOrdpriorid(java.math.BigDecimal ordpriorid) {
        this.ordpriorid = ordpriorid;
    }


    /**
     * Gets the varmax value for this Ijfictec.
     * 
     * @return varmax
     */
    public double getVarmax() {
        return varmax;
    }


    /**
     * Sets the varmax value for this Ijfictec.
     * 
     * @param varmax
     */
    public void setVarmax(double varmax) {
        this.varmax = varmax;
    }


    /**
     * Gets the varmin value for this Ijfictec.
     * 
     * @return varmin
     */
    public double getVarmin() {
        return varmin;
    }


    /**
     * Sets the varmin value for this Ijfictec.
     * 
     * @param varmin
     */
    public void setVarmin(double varmin) {
        this.varmin = varmin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijfictec)) return false;
        Ijfictec other = (Ijfictec) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ciclopadrao == other.getCiclopadrao() &&
            ((this.dthrfvalcic==null && other.getDthrfvalcic()==null) || 
             (this.dthrfvalcic!=null &&
              this.dthrfvalcic.equals(other.getDthrfvalcic()))) &&
            ((this.dthrivalestru==null && other.getDthrivalestru()==null) || 
             (this.dthrivalestru!=null &&
              this.dthrivalestru.equals(other.getDthrivalestru()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijfictecautorizmods==null && other.getIjfictecautorizmods()==null) || 
             (this.ijfictecautorizmods!=null &&
              java.util.Arrays.equals(this.ijfictecautorizmods, other.getIjfictecautorizmods()))) &&
            ((this.ijfictectmpsemesps==null && other.getIjfictectmpsemesps()==null) || 
             (this.ijfictectmpsemesps!=null &&
              java.util.Arrays.equals(this.ijfictectmpsemesps, other.getIjfictectmpsemesps()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.justificativa==null && other.getJustificativa()==null) || 
             (this.justificativa!=null &&
              this.justificativa.equals(other.getJustificativa()))) &&
            ((this.ordpriorid==null && other.getOrdpriorid()==null) || 
             (this.ordpriorid!=null &&
              this.ordpriorid.equals(other.getOrdpriorid()))) &&
            this.varmax == other.getVarmax() &&
            this.varmin == other.getVarmin();
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
        _hashCode += new Double(getCiclopadrao()).hashCode();
        if (getDthrfvalcic() != null) {
            _hashCode += getDthrfvalcic().hashCode();
        }
        if (getDthrivalestru() != null) {
            _hashCode += getDthrivalestru().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjfictecautorizmods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfictecautorizmods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfictecautorizmods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjfictectmpsemesps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjfictectmpsemesps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjfictectmpsemesps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getJustificativa() != null) {
            _hashCode += getJustificativa().hashCode();
        }
        if (getOrdpriorid() != null) {
            _hashCode += getOrdpriorid().hashCode();
        }
        _hashCode += new Double(getVarmax()).hashCode();
        _hashCode += new Double(getVarmin()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijfictec.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictec"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciclopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciclopadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfvalcic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfvalcic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalestru");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalestru"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictecId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfictecautorizmods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfictecautorizmods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictecautorizmod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijfictectmpsemesps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijfictectmpsemesps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijfictectmpsemesp"));
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
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("justificativa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "justificativa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordpriorid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordpriorid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varmax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "varmax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varmin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "varmin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
