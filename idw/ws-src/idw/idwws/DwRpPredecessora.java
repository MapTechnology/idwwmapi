/**
 * DwRpPredecessora.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwRpPredecessora  extends idw.idwws.DwRpPredecessoraTemplate  implements java.io.Serializable {
    private idw.idwws.DwRotapasso dwRotapassoByIdRotapassoFilho;

    private idw.idwws.DwRotapasso dwRotapassoByIdRotapassoPai;

    private long idRpPredecessora;

    private java.lang.Boolean isAceitaSeC;

    private java.lang.Boolean isAceitaSeNc;

    private java.lang.Boolean isEspelho;

    public DwRpPredecessora() {
    }

    public DwRpPredecessora(
           idw.idwws.DwRotapasso dwRotapassoByIdRotapassoFilho,
           idw.idwws.DwRotapasso dwRotapassoByIdRotapassoPai,
           long idRpPredecessora,
           java.lang.Boolean isAceitaSeC,
           java.lang.Boolean isAceitaSeNc,
           java.lang.Boolean isEspelho) {
        this.dwRotapassoByIdRotapassoFilho = dwRotapassoByIdRotapassoFilho;
        this.dwRotapassoByIdRotapassoPai = dwRotapassoByIdRotapassoPai;
        this.idRpPredecessora = idRpPredecessora;
        this.isAceitaSeC = isAceitaSeC;
        this.isAceitaSeNc = isAceitaSeNc;
        this.isEspelho = isEspelho;
    }


    /**
     * Gets the dwRotapassoByIdRotapassoFilho value for this DwRpPredecessora.
     * 
     * @return dwRotapassoByIdRotapassoFilho
     */
    public idw.idwws.DwRotapasso getDwRotapassoByIdRotapassoFilho() {
        return dwRotapassoByIdRotapassoFilho;
    }


    /**
     * Sets the dwRotapassoByIdRotapassoFilho value for this DwRpPredecessora.
     * 
     * @param dwRotapassoByIdRotapassoFilho
     */
    public void setDwRotapassoByIdRotapassoFilho(idw.idwws.DwRotapasso dwRotapassoByIdRotapassoFilho) {
        this.dwRotapassoByIdRotapassoFilho = dwRotapassoByIdRotapassoFilho;
    }


    /**
     * Gets the dwRotapassoByIdRotapassoPai value for this DwRpPredecessora.
     * 
     * @return dwRotapassoByIdRotapassoPai
     */
    public idw.idwws.DwRotapasso getDwRotapassoByIdRotapassoPai() {
        return dwRotapassoByIdRotapassoPai;
    }


    /**
     * Sets the dwRotapassoByIdRotapassoPai value for this DwRpPredecessora.
     * 
     * @param dwRotapassoByIdRotapassoPai
     */
    public void setDwRotapassoByIdRotapassoPai(idw.idwws.DwRotapasso dwRotapassoByIdRotapassoPai) {
        this.dwRotapassoByIdRotapassoPai = dwRotapassoByIdRotapassoPai;
    }


    /**
     * Gets the idRpPredecessora value for this DwRpPredecessora.
     * 
     * @return idRpPredecessora
     */
    public long getIdRpPredecessora() {
        return idRpPredecessora;
    }


    /**
     * Sets the idRpPredecessora value for this DwRpPredecessora.
     * 
     * @param idRpPredecessora
     */
    public void setIdRpPredecessora(long idRpPredecessora) {
        this.idRpPredecessora = idRpPredecessora;
    }


    /**
     * Gets the isAceitaSeC value for this DwRpPredecessora.
     * 
     * @return isAceitaSeC
     */
    public java.lang.Boolean getIsAceitaSeC() {
        return isAceitaSeC;
    }


    /**
     * Sets the isAceitaSeC value for this DwRpPredecessora.
     * 
     * @param isAceitaSeC
     */
    public void setIsAceitaSeC(java.lang.Boolean isAceitaSeC) {
        this.isAceitaSeC = isAceitaSeC;
    }


    /**
     * Gets the isAceitaSeNc value for this DwRpPredecessora.
     * 
     * @return isAceitaSeNc
     */
    public java.lang.Boolean getIsAceitaSeNc() {
        return isAceitaSeNc;
    }


    /**
     * Sets the isAceitaSeNc value for this DwRpPredecessora.
     * 
     * @param isAceitaSeNc
     */
    public void setIsAceitaSeNc(java.lang.Boolean isAceitaSeNc) {
        this.isAceitaSeNc = isAceitaSeNc;
    }


    /**
     * Gets the isEspelho value for this DwRpPredecessora.
     * 
     * @return isEspelho
     */
    public java.lang.Boolean getIsEspelho() {
        return isEspelho;
    }


    /**
     * Sets the isEspelho value for this DwRpPredecessora.
     * 
     * @param isEspelho
     */
    public void setIsEspelho(java.lang.Boolean isEspelho) {
        this.isEspelho = isEspelho;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwRpPredecessora)) return false;
        DwRpPredecessora other = (DwRpPredecessora) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwRotapassoByIdRotapassoFilho==null && other.getDwRotapassoByIdRotapassoFilho()==null) || 
             (this.dwRotapassoByIdRotapassoFilho!=null &&
              this.dwRotapassoByIdRotapassoFilho.equals(other.getDwRotapassoByIdRotapassoFilho()))) &&
            ((this.dwRotapassoByIdRotapassoPai==null && other.getDwRotapassoByIdRotapassoPai()==null) || 
             (this.dwRotapassoByIdRotapassoPai!=null &&
              this.dwRotapassoByIdRotapassoPai.equals(other.getDwRotapassoByIdRotapassoPai()))) &&
            this.idRpPredecessora == other.getIdRpPredecessora() &&
            ((this.isAceitaSeC==null && other.getIsAceitaSeC()==null) || 
             (this.isAceitaSeC!=null &&
              this.isAceitaSeC.equals(other.getIsAceitaSeC()))) &&
            ((this.isAceitaSeNc==null && other.getIsAceitaSeNc()==null) || 
             (this.isAceitaSeNc!=null &&
              this.isAceitaSeNc.equals(other.getIsAceitaSeNc()))) &&
            ((this.isEspelho==null && other.getIsEspelho()==null) || 
             (this.isEspelho!=null &&
              this.isEspelho.equals(other.getIsEspelho())));
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
        if (getDwRotapassoByIdRotapassoFilho() != null) {
            _hashCode += getDwRotapassoByIdRotapassoFilho().hashCode();
        }
        if (getDwRotapassoByIdRotapassoPai() != null) {
            _hashCode += getDwRotapassoByIdRotapassoPai().hashCode();
        }
        _hashCode += new Long(getIdRpPredecessora()).hashCode();
        if (getIsAceitaSeC() != null) {
            _hashCode += getIsAceitaSeC().hashCode();
        }
        if (getIsAceitaSeNc() != null) {
            _hashCode += getIsAceitaSeNc().hashCode();
        }
        if (getIsEspelho() != null) {
            _hashCode += getIsEspelho().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwRpPredecessora.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRpPredecessora"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapassoByIdRotapassoFilho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassoByIdRotapassoFilho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRotapassoByIdRotapassoPai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRotapassoByIdRotapassoPai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRotapasso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idRpPredecessora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idRpPredecessora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAceitaSeC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAceitaSeC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAceitaSeNc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAceitaSeNc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isEspelho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isEspelho"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
