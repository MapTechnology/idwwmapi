/**
 * Ijoplotes.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijoplotes  implements java.io.Serializable {
    private java.lang.String cdestrutura;

    private java.util.Calendar dthraberturalote;

    private java.util.Calendar dthrfechamentolote;

    private java.util.Calendar dthrsitlote;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijoplotesdet[] ijoplotesdets;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbmol ijtbmol;

    private idw.idwws.Ijtbpro ijtbpro;

    private java.lang.String nrloteop;

    private java.lang.Double percfirmlote;

    private double qtdunidades;

    private org.apache.axis.types.UnsignedShort sitlote;

    private java.math.BigDecimal tamlotepadrao;

    public Ijoplotes() {
    }

    public Ijoplotes(
           java.lang.String cdestrutura,
           java.util.Calendar dthraberturalote,
           java.util.Calendar dthrfechamentolote,
           java.util.Calendar dthrsitlote,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijoplotesdet[] ijoplotesdets,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbmol ijtbmol,
           idw.idwws.Ijtbpro ijtbpro,
           java.lang.String nrloteop,
           java.lang.Double percfirmlote,
           double qtdunidades,
           org.apache.axis.types.UnsignedShort sitlote,
           java.math.BigDecimal tamlotepadrao) {
           this.cdestrutura = cdestrutura;
           this.dthraberturalote = dthraberturalote;
           this.dthrfechamentolote = dthrfechamentolote;
           this.dthrsitlote = dthrsitlote;
           this.ijop = ijop;
           this.ijoplotesdets = ijoplotesdets;
           this.ijtbinj = ijtbinj;
           this.ijtbmol = ijtbmol;
           this.ijtbpro = ijtbpro;
           this.nrloteop = nrloteop;
           this.percfirmlote = percfirmlote;
           this.qtdunidades = qtdunidades;
           this.sitlote = sitlote;
           this.tamlotepadrao = tamlotepadrao;
    }


    /**
     * Gets the cdestrutura value for this Ijoplotes.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this Ijoplotes.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the dthraberturalote value for this Ijoplotes.
     * 
     * @return dthraberturalote
     */
    public java.util.Calendar getDthraberturalote() {
        return dthraberturalote;
    }


    /**
     * Sets the dthraberturalote value for this Ijoplotes.
     * 
     * @param dthraberturalote
     */
    public void setDthraberturalote(java.util.Calendar dthraberturalote) {
        this.dthraberturalote = dthraberturalote;
    }


    /**
     * Gets the dthrfechamentolote value for this Ijoplotes.
     * 
     * @return dthrfechamentolote
     */
    public java.util.Calendar getDthrfechamentolote() {
        return dthrfechamentolote;
    }


    /**
     * Sets the dthrfechamentolote value for this Ijoplotes.
     * 
     * @param dthrfechamentolote
     */
    public void setDthrfechamentolote(java.util.Calendar dthrfechamentolote) {
        this.dthrfechamentolote = dthrfechamentolote;
    }


    /**
     * Gets the dthrsitlote value for this Ijoplotes.
     * 
     * @return dthrsitlote
     */
    public java.util.Calendar getDthrsitlote() {
        return dthrsitlote;
    }


    /**
     * Sets the dthrsitlote value for this Ijoplotes.
     * 
     * @param dthrsitlote
     */
    public void setDthrsitlote(java.util.Calendar dthrsitlote) {
        this.dthrsitlote = dthrsitlote;
    }


    /**
     * Gets the ijop value for this Ijoplotes.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijoplotes.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijoplotesdets value for this Ijoplotes.
     * 
     * @return ijoplotesdets
     */
    public idw.idwws.Ijoplotesdet[] getIjoplotesdets() {
        return ijoplotesdets;
    }


    /**
     * Sets the ijoplotesdets value for this Ijoplotes.
     * 
     * @param ijoplotesdets
     */
    public void setIjoplotesdets(idw.idwws.Ijoplotesdet[] ijoplotesdets) {
        this.ijoplotesdets = ijoplotesdets;
    }

    public idw.idwws.Ijoplotesdet getIjoplotesdets(int i) {
        return this.ijoplotesdets[i];
    }

    public void setIjoplotesdets(int i, idw.idwws.Ijoplotesdet _value) {
        this.ijoplotesdets[i] = _value;
    }


    /**
     * Gets the ijtbinj value for this Ijoplotes.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijoplotes.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbmol value for this Ijoplotes.
     * 
     * @return ijtbmol
     */
    public idw.idwws.Ijtbmol getIjtbmol() {
        return ijtbmol;
    }


    /**
     * Sets the ijtbmol value for this Ijoplotes.
     * 
     * @param ijtbmol
     */
    public void setIjtbmol(idw.idwws.Ijtbmol ijtbmol) {
        this.ijtbmol = ijtbmol;
    }


    /**
     * Gets the ijtbpro value for this Ijoplotes.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijoplotes.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the nrloteop value for this Ijoplotes.
     * 
     * @return nrloteop
     */
    public java.lang.String getNrloteop() {
        return nrloteop;
    }


    /**
     * Sets the nrloteop value for this Ijoplotes.
     * 
     * @param nrloteop
     */
    public void setNrloteop(java.lang.String nrloteop) {
        this.nrloteop = nrloteop;
    }


    /**
     * Gets the percfirmlote value for this Ijoplotes.
     * 
     * @return percfirmlote
     */
    public java.lang.Double getPercfirmlote() {
        return percfirmlote;
    }


    /**
     * Sets the percfirmlote value for this Ijoplotes.
     * 
     * @param percfirmlote
     */
    public void setPercfirmlote(java.lang.Double percfirmlote) {
        this.percfirmlote = percfirmlote;
    }


    /**
     * Gets the qtdunidades value for this Ijoplotes.
     * 
     * @return qtdunidades
     */
    public double getQtdunidades() {
        return qtdunidades;
    }


    /**
     * Sets the qtdunidades value for this Ijoplotes.
     * 
     * @param qtdunidades
     */
    public void setQtdunidades(double qtdunidades) {
        this.qtdunidades = qtdunidades;
    }


    /**
     * Gets the sitlote value for this Ijoplotes.
     * 
     * @return sitlote
     */
    public org.apache.axis.types.UnsignedShort getSitlote() {
        return sitlote;
    }


    /**
     * Sets the sitlote value for this Ijoplotes.
     * 
     * @param sitlote
     */
    public void setSitlote(org.apache.axis.types.UnsignedShort sitlote) {
        this.sitlote = sitlote;
    }


    /**
     * Gets the tamlotepadrao value for this Ijoplotes.
     * 
     * @return tamlotepadrao
     */
    public java.math.BigDecimal getTamlotepadrao() {
        return tamlotepadrao;
    }


    /**
     * Sets the tamlotepadrao value for this Ijoplotes.
     * 
     * @param tamlotepadrao
     */
    public void setTamlotepadrao(java.math.BigDecimal tamlotepadrao) {
        this.tamlotepadrao = tamlotepadrao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijoplotes)) return false;
        Ijoplotes other = (Ijoplotes) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdestrutura==null && other.getCdestrutura()==null) || 
             (this.cdestrutura!=null &&
              this.cdestrutura.equals(other.getCdestrutura()))) &&
            ((this.dthraberturalote==null && other.getDthraberturalote()==null) || 
             (this.dthraberturalote!=null &&
              this.dthraberturalote.equals(other.getDthraberturalote()))) &&
            ((this.dthrfechamentolote==null && other.getDthrfechamentolote()==null) || 
             (this.dthrfechamentolote!=null &&
              this.dthrfechamentolote.equals(other.getDthrfechamentolote()))) &&
            ((this.dthrsitlote==null && other.getDthrsitlote()==null) || 
             (this.dthrsitlote!=null &&
              this.dthrsitlote.equals(other.getDthrsitlote()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijoplotesdets==null && other.getIjoplotesdets()==null) || 
             (this.ijoplotesdets!=null &&
              java.util.Arrays.equals(this.ijoplotesdets, other.getIjoplotesdets()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbmol==null && other.getIjtbmol()==null) || 
             (this.ijtbmol!=null &&
              this.ijtbmol.equals(other.getIjtbmol()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.nrloteop==null && other.getNrloteop()==null) || 
             (this.nrloteop!=null &&
              this.nrloteop.equals(other.getNrloteop()))) &&
            ((this.percfirmlote==null && other.getPercfirmlote()==null) || 
             (this.percfirmlote!=null &&
              this.percfirmlote.equals(other.getPercfirmlote()))) &&
            this.qtdunidades == other.getQtdunidades() &&
            ((this.sitlote==null && other.getSitlote()==null) || 
             (this.sitlote!=null &&
              this.sitlote.equals(other.getSitlote()))) &&
            ((this.tamlotepadrao==null && other.getTamlotepadrao()==null) || 
             (this.tamlotepadrao!=null &&
              this.tamlotepadrao.equals(other.getTamlotepadrao())));
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
        if (getCdestrutura() != null) {
            _hashCode += getCdestrutura().hashCode();
        }
        if (getDthraberturalote() != null) {
            _hashCode += getDthraberturalote().hashCode();
        }
        if (getDthrfechamentolote() != null) {
            _hashCode += getDthrfechamentolote().hashCode();
        }
        if (getDthrsitlote() != null) {
            _hashCode += getDthrsitlote().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjoplotesdets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjoplotesdets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjoplotesdets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbmol() != null) {
            _hashCode += getIjtbmol().hashCode();
        }
        if (getIjtbpro() != null) {
            _hashCode += getIjtbpro().hashCode();
        }
        if (getNrloteop() != null) {
            _hashCode += getNrloteop().hashCode();
        }
        if (getPercfirmlote() != null) {
            _hashCode += getPercfirmlote().hashCode();
        }
        _hashCode += new Double(getQtdunidades()).hashCode();
        if (getSitlote() != null) {
            _hashCode += getSitlote().hashCode();
        }
        if (getTamlotepadrao() != null) {
            _hashCode += getTamlotepadrao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijoplotes.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotes"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdestrutura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdestrutura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthraberturalote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthraberturalote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfechamentolote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfechamentolote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrsitlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrsitlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijoplotesdets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijoplotesdets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijoplotesdet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbmol"));
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
        elemField.setFieldName("nrloteop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrloteop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("percfirmlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "percfirmlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtdunidades");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtdunidades"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sitlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sitlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamlotepadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamlotepadrao"));
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
