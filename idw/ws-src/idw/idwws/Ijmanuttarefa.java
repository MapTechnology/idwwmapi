/**
 * Ijmanuttarefa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmanuttarefa  implements java.io.Serializable {
    private java.lang.String cdtarefa;

    private java.lang.String dstarefa;

    private java.lang.String idtarefa;

    private idw.idwws.Ijclasstarefamanut ijclasstarefamanut;

    private idw.idwws.Ijmanutchklstdet[] ijmanutchklstdetsForIdtarefa;

    private idw.idwws.Ijmanutchklstdet[] ijmanutchklstdetsForIdtarefapai;

    private idw.idwws.Ijmanutexec[] ijmanutexecsForIdtarefaavulsa;

    private idw.idwws.Ijmanutexec[] ijmanutexecsForIdtarefachklst;

    private idw.idwws.Ijmanutexec[] ijmanutexecsForIdtarefachklstpai;

    private org.apache.axis.types.UnsignedShort sttarefa;

    public Ijmanuttarefa() {
    }

    public Ijmanuttarefa(
           java.lang.String cdtarefa,
           java.lang.String dstarefa,
           java.lang.String idtarefa,
           idw.idwws.Ijclasstarefamanut ijclasstarefamanut,
           idw.idwws.Ijmanutchklstdet[] ijmanutchklstdetsForIdtarefa,
           idw.idwws.Ijmanutchklstdet[] ijmanutchklstdetsForIdtarefapai,
           idw.idwws.Ijmanutexec[] ijmanutexecsForIdtarefaavulsa,
           idw.idwws.Ijmanutexec[] ijmanutexecsForIdtarefachklst,
           idw.idwws.Ijmanutexec[] ijmanutexecsForIdtarefachklstpai,
           org.apache.axis.types.UnsignedShort sttarefa) {
           this.cdtarefa = cdtarefa;
           this.dstarefa = dstarefa;
           this.idtarefa = idtarefa;
           this.ijclasstarefamanut = ijclasstarefamanut;
           this.ijmanutchklstdetsForIdtarefa = ijmanutchklstdetsForIdtarefa;
           this.ijmanutchklstdetsForIdtarefapai = ijmanutchklstdetsForIdtarefapai;
           this.ijmanutexecsForIdtarefaavulsa = ijmanutexecsForIdtarefaavulsa;
           this.ijmanutexecsForIdtarefachklst = ijmanutexecsForIdtarefachklst;
           this.ijmanutexecsForIdtarefachklstpai = ijmanutexecsForIdtarefachklstpai;
           this.sttarefa = sttarefa;
    }


    /**
     * Gets the cdtarefa value for this Ijmanuttarefa.
     * 
     * @return cdtarefa
     */
    public java.lang.String getCdtarefa() {
        return cdtarefa;
    }


    /**
     * Sets the cdtarefa value for this Ijmanuttarefa.
     * 
     * @param cdtarefa
     */
    public void setCdtarefa(java.lang.String cdtarefa) {
        this.cdtarefa = cdtarefa;
    }


    /**
     * Gets the dstarefa value for this Ijmanuttarefa.
     * 
     * @return dstarefa
     */
    public java.lang.String getDstarefa() {
        return dstarefa;
    }


    /**
     * Sets the dstarefa value for this Ijmanuttarefa.
     * 
     * @param dstarefa
     */
    public void setDstarefa(java.lang.String dstarefa) {
        this.dstarefa = dstarefa;
    }


    /**
     * Gets the idtarefa value for this Ijmanuttarefa.
     * 
     * @return idtarefa
     */
    public java.lang.String getIdtarefa() {
        return idtarefa;
    }


    /**
     * Sets the idtarefa value for this Ijmanuttarefa.
     * 
     * @param idtarefa
     */
    public void setIdtarefa(java.lang.String idtarefa) {
        this.idtarefa = idtarefa;
    }


    /**
     * Gets the ijclasstarefamanut value for this Ijmanuttarefa.
     * 
     * @return ijclasstarefamanut
     */
    public idw.idwws.Ijclasstarefamanut getIjclasstarefamanut() {
        return ijclasstarefamanut;
    }


    /**
     * Sets the ijclasstarefamanut value for this Ijmanuttarefa.
     * 
     * @param ijclasstarefamanut
     */
    public void setIjclasstarefamanut(idw.idwws.Ijclasstarefamanut ijclasstarefamanut) {
        this.ijclasstarefamanut = ijclasstarefamanut;
    }


    /**
     * Gets the ijmanutchklstdetsForIdtarefa value for this Ijmanuttarefa.
     * 
     * @return ijmanutchklstdetsForIdtarefa
     */
    public idw.idwws.Ijmanutchklstdet[] getIjmanutchklstdetsForIdtarefa() {
        return ijmanutchklstdetsForIdtarefa;
    }


    /**
     * Sets the ijmanutchklstdetsForIdtarefa value for this Ijmanuttarefa.
     * 
     * @param ijmanutchklstdetsForIdtarefa
     */
    public void setIjmanutchklstdetsForIdtarefa(idw.idwws.Ijmanutchklstdet[] ijmanutchklstdetsForIdtarefa) {
        this.ijmanutchklstdetsForIdtarefa = ijmanutchklstdetsForIdtarefa;
    }

    public idw.idwws.Ijmanutchklstdet getIjmanutchklstdetsForIdtarefa(int i) {
        return this.ijmanutchklstdetsForIdtarefa[i];
    }

    public void setIjmanutchklstdetsForIdtarefa(int i, idw.idwws.Ijmanutchklstdet _value) {
        this.ijmanutchklstdetsForIdtarefa[i] = _value;
    }


    /**
     * Gets the ijmanutchklstdetsForIdtarefapai value for this Ijmanuttarefa.
     * 
     * @return ijmanutchklstdetsForIdtarefapai
     */
    public idw.idwws.Ijmanutchklstdet[] getIjmanutchklstdetsForIdtarefapai() {
        return ijmanutchklstdetsForIdtarefapai;
    }


    /**
     * Sets the ijmanutchklstdetsForIdtarefapai value for this Ijmanuttarefa.
     * 
     * @param ijmanutchklstdetsForIdtarefapai
     */
    public void setIjmanutchklstdetsForIdtarefapai(idw.idwws.Ijmanutchklstdet[] ijmanutchklstdetsForIdtarefapai) {
        this.ijmanutchklstdetsForIdtarefapai = ijmanutchklstdetsForIdtarefapai;
    }

    public idw.idwws.Ijmanutchklstdet getIjmanutchklstdetsForIdtarefapai(int i) {
        return this.ijmanutchklstdetsForIdtarefapai[i];
    }

    public void setIjmanutchklstdetsForIdtarefapai(int i, idw.idwws.Ijmanutchklstdet _value) {
        this.ijmanutchklstdetsForIdtarefapai[i] = _value;
    }


    /**
     * Gets the ijmanutexecsForIdtarefaavulsa value for this Ijmanuttarefa.
     * 
     * @return ijmanutexecsForIdtarefaavulsa
     */
    public idw.idwws.Ijmanutexec[] getIjmanutexecsForIdtarefaavulsa() {
        return ijmanutexecsForIdtarefaavulsa;
    }


    /**
     * Sets the ijmanutexecsForIdtarefaavulsa value for this Ijmanuttarefa.
     * 
     * @param ijmanutexecsForIdtarefaavulsa
     */
    public void setIjmanutexecsForIdtarefaavulsa(idw.idwws.Ijmanutexec[] ijmanutexecsForIdtarefaavulsa) {
        this.ijmanutexecsForIdtarefaavulsa = ijmanutexecsForIdtarefaavulsa;
    }

    public idw.idwws.Ijmanutexec getIjmanutexecsForIdtarefaavulsa(int i) {
        return this.ijmanutexecsForIdtarefaavulsa[i];
    }

    public void setIjmanutexecsForIdtarefaavulsa(int i, idw.idwws.Ijmanutexec _value) {
        this.ijmanutexecsForIdtarefaavulsa[i] = _value;
    }


    /**
     * Gets the ijmanutexecsForIdtarefachklst value for this Ijmanuttarefa.
     * 
     * @return ijmanutexecsForIdtarefachklst
     */
    public idw.idwws.Ijmanutexec[] getIjmanutexecsForIdtarefachklst() {
        return ijmanutexecsForIdtarefachklst;
    }


    /**
     * Sets the ijmanutexecsForIdtarefachklst value for this Ijmanuttarefa.
     * 
     * @param ijmanutexecsForIdtarefachklst
     */
    public void setIjmanutexecsForIdtarefachklst(idw.idwws.Ijmanutexec[] ijmanutexecsForIdtarefachklst) {
        this.ijmanutexecsForIdtarefachklst = ijmanutexecsForIdtarefachklst;
    }

    public idw.idwws.Ijmanutexec getIjmanutexecsForIdtarefachklst(int i) {
        return this.ijmanutexecsForIdtarefachklst[i];
    }

    public void setIjmanutexecsForIdtarefachklst(int i, idw.idwws.Ijmanutexec _value) {
        this.ijmanutexecsForIdtarefachklst[i] = _value;
    }


    /**
     * Gets the ijmanutexecsForIdtarefachklstpai value for this Ijmanuttarefa.
     * 
     * @return ijmanutexecsForIdtarefachklstpai
     */
    public idw.idwws.Ijmanutexec[] getIjmanutexecsForIdtarefachklstpai() {
        return ijmanutexecsForIdtarefachklstpai;
    }


    /**
     * Sets the ijmanutexecsForIdtarefachklstpai value for this Ijmanuttarefa.
     * 
     * @param ijmanutexecsForIdtarefachklstpai
     */
    public void setIjmanutexecsForIdtarefachklstpai(idw.idwws.Ijmanutexec[] ijmanutexecsForIdtarefachklstpai) {
        this.ijmanutexecsForIdtarefachklstpai = ijmanutexecsForIdtarefachklstpai;
    }

    public idw.idwws.Ijmanutexec getIjmanutexecsForIdtarefachklstpai(int i) {
        return this.ijmanutexecsForIdtarefachklstpai[i];
    }

    public void setIjmanutexecsForIdtarefachklstpai(int i, idw.idwws.Ijmanutexec _value) {
        this.ijmanutexecsForIdtarefachklstpai[i] = _value;
    }


    /**
     * Gets the sttarefa value for this Ijmanuttarefa.
     * 
     * @return sttarefa
     */
    public org.apache.axis.types.UnsignedShort getSttarefa() {
        return sttarefa;
    }


    /**
     * Sets the sttarefa value for this Ijmanuttarefa.
     * 
     * @param sttarefa
     */
    public void setSttarefa(org.apache.axis.types.UnsignedShort sttarefa) {
        this.sttarefa = sttarefa;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmanuttarefa)) return false;
        Ijmanuttarefa other = (Ijmanuttarefa) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdtarefa==null && other.getCdtarefa()==null) || 
             (this.cdtarefa!=null &&
              this.cdtarefa.equals(other.getCdtarefa()))) &&
            ((this.dstarefa==null && other.getDstarefa()==null) || 
             (this.dstarefa!=null &&
              this.dstarefa.equals(other.getDstarefa()))) &&
            ((this.idtarefa==null && other.getIdtarefa()==null) || 
             (this.idtarefa!=null &&
              this.idtarefa.equals(other.getIdtarefa()))) &&
            ((this.ijclasstarefamanut==null && other.getIjclasstarefamanut()==null) || 
             (this.ijclasstarefamanut!=null &&
              this.ijclasstarefamanut.equals(other.getIjclasstarefamanut()))) &&
            ((this.ijmanutchklstdetsForIdtarefa==null && other.getIjmanutchklstdetsForIdtarefa()==null) || 
             (this.ijmanutchklstdetsForIdtarefa!=null &&
              java.util.Arrays.equals(this.ijmanutchklstdetsForIdtarefa, other.getIjmanutchklstdetsForIdtarefa()))) &&
            ((this.ijmanutchklstdetsForIdtarefapai==null && other.getIjmanutchklstdetsForIdtarefapai()==null) || 
             (this.ijmanutchklstdetsForIdtarefapai!=null &&
              java.util.Arrays.equals(this.ijmanutchklstdetsForIdtarefapai, other.getIjmanutchklstdetsForIdtarefapai()))) &&
            ((this.ijmanutexecsForIdtarefaavulsa==null && other.getIjmanutexecsForIdtarefaavulsa()==null) || 
             (this.ijmanutexecsForIdtarefaavulsa!=null &&
              java.util.Arrays.equals(this.ijmanutexecsForIdtarefaavulsa, other.getIjmanutexecsForIdtarefaavulsa()))) &&
            ((this.ijmanutexecsForIdtarefachklst==null && other.getIjmanutexecsForIdtarefachklst()==null) || 
             (this.ijmanutexecsForIdtarefachklst!=null &&
              java.util.Arrays.equals(this.ijmanutexecsForIdtarefachklst, other.getIjmanutexecsForIdtarefachklst()))) &&
            ((this.ijmanutexecsForIdtarefachklstpai==null && other.getIjmanutexecsForIdtarefachklstpai()==null) || 
             (this.ijmanutexecsForIdtarefachklstpai!=null &&
              java.util.Arrays.equals(this.ijmanutexecsForIdtarefachklstpai, other.getIjmanutexecsForIdtarefachklstpai()))) &&
            ((this.sttarefa==null && other.getSttarefa()==null) || 
             (this.sttarefa!=null &&
              this.sttarefa.equals(other.getSttarefa())));
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
        if (getCdtarefa() != null) {
            _hashCode += getCdtarefa().hashCode();
        }
        if (getDstarefa() != null) {
            _hashCode += getDstarefa().hashCode();
        }
        if (getIdtarefa() != null) {
            _hashCode += getIdtarefa().hashCode();
        }
        if (getIjclasstarefamanut() != null) {
            _hashCode += getIjclasstarefamanut().hashCode();
        }
        if (getIjmanutchklstdetsForIdtarefa() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutchklstdetsForIdtarefa());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutchklstdetsForIdtarefa(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanutchklstdetsForIdtarefapai() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutchklstdetsForIdtarefapai());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutchklstdetsForIdtarefapai(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanutexecsForIdtarefaavulsa() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutexecsForIdtarefaavulsa());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutexecsForIdtarefaavulsa(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanutexecsForIdtarefachklst() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutexecsForIdtarefachklst());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutexecsForIdtarefachklst(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmanutexecsForIdtarefachklstpai() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmanutexecsForIdtarefachklstpai());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmanutexecsForIdtarefachklstpai(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSttarefa() != null) {
            _hashCode += getSttarefa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmanuttarefa.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanuttarefa"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdtarefa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdtarefa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dstarefa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dstarefa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idtarefa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idtarefa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijclasstarefamanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijclasstarefamanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijclasstarefamanut"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutchklstdetsForIdtarefa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutchklstdetsForIdtarefa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutchklstdet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutchklstdetsForIdtarefapai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutchklstdetsForIdtarefapai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutchklstdet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutexecsForIdtarefaavulsa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutexecsForIdtarefaavulsa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutexecsForIdtarefachklst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutexecsForIdtarefachklst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanutexecsForIdtarefachklstpai");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanutexecsForIdtarefachklstpai"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutexec"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sttarefa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sttarefa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
