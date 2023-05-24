/**
 * PpCpData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCpData  extends idw.idwws.PpCpDataTemplate  implements java.io.Serializable {
    private java.util.Calendar dtPlanejada;

    private java.lang.Long idCpData;

    private java.lang.Double pcsProducaoprevista;

    private idw.idwws.PpCpTurno[] ppCpTurnos;

    private idw.idwws.PpCpproduto ppCpproduto;

    public PpCpData() {
    }

    public PpCpData(
           java.util.Calendar dtPlanejada,
           java.lang.Long idCpData,
           java.lang.Double pcsProducaoprevista,
           idw.idwws.PpCpTurno[] ppCpTurnos,
           idw.idwws.PpCpproduto ppCpproduto) {
        this.dtPlanejada = dtPlanejada;
        this.idCpData = idCpData;
        this.pcsProducaoprevista = pcsProducaoprevista;
        this.ppCpTurnos = ppCpTurnos;
        this.ppCpproduto = ppCpproduto;
    }


    /**
     * Gets the dtPlanejada value for this PpCpData.
     * 
     * @return dtPlanejada
     */
    public java.util.Calendar getDtPlanejada() {
        return dtPlanejada;
    }


    /**
     * Sets the dtPlanejada value for this PpCpData.
     * 
     * @param dtPlanejada
     */
    public void setDtPlanejada(java.util.Calendar dtPlanejada) {
        this.dtPlanejada = dtPlanejada;
    }


    /**
     * Gets the idCpData value for this PpCpData.
     * 
     * @return idCpData
     */
    public java.lang.Long getIdCpData() {
        return idCpData;
    }


    /**
     * Sets the idCpData value for this PpCpData.
     * 
     * @param idCpData
     */
    public void setIdCpData(java.lang.Long idCpData) {
        this.idCpData = idCpData;
    }


    /**
     * Gets the pcsProducaoprevista value for this PpCpData.
     * 
     * @return pcsProducaoprevista
     */
    public java.lang.Double getPcsProducaoprevista() {
        return pcsProducaoprevista;
    }


    /**
     * Sets the pcsProducaoprevista value for this PpCpData.
     * 
     * @param pcsProducaoprevista
     */
    public void setPcsProducaoprevista(java.lang.Double pcsProducaoprevista) {
        this.pcsProducaoprevista = pcsProducaoprevista;
    }


    /**
     * Gets the ppCpTurnos value for this PpCpData.
     * 
     * @return ppCpTurnos
     */
    public idw.idwws.PpCpTurno[] getPpCpTurnos() {
        return ppCpTurnos;
    }


    /**
     * Sets the ppCpTurnos value for this PpCpData.
     * 
     * @param ppCpTurnos
     */
    public void setPpCpTurnos(idw.idwws.PpCpTurno[] ppCpTurnos) {
        this.ppCpTurnos = ppCpTurnos;
    }

    public idw.idwws.PpCpTurno getPpCpTurnos(int i) {
        return this.ppCpTurnos[i];
    }

    public void setPpCpTurnos(int i, idw.idwws.PpCpTurno _value) {
        this.ppCpTurnos[i] = _value;
    }


    /**
     * Gets the ppCpproduto value for this PpCpData.
     * 
     * @return ppCpproduto
     */
    public idw.idwws.PpCpproduto getPpCpproduto() {
        return ppCpproduto;
    }


    /**
     * Sets the ppCpproduto value for this PpCpData.
     * 
     * @param ppCpproduto
     */
    public void setPpCpproduto(idw.idwws.PpCpproduto ppCpproduto) {
        this.ppCpproduto = ppCpproduto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCpData)) return false;
        PpCpData other = (PpCpData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dtPlanejada==null && other.getDtPlanejada()==null) || 
             (this.dtPlanejada!=null &&
              this.dtPlanejada.equals(other.getDtPlanejada()))) &&
            ((this.idCpData==null && other.getIdCpData()==null) || 
             (this.idCpData!=null &&
              this.idCpData.equals(other.getIdCpData()))) &&
            ((this.pcsProducaoprevista==null && other.getPcsProducaoprevista()==null) || 
             (this.pcsProducaoprevista!=null &&
              this.pcsProducaoprevista.equals(other.getPcsProducaoprevista()))) &&
            ((this.ppCpTurnos==null && other.getPpCpTurnos()==null) || 
             (this.ppCpTurnos!=null &&
              java.util.Arrays.equals(this.ppCpTurnos, other.getPpCpTurnos()))) &&
            ((this.ppCpproduto==null && other.getPpCpproduto()==null) || 
             (this.ppCpproduto!=null &&
              this.ppCpproduto.equals(other.getPpCpproduto())));
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
        if (getDtPlanejada() != null) {
            _hashCode += getDtPlanejada().hashCode();
        }
        if (getIdCpData() != null) {
            _hashCode += getIdCpData().hashCode();
        }
        if (getPcsProducaoprevista() != null) {
            _hashCode += getPcsProducaoprevista().hashCode();
        }
        if (getPpCpTurnos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCpTurnos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCpTurnos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPpCpproduto() != null) {
            _hashCode += getPpCpproduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpCpData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtPlanejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtPlanejada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCpData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCpData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsProducaoprevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsProducaoprevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpTurnos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpTurnos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpproduto"));
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
