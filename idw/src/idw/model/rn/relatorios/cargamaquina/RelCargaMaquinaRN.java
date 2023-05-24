package idw.model.rn.relatorios.cargamaquina;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpr;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.TurnoRN;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;
import idw.util.IdwLogger;
import idw.webservices.dto.FiltroRelatorioCargaMaquinaDTO;
import idw.webservices.dto.RelatorioCargaMaquinaDTO;
import idw.webservices.dto.TurnoAtualDTO;

public class RelCargaMaquinaRN extends AbstractRN<DAOGenerico> {
	
	public RelCargaMaquinaRN() {
		super(new DAOGenerico());
	}
	
	public RelCargaMaquinaRN(DAOGenerico dao) {
		super(dao);
	}	
	
	public RelatorioCargaMaquinaDTO getRelatorioCargaMaquina(FiltroRelatorioCargaMaquinaDTO filtro) {
		
		IdwLogger log = new IdwLogger("ChamadasUsuarios");
		int idLog = log.getIdAleatorio();
		log.iniciaAvaliacao(idLog, "RelCargaMaquinaRN.getRelatorioCargaMaquina");
		log.info( idLog , 0, "RelCargaMaquinaRN.getRelatorioCargaMaquina filtro usado:" + filtro.toString());

		List<PpCp> cps = consulta(filtro);
		RelatorioCargaMaquinaDTO retorno = montarRelatorio(cps, filtro);
		log.mostrarAvaliacaoCompleta();
		return retorno;		
	}
	
	private RelatorioCargaMaquinaDTO montarRelatorio(List<PpCp> cps, FiltroRelatorioCargaMaquinaDTO filtro) {
		RelatorioCargaMaquinaDTO retorno = new RelatorioCargaMaquinaDTO();
		retorno.setItens(new ArrayList<RelatorioCargaMaquinaDTO>());

		Date dthrInicial = null;
		Date dthrFinal  = null;
		
		//periodo
		dthrInicial = DataHoraRN.getData(filtro.getSelecionaAno(), filtro.getSelecionaMes(), 1);
		dthrFinal = DataHoraRN.getUltimoDiaDoMesDaData(dthrInicial);
		
		
		for (PpCp cp : cps) {
			// tempo disponivel no periodo (baseado no calendario atual)
			for (PpCpproduto pp : cp.getPpCpprodutos()) {
				RelatorioCargaMaquinaDTO cpDet = new RelatorioCargaMaquinaDTO();

				// id da cp
				cpDet.setOp(pp.getNrDoc());
				cpDet.setMaquina(cp.getOmPt().getCdPt());
				cpDet.setProduto(pp.getOmProduto().getCdProduto());
				
				//recuperar RAP (ferramenta)
				if (cp.getDwFolha() != null) {
					for (DwFolharap frap : cp.getDwFolha().getDwFolharaps()) {
						for (DwFolharapcom frapc : frap.getDwFolharapcoms()) {
							if (frapc.getOmProduto().getCdProduto().equals(cpDet.getProduto())) {
								//RAP
								cpDet.setMolde(frap.getDwRap().getCdRap());
								break;
							}
						}
						if (cpDet.getMolde() != null) {
							break;
						}
					}
				}
				
				cpDet.setStOp(retornaSituacaoOp(cp.getStCp()));
				
				// totais da cp (resumo)
				totaisCP(cpDet, cp, pp);
				
				// detalhamento por dia: planejado, producao, refugo e boas
				totaisCPPeriodo(cpDet, cp, pp, dthrInicial, dthrFinal);
				
				// tempo disponivel para CP
				Map<Date, Double> tempoDisponivelParaProducaoCP = new HashMap<Date, Double>();
				Date dtHrIniPlan = cp.getDthrInicio();
				Date dtHrFimPlan = cp.getDthrFinal();
				tempoDisponivelParaProducaoCP = getTempoDisponivelPorDia(cp.getOmPt(), dtHrIniPlan, dtHrFimPlan);
				
				// distribuicao do planejamento
				totaisPlanejadosCPPeriodo(cpDet, cp, pp, tempoDisponivelParaProducaoCP, tempoDisponivelParaProducaoCP);
				
				
				retorno.getItens().add(cpDet);
			}
			
		}
		
		totaisMaquina(retorno);
		return retorno;
	}
	
	private SortedMap<Date, Double> getTempoDisponivelPorDia(OmPt omPt, Date dtRefIni, Date dtRefFim) {
		SortedMap<Date, Double> retorno = new TreeMap<Date, Double>();
		TurnoRN turnoRN = new TurnoRN(getDao());
		
		Date dtRef = dtRefIni;
		while (DataHoraRN.before(dtRef, dtRefFim) ||  DataHoraRN.compareTo(dtRef, dtRefFim) == 0) {
			Date dtHrI = DataHoraRN.adicionaSegundosNaData(dtRef, 0);
			Date dtHrF = DataHoraRN.adicionaSegundosNaData(dtRef, 86400-1); // dia inteiro (86400) menos 1 segundo
			
			
			List<TurnoAtualDTO> turnos = null;
			try {
				turnos = turnoRN.getTurnoAtualDTOsPeriodo(omPt, dtHrI, dtHrF);
			} catch (SemCalendarioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			// duracao dos turnos desconsiderando turno indefinido 
			Double duracaoTurnos = 0d;			
			for(TurnoAtualDTO turno : turnos) {
				if (turno.getIdTurno() != 1) {
					Date dtHrIni = turno.getDtHrITurno();
					Date dtHrFim = turno.getDtHrFTurno();
					
					if (DataHoraRN.before(dtHrIni, dtHrI)) {
						dtHrIni = dtHrI;
					}
					
					if (DataHoraRN.after(dtHrFim, dtHrF)) {
						dtHrFim = dtHrF;
					}
					
					int duracao = DataHoraRN.getQuantidadeSegundosNoPeriodo(dtHrIni, dtHrFim);					
					duracaoTurnos += duracao;
				}
			}			
			if (duracaoTurnos > 0) {
				duracaoTurnos += 1;
			}
			
			retorno.put(dtRef, duracaoTurnos); 			
			
			dtRef = DataHoraRN.adicionaDiasDaData(dtRef, 1);			
		}
		
		return retorno;
	}
	
	private String retornaSituacaoOp(int stOp) {

		switch (stOp) {
		case 0:
			return "Cadastrada";
		case 1:
			return "Firmada";
		case 2:
			return "Suspensa";
		case 3:
			return "Cancelada";
		case 4:
			return "Concluida Manualmente";
		case 5:
			return "Em Setup";
		case 6:
			return "Iniciada";
		}
		return null;
	}	

    private int corProducao(BigDecimal plano, BigDecimal producao) {
        final int corDefault = 1;
        final int corAzul = 2; 
        final int corVermelho = 3;
        
        int cor;
        
        if (plano.doubleValue() == 0d) {
            if (producao.doubleValue() == 0d) {
                cor = corDefault;
            } else {
                cor = corVermelho;
            }
            
        } else {
        	cor = corAzul;
        }

        return cor;
    }	
    
    private int corPlano(BigDecimal plano, BigDecimal producao) {
        final int corDefault = 1;
        final int corVerde = 4;
        
        int cor;
        
        if (producao.doubleValue() > plano.doubleValue()) {
            cor = corVerde;
        } else {
        	cor = corDefault;
        }
        
        return cor;
    }		
	
    private void totaisMaquina(RelatorioCargaMaquinaDTO dto) {
		for (RelatorioCargaMaquinaDTO cp : dto.getItens()) {
			

			//planejado
			dto.setPlanejadoDia0(AritmeticaUtil.somar(dto.getPlanejadoDia0(), cp.getPlanejadoDia0()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia1(AritmeticaUtil.somar(dto.getPlanejadoDia1(), cp.getPlanejadoDia1()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia2(AritmeticaUtil.somar(dto.getPlanejadoDia2(), cp.getPlanejadoDia2()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia3(AritmeticaUtil.somar(dto.getPlanejadoDia3(), cp.getPlanejadoDia3()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia4(AritmeticaUtil.somar(dto.getPlanejadoDia4(), cp.getPlanejadoDia4()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia5(AritmeticaUtil.somar(dto.getPlanejadoDia5(), cp.getPlanejadoDia5()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia6(AritmeticaUtil.somar(dto.getPlanejadoDia6(), cp.getPlanejadoDia6()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia7(AritmeticaUtil.somar(dto.getPlanejadoDia7(), cp.getPlanejadoDia7()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia8(AritmeticaUtil.somar(dto.getPlanejadoDia8(), cp.getPlanejadoDia8()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia9(AritmeticaUtil.somar(dto.getPlanejadoDia9(), cp.getPlanejadoDia9()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia10(AritmeticaUtil.somar(dto.getPlanejadoDia10(), cp.getPlanejadoDia10()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia11(AritmeticaUtil.somar(dto.getPlanejadoDia11(), cp.getPlanejadoDia11()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia12(AritmeticaUtil.somar(dto.getPlanejadoDia12(), cp.getPlanejadoDia12()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia13(AritmeticaUtil.somar(dto.getPlanejadoDia13(), cp.getPlanejadoDia13()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia14(AritmeticaUtil.somar(dto.getPlanejadoDia14(), cp.getPlanejadoDia14()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia15(AritmeticaUtil.somar(dto.getPlanejadoDia15(), cp.getPlanejadoDia15()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia16(AritmeticaUtil.somar(dto.getPlanejadoDia16(), cp.getPlanejadoDia16()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia17(AritmeticaUtil.somar(dto.getPlanejadoDia17(), cp.getPlanejadoDia17()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia18(AritmeticaUtil.somar(dto.getPlanejadoDia18(), cp.getPlanejadoDia18()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia19(AritmeticaUtil.somar(dto.getPlanejadoDia19(), cp.getPlanejadoDia19()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia20(AritmeticaUtil.somar(dto.getPlanejadoDia20(), cp.getPlanejadoDia20()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia21(AritmeticaUtil.somar(dto.getPlanejadoDia21(), cp.getPlanejadoDia21()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia22(AritmeticaUtil.somar(dto.getPlanejadoDia22(), cp.getPlanejadoDia22()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia23(AritmeticaUtil.somar(dto.getPlanejadoDia23(), cp.getPlanejadoDia23()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia24(AritmeticaUtil.somar(dto.getPlanejadoDia24(), cp.getPlanejadoDia24()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia25(AritmeticaUtil.somar(dto.getPlanejadoDia25(), cp.getPlanejadoDia25()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia26(AritmeticaUtil.somar(dto.getPlanejadoDia26(), cp.getPlanejadoDia26()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia27(AritmeticaUtil.somar(dto.getPlanejadoDia27(), cp.getPlanejadoDia27()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia28(AritmeticaUtil.somar(dto.getPlanejadoDia28(), cp.getPlanejadoDia28()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia29(AritmeticaUtil.somar(dto.getPlanejadoDia29(), cp.getPlanejadoDia29()).setScale(4, RoundingMode.HALF_UP));
			dto.setPlanejadoDia30(AritmeticaUtil.somar(dto.getPlanejadoDia30(), cp.getPlanejadoDia30()).setScale(4, RoundingMode.HALF_UP));

			
			//produzido
			dto.setProducaoDia0(AritmeticaUtil.somar(dto.getProducaoDia0(), cp.getProducaoDia0()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia1(AritmeticaUtil.somar(dto.getProducaoDia1(), cp.getProducaoDia1()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia2(AritmeticaUtil.somar(dto.getProducaoDia2(), cp.getProducaoDia2()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia3(AritmeticaUtil.somar(dto.getProducaoDia3(), cp.getProducaoDia3()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia4(AritmeticaUtil.somar(dto.getProducaoDia4(), cp.getProducaoDia4()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia5(AritmeticaUtil.somar(dto.getProducaoDia5(), cp.getProducaoDia5()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia6(AritmeticaUtil.somar(dto.getProducaoDia6(), cp.getProducaoDia6()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia7(AritmeticaUtil.somar(dto.getProducaoDia7(), cp.getProducaoDia7()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia8(AritmeticaUtil.somar(dto.getProducaoDia8(), cp.getProducaoDia8()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia9(AritmeticaUtil.somar(dto.getProducaoDia9(), cp.getProducaoDia9()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia10(AritmeticaUtil.somar(dto.getProducaoDia10(), cp.getProducaoDia10()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia11(AritmeticaUtil.somar(dto.getProducaoDia11(), cp.getProducaoDia11()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia12(AritmeticaUtil.somar(dto.getProducaoDia12(), cp.getProducaoDia12()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia13(AritmeticaUtil.somar(dto.getProducaoDia13(), cp.getProducaoDia13()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia14(AritmeticaUtil.somar(dto.getProducaoDia14(), cp.getProducaoDia14()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia15(AritmeticaUtil.somar(dto.getProducaoDia15(), cp.getProducaoDia15()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia16(AritmeticaUtil.somar(dto.getProducaoDia16(), cp.getProducaoDia16()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia17(AritmeticaUtil.somar(dto.getProducaoDia17(), cp.getProducaoDia17()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia18(AritmeticaUtil.somar(dto.getProducaoDia18(), cp.getProducaoDia18()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia19(AritmeticaUtil.somar(dto.getProducaoDia19(), cp.getProducaoDia19()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia20(AritmeticaUtil.somar(dto.getProducaoDia20(), cp.getProducaoDia20()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia21(AritmeticaUtil.somar(dto.getProducaoDia21(), cp.getProducaoDia21()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia22(AritmeticaUtil.somar(dto.getProducaoDia22(), cp.getProducaoDia22()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia23(AritmeticaUtil.somar(dto.getProducaoDia23(), cp.getProducaoDia23()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia24(AritmeticaUtil.somar(dto.getProducaoDia24(), cp.getProducaoDia24()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia25(AritmeticaUtil.somar(dto.getProducaoDia25(), cp.getProducaoDia25()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia26(AritmeticaUtil.somar(dto.getProducaoDia26(), cp.getProducaoDia26()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia27(AritmeticaUtil.somar(dto.getProducaoDia27(), cp.getProducaoDia27()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia28(AritmeticaUtil.somar(dto.getProducaoDia28(), cp.getProducaoDia28()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia29(AritmeticaUtil.somar(dto.getProducaoDia29(), cp.getProducaoDia29()).setScale(4, RoundingMode.HALF_UP));
			dto.setProducaoDia30(AritmeticaUtil.somar(dto.getProducaoDia30(), cp.getProducaoDia30()).setScale(4, RoundingMode.HALF_UP));
			
			
			//refugado
			dto.setRefugoDia0(AritmeticaUtil.somar(dto.getRefugoDia0(), cp.getRefugoDia0()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia1(AritmeticaUtil.somar(dto.getRefugoDia1(), cp.getRefugoDia1()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia2(AritmeticaUtil.somar(dto.getRefugoDia2(), cp.getRefugoDia2()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia3(AritmeticaUtil.somar(dto.getRefugoDia3(), cp.getRefugoDia3()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia4(AritmeticaUtil.somar(dto.getRefugoDia4(), cp.getRefugoDia4()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia5(AritmeticaUtil.somar(dto.getRefugoDia5(), cp.getRefugoDia5()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia6(AritmeticaUtil.somar(dto.getRefugoDia6(), cp.getRefugoDia6()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia7(AritmeticaUtil.somar(dto.getRefugoDia7(), cp.getRefugoDia7()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia8(AritmeticaUtil.somar(dto.getRefugoDia8(), cp.getRefugoDia8()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia9(AritmeticaUtil.somar(dto.getRefugoDia9(), cp.getRefugoDia9()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia10(AritmeticaUtil.somar(dto.getRefugoDia10(), cp.getRefugoDia10()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia11(AritmeticaUtil.somar(dto.getRefugoDia11(), cp.getRefugoDia11()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia12(AritmeticaUtil.somar(dto.getRefugoDia12(), cp.getRefugoDia12()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia13(AritmeticaUtil.somar(dto.getRefugoDia13(), cp.getRefugoDia13()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia14(AritmeticaUtil.somar(dto.getRefugoDia14(), cp.getRefugoDia14()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia15(AritmeticaUtil.somar(dto.getRefugoDia15(), cp.getRefugoDia15()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia16(AritmeticaUtil.somar(dto.getRefugoDia16(), cp.getRefugoDia16()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia17(AritmeticaUtil.somar(dto.getRefugoDia17(), cp.getRefugoDia17()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia18(AritmeticaUtil.somar(dto.getRefugoDia18(), cp.getRefugoDia18()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia19(AritmeticaUtil.somar(dto.getRefugoDia19(), cp.getRefugoDia19()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia20(AritmeticaUtil.somar(dto.getRefugoDia20(), cp.getRefugoDia20()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia21(AritmeticaUtil.somar(dto.getRefugoDia21(), cp.getRefugoDia21()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia22(AritmeticaUtil.somar(dto.getRefugoDia22(), cp.getRefugoDia22()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia23(AritmeticaUtil.somar(dto.getRefugoDia23(), cp.getRefugoDia23()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia24(AritmeticaUtil.somar(dto.getRefugoDia24(), cp.getRefugoDia24()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia25(AritmeticaUtil.somar(dto.getRefugoDia25(), cp.getRefugoDia25()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia26(AritmeticaUtil.somar(dto.getRefugoDia26(), cp.getRefugoDia26()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia27(AritmeticaUtil.somar(dto.getRefugoDia27(), cp.getRefugoDia27()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia28(AritmeticaUtil.somar(dto.getRefugoDia28(), cp.getRefugoDia28()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia29(AritmeticaUtil.somar(dto.getRefugoDia29(), cp.getRefugoDia29()).setScale(4, RoundingMode.HALF_UP));
			dto.setRefugoDia30(AritmeticaUtil.somar(dto.getRefugoDia30(), cp.getRefugoDia30()).setScale(4, RoundingMode.HALF_UP));
			
			//boas
			dto.setBoasDia0(AritmeticaUtil.somar(dto.getBoasDia0(), cp.getBoasDia0()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia1(AritmeticaUtil.somar(dto.getBoasDia1(), cp.getBoasDia1()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia2(AritmeticaUtil.somar(dto.getBoasDia2(), cp.getBoasDia2()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia3(AritmeticaUtil.somar(dto.getBoasDia3(), cp.getBoasDia3()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia4(AritmeticaUtil.somar(dto.getBoasDia4(), cp.getBoasDia4()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia5(AritmeticaUtil.somar(dto.getBoasDia5(), cp.getBoasDia5()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia6(AritmeticaUtil.somar(dto.getBoasDia6(), cp.getBoasDia6()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia7(AritmeticaUtil.somar(dto.getBoasDia7(), cp.getBoasDia7()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia8(AritmeticaUtil.somar(dto.getBoasDia8(), cp.getBoasDia8()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia9(AritmeticaUtil.somar(dto.getBoasDia9(), cp.getBoasDia9()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia10(AritmeticaUtil.somar(dto.getBoasDia10(), cp.getBoasDia10()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia11(AritmeticaUtil.somar(dto.getBoasDia11(), cp.getBoasDia11()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia12(AritmeticaUtil.somar(dto.getBoasDia12(), cp.getBoasDia12()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia13(AritmeticaUtil.somar(dto.getBoasDia13(), cp.getBoasDia13()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia14(AritmeticaUtil.somar(dto.getBoasDia14(), cp.getBoasDia14()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia15(AritmeticaUtil.somar(dto.getBoasDia15(), cp.getBoasDia15()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia16(AritmeticaUtil.somar(dto.getBoasDia16(), cp.getBoasDia16()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia17(AritmeticaUtil.somar(dto.getBoasDia17(), cp.getBoasDia17()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia18(AritmeticaUtil.somar(dto.getBoasDia18(), cp.getBoasDia18()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia19(AritmeticaUtil.somar(dto.getBoasDia19(), cp.getBoasDia19()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia20(AritmeticaUtil.somar(dto.getBoasDia20(), cp.getBoasDia20()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia21(AritmeticaUtil.somar(dto.getBoasDia21(), cp.getBoasDia21()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia22(AritmeticaUtil.somar(dto.getBoasDia22(), cp.getBoasDia22()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia23(AritmeticaUtil.somar(dto.getBoasDia23(), cp.getBoasDia23()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia24(AritmeticaUtil.somar(dto.getBoasDia24(), cp.getBoasDia24()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia25(AritmeticaUtil.somar(dto.getBoasDia25(), cp.getBoasDia25()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia26(AritmeticaUtil.somar(dto.getBoasDia26(), cp.getBoasDia26()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia27(AritmeticaUtil.somar(dto.getBoasDia27(), cp.getBoasDia27()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia28(AritmeticaUtil.somar(dto.getBoasDia28(), cp.getBoasDia28()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia29(AritmeticaUtil.somar(dto.getBoasDia29(), cp.getBoasDia29()).setScale(4, RoundingMode.HALF_UP));
			dto.setBoasDia30(AritmeticaUtil.somar(dto.getBoasDia30(), cp.getBoasDia30()).setScale(4, RoundingMode.HALF_UP));
			
			//cor
			dto.setCorDia0(corProducao(dto.getPlanejadoDia0(), dto.getProducaoDia0()));
			dto.setCorDia1(corProducao(dto.getPlanejadoDia1(), dto.getProducaoDia1()));
			dto.setCorDia2(corProducao(dto.getPlanejadoDia2(), dto.getProducaoDia2()));
			dto.setCorDia3(corProducao(dto.getPlanejadoDia3(), dto.getProducaoDia3()));
			dto.setCorDia4(corProducao(dto.getPlanejadoDia4(), dto.getProducaoDia4()));
			dto.setCorDia5(corProducao(dto.getPlanejadoDia5(), dto.getProducaoDia5()));
			dto.setCorDia6(corProducao(dto.getPlanejadoDia6(), dto.getProducaoDia6()));
			dto.setCorDia7(corProducao(dto.getPlanejadoDia7(), dto.getProducaoDia7()));
			dto.setCorDia8(corProducao(dto.getPlanejadoDia8(), dto.getProducaoDia8()));
			dto.setCorDia9(corProducao(dto.getPlanejadoDia9(), dto.getProducaoDia9()));
			dto.setCorDia10(corProducao(dto.getPlanejadoDia10(), dto.getProducaoDia10()));
			dto.setCorDia11(corProducao(dto.getPlanejadoDia11(), dto.getProducaoDia11()));
			dto.setCorDia12(corProducao(dto.getPlanejadoDia12(), dto.getProducaoDia12()));
			dto.setCorDia13(corProducao(dto.getPlanejadoDia13(), dto.getProducaoDia13()));
			dto.setCorDia14(corProducao(dto.getPlanejadoDia14(), dto.getProducaoDia14()));
			dto.setCorDia15(corProducao(dto.getPlanejadoDia15(), dto.getProducaoDia15()));
			dto.setCorDia16(corProducao(dto.getPlanejadoDia16(), dto.getProducaoDia16()));
			dto.setCorDia17(corProducao(dto.getPlanejadoDia17(), dto.getProducaoDia17()));
			dto.setCorDia18(corProducao(dto.getPlanejadoDia18(), dto.getProducaoDia18()));
			dto.setCorDia19(corProducao(dto.getPlanejadoDia19(), dto.getProducaoDia19()));
			dto.setCorDia20(corProducao(dto.getPlanejadoDia20(), dto.getProducaoDia20()));
			dto.setCorDia21(corProducao(dto.getPlanejadoDia21(), dto.getProducaoDia21()));
			dto.setCorDia22(corProducao(dto.getPlanejadoDia22(), dto.getProducaoDia22()));
			dto.setCorDia23(corProducao(dto.getPlanejadoDia23(), dto.getProducaoDia23()));
			dto.setCorDia24(corProducao(dto.getPlanejadoDia24(), dto.getProducaoDia24()));
			dto.setCorDia25(corProducao(dto.getPlanejadoDia25(), dto.getProducaoDia25()));
			dto.setCorDia26(corProducao(dto.getPlanejadoDia26(), dto.getProducaoDia26()));
			dto.setCorDia27(corProducao(dto.getPlanejadoDia27(), dto.getProducaoDia27()));
			dto.setCorDia28(corProducao(dto.getPlanejadoDia28(), dto.getProducaoDia28()));
			dto.setCorDia29(corProducao(dto.getPlanejadoDia29(), dto.getProducaoDia29()));
			dto.setCorDia30(corProducao(dto.getPlanejadoDia30(), dto.getProducaoDia30()));
			
		}
	}
	

	private void totaisCPPeriodo(RelatorioCargaMaquinaDTO cpDet, PpCp cp, PpCpproduto pp, Date dthrInicial, Date dthrFinal) {
		List<DwConsolid> producao = consultaConsolCP(cp, pp, dthrInicial, dthrFinal);
		
		final int corSemPlano = 3;
		
		class Producao {
			Date dtreferencia = null;
			BigDecimal prodBruta = BigDecimal.ZERO;
			BigDecimal prodRefugada = BigDecimal.ZERO;
			BigDecimal prodBoa = BigDecimal.ZERO;			
		}
		
		Map<Date, Producao> mapTotalDia = new HashMap<Date, Producao>();
		
		for(DwConsolid id : producao) {
			for (DwConsolpr pro : id.getDwConsol().getDwConsolprs()) {
				Producao producaoDia = new Producao();
				
				if (mapTotalDia.containsKey(id.getDtReferencia()) == true) {
					// acumula
					producaoDia =  mapTotalDia.get(id.getDtReferencia());					
					producaoDia.prodBruta = AritmeticaUtil.somar(producaoDia.prodBruta, pro.getPcsProducaoBruta());
					producaoDia.prodRefugada = AritmeticaUtil.somar(producaoDia.prodRefugada, pro.getPcsProducaoRefugada());
					producaoDia.prodBoa = AritmeticaUtil.somar(producaoDia.prodBoa, pro.getPcsProducaoLiquida());
					
				} else {
					// inclui
					producaoDia.dtreferencia = id.getDtReferencia();
					producaoDia.prodBruta = pro.getPcsProducaoBruta();
					producaoDia.prodRefugada = pro.getPcsProducaoRefugada();
					producaoDia.prodBoa = pro.getPcsProducaoLiquida();
				}
				
				mapTotalDia.put(id.getDtReferencia(), producaoDia);				
			}
		}
		
		Set<Date> datas =  mapTotalDia.keySet();
		for (Date data : datas) {
			BigDecimal prodBruta = mapTotalDia.get(data).prodBruta.setScale(4, RoundingMode.HALF_UP);
			BigDecimal prodRefugada = mapTotalDia.get(data).prodRefugada.setScale(4, RoundingMode.HALF_UP);
			BigDecimal prodBoa = mapTotalDia.get(data).prodBoa.setScale(4, RoundingMode.HALF_UP);
			
			
			switch ( DataHoraRN.getDia(data)  ) {
			case 1:				
				cpDet.setDia(1);
				cpDet.setProducaoDia0(prodBruta);
				cpDet.setRefugoDia0(prodRefugada);
				cpDet.setBoasDia0(prodBoa);
				cpDet.setCorDia0(corSemPlano);
				break;
			case 2:				
				cpDet.setDia(2);
				cpDet.setProducaoDia1(prodBruta);
				cpDet.setRefugoDia1(prodRefugada);
				cpDet.setBoasDia1(prodBoa);
				cpDet.setCorDia1(corSemPlano);
				break;
			case 3:				
				cpDet.setDia(3);
				cpDet.setProducaoDia2(prodBruta);
				cpDet.setRefugoDia2(prodRefugada);
				cpDet.setBoasDia2(prodBoa);
				cpDet.setCorDia2(corSemPlano);
				break;
			case 4:		
				cpDet.setDia(4);
				cpDet.setProducaoDia3(prodBruta);
				cpDet.setRefugoDia3(prodRefugada);
				cpDet.setBoasDia3(prodBoa);		
				cpDet.setCorDia3(corSemPlano);
				break;
			case 5:				
				cpDet.setDia(5);
				cpDet.setProducaoDia4(prodBruta);
				cpDet.setRefugoDia4(prodRefugada);
				cpDet.setBoasDia4(prodBoa);		
				cpDet.setCorDia4(corSemPlano);
				break;
			case 6:				
				cpDet.setDia(6);
				cpDet.setProducaoDia5(prodBruta);
				cpDet.setRefugoDia5(prodRefugada);
				cpDet.setBoasDia5(prodBoa);		
				cpDet.setCorDia5(corSemPlano);
				break;
			case 7:				
				cpDet.setDia(7);
				cpDet.setProducaoDia6(prodBruta);
				cpDet.setRefugoDia6(prodRefugada);
				cpDet.setBoasDia6(prodBoa);		
				cpDet.setCorDia6(corSemPlano);
				break;
			case 8:				
				cpDet.setDia(8);
				cpDet.setProducaoDia7(prodBruta);
				cpDet.setRefugoDia7(prodRefugada);
				cpDet.setBoasDia7(prodBoa);		
				cpDet.setCorDia7(corSemPlano);
				break;
			case 9:				
				cpDet.setDia(9);
				cpDet.setProducaoDia8(prodBruta);
				cpDet.setRefugoDia8(prodRefugada);
				cpDet.setBoasDia8(prodBoa);		
				cpDet.setCorDia8(corSemPlano);
				break;
			case 10:				
				cpDet.setDia(10);
				cpDet.setProducaoDia9(prodBruta);
				cpDet.setRefugoDia9(prodRefugada);
				cpDet.setBoasDia9(prodBoa);		
				cpDet.setCorDia8(corSemPlano);
				break;
			case 11:				
				cpDet.setDia(11);
				cpDet.setProducaoDia10(prodBruta);
				cpDet.setRefugoDia10(prodRefugada);
				cpDet.setBoasDia10(prodBoa);	
				cpDet.setCorDia10(corSemPlano);
				break;				
			case 12:				
				cpDet.setDia(12);
				cpDet.setProducaoDia11(prodBruta);
				cpDet.setRefugoDia11(prodRefugada);
				cpDet.setBoasDia11(prodBoa);	
				cpDet.setCorDia11(corSemPlano);
				break;
			case 13:	
				cpDet.setDia(13);
				cpDet.setProducaoDia12(prodBruta);
				cpDet.setRefugoDia12(prodRefugada);
				cpDet.setBoasDia12(prodBoa);	
				cpDet.setCorDia12(corSemPlano);
				break;
			case 14:				
				cpDet.setDia(14);
				cpDet.setProducaoDia13(prodBruta);
				cpDet.setRefugoDia13(prodRefugada);
				cpDet.setBoasDia13(prodBoa);	
				cpDet.setCorDia13(corSemPlano);
				break;
			case 15:				
				cpDet.setDia(15);
				cpDet.setProducaoDia14(prodBruta);
				cpDet.setRefugoDia14(prodRefugada);
				cpDet.setBoasDia14(prodBoa);	
				cpDet.setCorDia14(corSemPlano);
				break;
			case 16:				
				cpDet.setDia(16);
				cpDet.setProducaoDia15(prodBruta);
				cpDet.setRefugoDia15(prodRefugada);
				cpDet.setBoasDia15(prodBoa);	
				cpDet.setCorDia15(corSemPlano);
				break;
			case 17:				
				cpDet.setDia(17);
				cpDet.setProducaoDia16(prodBruta);
				cpDet.setRefugoDia16(prodRefugada);
				cpDet.setBoasDia16(prodBoa);
				cpDet.setCorDia16(corSemPlano);
				break;
			case 18:				
				cpDet.setDia(18);
				cpDet.setProducaoDia17(prodBruta);
				cpDet.setRefugoDia17(prodRefugada);
				cpDet.setBoasDia17(prodBoa);	
				cpDet.setCorDia17(corSemPlano);
				break;
			case 19:				
				cpDet.setDia(19);
				cpDet.setProducaoDia18(prodBruta);
				cpDet.setRefugoDia18(prodRefugada);
				cpDet.setBoasDia18(prodBoa);	
				cpDet.setCorDia18(corSemPlano);
				break;
			case 20:				
				cpDet.setDia(20);
				cpDet.setProducaoDia19(prodBruta);
				cpDet.setRefugoDia19(prodRefugada);
				cpDet.setBoasDia19(prodBoa);	
				cpDet.setCorDia19(corSemPlano);
				break;
			case 21:				
				cpDet.setDia(21);
				cpDet.setProducaoDia20(prodBruta);
				cpDet.setRefugoDia20(prodRefugada);
				cpDet.setBoasDia20(prodBoa);	
				cpDet.setCorDia20(corSemPlano);
				break;				
			case 22:	
				cpDet.setDia(22);
				cpDet.setProducaoDia21(prodBruta);
				cpDet.setRefugoDia21(prodRefugada);
				cpDet.setBoasDia21(prodBoa);	
				cpDet.setCorDia21(corSemPlano);
				break;
			case 23:				
				cpDet.setDia(23);
				cpDet.setProducaoDia22(prodBruta);
				cpDet.setRefugoDia22(prodRefugada);
				cpDet.setBoasDia22(prodBoa);	
				cpDet.setCorDia22(corSemPlano);
				break;
			case 24:				
				cpDet.setDia(24);
				cpDet.setProducaoDia23(prodBruta);
				cpDet.setRefugoDia23(prodRefugada);
				cpDet.setBoasDia23(prodBoa);	
				cpDet.setCorDia23(corSemPlano);
				break;
			case 25:				
				cpDet.setDia(25);
				cpDet.setProducaoDia24(prodBruta);
				cpDet.setRefugoDia24(prodRefugada);
				cpDet.setBoasDia24(prodBoa);	
				cpDet.setCorDia24(corSemPlano);
				break;
			case 26:				
				cpDet.setDia(26);
				cpDet.setProducaoDia25(prodBruta);
				cpDet.setRefugoDia25(prodRefugada);
				cpDet.setBoasDia25(prodBoa);	
				cpDet.setCorDia25(corSemPlano);
				break;
			case 27:				
				cpDet.setDia(27);
				cpDet.setProducaoDia26(prodBruta);
				cpDet.setRefugoDia26(prodRefugada);
				cpDet.setBoasDia26(prodBoa);	
				cpDet.setCorDia26(corSemPlano);
				break;
			case 28:				
				cpDet.setDia(28);
				cpDet.setProducaoDia27(prodBruta);
				cpDet.setRefugoDia27(prodRefugada);
				cpDet.setBoasDia27(prodBoa);	
				cpDet.setCorDia27(corSemPlano);
				break;
			case 29:				
				cpDet.setDia(29);
				cpDet.setProducaoDia28(prodBruta);
				cpDet.setRefugoDia28(prodRefugada);
				cpDet.setBoasDia28(prodBoa);	
				cpDet.setCorDia28(corSemPlano);
				break;
			case 30:				
				cpDet.setDia(30);
				cpDet.setProducaoDia29(prodBruta);
				cpDet.setRefugoDia29(prodRefugada);
				cpDet.setBoasDia29(prodBoa);	
				cpDet.setCorDia29(corSemPlano);
				break;
			case 31:				
				cpDet.setDia(31);
				cpDet.setProducaoDia30(prodBruta);
				cpDet.setRefugoDia30(prodRefugada);
				cpDet.setBoasDia30(prodBoa);	
				cpDet.setCorDia30(corSemPlano);
				break;
			}
		}
	}
	
	private void totaisPlanejadosCPPeriodo(RelatorioCargaMaquinaDTO cpDet, PpCp cp, PpCpproduto pp, Map<Date, Double> tempoDisponivelParaPlanejadoCP, Map<Date, Double> tempoDisponivelParaPlanejado ) {
		FolhaRN folhaRN = new FolhaRN(getDao());
		
		// fator de contagem
		BigDecimal fatorContagem = BigDecimal.ONE;
		try {
			fatorContagem = folhaRN.getFatorContagemFromDwFolha(cp.getDwFolha(), cp.getOmPt());
		} catch (SemPacoteOuFatorException e) {

		}
		
		// pcs por ciclo
		BigDecimal pcsCicloAtivas = BigDecimal.ONE;
		try {
			pcsCicloAtivas = folhaRN.getPcsPorCicloAtivas(cp.getDwFolha(), pp.getOmProduto());
		} catch (SemPcsPorCicloAtivasException e) {

		}
		
		// ciclo padrao
		BigDecimal cicloPadrao = BigDecimal.ONE;
		try {
			cicloPadrao = folhaRN.getCicloPadrao(cp.getDwFolha(), cp.getOmPt());
		} catch (SemCicloPadraoException e) {

		}

		BigDecimal saldoPlanejado = pp.getPcsProducaoplanejada();
				
		Set<Date> datas =  tempoDisponivelParaPlanejadoCP.keySet();
		for (Date data : datas) {
			BigDecimal tempoDisp = new BigDecimal(tempoDisponivelParaPlanejadoCP.get(data));
			BigDecimal prodPlanDia = FormulasInjet.calcularProducaoPrevista(tempoDisp, cicloPadrao, pcsCicloAtivas, fatorContagem, cp.getOmPt().getIndOee()).setScale(4, RoundingMode.HALF_UP);
			
			if (prodPlanDia.doubleValue() > saldoPlanejado.doubleValue()) {
				prodPlanDia = saldoPlanejado.setScale(4, RoundingMode.HALF_UP);
			}
			
			if (saldoPlanejado.doubleValue() <= 0d) {
				prodPlanDia = BigDecimal.ZERO.setScale(4, RoundingMode.HALF_UP);
			} 			
			
			
			// verifica se existe intersecao de data
			if (tempoDisponivelParaPlanejado.containsKey(data)) {
				switch ( DataHoraRN.getDia(data)  ) {
				case 1:
					cpDet.setPlanejadoDia0(prodPlanDia);
					cpDet.setCorDia0(corProducao(prodPlanDia, cpDet.getProducaoDia0()));
					break;
				case 2:
					cpDet.setPlanejadoDia1(prodPlanDia);
					cpDet.setCorDia1(corProducao(prodPlanDia, cpDet.getProducaoDia1()));
					break;
				case 3:
					cpDet.setPlanejadoDia2(prodPlanDia);
					cpDet.setCorDia2(corProducao(prodPlanDia, cpDet.getProducaoDia2()));
					break;
				case 4:
					cpDet.setPlanejadoDia3(prodPlanDia);
					cpDet.setCorDia3(corProducao(prodPlanDia, cpDet.getProducaoDia3()));
					break;
				case 5:
					cpDet.setPlanejadoDia4(prodPlanDia);
					cpDet.setCorDia4(corProducao(prodPlanDia, cpDet.getProducaoDia4()));
					break;
				case 6:
					cpDet.setPlanejadoDia5(prodPlanDia);
					cpDet.setCorDia5(corProducao(prodPlanDia, cpDet.getProducaoDia5()));
					break;
				case 7:
					cpDet.setPlanejadoDia6(prodPlanDia);
					cpDet.setCorDia6(corProducao(prodPlanDia, cpDet.getProducaoDia6()));
					break;
				case 8:
					cpDet.setPlanejadoDia7(prodPlanDia);
					cpDet.setCorDia7(corProducao(prodPlanDia, cpDet.getProducaoDia7()));
					break;
				case 9:
					cpDet.setPlanejadoDia8(prodPlanDia);
					cpDet.setCorDia8(corProducao(prodPlanDia, cpDet.getProducaoDia8()));
					break;
				case 10:
					cpDet.setPlanejadoDia9(prodPlanDia);
					cpDet.setCorDia9(corProducao(prodPlanDia, cpDet.getProducaoDia9()));
					break;
				case 11:
					cpDet.setPlanejadoDia10(prodPlanDia);
					cpDet.setCorDia10(corProducao(prodPlanDia, cpDet.getProducaoDia10()));
					break;
				case 12:
					cpDet.setPlanejadoDia11(prodPlanDia);
					cpDet.setCorDia11(corProducao(prodPlanDia, cpDet.getProducaoDia11()));
					break;
				case 13:
					cpDet.setPlanejadoDia12(prodPlanDia);
					cpDet.setCorDia12(corProducao(prodPlanDia, cpDet.getProducaoDia12()));
					break;
				case 14:
					cpDet.setPlanejadoDia13(prodPlanDia);
					cpDet.setCorDia13(corProducao(prodPlanDia, cpDet.getProducaoDia13()));
					break;
				case 15:
					cpDet.setPlanejadoDia14(prodPlanDia);
					cpDet.setCorDia14(corProducao(prodPlanDia, cpDet.getProducaoDia14()));
					break;
				case 16:
					cpDet.setPlanejadoDia15(prodPlanDia);
					cpDet.setCorDia15(corProducao(prodPlanDia, cpDet.getProducaoDia15()));
					break;
				case 17:
					cpDet.setPlanejadoDia16(prodPlanDia);
					cpDet.setCorDia16(corProducao(prodPlanDia, cpDet.getProducaoDia16()));
					break;
				case 18:
					cpDet.setPlanejadoDia17(prodPlanDia);
					cpDet.setCorDia17(corProducao(prodPlanDia, cpDet.getProducaoDia17()));
					break;
				case 19:
					cpDet.setPlanejadoDia18(prodPlanDia);
					cpDet.setCorDia18(corProducao(prodPlanDia, cpDet.getProducaoDia18()));
					break;
				case 20:
					cpDet.setPlanejadoDia19(prodPlanDia);
					cpDet.setCorDia19(corProducao(prodPlanDia, cpDet.getProducaoDia19()));
					break;
				case 21:
					cpDet.setPlanejadoDia20(prodPlanDia);
					cpDet.setCorDia20(corProducao(prodPlanDia, cpDet.getProducaoDia20()));
					break;
				case 22:
					cpDet.setPlanejadoDia21(prodPlanDia);
					cpDet.setCorDia21(corProducao(prodPlanDia, cpDet.getProducaoDia21()));
					break;
				case 23:
					cpDet.setPlanejadoDia22(prodPlanDia);
					cpDet.setCorDia22(corProducao(prodPlanDia, cpDet.getProducaoDia22()));
					break;
				case 24:
					cpDet.setPlanejadoDia23(prodPlanDia);
					cpDet.setCorDia23(corProducao(prodPlanDia, cpDet.getProducaoDia23()));
					break;
				case 25:
					cpDet.setPlanejadoDia24(prodPlanDia);
					cpDet.setCorDia24(corProducao(prodPlanDia, cpDet.getProducaoDia24()));
					break;
				case 26:
					cpDet.setPlanejadoDia25(prodPlanDia);
					cpDet.setCorDia25(corProducao(prodPlanDia, cpDet.getProducaoDia25()));
					break;
				case 27:
					cpDet.setPlanejadoDia26(prodPlanDia);
					cpDet.setCorDia26(corProducao(prodPlanDia, cpDet.getProducaoDia26()));
					break;
				case 28:
					cpDet.setPlanejadoDia27(prodPlanDia);
					cpDet.setCorDia27(corProducao(prodPlanDia, cpDet.getProducaoDia27()));
					break;
				case 29:
					cpDet.setPlanejadoDia28(prodPlanDia);
					cpDet.setCorDia28(corProducao(prodPlanDia, cpDet.getProducaoDia28()));
					break;
				case 30:
					cpDet.setPlanejadoDia29(prodPlanDia);
					cpDet.setCorDia29(corProducao(prodPlanDia, cpDet.getProducaoDia29()));
					break;
				case 31:
					cpDet.setPlanejadoDia30(prodPlanDia);
					cpDet.setCorDia30(corProducao(prodPlanDia, cpDet.getProducaoDia30()));
					break;
				}
			}
			
			saldoPlanejado = AritmeticaUtil.diminuir(saldoPlanejado, prodPlanDia);			
		}		
	}
		
	private List<DwConsolid> consultaConsolCP(PpCp cp, PpCpproduto pp, Date dthrInicial, Date dthrFinal) {

		MapQuery q = new MapQuery(getDaoSession());

		q.append("SELECT DISTINCT consolid");
		q.append("FROM DwConsolid consolid");
		q.append("JOIN consolid.dwConsols consol");
		q.append("JOIN consolid.omPt pt");
		q.append("JOIN consolid.ppCp cp");
		q.append("JOIN cp.ppCpprodutos ppCpproduto");
		q.append("JOIN ppCpproduto.omProduto produto");
		q.append("JOIN consolid.dwFolha folha");
		q.append("left JOIN folha.dwFolharaps folharap");
		q.append("left JOIN folharap.dwRap rap");
		q.append("left JOIN rap.dwRapGrupos rapGrupo");
		q.append("left JOIN rapGrupo.dwGrupoFerramenta grupoFerramenta");
		q.append("left join folha.dwFolhaiacs dwfolhaiac");
		q.append("left join pt.omObjs omobj");
		q.append("left join omobj.omGtByIdGt omgt");
		
		q.append("WHERE consolid.tpId = 1"); // turno
		q.append("AND consolid.stAtivo IS NULL"); // somente producao normal
		q.append("AND consolid.dwTurno.idTurno <> 0"); // desconsidera turno indefinido
		q.append("AND cp.cdCp = :cdCp");
		q.append("AND pt.cdPt = :cdPt");
		q.append("AND produto.cdProduto = :cdProduto");		
		q.append("AND consolid.dtReferencia between :inicio and :fim");
		

		//parametros
		q.defineParametroData("inicio", dthrInicial);
		q.defineParametroData("fim", dthrFinal);
		q.defineParametro("cdCp", cp.getCdCp());
		q.defineParametro("cdPt", cp.getOmPt().getCdPt());
		q.defineParametro("cdProduto", pp.getOmProduto().getCdProduto());
		

		List<DwConsolid> retorno = q.list();
		return retorno;
	}

	private void totaisCP(RelatorioCargaMaquinaDTO cpDet, PpCp cp, PpCpproduto pp) {
		FolhaRN folhaRN = new FolhaRN(getDao());
		
		// fator de contagem
		BigDecimal fatorContagem = BigDecimal.ONE;
		try {
			fatorContagem = folhaRN.getFatorContagemFromDwFolha(cp.getDwFolha(), cp.getOmPt());
		} catch (SemPacoteOuFatorException e) {

		}
		
		// pcs por ciclo
		BigDecimal pcsCicloAtivas = BigDecimal.ONE;
		try {
			pcsCicloAtivas = folhaRN.getPcsPorCicloAtivas(cp.getDwFolha(), pp.getOmProduto());
		} catch (SemPcsPorCicloAtivasException e) {

		}
		
		// ciclo padrao
		BigDecimal cicloPadrao = BigDecimal.ONE;
		try {
			cicloPadrao = folhaRN.getCicloPadrao(cp.getDwFolha(), cp.getOmPt());
		} catch (SemCicloPadraoException e) {

		}
				
		//metas		
		BigDecimal metaHoraCP = FormulasInjet.calcularProducaoPrevista(new BigDecimal(3600), cicloPadrao, pcsCicloAtivas, fatorContagem, cp.getOmPt().getIndOee()).setScale(4, RoundingMode.HALF_UP);
		BigDecimal metaDiaCP = FormulasInjet.calcularProducaoPrevista(new BigDecimal(86400), cicloPadrao, pcsCicloAtivas, fatorContagem, cp.getOmPt().getIndOee()).setScale(4, RoundingMode.HALF_UP);
		
		//qtds totais da cp
		BigDecimal prodBrutaCP = (pp.getPcsProducaobruta() ==  null ? BigDecimal.ZERO : pp.getPcsProducaobruta()).setScale(4, RoundingMode.HALF_UP);
		BigDecimal prodRefugadaCP = (pp.getPcsProducaorefugada() ==  null ? BigDecimal.ZERO : pp.getPcsProducaorefugada()).setScale(4, RoundingMode.HALF_UP);
		BigDecimal prodBoaCP = (AritmeticaUtil.diminuir(prodBrutaCP, prodRefugadaCP)).setScale(4, RoundingMode.HALF_UP);
		BigDecimal prodPlanCP = (pp.getPcsProducaoplanejada() ==  null ? BigDecimal.ZERO : pp.getPcsProducaoplanejada()).setScale(4, RoundingMode.HALF_UP);
		BigDecimal prodSaldoCP = (AritmeticaUtil.diminuir(prodPlanCP, prodBoaCP)).setScale(4, RoundingMode.HALF_UP);
		
		cpDet.setPlano(prodPlanCP);
		cpDet.setRefugo(prodRefugadaCP);
		cpDet.setBoas(prodBoaCP);
		cpDet.setSaldo(prodSaldoCP);
		cpDet.setMetaHora(metaHoraCP);
		cpDet.setMetaDia(metaDiaCP);	
		cpDet.setCorQtd(corPlano(cpDet.getPlano(), cpDet.getBoas()));
	}
	
	private List<PpCp> consulta(FiltroRelatorioCargaMaquinaDTO filtro) {
		List<PpCp> retorno = new ArrayList<PpCp>();
		
		Date dthrInicial = null;
		Date dthrFinal  = null;

		//periodo
		dthrInicial = DataHoraRN.getData(filtro.getSelecionaAno(), filtro.getSelecionaMes(), 1);
		dthrFinal = DataHoraRN.getUltimoDiaDoMesDaData(dthrInicial);

		//consulta
		MapQuery q = new MapQuery(getDaoSession());

		q.append("SELECT DISTINCT p");
		q.append("  FROM PpCp p");
		q.append("  JOIN FETCH p.ppCpprodutos pp");
		q.append("  JOIN FETCH pp.omProduto pr");
		q.append("  JOIN FETCH p.dwFolha f");
		q.append("  LEFT JOIN FETCH f.dwFolhacics c");
		q.append("  LEFT JOIN FETCH f.dwFolharaps r");
		q.append("  LEFT JOIN FETCH r.dwFolharapcoms rc");
		q.append("  LEFT JOIN FETCH r.dwRap rap");
		q.append("  LEFT JOIN FETCH rap.dwRapGrupos rg");
		q.append("  LEFT JOIN FETCH rg.dwGrupoFerramenta rf");
		q.append("  LEFT JOIN FETCH p.omPt ompt");
		q.append("  LEFT JOIN ompt.omObjs omobj");
		q.append("  LEFT JOIN omobj.omGtByIdGt omgt");

		// filtro de pt
		q.append(" WHERE ( (p.dthrInicio BETWEEN :dthrini AND :dthrfim) OR (p.dthrFinal BETWEEN :dthrini AND :dthrfim) OR (:dthrini BETWEEN p.dthrInicio AND p.dthrFinal) )");
		q.append("   AND p.dthrInicio IS NOT NULL");
		q.append("   AND p.dthrFinal  IS NOT NULL");
		
		if (filtro.getOmpt() != null && filtro.getOmpt().getCdPt() != null) {
			q.append("AND ompt.cdPt = :cdPt");
		} 

		// grupo de pts
		if (filtro.getOmgt() != null) {
			q.append("AND omgt.cdGt = :cdGt");
		}

		// ferramenta
		if (filtro.getDwRap() != null) {
			q.append("AND rap.cdRap = :cdFerr");
		}

		// grupo de ferramentas
		if (filtro.getMolde() != null) {
			q.append("AND rf.cdGrupoFerramenta = :cdGrpFerr");
		}

		q.append("ORDER BY p.cdCp");
		
		// parametros
		q.defineParametroTimestamp("dthrini", dthrInicial);
		q.defineParametroTimestamp("dthrfim", dthrFinal);

		// filtro de pt
		if (filtro.getOmpt() != null && filtro.getOmpt().getCdPt() != null) {
			q.defineParametro("cdPt", filtro.getOmpt().getCdPt());
		}

		// grupo de pts
		if (filtro.getOmgt() != null) {
			q.defineParametro("cdGt", filtro.getOmgt().getCdGt());
		}

		// ferramenta
		if (filtro.getDwRap() != null) {
			q.defineParametro("cdFerr", filtro.getDwRap().getCdRap());
		}

		// grupo de ferramentas
		if (filtro.getMolde() != null) {
			q.defineParametro("cdGrpFerr", filtro.getMolde().getCdGrupoFerramenta());
		}

		retorno = q.list();
		return retorno;
	}

	
}
