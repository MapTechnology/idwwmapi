	package idw.model.rn.monitorizacao;

import java.util.ArrayList;
import java.util.Date;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.TurnoRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.GtDTO;
import idw.webservices.dto.GtRtDTO;
import idw.webservices.dto.GtRtMonitorizacaoDTO;
import idw.webservices.dto.ObjDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.dto.ObjsDTO;
import idw.webservices.dto.ObjsRtMonitorizacaoDTO;
import idw.webservices.dto.TurnoAtualDTO;

public class MonitorizacaoVisaoMaquinaRN extends MonitorizacaoRN {	

	public MonitorizacaoVisaoMaquinaRN() {
		super();
	}


	public MonitorizacaoVisaoMaquinaRN(DAOGenerico dao) {
		super(dao);
	}

	/**
	 * Esse eh o metodo chamado para criacao da tela de monitorizacao com os
	 * icones Dados Monitorizaçãoo em tempo real do Grupo de Trabalho
	 * 
	 * @param GtRtDTO
	 * @param tpId
	 *            - tipo do período (hora, turno, acumulado, mês/ano)
	 * @return <code>GtRtDTO</code> com detalhes da monitorizaçãoo
	 */
	public GtRtMonitorizacaoDTO getTelaMonitorizacaoMaquina(GtRtDTO filtro, DwConsolidTemplate.TpId tpId) {
		IdwLogger log = new IdwLogger("MonitorizacaoVisaoMaquina");
		
		// Alessandre: Em 5-3-13 acrescentei a linha abaixo para remover a hora
		// da data de referencia
		// pois no XP do ambiente de testes a hora estava chegando com valor 1
		// mas saia da GUI como 0
		filtro.setDtReferencia(DataHoraRN.getDataSemHora(filtro.getDtReferencia()));

		// Instancia objeto de retorno

		GtRtMonitorizacaoDTO retorno = new GtRtMonitorizacaoDTO();
		retorno.setObjsRtMonitorizacaoDTO(new ObjsRtMonitorizacaoDTO());
		retorno.getObjsRtMonitorizacaoDTO().setObjsRtMonitorizacao(new ArrayList<ObjRtMonitorizacaoDTO>());
		retorno.setGtDTO(new GtDTO());
		retorno.getGtDTO().setGt(filtro.getGtDTO().getGt());


		if (retorno.getGtDTO().getGt() == null || filtro.getGtDTO().getGt().getIdGt() == null) {
			
			return retorno;
		}

		// guardar a data/hora atual para o grupo de trabalho
		// gtRtDTO dtreferencia tem que ser a do filtro, senao os dados nao vem
		// corretamente
		// entretanto, antes de retornar do ws devemos alterar essa referencia
		// para a dt e hr atual q sera mostrada na GUI.
		//
		retorno.setDtReferencia(filtro.getDtReferencia());

		OmCfg omcfg = Util.getConfigGeral(this.getDaoSession());

		// pega os objetos que fazem parte do GT

		log.iniciaAvaliacao("getObjsDTO");
		ObjsDTO listaobjs = this.getObjsDTO(log, filtro.getGtDTO().getGt().getIdGt(), filtro.getIdPt(), true);
		log.mostrarAvaliacaoCompleta();

		// Varre todos os objetos que compoe a tela do GT que sera monitorizado com o 
		// objetivo de instancia cada objeto desse, conforme o seu tipo? PT GT Imagem, etc
		log.iniciaAvaliacao("for em getObjs");
		for (ObjDTO obj : listaobjs.getObjs()) {

			
			ObjRtMonitorizacaoDTO objetoDaTela = this.montaObjetoNaTelaMonitorizacao(log, obj, tpId, retorno.getDtReferencia(), filtro.getDwTurno(), omcfg, filtro.getIsTurnoAtual(), filtro.getFiltroOP());
			

			if (objetoDaTela != null) {
				objetoDaTela.setDtReferencia(retorno.getDtReferencia());
				objetoDaTela.setCdTurno(filtro.getDwTurno().getCdTurno());
				objetoDaTela.setIdTurno(filtro.getDwTurno().getIdTurno());
				retorno.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao().add(objetoDaTela);
			}
		}
		log.mostrarAvaliacaoCompleta();
		
		// Finalizano o metodo preparando algumas informacoes para retorno

		TurnoRN rn = new TurnoRN(getDao());
		TurnoAtualDTO turnoReferencia = null;
		OmPt ompt = new OmPt();
		
		//  Pega a referencia o 1o pt e em qual turno ele está
		log.iniciaAvaliacao("Restante 1 do algoritmo");
		for (ObjRtMonitorizacaoDTO obj : retorno.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao()) {
			if (obj.getTipoObj() == 0) { //PT
				
				log.info("PT " + obj.getCdPt() + " usado como referencia para encontrar o turno");
				
				ompt.setIdPt(obj.getIdPt());
				ompt.setCdPt(obj.getCdPt());
				try {
					turnoReferencia = rn.getTurnoAtualDTOPassandoIdPtEDtTurnoEIdTurno(ompt,filtro.getDtReferencia(),filtro.getDwTurno().getIdTurno());
					if (turnoReferencia != null) {
						break;
					}
				} catch (SemCalendarioException e) {
					continue;
				} catch (IllegalStateException e) {
					continue;
				}
			}
		}
		log.mostrarAvaliacaoCompleta();
		log.iniciaAvaliacao("Restante 2 do algoritmo");
		
		//Se o pt nao tiver um turno entao usar o turno do filtro
		if (turnoReferencia == null) {
			turnoReferencia = new TurnoAtualDTO();
			turnoReferencia.setDwturno(filtro.getDwTurno());
		}

		// Alessandre 14-2-14 a linha abaixo foi comentada pois desejamos que a
		// dt de referencia do turno seja a dt de referncia que veio no filtro
		// se retornarmos a dt e hr atual a monitorizacao ira mostrar sempre a
		// dt atual como referencia ao turno. Problema qdo virar 0h
		retorno.setDthrRefresh(DataHoraRN.getDataHoraAtual());
		retorno.setTurnoReferencia(turnoReferencia);
		log.mostrarAvaliacaoCompleta();
		log.iniciaAvaliacao("Restante 3 do algoritmo");

		
		if (turnoReferencia != null)
			retorno.getTurnoReferencia().prepararSerializacao();
		
		log.mostrarAvaliacaoCompleta();
		return retorno;

	}

	
	/**
	 * Coleta dos dados de tempo real do objeto
	 * 
	 * @param objDTO
	 * @return Dados do tempo real do objeto
	 */
	private ObjRtMonitorizacaoDTO montaObjetoNaTelaMonitorizacao(IdwLogger log, ObjDTO objDTO, DwConsolidTemplate.TpId tpId, Date dtReferencia, DwTurno dwTurno, OmCfg omcfg, boolean isTurnoAtual, Integer filtroOp) {

		ObjRtMonitorizacaoDTO retorno = new ObjRtMonitorizacaoDTO();
		OmObj omObj = objDTO.getObj();

		retorno.setUrlImg(omObj.getOmImg() != null ? omObj.getOmImg().getUrlImg() : "");

		retorno.setX(objDTO.getObj().getX().doubleValue());
		if (objDTO.getObj().getY() != null)
			retorno.setY(objDTO.getObj().getY().doubleValue());
		else
			retorno.setY(0d);

		// Factory para tratar o objeto em tela
		ObjetoNaTelaFactory objeto = ObjetoNaTelaFactory.getInstancia(omObj);
		try {
			log.iniciaAvaliacao("fim objeto.criar");
			log.info("objeto.criar");
			objeto.criar(retorno, omObj, omcfg, log, dtReferencia, dwTurno, this, tpId, isTurnoAtual, filtroOp);
		} catch (NullPointerException e) {
			log.info("ObjetoNaTela nao suportado nesse metodo. TpObj=" + omObj.getTpObj(), e);
			retorno = null;
		} finally {
			log.mostrarAvaliacaoCompleta();
		}
		return retorno;
	}
}
