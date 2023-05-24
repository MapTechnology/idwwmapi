/**
 * DwProcedimento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwProcedimento  extends idw.idwws.DwProcedimentoTemplate  implements java.io.Serializable {
    private java.lang.String cdProcedimento;

    private java.lang.String dsProcedimento;

    private java.util.Calendar dtRevisao;

    private java.util.Calendar dtStativo;

    private idw.idwws.DwFolha[] dwFolhas;

    private idw.idwws.DwProcarhom[] dwProcarhoms;

    private idw.idwws.DwProcativ[] dwProcativs;

    private idw.idwws.DwProrea[] dwProreas;

    private java.lang.Long idProcedimento;

    private idw.idwws.OmUsr omUsrByIdUsrrevisao;

    private idw.idwws.OmUsr omUsrByIdUsrstativo;

    private java.lang.Long revisao;

    private java.lang.Byte stAtivo;

    public DwProcedimento() {
    }

    public DwProcedimento(
           java.lang.Long id,
           java.lang.String cdProcedimento,
           java.lang.String dsProcedimento,
           java.util.Calendar dtRevisao,
           java.util.Calendar dtStativo,
           idw.idwws.DwFolha[] dwFolhas,
           idw.idwws.DwProcarhom[] dwProcarhoms,
           idw.idwws.DwProcativ[] dwProcativs,
           idw.idwws.DwProrea[] dwProreas,
           java.lang.Long idProcedimento,
           idw.idwws.OmUsr omUsrByIdUsrrevisao,
           idw.idwws.OmUsr omUsrByIdUsrstativo,
           java.lang.Long revisao,
           java.lang.Byte stAtivo) {
        super(
            id);
        this.cdProcedimento = cdProcedimento;
        this.dsProcedimento = dsProcedimento;
        this.dtRevisao = dtRevisao;
        this.dtStativo = dtStativo;
        this.dwFolhas = dwFolhas;
        this.dwProcarhoms = dwProcarhoms;
        this.dwProcativs = dwProcativs;
        this.dwProreas = dwProreas;
        this.idProcedimento = idProcedimento;
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
        this.revisao = revisao;
        this.stAtivo = stAtivo;
    }


    /**
     * Gets the cdProcedimento value for this DwProcedimento.
     * 
     * @return cdProcedimento
     */
    public java.lang.String getCdProcedimento() {
        return cdProcedimento;
    }


    /**
     * Sets the cdProcedimento value for this DwProcedimento.
     * 
     * @param cdProcedimento
     */
    public void setCdProcedimento(java.lang.String cdProcedimento) {
        this.cdProcedimento = cdProcedimento;
    }


    /**
     * Gets the dsProcedimento value for this DwProcedimento.
     * 
     * @return dsProcedimento
     */
    public java.lang.String getDsProcedimento() {
        return dsProcedimento;
    }


    /**
     * Sets the dsProcedimento value for this DwProcedimento.
     * 
     * @param dsProcedimento
     */
    public void setDsProcedimento(java.lang.String dsProcedimento) {
        this.dsProcedimento = dsProcedimento;
    }
    

    /**
     * Gets the dtRevisao value for this DwProcedimento.
     * 
     * @return dtRevisao
     */
    public java.util.Calendar getDtRevisao() {
        return dtRevisao;
    }


    /**
     * Sets the dtRevisao value for this DwProcedimento.
     * 
     * @param dtRevisao
     */
    public void setDtRevisao(java.util.Calendar dtRevisao) {
        this.dtRevisao = dtRevisao;
    }


    /**
     * Gets the dtStativo value for this DwProcedimento.
     * 
     * @return dtStativo
     */
    public java.util.Calendar getDtStativo() {
        return dtStativo;
    }


    /**
     * Sets the dtStativo value for this DwProcedimento.
     * 
     * @param dtStativo
     */
    public void setDtStativo(java.util.Calendar dtStativo) {
        this.dtStativo = dtStativo;
    }


    /**
     * Gets the dwFolhas value for this DwProcedimento.
     * 
     * @return dwFolhas
     */
    public idw.idwws.DwFolha[] getDwFolhas() {
        return dwFolhas;
    }


    /**
     * Sets the dwFolhas value for this DwProcedimento.
     * 
     * @param dwFolhas
     */
    public void setDwFolhas(idw.idwws.DwFolha[] dwFolhas) {
        this.dwFolhas = dwFolhas;
    }

    public idw.idwws.DwFolha getDwFolhas(int i) {
        return this.dwFolhas[i];
    }

    public void setDwFolhas(int i, idw.idwws.DwFolha _value) {
        this.dwFolhas[i] = _value;
    }


    /**
     * Gets the dwProcarhoms value for this DwProcedimento.
     * 
     * @return dwProcarhoms
     */
    public idw.idwws.DwProcarhom[] getDwProcarhoms() {
        return dwProcarhoms;
    }


    /**
     * Sets the dwProcarhoms value for this DwProcedimento.
     * 
     * @param dwProcarhoms
     */
    public void setDwProcarhoms(idw.idwws.DwProcarhom[] dwProcarhoms) {
        this.dwProcarhoms = dwProcarhoms;
    }

    public idw.idwws.DwProcarhom getDwProcarhoms(int i) {
        return this.dwProcarhoms[i];
    }

    public void setDwProcarhoms(int i, idw.idwws.DwProcarhom _value) {
        this.dwProcarhoms[i] = _value;
    }


    /**
     * Gets the dwProcativs value for this DwProcedimento.
     * 
     * @return dwProcativs
     */
    public idw.idwws.DwProcativ[] getDwProcativs() {
        return dwProcativs;
    }


    /**
     * Sets the dwProcativs value for this DwProcedimento.
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
     * Gets the dwProreas value for this DwProcedimento.
     * 
     * @return dwProreas
     */
    public idw.idwws.DwProrea[] getDwProreas() {
        return dwProreas;
    }


    /**
     * Sets the dwProreas value for this DwProcedimento.
     * 
     * @param dwProreas
     */
    public void setDwProreas(idw.idwws.DwProrea[] dwProreas) {
        this.dwProreas = dwProreas;
    }

    public idw.idwws.DwProrea getDwProreas(int i) {
        return this.dwProreas[i];
    }

    public void setDwProreas(int i, idw.idwws.DwProrea _value) {
        this.dwProreas[i] = _value;
    }


    /**
     * Gets the idProcedimento value for this DwProcedimento.
     * 
     * @return idProcedimento
     */
    public java.lang.Long getIdProcedimento() {
        return idProcedimento;
    }


    /**
     * Sets the idProcedimento value for this DwProcedimento.
     * 
     * @param idProcedimento
     */
    public void setIdProcedimento(java.lang.Long idProcedimento) {
        this.idProcedimento = idProcedimento;
    }


    /**
     * Gets the omUsrByIdUsrrevisao value for this DwProcedimento.
     * 
     * @return omUsrByIdUsrrevisao
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrrevisao() {
        return omUsrByIdUsrrevisao;
    }


    /**
     * Sets the omUsrByIdUsrrevisao value for this DwProcedimento.
     * 
     * @param omUsrByIdUsrrevisao
     */
    public void setOmUsrByIdUsrrevisao(idw.idwws.OmUsr omUsrByIdUsrrevisao) {
        this.omUsrByIdUsrrevisao = omUsrByIdUsrrevisao;
    }


    /**
     * Gets the omUsrByIdUsrstativo value for this DwProcedimento.
     * 
     * @return omUsrByIdUsrstativo
     */
    public idw.idwws.OmUsr getOmUsrByIdUsrstativo() {
        return omUsrByIdUsrstativo;
    }


    /**
     * Sets the omUsrByIdUsrstativo value for this DwProcedimento.
     * 
     * @param omUsrByIdUsrstativo
     */
    public void setOmUsrByIdUsrstativo(idw.idwws.OmUsr omUsrByIdUsrstativo) {
        this.omUsrByIdUsrstativo = omUsrByIdUsrstativo;
    }


    /**
     * Gets the revisao value for this DwProcedimento.
     * 
     * @return revisao
     */
    public java.lang.Long getRevisao() {
        return revisao;
    }


    /**
     * Sets the revisao value for this DwProcedimento.
     * 
     * @param revisao
     */
    public void setRevisao(java.lang.Long revisao) {
        this.revisao = revisao;
    }


    /**
     * Gets the stAtivo value for this DwProcedimento.
     * 
     * @return stAtivo
     */
    public java.lang.Byte getStAtivo() {
        return stAtivo;
    }


    /**
     * Sets the stAtivo value for this DwProcedimento.
     * 
     * @param stAtivo
     */
    public void setStAtivo(java.lang.Byte stAtivo) {
        this.stAtivo = stAtivo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwProcedimento)) return false;
        DwProcedimento other = (DwProcedimento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cdProcedimento==null && other.getCdProcedimento()==null) || 
             (this.cdProcedimento!=null &&
              this.cdProcedimento.equals(other.getCdProcedimento()))) &&
            ((this.dsProcedimento==null && other.getDsProcedimento()==null) || 
             (this.dsProcedimento!=null &&
              this.dsProcedimento.equals(other.getDsProcedimento()))) &&
            ((this.dtRevisao==null && other.getDtRevisao()==null) || 
             (this.dtRevisao!=null &&
              this.dtRevisao.equals(other.getDtRevisao()))) &&
            ((this.dtStativo==null && other.getDtStativo()==null) || 
             (this.dtStativo!=null &&
              this.dtStativo.equals(other.getDtStativo()))) &&
            ((this.dwFolhas==null && other.getDwFolhas()==null) || 
             (this.dwFolhas!=null &&
              java.util.Arrays.equals(this.dwFolhas, other.getDwFolhas()))) &&
            ((this.dwProcarhoms==null && other.getDwProcarhoms()==null) || 
             (this.dwProcarhoms!=null &&
              java.util.Arrays.equals(this.dwProcarhoms, other.getDwProcarhoms()))) &&
            ((this.dwProcativs==null && other.getDwProcativs()==null) || 
             (this.dwProcativs!=null &&
              java.util.Arrays.equals(this.dwProcativs, other.getDwProcativs()))) &&
            ((this.dwProreas==null && other.getDwProreas()==null) || 
             (this.dwProreas!=null &&
              java.util.Arrays.equals(this.dwProreas, other.getDwProreas()))) &&
            ((this.idProcedimento==null && other.getIdProcedimento()==null) || 
             (this.idProcedimento!=null &&
              this.idProcedimento.equals(other.getIdProcedimento()))) &&
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
        if (getCdProcedimento() != null) {
            _hashCode += getCdProcedimento().hashCode();
        }
        if (getDsProcedimento() != null) {
            _hashCode += getDsProcedimento().hashCode();
        }
        if (getDtRevisao() != null) {
            _hashCode += getDtRevisao().hashCode();
        }
        if (getDtStativo() != null) {
            _hashCode += getDtStativo().hashCode();
        }
        if (getDwFolhas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwProcarhoms() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwProcarhoms());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwProcarhoms(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getDwProreas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwProreas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwProreas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdProcedimento() != null) {
            _hashCode += getIdProcedimento().hashCode();
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
        new org.apache.axis.description.TypeDesc(DwProcedimento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcedimento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdProcedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdProcedimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsProcedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsProcedimento"));
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
        elemField.setFieldName("dwFolhas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProcarhoms");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProcarhoms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcarhom"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("dwProreas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProreas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProrea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProcedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProcedimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
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
