/**
 * DwEstpro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwEstpro  extends idw.idwws.DwEstProTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrAjuste;

    private java.util.Calendar dthrEntrada;

    private java.util.Calendar dthrSaida;

    private java.util.Calendar dthrTotal;

    private idw.idwws.DwEst dwEst;

    private idw.idwws.DwEstmov[] dwEstmovs;

    private java.lang.Long idEstpro;

    private idw.idwws.OmProduto omProduto;

    private idw.idwws.PpCliente ppCliente;

    private java.math.BigDecimal qtAjuste;

    private java.math.BigDecimal qtEntrada;

    private java.math.BigDecimal qtReservada;

    private java.math.BigDecimal qtSaida;

    private java.math.BigDecimal qtTotal;

    public DwEstpro() {
    }

    public DwEstpro(
           java.util.Calendar dthrAjuste,
           java.util.Calendar dthrEntrada,
           java.util.Calendar dthrSaida,
           java.util.Calendar dthrTotal,
           idw.idwws.DwEst dwEst,
           idw.idwws.DwEstmov[] dwEstmovs,
           java.lang.Long idEstpro,
           idw.idwws.OmProduto omProduto,
           idw.idwws.PpCliente ppCliente,
           java.math.BigDecimal qtAjuste,
           java.math.BigDecimal qtEntrada,
           java.math.BigDecimal qtReservada,
           java.math.BigDecimal qtSaida,
           java.math.BigDecimal qtTotal) {
        this.dthrAjuste = dthrAjuste;
        this.dthrEntrada = dthrEntrada;
        this.dthrSaida = dthrSaida;
        this.dthrTotal = dthrTotal;
        this.dwEst = dwEst;
        this.dwEstmovs = dwEstmovs;
        this.idEstpro = idEstpro;
        this.omProduto = omProduto;
        this.ppCliente = ppCliente;
        this.qtAjuste = qtAjuste;
        this.qtEntrada = qtEntrada;
        this.qtReservada = qtReservada;
        this.qtSaida = qtSaida;
        this.qtTotal = qtTotal;
    }


    /**
     * Gets the dthrAjuste value for this DwEstpro.
     * 
     * @return dthrAjuste
     */
    public java.util.Calendar getDthrAjuste() {
        return dthrAjuste;
    }


    /**
     * Sets the dthrAjuste value for this DwEstpro.
     * 
     * @param dthrAjuste
     */
    public void setDthrAjuste(java.util.Calendar dthrAjuste) {
        this.dthrAjuste = dthrAjuste;
    }


    /**
     * Gets the dthrEntrada value for this DwEstpro.
     * 
     * @return dthrEntrada
     */
    public java.util.Calendar getDthrEntrada() {
        return dthrEntrada;
    }


    /**
     * Sets the dthrEntrada value for this DwEstpro.
     * 
     * @param dthrEntrada
     */
    public void setDthrEntrada(java.util.Calendar dthrEntrada) {
        this.dthrEntrada = dthrEntrada;
    }


    /**
     * Gets the dthrSaida value for this DwEstpro.
     * 
     * @return dthrSaida
     */
    public java.util.Calendar getDthrSaida() {
        return dthrSaida;
    }


    /**
     * Sets the dthrSaida value for this DwEstpro.
     * 
     * @param dthrSaida
     */
    public void setDthrSaida(java.util.Calendar dthrSaida) {
        this.dthrSaida = dthrSaida;
    }


    /**
     * Gets the dthrTotal value for this DwEstpro.
     * 
     * @return dthrTotal
     */
    public java.util.Calendar getDthrTotal() {
        return dthrTotal;
    }


    /**
     * Sets the dthrTotal value for this DwEstpro.
     * 
     * @param dthrTotal
     */
    public void setDthrTotal(java.util.Calendar dthrTotal) {
        this.dthrTotal = dthrTotal;
    }


    /**
     * Gets the dwEst value for this DwEstpro.
     * 
     * @return dwEst
     */
    public idw.idwws.DwEst getDwEst() {
        return dwEst;
    }


    /**
     * Sets the dwEst value for this DwEstpro.
     * 
     * @param dwEst
     */
    public void setDwEst(idw.idwws.DwEst dwEst) {
        this.dwEst = dwEst;
    }


    /**
     * Gets the dwEstmovs value for this DwEstpro.
     * 
     * @return dwEstmovs
     */
    public idw.idwws.DwEstmov[] getDwEstmovs() {
        return dwEstmovs;
    }


    /**
     * Sets the dwEstmovs value for this DwEstpro.
     * 
     * @param dwEstmovs
     */
    public void setDwEstmovs(idw.idwws.DwEstmov[] dwEstmovs) {
        this.dwEstmovs = dwEstmovs;
    }

    public idw.idwws.DwEstmov getDwEstmovs(int i) {
        return this.dwEstmovs[i];
    }

    public void setDwEstmovs(int i, idw.idwws.DwEstmov _value) {
        this.dwEstmovs[i] = _value;
    }


    /**
     * Gets the idEstpro value for this DwEstpro.
     * 
     * @return idEstpro
     */
    public java.lang.Long getIdEstpro() {
        return idEstpro;
    }


    /**
     * Sets the idEstpro value for this DwEstpro.
     * 
     * @param idEstpro
     */
    public void setIdEstpro(java.lang.Long idEstpro) {
        this.idEstpro = idEstpro;
    }


    /**
     * Gets the omProduto value for this DwEstpro.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwEstpro.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the ppCliente value for this DwEstpro.
     * 
     * @return ppCliente
     */
    public idw.idwws.PpCliente getPpCliente() {
        return ppCliente;
    }


    /**
     * Sets the ppCliente value for this DwEstpro.
     * 
     * @param ppCliente
     */
    public void setPpCliente(idw.idwws.PpCliente ppCliente) {
        this.ppCliente = ppCliente;
    }


    /**
     * Gets the qtAjuste value for this DwEstpro.
     * 
     * @return qtAjuste
     */
    public java.math.BigDecimal getQtAjuste() {
        return qtAjuste;
    }


    /**
     * Sets the qtAjuste value for this DwEstpro.
     * 
     * @param qtAjuste
     */
    public void setQtAjuste(java.math.BigDecimal qtAjuste) {
        this.qtAjuste = qtAjuste;
    }


    /**
     * Gets the qtEntrada value for this DwEstpro.
     * 
     * @return qtEntrada
     */
    public java.math.BigDecimal getQtEntrada() {
        return qtEntrada;
    }


    /**
     * Sets the qtEntrada value for this DwEstpro.
     * 
     * @param qtEntrada
     */
    public void setQtEntrada(java.math.BigDecimal qtEntrada) {
        this.qtEntrada = qtEntrada;
    }


    /**
     * Gets the qtReservada value for this DwEstpro.
     * 
     * @return qtReservada
     */
    public java.math.BigDecimal getQtReservada() {
        return qtReservada;
    }


    /**
     * Sets the qtReservada value for this DwEstpro.
     * 
     * @param qtReservada
     */
    public void setQtReservada(java.math.BigDecimal qtReservada) {
        this.qtReservada = qtReservada;
    }


    /**
     * Gets the qtSaida value for this DwEstpro.
     * 
     * @return qtSaida
     */
    public java.math.BigDecimal getQtSaida() {
        return qtSaida;
    }


    /**
     * Sets the qtSaida value for this DwEstpro.
     * 
     * @param qtSaida
     */
    public void setQtSaida(java.math.BigDecimal qtSaida) {
        this.qtSaida = qtSaida;
    }


    /**
     * Gets the qtTotal value for this DwEstpro.
     * 
     * @return qtTotal
     */
    public java.math.BigDecimal getQtTotal() {
        return qtTotal;
    }


    /**
     * Sets the qtTotal value for this DwEstpro.
     * 
     * @param qtTotal
     */
    public void setQtTotal(java.math.BigDecimal qtTotal) {
        this.qtTotal = qtTotal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwEstpro)) return false;
        DwEstpro other = (DwEstpro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrAjuste==null && other.getDthrAjuste()==null) || 
             (this.dthrAjuste!=null &&
              this.dthrAjuste.equals(other.getDthrAjuste()))) &&
            ((this.dthrEntrada==null && other.getDthrEntrada()==null) || 
             (this.dthrEntrada!=null &&
              this.dthrEntrada.equals(other.getDthrEntrada()))) &&
            ((this.dthrSaida==null && other.getDthrSaida()==null) || 
             (this.dthrSaida!=null &&
              this.dthrSaida.equals(other.getDthrSaida()))) &&
            ((this.dthrTotal==null && other.getDthrTotal()==null) || 
             (this.dthrTotal!=null &&
              this.dthrTotal.equals(other.getDthrTotal()))) &&
            ((this.dwEst==null && other.getDwEst()==null) || 
             (this.dwEst!=null &&
              this.dwEst.equals(other.getDwEst()))) &&
            ((this.dwEstmovs==null && other.getDwEstmovs()==null) || 
             (this.dwEstmovs!=null &&
              java.util.Arrays.equals(this.dwEstmovs, other.getDwEstmovs()))) &&
            ((this.idEstpro==null && other.getIdEstpro()==null) || 
             (this.idEstpro!=null &&
              this.idEstpro.equals(other.getIdEstpro()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.ppCliente==null && other.getPpCliente()==null) || 
             (this.ppCliente!=null &&
              this.ppCliente.equals(other.getPpCliente()))) &&
            ((this.qtAjuste==null && other.getQtAjuste()==null) || 
             (this.qtAjuste!=null &&
              this.qtAjuste.equals(other.getQtAjuste()))) &&
            ((this.qtEntrada==null && other.getQtEntrada()==null) || 
             (this.qtEntrada!=null &&
              this.qtEntrada.equals(other.getQtEntrada()))) &&
            ((this.qtReservada==null && other.getQtReservada()==null) || 
             (this.qtReservada!=null &&
              this.qtReservada.equals(other.getQtReservada()))) &&
            ((this.qtSaida==null && other.getQtSaida()==null) || 
             (this.qtSaida!=null &&
              this.qtSaida.equals(other.getQtSaida()))) &&
            ((this.qtTotal==null && other.getQtTotal()==null) || 
             (this.qtTotal!=null &&
              this.qtTotal.equals(other.getQtTotal())));
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
        if (getDthrAjuste() != null) {
            _hashCode += getDthrAjuste().hashCode();
        }
        if (getDthrEntrada() != null) {
            _hashCode += getDthrEntrada().hashCode();
        }
        if (getDthrSaida() != null) {
            _hashCode += getDthrSaida().hashCode();
        }
        if (getDthrTotal() != null) {
            _hashCode += getDthrTotal().hashCode();
        }
        if (getDwEst() != null) {
            _hashCode += getDwEst().hashCode();
        }
        if (getDwEstmovs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwEstmovs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwEstmovs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdEstpro() != null) {
            _hashCode += getIdEstpro().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getPpCliente() != null) {
            _hashCode += getPpCliente().hashCode();
        }
        if (getQtAjuste() != null) {
            _hashCode += getQtAjuste().hashCode();
        }
        if (getQtEntrada() != null) {
            _hashCode += getQtEntrada().hashCode();
        }
        if (getQtReservada() != null) {
            _hashCode += getQtReservada().hashCode();
        }
        if (getQtSaida() != null) {
            _hashCode += getQtSaida().hashCode();
        }
        if (getQtTotal() != null) {
            _hashCode += getQtTotal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwEstpro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstpro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrAjuste");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrAjuste"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrEntrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrEntrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrSaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrSaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrTotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstmovs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstmovs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstmov"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEstpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEstpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAjuste");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAjuste"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtEntrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtEntrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtReservada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtReservada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtSaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtSaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtTotal"));
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
