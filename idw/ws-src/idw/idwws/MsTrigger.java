/**
 * MsTrigger.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MsTrigger  extends idw.idwws.MsTriggerTemplate  implements java.io.Serializable {
    private idw.idwws.DwFolha dwFolha;

    private java.math.BigDecimal idTrigger;

    private idw.idwws.MsDetector msDetector;

    private idw.idwws.MsInd msInd;

    private idw.idwws.MsTpevt msTpevt;

    private idw.idwws.OmPt omPt;

    private idw.idwws.OmTppt omTppt;

    private java.math.BigDecimal operadorlogico;

    private java.math.BigDecimal ordem;

    private java.math.BigDecimal qtCiclos;

    private java.math.BigDecimal vlInd;

    public MsTrigger() {
    }

    public MsTrigger(
           idw.idwws.DwFolha dwFolha,
           java.math.BigDecimal idTrigger,
           idw.idwws.MsDetector msDetector,
           idw.idwws.MsInd msInd,
           idw.idwws.MsTpevt msTpevt,
           idw.idwws.OmPt omPt,
           idw.idwws.OmTppt omTppt,
           java.math.BigDecimal operadorlogico,
           java.math.BigDecimal ordem,
           java.math.BigDecimal qtCiclos,
           java.math.BigDecimal vlInd) {
        this.dwFolha = dwFolha;
        this.idTrigger = idTrigger;
        this.msDetector = msDetector;
        this.msInd = msInd;
        this.msTpevt = msTpevt;
        this.omPt = omPt;
        this.omTppt = omTppt;
        this.operadorlogico = operadorlogico;
        this.ordem = ordem;
        this.qtCiclos = qtCiclos;
        this.vlInd = vlInd;
    }


    /**
     * Gets the dwFolha value for this MsTrigger.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this MsTrigger.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the idTrigger value for this MsTrigger.
     * 
     * @return idTrigger
     */
    public java.math.BigDecimal getIdTrigger() {
        return idTrigger;
    }


    /**
     * Sets the idTrigger value for this MsTrigger.
     * 
     * @param idTrigger
     */
    public void setIdTrigger(java.math.BigDecimal idTrigger) {
        this.idTrigger = idTrigger;
    }


    /**
     * Gets the msDetector value for this MsTrigger.
     * 
     * @return msDetector
     */
    public idw.idwws.MsDetector getMsDetector() {
        return msDetector;
    }


    /**
     * Sets the msDetector value for this MsTrigger.
     * 
     * @param msDetector
     */
    public void setMsDetector(idw.idwws.MsDetector msDetector) {
        this.msDetector = msDetector;
    }


    /**
     * Gets the msInd value for this MsTrigger.
     * 
     * @return msInd
     */
    public idw.idwws.MsInd getMsInd() {
        return msInd;
    }


    /**
     * Sets the msInd value for this MsTrigger.
     * 
     * @param msInd
     */
    public void setMsInd(idw.idwws.MsInd msInd) {
        this.msInd = msInd;
    }


    /**
     * Gets the msTpevt value for this MsTrigger.
     * 
     * @return msTpevt
     */
    public idw.idwws.MsTpevt getMsTpevt() {
        return msTpevt;
    }


    /**
     * Sets the msTpevt value for this MsTrigger.
     * 
     * @param msTpevt
     */
    public void setMsTpevt(idw.idwws.MsTpevt msTpevt) {
        this.msTpevt = msTpevt;
    }


    /**
     * Gets the omPt value for this MsTrigger.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this MsTrigger.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the omTppt value for this MsTrigger.
     * 
     * @return omTppt
     */
    public idw.idwws.OmTppt getOmTppt() {
        return omTppt;
    }


    /**
     * Sets the omTppt value for this MsTrigger.
     * 
     * @param omTppt
     */
    public void setOmTppt(idw.idwws.OmTppt omTppt) {
        this.omTppt = omTppt;
    }


    /**
     * Gets the operadorlogico value for this MsTrigger.
     * 
     * @return operadorlogico
     */
    public java.math.BigDecimal getOperadorlogico() {
        return operadorlogico;
    }


    /**
     * Sets the operadorlogico value for this MsTrigger.
     * 
     * @param operadorlogico
     */
    public void setOperadorlogico(java.math.BigDecimal operadorlogico) {
        this.operadorlogico = operadorlogico;
    }


    /**
     * Gets the ordem value for this MsTrigger.
     * 
     * @return ordem
     */
    public java.math.BigDecimal getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this MsTrigger.
     * 
     * @param ordem
     */
    public void setOrdem(java.math.BigDecimal ordem) {
        this.ordem = ordem;
    }


    /**
     * Gets the qtCiclos value for this MsTrigger.
     * 
     * @return qtCiclos
     */
    public java.math.BigDecimal getQtCiclos() {
        return qtCiclos;
    }


    /**
     * Sets the qtCiclos value for this MsTrigger.
     * 
     * @param qtCiclos
     */
    public void setQtCiclos(java.math.BigDecimal qtCiclos) {
        this.qtCiclos = qtCiclos;
    }


    /**
     * Gets the vlInd value for this MsTrigger.
     * 
     * @return vlInd
     */
    public java.math.BigDecimal getVlInd() {
        return vlInd;
    }


    /**
     * Sets the vlInd value for this MsTrigger.
     * 
     * @param vlInd
     */
    public void setVlInd(java.math.BigDecimal vlInd) {
        this.vlInd = vlInd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MsTrigger)) return false;
        MsTrigger other = (MsTrigger) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.idTrigger==null && other.getIdTrigger()==null) || 
             (this.idTrigger!=null &&
              this.idTrigger.equals(other.getIdTrigger()))) &&
            ((this.msDetector==null && other.getMsDetector()==null) || 
             (this.msDetector!=null &&
              this.msDetector.equals(other.getMsDetector()))) &&
            ((this.msInd==null && other.getMsInd()==null) || 
             (this.msInd!=null &&
              this.msInd.equals(other.getMsInd()))) &&
            ((this.msTpevt==null && other.getMsTpevt()==null) || 
             (this.msTpevt!=null &&
              this.msTpevt.equals(other.getMsTpevt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.omTppt==null && other.getOmTppt()==null) || 
             (this.omTppt!=null &&
              this.omTppt.equals(other.getOmTppt()))) &&
            ((this.operadorlogico==null && other.getOperadorlogico()==null) || 
             (this.operadorlogico!=null &&
              this.operadorlogico.equals(other.getOperadorlogico()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem()))) &&
            ((this.qtCiclos==null && other.getQtCiclos()==null) || 
             (this.qtCiclos!=null &&
              this.qtCiclos.equals(other.getQtCiclos()))) &&
            ((this.vlInd==null && other.getVlInd()==null) || 
             (this.vlInd!=null &&
              this.vlInd.equals(other.getVlInd())));
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
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getIdTrigger() != null) {
            _hashCode += getIdTrigger().hashCode();
        }
        if (getMsDetector() != null) {
            _hashCode += getMsDetector().hashCode();
        }
        if (getMsInd() != null) {
            _hashCode += getMsInd().hashCode();
        }
        if (getMsTpevt() != null) {
            _hashCode += getMsTpevt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getOmTppt() != null) {
            _hashCode += getOmTppt().hashCode();
        }
        if (getOperadorlogico() != null) {
            _hashCode += getOperadorlogico().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
        }
        if (getQtCiclos() != null) {
            _hashCode += getQtCiclos().hashCode();
        }
        if (getVlInd() != null) {
            _hashCode += getVlInd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MsTrigger.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msTrigger"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTrigger");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTrigger"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msDetector");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msDetector"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msDetector"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msInd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msInd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msTpevt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msTpevt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "msTpevt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omTppt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omTppt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omTppt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operadorlogico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operadorlogico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtCiclos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtCiclos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vlInd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vlInd"));
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
