/**
 * MapasCODTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class MapasCODTO  implements java.io.Serializable {
    private idw.idwws.MapaCODTO mapaAtual;

    private long mapaConferidoParaPT;

    private idw.idwws.MapaCODTO mapaCorrente;

    private boolean mapaCorrenteExclusivo;

    private long mapaCorrenteParaPT;

    private long mapaPreConferidoParaPT;

    private idw.idwws.MapaCODTO[] mapas;

    private java.lang.String programaNaMaquina;

    public MapasCODTO() {
    }

    public MapasCODTO(
           idw.idwws.MapaCODTO mapaAtual,
           long mapaConferidoParaPT,
           idw.idwws.MapaCODTO mapaCorrente,
           boolean mapaCorrenteExclusivo,
           long mapaCorrenteParaPT,
           long mapaPreConferidoParaPT,
           idw.idwws.MapaCODTO[] mapas,
           java.lang.String programaNaMaquina) {
           this.mapaAtual = mapaAtual;
           this.mapaConferidoParaPT = mapaConferidoParaPT;
           this.mapaCorrente = mapaCorrente;
           this.mapaCorrenteExclusivo = mapaCorrenteExclusivo;
           this.mapaCorrenteParaPT = mapaCorrenteParaPT;
           this.mapaPreConferidoParaPT = mapaPreConferidoParaPT;
           this.mapas = mapas;
           this.programaNaMaquina = programaNaMaquina;
    }


    /**
     * Gets the mapaAtual value for this MapasCODTO.
     * 
     * @return mapaAtual
     */
    public idw.idwws.MapaCODTO getMapaAtual() {
        return mapaAtual;
    }


    /**
     * Sets the mapaAtual value for this MapasCODTO.
     * 
     * @param mapaAtual
     */
    public void setMapaAtual(idw.idwws.MapaCODTO mapaAtual) {
        this.mapaAtual = mapaAtual;
    }


    /**
     * Gets the mapaConferidoParaPT value for this MapasCODTO.
     * 
     * @return mapaConferidoParaPT
     */
    public long getMapaConferidoParaPT() {
        return mapaConferidoParaPT;
    }


    /**
     * Sets the mapaConferidoParaPT value for this MapasCODTO.
     * 
     * @param mapaConferidoParaPT
     */
    public void setMapaConferidoParaPT(long mapaConferidoParaPT) {
        this.mapaConferidoParaPT = mapaConferidoParaPT;
    }


    /**
     * Gets the mapaCorrente value for this MapasCODTO.
     * 
     * @return mapaCorrente
     */
    public idw.idwws.MapaCODTO getMapaCorrente() {
        return mapaCorrente;
    }


    /**
     * Sets the mapaCorrente value for this MapasCODTO.
     * 
     * @param mapaCorrente
     */
    public void setMapaCorrente(idw.idwws.MapaCODTO mapaCorrente) {
        this.mapaCorrente = mapaCorrente;
    }


    /**
     * Gets the mapaCorrenteExclusivo value for this MapasCODTO.
     * 
     * @return mapaCorrenteExclusivo
     */
    public boolean isMapaCorrenteExclusivo() {
        return mapaCorrenteExclusivo;
    }


    /**
     * Sets the mapaCorrenteExclusivo value for this MapasCODTO.
     * 
     * @param mapaCorrenteExclusivo
     */
    public void setMapaCorrenteExclusivo(boolean mapaCorrenteExclusivo) {
        this.mapaCorrenteExclusivo = mapaCorrenteExclusivo;
    }


    /**
     * Gets the mapaCorrenteParaPT value for this MapasCODTO.
     * 
     * @return mapaCorrenteParaPT
     */
    public long getMapaCorrenteParaPT() {
        return mapaCorrenteParaPT;
    }


    /**
     * Sets the mapaCorrenteParaPT value for this MapasCODTO.
     * 
     * @param mapaCorrenteParaPT
     */
    public void setMapaCorrenteParaPT(long mapaCorrenteParaPT) {
        this.mapaCorrenteParaPT = mapaCorrenteParaPT;
    }


    /**
     * Gets the mapaPreConferidoParaPT value for this MapasCODTO.
     * 
     * @return mapaPreConferidoParaPT
     */
    public long getMapaPreConferidoParaPT() {
        return mapaPreConferidoParaPT;
    }


    /**
     * Sets the mapaPreConferidoParaPT value for this MapasCODTO.
     * 
     * @param mapaPreConferidoParaPT
     */
    public void setMapaPreConferidoParaPT(long mapaPreConferidoParaPT) {
        this.mapaPreConferidoParaPT = mapaPreConferidoParaPT;
    }


    /**
     * Gets the mapas value for this MapasCODTO.
     * 
     * @return mapas
     */
    public idw.idwws.MapaCODTO[] getMapas() {
        return mapas;
    }


    /**
     * Sets the mapas value for this MapasCODTO.
     * 
     * @param mapas
     */
    public void setMapas(idw.idwws.MapaCODTO[] mapas) {
        this.mapas = mapas;
    }

    public idw.idwws.MapaCODTO getMapas(int i) {
        return this.mapas[i];
    }

    public void setMapas(int i, idw.idwws.MapaCODTO _value) {
        this.mapas[i] = _value;
    }


    /**
     * Gets the programaNaMaquina value for this MapasCODTO.
     * 
     * @return programaNaMaquina
     */
    public java.lang.String getProgramaNaMaquina() {
        return programaNaMaquina;
    }


    /**
     * Sets the programaNaMaquina value for this MapasCODTO.
     * 
     * @param programaNaMaquina
     */
    public void setProgramaNaMaquina(java.lang.String programaNaMaquina) {
        this.programaNaMaquina = programaNaMaquina;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MapasCODTO)) return false;
        MapasCODTO other = (MapasCODTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mapaAtual==null && other.getMapaAtual()==null) || 
             (this.mapaAtual!=null &&
              this.mapaAtual.equals(other.getMapaAtual()))) &&
            this.mapaConferidoParaPT == other.getMapaConferidoParaPT() &&
            ((this.mapaCorrente==null && other.getMapaCorrente()==null) || 
             (this.mapaCorrente!=null &&
              this.mapaCorrente.equals(other.getMapaCorrente()))) &&
            this.mapaCorrenteExclusivo == other.isMapaCorrenteExclusivo() &&
            this.mapaCorrenteParaPT == other.getMapaCorrenteParaPT() &&
            this.mapaPreConferidoParaPT == other.getMapaPreConferidoParaPT() &&
            ((this.mapas==null && other.getMapas()==null) || 
             (this.mapas!=null &&
              java.util.Arrays.equals(this.mapas, other.getMapas()))) &&
            ((this.programaNaMaquina==null && other.getProgramaNaMaquina()==null) || 
             (this.programaNaMaquina!=null &&
              this.programaNaMaquina.equals(other.getProgramaNaMaquina())));
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
        if (getMapaAtual() != null) {
            _hashCode += getMapaAtual().hashCode();
        }
        _hashCode += new Long(getMapaConferidoParaPT()).hashCode();
        if (getMapaCorrente() != null) {
            _hashCode += getMapaCorrente().hashCode();
        }
        _hashCode += (isMapaCorrenteExclusivo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += new Long(getMapaCorrenteParaPT()).hashCode();
        _hashCode += new Long(getMapaPreConferidoParaPT()).hashCode();
        if (getMapas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMapas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMapas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProgramaNaMaquina() != null) {
            _hashCode += getProgramaNaMaquina().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MapasCODTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mapasCODTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapaAtual");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapaAtual"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mapaCODTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapaConferidoParaPT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapaConferidoParaPT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapaCorrente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapaCorrente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mapaCODTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapaCorrenteExclusivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapaCorrenteExclusivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapaCorrenteParaPT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapaCorrenteParaPT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapaPreConferidoParaPT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapaPreConferidoParaPT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mapas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "mapaCODTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programaNaMaquina");
        elemField.setXmlName(new javax.xml.namespace.QName("", "programaNaMaquina"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
