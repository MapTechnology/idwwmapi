/**
 * Ijtbpostos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbpostos  implements java.io.Serializable {
    private java.lang.String cdcoletor;

    private java.lang.String cdmestre;

    private java.lang.String cdposto;

    private java.math.BigDecimal cdsubcoletor;

    private java.lang.String dsposto;

    private idw.idwws.Ijgalobj[] ijgalobjs;

    private idw.idwws.Ijmovpostos[] ijmovpostoses;

    private idw.idwws.Ijpostogrpestproc[] ijpostogrpestprocs;

    private java.math.BigDecimal stposto;

    private java.math.BigDecimal tpposto;

    public Ijtbpostos() {
    }

    public Ijtbpostos(
           java.lang.String cdcoletor,
           java.lang.String cdmestre,
           java.lang.String cdposto,
           java.math.BigDecimal cdsubcoletor,
           java.lang.String dsposto,
           idw.idwws.Ijgalobj[] ijgalobjs,
           idw.idwws.Ijmovpostos[] ijmovpostoses,
           idw.idwws.Ijpostogrpestproc[] ijpostogrpestprocs,
           java.math.BigDecimal stposto,
           java.math.BigDecimal tpposto) {
           this.cdcoletor = cdcoletor;
           this.cdmestre = cdmestre;
           this.cdposto = cdposto;
           this.cdsubcoletor = cdsubcoletor;
           this.dsposto = dsposto;
           this.ijgalobjs = ijgalobjs;
           this.ijmovpostoses = ijmovpostoses;
           this.ijpostogrpestprocs = ijpostogrpestprocs;
           this.stposto = stposto;
           this.tpposto = tpposto;
    }


    /**
     * Gets the cdcoletor value for this Ijtbpostos.
     * 
     * @return cdcoletor
     */
    public java.lang.String getCdcoletor() {
        return cdcoletor;
    }


    /**
     * Sets the cdcoletor value for this Ijtbpostos.
     * 
     * @param cdcoletor
     */
    public void setCdcoletor(java.lang.String cdcoletor) {
        this.cdcoletor = cdcoletor;
    }


    /**
     * Gets the cdmestre value for this Ijtbpostos.
     * 
     * @return cdmestre
     */
    public java.lang.String getCdmestre() {
        return cdmestre;
    }


    /**
     * Sets the cdmestre value for this Ijtbpostos.
     * 
     * @param cdmestre
     */
    public void setCdmestre(java.lang.String cdmestre) {
        this.cdmestre = cdmestre;
    }


    /**
     * Gets the cdposto value for this Ijtbpostos.
     * 
     * @return cdposto
     */
    public java.lang.String getCdposto() {
        return cdposto;
    }


    /**
     * Sets the cdposto value for this Ijtbpostos.
     * 
     * @param cdposto
     */
    public void setCdposto(java.lang.String cdposto) {
        this.cdposto = cdposto;
    }


    /**
     * Gets the cdsubcoletor value for this Ijtbpostos.
     * 
     * @return cdsubcoletor
     */
    public java.math.BigDecimal getCdsubcoletor() {
        return cdsubcoletor;
    }


    /**
     * Sets the cdsubcoletor value for this Ijtbpostos.
     * 
     * @param cdsubcoletor
     */
    public void setCdsubcoletor(java.math.BigDecimal cdsubcoletor) {
        this.cdsubcoletor = cdsubcoletor;
    }


    /**
     * Gets the dsposto value for this Ijtbpostos.
     * 
     * @return dsposto
     */
    public java.lang.String getDsposto() {
        return dsposto;
    }


    /**
     * Sets the dsposto value for this Ijtbpostos.
     * 
     * @param dsposto
     */
    public void setDsposto(java.lang.String dsposto) {
        this.dsposto = dsposto;
    }


    /**
     * Gets the ijgalobjs value for this Ijtbpostos.
     * 
     * @return ijgalobjs
     */
    public idw.idwws.Ijgalobj[] getIjgalobjs() {
        return ijgalobjs;
    }


    /**
     * Sets the ijgalobjs value for this Ijtbpostos.
     * 
     * @param ijgalobjs
     */
    public void setIjgalobjs(idw.idwws.Ijgalobj[] ijgalobjs) {
        this.ijgalobjs = ijgalobjs;
    }

    public idw.idwws.Ijgalobj getIjgalobjs(int i) {
        return this.ijgalobjs[i];
    }

    public void setIjgalobjs(int i, idw.idwws.Ijgalobj _value) {
        this.ijgalobjs[i] = _value;
    }


    /**
     * Gets the ijmovpostoses value for this Ijtbpostos.
     * 
     * @return ijmovpostoses
     */
    public idw.idwws.Ijmovpostos[] getIjmovpostoses() {
        return ijmovpostoses;
    }


    /**
     * Sets the ijmovpostoses value for this Ijtbpostos.
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
     * Gets the ijpostogrpestprocs value for this Ijtbpostos.
     * 
     * @return ijpostogrpestprocs
     */
    public idw.idwws.Ijpostogrpestproc[] getIjpostogrpestprocs() {
        return ijpostogrpestprocs;
    }


    /**
     * Sets the ijpostogrpestprocs value for this Ijtbpostos.
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
     * Gets the stposto value for this Ijtbpostos.
     * 
     * @return stposto
     */
    public java.math.BigDecimal getStposto() {
        return stposto;
    }


    /**
     * Sets the stposto value for this Ijtbpostos.
     * 
     * @param stposto
     */
    public void setStposto(java.math.BigDecimal stposto) {
        this.stposto = stposto;
    }


    /**
     * Gets the tpposto value for this Ijtbpostos.
     * 
     * @return tpposto
     */
    public java.math.BigDecimal getTpposto() {
        return tpposto;
    }


    /**
     * Sets the tpposto value for this Ijtbpostos.
     * 
     * @param tpposto
     */
    public void setTpposto(java.math.BigDecimal tpposto) {
        this.tpposto = tpposto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbpostos)) return false;
        Ijtbpostos other = (Ijtbpostos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdcoletor==null && other.getCdcoletor()==null) || 
             (this.cdcoletor!=null &&
              this.cdcoletor.equals(other.getCdcoletor()))) &&
            ((this.cdmestre==null && other.getCdmestre()==null) || 
             (this.cdmestre!=null &&
              this.cdmestre.equals(other.getCdmestre()))) &&
            ((this.cdposto==null && other.getCdposto()==null) || 
             (this.cdposto!=null &&
              this.cdposto.equals(other.getCdposto()))) &&
            ((this.cdsubcoletor==null && other.getCdsubcoletor()==null) || 
             (this.cdsubcoletor!=null &&
              this.cdsubcoletor.equals(other.getCdsubcoletor()))) &&
            ((this.dsposto==null && other.getDsposto()==null) || 
             (this.dsposto!=null &&
              this.dsposto.equals(other.getDsposto()))) &&
            ((this.ijgalobjs==null && other.getIjgalobjs()==null) || 
             (this.ijgalobjs!=null &&
              java.util.Arrays.equals(this.ijgalobjs, other.getIjgalobjs()))) &&
            ((this.ijmovpostoses==null && other.getIjmovpostoses()==null) || 
             (this.ijmovpostoses!=null &&
              java.util.Arrays.equals(this.ijmovpostoses, other.getIjmovpostoses()))) &&
            ((this.ijpostogrpestprocs==null && other.getIjpostogrpestprocs()==null) || 
             (this.ijpostogrpestprocs!=null &&
              java.util.Arrays.equals(this.ijpostogrpestprocs, other.getIjpostogrpestprocs()))) &&
            ((this.stposto==null && other.getStposto()==null) || 
             (this.stposto!=null &&
              this.stposto.equals(other.getStposto()))) &&
            ((this.tpposto==null && other.getTpposto()==null) || 
             (this.tpposto!=null &&
              this.tpposto.equals(other.getTpposto())));
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
        if (getCdcoletor() != null) {
            _hashCode += getCdcoletor().hashCode();
        }
        if (getCdmestre() != null) {
            _hashCode += getCdmestre().hashCode();
        }
        if (getCdposto() != null) {
            _hashCode += getCdposto().hashCode();
        }
        if (getCdsubcoletor() != null) {
            _hashCode += getCdsubcoletor().hashCode();
        }
        if (getDsposto() != null) {
            _hashCode += getDsposto().hashCode();
        }
        if (getIjgalobjs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgalobjs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgalobjs(), i);
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
        if (getStposto() != null) {
            _hashCode += getStposto().hashCode();
        }
        if (getTpposto() != null) {
            _hashCode += getTpposto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbpostos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpostos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdcoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdcoletor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmestre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmestre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdposto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdposto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdsubcoletor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdsubcoletor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsposto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsposto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgalobjs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgalobjs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgalobj"));
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
        elemField.setFieldName("stposto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stposto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpposto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpposto"));
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
