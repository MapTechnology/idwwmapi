package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import org.apache.commons.lang3.Validate;

import idw.model.IPojoMAP;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRota;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpPlano;

public abstract class PpCpTemplate extends AbstractTemplate<PpCp> implements IPojoMAP {

	public final static String _FIELD_NAME_CD = "CdCp";

	public enum StCp {
		CADASTRADA(0), FIRMADA(1), SUSPENSA(2), CANCELADA(3), CONCLUIDA(4), EMSETUP(5), INICIADA(6);
		private final int value;

		StCp(int value) {
			this.value = value;
		}

		public boolean equals(Integer stCp) {
			return stCp != null && stCp.equals(value);
		}

		public int getValue() {
			return this.value;
		}
	}
	
	public enum TpCp {
		PRODUCAO(0), RETRABALHO(1), TRANSFORMACAO(2);
		private final int value;

		TpCp(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}
	}


	/**
	 * Pega o produto que está na {PpCp} baseado no seu código
	 * 
	 * @param cdProduto
	 * @return PpCpproduto
	 */
	public PpCpproduto getPpCpproduto(String cdProduto) {
		Validate.notBlank(cdProduto, "codigo do produto vazio");
		if (getInstanceT().getPpCpprodutos() != null) {
			for (PpCpproduto ppCpproduto : getInstanceT().getPpCpprodutos()) {
				if (ppCpproduto.getOmProduto().getCdProduto().equals(cdProduto)) {
					return ppCpproduto;
				}
			}
		}
		return null;
	}

	/*
	 * Obtem o numero da op
	 * 
	 */
	public String getNrop() {
		if (getInstanceT().getPpCpprodutos() != null) {
			for (PpCpproduto ppCpproduto : getInstanceT().getPpCpprodutos()) {
				if (ppCpproduto.getNrDoc() != null && ppCpproduto.getNrDoc().equals("") == false)
					return ppCpproduto.getNrDoc();
			}
		}
		return "";
	}

	/**
	 * Pega o total de pecas a produzir de todos os produtos
	 * 
	 * @return
	 */
	public double getQtPecasProduzir() {
		PpCp ppCp = (PpCp) this;
		double retorno = 0;
		for (PpCpproduto ppCpproduto : ppCp.getPpCpprodutos()) {
			if (ppCpproduto.getPcsProducaoplanejada() != null) {
				retorno += ppCpproduto.getPcsProducaoplanejada().doubleValue();
			}
		}
		return retorno;
	}

	public double getSaldoAProduzir() {
		PpCp ppCp = (PpCp) this;
		double retorno = 0;
		double producaoBruta = 0d;
		double producaoRefugada = 0d;
		double producaoPlanejada = 0d;
		for (PpCpproduto ppCpproduto : ppCp.getPpCpprodutos()) {
			if (ppCpproduto.getPcsProducaoplanejada() != null)
				producaoPlanejada += ppCpproduto.getPcsProducaoplanejada().doubleValue();
			if (ppCpproduto.getPcsProducaobruta() != null)
				producaoBruta += ppCpproduto.getPcsProducaobruta().doubleValue();
			if (ppCpproduto.getPcsProducaorefugada() != null)
				producaoRefugada += ppCpproduto.getPcsProducaorefugada().doubleValue();
		}
		retorno = producaoPlanejada - (producaoBruta - producaoRefugada);
		return retorno;
	}

	public double getProducaoBruta() {
		PpCp ppCp = (PpCp) this;
		double retorno = 0;
		for (PpCpproduto ppCpproduto : ppCp.getPpCpprodutos()) {
			if (ppCpproduto.getPcsProducaobruta() != null)
				retorno = +ppCpproduto.getPcsProducaobruta().doubleValue();
		}
		return retorno;
	}

	public double getProducaoRefugada() {
		PpCp ppCp = (PpCp) this;
		double retorno = 0;
		for (PpCpproduto ppCpproduto : ppCp.getPpCpprodutos()) {
			if (ppCpproduto.getPcsProducaorefugada() != null)
				retorno = +ppCpproduto.getPcsProducaorefugada().doubleValue();
		}
		return retorno;
	}

	@Override
	public Long getId() {
		return getInstanceT().getIdCp();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdCp(id);
	}

	@Override
	public String getCd() {
		return ((PpCp) this).getCdCp();
	}

	@Override
	public String getFieldNameCd() {
		return PpCpTemplate._FIELD_NAME_CD;
	}

	@Override
	protected PpCp atribuir(PpCp from, PpCp to, boolean isCopiarFK) {
		if (to == null) {
			to = new PpCp();
		}

		to.setIdCp(from.getIdCp());
		to.setCdCp(from.getCdCp());
		to.setDthrInicio(from.getDthrInicio());
		to.setDthrFinal(from.getDthrFinal());
		to.setDthrInicioreal(from.getDthrInicioreal());
		to.setDthrFinalreal(from.getDthrFinalreal());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setIsAntecipacao(from.getIsAntecipacao());
		to.setIsBarrasete(from.getIsBarrasete());
		to.setIsCm(from.getIsCm());
		to.setIsFinalserie(from.getIsFinalserie());
		to.setIsMassa(from.getIsMassa());
		to.setIsTryout(from.getIsTryout());
		to.setIsFaltamp(from.getIsFaltamp());
		to.setPrioridade(from.getPrioridade());
		to.setRevisao(from.getRevisao());
		to.setIsApAberta(from.getIsApAberta());
		to.setStAtivo(from.getStAtivo());
		to.setStCp(from.getStCp());
		to.setTpCp(from.getTpCp());
		to.setPasso(from.getPasso());
		to.setDthrIsetup(from.getDthrIsetup());
		to.setDthrFsetup(from.getDthrFsetup());
		to.setNrLoteMp(from.getNrLoteMp());
		to.setDtLoteMp(from.getDtLoteMp());

		if (isCopiarFK) {
			if (from.getDwCal() != null) {
				to.setDwCal((DwCal) from.getDwCal().clone());
			}
			if (from.getDwFolha() != null) {
				to.setDwFolha(from.getDwFolha().clone(false));
			}
			if (from.getDwRota() != null) {
				to.setDwRota(from.getDwRota().clone(false));
			}
			if (from.getDwEst() != null) {
				to.setDwEst(from.getDwEst().clone(false));
			}
			if (from.getOmPt() != null) {
				to.setOmPt(from.getOmPt().clone(false));
			}
			if (from.getOmGt() != null) {
				to.setOmGt(from.getOmGt().clone(false));
			}
			if (from.getOmUsrByIdUsrrevisao() != null) {
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao().clone(false));
			}
			if (from.getOmUsrByIdUsrstativo() != null) {
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo().clone(false));
			}
			if (from.getPpCliente() != null) {
				to.setPpCliente(from.getPpCliente().clone(false));
			}

			if ((from.getPpCpprodutos() != null) && (!from.getPpCpprodutos().isEmpty())) {
				to.setPpCpprodutos(new HashSet<PpCpproduto>());
				for (PpCpproduto prod : from.getPpCpprodutos()) {
					to.getPpCpprodutos().add(prod.clone(true));
				}
			}

			if (from.getPpPlano() != null) {
				to.setPpPlano(from.getPpPlano().clone(false));
			}
			if (from.getPpNec() != null) {
				to.setPpNec(from.getPpNec().clone(false));
			}
			to.setDwConsolids(null);
		}

		return to;
	}

	public void set(Long idCp, String cdCp, OmUsr omUsrByIdUsrstativo, OmUsr omUsrByIdUsrrevisao, Long revisao, Date dtRevisao,
			Date dtStativo, Byte stAtivo, Integer prioridade, Boolean isAntecipacao, Integer stCp, Date dthrInicio, Date dthrFinal,
			Date dthrInicioreal, Date dthrFinalreal, Integer tpCp, Boolean isFinalserie, Boolean isMassa, Boolean isTryout, Boolean isCm,
			Boolean isBarrasete,
			Date dtCobertura, BigDecimal passo,
			OmPt omPt, DwEst dwEst, PpPlano ppPlano, DwCal dwCal, DwFolha dwFolha, DwRota dwRota, OmGt omGt, PpCliente ppCliente) {

		PpCp ppCp = (PpCp) this;

		ppCp.setIdCp(idCp);
		ppCp.setCdCp(cdCp);
		ppCp.setDthrInicio(dthrInicio);
		ppCp.setDthrFinal(dthrFinal);
		ppCp.setDthrInicioreal(dthrInicioreal);
		ppCp.setDthrFinalreal(dthrFinalreal);
		ppCp.setDtRevisao(dtRevisao);
		ppCp.setDtStativo(dtStativo);
		ppCp.setIsAntecipacao(isAntecipacao);
		ppCp.setIsBarrasete(isBarrasete);
		ppCp.setIsCm(isCm);
		ppCp.setIsFinalserie(isFinalserie);
		ppCp.setIsMassa(isMassa);
		ppCp.setIsTryout(isTryout);
		ppCp.setPrioridade(prioridade);
		ppCp.setRevisao(revisao);
		ppCp.setStAtivo(stAtivo);
		ppCp.setStCp(stCp);
		ppCp.setTpCp(tpCp);
		ppCp.setPasso(passo);
		ppCp.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		ppCp.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		ppCp.setDtCobertura(dtCobertura);
		ppCp.setOmPt(omPt);
		ppCp.setDwEst(dwEst);
		ppCp.setPpPlano(ppPlano);
		ppCp.setDwCal(dwCal);
		ppCp.setDwFolha(dwFolha);
		ppCp.setDwRota(dwRota);
		ppCp.setOmGt(omGt);
		ppCp.setPpCliente(ppCliente);

	}

	public void mudarDthrIniciorealIfNull(Date dthrInicioreal) {
		if (getInstanceT().getDthrInicioreal() == null) {
			getInstanceT().setDthrInicioreal(dthrInicioreal);
			getInstanceT().setStCp(PpCpTemplate.StCp.INICIADA.getValue());
		}
	}

	public OmProduto obtemPrimeiroProduto() {
		PpCp ppCp = (PpCp) this;
		OmProduto retorno = null;
		for (PpCpproduto ppCpproduto : ppCp.getPpCpprodutos()) {
			retorno = ppCpproduto.getOmProduto();
			break;
		}
		return retorno;
	}
}
