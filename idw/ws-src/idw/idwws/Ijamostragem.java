/**
 * Ijamostragem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijamostragem  implements java.io.Serializable {
    private double amplitudevllidos;

    private double cavidade;

    private java.lang.String cdmolvalespecific;

    private org.apache.axis.types.UnsignedShort compoemedia;

    private java.util.Calendar dthrivalespecific;

    private java.lang.String idamostragem;

    private java.lang.String idespecific;

    private idw.idwws.Ijamostragemdet[] ijamostragemdets;

    private idw.idwws.Ijamstraltcgq[] ijamstraltcgqs;

    private idw.idwws.Ijamstrmedias[] ijamstrmediasesForIdamostragem;

    private idw.idwws.Ijamstrmedias[] ijamstrmediasesForIdamstrmedia;

    private idw.idwws.Ijinspecao ijinspecao;

    private double mediavllidos;

    private org.apache.axis.types.UnsignedShort resultado;

    private org.apache.axis.types.UnsignedShort stamostragem;

    public Ijamostragem() {
    }

    public Ijamostragem(
           double amplitudevllidos,
           double cavidade,
           java.lang.String cdmolvalespecific,
           org.apache.axis.types.UnsignedShort compoemedia,
           java.util.Calendar dthrivalespecific,
           java.lang.String idamostragem,
           java.lang.String idespecific,
           idw.idwws.Ijamostragemdet[] ijamostragemdets,
           idw.idwws.Ijamstraltcgq[] ijamstraltcgqs,
           idw.idwws.Ijamstrmedias[] ijamstrmediasesForIdamostragem,
           idw.idwws.Ijamstrmedias[] ijamstrmediasesForIdamstrmedia,
           idw.idwws.Ijinspecao ijinspecao,
           double mediavllidos,
           org.apache.axis.types.UnsignedShort resultado,
           org.apache.axis.types.UnsignedShort stamostragem) {
           this.amplitudevllidos = amplitudevllidos;
           this.cavidade = cavidade;
           this.cdmolvalespecific = cdmolvalespecific;
           this.compoemedia = compoemedia;
           this.dthrivalespecific = dthrivalespecific;
           this.idamostragem = idamostragem;
           this.idespecific = idespecific;
           this.ijamostragemdets = ijamostragemdets;
           this.ijamstraltcgqs = ijamstraltcgqs;
           this.ijamstrmediasesForIdamostragem = ijamstrmediasesForIdamostragem;
           this.ijamstrmediasesForIdamstrmedia = ijamstrmediasesForIdamstrmedia;
           this.ijinspecao = ijinspecao;
           this.mediavllidos = mediavllidos;
           this.resultado = resultado;
           this.stamostragem = stamostragem;
    }


    /**
     * Gets the amplitudevllidos value for this Ijamostragem.
     * 
     * @return amplitudevllidos
     */
    public double getAmplitudevllidos() {
        return amplitudevllidos;
    }


    /**
     * Sets the amplitudevllidos value for this Ijamostragem.
     * 
     * @param amplitudevllidos
     */
    public void setAmplitudevllidos(double amplitudevllidos) {
        this.amplitudevllidos = amplitudevllidos;
    }


    /**
     * Gets the cavidade value for this Ijamostragem.
     * 
     * @return cavidade
     */
    public double getCavidade() {
        return cavidade;
    }


    /**
     * Sets the cavidade value for this Ijamostragem.
     * 
     * @param cavidade
     */
    public void setCavidade(double cavidade) {
        this.cavidade = cavidade;
    }


    /**
     * Gets the cdmolvalespecific value for this Ijamostragem.
     * 
     * @return cdmolvalespecific
     */
    public java.lang.String getCdmolvalespecific() {
        return cdmolvalespecific;
    }


    /**
     * Sets the cdmolvalespecific value for this Ijamostragem.
     * 
     * @param cdmolvalespecific
     */
    public void setCdmolvalespecific(java.lang.String cdmolvalespecific) {
        this.cdmolvalespecific = cdmolvalespecific;
    }


    /**
     * Gets the compoemedia value for this Ijamostragem.
     * 
     * @return compoemedia
     */
    public org.apache.axis.types.UnsignedShort getCompoemedia() {
        return compoemedia;
    }


    /**
     * Sets the compoemedia value for this Ijamostragem.
     * 
     * @param compoemedia
     */
    public void setCompoemedia(org.apache.axis.types.UnsignedShort compoemedia) {
        this.compoemedia = compoemedia;
    }


    /**
     * Gets the dthrivalespecific value for this Ijamostragem.
     * 
     * @return dthrivalespecific
     */
    public java.util.Calendar getDthrivalespecific() {
        return dthrivalespecific;
    }


    /**
     * Sets the dthrivalespecific value for this Ijamostragem.
     * 
     * @param dthrivalespecific
     */
    public void setDthrivalespecific(java.util.Calendar dthrivalespecific) {
        this.dthrivalespecific = dthrivalespecific;
    }


    /**
     * Gets the idamostragem value for this Ijamostragem.
     * 
     * @return idamostragem
     */
    public java.lang.String getIdamostragem() {
        return idamostragem;
    }


    /**
     * Sets the idamostragem value for this Ijamostragem.
     * 
     * @param idamostragem
     */
    public void setIdamostragem(java.lang.String idamostragem) {
        this.idamostragem = idamostragem;
    }


    /**
     * Gets the idespecific value for this Ijamostragem.
     * 
     * @return idespecific
     */
    public java.lang.String getIdespecific() {
        return idespecific;
    }


    /**
     * Sets the idespecific value for this Ijamostragem.
     * 
     * @param idespecific
     */
    public void setIdespecific(java.lang.String idespecific) {
        this.idespecific = idespecific;
    }


    /**
     * Gets the ijamostragemdets value for this Ijamostragem.
     * 
     * @return ijamostragemdets
     */
    public idw.idwws.Ijamostragemdet[] getIjamostragemdets() {
        return ijamostragemdets;
    }


    /**
     * Sets the ijamostragemdets value for this Ijamostragem.
     * 
     * @param ijamostragemdets
     */
    public void setIjamostragemdets(idw.idwws.Ijamostragemdet[] ijamostragemdets) {
        this.ijamostragemdets = ijamostragemdets;
    }

    public idw.idwws.Ijamostragemdet getIjamostragemdets(int i) {
        return this.ijamostragemdets[i];
    }

    public void setIjamostragemdets(int i, idw.idwws.Ijamostragemdet _value) {
        this.ijamostragemdets[i] = _value;
    }


    /**
     * Gets the ijamstraltcgqs value for this Ijamostragem.
     * 
     * @return ijamstraltcgqs
     */
    public idw.idwws.Ijamstraltcgq[] getIjamstraltcgqs() {
        return ijamstraltcgqs;
    }


    /**
     * Sets the ijamstraltcgqs value for this Ijamostragem.
     * 
     * @param ijamstraltcgqs
     */
    public void setIjamstraltcgqs(idw.idwws.Ijamstraltcgq[] ijamstraltcgqs) {
        this.ijamstraltcgqs = ijamstraltcgqs;
    }

    public idw.idwws.Ijamstraltcgq getIjamstraltcgqs(int i) {
        return this.ijamstraltcgqs[i];
    }

    public void setIjamstraltcgqs(int i, idw.idwws.Ijamstraltcgq _value) {
        this.ijamstraltcgqs[i] = _value;
    }


    /**
     * Gets the ijamstrmediasesForIdamostragem value for this Ijamostragem.
     * 
     * @return ijamstrmediasesForIdamostragem
     */
    public idw.idwws.Ijamstrmedias[] getIjamstrmediasesForIdamostragem() {
        return ijamstrmediasesForIdamostragem;
    }


    /**
     * Sets the ijamstrmediasesForIdamostragem value for this Ijamostragem.
     * 
     * @param ijamstrmediasesForIdamostragem
     */
    public void setIjamstrmediasesForIdamostragem(idw.idwws.Ijamstrmedias[] ijamstrmediasesForIdamostragem) {
        this.ijamstrmediasesForIdamostragem = ijamstrmediasesForIdamostragem;
    }

    public idw.idwws.Ijamstrmedias getIjamstrmediasesForIdamostragem(int i) {
        return this.ijamstrmediasesForIdamostragem[i];
    }

    public void setIjamstrmediasesForIdamostragem(int i, idw.idwws.Ijamstrmedias _value) {
        this.ijamstrmediasesForIdamostragem[i] = _value;
    }


    /**
     * Gets the ijamstrmediasesForIdamstrmedia value for this Ijamostragem.
     * 
     * @return ijamstrmediasesForIdamstrmedia
     */
    public idw.idwws.Ijamstrmedias[] getIjamstrmediasesForIdamstrmedia() {
        return ijamstrmediasesForIdamstrmedia;
    }


    /**
     * Sets the ijamstrmediasesForIdamstrmedia value for this Ijamostragem.
     * 
     * @param ijamstrmediasesForIdamstrmedia
     */
    public void setIjamstrmediasesForIdamstrmedia(idw.idwws.Ijamstrmedias[] ijamstrmediasesForIdamstrmedia) {
        this.ijamstrmediasesForIdamstrmedia = ijamstrmediasesForIdamstrmedia;
    }

    public idw.idwws.Ijamstrmedias getIjamstrmediasesForIdamstrmedia(int i) {
        return this.ijamstrmediasesForIdamstrmedia[i];
    }

    public void setIjamstrmediasesForIdamstrmedia(int i, idw.idwws.Ijamstrmedias _value) {
        this.ijamstrmediasesForIdamstrmedia[i] = _value;
    }


    /**
     * Gets the ijinspecao value for this Ijamostragem.
     * 
     * @return ijinspecao
     */
    public idw.idwws.Ijinspecao getIjinspecao() {
        return ijinspecao;
    }


    /**
     * Sets the ijinspecao value for this Ijamostragem.
     * 
     * @param ijinspecao
     */
    public void setIjinspecao(idw.idwws.Ijinspecao ijinspecao) {
        this.ijinspecao = ijinspecao;
    }


    /**
     * Gets the mediavllidos value for this Ijamostragem.
     * 
     * @return mediavllidos
     */
    public double getMediavllidos() {
        return mediavllidos;
    }


    /**
     * Sets the mediavllidos value for this Ijamostragem.
     * 
     * @param mediavllidos
     */
    public void setMediavllidos(double mediavllidos) {
        this.mediavllidos = mediavllidos;
    }


    /**
     * Gets the resultado value for this Ijamostragem.
     * 
     * @return resultado
     */
    public org.apache.axis.types.UnsignedShort getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this Ijamostragem.
     * 
     * @param resultado
     */
    public void setResultado(org.apache.axis.types.UnsignedShort resultado) {
        this.resultado = resultado;
    }


    /**
     * Gets the stamostragem value for this Ijamostragem.
     * 
     * @return stamostragem
     */
    public org.apache.axis.types.UnsignedShort getStamostragem() {
        return stamostragem;
    }


    /**
     * Sets the stamostragem value for this Ijamostragem.
     * 
     * @param stamostragem
     */
    public void setStamostragem(org.apache.axis.types.UnsignedShort stamostragem) {
        this.stamostragem = stamostragem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijamostragem)) return false;
        Ijamostragem other = (Ijamostragem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.amplitudevllidos == other.getAmplitudevllidos() &&
            this.cavidade == other.getCavidade() &&
            ((this.cdmolvalespecific==null && other.getCdmolvalespecific()==null) || 
             (this.cdmolvalespecific!=null &&
              this.cdmolvalespecific.equals(other.getCdmolvalespecific()))) &&
            ((this.compoemedia==null && other.getCompoemedia()==null) || 
             (this.compoemedia!=null &&
              this.compoemedia.equals(other.getCompoemedia()))) &&
            ((this.dthrivalespecific==null && other.getDthrivalespecific()==null) || 
             (this.dthrivalespecific!=null &&
              this.dthrivalespecific.equals(other.getDthrivalespecific()))) &&
            ((this.idamostragem==null && other.getIdamostragem()==null) || 
             (this.idamostragem!=null &&
              this.idamostragem.equals(other.getIdamostragem()))) &&
            ((this.idespecific==null && other.getIdespecific()==null) || 
             (this.idespecific!=null &&
              this.idespecific.equals(other.getIdespecific()))) &&
            ((this.ijamostragemdets==null && other.getIjamostragemdets()==null) || 
             (this.ijamostragemdets!=null &&
              java.util.Arrays.equals(this.ijamostragemdets, other.getIjamostragemdets()))) &&
            ((this.ijamstraltcgqs==null && other.getIjamstraltcgqs()==null) || 
             (this.ijamstraltcgqs!=null &&
              java.util.Arrays.equals(this.ijamstraltcgqs, other.getIjamstraltcgqs()))) &&
            ((this.ijamstrmediasesForIdamostragem==null && other.getIjamstrmediasesForIdamostragem()==null) || 
             (this.ijamstrmediasesForIdamostragem!=null &&
              java.util.Arrays.equals(this.ijamstrmediasesForIdamostragem, other.getIjamstrmediasesForIdamostragem()))) &&
            ((this.ijamstrmediasesForIdamstrmedia==null && other.getIjamstrmediasesForIdamstrmedia()==null) || 
             (this.ijamstrmediasesForIdamstrmedia!=null &&
              java.util.Arrays.equals(this.ijamstrmediasesForIdamstrmedia, other.getIjamstrmediasesForIdamstrmedia()))) &&
            ((this.ijinspecao==null && other.getIjinspecao()==null) || 
             (this.ijinspecao!=null &&
              this.ijinspecao.equals(other.getIjinspecao()))) &&
            this.mediavllidos == other.getMediavllidos() &&
            ((this.resultado==null && other.getResultado()==null) || 
             (this.resultado!=null &&
              this.resultado.equals(other.getResultado()))) &&
            ((this.stamostragem==null && other.getStamostragem()==null) || 
             (this.stamostragem!=null &&
              this.stamostragem.equals(other.getStamostragem())));
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
        _hashCode += new Double(getAmplitudevllidos()).hashCode();
        _hashCode += new Double(getCavidade()).hashCode();
        if (getCdmolvalespecific() != null) {
            _hashCode += getCdmolvalespecific().hashCode();
        }
        if (getCompoemedia() != null) {
            _hashCode += getCompoemedia().hashCode();
        }
        if (getDthrivalespecific() != null) {
            _hashCode += getDthrivalespecific().hashCode();
        }
        if (getIdamostragem() != null) {
            _hashCode += getIdamostragem().hashCode();
        }
        if (getIdespecific() != null) {
            _hashCode += getIdespecific().hashCode();
        }
        if (getIjamostragemdets() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamostragemdets());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamostragemdets(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjamstraltcgqs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamstraltcgqs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamstraltcgqs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjamstrmediasesForIdamostragem() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamstrmediasesForIdamostragem());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamstrmediasesForIdamostragem(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjamstrmediasesForIdamstrmedia() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjamstrmediasesForIdamstrmedia());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjamstrmediasesForIdamstrmedia(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjinspecao() != null) {
            _hashCode += getIjinspecao().hashCode();
        }
        _hashCode += new Double(getMediavllidos()).hashCode();
        if (getResultado() != null) {
            _hashCode += getResultado().hashCode();
        }
        if (getStamostragem() != null) {
            _hashCode += getStamostragem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijamostragem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amplitudevllidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amplitudevllidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cavidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cavidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdmolvalespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdmolvalespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compoemedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "compoemedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrivalespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrivalespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idamostragem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idamostragem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idespecific");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idespecific"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamostragemdets");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamostragemdets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamostragemdet"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamstraltcgqs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamstraltcgqs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstraltcgq"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamstrmediasesForIdamostragem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamstrmediasesForIdamostragem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrmedias"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijamstrmediasesForIdamstrmedia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijamstrmediasesForIdamstrmedia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijamstrmedias"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijinspecao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijinspecao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijinspecao"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mediavllidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mediavllidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stamostragem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stamostragem"));
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
