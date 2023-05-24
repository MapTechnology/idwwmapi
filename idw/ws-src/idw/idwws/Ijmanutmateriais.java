/**
 * Ijmanutmateriais.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijmanutmateriais  implements java.io.Serializable {
    private java.lang.String dsmaterial;

    private idw.idwws.IjmanutmateriaisId id;

    private idw.idwws.Ijmanut ijmanut;

    private java.lang.String nmfornecec;

    private java.lang.String nrnota;

    private java.lang.String observacao;

    private double precototal;

    private double precounit;

    private double qtde;

    private java.lang.String unidmedida;

    public Ijmanutmateriais() {
    }

    public Ijmanutmateriais(
           java.lang.String dsmaterial,
           idw.idwws.IjmanutmateriaisId id,
           idw.idwws.Ijmanut ijmanut,
           java.lang.String nmfornecec,
           java.lang.String nrnota,
           java.lang.String observacao,
           double precototal,
           double precounit,
           double qtde,
           java.lang.String unidmedida) {
           this.dsmaterial = dsmaterial;
           this.id = id;
           this.ijmanut = ijmanut;
           this.nmfornecec = nmfornecec;
           this.nrnota = nrnota;
           this.observacao = observacao;
           this.precototal = precototal;
           this.precounit = precounit;
           this.qtde = qtde;
           this.unidmedida = unidmedida;
    }


    /**
     * Gets the dsmaterial value for this Ijmanutmateriais.
     * 
     * @return dsmaterial
     */
    public java.lang.String getDsmaterial() {
        return dsmaterial;
    }


    /**
     * Sets the dsmaterial value for this Ijmanutmateriais.
     * 
     * @param dsmaterial
     */
    public void setDsmaterial(java.lang.String dsmaterial) {
        this.dsmaterial = dsmaterial;
    }


    /**
     * Gets the id value for this Ijmanutmateriais.
     * 
     * @return id
     */
    public idw.idwws.IjmanutmateriaisId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijmanutmateriais.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjmanutmateriaisId id) {
        this.id = id;
    }


    /**
     * Gets the ijmanut value for this Ijmanutmateriais.
     * 
     * @return ijmanut
     */
    public idw.idwws.Ijmanut getIjmanut() {
        return ijmanut;
    }


    /**
     * Sets the ijmanut value for this Ijmanutmateriais.
     * 
     * @param ijmanut
     */
    public void setIjmanut(idw.idwws.Ijmanut ijmanut) {
        this.ijmanut = ijmanut;
    }


    /**
     * Gets the nmfornecec value for this Ijmanutmateriais.
     * 
     * @return nmfornecec
     */
    public java.lang.String getNmfornecec() {
        return nmfornecec;
    }


    /**
     * Sets the nmfornecec value for this Ijmanutmateriais.
     * 
     * @param nmfornecec
     */
    public void setNmfornecec(java.lang.String nmfornecec) {
        this.nmfornecec = nmfornecec;
    }


    /**
     * Gets the nrnota value for this Ijmanutmateriais.
     * 
     * @return nrnota
     */
    public java.lang.String getNrnota() {
        return nrnota;
    }


    /**
     * Sets the nrnota value for this Ijmanutmateriais.
     * 
     * @param nrnota
     */
    public void setNrnota(java.lang.String nrnota) {
        this.nrnota = nrnota;
    }


    /**
     * Gets the observacao value for this Ijmanutmateriais.
     * 
     * @return observacao
     */
    public java.lang.String getObservacao() {
        return observacao;
    }


    /**
     * Sets the observacao value for this Ijmanutmateriais.
     * 
     * @param observacao
     */
    public void setObservacao(java.lang.String observacao) {
        this.observacao = observacao;
    }


    /**
     * Gets the precototal value for this Ijmanutmateriais.
     * 
     * @return precototal
     */
    public double getPrecototal() {
        return precototal;
    }


    /**
     * Sets the precototal value for this Ijmanutmateriais.
     * 
     * @param precototal
     */
    public void setPrecototal(double precototal) {
        this.precototal = precototal;
    }


    /**
     * Gets the precounit value for this Ijmanutmateriais.
     * 
     * @return precounit
     */
    public double getPrecounit() {
        return precounit;
    }


    /**
     * Sets the precounit value for this Ijmanutmateriais.
     * 
     * @param precounit
     */
    public void setPrecounit(double precounit) {
        this.precounit = precounit;
    }


    /**
     * Gets the qtde value for this Ijmanutmateriais.
     * 
     * @return qtde
     */
    public double getQtde() {
        return qtde;
    }


    /**
     * Sets the qtde value for this Ijmanutmateriais.
     * 
     * @param qtde
     */
    public void setQtde(double qtde) {
        this.qtde = qtde;
    }


    /**
     * Gets the unidmedida value for this Ijmanutmateriais.
     * 
     * @return unidmedida
     */
    public java.lang.String getUnidmedida() {
        return unidmedida;
    }


    /**
     * Sets the unidmedida value for this Ijmanutmateriais.
     * 
     * @param unidmedida
     */
    public void setUnidmedida(java.lang.String unidmedida) {
        this.unidmedida = unidmedida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijmanutmateriais)) return false;
        Ijmanutmateriais other = (Ijmanutmateriais) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dsmaterial==null && other.getDsmaterial()==null) || 
             (this.dsmaterial!=null &&
              this.dsmaterial.equals(other.getDsmaterial()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijmanut==null && other.getIjmanut()==null) || 
             (this.ijmanut!=null &&
              this.ijmanut.equals(other.getIjmanut()))) &&
            ((this.nmfornecec==null && other.getNmfornecec()==null) || 
             (this.nmfornecec!=null &&
              this.nmfornecec.equals(other.getNmfornecec()))) &&
            ((this.nrnota==null && other.getNrnota()==null) || 
             (this.nrnota!=null &&
              this.nrnota.equals(other.getNrnota()))) &&
            ((this.observacao==null && other.getObservacao()==null) || 
             (this.observacao!=null &&
              this.observacao.equals(other.getObservacao()))) &&
            this.precototal == other.getPrecototal() &&
            this.precounit == other.getPrecounit() &&
            this.qtde == other.getQtde() &&
            ((this.unidmedida==null && other.getUnidmedida()==null) || 
             (this.unidmedida!=null &&
              this.unidmedida.equals(other.getUnidmedida())));
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
        if (getDsmaterial() != null) {
            _hashCode += getDsmaterial().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjmanut() != null) {
            _hashCode += getIjmanut().hashCode();
        }
        if (getNmfornecec() != null) {
            _hashCode += getNmfornecec().hashCode();
        }
        if (getNrnota() != null) {
            _hashCode += getNrnota().hashCode();
        }
        if (getObservacao() != null) {
            _hashCode += getObservacao().hashCode();
        }
        _hashCode += new Double(getPrecototal()).hashCode();
        _hashCode += new Double(getPrecounit()).hashCode();
        _hashCode += new Double(getQtde()).hashCode();
        if (getUnidmedida() != null) {
            _hashCode += getUnidmedida().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijmanutmateriais.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutmateriais"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsmaterial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsmaterial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanutmateriaisId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijmanut");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijmanut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijmanut"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmfornecec");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmfornecec"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrnota");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrnota"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("observacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "observacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precototal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "precototal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("precounit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "precounit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtde");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidmedida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unidmedida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
