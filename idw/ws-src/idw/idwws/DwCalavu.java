/**
 * DwCalavu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwCalavu  extends idw.idwws.DwCalavuTemplate  implements java.io.Serializable {
    private java.util.Calendar dtAvulso;

    private idw.idwws.DwCal dwCal;

    private idw.idwws.DwCalsem dwCalsem;

    private idw.idwws.DwTurno dwTurno;

    private java.math.BigDecimal hrFinal;

    private java.lang.String hrFinalGui;

    private java.lang.String hrInicialGui;

    private java.math.BigDecimal hrinicial;

    private long idCalavu;

    private java.lang.Boolean isCalsemdesativado;

    private java.lang.Boolean isFimturno;

    private java.lang.Boolean isInicioturno;

    private java.math.BigDecimal segTempocalendario;

    private java.math.BigDecimal segTempocalsempeso;

    private java.math.BigDecimal segToleranciapos;

    private java.math.BigDecimal segToleranciapre;

    private java.lang.Byte tpCalavu;

    private java.lang.Byte tpDtreferencia;

    public DwCalavu() {
    }

    public DwCalavu(
           java.util.Calendar dtAvulso,
           idw.idwws.DwCal dwCal,
           idw.idwws.DwCalsem dwCalsem,
           idw.idwws.DwTurno dwTurno,
           java.math.BigDecimal hrFinal,
           java.lang.String hrFinalGui,
           java.lang.String hrInicialGui,
           java.math.BigDecimal hrinicial,
           long idCalavu,
           java.lang.Boolean isCalsemdesativado,
           java.lang.Boolean isFimturno,
           java.lang.Boolean isInicioturno,
           java.math.BigDecimal segTempocalendario,
           java.math.BigDecimal segTempocalsempeso,
           java.math.BigDecimal segToleranciapos,
           java.math.BigDecimal segToleranciapre,
           java.lang.Byte tpCalavu,
           java.lang.Byte tpDtreferencia) {
        this.dtAvulso = dtAvulso;
        this.dwCal = dwCal;
        this.dwCalsem = dwCalsem;
        this.dwTurno = dwTurno;
        this.hrFinal = hrFinal;
        this.hrFinalGui = hrFinalGui;
        this.hrInicialGui = hrInicialGui;
        this.hrinicial = hrinicial;
        this.idCalavu = idCalavu;
        this.isCalsemdesativado = isCalsemdesativado;
        this.isFimturno = isFimturno;
        this.isInicioturno = isInicioturno;
        this.segTempocalendario = segTempocalendario;
        this.segTempocalsempeso = segTempocalsempeso;
        this.segToleranciapos = segToleranciapos;
        this.segToleranciapre = segToleranciapre;
        this.tpCalavu = tpCalavu;
        this.tpDtreferencia = tpDtreferencia;
    }


    /**
     * Gets the dtAvulso value for this DwCalavu.
     * 
     * @return dtAvulso
     */
    public java.util.Calendar getDtAvulso() {
        return dtAvulso;
    }


    /**
     * Sets the dtAvulso value for this DwCalavu.
     * 
     * @param dtAvulso
     */
    public void setDtAvulso(java.util.Calendar dtAvulso) {
        this.dtAvulso = dtAvulso;
    }


    /**
     * Gets the dwCal value for this DwCalavu.
     * 
     * @return dwCal
     */
    public idw.idwws.DwCal getDwCal() {
        return dwCal;
    }


    /**
     * Sets the dwCal value for this DwCalavu.
     * 
     * @param dwCal
     */
    public void setDwCal(idw.idwws.DwCal dwCal) {
        this.dwCal = dwCal;
    }


    /**
     * Gets the dwCalsem value for this DwCalavu.
     * 
     * @return dwCalsem
     */
    public idw.idwws.DwCalsem getDwCalsem() {
        return dwCalsem;
    }


    /**
     * Sets the dwCalsem value for this DwCalavu.
     * 
     * @param dwCalsem
     */
    public void setDwCalsem(idw.idwws.DwCalsem dwCalsem) {
        this.dwCalsem = dwCalsem;
    }


    /**
     * Gets the dwTurno value for this DwCalavu.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this DwCalavu.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the hrFinal value for this DwCalavu.
     * 
     * @return hrFinal
     */
    public java.math.BigDecimal getHrFinal() {
        return hrFinal;
    }


    /**
     * Sets the hrFinal value for this DwCalavu.
     * 
     * @param hrFinal
     */
    public void setHrFinal(java.math.BigDecimal hrFinal) {
        this.hrFinal = hrFinal;
    }


    /**
     * Gets the hrFinalGui value for this DwCalavu.
     * 
     * @return hrFinalGui
     */
    public java.lang.String getHrFinalGui() {
        return hrFinalGui;
    }


    /**
     * Sets the hrFinalGui value for this DwCalavu.
     * 
     * @param hrFinalGui
     */
    public void setHrFinalGui(java.lang.String hrFinalGui) {
        this.hrFinalGui = hrFinalGui;
    }


    /**
     * Gets the hrInicialGui value for this DwCalavu.
     * 
     * @return hrInicialGui
     */
    public java.lang.String getHrInicialGui() {
        return hrInicialGui;
    }


    /**
     * Sets the hrInicialGui value for this DwCalavu.
     * 
     * @param hrInicialGui
     */
    public void setHrInicialGui(java.lang.String hrInicialGui) {
        this.hrInicialGui = hrInicialGui;
    }


    /**
     * Gets the hrinicial value for this DwCalavu.
     * 
     * @return hrinicial
     */
    public java.math.BigDecimal getHrinicial() {
        return hrinicial;
    }


    /**
     * Sets the hrinicial value for this DwCalavu.
     * 
     * @param hrinicial
     */
    public void setHrinicial(java.math.BigDecimal hrinicial) {
        this.hrinicial = hrinicial;
    }


    /**
     * Gets the idCalavu value for this DwCalavu.
     * 
     * @return idCalavu
     */
    public long getIdCalavu() {
        return idCalavu;
    }


    /**
     * Sets the idCalavu value for this DwCalavu.
     * 
     * @param idCalavu
     */
    public void setIdCalavu(long idCalavu) {
        this.idCalavu = idCalavu;
    }


    /**
     * Gets the isCalsemdesativado value for this DwCalavu.
     * 
     * @return isCalsemdesativado
     */
    public java.lang.Boolean getIsCalsemdesativado() {
        return isCalsemdesativado;
    }


    /**
     * Sets the isCalsemdesativado value for this DwCalavu.
     * 
     * @param isCalsemdesativado
     */
    public void setIsCalsemdesativado(java.lang.Boolean isCalsemdesativado) {
        this.isCalsemdesativado = isCalsemdesativado;
    }


    /**
     * Gets the isFimturno value for this DwCalavu.
     * 
     * @return isFimturno
     */
    public java.lang.Boolean getIsFimturno() {
        return isFimturno;
    }


    /**
     * Sets the isFimturno value for this DwCalavu.
     * 
     * @param isFimturno
     */
    public void setIsFimturno(java.lang.Boolean isFimturno) {
        this.isFimturno = isFimturno;
    }


    /**
     * Gets the isInicioturno value for this DwCalavu.
     * 
     * @return isInicioturno
     */
    public java.lang.Boolean getIsInicioturno() {
        return isInicioturno;
    }


    /**
     * Sets the isInicioturno value for this DwCalavu.
     * 
     * @param isInicioturno
     */
    public void setIsInicioturno(java.lang.Boolean isInicioturno) {
        this.isInicioturno = isInicioturno;
    }


    /**
     * Gets the segTempocalendario value for this DwCalavu.
     * 
     * @return segTempocalendario
     */
    public java.math.BigDecimal getSegTempocalendario() {
        return segTempocalendario;
    }


    /**
     * Sets the segTempocalendario value for this DwCalavu.
     * 
     * @param segTempocalendario
     */
    public void setSegTempocalendario(java.math.BigDecimal segTempocalendario) {
        this.segTempocalendario = segTempocalendario;
    }


    /**
     * Gets the segTempocalsempeso value for this DwCalavu.
     * 
     * @return segTempocalsempeso
     */
    public java.math.BigDecimal getSegTempocalsempeso() {
        return segTempocalsempeso;
    }


    /**
     * Sets the segTempocalsempeso value for this DwCalavu.
     * 
     * @param segTempocalsempeso
     */
    public void setSegTempocalsempeso(java.math.BigDecimal segTempocalsempeso) {
        this.segTempocalsempeso = segTempocalsempeso;
    }


    /**
     * Gets the segToleranciapos value for this DwCalavu.
     * 
     * @return segToleranciapos
     */
    public java.math.BigDecimal getSegToleranciapos() {
        return segToleranciapos;
    }


    /**
     * Sets the segToleranciapos value for this DwCalavu.
     * 
     * @param segToleranciapos
     */
    public void setSegToleranciapos(java.math.BigDecimal segToleranciapos) {
        this.segToleranciapos = segToleranciapos;
    }


    /**
     * Gets the segToleranciapre value for this DwCalavu.
     * 
     * @return segToleranciapre
     */
    public java.math.BigDecimal getSegToleranciapre() {
        return segToleranciapre;
    }


    /**
     * Sets the segToleranciapre value for this DwCalavu.
     * 
     * @param segToleranciapre
     */
    public void setSegToleranciapre(java.math.BigDecimal segToleranciapre) {
        this.segToleranciapre = segToleranciapre;
    }


    /**
     * Gets the tpCalavu value for this DwCalavu.
     * 
     * @return tpCalavu
     */
    public java.lang.Byte getTpCalavu() {
        return tpCalavu;
    }


    /**
     * Sets the tpCalavu value for this DwCalavu.
     * 
     * @param tpCalavu
     */
    public void setTpCalavu(java.lang.Byte tpCalavu) {
        this.tpCalavu = tpCalavu;
    }


    /**
     * Gets the tpDtreferencia value for this DwCalavu.
     * 
     * @return tpDtreferencia
     */
    public java.lang.Byte getTpDtreferencia() {
        return tpDtreferencia;
    }


    /**
     * Sets the tpDtreferencia value for this DwCalavu.
     * 
     * @param tpDtreferencia
     */
    public void setTpDtreferencia(java.lang.Byte tpDtreferencia) {
        this.tpDtreferencia = tpDtreferencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwCalavu)) return false;
        DwCalavu other = (DwCalavu) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dtAvulso==null && other.getDtAvulso()==null) || 
             (this.dtAvulso!=null &&
              this.dtAvulso.equals(other.getDtAvulso()))) &&
            ((this.dwCal==null && other.getDwCal()==null) || 
             (this.dwCal!=null &&
              this.dwCal.equals(other.getDwCal()))) &&
            ((this.dwCalsem==null && other.getDwCalsem()==null) || 
             (this.dwCalsem!=null &&
              this.dwCalsem.equals(other.getDwCalsem()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            ((this.hrFinal==null && other.getHrFinal()==null) || 
             (this.hrFinal!=null &&
              this.hrFinal.equals(other.getHrFinal()))) &&
            ((this.hrFinalGui==null && other.getHrFinalGui()==null) || 
             (this.hrFinalGui!=null &&
              this.hrFinalGui.equals(other.getHrFinalGui()))) &&
            ((this.hrInicialGui==null && other.getHrInicialGui()==null) || 
             (this.hrInicialGui!=null &&
              this.hrInicialGui.equals(other.getHrInicialGui()))) &&
            ((this.hrinicial==null && other.getHrinicial()==null) || 
             (this.hrinicial!=null &&
              this.hrinicial.equals(other.getHrinicial()))) &&
            this.idCalavu == other.getIdCalavu() &&
            ((this.isCalsemdesativado==null && other.getIsCalsemdesativado()==null) || 
             (this.isCalsemdesativado!=null &&
              this.isCalsemdesativado.equals(other.getIsCalsemdesativado()))) &&
            ((this.isFimturno==null && other.getIsFimturno()==null) || 
             (this.isFimturno!=null &&
              this.isFimturno.equals(other.getIsFimturno()))) &&
            ((this.isInicioturno==null && other.getIsInicioturno()==null) || 
             (this.isInicioturno!=null &&
              this.isInicioturno.equals(other.getIsInicioturno()))) &&
            ((this.segTempocalendario==null && other.getSegTempocalendario()==null) || 
             (this.segTempocalendario!=null &&
              this.segTempocalendario.equals(other.getSegTempocalendario()))) &&
            ((this.segTempocalsempeso==null && other.getSegTempocalsempeso()==null) || 
             (this.segTempocalsempeso!=null &&
              this.segTempocalsempeso.equals(other.getSegTempocalsempeso()))) &&
            ((this.segToleranciapos==null && other.getSegToleranciapos()==null) || 
             (this.segToleranciapos!=null &&
              this.segToleranciapos.equals(other.getSegToleranciapos()))) &&
            ((this.segToleranciapre==null && other.getSegToleranciapre()==null) || 
             (this.segToleranciapre!=null &&
              this.segToleranciapre.equals(other.getSegToleranciapre()))) &&
            ((this.tpCalavu==null && other.getTpCalavu()==null) || 
             (this.tpCalavu!=null &&
              this.tpCalavu.equals(other.getTpCalavu()))) &&
            ((this.tpDtreferencia==null && other.getTpDtreferencia()==null) || 
             (this.tpDtreferencia!=null &&
              this.tpDtreferencia.equals(other.getTpDtreferencia())));
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
        if (getDtAvulso() != null) {
            _hashCode += getDtAvulso().hashCode();
        }
        if (getDwCal() != null) {
            _hashCode += getDwCal().hashCode();
        }
        if (getDwCalsem() != null) {
            _hashCode += getDwCalsem().hashCode();
        }
        if (getDwTurno() != null) {
            _hashCode += getDwTurno().hashCode();
        }
        if (getHrFinal() != null) {
            _hashCode += getHrFinal().hashCode();
        }
        if (getHrFinalGui() != null) {
            _hashCode += getHrFinalGui().hashCode();
        }
        if (getHrInicialGui() != null) {
            _hashCode += getHrInicialGui().hashCode();
        }
        if (getHrinicial() != null) {
            _hashCode += getHrinicial().hashCode();
        }
        _hashCode += new Long(getIdCalavu()).hashCode();
        if (getIsCalsemdesativado() != null) {
            _hashCode += getIsCalsemdesativado().hashCode();
        }
        if (getIsFimturno() != null) {
            _hashCode += getIsFimturno().hashCode();
        }
        if (getIsInicioturno() != null) {
            _hashCode += getIsInicioturno().hashCode();
        }
        if (getSegTempocalendario() != null) {
            _hashCode += getSegTempocalendario().hashCode();
        }
        if (getSegTempocalsempeso() != null) {
            _hashCode += getSegTempocalsempeso().hashCode();
        }
        if (getSegToleranciapos() != null) {
            _hashCode += getSegToleranciapos().hashCode();
        }
        if (getSegToleranciapre() != null) {
            _hashCode += getSegToleranciapre().hashCode();
        }
        if (getTpCalavu() != null) {
            _hashCode += getTpCalavu().hashCode();
        }
        if (getTpDtreferencia() != null) {
            _hashCode += getTpDtreferencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwCalavu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalavu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtAvulso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtAvulso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwCalsem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalsem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalsem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwTurno"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrFinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrFinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrFinalGui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrFinalGui"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrInicialGui");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrInicialGui"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hrinicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrinicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCalavu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCalavu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isCalsemdesativado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isCalsemdesativado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFimturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isFimturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isInicioturno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isInicioturno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segTempocalendario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segTempocalendario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segTempocalsempeso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segTempocalsempeso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segToleranciapos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segToleranciapos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segToleranciapre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segToleranciapre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpCalavu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpCalavu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpDtreferencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpDtreferencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "byte"));
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
