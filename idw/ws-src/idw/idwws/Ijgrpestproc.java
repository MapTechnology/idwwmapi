/**
 * Ijgrpestproc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijgrpestproc  implements java.io.Serializable {
    private java.lang.String cdgrupoestproc;

    private java.lang.String dsgrupoestproc;

    private idw.idwws.Ijgrpdetestproc[] ijgrpdetestprocs;

    private idw.idwws.Ijmovpostos[] ijmovpostoses;

    private idw.idwws.Ijpostogrpestproc[] ijpostogrpestprocs;

    private idw.idwws.Ijtboperacoes ijtboperacoes;

    public Ijgrpestproc() {
    }

    public Ijgrpestproc(
           java.lang.String cdgrupoestproc,
           java.lang.String dsgrupoestproc,
           idw.idwws.Ijgrpdetestproc[] ijgrpdetestprocs,
           idw.idwws.Ijmovpostos[] ijmovpostoses,
           idw.idwws.Ijpostogrpestproc[] ijpostogrpestprocs,
           idw.idwws.Ijtboperacoes ijtboperacoes) {
           this.cdgrupoestproc = cdgrupoestproc;
           this.dsgrupoestproc = dsgrupoestproc;
           this.ijgrpdetestprocs = ijgrpdetestprocs;
           this.ijmovpostoses = ijmovpostoses;
           this.ijpostogrpestprocs = ijpostogrpestprocs;
           this.ijtboperacoes = ijtboperacoes;
    }


    /**
     * Gets the cdgrupoestproc value for this Ijgrpestproc.
     * 
     * @return cdgrupoestproc
     */
    public java.lang.String getCdgrupoestproc() {
        return cdgrupoestproc;
    }


    /**
     * Sets the cdgrupoestproc value for this Ijgrpestproc.
     * 
     * @param cdgrupoestproc
     */
    public void setCdgrupoestproc(java.lang.String cdgrupoestproc) {
        this.cdgrupoestproc = cdgrupoestproc;
    }


    /**
     * Gets the dsgrupoestproc value for this Ijgrpestproc.
     * 
     * @return dsgrupoestproc
     */
    public java.lang.String getDsgrupoestproc() {
        return dsgrupoestproc;
    }


    /**
     * Sets the dsgrupoestproc value for this Ijgrpestproc.
     * 
     * @param dsgrupoestproc
     */
    public void setDsgrupoestproc(java.lang.String dsgrupoestproc) {
        this.dsgrupoestproc = dsgrupoestproc;
    }


    /**
     * Gets the ijgrpdetestprocs value for this Ijgrpestproc.
     * 
     * @return ijgrpdetestprocs
     */
    public idw.idwws.Ijgrpdetestproc[] getIjgrpdetestprocs() {
        return ijgrpdetestprocs;
    }


    /**
     * Sets the ijgrpdetestprocs value for this Ijgrpestproc.
     * 
     * @param ijgrpdetestprocs
     */
    public void setIjgrpdetestprocs(idw.idwws.Ijgrpdetestproc[] ijgrpdetestprocs) {
        this.ijgrpdetestprocs = ijgrpdetestprocs;
    }

    public idw.idwws.Ijgrpdetestproc getIjgrpdetestprocs(int i) {
        return this.ijgrpdetestprocs[i];
    }

    public void setIjgrpdetestprocs(int i, idw.idwws.Ijgrpdetestproc _value) {
        this.ijgrpdetestprocs[i] = _value;
    }


    /**
     * Gets the ijmovpostoses value for this Ijgrpestproc.
     * 
     * @return ijmovpostoses
     */
    public idw.idwws.Ijmovpostos[] getIjmovpostoses() {
        return ijmovpostoses;
    }


    /**
     * Sets the ijmovpostoses value for this Ijgrpestproc.
     * 
     * @param ijmovpostoses
     */
    public void setIjmovpostoses(idw.idwws.Ijmovpostos[] ijmovpostoses) {
        this.ijmovpostoses = ijmovpostoses;
    }

    public idw.idwws.Ijmovpostos getIjmovpostoses(int i) {
        return this.ijmovpostoses[i];
    }

    public void setIjmovpostoses(int i, idw.idwws.Ijmovpostos _value) {
        this.ijmovpostoses[i] = _value;
    }


    /**
     * Gets the ijpostogrpestprocs value for this Ijgrpestproc.
     * 
     * @return ijpostogrpestprocs
     */
    public idw.idwws.Ijpostogrpestproc[] getIjpostogrpestprocs() {
        return ijpostogrpestprocs;
    }


    /**
     * Sets the ijpostogrpestprocs value for this Ijgrpestproc.
     * 
     * @param ijpostogrpestprocs
     */
    public void setIjpostogrpestprocs(idw.idwws.Ijpostogrpestproc[] ijpostogrpestprocs) {
        this.ijpostogrpestprocs = ijpostogrpestprocs;
    }

    public idw.idwws.Ijpostogrpestproc getIjpostogrpestprocs(int i) {
        return this.ijpostogrpestprocs[i];
    }

    public void setIjpostogrpestprocs(int i, idw.idwws.Ijpostogrpestproc _value) {
        this.ijpostogrpestprocs[i] = _value;
    }


    /**
     * Gets the ijtboperacoes value for this Ijgrpestproc.
     * 
     * @return ijtboperacoes
     */
    public idw.idwws.Ijtboperacoes getIjtboperacoes() {
        return ijtboperacoes;
    }


    /**
     * Sets the ijtboperacoes value for this Ijgrpestproc.
     * 
     * @param ijtboperacoes
     */
    public void setIjtboperacoes(idw.idwws.Ijtboperacoes ijtboperacoes) {
        this.ijtboperacoes = ijtboperacoes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijgrpestproc)) return false;
        Ijgrpestproc other = (Ijgrpestproc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdgrupoestproc==null && other.getCdgrupoestproc()==null) || 
             (this.cdgrupoestproc!=null &&
              this.cdgrupoestproc.equals(other.getCdgrupoestproc()))) &&
            ((this.dsgrupoestproc==null && other.getDsgrupoestproc()==null) || 
             (this.dsgrupoestproc!=null &&
              this.dsgrupoestproc.equals(other.getDsgrupoestproc()))) &&
            ((this.ijgrpdetestprocs==null && other.getIjgrpdetestprocs()==null) || 
             (this.ijgrpdetestprocs!=null &&
              java.util.Arrays.equals(this.ijgrpdetestprocs, other.getIjgrpdetestprocs()))) &&
            ((this.ijmovpostoses==null && other.getIjmovpostoses()==null) || 
             (this.ijmovpostoses!=null &&
              java.util.Arrays.equals(this.ijmovpostoses, other.getIjmovpostoses()))) &&
            ((this.ijpostogrpestprocs==null && other.getIjpostogrpestprocs()==null) || 
             (this.ijpostogrpestprocs!=null &&
              java.util.Arrays.equals(this.ijpostogrpestprocs, other.getIjpostogrpestprocs()))) &&
            ((this.ijtboperacoes==null && other.getIjtboperacoes()==null) || 
             (this.ijtboperacoes!=null &&
              this.ijtboperacoes.equals(other.getIjtboperacoes())));
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
        if (getCdgrupoestproc() != null) {
            _hashCode += getCdgrupoestproc().hashCode();
        }
        if (getDsgrupoestproc() != null) {
            _hashCode += getDsgrupoestproc().hashCode();
        }
        if (getIjgrpdetestprocs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpdetestprocs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpdetestprocs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjmovpostoses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjmovpostoses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjmovpostoses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpostogrpestprocs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpostogrpestprocs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpostogrpestprocs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtboperacoes() != null) {
            _hashCode += getIjtboperacoes().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijgrpestproc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpestproc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdgrupoestproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdgrupoestproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsgrupoestproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsgrupoestproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpdetestprocs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpdetestprocs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpdetestproc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmovpostoses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmovpostoses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmovpostos"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpostogrpestprocs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpostogrpestprocs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpostogrpestproc"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtboperacoes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtboperacoes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtboperacoes"));
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
