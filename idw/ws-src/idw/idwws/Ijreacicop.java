/**
 * Ijreacicop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijreacicop  implements java.io.Serializable {
    private java.util.Calendar dthrfciclo;

    private java.util.Calendar dthrivalcic;

    private java.util.Calendar dthrivalestru;

    private idw.idwws.IjreacicopId id;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijreacicopoprd[] ijreacicopoprds;

    private idw.idwws.Ijtbinj ijtbinj;

    private java.lang.String nrOrdProd;

    private java.lang.Double tmpcicespera;

    private double tmpciclolido;

    private double tmpcicpadrao;

    private java.lang.Double tmpcicpadraoespera;

    public Ijreacicop() {
    }

    public Ijreacicop(
           java.util.Calendar dthrfciclo,
           java.util.Calendar dthrivalcic,
           java.util.Calendar dthrivalestru,
           idw.idwws.IjreacicopId id,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijreacicopoprd[] ijreacicopoprds,
           idw.idwws.Ijtbinj ijtbinj,
           java.lang.String nrOrdProd,
           java.lang.Double tmpcicespera,
           double tmpciclolido,
           double tmpcicpadrao,
           java.lang.Double tmpcicpadraoespera) {
           this.dthrfciclo = dthrfciclo;
           this.dthrivalcic = dthrivalcic;
           this.dthrivalestru = dthrivalestru;
           this.id = id;
           this.ijestmol = ijestmol;
           this.ijop = ijop;
           this.ijreacicopoprds = ijreacicopoprds;
           this.ijtbinj = ijtbinj;
           this.nrOrdProd = nrOrdProd;
           this.tmpcicespera = tmpcicespera;
           this.tmpciclolido = tmpciclolido;
           this.tmpcicpadrao = tmpcicpadrao;
           this.tmpcicpadraoespera = tmpcicpadraoespera;
    }


    /**
     * Gets the dthrfciclo value for this Ijreacicop.
     * 
     * @return dthrfciclo
     */
    public java.util.Calendar getDthrfciclo() {
        return dthrfciclo;
    }


    /**
     * Sets the dthrfciclo value for this Ijreacicop.
     * 
     * @param dthrfciclo
     */
    public void setDthrfciclo(java.util.Calendar dthrfciclo) {
        this.dthrfciclo = dthrfciclo;
    }


    /**
     * Gets the dthrivalcic value for this Ijreacicop.
     * 
     * @return dthrivalcic
     */
    public java.util.Calendar getDthrivalcic() {
        return dthrivalcic;
    }


    /**
     * Sets the dthrivalcic value for this Ijreacicop.
     * 
     * @param dthrivalcic
     */
    public void setDthrivalcic(java.util.Calendar dthrivalcic) {
        this.dthrivalcic = dthrivalcic;
    }


    /**
     * Gets the dthrivalestru value for this Ijreacicop.
     * 
     * @return dthrivalestru
     */
    public java.util.Calendar getDthrivalestru() {
        return dthrivalestru;
    }


    /**
     * Sets the dthrivalestru value for this Ijreacicop.
     * 
     * @param dthrivalestru
     */
    public void setDthrivalestru(java.util.Calendar dthrivalestru) {
        this.dthrivalestru = dthrivalestru;
    }


    /**
     * Gets the id value for this Ijreacicop.
     * 
     * @return id
     */
    public idw.idwws.IjreacicopId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijreacicop.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjreacicopId id) {
        this.id = id;
    }


    /**
     * Gets the ijestmol value for this Ijreacicop.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijreacicop.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijop value for this Ijreacicop.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijreacicop.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijreacicopoprds value for this Ijreacicop.
     * 
     * @return ijreacicopoprds
     */
    public idw.idwws.Ijreacicopoprd[] getIjreacicopoprds() {
        return ijreacicopoprds;
    }


    /**
     * Sets the ijreacicopoprds value for this Ijreacicop.
     * 
     * @param ijreacicopoprds
     */
    public void setIjreacicopoprds(idw.idwws.Ijreacicopoprd[] ijreacicopoprds) {
        this.ijreacicopoprds = ijreacicopoprds;
    }

    public idw.idwws.Ijreacicopoprd getIjreacicopoprds(int i) {
        return this.ijreacicopoprds[i];
    }

    public void setIjreacicopoprds(int i, idw.idwws.Ijreacicopoprd _value) {
        this.ijreacicopoprds[i] = _value;
    }


    /**
     * Gets the ijtbinj value for this Ijreacicop.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijreacicop.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the nrOrdProd value for this Ijreacicop.
     * 
     * @return nrOrdProd
     */
    public java.lang.String getNrOrdProd() {
        return nrOrdProd;
    }


    /**
     * Sets the nrOrdProd value for this Ijreacicop.
     * 
     * @param nrOrdProd
     */
    public void setNrOrdProd(java.lang.String nrOrdProd) {
        this.nrOrdProd = nrOrdProd;
    }


    /**
     * Gets the tmpcicespera value for this Ijreacicop.
     * 
     * @return tmpcicespera
     */
    public java.lang.Double getTmpcicespera() {
        return tmpcicespera;
    }


    /**
     * Sets the tmpcicespera value for this Ijreacicop.
     * 
     * @param tmpcicespera
     */
    public void setTmpcicespera(java.lang.Double tmpcicespera) {
        this.tmpcicespera = tmpcicespera;
    }


    /**
     * Gets the tmpciclolido value for this Ijreacicop.
     * 
     * @return tmpciclolido
     */
    public double getTmpciclolido() {
        return tmpciclolido;
    }


    /**
     * Sets the tmpciclolido value for this Ijreacicop.
     * 
     * @param tmpciclolido
     */
    public void setTmpciclolido(double tmpciclolido) {
        this.tmpciclolido = tmpciclolido;
    }


    /**
     * Gets the tmpcicpadrao value for this Ijreacicop.
     * 
     * @return tmpcicpadrao
     */
    public double getTmpcicpadrao() {
        return tmpcicpadrao;
    }


    /**
     * Sets the tmpcicpadrao value for this Ijreacicop.
     * 
     * @param tmpcicpadrao
     */
    public void setTmpcicpadrao(double tmpcicpadrao) {
        this.tmpcicpadrao = tmpcicpadrao;
    }


    /**
     * Gets the tmpcicpadraoespera value for this Ijreacicop.
     * 
     * @return tmpcicpadraoespera
     */
    public java.lang.Double getTmpcicpadraoespera() {
        return tmpcicpadraoespera;
    }


    /**
     * Sets the tmpcicpadraoespera value for this Ijreacicop.
     * 
     * @param tmpcicpadraoespera
     */
    public void setTmpcicpadraoespera(java.lang.Double tmpcicpadraoespera) {
        this.tmpcicpadraoespera = tmpcicpadraoespera;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijreacicop)) return false;
        Ijreacicop other = (Ijreacicop) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfciclo==null && other.getDthrfciclo()==null) || 
             (this.dthrfciclo!=null &&
              this.dthrfciclo.equals(other.getDthrfciclo()))) &&
            ((this.dthrivalcic==null && other.getDthrivalcic()==null) || 
             (this.dthrivalcic!=null &&
              this.dthrivalcic.equals(other.getDthrivalcic()))) &&
            ((this.dthrivalestru==null && other.getDthrivalestru()==null) || 
             (this.dthrivalestru!=null &&
              this.dthrivalestru.equals(other.getDthrivalestru()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijreacicopoprds==null && other.getIjreacicopoprds()==null) || 
             (this.ijreacicopoprds!=null &&
              java.util.Arrays.equals(this.ijreacicopoprds, other.getIjreacicopoprds()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.nrOrdProd==null && other.getNrOrdProd()==null) || 
             (this.nrOrdProd!=null &&
              this.nrOrdProd.equals(other.getNrOrdProd()))) &&
            ((this.tmpcicespera==null && other.getTmpcicespera()==null) || 
             (this.tmpcicespera!=null &&
              this.tmpcicespera.equals(other.getTmpcicespera()))) &&
            this.tmpciclolido == other.getTmpciclolido() &&
            this.tmpcicpadrao == other.getTmpcicpadrao() &&
            ((this.tmpcicpadraoespera==null && other.getTmpcicpadraoespera()==null) || 
             (this.tmpcicpadraoespera!=null &&
              this.tmpcicpadraoespera.equals(other.getTmpcicpadraoespera())));
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
        if (getDthrfciclo() != null) {
            _hashCode += getDthrfciclo().hashCode();
        }
        if (getDthrivalcic() != null) {
            _hashCode += getDthrivalcic().hashCode();
        }
        if (getDthrivalestru() != null) {
            _hashCode += getDthrivalestru().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjreacicopoprds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreacicopoprds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreacicopoprds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getNrOrdProd() != null) {
            _hashCode += getNrOrdProd().hashCode();
        }
        if (getTmpcicespera() != null) {
            _hashCode += getTmpcicespera().hashCode();
        }
        _hashCode += new Double(getTmpciclolido()).hashCode();
        _hashCode += new Double(getTmpcicpadrao()).hashCode();
        if (getTmpcicpadraoespera() != null) {
            _hashCode += getTmpcicpadraoespera().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijreacicop.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacicop"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfciclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfciclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalcic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalcic"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacicopId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijestmol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijestmol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijestmol"));
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
        elemField.setFieldName("ijreacicopoprds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreacicopoprds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreacicopoprd"));
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
        elemField.setFieldName("nrOrdProd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nrOrdProd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpcicespera");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpcicespera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpciclolido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpciclolido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpcicpadrao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpcicpadrao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpcicpadraoespera");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpcicpadraoespera"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
