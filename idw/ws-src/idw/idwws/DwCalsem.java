/**
 * DwCalsem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwCalsem  extends idw.idwws.DwCalsemTemplate  implements java.io.Serializable {
    private java.math.BigDecimal diasemana;

    private idw.idwws.DwCal dwCal;

    private idw.idwws.DwCalavu[] dwCalavus;

    private idw.idwws.DwTurno dwTurno;

    private java.math.BigDecimal hrFinal;

    private java.lang.String hrFinalGui;

    private java.math.BigDecimal hrInicial;

    private java.lang.String hrInicialGui;

    private long idCalsem;

    private java.lang.Boolean isFimturno;

    private java.lang.Boolean isInicioturno;

    private java.lang.Integer ordem;

    private java.math.BigDecimal segTempocalendario;

    private java.math.BigDecimal segTempocalsempeso;

    private java.math.BigDecimal segToleranciapos;

    private java.math.BigDecimal segToleranciapre;

    private java.lang.Byte tpDtreferencia;

    public DwCalsem() {
    }

    public DwCalsem(
           java.math.BigDecimal diasemana,
           idw.idwws.DwCal dwCal,
           idw.idwws.DwCalavu[] dwCalavus,
           idw.idwws.DwTurno dwTurno,
           java.math.BigDecimal hrFinal,
           java.lang.String hrFinalGui,
           java.math.BigDecimal hrInicial,
           java.lang.String hrInicialGui,
           long idCalsem,
           java.lang.Boolean isFimturno,
           java.lang.Boolean isInicioturno,
           java.lang.Integer ordem,
           java.math.BigDecimal segTempocalendario,
           java.math.BigDecimal segTempocalsempeso,
           java.math.BigDecimal segToleranciapos,
           java.math.BigDecimal segToleranciapre,
           java.lang.Byte tpDtreferencia) {
        this.diasemana = diasemana;
        this.dwCal = dwCal;
        this.dwCalavus = dwCalavus;
        this.dwTurno = dwTurno;
        this.hrFinal = hrFinal;
        this.hrFinalGui = hrFinalGui;
        this.hrInicial = hrInicial;
        this.hrInicialGui = hrInicialGui;
        this.idCalsem = idCalsem;
        this.isFimturno = isFimturno;
        this.isInicioturno = isInicioturno;
        this.ordem = ordem;
        this.segTempocalendario = segTempocalendario;
        this.segTempocalsempeso = segTempocalsempeso;
        this.segToleranciapos = segToleranciapos;
        this.segToleranciapre = segToleranciapre;
        this.tpDtreferencia = tpDtreferencia;
    }


    /**
     * Gets the diasemana value for this DwCalsem.
     * 
     * @return diasemana
     */
    public java.math.BigDecimal getDiasemana() {
        return diasemana;
    }


    /**
     * Sets the diasemana value for this DwCalsem.
     * 
     * @param diasemana
     */
    public void setDiasemana(java.math.BigDecimal diasemana) {
        this.diasemana = diasemana;
    }


    /**
     * Gets the dwCal value for this DwCalsem.
     * 
     * @return dwCal
     */
    public idw.idwws.DwCal getDwCal() {
        return dwCal;
    }


    /**
     * Sets the dwCal value for this DwCalsem.
     * 
     * @param dwCal
     */
    public void setDwCal(idw.idwws.DwCal dwCal) {
        this.dwCal = dwCal;
    }


    /**
     * Gets the dwCalavus value for this DwCalsem.
     * 
     * @return dwCalavus
     */
    public idw.idwws.DwCalavu[] getDwCalavus() {
        return dwCalavus;
    }


    /**
     * Sets the dwCalavus value for this DwCalsem.
     * 
     * @param dwCalavus
     */
    public void setDwCalavus(idw.idwws.DwCalavu[] dwCalavus) {
        this.dwCalavus = dwCalavus;
    }

    public idw.idwws.DwCalavu getDwCalavus(int i) {
        return this.dwCalavus[i];
    }

    public void setDwCalavus(int i, idw.idwws.DwCalavu _value) {
        this.dwCalavus[i] = _value;
    }


    /**
     * Gets the dwTurno value for this DwCalsem.
     * 
     * @return dwTurno
     */
    public idw.idwws.DwTurno getDwTurno() {
        return dwTurno;
    }


    /**
     * Sets the dwTurno value for this DwCalsem.
     * 
     * @param dwTurno
     */
    public void setDwTurno(idw.idwws.DwTurno dwTurno) {
        this.dwTurno = dwTurno;
    }


    /**
     * Gets the hrFinal value for this DwCalsem.
     * 
     * @return hrFinal
     */
    public java.math.BigDecimal getHrFinal() {
        return hrFinal;
    }


    /**
     * Sets the hrFinal value for this DwCalsem.
     * 
     * @param hrFinal
     */
    public void setHrFinal(java.math.BigDecimal hrFinal) {
        this.hrFinal = hrFinal;
    }


    /**
     * Gets the hrFinalGui value for this DwCalsem.
     * 
     * @return hrFinalGui
     */
    public java.lang.String getHrFinalGui() {
        return hrFinalGui;
    }


    /**
     * Sets the hrFinalGui value for this DwCalsem.
     * 
     * @param hrFinalGui
     */
    public void setHrFinalGui(java.lang.String hrFinalGui) {
        this.hrFinalGui = hrFinalGui;
    }


    /**
     * Gets the hrInicial value for this DwCalsem.
     * 
     * @return hrInicial
     */
    public java.math.BigDecimal getHrInicial() {
        return hrInicial;
    }


    /**
     * Sets the hrInicial value for this DwCalsem.
     * 
     * @param hrInicial
     */
    public void setHrInicial(java.math.BigDecimal hrInicial) {
        this.hrInicial = hrInicial;
    }


    /**
     * Gets the hrInicialGui value for this DwCalsem.
     * 
     * @return hrInicialGui
     */
    public java.lang.String getHrInicialGui() {
        return hrInicialGui;
    }


    /**
     * Sets the hrInicialGui value for this DwCalsem.
     * 
     * @param hrInicialGui
     */
    public void setHrInicialGui(java.lang.String hrInicialGui) {
        this.hrInicialGui = hrInicialGui;
    }


    /**
     * Gets the idCalsem value for this DwCalsem.
     * 
     * @return idCalsem
     */
    public long getIdCalsem() {
        return idCalsem;
    }


    /**
     * Sets the idCalsem value for this DwCalsem.
     * 
     * @param idCalsem
     */
    public void setIdCalsem(long idCalsem) {
        this.idCalsem = idCalsem;
    }


    /**
     * Gets the isFimturno value for this DwCalsem.
     * 
     * @return isFimturno
     */
    public java.lang.Boolean getIsFimturno() {
        return isFimturno;
    }


    /**
     * Sets the isFimturno value for this DwCalsem.
     * 
     * @param isFimturno
     */
    public void setIsFimturno(java.lang.Boolean isFimturno) {
        this.isFimturno = isFimturno;
    }


    /**
     * Gets the isInicioturno value for this DwCalsem.
     * 
     * @return isInicioturno
     */
    public java.lang.Boolean getIsInicioturno() {
        return isInicioturno;
    }


    /**
     * Sets the isInicioturno value for this DwCalsem.
     * 
     * @param isInicioturno
     */
    public void setIsInicioturno(java.lang.Boolean isInicioturno) {
        this.isInicioturno = isInicioturno;
    }


    /**
     * Gets the ordem value for this DwCalsem.
     * 
     * @return ordem
     */
    public java.lang.Integer getOrdem() {
        return ordem;
    }


    /**
     * Sets the ordem value for this DwCalsem.
     * 
     * @param ordem
     */
    public void setOrdem(java.lang.Integer ordem) {
        this.ordem = ordem;
    }


    /**
     * Gets the segTempocalendario value for this DwCalsem.
     * 
     * @return segTempocalendario
     */
    public java.math.BigDecimal getSegTempocalendario() {
        return segTempocalendario;
    }


    /**
     * Sets the segTempocalendario value for this DwCalsem.
     * 
     * @param segTempocalendario
     */
    public void setSegTempocalendario(java.math.BigDecimal segTempocalendario) {
        this.segTempocalendario = segTempocalendario;
    }


    /**
     * Gets the segTempocalsempeso value for this DwCalsem.
     * 
     * @return segTempocalsempeso
     */
    public java.math.BigDecimal getSegTempocalsempeso() {
        return segTempocalsempeso;
    }


    /**
     * Sets the segTempocalsempeso value for this DwCalsem.
     * 
     * @param segTempocalsempeso
     */
    public void setSegTempocalsempeso(java.math.BigDecimal segTempocalsempeso) {
        this.segTempocalsempeso = segTempocalsempeso;
    }


    /**
     * Gets the segToleranciapos value for this DwCalsem.
     * 
     * @return segToleranciapos
     */
    public java.math.BigDecimal getSegToleranciapos() {
        return segToleranciapos;
    }


    /**
     * Sets the segToleranciapos value for this DwCalsem.
     * 
     * @param segToleranciapos
     */
    public void setSegToleranciapos(java.math.BigDecimal segToleranciapos) {
        this.segToleranciapos = segToleranciapos;
    }


    /**
     * Gets the segToleranciapre value for this DwCalsem.
     * 
     * @return segToleranciapre
     */
    public java.math.BigDecimal getSegToleranciapre() {
        return segToleranciapre;
    }


    /**
     * Sets the segToleranciapre value for this DwCalsem.
     * 
     * @param segToleranciapre
     */
    public void setSegToleranciapre(java.math.BigDecimal segToleranciapre) {
        this.segToleranciapre = segToleranciapre;
    }


    /**
     * Gets the tpDtreferencia value for this DwCalsem.
     * 
     * @return tpDtreferencia
     */
    public java.lang.Byte getTpDtreferencia() {
        return tpDtreferencia;
    }


    /**
     * Sets the tpDtreferencia value for this DwCalsem.
     * 
     * @param tpDtreferencia
     */
    public void setTpDtreferencia(java.lang.Byte tpDtreferencia) {
        this.tpDtreferencia = tpDtreferencia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwCalsem)) return false;
        DwCalsem other = (DwCalsem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.diasemana==null && other.getDiasemana()==null) || 
             (this.diasemana!=null &&
              this.diasemana.equals(other.getDiasemana()))) &&
            ((this.dwCal==null && other.getDwCal()==null) || 
             (this.dwCal!=null &&
              this.dwCal.equals(other.getDwCal()))) &&
            ((this.dwCalavus==null && other.getDwCalavus()==null) || 
             (this.dwCalavus!=null &&
              java.util.Arrays.equals(this.dwCalavus, other.getDwCalavus()))) &&
            ((this.dwTurno==null && other.getDwTurno()==null) || 
             (this.dwTurno!=null &&
              this.dwTurno.equals(other.getDwTurno()))) &&
            ((this.hrFinal==null && other.getHrFinal()==null) || 
             (this.hrFinal!=null &&
              this.hrFinal.equals(other.getHrFinal()))) &&
            ((this.hrFinalGui==null && other.getHrFinalGui()==null) || 
             (this.hrFinalGui!=null &&
              this.hrFinalGui.equals(other.getHrFinalGui()))) &&
            ((this.hrInicial==null && other.getHrInicial()==null) || 
             (this.hrInicial!=null &&
              this.hrInicial.equals(other.getHrInicial()))) &&
            ((this.hrInicialGui==null && other.getHrInicialGui()==null) || 
             (this.hrInicialGui!=null &&
              this.hrInicialGui.equals(other.getHrInicialGui()))) &&
            this.idCalsem == other.getIdCalsem() &&
            ((this.isFimturno==null && other.getIsFimturno()==null) || 
             (this.isFimturno!=null &&
              this.isFimturno.equals(other.getIsFimturno()))) &&
            ((this.isInicioturno==null && other.getIsInicioturno()==null) || 
             (this.isInicioturno!=null &&
              this.isInicioturno.equals(other.getIsInicioturno()))) &&
            ((this.ordem==null && other.getOrdem()==null) || 
             (this.ordem!=null &&
              this.ordem.equals(other.getOrdem()))) &&
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
        if (getDiasemana() != null) {
            _hashCode += getDiasemana().hashCode();
        }
        if (getDwCal() != null) {
            _hashCode += getDwCal().hashCode();
        }
        if (getDwCalavus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDwCalavus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDwCalavus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getHrInicial() != null) {
            _hashCode += getHrInicial().hashCode();
        }
        if (getHrInicialGui() != null) {
            _hashCode += getHrInicialGui().hashCode();
        }
        _hashCode += new Long(getIdCalsem()).hashCode();
        if (getIsFimturno() != null) {
            _hashCode += getIsFimturno().hashCode();
        }
        if (getIsInicioturno() != null) {
            _hashCode += getIsInicioturno().hashCode();
        }
        if (getOrdem() != null) {
            _hashCode += getOrdem().hashCode();
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
        if (getTpDtreferencia() != null) {
            _hashCode += getTpDtreferencia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwCalsem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalsem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diasemana");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diasemana"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("dwCalavus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwCalavus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCalavu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
        elemField.setFieldName("hrInicial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hrInicial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
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
        elemField.setFieldName("idCalsem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCalsem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("ordem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
