/**
 * Ijgrpparaux.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpparaux  implements java.io.Serializable {
    private java.lang.String cdauxiliar;

    private java.lang.String cdcor;

    private java.lang.String cdgrupopar;

    private idw.idwws.Ijgrppar ijgrppar;

    private java.lang.String siglagrupo;

    public Ijgrpparaux() {
    }

    public Ijgrpparaux(
           java.lang.String cdauxiliar,
           java.lang.String cdcor,
           java.lang.String cdgrupopar,
           idw.idwws.Ijgrppar ijgrppar,
           java.lang.String siglagrupo) {
           this.cdauxiliar = cdauxiliar;
           this.cdcor = cdcor;
           this.cdgrupopar = cdgrupopar;
           this.ijgrppar = ijgrppar;
           this.siglagrupo = siglagrupo;
    }


    /**
     * Gets the cdauxiliar value for this Ijgrpparaux.
     * 
     * @return cdauxiliar
     */
    public java.lang.String getCdauxiliar() {
        return cdauxiliar;
    }


    /**
     * Sets the cdauxiliar value for this Ijgrpparaux.
     * 
     * @param cdauxiliar
     */
    public void setCdauxiliar(java.lang.String cdauxiliar) {
        this.cdauxiliar = cdauxiliar;
    }


    /**
     * Gets the cdcor value for this Ijgrpparaux.
     * 
     * @return cdcor
     */
    public java.lang.String getCdcor() {
        return cdcor;
    }


    /**
     * Sets the cdcor value for this Ijgrpparaux.
     * 
     * @param cdcor
     */
    public void setCdcor(java.lang.String cdcor) {
        this.cdcor = cdcor;
    }


    /**
     * Gets the cdgrupopar value for this Ijgrpparaux.
     * 
     * @return cdgrupopar
     */
    public java.lang.String getCdgrupopar() {
        return cdgrupopar;
    }


    /**
     * Sets the cdgrupopar value for this Ijgrpparaux.
     * 
     * @param cdgrupopar
     */
    public void setCdgrupopar(java.lang.String cdgrupopar) {
        this.cdgrupopar = cdgrupopar;
    }


    /**
     * Gets the ijgrppar value for this Ijgrpparaux.
     * 
     * @return ijgrppar
     */
    public idw.idwws.Ijgrppar getIjgrppar() {
        return ijgrppar;
    }


    /**
     * Sets the ijgrppar value for this Ijgrpparaux.
     * 
     * @param ijgrppar
     */
    public void setIjgrppar(idw.idwws.Ijgrppar ijgrppar) {
        this.ijgrppar = ijgrppar;
    }


    /**
     * Gets the siglagrupo value for this Ijgrpparaux.
     * 
     * @return siglagrupo
     */
    public java.lang.String getSiglagrupo() {
        return siglagrupo;
    }


    /**
     * Sets the siglagrupo value for this Ijgrpparaux.
     * 
     * @param siglagrupo
     */
    public void setSiglagrupo(java.lang.String siglagrupo) {
        this.siglagrupo = siglagrupo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpparaux)) return false;
        Ijgrpparaux other = (Ijgrpparaux) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdauxiliar==null && other.getCdauxiliar()==null) || 
             (this.cdauxiliar!=null &&
              this.cdauxiliar.equals(other.getCdauxiliar()))) &&
            ((this.cdcor==null && other.getCdcor()==null) || 
             (this.cdcor!=null &&
              this.cdcor.equals(other.getCdcor()))) &&
            ((this.cdgrupopar==null && other.getCdgrupopar()==null) || 
             (this.cdgrupopar!=null &&
              this.cdgrupopar.equals(other.getCdgrupopar()))) &&
            ((this.ijgrppar==null && other.getIjgrppar()==null) || 
             (this.ijgrppar!=null &&
              this.ijgrppar.equals(other.getIjgrppar()))) &&
            ((this.siglagrupo==null && other.getSiglagrupo()==null) || 
             (this.siglagrupo!=null &&
              this.siglagrupo.equals(other.getSiglagrupo())));
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
        if (getCdauxiliar() != null) {
            _hashCode += getCdauxiliar().hashCode();
        }
        if (getCdcor() != null) {
            _hashCode += getCdcor().hashCode();
        }
        if (getCdgrupopar() != null) {
            _hashCode += getCdgrupopar().hashCode();
        }
        if (getIjgrppar() != null) {
            _hashCode += getIjgrppar().hashCode();
        }
        if (getSiglagrupo() != null) {
            _hashCode += getSiglagrupo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpparaux.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaux"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdauxiliar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdauxiliar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrupopar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrupopar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrppar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrppar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrppar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siglagrupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "siglagrupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
