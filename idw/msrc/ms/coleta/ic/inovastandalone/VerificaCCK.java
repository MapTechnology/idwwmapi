package ms.coleta.ic.inovastandalone;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.pojos.template.DwFtParamTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.dto.ColetaParametroDTO;
import ms.model.dto.IcUpDTO;

public class VerificaCCK {
	
	/*
	 * CCKPT103-2014-10-37 18:03:10.310
	 * CCKPTidPt-YYY-MM-DD HHMMMSS.txt
	 * 
	 * Conteudo do arquivo
	 * 		
		4 consumo_reativo_positivo,// kvarh[+] x 10000
		5 consumo_reativo_negativo,// kvarh[-] x 10000
		6 consumo_ativo_positivo, //kwh[+] x 10000
		7 consumo_ativo_negativo, //kwh[-] x 10000
		8 Tensao_fase_neutro_A,    // volts x 10
		9 Tensao_fase_neutro_B,	  // volts x 10
		10 Tensao_fase_neutro_C,	  // volts x 10
		11 Tensao_trifasica_media,  // volts x 10
		12 Corrente_fase_neutro_A,  // amper x 1000
		13 Corrente_fase_neutro_B,  // amper x 1000
		14 Corrente_fase_neutro_C,  // amper x 1000
		15 Corrente_media_trifasica,// amper x 1000
		16 potencia_ativa_total,	  // kwatt x 10
		17 potencia_reativa_total,  // var x 10
		18 fator_potencia,		  //fp x 1000
		19 frequencia,			  //frequencia x 100
		20 Angulo_carga_A,
		21 Angulo_carga_B,
		22 Angulo_carga_C,
		23 Angulo_Tensao_A,
		24 Angulo_Tensao_B,
		25 Angulo_Tensao_C,
		26 potencia_aparente_total, // kva x 10
		27 VersaoFirmware,
		28 Relacao_tp_primario,
		29 Relacao_tp_secundario,
		30 Relacao_tc_primario,
		31 Tp_primario_secundario,
		32 Tc_primario_tp_modo_ligacao,
		33 Tensao_fase_fase_AB,     // volts x 10
		34 Tensao_fase_fase_BC,     // volts x 10
		35 Tensao_fase_fase_CA);    // volts x 10
	 */
	
	public boolean verificaDemandaMaximaEAtualizaMedia(DadosLocaisCCK dadosLocais,double amostragem){
		boolean retorno= false;
		if(dadosLocais!=null){
			if(dadosLocais.getDemandaMaxima()<amostragem){
				dadosLocais.setDemandaMaxima(amostragem);
				retorno=true;
			}
			int szMedia=dadosLocais.getSizeMedia();
			if(szMedia<10){
				szMedia++;
			}
			dadosLocais.setDemandaMedia(((dadosLocais.getDemandaMedia()*(szMedia-1)) +amostragem)/szMedia);
			dadosLocais.setSizeMedia(szMedia);
		}
		return retorno;		
	}

	public boolean verificaLancaAlerta(IdwLogger log,  DadosLocaisCCK dadosLocais ,double amostragem){
		boolean retorno=false;
		int estadoAtual=DadosLocaisCCK._NAODEFINIDO;
		// Valida Mudanca Estado
		if(amostragem>= dadosLocais.getLimiteAceitavelInf() &&
				amostragem <= dadosLocais.getLimiteAceitavelInf()) {
			// Tuuudo bem  Verde
			estadoAtual=DadosLocaisCCK._EstadoOK;
		} else if (amostragem>=dadosLocais.getLimiteCriticoInf() &&
				amostragem<=dadosLocais.getLimiteCriticoSup()) {
			// Zona Aceitavel Amarela
			estadoAtual=DadosLocaisCCK._Aceitavel;
		} else {
			// Zona Aceitavel Vermelha
			estadoAtual=DadosLocaisCCK._Critico;			
		}
		log.info("estadoAtual=" + estadoAtual + " estadoAnterior=" + dadosLocais.getLastEstadoAferido() + " estadoAnteriorConsol=" + dadosLocais.getUltimoestadoConsolidado() +
				" country=" + dadosLocais.countRetries + 
				" nRetries=" + dadosLocais.nrRetries
				);
		if(estadoAtual!= dadosLocais.getUltimoestadoConsolidado()){
			if(dadosLocais.getLastEstadoAferido()!=estadoAtual)
				dadosLocais.countRetries=0;

			dadosLocais.countRetries++;

			if(dadosLocais.countRetries>=dadosLocais.nrRetries){
				dadosLocais.setUltimoestadoConsolidado(estadoAtual);
				dadosLocais.countRetries=0;
				if(estadoAtual!=DadosLocaisCCK._EstadoOK){
					//set ServicoFactory._ALERTA_FATOR_DE_POTENCIA
					retorno=true;
				}						
			}
		}
		dadosLocais.setLastEstadoAferido(estadoAtual);
		log.info("retorno = " + retorno);
		return retorno;
	}
	
	private DadosLocaisCCK getDadosLocaisFromIcUpdtotpParametro(IcUpDTO icupdto,int tpParametro){
		if(icupdto.getDadosLocaisCCK()!=null) {
			for (DadosLocaisCCK dadosLocais : icupdto.getDadosLocaisCCK()) {
				if(dadosLocais.getTpParametro()==tpParametro) {	
					return dadosLocais;
				}
			}					
		} 
		DadosLocaisCCK dadosLocaisCCK =new DadosLocaisCCK();						
		dadosLocaisCCK.setTpParametro(tpParametro);
		if(icupdto.getDadosLocaisCCK()==null){
			icupdto.setDadosLocaisCCK(new ArrayList<DadosLocaisCCK>());
		}
		icupdto.getDadosLocaisCCK().add(dadosLocaisCCK);
		return dadosLocaisCCK;	
	}
	

	private void updateDadosLocaisFromColetaParametroDTO(IcUpDTO icupdto){
		List<ColetaParametroDTO> parametrosColetadosDTO = null;
		int tpparametro=0;

		try {
			parametrosColetadosDTO = IdwFacade.getInstancia().getDadosMedTempPorIdPt(icupdto.getUpDTO().getCd_up());
			if (parametrosColetadosDTO!=null && parametrosColetadosDTO.size()>0) {
				for(ColetaParametroDTO colParDTO : parametrosColetadosDTO) {
					if(colParDTO!=null){
						
						if(colParDTO.getTpparametro().equals(DwFtParamTemplate.Type.ENERGIACONSUMIDA)) {
							tpparametro=ProcessaLinhaEvento._CONSUMO_ATIVO;
						}
						if (colParDTO.getTpparametro().equals(DwFtParamTemplate.Type.FATORPONTENCIA)) {
							tpparametro=ProcessaLinhaEvento._FATOR_DE_POTENCIA;
						}
						DadosLocaisCCK dadosLocaisCCK = getDadosLocaisFromIcUpdtotpParametro(icupdto,tpparametro);
						
						try {
							dadosLocaisCCK.setLimiteAceitavelInf(colParDTO.getLimInfTemp().doubleValue());
							dadosLocaisCCK.setLimiteCriticoInf(colParDTO.getLimInfTempCritico().doubleValue());
							dadosLocaisCCK.setLimiteAceitavelSup(colParDTO.getLimSupTemp().doubleValue());
							dadosLocaisCCK.setLimiteCriticoSup(colParDTO.getLimSupTempCritico().doubleValue());
						} catch (NullPointerException e) {
							e.printStackTrace(); 
						}
					}
				}
			}

		}catch(Exception exec){
			exec.printStackTrace();
			
		}
	}
	
	private void verificaSeAtualizaDadosLocaisCCK(IcUpDTO icupdto){
		Date dthrAtual=new Date();
		if((icupdto.getRefUpdateDadosLocaisCCK() == null) || (DataHoraRN.getQuantidadeSegundosNoPeriodo(icupdto.getRefUpdateDadosLocaisCCK(),dthrAtual )>60)){
			icupdto.setRefUpdateDadosLocaisCCK(dthrAtual);
			updateDadosLocaisFromColetaParametroDTO(icupdto);
		}		
	}
	
	public DadosLocaisCCK getDadosLocaisFromIcUpdtoVerificaUpdate(IcUpDTO icupdto,int tpParametro){
		verificaSeAtualizaDadosLocaisCCK(icupdto);
		return getDadosLocaisFromIcUpdtotpParametro(icupdto,tpParametro);
	}
	
}
