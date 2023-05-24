package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAPAkOmTppt;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

/**
 * isFDS - Indica que a parada sem peso está ocorrendo porque final de semana.
 * isMDO - Indica que a parada e do tipo m�o-de-obra
 * isMTBF - MTBF ("Mean Time Between Failures") ou período médio entre falhas
 * isMTTR -
 * isPA - parada de avaria
 * isPAO - parada de anomalia organizacional
 * isPP - parada de prepara��oo
 * isPREV - parada prevista
 * isPTP - Parada de troca de produ��oo
 * isSCP - Indica que a parada sem peso está ocorrendo porque n�o há pedido em carteira que justifique a produ��oo.
 *
 * @author map
 *
 */
public abstract class DwTParadaTemplate extends AbstractTemplate<DwTParada> implements IPojoMAPAkOmTppt {

	public static final String _FIELD_NAME_CD = "CdTparada";
	private static final int _MAX_LEN_CD_TPARADA = 30;
	private static final int _MAX_LEN_DS_TPARADA = 100;

	@Override
	public Long getId() {		
		return getInstanceT().getIdTparada();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdTparada(id);
	}

	/**
	 * Campos usados no equals:
	 * <p>CdTparada, DsTparada, OmTppt, StAtivo, IsRequerCausa, IsRequerAcao,
	 *	IsRequerJust, IsPesa, IsRegulagem, IsFds, IsMdo, IsMtbf,IsMttr, IsPa,
	 *  IsPao, IsPrev,IsPp, IsPtp, IsScp, QtTec
	 */
	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwTParada dwTParadaOther = (DwTParada) o;
			final DwTParada dwTParada = (DwTParada) this;
			equals = (new EqualsBuilderIdw())
						.append(dwTParada.getCdTparada(), dwTParadaOther.getCdTparada())
						.append(dwTParada.getDsTparada(), dwTParadaOther.getDsTparada())
						.append(dwTParada.getOmTppt(), dwTParadaOther.getOmTppt())
						.append(dwTParada.getDwTArea(),dwTParadaOther.getDwTArea())
						.append(dwTParada.getStAtivo(), dwTParadaOther.getStAtivo())
						.append(dwTParada.getIsRequerCausa(), dwTParadaOther.getIsRequerCausa())
						.append(dwTParada.getIsRequerAcao(), dwTParadaOther.getIsRequerAcao())
						.append(dwTParada.getIsRequerJust(), dwTParadaOther.getIsRequerJust())
						.append(dwTParada.getIsPesa(), dwTParadaOther.getIsPesa())
						.append(dwTParada.getIsRegulagem(), dwTParadaOther.getIsRegulagem())
						.append(dwTParada.getIsPermitecorrecao(), dwTParadaOther.getIsPermitecorrecao())
						.append(dwTParada.getIsFds(), dwTParadaOther.getIsFds())
						.append(dwTParada.getIsMdo(), dwTParadaOther.getIsMdo())
						.append(dwTParada.getIsMtbf(), dwTParadaOther.getIsMtbf())
						.append(dwTParada.getIsPa(), dwTParadaOther.getIsPa())
						.append(dwTParada.getIsPao(), dwTParadaOther.getIsPao())
						.append(dwTParada.getIsPrev(), dwTParadaOther.getIsPrev())
						.append(dwTParada.getIsPp(), dwTParadaOther.getIsPp())
						.append(dwTParada.getIsPtp(), dwTParadaOther.getIsPtp())
						.append(dwTParada.getIsScp(), dwTParadaOther.getIsScp())
						.append(dwTParada.getQtTec(), dwTParadaOther.getQtTec())
						.append(dwTParada.getIsDefault(), dwTParadaOther.getIsDefault())
						.append(dwTParada.getIsSemOp(), dwTParadaOther.getIsSemOp())
						.append(dwTParada.getIsSolicitarOS(), dwTParadaOther.getIsSolicitarOS())
						.append(dwTParada.getIsSemConexao(), dwTParadaOther.getIsSemConexao())
						.append(dwTParada.getIsSemEvento(), dwTParadaOther.getIsSemEvento())
						.append(dwTParada.getSegExtrapolacao(), dwTParadaOther.getSegExtrapolacao())
						.append(dwTParada.getSegTimeoutalerta(), dwTParadaOther.getSegTimeoutalerta())
						.append(dwTParada.getDwTParadaextra(), dwTParadaOther.getDwTParadaextra())
						.append(dwTParada.getDwTAlerta(), dwTParadaOther.getDwTAlerta())
						.isEquals();
		}
		return equals;
	}

	/**
	 * Campos usados no hashCode: CdTparada, DsTparada, OmTppt, StAtivo
	 */
	@Override
	public int hashCode(){

		DwTParada dwTParada = (DwTParada) this;

		return (new HashCodeBuilderIdw())
				.append(dwTParada.getCdTparada())
				.append(dwTParada.getDsTparada())
				.append(dwTParada.getOmTppt())
				.append(dwTParada.getDwTArea())
				.append(dwTParada.getStAtivo())
				.append(dwTParada.getIsRequerCausa())
				.append(dwTParada.getIsRequerAcao())
				.append(dwTParada.getIsRequerJust())
				.append(dwTParada.getIsPesa())
				.append(dwTParada.getIsRegulagem())
				.append(dwTParada.getIsPermitecorrecao())
				.append(dwTParada.getIsFds())
				.append(dwTParada.getIsMdo())
				.append(dwTParada.getIsMtbf())
				.append(dwTParada.getIsPa())
				.append(dwTParada.getIsPao())
				.append(dwTParada.getIsPrev())
				.append(dwTParada.getIsPp())
				.append(dwTParada.getIsPtp())
				.append(dwTParada.getIsScp())
				.append(dwTParada.getQtTec())
				.append(dwTParada.getIsDefault())
				.append(dwTParada.getIsSemOp())
				.append(dwTParada.getIsSemConexao())
				.append(dwTParada.getIsSemEvento())
				.toHashCode();
	}

	@Override
	public String getCd() {
		return ((DwTParada)this).getCdTparada();
	}

	@Override
	public String getFieldNameCd() {
		return DwTParadaTemplate._FIELD_NAME_CD;
	}

	public void set(Long idTparada, DwTParada dwtparada, OmTppt omTppt, DwTArea dwTArea, OmUsr omUsrByIdUsrstativo,
			OmUsr omUsrByIdUsrrevisao, DwTAlerta dwtalerta, String cdTparada, Long revisao,
			String dsTparada, Date dtRevisao, Byte stAtivo, Date dtStativo,
			Boolean isRequerCausa, Boolean isRequerAcao, Boolean isRequerJust,
			Boolean isPesa, Boolean isRegulagem, Boolean isFds, Boolean isMdo,
			Boolean isMtbf, Boolean isPa, Boolean isPao, Boolean isPrev,
			Boolean isPp, Boolean isPtp, Boolean isScp, Integer qtTec, Boolean isDefault, 
			Boolean isSemOp, Boolean isSemConexao, Boolean isSemEvento, Boolean isPermitecorrecao,
			Boolean isEntradarap, Boolean isSaidarap,
			BigDecimal segTimeoutalerta,
			BigDecimal segExtrapolacao, Boolean issolicitaros) {

		DwTParada dwTParada = (DwTParada) this;

		dwTParada.setIdTparada(idTparada);
		dwTParada.setOmTppt(omTppt);
		dwTParada.setDwTArea(dwTArea);
		dwTParada.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		dwTParada.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		dwTParada.setCdTparada(cdTparada);
		dwTParada.setRevisao(revisao);
		dwTParada.setDsTparada(dsTparada);
		dwTParada.setDtRevisao(dtRevisao);
		dwTParada.setStAtivo(stAtivo);
		dwTParada.setDtStativo(dtStativo);
		dwTParada.setIsRequerCausa(isRequerCausa);
		dwTParada.setIsRequerAcao(isRequerAcao);
		dwTParada.setIsRequerJust(isRequerJust);
		dwTParada.setIsPesa(isPesa);
		dwTParada.setIsRegulagem(isRegulagem);
		dwTParada.setIsFds(isFds);
		dwTParada.setIsMdo(isMdo);
		dwTParada.setIsMtbf(isMtbf);
		dwTParada.setIsPa(isPa);
		dwTParada.setIsPao(isPao);
		dwTParada.setIsPrev(isPrev);
		dwTParada.setIsPp(isPp);
		dwTParada.setIsPtp(isPtp);
		dwTParada.setIsScp(isScp);
		dwTParada.setQtTec(qtTec);
		dwTParada.setIsDefault(isDefault);
		dwTParada.setIsSemOp(isSemOp);
		dwTParada.setIsSemConexao(isSemConexao);
		dwTParada.setIsSemEvento(isSemEvento);
		dwTParada.setIsPermitecorrecao(isPermitecorrecao);
		dwTParada.setIsEntradarap(isEntradarap);
		dwTParada.setIsSaidarap(isSaidarap);
		dwTParada.setSegTimeoutalerta(segTimeoutalerta);
		dwTParada.setDwTAlerta(dwtalerta);
		dwTParada.setDwTParadaextra(dwtparada);
		dwTParada.setSegExtrapolacao(segExtrapolacao);
		dwTParada.setIsSolicitarOS(issolicitaros);
	}

	@Override
	protected DwTParada atribuir(DwTParada itemGet, DwTParada itemSet,
			boolean isCopiarFK) {

		if (itemSet == null) {
			itemSet = new DwTParada();
		}

		itemSet.set(
				itemGet.getIdTparada(),
				(isCopiarFK ? CloneUtil.clone(itemGet.getDwTParadaextra(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmTppt(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getDwTArea(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrstativo(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getOmUsrByIdUsrrevisao(),false) : null),
				(isCopiarFK ? CloneUtil.clone(itemGet.getDwTAlerta(),false) : null),
				itemGet.getCdTparada(),
				itemGet.getRevisao(),
				itemGet.getDsTparada(),
				itemGet.getDtRevisao(),
				itemGet.getStAtivo(),
				itemGet.getDtStativo(),
				itemGet.getIsRequerCausa(),
				itemGet.getIsRequerAcao(),
				itemGet.getIsRequerJust(),
				itemGet.getIsPesa(),
				itemGet.getIsRegulagem(),
				itemGet.getIsFds(),
				itemGet.getIsMdo(),
				itemGet.getIsMtbf(),
				itemGet.getIsPa(),
				itemGet.getIsPao(),
				itemGet.getIsPrev(),
				itemGet.getIsPp(),
				itemGet.getIsPtp(),
				itemGet.getIsScp(),
				itemGet.getQtTec(),
				itemGet.getIsDefault(),
				itemGet.getIsSemOp(),
				itemGet.getIsSemConexao(),
				itemGet.getIsSemEvento(),
				itemGet.getIsPermitecorrecao(),
				itemGet.getIsEntradarap(),
				itemGet.getIsSaidarap(),
				itemGet.getSegTimeoutalerta(),
				itemGet.getSegExtrapolacao(),
				itemGet.getIsSolicitarOS()
				);

		return itemSet;

	}

	public void limitarStrings(){
		DwTParada dwTParada = (DwTParada) this;
		dwTParada.setCdTparada(StringUtils.left(dwTParada.getCdTparada(), DwTParadaTemplate._MAX_LEN_CD_TPARADA));
		dwTParada.setDsTparada(StringUtils.left(dwTParada.getDsTparada(), DwTParadaTemplate._MAX_LEN_DS_TPARADA));
	}

	/**
	 * Atribui valores padr�o para as propriedades
	 * <br> isPesa = true
	 */
	public void setDefaultValues(){
		DwTParada dwTParada = (DwTParada) this;
		dwTParada.setIsPesa(true);
		dwTParada.setIsPermitecorrecao(true);
		dwTParada.setIsSolicitarOS(false);
	}
	
	/**
	 * Atribui valores padr�o para as propriedades, caso esteja nulo
	 */
	public void setDefaultValuesIfNull(){
		
		DwTParada dwTParada = getInstanceT();
		
		if(dwTParada.getIsPesa() == null){
			dwTParada.setIsPesa(false);
		}
		if (dwTParada.getIsSolicitarOS() == null) {
			dwTParada.setIsSolicitarOS(false);
		}

		// Parada de fim de semana
		if(dwTParada.getIsFds() == null){
			dwTParada.setIsFds(false);
		}

		// Parada de m�o de obra
		if(dwTParada.getIsMdo() == null){
			dwTParada.setIsMdo(false);
		}

		// Tempo médio entre falhas
		if(dwTParada.getIsMtbf() == null){
			dwTParada.setIsMtbf(false);
		}

		// Parada de avaria
		if(dwTParada.getIsPa() == null){
			dwTParada.setIsPa(false);
		}

		// Parada de anomalia organizacional
		if(dwTParada.getIsPao() == null){
			dwTParada.setIsPao(false);
		}

		// Parada de prepara��oo
		if(dwTParada.getIsPp() == null){
			dwTParada.setIsPp(false);
		}

		// Parada prevista
		if(dwTParada.getIsPrev() == null){
			dwTParada.setIsPrev(false);
		}

		// Parada de troca de produ��oo
		if(dwTParada.getIsPtp() == null){
			dwTParada.setIsPtp(false);
		}

		// Parada de regulagem
		if(dwTParada.getIsRegulagem() == null){
			dwTParada.setIsRegulagem(false); 
		}

		// Parada sem carteira de pedido
		if(dwTParada.getIsScp() == null){
			dwTParada.setIsScp(false); 
		}
		
		// Parada padr�o
		if(dwTParada.getIsDefault() == null){
			dwTParada.setIsDefault(false); 
		}

		// Parada para período sem op
		if(dwTParada.getIsSemOp() == null){
			dwTParada.setIsSemOp(false);
		}		
		
		// Parada para período sem evento
		if(dwTParada.getIsSemEvento() == null){
			dwTParada.setIsSemEvento(false);
		}	
	
		// Parada para período sem conex�o
		if(dwTParada.getIsSemConexao() == null){
			dwTParada.setIsSemConexao(false);
		}
		
	}
	
}
