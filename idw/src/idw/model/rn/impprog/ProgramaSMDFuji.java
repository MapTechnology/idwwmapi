package idw.model.rn.impprog;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import idw.model.excessoes.SemCategoriaException;
import idw.model.excessoes.SemFeedersException;
import idw.model.rn.DataHoraRN;
import idw.util.UtilsString;

public class ProgramaSMDFuji  extends AProgramaSMD{

	private String arquivo;
	private String conteudo;
	private Document doc;
	private String programa;
	private String data;
	private String hora;

	public ProgramaSMDFuji(String arquivo, String conteudo) throws SemCategoriaException{
		this.arquivo = arquivo;
		this.conteudo = conteudo;
		if (doc == null) {
			// Alessandre; nao vou inicializar doc pois sempre tenho erro de formacao no XML iniciaManipulacao();
		}
	}

	public String getArquivo() {
		return arquivo;
	}
	
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public String getPrograma() {
		return this.programa;
	}

	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public Date obtemDataHoraPrograma() throws SemCategoriaException{
		String dthr = "";

		dthr = data + " " + hora;

		Date retorno = DataHoraRN.stringToDate(dthr, "dd/MM/yyyy HH:mm:ss");

		return retorno;
	}

	// O objetivo desse metodo eh obter a lista de maquinas do xml
	@Override
	public List<MaquinaSMDPanasonic> obtemMaquinas() throws SemCategoriaException{
		List<MaquinaSMDPanasonic> retorno = new ArrayList<MaquinaSMDPanasonic>();
		List<String> valores = new ArrayList<String>();

		// Obtem o nome das maquinas, em geral sera apenas uma
		valores = obtemAtributo("McName");
		for(String valor : valores){
            MaquinaSMDPanasonic maq = new MaquinaSMDPanasonic();
            maq.setNomeMaquina(valor);
        	retorno.add(maq);
		}
		
		// Obtem o nome do programa
		valores = obtemAtributo("prgName");
		for (String valor : valores){
			this.programa = valor;
		}
		// Obtem a revisao do programa para concatenar com o nome do programa, pois nos arquivos de coleta (eventdata.txt) o programa
		// aparece com as duas informacoes concatenadas
		valores = obtemAtributo("JobRevision");
		String revisaoPrograma = "";
		for (String valor : valores){
			revisaoPrograma = valor;
		}
		this.programa += revisaoPrograma;
		
		// obtem a data do programa
		valores = obtemAtributo("RepDate");
		for (String valor : valores){
			this.data = valor;
		}

		// obtem a hora do programa
		valores = obtemAtributo("RepTime");
		for (String valor : valores){
			this.hora = valor;
		}
		
		// obtem o ciclo padrao da maquina que esta no arquivo L1NXTA_TimingReportUnitNXT_T.xml
		valores = obtemAtributo("Total_Cycle_Time");
		double cicloPadrao = 0d;
		for (String valor : valores){
			cicloPadrao = Double.parseDouble(valor);
		}
		for (MaquinaSMDPanasonic m : retorno) {
			m.setCicloPadrao(cicloPadrao);
		}

		return retorno;
	}
	
	/* Obtem a lista de valores de determinada chave
	 * 
	 */
	private List<String> obtemAtributo(String chave){
		List<String> retorno = new ArrayList<String>();

		// Alessandre: Comentei o loop abaixo pois o conteudo sempre tem erro de mal formacao
		// entao vou pesquisar como string mesmo
//		NodeList nodes = doc.getElementsByTagName(chave);
//        for (int i = 0; i < nodes.getLength(); i++) {
//                Element elemento = (Element) nodes.item(i);
//                String valor = elemento.getTextContent();
//                if (valor.equals(chave) == false)
//                	retorno.add(valor);
//        }
		
		int posicaoChave = this.conteudo.indexOf(chave);
		String resto = this.conteudo;
		while (posicaoChave >= 0){
			
			resto = resto.substring(posicaoChave + chave.length() + 1);
			String ateC = "</" + chave + ">";
			
			int ate = resto.indexOf(ateC);
			String valor = resto.substring(0, ate );
			resto = resto.substring(ate + ateC.length());

			if (valor.equals(chave) == false)
				retorno.add(valor);
			
			posicaoChave = resto.indexOf(chave);
		}
		
		return retorno;
	}

	@Override
	public List<MaquinaSMDFeeder> obtemFeeders(MaquinaSMDPanasonic maquinaSMD) throws SemFeedersException{
		
		List<MaquinaSMDFeeder> retorno = new ArrayList<MaquinaSMDFeeder>();

		List<String> feeders = obtemAtributo("fsSetPos");
		List<String> componentes = obtemAtributo("fsPartNum");
		List<String> quantidades = obtemAtributo("fsPartQty");
		List<String> componentesAlternativos = obtemAtributo("pnBarcode");
		List<String> descricoes = UtilsString.removeCaracteresEspeciaisListString (obtemAtributo("pnPartComment"));
		
		for (int i = 0 ; i < feeders.size(); i++) {
			String feeder = feeders.get(i);
			String cdComponente = componentes.get(i);
			Double quantidadeComponente = Double.parseDouble(quantidades.get(i));
			
			String cdComponenteAlternativo = "";
			if (componentesAlternativos != null && i < componentesAlternativos.size())
				cdComponenteAlternativo = componentesAlternativos.get(i);
			
			String descricao = "";
			if (descricoes != null && i < descricoes.size())
				descricao = descricoes.get(i);
			
			// Ajusta a codificacao do feeder para o padrao esperado Z1000
			String mesa = feeder.substring(0, feeder.indexOf('-'));
			String feed = feeder.substring(feeder.indexOf('-') + 1);
			// Remover os - do conteudo de feed. Isso pq na unicoba existem trays no formato <fsSetPos>8-A- 2-1</fsSetPos> o resultado deve ser Z8A21
			feed = feed.replaceAll("-", "");
			feed = feed.replaceAll(" ", "");
			feed = feed.trim();
			
			String feederFormatado = mesa + StringUtils.repeat("0", 4 - feed.length()) + feed;
			
			// Inicializa o dto
			MaquinaSMDFeeder feederFinal = new MaquinaSMDFeeder();
			feederFinal.setCdProduto(cdComponente);
			feederFinal.setIdNum("parece sem uso");
			feederFinal.setCdFeederDePara(feederFormatado);
			feederFinal.setQuantidade(BigDecimal.valueOf(quantidadeComponente));
			feederFinal.setPosicao(null);
			feederFinal.setDescricao(descricao);
			feederFinal.setCdProdutoAlternativo(cdComponenteAlternativo);
	
			retorno.add(feederFinal);
		}
		
		return retorno;
	}


	// Esse metodo eh chamado uma unica vez para inicializar o doc que contem todo o xml recebido
	// esse metodo deixou de ser usado pois estou trantando o conteudo como um string e nao mais um xml
	@Deprecated
	public void iniciaManipulacao() throws SemCategoriaException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// Get the DocumentBuilder
			DocumentBuilder docBuilder = factory.newDocumentBuilder();

			// Using existing XML Document
			doc = docBuilder.parse(new ByteArrayInputStream(this.conteudo.getBytes()));
		} catch (SAXException e) {
			e.printStackTrace();
			throw new SemCategoriaException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new SemCategoriaException();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new SemCategoriaException();
		}
	}
}
