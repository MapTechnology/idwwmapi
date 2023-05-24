package injetws.model.rn.coletadiscreta;


import ms.model.dao.AbstractPdbaInjetDAO;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;


import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.util.IdwLogger;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrOperacaoColetaDiscreta;
import injetws.model.pojos.PrUp;
import injetws.model.rn.InfoRN;
import injetws.webservices.dto.IwsColetaDiscretaOperacaoDTO;

import java.util.List;

@SuppressWarnings("unchecked")
public class ColetaDiscretaOperacaoRN extends AbstractPdbaInjetDAO {

	IdwLogger log;
	
	public ColetaDiscretaOperacaoRN(IdwLogger log,DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(log);
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.log = log;
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
    public static String OPERACAO_PRODUCAO_CARGA_OP = "1001";
    public static String OPERACAO_PRODUCAO_APONTAMENTO_PRODUCAO = "1002";
    public static String OPERACAO_PRODUCAO_APONTAMENTO_REFUGO = "1003	";
    public static String OPERACAO_PRODUCAO_APONTAMENTO_PARADA_COM_PESO = "1010";
    public static String OPERACAO_PRODUCAO_APONTAMENTO_PARADA_SEM_PESO = "1011";
    public static String OPERACAO_PRODUCAO_APONTAMENTO_PARADA = "1010, 1011";
    public static String OPERACAO_PRODUCAO_APONTAMENTO_LOGIN_LOGOUT = "1020";
    public static String OPERACAO_ACABAMENTO_CARGA_OP = "2001";
    
	public boolean getTr_ExisteOperacao (String idUP, String cdOperacao, String tpFuncOperacao) throws SemSGBDException {
		boolean retorno = false;
		
		InfoRN rn = new InfoRN(getDaoInjet(),getDaoPdba());
		PrUp prup = rn.pesquisaPrup(log, 0, idUP);
		
		String hql="";
		hql += "select a ";
		hql += "from PrOperacaoColetaDiscreta a ";		
		hql += "where a.prConexoesInjet.idregconexaoinjet = '::idregconexaoinjet'";
		hql += "  and a.cdoperacao     = '::cdoperacao' ";
		hql += "  and a.tpfuncoperacao in (::tpFuncOperacao) ";
		
		hql = hql.replaceAll("::idregconexaoinjet", prup.getPrConexoesInjet().getIdregconexaoinjet().toString());
		hql = hql.replaceAll("::cdoperacao", cdOperacao);
		hql = hql.replaceAll("::tpFuncOperacao", tpFuncOperacao);
		
		
		try {
			Query q = getDaoPdba().getSession().createQuery(hql);			

			List<PrOperacaoColetaDiscreta> listaRegistros = null;
			listaRegistros = q.list();
			
			if (listaRegistros.size() > 0) {
				retorno = true;
			} 	
			else
			{
				retorno = false; 
			}
			
		} catch (Exception e) {
			throw new SemSGBDException();
		}

		return retorno;
	}

	public IwsColetaDiscretaOperacaoDTO getTr_RecuperaOperacao (String idUP, String cdOperacao, String tpFuncOperacao) throws RegistroDesconhecidoException {
		IwsColetaDiscretaOperacaoDTO retorno = new IwsColetaDiscretaOperacaoDTO();
		
		InfoRN rn = new InfoRN(getDaoInjet(),getDaoPdba());
		PrUp prup = rn.pesquisaPrup(log, 0, idUP);
		
		String hql="";
		hql += "select a ";
		hql += "from PrOperacaoColetaDiscreta a ";		
		hql += "where a.prConexoesInjet.idregconexaoinjet = '::idregconexaoinjet'";
		hql += "  and a.cdoperacao     = '::cdoperacao' ";
		hql += "  and a.tpfuncoperacao in (::tpFuncOperacao) ";
		
		hql = hql.replaceAll("::idregconexaoinjet", prup.getPrConexoesInjet().getIdregconexaoinjet().toString());
		hql = hql.replaceAll("::cdoperacao", cdOperacao);
		hql = hql.replaceAll("::tpFuncOperacao", tpFuncOperacao);
		
		Query q = getDaoPdba().getSession().createQuery(hql);

		
		List<PrOperacaoColetaDiscreta> listaRegistros = null;
		try {
			listaRegistros = q.list();

			
			if (listaRegistros.size() > 0) {
				PrOperacaoColetaDiscreta registro = listaRegistros.get(0);
				
				retorno.setIdRegOperacao(registro.getIdregoperacao());
				retorno.setIdRegConexaoInjet(registro.getPrConexoesInjet().getIdregconexaoinjet().toString());
				retorno.setCdOperacao(registro.getCdoperacao());
				retorno.setDsOperacao(registro.getDsoperacao());
				retorno.setTpOperacao(registro.getTpoperacao());
				retorno.setTpFuncOperacao(registro.getTpfuncoperacao());
				retorno.setSiglaUM(registro.getSiglaum());
			} 	
			else
			{
				throw new RegistroDesconhecidoException();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}
		
}
