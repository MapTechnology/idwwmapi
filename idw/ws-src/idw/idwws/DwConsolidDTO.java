/**
 * DwConsolidDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class DwConsolidDTO  implements java.io.Serializable {
    private idw.idwws.DwConsolid dwConsolid;

    private int ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA;

    private int ERRO_DESCONHECIDO;

    private int ERRO_FOLHA_DESCONHECIDA;

    private int ERRO_PT_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private double eficienciaCiclo;

    private int isProducao;

    private double lie;

    private idw.idwws.DwFolhaDTO[] listaProgramas;

    private idw.idwws.ApontamentoTurnoDTO[] listaValoresTurnos;

    private double lse;

    private int resultado;

    public DwConsolidDTO() {
    }

    public DwConsolidDTO(
           idw.idwws.DwConsolid dwConsolid,
           int ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA,
           int ERRO_DESCONHECIDO,
           int ERRO_FOLHA_DESCONHECIDA,
           int ERRO_PT_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           double eficienciaCiclo,
           int isProducao,
           double lie,
           idw.idwws.DwFolhaDTO[] listaProgramas,
           idw.idwws.ApontamentoTurnoDTO[] listaValoresTurnos,
           double lse,
           int resultado) {
           this.dwConsolid = dwConsolid;
           this.ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA = ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_FOLHA_DESCONHECIDA = ERRO_FOLHA_DESCONHECIDA;
           this.ERRO_PT_DESCONHECIDO = ERRO_PT_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.eficienciaCiclo = eficienciaCiclo;
           this.isProducao = isProducao;
           this.lie = lie;
           this.listaProgramas = listaProgramas;
           this.listaValoresTurnos = listaValoresTurnos;
           this.lse = lse;
           this.resultado = resultado;
    }


    /**
     * Gets the dwConsolid value for this DwConsolidDTO.
     * 
     * @return dwConsolid
     */
    public idw.idwws.DwConsolid getDwConsolid() {
        return dwConsolid;
    }


    /**
     * Sets the dwConsolid value for this DwConsolidDTO.
     * 
     * @param dwConsolid
     */
    public void setDwConsolid(idw.idwws.DwConsolid dwConsolid) {
        this.dwConsolid = dwConsolid;
    }


    /**
     * Gets the ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA value for this DwConsolidDTO.
     * 
     * @return ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA
     */
    public int getERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA() {
        return ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA;
    }


    /**
     * Sets the ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA value for this DwConsolidDTO.
     * 
     * @param ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA
     */
    public void setERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA(int ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA) {
        this.ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA = ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this DwConsolidDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this DwConsolidDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_FOLHA_DESCONHECIDA value for this DwConsolidDTO.
     * 
     * @return ERRO_FOLHA_DESCONHECIDA
     */
    public int getERRO_FOLHA_DESCONHECIDA() {
        return ERRO_FOLHA_DESCONHECIDA;
    }


    /**
     * Sets the ERRO_FOLHA_DESCONHECIDA value for this DwConsolidDTO.
     * 
     * @param ERRO_FOLHA_DESCONHECIDA
     */
    public void setERRO_FOLHA_DESCONHECIDA(int ERRO_FOLHA_DESCONHECIDA) {
        this.ERRO_FOLHA_DESCONHECIDA = ERRO_FOLHA_DESCONHECIDA;
    }


    /**
     * Gets the ERRO_PT_DESCONHECIDO value for this DwConsolidDTO.
     * 
     * @return ERRO_PT_DESCONHECIDO
     */
    public int getERRO_PT_DESCONHECIDO() {
        return ERRO_PT_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_PT_DESCONHECIDO value for this DwConsolidDTO.
     * 
     * @param ERRO_PT_DESCONHECIDO
     */
    public void setERRO_PT_DESCONHECIDO(int ERRO_PT_DESCONHECIDO) {
        this.ERRO_PT_DESCONHECIDO = ERRO_PT_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this DwConsolidDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this DwConsolidDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the eficienciaCiclo value for this DwConsolidDTO.
     * 
     * @return eficienciaCiclo
     */
    public double getEficienciaCiclo() {
        return eficienciaCiclo;
    }


    /**
     * Sets the eficienciaCiclo value for this DwConsolidDTO.
     * 
     * @param eficienciaCiclo
     */
    public void setEficienciaCiclo(double eficienciaCiclo) {
        this.eficienciaCiclo = eficienciaCiclo;
    }


    /**
     * Gets the isProducao value for this DwConsolidDTO.
     * 
     * @return isProducao
     */
    public int getIsProducao() {
        return isProducao;
    }


    /**
     * Sets the isProducao value for this DwConsolidDTO.
     * 
     * @param isProducao
     */
    public void setIsProducao(int isProducao) {
        this.isProducao = isProducao;
    }


    /**
     * Gets the lie value for this DwConsolidDTO.
     * 
     * @return lie
     */
    public double getLie() {
        return lie;
    }


    /**
     * Sets the lie value for this DwConsolidDTO.
     * 
     * @param lie
     */
    public void setLie(double lie) {
        this.lie = lie;
    }


    /**
     * Gets the listaProgramas value for this DwConsolidDTO.
     * 
     * @return listaProgramas
     */
    public idw.idwws.DwFolhaDTO[] getListaProgramas() {
        return listaProgramas;
    }


    /**
     * Sets the listaProgramas value for this DwConsolidDTO.
     * 
     * @param listaProgramas
     */
    public void setListaProgramas(idw.idwws.DwFolhaDTO[] listaProgramas) {
        this.listaProgramas = listaProgramas;
    }

    public idw.idwws.DwFolhaDTO getListaProgramas(int i) {
        return this.listaProgramas[i];
    }

    public void setListaProgramas(int i, idw.idwws.DwFolhaDTO _value) {
        this.listaProgramas[i] = _value;
    }


    /**
     * Gets the listaValoresTurnos value for this DwConsolidDTO.
     * 
     * @return listaValoresTurnos
     */
    public idw.idwws.ApontamentoTurnoDTO[] getListaValoresTurnos() {
        return listaValoresTurnos;
    }


    /**
     * Sets the listaValoresTurnos value for this DwConsolidDTO.
     * 
     * @param listaValoresTurnos
     */
    public void setListaValoresTurnos(idw.idwws.ApontamentoTurnoDTO[] listaValoresTurnos) {
        this.listaValoresTurnos = listaValoresTurnos;
    }

    public idw.idwws.ApontamentoTurnoDTO getListaValoresTurnos(int i) {
        return this.listaValoresTurnos[i];
    }

    public void setListaValoresTurnos(int i, idw.idwws.ApontamentoTurnoDTO _value) {
        this.listaValoresTurnos[i] = _value;
    }


    /**
     * Gets the lse value for this DwConsolidDTO.
     * 
     * @return lse
     */
    public double getLse() {
        return lse;
    }


    /**
     * Sets the lse value for this DwConsolidDTO.
     * 
     * @param lse
     */
    public void setLse(double lse) {
        this.lse = lse;
    }


    /**
     * Gets the resultado value for this DwConsolidDTO.
     * 
     * @return resultado
     */
    public int getResultado() {
        return resultado;
    }


    /**
     * Sets the resultado value for this DwConsolidDTO.
     * 
     * @param resultado
     */
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DwConsolidDTO)) return false;
        DwConsolidDTO other = (DwConsolidDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dwConsolid==null && other.getDwConsolid()==null) || 
             (this.dwConsolid!=null &&
              this.dwConsolid.equals(other.getDwConsolid()))) &&
            this.ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA == other.getERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_FOLHA_DESCONHECIDA == other.getERRO_FOLHA_DESCONHECIDA() &&
            this.ERRO_PT_DESCONHECIDO == other.getERRO_PT_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            this.eficienciaCiclo == other.getEficienciaCiclo() &&
            this.isProducao == other.getIsProducao() &&
            this.lie == other.getLie() &&
            ((this.listaProgramas==null && other.getListaProgramas()==null) || 
             (this.listaProgramas!=null &&
              java.util.Arrays.equals(this.listaProgramas, other.getListaProgramas()))) &&
            ((this.listaValoresTurnos==null && other.getListaValoresTurnos()==null) || 
             (this.listaValoresTurnos!=null &&
              java.util.Arrays.equals(this.listaValoresTurnos, other.getListaValoresTurnos()))) &&
            this.lse == other.getLse() &&
            this.resultado == other.getResultado();
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
        if (getDwConsolid() != null) {
            _hashCode += getDwConsolid().hashCode();
        }
        _hashCode += getERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_FOLHA_DESCONHECIDA();
        _hashCode += getERRO_PT_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        _hashCode += new Double(getEficienciaCiclo()).hashCode();
        _hashCode += getIsProducao();
        _hashCode += new Double(getLie()).hashCode();
        if (getListaProgramas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaProgramas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaProgramas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaValoresTurnos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaValoresTurnos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaValoresTurnos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Double(getLse()).hashCode();
        _hashCode += getResultado();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DwConsolidDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolidDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dwConsolid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dwConsolid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwConsolid"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_FOLHA_DESCONHECIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_FOLHA_DESCONHECIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PT_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PT_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EVENTO_BEM_SUCEDIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EVENTO_BEM_SUCEDIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eficienciaCiclo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eficienciaCiclo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isProducao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isProducao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaProgramas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaProgramas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwFolhaDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaValoresTurnos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "listaValoresTurnos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "apontamentoTurnoDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
