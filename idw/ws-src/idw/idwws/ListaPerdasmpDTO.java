/**
 * ListaPerdasmpDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class ListaPerdasmpDTO  implements java.io.Serializable {
    private java.lang.String indicePerdasMP;

    private java.lang.String indicePerdasRAP;

    private idw.idwws.PerdasmpDTO[] perdasmpDTOs;

    private idw.idwws.PerdasmpDTO[] perdasmpRapDTOs;

    public ListaPerdasmpDTO() {
    }

    public ListaPerdasmpDTO(
           java.lang.String indicePerdasMP,
           java.lang.String indicePerdasRAP,
           idw.idwws.PerdasmpDTO[] perdasmpDTOs,
           idw.idwws.PerdasmpDTO[] perdasmpRapDTOs) {
           this.indicePerdasMP = indicePerdasMP;
           this.indicePerdasRAP = indicePerdasRAP;
           this.perdasmpDTOs = perdasmpDTOs;
           this.perdasmpRapDTOs = perdasmpRapDTOs;
    }


    /**
     * Gets the indicePerdasMP value for this ListaPerdasmpDTO.
     * 
     * @return indicePerdasMP
     */
    public java.lang.String getIndicePerdasMP() {
        return indicePerdasMP;
    }


    /**
     * Sets the indicePerdasMP value for this ListaPerdasmpDTO.
     * 
     * @param indicePerdasMP
     */
    public void setIndicePerdasMP(java.lang.String indicePerdasMP) {
        this.indicePerdasMP = indicePerdasMP;
    }


    /**
     * Gets the indicePerdasRAP value for this ListaPerdasmpDTO.
     * 
     * @return indicePerdasRAP
     */
    public java.lang.String getIndicePerdasRAP() {
        return indicePerdasRAP;
    }


    /**
     * Sets the indicePerdasRAP value for this ListaPerdasmpDTO.
     * 
     * @param indicePerdasRAP
     */
    public void setIndicePerdasRAP(java.lang.String indicePerdasRAP) {
        this.indicePerdasRAP = indicePerdasRAP;
    }


    /**
     * Gets the perdasmpDTOs value for this ListaPerdasmpDTO.
     * 
     * @return perdasmpDTOs
     */
    public idw.idwws.PerdasmpDTO[] getPerdasmpDTOs() {
        return perdasmpDTOs;
    }


    /**
     * Sets the perdasmpDTOs value for this ListaPerdasmpDTO.
     * 
     * @param perdasmpDTOs
     */
    public void setPerdasmpDTOs(idw.idwws.PerdasmpDTO[] perdasmpDTOs) {
        this.perdasmpDTOs = perdasmpDTOs;
    }

    public idw.idwws.PerdasmpDTO getPerdasmpDTOs(int i) {
        return this.perdasmpDTOs[i];
    }

    public void setPerdasmpDTOs(int i, idw.idwws.PerdasmpDTO _value) {
        this.perdasmpDTOs[i] = _value;
    }


    /**
     * Gets the perdasmpRapDTOs value for this ListaPerdasmpDTO.
     * 
     * @return perdasmpRapDTOs
     */
    public idw.idwws.PerdasmpDTO[] getPerdasmpRapDTOs() {
        return perdasmpRapDTOs;
    }


    /**
     * Sets the perdasmpRapDTOs value for this ListaPerdasmpDTO.
     * 
     * @param perdasmpRapDTOs
     */
    public void setPerdasmpRapDTOs(idw.idwws.PerdasmpDTO[] perdasmpRapDTOs) {
        this.perdasmpRapDTOs = perdasmpRapDTOs;
    }

    public idw.idwws.PerdasmpDTO getPerdasmpRapDTOs(int i) {
        return this.perdasmpRapDTOs[i];
    }

    public void setPerdasmpRapDTOs(int i, idw.idwws.PerdasmpDTO _value) {
        this.perdasmpRapDTOs[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaPerdasmpDTO)) return false;
        ListaPerdasmpDTO other = (ListaPerdasmpDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.indicePerdasMP==null && other.getIndicePerdasMP()==null) || 
             (this.indicePerdasMP!=null &&
              this.indicePerdasMP.equals(other.getIndicePerdasMP()))) &&
            ((this.indicePerdasRAP==null && other.getIndicePerdasRAP()==null) || 
             (this.indicePerdasRAP!=null &&
              this.indicePerdasRAP.equals(other.getIndicePerdasRAP()))) &&
            ((this.perdasmpDTOs==null && other.getPerdasmpDTOs()==null) || 
             (this.perdasmpDTOs!=null &&
              java.util.Arrays.equals(this.perdasmpDTOs, other.getPerdasmpDTOs()))) &&
            ((this.perdasmpRapDTOs==null && other.getPerdasmpRapDTOs()==null) || 
             (this.perdasmpRapDTOs!=null &&
              java.util.Arrays.equals(this.perdasmpRapDTOs, other.getPerdasmpRapDTOs())));
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
        if (getIndicePerdasMP() != null) {
            _hashCode += getIndicePerdasMP().hashCode();
        }
        if (getIndicePerdasRAP() != null) {
            _hashCode += getIndicePerdasRAP().hashCode();
        }
        if (getPerdasmpDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPerdasmpDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPerdasmpDTOs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPerdasmpRapDTOs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPerdasmpRapDTOs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPerdasmpRapDTOs(), i);
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
        new org.apache.axis.description.TypeDesc(ListaPerdasmpDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "listaPerdasmpDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicePerdasMP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicePerdasMP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indicePerdasRAP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indicePerdasRAP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdasmpDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdasmpDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "perdasmpDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdasmpRapDTOs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdasmpRapDTOs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "perdasmpDTO"));
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
