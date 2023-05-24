/**
 * Ijbroneprosecao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijbroneprosecao  implements java.io.Serializable {
    private java.util.Calendar dthrfimcomp;

    private idw.idwws.IjbroneprosecaoId id;

    private idw.idwws.Ijtbpro ijtbproByCdproduto;

    private idw.idwws.Ijtbpro ijtbproByCdprodutocomp;

    private double quantidade;

    public Ijbroneprosecao() {
    }

    public Ijbroneprosecao(
           java.util.Calendar dthrfimcomp,
           idw.idwws.IjbroneprosecaoId id,
           idw.idwws.Ijtbpro ijtbproByCdproduto,
           idw.idwws.Ijtbpro ijtbproByCdprodutocomp,
           double quantidade) {
           this.dthrfimcomp = dthrfimcomp;
           this.id = id;
           this.ijtbproByCdproduto = ijtbproByCdproduto;
           this.ijtbproByCdprodutocomp = ijtbproByCdprodutocomp;
           this.quantidade = quantidade;
    }


    /**
     * Gets the dthrfimcomp value for this Ijbroneprosecao.
     * 
     * @return dthrfimcomp
     */
    public java.util.Calendar getDthrfimcomp() {
        return dthrfimcomp;
    }


    /**
     * Sets the dthrfimcomp value for this Ijbroneprosecao.
     * 
     * @param dthrfimcomp
     */
    public void setDthrfimcomp(java.util.Calendar dthrfimcomp) {
        this.dthrfimcomp = dthrfimcomp;
    }


    /**
     * Gets the id value for this Ijbroneprosecao.
     * 
     * @return id
     */
    public idw.idwws.IjbroneprosecaoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijbroneprosecao.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjbroneprosecaoId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbproByCdproduto value for this Ijbroneprosecao.
     * 
     * @return ijtbproByCdproduto
     */
    public idw.idwws.Ijtbpro getIjtbproByCdproduto() {
        return ijtbproByCdproduto;
    }


    /**
     * Sets the ijtbproByCdproduto value for this Ijbroneprosecao.
     * 
     * @param ijtbproByCdproduto
     */
    public void setIjtbproByCdproduto(idw.idwws.Ijtbpro ijtbproByCdproduto) {
        this.ijtbproByCdproduto = ijtbproByCdproduto;
    }


    /**
     * Gets the ijtbproByCdprodutocomp value for this Ijbroneprosecao.
     * 
     * @return ijtbproByCdprodutocomp
     */
    public idw.idwws.Ijtbpro getIjtbproByCdprodutocomp() {
        return ijtbproByCdprodutocomp;
    }


    /**
     * Sets the ijtbproByCdprodutocomp value for this Ijbroneprosecao.
     * 
     * @param ijtbproByCdprodutocomp
     */
    public void setIjtbproByCdprodutocomp(idw.idwws.Ijtbpro ijtbproByCdprodutocomp) {
        this.ijtbproByCdprodutocomp = ijtbproByCdprodutocomp;
    }


    /**
     * Gets the quantidade value for this Ijbroneprosecao.
     * 
     * @return quantidade
     */
    public double getQuantidade() {
        return quantidade;
    }


    /**
     * Sets the quantidade value for this Ijbroneprosecao.
     * 
     * @param quantidade
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijbroneprosecao)) return false;
        Ijbroneprosecao other = (Ijbroneprosecao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfimcomp==null && other.getDthrfimcomp()==null) || 
             (this.dthrfimcomp!=null &&
              this.dthrfimcomp.equals(other.getDthrfimcomp()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbproByCdproduto==null && other.getIjtbproByCdproduto()==null) || 
             (this.ijtbproByCdproduto!=null &&
              this.ijtbproByCdproduto.equals(other.getIjtbproByCdproduto()))) &&
            ((this.ijtbproByCdprodutocomp==null && other.getIjtbproByCdprodutocomp()==null) || 
             (this.ijtbproByCdprodutocomp!=null &&
              this.ijtbproByCdprodutocomp.equals(other.getIjtbproByCdprodutocomp()))) &&
            this.quantidade == other.getQuantidade();
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
        if (getDthrfimcomp() != null) {
            _hashCode += getDthrfimcomp().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbproByCdproduto() != null) {
            _hashCode += getIjtbproByCdproduto().hashCode();
        }
        if (getIjtbproByCdprodutocomp() != null) {
            _hashCode += getIjtbproByCdprodutocomp().hashCode();
        }
        _hashCode += new Double(getQuantidade()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijbroneprosecao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijbroneprosecao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfimcomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfimcomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijbroneprosecaoId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbproByCdproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbproByCdproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbproByCdprodutocomp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbproByCdprodutocomp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantidade"));
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
