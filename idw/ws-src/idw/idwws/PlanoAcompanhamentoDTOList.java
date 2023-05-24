/**
 * PlanoAcompanhamentoDTOList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PlanoAcompanhamentoDTOList  implements java.io.Serializable {
    private idw.idwws.PlanoAcompanhamentoDTO[] acompanhamentos;

    private java.lang.Double indiceAntecipacao;

    private java.lang.Double indiceAtraso;

    private java.lang.Double mediaAtrasos;

    private idw.idwws.PpCp[] ppcps;

    public PlanoAcompanhamentoDTOList() {
    }

    public PlanoAcompanhamentoDTOList(
           idw.idwws.PlanoAcompanhamentoDTO[] acompanhamentos,
           java.lang.Double indiceAntecipacao,
           java.lang.Double indiceAtraso,
           java.lang.Double mediaAtrasos,
           idw.idwws.PpCp[] ppcps) {
           this.acompanhamentos = acompanhamentos;
           this.indiceAntecipacao = indiceAntecipacao;
           this.indiceAtraso = indiceAtraso;
           this.mediaAtrasos = mediaAtrasos;
           this.ppcps = ppcps;
    }


    /**
     * Gets the acompanhamentos value for this PlanoAcompanhamentoDTOList.
     * 
     * @return acompanhamentos
     */
    public idw.idwws.PlanoAcompanhamentoDTO[] getAcompanhamentos() {
        return acompanhamentos;
    }


    /**
     * Sets the acompanhamentos value for this PlanoAcompanhamentoDTOList.
     * 
     * @param acompanhamentos
     */
    public void setAcompanhamentos(idw.idwws.PlanoAcompanhamentoDTO[] acompanhamentos) {
        this.acompanhamentos = acompanhamentos;
    }

    public idw.idwws.PlanoAcompanhamentoDTO getAcompanhamentos(int i) {
        return this.acompanhamentos[i];
    }

    public void setAcompanhamentos(int i, idw.idwws.PlanoAcompanhamentoDTO _value) {
        this.acompanhamentos[i] = _value;
    }


    /**
     * Gets the indiceAntecipacao value for this PlanoAcompanhamentoDTOList.
     * 
     * @return indiceAntecipacao
     */
    public java.lang.Double getIndiceAntecipacao() {
        return indiceAntecipacao;
    }


    /**
     * Sets the indiceAntecipacao value for this PlanoAcompanhamentoDTOList.
     * 
     * @param indiceAntecipacao
     */
    public void setIndiceAntecipacao(java.lang.Double indiceAntecipacao) {
        this.indiceAntecipacao = indiceAntecipacao;
    }


    /**
     * Gets the indiceAtraso value for this PlanoAcompanhamentoDTOList.
     * 
     * @return indiceAtraso
     */
    public java.lang.Double getIndiceAtraso() {
        return indiceAtraso;
    }


    /**
     * Sets the indiceAtraso value for this PlanoAcompanhamentoDTOList.
     * 
     * @param indiceAtraso
     */
    public void setIndiceAtraso(java.lang.Double indiceAtraso) {
        this.indiceAtraso = indiceAtraso;
    }


    /**
     * Gets the mediaAtrasos value for this PlanoAcompanhamentoDTOList.
     * 
     * @return mediaAtrasos
     */
    public java.lang.Double getMediaAtrasos() {
        return mediaAtrasos;
    }


    /**
     * Sets the mediaAtrasos value for this PlanoAcompanhamentoDTOList.
     * 
     * @param mediaAtrasos
     */
    public void setMediaAtrasos(java.lang.Double mediaAtrasos) {
        this.mediaAtrasos = mediaAtrasos;
    }


    /**
     * Gets the ppcps value for this PlanoAcompanhamentoDTOList.
     * 
     * @return ppcps
     */
    public idw.idwws.PpCp[] getPpcps() {
        return ppcps;
    }


    /**
     * Sets the ppcps value for this PlanoAcompanhamentoDTOList.
     * 
     * @param ppcps
     */
    public void setPpcps(idw.idwws.PpCp[] ppcps) {
        this.ppcps = ppcps;
    }

    public idw.idwws.PpCp getPpcps(int i) {
        return this.ppcps[i];
    }

    public void setPpcps(int i, idw.idwws.PpCp _value) {
        this.ppcps[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PlanoAcompanhamentoDTOList)) return false;
        PlanoAcompanhamentoDTOList other = (PlanoAcompanhamentoDTOList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acompanhamentos==null && other.getAcompanhamentos()==null) || 
             (this.acompanhamentos!=null &&
              java.util.Arrays.equals(this.acompanhamentos, other.getAcompanhamentos()))) &&
            ((this.indiceAntecipacao==null && other.getIndiceAntecipacao()==null) || 
             (this.indiceAntecipacao!=null &&
              this.indiceAntecipacao.equals(other.getIndiceAntecipacao()))) &&
            ((this.indiceAtraso==null && other.getIndiceAtraso()==null) || 
             (this.indiceAtraso!=null &&
              this.indiceAtraso.equals(other.getIndiceAtraso()))) &&
            ((this.mediaAtrasos==null && other.getMediaAtrasos()==null) || 
             (this.mediaAtrasos!=null &&
              this.mediaAtrasos.equals(other.getMediaAtrasos()))) &&
            ((this.ppcps==null && other.getPpcps()==null) || 
             (this.ppcps!=null &&
              java.util.Arrays.equals(this.ppcps, other.getPpcps())));
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
        if (getAcompanhamentos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAcompanhamentos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAcompanhamentos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIndiceAntecipacao() != null) {
            _hashCode += getIndiceAntecipacao().hashCode();
        }
        if (getIndiceAtraso() != null) {
            _hashCode += getIndiceAtraso().hashCode();
        }
        if (getMediaAtrasos() != null) {
            _hashCode += getMediaAtrasos().hashCode();
        }
        if (getPpcps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpcps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpcps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PlanoAcompanhamentoDTOList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "planoAcompanhamentoDTOList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acompanhamentos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acompanhamentos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "planoAcompanhamentoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceAntecipacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceAntecipacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceAtraso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceAtraso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mediaAtrasos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mediaAtrasos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppcps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppcps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
