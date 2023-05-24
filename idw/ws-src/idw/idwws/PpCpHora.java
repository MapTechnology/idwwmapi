/**
 * PpCpHora.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCpHora  implements java.io.Serializable {
    private idw.idwws.DwCalavu dwCalavu;

    private idw.idwws.DwCalsem dwCalsem;

    private java.lang.Long idCphora;

    private java.lang.Double pcsProducaoprevista;

    private idw.idwws.PpCpTurno ppCpTurno;

    public PpCpHora() {
    }

    public PpCpHora(
           idw.idwws.DwCalavu dwCalavu,
           idw.idwws.DwCalsem dwCalsem,
           java.lang.Long idCphora,
           java.lang.Double pcsProducaoprevista,
           idw.idwws.PpCpTurno ppCpTurno) {
           this.dwCalavu = dwCalavu;
           this.dwCalsem = dwCalsem;
           this.idCphora = idCphora;
           this.pcsProducaoprevista = pcsProducaoprevista;
           this.ppCpTurno = ppCpTurno;
    }


    /**
     * Gets the dwCalavu value for this PpCpHora.
     * 
     * @return dwCalavu
     */
    public idw.idwws.DwCalavu getDwCalavu() {
        return dwCalavu;
    }


    /**
     * Sets the dwCalavu value for this PpCpHora.
     * 
     * @param dwCalavu
     */
    public void setDwCalavu(idw.idwws.DwCalavu dwCalavu) {
        this.dwCalavu = dwCalavu;
    }


    /**
     * Gets the dwCalsem value for this PpCpHora.
     * 
     * @return dwCalsem
     */
    public idw.idwws.DwCalsem getDwCalsem() {
        return dwCalsem;
    }


    /**
     * Sets the dwCalsem value for this PpCpHora.
     * 
     * @param dwCalsem
     */
    public void setDwCalsem(idw.idwws.DwCalsem dwCalsem) {
        this.dwCalsem = dwCalsem;
    }


    /**
     * Gets the idCphora value for this PpCpHora.
     * 
     * @return idCphora
     */
    public java.lang.Long getIdCphora() {
        return idCphora;
    }


    /**
     * Sets the idCphora value for this PpCpHora.
     * 
     * @param idCphora
     */
    public void setIdCphora(java.lang.Long idCphora) {
        this.idCphora = idCphora;
    }


    /**
     * Gets the pcsProducaoprevista value for this PpCpHora.
     * 
     * @return pcsProducaoprevista
     */
    public java.lang.Double getPcsProducaoprevista() {
        return pcsProducaoprevista;
    }


    /**
     * Sets the pcsProducaoprevista value for this PpCpHora.
     * 
     * @param pcsProducaoprevista
     */
    public void setPcsProducaoprevista(java.lang.Double pcsProducaoprevista) {
        this.pcsProducaoprevista = pcsProducaoprevista;
    }


    /**
     * Gets the ppCpTurno value for this PpCpHora.
     * 
     * @return ppCpTurno
     */
    public idw.idwws.PpCpTurno getPpCpTurno() {
        return ppCpTurno;
    }


    /**
     * Sets the ppCpTurno value for this PpCpHora.
     * 
     * @param ppCpTurno
     */
    public void setPpCpTurno(idw.idwws.PpCpTurno ppCpTurno) {
        this.ppCpTurno = ppCpTurno;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCpHora)) return false;
        PpCpHora other = (PpCpHora) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwCalavu==null && other.getDwCalavu()==null) || 
             (this.dwCalavu!=null &&
              this.dwCalavu.equals(other.getDwCalavu()))) &&
            ((this.dwCalsem==null && other.getDwCalsem()==null) || 
             (this.dwCalsem!=null &&
              this.dwCalsem.equals(other.getDwCalsem()))) &&
            ((this.idCphora==null && other.getIdCphora()==null) || 
             (this.idCphora!=null &&
              this.idCphora.equals(other.getIdCphora()))) &&
            ((this.pcsProducaoprevista==null && other.getPcsProducaoprevista()==null) || 
             (this.pcsProducaoprevista!=null &&
              this.pcsProducaoprevista.equals(other.getPcsProducaoprevista()))) &&
            ((this.ppCpTurno==null && other.getPpCpTurno()==null) || 
             (this.ppCpTurno!=null &&
              this.ppCpTurno.equals(other.getPpCpTurno())));
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
        if (getDwCalavu() != null) {
            _hashCode += getDwCalavu().hashCode();
        }
        if (getDwCalsem() != null) {
            _hashCode += getDwCalsem().hashCode();
        }
        if (getIdCphora() != null) {
            _hashCode += getIdCphora().hashCode();
        }
        if (getPcsProducaoprevista() != null) {
            _hashCode += getPcsProducaoprevista().hashCode();
        }
        if (getPpCpTurno() != null) {
            _hashCode += getPpCpTurno().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PpCpHora.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpHora"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCalavu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalavu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalavu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCalsem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalsem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalsem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCphora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCphora"));
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
        elemField.setFieldName("ppCpTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpTurno"));
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
