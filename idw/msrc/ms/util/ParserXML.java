package ms.util;

import ms.excessao.FuncionalidadeIndisponivelException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParserXML {
	
	private String arquivo;
	private Document doc;

	public ParserXML(String arquivo) {
		this.arquivo = arquivo;
	}

	public void iniciaManipulacao() throws FuncionalidadeIndisponivelException {
		try {
			File file = new File(this.arquivo);

			// Create instance of DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// Get the DocumentBuilder
			DocumentBuilder docBuilder = factory.newDocumentBuilder();

			// Using existing XML Document
			doc = docBuilder.parse(file);
		} catch (SAXException e) {
			throw new FuncionalidadeIndisponivelException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new FuncionalidadeIndisponivelException(e);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new FuncionalidadeIndisponivelException(e);
		}
	}

	public void finalizaManipulacao(Integer tipoBanco) throws FuncionalidadeIndisponivelException {
		try {
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			
			TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();
			trans.setOutputProperty(OutputKeys.INDENT,"yes");
			trans.setOutputProperty(OutputKeys.METHOD,"xml");
			trans.transform(source, result);
			
			String xmlString = sw.toString();
			BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo)));
			bw2.write(xmlString);
			bw2.flush();
			bw2.close();

			String linha = null;
			FileReader reader = new FileReader(arquivo);
			BufferedReader leitor = new BufferedReader(reader);
			Vector<String> linhas = new Vector<String>();

			linha = leitor.readLine();
			linhas.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			linhas.add("<!DOCTYPE hibernate-configuration PUBLIC \"-//Hibernate/Hibernate Configuration DTD 3.0//EN\" \"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd\">\n");

			while((linha = leitor.readLine()) != null) {
				if(linha.contains("<property name=\"hibernate.connection.isolation\">1</property>") ) {
					if(tipoBanco == 1) {
						linha = "        <property name=\"hibernate.connection.isolation\">1</property>";
					}
					else {
						linha = "<!--    <property name=\"hibernate.connection.isolation\">1</property> -->";
					}
					linhas.add(linha+"\n");
					break;
				}
				else {
					linhas.add(linha+"\n");
				}
			}
			while((linha = leitor.readLine()) != null) {
				linhas.add(linha+"\n");
			}
			leitor.close();
			reader.close();
			FileWriter writer = new FileWriter(arquivo);
			BufferedWriter escritor = new BufferedWriter(writer);
			for(String line : linhas) {
				escritor.write(line);
			}
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new FuncionalidadeIndisponivelException(e);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			throw new FuncionalidadeIndisponivelException(e);
		} catch (TransformerException e) {
			e.printStackTrace();
			throw new FuncionalidadeIndisponivelException(e);
		}
	}
	
	public void setAtributo(String elemento, String nomeAtributo, String valorAtributo) throws FuncionalidadeIndisponivelException{
		try {
		NodeList l = doc.getElementsByTagName(elemento);
		for (int i = 0; i < l.getLength(); i++) {
	//		Node n = l.item(i);
//			if (n.getAttributes().item(0).getTextContent().equals(nomeAtributo)) {
//				n.setTextContent(valorAtributo);
//			}
		}
		} catch (NullPointerException e){
			e.printStackTrace();
			throw new FuncionalidadeIndisponivelException(e);
		}
	}
	
	public String getAtributo(String elemento, String nomeAtributo) throws FuncionalidadeIndisponivelException{
		try {
		NodeList l = doc.getElementsByTagName(elemento);
		for (int i = 0; i < l.getLength(); i++) {
	//		Node n = l.item(i);
//			if (n.getAttributes().item(0).getTextContent().equals(nomeAtributo)) {
//				return n.getTextContent();
//			}
		}
		} catch (NullPointerException e){
			e.printStackTrace();
			throw new FuncionalidadeIndisponivelException(e);
		}
		return "";
	}
	
}
