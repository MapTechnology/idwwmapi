package injetws.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.IjcfgIntat;
import idw.model.pojos.injet.Ijcfgandmaqevt;
import idw.model.pojos.injet.Ijcfgandmaqevtarg;
import idw.model.pojos.injet.Ijcfgdiariobrdqld;
import idw.model.pojos.injet.Ijdrivercent;
import idw.model.pojos.injet.Ijgrpparaminspxord;
import idw.model.pojos.injet.Ijprotempolimdbqld;
import idw.model.pojos.injet.Ijreaaptpesomedio;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.Ijtbproembalagem;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.pojos.injet.Ijtbvarritmo;
import idw.model.rn.DataHoraRN;
import idw.model.rn.pdba.AlertaPdbaMsEvtRN;
import idw.model.rn.pdba.ParadaPdbaMsEvtRN;
import idw.model.rn.pdba.ProducaoPdbaMsEvtRN;
import idw.util.IdwLogger;
import injetws.model.excessoes.MestreOfflineException;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrBridgeCollectorDatabase;
import injetws.model.pojos.PrColetor;
import injetws.model.pojos.PrColetorEventos;
import injetws.model.pojos.PrConexoesInjet;
import injetws.model.pojos.PrEventosBridgeCollecDb;
import injetws.model.pojos.PrProUsu;
import injetws.model.pojos.PrSubColetor;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpAndon;
import injetws.model.pojos.PrUpAndonAlertaInspecao;
import injetws.model.pojos.PrUpAndonArg;
import injetws.model.pojos.PrUpAndonArgId;
import injetws.model.pojos.PrUpAndonId;
import injetws.model.pojos.PrUpAndonIndicadores;
import injetws.model.pojos.PrUpAndonPrcsft;
import injetws.model.pojos.PrUpAndonPrcsftConfig;
import injetws.model.pojos.PrUpAndonResultUltimaInsp;
import injetws.model.pojos.PrUpConfiguracoes;
import injetws.model.pojos.PrUpCtrlEventosLoginout;
import injetws.model.pojos.PrUpCtrlInicioProcesso;
import injetws.model.pojos.PrUpDadosBc;
import injetws.model.pojos.PrUpDnc;
import injetws.model.pojos.PrUpDncConfiguracoes;
import injetws.model.pojos.PrUpExecinspecao;
import injetws.model.pojos.PrUpLoginsEmAberto;
import injetws.model.pojos.PrUpProduto;
import injetws.model.pojos.PrUpProdutoMatPrima;
import injetws.model.pojos.PrUpProdutoMatPrimaUsada;
import injetws.model.pojos.PrUpProdutoValidacao;
import injetws.model.pojos.PrUpUltimaParada;
import injetws.model.pojos.PrUpUltimaVariacaoRitmo;
import injetws.model.pojos.PrUpVariacaoRitmoPend;
import injetws.model.rn.injet.InjetAlertaRN;
import injetws.model.rn.injet.InjetInfoRN;
import injetws.model.rn.injet.InjetModRN;
import injetws.model.rn.injet.InjetParadaRN;
import injetws.model.rn.injet.InjetRefugoRN;
import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsAndonArgsDTO;
import injetws.webservices.dto.IwsAndonDTO;
import injetws.webservices.dto.IwsAndonIndicadoresDTO;
import injetws.webservices.dto.IwsAndonReleDTO;
import injetws.webservices.dto.IwsAutenticacaoDTO;
import injetws.webservices.dto.IwsComplementaOP;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.webservices.dto.IwsDadosBCDTO;
import injetws.webservices.dto.IwsDadosCIPDTO;
import injetws.webservices.dto.IwsDadosIHMBalancaDTO;
import injetws.webservices.dto.IwsDadosInspDTO;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsInspecaoAutoDTO;
import injetws.webservices.dto.IwsInspecaoManualDTO;
import injetws.webservices.dto.IwsListModDTO;
import injetws.webservices.dto.IwsListaInspecoesAutoDTO;
import injetws.webservices.dto.IwsListaUpDTO;
import injetws.webservices.dto.IwsModDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;
import injetws.webservices.dto.IwsProdutoDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsReleDTO;
import injetws.webservices.dto.IwsUpAndonPrcsftDTO;
import injetws.webservices.dto.IwsUpDTO;
import injetws.webservices.dto.IwsVariacaoRitmoDTO;
import injetws.webservices.dto.IwsVariacaoRitmoValidaDTO;
import injetws.webservices.dto.MoldeEstruturaDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dao.AbstractPdbaInjetDAO;
import ms.model.dto.IcUpDTO;
import ms.model.rn.UsuarioMSRN;

@SuppressWarnings("unchecked")
public class InfoRN extends AbstractPdbaInjetDAO {

	/* Alessandre: em 20-8-14 criei o construtor para poder chamar InfoRN via heartbeat do MS afim de obter os dados do CIP sem ter a conexao com o injet
	 * 
	 */
	public InfoRN(DAOGenerico daoPdba) {
		Validate.notNull(daoPdba);
		this.setDaoPdba(daoPdba);
	}
	public InfoRN(DAOGenericoInjet daoInjet, DAOGenerico daoPdba) {
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);

		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}

	public static void main(String args[]) {
	}

	public Date obtemDataHoraAtual() {
		return DataHoraRN.getDataHoraAtual(this.getDaoPdba());
	}

	private void verificaSeFinalizaCicloAoInicializar(IdwLogger log, int idLog, PrUp prup, Date dthrEvento) throws ServicoFalhouException {
		// Ciclo deve ser finalizado? => PR_UP (DthrAtualMs -
		// Pr_Up.DtHrIniCicloMs) >= (Pr_Up.TmpCicloPadrao *
		// Pr_Up.cfgPercTmpCicloIni)
		// Se SIM Fecha Ciclo, com Data/Hora ultimo acesso ao banco
		PrUpUltimaParada oPrUpUltimaParada = null;
		if (dthrEvento == null)
			return;
		
		if (prup.getDthrinicicComMilisegundos() != null && prup.getTmpciclopadrao() != null && prup.getCfgperctmpcicloinicializacao() != null) {

			Double referenciaTmpCiclo = ((prup.getTmpciclopadrao() * prup.getCfgperctmpcicloinicializacao()) * 10) + (prup.getTmpcicloparcial() * 1000);
			Date dthrFecharCiclo = DataHoraRN.somaMiliSegundos(prup.getDthrinicicComMilisegundos(), referenciaTmpCiclo.intValue());
			
			if (prup.getStparadaemaberto() != null && prup.getStparadaemaberto() == '1' && prup.getCdultimaparada() != null && !prup.getCdultimaparada().equals("999999")) {
				oPrUpUltimaParada = new PrUpUltimaParada();
				oPrUpUltimaParada = pesquisaPrup_ultimaparada(log, idLog, prup);
			}
			
			System.out.println(
					" dthrFecharCiclo=" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dthrFecharCiclo) + 
					" dthrEvento:" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dthrEvento) + 
					" prup.dthrinicicCiclo:" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(prup.getDthrinicicComMilisegundos()) + 
					" iguais=" + dthrFecharCiclo.before(dthrEvento) +
					" outroigual=" + DataHoraRN.before(dthrFecharCiclo, dthrEvento));
			if (dthrFecharCiclo.before(dthrEvento)) {
				// se a maquina possuir configuracao de parada NAO fecha ciclo
				// ou tamanho do pacote de ciclos for mais que 1
				if (    (prup.getCfginterrupcaociclo() != null && prup.getCfginterrupcaociclo().equals('2')) || 
						(prup.getCfgtamanhoumpacoteciclos() != null && prup.getCfgtamanhoumpacoteciclos().doubleValue() > 1d)) {
					
					// fechar parada em aberto apenas se o ciclo de
					// inicializacaoo for lancado

					if (prup.getDthriniultimaparada() != null && dthrFecharCiclo.compareTo(prup.getDthriniultimaparada()) <= 0) {
						dthrFecharCiclo = DataHoraRN.somaSegundos(prup.getDthriniultimaparada(), 1);
					}
					
					if (prup.getStparadaemaberto() != null
							&& prup.getStparadaemaberto() == '1'
							&& ((oPrUpUltimaParada != null
							&& oPrUpUltimaParada.getisParadaRegulagem() != null && oPrUpUltimaParada
							.getisParadaRegulagem().equals('0')) || (prup
									.getCdultimaparada() != null && prup
									.getCdultimaparada().equals("999999")))) {

						prup.mudaDtHrUltimoHeartBeat(dthrFecharCiclo);
						prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(dthrFecharCiclo));
						fecharParada(log, idLog, prup);
						prup.setStparadaemaberto('0');
					}
				}
				
				/* Alessandre em 13-12-17 um problema na Ipackem com leitura de CB com configuracao
				 * do grau de liberdade. Nessa situacao qdo o clp eh resetado o ciclo abaixo eh lancado
				 * e não deveria pois apenas com a leitura seria eh q o evento 7 deve ser lancado
				 * Vou utilizar o CFG que determina se a parada fecha ciclo. Se nao fechar vou entender que 
				 * nao devo lancar o ciclo na inicializacao
				 */
				if (prup.getCfginterrupcaociclo() == null || prup.getCfginterrupcaociclo().equals('2') == false) {
					if (prup.getStparadaemaberto() != null
							&& prup.getStparadaemaberto() == '1'
							&& prup.getCdultimaparada() != null
							&& !prup.getCdultimaparada().equals("")
							&& !prup.getCdultimaparada().equals("999999")
							&& oPrUpUltimaParada != null
							&& oPrUpUltimaParada.getisParadaRegulagem() == '1') {
						log.info(idLog, 0, "chamando fecharCiclo a partir de veriricaSeFinalizaCicloAoINicializar");
						fecharCiclo(log, idLog, prup, dthrFecharCiclo, prup.getCfgtamanhoumpacoteciclos().intValue(), true, false, "INICIALIZACAO");
					} else {
						log.info(idLog, 0, "chamando fecharCiclo a partir de veriricaSeFinalizaCicloAoINicializar no else");
						fecharCiclo(log, idLog, prup, dthrFecharCiclo, prup.getCfgtamanhoumpacoteciclos().intValue(), false, false, "INICIALIZACAO");
					}
					// alterado by /Senoj para fechar ciclo sempre com tempo
					// positivo, e limpar DThriniciociclo
					prup.setDthrinicic(null); // by Senoj 2010 05 26
					prup.setMsdthrinicic(0d);
					// Adicionado para tratamaneto de tempo de espera by Senoj
					prup.setDthrfimcic(null);
					prup.setMsdthrfimcic(0d);
					prup.setStcicloemaberto('0');
					prup.mudaDtHrUltimoHeartBeat(dthrFecharCiclo);
					getDaoPdba().makePersistent(prup);
				}
				this.getDaoPdba().flushReiniciandoTransacao();
			}
		}

	}

	public IwsListaUpDTO inicializacaoColetaDiscreta(IdwLogger log, int idLog, String mac) throws SemSGBDException, ServicoFalhouException {
		IwsListaUpDTO listaUpDTO = new IwsListaUpDTO();

		// Obtem a lista de UPs
		List<PrUp> prups = null;
		try {
			prups = getPrUpsColetaDiscreta(mac);
		} catch (SemSGBDException e) {
			listaUpDTO.setIsSGBDOnline(false);
			return listaUpDTO;
		}

		// Obtem o intervalo do ultimo heart-beat
		try {
			listaUpDTO.setDthrUltimoBeatColetor(getUpBeat(mac));
		} catch (RegistroDesconhecidoException e) {
			// N�o conseguiu obter o valor do ultimo heartbeat, assumir
			// data e
			// hora atual
			listaUpDTO.setDthrUltimoBeatColetor(DataHoraRN
					.getDataHoraAtual(this.getDaoPdba()));
		} catch (SemSGBDException e) {
			listaUpDTO.setIsSGBDOnline(false);

			return listaUpDTO;
		}

		for (PrUp prup : prups) {
			// Atualiza em prup o ultimo heart beat do coletor
			prup.mudaDtHrUltimoHeartBeat(listaUpDTO.getDthrUltimoBeatColetor());
			prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(listaUpDTO.getDthrUltimoBeatColetor()));
			prup.mudaIsInjOuLiner(isMaquinaINJouLINER(prup.getCdmaquina()).getSucesso());
			/*
			 * Rejeitar eventos que o mestre enviou no intervalo em que o
			 * coletor esteve offline onde PR_EVENTOS_BRIDGE_COLLEC_DB.TpEvento:
			 * 2,3 e 6
			 */

			Date dthrEvento = DataHoraRN.getDataHoraAtual(this.getDaoPdba());

			String hql = "";

			hql += "update PrEventosBridgeCollecDb preventos ";
			hql += "set preventos.stevento = '2', ";
			hql += "preventos.inf20 = '::dtatual', ";
			hql += "preventos.inf19 = '::idup' ";
			hql += "where preventos.stevento = '0' and preventos.tpevento in (1, 2, 3, 5, 6, 8, 20) ";
			hql += "and preventos.prUp.idup = '::idup' ";

			hql = hql.replaceAll("::idup", prup.getIdup().toString());
			hql = hql.replaceAll("::dtatual", dthrEvento.toString());

			Query q = this.getDaoPdba().getSession().createQuery(hql);

			q.executeUpdate();

			/* Alessandre em 06-02-2015 removi a alteracao de prup pois nao eh necessario e esta impactando no lancamento dos ciclos qdo
			 * o idw est� ativo
			// PR_UP.StAguardRespMasterBridgeDB = �0�
			hql = "";
			hql += "update PrUp prup ";
			hql += "set prup.staguardrespmasterbridgecldb = '0' ";
			hql += "where prup.idup = '::idup' ";

			hql = hql.replaceAll("::idup", prup.getIdup().toString());

			q = this.getDaoPdba().getSession().createQuery(hql);

			q.executeUpdate();

			this.getDaoPdba().flushReiniciandoTransacao();
			 */

			// Trata UP corrente do loop
			// Lan�ar Evento de Inicializa��o
			// PR_COLETOR_EVENTOS
			// DtHr1Evento = momento da inicializa��o
			// msDtHr1Evento = momento da inicializa��o
			// DtHr2Evento = DtHr1Evento
			// msDtHr2Evento = msDtHr1Evento
			// IdUP
			// StEvento = 0

			verificaSeFinalizaCicloAoInicializar(log, idLog, prup, dthrEvento);

			prup.mudaDtHrReferenciaParaEventos(dthrEvento);

			PrColetorEventos prcoletoreventos = new PrColetorEventos();
			prcoletoreventos.setTpevento(new BigDecimal(1));
			prcoletoreventos.setDthr1evento(dthrEvento);
			prcoletoreventos.setMsdthr1evento(DataHoraRN
					.getApenasMilisegundos(dthrEvento));
			prcoletoreventos.setDthr2evento(dthrEvento);
			prcoletoreventos.setMsdthr2evento(DataHoraRN
					.getApenasMilisegundos(dthrEvento));
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setPrUp(prup);
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);

			// Tem NrOP para a UP?
			// Se nao, seta flag para a up informando que nao tem OP carregada e
			// que o coletor
			// deve entrar no processo de pedir os dados de Op (molde, etc)
			// Passar para a proxima Up do coletor
			if (isUpTemOPCarregada(prup) == false) {
				prup.mudaSemPrograma(true);
				listaUpDTO.addPrUp(prup);
				continue; // proxima up
			}
			// Se sim PLANEJAMENTO EM EXECUCAO
			IwsCpDTO isFinalizouPlanejamento = planejamentoEmExecucao(log, idLog, prup, 1d);

			if (isFinalizouPlanejamento.getPlanClose() == true) {
				prup.mudaSemPrograma(true);
				listaUpDTO.addPrUp(prup);
				continue; // proxima up
			}
			prup.mudaSemPrograma(false);
			// Parada em aberto?
			prup.mudaParadaEmAberto(isParadaEmAberto(prup));

			verificaStatusVariacaoRitmo(prup);
			verificaIsComCIP(log, idLog, prup);
			prup.mudaDadosBC(obtemDadosPrUpDadosBC(prup.getIdup()));
			listaUpDTO.addFullPrUp(log, idLog, prup, null, getDaoInjet(), this.getDaoPdba());

			// Gera evento 98 informando que a inicializa��o finalizou
			PrColetorEventos prcoletoreventosFinal = new PrColetorEventos();
			prcoletoreventosFinal.setTpevento(new BigDecimal(98));
			prcoletoreventosFinal.setStevento("3");
			prcoletoreventosFinal.setDthr1evento(dthrEvento);
			prcoletoreventosFinal.setMsdthr1evento(DataHoraRN
					.getApenasMilisegundos(prcoletoreventosFinal
							.getDthr1evento()));
			prcoletoreventosFinal.setDthr2evento(prcoletoreventosFinal
					.getDthr1evento());
			prcoletoreventosFinal.setMsdthr2evento(DataHoraRN
					.getApenasMilisegundos(prcoletoreventosFinal
							.getDthr1evento()));
			prcoletoreventosFinal.setNrop(prup.getNrop());
			prcoletoreventosFinal.setCdestrutura(prup.getCdestrutura());
			prcoletoreventosFinal.setCdmolde(prup.getCdmolde());
			prcoletoreventosFinal.setDthriniplanejada(prup
					.getDthriniplanejada());
			prcoletoreventosFinal.setPrUp(prup);
			prcoletoreventosFinal.setInf20(dthrEvento.toString());
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventosFinal, false);
		}

		return listaUpDTO;
	}

	private void VerificaIsEmRegulagem(IdwLogger log, int idLog, PrUp prup) {
		InjetParadaRN paradaRN = new InjetParadaRN(this.getDaoInjet(), this.getDaoPdba());

		IwsParadaDTO oParadaDTO = new IwsParadaDTO();
		try {
			oParadaDTO = paradaRN.getTr_TabParadaSetaCod(log, idLog, prup.getIdup()
					.toString(), prup.getCdultimaparada());
			if (prup.getStparadaemaberto() != null
					&& prup.getStparadaemaberto() == '1') {
				prup.mudaIsEmRegulagem(oParadaDTO.getIsRegulagem());
			} else {
				prup.mudaIsEmRegulagem(false);
			}
		} catch (RegistroDesconhecidoException e) {
			prup.mudaIsEmRegulagem(false);
		}
	}

	private boolean verificaStatusAndonConfig(PrUp prup) {

		boolean retorno = false;

		try {
			retorno = getStatusPrUpAndon(prup.getIdup().toString(), false);
		} catch (SemSGBDException e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;

	}

	private boolean verificaStatusAndonPrcsft(PrUp prup) {

		boolean retorno = false;

		try {
			retorno = getStatusPrUpAndon(prup.getIdup().toString(), true);
		} catch (SemSGBDException e) {
			e.printStackTrace();
			retorno = false;
		}
		return retorno;

	}

	public IwsListaUpDTO inicializacaoSemEvento(IdwLogger log, int idLog, String mac) throws SemSGBDException {
		IwsListaUpDTO listaUpDTO = new IwsListaUpDTO();

		log.info(idLog, 0, "chamando verificaEventoDesativacao");
		// Verifica evento 18 de ativacao de UP para esse coletor
		try {
			verificaEventoDesativacao(log, idLog, mac);
		} catch (ServicoFalhouException e1) {
			throw new SemSGBDException();
		}
		log.info(idLog, 0, "FIM - chamando verificaEventoDesativacao");

		log.info(idLog, 0, "chamando verificaAtualizacoes");
		verificaAtualizacoes(log, idLog, mac);
		log.info(idLog, 0, "FIM - chamando verificaAtualizacoes");

		log.info(idLog, 0, "Flush em prup");
		this.getDaoPdba().flushReiniciandoTransacao();

		// Obtem a lista de UPs
		List<PrUp> prups = null;

		try {
			prups = getPrUps(log, idLog, mac);
		} catch (SemSGBDException e) {
			listaUpDTO.setIsSGBDOnline(false);
			log.info(idLog, 0, "retornando pois semsgbdexception");
			return listaUpDTO;
		}

		// Obtem o intervalo do ultimo heart-beat
		try {
			listaUpDTO.setDthrUltimoBeatColetor(getUpBeat(mac));
		} catch (RegistroDesconhecidoException e) {
			// N�o conseguiu obter o valor do ultimo heartbeat, assumir
			// data e
			// hora atual
			listaUpDTO.setDthrUltimoBeatColetor(DataHoraRN.getDataHoraAtual(this.getDaoPdba()));
		} catch (SemSGBDException e) {
			listaUpDTO.setIsSGBDOnline(false);
			return listaUpDTO;
		}

		for (PrUp prup : prups) {
			log.info(idLog, 0, "varrendo prup = " + prup.getIdup());
			// Atualiza em prup o ultimo heart beat do coletor
			prup.mudaDtHrUltimoHeartBeat(listaUpDTO.getDthrUltimoBeatColetor());
			prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(listaUpDTO.getDthrUltimoBeatColetor()));
			prup.mudaIsInjOuLiner(isMaquinaINJouLINER(prup.getCdmaquina()).getSucesso());

			/* Alessandre em 06-02-2015 removi a alteracao de prup pois nao eh necessario e esta impactando no lancamento dos ciclos qdo
			 * o idw est� ativo

			String hql = "";
			// PR_UP.StAguardRespMasterBridgeDB = �0�
			hql = "";
			hql += "update PrUp prup ";
			hql += "set prup.staguardrespmasterbridgecldb = '0' ";
			hql += "where prup.idup = '::idup' ";

			hql = hql.replaceAll("::idup", prup.getIdup().toString());

			Query q = this.getDaoPdba().getSession().createQuery(hql);

			q.executeUpdate();

			this.getDaoPdba().flushReiniciandoTransacao();
			 */
			
			verificaStatusVariacaoRitmo(prup);
			verificaIsComCIP(log, idLog, prup);
			prup.mudaDadosBC(obtemDadosPrUpDadosBC(prup.getIdup()));
			try {
				prup.mudaIsAlertaProbQuali(setTr_buscaAleraProbQuali(prup.getCdmaquina())); 																			// 20100322
			} catch (SemSGBDException e) {
				log.info("excessao", e);
				e.printStackTrace();
				prup.mudaIsAlertaProbQuali(false);
			}	
			VerificaIsEmRegulagem(log, idLog, prup);
			listaUpDTO.setStAndonConfiguravel(verificaStatusAndonConfig(prup));
			listaUpDTO.setStAndonProcessoft(verificaStatusAndonPrcsft(prup));
			listaUpDTO.addFullPrUp(log, idLog, prup, getTr_ListaDadosAndon(log, idLog, prup),getDaoInjet(), this.getDaoPdba()); 
			
			getDaoPdba().evict(prup);
		}

		return (listaUpDTO);
	}

	public IwsListaUpDTO inicializacao(IdwLogger log, int idLog, String mac, boolean comParadaSemConexao,
			boolean comParadaDefault, Date dthrEvento) throws SemSGBDException, ServicoFalhouException {
		IwsListaUpDTO listaUpDTO = new IwsListaUpDTO();

		// Obtem a lista de UPs
		List<PrUp> prups = null;
		if (dthrEvento == null)
			dthrEvento = DataHoraRN.getDataHoraAtual(this.getDaoPdba());

		try {
			prups = getPrUps(log, idLog, mac);
		} catch (SemSGBDException e) {
			listaUpDTO.setIsSGBDOnline(false);
			return listaUpDTO;
		}

		// Obtem o intervalo do ultimo heart-beat
		try {
			listaUpDTO.setDthrUltimoBeatColetor(getUpBeat(mac));
		} catch (RegistroDesconhecidoException e) {
			// N�o conseguiu obter o valor do ultimo heartbeat, assumir data e
			// hora atual
			listaUpDTO.setDthrUltimoBeatColetor(dthrEvento);
		} catch (SemSGBDException e) {
			listaUpDTO.setIsSGBDOnline(false);
			return listaUpDTO;
		}

		for (PrUp prup : prups) {
			// Atualiza em prup o ultimo heart beat do coletor
			prup.mudaDtHrUltimoHeartBeat(listaUpDTO.getDthrUltimoBeatColetor());
			prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(listaUpDTO.getDthrUltimoBeatColetor()));
			prup.mudaSemPrograma(false);
			prup.mudaIsInjOuLiner(isMaquinaINJouLINER(prup.getCdmaquina()).getSucesso());

			/*
			 * Rejeitar eventos que o mestre enviou no intervalo em que o
			 * coletor esteve offline onde PR_EVENTOS_BRIDGE_COLLEC_DB.TpEvento:
			 * 2,3 e 6
			 */

			String hql = "";

			hql += "update PrEventosBridgeCollecDb preventos ";
			hql += "set preventos.stevento = '2', ";
			hql += "preventos.inf20 = '::dtatual', ";
			hql += "preventos.inf19 = '::idup' ";
			hql += "where preventos.stevento = '0' and preventos.tpevento in (1, 2, 3, 6, 8, 20) ";// Senoj
			// removido
			// o
			// evento
			// 5
			hql += "and preventos.prUp.idup = '::idup' ";

			hql = hql.replaceAll("::idup", prup.getIdup().toString());
			hql = hql.replaceAll("::dtatual", dthrEvento.toString());

			Query q = this.getDaoPdba().getSession().createQuery(hql);

			q.executeUpdate();

			this.getDaoPdba().flushReiniciandoTransacao();
			/* Alessandre em 06-02-2015 removi a alteracao de prup pois nao eh necessario e esta impactando no lancamento dos ciclos qdo
			 * o idw est� ativo

			try {
				// PR_UP.StAguardRespMasterBridgeDB = �0�
				hql = "";
				hql += "update PrUp prup ";
				hql += "set prup.staguardrespmasterbridgecldb = '0' ";
				hql += "where prup.idup = '::idup' ";

				hql = hql.replaceAll("::idup", prup.getIdup().toString());

				q = this.getDaoPdba().getSession().createQuery(hql);

				q.executeUpdate();
				this.getDaoPdba().flushReiniciandoTransacao();
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/

			// Trata UP corrente do loop
			// Lan�ar Evento de Inicializa��o
			// PR_COLETOR_EVENTOS
			// DtHr1Evento = momento da inicializa��o
			// msDtHr1Evento = momento da inicializa��o
			// DtHr2Evento = DtHr1Evento
			// msDtHr2Evento = msDtHr1Evento
			// IdUP
			// StEvento = 0

			verificaSeFinalizaCicloAoInicializar(log, idLog, prup, dthrEvento);
			if (comParadaSemConexao && prup.getNrop() != null) {
				if (prup.obtemDtHrUltimoHeartBeat().before(dthrEvento)) {
					ParadaRN oParadaRN = new ParadaRN(this.getDaoInjet(), this.getDaoPdba());
					Date dthrInicioParSemConex = prup.obtemDtHrUltimoHeartBeat();

					// Verifica se parada � maior que 1 segundo By Senoj 2010 05
					// 26
					// Alterei o DtHr para o Data e Hora Evento, pois o coletor
					// ainda n�o possui uma data confi�vel neste momento
					try {
						if (dthrInicioParSemConex != null
								&& (DataHoraRN.getQuantidadeSegundosNoPeriodo(
										dthrInicioParSemConex, dthrEvento) > 1)) {
							oParadaRN.setTr_lancaParadaSemConexao(log, idLog, prup
									.getIdup().toString(),
									dthrInicioParSemConex, dthrEvento,
									comParadaDefault);
							this.getDaoPdba().flushReiniciandoTransacao();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			prup.mudaDtHrReferenciaParaEventos(dthrEvento);
			double milissegundos = DataHoraRN.getApenasMilisegundos(dthrEvento);

			PrColetorEventos prcoletoreventos = new PrColetorEventos();
			prcoletoreventos.setTpevento(new BigDecimal(1));
			prcoletoreventos.setDthr1evento(dthrEvento);
			prcoletoreventos.setMsdthr1evento(milissegundos);
			prcoletoreventos.setDthr2evento(dthrEvento);
			prcoletoreventos.setMsdthr2evento(milissegundos);
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setPrUp(prup);
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
			this.getDaoPdba().flushReiniciandoTransacao();
			// Tem NrOP para a UP?
			// Se nao, seta flag para a up informando que nao tem OP carregada e
			// que o coletor
			// deve entrar no processo de pedir os dados de Op (molde, etc)
			// Passar para a proxima Up do coletor
			if (isUpTemOPCarregada(prup) == false) {
				prup.mudaSemPrograma(true);
				listaUpDTO.addPrUp(prup);
				continue; // proxima up
			}
			// Se sim PLANEJAMENTO EM EXECUCAO
			IwsCpDTO retornoValidacao = planejamentoEmExecucao(log, idLog, prup, 1d);

			if (retornoValidacao.getPlanClose() == true) {
				prup.mudaSemPrograma(true);
				listaUpDTO.addPrUp(prup);
				continue; // proxima up
			}
			// Parada em aberto?
			prup.mudaParadaEmAberto(isParadaEmAberto(prup));


			verificaStatusVariacaoRitmo(prup);
			verificaIsComCIP(log, idLog, prup);
			prup.mudaDadosBC(obtemDadosPrUpDadosBC(prup.getIdup()));
			VerificaIsEmRegulagem(log, idLog, prup);
			try {
				prup.mudaIsAlertaProbQuali(setTr_buscaAleraProbQuali(prup.getCdmaquina())); 																			// 20100322
			} catch (SemSGBDException e) {
				e.printStackTrace();
				prup.mudaIsAlertaProbQuali(false);
			}

			ModRN modrn = new ModRN(getDaoInjet(), getDaoPdba());
			List<IwsModDTO> listaLogins = null;
			try {
				listaLogins = modrn.getTr_balanceamentoLogin(prup, dthrEvento,
						getStBcOnline(prup.getIdup().toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.getDaoPdba().flushReiniciandoTransacao();
			try {
				InjetAlertaRN aRn = new InjetAlertaRN(this.getDaoInjet());
				prup.mudaListaAlertasEmAberto(aRn.pesquisaAlertasEmAberto(log, idLog, prup.getCdmaquina()));
				prup.mudaListaAlertasDiarioDeBordo(aRn.pesquisaAlertasAptDiariodeBordo(log, idLog, prup.getCdmaquina()));
				aRn = null;
			} catch (SemSGBDException e1) {
				e1.printStackTrace();
			}
			prup.mudaListaLoginsEmAberto(listaLogins);
			modrn = null;

			listaUpDTO.setStAndonConfiguravel(verificaStatusAndonConfig(prup));
			listaUpDTO.setStAndonProcessoft(verificaStatusAndonPrcsft(prup));
			listaUpDTO.addFullPrUp(log, idLog, prup, getTr_ListaDadosAndon(log, idLog, prup),
					getDaoInjet(), this.getDaoPdba());
			// Gera evento 98 informando que a inicializa��o finalizou
			PrColetorEventos prcoletoreventosFinal = new PrColetorEventos();
			prcoletoreventosFinal.setTpevento(new BigDecimal(98));
			prcoletoreventosFinal.setStevento("3");
			prcoletoreventosFinal.setDthr1evento(dthrEvento);
			prcoletoreventosFinal.setMsdthr1evento(milissegundos);
			prcoletoreventosFinal.setDthr2evento(dthrEvento);
			prcoletoreventosFinal.setMsdthr2evento(milissegundos);
			prcoletoreventosFinal.setNrop(prup.getNrop());
			prcoletoreventosFinal.setCdestrutura(prup.getCdestrutura());
			prcoletoreventosFinal.setCdmolde(prup.getCdmolde());
			prcoletoreventosFinal.setDthriniplanejada(prup
					.getDthriniplanejada());
			prcoletoreventosFinal.setPrUp(prup);
			prcoletoreventosFinal.setInf20(dthrEvento.toString());
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventosFinal, false);
			this.getDaoPdba().flushReiniciandoTransacao();// By Senoj 2010 05 26

		}

		return listaUpDTO;
	}

	private boolean isParadaEmAberto(PrUp prup) {
		if (prup.getStparadaemaberto() == null)
			return false;

		return (prup.getStparadaemaberto().equals('1'));
	}

	private IwsCpDTO planejamentoEmExecucao(IdwLogger log, int idLog, PrUp prup, Double qtdBatidas) {
		IwsCpDTO retorno = new IwsCpDTO();
		retorno.setPlanClose(true);
		// Alterar RespostaAguard para a ID de resposta referente ao Resultado
		// Valida��o Planejamento em Execu��o
		// StAguardRespMestreBridgeCLDB = 3

		// Lan�a evento de Valida��o de Planejamento em
		// Execu��o na
		// PR_COLETOR_EVENTOS
		// TpEvento = 3
		// NrOP
		// CdMolde
		// CdEstrutura
		// CdEstrutura
		// INF01 = TpSessaoProducao
		Date dthrEvento = null;
		Double msDthrEvento = null;
		InjetInfoRN iRN = new InjetInfoRN(getDaoInjet(),getDaoPdba());
		iRN.verificaIntegDoal(prup);

		PrColetorEventos prcoletoreventosPesquisa = obtemUltimoPrColetorEventos(prup);
		try {
			prup.mudaDtHrUltimoHeartBeat(getBeatForIdup(prup.getIdup()
					.toString()));
		} catch (Exception e) {
			// N�o conseguiu obter o valor do ultimo heartbeat, assumir data e
			// hora atual
			prup.mudaDtHrUltimoHeartBeat(DataHoraRN.getDataHoraAtual(this
					.getDaoPdba()));
		}
		if (prup.obtemDtHrUltimoHeartBeat() != null) {

			if (prup.obtemDtHrUltimoHeartBeat().before(
					prup.obtemDtHrReferenciaEventos())) {
				dthrEvento = prup.obtemDtHrReferenciaEventos();
				msDthrEvento = (double) DataHoraRN
						.getApenasMilisegundos(dthrEvento);
			} else if (prup.obtemDtHrUltimoHeartBeat().before(
					prcoletoreventosPesquisa.getDthr2evento())) {
				dthrEvento = prcoletoreventosPesquisa.getDthr2evento();
				msDthrEvento = prcoletoreventosPesquisa.getMsdthr2evento();
			} else {
				dthrEvento = prup.obtemDtHrUltimoHeartBeat();
				msDthrEvento = (double) DataHoraRN
						.getApenasMilisegundos(dthrEvento);
			}
		} else if (prcoletoreventosPesquisa == null) {
			dthrEvento = prup.obtemDtHrReferenciaEventos();
			msDthrEvento = (double) DataHoraRN
					.getApenasMilisegundos(dthrEvento);
		} else {
			dthrEvento = prcoletoreventosPesquisa.getDthr2evento();
			msDthrEvento = prcoletoreventosPesquisa.getMsdthr2evento();
		}

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setTpevento(new BigDecimal(3));
		prcoletoreventos.setDthr1evento(dthrEvento);
		prcoletoreventos.setMsdthr1evento(msDthrEvento);
		prcoletoreventos.setDthr2evento(dthrEvento);
		prcoletoreventos.setMsdthr2evento(msDthrEvento);
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setInf01(prup.getCfgtpsessaoproducao());
		try {
			String dtte = DataHoraRN.getDataHoraAtual(this.getDaoPdba())
					.toString();
			if (dtte.length() > 30)
				prcoletoreventos.setInf20(dtte.substring(0, 30));
			else
				prcoletoreventos.setInf20(dtte);
		} catch (Exception e) {
			prcoletoreventos.setInf20("ERRO ln: 716");
		}
		prcoletoreventos.setPrUp(prup);

		PrEventosBridgeCollecDb eventoResposta = null;
		try {
			eventoResposta = lancarEventoEsperaPrEventosBridgeCollecDb(
					log, idLog,
					prcoletoreventos, true);
		} catch (MestreOfflineException e) {
			// Se o mestre estiver off-line, entao independente se o BC
			// respondeu o 3, o evento 5 deve ser lancado
			eventoResposta = new PrEventosBridgeCollecDb();
			eventoResposta.setTpevento(new BigDecimal(3));
			eventoResposta.setInf01("1");
		}

		prcoletoreventosPesquisa = obtemUltimoPrColetorEventos(prup);

		if (prcoletoreventosPesquisa == null) {
			dthrEvento = prup.obtemDtHrReferenciaEventos();
			msDthrEvento = (double) DataHoraRN
					.getApenasMilisegundos(dthrEvento);
		} else {
			dthrEvento = prcoletoreventosPesquisa.getDthr2evento();
			msDthrEvento = prcoletoreventosPesquisa.getMsdthr2evento();
		}
		if(eventoResposta.getInf01().equals("1")){
			if (eventoResposta.getInf02() == null) {
				retorno.setIsApntSAPAtivo("0");
				prup.mudaIsComApntSAP("0");
				retorno.setStApntSAP("0");
				prup.mudaStatusApntSAP("0");
			} else {
				if (eventoResposta.getInf02().equals("1")) {
					retorno.setIsApntSAPAtivo("1");
					prup.mudaIsComApntSAP("1");
					if (eventoResposta.getInf03().equals("1")) {
						retorno.setStApntSAP("1");
						prup.mudaStatusApntSAP("1");
					} else {
						retorno.setStApntSAP("0");
						prup.mudaStatusApntSAP("0");
					}
				} else {
					retorno.setIsApntSAPAtivo("0");
					prup.mudaIsComApntSAP("0");
					retorno.setStApntSAP("0");
					prup.mudaStatusApntSAP("0");
				}
				retorno.setPlanClose(false);
			}
		}
		// Planejametno valido
		// Lan�ar evento de OP confirmada em PR_COLETOR_EVENTOS
		// TpEvento = 5
		// DtHrInicioMs = Data/hora inicio confirmacao Op;
		// DtHrFimMs = Data/hora inicio confirmacao Op;
		// NrOP;
		// CdMolde;
		// CdEstrutura;
		// INF01 = Sessao de Producao
		// dthrEvento = DataHoraRN.getDataHoraAtual();

		PrColetorEventos eventoConfirmacao = new PrColetorEventos();
		eventoConfirmacao.setTpevento(new BigDecimal(5));
		eventoConfirmacao.setCdestrutura(prup.getCdestrutura());
		eventoConfirmacao.setPrUp(prup);
		eventoConfirmacao.setCdmolde(prup.getCdmolde());
		eventoConfirmacao.setDthr1evento(dthrEvento);
		eventoConfirmacao.setDthr2evento(dthrEvento);
		eventoConfirmacao.setDthriniplanejada(prup.getDthriniplanejada());
		eventoConfirmacao.setMsdthr1evento(msDthrEvento);
		eventoConfirmacao.setMsdthr2evento(msDthrEvento);
		eventoConfirmacao
		.setInf01(prup.getCfgtpsessaoproducao().toString());
		eventoConfirmacao.setInf02(null);
		eventoConfirmacao.setNrop(prup.getNrop());
		eventoConfirmacao.setCdmolde(prup.getCdmolde());
		eventoConfirmacao.setCdestrutura(prup.getCdestrutura());
		eventoConfirmacao.setPrUp(prup);
		lancarEventoEsperaPrColetorEventos(log, idLog, eventoConfirmacao, false);
		retorno.setPlanClose(false);
		return retorno;
	}

	private void fecharTodosLogins(IdwLogger log, int idLog, PrUp prup) {
		// Remove login de PR_UP_LOGINS_EM_ABERTO
		// IdUP
		String hql = "";
		String sql = "";
		hql += "select pruploginsemaberto ";
		hql += "from PrUpLoginsEmAberto pruploginsemaberto ";
		hql += "where pruploginsemaberto.prUp.idup = '::idup'";

		hql = hql.replaceAll("::idup", prup.getIdup().toString());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrUpLoginsEmAberto> lista = q.list();

		for (PrUpLoginsEmAberto pruploginsemaberto : lista) {
			// Lan�ar evento de Logout em PR_COLETOR_EVENTOS
			// TpEvento = 18
			// DtHrInicioMs = DtHr fim alerta;
			// DtHrFimMs = DtHr fim alerta;
			// NrOP;
			// CdMolde;
			// CdEstrutura;
			// INF01 = data hora do inicio do login
			// INF02= milisegundo do inicio do login
			// INF03= cdusuario

			PrColetorEventos evento = new PrColetorEventos();
			evento.setTpevento(new BigDecimal(18));
			evento.setDthr1evento(prup.obtemDtHrUltimoHeartBeat());
			evento.setMsdthr1evento(prup.obtemMsDthrUltimoHeartBeat());
			evento.setNrop(prup.getNrop());
			evento.setPrUp(prup);
			evento.setCdmolde(prup.getCdmolde());
			evento.setCdestrutura(prup.getCdestrutura());
			evento.setDthriniplanejada(prup.getDthriniplanejada());
			evento.setInf01(DataHoraRN.dateToStringYYYYMMDDHHMMSS(pruploginsemaberto.getDthrlogin()));
			evento.setInf02(String.valueOf(pruploginsemaberto.getMsdthrlogin()));
			evento.setInf03(pruploginsemaberto.getCdusuario());

			lancarEventoEsperaPrColetorEventos(log, idLog, evento, false);
			
			// Alessandre em 12-01-18 comentei o flush abaixo pois em alguma situação o logout era executado no BC mas pr_up_logins_em_aberto nao era excluida
			//this.getDaoPdba().flushReiniciandoTransacao();

			if (IdwFacade.getInstancia().isIDWAtivo()) {
				UsuarioMSRN usuarioMSRN = new UsuarioMSRN();
				usuarioMSRN.iniciaConexaoBanco(getDaoPdba().getSession());
				usuarioMSRN.deslogarUsuario( prup.getIdup().toString(), pruploginsemaberto.getCdusuario(), prup.obtemDtHrUltimoHeartBeat());
			}


			sql = "";
			sql += "delete from Pr_Up_Logins_Em_Aberto where idUp='::idup' and cdusuario='::cdusuario' ";
			sql = sql.replaceAll("::idup", prup.getIdup().toString());
			sql = sql.replaceAll("::cdusuario", pruploginsemaberto.getCdusuario());

			q = this.getDaoPdba().getSession().createSQLQuery(sql);

			q.executeUpdate();
			this.getDaoPdba().flushReiniciandoTransacao();
		}
	}

	private void fecharTodosAlertas(IdwLogger log, int idLog, PrUp prup) {
		List<IwsAlertaDTO> listaAlertas=new ArrayList<IwsAlertaDTO>();
		try {
			InjetAlertaRN aRn = new InjetAlertaRN(this.getDaoInjet());
			listaAlertas = aRn.pesquisaAlertasEmAberto(log, idLog, prup.getCdmaquina());			
			aRn = null;
		} catch (SemSGBDException e1) {
			e1.printStackTrace();
		}
		// Remove alerta de PR_UP_ALERTAS_EM_ABERTO
		// IdUP
		if(listaAlertas==null)
			return;
		try{
			for (IwsAlertaDTO alertasemaberto : listaAlertas) {
				if (!alertasemaberto.getCdAlerta().equals("QLD001") &&
						!alertasemaberto.getCdAlerta().equals("EXT001")	&&
						!alertasemaberto.getCdAlerta().equals("EXT002")	&&
						!alertasemaberto.getCdAlerta().equals("DBQ001")	&&
						!alertasemaberto.getCdAlerta().equals("999999")	) {
					// Lan�ar evento de Fim de alerta em PR_COLETOR_EVENTOS
					// TpEvento = 16
					// DtHrInicioMs = DtHr fim alerta;
					// DtHrFimMs = DtHr fim alerta;
					// NrOP;
					// CdMolde;
					// CdEstrutura;
					// INF01 = data hora do inicio do alerta
					// INF02= milisegundo do inicio do alerta
					// INF03= codigo do alerta
					PrColetorEventos evento = new PrColetorEventos();
					evento.setTpevento(new BigDecimal(16));
					evento.setDthr1evento(prup.obtemDtHrUltimoHeartBeat());
					evento.setMsdthr1evento(prup.obtemMsDthrUltimoHeartBeat());
					evento.setNrop(prup.getNrop());
					evento.setPrUp(prup);
					evento.setCdmolde(prup.getCdmolde());
					evento.setCdestrutura(prup.getCdestrutura());
					evento.setInf01(DataHoraRN.dateToString(
							alertasemaberto.getdthrinialerta(),
							DataHoraRN.YYYYMMDDHHMMSS));
					evento.setInf02(String.valueOf(DataHoraRN.getApenasMilisegundos(alertasemaberto.getdthrinialerta())));
					evento.setInf03(alertasemaberto.getCdAlerta());

					lancarEventoEsperaPrColetorEventos(log, idLog, evento, false);

					// Lancar aqui o fechamento dos alerta
					if (IdwFacade.getInstancia().isIDWAtivo()) {
						AlertaPdbaMsEvtRN rnidw = new AlertaPdbaMsEvtRN();
						rnidw.executarServico(getDaoPdba().getSession(), prup.getIdup().toString(),
								alertasemaberto.getCdAlerta(), prup.obtemDtHrUltimoHeartBeat(), null, null,
								ServicoFactory._REMOVE_ALERTA, "fecharTodosAlertas " + DataHoraRN.getDataHoraAtualFormatada());
					}

					this.getDaoPdba().flushReiniciandoTransacao();
				} 
			}
		}
		catch(Exception e){
			log.info("N�o foi possivel fechar Alertas ao Finalizar Planejamento: ", e);
		}
	}

	public void fecharParada(IdwLogger log, int idLog, PrUp prup) throws ServicoFalhouException {
		// Lan�ar evento de Fechar Parada em PR_COLETOR_EVENTOS
		// TpEvento = 10
		// DtHrInicioMs = Fim da parada;
		// DtHrFimMs = Fim da parada;
		// NrOP;
		// CdMolde;
		// CdEstrutura;
		// INF01 = DataHora inicio da parada
		// INF01 = Milisegundo de inicio da parada

		if (prup.getStparadaemaberto() != null
				&& prup.getStparadaemaberto() == '1'
				&& prup.getCdultimaparada() != null) {
			if (prup.obtemDtHrUltimoHeartBeat() == null) {
				Date dthrAtual;
				dthrAtual = DataHoraRN.getDataHoraAtual(this.getDaoPdba());
				prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(dthrAtual));
				prup.mudaDtHrUltimoHeartBeat(dthrAtual);
			}
			PrUpUltimaParada oPrUpUltimaParada = pesquisaPrup_ultimaparada(log, idLog, prup);
			if (prup.getCdultimaparada() != null
					&& !prup.getCdultimaparada().equals("999999")
					&& oPrUpUltimaParada.getisParadaRegulagem() != null
					&& oPrUpUltimaParada.getisParadaRegulagem().equals('1')) {
				if (prup.getDthrinicic() != null) {
					fecharCiclo(log, idLog, prup, prup.obtemDtHrUltimoHeartBeat(),
							prup.getCfgtamanhoumpacoteciclos().intValue(), true, true,
							"Inicio de Regulagem");
					prup.setDthrinicic(null);
					prup.setMsdthrinicic(0d);
					// Adicionado para tratamaneto de tempo de espera by Senoj
					prup.setDthrfimcic(null);
					prup.setMsdthrfimcic(0d);
					prup.setStcicloemaberto('0');

					prup.setTmpcicloparcial(0d);
					prup.setTmpcicloparcialaux(0d);

					this.getDaoPdba().flushReiniciandoTransacao();
					this.getDaoPdba().getSession().merge(prup);
				}
			}
			PrColetorEventos evento = new PrColetorEventos();
			evento.setTpevento(new BigDecimal(10));
			evento.setDthr1evento(prup.obtemDtHrUltimoHeartBeat());
			evento.setMsdthr1evento(prup.obtemMsDthrUltimoHeartBeat());
			evento.setNrop(prup.getNrop());
			evento.setCdmolde(prup.getCdmolde());
			evento.setCdestrutura(prup.getCdestrutura());
			evento.setDthriniplanejada(prup.getDthriniplanejada());
			evento.setPrUp(prup);
			evento.setStevento("0");
			if (prup.getDthriniultimaparada() != null) {
				evento.setInf01(DataHoraRN.dateToStringYYYYMMDDHHMMSS(prup.getDthriniultimaparada()));
				evento.setInf02(String.valueOf(prup.getMsdthriniultimaparada()));
			}
			lancarEventoEsperaPrColetorEventos(log, idLog, evento, false);

			if (IdwFacade.getInstancia().isIDWAtivo()) {
					// Alessandre-tanto o inicio da parada qto o final da para estao
					// chamando o mesmo servico, e o servico ira executar inicio ou fim da parada dependendo do 
					// status de funcionamento da maquina. Encontrar uma forma de dizer q a maq esta trabalhando
					// aqui para q o servico inicio uma parada
					IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(prup.getIdup().toString());

					icupdto.getUpDTO().setUpTrabalhando(false);

					ParadaPdbaMsEvtRN rnidw = new ParadaPdbaMsEvtRN();
					rnidw.executarServico(getDaoPdba().getSession(), prup.getIdup().toString(), null, prup.obtemDtHrUltimoHeartBeat(), null, null, ServicoFactory._FIM_PARADA, "fecharParada " + DataHoraRN.getDataHoraAtualFormatada());
			}

			// Adicionado atualiza��o de Flag de st parada em aberto
			prup.setStparadaemaberto('0');
			// se a parada n�o fecha ciclo, entao acumular o tempo da parada
			// em PrUp.tmpCicloParcial
			// Assim, quando o ciclo fechar, o tempo dele ser� o tempo
			// transcorrido entre o inicio
			// e fim do ciclo menos as paradas representadas em
			// PrUp.tmpCicloParcial
			if (prup.getDthrinicic() == null) {
				prup.setTmpcicloparcial(0d);
				prup.setTmpcicloparcialaux(0d);
			} else if ((prup.getCfginterrupcaociclo() != null && prup
					.getCfginterrupcaociclo().equals('2'))
					|| (prup.getCfgtamanhoumpacoteciclos() != null && prup
					.getCfgtamanhoumpacoteciclos().doubleValue() > 1d)) {
				double segundos = DataHoraRN.getQuantidadeSegundosNoPeriodo(
						prup.getDthriniultimaparada(),
						prup.obtemDtHrUltimoHeartBeat());
				if (prup.getTmpcicloparcial() == null)
					prup.setTmpcicloparcial((double) segundos);
				else
					prup.setTmpcicloparcial(prup.getTmpcicloparcial()
							+ (double) segundos);
			}
			prup.mudaParadaEmAberto(false);
			this.getDaoPdba().makePersistent(prup);
		}
	}

	public PrUp pesquisaPrup(IdwLogger log, int idLog, String idUp) {

		MapQuery q = new MapQuery(getDaoPdba().getSession());
		q.append("select prup ");
		q.append("from PrUp prup ");
		q.append("where prup.idup = :idup and prup.stativa = 1");

		q.defineParametro("idup", new BigDecimal(idUp));
		q.setMaxResults(1);
		log.info("pesquisando prup com idup = " + idUp);
		PrUp retorno = (PrUp) q.uniqueResult();
		if (retorno == null) {
			log.info("..::ERRO::.. Nao foi possivel obter a IDUP para:" + idUp);
		}

		if (retorno.getNrop() != null)
			retorno.mudaSemPrograma(false);

		return retorno;
	}

	public PrUp pesquisaPrupCdmaquina(IdwLogger log, int idLog, String cdMaquina) {

		String hql = "";
		hql += "select prup ";
		hql += "from PrUp prup ";
		hql += "where prup.cdmaquina = '::cdMaquina'";
		hql += "and prup.stativa = '1'";

		hql = hql.replaceAll("::cdMaquina", cdMaquina);

		Query q = this.getDaoPdba().getSession().createQuery(hql);
		q.setMaxResults(1);

		PrUp retorno = (PrUp) q.uniqueResult();
		if (retorno == null) {
			log.info("..::ERRO::.. N�o foi poss�vel obter a PrUP para cdMaquina:"
					+ cdMaquina);
		}

		if (retorno.getNrop() != null)
			retorno.mudaSemPrograma(false);

		return retorno;
	}

	// O metodo abaixo eh chamado pelo Facade. Sera executado quando o coletor
	// solicita o fechamento do planejamento
	public void fimPlanejamento(IdwLogger log, int idLog, String idUp, Date dthrfplanejamento,int batidas, boolean isParcial) throws ServicoFalhouException {
		// Obtem PrUp
		PrUp prup = new PrUp();
		prup = pesquisaPrup(log, idLog, idUp);

		// seta fim do planejamento com a data e hora recebidas
		prup.mudaDtHrUltimoHeartBeat(dthrfplanejamento);
		prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(dthrfplanejamento));

		// finaliza planejamento
		finalizacaoDoPlanejamento(log, idLog, prup, batidas, isParcial);

	}

	public void desativaUp(IdwLogger log, int idLog, PrUp prup) throws ServicoFalhouException {
		desativaUp(log, idLog, prup, true);
	}

	public void desativaUp(IdwLogger log, int idLog, PrUp prup, boolean isFlush) throws ServicoFalhouException {



		PrColetorEventos prcoletoreventosPesquisa = obtemUltimoPrColetorEventos(prup);

		if (prcoletoreventosPesquisa == null) {
			prup.mudaDtHrUltimoHeartBeat(prup.obtemDtHrReferenciaEventos());
			prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN
					.getApenasMilisegundos(prup.obtemDtHrReferenciaEventos()));
		} else {
			prup.mudaDtHrUltimoHeartBeat(prcoletoreventosPesquisa
					.getDthr2evento());
			prup.mudaMsDthrUltimoHeartBeat(prcoletoreventosPesquisa
					.getMsdthr2evento());
		}
		if (prup.obtemDtHrUltimoHeartBeat() == null) {
			Date dthrAtual;
			dthrAtual = DataHoraRN.getDataHoraAtual(this.getDaoPdba());
			prup.mudaDtHrUltimoHeartBeat(dthrAtual);
			prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN
					.getApenasMilisegundos(dthrAtual));
		}
		finalizacaoDoPlanejamento(log, idLog, prup,1, false);		
		if (isFlush == true)
			this.getDaoPdba().flushReiniciandoTransacao();	

		try{
			String sql = "";
			sql += "update pr_up set idregsubcoletor=null, stativa='0' where idup='::idup'";
			sql = sql.replaceAll("::idup", prup.getIdup().toString());
			Query q = this.getDaoPdba().getSession().createSQLQuery(sql);
			q.executeUpdate();
			if (isFlush == true)
				this.getDaoPdba().flushReiniciandoTransacao();
		}catch(Exception e){
			log.info("Erro ao desativar a UP:"+prup.getIdup().toString());
		}

	}

	public void ativaUp(PrUp prup) {
		ativaUp(prup, true);
	}

	public void ativaUp(PrUp prup, boolean isFlush) {
		// prup.setStativa('1');
		// getSession().merge(prup);
		// flushReiniciandoTransacao();

		String hql = "";
		hql += "update PrUp prup set prup.stativa = 1 ";
		hql += "where prup.idup = '::idup' ";
		hql = hql.replaceAll("::idup", prup.getIdup().toString());
		Query q = this.getDaoPdba().getSession().createQuery(hql);
		q.executeUpdate();
		if (isFlush == true)
			this.getDaoPdba().flushReiniciandoTransacao();

	}

	// O metodo abaixo eh chamado durante a inicializacao e pelo fimPlanejamento
	// (acima)
	private void finalizacaoDoPlanejamento(IdwLogger log, int idLog, PrUp prup,int batidas, boolean isParcial) throws ServicoFalhouException {
		finalizacaoDoPlanejamento(log, idLog, prup, false, null, 0d,batidas, isParcial);
	}

	private void finalizacaoEventosEmPerdadeSincronia(IdwLogger log, int idLog, PrUp prup,
			Date dataHoraReferencia, double mSegReferencia) throws ServicoFalhouException {
		finalizacaoDoPlanejamento(log, idLog, prup, true, dataHoraReferencia,
				mSegReferencia,1, true);// finaliza todos os eventos sem finaizar a OP
	}

	private void finalizacaoDoPlanejamento(IdwLogger log, int idLog, PrUp prup,
			Boolean isEmPerdaDeSincronia, Date dataHoraReferencia,
			double mSegReferencia,int batidas, boolean isParcial) throws ServicoFalhouException {
		PrColetorEventos prcoletoreventos = new PrColetorEventos();		
		if(isEmPerdaDeSincronia == true) {	
			Calendar cDate = new GregorianCalendar();
			cDate.setTime(dataHoraReferencia);
			cDate.add(Calendar.MILLISECOND, (int) mSegReferencia);
			prup.mudaDtHrUltimoHeartBeat(cDate.getTime());
			prup.mudaMsDthrUltimoHeartBeat(mSegReferencia);
			prcoletoreventos = new PrColetorEventos();
			prcoletoreventos.setPrUp(prup);
			prcoletoreventos.setTpevento(new BigDecimal(21));
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setDthr1evento(dataHoraReferencia);
			prcoletoreventos.setMsdthr1evento(mSegReferencia);
			if (isParcial == true) {
				prcoletoreventos.setInf01("1");
			} 
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
		}
		if(prup.getNrop()!=null)
			fecharTodosAlertas(log, idLog, prup);
		// fazer a verificacao
		if (verificaModuloAtivo(prup.getIdup().toString())) {
			fecharTodosLogins(log, idLog, prup); // No deve finalizar o login ao finalizar o planejamento
		}
		PrUpUltimaParada oUltimaParada = pesquisaPrup_ultimaparada(log, idLog, prup);
		Boolean isParadaRegulagem = false;
		if ((oUltimaParada != null)
				&& oUltimaParada.getisParadaRegulagem() != null 
				&& oUltimaParada.getDtHrFParada() == null
				&& (oUltimaParada.getisParadaRegulagem().charValue() == '1')) {
			isParadaRegulagem = true;
		}
		// obter estado se existe parada aberta
		boolean isParadaAberta = false, isCodParInformado = false;

		if (prup.getStparadaemaberto() != null && prup.getStparadaemaberto() == '1') {
			isParadaAberta = true;
			if (prup.getCdultimaparada() != null && !prup.getCdultimaparada().equals("999999")) {
				isCodParInformado = true;
			}
		}
		fecharParada(log, idLog, prup);

		if (prup.getDthrinicic() != null && prup.getNrop() != null
				&& !prup.getNrop().equals("")
				&& prup.getTmpciclopadrao() != null) {
			Date DataHrParaFecharCiclo = DataHoraRN.getDataComMilisegundos(
					prup.obtemDtHrUltimoHeartBeat(),
					prup.obtemMsDthrUltimoHeartBeat());
			float tempoCiclo = prup.getTempoCiclo(DataHrParaFecharCiclo);
			float tempoLimite = (prup.getTmpciclopadrao().floatValue()
					* prup.getCfgperctmpcicloparauto().floatValue() * 10f);
			if ((isParadaAberta==false) && (tempoCiclo > tempoLimite) && (prup.getCfgperctmpcicloparauto()>0d)
					&& ((prup.getTmpcicloparcial() == null) || (prup
							.getTmpcicloparcial() != null && prup
							.getTmpcicloparcial().equals(0d))))
				DataHrParaFecharCiclo = DataHoraRN.somaMiliSegundos(
						prup.getDthrinicicComMilisegundos(), (int) tempoLimite);
			fecharCiclo(log, idLog, prup, DataHrParaFecharCiclo, batidas, isParadaRegulagem,
					false, "FimPlanejamento");
		}
		// Adicionado para tratamaneto de tempo de espera by Senoj
		prup.setDthrfimcic(null);
		prup.setMsdthrfimcic(0d);
		prup.setStcicloemaberto('0');
		if (isEmPerdaDeSincronia == true) {
			// fecharTodosLogins(prup); // em caso de perda de sincronismo deve
			// finalizar

			this.getDaoPdba().getSession().merge(prup);
			prcoletoreventos = new PrColetorEventos();
			prcoletoreventos.setPrUp(prup);
			prcoletoreventos.setTpevento(new BigDecimal(121));
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setDthr1evento(prup.obtemDtHrUltimoHeartBeat());
			prcoletoreventos.setMsdthr1evento(prup.obtemMsDthrUltimoHeartBeat());
			//Rebeca: 2018-06-04 - setar campo Inf01 também neste caso de perda de sincronia
			if (isParcial == true) {
				prcoletoreventos.setInf01("1");
			} 
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);

			// se estiver parada aberta, lan�a nova parada com motivo da
			// anterior
			if (isParadaAberta) {
				ParadaRN prn = new ParadaRN(this.getDaoInjet(), this.getDaoPdba());
				Date dtHrParada = DataHoraRN.getDataComMilisegundos(prup.obtemDtHrUltimoHeartBeat(), prup.obtemMsDthrUltimoHeartBeat());
				prn.setTr_paradaInicio(log, idLog, prup.getIdup().toString(), dtHrParada,false, false);
				prn.setTr_UltimaParadaInicio(log, idLog, prup.getIdup().toString(), dtHrParada, false);
				if (isCodParInformado) {
					PrUpUltimaParada ultimaParadaDto = pesquisaPrup_ultimaparada(log, idLog, prup);
					prn.setTr_paradaMotivo(log, idLog, prup.getIdup().toString(),
							dtHrParada, ultimaParadaDto.getCdParada(),
							ultimaParadaDto.getCdAcao(),
							ultimaParadaDto.getCdCausa(),
							ultimaParadaDto.getCdJustificativa(),
							ultimaParadaDto.getCdTecnicoResponsavel(),
							ultimaParadaDto.getCdTecnico1(),
							ultimaParadaDto.getCdTecnico2(),
							ultimaParadaDto.getCdLocalParada(),null,null,0);
				}
			}

			return; // se esta em perda de sincronia sai neste ponto para evitar
					// a finaliza��o da OP
		}
		trataFimCIP(
				log, idLog,
				prup.getIdup().toString(),
				DataHoraRN.getDataComMilisegundos(
						prup.obtemDtHrUltimoHeartBeat(),
						prup.obtemMsDthrUltimoHeartBeat()), true,null);
		if (prup.obtemIsReiniciarUp()) {
			fecharTodosLogins(log, idLog, prup);
		}
		// , TpEvento = 6 (Planejamento Finalizado)
		// - Nrop
		// - CdMolde
		// - CdEstrutura
		// - StEvento = 0 (n�o lido pelo mestre)
		// Se nao houver OP carregada na UP, nao eh necessario enviar o evento 6
		if (prup.getNrop() != null && !prup.getNrop().equals("")) {
			prcoletoreventos = new PrColetorEventos();
			prcoletoreventos.setTpevento(new BigDecimal(6));
			prcoletoreventos.setDthr1evento(prup.obtemDtHrUltimoHeartBeat());
			prcoletoreventos.setMsdthr1evento(prup.obtemMsDthrUltimoHeartBeat());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setPrUp(prup);
			//Rebeca: 2018-06-04 - setar campo Inf01 mesmo quando não há perda de sincronia
			if (isParcial == true) {
				prcoletoreventos.setInf01("1");
			} 
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
		}

		// Apagar os dados da tabela PR_UP:
		// NrOP, CdMolde, CdEstrutura, TmpCicloPadrao, QtdCiclosExecutados,
		// QtdProducaoLiquida,
		// DtrUltRefugo, CdUltimoRefugo, IdReduzidoProduto, QtdRefugada,
		// CdUltimaParada, DtHrIniUltParada
		prup.setNrop(null);
		prup.setNropestendido(null);
		prup.setCdmolde(null);
		prup.setCdestrutura(null);
		prup.setTmpciclopadrao(null);
		prup.setQtdciclosexecutados(null);
		prup.setDthrultimorefugo(null);
		prup.setMsdthrultimorefugo(null);
		prup.setCdultimorefugo(null);
		prup.setIdreduzidaproduto(null);
		prup.setQtdrefugada(null);
		prup.setCdultimaparada(null);
		prup.setDthriniultimaparada(null);
		prup.setMsdthriniultimaparada(null);
		prup.setDthrinicic(null);
		prup.setMsdthrinicic(0d);
		prup.setTmpcicloparcial(0d);
		prup.setTmpcicloparcialaux(0d);
		// faltava limpar campos estendidos
		prup.setCdmolestendido(null);
		// Limpar Tabela de alertas e logins
		prup.setPrUpLoginsEmAbertos(null);
		prup.setPrUpAlertasEmAbertos(null);
		prup.mudaSemPrograma(true);
		prup.setStvertelaintegdoal(null);
		if (prup.getStintegdoal() != null)
			prup.setStalimintegdoal('0');
		else
			prup.setStalimintegdoal(null);
		prup.setIsOpSemColeta('0');
		this.getDaoPdba().getSession().merge(prup);
		setProdLiquida(prup.getIdup().toString(), 0d);
		try {
			// Limpar PR_UP_PRODUTO referentes a UP.
			String hql = "";

			hql += "delete from PrUpProduto prupproduto where prupproduto.prUp.idup = '::idup' ";

			hql = hql.replaceAll("::idup", prup.getIdup().toString());

			Query q = this.getDaoPdba().getSession().createQuery(hql);

			q.executeUpdate();

			// Limpar PR_UP_EXECINSPECAO e PR_UP_CTRL_EXECINSPECAO
			// vlauria 20100325
			String sql = "";

			sql += "delete from Pr_Up_Execinspecao where idUp = '::idup' ";
			sql = sql.replaceAll("::idup", prup.getIdup().toString());

			q = this.getDaoPdba().getSession().createSQLQuery(sql);

			q.executeUpdate();

			sql = "";

			sql += "delete from Pr_Up_Ctrl_Execinspecao where idUp = '::idup' ";
			sql = sql.replaceAll("::idup", prup.getIdup().toString());

			q = this.getDaoPdba().getSession().createSQLQuery(sql);

			q.executeUpdate();

			sql = "";

			sql += "delete from Pr_Up_Produto_Mat_Prima where idUp = '::idup' ";
			sql = sql.replaceAll("::idup", prup.getIdup().toString());

			q = this.getDaoPdba().getSession().createSQLQuery(sql);

			q.executeUpdate();
		} catch (Exception e) {
			// N�o faz nada apenas para proteger de poss�veis cagadas

		}
	}

	private Boolean isUpTemOPCarregada(PrUp prup) {
		Boolean retorno = true;

		if (prup.getNrop() == null) {
			prup.setNrop(null);
			prup.setNropestendido(null);
			prup.setCdmolde(null);
			prup.setCdestrutura(null);
			prup.setTmpciclopadrao(null);
			prup.setQtdciclosexecutados(null);
			prup.setDthrultimorefugo(null);
			prup.setMsdthrultimorefugo(null);
			prup.setCdultimorefugo(null);
			prup.setIdreduzidaproduto(null);
			prup.setQtdrefugada(null);
			prup.setCdultimaparada(null);
			prup.setDthriniultimaparada(null);
			prup.setMsdthriniultimaparada(null);
			prup.setDthrinicic(null);
			prup.setMsdthrinicic(0d);
			// Adicionado para tratamaneto de tempo de espera by Senoj
			prup.setDthrfimcic(null);
			prup.setMsdthrfimcic(0d);
			prup.setStcicloemaberto('0');
			// Limpar Tabela de alertas e logins
			prup.setPrUpAlertasEmAbertos(null);
			prup.mudaSemPrograma(true);

			try {
				this.getDaoPdba().getSession().merge(prup);
				setProdLiquida(prup.getIdup().toString(), 0d);
			} catch (Exception e) {
				e.printStackTrace();
			}
			retorno = false;
		}

		return retorno;
	}

	public boolean getStBcOnline(String idup) {

		// Obtem o tempo de time-out para espera do mestre e se esta
		// off-line
		String hql = "";

		hql += "select prbridgecollectordatabase ";
		hql += "from PrBridgeCollectorDatabase prbridgecollectordatabase ";
		hql += "join prbridgecollectordatabase.prConexoesInjets prconexoesinjet ";
		hql += "join prconexoesinjet.prUps prups ";
		hql += "where prups.idup = '::idup' ";

		hql = hql.replaceAll("::idup", idup);
		try {
			Query q = this.getDaoPdba().getSession().createQuery(hql);

			PrBridgeCollectorDatabase mestre = (PrBridgeCollectorDatabase) q
					.uniqueResult();
			if (mestre.getStonline() == '1') {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean getStMonitoraTempoEspera(PrUp prup) {
		// Verifica se coletor trabalha com ciclo em espera.
		PrSubColetor prsubcoletor = prup.getPrSubColetor();
		PrColetor prcoletor = prsubcoletor.getPrColetor();
		boolean retorno = false;
		if (prcoletor.getStmonitoraespera() != null
				&& prcoletor.getStmonitoraespera() == '1')
			retorno = true;
		return retorno;
	}

	public PrColetor getPrColetorByIdColetor(String idcoletor)
			throws RegistroDesconhecidoException {
		MapQuery q = new MapQuery(this.getDaoPdba().getSession());
		q.append("from PrColetor prcoletor where prcoletor.idcoletor = :idcoletor ");

		q.defineParametro("idcoletor", idcoletor);

		q.query().setMaxResults(1);

		PrColetor prcoletor = null;

		prcoletor = (PrColetor) q.query().uniqueResult();

		if (prcoletor == null)
			throw new RegistroDesconhecidoException();

		return prcoletor;
	}

	public PrSubColetor getPrSubColetorByIdRegColetorEIdColetor(
			BigDecimal idregcoletor, String idsubcoletor)
					throws RegistroDesconhecidoException {
		if (idsubcoletor == null) {
			throw new RegistroDesconhecidoException();
		}
		MapQuery q = new MapQuery(this.getDaoPdba().getSession());
		q.append("from PrSubColetor prsubcoletor ");
		q.append("where prsubcoletor.prColetor.idregcoletor = :idregcoletor and prsubcoletor.idsubcoletor = :idsubcoletor ");

		q.defineParametro("idregcoletor", idregcoletor);
		try {
			q.defineParametro("idsubcoletor", new BigDecimal(idsubcoletor));
		} catch (NumberFormatException e) {
			throw new RegistroDesconhecidoException();
		}
		q.query().setMaxResults(1);

		PrSubColetor prsubcoletor = null;

		prsubcoletor = (PrSubColetor) q.query().uniqueResult();

		if (prsubcoletor == null)
			throw new RegistroDesconhecidoException();

		return prsubcoletor;
	}

	/*
	@Deprecated
	private void setFimDecicloEmEspera(PrUp prup, Date dthrfimcic) {

		// Verifica se coletor trabalha com ciclo em espera.
		PrSubColetor prsubcoletor = prup.getPrSubColetor();
		PrColetor prcoletor = prsubcoletor.getPrColetor();

		MapQuery q = new MapQuery(this.getDaoPdba().getSession());

		q.append("select prup ");
		q.append("from PrUp prup ");
		q.append("join fetch prup.prSubColetor prsubcoletor ");
		q.append("join fetch prsubcoletor.prColetor prcoletor ");
		q.append("where prcoletor.stmonitoraespera='1' and ");
		// Alessandre em 09-02-15 removi a up atual da lista de retorno, ja q ela nao altera nada
		q.append("prup <> :prup and ");
		q.append("prcoletor.idcoletor = :idcoletor and prup.stcicloemaberto = '1'");

		q.defineParametro("idcoletor", prcoletor.getIdcoletor());
		q.defineParametro("prup", prup);

		List<PrUp> lista = q.query().list();

		if (lista != null && lista.size() == 0) {
			// Se nao, sai
			return;
		}

		for (PrUp lcprup : lista) {
			if (!(lcprup.getIdup().equals(prup.getIdup()))) {
				lcprup.setStcicloemaberto('0');
				lcprup.setDthrfimcic(dthrfimcic);
				lcprup.setMsdthrfimcic((double) DataHoraRN.getApenasMilisegundos(dthrfimcic));
				lcprup.setTmpcicloparcialaux(lcprup.getTmpcicloparcial());
				this.getDaoPdba().getSession().merge(lcprup);
			}
		}

		return;
	}*/

	public boolean fecharCiclo(IdwLogger log, int idLog, PrUp prup, Date dthrFimCiclo, int QtdBatidas,
			boolean isCicloEmRegulagem, boolean isCicloFechadoPorParada,
			String origem) throws ServicoFalhouException {

		if (prup.isSemPrograma) {
			log.info(idLog, 0, "prup.isSemPrograma = true");
			return false;
		}

		if (prup.getDthrinicic() == null) {
			log.info(idLog, 0, "prup.dthrinicic is null");
			prup.setDthrinicic(dthrFimCiclo);
			prup.setMsdthrinicic((double) DataHoraRN.getApenasMilisegundos(dthrFimCiclo));
			// Adicionado para tratamaneto de tempo de espera by Senoj
			prup.setDthrfimcic(null);
			prup.setMsdthrfimcic(0d);
			prup.setStcicloemaberto('0');
			this.getDaoPdba().getSession().merge(prup);

			// Alessandre em 3-11-2014
			// Caso o idw esteja ativo � necess�rio lan�ar um inicio de ciclo com o mesmso horario de prup.dthriniciocci
			// Pois os dois sistemas precisam ter a mesma referencia de ciclo
			if (IdwFacade.getInstancia().isIDWAtivo() == true) {
					ProducaoPdbaMsEvtRN idwRN = new ProducaoPdbaMsEvtRN();
					// Alessandre: 4-2-15 por algum motivo no idw aparece inicio de ciclo ao inves de final de ciclo, acho que eh por causa
					// do codigo abaixo. Mudei pra FIM_CICLO ao inves de INICIO_CICLO, mas o mais correto parece ser INICIO_CICLO, voltei
						idwRN.executarServico(getDaoPdba().getSession(), prup.getIdup().toString(), null, prup.getDthrinicic(), null, null, ServicoFactory._INICIO_CICLO, "fecharCiclo " + DataHoraRN.getDataHoraAtualFormatada());
			}



			return false;
		}

		boolean isCicloValido = true;

		String inf17 = "", inf12 = "0", inf13 = "";

		/* Ini Filtro */
		Long valoradicional = 0l;
		if (prup.getCfgtolertmpcicloparauto() != null)
			valoradicional = 1 + prup.getCfgtolertmpcicloparauto(); // adicionado
																	// 1 para
																	// valor de
																	// toler�ncia

		float tempoLimite = new Float((prup.getTmpciclopadrao() * prup.getCfgperctmpcicloparauto() / 100) + (valoradicional / 1000));
		log.info("tempoLImite = " + tempoLimite);
		log.info("prup.TmpCiclopadrao  = " + prup.getTmpciclopadrao());
		log.info("prup.getCfgperctmpcicloparauto = " + prup.getCfgperctmpcicloparauto());
		log.info("valoradicional = " + valoradicional);

		// para casos de pacote de ciclo o tempo limite de ciclo � multiplicado
		// pelo n�mero de tamanho do pacote de ciclos.
		tempoLimite = tempoLimite * (new Float(prup.getCfgtamanhoumpacoteciclos()));
		log.info("prup.getcfgtamanhoumpacoteciclos = " + prup.getCfgtamanhoumpacoteciclos());

		if (dthrFimCiclo.before(prup.getDthrinicicComMilisegundos())) {

			Date datarecuperada = DataHoraRN.trySaveDthrEvent(prup.getDthrinicicComMilisegundos(), dthrFimCiclo, tempoLimite);

			if (datarecuperada != null) {
				inf17 = DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrFimCiclo);
				dthrFimCiclo = datarecuperada;
			} else {
				inf17 = "Nao pode recuperar";
				isCicloValido = false;
				log.info(idLog, 0, "prup.isCicloValido = false");
			}
		}

		// Se a UP tem paradas que n�o fecham o ciclo, entao deve-se
		// descontar
		// do ciclo o tempo
		// das paradas que ocorreram. Esse tempo esta em PrUp.tmpCicloParcial.
		// Se o ciclo aconteceu durante uma parada de regulagem, entao nao se
		// deve descontar o tmpcicparcial
		double tempoCicloTimeout;
		float tempoCiclo = (prup.getTempoCiclo(dthrFimCiclo) / 1000f);
		float tempoCicloAtivo = 0f, tempoCicloEspera = 0f;
		boolean isMonitorandoCicloEmEspera = false;

		if (getStMonitoraTempoEspera(prup) && prup.getStcicloemaberto() == '0') {
			log.info(idLog, 0, "prup.stcicloemaberto = " + prup.getStcicloemaberto());
			log.info(idLog, 0, "getStMonitoraTempoEspera pode ser true");

			isMonitorandoCicloEmEspera = true;
			tempoCicloAtivo = prup.getTempoCicloAtivo() - (prup.getTmpcicloparcialaux().floatValue());
			tempoCicloEspera = prup.getTempoCicloEspera(dthrFimCiclo) - (prup.getTmpcicloparcialEspera().floatValue());
		}

		float logTempoCiclo = tempoCiclo;
		boolean isComTmpParcial = false;
		if ((prup.getCfginterrupcaociclo() != null && prup.getCfginterrupcaociclo().equals('2')) || (prup.getCfgtamanhoumpacoteciclos() != null && prup.getCfgtamanhoumpacoteciclos().doubleValue() > 1d)) {
			if ((prup.getTmpcicloparcial() != null) && (isCicloEmRegulagem == false)) {
				tempoCiclo = tempoCiclo - prup.getTmpcicloparcial().floatValue();
				if (tempoCiclo < 0) {
					log.info("..::(Tempo de Ciclo negativo devido a TmpcicloParcial)::.. " + String.valueOf(tempoCiclo) + "s");
					tempoCiclo = logTempoCiclo;
					prup.setTmpcicloparcial(0d);
				} else
					isComTmpParcial = true;
			}
		}

		//SHINTANI20190719-15H00 (!isCicloEmRegulagem && (tempoCiclo > tempoLimite) && (prup.getCfgperctmpcicloparauto()>0d)) { ////SHINTANI20190719-15H00 a pedido de Fabricio para atender Alessandro/Cesar/Shintani, alterado para especializacao apenas para casos % acima 100%
		//SHINTANI20190719-15H00 a pedido de Fabricio para atender Alessandro/Cesar/Shintani, alterado para especializacao apenas para casos % acima 100% . Ocorria uma inconsistencia nos tempos ciclos Shintane que definia limites-ab-parada menor que 100%, na realidade definiam lah 20%.
		//SHINTANI20190719-15H00 ... no caso acima, Fabricio localizou este trecho e requereu liberacao de um CLASS para dispobibilizar ao Alessandro remotamente. 
		if (!isCicloEmRegulagem && (tempoCiclo > tempoLimite) && (prup.getCfgperctmpcicloparauto()>=100d)) { ////SHINTANI20190719-15H00 a pedido de Fabricio para atender Alessandro/Cesar/Shintani, alterado para especializacao apenas para casos % acima 100%
			// Valor de ciclo acima do limite, se n�o for parada de regulagem h?
			// este caso s� deve ocorrer se for Regulagem ou Maquina sem parada automatica
			// algo de errado!
			inf12 = "1";
			inf13 = DataHoraRN.dateToStringYYYYMMDDHHMMSSms(prup.getDthrinicicComMilisegundos());
			Double segundosAdic = new Double(DataHoraRN.getQuantidadeSegundosNoPeriodo(prup.getDthrinicicComMilisegundos(), dthrFimCiclo) - tempoLimite);
			if (isComTmpParcial) {
				segundosAdic -= prup.getTmpcicloparcial();
			}
			log.info("prup.getCfgperctmpcicloparauto = " + prup.getCfgperctmpcicloparauto());
			log.info("TempoLimite = " + tempoLimite);
			log.info("TempoCiclo = " + tempoCiclo);
			log.info("..::(CICLO TRUNCADO)::.. " + String.valueOf(tempoLimite - tempoCiclo) + "s");
			Date novoInicioCiclo = DataHoraRN.somaSegundos(prup.getDthrinicicComMilisegundos(), segundosAdic.intValue());
			log.info(idLog, 0, "salvando novo inicio de ciclo pois truncou = " + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(novoInicioCiclo));
			prup.setDthrinicic(novoInicioCiclo);
			prup.setMsdthrinicic((double) DataHoraRN.getApenasMilisegundos(novoInicioCiclo));
			tempoCiclo = tempoLimite;
			
			// Lancar um inicio de ciclo para o IDW tb
			if (IdwFacade.getInstancia().isIDWAtivo() == true && isCicloValido == true) {
				log.info(idLog, 0, "Vou lancar o ciclo no idw");
				// Caso ocorra qualquer problema, o processo nao deve parar e seguir em frente pra finalizar execucao do metodo
					ProducaoPdbaMsEvtRN idwRN = new ProducaoPdbaMsEvtRN();
						idwRN.executarServico(getDaoPdba().getSession(), prup.getIdup().toString(), null, novoInicioCiclo, null, null, ServicoFactory._INICIO_CICLO, "fecharCiclo " + DataHoraRN.getDataHoraAtualFormatada());
				log.info(idLog, 0, "Lancei o inicio de ciclo no idw em " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(novoInicioCiclo));
			}
		}

		if (prup.getNrop() == null) {
			inf17 = "SEM OP";
			isCicloValido = false;
		}

		try {
			tempoCicloTimeout = prup.getTmpciclopadrao() * (prup.getCfgperctoleranciasinalciclo() / 100);
			if(tempoCicloTimeout<1){
				log.info("Tempo de Timout menor que 1 segundo, referencia sendo setada para 1 segundo");
				tempoCicloTimeout=1;
			}
		} catch (Exception e) {
			tempoCicloTimeout = 1;
		}

		// Se sim, Tempo do ciclo inv�lido? Tempo de ciclo deve ser superior ao
		// tempo tolerado de ciclo.cfgPercToleranciaSinalCiclo
		if (tempoCiclo < tempoCicloTimeout) {
			isCicloValido = false;
		}
		
		/* Alessandre em 12-12-17 se o ciclo for invalido, mas o infoAdicional estiver registrando que o inicio do ciclo
		 * foi gravado pela leitura do codigo de barras, entao devemos aceitar o ciclo
		 */
		if (isCicloValido == false && prup.getInfoAdicional() != null && prup.getInfoAdicional().trim().equals("inicioBarcode")) {
			isCicloValido = true;
		}
		
		
		log.info(idLog, 0, "isCicloValido = " + isCicloValido);
		log.info(idLog, 0, " lancando FIM CICLO em inicia " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(prup.getDthrinicic()) + " termina " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrFimCiclo));
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setTpevento(new BigDecimal(7));

		prcoletoreventos.setDthr1evento(prup.getDthrinicic());
		prcoletoreventos.setMsdthr1evento(prup.getMsdthrinicic());

		prcoletoreventos.setDthr2evento(dthrFimCiclo);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dthrFimCiclo));

		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setInf01(String.valueOf(tempoCiclo));
		if (QtdBatidas <= 0)
			prcoletoreventos.setInf02("1");
		else
			prcoletoreventos.setInf02(String.valueOf(QtdBatidas));

		if (isCicloEmRegulagem == true)
			prcoletoreventos.setInf03("3");
		else if (isCicloFechadoPorParada == true) {
			prcoletoreventos.setInf03("1"); // o dois eh obsoleto
			prcoletoreventos.setInf20("par fechou cic");
		} else
			prcoletoreventos.setInf03("1");

		prcoletoreventos.setInf04("tmpcicparcial=" + prup.getTmpcicloparcial());
		prcoletoreventos.setInf05(origem);
		prcoletoreventos.setInf06(String.valueOf(tempoCicloEspera));
		prcoletoreventos.setInf07(prup.getCfgperctoleranciasinalciclo().toString());

		if (prup.getTmpciclopadrao() != null)
			prcoletoreventos.setInf08(prup.getTmpciclopadrao().toString());

		prcoletoreventos.setInf09(("tmpCic=" + String.valueOf((int) logTempoCiclo)));


		if (isMonitorandoCicloEmEspera)
			prcoletoreventos.setInf10("tmpCicAtiv=" + String.valueOf((int) tempoCicloAtivo));
		else
			prcoletoreventos.setInf10("0");

		prcoletoreventos.setInf11("tmpcicparaux=" + prup.getTmpcicloparcialaux());
		prcoletoreventos.setInf12(inf12);
		prcoletoreventos.setInf13(inf13);
		prcoletoreventos.setInf14(String.valueOf((int) tempoLimite));
		prcoletoreventos.setInf15(String.valueOf(prup.getCfgtamanhoumpacoteciclos().intValue()));
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setInf17(inf17);
		prcoletoreventos.setInf18(prup.getInfoAdicional());
		IwsDadosApontamentoDTO dados = prup.obtemDadosApontamento();			
		preencheInf19eInf20EventoCiclo(log, idLog, prcoletoreventos,dados);			

		// Se o ciclo que esta sendo lancado for feito para uma UP sem OP entao
		// o ciclo deve ir com o status 3 e como tipo 95
		if (isCicloValido == false) {
			prcoletoreventos.setTpevento(new BigDecimal(95));
			prcoletoreventos.setStevento("3");
			prcoletoreventos.setInf07(prup.getCfgperctoleranciasinalciclo().toString());
			if (prup.getTmpciclopadrao() != null)
				prcoletoreventos.setInf08(prup.getTmpciclopadrao().toString());
			prcoletoreventos.setInf09("tmoCic="+ String.valueOf((int) logTempoCiclo));
		} else {
			prup.setTmpcicloparcial(0d);
			prup.setTmpcicloparcialaux(0d);
		}

		lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
		
		// Apos lancar PR_COLETOR_EVENTOS verificar se o IDW est� ativo. Se sim, chamar o servico de ciclo do IDW para que ms_evt seja lancada
		// Alessandre: 3-11-14 acrescenti no if abaixo o teste se o ciclo ? valido. Se n?o for valido, n?o ser? lancado no idw.
		if (IdwFacade.getInstancia().isIDWAtivo() == true && isCicloValido == true) {
			log.info(idLog, 0, "Vou lancar o ciclo no idw");
			// Caso ocorra qualquer problema, o processo nao deve parar e seguir em frente pra finalizar execucao do metodo
				ProducaoPdbaMsEvtRN idwRN = new ProducaoPdbaMsEvtRN();
					idwRN.executarServico(getDaoPdba().getSession(), prup.getIdup().toString(), null, dthrFimCiclo, null, null, ServicoFactory._FIM_CICLO, "fecharCiclo " + DataHoraRN.getDataHoraAtualFormatada());
			log.info(idLog, 0, "Lancei o ciclo no idw");
		}

		// H� dados novos em PR_UP_CONFIGURACOES
		log.info(idLog, 0, "vou chamar atualizarPrUpConfiguracoes");
		atualizarPrUpConfiguracoes(log, idLog, prup);

		// Limpa os campos de inicio do ciclo em PR_UP
		if (isCicloValido || prup.getNrop() == null) {
			log.info(idLog, 0, "limpando inicio do ciclo da prup 1");
			prup.setDthrinicic(null);
			prup.setMsdthrinicic(0d);
			// Adicionado para tratamaneto de tempo de espera by Senoj
			prup.setDthrfimcic(null);
			prup.setMsdthrfimcic(0d);
			prup.setStcicloemaberto('0');
		} else {
			log.info(idLog, 0, "limpando inicio do ciclo da prup 2");
			// Removido atualiza��o de dthrinicic
			// Adicionado para tratamaneto de tempo de espera by Senoj
			prup.setDthrfimcic(null);
			prup.setMsdthrfimcic(0d);
		}

		// Incrementar PR_UP.QtdCiclosExecutados
		if (isCicloValido) {
			if (prup.getQtdciclosexecutados() == null)
				prup.setQtdciclosexecutados(new BigDecimal(1));
			else
				prup.setQtdciclosexecutados(prup.getQtdciclosexecutados().add(new BigDecimal(1)));

			// Atualiza Efici�ncia de Ciclo
			if ((tempoCiclo > 0) && (prup.getTmpciclopadrao() != null))
				prup.setvleficultciclo(prup.getTmpciclopadrao() / tempoCiclo * 100.0);
			else
				prup.setvleficultciclo(0.0);

		} 
		
		log.info(idLog, 0, "merge em prup");

		this.getDaoPdba().makePersistent(prup);		

		//setFimDecicloEmEspera(prup, dthrFimCiclo);

		return isCicloValido;
	}

	private void preencheInf19eInf20EventoCiclo(
			IdwLogger log, int idLog,
			PrColetorEventos prcoletoreventos,IwsDadosApontamentoDTO dados){
		
		if(dados == null || dados.getListaVariacoes()==null || dados.isDeveInformarApont()==false){
			return;
		}
		int i=0;
		String Inf19="",Inf20="";
		for(IwsVariacaoRitmoValidaDTO ovar : dados.getListaVariacoes()){
			if(ovar.getCdVariacaoRitmo()!=null && ovar.getCdVariacaoRitmo().length()==6 && ovar.getQuantidade()>0){
				if(validaMotivoVariacaoRitmo(ovar.getCdVariacaoRitmo()).getIsVariacaoValida()==false){
					log.info("Considerou o c�digo de Varia��o de Ritmo: "+ovar.getCdVariacaoRitmo()+" Inv�lido");
					ovar.setCdVariacaoRitmo("999999");
				}
				if(i<3){
					Inf19 +=ovar.getCdVariacaoRitmo()+":"+ String.valueOf(ovar.getQuantidade())+";";
				}else{
					Inf20 +=ovar.getCdVariacaoRitmo()+":"+ String.valueOf(ovar.getQuantidade())+";";
				}
				i++;				
			}
		}
		if(i>0){
			prcoletoreventos.setInf19(Inf19);
			prcoletoreventos.setInf20(Inf20);
		}

	}

	public void atualizarPrUpConfiguracoes(IdwLogger log, int idLog, PrUp prup) {
		MapQuery q2 = new MapQuery(getDaoPdba().getSession());
		q2.append("select prupconfiguracoes ");
		q2.append("from PrUpConfiguracoes prupconfiguracoes ");
		q2.append("where prupconfiguracoes.prUp.idup = :idup ");

		q2.defineParametro("idup", prup.getIdup());

		List<PrUpConfiguracoes> lista = q2.list();

		for (PrUpConfiguracoes prupconfiguracoes : lista) {
			// CfgTamanhoUmPacoteCiclos
			// CfgPercTmpCicloParAuto
			// CfgPercToleranciaSinalCiclo
			// CfgPercTmpCicloInicializacao
			// CfgInterrupcaoCiclo
			// CfgDbc
			// TmpCicloPadrao
			// cfgTolerTmpCicloParAuto

			if (prupconfiguracoes.getIdregsubcoletor() != null) {
				q2.novaConsulta();
				q2.append("select prsubcoletor ");
				q2.append("from PrSubColetor prsubcoletor ");
				q2.append("where prsubcoletor.idregsubcoletor = :idregsubcolect ");

				q2.defineParametro("idregsubcolect", prupconfiguracoes.getIdregsubcoletor());
				q2.setMaxResults(1);

				PrSubColetor prsubcoletor = (PrSubColetor) q2.uniqueResult();
				prup.setPrSubColetor(prsubcoletor);
				log.info(idLog, 0, "Alterando prup.prsubcoletor");
			}
			if (prupconfiguracoes.getCfgdbc() != null) {
				prup.setCfgdbc(prupconfiguracoes.getCfgdbc());
				log.info(idLog, 0, "Alterando prup.cfgdbc");
			}

			if (prupconfiguracoes.getCfginterrupcaociclo() != null) {
				prup.setCfginterrupcaociclo(prupconfiguracoes.getCfginterrupcaociclo());
				log.info(idLog, 0, "Alterando prup.cfginterrupcaociclo");
			}


			if (prupconfiguracoes.getCfgperctmpcicloinicializacao() != null) {
				prup.setCfgperctmpcicloinicializacao(prupconfiguracoes.getCfgperctmpcicloinicializacao());
				log.info(idLog, 0, "Alterando prup.cfgperctmpcicloinicializacao");
			}


			if (prupconfiguracoes.getCfgperctoleranciasinalciclo() != null) {
				prup.setCfgperctoleranciasinalciclo(prupconfiguracoes.getCfgperctoleranciasinalciclo());
				log.info(idLog, 0, "Alterando prup.cfgperctoleranciasinalciclo");
			}


			if (prupconfiguracoes.getCfgperctmpcicloparauto() != null) {
				prup.setCfgperctmpcicloparauto(prupconfiguracoes.getCfgperctmpcicloparauto());
				log.info(idLog, 0, "Alterando prup.cfgperctmpcicloparauto");
			}


			if (prupconfiguracoes.getCfgtamanhoumpacoteciclos() != null) {
				prup.setCfgtamanhoumpacoteciclos(prupconfiguracoes.getCfgtamanhoumpacoteciclos());
				log.info(idLog, 0, "Alterando prup.cfgtamanhoumpacoteciclo");
			}


			if (prupconfiguracoes.getCfgtpsessaoproducao() != null) {
				prup.setCfgtpsessaoproducao(prupconfiguracoes.getCfgtpsessaoproducao());
				log.info(idLog, 0, "Alterando prup.cfgtpsessaoproducao");
			}

			if (prupconfiguracoes.getTmpciclopadrao() != null) {
				prup.setTmpciclopadrao(prupconfiguracoes.getTmpciclopadrao());
				log.info(idLog, 0, "Alterando prup.tmpciclopadrao");
			}

			// vlauria 20100202
			if (prupconfiguracoes.getCfgtolertmpcicloparauto() != null) {
				if (prupconfiguracoes.getCfgtolertmpcicloparauto() != 0) {
					prup.setCfgtolertmpcicloparauto(prupconfiguracoes.getCfgtolertmpcicloparauto().longValue());
					log.info(idLog, 0, "Alterando prup.cfgtoretmpcicloparauto");
				}

			}

			log.info(idLog, 0, "makePersiste em prUpConfiguracoes");
			prupconfiguracoes.getPrEventosBridgeCollecDb().setStevento("1");
			this.getDaoPdba().makePersistent(prupconfiguracoes.getPrEventosBridgeCollecDb());

			// Alessandre: em 12-02-15 comentei o mege abaixo para evitar o SNAPSHOT
			// mas acredito que pelo fato do flushReiniciando logo abaixo eh q esteja causando o problema
			//this.getDaoPdba().getSession().merge(prup); // Nao eh necessario no
														// momento, mais a
														// frente na execucao ter� um merge em
			// momento, mais a
														// frente na execucao terï¿½ um merge em
														// prup

			this.getDaoPdba().getSession().delete(prupconfiguracoes);
			
			//Alessandre me 12-02-15 Removi para que o comite ocorra somente no final de toda a transacao
			//this.getDaoPdba().flushReiniciandoTransacao(); // APAGAR
		}

	}

	public PrColetorEventos lancarEventoEsperaPrColetorEventos(
			IdwLogger log, int idLog,
			PrColetorEventos prcoletoreventos, boolean isEsperaRetorno) {
		
		log.info(idLog, 0, "entrei em lancarEventosEsperaPrColetorEventos com flag = " + isEsperaRetorno);
		
		if (prcoletoreventos.getStevento() == null || !prcoletoreventos.getStevento().equals("3"))
			prcoletoreventos.setStevento("0");

		if (prcoletoreventos.getDthr2evento() == null) {
			if (prcoletoreventos.getDthr1evento() == null) {
				Date dataHoraAtual = DataHoraRN.getDataHoraAtual(this.getDaoPdba());
				prcoletoreventos.setDthr1evento(dataHoraAtual);
				prcoletoreventos.setMsdthr1evento((double) DataHoraRN.getApenasMilisegundos(dataHoraAtual));
				log.info(idLog, 0, "dthr1evento � null vou usar a hora atual " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dataHoraAtual));
			}
			log.info(idLog, 0, "vou colocar dthr1evento de prcoletoreventos que eh " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(prcoletoreventos.getDthr1evento()) + " em dthr2evento");
			prcoletoreventos.setDthr2evento(prcoletoreventos.getDthr1evento());
			prcoletoreventos.setMsdthr2evento(prcoletoreventos.getMsdthr1evento());
		}

		// TODO: VERIFICAR RESTRICOES, tipo NOT NULL
		if ((prcoletoreventos.getPrUp() == null) || (prcoletoreventos.getPrUp().getIdup().toString() == null))
			log.error("id up nulo");
		
		if ((prcoletoreventos.getTpevento() == null))
			log.error("TpEvento nulo");

		this.getDaoPdba().getSession().save(prcoletoreventos);

		log.info(idLog, 0, "saindo de lancarEventosEsperaPrColetorEventos com flag = " + isEsperaRetorno);

		return (prcoletoreventos);
	}

	/* Alessandre em 06-12-17. Esse metodo foi criado para atender o cancelamento de refugo que precisa saber se o cancelamento foi
	 * executado com sucesso.
	 */
	private PrColetorEventos lancarEventoRetornaPrColetorEventosConsolidado(
			IdwLogger log, int idLog,
			PrColetorEventos prcoletoreventos, boolean isComTimeout) {
		
		log.info(idLog, 0, "entrei em lancarEventoRetornaPrColetorEventosConsolidado com timeout = " + isComTimeout);
		
		if (prcoletoreventos.getStevento() == null || !prcoletoreventos.getStevento().equals("3"))
			prcoletoreventos.setStevento("0");

		if (prcoletoreventos.getDthr2evento() == null) {
			if (prcoletoreventos.getDthr1evento() == null) {
				Date dataHoraAtual = DataHoraRN.getDataHoraAtual(this.getDaoPdba());
				prcoletoreventos.setDthr1evento(dataHoraAtual);
				prcoletoreventos.setMsdthr1evento((double) DataHoraRN.getApenasMilisegundos(dataHoraAtual));
				log.info(idLog, 0, "dthr1evento � null vou usar a hora atual " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dataHoraAtual));
			}
			log.info(idLog, 0, "vou colocar dthr1evento de prcoletoreventos que eh " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(prcoletoreventos.getDthr1evento()) + " em dthr2evento");
			prcoletoreventos.setDthr2evento(prcoletoreventos.getDthr1evento());
			prcoletoreventos.setMsdthr2evento(prcoletoreventos.getMsdthr1evento());
		}

		// TODO: VERIFICAR RESTRICOES, tipo NOT NULL
		if ((prcoletoreventos.getPrUp() == null) || (prcoletoreventos.getPrUp().getIdup().toString() == null))
			log.error("id up nulo");
		
		if ((prcoletoreventos.getTpevento() == null))
			log.error("TpEvento nulo");

		prcoletoreventos = (PrColetorEventos) this.getDaoPdba().makePersistent(prcoletoreventos);
		
		getDaoPdba().flushReiniciandoTransacao();
		
		Integer idEvento = prcoletoreventos.getIdeventocoletor();
		
		MapQuery q = new MapQuery(getDaoPdba().getSession());
		
		q.append("select a");
		q.append("from PrColetorEventos a");
		q.append("where a.ideventocoletor = :id");
		
		Date inicio = DataHoraRN.getDataHoraAtual();
		// Aguardar processamento do evento pelo BC
		while (isComTimeout) {
			getDaoPdba().flush();
			getDaoPdba().flushReiniciandoTransacao();
			getDaoPdba().clear();
			UtilRN.pausaNaThread(UtilRN.TEMPO_MEDIO_TRATRAMENTO_BC);
			q.defineParametro("id", idEvento);
			prcoletoreventos = (PrColetorEventos) q.uniqueResult();
			if (prcoletoreventos.getStevento().equals("0") == false)
				isComTimeout = false;
			else if (DataHoraRN.getQuantidadeSegundosNoPeriodo(inicio, DataHoraRN.getDataHoraAtual()) > 60) {
				isComTimeout = false;
			}
		}

		log.info(idLog, 0, "saindo de lancarEventosEsperaPrColetorEventos com flag = " + isComTimeout);

		return (prcoletoreventos);
	}

	
	public PrEventosBridgeCollecDb lancarEventoEsperaPrEventosBridgeCollecDb(
			IdwLogger log, int idLog,
			PrColetorEventos prcoletoreventos, boolean isComTimeout)
					throws MestreOfflineException {

		PrEventosBridgeCollecDb retorno = null;
		PrColetorEventos prcoletoreventoRetorno = null;

		// Lanca evento
		prcoletoreventoRetorno = lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, true);
		if (isComTimeout == false)
			return null;

		UtilRN.pausaNaThread(UtilRN.TEMPO_MEDIO_TRATRAMENTO_BC);
		this.getDaoPdba().flushReiniciandoTransacao();

		// Espera retorno do evento
		boolean isAguardando = true;
		while (isAguardando) {
			// Obtem o tempo de time-out para espera do mestre e se esta
			// off-line
			String hql = "";

			hql += "select prbridgecollectordatabase ";
			hql += "from PrBridgeCollectorDatabase prbridgecollectordatabase ";
			hql += "join prbridgecollectordatabase.prConexoesInjets prconexoesinjet ";
			hql += "join prconexoesinjet.prUps prups ";
			hql += "where prups.idup = '::idup' ";

			hql = hql.replaceAll("::idup", prcoletoreventos.getPrUp().getIdup().toString());

			Query q = this.getDaoPdba().getSession().createQuery(hql);

			PrBridgeCollectorDatabase mestre = (PrBridgeCollectorDatabase) q.uniqueResult();

			// Se mestre estiver on-line pode-se sair do loop
			if (mestre.getStonline() == '1') {
				isAguardando = false;
			}

			hql = "";

			hql += "select preventosbridgecollecdb ";
			hql += "from PrEventosBridgeCollecDb preventosbridgecollecdb ";
			hql += "where preventosbridgecollecdb.prUp.idup = '::idup' and ";
			hql += "preventosbridgecollecdb.ideventocoletor = '::ideventocoletor' ";
			hql += "and preventosbridgecollecdb.stevento = '0' ";

			hql = hql.replaceAll("::idup", prcoletoreventos.getPrUp().getIdup().toString());
			hql = hql.replaceAll("::ideventocoletor", prcoletoreventoRetorno.getIdeventocoletor().toString());

			q = this.getDaoPdba().getSession().createQuery(hql);

			PrEventosBridgeCollecDb eventoRecebido = null;

			List<PrEventosBridgeCollecDb> lista = null;

			lista = q.list();

			if (lista.size() >= 1) {
				eventoRecebido = (PrEventosBridgeCollecDb) lista.get(0);
				if (eventoRecebido != null) {
					eventoRecebido.setStevento("1");
					this.getDaoPdba().getSession().merge(eventoRecebido);
				} else {
					isAguardando = true;
				}
			} else {
				// Se nao tiver retorno do mestre, continuar aguardando retorno
				isAguardando = true;
			}

			// Se mestre estiver com time-out, abortar espera e retornar
			// mensagem de mestre off-line
			if (mestre.getDthrultacessobd() == null || DataHoraRN.getQuantidadeSegundosNoPeriodo(mestre.getDthrultacessobd(), DataHoraRN.getDataHoraAtual(this.getDaoPdba())) > mestre.getTmptimeoutmaster()) {

				this.getDaoPdba().flushReiniciandoTransacao();

				throw new MestreOfflineException();
			}
			retorno = eventoRecebido;			
			UtilRN.pausaNaThread(UtilRN.TEMPO_MEDIO_TRATRAMENTO_BC);
			this.getDaoPdba().flushReiniciandoTransacao();
		}

		// Salva alteracoes

		this.getDaoPdba().flushReiniciandoTransacao();

		return retorno;
	}

	public IwsListaUpDTO setUpBeat(IdwLogger log, int idLog, String mac, Date dthrBeat,boolean isLogoutNaViradaTurno,boolean isFechaParadaNaViradaTurno) throws SemSGBDException, RegistroDesconhecidoException {


		String hql = "";
		hql += "select prcoletor ";
		hql += "from PrColetor prcoletor ";
		hql += "where prcoletor.idcoletor = '::idcoletor' or prcoletor.idcoletor2 = '::idcoletor' ";

		hql = hql.replaceAll("::idcoletor", mac);

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrColetor> listaPrColetor = null;
		try {
			listaPrColetor = q.list();
		} catch (Exception e) {

			throw new SemSGBDException();
		}

		PrColetor prcoletor = null;
		if (listaPrColetor.size() > 1) {
			hql = "";

			hql += "select prup ";
			hql += "from PrUp prup ";
			hql += "join fetch prup.prSubColetor prsubcoletor ";
			hql += "join fetch prsubcoletor.prColetor prcoletor ";
			hql += "where (prcoletor.idcoletor = '::idcoletor' or prcoletor.idcoletor2 = '::idcoletor') and prup.stativa = '1' ";

			hql = hql.replaceAll("::idcoletor", mac);

			q = this.getDaoPdba().getSession().createQuery(hql);

			try {
				if (q.list().size() > 0) {
					PrUp prup = (PrUp) q.list().get(0);
					prcoletor = prup.getPrSubColetor().getPrColetor();
				} else {
					throw new RegistroDesconhecidoException();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RegistroDesconhecidoException();
			}
		} else if (listaPrColetor.size() > 0)
			prcoletor = listaPrColetor.get(0);
		else {
			throw new RegistroDesconhecidoException();
		}

		long milisegundos = DataHoraRN.getApenasMilisegundos(dthrBeat);
		Date dthrBeatGravado = prcoletor.getDthrultacessobd();
		Double msdthrBeatGravado = prcoletor.getMsdthrultacessobd();
		Date dthrBeatWS = DataHoraRN.getDataHoraAtual(this.getDaoPdba());

		if (prcoletor.getDthrultacessobd() == null) {
			prcoletor.setDthrultacessobd(dthrBeat);
			prcoletor.setMsdthrultacessobd((double) milisegundos);
		}
		if (prcoletor.getDthrultacessows() == null) {
			prcoletor.setDthrultacessows(dthrBeatWS);
			prcoletor.setMsdthrultacessobd(new Double(DataHoraRN.getApenasMilisegundos(dthrBeatWS)));
		}

		prcoletor.setDthrultacessobd(dthrBeat);
		prcoletor.setMsdthrultacessobd((double) milisegundos);

		prcoletor.setDthrultacessows(dthrBeatWS);
		prcoletor.setMsdthrultacessows((double) DataHoraRN.getApenasMilisegundos(dthrBeatWS));

		this.getDaoPdba().getSession().merge(prcoletor);
		IwsListaUpDTO listaUpDTO = new IwsListaUpDTO();

		try {
			listaUpDTO = verificaEventos(log, idLog, mac, dthrBeatGravado, msdthrBeatGravado, prcoletor, dthrBeat, dthrBeatWS, isLogoutNaViradaTurno, isFechaParadaNaViradaTurno);
		} catch (ServicoFalhouException e) {
			throw new SemSGBDException();
		}
		return listaUpDTO;
	}

	public void verificaEventoAtivaUP(IdwLogger log, int idLog) throws ServicoFalhouException {
		String hql;
		hql = "";

		hql += "select preventosbridgecollecdb ";
		hql += "from PrEventosBridgeCollecDb preventosbridgecollecdb ";
		hql += "join fetch preventosbridgecollecdb.prUp prup ";
		hql += "where ";
		hql += "preventosbridgecollecdb.stevento = '0' and ";
		hql += "preventosbridgecollecdb.tpevento = 18 ";
		hql += "order by preventosbridgecollecdb.dthrevento ";

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrEventosBridgeCollecDb> listaPrEventos = null;

		listaPrEventos = q.list();

		if (listaPrEventos.size() >= 1) {
			for (PrEventosBridgeCollecDb eventoRecebido : listaPrEventos) {
				// trata eventoRecebido
				if (eventoRecebido != null) {
					trataEventoRecebido(log, idLog, eventoRecebido, eventoRecebido.getPrUp());
					eventoRecebido.setStevento("1");
					this.getDaoPdba().getSession().merge(eventoRecebido);
				}
			}
		}	

		q = null;
		listaPrEventos = null;
		hql = null;
	}

	private void verificaEventoDesativacao(IdwLogger log, int idLog, String mac) throws ServicoFalhouException {
		String hql;
		hql = "";

		hql += "select preventosbridgecollecdb ";
		hql += "from PrEventosBridgeCollecDb preventosbridgecollecdb ";
		hql += "join fetch preventosbridgecollecdb.prUp prup ";
		hql += "where ";
		hql += "preventosbridgecollecdb.stevento = '0' and ";
		hql += "preventosbridgecollecdb.tpevento = 17 ";
		hql += "order by preventosbridgecollecdb.dthrevento ";

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrEventosBridgeCollecDb> listaPrEventos = null;

		listaPrEventos = q.list();

		if (listaPrEventos.size() >= 1) {
			for (PrEventosBridgeCollecDb eventoRecebido : listaPrEventos) {
				// trata eventoRecebido
				if (eventoRecebido != null) {
					trataEventoRecebido(log, idLog, eventoRecebido, eventoRecebido.getPrUp());
					eventoRecebido.setStevento("1");
					this.getDaoPdba().getSession().merge(eventoRecebido);
				}
			}
		}

		q = null;
		listaPrEventos = null;
		hql = null;
	}

	private IwsListaUpDTO verificaEventos(
			IdwLogger log, int idLog,
			String mac, Date dthrBeatGravado,
			Double msdthrBeatGravado, PrColetor prcoletor, Date dthrBeat,
			Date dthrWS,boolean isLogoutNaViradaTurno,boolean isFechaParadaNaViradaTurno) throws ServicoFalhouException {

		// Trata evento 18 (ativa UP). Deve-se tratar esse evento aqui pois a UP
		// que est� sendo reativa na estar� na lista prups abaixo e
		// ter�
		// que
		// estar caso esteja sendo reativada
		verificaAtualizacoes(log, idLog, mac);
		verificaEventoDesativacao(log, idLog, mac);

		this.getDaoPdba().flushReiniciandoTransacao();

		// novos parmetros
		// List<AndonReleDTO> paramsAndonDTOToSetInListaUpDTO = new
		// ArrayList<AndonReleDTO>();
		// parmetros atuais
		// List<AndonReleDTO> listaAndonReleCorrente = new
		// ArrayList<AndonReleDTO>();

		IwsListaUpDTO listaUpDTO = new IwsListaUpDTO();
		// Obtem a lista de UPs
		List<PrUp> prups = null;
		IwsReleDTO Rele01 = null;
		IwsReleDTO Rele02 = null;
		IwsReleDTO Rele03 = null;
		IwsReleDTO Rele04 = null;
		IwsReleDTO Rele05 = null;
		IwsReleDTO RespRele = new IwsReleDTO();
		IwsAndonReleDTO RespReleAndon = new IwsAndonReleDTO();
		try {
			prups = getPrUpsTodas(log, idLog, mac);
		} catch (SemSGBDException e) {
			listaUpDTO.setIsSGBDOnline(true);
		}
		
		if (prups == null)
			prups = new ArrayList<PrUp>();

		// Obtem o intervalo do ultimo heart-beat
		for (PrUp prup : prups) {
			if (prup.getDthrinicic() != null)
				log.info(idLog, 0, "Inicio do Ciclo para " + prup.getIdup() + " = " + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(prup.getDthrinicic()));
			else
				log.info(idLog, 0, "Inicio do Ciclo para " + prup.getIdup() + " eh null");

			String eventosASeremTratados = "";
			prup.mudaDtHrReferenciaParaEventos(dthrBeat);
			prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(dthrBeat));
			prup.mudaLogoutNaViradaTurno(isLogoutNaViradaTurno);
			prup.mudaFechaParadaNaViradaTurno(isFechaParadaNaViradaTurno);
			if (prup.getStativa() == '1') {

				prup.mudaDtHrUltimoHeartBeat(dthrBeat);
				prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(dthrBeat));
				eventosASeremTratados = "'1', '5', '15', '17', '18', '21','22','24', '29', '30', '32',"
						+ "'38', '37', '39', '40', '43', '44', '45', '47'"; // vlauria
				// 20100318/20100319/20100322/20100506
				// senoj 20100812 adicionado tratamento de evento 47 - limpa
				// dados de OP
			} else {
				eventosASeremTratados = "'18'";
			}
			String hql = "";

			hql += "select preventosbridgecollecdb ";
			hql += "from PrEventosBridgeCollecDb preventosbridgecollecdb ";
			hql += "where preventosbridgecollecdb.prUp.idup = '::idup' and ";
			hql += "preventosbridgecollecdb.stevento = '0' and ";
			hql += "preventosbridgecollecdb.tpevento in (::eventosASeremTratados) ";
			hql += "order by preventosbridgecollecdb.dthrevento ";

			hql = hql.replaceAll("::idup", prup.getIdup().toString());
			hql = hql.replaceAll("::eventosASeremTratados",
					eventosASeremTratados);

			Query q = this.getDaoPdba().getSession().createQuery(hql);

			List<PrEventosBridgeCollecDb> lista = null;
			lista = q.list();

			try{
				prup.mudaIsAlertaProbQuali(setTr_buscaAleraProbQuali(prup.getCdmaquina()));
			}catch(SemSGBDException erro){
				log.info("*************Erro em setTr_buscaAleraProbQuali("+prup.getCdmaquina()+")");
			}
			prup.mudaResultadoUltimaInspecao(buscaResulUltimaInsp(prup));

			boolean isInspPending = false;
			if (prup.getStativa() == '1' && prup.getNrop() != null) {
				try {
					isInspPending = consultaAlertaInspecao(prup);
				} catch (Exception e) {
					e.printStackTrace();
					isInspPending = false;
				}

				prup.mudaInspecaoPendente(isInspPending);
			}

			try {
				InjetAlertaRN aRn = new InjetAlertaRN(this.getDaoInjet());
				prup.mudaListaAlertasEmAberto(aRn.pesquisaAlertasEmAberto(log, idLog, prup.getCdmaquina()));
				prup.mudaListaAlertasDiarioDeBordo(aRn.pesquisaAlertasAptDiariodeBordo(log, idLog, prup.getCdmaquina()));
				aRn = null;
			} catch (SemSGBDException e1) {
				e1.printStackTrace();
			}

			this.getDaoPdba().flushReiniciandoTransacao();
			ModRN modrn = new ModRN(getDaoInjet(),getDaoPdba());
			List<IwsModDTO> listaLogins = null;
			try {
				listaLogins = modrn.getTr_balanceamentoLogin(prup, dthrBeat, getStBcOnline(prup.getIdup().toString()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.getDaoPdba().flushReiniciandoTransacao();
			prup.mudaListaLoginsEmAberto(listaLogins);
			modrn = null;
			if (lista.size() >= 1) {
				for (PrEventosBridgeCollecDb eventoRecebido : lista) {
					// trata eventoRecebido
					if (eventoRecebido != null) {
						RespReleAndon = trataEventoRecebido(log, idLog, eventoRecebido, prup, listaUpDTO);
						eventoRecebido.setStevento("1");

						this.getDaoPdba().getSession().merge(eventoRecebido);
						if (RespReleAndon.getRelayFromBeat() != null) {
							RespRele.copyFromAndonReleDto(RespReleAndon);
						} else if (RespReleAndon.getIsInspecaoPendente() != null) {
							/*
							 * set/clear de inspeo pendente
							 */
							if (RespReleAndon.getIsInspecaoPendente() == true)
								prup.mudaInspecaoPendente(true);
							else
								prup.mudaInspecaoPendente(false);
						} else if (RespReleAndon
								.getIsComAlertaProblemaQualidade() != null) {
							/*
							 * set/clear do alerta de problema de qualidade
							 */
							prup.mudaIsAlertaProbQuali(RespReleAndon.getIsComAlertaProblemaQualidade());							
						} else if (RespReleAndon.getResultadoUltimaInspecao() != null) {
							/*
							 * modifica resultado da ltima inspeo
							 */
							prup.mudaResultadoUltimaInspecao(RespReleAndon.getResultadoUltimaInspecao());
						}

						if (RespRele != null && RespRele.getINF01() != null) {
							switch (Integer.parseInt(RespRele.getINF01())) {
							case 0:
								Rele01 = new IwsReleDTO();
								Rele01.setINF01("1");
								Rele01.setINF02("0");
								Rele01.setINF03("0");
								Rele01.setINF04("0");
								Rele01.setINF05("0");
								Rele02 = new IwsReleDTO();
								Rele02.setINF01("2");
								Rele02.setINF02("0");
								Rele02.setINF03("0");
								Rele02.setINF04("0");
								Rele02.setINF05("0");
								Rele03 = new IwsReleDTO();
								Rele03.setINF01("3");
								Rele03.setINF02("0");
								Rele03.setINF03("0");
								Rele03.setINF04("0");
								Rele03.setINF05("0");
								Rele04 = new IwsReleDTO();
								Rele04.setINF01("4");
								Rele04.setINF02("0");
								Rele04.setINF03("0");
								Rele04.setINF04("0");
								Rele04.setINF05("0");
								Rele05 = new IwsReleDTO();
								Rele05.setINF01("5");
								Rele05.setINF02("0");
								Rele05.setINF03("0");
								Rele05.setINF04("0");
								Rele05.setINF05("0");
								break;
							case 1:
								Rele01 = new IwsReleDTO();
								Rele01 = RespRele;
								break;
							case 2:
								Rele02 = new IwsReleDTO();
								Rele02 = RespRele;
								break;
							case 3:
								Rele03 = new IwsReleDTO();
								Rele03 = RespRele;
								break;
							case 4:
								Rele04 = new IwsReleDTO();
								Rele04 = RespRele;
								break;
							case 5:
								Rele05 = new IwsReleDTO();
								Rele05 = RespRele;
								break;
							}
						}
					}
				}
			}
			VerificaIsEmRegulagem(log, idLog, prup);
			verificaStatusVariacaoRitmo(prup);
			this.getDaoPdba().getSession().merge(prup);
			verificaIsComCIP(log, idLog, prup);
			List<IwsAndonDTO> listaAndonCorrente = new ArrayList<IwsAndonDTO>();
			try {
				if (getStatusPrUpAndon(prup.getIdup().toString(), false)) 
				{
					listaAndonCorrente = getTr_ListaDadosAndon(log, idLog, prup);
				}
			} catch (SemSGBDException e) {
				e.printStackTrace();
			}
			prup.mudaIsInjOuLiner(isMaquinaINJouLINER(prup.getCdmaquina()).getSucesso());
			prup.mudaDadosBC(obtemDadosPrUpDadosBC(prup.getIdup()));
			verificaSeQuebraDeParadaAT(log,idLog,prup,dthrBeat);
			listaUpDTO.setStAndonConfiguravel(verificaStatusAndonConfig(prup));
			listaUpDTO.setStAndonProcessoft(verificaStatusAndonPrcsft(prup));
			listaUpDTO.addFullPrUp(log, idLog, prup, listaAndonCorrente, getDaoInjet(), getDaoPdba());
			try {
				// adicionado by Senoj para tratar diferen�a de hor�rio entre
				// coletor e banco
				long difDtHrMinutos = DataHoraRN.getQuantidadeMinutosNoPeriodo(dthrBeat, DataHoraRN.getDataHoraAtual(this.getDaoPdba()));
				if ((int) difDtHrMinutos > (20) || (int) difDtHrMinutos < (-20)) {
					// Deve lan�ar um evento de log(94) e um evento 20
					// para cada idup atrelada a esse coletor
					PrColetorEventos prcoletoreventos = new PrColetorEventos();
					prcoletoreventos.setTpevento(new BigDecimal(94));

					prcoletoreventos.setDthr1evento(prup.obtemDtHrUltimoHeartBeat());
					prcoletoreventos.setMsdthr1evento(prup.obtemMsDthrUltimoHeartBeat());

					prcoletoreventos.setDthr2evento(prup.obtemDtHrUltimoHeartBeat());
					prcoletoreventos.setMsdthr2evento(prup.obtemMsDthrUltimoHeartBeat());

					prcoletoreventos.setNrop(prup.getNrop());
					prcoletoreventos.setCdmolde(prup.getCdmolde());
					prcoletoreventos.setCdestrutura(prup.getCdestrutura());
					prcoletoreventos.setInf01("Ajuste DtHr");
					prcoletoreventos.setInf02(String.valueOf(difDtHrMinutos));
					prcoletoreventos.setStevento("3");
					prcoletoreventos.setPrUp(prup);
					lancarEventoEsperaPrColetorEventos(log, idLog,prcoletoreventos, false);
					// lança evento 94 somente log
					lancarEventoEsperaPrColetorEventos(log, idLog,prcoletoreventos, false); 
					// lança evento 94 somente log
					// ________________________________________________________________________________________
					// by Senoj

					prcoletoreventos = new PrColetorEventos();
					prcoletoreventos.setTpevento(new BigDecimal(20));

					prcoletoreventos.setDthr1evento(prup.obtemDtHrUltimoHeartBeat());
					prcoletoreventos.setMsdthr1evento(prup.obtemMsDthrUltimoHeartBeat());

					prcoletoreventos.setDthr2evento(prup.obtemDtHrUltimoHeartBeat());
					prcoletoreventos.setMsdthr2evento(prup.obtemMsDthrUltimoHeartBeat());

					prcoletoreventos.setNrop(prup.getNrop());
					prcoletoreventos.setCdmolde(prup.getCdmolde());
					prcoletoreventos.setCdestrutura(prup.getCdestrutura());
					prcoletoreventos.setInf01("Ajuste DtHr");
					prcoletoreventos.setInf02(String.valueOf(difDtHrMinutos));
					prcoletoreventos.setStevento("0");
					prcoletoreventos.setPrUp(prup);
					lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false); // lan�a
																					// evento
																					// 20
					lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false); // lan�a
					// evento
					// 20
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			getDaoPdba().evict(prup);
		}
		listaUpDTO.setRele(Rele01, Rele02, Rele03, Rele04, Rele05);
		return (listaUpDTO);
	}

	private IwsAndonReleDTO trataEventoRecebido(
			IdwLogger log, int idLog,
			PrEventosBridgeCollecDb eventoRecebido, PrUp prup) throws ServicoFalhouException {
		return (trataEventoRecebido(log, idLog, eventoRecebido, prup, null));
	}

	private IwsAndonReleDTO trataEventoRecebido(
			IdwLogger log, int idLog,
			PrEventosBridgeCollecDb eventoRecebido, PrUp prup,
			IwsListaUpDTO listaUpDTO) throws ServicoFalhouException {
		IwsReleDTO RespRele = new IwsReleDTO();
		IwsAndonReleDTO RespReleAndon = new IwsAndonReleDTO();
		// List<AndonDTO> andonlista = new ArrayList<AndonDTO>();

		if (eventoRecebido.getTpevento().equals((new BigDecimal(22)))) {
			return (RespReleAndon);
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(5)))) {
			log.info("*******" + prup.getIdup()
					+ "*******************Atualizando configura��es de UP");
			atualizarPrUpConfiguracoes(log, idLog, prup);
			// getSession().merge(prup);
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(1)))) {
			// seta os rel�s
			// desliga todos os rel�s. 1 - 5
			RespRele.setINF01("0");
			log.info("*******" + prup.getIdup()
					+ "*******************Tratando in�cio do BC");
			if (prup.getNrop() != null) {
				IwsCpDTO isFinalizouPlanejamento = planejamentoEmExecucao(log, idLog, prup, 1d);
				if (isFinalizouPlanejamento.getPlanClose() == true) {
					prup.mudaSemPrograma(true);
				}
				prup.mudaIsComApntSAP(isFinalizouPlanejamento.getIsApntSAPAtivo());
				prup.mudaStatusApntSAP(isFinalizouPlanejamento.getStApntSAP());
			}
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(15)))) {
			prup.mudaIsReiniciarUp(true);
			finalizacaoEventosEmPerdadeSincronia(log, idLog, prup,
					eventoRecebido.getDthrevento(),
					eventoRecebido.getMsdthrevento());

		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(17)))) {

			desativaUp(log, idLog, prup);// deve colocar o idregsubcoletor para null
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(18)))) {

			atualizarPrUpConfiguracoes(log, idLog, prup);
			ativaUp(prup);
		}

		// evento de copiar configuracoes DNC
		if (eventoRecebido.getTpevento().equals((new BigDecimal(21)))) {
			PrUpDncConfiguracoes oPrUpDncConfiguracoes = null;

			try {
				oPrUpDncConfiguracoes = evento21VerificarTabelaConfig(
						eventoRecebido, prup);
			} catch (RegistroDesconhecidoException rde) {
				oPrUpDncConfiguracoes = null;
			} catch (Exception e) {
				oPrUpDncConfiguracoes = null;
				e.printStackTrace();
			}

			if (oPrUpDncConfiguracoes != null) {
				try {
					evento21CopiaApagaDados(oPrUpDncConfiguracoes);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else { // erro, evento informacoes invalidas
				// descarta o evento
			}
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(24)))) {
			try {
				if (prup.getNrop() != null && !prup.getNrop().equals("")) {
					setaAberturadeCIPPendente(log, idLog, eventoRecebido, prup);
				} else {
					log.info("***Evento de abertura de CIP(24) foi desprezado por up:"
							+ prup.getIdup() + " estar sem OP");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(29)))) {
			boolean retorno = verificaStatusAndonConfig(prup); // busca por
			// andon
			// configuravel
			// //vlauria
			// 20100318

			if (retorno == false) {
				if (verificarInfReleEvento29(eventoRecebido)) {
					RespRele.setINF01(eventoRecebido.getInf01());
					RespRele.setINF02(eventoRecebido.getInf02());
					RespRele.setINF03(eventoRecebido.getInf03());
					RespRele.setINF04(eventoRecebido.getInf04());
					RespRele.setINF05(eventoRecebido.getInf05());
				}
			}
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(30)))) {
			PrUpAndonPrcsftConfig oPrUpAndonPrcsftConfig = null;
			PrUpAndonPrcsft oPrUpAndonPrcsft = null;

			try {
				oPrUpAndonPrcsftConfig = evento30VerificarTabelaConfig(
						eventoRecebido, prup);
			} catch (RegistroDesconhecidoException rde) {
				oPrUpAndonPrcsftConfig = null;
			} catch (Exception e) {
				oPrUpAndonPrcsftConfig = null;
				e.printStackTrace();
			}

			if (oPrUpAndonPrcsftConfig != null) {
				try {
					oPrUpAndonPrcsft = evento30CopiaApagaDados(log, idLog, oPrUpAndonPrcsftConfig);
					listaUpDTO.setPrUpAndonPrcsfts(oPrUpAndonPrcsft);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else { // erro, evento informacoes invalidas
				// descarta o evento
			}
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(32)))) {
			if(prup.obtemLogoutNaViradaTurno()==true){
				fecharTodosLogins(log, idLog, prup);
				prup.mudaDeveLiparUsuarios(true);
			}
			if(prup.obtemFechaParadaNaViradaTurno()==true){
				if (prup.getStparadaemaberto() != null
						&& prup.getStparadaemaberto() == '1') {

					Date DataReferencia=DataHoraRN.getDataComMilisegundos(eventoRecebido.getDthrevento(),eventoRecebido.getMsdthrevento());
					// Somente efetua o tratamento da virada se a parada estiver aberta e se a parada tiver iniciado no turno anterior.
					if(DataHoraRN.amountOfSecondsInPeriod(prup.getDthriniultimaparada(),DataReferencia)>1){
						Date dthrBeat=DataHoraRN.getDataComMilisegundos(prup.obtemDtHrUltimoHeartBeat(),prup.obtemMsDthrUltimoHeartBeat());
						prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(DataReferencia));
						prup.mudaDtHrUltimoHeartBeat(DataReferencia);
						fecharParada(log, idLog, prup);// fecha parada

						this.getDaoPdba().flushReiniciandoTransacao();

						PrColetorEventos prcoletoreventos = new PrColetorEventos();
						prcoletoreventos.setTpevento(new BigDecimal(8));
						prcoletoreventos.setDthr1evento(DataReferencia);
						prcoletoreventos.setMsdthr1evento(DataHoraRN.getApenasMilisegundos(DataReferencia));
						prcoletoreventos.setNrop(prup.getNrop());
						prcoletoreventos.setCdmolde(prup.getCdmolde());
						prcoletoreventos.setCdestrutura(prup.getCdestrutura());
						prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
						prcoletoreventos.setPrUp(prup);
						prcoletoreventos.setInf01("1");
						prcoletoreventos.setInf20("evento32ViradaDeTurno");
						lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);// abre parada

						if (IdwFacade.getInstancia().isIDWAtivo()) {
								// Alessandre-tanto o inicio da parada qto o final da para estao
								// chamando o mesmo servico, e o servico ira executar inicio ou fim da parada dependendo do 
								// status de funcionamento da maquina. Encontrar uma forma de dizer q a maq esta trabalhando
								// aqui para q o servico inicio uma parada
								IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(prup.getIdup().toString());
								icupdto.getUpDTO().setUpTrabalhando(true);

								ParadaPdbaMsEvtRN rnpdba = new ParadaPdbaMsEvtRN();
									rnpdba.executarServico(getDaoPdba().getSession(), prup.getIdup().toString(), null, DataReferencia, null, null, ServicoFactory._INICIO_PARADA, "trataEventoRecebido " + DataHoraRN.getDataHoraAtualFormatada());
						}

						prup.mudaParadaEmAberto(true);
						this.getDaoPdba().getSession().merge(prup);	

						this.getDaoPdba().flushReiniciandoTransacao();

						ParadaRN prn = new ParadaRN(this.getDaoInjet(), this.getDaoPdba());											
						prn.setTr_UltimaParadaInicio(log, idLog, prup.getIdup().toString(), DataReferencia, true);						

						prup.mudaDtHrReferenciaParaEventos(dthrBeat);
						prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(dthrBeat));
					}

				}
			}
		}

		if (eventoRecebido.getTpevento().equals(new BigDecimal(37))) { // vlauria
			// 20100322

			if (eventoRecebido.getInf01().equals("QLD001") == true) {
				if (DataHoraRN.validaStringDtHr(eventoRecebido.getInf02())) {
					RespReleAndon.setIdup(prup.getIdup().toString());
					RespReleAndon.setIsComAlertaProblemaQualidade(true);
				}
			}
		}
		if (eventoRecebido.getTpevento().equals((new BigDecimal(38)))) { // vlauria
			// 20100319
			boolean resultado = evento38AlertaInspecao(eventoRecebido, prup);

			if (resultado)
				RespReleAndon.setIsInspecaoPendente(true);
			else
				RespReleAndon.setIsInspecaoPendente(false);

			RespReleAndon.setIdup(prup.getIdup().toString());

		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(39)))) { // vlauria
			// 20100319
			String resultado = "";
			if (prup.getNrop() != null) {
				resultado = consultaResulUltimaInsp(log, idLog, prup, eventoRecebido);
			}
			if (resultado.equals("") || resultado.equals("0")) {
				RespReleAndon.setIdup(prup.getIdup().toString());
				RespReleAndon.setResultadoUltimaInspecao(0);
			} else {
				if (resultado.equals("1")) {
					RespReleAndon.setIdup(prup.getIdup().toString());
					RespReleAndon.setResultadoUltimaInspecao(1);
				}
				if (resultado.equals("2")) {
					RespReleAndon.setIdup(prup.getIdup().toString());
					RespReleAndon.setResultadoUltimaInspecao(2);
				}
				if (resultado.equals("3")) {
					RespReleAndon.setIdup(prup.getIdup().toString());
					RespReleAndon.setResultadoUltimaInspecao(3);
				}
			}
			// RespRele =
			// evento3839ResultadoAlertaInspecao(eventoRecebido,"'4', '5', '6'");
		}		

		if (eventoRecebido.getTpevento().equals((new BigDecimal(43)))) { // vlauria
			// 20100318
			listaUpDTO.setStAndonProcessoft(verificaStatusAndonPrcsft(prup));
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(44)))) { // vlauria
			// 20100319
			listaUpDTO.setStAndonConfiguravel(verificaStatusAndonConfig(prup));
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(45)))) { // vlauria
			// 20100506
			if (eventoRecebido.getInf01() != null) {
				if (eventoRecebido.getInf01().equals("1")) {
					prup.mudaIsComApntSAP("1");
					if (eventoRecebido.getInf02().equals("1")) {
						prup.mudaStatusApntSAP("1");
					} else {
						prup.mudaStatusApntSAP("0");
					}
				} else {
					prup.mudaIsComApntSAP("0");
					prup.mudaStatusApntSAP("0");
				}
			}
		}

		if (eventoRecebido.getTpevento().equals((new BigDecimal(47)))) { // senoj
			// 20100812
			// deve limpar os dados de OP
			if (prup.getNrop() != null && !prup.getNrop().equals("")) {
				// limpa dados
				prup.setNrop(null);
				prup.setNropestendido(null);
				prup.setCdmolde(null);
				prup.setCdestrutura(null);
				prup.setTmpciclopadrao(null);
				prup.setQtdciclosexecutados(null);
				prup.setDthrultimorefugo(null);
				prup.setMsdthrultimorefugo(null);
				prup.setCdultimorefugo(null);
				prup.setIdreduzidaproduto(null);
				prup.setQtdrefugada(null);
				prup.setCdultimaparada(null);
				prup.setDthriniultimaparada(null);
				prup.setMsdthriniultimaparada(null);
				prup.setDthrinicic(null);
				prup.setMsdthrinicic(0d);
				// Adicionado para tratamaneto de tempo de espera by Senoj
				prup.setDthrfimcic(null);
				prup.setMsdthrfimcic(0d);
				prup.setStcicloemaberto('0');
				// faltava limpar campos estendidos
				prup.setCdmolestendido(null);
				prup.setPrUpAlertasEmAbertos(null);
				this.getDaoPdba().getSession().merge(prup);
				setProdLiquida(prup.getIdup().toString(), 0d);
				prup.mudaSemPrograma(true);
				prup.mudaIsReiniciarUp(true);

			}
		}
		return (RespReleAndon);
	}

	private PrUpAndonPrcsft evento30CopiaApagaDados(
			IdwLogger log, int idLog,
			PrUpAndonPrcsftConfig oPrUpAndonPrcsftConfig)
					throws SemSGBDException {
		String hql = "";
		hql += "select prupandonprcsft ";
		hql += "from PrUpAndonPrcsft prupandonprcsft ";
		hql += "where prupandonprcsft.idup = '::idup' ";
		hql = hql.replaceAll("::idup", oPrUpAndonPrcsftConfig.getidup());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrUpAndonPrcsft> listaPrUpAndonPrcsft = null;
		try {
			listaPrUpAndonPrcsft = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		PrUpAndonPrcsft oPrUpAndonPrcsft = null;

		// PrUpAndonPrcsft();
		if (oPrUpAndonPrcsftConfig.getstRele7SldZero() == null)
			oPrUpAndonPrcsftConfig.setstRele7SldZero("0");

		if (oPrUpAndonPrcsftConfig.gettmpRele7LigSldZero() == null)
			oPrUpAndonPrcsftConfig.settmpRele7LigSldZero(0);

		if (oPrUpAndonPrcsftConfig.gettmpRele7DesSldZero() == null)
			oPrUpAndonPrcsftConfig.settmpRele7DesSldZero(0);

		if (listaPrUpAndonPrcsft.size() > 0) { // tem registro, update
			oPrUpAndonPrcsft = listaPrUpAndonPrcsft.get(0);

			oPrUpAndonPrcsft.setidup(oPrUpAndonPrcsftConfig.getidup());
			oPrUpAndonPrcsft.setstRele6(oPrUpAndonPrcsftConfig.getstRele6());
			oPrUpAndonPrcsft.settmpRele6Lig(oPrUpAndonPrcsftConfig
					.gettmpRele6Lig());
			oPrUpAndonPrcsft.settmpRele6Des(oPrUpAndonPrcsftConfig
					.gettmpRele6Des());
			oPrUpAndonPrcsft.setstRele7(oPrUpAndonPrcsftConfig.getstRele7());
			oPrUpAndonPrcsft.settmpLimParNaoInf(oPrUpAndonPrcsftConfig
					.gettmpLimParNaoInf());
			oPrUpAndonPrcsft.settmpRele7Lig(oPrUpAndonPrcsftConfig
					.gettmpRele7Lig());
			oPrUpAndonPrcsft.settmpRele7Des(oPrUpAndonPrcsftConfig
					.gettmpRele7Des());
			oPrUpAndonPrcsft.setstRele8(oPrUpAndonPrcsftConfig.getstRele8());
			oPrUpAndonPrcsft.setvlRefEficUltCiclo(oPrUpAndonPrcsftConfig
					.getvlRefEficUltCiclo());
			oPrUpAndonPrcsft.settmpRele8Lig(oPrUpAndonPrcsftConfig
					.gettmpRele8Lig());
			oPrUpAndonPrcsft.settmpRele8Des(oPrUpAndonPrcsftConfig
					.gettmpRele8Des());
			oPrUpAndonPrcsft.setstRele7SldZero(oPrUpAndonPrcsftConfig
					.getstRele7SldZero());
			oPrUpAndonPrcsft.settmpRele7LigSldZero(oPrUpAndonPrcsftConfig
					.gettmpRele7LigSldZero());
			oPrUpAndonPrcsft.settmpRele7DesSldZero(oPrUpAndonPrcsftConfig
					.gettmpRele7DesSldZero());

			this.getDaoPdba().getSession().update(oPrUpAndonPrcsft);
		} else { // nao tem registro, insere
			log.info(oPrUpAndonPrcsftConfig.getidup() + "---"
					+ oPrUpAndonPrcsftConfig.getstRele6() + "---"
					+ oPrUpAndonPrcsftConfig.gettmpRele6Lig() + "---"
					+ oPrUpAndonPrcsftConfig.gettmpRele6Des() + "---"
					+ oPrUpAndonPrcsftConfig.getstRele7() + "---"
					+ oPrUpAndonPrcsftConfig.gettmpLimParNaoInf() + "---"
					+ oPrUpAndonPrcsftConfig.gettmpRele7Lig() + "---"
					+ oPrUpAndonPrcsftConfig.gettmpRele7Des() + "---"
					+ oPrUpAndonPrcsftConfig.getstRele8() + "---"
					+ oPrUpAndonPrcsftConfig.getvlRefEficUltCiclo() + "---"
					+ oPrUpAndonPrcsftConfig.gettmpRele8Lig() + "---"
					+ oPrUpAndonPrcsftConfig.gettmpRele8Des() + "---"
					+ oPrUpAndonPrcsftConfig.getstRele7SldZero() + "---"
					+ oPrUpAndonPrcsftConfig.gettmpRele7LigSldZero() + "---"
					+ oPrUpAndonPrcsftConfig.gettmpRele7DesSldZero());

			// Pra que existe isso?
			oPrUpAndonPrcsft = new PrUpAndonPrcsft(
					oPrUpAndonPrcsftConfig.getidup(),
					oPrUpAndonPrcsftConfig.getstRele6(),
					oPrUpAndonPrcsftConfig.gettmpRele6Lig(),
					oPrUpAndonPrcsftConfig.gettmpRele6Des(),
					oPrUpAndonPrcsftConfig.getstRele7(),
					oPrUpAndonPrcsftConfig.gettmpLimParNaoInf(),
					oPrUpAndonPrcsftConfig.gettmpRele7Lig(),
					oPrUpAndonPrcsftConfig.gettmpRele7Des(),
					oPrUpAndonPrcsftConfig.getstRele8(),
					oPrUpAndonPrcsftConfig.getvlRefEficUltCiclo(),
					oPrUpAndonPrcsftConfig.gettmpRele8Lig(),
					oPrUpAndonPrcsftConfig.gettmpRele8Des(),
					oPrUpAndonPrcsftConfig.getstRele7SldZero(),
					oPrUpAndonPrcsftConfig.gettmpRele7LigSldZero(),
					oPrUpAndonPrcsftConfig.gettmpRele7DesSldZero());

			this.getDaoPdba().getSession().save(oPrUpAndonPrcsft);
		}

		this.getDaoPdba().getSession().delete(oPrUpAndonPrcsftConfig);

		return (oPrUpAndonPrcsft);
	}

	private PrUpAndonPrcsftConfig evento30VerificarTabelaConfig(
			PrEventosBridgeCollecDb eventoRecebido, PrUp prup)
					throws RegistroDesconhecidoException, SemSGBDException {
		String hql = "";
		hql += "select prupandonprcsftconfig ";
		hql += "from PrUpAndonPrcsftConfig prupandonprcsftconfig ";
		hql += "where prupandonprcsftconfig.idup = '::idup' ";
		hql += "and prupandonprcsftconfig.idEventosBridgeCollecDb = '::idEventosBridgeCollecDb' ";

		hql = hql.replaceAll("::idup", prup.getIdup().toString());
		hql = hql.replaceAll("::idEventosBridgeCollecDb",
				eventoRecebido.getIdeventomasterbridgecollectodb());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrUpAndonPrcsftConfig> listaPrUpAndonPrcsftConfig = null;
		try {
			listaPrUpAndonPrcsftConfig = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		PrUpAndonPrcsftConfig oPrUpAndonPrcsftConfig = null;

		if (listaPrUpAndonPrcsftConfig.size() > 0)
			oPrUpAndonPrcsftConfig = listaPrUpAndonPrcsftConfig.get(0);
		else
			throw new RegistroDesconhecidoException();

		return oPrUpAndonPrcsftConfig;
	}

	private void evento21CopiaApagaDados(
			PrUpDncConfiguracoes oPrUpDncConfiguracoes) throws SemSGBDException {
		String hql = "";
		hql += "select prupdnc ";
		hql += "from PrUpDnc prupdnc ";
		hql += "where prupdnc.idUp = '::idup' ";

		hql = hql.replaceAll("::idup", oPrUpDncConfiguracoes.getidUp());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrUpDnc> listaPrUpDnc = null;
		try {
			listaPrUpDnc = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		PrUpDnc oPrUpDnc = new PrUpDnc();

		if (listaPrUpDnc.size() > 0) { // tem registro, update
			oPrUpDnc = listaPrUpDnc.get(0);
			oPrUpDnc.setStAtivo(oPrUpDncConfiguracoes.getStAtivo());
			oPrUpDnc.setUploadPath(oPrUpDncConfiguracoes.getUploadPath());
			oPrUpDnc.setUploadExt(oPrUpDncConfiguracoes.getUploadExt());
			oPrUpDnc.setDownloadPath(oPrUpDncConfiguracoes.getDownloadPath());
			oPrUpDnc.setDownloadExt(oPrUpDncConfiguracoes.getDownloadExt());
			oPrUpDnc.setSerialPort(oPrUpDncConfiguracoes.getSerialPort());
			oPrUpDnc.setDataBit(oPrUpDncConfiguracoes.getDataBit());
			oPrUpDnc.setStopBit(oPrUpDncConfiguracoes.getStopBit());
			oPrUpDnc.setFlowControl(oPrUpDncConfiguracoes.getFlowControl());
			oPrUpDnc.setRecTimeOut(oPrUpDncConfiguracoes.getRecTimeOut());
			oPrUpDnc.setBaudRate(oPrUpDncConfiguracoes.getBaudRate());
			oPrUpDnc.setParity(oPrUpDncConfiguracoes.getParity());
			oPrUpDnc.setRecIgnBefFrstEOB(oPrUpDncConfiguracoes
					.getRecIgnBefFrstEOB());
			oPrUpDnc.setRecIgnAftLastEOF(oPrUpDncConfiguracoes
					.getRecIgnAftLastEOF());
			oPrUpDnc.setSndStartProg(oPrUpDncConfiguracoes.getSndStartProg());
			oPrUpDnc.setSndEndProg(oPrUpDncConfiguracoes.getSndEndProg());
			oPrUpDnc.setSndEndBlock(oPrUpDncConfiguracoes.getSndEndBlock());
			oPrUpDnc.setSndIgnore(oPrUpDncConfiguracoes.getSndIgnore());
			oPrUpDnc.setSndDelayByte(oPrUpDncConfiguracoes.getSndDelayByte());
			oPrUpDnc.setSndRTS(oPrUpDncConfiguracoes.getSndRTS());
			oPrUpDnc.setSndCnvtUCase(oPrUpDncConfiguracoes.getSndCnvtUCase());
			oPrUpDnc.setSndIgnEmptyBlock(oPrUpDncConfiguracoes
					.getSndIgnEmptyBlock());

			this.getDaoPdba().getSession().update(oPrUpDnc);
		} else {
			oPrUpDnc = new PrUpDnc(oPrUpDncConfiguracoes.getidUp(),
					oPrUpDncConfiguracoes.getStAtivo(),
					oPrUpDncConfiguracoes.getUploadPath(),
					oPrUpDncConfiguracoes.getUploadExt(),
					oPrUpDncConfiguracoes.getDownloadPath(),
					oPrUpDncConfiguracoes.getDownloadExt(),
					oPrUpDncConfiguracoes.getSerialPort(),
					oPrUpDncConfiguracoes.getBaudRate(),
					oPrUpDncConfiguracoes.getDataBit(),
					oPrUpDncConfiguracoes.getParity(),
					oPrUpDncConfiguracoes.getStopBit(),
					oPrUpDncConfiguracoes.getFlowControl(),
					oPrUpDncConfiguracoes.getRecTimeOut(),
					oPrUpDncConfiguracoes.getRecIgnBefFrstEOB(),
					oPrUpDncConfiguracoes.getRecIgnAftLastEOF(),
					oPrUpDncConfiguracoes.getSndStartProg(),
					oPrUpDncConfiguracoes.getSndEndProg(),
					oPrUpDncConfiguracoes.getSndEndBlock(),
					oPrUpDncConfiguracoes.getSndIgnore(),
					oPrUpDncConfiguracoes.getSndDelayByte(),
					oPrUpDncConfiguracoes.getSndRTS(),
					oPrUpDncConfiguracoes.getSndCnvtUCase(),
					oPrUpDncConfiguracoes.getSndIgnEmptyBlock());

			this.getDaoPdba().getSession().save(oPrUpDnc);
		}

		this.getDaoPdba().getSession().delete(oPrUpDncConfiguracoes);
		this.getDaoPdba().flushReiniciandoTransacao();
	}

	private PrUpDncConfiguracoes evento21VerificarTabelaConfig(
			PrEventosBridgeCollecDb eventoRecebido, PrUp prup)
					throws RegistroDesconhecidoException, SemSGBDException {
		String hql = "";
		hql = "select prupdncconfiguracoes ";
		hql += "from PrUpDncConfiguracoes prupdncconfiguracoes ";
		hql += "where prupdncconfiguracoes.idUp = '::idup' ";
		hql += "and prupdncconfiguracoes.idEventosBridgeCollecDb = '::idEventosBridgeCollecDb' ";

		hql = hql.replaceAll("::idup", prup.getIdup().toString());
		hql = hql.replaceAll("::idEventosBridgeCollecDb",
				eventoRecebido.getIdeventomasterbridgecollectodb());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrUpDncConfiguracoes> listaPrUpDncConfiguracoes = null;
		try {
			listaPrUpDncConfiguracoes = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		PrUpDncConfiguracoes oPrUpDncConfiguracoes = null;

		if (listaPrUpDncConfiguracoes.size() > 0)
			oPrUpDncConfiguracoes = listaPrUpDncConfiguracoes.get(0);
		else
			throw new RegistroDesconhecidoException();

		return oPrUpDncConfiguracoes;
	}

	public void setTrRepeteMotivoParada(IdwLogger log, int idLog, PrUp prup, Date dthrInicio) throws ServicoFalhouException {
		ParadaRN parrn = new ParadaRN(getDaoInjet(), getDaoPdba());
		PrUpUltimaParada oPrUpUltimaParada = pesquisaPrup_ultimaparada(log, idLog, prup);
		if (oPrUpUltimaParada == null)
			return;
		prup.setCdultimaparada(oPrUpUltimaParada.getCdParada());
		this.getDaoPdba().getSession().merge(prup);
		parrn.setTr_paradaMotivo(log, idLog, prup.getIdup().toString(), dthrInicio,
				oPrUpUltimaParada.getCdParada(), oPrUpUltimaParada.getCdAcao(),
				oPrUpUltimaParada.getCdCausa(),
				oPrUpUltimaParada.getCdJustificativa(),
				oPrUpUltimaParada.getCdTecnicoResponsavel(),
				oPrUpUltimaParada.getCdTecnico1(),
				oPrUpUltimaParada.getCdTecnico2(),
				oPrUpUltimaParada.getCdLocalParada(),null,null,0);
		this.getDaoPdba().flushReiniciandoTransacao();
	}

	public void verificaIsComCIP(IdwLogger log, int idLog, PrUp prup) {

		MapQuery q = new MapQuery(getDaoPdba().getSession());

		q.append("from PrUpCtrlInicioProcesso prupcip ");
		q.append("where prupcip.idup = :idup ");

		q.defineParametro("idup", prup.getIdup().toString());

		q.query().setMaxResults(1);
		PrUpCtrlInicioProcesso prupcip = null;
		IwsDadosCIPDTO dadosCIP = new IwsDadosCIPDTO();
		dadosCIP.setIsCIPPendente(false);
		try {
			prupcip = (PrUpCtrlInicioProcesso) q.uniqueResult();
			if (prupcip != null) {
				if (prup.getNrop() == null || prup.getNrop().equals("")) {
					prupcip.setDthrinicio(null);
					prupcip.setDthrfinal(null);
					prupcip.setIscippendente('0');
					prupcip.setCdmoldeantigo(null);
					this.getDaoPdba().getSession().merge(prupcip);
					this.getDaoPdba().flushReiniciandoTransacao();

					return;
				}

				if (prupcip.getDthrinicio() != null && prupcip.getDthrfinal() == null) {
					dadosCIP.setIsEmCIP(true);
					dadosCIP.setCdmoldeantigo(prupcip.getCdmoldeantigo());
					dadosCIP.setDtHrInicio(prupcip.getDthrinicio());
					log.info("*******" + prup.getIdup()
							+ "*******************Considerando COM CIP");
				} else if ((prupcip.getIscippendente() != null) && (prupcip.getIscippendente().equals('1'))) {
					dadosCIP.setIsCIPPendente(true);
					dadosCIP.setCdmoldeantigo(prupcip.getCdmoldeantigo());
					log.info("*******" + prup.getIdup()
							+ "*******************Abertura de CIP Pendente");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		prup.mudaDadosCIPDTO(dadosCIP);

	}

	public void setaAberturadeCIPPendente(
			IdwLogger log, int idLog,
			PrEventosBridgeCollecDb eventoRecebido, PrUp prup) {
		MapQuery q = new MapQuery(getDaoPdba().getSession());

		q.append("from PrUpCtrlInicioProcesso prupcip ");
		q.append("where prupcip.idup = :idup ");

		q.defineParametro("idup", prup.getIdup().toString());

		q.query().setMaxResults(1);
		PrUpCtrlInicioProcesso prupcip = null;
		try {
			prupcip = (PrUpCtrlInicioProcesso) q.uniqueResult();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (prup.getNrop() != null && !prup.getNrop().equals("")) {
			if (prupcip == null) {
				prupcip = new PrUpCtrlInicioProcesso();
				prupcip.setIdup(prup.getIdup().toString());
				prupcip.setPrUp(prup);
			}
			prupcip.setDthrinicio(null);
			prupcip.setCdtecinicio(null);
			prupcip.setCdtecfinal(null);
			prupcip.setDthrfinal(null);
			prupcip.setIscippendente('1');
			prupcip.setCdmoldeantigo(eventoRecebido.getInf01());
			this.getDaoPdba().makePersistent(prupcip);
			this.getDaoPdba().flushReiniciandoTransacao();
			log.info("*******" + prup.getIdup()
					+ "*******************Abertura de CIP Pendente");
			return;
		}

	}

	public void TratarInicioDeCIP(
			IdwLogger log, int idLog,
			String idup, Date DataReferencia,String Tecnico)
			throws RegistroDesconhecidoException, SemSGBDException, ServicoFalhouException {
		PrUp prup = new PrUp();
		prup = pesquisaPrup(log, idLog, idup);

		// trata CIP
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		Boolean trataParada = false, isParadainformada = false;
		if (prup.getStparadaemaberto() != null
				&& prup.getStparadaemaberto() == '1') {
			prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(DataReferencia));
			prup.mudaDtHrUltimoHeartBeat(DataReferencia);
			fecharParada(log, idLog, prup);// fecha parada
			this.getDaoPdba().flushReiniciandoTransacao();
			trataParada = true;
			if (prup.getCdultimaparada() != null
					&& !prup.getCdultimaparada().equals("")
					&& !prup.getCdultimaparada().equals("999999"))
				isParadainformada = true;
		}
		// insere evento 26 com DthrEvento
		prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setTpevento(new BigDecimal(26));
		prcoletoreventos.setDthr1evento(DataReferencia);
		prcoletoreventos.setMsdthr1evento(DataHoraRN
				.getApenasMilisegundos(DataReferencia));
		prcoletoreventos.setDthr2evento(DataReferencia);
		prcoletoreventos.setMsdthr2evento(DataHoraRN
				.getApenasMilisegundos(DataReferencia));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		//c?digo do t?cnico que abriu o CIP somente se houver 
		prcoletoreventos.setInf01(Tecnico);
		prcoletoreventos.setPrUp(prup);

		lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
		// aqui era tratado o evento 22 do BC... removido pois n�o havia
		// necessidade
		this.getDaoPdba().flushReiniciandoTransacao();
		MapQuery q =new MapQuery(getDaoPdba().getSession());
		q.append("from PrUpCtrlInicioProcesso prupcip ");
		q.append("where prupcip.idup = :idup ");

		q.defineParametro("idup", prup.getIdup().toString());
		q.setMaxResults(1);		

		PrUpCtrlInicioProcesso oPrUpCtrlInicioProcesso = null;
		try {
			oPrUpCtrlInicioProcesso = (PrUpCtrlInicioProcesso) q.uniqueResult();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		if (oPrUpCtrlInicioProcesso == null){
			oPrUpCtrlInicioProcesso = new PrUpCtrlInicioProcesso();
			oPrUpCtrlInicioProcesso.setIdup(prup.getIdup().toString());
		}
		oPrUpCtrlInicioProcesso.setDthrinicio(DataReferencia);
		oPrUpCtrlInicioProcesso.setDthrfinal(null);		
		oPrUpCtrlInicioProcesso.setIscippendente('0');
		this.getDaoPdba().makePersistent(oPrUpCtrlInicioProcesso);
		this.getDaoPdba().flushReiniciandoTransacao();

		if (trataParada) {
			PrColetorEventos prcoletoreventos2 = new PrColetorEventos();
			prcoletoreventos2.setTpevento(new BigDecimal(8));
			prcoletoreventos2.setDthr1evento(DataReferencia);
			prcoletoreventos2.setMsdthr1evento(DataHoraRN.getApenasMilisegundos(DataReferencia));
			prcoletoreventos2.setNrop(prup.getNrop());
			prcoletoreventos2.setCdmolde(prup.getCdmolde());
			prcoletoreventos2.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos2.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos2.setPrUp(prup);
			prcoletoreventos2.setInf01("1");
			prcoletoreventos2.setInf20("evento24TratarInicioDeCIP");
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos2, false);// abre
			// parada

			if (IdwFacade.getInstancia().isIDWAtivo()) {
					// Alessandre-tanto o inicio da parada qto o final da para estao
					// chamando o mesmo servico, e o servico ira executar inicio ou fim da parada dependendo do 
					// status de funcionamento da maquina. Encontrar uma forma de dizer q a maq esta trabalhando
					// aqui para q o servico inicio uma parada
					IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(idup);

					icupdto.getUpDTO().setUpTrabalhando(true);

					ParadaPdbaMsEvtRN rnpdba = new ParadaPdbaMsEvtRN();
						rnpdba.executarServico(getDaoPdba().getSession(), idup, null, DataReferencia, null, null, ServicoFactory._INICIO_PARADA, "TratatInicioDeCIP " + DataHoraRN.getDataHoraAtualFormatada());
			}

			prup.setDthriniultimaparada(DataReferencia);
			prup.setMsdthriniultimaparada((double) DataHoraRN.getApenasMilisegundos(DataReferencia));
			prup.setStparadaemaberto('1');
			this.getDaoPdba().getSession().merge(prup);
			if (isParadainformada)
				setTrRepeteMotivoParada(log, idLog, prup, DataReferencia);
			this.getDaoPdba().flushReiniciandoTransacao();
		}
	}

	public Boolean trataFimCIP(IdwLogger log, int idLog, String idup, Date DtHrEvento,String Tecnico) throws ServicoFalhouException {
		return trataFimCIP(log, idLog, idup, DtHrEvento, false,Tecnico);
	}

	public Boolean trataFimCIP(
			IdwLogger log, int idLog,
			String idup, Date DtHrEvento,
			Boolean isFechandoOP,String Tecnico) throws ServicoFalhouException {
		PrUp prup = pesquisaPrup(log, idLog, idup);

		MapQuery q= new MapQuery(getDaoPdba().getSession());

		q.append("from PrUpCtrlInicioProcesso otbl");
		q.append("where otbl.idup = :idup ");
		q.defineParametro("idup", idup);
		q.setMaxResults(1);

		PrUpCtrlInicioProcesso oPrUpCtrlInicioProcesso = null;
		try {
			oPrUpCtrlInicioProcesso = (PrUpCtrlInicioProcesso)q.uniqueResult();
		} catch (Exception e) {
			log.info("Erro ao finalizar o CIP, Dado n�o encontrado em PrUpCtrlInicioProcesso para o Idup: "+idup);
			e.printStackTrace();
			return false;
		}


		if (oPrUpCtrlInicioProcesso != null &&
				oPrUpCtrlInicioProcesso.getDthrinicio() != null
				&& oPrUpCtrlInicioProcesso.getDthrfinal() == null) {
			PrColetorEventos prcoletoreventos = new PrColetorEventos();
			Boolean trataParada = false, isParadainformada = false;
			if (prup.getStparadaemaberto() != null && prup.getStparadaemaberto() == '1') {
				prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(DtHrEvento));
				prup.mudaDtHrUltimoHeartBeat(DtHrEvento);
				fecharParada(log, idLog, prup);// fecha parada
				trataParada = true;
				if (prup.getCdultimaparada() != null && !prup.getCdultimaparada().equals("") && !prup.getCdultimaparada().equals("999999"))
					isParadainformada = true;
			}
			oPrUpCtrlInicioProcesso.setDthrfinal(DtHrEvento);

			this.getDaoPdba().makePersistent(oPrUpCtrlInicioProcesso);
			this.getDaoPdba().flushReiniciandoTransacao();

			prcoletoreventos = new PrColetorEventos();
			prcoletoreventos.setTpevento(new BigDecimal(27));
			prcoletoreventos.setDthr1evento(DtHrEvento);
			prcoletoreventos.setMsdthr1evento(DataHoraRN.getApenasMilisegundos(DtHrEvento));
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setPrUp(prup);
			//c�digo do t�cnico que fechou o CIP somente se houver 
			prcoletoreventos.setInf01(Tecnico);
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);

			this.getDaoPdba().flushReiniciandoTransacao();
			if (trataParada && !isFechandoOP) {
				PrColetorEventos prcoletoreventos2 = new PrColetorEventos();
				prcoletoreventos2.setTpevento(new BigDecimal(8));
				prcoletoreventos2.setDthr1evento(DtHrEvento);
				prcoletoreventos2.setMsdthr1evento(DataHoraRN.getApenasMilisegundos(DtHrEvento));
				prcoletoreventos2.setNrop(prup.getNrop());
				prcoletoreventos2.setCdmolde(prup.getCdmolde());
				prcoletoreventos2.setCdestrutura(prup.getCdestrutura());
				prcoletoreventos2.setDthriniplanejada(prup.getDthriniplanejada());
				prcoletoreventos2.setPrUp(prup);
				prcoletoreventos2.setInf01("1");
				prcoletoreventos2.setInf20("trataFimCIP");
				lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos2, false);

				if (IdwFacade.getInstancia().isIDWAtivo()) {
						// Alessandre-tanto o inicio da parada qto o final da para estao
						// chamando o mesmo servico, e o servico ira executar inicio ou fim da parada dependendo do 
						// status de funcionamento da maquina. Encontrar uma forma de dizer q a maq esta trabalhando
						// aqui para q o servico inicio uma parada
						IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(idup);

						icupdto.getUpDTO().setUpTrabalhando(true);

						ParadaPdbaMsEvtRN rnpdba = new ParadaPdbaMsEvtRN();
							rnpdba.executarServico(getDaoPdba().getSession(), idup, null, DtHrEvento, null, null, ServicoFactory._INICIO_PARADA, "trataFimCIP " + DataHoraRN.getDataHoraAtualFormatada());
				}

				prup.setDthriniultimaparada(DtHrEvento);
				prup.setMsdthriniultimaparada((double) DataHoraRN.getApenasMilisegundos(DtHrEvento));
				prup.setStparadaemaberto('1');
				this.getDaoPdba().getSession().merge(prup);
				if (isParadainformada)
					setTrRepeteMotivoParada(log, idLog, prup, DtHrEvento);
				this.getDaoPdba().flushReiniciandoTransacao();
			}			
		}
		return true;
	}

	public Boolean verificarInfReleEvento29(
			PrEventosBridgeCollecDb eventoRecebido) {
		Boolean bRet = false;

		if (eventoRecebido.getInf01() != null) {
			try {
				Integer inf01 = Integer.parseInt(eventoRecebido.getInf01());

				if (inf01 >= 1 && inf01 <= 5) {
					if (eventoRecebido.getInf02().equals("0")) {
						bRet = true;
					} else if (eventoRecebido.getInf02().equals("1")) {
						if (eventoRecebido.getInf03().equals("0")) {
							Integer inf04 = Integer.parseInt(eventoRecebido
									.getInf04());
							Integer inf05 = Integer.parseInt(eventoRecebido
									.getInf05());

							if (inf04 > 0 && inf05 > 0)
								bRet = true;
							else
								// erro, numero nao maior que zero
								bRet = false;
						} else if (eventoRecebido.getInf03().equals("1")) {
							bRet = true;
						} else { // erro, valor diferente de 0 e 1
							bRet = false;
						}
					} else { // erro, valor diferente de 0 e 1
						bRet = false;
					}
				}
			} catch (NumberFormatException e) {
				bRet = false;
			}
		} else {
			bRet = false;
		}

		return (bRet);
	}

	public Date getUpBeat(String mac) throws RegistroDesconhecidoException,
	SemSGBDException {

		String hql = "";
		hql += "select prcoletor ";
		hql += "from PrColetor prcoletor ";
		hql += "where prcoletor.idcoletor = '::idcoletor' ";

		hql = hql.replaceAll("::idcoletor", mac);

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrColetor> listaPrColetor = null;
		try {
			listaPrColetor = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}
		Date resposta = null;
		Date reference = null;
		if (listaPrColetor.size() > 0) {
			for (PrColetor prcoletor : listaPrColetor) {
				try {
					reference = DataHoraRN.getDataComMilisegundos(
							prcoletor.getDthrultacessobd(),
							prcoletor.getMsdthrultacessobd());
				} catch (Exception e) {
					reference = DataHoraRN.getDataHoraAtual(this.getDaoPdba());
				}
				if (resposta == null || resposta.before(reference)) {
					resposta = reference;
				}
			}
		} else {
			throw new RegistroDesconhecidoException();
		}
		return resposta;
	}

	private List<PrUp> verificaCoincidenciaIdUpStiva(
			IdwLogger log, int idLog,
			List<PrUp> listaPrUp) {

		if (listaPrUp == null)
			return null;

		int indice = 0;
		double idSubcoletor1, idSubcoletor2;
		List<PrUp> retornoListaPrUp = new ArrayList<PrUp>(listaPrUp);
		Date oDataHoraAtual = null;

		for (PrUp prup : listaPrUp) {
			// adicionado by senoj para filtrar poss�vel erro em prup(erro
			// ocorreu na Cosmosplast em 20100916)
			if (prup.getNrop() == null || prup.getNrop().equals("")) {
				prup.setStparadaemaberto('0');
				this.getDaoPdba().getSession().merge(prup);
			}
			for (PrUp prup2 : listaPrUp) {
				// Alessandre em 02-03-15 coloquei o if para evitar um null pointer que deve ter sido causado qdo o sql server estourou espaco em disco
				if (prup == null || prup.getPrSubColetor() == null || prup.getPrSubColetor().getIdsubcoletor() == null) {
					continue;
				}
				idSubcoletor1 = prup.getPrSubColetor().getIdsubcoletor().doubleValue();
				idSubcoletor2 = prup2.getPrSubColetor().getIdsubcoletor().doubleValue();
				if ((idSubcoletor1 == idSubcoletor2) && (!prup.getIdup().equals(prup2.getIdup()) && prup.getStativa() == '1' && prup2.getStativa() == '1')) {
					if (retornoListaPrUp.contains(prup) == true) {
						indice = retornoListaPrUp.indexOf(prup);
						oDataHoraAtual = DataHoraRN.getDataHoraAtual(this.getDaoPdba());
						PrColetorEventos prcoletoreventos = new PrColetorEventos();
						prcoletoreventos.setTpevento(new BigDecimal(171));
						prcoletoreventos.setStevento("3");
						prcoletoreventos.setDthr1evento(oDataHoraAtual);
						prcoletoreventos.setMsdthr1evento(DataHoraRN
								.getApenasMilisegundos(oDataHoraAtual));
						prcoletoreventos.setDthr2evento(oDataHoraAtual);
						prcoletoreventos.setMsdthr2evento(DataHoraRN
								.getApenasMilisegundos(oDataHoraAtual));
						prcoletoreventos.setNrop(prup.getNrop());
						prcoletoreventos.setCdestrutura(prup.getCdestrutura());
						prcoletoreventos.setCdmolde(prup.getCdmolde());
						prcoletoreventos.setDthriniplanejada(prup
								.getDthriniplanejada());
						prcoletoreventos.setPrUp(prup);
						prcoletoreventos.setInf01("2 IDUPs ativas para o mesmo SubColetor");
						lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
						atualizarPrUpConfiguracoes(log, idLog, prup);
						this.getDaoPdba().flushReiniciandoTransacao();
						retornoListaPrUp.remove(indice);
						// deve verificar se h atualizao para este prup
					}
				}
			}
		}
		// exclui itens coincidentes
		return retornoListaPrUp;
	}

	public List<PrUp> getPrUpsColetaDiscreta(String mac)
			throws SemSGBDException {
		String hql = "";

		hql += "select prup ";
		hql += "from PrUp prup ";
		hql += "join fetch prup.prSubColetor prsubcoletor ";
		hql += "join fetch prsubcoletor.prColetor prcoletor ";
		hql += "where prcoletor.idcoletor = '::idcoletor' ";
		hql += "  and prup.tpup    =  2  "; // voltar pra 2 depois de testar
		hql += "  and prup.stativa = '1' ";

		hql = hql.replaceAll("::idcoletor", mac);

		List<PrUp> listaPrUp = null;

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		try {
			listaPrUp = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		return listaPrUp;
	}

	public List<PrUp> getPrUps(IdwLogger log, int idLog, String mac) throws SemSGBDException {
		String hql = "";

		hql += "select prup ";
		hql += "from PrUp prup ";
		hql += "join fetch prup.prSubColetor prsubcoletor ";
		hql += "join fetch prsubcoletor.prColetor prcoletor ";
		hql += "where ( prcoletor.idcoletor = '::idcoletor' or prcoletor.idcoletor2 = '::idcoletor' ) and prup.stativa = '1' ";

		hql = hql.replaceAll("::idcoletor", mac);

		List<PrUp> listaPrUp = null;

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		try {
			listaPrUp = q.list();
			listaPrUp = verificaCoincidenciaIdUpStiva(log, idLog, listaPrUp);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SemSGBDException();
		}

		return listaPrUp;
	}

	public List<PrUp> getPrUpsTodas(IdwLogger log, int idLog, String mac) throws SemSGBDException {
		String hql = "";

		hql += "select prup ";
		hql += "from PrUp prup ";
		hql += "join fetch prup.prSubColetor prsubcoletor ";
		hql += "join fetch prsubcoletor.prColetor prcoletor ";
		hql += "where prcoletor.idcoletor = '::idcoletor' or prcoletor.idcoletor2 = '::idcoletor' ";

		hql = hql.replaceAll("::idcoletor", mac);

		List<PrUp> listaPrUp = null;

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		try {
			listaPrUp = q.list();
			listaPrUp = verificaCoincidenciaIdUpStiva(log, idLog, listaPrUp);
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		return listaPrUp;
	}

	public IwsAutenticacaoDTO verificaSeOperadorLogado(
			IdwLogger log, int idLog,
			String idUp,
			String cdUsuario) {
		IwsAutenticacaoDTO retorno = new IwsAutenticacaoDTO();
		retorno.setIsAutorizado(false);
		PrUp prup = pesquisaPrup(log, idLog, idUp);

		Set<PrUpLoginsEmAberto> listalogins = prup.getPrUpLoginsEmAbertos();
		for (PrUpLoginsEmAberto pruplogin : listalogins) {
			if (pruplogin.getCdusuario().equals(cdUsuario)) {
				retorno.setIsAutorizado(true);
				retorno.setNomeOperador(pruplogin.getCdusuario());
				retorno.setIdOperador(pruplogin.getIdloginaberto());
				retorno.setCdUsuario(pruplogin.getCdusuario());
				retorno.setResultadoAutenticacao(IwsAutenticacaoDTO.Autorizado);
			}
		}
		return retorno;
	}

	public void efetuaLogin(IdwLogger log, int idLog, String idUp, String login, Date DataHrAtual) {

		PrUp prup = pesquisaPrup(log, idLog, idUp);

		// Verifica se o login ja esta aberto, se sim nao faz nada
		Set<PrUpLoginsEmAberto> listalogins = prup.getPrUpLoginsEmAbertos();
		for (PrUpLoginsEmAberto pruplogin : listalogins) {
			if (pruplogin.getCdusuario().equals(login)) {
				return;
			}
		}

		// Se login nao estiver aberto, abrir
		long milisegundos = DataHrAtual.getTime() % 1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(17));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(DataHrAtual);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(DataHrAtual);
		prcoletoreventos.setMsdthr2evento((double) milisegundos);
		prcoletoreventos.setInf01(login);
		lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);

		if (IdwFacade.getInstancia().isIDWAtivo()) {
			UsuarioMSRN usuarioMSRN = new UsuarioMSRN();
			usuarioMSRN.iniciaConexaoBanco(getDaoPdba().getSession());
			// Tenta fazer o login
			usuarioMSRN.logarUsuario(idUp, login, DataHrAtual);
		}

		this.getDaoPdba().flushReiniciandoTransacao();
		String sql = "";
		sql += "insert into Pr_Up_Logins_Em_Aberto (idUp, cdusuario, DtHrLogin, msDtHrLogin)";
		sql += " values ( '::idup', '::cdusuario', :data , ::msDtHrLogin)";
		sql = sql.replaceAll("::idup", idUp);
		sql = sql.replaceAll("::cdusuario", login);
		sql = sql.replaceAll("::msDtHrLogin", (String.valueOf(milisegundos)));

		Query q = this.getDaoPdba().getSession().createSQLQuery(sql);
		q.setTimestamp("data", DataHrAtual);
		q.executeUpdate();
		this.getDaoPdba().flushReiniciandoTransacao();

		PrUpCtrlEventosLoginout eventosLoginout = null;
		sql = "";

		sql += "select prupctrleventosloginout from PrUpCtrlEventosLoginout prupctrleventosloginout ";
		sql += "where prupctrleventosloginout.idup = '::idup' ";

		sql = sql.replaceAll("::idup", idUp);

		q = this.getDaoPdba().getSession().createQuery(sql);

		try {
			eventosLoginout = (PrUpCtrlEventosLoginout) q.uniqueResult();
		} catch (Exception e1) {
			e1.printStackTrace();
			eventosLoginout = null;
		}

		if (eventosLoginout != null) {
			eventosLoginout.setDthrcoletor(DataHrAtual);
			this.getDaoPdba().getSession().merge(eventosLoginout);
		}
	}

	public void efetuaLogout(IdwLogger log, int idLog, String idUp, String login, Date DataHrAtual, Date DthrLogin) {
		PrUp prup = pesquisaPrup(log, idLog, idUp);
		long milisegundos = DataHrAtual.getTime() % 1000;
		long milisegnLogin = DthrLogin.getTime() % 1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(18));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(DataHrAtual);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(DataHrAtual);
		prcoletoreventos.setMsdthr2evento((double) milisegundos);
		prcoletoreventos.setInf01(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DthrLogin));
		prcoletoreventos.setInf02(String.valueOf(milisegnLogin));
		prcoletoreventos.setInf03(login);
		lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);

		if (IdwFacade.getInstancia().isIDWAtivo()) {
			UsuarioMSRN usuarioMSRN = new UsuarioMSRN();
			usuarioMSRN.iniciaConexaoBanco(getDaoPdba().getSession());
			usuarioMSRN.deslogarUsuario(idUp, login, DataHrAtual);
		}

		// Alessandre em 12-01-18 comentei a linha abaixo para evitar que o logout seja feito no BC mas nao no coletor caso ocorra algum erro na coleta
		//this.getDaoPdba().flushReiniciandoTransacao();
		
		String sql = "";
		sql += "delete from Pr_Up_Logins_Em_Aberto where idUp='::idup' and cdusuario='::cdusuario' ";
		sql = sql.replaceAll("::idup", idUp);
		sql = sql.replaceAll("::cdusuario", login);

		Query q = this.getDaoPdba().getSession().createSQLQuery(sql);

		int count = q.executeUpdate();
		
		log.info(idLog, 0, count + " - Logout operador " + sql);
		
		// Alessandre em 12-01-18 mesmo motivo do comentario anterior
		//this.getDaoPdba().flushReiniciandoTransacao();

		PrUpCtrlEventosLoginout eventosLoginout = null;
		sql = "";

		sql += "select prupctrleventosloginout from PrUpCtrlEventosLoginout prupctrleventosloginout ";
		sql += "where prupctrleventosloginout.idup = '::idup' ";

		sql = sql.replaceAll("::idup", idUp);

		q = this.getDaoPdba().getSession().createQuery(sql);

		try {
			eventosLoginout = (PrUpCtrlEventosLoginout) q.uniqueResult();
		} catch (Exception e1) {
			e1.printStackTrace();
			eventosLoginout = null;
		}

		if (eventosLoginout != null) {
			eventosLoginout.setDthrcoletor(DataHrAtual);
			this.getDaoPdba().getSession().merge(eventosLoginout);
		}
	}

	private void atualizaPrUpProduto(String idup){ //TODO Senoj: refazer este m�todo
		String hql = "";
		// 1o insere a partir de PrUpProdutoValidacao
		hql = " select prupprodutovalidacao ";
		hql += "from PrUpProdutoValidacao prupprodutovalidacao ";
		hql += "where prupprodutovalidacao.prUp.idup = '::idup' ";

		hql = hql.replaceAll("::idup", idup);

		Query	q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrUpProdutoValidacao> listaprprodconfig = null;

		try {
			listaprprodconfig = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(listaprprodconfig==null || listaprprodconfig.size()==0){
			return;
		}

		// Atualizar tabela PR_UP_PRODUTO, com os dados da tabela
		// PR_UP_PRODUTO_VALIDACAO
		// 2o apaga

		hql = "delete from PrUpProduto prupproduto ";
		hql += "where prupproduto.prUp.idup = '::idup' ";

		hql = hql.replaceAll("::idup", idup);

		q = this.getDaoPdba().getSession().createQuery(hql);
		q.executeUpdate();

		this.getDaoPdba().flushReiniciandoTransacao();



		// PrUpProduto prupproduto = new PrUpProduto();
		for (PrUpProdutoValidacao prupprodutovalidacao : listaprprodconfig) {
			String sql = "insert into Pr_Up_Produto (idUp, cdproduto, idreduzidaproduto, dsproduto, qtdplan, qtdprodliquida )";
			sql += " values ( '::idup', '::cdproduto', '::IdReduzidaProduto', '::dsproduto', ::qtdplan, ::qtdprodliquida)";
			sql = sql.replaceAll("::idup", idup);
			sql = sql.replaceAll("::cdproduto",
					prupprodutovalidacao.getCdproduto());
			sql = sql.replaceAll("::IdReduzidaProduto",
					("" + prupprodutovalidacao.getIdreduzidaproduto()));
			sql = sql.replaceAll("::dsproduto",
					prupprodutovalidacao.getDsproduto());
			sql = sql.replaceAll("::qtdplan",
					String.valueOf(prupprodutovalidacao.getQtplan()));
			sql = sql.replaceAll("::qtdprodliquida", "0");

			q = this.getDaoPdba().getSession().createSQLQuery(sql);
			q.executeUpdate();
		}
		hql = "delete ";
		hql += "from PrUpProdutoValidacao prupprodutovalidacao ";
		hql += "where prupprodutovalidacao.prUp.idup = '::idup' ";

		hql = hql.replaceAll("::idup", idup);

		q = this.getDaoPdba().getSession().createQuery(hql);
		q.executeUpdate();

		this.getDaoPdba().flushReiniciandoTransacao();	

	}

	public IwsCpDTO planejamento(IdwLogger log, int idLog, String idUp, IwsCpDTO cpEntrada, Date dthr) throws ServicoFalhouException {
		IwsCpDTO retorno = new IwsCpDTO();

		PrColetorEventos evento = new PrColetorEventos();

		Double msDthrEvento = (double) (DataHoraRN.getApenasMilisegundos(dthr));
		PrUp prup = pesquisaPrup(log, idLog, idUp);

		InjetInfoRN iRN = new InjetInfoRN(getDaoInjet(),getDaoPdba());
		iRN.verificaIntegDoal(prup);

		String nropestendido = null;
		String cdmoldeestendido = null;
		
		try {
			prup.mudaDtHrUltimoHeartBeat(dthr);
		} catch (Exception e) {
			prup.mudaDtHrUltimoHeartBeat(DataHoraRN.getDataHoraAtual(this.getDaoPdba()));
		}

		evento.setDthr1evento(dthr);
		evento.setMsdthr1evento(msDthrEvento);

		evento.setDthr2evento(evento.getDthr1evento());
		evento.setMsdthr2evento(evento.getMsdthr1evento());

		evento.setTpevento(new BigDecimal(2));
		evento.setInf01(cpEntrada.getStCriacaoCP());
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_MOLDE) {
			evento.setInf02(cpEntrada.getCdmolde());
		}
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_OP) {
			evento.setInf02(cpEntrada.getNrop());
		}
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_PRODUTO) {
			evento.setInf02(cpEntrada.getCdProduto());
		}
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_MOLDE_ESTRUTURA_COM_OPCRIACAONOMASTER) {
			evento.setInf02(cpEntrada.getCdmolde());
			evento.setInf03(cpEntrada.getCdestrutura());
			evento.setInf04(cpEntrada.getQtciclos().toString());
		}
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_PRODUTO_ESTRUTURA_COM_OPCRIACAONOMASTER) {
			evento.setInf02(cpEntrada.getCdProduto());
			evento.setInf03(cpEntrada.getCdestrutura());
			// 2019-09-26 Ailton: validacao do cpEntrada.getProducaoPlanejada()
			// caso esteja vazio usar a qtCiclos
			// evento.setInf04(cpEntrada.getProducaoPlanejada().toString());
			if (cpEntrada.getProducaoPlanejada() != null)
				evento.setInf04(cpEntrada.getProducaoPlanejada().toString());
			else if (cpEntrada.getQtciclos() != null)
				evento.setInf04(cpEntrada.getQtciclos().toString());
		}
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_PRODUTO_MONTAGEM) {
			evento.setInf01(cpEntrada.getCdProduto());
		}
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_PRODUTO_OP_COM_OPCRIACAOMASTER) {
			evento.setInf02(cpEntrada.getCdProduto());
			// 2019-09-26 Ailton: validacao do cpEntrada.getProducaoPlanejada()
			// caso esteja vazio usar a qtCiclos
			// evento.setInf03(cpEntrada.getProducaoPlanejada().toString());
			if (cpEntrada.getProducaoPlanejada() != null)
				evento.setInf03(cpEntrada.getProducaoPlanejada().toString());
			else if (cpEntrada.getQtciclos() != null)
				evento.setInf03(cpEntrada.getQtciclos().toString());
		}
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_MOLDE_PRODUTO_QTCICLOS) {
			evento.setInf02(cpEntrada.getCdmolde());
			evento.setInf03(cpEntrada.getCdProduto());
			evento.setInf04(cpEntrada.getQtciclos().toString());
		}
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_MOLDE_PRODUTO_QTDCARTOES) {
			evento.setInf02(cpEntrada.getCdProduto());
			evento.setInf03(cpEntrada.getCdmolde());
			evento.setInf04(cpEntrada.getQtcartoes());
		}

		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_SESSAO_CDM) {
			evento.setInf02(cpEntrada.getNrop());
			evento.setInf03(cpEntrada.getProducaoPlanejada());
		}

		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_OP_11) {
			evento.setInf02(cpEntrada.getNrop());
		}

		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_OP_MOLDE_ESTRUTURA_OPT) {
			evento.setInf02(cpEntrada.getNrop());
			evento.setInf03(cpEntrada.getCdmolde());
			evento.setInf04(cpEntrada.getCdestrutura());
		}		
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_OP_QTD_INCREMNTAL) {
			evento.setInf02(cpEntrada.getNrop());
			evento.setInf03(cpEntrada.getCdmolde());
			evento.setInf04(cpEntrada.getCdestrutura());
			evento.setInf05(cpEntrada.getProducaoPlanejada());			
		}		
		if (Integer.parseInt(cpEntrada.getStCriacaoCP()) == IwsUpDTO.TIPO_CP_OP_ESTRUTURA) {
			evento.setInf02(cpEntrada.getNrop()); //WellStream
			evento.setInf03(cpEntrada.getNrop());
			evento.setInf04(cpEntrada.getCdestrutura());
		}
		
		prup.mudaDtHrReferenciaParaEventos(dthr);
		evento.setPrUp(prup);

		PrEventosBridgeCollecDb eventoRetorno = null;

		try {
			eventoRetorno = lancarEventoEsperaPrEventosBridgeCollecDb(log, idLog, evento, true);
		} catch (MestreOfflineException e) {
			log.info("Detectou que BC esta OFF-line: " + idUp);
			retorno.setTxtMensagem("Detectou que BC esta offline.");
			retorno.setIsSGBDOnline(false);
		}

		if (eventoRetorno == null) {
			eventoRetorno = new PrEventosBridgeCollecDb();
			eventoRetorno.setTpevento(new BigDecimal(0));
			eventoRetorno.setInf01("");
		}

		// Falhou a criacao da OP
		if (retorno.getIsSGBDOnline() == false || (eventoRetorno.getTpevento().equals(new BigDecimal(2)) && eventoRetorno.getInf01().equals("0"))) {

			/* Marcos Sardinha: 2019-04-17 - trecho abaixo removia complemento das mensagens...
			 * 
			if (retorno.getIsSGBDOnline() == true && eventoRetorno.getTxtmensagem() != null) {
				
				if (eventoRetorno.getTxtmensagem().indexOf("(") >= 0)
					retorno.setTxtMensagem(eventoRetorno.getTxtmensagem().substring(0, eventoRetorno.getTxtmensagem().indexOf("(")));
				else
					retorno.setTxtMensagem(eventoRetorno.getTxtmensagem());
			}
			*/
			
			if (retorno.getIsSGBDOnline() == true) {
				retorno.setTxtMensagem(eventoRetorno.getTxtmensagem());
			}
				
			retorno.setTxtMensagem(eventoRetorno.getTxtmensagem());
			
			retorno.setIsProducaoValida(false);

			try {

				// Limpar PR_UP_EXECINSPECAO e PR_UP_CTRL_EXECINSPECAO ,
				// Pr_Up_Variacao_Ritmo_Pend e Pr_Up_Ultima_Variacao_Ritmo

				String sql = "";

				sql += "delete from Pr_Up_Execinspecao where idUp = '::idup' ";
				sql = sql.replaceAll("::idup", prup.getIdup().toString());

				Query q = this.getDaoPdba().getSession().createSQLQuery(sql);

				q.executeUpdate();

				sql = "";

				sql += "delete from Pr_Up_Ctrl_Execinspecao where idUp = '::idup' ";
				sql = sql.replaceAll("::idup", prup.getIdup().toString());

				q = this.getDaoPdba().getSession().createSQLQuery(sql);

				q.executeUpdate();

				sql = "";

				sql += "delete from Pr_Up_Variacao_Ritmo_Pend where idUp = '::idup' ";
				sql = sql.replaceAll("::idup", prup.getIdup().toString());

				q = this.getDaoPdba().getSession().createSQLQuery(sql);

				sql = "";

				sql += "delete from Pr_Up_Ultima_Variacao_Ritmo where idUp = '::idup' ";
				sql = sql.replaceAll("::idup", prup.getIdup().toString());

				q = this.getDaoPdba().getSession().createSQLQuery(sql);

				q.executeUpdate();
			} catch (Exception e) {
				// N�o faz nada apenas para proteger de poss�veis

			}
		} else {
			nropestendido = new String(eventoRetorno.getInf03());
			cdmoldeestendido = new String(eventoRetorno.getInf04());
			log.info(idLog, 0,"NropEstendido:"+nropestendido +" MoldeEstendido:"+cdmoldeestendido);
			// se integra��o bettanin e integra��o doal estiverem ativos,
			// registra no log banco
			if (eventoRetorno.getInf06() != null && (prup.getStintegdoal() != null && prup.getStintegdoal().equals('1'))) {
				log.info(idLog, 0,"UTILIZANDO INTEGRAÇÂO BETTANIN, DADOS DE OP SÂO ESCRITOS PELO BC");
				setTr_registroIntegracaoDoal(log, idLog,
						idUp,
						dthr,
						"INTEGRACAO BETTANIN E INTEGACAO DOALPLASTIC ESTAO ATIVADAS."
								+ " A INTEGRACAO BETTANIN TERA PRIORIDADE DE EXECUCAO",
								false);
			}
			// se inf06 = null, significa que n�o h� apontamento para SAP
			// se stintegdoal = '0', n�o precisa valida��o com SAP Doal
			// se stintegdoal = null, n�o precisa valida��o com SAP Doal
			
			if ((eventoRetorno.getInf06() == null) && ((prup.getStintegdoal() != null && prup.getStintegdoal().equals('0')) || (prup.getStintegdoal() == null))) // vlauria 20100505
			{
				log.info(idLog, 0,"CARREGAMENTOS DE DADOS DE OP DO EVENTO DE RETORNO");
				boolean isOpSemColeta = false;
				prup.mudaIsComApntSAP(null);								
				prup.setNrop(eventoRetorno.getNrop());				
				prup.setNropestendido(nropestendido);
				prup.setTmpciclopadrao(Double.parseDouble(eventoRetorno.getInf02()));
				prup.setDthriniplanejada(eventoRetorno.getDthriniplanejada());
				prup.setCdmolde(eventoRetorno.getCdmolde());
				prup.setCdmolestendido(cdmoldeestendido);
				prup.setCdestrutura(eventoRetorno.getCdestrutura());
				prup.setQtdciclosexecutados(new BigDecimal(eventoRetorno.getInf05()));
				if (eventoRetorno.getInf08() != null && eventoRetorno.getInf08().equals("1")) {
					prup.setIsOpSemColeta('1');
					isOpSemColeta = true;
				} else
					prup.setIsOpSemColeta('0');

				this.getDaoPdba().getSession().merge(prup);
				setProdLiquida(idUp, Double.parseDouble(eventoRetorno.getInf07()));
				retorno.setNrop(eventoRetorno.getNrop());
				retorno.setCdmolde(eventoRetorno.getCdmolde());
				retorno.setCdestrutura(eventoRetorno.getCdestrutura());
				retorno.setDthrIPlanejamento(eventoRetorno.getDthriniplanejada());
				retorno.setCicloPadrao(Float.valueOf(eventoRetorno.getInf02()));
				retorno.setNropestendido(nropestendido);
				retorno.setCdmoldeestendido(cdmoldeestendido);
				if (eventoRetorno.getInf08() != null && eventoRetorno.getInf08().equals("1")) {
					retorno.setIsOpSemColeta(true);
					retorno.setcdParadaSemProd(eventoRetorno.getInf09());
				} else
					retorno.setIsOpSemColeta(false);
				
				
				// Processa os produtos da OP retornada

				atualizaPrUpProduto(prup.getIdup().toString());
				// Lan�ar evento de OP confirmada em PR_COLETOR_EVENTOS
				// TpEvento = 5
				// DtHrInicioMs = Data/hora inicio confirmacao Op;
				// DtHrFimMs = Data/hora inicio confirmacao Op;
				// NrOP;
				// CdMolde;
				// CdEstrutura;
				// INF01 = Sessao de Producao
				try {

					// Limpar PR_UP_EXECINSPECAO e PR_UP_CTRL_EXECINSPECAO
					// vlauria 20100325
					String sql = "";
					Query q;

					sql += "delete from Pr_Up_Execinspecao where idUp = '::idup' ";
					sql = sql.replaceAll("::idup", prup.getIdup().toString());

					q = this.getDaoPdba().getSession().createSQLQuery(sql);

					q.executeUpdate();

					sql = "";

					sql += "delete from Pr_Up_Ctrl_Execinspecao where idUp = '::idup' ";
					sql = sql.replaceAll("::idup", prup.getIdup().toString());

					q = this.getDaoPdba().getSession().createSQLQuery(sql);

					q.executeUpdate();
				} catch (Exception e) {
					// N�o faz nada apenas para proteger de poss�veis

				}

				PrColetorEventos eventoConfirmacaoOP = new PrColetorEventos();
				eventoConfirmacaoOP.setTpevento(new BigDecimal(5));
				eventoConfirmacaoOP.setDthr1evento(dthr);
				eventoConfirmacaoOP.setMsdthr1evento(msDthrEvento);
				eventoConfirmacaoOP.setDthr2evento(dthr);
				eventoConfirmacaoOP.setMsdthr2evento(msDthrEvento);
				eventoConfirmacaoOP.setNrop(eventoRetorno.getNrop());
				eventoConfirmacaoOP.setCdmolde(eventoRetorno.getCdmolde());
				eventoConfirmacaoOP.setCdestrutura(eventoRetorno.getCdestrutura());
				eventoConfirmacaoOP.setDthriniplanejada(eventoRetorno.getDthriniplanejada());
				eventoConfirmacaoOP.setInf01(evento.getInf01());
				eventoConfirmacaoOP.setPrUp(prup);
				lancarEventoEsperaPrColetorEventos(log, idLog, eventoConfirmacaoOP, false);
				this.getDaoPdba().flushReiniciandoTransacao();
				if (isOpSemColeta) {
					ParadaRN prn = new ParadaRN(getDaoInjet(), getDaoPdba());
					prn.setTr_AbrelancaMotivoParada(log, idLog, prup, DataHoraRN.getDataComMilisegundos(dthr, msDthrEvento), eventoRetorno.getInf09());
				}

				this.getDaoPdba().flushReiniciandoTransacao();
			} else {
				// se INF06 != null, valida��o para Apnt SAP Bettanin
				// se INF06 == null, valida��o para Integra��o Doal
				if (eventoRetorno.getInf06() != null) {
					if (eventoRetorno.getInf06().equals("1")) {
						retorno.setIsApntSAPAtivo("1");
						prup.mudaIsComApntSAP("1");
					} else {
						retorno.setIsApntSAPAtivo("0");
						prup.mudaIsComApntSAP("0");
					}
				}
				// se inf06 == null e stintegdoal == '1', seguir.
				else {
					retorno.setIsApntSAPAtivo(null);
					prup.mudaIsComApntSAP(null);
				}
			}
			if(eventoRetorno.getNrop()==null)
				log.error("#### Sem OP no retorno de planejamento para idup:"+idUp);
		}
		retorno.setNrop(eventoRetorno.getNrop());
		retorno.setCdmolde(eventoRetorno.getCdmolde());
		retorno.setCdestrutura(eventoRetorno.getCdestrutura());
		retorno.setDthrIPlanejamento(eventoRetorno.getDthriniplanejada());
		retorno.setCdmoldeestendido(cdmoldeestendido);
		retorno.setNropestendido(nropestendido);
		if (eventoRetorno.getInf08() != null && eventoRetorno.getInf08().equals("1")) {
			retorno.setIsOpSemColeta(true);
			retorno.setcdParadaSemProd(eventoRetorno.getInf09());
		} else
			retorno.setIsOpSemColeta(false);
		// Abaixo atribuir a retorno a lista de produtos da CP
		prup = pesquisaPrup(log, idLog, idUp);
		retorno.setProdutos(new ArrayList<IwsProdutoDTO>());
		for (PrUpProduto prupproduto : prup.getPrUpProdutos()) {
			IwsProdutoDTO produtoDTO = new IwsProdutoDTO();
			produtoDTO.setCdProduto(prupproduto.getCdproduto());
			produtoDTO.setCdReduzido(String.valueOf(prupproduto.getIdreduzidaproduto()));
			produtoDTO.setDsProduto(prupproduto.getDsproduto());
			retorno.addProdutoDTO(produtoDTO);
		}
		if (retorno.getProdutos().size() == 0) {
			log.error("Sem Lista de Produtos no retorno de InfoRN.planejamento");
			// Sem Lista de Produtos no retorno de InfoRN.planejamento");
			// tenta novamente mas por otro m�todo
			String hql2 = "";
			hql2 += "select prupproduto ";
			hql2 += "from PrUpProduto prupproduto ";
			hql2 += "where prupproduto.prUp.idup = '::idup' ";

			hql2 = hql2.replaceAll("::idup", idUp);

			Query q2 = this.getDaoPdba().getSession().createQuery(hql2);

			List<PrUpProduto> listaprprod = null;

			try {
				listaprprod = q2.list();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (listaprprod != null) {
				for (PrUpProduto prupproduto : listaprprod) {
					IwsProdutoDTO produtoDTO = new IwsProdutoDTO();
					produtoDTO.setCdProduto(prupproduto.getCdproduto());
					produtoDTO.setCdReduzido(String.valueOf(prupproduto.getIdreduzidaproduto()));
					produtoDTO.setDsProduto(prupproduto.getDsproduto());
					retorno.addProdutoDTO(produtoDTO);
				}
			}
			if (retorno.getProdutos().size() == 0)
				log.error("Sem Lista de Produtos no retorno de InfoRN.planejamento");
		}
		if (eventoRetorno.getInf02() != null) {
			retorno.setCicloPadrao(Float.valueOf(eventoRetorno.getInf02()));
		} else {
			retorno.setCicloPadrao(0f);
		}

		if (prup.getCfgperctmpcicloparauto() != null)
			retorno.setCfgPercTmpCicloParAuto(prup.getCfgperctmpcicloparauto().floatValue());
		else
			retorno.setCfgPercTmpCicloParAuto(0f);

		if (prup.getCfgperctoleranciasinalciclo() != null)
			retorno.setCfgPercToleranciaSinalCiclo(prup.getCfgperctoleranciasinalciclo().floatValue());
		else
			retorno.setCfgPercToleranciaSinalCiclo(0f);

		if (prup.getCfgtamanhoumpacoteciclos() != null)
			retorno.setCfgTamanhoUmPacoteCiclos(prup.getCfgtamanhoumpacoteciclos().floatValue());
		else
			retorno.setCfgTamanhoUmPacoteCiclos(0f);

		if (prup.getCfgtolertmpcicloparauto() != null) {
			if (prup.getCfgtolertmpcicloparauto() != 0) // vlauria 20100203
				retorno.setCfgTolerTmpCicloParAuto(prup.getCfgtolertmpcicloparauto());
			else
				retorno.setCfgTolerTmpCicloParAuto(0);
		} else {
			retorno.setCfgTolerTmpCicloParAuto(0);
		}

		if (prup.obtemIsComApntSAP() != null && prup.obtemIsComApntSAP().equals("0")) {
			setTr_confirmacaoOp(log, idLog, prup.getIdup().toString(), dthr, null, retorno);
		}

		if (prup.getQtdciclosexecutados() != null)
			retorno.setQtciclos(prup.getQtdciclosexecutados().toString());
		else
			retorno.setQtciclos("0");

		return retorno;
	}



	public IwsCpDTO setTr_confirmacaoOp(
			IdwLogger log, int idLog,
			String idUp, Date dthr,
			String stApntSap, IwsCpDTO cpdto) { 
		
		PrUp prup = pesquisaPrup(log, idLog, idUp);
		prup.setNrop(cpdto.getNrop());				
		prup.setNropestendido(cpdto.getNropestendido());
		prup.setTmpciclopadrao(Double.valueOf(cpdto.getCicloPadrao()));
		prup.setDthriniplanejada(cpdto.getDthrIPlanejamento());
		prup.setCdmolde(cpdto.getCdmolde());
		prup.setCdmolestendido(cpdto.getCdmoldeestendido());
		prup.setCdestrutura(cpdto.getCdestrutura());
		if (cpdto.getIsOpSemColeta()) {
			prup.setIsOpSemColeta('1');
		} else
			prup.setIsOpSemColeta('0');

		this.getDaoPdba().getSession().merge(prup);		
	
		this.getDaoPdba().flushReiniciandoTransacao();

		// Processa os produtos da OP retornada
		atualizaPrUpProduto(idUp);		

		try {

			// Limpar PR_UP_EXECINSPECAO e PR_UP_CTRL_EXECINSPECAO
			// vlauria 20100325
			String sql = "";

			sql += "delete from Pr_Up_Execinspecao where idUp = '::idup' ";
			sql = sql.replaceAll("::idup", idUp);

			Query q = this.getDaoPdba().getSession().createSQLQuery(sql);

			q.executeUpdate();

			sql = "";

			sql += "delete from Pr_Up_Ctrl_Execinspecao where idUp = '::idup' ";
			sql = sql.replaceAll("::idup", idUp);

			q = this.getDaoPdba().getSession().createSQLQuery(sql);

			q.executeUpdate();
		} catch (Exception e) {
			// N�o faz nada apenas para proteger de poss�veis
			e.printStackTrace();
		}
		this.getDaoPdba().flushReiniciandoTransacao();
		this.getDaoPdba().getSession().clear();

		double msDthrEvento = (double) DataHoraRN.getApenasMilisegundos(dthr);
		prup = pesquisaPrup(log, idLog, idUp);

		cpdto.setProdutos(new ArrayList<IwsProdutoDTO>());
		for (PrUpProduto prupproduto : prup.getPrUpProdutos()) {
			IwsProdutoDTO produtoDTO = new IwsProdutoDTO();
			produtoDTO.setCdProduto(prupproduto.getCdproduto());
			produtoDTO.setCdReduzido(String.valueOf(prupproduto
					.getIdreduzidaproduto()));
			produtoDTO.setDsProduto(prupproduto.getDsproduto());

			cpdto.addProdutoDTO(produtoDTO);
		}
		if (cpdto.getProdutos().size() == 0) {
			log.error("Tentando Obter Lista de Produtos no cpdto de InfoRN.setTr_confimacaoOP.");
			// Sem Lista de Produtos no cpdto de InfoRN.setTr_confimacaoOP");
			// tenta novamente mas por otro m�todo
			
			MapQuery mapQuery = new MapQuery(this.getDaoPdba().getSession());
			mapQuery.append("select prupproduto");
			mapQuery.append("from PrUpProduto prupproduto");
			mapQuery.append("where prupproduto.prUp.idup = :idup");					
			mapQuery.defineParametro("idup", idUp);	
			List<PrUpProduto> listaprprod= null;
			try {
				listaprprod = mapQuery.query().list();	
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (listaprprod != null) {
				for (PrUpProduto prupproduto : listaprprod) {
					IwsProdutoDTO produtoDTO = new IwsProdutoDTO();
					produtoDTO.setCdProduto(prupproduto.getCdproduto());
					produtoDTO.setCdReduzido(String.valueOf(prupproduto
							.getIdreduzidaproduto()));
					produtoDTO.setDsProduto(prupproduto.getDsproduto());

					cpdto.addProdutoDTO(produtoDTO);
				}
			}
			if (cpdto.getProdutos().size() == 0)
				log.error("Sem Lista de Produtos no cpdto de InfoRN.setTr_confimacaoOP.");
			// [ERRO] Sem Lista de Produtos no cpdto de InfoRN.setTr_confimacaoOP");
		}
		PrColetorEventos eventoConfirmacaoOP = new PrColetorEventos();
		eventoConfirmacaoOP.setTpevento(new BigDecimal(5));
		eventoConfirmacaoOP.setDthr1evento(dthr);
		eventoConfirmacaoOP.setMsdthr1evento(msDthrEvento);
		eventoConfirmacaoOP.setDthr2evento(dthr);
		eventoConfirmacaoOP.setMsdthr2evento(msDthrEvento);
		eventoConfirmacaoOP.setNrop(cpdto.getNrop());
		eventoConfirmacaoOP.setCdmolde(cpdto.getCdmolde());
		eventoConfirmacaoOP.setCdestrutura(cpdto.getCdestrutura());
		eventoConfirmacaoOP.setDthriniplanejada(cpdto.getDthrIPlanejamento());
		eventoConfirmacaoOP.setInf01(prup.getCfgtpsessaoproducao());
		eventoConfirmacaoOP.setInf02(stApntSap);
		eventoConfirmacaoOP.setPrUp(prup);
		lancarEventoEsperaPrColetorEventos(log, idLog, eventoConfirmacaoOP, false);
		this.getDaoPdba().flushReiniciandoTransacao();
		if (cpdto.getIsOpSemColeta()) {
			ParadaRN prn = new ParadaRN(getDaoInjet(), getDaoPdba());
			prn.setTr_AbrelancaMotivoParada(log, idLog, prup,
					DataHoraRN.getDataComMilisegundos(dthr, msDthrEvento),
					cpdto.getcdParadaSemProd());
		}
		return cpdto;

	}

	public IwsRefugoDTO setTr_LancaEventoRefugo(
			IdwLogger log, int idLog,
			String cdRefugo,
			String cdCausa, String cdAcao, String Quantidade, String IdUp,
			String idRdzProduto, Date DataHrAtual) throws SemSGBDException, ServicoFalhouException {
		// espa�o reservado para lan�ar evento de refugo
		// throw new RegistroDesconhecidoException();
		PrUp prup = null;
		prup = pesquisaPrup(log, idLog, IdUp);
		InjetRefugoRN iRN = new InjetRefugoRN(getDaoInjet());
		IwsRefugoDTO resposta;
		Boolean isValido = true;
		try {
			resposta = iRN.getTr_TabValidaCodRefugo(prup.getCdmaquina(),cdRefugo);
		} catch (Exception e) {
			resposta = new IwsRefugoDTO();
			isValido = false;
			e.printStackTrace();
		}

		try {
			InjetInfoRN iInfoRN = new InjetInfoRN(getDaoInjet(),getDaoPdba());
			if (isValido && resposta.getPedeCausa()){
				cdCausa = UtilRN.setZeroEsquerda(cdCausa);
				isValido = iInfoRN.validaCausa(cdCausa);
			}
			if (isValido && resposta.getPedeAcao()){
				cdAcao = UtilRN.setZeroEsquerda(cdAcao);
				isValido = iInfoRN.validaAcao(cdAcao);
			}
		} catch (Exception e) {
			resposta = new IwsRefugoDTO();
			isValido = false;
			e.printStackTrace();
		}
		if (isValido) {			

			double milisegundos = DataHoraRN.getApenasMilisegundos(DataHrAtual);

			PrColetorEventos prcoletoreventos = new PrColetorEventos();
			prcoletoreventos.setPrUp(prup);
			prcoletoreventos.setTpevento(new BigDecimal(12));
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setDthr1evento(DataHrAtual);
			prcoletoreventos.setMsdthr1evento(milisegundos);
			prcoletoreventos.setDthr2evento(DataHrAtual);
			prcoletoreventos.setMsdthr2evento(milisegundos);
			prcoletoreventos.setInf01(cdRefugo);
			prcoletoreventos.setInf02(idRdzProduto);
			prcoletoreventos.setInf03(Quantidade);
			prcoletoreventos.setInf04(cdCausa);
			prcoletoreventos.setInf05(cdAcao);

			PrEventosBridgeCollecDb eventoResposta = null;
			try {
				eventoResposta = lancarEventoEsperaPrEventosBridgeCollecDb(log, idLog, prcoletoreventos, true);
			} catch (MestreOfflineException e) {		
				log.info("Detectou que BC est� OFF-line: " + IdUp);	
				resposta.setIsRefugoValido(false);
				return (resposta);
			}

			String retorno = eventoResposta.getInf01();
			if (retorno.compareTo("0") == 0) {
				resposta.setIsRefugoValido(false);
				resposta.setMilissegundos(0);
				resposta.setDthrUltRefugo(DataHrAtual);
				resposta.setCdRefugo("");
				resposta.setIdReduzidaProd("");
			} else if (retorno.compareTo("1") == 0) {
				prup.setIdreduzidaproduto(idRdzProduto.charAt(0));
				prup.setCdultimorefugo(cdRefugo);
				prup.setDthrultimorefugo(DataHrAtual);
				prup.setMsdthrultimorefugo(milisegundos);
				resposta.setIsRefugoValido(true);
				resposta.setMilissegundos((long) milisegundos);
				resposta.setDthrUltRefugo(DataHrAtual);
				resposta.setCdRefugo(cdRefugo);
				resposta.setIdReduzidaProd(idRdzProduto);
				this.getDaoPdba().flushReiniciandoTransacao();

				// Alessandre em 3-11-2014
				// Caso o idw esteja ativo � necess�rio lan�ar um inicio de ciclo com o mesmso horario de prup.dthriniciocci
				// Pois os dois sistemas precisam ter a mesma referencia de ciclo
				if (IdwFacade.getInstancia().isIDWAtivo() == true) {
					// Caso ocorra qualquer problema, o processo nao deve parar e seguir em frente pra finalizar execucao do metodo
						ProducaoPdbaMsEvtRN idwRN = new ProducaoPdbaMsEvtRN();
							idwRN.executarServico(getDaoPdba().getSession(), cdRefugo/*cdRefugo*/, cdCausa/*cdCausa*/, cdAcao/*cdAcao*/, Quantidade/*Quantidade*/, prup.getIdup().toString()/*IdUp*/, idRdzProduto/*idRdzProduto*/, DataHrAtual /*DataHrAtual*/);
				}

			}
		} else {
			resposta.setIsRefugoValido(false);
		}

		return (resposta);
	}

	public IwsConsultaDTO setTr_Consula(
			IdwLogger log, int idLog,
			String CdConsulta, String IdUp,
			Date DataHrAtual) throws SemSGBDException {

		IwsConsultaDTO resposta = new IwsConsultaDTO();
		/* Comentado para Liberar qualauer c�digo de consulta.
		if (!VaidaCodigodaConsulta(CdConsulta)) {
			resposta.setResposta(false);
			resposta.setCampoRSP1("Invalido");
			return resposta;
		}
		 */
		PrUp prup = null;
		prup = pesquisaPrup(log, idLog, IdUp);

		long milisegundos = DataHoraRN.getApenasMilisegundos(DataHrAtual);

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(19));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(DataHrAtual);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(DataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(DataHrAtual));
		prcoletoreventos.setInf01(CdConsulta);

		PrEventosBridgeCollecDb eventoResposta = null;
		try {
			eventoResposta = lancarEventoEsperaPrEventosBridgeCollecDb(log, idLog, prcoletoreventos, true);
		} catch (MestreOfflineException e) {		
			log.info("Detectou que BC est� OFF-line: " + IdUp);			
		}
		if(eventoResposta!=null){			
			resposta.setCampoRSP1(eventoResposta.getInf01());
			resposta.setCampoRSP2(eventoResposta.getInf02());
			resposta.setCampoRSP3(eventoResposta.getInf03());
			resposta.setCampoRSP4(eventoResposta.getInf04());
			resposta.setCampoRSP5(eventoResposta.getInf05());
			resposta.setCampoRSP6(eventoResposta.getInf06());
			resposta.setCampoRSP7(eventoResposta.getInf07());
			resposta.setCampoRSP8(eventoResposta.getInf08());
			resposta.setResposta(true);			
		}else{
			log.info("Consulta Não realizada cdConsulta: "+CdConsulta);	
		}
		return resposta;
	}

	public boolean setTr_ApagaUltimoRefugo(
			IdwLogger log, int idLog,
			String cdRefugo,
			String idRdzProduto, Date DthrUltRefugo, String milisec,
			String IdUp, Date DataHrAtual) throws SemSGBDException, ServicoFalhouException {

		PrUp prup = null;
		prup = pesquisaPrup(log, idLog, IdUp);
		long milisegundos = DataHoraRN.getApenasMilisegundos(DataHrAtual);

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(14));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(DataHrAtual);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(DataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(DataHrAtual));
		prcoletoreventos.setInf01(DataHoraRN.dateToStringYYYYMMDDHHMMSS(DthrUltRefugo));
		prcoletoreventos.setInf02(milisec);
		prcoletoreventos.setInf03(cdRefugo);
		prcoletoreventos.setInf04(idRdzProduto);

		/* Alessandre em 06-12-17 comentei a linha abaixo e substitui pela seguinte a fim de esperar o processamento do BC
		 * o objetivo é saber se o cancelamento foi feito
		 */
		//lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
		boolean isComTimeout = true;
		boolean isretorno = true;
		PrColetorEventos eventobc = lancarEventoRetornaPrColetorEventosConsolidado(log, idLog, prcoletoreventos, isComTimeout);

		if (eventobc != null)
			System.out.println("eventobc=" + eventobc.getStevento());
		else
			System.out.println("eventobc is null");
		
		if (eventobc != null && eventobc.getStevento().equals("1") == false) {
			isretorno = false;
			System.out.println("retorno false");
		}
		
		this.getDaoPdba().flushReiniciandoTransacao();

		// Se o idw estiver ativo entao lancar o evento de cancelamento de refugo
		if (IdwFacade.getInstancia().isIDWAtivo() == true) {
			// Caso ocorra qualquer problema, o processo nao deve parar e seguir em frente pra finalizar execucao do metodo
				ProducaoPdbaMsEvtRN idwRN = new ProducaoPdbaMsEvtRN();
					idwRN.executarServico(getDaoPdba().getSession(), prup.getIdup().toString(), null, prup.getDthrinicic(), null, null, ServicoFactory._APAGAULTIMOREFUGO, "setTr_ApagaUltimoRefugo " + DataHoraRN.getDataHoraAtualFormatada());
		}

		// Se o refugo foi cancelado entao limpar a referencia dele
		if (isretorno) {

			System.out.println("limpando refugo de prup");
			
			prup.setDthrultimorefugo(null);
			prup.setCdultimorefugo(null);
			prup.setIdreduzidaproduto(null);
			prup.setMsdthrultimorefugo(null);
			
			this.getDaoPdba().makePersistent(prup);
			
			this.getDaoPdba().flushReiniciandoTransacao();

		}
		
		return isretorno;
	}

	public boolean setTr_AlertaInicio(
			IdwLogger log, int idLog,
			String idUp, String cdAlerta, Date DataHrAtual) throws RegistroDesconhecidoException, ServicoFalhouException {
		boolean retorno = false;
		double milisegundos = DataHoraRN.getApenasMilisegundos(DataHrAtual);

		PrUp prup = null;
		prup = pesquisaPrup(log, idLog, idUp);

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(15));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(DataHrAtual);
		prcoletoreventos.setMsdthr1evento(milisegundos);
		prcoletoreventos.setDthr2evento(DataHrAtual);
		prcoletoreventos.setMsdthr2evento(milisegundos);
		prcoletoreventos.setInf01(cdAlerta);
		lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);

		retorno = true;
		return retorno;

	}

	public boolean setTr_AlertaFim(
			IdwLogger log, int idLog,
			String idUP, String cdAlerta,
			Date DataHrAtual) throws RegistroDesconhecidoException,
			SemSGBDException {
		boolean retorno = false;
		double milisegundos = DataHoraRN.getApenasMilisegundos(DataHrAtual);

		PrUp prup = null;
		prup = pesquisaPrup(log, idLog, idUP);

		InjetAlertaRN aRn = new InjetAlertaRN(getDaoInjet());
		IwsAlertaDTO dadoale = aRn.pesquisaAlertaEspecifico(log, idLog, prup.getCdmaquina(), cdAlerta);

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(16));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(DataHrAtual);
		prcoletoreventos.setMsdthr1evento(milisegundos);
		prcoletoreventos.setDthr2evento(DataHrAtual);
		prcoletoreventos.setMsdthr2evento(milisegundos);
		prcoletoreventos.setInf01(DataHoraRN.dateToStringYYYYMMDDHHMMSS(dadoale.getdthrinialerta()));
		prcoletoreventos.setInf02(String.valueOf(DataHoraRN.getApenasMilisegundos(dadoale.getdthrinialerta())));
		prcoletoreventos.setInf03(cdAlerta);
		lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);

		this.getDaoPdba().flushReiniciandoTransacao();

		retorno = true;
		return retorno;
	}

	public void setTr_InspecaoManual(
			IdwLogger log, int idLog,
			String idUp, Date dthrEvento,
			String cdProd, String dthrAlerta, String result)
					throws SemSGBDException {

		long milisegundos = DataHoraRN.getApenasMilisegundos(dthrEvento);
		PrUp prup = pesquisaPrup(log, idLog, idUp);
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(29));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dthrEvento);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(dthrEvento);
		prcoletoreventos.setMsdthr2evento(DataHoraRN
				.getApenasMilisegundos(dthrEvento));
		prcoletoreventos.setInf01(cdProd);
		prcoletoreventos.setInf02(dthrAlerta);
		prcoletoreventos.setInf03(result);
		lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
		this.getDaoPdba().flushReiniciandoTransacao();
	}

	public Boolean setTr_ApontamentoAramado(IdwLogger log, int idLog, String idUp, Date dthrEvento,
			String cdProd, String quantidade) throws SemSGBDException {
		// adicionar valida id rdz produto
		PrUp prup = pesquisaPrup(log, idLog, idUp);
		Boolean valida = false;
		String CodigoProdutoFUll = "";
		for (PrUpProduto prupproduto : prup.getPrUpProdutos()) {
			if (cdProd.equals((new Character(prupproduto.getIdreduzidaproduto())).toString())) {
				CodigoProdutoFUll = prupproduto.getCdproduto();
				valida = true;
				break;
			}
		}

		if (valida == false)
			return false;
		double milisegundos = DataHoraRN.getApenasMilisegundos(dthrEvento);
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(30));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dthrEvento);
		prcoletoreventos.setMsdthr1evento(milisegundos);
		prcoletoreventos.setDthr2evento(dthrEvento);
		prcoletoreventos.setMsdthr2evento(milisegundos);
		prcoletoreventos.setInf01(CodigoProdutoFUll);
		prcoletoreventos.setInf02(quantidade);
		lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
		this.getDaoPdba().flushReiniciandoTransacao();
		return true;
	}

	public PrColetorEventos obtemUltimoPrColetorEventos(PrUp prup) {
		PrColetorEventos retorno = null;
		// Obtem o registro incluido para retorno
		// limitar o numero de retornos deste select para otimizar o desempenho
		String hql = "";
		hql += "select prcoletoreventos ";
		hql += "from PrColetorEventos prcoletoreventos ";
		hql += "where prcoletoreventos.prUp.idup = '::idup' ";
		hql += "order by prcoletoreventos.ideventocoletor desc ";

		hql = hql.replaceAll("::idup", prup.getIdup().toString());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		q.setMaxResults(1);

		List<PrColetorEventos> listaPrColetorEventos = q.list();

		if (listaPrColetorEventos.size() >= 1) {
			retorno = (PrColetorEventos) listaPrColetorEventos.get(0);
		}
		return retorno;
	}

	public void verificaAtualizacoes(IdwLogger log, int idLog, String mac) {
		try {
			List<PrUp> lstPrup = getPrUps(log, idLog, mac);
			String listaIdup = "";
			int indice = 0;
			for (PrUp lcprup : lstPrup) {
				ProcessaMudancaConfigAndon(log, idLog, lcprup);
				if(lcprup.getStativa()=='1' && lcprup.getNrop()!=null && lcprup.getNrop().length()>0){
					atualizaPrUpProduto(lcprup.getIdup().toString());
				}
				if (indice > 0){
					listaIdup += ",";
				}
				listaIdup += "'" + lcprup.getIdup().toString() + "'";
				indice++;
			}
			if (indice == 0)
				return;
			String hql = "";
			hql += "select prupconfiguracoes ";
			hql += "from PrUpConfiguracoes prupconfiguracoes ";
			hql += "where prupconfiguracoes.prUp.idup in (::listaidup)";

			hql = hql.replaceAll("::listaidup", listaIdup);

			Query q = this.getDaoPdba().getSession().createQuery(hql);

			List<PrUpConfiguracoes> lista = q.list();

			for (PrUpConfiguracoes prupconfiguracoes : lista) {
				// CfgTamanhoUmPacoteCiclos
				// CfgPercTmpCicloParAuto
				// CfgPercToleranciaSinalCiclo
				// CfgPercTmpCicloInicializacao
				// CfgInterrupcaoCiclo
				// CfgDbc
				// TmpCicloPadrao
				// cfgTolerTmpCicloParAuto
				PrUp prup = prupconfiguracoes.getPrUp();
				if (prupconfiguracoes.getIdregsubcoletor() != null) {
					hql = "";
					hql += "select prsubcoletor ";
					hql += "from PrSubColetor prsubcoletor ";
					hql += "where prsubcoletor.idregsubcoletor = '::idregsubcolect' ";

					hql = hql.replaceAll("::idregsubcolect",
							prupconfiguracoes.getIdregsubcoletor());

					q = this.getDaoPdba().getSession().createQuery(hql);
					PrSubColetor prsubcoletor = (PrSubColetor) q.uniqueResult();
					log.info("alterando prup.prsubcoleto");
					prup.setPrSubColetor(prsubcoletor);
				}
				if (prupconfiguracoes.getCfgdbc() != null) {
					log.info("alterando prup.cfgdbc");
					prup.setCfgdbc(prupconfiguracoes.getCfgdbc());
				}

				if (prupconfiguracoes.getCfginterrupcaociclo() != null) {
					log.info("alterando prup.cfginterrupcaociclo");
					prup.setCfginterrupcaociclo(prupconfiguracoes.getCfginterrupcaociclo());
				}

				if (prupconfiguracoes.getCfgperctmpcicloinicializacao() != null) {
					log.info("alterando prup.cfgperctmpcicloinicializacao");
					prup.setCfgperctmpcicloinicializacao(prupconfiguracoes.getCfgperctmpcicloinicializacao());
				}
				
				if (prupconfiguracoes.getCfgperctoleranciasinalciclo() != null) {
					log.info("alterando prup.cfgperctoleranciasinalciclo");
					prup.setCfgperctoleranciasinalciclo(prupconfiguracoes.getCfgperctoleranciasinalciclo());
				}
				
				if (prupconfiguracoes.getCfgperctmpcicloparauto() != null) {
					prup.setCfgperctmpcicloparauto(prupconfiguracoes.getCfgperctmpcicloparauto());
					log.info("alterando prup.cfgperctmpcicloparauto");
				}

				if (prupconfiguracoes.getCfgtamanhoumpacoteciclos() != null) {
					prup.setCfgtamanhoumpacoteciclos(prupconfiguracoes.getCfgtamanhoumpacoteciclos());
					log.info("alterando prup.cfgtamanhoumpacoteciclos");
				}

				if (prupconfiguracoes.getCfgtpsessaoproducao() != null) {
					prup.setCfgtpsessaoproducao(prupconfiguracoes.getCfgtpsessaoproducao());
					log.info("alterando prup.cfgtpsessaoproducao");
				}

				if (prupconfiguracoes.getTmpciclopadrao() != null) {
					prup.setTmpciclopadrao(prupconfiguracoes.getTmpciclopadrao());
					log.info("alterando prup.tmpciclopadrao");
				}

				// vlauria 20100202
				if (prupconfiguracoes.getCfgtolertmpcicloparauto() != null) {
					if (prupconfiguracoes.getCfgtolertmpcicloparauto() != 0) {
						prup.setCfgtolertmpcicloparauto(prupconfiguracoes.getCfgtolertmpcicloparauto().longValue());
						log.info("alterando prup.cfgtolertmpcicloparauto");
					}
				}

				prupconfiguracoes.getPrEventosBridgeCollecDb().setStevento("1");
				this.getDaoPdba().getSession().merge(prupconfiguracoes.getPrEventosBridgeCollecDb());

				this.getDaoPdba().getSession().merge(prup); // Nao eh necessario
				// no momento, mais
				// a
				// frente na execucao ter� um merge em
				// prup

				this.getDaoPdba().getSession().delete(prupconfiguracoes);
				this.getDaoPdba().flushReiniciandoTransacao(); // APAGAR
			}
		} catch (Exception e) {
			log.info("erro", e);
			e.printStackTrace();
		}

	}

	public PrUpUltimaParada pesquisaPrup_ultimaparada(IdwLogger log, int idLog, PrUp prup) {
		return pesquisaPrup_ultimaparada(log, idLog, prup, false);
	}

	public PrUpUltimaParada pesquisaPrup_ultimaparada(
			IdwLogger log, int idLog,
			PrUp prup,
			boolean isFromSetaCod) {
		String hql = "";
		hql += "select prupultimaparada ";
		hql += "from PrUpUltimaParada prupultimaparada ";
		hql += "where prupultimaparada.idup = '::idup'";

		hql = hql.replaceAll("::idup", prup.getIdup().toString());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		PrUpUltimaParada retorno;
		try {
			retorno = (PrUpUltimaParada) q.uniqueResult();
		} catch (Exception e) {
			retorno = null;
			e.printStackTrace();
		}
		if (retorno == null && prup.getStparadaemaberto() != null
				&& prup.getCdultimaparada() != null) {
			// deve preencher PrUltimaParada com os dados de PrParada e o codigo
			// da Ultima parada.
			InjetParadaRN parrn = new InjetParadaRN(this.getDaoInjet(), this.getDaoPdba());
			retorno = new PrUpUltimaParada();
			if (isFromSetaCod) {
				retorno.setisParadaRegulagem('0');
			} else {
				try {
					IwsParadaDTO oParadaRN = parrn.getTr_TabParadaSetaCod(log, idLog, prup
							.getIdup().toString(), prup.getCdultimaparada());
					retorno.setCdAcao(oParadaRN.getCdAcao());
					retorno.setCdCausa(oParadaRN.getCdCausa());
					retorno.setCdJustificativa(oParadaRN.getCdJustificativa());
					retorno.setCdParada(oParadaRN.getCdParada());
					retorno.setCdTecnico1(oParadaRN.getCdTecnicoUm());
					retorno.setCdTecnico2(oParadaRN.getCdTecnicoDois());
					retorno.setCdTecnicoResponsavel(oParadaRN
							.getCdTecnicoResponsavel());
					retorno.setIdup(prup.getIdup().toString());
					retorno.setDtHrIParada(DataHoraRN.getDataComMilisegundos(
							prup.getDthriniultimaparada(),
							prup.getMsdthriniultimaparada()));
					if (oParadaRN.getIsRegulagem() == true)
						retorno.setisParadaRegulagem('1');
					else
						retorno.setisParadaRegulagem('0');
				} catch (Exception exc) {
					retorno.setisParadaRegulagem('0');
					exc.printStackTrace();
				}
			}
		}
		return retorno;
	}

	public boolean setTr_MCSemConexao(IdwLogger log, int idLog, String mac, Date dthrBeat)
			throws SemSGBDException, RegistroDesconhecidoException {
		// Obtem a lista de UPs
		List<PrUp> prups = null;
		try {
			prups = getPrUps(log, idLog, mac);
		} catch (SemSGBDException e) {
			return false;
		}

		// varre as ups do MC limpando o inicio dos ciclos
		for (PrUp prup : prups) {
			prup.setDthrinicic(null);
			prup.setMsdthrinicic(0d);
			// Adicionado para tratamaneto de tempo de espera by Senoj
			prup.setDthrfimcic(null);
			prup.setMsdthrfimcic(0d);
			prup.setStcicloemaberto('0');

			this.getDaoPdba().getSession().merge(prup);

			// Gera log de inicio de perda de conex�o
			PrColetorEventos prcoletoreventos = new PrColetorEventos();
			prcoletoreventos.setTpevento(new BigDecimal(97));
			prcoletoreventos.setStevento("3");
			prcoletoreventos.setDthr1evento(dthrBeat);
			prcoletoreventos.setMsdthr1evento(DataHoraRN
					.getApenasMilisegundos(dthrBeat));
			prcoletoreventos.setDthr2evento(dthrBeat);
			prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dthrBeat));
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setPrUp(prup);
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);

		}

		return true;
	}

	/*
	 * Pega os dados da tabela PR_UP_ANDON_PRCSFT dado um IDUP Retona NULL se o
	 * dado n�o existir Exception: SemSGBDException
	 */

	public PrUpAndonPrcsft getPrUpAndonPrcsft(String idup)
			throws SemSGBDException {
		String hql = "";
		hql += "select prupandonprcsft ";
		hql += "from PrUpAndonPrcsft prupandonprcsft ";
		hql += "where prupandonprcsft.idup = '::idup' ";

		hql = hql.replaceAll("::idup", idup);

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrUpAndonPrcsft> listaPrUpAndonPrcsft = null;
		try {
			listaPrUpAndonPrcsft = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		PrUpAndonPrcsft oPrUpAndonPrcsft = null;

		if (listaPrUpAndonPrcsft.size() > 0) { // tem registro
			oPrUpAndonPrcsft = listaPrUpAndonPrcsft.get(0);
		} else {
			oPrUpAndonPrcsft = null;
		}

		return (oPrUpAndonPrcsft);
	}

	public boolean getStatusPrUpAndon(String idup, boolean tipo)
			throws SemSGBDException { // vlauria 20100318

		String hql = "";
		hql += "select prconexoesinjet ";
		hql += "from PrConexoesInjet prconexoesinjet, PrUp prup ";
		hql += "where prconexoesinjet.idregconexaoinjet = prup.prConexoesInjet.idregconexaoinjet ";
		hql += "and prup.idup = '::idup'";

		hql = hql.replaceAll("::idup", idup);

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		List<PrConexoesInjet> listaPrConexoesInjet = null;
		try {
			listaPrConexoesInjet = q.list();
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		PrConexoesInjet oPrConexoesInjet = new PrConexoesInjet();

		if (listaPrConexoesInjet.size() > 0) { // tem registro
			oPrConexoesInjet = listaPrConexoesInjet.get(0);
		} else {
			oPrConexoesInjet = null;
		}
		if (tipo == true) {
			if (oPrConexoesInjet != null
					&& (oPrConexoesInjet.getStAndonProcessoft() == 1)) {
				return true;
			}
			return false;
		} else {
			if (oPrConexoesInjet != null
					&& (oPrConexoesInjet.getStAndonConfiguravel() == 1)) {
				return true;
			}
			return false;
		}
	}

	public IwsUpAndonPrcsftDTO setTr_getPrUpAndonPrcsft(String idup)
			throws SemSGBDException {
		PrUpAndonPrcsft prUpAndonPrcsft;
		IwsUpAndonPrcsftDTO upAndonPrcsftDTO = new IwsUpAndonPrcsftDTO();

		prUpAndonPrcsft = getPrUpAndonPrcsft(idup);

		if (prUpAndonPrcsft != null) {
			upAndonPrcsftDTO.copyPrUpAndonPrcsft(prUpAndonPrcsft);
			upAndonPrcsftDTO.seterro(false);
		} else {
			upAndonPrcsftDTO.seterro(true);
		}

		return (upAndonPrcsftDTO);
	}

	public IwsReleDTO setTr_getRele8(String idup)
			throws RegistroDesconhecidoException, SemSGBDException {
		PrUpAndonPrcsft oPrUpAndonPrcsft = getPrUpAndonPrcsft(idup);
		IwsReleDTO oRele8 = new IwsReleDTO();

		if (oPrUpAndonPrcsft != null) {
			oRele8.setINF01("4");
			oRele8.setINF02(oPrUpAndonPrcsft.getstRele8());
			oRele8.setINF03("1"); // ligar rele em modo continuo
			oRele8.setINF04(oPrUpAndonPrcsft.gettmpRele8Lig().toString());
			oRele8.setINF05(oPrUpAndonPrcsft.gettmpRele8Des().toString());
			oRele8.setvlRefEficUltCiclo(oPrUpAndonPrcsft.getvlRefEficUltCiclo()
					.toString());
		} else {
			return null;
			// throw new RegistroDesconhecidoException();
		}

		return (oRele8);
	}

	public IwsReleDTO setTr_getRele8Ciclo(IdwLogger log, int idLog, String idup)
			throws RegistroDesconhecidoException, SemSGBDException,
			NullPointerException {
		IwsReleDTO oRele8DTO = new IwsReleDTO();

		PrUp prup = pesquisaPrupExt(idup);

		List<PrUp> prups = null;
		PrColetor oPrColetor;

		if (prup != null) {
			oPrColetor = prup.getPrSubColetor().getPrColetor();

			if (oPrColetor == null)
				throw new NullPointerException();

			// Obtem a lista de UPs
			prups = getPrUps(log, idLog, oPrColetor.getIdcoletor());

			for (PrUp oprup : prups) {
				oRele8DTO = this.setTr_getRele8(oprup.getIdup().toString());

				if (oRele8DTO != null && (oprup.getvleficultciclo() != null)
						&& (oRele8DTO.getvlRefEficUltCiclo()) != null
						&& (oprup.getStparadaemaberto() != null)) {
					if ((oprup.getStparadaemaberto() == '0')
							&& oprup.getvleficultciclo() < Double
							.parseDouble(oRele8DTO
									.getvlRefEficUltCiclo())) {
						oRele8DTO.setINF03("0");
						break;
					} else
						oRele8DTO.setINF03("1");
				}
			}
		} else {
			throw new NullPointerException();
		}
		return (oRele8DTO);
	}

	public PrUp pesquisaPrupExt(String idup) {
		String hql = "";

		hql += "select prup ";
		hql += "from PrUp prup ";
		hql += "join fetch prup.prSubColetor prsubcoletor ";
		hql += "join fetch prsubcoletor.prColetor prcoletor ";
		hql += "where prup.idup = '::idup'";

		hql = hql.replaceAll("::idup", idup);

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		PrUp oPrUp = null;

		try {
			oPrUp = (PrUp) q.uniqueResult();
		} catch (Exception e) {
			oPrUp = null;
		}

		return oPrUp;
	}

	// modifica��es para o m�dulo de qualidade II

	public PrUpExecinspecao getTr_VerificaExecInspecao(String idUp) // vlauria
	// 20100308
			throws SemSGBDException {
		
		PrUpExecinspecao atbl=null;
		
		MapQuery mapQuery = new MapQuery(this.getDaoPdba().getSession());	
		mapQuery.append("select atbl ");
		mapQuery.append("from PrUpExecinspecao atbl");	
		mapQuery.append("where atbl.prUpCtrlExecinspecao.idup = :idup");
		mapQuery.defineParametro("idup", idUp );
		mapQuery.query().setMaxResults(1);	
		try {
			atbl = (PrUpExecinspecao) mapQuery.query().uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return (atbl);
	}

	public IwsInspecaoManualDTO setTr_LancaEventoInspecao(IdwLogger log, int idLog, String idUp, // vlauria
			// 20100309
			Date DataHrAtual) throws SemSGBDException {

		PrUp prup = new PrUp();
		prup = pesquisaPrup(log, idLog, idUp);
		IwsInspecaoManualDTO resposta = new IwsInspecaoManualDTO();
		resposta.setIscomalertaprobqualidade(false);
		resposta.setIsinspemandamento(false);
		resposta.setIsSemInspecao(false);

		long milisegundos = DataHrAtual.getTime() % 1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(31));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(DataHrAtual);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(DataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN
				.getApenasMilisegundos(DataHrAtual));

		PrEventosBridgeCollecDb eventoResposta = null;
		try {
			eventoResposta = lancarEventoEsperaPrEventosBridgeCollecDb(log, idLog,
					prcoletoreventos, true);

		} catch (MestreOfflineException e) {
			resposta.setErro(true);
			resposta.setMsgErro("Bridge Collector (BC) est� Offline.");
			return (resposta);
		}

		if (eventoResposta.getTpevento().equals(new BigDecimal(34))) {
			String retorno = eventoResposta.getInf01();
			if (retorno.equals("0")) {
				resposta.setErro(true);
				resposta.setMsgErro(eventoResposta.getTxtmensagem());
				resposta.setInf02(eventoResposta.getInf02());
				switch (Integer.valueOf(eventoResposta.getInf02())) {
				case 12:
					resposta.setInf01("30");
					break;
				case 19:
					resposta.setInf01("31");
					break;
				case 20:
					resposta.setInf01("32");
					break;
				case 153:
					resposta.setInf01("33");
					break;
				case 154:
					resposta.setInf01("34");
					break;
				case 155:
					resposta.setInf01("20");
					resposta.setIsSemInspecao(true);
					break;
				case 156:
					resposta.setInf01("35");
					break;
				case 179:
					resposta.setInf01("23");
					resposta.setIsinspemandamento(true);
					break;
				case 183:
					resposta.setInf01("36");
					break;
				case 184:
					resposta.setInf01("37");
					break;
				case 187:
					resposta.setInf01("22");
					resposta.setIscomalertaprobqualidade(true);
					break;
				case 188:
					resposta.setInf01("38");
					break;
				default:
					resposta.setInf01("21");
					break;
				}
				resposta.setPrupexecinspecao(null);

			} else if (retorno.equals("1")) {
				resposta.setErro(false);
				resposta.setInf01("0");
				resposta.setInf02("0");

				resposta.setIsSemInspecao(false);
				resposta.setIscomalertaprobqualidade(false);
				resposta.setIsinspemandamento(false);
				resposta.setPrupexecinspecao(null);

			} else {
				resposta.setErro(true);
				resposta.setMsgErro("Par�metros do BC est�o incorretos. Entre em Contato com o Suporte.");
				resposta.setInf01("1");
				resposta.setInf02("1"); // detetmina que o par�metro INF01 no
				// evento 34 � incorreto
				resposta.setPrupexecinspecao(null);
			}
			return (resposta);
		} else {
			resposta.setErro(true);
			resposta.setMsgErro("Evento do BC incorreto. Entre em Contato com o Suporte.");
			// resposta = null;
			return resposta;
		}

	}

	public Ijdrivercent getDadosDoDriver(IdwLogger log, int idLog, String idup,String IdDriver)throws SemSGBDException{		

		PrUp prup = pesquisaPrup(log, idLog, idup);
		String idcoletor=prup.getPrSubColetor().getPrColetor().getIdcoletor();
		MapQuery mapQuery = new MapQuery(this.getDaoInjet().getSession());	
		mapQuery.append("select btbl ");
		mapQuery.append("from Ijdrivercent btbl ");
		mapQuery.append("join fetch btbl.ijtbcentinsp atbl ");
		mapQuery.append("join fetch btbl.ijtbdrivers ctbl ");		
		mapQuery.append("where atbl.tpcentral = 2 ");
		mapQuery.append("and atbl.idhost = :idcoletor " );	
		mapQuery.append("and ctbl.iddriver = :iddriver " );
		mapQuery.defineParametro("idcoletor", idcoletor );
		mapQuery.defineParametro("iddriver", IdDriver );
		mapQuery.query().setMaxResults(1);			
		Ijdrivercent btbl = (Ijdrivercent) mapQuery.query().uniqueResult();
		return btbl;		
	}

	public IwsInspecaoManualDTO getTr_ParametrosInspecao(
			IdwLogger log, int idLog,
			String idup)throws SemSGBDException {
		IwsInspecaoManualDTO inspDTO = new IwsInspecaoManualDTO();
		try{
			MapQuery mapQuery = new MapQuery(this.getDaoPdba().getSession());
			mapQuery.append("select otbl ");
			mapQuery.append("from PrUpExecinspecao otbl ");
			mapQuery.append("join fetch otbl.prUpCtrlExecinspecao btbl ");
			mapQuery.append("where otbl.idInspecao = btbl.idInspecao " );
			mapQuery.append("and btbl.idup = :idup ");
			mapQuery.append("and otbl.stExecucao = '1'  ");
			mapQuery.append("order by  otbl.ordemLeitura, otbl.idCavidade, otbl.amostra, otbl.subAmostra ");		
			mapQuery.defineParametro("idup", idup);
			mapQuery.query().setMaxResults(1);
			PrUpExecinspecao otbl = (PrUpExecinspecao) mapQuery.query().uniqueResult();

			if (otbl != null) {
				inspDTO.copyPrUpExecinspecao(otbl);
				if((inspDTO.getPrupexecinspecao().getTpEntradaVlr().equals(2))||
						(inspDTO.getPrupexecinspecao().getTpEntradaVlr().equals(0))){
					Ijdrivercent btbl=getDadosDoDriver(log, idLog, idup,otbl.getIdDriver());
					if(btbl==null){
						inspDTO.getPrupexecinspecao().setPorta("1");
						log.info("Erro ao obter Dados do Driver:"+inspDTO.getPrupexecinspecao().getIdDriver());
					}else
						inspDTO.getPrupexecinspecao().setPorta(btbl.getIdportacom());
					// obtem dados de drivers
				}
			}else{
				inspDTO.setPrupexecinspecao(null);
			}
			otbl = null;
			mapQuery = null;
			return inspDTO;
		}catch(Exception e){
			e.printStackTrace();
			throw new SemSGBDException();
		}
	}

	public void setTr_atualizaResultadoInspecao(String idUp,
			IwsDadosInspDTO resultadoInspecao) { // vlauria 20100309
		String sql = "";

		sql = "";

		sql += "delete from Pr_Up_Execinspecao where idexecinpecao = '::idexecinspecao' ";

		sql = sql.replaceAll("::idexecinspecao",
				resultadoInspecao.getIdExecInpecao());

		Query q = this.getDaoPdba().getSession().createSQLQuery(sql);

		try {
			q.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.getDaoPdba().flushReiniciandoTransacao();

		String hql = "";

		hql += "select prupexecinspecao ";
		hql += "from PrUpExecinspecao prupexecinspecao ";
		hql += "where prupexecinspecao.prUpCtrlExecinspecao.idup = '::idup' ";

		hql = hql.replaceAll("::idup", idUp);

		// List<Object> listaPrUpExecinspecao = new ArrayList<Object>();
		List<PrUpExecinspecao> listaPrUpExecinspecao = new ArrayList<PrUpExecinspecao>();

		q = this.getDaoPdba().getSession().createQuery(hql);

		try {
			listaPrUpExecinspecao = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			listaPrUpExecinspecao = null;
		}

		this.getDaoPdba().flushReiniciandoTransacao();

		if (listaPrUpExecinspecao == null || listaPrUpExecinspecao.isEmpty()) {

			sql = "";

			sql += "delete from Pr_Up_Ctrl_Execinspecao where idinspecao = '::idexecinspecao' ";

			sql = sql.replaceAll("::idexecinspecao",
					resultadoInspecao.getIdInspecao());

			q = this.getDaoPdba().getSession().createSQLQuery(sql);

			try {
				q.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

			this.getDaoPdba().flushReiniciandoTransacao();
		}

		return;
	}

	public IwsErroDTO setTr_LancaEventoFimInspecao(IdwLogger log, int idLog, String idUp,
			Date DataHrAtual, // vlauria 20100315
			IwsDadosInspDTO dadosInspecao) throws SemSGBDException {

		IwsErroDTO erro = new IwsErroDTO();

		PrUp prup = null;
		prup = pesquisaPrup(log, idLog, idUp);

		long milisegundos = DataHrAtual.getTime() % 1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(32));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(DataHrAtual);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(DataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN
				.getApenasMilisegundos(DataHrAtual));
		prcoletoreventos.setInf01(dadosInspecao.getIdInspecao());
		prcoletoreventos.setInf02(dadosInspecao.getCdProduto());
		prcoletoreventos.setInf03(dadosInspecao.getIdParametro());
		prcoletoreventos.setInf04(String.valueOf(dadosInspecao.getIdCavidade()));
		prcoletoreventos.setInf05(String.valueOf(dadosInspecao.getAmostra()));
		prcoletoreventos.setInf06(String.valueOf(dadosInspecao.getVlLido()));

		try {
			lancarEventoEsperaPrEventosBridgeCollecDb(log, idLog, prcoletoreventos, false);


			setTr_atualizaResultadoInspecao(idUp, dadosInspecao);
			erro.setSucesso(true);
		} catch (MestreOfflineException e) {
			erro.setSucesso(false);
			erro.setMensagem("Bridge Collector (BC) est� Offline.");
			// return;
		}

		return (erro);
	}

	private void limpaDadosAndon(PrUp prup){
		try {		
			MapQuery q = new MapQuery(getDaoPdba().getSession());
			q.append("delete");
			q.append("from PrUpAndonArg oandon");
			q.append("where oandon.id.idup = :idup");
			q.defineParametro("idup", prup.getIdup().toString());				
			q.query().executeUpdate();

			q.novaConsulta();				
			q.append("delete");
			q.append("from PrUpAndon oandon");
			q.append("where oandon.id.idup = :idup");
			q.defineParametro("idup", prup.getIdup().toString());
			q.query().executeUpdate();				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	private boolean verificaSeAtualizaAndon(
			IdwLogger log, int idLog,
			String cdMaquina){
		boolean retorno=false;
		MapQuery q = new MapQuery(getDaoInjet().getSession());	
		q.append("select otbl from Ijcfgandmaqevt otbl");
		q.append("where otbl.stsincronismo='1'");
		q.append("and otbl.ijtbinj.cdinjetora = :cdmaquina");
		q.defineParametro("cdmaquina", cdMaquina);
		q.setMaxResults(1);
		try{
			Ijcfgandmaqevt otbl=(Ijcfgandmaqevt)q.uniqueResult();
			if(otbl!=null)
				retorno=true;
		}catch(Exception e){
			log.info("Comportamento inadequado em verificaSeAtualizaAndon para Maquina:"+cdMaquina);
		}		 
		return retorno;
	}

	private void setStSincronismo(IdwLogger log, int idLog, String cdMaquina){
		MapQuery q = new MapQuery(getDaoInjet().getSession());	
		q.append("update Ijcfgandmaqevt otbl");
		q.append("set otbl.stsincronismo='0'");
		q.append("where otbl.stsincronismo='1'");
		q.append("and otbl.ijtbinj.cdinjetora = :cdmaquina");
		q.defineParametro("cdmaquina", cdMaquina);
		try{
			q.query().executeUpdate();
		}catch(Exception e){
			log.info("Comportamento inadequado em setStSincronismo para Maquina:"+cdMaquina);
		}	
	}

	private void ProcessaMudancaConfigAndon(IdwLogger log, int idLog, PrUp prup) {		
		// Verifca se atualiza andon
		boolean deveAtualizar=verificaSeAtualizaAndon(log, idLog, prup.getCdmaquina());

		if(deveAtualizar){
			try{
				limpaDadosAndon(prup); // Limpa dados para evitar confus�o de revalida��o.				
			}catch(Exception exc){
				log.info("Erro ao excluir dados de Andon para IDUP:"+prup.getIdup().toString());
				exc.printStackTrace();
				return;
			}
			try{
				MapQuery q = new MapQuery(getDaoInjet().getSession());	
				q.append("select otbl from Ijcfgandmaqevt otbl");
				q.append("where otbl.stexclusao=0");
				q.append("and otbl.stativo=1");
				q.append("and otbl.ijtbinj.cdinjetora = :cdmaquina");
				q.append("order by otbl.ideventoandon");
				q.defineParametro("cdmaquina", prup.getCdmaquina());
				List<Ijcfgandmaqevt> listaIjcfgandmaqevt =null;
				listaIjcfgandmaqevt = q.list();
				if(listaIjcfgandmaqevt!=null && listaIjcfgandmaqevt.size()>0){
					for(Ijcfgandmaqevt obj :listaIjcfgandmaqevt){
						PrUpAndonId oAndonid = new PrUpAndonId(obj.getIdeventoandon(),prup.getIdup().toString());
						PrUpAndon oAndon = new PrUpAndon(oAndonid,prup,obj.getIjtbtpeventoandon().getTpeventoandon(),
								obj.getIjtbrele().getIdrele(),obj.getIjtbrele().getIdreleaux(),obj.getPrioridade(),
								obj.getStintermitente(),obj.getTmpsinalalto(),obj.getTmpsinalbaixo(),obj.getStativo(),null);
						oAndon=getDaoPdba().makePersistent(oAndon);
						for(Ijcfgandmaqevtarg objarg:obj.getIjcfgandmaqevtargs()){
							PrUpAndonArgId oArgId = new PrUpAndonArgId(prup.getIdup().toString(),obj.getIdeventoandon(),
									objarg.getId().getOrdemcondicao());
							PrUpAndonArg oArg = new PrUpAndonArg(oArgId,oAndon,objarg.getOperadorlogico(),objarg.getOperadorcalculo(),
									objarg.getTpvlreferencia(),objarg.getVlreferenciastr(),objarg.getVlreferencianum());
							getDaoPdba().makePersistent(oArg);									
						}
					}
				}	
				setStSincronismo(log, idLog, prup.getCdmaquina());
				getDaoPdba().flushReiniciandoTransacao();
				getDaoInjet().flushReiniciandoTransacao();	
				log.info("Dados de Andon Atualizados para IDUP:"+prup.getIdup().toString());
			}catch(Exception exc){
				log.info("Erro ao Atualizar dados de Andon para IDUP:"+prup.getIdup().toString());
				exc.printStackTrace();
				return;
			}			
		}
	}

	private Boolean evento38AlertaInspecao(PrEventosBridgeCollecDb eventoBC,
			PrUp prup) { // vlauria 20100319
		List<PrUpAndonAlertaInspecao> listaAndonInsp = new ArrayList<PrUpAndonAlertaInspecao>();

		if (eventoBC.getInf01().equals("1")) {
			String hql = "";

			hql += "select prupandonalertainspecao ";
			hql += "from PrUpAndonAlertaInspecao prupandonalertainspecao ";
			hql += "where prupandonalertainspecao.id.idup = '::idup' ";

			hql = hql.replaceAll("::idup", prup.getIdup().toString());

			Query q = this.getDaoPdba().getSession().createQuery(hql);

			try {
				listaAndonInsp = q.list();
			} catch (Exception e) {
				e.printStackTrace();
				listaAndonInsp = null;
			}

			if (listaAndonInsp != null && listaAndonInsp.size() > 0) {
				String sql = "";

				sql += "update PrUpAndonAlertaInspecao prupandonalertainspecao ";
				sql += "set prupandonalertainspecao.nrop = '::nrop', ";
				sql += " prupandonalertainspecao.cdmolde = '::cdmolde', ";
				sql += " prupandonalertainspecao.cdestrutura = '::cdestrutura', ";
				sql += " prupandonalertainspecao.cdproduto = '::cdproduto', ";
				sql += " prupandonalertainspecao.dthralerta = :data, ";
				sql += " prupandonalertainspecao.tmpliminspqld = ::tmpliminspqld ";
				sql += "where prupandonalertainspecao.idup = '::idup' ";

				sql = sql.replaceAll("::idup", prup.getIdup().toString());
				if (prup.getNrop() != null)
					sql = sql.replaceAll("::nrop", prup.getNrop());
				else
					sql = sql.replaceAll("::nrop", "");
				if (prup.getCdmolde() != null)
					sql = sql.replaceAll("::cdmolde", prup.getCdmolde());
				else
					sql = sql.replaceAll("::cdmolde", "");
				if (prup.getCdestrutura() != null)
					sql = sql
					.replaceAll("::cdestrutura", prup.getCdestrutura());
				else
					sql = sql.replaceAll("::cdestrutura", "");
				sql = sql.replaceAll("::cdproduto", eventoBC.getInf02());
				sql = sql.replaceAll("::tmpliminspqld", eventoBC.getInf04());
				q = this.getDaoPdba().getSession().createQuery(sql);

				try {
					q.setTimestamp("data", DataHoraRN.stringToDate(
							eventoBC.getInf03(), DataHoraRN.YYYYMMDDHHMMSS));
				} catch (Exception e) {
					q.setTimestamp("data", eventoBC.getDthrevento());
					e.printStackTrace();
				}

				q.executeUpdate();

				this.getDaoPdba().flushReiniciandoTransacao();
			} else {
				String sql = "";

				sql += "insert into Pr_Up_Andon_Alerta_Inspecao ( ";
				sql += "IDUP, NROP, CDMOLDE, CDESTRUTURA, CDPRODUTO, DTHRALERTA, TMPLIMINSPQLD )";
				sql += "values ( ";
				sql += " '::idup', '::nrop', '::cdmolde', '::cdestrutura', '::cdproduto', :data, ::tmpliminspqld ) ";

				sql = sql.replaceAll("::idup", prup.getIdup().toString());
				if (prup.getNrop() != null)
					sql = sql.replaceAll("::nrop", prup.getNrop());
				else
					sql = sql.replaceAll("::nrop", "");
				if (prup.getCdmolde() != null)
					sql = sql.replaceAll("::cdmolde", prup.getCdmolde());
				else
					sql = sql.replaceAll("::cdmolde", "");
				if (prup.getCdestrutura() != null)
					sql = sql
					.replaceAll("::cdestrutura", prup.getCdestrutura());
				else
					sql = sql.replaceAll("::cdestrutura", "");
				sql = sql.replaceAll("::cdproduto", eventoBC.getInf02());
				sql = sql.replaceAll("::tmpliminspqld", eventoBC.getInf04());

				q = this.getDaoPdba().getSession().createSQLQuery(sql);
				try {
					q.setTimestamp("data", DataHoraRN.stringToDate(
							eventoBC.getInf03(), DataHoraRN.YYYYMMDDHHMMSS));
				} catch (Exception e) {
					q.setTimestamp("data", eventoBC.getDthrevento());
					e.printStackTrace();
				}
				q.executeUpdate();

				this.getDaoPdba().flushReiniciandoTransacao();
			}
			return true;
		} else {
			if (eventoBC.getInf01().equals("2")) {
				String sql = "";

				sql += "delete from Pr_Up_Andon_Alerta_Inspecao ";
				sql += "where idup = '::idup' ";

				sql = sql.replaceAll("::idup", prup.getIdup().toString());

				Query q = this.getDaoPdba().getSession().createSQLQuery(sql);

				q.executeUpdate();

				this.getDaoPdba().flushReiniciandoTransacao();

				return false;
			}
		}
		return false;
	}

	public IwsErroDTO setTr_LancaAberturaInspecao(IdwLogger log, int idLog, String idUp, Date dtHr) { // vlauria
		// 20100321
		PrUp prup = null;
		prup = pesquisaPrup(log, idLog, idUp);

		long milisegundos = dtHr.getTime() % 1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(41));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dtHr);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(dtHr);
		prcoletoreventos.setMsdthr2evento(DataHoraRN
				.getApenasMilisegundos(dtHr));

		IwsErroDTO erro = new IwsErroDTO();

		try {
			PrEventosBridgeCollecDb eventoResposta = lancarEventoEsperaPrEventosBridgeCollecDb(log, idLog,
					prcoletoreventos, true);

			if (eventoResposta != null && eventoResposta.getInf01() != null
					&& eventoResposta.getInf01().equals("1")
					&& eventoResposta.getTpevento().equals(new BigDecimal(52))) {
				erro.setSucesso(true);
			} else {
				erro.setSucesso(false);
				if (eventoResposta != null)
					;
				erro.setMensagem(eventoResposta.getTxtmensagem());
			}

		} catch (MestreOfflineException e) {
			erro.setSucesso(false);
			erro.setMensagem("Bridge Collector (BC) est� Offline.");
		}

		return (erro);
	}

	public boolean setTr_buscaAleraProbQuali(String cdMaquina)
			throws SemSGBDException { 
		IdwLogger log = new IdwLogger(cdMaquina);
		int idLog = log.getIdAleatorio();
		List<IwsAlertaDTO> lcAlertaDto = null;
		InjetAlertaRN aRn = new InjetAlertaRN(getDaoInjet());
		lcAlertaDto = aRn.pesquisaAlertasProblemaQualidade(log, idLog, cdMaquina);
		aRn = null;
		if (lcAlertaDto != null && lcAlertaDto.size() > 0)
			return true;
		return false;
	}

	public IwsErroDTO setTr_buscaAleraProbQualiRet(IdwLogger log, int idLog, String cdMaquina)
			throws SemSGBDException {
		IwsErroDTO retorno = new IwsErroDTO();
		retorno.setSucesso(false);
		retorno.setMensagem("Sem Alerta de Problema de Qualidade");
		if (setTr_buscaAleraProbQuali(cdMaquina)) {
			retorno.setSucesso(true);
			retorno.setMensagem("");
		}		
		return (retorno); // erro: sem alerta de problema de qualidade aberto
	}

	public IwsErroDTO encerraAlertaProbQuali(
			IdwLogger log, int idLog,
			String idUp, Date dtHrEvento,
			String cdUsuario) throws SemSGBDException { // vlauria 20100323
		Date dtHrIniAlerta = new Date();
		List<IwsAlertaDTO> vetorAlerta = null;
		IwsErroDTO retorno = new IwsErroDTO();

		PrUp prup = null;
		prup = pesquisaPrup(log, idLog, idUp);
		try {
			InjetAlertaRN aRn = new InjetAlertaRN(getDaoInjet());
			vetorAlerta = aRn.pesquisaAlertasProblemaQualidade(log, idLog, prup.getCdmaquina());
			aRn = null;
		} catch (SemSGBDException e) {
			throw new SemSGBDException();
		} catch (Exception e) {
			retorno.setSucesso(false);
			retorno.setMensagem("Alerta de Problema de Qualidade n�o foi Finalizado.");
			// return false; //alerta de problema de qualidade no foi finalizado
		}

		if (vetorAlerta != null && vetorAlerta.size() > 0) {
			dtHrIniAlerta = vetorAlerta.get(0).getdthrinialerta();
		}

		long milisegundos = dtHrEvento.getTime() % 1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(42));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dtHrEvento);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(dtHrEvento);
		prcoletoreventos.setMsdthr2evento(DataHoraRN
				.getApenasMilisegundos(dtHrEvento));
		prcoletoreventos.setInf01(DataHoraRN.dateToString(dtHrIniAlerta,
				DataHoraRN.YYYYMMDDHHMMSS));
		prcoletoreventos.setInf02(cdUsuario);

		try {
			lancarEventoEsperaPrEventosBridgeCollecDb(log, idLog, prcoletoreventos, false);
		} catch (MestreOfflineException e) {
			retorno.setSucesso(false);
			retorno.setMensagem("Bridge Collector (BC) est� Offline.");
		}

		this.getDaoPdba().flushReiniciandoTransacao();

		retorno.setSucesso(true);
		return (retorno); // alerta de problema de qualidade foi finalizado
	}

	private BigDecimal consultaTempoEventoAndonInsp(PrUp prup) { // vlauria
		// 20100324
		List<PrUpAndonAlertaInspecao> lcAndonAlertaInsp = new ArrayList<PrUpAndonAlertaInspecao>();
		BigDecimal tmpLimExecInsp;

		String hql = "";

		hql += "select prupandonalertainspecao ";
		hql += "from PrUpAndonAlertaInspecao prupandonalertainspecao ";
		hql += "where prupandonalertainspecao.idup = '::idup' ";

		hql = hql.replaceAll("::idup", prup.getIdup().toString());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		try {
			lcAndonAlertaInsp = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			lcAndonAlertaInsp = null;
		}

		if (lcAndonAlertaInsp != null && lcAndonAlertaInsp.size() > 0) {
			tmpLimExecInsp = lcAndonAlertaInsp.get(0).getTmpliminspqld();
			return tmpLimExecInsp;
		} else
			return (new BigDecimal(0));
	}

	private String consultaResulUltimaInsp(
			IdwLogger log, int idLog,
			PrUp prup,
			PrEventosBridgeCollecDb eventoBC) {
		PrUpAndonResultUltimaInsp lcAndonResulInsp = new PrUpAndonResultUltimaInsp();
		String resultado = "";

		String hql = "";

		hql += "select prupandonresultultimainspecao ";
		hql += "from PrUpAndonResultUltimaInsp prupandonresultultimainspecao ";
		hql += "where prupandonresultultimainspecao.idup = '::idup' ";

		hql = hql.replaceAll("::idup", prup.getIdup().toString());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		try {
			lcAndonResulInsp = (PrUpAndonResultUltimaInsp) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			lcAndonResulInsp = null;
		}

		if (lcAndonResulInsp != null) {
			String sql = "";

			sql += "update Pr_Up_Andon_Result_Ultima_Insp set ";
			if (lcAndonResulInsp.getNrop() != null
					&& !lcAndonResulInsp.getNrop().equals(eventoBC.getNrop()))
				sql += "NROP='::nrop' ,";
			if (lcAndonResulInsp.getCdmolde() != null
					&& !lcAndonResulInsp.getCdmolde().equals(
							eventoBC.getCdmolde()))
				sql += "CDMOLDE='::cdmolde' ,";
			if (lcAndonResulInsp.getCdestrutura() != null
					&& !lcAndonResulInsp.getCdestrutura().equals(
							eventoBC.getCdestrutura()))
				sql += "CDESTRUTURA='::cdestrutura' ,";

			sql += "ULTIMORESULTADO=::ultimoresultado";
			sql += "where idup='::idup'";

			sql = sql.replaceAll("::idup", prup.getIdup().toString());
			if (lcAndonResulInsp.getNrop() != null
					&& !lcAndonResulInsp.getNrop().equals(eventoBC.getNrop()))
				sql = sql.replaceAll("::nrop", prup.getNrop());

			if (lcAndonResulInsp.getCdmolde() != null
					&& !lcAndonResulInsp.getCdmolde().equals(
							eventoBC.getCdmolde()))
				sql = sql.replaceAll("::cdmolde", prup.getCdmolde());

			if (lcAndonResulInsp.getCdestrutura() != null
					&& !lcAndonResulInsp.getCdestrutura().equals(
							eventoBC.getCdestrutura()))
				sql = sql.replaceAll("::cdestrutura", prup.getCdestrutura());

			sql = sql.replaceAll("::ultimoresultado", eventoBC.getInf01());

			q = this.getDaoPdba().getSession().createSQLQuery(sql);

			q.executeUpdate();

			this.getDaoPdba().flushReiniciandoTransacao();

			resultado = String.valueOf(eventoBC.getInf01());
			return resultado;
		} else {
			String sql = "";

			sql += "insert into Pr_Up_Andon_Result_Ultima_Insp ( ";
			sql += "IDUP, NROP, CDMOLDE, CDESTRUTURA, ULTIMORESULTADO)";
			sql += "values ( ";
			sql += " '::idup', '::nrop', '::cdmolde', '::cdestrutura', '::ultimoresultado') ";
			sql = sql.replaceAll("::idup", prup.getIdup().toString());
			if (prup.getNrop() != null && prup.getCdmolde() != null
					&& prup.getCdestrutura() != null) {
				sql = sql.replaceAll("::nrop", prup.getNrop());
				sql = sql.replaceAll("::cdmolde", prup.getCdmolde());
				sql = sql.replaceAll("::cdestrutura", prup.getCdestrutura());
				sql = sql.replaceAll("::ultimoresultado", eventoBC.getInf01());
				q = this.getDaoPdba().getSession().createSQLQuery(sql);

				q.executeUpdate();

				this.getDaoPdba().flushReiniciandoTransacao();
			} else {
				log.info("-ERRO-Dados de planejamento est�o nulos: ");
				log.info("idup= " + prup.getIdup());
				log.info("nrop= " + prup.getNrop());
				log.info("molde= " + prup.getCdmolde());
				log.info("estrutura= " + prup.getCdestrutura());
			}
		}
		return resultado = "";
	}

	private IwsAndonIndicadoresDTO consultaIndicadoresAndon(String idUp) {
		IwsAndonIndicadoresDTO resposta = new IwsAndonIndicadoresDTO();
		MapQuery q = new MapQuery(getDaoPdba().getSession());

		q.append("from PrUpAndonIndicadores otbl  ");
		q.append("WHERE (otbl.id.idup = :idup) ");
		q.append("ORDER BY otbl.id.idindicador ");

		q.defineParametro("idup", idUp);
		List<PrUpAndonIndicadores> listOtbl = null;
		try {
			listOtbl = q.list();
			if (listOtbl == null) {
				return resposta;
			}
			resposta.setListaIwsAndonIndicador(listOtbl);
		} catch (Exception e) {
			return resposta;
		}
		return resposta;
	}

	public void removeInspecoesInvalidas(String idUp) {

		String sql = "";

		sql += "delete from Pr_Up_Execinspecao where idup = '::idup' ";

		sql = sql.replaceAll("::idup", idUp);

		Query q = this.getDaoPdba().getSession().createSQLQuery(sql);

		try {
			q.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.getDaoPdba().flushReiniciandoTransacao();

		sql = "";

		sql += "delete from Pr_Up_Ctrl_Execinspecao where idup = '::idup' ";

		sql = sql.replaceAll("::idup", idUp);

		q = this.getDaoPdba().getSession().createSQLQuery(sql);

		try {
			q.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Boolean consultaAlertaInspecao(PrUp prup) {
		List<PrUpAndonAlertaInspecao> listaAndonInsp = new ArrayList<PrUpAndonAlertaInspecao>();

		String hql = "";

		hql += "select prupandonalertainspecao ";
		hql += "from PrUpAndonAlertaInspecao prupandonalertainspecao ";
		hql += "where prupandonalertainspecao.id.idup = '::idup' ";
		// hql += "and prupandonalertainspecao.nrop = '::nrop'";

		hql = hql.replaceAll("::idup", prup.getIdup().toString());
		// hql = hql.replaceAll("::nrop", prup.getNrop());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		try {
			listaAndonInsp = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			listaAndonInsp = null;
		}

		if (listaAndonInsp != null && listaAndonInsp.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setTr_alteraStatusApntSap(IdwLogger log, int idLog, String idUp, Date dthr,
			String stApntSap) { // vlauria 20100506

		double msDthrEvento = (double) DataHoraRN.getApenasMilisegundos(dthr);
		PrUp prup = pesquisaPrup(log, idLog, idUp);

		PrColetorEventos evento = new PrColetorEventos();
		evento.setTpevento(new BigDecimal(43));
		evento.setDthr1evento(dthr);
		evento.setMsdthr1evento(msDthrEvento);
		evento.setDthr2evento(dthr);
		evento.setMsdthr2evento(msDthrEvento);
		evento.setNrop(prup.getNrop());
		evento.setCdmolde(prup.getCdmolde());
		evento.setCdestrutura(prup.getCdestrutura());
		evento.setDthriniplanejada(prup.getDthriniplanejada());
		evento.setInf01(stApntSap);
		evento.setPrUp(prup);
		lancarEventoEsperaPrColetorEventos(log, idLog, evento, false);
	}

	public String setTr_adicionaCartoesKanban(
			IdwLogger log, int idLog,
			String idUp, Date dtHrEvento,
			String quantidade) {
		String resposta = null;
		PrEventosBridgeCollecDb eventoResposta;
		PrUp prup = pesquisaPrup(log, idLog, idUp);

		long milisegundos = dtHrEvento.getTime() % 1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(44));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dtHrEvento);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(dtHrEvento);
		prcoletoreventos.setMsdthr2evento(DataHoraRN
				.getApenasMilisegundos(dtHrEvento));
		prcoletoreventos.setInf01("A");
		prcoletoreventos.setInf02(quantidade);

		try {
			eventoResposta = new PrEventosBridgeCollecDb();
			eventoResposta = lancarEventoEsperaPrEventosBridgeCollecDb(
					log, idLog,
					prcoletoreventos, true);
		} catch (MestreOfflineException e) {			
			return "Detectou que BC esta offline";
		}

		if (eventoResposta.getTpevento().equals(new BigDecimal(46))
				&& eventoResposta.getInf01().equals("1")) {
			resposta = "OK";
			// resposta.concat("OK");
		} else {
			if (eventoResposta.getTxtmensagem() != null)
				resposta = eventoResposta.getTxtmensagem();
			else {
				resposta = "TXT MENSAGEM IGUAL NULO";
				// resposta.concat("TXT MENSAGEM IGUAL NULO");
			}
		}

		return resposta;
	}

	public String setTr_removeCartoesKanban(
			IdwLogger log, int idLog,
			String idUp, Date dtHrEvento,
			String quantidade) {
		String resposta = null;
		PrEventosBridgeCollecDb eventoResposta;
		PrUp prup = pesquisaPrup(log, idLog, idUp);

		long milisegundos = dtHrEvento.getTime() % 1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(44));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dtHrEvento);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(dtHrEvento);
		prcoletoreventos.setMsdthr2evento(DataHoraRN
				.getApenasMilisegundos(dtHrEvento));
		prcoletoreventos.setInf01("S");
		prcoletoreventos.setInf02(quantidade);

		try {
			eventoResposta = new PrEventosBridgeCollecDb();
			eventoResposta = lancarEventoEsperaPrEventosBridgeCollecDb(
					log, idLog,
					prcoletoreventos, true);
		} catch (MestreOfflineException e) {
			e.printStackTrace();
			return "Detectou que BC esta offline";
		}

		if (eventoResposta.getTpevento().equals(new BigDecimal(46))
				&& eventoResposta.getInf01().equals("1")) {
			resposta = "OK";
			// resposta.concat("OK");
		} else {
			if (eventoResposta.getTxtmensagem() != null)
				resposta = eventoResposta.getTxtmensagem();
			else {
				resposta = "TXT MENSAGEM IGUAL NULO";
				// resposta.concat("TXT MENSAGEM IGUAL NULO");
			}
		}

		return resposta;
	}

	private Integer buscaResulUltimaInsp(PrUp prup) {
		PrUpAndonResultUltimaInsp lcAndonResulInsp = new PrUpAndonResultUltimaInsp();
		Integer resultado = 0;
		String hql = "";

		hql += "select prupandonresultultimainspecao ";
		hql += "from PrUpAndonResultUltimaInsp prupandonresultultimainspecao ";
		hql += "where prupandonresultultimainspecao.idup = '::idup' ";

		hql = hql.replaceAll("::idup", prup.getIdup().toString());

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		try {
			lcAndonResulInsp = (PrUpAndonResultUltimaInsp) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			lcAndonResulInsp = null;
		}

		if (lcAndonResulInsp != null) {
			if (lcAndonResulInsp.getUltimoresultado() == '1')
				resultado = 1;
			if (lcAndonResulInsp.getUltimoresultado() == '2')
				resultado = 2;
			if (lcAndonResulInsp.getUltimoresultado() == '3')
				resultado = 3;
		} else
			resultado = 0;

		return resultado;

	}

	private Date getBeatForIdup(String idUp) {
		String sql = "";
		Date dthrbeat = null;

		sql += "select c.dthrultacessobd from  Pr_Up a, Pr_Sub_Coletor b, Pr_Coletor c ";
		sql += "where a.idup = '::idup' ";
		sql += "and c.idregcoletor = b.idregcoletor ";
		sql += "and b.idregsubcoletor = a.idregsubcoletor ";

		sql = sql.replaceAll("::idup", idUp);

		Query q = this.getDaoPdba().getSession().createSQLQuery(sql);

		try {
			dthrbeat = (Date) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dthrbeat;
	}

	private List<PrUpAndon> obtem_ListaAndon(PrUp prup) {
		List<PrUpAndon> listaAndon = new ArrayList<PrUpAndon>();
		MapQuery q = new MapQuery(getDaoPdba().getSession());

		try {
			q.novaConsulta();
			q.append("select oandon ");
			q.append("from PrUpAndon oandon ");
			q.append("where oandon.id.idup = :idup ");
			q.append("and oandon.stativo='1' ");
			q.defineParametro("idup", prup.getIdup().toString());
			listaAndon = q.list();			
		} catch (Exception e) {
			e.printStackTrace();
			listaAndon = null;
		}
		return listaAndon;
	}

	private boolean VerificaSeIgnoraAndon(PrUp prup, PrUpAndon prupandon) {
		boolean ignoraEvento=true;
		// Ignorando caso n�o possua v�nculo v�lido para tratar o evento
		if (prupandon.getTpeventoandon().intValue()==IwsAndonDTO.EV_LIMITE_CIP_EXTRAPOLADO) {
			boolean molodIN = false, moldOUT = false;
			if(prup.obtemDadosCIPDTO()!=null && prup.obtemDadosCIPDTO().getIsEmCIP()){
				for (PrUpAndonArg arg : prupandon.getPrUpAndonArgs()) {
					if (arg == null || arg.getTpvlreferencia() == null
							|| arg.getVlreferenciastr() == null)
						continue;
					if ((arg.getTpvlreferencia().intValue()==IwsAndonDTO.VL_REF_MOLDE_QUE_SAI)
							&& arg.getVlreferenciastr().equals(
									prup.obtemDadosCIPDTO().getCdmoldeantigo())) {
						molodIN = true;
					}
					if ((arg.getTpvlreferencia().intValue()==IwsAndonDTO.VL_REF_MOLDE_QUE_ENTRA)
							&& arg.getVlreferenciastr().equals(prup.getCdmolde())) {
						moldOUT = true;
					}
				}
			}
			if(molodIN&&moldOUT)
				ignoraEvento=false;		
		}else{
			ignoraEvento=false;
		}
		return ignoraEvento;
	}

	private List<IwsAndonDTO> getTr_ListaDadosAndon(IdwLogger log, int idLog, PrUp prup) { // senoj
		
		if (!verificaStatusAndonConfig(prup))
			return null;
		
		List<IwsAndonDTO> listaAndonDTO = new ArrayList<IwsAndonDTO>();
		IwsAndonDTO andonDTO = null;
		
		List<PrUpAndon> listaAndon = obtem_ListaAndon(prup);
		
		IwsAndonIndicadoresDTO listaVlIndicador = consultaIndicadoresAndon(prup.getIdup().toString());
		
		BigDecimal tempoEventoAndonInsp = consultaTempoEventoAndonInsp(prup);
		
		boolean deveadicionar;
		
		if (listaAndon != null && listaAndon.size() > 0) {
			
			for (PrUpAndon andon : listaAndon) {
				
				if (VerificaSeIgnoraAndon(prup, andon)) {
					continue;
				}
				
				andonDTO = new IwsAndonDTO();				
				andonDTO.copyPrUpAndon(andon);
				deveadicionar=true;
				/*
				 * APENAS O EVENTO 3 (INSPE��O PENDENTE) TEM O TEMPO LIMITE
				 * CONFIGURADO FORA DE ARGUMENTOS
				 */
				if (andonDTO.getTpeventoandon().intValue() == IwsAndonDTO.EV_INSPECAO_PENDENTE)
				{
					andonDTO.setTmpliminspqld(tempoEventoAndonInsp);
					
				} else if ((andonDTO.getTpeventoandon().intValue() > IwsAndonDTO.EV_MAQUINA_TRABALHANDO)
						&& (andonDTO.getTpeventoandon().intValue() < IwsAndonDTO.EV_QLQR_PARADA)) {
					/*
					 * 
					 * OS EVENTOS 9, 10, 11 E 12 PRECISAM, TAMB�M, DE INDICADORES
					 * PARA COMPARA��O OS INDICADORES QUE ESTO SENDO USADOS SO
					 * PARA O PERIODO RELACIONADO ULTIMA HORA PORTANTO, PERIODO
					 * = 1
					 */
					andonDTO.setIndicador(listaVlIndicador.getIwsAndonIndicador(andonDTO.getTpeventoandon()));
					
				}else if ((andonDTO.getTpeventoandon().intValue() > IwsAndonDTO.EV_LIMITE_CIP_EXTRAPOLADO) &&
						  (andonDTO.getTpeventoandon().intValue() < IwsAndonDTO.EV_IS_OP_CONCLUIDA)) {
					
					Ijcfgdiariobrdqld objDiarioBrdQld=obtemIjcfgdiariobrdqld();
					
					if ((objDiarioBrdQld!=null) && (objDiarioBrdQld.getId()!=null) && 
						(objDiarioBrdQld.getId().getCfgdiariobrdqld().intValue() != 0)) {
						
						if (andonDTO.getTpeventoandon().intValue() == IwsAndonDTO.EV_APONTAMENTO_DBQ_EXTRAPOLADO){
							IwsAndonArgsDTO argDTO = new IwsAndonArgsDTO();														
							if(objDiarioBrdQld.getId().getCfgdiariobrdqld().intValue()==1){
								argDTO.setVlreferencianum(objDiarioBrdQld.getId().getTempolimaptdbqld().doubleValue());
							}else if(prup.getNrop()!=null && prup.getNrop().length()>0){
								argDTO.setVlreferencianum(obtemijprotempolimdbqldPorProd(log, idLog, prup)); 
							}
							
							if (argDTO.getVlreferencianum()==null || argDTO.getVlreferencianum().equals(0d)) {
								
								if (prup.getNrop()!=null && prup.getNrop().length() > 0)
									log.info("Evento de Andon desprezado por falta de referencia tp:17 idup:"+prup.getIdup().toString());
								
								deveadicionar=false;
								
							} else {
								argDTO.setIdup(andonDTO.getIdup());
								argDTO.setOperadorcalculo(">=");
								argDTO.setOrdemcondicao(new BigDecimal(1));
								argDTO.setTpvlreferencia(new BigDecimal(3));
								argDTO.setIdeventoandon(andonDTO.getIdeventoandon());
								List<IwsAndonArgsDTO> listArg = new ArrayList<IwsAndonArgsDTO>();
								listArg.add(argDTO);
								andonDTO.setListaAndonArgsDTO(listArg);
							}
						}
						
					}else{
						log.info("Evento de Andon desprezado erro consulta tp:17 idup:"+prup.getIdup().toString());
						deveadicionar=false;
					}
				}else if(andonDTO.getTpeventoandon().intValue() == IwsAndonDTO.EV_IS_OP_CONCLUIDA){
					if((prup.getNrop()!=null)&& (prup.getStativa()=='1'))
						prup.mudaIsOPConcluida(isOpConcluida(log, idLog, prup.getCdmaquina()));
				}
				if(deveadicionar)
					listaAndonDTO.add(andonDTO);
			}

			return listaAndonDTO;
		}

		return null;
	}

	public Ijcfgdiariobrdqld obtemIjcfgdiariobrdqld(){
		MapQuery q = new MapQuery(getDaoInjet().getSession());
		try {
			// Verifica se o valor em Ijcfgdiariobrdqld � valido para toda a Planta	
			q.append("from Ijcfgdiariobrdqld otbl ");
			q.setMaxResults(1);
			Ijcfgdiariobrdqld oDrbqld = null;
			oDrbqld= (Ijcfgdiariobrdqld) q.uniqueResult();
			return oDrbqld;
		}catch(Exception e){
			e.printStackTrace();		
			return null;
		}
	}


	public Double obtemijprotempolimdbqldPorProd(IdwLogger log, int idLog, PrUp prup)  {
		Double retorno =null;
		MapQuery q = new MapQuery(getDaoInjet().getSession());

		try {					
				List<Object> listaprod = new ArrayList<Object>();
				for(PrUpProduto listPrupprod :prup.getPrUpProdutos()){
					listaprod.add(listPrupprod.getCdproduto());
				}
				if(listaprod.size()==0){					
					log.info("Idup:"+prup.getIdup().toString()+" -N�o pode obter tempolimdbqld por n?o estar com lista de produtos");
				}else{				
					// Caso ijCfgDiarioBrdQld.CfgDiarioBrdQld = 2;
					// Obtem os tempo por produto
					// obtem o menor tempo dentre os produtos da atuais da UP e usa esse tempo 
					q.novaConsulta();
					q.append("select otbl ");
					q.append("from Ijprotempolimdbqld  otbl ");
					q.append("where otbl.ijtbpro.cdproduto in (:listcdprod) ");
					q.append("order by otbl.tempolimaptdbqld ");
					q.defineListaParametro("listcdprod", listaprod);
					q.setMaxResults(1);
					Ijprotempolimdbqld obj = null;
					obj=(Ijprotempolimdbqld)q.uniqueResult();
					if(obj!=null)
						retorno = obj.getTempolimaptdbqld().doubleValue();
				}
			
			listaprod = new ArrayList<Object>();
			for(PrUpProduto listPrupprod :prup.getPrUpProdutos()){
				listaprod.add(listPrupprod.getCdproduto());
			}
			if(listaprod.size()==0){					
				log.info("Idup:"+prup.getIdup().toString()+" -N?o pode obter tempolimdbqld por n?o estar com lista de produtos");
			}else{				
				// Caso ijCfgDiarioBrdQld.CfgDiarioBrdQld = 2;
				// Obtem os tempo por produto
				// obtem o menor tempo dentre os produtos da atuais da UP e usa esse tempo 
				q.novaConsulta();
				q.append("select otbl ");
				q.append("from Ijprotempolimdbqld  otbl ");
				q.append("where otbl.ijtbpro.cdproduto in (:listcdprod) ");
				q.append("order by otbl.tempolimaptdbqld ");
				q.defineListaParametro("listcdprod", listaprod);
				q.setMaxResults(1);
				Ijprotempolimdbqld obj = null;
				obj=(Ijprotempolimdbqld)q.uniqueResult();
				if(obj!=null)
					retorno = obj.getTempolimaptdbqld().doubleValue();
			}

		} catch (Exception e) {
			e.printStackTrace();			
		}
		return retorno;
	}

	public void setTr_registroIntegracaoDoal(IdwLogger log, int idLog, String idUp, Date dtHr,
			String text, boolean salvaAlimIntegDoal) {
		PrUp prup = pesquisaPrup(log, idLog, idUp);

		long milisegundos = dtHr.getTime() % 1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(96));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dtHr);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(dtHr);
		prcoletoreventos.setMsdthr2evento(DataHoraRN
				.getApenasMilisegundos(dtHr));
		prcoletoreventos.setStevento("3");

		int tamanhoTxt = text.length();
		int numeroLinhas = tamanhoTxt / 40;

		if (tamanhoTxt % 40 > 0)
			numeroLinhas++;

		if (numeroLinhas >= 1) {
			if (tamanhoTxt >= 40) {
				prcoletoreventos.setInf01(text.substring(0, 40));
			} else {
				prcoletoreventos.setInf01(text.substring(0, tamanhoTxt));
			}
		}
		if (numeroLinhas >= 2) {
			if (tamanhoTxt >= 80) {
				prcoletoreventos.setInf02(text.substring(40, 80));
			} else {
				prcoletoreventos.setInf02(text.substring(40, tamanhoTxt));
			}
		}
		if (numeroLinhas >= 3) {
			if (tamanhoTxt >= 120) {
				prcoletoreventos.setInf03(text.substring(80, 120));
			} else {
				prcoletoreventos.setInf03(text.substring(80, tamanhoTxt));
			}
		}
		if (numeroLinhas >= 4) {
			if (tamanhoTxt >= 160) {
				prcoletoreventos.setInf04(text.substring(120, 160));
			} else {
				prcoletoreventos.setInf04(text.substring(120, tamanhoTxt));
			}
		}

		try {
			lancarEventoEsperaPrEventosBridgeCollecDb(log, idLog, prcoletoreventos, false);
		} catch (MestreOfflineException e) {
			e.printStackTrace();
		}

		if (salvaAlimIntegDoal) {
			prup.setStalimintegdoal('1');
			this.getDaoPdba().getSession().merge(prup);
		}
	}

	public List<IwsProdMateriaPrimaDTO> getTr_dadosIntegracaoDoal(IdwLogger log, int idLog, String idUp) {
		List<PrUpProdutoMatPrima> listMatPrima = new ArrayList<PrUpProdutoMatPrima>();
		List<IwsProdMateriaPrimaDTO> matPrimaDto = null;


		String hql = "";

		hql += "select prupmateriaprima from PrUpProdutoMatPrima prupmateriaprima ";
		hql += "where prupmateriaprima.prUp.idup = '::idup' ";

		hql = hql.replaceAll("::idup", idUp);

		try {
			Query q = this.getDaoPdba().getSession().createQuery(hql);
			listMatPrima = q.list();
		} catch (Exception e) {
			listMatPrima = null;
			e.printStackTrace();
		}

		PrUp prup = pesquisaPrup(log, idLog, idUp);
		
		if (listMatPrima != null && listMatPrima.size() > 0) {
			for (PrUpProdutoMatPrima matprima : listMatPrima) {
				PrUpProdutoValidacao produto = new PrUpProdutoValidacao();
				IwsProdMateriaPrimaDTO primaDto = new IwsProdMateriaPrimaDTO();
				primaDto.copyPrUpProdMatPrima(matprima);

				hql = "";
				hql += " select prupprodutoval ";
				hql += "from PrUpProdutoValidacao prupprodutoval ";
				hql += "where prupprodutoval.prUp.idup = '::idup' ";
				hql += "and prupprodutoval.cdproduto = '::cdproduto' ";

				hql = hql.replaceAll("::idup", idUp);
				hql = hql.replaceAll("::cdproduto", primaDto.getCdProduto());

				try {
					Query q = this.getDaoPdba().getSession().createQuery(hql);
					produto = (PrUpProdutoValidacao) q.uniqueResult();
				} catch (Exception e) {
					produto = null;
					e.printStackTrace();
				}

				if (produto != null) {
					if (matPrimaDto == null)
						matPrimaDto = new ArrayList<IwsProdMateriaPrimaDTO>();
					primaDto.setDsProduto(produto.getDsproduto());
					matPrimaDto.add(primaDto);
					prup.setStvertelaintegdoal('1');
				}
			}
		} else {
			prup.setStvertelaintegdoal('0');
			prup.setStalimintegdoal('1');
		}
		this.getDaoPdba().getSession().merge(prup);
		this.getDaoPdba().flushReiniciandoTransacao();
		return matPrimaDto;
	}

	public IwsProdMateriaPrimaDTO setTr_lancaApntMateriaPrima(IdwLogger log, int idLog, String idUp,
			Date dtHr, String cdproduto, String cdmateriaprima, String estoque,
			String lote, Double quantidade, int stRegistro, IwsCpDTO cpdto) {
		String dsmateriaprima = "";
		String unidade = "";
		boolean controlalote = false;
		IwsProdMateriaPrimaDTO ultimaMatPrima = new IwsProdMateriaPrimaDTO();
		PrUp prup = pesquisaPrup(log, idLog, idUp);

		if (stRegistro == 3) {
			estoque = "N/I";
			lote = "SEM LOTE";
		}

		long milisegundos = dtHr.getTime() % 1000;

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(45));
		prcoletoreventos.setNrop(cpdto.getNrop());
		prcoletoreventos.setCdmolde(cpdto.getCdmolde());
		prcoletoreventos.setCdestrutura(cpdto.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(cpdto.getDthrIPlanejamento());
		prcoletoreventos.setDthr1evento(dtHr);
		prcoletoreventos.setMsdthr1evento((double) milisegundos);
		prcoletoreventos.setDthr2evento(dtHr);
		prcoletoreventos.setMsdthr2evento(DataHoraRN
				.getApenasMilisegundos(dtHr));
		prcoletoreventos.setStevento("0");
		prcoletoreventos.setInf01(cdproduto);
		prcoletoreventos.setInf02(cdmateriaprima);
		prcoletoreventos.setInf03(estoque);
		prcoletoreventos.setInf04(lote);
		prcoletoreventos.setInf05(String.valueOf(quantidade));
		prcoletoreventos.setInf06(String.valueOf(stRegistro));

		try {
			lancarEventoEsperaPrEventosBridgeCollecDb(log, idLog, prcoletoreventos, false);
		} catch (MestreOfflineException e) {
			e.printStackTrace();
			ultimaMatPrima.setCdMateriaPrima(null);
			return ultimaMatPrima;
		}

		this.getDaoPdba().flushReiniciandoTransacao();
		String sql = "";

		List<IwsProdMateriaPrimaDTO> lcPrima = getTr_dadosIntegracaoDoal(log, idLog, idUp);
		for (IwsProdMateriaPrimaDTO lcmp : lcPrima) {
			if (lcmp.getCdMateriaPrima().equals(cdmateriaprima)
					&& lcmp.getCdProduto().equals(cdproduto)) {
				dsmateriaprima = lcmp.getDsMateriaPrima();
				unidade = lcmp.getUnidade();
				controlalote = lcmp.getControlalote();
				sql = "update Pr_Up_Produto_Mat_Prima ";
				sql += "set nrLote = '::nrLote' ,cdEstoque='::cdEstoque' ";
				sql += "where idup = '::idup'  and cdMateriaPrima='::cdMateria' ";
				sql += "and cdProduto='::cdProd'";

				sql = sql.replaceAll("::nrLote", lote);
				sql = sql.replaceAll("::cdEstoque", estoque);
				sql = sql.replaceAll("::idup", lcmp.getIdUp());
				sql = sql.replaceAll("::cdMateria", cdmateriaprima);
				sql = sql.replaceAll("::cdProd", cdproduto);

				try {
					Query q = this.getDaoPdba().getSession()
							.createSQLQuery(sql);
					q.executeUpdate();
					this.getDaoPdba().flushReiniciandoTransacao();

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}

		PrUpProdutoMatPrimaUsada pojoUltMatPrima = new PrUpProdutoMatPrimaUsada();

		String hql = "";

		hql += "select prupmateriaprima from PrUpProdutoMatPrimaUsada prupmateriaprima ";
		hql += "where prupmateriaprima.idup = '::idup' ";

		hql = hql.replaceAll("::idup", idUp);

		try {
			Query q = this.getDaoPdba().getSession().createQuery(hql);

			pojoUltMatPrima = (PrUpProdutoMatPrimaUsada) q.uniqueResult();
		} catch (Exception e) {
			pojoUltMatPrima = null;
			e.printStackTrace();
		}

		if (pojoUltMatPrima == null) {
			sql += "insert into PR_UP_PRODUTO_MAT_PRIMA_USADA ( ";
			sql += "IDUP, cdproduto, cdmateriaprima, dsmateriaprima, unidade, cdestoque, nrlote, qtd, stregistro)";
			sql += "values ( ";
			sql += " '::idup', '::cdproduto', '::cdmateriaprima', '::dsmateriaprima', '::unidade', '::cdestoque', '::nrlote', ::qtd, ::stregistro) ";

			sql = sql.replaceAll("::idup", prup.getIdup().toString());
			sql = sql.replaceAll("::cdproduto", cdproduto);
			sql = sql.replaceAll("::cdmateriaprima", cdmateriaprima);
			sql = sql.replaceAll("::dsmateriaprima", dsmateriaprima);
			sql = sql.replaceAll("::unidade", unidade);
			sql = sql.replaceAll("::cdestoque", estoque);
			sql = sql.replaceAll("::nrlote", lote);
			sql = sql.replaceAll("::qtd", String.valueOf(quantidade));
			sql = sql.replaceAll("::stregistro", String.valueOf(stRegistro));

			try {
				Query q = this.getDaoPdba().getSession().createSQLQuery(sql);
				q.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}

			pojoUltMatPrima = new PrUpProdutoMatPrimaUsada();
			pojoUltMatPrima.setCdmateriaprima(cdmateriaprima);
			pojoUltMatPrima.setDsmateriaprima(dsmateriaprima);
			pojoUltMatPrima.setCdproduto(cdproduto);
			pojoUltMatPrima.setIdup(idUp);
			pojoUltMatPrima.setUnidade(unidade);
			pojoUltMatPrima.setNrlote(lote);
			pojoUltMatPrima.setCdestoque(estoque);
			if (stRegistro == 1)
				pojoUltMatPrima.setStregistro('1');
			else if (stRegistro == 2)
				pojoUltMatPrima.setStregistro('2');
			else if (stRegistro == 3)
				pojoUltMatPrima.setStregistro('3');
			else
				pojoUltMatPrima.setStregistro('0');
			pojoUltMatPrima.setQtd(quantidade);

		} else {
			pojoUltMatPrima.setCdmateriaprima(cdmateriaprima);
			pojoUltMatPrima.setDsmateriaprima(dsmateriaprima);
			pojoUltMatPrima.setCdproduto(cdproduto);
			pojoUltMatPrima.setIdup(idUp);
			pojoUltMatPrima.setUnidade(unidade);
			pojoUltMatPrima.setNrlote(lote);
			pojoUltMatPrima.setCdestoque(estoque);

			switch (stRegistro) {
			case 1:
				pojoUltMatPrima.setStregistro('1');
				break;
			case 2:
				pojoUltMatPrima.setStregistro('2');
				break;
			case 3:
				pojoUltMatPrima.setStregistro('3');
				break;
			default:
				pojoUltMatPrima.setStregistro('0');
			}

			pojoUltMatPrima.setQtd(quantidade);

			this.getDaoPdba().getSession().merge(pojoUltMatPrima);
		}

		ultimaMatPrima.copyProdUltimaMatPrima(pojoUltMatPrima);
		ultimaMatPrima.setControlalote(controlalote);

		this.getDaoPdba().flushReiniciandoTransacao();

		PrUpProduto produto = new PrUpProduto();

		hql = "";
		hql += " select prupproduto ";
		hql += "from PrUpProduto prupproduto ";
		hql += "where prupproduto.prUp.idup = '::idup' ";
		hql += "and prupproduto.cdproduto = '::cdproduto' ";

		hql = hql.replaceAll("::idup", idUp);
		hql = hql.replaceAll("::cdproduto", ultimaMatPrima.getCdProduto());

		try {
			Query q = this.getDaoPdba().getSession().createQuery(hql);
			produto = (PrUpProduto) q.uniqueResult();
		} catch (Exception e) {
			produto = null;
			e.printStackTrace();
		}

		if (produto != null) {
			ultimaMatPrima.setDsProduto(produto.getDsproduto());
		} else { // TODO senoj: PAra mim isto � Uma POG verificar se tem uma fun??o real
			PrUpProdutoValidacao produto2 = new PrUpProdutoValidacao();

			hql = "";
			hql += " select prupprodutovalidacao ";
			hql += "from PrUpProdutoValidacao prupprodutovalidacao ";
			hql += "where prupprodutovalidacao.prUp.idup = '::idup' ";
			hql += "and prupprodutovalidacao.cdproduto = '::cdproduto' ";

			hql = hql.replaceAll("::idup", idUp);
			hql = hql.replaceAll("::cdproduto", ultimaMatPrima.getCdProduto());

			try {
				Query q = this.getDaoPdba().getSession().createQuery(hql);
				produto2 = (PrUpProdutoValidacao) q.uniqueResult();
			} catch (Exception e) {
				produto = null;
				e.printStackTrace();
			}
			if (produto2 != null) {
				ultimaMatPrima.setDsProduto(produto2.getDsproduto());
			} else {
				ultimaMatPrima.setDsProduto(null);
			}
		}

		this.getDaoPdba().flushReiniciandoTransacao();

		return ultimaMatPrima;
	}

	public IwsProdMateriaPrimaDTO getTr_ultimaMateriaPrima(String idUp) {
		IwsProdMateriaPrimaDTO ultimaMatPrima = new IwsProdMateriaPrimaDTO();
		PrUpProdutoMatPrimaUsada pojoUltMatPrima = new PrUpProdutoMatPrimaUsada();

		String hql = "";

		hql += "select prupmateriaprima from PrUpProdutoMatPrimaUsada prupmateriaprima ";
		hql += "where prupmateriaprima.idup = '::idup' ";

		hql = hql.replaceAll("::idup", idUp);

		try {
			Query q = this.getDaoPdba().getSession().createQuery(hql);

			pojoUltMatPrima = (PrUpProdutoMatPrimaUsada) q.uniqueResult();
		} catch (Exception e) {
			pojoUltMatPrima = null;
			e.printStackTrace();
		}

		if (pojoUltMatPrima != null) {
			PrUpProduto produto = new PrUpProduto();
			ultimaMatPrima.copyProdUltimaMatPrima(pojoUltMatPrima);

			hql = "";
			hql += " select prupproduto ";
			hql += "from PrUpProduto prupproduto ";
			hql += "where prupproduto.prUp.idup = '::idup' ";
			hql += "and prupproduto.cdproduto = '::cdproduto' ";

			hql = hql.replaceAll("::idup", idUp);
			hql = hql.replaceAll("::cdproduto", ultimaMatPrima.getCdProduto());

			try {
				Query q = this.getDaoPdba().getSession().createQuery(hql);
				produto = (PrUpProduto) q.uniqueResult();
			} catch (Exception e) {
				produto = null;
				e.printStackTrace();
			}

			if (produto != null) {
				ultimaMatPrima.setDsProduto(produto.getDsproduto());
			} else {
				ultimaMatPrima.setDsProduto(null);
			}

			PrUpProdutoMatPrima pojoMatPrima = new PrUpProdutoMatPrima();

			hql = "";

			hql += "select prupmateriaprima from PrUpProdutoMatPrima prupmateriaprima ";
			hql += "where prupmateriaprima.prUp.idup = '::idup' ";
			hql += "and prupmateriaprima.cdproduto = '::cdproduto' ";
			hql += "and prupmateriaprima.cdmateriaprima = '::cdmateriaprima' ";

			hql = hql.replaceAll("::idup", idUp);
			hql = hql.replaceAll("::cdproduto", ultimaMatPrima.getCdProduto());
			hql = hql.replaceAll("::cdmateriaprima",
					ultimaMatPrima.getCdMateriaPrima());

			try {
				Query q = this.getDaoPdba().getSession().createQuery(hql);

				pojoMatPrima = (PrUpProdutoMatPrima) q.uniqueResult();
			} catch (Exception e) {
				pojoMatPrima = null;
				e.printStackTrace();
			}

			if (pojoMatPrima != null) {
				if (pojoMatPrima.getControlalote() == '1')
					ultimaMatPrima.setControlalote(true);
				else
					ultimaMatPrima.setControlalote(false);
			} else
				ultimaMatPrima.setControlalote(false);
		} else {
			ultimaMatPrima = null;
		}

		return ultimaMatPrima;
	}

	private void setProdLiquida(String idup, Double qtd) {
		try {
			String sql = "update Pr_Up_Dados_BC ";
			sql += "set QtdProducaoLiquida = :qtdLiqd ";
			sql += "where idup = '::idup'";
			sql = sql.replaceAll("::idup", idup);

			Query q = this.getDaoPdba().getSession().createSQLQuery(sql);
			q.setDouble("qtdLiqd", qtd);
			q.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private IwsDadosBCDTO obtemDadosPrUpDadosBC(BigDecimal idup) {
		IwsDadosBCDTO retorno = new IwsDadosBCDTO();
		try {
			MapQuery q = new MapQuery(getDaoPdba().getSession());

			q.append("from PrUpDadosBc prupdadosbc ");
			q.append("where prupdadosbc.idUp = :idup");

			q.defineParametro("idup", idup);
			q.query().setMaxResults(1);

			PrUpDadosBc prupdadosbc = null;
			prupdadosbc = (PrUpDadosBc) q.query().uniqueResult();
			if (prupdadosbc != null)
				retorno.copyPrUpDadosBC(prupdadosbc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

	private void verificaStatusVariacaoRitmo(PrUp prup) {
		IwsVariacaoRitmoDTO oVar = new IwsVariacaoRitmoDTO();
		try {
			String hql = "";

			hql = "from PrUpVariacaoRitmoPend o " + "where o.idUp = '::idup' "
					+ "order by o.idRegVariacaoRitmoPend";

			hql = hql.replaceAll("::idup", prup.getIdup().toString());

			Query q = this.getDaoPdba().getSession().createQuery(hql);

			q.setMaxResults(1);
			try {
				PrUpVariacaoRitmoPend oPrUpVariacaoRitmoPend = (PrUpVariacaoRitmoPend) q
						.uniqueResult();
				if (prup.getNrop() == null || prup.getNrop().equals("")
						|| prup.getNrop().equals(" ")) {
					String sql = "delete from Pr_Up_Variacao_Ritmo_Pend where idup = '::idup' ";
					sql = sql.replaceAll("::idup", prup.getIdup().toString());

					Query q2 = this.getDaoPdba().getSession()
							.createSQLQuery(sql);
					try {
						q2.executeUpdate();
					} catch (Exception e) {
					}
				} else {
					oVar.copyVariacaoPend(oPrUpVariacaoRitmoPend);
				}
			} catch (Exception e) {
				// n�o faz nada registro n�o encontrado logo n�o h� varia��o
				// pendente.
			}
			if (!oVar.getIsComVariacaoRitmoPend()) {

				hql = "from PrUpUltimaVariacaoRitmo o "
						+ "where o.idUp = '::idup' ";

				hql = hql.replaceAll("::idup", prup.getIdup().toString());

				q = this.getDaoPdba().getSession().createQuery(hql);
				try {
					PrUpUltimaVariacaoRitmo oPrUpUltimaVariacaoRitmo = (PrUpUltimaVariacaoRitmo) q
							.uniqueResult();
					oVar.copyUltimaVariacaoRitmoInformada(oPrUpUltimaVariacaoRitmo);
				} catch (Exception e) {
					// n�o faz anda pois registro n�o foi encontrado
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: Verificar se � necess�rio alguma tratativa neste ponto
		}
		prup.mudaVariacaoRitmoDTO(oVar);
	}

	public IwsVariacaoRitmoValidaDTO validaMotivoVariacaoRitmo( String cdMotivo) {
		IwsVariacaoRitmoValidaDTO oVar = new IwsVariacaoRitmoValidaDTO();

		cdMotivo = UtilRN.getCodigoPadraoInjet(cdMotivo);
		MapQuery q = new MapQuery(getDaoInjet().getSession());

		q.append("from Ijtbvarritmo otbl ");
		q.append("where otbl.cdvarritmo = :cdvariacaoritmo ");
		q.append("and otbl.stativo = '1' ");
		q.defineParametro("cdvariacaoritmo", cdMotivo);	
		q.setMaxResults(1);
		try {
			Ijtbvarritmo ijtbvarritmo = (Ijtbvarritmo) q.uniqueResult();
			oVar.copyPrVariacaoRitmo(ijtbvarritmo);
		} catch (Exception e) {
			// n�o faz nada registro n�o encontrado logo n�o h� varia��o
			// pendente.
		}
		return oVar;
	}

	public void lancaEvento46(IdwLogger log, int idLog, IwsVariacaoRitmoDTO oVar, String idUp, Date dthrEvento) {
		PrUp prup = pesquisaPrup(log, idLog, idUp);
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setTpevento(new BigDecimal(46));
		prcoletoreventos.setDthr1evento(dthrEvento);
		prcoletoreventos.setMsdthr1evento(DataHoraRN
				.getApenasMilisegundos(dthrEvento));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setInf01(String.valueOf((int) oVar
				.getIdVariacaoRitmoInjet()));
		prcoletoreventos.setPrUp(prup);
		boolean temdados = false;
		if (oVar.getCdVarRitmo01() != null && oVar.getPerc01() > 0) {
			prcoletoreventos.setInf02(oVar.getCdVarRitmo01());
			prcoletoreventos.setInf03(String.valueOf(oVar.getPerc01()));
			temdados = true;
		}
		if (oVar.getCdVarRitmo02() != null && oVar.getPerc02() > 0) {
			prcoletoreventos.setInf04(oVar.getCdVarRitmo02());
			prcoletoreventos.setInf05(String.valueOf(oVar.getPerc02()));
		}
		if (oVar.getCdVarRitmo03() != null && oVar.getPerc03() > 0) {
			prcoletoreventos.setInf06(oVar.getCdVarRitmo03());
			prcoletoreventos.setInf07(String.valueOf(oVar.getPerc03()));
		}
		if (oVar.getCdVarRitmo04() != null && oVar.getPerc04() > 0) {
			prcoletoreventos.setInf08(oVar.getCdVarRitmo04());
			prcoletoreventos.setInf09(String.valueOf(oVar.getPerc04()));
		}
		if (oVar.getCdVarRitmo05() != null && oVar.getPerc05() > 0) {
			prcoletoreventos.setInf10(oVar.getCdVarRitmo05());
			prcoletoreventos.setInf11(String.valueOf(oVar.getPerc05()));
		}
		if (oVar.getCdVarRitmo06() != null && oVar.getPerc06() > 0) {
			prcoletoreventos.setInf12(oVar.getCdVarRitmo06());
			prcoletoreventos.setInf13(String.valueOf(oVar.getPerc06()));
		}
		if (oVar.getCdVarRitmo07() != null && oVar.getPerc07() > 0) {
			prcoletoreventos.setInf14(oVar.getCdVarRitmo07());
			prcoletoreventos.setInf15(String.valueOf(oVar.getPerc07()));
		}
		if (oVar.getCdVarRitmo08() != null && oVar.getPerc08() > 0) {
			prcoletoreventos.setInf16(oVar.getCdVarRitmo08());
			prcoletoreventos.setInf17(String.valueOf(oVar.getPerc08()));
		}
		if (temdados) {
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
			this.getDaoPdba().flushReiniciandoTransacao();
			PrUpUltimaVariacaoRitmo prupultimavariacaoritmo = null;
			Boolean existeReg = false;
			try {
				String sql = "delete Pr_Up_Variacao_Ritmo_Pend where IDVARIACAORITMOINJET = ::idVariacao ";

				sql = sql.replaceAll("::idVariacao",
						String.valueOf((int) oVar.getIdVariacaoRitmoInjet()));

				Query qe = this.getDaoPdba().getSession().createSQLQuery(sql);

				qe.executeUpdate();
			} catch (Exception e) {

			}
			try {
				String hql = "from PrUpUltimaVariacaoRitmo o where o.idUp = '::idup' ";

				hql = hql.replaceAll("::idup", prup.getIdup().toString());

				Query q = this.getDaoPdba().getSession().createQuery(hql);

				prupultimavariacaoritmo = (PrUpUltimaVariacaoRitmo) q
						.uniqueResult();
				if (prupultimavariacaoritmo != null) {
					existeReg = true;
				}
			} catch (Exception e) {
				// N�o faz nada apenas tenta excluir o dado caso exista.
			}
			if (!existeReg)
				prupultimavariacaoritmo = new PrUpUltimaVariacaoRitmo();
			oVar.getUltimaVariacaoRitmoInformada(prupultimavariacaoritmo);

			if (existeReg) {
				this.getDaoPdba().getSession().merge(prupultimavariacaoritmo);
			} else {
				prupultimavariacaoritmo.setIdUp(idUp);
				this.getDaoPdba().getSession().save(prupultimavariacaoritmo);
			}
			this.getDaoPdba().flushReiniciandoTransacao();
		} else {
			log.info("ERRO Ao Lan�ar Varia��o de ritmo");
		}
	}

	public IwsListaUpDTO getUpsIHM(String urlIHM, Date dthrBeat, boolean trataDthrBeat)
			throws SemSGBDException {

		String hql = "";

		hql += "select prup ";
		hql += "from PrUp prup ";
		hql += "where prup.idup in( ";
		hql += "select msup.iduppdba ";
		hql += "from MsUp msup ";
		hql += ",MsUpihm msupihm ";
		hql += ",MsIhm msihm ";
		hql += "where (( msihm.idIhm = msupihm.msIhm.idIhm and ";
		hql += " msupihm.msUp.idUp = msup.idUp) and ";
		hql += "(msihm.urlConexao = '::idcoletor' or msihm.urlConexaoalt = '::idcoletor'))";
		hql += ") and prup.stativa = '1' ";
		hql = hql.replaceAll("::idcoletor", urlIHM);

		List<PrUp> listaPrUp = null;

		Query q = this.getDaoPdba().getSession().createQuery(hql);

		try {
			listaPrUp = new ArrayList<PrUp>(q.list());
		} catch (Exception e) {
			e.printStackTrace();
			throw new SemSGBDException();
		}
		IwsListaUpDTO listaUpDTO = new IwsListaUpDTO();
		for (PrUp prup : listaPrUp) {		
			
			prup.mudaIsAlertaProbQuali(setTr_buscaAleraProbQuali(prup.getCdmaquina()));
			prup.mudaResultadoUltimaInspecao(buscaResulUltimaInsp(prup));

			boolean isInspPending = false;
			if (prup.getStativa() == '1' && prup.getNrop() != null) {
				try {
					isInspPending = consultaAlertaInspecao(prup);
				} catch (Exception e) {
					e.printStackTrace();
					isInspPending = false;
				}

				prup.mudaInspecaoPendente(isInspPending);
			}

			try {
				IdwLogger log = new IdwLogger(urlIHM);
				int idLog = log.getIdAleatorio();
				InjetAlertaRN aRn = new InjetAlertaRN(getDaoInjet());
				prup.mudaListaAlertasEmAberto(aRn.pesquisaAlertasEmAberto(log, idLog, prup.getCdmaquina()));
				prup.mudaListaAlertasDiarioDeBordo(aRn.pesquisaAlertasAptDiariodeBordo(log, idLog, prup.getCdmaquina()));
				aRn = null;
			} catch (SemSGBDException e1) {
				e1.printStackTrace();
			}

			ModRN modrn = new ModRN(getDaoInjet(), getDaoPdba());
			List<IwsModDTO> listaLogins = null;
			if(trataDthrBeat == true){
				try {
					listaLogins = modrn.getTr_balanceamentoLogin(prup, dthrBeat,
							getStBcOnline(prup.getIdup().toString()));
				} catch (Exception e) {
					e.printStackTrace();
				}


				prup.mudaListaLoginsEmAberto(listaLogins);
			}
			IdwLogger log = new IdwLogger(urlIHM);
			int idLog = log.getIdAleatorio();
			VerificaIsEmRegulagem(log, idLog, prup);
			verificaStatusVariacaoRitmo(prup);
			prup.mudaIsInjOuLiner(isMaquinaINJouLINER(prup.getCdmaquina()).getSucesso());
			this.getDaoPdba().getSession().merge(prup);
			verificaIsComCIP(log, idLog, prup);
			List<IwsAndonDTO> listaAndonCorrente = new ArrayList<IwsAndonDTO>();
			try {
				if (getStatusPrUpAndon(prup.getIdup().toString(), false)) 
				{
					listaAndonCorrente = getTr_ListaDadosAndon(log, idLog, prup);
				}
			} catch (SemSGBDException e) {
				e.printStackTrace();
			}
			prup.mudaDadosBC(obtemDadosPrUpDadosBC(prup.getIdup()));
			listaUpDTO.setStAndonConfiguravel(verificaStatusAndonConfig(prup));
			listaUpDTO.setStAndonProcessoft(verificaStatusAndonPrcsft(prup));
			listaUpDTO.addFullPrUp(log, idLog, prup, listaAndonCorrente, getDaoInjet(), getDaoPdba());
		}

		return listaUpDTO;
	}

	public IwsErroDTO verificaOperadorLogado(String idUp, String login,
			Date DataHrAtual) {
		IwsErroDTO erroDTO = new IwsErroDTO();
		try {

			MapQuery mapQuery = new MapQuery(this.getDaoPdba().getSession());
			// Verifico se � possivel fazer a verificacao do login
			mapQuery.append("select prconexoesinjet ");
			mapQuery.append(" from PrConexoesInjet prconexoesinjet, PrUp prup ");
			mapQuery.append(" where prconexoesinjet.idregconexaoinjet = prup.prConexoesInjet.idregconexaoinjet ");
			mapQuery.append(" and prup.idup = :idup");
			mapQuery.defineParametro("idup", new BigDecimal(idUp));
			mapQuery.query().setMaxResults(1);

			PrConexoesInjet prConexoesInjet = (PrConexoesInjet) mapQuery.query().uniqueResult();

			if (verificaModuloAtivo(idUp)) {

				mapQuery.novaConsulta();
				mapQuery.append("select pruploginsemaberto ");
				mapQuery.append("from PrUpLoginsEmAberto pruploginsemaberto ");
				mapQuery.append("where pruploginsemaberto.cdusuario=:cdusuario ");
				mapQuery.append(" and pruploginsemaberto.prUp.idup <> :idup ");

				mapQuery.defineParametro("cdusuario", login);
				mapQuery.defineParametro("idup", new BigDecimal(idUp));

				mapQuery.query().setMaxResults(1);
				PrUpLoginsEmAberto pruploginsemaberto = (PrUpLoginsEmAberto) mapQuery.query().uniqueResult();

				if (pruploginsemaberto == null) {

					// Nao tem nenhum cadastrado
					// busco a lista do PrProUsu
					mapQuery.novaConsulta();
					mapQuery.append("select prprousu ");

					mapQuery.append("from PrProUsu prprousu ");
					mapQuery.append("where prprousu.cdusuario = :cdUsuario and prprousu.prConexoesInjet.idregconexaoinjet=:idConexao ");

					mapQuery.defineParametro("cdUsuario", login);
					mapQuery.defineParametro("idConexao", prConexoesInjet.getIdregconexaoinjet());

					List<PrProUsu> lstPrProUsu = mapQuery.query().list();

					mapQuery.novaConsulta();
					mapQuery.append("select prupproduto ");
					mapQuery.append("from PrUpProduto prupproduto ");
					mapQuery.append("where prupproduto.prUp.idup=:idUp ");
					mapQuery.defineParametro("idUp", new BigDecimal(idUp));

					List<PrUpProduto> lstPrUpProdutos = mapQuery.query().list();

					if (validaOperadorTrabalho(lstPrUpProdutos, lstPrProUsu)) {
						erroDTO.setSucesso(true);
						erroDTO.setMensagem("");
					} else {
						erroDTO.setSucesso(false);
						erroDTO.setMensagem("Este operador nao   esta apto para o    trabalho");
					}
				} else {
					erroDTO.setSucesso(false);
					erroDTO.setMensagem("O operador: "
							+ pruploginsemaberto.getCdusuario()
							+ "  ja se encontra      logado na maquina:  "
							+ pruploginsemaberto.getPrUp().getCdmaqestendido());

				}

			} else {
				erroDTO.setSucesso(true);
				erroDTO.setMensagem("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			erroDTO.setSucesso(false);
			erroDTO.setMensagem("Ocorreu um erro ao  tentar logar o      usuario");
		}

		return erroDTO;
	}

	public boolean validaOperadorTrabalho(List<PrUpProduto> lstPrUpProduto,
			List<PrProUsu> lstPrProUsu) {
		boolean retorno = false;
		List<String> lstNome = new ArrayList<String>();
		// if ((lstPrUpProduto != null) &&(lstPrProUsu != null) ){
		if ((lstPrUpProduto.size() > 0) && (lstPrProUsu.size() > 0)) {

			for (PrUpProduto prupproduto : lstPrUpProduto) {
				boolean achou = false;
				for (PrProUsu prprousu : lstPrProUsu) {
					if (prupproduto.getCdproduto().equals(
							prprousu.getCdproduto())) {
						achou = true;
					}
				}
				if (!achou) {
					lstNome.add(prupproduto.getCdproduto());
				}
			}
			if (lstNome.size() > 0) {
				retorno = false;
			} else {
				retorno = true;
			}
		} else {
			retorno = false;
		}
		lstNome = null;
		return retorno;
	}

	public boolean verificaModuloAtivo(String idUp) {
		boolean retorno = false;
		MapQuery mapQuery = new MapQuery(this.getDaoPdba().getSession());
		// Verifico se � possivel fazer a verificacao do login
		mapQuery.append("select prconexoesinjet ");
		mapQuery.append(
				" from PrConexoesInjet prconexoesinjet, PrUp prup ");
		mapQuery.append(" where prconexoesinjet.idregconexaoinjet = prup.prConexoesInjet.idregconexaoinjet ");
		mapQuery.append(" and prup.idup = :idup");
		mapQuery.defineParametro("idup", new BigDecimal(idUp));
		mapQuery.setMaxResults(1);
		PrConexoesInjet prConexoesInjet = (PrConexoesInjet) mapQuery.uniqueResult();

		if (prConexoesInjet != null) {
			if (prConexoesInjet.getStProdutoUsuario() != null && prConexoesInjet.getStProdutoUsuario().equals(1)) {
				retorno = true;
			}
		}
		prConexoesInjet = null;
		mapQuery = null;
		return retorno;
	}
	private IwsErroDTO isMaquinaINJouLINER(String cdinjetora){
		IwsErroDTO errodto = new IwsErroDTO();
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());
		// Verifico se a Maquina � do tipo INJ ou LINER
		q.append("select ijtbinj ");
		q.append("from Ijtbinj ijtbinj");
		q.append("where ijtbinj.cdinjetora = :cdinjetora");
		q.append("and (ijtbinj.tpicone IN ('INJ', 'LINER'))");
		q.defineParametro("cdinjetora", cdinjetora);
		q.setMaxResults(1);
		Ijtbinj ijtbinj = (Ijtbinj) q.uniqueResult();

		if (ijtbinj != null) {
			errodto.setSucesso(true);
		}else{
			errodto.setMensagem("Operacao Nao Autorizada");
		}
		ijtbinj = null;
		q = null;
		return errodto;
	}

	public IwsErroDTO verificaSeJaEfetouPesagem(IdwLogger log, int idLog, String idUP){
		PrUp prup = pesquisaPrup(log, idLog, idUP);
		IwsErroDTO errodto = new IwsErroDTO();
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());		
		q.append("select otbl ");
		q.append("from Ijreaaptpesomedio otbl");
		q.append("where otbl.ijfictec.ijtbinj.cdinjetora = :cdinjetora");
		q.append("and otbl.ijop.nrop=:nrop");
		q.defineParametro("cdinjetora", prup.getCdmaquina());
		q.defineParametro("nrop", prup.getNrop());
		q.setMaxResults(1);
		Ijreaaptpesomedio otbl = (Ijreaaptpesomedio) q.uniqueResult();

		if (otbl != null) {
			errodto.setSucesso(true);
		}else{
			errodto.setMensagem("Operacao Nao Autorizada");
		}
		otbl = null;
		q = null;
		return errodto;

	}

	public IwsErroDTO lancaPesagemAmericaTampas(IdwLogger log, int idLog, String idUP, BigDecimal valor,Date dthr) {
		PrUp prup = pesquisaPrup(log, idLog, idUP);
		IwsErroDTO retorno =isMaquinaINJouLINER(prup.getCdmaquina());
		if(retorno.getSucesso()){
			PrColetorEventos prcoletoreventos = new PrColetorEventos();
			int milissegundos = DataHoraRN.getApenasMilisegundos(dthr);
			prcoletoreventos.setPrUp(prup);
			prcoletoreventos.setTpevento(new BigDecimal(47));
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setDthr1evento(dthr);
			prcoletoreventos.setMsdthr1evento((double) milissegundos);
			prcoletoreventos.setDthr2evento(dthr);
			prcoletoreventos.setMsdthr2evento((double) milissegundos);
			prcoletoreventos.setInf01(valor.toString());
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
		}
		return retorno;
	}

	public IwsErroDTO lancaPerdaResinaAmericaTampas(IdwLogger log, int idLog, String idUP, BigDecimal valor,Date dthr) {
		PrUp prup = pesquisaPrup(log, idLog, idUP);
		IwsErroDTO retorno =isMaquinaINJouLINER(prup.getCdmaquina());
		if(retorno.getSucesso()){
			PrColetorEventos prcoletoreventos = new PrColetorEventos();
			int milissegundos = DataHoraRN.getApenasMilisegundos(dthr);
			prcoletoreventos.setPrUp(prup);
			prcoletoreventos.setTpevento(new BigDecimal(48));
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setDthr1evento(dthr);
			prcoletoreventos.setMsdthr1evento((double) milissegundos);
			prcoletoreventos.setDthr2evento(dthr);
			prcoletoreventos.setMsdthr2evento((double) milissegundos);
			prcoletoreventos.setInf01(valor.toString());
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);
		}
		return retorno;
	}

	public Ijtbusu getIjtbusuDeOperadorLogado(String idUP){

		Ijtbusu retorno=null;
		ModRN modrn	=new ModRN(getDaoInjet(),getDaoPdba());
		InjetModRN injmodrn = new InjetModRN(getDaoInjet(),getDaoPdba());
		String cdusuario=null;
		try{			
			IwsListModDTO listaoperadores=modrn.getTr_operadoresLogados(idUP);
			cdusuario=listaoperadores.getListModDTO().get(0).getLogin();
		}catch(Exception exc){
			exc.printStackTrace();		
		}
		if(cdusuario!=null){
			try{
				retorno =injmodrn.getIjtbusu(cdusuario);
			}catch(Exception exc){
				exc.printStackTrace();			
			}
		}
		return retorno;
	}

	public IwsErroDTO mudancaCavidadesAtivasNomolde(IdwLogger log, int idLog, String idUP, int valor,Date dthr) {
		IwsErroDTO retorno;
		PrUp prup = pesquisaPrup(log, idLog, idUP);
		// tenta alterar o Molde
		InjetInfoRN iiRn = new InjetInfoRN(getDaoInjet(),getDaoPdba());
		Ijtbusu usuario = getIjtbusuDeOperadorLogado(idUP);
		if(usuario==null){
			retorno=new IwsErroDTO();
			retorno.setSucesso(false);
			retorno.setMensagem("ERRO AO OBTER OPERADOR LOGADO");
			return retorno;
		}
		retorno =iiRn.mudaCavidadesAtivasNomolde(prup,valor,dthr,usuario);
		// se valor valido Lan�a
		if(retorno.getSucesso()==true){
			PrColetorEventos prcoletoreventos = new PrColetorEventos();
			int milissegundos = DataHoraRN.getApenasMilisegundos(dthr);
			prcoletoreventos.setPrUp(prup);
			prcoletoreventos.setTpevento(new BigDecimal(93));
			prcoletoreventos.setStevento("3");
			prcoletoreventos.setNrop(prup.getNrop());
			prcoletoreventos.setCdmolde(prup.getCdmolde());
			prcoletoreventos.setCdestrutura(prup.getCdestrutura());
			prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
			prcoletoreventos.setDthr1evento(dthr);
			prcoletoreventos.setMsdthr1evento((double) milissegundos);
			prcoletoreventos.setDthr2evento(dthr);
			prcoletoreventos.setMsdthr2evento((double) milissegundos);
			prcoletoreventos.setInf01("MundancaDeCavidadesAtivas");
			prcoletoreventos.setInf02("Valor="+valor);
			lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);	
		}
		return retorno;
	}

	private List<Object> listIdespecificFromIjespecinsppro(PrUp prup,boolean validaPorMolde){

		if(prup.getPrUpProdutos() !=null && prup.getPrUpProdutos().size()>0){

			String cdmolde="999999";
			BigDecimal cfgespqld = BigDecimal.ONE;

			if(validaPorMolde==true){
				cdmolde = prup.getCdmolde();
				cfgespqld = new BigDecimal(2);
			}

			String cdprod=((PrUpProduto)prup.getPrUpProdutos().toArray()[0]).getCdproduto();

			MapQuery q = new MapQuery(this.getDaoInjet().getSession());		

			q.append("SELECT  ijespec.id.idespecific");
			q.append("FROM  Ijespecinsppro ijespec,");
			q.append("Ijparaminspec ijparam,");
			q.append("Ijtbprocfgespqld ijtbproc,");
			q.append("Ijespecinspproxinj ijespecinj"); 
			q.append("WHERE	ijespec.id.cdproduto = :cdproduto");
			q.append("AND	ijespec.id.cdmolde = :cdmolde");
			q.append("AND 	ijespec.dthrfvalespecific IS NULL");
			q.append("AND	ijespec.especificativa = 1");
			q.append("AND 	ijespec.ijtbdrivers.iddriver ='WHI_IHM_100'");
			q.append("AND	ijparam.idespecific = ijespec.id.idespecific");
			q.append("AND 	ijparam.tpespecific = 2");
			q.append("AND	ijtbproc.ijtbpro.cdproduto = ijespec.id.cdproduto");
			q.append("AND	ijtbproc.cfgespqld = :cfgespqld");
			q.append("AND 	ijespecinj.id.cdproduto = ijespec.id.cdproduto");
			q.append("AND 	ijespecinj.id.idespecific = ijespec.id.idespecific");
			q.append("AND 	ijespecinj.id.cdmolde = ijespec.id.cdmolde");
			q.append("AND	ijespecinj.id.dthrivalespecific = ijespec.id.dthrivalespecific");
			q.append("AND	ijespecinj.ijtbinj.cdinjetora = :cdinjetora");

			q.defineParametro("cdproduto", cdprod);
			q.defineParametro("cdmolde", cdmolde);
			q.defineParametro("cfgespqld", cfgespqld);
			q.defineParametro("cdinjetora", prup.getCdmaquina());
			List<Object> listIdespecific = q.list();			
			q = null;
			if (listIdespecific != null && listIdespecific.size()>0) {
				return listIdespecific;
			}			   
		}
		return null;
	}

	public IwsListaInspecoesAutoDTO obtemListaDeVariaveisParaAferir(IdwLogger log, int idLog, String idUP) {
		PrUp prup = pesquisaPrup(log, idLog, idUP);
		List<Object> listIdespecific=null;
		IwsListaInspecoesAutoDTO retorno=new IwsListaInspecoesAutoDTO();
		//Verifica se h� vinculo por Molde
		try{
			listIdespecific=listIdespecificFromIjespecinsppro(prup,true);
		}catch(Exception e){
			log.info("N�o conseguiu obter lista de listIdespecificFromIjespecinsppro("+idUP+") especificando o Molde");
		}
		//Caso n�o haja vinculo por Molde, Verifica se h� vinculo sem Molde
		if(listIdespecific == null){
			try{
				listIdespecific=listIdespecificFromIjespecinsppro(prup,false);
			}catch(Exception e){
				log.info("N�o conseguiu obter lista de listIdespecificFromIjespecinsppro("+idUP+") sem especificar o Molde");
			}			
		}

		if(listIdespecific!=null && listIdespecific.size()>0){
			MapQuery q = new MapQuery(this.getDaoInjet().getSession());	

			q.append("SELECT ijgrpinsp");
			q.append("FROM Ijgrpparaminspxord ijgrpinsp");
			q.append("WHERE ijgrpinsp.id.cdgrpparam in (");
			q.append("SELECT min(otbl.id.cdgrpparam )");
			q.append("FROM Ijgrpparaminspxord otbl");
			q.append("WHERE otbl.id.idespecific IN (:listidespecific)"); 
			q.append("AND (SELECT count(*)"); 
			q.append("FROM Ijgrpparaminspxord otblcount");
			q.append("WHERE otblcount.id.cdgrpparam = otbl.id.cdgrpparam) = :nrcount");
			q.append("GROUP BY otbl.id.cdgrpparam");
			q.append("HAVING count(*) = :nrcount)");
			q.append("ORDER BY ijgrpinsp.ordemedicao, ijgrpinsp.id.idespecific");

			q.defineListaParametro("listidespecific", listIdespecific);
			q.defineParametro("nrcount",new Long(listIdespecific.size()));
			List<Ijgrpparaminspxord> listijgrpinsp = q.list();
			if(listijgrpinsp!=null && listijgrpinsp.size()>0){
				IwsInspecaoAutoDTO inspec;
				for(Ijgrpparaminspxord ijgrpinsp :listijgrpinsp){
					inspec= new IwsInspecaoAutoDTO();
					inspec.setOrdemedicao(ijgrpinsp.getOrdemedicao());
					inspec.setCdgrpparam(ijgrpinsp.getId().getCdgrpparam());
					inspec.setIdespecific(ijgrpinsp.getId().getIdespecific());
					retorno.addInspecao(inspec);
				}

			}
		}	
		retorno.setInicializado(true);
		return retorno;
	}

	public Boolean isOpConcluida(IdwLogger log, int idLog, String cdinjetora) {
		Boolean retorno= false;
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());	

		q.append("SELECT ");	
		q.append("(SELECT SUM(pp.qtpecasproduzir) FROM Ijopprodutos pp");	
		q.append("WHERE pp.id.nrop = cnsop.id.nrop) as prodplanejada,");

		q.append("SUM((cnsop.qtinjnormal * cav.id.cavativas) + cnsop.qtprodpkgcic) as prodbruta,");

		q.append("(SELECT SUM(detref.qtpcsref)");
		q.append("FROM Ijcnsmaqopdetref detref, Ijmolpro molpro");
		q.append("WHERE detref.id.cdinjetora = cnsop.id.cdinjetora");
		q.append("AND detref.id.nrop = cnsop.id.nrop");
		q.append("AND detref.id.cdmolde = cnsop.id.cdmolde");
		q.append("AND detref.id.cdestrutura = cnsop.id.cdestrutura");
		q.append("AND detref.id.dthrivalestru = cnsop.id.dthrivalestru");
		q.append("AND detref.id.dthrivalcic = cnsop.id.dthrivalcic");
		q.append("AND molpro.id.cdmolde = detref.id.cdmolde"); 
		q.append("AND molpro.id.cdestrutura = detref.id.cdestrutura");  
		q.append("AND molpro.id.dthrival = detref.id.dthrivalestru");    
		q.append("AND molpro.cdidentificacao = detref.id.cdidentificacao) as prodrefugada"); 

		q.append("FROM Ijcnsmaqop cnsop, Cavidades cav, Ijtbinj tbinj");   
		q.append("WHERE cav.id.cdmolde = cnsop.id.cdmolde");   
		q.append("AND cav.id.cdestrutura = cnsop.id.cdestrutura");     
		q.append("AND cav.id.dthrival    = cnsop.id.dthrivalestru");     
		q.append("AND cnsop.id.nrop = tbinj.opatual");   
		q.append("AND tbinj.cdinjetora = :cdinjetora"); 
		q.append(" GROUP BY cnsop.id"); 

		q.defineParametro("cdinjetora",cdinjetora);
		List<Object> consulta = q.list();

		Double prodPlan=0d,prodBruta=0d,prodRefugada=0d;

		if(consulta!=null && consulta.size()>0){	
			int i=0;
			for(Object res: consulta ){
				Object[] dados = (Object[])res;		
				i++;
				try{
					prodPlan= Double.valueOf(dados[0].toString());
				}catch(Exception exc){
					log.info("isOpConcluida..linha"+i+" cdinjetora:"+ cdinjetora +" prodPlan zerada");
				}
				try{
					prodBruta += Double.valueOf(dados[1].toString());
				}catch(Exception exc){
					log.info("isOpConcluida..linha"+i+" cdinjetora:"+ cdinjetora +" prodBruta zerada");
				}
				try{
					prodRefugada += Double.valueOf(dados[2].toString());
				}catch(Exception exc){
					log.info("isOpConcluida..linha"+i+" cdinjetora:"+ cdinjetora +" prodRefugada zerada");
				}
			}

			if(prodPlan<=(prodBruta-prodRefugada)){				  
				retorno=true;
			}
			log.info("isOpConcluida="+retorno+" cdinjetora:"+ cdinjetora +" prodPlan:"+
					prodPlan +" prodBruta:"+ prodBruta +" prodRefugada:"+ prodRefugada +" linhas:"+consulta.size());
		}		
		return retorno;
	}  

	public boolean verificaSeFinalizaOP(IdwLogger log, int idLog, PrUp prup){
		boolean retorno=false;

		if(prup.getCfgtpsessaoproducao().equals("11")==false)
			return retorno;
		retorno=isOpConcluida(log, idLog, prup.getCdmaquina());		

		return retorno;
	}

	
	public void verificaSeQuebraDeParadaAT(IdwLogger log, int idLog, PrUp prup, Date dthrevento){
		try{
			MapQuery q = new MapQuery(this.getDaoInjet().getSession());
			q.append("select otbl ");
			q.append("from IjcfgIntat otbl");
			q.setMaxResults(1);		
			IjcfgIntat otbl = (IjcfgIntat) q.uniqueResult();
			
			if(otbl !=null){
				if (prup.getStparadaemaberto() != null
						&& prup.getStparadaemaberto() == '1') {	
					
					boolean finalizaparada=false,quebraDiaAnterior;
					long horaRef=otbl.getHrinireferencia().intValue();
					long segIntervaloQuebra=otbl.getIntervaloquebra().intValue();
					long horaAtual = (long) dthrevento.getTime()/1000;
					long iniParRef = (long) prup.getDthriniultimaparada().getTime()/1000;
					long regIniDia = (long) DataHoraRN.getDataInicioDiaAtual().getTime()/1000;
					long diffAtualRef=0;	
					long quebraMdc=0;
					
					if((horaAtual-iniParRef) > 86400){
						//Filtro para o caso do sistema ter ficado mais de um dia sem execu��oo!
						//Evita gera��oo de paradas que poderiam sobrecarregar o banco
						finalizaparada=true;				
					}else{
						horaAtual-=regIniDia;
						
						if(horaAtual<horaRef){
							diffAtualRef=horaAtual+86400-horaRef;
							quebraDiaAnterior=true;
						}else{	
							diffAtualRef=horaAtual-horaRef;	
							quebraDiaAnterior=false;
						}
						
						iniParRef=iniParRef-regIniDia;				
					
						quebraMdc=(long) diffAtualRef/segIntervaloQuebra;
						
						if(quebraDiaAnterior==true){
							horaRef+=((segIntervaloQuebra*quebraMdc)-86400);
						}else{
							horaRef+=(segIntervaloQuebra*quebraMdc);
						}		
						if(iniParRef<(horaRef)){
							finalizaparada=true;						
						}
											
					}
					if(finalizaparada==true){	
						
						Date dthrBeat=DataHoraRN.getDataComMilisegundos(prup.obtemDtHrUltimoHeartBeat(),prup.obtemMsDthrUltimoHeartBeat());
						prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(dthrevento));
						prup.mudaDtHrUltimoHeartBeat(dthrevento);
						fecharParada(log, idLog, prup);// fecha parada

						this.getDaoPdba().flushReiniciandoTransacao();

						PrColetorEventos prcoletoreventos = new PrColetorEventos();
						prcoletoreventos.setTpevento(new BigDecimal(8));
						prcoletoreventos.setDthr1evento(dthrevento);
						prcoletoreventos.setMsdthr1evento(DataHoraRN.getApenasMilisegundos(dthrevento));
						prcoletoreventos.setNrop(prup.getNrop());
						prcoletoreventos.setCdmolde(prup.getCdmolde());
						prcoletoreventos.setCdestrutura(prup.getCdestrutura());
						prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
						prcoletoreventos.setPrUp(prup);
						prcoletoreventos.setInf01("1");
						prcoletoreventos.setInf20("Quebra de Parada AT");
						lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);// abre parada

						if (IdwFacade.getInstancia().isIDWAtivo()) {
							// Alessandre-tanto o inicio da parada qto o final da para estao
							// chamando o mesmo servico, e o servico ira executar inicio ou fim da parada dependendo do 
							// status de funcionamento da maquina. Encontrar uma forma de dizer q a maq esta trabalhando
							// aqui para q o servico inicio uma parada
							IcUpDTO icupdto = Stubedelegate.getInstancia().getMsthread().getIcUp(prup.getIdup().toString());

							icupdto.getUpDTO().setUpTrabalhando(true);

							ParadaPdbaMsEvtRN rnpdba = new ParadaPdbaMsEvtRN();
							rnpdba.executarServico(getDaoPdba().getSession(), prup.getIdup().toString(), null, dthrevento, null, null, ServicoFactory._INICIO_PARADA, "veriricaSeQuebraDeParadaAT " + DataHoraRN.getDataHoraAtualFormatada());
						}

						prup.mudaParadaEmAberto(true);
						this.getDaoPdba().getSession().merge(prup);	

						this.getDaoPdba().flushReiniciandoTransacao();

						ParadaRN prn = new ParadaRN(this.getDaoInjet(), this.getDaoPdba());											
						prn.setTr_UltimaParadaInicio(log, idLog, prup.getIdup().toString(), dthrevento, true);						

						prup.mudaDtHrReferenciaParaEventos(dthrBeat);
						prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(dthrBeat));
					}
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	public IwsDadosIHMBalancaDTO SincronizaIHMBalanca(String ip) throws Exception{
		IwsDadosIHMBalancaDTO retorno = new IwsDadosIHMBalancaDTO();
		
		try{
			IwsListaUpDTO listaUps = getUpsIHM(ip, new Date(), false);
			IwsUpDTO updto = listaUps.getUps().get(0);
			
			retorno.setDslinha(updto.getUp());
			retorno.setDsprodutoext(updto.getCp().getProdutos().get(0).getDsProduto());
			retorno.setNropext(updto.getCp().getNropestendido());
			retorno.setNumeroItem(updto.getCp().getProdutos().get(0).getCdProduto());
			retorno.setCdlinha(updto.getCdMaquina());
			
			MapQuery q = new MapQuery(this.getDaoInjet().getSession());
			q.append("select otbl ");
			q.append("from Ijtbproembalagem otbl");
			q.append("where otbl.ijtbpro.cdproduto = :cdprod");
			q.defineParametro("cdprod", updto.getCp().getProdutos().get(0).getCdProduto());
			q.setMaxResults(1);		
			Ijtbproembalagem otbl = (Ijtbproembalagem) q.uniqueResult();
			
			if(otbl != null){
				retorno.setPesoembalagem(otbl.getTaraembalagem());
				retorno.setPesoprodutoun(otbl.getIjtbpro().getPliquidomedio());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return retorno;
	}
	
	public String getCdmoldeEstendido(String cdMolde){
		String retorno = cdMolde;
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());
		q.append("select otbl.cdmolestendido");
		q.append("from  Ijtbmol otbl");
		q.append("where otbl.cdmolde=:cdmolde");
		q.defineParametro("cdmolde", cdMolde);
		q.setMaxResults(1);
		retorno = (String) q.uniqueResult();
		return retorno;
	}
	
	public IwsComplementaOP getTr_verificaSePedeComplemento(String idUP,String nrop, IdwLogger log, int idLog){
		IwsComplementaOP retorno = new IwsComplementaOP();
		PrUp prup = pesquisaPrup(log, idLog, idUP);
		
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());
		List<MoldeEstruturaDTO> lista;
		retorno.setOPValida(false);
		
		if(prup.getCfgtpsessaoproducao().equals("12")){
			
			q.append("select DISTINCT otbl.cdproduto");
			q.append("from IjIntArthiLogImpOp otbl");
			q.append("WHERE otbl.nropErp = :nrop");
			q.defineParametro("nrop", nrop);
			
			List<Object> listprod = q.list();
			int qtdprod=0;
			if(listprod!=null && listprod.size()>0){
				qtdprod=listprod.size();
				
				String listaProduto ="";
				int ind=qtdprod;
				for(Object obj : listprod){
					listaProduto += "'"+(String) obj+"'";
					ind--;
					if(ind>0)
						listaProduto+=",";
				}	

				String sql = "";
				sql += "SELECT DISTINCT a.cdmolde as cdmolde, a.cdestrutura as cdestrutura ";
				sql += "FROM ijmolpro a, (SELECT c.cdmolde, c.cdestrutura ";
				sql +=					"FROM ijmolpro c ";
				sql +=					"WHERE c.cdproduto IN (::listaprod) ";
				sql +=					"AND c.dthrfval IS NULL ";
				sql +=					"GROUP BY c.cdmolde, c.cdestrutura ";
				sql +=					"HAVING COUNT(*) = ::qtdprod ) b ";
				sql += "WHERE a.cdproduto IN (::listaprod) ";				
				sql += "AND a.dthrfval IS NULL ";
				sql += "AND a.cdmolde = b.cdmolde ";
				sql += "AND a.cdestrutura = b.cdestrutura ";
				sql += "GROUP BY a.cdmolde, a.cdestrutura ";
				sql += "HAVING COUNT(*) = ::qtdprod ";
				
				sql = sql.replaceAll("::qtdprod", String.valueOf(qtdprod));				
				sql = sql.replaceAll("::listaprod",	listaProduto);

				Query SQLq = this.getDaoInjet().getSession().createSQLQuery(sql);	
				SQLq.setResultTransformer(Transformers.aliasToBean(MoldeEstruturaDTO.class));
				
				lista = SQLq.list();
				if(lista != null  && lista.size()>0){
					retorno.setOPValida(true);	
					retorno.setRequerqtd(false);
					if(lista.size()>1){			
						retorno.setRequerComplemento(true);
						retorno.setRequerMolde(true);
						retorno.setRequerEstrutura(true);
					}else{
						retorno.setRequerComplemento(false);
						retorno.setRequerMolde(false);
						retorno.setRequerEstrutura(false);
						retorno.setCdmolde(getCdmoldeEstendido(lista.get(0).getCdmolde()));
						retorno.setCdestrutura(lista.get(0).getCdestrutura());
					}
				}else{
					retorno.setOPValida(false);
					retorno.setTxtMensagem("    OP NAO        ENCONTRADA");
				}				
			}else{
				retorno.setOPValida(false);
				retorno.setTxtMensagem("    OP NAO        ENCONTRADA");
			}
			listprod=null;			
			
		}else if(prup.getCfgtpsessaoproducao().equals("13")){
			q.append("select DISTINCT otbl.cdmolde as cdmolde, otbl.cdestrutura as cdestrutura");
			q.append("from IjIntFitesaOp otbl");
			q.append("WHERE otbl.nropErp = :nrop");
			q.defineParametro("nrop", nrop);
			q.query().setResultTransformer(Transformers.aliasToBean(MoldeEstruturaDTO.class));
			lista = q.list();
			if(lista != null  && lista.size()>0){
				retorno.setOPValida(true);
				retorno.setRequerComplemento(true);
				retorno.setRequerqtd(true);
				if(lista.size()>1){
					retorno.setRequerMolde(true);
					retorno.setRequerEstrutura(true);
				}else{
					retorno.setRequerMolde(false);
					retorno.setRequerEstrutura(false);
					retorno.setCdmolde(getCdmoldeEstendido(lista.get(0).getCdmolde()));
					retorno.setCdestrutura(lista.get(0).getCdestrutura());
				}
			}else{
				retorno.setOPValida(false);
				retorno.setTxtMensagem("    OP NAO        ENCONTRADA");
			}
		}else{
			retorno.setTxtMensagem("   TP SESSAO     INVALIDA");
		}		
		
		q=null;
		lista=null;
		
		return retorno;		
		
	}
	
	public IwsErroDTO lancaIncProdPlan(String idUP,int quantidade,Date dthrevt, IdwLogger log, int idLog){
		IwsErroDTO retorno = new IwsErroDTO();		
		PrUp prup = pesquisaPrup(log, idLog, idUP);
		
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		int milissegundos = DataHoraRN.getApenasMilisegundos(dthrevt);
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(49)); 
		prcoletoreventos.setStevento("0");
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dthrevt);
		prcoletoreventos.setMsdthr1evento((double) milissegundos);
		prcoletoreventos.setDthr2evento(dthrevt);
		prcoletoreventos.setMsdthr2evento((double) milissegundos);
		prcoletoreventos.setInf01(String.valueOf(quantidade));
		
		
		PrEventosBridgeCollecDb eventoRetorno = null;

		try {
			eventoRetorno = lancarEventoEsperaPrEventosBridgeCollecDb(log, idLog, prcoletoreventos, true);
			retorno.setSucesso(false);
			if(eventoRetorno.getTxtmensagem()!=null){
				if (eventoRetorno.getTxtmensagem().indexOf("(") >= 0)
					retorno.setMensagem(eventoRetorno.getTxtmensagem().substring(0, eventoRetorno.getTxtmensagem().indexOf("(")));
				else
					retorno.setMensagem(eventoRetorno.getTxtmensagem());
			}
			
			if(eventoRetorno.getTpevento().equals(new BigDecimal(59))){
				if(eventoRetorno.getInf01().equals("1")){
					retorno.setSucesso(true);	
				}
			}				
			
		} catch (MestreOfflineException e) {
			log.info("Detectou que BC esta OFF-line: " + idUP);
			retorno.setMensagem("Detectou que BC esta offline.");
			retorno.setSucesso(false);
		}
			
		return retorno;		
	}
	
	public boolean setTr_InformaLote(
			IdwLogger log, int idLog,
			String idUp, String lote, Date DataHrAtual) throws RegistroDesconhecidoException, ServicoFalhouException {
		boolean retorno = false;
		double milisegundos = DataHoraRN.getApenasMilisegundos(DataHrAtual);

		PrUp prup = null;
		prup = pesquisaPrup(log, idLog, idUp);

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(50));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(DataHrAtual);
		prcoletoreventos.setMsdthr1evento(milisegundos);
		prcoletoreventos.setDthr2evento(DataHrAtual);
		prcoletoreventos.setMsdthr2evento(milisegundos);
		prcoletoreventos.setInf01(lote);
		lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);

		retorno = true;
		return retorno;

	}	

	public boolean setTr_FinalizaLote(
			IdwLogger log, int idLog,
			String idUp, String lote, Date DataHrAtual) throws RegistroDesconhecidoException, ServicoFalhouException {
		boolean retorno = false;
		double milisegundos = DataHoraRN.getApenasMilisegundos(DataHrAtual);

		PrUp prup = null;
		prup = pesquisaPrup(log, idLog, idUp);

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(51));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(DataHrAtual);
		prcoletoreventos.setMsdthr1evento(milisegundos);
		prcoletoreventos.setDthr2evento(DataHrAtual);
		prcoletoreventos.setMsdthr2evento(milisegundos);
		prcoletoreventos.setInf01(lote);
		lancarEventoEsperaPrColetorEventos(log, idLog, prcoletoreventos, false);

		retorno = true;
		return retorno;

	}	

}
