/**
 * DetalhamentoProducaoDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DetalhamentoProducaoDTO  implements java.io.Serializable {
    private java.lang.Double cicmedio;

    private java.lang.Double cicpadraomedio;

    private java.util.Calendar dthrfim;

    private java.util.Calendar dthrinicio;

    private java.lang.String duracaointervalo;

    private java.lang.Double horasparadas;

    private java.lang.Double horastrabalhadas;

    private java.lang.Double indiceparadas;

    private idw.idwws.DetalheParadaDTO[] listaparadas;

    private idw.idwws.DetalheProducaoDTO[] listaproducao;

    private idw.idwws.DetalheRefugoDTO[] listarefugos;

    private java.lang.Double perdascic;

    private java.lang.Double perdasparadas;

    private java.lang.Double perdasrefugos;

    private java.lang.Double tempodisponivel;

    private java.lang.Double totalperdas;

    public DetalhamentoProducaoDTO() {
    }

    public DetalhamentoProducaoDTO(
           java.lang.Double cicmedio,
           java.lang.Double cicpadraomedio,
           java.util.Calendar dthrfim,
           java.util.Calendar dthrinicio,
           java.lang.String duracaointervalo,
           java.lang.Double horasparadas,
           java.lang.Double horastrabalhadas,
           java.lang.Double indiceparadas,
           idw.idwws.DetalheParadaDTO[] listaparadas,
           idw.idwws.DetalheProducaoDTO[] listaproducao,
           idw.idwws.DetalheRefugoDTO[] listarefugos,
           java.lang.Double perdascic,
           java.lang.Double perdasparadas,
           java.lang.Double perdasrefugos,
           java.lang.Double tempodisponivel,
           java.lang.Double totalperdas) {
           this.cicmedio = cicmedio;
           this.cicpadraomedio = cicpadraomedio;
           this.dthrfim = dthrfim;
           this.dthrinicio = dthrinicio;
           this.duracaointervalo = duracaointervalo;
           this.horasparadas = horasparadas;
           this.horastrabalhadas = horastrabalhadas;
           this.indiceparadas = indiceparadas;
           this.listaparadas = listaparadas;
           this.listaproducao = listaproducao;
           this.listarefugos = listarefugos;
           this.perdascic = perdascic;
           this.perdasparadas = perdasparadas;
           this.perdasrefugos = perdasrefugos;
           this.tempodisponivel = tempodisponivel;
           this.totalperdas = totalperdas;
    }


    /**
     * Gets the cicmedio value for this DetalhamentoProducaoDTO.
     * 
     * @return cicmedio
     */
    public java.lang.Double getCicmedio() {
        return cicmedio;
    }


    /**
     * Sets the cicmedio value for this DetalhamentoProducaoDTO.
     * 
     * @param cicmedio
     */
    public void setCicmedio(java.lang.Double cicmedio) {
        this.cicmedio = cicmedio;
    }


    /**
     * Gets the cicpadraomedio value for this DetalhamentoProducaoDTO.
     * 
     * @return cicpadraomedio
     */
    public java.lang.Double getCicpadraomedio() {
        return cicpadraomedio;
    }


    /**
     * Sets the cicpadraomedio value for this DetalhamentoProducaoDTO.
     * 
     * @param cicpadraomedio
     */
    public void setCicpadraomedio(java.lang.Double cicpadraomedio) {
        this.cicpadraomedio = cicpadraomedio;
    }


    /**
     * Gets the dthrfim value for this DetalhamentoProducaoDTO.
     * 
     * @return dthrfim
     */
    public java.util.Calendar getDthrfim() {
        return dthrfim;
    }


    /**
     * Sets the dthrfim value for this DetalhamentoProducaoDTO.
     * 
     * @param dthrfim
     */
    public void setDthrfim(java.util.Calendar dthrfim) {
        this.dthrfim = dthrfim;
    }


    /**
     * Gets the dthrinicio value for this DetalhamentoProducaoDTO.
     * 
     * @return dthrinicio
     */
    public java.util.Calendar getDthrinicio() {
        return dthrinicio;
    }


    /**
     * Sets the dthrinicio value for this DetalhamentoProducaoDTO.
     * 
     * @param dthrinicio
     */
    public void setDthrinicio(java.util.Calendar dthrinicio) {
        this.dthrinicio = dthrinicio;
    }


    /**
     * Gets the duracaointervalo value for this DetalhamentoProducaoDTO.
     * 
     * @return duracaointervalo
     */
    public java.lang.String getDuracaointervalo() {
        return duracaointervalo;
    }


    /**
     * Sets the duracaointervalo value for this DetalhamentoProducaoDTO.
     * 
     * @param duracaointervalo
     */
    public void setDuracaointervalo(java.lang.String duracaointervalo) {
        this.duracaointervalo = duracaointervalo;
    }


    /**
     * Gets the horasparadas value for this DetalhamentoProducaoDTO.
     * 
     * @return horasparadas
     */
    public java.lang.Double getHorasparadas() {
        return horasparadas;
    }


    /**
     * Sets the horasparadas value for this DetalhamentoProducaoDTO.
     * 
     * @param horasparadas
     */
    public void setHorasparadas(java.lang.Double horasparadas) {
        this.horasparadas = horasparadas;
    }


    /**
     * Gets the horastrabalhadas value for this DetalhamentoProducaoDTO.
     * 
     * @return horastrabalhadas
     */
    public java.lang.Double getHorastrabalhadas() {
        return horastrabalhadas;
    }


    /**
     * Sets the horastrabalhadas value for this DetalhamentoProducaoDTO.
     * 
     * @param horastrabalhadas
     */
    public void setHorastrabalhadas(java.lang.Double horastrabalhadas) {
        this.horastrabalhadas = horastrabalhadas;
    }


    /**
     * Gets the indiceparadas value for this DetalhamentoProducaoDTO.
     * 
     * @return indiceparadas
     */
    public java.lang.Double getIndiceparadas() {
        return indiceparadas;
    }


    /**
     * Sets the indiceparadas value for this DetalhamentoProducaoDTO.
     * 
     * @param indiceparadas
     */
    public void setIndiceparadas(java.lang.Double indiceparadas) {
        this.indiceparadas = indiceparadas;
    }


    /**
     * Gets the listaparadas value for this DetalhamentoProducaoDTO.
     * 
     * @return listaparadas
     */
    public idw.idwws.DetalheParadaDTO[] getListaparadas() {
        return listaparadas;
    }


    /**
     * Sets the listaparadas value for this DetalhamentoProducaoDTO.
     * 
     * @param listaparadas
     */
    public void setListaparadas(idw.idwws.DetalheParadaDTO[] listaparadas) {
        this.listaparadas = listaparadas;
    }

    public idw.idwws.DetalheParadaDTO getListaparadas(int i) {
        return this.listaparadas[i];
    }

    public void setListaparadas(int i, idw.idwws.DetalheParadaDTO _value) {
        this.listaparadas[i] = _value;
    }


    /**
     * Gets the listaproducao value for this DetalhamentoProducaoDTO.
     * 
     * @return listaproducao
     */
    public idw.idwws.DetalheProducaoDTO[] getListaproducao() {
        return listaproducao;
    }


    /**
     * Sets the listaproducao value for this DetalhamentoProducaoDTO.
     * 
     * @param listaproducao
     */
    public void setListaproducao(idw.idwws.DetalheProducaoDTO[] listaproducao) {
        this.listaproducao = listaproducao;
    }

    public idw.idwws.DetalheProducaoDTO getListaproducao(int i) {
        return this.listaproducao[i];
    }

    public void setListaproducao(int i, idw.idwws.DetalheProducaoDTO _value) {
        this.listaproducao[i] = _value;
    }


    /**
     * Gets the listarefugos value for this DetalhamentoProducaoDTO.
     * 
     * @return listarefugos
     */
    public idw.idwws.DetalheRefugoDTO[] getListarefugos() {
        return listarefugos;
    }


    /**
     * Sets the listarefugos value for this DetalhamentoProducaoDTO.
     * 
     * @param listarefugos
     */
    public void setListarefugos(idw.idwws.DetalheRefugoDTO[] listarefugos) {
        this.listarefugos = listarefugos;
    }

    public idw.idwws.DetalheRefugoDTO getListarefugos(int i) {
        return this.listarefugos[i];
    }

    public void setListarefugos(int i, idw.idwws.DetalheRefugoDTO _value) {
        this.listarefugos[i] = _value;
    }


    /**
     * Gets the perdascic value for this DetalhamentoProducaoDTO.
     * 
     * @return perdascic
     */
    public java.lang.Double getPerdascic() {
        return perdascic;
    }


    /**
     * Sets the perdascic value for this DetalhamentoProducaoDTO.
     * 
     * @param perdascic
     */
    public void setPerdascic(java.lang.Double perdascic) {
        this.perdascic = perdascic;
    }


    /**
     * Gets the perdasparadas value for this DetalhamentoProducaoDTO.
     * 
     * @return perdasparadas
     */
    public java.lang.Double getPerdasparadas() {
        return perdasparadas;
    }


    /**
     * Sets the perdasparadas value for this DetalhamentoProducaoDTO.
     * 
     * @param perdasparadas
     */
    public void setPerdasparadas(java.lang.Double perdasparadas) {
        this.perdasparadas = perdasparadas;
    }


    /**
     * Gets the perdasrefugos value for this DetalhamentoProducaoDTO.
     * 
     * @return perdasrefugos
     */
    public java.lang.Double getPerdasrefugos() {
        return perdasrefugos;
    }


    /**
     * Sets the perdasrefugos value for this DetalhamentoProducaoDTO.
     * 
     * @param perdasrefugos
     */
    public void setPerdasrefugos(java.lang.Double perdasrefugos) {
        this.perdasrefugos = perdasrefugos;
    }


    /**
     * Gets the tempodisponivel value for this DetalhamentoProducaoDTO.
     * 
     * @return tempodisponivel
     */
    public java.lang.Double getTempodisponivel() {
        return tempodisponivel;
    }


    /**
     * Sets the tempodisponivel value for this DetalhamentoProducaoDTO.
     * 
     * @param tempodisponivel
     */
    public void setTempodisponivel(java.lang.Double tempodisponivel) {
        this.tempodisponivel = tempodisponivel;
    }


    /**
     * Gets the totalperdas value for this DetalhamentoProducaoDTO.
     * 
     * @return totalperdas
     */
    public java.lang.Double getTotalperdas() {
        return totalperdas;
    }


    /**
     * Sets the totalperdas value for this DetalhamentoProducaoDTO.
     * 
     * @param totalperdas
     */
    public void setTotalperdas(java.lang.Double totalperdas) {
        this.totalperdas = totalperdas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetalhamentoProducaoDTO)) return false;
        DetalhamentoProducaoDTO other = (DetalhamentoProducaoDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cicmedio==null && other.getCicmedio()==null) || 
             (this.cicmedio!=null &&
              this.cicmedio.equals(other.getCicmedio()))) &&
            ((this.cicpadraomedio==null && other.getCicpadraomedio()==null) || 
             (this.cicpadraomedio!=null &&
              this.cicpadraomedio.equals(other.getCicpadraomedio()))) &&
            ((this.dthrfim==null && other.getDthrfim()==null) || 
             (this.dthrfim!=null &&
              this.dthrfim.equals(other.getDthrfim()))) &&
            ((this.dthrinicio==null && other.getDthrinicio()==null) || 
             (this.dthrinicio!=null &&
              this.dthrinicio.equals(other.getDthrinicio()))) &&
            ((this.duracaointervalo==null && other.getDuracaointervalo()==null) || 
             (this.duracaointervalo!=null &&
              this.duracaointervalo.equals(other.getDuracaointervalo()))) &&
            ((this.horasparadas==null && other.getHorasparadas()==null) || 
             (this.horasparadas!=null &&
              this.horasparadas.equals(other.getHorasparadas()))) &&
            ((this.horastrabalhadas==null && other.getHorastrabalhadas()==null) || 
             (this.horastrabalhadas!=null &&
              this.horastrabalhadas.equals(other.getHorastrabalhadas()))) &&
            ((this.indiceparadas==null && other.getIndiceparadas()==null) || 
             (this.indiceparadas!=null &&
              this.indiceparadas.equals(other.getIndiceparadas()))) &&
            ((this.listaparadas==null && other.getListaparadas()==null) || 
             (this.listaparadas!=null &&
              java.util.Arrays.equals(this.listaparadas, other.getListaparadas()))) &&
            ((this.listaproducao==null && other.getListaproducao()==null) || 
             (this.listaproducao!=null &&
              java.util.Arrays.equals(this.listaproducao, other.getListaproducao()))) &&
            ((this.listarefugos==null && other.getListarefugos()==null) || 
             (this.listarefugos!=null &&
              java.util.Arrays.equals(this.listarefugos, other.getListarefugos()))) &&
            ((this.perdascic==null && other.getPerdascic()==null) || 
             (this.perdascic!=null &&
              this.perdascic.equals(other.getPerdascic()))) &&
            ((this.perdasparadas==null && other.getPerdasparadas()==null) || 
             (this.perdasparadas!=null &&
              this.perdasparadas.equals(other.getPerdasparadas()))) &&
            ((this.perdasrefugos==null && other.getPerdasrefugos()==null) || 
             (this.perdasrefugos!=null &&
              this.perdasrefugos.equals(other.getPerdasrefugos()))) &&
            ((this.tempodisponivel==null && other.getTempodisponivel()==null) || 
             (this.tempodisponivel!=null &&
              this.tempodisponivel.equals(other.getTempodisponivel()))) &&
            ((this.totalperdas==null && other.getTotalperdas()==null) || 
             (this.totalperdas!=null &&
              this.totalperdas.equals(other.getTotalperdas())));
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
        if (getCicmedio() != null) {
            _hashCode += getCicmedio().hashCode();
        }
        if (getCicpadraomedio() != null) {
            _hashCode += getCicpadraomedio().hashCode();
        }
        if (getDthrfim() != null) {
            _hashCode += getDthrfim().hashCode();
        }
        if (getDthrinicio() != null) {
            _hashCode += getDthrinicio().hashCode();
        }
        if (getDuracaointervalo() != null) {
            _hashCode += getDuracaointervalo().hashCode();
        }
        if (getHorasparadas() != null) {
            _hashCode += getHorasparadas().hashCode();
        }
        if (getHorastrabalhadas() != null) {
            _hashCode += getHorastrabalhadas().hashCode();
        }
        if (getIndiceparadas() != null) {
            _hashCode += getIndiceparadas().hashCode();
        }
        if (getListaparadas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaparadas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaparadas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaproducao() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaproducao());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaproducao(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListarefugos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListarefugos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListarefugos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPerdascic() != null) {
            _hashCode += getPerdascic().hashCode();
        }
        if (getPerdasparadas() != null) {
            _hashCode += getPerdasparadas().hashCode();
        }
        if (getPerdasrefugos() != null) {
            _hashCode += getPerdasrefugos().hashCode();
        }
        if (getTempodisponivel() != null) {
            _hashCode += getTempodisponivel().hashCode();
        }
        if (getTotalperdas() != null) {
            _hashCode += getTotalperdas().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetalhamentoProducaoDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalhamentoProducaoDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicmedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicmedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cicpadraomedio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cicpadraomedio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfim");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracaointervalo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracaointervalo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horasparadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "horasparadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horastrabalhadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "horastrabalhadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indiceparadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indiceparadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaparadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaparadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheParadaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaproducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaproducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheProducaoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listarefugos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listarefugos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "detalheRefugoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdascic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdascic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdasparadas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdasparadas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("perdasrefugos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "perdasrefugos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tempodisponivel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tempodisponivel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalperdas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "totalperdas"));
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
