package idw.model.rn.impprog;

import idw.model.excessoes.SemCategoriaException;
import idw.model.excessoes.SemFeedersException;
import idw.model.rn.impprog.siemens.DivisionSiemens;
import idw.model.rn.impprog.siemens.FeederSiemens;
import idw.model.rn.impprog.siemens.MaquinaSMDSiemens;
import idw.model.rn.impprog.siemens.TableMaquinaSiemens;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgramaSMDSiemens extends AProgramaSMD{
	public String arquivo;
	public String conteudo = new String();
	public String programa;
	public Date dataDoPrograma;
	public List<MaquinaSMDPanasonic> maquinas = new ArrayList<MaquinaSMDPanasonic>();
	public List<MaquinaSMDSiemens> maquinasSiemens = new ArrayList<MaquinaSMDSiemens>();
	public List<TableMaquinaSiemens> tables = new ArrayList<TableMaquinaSiemens>();
	public List<FeederSiemens> feeders = new ArrayList<FeederSiemens>();
	public List<DivisionSiemens> divisions = new ArrayList<DivisionSiemens>();
	
	
	public ProgramaSMDSiemens(String arquivo, String conteudo){
		this.arquivo = arquivo;
		this.conteudo = conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}



	@Override
	public List<MaquinaSMDPanasonic> obtemMaquinas() throws SemCategoriaException {
		// TODO Auto-generated method stub
		int contador = 0;
		int compFantasma = 0;
		List<String> linesCampos = new ArrayList<String>();
		linesCampos = obtemChave("PrintLine", this.getConteudo());
		
		this.programa = obtemChave("SetupName", linesCampos.get(0)).get(0);
		String dataDoProgramaString = obtemChave("DateTimeNow", linesCampos.get(0)).get(0);
		SimpleDateFormat formatoDaData=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			this.dataDoPrograma = formatoDaData.parse(dataDoProgramaString);
		} catch (ParseException e) {
			this.dataDoPrograma = new Date();
		}
		List<String> maquinasCampos = new ArrayList<String>();
		List<String> tablesCampos = new ArrayList<String>();
		List<String> feederCampos = new ArrayList<String>();
		List<String> divisionCampos = new ArrayList<String>();
		maquinasCampos = obtemChave("PrintMachine", this.getConteudo());
		tablesCampos = obtemChave("PrintTable", this.getConteudo());
		feederCampos = obtemChave("PrintFeeder", this.getConteudo());
		divisionCampos = obtemChave("PrintDivision", this.getConteudo());
		
		for(String maquinaCampo : maquinasCampos){
			MaquinaSMDSiemens maquina = new MaquinaSMDSiemens();
			String machineOID = obtemChave("MachineOID", maquinaCampo).get(0);
			maquina.setMachineOID(machineOID);
		    String lineOID = obtemChave("LineOID", maquinaCampo).get(0);
		    maquina.setLineOID(lineOID);
		    String machineName = obtemChave("MachineName", maquinaCampo).get(0);
		    maquina.setMachineName(machineName);
		    String machineType = obtemChave("MachineType", maquinaCampo).get(0);
		    maquina.setMachineType(machineType);
		    String machineNr = obtemChave("MachineNr", maquinaCampo).get(0);
		    maquina.setMachineNr(machineNr);
		    maquinasSiemens.add(maquina);
		    addMaquinaSiemensAsPanasonic(maquina);
		}
		
		for(String tableCampo: tablesCampos) {
			TableMaquinaSiemens table = new TableMaquinaSiemens();
			String tableOID = obtemChaveUnica("TableOID", tableCampo);
			table.setTableOID(tableOID);
			String machineOID = obtemChaveUnica("MachineOID", tableCampo);
			table.setMachineOID(machineOID);
			String tableName = obtemChaveUnica("TableName", tableCampo);
			table.setTableName(tableName);
			String tableNr = obtemChaveUnica("TableNr", tableCampo);
			table.setTableNr(tableNr);
			String tableType = obtemChaveUnica("TableType", tableCampo);
			table.setTableType(tableType);
			String tableIsConstant = obtemChaveUnica("TableIsConstant", tableCampo);
			table.setTableIsConstant(tableIsConstant);
			//tables.add(table);
			addTableByOID(table);
		}
		
		for(String feederCampo: feederCampos) {
			FeederSiemens feeder = new FeederSiemens();
			String feederOID = obtemChaveUnica("FeederOID", feederCampo);
			feeder.setFeederOID(feederOID);
			String tableOID = obtemChaveUnica("TableOID", feederCampo);
			feeder.setTableOID(tableOID);
			String trackNr = obtemChaveUnica("TrackNr", feederCampo);
			feeder.setTrackNr(trackNr);
			String feedertype = obtemChaveUnica("Feedertype", feederCampo);
			feeder.setFeedertype(feedertype);
			String feederSortNr = obtemChaveUnica("FeederSortNr", feederCampo);
			feeder.setFeederSortNr(feederSortNr);
			String isTray = obtemChaveUnica("IsTray", feederCampo);
			feeder.setIsTray(isTray);
			//feeders.add(feeder);
			addFeederByOID(feeder);
		}
		
		for (String divisionCampo: divisionCampos) {
			contador = contador + 1;
			DivisionSiemens division = new DivisionSiemens();
			String component = obtemChaveUnica("Component", divisionCampo);
			if(component == null || component.equals("") || component.length() ==0) {
				compFantasma = compFantasma + 1;
				String divisionOID = obtemChaveUnica("DivisionOID", divisionCampo);
				//System.out.println(divisionOID + "." + "CONTAGEM DOS COMPONENTES FANTASMAS: " + compFantasma);
				continue;
			}
			division.setComponent(component);
			String divisionOID = obtemChaveUnica("DivisionOID", divisionCampo);
			division.setDivisionOID(divisionOID);
			String feederOID = obtemChaveUnica("FeederOID", divisionCampo);
			division.setFeederOID(feederOID);
			String divisionNr = obtemChaveUnica("DivisionNr", divisionCampo);
			division.setDivisionNr(divisionNr);
			String componentShape = obtemChaveUnica("ComponentShape", divisionCampo);
			division.setComponentShape(componentShape);
			String componentShapeNr = obtemChaveUnica("ComponentShapeNr", divisionCampo);
			division.setComponentShapeNr(componentShapeNr);
			String divisionNotUsed = obtemChaveUnica("DivisionNotUsed", divisionCampo);
			division.setDivisionNotUsed(divisionNotUsed);
			String compComment = obtemChaveUnica("CompComment", divisionCampo);
			division.setCompComment(compComment);
			String compShapeComment = obtemChaveUnica("CompShapeComment", divisionCampo);
			division.setComponentShape(compShapeComment);
			String componentFullPath = obtemChaveUnica("ComponentFullPath", divisionCampo);
			division.setComponentFullPath(componentFullPath);
			String componentShapeFullPath = obtemChaveUnica("ComponentShapeFullPath", divisionCampo);
			division.setComponentShapeFullPath(componentShapeFullPath);
			
			String towerNr = obtemChaveUnica("TowerNr", divisionCampo);
			division.setTowerNr(towerNr);
			String levelNr = obtemChaveUnica("LevelNr", divisionCampo);
			division.setLevelNr(levelNr);
			String pickupsWithQuantity = obtemChaveUnica("PickupsWithQuantity", divisionCampo);
			division.setPickupsWithQuantity(pickupsWithQuantity);
			
			//divisions.add(division);
			addDivisionByOID(division);
			//System.out.println(divisionOID + "." + "CONTAGEM: " + contador);
		}
		
		return this.maquinas;
	}

	@Override
	public String getPrograma() {
		// TODO Auto-generated method stub
		return this.programa;
	}

	public String getConteudo() {
		return this.conteudo;
	}
	@Override
	public Date obtemDataHoraPrograma() throws SemCategoriaException {
		// TODO Auto-generated method stub
		return this.dataDoPrograma;
	}

	@Override
	public List<MaquinaSMDFeeder> obtemFeeders(MaquinaSMDPanasonic maquinaSMD) throws SemFeedersException {
		// TODO Auto-generated method stub
		List<MaquinaSMDFeeder> listaFeederSMD = new ArrayList<MaquinaSMDFeeder>();
		
		MaquinaSMDSiemens maquinaTraduzida = retornaSiemensDaPanasonic(maquinaSMD);
		for(TableMaquinaSiemens table : maquinaTraduzida.getTablesmaquinas()){
			for(FeederSiemens feeder: table.getFeeders()) {
				for(DivisionSiemens division: feeder.getComponentes()) {
					MaquinaSMDFeeder novo = new MaquinaSMDFeeder();
					if(!(division.getCompComment().length() == 0) && !(division.getCompComment().equals(""))){
						novo.setDescricao(division.getCompComment());
					}
					else
						novo.setDescricao("Nao ha descricao");
					int posicao = 0;
					int feederNr = 0;
					try{
						posicao = Integer.parseInt(division.getDivisionNr());
						feederNr = Integer.parseInt(feeder.getTrackNr());
						posicao = (posicao-1)*2 + feederNr;
					}
					catch(Exception e) {
						posicao = 0;
					}
					novo.setPosicao(new BigDecimal(posicao));
					//Luiz 20190516 Caso seja da bandeja, o towerNr sera diferente de 0 e o programa devera cair no else
					//Luiz 20190516 Caso nao seja da bandeja, entao a regra segue como o padra da siemens ex: mesa 1 e trilha 13 devera ser: 1013
					if(division.getTowerNr().equals("0")) {
					if (posicao < 10)
						novo.setCdFeederDePara(table.getTableNr() + "00" + posicao);
					else
						novo.setCdFeederDePara(table.getTableNr() + "0" + posicao);
					}
					else {
						try{
						posicao = Integer.parseInt(division.getLevelNr());
						}
						catch(Exception e)
						{
							posicao = 0;
						}
						if(posicao < 10) {
							novo.setCdFeederDePara("Z" + division.getTowerNr()+ "00" + division.getLevelNr());
						}
						else 
							novo.setCdFeederDePara("Z" + division.getTowerNr() + "0" + division.getLevelNr());
						}
					try{
						if(division.getPickupsWithQuantity() == null || division.getPickupsWithQuantity().equals("")
								|| division.getPickupsWithQuantity().equals("-1")) {
							novo.setQuantidade(new BigDecimal(0));
						}
						else {
							novo.setQuantidade(new BigDecimal(division.getPickupsWithQuantity()));	
						}
					}
					catch(Exception e)
					{
						novo.setQuantidade(new BigDecimal(0));
					}
					
					if(division.getComponent().contains(",") || division.getComponent().contains("/"))
					{
						String[] campos = null;
						String campoLimpo = division.getComponent().replaceAll("\\s+", "");
						campoLimpo = campoLimpo.replaceAll(" ", "");
						if(division.getComponent().contains(","))
							campos = campoLimpo.split(",");
						else if (division.getComponent().contains("/")) { 
							campos = campoLimpo.split("/");
						}
						novo.setCdProduto(campos[0]);
						novo.setCdProdutoAlternativo(campoLimpo.substring(campoLimpo.indexOf(campos[0]) + campos[0].length() + 1));
						listaFeederSMD.add(novo);
					} else {
					novo.setCdProduto(division.getComponent());
					novo.setCdProdutoAlternativo("");
					listaFeederSMD.add(novo);
				}
			}
		}
		}
		//System.out.println(maquinaSMD.getNomeMaquina());
		//imprimeFeeders(listaFeederSMD);
		
		return listaFeederSMD;
	}
	
	public List<String> obtemChave(String chave, String conteudo){
	List<String> retorno = new ArrayList<String>();

	// Alessandre: Comentei o loop abaixo pois o conteudo sempre tem erro de mal formacao
	// entao vou pesquisar como string mesmo
//	NodeList nodes = doc.getElementsByTagName(chave);
//    for (int i = 0; i < nodes.getLength(); i++) {
//            Element elemento = (Element) nodes.item(i);
//            String valor = elemento.getTextContent();
//            if (valor.equals(chave) == false)
//            	retorno.add(valor);
//    }
	
	int posicaoChave = conteudo.indexOf(chave);
	String resto = conteudo;
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
	
	public String obtemChaveUnica(String chave, String conteudo){
	String retorno = new String("");

	// Alessandre: Comentei o loop abaixo pois o conteudo sempre tem erro de mal formacao
	// entao vou pesquisar como string mesmo
//	NodeList nodes = doc.getElementsByTagName(chave);
//    for (int i = 0; i < nodes.getLength(); i++) {
//            Element elemento = (Element) nodes.item(i);
//            String valor = elemento.getTextContent();
//            if (valor.equals(chave) == false)
//            	retorno.add(valor);
//    }
	
	int posicaoChave = conteudo.indexOf("<" + chave + ">");
	String resto = conteudo;
	if (posicaoChave >= 0){
		
		resto = resto.substring(posicaoChave + chave.length() + 2);
		String ateC = "</" + chave + ">";
		
		int ate = resto.indexOf(ateC);
		if(ate >= 0){
		String valor = resto.substring(0, ate );
		retorno = valor;
		}
	}
	
	return retorno;
}


	public void addFeederByOID(FeederSiemens OID) {
		for(MaquinaSMDSiemens maquina : maquinasSiemens){
			for(TableMaquinaSiemens table : maquina.getTablesmaquinas()){
				if (table.getTableOID().equals(OID.getTableOID())) {
					table.getFeeders().add(OID);
					return;
				}
			}
		}
		System.out.println("NAO ENCONTREI A TABLE DE OID: " + OID.getTableOID() + " DO FEEDER DE OID:" + OID.getFeederOID());

	}
	
	public void addDivisionByOID(DivisionSiemens OID) {
		for(MaquinaSMDSiemens maquina : maquinasSiemens){
			for(TableMaquinaSiemens table : maquina.getTablesmaquinas()){
				for(FeederSiemens feeder: table.getFeeders()) {
					if(feeder.getFeederOID().equals(OID.getFeederOID())) {
						feeder.getComponentes().add(OID);
						return;
					}
				}
			}
		}
		System.out.println("NAO ENCONTREI O FEEDER DE OID: " + OID.getFeederOID() + " DA DIVISIO DE OID:" + OID.getDivisionOID());

	}
	
	public void addTableByOID(TableMaquinaSiemens OID) {
		for(MaquinaSMDSiemens maquina : maquinasSiemens){
			if (maquina.getMachineOID().equals(OID.getMachineOID())) {
				maquina.getTablesmaquinas().add(OID);
				return;
			}
		}
		System.out.println("NAO ENCONTREI A MAQUINA DE OID: " + OID.getMachineOID() + " DA TABLE DE OID:" + OID.getTableOID());
	}
	
	public MaquinaSMDSiemens getMaquinaByOID(String OID) {
		for(MaquinaSMDSiemens maquina : maquinasSiemens){
			if (maquina.getMachineOID().equals(OID)) {
				return maquina;
			}
		}
		return null;
	}
	
	public void addMaquinaSiemensAsPanasonic(MaquinaSMDSiemens maquinaSiemens){
		MaquinaSMDPanasonic maquina = new MaquinaSMDPanasonic();
		maquina.setNomeMaquina(maquinaSiemens.getMachineName());
		maquina.setCicloPadrao(0);
		this.maquinas.add(maquina);
	}
	
	public MaquinaSMDSiemens retornaSiemensDaPanasonic(MaquinaSMDPanasonic maquina){
		MaquinaSMDSiemens retorno = new MaquinaSMDSiemens();
		for(MaquinaSMDSiemens maquinaS : maquinasSiemens) {
			if(maquina.getNomeMaquina().equals(maquinaS.getMachineName())) {
				retorno = maquinaS;
				break;
			}
		}
		return retorno;
	}
	
	public void imprimeFeeders(List<MaquinaSMDFeeder> listaSMD) throws SemFeedersException {
		// TODO Auto-generated method stub
		
		for(MaquinaSMDFeeder ele: listaSMD) {
			System.out.println("POSICAO: "+ ele.getCdFeederDePara() + " CODIGO : " + ele.getCdProduto() + "ALTERNATIVO: " + ele.getCdProdutoAlternativo());
		}
}
}
