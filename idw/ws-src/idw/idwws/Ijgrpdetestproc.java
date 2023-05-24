/**
 * Ijgrpdetestproc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpdetestproc  implements java.io.Serializable {
    private idw.idwws.IjgrpdetestprocId id;

    private idw.idwws.Ijgrpestproc ijgrpestproc;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtboperacoes ijtboperacoes;

    public Ijgrpdetestproc() {
    }

    public Ijgrpdetestproc(
           idw.idwws.IjgrpdetestprocId id,
           idw.idwws.Ijgrpestproc ijgrpestproc,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtboperacoes ijtboperacoes) {
           this.id = id;
           this.ijgrpestproc = ijgrpestproc;
           this.ijtbinj = ijtbinj;
           this.ijtboperacoes = ijtboperacoes;
    }


    /**
     * Gets the id value for this Ijgrpdetestproc.
     * 
     * @return id
     */
    public idw.idwws.IjgrpdetestprocId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijgrpdetestproc.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjgrpdetestprocId id) {
        this.id = id;
    }


    /**
     * Gets the ijgrpestproc value for this Ijgrpdetestproc.
     * 
     * @return ijgrpestproc
     */
    public idw.idwws.Ijgrpestproc getIjgrpestproc() {
        return ijgrpestproc;
    }


    /**
     * Sets the ijgrpestproc value for this Ijgrpdetestproc.
     * 
     * @param ijgrpestproc
     */
    public void setIjgrpestproc(idw.idwws.Ijgrpestproc ijgrpestproc) {
        this.ijgrpestproc = ijgrpestproc;
    }


    /**
     * Gets the ijtbinj value for this Ijgrpdetestproc.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijgrpdetestproc.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtboperacoes value for this Ijgrpdetestproc.
     * 
     * @return ijtboperacoes
     */
    public idw.idwws.Ijtboperacoes getIjtboperacoes() {
        return ijtboperacoes;
    }


    /**
     * Sets the ijtboperacoes value for this Ijgrpdetestproc.
     * 
     * @param ijtboperacoes
     */
    public void setIjtboperacoes(idw.idwws.Ijtboperacoes ijtboperacoes) {
        this.ijtboperacoes = ijtboperacoes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpdetestproc)) return false;
        Ijgrpdetestproc other = (Ijgrpdetestproc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijgrpestproc==null && other.getIjgrpestproc()==null) || 
             (this.ijgrpestproc!=null &&
              this.ijgrpestproc.equals(other.getIjgrpestproc()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtboperacoes==null && other.getIjtboperacoes()==null) || 
             (this.ijtboperacoes!=null &&
              this.ijtboperacoes.equals(other.getIjtboperacoes())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjgrpestproc() != null) {
            _hashCode += getIjgrpestproc().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtboperacoes() != null) {
            _hashCode += getIjtboperacoes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpdetestproc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetestproc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetestprocId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpestproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpestproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpestproc"));
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
        elemField.setFieldName("ijtboperacoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtboperacoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtboperacoes"));
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
