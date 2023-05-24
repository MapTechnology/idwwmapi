/**
 * DwFolhamedtemphorcfg.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolhamedtemphorcfg  extends idw.idwws.DwFolhamedtemphorcfgTemplate  implements java.io.Serializable {
    private java.lang.String corIntervalo;

    private java.lang.String dsCfg;

    private idw.idwws.DwFolhamedtemhor dwFolhamedtemhor;

    private java.math.BigDecimal idFolhamedtemphorcfg;

    private java.math.BigDecimal limInfTemp;

    private java.math.BigDecimal limSupTemp;

    public DwFolhamedtemphorcfg() {
    }

    public DwFolhamedtemphorcfg(
           java.lang.String corIntervalo,
           java.lang.String dsCfg,
           idw.idwws.DwFolhamedtemhor dwFolhamedtemhor,
           java.math.BigDecimal idFolhamedtemphorcfg,
           java.math.BigDecimal limInfTemp,
           java.math.BigDecimal limSupTemp) {
        this.corIntervalo = corIntervalo;
        this.dsCfg = dsCfg;
        this.dwFolhamedtemhor = dwFolhamedtemhor;
        this.idFolhamedtemphorcfg = idFolhamedtemphorcfg;
        this.limInfTemp = limInfTemp;
        this.limSupTemp = limSupTemp;
    }


    /**
     * Gets the corIntervalo value for this DwFolhamedtemphorcfg.
     * 
     * @return corIntervalo
     */
    public java.lang.String getCorIntervalo() {
        return corIntervalo;
    }


    /**
     * Sets the corIntervalo value for this DwFolhamedtemphorcfg.
     * 
     * @param corIntervalo
     */
    public void setCorIntervalo(java.lang.String corIntervalo) {
        this.corIntervalo = corIntervalo;
    }


    /**
     * Gets the dsCfg value for this DwFolhamedtemphorcfg.
     * 
     * @return dsCfg
     */
    public java.lang.String getDsCfg() {
        return dsCfg;
    }


    /**
     * Sets the dsCfg value for this DwFolhamedtemphorcfg.
     * 
     * @param dsCfg
     */
    public void setDsCfg(java.lang.String dsCfg) {
        this.dsCfg = dsCfg;
    }


    /**
     * Gets the dwFolhamedtemhor value for this DwFolhamedtemphorcfg.
     * 
     * @return dwFolhamedtemhor
     */
    public idw.idwws.DwFolhamedtemhor getDwFolhamedtemhor() {
        return dwFolhamedtemhor;
    }


    /**
     * Sets the dwFolhamedtemhor value for this DwFolhamedtemphorcfg.
     * 
     * @param dwFolhamedtemhor
     */
    public void setDwFolhamedtemhor(idw.idwws.DwFolhamedtemhor dwFolhamedtemhor) {
        this.dwFolhamedtemhor = dwFolhamedtemhor;
    }


    /**
     * Gets the idFolhamedtemphorcfg value for this DwFolhamedtemphorcfg.
     * 
     * @return idFolhamedtemphorcfg
     */
    public java.math.BigDecimal getIdFolhamedtemphorcfg() {
        return idFolhamedtemphorcfg;
    }


    /**
     * Sets the idFolhamedtemphorcfg value for this DwFolhamedtemphorcfg.
     * 
     * @param idFolhamedtemphorcfg
     */
    public void setIdFolhamedtemphorcfg(java.math.BigDecimal idFolhamedtemphorcfg) {
        this.idFolhamedtemphorcfg = idFolhamedtemphorcfg;
    }


    /**
     * Gets the limInfTemp value for this DwFolhamedtemphorcfg.
     * 
     * @return limInfTemp
     */
    public java.math.BigDecimal getLimInfTemp() {
        return limInfTemp;
    }


    /**
     * Sets the limInfTemp value for this DwFolhamedtemphorcfg.
     * 
     * @param limInfTemp
     */
    public void setLimInfTemp(java.math.BigDecimal limInfTemp) {
        this.limInfTemp = limInfTemp;
    }


    /**
     * Gets the limSupTemp value for this DwFolhamedtemphorcfg.
     * 
     * @return limSupTemp
     */
    public java.math.BigDecimal getLimSupTemp() {
        return limSupTemp;
    }


    /**
     * Sets the limSupTemp value for this DwFolhamedtemphorcfg.
     * 
     * @param limSupTemp
     */
    public void setLimSupTemp(java.math.BigDecimal limSupTemp) {
        this.limSupTemp = limSupTemp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolhamedtemphorcfg)) return false;
        DwFolhamedtemphorcfg other = (DwFolhamedtemphorcfg) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.corIntervalo==null && other.getCorIntervalo()==null) || 
             (this.corIntervalo!=null &&
              this.corIntervalo.equals(other.getCorIntervalo()))) &&
            ((this.dsCfg==null && other.getDsCfg()==null) || 
             (this.dsCfg!=null &&
              this.dsCfg.equals(other.getDsCfg()))) &&
            ((this.dwFolhamedtemhor==null && other.getDwFolhamedtemhor()==null) || 
             (this.dwFolhamedtemhor!=null &&
              this.dwFolhamedtemhor.equals(other.getDwFolhamedtemhor()))) &&
            ((this.idFolhamedtemphorcfg==null && other.getIdFolhamedtemphorcfg()==null) || 
             (this.idFolhamedtemphorcfg!=null &&
              this.idFolhamedtemphorcfg.equals(other.getIdFolhamedtemphorcfg()))) &&
            ((this.limInfTemp==null && other.getLimInfTemp()==null) || 
             (this.limInfTemp!=null &&
              this.limInfTemp.equals(other.getLimInfTemp()))) &&
            ((this.limSupTemp==null && other.getLimSupTemp()==null) || 
             (this.limSupTemp!=null &&
              this.limSupTemp.equals(other.getLimSupTemp())));
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
        if (getCorIntervalo() != null) {
            _hashCode += getCorIntervalo().hashCode();
        }
        if (getDsCfg() != null) {
            _hashCode += getDsCfg().hashCode();
        }
        if (getDwFolhamedtemhor() != null) {
            _hashCode += getDwFolhamedtemhor().hashCode();
        }
        if (getIdFolhamedtemphorcfg() != null) {
            _hashCode += getIdFolhamedtemphorcfg().hashCode();
        }
        if (getLimInfTemp() != null) {
            _hashCode += getLimInfTemp().hashCode();
        }
        if (getLimSupTemp() != null) {
            _hashCode += getLimSupTemp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolhamedtemphorcfg.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamedtemphorcfg"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corIntervalo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corIntervalo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsCfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsCfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhamedtemhor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhamedtemhor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamedtemhor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolhamedtemphorcfg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolhamedtemphorcfg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limInfTemp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "limInfTemp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("limSupTemp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "limSupTemp"));
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
