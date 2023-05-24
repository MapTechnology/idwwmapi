/**
 * ApontamentoTurnoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ApontamentoTurnoDTO  implements java.io.Serializable {
    private java.lang.String descricao;

    private idw.idwws.DwConsolid dwConsolid;

    private int idTurno;

    public ApontamentoTurnoDTO() {
    }

    public ApontamentoTurnoDTO(
           java.lang.String descricao,
           idw.idwws.DwConsolid dwConsolid,
           int idTurno) {
           this.descricao = descricao;
           this.dwConsolid = dwConsolid;
           this.idTurno = idTurno;
    }


    /**
     * Gets the descricao value for this ApontamentoTurnoDTO.
     * 
     * @return descricao
     */
    public java.lang.String getDescricao() {
        return descricao;
    }


    /**
     * Sets the descricao value for this ApontamentoTurnoDTO.
     * 
     * @param descricao
     */
    public void setDescricao(java.lang.String descricao) {
        this.descricao = descricao;
    }


    /**
     * Gets the dwConsolid value for this ApontamentoTurnoDTO.
     * 
     * @return dwConsolid
     */
    public idw.idwws.DwConsolid getDwConsolid() {
        return dwConsolid;
    }


    /**
     * Sets the dwConsolid value for this ApontamentoTurnoDTO.
     * 
     * @param dwConsolid
     */
    public void setDwConsolid(idw.idwws.DwConsolid dwConsolid) {
        this.dwConsolid = dwConsolid;
    }


    /**
     * Gets the idTurno value for this ApontamentoTurnoDTO.
     * 
     * @return idTurno
     */
    public int getIdTurno() {
        return idTurno;
    }


    /**
     * Sets the idTurno value for this ApontamentoTurnoDTO.
     * 
     * @param idTurno
     */
    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApontamentoTurnoDTO)) return false;
        ApontamentoTurnoDTO other = (ApontamentoTurnoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descricao==null && other.getDescricao()==null) || 
             (this.descricao!=null &&
              this.descricao.equals(other.getDescricao()))) &&
            ((this.dwConsolid==null && other.getDwConsolid()==null) || 
             (this.dwConsolid!=null &&
              this.dwConsolid.equals(other.getDwConsolid()))) &&
            this.idTurno == other.getIdTurno();
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
        if (getDescricao() != null) {
            _hashCode += getDescricao().hashCode();
        }
        if (getDwConsolid() != null) {
            _hashCode += getDwConsolid().hashCode();
        }
        _hashCode += getIdTurno();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ApontamentoTurnoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "apontamentoTurnoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descricao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descricao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTurno"));
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
