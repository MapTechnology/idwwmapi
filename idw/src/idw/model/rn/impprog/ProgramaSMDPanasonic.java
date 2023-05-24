package idw.model.rn.impprog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.excessoes.SemCategoriaException;
import idw.model.excessoes.SemFeedersException;
import idw.model.rn.DataHoraRN;


public class ProgramaSMDPanasonic  extends AProgramaSMD{

	private String arquivo;
	private String conteudo;

	//Esta classe terá metodos abstratos para fazer a validação de regras de negocio de acordo com a empresa
	
	
	public ProgramaSMDPanasonic(String arquivo, String conteudo){
		this.arquivo = arquivo;
		this.conteudo = conteudo;
	}

	public String getArquivo() {
		return arquivo;
	}
	
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	@Override
	public String getPrograma() {
		String programa = arquivo.substring(0, arquivo.length() - 0);
		return programa;
	}

	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	private String obtemApenasCategoria(String conteudo, String categoria) throws SemCategoriaException{
		if (conteudo.indexOf(categoria) < 0) {
			//System.out.println("Nao existe a categoria " + categoria + " no conteudo " + conteudo);
			throw new SemCategoriaException();
		}
		
		String retorno = conteudo.substring(conteudo.indexOf(categoria));

		retorno = retorno.substring(retorno.indexOf('\n') + 1);
		retorno = retorno.substring(0, retorno.indexOf('[') - 1);

		return retorno;
	}

	private String obtemValorNaCategoria(String categoria, String campo){
		String retorno = categoria.substring(categoria.indexOf(campo) + 5);

		retorno = retorno.substring(0, retorno.indexOf('\n'));

		return retorno;		
	}

	@Override
	public Date obtemDataHoraPrograma() throws SemCategoriaException{
		String dthr = "";

		String categoria = obtemApenasCategoria(conteudo, "[Index]");
		dthr = obtemValorNaCategoria(categoria, "Date");

		Date retorno = DataHoraRN.stringToDate(dthr, "yyyy/MM/dd,hh:mm:ss");

		return retorno;
	}

	public List<String> obtemLinhas() {
		int posicao = getPrograma().length() - 4;
		String linha = getPrograma().substring(posicao, posicao+2);
		List<String> retorno = new ArrayList<String>();

		if (!linha.substring(0, 1).equals("0")){
			retorno.add("0" + linha.substring(0, 1));
			retorno.add("0" + linha.substring(1, 2));
		} else {
			retorno.add(linha);
		}
		return retorno;
	}

	@Override
	public List<MaquinaSMDPanasonic> obtemMaquinas() throws SemCategoriaException{
		List<MaquinaSMDPanasonic> retorno = new ArrayList<MaquinaSMDPanasonic>();

		String categoria = obtemApenasCategoria(conteudo, "[Machines]");
		List<String> linhas = obtemLinhas();

		for (String linha : linhas){
			int contadorLinha = 1;
			do {
				String buffer = obtemBuffer(categoria, contadorLinha++);

				if (buffer != null && !buffer.equals("")){
					if (
							buffer.substring(0, 1).equals("0") || 
							buffer.substring(0, 1).equals("1") || 
							buffer.substring(0, 1).equals("2") || 
							buffer.substring(0, 1).equals("3") || 
							buffer.substring(0, 1).equals("4") || 
							buffer.substring(0, 1).equals("5") || 
							buffer.substring(0, 1).equals("6") || 
							buffer.substring(0, 1).equals("7") || 
							buffer.substring(0, 1).equals("8") || 
							buffer.substring(0, 1).equals("9") ) {
						// Se for uma linha valida para maquina
						MaquinaSMDPanasonic maquina = new MaquinaSMDPanasonic();
						maquina.setLinha(linha);
						maquina.setNomeMaquina(obtemNomeMaquina(buffer));
						
						// Procura se maquina ja existe no retorno. Se existir adiciona apenas o prefixo do feeder
						boolean isExiste = false;
						for (MaquinaSMDPanasonic imaq : retorno){
							if (imaq.equals(maquina)){
								isExiste = true;
								maquina = imaq;
								break;
							}
						}
						maquina.addPrefixoFeeders(obtemPrefixoFeeder(buffer));
						if (isExiste == false)
							retorno.add(maquina);
					}
				} else {
					contadorLinha = -1;
				}
			} while (contadorLinha > 0);
		}

		return retorno;
	}

	private String obtemNomeMaquina(String buffer){
		String retorno = "";

		retorno = buffer.substring(buffer.indexOf(" ") + 1);
		retorno = retorno.substring(0, retorno.indexOf(" "));

		return retorno;
	}


	private String obtemPrefixoFeeder(String buffer){
		String retorno = "";

		retorno = buffer.substring(0, buffer.indexOf(" "));

		return retorno;
	}

	private String obtemBuffer(String categoria, int contador){
		String retorno = categoria;

		int inicio = 0;
		int fim = retorno.indexOf('\n');

		for (int i = 2 ; i <= contador ; i++){
			inicio = fim + 1;

			if (retorno.indexOf('\n', inicio) < 0)
				fim = retorno.length();
			else
				fim = retorno.indexOf('\n', inicio);
		}

		try{
			retorno = categoria.substring(inicio, fim);
		} catch (IndexOutOfBoundsException e){
			retorno = "";
		}
		return retorno;
	}



	@Override
	public List<MaquinaSMDFeeder> obtemFeeders(MaquinaSMDPanasonic maquinaSMD) throws SemFeedersException{
		
		List<MaquinaSMDFeeder> retorno = new ArrayList<MaquinaSMDFeeder>();
		List<MaquinaSMDFeeder> temporario = new ArrayList<MaquinaSMDFeeder>(); 

		String categoria = "";
		
		try {
			categoria = obtemApenasCategoria(conteudo, "[PartsLibIndex]");
		} catch (SemCategoriaException e) {
			try {
				categoria = obtemApenasCategoria(conteudo, "[PartsData]");
			} catch (SemCategoriaException e1) {
				throw new SemFeedersException();
			}
		}

		// Obtem todos os componentes do arquivo independente da maquina
		int contadorLinha = 1;
		do {
			String buffer = obtemBuffer(categoria, contadorLinha++);

			if (buffer != null && !buffer.equals("")){
				if (
						buffer.substring(0, 1).equals("0") || 
						buffer.substring(0, 1).equals("1") || 
						buffer.substring(0, 1).equals("2") || 
						buffer.substring(0, 1).equals("3") || 
						buffer.substring(0, 1).equals("4") || 
						buffer.substring(0, 1).equals("5") || 
						buffer.substring(0, 1).equals("6") || 
						buffer.substring(0, 1).equals("7") || 
						buffer.substring(0, 1).equals("8") || 
						buffer.substring(0, 1).equals("9") ) {

					String cdProduto = "";
					String idNum = "";

					idNum = buffer.substring(0, buffer.indexOf(' '));
					cdProduto = buffer.substring(buffer.indexOf( (char) 34) + 1);
					cdProduto = cdProduto.substring(0, cdProduto.indexOf((char) 34));

					MaquinaSMDFeeder feeder = new MaquinaSMDFeeder();
					feeder.setCdProduto(cdProduto);
					feeder.setIdNum(idNum);
					temporario.add(feeder);
				}
			} else {
				contadorLinha = -1;
			}
		} while (contadorLinha > 0);

		// Obtem apenas os componentes da maquina
		try {
			categoria = obtemApenasCategoria(conteudo, "[StockData]");
		} catch (SemCategoriaException e) {
			throw new SemFeedersException();
		}
		contadorLinha = 1;
		do {
			String buffer = obtemBuffer(categoria, contadorLinha++);
			
			if (buffer != null && !buffer.equals("")){
				if (
						buffer.substring(0, 1).equals("0") || 
						buffer.substring(0, 1).equals("1") || 
						buffer.substring(0, 1).equals("2") || 
						buffer.substring(0, 1).equals("3") || 
						buffer.substring(0, 1).equals("4") || 
						buffer.substring(0, 1).equals("5") || 
						buffer.substring(0, 1).equals("6") || 
						buffer.substring(0, 1).equals("7") || 
						buffer.substring(0, 1).equals("8") || 
						buffer.substring(0, 1).equals("9") ) {

					String componenteL = "";
					String componenteR = "";

//					Somente pra ficar registrado o que seria cada coluna do [StockData]
//                  1a coluna IDNUM é somente a ordem de colocação
//					2a N é a mesa e o feeder, msm padrão do [PositionData]
//					3a PA é o feeder na posição L
//					4a PB é o feeder na posição R
//
//					Caso a coluna PA ou PB esteja com o ZERO é pq nao ha componente naquele
//					feeder.
//
//					Exemplo:
//					IDNUM N 	PA 	PB 	PC  PD  PE  PF  PG 	PH PI PJ TA TB 		TC TD TE TF TG TH TI TJ DA DB
//					1 	  10003 0 	122 0 	0 	0 	0 	0 	0  0  0  0  2481 	0  0  0  0  0  0  0  0  0  0

					
					buffer = buffer.substring(buffer.indexOf(' ') + 1);

					String parts = buffer.substring(0, buffer.indexOf(' '));

					buffer = buffer.substring(buffer.indexOf(' ') + 1);

					componenteL = buffer.substring(0, buffer.indexOf(' '));

					if (componenteL.equals("0"))
						componenteL = "";

					buffer = buffer.substring(buffer.indexOf(' ') + 1);

					componenteR = buffer.substring(0, buffer.indexOf(' '));
					
					if (componenteR.equals("0"))
						componenteR = "";

					// Se o feeder avaliado pertencer a maquina desejada, entao considerar seu processamento\
					String pu = parts;
					String side = "";
					if (componenteL.equals("") == false)
						side = "1";
					
					if (maquinaSMD.isFeederPertenceAMaquina(pu, side)){
						for (MaquinaSMDFeeder feeder : temporario){
							// Se o feeder encontrado for do produto encontrado anteriormente (loop acima) entao considera-lo para retorno
							if (feeder.getIdNum().equals(componenteL)){
								MaquinaSMDFeeder feederFinal = new MaquinaSMDFeeder();
								feederFinal.setCdProduto(feeder.getCdProduto());
								feederFinal.setIdNum(feeder.getIdNum());
								feederFinal.setCdFeederDePara(pu + side);
								feederFinal.setPosicao(null);

								retorno.add(feederFinal);
							}
						}
					}

					// Se o feeder avaliado pertencer a maquina desejada, entao considerar seu processamento
					side = "";
					if (componenteR.equals("") == false)
						side = "2";
					
					if (maquinaSMD.isFeederPertenceAMaquina(pu, side)){
						for (MaquinaSMDFeeder feeder : temporario){
							// Se o feeder encontrado for do produto encontrado anteriormente (loop acima) entao considera-lo para retorno
							if (feeder.getIdNum().equals(componenteR)){
								MaquinaSMDFeeder feederFinal = new MaquinaSMDFeeder();
								feederFinal.setCdProduto(feeder.getCdProduto());
								feederFinal.setIdNum(feeder.getIdNum());
								feederFinal.setCdFeederDePara(pu + side);
								feederFinal.setPosicao(null);
								retorno.add(feederFinal);
							}
						}
					}
				}
			} else {
				contadorLinha = -1;
			}
		} while (contadorLinha > 0);

		return retorno;
	}

}
