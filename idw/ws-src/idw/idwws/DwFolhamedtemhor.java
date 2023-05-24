/**
 * DwFolhamedtemhor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwFolhamedtemhor  extends idw.idwws.DwFolhamedtemhorTemplate  implements java.io.Serializable {
    private java.math.BigDecimal diasemfim;

    private java.math.BigDecimal diasemini;

    private idw.idwws.DwFolhamedtemp dwFolhamedtemp;

    private idw.idwws.DwFolhamedtemphorcfg[] dwFolhamedtemphorcfgs;

    private java.math.BigDecimal hrfim;

    private java.lang.String hrfimgui;

    private java.math.BigDecimal hrini;

    private java.lang.String hrinigui;

    private java.math.BigDecimal idFolhamedtemphorario;

    public DwFolhamedtemhor() {
    }

    public DwFolhamedtemhor(
           java.math.BigDecimal diasemfim,
           java.math.BigDecimal diasemini,
           idw.idwws.DwFolhamedtemp dwFolhamedtemp,
           idw.idwws.DwFolhamedtemphorcfg[] dwFolhamedtemphorcfgs,
           java.math.BigDecimal hrfim,
           java.lang.String hrfimgui,
           java.math.BigDecimal hrini,
           java.lang.String hrinigui,
           java.math.BigDecimal idFolhamedtemphorario) {
        this.diasemfim = diasemfim;
        this.diasemini = diasemini;
        this.dwFolhamedtemp = dwFolhamedtemp;
        this.dwFolhamedtemphorcfgs = dwFolhamedtemphorcfgs;
        this.hrfim = hrfim;
        this.hrfimgui = hrfimgui;
        this.hrini = hrini;
        this.hrinigui = hrinigui;
        this.idFolhamedtemphorario = idFolhamedtemphorario;
    }


    /**
     * Gets the diasemfim value for this DwFolhamedtemhor.
     * 
     * @return diasemfim
     */
    public java.math.BigDecimal getDiasemfim() {
        return diasemfim;
    }


    /**
     * Sets the diasemfim value for this DwFolhamedtemhor.
     * 
     * @param diasemfim
     */
    public void setDiasemfim(java.math.BigDecimal diasemfim) {
        this.diasemfim = diasemfim;
    }


    /**
     * Gets the diasemini value for this DwFolhamedtemhor.
     * 
     * @return diasemini
     */
    public java.math.BigDecimal getDiasemini() {
        return diasemini;
    }


    /**
     * Sets the diasemini value for this DwFolhamedtemhor.
     * 
     * @param diasemini
     */
    public void setDiasemini(java.math.BigDecimal diasemini) {
        this.diasemini = diasemini;
    }


    /**
     * Gets the dwFolhamedtemp value for this DwFolhamedtemhor.
     * 
     * @return dwFolhamedtemp
     */
    public idw.idwws.DwFolhamedtemp getDwFolhamedtemp() {
        return dwFolhamedtemp;
    }


    /**
     * Sets the dwFolhamedtemp value for this DwFolhamedtemhor.
     * 
     * @param dwFolhamedtemp
     */
    public void setDwFolhamedtemp(idw.idwws.DwFolhamedtemp dwFolhamedtemp) {
        this.dwFolhamedtemp = dwFolhamedtemp;
    }


    /**
     * Gets the dwFolhamedtemphorcfgs value for this DwFolhamedtemhor.
     * 
     * @return dwFolhamedtemphorcfgs
     */
    public idw.idwws.DwFolhamedtemphorcfg[] getDwFolhamedtemphorcfgs() {
        return dwFolhamedtemphorcfgs;
    }


    /**
     * Sets the dwFolhamedtemphorcfgs value for this DwFolhamedtemhor.
     * 
     * @param dwFolhamedtemphorcfgs
     */
    public void setDwFolhamedtemphorcfgs(idw.idwws.DwFolhamedtemphorcfg[] dwFolhamedtemphorcfgs) {
        this.dwFolhamedtemphorcfgs = dwFolhamedtemphorcfgs;
    }

    public idw.idwws.DwFolhamedtemphorcfg getDwFolhamedtemphorcfgs(int i) {
        return this.dwFolhamedtemphorcfgs[i];
    }

    public void setDwFolhamedtemphorcfgs(int i, idw.idwws.DwFolhamedtemphorcfg _value) {
        this.dwFolhamedtemphorcfgs[i] = _value;
    }


    /**
     * Gets the hrfim value for this DwFolhamedtemhor.
     * 
     * @return hrfim
     */
    public java.math.BigDecimal getHrfim() {
        return hrfim;
    }


    /**
     * Sets the hrfim value for this DwFolhamedtemhor.
     * 
     * @param hrfim
     */
    public void setHrfim(java.math.BigDecimal hrfim) {
        this.hrfim = hrfim;
    }


    /**
     * Gets the hrfimgui value for this DwFolhamedtemhor.
     * 
     * @return hrfimgui
     */
    public java.lang.String getHrfimgui() {
        return hrfimgui;
    }


    /**
     * Sets the hrfimgui value for this DwFolhamedtemhor.
     * 
     * @param hrfimgui
     */
    public void setHrfimgui(java.lang.String hrfimgui) {
        this.hrfimgui = hrfimgui;
    }


    /**
     * Gets the hrini value for this DwFolhamedtemhor.
     * 
     * @return hrini
     */
    public java.math.BigDecimal getHrini() {
        return hrini;
    }


    /**
     * Sets the hrini value for this DwFolhamedtemhor.
     * 
     * @param hrini
     */
    public void setHrini(java.math.BigDecimal hrini) {
        this.hrini = hrini;
    }


    /**
     * Gets the hrinigui value for this DwFolhamedtemhor.
     * 
     * @return hrinigui
     */
    public java.lang.String getHrinigui() {
        return hrinigui;
    }


    /**
     * Sets the hrinigui value for this DwFolhamedtemhor.
     * 
     * @param hrinigui
     */
    public void setHrinigui(java.lang.String hrinigui) {
        this.hrinigui = hrinigui;
    }


    /**
     * Gets the idFolhamedtemphorario value for this DwFolhamedtemhor.
     * 
     * @return idFolhamedtemphorario
     */
    public java.math.BigDecimal getIdFolhamedtemphorario() {
        return idFolhamedtemphorario;
    }


    /**
     * Sets the idFolhamedtemphorario value for this DwFolhamedtemhor.
     * 
     * @param idFolhamedtemphorario
     */
    public void setIdFolhamedtemphorario(java.math.BigDecimal idFolhamedtemphorario) {
        this.idFolhamedtemphorario = idFolhamedtemphorario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwFolhamedtemhor)) return false;
        DwFolhamedtemhor other = (DwFolhamedtemhor) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.diasemfim==null && other.getDiasemfim()==null) || 
             (this.diasemfim!=null &&
              this.diasemfim.equals(other.getDiasemfim()))) &&
            ((this.diasemini==null && other.getDiasemini()==null) || 
             (this.diasemini!=null &&
              this.diasemini.equals(other.getDiasemini()))) &&
            ((this.dwFolhamedtemp==null && other.getDwFolhamedtemp()==null) || 
             (this.dwFolhamedtemp!=null &&
              this.dwFolhamedtemp.equals(other.getDwFolhamedtemp()))) &&
            ((this.dwFolhamedtemphorcfgs==null && other.getDwFolhamedtemphorcfgs()==null) || 
             (this.dwFolhamedtemphorcfgs!=null &&
              java.util.Arrays.equals(this.dwFolhamedtemphorcfgs, other.getDwFolhamedtemphorcfgs()))) &&
            ((this.hrfim==null && other.getHrfim()==null) || 
             (this.hrfim!=null &&
              this.hrfim.equals(other.getHrfim()))) &&
            ((this.hrfimgui==null && other.getHrfimgui()==null) || 
             (this.hrfimgui!=null &&
              this.hrfimgui.equals(other.getHrfimgui()))) &&
            ((this.hrini==null && other.getHrini()==null) || 
             (this.hrini!=null &&
              this.hrini.equals(other.getHrini()))) &&
            ((this.hrinigui==null && other.getHrinigui()==null) || 
             (this.hrinigui!=null &&
              this.hrinigui.equals(other.getHrinigui()))) &&
            ((this.idFolhamedtemphorario==null && other.getIdFolhamedtemphorario()==null) || 
             (this.idFolhamedtemphorario!=null &&
              this.idFolhamedtemphorario.equals(other.getIdFolhamedtemphorario())));
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
        if (getDiasemfim() != null) {
            _hashCode += getDiasemfim().hashCode();
        }
        if (getDiasemini() != null) {
            _hashCode += getDiasemini().hashCode();
        }
        if (getDwFolhamedtemp() != null) {
            _hashCode += getDwFolhamedtemp().hashCode();
        }
        if (getDwFolhamedtemphorcfgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwFolhamedtemphorcfgs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwFolhamedtemphorcfgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getHrfim() != null) {
            _hashCode += getHrfim().hashCode();
        }
        if (getHrfimgui() != null) {
            _hashCode += getHrfimgui().hashCode();
        }
        if (getHrini() != null) {
            _hashCode += getHrini().hashCode();
        }
        if (getHrinigui() != null) {
            _hashCode += getHrinigui().hashCode();
        }
        if (getIdFolhamedtemphorario() != null) {
            _hashCode += getIdFolhamedtemphorario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwFolhamedtemhor.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamedtemhor"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diasemfim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diasemfim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diasemini");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diasemini"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhamedtemp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhamedtemp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamedtemp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolhamedtemphorcfgs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolhamedtemphorcfgs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhamedtemphorcfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrfim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrfim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrfimgui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrfimgui"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrini");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrini"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrinigui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrinigui"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFolhamedtemphorario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFolhamedtemphorario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
