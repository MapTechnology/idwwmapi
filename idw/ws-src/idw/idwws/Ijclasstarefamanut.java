/**
 * Ijclasstarefamanut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijclasstarefamanut  implements java.io.Serializable {
    private java.lang.String cdclasstarefa;

    private java.lang.String dsclasstarefa;

    private idw.idwws.Ijmanuttarefa[] ijmanuttarefas;

    public Ijclasstarefamanut() {
    }

    public Ijclasstarefamanut(
           java.lang.String cdclasstarefa,
           java.lang.String dsclasstarefa,
           idw.idwws.Ijmanuttarefa[] ijmanuttarefas) {
           this.cdclasstarefa = cdclasstarefa;
           this.dsclasstarefa = dsclasstarefa;
           this.ijmanuttarefas = ijmanuttarefas;
    }


    /**
     * Gets the cdclasstarefa value for this Ijclasstarefamanut.
     * 
     * @return cdclasstarefa
     */
    public java.lang.String getCdclasstarefa() {
        return cdclasstarefa;
    }


    /**
     * Sets the cdclasstarefa value for this Ijclasstarefamanut.
     * 
     * @param cdclasstarefa
     */
    public void setCdclasstarefa(java.lang.String cdclasstarefa) {
        this.cdclasstarefa = cdclasstarefa;
    }


    /**
     * Gets the dsclasstarefa value for this Ijclasstarefamanut.
     * 
     * @return dsclasstarefa
     */
    public java.lang.String getDsclasstarefa() {
        return dsclasstarefa;
    }


    /**
     * Sets the dsclasstarefa value for this Ijclasstarefamanut.
     * 
     * @param dsclasstarefa
     */
    public void setDsclasstarefa(java.lang.String dsclasstarefa) {
        this.dsclasstarefa = dsclasstarefa;
    }


    /**
     * Gets the ijmanuttarefas value for this Ijclasstarefamanut.
     * 
     * @return ijmanuttarefas
     */
    public idw.idwws.Ijmanuttarefa[] getIjmanuttarefas() {
        return ijmanuttarefas;
    }


    /**
     * Sets the ijmanuttarefas value for this Ijclasstarefamanut.
     * 
     * @param ijmanuttarefas
     */
    public void setIjmanuttarefas(idw.idwws.Ijmanuttarefa[] ijmanuttarefas) {
        this.ijmanuttarefas = ijmanuttarefas;
    }

    public idw.idwws.Ijmanuttarefa getIjmanuttarefas(int i) {
        return this.ijmanuttarefas[i];
    }

    public void setIjmanuttarefas(int i, idw.idwws.Ijmanuttarefa _value) {
        this.ijmanuttarefas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijclasstarefamanut)) return false;
        Ijclasstarefamanut other = (Ijclasstarefamanut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdclasstarefa==null && other.getCdclasstarefa()==null) || 
             (this.cdclasstarefa!=null &&
              this.cdclasstarefa.equals(other.getCdclasstarefa()))) &&
            ((this.dsclasstarefa==null && other.getDsclasstarefa()==null) || 
             (this.dsclasstarefa!=null &&
              this.dsclasstarefa.equals(other.getDsclasstarefa()))) &&
            ((this.ijmanuttarefas==null && other.getIjmanuttarefas()==null) || 
             (this.ijmanuttarefas!=null &&
              java.util.Arrays.equals(this.ijmanuttarefas, other.getIjmanuttarefas())));
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
        if (getCdclasstarefa() != null) {
            _hashCode += getCdclasstarefa().hashCode();
        }
        if (getDsclasstarefa() != null) {
            _hashCode += getDsclasstarefa().hashCode();
        }
        if (getIjmanuttarefas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanuttarefas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanuttarefas(), i);
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
        new org.apache.axis.description.TypeDesc(Ijclasstarefamanut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclasstarefamanut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdclasstarefa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdclasstarefa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsclasstarefa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsclasstarefa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanuttarefas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanuttarefas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanuttarefa"));
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
