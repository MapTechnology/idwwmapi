/**
 * Ijtbdnc.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class Ijtbdnc  implements java.io.Serializable {
    private double baudrate;

    private java.lang.String cdinjetora;

    private java.math.BigDecimal databit;

    private java.lang.String downloadext;

    private java.lang.String downloadpath;

    private java.lang.String flowcontrol;

    private idw.idwws.Ijtbinj ijtbinj;

    private java.lang.String parity;

    private org.apache.axis.types.UnsignedShort recignaftlasteob;

    private org.apache.axis.types.UnsignedShort recignbeffrsteob;

    private double rectimeout;

    private org.apache.axis.types.UnsignedShort serialport;

    private org.apache.axis.types.UnsignedShort sndcnvtucase;

    private java.math.BigDecimal snddelaybyte;

    private java.lang.String sndendblock;

    private java.lang.String sndendprog;

    private org.apache.axis.types.UnsignedShort sndignemptyblock;

    private java.lang.String sndignore;

    private java.lang.String sndrts;

    private java.lang.String sndstartprog;

    private org.apache.axis.types.UnsignedShort stativo;

    private java.math.BigDecimal stopbit;

    private org.apache.axis.types.UnsignedShort stsincronismo;

    private java.lang.String uploadext;

    private java.lang.String uploadpath;

    public Ijtbdnc() {
    }

    public Ijtbdnc(
           double baudrate,
           java.lang.String cdinjetora,
           java.math.BigDecimal databit,
           java.lang.String downloadext,
           java.lang.String downloadpath,
           java.lang.String flowcontrol,
           idw.idwws.Ijtbinj ijtbinj,
           java.lang.String parity,
           org.apache.axis.types.UnsignedShort recignaftlasteob,
           org.apache.axis.types.UnsignedShort recignbeffrsteob,
           double rectimeout,
           org.apache.axis.types.UnsignedShort serialport,
           org.apache.axis.types.UnsignedShort sndcnvtucase,
           java.math.BigDecimal snddelaybyte,
           java.lang.String sndendblock,
           java.lang.String sndendprog,
           org.apache.axis.types.UnsignedShort sndignemptyblock,
           java.lang.String sndignore,
           java.lang.String sndrts,
           java.lang.String sndstartprog,
           org.apache.axis.types.UnsignedShort stativo,
           java.math.BigDecimal stopbit,
           org.apache.axis.types.UnsignedShort stsincronismo,
           java.lang.String uploadext,
           java.lang.String uploadpath) {
           this.baudrate = baudrate;
           this.cdinjetora = cdinjetora;
           this.databit = databit;
           this.downloadext = downloadext;
           this.downloadpath = downloadpath;
           this.flowcontrol = flowcontrol;
           this.ijtbinj = ijtbinj;
           this.parity = parity;
           this.recignaftlasteob = recignaftlasteob;
           this.recignbeffrsteob = recignbeffrsteob;
           this.rectimeout = rectimeout;
           this.serialport = serialport;
           this.sndcnvtucase = sndcnvtucase;
           this.snddelaybyte = snddelaybyte;
           this.sndendblock = sndendblock;
           this.sndendprog = sndendprog;
           this.sndignemptyblock = sndignemptyblock;
           this.sndignore = sndignore;
           this.sndrts = sndrts;
           this.sndstartprog = sndstartprog;
           this.stativo = stativo;
           this.stopbit = stopbit;
           this.stsincronismo = stsincronismo;
           this.uploadext = uploadext;
           this.uploadpath = uploadpath;
    }


    /**
     * Gets the baudrate value for this Ijtbdnc.
     * 
     * @return baudrate
     */
    public double getBaudrate() {
        return baudrate;
    }


    /**
     * Sets the baudrate value for this Ijtbdnc.
     * 
     * @param baudrate
     */
    public void setBaudrate(double baudrate) {
        this.baudrate = baudrate;
    }


    /**
     * Gets the cdinjetora value for this Ijtbdnc.
     * 
     * @return cdinjetora
     */
    public java.lang.String getCdinjetora() {
        return cdinjetora;
    }


    /**
     * Sets the cdinjetora value for this Ijtbdnc.
     * 
     * @param cdinjetora
     */
    public void setCdinjetora(java.lang.String cdinjetora) {
        this.cdinjetora = cdinjetora;
    }


    /**
     * Gets the databit value for this Ijtbdnc.
     * 
     * @return databit
     */
    public java.math.BigDecimal getDatabit() {
        return databit;
    }


    /**
     * Sets the databit value for this Ijtbdnc.
     * 
     * @param databit
     */
    public void setDatabit(java.math.BigDecimal databit) {
        this.databit = databit;
    }


    /**
     * Gets the downloadext value for this Ijtbdnc.
     * 
     * @return downloadext
     */
    public java.lang.String getDownloadext() {
        return downloadext;
    }


    /**
     * Sets the downloadext value for this Ijtbdnc.
     * 
     * @param downloadext
     */
    public void setDownloadext(java.lang.String downloadext) {
        this.downloadext = downloadext;
    }


    /**
     * Gets the downloadpath value for this Ijtbdnc.
     * 
     * @return downloadpath
     */
    public java.lang.String getDownloadpath() {
        return downloadpath;
    }


    /**
     * Sets the downloadpath value for this Ijtbdnc.
     * 
     * @param downloadpath
     */
    public void setDownloadpath(java.lang.String downloadpath) {
        this.downloadpath = downloadpath;
    }


    /**
     * Gets the flowcontrol value for this Ijtbdnc.
     * 
     * @return flowcontrol
     */
    public java.lang.String getFlowcontrol() {
        return flowcontrol;
    }


    /**
     * Sets the flowcontrol value for this Ijtbdnc.
     * 
     * @param flowcontrol
     */
    public void setFlowcontrol(java.lang.String flowcontrol) {
        this.flowcontrol = flowcontrol;
    }


    /**
     * Gets the ijtbinj value for this Ijtbdnc.
     * 
     * @return ijtbinj
     */
    public idw.idwws.Ijtbinj getIjtbinj() {
        return ijtbinj;
    }


    /**
     * Sets the ijtbinj value for this Ijtbdnc.
     * 
     * @param ijtbinj
     */
    public void setIjtbinj(idw.idwws.Ijtbinj ijtbinj) {
        this.ijtbinj = ijtbinj;
    }


    /**
     * Gets the parity value for this Ijtbdnc.
     * 
     * @return parity
     */
    public java.lang.String getParity() {
        return parity;
    }


    /**
     * Sets the parity value for this Ijtbdnc.
     * 
     * @param parity
     */
    public void setParity(java.lang.String parity) {
        this.parity = parity;
    }


    /**
     * Gets the recignaftlasteob value for this Ijtbdnc.
     * 
     * @return recignaftlasteob
     */
    public org.apache.axis.types.UnsignedShort getRecignaftlasteob() {
        return recignaftlasteob;
    }


    /**
     * Sets the recignaftlasteob value for this Ijtbdnc.
     * 
     * @param recignaftlasteob
     */
    public void setRecignaftlasteob(org.apache.axis.types.UnsignedShort recignaftlasteob) {
        this.recignaftlasteob = recignaftlasteob;
    }


    /**
     * Gets the recignbeffrsteob value for this Ijtbdnc.
     * 
     * @return recignbeffrsteob
     */
    public org.apache.axis.types.UnsignedShort getRecignbeffrsteob() {
        return recignbeffrsteob;
    }


    /**
     * Sets the recignbeffrsteob value for this Ijtbdnc.
     * 
     * @param recignbeffrsteob
     */
    public void setRecignbeffrsteob(org.apache.axis.types.UnsignedShort recignbeffrsteob) {
        this.recignbeffrsteob = recignbeffrsteob;
    }


    /**
     * Gets the rectimeout value for this Ijtbdnc.
     * 
     * @return rectimeout
     */
    public double getRectimeout() {
        return rectimeout;
    }


    /**
     * Sets the rectimeout value for this Ijtbdnc.
     * 
     * @param rectimeout
     */
    public void setRectimeout(double rectimeout) {
        this.rectimeout = rectimeout;
    }


    /**
     * Gets the serialport value for this Ijtbdnc.
     * 
     * @return serialport
     */
    public org.apache.axis.types.UnsignedShort getSerialport() {
        return serialport;
    }


    /**
     * Sets the serialport value for this Ijtbdnc.
     * 
     * @param serialport
     */
    public void setSerialport(org.apache.axis.types.UnsignedShort serialport) {
        this.serialport = serialport;
    }


    /**
     * Gets the sndcnvtucase value for this Ijtbdnc.
     * 
     * @return sndcnvtucase
     */
    public org.apache.axis.types.UnsignedShort getSndcnvtucase() {
        return sndcnvtucase;
    }


    /**
     * Sets the sndcnvtucase value for this Ijtbdnc.
     * 
     * @param sndcnvtucase
     */
    public void setSndcnvtucase(org.apache.axis.types.UnsignedShort sndcnvtucase) {
        this.sndcnvtucase = sndcnvtucase;
    }


    /**
     * Gets the snddelaybyte value for this Ijtbdnc.
     * 
     * @return snddelaybyte
     */
    public java.math.BigDecimal getSnddelaybyte() {
        return snddelaybyte;
    }


    /**
     * Sets the snddelaybyte value for this Ijtbdnc.
     * 
     * @param snddelaybyte
     */
    public void setSnddelaybyte(java.math.BigDecimal snddelaybyte) {
        this.snddelaybyte = snddelaybyte;
    }


    /**
     * Gets the sndendblock value for this Ijtbdnc.
     * 
     * @return sndendblock
     */
    public java.lang.String getSndendblock() {
        return sndendblock;
    }


    /**
     * Sets the sndendblock value for this Ijtbdnc.
     * 
     * @param sndendblock
     */
    public void setSndendblock(java.lang.String sndendblock) {
        this.sndendblock = sndendblock;
    }


    /**
     * Gets the sndendprog value for this Ijtbdnc.
     * 
     * @return sndendprog
     */
    public java.lang.String getSndendprog() {
        return sndendprog;
    }


    /**
     * Sets the sndendprog value for this Ijtbdnc.
     * 
     * @param sndendprog
     */
    public void setSndendprog(java.lang.String sndendprog) {
        this.sndendprog = sndendprog;
    }


    /**
     * Gets the sndignemptyblock value for this Ijtbdnc.
     * 
     * @return sndignemptyblock
     */
    public org.apache.axis.types.UnsignedShort getSndignemptyblock() {
        return sndignemptyblock;
    }


    /**
     * Sets the sndignemptyblock value for this Ijtbdnc.
     * 
     * @param sndignemptyblock
     */
    public void setSndignemptyblock(org.apache.axis.types.UnsignedShort sndignemptyblock) {
        this.sndignemptyblock = sndignemptyblock;
    }


    /**
     * Gets the sndignore value for this Ijtbdnc.
     * 
     * @return sndignore
     */
    public java.lang.String getSndignore() {
        return sndignore;
    }


    /**
     * Sets the sndignore value for this Ijtbdnc.
     * 
     * @param sndignore
     */
    public void setSndignore(java.lang.String sndignore) {
        this.sndignore = sndignore;
    }


    /**
     * Gets the sndrts value for this Ijtbdnc.
     * 
     * @return sndrts
     */
    public java.lang.String getSndrts() {
        return sndrts;
    }


    /**
     * Sets the sndrts value for this Ijtbdnc.
     * 
     * @param sndrts
     */
    public void setSndrts(java.lang.String sndrts) {
        this.sndrts = sndrts;
    }


    /**
     * Gets the sndstartprog value for this Ijtbdnc.
     * 
     * @return sndstartprog
     */
    public java.lang.String getSndstartprog() {
        return sndstartprog;
    }


    /**
     * Sets the sndstartprog value for this Ijtbdnc.
     * 
     * @param sndstartprog
     */
    public void setSndstartprog(java.lang.String sndstartprog) {
        this.sndstartprog = sndstartprog;
    }


    /**
     * Gets the stativo value for this Ijtbdnc.
     * 
     * @return stativo
     */
    public org.apache.axis.types.UnsignedShort getStativo() {
        return stativo;
    }


    /**
     * Sets the stativo value for this Ijtbdnc.
     * 
     * @param stativo
     */
    public void setStativo(org.apache.axis.types.UnsignedShort stativo) {
        this.stativo = stativo;
    }


    /**
     * Gets the stopbit value for this Ijtbdnc.
     * 
     * @return stopbit
     */
    public java.math.BigDecimal getStopbit() {
        return stopbit;
    }


    /**
     * Sets the stopbit value for this Ijtbdnc.
     * 
     * @param stopbit
     */
    public void setStopbit(java.math.BigDecimal stopbit) {
        this.stopbit = stopbit;
    }


    /**
     * Gets the stsincronismo value for this Ijtbdnc.
     * 
     * @return stsincronismo
     */
    public org.apache.axis.types.UnsignedShort getStsincronismo() {
        return stsincronismo;
    }


    /**
     * Sets the stsincronismo value for this Ijtbdnc.
     * 
     * @param stsincronismo
     */
    public void setStsincronismo(org.apache.axis.types.UnsignedShort stsincronismo) {
        this.stsincronismo = stsincronismo;
    }


    /**
     * Gets the uploadext value for this Ijtbdnc.
     * 
     * @return uploadext
     */
    public java.lang.String getUploadext() {
        return uploadext;
    }


    /**
     * Sets the uploadext value for this Ijtbdnc.
     * 
     * @param uploadext
     */
    public void setUploadext(java.lang.String uploadext) {
        this.uploadext = uploadext;
    }


    /**
     * Gets the uploadpath value for this Ijtbdnc.
     * 
     * @return uploadpath
     */
    public java.lang.String getUploadpath() {
        return uploadpath;
    }


    /**
     * Sets the uploadpath value for this Ijtbdnc.
     * 
     * @param uploadpath
     */
    public void setUploadpath(java.lang.String uploadpath) {
        this.uploadpath = uploadpath;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ijtbdnc)) return false;
        Ijtbdnc other = (Ijtbdnc) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.baudrate == other.getBaudrate() &&
            ((this.cdinjetora==null && other.getCdinjetora()==null) || 
             (this.cdinjetora!=null &&
              this.cdinjetora.equals(other.getCdinjetora()))) &&
            ((this.databit==null && other.getDatabit()==null) || 
             (this.databit!=null &&
              this.databit.equals(other.getDatabit()))) &&
            ((this.downloadext==null && other.getDownloadext()==null) || 
             (this.downloadext!=null &&
              this.downloadext.equals(other.getDownloadext()))) &&
            ((this.downloadpath==null && other.getDownloadpath()==null) || 
             (this.downloadpath!=null &&
              this.downloadpath.equals(other.getDownloadpath()))) &&
            ((this.flowcontrol==null && other.getFlowcontrol()==null) || 
             (this.flowcontrol!=null &&
              this.flowcontrol.equals(other.getFlowcontrol()))) &&
            ((this.ijtbinj==null && other.getIjtbinj()==null) || 
             (this.ijtbinj!=null &&
              this.ijtbinj.equals(other.getIjtbinj()))) &&
            ((this.parity==null && other.getParity()==null) || 
             (this.parity!=null &&
              this.parity.equals(other.getParity()))) &&
            ((this.recignaftlasteob==null && other.getRecignaftlasteob()==null) || 
             (this.recignaftlasteob!=null &&
              this.recignaftlasteob.equals(other.getRecignaftlasteob()))) &&
            ((this.recignbeffrsteob==null && other.getRecignbeffrsteob()==null) || 
             (this.recignbeffrsteob!=null &&
              this.recignbeffrsteob.equals(other.getRecignbeffrsteob()))) &&
            this.rectimeout == other.getRectimeout() &&
            ((this.serialport==null && other.getSerialport()==null) || 
             (this.serialport!=null &&
              this.serialport.equals(other.getSerialport()))) &&
            ((this.sndcnvtucase==null && other.getSndcnvtucase()==null) || 
             (this.sndcnvtucase!=null &&
              this.sndcnvtucase.equals(other.getSndcnvtucase()))) &&
            ((this.snddelaybyte==null && other.getSnddelaybyte()==null) || 
             (this.snddelaybyte!=null &&
              this.snddelaybyte.equals(other.getSnddelaybyte()))) &&
            ((this.sndendblock==null && other.getSndendblock()==null) || 
             (this.sndendblock!=null &&
              this.sndendblock.equals(other.getSndendblock()))) &&
            ((this.sndendprog==null && other.getSndendprog()==null) || 
             (this.sndendprog!=null &&
              this.sndendprog.equals(other.getSndendprog()))) &&
            ((this.sndignemptyblock==null && other.getSndignemptyblock()==null) || 
             (this.sndignemptyblock!=null &&
              this.sndignemptyblock.equals(other.getSndignemptyblock()))) &&
            ((this.sndignore==null && other.getSndignore()==null) || 
             (this.sndignore!=null &&
              this.sndignore.equals(other.getSndignore()))) &&
            ((this.sndrts==null && other.getSndrts()==null) || 
             (this.sndrts!=null &&
              this.sndrts.equals(other.getSndrts()))) &&
            ((this.sndstartprog==null && other.getSndstartprog()==null) || 
             (this.sndstartprog!=null &&
              this.sndstartprog.equals(other.getSndstartprog()))) &&
            ((this.stativo==null && other.getStativo()==null) || 
             (this.stativo!=null &&
              this.stativo.equals(other.getStativo()))) &&
            ((this.stopbit==null && other.getStopbit()==null) || 
             (this.stopbit!=null &&
              this.stopbit.equals(other.getStopbit()))) &&
            ((this.stsincronismo==null && other.getStsincronismo()==null) || 
             (this.stsincronismo!=null &&
              this.stsincronismo.equals(other.getStsincronismo()))) &&
            ((this.uploadext==null && other.getUploadext()==null) || 
             (this.uploadext!=null &&
              this.uploadext.equals(other.getUploadext()))) &&
            ((this.uploadpath==null && other.getUploadpath()==null) || 
             (this.uploadpath!=null &&
              this.uploadpath.equals(other.getUploadpath())));
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
        _hashCode += new Double(getBaudrate()).hashCode();
        if (getCdinjetora() != null) {
            _hashCode += getCdinjetora().hashCode();
        }
        if (getDatabit() != null) {
            _hashCode += getDatabit().hashCode();
        }
        if (getDownloadext() != null) {
            _hashCode += getDownloadext().hashCode();
        }
        if (getDownloadpath() != null) {
            _hashCode += getDownloadpath().hashCode();
        }
        if (getFlowcontrol() != null) {
            _hashCode += getFlowcontrol().hashCode();
        }
        if (getIjtbinj() != null) {
            _hashCode += getIjtbinj().hashCode();
        }
        if (getParity() != null) {
            _hashCode += getParity().hashCode();
        }
        if (getRecignaftlasteob() != null) {
            _hashCode += getRecignaftlasteob().hashCode();
        }
        if (getRecignbeffrsteob() != null) {
            _hashCode += getRecignbeffrsteob().hashCode();
        }
        _hashCode += new Double(getRectimeout()).hashCode();
        if (getSerialport() != null) {
            _hashCode += getSerialport().hashCode();
        }
        if (getSndcnvtucase() != null) {
            _hashCode += getSndcnvtucase().hashCode();
        }
        if (getSnddelaybyte() != null) {
            _hashCode += getSnddelaybyte().hashCode();
        }
        if (getSndendblock() != null) {
            _hashCode += getSndendblock().hashCode();
        }
        if (getSndendprog() != null) {
            _hashCode += getSndendprog().hashCode();
        }
        if (getSndignemptyblock() != null) {
            _hashCode += getSndignemptyblock().hashCode();
        }
        if (getSndignore() != null) {
            _hashCode += getSndignore().hashCode();
        }
        if (getSndrts() != null) {
            _hashCode += getSndrts().hashCode();
        }
        if (getSndstartprog() != null) {
            _hashCode += getSndstartprog().hashCode();
        }
        if (getStativo() != null) {
            _hashCode += getStativo().hashCode();
        }
        if (getStopbit() != null) {
            _hashCode += getStopbit().hashCode();
        }
        if (getStsincronismo() != null) {
            _hashCode += getStsincronismo().hashCode();
        }
        if (getUploadext() != null) {
            _hashCode += getUploadext().hashCode();
        }
        if (getUploadpath() != null) {
            _hashCode += getUploadpath().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ijtbdnc.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbdnc"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baudrate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "baudrate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cdinjetora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cdinjetora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("databit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "databit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("downloadext");
        elemField.setXmlName(new javax.xml.namespace.QName("", "downloadext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("downloadpath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "downloadpath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flowcontrol");
        elemField.setXmlName(new javax.xml.namespace.QName("", "flowcontrol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ijtbinj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ijtbinj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "ijtbinj"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recignaftlasteob");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recignaftlasteob"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recignbeffrsteob");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recignbeffrsteob"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rectimeout");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rectimeout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serialport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serialport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sndcnvtucase");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sndcnvtucase"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("snddelaybyte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "snddelaybyte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sndendblock");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sndendblock"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sndendprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sndendprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sndignemptyblock");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sndignemptyblock"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sndignore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sndignore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sndrts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sndrts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sndstartprog");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sndstartprog"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stativo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stativo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stopbit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stopbit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stsincronismo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stsincronismo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uploadext");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uploadext"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uploadpath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uploadpath"));
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
