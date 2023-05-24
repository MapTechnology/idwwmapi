/**
 * DwProreaativobs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwProreaativobs  extends idw.idwws.DwProreaativobsTemplate  implements java.io.Serializable {
    private java.lang.Long idProreaativobs;

    private java.lang.String dsObs;

    private byte[] foto;

    private byte[] audio;

    private java.util.Calendar dthrObs;

    private java.lang.Boolean isFoto;

    private java.lang.Boolean isTexto;

    private java.lang.Boolean isAudio;

    private idw.idwws.DwProreaativ dwProreaativ;

    public DwProreaativobs() {
    }

    public DwProreaativobs(
           java.lang.Long idProreaativobs,
           java.lang.String dsObs,
           byte[] foto,
           byte[] audio,
           java.util.Calendar dthrObs,
           java.lang.Boolean isFoto,
           java.lang.Boolean isTexto,
           java.lang.Boolean isAudio,
           idw.idwws.DwProreaativ dwProreaativ) {
        this.idProreaativobs = idProreaativobs;
        this.dsObs = dsObs;
        this.foto = foto;
        this.audio = audio;
        this.dthrObs = dthrObs;
        this.isFoto = isFoto;
        this.isTexto = isTexto;
        this.isAudio = isAudio;
        this.dwProreaativ = dwProreaativ;
    }


    /**
     * Gets the idProreaativobs value for this DwProreaativobs.
     * 
     * @return idProreaativobs
     */
    public java.lang.Long getIdProreaativobs() {
        return idProreaativobs;
    }


    /**
     * Sets the idProreaativobs value for this DwProreaativobs.
     * 
     * @param idProreaativobs
     */
    public void setIdProreaativobs(java.lang.Long idProreaativobs) {
        this.idProreaativobs = idProreaativobs;
    }


    /**
     * Gets the dsObs value for this DwProreaativobs.
     * 
     * @return dsObs
     */
    public java.lang.String getDsObs() {
        return dsObs;
    }


    /**
     * Sets the dsObs value for this DwProreaativobs.
     * 
     * @param dsObs
     */
    public void setDsObs(java.lang.String dsObs) {
        this.dsObs = dsObs;
    }


    /**
     * Gets the foto value for this DwProreaativobs.
     * 
     * @return foto
     */
    public byte[] getFoto() {
        return foto;
    }


    /**
     * Sets the foto value for this DwProreaativobs.
     * 
     * @param foto
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }


    /**
     * Gets the audio value for this DwProreaativobs.
     * 
     * @return audio
     */
    public byte[] getAudio() {
        return audio;
    }


    /**
     * Sets the audio value for this DwProreaativobs.
     * 
     * @param audio
     */
    public void setAudio(byte[] audio) {
        this.audio = audio;
    }


    /**
     * Gets the dthrObs value for this DwProreaativobs.
     * 
     * @return dthrObs
     */
    public java.util.Calendar getDthrObs() {
        return dthrObs;
    }


    /**
     * Sets the dthrObs value for this DwProreaativobs.
     * 
     * @param dthrObs
     */
    public void setDthrObs(java.util.Calendar dthrObs) {
        this.dthrObs = dthrObs;
    }


    /**
     * Gets the isFoto value for this DwProreaativobs.
     * 
     * @return isFoto
     */
    public java.lang.Boolean getIsFoto() {
        return isFoto;
    }


    /**
     * Sets the isFoto value for this DwProreaativobs.
     * 
     * @param isFoto
     */
    public void setIsFoto(java.lang.Boolean isFoto) {
        this.isFoto = isFoto;
    }


    /**
     * Gets the isTexto value for this DwProreaativobs.
     * 
     * @return isTexto
     */
    public java.lang.Boolean getIsTexto() {
        return isTexto;
    }


    /**
     * Sets the isTexto value for this DwProreaativobs.
     * 
     * @param isTexto
     */
    public void setIsTexto(java.lang.Boolean isTexto) {
        this.isTexto = isTexto;
    }


    /**
     * Gets the isAudio value for this DwProreaativobs.
     * 
     * @return isAudio
     */
    public java.lang.Boolean getIsAudio() {
        return isAudio;
    }


    /**
     * Sets the isAudio value for this DwProreaativobs.
     * 
     * @param isAudio
     */
    public void setIsAudio(java.lang.Boolean isAudio) {
        this.isAudio = isAudio;
    }


    /**
     * Gets the dwProreaativ value for this DwProreaativobs.
     * 
     * @return dwProreaativ
     */
    public idw.idwws.DwProreaativ getDwProreaativ() {
        return dwProreaativ;
    }


    /**
     * Sets the dwProreaativ value for this DwProreaativobs.
     * 
     * @param dwProreaativ
     */
    public void setDwProreaativ(idw.idwws.DwProreaativ dwProreaativ) {
        this.dwProreaativ = dwProreaativ;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwProreaativobs)) return false;
        DwProreaativobs other = (DwProreaativobs) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.idProreaativobs==null && other.getIdProreaativobs()==null) || 
             (this.idProreaativobs!=null &&
              this.idProreaativobs.equals(other.getIdProreaativobs()))) &&
            ((this.dsObs==null && other.getDsObs()==null) || 
             (this.dsObs!=null &&
              this.dsObs.equals(other.getDsObs()))) &&
            ((this.foto==null && other.getFoto()==null) || 
             (this.foto!=null &&
              java.util.Arrays.equals(this.foto, other.getFoto()))) &&
            ((this.audio==null && other.getAudio()==null) || 
             (this.audio!=null &&
              java.util.Arrays.equals(this.audio, other.getAudio()))) &&
            ((this.dthrObs==null && other.getDthrObs()==null) || 
             (this.dthrObs!=null &&
              this.dthrObs.equals(other.getDthrObs()))) &&
            ((this.isFoto==null && other.getIsFoto()==null) || 
             (this.isFoto!=null &&
              this.isFoto.equals(other.getIsFoto()))) &&
            ((this.isTexto==null && other.getIsTexto()==null) || 
             (this.isTexto!=null &&
              this.isTexto.equals(other.getIsTexto()))) &&
            ((this.isAudio==null && other.getIsAudio()==null) || 
             (this.isAudio!=null &&
              this.isAudio.equals(other.getIsAudio()))) &&
            ((this.dwProreaativ==null && other.getDwProreaativ()==null) || 
             (this.dwProreaativ!=null &&
              this.dwProreaativ.equals(other.getDwProreaativ())));
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
        if (getIdProreaativobs() != null) {
            _hashCode += getIdProreaativobs().hashCode();
        }
        if (getDsObs() != null) {
            _hashCode += getDsObs().hashCode();
        }
        if (getFoto() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFoto());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFoto(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAudio() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAudio());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAudio(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDthrObs() != null) {
            _hashCode += getDthrObs().hashCode();
        }
        if (getIsFoto() != null) {
            _hashCode += getIsFoto().hashCode();
        }
        if (getIsTexto() != null) {
            _hashCode += getIsTexto().hashCode();
        }
        if (getIsAudio() != null) {
            _hashCode += getIsAudio().hashCode();
        }
        if (getDwProreaativ() != null) {
            _hashCode += getDwProreaativ().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwProreaativobs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProreaativobs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProreaativobs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idProreaativobs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dsObs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dsObs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("foto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "foto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("audio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "audio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrObs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrObs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isFoto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isFoto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTexto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isTexto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAudio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isAudio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwProreaativ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwProreaativ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwProreaativ"));
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
