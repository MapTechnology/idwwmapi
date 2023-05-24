/**
 * Ijpdcaparticipproj.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijpdcaparticipproj  implements java.io.Serializable {
    private idw.idwws.IjpdcaparticipprojId id;

    private idw.idwws.Ijpdcaagndacmpeft[] ijpdcaagndacmpefts;

    private idw.idwws.Ijpdcaagndacmp[] ijpdcaagndacmps;

    private idw.idwws.Ijpdcaprojeto ijpdcaprojeto;

    private idw.idwws.Ijtbusu ijtbusu;

    private idw.idwws.Ijtbusumail ijtbusumail;

    private java.lang.String nmparticipprojeto;

    private java.math.BigDecimal participadm;

    private java.math.BigDecimal tpparticipante;

    public Ijpdcaparticipproj() {
    }

    public Ijpdcaparticipproj(
           idw.idwws.IjpdcaparticipprojId id,
           idw.idwws.Ijpdcaagndacmpeft[] ijpdcaagndacmpefts,
           idw.idwws.Ijpdcaagndacmp[] ijpdcaagndacmps,
           idw.idwws.Ijpdcaprojeto ijpdcaprojeto,
           idw.idwws.Ijtbusu ijtbusu,
           idw.idwws.Ijtbusumail ijtbusumail,
           java.lang.String nmparticipprojeto,
           java.math.BigDecimal participadm,
           java.math.BigDecimal tpparticipante) {
           this.id = id;
           this.ijpdcaagndacmpefts = ijpdcaagndacmpefts;
           this.ijpdcaagndacmps = ijpdcaagndacmps;
           this.ijpdcaprojeto = ijpdcaprojeto;
           this.ijtbusu = ijtbusu;
           this.ijtbusumail = ijtbusumail;
           this.nmparticipprojeto = nmparticipprojeto;
           this.participadm = participadm;
           this.tpparticipante = tpparticipante;
    }


    /**
     * Gets the id value for this Ijpdcaparticipproj.
     * 
     * @return id
     */
    public idw.idwws.IjpdcaparticipprojId getId() {
        return id;
    }


    /**
     * Sets the id value for this Ijpdcaparticipproj.
     * 
     * @param id
     */
    public void setId(idw.idwws.IjpdcaparticipprojId id) {
        this.id = id;
    }


    /**
     * Gets the ijpdcaagndacmpefts value for this Ijpdcaparticipproj.
     * 
     * @return ijpdcaagndacmpefts
     */
    public idw.idwws.Ijpdcaagndacmpeft[] getIjpdcaagndacmpefts() {
        return ijpdcaagndacmpefts;
    }


    /**
     * Sets the ijpdcaagndacmpefts value for this Ijpdcaparticipproj.
     * 
     * @param ijpdcaagndacmpefts
     */
    public void setIjpdcaagndacmpefts(idw.idwws.Ijpdcaagndacmpeft[] ijpdcaagndacmpefts) {
        this.ijpdcaagndacmpefts = ijpdcaagndacmpefts;
    }

    public idw.idwws.Ijpdcaagndacmpeft getIjpdcaagndacmpefts(int i) {
        return this.ijpdcaagndacmpefts[i];
    }

    public void setIjpdcaagndacmpefts(int i, idw.idwws.Ijpdcaagndacmpeft _value) {
        this.ijpdcaagndacmpefts[i] = _value;
    }


    /**
     * Gets the ijpdcaagndacmps value for this Ijpdcaparticipproj.
     * 
     * @return ijpdcaagndacmps
     */
    public idw.idwws.Ijpdcaagndacmp[] getIjpdcaagndacmps() {
        return ijpdcaagndacmps;
    }


    /**
     * Sets the ijpdcaagndacmps value for this Ijpdcaparticipproj.
     * 
     * @param ijpdcaagndacmps
     */
    public void setIjpdcaagndacmps(idw.idwws.Ijpdcaagndacmp[] ijpdcaagndacmps) {
        this.ijpdcaagndacmps = ijpdcaagndacmps;
    }

    public idw.idwws.Ijpdcaagndacmp getIjpdcaagndacmps(int i) {
        return this.ijpdcaagndacmps[i];
    }

    public void setIjpdcaagndacmps(int i, idw.idwws.Ijpdcaagndacmp _value) {
        this.ijpdcaagndacmps[i] = _value;
    }


    /**
     * Gets the ijpdcaprojeto value for this Ijpdcaparticipproj.
     * 
     * @return ijpdcaprojeto
     */
    public idw.idwws.Ijpdcaprojeto getIjpdcaprojeto() {
        return ijpdcaprojeto;
    }


    /**
     * Sets the ijpdcaprojeto value for this Ijpdcaparticipproj.
     * 
     * @param ijpdcaprojeto
     */
    public void setIjpdcaprojeto(idw.idwws.Ijpdcaprojeto ijpdcaprojeto) {
        this.ijpdcaprojeto = ijpdcaprojeto;
    }


    /**
     * Gets the ijtbusu value for this Ijpdcaparticipproj.
     * 
     * @return ijtbusu
     */
    public idw.idwws.Ijtbusu getIjtbusu() {
        return ijtbusu;
    }


    /**
     * Sets the ijtbusu value for this Ijpdcaparticipproj.
     * 
     * @param ijtbusu
     */
    public void setIjtbusu(idw.idwws.Ijtbusu ijtbusu) {
        this.ijtbusu = ijtbusu;
    }


    /**
     * Gets the ijtbusumail value for this Ijpdcaparticipproj.
     * 
     * @return ijtbusumail
     */
    public idw.idwws.Ijtbusumail getIjtbusumail() {
        return ijtbusumail;
    }


    /**
     * Sets the ijtbusumail value for this Ijpdcaparticipproj.
     * 
     * @param ijtbusumail
     */
    public void setIjtbusumail(idw.idwws.Ijtbusumail ijtbusumail) {
        this.ijtbusumail = ijtbusumail;
    }


    /**
     * Gets the nmparticipprojeto value for this Ijpdcaparticipproj.
     * 
     * @return nmparticipprojeto
     */
    public java.lang.String getNmparticipprojeto() {
        return nmparticipprojeto;
    }


    /**
     * Sets the nmparticipprojeto value for this Ijpdcaparticipproj.
     * 
     * @param nmparticipprojeto
     */
    public void setNmparticipprojeto(java.lang.String nmparticipprojeto) {
        this.nmparticipprojeto = nmparticipprojeto;
    }


    /**
     * Gets the participadm value for this Ijpdcaparticipproj.
     * 
     * @return participadm
     */
    public java.math.BigDecimal getParticipadm() {
        return participadm;
    }


    /**
     * Sets the participadm value for this Ijpdcaparticipproj.
     * 
     * @param participadm
     */
    public void setParticipadm(java.math.BigDecimal participadm) {
        this.participadm = participadm;
    }


    /**
     * Gets the tpparticipante value for this Ijpdcaparticipproj.
     * 
     * @return tpparticipante
     */
    public java.math.BigDecimal getTpparticipante() {
        return tpparticipante;
    }


    /**
     * Sets the tpparticipante value for this Ijpdcaparticipproj.
     * 
     * @param tpparticipante
     */
    public void setTpparticipante(java.math.BigDecimal tpparticipante) {
        this.tpparticipante = tpparticipante;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijpdcaparticipproj)) return false;
        Ijpdcaparticipproj other = (Ijpdcaparticipproj) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.ijpdcaagndacmpefts==null && other.getIjpdcaagndacmpefts()==null) || 
             (this.ijpdcaagndacmpefts!=null &&
              java.util.Arrays.equals(this.ijpdcaagndacmpefts, other.getIjpdcaagndacmpefts()))) &&
            ((this.ijpdcaagndacmps==null && other.getIjpdcaagndacmps()==null) || 
             (this.ijpdcaagndacmps!=null &&
              java.util.Arrays.equals(this.ijpdcaagndacmps, other.getIjpdcaagndacmps()))) &&
            ((this.ijpdcaprojeto==null && other.getIjpdcaprojeto()==null) || 
             (this.ijpdcaprojeto!=null &&
              this.ijpdcaprojeto.equals(other.getIjpdcaprojeto()))) &&
            ((this.ijtbusu==null && other.getIjtbusu()==null) || 
             (this.ijtbusu!=null &&
              this.ijtbusu.equals(other.getIjtbusu()))) &&
            ((this.ijtbusumail==null && other.getIjtbusumail()==null) || 
             (this.ijtbusumail!=null &&
              this.ijtbusumail.equals(other.getIjtbusumail()))) &&
            ((this.nmparticipprojeto==null && other.getNmparticipprojeto()==null) || 
             (this.nmparticipprojeto!=null &&
              this.nmparticipprojeto.equals(other.getNmparticipprojeto()))) &&
            ((this.participadm==null && other.getParticipadm()==null) || 
             (this.participadm!=null &&
              this.participadm.equals(other.getParticipadm()))) &&
            ((this.tpparticipante==null && other.getTpparticipante()==null) || 
             (this.tpparticipante!=null &&
              this.tpparticipante.equals(other.getTpparticipante())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getIjpdcaagndacmpefts() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpdcaagndacmpefts());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpdcaagndacmpefts(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpdcaagndacmps() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpdcaagndacmps());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpdcaagndacmps(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpdcaprojeto() != null) {
            _hashCode += getIjpdcaprojeto().hashCode();
        }
        if (getIjtbusu() != null) {
            _hashCode += getIjtbusu().hashCode();
        }
        if (getIjtbusumail() != null) {
            _hashCode += getIjtbusumail().hashCode();
        }
        if (getNmparticipprojeto() != null) {
            _hashCode += getNmparticipprojeto().hashCode();
        }
        if (getParticipadm() != null) {
            _hashCode += getParticipadm().hashCode();
        }
        if (getTpparticipante() != null) {
            _hashCode += getTpparticipante().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijpdcaparticipproj.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaparticipproj"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaparticipprojId"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcaagndacmpefts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcaagndacmpefts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaagndacmpeft"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcaagndacmps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcaagndacmps"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaagndacmp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcaprojeto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcaprojeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaprojeto"));
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
        elemField.setFieldName("ijtbusumail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusumail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusumail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nmparticipprojeto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nmparticipprojeto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("participadm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "participadm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tpparticipante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tpparticipante"));
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
