package idw.model.rn;

import idw.model.dao.DAOGenerico;
import idw.model.dao.SpPlanoDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmUsr;
import idw.model.pojos.SpPlano;
import idw.model.pojos.SpPlanoresp;

public class SpPlanoRN extends AbstractRN<DAOGenerico> {

	private final String formatoData;
	private final String formatoDataHora;
	


	public SpPlanoRN(String formatoData, String formatoDataHora) {
		this(null,  formatoData,  formatoDataHora);
	}

	public SpPlanoRN(DAOGenerico dao, String formatoData, String formatoDataHora) {
		super(dao );
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
		this.formatoData = formatoData;
		this.formatoDataHora = formatoDataHora;
		
		
		
	}

	public SpPlano deletarPlano(int idPlano) throws RegistroDesconhecidoException {
		SpPlanoDAO dao = new SpPlanoDAO(getDaoSession(), formatoData, formatoDataHora);

		SpPlano plano = dao.getPlano(idPlano);
		if (plano == null) {
			throw new RegistroDesconhecidoException();
		}
		if (plano.getSpPlanoresps()!=null){
			for (SpPlanoresp pr : plano.getSpPlanoresps()){
				this.getDao().delete(pr);
			}
		}
		this.getDao().delete(plano);
		return plano;
	}


	public SpPlanoresp deletarPlanoresp(int idPlanoresp) throws RegistroDesconhecidoException {
		SpPlanoDAO dao = new SpPlanoDAO(getDaoSession(), formatoData, formatoDataHora);

		SpPlanoresp planoresp = dao.getPlanoresp(idPlanoresp);
		if (planoresp == null) {
			throw new RegistroDesconhecidoException();
		}
		this.getDao().delete(planoresp);
		return planoresp;
	}

	public long insertPlano(
			long idPlano 
			, long idProblema
			, String problemaoque 
			, String acaocomo
			, String prazoiniquando
			, String prazofimquando
			, int statuspercconclusao
			) throws RegistroDesconhecidoException {




		SpPlanoDAO dao = new SpPlanoDAO(getDaoSession(),formatoData,  formatoDataHora);
		
		long id = dao.insertPlano(
				idPlano 
				,  idProblema
				,  problemaoque 
				,  acaocomo
				,  prazoiniquando
				,  prazofimquando
				,  statuspercconclusao
				);
		if (id == 0L) {
			throw new RegistroDesconhecidoException();
		}
		return id;
	}		



	public long insertPlanoresp(
			long idPlanoresp 
			, long idPlano
			, long idUsr 

			) throws RegistroDesconhecidoException {

		UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
		OmUsr omusuario = usuarioRN.getOmUsr(idUsr) ;
		if (omusuario==null) {omusuario=null; usuarioRN=null; return 0;}
		if (omusuario.getId()==null) { omusuario=null; usuarioRN=null; return 0;}

		
		SpPlanoDAO dao = new SpPlanoDAO(getDaoSession(),formatoData,  formatoDataHora);

		
		//tratamento para inserir também omusrInternoA3.
		if(idPlanoresp==0L){//só para planosresps novos...
			//tratamento para inserir também omusrInternoA3.
			OmUsr omusrInternoA3 = null;
			long idUsrInternoA3=0L;
			long idinternoplanresp = 0L;
			SpPlanoresp spplanorespcomUsrInternoA3 = null;
			omusrInternoA3 = dao.getOmUsrInternoA3();
			if(omusrInternoA3!=null && omusrInternoA3.getIdUsr()>0L){
				idUsrInternoA3 = omusrInternoA3.getIdUsr();
			} else {
				idUsrInternoA3 = 0L;
			}
			if(idUsrInternoA3>0L){
				idinternoplanresp = 0L;
				try{
					spplanorespcomUsrInternoA3 = dao.getSpPlanorespExisteComPlanoUsrInternoA3(idPlano,  idUsrInternoA3 );
					if (spplanorespcomUsrInternoA3==null){
						
						//se não existe, insere o interno junto
						idinternoplanresp = dao.insertPlanoresp(
								0L 
								,  idPlano
								, omusrInternoA3
								);
						
					}
				} catch (Exception e){
					
				} finally {
					spplanorespcomUsrInternoA3 = null;
					omusrInternoA3 = null;
					idinternoplanresp = 0L;
				}			
			}			
		}//...tratamento para inserir também omusrInternoA3.
		
		
		long id = dao.insertPlanoresp(
				idPlanoresp 
				,  idPlano
				, omusuario
				);
		if (id == 0L) {
			throw new RegistroDesconhecidoException();
		}
		
		
		
		
		return id;
	}

}
