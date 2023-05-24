package idw.model.rn.imp.injet;

import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijtbmestres;
import idw.util.IdwLogger;

public abstract class ImportacaoInjetRN {
	private final IdwLogger log;
	private final DAOGenerico dao;
	private final DAOGenericoInjet daoInjet;

	private final int idLog;
	private final int identacao;

	public abstract boolean isPrecisaImportar(Ijtbmestres ijtbMestres);
	public abstract void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt);

	public ImportacaoInjetRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){

		Validate.notNull(log, "IdwLogger");
		Validate.notNull(dao, "dao");
		Validate.notNull(daoInjet, "daoInjet");

		this.log = log;
		this.dao = dao;
		this.daoInjet = daoInjet;
		this.idLog = idLog;
		this.identacao = identacao;

	}

	protected int getIdLog() {
		return this.idLog;
	}

//	protected void setIdLog(int idLog) {
//		this.idLog = idLog;
//	}

	protected int getIdentacao() {
		return this.identacao;
	}

//	protected void setIdentacao(int identacao) {
//		this.identacao = identacao;
//	}


	/**
	 * Flag para importa��o de dados est� ativada?
	 * @param listaMestres
	 * @return
	 */
	public boolean isPrecisaImportar(List<Ijtbmestres> listaMestres){

		for(Ijtbmestres ijtbmestres : listaMestres){
			if(this.isPrecisaImportar(ijtbmestres)){
				return true;
			}
		}

		return false;
	}

	public IdwLogger getLog() {
		return this.log;
	}

	public DAOGenerico getDao() {
		return this.dao;
	}

	public DAOGenericoInjet getDaoInjet() {
		return this.daoInjet;
	}

}
