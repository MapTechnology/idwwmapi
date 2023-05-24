/**
 * DwPepro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwPepro  extends idw.idwws.DwPeproTemplate  implements java.io.Serializable {
    private java.lang.String dsPepro;

    private idw.idwws.DwConsolid[] dwConsolids;

    private long idPepro;

    private idw.idwws.OmCfg[] omCfgsForIdPeproCtreproc;

    private idw.idwws.OmCfg[] omCfgsForIdPeproNormal;

    public DwPepro() {
    }

    public DwPepro(
           java.lang.String dsPepro,
           idw.idwws.DwConsolid[] dwConsolids,
           long idPepro,
           idw.idwws.OmCfg[] omCfgsForIdPeproCtreproc,
           idw.idwws.OmCfg[] omCfgsForIdPeproNormal) {
        this.dsPepro = dsPepro;
        this.dwConsolids = dwConsolids;
        this.idPepro = idPepro;
        this.omCfgsForIdPeproCtreproc = omCfgsForIdPeproCtreproc;
        this.omCfgsForIdPeproNormal = omCfgsForIdPeproNormal;
    }


    /**
     * Gets the dsPepro value for this DwPepro.
     * 
     * @return dsPepro
     */
    public java.lang.String getDsPepro() {
        return dsPepro;
    }


    /**
     * Sets the dsPepro value for this DwPepro.
     * 
     * @param dsPepro
     */
    public void setDsPepro(java.lang.String dsPepro) {
        this.dsPepro = dsPepro;
    }


    /**
     * Gets the dwConsolids value for this DwPepro.
     * 
     * @return dwConsolids
     */
    public idw.idwws.DwConsolid[] getDwConsolids() {
        return dwConsolids;
    }


    /**
     * Sets the dwConsolids value for this DwPepro.
     * 
     * @param dwConsolids
     */
    public void setDwConsolids(idw.idwws.DwConsolid[] dwConsolids) {
        this.dwConsolids = dwConsolids;
    }

    public idw.idwws.DwConsolid getDwConsolids(int i) {
        return this.dwConsolids[i];
    }

    public void setDwConsolids(int i, idw.idwws.DwConsolid _value) {
        this.dwConsolids[i] = _value;
    }


    /**
     * Gets the idPepro value for this DwPepro.
     * 
     * @return idPepro
     */
    public long getIdPepro() {
        return idPepro;
    }


    /**
     * Sets the idPepro value for this DwPepro.
     * 
     * @param idPepro
     */
    public void setIdPepro(long idPepro) {
        this.idPepro = idPepro;
    }


    /**
     * Gets the omCfgsForIdPeproCtreproc value for this DwPepro.
     * 
     * @return omCfgsForIdPeproCtreproc
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdPeproCtreproc() {
        return omCfgsForIdPeproCtreproc;
    }


    /**
     * Sets the omCfgsForIdPeproCtreproc value for this DwPepro.
     * 
     * @param omCfgsForIdPeproCtreproc
     */
    public void setOmCfgsForIdPeproCtreproc(idw.idwws.OmCfg[] omCfgsForIdPeproCtreproc) {
        this.omCfgsForIdPeproCtreproc = omCfgsForIdPeproCtreproc;
    }

    public idw.idwws.OmCfg getOmCfgsForIdPeproCtreproc(int i) {
        return this.omCfgsForIdPeproCtreproc[i];
    }

    public void setOmCfgsForIdPeproCtreproc(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdPeproCtreproc[i] = _value;
    }


    /**
     * Gets the omCfgsForIdPeproNormal value for this DwPepro.
     * 
     * @return omCfgsForIdPeproNormal
     */
    public idw.idwws.OmCfg[] getOmCfgsForIdPeproNormal() {
        return omCfgsForIdPeproNormal;
    }


    /**
     * Sets the omCfgsForIdPeproNormal value for this DwPepro.
     * 
     * @param omCfgsForIdPeproNormal
     */
    public void setOmCfgsForIdPeproNormal(idw.idwws.OmCfg[] omCfgsForIdPeproNormal) {
        this.omCfgsForIdPeproNormal = omCfgsForIdPeproNormal;
    }

    public idw.idwws.OmCfg getOmCfgsForIdPeproNormal(int i) {
        return this.omCfgsForIdPeproNormal[i];
    }

    public void setOmCfgsForIdPeproNormal(int i, idw.idwws.OmCfg _value) {
        this.omCfgsForIdPeproNormal[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwPepro)) return false;
        DwPepro other = (DwPepro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsPepro==null && other.getDsPepro()==null) || 
             (this.dsPepro!=null &&
              this.dsPepro.equals(other.getDsPepro()))) &&
            ((this.dwConsolids==null && other.getDwConsolids()==null) || 
             (this.dwConsolids!=null &&
              java.util.Arrays.equals(this.dwConsolids, other.getDwConsolids()))) &&
            this.idPepro == other.getIdPepro() &&
            ((this.omCfgsForIdPeproCtreproc==null && other.getOmCfgsForIdPeproCtreproc()==null) || 
             (this.omCfgsForIdPeproCtreproc!=null &&
              java.util.Arrays.equals(this.omCfgsForIdPeproCtreproc, other.getOmCfgsForIdPeproCtreproc()))) &&
            ((this.omCfgsForIdPeproNormal==null && other.getOmCfgsForIdPeproNormal()==null) || 
             (this.omCfgsForIdPeproNormal!=null &&
              java.util.Arrays.equals(this.omCfgsForIdPeproNormal, other.getOmCfgsForIdPeproNormal())));
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
        if (getDsPepro() != null) {
            _hashCode += getDsPepro().hashCode();
        }
        if (getDwConsolids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwConsolids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwConsolids(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getIdPepro()).hashCode();
        if (getOmCfgsForIdPeproCtreproc() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdPeproCtreproc());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdPeproCtreproc(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOmCfgsForIdPeproNormal() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOmCfgsForIdPeproNormal());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOmCfgsForIdPeproNormal(), i);
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
        new org.apache.axis.description.TypeDesc(DwPepro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPepro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsPepro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsPepro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPepro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idPepro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdPeproCtreproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdPeproCtreproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omCfgsForIdPeproNormal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omCfgsForIdPeproNormal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omCfg"));
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
