/**
 * AlocacaoProdutoMaquinaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class AlocacaoProdutoMaquinaDTO  implements java.io.Serializable {
    private idw.idwws.CpDTO cpReferencia;

    private idw.idwws.CpsDTO cps;

    private idw.idwws.IdCtDTO id;

    private int tempoExecucaoCps;

    public AlocacaoProdutoMaquinaDTO() {
    }

    public AlocacaoProdutoMaquinaDTO(
           idw.idwws.CpDTO cpReferencia,
           idw.idwws.CpsDTO cps,
           idw.idwws.IdCtDTO id,
           int tempoExecucaoCps) {
           this.cpReferencia = cpReferencia;
           this.cps = cps;
           this.id = id;
           this.tempoExecucaoCps = tempoExecucaoCps;
    }


    /**
     * Gets the cpReferencia value for this AlocacaoProdutoMaquinaDTO.
     * 
     * @return cpReferencia
     */
    public idw.idwws.CpDTO getCpReferencia() {
        return cpReferencia;
    }


    /**
     * Sets the cpReferencia value for this AlocacaoProdutoMaquinaDTO.
     * 
     * @param cpReferencia
     */
    public void setCpReferencia(idw.idwws.CpDTO cpReferencia) {
        this.cpReferencia = cpReferencia;
    }


    /**
     * Gets the cps value for this AlocacaoProdutoMaquinaDTO.
     * 
     * @return cps
     */
    public idw.idwws.CpsDTO getCps() {
        return cps;
    }


    /**
     * Sets the cps value for this AlocacaoProdutoMaquinaDTO.
     * 
     * @param cps
     */
    public void setCps(idw.idwws.CpsDTO cps) {
        this.cps = cps;
    }


    /**
     * Gets the id value for this AlocacaoProdutoMaquinaDTO.
     * 
     * @return id
     */
    public idw.idwws.IdCtDTO getId() {
        return id;
    }


    /**
     * Sets the id value for this AlocacaoProdutoMaquinaDTO.
     * 
     * @param id
     */
    public void setId(idw.idwws.IdCtDTO id) {
        this.id = id;
    }


    /**
     * Gets the tempoExecucaoCps value for this AlocacaoProdutoMaquinaDTO.
     * 
     * @return tempoExecucaoCps
     */
    public int getTempoExecucaoCps() {
        return tempoExecucaoCps;
    }


    /**
     * Sets the tempoExecucaoCps value for this AlocacaoProdutoMaquinaDTO.
     * 
     * @param tempoExecucaoCps
     */
    public void setTempoExecucaoCps(int tempoExecucaoCps) {
        this.tempoExecucaoCps = tempoExecucaoCps;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AlocacaoProdutoMaquinaDTO)) return false;
        AlocacaoProdutoMaquinaDTO other = (AlocacaoProdutoMaquinaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cpReferencia==null && other.getCpReferencia()==null) || 
             (this.cpReferencia!=null &&
              this.cpReferencia.equals(other.getCpReferencia()))) &&
            ((this.cps==null && other.getCps()==null) || 
             (this.cps!=null &&
              this.cps.equals(other.getCps()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            this.tempoExecucaoCps == other.getTempoExecucaoCps();
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
        if (getCpReferencia() != null) {
            _hashCode += getCpReferencia().hashCode();
        }
        if (getCps() != null) {
            _hashCode += getCps().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        _hashCode += getTempoExecucaoCps();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlocacaoProdutoMaquinaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "alocacaoProdutoMaquinaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpReferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cpReferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "cpDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "cpsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "idCtDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempoExecucaoCps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempoExecucaoCps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
