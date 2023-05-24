/**
 * DwNserie.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwNserie  extends idw.idwws.DwNserieTemplate  implements java.io.Serializable {
    private java.lang.String cb;

    private idw.idwws.DwEst dwEst;

    private idw.idwws.DwPassagem dwPassagem;

    private idw.idwws.DwPassagem[] dwPassagems;

    private idw.idwws.DwPassagem dwPassagemtf;

    private long idNserie;

    private java.lang.String ns;

    private idw.idwws.OmProduto omProduto;

    public DwNserie() {
    }

    public DwNserie(
           java.lang.String cb,
           idw.idwws.DwEst dwEst,
           idw.idwws.DwPassagem dwPassagem,
           idw.idwws.DwPassagem[] dwPassagems,
           idw.idwws.DwPassagem dwPassagemtf,
           long idNserie,
           java.lang.String ns,
           idw.idwws.OmProduto omProduto) {
        this.cb = cb;
        this.dwEst = dwEst;
        this.dwPassagem = dwPassagem;
        this.dwPassagems = dwPassagems;
        this.dwPassagemtf = dwPassagemtf;
        this.idNserie = idNserie;
        this.ns = ns;
        this.omProduto = omProduto;
    }


    /**
     * Gets the cb value for this DwNserie.
     * 
     * @return cb
     */
    public java.lang.String getCb() {
        return cb;
    }


    /**
     * Sets the cb value for this DwNserie.
     * 
     * @param cb
     */
    public void setCb(java.lang.String cb) {
        this.cb = cb;
    }


    /**
     * Gets the dwEst value for this DwNserie.
     * 
     * @return dwEst
     */
    public idw.idwws.DwEst getDwEst() {
        return dwEst;
    }


    /**
     * Sets the dwEst value for this DwNserie.
     * 
     * @param dwEst
     */
    public void setDwEst(idw.idwws.DwEst dwEst) {
        this.dwEst = dwEst;
    }


    /**
     * Gets the dwPassagem value for this DwNserie.
     * 
     * @return dwPassagem
     */
    public idw.idwws.DwPassagem getDwPassagem() {
        return dwPassagem;
    }


    /**
     * Sets the dwPassagem value for this DwNserie.
     * 
     * @param dwPassagem
     */
    public void setDwPassagem(idw.idwws.DwPassagem dwPassagem) {
        this.dwPassagem = dwPassagem;
    }


    /**
     * Gets the dwPassagems value for this DwNserie.
     * 
     * @return dwPassagems
     */
    public idw.idwws.DwPassagem[] getDwPassagems() {
        return dwPassagems;
    }


    /**
     * Sets the dwPassagems value for this DwNserie.
     * 
     * @param dwPassagems
     */
    public void setDwPassagems(idw.idwws.DwPassagem[] dwPassagems) {
        this.dwPassagems = dwPassagems;
    }

    public idw.idwws.DwPassagem getDwPassagems(int i) {
        return this.dwPassagems[i];
    }

    public void setDwPassagems(int i, idw.idwws.DwPassagem _value) {
        this.dwPassagems[i] = _value;
    }


    /**
     * Gets the dwPassagemtf value for this DwNserie.
     * 
     * @return dwPassagemtf
     */
    public idw.idwws.DwPassagem getDwPassagemtf() {
        return dwPassagemtf;
    }


    /**
     * Sets the dwPassagemtf value for this DwNserie.
     * 
     * @param dwPassagemtf
     */
    public void setDwPassagemtf(idw.idwws.DwPassagem dwPassagemtf) {
        this.dwPassagemtf = dwPassagemtf;
    }


    /**
     * Gets the idNserie value for this DwNserie.
     * 
     * @return idNserie
     */
    public long getIdNserie() {
        return idNserie;
    }


    /**
     * Sets the idNserie value for this DwNserie.
     * 
     * @param idNserie
     */
    public void setIdNserie(long idNserie) {
        this.idNserie = idNserie;
    }


    /**
     * Gets the ns value for this DwNserie.
     * 
     * @return ns
     */
    public java.lang.String getNs() {
        return ns;
    }


    /**
     * Sets the ns value for this DwNserie.
     * 
     * @param ns
     */
    public void setNs(java.lang.String ns) {
        this.ns = ns;
    }


    /**
     * Gets the omProduto value for this DwNserie.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this DwNserie.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwNserie)) return false;
        DwNserie other = (DwNserie) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cb==null && other.getCb()==null) || 
             (this.cb!=null &&
              this.cb.equals(other.getCb()))) &&
            ((this.dwEst==null && other.getDwEst()==null) || 
             (this.dwEst!=null &&
              this.dwEst.equals(other.getDwEst()))) &&
            ((this.dwPassagem==null && other.getDwPassagem()==null) || 
             (this.dwPassagem!=null &&
              this.dwPassagem.equals(other.getDwPassagem()))) &&
            ((this.dwPassagems==null && other.getDwPassagems()==null) || 
             (this.dwPassagems!=null &&
              java.util.Arrays.equals(this.dwPassagems, other.getDwPassagems()))) &&
            ((this.dwPassagemtf==null && other.getDwPassagemtf()==null) || 
             (this.dwPassagemtf!=null &&
              this.dwPassagemtf.equals(other.getDwPassagemtf()))) &&
            this.idNserie == other.getIdNserie() &&
            ((this.ns==null && other.getNs()==null) || 
             (this.ns!=null &&
              this.ns.equals(other.getNs()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto())));
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
        if (getCb() != null) {
            _hashCode += getCb().hashCode();
        }
        if (getDwEst() != null) {
            _hashCode += getDwEst().hashCode();
        }
        if (getDwPassagem() != null) {
            _hashCode += getDwPassagem().hashCode();
        }
        if (getDwPassagems() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwPassagems());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwPassagems(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwPassagemtf() != null) {
            _hashCode += getDwPassagemtf().hashCode();
        }
        _hashCode += new Long(getIdNserie()).hashCode();
        if (getNs() != null) {
            _hashCode += getNs().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwNserie.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwNserie"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cb");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cb"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEst");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEst"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEst"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagems");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagems"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwPassagemtf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwPassagemtf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwPassagem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idNserie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idNserie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ns");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ns"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
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
