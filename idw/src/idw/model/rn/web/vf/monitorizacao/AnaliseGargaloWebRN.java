package idw.model.rn.web.vf.monitorizacao;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmGtDAO;
import idw.model.dao.OmObjDAO;
import idw.model.excessoes.PostoSemDadoException;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate.TpId;
import idw.model.rn.DataHoraRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.model.rn.monitorizacao.web.imagem.MonitorizacaoIcone;
import idw.model.rn.monitorizacao.web.imagem.MonitorizacaoIconeFactory;
import idw.model.rn.web.vf.AbstractWebRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.DetalheMonitorizacaoWebRN;
import idw.model.rn.web.vf.monitorizacao.detalhe.FiltroWebRN;
import idw.util.Cor;
import idw.webservices.dto.DetalheAnaliseGargaloDTO;
import idw.webservices.dto.FiltroProducaoDTO;
import idw.webservices.dto.FiltroProducaoPtCpDTO;
import idw.webservices.dto.IndicadoresPtDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.AnaliseGargaloDTO;
import idw.webservices.rest.dto.monitorizacao.AnaliseGargaloGraficoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroAnaliseGargaloDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroPtCpDTO;
import idw.webservices.rest.dto.monitorizacao.MonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.PtAnaliseGargaloDTO;
import idw.webservices.rest.dto.monitorizacao.PtIconeDTO;
import idw.webservices.rest.dto.monitorizacao.PtIndicadorDTO;
import idw.webservices.rest.dto.monitorizacao.PtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.PtTemposDTO;
import ms.util.ConversaoTipos;

public class AnaliseGargaloWebRN extends AbstractWebRN {
	
	public static final Color COR_CICLO_PADRAO = new Color(102,102,255);
	public static final Color COR_CICLO_MEDIO = new Color(255,127,0);
	public static final Color COR_CICLO_MEDIOGARGALOAGRUPADO = new Color(0,255,0);//VERDE //190508
	public static final Color COR_GARGALO_TEORICO = new Color(255,0,0);
	public static final Color COR_GARGALO_DINAMICO = new Color(153,0,204);
	
	public static final String FORMATO_DATA = "dd/MM/yyyy";
	public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";

	private MonitorizacaoIconeFactory iconeFactory = new MonitorizacaoIconeFactory();
	
	public AnaliseGargaloWebRN(String formatoData, String formatoDataHora) {
		super(formatoData, formatoDataHora);
	}

	public AnaliseGargaloWebRN(
			DAOGenerico dao, 
			String formatoData,
			String formatoDataHora) {
		super(dao, formatoData, formatoDataHora);
	}
	
	public AnaliseGargaloDTO getDetalhe(FiltroMonitorizacaoDTO filtroMonitorizacao) {
		
		
		MonitorizacaoWebRN monitorizacaoWebRN = new MonitorizacaoWebRN(getDao(), formatoData, formatoDataHora);
		MonitorizacaoDTO monitorizacaoDTO = monitorizacaoWebRN.getMonitorizacao(filtroMonitorizacao);
		
		FiltroProducaoDTO filtroConvertido = converterFiltro(monitorizacaoDTO.getFiltroAnaliseGargalo());

		
		
		
		//190425 //1904TESTE TESTE. desativar //TODO: desativar apos testes do frontend:
		//190425 //1904TESTE TESTE. filtroMonitorizacao.setGargalosAgrupados(true);		
		
		
		
		
		
		DetalheMonitorizacaoPTInsertRN AnaliseGargaloRN = new DetalheMonitorizacaoPTInsertRN(getDao());
			//190417		DetalheAnaliseGargaloDTO detalhe = AnaliseGargaloRN.getDetalheCelulas(filtroConvertido);
		DetalheAnaliseGargaloDTO detalhe = AnaliseGargaloRN.getDetalheCelulas(filtroConvertido, filtroMonitorizacao.isGargalosAgrupados()); //190417
		
		AnaliseGargaloDTO retorno = new AnaliseGargaloDTO();
		retorno.setGrupoTrabalho(filtroMonitorizacao.getCdGt());
		retorno.setData(filtroMonitorizacao.getDtReferencia());
		retorno.setTurno(filtroConvertido.getDwTurno().getDsTurno());


		retorno.setCorCicloPadrao(Cor.transformarParaCodigoHexadecimal(COR_CICLO_PADRAO));
		retorno.setCorCicloMedio(Cor.transformarParaCodigoHexadecimal(COR_CICLO_MEDIO));
		retorno.setCorGargaloTeorico(Cor.transformarParaCodigoHexadecimal(COR_GARGALO_TEORICO));
		retorno.setCorGargaloDinamico(Cor.transformarParaCodigoHexadecimal(COR_GARGALO_DINAMICO));
		retorno.setCorCicloMedioGargaloAgrupado(Cor.transformarParaCodigoHexadecimal(COR_CICLO_MEDIOGARGALOAGRUPADO));//190508

		
		retorno.setPostos(getDetalhePostos(detalhe));
		retorno.setGargalos(getGargalos(detalhe, filtroMonitorizacao.getCdGt(),  monitorizacaoDTO.getFiltroAnaliseGargalo().getListaFiltroPostos(), filtroMonitorizacao.isGargalosAgrupados()));


		retorno.setIndicadoresApontamentoGt(new PtIndicadorDTO());
		retorno.setTemposApontamentoGt(new PtTemposDTO());
		retorno.setIcone(getIcone(filtroMonitorizacao.getCdGt()));


		
		if (filtroMonitorizacao.isGargalosAgrupados()){
			boolean isAoMenosUmGargaloAgrupado = false;
			if (retorno.getGargalos()!=null){
				Iterator it  = retorno.getGargalos().iterator();
				while (it.hasNext()){
					AnaliseGargaloGraficoDTO o =  (AnaliseGargaloGraficoDTO) it.next();
					if (o.isGargalosAgrupados()){
						isAoMenosUmGargaloAgrupado = true;
						break;
					}
				}
			}
			if(isAoMenosUmGargaloAgrupado){
				retorno.setGargalosAgrupados(true);//190424
			}else{
				retorno.setGargalosAgrupados(false);//190424
			}
		}




		try {
			OmObjDAO objDAO = new OmObjDAO(getDaoSession());
			String cdPtAptGt = objDAO.getCdPtApontamentoByCdGt(filtroMonitorizacao.getCdGt());
			FiltroDetalhePostoDTO filtro = filtroPtAptGt(retorno, cdPtAptGt);

			if (filtro.getTpId() != null) {
				FiltroWebRN filtroRN = new FiltroWebRN(getDao(), FORMATO_DATA, FORMATO_DATA_HORA);
				DetalheMonitorizacaoWebRN rn = new DetalheMonitorizacaoWebRN(getDao(), FORMATO_DATA, FORMATO_DATA_HORA);
				
				PtMonitorizacaoDTO ptGt = rn.getDetalhe(filtroRN.converterParaFiltroDetalhePTInjetDTO(filtro));
				retorno.setIndicadoresApontamentoGt(ptGt.getIndicadores());
				retorno.setTemposApontamentoGt(ptGt.getTempos());

			
				objDAO=null;//20190104
				cdPtAptGt=null;//20190104
				filtro=null;//20190104
			}
			
		} catch (PostoSemDadoException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		
		monitorizacaoWebRN =null;//20190104
		monitorizacaoDTO =null;//20190104
		filtroConvertido =null;//20190104
		AnaliseGargaloRN=null;//20190104
		detalhe=null;//20190104
		
		
		return retorno;
	}
	
	private FiltroDetalhePostoDTO filtroPtAptGt(AnaliseGargaloDTO maquinas, String cdPtAptGt) {
		FiltroDetalhePostoDTO filtro = new FiltroDetalhePostoDTO();

		for (AnaliseGargaloGraficoDTO gargalo : maquinas.getGargalos()) {
			if (gargalo.getPosto().equals(cdPtAptGt)) {
				filtro = gargalo.getFiltro();
				break;
			}
		}

		return filtro;
	}
	
	private List<PtAnaliseGargaloDTO> getDetalhePostos(DetalheAnaliseGargaloDTO detalhe) {
		List<PtAnaliseGargaloDTO> retorno = new ArrayList<PtAnaliseGargaloDTO>();
		
		for(IndicadoresPtDTO pt : detalhe.getListaIndicadoresPt().getLista()) {
			PtAnaliseGargaloDTO ptDTO = new PtAnaliseGargaloDTO();
			ptDTO.setPosto(pt.getOmPt().getCdPt());
			ptDTO.setCicloPadrao(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getCicloPadrao(), 2) + "s");
			ptDTO.setCicloMedio(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getCicloMedio().doubleValue(), 2) + "s");
			ptDTO.setHorasPeriodo(DataHoraRN.formatSegundosParaHHMMSS(pt.getIndicadoresDTO().getTempoPeriodo()));
			ptDTO.setHorasTotais(DataHoraRN.formatSegundosParaHHMMSS(pt.getIndicadoresDTO().getTempoAtivo().add(pt.getIndicadoresDTO().getTempoParadaSp())));
			ptDTO.setHorasDisponiveis(DataHoraRN.formatSegundosParaHHMMSS(pt.getIndicadoresDTO().getTempoAtivo()));
			ptDTO.setHorasTrabalhadas(DataHoraRN.formatSegundosParaHHMMSS(pt.getIndicadoresDTO().getTempoTrabalhado()));
			ptDTO.setHorasParadas(DataHoraRN.formatSegundosParaHHMMSS(pt.getIndicadoresDTO().getTempoParadaCp()));
			ptDTO.setProducaoBruta(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getProducaoBruta(), 0));
			ptDTO.setProducaoRefugada(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getProducaoRefugada(), 0));
			ptDTO.setProducaoLiquida(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getProducaoLiquida(), 0));
			ptDTO.setProducaoPrevista(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getProducaoPrevista(), 0));
			ptDTO.setEficienciaRealizacao(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getEficienciaRealizacao(), 2));
			ptDTO.setIndiceRefugo(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getIndiceRefugo(), 2));
			ptDTO.setIndiceParada(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getIndiceParada(), 2));
			ptDTO.setIndiceCavidadesAtivas(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getIndiceCavidadesAtivas(), 2));
			ptDTO.setEficienciaCiclo(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getEficienciaCiclo(), 2));
			ptDTO.setIndiceProdutividade(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getIndiceProducao(), 2));
			ptDTO.setEficienciaInst(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getEficienciaInstantanea(), 2));
			ptDTO.setIto(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getITO(), 2));
			ptDTO.setIdo(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getIDO(), 2));
			ptDTO.setIpa(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getIPA(), 2));
			ptDTO.setOee(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getOee(), 2));
			
			retorno.add(ptDTO);
		}
		
		for (IndicadoresPtDTO pt : detalhe.getListaIndicadoresPtGargaloTeorico().getLista()) {
			for(PtAnaliseGargaloDTO dto : retorno) {
				if (pt.getOmPt().getCdPt().equals(dto.getPosto())) {
					dto.setCor(Cor.transformarParaCodigoHexadecimal(COR_GARGALO_TEORICO));
	            }
			}
        }
		
		for (IndicadoresPtDTO pt : detalhe.getListaIndicadoresPtGargaloDinamico().getLista()) {
			for(PtAnaliseGargaloDTO dto : retorno) {
				if (pt.getOmPt().getCdPt().equals(dto.getPosto())) {
					dto.setCor(Cor.transformarParaCodigoHexadecimal(COR_GARGALO_DINAMICO));
	            }
			}
        }
		
		return retorno;
	}
	
	private List<AnaliseGargaloGraficoDTO> getGargalos(DetalheAnaliseGargaloDTO detalhe, String cdGt,  List<FiltroDetalhePostoDTO> listaFiltroPostos, boolean isGargalosAgrupados) {
		List<AnaliseGargaloGraficoDTO> retorno = new ArrayList<AnaliseGargaloGraficoDTO>();
		
		List<AnaliseGargaloGraficoDTO> listaPt = new ArrayList<AnaliseGargaloGraficoDTO>();		
		OmObjDAO objDAO = new OmObjDAO(getDaoSession());
		List<OmObj> listaobj = objDAO.pesquisarOmObsByCdGt(cdGt);
		listaobj = objDAO.getPostosOrdenados(listaobj);


		String caminhoicone = "";
		for(OmObj ptG : listaobj) {
			
			caminhoicone = "";
			if (ptG.getOmImg()!=null && ptG.getOmImg().getUrlImg()!=null ){
				caminhoicone = 	ptG.getOmImg().getUrlImg();
			}
			for (IndicadoresPtDTO pt : detalhe.getListaIndicadoresPt().getLista()) {
				if (ptG.getOmPt().getCdPt().equals(pt.getOmPt().getCdPt())) {
					AnaliseGargaloGraficoDTO dto = new AnaliseGargaloGraficoDTO();
					dto.setPosto(pt.getOmPt().getCdPt());
					dto.setCicloPadrao(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getCicloPadrao(), 2));
					dto.setCicloMedio(ConversaoTipos.converteParaString(pt.getIndicadoresDTO().getCicloMedio().doubleValue(), 2));
					dto.setCorCicloPadrao(Cor.transformarParaCodigoHexadecimal(COR_CICLO_PADRAO));
					dto.setCorCicloMedio(Cor.transformarParaCodigoHexadecimal(COR_CICLO_MEDIO));
					
					dto.setFiltro(getFiltroDetalhePosto(dto.getPosto(), listaFiltroPostos));
					
					dto.setCaminhoIcone(caminhoicone);//180828
					
					dto.setGargalosAgrupados(pt.isGargalosAgrupados());//190425
					dto.getFiltro().setGargalosAgrupados(pt.isGargalosAgrupados());//190508

					//190508
					if ( dto.isGargalosAgrupados() 
							&& dto.getCorCicloMedio().equals(Cor.transformarParaCodigoHexadecimal(COR_CICLO_MEDIO))
						){
						dto.setCorCicloMedio(Cor.transformarParaCodigoHexadecimal(COR_CICLO_MEDIOGARGALOAGRUPADO));
					}
					
					//190508
					if ( dto.isGargalosAgrupados() ){
						dto.getFiltro().setCdTipoPosto(pt.getIndicadoresDTO().getCdPt());
					}

					
					AnaliseGargaloGraficoDTO ptGargalo = new AnaliseGargaloGraficoDTO();
					ptGargalo = dto;

					listaPt.add(ptGargalo);			
					break;
				}
	        }
		}
		
        retorno = new ArrayList<AnaliseGargaloGraficoDTO>();
        for (AnaliseGargaloGraficoDTO obj : listaPt) {
        	retorno.add(obj);
        }
        
		for (IndicadoresPtDTO pt : detalhe.getListaIndicadoresPtGargaloTeorico().getLista()) {
			for(AnaliseGargaloGraficoDTO dto : retorno) {
				if (pt.getOmPt().getCdPt().equals(dto.getPosto())) {
					dto.setCorCicloPadrao(Cor.transformarParaCodigoHexadecimal(COR_GARGALO_TEORICO));
	            }
			}
        }
		
		for (IndicadoresPtDTO pt : detalhe.getListaIndicadoresPtGargaloDinamico().getLista()) {
			for(AnaliseGargaloGraficoDTO dto : retorno) {
				if (pt.getOmPt().getCdPt().equals(dto.getPosto())) {
					dto.setCorCicloMedio(Cor.transformarParaCodigoHexadecimal(COR_GARGALO_DINAMICO));
	            }
			}
        }

		
		// renomeia postos para os casos de gargalos-agrupados
		if(retorno!=null){
			Iterator it = retorno.iterator();
			while (it.hasNext()){
				AnaliseGargaloGraficoDTO o = (AnaliseGargaloGraficoDTO) it.next();
				if (o.isGargalosAgrupados()){
					o.setPosto(o.getFiltro().getCdTipoPosto());				}
			}
		}
		
		
		return retorno;
	}
	
	private FiltroDetalhePostoDTO getFiltroDetalhePosto(String cdPosto, List<FiltroDetalhePostoDTO> lista) {
    	for(FiltroDetalhePostoDTO posto : lista) {
    		if(posto.getCdPosto().equals(cdPosto)) {
    			return posto;
    		}
    	}
    	return null;
    }
	
	// Baseado no NetBeans: GtTabMain.mostrarAnaliseGargalo
	public FiltroProducaoDTO converterFiltro(FiltroAnaliseGargaloDTO filtro) {
		FiltroProducaoDTO retorno = new FiltroProducaoDTO();
		
		retorno.setDtReferencia(DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData));
		
		TurnoRN turnoRN = new TurnoRN(getDao());
		retorno.setDwTurno(turnoRN.getDwTurnoPorId(filtro.getIdTurno()));
		
		OmGtDAO omGtDAO = new OmGtDAO(getDaoSession());
		OmGt omGt = omGtDAO.getOmGtPorCdAtivoOrderById(filtro.getCdGt());
		retorno.setOmGt(omGt);
		
		if (filtro.getFiltroOp() == 2) {
			retorno.setTpId(TpId.ACUMULADO.getValue());
		} else {
			retorno.setTpId(TpId.TURNO.getValue());
		}
		
		List<FiltroProducaoPtCpDTO> listaFiltroPtCpConvertido = new ArrayList<>();
		for(FiltroPtCpDTO filtroPtCp : filtro.getListaFiltroPtCp()) {
			OmPt omPt = new OmPt();
			omPt.setIdPt(filtroPtCp.getIdPt());
			
            PpCp ppCp = new PpCp();
            ppCp.setCdCp(filtroPtCp.getCdCp());
            
            FiltroProducaoPtCpDTO filtroPtCpConvertido = new FiltroProducaoPtCpDTO();
            filtroPtCpConvertido.setOmPt(omPt);
            filtroPtCpConvertido.setPpCp(ppCp);
            
            listaFiltroPtCpConvertido.add(filtroPtCpConvertido);
		}
		retorno.setListaFiltroProducaoPtCp(listaFiltroPtCpConvertido);
		
		return retorno;
	}

	private PtIconeDTO getIcone(String cdGt) {		
		OmObjDAO objDAO = new OmObjDAO(getDaoSession());
		OmObj objGT = objDAO.getObjGt(cdGt);
		
		ObjRtMonitorizacaoDTO obj = new ObjRtMonitorizacaoDTO();
		obj.setUrlImg(objGT.getOmGtByIdGt().getOmImg() != null ? objGT.getOmGtByIdGt().getOmImg().getUrlImg() : "");
		
		MonitorizacaoIcone monitorizacaoIcone = iconeFactory.getMonitorizacaoIcone(obj);
		PtIconeDTO iconeDTO = monitorizacaoIcone.getIcone(obj);				
		return iconeDTO;
	}
		
}
