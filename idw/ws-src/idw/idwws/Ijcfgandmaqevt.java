/**
 * Ijcfgandmaqevt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijcfgandmaqevt  implements java.io.Serializable {
    private double ideventoandon;

    private idw.idwws.Ijcfgandmaqevtarg[] ijcfgandmaqevtargs;

    private idw.idwws.Ijcfgandonagrup[] ijcfgandonagrupsForIdeventoandon;

    private idw.idwws.Ijcfgandonagrup[] ijcfgandonagrupsForIdeventoandon2;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbrele ijtbrele;

    private idw.idwws.Ijtbtpeventoandon ijtbtpeventoandon;

    private java.math.BigDecimal prioridade;

    private java.math.BigDecimal stativo;

    private java.math.BigDecimal stexclusao;

    private java.math.BigDecimal stintermitente;

    private org.apache.axis.types.UnsignedShort stsincronismo;

    private java.math.BigDecimal tmpsinalalto;

    private java.math.BigDecimal tmpsinalbaixo;

    public Ijcfgandmaqevt() {
    }

    public Ijcfgandmaqevt(
           double ideventoandon,
           idw.idwws.Ijcfgandmaqevtarg[] ijcfgandmaqevtargs,
           idw.idwws.Ijcfgandonagrup[] ijcfgandonagrupsForIdeventoandon,
           idw.idwws.Ijcfgandonagrup[] ijcfgandonagrupsForIdeventoandon2,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbrele ijtbrele,
           idw.idwws.Ijtbtpeventoandon ijtbtpeventoandon,
           java.math.BigDecimal prioridade,
           java.math.BigDecimal stativo,
           java.math.BigDecimal stexclusao,
           java.math.BigDecimal stintermitente,
           org.apache.axis.types.UnsignedShort stsincronismo,
           java.math.BigDecimal tmpsinalalto,
           java.math.BigDecimal tmpsinalbaixo) {
           this.ideventoandon = ideventoandon;
           this.ijcfgandmaqevtargs = ijcfgandmaqevtargs;
           this.ijcfgandonagrupsForIdeventoandon = ijcfgandonagrupsForIdeventoandon;
           this.ijcfgandonagrupsForIdeventoandon2 = ijcfgandonagrupsForIdeventoandon2;
           this.ijtbinj = ijtbinj;
           this.ijtbrele = ijtbrele;
           this.ijtbtpeventoandon = ijtbtpeventoandon;
           this.prioridade = prioridade;
           this.stativo = stativo;
           this.stexclusao = stexclusao;
           this.stintermitente = stintermitente;
           this.stsincronismo = stsincronismo;
           this.tmpsinalalto = tmpsinalalto;
           this.tmpsinalbaixo = tmpsinalbaixo;
    }


    /**
     * Gets the ideventoandon value for this Ijcfgandmaqevt.
     * 
     * @return ideventoandon
     */
    public double getIdeventoandon() {
        return ideventoandon;
    }


    /**
     * Sets the ideventoandon value for this Ijcfgandmaqevt.
     * 
     * @param ideventoandon
     */
    public void setIdeventoandon(double ideventoandon) {
        this.ideventoandon = ideventoandon;
    }


    /**
     * Gets the ijcfgandmaqevtargs value for this Ijcfgandmaqevt.
     * 
     * @return ijcfgandmaqevtargs
     */
    public idw.idwws.Ijcfgandmaqevtarg[] getIjcfgandmaqevtargs() {
        return ijcfgandmaqevtargs;
    }


    /**
     * Sets the ijcfgandmaqevtargs value for this Ijcfgandmaqevt.
     * 
     * @param ijcfgandmaqevtargs
     */
    public void setIjcfgandmaqevtargs(idw.idwws.Ijcfgandmaqevtarg[] ijcfgandmaqevtargs) {
        this.ijcfgandmaqevtargs = ijcfgandmaqevtargs;
    }

    public idw.idwws.Ijcfgandmaqevtarg getIjcfgandmaqevtargs(int i) {
        return this.ijcfgandmaqevtargs[i];
    }

    public void setIjcfgandmaqevtargs(int i, idw.idwws.Ijcfgandmaqevtarg _value) {
        this.ijcfgandmaqevtargs[i] = _value;
    }


    /**
     * Gets the ijcfgandonagrupsForIdeventoandon value for this Ijcfgandmaqevt.
     * 
     * @return ijcfgandonagrupsForIdeventoandon
     */
    public idw.idwws.Ijcfgandonagrup[] getIjcfgandonagrupsForIdeventoandon() {
        return ijcfgandonagrupsForIdeventoandon;
    }


    /**
     * Sets the ijcfgandonagrupsForIdeventoandon value for this Ijcfgandmaqevt.
     * 
     * @param ijcfgandonagrupsForIdeventoandon
     */
    public void setIjcfgandonagrupsForIdeventoandon(idw.idwws.Ijcfgandonagrup[] ijcfgandonagrupsForIdeventoandon) {
        this.ijcfgandonagrupsForIdeventoandon = ijcfgandonagrupsForIdeventoandon;
    }

    public idw.idwws.Ijcfgandonagrup getIjcfgandonagrupsForIdeventoandon(int i) {
        return this.ijcfgandonagrupsForIdeventoandon[i];
    }

    public void setIjcfgandonagrupsForIdeventoandon(int i, idw.idwws.Ijcfgandonagrup _value) {
        this.ijcfgandonagrupsForIdeventoandon[i] = _value;
    }


    /**
     * Gets the ijcfgandonagrupsForIdeventoandon2 value for this Ijcfgandmaqevt.
     * 
     * @return ijcfgandonagrupsForIdeventoandon2
     */
    public idw.idwws.Ijcfgandonagrup[] getIjcfgandonagrupsForIdeventoandon2() {
        return ijcfgandonagrupsForIdeventoandon2;
    }


    /**
     * Sets the ijcfgandonagrupsForIdeventoandon2 value for this Ijcfgandmaqevt.
     * 
     * @param ijcfgandonagrupsForIdeventoandon2
     */
    public void setIjcfgandonagrupsForIdeventoandon2(idw.idwws.Ijcfgandonagrup[] ijcfgandonagrupsForIdeventoandon2) {
        this.ijcfgandonagrupsForIdeventoandon2 = ijcfgandonagrupsForIdeventoandon2;
    }

    public idw.idwws.Ijcfgandonagrup getIjcfgandonagrupsForIdeventoandon2(int i) {
        return this.ijcfgandonagrupsForIdeventoandon2[i];
    }

    public void setIjcfgandonagrupsForIdeventoandon2(int i, idw.idwws.Ijcfgandonagrup _value) {
        this.ijcfgandonagrupsForIdeventoandon2[i] = _value;
    }


    /**
     * Gets the ijtbinj value for this Ijcfgandmaqevt.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijcfgandmaqevt.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbrele value for this Ijcfgandmaqevt.
     * 
     * @return ijtbrele
     */
    public idw.idwws.Ijtbrele getIjtbrele() {
        return ijtbrele;
    }


    /**
     * Sets the ijtbrele value for this Ijcfgandmaqevt.
     * 
     * @param ijtbrele
     */
    public void setIjtbrele(idw.idwws.Ijtbrele ijtbrele) {
        this.ijtbrele = ijtbrele;
    }


    /**
     * Gets the ijtbtpeventoandon value for this Ijcfgandmaqevt.
     * 
     * @return ijtbtpeventoandon
     */
    public idw.idwws.Ijtbtpeventoandon getIjtbtpeventoandon() {
        return ijtbtpeventoandon;
    }


    /**
     * Sets the ijtbtpeventoandon value for this Ijcfgandmaqevt.
     * 
     * @param ijtbtpeventoandon
     */
    public void setIjtbtpeventoandon(idw.idwws.Ijtbtpeventoandon ijtbtpeventoandon) {
        this.ijtbtpeventoandon = ijtbtpeventoandon;
    }


    /**
     * Gets the prioridade value for this Ijcfgandmaqevt.
     * 
     * @return prioridade
     */
    public java.math.BigDecimal getPrioridade() {
        return prioridade;
    }


    /**
     * Sets the prioridade value for this Ijcfgandmaqevt.
     * 
     * @param prioridade
     */
    public void setPrioridade(java.math.BigDecimal prioridade) {
        this.prioridade = prioridade;
    }


    /**
     * Gets the stativo value for this Ijcfgandmaqevt.
     * 
     * @return stativo
     */
    public java.math.BigDecimal getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijcfgandmaqevt.
     * 
     * @param stativo
     */
    public void setStativo(java.math.BigDecimal stativo) {
        this.stativo = stativo;
    }


    /**
     * Gets the stexclusao value for this Ijcfgandmaqevt.
     * 
     * @return stexclusao
     */
    public java.math.BigDecimal getStexclusao() {
        return stexclusao;
    }


    /**
     * Sets the stexclusao value for this Ijcfgandmaqevt.
     * 
     * @param stexclusao
     */
    public void setStexclusao(java.math.BigDecimal stexclusao) {
        this.stexclusao = stexclusao;
    }


    /**
     * Gets the stintermitente value for this Ijcfgandmaqevt.
     * 
     * @return stintermitente
     */
    public java.math.BigDecimal getStintermitente() {
        return stintermitente;
    }


    /**
     * Sets the stintermitente value for this Ijcfgandmaqevt.
     * 
     * @param stintermitente
     */
    public void setStintermitente(java.math.BigDecimal stintermitente) {
        this.stintermitente = stintermitente;
    }


    /**
     * Gets the stsincronismo value for this Ijcfgandmaqevt.
     * 
     * @return stsincronismo
     */
    public org.apache.axis.types.UnsignedShort getStsincronismo() {
        return stsincronismo;
    }


    /**
     * Sets the stsincronismo value for this Ijcfgandmaqevt.
     * 
     * @param stsincronismo
     */
    public void setStsincronismo(org.apache.axis.types.UnsignedShort stsincronismo) {
        this.stsincronismo = stsincronismo;
    }


    /**
     * Gets the tmpsinalalto value for this Ijcfgandmaqevt.
     * 
     * @return tmpsinalalto
     */
    public java.math.BigDecimal getTmpsinalalto() {
        return tmpsinalalto;
    }


    /**
     * Sets the tmpsinalalto value for this Ijcfgandmaqevt.
     * 
     * @param tmpsinalalto
     */
    public void setTmpsinalalto(java.math.BigDecimal tmpsinalalto) {
        this.tmpsinalalto = tmpsinalalto;
    }


    /**
     * Gets the tmpsinalbaixo value for this Ijcfgandmaqevt.
     * 
     * @return tmpsinalbaixo
     */
    public java.math.BigDecimal getTmpsinalbaixo() {
        return tmpsinalbaixo;
    }


    /**
     * Sets the tmpsinalbaixo value for this Ijcfgandmaqevt.
     * 
     * @param tmpsinalbaixo
     */
    public void setTmpsinalbaixo(java.math.BigDecimal tmpsinalbaixo) {
        this.tmpsinalbaixo = tmpsinalbaixo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijcfgandmaqevt)) return false;
        Ijcfgandmaqevt other = (Ijcfgandmaqevt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.ideventoandon == other.getIdeventoandon() &&
            ((this.ijcfgandmaqevtargs==null && other.getIjcfgandmaqevtargs()==null) || 
             (this.ijcfgandmaqevtargs!=null &&
              java.util.Arrays.equals(this.ijcfgandmaqevtargs, other.getIjcfgandmaqevtargs()))) &&
            ((this.ijcfgandonagrupsForIdeventoandon==null && other.getIjcfgandonagrupsForIdeventoandon()==null) || 
             (this.ijcfgandonagrupsForIdeventoandon!=null &&
              java.util.Arrays.equals(this.ijcfgandonagrupsForIdeventoandon, other.getIjcfgandonagrupsForIdeventoandon()))) &&
            ((this.ijcfgandonagrupsForIdeventoandon2==null && other.getIjcfgandonagrupsForIdeventoandon2()==null) || 
             (this.ijcfgandonagrupsForIdeventoandon2!=null &&
              java.util.Arrays.equals(this.ijcfgandonagrupsForIdeventoandon2, other.getIjcfgandonagrupsForIdeventoandon2()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbrele==null && other.getIjtbrele()==null) || 
             (this.ijtbrele!=null &&
              this.ijtbrele.equals(other.getIjtbrele()))) &&
            ((this.ijtbtpeventoandon==null && other.getIjtbtpeventoandon()==null) || 
             (this.ijtbtpeventoandon!=null &&
              this.ijtbtpeventoandon.equals(other.getIjtbtpeventoandon()))) &&
            ((this.prioridade==null && other.getPrioridade()==null) || 
             (this.prioridade!=null &&
              this.prioridade.equals(other.getPrioridade()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo()))) &&
            ((this.stexclusao==null && other.getStexclusao()==null) || 
             (this.stexclusao!=null &&
              this.stexclusao.equals(other.getStexclusao()))) &&
            ((this.stintermitente==null && other.getStintermitente()==null) || 
             (this.stintermitente!=null &&
              this.stintermitente.equals(other.getStintermitente()))) &&
            ((this.stsincronismo==null && other.getStsincronismo()==null) || 
             (this.stsincronismo!=null &&
              this.stsincronismo.equals(other.getStsincronismo()))) &&
            ((this.tmpsinalalto==null && other.getTmpsinalalto()==null) || 
             (this.tmpsinalalto!=null &&
              this.tmpsinalalto.equals(other.getTmpsinalalto()))) &&
            ((this.tmpsinalbaixo==null && other.getTmpsinalbaixo()==null) || 
             (this.tmpsinalbaixo!=null &&
              this.tmpsinalbaixo.equals(other.getTmpsinalbaixo())));
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
        _hashCode += new Double(getIdeventoandon()).hashCode();
        if (getIjcfgandmaqevtargs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcfgandmaqevtargs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcfgandmaqevtargs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjcfgandonagrupsForIdeventoandon() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcfgandonagrupsForIdeventoandon());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcfgandonagrupsForIdeventoandon(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjcfgandonagrupsForIdeventoandon2() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjcfgandonagrupsForIdeventoandon2());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjcfgandonagrupsForIdeventoandon2(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbrele() != null) {
            _hashCode += getIjtbrele().hashCode();
        }
        if (getIjtbtpeventoandon() != null) {
            _hashCode += getIjtbtpeventoandon().hashCode();
        }
        if (getPrioridade() != null) {
            _hashCode += getPrioridade().hashCode();
        }
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        if (getStexclusao() != null) {
            _hashCode += getStexclusao().hashCode();
        }
        if (getStintermitente() != null) {
            _hashCode += getStintermitente().hashCode();
        }
        if (getStsincronismo() != null) {
            _hashCode += getStsincronismo().hashCode();
        }
        if (getTmpsinalalto() != null) {
            _hashCode += getTmpsinalalto().hashCode();
        }
        if (getTmpsinalbaixo() != null) {
            _hashCode += getTmpsinalbaixo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijcfgandmaqevt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandmaqevt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ideventoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ideventoandon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcfgandmaqevtargs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcfgandmaqevtargs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandmaqevtarg"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcfgandonagrupsForIdeventoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcfgandonagrupsForIdeventoandon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandonagrup"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijcfgandonagrupsForIdeventoandon2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijcfgandonagrupsForIdeventoandon2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijcfgandonagrup"));
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
        elemField.setFieldName("ijtbrele");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbrele"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbrele"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbtpeventoandon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbtpeventoandon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbtpeventoandon"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prioridade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prioridade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stexclusao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stexclusao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stintermitente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stintermitente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stsincronismo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stsincronismo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpsinalalto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpsinalalto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tmpsinalbaixo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tmpsinalbaixo"));
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
