/**
 * Ijgrpemail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpemail  implements java.io.Serializable {
    private java.lang.String cdgrpemail;

    private java.lang.String dsgrpemail;

    private idw.idwws.Ijgrpusuemail[] ijgrpusuemails;

    private idw.idwws.Ijselecao[] ijselecaos;

    private idw.idwws.Ijtbusu ijtbusu;

    public Ijgrpemail() {
    }

    public Ijgrpemail(
           java.lang.String cdgrpemail,
           java.lang.String dsgrpemail,
           idw.idwws.Ijgrpusuemail[] ijgrpusuemails,
           idw.idwws.Ijselecao[] ijselecaos,
           idw.idwws.Ijtbusu ijtbusu) {
           this.cdgrpemail = cdgrpemail;
           this.dsgrpemail = dsgrpemail;
           this.ijgrpusuemails = ijgrpusuemails;
           this.ijselecaos = ijselecaos;
           this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the cdgrpemail value for this Ijgrpemail.
     * 
     * @return cdgrpemail
     */
    public java.lang.String getCdgrpemail() {
        return cdgrpemail;
    }


    /**
     * Sets the cdgrpemail value for this Ijgrpemail.
     * 
     * @param cdgrpemail
     */
    public void setCdgrpemail(java.lang.String cdgrpemail) {
        this.cdgrpemail = cdgrpemail;
    }


    /**
     * Gets the dsgrpemail value for this Ijgrpemail.
     * 
     * @return dsgrpemail
     */
    public java.lang.String getDsgrpemail() {
        return dsgrpemail;
    }


    /**
     * Sets the dsgrpemail value for this Ijgrpemail.
     * 
     * @param dsgrpemail
     */
    public void setDsgrpemail(java.lang.String dsgrpemail) {
        this.dsgrpemail = dsgrpemail;
    }


    /**
     * Gets the ijgrpusuemails value for this Ijgrpemail.
     * 
     * @return ijgrpusuemails
     */
    public idw.idwws.Ijgrpusuemail[] getIjgrpusuemails() {
        return ijgrpusuemails;
    }


    /**
     * Sets the ijgrpusuemails value for this Ijgrpemail.
     * 
     * @param ijgrpusuemails
     */
    public void setIjgrpusuemails(idw.idwws.Ijgrpusuemail[] ijgrpusuemails) {
        this.ijgrpusuemails = ijgrpusuemails;
    }

    public idw.idwws.Ijgrpusuemail getIjgrpusuemails(int i) {
        return this.ijgrpusuemails[i];
    }

    public void setIjgrpusuemails(int i, idw.idwws.Ijgrpusuemail _value) {
        this.ijgrpusuemails[i] = _value;
    }


    /**
     * Gets the ijselecaos value for this Ijgrpemail.
     * 
     * @return ijselecaos
     */
    public idw.idwws.Ijselecao[] getIjselecaos() {
        return ijselecaos;
    }


    /**
     * Sets the ijselecaos value for this Ijgrpemail.
     * 
     * @param ijselecaos
     */
    public void setIjselecaos(idw.idwws.Ijselecao[] ijselecaos) {
        this.ijselecaos = ijselecaos;
    }

    public idw.idwws.Ijselecao getIjselecaos(int i) {
        return this.ijselecaos[i];
    }

    public void setIjselecaos(int i, idw.idwws.Ijselecao _value) {
        this.ijselecaos[i] = _value;
    }


    /**
     * Gets the ijtbusu value for this Ijgrpemail.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijgrpemail.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpemail)) return false;
        Ijgrpemail other = (Ijgrpemail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrpemail==null && other.getCdgrpemail()==null) || 
             (this.cdgrpemail!=null &&
              this.cdgrpemail.equals(other.getCdgrpemail()))) &&
            ((this.dsgrpemail==null && other.getDsgrpemail()==null) || 
             (this.dsgrpemail!=null &&
              this.dsgrpemail.equals(other.getDsgrpemail()))) &&
            ((this.ijgrpusuemails==null && other.getIjgrpusuemails()==null) || 
             (this.ijgrpusuemails!=null &&
              java.util.Arrays.equals(this.ijgrpusuemails, other.getIjgrpusuemails()))) &&
            ((this.ijselecaos==null && other.getIjselecaos()==null) || 
             (this.ijselecaos!=null &&
              java.util.Arrays.equals(this.ijselecaos, other.getIjselecaos()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu())));
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
        if (getCdgrpemail() != null) {
            _hashCode += getCdgrpemail().hashCode();
        }
        if (getDsgrpemail() != null) {
            _hashCode += getDsgrpemail().hashCode();
        }
        if (getIjgrpusuemails() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpusuemails());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpusuemails(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjselecaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjselecaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjselecaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpemail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpemail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrpemail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrpemail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgrpemail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgrpemail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpusuemails");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpusuemails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpusuemail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijselecaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijselecaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijselecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
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
