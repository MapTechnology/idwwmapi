package idw.model.rn.consolidacao.perdamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.hibernate.StaleStateException;
import org.hibernate.exception.LockAcquisitionException;

import idw.model.dao.MapQuery;
import idw.model.excessoes.SemCalendarioException;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwCalsem;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolpalog;
import idw.model.pojos.DwConsolpemp;
import idw.model.pojos.DwConsolpempoco;
import idw.model.pojos.DwConsolperdamplog;
import idw.model.pojos.DwConsolpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTPerdamp;
import idw.model.pojos.MsEvt;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmMapa;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PerdampRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.TempoRealRN;
import idw.model.rn.alimentacao.ConsumoAlimentacaoRN;
import idw.model.rn.alimentacao.MapaAlimentacaoRN;
import idw.model.rn.consolidacao.EventoInvalidoEmParadaRegulagemException;
import idw.model.rn.consolidacao.EventoInvalidoException;
import idw.model.rn.consolidacao.IConsolidacao;
import idw.model.rn.consolidacao.estoque.ConsultaCdPaComFormatacoes;
import idw.model.rn.servemail.ServicoEmailFactory;
import idw.model.rn.servemail.ServicoEmailPerdaMateriaPrimaRN;
import idw.util.IdwLogger;
import injetws.model.excessoes.SemSGBDException;

public class ConsolidacaoPerdaMP extends ConsolidaRN implements IConsolidacao {

	/**
	 * TODO documentar procedimento TODO usar como modelo a consolidacao de
	 * refugo
	 * 
	 * @param omPt
	 * @param list
	 *            <dwCalSem>
	 * @param msEvt
	 * @param omcfg
	 * @param log
	 * @throws SemCicloPadraoException
	 * @throws SemSGBDException
	 * @throws SemCalendarioException
	 */
	@Override
	public void executarConsolidacao(OmPt omPt, DwConsolpt dwconsolp, List<DwCalsem> dwCalsems, MsEvt msEvt, OmCfg omcfg, IdwLogger log, int idLog, int identacao) throws EventoInvalidoException, SemCalendarioException, SemSGBDException, SemCicloPadraoException {
		Validate.notNull(omPt, "Ompt eh nulo");
		Validate.notNull(msEvt, "msEvt e nulo");
		Validate.notNull(omcfg, "omcfg e nulo");
		Validate.notNull(log, "log e nulo");
		Validate.notNull(dwCalsems, "Lista de calendario nula");
		Validate.notNull(msEvt.getQtErromontagem(), "Qtde erro null");
		Validate.isTrue(msEvt.getQtErromontagem() != 0, "Quantidade de erro deve ser maior que zero");

		Date dtHrPerdaMP = msEvt.getDthrEvento();

		// Não pode existir evento de perda de matéria-prima dentro de regulagem
		// de máquina
		DwConsolpalog dwConsolpalog = getUltimaParadaFromDwConsolpalog(omPt);
		if (dwConsolpalog != null) {
			if (dwConsolpalog.isDtHrDentroParadaComRegulagem(dtHrPerdaMP)) {
				throw new EventoInvalidoEmParadaRegulagemException(msEvt, dwConsolpalog);
			}
		}

		
		log.iniciaAvaliacao("Obtendo ppCp");
		PpCp ppCp = obtemPpCp(log, idLog, identacao, omPt, dwCalsems, msEvt, omcfg);
		log.paraAvaliacao();
		log.info(log.getAvaliacaoCompleta());
		Validate.notNull(ppCp, "ppCp nao pode ser nulo");

		log.iniciaAvaliacao("Obtendo DwFolha");
		FolhaRN folhaRN = new FolhaRN(this.getDao());
		DwFolha dwFolha = folhaRN.getDwFolhaAtiva(ppCp);
		log.paraAvaliacao();
		log.info(log.getAvaliacaoCompleta());
		Validate.notNull(dwFolha, "nao tem folha ativa para o ppCp");

		// Pega ConsolId
		DwConsolid dwConsolid = this.obtemConsolIdTurno(log, idLog, identacao, omPt, dwCalsems, ppCp, dwFolha, dtHrPerdaMP, omcfg, msEvt.getDwPepro());
		
		TempoRealRN.setDthrEmDwRtBaseadoNosEventos(dwConsolid.getDwRt(), msEvt.getDthrEvento());
		
		DwTPerdamp dwTPerdamp = null;
		PerdampRN perdaRN = new PerdampRN();

		BigDecimal qtErroMontagem = new BigDecimal(msEvt.getQtErromontagem());

		// Obtem o codigo da perda de MP
		log.iniciaAvaliacao("getDwTPerdamp");
		try {
			perdaRN.setDaoSession(this.getDao().getSession());
			dwTPerdamp = perdaRN.getDwTPerdamp((long) msEvt.getTpErromontagem());
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		log.paraAvaliacao();
		log.info(log.getAvaliacaoCompleta());

		// Pegar referencia do produto
		// Se o cdproduto do evento for null eh pq a panasonic nao envia o
		// codigo do produto, entao
		// abaixo devemos pesquisar no mapa de alimentacao pra descobrir qual
		// foi o componente perdido pelo checkfeeder
		// mas por enquanto iremos apenas pegar o cdproduto 0 desconhecido
		String cdProduto = msEvt.getCdProduto();
		OmMapapa ommapapa = null;
		
		// Se nao existe produto enviado, entao pegar o componente do erro se o
		// mesmo tiver sido definido
		if (cdProduto == null || cdProduto.equals(""))
			if (msEvt != null && msEvt.getCdComponente() != null && msEvt.getCdComponente().equals("") == false)
				cdProduto = msEvt.getCdComponente();

		// Se nao houver um componente, entao utilizar o feeder para localizar
		// via mapa qual o componente a partir do feeder
		if (cdProduto == null || cdProduto.equals("") || cdProduto.equals("0")) {
			// Obter qual a folha a partir do msevt.nrop para em seguida pegar o
			// produto q sera usado para encontrar o mapapa
			DwFolhaiac dwfolhaiac = null;
			for (DwFolhaiac iac : dwFolha.getDwFolhaiacs()) {
				dwfolhaiac = iac;
			}
			if (dwfolhaiac != null) {
				OmProduto omproduto = dwfolhaiac.getOmProduto();

				if (omproduto != null) {

					// Obter a referencia orignial do cdFeeder removendo o Z
					String cdFeeder = msEvt.getDepara();
					MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
					rn.setDao(getDao());
					log.info("1) getMapapaByProdutoFeeder cdProduto="
							+ omproduto.getCdProduto() + " - posicao="
							+ cdFeeder);
					ommapapa = rn.getMapapaByProdutoFeeder(omproduto.getCdProduto(), cdFeeder, omPt, log, idLog, 0);

					if (ommapapa != null) {
						cdProduto = ommapapa.getOmProduto().getCdProduto();

						log.info("cdProduto encontrado pelo mapa=" + cdProduto);
					}
				}
			}
		} else {
			MapaAlimentacaoRN rn = new MapaAlimentacaoRN();
			rn.setDao(getDao());

			log.info("2) getMapapaByProdutoFeeder2 cdProduto="
					+ cdProduto + " - posicao="
					+ msEvt.getDepara());
			ommapapa = rn.getMapapaByProdutoFeeder(cdProduto, msEvt.getDepara(), omPt, log, idLog, 0);

			if (ommapapa != null) {
				log.info("cdProduto encontrado pelo mapa=" + cdProduto);
			} else if (msEvt.getCdFeeder() != null && msEvt.getCdFeeder().length() > 1) {
				String depara = msEvt.getCdFeeder().substring(1);
				log.info("3) getMapapaByProdutoFeeder3 cdProduto="
						+ cdProduto + " - posicao="
						+ depara);
				ommapapa = rn.getMapapaByProdutoFeeder(cdProduto, depara, omPt, log, idLog, 0);
				if (ommapapa != null)
					log.info("cdProduto encontrado pelo mapa=" + cdProduto);
			}
		}

		// Se mesmo assim nao houver um produto usar produto indefinido
		if (cdProduto == null || cdProduto.equals(""))
			cdProduto = "0";

		//Obtem omProduto do componente definido acima
		log.iniciaAvaliacao("getOmProduto");
		ProdutoRN produtoRN = new ProdutoRN(getDao());
		OmProduto omProduto;
		omProduto = produtoRN.getProdutoByCdEStAtivo(cdProduto);
		log.paraAvaliacao();
		log.info(log.getAvaliacaoCompleta());

		// Farei o cadastro do produto se o mesmo nao existir
		if (omProduto == null) {
			omProduto = new OmProduto();
			omProduto.setCdProduto(cdProduto);
			omProduto.setDsProduto("Cadastrada automaticamente pelo insert");
			omProduto.setRevisao((long) 1);
			omProduto.setDtRevisao(DataHoraRN.getDataHoraAtual());
			omProduto.setDtStativo(DataHoraRN.getDataHoraAtual());
			omProduto.setIdProduto(0l);
			omProduto.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
			omProduto.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
			omProduto.setStAtivo((byte) 1);
			omProduto.setTpProduto(OmProdutoTemplate.TpProduto.COMPONENTE.getId());
			getDao().makePersistent(omProduto);
		}
		Validate.notNull(omProduto, "Produto nao encontrado");

		int milSegundos = DataHoraRN.getApenasMilisegundos(dtHrPerdaMP);

		// Pego informacao referente ao rap se o rap estiver preenchido no
		// evento
		DwRap dwrapFeeder = null;
		if (msEvt.getCdFeeder() != null && msEvt.getCdFeeder().equals("") == false) {
			// analisando o CD_FEEDER por meio do PT, produto e o getFeeder do
			// MSEVT - Cileno 07/10/2014
			OmMapa mapa = getMapa(msEvt, omPt);
			try {
				ConsultaCdPaComFormatacoes consultaCdPaComFormatacoes = new ConsultaCdPaComFormatacoes();
				OmPa omPa = consultaCdPaComFormatacoes.getOmPa(msEvt.getCdFeeder(), mapa);

				if (omPa != null) {
					msEvt.setCdFeeder(omPa.getCdPa());
				} else {
					ServicoEmailFactory email = ServicoEmailFactory.getInstance(
									log,
									idLog,
									identacao,
									this.getDao().getSession(),
									ServicoEmailFactory.TpEvt.PERDA_MATERIA_PRIMA);
					
					((ServicoEmailPerdaMateriaPrimaRN) email).setCdFeeder(msEvt.getCdFeeder());
					((ServicoEmailPerdaMateriaPrimaRN) email).setMapa(mapa);
					email.gerarAlerta(dwConsolid);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Ele não poderá ser nulo
			log.iniciaAvaliacao("getDwRap feeder");
			dwrapFeeder = perdaRN.getDwRap(msEvt.getCdFeeder());
			log.paraAvaliacao();
			log.info(log.getAvaliacaoCompleta());
			if (dwrapFeeder == null) {
				// incluir rap para o feeder
				dwrapFeeder = new DwRap();
				dwrapFeeder.setId(null);
				dwrapFeeder.setCdRap(msEvt.getCdFeeder());
				// dwrapFeeder.setCdRap(cdPa);
				dwrapFeeder.setRevisao(1l);
				dwrapFeeder.setDsRap("Rap Feeder cadastrado automaticamente pela consolidacao");
				dwrapFeeder.setDtRevisao(DataHoraRN.getDataHoraAtual());
				dwrapFeeder.setStAtivo((byte) 1);
				dwrapFeeder.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
				dwrapFeeder.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());
				dwrapFeeder.setDtStativo(DataHoraRN.getDataHoraAtual());

				getDao().makePersistent(dwrapFeeder);
				
			}
		}

		// Pego informacao sobre o Nozzle
		DwRap dwrapNozze = null;
		if (msEvt.getCdNozzle() != null && msEvt.getCdNozzle().equals("") == false) {
			log.iniciaAvaliacao("getDwRap Nozzle");
			dwrapNozze = perdaRN.getDwRap(msEvt.getCdNozzle());
			log.paraAvaliacao();
			log.info(log.getAvaliacaoCompleta());
			if (dwrapNozze == null) {
				// incluir rap para o feeder
				dwrapNozze = new DwRap();
				dwrapNozze.setId(null);
				dwrapNozze.setCdRap(msEvt.getCdNozzle());
				dwrapNozze.setRevisao(1l);
				dwrapNozze.setDsRap("Rap Nozzle cadastrado automaticamente pela consolidacao");
				dwrapNozze.setDtRevisao(DataHoraRN.getDataHoraAtual());
				dwrapNozze.setStAtivo((byte) 1);
				dwrapNozze.setDtStativo(DataHoraRN.getDataHoraAtual());
				dwrapNozze.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
				dwrapNozze.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());

				getDao().makePersistent(dwrapNozze);
			}
		}

		// Inserir a perda de materia-prima se o feeder vier identificado
		DwConsolpemp dwconsolpempFeeder = null;
		if (dwrapFeeder != null) {
			DwConsolperdamplog dwConsolperdamplog = new DwConsolperdamplog();
			dwConsolperdamplog.setDwRap(dwrapFeeder);
			dwConsolperdamplog.setDthrPerdamp(msEvt.getDthrEvento());
			dwConsolperdamplog.setMsDthrperdamp(milSegundos);
			dwConsolperdamplog.setOmPt(omPt);
			dwConsolperdamplog.setPpCp(ppCp);
			dwConsolperdamplog.setOmMapapa(ommapapa);
			dwConsolperdamplog.setOmProduto(omProduto);
			dwConsolperdamplog.setDwTPerdamp(dwTPerdamp);
			dwConsolperdamplog.setQtAutoPerdamp(qtErroMontagem);
			dwConsolperdamplog.setQtManuPerdamp(BigDecimal.ZERO);
			dwConsolperdamplog.setIdConsolpemplog(0l);
			this.getDao().makePersistent(dwConsolperdamplog);

			// Pega dwConsol
			DwConsol dwConsol = null;
			for (DwConsol item : dwConsolid.getDwConsols()) {
				dwConsol = item;
				break;
			}
			// Enconrta o DwConsolpemp do dwconsol em questao e do tipo da perda
			log.iniciaAvaliacao("pesquisarDwConsolpemp");
			dwconsolpempFeeder = pesquisarDwConsolpemp(dwConsol, dwTPerdamp);
			log.paraAvaliacao();
			log.info(log.getAvaliacaoCompleta());

			if (dwconsolpempFeeder == null) {
				dwconsolpempFeeder = new DwConsolpemp();
				dwconsolpempFeeder.setDwConsol(dwConsol);
				dwconsolpempFeeder.setDwTPerdamp(dwTPerdamp);
				dwconsolpempFeeder.setIdConsolpemp(0l);
				dwconsolpempFeeder.setQtAutoPerdamp(qtErroMontagem);
				dwconsolpempFeeder.setQtManuPerdamp(BigDecimal.ZERO);
			} else {
				dwconsolpempFeeder.setQtAutoPerdamp(dwconsolpempFeeder.getQtAutoPerdamp().add(qtErroMontagem));
			}

			getDao().makePersistent(dwconsolpempFeeder);

			// Inserir em DwConsolpempoco
			DwConsolpempoco dwconsolpempocoFeeder = new DwConsolpempoco();
			dwconsolpempocoFeeder.setDwConsolpemp(dwconsolpempFeeder);
			dwconsolpempocoFeeder.setDwConsolperdamplog(dwConsolperdamplog);
			dwconsolpempocoFeeder.setIdConsolpempoco(0l);
			getDao().makePersistent(dwconsolpempocoFeeder);

			//Se a perda vinher de uma desalimentação não é para consumir
			boolean isConsumir = msEvt.getOrigem().contains("Desalimentacao: PerdaMP") ? false: true;

			if (isConsumir) {
				// TODO milton remover try catch após teste -- ConsumoAlimentacaoRN.CONSUMIR_MATERIA_PRIMA
				try {
					ConsumoAlimentacaoRN consumoAlimentacao = new ConsumoAlimentacaoRN(getDao());
					consumoAlimentacao.consumirPorPerdaComponente(log, idLog, omPt, omProduto, dwrapFeeder.getCdRap(), qtErroMontagem, msEvt.getDthrEvento());
					getDao().flush();
				} catch (LockAcquisitionException e) {
					e.printStackTrace();
					throw e;
				} catch (StaleStateException e) {
					e.printStackTrace();
					throw e;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// Inserir perda de componente via Nozzle se o mesmo vier identificado
		if (dwrapNozze != null) {
			DwConsolperdamplog pojoNozzle = new DwConsolperdamplog();
			pojoNozzle.setDwRap(dwrapNozze);
			pojoNozzle.setDthrPerdamp(msEvt.getDthrEvento());
			pojoNozzle.setMsDthrperdamp(milSegundos);
			pojoNozzle.setOmPt(omPt);
			pojoNozzle.setPpCp(ppCp);
			pojoNozzle.setOmProduto(omProduto);
			pojoNozzle.setDwTPerdamp(dwTPerdamp);
			pojoNozzle.setQtAutoPerdamp(qtErroMontagem);
			pojoNozzle.setQtManuPerdamp(BigDecimal.ZERO);
			this.getDao().makePersistent(pojoNozzle);

			// Pega dwConsol
			DwConsol dwConsol = null;
			for (DwConsol item : dwConsolid.getDwConsols()) {
				dwConsol = item;
				break;
			}

			// Enconrta o DwConsolpemp do dwconsol em questao e do tipo da
			// perda. Usa o do feeder se existir, senao pesquisa um
			DwConsolpemp dwconsolpempNozze = dwconsolpempFeeder;

			if (dwconsolpempNozze == null)
				dwconsolpempNozze = pesquisarDwConsolpemp(dwConsol, dwTPerdamp);

			if (dwconsolpempNozze == null) {
				dwconsolpempNozze = new DwConsolpemp();
				dwconsolpempNozze.setDwConsol(dwConsol);
				dwconsolpempNozze.setDwTPerdamp(dwTPerdamp);
				dwconsolpempNozze.setIdConsolpemp(0l);
				dwconsolpempNozze.setQtAutoPerdamp(qtErroMontagem);
				dwconsolpempNozze.setQtManuPerdamp(BigDecimal.ZERO);
			} else if (dwconsolpempFeeder == null) {
				dwconsolpempNozze.setQtAutoPerdamp(dwconsolpempNozze.getQtAutoPerdamp().add(qtErroMontagem));
			}

			getDao().makePersistent(dwconsolpempNozze);

			// Inserir em DwConsolpempoco
			DwConsolpempoco dwconsolpempocoNozzle = new DwConsolpempoco();
			dwconsolpempocoNozzle.setDwConsolpemp(dwconsolpempNozze);
			dwconsolpempocoNozzle.setDwConsolperdamplog(pojoNozzle);
			dwconsolpempocoNozzle.setIdConsolpempoco(0l);
			getDao().makePersistent(dwconsolpempocoNozzle);
		}
	}


	private OmMapa getMapa(MsEvt evt, OmPt pt) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("SELECT mapa");
		q.append("FROM OmMapa mapa");
		q.append("JOIN mapa.omPt pt");
		q.append("WHERE mapa.cdMapa LIKE :cdMapa");
		q.append("AND pt.cdPt = :cdPt");
		q.append("AND mapa.stAtivo = :stAtivo");
		q.append("ORDER BY mapa.revisao DESC");
		q.defineParametro("cdMapa", "%" + evt.getNrop() + "%");
		q.defineParametro("cdPt", pt.getCdPt());
		q.defineParametro("stAtivo", (byte) 1);
		q.setMaxResults(1);
		return (OmMapa) q.uniqueResult();
	}

	private DwConsolpemp pesquisarDwConsolpemp(DwConsol dwConsol,
			DwTPerdamp dwTPerdamp) {
		DwConsolpemp retorno = null;

		MapQuery q = new MapQuery(getDaoSession());

		q.append("select dwconsolpemp");
		q.append("from DwConsolpemp dwconsolpemp");
		q.append("where dwconsolpemp.dwConsol = :dwconsol");
		q.append("and dwconsolpemp.dwTPerdamp = :dwtperdamp");

		q.setMaxResults(1);
		q.defineParametro("dwconsol", dwConsol);
		q.defineParametro("dwtperdamp", dwTPerdamp);

		retorno = (DwConsolpemp) q.uniqueResult();
		return retorno;
	}
}
