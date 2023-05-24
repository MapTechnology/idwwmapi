/**
 * GraficoBIItemRecorrenciaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class GraficoBIItemRecorrenciaDTO  implements java.io.Serializable {
    private java.util.Calendar dthrFim;

    private java.util.Calendar dthrIni;

    private java.lang.Double indItem;

    private idw.idwws.DetalheRecorrenciaParadaDTO[] listaParadas;

    private idw.idwws.DetalheRecorrenciaRefugoDTO[] listaRefugos;

    private java.lang.Long qtdPerdida;

    private java.lang.Double segTempoParadas;

    private java.lang.String toolTip;

    public GraficoBIItemRecorrenciaDTO() {
    }

    public GraficoBIItemRecorrenciaDTO(
           java.util.Calendar dthrFim,
           java.util.Calendar dthrIni,
           java.lang.Double indItem,
           idw.idwws.DetalheRecorrenciaParadaDTO[] listaParadas,
           idw.idwws.DetalheRecorrenciaRefugoDTO[] listaRefugos,
           java.lang.Long qtdPerdida,
           java.lang.Double segTempoParadas,
           java.lang.String toolTip) {
           this.dthrFim = dthrFim;
           this.dthrIni = dthrIni;
           this.indItem = indItem;
           this.listaParadas = listaParadas;
           this.listaRefugos = listaRefugos;
           this.qtdPerdida = qtdPerdida;
           this.segTempoParadas = segTempoParadas;
           this.toolTip = toolTip;
    }


    /**
     * Gets the dthrFim value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @return dthrFim
     */
    public java.util.Calendar getDthrFim() {
        return dthrFim;
    }


    /**
     * Sets the dthrFim value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @param dthrFim
     */
    public void setDthrFim(java.util.Calendar dthrFim) {
        this.dthrFim = dthrFim;
    }


    /**
     * Gets the dthrIni value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @return dthrIni
     */
    public java.util.Calendar getDthrIni() {
        return dthrIni;
    }


    /**
     * Sets the dthrIni value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @param dthrIni
     */
    public void setDthrIni(java.util.Calendar dthrIni) {
        this.dthrIni = dthrIni;
    }


    /**
     * Gets the indItem value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @return indItem
     */
    public java.lang.Double getIndItem() {
        return indItem;
    }


    /**
     * Sets the indItem value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @param indItem
     */
    public void setIndItem(java.lang.Double indItem) {
        this.indItem = indItem;
    }


    /**
     * Gets the listaParadas value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @return listaParadas
     */
    public idw.idwws.DetalheRecorrenciaParadaDTO[] getListaParadas() {
        return listaParadas;
    }


    /**
     * Sets the listaParadas value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @param listaParadas
     */
    public void setListaParadas(idw.idwws.DetalheRecorrenciaParadaDTO[] listaParadas) {
        this.listaParadas = listaParadas;
    }

    public idw.idwws.DetalheRecorrenciaParadaDTO getListaParadas(int i) {
        return this.listaParadas[i];
    }

    public void setListaParadas(int i, idw.idwws.DetalheRecorrenciaParadaDTO _value) {
        this.listaParadas[i] = _value;
    }


    /**
     * Gets the listaRefugos value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @return listaRefugos
     */
    public idw.idwws.DetalheRecorrenciaRefugoDTO[] getListaRefugos() {
        return listaRefugos;
    }


    /**
     * Sets the listaRefugos value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @param listaRefugos
     */
    public void setListaRefugos(idw.idwws.DetalheRecorrenciaRefugoDTO[] listaRefugos) {
        this.listaRefugos = listaRefugos;
    }

    public idw.idwws.DetalheRecorrenciaRefugoDTO getListaRefugos(int i) {
        return this.listaRefugos[i];
    }

    public void setListaRefugos(int i, idw.idwws.DetalheRecorrenciaRefugoDTO _value) {
        this.listaRefugos[i] = _value;
    }


    /**
     * Gets the qtdPerdida value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @return qtdPerdida
     */
    public java.lang.Long getQtdPerdida() {
        return qtdPerdida;
    }


    /**
     * Sets the qtdPerdida value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @param qtdPerdida
     */
    public void setQtdPerdida(java.lang.Long qtdPerdida) {
        this.qtdPerdida = qtdPerdida;
    }


    /**
     * Gets the segTempoParadas value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @return segTempoParadas
     */
    public java.lang.Double getSegTempoParadas() {
        return segTempoParadas;
    }


    /**
     * Sets the segTempoParadas value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @param segTempoParadas
     */
    public void setSegTempoParadas(java.lang.Double segTempoParadas) {
        this.segTempoParadas = segTempoParadas;
    }


    /**
     * Gets the toolTip value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @return toolTip
     */
    public java.lang.String getToolTip() {
        return toolTip;
    }


    /**
     * Sets the toolTip value for this GraficoBIItemRecorrenciaDTO.
     * 
     * @param toolTip
     */
    public void setToolTip(java.lang.String toolTip) {
        this.toolTip = toolTip;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GraficoBIItemRecorrenciaDTO)) return false;
        GraficoBIItemRecorrenciaDTO other = (GraficoBIItemRecorrenciaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrFim==null && other.getDthrFim()==null) || 
             (this.dthrFim!=null &&
              this.dthrFim.equals(other.getDthrFim()))) &&
            ((this.dthrIni==null && other.getDthrIni()==null) || 
             (this.dthrIni!=null &&
              this.dthrIni.equals(other.getDthrIni()))) &&
            ((this.indItem==null && other.getIndItem()==null) || 
             (this.indItem!=null &&
              this.indItem.equals(other.getIndItem()))) &&
            ((this.listaParadas==null && other.getListaParadas()==null) || 
             (this.listaParadas!=null &&
              java.util.Arrays.equals(this.listaParadas, other.getListaParadas()))) &&
            ((this.listaRefugos==null && other.getListaRefugos()==null) || 
             (this.listaRefugos!=null &&
              java.util.Arrays.equals(this.listaRefugos, other.getListaRefugos()))) &&
            ((this.qtdPerdida==null && other.getQtdPerdida()==null) || 
             (this.qtdPerdida!=null &&
              this.qtdPerdida.equals(other.getQtdPerdida()))) &&
            ((this.segTempoParadas==null && other.getSegTempoParadas()==null) || 
             (this.segTempoParadas!=null &&
              this.segTempoParadas.equals(other.getSegTempoParadas()))) &&
            ((this.toolTip==null && other.getToolTip()==null) || 
             (this.toolTip!=null &&
              this.toolTip.equals(other.getToolTip())));
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
        if (getDthrFim() != null) {
            _hashCode += getDthrFim().hashCode();
        }
        if (getDthrIni() != null) {
            _hashCode += getDthrIni().hashCode();
        }
        if (getIndItem() != null) {
            _hashCode += getIndItem().hashCode();
        }
        if (getListaParadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaParadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaParadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaRefugos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaRefugos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaRefugos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getQtdPerdida() != null) {
            _hashCode += getQtdPerdida().hashCode();
        }
        if (getSegTempoParadas() != null) {
            _hashCode += getSegTempoParadas().hashCode();
        }
        if (getToolTip() != null) {
            _hashCode += getToolTip().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GraficoBIItemRecorrenciaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "graficoBIItemRecorrenciaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrIni");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrIni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheRecorrenciaParadaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaRefugos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaRefugos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheRecorrenciaRefugoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdPerdida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdPerdida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segTempoParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segTempoParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toolTip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "toolTip"));
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
