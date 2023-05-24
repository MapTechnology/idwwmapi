/**
 * PpCpproduto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class PpCpproduto  extends idw.idwws.PpCpprodutoTemplate  implements java.io.Serializable {
    private java.lang.Long idCpproduto;

    private java.lang.String nrDoc;

    private idw.idwws.OmProduto omProduto;

    private java.lang.Double pcsProducaobruta;

    private java.lang.Double pcsProducaoplanejada;

    private idw.idwws.PpCp ppCp;

    private idw.idwws.PpCpData[] ppCpDatas;

    public PpCpproduto() {
    }

    public PpCpproduto(
           java.lang.Long idCpproduto,
           java.lang.String nrDoc,
           idw.idwws.OmProduto omProduto,
           java.lang.Double pcsProducaobruta,
           java.lang.Double pcsProducaoplanejada,
           idw.idwws.PpCp ppCp,
           idw.idwws.PpCpData[] ppCpDatas) {
        this.idCpproduto = idCpproduto;
        this.nrDoc = nrDoc;
        this.omProduto = omProduto;
        this.pcsProducaobruta = pcsProducaobruta;
        this.pcsProducaoplanejada = pcsProducaoplanejada;
        this.ppCp = ppCp;
        this.ppCpDatas = ppCpDatas;
    }


    /**
     * Gets the idCpproduto value for this PpCpproduto.
     * 
     * @return idCpproduto
     */
    public java.lang.Long getIdCpproduto() {
        return idCpproduto;
    }


    /**
     * Sets the idCpproduto value for this PpCpproduto.
     * 
     * @param idCpproduto
     */
    public void setIdCpproduto(java.lang.Long idCpproduto) {
        this.idCpproduto = idCpproduto;
    }


    /**
     * Gets the nrDoc value for this PpCpproduto.
     * 
     * @return nrDoc
     */
    public java.lang.String getNrDoc() {
        return nrDoc;
    }


    /**
     * Sets the nrDoc value for this PpCpproduto.
     * 
     * @param nrDoc
     */
    public void setNrDoc(java.lang.String nrDoc) {
        this.nrDoc = nrDoc;
    }


    /**
     * Gets the omProduto value for this PpCpproduto.
     * 
     * @return omProduto
     */
    public idw.idwws.OmProduto getOmProduto() {
        return omProduto;
    }


    /**
     * Sets the omProduto value for this PpCpproduto.
     * 
     * @param omProduto
     */
    public void setOmProduto(idw.idwws.OmProduto omProduto) {
        this.omProduto = omProduto;
    }


    /**
     * Gets the pcsProducaobruta value for this PpCpproduto.
     * 
     * @return pcsProducaobruta
     */
    public java.lang.Double getPcsProducaobruta() {
        return pcsProducaobruta;
    }


    /**
     * Sets the pcsProducaobruta value for this PpCpproduto.
     * 
     * @param pcsProducaobruta
     */
    public void setPcsProducaobruta(java.lang.Double pcsProducaobruta) {
        this.pcsProducaobruta = pcsProducaobruta;
    }


    /**
     * Gets the pcsProducaoplanejada value for this PpCpproduto.
     * 
     * @return pcsProducaoplanejada
     */
    public java.lang.Double getPcsProducaoplanejada() {
        return pcsProducaoplanejada;
    }


    /**
     * Sets the pcsProducaoplanejada value for this PpCpproduto.
     * 
     * @param pcsProducaoplanejada
     */
    public void setPcsProducaoplanejada(java.lang.Double pcsProducaoplanejada) {
        this.pcsProducaoplanejada = pcsProducaoplanejada;
    }


    /**
     * Gets the ppCp value for this PpCpproduto.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this PpCpproduto.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }


    /**
     * Gets the ppCpDatas value for this PpCpproduto.
     * 
     * @return ppCpDatas
     */
    public idw.idwws.PpCpData[] getPpCpDatas() {
        return ppCpDatas;
    }


    /**
     * Sets the ppCpDatas value for this PpCpproduto.
     * 
     * @param ppCpDatas
     */
    public void setPpCpDatas(idw.idwws.PpCpData[] ppCpDatas) {
        this.ppCpDatas = ppCpDatas;
    }

    public idw.idwws.PpCpData getPpCpDatas(int i) {
        return this.ppCpDatas[i];
    }

    public void setPpCpDatas(int i, idw.idwws.PpCpData _value) {
        this.ppCpDatas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PpCpproduto)) return false;
        PpCpproduto other = (PpCpproduto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.idCpproduto==null && other.getIdCpproduto()==null) || 
             (this.idCpproduto!=null &&
              this.idCpproduto.equals(other.getIdCpproduto()))) &&
            ((this.nrDoc==null && other.getNrDoc()==null) || 
             (this.nrDoc!=null &&
              this.nrDoc.equals(other.getNrDoc()))) &&
            ((this.omProduto==null && other.getOmProduto()==null) || 
             (this.omProduto!=null &&
              this.omProduto.equals(other.getOmProduto()))) &&
            ((this.pcsProducaobruta==null && other.getPcsProducaobruta()==null) || 
             (this.pcsProducaobruta!=null &&
              this.pcsProducaobruta.equals(other.getPcsProducaobruta()))) &&
            ((this.pcsProducaoplanejada==null && other.getPcsProducaoplanejada()==null) || 
             (this.pcsProducaoplanejada!=null &&
              this.pcsProducaoplanejada.equals(other.getPcsProducaoplanejada()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp()))) &&
            ((this.ppCpDatas==null && other.getPpCpDatas()==null) || 
             (this.ppCpDatas!=null &&
              java.util.Arrays.equals(this.ppCpDatas, other.getPpCpDatas())));
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
        if (getIdCpproduto() != null) {
            _hashCode += getIdCpproduto().hashCode();
        }
        if (getNrDoc() != null) {
            _hashCode += getNrDoc().hashCode();
        }
        if (getOmProduto() != null) {
            _hashCode += getOmProduto().hashCode();
        }
        if (getPcsProducaobruta() != null) {
            _hashCode += getPcsProducaobruta().hashCode();
        }
        if (getPcsProducaoplanejada() != null) {
            _hashCode += getPcsProducaoplanejada().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        if (getPpCpDatas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPpCpDatas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPpCpDatas(), i);
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
        new org.apache.axis.description.TypeDesc(PpCpproduto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpproduto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCpproduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCpproduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrDoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrDoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omProduto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omProduto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omProduto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsProducaobruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsProducaobruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pcsProducaoplanejada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pcsProducaoplanejada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("ppCpDatas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCpDatas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCpData"));
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
