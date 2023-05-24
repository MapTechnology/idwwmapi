package idw.model.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.SpObj;
import idw.model.pojos.SpProblema;

public class SpObjDAO {
	
	private final MapQuery q;
	private Session session;

    public SpObjDAO(Session session) {
    	this.session = session;
        q = new MapQuery(session);
    }
    
    public List<SpObj> getListaObjetivos(long idProblema) {
    	q.novaConsulta();
		q.append("SELECT spObj");
		q.append("FROM SpObj spObj");
		q.append("INNER JOIN spObj.spProblema spProblema");
		q.append("WHERE spProblema.idProblema = :idProblema");
		q.append("ORDER BY spObj.idObj");

		q.defineParametro("idProblema", new BigDecimal(idProblema));

		return q.list();
	}
    
    public SpObj getObjetivo(long idObj) {
    	q.novaConsulta();
		q.append("SELECT spObj");
		q.append("FROM SpObj spObj");
		q.append("WHERE spObj.idObj = :idObj");

		q.defineParametro("idObj", new BigDecimal(idObj));
		
		return (SpObj) q.uniqueResult();
	}

    
    public long insertObjetivo(long idObj, long idProblema, String texto) {

    	long retorno = 0L;
    	
    	//-- Primeiramente, garante que existe o param_idproblema no a3_problema
    	q.novaConsulta();
    	SpProblema retornoSpProblema = null;
    	SpObj spPersist = null;
		q.append("SELECT sp");
		q.append("FROM SpProblema sp");
		q.append("WHERE sp.idProblema = :idProblema");
		q.defineParametro("idProblema", new BigDecimal(idProblema));
		retornoSpProblema = (SpProblema) q.uniqueResult();
		if (retornoSpProblema!=null && retornoSpProblema.getIdProblema()!=null && retornoSpProblema.getIdProblema().longValue()>0L){
			
			//-- Busca saber se já existe param_idobj. Se já existir, Update, senão, Insert.
			boolean isInsert = true; // verifica se é mesmo INSERT ou se já existe e deve-se fazer UPDATE
			spPersist = this.getObjetivo(idObj);
			if (spPersist!=null && spPersist.getIdObj()!=null && spPersist.getIdObj().longValue()>0L){
				isInsert = false;
			}
			
			//-- Garante que se passado um ID-inexistente E <>0, retorna sem fazer nada.
			if ( (isInsert) && idObj!=0L){
				return 0L;
			}

			if(isInsert){
				//-- Insert
				spPersist = null;
				spPersist = new SpObj();
				SpProblema spprob = new SpProblema();
				spprob.setIdProblema( new BigDecimal( idProblema));
				spPersist.setSpProblema(spprob);
				spPersist.setTextoobj(texto);
				spPersist.setDtRevisao(new Date());
				spPersist.setDtStativo(new Date());
				this.session.persist(spPersist);
				this.session.flush();
				if (spPersist!=null && spPersist.getIdObj()!=null){
					retorno = spPersist.getIdObj().longValue();
				}
			} else
			{
				//Update
				spPersist.setTextoobj(texto);
				this.session.merge(spPersist);
				this.session.flush();
				retorno = spPersist.getIdObj().longValue();
			}
		  			
			
		}
		return retorno;
	}
    
}
