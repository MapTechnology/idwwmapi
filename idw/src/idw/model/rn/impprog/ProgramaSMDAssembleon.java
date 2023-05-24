package idw.model.rn.impprog;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import idw.model.excessoes.SemCategoriaException;
import idw.model.excessoes.SemFeedersException;
import idw.model.rn.DataHoraRN;
import idw.util.ArquivosDiretorios;

public class ProgramaSMDAssembleon extends AProgramaSMD {

	private boolean isFileParsed;
	private String fileName;
	private String programa;
	private String conteudo;
	private byte[] conteudoBinario;
	private Date dthrPrograma;
    private List<MaquinaSMDPanasonic> maquinas;
    private List<MaquinaSMDFeeder> feeders;
	
	public ProgramaSMDAssembleon(String arquivo, byte[] conteudoBinario) throws SemCategoriaException{
		this.isFileParsed = false;
		this.fileName = arquivo;
		this.programa = "";
		this.conteudo = "";
		this.conteudoBinario = conteudoBinario;
		this.dthrPrograma = new Date();
		this.maquinas = new ArrayList<MaquinaSMDPanasonic>();
		this.feeders = new ArrayList<MaquinaSMDFeeder>();
	}

	private void parseArquivoInterno() {
		if(isFileParsed)
			return;
	    //String pathRelativo = Stubedelegate.getInstancia().getPathRelativo();
		String pathRelativo = System.getProperty( "catalina.base" ) + "/wtpwebapps";
	    String dirPath = pathRelativo + "/coleta/importacao/";
	    String filePath = dirPath + fileName;
	    
	    File file = null;
	    PDFParser parser = null;
	    COSDocument cosDoc = null;
	    PDDocument pdDoc = null;
	    PDFTextStripper pdfStripper = null;
	    
	    try {
	    	ArquivosDiretorios.criarDiretorioSeNaoexistir(dirPath);
	    	
			Files.write(Paths.get(filePath), conteudoBinario);
	    
			file = new File(filePath);
	    	//Trecho para extrair o texto do PDF
	    	RandomAccessFile raf = new RandomAccessFile(file, "r");
	    	
	        parser = new PDFParser(raf);
	        parser.parse();
	        
	        cosDoc = parser.getDocument();
	        pdDoc = new PDDocument(cosDoc);
	        
	        pdfStripper = new PDFTextStripper();
	        conteudo = pdfStripper.getText(pdDoc);
	        
			//Quebro o conteudo do PDF em paginas atraves do rodape enumerador de paginas
			List<String> pages = new ArrayList<String>(Arrays.asList(conteudo.split("- [0-9]+ -")));
			//Pego a quantidade de paginas de acordo com o Parser de PDF
	        int numOfPages = pdDoc.getNumberOfPages();
	        
	        //Removo as paginas restantes(provavel lixo)
	        while(pages.size() > numOfPages)
	        	pages.remove(pages.size()-1);
	        
	        //Itero sobre as paginas 1 a 1 para tratar
	        for(int indexOfPage=0; indexOfPage < pages.size() ; indexOfPage++) {
	        	
	        	//Quebro o conteudo por linha
		        List<String> lines = new ArrayList<String>(Arrays.asList(pages.get(indexOfPage).split("\n")));
		        
		        //Primeira linha eh o Date e Time
		        if(dthrPrograma == null) {
			        String dateAndTime = lines.get(0);
			        dthrPrograma = DataHoraRN.toDateFromYYYYMMDDHHMI(dateAndTime);
			        System.out.print("DateAndTime="+dateAndTime);
		        }
		        
		        //Removo as seguintes linhas que sao cabecalhos da tabela
		        for(int i=0; i<4; i++) {
		        	lines.remove(0);
		        }
		        
		        //Linhas restantes sao elementos da tabela e que devem ser tratados
		        for(String line : lines) {
		        	//O parse de PDF nao conseguiu tratar bem um caso em que o FeederType era 12mmEmboss
		        	//Ele concatenava com o proximo campo que era Sequence
		        	//Para resolver isso, adicionamos o espaco manualmente
		        	if(line.contains("EmbossPaper"))
		        		line = line.replaceAll("EmbossPaper", "Emboss Paper");
		        	
		        	//Quebro a linha por espacos, onde cada item eh uma celula
		        	String[] row = line.split("\\s+");
		        	
		        	String number = "";
		        	String assigned = "";
		        	String partsName = "";
		        	String partsComment = "";
		        	String setNumber = "";
		        	String feederType = "";
		        	String sequence = "";
		        	String point = "";
		        	String databaseNumber = "";
		        	String useFeeder = "";
		        	
		        	//Quando o campo assigned nao esta marcado, o mesmo nao tem valor e a row fica com 9 elementos
		        	if(row.length == 9) {
		        		number = row[0];
			        	partsName = row[1];
			        	partsComment = row[2];
			        	setNumber = row[3];
			        	feederType = row[4];
			        	sequence = row[5];
			        	point = row[6];
			        	databaseNumber = row[7];
			        	useFeeder = row[8];
		        	//Quando o campo assigned ESTA marcado, o mesmo nao tem valor e a row fica com 10 elementos
		        	} else if(row.length == 10) {
		        		number = row[0];
		        		assigned = row[1];
			        	partsName = row[2];
			        	partsComment = row[3];
			        	setNumber = row[4];
			        	feederType = row[5];
			        	sequence = row[6];
			        	point = row[7];
			        	databaseNumber = row[8];
			        	useFeeder = row[9];
		        		//MachineName e BoardName estao grudados no fim da pagina
		        		//Utilizar o padrao do MachineName ja conhecido(OP-07-M62557) para pegar o BoardName e MachineName
		        	} else if(line.trim().matches("[A-Z]{2}-[0-9]{2}-M[0-9]{5}[A-Z0-9_-]*")) {
		        		String boardName = line.replaceAll("[A-Z]{2}-[0-9]{2}-M[0-9]{5}", "").trim();
		        		String machineName = line.replaceAll(boardName, "").trim();
		        		
		        		if(maquinas.size() == 0) {
			        		MaquinaSMDPanasonic maquina = new MaquinaSMDPanasonic();
			        		maquina.setNomeMaquina(machineName);
			        		
			        		maquinas.add(maquina);
		        		}
		        		programa = boardName;
		        		
		        	} else {
		        	}
		        	
		        	//Rows validas a serem tratadas
		        	if(row.length == 9 || row.length == 10) {
		        		//System.out.println("number="+number + " assigned="+assigned + " partsName="+partsName + " partsComment="+partsComment + " setNumber="+setNumber + " feederType="+feederType + " sequence="+sequence + 
		        		//	" point="+point + " databaseNumber="+databaseNumber + " useFeeder="+useFeeder);
		        		MaquinaSMDFeeder feeder = new MaquinaSMDFeeder();
		        		feeder.setCdProduto(partsName);
		        		feeder.setIdNum("parece sem uso");
		        		feeder.setCdFeederDePara(setNumber);
		        		feeder.setQuantidade(new BigDecimal(point));
		        		feeder.setPosicao(new BigDecimal(number));
		        		feeders.add(feeder);
		        	}
		        }
	        }

	        //String allTextInFile = parsedText.replaceAll("[^A-Za-z0-9. _\t\n]+", "");
	    } catch (Exception e) {
	        e.printStackTrace();
	        try {
	            if (cosDoc != null)
	                cosDoc.close();
	        } catch (Exception e1) {
	            e.printStackTrace();
	        }
	        try {
	            if (pdDoc != null)
	                pdDoc.close();
	        } catch (Exception e1) {
	            e.printStackTrace();
	        }
	        ArquivosDiretorios.delete(filePath);
	    } finally {
	    	isFileParsed = true;
	    }
	}
	
	@Override
	public List<MaquinaSMDPanasonic> obtemMaquinas()
			throws SemCategoriaException {
		parseArquivoInterno();
		// TODO Auto-generated method stub
		return maquinas;
	}

	@Override
	public String getPrograma() {
		parseArquivoInterno();
		return programa;
	}

	@Override
	public Date obtemDataHoraPrograma() throws SemCategoriaException {
		parseArquivoInterno();
		// TODO Auto-generated method stub
		return dthrPrograma;
	}

	@Override
	public List<MaquinaSMDFeeder> obtemFeeders(MaquinaSMDPanasonic maquinaSMD)
			throws SemFeedersException {
		parseArquivoInterno();
		// TODO Auto-generated method stub
		return feeders;
	}

}
