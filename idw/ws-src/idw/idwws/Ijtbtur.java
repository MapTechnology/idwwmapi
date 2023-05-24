/**
 * Ijtbtur.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbtur  implements java.io.Serializable {
    private java.lang.String cdturno;

    private java.lang.String dsturno;

    private idw.idwws.Exportacao001[] exportacao001S;

    private idw.idwws.Ijcncturno[] ijcncturnos;

    private idw.idwws.Ijhortur[] ijhorturs;

    private idw.idwws.Ijrefman[] ijrefmans;

    private idw.idwws.Ijreprodt[] ijreprodts;

    private idw.idwws.Ijtbmodisp[] ijtbmodisps;

    public Ijtbtur() {
    }

    public Ijtbtur(
           java.lang.String cdturno,
           java.lang.String dsturno,
           idw.idwws.Exportacao001[] exportacao001S,
           idw.idwws.Ijcncturno[] ijcncturnos,
           idw.idwws.Ijhortur[] ijhorturs,
           idw.idwws.Ijrefman[] ijrefmans,
           idw.idwws.Ijreprodt[] ijreprodts,
           idw.idwws.Ijtbmodisp[] ijtbmodisps) {
           this.cdturno = cdturno;
           this.dsturno = dsturno;
           this.exportacao001S = exportacao001S;
           this.ijcncturnos = ijcncturnos;
           this.ijhorturs = ijhorturs;
           this.ijrefmans = ijrefmans;
           this.ijreprodts = ijreprodts;
           this.ijtbmodisps = ijtbmodisps;
    }


    /**
     * Gets the cdturno value for this Ijtbtur.
     * 
     * @return cdturno
     */
    public java.lang.String getCdturno() {
        return cdturno;
    }


    /**
     * Sets the cdturno value for this Ijtbtur.
     * 
     * @param cdturno
     */
    public void setCdturno(java.lang.String cdturno) {
        this.cdturno = cdturno;
    }


    /**
     * Gets the dsturno value for this Ijtbtur.
     * 
     * @return dsturno
     */
    public java.lang.String getDsturno() {
        return dsturno;
    }


    /**
     * Sets the dsturno value for this Ijtbtur.
     * 
     * @param dsturno
     */
    public void setDsturno(java.lang.String dsturno) {
        this.dsturno = dsturno;
    }


    /**
     * Gets the exportacao001S value for this Ijtbtur.
     * 
     * @return exportacao001S
     */
    public idw.idwws.Exportacao001[] getExportacao001S() {
        return exportacao001S;
    }


    /**
     * Sets the exportacao001S value for this Ijtbtur.
     * 
     * @param exportacao001S
     */
    public void setExportacao001S(idw.idwws.Exportacao001[] exportacao001S) {
        this.exportacao001S = exportacao001S;
    }

    public idw.idwws.Exportacao001 getExportacao001S(int i) {
        return this.exportacao001S[i];
    }

    public void setExportacao001S(int i, idw.idwws.Exportacao001 _value) {
        this.exportacao001S[i] = _value;
    }


    /**
     * Gets the ijcncturnos value for this Ijtbtur.
     * 
     * @return ijcncturnos
     */
    public idw.idwws.Ijcncturno[] getIjcncturnos() {
        return ijcncturnos;
    }


    /**
     * Sets the ijcncturnos value for this Ijtbtur.
     * 
     * @param ijcncturnos
     */
    public void setIjcncturnos(idw.idwws.Ijcncturno[] ijcncturnos) {
        this.ijcncturnos = ijcncturnos;
    }

    public idw.idwws.Ijcncturno getIjcncturnos(int i) {
        return this.ijcncturnos[i];
    }

    public void setIjcncturnos(int i, idw.idwws.Ijcncturno _value) {
        this.ijcncturnos[i] = _value;
    }


    /**
     * Gets the ijhorturs value for this Ijtbtur.
     * 
     * @return ijhorturs
     */
    public idw.idwws.Ijhortur[] getIjhorturs() {
        return ijhorturs;
    }


    /**
     * Sets the ijhorturs value for this Ijtbtur.
     * 
     * @param ijhorturs
     */
    public void setIjhorturs(idw.idwws.Ijhortur[] ijhorturs) {
        this.ijhorturs = ijhorturs;
    }

    public idw.idwws.Ijhortur getIjhorturs(int i) {
        return this.ijhorturs[i];
    }

    public void setIjhorturs(int i, idw.idwws.Ijhortur _value) {
        this.ijhorturs[i] = _value;
    }


    /**
     * Gets the ijrefmans value for this Ijtbtur.
     * 
     * @return ijrefmans
     */
    public idw.idwws.Ijrefman[] getIjrefmans() {
        return ijrefmans;
    }


    /**
     * Sets the ijrefmans value for this Ijtbtur.
     * 
     * @param ijrefmans
     */
    public void setIjrefmans(idw.idwws.Ijrefman[] ijrefmans) {
        this.ijrefmans = ijrefmans;
    }

    public idw.idwws.Ijrefman getIjrefmans(int i) {
        return this.ijrefmans[i];
    }

    public void setIjrefmans(int i, idw.idwws.Ijrefman _value) {
        this.ijrefmans[i] = _value;
    }


    /**
     * Gets the ijreprodts value for this Ijtbtur.
     * 
     * @return ijreprodts
     */
    public idw.idwws.Ijreprodt[] getIjreprodts() {
        return ijreprodts;
    }


    /**
     * Sets the ijreprodts value for this Ijtbtur.
     * 
     * @param ijreprodts
     */
    public void setIjreprodts(idw.idwws.Ijreprodt[] ijreprodts) {
        this.ijreprodts = ijreprodts;
    }

    public idw.idwws.Ijreprodt getIjreprodts(int i) {
        return this.ijreprodts[i];
    }

    public void setIjreprodts(int i, idw.idwws.Ijreprodt _value) {
        this.ijreprodts[i] = _value;
    }


    /**
     * Gets the ijtbmodisps value for this Ijtbtur.
     * 
     * @return ijtbmodisps
     */
    public idw.idwws.Ijtbmodisp[] getIjtbmodisps() {
        return ijtbmodisps;
    }


    /**
     * Sets the ijtbmodisps value for this Ijtbtur.
     * 
     * @param ijtbmodisps
     */
    public void setIjtbmodisps(idw.idwws.Ijtbmodisp[] ijtbmodisps) {
        this.ijtbmodisps = ijtbmodisps;
    }

    public idw.idwws.Ijtbmodisp getIjtbmodisps(int i) {
        return this.ijtbmodisps[i];
    }

    public void setIjtbmodisps(int i, idw.idwws.Ijtbmodisp _value) {
        this.ijtbmodisps[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbtur)) return false;
        Ijtbtur other = (Ijtbtur) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdturno==null && other.getCdturno()==null) || 
             (this.cdturno!=null &&
              this.cdturno.equals(other.getCdturno()))) &&
            ((this.dsturno==null && other.getDsturno()==null) || 
             (this.dsturno!=null &&
              this.dsturno.equals(other.getDsturno()))) &&
            ((this.exportacao001S==null && other.getExportacao001S()==null) || 
             (this.exportacao001S!=null &&
              java.util.Arrays.equals(this.exportacao001S, other.getExportacao001S()))) &&
            ((this.ijcncturnos==null && other.getIjcncturnos()==null) || 
             (this.ijcncturnos!=null &&
              java.util.Arrays.equals(this.ijcncturnos, other.getIjcncturnos()))) &&
            ((this.ijhorturs==null && other.getIjhorturs()==null) || 
             (this.ijhorturs!=null &&
              java.util.Arrays.equals(this.ijhorturs, other.getIjhorturs()))) &&
            ((this.ijrefmans==null && other.getIjrefmans()==null) || 
             (this.ijrefmans!=null &&
              java.util.Arrays.equals(this.ijrefmans, other.getIjrefmans()))) &&
            ((this.ijreprodts==null && other.getIjreprodts()==null) || 
             (this.ijreprodts!=null &&
              java.util.Arrays.equals(this.ijreprodts, other.getIjreprodts()))) &&
            ((this.ijtbmodisps==null && other.getIjtbmodisps()==null) || 
             (this.ijtbmodisps!=null &&
              java.util.Arrays.equals(this.ijtbmodisps, other.getIjtbmodisps())));
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
        if (getCdturno() != null) {
            _hashCode += getCdturno().hashCode();
        }
        if (getDsturno() != null) {
            _hashCode += getDsturno().hashCode();
        }
        if (getExportacao001S() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getExportacao001S());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getExportacao001S(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjcncturnos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcncturnos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcncturnos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjhorturs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjhorturs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjhorturs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrefmans() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrefmans());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrefmans(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjreprodts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreprodts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreprodts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbmodisps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbmodisps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbmodisps(), i);
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
        new org.apache.axis.description.TypeDesc(Ijtbtur.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtur"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exportacao001S");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exportacao001s"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "exportacao001"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcncturnos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcncturnos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcncturno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijhorturs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijhorturs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijhortur"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrefmans");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrefmans"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrefman"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreprodts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreprodts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreprodt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmodisps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmodisps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmodisp"));
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
