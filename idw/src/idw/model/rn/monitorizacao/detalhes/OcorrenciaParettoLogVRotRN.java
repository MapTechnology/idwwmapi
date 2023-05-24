package idw.model.rn.monitorizacao.detalhes;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsoldef;
import idw.model.pojos.OmCfgind;
import idw.model.rn.AbstractRN;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoLogVRotDTO;
import idw.model.rn.monitorizacao.detalhes.dto.GraficoParettoLogVRotSDTO;
import idw.util.IdwLogger;
import idw.webservices.dto.DetalhamentoLogVRotDTO;
import idw.webservices.dto.FiltroDetalheLogVRotDTO;
import idw.webservices.dto.SerieParettoDTO;

public class OcorrenciaParettoLogVRotRN extends AbstractRN<DAOGenerico> {
	
	public static final long ID_INDICADOR_LOGVROT = 1;

	public OcorrenciaParettoLogVRotRN() {
		super(new DAOGenerico());
	}
	
	public OcorrenciaParettoLogVRotRN(DAOGenerico dao) {
		super(dao);
	}
	
	//WS
	public GraficoParettoLogVRotSDTO getGraficoParettoLogVRotRN(FiltroDetalheLogVRotDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "OcorrenciaParettoLogVRotRN.getGraficoParettoLogVRotRN");
		log.info( idLog , 0, "OcorrenciaParettoLogVRotRN.getGraficoParettoLogVRotRN filtro usado:" + filtro.toString());
		
		int i=0;
		List<SerieParettoDTO>  listSerieparettoLogsdto = null;
		List<SerieParettoDTO>  listSerieparettoPassdto = null;
		
		Calendar param_cal1 = new GregorianCalendar();
		Calendar param_cal2 = new GregorianCalendar();
		String sdt1 = "";
		String sdt2 = "";
		String param_cdTurno = "";
		String param_cdGt = "";
		SimpleDateFormat formatoDtHr = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );
		SimpleDateFormat formatoDt = new SimpleDateFormat( "dd/MM/yyyy" );

		
		if (
				filtro!=null 
				&& filtro.getDtReferenciaInicial()!=null 
				&& filtro.getOmGt()!=null
				&& filtro.getOmGt().getCdGt()!=null
				&& filtro.getDwTurno()!=null
				&& filtro.getDwTurno().getCdTurno()!=null
			){

			try{
				param_cal1.setTime( filtro.getDtReferenciaInicial() );
				param_cal2.setTime( filtro.getDtReferenciaInicial() );
				sdt1  = formatoDt.format(param_cal1.getTime()) + " 00:00"; //tsthardcodedtemp(identificar turno corretamente)
				sdt2  = formatoDt.format(param_cal1.getTime()) + " 23:59"; //tsthardcodedtemp(identificar turno corretamente)
				param_cal1.setTime(formatoDtHr.parse(sdt1));
				param_cal2.setTime(formatoDtHr.parse(sdt2));
			}catch(Exception e){
			}
			
			param_cdTurno = filtro.getDwTurno().getCdTurno();
			param_cdGt = filtro.getOmGt().getCdGt();
		} else {
			return null;
		}

		/* TESTES HARDCODED
		try{
			//Teste tst hard-coded - Passagens
			Calendar cal1 = new GregorianCalendar();
			Calendar cal2 = new GregorianCalendar();
			SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );
			cal1.setTime(formato.parse("03/08/2018 07:00"));
			cal2.setTime(formato.parse("03/08/2018 15:20"));
			listSerieparettoPassdto = this.getSeriesParettoPassagensQC("1","HIKVISION",cal1.getTime(), cal2.getTime());
			i=0;			
		}catch(Exception e){
		}	
		try{
			//Teste tst hard-coded - LOgs
			Calendar cal1 = new GregorianCalendar();
			Calendar cal2 = new GregorianCalendar();
			SimpleDateFormat formato = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );
			cal1.setTime(formato.parse("15/01/2019 07:00"));
			cal2.setTime(formato.parse("15/01/2019 19:30"));
			listSerieparettoLogsdto = this.getSeriesParettoLogsvrot("0","FABRICA",cal1.getTime(), cal2.getTime());
			i=0;
		}catch(Exception e){
		}
		*/
		
		try{
			//Teste tst hard-coded - Passagens
			listSerieparettoPassdto = this.getSeriesParettoPassagensQC(param_cdTurno,param_cdGt,param_cal1.getTime(), param_cal2.getTime());
			i=0;			
		}catch(Exception e){
		}	
		try{
			//Teste tst hard-coded - LOgs
			listSerieparettoLogsdto = this.getSeriesParettoLogsvrot(param_cdTurno,param_cdGt,param_cal1.getTime(), param_cal2.getTime());
			i=0;
		}catch(Exception e){
		}
		
		
		List<SerieParettoDTO>  listSerieparettoFINALdto = null;
		if (listSerieparettoPassdto!=null && listSerieparettoPassdto.size()>0){
			
			listSerieparettoFINALdto = new ArrayList<SerieParettoDTO>();
			int conta = 0;
			for (SerieParettoDTO p : listSerieparettoPassdto){
				conta++;
				
				SerieParettoDTO novo = new SerieParettoDTO();
				novo.setElemento(p.getElemento());
				novo.setQtdeApontamento(p.getQtdeApontamento());
				Double qL = new Double(0L);
				for (SerieParettoDTO iL : listSerieparettoLogsdto){
					if(iL.equals(p.getElemento())){
						qL = iL.getQtdeApontamento();
						break;
					}
				}
				if (p.getQtdeApontamento()!=null && p.getQtdeApontamento().doubleValue()>0.0){
					novo.setQtdeApontamento(qL.doubleValue()/p.getQtdeApontamento().doubleValue());					
				}else{
					novo.setQtdeApontamento(new Double(0L));
				}
				novo.setQtdeApontamento(novo.getQtdeApontamento().doubleValue()*100); //%
				
				//Tsthardcoded novo.setQtdeApontamento( new Double(( conta*5) ));//TESTE
				
				listSerieparettoFINALdto.add(novo);
			}
			
		}
		
		//NAOaqui nList<DwConsoldef> listaPojosFiltrada = consultarLogVRotBanco(filtro);
		List<DetalhamentoLogVRotDTO> listaItensDTO = getListaLogVRotDTODeSerie(listSerieparettoFINALdto);
		Map<String, DetalhamentoLogVRotDTO> mapItensDTO = agruparItensIguais(listaItensDTO);
		List<GraficoParettoLogVRotDTO> listaParettoItemDTO = getListaGraficoParettoLogVRotDTO(mapItensDTO);
		
		GraficoParettoLogVRotSDTO retornoDTO = new GraficoParettoLogVRotSDTO();
		retornoDTO.setItens(listaParettoItemDTO);
		setIndicador(retornoDTO);
		log.mostrarAvaliacaoCompleta();
		return retornoDTO;
	}

	public DetalhamentoLogVRotDTO getOcorrenciaParettoLogVRot(FiltroDetalheLogVRotDTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "OcorrenciaParettoLogVRotRN.getOcorrenciaParettoLogVRot");
		log.info( idLog , 0, "OcorrenciaParettoLogVRotRN.getOcorrenciaParettoLogVRot filtro usado:" + filtro.toString());
		
		List<DwConsoldef> listaPojosFiltrada = consultarLogVRotBanco(filtro);
		List<DetalhamentoLogVRotDTO> listaItensDTO = getListaLogVRotDTO(listaPojosFiltrada);
		
		DetalhamentoLogVRotDTO retorno = new DetalhamentoLogVRotDTO();
		retorno.setListaResultadoPesquisa(listaItensDTO);
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	private Map<String, DetalhamentoLogVRotDTO> agruparItensIguais(List<DetalhamentoLogVRotDTO> listaItensDTO){
		Map<String, DetalhamentoLogVRotDTO> map = new HashMap<String, DetalhamentoLogVRotDTO>();
		for(DetalhamentoLogVRotDTO itemDTO : listaItensDTO){
			String codigoItem = itemDTO.getCodigoItem();
			DetalhamentoLogVRotDTO itemDTOMap = map.get(codigoItem);			
			if(itemDTOMap == null){
				map.put(codigoItem, itemDTO);
			} else {
				BigDecimal quantidadeTotalAgrupamento = itemDTO.getQuantidade().add(itemDTOMap.getQuantidade());
				itemDTOMap.setQuantidade(quantidadeTotalAgrupamento);
			}
		}
		return map;
	}
	
	private List<GraficoParettoLogVRotDTO> getListaGraficoParettoLogVRotDTO(Map<String, DetalhamentoLogVRotDTO> mapDTO){
		//NAO-aqui-usar-100% BigDecimal quantidadeTotalMapeamento = calcularQuantidadeTotalLogVRot(mapDTO);
		BigDecimal quantidadeTotalMapeamento = new BigDecimal(100L);
		List<GraficoParettoLogVRotDTO> listaRetorno = new ArrayList<>();
		for(String chave : mapDTO.keySet()){
			DetalhamentoLogVRotDTO itemDTO = mapDTO.get(chave);
			BigDecimal indice = dividir(itemDTO.getQuantidade(), quantidadeTotalMapeamento).multiply(new BigDecimal(100));
			GraficoParettoLogVRotDTO graficoparettoLogvrotDTO = new GraficoParettoLogVRotDTO();
			graficoparettoLogvrotDTO.setIndice(indice);
			graficoparettoLogvrotDTO.setItemDetalhe(itemDTO);
			listaRetorno.add(graficoparettoLogvrotDTO);
		}
		return listaRetorno;
	}
	
	private BigDecimal calcularQuantidadeTotalLogVRot(Map<String, DetalhamentoLogVRotDTO> mapDTO){
		BigDecimal contador = BigDecimal.ZERO;
		for(String chave : mapDTO.keySet()){
			DetalhamentoLogVRotDTO itemDTO = mapDTO.get(chave);
			if(itemDTO.getQuantidade() != null){
				contador = contador.add(itemDTO.getQuantidade());
			}
		}
		return contador;
	}
	
	private List<DetalhamentoLogVRotDTO> getListaLogVRotDTODeSerie(List<SerieParettoDTO> listaSeries){
		List<DetalhamentoLogVRotDTO> listaItensDTO = new ArrayList<>();
		for(SerieParettoDTO itemserie : listaSeries){
			DetalhamentoLogVRotDTO itemDTO = new DetalhamentoLogVRotDTO();
			itemDTO.setPosto(itemserie.getElemento());
			itemDTO.setFerramenta("");
			itemDTO.setCodigoItem(itemserie.getElemento());
			itemDTO.setDescricaoItem(itemserie.getElemento());
			itemDTO.setCodigoProduto("");
			itemDTO.setDescricaoProduto("");		
			itemDTO.setQuantidade( new BigDecimal( itemserie.getQtdeApontamento().doubleValue() ));
			itemDTO.setArea("");
			itemDTO.setDtReferencia(null);
			itemDTO.setTurno("");
			listaItensDTO.add(itemDTO);
		}
		return listaItensDTO;
	}
	
	private List<DetalhamentoLogVRotDTO> getListaLogVRotDTO(List<DwConsoldef> listaPojo){
		List<DetalhamentoLogVRotDTO> listaItensDTO = new ArrayList<>();
		for(DwConsoldef itempojo : listaPojo){
			DetalhamentoLogVRotDTO itemDTO = new DetalhamentoLogVRotDTO();
			itemDTO.setPosto(itempojo.getDwConsol().getDwConsolid().getOmPt().getCd());
			itemDTO.setFerramenta(itempojo.getDwConsol().getDwConsolid().getDwFolha().getCdFolha());
			itemDTO.setCodigoItem(itempojo.getDwTDefeito().getCdTdefeito());
			itemDTO.setDescricaoItem(itempojo.getDwTDefeito().getDsTdefeito());
			if (itempojo.getDwTDefeito() != null && itempojo.getDwTDefeito().getOmProduto() != null) {
				itemDTO.setCodigoProduto(itempojo.getDwTDefeito().getOmProduto().getCdProduto());
				itemDTO.setDescricaoProduto(itempojo.getDwTDefeito().getOmProduto().getDsProduto());			
			} else {
				itemDTO.setCodigoProduto("");
				itemDTO.setDescricaoProduto("");
			}
			
			itemDTO.setQuantidade(itempojo.getQtDefeitos());
			if (itempojo.getDwTArea() != null)
				itemDTO.setArea(itempojo.getDwTArea().getCd() + " - " + itempojo.getDwTArea().getDsArea());
			else
				itemDTO.setArea("");
			itemDTO.setDtReferencia(itempojo.getDwConsol().getDwConsolid().getDtReferencia());
			itemDTO.setTurno(itempojo.getDwConsol().getDwConsolid().getDwTurno().getDsTurno());
			listaItensDTO.add(itemDTO);
		}
		return listaItensDTO;
	}
	
	
	private GraficoParettoLogVRotSDTO setIndicador(GraficoParettoLogVRotSDTO dto){
		if(dto == null){
			return dto;
		}
		
		OmCfgind indicador = getIndicador(ID_INDICADOR_LOGVROT);
		if(indicador == null){
			return dto;
		}
		
		dto.setIndSuperior(indicador.getIndSuperior());
		dto.setIndMeta(indicador.getIndMeta());
		dto.setIndInferior(indicador.getIndInferior());
		return dto;
	}
	
	private List<DwConsoldef> consultarLogVRotBanco( FiltroDetalheLogVRotDTO filtro){


		
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
		
		if(filtro.getCodigoItem() != null){
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
		
		if(filtro.getCodigoItem() != null){
			q.defineParametro("codigoDefeito", filtro.getCodigoItem());
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
		q.append("WHERE indicador.idCfgind = :idIndicador");
				
		q.defineParametro("idIndicador", idIndicador);
		
		return (OmCfgind) q.uniqueResult();
	}
	
	
	public List<SerieParettoDTO> getSeriesParettoLogsvrot(String cdTurno, String cdGt, Date dthr1, Date dthr2 ) {
		// Retorna Lista com qt de simples ocorrências por PT
		MapQuery q = new MapQuery(getDaoSession());

		List<SerieParettoDTO> retorno = new ArrayList<SerieParettoDTO>();

		q.append("select pt.cdPt as cd, count (a.dthrLog)  as qt ");
		q.append("from DwLogvalroteiro a ");
		q.append("join a.dwTurno t ");
		q.append("join a.omPt pt ");
		q.append("join pt.omTppt tppt ");
		q.append("join pt.omGt gt ");
		q.append("where ");
		q.append("1=1 ");
		q.append("and a.dthrLog between :DtHr1 and :DtHr2 ");
		q.append("and t.cdTurno= :cdTurno ");
		q.append("and t.stAtivo=1 ");
		q.append("and gt.cdGt= :cdGt ");
		q.append("and gt.stAtivo=1 ");
		q.append("and tppt.cdTppt in ( 'PVE', 'PTD', 'PT', '24G', '5G', 'TX', 'RX', 'SSID', 'FTP', 'PKFT', 'HPNA', 'WC', 'FQC') ");
		q.append("group by pt.cdPt ");
		q.append("order by pt.cdPt ");
		q.append(" ");

		q.defineParametro("cdTurno", cdTurno);
		q.defineParametro("cdGt", cdGt);
		q.defineParametroTimestamp("DtHr1", dthr1);
		q.defineParametroTimestamp("DtHr2", dthr2);
		q.setMaxResults(200);

		Iterator itResultados = q.list().iterator();

		while ( itResultados.hasNext() ) {
			Object[] itemdalista = (Object[]) itResultados.next();
			
			String cd = (String) itemdalista[0];
			Double qt =  ( (Long)  itemdalista[1]).doubleValue();
			
			SerieParettoDTO itemRetorno = new SerieParettoDTO();
			itemRetorno.setElemento(cd);
			itemRetorno.setQtdeApontamento(qt);
			retorno.add(itemRetorno);
		}

		return retorno;

	}
	
	
	public List<SerieParettoDTO> getSeriesParettoPassagensQC(String cdTurno, String cdGt, Date dthr1, Date dthr2 ) {
		// Retorna Lista com qt de simples ocorrências por PT
		MapQuery q = new MapQuery(getDaoSession());

		List<SerieParettoDTO> retorno = new ArrayList<SerieParettoDTO>();

		q.append("select pt.cdPt as cd, count (a.dthr)  as qt ");
		q.append("from DwPassagem a ");
		q.append("join a.dwConsolid b ");
		q.append("join b.dwTurno t ");
		q.append("join a.omPt pt ");
		q.append("join pt.omTppt tppt ");
		q.append("join pt.omGt gt ");
		q.append("where ");
		q.append("1=1 ");
		q.append("and a.dthr between :DtHr1 and :DtHr2 ");
		q.append("and t.cdTurno= :cdTurno ");
		q.append("and t.stAtivo=1 ");
		q.append("and gt.cdGt= :cdGt ");
		q.append("and gt.stAtivo=1 ");
		q.append("and tppt.cdTppt in ( 'PVE', 'PTD', 'PT', '24G', '5G', 'TX', 'RX', 'SSID', 'FTP', 'PKFT', 'HPNA', 'WC', 'FQC') ");
		q.append("group by pt.cdPt ");
		q.append("order by pt.cdPt ");
		q.append(" ");

		q.defineParametro("cdTurno", cdTurno);
		q.defineParametro("cdGt", cdGt);
		q.defineParametroTimestamp("DtHr1", dthr1);
		q.defineParametroTimestamp("DtHr2", dthr2);
		q.setMaxResults(200);

		Iterator itResultados = q.list().iterator();

		while ( itResultados.hasNext() ) {
			Object[] itemdalista = (Object[]) itResultados.next();
			
			String cd = (String) itemdalista[0];
			Double qt =  ( (Long)  itemdalista[1]).doubleValue();
			
			SerieParettoDTO itemRetorno = new SerieParettoDTO();
			itemRetorno.setElemento(cd);
			itemRetorno.setQtdeApontamento(qt);
			retorno.add(itemRetorno);
		}

		return retorno;

	}
	
/*
 * 
 * 
 * 	
 */
	
}
