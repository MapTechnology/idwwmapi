/**
 * FiltroDetalheProducaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class FiltroDetalheProducaoDTO  implements java.io.Serializable {
    private java.util.Calendar dthrfim;

    private java.util.Calendar dthrinicio;

    private long idCp;

    private long iddwConsolid;

    private idw.idwws.DwRap molde;

    private idw.idwws.OmPt ompt;

    private idw.idwws.PpCp ppCp;

    private java.lang.Byte tpId;

    public FiltroDetalheProducaoDTO() {
    }

    public FiltroDetalheProducaoDTO(
           java.util.Calendar dthrfim,
           java.util.Calendar dthrinicio,
           long idCp,
           long iddwConsolid,
           idw.idwws.DwRap molde,
           idw.idwws.OmPt ompt,
           idw.idwws.PpCp ppCp,
           java.lang.Byte tpId) {
           this.dthrfim = dthrfim;
           this.dthrinicio = dthrinicio;
           this.idCp = idCp;
           this.iddwConsolid = iddwConsolid;
           this.molde = molde;
           this.ompt = ompt;
           this.ppCp = ppCp;
           this.tpId = tpId;
    }


    /**
     * Gets the dthrfim value for this FiltroDetalheProducaoDTO.
     * 
     * @return dthrfim
     */
    public java.util.Calendar getDthrfim() {
        return dthrfim;
    }


    /**
     * Sets the dthrfim value for this FiltroDetalheProducaoDTO.
     * 
     * @param dthrfim
     */
    public void setDthrfim(java.util.Calendar dthrfim) {
        this.dthrfim = dthrfim;
    }


    /**
     * Gets the dthrinicio value for this FiltroDetalheProducaoDTO.
     * 
     * @return dthrinicio
     */
    public java.util.Calendar getDthrinicio() {
        return dthrinicio;
    }


    /**
     * Sets the dthrinicio value for this FiltroDetalheProducaoDTO.
     * 
     * @param dthrinicio
     */
    public void setDthrinicio(java.util.Calendar dthrinicio) {
        this.dthrinicio = dthrinicio;
    }


    /**
     * Gets the idCp value for this FiltroDetalheProducaoDTO.
     * 
     * @return idCp
     */
    public long getIdCp() {
        return idCp;
    }


    /**
     * Sets the idCp value for this FiltroDetalheProducaoDTO.
     * 
     * @param idCp
     */
    public void setIdCp(long idCp) {
        this.idCp = idCp;
    }


    /**
     * Gets the iddwConsolid value for this FiltroDetalheProducaoDTO.
     * 
     * @return iddwConsolid
     */
    public long getIddwConsolid() {
        return iddwConsolid;
    }


    /**
     * Sets the iddwConsolid value for this FiltroDetalheProducaoDTO.
     * 
     * @param iddwConsolid
     */
    public void setIddwConsolid(long iddwConsolid) {
        this.iddwConsolid = iddwConsolid;
    }


    /**
     * Gets the molde value for this FiltroDetalheProducaoDTO.
     * 
     * @return molde
     */
    public idw.idwws.DwRap getMolde() {
        return molde;
    }


    /**
     * Sets the molde value for this FiltroDetalheProducaoDTO.
     * 
     * @param molde
     */
    public void setMolde(idw.idwws.DwRap molde) {
        this.molde = molde;
    }


    /**
     * Gets the ompt value for this FiltroDetalheProducaoDTO.
     * 
     * @return ompt
     */
    public idw.idwws.OmPt getOmpt() {
        return ompt;
    }


    /**
     * Sets the ompt value for this FiltroDetalheProducaoDTO.
     * 
     * @param ompt
     */
    public void setOmpt(idw.idwws.OmPt ompt) {
        this.ompt = ompt;
    }


    /**
     * Gets the ppCp value for this FiltroDetalheProducaoDTO.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this FiltroDetalheProducaoDTO.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }


    /**
     * Gets the tpId value for this FiltroDetalheProducaoDTO.
     * 
     * @return tpId
     */
    public java.lang.Byte getTpId() {
        return tpId;
    }


    /**
     * Sets the tpId value for this FiltroDetalheProducaoDTO.
     * 
     * @param tpId
     */
    public void setTpId(java.lang.Byte tpId) {
        this.tpId = tpId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiltroDetalheProducaoDTO)) return false;
        FiltroDetalheProducaoDTO other = (FiltroDetalheProducaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfim==null && other.getDthrfim()==null) || 
             (this.dthrfim!=null &&
              this.dthrfim.equals(other.getDthrfim()))) &&
            ((this.dthrinicio==null && other.getDthrinicio()==null) || 
             (this.dthrinicio!=null &&
              this.dthrinicio.equals(other.getDthrinicio()))) &&
            this.idCp == other.getIdCp() &&
            this.iddwConsolid == other.getIddwConsolid() &&
            ((this.molde==null && other.getMolde()==null) || 
             (this.molde!=null &&
              this.molde.equals(other.getMolde()))) &&
            ((this.ompt==null && other.getOmpt()==null) || 
             (this.ompt!=null &&
              this.ompt.equals(other.getOmpt()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp()))) &&
            ((this.tpId==null && other.getTpId()==null) || 
             (this.tpId!=null &&
              this.tpId.equals(other.getTpId())));
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
        if (getDthrfim() != null) {
            _hashCode += getDthrfim().hashCode();
        }
        if (getDthrinicio() != null) {
            _hashCode += getDthrinicio().hashCode();
        }
        _hashCode += new Long(getIdCp()).hashCode();
        _hashCode += new Long(getIddwConsolid()).hashCode();
        if (getMolde() != null) {
            _hashCode += getMolde().hashCode();
        }
        if (getOmpt() != null) {
            _hashCode += getOmpt().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        if (getTpId() != null) {
            _hashCode += getTpId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiltroDetalheProducaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "filtroDetalheProducaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iddwConsolid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iddwConsolid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("molde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "molde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ompt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ompt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
