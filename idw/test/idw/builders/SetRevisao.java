package idw.builders;

import idw.model.IPojoMAP;
import idw.model.pojos.OmUsr;

import java.util.Date;


public class SetRevisao {
	public final static Date DATE = new Date(); 
	public final static byte ST_ATIVO  = 1;
	public final static long REVISAO = 1l;
	
	//public static Date date = new Date();
	public static void set(IPojoMAP pojo){
//		pojo.setDtRevisao(date);
//		pojo.setDtRevisao(date);
	}

	public static void set(IPojoMAP pojo, OmUsr omUsr){
		set(pojo);
		pojo.setOmUsrByIdUsrrevisao(omUsr);
		pojo.setOmUsrByIdUsrstativo(omUsr);
//		pojo.setRevisao(revisao);
//		pojo.setStAtivo(stAtivo)
	}	
}
