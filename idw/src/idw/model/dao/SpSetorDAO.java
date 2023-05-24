package idw.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmProduto;
import idw.model.pojos.SpSetor;
import idw.webservices.rest.mfv.dto.MfvSetorDTO;

public class SpSetorDAO {

	private final MapQuery q;
	private Session session;
	
	public SpSetorDAO(Session session) {
		this.session = session;		
		q = new MapQuery(session);
	}
	
	public SpSetor getSetor(long idSetor) {
		q.novaConsulta();
		q.append("SELECT spSetor");
		q.append("FROM SpSetor spSetor");
		q.append("WHERE spSetor.idSetor = :idSetor");

		q.defineParametro("idSetor", new BigDecimal( idSetor));

		return (SpSetor) q.uniqueResult();
	}	

	public List<SpSetor> getSetor(String dsSetor) {
		q.novaConsulta();
		q.append("SELECT spSetor");
		q.append("FROM SpSetor spSetor");
		q.append("WHERE spSetor.dsSetor = :dsSetor");

		q.defineParametro("dsSetor", dsSetor);

		return q.list();
	}
	
	public List<MfvSetorDTO> getListaMfvSetores(String cdProduto, long idSetor) {

		List<MfvSetorDTO> retorno = new ArrayList<MfvSetorDTO>();
		MfvSetorDTO retornoitem = new MfvSetorDTO(null, null, null, null, null, null,null,null,null);
		retorno.add(retornoitem);
		
		//-- Zero param check
		if(cdProduto==null || cdProduto.trim().equals("0") || cdProduto.trim().equals("")){
			return retorno;
		}
		if(idSetor==0L){
			return retorno;
		}
		

		//--Produto check
		OmProduto produto = null;
		OmProdutoDAO daoprd = new OmProdutoDAO(this.session);
		produto = daoprd.getOmProdutoPorCdAtivoOrderByIdDesc(cdProduto);
		if (produto==null){
			return retorno;
		}
		if (produto.getIdProduto()==0L){
			return retorno;
		}
		
		//--Setor check
		SpSetor setor = null;
		setor = this.getSetor(idSetor);
		if (setor==null){
			return retorno;
		}
		if (setor.getIdSetor().longValue()==0L){
			return retorno;
		}
		
		q.novaConsulta();
		q.append("SELECT  ");
		q.append("	NEW idw.webservices.rest.mfv.dto.MfvSetorDTO   ");
		q.append("	(     	 ");
		
		q.append(" a.idSetor as idsetor, ");
		q.append(" a.omGt.idGt as idgt, ");
		q.append(" a.cdSetor as cdsetor,  ");
		q.append(" a.dsSetor as dssetor, ");
		q.append(" a.tpSetor as tp_setor,  ");
		q.append(" a.ordem as ord, ");
		q.append(" m.minLeadtime as  vleadtime, ");
		q.append(" m.segCicletime as vcicletime, ");
		q.append(" m.percOee as vpercoee ");
		
		q.append("	)      ");
		q.append(" from  ");
		q.append(" 	SpSetor a ");
		q.append(" 	LEFT JOIN  a.spMfvs m ");
		q.append(" WHERE  ");
		q.append(" 	m.cdProduto = :cdProduto ");
		q.append(" 	AND a.idSetor = :idSetor ");
		///--q.append(" no	-- AND m.stAtivo = 1 ");		
		q.defineParametro("idSetor", new BigDecimal( idSetor) );
		q.defineParametro("cdProduto", cdProduto);
		retorno = q.list();

		return retorno;
	}	

	
	public List<MfvSetorDTO> getListaMfvSetoresCdProduto(String cdProduto) {
		//fa3setoresmfv
		List<MfvSetorDTO> retorno = new ArrayList<MfvSetorDTO>();
		MfvSetorDTO retornoitem = new MfvSetorDTO(null, null, null, null, null, null,null,null,null);
		retorno.add(retornoitem);
		
		//-- Zero param check
		if(cdProduto==null || cdProduto.trim().equals("0") || cdProduto.trim().equals("")){
			return retorno;
		}


		//--Produto check
		OmProduto produto = null;
		OmProdutoDAO daoprd = new OmProdutoDAO(this.session);
		produto = daoprd.getOmProdutoPorCdAtivoOrderByIdDesc(cdProduto);
		if (produto==null){
			return retorno;
		}
		if (produto.getIdProduto()==0L){
			return retorno;
		}
		
		
		
		q.novaConsulta();
		q.append("SELECT  ");
		q.append("	NEW idw.webservices.rest.mfv.dto.MfvSetorDTO   ");
		q.append("	(     	 ");
		
		q.append(" a.idSetor as idsetor, ");
		q.append(" a.omGt.idGt as idgt, ");
		q.append(" a.cdSetor as cdsetor,  ");
		q.append(" a.dsSetor as dssetor, ");
		q.append(" a.tpSetor as tp_setor,  ");
		q.append(" a.ordem as ord, ");
		q.append(" m.minLeadtime as  vleadtime, ");
		q.append(" m.segCicletime as vcicletime, ");
		q.append(" m.percOee as vpercoee ");
		
		q.append("	)      ");
		q.append(" from  ");
		q.append(" 	SpSetor a ");
		q.append(" 	LEFT JOIN  a.spMfvs m ");
		q.append(" WHERE  ");
		q.append(" 	m.cdProduto = :cdProduto ");
		q.append(" 	order by a.ordem  ");
		

		q.defineParametro("cdProduto", cdProduto);
		retorno = q.list();

		return retorno;
	}	
}
