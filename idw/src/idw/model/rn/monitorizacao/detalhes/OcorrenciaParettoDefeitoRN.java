package idw.model.rn.monitorizacao.detalhes;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsoldef;
import idw.model.pojos.OmCfgind;
import idw.model.rn.AbstractRN;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoDefeitoDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoDefeitosDTO;
import idw.util.IdwLogger;
import idw.webservices.dto.DetalhamentoDefeitoDTO;
import idw.webservices.dto.FiltroDetalheDefeito;

public class OcorrenciaParettoDefeitoRN extends AbstractRN<DAOGenerico> {
	
	public static final long ID_INDICADOR_DEFEITO = 1;

	public OcorrenciaParettoDefeitoRN() {
		super(new DAOGenerico());
	}
	
	public OcorrenciaParettoDefeitoRN(DAOGenerico dao) {
		super(dao);
	}
	
	public GraficoParettoDefeitosDTO getGraficoParettoDefeito(FiltroDetalheDefeito filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "OcorrenciaParettoDefeitoRN.getGraficoParettoDefeito");
		log.info( idLog , 0, "OcorrenciaParettoDefeitoRN.getGraficoParettoDefeito filtro usado:" + filtro.toString());
		
		List<DwConsoldef> listaDefeitosFiltrada = consultarDefeitosBanco(filtro);
		List<DetalhamentoDefeitoDTO> listaDefeitosDTO = getListaDefeitoDTO(listaDefeitosFiltrada);
		Map<String, DetalhamentoDefeitoDTO> mapDefeitosDTO = agruparDefeitosIguais(listaDefeitosDTO);
		List<GraficoParettoDefeitoDTO> listaParretoDefeitoDTO = getListaGraficoParettoDefeitoDTO(mapDefeitosDTO);
		
		GraficoParettoDefeitosDTO retornoDTO = new GraficoParettoDefeitosDTO();
		retornoDTO.setDefeitos(listaParretoDefeitoDTO);
		setIndicador(retornoDTO);
		log.mostrarAvaliacaoCompleta();
		return retornoDTO;
	}

	public DetalhamentoDefeitoDTO getOcorrenciaParettoDefeito(FiltroDetalheDefeito filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "OcorrenciaParettoDefeitoRN.getOcorrenciaParettoDefeito");
		log.info( idLog , 0, "OcorrenciaParettoDefeitoRN.getOcorrenciaParettoDefeito filtro usado:" + filtro.toString());
		
		List<DwConsoldef> listaDefeitosFiltrada = consultarDefeitosBanco(filtro);
		List<DetalhamentoDefeitoDTO> listaDefeitosDTO = getListaDefeitoDTO(listaDefeitosFiltrada);
		
		DetalhamentoDefeitoDTO retorno = new DetalhamentoDefeitoDTO();
		retorno.setListaResultadoPesquisa(listaDefeitosDTO);
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	private Map<String, DetalhamentoDefeitoDTO> agruparDefeitosIguais(List<DetalhamentoDefeitoDTO> listaDefeitosDTO){
		Map<String, DetalhamentoDefeitoDTO> map = new HashMap<String, DetalhamentoDefeitoDTO>();
		for(DetalhamentoDefeitoDTO defeitoDTO : listaDefeitosDTO){
			String codigoDefeito = defeitoDTO.getCodigoDefeito();
			DetalhamentoDefeitoDTO defeitoDTOMap = map.get(codigoDefeito);			
			if(defeitoDTOMap == null){
				map.put(codigoDefeito, defeitoDTO);
			} else {
				BigDecimal quantidadeTotalAgrupamento = defeitoDTO.getQuantidade().add(defeitoDTOMap.getQuantidade());
				defeitoDTOMap.setQuantidade(quantidadeTotalAgrupamento);
			}
		}
		return map;
	}
	
	private List<GraficoParettoDefeitoDTO> getListaGraficoParettoDefeitoDTO(Map<String, DetalhamentoDefeitoDTO> mapDTO){
		BigDecimal quantidadeTotalDefeito = calcularQuantidadeTotalDefeito(mapDTO);
		List<GraficoParettoDefeitoDTO> listaRetorno = new ArrayList<>();
		for(String chave : mapDTO.keySet()){
			DetalhamentoDefeitoDTO defeitoDTO = mapDTO.get(chave);
			BigDecimal indice = dividir(defeitoDTO.getQuantidade(), quantidadeTotalDefeito).multiply(new BigDecimal(100));
			GraficoParettoDefeitoDTO graficoParettoDefeitoDTO = new GraficoParettoDefeitoDTO();
			graficoParettoDefeitoDTO.setIndice(indice);
			graficoParettoDefeitoDTO.setDefeito(defeitoDTO);
			listaRetorno.add(graficoParettoDefeitoDTO);
		}
		return listaRetorno;
	}
	
	private BigDecimal calcularQuantidadeTotalDefeito(Map<String, DetalhamentoDefeitoDTO> mapDTO){
		BigDecimal contador = BigDecimal.ZERO;
		for(String chave : mapDTO.keySet()){
			DetalhamentoDefeitoDTO defeitoDTO = mapDTO.get(chave);
			if(defeitoDTO.getQuantidade() != null){
				contador = contador.add(defeitoDTO.getQuantidade());
			}
		}
		return contador;
	}
	
	private List<DetalhamentoDefeitoDTO> getListaDefeitoDTO(List<DwConsoldef> listaPojo){
		List<DetalhamentoDefeitoDTO> listaDefeitosDTO = new ArrayList<>();
		for(DwConsoldef defeito : listaPojo){
			DetalhamentoDefeitoDTO defeitoDTO = new DetalhamentoDefeitoDTO();
			defeitoDTO.setPosto(defeito.getDwConsol().getDwConsolid().getOmPt().getCd());
			defeitoDTO.setFerramenta(defeito.getDwConsol().getDwConsolid().getDwFolha().getCdFolha());
			defeitoDTO.setCodigoDefeito(defeito.getDwTDefeito().getCdTdefeito());
			defeitoDTO.setDescricaoDefeito(defeito.getDwTDefeito().getDsTdefeito());
			if (defeito.getDwTDefeito() != null && defeito.getDwTDefeito().getOmProduto() != null) {
				defeitoDTO.setCodigoProduto(defeito.getDwTDefeito().getOmProduto().getCdProduto());
				defeitoDTO.setDescricaoProduto(defeito.getDwTDefeito().getOmProduto().getDsProduto());			
			} else {
				defeitoDTO.setCodigoProduto("");
				defeitoDTO.setDescricaoProduto("");
			}
			
			defeitoDTO.setQuantidade(defeito.getQtDefeitos());
			if (defeito.getDwTArea() != null)
				defeitoDTO.setArea(defeito.getDwTArea().getCd() + " - " + defeito.getDwTArea().getDsArea());
			else
				defeitoDTO.setArea("");
			defeitoDTO.setDtReferencia(defeito.getDwConsol().getDwConsolid().getDtReferencia());
			defeitoDTO.setTurno(defeito.getDwConsol().getDwConsolid().getDwTurno().getDsTurno());
			listaDefeitosDTO.add(defeitoDTO);
		}
		return listaDefeitosDTO;
	}
	
	private GraficoParettoDefeitosDTO setIndicador(GraficoParettoDefeitosDTO dto){
		if(dto == null){
			return dto;
		}
		
		OmCfgind indicador = getIndicador(ID_INDICADOR_DEFEITO);
		if(indicador == null){
			return dto;
		}
		
		dto.setIndSuperior(indicador.getIndSuperior());
		dto.setIndMeta(indicador.getIndMeta());
		dto.setIndInferior(indicador.getIndInferior());
		return dto;
	}
	
	private List<DwConsoldef> consultarDefeitosBanco(FiltroDetalheDefeito filtro){


		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolDefeito");
		q.append("FROM DwConsoldef consolDefeito");
		q.append("JOIN consolDefeito.dwTDefeito defeito");
		q.append("JOIN consolDefeito.dwConsol consol");
		q.append("left JOIN consolDefeito.dwTArea area");
		q.append("JOIN consol.dwConsolid consolid");
		q.append("join consolid.omPt ompt");
		q.append("left join ompt.omObjs omobj");
		q.append("left join omobj.omGtByIdGt omgt");
		q.append("WHERE 1=1");
		
		if(filtro.getTpId() != null){
			q.append("AND consolid.tpId = :tpId");
		}
		
		if(filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null){
			q.append("AND consolid.dtReferencia BETWEEN :dtinicial AND :dtfinal");
		} else if(filtro.getDtReferenciaInicial() != null){
			q.append("AND consolid.dtReferencia = :dtinicial");
		} else {
			q.append("AND consolid.dtReferencia = :dtfinal");
		}
		
		if(filtro.getDwTurno() != null){
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}
		
		if(filtro.getOmPt() != null){
			q.append("AND consolid.omPt.cdPt = :cdpt");
		}
		
		if(filtro.getPpCp() != null){
			q.append("AND consolid.ppCp.cdCp = :cdcp");
		}
		
		if(filtro.getOmGt() != null){
			q.append("AND omgt.cdGt = :cdGt");
		}

		if(filtro.getDwtarea() != null){
			q.append("AND area.cdArea = :codigoArea");
		}
		
		if(filtro.getOmProduto() != null){
			q.append("AND defeito.omProduto.cdProduto = :codigoProduto");
		}
		
		if(filtro.getCodigoDefeito() != null){
			q.append("AND defeito.cdTdefeito = :codigoDefeito");
		}
		
		//defineParametro
		
		if(filtro.getTpId() != null){
			q.defineParametro("tpId", filtro.getTpId());
		}
		
		if(filtro.getDtReferenciaInicial() != null && filtro.getDtReferenciaFinal() != null){
			q.defineParametro("dtinicial", filtro.getDtReferenciaInicial());
			q.defineParametro("dtfinal", filtro.getDtReferenciaFinal());
		} else if(filtro.getDtReferenciaInicial() != null){
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
		
		if(filtro.getOmGt() != null){
			q.defineParametro("cdGt", filtro.getOmGt().getCdGt());
		}
				
		if(filtro.getDwtarea() != null){
			q.defineParametro("codigoArea", filtro.getDwtarea().getCdArea());
		}
		
		if(filtro.getOmProduto() != null){
			q.defineParametro("codigoProduto", filtro.getOmProduto().getCdProduto());
		}
		
		if(filtro.getCodigoDefeito() != null){
			q.defineParametro("codigoDefeito", filtro.getCodigoDefeito());
		}

		List<DwConsoldef> lista = q.list();
		return lista;
	}
	
	private BigDecimal dividir(BigDecimal dividendo, BigDecimal divisor){
		if(dividendo == null || divisor == null){
			return BigDecimal.ZERO;
		}
		
		if(divisor.doubleValue() == 0){
			return BigDecimal.ZERO;
		}
		
		return dividendo.divide(divisor, MathContext.DECIMAL32);
	}
	
	public OmCfgind getIndicador(long idIndicador) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT indicador");
		q.append("FROM OmCfgind indicador");
		q.append("WHERE indicador.omInd.idInd = :idIndicador");
				
		q.defineParametro("idIndicador", idIndicador);
		
		return (OmCfgind) q.uniqueResult();
	}
}
