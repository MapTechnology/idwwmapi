package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RoteiroDesconhecidoException;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpNec;
import idw.model.pojos.PpNeccron;
import idw.model.pojos.PpPlanec;
import idw.model.pojos.PpPlano;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.util.IdwLogger;
import idw.webservices.dto.DadosDiaPlanProdDTO;
import idw.webservices.dto.PlanoAcompanhamentoDTO;
import idw.webservices.dto.PlanoAcompanhamentoDTOList;
import idw.webservices.dto.PlanoDTO;

public class MonitorizacaoPPRN extends AcompanhamentoPlanejamentoRN{

	public MonitorizacaoPPRN(){
	}
	
	public MonitorizacaoPPRN(DAOGenerico dao){
		super(dao);
	}
	
	/*
	 * Metodo principal para retorno dos dados a tela de monitorizacao do planejamento
	 */
	@Override
	public PlanoAcompanhamentoDTOList capturarAcompanhamentos(PlanoAcompanhamentoDTO planoAcomp) {
		inicializaQueryProducao();
		IdwLogger log = new IdwLogger("MonitorizacaoPPRN");
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		// Inicializa RNs externas para uso
		PlanoProducaoRN ppRN = new PlanoProducaoRN(dao);
		PedidoClienteRN necRN = new PedidoClienteRN(dao);
		
		// Inicializa objetos importantes para o metodo
		PlanoAcompanhamentoDTOList retorno = new PlanoAcompanhamentoDTOList();
		PlanoDTO planoDTO = planoAcomp.getPlanoDTO();
		ppRN.setIdPlano(planoDTO.getIdPlano());
		PpPlano ppplano = ppRN.pesquisarPlanoById();
		
		
		// Inicializa query para pesquisa das CPs
		MapQuery queryCps = new MapQuery(dao.getSession());
		
		queryCps.append("select ppcp");
		queryCps.append("from PpCp ppcp");
		queryCps.append("join fetch ppcp.ppCpprodutos ppcpproduto");
		queryCps.append("where ppcp.ppPlano = :ppplano");
		queryCps.append("and ppcp.stAtivo = 1");
		queryCps.append("and ppcpproduto.omProduto = :omproduto");
		
		queryCps.defineParametro("ppplano", ppplano);
		
		// ordena os ppplanecs
		List<PpPlanec> listaPpPlanec = new ArrayList<PpPlanec>(ppplano.getPpPlanecs());
		
		Collections.sort(listaPpPlanec, new Comparator<PpPlanec>() {
			@Override
			public int compare(PpPlanec o1, PpPlanec o2) {
				return o1.getPrioridade() < o2.getPrioridade() ? -1 : o1.getPrioridade() > o2.getPrioridade() ? +1 : 0;
			}
		});
		
		// 1o Passo: Para cada necessidade, gerar o PlanoAcompanhamento conforme o roteiro independente se existe ou nao CP
		for (PpPlanec ppplanec : ppplano.getPpPlanecs()) {
			PpNec ppnec = ppplanec.getPpNec();
			necRN.setIdNec(ppnec.getIdNec());
			necRN.setOmProduto(ppnec.getOmProduto());
			
			// Se a necessidade nao for do ano e mes de referencia entao descarta-la
			boolean isNecessidadeNoMesReferencia = false;
			
			for (PpNeccron ppneccron : ppnec.getPpNeccrons()){
				if ( DataHoraRN.isDataPertenceAoMes(ppneccron.getDtDesejada(), planoAcomp.getAnoReferencia(), planoAcomp.getMesReferencia()) == true ) {
					isNecessidadeNoMesReferencia = true;
					break;
				}
			}

			
			if (isNecessidadeNoMesReferencia == false)
				continue;
			
			// Caso o roteiro nao exista ou nao tenham passos uma excessao abaixo será gerada
			List<PassosDTO> passos = null;
			List<PlanoAcompanhamentoDTO> acompanhamentos = null;
			try {
				passos = necRN.pesquisarPassosDTO(log, idLog, identacao, ppplano);
				acompanhamentos = 	inicializaPlanoAcompanhamentoListAPartirDosPassos(ppnec, 0, true, passos).getAcompanhamentos();
			} catch (RoteiroDesconhecidoException e) {
				// Se nao existir roteiro preciso de alguma forma diferencia na monitorizacao. No momento vou deixar passos e acompnh
				passos = new ArrayList<PassosDTO>();
				acompanhamentos = new ArrayList<PlanoAcompanhamentoDTO>();
			}
			
			// Verifica se os acompanhamentos ja existem dentro da lista, se sim, acumula
			retorno.adicionaAcompanhamentoOuAcumula(acompanhamentos);
		}

		// 2o Passo: Para cada elemento do planoacompanhamento, preencher os dados com as cps que foram geradas
		PlanoAcompanhamentoDTO dtoAnterior = null;
		int iCor = 0;
		int corFrente[] = {0, 0};
		int corFundo[] = {255, 205};
		double qtTotalCps = 0d;
		double qtCpsAntecipacao = 0d;
		double qtCpsAtrasadas = 0d;
		double tempoAtrasos = 0d;
		
		for (PlanoAcompanhamentoDTO dto : retorno.getAcompanhamentos()){
			dto.setDiaReferencia(planoAcomp.getDiaReferencia());

			if (dtoAnterior == null)
				dtoAnterior = dto;
			
			// Determina a cor usada. Se for roteiro diferente muda a cor. Se for no mesmo roteiro mais o passo do dto for menor que o anterior tb muda
			if (
					dtoAnterior.getIdRota().equals(dto.getIdRota()) == false ||
					(dtoAnterior.getIdRota().equals(dto.getIdRota()) == true &&
							dtoAnterior.getPasso().intValue() >= dto.getPasso().intValue()
							)
					) {
				// Se mudou a rota,  entao o passo Anterior deve ter o seu Disponivel produzir zerado
				dtoAnterior.setDisponivelProduzir(0l);
				
				// E o dtoAnterior passa a ser o passo atual
				dtoAnterior = dto;
				
				if (iCor == 0)
					iCor = 1;
				else
					iCor = 0;
			}
			
			dto.setCorFrente(corFrente[iCor]);
			dto.setCorFundo(corFundo[iCor]);

			// incializar saldo do mes anterior
			BigDecimal saldoAnterior = calcularSaldoMesAnterior(dto.obtemOmproduto(), planoAcomp.getMesReferencia(), planoAcomp.getAnoReferencia());
			//Long saldoAnteriorApenasDoItem = saldoAnterior.longValue();
			
			// Obtem o saldo do mes anterior para o produto pai tb apenas para o ultimo passo
			if (dto.isUltimoPasso() == true) {
				saldoAnterior = saldoAnterior.add(calcularSaldoMesAnteriorNosProdutos(dto.obtemOmproduto(), planoAcomp.getMesReferencia(), planoAcomp.getAnoReferencia()));
			} else {
				// Se nao for o ultimo passo, por outro lado, deve-se somar ao estoque do item todos os demais estoques dos passos subsequentes
				// Mas nesse momento nao se tem o estoque apurado para esses passos futuros
				// Logo faremos isso apos a interacao desse loop
			}
			dto.setSaldoAnterior(saldoAnterior);

			// Produzido = Kit Total - Saldo Anterior
			Long produzido = calcularProduzidoMes(dto.obtemOmproduto(), planoAcomp.getMesReferencia(), planoAcomp.getAnoReferencia());
			// Agora devo tirar do produzido no mes o valor do saldo anterior apenas do item em questao, sem o saldo do item pai
			// Alessadnre: removi a linha abaixo em 02-02-13 comecei a pegar a producao de dwconsol ao inves de pegar 
			// a posicao do estoque
			//produzido -= saldoAnteriorApenasDoItem;
			if (produzido > 0)
				dto.setProduzidoMes(produzido);
			else
				dto.setProduzidoMes(0l);
			
			// Calcular a ser produzido pelas CPs atuais no plano fechado
			Long aSerProduzido = calcularASerProduzido(dto.obtemOmproduto());
			dto.setaProduzirCpsAtuais(aSerProduzido);
			
			// Nesse momento dto.setProduzidoMes contem o saldo atual do item, logo ele eh o KitTotal, por isso, vou joga-lo tb para kittotal
			// Isso nao eh verdade. o kit total sempre deve ser a soma do produzido no mes + saldo anterior, por isso comentei
			//dto.setKitTotal(dto.getProduzidoMes());

			// Kit Total = Saldo do mes anterior + produzido, logo eh o saldo atual em dwEstPro
			dto.setKitTotal(dto.getProduzidoMes() + dto.getSaldoAnterior().longValue() + dto.getaProduzirCpsAtuais());
			dto.setSaldoRealEstoque( dto.getKitTotal().intValue() ) ; //(int) (dto.getProduzidoMes() + saldoAnteriorApenasDoItem));

			// Recalculando o produzido no mes. Acho que eu tinha visto uma situacao em que isso nao da certo, 
			// mas nao sei qual. Lembrei, eh pq o saldoanterior tb tem o saldo do pai e para
			// calcular dessa forma nao podemos ter esse saldo, comentei abaixo mas a nivel de historico
			//dto.setProduzidoMes(dto.getProduzidoMes() - dto.getSaldoAnterior().longValue());
			
			
			//vou testar ve se funcionou e falta ainda determinar se esta coberto ou nao
			inicializarColunasDias(dto);

			// Calcula o disponivel produzir
			// quando o dtoAnterior nao for o dto
			if (dtoAnterior != dto)
				dtoAnterior.setDisponivelProduzir(dtoAnterior.getKitTotal() - dto.getKitTotal());

			// Procura CPs para a necessidade
			queryCps.defineParametro("omproduto", dto.obtemOmproduto());
			List<PpCp> listaCps = queryCps.list();
			double producaoPlanejada = 0d;
			
			// as cps sao percorridas apenas para calculo dos indicadores da monitorizacao
			// e para encontrar a coluna QtdPlanejada
			for (PpCp ppcp : listaCps) {
				
				// Conta o total de cps
				qtTotalCps++;
				
				// Conta o total de cps em atraso
				if (DataHoraRN.before(ppcp.getDthrInicio(), DataHoraRN.getDataHoraAtual()) == true) {
					qtCpsAtrasadas++;
					
					// Calcula o tempo de atraso da CP
					tempoAtrasos += DataHoraRN.getQuantidadeSegundosNoPeriodo(ppcp.getDthrInicio(), DataHoraRN.getDataHoraAtual());
				}
				
				// Conta o total de cps de antecipacao
				if (ppcp.getIsAntecipacao() == true)
					qtCpsAntecipacao++;

				// Adiciona a CP a lista de retornos das cps independente se eh do mes de referencia
				PpCp ppcpClone = ppcp.clone(false);
				ppcpClone.setPpCpprodutos(new HashSet<PpCpproduto>());
				OmPt ompt = ppcp.getOmPt();
				if (ompt != null)
					ompt = ompt.clone(false);
				
				OmGt omgt = ppcp.getOmGt();
				if (omgt != null)
					omgt = omgt.clone();
				ppcpClone.setOmPt(ompt);
				ppcpClone.setOmGt(omgt);
				
				// Somar apenas as Cps que iniciarem no m�s de referencia
				if (DataHoraRN.isDataPertenceAoMes(ppcp.getDthrInicio(), planoAcomp.getAnoReferencia(), planoAcomp.getMesReferencia()) == true) {
					for (PpCpproduto ppcpproduto : ppcp.getPpCpprodutos()){
						producaoPlanejada += ppcpproduto.getPcsProducaoplanejada().doubleValue();
						PpCpproduto ppcpprodutoClone = ppcpproduto.clone();
						ppcpClone.getPpCpprodutos().add(ppcpprodutoClone);
					}
				}
				retorno.getPpcps().add(ppcpClone);
			}
			dto.setSomaPlanejada(producaoPlanejada);
			
			// Setar a necessidade da linha
			// Isso ja eh feito no momento em que o retorno possui a lista PpNec


			// O dtoAnterior passa a ser o dto que foi avaliado
			dtoAnterior = dto;

		}
		

		
		// Vou executar um passo intermediario entre o 2 e o 3 com o objetivo de ajustar os valores do saldo inicial do mes, kit total e o DIsponivel produzir
		// O ideal era ter feito isso no loop anterior para ser mais rapido, mas por falta de tempo vou fazer isso aqui
		// mas com a perspectiva de unir com o loop anterior. Para unir � necesss�rio que no loop anterior os passos sejam ordenados do ultimo passo para o 1o
		// facilitando o calculo do estoque inicial dos passos anteriores, visto que esses passos anteriores recebem alem do seu proprio estoque o estoque dos passos seguintes
		for (PlanoAcompanhamentoDTO dto : retorno.getAcompanhamentos()){
			// Ajusta o saldo do estoque do mes anterior
			Long saldoAnterior = dto.getSaldoAnterior().longValue();
			Long saldoAnteriorProximosPassos = somaSaldoInicial(retorno.getAcompanhamentos(), dto);
			Long saldo = saldoAnterior + saldoAnteriorProximosPassos;
			dto.setSaldoAnterior(new BigDecimal(saldo));
			
			// Ajusta o kit total
			// Kit Total = Saldo do mes anterior + produzido, logo eh o saldo atual em dwEstPro
			dto.setKitTotal(dto.getProduzidoMes() + dto.getSaldoAnterior().longValue());
			dto.setSaldoRealEstoque( dto.getKitTotal().intValue() ); // (int) (dto.getProduzidoMes() + saldoAnterior ));
			
			// ajusta o disponivel produzir
			if (dtoAnterior == null)
				dtoAnterior = dto;
			
			// Determina a cor usada. Se for roteiro diferente muda a cor. Se for no mesmo roteiro mais o passo do dto for menor que o anterior tb muda
			if (
					dtoAnterior.getIdRota().equals(dto.getIdRota()) == false ||
					(dtoAnterior.getIdRota().equals(dto.getIdRota()) == true &&
							dtoAnterior.getPasso().intValue() >= dto.getPasso().intValue()
							)
					) {
				// Se mudou a rota,  entao o passo Anterior deve ter o seu Disponivel produzir zerado
				dtoAnterior.setDisponivelProduzir(0l);
				
				// E o dtoAnterior passa a ser o passo atual
				dtoAnterior = dto;
			}
			// Calcula o disponivel produzir
			// quando o dtoAnterior nao for o dto
			if (dtoAnterior != dto)
				dtoAnterior.setDisponivelProduzir(dtoAnterior.getKitTotal() - dto.getKitTotal());

			// Vou aproveitar aqui tb eh revalidar a cobertura dos pedidos
			
			long saldoDisponivel = dto.getKitTotal();
			for (DadosDiaPlanProdDTO  dd : dto.getDias()){
				if (dd != null && dd.getValorDia() != null) {
					saldoDisponivel -= dd.getValorDia();
					dd.setCoberto(saldoDisponivel >= 0);
				}
			}
			
			// O dtoAnterior passa a ser o dto que foi avaliado
			dtoAnterior = dto;

		}

		// 3o Passo: seta os indicadores de acompanhamento
		// Para tanto interagir sobre o retorno, analisando
		// Indice de atraso = % de quantas CPs que deveriam ter comecado nao comecaram
		// Indice de antecipacao = % de CPs no mes que esta produzindo para o mes seguinte
		// Media de atrasos = tempo medio do intervalo entre o inicio planejado e o real
		double indiceAtraso = 0d;
		double indiceAntecipacao = 0d;
		double mediaAtrasos = 0d;
		
		if (qtTotalCps > 0){
			indiceAtraso = (int) ((qtCpsAtrasadas / qtTotalCps) * 100);
			indiceAntecipacao = (int) ((qtCpsAntecipacao / qtTotalCps) * 100);
		}
		if (qtCpsAtrasadas > 0) {
			mediaAtrasos = tempoAtrasos / qtCpsAtrasadas;
			mediaAtrasos /= 3600;
			mediaAtrasos = (int) mediaAtrasos;
		}
		
		
		retorno.setIndiceAtraso(indiceAtraso);
		retorno.setIndiceAntecipacao(indiceAntecipacao);
		retorno.setMediaAtrasos(mediaAtrasos);
		
		// 4o Passo: Uma tentativa de ordenar adequadamente o resultado
		Collections.sort(retorno.getAcompanhamentos(), new Comparator<PlanoAcompanhamentoDTO>() {
			@Override
			public int compare(PlanoAcompanhamentoDTO o1, PlanoAcompanhamentoDTO o2) {
				int retorno = 0;
				if (o1.getCnt().compareTo(o2.getCnt()) == 0) {
					if (o1.getIdRota() > o2.getIdRota())
						retorno = 1;
					else if (o1.getIdRota() < o2.getIdRota())
						retorno = -1;
					else if (o1.getIdPasso() > o2.getIdPasso())
						retorno = 1;
					else if (o1.getIdPasso() < o2.getIdPasso())
						retorno = -1;
				} else {
					retorno = o1.getCnt().compareTo(o2.getCnt());
				}
				return retorno;
			}
		});
		
		// 5o Passo: Colorir o fundo novamente
		for (PlanoAcompanhamentoDTO dto : retorno.getAcompanhamentos()){
			if (dtoAnterior == null)
				dtoAnterior = dto;
			
			// Determina a cor usada. Se for roteiro diferente muda a cor. Se for no mesmo roteiro mais o passo do dto for menor que o anterior tb muda
			if (
					dtoAnterior.getIdRota().equals(dto.getIdRota()) == false ||
					(dtoAnterior.getIdRota().equals(dto.getIdRota()) == true &&
							dtoAnterior.getPasso().intValue() >= dto.getPasso().intValue()
							)
					) {

				// E o dtoAnterior passa a ser o passo atual
				dtoAnterior = dto;
				
				if (iCor == 0)
					iCor = 1;
				else
					iCor = 0;
			}
			dto.setFaltaSobra(dto.getKitTotal() - dto.getProducaoTotal());
			dto.setCorFrente(corFrente[iCor]);
			dto.setCorFundo(corFundo[iCor]);
		}
		
		return retorno;
	}

	/*
	 * 
	 */
	private Long somaSaldoInicial(List<PlanoAcompanhamentoDTO> acompanhamentos, PlanoAcompanhamentoDTO dto) {
		Long retorno = 0l;
		boolean isDtoEncontrado = false;
		
		if (dto.isUltimoPasso() == true)
			return retorno;
		
		for (PlanoAcompanhamentoDTO aco : acompanhamentos) {
			// encontra o item que se quer somar a partir dele
			if (aco == dto) {
				isDtoEncontrado = true;
			} else if (isDtoEncontrado == true) {
				retorno += aco.getSaldoAnterior().longValue();
				// Verifica se chegou ao ultimo passo
				if (aco.isUltimoPasso() == true)
					break;
			}
		}
		return retorno;
	}
	
	/*
	 * Iniciliza o dto de retorno (PlanoAcompanhamentoDTOList) do metodo principal (acima) recursivamente com os passos do roteiro
	 */
	private PlanoAcompanhamentoDTOList inicializaPlanoAcompanhamentoListAPartirDosPassos(PpNec ppnec, int idPasso, boolean isSomarPasso, List<PassosDTO> passos){
		PlanoAcompanhamentoDTOList retorno = new PlanoAcompanhamentoDTOList();
		
		for (PassosDTO passo : passos){
			if (isSomarPasso == true)
				idPasso++;
			
			PlanoAcompanhamentoDTO linha = new PlanoAcompanhamentoDTO(passo);
			linha.setIdPasso(idPasso);
			
			// Acrescentar na linha o ppnec clonado para ele poder ir ao cliente desktop. assim o mesmo podera mostrar as necessidade no tree
			linha.getListaPpnec().add(ppnec.clone());
			retorno.getAcompanhamentos().add(linha);
			
			// Adiciona os passos da predecessora
			retorno.getAcompanhamentos().addAll(inicializaPlanoAcompanhamentoListAPartirDosPassos(ppnec, idPasso, false, passo.getPassosPredecessoras()).getAcompanhamentos());
		}
		
		return retorno;
	}
	
	/*
	 * Metodo sobreescrito que encontra a producao solicita pelos clientes
	 */
	@Override
	protected void inicializarColunasDias(PlanoAcompanhamentoDTO acomp) {
		double saldoDisponivel = acomp.getKitTotal();
		double producaoTotal = 0d;
		double producaoAteODia = 0d;
		// Varre as datas solicitadas
		for (PpNec ppnec : acomp.getListaPpnec()){
			// As ppneccron devem estar por ordem de data, senao as colunas cobertas (verde) podem ficar com saltos
			List<PpNeccron> listaPpNeccron = new ArrayList<PpNeccron>(ppnec.getPpNeccrons());
			Collections.sort(listaPpNeccron, new Comparator<PpNeccron>() {

				@Override
				public int compare(PpNeccron o1, PpNeccron o2) {
					return (DataHoraRN.before(o1.getDtDesejada(), o2.getDtDesejada()) ? -1 : (DataHoraRN.after(o1.getDtDesejada(), o2.getDtDesejada()) ? +1 : 0));
				}
			});
			
			for (PpNeccron ppneccron : listaPpNeccron) {
				saldoDisponivel -= ppneccron.getQtDesejada().doubleValue();
				producaoTotal += ppneccron.getQtDesejada().doubleValue();
				int ndia = DataHoraRN.getApenasDia(ppneccron.getDtDesejada());
				if (ndia <= acomp.getDiaReferencia())
					producaoAteODia += ppneccron.getQtDesejada().doubleValue();

				DadosDiaPlanProdDTO dadosDia = new DadosDiaPlanProdDTO();
				dadosDia.setValorDia(ppneccron.getQtDesejada().doubleValue());
				dadosDia.setCoberto((saldoDisponivel >= 0));
				acomp.addProducaoPlanejadaNoDia(DataHoraRN.getApenasDia(ppneccron.getDtDesejada()), dadosDia);
			}
		}
		acomp.setProducaoTotal(producaoTotal);
		acomp.setQtdeProducaoSimulacao((int)producaoAteODia);
	}
}
