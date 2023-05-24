/**
 * PpCpTurno.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCpTurno  extends idw.idwws.PpCpTurnoTemplate  implements java.io.Serializable {
    private idw.idwws.DwCalavu dwCalavu;

    private idw.idwws.DwTurno dwTurno;

    private java.lang.Long idCpTurno;

    private java.lang.Double pcsProducaoprevista;

    private idw.idwws.PpCpData ppCpData;

    private idw.idwws.PpCpHora[] ppCpHoras;

    public PpCpTurno() {
    }

    public PpCpTurno(
           idw.idwws.DwCalavu dwCalavu,
           idw.idwws.DwTurno dwTurno,
           java.lang.Long idCpTurno,
           java.lang.Double pcsProducaoprevista,
           idw.idwws.PpCpData ppCpData,
           idw.idwws.PpCpHora[] ppCpHoras) {
        this.dwCalavu = dwCalavu;
        this.dwTurno = dwTurno;
        this.idCpTurno = idCpTurno;
        this.pcsProducaoprevista = pcsProducaoprevista;
        this.ppCpData = ppCpData;
        this.ppCpHoras = ppCpHoras;
    }


    /**
     * Gets the dwCalavu value for this PpCpTurno.
     * 
     * @return dwCalavu
     */
    public idw.idwws.DwCalavu getDwCalavu() {
        return dwCalavu;
    }


    /**
     * Sets the dwCalavu value for this PpCpTurno.
     * 
     * @param dwCalavu
     */
    public void setDwCalavu(idw.idwws.DwCalavu dwCalavu) {
        this.dwCalavu = dwCalavu;
    }


    /**
     * Gets the dwTurno value for this PpCpTurno.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this PpCpTurno.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the idCpTurno value for this PpCpTurno.
     * 
     * @return idCpTurno
     */
    public java.lang.Long getIdCpTurno() {
        return idCpTurno;
    }


    /**
     * Sets the idCpTurno value for this PpCpTurno.
     * 
     * @param idCpTurno
     */
    public void setIdCpTurno(java.lang.Long idCpTurno) {
        this.idCpTurno = idCpTurno;
    }


    /**
     * Gets the pcsProducaoprevista value for this PpCpTurno.
     * 
     * @return pcsProducaoprevista
     */
    public java.lang.Double getPcsProducaoprevista() {
        return pcsProducaoprevista;
    }


    /**
     * Sets the pcsProducaoprevista value for this PpCpTurno.
     * 
     * @param pcsProducaoprevista
     */
    public void setPcsProducaoprevista(java.lang.Double pcsProducaoprevista) {
        this.pcsProducaoprevista = pcsProducaoprevista;
    }


    /**
     * Gets the ppCpData value for this PpCpTurno.
     * 
     * @return ppCpData
     */
    public idw.idwws.PpCpData getPpCpData() {
        return ppCpData;
    }


    /**
     * Sets the ppCpData value for this PpCpTurno.
     * 
     * @param ppCpData
     */
    public void setPpCpData(idw.idwws.PpCpData ppCpData) {
        this.ppCpData = ppCpData;
    }


    /**
     * Gets the ppCpHoras value for this PpCpTurno.
     * 
     * @return ppCpHoras
     */
    public idw.idwws.PpCpHora[] getPpCpHoras() {
        return ppCpHoras;
    }


    /**
     * Sets the ppCpHoras value for this PpCpTurno.
     * 
     * @param ppCpHoras
     */
    public void setPpCpHoras(idw.idwws.PpCpHora[] ppCpHoras) {
        this.ppCpHoras = ppCpHoras;
    }

    public idw.idwws.PpCpHora getPpCpHoras(int i) {
        return this.ppCpHoras[i];
    }

    public void setPpCpHoras(int i, idw.idwws.PpCpHora _value) {
        this.ppCpHoras[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCpTurno)) return false;
        PpCpTurno other = (PpCpTurno) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwCalavu==null && other.getDwCalavu()==null) || 
             (this.dwCalavu!=null &&
              this.dwCalavu.equals(other.getDwCalavu()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            ((this.idCpTurno==null && other.getIdCpTurno()==null) || 
             (this.idCpTurno!=null &&
              this.idCpTurno.equals(other.getIdCpTurno()))) &&
            ((this.pcsProducaoprevista==null && other.getPcsProducaoprevista()==null) || 
             (this.pcsProducaoprevista!=null &&
              this.pcsProducaoprevista.equals(other.getPcsProducaoprevista()))) &&
            ((this.ppCpData==null && other.getPpCpData()==null) || 
             (this.ppCpData!=null &&
              this.ppCpData.equals(other.getPpCpData()))) &&
            ((this.ppCpHoras==null && other.getPpCpHoras()==null) || 
             (this.ppCpHoras!=null &&
              java.util.Arrays.equals(this.ppCpHoras, other.getPpCpHoras())));
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
        if (getDwCalavu() != null) {
            _hashCode += getDwCalavu().hashCode();
        }
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        if (getIdCpTurno() != null) {
            _hashCode += getIdCpTurno().hashCode();
        }
        if (getPcsProducaoprevista() != null) {
            _hashCode += getPcsProducaoprevista().hashCode();
        }
        if (getPpCpData() != null) {
            _hashCode += getPpCpData().hashCode();
        }
        if (getPpCpHoras() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCpHoras());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCpHoras(), i);
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
        new org.apache.axis.description.TypeDesc(PpCpTurno.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpTurno"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCalavu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalavu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalavu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCpTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCpTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsProducaoprevista");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsProducaoprevista"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpData");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCpHoras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpHoras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpHora"));
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
