package idw.model.rn;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.OmProduto;
import idw.model.rn.detalhemonitorizacao.IndicadoresDoDetalheCiclosRN;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.FiltroRelatorioProdutividadeR42DTO;
import idw.webservices.dto.RelatorioProdutividadeR42DTO;
import ms.util.ConversaoTipos;

public class RelatorioProdutividadeR42RN extends AbstractRN<DAOGenerico> {

	protected FiltroRelatorioProdutividadeR42DTO filtroReport;
	
	public RelatorioProdutividadeR42RN() {
		this(null);
	}
	
	public RelatorioProdutividadeR42RN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	

	// metodo principal para gerar relatorio
	public RelatorioProdutividadeR42DTO getRelatorioProdutividadeR42DTO(FiltroRelatorioProdutividadeR42DTO filtro){
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioProdutividadeR42RN.getRelatorioProdutividadeR42DTO");
		log.info( idLog , 0, "RelatorioProdutividadeR42RN.getRelatorioProdutividadeR42DTO filtro usado:" + filtro.toString());
		
		this.filtroReport = filtro;
		
		RelatorioProdutividadeR42DTO retorno = new RelatorioProdutividadeR42DTO();
		
		List<DwConsolid> resultadoDaConsulta = consultaRelatorioProdutividadeR42(filtro);
				
		BigDecimal segundosTempoAtivoTotal = BigDecimal.ZERO;
		BigDecimal segundosCicloProdutivosTotal = BigDecimal.ZERO;
		BigDecimal segundosCicloImprodutivosTotal = BigDecimal.ZERO;
		BigDecimal segundosHorasTrabalhadasTotal = BigDecimal.ZERO;
		BigDecimal segundosHorasParadasTotal = BigDecimal.ZERO;
		BigDecimal segundosProducaoBoaTotal = BigDecimal.ZERO;
		BigDecimal segundosRefugosTotal = BigDecimal.ZERO;
		BigDecimal segundosPerdasCicloTotal = BigDecimal.ZERO;
		BigDecimal segundosPCITotal = BigDecimal.ZERO;
		
		BigDecimal pecaTempoAtivoTotal = BigDecimal.ZERO;
		BigDecimal pecaCicloProdutivoTotal = BigDecimal.ZERO;
		BigDecimal pecaCicloImprodutivoTotal = BigDecimal.ZERO;
		BigDecimal pecaHorasTrabalhadasTotal = BigDecimal.ZERO;
		BigDecimal pecaHorasParadasTotal = BigDecimal.ZERO;
		BigDecimal pecaProducaoBoaTotal = BigDecimal.ZERO;
		BigDecimal pecaRefugosTotal = BigDecimal.ZERO;
		BigDecimal pecaPerdasCicloTotal = BigDecimal.ZERO;
		BigDecimal pecaPCITotal = BigDecimal.ZERO;
		
		double pesoKGTempoAtivo = 0;
		double pesoKGCicloProdutivo = 0;
		double pesoKGCicloImprodutivo = 0;
		double pesoKGHorasTrabalhadas = 0;
		double pesoKGHorasParadas = 0;
		double pesoKGProducaoBoa = 0;
		double pesoKGRefugos = 0;
		double pesoKGPerdasCiclo = 0;
		double pesoKGPCI = 0;
		
		double pesoTONTempoAtivo = 0;
		double pesoTONCicloProdutivo = 0;
		double pesoTONCicloImprodutivo = 0;
		double pesoTONHorasTrabalhadas = 0;
		double pesoTONHorasParadas = 0;
		double pesoTONProducaoBoa = 0;
		double pesoTONRefugos = 0;
		double pesoTONPerdasCiclo = 0;
		double pesoTONPCI = 0;
		
		for(DwConsolid consolid : resultadoDaConsulta) {			
			
			BigDecimal cavidadesAtivas = getQuantidadeCavidadesAtivas(consolid);
			
			for(DwConsol consol : consolid.getDwConsols()){
				//BigDecimal cicloPadraoDwConsolId = consol.getSegAutoCiclopadrao();
				
				
				BigDecimal cicloPadrao = BigDecimal.ZERO;
				BigDecimal cicloMedio = BigDecimal.ZERO;
				
				double pesoBrutoGrama = getPesoBrutoProdutoGrama(consol);
				
				cicloPadrao = getBigDecimal(consol.getSegAutoCiclopadrao()).add(cicloPadrao);
				cicloPadrao = getBigDecimal(consol.getSegManuCiclopadrao()).add(cicloPadrao);
				
				cicloMedio = getBigDecimal(consol.getSegAutoCiclomedio()).add(cicloMedio);
				cicloMedio = getBigDecimal(consol.getSegManuCiclomedio()).add(cicloMedio);
				
				// RECUPERANDO A COLUNA TEMPO
				BigDecimal segundosTempoAtivo = BigDecimal.ZERO;
				segundosTempoAtivo = getBigDecimal(consol.getSegAutoTempoativo()).add(segundosTempoAtivo);
				segundosTempoAtivo = getBigDecimal(consol.getSegManuTempoativo()).add(segundosTempoAtivo);
				segundosTempoAtivoTotal = segundosTempoAtivo.add(segundosTempoAtivoTotal);								
				
				BigDecimal segundosCicloProdutivos = BigDecimal.ZERO;
				segundosCicloProdutivos = getBigDecimal(consol.getSegAutoCicloprodutivo()).add(segundosCicloProdutivos);
				segundosCicloProdutivos = getBigDecimal(consol.getSegManuCicloprodutivo()).add(segundosCicloProdutivos);
				segundosCicloProdutivosTotal = segundosCicloProdutivos.add(segundosCicloProdutivosTotal);
				
				BigDecimal segundosCicloImprodutivos = BigDecimal.ZERO;
				segundosCicloImprodutivos = getBigDecimal(consol.getSegAutoCicloimprodutivo()).add(segundosCicloImprodutivos);
				segundosCicloImprodutivos = getBigDecimal(consol.getSegManuCicloimprodutivo()).add(segundosCicloImprodutivos);
				segundosCicloImprodutivosTotal = segundosCicloImprodutivos.add(segundosCicloImprodutivosTotal);
				
				BigDecimal segundosHorasTrabalhadas = BigDecimal.ZERO;
				segundosHorasTrabalhadas = getBigDecimal(consol.getSegAutoTempotrabalhado()).add(segundosHorasTrabalhadas);
				segundosHorasTrabalhadas = getBigDecimal(consol.getSegManuTempotrabalhado()).add(segundosHorasTrabalhadas);
				segundosHorasTrabalhadasTotal = segundosHorasTrabalhadas.add(segundosHorasTrabalhadasTotal);
				
				BigDecimal segundosHorasParadas = BigDecimal.ZERO;
				segundosHorasParadas = getBigDecimal(consol.getSegAutoTempoparadaCp()).add(segundosHorasParadas);
				segundosHorasParadas = getBigDecimal(consol.getSegManuTempoparadaCp()).add(segundosHorasParadas);
				segundosHorasParadasTotal = segundosHorasParadas.add(segundosHorasParadasTotal);
				
				BigDecimal segundosProducaoBoa = BigDecimal.ZERO;
				segundosProducaoBoa = getQuantidadeProduzidaBoaTempo(consol, cavidadesAtivas, cicloMedio).add(segundosProducaoBoa);
				segundosProducaoBoaTotal = segundosProducaoBoa.add(segundosProducaoBoaTotal);
				
				BigDecimal segundosRefugos = BigDecimal.ZERO;
				//Marcos Sardinha: 2017-08-11 >> Defeito #4341
				//segundosRefugos =  getQuantidadeRefugadaTempo(consol, cavidadesAtivas, cicloMedio).add(segundosRefugos);
				segundosRefugos = getBigDecimal(consol.getSegAutoTemporefugadas()).add(segundosRefugos);
				segundosRefugos = getBigDecimal(consol.getSegManuTemporefugadas()).add(segundosRefugos);
				segundosRefugosTotal = segundosRefugos.add(segundosRefugosTotal);
				
				BigDecimal segundosPerdasCiclo = BigDecimal.ZERO;
				segundosPerdasCiclo = getBigDecimal(consol.getSegAutoPerdaciclo()).add(segundosPerdasCiclo);
				segundosPerdasCiclo = getBigDecimal(consol.getSegManuPerdaciclo()).add(segundosPerdasCiclo);
				segundosPerdasCicloTotal = segundosPerdasCiclo.add(segundosPerdasCicloTotal);
				
				BigDecimal segundosPCI = BigDecimal.ZERO;
				segundosPCI = getBigDecimal(consol.getSegAutoPerdacav()).add(segundosPCI);
				segundosPCI = getBigDecimal(consol.getSegManuPerdacav()).add(segundosPCI);
				segundosPCITotal = segundosPCI.add(segundosPCITotal);
				
				// RECUPERANDO A COLUNA PECAS
				//Marcos Sardinha: 2017-08-11 >> Defeito #4341
				//BigDecimal pecaTempoAtivo = getPecaTempoAtivo(segundosTempoAtivo, cavidadesAtivas,cicloMedio);
				BigDecimal pecaTempoAtivo =  BigDecimal.ZERO; 
				pecaTempoAtivo = getBigDecimal(consol.getPcsAutoProducaoprevista()).add(pecaTempoAtivo);
				pecaTempoAtivo = getBigDecimal(consol.getPcsManuProducaoprevista()).add(pecaTempoAtivo);
				pecaTempoAtivoTotal = pecaTempoAtivo.add(pecaTempoAtivoTotal);
				
				BigDecimal pecaCicloProdutivo = BigDecimal.ZERO;
				//Marcos Sardinha: 2017-08-11 >> Defeito #4341
				//pecaCicloProdutivo = getBigDecimal(consol.getQtAutoCicloprodutivo()).add(pecaCicloProdutivo);
				//pecaCicloProdutivo = getBigDecimal(consol.getQtManuCicloprodutivo()).add(pecaCicloProdutivo);
				pecaCicloProdutivo = getBigDecimal(consol.getPcsAutoProducaobruta()).add(pecaCicloProdutivo);
				pecaCicloProdutivo = getBigDecimal(consol.getPcsManuProducaobruta()).add(pecaCicloProdutivo);				
				pecaCicloProdutivoTotal = pecaCicloProdutivo.add(pecaCicloProdutivoTotal);
				
				BigDecimal pecaCicloImprodutivo = BigDecimal.ZERO;
				//Marcos Sardinha: 2017-08-11 >> Defeito #4341
				pecaCicloImprodutivo = getBigDecimal(consol.getQtAutoCicloimprodutivo()).add(pecaCicloImprodutivo);
				pecaCicloImprodutivo = getBigDecimal(consol.getQtManuCicloimprodutivo()).add(pecaCicloImprodutivo);
				pecaCicloImprodutivo = pecaCicloImprodutivo.multiply(cavidadesAtivas);
				pecaCicloImprodutivoTotal = pecaCicloImprodutivo.add(pecaCicloImprodutivoTotal);
				
				BigDecimal pecaHorasTrabalhadas = getPecaHorasTrabalhadas(segundosHorasTrabalhadas, cavidadesAtivas, cicloMedio);
				pecaHorasTrabalhadasTotal = pecaHorasTrabalhadas.add(pecaHorasTrabalhadasTotal);
				
				//Marcos Sardinha: 2017-08-11 >> Defeito #4341
				//BigDecimal pecaHorasParadas = getPecaHorasParadas(segundosHorasParadas, cavidadesAtivas, cicloMedio);
				BigDecimal pecaHorasParadas = BigDecimal.ZERO;
				pecaHorasParadas = getBigDecimal(consol.getPcsAutoPerdaparadaCp()).add(pecaHorasParadas);

				
				pecaHorasParadasTotal = pecaHorasParadas.add(pecaHorasParadasTotal);
						
				BigDecimal pecaProducaoBoa = getQuantidadeProduzidaBoaPeca(consol);
				pecaProducaoBoaTotal = pecaProducaoBoa.add(pecaProducaoBoaTotal);
				
				BigDecimal pecaRefugos = getQuantidadeRefugadaPeca(consol);
				pecaRefugosTotal = pecaRefugos.add(pecaRefugosTotal);
				
				BigDecimal pecaPerdasCiclo = getPerdasCicloPeca(consol);
				pecaPerdasCicloTotal = pecaPerdasCiclo.add(pecaPerdasCicloTotal);
				
				BigDecimal pecaPCI = getPerdaPCIPeca(consol);
				pecaPCITotal = pecaPCI.add(pecaPCITotal);
				
				// RECUPERANDO AS COLUNAS PESOS
				double pesoTempoAtivo = pecaTempoAtivo.doubleValue() * pesoBrutoGrama;
				pesoKGTempoAtivo += converterGramaParaKilo(pesoTempoAtivo);
				pesoTONTempoAtivo += converterGramaParaTornelada(pesoTempoAtivo);			
				
				double pesoGramaCicloProdutivo = pecaCicloProdutivo.doubleValue() * pesoBrutoGrama;
				pesoKGCicloProdutivo += converterGramaParaKilo(pesoGramaCicloProdutivo);
				pesoTONCicloProdutivo += converterGramaParaTornelada(pesoGramaCicloProdutivo);
				
				double pesoGramaCicloImprodutivo = pecaCicloImprodutivo.doubleValue() * pesoBrutoGrama;
				pesoKGCicloImprodutivo += converterGramaParaKilo(pesoGramaCicloImprodutivo);
				pesoTONCicloImprodutivo += converterGramaParaTornelada(pesoGramaCicloImprodutivo);
				
				double pesoHorasTrabalhadas = pecaHorasTrabalhadas.doubleValue() * pesoBrutoGrama;
				pesoKGHorasTrabalhadas += converterGramaParaKilo(pesoHorasTrabalhadas);
				pesoTONHorasTrabalhadas += converterGramaParaTornelada(pesoHorasTrabalhadas);		
				
				double pesoHorasParadas = pecaHorasParadas.doubleValue() * pesoBrutoGrama;
				pesoKGHorasParadas += converterGramaParaKilo(pesoHorasParadas);
				pesoTONHorasParadas += converterGramaParaTornelada(pesoHorasParadas);		
				
				double quantidadeProduzidaBoaGramas = getQuantidadeProduzidaBoaGramas(consol);
				pesoKGProducaoBoa += converterGramaParaKilo(quantidadeProduzidaBoaGramas);
				pesoTONProducaoBoa += converterGramaParaTornelada(quantidadeProduzidaBoaGramas);
								
				double quantidadeRefugadaGramas = pecaRefugos.doubleValue() * pesoBrutoGrama;
				pesoKGRefugos += converterGramaParaKilo(quantidadeRefugadaGramas);
				pesoTONRefugos += converterGramaParaTornelada(quantidadeRefugadaGramas);	
				
				double pesoGramaPerdasCiclo = pecaPerdasCiclo.doubleValue() * pesoBrutoGrama;
				pesoKGPerdasCiclo += converterGramaParaKilo(pesoGramaPerdasCiclo);
				pesoTONPerdasCiclo += converterGramaParaTornelada(pesoGramaPerdasCiclo);
				
				double pesoGramaPCI = pecaPCI.doubleValue() * pesoBrutoGrama;
				pesoKGPCI += converterGramaParaKilo(pesoGramaPCI);
				pesoTONPCI += converterGramaParaTornelada(pesoGramaPCI);				
			}
		}
		
		retorno.setTempoAtivoTempo(converterSegundosParaHHMMSS(segundosTempoAtivoTotal.longValue()));
		retorno.setTempoAtivoPeca(ConversaoTipos.converteParaStringComFormat(pecaTempoAtivoTotal.doubleValue(), 4));
		retorno.setTempoAtivoPesoKG(ConversaoTipos.converteParaStringComFormat(pesoKGTempoAtivo, 4));
		retorno.setTempoAtivoPesoTON(ConversaoTipos.converteParaStringComFormat(pesoTONTempoAtivo, 4));	
		
		retorno.setCiclosProdutivosTempo(converterSegundosParaHHMMSS(segundosCicloProdutivosTotal.longValue()));
		retorno.setCiclosProdutivosPeca(ConversaoTipos.converteParaStringComFormat(pecaCicloProdutivoTotal.doubleValue(), 4));
		retorno.setCiclosProdutivosPesoKG(ConversaoTipos.converteParaStringComFormat(pesoKGCicloProdutivo, 4));
		retorno.setCiclosProdutivosPesoTON(ConversaoTipos.converteParaStringComFormat(pesoTONCicloProdutivo, 4));		
		
		retorno.setCiclosImprodutivosTempo(converterSegundosParaHHMMSS(segundosCicloImprodutivosTotal.longValue()));
		retorno.setCiclosImprodutivosPeca(ConversaoTipos.converteParaStringComFormat(pecaCicloImprodutivoTotal.doubleValue(), 4));
		retorno.setCiclosImprodutivosPesoKG(ConversaoTipos.converteParaStringComFormat(pesoKGCicloImprodutivo, 4));
		retorno.setCiclosImprodutivosPesoTON(ConversaoTipos.converteParaStringComFormat(pesoTONCicloImprodutivo, 4));
		
		retorno.setHorasTrabalhadasTempo(converterSegundosParaHHMMSS(segundosHorasTrabalhadasTotal.longValue()));
		retorno.setHorasTrabalhadasPeca(ConversaoTipos.converteParaStringComFormat(pecaHorasTrabalhadasTotal.doubleValue(), 4));
		retorno.setHorasTrabalhadasPesoKG(ConversaoTipos.converteParaStringComFormat(pesoKGHorasTrabalhadas, 4));
		retorno.setHorasTrabalhadasPesoTON(ConversaoTipos.converteParaStringComFormat(pesoTONHorasTrabalhadas, 4));
		
		retorno.setHorasParadasTempo(converterSegundosParaHHMMSS(segundosHorasParadasTotal.longValue()));
		retorno.setHorasParadasPeca(ConversaoTipos.converteParaStringComFormat(pecaHorasParadasTotal.doubleValue(), 4));
		retorno.setHorasParadasPesoKG(ConversaoTipos.converteParaStringComFormat(pesoKGHorasParadas, 4));
		retorno.setHorasParadasPesoTON(ConversaoTipos.converteParaStringComFormat(pesoTONHorasParadas, 4));
		
		retorno.setQuantidadesProduzidaBoaTempo(converterSegundosParaHHMMSS(segundosProducaoBoaTotal.longValue()));
		retorno.setQuantidadesProduzidaBoaPeca(ConversaoTipos.converteParaStringComFormat(pecaProducaoBoaTotal.doubleValue(), 4));
		retorno.setQuantidadesProduzidaBoaPesoKG(ConversaoTipos.converteParaStringComFormat(pesoKGProducaoBoa, 4));
		retorno.setQuantidadesProduzidaBoaPesoTON(ConversaoTipos.converteParaStringComFormat(pesoTONProducaoBoa, 4));
		
		retorno.setRefugosTempo(converterSegundosParaHHMMSS(segundosRefugosTotal.longValue()));
		retorno.setRefugosPeca(ConversaoTipos.converteParaStringComFormat(pecaRefugosTotal.doubleValue(), 4));
		retorno.setRefugosPesoKG(ConversaoTipos.converteParaStringComFormat(pesoKGRefugos, 4));
		retorno.setRefugosPesoTON(ConversaoTipos.converteParaStringComFormat(pesoTONRefugos, 4));
		
		retorno.setPerdasCicloTempo(converterMilisegundosParaHHMMSS(segundosPerdasCicloTotal.longValue()));
		retorno.setPerdasCicloPeca(ConversaoTipos.converteParaStringComFormat(pecaPerdasCicloTotal.doubleValue(), 4));
		retorno.setPerdasCicloPesoKG(ConversaoTipos.converteParaStringComFormat(pesoKGPerdasCiclo, 4));
		retorno.setPerdasCicloPesoTON(ConversaoTipos.converteParaStringComFormat(pesoTONPerdasCiclo, 4));
		
		retorno.setPCITempo(converterSegundosParaHHMMSS(segundosPCITotal.longValue()));		
		retorno.setPCIPeca(ConversaoTipos.converteParaStringComFormat(pecaPCITotal.doubleValue(), 4));
		retorno.setPCIPesoKG(ConversaoTipos.converteParaStringComFormat(pesoKGPCI, 4));
		retorno.setPCIPesoTON(ConversaoTipos.converteParaStringComFormat(pesoTONPCI, 4));
		
		double eficienciaRealizacao = getEficienciaRealizacao(resultadoDaConsulta);
		retorno.setEficienciaRealizadas(ConversaoTipos.converteParaStringComFormat(eficienciaRealizacao, 2)+"%");
		
		double eficienciaCiclo = getEficienciaCiclo(resultadoDaConsulta);
		retorno.setEficienciaCiclo(ConversaoTipos.converteParaStringComFormat(eficienciaCiclo, 2)+"%");
		
		double indiceRefugos = getIndiceRefugos(resultadoDaConsulta);
		retorno.setIndiceRefugos(ConversaoTipos.converteParaStringComFormat(indiceRefugos, 2)+"%");
		
		retorno.setIndiceCavidadesAtivas(ConversaoTipos.converteParaStringComFormat(100d,2) + "%");
		
		double indiceParadas = getIndiceParadas(resultadoDaConsulta);
		retorno.setIndiceParadas(ConversaoTipos.converteParaStringComFormat(indiceParadas, 2)+"%");
		
		double indicePerdas = getIndicePerdas(resultadoDaConsulta);
		retorno.setIndicePerdas(ConversaoTipos.converteParaStringComFormat(indicePerdas, 2)+"%");
		
		double indiceUtilizacao = getIndiceUtilizacao(segundosHorasTrabalhadasTotal, segundosTempoAtivoTotal);
		retorno.setUtilizacao(ConversaoTipos.converteParaStringComFormat(indiceUtilizacao, 2)+"%");
		
		double kgHorasTrabalhada = getKGHorasTrabalhada(segundosHorasTrabalhadasTotal, new BigDecimal(pesoKGHorasTrabalhadas));
		retorno.setHorasTrabalhadas(ConversaoTipos.converteParaStringComFormat(kgHorasTrabalhada, 2));
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	private List<DwConsolid> consultaRelatorioProdutividadeR42(FiltroRelatorioProdutividadeR42DTO filtro){
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.omPt pt");
		//q.append("JOIN consolid.ppCp cp");
		q.append("JOIN consolid.dwFolha folha");
		q.append("left join pt.omObjs omobj");
		q.append("left JOIN folha.dwFolharaps folharap");
		q.append("left JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");
		q.append("WHERE consolid.tpId = :tpId");
		q.append(" AND consolid.stAtivo IS NULL");
		
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.append("AND consolid.dtReferencia BETWEEN :dataincial and :datafinal");
		}
		
		if (filtro.getTurnoDTO() != null) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		} else {
			//Marcos Sardinha: 2017-08-10 >> Defeito #4341
			q.append("AND consolid.dwTurno.idTurno <> 1");
		}
		if(filtro.getOmpt() != null){
			q.append("AND consolid.omPt.cdPt = :cdpt");
		}
		else if(filtro.getOmgt() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idGt");
		}
		if (filtro.getDwRap() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		if (filtro.getGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idGpRap");
		}

		q.defineParametro("tpId", (byte)1);
		
		if(filtro.getPeriodoInicial() != null && filtro.getPeriodoFinal() != null){
			q.defineParametroTimestamp("dataincial", filtro.getPeriodoInicial());
			q.defineParametroTimestamp("datafinal",DataHoraRN.getDataHora235959(filtro.getPeriodoFinal()));
		}
		if (filtro.getTurnoDTO() != null) {
			q.defineParametro("idturno", filtro.getTurnoDTO().getTurno().getIdTurno());
		}
		if (filtro.getOmgt() != null) {
			q.defineParametro("idGt", filtro.getOmgt().getIdGt());
		}
		else if (filtro.getOmpt() != null) {
			q.defineParametro("cdpt", filtro.getOmpt().getCdPt());
		}
		if (filtro.getGrupoFerramenta() != null) {
			q.defineParametro("idGpRap", filtro.getGrupoFerramenta().getIdGrupoFerramenta());
		}
		else if (filtro.getDwRap() != null) {
			q.defineParametro("idrap", filtro.getDwRap().getIdRap());
		}

		return q.list();
	}
	
	// a formula do relatorio diz para usar ciclo padrao, porem acho que o resultado nao fica correto.
	// usando ciclo medio acho que o resultado fica correto.
	private BigDecimal getQuantidadeProduzidaBoaTempo(DwConsol consol, BigDecimal cavidadesAtivas, BigDecimal cicloMedio){
		BigDecimal pecasBoas = getQuantidadeProduzidaBoaPeca(consol);
		if(cavidadesAtivas.doubleValue() != 0){
			pecasBoas = pecasBoas.divide(cavidadesAtivas, MathContext.DECIMAL32);
		}
		return pecasBoas.multiply(cicloMedio);
	}
		
	private BigDecimal getQuantidadeProduzidaBoaPeca(DwConsol consol){
		BigDecimal pecaProduzido = getQuantidadeProduzidaPeca(consol);
		BigDecimal pecaRefugado = getQuantidadeRefugadaPeca(consol);
		return pecaProduzido.subtract(pecaRefugado);
	}
	
	private BigDecimal getQuantidadeProduzidaPeca(DwConsol consol){
		BigDecimal quantidadeProduzidaPeca = BigDecimal.ZERO;
		quantidadeProduzidaPeca = consol.getPcsProducaoBruta().add(quantidadeProduzidaPeca);
		return quantidadeProduzidaPeca;
	}
	
	private double getQuantidadeProduzidaBoaGramas(DwConsol consol){
		return getQuantidadeProduzidaEmGramas(consol) - getQuantidadeRefugadaEmGramas(consol);
	}
	
	private double getQuantidadeProduzidaEmGramas(DwConsol consol){
		double quantidadeProduzidaEmGramas = 0;
		for(DwConsolpr consolpr : consol.getDwConsolprs()) {
			quantidadeProduzidaEmGramas += getBigDecimal(consolpr.getGAutoPesoBruto()).doubleValue();
			quantidadeProduzidaEmGramas += getBigDecimal(consolpr.getGManuPesoBruto()).doubleValue();
		}
		return quantidadeProduzidaEmGramas;
	}
	
	private BigDecimal getPecaHorasTrabalhadas(BigDecimal segundosHorasTrabalhadas, BigDecimal cavidadesAtivas, BigDecimal cicloMedio){
		if(cicloMedio.doubleValue() != 0){
			segundosHorasTrabalhadas = segundosHorasTrabalhadas.divide(cicloMedio, MathContext.DECIMAL32);
		}
		BigDecimal resultado = segundosHorasTrabalhadas.multiply(cavidadesAtivas);
		return resultado;
	}
	
	private BigDecimal getQuantidadeRefugadaPeca(DwConsol consol){
		BigDecimal quantidadeRefugadaPeca = BigDecimal.ZERO;
		quantidadeRefugadaPeca = consol.getPcsProducaoRefugada().add(quantidadeRefugadaPeca);
		return quantidadeRefugadaPeca;
	}
	
	//FIXME
	private double getQuantidadeRefugadaEmGramas(DwConsol consol){
		double quantidadeRefugadaEmGramas = 0;
		for(DwConsolpr consolpr : consol.getDwConsolprs()) {
			double pesoBrutoDoProduto = 0;
			
			pesoBrutoDoProduto = getBigDecimal(consolpr.getOmProduto().getGPesoBruto()).doubleValue();
		
			quantidadeRefugadaEmGramas += pesoBrutoDoProduto * quantidadeRefugadaEmGramas;
		}
		return quantidadeRefugadaEmGramas;
	}
	
	private BigDecimal getPerdasCicloPeca(DwConsol consol){
		BigDecimal perdasCicloPeca = BigDecimal.ZERO;
		perdasCicloPeca = getBigDecimal(consol.getPcsAutoPerdaciclo()).add(perdasCicloPeca);
		perdasCicloPeca = getBigDecimal(consol.getPcsManuPerdaciclo()).add(perdasCicloPeca);
		return perdasCicloPeca;
	}
	
	private BigDecimal getPerdaPCIPeca(DwConsol consol){
		BigDecimal perdasPCIPeca = BigDecimal.ZERO;
		perdasPCIPeca = getBigDecimal(consol.getPcsAutoPerdacavidades()).add(perdasPCIPeca);
		perdasPCIPeca = getBigDecimal(consol.getPcsManuPerdacavidades()).add(perdasPCIPeca);
		return perdasPCIPeca;
	}
	
	private BigDecimal getQuantidadeCavidadesAtivas(DwConsolid consolid){
		BigDecimal quantidadeCavidadesAtivas = BigDecimal.ZERO;
		
		for(DwFolharap rap : consolid.getDwFolha().getDwFolharaps()){
			for(DwFolharapcom com : rap.getDwFolharapcoms()){
				quantidadeCavidadesAtivas = getBigDecimal(com.getQtAtiva()).add(quantidadeCavidadesAtivas);
			}
		}
		
		if(quantidadeCavidadesAtivas.longValue() == 0){
			for (DwFolhaiac iac : consolid.getDwFolha().getDwFolhaiacs()) {
				quantidadeCavidadesAtivas = getBigDecimal(iac.getQtAtiva()).add(quantidadeCavidadesAtivas);
			}
		}
		
		return quantidadeCavidadesAtivas;
	}
	
	private double getEficienciaRealizacao(List<DwConsolid> listaDwconsolid) {
		Double prodBruta = 0d;
		Double prodRef = 0d;
		Double prodPrev = 0d;

		for (DwConsolid dwci : listaDwconsolid) {
			for (DwConsol dwconsol : dwci.getDwConsols()) {
				prodBruta += dwconsol.getPcsProducaoBruta().doubleValue();

				prodRef += dwconsol.getPcsProducaoRefugada().doubleValue();

				prodPrev += dwconsol.getPcsAutoProducaoprevista() != null
						? dwconsol.getPcsAutoProducaoprevista().doubleValue() : 0d;
				prodPrev += dwconsol.getPcsManuProducaoprevista() != null
						? dwconsol.getPcsManuProducaoprevista().doubleValue() : 0d;
			}
		}
		Double producaoLiquida = prodBruta - prodRef;

		return FormulasInjet.calcularEficienciaRealizacao(new BigDecimal(producaoLiquida), new BigDecimal(prodPrev))
				.doubleValue();
	}
		

	//Marcos Sardinha: 2017-08-11 >> Defeito #4341
	private double getEficienciaCiclo(List<DwConsolid> listaDwconsolid) {
		Double segCicloPadrao = 0d;
		Double segCicloMedio = 0d;
		Float efiCiclo = 0f;
		
		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();
		filtro.setDtReferenciaInicial(this.filtroReport.getPeriodoInicial());
		filtro.setDtReferenciaFinal(this.filtroReport.getPeriodoFinal());
		
		IndicadoresDoDetalheCiclosRN irn = new IndicadoresDoDetalheCiclosRN(getDao());
		segCicloPadrao = irn.calcularCicloPadrao(listaDwconsolid, filtro);
		segCicloMedio = irn.calcularCicloMedio(listaDwconsolid, filtro);
		
		
		efiCiclo = FormulasInjet.calcularEficienciaCiclo(new BigDecimal(segCicloPadrao), new BigDecimal(segCicloMedio));

		return efiCiclo.doubleValue();
	}
	
	private double getIndiceRefugos(List<DwConsolid> listaDwconsolid) {
		Long producaoBruta = 0L;
		Long producaoRefugada = 0L;

		for (DwConsolid consolid : listaDwconsolid) {
			for (DwConsol consol : consolid.getDwConsols()) {
				producaoBruta += consol.getPcsProducaoBruta().longValue();
				
				producaoRefugada += consol.getPcsProducaoRefugada().longValue();
			}
		}

		return FormulasInjet.calcularIndiceRefugo(producaoRefugada.longValue(), producaoBruta.longValue()).doubleValue();
	}
	
	private double getIndiceParadas(List<DwConsolid> listaDwconsolid) {
		Long tempoparadacp = 0l;
		Long tempoativo = 0l;
		Date dthrITurnoMenor = null;
		Date dthrFTurnoMaior = null;
		//List<DwConsolpalog> paradasEmAberto = new ArrayList<>();

		for (DwConsolid dwci : listaDwconsolid) {
			for (DwConsol dwconsol : dwci.getDwConsols()) {
				if (dthrITurnoMenor == null || DataHoraRN.before(dwconsol.getDwConsolid().getDthrIturno(),dthrITurnoMenor))
					dthrITurnoMenor = dwconsol.getDwConsolid().getDthrIturno();
				if (dthrFTurnoMaior == null || DataHoraRN.after(dwconsol.getDwConsolid().getDthrFturno(), dthrFTurnoMaior))
					dthrFTurnoMaior = dwconsol.getDwConsolid().getDthrFturno();
	
				BigDecimal tempoParadaCP = dwconsol.getSegAutoTempoparadaCp();
				if ( tempoParadaCP == null) {
					tempoParadaCP = BigDecimal.ZERO;
				}
				BigDecimal tempoAtivo = dwconsol.getSegAutoTempoativo(); 
				if (tempoAtivo == null) {
					tempoAtivo = BigDecimal.ZERO;
				}
	
				tempoparadacp += tempoParadaCP.longValue();
				tempoativo += tempoAtivo.longValue();
	
			}
		}

		
		if (tempoparadacp < 0l)
			tempoparadacp = 0l;

		
		return FormulasInjet.calcularIndiceParada(BigDecimal.valueOf(tempoparadacp),
				BigDecimal.valueOf(tempoativo)).doubleValue();
		
	}
	
	private Double getIndicePerdas(List<DwConsolid> listaDwconsolid) {
		Double perdaciclo = 0d;
		Double perdaparadacp = 0d;
		Double prodref = 0d;
		Double perdacav = 0d;
		Double prodprev = 0d;

		for (DwConsolid dwci : listaDwconsolid) {
			for (DwConsol dwconsol : dwci.getDwConsols()) {
				perdaciclo += dwconsol.getPcsAutoPerdaciclo() != null ? dwconsol.getPcsAutoPerdaciclo().doubleValue() : 0d;
				perdaciclo += dwconsol.getPcsManuPerdaciclo() != null ? dwconsol.getPcsManuPerdaciclo().doubleValue()
						: 0l;

				perdaparadacp += dwconsol.getPcsAutoPerdaparadaCp() != null
						? dwconsol.getPcsAutoPerdaparadaCp().doubleValue() : 0d;

				prodref += dwconsol.getPcsProducaoRefugada().doubleValue();

				perdacav += dwconsol.getPcsAutoPerdacavidades() != null ? dwconsol.getPcsAutoPerdacavidades().longValue()
						: 0l;
				perdacav += dwconsol.getPcsManuPerdacavidades() != null
						? dwconsol.getPcsManuPerdacavidades().doubleValue() : 0d;

				prodprev += dwconsol.getPcsAutoProducaoprevista() != null
						? dwconsol.getPcsAutoProducaoprevista().doubleValue() : 0d;
				prodprev += dwconsol.getPcsManuProducaoprevista() != null
						? dwconsol.getPcsManuProducaoprevista().doubleValue() : 0d;
			}
		}

		return FormulasInjet.calcularIndicePerda(perdaciclo, perdaparadacp, prodref, perdacav, prodprev).doubleValue();
	}
	
	private double getIndiceUtilizacao(BigDecimal horasTrabalhadas, BigDecimal tempoAtivo){
		return FormulasInjet.calcularUtilizacao(horasTrabalhadas, tempoAtivo);
	}
	
	private double getKGHorasTrabalhada(BigDecimal tempoEmSegundos, BigDecimal pesoKG){
		if(tempoEmSegundos.doubleValue() == 0){
			return 0;
		}
		tempoEmSegundos = tempoEmSegundos.divide(new BigDecimal(3600), MathContext.DECIMAL32);
		return pesoKG.divide(tempoEmSegundos, MathContext.DECIMAL32).doubleValue();
	}
	
	private double getPesoBrutoProdutoGrama(DwConsol dwconsol){
		double pesoBruto = 0;
		for (DwConsolpr dwconsolpr : dwconsol.getDwConsolprs()) {
			OmProduto omproduto = dwconsolpr.getOmProduto();
			if (omproduto != null && omproduto.getGPesoBruto() != null)
				pesoBruto += omproduto.getGPesoBruto().doubleValue();
		}
		return pesoBruto;
	}
	
	private double converterGramaParaKilo(double grama){
		return grama / 1000;
	}
	
	private double converterGramaParaTornelada(double grama){
		return converterGramaParaKilo(grama) / 1000;
	}
	
	//Evita o NPE (null point exception)
	private BigDecimal getBigDecimal(BigDecimal valor) {
		if(valor != null){
			return valor;
		}
		return BigDecimal.ZERO;
	}
	
	private String converterMilisegundosParaHHMMSS(Long milisegundos) {
		return DataHoraRN.formatMilisegundosParaHHMMSS(milisegundos);
	}
	
	private String converterSegundosParaHHMMSS(Long segundos){
		return DataHoraRN.formatSegundosParaHHMMSS(segundos.intValue());
	}
}
