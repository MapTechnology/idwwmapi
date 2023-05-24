/**
 * Ijctrliniproc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijctrliniproc  implements java.io.Serializable {
    private java.util.Calendar dthrfimctrliniproc;

    private java.util.Calendar dthrinictrliniproc;

    private java.util.Calendar dthriniparentrada;

    private java.util.Calendar dthriniparsaida;

    private java.lang.String idctrlinicproc;

    private idw.idwws.Ijctrliniprocprod[] ijctrliniprocprods;

    private idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocas;

    private idw.idwws.Ijop ijop;

    private idw.idwws.Ijreapar[] ijreapars;

    private idw.idwws.Ijrearef[] ijrearefs;

    private idw.idwws.Ijtbinj ijtbinj;

    private idw.idwws.Ijtbusu ijtbusuByCdtecfinal;

    private idw.idwws.Ijtbusu ijtbusuByCdtecinicio;

    public Ijctrliniproc() {
    }

    public Ijctrliniproc(
           java.util.Calendar dthrfimctrliniproc,
           java.util.Calendar dthrinictrliniproc,
           java.util.Calendar dthriniparentrada,
           java.util.Calendar dthriniparsaida,
           java.lang.String idctrlinicproc,
           idw.idwws.Ijctrliniprocprod[] ijctrliniprocprods,
           idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocas,
           idw.idwws.Ijop ijop,
           idw.idwws.Ijreapar[] ijreapars,
           idw.idwws.Ijrearef[] ijrearefs,
           idw.idwws.Ijtbinj ijtbinj,
           idw.idwws.Ijtbusu ijtbusuByCdtecfinal,
           idw.idwws.Ijtbusu ijtbusuByCdtecinicio) {
           this.dthrfimctrliniproc = dthrfimctrliniproc;
           this.dthrinictrliniproc = dthrinictrliniproc;
           this.dthriniparentrada = dthriniparentrada;
           this.dthriniparsaida = dthriniparsaida;
           this.idctrlinicproc = idctrlinicproc;
           this.ijctrliniprocprods = ijctrliniprocprods;
           this.ijctrliniproctrocas = ijctrliniproctrocas;
           this.ijop = ijop;
           this.ijreapars = ijreapars;
           this.ijrearefs = ijrearefs;
           this.ijtbinj = ijtbinj;
           this.ijtbusuByCdtecfinal = ijtbusuByCdtecfinal;
           this.ijtbusuByCdtecinicio = ijtbusuByCdtecinicio;
    }


    /**
     * Gets the dthrfimctrliniproc value for this Ijctrliniproc.
     * 
     * @return dthrfimctrliniproc
     */
    public java.util.Calendar getDthrfimctrliniproc() {
        return dthrfimctrliniproc;
    }


    /**
     * Sets the dthrfimctrliniproc value for this Ijctrliniproc.
     * 
     * @param dthrfimctrliniproc
     */
    public void setDthrfimctrliniproc(java.util.Calendar dthrfimctrliniproc) {
        this.dthrfimctrliniproc = dthrfimctrliniproc;
    }


    /**
     * Gets the dthrinictrliniproc value for this Ijctrliniproc.
     * 
     * @return dthrinictrliniproc
     */
    public java.util.Calendar getDthrinictrliniproc() {
        return dthrinictrliniproc;
    }


    /**
     * Sets the dthrinictrliniproc value for this Ijctrliniproc.
     * 
     * @param dthrinictrliniproc
     */
    public void setDthrinictrliniproc(java.util.Calendar dthrinictrliniproc) {
        this.dthrinictrliniproc = dthrinictrliniproc;
    }


    /**
     * Gets the dthriniparentrada value for this Ijctrliniproc.
     * 
     * @return dthriniparentrada
     */
    public java.util.Calendar getDthriniparentrada() {
        return dthriniparentrada;
    }


    /**
     * Sets the dthriniparentrada value for this Ijctrliniproc.
     * 
     * @param dthriniparentrada
     */
    public void setDthriniparentrada(java.util.Calendar dthriniparentrada) {
        this.dthriniparentrada = dthriniparentrada;
    }


    /**
     * Gets the dthriniparsaida value for this Ijctrliniproc.
     * 
     * @return dthriniparsaida
     */
    public java.util.Calendar getDthriniparsaida() {
        return dthriniparsaida;
    }


    /**
     * Sets the dthriniparsaida value for this Ijctrliniproc.
     * 
     * @param dthriniparsaida
     */
    public void setDthriniparsaida(java.util.Calendar dthriniparsaida) {
        this.dthriniparsaida = dthriniparsaida;
    }


    /**
     * Gets the idctrlinicproc value for this Ijctrliniproc.
     * 
     * @return idctrlinicproc
     */
    public java.lang.String getIdctrlinicproc() {
        return idctrlinicproc;
    }


    /**
     * Sets the idctrlinicproc value for this Ijctrliniproc.
     * 
     * @param idctrlinicproc
     */
    public void setIdctrlinicproc(java.lang.String idctrlinicproc) {
        this.idctrlinicproc = idctrlinicproc;
    }


    /**
     * Gets the ijctrliniprocprods value for this Ijctrliniproc.
     * 
     * @return ijctrliniprocprods
     */
    public idw.idwws.Ijctrliniprocprod[] getIjctrliniprocprods() {
        return ijctrliniprocprods;
    }


    /**
     * Sets the ijctrliniprocprods value for this Ijctrliniproc.
     * 
     * @param ijctrliniprocprods
     */
    public void setIjctrliniprocprods(idw.idwws.Ijctrliniprocprod[] ijctrliniprocprods) {
        this.ijctrliniprocprods = ijctrliniprocprods;
    }

    public idw.idwws.Ijctrliniprocprod getIjctrliniprocprods(int i) {
        return this.ijctrliniprocprods[i];
    }

    public void setIjctrliniprocprods(int i, idw.idwws.Ijctrliniprocprod _value) {
        this.ijctrliniprocprods[i] = _value;
    }


    /**
     * Gets the ijctrliniproctrocas value for this Ijctrliniproc.
     * 
     * @return ijctrliniproctrocas
     */
    public idw.idwws.Ijctrliniproctroca[] getIjctrliniproctrocas() {
        return ijctrliniproctrocas;
    }


    /**
     * Sets the ijctrliniproctrocas value for this Ijctrliniproc.
     * 
     * @param ijctrliniproctrocas
     */
    public void setIjctrliniproctrocas(idw.idwws.Ijctrliniproctroca[] ijctrliniproctrocas) {
        this.ijctrliniproctrocas = ijctrliniproctrocas;
    }

    public idw.idwws.Ijctrliniproctroca getIjctrliniproctrocas(int i) {
        return this.ijctrliniproctrocas[i];
    }

    public void setIjctrliniproctrocas(int i, idw.idwws.Ijctrliniproctroca _value) {
        this.ijctrliniproctrocas[i] = _value;
    }


    /**
     * Gets the ijop value for this Ijctrliniproc.
     * 
     * @return ijop
     */
    public idw.idwws.Ijop getIjop() {
        return ijop;
    }


    /**
     * Sets the ijop value for this Ijctrliniproc.
     * 
     * @param ijop
     */
    public void setIjop(idw.idwws.Ijop ijop) {
        this.ijop = ijop;
    }


    /**
     * Gets the ijreapars value for this Ijctrliniproc.
     * 
     * @return ijreapars
     */
    public idw.idwws.Ijreapar[] getIjreapars() {
        return ijreapars;
    }


    /**
     * Sets the ijreapars value for this Ijctrliniproc.
     * 
     * @param ijreapars
     */
    public void setIjreapars(idw.idwws.Ijreapar[] ijreapars) {
        this.ijreapars = ijreapars;
    }

    public idw.idwws.Ijreapar getIjreapars(int i) {
        return this.ijreapars[i];
    }

    public void setIjreapars(int i, idw.idwws.Ijreapar _value) {
        this.ijreapars[i] = _value;
    }


    /**
     * Gets the ijrearefs value for this Ijctrliniproc.
     * 
     * @return ijrearefs
     */
    public idw.idwws.Ijrearef[] getIjrearefs() {
        return ijrearefs;
    }


    /**
     * Sets the ijrearefs value for this Ijctrliniproc.
     * 
     * @param ijrearefs
     */
    public void setIjrearefs(idw.idwws.Ijrearef[] ijrearefs) {
        this.ijrearefs = ijrearefs;
    }

    public idw.idwws.Ijrearef getIjrearefs(int i) {
        return this.ijrearefs[i];
    }

    public void setIjrearefs(int i, idw.idwws.Ijrearef _value) {
        this.ijrearefs[i] = _value;
    }


    /**
     * Gets the ijtbinj value for this Ijctrliniproc.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijctrliniproc.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the ijtbusuByCdtecfinal value for this Ijctrliniproc.
     * 
     * @return ijtbusuByCdtecfinal
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdtecfinal() {
        return ijtbusuByCdtecfinal;
    }


    /**
     * Sets the ijtbusuByCdtecfinal value for this Ijctrliniproc.
     * 
     * @param ijtbusuByCdtecfinal
     */
    public void setIjtbusuByCdtecfinal(idw.idwws.Ijtbusu ijtbusuByCdtecfinal) {
        this.ijtbusuByCdtecfinal = ijtbusuByCdtecfinal;
    }


    /**
     * Gets the ijtbusuByCdtecinicio value for this Ijctrliniproc.
     * 
     * @return ijtbusuByCdtecinicio
     */
    public idw.idwws.Ijtbusu getIjtbusuByCdtecinicio() {
        return ijtbusuByCdtecinicio;
    }


    /**
     * Sets the ijtbusuByCdtecinicio value for this Ijctrliniproc.
     * 
     * @param ijtbusuByCdtecinicio
     */
    public void setIjtbusuByCdtecinicio(idw.idwws.Ijtbusu ijtbusuByCdtecinicio) {
        this.ijtbusuByCdtecinicio = ijtbusuByCdtecinicio;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijctrliniproc)) return false;
        Ijctrliniproc other = (Ijctrliniproc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dthrfimctrliniproc==null && other.getDthrfimctrliniproc()==null) || 
             (this.dthrfimctrliniproc!=null &&
              this.dthrfimctrliniproc.equals(other.getDthrfimctrliniproc()))) &&
            ((this.dthrinictrliniproc==null && other.getDthrinictrliniproc()==null) || 
             (this.dthrinictrliniproc!=null &&
              this.dthrinictrliniproc.equals(other.getDthrinictrliniproc()))) &&
            ((this.dthriniparentrada==null && other.getDthriniparentrada()==null) || 
             (this.dthriniparentrada!=null &&
              this.dthriniparentrada.equals(other.getDthriniparentrada()))) &&
            ((this.dthriniparsaida==null && other.getDthriniparsaida()==null) || 
             (this.dthriniparsaida!=null &&
              this.dthriniparsaida.equals(other.getDthriniparsaida()))) &&
            ((this.idctrlinicproc==null && other.getIdctrlinicproc()==null) || 
             (this.idctrlinicproc!=null &&
              this.idctrlinicproc.equals(other.getIdctrlinicproc()))) &&
            ((this.ijctrliniprocprods==null && other.getIjctrliniprocprods()==null) || 
             (this.ijctrliniprocprods!=null &&
              java.util.Arrays.equals(this.ijctrliniprocprods, other.getIjctrliniprocprods()))) &&
            ((this.ijctrliniproctrocas==null && other.getIjctrliniproctrocas()==null) || 
             (this.ijctrliniproctrocas!=null &&
              java.util.Arrays.equals(this.ijctrliniproctrocas, other.getIjctrliniproctrocas()))) &&
            ((this.ijop==null && other.getIjop()==null) || 
             (this.ijop!=null &&
              this.ijop.equals(other.getIjop()))) &&
            ((this.ijreapars==null && other.getIjreapars()==null) || 
             (this.ijreapars!=null &&
              java.util.Arrays.equals(this.ijreapars, other.getIjreapars()))) &&
            ((this.ijrearefs==null && other.getIjrearefs()==null) || 
             (this.ijrearefs!=null &&
              java.util.Arrays.equals(this.ijrearefs, other.getIjrearefs()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.ijtbusuByCdtecfinal==null && other.getIjtbusuByCdtecfinal()==null) || 
             (this.ijtbusuByCdtecfinal!=null &&
              this.ijtbusuByCdtecfinal.equals(other.getIjtbusuByCdtecfinal()))) &&
            ((this.ijtbusuByCdtecinicio==null && other.getIjtbusuByCdtecinicio()==null) || 
             (this.ijtbusuByCdtecinicio!=null &&
              this.ijtbusuByCdtecinicio.equals(other.getIjtbusuByCdtecinicio())));
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
        if (getDthrfimctrliniproc() != null) {
            _hashCode += getDthrfimctrliniproc().hashCode();
        }
        if (getDthrinictrliniproc() != null) {
            _hashCode += getDthrinictrliniproc().hashCode();
        }
        if (getDthriniparentrada() != null) {
            _hashCode += getDthriniparentrada().hashCode();
        }
        if (getDthriniparsaida() != null) {
            _hashCode += getDthriniparsaida().hashCode();
        }
        if (getIdctrlinicproc() != null) {
            _hashCode += getIdctrlinicproc().hashCode();
        }
        if (getIjctrliniprocprods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrliniprocprods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrliniprocprods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjctrliniproctrocas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjctrliniproctrocas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjctrliniproctrocas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjop() != null) {
            _hashCode += getIjop().hashCode();
        }
        if (getIjreapars() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjreapars());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjreapars(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjrearefs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjrearefs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjrearefs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getIjtbusuByCdtecfinal() != null) {
            _hashCode += getIjtbusuByCdtecfinal().hashCode();
        }
        if (getIjtbusuByCdtecinicio() != null) {
            _hashCode += getIjtbusuByCdtecinicio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijctrliniproc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrfimctrliniproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrfimctrliniproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrinictrliniproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrinictrliniproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriniparentrada");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriniparentrada"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthriniparsaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthriniparsaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idctrlinicproc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idctrlinicproc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrliniprocprods");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniprocprods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniprocprod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijctrliniproctrocas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijctrliniproctrocas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijctrliniproctroca"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijop"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijreapars");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijreapars"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijreapar"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijrearefs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijrearefs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijrearef"));
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
        elemField.setFieldName("ijtbusuByCdtecfinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdtecfinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusuByCdtecinicio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusuByCdtecinicio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
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
