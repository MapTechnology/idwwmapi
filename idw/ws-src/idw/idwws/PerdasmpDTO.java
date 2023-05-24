/**
 * PerdasmpDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PerdasmpDTO  implements java.io.Serializable {
    private java.lang.String[] cdsRaps;

    private idw.idwws.DwRap dwRap;

    private idw.idwws.DwTPerdamp dwTPerdamp;

    private java.lang.Double indiceDePerda;

    private idw.idwws.OmProduto omproduto;

    private java.lang.Double quantidade;

    public PerdasmpDTO() {
    }

    public PerdasmpDTO(
           java.lang.String[] cdsRaps,
           idw.idwws.DwRap dwRap,
           idw.idwws.DwTPerdamp dwTPerdamp,
           java.lang.Double indiceDePerda,
           idw.idwws.OmProduto omproduto,
           java.lang.Double quantidade) {
           this.cdsRaps = cdsRaps;
           this.dwRap = dwRap;
           this.dwTPerdamp = dwTPerdamp;
           this.indiceDePerda = indiceDePerda;
           this.omproduto = omproduto;
           this.quantidade = quantidade;
    }


    /**
     * Gets the cdsRaps value for this PerdasmpDTO.
     * 
     * @return cdsRaps
     */
    public java.lang.String[] getCdsRaps() {
        return cdsRaps;
    }


    /**
     * Sets the cdsRaps value for this PerdasmpDTO.
     * 
     * @param cdsRaps
     */
    public void setCdsRaps(java.lang.String[] cdsRaps) {
        this.cdsRaps = cdsRaps;
    }

    public java.lang.String getCdsRaps(int i) {
        return this.cdsRaps[i];
    }

    public void setCdsRaps(int i, java.lang.String _value) {
        this.cdsRaps[i] = _value;
    }


    /**
     * Gets the dwRap value for this PerdasmpDTO.
     * 
     * @return dwRap
     */
    public idw.idwws.DwRap getDwRap() {
        return dwRap;
    }


    /**
     * Sets the dwRap value for this PerdasmpDTO.
     * 
     * @param dwRap
     */
    public void setDwRap(idw.idwws.DwRap dwRap) {
        this.dwRap = dwRap;
    }


    /**
     * Gets the dwTPerdamp value for this PerdasmpDTO.
     * 
     * @return dwTPerdamp
     */
    public idw.idwws.DwTPerdamp getDwTPerdamp() {
        return dwTPerdamp;
    }


    /**
     * Sets the dwTPerdamp value for this PerdasmpDTO.
     * 
     * @param dwTPerdamp
     */
    public void setDwTPerdamp(idw.idwws.DwTPerdamp dwTPerdamp) {
        this.dwTPerdamp = dwTPerdamp;
    }


    /**
     * Gets the indiceDePerda value for this PerdasmpDTO.
     * 
     * @return indiceDePerda
     */
    public java.lang.Double getIndiceDePerda() {
        return indiceDePerda;
    }


    /**
     * Sets the indiceDePerda value for this PerdasmpDTO.
     * 
     * @param indiceDePerda
     */
    public void setIndiceDePerda(java.lang.Double indiceDePerda) {
        this.indiceDePerda = indiceDePerda;
    }


    /**
     * Gets the omproduto value for this PerdasmpDTO.
     * 
     * @return omproduto
     */
    public idw.idwws.OmProduto getOmproduto() {
        return omproduto;
    }


    /**
     * Sets the omproduto value for this PerdasmpDTO.
     * 
     * @param omproduto
     */
    public void setOmproduto(idw.idwws.OmProduto omproduto) {
        this.omproduto = omproduto;
    }


    /**
     * Gets the quantidade value for this PerdasmpDTO.
     * 
     * @return quantidade
     */
    public java.lang.Double getQuantidade() {
        return quantidade;
    }


    /**
     * Sets the quantidade value for this PerdasmpDTO.
     * 
     * @param quantidade
     */
    public void setQuantidade(java.lang.Double quantidade) {
        this.quantidade = quantidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PerdasmpDTO)) return false;
        PerdasmpDTO other = (PerdasmpDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdsRaps==null && other.getCdsRaps()==null) || 
             (this.cdsRaps!=null &&
              java.util.Arrays.equals(this.cdsRaps, other.getCdsRaps()))) &&
            ((this.dwRap==null && other.getDwRap()==null) || 
             (this.dwRap!=null &&
              this.dwRap.equals(other.getDwRap()))) &&
            ((this.dwTPerdamp==null && other.getDwTPerdamp()==null) || 
             (this.dwTPerdamp!=null &&
              this.dwTPerdamp.equals(other.getDwTPerdamp()))) &&
            ((this.indiceDePerda==null && other.getIndiceDePerda()==null) || 
             (this.indiceDePerda!=null &&
              this.indiceDePerda.equals(other.getIndiceDePerda()))) &&
            ((this.omproduto==null && other.getOmproduto()==null) || 
             (this.omproduto!=null &&
              this.omproduto.equals(other.getOmproduto()))) &&
            ((this.quantidade==null && other.getQuantidade()==null) || 
             (this.quantidade!=null &&
              this.quantidade.equals(other.getQuantidade())));
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
        if (getCdsRaps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCdsRaps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCdsRaps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwRap() != null) {
            _hashCode += getDwRap().hashCode();
        }
        if (getDwTPerdamp() != null) {
            _hashCode += getDwTPerdamp().hashCode();
        }
        if (getIndiceDePerda() != null) {
            _hashCode += getIndiceDePerda().hashCode();
        }
        if (getOmproduto() != null) {
            _hashCode += getOmproduto().hashCode();
        }
        if (getQuantidade() != null) {
            _hashCode += getQuantidade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PerdasmpDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "perdasmpDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdsRaps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdsRaps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwRap");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwRap"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwRap"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTPerdamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTPerdamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTPerdamp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceDePerda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceDePerda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
