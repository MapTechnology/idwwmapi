/**
 * Ijpropeso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijpropeso  implements java.io.Serializable {
    private idw.idwws.IjpropesoId id;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbpro ijtbpro;

    private double pesoideal;

    private double pesomax;

    private double pesomin;

    public Ijpropeso() {
    }

    public Ijpropeso(
           idw.idwws.IjpropesoId id,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbpro ijtbpro,
           double pesoideal,
           double pesomax,
           double pesomin) {
           this.id = id;
           this.ijtbinj = ijtbinj;
           this.ijtbpro = ijtbpro;
           this.pesoideal = pesoideal;
           this.pesomax = pesomax;
           this.pesomin = pesomin;
    }


    /**
     * Gets the id value for this Ijpropeso.
     * 
     * @return id
     */
    public idw.idwws.IjpropesoId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijpropeso.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjpropesoId id) {
        this.id = id;
    }


    /**
     * Gets the ijtbinj value for this Ijpropeso.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijpropeso.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbpro value for this Ijpropeso.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijpropeso.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the pesoideal value for this Ijpropeso.
     * 
     * @return pesoideal
     */
    public double getPesoideal() {
        return pesoideal;
    }


    /**
     * Sets the pesoideal value for this Ijpropeso.
     * 
     * @param pesoideal
     */
    public void setPesoideal(double pesoideal) {
        this.pesoideal = pesoideal;
    }


    /**
     * Gets the pesomax value for this Ijpropeso.
     * 
     * @return pesomax
     */
    public double getPesomax() {
        return pesomax;
    }


    /**
     * Sets the pesomax value for this Ijpropeso.
     * 
     * @param pesomax
     */
    public void setPesomax(double pesomax) {
        this.pesomax = pesomax;
    }


    /**
     * Gets the pesomin value for this Ijpropeso.
     * 
     * @return pesomin
     */
    public double getPesomin() {
        return pesomin;
    }


    /**
     * Sets the pesomin value for this Ijpropeso.
     * 
     * @param pesomin
     */
    public void setPesomin(double pesomin) {
        this.pesomin = pesomin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijpropeso)) return false;
        Ijpropeso other = (Ijpropeso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.pesoideal == other.getPesoideal() &&
            this.pesomax == other.getPesomax() &&
            this.pesomin == other.getPesomin();
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getPesoideal()).hashCode();
        _hashCode += new Double(getPesomax()).hashCode();
        _hashCode += new Double(getPesomin()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijpropeso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpropeso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpropesoId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesoideal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pesoideal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesomax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pesomax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pesomin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pesomin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
