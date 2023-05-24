package idw.model.rn.algoritmos.monitorizacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwRt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmIndpt;
import idw.model.pojos.OmIndtppt;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.monitorizacao.MonitorizacaoRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetRN;
import idw.model.rn.monitorizacao.injet.MonitorizacaoInjetV2RN;
import idw.util.IdwLogger;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.injet.RtFolhaDTO;

public class AlgoritmoMonitorizacaoTemperatura implements IAlgoritmo
{
	
	private Double eficienciaCiclomedio = 0d;
	private Double eficienciaUltimoCiclo = 0d;
	private Double eficienciaRealizacao = 0d;
	private Double indice_parada = null;
	private Double indice_refugo = null;
	private Double indice_acur = null;
	private Double indice_OEE = null;
	private Double indice_producao = null;
	private List<DwConsolid> listadwConsolid = null;
	private DwRt dwRt = null;
	private MonitorizacaoRN rn = null;
	
	@SuppressWarnings("static-access")
	@Override
	public void executar(IdwLogger log, ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, DwRt dwRt, OmCfg omCfg, MonitorizacaoRN rn, boolean isTurnoAtual, Integer filtroOp) {

		this.dwRt = dwRt;
		this.rn = rn;
		
		//Verifica se existe operadores logados
		objRtDTOItem.setTemOperador((dwRt.getIsOperador() != null) && dwRt.getIsOperador().booleanValue());

		//setar os valores do Turno
		objRtDTOItem.setCdTurno(dwRt.getDwTurno().getCdTurno());
		objRtDTOItem.setDsTurno(dwRt.getDwTurno().getDsTurno());
		objRtDTOItem.setIdTurno(dwRt.getDwTurno().getIdTurno());
		
		
		//setar o tipo do algoritmo
		objRtDTOItem.setTipoAlgoritmo(objRtDTOItem.ALG_TEMPERATURA);
		
		PTRN ptrn = new PTRN(rn.getDao());
		OmPt ompt = ptrn.pesquisarPtByCdPtStAtivo(objRtDTOItem.getCdPt());

		//verifica se o item possui configuracao
		//se tiver trata o item, senao retorna;
		if(objRtDTOItem.isTemOmCfg()){
			
			if(objRtDTOItem.isTemDwRt() && dwRt.getIsOffline() != null && dwRt.getIsOffline() == false){
				listadwConsolid = buscarDwConsolid(ompt);
				setarValores(log);
				setarValoresNoObjeto(objRtDTOItem);
				setarFlags(objRtDTOItem , omCfg, ompt);	
				
				if (listadwConsolid.isEmpty() == false) {
					objRtDTOItem.setCdCp(listadwConsolid.get(0).getPpCp().getCdCp());
					objRtDTOItem.setIdCp(listadwConsolid.get(0).getPpCp().getIdCp());
					objRtDTOItem.setCdProduto(listadwConsolid.get(0).getPpCp().getPpCpprodutos().iterator().next().getOmProduto().getCdProduto());
					
					// recuperar informa��es relativas a temperatura
					ObjRtMonitorizacaoDTO objTemp = this.rn.getInfoTemperatura(listadwConsolid.get(0));
					
					if (objTemp != null) {
						objRtDTOItem.setUltimaTemperaturaLida(objTemp.getUltimaTemperaturaLida());
						objRtDTOItem.setTemperaturaZonaCritInf(objTemp.isTemperaturaZonaCritInf());
						objRtDTOItem.setTemperaturaZonaActInf(objTemp.isTemperaturaZonaActInf());
						objRtDTOItem.setTemperaturaZonaIdeal(objTemp.isTemperaturaZonaIdeal());
						objRtDTOItem.setTemperaturaZonaActSup(objTemp.isTemperaturaZonaActSup());
						objRtDTOItem.setTemperaturaZonaCritSup(objTemp.isTemperaturaZonaCritSup());
					}
					
					if (dwRt.getUlttemperaturalida() != null)
						objRtDTOItem.setUltimaTemperaturaLida(dwRt.getUlttemperaturalida().doubleValue());
					else
						objRtDTOItem.setUltimaTemperaturaLida(0d);
					
					
				} else {
					objRtDTOItem.setCdCp("");
					objRtDTOItem.setCdProduto("");
				}
				
				if(objRtDTOItem.isTemPlanejamento() == false){
					setarValoresSemMolde(objRtDTOItem, dwRt);
					objRtDTOItem.setTemPlanejamento(true); //remover o fundo azul do icone
				}
				
				
		    }
		}else{
			objRtDTOItem.setOffline(true);
			objRtDTOItem.setParada(true);
		}
		
	}
	
	private List<DwConsolid> buscarDwConsolid(OmPt ompt){
		List<DwConsolid> retorno = new ArrayList<DwConsolid>();
		
		if (dwRt.getPpCp() != null)
			retorno = rn.getDwConsolidPorDt(ompt, dwRt.getPpCp(),  dwRt.getDtReferencia(), dwRt.getDwTurno());
		
		return retorno; 
	}
	
	private void setarValoresSemMolde(ObjRtMonitorizacaoDTO objRtDTOItem,DwRt dwRt){
		if (dwRt.getDwConsolpalog() != null){
			
			if (dwRt.getDwConsolpalog().getDwTParada() != null){
				objRtDTOItem.setUltimaParada(dwRt.getDwConsolpalog().getDwTParada().getCd());
			}else{
				objRtDTOItem.setUltimaParada("");
			}
			objRtDTOItem.setIniParada(dwRt.getDwConsolpalog().getDthrIparada());
			objRtDTOItem.setFimParada(dwRt.getDwConsolpalog().getDthrFparada());	
			
			if ( objRtDTOItem.getIniParada() != null && objRtDTOItem.getFimParada() != null){
				objRtDTOItem.setDuracaoParada(diferencaEmHoras(objRtDTOItem.getIniParada(), objRtDTOItem.getFimParada()));
			}
		}else{
			objRtDTOItem.setUltimaParada(null);
			objRtDTOItem.setIniParada(null);
			objRtDTOItem.setFimParada(null);
			objRtDTOItem.setDuracaoParada(null);
		}
		
		if (listadwConsolid != null && listadwConsolid.isEmpty() == false){
				
			    if (listadwConsolid.get(0).getPpCp() != null){
			    	if (listadwConsolid.get(0).getPpCp().getPpCpprodutos()!= null){
			    		for(PpCpproduto ppCpProduto : listadwConsolid.get(0).getPpCp().getPpCpprodutos()){
			    			objRtDTOItem.setUltimaOp(ppCpProduto.getNrDoc());
			    			break;
			    		}
			    	}
			    	
			        //FIXME: necess�rio identificar de algum modo a folha que est� em uso; provavelmente incluir id_folha em dw_rt. No momento a propriedade UltimoMolde de objRtDTOItem n�o est� sendo usada. 
			        if (listadwConsolid.get(0).getDwFolha() != null){
			    	   if (listadwConsolid.get(0).getDwFolha().getDwFolharaps() != null){
			    		   for(DwFolharap dwFolhaRap : listadwConsolid.get(0).getDwFolha().getDwFolharaps()){
			    			   if (dwFolhaRap.getDwRap() != null){
			    				   objRtDTOItem.setUltimoMolde( dwFolhaRap.getDwRap().getCdRap());
			    			       break;
			    			   }
			    		   }
			    	   }
			       }
			    	
			    }
			    
		}else{
			objRtDTOItem.setUltimaOp("");
			objRtDTOItem.setUltimoMolde("");
		}
		
		
	}
	
	private void setarFlags(ObjRtMonitorizacaoDTO objRtDTOItem, OmCfg omCfg, OmPt ompt){
		
		long diffTime = 0;
		//capturando tempo entre a data de referencia e a data do heartbeat	(diffTime)
		if (dwRt.getDthrHeartbeat() != null && objRtDTOItem.getDtReferencia() != null) {
			diffTime = DataHoraRN.getQuantidadeSegundosNoPeriodo(dwRt.getDthrHeartbeat(), objRtDTOItem.getDtReferencia());
		}

		//se diffTime for maior que 60, entao item esta offline.
		objRtDTOItem.setOffline(diffTime > 60);
		
		boolean rtOffline = dwRt.getIsOffline() == null ? true : dwRt.getIsOffline();
		
		if(objRtDTOItem.isOffline() != rtOffline){
			//atualizar dwrt.offline
			dwRt.setIsOffline(objRtDTOItem.isOffline());
		}
		
		
		//Verificando se a maquina esta dentro da meta
		objRtDTOItem.setDentroDaMeta(isMaquinaDentroDaMeta(objRtDTOItem, dwRt, omCfg));	
		
		
		//verifica 	flag de maq. parada
		objRtDTOItem.setParada(dwRt.getStFuncionamento()!= null && dwRt.getStFuncionamento().equals( (byte) 0));
		
		
		//Verifica se parada � parada de manutencao
		objRtDTOItem.setParadaManutencao(false);
		
		//verifica se � parada com peso
	    objRtDTOItem.setParadaComPeso(false);
	    
	    //verifica se maq. esta sem Molde
	    objRtDTOItem.setTemPlanejamento( ! ((dwRt.getIsSemplanejamento() != null) && (dwRt.getIsSemplanejamento())) );
	    objRtDTOItem.setComAlerta(false);
	    
    	//Op estara concluida se Producao Planejada for igual a producao liquida
    	objRtDTOItem.setOpConcluida(false);
    	objRtDTOItem.setOpConcluida90PorCento(false);

	}
	
	/**
	 * M�quina est� dentro da meta quando  n�o satisfaz as seguintes condi��es:
	 * 1 - Efici�ncia de ciclo m�dio, esta fora de faixa;
	 * 2 - Efici�ncia do �ltmio Ciclo esta fora de faixa;
	 * 3 - �ndice de refugo acima da faixa;
	 * 4 - Efici�ncia de realiza��o fora de faixa 
	 */
	private boolean isMaquinaDentroDaMeta(ObjRtMonitorizacaoDTO objRtDTOItem, DwRt dwRt, OmCfg omCfg){
		
		/*if (cicloMedio == null || cicloPadrao == 0 || ultimoCiclo == 0 || prod_liq == null || prod_Prevista == null || indice_refugo == null){
			return false;
		}*/

		
		/**
			 * Eficiencia de ciclo medio, calculada usando uma regra de 3 simples e direta, 
			 * onde ciclo padrao esta para 100 assim como ciclo medio esta para x
		*/
			
			//TODO verificar indice dentro do  OmPt  
			if(dwRt.getOmPt().getOmIndpts() != null){
				for (OmIndpt indPt : dwRt.getOmPt().getOmIndpts()){
					
					//testa EficienciaRealizacao 
					if(indPt.getIdIndpt() == 1){
						
						if (indPt.getIndMeta() == null ||  indPt.getIndMeta().longValue()  > eficienciaRealizacao ){
							return false;
						}
						
					}
					
					//testa EficienciaCiclomedio 
					if(indPt.getIdIndpt() == 2){
						
						if (indPt.getIndMeta() == null ||  indPt.getIndMeta().longValue()  > eficienciaCiclomedio ){
							return false;
						}
						
						if (indPt.getIndMeta() == null ||  indPt.getIndMeta().longValue()  > eficienciaUltimoCiclo ){
							return false;
						}
					}
					
				}
			}
			
			//TODO verificar indice dentro do OmTppt
			if(dwRt.getOmPt().getOmTppt().getOmIndtppts() != null){
				for (OmIndtppt indTppt : dwRt.getOmPt().getOmTppt().getOmIndtppts()){
					//testa EficienciaCiclomedio 
					if(indTppt.getIdIndtppt() == 1){
						
						if (indTppt.getNumMeta() == null ||  indTppt.getNumMeta().longValue()  > eficienciaCiclomedio ){
							return false;
						}
					}
					
					//testa EficienciaUltimoCiclo 
					if(indTppt.getIdIndtppt() == 2){
						
						if (indTppt.getNumMeta() == null ||  indTppt.getNumMeta().longValue()  > eficienciaUltimoCiclo ){
							return false;
						}
						
						if (indTppt.getNumMeta() == null ||  indTppt.getNumMeta().longValue()  > eficienciaRealizacao ){
							return false;
						}
					}
					
				
				}	
			}
			
			if (omCfg.getOmCfginds() != null){
				for(OmCfgind omCfgInd :omCfg.getOmCfginds()){
					if (omCfgInd.getIdCfgind() == 1){
						if (omCfgInd.getIndMeta().longValue() > eficienciaRealizacao){
							return false;
						}
					}
					
                    if (omCfgInd.getIdCfgind() == 2){
                    	if (omCfgInd.getIndMeta().longValue() > eficienciaCiclomedio){
							return false;
						}
                    	
                    	if (omCfgInd.getIndMeta().longValue() > eficienciaUltimoCiclo){
							return false;
						}
					}
                    
                    
				}
			}
		return true;
	}
	
	
	/*
	 * Inicializar Valores que ser�o utilizados em todo o Algoritmo
	 */
	private void setarValores(IdwLogger log) {
	}
	
	private void setarValoresNoObjeto(ObjRtMonitorizacaoDTO objRtDTOItem){
		if (eficienciaRealizacao != null)
			objRtDTOItem.setEfiRealizacao(eficienciaRealizacao.doubleValue());
		
		if (eficienciaCiclomedio != null)
			objRtDTOItem.setEfiCiclos(eficienciaCiclomedio.doubleValue());
		
		if (indice_refugo != null)
			objRtDTOItem.setIndiceRefugos(indice_refugo.doubleValue());
		
		if (indice_producao != null)
			objRtDTOItem.setIndiceProducao(indice_producao.doubleValue());
		if (indice_parada != null)
			objRtDTOItem.setIndiceParadas(indice_parada.doubleValue());
		if (indice_OEE != null)
			objRtDTOItem.setProdutividadeOEE(indice_OEE.doubleValue());
		if (indice_acur != null)
			objRtDTOItem.setIndiceCavAtivas(indice_acur.doubleValue());
		if (eficienciaUltimoCiclo != null)
			objRtDTOItem.setEfiInstantanea(eficienciaUltimoCiclo.doubleValue());		
	}
	
	
	private String diferencaEmHoras(Date dataInicial, Date dataFinal){  
        StringBuilder data = new StringBuilder();
	      
        long diferenca = dataFinal.getTime() - dataInicial.getTime();  
        long diferencaEmHoras = (diferenca /1000) / 60 / 60;  
        long minutosRestantes = (diferenca / 1000)/60 %60;  
        long segundosRestantes = (diferenca / 1000) % (60);  
         
        
        data.append(diferencaEmHoras < 10 ? "0" + diferencaEmHoras + ":" : diferencaEmHoras  + ":" ); 	        
        data.append(minutosRestantes < 10 ? "0" + minutosRestantes + ":" : minutosRestantes + ":"  );
        data.append(segundosRestantes < 10 ? "0" + segundosRestantes  : segundosRestantes   );
        
        return data.toString();  
    }  

	//Marcos Sardinha: VFWEB - Injet
	public void executar(
			IdwLogger log, 
			ObjRtMonitorizacaoDTO retorno, 
			DwConsolidTemplate.TpId tpId, 
			RtFolhaDTO rtf, 
			OmCfg omCfg, 
			MonitorizacaoInjetRN rn, 
			boolean isTurnoAtual, 
			Integer filtroOp) {

	}
	
	//WEB - Injet - V2 (node)
	@Override
	public void executar(IdwLogger log, ObjRtMonitorizacaoDTO objRtDTOItem, DwConsolidTemplate.TpId tpId, RtFolhaDTO dwRt, OmCfg omCfg,MonitorizacaoInjetV2RN rn, boolean isTurnoAtual, Integer filtroOp) {
	}	
	

}
