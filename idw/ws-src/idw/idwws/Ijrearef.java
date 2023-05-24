/**
 * Ijrearef.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijrearef  implements java.io.Serializable {
    private java.math.BigDecimal acumulado;

    private java.util.Calendar dthrfrefugo;

    private java.util.Calendar dthrivalcic;

    private java.util.Calendar dthrivalestru;

    private idw.idwws.IjrearefId id;

    private idw.idwws.Ijctrliniproc ijctrliniproc;

    private idw.idwws.Ijestmol ijestmol;

    private idw.idwws.Ijrearefintbet[] ijrearefintbets;

    private idw.idwws.Ijrearefoprd[] ijrearefoprds;

    private idw.idwws.Ijtbaco ijtbaco;

    private idw.idwws.Ijtbcau ijtbcau;

    private idw.idwws.Ijtbref ijtbref;

    private java.math.BigDecimal lcancelado;

    private java.lang.String nrop;

    private java.lang.Double qtrefugada;

    private org.apache.axis.types.UnsignedShort refreprocesso;

    public Ijrearef() {
    }

    public Ijrearef(
           java.math.BigDecimal acumulado,
           java.util.Calendar dthrfrefugo,
           java.util.Calendar dthrivalcic,
           java.util.Calendar dthrivalestru,
           idw.idwws.IjrearefId id,
           idw.idwws.Ijctrliniproc ijctrliniproc,
           idw.idwws.Ijestmol ijestmol,
           idw.idwws.Ijrearefintbet[] ijrearefintbets,
           idw.idwws.Ijrearefoprd[] ijrearefoprds,
           idw.idwws.Ijtbaco ijtbaco,
           idw.idwws.Ijtbcau ijtbcau,
           idw.idwws.Ijtbref ijtbref,
           java.math.BigDecimal lcancelado,
           java.lang.String nrop,
           java.lang.Double qtrefugada,
           org.apache.axis.types.UnsignedShort refreprocesso) {
           this.acumulado = acumulado;
           this.dthrfrefugo = dthrfrefugo;
           this.dthrivalcic = dthrivalcic;
           this.dthrivalestru = dthrivalestru;
           this.id = id;
           this.ijctrliniproc = ijctrliniproc;
           this.ijestmol = ijestmol;
           this.ijrearefintbets = ijrearefintbets;
           this.ijrearefoprds = ijrearefoprds;
           this.ijtbaco = ijtbaco;
           this.ijtbcau = ijtbcau;
           this.ijtbref = ijtbref;
           this.lcancelado = lcancelado;
           this.nrop = nrop;
           this.qtrefugada = qtrefugada;
           this.refreprocesso = refreprocesso;
    }


    /**
     * Gets the acumulado value for this Ijrearef.
     * 
     * @return acumulado
     */
    public java.math.BigDecimal getAcumulado() {
        return acumulado;
    }


    /**
     * Sets the acumulado value for this Ijrearef.
     * 
     * @param acumulado
     */
    public void setAcumulado(java.math.BigDecimal acumulado) {
        this.acumulado = acumulado;
    }


    /**
     * Gets the dthrfrefugo value for this Ijrearef.
     * 
     * @return dthrfrefugo
     */
    public java.util.Calendar getDthrfrefugo() {
        return dthrfrefugo;
    }


    /**
     * Sets the dthrfrefugo value for this Ijrearef.
     * 
     * @param dthrfrefugo
     */
    public void setDthrfrefugo(java.util.Calendar dthrfrefugo) {
        this.dthrfrefugo = dthrfrefugo;
    }


    /**
     * Gets the dthrivalcic value for this Ijrearef.
     * 
     * @return dthrivalcic
     */
    public java.util.Calendar getDthrivalcic() {
        return dthrivalcic;
    }


    /**
     * Sets the dthrivalcic value for this Ijrearef.
     * 
     * @param dthrivalcic
     */
    public void setDthrivalcic(java.util.Calendar dthrivalcic) {
        this.dthrivalcic = dthrivalcic;
    }


    /**
     * Gets the dthrivalestru value for this Ijrearef.
     * 
     * @return dthrivalestru
     */
    public java.util.Calendar getDthrivalestru() {
        return dthrivalestru;
    }


    /**
     * Sets the dthrivalestru value for this Ijrearef.
     * 
     * @param dthrivalestru
     */
    public void setDthrivalestru(java.util.Calendar dthrivalestru) {
        this.dthrivalestru = dthrivalestru;
    }


    /**
     * Gets the id value for this Ijrearef.
     * 
     * @return id
     */
    public idw.idwws.IjrearefId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijrearef.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjrearefId id) {
        this.id = id;
    }


    /**
     * Gets the ijctrliniproc value for this Ijrearef.
     * 
     * @return ijctrliniproc
     */
    public idw.idwws.Ijctrliniproc getIjctrliniproc() {
        return ijctrliniproc;
    }


    /**
     * Sets the ijctrliniproc value for this Ijrearef.
     * 
     * @param ijctrliniproc
     */
    public void setIjctrliniproc(idw.idwws.Ijctrliniproc ijctrliniproc) {
        this.ijctrliniproc = ijctrliniproc;
    }


    /**
     * Gets the ijestmol value for this Ijrearef.
     * 
     * @return ijestmol
     */
    public idw.idwws.Ijestmol getIjestmol() {
        return ijestmol;
    }


    /**
     * Sets the ijestmol value for this Ijrearef.
     * 
     * @param ijestmol
     */
    public void setIjestmol(idw.idwws.Ijestmol ijestmol) {
        this.ijestmol = ijestmol;
    }


    /**
     * Gets the ijrearefintbets value for this Ijrearef.
     * 
     * @return ijrearefintbets
     */
    public idw.idwws.Ijrearefintbet[] getIjrearefintbets() {
        return ijrearefintbets;
    }


    /**
     * Sets the ijrearefintbets value for this Ijrearef.
     * 
     * @param ijrearefintbets
     */
    public void setIjrearefintbets(idw.idwws.Ijrearefintbet[] ijrearefintbets) {
        this.ijrearefintbets = ijrearefintbets;
    }

    public idw.idwws.Ijrearefintbet getIjrearefintbets(int i) {
        return this.ijrearefintbets[i];
    }

    public void setIjrearefintbets(int i, idw.idwws.Ijrearefintbet _value) {
        this.ijrearefintbets[i] = _value;
    }


    /**
     * Gets the ijrearefoprds value for this Ijrearef.
     * 
     * @return ijrearefoprds
     */
    public idw.idwws.Ijrearefoprd[] getIjrearefoprds() {
        return ijrearefoprds;
    }


    /**
     * Sets the ijrearefoprds value for this Ijrearef.
     * 
     * @param ijrearefoprds
     */
    public void setIjrearefoprds(idw.idwws.Ijrearefoprd[] ijrearefoprds) {
        this.ijrearefoprds = ijrearefoprds;
    }

    public idw.idwws.Ijrearefoprd getIjrearefoprds(int i) {
        return this.ijrearefoprds[i];
    }

    public void setIjrearefoprds(int i, idw.idwws.Ijrearefoprd _value) {
        this.ijrearefoprds[i] = _value;
    }


    /**
     * Gets the ijtbaco value for this Ijrearef.
     * 
     * @return ijtbaco
     */
    public idw.idwws.Ijtbaco getIjtbaco() {
        return ijtbaco;
    }


    /**
     * Sets the ijtbaco value for this Ijrearef.
     * 
     * @param ijtbaco
     */
    public void setIjtbaco(idw.idwws.Ijtbaco ijtbaco) {
        this.ijtbaco = ijtbaco;
    }


    /**
     * Gets the ijtbcau value for this Ijrearef.
     * 
     * @return ijtbcau
     */
    public idw.idwws.Ijtbcau getIjtbcau() {
        return ijtbcau;
    }


    /**
     * Sets the ijtbcau value for this Ijrearef.
     * 
     * @param ijtbcau
     */
    public void setIjtbcau(idw.idwws.Ijtbcau ijtbcau) {
        this.ijtbcau = ijtbcau;
    }


    /**
     * Gets the ijtbref value for this Ijrearef.
     * 
     * @return ijtbref
     */
    public idw.idwws.Ijtbref getIjtbref() {
        return ijtbref;
    }


    /**
     * Sets the ijtbref value for this Ijrearef.
     * 
     * @param ijtbref
     */
    public void setIjtbref(idw.idwws.Ijtbref ijtbref) {
        this.ijtbref = ijtbref;
    }


    /**
     * Gets the lcancelado value for this Ijrearef.
     * 
     * @return lcancelado
     */
    public java.math.BigDecimal getLcancelado() {
        return lcancelado;
    }


    /**
     * Sets the lcancelado value for this Ijrearef.
     * 
     * @param lcancelado
     */
    public void setLcancelado(java.math.BigDecimal lcancelado) {
        this.lcancelado = lcancelado;
    }


    /**
     * Gets the nrop value for this Ijrearef.
     * 
     * @return nrop
     */
    public java.lang.String getNrop() {
        return nrop;
    }


    /**
     * Sets the nrop value for this Ijrearef.
     * 
     * @param nrop
     */
    public void setNrop(java.lang.String nrop) {
        this.nrop = nrop;
    }


    /**
     * Gets the qtrefugada value for this Ijrearef.
     * 
     * @return qtrefugada
     */
    public java.lang.Double getQtrefugada() {
        return qtrefugada;
    }


    /**
     * Sets the qtrefugada value for this Ijrearef.
     * 
     * @param qtrefugada
     */
    public void setQtrefugada(java.lang.Double qtrefugada) {
        this.qtrefugada = qtrefugada;
    }


    /**
     * Gets the refreprocesso value for this Ijrearef.
     * 
     * @return refreprocesso
     */
    public org.apache.axis.types.UnsignedShort getRefreprocesso() {
        return refreprocesso;
    }


    /**
     * Sets the refreprocesso value for this Ijrearef.
     * 
     * @param refreprocesso
     */
    public void setRefreprocesso(org.apache.axis.types.UnsignedShort refreprocesso) {
        this.refreprocesso = refreprocesso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijrearef)) return false;
        Ijrearef other = (Ijrearef) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acumulado==null && other.getAcumulado()==null) || 
             (this.acumulado!=null &&
              this.acumulado.equals(other.getAcumulado()))) &&
            ((this.dthrfrefugo==null && other.getDthrfrefugo()==null) || 
             (this.dthrfrefugo!=null &&
              this.dthrfrefugo.equals(other.getDthrfrefugo()))) &&
            ((this.dthrivalcic==null && other.getDthrivalcic()==null) || 
             (this.dthrivalcic!=null &&
              this.dthrivalcic.equals(other.getDthrivalcic()))) &&
            ((this.dthrivalestru==null && other.getDthrivalestru()==null) || 
             (this.dthrivalestru!=null &&
              this.dthrivalestru.equals(other.getDthrivalestru()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijctrliniproc==null && other.getIjctrliniproc()==null) || 
             (this.ijctrliniproc!=null &&
              this.ijctrliniproc.equals(other.getIjctrliniproc()))) &&
            ((this.ijestmol==null && other.getIjestmol()==null) || 
             (this.ijestmol!=null &&
              this.ijestmol.equals(other.getIjestmol()))) &&
            ((this.ijrearefintbets==null && other.getIjrearefintbets()==null) || 
             (this.ijrearefintbets!=null &&
              java.util.Arrays.equals(this.ijrearefintbets, other.getIjrearefintbets()))) &&
            ((this.ijrearefoprds==null && other.getIjrearefoprds()==null) || 
             (this.ijrearefoprds!=null &&
              java.util.Arrays.equals(this.ijrearefoprds, other.getIjrearefoprds()))) &&
            ((this.ijtbaco==null && other.getIjtbaco()==null) || 
             (this.ijtbaco!=null &&
              this.ijtbaco.equals(other.getIjtbaco()))) &&
            ((this.ijtbcau==null && other.getIjtbcau()==null) || 
             (this.ijtbcau!=null &&
              this.ijtbcau.equals(other.getIjtbcau()))) &&
            ((this.ijtbref==null && other.getIjtbref()==null) || 
             (this.ijtbref!=null &&
              this.ijtbref.equals(other.getIjtbref()))) &&
            ((this.lcancelado==null && other.getLcancelado()==null) || 
             (this.lcancelado!=null &&
              this.lcancelado.equals(other.getLcancelado()))) &&
            ((this.nrop==null && other.getNrop()==null) || 
             (this.nrop!=null &&
              this.nrop.equals(other.getNrop()))) &&
            ((this.qtrefugada==null && other.getQtrefugada()==null) || 
             (this.qtrefugada!=null &&
              this.qtrefugada.equals(other.getQtrefugada()))) &&
            ((this.refreprocesso==null && other.getRefreprocesso()==null) || 
             (this.refreprocesso!=null &&
              this.refreprocesso.equals(other.getRefreprocesso())));
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
        if (getAcumulado() != null) {
            _hashCode += getAcumulado().hashCode();
        }
        if (getDthrfrefugo() != null) {
            _hashCode += getDthrfrefugo().hashCode();
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
        if (getIjctrliniproc() != null) {
            _hashCode += getIjctrliniproc().hashCode();
        }
        if (getIjestmol() != null) {
            _hashCode += getIjestmol().hashCode();
        }
        if (getIjrearefintbets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrearefintbets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrearefintbets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrearefoprds() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrearefoprds());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrearefoprds(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbaco() != null) {
            _hashCode += getIjtbaco().hashCode();
        }
        if (getIjtbcau() != null) {
            _hashCode += getIjtbcau().hashCode();
        }
        if (getIjtbref() != null) {
            _hashCode += getIjtbref().hashCode();
        }
        if (getLcancelado() != null) {
            _hashCode += getLcancelado().hashCode();
        }
        if (getNrop() != null) {
            _hashCode += getNrop().hashCode();
        }
        if (getQtrefugada() != null) {
            _hashCode += getQtrefugada().hashCode();
        }
        if (getRefreprocesso() != null) {
            _hashCode += getRefreprocesso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijrearef.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearef"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acumulado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acumulado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfrefugo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfrefugo"));
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
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearefId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrliniproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproc"));
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
        elemField.setFieldName("ijrearefintbets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrearefintbets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearefintbet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrearefoprds");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrearefoprds"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearefoprd"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbaco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbaco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbaco"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbcau");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbcau"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbcau"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbref");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbref"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbref"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lcancelado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lcancelado"));
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
        elemField.setFieldName("qtrefugada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qtrefugada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("refreprocesso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "refreprocesso"));
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
