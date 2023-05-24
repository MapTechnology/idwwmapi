package idw.model.rn.web.injet.monitorizacao.detalhe;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.OmGtDAO;
import idw.model.dao.OmPtDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.DwConsolidTemplate.TpId;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.detalhemonitorizacao.GraficoBIParetoPerdasRN;
import idw.model.rn.injet.TurnoInjetRN;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroProducaoDTO;
import idw.webservices.dto.FiltroProducaoPtCpDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalheParadaDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroDetalhePostoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.FiltroPerdaGanhoDTO;

public class FiltroWebInjetRN  extends AbstractRN<DAOGenericoInjet> {
	
	public static final int ULTIMA_OP = 0;
	public static final int TODAS_OP = 1;

	private final String formatoData;
	private final String formatoDataHora;
	
	public FiltroWebInjetRN(String formatoData, String formatoDataHora) {
        this(new DAOGenericoInjet(), formatoData, formatoDataHora);
    }

    public FiltroWebInjetRN(DAOGenericoInjet dao, String formatoData, String formatoDataHora) {
        super(dao);
        this.formatoData = formatoData;
        this.formatoDataHora = formatoDataHora;
    }
    
    public FiltroDetalhePTInjetDTO converterParaFiltroDetalhePerdaGanho(FiltroPerdaGanhoDTO filtro) {
    	FiltroDetalhePTInjetDTO filtroConvertido = this.converterParaFiltroDetalhePTInjetDTO(filtro);
    	if(filtro.getTipo() == 2) {
    		filtroConvertido.setTipoPareto(GraficoBIParetoPerdasRN.PARETO_CICLOS);
    	} else {
    		filtroConvertido.setTipoPareto(GraficoBIParetoPerdasRN.PARETO_TODAS);
    	}
    	filtroConvertido.setIsParadasComPeso(filtro.isMostrarParadaComPeso());
    	filtroConvertido.setIsParadasSemPeso(filtro.isMostrarParadaSemPeso());    	
    	return filtroConvertido;
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
    
    public FiltroDetalhePTInjetDTO converterParaFiltroDetalhePTInjetDTO(FiltroDetalhePostoDTO filtro, boolean isParComPeso, boolean isParSemPeso) {
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

    	retorno.setIsParadasComPeso(isParComPeso);
    	retorno.setIsParadasSemPeso(isParSemPeso);
    	return retorno;
    }
        
    public FiltroProducaoDTO getFiltroAnaliseTurno(FiltroMonitorizacaoDTO filtroMonitorizacao) {
    	FiltroProducaoDTO filtro = new FiltroProducaoDTO();
    	
		filtro.setDtReferencia(DataHoraRN.stringToDate(filtroMonitorizacao.getDtReferencia(), formatoData));
		
		TurnoInjetRN turnoRN = new TurnoInjetRN(getDao());
		filtro.setDwTurno(turnoRN.getDwTurnoPorIdInjet(filtroMonitorizacao.getIdTurno()));
		
		OmGtDAO omGtDAO = new OmGtDAO(getDaoSession());
		OmGt omGt = omGtDAO.getOmGtPorCdAtivoOrderByIdInjet(getDao(), filtroMonitorizacao.getCdGt());
		
		filtro.setOmGt(omGt);
		
		filtro.setTpId(TpId.TURNO.getValue());

		OmPtDAO ptrn = new OmPtDAO(getDaoSession());
		
		List<FiltroProducaoPtCpDTO> listaFiltroPtCp = new ArrayList<>();
		for(FiltroDetalhePostoDTO filtroPosto : filtroMonitorizacao.getListaFiltroPosto()) {
			FiltroProducaoPtCpDTO filtroPtCp = new FiltroProducaoPtCpDTO();
			
			OmPt omPt = ptrn.getOmPtAtivoComUltimaRevisaoInjet(getDao(), filtroPosto.getCdPosto());
			filtroPtCp.setOmPt(omPt);
			
            PpCp ppCp = new PpCp();
            ppCp.setCdCp(filtroPosto.getCdCp());
            filtroPtCp.setPpCp(ppCp);
            
            listaFiltroPtCp.add(filtroPtCp);
		}
		filtro.setListaFiltroProducaoPtCp(listaFiltroPtCp);
		
		return filtro;
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
