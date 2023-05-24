package idw.model.rn;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.OmTppt;
import idw.util.Util;
import idw.webservices.dto.DefeitoDTO;
import injetws.model.excessoes.SemSGBDException;

public class VerificaDefeitoRN extends DAOGenerico {
	
	public DefeitoDTO verificaDefeito(DefeitoDTO defeito) {
		DefeitoDTO retorno = new DefeitoDTO();
		
		retorno.setIdPassagem(defeito.getIdPassagem());
		retorno.setIdPassdef(defeito.getIdPassdef());
		
		// Verificação se o defeito existe para o tipo de posto
		DwTDefeito oDwTDefeito = null;
		oDwTDefeito = this.getTDefeito(defeito);
		
		if(oDwTDefeito == null) { // se não existir
			retorno.getResultado().setIdmensagem(retorno.getResultado().getDEFEITO_DESCONHECIDO());
		}
		else { // se existir
			retorno.setIdTDefeito(oDwTDefeito.getIdTdefeito());
			retorno.getResultado().setIdmensagem(retorno.getResultado().getCOM_SUCESSO());
		}
		
		return(retorno);
	}
	
	public DwTDefeito getTDefeito(DefeitoDTO defeito) {
		String hql = "";
		
		//select * 
		//from dw_t_defeito
		//where st_ativo=1 and cd_tdefeito = defeito.cb and id_tppt = defeito.id_tppt
		
		hql += "SELECT dwtdefeito ";
		hql += "FROM DwTDefeito dwtdefeito ";
//		hql += "JOIN dwtdefeito.omTppt omtppt ";
		hql += "WHERE dwtdefeito.stAtivo = 1 AND ";
		hql += "dwtdefeito.cdTdefeito = '::cdTdefeito' AND ";
		hql += "dwtdefeito.omTppt.idTppt = ::idTppt ";
		
		hql = hql.replaceAll("::cdTdefeito", defeito.getCb());
		hql = hql.replaceAll("::idTppt", String.valueOf(defeito.getIdTppt()));
		
		DwTDefeito oDwTDefeito = null;
		try {
			oDwTDefeito = Util.getDadosBanco(new DwTDefeito(), this.getSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ????????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oDwTDefeito = null;
		}
		
		return(oDwTDefeito);
	}	
	public DwTDefeito getTDefeito(long id) {
		String hql = "";
		
		//select * 
		//from dw_t_defeito
		//where st_ativo=1 and cd_tdefeito = defeito.cb and id_tppt = defeito.id_tppt
		
		hql += "SELECT dwtdefeito ";
		hql += "FROM DwTDefeito dwtdefeito ";
//		hql += "JOIN dwtdefeito.omTppt omtppt ";
		hql += "WHERE dwtdefeito.stAtivo = 1 AND ";
		hql += "dwtdefeito.idTdefeito = ::idTdefeito ";
		
		hql = hql.replaceAll("::idTdefeito", String.valueOf(id));
		
		DwTDefeito oDwTDefeito = null;
		try {
			oDwTDefeito = Util.getDadosBanco(new DwTDefeito(), this.getSession(), hql);
		} catch (SemSGBDException e) {
			// TODO: ????????????????????????????
			e.printStackTrace();
		} catch (RegistroDesconhecidoException e) {
			oDwTDefeito = null;
		}
		
		return(oDwTDefeito);
	}
	public DwTDefeito getTDefeito(OmTppt omtppt, String cdDefeito) {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select a");
		q.append("from DwTDefeito a");
		q.append("where a.omTppt = :omtppt");
		q.append("and a.cdTdefeito = :cddefeito");
		q.append("and a.stAtivo = 1");
		q.defineParametro("omtppt", omtppt);
		q.defineParametro("cddefeito", cdDefeito);
		q.setMaxResults(1);
		return (DwTDefeito) q.uniqueResult();
	}
}
