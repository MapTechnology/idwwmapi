package idw.model.rn.consolidacao.estoque;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolestlocalproDAO;
import idw.model.dao.DwConsolestlocalprotempDAO;
import idw.model.dao.DwEstlocalproDAO;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwConsolestlocalpro;
import idw.model.pojos.DwConsolestlocalprotemp;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwEstMovTemplate.TpOrigem;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.estoque.EstoqueRN;
import idw.model.rn.estoque.LocalEstoquePaRN;
import idw.model.rn.estoque.TipoAjusteEstoque;
import idw.util.CompareUtils;
import idw.util.IdwLogger;
import idw.webservices.dto.TurnoAtualDTO;

public class ConsolidacaoLocalEstoque extends AbstractRN<DAOGenerico> {

	public ConsolidacaoLocalEstoque(DAOGenerico dao) {
		super(dao);
	}

	/*
	 * Metodo principal da classe
	 */
	public void consolidarTabelaTemporariaLocalEstoque(IdwLogger log, int idLog, int qtdRegistros) {
		DwConsolestlocalprotempDAO dwConsolestlocalprotempDAO = new DwConsolestlocalprotempDAO(this.getDaoSession());

		List<DwConsolestlocalprotemp> listConsolestlocalprotemp = dwConsolestlocalprotempDAO.getDwConsolestlocalprotemp(qtdRegistros);

		for (DwConsolestlocalprotemp dwConsolestlocalprotemp : listConsolestlocalprotemp) {

			TipoAjusteEstoque tipoAjusteEstoque = TipoAjusteEstoque.getTipoAjusteEstoque(dwConsolestlocalprotemp.getTpAjusteestoque());

			DwEstlocalpro dwEstlocalpro = dwConsolestlocalprotemp.getDwEstlocalpro();
			BigDecimal qt = dwConsolestlocalprotemp.getQt();
			DwCal dwCal = dwConsolestlocalprotemp.getDwCal();
			DwTurno dwTurno = dwConsolestlocalprotemp.getDwTurno();
			Date dthrIturno = dwConsolestlocalprotemp.getDthrIturno();
			Date dthrFturno = dwConsolestlocalprotemp.getDthrFturno();
			Date dthr = dwConsolestlocalprotemp.getDthr();
			Date dtReferencia = dwConsolestlocalprotemp.getDtReferencia();
			OmUsr omUsr = dwConsolestlocalprotemp.getOmUsr();

			boolean isGeraMov = tipoAjusteEstoque.equals(TipoAjusteEstoque.CONSUMO_POR_CICLO) == false && tipoAjusteEstoque.equals(TipoAjusteEstoque.CONSUMO_POR_PERDA) == false;

			if (
					tipoAjusteEstoque.equals(TipoAjusteEstoque.CONSUMO_POR_CICLO) || 
					tipoAjusteEstoque.equals(TipoAjusteEstoque.CONSUMO_POR_PERDA) || 
					tipoAjusteEstoque.equals(TipoAjusteEstoque.SAIDA)) {

				if (qt == null)
					System.out.println("qt null");
				if (dwEstlocalpro != null && CompareUtils.compareTo(dwEstlocalpro.getQtTotal(), qt) < 0) {
					BigDecimal diff = qt.subtract(dwEstlocalpro.getQtTotal());
					consolidarLocalEstoqueQuantidade(log, idLog, dwCal, dwTurno,
							dtReferencia, dthrIturno, dthrFturno,
							dwEstlocalpro, diff, TipoAjusteEstoque.AJUSTE,
							dthr, omUsr, isGeraMov);

				}

			}

			consolidarLocalEstoqueQuantidade(log, idLog, dwCal, dwTurno, dtReferencia,
					dthrIturno, dthrFturno, dwEstlocalpro, qt,
					tipoAjusteEstoque, dthr, omUsr, isGeraMov);

			dwConsolestlocalprotempDAO.excluir(dwConsolestlocalprotemp);

		}

	}

	
	public TurnoAtualDTO getTurnoAtualDTO(DwEstlocal dwEstlocal, Date data) throws SemCalendarioException {
		TurnoRN turnoRN = new TurnoRN(getDao());
		TurnoAtualDTO turnoAtualDTO = null;

		if (dwEstlocal.getOmPt() != null) {
			turnoAtualDTO = turnoRN.getTurnoAtualDTOSemClone(dwEstlocal.getOmPt(), data);
		} else if (dwEstlocal.getOmGt() != null) {
			turnoAtualDTO = turnoRN.getTurnoAtualGtDTO(dwEstlocal.getOmGt(), data, true);
		}

		if (turnoAtualDTO == null) {
			turnoAtualDTO = turnoRN.getTurnoAtualDTOComCalendarioIndefinido(data);
		}

		return turnoAtualDTO;

	}

	/* Alessandre em 10-02-16 comentei pois aparentemente nao esta sendo usado
	public void consolidarLocalEstoqueConsumoOuPerdaMP(
			IdwLogger log, int idLog,
			TipoAjusteEstoque tipoAjusteEstoque, TurnoAtualDTO turnoAtualDTO,
			OmCfg omCfg, OmPt omPt, OmPa omPa, OmProduto omProduto,	BigDecimal qtdConsumida, BigDecimal qtdAtualPosicao, 
			Date data) {

		DwEst dwEstAlimentacao = omCfg.getDwEstByIdEstAlimentacao();
		OmUsr omUsr = omCfg.getOmUsrimpprog();

		LocalEstoquePaRN localEstoquePaRN = new LocalEstoquePaRN(getDao());
		DwEstlocal dwEstlocal = localEstoquePaRN.getDwEstlocalAlimentacaoCriaSenaoExistir(dwEstAlimentacao,
						omPt, omPa, omUsr, data);

		EstoqueRN estoqueRN = new EstoqueRN(getDao());
		DwEstpro dwEstpro = estoqueRN.getDwEstproSenaoExistirCriar(omProduto, dwEstAlimentacao);

		DwEstlocalproDAO dwEstlocalproDAO = new DwEstlocalproDAO(getDaoSession());
		DwEstlocalpro dwEstlocalpro = dwEstlocalproDAO.getDwEstlocalproSenaoExistirCriar(dwEstlocal, dwEstpro, null);

		boolean isDwEstlocalproEhNovoQuantidadeZerada = CompareUtils.equals(dwEstlocalpro.getQtTotal(), BigDecimal.ZERO);
		if (isDwEstlocalproEhNovoQuantidadeZerada) {
			consolidarLocalEstoqueAjuste(log, idLog, turnoAtualDTO, omCfg, dwEstlocalpro, qtdAtualPosicao, data, omUsr);
		}

		boolean isQtAtualMenorQueConsumo = CompareUtils.compareTo(
				qtdAtualPosicao, qtdConsumida) < 0;
		if (isQtAtualMenorQueConsumo) {
			consolidarLocalEstoqueAjuste(log, idLog, turnoAtualDTO, omCfg, dwEstlocalpro, qtdConsumida, data, omUsr);
		}

		consolidarLocalEstoqueQuantidade(log, idLog, turnoAtualDTO.getDwcal(),
				turnoAtualDTO.getDwturno(), turnoAtualDTO.getDtReferencia(),
				turnoAtualDTO.getDtHrITurno(), turnoAtualDTO.getDtHrFTurno(),
				dwEstlocalpro, qtdConsumida, tipoAjusteEstoque, data, omUsr,
				false);

	}*/

	public void consolidarLocalEstoqueConsumoOuPerdaMPThreadSafe(
			TipoAjusteEstoque tipoAjusteEstoque, TurnoAtualDTO turnoAtualDTO,
			OmCfg omCfg, OmPt omPt, OmPa omPa, OmProduto omProduto,
			BigDecimal qtdConsumida, BigDecimal qtdAtualPosicao, Date data) {

		DwEst dwEstAlimentacao = omCfg.getDwEstByIdEstAlimentacao();
		OmUsr omUsr = omCfg.getOmUsrimpprog();

		LocalEstoquePaRN localEstoquePaRN = new LocalEstoquePaRN(getDao());
		DwEstlocal dwEstlocal = localEstoquePaRN.getDwEstlocalAlimentacaoCriaSenaoExistir(dwEstAlimentacao,
						omPt, omPa, omUsr, data);

		EstoqueRN estoqueRN = new EstoqueRN(getDao());
		DwEstpro dwEstpro = estoqueRN.getDwEstproSenaoExistirCriar(omProduto, dwEstAlimentacao);

		DwEstlocalproDAO dwEstlocalproDAO = new DwEstlocalproDAO(getDaoSession());
		DwEstlocalpro dwEstlocalpro = dwEstlocalproDAO.getDwEstlocalproSenaoExistirCriar(dwEstlocal, dwEstpro, null);

		Integer ano = DataHoraRN.getAno(turnoAtualDTO.getDtReferencia());
		Integer mes = DataHoraRN.getMes(turnoAtualDTO.getDtReferencia());
		DwConsolestlocalprotempDAO dwConsolestlocalprotempDAO = new DwConsolestlocalprotempDAO(getDaoSession());

		dwConsolestlocalprotempDAO.incluirDwConsolestlocalprotemp(
				turnoAtualDTO.getDwcal(), turnoAtualDTO.getDwturno(),
				turnoAtualDTO.getDtReferencia(), dwEstlocalpro,
				turnoAtualDTO.getDtHrITurno(), turnoAtualDTO.getDtHrFTurno(),
				ano, mes, tipoAjusteEstoque.getId(), qtdConsumida, omUsr, data);


	}


	public void consolidarLocalEstoqueEntrada(
			IdwLogger log, int idLog,
			OmCfg omCfg,
			TurnoAtualDTO turnoAtualDTO, DwEstlocal dwEstlocal,
			OmProduto omProduto, BigDecimal qtEntrada, Date data, OmUsr omUsr) {

		EstoqueRN estoqueRN = new EstoqueRN(getDao());

		DwEstpro estpro = estoqueRN.getDwEstproSenaoExistirCriar(omProduto,
				dwEstlocal.getDwEst());

		DwEstlocalproDAO estlocalproDAO = new DwEstlocalproDAO(getDaoSession());
		DwEstlocalpro dwEstlocalpro = estlocalproDAO
				.getDwEstlocalproSenaoExistirCriar(dwEstlocal, estpro, null);

		consolidarLocalEstoqueEntrada(log, idLog, turnoAtualDTO, omCfg, dwEstlocalpro,
				qtEntrada, data, omUsr);

	}

	public void consolidarLocalEstoqueEntrada(
			IdwLogger log, int idLog,
			TurnoAtualDTO turnoAtualDTO,
			OmCfg omCfg, DwEstlocalpro dwEstlocalpro, BigDecimal qtdEntrada,
			Date data, OmUsr omUsr) {

		consolidarLocalEstoqueQuantidade(log, idLog, turnoAtualDTO.getDwcal(),
				turnoAtualDTO.getDwturno(), turnoAtualDTO.getDtReferencia(),
				turnoAtualDTO.getDtHrITurno(), turnoAtualDTO.getDtHrFTurno(),
				dwEstlocalpro, qtdEntrada, TipoAjusteEstoque.ENTRADA, data,
				omUsr, true);

	}

	public void consolidarLocalEstoqueSaidaFazAjusteSeQtdMaiorQueTotal(
			IdwLogger log, int idLog,
			TurnoAtualDTO turnoAtualDTO, OmCfg omCfg,
			DwEstlocalpro dwEstlocalpro, BigDecimal qtdSaida, Date data,
			OmUsr omUsr) {

		log.info(idLog, 0, "vou chamar fazerAjusteSeQtdSaidaMaiorQueTotal");
		fazerAjusteSeQtdSaidaMaiorQueTotal(log, idLog, turnoAtualDTO, omCfg, dwEstlocalpro, qtdSaida, data, omUsr);

		log.info(idLog, 0, "vou chamar consolidarLocalEstoqueQuantidade");
		consolidarLocalEstoqueQuantidade(log, idLog, turnoAtualDTO.getDwcal(),
				turnoAtualDTO.getDwturno(), turnoAtualDTO.getDtReferencia(),
				turnoAtualDTO.getDtHrITurno(), turnoAtualDTO.getDtHrFTurno(),
				dwEstlocalpro, qtdSaida, TipoAjusteEstoque.SAIDA, data, omUsr,
				true);

	}

	public void consolidarLocalEstoqueAjuste(IdwLogger log, int idLog, TurnoAtualDTO turnoAtualDTO,
			OmCfg omCfg, DwEstlocalpro dwEstlocalpro, BigDecimal qtdAjuste,
			Date data, OmUsr omUsr) {

		consolidarLocalEstoqueQuantidade(log, idLog, turnoAtualDTO.getDwcal(),
				turnoAtualDTO.getDwturno(), turnoAtualDTO.getDtReferencia(),
				turnoAtualDTO.getDtHrITurno(), turnoAtualDTO.getDtHrFTurno(),
				dwEstlocalpro, qtdAjuste, TipoAjusteEstoque.AJUSTE, data,
				omUsr, true);

	}

	private void fazerAjusteSeQtdSaidaMaiorQueTotal(
			IdwLogger log, int idLog,
			TurnoAtualDTO turnoAtualDTO, OmCfg omCfg,
			DwEstlocalpro dwEstlocalpro, BigDecimal qtdSeraRemovida, Date data,
			OmUsr omUsr) {

		BigDecimal qtDiff = qtdSeraRemovida.subtract(dwEstlocalpro.getQtTotal());
		if (CompareUtils.compareTo(qtDiff, BigDecimal.ZERO) > 0) {
			log.info(idLog, 0, "vou chamar consolidarLocalEstoqueAjuste pois qtDiff=" + qtDiff.intValue());
			consolidarLocalEstoqueAjuste(log, idLog, turnoAtualDTO, omCfg, dwEstlocalpro, qtDiff, data, omUsr);
		} else {
			log.info(idLog, 0, "Nao chamei consolidarLocalEstoqueAjuste");
		}

	}

	private void consolidarLocalEstoqueQuantidade(
			IdwLogger log, int idLog,
			DwCal dwCal, DwTurno dwTurno,
			Date dtReferencia, Date dthrIturno, Date dthrFturno,
			DwEstlocalpro dwEstlocalpro, BigDecimal qtd,
			TipoAjusteEstoque tipoAjusteEstoque, Date data, OmUsr omUsr,
			boolean isGerarMov) {

		DwConsolestlocalproDAO dwConsolestlocalproDAO = new DwConsolestlocalproDAO(getDaoSession());

		DwConsolestlocalpro dwConsolestlocalpro = null;

		if (dwEstlocalpro != null && dwEstlocalpro.getQtSaida() != null && dwEstlocalpro.getQtSaida().doubleValue() > 0 && dwEstlocalpro.getDwEstlocal().getOmPt() != null) {
			log.info(idLog, 0, "Entrei no 1o if");
			dwConsolestlocalpro = dwConsolestlocalproDAO.getDwConsolestlocalpro(dwCal, dwTurno, dtReferencia, dwEstlocalpro);

			// se n�o encontrar, procura o último registro válido para a máquina, produto e posi��oo
			if (dwConsolestlocalpro == null) {
				log.info(idLog, 0, "Entrei no 1.1o if");
				dwConsolestlocalpro = dwConsolestlocalproDAO.getDwConsolestlocalproUltimoRegistroValido(dwEstlocalpro, dwEstlocalpro.getDwEstlocal().getTpLocalEstoque());
				
				//Caso o calendário, ou turno, ou data de referência sejam diferentes, cria-se um novo registro de consolida��oo
				if (dwConsolestlocalpro == null || dwConsolestlocalpro.getDwCal() != dwCal || dwConsolestlocalpro.getDwTurno() != dwTurno  || dwConsolestlocalpro.getDtReferencia() != dtReferencia) {
					log.info(idLog, 0, "Entrei no 1.1.1o if");
					//preserva as quantidades de entrada e saída encontradas para realizar os cálculos
					BigDecimal qtEntradaEncontrada = BigDecimal.ZERO;
					BigDecimal qtSaidaEncontrada = BigDecimal.ZERO;
					if (dwConsolestlocalpro != null) {
						qtEntradaEncontrada = dwConsolestlocalpro.getQtEntrada();
						qtSaidaEncontrada = dwConsolestlocalpro.getQtSaida();
					}
					dwConsolestlocalpro = dwConsolestlocalproDAO.getDwConsolestlocalproSenaoExistirCriar(dwCal,	dwTurno, dtReferencia, dwEstlocalpro, dthrIturno, dthrFturno);
					
					//seta o novo registro com as quantidades de etrada e saída encontradas
					dwConsolestlocalpro.setQtEntrada(qtEntradaEncontrada);
					dwConsolestlocalpro.setQtSaida(qtSaidaEncontrada);
				}
			}

		} else if(dwEstlocalpro != null && dwEstlocalpro.getDwEstlocal().getTpLocalEstoque() != null &&
				dwEstlocalpro.getDwEstlocal().getTpLocalEstoque() == 2 &&
				dwEstlocalpro.getDwEstlocal().getOmPt() != null){
			log.info(idLog, 0, "Entrei no 2o if");

			//encontra o último registro de desalimenta��oo válido
			dwConsolestlocalpro = dwConsolestlocalproDAO.getDwConsolestlocalproUltimoRegistroValido(dwEstlocalpro, dwEstlocalpro.getDwEstlocal().getTpLocalEstoque());
			
			//Caso o calendário, ou turno, ou data de referência sejam diferentes, cria-se um novo registro de consolida��oo
			if (
					(dwConsolestlocalpro != null && dwConsolestlocalpro.getDwCal() != null && dwConsolestlocalpro.getDwCal() != dwCal) || 
					(dwConsolestlocalpro != null && dwConsolestlocalpro.getDwTurno() != null && dwConsolestlocalpro.getDwTurno() != dwTurno) || 
					(dwConsolestlocalpro != null && dwConsolestlocalpro.getDtReferencia() != null && dwConsolestlocalpro.getDtReferencia() != dtReferencia) ) {
				log.info(idLog, 0, "Entrei no 2.1o if");
				//preserva a quantidade de entrada encontrada para realizar os cálculos
				BigDecimal qtEntradaEncontrada = dwConsolestlocalpro.getQtEntrada();
				
				dwConsolestlocalpro = dwConsolestlocalproDAO.getDwConsolestlocalproSenaoExistirCriar(dwCal,	dwTurno, dtReferencia, dwEstlocalpro, dthrIturno, dthrFturno);
				
				//seta o novo registro com as quantidades de etrada e saída encontradas
				dwConsolestlocalpro.setQtEntrada(qtEntradaEncontrada);
			}
		} else {
			log.info(idLog, 0, "Entrei no else");
			dwConsolestlocalpro = dwConsolestlocalproDAO.getDwConsolestlocalproSenaoExistirCriar(dwCal, dwTurno, dtReferencia, dwEstlocalpro, dthrIturno, dthrFturno);
		}
		
		if (dwConsolestlocalpro == null) {
			log.info(idLog, 0, "dwConsolestlocalpro = null");
			dwConsolestlocalpro = dwConsolestlocalproDAO.getDwConsolestlocalproSenaoExistirCriar(dwCal, dwTurno, dtReferencia, dwEstlocalpro, dthrIturno, dthrFturno);
		}

		EstoqueRN estoqueRN = new EstoqueRN(getDao());

		switch (tipoAjusteEstoque) {
		case AJUSTE:
			log.info(idLog, 0, "entrei em AJUSTE");
			dwConsolestlocalpro.setQtAjuste(dwConsolestlocalpro.getQtAjuste().add(qtd));
			estoqueRN.atualizarEstoqueProduto(dwEstlocalpro.getDwEstpro(), dwEstlocalpro, qtd, BigDecimal.ZERO, BigDecimal.ZERO, data, omUsr, isGerarMov, TpOrigem.CHECKLEVEL);
			break;

		case ENTRADA:
			log.info(idLog, 0, "entrei em ENTRADA");
			dwConsolestlocalpro.setQtEntrada(dwConsolestlocalpro.getQtEntrada().add(qtd));
			estoqueRN.atualizarEstoqueProduto(dwEstlocalpro.getDwEstpro(),
					dwEstlocalpro, BigDecimal.ZERO, qtd, BigDecimal.ZERO, data,
					omUsr, isGerarMov, TpOrigem.CHECKLEVEL);
			break;

		case SAIDA:
			log.info(idLog, 0, "entrei em SAIDA");
			dwConsolestlocalpro.setQtSaida(dwConsolestlocalpro.getQtSaida().add(qtd));
			estoqueRN.atualizarEstoqueProduto(dwEstlocalpro.getDwEstpro(),
					dwEstlocalpro, BigDecimal.ZERO, BigDecimal.ZERO, qtd, data,
					omUsr, isGerarMov, TpOrigem.CHECKLEVEL);
			break;

		case CONSUMO_POR_CICLO:
			log.info(idLog, 0, "entrei em CONSUMO_POR_CICLO");
			dwConsolestlocalpro.setQtConsumida(dwConsolestlocalpro.getQtConsumida().add(qtd));
			estoqueRN.atualizarEstoqueProduto(dwEstlocalpro.getDwEstpro(),
					dwEstlocalpro, BigDecimal.ZERO, BigDecimal.ZERO, qtd, data,
					omUsr, isGerarMov, TpOrigem.CHECKLEVEL);
			break;

		case CONSUMO_POR_PERDA:
			log.info(idLog, 0, "entrei em CONSUMO_POR_PERDA");
			dwConsolestlocalpro.setQtPerda(dwConsolestlocalpro.getQtPerda().add(qtd));
			estoqueRN.atualizarEstoqueProduto(dwEstlocalpro.getDwEstpro(),
					dwEstlocalpro, BigDecimal.ZERO, BigDecimal.ZERO, qtd, data,
					omUsr, isGerarMov, TpOrigem.CHECKLEVEL);
			break;

		}

		BigDecimal qtTotal = calcularTotal(dwConsolestlocalpro.getQtEntrada(),
				dwConsolestlocalpro.getQtSaida(),
				dwConsolestlocalpro.getQtAjuste(),
				dwConsolestlocalpro.getQtConsumida(),
				dwConsolestlocalpro.getQtPerda());
		dwConsolestlocalpro.setQtTotal(qtTotal);

		log.info(idLog, 0, "makePersiste em dwCOnsolestlocalpro");
		getDao().makePersistent(dwConsolestlocalpro);

	}

	private BigDecimal calcularTotal(BigDecimal qtEntrada, BigDecimal qtSaida,
			BigDecimal qtAjuste, BigDecimal qtConsumida, BigDecimal qtPerdida) {
		return qtEntrada.add(qtAjuste).subtract(qtSaida).subtract(qtConsumida)
				.subtract(qtPerdida);
	}

}
