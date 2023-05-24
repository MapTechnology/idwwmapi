package idw.model.rn.monitorizacao.detalhes;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwPassdef;
import idw.model.pojos.OmCfgind;
import idw.model.rn.AbstractRN;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoDefeitoComponenteDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoDefeitosComponentesDTO;
import idw.webservices.dto.DetalhamentoDefeitoComponenteDTO;
import idw.webservices.dto.FiltroDetalheDefeito;

public class OcorrenciaParettoDefeitoComponenteRN extends AbstractRN<DAOGenerico> {
	
	public static final long ID_INDICADOR_DEFEITO_COMPONENTE = 1;

	public OcorrenciaParettoDefeitoComponenteRN() {
		super(new DAOGenerico());
	}
	
	public OcorrenciaParettoDefeitoComponenteRN(DAOGenerico dao) {
		super(dao);
	}
	
	public GraficoParettoDefeitosComponentesDTO getGraficoParettoDefeitoComponente(FiltroDetalheDefeito filtro){
		
		List<DwPassdef> listaDefeitosComponentesFiltrada = consultarDefeitosComponentesBanco(filtro);
		
		List<DetalhamentoDefeitoComponenteDTO> listaDefeitosComponentesDTO = getListaDefeitoComponenteDTO(listaDefeitosComponentesFiltrada);
		
		Map<String, DetalhamentoDefeitoComponenteDTO> mapDefeitosComponentesDTO = agruparDefeitosComponentesIguais(listaDefeitosComponentesDTO);
		
		List<GraficoParettoDefeitoComponenteDTO> listaParretoDefeitoComponenteDTO = getListaGraficoParettoDefeitoComponenteDTO(mapDefeitosComponentesDTO);
		
		GraficoParettoDefeitosComponentesDTO retornoDTO = new GraficoParettoDefeitosComponentesDTO();
		
		retornoDTO.setDefeitosComponentes(listaParretoDefeitoComponenteDTO);
		
		setIndicador(retornoDTO);
		
		return retornoDTO;
	
	}

	public DetalhamentoDefeitoComponenteDTO getOcorrenciaParettoDefeitoComponente(FiltroDetalheDefeito filtro){
		
		List<DwPassdef> listaDefeitosComponentesFiltrada = consultarDefeitosComponentesBanco(filtro);
		List<DetalhamentoDefeitoComponenteDTO> listaDefeitosComponentesDTO = getListaDefeitoComponenteDTO(listaDefeitosComponentesFiltrada);
		
		DetalhamentoDefeitoComponenteDTO retorno = new DetalhamentoDefeitoComponenteDTO();
		
		retorno.setListaResultadoPesquisa(listaDefeitosComponentesDTO);
		
		return retorno;
	
	}
	
	private Map<String, DetalhamentoDefeitoComponenteDTO> agruparDefeitosComponentesIguais(List<DetalhamentoDefeitoComponenteDTO> listaDefeitosComponentesDTO) {
		
		Map<String, DetalhamentoDefeitoComponenteDTO> map = new HashMap<String, DetalhamentoDefeitoComponenteDTO>();
		
		for(DetalhamentoDefeitoComponenteDTO defeitoComponenteDTO : listaDefeitosComponentesDTO){
			
			String codigoComponente = defeitoComponenteDTO.getCdComponentePosMecanica();
			
			DetalhamentoDefeitoComponenteDTO defeitoComponenteDTOMap = map.get(codigoComponente);			
			
			if(defeitoComponenteDTOMap == null){
				map.put(codigoComponente, defeitoComponenteDTO);
			} else {
				BigDecimal quantidadeTotalAgrupamento = defeitoComponenteDTO.getQuantidade().add(defeitoComponenteDTOMap.getQuantidade());
				defeitoComponenteDTOMap.setQuantidade(quantidadeTotalAgrupamento);
			}
		
		}
		
		return map;
	
	}
	
	private List<GraficoParettoDefeitoComponenteDTO> getListaGraficoParettoDefeitoComponenteDTO(Map<String, DetalhamentoDefeitoComponenteDTO> mapDTO){
		
		BigDecimal quantidadeTotalDefeitoComponente = calcularQuantidadeTotalDefeitoComponente(mapDTO);
		
		List<GraficoParettoDefeitoComponenteDTO> listaRetorno = new ArrayList<>();
		
		for(String chave : mapDTO.keySet()){
			
			DetalhamentoDefeitoComponenteDTO defeitoComponenteDTO = mapDTO.get(chave);
			
			BigDecimal indice = dividir(defeitoComponenteDTO.getQuantidade(), quantidadeTotalDefeitoComponente).multiply(new BigDecimal(100));
			
			GraficoParettoDefeitoComponenteDTO graficoParettoDefeitoComponenteDTO = new GraficoParettoDefeitoComponenteDTO();
			
			graficoParettoDefeitoComponenteDTO.setIndice(indice);
			graficoParettoDefeitoComponenteDTO.setDefeitoComponente(defeitoComponenteDTO);
			
			listaRetorno.add(graficoParettoDefeitoComponenteDTO);
		
		}
		
		return listaRetorno;
	
	}
	
	private BigDecimal calcularQuantidadeTotalDefeitoComponente(Map<String, DetalhamentoDefeitoComponenteDTO> mapDTO) {
		
		BigDecimal contador = BigDecimal.ZERO;
		
		for(String chave : mapDTO.keySet()){
			
			DetalhamentoDefeitoComponenteDTO defeitoComponenteDTO = mapDTO.get(chave);
			
			if(defeitoComponenteDTO.getQuantidade() != null){
				contador = contador.add(defeitoComponenteDTO.getQuantidade());
			}
		
		}
		
		return contador;
	
	}
	
	private List<DetalhamentoDefeitoComponenteDTO> getListaDefeitoComponenteDTO(List<DwPassdef> listaPojo) {
		
		List<DetalhamentoDefeitoComponenteDTO> listaDefeitosComponentesDTO = new ArrayList<>();
		
		for(DwPassdef defeitoComponente : listaPojo){
			
			DetalhamentoDefeitoComponenteDTO defeitoComponenteDTO = new DetalhamentoDefeitoComponenteDTO();
			
			defeitoComponenteDTO.setCdComponente("Não Informado");
			defeitoComponenteDTO.setDsPosicaoMecanica("Não Informado");
			
			if (defeitoComponente.getCdComponente() != null) {
				defeitoComponenteDTO.setCdComponente(defeitoComponente.getCdComponente());	
			}
			
			if (defeitoComponente.getDsPosicaomecanica() != null) {
				defeitoComponenteDTO.setDsPosicaoMecanica(defeitoComponente.getDsPosicaomecanica());	
			}
			
			defeitoComponenteDTO.setCdComponentePosMecanica(defeitoComponenteDTO.getCdComponente().concat(defeitoComponenteDTO.getDsPosicaoMecanica()));
			defeitoComponenteDTO.setQuantidade(BigDecimal.ONE);
			
			listaDefeitosComponentesDTO.add(defeitoComponenteDTO);
		
		}
		
		return listaDefeitosComponentesDTO;
	
	}
	
	private GraficoParettoDefeitosComponentesDTO setIndicador(GraficoParettoDefeitosComponentesDTO dto){
		
		if(dto == null){
			return dto;
		}
		
		OmCfgind indicador = getIndicador(ID_INDICADOR_DEFEITO_COMPONENTE);
		
		if(indicador == null){
			return dto;
		}
		
		dto.setIndSuperior(indicador.getIndSuperior());
		dto.setIndMeta(indicador.getIndMeta());
		dto.setIndInferior(indicador.getIndInferior());
		
		return dto;
	
	}
	
	private List<DwPassdef> consultarDefeitosComponentesBanco(FiltroDetalheDefeito filtro){
		
		MapQuery q = new MapQuery(getDaoSession());
		/*
		select passdef.cd_componente, passdef.ds_posicaomecanica
		  from dw_passdef passdef, dw_passagem passagem, dw_consolid consolid
		 where passdef.id_passagem  = passagem.id_passagem
		   and passagem.id_consolid = consolid.id_consolid
		   and consolid.tp_id    = 1
		   and consolid.dt_referencia between '2018-08-03' and '2018-08-03'
		   and consolid.id_turno = 4
		   and consolid.id_pt = 518
		group by passdef.cd_componente, passdef.ds_posicaomecanica		
		*/
		q.append("select distinct passDef");
		q.append("from DwPassdef passDef");
		q.append("join passDef.dwPassagem passagem");
		q.append("join passDef.dwTDefeito defeito");
		q.append("join passagem.dwConsolid consolid");
		q.append("where 1 = 1");
		
		if(filtro.getTpId() != null){
			q.append("and consolid.tpId = :tpId");
		}
		
		if(filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null) {
			q.append("and consolid.dtReferencia between :dtinicial and :dtfinal");
		} else if(filtro.getDtReferenciaInicial() != null) {
			q.append("and consolid.dtReferencia = :dtinicial");
		} else {
			q.append("and consolid.dtReferencia = :dtfinal");
		}
		
		if(filtro.getDwTurno() != null){
			q.append("and consolid.dwTurno.idTurno = :idturno");
		}
		
		if(filtro.getOmPt() != null){
			q.append("and consolid.omPt.cdPt = :cdpt");
		}
		
		if(filtro.getPpCp() != null){
			q.append("and consolid.ppCp.cdCp = :cdcp");
		}
		
		if(filtro.getCodigoDefeito() != null){
			q.append("and defeito.cdTdefeito = :codigoDefeito");
		}

		if(filtro.getTpId() != null){
			q.defineParametro("tpId", filtro.getTpId());
		}
		
		if(filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null) {
			q.defineParametro("dtinicial", filtro.getDtReferenciaInicial());
			q.defineParametro("dtfinal", filtro.getDtReferenciaFinal());
		} else if(filtro.getDtReferenciaInicial() != null) {
			q.defineParametro("dtinicial", filtro.getDtReferenciaInicial());
		} else {
			q.defineParametro("dtfinal", filtro.getDtReferenciaFinal());
		}
		
		if(filtro.getDwTurno() != null){
			q.defineParametro("idturno", filtro.getDwTurno().getIdTurno());
		}
		
		if(filtro.getOmPt() != null){
			q.defineParametro("cdpt", filtro.getOmPt().getCdPt());
		}
		
		if(filtro.getPpCp() != null){
			q.defineParametro("cdcp", filtro.getPpCp().getCdCp());
		}
		
		if(filtro.getCodigoDefeito() != null){
			q.defineParametro("codigoDefeito", filtro.getCodigoDefeito());
		}
		
		List<DwPassdef> lista = q.list();
		
		return lista;
	
	}
	
	private BigDecimal dividir(BigDecimal dividendo, BigDecimal divisor) {
		
		if(dividendo == null || divisor == null) {
			return BigDecimal.ZERO;
		}
		
		if(divisor.doubleValue() == 0) {
			return BigDecimal.ZERO;
		}
		
		return dividendo.divide(divisor, MathContext.DECIMAL32);
	
	}
	
	public OmCfgind getIndicador(long idIndicador) {
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select indicador");
		q.append("from OmCfgind indicador");
		q.append("where indicador.idCfgind = :idIndicador");
				
		q.defineParametro("idIndicador", idIndicador);
		
		return (OmCfgind) q.uniqueResult();
		
	}
	
}