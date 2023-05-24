/**
 * Ijtbusumail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbusumail  implements java.io.Serializable {
    private java.lang.String cdusumail;

    private java.util.Calendar dthrcadastro;

    private java.util.Calendar dthrsaida;

    private java.lang.String endemail1;

    private java.lang.String endemail2;

    private idw.idwws.Ijgrpusuemail[] ijgrpusuemails;

    private idw.idwws.Ijpdcaparticipproj[] ijpdcaparticipprojs;

    private idw.idwws.Ijtbset ijtbset;

    private idw.idwws.Ijtbusumail ijtbusumail;

    private idw.idwws.Ijtbusumail[] ijtbusumails;

    private idw.idwws.Ijtbusumailsms[] ijtbusumailsmses;

    private idw.idwws.Ijtbusu[] ijtbusus;

    private java.lang.String indenvioemail;

    private java.lang.String indformacorpo;

    private java.lang.String indformatitulo;

    private java.lang.String nome;

    public Ijtbusumail() {
    }

    public Ijtbusumail(
           java.lang.String cdusumail,
           java.util.Calendar dthrcadastro,
           java.util.Calendar dthrsaida,
           java.lang.String endemail1,
           java.lang.String endemail2,
           idw.idwws.Ijgrpusuemail[] ijgrpusuemails,
           idw.idwws.Ijpdcaparticipproj[] ijpdcaparticipprojs,
           idw.idwws.Ijtbset ijtbset,
           idw.idwws.Ijtbusumail ijtbusumail,
           idw.idwws.Ijtbusumail[] ijtbusumails,
           idw.idwws.Ijtbusumailsms[] ijtbusumailsmses,
           idw.idwws.Ijtbusu[] ijtbusus,
           java.lang.String indenvioemail,
           java.lang.String indformacorpo,
           java.lang.String indformatitulo,
           java.lang.String nome) {
           this.cdusumail = cdusumail;
           this.dthrcadastro = dthrcadastro;
           this.dthrsaida = dthrsaida;
           this.endemail1 = endemail1;
           this.endemail2 = endemail2;
           this.ijgrpusuemails = ijgrpusuemails;
           this.ijpdcaparticipprojs = ijpdcaparticipprojs;
           this.ijtbset = ijtbset;
           this.ijtbusumail = ijtbusumail;
           this.ijtbusumails = ijtbusumails;
           this.ijtbusumailsmses = ijtbusumailsmses;
           this.ijtbusus = ijtbusus;
           this.indenvioemail = indenvioemail;
           this.indformacorpo = indformacorpo;
           this.indformatitulo = indformatitulo;
           this.nome = nome;
    }


    /**
     * Gets the cdusumail value for this Ijtbusumail.
     * 
     * @return cdusumail
     */
    public java.lang.String getCdusumail() {
        return cdusumail;
    }


    /**
     * Sets the cdusumail value for this Ijtbusumail.
     * 
     * @param cdusumail
     */
    public void setCdusumail(java.lang.String cdusumail) {
        this.cdusumail = cdusumail;
    }


    /**
     * Gets the dthrcadastro value for this Ijtbusumail.
     * 
     * @return dthrcadastro
     */
    public java.util.Calendar getDthrcadastro() {
        return dthrcadastro;
    }


    /**
     * Sets the dthrcadastro value for this Ijtbusumail.
     * 
     * @param dthrcadastro
     */
    public void setDthrcadastro(java.util.Calendar dthrcadastro) {
        this.dthrcadastro = dthrcadastro;
    }


    /**
     * Gets the dthrsaida value for this Ijtbusumail.
     * 
     * @return dthrsaida
     */
    public java.util.Calendar getDthrsaida() {
        return dthrsaida;
    }


    /**
     * Sets the dthrsaida value for this Ijtbusumail.
     * 
     * @param dthrsaida
     */
    public void setDthrsaida(java.util.Calendar dthrsaida) {
        this.dthrsaida = dthrsaida;
    }


    /**
     * Gets the endemail1 value for this Ijtbusumail.
     * 
     * @return endemail1
     */
    public java.lang.String getEndemail1() {
        return endemail1;
    }


    /**
     * Sets the endemail1 value for this Ijtbusumail.
     * 
     * @param endemail1
     */
    public void setEndemail1(java.lang.String endemail1) {
        this.endemail1 = endemail1;
    }


    /**
     * Gets the endemail2 value for this Ijtbusumail.
     * 
     * @return endemail2
     */
    public java.lang.String getEndemail2() {
        return endemail2;
    }


    /**
     * Sets the endemail2 value for this Ijtbusumail.
     * 
     * @param endemail2
     */
    public void setEndemail2(java.lang.String endemail2) {
        this.endemail2 = endemail2;
    }


    /**
     * Gets the ijgrpusuemails value for this Ijtbusumail.
     * 
     * @return ijgrpusuemails
     */
    public idw.idwws.Ijgrpusuemail[] getIjgrpusuemails() {
        return ijgrpusuemails;
    }


    /**
     * Sets the ijgrpusuemails value for this Ijtbusumail.
     * 
     * @param ijgrpusuemails
     */
    public void setIjgrpusuemails(idw.idwws.Ijgrpusuemail[] ijgrpusuemails) {
        this.ijgrpusuemails = ijgrpusuemails;
    }

    public idw.idwws.Ijgrpusuemail getIjgrpusuemails(int i) {
        return this.ijgrpusuemails[i];
    }

    public void setIjgrpusuemails(int i, idw.idwws.Ijgrpusuemail _value) {
        this.ijgrpusuemails[i] = _value;
    }


    /**
     * Gets the ijpdcaparticipprojs value for this Ijtbusumail.
     * 
     * @return ijpdcaparticipprojs
     */
    public idw.idwws.Ijpdcaparticipproj[] getIjpdcaparticipprojs() {
        return ijpdcaparticipprojs;
    }


    /**
     * Sets the ijpdcaparticipprojs value for this Ijtbusumail.
     * 
     * @param ijpdcaparticipprojs
     */
    public void setIjpdcaparticipprojs(idw.idwws.Ijpdcaparticipproj[] ijpdcaparticipprojs) {
        this.ijpdcaparticipprojs = ijpdcaparticipprojs;
    }

    public idw.idwws.Ijpdcaparticipproj getIjpdcaparticipprojs(int i) {
        return this.ijpdcaparticipprojs[i];
    }

    public void setIjpdcaparticipprojs(int i, idw.idwws.Ijpdcaparticipproj _value) {
        this.ijpdcaparticipprojs[i] = _value;
    }


    /**
     * Gets the ijtbset value for this Ijtbusumail.
     * 
     * @return ijtbset
     */
    public idw.idwws.Ijtbset getIjtbset() {
        return ijtbset;
    }


    /**
     * Sets the ijtbset value for this Ijtbusumail.
     * 
     * @param ijtbset
     */
    public void setIjtbset(idw.idwws.Ijtbset ijtbset) {
        this.ijtbset = ijtbset;
    }


    /**
     * Gets the ijtbusumail value for this Ijtbusumail.
     * 
     * @return ijtbusumail
     */
    public idw.idwws.Ijtbusumail getIjtbusumail() {
        return ijtbusumail;
    }


    /**
     * Sets the ijtbusumail value for this Ijtbusumail.
     * 
     * @param ijtbusumail
     */
    public void setIjtbusumail(idw.idwws.Ijtbusumail ijtbusumail) {
        this.ijtbusumail = ijtbusumail;
    }


    /**
     * Gets the ijtbusumails value for this Ijtbusumail.
     * 
     * @return ijtbusumails
     */
    public idw.idwws.Ijtbusumail[] getIjtbusumails() {
        return ijtbusumails;
    }


    /**
     * Sets the ijtbusumails value for this Ijtbusumail.
     * 
     * @param ijtbusumails
     */
    public void setIjtbusumails(idw.idwws.Ijtbusumail[] ijtbusumails) {
        this.ijtbusumails = ijtbusumails;
    }

    public idw.idwws.Ijtbusumail getIjtbusumails(int i) {
        return this.ijtbusumails[i];
    }

    public void setIjtbusumails(int i, idw.idwws.Ijtbusumail _value) {
        this.ijtbusumails[i] = _value;
    }


    /**
     * Gets the ijtbusumailsmses value for this Ijtbusumail.
     * 
     * @return ijtbusumailsmses
     */
    public idw.idwws.Ijtbusumailsms[] getIjtbusumailsmses() {
        return ijtbusumailsmses;
    }


    /**
     * Sets the ijtbusumailsmses value for this Ijtbusumail.
     * 
     * @param ijtbusumailsmses
     */
    public void setIjtbusumailsmses(idw.idwws.Ijtbusumailsms[] ijtbusumailsmses) {
        this.ijtbusumailsmses = ijtbusumailsmses;
    }

    public idw.idwws.Ijtbusumailsms getIjtbusumailsmses(int i) {
        return this.ijtbusumailsmses[i];
    }

    public void setIjtbusumailsmses(int i, idw.idwws.Ijtbusumailsms _value) {
        this.ijtbusumailsmses[i] = _value;
    }


    /**
     * Gets the ijtbusus value for this Ijtbusumail.
     * 
     * @return ijtbusus
     */
    public idw.idwws.Ijtbusu[] getIjtbusus() {
        return ijtbusus;
    }


    /**
     * Sets the ijtbusus value for this Ijtbusumail.
     * 
     * @param ijtbusus
     */
    public void setIjtbusus(idw.idwws.Ijtbusu[] ijtbusus) {
        this.ijtbusus = ijtbusus;
    }

    public idw.idwws.Ijtbusu getIjtbusus(int i) {
        return this.ijtbusus[i];
    }

    public void setIjtbusus(int i, idw.idwws.Ijtbusu _value) {
        this.ijtbusus[i] = _value;
    }


    /**
     * Gets the indenvioemail value for this Ijtbusumail.
     * 
     * @return indenvioemail
     */
    public java.lang.String getIndenvioemail() {
        return indenvioemail;
    }


    /**
     * Sets the indenvioemail value for this Ijtbusumail.
     * 
     * @param indenvioemail
     */
    public void setIndenvioemail(java.lang.String indenvioemail) {
        this.indenvioemail = indenvioemail;
    }


    /**
     * Gets the indformacorpo value for this Ijtbusumail.
     * 
     * @return indformacorpo
     */
    public java.lang.String getIndformacorpo() {
        return indformacorpo;
    }


    /**
     * Sets the indformacorpo value for this Ijtbusumail.
     * 
     * @param indformacorpo
     */
    public void setIndformacorpo(java.lang.String indformacorpo) {
        this.indformacorpo = indformacorpo;
    }


    /**
     * Gets the indformatitulo value for this Ijtbusumail.
     * 
     * @return indformatitulo
     */
    public java.lang.String getIndformatitulo() {
        return indformatitulo;
    }


    /**
     * Sets the indformatitulo value for this Ijtbusumail.
     * 
     * @param indformatitulo
     */
    public void setIndformatitulo(java.lang.String indformatitulo) {
        this.indformatitulo = indformatitulo;
    }


    /**
     * Gets the nome value for this Ijtbusumail.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Ijtbusumail.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbusumail)) return false;
        Ijtbusumail other = (Ijtbusumail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cdusumail==null && other.getCdusumail()==null) || 
             (this.cdusumail!=null &&
              this.cdusumail.equals(other.getCdusumail()))) &&
            ((this.dthrcadastro==null && other.getDthrcadastro()==null) || 
             (this.dthrcadastro!=null &&
              this.dthrcadastro.equals(other.getDthrcadastro()))) &&
            ((this.dthrsaida==null && other.getDthrsaida()==null) || 
             (this.dthrsaida!=null &&
              this.dthrsaida.equals(other.getDthrsaida()))) &&
            ((this.endemail1==null && other.getEndemail1()==null) || 
             (this.endemail1!=null &&
              this.endemail1.equals(other.getEndemail1()))) &&
            ((this.endemail2==null && other.getEndemail2()==null) || 
             (this.endemail2!=null &&
              this.endemail2.equals(other.getEndemail2()))) &&
            ((this.ijgrpusuemails==null && other.getIjgrpusuemails()==null) || 
             (this.ijgrpusuemails!=null &&
              java.util.Arrays.equals(this.ijgrpusuemails, other.getIjgrpusuemails()))) &&
            ((this.ijpdcaparticipprojs==null && other.getIjpdcaparticipprojs()==null) || 
             (this.ijpdcaparticipprojs!=null &&
              java.util.Arrays.equals(this.ijpdcaparticipprojs, other.getIjpdcaparticipprojs()))) &&
            ((this.ijtbset==null && other.getIjtbset()==null) || 
             (this.ijtbset!=null &&
              this.ijtbset.equals(other.getIjtbset()))) &&
            ((this.ijtbusumail==null && other.getIjtbusumail()==null) || 
             (this.ijtbusumail!=null &&
              this.ijtbusumail.equals(other.getIjtbusumail()))) &&
            ((this.ijtbusumails==null && other.getIjtbusumails()==null) || 
             (this.ijtbusumails!=null &&
              java.util.Arrays.equals(this.ijtbusumails, other.getIjtbusumails()))) &&
            ((this.ijtbusumailsmses==null && other.getIjtbusumailsmses()==null) || 
             (this.ijtbusumailsmses!=null &&
              java.util.Arrays.equals(this.ijtbusumailsmses, other.getIjtbusumailsmses()))) &&
            ((this.ijtbusus==null && other.getIjtbusus()==null) || 
             (this.ijtbusus!=null &&
              java.util.Arrays.equals(this.ijtbusus, other.getIjtbusus()))) &&
            ((this.indenvioemail==null && other.getIndenvioemail()==null) || 
             (this.indenvioemail!=null &&
              this.indenvioemail.equals(other.getIndenvioemail()))) &&
            ((this.indformacorpo==null && other.getIndformacorpo()==null) || 
             (this.indformacorpo!=null &&
              this.indformacorpo.equals(other.getIndformacorpo()))) &&
            ((this.indformatitulo==null && other.getIndformatitulo()==null) || 
             (this.indformatitulo!=null &&
              this.indformatitulo.equals(other.getIndformatitulo()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome())));
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
        if (getCdusumail() != null) {
            _hashCode += getCdusumail().hashCode();
        }
        if (getDthrcadastro() != null) {
            _hashCode += getDthrcadastro().hashCode();
        }
        if (getDthrsaida() != null) {
            _hashCode += getDthrsaida().hashCode();
        }
        if (getEndemail1() != null) {
            _hashCode += getEndemail1().hashCode();
        }
        if (getEndemail2() != null) {
            _hashCode += getEndemail2().hashCode();
        }
        if (getIjgrpusuemails() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjgrpusuemails());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjgrpusuemails(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjpdcaparticipprojs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjpdcaparticipprojs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjpdcaparticipprojs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbset() != null) {
            _hashCode += getIjtbset().hashCode();
        }
        if (getIjtbusumail() != null) {
            _hashCode += getIjtbusumail().hashCode();
        }
        if (getIjtbusumails() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbusumails());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbusumails(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbusumailsmses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbusumailsmses());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbusumailsmses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIjtbusus() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIjtbusus());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIjtbusus(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIndenvioemail() != null) {
            _hashCode += getIndenvioemail().hashCode();
        }
        if (getIndformacorpo() != null) {
            _hashCode += getIndformacorpo().hashCode();
        }
        if (getIndformatitulo() != null) {
            _hashCode += getIndformatitulo().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbusumail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusumail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdusumail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdusumail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrcadastro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrcadastro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dthrsaida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dthrsaida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endemail1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endemail1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endemail2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endemail2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijgrpusuemails");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijgrpusuemails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijgrpusuemail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijpdcaparticipprojs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijpdcaparticipprojs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijpdcaparticipproj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbset");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbset"));
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
        elemField.setFieldName("ijtbusumails");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusumails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusumail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusumailsmses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusumailsmses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusumailsms"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbusus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbusus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbusu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indenvioemail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indenvioemail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indformacorpo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indformacorpo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indformatitulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indformatitulo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
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
