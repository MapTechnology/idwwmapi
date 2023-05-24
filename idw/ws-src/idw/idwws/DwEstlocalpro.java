/**
 * DwEstlocalpro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwEstlocalpro  extends idw.idwws.DwEstlocalproTemplate  implements java.io.Serializable {
    private idw.idwws.DwEstlocal dwEstlocal;

    private idw.idwws.DwEstpro dwEstpro;

    private long idEstlocalpro;

    private idw.idwws.PpCp ppCp;

    private java.math.BigDecimal qtAjuste;

    private java.math.BigDecimal qtEntrada;

    private java.math.BigDecimal qtSaida;

    private java.math.BigDecimal qtTotal;

    public DwEstlocalpro() {
    }

    public DwEstlocalpro(
           idw.idwws.DwEstlocal dwEstlocal,
           idw.idwws.DwEstpro dwEstpro,
           long idEstlocalpro,
           idw.idwws.PpCp ppCp,
           java.math.BigDecimal qtAjuste,
           java.math.BigDecimal qtEntrada,
           java.math.BigDecimal qtSaida,
           java.math.BigDecimal qtTotal) {
        this.dwEstlocal = dwEstlocal;
        this.dwEstpro = dwEstpro;
        this.idEstlocalpro = idEstlocalpro;
        this.ppCp = ppCp;
        this.qtAjuste = qtAjuste;
        this.qtEntrada = qtEntrada;
        this.qtSaida = qtSaida;
        this.qtTotal = qtTotal;
    }


    /**
     * Gets the dwEstlocal value for this DwEstlocalpro.
     * 
     * @return dwEstlocal
     */
    public idw.idwws.DwEstlocal getDwEstlocal() {
        return dwEstlocal;
    }


    /**
     * Sets the dwEstlocal value for this DwEstlocalpro.
     * 
     * @param dwEstlocal
     */
    public void setDwEstlocal(idw.idwws.DwEstlocal dwEstlocal) {
        this.dwEstlocal = dwEstlocal;
    }


    /**
     * Gets the dwEstpro value for this DwEstlocalpro.
     * 
     * @return dwEstpro
     */
    public idw.idwws.DwEstpro getDwEstpro() {
        return dwEstpro;
    }


    /**
     * Sets the dwEstpro value for this DwEstlocalpro.
     * 
     * @param dwEstpro
     */
    public void setDwEstpro(idw.idwws.DwEstpro dwEstpro) {
        this.dwEstpro = dwEstpro;
    }


    /**
     * Gets the idEstlocalpro value for this DwEstlocalpro.
     * 
     * @return idEstlocalpro
     */
    public long getIdEstlocalpro() {
        return idEstlocalpro;
    }


    /**
     * Sets the idEstlocalpro value for this DwEstlocalpro.
     * 
     * @param idEstlocalpro
     */
    public void setIdEstlocalpro(long idEstlocalpro) {
        this.idEstlocalpro = idEstlocalpro;
    }


    /**
     * Gets the ppCp value for this DwEstlocalpro.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this DwEstlocalpro.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }


    /**
     * Gets the qtAjuste value for this DwEstlocalpro.
     * 
     * @return qtAjuste
     */
    public java.math.BigDecimal getQtAjuste() {
        return qtAjuste;
    }


    /**
     * Sets the qtAjuste value for this DwEstlocalpro.
     * 
     * @param qtAjuste
     */
    public void setQtAjuste(java.math.BigDecimal qtAjuste) {
        this.qtAjuste = qtAjuste;
    }


    /**
     * Gets the qtEntrada value for this DwEstlocalpro.
     * 
     * @return qtEntrada
     */
    public java.math.BigDecimal getQtEntrada() {
        return qtEntrada;
    }


    /**
     * Sets the qtEntrada value for this DwEstlocalpro.
     * 
     * @param qtEntrada
     */
    public void setQtEntrada(java.math.BigDecimal qtEntrada) {
        this.qtEntrada = qtEntrada;
    }


    /**
     * Gets the qtSaida value for this DwEstlocalpro.
     * 
     * @return qtSaida
     */
    public java.math.BigDecimal getQtSaida() {
        return qtSaida;
    }


    /**
     * Sets the qtSaida value for this DwEstlocalpro.
     * 
     * @param qtSaida
     */
    public void setQtSaida(java.math.BigDecimal qtSaida) {
        this.qtSaida = qtSaida;
    }


    /**
     * Gets the qtTotal value for this DwEstlocalpro.
     * 
     * @return qtTotal
     */
    public java.math.BigDecimal getQtTotal() {
        return qtTotal;
    }


    /**
     * Sets the qtTotal value for this DwEstlocalpro.
     * 
     * @param qtTotal
     */
    public void setQtTotal(java.math.BigDecimal qtTotal) {
        this.qtTotal = qtTotal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwEstlocalpro)) return false;
        DwEstlocalpro other = (DwEstlocalpro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dwEstlocal==null && other.getDwEstlocal()==null) || 
             (this.dwEstlocal!=null &&
              this.dwEstlocal.equals(other.getDwEstlocal()))) &&
            ((this.dwEstpro==null && other.getDwEstpro()==null) || 
             (this.dwEstpro!=null &&
              this.dwEstpro.equals(other.getDwEstpro()))) &&
            this.idEstlocalpro == other.getIdEstlocalpro() &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp()))) &&
            ((this.qtAjuste==null && other.getQtAjuste()==null) || 
             (this.qtAjuste!=null &&
              this.qtAjuste.equals(other.getQtAjuste()))) &&
            ((this.qtEntrada==null && other.getQtEntrada()==null) || 
             (this.qtEntrada!=null &&
              this.qtEntrada.equals(other.getQtEntrada()))) &&
            ((this.qtSaida==null && other.getQtSaida()==null) || 
             (this.qtSaida!=null &&
              this.qtSaida.equals(other.getQtSaida()))) &&
            ((this.qtTotal==null && other.getQtTotal()==null) || 
             (this.qtTotal!=null &&
              this.qtTotal.equals(other.getQtTotal())));
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
        if (getDwEstlocal() != null) {
            _hashCode += getDwEstlocal().hashCode();
        }
        if (getDwEstpro() != null) {
            _hashCode += getDwEstpro().hashCode();
        }
        _hashCode += new Long(getIdEstlocalpro()).hashCode();
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        if (getQtAjuste() != null) {
            _hashCode += getQtAjuste().hashCode();
        }
        if (getQtEntrada() != null) {
            _hashCode += getQtEntrada().hashCode();
        }
        if (getQtSaida() != null) {
            _hashCode += getQtSaida().hashCode();
        }
        if (getQtTotal() != null) {
            _hashCode += getQtTotal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwEstlocalpro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstlocalpro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstlocal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstlocal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstlocal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwEstpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwEstpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwEstpro"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEstlocalpro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEstlocalpro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtAjuste");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtAjuste"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtEntrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtEntrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtSaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtSaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtTotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtTotal"));
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
