package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import idw.model.IPojoMAP;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRapGrupo;
import idw.model.pojos.DwRappro;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpIndispRappt;
import idw.util.CloneUtil;
import idw.util.EqualsBuilderIdw;
import idw.util.HashCodeBuilderIdw;

public abstract class DwRapTemplate extends AbstractTemplate<DwRap> implements IPojoMAP{
	public static final String _FIELD_NAME_CD = "CdRap";

	private static final int _MAX_LEN_CD_RAP = 30;
	private static final int _MAX_LEN_DS_RAP = 100;
	private static final int _MAX_LEN_DEPARA = 100;

	@Override
	public Long getId() {		
		return getInstanceT().getIdRap();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdRap(id);
	}	
	
	@Override
	public String getCd() {
		return ((DwRap)this).getCdRap();
	}

	@Override
	public String getFieldNameCd() {
		return DwRapTemplate._FIELD_NAME_CD;
	}

	@Override
	public boolean equals(Object o){
		boolean equals = false;
		if((o != null) && this.getClass().isAssignableFrom(o.getClass())){
			final DwRap dwRapOther = (DwRap) o;
			final DwRap dwRap = (DwRap) this;
			equals = (new EqualsBuilderIdw())
						.append(dwRap.getCdRap(), dwRapOther.getCdRap())
						.append(dwRap.getDsRap(), dwRapOther.getDsRap())
						.append(dwRap.getDepara(), dwRapOther.getDepara())
						.append(dwRap.getDwRap(), dwRapOther.getDwRap())
						.append(dwRap.getStAtivo(), dwRapOther.getStAtivo())
						.isEquals();
		}
		return equals;
	}

	@Override
	public int hashCode(){

		DwRap dwRap = (DwRap) this;

		return (new HashCodeBuilderIdw())
						.append(dwRap.getCdRap())
						.append(dwRap.getDsRap())
						.append(dwRap.getDepara())
						.append(dwRap.getDwRap())
						.append(dwRap.getStAtivo())
						.toHashCode();
	}

	public void set(Long idRap, String cdRap, Long revisao, Date dtStativo, Date dtRevisao, Byte stAtivo,
					String dsRap, BigDecimal qtTotal, BigDecimal qtAlocada, String depara,
					BigDecimal segTempoliberacao, Byte tpRap, Integer qtCiclosEntreManutencao, Integer qtAutoCiclosTotais, Integer qtAutoCiclosDesdeultimaManutencao,
					String proprietario, String origem, Date dtFabricacao, String versao, String justificativaversao){

		DwRap dwRap = (DwRap) this;
		dwRap.setIdRap(idRap);
		dwRap.setCdRap(cdRap);
		dwRap.setRevisao(revisao);
		dwRap.setDtStativo(dtStativo);
		dwRap.setDtRevisao(dtRevisao);
		dwRap.setStAtivo(stAtivo);
		dwRap.setDsRap(dsRap);
		dwRap.setQtTotal(qtTotal);
		dwRap.setQtAlocada(qtAlocada);
		dwRap.setDepara(depara);
		dwRap.setSegTempoliberacao(segTempoliberacao);
		dwRap.setQtCiclosEntreManutencao(qtCiclosEntreManutencao);
		dwRap.setQtAutoCiclosTotais(qtAutoCiclosTotais);
		dwRap.setQtAutoCiclosDesdeultimaManutencao(qtAutoCiclosDesdeultimaManutencao);
		dwRap.setProprietario(proprietario);
		dwRap.setOrigem(origem);
		dwRap.setDtFabricacao(dtFabricacao);
		dwRap.setVersao(versao);
		dwRap.setJustificativaversao(justificativaversao);
		
		if (tpRap != null)
			dwRap.setTpRap(new BigDecimal(tpRap));

	}

	public void set(Long idRap, String cdRap, Long revisao, Date dtStativo, Date dtRevisao, Byte stAtivo,
					String dsRap, BigDecimal qtTotal, BigDecimal qtAlocada, String depara,
					BigDecimal segTempoliberacao,
					DwRap dwRap, OmUsr omUsrByIdUsrstativo, OmUsr omUsrByIdUsrrevisao, Byte tpRap, PpCliente ppcliente,
					Integer qtCiclosEntreManutencao, Integer qtAutoCiclosTotais, Integer qtAutoCiclosDesdeultimaManutencao,
					String proprietario, String origem, Date dtFabricacao, String versao, String justificativaversao){
		this.set(idRap, cdRap, revisao, dtStativo, dtRevisao, stAtivo, dsRap, qtTotal, qtAlocada, depara, segTempoliberacao, tpRap, qtCiclosEntreManutencao, qtAutoCiclosTotais, qtAutoCiclosDesdeultimaManutencao, proprietario, origem, dtFabricacao, versao, justificativaversao);
		this.set(dwRap, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, ppcliente);
	}

	public void set(DwRap dwRap, OmUsr omUsrByIdUsrstativo, OmUsr omUsrByIdUsrrevisao, PpCliente ppcliente){
		DwRap obj = (DwRap) this;
		obj.setDwRap(dwRap);
		obj.setOmUsrByIdUsrrevisao(omUsrByIdUsrrevisao);
		obj.setOmUsrByIdUsrstativo(omUsrByIdUsrstativo);
		obj.setPpCliente(ppcliente);
	}

	@Override
	protected DwRap atribuir(DwRap from, DwRap to, boolean isCopiarFK) {
		if (to == null) {
			to = new DwRap();
		}

		to.set(
				from.getIdRap(),
				from.getCdRap(),
				from.getRevisao(),
				from.getDtStativo(),
				from.getDtRevisao(),
				from.getStAtivo(),
				from.getDsRap(),
				from.getQtTotal(),
				from.getQtAlocada(),
				from.getDepara(),
				from.getSegTempoliberacao(),
				null,
				from.getQtCiclosEntreManutencao(), 
				from.getQtAutoCiclosTotais(), 
				from.getQtAutoCiclosDesdeultimaManutencao(),
				from.getProprietario(), 
				from.getOrigem(), 
				from.getDtFabricacao(), 
				from.getVersao(), 
				from.getJustificativaversao()
				);

		if (isCopiarFK == true){

			to.setOmUsrByIdUsrrevisao(CloneUtil.clone(from.getOmUsrByIdUsrrevisao(),false));
			to.setOmUsrByIdUsrstativo(CloneUtil.clone(from.getOmUsrByIdUsrstativo(),false));
			to.setPpCliente(CloneUtil.clone(from.getPpCliente(), false));
			//DwFolharap
			if (from.getDwFolharaps() != null) {
				to.setDwFolharaps(new HashSet<DwFolharap>());
				for(DwFolharap rap : from.getDwFolharaps()){
					to.getDwFolharaps().add(rap.clone());
				}
			}

			//PpIndispRappt
			if (from.getPpIndispRappts() != null) {
				to.setPpIndispRappts(new HashSet<PpIndispRappt>());
				for(PpIndispRappt ppIndis : from.getPpIndispRappts()){
					to.getPpIndispRappts().add(ppIndis.clone());
				}
			}
			
			//DwRapGrupos
			if(from.getDwRapGrupos() != null) {
				to.setDwRapGrupos(new HashSet<DwRapGrupo>());
				for(DwRapGrupo dwRapGrupo : from.getDwRapGrupos()) {
					to.getDwRapGrupos().add(dwRapGrupo.clone());
				}
			}
			
			if (from.getDwEstlocal() != null)
				to.setDwEstlocal(from.getDwEstlocal().clone(false));
			else
				to.setDwEstlocal(null);
			
			if (from.getDwTprap() != null)
				to.setDwTprap(from.getDwTprap().clone(false));
			else
				to.setDwTprap(null);
			
			if (from.getOmCc() != null)
				to.setOmCc(from.getOmCc().clone(false));
			else
				to.setOmCc(null);
			
			if (from.getOmGt() != null)
				to.setOmGt(from.getOmGt().clone(false));
			else
				to.setOmGt(null);
			
			if (from.getDwRappros() != null) {
				to.setDwRappros(new HashSet<DwRappro>());
				for (DwRappro dwrappro : from.getDwRappros()) {
					to.getDwRappros().add(dwrappro.clone());
				}
			}

		}

		return to;
	}

	public void limitarStrings(){
		DwRap dwRap = (DwRap) this;
		dwRap.setCdRap(StringUtils.left(dwRap.getCdRap(), DwRapTemplate._MAX_LEN_CD_RAP));
		dwRap.setDsRap(StringUtils.left(dwRap.getDsRap(), DwRapTemplate._MAX_LEN_DS_RAP));
		dwRap.setDepara(StringUtils.left(dwRap.getDepara(), DwRapTemplate._MAX_LEN_DEPARA));
	}

}
