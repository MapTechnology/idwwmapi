/**
 * Ijplanop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijplanop  implements java.io.Serializable {
    private java.util.Calendar dthrfimplan;

    private java.util.Calendar dthrinicioreal;

    private java.util.Calendar dthrsaida;

    private java.lang.Double eficiencia;

    private idw.idwws.IjplanopId id;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbinj ijtbinj;

    private java.math.BigDecimal situacaoplano;

    private java.math.BigDecimal tmpsetup;

    public Ijplanop() {
    }

    public Ijplanop(
           java.util.Calendar dthrfimplan,
           java.util.Calendar dthrinicioreal,
           java.util.Calendar dthrsaida,
           java.lang.Double eficiencia,
           idw.idwws.IjplanopId id,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbinj ijtbinj,
           java.math.BigDecimal situacaoplano,
           java.math.BigDecimal tmpsetup) {
           this.dthrfimplan = dthrfimplan;
           this.dthrinicioreal = dthrinicioreal;
           this.dthrsaida = dthrsaida;
           this.eficiencia = eficiencia;
           this.id = id;
           this.ijestmol = ijestmol;
           this.ijop = ijop;
           this.ijtbinj = ijtbinj;
           this.situacaoplano = situacaoplano;
           this.tmpsetup = tmpsetup;
    }


    /**
     * Gets the dthrfimplan value for this Ijplanop.
     * 
     * @return dthrfimplan
     */
    public java.util.Calendar getDthrfimplan() {
        return dthrfimplan;
    }


    /**
     * Sets the dthrfimplan value for this Ijplanop.
     * 
     * @param dthrfimplan
     */
    public void setDthrfimplan(java.util.Calendar dthrfimplan) {
        this.dthrfimplan = dthrfimplan;
    }


    /**
     * Gets the dthrinicioreal value for this Ijplanop.
     * 
     * @return dthrinicioreal
     */
    public java.util.Calendar getDthrinicioreal() {
        return dthrinicioreal;
    }


    /**
     * Sets the dthrinicioreal value for this Ijplanop.
     * 
     * @param dthrinicioreal
     */
    public void setDthrinicioreal(java.util.Calendar dthrinicioreal) {
        this.dthrinicioreal = dthrinicioreal;
    }


    /**
     * Gets the dthrsaida value for this Ijplanop.
     * 
     * @return dthrsaida
     */
    public java.util.Calendar getDthrsaida() {
        return dthrsaida;
    }


    /**
     * Sets the dthrsaida value for this Ijplanop.
     * 
     * @param dthrsaida
     */
    public void setDthrsaida(java.util.Calendar dthrsaida) {
        this.dthrsaida = dthrsaida;
    }


    /**
     * Gets the eficiencia value for this Ijplanop.
     * 
     * @return eficiencia
     */
    public java.lang.Double getEficiencia() {
        return eficiencia;
    }


    /**
     * Sets the eficiencia value for this Ijplanop.
     * 
     * @param eficiencia
     */
    public void setEficiencia(java.lang.Double eficiencia) {
        this.eficiencia = eficiencia;
    }


    /**
     * Gets the id value for this Ijplanop.
     * 
     * @return id
     */
    public idw.idwws.IjplanopId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijplanop.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjplanopId id) {
        this.id = id;
    }


    /**
     * Gets the ijestmol value for this Ijplanop.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijplanop.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijop value for this Ijplanop.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijplanop.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbinj value for this Ijplanop.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijplanop.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the situacaoplano value for this Ijplanop.
     * 
     * @return situacaoplano
     */
    public java.math.BigDecimal getSituacaoplano() {
        return situacaoplano;
    }


    /**
     * Sets the situacaoplano value for this Ijplanop.
     * 
     * @param situacaoplano
     */
    public void setSituacaoplano(java.math.BigDecimal situacaoplano) {
        this.situacaoplano = situacaoplano;
    }


    /**
     * Gets the tmpsetup value for this Ijplanop.
     * 
     * @return tmpsetup
     */
    public java.math.BigDecimal getTmpsetup() {
        return tmpsetup;
    }


    /**
     * Sets the tmpsetup value for this Ijplanop.
     * 
     * @param tmpsetup
     */
    public void setTmpsetup(java.math.BigDecimal tmpsetup) {
        this.tmpsetup = tmpsetup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijplanop)) return false;
        Ijplanop other = (Ijplanop) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfimplan==null && other.getDthrfimplan()==null) || 
             (this.dthrfimplan!=null &&
              this.dthrfimplan.equals(other.getDthrfimplan()))) &&
            ((this.dthrinicioreal==null && other.getDthrinicioreal()==null) || 
             (this.dthrinicioreal!=null &&
              this.dthrinicioreal.equals(other.getDthrinicioreal()))) &&
            ((this.dthrsaida==null && other.getDthrsaida()==null) || 
             (this.dthrsaida!=null &&
              this.dthrsaida.equals(other.getDthrsaida()))) &&
            ((this.eficiencia==null && other.getEficiencia()==null) || 
             (this.eficiencia!=null &&
              this.eficiencia.equals(other.getEficiencia()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.situacaoplano==null && other.getSituacaoplano()==null) || 
             (this.situacaoplano!=null &&
              this.situacaoplano.equals(other.getSituacaoplano()))) &&
            ((this.tmpsetup==null && other.getTmpsetup()==null) || 
             (this.tmpsetup!=null &&
              this.tmpsetup.equals(other.getTmpsetup())));
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
        if (getDthrfimplan() != null) {
            _hashCode += getDthrfimplan().hashCode();
        }
        if (getDthrinicioreal() != null) {
            _hashCode += getDthrinicioreal().hashCode();
        }
        if (getDthrsaida() != null) {
            _hashCode += getDthrsaida().hashCode();
        }
        if (getEficiencia() != null) {
            _hashCode += getEficiencia().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getSituacaoplano() != null) {
            _hashCode += getSituacaoplano().hashCode();
        }
        if (getTmpsetup() != null) {
            _hashCode += getTmpsetup().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijplanop.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijplanop"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfimplan");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfimplan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinicioreal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinicioreal"));
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
        elemField.setFieldName("eficiencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficiencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijplanopId"));
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
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("situacaoplano");
        elemField.setXmlName(new javax.xml.namespace.QName("", "situacaoplano"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpsetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpsetup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
