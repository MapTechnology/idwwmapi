package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.DwEst;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmFor;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPromidia;
import idw.model.pojos.OmUnidmedida;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

public abstract class OmProdutoTemplate extends AbstractTemplate<OmProduto> implements IPojoMAP {

	public static final String _FIELD_NAME_CD = "CdProduto";
	private static final int _MAX_LEN_CD_PRODUTO = 30;
	private static final int _MAX_LEN_DEPARA = 256;
	private static final int _MAX_LEN_DS_COMPLEMENTO = 100;
	private static final int _MAX_LEN_DS_CURTA = 10;
	private static final int _MAX_LEN_DS_PRODUTO = 256;
	private static final int _MAX_LEN_CD_SAP = 20;
	private static final int _MAX_LEN_CD_CAIXA = 20;
	private static final int _MAX_LEN_CD_MODELO = 60;
	private static final int _MAX_LEN_CD_PARTNUMBER = 60;

	/** Definições de tipo de produto */
	public enum TpProduto{

		PRODUTO_FINAL((byte)0),
		COMPONENTE((byte) 1),
		AGRUPADOR((byte) 2),
		SEMI_ACABADO((byte) 3),
		EMBALAGEM((byte) 4);

		private final byte id;

		TpProduto(byte id){
			this.id = id;
		}

		public boolean equals(byte id){
			return this.id == id;
		}

		public byte getId(){
			return this.id;
		}

		public boolean equals(Byte id){
			return (id == null ? false: id.equals(this.id));
		}

		/**
		 * Pega o item de {@code TpProduto} baseado no id
		 * @param id
		 */
		public static TpProduto valueOf(Byte id){
			if(id != null){
				for(TpProduto item: TpProduto.values()){
					if(item.equals(id)){
						return item;
					}
				}
			}
			return null;
		}

	}

	public enum TpSemiacabado{

		IAC((byte)0),
		IMC((byte) 1);

		private final byte id;

		TpSemiacabado(byte id){
			this.id = id;
		}

		public boolean equals(byte id){
			return this.id == id;
		}

		public byte getId(){
			return this.id;
		}

		/**
		 * Pega o item de {@code TpSemiacabado} baseado no id
		 * @param id
		 */
		public static TpSemiacabado valueOf(Byte id){
			if(id != null){
				for(TpSemiacabado item: TpSemiacabado.values()){
					if(item.equals(id)){
						return item;
					}
				}
			}
			return null;
		}

	}

	public enum TpProducao{

		/** Produ��oo normal */
		NORMAL(BigDecimal.ZERO),
		/** Tryout */
		TRYOUT(BigDecimal.ONE),
		/** Massa, producao em massa. Essa nao eh producao normal. A producao em massa ocorre logo apos o layout*/
		MASSA(new BigDecimal(2)),
		/** final de linha */
		FINAL_LINHA(new BigDecimal(3));

		private final BigDecimal id;

		TpProducao(BigDecimal id){
			this.id = id;
		}

		/**
		 * Compara com o id do tipo
		 */
		public boolean equals(BigDecimal id){
			if(id == null){
				return false;
			} else{
				return id.intValue() == this.id.intValue();
			}
		}

		/** Id relacionado ao tipo */
		public BigDecimal getId(){
			return this.id;
		}

		/** Retorna {@code TpProducao} baseado no id */
		public static TpProducao valueOf(BigDecimal id){
			if(id != null){
				for(TpProducao item: TpProducao.values()){
					if(item.equals(id)){
						return item;
					}
				}
			}
			return null;
		}

	}

	public enum TpOrigem{

		INDEFINIDO(0),
		NACIONAL(1),
		IMPORTADO(2),
		LOCAL(3);

		private final int id;
		TpOrigem(final int id){
			this.id = id;
		}

		public int getId(){
			return this.id;
		}

		public boolean equals(int id){
			return this.id == id;
		}

		/**
		 * Pega o item de {@code TpOrigem} baseado no id
		 * @param id
		 */
		public static TpOrigem valueOf(Integer id){
			if(id != null){
				for(TpOrigem item: TpOrigem.values()){
					if(item.getId() == id){
						return item;
					}
				}
			}
			return TpOrigem.INDEFINIDO;
		}
	}

	private double tmpEstimado = 0d;

	public double obtemTmpEstimado(){
		return this.tmpEstimado;
	}
	public void mudaTmpEstimado(double valor){
		this.tmpEstimado = valor;
	}

	public boolean isTpProduto(TpProduto... tpProdutos){
		OmProduto omProduto = (OmProduto) this;
		for(TpProduto tpProduto: tpProdutos){
			if(tpProduto.equals(omProduto.getTpProduto())){
				return true;
			}
		}
		return false;
	}

	@Override
	public Long getId() {
		return getInstanceT().getIdProduto();
	}

	@Override
	public void setId(Long id) {
		getInstanceT().setIdProduto(id == null ? 0L: id.longValue());
	}

	@Override
	public String getCd() {
		return ((OmProduto)this).getCdProduto();
	}

	@Override
	public String getFieldNameCd() {
		return OmProdutoTemplate._FIELD_NAME_CD;
	}

	/**
	 * Campos usados no equals:
	 * <p> CdProduto, DsProduto, OmFor, PpCliente, OmProgrp, DwEst, OmCc,  OmProdutoByIdProdutoagru,
	 * TpProduto, MinValposalim, DsComplemento, Depara, HrLeadtimeentrada, HrLeadtimesaida, QtLoteminprod
	 *  TpProducao, IndPerdaproducao, DsCurta, StAtivo, GPesoBruto, GPesoLiquido, OmUnidmedida, TpOrigem, VlCustounit, TpSemiacabado
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final OmProduto omProdutoOther = (OmProduto) o;
			final OmProduto omProduto = (OmProduto) this;
			equals = (new EqualsBuilderIdw())
						.append(omProduto.getCdProduto(), omProdutoOther.getCdProduto())
						.append(omProduto.getDsProduto(), omProdutoOther.getDsProduto())
						.append(omProduto.getOmFor(), omProdutoOther.getOmFor())
						.append(omProduto.getPpCliente(), omProdutoOther.getPpCliente())
						.append(omProduto.getOmProgrp(), omProdutoOther.getOmProgrp())
						.append(omProduto.getDwEst(), omProdutoOther.getDwEst())
						.append(omProduto.getOmCc(), omProdutoOther.getOmCc())
						.append(omProduto.getOmProdutoByIdProdutoagru(), omProdutoOther.getOmProdutoByIdProdutoagru())
						.append(omProduto.getTpProduto(), omProdutoOther.getTpProduto())
						.append(omProduto.getTpSemiacabado(), omProdutoOther.getTpSemiacabado())
						.append(omProduto.getMinValposalim(), omProdutoOther.getMinValposalim())
						.append(omProduto.getDsComplemento(), omProdutoOther.getDsComplemento())
						.append(omProduto.getDepara(), omProdutoOther.getDepara())
						.append(omProduto.getHrLeadtimeentrada(), omProdutoOther.getHrLeadtimeentrada())
						.append(omProduto.getHrLeadtimesaida(), omProdutoOther.getHrLeadtimesaida())
						.append(omProduto.getTpProducao(), omProdutoOther.getTpProducao())
						.append(omProduto.getIndPerdaproducao(), omProdutoOther.getIndPerdaproducao())
						.append(omProduto.getDsCurta(), omProdutoOther.getDsCurta())
						.append(omProduto.getStAtivo(), omProdutoOther.getStAtivo())
						.append(omProduto.getGPesoBruto(), omProdutoOther.getGPesoBruto())
						.append(omProduto.getGPesoLiquido(), omProdutoOther.getGPesoLiquido())
						.append(omProduto.getOmUnidmedida(), omProdutoOther.getOmUnidmedida())
						.append(omProduto.getTpOrigem(), omProdutoOther.getTpOrigem())
						.append(omProduto.getVlCustounit(), omProdutoOther.getVlCustounit())
						.append(omProduto.getQtLoteminprod(), omProdutoOther.getQtLoteminprod())
						.append(omProduto.getIsDat(), omProdutoOther.getIsDat())
						.append(omProduto.getIsConsumido(), omProdutoOther.getIsConsumido())
						.append(omProduto.getCdSap(), omProdutoOther.getCdSap())
						.append(omProduto.getCdCaixa(), omProdutoOther.getCdCaixa())
						.append(omProduto.getQtEmpilhamento(), omProdutoOther.getQtEmpilhamento())
						.append(omProduto.getCdModelo(), omProdutoOther.getCdModelo())
						.append(omProduto.getCdPartnumber(), omProdutoOther.getCdPartnumber())
						.isEquals();
		}
		return equals;
	}

	/**
	 * {@link OmProdutoTemplate#equals(Object)}
	 */
	@Override
	public int hashCode(){

		OmProduto omProduto = (OmProduto) this;

		return (new HashCodeBuilderIdw())
						.append(omProduto.getCdProduto())
						.append(omProduto.getDsProduto())
						.append(omProduto.getOmFor())
						.append(omProduto.getPpCliente())
						.append(omProduto.getOmProgrp())
						.append(omProduto.getDwEst())
						.append(omProduto.getOmCc())
						.append(omProduto.getOmProdutoByIdProdutoagru())
						.append(omProduto.getTpProduto())
						.append(omProduto.getTpSemiacabado())
						.append(omProduto.getMinValposalim())
						.append(omProduto.getDsComplemento())
						.append(omProduto.getDepara())
						.append(omProduto.getHrLeadtimeentrada())
						.append(omProduto.getHrLeadtimesaida())
						.append(omProduto.getTpProducao())
						.append(omProduto.getIndPerdaproducao())
						.append(omProduto.getDsCurta())
						.append(omProduto.getStAtivo())
						.append(omProduto.getGPesoBruto())
						.append(omProduto.getGPesoLiquido())
						.append(omProduto.getOmUnidmedida())
						.append(omProduto.getTpOrigem())
						.append(omProduto.getVlCustounit())
						.append(omProduto.getQtLoteminprod())
						.append(omProduto.getIsDat())
						.append(omProduto.getIsConsumido())
						.append(omProduto.getCdSap())
						.append(omProduto.getCdCaixa())
						.append(omProduto.getQtEmpilhamento())
						.append(omProduto.getCdModelo())
						.append(omProduto.getCdPartnumber())
						.toHashCode();
	}
	/**
	 * Atualiza apenas os atributos básicos (que n�o s�o outros pojos)
	 *
	 * @param idProduto
	 * @param cdProduto
	 * @param revisao
	 * @param dsProduto
	 * @param dtRevisao
	 * @param dtStativo
	 * @param stAtivo
	 * @param tpProduto
	 * @param minValposalim
	 * @param dsComplemento
	 * @param depara
	 * @param hrLeadtimeentrada
	 * @param hrLeadtimesaida
	 * @param tpProducao
	 * @param indPerdaproducao
	 * @param dsCurta
	 * @param gPesoBruto
	 * @param gPesoLiquido
	 * @param tpOrigem
	 * @param vlCustounit
	 * @param qtLoteminprod
	 * @param tpSemiacabado
	 * @param isDat
	 */
	public void set(
			long idProduto,
			String cdProduto,
			Long revisao,
			String dsProduto,
			Date dtRevisao,
			Date dtStativo,
			Byte stAtivo, Byte tpProduto, BigDecimal minValposalim,
			String dsComplemento, String depara, BigDecimal hrLeadtimeentrada,
			BigDecimal hrLeadtimesaida, BigDecimal tpProducao, BigDecimal indPerdaproducao,
			String dsCurta, BigDecimal gPesoBruto, BigDecimal gPesoLiquido,
			Integer tpOrigem, BigDecimal vlCustounit, BigDecimal qtLoteminprod, Byte tpSemiacabado,
			Boolean isDat, Boolean isConsumido, Byte tpClasseabc, String cdSap, String cdCaixa, Integer qtEmpilhamento,
			String cdModelo, String cdPartnumber, Boolean isRequerroteiro, Boolean isRastreabilidade){

		OmProduto o = (OmProduto) this;

		o.setIdProduto(idProduto);
		o.setCdProduto(cdProduto);
		o.setRevisao(revisao);
		o.setDsProduto(dsProduto);
		o.setDtRevisao(dtRevisao);
		o.setDtStativo(dtStativo);
		o.setStAtivo(stAtivo);
		o.setTpProduto(tpProduto);
		o.setTpProducao(tpProducao);
		o.setMinValposalim(minValposalim);
		o.setDsComplemento(dsComplemento);
		o.setDepara(depara);
		o.setHrLeadtimeentrada(hrLeadtimeentrada);
		o.setHrLeadtimesaida(hrLeadtimesaida);
		o.setIndPerdaproducao(indPerdaproducao);
		o.setDsCurta(dsCurta);
		o.setGPesoBruto(gPesoBruto);
		o.setGPesoLiquido(gPesoLiquido);
		o.setTpOrigem(tpOrigem);
		o.setVlCustounit(vlCustounit);
		o.setQtLoteminprod(qtLoteminprod);
		o.setTpSemiacabado(tpSemiacabado);
		o.setIsDat(isDat);
		o.setIsConsumido(isConsumido);
		o.setTpClasseabc(tpClasseabc);
		o.setCdSap(cdSap);
		o.setCdCaixa(cdCaixa);
		o.setQtEmpilhamento(qtEmpilhamento);
		o.setCdModelo(cdModelo);
		o.setCdPartnumber(cdPartnumber);
		o.setIsRequerroteiro(isRequerroteiro);
		o.setIsRastreabilidade(isRastreabilidade);
	}

	public void set(
			long idProduto,
			String cdProduto,
			Long revisao,
			String dsProduto,
			Date dtRevisao,
			Date dtStativo,
			Byte stAtivo, Byte tpProduto, BigDecimal minValposalim,
			String dsComplemento, String depara, BigDecimal hrLeadtimeentrada,
			BigDecimal hrLeadtimesaida, BigDecimal tpProducao, BigDecimal indPerdaproducao,
			String dsCurta, BigDecimal gPesoBruto, BigDecimal gPesoLiquido,
			DwEst dwEst, OmFor omFor, OmUsr omUsrByIdUsrstativo,
			OmProgrp omProgrp, OmUsr omUsrByIdUsrrevisao, OmCc omCc, OmProduto omProdutoByIdProdutoagru,
			PpCliente ppCliente, OmUnidmedida omUnidmedida, Integer tpOrigem, BigDecimal vlCustounit, BigDecimal qtLoteminprod, Byte tpSemiacabado,
			Boolean isDat, Boolean isConsumido, Byte tpClasseabc,
			String cdSap, String cdCaixa, Integer qtEmpilhamento,
			String cdModelo, String cdPartnumber, Boolean isRequerroteiro, Boolean isRastreabilidade){

		OmProduto o = (OmProduto) this;

		o.set(idProduto,
				cdProduto,
				revisao,
				dsProduto,
				dtRevisao,
				dtStativo,
				stAtivo,
				tpProduto,
				minValposalim,
				dsComplemento,
				depara,
				hrLeadtimeentrada,
				hrLeadtimesaida,
				tpProducao,
				indPerdaproducao,
				dsCurta, gPesoBruto, gPesoLiquido,
				tpOrigem, vlCustounit, qtLoteminprod, tpSemiacabado, isDat, isConsumido, tpClasseabc,
				cdSap, cdCaixa, qtEmpilhamento,
				cdModelo, cdPartnumber, isRequerroteiro, isRastreabilidade);

		o.setOmFor(omFor);
		o.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		o.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		o.setOmProgrp(omProgrp);
		o.setOmCc(omCc);
		o.setDwEst(dwEst);
		o.setOmProdutoByIdProdutoagru(omProdutoByIdProdutoagru);
		o.setPpCliente(ppCliente);
		o.setOmUnidmedida(omUnidmedida);
	}

	public void setForeignKeys(OmFor omFor, PpCliente ppCliente, OmUsr omUsrByIdUsrstativo,
			OmProgrp omProgrp, OmUsr omUsrByIdUsrrevisao, DwEst dwEst, OmCc omCc,
			OmProduto omProdutoByIdProdutoagru, OmUnidmedida omUnidmedida){

		OmProduto omProduto = (OmProduto) this;

		omProduto.setOmFor(omFor);
		omProduto.setPpCliente(ppCliente);
		omProduto.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		omProduto.setOmProgrp(omProgrp);
		omProduto.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		omProduto.setDwEst(dwEst);
		omProduto.setOmCc(omCc);
		omProduto.setOmProdutoByIdProdutoagru(omProdutoByIdProdutoagru);
		omProduto.setOmUnidmedida(omUnidmedida);

	}

	@Override
	protected OmProduto atribuir(OmProduto itemGet, OmProduto itemSet,
			boolean isCopiarFK) {

		if(itemSet == null){
			itemSet = new OmProduto();
		}

		itemSet.set(
				itemGet.getIdProduto(),
				itemGet.getCdProduto(),
				itemGet.getRevisao(),
				itemGet.getDsProduto(),
				itemGet.getDtRevisao(),
				itemGet.getDtStativo(),
				itemGet.getStAtivo(),
				itemGet.getTpProduto(),
				itemGet.getMinValposalim(),
				itemGet.getDsComplemento(),
				itemGet.getDepara(),
				itemGet.getHrLeadtimeentrada(),
				itemGet.getHrLeadtimesaida(),
				itemGet.getTpProducao(),
				itemGet.getIndPerdaproducao(),
				itemGet.getDsCurta(),
				itemGet.getGPesoBruto(),
				itemGet.getGPesoLiquido(),
				itemGet.getTpOrigem(),
				itemGet.getVlCustounit(),
				itemGet.getQtLoteminprod(),
				itemGet.getTpSemiacabado(),
				itemGet.getIsDat(),
				itemGet.getIsConsumido(),
				itemGet.getTpClasseabc(),
				itemGet.getCdSap(),
				itemGet.getCdCaixa(),
				itemGet.getQtEmpilhamento(),
				itemGet.getCdModelo(),
				itemGet.getCdPartnumber(),
				itemGet.getIsRequerroteiro(),
				itemGet.getIsRastreabilidade()
				);

		if (isCopiarFK) {
			if (itemGet.getOmUnidmedida() != null)
				itemSet.setOmUnidmedida(itemGet.getOmUnidmedida().clone(false));

			itemSet.setOmProgrp(CloneUtil.clone(itemGet.getOmProgrp(),false));
			itemSet.setOmCc(CloneUtil.clone(itemGet.getOmCc(),false));
			itemSet.setOmProdutoByIdProdutoagru(CloneUtil.clone(itemGet.getOmProdutoByIdProdutoagru(), false));
			itemSet.setPpCliente(CloneUtil.clone(itemGet.getPpCliente(),false));
			itemSet.setOmUsrByIdUsrrevisao(CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false));
			itemSet.setOmUsrByIdUsrstativo(CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false));
			itemSet.setOmUnidmedida(CloneUtil.clone(itemGet.getOmUnidmedida(),false));

			DwEst dwEst = new DwEst();
			try {
				dwEst.setCdEst(itemGet.getDwEst().getCdEst());
				dwEst.setDsEst(itemGet.getDwEst().getDsEst());
			} catch (Exception e) {
				dwEst = null;
			}
			itemSet.setDwEst(dwEst);

			OmFor omFor = new OmFor();
			try {
				omFor.setCdFor(itemGet.getOmFor().getCdFor());
				omFor.setNmFornecedor(itemGet.getOmFor().getNmFornecedor());
			} catch (Exception e) {
				omFor = null;
			}
			itemSet.setOmFor(omFor);

			if (itemGet.getOmPromidias() != null) {
				itemSet.setOmPromidias(new HashSet<OmPromidia>());
				for (OmPromidia midia : itemGet.getOmPromidias()) {
					OmPromidia clone = midia.clone();
					itemSet.getOmPromidias().add(clone);
				}
			}

		}

		return itemSet;
	}

	public void limitarStrings(){
		OmProduto omProduto = (OmProduto) this;
		omProduto.setCdProduto(StringUtils.left(omProduto.getCdProduto(), OmProdutoTemplate._MAX_LEN_CD_PRODUTO));
		omProduto.setDepara(StringUtils.left(omProduto.getDepara(), OmProdutoTemplate._MAX_LEN_DEPARA));
		omProduto.setDsComplemento(StringUtils.left(omProduto.getDsComplemento(), OmProdutoTemplate._MAX_LEN_DS_COMPLEMENTO));
		omProduto.setDsCurta(StringUtils.left(omProduto.getDsCurta(), OmProdutoTemplate._MAX_LEN_DS_CURTA));
		omProduto.setDsProduto(StringUtils.left(omProduto.getDsProduto(), OmProdutoTemplate._MAX_LEN_DS_PRODUTO));
		omProduto.setCdSap(StringUtils.left(omProduto.getCdSap(), OmProdutoTemplate._MAX_LEN_CD_SAP));
		omProduto.setCdCaixa(StringUtils.left(omProduto.getCdCaixa(), OmProdutoTemplate._MAX_LEN_CD_CAIXA));
		omProduto.setCdModelo(StringUtils.left(omProduto.getCdModelo(), OmProdutoTemplate._MAX_LEN_CD_MODELO));
		omProduto.setCdPartnumber(StringUtils.left(omProduto.getCdPartnumber(), OmProdutoTemplate._MAX_LEN_CD_PARTNUMBER));
	}

}
