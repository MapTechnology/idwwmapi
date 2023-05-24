/**
 * WebXMLDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class WebXMLDTO  implements java.io.Serializable {
    private java.lang.String[] classesInicializaveis;

    private java.lang.String[] classesNaoInicializaveis;

    private java.lang.String versaoMobile;

    public WebXMLDTO() {
    }

    public WebXMLDTO(
           java.lang.String[] classesInicializaveis,
           java.lang.String[] classesNaoInicializaveis,
           java.lang.String versaoMobile) {
           this.classesInicializaveis = classesInicializaveis;
           this.classesNaoInicializaveis = classesNaoInicializaveis;
           this.versaoMobile = versaoMobile;
    }


    /**
     * Gets the classesInicializaveis value for this WebXMLDTO.
     * 
     * @return classesInicializaveis
     */
    public java.lang.String[] getClassesInicializaveis() {
        return classesInicializaveis;
    }


    /**
     * Sets the classesInicializaveis value for this WebXMLDTO.
     * 
     * @param classesInicializaveis
     */
    public void setClassesInicializaveis(java.lang.String[] classesInicializaveis) {
        this.classesInicializaveis = classesInicializaveis;
    }

    public java.lang.String getClassesInicializaveis(int i) {
        return this.classesInicializaveis[i];
    }

    public void setClassesInicializaveis(int i, java.lang.String _value) {
        this.classesInicializaveis[i] = _value;
    }


    /**
     * Gets the classesNaoInicializaveis value for this WebXMLDTO.
     * 
     * @return classesNaoInicializaveis
     */
    public java.lang.String[] getClassesNaoInicializaveis() {
        return classesNaoInicializaveis;
    }


    /**
     * Sets the classesNaoInicializaveis value for this WebXMLDTO.
     * 
     * @param classesNaoInicializaveis
     */
    public void setClassesNaoInicializaveis(java.lang.String[] classesNaoInicializaveis) {
        this.classesNaoInicializaveis = classesNaoInicializaveis;
    }

    public java.lang.String getClassesNaoInicializaveis(int i) {
        return this.classesNaoInicializaveis[i];
    }

    public void setClassesNaoInicializaveis(int i, java.lang.String _value) {
        this.classesNaoInicializaveis[i] = _value;
    }


    /**
     * Gets the versaoMobile value for this WebXMLDTO.
     * 
     * @return versaoMobile
     */
    public java.lang.String getVersaoMobile() {
        return versaoMobile;
    }


    /**
     * Sets the versaoMobile value for this WebXMLDTO.
     * 
     * @param versaoMobile
     */
    public void setVersaoMobile(java.lang.String versaoMobile) {
        this.versaoMobile = versaoMobile;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WebXMLDTO)) return false;
        WebXMLDTO other = (WebXMLDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.classesInicializaveis==null && other.getClassesInicializaveis()==null) || 
             (this.classesInicializaveis!=null &&
              java.util.Arrays.equals(this.classesInicializaveis, other.getClassesInicializaveis()))) &&
            ((this.classesNaoInicializaveis==null && other.getClassesNaoInicializaveis()==null) || 
             (this.classesNaoInicializaveis!=null &&
              java.util.Arrays.equals(this.classesNaoInicializaveis, other.getClassesNaoInicializaveis()))) &&
            ((this.versaoMobile==null && other.getVersaoMobile()==null) || 
             (this.versaoMobile!=null &&
              this.versaoMobile.equals(other.getVersaoMobile())));
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
        if (getClassesInicializaveis() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClassesInicializaveis());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClassesInicializaveis(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getClassesNaoInicializaveis() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getClassesNaoInicializaveis());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getClassesNaoInicializaveis(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVersaoMobile() != null) {
            _hashCode += getVersaoMobile().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WebXMLDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "webXMLDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classesInicializaveis");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classesInicializaveis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classesNaoInicializaveis");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classesNaoInicializaveis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versaoMobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "versaoMobile"));
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
