package idw.model.rn.impprog.oas;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import idw.model.excessoes.SemComunicacaoException;
import idw.model.pojos.OmPt;
import idw.model.rn.impprog.IImportaProgramaRN;
import idw.webservices.dto.ProgramaInsersoraDTO;
import idw.webservices.dto.ProgramasInsersorasDTO;


public class ImportaProgramaOASRN implements IImportaProgramaRN{

	@Override
	public ProgramaInsersoraDTO getProgramaInsersoraDTO(
			ProgramaInsersoraDTO programaInsersoraDTO) {
		
		return null;
	}

	@Override
	public ProgramasInsersorasDTO getProgramasInsersorasDTO(
			OmPt ompt) {
		
		// Processa string XML
//		String dados = "";
		try {
//			dados = getXML(ompt);
			getXML(ompt);
		} catch (SemComunicacaoException e) {
			e.printStackTrace();
		}
		
//		String xml = "";
		
//		XStream xstream = new XStream(new DomDriver());
		
//		programaDTO = (SetupsOASXMLDTO) xstream.fromXML(xml);
//		
//		programaDTO tera o conteudo mapeado na classe
		
		return null;
	}

	private String getXML(OmPt ompt) throws SemComunicacaoException{
		// Identifica servidor de programas e a porta
		String host = ompt.getUrlConexao();
		String porta = "81";
		
		if (host == null || host.equals(""))
			host = "localhost";
		
		// Tem a porta na url?
		if (host.indexOf(':') > 0){
			porta = host.substring(host.indexOf(':')+1);
			host = host.substring(0, host.indexOf(':'));
		}
		
		// Abre conexao Stream TCP/IP com servidor de programas da insersora
		Socket cliente = null;
		
		
		try {
			cliente = new Socket(host, Integer.parseInt(porta));
		} catch (NumberFormatException e) {
			throw new SemComunicacaoException();
		} catch (UnknownHostException e) {
			throw new SemComunicacaoException();
		} catch (IOException e) {
			throw new SemComunicacaoException();
		}
		
		// Abre canal para receber dados
		DataInputStream canalEntrada = null;
		DataOutputStream canalSaida = null;
		
		try {
			canalEntrada = new DataInputStream(cliente.getInputStream());
		} catch (IOException e) {
			throw new SemComunicacaoException();
		}

		try {
			canalSaida = new DataOutputStream(cliente.getOutputStream());
		} catch (IOException e) {
			throw new SemComunicacaoException();
		}

		// Envia algo para o servidor
		try {
			canalSaida.writeInt(1001);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Recebe uma string com um XML
		String dados = "";
		
		try {
			dados = canalEntrada.readUTF();
		} catch (IOException e) {
			throw new SemComunicacaoException();
		}
		
		// Fecha canal de comunicacao
		try {
			canalSaida.close();
			canalEntrada.close();
			cliente.close();
		} catch (IOException e) {
			throw new SemComunicacaoException();
		}

		return dados;
	}

	@Override
	public void inicializacao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacao() {
		// TODO Auto-generated method stub
		
	}
}
