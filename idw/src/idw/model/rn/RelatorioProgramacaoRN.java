package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpa;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpIndispRappt;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioProgramacaoDTO;
import idw.webservices.dto.RelatorioProgramacaoDTO;
import idw.webservices.dto.TurnoAtualDTO;

public class RelatorioProgramacaoRN extends AbstractRN<DAOGenerico> {

	public RelatorioProgramacaoRN() {
		this(null);
	}
	
	public RelatorioProgramacaoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public RelatorioProgramacaoDTO getRelatorioProgramacao(FiltroRelatorioProgramacaoDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelatorioProgramacaoRN.getRelatorioProgramacao");
		log.info( idLog , 0, "RelatorioProgramacaoRN.getRelatorioProgramacao filtro usado:" + filtro.toString());
		
		RelatorioProgramacaoDTO retorno = null;
		RelatorioProgramacaoDTO disp = null;
		RelatorioProgramacaoDTO prod = null;
		if(filtro.isOpsDisponiveis()){
			List<Object> lista = getListaOpDisponivel(filtro);
			disp = montarRelatorioOpDisponivel(lista, filtro);
		}
		if (filtro.isOpsEmMaquinas()) {
			prod = montarRelatorio(getConsulta(filtro), filtro.isPeca(), filtro.isKilograma());
		}
		
		if (disp != null)
			retorno = disp;
		
		if (disp == null && prod != null)
			retorno = prod;
		else if (prod != null)
			retorno.getItens().addAll(prod.getItens());
		if(retorno == null)
			retorno = new RelatorioProgramacaoDTO();
		
		
		Comparator<RelatorioProgramacaoDTO> comparator = new Comparator<RelatorioProgramacaoDTO>() {			
			@Override
			public int compare(RelatorioProgramacaoDTO o1, RelatorioProgramacaoDTO o2) {
				String str1 = o1.getMaquina() + o1.getInicioPlanejado() + o1.getOp();
				String str2 = o2.getMaquina() + o2.getInicioPlanejado() + o2.getOp();
				return str1.compareTo(str2);
			}
		};
		Collections.sort(retorno.getItens(), comparator);		
		log.mostrarAvaliacaoCompleta();
		return retorno;
	}
	
	private List<Object> getListaOpDisponivel(FiltroRelatorioProgramacaoDTO filtro){
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("SELECT DISTINCT "); // Alessandre em 13-06-22 acrescentei um DISTINCT
		q.append("cp.idCp, ");
		q.append("pt.cdPt,");//maquina
		q.append("pt.dsCurta,");//maquina
		q.append("prod.cdProduto,");//produtoCd
		q.append("prod.dsProduto,");//produtoDs
		q.append("rap.cdRap,");//molde
		q.append("ppcpproduto.nrDoc, ");//op
		q.append("cliente.nmCliente,");//cliente
		q.append("cp.dthrInicio,");//inicioPlanejado
		q.append("cp.dthrFinal,");//fimPlanejado
		q.append("cp.dthrInicioreal,");//inicioReal
		q.append("cp.dthrFinalreal,");//fimPrevisto
		//gargalo
		q.append("folha.segSetup,");//setupProg
		q.append("pt.indOee,");//eficienciaProg
		//paradasProg
		//qtdsPlanejada
		//qtdsBoas
		//saldo
		//isOpCarteira
		//isPlanoCritico
		q.append("pt.idPt, ");// pt para verificar turno
		q.append("ppcpproduto.pcsProducaoplanejada");
		
		q.append("FROM DwConsolid consolid");		
		q.append("JOIN consolid.ppCp cp"); // Alessandre em 13-06-22 tirei o RIGHT desse join pois quero as OPs que tiverem dwconslid apenas
		q.append("JOIN cp.omPt pt");
		q.append("JOIN cp.dwFolha folha");
		q.append("left join folha.dwFolharaps folharap");
		q.append("left join folharap.dwRap rap");
		q.append("LEFT JOIN pt.omObjs obj");
		q.append("LEFT JOIN obj.omGtByIdGt gt");
		q.append("LEFT JOIN cp.ppCpprodutos ppcpproduto");
		q.append("LEFT JOIN ppcpproduto.omProduto prod");	
		q.append("LEFT JOIN cp.ppCliente cliente");
		// Alessandre em 13-06-22 analisando o chamado 7948 comentei a linha abaixo pois sempre ppCp deve ter um valor. Estranho esse teste ai
//		q.append("WHERE consolid.ppCp IS NULL");
		q.append("WHERE cp.dthrInicio BETWEEN :dtInicio AND :dtFim");
//		q.append("AND cp.stAtivo = :stAtivo"); Alessandre em 13-06-22 nao da pra excluir as OPs que foram alteradoas e tiveram o stativo 0
		
		// Alessandre em 13-06-22 faltou filtrar apenas os tpId = TURNO
		q.append("and consolid.tpId = 1");
		
		if(filtro.getOmPt() != null) {
			q.append("AND pt.idPt = :idPt");
		} else {
			q.append("AND gt.idGt = :idGt");
		}		
		
		q.defineParametro("stAtivo", (byte) 1);
		q.defineParametro("dtInicio", filtro.getDtInicio());
		q.defineParametro("dtFim", DataHoraRN.getDataHora235959(filtro.getDtFim()));
		
		if(filtro.getOmPt() != null) {
			q.defineParametro("idPt", filtro.getOmPt().getIdPt());
		} else {
			q.defineParametro("idGt", filtro.getOmGt().getIdGt());
		}
		
		return q.list();
	}
	
	private List<DwConsolid> getConsulta(FiltroRelatorioProgramacaoDTO filtro) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.dwTurno turno");
		q.append("JOIN consolid.ppCp cp");
		q.append("JOIN cp.ppCpprodutos cpproduto");
		q.append("JOIN consol.dwConsolprs consolpr");
		q.append("JOIN consolpr.omProduto produto");
		q.append("LEFT JOIN pt.omObjs obj");
		q.append("LEFT JOIN obj.omGtByIdGt gt");
		q.append("WHERE consolid.tpId = :tpId");
		q.append("AND consolid.dtReferencia BETWEEN :dtInicio AND :dtFim");
		if(filtro.getDwTurno() != null) {
			q.append("AND turno.idTurno = :idTurno");
		}else{
			q.append("AND consolid.dwTurno.idTurno != 1");
		}
		if(filtro.getOmPt() != null) {
			q.append("AND pt.idPt = :idPt");
		} else {
			q.append("AND gt.idGt = :idGt");
		}
		if(filtro.isOpsEmMaquinas()) {
			q.append("AND cp.cdCp = pt.ppCp.cdCp");
		}
		
		q.defineParametro("tpId", (byte) 1);
		q.defineParametroData("dtInicio", filtro.getDtInicio());
		q.defineParametroData("dtFim", DataHoraRN.getDataHora235959(filtro.getDtFim()));
		if(filtro.getDwTurno() != null) {
			q.defineParametro("idTurno", filtro.getDwTurno().getIdTurno());
		}
		if(filtro.getOmPt() != null) {
			q.defineParametro("idPt", filtro.getOmPt().getIdPt());
		} else {
			q.defineParametro("idGt", filtro.getOmGt().getIdGt());
		}
		return q.list();
	}	
	
	private RelatorioProgramacaoDTO montarRelatorioOpDisponivel(List<Object> lista, FiltroRelatorioProgramacaoDTO filtro) {
		
		int _idCp = 0;
		int _maquina = 1;
		int _dsmaquina = 2;
		int _cdProduto = 3;
		int _dsProduto = 4;
		int _molde = 5;
		int _op = 6;
		int _cliente = 7;
		int _inicioPlanejado = 8;
		int _fimPlanejado = 9;
		int _inicioReal = 10;
		int _fimPrevisto = 11;
		int _setupProg = 12;
		int _eficienciaProg = 13;
		int _pt = 14;
		int _producaoPlanejada = 15;
		
		RelatorioProgramacaoDTO retorno = new RelatorioProgramacaoDTO();
		retorno.setItens(new ArrayList<RelatorioProgramacaoDTO>());
		
		HashMap<String, RelatorioProgramacaoDTO> itens = new HashMap<>();		
		
		for(Object o : lista) {
			
			RelatorioProgramacaoDTO item;
			String chave = "";
			Object[] reg = (Object[]) o;
			chave += reg[_idCp];
			
			if(!itens.containsKey(chave)){
				
				Date dataInicioPlanejado = (Date)reg[_inicioPlanejado];
				Date dataFimPlanejado = (Date)reg[_fimPlanejado];
				long ptId = (long)reg[_pt];
				
				if(filtro.getDwTurno() != null) {
					long turnoId = filtro.getDwTurno().getIdTurno();
					long turnoAtualId = getTurno(ptId, dataInicioPlanejado);
					if(turnoId != turnoAtualId){
						continue;
					}
				}
				
				long idPt = (long) reg[_pt];
				List<PpIndispRappt> listaRappt = getEficienciaProgramadaOpDisponivel(idPt, dataInicioPlanejado, dataFimPlanejado);
				long tempoParadaProgramada = 0l;
				for(PpIndispRappt rappt : listaRappt){
					if(rappt.getDthrInicio() == null || rappt.getDthrFinal() == null){
						continue;
					}
					
					//System.out.println("     rappt:"+rappt.getIdIndispRappt());
					
					long dataInicial = 0l;
					//System.out.println("          inicioPlanejado:"+retornaData(dataInicioPlanejado));
					if(rappt.getDthrInicio().getTime() < dataInicioPlanejado.getTime()){
						dataInicial = dataInicioPlanejado.getTime();
						//System.out.println("               inicio1:"+retornaData(new Date(dataInicial)));
					} else {
						dataInicial = rappt.getDthrInicio().getTime();
						//System.out.println("               inicio2:"+retornaData(new Date(dataInicial)));
					}
					
					long dataFinal = 0l;
					//System.out.println("          fimPlanejado:"+retornaData(dataFimPlanejado));
					if(rappt.getDthrFinal().getTime() > dataFimPlanejado.getTime()){
						dataFinal = dataFimPlanejado.getTime();
						//System.out.println("               fim1:"+retornaData(new Date(dataFinal)));
					} else {
						dataFinal = rappt.getDthrFinal().getTime();
						//System.out.println("               fim2:"+retornaData(new Date(dataFinal)));
					}
					
					
					if(dataInicial > dataFinal){
						continue;
					}
					
					tempoParadaProgramada += dataFinal - dataInicial;
				}
				
				item = new RelatorioProgramacaoDTO();
				item.setMaquina(retornaString((String)reg[_maquina] + "\n" + (String)reg[_dsmaquina]));				
				item.setMolde(retornaString((String)reg[_molde]));
				if (item.getMolde() == null)
					item.setMolde("---");
				item.setOp(retornaString((String)reg[_op]));
				String produto = retornaString((String)reg[_cdProduto]) + "/" + retornaString((String)reg[_dsProduto]);
				item.setProduto(produto);
				item.setCliente(retornaString((String)reg[_cliente]));
				item.setInicioPlanejado(retornaData(dataInicioPlanejado));
				item.setFimPlanejado(retornaData((Date)reg[_fimPlanejado]));
				
				item.setInicioReal("--------");
				item.setFimPrevisto("--------");
				item.setGargalo("--------");
				
				item.setSetupProg(retornaInt(reg[_setupProg]));
				item.setEficienciaProg(retornaInt(reg[_eficienciaProg]));
				item.setParadasProg(retornaMillisFormatado(tempoParadaProgramada));
				item.setQtdsPlanejada( ((BigDecimal) (reg[_producaoPlanejada])).doubleValue());
				item.setQtdsBoas(0);
				item.setSaldo(((BigDecimal) (reg[_producaoPlanejada])).doubleValue());
				item.setOpCarteira(false);
				item.setPlanoCritico(false);
				itens.put(chave, item);
			} else {
				
			}
		}
		
		for(String i : itens.keySet()) {
			RelatorioProgramacaoDTO item = itens.get(i);
			retorno.getItens().add(item);
		}
		
		Comparator<RelatorioProgramacaoDTO> comparator = new Comparator<RelatorioProgramacaoDTO>() {			
			@Override
			public int compare(RelatorioProgramacaoDTO o1, RelatorioProgramacaoDTO o2) {
				String str1 = o1.getInicioReal() + o1.getMaquina() + o1.getOp();
				String str2 = o2.getInicioReal() + o2.getMaquina() + o2.getOp();
				return str1.compareTo(str2);
			}
		};
		Collections.sort(retorno.getItens(), comparator);
		
		return retorno;
	}
	
	private RelatorioProgramacaoDTO montarRelatorio(List<DwConsolid> listaConsolids, boolean isPeca, boolean isKilograma) {
		RelatorioProgramacaoDTO retorno = new RelatorioProgramacaoDTO();
		retorno.setItens(new ArrayList<RelatorioProgramacaoDTO>());
		
		HashMap<String, RelatorioProgramacaoDTO> mapItens = new HashMap<>();
		FolhaRN folharn = new FolhaRN(getDao());
		for(DwConsolid consolid : listaConsolids) {
			int pecasPorCiclo = folharn.getPcsPorCicloAtivasFromDwFolha(consolid.getDwFolha()).intValue();

			for(DwConsol consol : consolid.getDwConsols()) {
				
				// na classe IndicadoresDoDetalheRN linha 1110 se for null segCicPadrao assume 10 (fiz igual) ou deve ser 0?
				int segCicPadrao = consolid.getDwFolha().getSegCiclopadrao() != null ? consolid.getDwFolha().getSegCiclopadrao().intValue() : 10;
				
				int producaoBruta = consol.getPcsProducaoBruta().intValue();
				int producaoRefugada = consol.getPcsProducaoRefugada().intValue();
				
				double qtdsBoas = producaoBruta - producaoRefugada;
				double qtdsPlanejada = new Double(consolid.getPpCp().getQtPecasProduzir()).intValue();
				
				
				String inicioPlanejado = null;
				String inicioReal = null;
				String fimPlanejado = null;
				String fimPrevisto = null;
				Date fimPrevistoDate = null;
				int setupProg = 0;
				int eficienciaProg = 0;
				double saldo = qtdsPlanejada - qtdsBoas;
				
				if(consolid.getPpCp().getDthrInicio() != null) {
					inicioPlanejado = DataHoraRN.dateToStringDDMMYYYYHHMMSS(consolid.getPpCp().getDthrInicio());
				}
				if(consolid.getPpCp().getDthrFinal() != null) {
					fimPlanejado = DataHoraRN.dateToStringDDMMYYYYHHMMSS(consolid.getPpCp().getDthrFinal());
				}
				if(consolid.getPpCp().getDthrInicioreal() != null) {
					inicioReal = DataHoraRN.dateToStringDDMMYYYYHHMMSS(consolid.getPpCp().getDthrInicioreal());
				}
				if(consolid.getDwFolha() != null && consolid.getDwFolha().getSegSetup() != null) {
					setupProg = consolid.getDwFolha().getSegSetup();
				}
				if(consolid.getOmPt().getIndOee() != null) {
					eficienciaProg = consolid.getOmPt().getIndOee().intValue();
				}
				Double segProducaoParaProduzirSaldo = 0d;
				
				String gargalo = null;
				if (consolid.getPpCp().getDthrFinalreal() != null) {
					continue;
				}
				if(saldo > 0) {
					if(pecasPorCiclo > 0) {
						Double aux = Math.ceil((double) saldo / (double) pecasPorCiclo);
						segProducaoParaProduzirSaldo = aux * segCicPadrao;
						Date dataFinalPrevista = DataHoraRN.adicionaSegundosNaData(DataHoraRN.getDataHoraAtual(), segProducaoParaProduzirSaldo.intValue());
						fimPrevisto = DataHoraRN.dateToStringDDMMYYYYHHMMSS(dataFinalPrevista);
						fimPrevistoDate = dataFinalPrevista;
						
						int segGargalo = DataHoraRN.getQuantidadeSegundosNoPeriodo(consolid.getPpCp().getDthrFinal(), dataFinalPrevista);
						gargalo = DataHoraRN.formatSegundosParaHHMMSS(segGargalo);
					}
				}				
				
				int segTempoParadasProg = 0;
				for(DwConsolpa consolpa : consol.getDwConsolpas()) {
					if(consolpa.getDwTParada().getIsPrev() != null && consolpa.getDwTParada().getIsPrev()){
						int tempoCP = consolpa.getSegAutoTempoparadaCp() != null ? consolpa.getSegAutoTempoparadaCp().intValue() : 0;
						tempoCP += consolpa.getSegManuTempoparadaCp() != null ? consolpa.getSegManuTempoparadaCp().intValue() : 0;
						
						int tempoSP = consolpa.getSegAutoTempoparadaSp() != null ? consolpa.getSegAutoTempoparadaSp().intValue() : 0;
						tempoSP += consolpa.getSegManuTempoparadaSp() != null ? consolpa.getSegManuTempoparadaSp().intValue() : 0;
						
						segTempoParadasProg = segTempoParadasProg + (tempoCP + tempoSP);
					}
				}
				String paradasProg = DataHoraRN.formatSegundosParaHHMMSS(segTempoParadasProg);

				for(DwConsolpr consolpr : consol.getDwConsolprs()) {
					
					BigDecimal qtdAtiva = BigDecimal.ONE;
					try {
						FolhaRN folhaRN = new FolhaRN(getDao());
						qtdAtiva = folhaRN.getPcsPorCicloAtivas(consolid.getDwFolha(), consolpr.getOmProduto());
					} catch (Exception e) {
					}
					if (qtdAtiva == null) {
						qtdAtiva = BigDecimal.ONE;
					}
					
					double pesoProduto = consolpr.getOmProduto().getGPesoBruto() != null ? consolpr.getOmProduto().getGPesoBruto().doubleValue() : 0;
					if(isPeca){
						
					} else if(isKilograma) {
						qtdsPlanejada = (qtdsPlanejada * pesoProduto) / 1000;
						qtdsBoas = (qtdsBoas * pesoProduto) / 1000;
						saldo = qtdsPlanejada - qtdsBoas;
					} else /*tonelada*/ {
						qtdsPlanejada = (qtdsPlanejada * pesoProduto) / 1000000;
						qtdsBoas = (qtdsBoas * pesoProduto) / 1000000;
						saldo = qtdsPlanejada - qtdsBoas;
					}
					
					String maquina = consolid.getOmPt().getCdPt();
					String op = null;
					for(PpCpproduto cpProduto : consolid.getPpCp().getPpCpprodutos()) {
						if(cpProduto.getNrDoc() == null) {
							continue;
						}
						op = cpProduto.getNrDoc();
					}
					DwFolharap dwfolharap = consolid.getDwFolha().obtemPrimeiroRap();
					String molde;
					if (dwfolharap != null) {
						molde = dwfolharap.getDwRap().getCdRap();
					} else {
						molde = "---";
					}
					String produto = consolpr.getOmProduto().getCdProduto() + "/" + consolpr.getOmProduto().getDsProduto();
					String cliente = null;					
					boolean isOpCarteira = consolid.getPpCp().getPpNec() != null;
					boolean isPlanoCritico = consolpr.getOmProduto().getTpProducao() != null && 
							consolpr.getOmProduto().getTpProducao().equals(OmProdutoTemplate.TpProducao.FINAL_LINHA); //FINAL DE SERIE (3)
					if(consolid.getPpCp().getPpCliente() != null) {
						cliente = consolid.getPpCp().getPpCliente().getCdCliente() + "/" + consolid.getPpCp().getPpCliente().getNmCliente();
					}
				
					String chave = maquina + op + molde + produto + cliente + inicioPlanejado;
							   //fimPlanejado + inicioReal + fimPrevisto + gargalo +
							   //setupProg + eficienciaProg + paradasProg + qtdsPlanejada;
					
					RelatorioProgramacaoDTO dto = mapItens.get(chave);
					
					if(dto == null) {
						dto = new RelatorioProgramacaoDTO();
						dto.setMaquina(consolid.getOmPt().getCdPt() + "\n" + consolid.getOmPt().getDsCurta());
						dto.setMolde(molde);
						dto.setOp(op); 
						dto.setProduto(produto);
						dto.setCliente(cliente);
						dto.setInicioPlanejado(inicioPlanejado);
						dto.setFimPlanejado(fimPlanejado);
						dto.setInicioReal(inicioReal);
						dto.setFimPrevisto(fimPrevisto);
						dto.setFimPrevistoDate(fimPrevistoDate);
						dto.setGargalo(gargalo);
						dto.setSetupProg(setupProg);
						dto.setEficienciaProg(eficienciaProg);
						dto.setParadasProg(paradasProg);
						dto.setQtdsPlanejada(qtdsPlanejada);
						dto.setQtdsBoas(qtdsBoas);
						dto.setSaldo(saldo);
						dto.setOpCarteira(isOpCarteira);
						dto.setPlanoCritico(isPlanoCritico);
						mapItens.put(chave, dto);
					} else {
						double novaQtdBoas = dto.getQtdsBoas() + qtdsBoas;
						double novoSaldo = dto.getQtdsPlanejada() - novaQtdBoas;
						dto.setQtdsBoas(novaQtdBoas);
						dto.setSaldo(novoSaldo);
						
						// Escolhe entre as maiores datas previstas de termino
						if (dto.getFimPrevistoDate() == null || (fimPrevistoDate != null && DataHoraRN.before(dto.getFimPrevistoDate(), fimPrevistoDate))) {
							dto.setFimPrevistoDate(fimPrevistoDate);
							dto.setFimPrevisto(fimPrevisto);
						}
					}
				}
			}
		}
		
		for(String chave : mapItens.keySet()) {
			RelatorioProgramacaoDTO item = mapItens.get(chave);
			retorno.getItens().add(item);
		}
		
		Comparator<RelatorioProgramacaoDTO> comparator = new Comparator<RelatorioProgramacaoDTO>() {			
			@Override
			public int compare(RelatorioProgramacaoDTO o1, RelatorioProgramacaoDTO o2) {
				String str1 = o1.getInicioReal() + o1.getMaquina() + o1.getOp();
				String str2 = o2.getInicioReal() + o2.getMaquina() + o2.getOp();
				return str1.compareTo(str2);
			}
		};
		Collections.sort(retorno.getItens(), comparator);
		
		return retorno;
	}
	
	private String retornaData(Date dthrFhora) {
		if(dthrFhora != null){
			return DataHoraRN.dateToStringDDMMYYYYHHMMSS(dthrFhora);
		}else{
			return"";
		}
	}
	
	private String retornaMillisFormatado(long millis) {
		return DataHoraRN.formatMilisegundosParaHHMMSS(millis);
	}
	
	private String retornaString(String item){
		if(item != null){
			return item;
		} else {
			return "";
		}
	}
	
	private int retornaInt(Object item){
		if(item != null){
			return (int)item;			
		}
		return 0;		
	}
	
	private long getTurno(long ptId, Date data){
		PTRN ptRn = new PTRN(getDao());
		OmPt omPt = ptRn.getOmPtById(ptId);
		TurnoRN turnoRn = new TurnoRN(getDao());		
		TurnoAtualDTO turno;
		try {
			turno = turnoRn.getTurnoAtualDTOSemClone(omPt, data);
			return turno.getIdTurno();
		} catch (SemCalendarioException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private List<PpIndispRappt> getEficienciaProgramadaOpDisponivel(long idPt, Date dtInicio, Date dtFim) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT DISTINCT a");
		q.append("FROM PpIndispRappt a");		
		q.append("JOIN a.ppIndisp b");
		q.append("WHERE b.stAtivo = :stAtivo");
		q.append("AND a.omPt.idPt = :idPt");
		q.append("AND (a.dthrInicio BETWEEN :dtInicio AND :dtFim");		
		q.append("OR a.dthrFinal BETWEEN :dtInicio AND :dtFim)");
		
		q.defineParametro("stAtivo", 1);
		q.defineParametro("idPt", idPt);
		q.defineParametroData("dtInicio", dtInicio);
		q.defineParametroData("dtFim", dtFim);
		return q.list();
	}
	
}