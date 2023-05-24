package idw.model.rn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwRt;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.util.IdwLogger;
import idw.webservices.dto.PassagemDTO;
import idw.webservices.dto.TurnoAtualDTO;
import injetws.model.excessoes.SemSGBDException;

public class TempoRealRN extends AbstractRN<DAOGenerico>{
	
	/**
	 * Controle para atualização de dthr_heartbeat de dw_rt, baseado nos eventos.<br>
	 * Por enquanto, vai ficar false, pois no caso da coleta pela insersora, que ainda não faz o heartbeat, 
	 * vai começar a validar se a máquina está online ou offline na coleta, se for escrito o heartbeat lá  
	 */
	private static final boolean IS_ATUALIZAR_DTHR_HEART_BEAT_BASEADO_EVENTOS = false;

	public TempoRealRN() {
		super(new DAOGenerico());
	}
	public TempoRealRN(DAOGenerico dao) {
		super(dao);
	}

	/*
	 * Obtem o DwRt para o heartbeat do IC na data e hora de referencia passada.
	 * Se nao existir, sera incluido um novo com os mesmos dados do ultimo dwrt da maquina
	 */
	public DwRt obtemDwRtParaHeartBeat(Date dthrReferencia, OmPt ompt, IdwLogger log, int idLog, int identacao, DwPepro dwPepro){
		
		// obtem a referencia do turno correspondente ao PT e hora do evento
		TurnoRN oTurnoRN = new TurnoRN(getDao());

		TurnoAtualDTO oTurnoAtualDTO = null;
		oTurnoAtualDTO = oTurnoRN.getTurnoAtualDTOComClone(ompt, dthrReferencia);

		return obtemDwRtParaHeartBeat(dthrReferencia, ompt, log, idLog, identacao, dwPepro, oTurnoAtualDTO);
		
	}
	
	public DwRt obtemDwRtParaHeartBeatSemClonarTurnoDTO(Date dthrReferencia, OmPt ompt, IdwLogger log, DwPepro dwPepro) throws SemCalendarioException{
		
		// obtem a referencia do turno correspondente ao PT e hora do evento
		TurnoRN oTurnoRN = new TurnoRN(getDao());

		TurnoAtualDTO oTurnoAtualDTO = null;
		oTurnoAtualDTO = oTurnoRN.getTurnoAtualDTOSemClone(ompt, dthrReferencia);

		return obtemDwRtParaHeartBeat(dthrReferencia, ompt, log, 0, 0, dwPepro, oTurnoAtualDTO);
		
	}

	
	public DwRt obtemDwRtParaHeartBeat(Date dthrReferencia, OmPt ompt, IdwLogger log, int idLog, int identacao, DwPepro dwPepro,
			TurnoAtualDTO oTurnoAtualDTO) {
		ConsolidaRN crn = new ConsolidaRN(getDao());
		DwRt retorno = null;

		// Vou pegar um novo idLog para avaliar uam insercao duplicada em dwrt
		idLog = log.getIdAleatorio();
		
		/* Alessandre em 18-05-17 o getDwRt sempre está pegando ompt.getPpCp mas pode acontecer que o posto esteja sem ppcp, nesse caso pegar um
		 * que nao tenha ppcp
		 */
		PpCp ppcp = null;
		if (ompt.getPpCp() != null && (ompt.getIsSemop() != null && ompt.getIsSemop() == false) )
			ppcp = ompt.getPpCp();
		
		// Verifica se ja existe dwrt para o turno em questao
		log.info(idLog, identacao, "Obtendo dwrt para " + DataHoraRN.dateToStringDDMMYYYY(oTurnoAtualDTO.getDtReferencia()) + " turno=" + oTurnoAtualDTO.getIdTurno() + " para pt=" + ompt.getIdPt() + " cp=" + (ompt.getPpCp() != null ? ompt.getPpCp().getIdCp() : " semop") );
		DwRt dwrtNoTurno = this.getDwRt(oTurnoAtualDTO.getDtReferencia(), oTurnoAtualDTO.getIdTurno(), ompt.getIdPt(), ppcp, null);
		FolhaRN folhaRN = new FolhaRN(this.getDao());

		// Se nao existir entao pesquisar o ultimo dwrt do pt para servir como base para o proximo dwrt
		if (dwrtNoTurno == null) {
			log.info(idLog, identacao, "HEARTBEAT nao encontrou dwRtTurno-1");

			// Encontra o ultimo DwRt para servidr de base para o novo. Mas se houver alguma data errada na coleta pode ocorrer dwrts no futuro q
			//irao impactar o dwrt encontrado. Assim, comentei a linha abaixo e substitui por uma procurar do turno anterior
			//DwRt dwRtUltimo = this.getUltimoDwRt(ompt.getIdPt());
			DwRt dwRtUltimo = obtemDwRtParaHeartBeatJaSabendoTurnoSemInserirDwRt(
					log, 
					idLog, 
					identacao,
					oTurnoAtualDTO.getDtReferencia(), 
					oTurnoAtualDTO.getDwturno(), 
					ompt, 
					oTurnoAtualDTO,
					1);
					
			// se nao existe o ultimo dwrt eh pq nunca houve um evento para sua geracao,
			// nesse caso devemos criar um novo considerando q esta sem planejamento
			if (dwRtUltimo == null) {
				log.info(idLog, identacao, "HEARTBEAT nao encontrou dwRtTurno-2");

				/* Alessandre em 18-05-17 o metodo abaixo esta passando ompt.ppCp mas se o posto estiver sem op ele nao deve passar
				 * senao o heartbeat vai incluir um dwrt com a op anterior. Isso foi resolvido mais acima, ppcp sera null
				 */
				retorno = obtemDwRt(log, idLog, identacao, oTurnoAtualDTO, ompt, ppcp, /*dwFolha*/ null);
			} else {
				log.info(idLog, identacao, "HEARTBEAT encontrou dwRtTurno-2");
				//se existe um ultimo dwrt usa-lo como base para criar um novo dwrt para o turno corrente
				getDao().evict(dwRtUltimo);
				dwRtUltimo.setIdRtbase(dwRtUltimo.getIdRt());
				dwRtUltimo.setIdRt(0);
				dwRtUltimo.setDtReferencia(oTurnoAtualDTO.getDtReferencia());
				dwRtUltimo.setDwTurno(oTurnoAtualDTO.getDwturno());
				dwRtUltimo.setDthrCadastro(DataHoraRN.getDataHoraAtual());
				
				if (ompt.getIsSemop() != null && ompt.getIsSemop())
					dwRtUltimo.setPpCp(null);
				else if (ppcp != null)
					dwRtUltimo.setPpCp(ppcp);
				
				/*
				 * Obtem a ultima parada para o posto
				 */
				dwRtUltimo.setDwConsolpalog(crn.getUltimaParadaFromDwConsolpalog(ompt));
				
				dwRtUltimo = getDao().makePersistent(dwRtUltimo);
				
				retorno = dwRtUltimo;

				// Incluir tb o dwconsolid para permitir que o detalhe da maquina abra mesmo sem ter eventos (no caso a maquina esta parada)
				try {
					// Se nao existir uma ppCp nao tem como descobrir a folha nem incluir dwconsolid
					// Alessandre em 19-01-17 o obtemConsolidTurno abaixo estava criando um registro com referencia a op ja fechada
					// isso gerou a emissao de relatorio com uma op q nao estava mais em maquina
					// Assim o obtemIdTurno sera gerado apenas se tiver op no posto
					if (dwRtUltimo.getPpCp() != null && (   (ompt.getIsSemop() != null && ompt.getIsSemop() == false) || ompt.getIsSemop() == null) ) {
						final DwFolha dwFolha = folhaRN.getDwFolhaAtiva(dwRtUltimo.getPpCp());
						// Abaixo o dwRt eh passado para obtemConsolidTUrno pois dwrt acabou de ser incluido logo obtemConsoliTurno nao pode incluir novamente
						crn.obtemConsolIdTurno(log, idLog, ompt, dwRtUltimo.getPpCp(), dwFolha, oTurnoAtualDTO, dwPepro, dwRtUltimo);
						
						// Alessandre em 02-05-17 incluir tambem dwconsolid para a hora. Necessario para qdo a parada estiver em aberto o grafico de 
						// tendencia ser gerado
						crn.obtemConsolIdHora(ompt, dwRtUltimo.getPpCp(), dwFolha, dthrReferencia, oTurnoAtualDTO, dwPepro);
					}
				} catch (SemCalendarioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SemSGBDException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SemCicloPadraoException | NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			retorno = dwrtNoTurno;
			
			if (dwrtNoTurno.getPpCp() != null) {
				final DwFolha dwFolha = folhaRN.getDwFolhaAtiva(dwrtNoTurno.getPpCp());
				try {
					crn.obtemConsolIdHora(ompt, dwrtNoTurno.getPpCp(), dwFolha, dthrReferencia, oTurnoAtualDTO, dwPepro);
				} catch (SemCalendarioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SemSGBDException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SemCicloPadraoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return retorno;
	}

	/*
	 * Esse metodo eh usado para obter o ultimo dwrt no momento da copia para um novo dwrt durante o heartbeat
	 * O metodo pode ser chamado recursivamente ate encontrar um dwrt no turno anterior. Isso sera feito 5 vezes conforme controle
	 * de nroTentativaRecursividade
	 */
	private DwRt obtemDwRtParaHeartBeatJaSabendoTurnoSemInserirDwRt(IdwLogger log, int idLog, int identacao,
			Date dtReferencia, DwTurno dwturno, 
			OmPt ompt, 
			TurnoAtualDTO turnoAtual,
			int nroTentativaRecursividade){
		DwRt retorno = null;

		if (ompt.getPpCp() != null)
			log.info(idLog, identacao, "obtemDwRtParaHeartBeatJaSabendoTurnoSemInserirDwRt procurando para  ompt.idPt=" + 
				ompt.getIdPt() + 
				" dtreferencia=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtReferencia) + 
				" idturno=" + dwturno.getIdTurno() + 
				" ppcp=" + ompt.getPpCp().getIdCp());
		else
			log.info(idLog, identacao, "obtemDwRtParaHeartBeatJaSabendoTurnoSemInserirDwRt procurando para  ompt.idPt=" + 
					ompt.getIdPt() + 
					" dtreferencia=" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtReferencia) + 
					" idturno=" + dwturno.getIdTurno() );
			

		// Verifica se ja existe dwrt para o turno em questao
		PpCp ppcp = null;
		if (ompt.getIsSemop() == null || ompt.getIsSemop() == false)
			ppcp = ompt.getPpCp();
		
		retorno = this.getDwRt(dtReferencia, dwturno.getIdTurno(), ompt.getIdPt(), ppcp, null);
		
		/*
		 * Se nao existir, descobrir qual o turno anterior e utiliza-lo como referencia para procurar o ultimo dwrt. 
		 * Ocorreu um caso em que houve virada de turno, e foram gerados varios dtrt antigos e se utilizou um desses antigos como referencia
		 */
		if (retorno == null) {
			log.info(idLog, 0, "HEARTBEAT nao encontrou dwrt, procurando com turno anterior");
			TurnoRN rn = new TurnoRN(getDao());
			try {
				TurnoAtualDTO turnoAnterior = rn.getTurnoAnteriorDTOPassandoIdPtEDtTurnoEIdTurno(ompt, dtReferencia, dwturno.getIdTurno(), turnoAtual);
				log.info(idLog, identacao, "Turno anterior = " + turnoAnterior.toString());
				retorno = this.getDwRt(turnoAnterior.getDtReferencia(), turnoAnterior.getIdTurno(), ompt.getIdPt(), ppcp, null);
			} catch (SemCalendarioException e) {
				retorno = null;
			} catch (IllegalStateException e) {
				retorno = null;
			}
		}

		// Se nao existir entao pesquisar o ultimo dwrt do pt para servir como base para o proximo dwrt
		if (retorno == null) {
			log.info(idLog, identacao, "obtemDwRtParaHeartBeatJaSabendoTurnoSemInserirDwRt.getDwRt NAO ENCONTROU DWRT para copiarFlags");
			// Encontra o ultimo DwRt para servidr de base para o novo
			retorno = this.getUltimoDwRt(ompt.getIdPt());
		}

		
		// Se for vazio procura pelo ultimo dwrt sem considerar o OP, pois durante a troca da op eh necessario criar um dwrt uma unica vez
		if (retorno == null) {
			log.info(idLog, identacao, "obtemDwRtParaHeartBeatJaSabendoTurnoSemInserirDwRt.getUltimoDwRt NAO ENCONTROU DWRT para copiarFlags");
			retorno = getUltimoDwRtSemConsiderarOP(ompt.getIdPt());
		}
		if (retorno == null)
			log.info(idLog, identacao, "obtemDwRtParaHeartBeatJaSabendoTurnoSemInserirDwRt NAO ENCONTROU DWRT para copiarFlag");
		else
			log.info(idLog, identacao, "Encontrou dwrt.idRt = " + retorno.getIdRt());


		return retorno;
	}

	public DwRt obtemDwRt(IdwLogger log, int idLog, int identacao, TurnoAtualDTO turnoAtualDTO, OmPt omPt, PpCp ppCp, DwFolha dwFolha){
		// obtem o rt

		DwRt dwRt = this.getDwRt(turnoAtualDTO.getDtReferencia(), turnoAtualDTO.getIdTurno(), omPt.getIdPt(), ppCp, dwFolha);
		// se nao encontrar registro algum
		if(dwRt == null) {
			// inserir registro
			dwRt = this.insertDwRt(log, idLog, identacao, turnoAtualDTO, omPt, ppCp, dwFolha, new BigDecimal(0));
		}
		return dwRt;
	}

	public DwRt obtemDwRt(IdwLogger log, int idLog, int identacao, OmPt omPt, List<DwCalsem> dwCalsems, PpCp ppCp, Date dtHrRef, DwFolha dwFolha){

		// obtem a referencia do turno correspondente ao PT e hora do evento
		TurnoRN oTurnoRN = new TurnoRN(getDao());

		TurnoAtualDTO oTurnoAtualDTO = null;
		//oTurnoAtualDTO = oTurnoRN.obtemTurnoAtual(omPt.getIdPt(), dtHrRef, null, 0, 0, omcfg);
		oTurnoAtualDTO = oTurnoRN.getTurnoAtualDTO(dwCalsems, dtHrRef);

		return obtemDwRt(log, idLog, identacao, oTurnoAtualDTO, omPt, ppCp, dwFolha);

	}
	/**
	 * Pega DwRt
	 * @param dtReferencia
	 * @param idTurno
	 * @param idPt
	 * @param ppCp
	 * @param dwFolha
	 * @return
	 */
	public DwRt getDwRt(Date dtReferencia, Long idTurno, Long idPt, PpCp ppCp, DwFolha dwFolha) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT distinct dwrt ");
		q.append("FROM DwRt dwrt ");
		// alessandre: em 23-5-13 transformei o join abaixo para left join pois podemos
		//ter dwrt sem dwconsolid, isso ocorre no caso do pt estar sem planejamento
		q.append("left join dwrt.dwConsolids dwConsolid ");
		q.append("WHERE dwrt.dtReferencia = :dtReferencia ");
		q.append("AND dwrt.dwTurno.idTurno = :idTurno ");
		q.append("AND dwrt.omPt.idPt = :idPt ");
		if( ppCp != null){
			q.append("AND dwrt.ppCp.idCp = :idCp ");
		}
		if(dwFolha != null){
			q.append("AND dwConsolid.dwFolha.idFolha = :idFolha");
		}
		q.append("ORDER BY dwrt.dthrHeartbeat desc, dwrt.dthrEvento DESC, dwrt.idRt DESC");

		q.defineParametro("idTurno", idTurno);
		q.defineParametro("idPt", idPt);

		if(dwFolha != null){
			q.defineParametro("idFolha", dwFolha.getIdFolha());
		}

		if( ppCp != null){
			q.defineParametro("idCp", ppCp.getIdCp());
		}
		q.defineParametroData("dtReferencia", dtReferencia);

		q.setMaxResults(1);

		DwRt oDwRt = null;

		oDwRt = (DwRt) q.query().uniqueResult();
		q = null;

		return(oDwRt);
	}
	public DwRtcic getUltimoDwRtcic(Date dthr, OmPt ompt, PpCp ppcp) {
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("SELECT distinct dwRtcic ");
		q.append("FROM DwRtcic dwRtcic ");
		q.append("where dwRtcic.dthrFciclo = :dthr ");
		q.append("and dwRtcic.ppCp.idCp = :idCp");
		q.append("and dwRtcic.dwRt.omPt.idPt = :idPt");
		q.append("ORDER BY dwRtcic.dthrFciclo DESC");

		q.defineParametro("dthr", dthr);
		q.defineParametro("idCp", ppcp.getIdCp());
		q.defineParametro("idPt", ompt.getIdPt());

		q.setMaxResults(1);

		DwRtcic dwRtcic = (DwRtcic) q.query().uniqueResult();
		
		return dwRtcic;
		
	}
	
	public DwRt insertDwRt(IdwLogger log, int idLog, int identacao, TurnoAtualDTO oTurnoAtualDTO, PassagemDTO passagem, DwFolha oDwFolha) {
		// calculando tempo passado entre passagem.dthrultimoevento e passagem.dthrevento		
		long tempoEntreEventos = DataHoraRN.getQuantidadeSegundosNoPeriodoTrantandoNulo(passagem.getDtHrEventoAnterior(), passagem.getDtHrEvento());

		OmPt omPt = ((OmPt) this.getDao().getSession().get(OmPt.class, passagem.getIdPt()));

		return insertDwRt(log, idLog, identacao, oTurnoAtualDTO, omPt, null, oDwFolha, new BigDecimal(tempoEntreEventos));
	}

	/**
	 * Inclui novo DwRt
	 * @param oTurnoAtualDTO
	 * @param omPt
	 * @param ppCp
	 * @param dwFolha
	 * @param segUltimociclo
	 * @return
	 */
	private DwRt insertDwRt(IdwLogger log, int idLog, int identacao, TurnoAtualDTO oTurnoAtualDTO, OmPt omPt, PpCp ppCp, DwFolha dwFolha, BigDecimal segUltimociclo) {
		return insertDwRt(log, idLog, identacao, oTurnoAtualDTO.getDtReferencia(), oTurnoAtualDTO.getDwturno(), omPt, ppCp, dwFolha, segUltimociclo, oTurnoAtualDTO);
	}

	/**
	 * Inclui novo DwRt
	 * @param dtReferencia
	 * @param dwTurno
	 * @param omPt
	 * @param ppCp
	 * @param dwFolha
	 * @param segUltimociclo
	 * @return
	 */
	private DwRt insertDwRt(IdwLogger log, int idLog, int identacao, Date dtReferencia, DwTurno dwTurno, OmPt omPt, PpCp ppCp, DwFolha dwFolha, BigDecimal segUltimociclo, TurnoAtualDTO turnoAtual) {
		Validate.notNull(dtReferencia, "Data de referencia (dtReferencia) não informada, ao incluir um novo DwRtTurno");
		Validate.notNull(dwTurno, "Turno (DwTurno) não informado, ao incluir um novo DwRtTurno");
		Validate.notNull(omPt, "Posto de trabalho (OmPt) não informado, ao incluir um novo DwRtTurno");

		// Alessandre: comentei as duas linhas abaixo em 23-5-13 pois um dwrt pode estar sem planejamento
		//Validate.notNull(ppCp, "PpCp (PpCp) não informado, ao incluir um novo DwRtTurno");
		//Validate.notNull(dwFolha, "Folha (dwFolha) não informada, ao incluir um novo DwRtTurno");

		if(segUltimociclo == null){
			segUltimociclo = BigDecimal.ONE;
		}

		DwRt dwRt = new DwRt();

		dwRt.setDtReferencia(dtReferencia);
		dwRt.setDwTurno(dwTurno);

		dwRt.setDefaultValues();

		// se folha for null insere zero
		if(dwFolha != null && dwFolha.getSegCiclominimo() != null) {
			dwRt.setSegCiclopadraominimo(dwFolha.getSegCiclominimo());
		} else {
			dwRt.setSegCiclopadraominimo(new BigDecimal(0));
		}

		dwRt.setSegUltimociclo(segUltimociclo);

		if (ppCp != null) {
			dwRt.setPcsProducaoplanejadaOp(new BigDecimal(ppCp.getQtPecasProduzir()));
		} else {
			dwRt.setPcsProducaoplanejadaOp(null);
		}

		if (ppCp != null)
			dwRt.setPcsProducaoliquidaOp(new BigDecimal(ppCp.getProducaoBruta()));
		else
			dwRt.setPcsProducaoliquidaOp(BigDecimal.ONE);

		dwRt.setOmPt(omPt);
		dwRt.setPpCp(ppCp);

		// Copia dados do DwRt anterior para o mais recente
		DwRt dwrtAnterior = this.copiarFlagsUltimoDwRt(log, idLog, identacao, dtReferencia, dwTurno, omPt, dwRt, turnoAtual);
		// Se a op do dwrtAnterior for diferente da op do dwrt que esta sendo salvo, entao limpar a ultima parada
		if (
				dwrtAnterior != null && dwRt != null &&
				dwrtAnterior.getPpCp() != null &&  dwRt.getPpCp() != null &&
				dwrtAnterior.getPpCp().getIdCp().equals(dwRt.getPpCp().getIdCp()) == false) {
			dwRt.setDwConsolpalog(null);
		}
		
		dwRt.setIdRt(0l);
		dwRt.setDthrCadastro(DataHoraRN.getDataHoraAtual());

		// Verificar se existem operadores logados
		ConsolidaRN crn = new ConsolidaRN(getDao());
		List<DwConsolmolog> lopera = crn.getDwConsolmologComLoginAberto(omPt.getIdPt());
		if (lopera.size() > 0)
			dwRt.setIsOperador(true);
		else
			dwRt.setIsOperador(false);

		// Alessadnre: se o ppcp passado for null entao setar como semplanejamento
		if (ppCp == null){
			log.info(idLog, identacao, "isSemplanejamento true em insertDwRt pois ppCp is null");
			dwRt.setIsSemplanejamento(true);
		}

		// Salva o novo DwRt
		getDao().makePersistent(dwRt);
		log.info(idLog, identacao, "Inserido idRt = " + dwRt.getIdRt() + " com dthrHeartbeat = " + DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwRt.getDthrHeartbeat()));
		//Alexandre 18/05/2016 - Retirei o new Exception da linha abaixo que estava poluindo o log com o getMessage() dele que nao significa nada.
		if (dwRt.getPpCp() != null) {
			log.info(idLog, identacao, "Com CP = " + dwRt.getPpCp().getCdCp()); //, new Exception());
		}

		return(dwRt);

	}

	/**
	 * Copiar dados do DwRt anterior para o novo
	 * @param idPt
	 * @param dwRt
	 */
	private DwRt copiarFlagsUltimoDwRt(IdwLogger log, int idLog, int identacao, Date dthrReferencia, DwTurno dwturno, OmPt ompt, DwRt dwRt, TurnoAtualDTO turnoAtual){
		DwRt dwRtAnterior = null;
		if(dwRt != null){
			dwRtAnterior = this.obtemDwRtParaHeartBeatJaSabendoTurnoSemInserirDwRt(
					log, 
					idLog, 
					identacao,
					dthrReferencia, 
					dwturno, 
					ompt, 
					turnoAtual,
					1);
			if (dwRtAnterior != null){
				this.copiarFlagsDwRt(dwRtAnterior, dwRt);
			} else {
				log.info(idLog, 0, "IsSemplanejamento = true em copiarFlagsUltimoDwrt para turno " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrReferencia) + " turno = " + dwturno.getIdTurno());
				dwRt.setIsSemplanejamento(true);
			}
		}
		return dwRtAnterior;
	}

	/**
	 * Copiar flags do periodo anterior para o atual
	 * @param dwRtOrigem
	 * @param dwRtDestino
	 */
	private void copiarFlagsDwRt(DwRt dwRtOrigem, DwRt dwRtDestino){
		Validate.notNull(dwRtOrigem, "dwRtOrigem nao pode ser nulo");
		Validate.notNull(dwRtDestino, "dwRtDestino nao pode ser nulo");

//		System.out.println("copiando isAlerta " + dwRtOrigem.getIsAlerta() + " de dwRtOrigem.id=" + dwRtOrigem.getIdRt() + " para o destino id=" + dwRtDestino.getIdRt());
		dwRtDestino.setIsAlerta(dwRtOrigem.getIsAlerta());
		dwRtDestino.setIsCip(dwRtOrigem.getIsCip());
		dwRtDestino.setIsConforme(dwRtOrigem.getIsConforme());
		dwRtDestino.setIsManutencaopre(dwRtOrigem.getIsManutencaopre());
		dwRtDestino.setIsOperador(dwRtOrigem.getIsOperador());
		dwRtDestino.setIsParadafechaciclo(dwRtOrigem.getIsParadafechaciclo());
		dwRtDestino.setIsParadapeso(dwRtOrigem.getIsParadapeso());
		dwRtDestino.setIsRegulagem(dwRtOrigem.getIsRegulagem());
		dwRtDestino.setIsSemplanejamento(dwRtOrigem.getIsSemplanejamento());
		dwRtDestino.setIsVidautilmolde(dwRtOrigem.getIsVidautilmolde());
		dwRtDestino.setDwConsolpalog(dwRtOrigem.getDwConsolpalog());
		dwRtDestino.setIsOffline(dwRtOrigem.getIsOffline());
		dwRtDestino.setDthrHeartbeat(dwRtOrigem.getDthrHeartbeat());

		// Alessandre emm 15-07-15 Coloquei pra copiar tb o stFuncionamento pois nao virada do turno com maquina parada nao estava parando
		dwRtDestino.setStFuncionamento(dwRtOrigem.getStFuncionamento());
	}

	public DwRt getUltimoDwRtSemConsiderarOP(Long idPt) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT dwrt ");
		q.append("FROM DwRt dwrt ");
		q.append("where dwrt.omPt.idPt = :idPt ");
		q.append("ORDER BY dwrt.dthrHeartbeat desc, dwrt.dthrEvento DESC, dwrt.idRt DESC");

		q.defineParametro("idPt", idPt);
		q.setMaxResults(1);

		DwRt oDwRt = null;
		oDwRt = (DwRt) q.query().uniqueResult();
		q = null;
		return(oDwRt);
	}
	public DwRt getUltimoDwRt(Long idPt) {
		MapQuery q = new MapQuery(this.getDao().getSession());
		OmPt ompt = getDao().findById(OmPt.class, idPt, false);

		q.append("SELECT dwrt ");
		q.append("FROM DwRt dwrt ");
		q.append("left join fetch dwrt.ppCp ppcp");
		q.append("where dwrt.omPt.idPt = :idPt ");
		if (ompt != null && ompt.getPpCp() != null)
			q.append("and dwrt.ppCp = :ppcp");
		
		q.append("ORDER BY dwrt.dthrHeartbeat desc, dwrt.dthrEvento DESC, dwrt.dtReferencia desc, dwrt.idRt DESC");

		q.defineParametro("idPt", idPt);
		
		if (ompt != null && ompt.getPpCp() != null)
			q.defineParametro("ppcp", ompt.getPpCp());

		q.setMaxResults(1);

		DwRt oDwRt = null;
		oDwRt = (DwRt) q.query().uniqueResult();
		q = null;
		return(oDwRt);
	}
	
	/**
	 * Guardar data/hora do evento consolidado em DwRt <br>
	 * Atualiza os campos de DwRt: <br>
	 * * dthrHeartBeat, dependendo do estado da {@link DwRt#IS_ATUALIZAR_DTHR_HEART_BEAT_BASEADO_EVENTOS}, ainda em estudo se vai gravar lá ou não. <br>
	 * * dthrEvento 
	 * @see DwRt#getDthrEvento() 
	 * @param dwRt
	 * @param dthr
	 */
	public static void setDthrEmDwRtBaseadoNosEventos(DwRt dwRt, Date dthr) {
		if (dwRt != null) {
			if (IS_ATUALIZAR_DTHR_HEART_BEAT_BASEADO_EVENTOS) {			
				dwRt.setDthrHeartbeat(DataHoraRN.getMaiorData(dthr, dwRt.getDthrHeartbeat()));
			}
			dwRt.setDthrEvento(DataHoraRN.getMaiorData(dthr, dwRt.getDthrEvento()));
		}
		
	}
	
	public static boolean isDthrDentroInicioFimTurno(DwRt dwRt, Date dthr) {
		boolean resultado = false;
		if (dwRt != null) {
			if (dwRt.getDwConsolids() != null) {
				for (DwConsolid dwConsolid : dwRt.getDwConsolids()) {
					resultado =  DataHoraRN.compareTo(dwConsolid.getDthrIturno(), dthr) <= 0 
							&& DataHoraRN.compareTo(dwConsolid.getDthrFturno(), dthr) >= 0;					
				}
			}
		}
		return resultado;		
	}
	
	public DwRt getUltimoDwRtByCdCp(String cdcp) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT dwrt ");
		q.append("FROM DwRt dwrt ");
		q.append("join fetch dwrt.ppCp ppcp");
		q.append("where ppcp.cdCp = :cdcp ");
		q.append("ORDER BY dwrt.dthrHeartbeat desc, dwrt.dthrEvento DESC, dwrt.dtReferencia desc, dwrt.idRt DESC");

		q.defineParametro("cdcp", cdcp);

		q.setMaxResults(1);

		DwRt oDwRt = null;
		oDwRt = (DwRt) q.query().uniqueResult();
		q = null;
		return(oDwRt);
	}



	public DwRt getUltimoDwRtByIdCp(Long idcp) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT dwrt ");
		q.append("FROM DwRt dwrt ");
		q.append("join fetch dwrt.ppCp ppcp");
		q.append("where ppcp.idCp = :idcp ");
		q.append("ORDER BY dwrt.dthrHeartbeat desc, dwrt.dthrEvento DESC, dwrt.dtReferencia desc, dwrt.idRt DESC");

		q.defineParametro("idcp", idcp);

		q.setMaxResults(1);

		DwRt oDwRt = null;
		oDwRt = (DwRt) q.query().uniqueResult();
		q = null;
		return(oDwRt);
	}
}
