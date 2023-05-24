/**
 * DwTestesub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwTestesub  extends idw.idwws.DwTestesubTemplate  implements java.io.Serializable {
    private java.lang.Integer acenderLampada;

    private idw.idwws.DwFolhateste dwFolhateste;

    private idw.idwws.DwFtSub dwFtSub;

    private idw.idwws.DwTestesubetapa[] dwTestesubetapas;

    private long idTestesub;

    private java.lang.Boolean isSalvar;

    private java.lang.Integer msCapMedPosFalha;

    private java.lang.Integer ordem;

    private java.lang.Integer ordemEtapa;

    private java.lang.Integer qtMedSeg;

    private java.lang.Integer qtMedSegPosFalha;

    public DwTestesub() {
    }

    public DwTestesub(
           java.lang.Integer acenderLampada,
           idw.idwws.DwFolhateste dwFolhateste,
           idw.idwws.DwFtSub dwFtSub,
           idw.idwws.DwTestesubetapa[] dwTestesubetapas,
           long idTestesub,
           java.lang.Boolean isSalvar,
           java.lang.Integer msCapMedPosFalha,
           java.lang.Integer ordem,
           java.lang.Integer ordemEtapa,
           java.lang.Integer qtMedSeg,
           java.lang.Integer qtMedSegPosFalha) {
        this.acenderLampada = acenderLampada;
        this.dwFolhateste = dwFolhateste;
        this.dwFtSub = dwFtSub;
        this.dwTestesubetapas = dwTestesubetapas;
        this.idTestesub = idTestesub;
        this.isSalvar = isSalvar;
        this.msCapMedPosFalha = msCapMedPosFalha;
        this.ordem = ordem;
        this.ordemEtapa = ordemEtapa;
        this.qtMedSeg = qtMedSeg;
        this.qtMedSegPosFalha = qtMedSegPosFalha;
    }


    /**
     * Gets the acenderLampada value for this DwTestesub.
     * 
     * @return acenderLampada
     */
    public java.lang.Integer getAcenderLampada() {
        return acenderLampada;
    }


    /**
     * Sets the acenderLampada value for this DwTestesub.
     * 
     * @param acenderLampada
     */
    public void setAcenderLampada(java.lang.Integer acenderLampada) {
        this.acenderLampada = acenderLampada;
    }


    /**
     * Gets the dwFolhateste value for this DwTestesub.
     * 
     * @return dwFolhateste
     */
    public idw.idwws.DwFolhateste getDwFolhateste() {
        return dwFolhateste;
    }


    /**
     * Sets the dwFolhateste value for this DwTestesub.
     * 
     * @param dwFolhateste
     */
    public void setDwFolhateste(idw.idwws.DwFolhateste dwFolhateste) {
        this.dwFolhateste = dwFolhateste;
    }


    /**
     * Gets the dwFtSub value for this DwTestesub.
     * 
     * @return dwFtSub
     */
    public idw.idwws.DwFtSub getDwFtSub() {
        return dwFtSub;
    }


    /**
     * Sets the dwFtSub value for this DwTestesub.
     * 
     * @param dwFtSub
     */
    public void setDwFtSub(idw.idwws.DwFtSub dwFtSub) {
        this.dwFtSub = dwFtSub;
    }


    /**
     * Gets the dwTestesubetapas value for this DwTestesub.
     * 
     * @return dwTestesubetapas
     */
    public idw.idwws.DwTestesubetapa[] getDwTestesubetapas() {
        return dwTestesubetapas;
    }


    /**
     * Sets the dwTestesubetapas value for this DwTestesub.
     * 
     * @param dwTestesubetapas
     */
    public void setDwTestesubetapas(idw.idwws.DwTestesubetapa[] dwTestesubetapas) {
        this.dwTestesubetapas = dwTestesubetapas;
    }

    public idw.idwws.DwTestesubetapa getDwTestesubetapas(int i) {
        return this.dwTestesubetapas[i];
    }

    public void setDwTestesubetapas(int i, idw.idwws.DwTestesubetapa _value) {
        this.dwTestesubetapas[i] = _value;
    }


    /**
     * Gets the idTestesub value for this DwTestesub.
     * 
     * @return idTestesub
     */
    public long getIdTestesub() {
        return idTestesub;
    }


    /**
     * Sets the idTestesub value for this DwTestesub.
     * 
     * @param idTestesub
     */
    public void setIdTestesub(long idTestesub) {
        this.idTestesub = idTestesub;
    }


    /**
     * Gets the isSalvar value for this DwTestesub.
     * 
     * @return isSalvar
     */
    public java.lang.Boolean getIsSalvar() {
        return isSalvar;
    }


    /**
     * Sets the isSalvar value for this DwTestesub.
     * 
     * @param isSalvar
     */
    public void setIsSalvar(java.lang.Boolean isSalvar) {
        this.isSalvar = isSalvar;
    }


    /**
     * Gets the msCapMedPosFalha value for this DwTestesub.
     * 
     * @return msCapMedPosFalha
     */
    public java.lang.Integer getMsCapMedPosFalha() {
        return msCapMedPosFalha;
    }


    /**
     * Sets the msCapMedPosFalha value for this DwTestesub.
     * 
     * @param msCapMedPosFalha
     */
    public void setMsCapMedPosFalha(java.lang.Integer msCapMedPosFalha) {
        this.msCapMedPosFalha = msCapMedPosFalha;
    }


    /**
     * Gets the ordem value for this DwTestesub.
     * 
     * @return ordem
     */
    public java.lang.Integer getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this DwTestesub.
     * 
     * @param ordem
     */
    public void setOrdem(java.lang.Integer ordem) {
        this.ordem = ordem;
    }


    /**
     * Gets the ordemEtapa value for this DwTestesub.
     * 
     * @return ordemEtapa
     */
    public java.lang.Integer getOrdemEtapa() {
        return ordemEtapa;
    }


    /**
     * Sets the ordemEtapa value for this DwTestesub.
     * 
     * @param ordemEtapa
     */
    public void setOrdemEtapa(java.lang.Integer ordemEtapa) {
        this.ordemEtapa = ordemEtapa;
    }


    /**
     * Gets the qtMedSeg value for this DwTestesub.
     * 
     * @return qtMedSeg
     */
    public java.lang.Integer getQtMedSeg() {
        return qtMedSeg;
    }


    /**
     * Sets the qtMedSeg value for this DwTestesub.
     * 
     * @param qtMedSeg
     */
    public void setQtMedSeg(java.lang.Integer qtMedSeg) {
        this.qtMedSeg = qtMedSeg;
    }


    /**
     * Gets the qtMedSegPosFalha value for this DwTestesub.
     * 
     * @return qtMedSegPosFalha
     */
    public java.lang.Integer getQtMedSegPosFalha() {
        return qtMedSegPosFalha;
    }


    /**
     * Sets the qtMedSegPosFalha value for this DwTestesub.
     * 
     * @param qtMedSegPosFalha
     */
    public void setQtMedSegPosFalha(java.lang.Integer qtMedSegPosFalha) {
        this.qtMedSegPosFalha = qtMedSegPosFalha;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwTestesub)) return false;
        DwTestesub other = (DwTestesub) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.acenderLampada==null && other.getAcenderLampada()==null) || 
             (this.acenderLampada!=null &&
              this.acenderLampada.equals(other.getAcenderLampada()))) &&
            ((this.dwFolhateste==null && other.getDwFolhateste()==null) || 
             (this.dwFolhateste!=null &&
              this.dwFolhateste.equals(other.getDwFolhateste()))) &&
            ((this.dwFtSub==null && other.getDwFtSub()==null) || 
             (this.dwFtSub!=null &&
              this.dwFtSub.equals(other.getDwFtSub()))) &&
            ((this.dwTestesubetapas==null && other.getDwTestesubetapas()==null) || 
             (this.dwTestesubetapas!=null &&
              java.util.Arrays.equals(this.dwTestesubetapas, other.getDwTestesubetapas()))) &&
            this.idTestesub == other.getIdTestesub() &&
            ((this.isSalvar==null && other.getIsSalvar()==null) || 
             (this.isSalvar!=null &&
              this.isSalvar.equals(other.getIsSalvar()))) &&
            ((this.msCapMedPosFalha==null && other.getMsCapMedPosFalha()==null) || 
             (this.msCapMedPosFalha!=null &&
              this.msCapMedPosFalha.equals(other.getMsCapMedPosFalha()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem()))) &&
            ((this.ordemEtapa==null && other.getOrdemEtapa()==null) || 
             (this.ordemEtapa!=null &&
              this.ordemEtapa.equals(other.getOrdemEtapa()))) &&
            ((this.qtMedSeg==null && other.getQtMedSeg()==null) || 
             (this.qtMedSeg!=null &&
              this.qtMedSeg.equals(other.getQtMedSeg()))) &&
            ((this.qtMedSegPosFalha==null && other.getQtMedSegPosFalha()==null) || 
             (this.qtMedSegPosFalha!=null &&
              this.qtMedSegPosFalha.equals(other.getQtMedSegPosFalha())));
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
        if (getAcenderLampada() != null) {
            _hashCode += getAcenderLampada().hashCode();
        }
        if (getDwFolhateste() != null) {
            _hashCode += getDwFolhateste().hashCode();
        }
        if (getDwFtSub() != null) {
            _hashCode += getDwFtSub().hashCode();
        }
        if (getDwTestesubetapas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwTestesubetapas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwTestesubetapas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdTestesub()).hashCode();
        if (getIsSalvar() != null) {
            _hashCode += getIsSalvar().hashCode();
        }
        if (getMsCapMedPosFalha() != null) {
            _hashCode += getMsCapMedPosFalha().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
        }
        if (getOrdemEtapa() != null) {
            _hashCode += getOrdemEtapa().hashCode();
        }
        if (getQtMedSeg() != null) {
            _hashCode += getQtMedSeg().hashCode();
        }
        if (getQtMedSegPosFalha() != null) {
            _hashCode += getQtMedSegPosFalha().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwTestesub.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTestesub"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acenderLampada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acenderLampada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhateste");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhateste"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhateste"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFtSub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFtSub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFtSub"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTestesubetapas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTestesubetapas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTestesubetapa"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTestesub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTestesub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isSalvar");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isSalvar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msCapMedPosFalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "msCapMedPosFalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("ordemEtapa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemEtapa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtMedSeg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtMedSeg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtMedSegPosFalha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtMedSegPosFalha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
