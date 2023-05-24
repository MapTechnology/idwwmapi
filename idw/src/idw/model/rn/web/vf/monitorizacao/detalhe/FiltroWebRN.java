package idw.model.rn.web.vf.monitorizacao.detalhe;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmGtDAO;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwConsolidTemplate.TpId;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.detalhemonitorizacao.GraficoBIParetoPerdasRN;
import idw.webservices.dto.FiltroDetalheDefeito;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroProducaoDTO;
import idw.webservices.dto.FiltroProducaoPtCpDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalheDefeitoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroPerdaGanhoDTO;

public class FiltroWebRN extends AbstractRN<DAOGenerico> {
	
	public static final int ULTIMA_OP = 0;
	public static final int TODAS_OP = 1;

	private final String formatoData;
	private final String formatoDataHora;
	
	public FiltroWebRN(String formatoData, String formatoDataHora) {
        this(new DAOGenerico(), formatoData, formatoDataHora);
    }

    public FiltroWebRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    public FiltroDetalhePTInjetDTO converterParaFiltroDetalhePTInjetDTO(FiltroDetalhePostoDTO filtro) {
    	FiltroDetalhePTInjetDTO retorno = new FiltroDetalhePTInjetDTO();
    	retorno.setFiltroOp(filtro.getFiltroOp());
    	retorno.setCdCp(filtro.getCdCp());
    	
    	
    	if(filtro.getTpId() == DwConsolidTemplate.TpId.TURNO.getValue()) {
    		retorno.setDtReferencia(DataHoraRN.stringToDate(filtro.getDtReferencia(), formatoData));
    	}
    	
    	if(filtro.getTpId() == DwConsolidTemplate.TpId.HORA.getValue()) {
    		retorno.setDthrIhora(DataHoraRN.stringToDate(filtro.getDtHrReferenciaInicial(), formatoDataHora));
    		retorno.setDthrFhora(DataHoraRN.stringToDate(filtro.getDtHrReferenciaFinal(), formatoDataHora));
    	}
    	
    	if(filtro.getIdTurno() > 0) {
	    	DwTurno turno = new DwTurno();
	    	turno.setIdTurno(filtro.getIdTurno());
	    	retorno.setDwTurno(turno);
    	}
    	
    	OmPt posto = new OmPt();
    	posto.setCdPt(filtro.getCdPosto());
    	retorno.setOmPt(posto);
    	
    	if(filtro.getCdProduto() != null && !filtro.getCdProduto().equals("")) {
    		OmProduto produto = new OmProduto();
        	produto.setCdProduto(filtro.getCdProduto());
        	retorno.setOmProduto(produto);
    	}
    	
    	retorno.setTpId(filtro.getTpId());
    	return retorno;
    }
    
    public FiltroProducaoDTO getFiltroAnaliseTurno(FiltroMonitorizacaoDTO filtroMonitorizacao) {
    	FiltroProducaoDTO filtro = new FiltroProducaoDTO();
    	
		filtro.setDtReferencia(DataHoraRN.stringToDate(filtroMonitorizacao.getDtReferencia(), formatoData));
		
		TurnoRN turnoRN = new TurnoRN(getDao());
		filtro.setDwTurno(turnoRN.getDwTurnoPorId(filtroMonitorizacao.getIdTurno()));
		
		OmGtDAO omGtDAO = new OmGtDAO(getDaoSession());
		OmGt omGt = omGtDAO.getOmGtPorCdAtivoOrderById(filtroMonitorizacao.getCdGt());
		filtro.setOmGt(omGt);
		
		filtro.setTpId(TpId.TURNO.getValue());
		
		PTRN ptrn = new PTRN(getDao());
		
		List<FiltroProducaoPtCpDTO> listaFiltroPtCp = new ArrayList<>();
		if(filtroMonitorizacao.getListaFiltroPosto() == null) {
			filtroMonitorizacao.setListaFiltroPosto(new ArrayList<FiltroDetalhePostoDTO>());
		}
		for(FiltroDetalhePostoDTO filtroPosto : filtroMonitorizacao.getListaFiltroPosto()) {
			FiltroProducaoPtCpDTO filtroPtCp = new FiltroProducaoPtCpDTO();
			
			OmPt omPt = ptrn.pesquisarPtByCdPtStAtivo(filtroPosto.getCdPosto());
			filtroPtCp.setOmPt(omPt);
			
			PpCp ppCp = new PpCp();
			ppCp.setCdCp(filtroPosto.getCdCp());
			filtroPtCp.setPpCp(ppCp);
			
			listaFiltroPtCp.add(filtroPtCp);
		}
		filtro.setListaFiltroProducaoPtCp(listaFiltroPtCp);
		
		return filtro;
	}
    
    public FiltroDetalhePTInjetDTO converterParaFiltroDetalhePerdaGanho(FiltroPerdaGanhoDTO filtro) {
    	FiltroDetalhePTInjetDTO filtroConvertido = this.converterParaFiltroDetalhePTInjetDTO(filtro);
    	if(filtro.getTipo() == 2) {
    		filtroConvertido.setTipoPareto(GraficoBIParetoPerdasRN.PARETO_CICLOS);
    	} else {
    		filtroConvertido.setTipoPareto(GraficoBIParetoPerdasRN.PARETO_TODAS);
    	}
    	
    	// o vf-desktop passa os filtros de parada com peso e sem peso = null
    	// filtroConvertido.setIsParadasComPeso(filtro.isMostrarParadaComPeso());
    	// filtroConvertido.setIsParadasSemPeso(filtro.isMostrarParadaSemPeso());
    	filtroConvertido.setIsParadasComPeso(null);
    	filtroConvertido.setIsParadasSemPeso(null);
    	
    	return filtroConvertido;
    }
    
    public FiltroDetalheDefeito converterParaFiltroDetalheDefeito(FiltroDetalheDefeitoDTO filtro) {
    	FiltroDetalhePTInjetDTO filtroInjet = this.converterParaFiltroDetalhePTInjetDTO(filtro);
    	
    	FiltroDetalheDefeito retorno = new FiltroDetalheDefeito();
    	retorno.setTpId(filtroInjet.getTpId());

		if (filtroInjet.getDtReferenciaInicial() == null || filtroInjet.getDtReferenciaFinal() == null) {
	    	retorno.setDtReferenciaInicial(filtroInjet.getDtReferencia());
	    	retorno.setDtReferenciaFinal(filtroInjet.getDtReferencia());    			
		} else {
	    	retorno.setDtReferenciaInicial(filtroInjet.getDtReferenciaInicial());
	    	retorno.setDtReferenciaFinal(filtroInjet.getDtReferenciaFinal());    			
		}
    	
    	retorno.setDwTurno(filtroInjet.getDwTurno());
    	retorno.setOmPt(filtroInjet.getOmPt());
    	retorno.setPpCp(filtroInjet.getPpCp());
    	retorno.setOmGt(filtroInjet.getOmGt());
    	retorno.setDwtarea(filtroInjet.getDwtarea());
    	retorno.setOmProduto(filtroInjet.getOmProduto());
    	retorno.setCodigoDefeito(filtro.getCdDefeito());
    	
    	return retorno;
    }
    
    public static void completarHorasDasDatas(FiltroDetalhePostoDTO filtro) {
    	if(filtro.getDtReferencia() == null || filtro.getDtReferencia().equals("")) {
    		return;
    	}
    	
    	if(filtro.getDtHrReferenciaInicial() == null) {
			filtro.setDtHrReferenciaInicial(filtro.getDtReferencia() + " 00:00:00");
		}
		
		if(filtro.getDtHrReferenciaFinal() == null) {
			filtro.setDtHrReferenciaFinal(filtro.getDtReferencia() + " 00:00:00");
		}
    }
    
    public static void duplicar(FiltroDetalhePostoDTO filtroOrigem, FiltroDetalhePostoDTO filtroCopia) {
    	filtroCopia.setFiltroOp(filtroOrigem.getFiltroOp());
    	filtroCopia.setCdCp(filtroOrigem.getCdCp());
    	filtroCopia.setDtReferencia(filtroOrigem.getDtReferencia());
    	filtroCopia.setDtHrReferenciaInicial(filtroOrigem.getDtHrReferenciaInicial());
    	filtroCopia.setDtHrReferenciaFinal(filtroOrigem.getDtHrReferenciaFinal());
    	filtroCopia.setIdTurno(filtroOrigem.getIdTurno());
    	filtroCopia.setCdPosto(filtroOrigem.getCdPosto());
    	filtroCopia.setTpId(filtroOrigem.getTpId());
    	filtroCopia.setCdProduto(filtroOrigem.getCdProduto());
    }
    
}
