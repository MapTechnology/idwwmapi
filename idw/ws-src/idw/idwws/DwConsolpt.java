/**
 * DwConsolpt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolpt  extends idw.idwws.DwConsolptTemplate  implements java.io.Serializable {
    private java.util.Calendar dthrFim;

    private java.util.Calendar dthrInicio;

    private idw.idwws.DwCal dwCal;

    private idw.idwws.DwConsolid dwConsolidByIdConsolidAcu;

    private idw.idwws.DwConsolid dwConsolidByIdConsolidHora;

    private idw.idwws.DwConsolid dwConsolidByIdConsolidMes;

    private idw.idwws.DwConsolid dwConsolidByIdConsolidTurno;

    private idw.idwws.DwFolha dwFolha;

    private java.lang.Long idConsolpt;

    private idw.idwws.OmPt omPt;

    private idw.idwws.PpCp ppCp;

    public DwConsolpt() {
    }

    public DwConsolpt(
           java.util.Calendar dthrFim,
           java.util.Calendar dthrInicio,
           idw.idwws.DwCal dwCal,
           idw.idwws.DwConsolid dwConsolidByIdConsolidAcu,
           idw.idwws.DwConsolid dwConsolidByIdConsolidHora,
           idw.idwws.DwConsolid dwConsolidByIdConsolidMes,
           idw.idwws.DwConsolid dwConsolidByIdConsolidTurno,
           idw.idwws.DwFolha dwFolha,
           java.lang.Long idConsolpt,
           idw.idwws.OmPt omPt,
           idw.idwws.PpCp ppCp) {
        this.dthrFim = dthrFim;
        this.dthrInicio = dthrInicio;
        this.dwCal = dwCal;
        this.dwConsolidByIdConsolidAcu = dwConsolidByIdConsolidAcu;
        this.dwConsolidByIdConsolidHora = dwConsolidByIdConsolidHora;
        this.dwConsolidByIdConsolidMes = dwConsolidByIdConsolidMes;
        this.dwConsolidByIdConsolidTurno = dwConsolidByIdConsolidTurno;
        this.dwFolha = dwFolha;
        this.idConsolpt = idConsolpt;
        this.omPt = omPt;
        this.ppCp = ppCp;
    }


    /**
     * Gets the dthrFim value for this DwConsolpt.
     * 
     * @return dthrFim
     */
    public java.util.Calendar getDthrFim() {
        return dthrFim;
    }


    /**
     * Sets the dthrFim value for this DwConsolpt.
     * 
     * @param dthrFim
     */
    public void setDthrFim(java.util.Calendar dthrFim) {
        this.dthrFim = dthrFim;
    }


    /**
     * Gets the dthrInicio value for this DwConsolpt.
     * 
     * @return dthrInicio
     */
    public java.util.Calendar getDthrInicio() {
        return dthrInicio;
    }


    /**
     * Sets the dthrInicio value for this DwConsolpt.
     * 
     * @param dthrInicio
     */
    public void setDthrInicio(java.util.Calendar dthrInicio) {
        this.dthrInicio = dthrInicio;
    }


    /**
     * Gets the dwCal value for this DwConsolpt.
     * 
     * @return dwCal
     */
    public idw.idwws.DwCal getDwCal() {
        return dwCal;
    }


    /**
     * Sets the dwCal value for this DwConsolpt.
     * 
     * @param dwCal
     */
    public void setDwCal(idw.idwws.DwCal dwCal) {
        this.dwCal = dwCal;
    }


    /**
     * Gets the dwConsolidByIdConsolidAcu value for this DwConsolpt.
     * 
     * @return dwConsolidByIdConsolidAcu
     */
    public idw.idwws.DwConsolid getDwConsolidByIdConsolidAcu() {
        return dwConsolidByIdConsolidAcu;
    }


    /**
     * Sets the dwConsolidByIdConsolidAcu value for this DwConsolpt.
     * 
     * @param dwConsolidByIdConsolidAcu
     */
    public void setDwConsolidByIdConsolidAcu(idw.idwws.DwConsolid dwConsolidByIdConsolidAcu) {
        this.dwConsolidByIdConsolidAcu = dwConsolidByIdConsolidAcu;
    }


    /**
     * Gets the dwConsolidByIdConsolidHora value for this DwConsolpt.
     * 
     * @return dwConsolidByIdConsolidHora
     */
    public idw.idwws.DwConsolid getDwConsolidByIdConsolidHora() {
        return dwConsolidByIdConsolidHora;
    }


    /**
     * Sets the dwConsolidByIdConsolidHora value for this DwConsolpt.
     * 
     * @param dwConsolidByIdConsolidHora
     */
    public void setDwConsolidByIdConsolidHora(idw.idwws.DwConsolid dwConsolidByIdConsolidHora) {
        this.dwConsolidByIdConsolidHora = dwConsolidByIdConsolidHora;
    }


    /**
     * Gets the dwConsolidByIdConsolidMes value for this DwConsolpt.
     * 
     * @return dwConsolidByIdConsolidMes
     */
    public idw.idwws.DwConsolid getDwConsolidByIdConsolidMes() {
        return dwConsolidByIdConsolidMes;
    }


    /**
     * Sets the dwConsolidByIdConsolidMes value for this DwConsolpt.
     * 
     * @param dwConsolidByIdConsolidMes
     */
    public void setDwConsolidByIdConsolidMes(idw.idwws.DwConsolid dwConsolidByIdConsolidMes) {
        this.dwConsolidByIdConsolidMes = dwConsolidByIdConsolidMes;
    }


    /**
     * Gets the dwConsolidByIdConsolidTurno value for this DwConsolpt.
     * 
     * @return dwConsolidByIdConsolidTurno
     */
    public idw.idwws.DwConsolid getDwConsolidByIdConsolidTurno() {
        return dwConsolidByIdConsolidTurno;
    }


    /**
     * Sets the dwConsolidByIdConsolidTurno value for this DwConsolpt.
     * 
     * @param dwConsolidByIdConsolidTurno
     */
    public void setDwConsolidByIdConsolidTurno(idw.idwws.DwConsolid dwConsolidByIdConsolidTurno) {
        this.dwConsolidByIdConsolidTurno = dwConsolidByIdConsolidTurno;
    }


    /**
     * Gets the dwFolha value for this DwConsolpt.
     * 
     * @return dwFolha
     */
    public idw.idwws.DwFolha getDwFolha() {
        return dwFolha;
    }


    /**
     * Sets the dwFolha value for this DwConsolpt.
     * 
     * @param dwFolha
     */
    public void setDwFolha(idw.idwws.DwFolha dwFolha) {
        this.dwFolha = dwFolha;
    }


    /**
     * Gets the idConsolpt value for this DwConsolpt.
     * 
     * @return idConsolpt
     */
    public java.lang.Long getIdConsolpt() {
        return idConsolpt;
    }


    /**
     * Sets the idConsolpt value for this DwConsolpt.
     * 
     * @param idConsolpt
     */
    public void setIdConsolpt(java.lang.Long idConsolpt) {
        this.idConsolpt = idConsolpt;
    }


    /**
     * Gets the omPt value for this DwConsolpt.
     * 
     * @return omPt
     */
    public idw.idwws.OmPt getOmPt() {
        return omPt;
    }


    /**
     * Sets the omPt value for this DwConsolpt.
     * 
     * @param omPt
     */
    public void setOmPt(idw.idwws.OmPt omPt) {
        this.omPt = omPt;
    }


    /**
     * Gets the ppCp value for this DwConsolpt.
     * 
     * @return ppCp
     */
    public idw.idwws.PpCp getPpCp() {
        return ppCp;
    }


    /**
     * Sets the ppCp value for this DwConsolpt.
     * 
     * @param ppCp
     */
    public void setPpCp(idw.idwws.PpCp ppCp) {
        this.ppCp = ppCp;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolpt)) return false;
        DwConsolpt other = (DwConsolpt) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dthrFim==null && other.getDthrFim()==null) || 
             (this.dthrFim!=null &&
              this.dthrFim.equals(other.getDthrFim()))) &&
            ((this.dthrInicio==null && other.getDthrInicio()==null) || 
             (this.dthrInicio!=null &&
              this.dthrInicio.equals(other.getDthrInicio()))) &&
            ((this.dwCal==null && other.getDwCal()==null) || 
             (this.dwCal!=null &&
              this.dwCal.equals(other.getDwCal()))) &&
            ((this.dwConsolidByIdConsolidAcu==null && other.getDwConsolidByIdConsolidAcu()==null) || 
             (this.dwConsolidByIdConsolidAcu!=null &&
              this.dwConsolidByIdConsolidAcu.equals(other.getDwConsolidByIdConsolidAcu()))) &&
            ((this.dwConsolidByIdConsolidHora==null && other.getDwConsolidByIdConsolidHora()==null) || 
             (this.dwConsolidByIdConsolidHora!=null &&
              this.dwConsolidByIdConsolidHora.equals(other.getDwConsolidByIdConsolidHora()))) &&
            ((this.dwConsolidByIdConsolidMes==null && other.getDwConsolidByIdConsolidMes()==null) || 
             (this.dwConsolidByIdConsolidMes!=null &&
              this.dwConsolidByIdConsolidMes.equals(other.getDwConsolidByIdConsolidMes()))) &&
            ((this.dwConsolidByIdConsolidTurno==null && other.getDwConsolidByIdConsolidTurno()==null) || 
             (this.dwConsolidByIdConsolidTurno!=null &&
              this.dwConsolidByIdConsolidTurno.equals(other.getDwConsolidByIdConsolidTurno()))) &&
            ((this.dwFolha==null && other.getDwFolha()==null) || 
             (this.dwFolha!=null &&
              this.dwFolha.equals(other.getDwFolha()))) &&
            ((this.idConsolpt==null && other.getIdConsolpt()==null) || 
             (this.idConsolpt!=null &&
              this.idConsolpt.equals(other.getIdConsolpt()))) &&
            ((this.omPt==null && other.getOmPt()==null) || 
             (this.omPt!=null &&
              this.omPt.equals(other.getOmPt()))) &&
            ((this.ppCp==null && other.getPpCp()==null) || 
             (this.ppCp!=null &&
              this.ppCp.equals(other.getPpCp())));
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
        if (getDthrFim() != null) {
            _hashCode += getDthrFim().hashCode();
        }
        if (getDthrInicio() != null) {
            _hashCode += getDthrInicio().hashCode();
        }
        if (getDwCal() != null) {
            _hashCode += getDwCal().hashCode();
        }
        if (getDwConsolidByIdConsolidAcu() != null) {
            _hashCode += getDwConsolidByIdConsolidAcu().hashCode();
        }
        if (getDwConsolidByIdConsolidHora() != null) {
            _hashCode += getDwConsolidByIdConsolidHora().hashCode();
        }
        if (getDwConsolidByIdConsolidMes() != null) {
            _hashCode += getDwConsolidByIdConsolidMes().hashCode();
        }
        if (getDwConsolidByIdConsolidTurno() != null) {
            _hashCode += getDwConsolidByIdConsolidTurno().hashCode();
        }
        if (getDwFolha() != null) {
            _hashCode += getDwFolha().hashCode();
        }
        if (getIdConsolpt() != null) {
            _hashCode += getIdConsolpt().hashCode();
        }
        if (getOmPt() != null) {
            _hashCode += getOmPt().hashCode();
        }
        if (getPpCp() != null) {
            _hashCode += getPpCp().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolpt.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolpt"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrFim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrFim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrInicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrInicio"));
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
        elemField.setFieldName("dwConsolidByIdConsolidAcu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolidByIdConsolidAcu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolidByIdConsolidHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolidByIdConsolidHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolidByIdConsolidMes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolidByIdConsolidMes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolidByIdConsolidTurno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolidByIdConsolidTurno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwFolha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwFolha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolha"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConsolpt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConsolpt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("omPt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "omPt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "omPt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ppCp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ppCp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ppCp"));
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
