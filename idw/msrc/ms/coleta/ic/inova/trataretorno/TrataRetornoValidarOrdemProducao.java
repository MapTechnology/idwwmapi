package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.ic.inova.dto.INovaUpDTO;
import ms.util.UtilsThreads;

public class TrataRetornoValidarOrdemProducao extends TrataRetorno {

	public TrataRetornoValidarOrdemProducao() {
	}
	
	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		String idup = this.ic.icupdto.getIdUP();
		
		IwsCpDTO cpEntrada = pegadadosCp(this.ic.icupdto, this.ic.icDadosRecebidos);
		if(Stubdelegate.getInstancia().validaPlanejamento(this.ic.icupdto, cpEntrada, parametro.getDataHoraEvento())) {
			//se o módulo de apontamento estiver desativado, verifica se integração Doal está ativa
			//do contrário, valida op, faz setprupcoletor e aciona andon processoft
			if(this.ic.icupdto.getCpTemp().getIsApntSAPAtivo() == null) {
				this.ic.icupdto.setIsApntSapAtivo(null);
				this.ic.icupdto.getDadosCIP().setIsEmCIP(false);
				
				//se integração Doal está ativa, pergunta informações necessárias no Coletor
				if(!this.ic.icupdto.isStIntegracaoDoal()) {
					
					this.ic.icupdto.setIsSemPrograma(false);
					this.ic.icupdto.setCp(this.ic.icupdto.getCpTemp());
					this.ic.icupdto.setStAlimIntegracaoDoal(true);
					
					this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
					this.ic.enviaSetPrUpColetor(this.ic.icupdto);
					
					UtilsThreads.pausaNaThread(100);
					
					// TODO: ANDON PROCESSOFT - a fazer
//					if(isAndonPrcsftAtivo) {
//						oUpAndonPrcsftDTO = Stubdelegate.getInstancia().setTr_getPrUpAndonPrcsft(lcupdto.idUP);
//						if (oUpAndonPrcsftDTO != null)
//						{
//							if (oUpAndonPrcsftDTO.stRele7SldZero != null)
//							{											
//								setSaida("8", "0", "0", oUpAndonPrcsftDTO.tmpRele7LigSldZero.ToString(), oUpAndonPrcsftDTO.tmpRele7DesSldZero.ToString());
//							}
//							setSaida("6", oUpAndonPrcsftDTO.stRele6, "0", oUpAndonPrcsftDTO.tmpRele6Lig.ToString(), oUpAndonPrcsftDTO.tmpRele6Des.ToString());
//							setSaida("5", oUpAndonPrcsftDTO.stRele7, "0", oUpAndonPrcsftDTO.tmpRele7Lig.ToString(), oUpAndonPrcsftDTO.tmpRele7Des.ToString());
//							setSaida("4", oUpAndonPrcsftDTO.stRele8, "1", oUpAndonPrcsftDTO.tmpRele8Lig.ToString(), oUpAndonPrcsftDTO.tmpRele8Des.ToString());
//							
//							//transformando valor para inteiro, com precisao de 2 casas decimais, para enviar ao coletor
//							int iTmpLimParNaoInf = Int16.Parse(Math.Truncate((oUpAndonPrcsftDTO.tmpLimParNaoInf * 100.0)).ToString());
//							int iVlRefEficUltCiclo = Int16.Parse(Math.Truncate((oUpAndonPrcsftDTO.vlRefEficUltCiclo * 100.0)).ToString());
//							setDado(lcupdto.idSubColetor, "1", iTmpLimParNaoInf.ToString());
//							setDado(lcupdto.idSubColetor, "2", iVlRefEficUltCiclo.ToString());
//						}
//					}
				}
				else {
					this.ic.icupdto.setStAlimIntegracaoDoal(false);
					this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
					this.ic.atualizaListaMatPrima(idup, Stubdelegate.getInstancia().buscaListaMateriaPrima(idup, this.ic.icupdto, parametro.getDataHoraEvento()));
					this.ic.resetaContagemMatPrima(idup);
					
					//listaMateriaPrima = Stubdelegate.getInstancia().buscaListaMateriaPrima(idup);
				}
				
				//responde para o coletor que não é necessário fazer a pergunta de apontamento
				Comando = "RESP;2;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;0;";
				
				//se integração Doal estiver ativa, pergunta no coletor
				//do contrário, não faz pergunta
				if(this.ic.icupdto.isStIntegracaoDoal() && this.ic.listaMateriaPrimaUps != null &&
						this.ic.listaMateriaPrimaUps.size() > 0)
				{
					
					IwsProdMateriaPrimaDTO prima = this.ic.buscaUltimaMatPrimaUsada(idup);
					Comando += "1;";
					
					if(prima != null) {
						Comando += prima.getDsProduto() + ";";
						Comando += prima.getDsMateriaPrima() + ";";
						Comando += prima.getUnidade() + ";";
					}
					else
						Comando += "NULL;NULL;NULL;";
					
					//insere o controle de solicatação de lote
					if(prima.getControlalote())
						Comando += "1;";
					else
						Comando += "0;";
					
					this.ic.icupdto.setMatPrimaEnviada(new IwsProdMateriaPrimaDTO());
					this.ic.icupdto.getMatPrimaEnviada().setCdProduto(prima.getCdProduto());
					this.ic.icupdto.getMatPrimaEnviada().setCdMateriaPrima(prima.getCdMateriaPrima());
					this.ic.icupdto.getMatPrimaEnviada().setControlalote(prima.getControlalote());
					this.ic.icupdto.setVisualizaTelaIntegDOal(true);
					
					this.ic.enviaSetPrUpColetor(this.ic.icupdto);
					this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
				}
				else if(this.ic.icupdto.isStIntegracaoDoal() && (this.ic.listaMateriaPrimaUps == null ||
						this.ic.listaMateriaPrimaUps.size() == 0 ) )
				{
					Comando += "0; ; ; ; ; ; ;";
					
					this.ic.icupdto.setIsSemPrograma(false);
					this.ic.icupdto.setCp(this.ic.icupdto.getCpTemp());
					this.ic.icupdto.setVisualizaTelaIntegDOal(false);
					this.ic.icupdto.setStAlimIntegracaoDoal(true);
					
					this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
					this.ic.enviaSetPrUpColetor(this.ic.icupdto);
					
					UtilsThreads.pausaNaThread(100);
					
					// TODO: ANDON PROCESSOFT - a fazer
//					if(isAndonPrcsftAtivo) {
//						oUpAndonPrcsftDTO = Stubdelegate.getInstancia().setTr_getPrUpAndonPrcsft(lcupdto.idUP);
//						if (oUpAndonPrcsftDTO != null)
//						{
//							if (oUpAndonPrcsftDTO.stRele7SldZero != null)
//							{										   
//								setSaida("8","0", "0", oUpAndonPrcsftDTO.tmpRele7LigSldZero.ToString(), oUpAndonPrcsftDTO.tmpRele7DesSldZero.ToString());
//							}
//							setSaida("6", oUpAndonPrcsftDTO.stRele6, "0", oUpAndonPrcsftDTO.tmpRele6Lig.ToString(), oUpAndonPrcsftDTO.tmpRele6Des.ToString());
//							setSaida("5", oUpAndonPrcsftDTO.stRele7, "0", oUpAndonPrcsftDTO.tmpRele7Lig.ToString(), oUpAndonPrcsftDTO.tmpRele7Des.ToString());
//							setSaida("4", oUpAndonPrcsftDTO.stRele8, "1", oUpAndonPrcsftDTO.tmpRele8Lig.ToString(), oUpAndonPrcsftDTO.tmpRele8Des.ToString());
//							
//							//transformando valor para inteiro, com precisao de 2 casas decimais, para enviar ao coletor
//							int iTmpLimParNaoInf = Int16.Parse(Math.Truncate((oUpAndonPrcsftDTO.tmpLimParNaoInf * 100.0)).ToString());
//						   // int iVlRefEficUltCiclo = Int16.Parse(Math.Truncate((oUpAndonPrcsftDTO.vlRefEficUltCiclo * 100.0)).ToString());
//							setDado(lcupdto.idSubColetor, "1", iTmpLimParNaoInf.ToString());
//						   // setDado(lcupdto.idSubColetor, "2", iVlRefEficUltCiclo.ToString());
//						}
//					}
					
					Stubdelegate.getInstancia().geraLogIntegracaoDoal(idup, parametro.getDataHoraEvento(),
					"INTEGRACAO DOAL ATIVA, PRODUTO DA OP NÃO POSSUI MATÉRIA PRIMA CADASTRADA", false);
				}
				else if(!this.ic.icupdto.isStIntegracaoDoal())
					Comando += "0; ; ; ; ; ; ;";
				//dado1 - Apnt SAP desativado.
				//dado2 - Sinaliza integração doal ativa
				//dado3 - produto
				//dado4 - materia-prima
				//dado5 - unidade
				//dado6 - solicita lote: true- solicita lote; false- não colicita
				
			}
			else {
				//se o módulo de apontamento estiver ativado, aguarda status do apontamento (apnt = 1 ou apnt = 0)
				this.ic.icupdto.setIsSemPrograma(true);
				this.ic.icupdto.setIsApntSapAtivo(this.ic.icupdto.getCpTemp().getIsApntSAPAtivo());
			}
			
			if(this.ic.icupdto.getIsApntSapAtivo() != null && this.ic.icupdto.getIsApntSapAtivo().equals("1")) {
				//se apontamentamento estiver ativo e a OP estiver apontando, faz pergunta de estado no coletor
				Comando = "RESP;2;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;1; ; ; ; ; ; ; ; ;";
				//dado1 - Apnt SAP ativado, perguntar do operador se aponta ou não.
			}
			else if(this.ic.icupdto.getIsApntSapAtivo() != null && this.ic.icupdto.getIsApntSapAtivo().equals("0")) {
				//se apontamentamento estiver ativo e a OP não estiver apontando, não faz pergunta de estado no coletor
				//valida OP, faz setprupcoletor e aciona andon processoft
				this.ic.icupdto.setIsApntSapAtivo("0");
				this.ic.icupdto.setIsSemPrograma(false);
				this.ic.icupdto.setCp(this.ic.icupdto.getCpTemp());
				
				this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
				this.ic.enviaSetPrUpColetor(this.ic.icupdto);
				
				UtilsThreads.pausaNaThread(100);
				
				// TODO: ANDON PROCESSOFT - a fazer
//				if(isAndonPrcsftAtivo) {
//					oUpAndonPrcsftDTO = Stubdelegate.getInstancia().setTr_getPrUpAndonPrcsft(lcupdto.idUP);
//					if (oUpAndonPrcsftDTO != null)
//					{
//						if (oUpAndonPrcsftDTO.stRele7SldZero != null)
//						{
//						   setSaida("8", "0", "0", oUpAndonPrcsftDTO.tmpRele7LigSldZero.ToString(), oUpAndonPrcsftDTO.tmpRele7DesSldZero.ToString());
//						}
//						setSaida("6", oUpAndonPrcsftDTO.stRele6, "0", oUpAndonPrcsftDTO.tmpRele6Lig.ToString(), oUpAndonPrcsftDTO.tmpRele6Des.ToString());
//						setSaida("5", oUpAndonPrcsftDTO.stRele7, "0", oUpAndonPrcsftDTO.tmpRele7Lig.ToString(), oUpAndonPrcsftDTO.tmpRele7Des.ToString());
//						setSaida("4", oUpAndonPrcsftDTO.stRele8, "1", oUpAndonPrcsftDTO.tmpRele8Lig.ToString(), oUpAndonPrcsftDTO.tmpRele8Des.ToString());
//						
//						//transformando valor para inteiro, com precisao de 2 casas decimais, para enviar ao coletor
//						int iTmpLimParNaoInf = Int16.Parse(Math.Truncate((oUpAndonPrcsftDTO.tmpLimParNaoInf * 100.0)).ToString());
//						int iVlRefEficUltCiclo = Int16.Parse(Math.Truncate((oUpAndonPrcsftDTO.vlRefEficUltCiclo * 100.0)).ToString());
//						setDado(lcupdto.idSubColetor, "1", iTmpLimParNaoInf.ToString());
//						setDado(lcupdto.idSubColetor, "2", iVlRefEficUltCiclo.ToString());
//					}
//				}
				
				Comando = "RESP;2;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;0; ; ; ; ; ; ;";
				//dado1 - Apnt SAP desativado.
			}
		}
		else {
			List<String> lines = this.ic.verificaTxtMensagem(this.ic.icupdto.getTxtMsg());
			Comando = "RESP;2;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
			if (lines.size() >= 1) Comando += lines.get(0) + ";";
			else Comando += " ;";
			if (lines.size() >= 2) Comando += lines.get(1) + ";";
			else Comando += " ;";
			if (lines.size() >= 3) Comando += lines.get(2) + ";";
			else Comando += " ;";
			if (lines.size() >= 4) Comando += lines.get(3) + ";";
			else Comando += " ;";
			Comando += " ; ; ; ; ; ;";
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}
	
	private IwsCpDTO pegadadosCp(INovaUpDTO lcupdto, String[] DadosRecebidos) {
		// TODO Alessandre abaixo iniciei retorno com uma instancia do objeto ao inves de null
		IwsCpDTO retorno = new IwsCpDTO();
		retorno.setStCriacaoCP(lcupdto.getStCriacaoCP().toString());
		
		switch(lcupdto.getStCriacaoCP()) {
			case 1:
				retorno.setCdmolde(DadosRecebidos[10]);
				break;
			case 2:
				retorno.setNrop(DadosRecebidos[10]);
				break;
			case 3:
				retorno.setCdProduto(DadosRecebidos[10]);
				break;
			case 4:
				retorno.setCdmolde(DadosRecebidos[10]);
				retorno.setCdestrutura(DadosRecebidos[11]);
				retorno.setQtciclos(DadosRecebidos[12]);
				break;
			case 5:
				retorno.setCdProduto(DadosRecebidos[10]);
				retorno.setCdestrutura(DadosRecebidos[11]);
				retorno.setProducaoPlanejada(DadosRecebidos[12]);
				break;
			case 6:
				retorno.setCdProduto(DadosRecebidos[10]);
				break;
			case 7:
				retorno.setCdProduto(DadosRecebidos[10]);
				retorno.setProducaoPlanejada(DadosRecebidos[11]);
				break;
			case 8:
				retorno.setCdmolde(DadosRecebidos[10]);
				retorno.setCdProduto(DadosRecebidos[11]);
				retorno.setQtciclos(DadosRecebidos[12]);
				break;
			case 9:
				retorno.setCdProduto(DadosRecebidos[10]);
				retorno.setCdmolde(DadosRecebidos[11]);
				retorno.setQtcartoes(DadosRecebidos[12]);
				break;
			default:
				break;
		}
		
		return(retorno);
	}
	
}
