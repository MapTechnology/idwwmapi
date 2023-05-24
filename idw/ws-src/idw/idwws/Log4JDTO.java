/**
 * Log4JDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Log4JDTO  implements java.io.Serializable {
    private boolean desabilitarLog;

    private java.lang.String diretorio;

    private java.lang.String nivel;

    private java.lang.String qtdeArquivos;

    private java.lang.String tamanho;

    public Log4JDTO() {
    }

    public Log4JDTO(
           boolean desabilitarLog,
           java.lang.String diretorio,
           java.lang.String nivel,
           java.lang.String qtdeArquivos,
           java.lang.String tamanho) {
           this.desabilitarLog = desabilitarLog;
           this.diretorio = diretorio;
           this.nivel = nivel;
           this.qtdeArquivos = qtdeArquivos;
           this.tamanho = tamanho;
    }


    /**
     * Gets the desabilitarLog value for this Log4JDTO.
     * 
     * @return desabilitarLog
     */
    public boolean isDesabilitarLog() {
        return desabilitarLog;
    }


    /**
     * Sets the desabilitarLog value for this Log4JDTO.
     * 
     * @param desabilitarLog
     */
    public void setDesabilitarLog(boolean desabilitarLog) {
        this.desabilitarLog = desabilitarLog;
    }


    /**
     * Gets the diretorio value for this Log4JDTO.
     * 
     * @return diretorio
     */
    public java.lang.String getDiretorio() {
        return diretorio;
    }


    /**
     * Sets the diretorio value for this Log4JDTO.
     * 
     * @param diretorio
     */
    public void setDiretorio(java.lang.String diretorio) {
        this.diretorio = diretorio;
    }


    /**
     * Gets the nivel value for this Log4JDTO.
     * 
     * @return nivel
     */
    public java.lang.String getNivel() {
        return nivel;
    }


    /**
     * Sets the nivel value for this Log4JDTO.
     * 
     * @param nivel
     */
    public void setNivel(java.lang.String nivel) {
        this.nivel = nivel;
    }


    /**
     * Gets the qtdeArquivos value for this Log4JDTO.
     * 
     * @return qtdeArquivos
     */
    public java.lang.String getQtdeArquivos() {
        return qtdeArquivos;
    }


    /**
     * Sets the qtdeArquivos value for this Log4JDTO.
     * 
     * @param qtdeArquivos
     */
    public void setQtdeArquivos(java.lang.String qtdeArquivos) {
        this.qtdeArquivos = qtdeArquivos;
    }


    /**
     * Gets the tamanho value for this Log4JDTO.
     * 
     * @return tamanho
     */
    public java.lang.String getTamanho() {
        return tamanho;
    }


    /**
     * Sets the tamanho value for this Log4JDTO.
     * 
     * @param tamanho
     */
    public void setTamanho(java.lang.String tamanho) {
        this.tamanho = tamanho;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Log4JDTO)) return false;
        Log4JDTO other = (Log4JDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.desabilitarLog == other.isDesabilitarLog() &&
            ((this.diretorio==null && other.getDiretorio()==null) || 
             (this.diretorio!=null &&
              this.diretorio.equals(other.getDiretorio()))) &&
            ((this.nivel==null && other.getNivel()==null) || 
             (this.nivel!=null &&
              this.nivel.equals(other.getNivel()))) &&
            ((this.qtdeArquivos==null && other.getQtdeArquivos()==null) || 
             (this.qtdeArquivos!=null &&
              this.qtdeArquivos.equals(other.getQtdeArquivos()))) &&
            ((this.tamanho==null && other.getTamanho()==null) || 
             (this.tamanho!=null &&
              this.tamanho.equals(other.getTamanho())));
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
        _hashCode += (isDesabilitarLog() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDiretorio() != null) {
            _hashCode += getDiretorio().hashCode();
        }
        if (getNivel() != null) {
            _hashCode += getNivel().hashCode();
        }
        if (getQtdeArquivos() != null) {
            _hashCode += getQtdeArquivos().hashCode();
        }
        if (getTamanho() != null) {
            _hashCode += getTamanho().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Log4JDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "log4JDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desabilitarLog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "desabilitarLog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diretorio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diretorio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nivel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nivel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdeArquivos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdeArquivos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamanho");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamanho"));
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
