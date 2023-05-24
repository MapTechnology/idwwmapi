package idw.model.rn.consolidacao.estoque;

import org.apache.commons.lang3.StringUtils;

import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPa;

public class ConsultaCdPaComFormatacoes {
	
	/**
	 * encontra OmPa pelo cdPa ou cdPa aproximado
	 */
	public OmPa getOmPa(String cdPa, OmMapa mapa){
		
		String mesa;
		String posicao;
		String lado;
		
		if(cdPa.length() <= 6){
			mesa = StringUtils.left(cdPa, 2);
			posicao = StringUtils.substring(cdPa, 2, 5);
		}else{
			mesa = StringUtils.left(cdPa, 3);
			if(StringUtils.right(String.valueOf(mesa), 1).equals("0")){
				mesa = StringUtils.substring(mesa, 0, 2);
			}
			
			posicao = StringUtils.substring(cdPa, 3, 6);
		}
		lado = StringUtils.right(cdPa, 1);
		OmPa paRetorno = null;
		
		/*n�o estou verificando o último caracter que aparentemente seria o lado
		quando o a quantidade de caracteres é igual a 5 aparentemente sempre ta vindo sem lado*/
		if(cdPa.length() == 5){
			paRetorno = variarMesaComZ(mesa, posicao, null, mapa); 
		}
		if(cdPa.length() == 6){
			paRetorno = variarMesaComZ(mesa, posicao, lado, mapa);
		}
		if(cdPa.length() == 7){
			paRetorno = variarMesaComZ(mesa, posicao, lado, mapa);
		}
		
		return paRetorno;
	}
	
	private OmPa encontrarCdPaNoMapaDoPt(String cdPa, OmMapa mapa){
		if(mapa != null && mapa.getOmMapapas() != null){
			for(OmMapapa mapapa : mapa.getOmMapapas()){
				OmPa posicaoNoMapa = mapapa.getOmPa();
				if(posicaoNoMapa.getCdPa().contains(cdPa)){
					return posicaoNoMapa;
				}
				if(posicaoNoMapa.getDepara().contains(cdPa)){
					return posicaoNoMapa;
				}
			}
		}
		return null;
	}

	private OmPa variarMesaComZ(String mesa, String posicao, String lado, OmMapa mapa){
		
		OmPa retorno = null;
		int numMesa = getNumMesa(mesa);
		
		String mauxiliar = mesa + posicao;
		if(lado != null){
			mauxiliar += lado;
		}
		
//		System.out.println("formatações ("+mauxiliar+") :\n");
		if(mauxiliar.length() == 5){
			retorno = variarCdPa(numMesa, mesa, posicao, lado, null, mapa, null);
			if(retorno != null){
				return retorno;
			}
			retorno = variarCdPa(numMesa, mesa, posicao, lado, null, mapa, false);
			if(retorno != null){
				return retorno;
			}
		}else{
			if(lado.equals("L")){
				retorno = variarCdPa(numMesa, mesa, posicao, lado, null, mapa, null);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "1", mapa, true);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "1", mapa, false);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "L", mapa, false);
				if(retorno != null){
					return retorno;
				}
			}else if(lado.equals("0")){
				retorno = variarCdPa(numMesa, mesa, posicao, lado, null, mapa, null);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "1", mapa, true);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "L", mapa, true);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "0", mapa, false);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "1", mapa, false);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "L", mapa, false);
			}else if(lado.equals("1")){
				retorno = variarCdPa(numMesa, mesa, posicao, lado, null, mapa, null);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "L", mapa, true);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "1", mapa, false);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "L", mapa, false);
			}else if(lado.equals("2")){
				retorno = variarCdPa(numMesa, mesa, posicao, lado, null, mapa, null);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "R", mapa, true);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "2", mapa, false);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "R", mapa, false);
			}else if(lado.equals("R")){
				retorno = variarCdPa(numMesa, mesa, posicao, lado, null, mapa, null);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "2", mapa, true);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "R", mapa, false);
				if(retorno != null){
					return retorno;
				}
				retorno = variarCdPa(numMesa, mesa, posicao, lado, "2", mapa, false);
			}
		}

		return retorno;
	}

	private OmPa variarCdPa(int numMesa, String mesa, String posicao, String lado, String ladoAux, OmMapa mapa, Boolean isMesaComZ){
		//Z50 006 L
		OmPa retorno = null;
		int numAux = numMesa;
		
		int tamanhoCdOriginal = mesa.length() + posicao.length();
		if(lado != null){
			tamanhoCdOriginal = tamanhoCdOriginal + 1;
		}
		
		if(isMesaComZ == null){
			for(int i = 0 ; i < 4 ; i++){
				if(mesa.contains("Z")){
					String mesaVariando;
					
					if(isMesaComZ == null){
						mesaVariando = formatarMesaComZ(numMesa);
					}else if(isMesaComZ){
						mesaVariando = formatarMesaComZ(numMesa);
					}else{
						mesaVariando = formatarMesaSemZ(numMesa);
					}
					
					String mesaAux = mesaVariando + posicao;
					if(isMesaComZ == null || isMesaComZ){
						if(lado != null){
							mesaAux += lado;
						}
					}
					if(ladoAux != null){
						mesaAux = StringUtils.left(mesaAux, mesaAux.length() - 1) + ladoAux;
					}
					
//					System.out.println(mesaAux);
					retorno = encontrarCdPaNoMapaDoPt(mesaAux, mapa);
					if(retorno != null){
						return retorno;
					}
				}
				numMesa = numMesa + 4;
			}
//			System.out.println();
		}else if(isMesaComZ){
			mesa = formatarMesaComZ(numAux);
			for(int i = 0 ; i < 4 ; i++){
				if(mesa.contains("Z")){
					String mesaVariando;
					if(isMesaComZ == null || isMesaComZ){
						mesaVariando = formatarMesaComZ(numMesa);
					}else{
						mesaVariando = formatarMesaSemZ(numMesa);
					}
					
					String mesaAux = mesaVariando + posicao;
					if(isMesaComZ == null || isMesaComZ){
						mesaAux += lado;
					}
					if(ladoAux != null){
						mesaAux = StringUtils.left(mesaAux, mesaAux.length() - 1) + ladoAux;
					}
					
//					System.out.println(mesaAux);
					retorno = encontrarCdPaNoMapaDoPt(mesaAux, mapa);
					if(retorno != null){
						return retorno;
					}
				}
				numMesa = numMesa + 4;
			}
//			System.out.println();
		}else{
			mesa = formatarMesaSemZ(numAux);
			for(int i = 0 ; i < 4 ; i++){
				if(!mesa.contains("Z")){
					String mesaVariando;
					if(isMesaComZ == null || isMesaComZ){
						mesaVariando = formatarMesaComZ(numMesa);
					}else{
						mesaVariando = formatarMesaSemZ(numMesa);
					}
					
					String mesaAux = mesaVariando + posicao;
					if(isMesaComZ == false && ladoAux != null){
						mesaAux += ladoAux;
					}
					
//					System.out.println(mesaAux);
					retorno = encontrarCdPaNoMapaDoPt(mesaAux, mapa);
					if(retorno != null){
						return retorno;
					}
				}
				numMesa = numMesa + 4;
			}
//			System.out.println();
		}

		return retorno;
	}
	
	private String formatarMesaComZ(int numMesa){
		return "Z" + numMesa;
	}
	
	private String formatarMesaSemZ(int numMesa){
		return numMesa + "0";
	}
	
	private int getNumMesa(String mesa){
		int numMesa;
		if(mesa.length() <= 2 ){
			if(mesa.contains("Z")){
				numMesa = Integer.parseInt(StringUtils.substring(mesa, 1, 2));
			}else{
				numMesa = Integer.parseInt(StringUtils.left(mesa, 2));
			}
		}else{
			if(mesa.contains("Z")){
				numMesa = Integer.parseInt(StringUtils.substring(mesa, 1, 3));
			}else{
				numMesa = Integer.parseInt(StringUtils.left(mesa, 3));
			}
		}
		return numMesa;
	}

//	private OmMapa criarMapaTeste(){
//		OmMapa mapa = new OmMapa();
//
//		OmMapapa mapapa1 = new OmMapapa();
//		OmPa pa1 = new OmPa();
//		pa1.setCdPa("Z7055");
//		pa1.setDepara("70055");
//		mapapa1.setOmPa(pa1);
//		
//		OmMapapa mapapa2 = new OmMapapa();
//		OmPa pa2 = new OmPa();
//		pa2.setCdPa("Z10046");
//		pa2.setDepara("100046");
//		mapapa2.setOmPa(pa2);
//		
////		OmMapapa mapapa3 = new OmMapapa();
////		OmPa pa3 = new OmPa();
////		pa3.setCdPa("Z200131");
////		pa3.setDepara("10057");
////		mapapa3.setOmPa(pa3);
////		
////		OmMapapa mapapa4 = new OmMapapa();
////		OmPa pa4 = new OmPa();
////		pa4.setCdPa("100092");
////		pa4.setDepara("100092");
////		mapapa4.setOmPa(pa4);
////		
////		OmMapapa mapapa5 = new OmMapapa();
////		OmPa pa5 = new OmPa();
////		pa5.setCdPa("100201");
////		pa5.setDepara("100201");
////		mapapa5.setOmPa(pa5);
////		
////		OmMapapa mapapa6 = new OmMapapa();
////		OmPa pa6 = new OmPa();
////		pa6.setCdPa("Z80121");
////		pa6.setDepara("800121");
////		mapapa6.setOmPa(pa6);
////		
////		OmMapapa mapapa7 = new OmMapapa();
////		OmPa pa7 = new OmPa();
////		pa7.setCdPa("800120");
////		pa7.setDepara("800120");
////		mapapa7.setOmPa(pa7);
////		
////		OmMapapa mapapa8 = new OmMapapa();
////		OmPa pa8 = new OmPa();
////		pa8.setCdPa("Z2051");
////		pa8.setDepara("20051");
////		mapapa8.setOmPa(pa8);
//		
//		OmMapapa mapapa9 = new OmMapapa();
//		OmPa pa9 = new OmPa();
//		pa9.setCdPa("Z5006L");
//		pa9.setDepara("500061");
//		mapapa9.setOmPa(pa9);
//		
////		OmMapapa mapapa10 = new OmMapapa();
////		OmPa pa10 = new OmPa();
////		pa10.setCdPa("Z5012L");
////		pa10.setDepara("500122");
////		mapapa10.setOmPa(pa10);
//
//		Set<OmMapapa> mapapas = new HashSet<OmMapapa>(0);
//		mapapas.add(mapapa1);
//		mapapas.add(mapapa2);
////		mapapas.add(mapapa3);
////		mapapas.add(mapapa4);
////		mapapas.add(mapapa5);
////		mapapas.add(mapapa6);
////		mapapas.add(mapapa7);
////		mapapas.add(mapapa8);
//		mapapas.add(mapapa9);
////		mapapas.add(mapapa10);
//		
//		mapa.setOmMapapas(mapapas);
//		return mapa;
//	}
//	
//	public static void main(String[] args) {
//		String cd = "Z50006L"; //30006, Z4007, Z402031, Z4012L, 40008, Z3024
//		ConsultaCdPaComFormatacoes f = new ConsultaCdPaComFormatacoes();
//		System.out.println("codigo: "+cd);
//		OmMapa mapa = f.criarMapaTeste();
//		OmPa pa = f.getOmPa(cd, mapa);
//		if(pa != null){
//			System.out.println("pa encontrado: "+pa.getCdPa());
//		}else{
//			System.out.println("\npa n�o encontrado!");
//		}
//	}
	
}