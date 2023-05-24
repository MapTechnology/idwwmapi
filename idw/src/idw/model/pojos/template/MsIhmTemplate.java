package idw.model.pojos.template;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import idw.model.pojos.MsIhm;
import idw.model.pojos.MsMsihm;
import idw.model.pojos.MsUpihm;
import ms.model.APojoMs;

public class MsIhmTemplate extends APojoMs<MsIhm>{
	

	@Override
	protected MsIhm atribuir(MsIhm from, MsIhm to,
			boolean isCopiarFK) {
		
		if (to == null)
			to = new MsIhm();
		
		to.setCdIhm(from.getCdIhm());
		
		if(from.getDthrCadastro() != null){
			to.setDthrCadastro((Date) from.getDthrCadastro().clone());
		}
		
		if(from.getDthrHeartbeat() != null){
			to.setDthrHeartbeat((Date) from.getDthrHeartbeat().clone());
		}
		
		if(from.getIdIhm() != null){
			to.setIdIhm(new BigDecimal(from.getIdIhm().doubleValue()));
		}
		
		if(from.getIsEvtalerta() != null){
			to.setIsEvtalerta(from.getIsEvtalerta());
		}
		
		if(from.getIsEvtciclofechado() != null){
			to.setIsEvtciclofechado(from.getIsEvtciclofechado());
		}
		
		if(from.getIsEvtlogin() != null){
			to.setIsEvtlogin(from.getIsEvtlogin());
		}
		
		if(from.getIsEvtparada() != null){
			to.setIsEvtparada(from.getIsEvtparada());
		}
		
		if(from.getIsEvtpnd() != null){
			to.setIsEvtpnd(from.getIsEvtpnd());
		}

		if(from.getIsEvtrefugo() != null){
			to.setIsEvtrefugo(from.getIsEvtrefugo());
		}

		if(from.getIsEvttodos() != null){
			to.setIsEvttodos(from.getIsEvttodos());
		}		
		
		if(from.getIsEvttrabalhando() != null){
			to.setIsEvttrabalhando(from.getIsEvttrabalhando());
		}
		
		if(from.getIsUpreg() != null){
			to.setIsUpreg(from.getIsUpreg());
		}
		
		if(isCopiarFK){
			
			if(from.getMsUsr() != null){
				to.setMsUsr(from.getMsUsr().clone(false));
			}
			
			if(from.getMsMsihms() != null){
				Set<MsMsihm> listaMsMsihm = new HashSet<MsMsihm>();
				for(MsMsihm msMsihm:from.getMsMsihms()){
					listaMsMsihm.add(msMsihm.clone(false));
				}
				to.setMsMsihms(listaMsMsihm);
			}

			
			if(from.getMsUpihms() != null){
				Set<MsUpihm> listaMsMsihms = new HashSet<MsUpihm>();
				for(MsUpihm msUpihm:from.getMsUpihms()){
					listaMsMsihms.add(msUpihm.clone(false));
				}
				to.setMsUpihms(listaMsMsihms);
			}
			
			
		}
			
		return to;
	}

}
