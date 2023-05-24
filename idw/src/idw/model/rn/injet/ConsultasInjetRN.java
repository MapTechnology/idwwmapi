package idw.model.rn.injet;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.injet.Ijctrliniproc;
import idw.model.pojos.injet.Ijctrliniproctroca;
import idw.model.pojos.injet.Ijestmol;
import idw.model.pojos.injet.IjestmolId;
import idw.model.pojos.injet.Ijgalobj;
import idw.model.pojos.injet.Ijgalobjgal;
import idw.model.pojos.injet.IjgalobjgalId;
import idw.model.pojos.injet.Ijgalobjgalmtrz;
import idw.model.pojos.injet.IjgalobjgalmtrzId;
import idw.model.pojos.injet.Ijlogope;
import idw.model.pojos.injet.IjlogopeId;
import idw.model.pojos.injet.Ijmatrizsetup;
import idw.model.pojos.injet.Ijop;
import idw.model.pojos.injet.Ijopprodutos;
import idw.model.pojos.injet.Ijreproan;
import idw.model.pojos.injet.Ijreprodt;
import idw.model.pojos.injet.Ijreproms;
import idw.model.pojos.injet.Ijrt;
import idw.model.pojos.injet.Ijtbcli;
import idw.model.pojos.injet.Ijtbgal;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.Ijtbpar;
import idw.model.pojos.injet.Ijtbpro;
import idw.model.pojos.injet.Ijtbtur;
import idw.model.pojos.injet.Ijtreal;
import idw.model.pojos.injet.VMaqAnoBi;
import idw.model.pojos.injet.VMaqAnoPa;
import idw.model.pojos.injet.VMaqDataBi;
import idw.model.pojos.injet.VMaqDataPa;
import idw.model.pojos.injet.VMaqMesBi;
import idw.model.pojos.injet.VMaqMesPa;
import idw.model.pojos.injet.ViewInjet;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.dto.CrescimentoFiltroInjetDTO;
import idw.model.rn.injet.dto.CrescimentoGalInjetDTO;
import idw.model.rn.injet.dto.CrescimentoMaqInjetDTO;
import idw.model.rn.injet.dto.FiltroGalpaoInjetDTO;
import idw.model.rn.injet.dto.FiltroMaquinaInjetDTO;
import idw.model.rn.injet.dto.MaquinaInjetDTO;
import idw.model.rn.injet.dto.MaquinaTotalInjetDTO;
import idw.model.rn.injet.dto.OEEGalpoesInjetDTO;
import idw.model.rn.injet.dto.OEETotalGalpaoInjetDTO;
import idw.model.rn.injet.dto.ParadaInjetDTO;
import idw.model.rn.injet.dto.TaxaUtilizacaoInjetDTO;
import idw.model.rn.injet.dto.TaxaUtilizacaoMesInjetDTO;
import idw.model.rn.injet.dto.TrabalhandoOuParadaInjetDTO;
import idw.model.rn.injet.dto.TrocaOPInjetDTO;
import idw.webservices.dto.ElementoDTO;
import idw.webservices.dto.GraficoDTO;
import idw.webservices.dto.SerieDTO;

@SuppressWarnings("unchecked")
public class ConsultasInjetRN extends AbstractRN<DAOGenericoInjet>{

	public ConsultasInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	MaquinaInjetRN rn = new MaquinaInjetRN(getDao());

	private List<TrocaOPInjetDTO> todasAsTrocas = new ArrayList<TrocaOPInjetDTO>();
	private List<TrocaOPInjetDTO> opsProcessadas = new ArrayList<TrocaOPInjetDTO>();

	public void processarConsultas(boolean isProcessarCompleto) {
		rn.setDaoSession(getDaoSession());

		boolean isProcessarDatas = true;

		// Obtem a lista de datas e turnos a serem processados
		List<Ijreprodt> listaIjreprodt = null;

		try {
			listaIjreprodt = pesquisarListaIjreprodt();
		} catch (RegistroDesconhecidoException e) {
			// Se nao tiver datas a processar, continuar e testar se existem
			// meses a processar
			isProcessarDatas = false;
		}

		// Obter a lista de todas as maquinas a serem processadas
		List<Ijtbinj> listaIjtbinj = null;
		listaIjtbinj = rn.pesquisarListaMaquinas("ijtbinj.opatual");

		// Processa todas as ocorrencias de datas encontradas
		if (isProcessarDatas == true) {
			for (Ijreprodt ijreprodt : listaIjreprodt) {
				// Marca dtCadastro do ijreprodt com o inicio do processamento
				ijreprodt.setDtCadastro(DataHoraRN.getDataHoraAtual());
				getDaoSession().merge(ijreprodt);

				Date inicio = DataHoraRN.getDataHoraAtual();
				processarData(ijreprodt, listaIjtbinj, isProcessarCompleto);
				Date fim = DataHoraRN.getDataHoraAtual();

				if (isProcessarCompleto){
					//processarViewInjet(ijreprodt, listaIjtbinj);
					inserirMes(ijreprodt);
				}

				getDaoSession().delete(ijreprodt);

				getDao().getDao().flushReiniciandoTransacao();
			}

			if (isProcessarCompleto){
				// Processar todos os tempos de setup encontrados
				try {
					processarViewInjetTempoSetup();
				} catch (Exception e){
					getDaoSession().getTransaction().rollback();
				}
			}
		}

		if (isProcessarCompleto){
			// Processa todas as ocorrencias dos meses encontrados
			boolean isProcessarMeses = true;
			List<Ijreproms> listaIjreproms = null;
			try {
				listaIjreproms = pesquisarListaIjreproms();
			} catch (RegistroDesconhecidoException e) {
				// Se nao tiver meses a processar, continuar e testar se existem
				// anos a processar
				isProcessarMeses = false;
			}
			if (isProcessarMeses == true) {
				for (Ijreproms ijreproms : listaIjreproms) {
					processarMes(ijreproms, listaIjtbinj);
					inserirAno(ijreproms);
					getDaoSession().delete(ijreproms);
				}
			}

			// Processa todas as ocorrencias dos anos encontrados
			boolean isProcessarAnos = true;
			List<Ijreproan> listaIjreproan = null;
			try {
				listaIjreproan = pesquisarListaIjreproan();
			} catch (RegistroDesconhecidoException e) {
				// Se nao tiver meses a processar, continuar e testar se existem
				// anos a processar
				isProcessarAnos = false;
			}
			if (isProcessarAnos == true) {
				for (Ijreproan ijreproan : listaIjreproan) {
					processarAno(ijreproan, listaIjtbinj);
					getDaoSession().delete(ijreproan);
				}
			}

		}

		if (isProcessarCompleto){
			// Inclui o turno atual para ser reprocessado no proximo processamento
			DiversosInjetRN rnDiv = new DiversosInjetRN(getDao());
			rnDiv.setDaoSession(getDaoSession());
			Ijtreal ijtreal = rnDiv.pesquisarIjtreal();

			Ijreprodt incluir = new Ijreprodt();
			incluir.setDtReferencia(ijtreal.getId().getDtrefturno());
			incluir.setIjtbtur(new Ijtbtur(ijtreal.getId().getCdturno()));

			try {
				incluir = pesquisarIjreprodt(incluir);
			} catch (RegistroDesconhecidoException e1) {
				getDao().getDao().makePersistent(incluir);
			}

			CalendarioInjetRN rnCal = new CalendarioInjetRN(getDao());
			rnCal.setDaoSession(getDaoSession());

			try {
				TurnoInjetDTO turnoAnt = rnCal.getTurnoAnteriorAReferenciaFinal(ijtreal.getId().getDtrefturno(), ijtreal.getId().getCdturno());
				incluir = new Ijreprodt();
				incluir.setDtReferencia(turnoAnt.getDtReferencia());
				incluir.setIjtbtur(new Ijtbtur(turnoAnt.getIjtbtur().getCdturno()));

				try {
					incluir = pesquisarIjreprodt(incluir);
				} catch (RegistroDesconhecidoException e) {
					getDao().getDao().makePersistent(incluir);
				}

			} catch (SemCalendarioException e) {			
			}
		}
	}

	private void processarMes(Ijreproms ijreproms, List<Ijtbinj> listaIjtbinj) {
		// Obtem 1o e ultimo dia do mes a ser avaliado
		Date dtInicial = DataHoraRN.getInicioMes(ijreproms.getAno(), ijreproms.getMes());
		Date dtFinal = DataHoraRN.getFimMes(ijreproms.getAno(), ijreproms.getMes());

		// Varre a lista de maquinas
		for (Ijtbinj ijtbinj : listaIjtbinj) {
			// Obtem todos os registros de VMaqDataBI para o mes analisado,
			// maquina e turno
			String hql = "";

			hql += "from VMaqDataBi vmaqdatabi ";
			hql += "where vmaqdatabi.dtReferencia between :dataInicial and :dataFinal ";
			hql += "and vmaqdatabi.ijtbinj.cdinjetora = '::cdinjetora' ";
			hql += "and vmaqdatabi.ijtbtur.cdturno = '::cdturno' ";

			hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());
			hql = hql.replaceAll("::cdturno", ijreproms.getIjtbtur()
					.getCdturno());

			Query q = getDaoSession().createQuery(hql);
			q.setParameter("dataInicial", dtInicial);
			q.setParameter("dataFinal", dtFinal);

			List<VMaqDataBi> lista = q.list();

			if (lista != null && lista.size() > 0) {
				// Limpa os registros em VMaqMesBi para receberem novos valores
				// Nao se pode acumular, pois iria acumular valores de
				// processamnetos
				// passados
				hql = "";
				hql += "update VMaqMesBi set ";
				hql += "segTempoativo = 0";
				hql += ",segTempoparada = 0";
				hql += ",segTempoparadaSp = 0";
				hql += ",segCicloprodutivo = 0";
				hql += ",segCicloimprodutivo = 0";
				hql += ",segTempotrabalhado = 0";
				hql += ",segTemporefugadas = 0";
				hql += ",segRitmo = 0";
				hql += ",segTempoprodutivas = 0";
				hql += ",segTempodisponivel = 0";
				hql += ",segPerdaciclo = 0";
				hql += ",segCiclomedio = 0";
				hql += ",segCiclopadrao = 0";
				hql += ",pcsPerdaparada = 0";
				hql += ",pcsPerdaparadaSp = 0";
				hql += ",pcsPerdaciclo = 0";
				hql += ",pcsPerdacavidades = 0";
				hql += ",pcsProducaobruta = 0";
				hql += ",pcsProducaorefugada = 0";
				hql += ",pcsProducaoprevista = 0 ";
				hql += ",segPerdacav = 0";
				hql += ",segCtt = 0";
				hql += ",segBoas = 0";
				hql += "where anoReferencia = ::anoReferencia and mesReferencia = ::mesReferencia and ";
				hql += "cdturno = '::cdturno' and cdinjetora = '::cdinjetora' ";

				hql = hql.replaceAll("::anoReferencia", ijreproms.getAno()
						.toString());
				hql = hql.replaceAll("::mesReferencia", ijreproms.getMes()
						.toString());
				hql = hql.replaceAll("::cdturno", ijreproms.getIjtbtur()
						.getCdturno());
				hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());

				Query upd = getDaoSession().createQuery(hql);

				upd.executeUpdate();

				// Interage sobre todos os registros encontrados em VMaqDataBI
				for (VMaqDataBi vmaqdatabi : lista) {
					// Cria instancia de VMaqMesBI
					VMaqMesBi vmaqmesbi = new VMaqMesBi();
					vmaqmesbi.setAnoReferencia(ijreproms.getAno().longValue());
					vmaqmesbi.setMesReferencia(ijreproms.getMes().longValue());
					vmaqmesbi.setCdturno(ijreproms.getIjtbtur().getCdturno());
					vmaqmesbi.setCdinjetora(ijtbinj.getCdinjetora());

					try {
						vmaqmesbi = pesquisarVMaqMesBi(vmaqmesbi);
					} catch (RegistroDesconhecidoException e) {
						vmaqmesbi.setSegTempoativo(new BigDecimal(0));
						vmaqmesbi.setSegTempoparada(new BigDecimal(0));
						vmaqmesbi.setSegTempoparadaSp(new BigDecimal(0));
						vmaqmesbi.setSegCicloprodutivo(new BigDecimal(0));
						vmaqmesbi.setSegCicloimprodutivo(new BigDecimal(0));
						vmaqmesbi.setSegTempotrabalhado(new BigDecimal(0));
						vmaqmesbi.setSegTemporefugadas(new BigDecimal(0));
						vmaqmesbi.setSegRitmo(new BigDecimal(0));
						vmaqmesbi.setSegTempoprodutivas(new BigDecimal(0));
						vmaqmesbi.setSegTempodisponivel(new BigDecimal(0));
						vmaqmesbi.setSegPerdaciclo(new BigDecimal(0));
						vmaqmesbi.setSegCiclomedio(new BigDecimal(0));
						vmaqmesbi.setSegCiclopadrao(new BigDecimal(0));
						vmaqmesbi.setPcsPerdaparada(0l);
						vmaqmesbi.setPcsPerdaparadaSp(0l);
						vmaqmesbi.setPcsPerdaciclo(new BigDecimal(0));
						vmaqmesbi.setPcsPerdacavidades(0l);
						vmaqmesbi.setPcsProducaobruta(0l);
						vmaqmesbi.setPcsProducaorefugada(0l);
						vmaqmesbi.setPcsProducaoprevista(0l);
						vmaqmesbi.setSegPerdacav(new BigDecimal(0));
						vmaqmesbi.setSegCtt(new BigDecimal(0));
						vmaqmesbi.setSegBoas(new BigDecimal(0));
					}
					vmaqmesbi.addVMaqDataBi(vmaqdatabi);

					getDao().getDao().makePersistent(vmaqmesbi);
				}
			}
			// Obtem todos os registros de VMaqDataPa para o mes analisado,
			// maquina e turno
			hql = "";

			hql += "from VMaqDataPa vmaqdatapa ";
			hql += "where vmaqdatapa.dtReferencia between :dataInicial and :dataFinal ";
			hql += "and vmaqdatapa.ijtbinj.cdinjetora = '::cdinjetora' ";
			hql += "and vmaqdatapa.ijtbtur.cdturno = '::cdturno' ";

			hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());
			hql = hql.replaceAll("::cdturno", ijreproms.getIjtbtur()
					.getCdturno());

			q = getDaoSession().createQuery(hql);
			q.setParameter("dataInicial", dtInicial);
			q.setParameter("dataFinal", dtFinal);

			List<VMaqDataPa> listaVMaqDataPa = q.list();

			if (listaVMaqDataPa != null && listaVMaqDataPa.size() > 0) {
				// Limpa os valores em VMaqDataPa para que n�o sejam acumulados
				// com valores de processamentos antigos
				hql = "";
				hql += "update VMaqMesPa set ";
				hql += "segTempoparada = 0 ";
				hql += "where anoReferencia = ::anoReferencia and mesReferencia = ::mesReferencia and ";
				hql += "cdturno = '::cdturno' and cdinjetora = '::cdinjetora' ";

				hql = hql.replaceAll("::anoReferencia", ijreproms.getAno()
						.toString());
				hql = hql.replaceAll("::mesReferencia", ijreproms.getMes()
						.toString());
				hql = hql.replaceAll("::cdturno", ijreproms.getIjtbtur()
						.getCdturno());
				hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());

				Query upd = getDaoSession().createQuery(hql);

				upd.executeUpdate();

				// Interage sobre todos os registros encontrados em VMAqDataPa
				for (VMaqDataPa vmaqdatapa : listaVMaqDataPa) {
					VMaqMesPa vmaqmespa = new VMaqMesPa();
					vmaqmespa.setAnoReferencia(ijreproms.getAno().longValue());
					vmaqmespa.setMesReferencia(ijreproms.getMes().longValue());
					vmaqmespa.setCdturno(ijreproms.getIjtbtur().getCdturno());
					vmaqmespa.setCdinjetora(ijtbinj.getCdinjetora());
					vmaqmespa
					.setCdparada(vmaqdatapa.getIjtbpar().getCdparada());

					try {
						vmaqmespa = pesquisarVMaqMesPa(vmaqmespa);
					} catch (RegistroDesconhecidoException e) {
						vmaqmespa.setSegTempoparada(new BigDecimal(0));
					}
					vmaqmespa.addVMaqDataPa(vmaqdatapa);

					getDao().getDao().makePersistent(vmaqmespa);

				}
			}
			getDao().getDao().flushReiniciandoTransacao();
			// A limpeza da sessao � importante para melhoria de performance
			getDaoSession().clear();
		}
	}

	private void processarAno(Ijreproan ijreproan, List<Ijtbinj> listaIjtbinj) {
		// Varre a lista de maquinas
		for (Ijtbinj ijtbinj : listaIjtbinj) {
			// Obtem todos os registros de VMaqDataBI para o mes analisado,
			// maquina e turno
			String hql = "";

			hql += "from VMaqMesBi vmaqmesbi ";
			hql += "where vmaqmesbi.anoReferencia = ::anoReferencia ";
			hql += "and vmaqmesbi.cdinjetora = '::cdinjetora' ";
			hql += "and vmaqmesbi.cdturno = '::cdturno' ";

			hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());
			hql = hql.replaceAll("::cdturno", ijreproan.getIjtbtur()
					.getCdturno());
			hql = hql.replaceAll("::anoReferencia", ijreproan.getAno()
					.toString());

			Query q = getDaoSession().createQuery(hql);

			List<VMaqMesBi> lista = q.list();

			if (lista != null && lista.size() > 0) {
				// Limpa os registros em VMaqMesBi para receberem novos valores
				// Nao se pode acumular, pois iria acumular valores de
				// processamnetos
				// passados
				hql = "";
				hql += "update VMaqAnoBi set ";
				hql += "segTempoativo = 0";
				hql += ",segTempoparada = 0";
				hql += ",segTempoparadaSp = 0";
				hql += ",segCicloprodutivo = 0";
				hql += ",segCicloimprodutivo = 0";
				hql += ",segTempotrabalhado = 0";
				hql += ",segTemporefugadas = 0";
				hql += ",segRitmo = 0";
				hql += ",segTempoprodutivas = 0";
				hql += ",segTempodisponivel = 0";
				hql += ",segPerdaciclo = 0";
				hql += ",segCiclomedio = 0";
				hql += ",segCiclopadrao = 0";
				hql += ",pcsPerdaparada = 0";
				hql += ",pcsPerdaparadaSp = 0";
				hql += ",pcsPerdaciclo = 0";
				hql += ",pcsPerdacavidades = 0";
				hql += ",pcsProducaobruta = 0";
				hql += ",pcsProducaorefugada = 0";
				hql += ",pcsProducaoprevista = 0 ";
				hql += ",segPerdacav = 0";
				hql += ",segCtt = 0";
				hql += ",segBoas = 0";
				hql += "where anoReferencia = ::anoReferencia and ";
				hql += "cdturno = '::cdturno' and cdinjetora = '::cdinjetora' ";

				hql = hql.replaceAll("::anoReferencia", ijreproan.getAno()
						.toString());
				hql = hql.replaceAll("::cdturno", ijreproan.getIjtbtur()
						.getCdturno());
				hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());

				Query upd = getDaoSession().createQuery(hql);

				upd.executeUpdate();

				// Interage sobre todos os registros encontrados em VMaqDataBI
				for (VMaqMesBi vmaqmesbi : lista) {
					// Cria instancia de VMaqMesBI
					VMaqAnoBi vmaqanobi = new VMaqAnoBi();
					vmaqanobi.setAnoReferencia(ijreproan.getAno().longValue());
					vmaqanobi.setCdturno(ijreproan.getIjtbtur().getCdturno());
					vmaqanobi.setCdinjetora(ijtbinj.getCdinjetora());

					try {
						vmaqanobi = pesquisarVMaqAnoBi(vmaqanobi);
					} catch (RegistroDesconhecidoException e) {
						vmaqanobi.setSegTempoativo(new BigDecimal(0));
						vmaqanobi.setSegTempoparada(new BigDecimal(0));
						vmaqanobi.setSegTempoparadaSp(new BigDecimal(0));
						vmaqanobi.setSegCicloprodutivo(new BigDecimal(0));
						vmaqanobi.setSegCicloimprodutivo(new BigDecimal(0));
						vmaqanobi.setSegTempotrabalhado(new BigDecimal(0));
						vmaqanobi.setSegTemporefugadas(new BigDecimal(0));
						vmaqanobi.setSegRitmo(new BigDecimal(0));
						vmaqanobi.setSegTempoprodutivas(new BigDecimal(0));
						vmaqanobi.setSegTempodisponivel(new BigDecimal(0));
						vmaqanobi.setSegPerdaciclo(new BigDecimal(0));
						vmaqanobi.setSegCiclomedio(new BigDecimal(0));
						vmaqanobi.setSegCiclopadrao(new BigDecimal(0));
						vmaqanobi.setPcsPerdaparada(0l);
						vmaqanobi.setPcsPerdaparadaSp(0l);
						vmaqanobi.setPcsPerdaciclo(new BigDecimal(0));
						vmaqanobi.setPcsPerdacavidades(0l);
						vmaqanobi.setPcsProducaobruta(0l);
						vmaqanobi.setPcsProducaorefugada(0l);
						vmaqanobi.setPcsProducaoprevista(0l);
						vmaqanobi.setSegPerdacav(new BigDecimal(0));
						vmaqanobi.setSegCtt(new BigDecimal(0));
						vmaqanobi.setSegBoas(new BigDecimal(0));
					}
					vmaqanobi.addVMaqMesBi(vmaqmesbi);

					getDao().makePersistent(vmaqanobi);
				}
			}
			// Obtem todos os registros de VMaqMesPa para o ano analisado,
			// maquina e turno
			hql = "";

			hql += "from VMaqMesPa vmaqmespa ";
			hql += "where vmaqmespa.anoReferencia = ::anoreferencia ";
			hql += "and vmaqmespa.cdinjetora = '::cdinjetora' ";
			hql += "and vmaqmespa.cdturno = '::cdturno' ";

			hql = hql.replaceAll("::anoreferencia", ijreproan.getAno()
					.toString());
			hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());
			hql = hql.replaceAll("::cdturno", ijreproan.getIjtbtur()
					.getCdturno());

			q = getDaoSession().createQuery(hql);

			List<VMaqMesPa> listaVMaqMesPa = q.list();

			if (listaVMaqMesPa != null && listaVMaqMesPa.size() > 0) {
				// Limpa os valores em VMaqDataPa para que n�o sejam acumulados
				// com valores de processamentos antigos
				hql = "";
				hql += "update VMaqAnoPa set ";
				hql += "segTempoparada = 0 ";
				hql += "where anoReferencia = ::anoReferencia and ";
				hql += "cdturno = '::cdturno' and cdinjetora = '::cdinjetora' ";

				hql = hql.replaceAll("::anoReferencia", ijreproan.getAno()
						.toString());
				hql = hql.replaceAll("::cdturno", ijreproan.getIjtbtur()
						.getCdturno());
				hql = hql.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());

				Query upd = getDaoSession().createQuery(hql);

				upd.executeUpdate();

				// Interage sobre todos os registros encontrados em VMAqDataPa
				for (VMaqMesPa vmaqmespa : listaVMaqMesPa) {
					VMaqAnoPa vmaqanopa = new VMaqAnoPa();
					vmaqanopa.setAnoReferencia(ijreproan.getAno().longValue());
					vmaqanopa.setCdturno(ijreproan.getIjtbtur().getCdturno());
					vmaqanopa.setCdinjetora(ijtbinj.getCdinjetora());
					vmaqanopa.setCdparada(vmaqmespa.getCdparada());

					try {
						vmaqanopa = pesquisarVMaqAnoPa(vmaqanopa);
					} catch (RegistroDesconhecidoException e) {
						vmaqanopa.setSegTempoparada(new BigDecimal(0));
					}
					vmaqanopa.addVMaqMesPa(vmaqmespa);

					getDao().makePersistent(vmaqanopa);

				}
			}
			getDao().getDao().flushReiniciandoTransacao();
			// A limpeza da sessao � importante para melhoria de performance
			getDaoSession().clear();
		}
	}

	private void processarViewInjetTempoSetup() {

		// Processa os dados de tempo de setup obtidos atraves das paradas
		for (TrocaOPInjetDTO troca : this.todasAsTrocas) {
			String hql = "";
			hql += "update ViewInjet set setupReal = ::setupReal, setupPadrao = ::setupPadrao ";
			hql += "where codMaquina = '::cdMaquina' and op = '::nrop' ";

			hql = hql.replaceAll("::nrop", troca.getNropEntrando());
			hql = hql.replaceAll("::cdMaquina", troca.getCdMaquina());
			hql = hql.replaceAll("::setupPadrao", troca.getTempoPlanejadoSetup().toString());
			hql = hql.replaceAll("::setupReal", troca.getTempoRealSetup()
					.toString());

			Query q = getDaoSession().createQuery(hql);

			q.executeUpdate();
		}

		// Processa os dados de tempo de setup obtidos atraves de Ijctrliniproc
		for (TrocaOPInjetDTO troca : this.opsProcessadas){

			// Encontra setup real e planejado
			String hql = "";
			hql += "from IjctrlIniproc a ";
			hql += "join fetch a.ijctrlIniproctrocas b ";
			hql += "where a.ijtbinj.cdinjetora = '::cdinjetora' ";
			hql += "and a.ijop.nrop = '::nrop' ";

			hql = hql.replaceAll("::cdinjetora", troca.getCdMaquina());
			hql = hql.replaceAll("::nrop", troca.getNropEntrando());

			Query q = getDaoSession().createQuery(hql);

			List<Ijctrliniproc> lista = (List<Ijctrliniproc>) q.list();

			if (lista.size() <= 0)
				continue;

			BigDecimal tempoSetupReal = new BigDecimal(0);
			BigDecimal tempoSetupPlanejado = new BigDecimal(0);

			for (Ijctrliniproc reg : lista){
				BigDecimal tempoSetupRealIjctrlIniproc = new BigDecimal(DataHoraRN.amountOfSecondsInPeriod(
						reg.getDthrinictrliniproc(), reg.getDthrfimctrliniproc()));

				if (tempoSetupRealIjctrlIniproc.floatValue() > 0f)
					tempoSetupReal = tempoSetupReal.add(tempoSetupRealIjctrlIniproc);


				// Se nao houver registros em Trocas entao nao precisa pegar o tempo de setup padrao
				if (reg.getIjctrliniproctrocas().size() <= 0)
					continue;

				// Para cada registro (a principio sempre sera apenas 1 reg) encontra o  tempo de setup padrao
				hql = "";

				hql += "from IjmatrizSetup ijmatrizsetup ";
				hql += "where ijmatrizsetup.id.cdinjetora = '::cdinjetora' ";
				hql += "and ijmatrizsetup.id.cdMoldeSai = '::cdmoldesai' ";
				hql += "and ijmatrizsetup.id.cdMoldeEntra = '::cdmoldeentra' ";

				hql = hql.replaceAll("::cdinjetora", troca.getCdMaquina());
				for (Ijctrliniproctroca regTroca : reg.getIjctrliniproctrocas()){
					if (regTroca.getIjestmolBySysC0013002() == null)
						continue;
					hql = hql.replaceAll("::cdmoldesai", regTroca.getIjestmolBySysC0013002().getId().getCdmolde());
					hql = hql.replaceAll("::cdmoldeentra", regTroca.getIjestmolBySysC0013001().getId().getCdmolde());
				}

				q = getDaoSession().createQuery(hql);

				List<Ijmatrizsetup> listaIjmatrizsetup = (List<Ijmatrizsetup>) q.list();

				for (Ijmatrizsetup ijmatrizsetup : listaIjmatrizsetup){
					tempoSetupPlanejado = tempoSetupPlanejado.add(new BigDecimal(ijmatrizsetup.getTemposetup()));
				}
			}




			// Atualiza viewInjet se setupReal estiver com valor
			if (tempoSetupReal.floatValue() > 0f){
				// Transforma os tempos para hora
				tempoSetupPlanejado = tempoSetupPlanejado.divide(new BigDecimal(3600), 5, BigDecimal.ROUND_HALF_EVEN);
				tempoSetupReal = tempoSetupReal.divide(new BigDecimal(3600), 5, BigDecimal.ROUND_HALF_EVEN);

				hql = "";
				hql += "update ViewInjet set setupReal = ::setupReal, setupPadrao = ::setupPadrao ";
				hql += "where codMaquina = '::cdMaquina' and op = '::nrop' ";

				hql = hql.replaceAll("::nrop", troca.getNropEntrando());
				hql = hql.replaceAll("::cdMaquina", troca.getIjtbinj().getCdinjestendido());
				hql = hql.replaceAll("::setupPadrao", tempoSetupPlanejado.toString());
				hql = hql.replaceAll("::setupReal", tempoSetupReal.toString());

//				//System.out.println(hql);
				q = getDaoSession().createQuery(hql);

				q.executeUpdate();
				
			}
		}
		getDao().getDao().flushReiniciandoTransacao();
	}

	private void processarViewInjet(Ijreprodt ijreprodt,
			List<Ijtbinj> listaIjtbinj) {

		// Obter a relacao das OPs conforme filtro acima
		PlanejamentoInjetRN rnPlanejamento = new PlanejamentoInjetRN(getDao());
		rnPlanejamento.setDaoSession(getDaoSession());

		// Interage pela lista de maquinas
		for (Ijtbinj ijtbinj : listaIjtbinj) {
			// Processa a lista de galpoes
			FiltroMaquinaInjetDTO filtroMaquina = new FiltroMaquinaInjetDTO();
			filtroMaquina.setCdMaquina(ijtbinj.getCdinjetora());
			filtroMaquina.setCdTurno(ijreprodt.getIjtbtur().getCdturno());
			filtroMaquina.setData(DataHoraRN.normalize(ijreprodt
					.getDtReferencia(), DataHoraRN._DAY));
			filtroMaquina.setDtFinal(filtroMaquina.getData());

			List<Ijop> listaIjop = rnPlanejamento.pesquisarListaIjop(filtroMaquina);

			for (Ijop ijop : listaIjop) {
				filtroMaquina.setNrop(ijop.getNrop());

				// Obter a lista de produtos em ijopprodutos
				List<Ijopprodutos> listaIjopprodutos = rnPlanejamento.pesquisarIjopprodutos(ijop);

				for (Ijopprodutos ijopprodutos : listaIjopprodutos) {
					Ijtbpro ijtbpro = ijopprodutos.getIjtbpro();

					filtroMaquina.setCdProduto(ijtbpro.getCdproduto());
					filtroMaquina.setObterParadasPorMotivo(true);
					filtroMaquina.setIsProcessarDetalheMaquina(true);
					filtroMaquina.setIsObterRelacaoProdutos(true);
					filtroMaquina.setIsObterGruposDaMaquina(true);
					filtroMaquina.setIsObterTemposDeSetupDasOPs(true);

					// Atualizar informacoes da maquina
					MaquinaInjetDTO maquinaDTO = null;

					try {
						maquinaDTO = rn.analisarMaquina(filtroMaquina);
					} catch (Exception e) {
						e.printStackTrace();
					}

					ViewInjet r = new ViewInjet();

					r.setData(filtroMaquina.getData());
					r.setTurno(ijreprodt.getIjtbtur().getCdturno());
					r.setCodMaquina(ijtbinj.getCdinjestendido());
					r.setOp(ijop.getNrop());
					r.setOpintegracao(rnPlanejamento.obtemOPDaSulbras(ijop.getNrop(), ijtbpro.getCdproduto()));
					r.setItem(ijtbpro.getCdproduto());
					r.setCodOperacaoParada("0");

					try {
						r = pesquisarViewInjet(r);
					} catch (RegistroDesconhecidoException e2) {
					}

					// Obtem cliente da OP
					Ijtbcli ijtbcli = rnPlanejamento.pesquisarIjtbcli(ijop);

					r.setCliente(ijtbcli.getDscliente());
					try {
						r.setCodOperador(maquinaDTO.getOperadorPrincipalTurno().getIjtbusu().getCdusuario());
					} catch (idw.model.excessoes.RegistroDesconhecidoException e1) {
						r.setCodOperador("-");
					} catch (NullPointerException e) {
						r.setCodOperador("-");
					}
					r.setDescricaoFilial("Matriz Caxias do Sul");
					r.setDescricaoMaquina(ijtbinj.getCdidentific());
					r.setDescricaoOperacao("Produ��o normal");
					r.setDescricaoProduto(ijtbpro.getDsproduto());
					r.setDiaSemana(DataHoraRN.getWeekDay(filtroMaquina
							.getData()));
					r.setFilial("1");
					r.setInicioturno(maquinaDTO.getDthrITurno());
					r.setFimturno(maquinaDTO.getDthrFTurno());
					r.setGrupoMaquina(ijtbinj.getTonelagem());
					r.setMes(DataHoraRN.getMes(filtroMaquina.getData()));
					r.setMoldeFerramenta(ijopprodutos.getIjestmol().getId()
							.getCdmolde());
					try {
						r.setNomeOperador(maquinaDTO.getOperadorPrincipalTurno().getIjtbusu().getNmusuario());
					} catch (idw.model.excessoes.RegistroDesconhecidoException e1) {
						r.setNomeOperador("-");
					} catch (NullPointerException e) {
						r.setNomeOperador("-");
					}
					r.setPeriodoTurno(maquinaDTO.getPeriodoTurno());
					try {
						r.setNcavBoas(maquinaDTO.getProduto(
								ijtbpro.getCdproduto()).getQtcavativas()
								.longValue());
					} catch (NullPointerException e) {
						r.setNcavBoas(1l);
					}
					try {
						r.setNcavTotal(maquinaDTO.getProduto(
								ijtbpro.getCdproduto()).getQtcavidades()
								.longValue());
					} catch (NullPointerException e) {
						r.setNcavTotal(1l);
					}
					// r.setTempoOperacao(new
					// BigDecimal(maquinaDTO.getMaquinaTotalDTO().getTempoCicloProdutivoComCTTHorasFormatado()));
					r.setTempoOperacao(new BigDecimal(maquinaDTO
							.getMaquinaTotalDTO().getTempoTrabalhadoHoras() / (float)listaIjopprodutos.size()));
					r.setCicloPadrao(maquinaDTO.getMaquinaTotalDTO()
							.getCicloPadrao().longValue());
					if (maquinaDTO.getMaquinaTotalDTO()
							.getCicloPadraoIndenpendenteCicloMedio()
							.floatValue() > 0f)
						r.setCicloEstHora((long) (3600f / maquinaDTO
								.getMaquinaTotalDTO()
								.getCicloPadraoIndenpendenteCicloMedio()
								.floatValue()));
					else
						r.setCicloEstHora(0l);
					try {
						r.setCicloEstTotal(r.getTempoOperacao().multiply(new BigDecimal(r.getCicloEstHora())).longValue());
					} catch (Exception e) {
						e.printStackTrace();
					}
					r.setNpecasEst1(r.getNcavTotal().longValue()
							* r.getCicloEstTotal());
					r.setTotPecasEstCod23(r.getNpecasEst1());
					r.setTotTempoCod231(r.getTempoOperacao());
					try {
						r.setTotCiclosRealizados(maquinaDTO.getMaquinaTotalDTO()
								.getQtInjNormal().longValue());
					} catch (Exception e){
						r.setTotCiclosRealizados(0l);
					}
					if (r.getTempoOperacao().longValue() > 0)
						r.setTotCiclosRealizadosHora(r.getTotCiclosRealizados()
								.longValue()
								/ r.getTempoOperacao().longValue());
					else
						r.setTotCiclosRealizadosHora(0l);
					r.setTotPecasEst2(r.getTotCiclosRealizados()
							* r.getNcavBoas());

					r.setTotalPecasProduzidas(maquinaDTO.getMaquinaTotalDTO()
							.getProducaoBrutaUnidade().longValue());
					r.setTotalPecasBoasProduzidas(maquinaDTO
							.getMaquinaTotalDTO().getProducaoLiquidaUnidade()
							.longValue());
					r.setTotalPecasNproduzidas(maquinaDTO.getMaquinaTotalDTO()
							.getPerdaTotalUnidade().longValue());
					r.setProducaoRefugada(r.getTotalPecasProduzidas()
							- r.getTotalPecasBoasProduzidas());
					// TODO verificar
					// maquinaDTO.getMaquinaTotalDTO().getProducaoRefugadaUnidade().longValue());

					r.setTotTempoCod232(new BigDecimal((r
							.getTotalPecasProduzidas().floatValue() / r
							.getNcavTotal().floatValue())
							* (r.getCicloPadrao().floatValue() / 3600f)));
					r.setPecasRejeiCod23(r.getProducaoRefugada());
					r.setTempoRejeitaCod23(new BigDecimal(maquinaDTO
							.getMaquinaTotalDTO()
							.getTempoRefugoHorasFormatado()));
					r.setTotalTempoPecasNproduzidas(new BigDecimal(maquinaDTO
							.getMaquinaTotalDTO()
							.getPerdaTotalTempoHorasFormatado()));
					r.setTotalTempoPecasBoasCod233(new BigDecimal(maquinaDTO
							.getMaquinaTotalDTO()
							.getTempoBoasHorasFormatado()));
					if (r.getTotalPecasBoasProduzidas() > 0)
						r.setProducaoLiquida(new BigDecimal(
								(r.getTotalPecasBoasProduzidas()
										.floatValue() / r
										.getTotalPecasProduzidas()
										.floatValue()) * 100f));
					else
						r.setProducaoLiquida(new BigDecimal(0));

					if (r.getCicloEstTotal() > 0)
						r.setProdutividadeNoPeriodo(new BigDecimal((r
								.getTotCiclosRealizados().floatValue() / r
								.getCicloEstTotal().floatValue()) * 100f));
					else
						r.setProdutividadeNoPeriodo(new BigDecimal(0));
					r.setOrigemParada("");
					try {
						r.setSubUnidade(maquinaDTO.getPrincipalGrupoDaMaquina().getDsgrpinj());
					} catch (idw.model.excessoes.RegistroDesconhecidoException e1) {
						r.setSubUnidade("-");
					}

					// inserir as trocas encontradas na lista atual
					this.todasAsTrocas.addAll(maquinaDTO.getTrocasDeOP());

					TrocaOPInjetDTO troca = new TrocaOPInjetDTO();
					troca.setCdMaquina(maquinaDTO.getIjtbinj().getCdinjetora());
					troca.setIjtbinj(maquinaDTO.getIjtbinj());
					troca.setNropEntrando(r.getOp());
					this.opsProcessadas.add(troca);

					// pegar da lista com todas as trocas
					// TrocaOP troca = pesquisarTrocaOP(r.getOp());
					// r.setSetupPadrao(troca.getTempoPlanejadoSetup());
					// r.setSetupReal(troca.getTempoRealSetup());
					r.setSetupPadrao(new BigDecimal(0));
					r.setSetupReal(new BigDecimal(0));
					r.setHoraHomem(maquinaDTO.getHorasHomem(r.getTempoOperacao()));

					try {
						getDao().makePersistent(r);
					} catch (Exception e) {
						e.printStackTrace();
					}
					getDao().getDao().flushReiniciandoTransacao();

					// Insere as ocorrencias das paradas
					for (ParadaInjetDTO paradaDTO : maquinaDTO.getParadas()) {
						ViewInjet rp = new ViewInjet();

						rp.setData(filtroMaquina.getData());
						rp.setTurno(ijreprodt.getIjtbtur().getCdturno());
						rp.setCodMaquina(ijtbinj.getCdinjestendido());
						rp.setOp(r.getOp());
						rp.setOpintegracao(r.getOpintegracao());
						rp.setItem("-");
						rp.setCodOperacaoParada(paradaDTO.getCdParada());
						try {
							rp = pesquisarViewInjet(rp);
						} catch (RegistroDesconhecidoException e2) {
						}

						rp.setCliente(r.getCliente());
						rp.setCodOperador(r.getCodOperador());
						rp.setDescricaoFilial("Matriz Caxias do Sul");
						rp.setDescricaoMaquina(ijtbinj.getCdidentific());
						rp.setDescricaoOperacao(paradaDTO.getDsParada());
						rp.setDescricaoProduto(ijtbpro.getDsproduto());
						rp.setDiaSemana(DataHoraRN
								.getWeekDay(filtroMaquina.getData()));
						rp.setFilial("1");
						rp.setGrupoMaquina(r.getGrupoMaquina());
						rp.setMes(DataHoraRN.getMes(filtroMaquina
								.getData()));
						rp.setMoldeFerramenta(ijopprodutos.getIjestmol()
								.getId().getCdmolde());
						rp.setNomeOperador(r.getNomeOperador());
						rp.setPeriodoTurno(maquinaDTO.getPeriodoTurno());
						try {
							rp.setNcavBoas(maquinaDTO.getProduto(
									ijtbpro.getCdproduto()).getQtcavativas()
									.longValue());
						} catch (NullPointerException e) {
							rp.setNcavBoas(1l);
						}
						try {
							rp.setNcavTotal(maquinaDTO.getProduto(
									ijtbpro.getCdproduto()).getQtcavidades()
									.longValue());
						} catch (NullPointerException e) {
							rp.setNcavTotal(1l);
						}
						rp.setTempoOperacao(new BigDecimal(paradaDTO
								.getTempoParadaHoras()));
						rp.setProducaoRefugada(0l);
						rp.setCicloPadrao(maquinaDTO.getMaquinaTotalDTO()
								.getCicloPadrao().longValue());
						if (maquinaDTO.getMaquinaTotalDTO().getCicloPadrao()
								.floatValue() > 0f)

							rp.setCicloEstHora((long) (3600f / maquinaDTO
									.getMaquinaTotalDTO().getCicloPadrao()
									.floatValue()));
						else
							rp.setCicloEstHora(0l);

						try {
							rp.setCicloEstTotal(rp.getTempoOperacao().multiply(new BigDecimal(rp.getCicloEstHora())).longValue());
						} catch (Exception e) {
							e.printStackTrace();
						}
						rp.setInicioturno(maquinaDTO.getDthrITurno());
						rp.setFimturno(maquinaDTO.getDthrFTurno());

						rp.setNpecasEst1(rp.getNcavTotal().longValue()
								* rp.getCicloEstTotal());
						rp.setTotPecasEstCod23(rp.getNpecasEst1());
						rp.setTotTempoCod231(new BigDecimal(0));
						// TotCiclosRealizados qdo for uma parada deve ser 0
						rp.setTotCiclosRealizados(0l);
						rp.setTotCiclosRealizadosHora(0l);

						rp.setTotPecasEst2(rp.getTotCiclosRealizados()
								* rp.getNcavBoas());
						rp.setTotalPecasProduzidas(0l);
						rp.setTotalPecasBoasProduzidas(0l);

						rp.setTotalPecasNproduzidas(0l);

						rp.setTotTempoCod232(new BigDecimal((rp
								.getTotalPecasProduzidas().floatValue() / rp
								.getNcavTotal().floatValue())
								* (rp.getCicloPadrao() / 3600f)));
						rp.setPecasRejeiCod23(rp.getProducaoRefugada());
						rp.setTempoRejeitaCod23(new BigDecimal(maquinaDTO
								.getMaquinaTotalDTO()
								.getTempoRefugoHorasFormatado()));
						rp.setTotalTempoPecasNproduzidas(new BigDecimal(0));
						rp.setTotalTempoPecasBoasCod233(new BigDecimal(0));
						if (rp.getTotalPecasBoasProduzidas() > 0)
							rp.setProducaoLiquida(new BigDecimal(
									(rp.getTotalPecasBoasProduzidas()
											.floatValue() / rp
											.getTotalPecasProduzidas()
											.floatValue()) * 100f));
						else
							rp.setProducaoLiquida(new BigDecimal(0));

						if (rp.getCicloEstTotal() > 0)
							rp.setProdutividadeNoPeriodo(new BigDecimal((rp
									.getTotCiclosRealizados().floatValue() / rp
									.getCicloEstTotal().floatValue()) * 100f));
						else
							rp.setProdutividadeNoPeriodo(new BigDecimal(0));
						rp.setOrigemParada(paradaDTO.getDsAreaResponsavel());
						try {
							rp
							.setSubUnidade(maquinaDTO.getPrincipalGrupoDaMaquina().getDsgrpinj());
						} catch (idw.model.excessoes.RegistroDesconhecidoException e1) {
							rp.setSubUnidade("-");
						}
						// rp.setSetupPadrao(r.getSetupPadrao());
						// rp.setSetupReal(r.getSetupReal());
						rp.setSetupPadrao(new BigDecimal(0));
						rp.setSetupReal(new BigDecimal(0));

						rp.setHoraHomem(new BigDecimal(0));

						getDao().makePersistent(rp);
					}

					getDao().flushReiniciandoTransacao();

					// Aqui insere a ineficiencia ou eficiencia de ciclo
					ViewInjet rpc = new ViewInjet();

					rpc.setData(filtroMaquina.getData());
					rpc.setTurno(ijreprodt.getIjtbtur().getCdturno());
					rpc.setCodMaquina(ijtbinj.getCdinjestendido());
					rpc.setOp(r.getOp());
					rpc.setOpintegracao(r.getOpintegracao());
					rpc.setItem("-");
					rpc.setCodOperacaoParada("-1");
					try {
						rpc = pesquisarViewInjet(rpc);
					} catch (RegistroDesconhecidoException e2) {
					}

					rpc.setCliente(r.getCliente());
					rpc.setCodOperador(r.getCodOperador());
					rpc.setDescricaoFilial("Matriz Caxias do Sul");
					rpc.setDescricaoMaquina(ijtbinj.getCdidentific());
					rpc.setDescricaoOperacao("Inefici�ncia de ciclo");
					rpc.setDescricaoProduto(ijtbpro.getDsproduto());
					rpc.setDiaSemana(DataHoraRN.getWeekDay(filtroMaquina
							.getData()));
					rpc.setFilial("1");
					rpc.setGrupoMaquina(r.getGrupoMaquina());
					rpc.setMes(DataHoraRN
							.getMes(filtroMaquina.getData()));
					rpc.setMoldeFerramenta(ijopprodutos.getIjestmol().getId()
							.getCdmolde());
					rpc.setNomeOperador(r.getNomeOperador());
					rpc.setPeriodoTurno(maquinaDTO.getPeriodoTurno());
					rpc.setInicioturno(maquinaDTO.getDthrITurno());
					rpc.setFimturno(maquinaDTO.getDthrFTurno());

					try {
						rpc.setNcavBoas(maquinaDTO.getProduto(
								ijtbpro.getCdproduto()).getQtcavativas()
								.longValue());
					} catch (Exception e) {
						rpc.setNcavBoas(1l);
					}
					try {
						rpc.setNcavTotal(maquinaDTO.getProduto(
								ijtbpro.getCdproduto()).getQtcavidades()
								.longValue());
					} catch (NullPointerException e) {
						rpc.setNcavTotal(1l);
					}
					rpc.setTempoOperacao(
							maquinaDTO.getMaquinaTotalDTO().getTempoRitmoSegundos().divide(new BigDecimal(3600), 5, BigDecimal.ROUND_HALF_EVEN));
					rpc.setProducaoRefugada(0l);
					rpc.setCicloPadrao(maquinaDTO.getMaquinaTotalDTO()
							.getCicloPadrao().longValue());
					if (maquinaDTO.getMaquinaTotalDTO().getCicloPadrao()
							.floatValue() > 0f)
						rpc.setCicloEstHora((long) (3600f / maquinaDTO
								.getMaquinaTotalDTO().getCicloPadrao()
								.floatValue()));
					else
						rpc.setCicloEstHora(0l);
					try {
						rpc.setCicloEstTotal(rpc.getTempoOperacao().multiply(new BigDecimal(rpc.getCicloEstHora())).longValue());
					} catch (Exception e) {
						e.printStackTrace();
					}
					rpc.setNpecasEst1(rpc.getNcavTotal().longValue()
							* rpc.getCicloEstTotal());
					rpc.setTotPecasEstCod23(rpc.getNpecasEst1());
					rpc.setTotTempoCod231(rpc.getTempoOperacao());
					rpc.setTotCiclosRealizados(0l);
					if (rpc.getTempoOperacao().longValue() > 0)
						rpc.setTotCiclosRealizadosHora(rpc
								.getTotCiclosRealizados().longValue()
								/ rpc.getTempoOperacao().longValue());
					else
						rpc.setTotCiclosRealizadosHora(0l);
					rpc.setTotPecasEst2(rpc.getTotCiclosRealizados()
							* rpc.getNcavBoas());

					rpc.setTotalPecasProduzidas(maquinaDTO.getMaquinaTotalDTO()
							.getPerdaCicloUnidade().longValue());
					rpc.setTotalPecasBoasProduzidas(0l);
					rpc.setTotalPecasNproduzidas(0l);

					rpc.setTotTempoCod232(new BigDecimal((rpc
							.getTotalPecasProduzidas().floatValue() / rpc
							.getNcavTotal().floatValue())
							* (rpc.getCicloPadrao().floatValue() / 3600f)));
					rpc.setPecasRejeiCod23(rpc.getProducaoRefugada());
					rpc.setTempoRejeitaCod23(new BigDecimal(maquinaDTO
							.getMaquinaTotalDTO()
							.getTempoRefugoHorasFormatado()));
					rpc.setTotalTempoPecasNproduzidas(new BigDecimal(0));
					rpc.setTotalTempoPecasBoasCod233(new BigDecimal(maquinaDTO
							.getMaquinaTotalDTO()
							.getTempoCicloProdutivoHorasFormatado()));
					if (rpc.getTotalPecasBoasProduzidas() > 0)
						rpc
						.setProducaoLiquida(new BigDecimal(
								(rpc.getTotalPecasBoasProduzidas()
										.floatValue() / rpc
										.getTotalPecasProduzidas()
										.floatValue()) * 100f));
					else
						rpc.setProducaoLiquida(new BigDecimal(0));
					if (rpc.getCicloEstTotal() > 0)
						rpc.setProdutividadeNoPeriodo(new BigDecimal((rpc
								.getTotCiclosRealizados().floatValue() / rpc
								.getCicloEstTotal().floatValue()) * 100f));
					else
						rpc.setProdutividadeNoPeriodo(new BigDecimal(0));
					rpc.setOrigemParada("-");
					try {
						rpc.setSubUnidade(maquinaDTO
								.getPrincipalGrupoDaMaquina().getDsgrpinj());
					} catch (RegistroDesconhecidoException e1) {
						rpc.setSubUnidade("-");
					}
					// rpc.setSetupPadrao(r.getSetupPadrao());
					// rpc.setSetupReal(r.getSetupReal());
					rpc.setSetupPadrao(new BigDecimal(0));
					rpc.setSetupReal(new BigDecimal(0));

					rpc.setHoraHomem(new BigDecimal(0));

					try {
						getDao().makePersistent(rpc);
						getDao().flushReiniciandoTransacao();
					} catch (Exception e){
						e.printStackTrace();
						//System.out.println("cliente " + rpc.getCliente());
						//System.out.println("getCodMaquina " + rpc.getCodMaquina());
						//System.out.println("getCodOperacaoParada " + rpc.getCodOperacaoParada());
						//System.out.println("getCodOperador " + rpc.getCodOperador());
						//System.out.println("getDescricaoFilial " + rpc.getDescricaoFilial());
						//System.out.println("getDescricaoMaquina " + rpc.getDescricaoMaquina());
						//System.out.println("getDescricaoOperacao " + rpc.getDescricaoOperacao());
						//System.out.println("getDescricaoProduto " + rpc.getDescricaoProduto());
						//System.out.println("getFilial " + rpc.getFilial());
						//System.out.println("getGrupoMaquina " + rpc.getGrupoMaquina());
						//System.out.println("getItem " + rpc.getItem());
						//System.out.println("getMoldeFerramenta " + rpc.getMoldeFerramenta());
						//System.out.println("getNomeOperador " + rpc.getNomeOperador());
						//System.out.println("getOp " + rpc.getOp());
						//System.out.println("getOpintegracao " + rpc.getOpintegracao());
						//System.out.println("getOrigemParada " + rpc.getOrigemParada());
						//System.out.println("getPeriodoTurno " + rpc.getPeriodoTurno());
						//System.out.println("getSubUnidade " + rpc.getSubUnidade());
						//System.out.println("getTurno " + rpc.getTurno());
						//System.out.println("getCicloEstHora " + rpc.getCicloEstHora());
						//System.out.println("getCicloEstTotal " + rpc.getCicloEstTotal());
						//System.out.println("getCicloPadrao " + rpc.getCicloPadrao());
						//System.out.println("getData " + rpc.getData());
						//System.out.println("getDiaSemana " + rpc.getDiaSemana());
						//System.out.println("getFimturno " + rpc.getFimturno());
						//System.out.println("getHoraHomem " + rpc.getHoraHomem());
						//System.out.println("getInicioturno " + rpc.getInicioturno());
						//System.out.println("getMes " + rpc.getMes());
						//System.out.println("getNcavBoas " + rpc.getNcavBoas());
						//System.out.println("getNcavTotal " + rpc.getNcavTotal());
						//System.out.println("getNpecasEst1 " + rpc.getNpecasEst1());
						//System.out.println("getPecasRejeiCod23 " + rpc.getPecasRejeiCod23());
						//System.out.println("getProducaoLiquida " + rpc.getProducaoLiquida());
						//System.out.println("getProducaoRefugada " + rpc.getProducaoRefugada());
						//System.out.println("getProdutividadeNoPeriodo " + rpc.getProdutividadeNoPeriodo());
						//System.out.println("getSetupPadrao " + rpc.getSetupPadrao());
						//System.out.println("getSetupReal " + rpc.getSetupReal());
						//System.out.println("getTempoOperacao " + rpc.getTempoOperacao());
						//System.out.println("getTempoRejeitaCod23 " + rpc.getTempoRejeitaCod23());
						//System.out.println("getTotalPecasBoasProduzidas " + rpc.getTotalPecasBoasProduzidas());
						//System.out.println("getTotalPecasNproduzidas " + rpc.getTotalPecasNproduzidas());
						//System.out.println("getTotalPecasProduzidas " + rpc.getTotalPecasProduzidas());
						//System.out.println("getTotalTempoPecasBoasCod233 " + rpc.getTotalTempoPecasBoasCod233());
						//System.out.println("getTotalTempoPecasNproduzidas " + rpc.getTotalTempoPecasNproduzidas());
						//System.out.println("getTotCiclosRealizados " + rpc.getTotCiclosRealizados());
						//System.out.println("getTotCiclosRealizadosHora " + rpc.getTotCiclosRealizadosHora());
						//System.out.println("getTotPecasEst2 " + rpc.getTotPecasEst2());
						//System.out.println("getTotPecasEstCod23 " + rpc.getTotPecasEstCod23());
						//System.out.println("getTotTempoCod231 " + rpc.getTotTempoCod231());
						//System.out.println("getTotTempoCod232 " + rpc.getTotTempoCod232());
					}

					// A limpeza da sessao � importante para melhoria de
					// performance
					getDaoSession().clear();
				}
			}
		}
	}

	private void processarData(Ijreprodt ijreprodt, List<Ijtbinj> listaIjtbinj, boolean isProcessarCompleto) {

		// Interage pela lista de maquinas
		for (Ijtbinj ijtbinj : listaIjtbinj) {
			if (isProcessarCompleto == false && ijtbinj.getStinjetora().equals("1")) // destivada
				continue;

			// Processa a lista de galpoes
			FiltroMaquinaInjetDTO filtroMaquina = new FiltroMaquinaInjetDTO();
			filtroMaquina.setIjtbinj(ijtbinj);
			filtroMaquina.setCdMaquina(ijtbinj.getCdinjetora());
			filtroMaquina.setCdTurno(ijreprodt.getIjtbtur().getCdturno());
			filtroMaquina.setData(DataHoraRN.normalize(ijreprodt
					.getDtReferencia(), DataHoraRN._DAY));
			filtroMaquina.setDtFinal(filtroMaquina.getData());
			filtroMaquina.setIsProcessarCompleto(false);

			filtroMaquina.setObterParadasPorMotivo(true);

			// Atualizar informacoes da maquina
			MaquinaInjetDTO maquinaDTO = null;

			Date inicio = DataHoraRN.getDataHoraAtual();
			try {
				maquinaDTO = rn.analisarMaquina(filtroMaquina);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			Date fim = DataHoraRN.getDataHoraAtual();

			VMaqDataBi r = null;

			// Verificar se existe o registro
			try {
				r = pesquisarVMaqDataBi(filtroMaquina.getData(), ijreprodt
						.getIjtbtur().getCdturno(), ijtbinj.getCdinjetora());
			} catch (RegistroDesconhecidoException e) {
				r = new VMaqDataBi();
				r.setDtReferencia(filtroMaquina.getData());
				r.setIjtbtur(ijreprodt.getIjtbtur());
				r.setIjtbinj(ijtbinj);

				r.setSegCicloimprodutivo(new BigDecimal(0));
				r.setSegCiclomedio(new BigDecimal(0));
				r.setSegCicloprodutivo(new BigDecimal(0));
				r.setSegPerdaciclo(new BigDecimal(0));
				r.setSegRitmo(new BigDecimal(0));
				r.setSegTempoativo(new BigDecimal(0));
				r.setSegTempodisponivel(new BigDecimal(0));
				r.setSegTempoparada(new BigDecimal(0));
				r.setSegTempoparadaSp(new BigDecimal(0));
				r.setSegTempoprodutivas(new BigDecimal(0));
				r.setSegTemporefugadas(new BigDecimal(0));
				r.setSegTempotrabalhado(new BigDecimal(0));

			}
			r.setDsMaquina(maquinaDTO.getDsMaquina());
			r.setDsTurno(ijreprodt.getIjtbtur().getDsturno());
			r.setDthrFimturno(maquinaDTO.getDthrFTurno());
			r.setDthrInicioturno(maquinaDTO.getDthrITurno());
			r.setIndEficiencia(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getEficienciaFormatada()));
			r.setIndEficienciaciclo(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getEficienciaCiclo()));
			r.setIndEficienciarealizacao(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getEficienciaRealizacao()));
			r.setIndIndiceparada(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getIndiceParada()));
			r.setIndIndiceperda(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getIndicePerda()));
			r.setIndIndicerefugo(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getIndiceRefugo()));
			r.setIndOee(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getOee()));
			r.setIndOeecapital(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getOeeCapital()));
			r.setIndTempocicloprodutivo(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getIndiceTempoCicloProdutivo()));
			r.setIndTempoproducaobruta(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getIndiceTempoProducaoBruta()));
			r.setIndTempoproducaoliquida(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getIndiceTempoProducaoLiquida()));
			r.setIndTemporefugo(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getIndiceTempoRefugo()));
			r.setIndUtilizacao(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getUtilizacao()));
			r.setPcsPerdacavidades(maquinaDTO.getMaquinaTotalDTO()
					.getPerdaCavidadeUnidade().longValue());
			r.setPcsPerdaciclo(maquinaDTO.getMaquinaTotalDTO()
					.getPerdaCicloUnidade());
			r.setPcsPerdaparada(maquinaDTO.getMaquinaTotalDTO()
					.getPerdaParadasUnidade().longValue());
			r.setPcsPerdaparadaSp(maquinaDTO.getMaquinaTotalDTO()
					.getPerdaParadasSemPesoUnidade().longValue());
			r.setPcsProducaobruta(maquinaDTO.getMaquinaTotalDTO()
					.getProducaoBrutaUnidade().longValue());
			r.setPcsProducaoprevista(maquinaDTO.getMaquinaTotalDTO()
					.getProducaoPrevistaUnidade().longValue());
			r.setPcsProducaorefugada(maquinaDTO.getMaquinaTotalDTO()
					.getProducaoRefugadaUnidade().longValue());

			r.setSegCicloimprodutivo(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getTempoCicloImprodutivoSegundos()
					.toPlainString()));
			r.setSegCiclomedio(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getCicloMedio().toPlainString()));
			r.setSegCicloprodutivo(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getTempoCicloProdutivoSegundos()
					.toPlainString()));
			r.setSegPerdaciclo(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getTempoPerdaCicloSegundos().toPlainString()));
			r.setSegRitmo(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getTempoRitmoSegundos().toPlainString()));
			r.setSegTempoativo(new BigDecimal(maquinaDTO.getMaquinaTotalDTO()
					.getTempoAtivoSegundos().toPlainString()));
			r.setSegTempodisponivel(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getTempoDisponiveisSegundos()
					.toPlainString()));
			r.setSegTempoparada(new BigDecimal(maquinaDTO.getMaquinaTotalDTO().getTempoParadaSegundos().toPlainString()));
			r.setSegTempoparadaSp(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getTempoParadaSemPesoSegundos()
					.toPlainString()));
			r.setSegTempoprodutivas(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getTempoProdutivasSegundos()
					.toPlainString()));
			r.setSegTemporefugadas(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getTempoRefugoSegundos()
					.toPlainString()));
			r.setSegTempotrabalhado(new BigDecimal(maquinaDTO
					.getMaquinaTotalDTO().getTempoTrabalhadoSegundos()
					.toPlainString()));

			r.setSegPerdacav(maquinaDTO.getMaquinaTotalDTO().getTempoPerdaCavidadeSegundos().divide(new BigDecimal(1), 5, BigDecimal.ROUND_HALF_EVEN));
			r.setSegCtt(maquinaDTO.getMaquinaTotalDTO().getTempoCorrecaoCTT().divide(new BigDecimal(1), 5, BigDecimal.ROUND_HALF_EVEN));
			r.setSegBoas(maquinaDTO.getMaquinaTotalDTO().getTempoBoasSegundos().divide(new BigDecimal(1), 5, BigDecimal.ROUND_HALF_EVEN));

			if (r.getSegCicloimprodutivo() == null
					|| r.getSegCicloimprodutivo().floatValue() == 0f)
				r.setSegCicloimprodutivo(new BigDecimal(0));

			if (r.getSegCiclomedio() == null
					|| r.getSegCiclomedio().floatValue() == 0f)
				r.setSegCiclomedio(new BigDecimal(0));

			if (r.getSegCicloprodutivo() == null
					|| r.getSegCicloprodutivo().floatValue() == 0f)
				r.setSegCicloprodutivo(new BigDecimal(0));

			if (r.getSegPerdacav() == null
					|| r.getSegPerdacav().floatValue() == 0f)
				r.setSegPerdacav(new BigDecimal(0));

			if (r.getSegCtt() == null
					|| r.getSegCtt().floatValue() == 0f)
				r.setSegCtt(new BigDecimal(0));

			if (r.getSegBoas() == null
					|| r.getSegBoas().floatValue() == 0f)
				r.setSegBoas(new BigDecimal(0));

			if (r.getSegPerdaciclo() == null
					|| r.getSegPerdaciclo().floatValue() == 0f)
				r.setSegPerdaciclo(new BigDecimal(0));

			if (r.getSegRitmo() == null || r.getSegRitmo().floatValue() == 0f)
				r.setSegRitmo(new BigDecimal(0));

			if (r.getSegTempoativo() == null
					|| r.getSegTempoativo().floatValue() == 0f)
				r.setSegTempoativo(new BigDecimal(0));

			if (r.getSegTempodisponivel() == null
					|| r.getSegTempodisponivel().floatValue() == 0f)
				r.setSegTempodisponivel(new BigDecimal(0));

			if (r.getSegTempoparada() == null
					|| r.getSegTempoparada().floatValue() == 0f)
				r.setSegTempoparada(new BigDecimal(0));

			if (r.getSegTempoparadaSp() == null
					|| r.getSegTempoparadaSp().floatValue() == 0f)
				r.setSegTempoparadaSp(new BigDecimal(0));

			if (r.getSegTempoprodutivas() == null
					|| r.getSegTempoprodutivas().floatValue() == 0f)
				r.setSegTempoprodutivas(new BigDecimal(0));

			if (r.getSegTemporefugadas() == null
					|| r.getSegTemporefugadas().floatValue() == 0f)
				r.setSegTemporefugadas(new BigDecimal(0));

			if (r.getSegTempotrabalhado() == null
					|| r.getSegTempotrabalhado().floatValue() == 0f)
				r.setSegTempotrabalhado(new BigDecimal(0));

			if (r.getSegTmpcicnormal() == null
					|| r.getSegTmpcicnormal().floatValue() == 0f)
				r.setSegTmpcicnormal(new BigDecimal(0));

			if (r.getSegCiclopadrao() == null
					|| r.getSegCiclopadrao().floatValue() == 0f)
				r.setSegCiclopadrao(new BigDecimal(0));

			r.setSegCicloimprodutivo(r.getSegCicloimprodutivo().setScale(10,
					RoundingMode.UP));
			r.setSegCiclomedio(r.getSegCiclomedio().setScale(10,
					RoundingMode.UP));
			r.setSegCicloprodutivo(r.getSegCicloprodutivo().setScale(10,
					RoundingMode.UP));
			r.setSegPerdaciclo(r.getSegPerdaciclo().setScale(10,
					RoundingMode.UP));
			r.setSegRitmo(r.getSegRitmo().setScale(10, RoundingMode.UP));
			r.setSegTempoativo(r.getSegTempoativo().setScale(10,
					RoundingMode.UP));
			r.setSegTempodisponivel(r.getSegTempodisponivel().setScale(10,
					RoundingMode.UP));
			r.setSegTempoparada(r.getSegTempoparada().setScale(10,
					RoundingMode.UP));
			r.setSegTempoparadaSp(r.getSegTempoparadaSp().setScale(10,
					RoundingMode.UP));
			r.setSegTempoprodutivas(r.getSegTempoprodutivas().setScale(10,
					RoundingMode.UP));
			r.setSegTemporefugadas(r.getSegTemporefugadas().setScale(10,
					RoundingMode.UP));
			r.setSegTempotrabalhado(r.getSegTempotrabalhado().setScale(10,
					RoundingMode.UP));

			try {
				getDao().makePersistent(r);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (isProcessarCompleto == true){
				// Insere as ocorrencias das paradas
				VMaqDataPa rp = null;
				for (ParadaInjetDTO paradaDTO : maquinaDTO.getParadas()) {
					// Verifica se o registro existe
					Ijtbpar ijtbpar = new Ijtbpar();
					ijtbpar.setCdparada(paradaDTO.getCdParada());

					try {
						rp = pesquisarVMaqDataPa(ijreprodt.getDtReferencia(),
								ijreprodt.getIjtbtur().getCdturno(), ijtbinj
								.getCdinjetora(), ijtbpar.getCdparada());
					} catch (RegistroDesconhecidoException e) {
						rp = new VMaqDataPa();
					}
					try {
						rp.setIjtbinj(ijtbinj);
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
					rp.setIjtbpar(ijtbpar);
					rp.setIjtbtur(ijreprodt.getIjtbtur());
					rp.setDsMaquina(ijtbinj.getCdinjestendido());
					rp.setDsparada(paradaDTO.getDsParada());
					rp.setDsTurno(ijreprodt.getIjtbtur().getDsturno());
					rp.setDtReferencia(ijreprodt.getDtReferencia());
					if (paradaDTO.isParadaPesa())
						rp.setParadaPesa("SIM");
					else
						rp.setParadaPesa("N�O");
					rp.setSegTempoparada(new BigDecimal(paradaDTO
							.getTempoParadaSegundos()));

					getDao().makePersistent(rp);

				}
			}
			try{
				getDao().flushReiniciandoTransacao();
			} catch (Exception e){

				e.printStackTrace();
			}
			// A limpeza da sessao � importante para melhoria de performance
			getDaoSession().clear();
		}
	}

	private void inserirMes(Ijreprodt ijreprodt) {
		Ijreproms ijreprodms = new Ijreproms();

		ijreprodms
		.setAno(DataHoraRN.getAno(ijreprodt.getDtReferencia()));
		ijreprodms
		.setMes(DataHoraRN.getMes(ijreprodt.getDtReferencia()));
		ijreprodms.setIjtbtur(ijreprodt.getIjtbtur());

		try {
			pesquisarIjreproms(ijreprodms);
		} catch (RegistroDesconhecidoException e) {
			getDao().makePersistent(ijreprodms);
		}
	}

	private void inserirAno(Ijreproms ijreproms) {
		Ijreproan ijreprodan = new Ijreproan();

		ijreprodan.setAno(ijreproms.getAno());
		ijreprodan.setIjtbtur(ijreproms.getIjtbtur());

		try {
			pesquisarIjreproan(ijreprodan);
		} catch (RegistroDesconhecidoException e) {
			getDao().makePersistent(ijreprodan);
		}
	}

	public Ijreproms pesquisarIjreproms(Ijreproms ijreproms)
	throws RegistroDesconhecidoException {
		String HQL = "";

		HQL += "from Ijreproms ijreproms ";
		HQL += "where ijreproms.ano = ::ano and ijreproms.mes = ::mes and ijreproms.ijtbtur.cdturno = '::cdturno' ";

		HQL = HQL.replaceAll("::ano", ijreproms.getAno().toString());
		HQL = HQL.replaceAll("::mes", ijreproms.getMes().toString());
		HQL = HQL.replaceAll("::cdturno", ijreproms.getIjtbtur().getCdturno());

		List<Ijreproms> listaIjreproms = null;

		Query q = getDaoSession().createQuery(HQL);

		try {
			listaIjreproms = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegistroDesconhecidoException();
		}
		if (listaIjreproms.size() <= 0) {
			throw new RegistroDesconhecidoException();
		}
		return listaIjreproms.get(0);
	}

	public Ijreproan pesquisarIjreproan(Ijreproan ijreproan)
	throws RegistroDesconhecidoException {
		String HQL = "";

		HQL += "from Ijreproan ijreproan ";
		HQL += "where ijreproan.ano = ::ano and ijreproan.ijtbtur.cdturno = '::cdturno' ";

		HQL = HQL.replaceAll("::ano", ijreproan.getAno().toString());
		HQL = HQL.replaceAll("::cdturno", ijreproan.getIjtbtur().getCdturno());

		List<Ijreproan> listaIjreproan = null;

		Query q = getDaoSession().createQuery(HQL);

		try {
			listaIjreproan = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegistroDesconhecidoException();
		}
		if (listaIjreproan.size() <= 0) {
			throw new RegistroDesconhecidoException();
		}
		return listaIjreproan.get(0);
	}

	public List<Ijreprodt> pesquisarListaIjreprodt() throws RegistroDesconhecidoException {
		String HQL = "";

		HQL += "from Ijreprodt ijreprodt join fetch ijreprodt.ijtbtur ijtbtur ";

		List<Ijreprodt> listaIjreprodt = null;

		Query q = getDaoSession().createQuery(HQL);

		try {
			listaIjreprodt = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegistroDesconhecidoException();
		}
		if (listaIjreprodt.size() <= 0) {
			throw new RegistroDesconhecidoException();
		}
		return listaIjreprodt;
	}

	public Ijreprodt pesquisarIjreprodt(Ijreprodt reg)
	throws RegistroDesconhecidoException {
		String HQL = "";

		HQL += "from Ijreprodt ijreprodt join fetch ijreprodt.ijtbtur ijtbtur where ijreprodt.id.dtReferencia = :data ";
		HQL += "and ijreprodt.ijtbtur.cdturno = '::cdturno' ";

		HQL = HQL.replaceAll("::cdturno", reg.getIjtbtur().getCdturno());

		List<Ijreprodt> listaIjreprodt = null;

		Query q = getDaoSession().createQuery(HQL);

		q.setDate("data", reg.getDtReferencia());

		try {
			listaIjreprodt = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegistroDesconhecidoException();
		}
		if (listaIjreprodt.size() <= 0) {
			throw new RegistroDesconhecidoException();
		}
		return listaIjreprodt.get(0);
	}

	public List<Ijreproms> pesquisarListaIjreproms()
	throws RegistroDesconhecidoException {
		String HQL = "";

		HQL += "from Ijreproms ijreproms join fetch ijreproms.ijtbtur ijtbtur ";

		List<Ijreproms> listaIjreproms = null;

		Query q = getDaoSession().createQuery(HQL);

		try {
			listaIjreproms = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegistroDesconhecidoException();
		}
		if (listaIjreproms.size() <= 0) {
			throw new RegistroDesconhecidoException();
		}
		return listaIjreproms;
	}

	public List<Ijreproan> pesquisarListaIjreproan()
	throws RegistroDesconhecidoException {
		String HQL = "";

		HQL += "from Ijreproan ijreproan join fetch ijreproan.ijtbtur ijtbtur ";

		List<Ijreproan> listaIjreproan = null;

		Query q = getDaoSession().createQuery(HQL);

		try {
			listaIjreproan = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegistroDesconhecidoException();
		}
		if (listaIjreproan.size() <= 0) {
			throw new RegistroDesconhecidoException();
		}
		return listaIjreproan;
	}

	public VMaqDataPa pesquisarVMaqDataPa(Date dt_referencia, String cdturno,
			String cdinjetora, String cdparada)
	throws RegistroDesconhecidoException {
		String hql = "";
		hql += "from VMaqDataPa vmaqdatapa ";
		hql += "where vmaqdatapa.dtReferencia = :data ";
		hql += "and vmaqdatapa.ijtbtur.cdturno = '::cdturno' ";
		hql += "and vmaqdatapa.ijtbinj.cdinjetora = '::cdinjetora' ";
		hql += "and vmaqdatapa.ijtbpar.cdparada = '::cdparada' ";

		hql = hql.replaceAll("::cdturno", cdturno);
		hql = hql.replaceAll("::cdinjetora", cdinjetora);
		hql = hql.replaceAll("::cdparada", cdparada);

		VMaqDataPa retorno = null;

		Query q = getDaoSession().createQuery(hql);

		q.setDate("data", dt_referencia);

		try {
			retorno = (VMaqDataPa) q.uniqueResult();
		} catch (Exception e) {
			throw new RegistroDesconhecidoException();
		}
		if (retorno == null)
			throw new RegistroDesconhecidoException();
		return retorno;
	}

	public VMaqDataBi pesquisarVMaqDataBi(Date dt_referencia, String cdturno,
			String cdinjetora) throws RegistroDesconhecidoException {
		String hql = "";
		hql += "from VMaqDataBi vmaqdatabi ";
		hql += "where vmaqdatabi.dtReferencia = :data ";
		hql += "and vmaqdatabi.ijtbtur.cdturno = '::cdturno' ";
		hql += "and vmaqdatabi.ijtbinj.cdinjetora = '::cdinjetora' ";

		hql = hql.replaceAll("::cdturno", cdturno);
		hql = hql.replaceAll("::cdinjetora", cdinjetora);

		VMaqDataBi retorno = null;

		Query q = getDaoSession().createQuery(hql);

		q.setDate("data", dt_referencia);

		try {
			retorno = (VMaqDataBi) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegistroDesconhecidoException();
		}
		if (retorno == null) {
			throw new RegistroDesconhecidoException();
		}

		return retorno;
	}

	public VMaqMesBi pesquisarVMaqMesBi(VMaqMesBi vmaqmesbi)
	throws RegistroDesconhecidoException {
		String hql = "";
		hql += "from VMaqMesBi vmaqmesbi ";
		hql += "where vmaqmesbi.anoReferencia = ::anoReferencia ";
		hql += "and vmaqmesbi.mesReferencia = ::mesReferencia ";
		hql += "and vmaqmesbi.cdturno = '::cdturno' ";
		hql += "and vmaqmesbi.cdinjetora = '::cdinjetora' ";

		hql = hql.replaceAll("::anoReferencia", vmaqmesbi.getAnoReferencia()
				.toString());
		hql = hql.replaceAll("::mesReferencia", vmaqmesbi.getMesReferencia()
				.toString());
		hql = hql.replaceAll("::cdturno", vmaqmesbi.getCdturno());
		hql = hql.replaceAll("::cdinjetora", vmaqmesbi.getCdinjetora());

		VMaqMesBi retorno = null;

		Query q = getDaoSession().createQuery(hql);

		try {
			retorno = (VMaqMesBi) q.uniqueResult();
		} catch (Exception e) {
			throw new RegistroDesconhecidoException();
		}
		if (retorno == null)
			throw new RegistroDesconhecidoException();
		return retorno;
	}

	public VMaqAnoBi pesquisarVMaqAnoBi(VMaqAnoBi vmaqanobi)
	throws RegistroDesconhecidoException {
		String hql = "";
		hql += "from VMaqAnoBi vmaqanobi ";
		hql += "where vmaqanobi.anoReferencia = ::anoReferencia ";
		hql += "and vmaqanobi.cdturno = '::cdturno' ";
		hql += "and vmaqanobi.cdinjetora = '::cdinjetora' ";

		hql = hql.replaceAll("::anoReferencia", vmaqanobi.getAnoReferencia()
				.toString());
		hql = hql.replaceAll("::cdturno", vmaqanobi.getCdturno());
		hql = hql.replaceAll("::cdinjetora", vmaqanobi.getCdinjetora());

		VMaqAnoBi retorno = null;

		Query q = getDaoSession().createQuery(hql);

		try {
			retorno = (VMaqAnoBi) q.uniqueResult();
		} catch (Exception e) {
			throw new RegistroDesconhecidoException();
		}
		if (retorno == null)
			throw new RegistroDesconhecidoException();
		return retorno;
	}

	public VMaqMesPa pesquisarVMaqMesPa(VMaqMesPa vmaqmespa)
	throws RegistroDesconhecidoException {
		String hql = "";
		hql += "from VMaqMesPa vmaqmespa ";
		hql += "where vmaqmespa.anoReferencia = ::anoReferencia ";
		hql += "and vmaqmespa.mesReferencia = ::mesReferencia ";
		hql += "and vmaqmespa.cdparada = '::cdparada' ";
		hql += "and vmaqmespa.cdturno = '::cdturno' ";
		hql += "and vmaqmespa.cdinjetora = '::cdinjetora' ";

		hql = hql.replaceAll("::anoReferencia", vmaqmespa.getAnoReferencia()
				.toString());
		hql = hql.replaceAll("::mesReferencia", vmaqmespa.getMesReferencia()
				.toString());
		hql = hql.replaceAll("::cdturno", vmaqmespa.getCdturno());
		hql = hql.replaceAll("::cdinjetora", vmaqmespa.getCdinjetora());
		hql = hql.replaceAll("::cdparada", vmaqmespa.getCdparada());

		VMaqMesPa retorno = null;

		Query q = getDaoSession().createQuery(hql);

		try {
			retorno = (VMaqMesPa) q.uniqueResult();
		} catch (Exception e) {
			throw new RegistroDesconhecidoException();
		}
		if (retorno == null)
			throw new RegistroDesconhecidoException();
		return retorno;
	}

	public VMaqAnoPa pesquisarVMaqAnoPa(VMaqAnoPa vmaqanopa) throws RegistroDesconhecidoException {
		String hql = "";
		hql += "from VMaqAnoPa vmaqanopa ";
		hql += "where vmaqanopa.anoReferencia = ::anoReferencia ";
		hql += "and vmaqanopa.cdparada = '::cdparada' ";
		hql += "and vmaqanopa.cdturno = '::cdturno' ";
		hql += "and vmaqanopa.cdinjetora = '::cdinjetora' ";

		hql = hql.replaceAll("::anoReferencia", vmaqanopa.getAnoReferencia()
				.toString());
		hql = hql.replaceAll("::cdturno", vmaqanopa.getCdturno());
		hql = hql.replaceAll("::cdinjetora", vmaqanopa.getCdinjetora());
		hql = hql.replaceAll("::cdparada", vmaqanopa.getCdparada());

		VMaqAnoPa retorno = null;

		Query q = getDaoSession().createQuery(hql);

		try {
			retorno = (VMaqAnoPa) q.uniqueResult();
		} catch (Exception e) {
			throw new RegistroDesconhecidoException();
		}
		if (retorno == null)
			throw new RegistroDesconhecidoException();
		return retorno;
	}

	private ViewInjet pesquisarViewInjet(ViewInjet r)
	throws RegistroDesconhecidoException {
		ViewInjet retorno = null;
		String hql = "";

		hql += "from ViewInjet viewInjet ";
		hql += "where viewInjet.data = :data ";
		hql += "and viewInjet.turno = '::cdturno' ";
		hql += "and viewInjet.codMaquina = '::cdmaquina' ";
		hql += "and viewInjet.op = '::nrop' ";
		hql += "and viewInjet.item = '::item' ";
		hql += "and viewInjet.codOperacaoParada = '::cdoperacao' ";

		hql = hql.replaceAll("::cdturno", r.getTurno());
		hql = hql.replaceAll("::cdmaquina", r.getCodMaquina());
		hql = hql.replaceAll("::nrop", r.getOp());
		hql = hql.replaceAll("::item", r.getItem());
		hql = hql.replaceAll("::cdoperacao", r.getCodOperacaoParada());

		Query q = getDaoSession().createQuery(hql);

		q.setParameter("data", r.getData());

		List<ViewInjet> lista = q.list();

		if (lista.size() == 0)
			throw new RegistroDesconhecidoException();

		retorno = lista.get(0);

		return retorno;
	}

	public MaquinaInjetDTO analisarConsultas(FiltroMaquinaInjetDTO filtro) {
		MaquinaInjetDTO retorno = null;
		// Analisar o filtro para decidi qual view utilizar
		// Se o filtro for de um periodo de um mes, utilizar v_maq_mes_bi e
		// v_maq_mes_pa
		// Se o periodo for um ano, utilizar v_maq_ano_bi e v_maq_ano_pa
		// Se o periodo for inferior a um mes, utilizar v_maq_data_bi e
		// v_map_data_bi
		Date dtIMes = null;
		Date dtFMes = null;
		Date dtIAno = null;
		Date dtFAno = null;

		dtIMes = DataHoraRN.getInicioMes(filtro.getData());
		dtFMes = DataHoraRN.getFimMes(filtro.getDtFinal());

		dtIAno = DataHoraRN.getInicioAno(filtro.getData());
		dtFAno = DataHoraRN.getFimAno(filtro.getDtFinal());

		if (DataHoraRN.compareDateAsDayOnly(dtIAno, filtro.getData()) == 0  && 
				DataHoraRN.compareDateAsDayOnly(dtFAno, filtro.getDtFinal()) == 0) {
			retorno = analisarConsultaANO(filtro);
		} else if (DataHoraRN.compareDateAsDayOnly(dtIMes, filtro.getData()) == 0  && 
				DataHoraRN.compareDateAsDayOnly(dtFMes, filtro.getDtFinal()) == 0) {
			retorno = analisarConsultaMES(filtro);
		} else {
			retorno = analisarConsultaDATA(filtro);
		}
		return retorno;
	}

	public MaquinaInjetDTO analisarConsultaDATA(FiltroMaquinaInjetDTO filtro) {
		String hql = "";
		MaquinaInjetDTO retorno = new MaquinaInjetDTO();

		hql += "from VMaqDataBi vmaq ";
		hql += "where vmaq.ijtbinj.cdinjetora = '::cdinjetora' ";
		hql += "and vmaq.dtReferencia between :dataI and :dataF ";

		hql = hql.replaceAll("::cdinjetora", filtro.getCdMaquina());

		if (filtro.getCdTurno() != null && !filtro.getCdTurno().equals("")) {
			hql += "and vmaq.ijtbtur.cdturno = '::cdturno' ";
			hql = hql.replaceAll("::cdturno", filtro.getCdTurno());
		}
		Query q = getDaoSession().createQuery(hql);

		q.setParameter("dataI", filtro.getData());
		q.setParameter("dataF", filtro.getDtFinal());

		List<VMaqDataBi> lista = q.list();

		for (VMaqDataBi reg : lista) {
			retorno.addVMaqDataBi(reg);
		}

		hql = "";
		hql += "from VMaqDataPa vmaq ";
		hql += "where vmaq.ijtbinj.cdinjetora = '::cdinjetora' ";
		hql += "and vmaq.dtReferencia between :dataI and :dataF ";

		hql = hql.replaceAll("::cdinjetora", filtro.getCdMaquina());

		if (filtro.getCdTurno() != null && !filtro.getCdTurno().equals("")) {
			hql += "and vmaq.ijtbtur.cdturno = '::cdturno' ";
			hql = hql.replaceAll("::cdturno", filtro.getCdTurno());
		}

		q = getDaoSession().createQuery(hql);

		q.setParameter("dataI", filtro.getData());
		q.setParameter("dataF", filtro.getDtFinal());

		List<VMaqDataPa> listaPa = q.list();

		for (VMaqDataPa reg : listaPa) {
			retorno.addVMaqDataPa(reg);
		}

		return retorno;
	}


	public MaquinaInjetDTO analisarConsultaMES(FiltroMaquinaInjetDTO filtro) {
		String hql = "";
		int anoReferencia = DataHoraRN.getAno(filtro.getData());
		int mesReferencia = DataHoraRN.getMes(filtro.getData());

		MaquinaInjetDTO retorno = new MaquinaInjetDTO();

		hql += "from VMaqMesBi vmaq ";
		hql += "where vmaq.cdinjetora = '::cdinjetora' ";
		hql += "and vmaq.anoReferencia = ::anoReferencia ";
		hql += "and vmaq.mesReferencia = ::mesReferencia ";

		hql = hql.replaceAll("::cdinjetora", filtro.getCdMaquina());
		hql = hql.replaceAll("::anoReferencia", String.valueOf(anoReferencia));
		hql = hql.replaceAll("::mesReferencia", String.valueOf(mesReferencia));

		if (filtro.getCdTurno() != null && !filtro.getCdTurno().equals("")) {
			hql += "and vmaq.cdturno = '::cdturno' ";
			hql = hql.replaceAll("::cdturno", filtro.getCdTurno());
		}
		Query q = getDaoSession().createQuery(hql);

		List<VMaqMesBi> lista = q.list();

		for (VMaqMesBi reg : lista) {
			retorno.addVMaqMesBi(reg);
		}

		hql = "";
		hql += "from VMaqMesPa vmaq ";
		hql += "where vmaq.cdinjetora = '::cdinjetora' ";
		hql += "and vmaq.anoReferencia = ::anoReferencia ";
		hql += "and vmaq.mesReferencia = ::mesReferencia ";

		hql = hql.replaceAll("::cdinjetora", filtro.getCdMaquina());
		hql = hql.replaceAll("::anoReferencia", String.valueOf(anoReferencia));
		hql = hql.replaceAll("::mesReferencia", String.valueOf(mesReferencia));

		if (filtro.getCdTurno() != null && !filtro.getCdTurno().equals("")) {
			hql += "and vmaq.cdturno = '::cdturno' ";
			hql = hql.replaceAll("::cdturno", filtro.getCdTurno());
		}

		q = getDaoSession().createQuery(hql);

		List<VMaqMesPa> listaPa = q.list();

		for (VMaqMesPa reg : listaPa) {
			retorno.addVMaqMesPa(reg);
		}

		return retorno;
	}
	public MaquinaInjetDTO analisarConsultaANO(FiltroMaquinaInjetDTO filtro) {
		String hql = "";
		int anoReferencia = DataHoraRN.getAno(filtro.getData());

		MaquinaInjetDTO retorno = new MaquinaInjetDTO();

		hql += "from VMaqAnoBi vmaq ";
		hql += "where vmaq.cdinjetora = '::cdinjetora' ";
		hql += "and vmaq.anoReferencia = ::anoReferencia ";

		hql = hql.replaceAll("::cdinjetora", filtro.getCdMaquina());
		hql = hql.replaceAll("::anoReferencia", String.valueOf(anoReferencia));

		if (filtro.getCdTurno() != null && !filtro.getCdTurno().equals("")) {
			hql += "and vmaq.cdturno = '::cdturno' ";
			hql = hql.replaceAll("::cdturno", filtro.getCdTurno());
		}
		Query q = getDaoSession().createQuery(hql);

		List<VMaqAnoBi> lista = q.list();

		for (VMaqAnoBi reg : lista) {
			retorno.addVMaqAnoBi(reg);
		}

		hql = "";
		hql += "from VMaqAnoPa vmaq ";
		hql += "where vmaq.cdinjetora = '::cdinjetora' ";
		hql += "and vmaq.anoReferencia = ::anoReferencia ";

		hql = hql.replaceAll("::cdinjetora", filtro.getCdMaquina());
		hql = hql.replaceAll("::anoReferencia", String.valueOf(anoReferencia));

		if (filtro.getCdTurno() != null && !filtro.getCdTurno().equals("")) {
			hql += "and vmaq.cdturno = '::cdturno' ";
			hql = hql.replaceAll("::cdturno", filtro.getCdTurno());
		}

		q = getDaoSession().createQuery(hql);

		List<VMaqAnoPa> listaPa = q.list();

		for (VMaqAnoPa reg : listaPa) {
			retorno.addVMaqAnoPa(reg);
		}

		return retorno;
	}

	public void popularIjRT()
	{
		DiversosInjetRN rnDiv = new DiversosInjetRN(getDao());
		rnDiv.setDaoSession(getDaoSession());

		//	Obter data de referencia e turno atual		
		Ijtreal ijtreal = rnDiv.pesquisarIjtreal();

		//	Obter a lista de todas as maquinas ativas no injet
		Ijtbinj filtro = new Ijtbinj();
		filtro.setStinjetora(0);
		List<Ijtbinj> listaIjtbinj = rnDiv.pesquisarIjtbinj(filtro);

		//	Varrer a lista de todas as injetoras. Para cada injetora
		for (Ijtbinj ijtbinj : listaIjtbinj){

			//	Obter um registro em IJRT 
			Ijrt filtroIjRT = new Ijrt();

			filtroIjRT.setIjtbinj(new Ijtbinj());
			filtroIjRT.getIjtbinj().setCdinjetora(ijtbinj.getCdinjetora());
			filtroIjRT.setDtReferencia(ijtreal.getId().getDtrefturno());
			filtroIjRT.setIjtbtur(new Ijtbtur());
			filtroIjRT.getIjtbtur().setCdturno(ijtreal.getId().getCdturno());

			List<Ijrt> listaIjRT = rnDiv.pesquisarIjRT(filtroIjRT);

			Ijrt ijRT = null;
			if (listaIjRT.size() > 0){
				ijRT = listaIjRT.get(0);
				//	Se n�o existir
			}else{
				ijRT = new Ijrt();

				ijRT.setDtReferencia(ijtreal.getId().getDtrefturno());

				Ijtbtur filtroIjtbtur = new Ijtbtur();
				filtroIjtbtur.setCdturno(ijtreal.getId().getCdturno());
				ijRT.setIjtbtur(rnDiv.pesquisarIjtbtur(filtroIjtbtur).get(0));				

				ijRT.setIjtbinj(ijtbinj);
				ijRT.setIsoperador('0');
			}

			//	Ap�s incluir o registro ou encontrar um registro pre-existente
			Ijlogope filtroIjlogope = new Ijlogope();
			filtroIjlogope.setId(new IjlogopeId());
			filtroIjlogope.getId().setCdinjetora(ijRT.getIjtbinj().getCdinjetora());
			filtroIjlogope.setDthrlogout(null);
			List<Ijlogope> listaIjlogope = rnDiv.pesquisarIjlogope(filtroIjlogope);

			if (listaIjlogope.size() > 0){
				ijRT.setIsoperador('1');
			}else{
				ijRT.setIsoperador('0');				
			}

			ijRT.setStfuncionamento(ijtbinj.getStfuncionamento().charAt(0));

			ijRT.setIjtbpar(ijtbinj.getIjtbpar());
			ijRT.setDthriparada(ijtbinj.getDthriparada());
			ijRT.setDthrfparada(ijtbinj.getDthrfparada());

			Date dtHrFinal = null;
			if (ijRT.getDthrfparada() == null){
				dtHrFinal = new Date();
			}else{
				dtHrFinal = ijRT.getDthrfparada();
			}

			ijRT.setDuracao(BigDecimal.valueOf(DataHoraRN.amountOfSecondsInPeriod(ijRT.getDthriparada(), dtHrFinal)));

			Ijestmol filtroIjestmol = new Ijestmol();
			filtroIjestmol.setId(new IjestmolId());
			String cdMoldeAtual = "";
			if (ijtbinj.getCdmoldeatual() != null)
				cdMoldeAtual = ijtbinj.getCdmoldeatual();

			filtroIjestmol.getId().setCdmolde(cdMoldeAtual);
			filtroIjestmol.getId().setCdestrutura(ijtbinj.getCdestruturaatual());
			try {
				ijRT.setIjestmol(rnDiv.pesquisarIjestmol(filtroIjestmol).get(0));
			} catch (Exception e) {
				ijRT.setIjestmol(null);
			}			

			VMaqDataBi filtroVMaqDataBi = new VMaqDataBi();
			filtroVMaqDataBi.setIjtbinj(new Ijtbinj());
			filtroVMaqDataBi.getIjtbinj().setCdinjetora(ijtbinj.getCdinjetora());
			filtroVMaqDataBi.setDtReferencia(ijtreal.getId().getDtrefturno());
			filtroVMaqDataBi.setIjtbtur(new Ijtbtur());
			filtroVMaqDataBi.getIjtbtur().setCdturno(ijtreal.getId().getCdturno());
			List<VMaqDataBi> listaVMaqDataBi = rnDiv.pesquisarVMaqDataBi(filtroVMaqDataBi);
			if (listaVMaqDataBi.size() > 0){
				ijRT.setVMaqDataBi(listaVMaqDataBi.get(0));
			}

			//			VMaqMesBi filtroVMaqMesBi = new VMaqMesBi();
			//			filtroVMaqMesBi.setCdinjetora(ijtbinj.getCdinjetora());
			//			filtroVMaqMesBi.setMesReferencia(Long.valueOf(DataHoraRN.getMes(ijRT.getDtReferencia())));
			//			filtroVMaqMesBi.setAnoReferencia(Long.valueOf(DataHoraRN.getAno(ijRT.getDtReferencia())));
			//			filtroVMaqMesBi.setCdturno(ijtreal.getId().getCdTurno());
			//			List<VMaqMesBi> listaVMaqMesBi = rnDiv.pesquisarVMaqMesBi(filtroVMaqMesBi);
			//			if (listaVMaqMesBi.size() > 0){
			//				ijRT.setVMaqMesBi(listaVMaqMesBi.get(0));
			//			}
			//
			//			VMaqAnoBi filtroVMaqAnoBi = new VMaqAnoBi();
			//			filtroVMaqAnoBi.setCdinjetora(ijtbinj.getCdinjetora());
			//			filtroVMaqAnoBi.setAnoReferencia(Long.valueOf(DataHoraRN.getAno(ijRT.getDtReferencia())));
			//			filtroVMaqAnoBi.setCdturno(ijtreal.getId().getCdTurno());
			//			List<VMaqAnoBi> listaVMaqAnoBi = rnDiv.pesquisarVMaqAnoBi(filtroVMaqAnoBi);
			//			if (listaVMaqAnoBi.size() > 0){
			//				ijRT.setVMaqAnoBi(listaVMaqAnoBi.get(0));
			//			}

			if (listaIjRT.size() > 0)
				getDaoSession().merge(ijRT);
			else
				getDaoSession().persist(ijRT);

			getDao().flushReiniciandoTransacao();

			getDaoSession().clear();

			filtroVMaqDataBi = null;
			filtroIjestmol = null;
			filtroIjlogope = null;
			listaIjRT =  null;
			ijRT = null;
			filtroIjRT  = null;

		}

		listaIjtbinj = null;
		filtro = null;
		ijtreal = null;
		rnDiv = null;

	}

	public List<CrescimentoGalInjetDTO> getCrescimento(CrescimentoFiltroInjetDTO filtro){
		DiversosInjetRN rnDiv = new DiversosInjetRN(getDao());
		rnDiv.setDaoSession(getDaoSession());

		List<CrescimentoGalInjetDTO> retorno = new ArrayList<CrescimentoGalInjetDTO>();

		for (String galpao : filtro.getGalpoes()) {

			// 	Obter a lista de todas as m�quinas ativas do galp�o
			Ijtbinj filtroIjtbinj = new Ijtbinj();
			filtroIjtbinj.setStinjetora(0);
			filtroIjtbinj.setIjgalobjs(new HashSet<Ijgalobj>());
			Ijgalobj ijgalobj = new Ijgalobj();
			ijgalobj.setIjtbgal(new Ijtbgal());
			ijgalobj.getIjtbgal().setCdgalpao(galpao);
			filtroIjtbinj.getIjgalobjs().add(ijgalobj);
			List<Ijtbinj> listaIjtbinj = rnDiv.pesquisarIjtbinj(filtroIjtbinj);

			Double mediaUtilizacaoMesAnteriorGal = 0d;
			Double mediaUtilizacaoMesAtualGal = 0d;		

			CrescimentoGalInjetDTO gal = new CrescimentoGalInjetDTO();
			gal.setMaquinas(new ArrayList<CrescimentoMaqInjetDTO>());

			//	Para cada m�quina, avaliar o percentual de crescimento, obtendo os dados do m�s atual e do m�s anterior
			Double tTrab = 0d;
			Double tDisp = 0d;
			Double tTrabAnt = 0d;
			Double tDispAnt = 0d;
			for (Ijtbinj ijtbinj : listaIjtbinj) {

				if (ijtbinj.getStinjetora().equals("1"))
					continue;

				Date inicio = DataHoraRN.getDataHoraAtual();
				
				//	Calcular para cada registro a taxa de utiliza��o = soma_tempoprodutivas / soma_tempodisponivel
				MaquinaTotalInjetDTO maqAtual =  rnDiv.getMediaTaxaUtilizacao(ijtbinj.getCdinjetora(),filtro.getAno() , filtro.getMes());
				Double mediaUtilizacaoMesAtualMaq = maqAtual.getUtilizacao().doubleValue();
				tTrab += maqAtual.getTempoTrabalhadoSegundos().doubleValue();
				tDisp += maqAtual.getTempoDisponiveisSegundos().doubleValue();
				
				GregorianCalendar calendario = new GregorianCalendar();				
				calendario.set(Calendar.YEAR, filtro.getAno());
				calendario.set(Calendar.MONTH, filtro.getMes());
				calendario.set(Calendar.DAY_OF_MONTH, 1);
				calendario.add(Calendar.MONTH, -1);

				Date inicio2 = DataHoraRN.getDataHoraAtual();
				
				MaquinaTotalInjetDTO maqAnt = rnDiv.getMediaTaxaUtilizacao(ijtbinj.getCdinjetora(), calendario.get(Calendar.YEAR) , calendario.get(Calendar.MONTH));
				Double mediaUtilizacaoMesAnteriorMaq = maqAnt.getUtilizacao().doubleValue();
				tTrabAnt += maqAnt.getTempoTrabalhadoSegundos().doubleValue();
				tDispAnt += maqAnt.getTempoDisponiveisSegundos().doubleValue();

				// calcular o percentual de crescimento

				Double percentualCrescimentoMaq = 0d;

				if (mediaUtilizacaoMesAnteriorMaq > 0){
					percentualCrescimentoMaq = ((mediaUtilizacaoMesAtualMaq - mediaUtilizacaoMesAnteriorMaq)/mediaUtilizacaoMesAnteriorMaq)*100;
				}

				//	Identificar se o percentual de crescimento � positivo, neutro ou negativo 
				Integer crescimentoMaq = 0;

				if (mediaUtilizacaoMesAnteriorMaq < mediaUtilizacaoMesAtualMaq){
					crescimentoMaq = 1;
				}else if (mediaUtilizacaoMesAnteriorMaq > mediaUtilizacaoMesAtualMaq){
					crescimentoMaq = -1;
				}

				mediaUtilizacaoMesAnteriorGal += mediaUtilizacaoMesAnteriorMaq;
				mediaUtilizacaoMesAtualGal += mediaUtilizacaoMesAtualMaq;			

				CrescimentoMaqInjetDTO maquina = new CrescimentoMaqInjetDTO();
				maquina.setCrescimento(crescimentoMaq);
				maquina.setIdentificacaoMaquina(ijtbinj.getCdinjestendido());
				maquina.setPercentualCrescimento(percentualCrescimentoMaq);
				maquina.setTaxaUtilizacaoMesAnterior(mediaUtilizacaoMesAnteriorMaq);
				maquina.setTaxaUtilizacaoMesAtual(mediaUtilizacaoMesAtualMaq);

				gal.getMaquinas().add(maquina);

			}

			//	Calcular o percentual de crescimento do galp�o como um todo
			if (listaIjtbinj.size() > 0){
				mediaUtilizacaoMesAnteriorGal = mediaUtilizacaoMesAnteriorGal / listaIjtbinj.size();
				if (tDispAnt > 0)
					mediaUtilizacaoMesAnteriorGal = (tTrabAnt / tDispAnt);
				mediaUtilizacaoMesAtualGal = mediaUtilizacaoMesAtualGal / listaIjtbinj.size();
				if (tDisp > 0)
					mediaUtilizacaoMesAtualGal = (tTrab / tDisp);
			}

			Double percentualCrescimentoGal = 0d;

			if (mediaUtilizacaoMesAnteriorGal > 0){
				percentualCrescimentoGal = ((mediaUtilizacaoMesAtualGal - mediaUtilizacaoMesAnteriorGal)/mediaUtilizacaoMesAnteriorGal)*100;
			}

			//	Identificar se o percentual de crescimento � positivo, neutro ou negativo 
			Integer crescimentoGal = 0;

			if (mediaUtilizacaoMesAnteriorGal < mediaUtilizacaoMesAtualGal){
				crescimentoGal = 1;
			}else if (mediaUtilizacaoMesAnteriorGal > mediaUtilizacaoMesAtualGal){
				crescimentoGal = -1;
			}

			gal.setCrescimento(crescimentoGal);
			gal.setIdentificacaoGalpao(galpao);
			try{
				gal.setDescricaoGalpao("Desc");
			} catch (Exception e){
				gal.setDescricaoGalpao("Desc");
			}
			gal.setPercentualCrescimento(percentualCrescimentoGal);
			gal.setTaxaUtilizacaoMesAnterior(mediaUtilizacaoMesAnteriorGal);
			gal.setTaxaUtilizacaoMesAtual(mediaUtilizacaoMesAtualGal);

			retorno.add(gal);
		}

		return retorno;

	}

	public TaxaUtilizacaoInjetDTO getTaxaUtilizacaoMaquina(CrescimentoFiltroInjetDTO filtro){
		
		DiversosInjetRN rnDiv = new DiversosInjetRN(getDao());
		rnDiv.setDaoSession(getDaoSession());
		
		List<TaxaUtilizacaoMesInjetDTO> taxas = new ArrayList<TaxaUtilizacaoMesInjetDTO>();
		TaxaUtilizacaoInjetDTO retorno = new TaxaUtilizacaoInjetDTO();

		SerieDTO serie = new SerieDTO();
		serie.setDescricao("Taxa de Utiliza��oo");

		double valorMedio = 0;

		String meses[] = { "Jan" ,  "Fev" ,
				"Mar" , "Abr" , "Mai" ,
				"Jun" , "Jul" , "Ago" ,
				"Set" , "Out" ,
				"Nov" , "Dez" };
		
		List<Ijtbinj> listaIjtbinj = new ArrayList<Ijtbinj>();
		
		for (String galpao : filtro.getGalpoes()) {
			// 	Obter a lista de todas as maquinas ativas do galpao
			Ijtbinj filtroIjtbinj = new Ijtbinj();
			filtroIjtbinj.setStinjetora(0);
			filtroIjtbinj.setIjgalobjs(new HashSet<Ijgalobj>());
			Ijgalobj ijgalobj = new Ijgalobj();
			ijgalobj.setIjtbgal(new Ijtbgal());
			ijgalobj.getIjtbgal().setCdgalpao(galpao);
			filtroIjtbinj.getIjgalobjs().add(ijgalobj);
			
			List<Ijtbinj> localListaIjtbinj = rnDiv.pesquisarIjtbinj(filtroIjtbinj);
			
			if(localListaIjtbinj != null) {
				for(Ijtbinj localIjtbinj : localListaIjtbinj) {
					boolean isExiste = false;
					for (Ijtbinj ijtbinj : listaIjtbinj){
						if (ijtbinj.getCdinjetora().equals(localIjtbinj.getCdinjetora())){
							isExiste = true;			
						}
					}
					if (isExiste == false){
						listaIjtbinj.add(localIjtbinj);
					}
				}
			}
			
		}

		GregorianCalendar calendario = new GregorianCalendar();				
		calendario.set(Calendar.YEAR, filtro.getAno());
		calendario.set(Calendar.MONTH, filtro.getMes()-1);
		calendario.set(Calendar.DAY_OF_MONTH, 1);
		calendario.add(Calendar.MONTH, -11);
		
		// variaveis para calcular a tendencia
		List<Double> listMesNumerico = new ArrayList<Double>();
		List<Double> listTaxaUtilizacao = new ArrayList<Double>();
		//List<Double> listMNxTU = new ArrayList<Double>();
		//List<Double> listMN2 = new ArrayList<Double>();
		//List<Double> listTU2 = new ArrayList<Double>();
		
		
		for (int i = 0; i < 12; i++) {
			
			Date inicioM = DataHoraRN.getDataHoraAtual();

			Double horasTrabalhadas = 0d;
			Double horasDisponiveis = 0d;		

			// Para cada maquina, avaliar a taxa de utilizacao no mes avaliado
			for (Ijtbinj ijtbinj : listaIjtbinj) {
				if (ijtbinj.getStinjetora().equals("1"))
					continue;
				//System.out.println("Injetora processada " + ijtbinj.getCdinjestendido());

				Date inicio = DataHoraRN.getInicioMes(calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH)+1);
				Date fim = DataHoraRN.getFimMes(calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH)+1);
				
				String HQL = "";
				
				HQL += "select  sum(segTempotrabalhado) as soma_tempotrabalhado, sum(segTempodisponivel) as soma_tempodisponivel ";
				HQL += "from VMaqDataBi A ";
				HQL += "where A.ijtbinj.cdinjetora = '::cdinjetora' ";
				HQL += "and A.dtReferencia between :dtinicio and :dtfim ";

				HQL = HQL.replaceAll("::cdinjetora", ijtbinj.getCdinjetora());

				List<Object[]> registro = null;

				Query q = getDaoSession().createQuery(HQL);				

					q.setParameter("dtinicio", inicio);
					q.setParameter("dtfim", fim);

				try{
					registro = (List<Object[]>) q.list();
				} catch (Exception e){
					//System.out.println(HQL);
					e.printStackTrace();
				}

				if (registro != null && registro.size() > 0){
					for (Object[] objects : registro) {
						if (objects[1] !=null && ((BigDecimal)objects[1]).doubleValue() != 0) {
							
							horasTrabalhadas += ((BigDecimal)objects[0]).doubleValue();
							horasDisponiveis += ((BigDecimal)objects[1]).doubleValue();	
						}
					}
				}

			}

			TaxaUtilizacaoMesInjetDTO taxa = new TaxaUtilizacaoMesInjetDTO();
			taxa.setAno(calendario.get(Calendar.YEAR));
			taxa.setMes(calendario.get(Calendar.MONTH)+1);

			taxas.add(taxa);
			
			// setando data para calculo da tendencia
			Date dtTendencia = calendario.getTime();

			calendario.add(Calendar.MONTH, 1);

			ElementoDTO elemento = new ElementoDTO();

			elemento.setValor( (horasTrabalhadas / horasDisponiveis) * 100d);				
			elemento.setDtInicial(new Date());
			elemento.setDtFim(new Date());
			elemento.setDescricao(meses[taxa.getMes()-1] + "/" + taxa.getAnoFormatado()); 

			valorMedio += elemento.getValor();
			serie.add(elemento);
			
			// calculos iniciais para a tendencia
			Double mesNumerico = DataHoraRN.getNumDiasFrom1900(dtTendencia); 
			Double taxaUtilizacao = elemento.getValor();
			
			listMesNumerico.add(mesNumerico);
			listTaxaUtilizacao.add(taxaUtilizacao);
			//listMNxTU.add(mesNumerico * taxaUtilizacao);
			//listMN2.add(Math.pow(mesNumerico, 2d));
			//listTU2.add(Math.pow(taxaUtilizacao, 2d));
			
		}
		
		valorMedio /= 12d;
		
		retorno.setTaxas(taxas);
		retorno.setGrafico(new GraficoDTO());
		retorno.getGrafico().add(serie);
		retorno.setValorMedio(valorMedio);
		
		
		serie = new SerieDTO();
		serie.setDescricao("Tend�ncia");
		
		// calculando a tendencia (y = m*x+b)
		Double N = 12d;
		Double somaX = new Double(0);
		Double somaY = new Double(0);
		Double somaXY = new Double(0);
		Double somalX2l = new Double(0);
		Double lsomaXl2 = new Double(0);
		for(int iCont = 0; iCont < N; iCont++) {
			somaX += listMesNumerico.get(iCont);
			somaY += listTaxaUtilizacao.get(iCont);
			
			somaXY += listMesNumerico.get(iCont) * listTaxaUtilizacao.get(iCont);
			//listMNxTU.add(mesNumerico * taxaUtilizacao);
			somalX2l += Math.pow(listMesNumerico.get(iCont), 2d);
			//listMN2.add(Math.pow(mesNumerico, 2d));
			//listTU2.add(Math.pow(taxaUtilizacao, 2d));
		}
		lsomaXl2 = Math.pow(somaX, 2d);
		
		// calculando M (M = (N * somaXY - somaX * somaY) / (N * somalX2l - lsomaXl2))
		Double M = (N * somaXY - somaX * somaY) / (N * somalX2l - lsomaXl2);
		// calculando B (B = (somaY - M * somaX) / N)
		Double B = (somaY - M * somaX) / N;
		// calculando Tendencia (T = M * X + B), para cada ponto X(MN-MesNumerico)
		for(int iCont = 0; iCont < N; iCont++) {
			Double tendencia = M * listMesNumerico.get(iCont) + B;
			
			ElementoDTO elemento = new ElementoDTO();

			elemento.setValor(tendencia);				
			elemento.setDtInicial(new Date());
			elemento.setDtFim(new Date());
			elemento.setDescricao(meses[taxas.get(iCont).getMes()-1] + "/" + taxas.get(iCont).getAnoFormatado()); 
			
			serie.add(elemento);
		}
		
		retorno.getGrafico().add(serie);

		
		return(retorno);

	}

	public List<TrabalhandoOuParadaInjetDTO> getTrabalhandoOuParada(FiltroGalpaoInjetDTO filtro, Session sessao){
		DiversosInjetRN rnDiv = new DiversosInjetRN(getDao());
		rnDiv.setDaoSession(sessao);
		
		List<TrabalhandoOuParadaInjetDTO> retorno = new ArrayList<TrabalhandoOuParadaInjetDTO>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterH = new SimpleDateFormat("HH:mm:ss");

		
		// Obtem o galpao
		String dsGalpao = "";
		dsGalpao = "Desc";
		
		
		// 	Obter a lista de todas as m�quinas ativas do galp�o
		Ijtbinj filtroIjtbinj = new Ijtbinj();
		filtroIjtbinj.setStinjetora(0);
		filtroIjtbinj.setIjgalobjs(new HashSet<Ijgalobj>());
		Ijgalobj ijgalobj = new Ijgalobj();
		ijgalobj.setIjtbgal(new Ijtbgal());
		ijgalobj.getIjtbgal().setCdgalpao(filtro.getCdGalpao());
		filtroIjtbinj.getIjgalobjs().add(ijgalobj);

		List<Ijtbinj> listaIjtbinj = rnDiv.pesquisarIjtbinj(filtroIjtbinj);

		// Obtem o turno atual e data de referencia atual
		Ijtreal ijtreal = rnDiv.pesquisarIjtreal();


		//	Para cada m�quina, avaliar o percentual de crescimento, obtendo os dados do m�s atual e do m�s anterior
		for (Ijtbinj ijtbinj : listaIjtbinj) {			

			// Obter um registro em IJRT 
			Ijrt filtroIjRT = new Ijrt();
			filtroIjRT.setIjtbinj(new Ijtbinj());
			filtroIjRT.getIjtbinj().setCdinjetora(ijtbinj.getCdinjetora());
			filtroIjRT.setDtReferencia(ijtreal.getId().getDtrefturno());
			Ijtbtur ijtbtur = new Ijtbtur();
			ijtbtur.setCdturno(ijtreal.getId().getCdturno());
			filtroIjRT.setIjtbtur(ijtbtur);

			List<Ijrt> listaIjRT = rnDiv.pesquisarIjRT(filtroIjRT);

			Ijrt ijRT = null;
			if (listaIjRT.size() > 0){
				ijRT = listaIjRT.get(0);

				Double oee = 0d;

				if (ijRT.getVMaqDataBi() != null){
					oee = (ijRT.getVMaqDataBi().getSegTempotrabalhado().doubleValue() / ijRT.getVMaqDataBi().getSegTempodisponivel().doubleValue())*100;
				}				

				TrabalhandoOuParadaInjetDTO maquina = new TrabalhandoOuParadaInjetDTO();
				maquina.setDsGalpao(dsGalpao);
				maquina.setOee(oee);
				maquina.setCdMaqEstendido(ijtbinj.getCdinjestendido());
				try{
					String cdMoldeAtual = "";
					if (ijtbinj.getCdmoldeatual() != null)
						cdMoldeAtual = ijtbinj.getCdmoldeatual();
					maquina.setCdMolEstendido(rnDiv.pesquisarIjtbmol(cdMoldeAtual).getCdmolestendido());
				}catch (Exception e) {
					maquina.setCdMolEstendido("");
				}

				if (ijRT.getIjtbpar() != null){
					maquina.setCdParada(ijRT.getIjtbpar().getCdparada());
					maquina.setDsParada(ijRT.getIjtbpar().getDsparada());
					maquina.setDsArea(ijRT.getIjtbpar().getIjareres().getDsarea());					

				}else{
					maquina.setCdParada("");
					maquina.setDsParada("");
					maquina.setDsArea("");
				}

				if (ijRT.getDthriparada() != null){
					maquina.setDthrIParada(formatter.format(ijRT.getDthriparada()) + " - " + formatterH.format(ijRT.getDthriparada()));
				}else{
					maquina.setDthrIParada("");
				}

				maquina.setDuracao(DataHoraRN.getSegundosParaHoraFormata(ijRT.getDuracao().intValue()));

				maquina.setStFuncionamento(ijRT.getStfuncionamento().toString());

				retorno.add(maquina);
			}
		}		

		// Ordenar a maquina numericamente
		Collections.sort(retorno, new Comparator<Object>(){
			public int compare(Object o1, Object o2) {
				int retorno = 0;

				TrabalhandoOuParadaInjetDTO dadosUm = (TrabalhandoOuParadaInjetDTO) o1;
				TrabalhandoOuParadaInjetDTO dadosDois = (TrabalhandoOuParadaInjetDTO) o2;

				try{
					retorno = (Integer.valueOf(dadosUm.getCdMaqEstendido()) < Integer.valueOf(dadosDois.getCdMaqEstendido()) ? 0:1);
				} catch (Exception e){
					retorno = 0;
				}
				return retorno;
			}
		});


		return retorno;

	}

	public OEEGalpoesInjetDTO getOEETotalGalpoes(FiltroGalpaoInjetDTO filtro){
		DiversosInjetRN rnDiv = new DiversosInjetRN(getDao());
		rnDiv.setDaoSession(getDaoSession());
		OEEGalpoesInjetDTO retorno = new OEEGalpoesInjetDTO();
		List<OEETotalGalpaoInjetDTO> retornoLista = new ArrayList<OEETotalGalpaoInjetDTO>();		

		// 	Obter a lista de todas os galp�es do galp�o
		Ijgalobjgal filtroIjgalobjgal = new Ijgalobjgal();
		filtroIjgalobjgal.setId(new IjgalobjgalId());
		filtroIjgalobjgal.getId().setCdgalpao(filtro.getCdGalpao());
		List<Ijgalobjgal> listaIjgalobjgal = rnDiv.pesquisarIjgalobjgal(filtroIjgalobjgal);

		//	Para cada m�quina, avaliar o percentual de crescimento, obtendo os dados do m�s atual e do m�s anterior
		int linha = 1;
		int coluna = 0;
		for (Ijgalobjgal ijgalobjgal : listaIjgalobjgal) {				
			coluna++;
			if (coluna>3){
				linha++;
				coluna=1;
			}		
			
			Double oee = rnDiv.getOEEGalpao(ijgalobjgal.getIjtbgalByCdgalpaoobj().getCdgalpao());

			OEETotalGalpaoInjetDTO galpao = new OEETotalGalpaoInjetDTO();
			galpao.setCoordX(BigDecimal.valueOf(coluna));
			galpao.setCoordY(BigDecimal.valueOf(linha));
			galpao.setCdGalpao(ijgalobjgal.getIjtbgalByCdgalpaoobj().getCdgalpao());
			galpao.setDsGalpao(ijgalobjgal.getIjtbgalByCdgalpaoobj().getDsgalpao());
			galpao.setMetaOEEMin(new BigDecimal(ijgalobjgal.getIjtbgalByCdgalpaoobj().getMetaoeemin()));
			galpao.setMetaOEEMax(new BigDecimal(ijgalobjgal.getIjtbgalByCdgalpaoobj().getMetaoeemax()));
			galpao.setOee(oee);
			galpao.setQuantidadeMaquinas(ijgalobjgal.getIjtbgalByCdgalpaoobj().getIjgalobjs().size());
			
			if (linha > retorno.getMaxLinha())
				retorno.setMaxLinha(linha);
			if (coluna > retorno.getMaxColuna())
				retorno.setMaxColuna(coluna);
			

			retornoLista.add(galpao);		

		}				

		retorno.setGalpoes(retornoLista);
		return retorno;

	}
	
	public OEEGalpoesInjetDTO getOEETotalGalpoesmtrz(FiltroGalpaoInjetDTO filtro){
		DiversosInjetRN rnDiv = new DiversosInjetRN(getDao());
		rnDiv.setDaoSession(getDaoSession());
		OEEGalpoesInjetDTO retorno = new OEEGalpoesInjetDTO();
		List<OEETotalGalpaoInjetDTO> retornoLista = new ArrayList<OEETotalGalpaoInjetDTO>();		

		// 	Obter a lista de todas os galp�es do galp�o
		Ijgalobjgalmtrz filtroIjgalobjgalmtrz = new Ijgalobjgalmtrz();
		filtroIjgalobjgalmtrz.setId(new IjgalobjgalmtrzId());
		filtroIjgalobjgalmtrz.getId().setCdgalpao(filtro.getCdGalpao());
		List<Ijgalobjgalmtrz> listaIjgalobjgalmtrz = rnDiv.pesquisarIjgalobjgalmtrz(filtroIjgalobjgalmtrz);

		//	Para cada m�quina, avaliar o percentual de crescimento, obtendo os dados do m�s atual e do m�s anterior
		for (Ijgalobjgalmtrz ijgalobjgalmtrz : listaIjgalobjgalmtrz) {			
								
			Double oee = rnDiv.getOEEGalpao(ijgalobjgalmtrz.getIjtbgalByCdgalpaoobj().getCdgalpao());

			OEETotalGalpaoInjetDTO galpao = new OEETotalGalpaoInjetDTO();
			galpao.setCoordX(ijgalobjgalmtrz.getCoordcoluna());
			galpao.setCoordY(ijgalobjgalmtrz.getCoordlinha());
			galpao.setCdGalpao(ijgalobjgalmtrz.getIjtbgalByCdgalpaoobj().getCdgalpao());
			galpao.setDsGalpao(ijgalobjgalmtrz.getIjtbgalByCdgalpaoobj().getDsgalpao());
			galpao.setMetaOEEMin(new BigDecimal(ijgalobjgalmtrz.getIjtbgalByCdgalpaoobj().getMetaoeemin()));
			galpao.setMetaOEEMax(new BigDecimal(ijgalobjgalmtrz.getIjtbgalByCdgalpaoobj().getMetaoeemax()));
			galpao.setOee(oee);
			galpao.setQuantidadeMaquinas(ijgalobjgalmtrz.getIjtbgalByCdgalpaoobj().getIjgalobjs().size());
			
			if (ijgalobjgalmtrz.getCoordlinha().intValue() > retorno.getMaxLinha())
				retorno.setMaxLinha(ijgalobjgalmtrz.getCoordlinha().intValue());
			if (ijgalobjgalmtrz.getCoordcoluna().intValue() > retorno.getMaxColuna())
				retorno.setMaxColuna(ijgalobjgalmtrz.getCoordcoluna().intValue());
			

			retornoLista.add(galpao);		

		}				

		retorno.setGalpoes(retornoLista);
		return retorno;

	}
}