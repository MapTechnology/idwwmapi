/**
 * ProgramacaoWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pst.scam.server.presentation.web.endpoint;

public interface ProgramacaoWS extends java.rmi.Remote {
    public java.lang.String getProgramacaosByMaquinaWS(java.lang.String usuarioMatricula, java.lang.String usuarioSenha, java.lang.String maquinaNome) throws java.rmi.RemoteException;
    public java.lang.String getProgramacaoCompletoWS(java.lang.String usuarioMatricula, java.lang.String usuarioSenha, java.lang.String programacaoId) throws java.rmi.RemoteException;
}
