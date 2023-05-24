/**
 * Ijalertas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijalertas  implements java.io.Serializable {
    private java.util.Calendar dthrfalerta;

    private java.util.Calendar dthrivalestru;

    private idw.idwws.IjalertasId id;

    private idw.idwws.Ijaledbqld[] ijaledbqlds;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijtbale ijtbale;

    private idw.idwws.Ijtbusu ijtbusu;

    private java.math.BigDecimal lgeradoautomatico;

    private java.lang.String nrop;

    private java.lang.String observacao;

    private java.math.BigDecimal quedaescravo;

    private org.apache.axis.types.UnsignedShort tpfechamento;

    public Ijalertas() {
    }

    public Ijalertas(
           java.util.Calendar dthrfalerta,
           java.util.Calendar dthrivalestru,
           idw.idwws.IjalertasId id,
           idw.idwws.Ijaledbqld[] ijaledbqlds,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijtbale ijtbale,
           idw.idwws.Ijtbusu ijtbusu,
           java.math.BigDecimal lgeradoautomatico,
           java.lang.String nrop,
           java.lang.String observacao,
           java.math.BigDecimal quedaescravo,
           org.apache.axis.types.UnsignedShort tpfechamento) {
           this.dthrfalerta = dthrfalerta;
           this.dthrivalestru = dthrivalestru;
           this.id = id;
           this.ijaledbqlds = ijaledbqlds;
           this.ijestmol = ijestmol;
           this.ijtbale = ijtbale;
           this.ijtbusu = ijtbusu;
           this.lgeradoautomatico = lgeradoautomatico;
           this.nrop = nrop;
           this.observacao = observacao;
           this.quedaescravo = quedaescravo;
           this.tpfechamento = tpfechamento;
    }


    /**
     * Gets the dthrfalerta value for this Ijalertas.
     * 
     * @return dthrfalerta
     */
    public java.util.Calendar getDthrfalerta() {
        return dthrfalerta;
    }


    /**
     * Sets the dthrfalerta value for this Ijalertas.
     * 
     * @param dthrfalerta
     */
    public void setDthrfalerta(java.util.Calendar dthrfalerta) {
        this.dthrfalerta = dthrfalerta;
    }


    /**
     * Gets the dthrivalestru value for this Ijalertas.
     * 
     * @return dthrivalestru
     */
    public java.util.Calendar getDthrivalestru() {
        return dthrivalestru;
    }


    /**
     * Sets the dthrivalestru value for this Ijalertas.
     * 
     * @param dthrivalestru
     */
    public void setDthrivalestru(java.util.Calendar dthrivalestru) {
        this.dthrivalestru = dthrivalestru;
    }


    /**
     * Gets the id value for this Ijalertas.
     * 
     * @return id
     */
    public idw.idwws.IjalertasId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijalertas.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjalertasId id) {
        this.id = id;
    }


    /**
     * Gets the ijaledbqlds value for this Ijalertas.
     * 
     * @return ijaledbqlds
     */
    public idw.idwws.Ijaledbqld[] getIjaledbqlds() {
        return ijaledbqlds;
    }


    /**
     * Sets the ijaledbqlds value for this Ijalertas.
     * 
     * @param ijaledbqlds
     */
    public void setIjaledbqlds(idw.idwws.Ijaledbqld[] ijaledbqlds) {
        this.ijaledbqlds = ijaledbqlds;
    }

    public idw.idwws.Ijaledbqld getIjaledbqlds(int i) {
        return this.ijaledbqlds[i];
    }

    public void setIjaledbqlds(int i, idw.idwws.Ijaledbqld _value) {
        this.ijaledbqlds[i] = _value;
    }


    /**
     * Gets the ijestmol value for this Ijalertas.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijalertas.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijtbale value for this Ijalertas.
     * 
     * @return ijtbale
     */
    public idw.idwws.Ijtbale getIjtbale() {
        return ijtbale;
    }


    /**
     * Sets the ijtbale value for this Ijalertas.
     * 
     * @param ijtbale
     */
    public void setIjtbale(idw.idwws.Ijtbale ijtbale) {
        this.ijtbale = ijtbale;
    }


    /**
     * Gets the ijtbusu value for this Ijalertas.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijalertas.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the lgeradoautomatico value for this Ijalertas.
     * 
     * @return lgeradoautomatico
     */
    public java.math.BigDecimal getLgeradoautomatico() {
        return lgeradoautomatico;
    }


    /**
     * Sets the lgeradoautomatico value for this Ijalertas.
     * 
     * @param lgeradoautomatico
     */
    public void setLgeradoautomatico(java.math.BigDecimal lgeradoautomatico) {
        this.lgeradoautomatico = lgeradoautomatico;
    }


    /**
     * Gets the nrop value for this Ijalertas.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this Ijalertas.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the observacao value for this Ijalertas.
     * 
     * @return observacao
     */
    public java.lang.String getObservacao() {
        return observacao;
    }


    /**
     * Sets the observacao value for this Ijalertas.
     * 
     * @param observacao
     */
    public void setObservacao(java.lang.String observacao) {
        this.observacao = observacao;
    }


    /**
     * Gets the quedaescravo value for this Ijalertas.
     * 
     * @return quedaescravo
     */
    public java.math.BigDecimal getQuedaescravo() {
        return quedaescravo;
    }


    /**
     * Sets the quedaescravo value for this Ijalertas.
     * 
     * @param quedaescravo
     */
    public void setQuedaescravo(java.math.BigDecimal quedaescravo) {
        this.quedaescravo = quedaescravo;
    }


    /**
     * Gets the tpfechamento value for this Ijalertas.
     * 
     * @return tpfechamento
     */
    public org.apache.axis.types.UnsignedShort getTpfechamento() {
        return tpfechamento;
    }


    /**
     * Sets the tpfechamento value for this Ijalertas.
     * 
     * @param tpfechamento
     */
    public void setTpfechamento(org.apache.axis.types.UnsignedShort tpfechamento) {
        this.tpfechamento = tpfechamento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijalertas)) return false;
        Ijalertas other = (Ijalertas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfalerta==null && other.getDthrfalerta()==null) || 
             (this.dthrfalerta!=null &&
              this.dthrfalerta.equals(other.getDthrfalerta()))) &&
            ((this.dthrivalestru==null && other.getDthrivalestru()==null) || 
             (this.dthrivalestru!=null &&
              this.dthrivalestru.equals(other.getDthrivalestru()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijaledbqlds==null && other.getIjaledbqlds()==null) || 
             (this.ijaledbqlds!=null &&
              java.util.Arrays.equals(this.ijaledbqlds, other.getIjaledbqlds()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijtbale==null && other.getIjtbale()==null) || 
             (this.ijtbale!=null &&
              this.ijtbale.equals(other.getIjtbale()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.lgeradoautomatico==null && other.getLgeradoautomatico()==null) || 
             (this.lgeradoautomatico!=null &&
              this.lgeradoautomatico.equals(other.getLgeradoautomatico()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.observacao==null && other.getObservacao()==null) || 
             (this.observacao!=null &&
              this.observacao.equals(other.getObservacao()))) &&
            ((this.quedaescravo==null && other.getQuedaescravo()==null) || 
             (this.quedaescravo!=null &&
              this.quedaescravo.equals(other.getQuedaescravo()))) &&
            ((this.tpfechamento==null && other.getTpfechamento()==null) || 
             (this.tpfechamento!=null &&
              this.tpfechamento.equals(other.getTpfechamento())));
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
        if (getDthrfalerta() != null) {
            _hashCode += getDthrfalerta().hashCode();
        }
        if (getDthrivalestru() != null) {
            _hashCode += getDthrivalestru().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjaledbqlds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjaledbqlds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjaledbqlds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjtbale() != null) {
            _hashCode += getIjtbale().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getLgeradoautomatico() != null) {
            _hashCode += getLgeradoautomatico().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getObservacao() != null) {
            _hashCode += getObservacao().hashCode();
        }
        if (getQuedaescravo() != null) {
            _hashCode += getQuedaescravo().hashCode();
        }
        if (getTpfechamento() != null) {
            _hashCode += getTpfechamento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijalertas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalertas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfalerta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfalerta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalestru");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalestru"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijalertasId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijaledbqlds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijaledbqlds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijaledbqld"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbale"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lgeradoautomatico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lgeradoautomatico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nrop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrop"));
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
        elemField.setFieldName("quedaescravo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quedaescravo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpfechamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpfechamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
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
