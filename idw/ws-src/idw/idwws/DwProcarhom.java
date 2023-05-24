/**
 * DwProcarhom.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwProcarhom  extends idw.idwws.DwProcarhomTemplate  implements java.io.Serializable {
    private idw.idwws.DwProcedimento dwProcedimento;

    private long idProcarhom;

    private idw.idwws.OmCargo omCargo;

    private java.lang.Short tpHomologacao;

    public DwProcarhom() {
    }

    public DwProcarhom(
           idw.idwws.DwProcedimento dwProcedimento,
           long idProcarhom,
           idw.idwws.OmCargo omCargo,
           java.lang.Short tpHomologacao) {
        this.dwProcedimento = dwProcedimento;
        this.idProcarhom = idProcarhom;
        this.omCargo = omCargo;
        this.tpHomologacao = tpHomologacao;
    }


    /**
     * Gets the dwProcedimento value for this DwProcarhom.
     * 
     * @return dwProcedimento
     */
    public idw.idwws.DwProcedimento getDwProcedimento() {
        return dwProcedimento;
    }


    /**
     * Sets the dwProcedimento value for this DwProcarhom.
     * 
     * @param dwProcedimento
     */
    public void setDwProcedimento(idw.idwws.DwProcedimento dwProcedimento) {
        this.dwProcedimento = dwProcedimento;
    }


    /**
     * Gets the idProcarhom value for this DwProcarhom.
     * 
     * @return idProcarhom
     */
    public long getIdProcarhom() {
        return idProcarhom;
    }


    /**
     * Sets the idProcarhom value for this DwProcarhom.
     * 
     * @param idProcarhom
     */
    public void setIdProcarhom(long idProcarhom) {
        this.idProcarhom = idProcarhom;
    }


    /**
     * Gets the omCargo value for this DwProcarhom.
     * 
     * @return omCargo
     */
    public idw.idwws.OmCargo getOmCargo() {
        return omCargo;
    }


    /**
     * Sets the omCargo value for this DwProcarhom.
     * 
     * @param omCargo
     */
    public void setOmCargo(idw.idwws.OmCargo omCargo) {
        this.omCargo = omCargo;
    }


    /**
     * Gets the tpHomologacao value for this DwProcarhom.
     * 
     * @return tpHomologacao
     */
    public java.lang.Short getTpHomologacao() {
        return tpHomologacao;
    }


    /**
     * Sets the tpHomologacao value for this DwProcarhom.
     * 
     * @param tpHomologacao
     */
    public void setTpHomologacao(java.lang.Short tpHomologacao) {
        this.tpHomologacao = tpHomologacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwProcarhom)) return false;
        DwProcarhom other = (DwProcarhom) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwProcedimento==null && other.getDwProcedimento()==null) || 
             (this.dwProcedimento!=null &&
              this.dwProcedimento.equals(other.getDwProcedimento()))) &&
            this.idProcarhom == other.getIdProcarhom() &&
            ((this.omCargo==null && other.getOmCargo()==null) || 
             (this.omCargo!=null &&
              this.omCargo.equals(other.getOmCargo()))) &&
            ((this.tpHomologacao==null && other.getTpHomologacao()==null) || 
             (this.tpHomologacao!=null &&
              this.tpHomologacao.equals(other.getTpHomologacao())));
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
        if (getDwProcedimento() != null) {
            _hashCode += getDwProcedimento().hashCode();
        }
        _hashCode += new Long(getIdProcarhom()).hashCode();
        if (getOmCargo() != null) {
            _hashCode += getOmCargo().hashCode();
        }
        if (getTpHomologacao() != null) {
            _hashCode += getTpHomologacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwProcarhom.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcarhom"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProcedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProcedimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcedimento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProcarhom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProcarhom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCargo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCargo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCargo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpHomologacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpHomologacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
