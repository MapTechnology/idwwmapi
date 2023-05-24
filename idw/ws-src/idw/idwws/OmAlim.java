/**
 * OmAlim.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class OmAlim  extends idw.idwws.OmAlimTemplate  implements java.io.Serializable {
    private java.lang.String cdAlim;

    private java.lang.String dsAlim;

    private java.util.Calendar dtStativo;

    private long idAlim;

    private idw.idwws.OmAlimrea[] omAlimreas;

    private idw.idwws.OmMapa omMapa;

    private idw.idwws.OmPt[] omPtsForIdAlim;

    private idw.idwws.OmPt[] omPtsForIdAlimcorrente;

    private idw.idwws.OmPt[] omPtsForIdAlimpre;

    private idw.idwws.OmUsr omUsr;

    private java.lang.Byte stAlim;

    private java.lang.Byte tpAlim;

    public OmAlim() {
    }

    public OmAlim(
           java.lang.String cdAlim,
           java.lang.String dsAlim,
           java.util.Calendar dtStativo,
           long idAlim,
           idw.idwws.OmAlimrea[] omAlimreas,
           idw.idwws.OmMapa omMapa,
           idw.idwws.OmPt[] omPtsForIdAlim,
           idw.idwws.OmPt[] omPtsForIdAlimcorrente,
           idw.idwws.OmPt[] omPtsForIdAlimpre,
           idw.idwws.OmUsr omUsr,
           java.lang.Byte stAlim,
           java.lang.Byte tpAlim) {
        this.cdAlim = cdAlim;
        this.dsAlim = dsAlim;
        this.dtStativo = dtStativo;
        this.idAlim = idAlim;
        this.omAlimreas = omAlimreas;
        this.omMapa = omMapa;
        this.omPtsForIdAlim = omPtsForIdAlim;
        this.omPtsForIdAlimcorrente = omPtsForIdAlimcorrente;
        this.omPtsForIdAlimpre = omPtsForIdAlimpre;
        this.omUsr = omUsr;
        this.stAlim = stAlim;
        this.tpAlim = tpAlim;
    }


    /**
     * Gets the cdAlim value for this OmAlim.
     * 
     * @return cdAlim
     */
    public java.lang.String getCdAlim() {
        return cdAlim;
    }


    /**
     * Sets the cdAlim value for this OmAlim.
     * 
     * @param cdAlim
     */
    public void setCdAlim(java.lang.String cdAlim) {
        this.cdAlim = cdAlim;
    }


    /**
     * Gets the dsAlim value for this OmAlim.
     * 
     * @return dsAlim
     */
    public java.lang.String getDsAlim() {
        return dsAlim;
    }


    /**
     * Sets the dsAlim value for this OmAlim.
     * 
     * @param dsAlim
     */
    public void setDsAlim(java.lang.String dsAlim) {
        this.dsAlim = dsAlim;
    }


    /**
     * Gets the dtStativo value for this OmAlim.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this OmAlim.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the idAlim value for this OmAlim.
     * 
     * @return idAlim
     */
    public long getIdAlim() {
        return idAlim;
    }


    /**
     * Sets the idAlim value for this OmAlim.
     * 
     * @param idAlim
     */
    public void setIdAlim(long idAlim) {
        this.idAlim = idAlim;
    }


    /**
     * Gets the omAlimreas value for this OmAlim.
     * 
     * @return omAlimreas
     */
    public idw.idwws.OmAlimrea[] getOmAlimreas() {
        return omAlimreas;
    }


    /**
     * Sets the omAlimreas value for this OmAlim.
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
     * Gets the omMapa value for this OmAlim.
     * 
     * @return omMapa
     */
    public idw.idwws.OmMapa getOmMapa() {
        return omMapa;
    }


    /**
     * Sets the omMapa value for this OmAlim.
     * 
     * @param omMapa
     */
    public void setOmMapa(idw.idwws.OmMapa omMapa) {
        this.omMapa = omMapa;
    }


    /**
     * Gets the omPtsForIdAlim value for this OmAlim.
     * 
     * @return omPtsForIdAlim
     */
    public idw.idwws.OmPt[] getOmPtsForIdAlim() {
        return omPtsForIdAlim;
    }


    /**
     * Sets the omPtsForIdAlim value for this OmAlim.
     * 
     * @param omPtsForIdAlim
     */
    public void setOmPtsForIdAlim(idw.idwws.OmPt[] omPtsForIdAlim) {
        this.omPtsForIdAlim = omPtsForIdAlim;
    }

    public idw.idwws.OmPt getOmPtsForIdAlim(int i) {
        return this.omPtsForIdAlim[i];
    }

    public void setOmPtsForIdAlim(int i, idw.idwws.OmPt _value) {
        this.omPtsForIdAlim[i] = _value;
    }


    /**
     * Gets the omPtsForIdAlimcorrente value for this OmAlim.
     * 
     * @return omPtsForIdAlimcorrente
     */
    public idw.idwws.OmPt[] getOmPtsForIdAlimcorrente() {
        return omPtsForIdAlimcorrente;
    }


    /**
     * Sets the omPtsForIdAlimcorrente value for this OmAlim.
     * 
     * @param omPtsForIdAlimcorrente
     */
    public void setOmPtsForIdAlimcorrente(idw.idwws.OmPt[] omPtsForIdAlimcorrente) {
        this.omPtsForIdAlimcorrente = omPtsForIdAlimcorrente;
    }

    public idw.idwws.OmPt getOmPtsForIdAlimcorrente(int i) {
        return this.omPtsForIdAlimcorrente[i];
    }

    public void setOmPtsForIdAlimcorrente(int i, idw.idwws.OmPt _value) {
        this.omPtsForIdAlimcorrente[i] = _value;
    }


    /**
     * Gets the omPtsForIdAlimpre value for this OmAlim.
     * 
     * @return omPtsForIdAlimpre
     */
    public idw.idwws.OmPt[] getOmPtsForIdAlimpre() {
        return omPtsForIdAlimpre;
    }


    /**
     * Sets the omPtsForIdAlimpre value for this OmAlim.
     * 
     * @param omPtsForIdAlimpre
     */
    public void setOmPtsForIdAlimpre(idw.idwws.OmPt[] omPtsForIdAlimpre) {
        this.omPtsForIdAlimpre = omPtsForIdAlimpre;
    }

    public idw.idwws.OmPt getOmPtsForIdAlimpre(int i) {
        return this.omPtsForIdAlimpre[i];
    }

    public void setOmPtsForIdAlimpre(int i, idw.idwws.OmPt _value) {
        this.omPtsForIdAlimpre[i] = _value;
    }


    /**
     * Gets the omUsr value for this OmAlim.
     * 
     * @return omUsr
     */
    public idw.idwws.OmUsr getOmUsr() {
        return omUsr;
    }


    /**
     * Sets the omUsr value for this OmAlim.
     * 
     * @param omUsr
     */
    public void setOmUsr(idw.idwws.OmUsr omUsr) {
        this.omUsr = omUsr;
    }


    /**
     * Gets the stAlim value for this OmAlim.
     * 
     * @return stAlim
     */
    public java.lang.Byte getStAlim() {
        return stAlim;
    }


    /**
     * Sets the stAlim value for this OmAlim.
     * 
     * @param stAlim
     */
    public void setStAlim(java.lang.Byte stAlim) {
        this.stAlim = stAlim;
    }


    /**
     * Gets the tpAlim value for this OmAlim.
     * 
     * @return tpAlim
     */
    public java.lang.Byte getTpAlim() {
        return tpAlim;
    }


    /**
     * Sets the tpAlim value for this OmAlim.
     * 
     * @param tpAlim
     */
    public void setTpAlim(java.lang.Byte tpAlim) {
        this.tpAlim = tpAlim;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OmAlim)) return false;
        OmAlim other = (OmAlim) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdAlim==null && other.getCdAlim()==null) || 
             (this.cdAlim!=null &&
              this.cdAlim.equals(other.getCdAlim()))) &&
            ((this.dsAlim==null && other.getDsAlim()==null) || 
             (this.dsAlim!=null &&
              this.dsAlim.equals(other.getDsAlim()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            this.idAlim == other.getIdAlim() &&
            ((this.omAlimreas==null && other.getOmAlimreas()==null) || 
             (this.omAlimreas!=null &&
              java.util.Arrays.equals(this.omAlimreas, other.getOmAlimreas()))) &&
            ((this.omMapa==null && other.getOmMapa()==null) || 
             (this.omMapa!=null &&
              this.omMapa.equals(other.getOmMapa()))) &&
            ((this.omPtsForIdAlim==null && other.getOmPtsForIdAlim()==null) || 
             (this.omPtsForIdAlim!=null &&
              java.util.Arrays.equals(this.omPtsForIdAlim, other.getOmPtsForIdAlim()))) &&
            ((this.omPtsForIdAlimcorrente==null && other.getOmPtsForIdAlimcorrente()==null) || 
             (this.omPtsForIdAlimcorrente!=null &&
              java.util.Arrays.equals(this.omPtsForIdAlimcorrente, other.getOmPtsForIdAlimcorrente()))) &&
            ((this.omPtsForIdAlimpre==null && other.getOmPtsForIdAlimpre()==null) || 
             (this.omPtsForIdAlimpre!=null &&
              java.util.Arrays.equals(this.omPtsForIdAlimpre, other.getOmPtsForIdAlimpre()))) &&
            ((this.omUsr==null && other.getOmUsr()==null) || 
             (this.omUsr!=null &&
              this.omUsr.equals(other.getOmUsr()))) &&
            ((this.stAlim==null && other.getStAlim()==null) || 
             (this.stAlim!=null &&
              this.stAlim.equals(other.getStAlim()))) &&
            ((this.tpAlim==null && other.getTpAlim()==null) || 
             (this.tpAlim!=null &&
              this.tpAlim.equals(other.getTpAlim())));
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
        if (getCdAlim() != null) {
            _hashCode += getCdAlim().hashCode();
        }
        if (getDsAlim() != null) {
            _hashCode += getDsAlim().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        _hashCode += new Long(getIdAlim()).hashCode();
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
        if (getOmPtsForIdAlim() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPtsForIdAlim());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPtsForIdAlim(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPtsForIdAlimcorrente() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPtsForIdAlimcorrente());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPtsForIdAlimcorrente(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmPtsForIdAlimpre() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmPtsForIdAlimpre());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmPtsForIdAlimpre(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmUsr() != null) {
            _hashCode += getOmUsr().hashCode();
        }
        if (getStAlim() != null) {
            _hashCode += getStAlim().hashCode();
        }
        if (getTpAlim() != null) {
            _hashCode += getTpAlim().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OmAlim.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omAlim"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdAlim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdAlim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsAlim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsAlim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtStativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtStativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAlim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAlim"));
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
        elemField.setFieldName("omPtsForIdAlim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPtsForIdAlim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPtsForIdAlimcorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPtsForIdAlimcorrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPtsForIdAlimpre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPtsForIdAlimpre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAlim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAlim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpAlim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpAlim"));
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
