/**
 * DwProcativ.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwProcativ  extends idw.idwws.DwProcativTemplate  implements java.io.Serializable {
    private java.lang.String dsProcativ;

    private idw.idwws.DwDetativ[] dwDetativs;

    private idw.idwws.DwGrpativ dwGrpativ;

    private idw.idwws.DwProcedimento dwProcedimento;

    private idw.idwws.DwTArea dwTArea;

    private long idProcativ;

    private java.lang.Integer ordemGrupo;

    private java.lang.Integer ordemProcativ;

    private java.math.BigDecimal segTempopadrao;

    public DwProcativ() {
    }

    public DwProcativ(
           java.lang.String dsProcativ,
           idw.idwws.DwDetativ[] dwDetativs,
           idw.idwws.DwGrpativ dwGrpativ,
           idw.idwws.DwProcedimento dwProcedimento,
           idw.idwws.DwTArea dwTArea,
           long idProcativ,
           java.lang.Integer ordemGrupo,
           java.lang.Integer ordemProcativ,
           java.math.BigDecimal segTempopadrao) {
        this.dsProcativ = dsProcativ;
        this.dwDetativs = dwDetativs;
        this.dwGrpativ = dwGrpativ;
        this.dwProcedimento = dwProcedimento;
        this.dwTArea = dwTArea;
        this.idProcativ = idProcativ;
        this.ordemGrupo = ordemGrupo;
        this.ordemProcativ = ordemProcativ;
        this.segTempopadrao = segTempopadrao;
    }


    /**
     * Gets the dsProcativ value for this DwProcativ.
     * 
     * @return dsProcativ
     */
    public java.lang.String getDsProcativ() {
        return dsProcativ;
    }


    /**
     * Sets the dsProcativ value for this DwProcativ.
     * 
     * @param dsProcativ
     */
    public void setDsProcativ(java.lang.String dsProcativ) {
        this.dsProcativ = dsProcativ;
    }


    /**
     * Gets the dwDetativs value for this DwProcativ.
     * 
     * @return dwDetativs
     */
    public idw.idwws.DwDetativ[] getDwDetativs() {
        return dwDetativs;
    }


    /**
     * Sets the dwDetativs value for this DwProcativ.
     * 
     * @param dwDetativs
     */
    public void setDwDetativs(idw.idwws.DwDetativ[] dwDetativs) {
        this.dwDetativs = dwDetativs;
    }

    public idw.idwws.DwDetativ getDwDetativs(int i) {
        return this.dwDetativs[i];
    }

    public void setDwDetativs(int i, idw.idwws.DwDetativ _value) {
        this.dwDetativs[i] = _value;
    }


    /**
     * Gets the dwGrpativ value for this DwProcativ.
     * 
     * @return dwGrpativ
     */
    public idw.idwws.DwGrpativ getDwGrpativ() {
        return dwGrpativ;
    }


    /**
     * Sets the dwGrpativ value for this DwProcativ.
     * 
     * @param dwGrpativ
     */
    public void setDwGrpativ(idw.idwws.DwGrpativ dwGrpativ) {
        this.dwGrpativ = dwGrpativ;
    }


    /**
     * Gets the dwProcedimento value for this DwProcativ.
     * 
     * @return dwProcedimento
     */
    public idw.idwws.DwProcedimento getDwProcedimento() {
        return dwProcedimento;
    }


    /**
     * Sets the dwProcedimento value for this DwProcativ.
     * 
     * @param dwProcedimento
     */
    public void setDwProcedimento(idw.idwws.DwProcedimento dwProcedimento) {
        this.dwProcedimento = dwProcedimento;
    }


    /**
     * Gets the dwTArea value for this DwProcativ.
     * 
     * @return dwTArea
     */
    public idw.idwws.DwTArea getDwTArea() {
        return dwTArea;
    }


    /**
     * Sets the dwTArea value for this DwProcativ.
     * 
     * @param dwTArea
     */
    public void setDwTArea(idw.idwws.DwTArea dwTArea) {
        this.dwTArea = dwTArea;
    }


    /**
     * Gets the idProcativ value for this DwProcativ.
     * 
     * @return idProcativ
     */
    public long getIdProcativ() {
        return idProcativ;
    }


    /**
     * Sets the idProcativ value for this DwProcativ.
     * 
     * @param idProcativ
     */
    public void setIdProcativ(long idProcativ) {
        this.idProcativ = idProcativ;
    }


    /**
     * Gets the ordemGrupo value for this DwProcativ.
     * 
     * @return ordemGrupo
     */
    public java.lang.Integer getOrdemGrupo() {
        return ordemGrupo;
    }


    /**
     * Sets the ordemGrupo value for this DwProcativ.
     * 
     * @param ordemGrupo
     */
    public void setOrdemGrupo(java.lang.Integer ordemGrupo) {
        this.ordemGrupo = ordemGrupo;
    }


    /**
     * Gets the ordemProcativ value for this DwProcativ.
     * 
     * @return ordemProcativ
     */
    public java.lang.Integer getOrdemProcativ() {
        return ordemProcativ;
    }


    /**
     * Sets the ordemProcativ value for this DwProcativ.
     * 
     * @param ordemProcativ
     */
    public void setOrdemProcativ(java.lang.Integer ordemProcativ) {
        this.ordemProcativ = ordemProcativ;
    }


    /**
     * Gets the segTempopadrao value for this DwProcativ.
     * 
     * @return segTempopadrao
     */
    public java.math.BigDecimal getSegTempopadrao() {
        return segTempopadrao;
    }


    /**
     * Sets the segTempopadrao value for this DwProcativ.
     * 
     * @param segTempopadrao
     */
    public void setSegTempopadrao(java.math.BigDecimal segTempopadrao) {
        this.segTempopadrao = segTempopadrao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwProcativ)) return false;
        DwProcativ other = (DwProcativ) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dsProcativ==null && other.getDsProcativ()==null) || 
             (this.dsProcativ!=null &&
              this.dsProcativ.equals(other.getDsProcativ()))) &&
            ((this.dwDetativs==null && other.getDwDetativs()==null) || 
             (this.dwDetativs!=null &&
              java.util.Arrays.equals(this.dwDetativs, other.getDwDetativs()))) &&
            ((this.dwGrpativ==null && other.getDwGrpativ()==null) || 
             (this.dwGrpativ!=null &&
              this.dwGrpativ.equals(other.getDwGrpativ()))) &&
            ((this.dwProcedimento==null && other.getDwProcedimento()==null) || 
             (this.dwProcedimento!=null &&
              this.dwProcedimento.equals(other.getDwProcedimento()))) &&
            ((this.dwTArea==null && other.getDwTArea()==null) || 
             (this.dwTArea!=null &&
              this.dwTArea.equals(other.getDwTArea()))) &&
            this.idProcativ == other.getIdProcativ() &&
            ((this.ordemGrupo==null && other.getOrdemGrupo()==null) || 
             (this.ordemGrupo!=null &&
              this.ordemGrupo.equals(other.getOrdemGrupo()))) &&
            ((this.ordemProcativ==null && other.getOrdemProcativ()==null) || 
             (this.ordemProcativ!=null &&
              this.ordemProcativ.equals(other.getOrdemProcativ()))) &&
            ((this.segTempopadrao==null && other.getSegTempopadrao()==null) || 
             (this.segTempopadrao!=null &&
              this.segTempopadrao.equals(other.getSegTempopadrao())));
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
        if (getDsProcativ() != null) {
            _hashCode += getDsProcativ().hashCode();
        }
        if (getDwDetativs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwDetativs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwDetativs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDwGrpativ() != null) {
            _hashCode += getDwGrpativ().hashCode();
        }
        if (getDwProcedimento() != null) {
            _hashCode += getDwProcedimento().hashCode();
        }
        if (getDwTArea() != null) {
            _hashCode += getDwTArea().hashCode();
        }
        _hashCode += new Long(getIdProcativ()).hashCode();
        if (getOrdemGrupo() != null) {
            _hashCode += getOrdemGrupo().hashCode();
        }
        if (getOrdemProcativ() != null) {
            _hashCode += getOrdemProcativ().hashCode();
        }
        if (getSegTempopadrao() != null) {
            _hashCode += getSegTempopadrao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwProcativ.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcativ"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsProcativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsProcativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwDetativs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwDetativs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwDetativ"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwGrpativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwGrpativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwGrpativ"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProcedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProcedimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProcedimento"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTArea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTArea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTArea"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProcativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProcativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemGrupo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemGrupo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordemProcativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordemProcativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segTempopadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segTempopadrao"));
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
