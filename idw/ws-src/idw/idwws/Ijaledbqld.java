/**
 * Ijaledbqld.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijaledbqld  implements java.io.Serializable {
    private java.math.BigDecimal anotado;

    private java.util.Calendar dthrlimite;

    private double idregistro;

    private idw.idwws.Ijaledbqldanot[] ijaledbqldanots;

    private idw.idwws.Ijaledbqldinsp[] ijaledbqldinsps;

    private idw.idwws.Ijalertas ijalertas;

    private idw.idwws.Ijgrpparaminsp ijgrpparaminsp;

    private idw.idwws.Ijqldultinsp[] ijqldultinsps;

    private idw.idwws.Ijtbpro ijtbpro;

    private double tempolimite;

    public Ijaledbqld() {
    }

    public Ijaledbqld(
           java.math.BigDecimal anotado,
           java.util.Calendar dthrlimite,
           double idregistro,
           idw.idwws.Ijaledbqldanot[] ijaledbqldanots,
           idw.idwws.Ijaledbqldinsp[] ijaledbqldinsps,
           idw.idwws.Ijalertas ijalertas,
           idw.idwws.Ijgrpparaminsp ijgrpparaminsp,
           idw.idwws.Ijqldultinsp[] ijqldultinsps,
           idw.idwws.Ijtbpro ijtbpro,
           double tempolimite) {
           this.anotado = anotado;
           this.dthrlimite = dthrlimite;
           this.idregistro = idregistro;
           this.ijaledbqldanots = ijaledbqldanots;
           this.ijaledbqldinsps = ijaledbqldinsps;
           this.ijalertas = ijalertas;
           this.ijgrpparaminsp = ijgrpparaminsp;
           this.ijqldultinsps = ijqldultinsps;
           this.ijtbpro = ijtbpro;
           this.tempolimite = tempolimite;
    }


    /**
     * Gets the anotado value for this Ijaledbqld.
     * 
     * @return anotado
     */
    public java.math.BigDecimal getAnotado() {
        return anotado;
    }


    /**
     * Sets the anotado value for this Ijaledbqld.
     * 
     * @param anotado
     */
    public void setAnotado(java.math.BigDecimal anotado) {
        this.anotado = anotado;
    }


    /**
     * Gets the dthrlimite value for this Ijaledbqld.
     * 
     * @return dthrlimite
     */
    public java.util.Calendar getDthrlimite() {
        return dthrlimite;
    }


    /**
     * Sets the dthrlimite value for this Ijaledbqld.
     * 
     * @param dthrlimite
     */
    public void setDthrlimite(java.util.Calendar dthrlimite) {
        this.dthrlimite = dthrlimite;
    }


    /**
     * Gets the idregistro value for this Ijaledbqld.
     * 
     * @return idregistro
     */
    public double getIdregistro() {
        return idregistro;
    }


    /**
     * Sets the idregistro value for this Ijaledbqld.
     * 
     * @param idregistro
     */
    public void setIdregistro(double idregistro) {
        this.idregistro = idregistro;
    }


    /**
     * Gets the ijaledbqldanots value for this Ijaledbqld.
     * 
     * @return ijaledbqldanots
     */
    public idw.idwws.Ijaledbqldanot[] getIjaledbqldanots() {
        return ijaledbqldanots;
    }


    /**
     * Sets the ijaledbqldanots value for this Ijaledbqld.
     * 
     * @param ijaledbqldanots
     */
    public void setIjaledbqldanots(idw.idwws.Ijaledbqldanot[] ijaledbqldanots) {
        this.ijaledbqldanots = ijaledbqldanots;
    }

    public idw.idwws.Ijaledbqldanot getIjaledbqldanots(int i) {
        return this.ijaledbqldanots[i];
    }

    public void setIjaledbqldanots(int i, idw.idwws.Ijaledbqldanot _value) {
        this.ijaledbqldanots[i] = _value;
    }


    /**
     * Gets the ijaledbqldinsps value for this Ijaledbqld.
     * 
     * @return ijaledbqldinsps
     */
    public idw.idwws.Ijaledbqldinsp[] getIjaledbqldinsps() {
        return ijaledbqldinsps;
    }


    /**
     * Sets the ijaledbqldinsps value for this Ijaledbqld.
     * 
     * @param ijaledbqldinsps
     */
    public void setIjaledbqldinsps(idw.idwws.Ijaledbqldinsp[] ijaledbqldinsps) {
        this.ijaledbqldinsps = ijaledbqldinsps;
    }

    public idw.idwws.Ijaledbqldinsp getIjaledbqldinsps(int i) {
        return this.ijaledbqldinsps[i];
    }

    public void setIjaledbqldinsps(int i, idw.idwws.Ijaledbqldinsp _value) {
        this.ijaledbqldinsps[i] = _value;
    }


    /**
     * Gets the ijalertas value for this Ijaledbqld.
     * 
     * @return ijalertas
     */
    public idw.idwws.Ijalertas getIjalertas() {
        return ijalertas;
    }


    /**
     * Sets the ijalertas value for this Ijaledbqld.
     * 
     * @param ijalertas
     */
    public void setIjalertas(idw.idwws.Ijalertas ijalertas) {
        this.ijalertas = ijalertas;
    }


    /**
     * Gets the ijgrpparaminsp value for this Ijaledbqld.
     * 
     * @return ijgrpparaminsp
     */
    public idw.idwws.Ijgrpparaminsp getIjgrpparaminsp() {
        return ijgrpparaminsp;
    }


    /**
     * Sets the ijgrpparaminsp value for this Ijaledbqld.
     * 
     * @param ijgrpparaminsp
     */
    public void setIjgrpparaminsp(idw.idwws.Ijgrpparaminsp ijgrpparaminsp) {
        this.ijgrpparaminsp = ijgrpparaminsp;
    }


    /**
     * Gets the ijqldultinsps value for this Ijaledbqld.
     * 
     * @return ijqldultinsps
     */
    public idw.idwws.Ijqldultinsp[] getIjqldultinsps() {
        return ijqldultinsps;
    }


    /**
     * Sets the ijqldultinsps value for this Ijaledbqld.
     * 
     * @param ijqldultinsps
     */
    public void setIjqldultinsps(idw.idwws.Ijqldultinsp[] ijqldultinsps) {
        this.ijqldultinsps = ijqldultinsps;
    }

    public idw.idwws.Ijqldultinsp getIjqldultinsps(int i) {
        return this.ijqldultinsps[i];
    }

    public void setIjqldultinsps(int i, idw.idwws.Ijqldultinsp _value) {
        this.ijqldultinsps[i] = _value;
    }


    /**
     * Gets the ijtbpro value for this Ijaledbqld.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijaledbqld.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the tempolimite value for this Ijaledbqld.
     * 
     * @return tempolimite
     */
    public double getTempolimite() {
        return tempolimite;
    }


    /**
     * Sets the tempolimite value for this Ijaledbqld.
     * 
     * @param tempolimite
     */
    public void setTempolimite(double tempolimite) {
        this.tempolimite = tempolimite;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijaledbqld)) return false;
        Ijaledbqld other = (Ijaledbqld) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anotado==null && other.getAnotado()==null) || 
             (this.anotado!=null &&
              this.anotado.equals(other.getAnotado()))) &&
            ((this.dthrlimite==null && other.getDthrlimite()==null) || 
             (this.dthrlimite!=null &&
              this.dthrlimite.equals(other.getDthrlimite()))) &&
            this.idregistro == other.getIdregistro() &&
            ((this.ijaledbqldanots==null && other.getIjaledbqldanots()==null) || 
             (this.ijaledbqldanots!=null &&
              java.util.Arrays.equals(this.ijaledbqldanots, other.getIjaledbqldanots()))) &&
            ((this.ijaledbqldinsps==null && other.getIjaledbqldinsps()==null) || 
             (this.ijaledbqldinsps!=null &&
              java.util.Arrays.equals(this.ijaledbqldinsps, other.getIjaledbqldinsps()))) &&
            ((this.ijalertas==null && other.getIjalertas()==null) || 
             (this.ijalertas!=null &&
              this.ijalertas.equals(other.getIjalertas()))) &&
            ((this.ijgrpparaminsp==null && other.getIjgrpparaminsp()==null) || 
             (this.ijgrpparaminsp!=null &&
              this.ijgrpparaminsp.equals(other.getIjgrpparaminsp()))) &&
            ((this.ijqldultinsps==null && other.getIjqldultinsps()==null) || 
             (this.ijqldultinsps!=null &&
              java.util.Arrays.equals(this.ijqldultinsps, other.getIjqldultinsps()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            this.tempolimite == other.getTempolimite();
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
        if (getAnotado() != null) {
            _hashCode += getAnotado().hashCode();
        }
        if (getDthrlimite() != null) {
            _hashCode += getDthrlimite().hashCode();
        }
        _hashCode += new Double(getIdregistro()).hashCode();
        if (getIjaledbqldanots() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjaledbqldanots());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjaledbqldanots(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjaledbqldinsps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjaledbqldinsps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjaledbqldinsps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjalertas() != null) {
            _hashCode += getIjalertas().hashCode();
        }
        if (getIjgrpparaminsp() != null) {
            _hashCode += getIjgrpparaminsp().hashCode();
        }
        if (getIjqldultinsps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjqldultinsps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjqldultinsps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        _hashCode += new Double(getTempolimite()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijaledbqld.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqld"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anotado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anotado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrlimite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrlimite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregistro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregistro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijaledbqldanots");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijaledbqldanots"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqldanot"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijaledbqldinsps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijaledbqldinsps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqldinsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijalertas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijalertas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalertas"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpparaminsp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpparaminsp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpparaminsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijqldultinsps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijqldultinsps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijqldultinsp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempolimite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempolimite"));
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
