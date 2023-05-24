/**
 * OmPrgpos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmPrgpos  implements java.io.Serializable {
    private idw.idwws.DwRap dwRapByIdRaptipofeeder;

    private idw.idwws.DwRap dwRapByIdRaptipomesa;

    private java.lang.String feedertable;

    private java.lang.String feedertrack;

    private long idPrgpos;

    private java.lang.String name;

    private idw.idwws.OmPa omPa;

    private idw.idwws.OmPrg omPrg;

    private idw.idwws.OmProduto omProduto;

    private java.lang.Integer ordem;

    private java.lang.String pocket;

    private java.math.BigDecimal posicao;

    private java.math.BigDecimal qtUsada;

    private java.lang.String scantrack;

    public OmPrgpos() {
    }

    public OmPrgpos(
           idw.idwws.DwRap dwRapByIdRaptipofeeder,
           idw.idwws.DwRap dwRapByIdRaptipomesa,
           java.lang.String feedertable,
           java.lang.String feedertrack,
           long idPrgpos,
           java.lang.String name,
           idw.idwws.OmPa omPa,
           idw.idwws.OmPrg omPrg,
           idw.idwws.OmProduto omProduto,
           java.lang.Integer ordem,
           java.lang.String pocket,
           java.math.BigDecimal posicao,
           java.math.BigDecimal qtUsada,
           java.lang.String scantrack) {
           this.dwRapByIdRaptipofeeder = dwRapByIdRaptipofeeder;
           this.dwRapByIdRaptipomesa = dwRapByIdRaptipomesa;
           this.feedertable = feedertable;
           this.feedertrack = feedertrack;
           this.idPrgpos = idPrgpos;
           this.name = name;
           this.omPa = omPa;
           this.omPrg = omPrg;
           this.omProduto = omProduto;
           this.ordem = ordem;
           this.pocket = pocket;
           this.posicao = posicao;
           this.qtUsada = qtUsada;
           this.scantrack = scantrack;
    }


    /**
     * Gets the dwRapByIdRaptipofeeder value for this OmPrgpos.
     * 
     * @return dwRapByIdRaptipofeeder
     */
    public idw.idwws.DwRap getDwRapByIdRaptipofeeder() {
        return dwRapByIdRaptipofeeder;
    }


    /**
     * Sets the dwRapByIdRaptipofeeder value for this OmPrgpos.
     * 
     * @param dwRapByIdRaptipofeeder
     */
    public void setDwRapByIdRaptipofeeder(idw.idwws.DwRap dwRapByIdRaptipofeeder) {
        this.dwRapByIdRaptipofeeder = dwRapByIdRaptipofeeder;
    }


    /**
     * Gets the dwRapByIdRaptipomesa value for this OmPrgpos.
     * 
     * @return dwRapByIdRaptipomesa
     */
    public idw.idwws.DwRap getDwRapByIdRaptipomesa() {
        return dwRapByIdRaptipomesa;
    }


    /**
     * Sets the dwRapByIdRaptipomesa value for this OmPrgpos.
     * 
     * @param dwRapByIdRaptipomesa
     */
    public void setDwRapByIdRaptipomesa(idw.idwws.DwRap dwRapByIdRaptipomesa) {
        this.dwRapByIdRaptipomesa = dwRapByIdRaptipomesa;
    }


    /**
     * Gets the feedertable value for this OmPrgpos.
     * 
     * @return feedertable
     */
    public java.lang.String getFeedertable() {
        return feedertable;
    }


    /**
     * Sets the feedertable value for this OmPrgpos.
     * 
     * @param feedertable
     */
    public void setFeedertable(java.lang.String feedertable) {
        this.feedertable = feedertable;
    }


    /**
     * Gets the feedertrack value for this OmPrgpos.
     * 
     * @return feedertrack
     */
    public java.lang.String getFeedertrack() {
        return feedertrack;
    }


    /**
     * Sets the feedertrack value for this OmPrgpos.
     * 
     * @param feedertrack
     */
    public void setFeedertrack(java.lang.String feedertrack) {
        this.feedertrack = feedertrack;
    }


    /**
     * Gets the idPrgpos value for this OmPrgpos.
     * 
     * @return idPrgpos
     */
    public long getIdPrgpos() {
        return idPrgpos;
    }


    /**
     * Sets the idPrgpos value for this OmPrgpos.
     * 
     * @param idPrgpos
     */
    public void setIdPrgpos(long idPrgpos) {
        this.idPrgpos = idPrgpos;
    }


    /**
     * Gets the name value for this OmPrgpos.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this OmPrgpos.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the omPa value for this OmPrgpos.
     * 
     * @return omPa
     */
    public idw.idwws.OmPa getOmPa() {
        return omPa;
    }


    /**
     * Sets the omPa value for this OmPrgpos.
     * 
     * @param omPa
     */
    public void setOmPa(idw.idwws.OmPa omPa) {
        this.omPa = omPa;
    }


    /**
     * Gets the omPrg value for this OmPrgpos.
     * 
     * @return omPrg
     */
    public idw.idwws.OmPrg getOmPrg() {
        return omPrg;
    }


    /**
     * Sets the omPrg value for this OmPrgpos.
     * 
     * @param omPrg
     */
    public void setOmPrg(idw.idwws.OmPrg omPrg) {
        this.omPrg = omPrg;
    }


    /**
     * Gets the omProduto value for this OmPrgpos.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this OmPrgpos.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the ordem value for this OmPrgpos.
     * 
     * @return ordem
     */
    public java.lang.Integer getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this OmPrgpos.
     * 
     * @param ordem
     */
    public void setOrdem(java.lang.Integer ordem) {
        this.ordem = ordem;
    }


    /**
     * Gets the pocket value for this OmPrgpos.
     * 
     * @return pocket
     */
    public java.lang.String getPocket() {
        return pocket;
    }


    /**
     * Sets the pocket value for this OmPrgpos.
     * 
     * @param pocket
     */
    public void setPocket(java.lang.String pocket) {
        this.pocket = pocket;
    }


    /**
     * Gets the posicao value for this OmPrgpos.
     * 
     * @return posicao
     */
    public java.math.BigDecimal getPosicao() {
        return posicao;
    }


    /**
     * Sets the posicao value for this OmPrgpos.
     * 
     * @param posicao
     */
    public void setPosicao(java.math.BigDecimal posicao) {
        this.posicao = posicao;
    }


    /**
     * Gets the qtUsada value for this OmPrgpos.
     * 
     * @return qtUsada
     */
    public java.math.BigDecimal getQtUsada() {
        return qtUsada;
    }


    /**
     * Sets the qtUsada value for this OmPrgpos.
     * 
     * @param qtUsada
     */
    public void setQtUsada(java.math.BigDecimal qtUsada) {
        this.qtUsada = qtUsada;
    }


    /**
     * Gets the scantrack value for this OmPrgpos.
     * 
     * @return scantrack
     */
    public java.lang.String getScantrack() {
        return scantrack;
    }


    /**
     * Sets the scantrack value for this OmPrgpos.
     * 
     * @param scantrack
     */
    public void setScantrack(java.lang.String scantrack) {
        this.scantrack = scantrack;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmPrgpos)) return false;
        OmPrgpos other = (OmPrgpos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwRapByIdRaptipofeeder==null && other.getDwRapByIdRaptipofeeder()==null) || 
             (this.dwRapByIdRaptipofeeder!=null &&
              this.dwRapByIdRaptipofeeder.equals(other.getDwRapByIdRaptipofeeder()))) &&
            ((this.dwRapByIdRaptipomesa==null && other.getDwRapByIdRaptipomesa()==null) || 
             (this.dwRapByIdRaptipomesa!=null &&
              this.dwRapByIdRaptipomesa.equals(other.getDwRapByIdRaptipomesa()))) &&
            ((this.feedertable==null && other.getFeedertable()==null) || 
             (this.feedertable!=null &&
              this.feedertable.equals(other.getFeedertable()))) &&
            ((this.feedertrack==null && other.getFeedertrack()==null) || 
             (this.feedertrack!=null &&
              this.feedertrack.equals(other.getFeedertrack()))) &&
            this.idPrgpos == other.getIdPrgpos() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.omPa==null && other.getOmPa()==null) || 
             (this.omPa!=null &&
              this.omPa.equals(other.getOmPa()))) &&
            ((this.omPrg==null && other.getOmPrg()==null) || 
             (this.omPrg!=null &&
              this.omPrg.equals(other.getOmPrg()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem()))) &&
            ((this.pocket==null && other.getPocket()==null) || 
             (this.pocket!=null &&
              this.pocket.equals(other.getPocket()))) &&
            ((this.posicao==null && other.getPosicao()==null) || 
             (this.posicao!=null &&
              this.posicao.equals(other.getPosicao()))) &&
            ((this.qtUsada==null && other.getQtUsada()==null) || 
             (this.qtUsada!=null &&
              this.qtUsada.equals(other.getQtUsada()))) &&
            ((this.scantrack==null && other.getScantrack()==null) || 
             (this.scantrack!=null &&
              this.scantrack.equals(other.getScantrack())));
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
        if (getDwRapByIdRaptipofeeder() != null) {
            _hashCode += getDwRapByIdRaptipofeeder().hashCode();
        }
        if (getDwRapByIdRaptipomesa() != null) {
            _hashCode += getDwRapByIdRaptipomesa().hashCode();
        }
        if (getFeedertable() != null) {
            _hashCode += getFeedertable().hashCode();
        }
        if (getFeedertrack() != null) {
            _hashCode += getFeedertrack().hashCode();
        }
        _hashCode += new Long(getIdPrgpos()).hashCode();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getOmPa() != null) {
            _hashCode += getOmPa().hashCode();
        }
        if (getOmPrg() != null) {
            _hashCode += getOmPrg().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
        }
        if (getPocket() != null) {
            _hashCode += getPocket().hashCode();
        }
        if (getPosicao() != null) {
            _hashCode += getPosicao().hashCode();
        }
        if (getQtUsada() != null) {
            _hashCode += getQtUsada().hashCode();
        }
        if (getScantrack() != null) {
            _hashCode += getScantrack().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmPrgpos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPrgpos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRapByIdRaptipofeeder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRapByIdRaptipofeeder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRapByIdRaptipomesa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRapByIdRaptipomesa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feedertable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feedertable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feedertrack");
        elemField.setXmlName(new javax.xml.namespace.QName("", "feedertrack"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPrgpos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPrgpos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("omPrg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPrg"));
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
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pocket");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pocket"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posicao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posicao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scantrack");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scantrack"));
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
