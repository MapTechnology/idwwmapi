package idw.model.rn.consolidacao.producao;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.MapQuery;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsoldef;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhamon;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.DwMacrange;
import idw.model.pojos.DwNsMp;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPassdef;
import idw.model.pojos.DwPassmon;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.DwTOrigem;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsEvtdefeito;
import idw.model.pojos.MsEvtmontagem;
import idw.model.pojos.OmAlim;
import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProrange;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcnc;
import idw.model.pojos.OmReel;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpnserie;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwMacrangeTemplate;
import idw.model.pojos.template.DwPassagemTemplate;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.pojos.template.OmProrangeTemplate;
import idw.model.rn.AreaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.MacRN;
import idw.model.rn.NumeroSerieRN;
import idw.model.rn.OrigemRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.VerificaDefeitoRN;
import idw.model.rn.VerificaPassagemRN;
import idw.model.rn.alimentacao.AlimentacaoRN;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.util.IdwLogger;
import idw.util.Util;
import injetws.model.excessoes.SemSGBDException;
import ms.util.ConversaoTipos;

public class ConsolidacaoPassagem extends ConsolidacaoProducao implements IConsolidacao{

	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwConsolpt, List<DwCalsem> dwCalsems, MsEvt msevt, OmCfg omcfg, IdwLogger log, int idLog, int identacao)  throws SemCalendarioException, SemSGBDException, SemCicloPadraoException, SemPlanejamentoException, NumeroSerieIrregularException {

		Validate.notNull(omPt, "Posto de trabalho esta nulo");
		Validate.notNull(omPt.getIdPt(), "idPt esta nulo");

		log.iniciaAvaliacao("obtemPpCp");
		final PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msevt, omcfg);
		log.paraAvaliacao(new BigDecimal(msevt.getIdEvt()), getDao());

		Validate.notNull(ppCp, "ppCp nao pode ser nulo");


		// Pega a folha ativa
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		final DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		Validate.notNull(dwFolha,"nao tem folha ativa para o ppCp");

		/*
		 * Inserir o numero de serie em DWNSERIE caso o mesmo n�o exista
		 */
		NumeroSerieRN rn = new NumeroSerieRN(getDao());
		DwNserie dwnseriedb = null;
		log.info(idLog, 0, "pesquisando ns com cb = " + msevt.getCb());
		dwnseriedb = rn.getDwNserieCb(msevt.getCb());
		
		OmProduto omProduto = null;

		/* a flag isConsumirMateriaPrima foi criada para evitar o consumo duplo da materiaprima quando o mesmo codigo de barras for lido
		 * Entretanto, o ideal era verificar se eh a 1a passagem do CB no posto e nao 
		 */
		boolean isConsumirMateriaPrima = false;
		if (dwnseriedb == null) {
			isConsumirMateriaPrima = true;
			log.info(idLog, 0, "NAO EXISTE cb = " + msevt.getCb());
			//throw new NumeroSerieIrregularException();
			// Alessandre em 30-07-15 comentei a inclusao do NS pois o CB lido pode ser um codigo de qq coisa logo descartar o evento
			// Alessandre em 11-11-16 voltei com o codigo abaixo para incluir um NS pois na Mondial o evento estava sendo descartado pq o NS nao existe
			// e aparentemente a validacao da etiqueta nao incluiu o NS
			/* Alessandre em 02-02-17 na mondial se o NS nao existir avaliar se o produto da op esta no cb lido
			 * Incluir somente se for um produto valido. Se nao retornar a excessao
			 */
			ProdutoRN prn = new ProdutoRN(getDao());
			String cdProduto = "";
			try {
				cdProduto = Util.extraiPorMascara(msevt.getCb(), omcfg.getMascaracdprodutoCB());
				if (cdProduto != null)
					omProduto = prn.getOmProduto(cdProduto);
				log.info(idLog, 0, "Produto encontrado " + msevt.getCb());
			} catch (RegistroDesconhecidoException e) {
				omProduto = null;
				// Alessandre em 14-08-15 o evento de fim do ciclo sera descartado pois o CB nao existe em omproduto
				// Alessandre em 15-02-17 comentei a linha abaixo por causa da GBR pois poderá haver CBs que nao estejam no padrão. Assim, sera assunmido
				// o produto que está na OP, conforme segue no codigo. Para os ciclos gerados a partir da passagem, os mesmos deverao estar sem o CB para nao se validar esse aspecto
				//Validate.notNull(omProduto, "produto nao existe " + cdProduto + " com mascara " + omcfg.getMascaracdprodutoCB());
			}

			dwnseriedb = new DwNserie();
			// alessandre em 30-07-15 comentei a linha abaixo e substitui pela seguinte
			//dwnseriedb.setCb(Util.extraiPorMascara(msevt.getOrigem(), omcfg.getMascaracb()));
			dwnseriedb.setCb(msevt.getCb());
			dwnseriedb.setCbserial(msevt.getCbserial());
			dwnseriedb.setDwEst(null);
			dwnseriedb.setIdNserie(0l);
			dwnseriedb.setNs(msevt.getCb());
			dwnseriedb.setOmProduto(omProduto);
			log.info(idLog, 0, "Conteudo cb=" + dwnseriedb.getCb() + " ns= "+ dwnseriedb.getNs());
			dwnseriedb = getDao().makePersistent(dwnseriedb);
		} else if ( (dwnseriedb.getCbserial() == null || dwnseriedb.getCbserial().trim().equals("")) && msevt.getCbserial() != null && msevt.getCbserial().trim().equals("") == false) {
			dwnseriedb.setCbserial(msevt.getCbserial());
			dwnseriedb = getDao().makePersistent(dwnseriedb);
		}

		if (dwnseriedb.getOmProduto() == null) {
			ProdutoRN prn = new ProdutoRN(getDao());
			if (msevt.getCdProduto() != null && msevt.getCdProduto().equals("") == false) {
				try {
					omProduto = prn.getOmProduto(msevt.getCdProduto());
				} catch (RegistroDesconhecidoException e) {
					log.info("nao encontrou o produto " + msevt.getCdProduto());
					omProduto = null;
				}
			}
			if (omProduto == null) {
				for (PpCpproduto p : ppCp.getPpCpprodutos() ) {
					omProduto = p.getOmProduto();
				}
				dwnseriedb.setOmProduto(omProduto);
			}
		} else if (omProduto == null) {
			omProduto = dwnseriedb.getOmProduto();
		}
		
		/* Alessandre em 02-04-2019 Para o blockchain da Flex é necessario associar ao numero de serie, as materias-primas apontadas no CF
		 * 
		 */
		if (isConsumirMateriaPrima)
			associarMPaoNS(dwnseriedb, omPt, msevt, dwFolha);

		// Verifica se existe a relacao entre a OP e o NS. se nao existir, incluir
		PpCpnserie cpnserie = rn.getPpCpnserieByCpNserie(ppCp, dwnseriedb);
		if (cpnserie == null) {
			cpnserie = new PpCpnserie();
			cpnserie.setDwNserie(dwnseriedb);
			cpnserie.setPpCp(ppCp);
			cpnserie.setIdCpserie(null);
		}

		// Obter o ultimo operador logado que permanece logado
		List<DwConsolmolog> lista = getDwConsolmologComLoginAberto(omPt.getIdPt());
		OmUsr omusr = null;
		if (lista != null && lista.isEmpty() == false) {
			omusr = lista.get(lista.size()-1).getOmUsr();
		}
		
		// Pode ser que nao tenha um operador logado, entao assumiremos o usuario da configuracao geral, assim,
		// caso seja necessario incluir um produto, nao teremos erro de insert em omproduto por falta de usuario
		if (omusr == null) {
			omusr = omcfg.getOmUsrimpprog();
		}

		// Obter dwConsolid do turno
		DwConsolid dwconsolidTurno = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, msevt.getDthrEvento(), omcfg, msevt.getDwPepro());

		// Obtem dwConsolid da hora
		DwConsolid dwconsolidHora = this.obtemConsolIdHora(omPt, dwCalsems, ppCp, dwFolha, msevt.getDthrEvento(), omcfg, msevt.getDwPepro());


		TempoRealRN.setDthrEmDwRtBaseadoNosEventos(dwconsolidTurno.getDwRt(), msevt.getDthrEvento());
		/*
		 * Inserir em DwPassagem
		 */
		DwPassagem dwpassagem = new DwPassagem();
		dwpassagem.setDthr(msevt.getDthrEvento());
		dwpassagem.setDthrInicio(msevt.getDthrEvento());
		dwpassagem.setDwConsolid(dwconsolidTurno);
		dwpassagem.setDwEst(null);
		dwpassagem.setDwNserie(dwnseriedb);
		dwpassagem.setIdPassagem(0l);
		dwpassagem.setIsTfFinalizado(true);
		dwpassagem.setIsMontagemfechadaantecipadamente(msevt.getIsMontagemfechadaantecipadamente());
		dwpassagem.setMsDthr(DataHoraRN.getApenasMilisegundos(msevt.getDthrEvento()));
		dwpassagem.setMsDthrinicio(DataHoraRN.getApenasMilisegundos(msevt.getDthrEvento()));
		dwpassagem.setOmPt(omPt);
		dwpassagem.setOmUsrByIdUsroperador(omusr);
		dwpassagem.setOmUsrByIdUsrsupervisor(null);
		dwpassagem.setSegCiclo(new BigDecimal(DataHoraRN.getQuantidadeSegundosNoPeriodo(dwpassagem.getDthrInicio(), dwpassagem.getDthr())));
		
		if (msevt!=null && msevt.getSeqbigint()!=null && msevt.getSeqbigint().longValue()>0L){
			dwpassagem.setSequencial(msevt.getSeqbigint());
		}

		//
		if (msevt.getTpErromontagem() != null && msevt.getTpErromontagem().intValue() > 0)
			dwpassagem.setStNserie(DwPassagemTemplate.StNserie.NAO_CONFORME.getValue());
		else
			dwpassagem.setStNserie(DwPassagemTemplate.StNserie.CONFORME.getValue());

		/* Verificar se veio a area responsavel pela passagem (no caso defeito)
		 *
		 */
		AreaRN arn = new AreaRN(getDao());

		if (msevt.getCdArea() != null && msevt.getCdArea().equals("") == false) {
			DwTArea dwtarea;
			try {
				dwtarea = arn.getDwTArea(msevt.getCdArea(), true);
			} catch (RegistroDesconhecidoException e) {
				dwtarea = null;
			}
			dwpassagem.setDwTArea(dwtarea);
		}

		getDao().makePersistent(dwpassagem);

		tratarDefeito(omPt, msevt, omcfg, dwconsolidTurno, dwconsolidHora, dwpassagem, arn);

		// Verificar se existe montagem a ser salva
		tratarMontagem(omPt, msevt, omcfg, dwFolha, dwnseriedb, omusr, dwpassagem, log, idLog);
		
		// Verificar e tratar se o passo reseta os testes de outros passos
		tratarBoot(omPt, msevt, omcfg, dwFolha, dwnseriedb, omusr, dwpassagem, omProduto, log, idLog);
		
		
		/* Alessandre em 26-03-19 com a mudanca de controle de MAC por produto ao inves de linha, a tabela
		 * DwMacRange eh utilizada apenas para o range pai. E a macuso deixou de ser usada pois o correto eh utilizar a dwnserei
		 * Assim o treho abaixo foi comentado
		// Verificar se o banco de materia-prima será consumida com a producao do semi-acabado
		DwMacrange macrange = isMateriaPrimaLimitada(dwnseriedb.getCb(), omPt);
		
		if (macrange != null) {
			// Registrar o consumo da materia prima limitada
			DwMacuso macuso = new DwMacuso();
			macuso.setDthrUso(msevt.getDthrEvento());
			macuso.setDwMacrange(macrange);
			macuso.setCdMac(dwnseriedb.getCb());
			
			getDao().makePersistent(macuso);
		}
		 */
		
		// Encontrar o OmProrange
		OmProduto omproduto = dwFolha.obtemProduto();
		OmProrange omprorange = null;
		omprorange = pesquisarOmProrange(omproduto, dwnseriedb.getCb());
		
		// Se tiver range e se o mac ainda nao tiver sido consumido, consumir
		if (omprorange != null && (dwnseriedb.getIsConsumido() == null || dwnseriedb.getIsConsumido() == false)) {
			dwnseriedb.setOmProrange(omprorange);
			dwnseriedb.setIsConsumido(true);
			BigDecimal qtConsumida = omprorange.getQtConsumida();
			if (qtConsumida == null)
				qtConsumida = BigDecimal.ZERO;
			qtConsumida = qtConsumida.add(BigDecimal.ONE);
			omprorange.setQtConsumida(qtConsumida);
			getDao().makePersistent(omprorange);
		}
		
		dwnseriedb = getDao().makePersistent(dwnseriedb);
	
	}
	
	public static void main(String[] args) {
		BigDecimal qtdeConsumidaPorNS = new BigDecimal(8);
		BigDecimal producaoPorCiclo = new BigDecimal(3);
		BigDecimal teste = qtdeConsumidaPorNS.divide(producaoPorCiclo, 0, RoundingMode.DOWN); // MathContext.DECIMAL128);
		System.out.println(teste);
		
	}
	
	
	/* Metodo para verificar e associar o consumo de materia-prima ao numero de serie
	 * A mp consumida será a MP disponivel em omalimrea no momento da consolidacao
	 */
	private void associarMPaoNS(DwNserie ns, OmPt ompt, MsEvt msevt, DwFolha dwFolha) {
		IdwLogger log = new IdwLogger("associarMPaoNS-" + ompt.getCdPt());
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		// Obter a relacao de todas as alimrea que ainda nao foram consumidads
		List<OmAlimrea> lista = obtemAlimreaASerConsumido(ompt, ns);
		
		if (lista != null) {
			
			FolhaRN folhaRN = new FolhaRN(getDao());
			BigDecimal producaoPorCiclo;
			try {
				producaoPorCiclo = folhaRN.getPcsPorCicloAtivas(dwFolha);
			} catch (SemPcsPorCicloAtivasException e1) {
				log.info(idLog, identacao, "Assumindo producao por ciclo 1");
				producaoPorCiclo = BigDecimal.ONE;
			}
			
			// Se a producao por ciclo encontrada for diferente da qtde enviada no msevt.qtde, utilizar msevt.qtde, pois a mesma pode ter a qtde de codigos de barras identificados
			if (msevt.getQtde() != null && producaoPorCiclo.compareTo(msevt.getQtde()) != 0 && msevt.getQtde().compareTo(BigDecimal.ZERO) > 0) {
				producaoPorCiclo = msevt.getQtde();
			}

			// Ordela a lista de omalimrea das mais antigas as mais receentes. Ou seja, as mais antigas devem ser consumidas 1o que as mais recentes
			Collections.sort(lista, new Comparator<OmAlimrea>() {
				@Override
				public int compare(OmAlimrea o1, OmAlimrea o2) {
					return o1.getIdAlimrea().compareTo(o2.getIdAlimrea()); // * -1; // pq estou usando -1. Nao deveria ser apenas 1??? para ser e ordem crescente?? debugar
				}
			});
			
			AlimentacaoRN rn = new AlimentacaoRN();
			rn.setDao(getDao());

			/* tem uma situacao em que a realimentacao inclui varias vezes para o mesmo feeder por exemplo a placa, e estava consumindo para todas as realimentacoes
			tenho q consumir apenas a mais antiga com saldo e nao considerar as outras
			A olucao sera criar um vetor com os feeder ja consumidos na interacao
			*/
			List<String> feederJaConsumidos = new ArrayList<>();
			BigDecimal qtdeRestanteParaConsumo = null;
			
			for (OmAlimrea omalimrea : lista) {

				boolean isMostrarLog = false;
				String grupo = "";
				
				try {
					grupo = omalimrea.getOmMapapa().getOmProduto().getOmProgrp().getCdProgrp();
					if (grupo.equals("0") == false)
						isMostrarLog = true;
				} catch (Exception e) {
					log.info(idLog, identacao, "Excessao:", e);
					isMostrarLog = true;
					grupo = "erro";
				}
				
				// Avalia se o feeder já foi consumido, se sim nao precisa mais consumir.
				if (feederJaConsumidos.contains(omalimrea.getCbRap()) || omalimrea.getQtAlimentada() == null || omalimrea.getQtAlimentada() <= 0 || (omalimrea.getQtAtual() != null && omalimrea.getQtAtual().compareTo(BigDecimal.ZERO) <= 0) ) {
					if (isMostrarLog)
						log.info(idLog, identacao, grupo + " - desconsiderando omalimrea=" + omalimrea.getIdAlimrea() + " qtalimentada=" + omalimrea.getQtAlimentada() + " qtatual=" + omalimrea.getQtAtual());
					continue;
				}
				
				/*
				 * Alessandre em 07-05-19 verificar se o Reel Id já foi usado para alimentar o feeder. Se sim, então essa nova alimentação
				 * não deve ser considerada como credito no estoque. Alem disso devemos dividir a qtsada no feeder pela quantidade de placas
				 * produzidas por ciclo, dessa forma enontramos a qtde de componente usados por cada NS
				 */
				BigDecimal qtdeConsumidaPorNS = omalimrea.getOmMapapa().getQtUsada();

				// Se o CB comecar com NS significa que foi gerado automaticamente, nesse caso nao faremos a divisao abaixo
				if (ns.getCb().trim().substring(0, 2).equals("NS") == false)
					qtdeConsumidaPorNS = qtdeConsumidaPorNS.divide(producaoPorCiclo, 0, RoundingMode.DOWN);
				
				if (isMostrarLog)
					log.info(idLog, identacao, omalimrea.getOmMapapa().getOmPa().getCdPa() + "=" + grupo +  " - qtdeNoMapa = " + omalimrea.getOmMapapa().getQtUsada() + " producaoPorCiclo=" + producaoPorCiclo + " qtdeConsumidaPorNS=" + qtdeConsumidaPorNS);

				if (omalimrea.getQtPorplaca() == null || (omalimrea.getQtPorplaca().compareTo(BigDecimal.ZERO) == 0 && qtdeConsumidaPorNS.compareTo(BigDecimal.ZERO) > 0))
					omalimrea.setQtPorplaca(qtdeConsumidaPorNS);

				BigDecimal qtdeConsumidaTotal = omalimrea.getQtUsada();
				BigDecimal qtdeConsumidaTotalAnterior = omalimrea.getQtUsada();
				if (qtdeConsumidaTotal == null) {
					qtdeConsumidaTotal = BigDecimal.ZERO;
					if (isMostrarLog)
						log.info(idLog, identacao + 5, grupo + " - saldo null, assumindo 0");
				}
				
				// Caso tenha sobrado algum valor a ser consumido do processamento anterior entao utiliza-lo como referencia
				if (qtdeRestanteParaConsumo != null) {
					qtdeConsumidaPorNS = qtdeRestanteParaConsumo;
					qtdeRestanteParaConsumo = null;
				}

				qtdeConsumidaTotal = qtdeConsumidaTotal.add(qtdeConsumidaPorNS);
				
				// Verificar se existe algo para se consumir, senao passa pra proximo
				if (
						omalimrea.getQtPorplaca() == null || 
						omalimrea.getQtPorplaca().compareTo(BigDecimal.ZERO) == 0) {
					getDao().makePersistent(omalimrea);
					continue;
				}
				
				/* Pode ocorrer da quantidade a ser consumida seja maior que a alimentada, nesse caso, devemos consumir ate o limite da alimentacao e o que sobrar 
				 * utlizar para a proxima alimentacao
				 */
				if (qtdeConsumidaTotal.compareTo(new BigDecimal(omalimrea.getQtAlimentada())) > 0) {
					// Calcular o que falta ser consumido. Essa quantidade deve ser consumida na proxima realimentacao
					qtdeRestanteParaConsumo = qtdeConsumidaTotal.subtract(new BigDecimal(omalimrea.getQtAlimentada()));
					
					// Consome o total alimentado
					qtdeConsumidaTotal = new BigDecimal(omalimrea.getQtAlimentada());
					
					
					// Remove o feeder da relacao dos ja consummidos para consumir novamente na proxima reailmentacao dispoinivel
					feederJaConsumidos.remove(omalimrea.getCbRap());
				}
				
				if (isMostrarLog)
					log.info(idLog, identacao + 5, "qtAlimentada=" + omalimrea.getQtAlimentada() + " qtUsadaAnterior=" + omalimrea.getQtUsada() + " qtde=" + qtdeConsumidaPorNS + " novaQtUsada=" + qtdeConsumidaTotal);

				omalimrea.setQtUsada(qtdeConsumidaTotal);

				BigDecimal qtAtualAnterior = omalimrea.getQtAtual();
				BigDecimal qtAtual = new BigDecimal(omalimrea.getQtAlimentada());
				if (isMostrarLog)
					log.info(idLog, identacao + 5, "qtAlimentada=" + qtAtual);
				qtAtual = qtAtual.subtract(omalimrea.getQtUsada());
				
				if (isMostrarLog)
					log.info(idLog, identacao + 5, "qtAlimentada-qtUsada = qtAtual =" + qtAtual);

				if (omalimrea.getQtPerdida() != null) {
					qtAtual = qtAtual.subtract(omalimrea.getQtPerdida());
					if (isMostrarLog)
						log.info(idLog, identacao + 5, "qtAlimentada-qtUsada-qtPerdida = qtAtual =" + qtAtual);
				}

				omalimrea.setQtAtual(qtAtual);

				getDao().makePersistent(omalimrea);

				if (isMostrarLog)
					log.info(idLog, identacao, omalimrea.getIdAlimrea() + " - Alterando qtUsada de " + qtdeConsumidaTotalAnterior + " para " + qtdeConsumidaTotal + " e qtAtual anterior de " + qtAtualAnterior + " para " + qtAtual);				
				
				
				
				// Inserir em dwnsmp somente se a qt por placa > 0
				// quando for zero siginifica que o componente é alimentado de forma integral em outro feeder
				if (omalimrea.getQtPorplaca() != null && omalimrea.getQtPorplaca().compareTo(BigDecimal.ZERO) > 0) {
					DwNsMp nsmp = new DwNsMp();
					nsmp.setIdNsmp(null);
					nsmp.setDwNserie(ns);
					nsmp.setOmPt(ompt);
					nsmp.setOmAlimrea(omalimrea);
					nsmp.setOmGt(ompt.getOmGt());
					nsmp.setOmProduto(omalimrea.getOmMapapa().getOmProduto());
					nsmp.setNrop(ompt.getPpCp().getNrop());
					nsmp.setDthrCadastro(msevt.getDthrEvento());
					getDao().makePersistent(nsmp);
					
					feederJaConsumidos.add(omalimrea.getCbRap());
					
					
					/* aqui devemos atualizar o estoque de cada reelid (rolo) a fim de sabermos quantos
					 * comoponentes existem no reelid caso o mesmo saia e depois retorne para uso
					 */
					if (omalimrea.getCb() != null) {
						OmReel omreel = rn.pesquisarEstoqueReelIdOuIncluir(log, idLog, omalimrea);
						
						if (omreel != null) {
							BigDecimal qtUsadaReel = omreel.getQtUsada();
							if (qtUsadaReel ==  null)
								qtUsadaReel = BigDecimal.ZERO;
							
							qtUsadaReel = qtUsadaReel.add(qtdeConsumidaPorNS);
							if (isMostrarLog)
								log.info(idLog, identacao, "idAlimrea: " + omalimrea.getIdAlimrea() + " - alterando qtUsada em omreel de " + omreel.getQtUsada() + " para " + qtUsadaReel + " para o idReel=" + omreel.getIdReel() + " - " + omreel.getCdReelid());
							omreel.setQtUsada(qtUsadaReel);
							
							getDao().makePersistent(omreel);
						}
					} else if (isMostrarLog) {
						log.info(idLog, identacao, "cbreelid vazio para idalimrea = " + omalimrea.getIdAlimrea());
					}
				}
			}
		}
	}
	
	private List<OmAlimrea> obtemAlimreaASerConsumido(OmPt ompt, DwNserie ns) {
		List<OmAlimrea> retorno = new ArrayList<>();
		
		MapQuery qAlim = new MapQuery(getDaoSession());
		
		// Obtem a ultima alimentacao
		qAlim.append("select a");
		qAlim.append("from OmAlim a");
		qAlim.append("join a.omMapa b");
		qAlim.append("join b.omPt c");
		qAlim.append("where c = :ompt");
		qAlim.append("and a.tpAlim = 3"); // alimnetacao
		qAlim.append("and a.stAlim = 1"); // sucesso
		qAlim.append("order by a.idAlim desc");
		
		qAlim.setMaxResults(1);
		
		
		// Obtem as leituras da ultima alimentacao que tenham saldo para consumo
		// Nao se pode pegar as realimentacoes, apenas o q tem saldo
		// e desconsiderar as leituras com erro
		MapQuery qAlimrea1 = new MapQuery(getDaoSession());
		qAlimrea1.append("select a");
		qAlimrea1.append("from OmAlimrea a");
		qAlimrea1.append("where a.omAlim = :omalim");
		qAlimrea1.append("and a.stLeitura <> 2"); // lelitura com erro
		qAlimrea1.append("and a.qtAtual is not null and a.qtAtual > 0"); // qtAtual sera null na 1a vez que processar uma passagem

		
		MapQuery qAlimrea2 = new MapQuery(getDaoSession());
		qAlimrea2.append("select a2");
		qAlimrea2.append("from OmAlimrea a2");
		qAlimrea2.append("where a2.omAlim = :omalim");
		qAlimrea2.append("and a2.stLeitura <> 2"); // lelitura com erro
		qAlimrea2.append("and a2.qtAtual is null and a2.omMapapa.omPa.idPa not in (");
		qAlimrea2.append("select a3.omMapapa.omPa.idPa from OmAlimrea a3 where a3.omAlim = :omalim and a3.stLeitura <> 2 and ");
		qAlimrea2.append("a3.qtAtual is not null and a3.qtAtual > 0 )");

		
		List<OmPt> listapts = new ArrayList<>();
		listapts.add(ompt);
		for (OmPtcnc cnc : ompt.getOmPtcncsForIdPt()) {
			listapts.add(cnc.getOmPtByIdPtFilho());
		}
		
		for (OmPt omptAux : listapts) {
			qAlim.defineParametro("ompt", omptAux);
			OmAlim omalim = (OmAlim) qAlim.uniqueResult();
			if (omalim == null)
				continue;
			
		

			qAlimrea1.defineParametro("omalim", omalim);
			List<OmAlimrea> lista = qAlimrea1.list();
			
			/*
			 * A lista contem as alimentacoes e realimentações que faltam ser consumidas
			 * Se houver uma alimentacao que ainda nao foi totalmente consumida e existe uma realimentacao tambem, desconsiderar o omalimrea da realimentacao
			 */
			qAlimrea2.defineParametro("omalim", omalim);
			List<OmAlimrea> lista2 = qAlimrea2.list();
			
			
			retorno.addAll(lista);
			retorno.addAll(lista2);
		}
		
		return retorno;
	}
	
	
	
	public OmProrange pesquisarOmProrange(OmProduto omproduto, String cb) {
		OmProrange retorno = null;
		
		if (omproduto == null || cb == null)
			return retorno;
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from OmProrange a");
		q.append("where a.omProduto = :omproduto");
		q.append("and a.stAtivo = 1");
		
		// Alessandre em 16-06-19 errado temos q considerar faixa numerica
		//q.append("and :cb between a.nsInicial and a.nsFinal"); 
		
		
		q.defineParametro("omproduto", omproduto);
		//q.defineParametro("cb", cb);
		//q.setMaxResults(1);
		List<OmProrange> lista = q.list();
		for (OmProrange prorange : lista) {
			// Converte faixa para decimal
			BigInteger nsInicial;
			BigInteger nsFinal;
			BigInteger nsAvaliado;
			if (prorange.getTpRegra().equals(OmProrangeTemplate._TPREGRA.TP_REGRA_DECIMAL.getValue())) {
				nsInicial = ConversaoTipos.converteParaBigInteger(prorange.getNsInicial());
				nsFinal = ConversaoTipos.converteParaBigInteger(prorange.getNsFinal());
				try {
					nsAvaliado = ConversaoTipos.converteParaBigInteger(cb);
				} catch (NumberFormatException e) {
					retorno = null;
					break;
				}
			} else {
				nsInicial = ConversaoTipos.converteHexParaDecimal(prorange.getNsInicial());
				nsFinal = ConversaoTipos.converteHexParaDecimal(prorange.getNsFinal());
				try {
					nsAvaliado = ConversaoTipos.converteHexParaDecimal(cb);
				} catch (NumberFormatException e) {
					retorno = null;
					break;
				}
			}
			if (nsAvaliado.compareTo(nsInicial) >= 0 && nsAvaliado.compareTo(nsFinal) <= 0) {
				retorno = prorange;
				break;
			}
		}
		return retorno;
	}
	
	private List<MsEvtmontagem> getMontagens(MsEvt msevt) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a from MsEvtmontagem a where a.msEvt = :msevt");
		q.defineParametro("msevt", msevt);
		return q.list();
	}

	private void tratarMontagem(OmPt omPt, MsEvt msevt, OmCfg omcfg, final DwFolha dwFolha, DwNserie dwnseriedb, OmUsr omusr, DwPassagem dwpassagem, IdwLogger log, int idLog) {
		
		/* Alessandre em 10-07-19 ler novamente as montagens, pois em alguns casos a lista está incompleta
		 * 
		 */
		List<MsEvtmontagem> lista = getMontagens(msevt);
		
		
		if (lista.isEmpty() == false) {
			ProdutoRN prn = new ProdutoRN(getDao());
			log.info(idLog, 0, "Qtde itens montados: " + lista.size());
			
			for (MsEvtmontagem montagem : lista) {

				String cdProduto = montagem.getCdProduto();

				if (cdProduto == null || cdProduto.equals(""))
					cdProduto = Util.extraiPorMascara(montagem.getCb(), omcfg.getMascaracdprodutomp());

				OmProduto omproduto = null;
				if (cdProduto != null && cdProduto.equals("") == false) {
					try {
						omproduto = prn.getOmProduto(cdProduto);
					} catch (RegistroDesconhecidoException e) {
						omproduto = null;
					}
				}
				
				/* Pegar da folha qual o produto a ser montado
				 *
				 */
				if (omproduto == null) {
					for (DwFolhamon mon : dwFolha.getDwFolhamons()) {
						for (DwFolhamoncomp moncomp : mon.getDwFolhamoncomps() ) {
							omproduto = moncomp.getOmProduto();
						}
					}
				}

				// se mesmo assim nao tiver o produto inserir para nao perder a montagem e vermos o q acontece
				if (omproduto == null) {
					omproduto = new OmProduto();
					omproduto.setId(null);
					omproduto.setCdProduto(cdProduto);
					omproduto.setDsProduto("cadastro automatico montagem posto " + omPt.getCdPt());
					omproduto.setDtRevisao(DataHoraRN.getDataHoraAtual());
					omproduto.setDtStativo(DataHoraRN.getDataHoraAtual());
					omproduto.setTpProduto(OmProdutoTemplate.TpProduto.COMPONENTE.getId());
					omproduto.setStAtivo((byte) 1);
					omproduto.setOmUsrByIdUsrrevisao(omusr);
					omproduto.setOmUsrByIdUsrstativo(omusr);
					getDao().makePersistent(omproduto);
				}
				DwPassmon passmon = new DwPassmon();
				passmon.setCb(montagem.getCb());
				passmon.setDsMon(montagem.getDsmontagem());
				passmon.setDwPassagem(dwpassagem);
				passmon.setIdPassmon(0l);
				passmon.setIsAlternativo(false);
				passmon.setOmProduto(omproduto);
				passmon.setOrdem(montagem.getOrdem());

				getDao().makePersistent(passmon);
				
				log.info(idLog, 0, "incluida dwpassmon com id " + passmon.getIdPassmon() + " para idPassagem=" + dwpassagem.getIdPassagem() + " cb=" + passmon.getCb());

				// A passagem no nserie serve para guardar a montagem do produto
				dwnseriedb.setDwPassagem(dwpassagem);
			}
		} else {
			log.info(idLog, 0, "Sem registro de montagem para a passagem id=" + dwpassagem.getIdPassagem());
		}
	}
	
	/* Metodo para verificar se a materia-prima está limitada a um range especifico
	 * 
	 */
	public DwMacrange isMateriaPrimaLimitada(String cb, OmPt ompt) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwMacrange a");
		q.append("where a.omGt = :omgt");
		q.append("and a.dwMacrangepai is not null");
		q.append("and a.tpRegra != :tpregra");
		q.append("and a.stMacrange = :stmacrange");
		
		q.defineParametro("omgt", ompt.getOmGt()); // ompt.getOmGt().getIdGt()
		q.defineParametro("tpregra", DwMacrangeTemplate.TpRegra.LIMITEGLOBAL.getId());
		q.defineParametro("stmacrange", DwMacrangeTemplate.StMacrange.COM_MAC_DISPONIVEL.getId());
		
		List<DwMacrange> lista = q.list();
		DwMacrange retorno = null;
		
		for (DwMacrange macrange : lista) {
			// Transforma mac para numero
			try {
				if (MacRN.isDentroDoRange(cb, macrange.getCdMacInicial(), macrange.getCdMacFinal())) {
					retorno = macrange;
				}
			} catch (NumberFormatException e) {
				// Essa excessao ocorrera caso a materia prima nao seja hexdecimal
			}
		}
		return retorno;
	}

	private void tratarDefeito(OmPt omPt, MsEvt msevt, OmCfg omcfg, DwConsolid dwconsolidTurno, DwConsolid dwconsolidHora, DwPassagem dwpassagem, AreaRN arn) {
		// Verifica se existem defeitos a serem inputados
		VerificaDefeitoRN drn = new VerificaDefeitoRN();
		drn.setDao(getDao());

		for (MsEvtdefeito defeito : msevt.getMsEvtdefeitos()) {
			tratarDefeito(omPt, msevt, defeito, omcfg, dwconsolidTurno, dwconsolidHora, dwpassagem, arn, drn, defeito.getCdDefeito(), defeito.getCdArea());

		}

		// Se o codigo do nozzle for infomado entao incluir um defeito tambem
		if (msevt.getCdDefeito() != null && msevt.getCdDefeito().equals("") == false) {
			tratarDefeito(omPt, msevt, null, omcfg, dwconsolidTurno, dwconsolidHora, dwpassagem, arn, drn, msevt.getCdDefeito(), msevt.getCdArea());
		}
		
		
		// Atualizar total de testes para o turno e hora
		DwConsol dwconsolTurno = dwconsolidTurno.getDwConsol();
		DwConsol dwconsolHora = dwconsolidHora.getDwConsol();
		
		if (dwconsolTurno.getQtAutoTestes() == null)
			dwconsolTurno.setQtAutoTestes(BigDecimal.ZERO);
		if (dwconsolHora.getQtAutoTestes() == null)
			dwconsolHora.setQtAutoTestes(BigDecimal.ZERO);
		
		dwconsolTurno.setQtAutoTestes(dwconsolTurno.getQtAutoTestes().add(BigDecimal.ONE));
		dwconsolHora.setQtAutoTestes(dwconsolHora.getQtAutoTestes().add(BigDecimal.ONE));
	}


	private void tratarDefeito(OmPt omPt, MsEvt msevt, MsEvtdefeito msevtdefeito, OmCfg omcfg, DwConsolid dwconsolidTurno, 
							   DwConsolid dwconsolidHora, DwPassagem dwpassagem, AreaRN arn, VerificaDefeitoRN drn, 
							   String cdDefeito, String cdArea) {
//CECILIA
		DwTDefeito dwtdefeito = drn.getTDefeito(omPt.getOmTppt(), cdDefeito);
		
		if (dwtdefeito == null) {
			dwtdefeito = createDwTDefeito(cdDefeito, omPt, omcfg);
			getDao().makePersistent(dwtdefeito);
		}

		DwTArea dwtarea = null;
		
		if (cdArea != null && cdArea.equals("") == false) {
			try {
				dwtarea = arn.getDwTArea(cdArea, true);
			} catch (RegistroDesconhecidoException e) {
				dwtarea = null;
			}
		}
		
		OrigemRN origemRN = new OrigemRN(getDao());
		
		DwTOrigem dwtorigem = null;
		
		if (msevt.getCdOrigem() != null && msevt.getCdOrigem().equals("") == false) {
			try {
				dwtorigem = origemRN.getDwTOrigem(msevt.getCdOrigem(), omPt.getOmTppt(), true);
			} catch (RegistroDesconhecidoException e) {
				dwtarea = null;
			}
		}
		
		DwPassdef def = null;
		
		if (dwtorigem != null) {
			def = createDwPassdef(msevt, msevtdefeito, dwpassagem, dwtdefeito, dwtarea, dwtorigem);
		} else {
			def = createDwPassdef(msevt, msevtdefeito, dwpassagem, dwtdefeito, dwtarea);	
		}
		
		getDao().makePersistent(def);
		
		incluirDefeitoNaConsolidacao(dwconsolidTurno, dwtdefeito, dwtarea);
		incluirDefeitoNaConsolidacao(dwconsolidHora, dwtdefeito, dwtarea);
	
	}

	private DwPassdef createDwPassdef(MsEvt msevt, MsEvtdefeito msevtdefeito, DwPassagem dwpassagem, DwTDefeito dwtdefeito, DwTArea dwtarea) {
		DwPassdef def = new DwPassdef();
		def.setDwPassagem(dwpassagem);
		def.setDwTDefeito(dwtdefeito);
		def.setDwTArea(dwtarea);
		def.setIdPassdef(0l);
		if (msevtdefeito != null) {
			def.setDsPosicaomecanica(msevtdefeito.getCdPosicao());
			def.setCdComponente(msevtdefeito.getCb());
		} else {
			def.setDsPosicaomecanica(msevt.getOrigem());
		}
		
		return def;
	}

	private DwPassdef createDwPassdef(MsEvt msevt, MsEvtdefeito msevtdefeito, DwPassagem dwpassagem, DwTDefeito dwtdefeito, DwTArea dwtarea, DwTOrigem dwtorigem) {
		
		DwPassdef def = new DwPassdef();
		
		def.setDwPassagem(dwpassagem);
		def.setDwTDefeito(dwtdefeito);
		def.setDwTArea(dwtarea);
		def.setDwTOrigem(dwtorigem);
		def.setIdPassdef(0l);
		
		if (msevtdefeito != null) {
			def.setDsPosicaomecanica(msevtdefeito.getCdPosicao());
			def.setCdComponente(msevtdefeito.getCb());
		} else {
			def.setDsPosicaomecanica(msevt.getOrigem());
		}
		
		return def;
	
	}

	private DwTDefeito createDwTDefeito(String cdDefeito, OmPt omPt, OmCfg omcfg) {
		DwTDefeito dwtdefeito;
		dwtdefeito = new DwTDefeito();
		dwtdefeito.setCdTdefeito(cdDefeito);
		dwtdefeito.setDsTdefeito("Cadastrado automaticamente pela consolida��o");
		dwtdefeito.setDtRevisao(DataHoraRN.getDataHoraAtual());
		dwtdefeito.setDtStativo(dwtdefeito.getDtRevisao());
		dwtdefeito.setIsRequeracao(false);
		dwtdefeito.setOmTppt(omPt.getOmTppt());
		dwtdefeito.setRevisao(1l);
		dwtdefeito.setStAtivo((byte) 1);
		dwtdefeito.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
		dwtdefeito.setOmUsrByIdUsrstativo(dwtdefeito.getOmUsrByIdUsrrevisao());
		return dwtdefeito;
	}


	// Consolida os defeitos para o dwconsolid
	private void incluirDefeitoNaConsolidacao(DwConsolid dwconsolid, DwTDefeito dwtdefeito, DwTArea dwtarea) {
		// Procura se existe um dwConsoldef para o motivo escolhido
		DwConsoldef dwconsoldef = null;
		DwConsol dwconsol = null;
		for (DwConsol consol : dwconsolid.getDwConsols()) {
			dwconsol = consol;
			for (DwConsoldef consoldef : consol.getDwConsoldefs()) {
				if (consoldef.getDwTDefeito().getCdTdefeito().equals(dwtdefeito.getCdTdefeito())) {
					if (
							(consoldef.getDwTArea() == null && dwtarea == null) ||
							(consoldef.getDwTArea() != null && dwtarea != null && consoldef.getDwTArea().getCdArea().equals(dwtarea.getCdArea()))
							)
					dwconsoldef = consoldef;
					break;
				}
			}
		}

		// Se nao encontrou criar um novo
		if (dwconsoldef == null) {
			dwconsoldef = new DwConsoldef();
			dwconsoldef.setDwConsol(dwconsol);
			dwconsoldef.setDwTArea(dwtarea);
			dwconsoldef.setDwTDefeito(dwtdefeito);
			dwconsoldef.setIdConsoldef(null);
			dwconsoldef.setQtDefeitos(BigDecimal.ONE);
		} else {
			dwconsoldef.setQtDefeitos(dwconsoldef.getQtDefeitos().add(BigDecimal.ONE));
		}
		if (dwconsol.getQtAutoDefeitos() == null)
			dwconsol.setQtAutoDefeitos(BigDecimal.ZERO);
		
		dwconsol.setQtAutoDefeitos(dwconsol.getQtAutoDefeitos().add(BigDecimal.ONE));

		getDao().makePersistent(dwconsol);
		getDao().makePersistent(dwconsoldef);
	}



	/* Metodo responsavel em verificar se o passo deve limpar quais teste 
	 * 
	 */
	private void tratarBoot(OmPt omPt, MsEvt msevt, OmCfg omcfg, DwFolha dwFolha, DwNserie dwnseriedb, OmUsr omusr, DwPassagem dwpassagem, OmProduto omproduto, IdwLogger log, int idLog) {
		// Encontra o roteiro
		DwRota oDwRota = null;
		VerificaPassagemRN rn = new VerificaPassagemRN();
		rn.setDao(getDao());
		
		oDwRota = rn.getRotaProduto(
				omPt.getOmGt().getIdGt(), 
				omproduto.getIdProduto());
		
		// Verifica qual o passo do roteiro
		List<DwFolha> folhas = new ArrayList<>();
		if (oDwRota != null) {
			for (DwRotapasso dwrotapasso : oDwRota.getDwRotapassos()) {
				if (dwrotapasso.getDwRotapassoByIdRotapassosucessoNc() != null && dwrotapasso.getDwRotapassoByIdRotapassosucessoNc().getDwFolha().equals(dwFolha)) {
					folhas.add(dwrotapasso.getDwFolha());
				}
			}
		}
		
		// Encontra os testes do roteiro encontrado 
		// Marcar esses testes como desativados
		MapQuery q = new MapQuery(getDaoSession());
		q.append("update DwPassagem set stAtivo = 0, dsDiariobordo=:ds where dwNserie=:dwnserie and omPt in ( select a from OmPt a where a.stAtivo = 1 and a.omTppt = :omtppt)");
		for (DwFolha dwfolha : folhas) {
			q.defineParametro("ds", "cancelado via boot em " + DataHoraRN.getDataHoraAtualFormatada());
			q.defineParametro("dwnserie", dwnseriedb);
			q.defineParametro("omtppt", dwfolha.getOmTppt());
			
			int qt = q.query().executeUpdate();
			log.info(idLog, 0, "qtde testes cancelandos pelo boot "+qt + " para CB " + dwnseriedb.getCb() + " para tipo posto " + dwfolha.getOmTppt().getCdTppt() + " da folha " + dwfolha.getCdFolha());
		}
			
			
	}

}
