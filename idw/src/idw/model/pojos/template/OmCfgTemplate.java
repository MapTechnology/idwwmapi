package idw.model.pojos.template;

import idw.model.IPojoMAP;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwFtParam;
import idw.model.pojos.DwPepro;
import idw.model.pojos.DwTRitmo;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgabc;
import idw.model.pojos.OmEmpresa;
import idw.util.CloneUtil;

public abstract class OmCfgTemplate extends AbstractTemplate<OmCfg> implements IPojoMAP {

	public static final String _FIELD_NAME_CD = "IdCfg";
	
	public enum TpWhatsapp {
		_SEMWHATSAPP(0),
		_TWILIO(1);

		private final int value;

		private TpWhatsapp(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

	}


	@Override
	public Long getId() {		
		return getInstanceT().getIdCfg();
	}
	
	@Override
	public void setId(Long id) {
		getInstanceT().setIdCfg(id == null ? 0L: id.longValue());
	}	
	

	@Override
	public String getCd() {
		return String.valueOf(((OmCfg) this).getIdCfg());
	}

	@Override
	public String getFieldNameCd() {
		return OmCfgTemplate._FIELD_NAME_CD;
	}

	@Override
	protected OmCfg atribuir(OmCfg from, OmCfg to, boolean isCopiarFK) {
		if (to == null) {
			to = new OmCfg();
		}

		to.setDsMensagemsobretensao(from.getDsMensagemsobretensao());
		to.setDsMensagemsubtensao(from.getDsMensagemsubtensao());
		to.setDtRevisao(from.getDtRevisao());
		to.setDtStativo(from.getDtStativo());
		to.setIdCfg(from.getIdCfg());
		to.setIsLogonobrigatorio(from.getIsLogonobrigatorio());
		to.setIsNivelfeeder(from.getIsNivelfeeder());
		to.setIsIhmtrocaop(from.getIsIhmtrocaop());
		to.setMascaracdprodutomp(from.getMascaracdprodutomp());
		to.setMascaracdprodutoCF(from.getMascaracdprodutoCF());
		to.setMascaraQtd(from.getMascaraQtd());
		to.setMascaracb(from.getMascaracb());
		to.setMascarafolha(from.getMascarafolha());
		to.setQtMaxetapateste(from.getQtMaxetapateste());
		to.setQtMaxptcoletafull(from.getQtMaxptcoletafull());
		to.setQtMaxsubetapas(from.getQtMaxsubetapas());
		to.setRevisao(from.getRevisao());
		to.setSegAutologout(from.getSegAutologout());
		to.setSegFeedbacklogin(from.getSegFeedbacklogin());
		to.setSegHeartbeat(from.getSegHeartbeat());
		to.setDthrEstliberado(from.getDthrEstliberado());
		to.setMascaraop(from.getMascaraop());
		to.setMascaracdprodutoCB(from.getMascaracdprodutoCB());
		to.setIsContacicloimprodutivoregula(from.getIsContacicloimprodutivoregula());
		to.setIsRequerTecnicoFimCip(from.getIsRequerTecnicoFimCip());
		to.setIsRequerTecnicoInicioCip(from.getIsRequerTecnicoInicioCip());
		to.setIsImpMapaQtUnica(from.getIsImpMapaQtUnica());
		to.setLogin(from.getLogin());
		to.setSenha(from.getSenha());
		to.setEmailsscriptpadraonc(from.getEmailsscriptpadraonc());
		to.setEmailaoi(from.getEmailaoi());
		to.setTpWhatsapp(from.getTpWhatsapp());
		to.setIdWhatsapp(from.getIdWhatsapp());
		to.setPwWhatsapp(from.getPwWhatsapp());
		to.setTelWhatsapp(from.getTelWhatsapp());
		
		to.setIsLogoutautomatico(from.getIsLogoutautomatico());
		to.setSegLogoutautomatico(from.getSegLogoutautomatico());
				
		if (isCopiarFK == true) {
			try {
				to.setDwTAlerta(from.getDwTAlerta().clone(false));
			} catch (Exception e) {
				to.setDwTAlerta(null);
			}
			try {
				to.setDwTRitmo(from.getDwTRitmo().clone(false));
			} catch (Exception e) {
				to.setDwTRitmo(null);
			}
			try {
				to.setDwTParadaByIdTparadacip(from.getDwTParadaByIdTparadacip().clone(false));
			} catch (Exception e) {
				to.setDwTParadaByIdTparadacip(null);
			}
			try {
				to.setDwTParadasemconexao(from.getDwTParadasemconexao().clone(false));
			} catch (Exception e) {
				to.setDwTParadasemconexao(null);
			}
			
			try {
				to.setDwCal(new DwCal());
				to.getDwCal().copy(from.getDwCal(), false);
			} catch (Exception e) {
				to.setDwCal(null);
			}
			try {
				to.setOmCfgabc(new OmCfgabc());
				to.setOmCfgabc(from.getOmCfgabc().clone(false));
			} catch (Exception e) {
				to.setOmCfgabc(null);
			}
			try {
				to.setDwTRitmo(new DwTRitmo());
				to.setDwTRitmo(from.getDwTRitmo().clone(false));
			} catch (Exception e) {
				to.setDwTRitmo(null);
			}
			try {
				to.setOmEmpresa(new OmEmpresa());
				to.setOmEmpresa(from.getOmEmpresa().clone(false));
			} catch (Exception e) {
				to.setOmEmpresa(null);
			}
			try {
				to.setDwEstByIdEstAlimentacao(new DwEst());
				to.getDwEstByIdEstAlimentacao().copy(from.getDwEstByIdEstAlimentacao(), false);
			} catch (Exception e) {
				to.setDwEstByIdEstAlimentacao(null);
			}
			try {
				to.setDwEstlocalorigalim(new DwEstlocal());
				to.getDwEstlocalorigalim().copy(from.getDwEstlocalorigalim(), false);
			} catch (Exception e) {
				to.setDwEstlocalorigalim(null);
			}
			try {
				to.setDwEstByIdEstexpedicao((DwEst) from
						.getDwEstByIdEstexpedicao().clone(false));
			} catch (Exception e) {
				to.setDwEstByIdEstexpedicao(null);
			}
			try {
				to.setDwEstByIdEstmp((DwEst) from
						.getDwEstByIdEstmp().clone(false));
			} catch (Exception e) {
				to.setDwEstByIdEstmp(null);
			}
			try {
				to.setDwEstByIdEstliberado((DwEst) from
						.getDwEstByIdEstliberado().clone(false));
			} catch (Exception e) {
				to.setDwEstByIdEstliberado(null);
			}
			try {
				to.setDwEstByIdEstrefugo((DwEst) from.getDwEstByIdEstrefugo()
						.clone(false));
			} catch (Exception e) {
				to.setDwEstByIdEstrefugo(null);
			}
			try {
				to.setDwEstByIdEstproducao((DwEst) from.getDwEstByIdEstproducao()
						.clone(false));
			} catch (Exception e) {
				to.setDwEstByIdEstproducao(null);
			}
			try {
				to.setDwFtParamByIdFtParamcorrente((DwFtParam) from
						.getDwFtParamByIdFtParamcorrente().clone(false));
			} catch (Exception e) {
				to.setDwFtParamByIdFtParamcorrente(null);
			}
			try {
				to.setDwFtParamByIdFtParamfp((DwFtParam) from.getDwFtParamByIdFtParamfp().clone(false));
			} catch (Exception e) {
				to.setDwFtParamByIdFtParamfp(null);
			}
			try {
				to.setDwFtParamByIdFtParamec((DwFtParam) from.getDwFtParamByIdFtParamec().clone(false));
			} catch (Exception e) {
				to.setDwFtParamByIdFtParamec(null);
			}
			try {
				to.setDwFtParamByIdFtParamTemp((DwFtParam) from.getDwFtParamByIdFtParamTemp().clone(false));
			} catch (Exception e) {
				to.setDwFtParamByIdFtParamTemp(null);
			}
			try {
				to.setDwFtParamByIdFtParamflusos((DwFtParam) from
						.getDwFtParamByIdFtParamflusos().clone(false));
			} catch (Exception e) {
				to.setDwFtParamByIdFtParamflusos(null);
			}
			try {
				to.setDwFtParamByIdFtParamfluxoe((DwFtParam) from
						.getDwFtParamByIdFtParamfluxoe().clone(false));
			} catch (Exception e) {
				to.setDwFtParamByIdFtParamfluxoe(null);
			}
			try {
				to.setDwFtParamByIdFtParamtensao((DwFtParam) from
						.getDwFtParamByIdFtParamtensao().clone(false));
			} catch (Exception e) {
				to.setDwFtParamByIdFtParamtensao(null);
			}
			try {
				to.setDwPeproByIdPeproctreproc((DwPepro) from
						.getDwPeproByIdPeproctreproc().clone());
			} catch (Exception e) {
				to.setDwPeproByIdPeproctreproc(null);
			}
			try {
				to.setDwPeproByIdPepronormal((DwPepro) from
						.getDwPeproByIdPepronormal().clone());
			} catch (Exception e) {
				to.setDwPeproByIdPepronormal(null);
			}
			try {
				to.setOmCcdefault(from.getOmCcdefault().clone(false));
			} catch (Exception e) {
			}
			try {
				to.setOmProduto(from.getOmProduto().clone(false));
			} catch (Exception e) {
				to.setOmProduto(null);
			}
			try {
				to.setOmResgui(from.getOmResgui().clone(false));
			} catch (Exception e) {
				to.setOmResgui(null);
			}
			try {
				to.setOmTpgtByIdTpgtfabrica(from.getOmTpgtByIdTpgtfabrica().clone(false));
			} catch (Exception e) {
			}
			try {
				to.setOmTpgtByIdTpgtlogsuper(from.getOmTpgtByIdTpgtlogsuper().clone(false));
			} catch (Exception e) {
			}
			try {
				to.setOmTpptByIdTpptinsersora(from
						.getOmTpptByIdTpptinsersora().clone(false));
			} catch (Exception e) {
				to.setOmTpptByIdTpptinsersora(null);
			}
			try {
				to.setOmTpptByIdTpptpm(from.getOmTpptByIdTpptpm()
						.clone(false));
			} catch (Exception e) {
				to.setOmTpptByIdTpptpm(null);
			}
			try {
				to.setOmTpptByIdTpptppass(from
						.getOmTpptByIdTpptppass().clone(false));
			} catch (Exception e) {
				to.setOmTpptByIdTpptppass(null);
			}
			try {
				to.setOmTpptByIdTpptprepro(from
						.getOmTpptByIdTpptprepro().clone(false));
			} catch (Exception e) {
				to.setOmTpptByIdTpptprepro(null);
			}
			try {
				to.setOmTpptByIdTpptptf(from.getOmTpptByIdTpptptf()
						.clone(false));
			} catch (Exception e) {
				to.setOmTpptByIdTpptptf(null);
			}
			try {
				to.setOmTpptByIdTpptpts(from.getOmTpptByIdTpptpts()
						.clone(false));
			} catch (Exception e) {
				to.setOmTpptByIdTpptpts(null);
			}
			try {
				to.setOmTpptByIdTpptptscd(from
						.getOmTpptByIdTpptptscd().clone(false));
			} catch (Exception e) {
				to.setOmTpptByIdTpptptscd(null);
			}
			try {
				to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao()
						.clone(false));
			} catch (Exception e) {
				to.setOmUsrByIdUsrrevisao(null);
			}
			try {
				to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo()
						.clone(false));
			} catch (Exception e) {
				to.setOmUsrByIdUsrstativo(null);
			}
			try {
				to.setOmUsrgrpByIdUsrgrpoperador(from
						.getOmUsrgrpByIdUsrgrpoperador().clone(false));
			} catch (Exception e) {
				to.setOmUsrgrpByIdUsrgrpoperador(null);
			}
			try {
				to.setOmUsrgrpByIdUsrgrpmonitor(from.getOmUsrgrpByIdUsrgrpmonitor().clone(false));
			} catch (Exception e) {
				to.setOmUsrgrpByIdUsrgrpmonitor(null);
			}
			try {
				to.setOmUsrgrpByIdUsrgrptecnico(from.getOmUsrgrpByIdUsrgrptecnico().clone(false));
			} catch (Exception e) {
				to.setOmUsrgrpByIdUsrgrptecnico(null);
			}
			try {
				to.setOmUsrgrpByIdUsrgrpsupervisor(from
						.getOmUsrgrpByIdUsrgrpsupervisor().clone(false));
			} catch (Exception e) {
				to.setOmUsrgrpByIdUsrgrpsupervisor(null);
			}
			try {
				to.setOmUsrimpprog(from.getOmUsrimpprog().clone(false));
			} catch (Exception e) {
				to.setOmUsrimpprog(null);
			}
			
			to.setOmGtimpcic(CloneUtil.clone(from.getOmGtimpcic(), false));
			
			try{
				to.setDwTParada(from.getDwTParada().clone(false));
			}catch(Exception e){
				to.setDwTParada(null);
			}
			try{
				to.setDwTRefugo(from.getDwTRefugo().clone(false));
			}catch(Exception e){
				to.setDwTRefugo(null);
			}
			try {
				to.setOmEmpresa(from.getOmEmpresa().clone(false));
			} catch (Exception e) {
				to.setOmEmpresa(null);
			}
			try {
				to.setOmRegrasNscbByIdRegrasCb(from.getOmRegrasNscbByIdRegrasCb().clone(false));
			} catch (Exception e) {
				to.setOmRegrasNscbByIdRegrasCb(null);
			}
			try {
				to.setOmRegrasNscbByIdRegrasNs(from.getOmRegrasNscbByIdRegrasNs().clone(false));
			} catch (Exception e) {
				to.setOmRegrasNscbByIdRegrasNs(null);
			}
//				to.setDwTParada(CloneUtil.clone(from.getDwTParada(), false));
		}else if (isCopiarFK == false){

			to.setDwCal(from.getDwCal());
			to.setDwEstByIdEstexpedicao(from.getDwEstByIdEstexpedicao());
			to.setDwEstByIdEstmp(from.getDwEstByIdEstmp());
			to.setDwEstByIdEstliberado(from.getDwEstByIdEstliberado());
			to.setDwEstByIdEstrefugo(from.getDwEstByIdEstrefugo());
			to.setDwEstByIdEstproducao(from.getDwEstByIdEstproducao());
			to.setDwFtParamByIdFtParamcorrente(from.getDwFtParamByIdFtParamcorrente());
			to.setDwFtParamByIdFtParamflusos(from.getDwFtParamByIdFtParamflusos());
			to.setDwFtParamByIdFtParamfluxoe(from.getDwFtParamByIdFtParamfluxoe());
			to.setDwFtParamByIdFtParamtensao(from.getDwFtParamByIdFtParamtensao());
			to.setDwPeproByIdPeproctreproc(from.getDwPeproByIdPeproctreproc());
			to.setDwPeproByIdPepronormal(from.getDwPeproByIdPepronormal());
			to.setOmCcdefault(from.getOmCcdefault());
//			 to.setOmCfgptdetcoletas(from.getOmCfgptdetcoletas().clone());
//			 to.setOmCfgscrpimps(from.getOmCfgscrpimps().clone());
			to.setOmProduto(from.getOmProduto());
			to.setOmResgui(from.getOmResgui());
			to.setOmTpgtByIdTpgtfabrica(from.getOmTpgtByIdTpgtfabrica());
			to.setOmTpgtByIdTpgtlogsuper(from.getOmTpgtByIdTpgtlogsuper());
			to.setOmTpptByIdTpptinsersora(from.getOmTpptByIdTpptinsersora());
			to.setOmTpptByIdTpptpm(from.getOmTpptByIdTpptpm());
			to.setOmTpptByIdTpptppass(from.getOmTpptByIdTpptppass());
			to.setOmTpptByIdTpptprepro(from.getOmTpptByIdTpptprepro());
			to.setOmTpptByIdTpptptf(from.getOmTpptByIdTpptptf());
			to.setOmTpptByIdTpptpts(from.getOmTpptByIdTpptpts());
			to.setOmTpptByIdTpptptscd(from.getOmTpptByIdTpptptscd());
			to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao());
			to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo());
			to.setOmUsrgrpByIdUsrgrpoperador(from.getOmUsrgrpByIdUsrgrpoperador());
			to.setOmUsrgrpByIdUsrgrpsupervisor(from.getOmUsrgrpByIdUsrgrpsupervisor());
			to.setOmUsrgrpByIdUsrgrpmonitor(from.getOmUsrgrpByIdUsrgrpmonitor());
			to.setOmUsrgrpByIdUsrgrptecnico(from.getOmUsrgrpByIdUsrgrptecnico());
			to.setOmUsrimpprog(from.getOmUsrimpprog());
			to.setOmGtimpcic(from.getOmGtimpcic());
			to.setDwTParada(from.getDwTParada());
			to.setDwEstByIdEstAlimentacao(from.getDwEstByIdEstAlimentacao());
			to.setDwEstlocalorigalim(from.getDwEstlocalorigalim());
			
		}

		return to;
		// OmUsr omUsrRev = new OmUsr();
		// try {
		// omUsrRev.setCdUsr(item.getOmUsrByIdUsrrevisao().getCdUsr());
		// omUsrRev.setDsNome(item.getOmUsrByIdUsrrevisao().getDsNome());
		// } catch (Exception e) {
		// }
		// clone.setOmUsrByIdUsrrevisao(omUsrRev);
		//
		// if (isCopiarFK){
		// to.setOmUsrByIdUsrrevisao(from.getOmUsrByIdUsrrevisao());
		// to.setOmUsrByIdUsrstativo(from.getOmUsrByIdUsrstativo());
		// }
	}
}
