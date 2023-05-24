package idw.model.rn;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolciplog;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpaoco;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwConsolre;
import idw.model.pojos.OmCfgind;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCpproduto;
import idw.util.AritmeticaUtil;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioProducaoR043DTO;
import idw.webservices.dto.LinhaTabelaSubRelatorioProducaoR043DTO;
import idw.webservices.dto.PtDTO;
import idw.webservices.dto.RelatorioProducaoR043DTO;
import idw.webservices.dto.ValorTabelaSubRelatorioProducaoR043DTO;
import ms.util.ConversaoTipos;

public class RelatorioProducaoR043RN extends AbstractRN<DAOGenerico> {
	
	public static final int QUANTIDADE_CASAS_DECIMAIS_PECAS = 0;
	public static final int QUANTIDADE_CASAS_DECIMAIS_HORAS = 2;
	
	public static final int MAXIMO_COLUNAS_DIARIAS = 7;
	public static final int MAXIMO_COLUNAS_SEMANAIS = 5;
	
	public static final int FILTRO_DIARIO = 0;
	public static final int FILTRO_SEMANAL = 1;
	
	public static final int OEE_PECA = 0;
	public static final int OEE_HORA = 1;
	
	//se a meta for -1 o valor no relatorio será VALOR_DEFAULT_META_RELATORIO
	public static final long ID_META_EFICIENCIA_SETUP = -1;
	public static final long ID_META_ATENDIMENTO = -1;
	public static final long ID_META_UTILIZACAO = -1;
	public static final long ID_META_EFICIENCIA = -1;
	public static final long ID_META_PRODUTIVIDADE_OEE = 5;
	public static final long ID_META_PRODUTIVIDADE_OEE_CAPITAL = -1;
	public static final long ID_META_PPMIL = -1;
	
	public static final String VALOR_DEFAULT_META_RELATORIO = "100%";

	public RelatorioProducaoR043RN() {
		this(null);
	}
	
	public RelatorioProducaoR043RN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public RelatorioProducaoR043DTO getRelatorioProducaoR043(FiltroRelatorioProducaoR043DTO filtro){
		//System.out.println(filtro);
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioProducaoR043RN.getRelatorioProducaoR043");
		log.info( idLog , 0, "RelatorioProducaoR043RN.getRelatorioProducaoR043 filtro usado:" + filtro.toString());
		
		int tipoFiltro;
		if(filtro.isRelatorioSemanal()){
			tipoFiltro = FILTRO_DIARIO;
		} else {
			tipoFiltro = FILTRO_SEMANAL;
		}
		
		int tipoFiltroOEE;
		if(filtro.isHoraOEE()){
			tipoFiltroOEE = OEE_HORA;
		} else {
			tipoFiltroOEE = OEE_PECA;
		}
		
		int maximoDeColunas;
		if(tipoFiltro == FILTRO_DIARIO){
			maximoDeColunas = MAXIMO_COLUNAS_DIARIAS;
		} else {
			maximoDeColunas = MAXIMO_COLUNAS_SEMANAIS;
		}
		
		int numeroDeMaquinas = 0;
		if(filtro.getPosto() != null){
			numeroDeMaquinas = 1;
		}
		if(filtro.getGrupoTrabalho() != null){
			PTRN ptrn = new PTRN(getDao());
			PtDTO filtroPt = new PtDTO();
			filtroPt.setPt(new OmPt());
			filtroPt.getPt().setStAtivo((byte) 1);
			filtroPt.getPt().setOmGt(filtro.getGrupoTrabalho());
			numeroDeMaquinas = ptrn.getPtsDeGtDTO(filtroPt).getPts().size();
		}
		
		RelatorioProducaoR043DTO retorno = new RelatorioProducaoR043DTO();
		retorno.setRealizada(true);
		retorno.setLista(new ArrayList<RelatorioProducaoR043DTO>());
		
		List<LinhaTabelaSubRelatorioProducaoR043DTO> refugos = new ArrayList<>();
		List<LinhaTabelaSubRelatorioProducaoR043DTO> paradas = new ArrayList<>();
		
		Map<String,ValorTabelaSubRelatorioProducaoR043DTO[]> mapValoresRefugos = new HashMap<>();
		Map<String,ValorTabelaSubRelatorioProducaoR043DTO[]> mapValoresParadas = new HashMap<>();
		
		List<ValorTabelaSubRelatorioProducaoR043DTO> listaValoresParadaComPeso = new ArrayList<>();
		List<ValorTabelaSubRelatorioProducaoR043DTO> listaValoresParadaSemPeso = new ArrayList<>();
		
		//laco principal
		for(int i=0; i<maximoDeColunas; i++){
			
			boolean colunaVazia = false;
			
			List<DwConsolid> resultadoConsulta = new ArrayList<>();
			if(filtro.getDias().size() > i){
				Date dia = filtro.getDias().get(i);
				resultadoConsulta = consultaRelatorioProdutividadeR42(filtro, dia, tipoFiltro);
			} else {
				colunaVazia = true;
			}
			
			BigDecimal paradaComPeso = BigDecimal.ZERO;
			BigDecimal paradaSemPeso = BigDecimal.ZERO;
			BigDecimal paradaTotal = BigDecimal.ZERO;
			
			for(DwConsolid consolid : resultadoConsulta) {
				for(DwConsol consol : consolid.getDwConsols()){
					
					//refugos
					for(DwConsolre consolre : consol.getDwConsolres()){
						gerarValoresMapRefugos(consolre, refugos, mapValoresRefugos, i, QUANTIDADE_CASAS_DECIMAIS_PECAS, maximoDeColunas);						
					}
					
					//paradas
					for(DwConsolpa consolpa : consol.getDwConsolpas()){
						
						paradaComPeso = getBigDecimal(consol.getSegAutoTempoparadaCp()).add(paradaComPeso);
						paradaComPeso = getBigDecimal(consol.getSegManuTempoparadaCp()).add(paradaComPeso);

						paradaSemPeso = getBigDecimal(consol.getSegAutoTempoparadaSp()).add(paradaSemPeso);
						paradaSemPeso = getBigDecimal(consol.getSegManuTempoparadaSp()).add(paradaSemPeso);
						
						paradaTotal = paradaComPeso.add(paradaTotal);
						paradaTotal = paradaSemPeso.add(paradaTotal);
						
						for(DwConsolpaoco consolpaoco : consolpa.getDwConsolpaocos()){
							gerarValoresMapParadas(consolpaoco, paradas, mapValoresParadas, i, QUANTIDADE_CASAS_DECIMAIS_HORAS, maximoDeColunas);
						}
					}						
				}
			}
			
			ValorTabelaSubRelatorioProducaoR043DTO valorParadaComPeso = new ValorTabelaSubRelatorioProducaoR043DTO();
			valorParadaComPeso.setValorAtualizandoCamposFilho(converterSegundoParaHora(paradaComPeso.longValue()), QUANTIDADE_CASAS_DECIMAIS_HORAS);
			listaValoresParadaComPeso.add(valorParadaComPeso);
			
			ValorTabelaSubRelatorioProducaoR043DTO valorParadaSemPeso = new ValorTabelaSubRelatorioProducaoR043DTO();
			valorParadaSemPeso.setValorAtualizandoCamposFilho(converterSegundoParaHora(paradaSemPeso.longValue()), QUANTIDADE_CASAS_DECIMAIS_HORAS);
			listaValoresParadaSemPeso.add(valorParadaSemPeso);			
			
			RelatorioProducaoR043DTO linha = getAcumuladosPeriodo(resultadoConsulta, tipoFiltro, tipoFiltroOEE);
			linha.setVazio(colunaVazia);
			linha.setNumeroMaquinas(new BigDecimal(numeroDeMaquinas));
			linha.setNumeroMaquinasFormatada(ConversaoTipos.converteParaStringUsandoVirgula(linha.getNumeroMaquinas(), 0));
			retorno.getLista().add(linha);
		}		
		
		//refugos
		setarValoresDoObjeto(refugos, mapValoresRefugos, QUANTIDADE_CASAS_DECIMAIS_PECAS);
		LinhaTabelaSubRelatorioProducaoR043DTO refugoTotalColuna = calcularTotalColuna(refugos, QUANTIDADE_CASAS_DECIMAIS_PECAS, maximoDeColunas);
		calcularIndice(refugoTotalColuna, refugos);
		atualizarTotalValorAcumulado(refugoTotalColuna, refugos, QUANTIDADE_CASAS_DECIMAIS_PECAS);
		calcularIndiceAcumulado(refugoTotalColuna, refugos);
		
		retorno.setRefugos(refugos);
		retorno.setTempoTotalRefugos(refugoTotalColuna);
		
		//paradas
		setarValoresDoObjeto(paradas, mapValoresParadas, QUANTIDADE_CASAS_DECIMAIS_HORAS);
		LinhaTabelaSubRelatorioProducaoR043DTO paradaTotalColuna = calcularTotalColuna(paradas, QUANTIDADE_CASAS_DECIMAIS_HORAS, maximoDeColunas);
		calcularIndice(paradaTotalColuna, paradas);
		atualizarTotalValorAcumulado(paradaTotalColuna, paradas, QUANTIDADE_CASAS_DECIMAIS_HORAS);
		calcularIndiceAcumulado(paradaTotalColuna, paradas);
		
		LinhaTabelaSubRelatorioProducaoR043DTO paradasComPeso = new LinhaTabelaSubRelatorioProducaoR043DTO();
		paradasComPeso.setValores(listaValoresParadaComPeso);
		calcularIndice(paradasComPeso, paradaTotalColuna, maximoDeColunas);
		calcularAcumuladoSubTotais(paradasComPeso, QUANTIDADE_CASAS_DECIMAIS_HORAS);
		calcularIndiceSubTotais(paradasComPeso, paradaTotalColuna.getValorAcumulado());
		
		LinhaTabelaSubRelatorioProducaoR043DTO paradasSemPeso = new LinhaTabelaSubRelatorioProducaoR043DTO();
		paradasSemPeso.setValores(listaValoresParadaSemPeso);
		calcularIndice(paradasSemPeso, paradaTotalColuna, maximoDeColunas);
		calcularAcumuladoSubTotais(paradasSemPeso, QUANTIDADE_CASAS_DECIMAIS_HORAS);
		calcularIndiceSubTotais(paradasSemPeso, paradaTotalColuna.getValorAcumulado());
		
		retorno.setParadas(paradas);
		retorno.setTempoTotalParadasComPeso(paradasComPeso);
		retorno.setTempoTotalParadasSemPeso(paradasSemPeso);
		retorno.setTempoTotalParadas(paradaTotalColuna);
		
		calcularAcumuladoIndicadores(retorno, tipoFiltroOEE);
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	private boolean isListaContemObjeto(String codigo, List<LinhaTabelaSubRelatorioProducaoR043DTO> objetos){
		if(objetos == null){
			return false;
		}
		
		for(LinhaTabelaSubRelatorioProducaoR043DTO objeto : objetos){
			if(objeto.getCodigo().equals(codigo)){
				return true;
			}
		}
		
		return false;
	}
	
	private void gerarValoresMapRefugos(DwConsolre consolre,
			List<LinhaTabelaSubRelatorioProducaoR043DTO> refugos,
			Map<String,ValorTabelaSubRelatorioProducaoR043DTO[]> mapValoresRefugos,
			int i,
			int quantidadeCasasDecimais,
			int maximoColunas){
		
		String codigo = consolre.getDwTRefugo().getCdTrefugo();
		String descricao = consolre.getDwTRefugo().getDsTrefugo();
		BigDecimal pecas = BigDecimal.ZERO;
		pecas = getBigDecimal(consolre.getPcsAutoProducaorefugada()).add(pecas);
		pecas = getBigDecimal(consolre.getPcsManuProducaorefugada()).add(pecas);
		
		if(isListaContemObjeto(codigo, refugos) == false){
			LinhaTabelaSubRelatorioProducaoR043DTO refugo = new LinhaTabelaSubRelatorioProducaoR043DTO();
			refugo.setCodigo(codigo);
			refugo.setDescricao(descricao);
			refugos.add(refugo);
		}
		
		ValorTabelaSubRelatorioProducaoR043DTO[] valores = mapValoresRefugos.get(codigo);
		if(valores == null){
			valores = new ValorTabelaSubRelatorioProducaoR043DTO[maximoColunas];
			mapValoresRefugos.put(codigo, valores);
		}
		
		ValorTabelaSubRelatorioProducaoR043DTO valor = valores[i];
		if(valor == null){
			valor = new ValorTabelaSubRelatorioProducaoR043DTO(quantidadeCasasDecimais);
			valores[i] = valor;
		}
		
		valor.setValorAtualizandoCamposFilho(pecas.add(valor.getValor()), quantidadeCasasDecimais);		
	}
	
	private void gerarValoresMapParadas(DwConsolpaoco consolpaoco,
			List<LinhaTabelaSubRelatorioProducaoR043DTO> paradas,
			Map<String,ValorTabelaSubRelatorioProducaoR043DTO[]> mapValoresParadas,
			int i,
			int quantidadeCasasDecimais,
			int maximoColunas){
		
		String codigo = consolpaoco.getDwConsolpa().getDwTParada().getCd();
		String descricao = consolpaoco.getDwConsolpa().getDwTParada().getDsTparada();
		long tempoParadaMilisegundos = getTempoParada(consolpaoco);
		BigDecimal tempoParadaHora = converterMilisegundoParaHora(tempoParadaMilisegundos);
		
		if(isListaContemObjeto(codigo, paradas) == false){
			LinhaTabelaSubRelatorioProducaoR043DTO parada = new LinhaTabelaSubRelatorioProducaoR043DTO();
			parada.setCodigo(codigo);
			parada.setDescricao(descricao);
			paradas.add(parada);
		}
		
		ValorTabelaSubRelatorioProducaoR043DTO[] valores = mapValoresParadas.get(codigo);
		if(valores == null){
			valores = new ValorTabelaSubRelatorioProducaoR043DTO[maximoColunas];
			mapValoresParadas.put(codigo, valores);
		}
		
		ValorTabelaSubRelatorioProducaoR043DTO valor = valores[i];
		if(valor == null){
			valor = new ValorTabelaSubRelatorioProducaoR043DTO(quantidadeCasasDecimais);
			valores[i] = valor;
		}
		
		valor.setValorAtualizandoCamposFilho(tempoParadaHora.add(valor.getValor()), quantidadeCasasDecimais);		
	}
	
	private void setarValoresDoObjeto(List<LinhaTabelaSubRelatorioProducaoR043DTO> objetos,
			Map<String,ValorTabelaSubRelatorioProducaoR043DTO[]> mapValores,
			int quantidadeCasasDecimais){
		
		for(LinhaTabelaSubRelatorioProducaoR043DTO objeto : objetos){
			ValorTabelaSubRelatorioProducaoR043DTO[] valores = mapValores.get(objeto.getCodigo());			
			if(valores == null){
				continue;
			}
			for(int i=0; i<valores.length; i++){
				ValorTabelaSubRelatorioProducaoR043DTO valor = valores[i];
				if(valor == null){
					valor = new ValorTabelaSubRelatorioProducaoR043DTO(quantidadeCasasDecimais);
				}
				objeto.getValores().add(valor);
			}
		}
	}
	
	private LinhaTabelaSubRelatorioProducaoR043DTO calcularTotalColuna(List<LinhaTabelaSubRelatorioProducaoR043DTO> objetos,
			int quantidadeCasasDecimais,
			int totalDeColunas){
		LinhaTabelaSubRelatorioProducaoR043DTO total = new LinhaTabelaSubRelatorioProducaoR043DTO();
				
		if(objetos != null && objetos.size() == 0){
			for(int i=0; i<totalDeColunas; i++){
				total.getValores().add(new ValorTabelaSubRelatorioProducaoR043DTO(quantidadeCasasDecimais));
			}
			return total;
		}
		
		for(int i=0; i<totalDeColunas; i++){
			
			ValorTabelaSubRelatorioProducaoR043DTO valorTotalColuna = new ValorTabelaSubRelatorioProducaoR043DTO();
			
			for(LinhaTabelaSubRelatorioProducaoR043DTO objeto : objetos){
				if(i < objeto.getValores().size()){
					ValorTabelaSubRelatorioProducaoR043DTO valor = objeto.getValores().get(i);
					BigDecimal totalColuna = getBigDecimal(valor.getValor()).add(getBigDecimal(valorTotalColuna.getValor()));
					valorTotalColuna.setValorAtualizandoCamposFilho(totalColuna, quantidadeCasasDecimais);
				}
			}
			
			if(valorTotalColuna.getValor().doubleValue() > 0){
				valorTotalColuna.setIndiceAtualizandoCamposFilho(new BigDecimal(100));
			}			
			total.getValores().add(valorTotalColuna);
		}
		
		return total;
	}
	
	private void calcularIndice(LinhaTabelaSubRelatorioProducaoR043DTO objetoTotalColuna, 
			List<LinhaTabelaSubRelatorioProducaoR043DTO> objetos){
		
		int totalDeColunas = objetoTotalColuna.getValores().size();
		for(int i=0; i<totalDeColunas; i++){
			
			BigDecimal somaDaColunaValor = getBigDecimal(objetoTotalColuna.getValores().get(i).getValor());
			for(LinhaTabelaSubRelatorioProducaoR043DTO objeto : objetos){
				ValorTabelaSubRelatorioProducaoR043DTO valor = objeto.getValores().get(i);
				if(valor == null){
					continue;
				}				
				
				if(somaDaColunaValor.doubleValue() > 0){
					BigDecimal indice = getBigDecimal(valor.getValor()).divide(somaDaColunaValor, MathContext.DECIMAL32);
					indice = indice.multiply(new BigDecimal(100));
					valor.setIndiceAtualizandoCamposFilho(indice);
				} else {
					valor.setIndiceAtualizandoCamposFilho(new BigDecimal(0));
				}
			}
		}
	}
	
	private void atualizarTotalValorAcumulado(LinhaTabelaSubRelatorioProducaoR043DTO objetoTotalColuna,
			List<LinhaTabelaSubRelatorioProducaoR043DTO> objetos,
			int quantidadeCasasDecimais){
		BigDecimal valorAcumuladoTotal = BigDecimal.ZERO;
		for(LinhaTabelaSubRelatorioProducaoR043DTO objeto : objetos){
			BigDecimal valorAcumulado = BigDecimal.ZERO;
			for(ValorTabelaSubRelatorioProducaoR043DTO valor : objeto.getValores()){
				valorAcumulado = getBigDecimal(valor.getValor()).add(valorAcumulado);
			}
			objeto.setValorAcumuladoAtualizandoCamposFilho(valorAcumulado, quantidadeCasasDecimais);
			valorAcumuladoTotal = valorAcumuladoTotal.add(valorAcumulado);
		}
		objetoTotalColuna.setValorAcumuladoAtualizandoCamposFilho(valorAcumuladoTotal, quantidadeCasasDecimais);		
	}
	
	private void calcularIndiceAcumulado(LinhaTabelaSubRelatorioProducaoR043DTO objetoTotalColuna, List<LinhaTabelaSubRelatorioProducaoR043DTO> objetos){
		BigDecimal valorAcumuladoTotal = objetoTotalColuna.getValorAcumulado();
		if(valorAcumuladoTotal.doubleValue() > 0){
			objetoTotalColuna.setIndiceAcumuladoAtualizandoCamposFilho(new BigDecimal(100));
		} else {
			objetoTotalColuna.setIndiceAcumuladoAtualizandoCamposFilho(BigDecimal.ZERO);
		}
		
		for(LinhaTabelaSubRelatorioProducaoR043DTO objeto : objetos){
			BigDecimal indice = getBigDecimal(objeto.getValorAcumulado()).divide(valorAcumuladoTotal, MathContext.DECIMAL32);
			indice = indice.multiply(new BigDecimal(100));
			objeto.setIndiceAcumuladoAtualizandoCamposFilho(indice);
		}
	}
		
	private void calcularAcumuladoSubTotais(LinhaTabelaSubRelatorioProducaoR043DTO objeto, int quantidadeCasasDecimais){
		BigDecimal totalValores = BigDecimal.ZERO;
		for(ValorTabelaSubRelatorioProducaoR043DTO valor : objeto.getValores()){
			totalValores = getBigDecimal(valor.getValor()).add(totalValores);
		}
		objeto.setValorAcumuladoAtualizandoCamposFilho(totalValores, quantidadeCasasDecimais);
	}
	
	private void calcularIndiceSubTotais(LinhaTabelaSubRelatorioProducaoR043DTO objeto, BigDecimal valorTotal){
		valorTotal = getBigDecimal(valorTotal);
		if(valorTotal.doubleValue() > 0){
			BigDecimal indice = getBigDecimal(objeto.getValorAcumulado()).divide(valorTotal, MathContext.DECIMAL32);
			indice = indice.multiply(new BigDecimal(100));
			objeto.setIndiceAcumuladoAtualizandoCamposFilho(indice);
		} else {
			objeto.setIndiceAcumuladoAtualizandoCamposFilho(BigDecimal.ZERO);
		}
	}
	
	private void calcularIndice(LinhaTabelaSubRelatorioProducaoR043DTO linha, LinhaTabelaSubRelatorioProducaoR043DTO colunaTotal, int totalColunas){
		for(int i=0; i<totalColunas; i++){
			if(i >= linha.getValores().size() && i >= colunaTotal.getValores().size()){
				continue;
			}
			BigDecimal total = getBigDecimal(colunaTotal.getValores().get(i).getValor());
			BigDecimal valor = getBigDecimal(linha.getValores().get(i).getValor());
			BigDecimal indice = dividir(valor, total);
			indice = indice.multiply(new BigDecimal(100));
			linha.getValores().get(i).setIndiceAtualizandoCamposFilho(indice);
		}
	}
	
	private RelatorioProducaoR043DTO getAcumuladosPeriodo(List<DwConsolid> resultadoConsulta, int tipoFiltro, int tipoFiltroOEE){
		RelatorioProducaoR043DTO retorno = new RelatorioProducaoR043DTO();
		
		BigDecimal producaoBrutaPecas = BigDecimal.ZERO;
		BigDecimal producaoBrutaKG = BigDecimal.ZERO;
		
		BigDecimal producaoRefugadaPecas = BigDecimal.ZERO;
		BigDecimal producaoRefugadaKG = BigDecimal.ZERO;
		
		BigDecimal producaoLiquidaPecas = BigDecimal.ZERO;
		BigDecimal producaoLiquidaKG = BigDecimal.ZERO;
		
		BigDecimal producaoPlanoPCMPecas = BigDecimal.ZERO;
		BigDecimal producaoPrevistaPecas = BigDecimal.ZERO;
		
		BigDecimal ciclosProdutivosSegundos = BigDecimal.ZERO;
		BigDecimal ciclosImprodutivosSegundos = BigDecimal.ZERO;
		BigDecimal paradasSegundos = BigDecimal.ZERO;
		BigDecimal naoDisponivelSegundos = BigDecimal.ZERO;
		BigDecimal disponivelSegundos = BigDecimal.ZERO;
		BigDecimal totaisSegundos = BigDecimal.ZERO;
		BigDecimal trabalhadasSegundos = BigDecimal.ZERO;
		BigDecimal refugosSegundos = BigDecimal.ZERO;
		BigDecimal ritmoSegundos = BigDecimal.ZERO;
		BigDecimal produtivasSegundos = BigDecimal.ZERO;
		BigDecimal pciSegundos = BigDecimal.ZERO;
		
		List<DwConsolciplog> setups = new ArrayList<>();
		BigDecimal numeroDeSetup = BigDecimal.ZERO;
		BigDecimal duracaoSetupMinutos = BigDecimal.ZERO;
		BigDecimal padraoMedioSetupMinutos = BigDecimal.ZERO;
		BigDecimal eficienciaSetup = BigDecimal.ZERO;
		
		BigDecimal atendimento = BigDecimal.ZERO;
		BigDecimal utilizacao = BigDecimal.ZERO;
		BigDecimal eficiencia = BigDecimal.ZERO;
		BigDecimal produtividade = BigDecimal.ZERO;
		BigDecimal produtividadeC = BigDecimal.ZERO;
		BigDecimal ppmil = BigDecimal.ZERO;
		
		for(DwConsolid consolid : resultadoConsulta) {
			Date dthrF = consolid.getPpCp().getDthrFinal();
			if (dthrF == null)
				dthrF = DataHoraRN.getDataHoraAtual();
			
			long inicio = consolid.getPpCp().getDthrInicio().getTime();
			long fim = dthrF.getTime();
			BigDecimal periodoTempo = converterMilisegundoParaHora(fim - inicio);
			
			BigDecimal producaoPlanejada = BigDecimal.ZERO;
			
			for(PpCpproduto produto : consolid.getPpCp().getPpCpprodutos()){
				producaoPlanejada = getBigDecimal(produto.getPcsProducaoplanejada()).add(producaoPlanejada);
			}
			
			if (periodoTempo != null && periodoTempo.equals(BigDecimal.ZERO) == false)
					producaoPlanejada = producaoPlanejada.divide(periodoTempo, MathContext.DECIMAL32);
			producaoPlanoPCMPecas = producaoPlanoPCMPecas.add(producaoPlanejada);
			
			for(DwConsol consol : consolid.getDwConsols()){
				
				padraoMedioSetupMinutos = converterSegundoParaMinuto(consol.getSegAutoCiclopadrao().longValue());
				producaoBrutaPecas = consol.getPcsProducaoBruta().add(producaoBrutaPecas);

				BigDecimal producaoRefugadaPecasSoma = BigDecimal.ZERO;
				producaoRefugadaPecasSoma = getBigDecimal(consol.getPcsProducaoRefugada()).add(producaoRefugadaPecasSoma);
				producaoRefugadaPecas = producaoRefugadaPecasSoma.add(producaoRefugadaPecas);
				producaoLiquidaPecas = getBigDecimal(consol.getPcsProducaoLiquida()).add(producaoLiquidaPecas);

				
				//Marcos Sardinha: 2017-08-31 >> Defeito #4342	>>> conversao para peso tem que considerar produto a produto (dw_consolpr_
				for (DwConsolpr pr : consol.getDwConsolprs()) {
					BigDecimal pesoBrutoProdutoGrama_pro = (pr.getOmProduto().getGPesoBruto() == null ? BigDecimal.ZERO : pr.getOmProduto().getGPesoBruto()); 
					
					BigDecimal producao_pro = AritmeticaUtil.somar((pr.getPcsAutoProducaobruta() == null ? BigDecimal.ZERO : pr.getPcsAutoProducaobruta()), 
																   (pr.getPcsManuProducaobruta() == null ? BigDecimal.ZERO : pr.getPcsManuProducaobruta()));
					
					BigDecimal refugo_pro = AritmeticaUtil.somar((pr.getPcsAutoProducaorefugada() == null ? BigDecimal.ZERO : pr.getPcsAutoProducaorefugada()), 
							                                     (pr.getPcsManuProducaorefugada() == null ? BigDecimal.ZERO : pr.getPcsManuProducaorefugada()));
					
					producaoBrutaKG = converterGramaParaKilo(AritmeticaUtil.multiplicar(producao_pro, pesoBrutoProdutoGrama_pro)).add(producaoBrutaKG);
					producaoRefugadaKG = converterGramaParaKilo(AritmeticaUtil.multiplicar(refugo_pro, pesoBrutoProdutoGrama_pro)).add(producaoRefugadaKG);
					producaoLiquidaKG = AritmeticaUtil.diminuir(producaoBrutaKG, producaoRefugadaKG);
					
				}
				
								
				producaoPrevistaPecas = getBigDecimal(consol.getPcsAutoProducaoprevista()).add(producaoPrevistaPecas);
				producaoPrevistaPecas = getBigDecimal(consol.getPcsManuProducaoprevista()).add(producaoPrevistaPecas);
				
				ciclosProdutivosSegundos = getBigDecimal(consol.getSegAutoCicloprodutivo()).add(ciclosProdutivosSegundos);
				ciclosProdutivosSegundos = getBigDecimal(consol.getSegManuCicloprodutivo()).add(ciclosProdutivosSegundos);
				
				ciclosImprodutivosSegundos = getBigDecimal(consol.getSegAutoCicloimprodutivo()).add(ciclosImprodutivosSegundos);
				ciclosImprodutivosSegundos = getBigDecimal(consol.getSegManuCicloimprodutivo()).add(ciclosImprodutivosSegundos);
				
				paradasSegundos = getBigDecimal(consol.getSegAutoTempoparadaCp()).add(paradasSegundos);
				paradasSegundos = getBigDecimal(consol.getSegManuTempoparadaCp()).add(paradasSegundos);
				
				naoDisponivelSegundos = getBigDecimal(consol.getSegAutoTempoparadaSp()).add(naoDisponivelSegundos);
				naoDisponivelSegundos = getBigDecimal(consol.getSegManuTempoparadaSp()).add(naoDisponivelSegundos);
				
				disponivelSegundos = disponivelSegundos.add(ciclosProdutivosSegundos);
				disponivelSegundos = disponivelSegundos.add(ciclosImprodutivosSegundos);
				disponivelSegundos = disponivelSegundos.add(paradasSegundos);
				
				totaisSegundos = totaisSegundos.add(naoDisponivelSegundos);
				totaisSegundos = totaisSegundos.add(disponivelSegundos);
				
				trabalhadasSegundos = trabalhadasSegundos.add(disponivelSegundos);				
				trabalhadasSegundos = trabalhadasSegundos.subtract(paradasSegundos);
				
				//refugosSegundos
				
				ritmoSegundos = getBigDecimal(consol.getSegAutoRitmo()).add(ritmoSegundos);
				ritmoSegundos = getBigDecimal(consol.getSegManuRitmo()).add(ritmoSegundos);
				
				//produtivasSegundos
				
				pciSegundos = getBigDecimal(consol.getSegAutoPerdacav()).add(pciSegundos);
				pciSegundos = getBigDecimal(consol.getSegManuPerdacav()).add(pciSegundos);
			}
			
			setups.addAll(consolid.getDwConsolciplogsForIdConsolidFim());
			setups.addAll(consolid.getDwConsolciplogsForIdConsolidInicio());			
		}
		
		numeroDeSetup = numeroDeSetup.add(new BigDecimal(setups.size()));
		for(DwConsolciplog setup : setups){
			Date dthrF = setup.getDthrFcip();
			if (dthrF == null)
				dthrF = DataHoraRN.getDataHoraAtual();
			long tempoSetup = DataHoraRN.getQuantidadeMilisegundosNoPeriodo(setup.getDthrIcip(), dthrF);
			duracaoSetupMinutos = converterMilisegundoParaMinuto(tempoSetup).add(duracaoSetupMinutos);
		}
		
		retorno.setRealizada(true);
		
		BigDecimal horasPeriodo = new BigDecimal(24);
		retorno.setHorasPeriodo(horasPeriodo);
		retorno.setHorasPeriodoFormatada(ConversaoTipos.converteParaStringUsandoVirgula(horasPeriodo, 2));
		
		BigDecimal diasDaSemana;
		if(tipoFiltro == FILTRO_SEMANAL){
			diasDaSemana = new BigDecimal(7);
		} else {
			diasDaSemana = new BigDecimal(1);
		}
		retorno.setDiasDaSemana(diasDaSemana);
		retorno.setDiasDaSemanaFormatada(ConversaoTipos.converteParaStringUsandoVirgula(diasDaSemana, 0));
		
		retorno.setProducaoBrutaPeca(producaoBrutaPecas);
		retorno.setProducaoBrutaPecaFormatada(ConversaoTipos.converteParaStringUsandoVirgula(producaoBrutaPecas, 0));
		retorno.setProducaoBrutaKg(producaoBrutaKG);
		retorno.setProducaoBrutaKgFormatada(ConversaoTipos.converteParaStringUsandoVirgula(producaoBrutaKG, 4));
		
		//refugo
		retorno.setFFormatandoCampoFilho(producaoRefugadaPecas);
		retorno.setGFormatandoCampoFilho(producaoRefugadaKG);

		retorno.setProducaoLiquidaPeca(producaoLiquidaPecas);
		retorno.setProducaoLiquidaPecaFormatada(ConversaoTipos.converteParaStringUsandoVirgula(producaoLiquidaPecas, 0));
		retorno.setProducaoLiquidaKg(producaoLiquidaKG);
		retorno.setProducaoLiquidaKgFormatada(ConversaoTipos.converteParaStringUsandoVirgula(producaoLiquidaKG, 4));
		
		retorno.setProducaoPCMPeca(producaoPlanoPCMPecas);
		retorno.setProducaoPCMPecaFormatada(ConversaoTipos.converteParaStringUsandoVirgula(producaoPlanoPCMPecas, 4));

		retorno.setProducaoPrevistaPeca(producaoPrevistaPecas);
		retorno.setProducaoPrevistaPecaFormatada(ConversaoTipos.converteParaStringUsandoVirgula(producaoPrevistaPecas, 4));
		
		BigDecimal ciclosProdutivosHora = converterSegundoParaHora(ciclosProdutivosSegundos.longValue());
		retorno.setCiclosProdutivosHora(ciclosProdutivosHora);
		retorno.setCiclosProdutivosHoraFormatada(ConversaoTipos.converteParaStringUsandoVirgula(ciclosProdutivosHora, 2));
		
		BigDecimal ciclosImprodutivosHora = converterSegundoParaHora(ciclosImprodutivosSegundos.longValue());
		retorno.setCiclosImprodutivosHora(ciclosImprodutivosHora);
		retorno.setCiclosImprodutivosHoraFormatada(ConversaoTipos.converteParaStringUsandoVirgula(ciclosImprodutivosHora, 2));
		
		BigDecimal paradasHora = converterSegundoParaHora(paradasSegundos.longValue());
		retorno.setParadasHora(paradasHora);
		retorno.setParadasHoraFormatada(ConversaoTipos.converteParaStringUsandoVirgula(paradasHora, 2));
		
		BigDecimal naoDisponivelHora = converterSegundoParaHora(naoDisponivelSegundos.longValue());
		retorno.setNaoDisponivelHora(naoDisponivelHora);
		retorno.setNaoDisponivelHoraFormatada(ConversaoTipos.converteParaStringUsandoVirgula(naoDisponivelHora, 2));
		
		// AE = K+L+M
		BigDecimal AE = BigDecimal.ZERO;
		AE = retorno.getK().add(AE);
		AE = retorno.getL().add(AE);
		AE = retorno.getM().add(AE);
		retorno.setAEFormatandoCampoFilho(AE);
		
		// AF = N+AE
		BigDecimal AF = BigDecimal.ZERO;
		AF = retorno.getN().add(AF);
		AF = retorno.getAE().add(AF);
		retorno.setAFFormatandoCampoFilho(AF);
		
		// O = AE-M
		BigDecimal O = BigDecimal.ZERO;
		O = retorno.getAE().add(O);
		O = O.subtract(retorno.getM());
		retorno.setOFormatandoCampoFilho(O);
		
		BigDecimal refugosHora = converterSegundoParaHora(refugosSegundos.longValue());
		retorno.setRefugosHora(refugosHora);
		retorno.setRefugosHoraFormatada(ConversaoTipos.converteParaStringUsandoVirgula(refugosHora, 2));
		
		BigDecimal ritmoHora = converterSegundoParaHora(ritmoSegundos.longValue());
		retorno.setRitmoHora(ritmoHora);
		retorno.setRitmoHoraFormatada(ConversaoTipos.converteParaStringUsandoVirgula(ritmoHora, 2));
		
		//AN
		BigDecimal pciHora = converterSegundoParaHora(pciSegundos.longValue());
		retorno.setPciHora(pciHora);
		retorno.setPciHoraFormatada(ConversaoTipos.converteParaStringUsandoVirgula(pciHora, 2));
		
		// R = O-L-P-Q-AN
		produtivasSegundos = retorno.getO().subtract(retorno.getL());
		produtivasSegundos = produtivasSegundos.subtract(retorno.getP());
		produtivasSegundos = produtivasSegundos.subtract(retorno.getQ());
		produtivasSegundos = produtivasSegundos.subtract(retorno.getAN());
		retorno.setRFormatandoCampoFilho(produtivasSegundos);
				
		retorno.setNumeroDeSetup(numeroDeSetup);
		retorno.setNumeroDeSetupFormatada(ConversaoTipos.converteParaStringUsandoVirgula(numeroDeSetup, 0));
		
		retorno.setDuracaoSetupMinutos(duracaoSetupMinutos);
		retorno.setDuracaoSetupMinutosFormatada(ConversaoTipos.converteParaStringUsandoVirgula(duracaoSetupMinutos, 2));
		
		retorno.setPadraoMedioSetupMinutos(padraoMedioSetupMinutos);
		retorno.setPadraoMedioSetupMinutosFormatada(ConversaoTipos.converteParaStringUsandoVirgula(padraoMedioSetupMinutos, 2));
		
		retorno.setVFormatandoCampoFilho(calcularV(retorno.getU(), retorno.getT(), retorno.getS()));
		retorno.setYFormatandoCampoFilho(calcularY(retorno.getH(), retorno.getJ()));
		retorno.setZFormatandoCampoFilho(calcularZ(retorno.getO(), retorno.getAE()));
		retorno.setAAFormatandoCampoFilho(calcularAA(retorno.getR(), retorno.getO()));
		retorno.setABFormatandoCampoFilho(calcularAB(tipoFiltroOEE, retorno.getR(), retorno.getAE(), retorno.getH(), retorno.getAD()));
		retorno.setAGFormatandoCampoFilho(calcularAG(retorno.getR(), retorno.getAF()));
		retorno.setACFormatandoCampoFilho(calcularAC(retorno.getF(), retorno.getD()));
		
		return retorno;
	}
	
	private void calcularAcumuladoIndicadores(RelatorioProducaoR043DTO dto, int tipoFiltroOEE){		
		BigDecimal V = BigDecimal.ZERO;
		BigDecimal Y = BigDecimal.ZERO;
		BigDecimal Z = BigDecimal.ZERO;
		BigDecimal AA = BigDecimal.ZERO;
		BigDecimal AB = BigDecimal.ZERO;
		BigDecimal AG = BigDecimal.ZERO;
		BigDecimal AC = BigDecimal.ZERO;
		
		int quantidade = 0;
		for(RelatorioProducaoR043DTO filho : dto.getLista()){
			if(filho.isVazio()){
				continue;
			}
			quantidade++;
			dto.setAFormatandoCampoFilho(dto.getA().add(filho.getA()));
			dto.setBFormatandoCampoFilho(dto.getB().add(filho.getB()));
			dto.setCFormatandoCampoFilho(dto.getC().add(filho.getC()));
			dto.setDFormatandoCampoFilho(dto.getD().add(filho.getD()));
			dto.setEFormatandoCampoFilho(dto.getE().add(filho.getE()));
			dto.setFFormatandoCampoFilho(dto.getF().add(filho.getF()));
			dto.setGFormatandoCampoFilho(dto.getG().add(filho.getG()));
			dto.setHFormatandoCampoFilho(dto.getH().add(filho.getH()));
			dto.setIFormatandoCampoFilho(dto.getI().add(filho.getI()));
			dto.setJFormatandoCampoFilho(dto.getJ().add(filho.getJ()));			
			dto.setADFormatandoCampoFilho(dto.getAD().add(filho.getAD()));
			dto.setKFormatandoCampoFilho(dto.getK().add(filho.getK()));
			dto.setLFormatandoCampoFilho(dto.getL().add(filho.getL()));
			dto.setMFormatandoCampoFilho(dto.getM().add(filho.getM()));
			dto.setNFormatandoCampoFilho(dto.getN().add(filho.getN()));
			dto.setAEFormatandoCampoFilho(dto.getAE().add(filho.getAE()));
			dto.setAFFormatandoCampoFilho(dto.getAF().add(filho.getAF()));
			dto.setOFormatandoCampoFilho(dto.getO().add(filho.getO()));
			dto.setPFormatandoCampoFilho(dto.getP().add(filho.getP()));
			dto.setQFormatandoCampoFilho(dto.getQ().add(filho.getQ()));			
			dto.setRFormatandoCampoFilho(dto.getR().add(filho.getR()));
			dto.setANFormatandoCampoFilho(dto.getAN().add(filho.getAN()));
			dto.setSFormatandoCampoFilho(dto.getS().add(filho.getS()));
			dto.setTFormatandoCampoFilho(dto.getT().add(filho.getT()));
			dto.setUFormatandoCampoFilho(dto.getU().add(filho.getU()));
			
			dto.setWFormatandoCampoFilho(dto.getW().add(filho.getW()));
			dto.setXFormatandoCampoFilho(dto.getX().add(filho.getX()));
			
			V = V.add(filho.getV());
			Y = Y.add(filho.getY());
			Z = Z.add(filho.getZ());
			AA = AA.add(filho.getAA());
			AB = AB.add(filho.getAB());
			AG = AG.add(filho.getAG());
			AC = AC.add(filho.getAC());
		}
		
		V = calcularV(dto.getU(), dto.getT(), dto.getS());
		Y = calcularY(dto.getH(), dto.getJ());
		Z = calcularZ(dto.getO(), dto.getAE());
		AA = calcularAA(dto.getR(), dto.getO());
		AB = calcularAB(tipoFiltroOEE, dto.getR(), dto.getAE(), dto.getH(), dto.getAD());
		AG = calcularAG(dto.getR(), dto.getAF());
		AC = calcularAC(dto.getF(), dto.getD());
		
		dto.setVFormatandoCampoFilho(V);
		dto.setYFormatandoCampoFilho(Y);
		dto.setZFormatandoCampoFilho(Z);
		dto.setAAFormatandoCampoFilho(AA);
		dto.setABFormatandoCampoFilho(AB);
		dto.setAGFormatandoCampoFilho(AG);
		dto.setACFormatandoCampoFilho(AC);
		
		dto.setEficienciaSetupMeta(getMeta(ID_META_EFICIENCIA_SETUP));
		dto.setAtendimentoMeta(getMeta(ID_META_ATENDIMENTO));
		dto.setUtilizacaoMeta(getMeta(ID_META_UTILIZACAO));
		dto.setEficienciaMeta(getMeta(ID_META_EFICIENCIA));
		dto.setProdutividadeMeta(getMeta(ID_META_PRODUTIVIDADE_OEE));
		dto.setProdutividadeCMeta(getMeta(ID_META_PRODUTIVIDADE_OEE_CAPITAL));
		dto.setPpmilMeta(getMeta(ID_META_PPMIL));
	}
	
	private String getMeta(long id){
		OmCfgind ind = getMetaPorId(id);
		if(ind == null || ind.getIndSuperior() == null){
			return VALOR_DEFAULT_META_RELATORIO;
		}
		return ConversaoTipos.converteParaStringUsandoVirgula(ind.getIndSuperior(), 0)+"%";
	}
	
	private List<DwConsolid> consultaRelatorioProdutividadeR42(FiltroRelatorioProducaoR043DTO filtro, Date data, int tipoFiltro){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		
		data = cal.getTime();
		
		//System.out.println("--------------");
		//System.out.println("inicio: "+new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(data));
		
		cal.set(Calendar.MILLISECOND, 999);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		
		Date dataFinal = cal.getTime();
		if(tipoFiltro == FILTRO_SEMANAL){
		    cal.add(Calendar.DAY_OF_MONTH, 6);
		    dataFinal = cal.getTime();
		}
		//System.out.println("fim: "+new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(dataFinal));
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.dwFolha folha");
		q.append("left join pt.omObjs omobj");
		q.append("left JOIN folha.dwFolharaps folharap");
		q.append("left JOIN folharap.dwRap rap");
		q.append("LEFT JOIN rap.dwRapGrupos rapgrupo");
		q.append("LEFT JOIN rapgrupo.dwGrupoFerramenta gpferramenta");		
		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.stAtivo IS NULL");
		q.append("AND consolid.dwTurno.idTurno <> 1");
		q.append("AND consolid.dtReferencia BETWEEN :dataIncial and :dataFinal");
		
		
		if (filtro.isTodosHorarios() == false) {
			q.append("AND consolid.dwTurno.idTurno = :idturno");
		}
		
		if(filtro.getPosto() != null){
			q.append("AND consolid.omPt.cdPt = :cdpt");
		}
		
		else if(filtro.getGrupoTrabalho() != null) {
			q.append("AND omobj.omGtByIdGt.idGt = :idGt");
		}		
		
		if (filtro.getFerramenta() != null) {
			q.append("AND rap.idRap = :idrap");
		}
		
		if (filtro.getGrupoFerramenta() != null) {
			q.append("AND gpferramenta.idGrupoFerramenta = :idGpRap");
		}

		q.defineParametro("tpId", (byte)1);
		
		q.defineParametroTimestamp("dataIncial", data);
		q.defineParametroTimestamp("dataFinal", dataFinal);
		
		if (filtro.isTodosHorarios() == false) {
			q.defineParametro("idturno", filtro.getTurno().getTurno().getIdTurno());
		}
		
		if (filtro.getPosto() != null) {
			q.defineParametro("cdpt", filtro.getPosto().getCdPt());
		}
		
		if (filtro.getGrupoTrabalho() != null) {
			q.defineParametro("idGt", filtro.getGrupoTrabalho().getIdGt());
		}		
		
		if (filtro.getFerramenta() != null) {
			q.defineParametro("idrap", filtro.getFerramenta().getIdRap());
		}
		
		if (filtro.getGrupoFerramenta() != null) {
			q.defineParametro("idGpRap", filtro.getGrupoFerramenta().getIdGrupoFerramenta());
		}	
		//System.out.println("size:"+q.list().size());
		return q.list();
	}
	
	public OmCfgind getMetaPorId(Long id){
		MapQuery q = new MapQuery(this.getDao().getSession());		
		q.append("SELECT i ");
		q.append("FROM OmCfgind i ");
		q.append("WHERE i.omInd.idInd = :id");
		q.defineParametro("id", id);
		OmCfgind ind = (OmCfgind) q.uniqueResult();
		if(ind != null){
			return ind.clone();
		}
		return null;
	}
	
	private BigDecimal converterMilisegundoParaHora(long milisegundo){
		return new BigDecimal(milisegundo).divide(new BigDecimal(3600000), MathContext.DECIMAL32);
	}
	
	private BigDecimal converterSegundoParaHora(long segundo){
		return new BigDecimal(segundo).divide(new BigDecimal(3600), MathContext.DECIMAL32);
	}
	
	private BigDecimal converterSegundoParaMinuto(long segundo){
		return new BigDecimal(segundo).divide(new BigDecimal(60), MathContext.DECIMAL32);
	}
	
	private BigDecimal converterMilisegundoParaMinuto(long segundo){
		return new BigDecimal(segundo).divide(new BigDecimal(60000), MathContext.DECIMAL32);
	}
	
	private long getTempoParada(DwConsolpaoco oco){
		if(isParadaValida(oco) == false){
			return 0L;
		}
		
		long inicioParada = oco.getDthrIparada().getTime();
		long fimParada = oco.getDthrFparada().getTime();
		
		return fimParada - inicioParada;
	}
	
	private BigDecimal getPesoBrutoProdutoGrama(DwConsol dwconsol){
		double pesoBruto = 0;
		for (DwConsolpr dwconsolpr : dwconsol.getDwConsolprs()) {
			OmProduto omproduto = dwconsolpr.getOmProduto();
			if (omproduto != null && omproduto.getGPesoBruto() != null)
				pesoBruto += omproduto.getGPesoBruto().doubleValue();
		}
		return new BigDecimal(pesoBruto);
	}
	
	private boolean isParadaValida(DwConsolpaoco consolpaoco){
		if(consolpaoco.getDthrIparada() == null){
			return false;
		}
		
		if(consolpaoco.getDthrFparada() == null){
			return false;
		}
		return true;
	}
	
	//Evita o NPE (null point exception)
	private BigDecimal getBigDecimal(BigDecimal valor) {
		if(valor != null){
			return valor;
		}
		return BigDecimal.ZERO;
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
	
	private BigDecimal converterGramaParaKilo(BigDecimal grama){
		grama = getBigDecimal(grama);
		return grama.divide(new BigDecimal(1000));
	}
	
	private BigDecimal calcularV(BigDecimal U, BigDecimal T, BigDecimal S) {
		// V = U/( T/S )
		BigDecimal eficienciaSetupDivisor = dividir(T, S);
		return dividir(U, eficienciaSetupDivisor).multiply(new BigDecimal(100));
	}
	
	private BigDecimal calcularY(BigDecimal H, BigDecimal J) {
		// Y = H/J
		return dividir(H, J).multiply(new BigDecimal(100));
	}
	
	private BigDecimal calcularZ(BigDecimal O, BigDecimal AE) {
		// Z = O/AE
		return dividir(O, AE).multiply(new BigDecimal(100));
	}
	
	private BigDecimal calcularAA(BigDecimal R, BigDecimal O) {
		// AA = R/O
		return dividir(R, O).multiply(new BigDecimal(100));
	}
	
	private BigDecimal calcularAB(int tipoFiltroOEE, BigDecimal R, BigDecimal AE, BigDecimal H, BigDecimal AD) {
		// AB = R/AE
		if(tipoFiltroOEE == OEE_HORA){
			return dividir(R, AE).multiply(new BigDecimal(100));
		}
		
		// AB = H/AD
		if(tipoFiltroOEE == OEE_PECA){
			return dividir(H, AD).multiply(new BigDecimal(100));
		}
		
		return BigDecimal.ZERO;
	}
	
	private BigDecimal calcularAG(BigDecimal R, BigDecimal AF) {
		// AG = R/AF
		return dividir(R, AF).multiply(new BigDecimal(100));
	}
	
	private BigDecimal calcularAC(BigDecimal F, BigDecimal D) {
		// AC = ( TR1/D ) * 1000
		// como F=TR1 
		// AC = ( F/D ) * 1000
		return dividir(F, D).multiply(new BigDecimal(1000));
	}
}
