/**
 * Ijtmpsetup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtmpsetup  implements java.io.Serializable {
    private java.lang.String cdinjetora;

    private idw.idwws.Ijestmol ijestmolBySysC0012982;

    private idw.idwws.Ijestmol ijestmolBySysC0012983;

    private idw.idwws.Ijop ijopByNropentrada;

    private idw.idwws.Ijop ijopByNropsaida;

    private idw.idwws.Ijtbinj ijtbinj;

    private java.lang.Double tmpultimosetup;

    public Ijtmpsetup() {
    }

    public Ijtmpsetup(
           java.lang.String cdinjetora,
           idw.idwws.Ijestmol ijestmolBySysC0012982,
           idw.idwws.Ijestmol ijestmolBySysC0012983,
           idw.idwws.Ijop ijopByNropentrada,
           idw.idwws.Ijop ijopByNropsaida,
           idw.idwws.Ijtbinj ijtbinj,
           java.lang.Double tmpultimosetup) {
           this.cdinjetora = cdinjetora;
           this.ijestmolBySysC0012982 = ijestmolBySysC0012982;
           this.ijestmolBySysC0012983 = ijestmolBySysC0012983;
           this.ijopByNropentrada = ijopByNropentrada;
           this.ijopByNropsaida = ijopByNropsaida;
           this.ijtbinj = ijtbinj;
           this.tmpultimosetup = tmpultimosetup;
    }


    /**
     * Gets the cdinjetora value for this Ijtmpsetup.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this Ijtmpsetup.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the ijestmolBySysC0012982 value for this Ijtmpsetup.
     * 
     * @return ijestmolBySysC0012982
     */
    public idw.idwws.Ijestmol getIjestmolBySysC0012982() {
        return ijestmolBySysC0012982;
    }


    /**
     * Sets the ijestmolBySysC0012982 value for this Ijtmpsetup.
     * 
     * @param ijestmolBySysC0012982
     */
    public void setIjestmolBySysC0012982(idw.idwws.Ijestmol ijestmolBySysC0012982) {
        this.ijestmolBySysC0012982 = ijestmolBySysC0012982;
    }


    /**
     * Gets the ijestmolBySysC0012983 value for this Ijtmpsetup.
     * 
     * @return ijestmolBySysC0012983
     */
    public idw.idwws.Ijestmol getIjestmolBySysC0012983() {
        return ijestmolBySysC0012983;
    }


    /**
     * Sets the ijestmolBySysC0012983 value for this Ijtmpsetup.
     * 
     * @param ijestmolBySysC0012983
     */
    public void setIjestmolBySysC0012983(idw.idwws.Ijestmol ijestmolBySysC0012983) {
        this.ijestmolBySysC0012983 = ijestmolBySysC0012983;
    }


    /**
     * Gets the ijopByNropentrada value for this Ijtmpsetup.
     * 
     * @return ijopByNropentrada
     */
    public idw.idwws.Ijop getIjopByNropentrada() {
        return ijopByNropentrada;
    }


    /**
     * Sets the ijopByNropentrada value for this Ijtmpsetup.
     * 
     * @param ijopByNropentrada
     */
    public void setIjopByNropentrada(idw.idwws.Ijop ijopByNropentrada) {
        this.ijopByNropentrada = ijopByNropentrada;
    }


    /**
     * Gets the ijopByNropsaida value for this Ijtmpsetup.
     * 
     * @return ijopByNropsaida
     */
    public idw.idwws.Ijop getIjopByNropsaida() {
        return ijopByNropsaida;
    }


    /**
     * Sets the ijopByNropsaida value for this Ijtmpsetup.
     * 
     * @param ijopByNropsaida
     */
    public void setIjopByNropsaida(idw.idwws.Ijop ijopByNropsaida) {
        this.ijopByNropsaida = ijopByNropsaida;
    }


    /**
     * Gets the ijtbinj value for this Ijtmpsetup.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijtmpsetup.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the tmpultimosetup value for this Ijtmpsetup.
     * 
     * @return tmpultimosetup
     */
    public java.lang.Double getTmpultimosetup() {
        return tmpultimosetup;
    }


    /**
     * Sets the tmpultimosetup value for this Ijtmpsetup.
     * 
     * @param tmpultimosetup
     */
    public void setTmpultimosetup(java.lang.Double tmpultimosetup) {
        this.tmpultimosetup = tmpultimosetup;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtmpsetup)) return false;
        Ijtmpsetup other = (Ijtmpsetup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.ijestmolBySysC0012982==null && other.getIjestmolBySysC0012982()==null) || 
             (this.ijestmolBySysC0012982!=null &&
              this.ijestmolBySysC0012982.equals(other.getIjestmolBySysC0012982()))) &&
            ((this.ijestmolBySysC0012983==null && other.getIjestmolBySysC0012983()==null) || 
             (this.ijestmolBySysC0012983!=null &&
              this.ijestmolBySysC0012983.equals(other.getIjestmolBySysC0012983()))) &&
            ((this.ijopByNropentrada==null && other.getIjopByNropentrada()==null) || 
             (this.ijopByNropentrada!=null &&
              this.ijopByNropentrada.equals(other.getIjopByNropentrada()))) &&
            ((this.ijopByNropsaida==null && other.getIjopByNropsaida()==null) || 
             (this.ijopByNropsaida!=null &&
              this.ijopByNropsaida.equals(other.getIjopByNropsaida()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.tmpultimosetup==null && other.getTmpultimosetup()==null) || 
             (this.tmpultimosetup!=null &&
              this.tmpultimosetup.equals(other.getTmpultimosetup())));
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
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getIjestmolBySysC0012982() != null) {
            _hashCode += getIjestmolBySysC0012982().hashCode();
        }
        if (getIjestmolBySysC0012983() != null) {
            _hashCode += getIjestmolBySysC0012983().hashCode();
        }
        if (getIjopByNropentrada() != null) {
            _hashCode += getIjopByNropentrada().hashCode();
        }
        if (getIjopByNropsaida() != null) {
            _hashCode += getIjopByNropsaida().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getTmpultimosetup() != null) {
            _hashCode += getTmpultimosetup().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtmpsetup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtmpsetup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmolBySysC0012982");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmolBySysC0012982"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmolBySysC0012983");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmolBySysC0012983"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopByNropentrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopByNropentrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijopByNropsaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijopByNropsaida"));
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
        elemField.setFieldName("tmpultimosetup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpultimosetup"));
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
