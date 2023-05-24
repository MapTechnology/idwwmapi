package ms.model.rn.importacao.mws;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.mws.DAOGenericoMws;
import idw.model.dao.tdba.DAOGenericoTdba;
import idw.model.pojos.tdba.SbOpsMp;
import idw.util.IdwLogger;
import injetws.webservices.dto.IwsErroDTO;
import injetws.webservices.dto.IwsListaMatPrimaDTO;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;

import org.apache.commons.lang3.Validate;

import ms.model.dao.AbstractMwsTdbaInjetDAO;

public class InfoRnMWS extends AbstractMwsTdbaInjetDAO {

	IdwLogger log;
	public InfoRnMWS(IdwLogger log, DAOGenericoMws daoMws, DAOGenericoTdba daoTdba, DAOGenericoInjet daoInjet){
		Validate.notNull(daoMws);
		Validate.notNull(daoInjet);
		Validate.notNull(daoTdba);
		Validate.notNull(log);
		this.log = log;
		this.setDaoInjet(daoInjet) ;
		this.setDaoMws(daoMws);
		this.setDaoTdba(daoTdba);	
	}
	
	public IwsListaMatPrimaDTO getTr_integracaoMws(String nrOp){
		IwsListaMatPrimaDTO retorno = new IwsListaMatPrimaDTO();
		int idLog = log.getIdAleatorio();
		try{
			MapQuery q = new MapQuery(this.getDaoTdba().getSession());

			q.append("select sb from SbOpsMp sb where sb.idRegistro in ");
			q.append(" ( select max(sbOpsMp.idRegistro) from SbOpsMp sbOpsMp ");
			q.append(" where sbOpsMp.tipoOperacao <> 3 ");
			//q.append(" and sbOpsMp.codBarras is not null ");
			q.append(" and sbOpsMp.nrOp = :nrOp ");
			q.append(" group by cod_mp) ");
			q.append(" order by sb.idRegistro ");
			q.defineParametro("nrOp", nrOp);
			List<SbOpsMp> lstSbOpsMp = q.list();
			ArrayList<IwsProdMateriaPrimaDTO> lstMateria = new ArrayList<IwsProdMateriaPrimaDTO>();

			for(SbOpsMp ops: lstSbOpsMp){
				IwsProdMateriaPrimaDTO matPrima = new IwsProdMateriaPrimaDTO();
				matPrima.setCdMateriaPrima(ops.getCodMp());
				matPrima.setIdRegistro(ops.getIdRegistro());
				lstMateria.add(matPrima);
			}
			retorno.copyListMatPrima(lstMateria);
		}catch(Exception e){
			log.error(idLog, 0, "InfoRN.getTr_integracaoMws: " + e.getMessage() + "\r\n" + e.getStackTrace());
		}
		return retorno;
	}
	public  IwsErroDTO setTr_integracaoMws(BigDecimal idRegistro, String codBarraLido){
		injetws.webservices.dto.IwsErroDTO erro = new injetws.webservices.dto.IwsErroDTO();
		int idLog = log.getIdAleatorio();
		try{
			MapQuery q = new MapQuery(this.getDaoTdba().getSession());
			q.append("select sb from SbOpsMp sb where sb.idRegistro = :idRegistro");
			q.defineParametro("idRegistro", idRegistro);
			q.setMaxResults(1);
			SbOpsMp sb = (SbOpsMp) q.uniqueResult();
			sb.setCodBarras(codBarraLido);
			this.getDaoTdba().makePersistent(sb);
			erro.setSucesso(true);
		}catch(Exception e){
			erro.setSucesso(false);
			erro.setMensagem(e.getMessage());
			log.error(idLog, 0, "InfoRN.setTr_integracaoMws: " + e.getMessage() + "\r\n" + e.getStackTrace());
		}
		return erro;
	}	
	
}
