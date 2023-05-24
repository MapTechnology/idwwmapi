/**
 * OmMapapa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmMapapa  extends idw.idwws.OmMapapaTemplate  implements java.io.Serializable {
    private long idMapapa;

    private idw.idwws.OmAlimrea[] omAlimreas;

    private idw.idwws.OmMapa omMapa;

    private idw.idwws.OmPa omPa;

    private idw.idwws.OmPapro[] omPapros;

    private idw.idwws.OmProduto omProduto;

    private java.math.BigDecimal qtUsada;

    public OmMapapa() {
    }

    public OmMapapa(
           long idMapapa,
           idw.idwws.OmAlimrea[] omAlimreas,
           idw.idwws.OmMapa omMapa,
           idw.idwws.OmPa omPa,
           idw.idwws.OmPapro[] omPapros,
           idw.idwws.OmProduto omProduto,
           java.math.BigDecimal qtUsada) {
        this.idMapapa = idMapapa;
        this.omAlimreas = omAlimreas;
        this.omMapa = omMapa;
        this.omPa = omPa;
        this.omPapros = omPapros;
        this.omProduto = omProduto;
        this.qtUsada = qtUsada;
    }


    /**
     * Gets the idMapapa value for this OmMapapa.
     * 
     * @return idMapapa
     */
    public long getIdMapapa() {
        return idMapapa;
    }


    /**
     * Sets the idMapapa value for this OmMapapa.
     * 
     * @param idMapapa
     */
    public void setIdMapapa(long idMapapa) {
        this.idMapapa = idMapapa;
    }


    /**
     * Gets the omAlimreas value for this OmMapapa.
     * 
     * @return omAlimreas
     */
    public idw.idwws.OmAlimrea[] getOmAlimreas() {
        return omAlimreas;
    }


    /**
     * Sets the omAlimreas value for this OmMapapa.
     * 
     * @param omAlimreas
     */
    public void setOmAlimreas(idw.idwws.OmAlimrea[] omAlimreas) {
        this.omAlimreas = omAlimreas;
    }

    public idw.idwws.OmAlimrea getOmAlimreas(int i) {
        return this.omAlimreas[i];
    }

    public void setOmAlimreas(int i, idw.idwws.OmAlimrea _value) {
        this.omAlimreas[i] = _value;
    }


    /**
     * Gets the omMapa value for this OmMapapa.
     * 
     * @return omMapa
     */
    public idw.idwws.OmMapa getOmMapa() {
        return omMapa;
    }


    /**
     * Sets the omMapa value for this OmMapapa.
     * 
     * @param omMapa
     */
    public void setOmMapa(idw.idwws.OmMapa omMapa) {
        this.omMapa = omMapa;
    }


    /**
     * Gets the omPa value for this OmMapapa.
     * 
     * @return omPa
     */
    public idw.idwws.OmPa getOmPa() {
        return omPa;
    }


    /**
     * Sets the omPa value for this OmMapapa.
     * 
     * @param omPa
     */
    public void setOmPa(idw.idwws.OmPa omPa) {
        this.omPa = omPa;
    }


    /**
     * Gets the omPapros value for this OmMapapa.
     * 
     * @return omPapros
     */
    public idw.idwws.OmPapro[] getOmPapros() {
        return omPapros;
    }


    /**
     * Sets the omPapros value for this OmMapapa.
     * 
     * @param omPapros
     */
    public void setOmPapros(idw.idwws.OmPapro[] omPapros) {
        this.omPapros = omPapros;
    }

    public idw.idwws.OmPapro getOmPapros(int i) {
        return this.omPapros[i];
    }

    public void setOmPapros(int i, idw.idwws.OmPapro _value) {
        this.omPapros[i] = _value;
    }


    /**
     * Gets the omProduto value for this OmMapapa.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this OmMapapa.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the qtUsada value for this OmMapapa.
     * 
     * @return qtUsada
     */
    public java.math.BigDecimal getQtUsada() {
        return qtUsada;
    }


    /**
     * Sets the qtUsada value for this OmMapapa.
     * 
     * @param qtUsada
     */
    public void setQtUsada(java.math.BigDecimal qtUsada) {
        this.qtUsada = qtUsada;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmMapapa)) return false;
        OmMapapa other = (OmMapapa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.idMapapa == other.getIdMapapa() &&
            ((this.omAlimreas==null && other.getOmAlimreas()==null) || 
             (this.omAlimreas!=null &&
              java.util.Arrays.equals(this.omAlimreas, other.getOmAlimreas()))) &&
            ((this.omMapa==null && other.getOmMapa()==null) || 
             (this.omMapa!=null &&
              this.omMapa.equals(other.getOmMapa()))) &&
            ((this.omPa==null && other.getOmPa()==null) || 
             (this.omPa!=null &&
              this.omPa.equals(other.getOmPa()))) &&
            ((this.omPapros==null && other.getOmPapros()==null) || 
             (this.omPapros!=null &&
              java.util.Arrays.equals(this.omPapros, other.getOmPapros()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.qtUsada==null && other.getQtUsada()==null) || 
             (this.qtUsada!=null &&
              this.qtUsada.equals(other.getQtUsada())));
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
        _hashCode += new Long(getIdMapapa()).hashCode();
        if (getOmAlimreas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmAlimreas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmAlimreas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmMapa() != null) {
            _hashCode += getOmMapa().hashCode();
        }
        if (getOmPa() != null) {
            _hashCode += getOmPa().hashCode();
        }
        if (getOmPapros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPapros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPapros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getQtUsada() != null) {
            _hashCode += getQtUsada().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmMapapa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapapa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idMapapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idMapapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omAlimreas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omAlimreas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlimrea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omMapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omMapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omMapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPapros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPapros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPapro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtUsada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtUsada"));
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
