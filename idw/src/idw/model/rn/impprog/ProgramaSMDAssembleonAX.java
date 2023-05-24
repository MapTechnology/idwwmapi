package idw.model.rn.impprog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.excessoes.SemCategoriaException;
import idw.model.excessoes.SemFeedersException;


public class ProgramaSMDAssembleonAX extends ProgramaSMDPanasonic{

	private String tipo1 = "\"Bank\";\"Feeder\";\"Line\";\"Part Number\";\"Descrição\";\"Count\";\"Feeder Type\";\"Cavity pitch\"";
	private String tipo2 = "\"Bank\";\"Feeder\";\"Pick Pos   Top Guide\";\"Part Number\";\"Descrição\";\"Package\";\"Count\";\"Feeder Type\";\"Cavity pitch\"";
	private String tipo3 = "\"Bank\";\"Feeder\";\"Pick Pos   Top Guide\";\"Part Number\";\"Package\";\"Count\";\"Feeder Type\";\"Cavity pitch\"";
	private String tipo4 = "\"Bank\";\"Feeder\";\"Pick Pos\";\"Part Number\";\"Description\";\"Package\";\"Count\";\"Feeder Type\";\"Cavity pitch\"";
	
	private boolean isFileParsed = false;
	private String fileName;
	private String programa;
	private String conteudo;
	private int tipoArquivoMapa;
	private String[] conteudoQuebradoEmN;
	private Date dthrPrograma;
    private List<MaquinaSMDPanasonic> maquinas;
    private List<MaquinaSMDFeeder> feeders;
    
    private String bank;
    private String feederString;
    private String pickPos;
    private String partNumber;
    private String count;
    private String feederType;
    private String cavityPitch;
    
    private String descricao; //
    private String package_; //
    
    private String machineName;
    
    
    

	public ProgramaSMDAssembleonAX(String arquivo, String conteudo) {
		super(arquivo, conteudo);
		this.isFileParsed = false;
		this.fileName = arquivo;
		this.programa = "";
		this.conteudo = conteudo;
		this.dthrPrograma = new Date();
		this.maquinas = new ArrayList<MaquinaSMDPanasonic>();
		this.feeders = new ArrayList<MaquinaSMDFeeder>();
	}
    
	private String linhaToString() {
		String retorno = null;
		retorno = bank + ";" + feederString + ";" + pickPos + ";" + partNumber
				 + ";" + descricao + ";" +  package_  + ";" + count
				 + ";" + feederType + ";" + cavityPitch;
		
		return retorno;
	}
	
	
    private String[] explode(String text, String separador) {
    	String[] retorno = null;
    	// Protecoes
    	if(text == null || separador == null)
    		return retorno;
    	
    	retorno = text.split(separador);
    	
    	return retorno;
    }
    
    private String extraiAspas(String entrada) {
    	String retorno = null;
    	
    	if (entrada != null && !entrada.contains("\""))
    		return retorno;
    	
    	retorno = entrada.replace("\"", "");
    	
    	return retorno;
    }
    
    private int determinaTipoMapa() {
    	int retorno = 0;
    	if (conteudo == null || conteudo.equals(""))
    		return retorno;
    	if (conteudoQuebradoEmN == null)
    		return retorno;
    	if(conteudoQuebradoEmN[2].equals(tipo1))
    		retorno = 1;
    	else if(conteudoQuebradoEmN[2].equals(tipo2))
    		retorno = 2;
    	else if(conteudoQuebradoEmN[2].equals(tipo3))
    		retorno = 3;
    	else if(conteudoQuebradoEmN[2].equals(tipo4))
    		retorno = 4;
    	
    	tipoArquivoMapa = retorno;
    	return retorno;
    }
    // Line = Pick Pos
    
    // Tipos de mapa por cabecalho:
    // Tipo 1
    // "Bank","Feeder","Line","Part Number","Descrição","Count","Feeder Type","Cavity pitch"

    // Tipo 2
    // "Bank","Feeder","Pick Pos   Top Guide","Part Number","Descrição","Package","Count","Feeder Type","Cavity pitch"
    // "Bank","Feeder","Pick Pos   Top Guide","Part Number","Descrição","Package","Count","Feeder Type","Cavity pitch"
    
    // Tipo 3
    // "Bank","Feeder","Pick Pos   Top Guide","Part Number","Package","Count","Feeder Type","Cavity pitch"
    
    // Tipo 4
    // "Bank","Feeder","Pick Pos","Part Number","Description","Package","Count","Feeder Type","Cavity pitch"
    // "Bank","Feeder","Pick Pos","Part Number","Description","Package","Count","Feeder Type","Cavity pitch"
    
    
	private void parseArquivoInterno() {
		// System.out.println(conteudo);
		if(isFileParsed)
			return;
		
		conteudoQuebradoEmN = explode(conteudo, "\n");
		
		if (conteudoQuebradoEmN != null) {
			determinaTipoMapa();
			// System.out.println(tipoArquivoMapa);
			// Percorre linhas
			for(String linha : conteudoQuebradoEmN) {
				if (linha != null && !linha.equals("")) {
					// System.out.println(linha);
					// Desconsidera o cabecalho na extracao de dados
					if (linha.contains("Bank"))
						continue;
					// Pega o Machine Name e o Program Name
					else if (linha.contains("Machine Name")) {
						String[] campos = explode(linha, ";");
						if (campos != null) {
							machineName = campos[1];
							continue;
						}
						
					} else if (linha.contains("Program Name")) {
						String[] campos = explode(linha, ";");
						if (campos != null) {
							programa = campos[1];
							continue;
						}
					}
					
					
					String[] campos = explode(linha, ";");
					if (campos != null) {
						
						// Percorre os campos da linha
						bank = extraiAspas(campos[0]);
						feederString = extraiAspas(campos[1]);
						pickPos = extraiAspas(campos[2]);
						partNumber = extraiAspas(campos[3]);
						
						// Considerando que existem modulos a serem considerados
						// feederString = bank + "00" + extraiAspas(campos[1]) + pickPos;
						
						// Descricao
						if (tipoArquivoMapa != 3)
							descricao = extraiAspas(campos[4]);
						else
							descricao = "";
						
						// Package
						if (tipoArquivoMapa != 1 && tipoArquivoMapa != 3)
							package_ = extraiAspas(campos[5]);
						else if (tipoArquivoMapa == 3)
							package_ = extraiAspas(campos[4]);
						else
							package_ = "";
						
						// Count
						if (tipoArquivoMapa == 1 || tipoArquivoMapa == 3)
							count = extraiAspas(campos[5]);
						else if (tipoArquivoMapa != 0)
							count = extraiAspas(campos[6]);
						else
							count = "";
						
						// Feeder Type
						if (tipoArquivoMapa == 1 || tipoArquivoMapa == 3)
							feederType = extraiAspas(campos[6]);
						else if (tipoArquivoMapa != 0)
							feederType = extraiAspas(campos[7]);
						else
							feederType = "";
						
						// Cavity pitch
						if (tipoArquivoMapa == 1 || tipoArquivoMapa == 3)
							cavityPitch = extraiAspas(campos[7]);
						else if (tipoArquivoMapa != 0)
							cavityPitch = extraiAspas(campos[8]);
						else
							cavityPitch = "";
						
						MaquinaSMDFeeder feeder = new MaquinaSMDFeeder();
						feeder.setCdProduto(partNumber);
						feeder.setIdNum("parece sem uso"); // mantido inalterado do ProgramaSMDAssemble
						feeder.setCdFeederDePara(bank + "00" + feederString + pickPos);
						feeder.setQuantidade(new BigDecimal(count));
						feeder.setPosicao(new BigDecimal(feederString));
						feeders.add(feeder);
						isFileParsed = true;
						
						if(maquinas.size() == 0) {
			        		MaquinaSMDPanasonic maquina = new MaquinaSMDPanasonic();
			        		maquina.setNomeMaquina(machineName);
			        		
			        		maquinas.add(maquina);
		        		}
						
						System.out.println(linhaToString());
					}
				}
				
			}
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
