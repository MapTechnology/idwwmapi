/**
 * PrConexoesInjet.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PrConexoesInjet  implements java.io.Serializable {
    private java.math.BigDecimal idconexaoinjet;

    private java.math.BigDecimal idregconexaoinjet;

    private idw.idwws.PrBridgeCollectorDatabase prBridgeCollectorDatabase;

    private idw.idwws.PrColetor[] prColetors;

    private idw.idwws.PrUp[] prUps;

    private int stAndonConfiguravel;

    private int stAndonProcessoft;

    private java.lang.Integer stProdutoUsuario;

    private double tmptimeoutcoletores;

    public PrConexoesInjet() {
    }

    public PrConexoesInjet(
           java.math.BigDecimal idconexaoinjet,
           java.math.BigDecimal idregconexaoinjet,
           idw.idwws.PrBridgeCollectorDatabase prBridgeCollectorDatabase,
           idw.idwws.PrColetor[] prColetors,
           idw.idwws.PrUp[] prUps,
           int stAndonConfiguravel,
           int stAndonProcessoft,
           java.lang.Integer stProdutoUsuario,
           double tmptimeoutcoletores) {
           this.idconexaoinjet = idconexaoinjet;
           this.idregconexaoinjet = idregconexaoinjet;
           this.prBridgeCollectorDatabase = prBridgeCollectorDatabase;
           this.prColetors = prColetors;
           this.prUps = prUps;
           this.stAndonConfiguravel = stAndonConfiguravel;
           this.stAndonProcessoft = stAndonProcessoft;
           this.stProdutoUsuario = stProdutoUsuario;
           this.tmptimeoutcoletores = tmptimeoutcoletores;
    }


    /**
     * Gets the idconexaoinjet value for this PrConexoesInjet.
     * 
     * @return idconexaoinjet
     */
    public java.math.BigDecimal getIdconexaoinjet() {
        return idconexaoinjet;
    }


    /**
     * Sets the idconexaoinjet value for this PrConexoesInjet.
     * 
     * @param idconexaoinjet
     */
    public void setIdconexaoinjet(java.math.BigDecimal idconexaoinjet) {
        this.idconexaoinjet = idconexaoinjet;
    }


    /**
     * Gets the idregconexaoinjet value for this PrConexoesInjet.
     * 
     * @return idregconexaoinjet
     */
    public java.math.BigDecimal getIdregconexaoinjet() {
        return idregconexaoinjet;
    }


    /**
     * Sets the idregconexaoinjet value for this PrConexoesInjet.
     * 
     * @param idregconexaoinjet
     */
    public void setIdregconexaoinjet(java.math.BigDecimal idregconexaoinjet) {
        this.idregconexaoinjet = idregconexaoinjet;
    }


    /**
     * Gets the prBridgeCollectorDatabase value for this PrConexoesInjet.
     * 
     * @return prBridgeCollectorDatabase
     */
    public idw.idwws.PrBridgeCollectorDatabase getPrBridgeCollectorDatabase() {
        return prBridgeCollectorDatabase;
    }


    /**
     * Sets the prBridgeCollectorDatabase value for this PrConexoesInjet.
     * 
     * @param prBridgeCollectorDatabase
     */
    public void setPrBridgeCollectorDatabase(idw.idwws.PrBridgeCollectorDatabase prBridgeCollectorDatabase) {
        this.prBridgeCollectorDatabase = prBridgeCollectorDatabase;
    }


    /**
     * Gets the prColetors value for this PrConexoesInjet.
     * 
     * @return prColetors
     */
    public idw.idwws.PrColetor[] getPrColetors() {
        return prColetors;
    }


    /**
     * Sets the prColetors value for this PrConexoesInjet.
     * 
     * @param prColetors
     */
    public void setPrColetors(idw.idwws.PrColetor[] prColetors) {
        this.prColetors = prColetors;
    }

    public idw.idwws.PrColetor getPrColetors(int i) {
        return this.prColetors[i];
    }

    public void setPrColetors(int i, idw.idwws.PrColetor _value) {
        this.prColetors[i] = _value;
    }


    /**
     * Gets the prUps value for this PrConexoesInjet.
     * 
     * @return prUps
     */
    public idw.idwws.PrUp[] getPrUps() {
        return prUps;
    }


    /**
     * Sets the prUps value for this PrConexoesInjet.
     * 
     * @param prUps
     */
    public void setPrUps(idw.idwws.PrUp[] prUps) {
        this.prUps = prUps;
    }

    public idw.idwws.PrUp getPrUps(int i) {
        return this.prUps[i];
    }

    public void setPrUps(int i, idw.idwws.PrUp _value) {
        this.prUps[i] = _value;
    }


    /**
     * Gets the stAndonConfiguravel value for this PrConexoesInjet.
     * 
     * @return stAndonConfiguravel
     */
    public int getStAndonConfiguravel() {
        return stAndonConfiguravel;
    }


    /**
     * Sets the stAndonConfiguravel value for this PrConexoesInjet.
     * 
     * @param stAndonConfiguravel
     */
    public void setStAndonConfiguravel(int stAndonConfiguravel) {
        this.stAndonConfiguravel = stAndonConfiguravel;
    }


    /**
     * Gets the stAndonProcessoft value for this PrConexoesInjet.
     * 
     * @return stAndonProcessoft
     */
    public int getStAndonProcessoft() {
        return stAndonProcessoft;
    }


    /**
     * Sets the stAndonProcessoft value for this PrConexoesInjet.
     * 
     * @param stAndonProcessoft
     */
    public void setStAndonProcessoft(int stAndonProcessoft) {
        this.stAndonProcessoft = stAndonProcessoft;
    }


    /**
     * Gets the stProdutoUsuario value for this PrConexoesInjet.
     * 
     * @return stProdutoUsuario
     */
    public java.lang.Integer getStProdutoUsuario() {
        return stProdutoUsuario;
    }


    /**
     * Sets the stProdutoUsuario value for this PrConexoesInjet.
     * 
     * @param stProdutoUsuario
     */
    public void setStProdutoUsuario(java.lang.Integer stProdutoUsuario) {
        this.stProdutoUsuario = stProdutoUsuario;
    }


    /**
     * Gets the tmptimeoutcoletores value for this PrConexoesInjet.
     * 
     * @return tmptimeoutcoletores
     */
    public double getTmptimeoutcoletores() {
        return tmptimeoutcoletores;
    }


    /**
     * Sets the tmptimeoutcoletores value for this PrConexoesInjet.
     * 
     * @param tmptimeoutcoletores
     */
    public void setTmptimeoutcoletores(double tmptimeoutcoletores) {
        this.tmptimeoutcoletores = tmptimeoutcoletores;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrConexoesInjet)) return false;
        PrConexoesInjet other = (PrConexoesInjet) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idconexaoinjet==null && other.getIdconexaoinjet()==null) || 
             (this.idconexaoinjet!=null &&
              this.idconexaoinjet.equals(other.getIdconexaoinjet()))) &&
            ((this.idregconexaoinjet==null && other.getIdregconexaoinjet()==null) || 
             (this.idregconexaoinjet!=null &&
              this.idregconexaoinjet.equals(other.getIdregconexaoinjet()))) &&
            ((this.prBridgeCollectorDatabase==null && other.getPrBridgeCollectorDatabase()==null) || 
             (this.prBridgeCollectorDatabase!=null &&
              this.prBridgeCollectorDatabase.equals(other.getPrBridgeCollectorDatabase()))) &&
            ((this.prColetors==null && other.getPrColetors()==null) || 
             (this.prColetors!=null &&
              java.util.Arrays.equals(this.prColetors, other.getPrColetors()))) &&
            ((this.prUps==null && other.getPrUps()==null) || 
             (this.prUps!=null &&
              java.util.Arrays.equals(this.prUps, other.getPrUps()))) &&
            this.stAndonConfiguravel == other.getStAndonConfiguravel() &&
            this.stAndonProcessoft == other.getStAndonProcessoft() &&
            ((this.stProdutoUsuario==null && other.getStProdutoUsuario()==null) || 
             (this.stProdutoUsuario!=null &&
              this.stProdutoUsuario.equals(other.getStProdutoUsuario()))) &&
            this.tmptimeoutcoletores == other.getTmptimeoutcoletores();
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
        if (getIdconexaoinjet() != null) {
            _hashCode += getIdconexaoinjet().hashCode();
        }
        if (getIdregconexaoinjet() != null) {
            _hashCode += getIdregconexaoinjet().hashCode();
        }
        if (getPrBridgeCollectorDatabase() != null) {
            _hashCode += getPrBridgeCollectorDatabase().hashCode();
        }
        if (getPrColetors() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrColetors());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrColetors(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrUps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrUps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrUps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getStAndonConfiguravel();
        _hashCode += getStAndonProcessoft();
        if (getStProdutoUsuario() != null) {
            _hashCode += getStProdutoUsuario().hashCode();
        }
        _hashCode += new Double(getTmptimeoutcoletores()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrConexoesInjet.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prConexoesInjet"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idconexaoinjet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idconexaoinjet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idregconexaoinjet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idregconexaoinjet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prBridgeCollectorDatabase");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prBridgeCollectorDatabase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prBridgeCollectorDatabase"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prColetors");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prColetors"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prColetor"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prUps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prUps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "prUp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAndonConfiguravel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAndonConfiguravel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stAndonProcessoft");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stAndonProcessoft"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stProdutoUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stProdutoUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmptimeoutcoletores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmptimeoutcoletores"));
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
