package ms.coleta.ic.inova;

import injetws.model.IwsFacade;
import injetws.webservices.dto.IwsUpDncDTO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Calendar;

import ms.coleta.ic.inova.dto.INovaUpDncDTO;
import idw.util.IdwLogger;

public class UpDnc {
	private static UpDnc instancia = null;
	
	public INovaUpDncDTO goUpDncDTO;
	public String numPcts;
	public String lastPctSize;
	public int codErro;
	public String lastEventDnc;
	public boolean isEXT;
	public boolean isCNT;
	public boolean feito;
	
	public static long TAM_PCT_DADO_DNC = 200;
	public int SLEEP_SEND = 350;

	public byte[] bArquivo;
	public byte[] bAquivoTmp;
	public String StrArquivo;
	public String StrTmpArquivo;
	public String CaminhoUtilizado;

	public static int FORMATACAO_INVALIDA = 1;
	public static int FORMATO_EXT_INVALIDO = 2;
	public static int ARQUIVO_NAO_EXISTE = 3;
	public static int ARQUIVO_DUPLICADO = 4;
	public static int EXTENSAO_INVALIDA = 5;
	public static int MAISVERSAO_INVALIDA = 6;
	public static int NAO_EXISTE_CNT = 7;
	public static int EXISTE_BLQ = 8;
	public static int FALHA_COMUNICACAO_WS = 9;
	public static int DADOS_AUSENTES = 10;
	public static int DADOS_WS_INVALIDOS = 11;
	public static int ERRO_WEBSERVER = 12;
	public static int ERRO_CARREGAR_ARQUIVO = 13;
	public static int PACOTE_TAMANHO_INVALIDO = 14;
	public static int ERRO_GRAVAR_ARQUIVO = 15;
	public static int ERRO_PERDEU_CONEXAO_ENVIANDO_ARQUIVO = 16;
	public static int ERRO_CONTAGEM_FIM_BLOCO = 17;
	public static int ERRO_SUBSTITUICAO_FIM_BLOCO = 18;

	public static int TAMANHO_COD_ARQUIVO = 7;

	public static byte CHAR_CR = 0x0D;
	public static byte CHAR_LF = 0x0A;
	
	IdwLogger log = null;
	int idLog;
	
	public UpDnc(IdwLogger log, int idLog) {
		this.log = log;
		this.idLog = idLog;
	}

	public static UpDnc getInstancia(IdwLogger log, int idLog) {
		if(instancia == null) {
			instancia = new UpDnc(log, idLog);
		}
		return instancia;
	}

	public static UpDnc getNewInstancia(IdwLogger log, int idLog) {
		instancia = new UpDnc(log, idLog);
		
		return instancia;
	}

	public Boolean pedidoEnviarArquivo(String idup, String codarq) {
		Boolean bRet = false;
		
		goUpDncDTO = this.pegar_dados_updnc(idup);
		goUpDncDTO.setcodArquivo(codarq);
		
		if(goUpDncDTO.getcodErro() == 0) {
			
			if(this.verificar_dados_ws(goUpDncDTO)) {
				
				if(this.verificar_enviar_arquivo(goUpDncDTO)) {
					
					if(isEXT) {
						bArquivo = this.carrega_arquivo(goUpDncDTO, goUpDncDTO.getDownloadExt());
					}
					else {
						bArquivo = this.carrega_arquivo(goUpDncDTO, "CNT");
					}
					
					if(bArquivo != null) {
						bRet = true;
					}
					else { //erro ao carregar arquivo
						this.codErro = ERRO_CARREGAR_ARQUIVO;
					}
				}
				else { //retornar codigo de erro
					
				}
			}
			else {
				//System.Console.WriteLine("Erro: " + oProgram.oErro.get_erro());
				//System.Windows.Forms.MessageBox.Show("Erro: " + this.codErro);
			}
		}
		else { // erro no contato com WS ou dado chegou com erro
			//System.Console.WriteLine("Erro: " + oProgram.oErro.get_erro());
			//sSystem.Windows.Forms.MessageBox.Show("Erro: " + this.codErro);
		}
		
		return(bRet);
	}

	public Boolean pedidoReceberArquivo(String cdMaquina, String codarq) {
		Boolean bRet = false;
		
		goUpDncDTO = this.pegar_dados_updnc(cdMaquina);
		goUpDncDTO.setcodArquivo(codarq);
		
		if(goUpDncDTO.getcodErro() == 0) {
			
			if(this.verificar_dados_ws(goUpDncDTO)) {
				
				if(this.verificar_receber_arquivo(goUpDncDTO)) {
					//System.Console.WriteLine("Pode receber!!");
					
					bRet = true;
				}
				else {
					//System.Windows.Forms.MessageBox.Show("Erro: " + this.codErro);
				}
			}
			else {
				//System.Windows.Forms.MessageBox.Show("Erro: " + this.codErro);
			}
		}
		else {
			//System.Windows.Forms.MessageBox.Show("Erro: " + this.codErro);
		}
		
		return (bRet);
	}

	public Boolean verificar_enviar_arquivo(INovaUpDncDTO oUpDncDTO) {
		String sArquivo = oUpDncDTO.getcodArquivo() + "." + oUpDncDTO.getDownloadExt();
		
		//System.out.println("Enviar arquivo!!");
		//System.out.println(oUpDncDTO.getDownloadPath());
		//System.out.println(sArquivo);
		
		if(!this.verificar_formatacao(oUpDncDTO.getcodArquivo())) {
			this.codErro = FORMATACAO_INVALIDA;
			return (false);
		}
		
		if(!this.verificar_formato_extensao(oUpDncDTO.getDownloadExt())) {
			this.codErro = FORMATO_EXT_INVALIDO;
			return (false);
		}
		
		if(!this.verificar_arquivo_existe(oUpDncDTO)) {
			this.codErro = ARQUIVO_NAO_EXISTE;
			return (false);
		}
		
		if(!this.verificar_arquivo_duplicado(oUpDncDTO)) { //verificar arquivos duplicados caso venham duas pastas de origem
			this.codErro = ARQUIVO_DUPLICADO;
			return (false);
		}
		
		if(!this.verificar_extensao(oUpDncDTO)) {
			this.codErro = EXTENSAO_INVALIDA;
			return (false);
		}
		
		if(!this.verificar_maisversao(oUpDncDTO)) {
			this.codErro = MAISVERSAO_INVALIDA;
			return (false);
		}
		
		return(true);
	}

	public Boolean verificar_receber_arquivo(INovaUpDncDTO oUpDncDTO) {
		String sArquivo = oUpDncDTO.getcodArquivo() + "." + oUpDncDTO.getUploadExt();
		
		//System.out.println("Receber arquivo!!");
		//System.out.println(oUpDncDTO.getUploadPath());
		//System.out.println(sArquivo);
		
		if(!this.verificar_formatacao(oUpDncDTO.getcodArquivo())) {
			this.codErro = FORMATACAO_INVALIDA;
			return (false);
		}
		
		if(!this.verificar_formato_extensao(oUpDncDTO.getUploadExt())) {
			this.codErro = FORMATO_EXT_INVALIDO;
			return(false);
		}
		
		if(!this.verificar_existe_cnt(oUpDncDTO)) {
			this.codErro = NAO_EXISTE_CNT;
			return (false);
		}
		
		if(!this.verificar_nao_existe_blq(oUpDncDTO)) {
			this.codErro = EXISTE_BLQ;
			return (false);
		}
		
		return(true);
	}
	
	public Boolean verificar_formatacao(String arquivo) {
		//verificando tamanho do nome do arquivo
		if(arquivo.length() != TAMANHO_COD_ARQUIVO)
			return (false);
		
		//testando cada posicao do nome do arquivo
		if(!Character.isUpperCase(arquivo.charAt(0))) return(false);
		if(!Character.isDigit(arquivo.charAt(1))) return(false);
		if(!Character.isDigit(arquivo.charAt(2))) return(false);
		if(!Character.isDigit(arquivo.charAt(3))) return(false);
		if(!Character.isDigit(arquivo.charAt(4))) return(false);
		if(!Character.isDigit(arquivo.charAt(5))) return(false);
		if(!Character.isUpperCase(arquivo.charAt(6))) return(false);
		
		return(true);
	}

	public Boolean verificar_formato_extensao(String ext) {
		//verificando a extensao do arquivo
		if(!ext.equals("MIN") && !ext.equals("CNC") && !ext.equals("CNT") && !ext.equals("BLQ") && !ext.equals("CFE") && !ext.equals("PMQ"))
			return(false);
		
		return(true);
	}

	public Boolean verificar_arquivo_existe(INovaUpDncDTO oUpDncDTO) {
		boolean verifica = true;
		Boolean existe1, existe2, existe3;
		
		//separando os caminhos de origem se houver mais de um
		String[] array_caminho_orig = oUpDncDTO.getDownloadPath().split(";");
		
		
		String sArquivo = oUpDncDTO.getcodArquivo() + "." + oUpDncDTO.getDownloadExt();
		
		if(array_caminho_orig.length == 1) {
			File arqCaminho = new File(array_caminho_orig[0] + "\\" + sArquivo);
			if(!arqCaminho.exists()) {
				verifica = false;
			}
			else {
				CaminhoUtilizado = array_caminho_orig[0];
			}
		}
		else if(array_caminho_orig.length == 2) {
			File arqCaminho1 = new File(array_caminho_orig[0] + "\\" + sArquivo);
			File arqCaminho2 = new File(array_caminho_orig[1] + "\\" + sArquivo);
			
			existe1 = arqCaminho1.exists();
			existe2 = arqCaminho2.exists();
			
			if(existe1)CaminhoUtilizado = array_caminho_orig[0];
			if(existe2)CaminhoUtilizado = array_caminho_orig[1];
			
			if(!existe1 && !existe2) {
				verifica = false;
			}
		}
		else if(array_caminho_orig.length > 2) {
			File arqCaminho1 = new File(array_caminho_orig[0] + "\\" + sArquivo);
			File arqCaminho2 = new File(array_caminho_orig[1] + "\\" + sArquivo);
			File arqCaminho3 = new File(array_caminho_orig[2] + "\\" + sArquivo);
			
			existe1 = arqCaminho1.exists();
			existe2 = arqCaminho2.exists();
			existe3 = arqCaminho3.exists();
			
			if(existe1) CaminhoUtilizado = array_caminho_orig[0];
			if(existe2) CaminhoUtilizado = array_caminho_orig[1];
			if(existe3) CaminhoUtilizado = array_caminho_orig[2];
			
			if(!existe1 && !existe2 && !existe3) {
				verifica = false;
			}
		}
		
		isEXT = verifica; // TODO: adicionar tratative requintada 
		isCNT = !isEXT;
		
		if(!verifica) {
			verifica = true;
			sArquivo = oUpDncDTO.getcodArquivo() + ".CNT";
			
			if(array_caminho_orig.length == 1) {
				File arqCaminho = new File(array_caminho_orig[0] + "\\" + sArquivo);
				
				if(!arqCaminho.exists()) {
					verifica = false;
				}
				else {
					CaminhoUtilizado = array_caminho_orig[0];
				}
			}
			else if(array_caminho_orig.length == 2) {
				File arqCaminho1 = new File(array_caminho_orig[0] + "\\" + sArquivo);
				File arqCaminho2 = new File(array_caminho_orig[1] + "\\" + sArquivo);
				
				existe1 = arqCaminho1.exists();
				existe2 = arqCaminho2.exists();
				
				if(existe1) CaminhoUtilizado = array_caminho_orig[0];
				if(existe2) CaminhoUtilizado = array_caminho_orig[1];
				
				if(!existe1 && !existe2) {
					verifica = false;
				}
			}
			else if(array_caminho_orig.length > 2) {
				File arqCaminho1 = new File(array_caminho_orig[0] + "\\" + sArquivo);
				File arqCaminho2 = new File(array_caminho_orig[1] + "\\" + sArquivo);
				File arqCaminho3 = new File(array_caminho_orig[2] + "\\" + sArquivo);
				
				existe1 = arqCaminho1.exists();
				existe2 = arqCaminho2.exists();
				existe3 = arqCaminho3.exists();
				
				if(existe1) CaminhoUtilizado = array_caminho_orig[0];
				if(existe2) CaminhoUtilizado = array_caminho_orig[1];
				if(existe3) CaminhoUtilizado = array_caminho_orig[2];
				
				if(!existe1 && !existe2 && !existe3) {
					verifica = false;
				}
			}
			isCNT = verifica;
		}
		
		return (verifica);
	}
	
	public Boolean verificar_arquivo_duplicado(INovaUpDncDTO oUpDncDTO) {
		//separando os caminhos de origem se houver mais de um
		String[] array_caminho_orig = oUpDncDTO.getDownloadPath().split(";");
		
		String sArquivo = oUpDncDTO.getcodArquivo() + "." + oUpDncDTO.getDownloadExt();
		
		if(array_caminho_orig.length == 1) {
			//	if(File.Exists(array_caminho_orig[0] + "\\" + oEvento.arquivo))
			//	{
			//		return (false);
			//	}
		}
		else if(array_caminho_orig.length == 2) {
			File oFile1 = new File(array_caminho_orig[0] + "\\" + sArquivo);
			File oFile2 = new File(array_caminho_orig[1] + "\\" + sArquivo);
			
			if(oFile1.exists() &&
					oFile2.exists())
			{
				return (false);
			}
		}
		else if(array_caminho_orig.length == 3) {
			Boolean existe1, existe2, existe3;
			
			File oFile1 = new File(array_caminho_orig[0] + "\\" + sArquivo);
			File oFile2 = new File(array_caminho_orig[1] + "\\" + sArquivo);
			File oFile3 = new File(array_caminho_orig[2] + "\\" + sArquivo);
			
			existe1 = oFile1.exists();
			existe2 = oFile2.exists();
			existe3 = oFile3.exists();
			
			if((existe1 && existe2) ||
				(existe2 && existe3) ||
				(existe3 && existe1) ){
				return (false);
			}
		}
		else {
			return false;
		}
		
		return (true);
	}

	public Boolean verificar_extensao(INovaUpDncDTO oUpDncDTO) {
		//separando os caminhos de origem se houver mais de um
		String[] array_caminho_orig = oUpDncDTO.getDownloadPath().split(";");
		//System.Console.WriteLine();
		File oDir;
		File[] oArrayFile;
		String sArquivo = "";
		
		if(isEXT) {
			sArquivo = oUpDncDTO.getcodArquivo() + "." + oUpDncDTO.getDownloadExt();
		}
		else if(isCNT) {
			sArquivo = oUpDncDTO.getcodArquivo() + ".CNT";
		}

		//procurar arquivos iguais com extensoes diferentes
		FilenameFilter oFiltroCNT = Util.getFiltroArquivoExtensao(sArquivo, "CNT");
		FilenameFilter oFiltroCNC = Util.getFiltroArquivoExtensao(sArquivo, "CNC");
		FilenameFilter oFiltroBLQ = Util.getFiltroArquivoExtensao(sArquivo, "BLQ");
		//	System.Console.WriteLine("filtro: " + sFiltro);
		int iSomaArquivos = 0;

		int iCont;
		for (iCont = 0; iCont < array_caminho_orig.length; iCont++)
		{
			if(iCont >= 3) break;
			if(array_caminho_orig[iCont].length() > 0)
			{
				oDir = new File(array_caminho_orig[iCont]);
				oArrayFile = oDir.listFiles(oFiltroCNT);
				iSomaArquivos += oArrayFile.length;
				oArrayFile = oDir.listFiles(oFiltroCNC);
				iSomaArquivos += oArrayFile.length;
				oArrayFile = oDir.listFiles(oFiltroBLQ);
				iSomaArquivos += oArrayFile.length;
			}
		}
		if(iSomaArquivos > 1)
			return (false);
		
		return (true);
	}
	
	public Boolean verificar_maisversao(INovaUpDncDTO oUpDncDTO) {
		//separando os caminhos de origem se houver mais de um
		String[] array_caminho_orig = oUpDncDTO.getDownloadPath().split(";");
		
		File oDir;
		File[] oArrayFile;
		String sArquivo = "";
		
		if(isEXT) {
			sArquivo = oUpDncDTO.getcodArquivo() + "." + oUpDncDTO.getDownloadExt();
		}
		else if(isCNT) {
			sArquivo = oUpDncDTO.getcodArquivo() + ".CNT";
		}
		
		//procurar arquivos iguais com versoes diferentes			
		FilenameFilter oFiltroCNT = Util.getFiltroArquivoVersao(sArquivo, ".CNT");
		FilenameFilter oFiltroCNC = Util.getFiltroArquivoVersao(sArquivo, ".CNC");
		FilenameFilter oFiltroBLQ = Util.getFiltroArquivoVersao(sArquivo, ".BLQ");
		int iSomaArquivos = 0;
		
		int iCont;
		for (iCont = 0; iCont < array_caminho_orig.length; iCont++) {
			if(iCont >= 3) break;
			
			if(array_caminho_orig[iCont].length() > 0) {
				oDir = new File(array_caminho_orig[iCont]);
				oArrayFile = oDir.listFiles(oFiltroCNT);
				iSomaArquivos += oArrayFile.length;
				oArrayFile = oDir.listFiles(oFiltroCNC);
				iSomaArquivos += oArrayFile.length;
				oArrayFile = oDir.listFiles(oFiltroBLQ);
				iSomaArquivos += oArrayFile.length;
			}
		}
		
		if(iSomaArquivos > 1)
			return(false);
		
		return(true);
	}
	
	public Boolean verificar_existe_cnt(INovaUpDncDTO oUpDncDTO) {
		String sArquivo = oUpDncDTO.getcodArquivo() + "." + oUpDncDTO.getUploadExt();
		String arquivo_verificar = sArquivo.substring(0, 7) + ".CNT";
		String[] array_caminho_orig = oUpDncDTO.getUploadPath().split(";");
		Boolean existe1, existe2, existe3;
		
		if(array_caminho_orig.length == 1) {
			File arqCaminho = new File(array_caminho_orig[0] + "\\" + arquivo_verificar);
			
			if(arqCaminho.exists()) {
				CaminhoUtilizado = array_caminho_orig[0];
				return true;
			}
		}
		else if(array_caminho_orig.length == 2) {
			File arqCaminho1 = new File(array_caminho_orig[0] + "\\" + arquivo_verificar);
			File arqCaminho2 = new File(array_caminho_orig[1] + "\\" + arquivo_verificar);
			
			existe1 = arqCaminho1.exists();
			existe2 = arqCaminho2.exists();
			
			if(existe1) CaminhoUtilizado = array_caminho_orig[0];
			if(existe2) CaminhoUtilizado = array_caminho_orig[1];
			
			if(existe1 || existe2) {
				return true;
			}
		}
		else if(array_caminho_orig.length > 2) {
			File arqCaminho1 = new File(array_caminho_orig[0] + "\\" + arquivo_verificar);
			File arqCaminho2 = new File(array_caminho_orig[1] + "\\" + arquivo_verificar);
			File arqCaminho3 = new File(array_caminho_orig[2] + "\\" + arquivo_verificar);
			
			existe1 = arqCaminho1.exists();
			existe2 = arqCaminho2.exists();
			existe3 = arqCaminho3.exists();
			
			if(existe1) CaminhoUtilizado = array_caminho_orig[0];
			if(existe2) CaminhoUtilizado = array_caminho_orig[1];
			if(existe3) CaminhoUtilizado = array_caminho_orig[2];
			
			if(existe1 || existe2 || existe3) {
				return true;
			}
		}
		return false;
	}

	public Boolean verificar_nao_existe_blq(INovaUpDncDTO oUpDncDTO) {
		String sArquivo = oUpDncDTO.getcodArquivo() + "." + oUpDncDTO.getUploadExt();
		
		String arquivo_verificar = sArquivo.substring(0, 7) + ".BLQ";
		
		String[] array_caminho_orig = oUpDncDTO.getUploadPath().split(";");
		
		if(array_caminho_orig.length == 1) {
			File arqCaminho = new File(array_caminho_orig[0] + "\\" + arquivo_verificar);
			
			if(arqCaminho.exists()) {
				return false;
			}
		}
		else if(array_caminho_orig.length == 2) {
			File arqCaminho1 = new File(array_caminho_orig[0] + "\\" + arquivo_verificar);
			File arqCaminho2 = new File(array_caminho_orig[1] + "\\" + arquivo_verificar);
			
			if(arqCaminho1.exists() ||
					arqCaminho2.exists())
			{
				return false;
			}
		}
		else if(array_caminho_orig.length > 2) {
			Boolean existe1, existe2, existe3;
			
			File arqCaminho1 = new File(array_caminho_orig[0] + "\\" + arquivo_verificar);
			File arqCaminho2 = new File(array_caminho_orig[1] + "\\" + arquivo_verificar);
			File arqCaminho3 = new File(array_caminho_orig[2] + "\\" + arquivo_verificar);
			
			existe1 = arqCaminho1.exists();
			existe2 = arqCaminho2.exists();
			existe3 = arqCaminho3.exists();
			
			if(existe1 || existe2 || existe3) {
				return false;
			}
		}
		
		return (true);
	}
	
	public INovaUpDncDTO pegar_dados_updnc(String cdMaquina) {
		IwsUpDncDTO oUpDncDTOWs;
		INovaUpDncDTO oUpDncDTO = new INovaUpDncDTO();
		
		try {
//			oUpDncDTOWs = Stubdelegate.getInstancia().getMsWs().getTr_DncTransferencia(cdMaquina);
			oUpDncDTOWs = IwsFacade.getInstancia().getTr_DncTransferencia(cdMaquina);
		} catch(Exception e) {
			oUpDncDTOWs = null;
			oUpDncDTO = null;
		}
		
		if(oUpDncDTOWs != null) { // chegou dados
			oUpDncDTO.copyUpDncDTOWs(oUpDncDTOWs);
			
			if(oUpDncDTO.getcodErro() == 0) { // chegou dados com sucesso
			}
			else { // chegou dados com erro
				this.codErro = oUpDncDTO.getcodErro();
			}
		}
		else { // erro na comunicacao com o webservice
			this.codErro = FALHA_COMUNICACAO_WS;
		}
		
		return (oUpDncDTO);
	}

	public Boolean verificar_dados_ws(INovaUpDncDTO oUpDncDTO) {
		//	oErro.set_erro(Erro.DADOS_WS_INVALIDOS);
		//	return(false);
		
		return(true);
	}
	
	public byte[] carrega_arquivo(INovaUpDncDTO oUpDncDTO,String extensao) {
		String pathToFile = CaminhoUtilizado + "\\" + oUpDncDTO.getcodArquivo() + "." + extensao;
		byte[] cArquivo;
		
		try {
			File oFile = new File(pathToFile);
			BufferedInputStream FileIn = new BufferedInputStream(new FileInputStream(oFile));
			long tam_arquivo = oFile.length();
			//fs.Close();
			cArquivo = new byte[(int) tam_arquivo];
			
			if(FileIn.available() > 0) {
				FileIn.read(cArquivo, 0, (int) tam_arquivo);
			}
			
			long last_pct_size = tam_arquivo % TAM_PCT_DADO_DNC;
			long num_pcts = (tam_arquivo - last_pct_size) / TAM_PCT_DADO_DNC;
			if(last_pct_size > 0)
			{
				num_pcts++;
			}
			else {
				last_pct_size = TAM_PCT_DADO_DNC;
			}
			this.lastPctSize = String.valueOf(last_pct_size);
			this.numPcts = String.valueOf(num_pcts);
		} catch(Exception e) {
			cArquivo = null;
		}
		
		return(cArquivo);
	}

	/*
	 * funcao para pegar um pedaco do array de bytes quando for separar para enviar em pedacos
	 */
	public byte[] getPedacoDadoDnc(int cont) {
		byte[] bDado = new byte[(int) TAM_PCT_DADO_DNC];
		long start;
		long tamPctAtual = 0;
		int cont2;
		
		//pegando o tamanho do pacote a ser enviado
		if(cont < Integer.parseInt(this.numPcts)) {
			tamPctAtual = TAM_PCT_DADO_DNC;
			 bDado= new byte[(int) TAM_PCT_DADO_DNC];
		}
		else if(cont == Integer.parseInt(this.numPcts)) {
			tamPctAtual = Long.parseLong(this.lastPctSize);
			bDado = new byte[new Long(Long.parseLong(this.lastPctSize)).intValue()];
		}
		//pegando ponto inicial para copiar os dados do pacote
		start = (cont - 1) * UpDnc.TAM_PCT_DADO_DNC;
		
		//passando dados para um pacote
		for (cont2 = 0; cont2 < tamPctAtual; cont2++) {
			bDado[cont2] = this.bArquivo[cont2 + (int)start];
		}
		
		return(bDado);
	}

	/*
	 * funcao utilizada apos um arquivo ter sido enviado com sucesso ao coletor
	 */
	public void post_enviar_arquivo(Calendar DtHrEvento) {
		if(goUpDncDTO.getDownloadExt() != "CNT") {
			String Arquivo_orig = CaminhoUtilizado + "\\" + goUpDncDTO.getcodArquivo() + "." + goUpDncDTO.getDownloadExt();
			String Arquivo_dest = CaminhoUtilizado + "\\" + goUpDncDTO.getcodArquivo() + ".CNT";
			
			File fdOrig = new File(Arquivo_orig); 
			File fdDest = new File(Arquivo_dest);
			
			fdOrig.renameTo(fdDest);
		}
		
		this.escreverLog(DtHrEvento, goUpDncDTO.getidUp(), goUpDncDTO.getcodArquivo(), goUpDncDTO.getDownloadPath(), "DO");
	}

	/*
	 * funcao utilizada apos um arquivo ter sido recebido com sucesso do coletor
	 */
	public Boolean post_receber_arquivo(Calendar DtHrEvento) {
		String Arquivo_dest = CaminhoUtilizado + "\\" + goUpDncDTO.getcodArquivo() + ".BLQ";
		long tam_arquivo = this.bArquivo.length;
		byte[] arquivoCorrigido = null;
		byte[] vetorCmp;
		//escreve o arquivo recebido
		//INSERIR VERIFICAÇÃO DE FIM DE BLOCO AQUI!
		
		try {
			switch (this.goUpDncDTO.getTpfimdebloco()) {
				case 1:
					vetorCmp = new byte[1]; //CR
					vetorCmp[0] = CHAR_CR;
					break;
				case 2:
					vetorCmp = new byte[1]; //LF
					vetorCmp[0] = CHAR_LF;
					break;
				case 3:
					vetorCmp = new byte[2]; //CR LF
					vetorCmp[0] = CHAR_CR;
					vetorCmp[1] = CHAR_LF;
					break;
				case 4:
					vetorCmp = new byte[2]; //LF CR
					vetorCmp[0] = CHAR_LF;
					vetorCmp[1] = CHAR_CR;
					break;
				case 5:
					vetorCmp = new byte[3]; //LF CR CR
					vetorCmp[0] = CHAR_LF;
					vetorCmp[1] = CHAR_CR;
					vetorCmp[2] = CHAR_CR;
					break;
				default:
					vetorCmp = new byte[1]; //LF
					vetorCmp[0] = CHAR_LF;
					break;
			}
			
			int[] posicoes = new int[(int) tam_arquivo];
			int bytes = 0, count = 0, i, j = 0;
			/**
			 * bytes: número de bytes do arquivo corrigido.
			 * count: contador utilizado para evitar substituição errada de caracteres
			 * i: índice da última posição do arquivo recebido
			 * j: número de posições identificadas, no total, no arquivo recebido
			 * */
			
			boolean lastCharSpecial = false, startsSpecial = false;
			
			for (i = 0; i < tam_arquivo; i++) {
				if(bArquivo[i] == CHAR_CR || bArquivo[i] == CHAR_LF) {
					
					if(vetorCmp.length > 1) {
						
						if(vetorCmp.length > 2) {
							
							if(bArquivo[i] == vetorCmp[0] && bArquivo[i + 1] == vetorCmp[1] && bArquivo[i + 2] == vetorCmp[2]) {
								
								if(i == 0 && startsSpecial == false) {
									startsSpecial = true;
								}
								
								if(count >= 1 && !lastCharSpecial) {
									bytes--;
									posicoes[j] = (i - (count + 1));
								}
								else
									posicoes[j] = (i - 1);	  //índice antes dos chars de fim de linha
								
								j++;
								i += 2; //adiciona dois considerando a leitura de três caracteres do vetor
								bytes += 2;
								lastCharSpecial = true;
								count = 0;
							}
							else {
								if(!lastCharSpecial)
									bytes++;
								count++;
								if(i == 0 && startsSpecial == false) {
									startsSpecial = true;
									posicoes[j] = 0;
									j++;
								}
							}
						}
						else {
							if(bArquivo[i] == vetorCmp[0] && bArquivo[i + 1] == vetorCmp[1]) {
								
								if(i == 0 && startsSpecial == false) {
									startsSpecial = true;
								}
								
								if(count >= 1 && !lastCharSpecial) {
									bytes--;
									posicoes[j] = (i - (count + 1));
								}
								else
									posicoes[j] = (i - 1);	  //índice antes dos chars de fim de linha
								
								j++;
								i += 1; //adiciona um considerando a leitura de dois caracteres do vetor
								bytes += 2;
								lastCharSpecial = true;
								count = 0;
							}
							else {
								if(!lastCharSpecial)
									bytes++;
								
								count++;
								
								if(i == 0 && startsSpecial == false) {
									startsSpecial = true;
									posicoes[j] = 0;
									j++;
								}
							}
						}
					}
					else if(vetorCmp.length == 1) {
						
						if(bArquivo[i] == vetorCmp[0]) {
							
							if(i == 0 && startsSpecial == false) {
								startsSpecial = true;
							}
							
							if(count >= 1 && !lastCharSpecial) {
								bytes--;
								posicoes[j] = (i - (count + 1));
							}
							else
								posicoes[j] = (i - 1);	  //índice antes dos chars de fim de linha
							
							j++;
							bytes += 2;
							lastCharSpecial = true;
							count = 0;
						}
						else {
							if(!lastCharSpecial)
								bytes++;
							
							count++;
							
							if(i == 0 && startsSpecial == false) {
								startsSpecial = true;
								posicoes[j] = 0;
								j++;
							}
						}
					}
					else {
						this.codErro = ERRO_CONTAGEM_FIM_BLOCO;
						return (false);
					}
				}
				else {
					if(lastCharSpecial == true) {
						posicoes[j] = i;
						j++;
					}
					
					if(i == 0) {
						posicoes[j] = 0;
						j++;
					}
					
					bytes += 1;
					lastCharSpecial = false;
					count = 0;
				}
			}
			//inserir a posição final do arquivo no vetor de posições
			posicoes[j] = i - 1;
			arquivoCorrigido = new byte[bytes];
			
			int m = 0;
			i = 0;
			if(startsSpecial && !(posicoes[1] == (bytes - 1)))
				i++;
			
			for (; i < j; i++) {
				int k;
				
				for (k = posicoes[i]; k <= posicoes[i + 1]; k++, m++) {
					arquivoCorrigido[m] = bArquivo[k];
				}
				//se já copiou todo o arquivo, não inserir CR LF no fim do arquivo.
				if(m == bytes)
					break;
				
				arquivoCorrigido[m] = CHAR_CR;
				arquivoCorrigido[++m] = CHAR_LF;
				m++; i++;
			}
		} catch(Exception e) {
			Util.escreveArquivoLog("err_dnc_fim_de_bloco_", e, log, idLog);
			
			this.codErro = ERRO_SUBSTITUICAO_FIM_BLOCO;
			return (false);
		}
		
		try {
				BufferedOutputStream fdOut = new BufferedOutputStream(new FileOutputStream(new File(Arquivo_dest)));
				fdOut.write(arquivoCorrigido);
				fdOut.flush();
				fdOut.close();
			//File.WriteAllBytes(Arquivo_dest, bArquivo);
		} catch(Exception e) {
			Util.escreveArquivoLog("err_dnc_gravar_arquivo_", e, log, idLog);
			
			this.codErro = ERRO_GRAVAR_ARQUIVO;
			return (false);
		}
		
		this.escreverLog(DtHrEvento, goUpDncDTO.getidUp(), goUpDncDTO.getcodArquivo(), CaminhoUtilizado, "UP");
		
		return(true);
	}

	/*
	 * funcao que vai montando o arquivo recebido pelo coletor, para depois gravar
	 */
//	private String ByteToString(byte[] bDado) {
//		int tamanho;
//		int indice;
//		String TmpStr = "";
//		tamanho = bDado.length;
//		indice = 0;
//		
//		while (indice < tamanho) {
//			TmpStr += (Char.ConvertFromUtf32(bDado[indice])).ToString();
//			indice++;
//		}
//		
//		return TmpStr;
//	}
	
	private byte[] LimpaVetorDnc(byte[] Dado){
		int tamanho = Dado.length - 7;
		int indice=0;
		byte[] Vetor = new byte[tamanho];
		
		for(indice=0;indice<tamanho;indice++){
			Vetor[indice] = Dado[indice + 7];
		}
		
		return Vetor;
	}
	
//	private void ConcatenaVetores(byte[] destino, byte[] origem){
	private byte[] ConcatenaVetores(byte[] destino, byte[] origem){
		int tamanho = destino.length + origem.length;
		bAquivoTmp = new byte[tamanho];
		int indice=0;
		int indice2=0;
		
		while(indice < destino.length) {
			bAquivoTmp[indice]=destino[indice];
			indice++;
		}
		
		while(indice < tamanho){
			bAquivoTmp[indice]=origem[indice2];
			indice2++;
			indice++;
		}
		
		destino = new byte[tamanho];
		destino = bAquivoTmp;
		
		return(destino);
	}
	
	private boolean VerificaoFim(String oStrArquivo) {
		String[] fins;
		int indice;
		byte valor,verificador=(byte)33;
		
		if(goUpDncDTO.getTpFimArquivo() == null || goUpDncDTO.getTpFimArquivo().length() == 0) {
			goUpDncDTO.setTpFimArquivo("");
			return true;
		}
		
		fins = goUpDncDTO.getTpFimArquivo().split(",");
		
		for(int i = 0; i < fins.length; i++) {
			try{
				indice=oStrArquivo.lastIndexOf(fins[i]);
				if(indice >= 0) {
					if((fins[i].length() + indice) >= oStrArquivo.length()) return true;
					valor = (byte) oStrArquivo.charAt(indice + fins[i].length());
//					valor = Convert.ToByte(oStrArquivo[indice + fins[i].length()]);
					if(verificador>valor ) return true;
				}
			} catch(Exception e) {
			  //não faz nada
			}
		}
		return false;
	}
	
	public int verificaMontaArquivo(byte[] bDado) {
		StrTmpArquivo = new String(bDado);
//		StrTmpArquivo = ByteToString(bDado);
		String Buffer = "";
		String[] SpliDados = Util.PegaArgumentos(StrTmpArquivo);
		
		if(SpliDados[0].equals("PCTDNC")){
			//trata os dados e verifica inicio
			Buffer = new String(LimpaVetorDnc(bDado));
//			Buffer=ByteToString(LimpaVetorDnc(bDado));
			bArquivo = ConcatenaVetores(bArquivo, LimpaVetorDnc(bDado));
			
			if(StrArquivo.equals("")){
				//verifica inicio	
				if(goUpDncDTO.getTpIniArquivo() == null || goUpDncDTO.getTpIniArquivo().length() == 0) {
					goUpDncDTO.setTpIniArquivo("");
					return 1;
				}
				
				if(Buffer.startsWith(goUpDncDTO.getTpIniArquivo())){
					
					if(goUpDncDTO.getTpIniArquivo().length() > 0) {
						StrArquivo = Buffer.substring(0, goUpDncDTO.getTpIniArquivo().length()); // TODO: verificar se da certo
//						StrArquivo = Buffer.Remove(0, goUpDncDTO.getTpIniArquivo().length());
					}
					return 1;
				}
				else {
					return 2;//erro inicio inválido
				}
			}
			else {
				StrArquivo += Buffer; //String sem o inicio utilizado para verificar o fim do arquivo
			}
			return 1;
		}
		else if(SpliDados[0].equals("FIMRCVDNC")) {
			//verifica fim
			if(VerificaoFim(StrArquivo)) {
				//finaliza e salva o ARQUIVO_DUPLICADO em BLQ
				return 3;
			}
			else {
				return 4;
			}
		}
		else if(SpliDados[0].equals("BUFFEROVERFLOW")){
			return 5;
		}
		else if(SpliDados[0].equals("FIM")){
			return 6;
		}
		else{
			return 0;
		}
	}

	public void escreverLog(Calendar DtHrEvento, String idUp, String codArquivo, String Path, String sTipo) {
		String sLinha;
		String sArquivoLog;
		
		sArquivoLog = "dnc" + DtHrEvento.get(Calendar.YEAR) + DtHrEvento.get(Calendar.MONTH) + ".log";
		
		sLinha = DtHrEvento + " - " + idUp + " - " + codArquivo + " - " + Path + " - " + sTipo;
		
		log.info(idLog, 0, sArquivoLog);
		log.info(idLog, 1, sLinha);
		
//		TextWriter tw = new StreamWriter(sArquivoLog, true);
//		tw.WriteLine(sLinha);
//		tw.Close();
	}
	/*
	public bool verificafimdoArquivo() {
		//usar bArquivo
		//bArquivo
	}
	 * */
}
