/**
 * Ijkanbanlote.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijkanbanlote  implements java.io.Serializable {
    private java.lang.String cdestrutura;

    private java.util.Calendar dthraberturalote;

    private java.util.Calendar dthrfechamentolote;

    private java.util.Calendar dthrsitlote;

    private idw.idwws.Ijkanbancartoes[] ijkanbancartoeses;

    private idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbmol ijtbmol;

    private idw.idwws.Ijtbpro ijtbpro;

    private java.lang.String nrlotekanban;

    private java.lang.Double perclotekanban;

    private java.math.BigDecimal qtcartoesfechados;

    private java.math.BigDecimal qtcartoeslote;

    private org.apache.axis.types.UnsignedShort sitlote;

    private java.math.BigDecimal tamlotekanban;

    public Ijkanbanlote() {
    }

    public Ijkanbanlote(
           java.lang.String cdestrutura,
           java.util.Calendar dthraberturalote,
           java.util.Calendar dthrfechamentolote,
           java.util.Calendar dthrsitlote,
           idw.idwws.Ijkanbancartoes[] ijkanbancartoeses,
           idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbmol ijtbmol,
           idw.idwws.Ijtbpro ijtbpro,
           java.lang.String nrlotekanban,
           java.lang.Double perclotekanban,
           java.math.BigDecimal qtcartoesfechados,
           java.math.BigDecimal qtcartoeslote,
           org.apache.axis.types.UnsignedShort sitlote,
           java.math.BigDecimal tamlotekanban) {
           this.cdestrutura = cdestrutura;
           this.dthraberturalote = dthraberturalote;
           this.dthrfechamentolote = dthrfechamentolote;
           this.dthrsitlote = dthrsitlote;
           this.ijkanbancartoeses = ijkanbancartoeses;
           this.ijkanbanidcartaos = ijkanbanidcartaos;
           this.ijop = ijop;
           this.ijtbinj = ijtbinj;
           this.ijtbmol = ijtbmol;
           this.ijtbpro = ijtbpro;
           this.nrlotekanban = nrlotekanban;
           this.perclotekanban = perclotekanban;
           this.qtcartoesfechados = qtcartoesfechados;
           this.qtcartoeslote = qtcartoeslote;
           this.sitlote = sitlote;
           this.tamlotekanban = tamlotekanban;
    }


    /**
     * Gets the cdestrutura value for this Ijkanbanlote.
     * 
     * @return cdestrutura
     */
    public java.lang.String getCdestrutura() {
        return cdestrutura;
    }


    /**
     * Sets the cdestrutura value for this Ijkanbanlote.
     * 
     * @param cdestrutura
     */
    public void setCdestrutura(java.lang.String cdestrutura) {
        this.cdestrutura = cdestrutura;
    }


    /**
     * Gets the dthraberturalote value for this Ijkanbanlote.
     * 
     * @return dthraberturalote
     */
    public java.util.Calendar getDthraberturalote() {
        return dthraberturalote;
    }


    /**
     * Sets the dthraberturalote value for this Ijkanbanlote.
     * 
     * @param dthraberturalote
     */
    public void setDthraberturalote(java.util.Calendar dthraberturalote) {
        this.dthraberturalote = dthraberturalote;
    }


    /**
     * Gets the dthrfechamentolote value for this Ijkanbanlote.
     * 
     * @return dthrfechamentolote
     */
    public java.util.Calendar getDthrfechamentolote() {
        return dthrfechamentolote;
    }


    /**
     * Sets the dthrfechamentolote value for this Ijkanbanlote.
     * 
     * @param dthrfechamentolote
     */
    public void setDthrfechamentolote(java.util.Calendar dthrfechamentolote) {
        this.dthrfechamentolote = dthrfechamentolote;
    }


    /**
     * Gets the dthrsitlote value for this Ijkanbanlote.
     * 
     * @return dthrsitlote
     */
    public java.util.Calendar getDthrsitlote() {
        return dthrsitlote;
    }


    /**
     * Sets the dthrsitlote value for this Ijkanbanlote.
     * 
     * @param dthrsitlote
     */
    public void setDthrsitlote(java.util.Calendar dthrsitlote) {
        this.dthrsitlote = dthrsitlote;
    }


    /**
     * Gets the ijkanbancartoeses value for this Ijkanbanlote.
     * 
     * @return ijkanbancartoeses
     */
    public idw.idwws.Ijkanbancartoes[] getIjkanbancartoeses() {
        return ijkanbancartoeses;
    }


    /**
     * Sets the ijkanbancartoeses value for this Ijkanbanlote.
     * 
     * @param ijkanbancartoeses
     */
    public void setIjkanbancartoeses(idw.idwws.Ijkanbancartoes[] ijkanbancartoeses) {
        this.ijkanbancartoeses = ijkanbancartoeses;
    }

    public idw.idwws.Ijkanbancartoes getIjkanbancartoeses(int i) {
        return this.ijkanbancartoeses[i];
    }

    public void setIjkanbancartoeses(int i, idw.idwws.Ijkanbancartoes _value) {
        this.ijkanbancartoeses[i] = _value;
    }


    /**
     * Gets the ijkanbanidcartaos value for this Ijkanbanlote.
     * 
     * @return ijkanbanidcartaos
     */
    public idw.idwws.Ijkanbanidcartao[] getIjkanbanidcartaos() {
        return ijkanbanidcartaos;
    }


    /**
     * Sets the ijkanbanidcartaos value for this Ijkanbanlote.
     * 
     * @param ijkanbanidcartaos
     */
    public void setIjkanbanidcartaos(idw.idwws.Ijkanbanidcartao[] ijkanbanidcartaos) {
        this.ijkanbanidcartaos = ijkanbanidcartaos;
    }

    public idw.idwws.Ijkanbanidcartao getIjkanbanidcartaos(int i) {
        return this.ijkanbanidcartaos[i];
    }

    public void setIjkanbanidcartaos(int i, idw.idwws.Ijkanbanidcartao _value) {
        this.ijkanbanidcartaos[i] = _value;
    }


    /**
     * Gets the ijop value for this Ijkanbanlote.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijkanbanlote.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijtbinj value for this Ijkanbanlote.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijkanbanlote.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbmol value for this Ijkanbanlote.
     * 
     * @return ijtbmol
     */
    public idw.idwws.Ijtbmol getIjtbmol() {
        return ijtbmol;
    }


    /**
     * Sets the ijtbmol value for this Ijkanbanlote.
     * 
     * @param ijtbmol
     */
    public void setIjtbmol(idw.idwws.Ijtbmol ijtbmol) {
        this.ijtbmol = ijtbmol;
    }


    /**
     * Gets the ijtbpro value for this Ijkanbanlote.
     * 
     * @return ijtbpro
     */
    public idw.idwws.Ijtbpro getIjtbpro() {
        return ijtbpro;
    }


    /**
     * Sets the ijtbpro value for this Ijkanbanlote.
     * 
     * @param ijtbpro
     */
    public void setIjtbpro(idw.idwws.Ijtbpro ijtbpro) {
        this.ijtbpro = ijtbpro;
    }


    /**
     * Gets the nrlotekanban value for this Ijkanbanlote.
     * 
     * @return nrlotekanban
     */
    public java.lang.String getNrlotekanban() {
        return nrlotekanban;
    }


    /**
     * Sets the nrlotekanban value for this Ijkanbanlote.
     * 
     * @param nrlotekanban
     */
    public void setNrlotekanban(java.lang.String nrlotekanban) {
        this.nrlotekanban = nrlotekanban;
    }


    /**
     * Gets the perclotekanban value for this Ijkanbanlote.
     * 
     * @return perclotekanban
     */
    public java.lang.Double getPerclotekanban() {
        return perclotekanban;
    }


    /**
     * Sets the perclotekanban value for this Ijkanbanlote.
     * 
     * @param perclotekanban
     */
    public void setPerclotekanban(java.lang.Double perclotekanban) {
        this.perclotekanban = perclotekanban;
    }


    /**
     * Gets the qtcartoesfechados value for this Ijkanbanlote.
     * 
     * @return qtcartoesfechados
     */
    public java.math.BigDecimal getQtcartoesfechados() {
        return qtcartoesfechados;
    }


    /**
     * Sets the qtcartoesfechados value for this Ijkanbanlote.
     * 
     * @param qtcartoesfechados
     */
    public void setQtcartoesfechados(java.math.BigDecimal qtcartoesfechados) {
        this.qtcartoesfechados = qtcartoesfechados;
    }


    /**
     * Gets the qtcartoeslote value for this Ijkanbanlote.
     * 
     * @return qtcartoeslote
     */
    public java.math.BigDecimal getQtcartoeslote() {
        return qtcartoeslote;
    }


    /**
     * Sets the qtcartoeslote value for this Ijkanbanlote.
     * 
     * @param qtcartoeslote
     */
    public void setQtcartoeslote(java.math.BigDecimal qtcartoeslote) {
        this.qtcartoeslote = qtcartoeslote;
    }


    /**
     * Gets the sitlote value for this Ijkanbanlote.
     * 
     * @return sitlote
     */
    public org.apache.axis.types.UnsignedShort getSitlote() {
        return sitlote;
    }


    /**
     * Sets the sitlote value for this Ijkanbanlote.
     * 
     * @param sitlote
     */
    public void setSitlote(org.apache.axis.types.UnsignedShort sitlote) {
        this.sitlote = sitlote;
    }


    /**
     * Gets the tamlotekanban value for this Ijkanbanlote.
     * 
     * @return tamlotekanban
     */
    public java.math.BigDecimal getTamlotekanban() {
        return tamlotekanban;
    }


    /**
     * Sets the tamlotekanban value for this Ijkanbanlote.
     * 
     * @param tamlotekanban
     */
    public void setTamlotekanban(java.math.BigDecimal tamlotekanban) {
        this.tamlotekanban = tamlotekanban;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijkanbanlote)) return false;
        Ijkanbanlote other = (Ijkanbanlote) obj;
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
            ((this.ijkanbancartoeses==null && other.getIjkanbancartoeses()==null) || 
             (this.ijkanbancartoeses!=null &&
              java.util.Arrays.equals(this.ijkanbancartoeses, other.getIjkanbancartoeses()))) &&
            ((this.ijkanbanidcartaos==null && other.getIjkanbanidcartaos()==null) || 
             (this.ijkanbanidcartaos!=null &&
              java.util.Arrays.equals(this.ijkanbanidcartaos, other.getIjkanbanidcartaos()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbmol==null && other.getIjtbmol()==null) || 
             (this.ijtbmol!=null &&
              this.ijtbmol.equals(other.getIjtbmol()))) &&
            ((this.ijtbpro==null && other.getIjtbpro()==null) || 
             (this.ijtbpro!=null &&
              this.ijtbpro.equals(other.getIjtbpro()))) &&
            ((this.nrlotekanban==null && other.getNrlotekanban()==null) || 
             (this.nrlotekanban!=null &&
              this.nrlotekanban.equals(other.getNrlotekanban()))) &&
            ((this.perclotekanban==null && other.getPerclotekanban()==null) || 
             (this.perclotekanban!=null &&
              this.perclotekanban.equals(other.getPerclotekanban()))) &&
            ((this.qtcartoesfechados==null && other.getQtcartoesfechados()==null) || 
             (this.qtcartoesfechados!=null &&
              this.qtcartoesfechados.equals(other.getQtcartoesfechados()))) &&
            ((this.qtcartoeslote==null && other.getQtcartoeslote()==null) || 
             (this.qtcartoeslote!=null &&
              this.qtcartoeslote.equals(other.getQtcartoeslote()))) &&
            ((this.sitlote==null && other.getSitlote()==null) || 
             (this.sitlote!=null &&
              this.sitlote.equals(other.getSitlote()))) &&
            ((this.tamlotekanban==null && other.getTamlotekanban()==null) || 
             (this.tamlotekanban!=null &&
              this.tamlotekanban.equals(other.getTamlotekanban())));
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
        if (getIjkanbancartoeses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbancartoeses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbancartoeses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjkanbanidcartaos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjkanbanidcartaos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjkanbanidcartaos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
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
        if (getNrlotekanban() != null) {
            _hashCode += getNrlotekanban().hashCode();
        }
        if (getPerclotekanban() != null) {
            _hashCode += getPerclotekanban().hashCode();
        }
        if (getQtcartoesfechados() != null) {
            _hashCode += getQtcartoesfechados().hashCode();
        }
        if (getQtcartoeslote() != null) {
            _hashCode += getQtcartoeslote().hashCode();
        }
        if (getSitlote() != null) {
            _hashCode += getSitlote().hashCode();
        }
        if (getTamlotekanban() != null) {
            _hashCode += getTamlotekanban().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijkanbanlote.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanlote"));
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
        elemField.setFieldName("ijkanbancartoeses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbancartoeses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbancartoes"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijkanbanidcartaos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijkanbanidcartaos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijkanbanidcartao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
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
        elemField.setFieldName("nrlotekanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrlotekanban"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perclotekanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perclotekanban"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcartoesfechados");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcartoesfechados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qtcartoeslote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtcartoeslote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sitlote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sitlote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tamlotekanban");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tamlotekanban"));
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
