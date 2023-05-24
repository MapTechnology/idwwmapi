/**
 * DwTurno.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTurno  extends idw.idwws.DwTurnoTemplate  implements java.io.Serializable {
    private java.lang.String cdTurno;

    private java.lang.String cor;

    private java.lang.String dsTurno;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwCalavu[] dwCalavus;

    private idw.idwws.DwCalsem[] dwCalsems;

    private idw.idwws.DwConsolid[] dwConsolids;

    private idw.idwws.DwRt[] dwRts;

    private long idTurno;

    private idw.idwws.OmProturno[] omProturnos;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwTurno() {
    }

    public DwTurno(
           java.lang.String cdTurno,
           java.lang.String cor,
           java.lang.String dsTurno,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwCalavu[] dwCalavus,
           idw.idwws.DwCalsem[] dwCalsems,
           idw.idwws.DwConsolid[] dwConsolids,
           idw.idwws.DwRt[] dwRts,
           long idTurno,
           idw.idwws.OmProturno[] omProturnos,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        this.cdTurno = cdTurno;
        this.cor = cor;
        this.dsTurno = dsTurno;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwCalavus = dwCalavus;
        this.dwCalsems = dwCalsems;
        this.dwConsolids = dwConsolids;
        this.dwRts = dwRts;
        this.idTurno = idTurno;
        this.omProturnos = omProturnos;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdTurno value for this DwTurno.
     * 
     * @return cdTurno
     */
    public java.lang.String getCdTurno() {
        return cdTurno;
    }


    /**
     * Sets the cdTurno value for this DwTurno.
     * 
     * @param cdTurno
     */
    public void setCdTurno(java.lang.String cdTurno) {
        this.cdTurno = cdTurno;
    }


    /**
     * Gets the cor value for this DwTurno.
     * 
     * @return cor
     */
    public java.lang.String getCor() {
        return cor;
    }


    /**
     * Sets the cor value for this DwTurno.
     * 
     * @param cor
     */
    public void setCor(java.lang.String cor) {
        this.cor = cor;
    }


    /**
     * Gets the dsTurno value for this DwTurno.
     * 
     * @return dsTurno
     */
    public java.lang.String getDsTurno() {
        return dsTurno;
    }


    /**
     * Sets the dsTurno value for this DwTurno.
     * 
     * @param dsTurno
     */
    public void setDsTurno(java.lang.String dsTurno) {
        this.dsTurno = dsTurno;
    }


    /**
     * Gets the dtRevisao value for this DwTurno.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwTurno.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwTurno.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwTurno.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwCalavus value for this DwTurno.
     * 
     * @return dwCalavus
     */
    public idw.idwws.DwCalavu[] getDwCalavus() {
        return dwCalavus;
    }


    /**
     * Sets the dwCalavus value for this DwTurno.
     * 
     * @param dwCalavus
     */
    public void setDwCalavus(idw.idwws.DwCalavu[] dwCalavus) {
        this.dwCalavus = dwCalavus;
    }

    public idw.idwws.DwCalavu getDwCalavus(int i) {
        return this.dwCalavus[i];
    }

    public void setDwCalavus(int i, idw.idwws.DwCalavu _value) {
        this.dwCalavus[i] = _value;
    }


    /**
     * Gets the dwCalsems value for this DwTurno.
     * 
     * @return dwCalsems
     */
    public idw.idwws.DwCalsem[] getDwCalsems() {
        return dwCalsems;
    }


    /**
     * Sets the dwCalsems value for this DwTurno.
     * 
     * @param dwCalsems
     */
    public void setDwCalsems(idw.idwws.DwCalsem[] dwCalsems) {
        this.dwCalsems = dwCalsems;
    }

    public idw.idwws.DwCalsem getDwCalsems(int i) {
        return this.dwCalsems[i];
    }

    public void setDwCalsems(int i, idw.idwws.DwCalsem _value) {
        this.dwCalsems[i] = _value;
    }


    /**
     * Gets the dwConsolids value for this DwTurno.
     * 
     * @return dwConsolids
     */
    public idw.idwws.DwConsolid[] getDwConsolids() {
        return dwConsolids;
    }


    /**
     * Sets the dwConsolids value for this DwTurno.
     * 
     * @param dwConsolids
     */
    public void setDwConsolids(idw.idwws.DwConsolid[] dwConsolids) {
        this.dwConsolids = dwConsolids;
    }

    public idw.idwws.DwConsolid getDwConsolids(int i) {
        return this.dwConsolids[i];
    }

    public void setDwConsolids(int i, idw.idwws.DwConsolid _value) {
        this.dwConsolids[i] = _value;
    }


    /**
     * Gets the dwRts value for this DwTurno.
     * 
     * @return dwRts
     */
    public idw.idwws.DwRt[] getDwRts() {
        return dwRts;
    }


    /**
     * Sets the dwRts value for this DwTurno.
     * 
     * @param dwRts
     */
    public void setDwRts(idw.idwws.DwRt[] dwRts) {
        this.dwRts = dwRts;
    }

    public idw.idwws.DwRt getDwRts(int i) {
        return this.dwRts[i];
    }

    public void setDwRts(int i, idw.idwws.DwRt _value) {
        this.dwRts[i] = _value;
    }


    /**
     * Gets the idTurno value for this DwTurno.
     * 
     * @return idTurno
     */
    public long getIdTurno() {
        return idTurno;
    }


    /**
     * Sets the idTurno value for this DwTurno.
     * 
     * @param idTurno
     */
    public void setIdTurno(long idTurno) {
        this.idTurno = idTurno;
    }


    /**
     * Gets the omProturnos value for this DwTurno.
     * 
     * @return omProturnos
     */
    public idw.idwws.OmProturno[] getOmProturnos() {
        return omProturnos;
    }


    /**
     * Sets the omProturnos value for this DwTurno.
     * 
     * @param omProturnos
     */
    public void setOmProturnos(idw.idwws.OmProturno[] omProturnos) {
        this.omProturnos = omProturnos;
    }

    public idw.idwws.OmProturno getOmProturnos(int i) {
        return this.omProturnos[i];
    }

    public void setOmProturnos(int i, idw.idwws.OmProturno _value) {
        this.omProturnos[i] = _value;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwTurno.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwTurno.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwTurno.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwTurno.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwTurno.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwTurno.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwTurno.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwTurno.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTurno)) return false;
        DwTurno other = (DwTurno) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdTurno==null && other.getCdTurno()==null) || 
             (this.cdTurno!=null &&
              this.cdTurno.equals(other.getCdTurno()))) &&
            ((this.cor==null && other.getCor()==null) || 
             (this.cor!=null &&
              this.cor.equals(other.getCor()))) &&
            ((this.dsTurno==null && other.getDsTurno()==null) || 
             (this.dsTurno!=null &&
              this.dsTurno.equals(other.getDsTurno()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwCalavus==null && other.getDwCalavus()==null) || 
             (this.dwCalavus!=null &&
              java.util.Arrays.equals(this.dwCalavus, other.getDwCalavus()))) &&
            ((this.dwCalsems==null && other.getDwCalsems()==null) || 
             (this.dwCalsems!=null &&
              java.util.Arrays.equals(this.dwCalsems, other.getDwCalsems()))) &&
            ((this.dwConsolids==null && other.getDwConsolids()==null) || 
             (this.dwConsolids!=null &&
              java.util.Arrays.equals(this.dwConsolids, other.getDwConsolids()))) &&
            ((this.dwRts==null && other.getDwRts()==null) || 
             (this.dwRts!=null &&
              java.util.Arrays.equals(this.dwRts, other.getDwRts()))) &&
            this.idTurno == other.getIdTurno() &&
            ((this.omProturnos==null && other.getOmProturnos()==null) || 
             (this.omProturnos!=null &&
              java.util.Arrays.equals(this.omProturnos, other.getOmProturnos()))) &&
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
        if (getCdTurno() != null) {
            _hashCode += getCdTurno().hashCode();
        }
        if (getCor() != null) {
            _hashCode += getCor().hashCode();
        }
        if (getDsTurno() != null) {
            _hashCode += getDsTurno().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwCalavus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwCalavus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwCalavus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwCalsems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwCalsems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwCalsems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwConsolids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolids(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwRts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwRts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdTurno()).hashCode();
        if (getOmProturnos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmProturnos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmProturnos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
        new org.apache.axis.description.TypeDesc(DwTurno.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsTurno"));
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
        elemField.setFieldName("dwCalavus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalavus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalavu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCalsems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalsems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalsem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProturnos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProturnos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProturno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
