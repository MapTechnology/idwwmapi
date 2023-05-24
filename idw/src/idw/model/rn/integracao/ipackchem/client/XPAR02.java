/**
 * XPAR02.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.model.rn.integracao.ipackchem.client;

public class XPAR02  implements java.io.Serializable {
    private java.util.Date XDATA_PRODUCAO;

    private java.lang.String XNUMERO_OP;

    private idw.model.rn.integracao.ipackchem.client.XPAR02LST[] XPAR02LSTS;

    private float XQUANTIDADE;

    private float XQUANTIDADE_REFUGO;

    public XPAR02() {
    }

    public XPAR02(
           java.util.Date XDATA_PRODUCAO,
           java.lang.String XNUMERO_OP,
           idw.model.rn.integracao.ipackchem.client.XPAR02LST[] XPAR02LSTS,
           float XQUANTIDADE,
           float XQUANTIDADE_REFUGO) {
           this.XDATA_PRODUCAO = XDATA_PRODUCAO;
           this.XNUMERO_OP = XNUMERO_OP;
           this.XPAR02LSTS = XPAR02LSTS;
           this.XQUANTIDADE = XQUANTIDADE;
           this.XQUANTIDADE_REFUGO = XQUANTIDADE_REFUGO;
    }


    /**
     * Gets the XDATA_PRODUCAO value for this XPAR02.
     * 
     * @return XDATA_PRODUCAO
     */
    public java.util.Date getXDATA_PRODUCAO() {
        return XDATA_PRODUCAO;
    }


    /**
     * Sets the XDATA_PRODUCAO value for this XPAR02.
     * 
     * @param XDATA_PRODUCAO
     */
    public void setXDATA_PRODUCAO(java.util.Date XDATA_PRODUCAO) {
        this.XDATA_PRODUCAO = XDATA_PRODUCAO;
    }


    /**
     * Gets the XNUMERO_OP value for this XPAR02.
     * 
     * @return XNUMERO_OP
     */
    public java.lang.String getXNUMERO_OP() {
        return XNUMERO_OP;
    }


    /**
     * Sets the XNUMERO_OP value for this XPAR02.
     * 
     * @param XNUMERO_OP
     */
    public void setXNUMERO_OP(java.lang.String XNUMERO_OP) {
        this.XNUMERO_OP = XNUMERO_OP;
    }


    /**
     * Gets the XPAR02LSTS value for this XPAR02.
     * 
     * @return XPAR02LSTS
     */
    public idw.model.rn.integracao.ipackchem.client.XPAR02LST[] getXPAR02LSTS() {
        return XPAR02LSTS;
    }


    /**
     * Sets the XPAR02LSTS value for this XPAR02.
     * 
     * @param XPAR02LSTS
     */
    public void setXPAR02LSTS(idw.model.rn.integracao.ipackchem.client.XPAR02LST[] XPAR02LSTS) {
        this.XPAR02LSTS = XPAR02LSTS;
    }


    /**
     * Gets the XQUANTIDADE value for this XPAR02.
     * 
     * @return XQUANTIDADE
     */
    public float getXQUANTIDADE() {
        return XQUANTIDADE;
    }


    /**
     * Sets the XQUANTIDADE value for this XPAR02.
     * 
     * @param XQUANTIDADE
     */
    public void setXQUANTIDADE(float XQUANTIDADE) {
        this.XQUANTIDADE = XQUANTIDADE;
    }


    /**
     * Gets the XQUANTIDADE_REFUGO value for this XPAR02.
     * 
     * @return XQUANTIDADE_REFUGO
     */
    public float getXQUANTIDADE_REFUGO() {
        return XQUANTIDADE_REFUGO;
    }


    /**
     * Sets the XQUANTIDADE_REFUGO value for this XPAR02.
     * 
     * @param XQUANTIDADE_REFUGO
     */
    public void setXQUANTIDADE_REFUGO(float XQUANTIDADE_REFUGO) {
        this.XQUANTIDADE_REFUGO = XQUANTIDADE_REFUGO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof XPAR02)) return false;
        XPAR02 other = (XPAR02) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.XDATA_PRODUCAO==null && other.getXDATA_PRODUCAO()==null) || 
             (this.XDATA_PRODUCAO!=null &&
              this.XDATA_PRODUCAO.equals(other.getXDATA_PRODUCAO()))) &&
            ((this.XNUMERO_OP==null && other.getXNUMERO_OP()==null) || 
             (this.XNUMERO_OP!=null &&
              this.XNUMERO_OP.equals(other.getXNUMERO_OP()))) &&
            ((this.XPAR02LSTS==null && other.getXPAR02LSTS()==null) || 
             (this.XPAR02LSTS!=null &&
              java.util.Arrays.equals(this.XPAR02LSTS, other.getXPAR02LSTS()))) &&
            this.XQUANTIDADE == other.getXQUANTIDADE() &&
            this.XQUANTIDADE_REFUGO == other.getXQUANTIDADE_REFUGO();
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
        if (getXDATA_PRODUCAO() != null) {
            _hashCode += getXDATA_PRODUCAO().hashCode();
        }
        if (getXNUMERO_OP() != null) {
            _hashCode += getXNUMERO_OP().hashCode();
        }
        if (getXPAR02LSTS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getXPAR02LSTS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getXPAR02LSTS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Float(getXQUANTIDADE()).hashCode();
        _hashCode += new Float(getXQUANTIDADE_REFUGO()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(XPAR02.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR02"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XDATA_PRODUCAO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XDATA_PRODUCAO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XNUMERO_OP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XNUMERO_OP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XPAR02LSTS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR02LSTS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR02LST"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XPAR02LST"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XQUANTIDADE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XQUANTIDADE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XQUANTIDADE_REFUGO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ipackchem.totvs.com.br:8807/", "XQUANTIDADE_REFUGO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
