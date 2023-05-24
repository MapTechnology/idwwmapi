/**
 * DwTArea.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTArea  extends idw.idwws.DwTAreaTemplate  implements java.io.Serializable {
    private java.lang.String cdArea;

    private java.lang.String dsArea;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwProcativ[] dwProcativs;

    private idw.idwws.DwTParada[] dwTParadas;

    private idw.idwws.DwTRefugo[] dwTRefugos;

    private long idArea;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwTArea() {
    }

    public DwTArea(
           java.lang.Long id,
           java.lang.String cdArea,
           java.lang.String dsArea,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwProcativ[] dwProcativs,
           idw.idwws.DwTParada[] dwTParadas,
           idw.idwws.DwTRefugo[] dwTRefugos,
           long idArea,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdArea = cdArea;
        this.dsArea = dsArea;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwProcativs = dwProcativs;
        this.dwTParadas = dwTParadas;
        this.dwTRefugos = dwTRefugos;
        this.idArea = idArea;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdArea value for this DwTArea.
     * 
     * @return cdArea
     */
    public java.lang.String getCdArea() {
        return cdArea;
    }


    /**
     * Sets the cdArea value for this DwTArea.
     * 
     * @param cdArea
     */
    public void setCdArea(java.lang.String cdArea) {
        this.cdArea = cdArea;
    }


    /**
     * Gets the dsArea value for this DwTArea.
     * 
     * @return dsArea
     */
    public java.lang.String getDsArea() {
        return dsArea;
    }


    /**
     * Sets the dsArea value for this DwTArea.
     * 
     * @param dsArea
     */
    public void setDsArea(java.lang.String dsArea) {
        this.dsArea = dsArea;
    }


    /**
     * Gets the dtRevisao value for this DwTArea.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwTArea.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwTArea.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwTArea.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwProcativs value for this DwTArea.
     * 
     * @return dwProcativs
     */
    public idw.idwws.DwProcativ[] getDwProcativs() {
        return dwProcativs;
    }


    /**
     * Sets the dwProcativs value for this DwTArea.
     * 
     * @param dwProcativs
     */
    public void setDwProcativs(idw.idwws.DwProcativ[] dwProcativs) {
        this.dwProcativs = dwProcativs;
    }

    public idw.idwws.DwProcativ getDwProcativs(int i) {
        return this.dwProcativs[i];
    }

    public void setDwProcativs(int i, idw.idwws.DwProcativ _value) {
        this.dwProcativs[i] = _value;
    }


    /**
     * Gets the dwTParadas value for this DwTArea.
     * 
     * @return dwTParadas
     */
    public idw.idwws.DwTParada[] getDwTParadas() {
        return dwTParadas;
    }


    /**
     * Sets the dwTParadas value for this DwTArea.
     * 
     * @param dwTParadas
     */
    public void setDwTParadas(idw.idwws.DwTParada[] dwTParadas) {
        this.dwTParadas = dwTParadas;
    }

    public idw.idwws.DwTParada getDwTParadas(int i) {
        return this.dwTParadas[i];
    }

    public void setDwTParadas(int i, idw.idwws.DwTParada _value) {
        this.dwTParadas[i] = _value;
    }


    /**
     * Gets the dwTRefugos value for this DwTArea.
     * 
     * @return dwTRefugos
     */
    public idw.idwws.DwTRefugo[] getDwTRefugos() {
        return dwTRefugos;
    }


    /**
     * Sets the dwTRefugos value for this DwTArea.
     * 
     * @param dwTRefugos
     */
    public void setDwTRefugos(idw.idwws.DwTRefugo[] dwTRefugos) {
        this.dwTRefugos = dwTRefugos;
    }

    public idw.idwws.DwTRefugo getDwTRefugos(int i) {
        return this.dwTRefugos[i];
    }

    public void setDwTRefugos(int i, idw.idwws.DwTRefugo _value) {
        this.dwTRefugos[i] = _value;
    }


    /**
     * Gets the idArea value for this DwTArea.
     * 
     * @return idArea
     */
    public long getIdArea() {
        return idArea;
    }


    /**
     * Sets the idArea value for this DwTArea.
     * 
     * @param idArea
     */
    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwTArea.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwTArea.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwTArea.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwTArea.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwTArea.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwTArea.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwTArea.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwTArea.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTArea)) return false;
        DwTArea other = (DwTArea) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdArea==null && other.getCdArea()==null) || 
             (this.cdArea!=null &&
              this.cdArea.equals(other.getCdArea()))) &&
            ((this.dsArea==null && other.getDsArea()==null) || 
             (this.dsArea!=null &&
              this.dsArea.equals(other.getDsArea()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwProcativs==null && other.getDwProcativs()==null) || 
             (this.dwProcativs!=null &&
              java.util.Arrays.equals(this.dwProcativs, other.getDwProcativs()))) &&
            ((this.dwTParadas==null && other.getDwTParadas()==null) || 
             (this.dwTParadas!=null &&
              java.util.Arrays.equals(this.dwTParadas, other.getDwTParadas()))) &&
            ((this.dwTRefugos==null && other.getDwTRefugos()==null) || 
             (this.dwTRefugos!=null &&
              java.util.Arrays.equals(this.dwTRefugos, other.getDwTRefugos()))) &&
            this.idArea == other.getIdArea() &&
            ((this.omUsrByIdUsrrevisao==null && other.getOmUsrByIdUsrrevisao()==null) || 
             (this.omUsrByIdUsrrevisao!=null &&
              this.omUsrByIdUsrrevisao.equals(other.getOmUsrByIdUsrrevisao()))) &&
            ((this.omUsrByIdUsrstativo==null && other.getOmUsrByIdUsrstativo()==null) || 
             (this.omUsrByIdUsrstativo!=null &&
              this.omUsrByIdUsrstativo.equals(other.getOmUsrByIdUsrstativo()))) &&
            ((this.revisao==null && other.getRevisao()==null) || 
             (this.revisao!=null &&
              this.revisao.equals(other.getRevisao()))) &&
            ((this.stAtivo==null && other.getStAtivo()==null) || 
             (this.stAtivo!=null &&
              this.stAtivo.equals(other.getStAtivo())));
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
        if (getCdArea() != null) {
            _hashCode += getCdArea().hashCode();
        }
        if (getDsArea() != null) {
            _hashCode += getDsArea().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwProcativs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwProcativs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwProcativs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTParadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTParadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTParadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwTRefugos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTRefugos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTRefugos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdArea()).hashCode();
        if (getOmUsrByIdUsrrevisao() != null) {
            _hashCode += getOmUsrByIdUsrrevisao().hashCode();
        }
        if (getOmUsrByIdUsrstativo() != null) {
            _hashCode += getOmUsrByIdUsrstativo().hashCode();
        }
        if (getRevisao() != null) {
            _hashCode += getRevisao().hashCode();
        }
        if (getStAtivo() != null) {
            _hashCode += getStAtivo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwTArea.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTArea"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtRevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtRevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
        elemField.setFieldName("dwProcativs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProcativs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcativ"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTParadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTParadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTParada"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTRefugos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTRefugos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTRefugo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrrevisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrrevisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omUsrByIdUsrstativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omUsrByIdUsrstativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omUsr"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "revisao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAtivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAtivo"));
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
