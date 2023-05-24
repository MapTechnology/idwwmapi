/**
 * DwConsolpr.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolpr  extends idw.idwws.DwConsolprTemplate  implements java.io.Serializable {
    private idw.idwws.DwConsol dwConsol;

    private idw.idwws.DwConsolprmo[] dwConsolprmos;

    private java.math.BigDecimal GAutoPesoBruto;

    private java.math.BigDecimal GAutoPesoLiquido;

    private java.math.BigDecimal GManuPesoBruto;

    private java.math.BigDecimal GManuPesoLiquido;

    private java.lang.Long idConsolpr;

    private idw.idwws.OmProduto omProduto;

    private java.lang.Long pcsAutoProducaobruta;

    private java.lang.Long pcsAutoProducaorefugada;

    private java.lang.Long pcsManuProducaobruta;

    private java.lang.Long pcsManuProducaorefugada;

    private java.math.BigDecimal segAutoTempoparada;

    private java.math.BigDecimal segAutoTempoparadaSp;

    public DwConsolpr() {
    }

    public DwConsolpr(
           idw.idwws.DwConsol dwConsol,
           idw.idwws.DwConsolprmo[] dwConsolprmos,
           java.math.BigDecimal GAutoPesoBruto,
           java.math.BigDecimal GAutoPesoLiquido,
           java.math.BigDecimal GManuPesoBruto,
           java.math.BigDecimal GManuPesoLiquido,
           java.lang.Long idConsolpr,
           idw.idwws.OmProduto omProduto,
           java.lang.Long pcsAutoProducaobruta,
           java.lang.Long pcsAutoProducaorefugada,
           java.lang.Long pcsManuProducaobruta,
           java.lang.Long pcsManuProducaorefugada,
           java.math.BigDecimal segAutoTempoparada,
           java.math.BigDecimal segAutoTempoparadaSp) {
        this.dwConsol = dwConsol;
        this.dwConsolprmos = dwConsolprmos;
        this.GAutoPesoBruto = GAutoPesoBruto;
        this.GAutoPesoLiquido = GAutoPesoLiquido;
        this.GManuPesoBruto = GManuPesoBruto;
        this.GManuPesoLiquido = GManuPesoLiquido;
        this.idConsolpr = idConsolpr;
        this.omProduto = omProduto;
        this.pcsAutoProducaobruta = pcsAutoProducaobruta;
        this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
        this.pcsManuProducaobruta = pcsManuProducaobruta;
        this.pcsManuProducaorefugada = pcsManuProducaorefugada;
        this.segAutoTempoparada = segAutoTempoparada;
        this.segAutoTempoparadaSp = segAutoTempoparadaSp;
    }


    /**
     * Gets the dwConsol value for this DwConsolpr.
     * 
     * @return dwConsol
     */
    public idw.idwws.DwConsol getDwConsol() {
        return dwConsol;
    }


    /**
     * Sets the dwConsol value for this DwConsolpr.
     * 
     * @param dwConsol
     */
    public void setDwConsol(idw.idwws.DwConsol dwConsol) {
        this.dwConsol = dwConsol;
    }


    /**
     * Gets the dwConsolprmos value for this DwConsolpr.
     * 
     * @return dwConsolprmos
     */
    public idw.idwws.DwConsolprmo[] getDwConsolprmos() {
        return dwConsolprmos;
    }


    /**
     * Sets the dwConsolprmos value for this DwConsolpr.
     * 
     * @param dwConsolprmos
     */
    public void setDwConsolprmos(idw.idwws.DwConsolprmo[] dwConsolprmos) {
        this.dwConsolprmos = dwConsolprmos;
    }

    public idw.idwws.DwConsolprmo getDwConsolprmos(int i) {
        return this.dwConsolprmos[i];
    }

    public void setDwConsolprmos(int i, idw.idwws.DwConsolprmo _value) {
        this.dwConsolprmos[i] = _value;
    }


    /**
     * Gets the GAutoPesoBruto value for this DwConsolpr.
     * 
     * @return GAutoPesoBruto
     */
    public java.math.BigDecimal getGAutoPesoBruto() {
        return GAutoPesoBruto;
    }


    /**
     * Sets the GAutoPesoBruto value for this DwConsolpr.
     * 
     * @param GAutoPesoBruto
     */
    public void setGAutoPesoBruto(java.math.BigDecimal GAutoPesoBruto) {
        this.GAutoPesoBruto = GAutoPesoBruto;
    }


    /**
     * Gets the GAutoPesoLiquido value for this DwConsolpr.
     * 
     * @return GAutoPesoLiquido
     */
    public java.math.BigDecimal getGAutoPesoLiquido() {
        return GAutoPesoLiquido;
    }


    /**
     * Sets the GAutoPesoLiquido value for this DwConsolpr.
     * 
     * @param GAutoPesoLiquido
     */
    public void setGAutoPesoLiquido(java.math.BigDecimal GAutoPesoLiquido) {
        this.GAutoPesoLiquido = GAutoPesoLiquido;
    }


    /**
     * Gets the GManuPesoBruto value for this DwConsolpr.
     * 
     * @return GManuPesoBruto
     */
    public java.math.BigDecimal getGManuPesoBruto() {
        return GManuPesoBruto;
    }


    /**
     * Sets the GManuPesoBruto value for this DwConsolpr.
     * 
     * @param GManuPesoBruto
     */
    public void setGManuPesoBruto(java.math.BigDecimal GManuPesoBruto) {
        this.GManuPesoBruto = GManuPesoBruto;
    }


    /**
     * Gets the GManuPesoLiquido value for this DwConsolpr.
     * 
     * @return GManuPesoLiquido
     */
    public java.math.BigDecimal getGManuPesoLiquido() {
        return GManuPesoLiquido;
    }


    /**
     * Sets the GManuPesoLiquido value for this DwConsolpr.
     * 
     * @param GManuPesoLiquido
     */
    public void setGManuPesoLiquido(java.math.BigDecimal GManuPesoLiquido) {
        this.GManuPesoLiquido = GManuPesoLiquido;
    }


    /**
     * Gets the idConsolpr value for this DwConsolpr.
     * 
     * @return idConsolpr
     */
    public java.lang.Long getIdConsolpr() {
        return idConsolpr;
    }


    /**
     * Sets the idConsolpr value for this DwConsolpr.
     * 
     * @param idConsolpr
     */
    public void setIdConsolpr(java.lang.Long idConsolpr) {
        this.idConsolpr = idConsolpr;
    }


    /**
     * Gets the omProduto value for this DwConsolpr.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwConsolpr.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the pcsAutoProducaobruta value for this DwConsolpr.
     * 
     * @return pcsAutoProducaobruta
     */
    public java.lang.Long getPcsAutoProducaobruta() {
        return pcsAutoProducaobruta;
    }


    /**
     * Sets the pcsAutoProducaobruta value for this DwConsolpr.
     * 
     * @param pcsAutoProducaobruta
     */
    public void setPcsAutoProducaobruta(java.lang.Long pcsAutoProducaobruta) {
        this.pcsAutoProducaobruta = pcsAutoProducaobruta;
    }


    /**
     * Gets the pcsAutoProducaorefugada value for this DwConsolpr.
     * 
     * @return pcsAutoProducaorefugada
     */
    public java.lang.Long getPcsAutoProducaorefugada() {
        return pcsAutoProducaorefugada;
    }


    /**
     * Sets the pcsAutoProducaorefugada value for this DwConsolpr.
     * 
     * @param pcsAutoProducaorefugada
     */
    public void setPcsAutoProducaorefugada(java.lang.Long pcsAutoProducaorefugada) {
        this.pcsAutoProducaorefugada = pcsAutoProducaorefugada;
    }


    /**
     * Gets the pcsManuProducaobruta value for this DwConsolpr.
     * 
     * @return pcsManuProducaobruta
     */
    public java.lang.Long getPcsManuProducaobruta() {
        return pcsManuProducaobruta;
    }


    /**
     * Sets the pcsManuProducaobruta value for this DwConsolpr.
     * 
     * @param pcsManuProducaobruta
     */
    public void setPcsManuProducaobruta(java.lang.Long pcsManuProducaobruta) {
        this.pcsManuProducaobruta = pcsManuProducaobruta;
    }


    /**
     * Gets the pcsManuProducaorefugada value for this DwConsolpr.
     * 
     * @return pcsManuProducaorefugada
     */
    public java.lang.Long getPcsManuProducaorefugada() {
        return pcsManuProducaorefugada;
    }


    /**
     * Sets the pcsManuProducaorefugada value for this DwConsolpr.
     * 
     * @param pcsManuProducaorefugada
     */
    public void setPcsManuProducaorefugada(java.lang.Long pcsManuProducaorefugada) {
        this.pcsManuProducaorefugada = pcsManuProducaorefugada;
    }


    /**
     * Gets the segAutoTempoparada value for this DwConsolpr.
     * 
     * @return segAutoTempoparada
     */
    public java.math.BigDecimal getSegAutoTempoparada() {
        return segAutoTempoparada;
    }


    /**
     * Sets the segAutoTempoparada value for this DwConsolpr.
     * 
     * @param segAutoTempoparada
     */
    public void setSegAutoTempoparada(java.math.BigDecimal segAutoTempoparada) {
        this.segAutoTempoparada = segAutoTempoparada;
    }


    /**
     * Gets the segAutoTempoparadaSp value for this DwConsolpr.
     * 
     * @return segAutoTempoparadaSp
     */
    public java.math.BigDecimal getSegAutoTempoparadaSp() {
        return segAutoTempoparadaSp;
    }


    /**
     * Sets the segAutoTempoparadaSp value for this DwConsolpr.
     * 
     * @param segAutoTempoparadaSp
     */
    public void setSegAutoTempoparadaSp(java.math.BigDecimal segAutoTempoparadaSp) {
        this.segAutoTempoparadaSp = segAutoTempoparadaSp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolpr)) return false;
        DwConsolpr other = (DwConsolpr) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwConsol==null && other.getDwConsol()==null) || 
             (this.dwConsol!=null &&
              this.dwConsol.equals(other.getDwConsol()))) &&
            ((this.dwConsolprmos==null && other.getDwConsolprmos()==null) || 
             (this.dwConsolprmos!=null &&
              java.util.Arrays.equals(this.dwConsolprmos, other.getDwConsolprmos()))) &&
            ((this.GAutoPesoBruto==null && other.getGAutoPesoBruto()==null) || 
             (this.GAutoPesoBruto!=null &&
              this.GAutoPesoBruto.equals(other.getGAutoPesoBruto()))) &&
            ((this.GAutoPesoLiquido==null && other.getGAutoPesoLiquido()==null) || 
             (this.GAutoPesoLiquido!=null &&
              this.GAutoPesoLiquido.equals(other.getGAutoPesoLiquido()))) &&
            ((this.GManuPesoBruto==null && other.getGManuPesoBruto()==null) || 
             (this.GManuPesoBruto!=null &&
              this.GManuPesoBruto.equals(other.getGManuPesoBruto()))) &&
            ((this.GManuPesoLiquido==null && other.getGManuPesoLiquido()==null) || 
             (this.GManuPesoLiquido!=null &&
              this.GManuPesoLiquido.equals(other.getGManuPesoLiquido()))) &&
            ((this.idConsolpr==null && other.getIdConsolpr()==null) || 
             (this.idConsolpr!=null &&
              this.idConsolpr.equals(other.getIdConsolpr()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.pcsAutoProducaobruta==null && other.getPcsAutoProducaobruta()==null) || 
             (this.pcsAutoProducaobruta!=null &&
              this.pcsAutoProducaobruta.equals(other.getPcsAutoProducaobruta()))) &&
            ((this.pcsAutoProducaorefugada==null && other.getPcsAutoProducaorefugada()==null) || 
             (this.pcsAutoProducaorefugada!=null &&
              this.pcsAutoProducaorefugada.equals(other.getPcsAutoProducaorefugada()))) &&
            ((this.pcsManuProducaobruta==null && other.getPcsManuProducaobruta()==null) || 
             (this.pcsManuProducaobruta!=null &&
              this.pcsManuProducaobruta.equals(other.getPcsManuProducaobruta()))) &&
            ((this.pcsManuProducaorefugada==null && other.getPcsManuProducaorefugada()==null) || 
             (this.pcsManuProducaorefugada!=null &&
              this.pcsManuProducaorefugada.equals(other.getPcsManuProducaorefugada()))) &&
            ((this.segAutoTempoparada==null && other.getSegAutoTempoparada()==null) || 
             (this.segAutoTempoparada!=null &&
              this.segAutoTempoparada.equals(other.getSegAutoTempoparada()))) &&
            ((this.segAutoTempoparadaSp==null && other.getSegAutoTempoparadaSp()==null) || 
             (this.segAutoTempoparadaSp!=null &&
              this.segAutoTempoparadaSp.equals(other.getSegAutoTempoparadaSp())));
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
        if (getDwConsol() != null) {
            _hashCode += getDwConsol().hashCode();
        }
        if (getDwConsolprmos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolprmos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolprmos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGAutoPesoBruto() != null) {
            _hashCode += getGAutoPesoBruto().hashCode();
        }
        if (getGAutoPesoLiquido() != null) {
            _hashCode += getGAutoPesoLiquido().hashCode();
        }
        if (getGManuPesoBruto() != null) {
            _hashCode += getGManuPesoBruto().hashCode();
        }
        if (getGManuPesoLiquido() != null) {
            _hashCode += getGManuPesoLiquido().hashCode();
        }
        if (getIdConsolpr() != null) {
            _hashCode += getIdConsolpr().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getPcsAutoProducaobruta() != null) {
            _hashCode += getPcsAutoProducaobruta().hashCode();
        }
        if (getPcsAutoProducaorefugada() != null) {
            _hashCode += getPcsAutoProducaorefugada().hashCode();
        }
        if (getPcsManuProducaobruta() != null) {
            _hashCode += getPcsManuProducaobruta().hashCode();
        }
        if (getPcsManuProducaorefugada() != null) {
            _hashCode += getPcsManuProducaorefugada().hashCode();
        }
        if (getSegAutoTempoparada() != null) {
            _hashCode += getSegAutoTempoparada().hashCode();
        }
        if (getSegAutoTempoparadaSp() != null) {
            _hashCode += getSegAutoTempoparadaSp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolpr.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpr"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolprmos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolprmos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolprmo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GAutoPesoBruto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GAutoPesoBruto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GAutoPesoLiquido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GAutoPesoLiquido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GManuPesoBruto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GManuPesoBruto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GManuPesoLiquido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GManuPesoLiquido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolpr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolpr"));
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
        elemField.setFieldName("pcsAutoProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsAutoProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsAutoProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsManuProducaorefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsManuProducaorefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segAutoTempoparadaSp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segAutoTempoparadaSp"));
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
