package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.LazyInitializationException;
import org.hibernate.SessionException;

import idw.model.IPojoMAP;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwFolhaemb;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolhamedtemp;
import idw.model.pojos.DwFolhamon;
import idw.model.pojos.DwFolhaoperacao;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwFolhasetup;
import idw.model.pojos.DwFolhateste;
import idw.model.pojos.DwProcedimento;
import idw.model.pojos.OmCfgscrpimp;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;
import idw.util.IdwLogger;

public abstract class DwFolhaTemplate extends AbstractTemplate<DwFolha> implements IPojoMAP {
	public static final String _FIELD_NAME_CD = "CdFolha";
	
	public abstract Set<DwFolharap> getDwFolharaps();
	public abstract void setDwFolharaps(Set<DwFolharap> dwFolharaps);

	public abstract Set<DwFolhaiac> getDwFolhaiacs();
	public abstract void setDwFolhaiacs(Set<DwFolhaiac> dwFolhaiacs);

	/*
	 * 
			0 - todas as operacoes são manuais
			1 - todas as operacoes são automáticas
			2 - operacoes principais automaticas com auxiliares manuais
			3 - operacoes principais manuais com auxiliares automaticas
	 */
	public enum _TP_PRODUCAO {
		_TP_PRODUCAO_MANUAL( (byte) 0),
		_TP_PRODUCAO_AUTOMATICA((byte) 1),
		_TP_PRODUCAO_AUTOMATICA_MANUAL((byte) 2),
		_TP_PRODUCAO_MANUAL_AUTOMATICA((byte) 3);
		
		private byte tp_producao;
		
		private _TP_PRODUCAO(byte tp) {
			this.tp_producao = tp;
		}
		
		public byte getValue() {
			return this.tp_producao;
		}
	}

	public enum TpFolha {
		RECEITA_TESTES_FUNCIONAIS((byte) 0), MONTAGEM((byte) 1), TESTE_PASSA_NAO_PASSA(
				(byte) 2), TESTA_PASSA_CODIGO_DEFEITO((byte) 3), APENAS_REGISTRO_PASSAGEM(
				(byte) 4), REPROCESSO_CAUSA_ACAO((byte) 5), PROGRAMA_IAC(
				(byte) 6), MEDICAO_TEMPERATURA((byte) 7);

		private final byte value;

		private TpFolha(byte value) {
			this.value = value;
		}

		public byte getValue() {
			return this.value;
		}

	}

	@Override
	public Long getId() {
		return getInstanceT().getIdFolha();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdFolha(id);
	}

	/**
	 * Pega cavidades ativas em DwFolhaIAC
	 * 
	 * @param log
	 * @return
	 */
	public BigDecimal totalCavAtivaFolhaIAC(IdwLogger log) {
		DwFolha dwFolha = (DwFolha) this;
		DwFolhaiac dwfolhaiac = null;
		BigDecimal cavAtiva = BigDecimal.ONE;
		try {
			dwfolhaiac = (DwFolhaiac) dwFolha.getDwFolhaiacs().iterator().next();
			cavAtiva = dwfolhaiac.getQtAtiva();
		} catch (Exception e) {
			log.info("DwFolhaIac nao existe para a folha id = " + dwFolha.getIdFolha() + ", cavAtiva ser� 1");
		}
		return cavAtiva;
	}

	public BigDecimal totalMPConsumidaPorCiclo(IdwLogger log) {
		DwFolha dwFolha = (DwFolha) this;
		DwFolhaiac dwfolhaiac = null;
		BigDecimal mpConsumidaPorCiclo = BigDecimal.ZERO;
		try {
			dwfolhaiac = (DwFolhaiac) dwFolha.getDwFolhaiacs().iterator().next();
			mpConsumidaPorCiclo = dwfolhaiac.getQtMpporciclo();
		} catch (Exception e) {
			log.info("DwFolhaIac nao existe para a folha id = " + dwFolha.getIdFolha() + ", mpConsumida ser� 0");
		}
		return mpConsumidaPorCiclo;
	}

	/**
	 * Pega o peso bruto do produto de DwFolharapcom de DwFolharap
	 * 
	 * @param idProduto
	 * @return
	 */
	public BigDecimal gPesoBrutoProd(long idProduto) {
		BigDecimal retorno = new BigDecimal(0);
		DwFolha dwFolha = (DwFolha) this;
		for (DwFolharap dwFolharap : dwFolha.getDwFolharaps()) {
			retorno.add(dwFolharap.gPesoBrutoProd(idProduto));
		}
		return retorno;
	}

	/**
	 * Pega o peso l�quido do produto de DwFolharapcom de DwFolharap
	 * 
	 * @param idProduto
	 * @return
	 */
	public BigDecimal gPesoLiquidoProd(long idProduto) {
		BigDecimal retorno = new BigDecimal(0);
		DwFolha dwFolha = (DwFolha) this;
		for (DwFolharap dwFolharap : dwFolha.getDwFolharaps()) {
			retorno.add(dwFolharap.gPesoLiquidoProd(idProduto));
		}
		return retorno;
	}

	/**
	 * Pega a quantidade de cavidade ativa do produto de DwFolharapcom de
	 * DwFolharap
	 * 
	 * @param idProduto
	 * @return
	 */
	public BigDecimal qtAtivaProd(long idProduto) {
		BigDecimal retorno = new BigDecimal(0);

		DwFolha dwFolha = (DwFolha) this;

		for (DwFolharap dwFolharap : dwFolha.getDwFolharaps()) {
			retorno.add(dwFolharap.qtAtivaProd(idProduto));
		}
		return retorno;

	}

	/**
	 * Pega a quantidade de cavidade total de DwFolharapcom de DwFolharap
	 * 
	 * @param idProduto
	 * @return
	 */
	public BigDecimal qtTotalProd(long idProduto) {
		BigDecimal retorno = new BigDecimal(0);

		DwFolha dwFolha = (DwFolha) this;

		for (DwFolharap dwFolharap : dwFolha.getDwFolharaps()) {
			retorno.add(dwFolharap.qtTotalProd(idProduto));
		}
		return retorno;

	}

	/**
	 * Pega a quantidade ativa de cada DwFolharapcom de DwFolharap
	 * 
	 * @return
	 */
	public BigDecimal totalQtAtiva() {
		BigDecimal retorno = new BigDecimal(1);

		DwFolha dwFolha = (DwFolha) this;

		for (DwFolharap dwFolharap : dwFolha.getDwFolharaps()) {
			retorno.add(dwFolharap.totalQtAtiva());
		}
		return retorno;

	}

	/**
	 * Pega a quantidade total de cada DwFolharapcom de DwFolharap
	 * 
	 * @return
	 */
	public BigDecimal totalQtTotal() {
		BigDecimal retorno = new BigDecimal(1);

		DwFolha dwFolha = (DwFolha) this;

		for (DwFolharap dwFolharap : dwFolha.getDwFolharaps()) {
			retorno.add(dwFolharap.totalQtTotal());
		}
		return retorno;

	}

	/**
	 * Pega o peso bruto de cada DwFolharapcom de DwFolharap
	 * 
	 * @return
	 */
	public BigDecimal gPesoBruto() {
		BigDecimal retorno = new BigDecimal(0);

		DwFolha dwFolha = (DwFolha) this;

		for (DwFolharap dwFolharap : dwFolha.getDwFolharaps()) {
			retorno.add(dwFolharap.gPesoBruto());
		}
		return retorno;

	}

	/**
	 * Pega o peso liquido total de cada DwFolharapcom de DwFolharap
	 * 
	 * @return
	 */
	public BigDecimal gPesoLiquido() {
		BigDecimal retorno = new BigDecimal(0);

		DwFolha dwFolha = (DwFolha) this;

		for (DwFolharap dwFolharap : dwFolha.getDwFolharaps()) {
			retorno.add(dwFolharap.gPesoLiquido());
		}
		return retorno;

	}

	@Override
	public String getCd() {
		return ((DwFolha) this).getCdFolha();
	}

	@Override
	public String getFieldNameCd() {
		return DwFolhaTemplate._FIELD_NAME_CD;
	}

	@Override
	public boolean equals(Object o) {
		boolean equals = false;
		if ((o != null) && this.getClass().isAssignableFrom(o.getClass())) {
			final DwFolha dwFolhaOther = (DwFolha) o;
			final DwFolha dwFolha = (DwFolha) this;
			equals = (new EqualsBuilderIdw())
					.append(dwFolha.getCdFolha(), dwFolhaOther.getCdFolha())
					.append(dwFolha.getDsFolha(), dwFolhaOther.getDsFolha())
					.append(dwFolha.getOmTppt(), dwFolhaOther.getOmTppt())
					.append(dwFolha.getStAtivo(), dwFolhaOther.getStAtivo())
					.append(dwFolha.getIsLogonobrigatorio(), dwFolhaOther.getIsLogonobrigatorio())
					.append(dwFolha.getIsModelo(), dwFolhaOther.getIsModelo())
					.append(dwFolha.getOmGt(), dwFolhaOther.getOmGt())
					.append(dwFolha.getSegCiclominimo(), dwFolhaOther.getSegCiclominimo())
					.append(dwFolha.getSegCiclopadrao(), dwFolhaOther.getSegCiclopadrao())
					.append(dwFolha.getSegCiclotimeout(), dwFolhaOther.getSegCiclotimeout())
					.append(dwFolha.getSegSetup(), dwFolhaOther.getSegSetup())
					.append(dwFolha.getTpFolha(), dwFolhaOther.getTpFolha())
					.append(dwFolha.getOmPt(), dwFolhaOther.getOmPt())
					.isEquals();
		}
		return equals;
	}

	@Override
	public int hashCode() {
		DwFolha dwFolha = (DwFolha) this;
		return (new HashCodeBuilderIdw()).append(dwFolha.getCdFolha())
				.append(dwFolha.getDsFolha()).append(dwFolha.getOmTppt())
				.append(dwFolha.getStAtivo())
				.append(dwFolha.getIsLogonobrigatorio())
				.append(dwFolha.getIsModelo()).append(dwFolha.getOmGt())
				.append(dwFolha.getSegCiclominimo())
				.append(dwFolha.getSegCiclopadrao())
				.append(dwFolha.getSegCiclotimeout())
				.append(dwFolha.getSegSetup()).append(dwFolha.getTpFolha())
				.append(dwFolha.getOmPt()).toHashCode();
	}

	public void set(Long idFolha, OmTppt omTppt, OmGt omGt,
			OmUsr omUsrByIdUsrstativo, OmUsr omUsrByIdUsrrevisao,
			String cdFolha, Long revisao, Date dtRevisao, Byte stAtivo,
			Date dtStativo, String dsFolha, BigDecimal segCiclopadrao,
			BigDecimal segCiclotimeout, BigDecimal segCiclominimo,
			Boolean isModelo, Byte tpFolha, Boolean isLogonobrigatorio,
			BigDecimal segLogoutauto, Integer segSetup, OmPt omPt,
			DwProcedimento dwProcedimento, Integer qtPacoteciclo,
			BigDecimal qtFatorcontagem,
			Boolean isAvaliarlimites,
			Integer limiteMinCb,
			Integer limiteMaxCb,
			Integer tpValidacao,
			Boolean isAceitarNsDesconhecido,
			String mascara) {

		DwFolha dwFolha = (DwFolha) this;

		dwFolha.setIdFolha(idFolha);
		dwFolha.setCdFolha(cdFolha);
		dwFolha.setDsFolha(dsFolha);
		dwFolha.setDtRevisao(dtRevisao);
		dwFolha.setDtStativo(dtStativo);
		dwFolha.setIsLogonobrigatorio(isLogonobrigatorio);
		dwFolha.setIsModelo(isModelo);
		dwFolha.setOmGt(omGt);
		dwFolha.setOmTppt(omTppt);
		dwFolha.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwFolha.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwFolha.setRevisao(revisao);
		dwFolha.setSegCiclominimo(segCiclominimo);
		dwFolha.setSegCiclopadrao(segCiclopadrao);
		dwFolha.setSegCiclotimeout(segCiclotimeout);
		dwFolha.setSegLogoutauto(segLogoutauto);
		dwFolha.setSegSetup(segSetup);
		dwFolha.setStAtivo(stAtivo);
		dwFolha.setTpFolha(tpFolha);
		dwFolha.setOmPt(omPt);
		dwFolha.setDwProcedimento(dwProcedimento);
		dwFolha.setQtFatorcontagem(qtFatorcontagem);
		dwFolha.setQtPacoteciclo(qtPacoteciclo);
		dwFolha.setIsAvaliarlimites(isAvaliarlimites);
		dwFolha.setLimiteMinCb(limiteMinCb);
		dwFolha.setLimiteMaxCb(limiteMaxCb);
		dwFolha.setTpValidacao(tpValidacao);
		dwFolha.setIsAceitarNsDesconhecido(isAceitarNsDesconhecido);
		dwFolha.setMascara(mascara);
	}

	@Override
	protected DwFolha atribuir(DwFolha from, DwFolha to, boolean isCopiarFK) {

		if (to == null) {
			to = new DwFolha();
		}

		to.set(from.getIdFolha(),
				(isCopiarFK ? CloneUtil.clone(from.getOmTppt(), false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmGt(), false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrstativo(), false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getOmUsrByIdUsrrevisao(), false) : null), 
				from.getCdFolha(), 
				from.getRevisao(),
				from.getDtRevisao(), 
				from.getStAtivo(), 
				from.getDtStativo(),
				from.getDsFolha(), 
				from.getSegCiclopadrao(), 
				from.getSegCiclotimeout(), 
				from.getSegCiclominimo(), 
				from.getIsModelo(), 
				from.getTpFolha(), 
				from.getIsLogonobrigatorio(), 
				from.getSegLogoutauto(), 
				from.getSegSetup(),
				(isCopiarFK ? CloneUtil.clone(from.getOmPt(), false) : null),
				(isCopiarFK ? CloneUtil.clone(from.getDwProcedimento(), false) : null), 
				from.getQtPacoteciclo(),
				from.getQtFatorcontagem(),
				from.getIsAvaliarlimites(),
				from.getLimiteMinCb(),
				from.getLimiteMaxCb(),
				from.getTpValidacao(),
				from.getIsAceitarNsDesconhecido(),
				from.getMascara());

		
		
		
		if (isCopiarFK == true) {
			
			if (from.getOmRegrasNscb() != null) {
				try {
					to.setOmRegrasNscb(from.getOmRegrasNscb().clone(false));
				} catch (Exception e) {
					to.setOmRegrasNscb(null);
				}
			}
			if (from.getOmCfgscrpimp() != null) {
				try {
					to.setOmCfgscrpimp((OmCfgscrpimp) from.getOmCfgscrpimp().clone());
				} catch (SessionException e) {
					to.setOmCfgscrpimp(null);
				} catch (LazyInitializationException e) {
					to.setOmCfgscrpimp(null);
				}
			}

			if (from.getDwFolhatestes() != null) {
				try {
					Set<DwFolhateste> dwfolhanew = new HashSet<DwFolhateste>();
					for (DwFolhateste dwft : from.getDwFolhatestes()) {
						dwfolhanew.add((DwFolhateste) dwft.clone());
					}
					to.setDwFolhatestes(dwfolhanew);
				} catch (SessionException e) {
					to.setDwFolhatestes(null);
				} catch (LazyInitializationException e) {
					to.setDwFolhatestes(null);
				}
			}
			
			if (from.getDwFolhaembs() != null) {
				try {
					Set<DwFolhaemb> folhaembs = new HashSet<DwFolhaemb>();
					for (DwFolhaemb emb : from.getDwFolhaembs()) {
						folhaembs.add(emb.clone());
					}
					to.setDwFolhaembs(folhaembs);
				} catch (SessionException | LazyInitializationException e) {
					to.setDwFolhaembs(null);
				}
			}

			// DwFolharap
			if (from.getDwFolharaps() != null) {
				try {
					to.setDwFolharaps(new HashSet<DwFolharap>());
					for (DwFolharap dwfolharap : from.getDwFolharaps()) {
						to.getDwFolharaps().add(dwfolharap.clone());
					}
				} catch (SessionException e) {
					to.setDwFolharaps(null);
				}
			}

			if ((from.getDwFolhaiacs() != null) && (!from.getDwFolhaiacs().isEmpty())) {
				try {
					to.setDwFolhaiacs(new HashSet<DwFolhaiac>());
					for (DwFolhaiac folhaiac : from.getDwFolhaiacs()) {
						if (folhaiac != null) {
							to.getDwFolhaiacs().add(folhaiac.clone());
						}
					}
				} catch (SessionException e) {
					to.setDwFolhaiacs(null);
				}
			}

			if (from.getDwFolhamons() != null && from.getDwFolhamons().isEmpty() == false) {
				to.setDwFolhamons(new HashSet<DwFolhamon>());
				for (DwFolhamon mon : from.getDwFolhamons()) {
					to.getDwFolhamons().add((DwFolhamon) mon.clone());
				}
			}

			if ((from.getDwFolhasetupsForIdFolhaentrando() != null) && (!from.getDwFolhasetupsForIdFolhaentrando().isEmpty())) {
				try {
					to.setDwFolhasetupsForIdFolhaentrando(new HashSet<DwFolhasetup>());
					for (DwFolhasetup folhaSetup : from.getDwFolhasetupsForIdFolhaentrando()) {
						DwFolhasetup setup = folhaSetup.clone(false);
						setup.setDwFolhaByIdFolhasaindo(folhaSetup.getDwFolhaByIdFolhasaindo().clone(false));
						to.getDwFolhasetupsForIdFolhaentrando().add(setup);
					}
				} catch (SessionException e) {
					to.setDwFolhasetupsForIdFolhaentrando(null);
				}
			}

			if ((from.getDwFolhacics() != null) && (from.getDwFolhacics().size() > 0)) {
				try {
					to.setDwFolhacics(new HashSet<DwFolhacic>());
					for (DwFolhacic folhacic : from.getDwFolhacics()) {
						to.getDwFolhacics().add(folhacic.clone());
					}
				} catch (SessionException e) {
					to.setDwFolhacics(null);
				}
			}

			if ((from.getDwFolhamedtemps() != null) && (!from.getDwFolhamedtemps().isEmpty())) {
				try {
					to.setDwFolhamedtemps(new HashSet<DwFolhamedtemp>());
					for (DwFolhamedtemp itemFMT : from.getDwFolhamedtemps()) {
						to.getDwFolhamedtemps().add(itemFMT.clone());
					}
				} catch (SessionException e) {
					to.setDwFolhamedtemps(null);
				}
			}
			
			try {
				if (from.getDwFolhaoperacoes() != null && from.getDwFolhaoperacoes().isEmpty() == false) {
					to.setDwFolhaoperacoes(new HashSet<DwFolhaoperacao>());
					for (DwFolhaoperacao operacao : from.getDwFolhaoperacoes()) {
						to.getDwFolhaoperacoes().add(operacao.clone());
					}
				}
			} catch (Exception e) {
				to.setDwFolhaoperacoes(null);
			}
		}

		to.setDwFolhasetupsForIdFolhasaindo(null);

		return to;
	}
	
	
	public DwFolharap obtemPrimeiroRap() {
		DwFolharap retorno = null;
		
		if (getDwFolharaps() != null) {
			for (DwFolharap rap : getDwFolharaps()) {
				retorno = rap;
				break;
			}
		}
		
		return retorno;
	}
	
	public OmProduto obtemProduto() {
		OmProduto retorno = null;
		if (getDwFolharaps() != null) {
			for (DwFolharap rap : getDwFolharaps()) {
				for (DwFolharapcom com : rap.getDwFolharapcoms()) {
					retorno = com.getOmProduto();
					break;
				}
			}
		}
		if (getDwFolhaiacs() != null) {
			for (DwFolhaiac iac : getDwFolhaiacs()) {
				retorno = iac.getOmProduto();
				break;
			}
		}
		return retorno;
	}
}
