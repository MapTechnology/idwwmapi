/**
 * IPCINJSOAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.model.rn.integracao.ipackchem.client;

public interface IPCINJSOAP extends java.rmi.Remote {

    /**
     * Metodo para liberaçãoo de certificado
     */
    public idw.model.rn.integracao.ipackchem.client.XRET03 XLIBCERTIFICADO(idw.model.rn.integracao.ipackchem.client.XPAR03 XLST_PAR03) throws java.rmi.RemoteException;

    /**
     * Metodo para atualizaçãoo da data prevista de tÃ©rmino da OP
     */
    public idw.model.rn.integracao.ipackchem.client.XRET01 XOPDTPREV(idw.model.rn.integracao.ipackchem.client.XPAR01 XLST_PAR01) throws java.rmi.RemoteException;

    /**
     * Metodo para apontamento de produçãoo
     */
    public idw.model.rn.integracao.ipackchem.client.XRET02 XPRODUCAO(idw.model.rn.integracao.ipackchem.client.XPAR02 XLST_PAR02) throws java.rmi.RemoteException;
}
