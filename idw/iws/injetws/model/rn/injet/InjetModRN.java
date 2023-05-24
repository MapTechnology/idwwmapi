package injetws.model.rn.injet;

import ms.model.dao.AbstractPdbaInjetDAO;
import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.util.IdwLogger;
import injetws.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.injet.Ijlogope;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.pojos.injet.Ijtbusureqtec;
import idw.model.pojos.injet.Ijusudirespec;
import injetws.model.rn.InfoRN;
import injetws.model.rn.SenhaRN;
import injetws.webservices.dto.IwsAutenticacaoDTO;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;

@SuppressWarnings("unchecked")
public class InjetModRN extends AbstractPdbaInjetDAO{
	
	public InjetModRN(DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
	private boolean validaTipoUsuario(Ijtbusu ijtbusu,int tpusu){
		boolean isOperadorValido=false; 
		switch(tpusu){
			case IwsAutenticacaoDTO.AVALIAR_OPERADOR:
				isOperadorValido=((ijtbusu.getTpusuario().intValue()==(1) || 
						ijtbusu.getTpusuario().intValue()==(3) || 
						ijtbusu.getTpusuario().intValue()==(11) ||
						ijtbusu.getTpusuario().intValue()==(13)) ? true : false); 
				break;
			case IwsAutenticacaoDTO.AVALIAR_TECNICO:
				isOperadorValido=((ijtbusu.getTpusuario().intValue()==(2) || 
						ijtbusu.getTpusuario().intValue()==(3) || 
						ijtbusu.getTpusuario().intValue()==(12) || 
						ijtbusu.getTpusuario().intValue()==(13)) ? true : false);
				break;
			case IwsAutenticacaoDTO.AVALIAR_TECQUALIDADE:
				isOperadorValido=isTecnicoQualidade(ijtbusu);
				break;
			case IwsAutenticacaoDTO.AVALIAR_TEC_1:
				for(Ijtbusureqtec otbl :ijtbusu.getIjtbusureqtecs()){
					if(otbl.getPedetec1().intValue()==1)
						isOperadorValido=true;
				}				
				break;
			case IwsAutenticacaoDTO.AVALIAR_TEC_2:
				for(Ijtbusureqtec otbl :ijtbusu.getIjtbusureqtecs()){
					if(otbl.getPedetec2().intValue()==1)
						isOperadorValido=true;
				}	
				break;
			case IwsAutenticacaoDTO.AVALIAR_TEC_RESP:
				for(Ijtbusureqtec otbl :ijtbusu.getIjtbusureqtecs()){
					if(otbl.getPedetecresp().intValue()==1)
						isOperadorValido=true;
				}
				break;
			case IwsAutenticacaoDTO.AVALIAR_TEC_CIP:
				isOperadorValido=isTecnicoCIP(ijtbusu);	
				break;
		}
		return isOperadorValido;
	}
	
	public boolean getTr_ValidaLoginSenha(String login, String senha, int avaliar ){
		boolean retorno = false;
		try{
			Ijtbusu ijtbusu = null;
			ijtbusu = getIjtbusu(login);
			
			if((ijtbusu!=null) && validaTipoUsuario(ijtbusu,avaliar) && SenhaRN.criptografarSenha(senha).equalsIgnoreCase(ijtbusu.getSenha()) ){
				// se senha igual, autorizar
				retorno = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return retorno;
	}

	public IwsAutenticacaoDTO getTr_Autorizacao(IdwLogger log, int idLog, String Idup,String login, String password, int avaliar, Date DataHrAtual,Boolean validaPorDsUsuario) {

		Ijtbusu ijtbusu = null;
		if(validaPorDsUsuario)
			ijtbusu = getIjtbusuByMatricula(login);
		else			
			ijtbusu = getIjtbusu(login);

		// inicializando DTO de retorno
		IwsAutenticacaoDTO retorno = new IwsAutenticacaoDTO();
		retorno.setIsAutorizado(false);
		retorno.setResultadoAutenticacao(IwsAutenticacaoDTO.NaoAutorizado);
		retorno.setDtHrLogin(DataHrAtual);
		retorno.setNomeOperador("");
		retorno.setIdOperador("");
		retorno.setCdUsuario("");
		if(ijtbusu!=null){	
			// Se usuário ativo e for operador ou técnico
			if ( validaTipoUsuario(ijtbusu,avaliar) &&
					SenhaRN.criptografarSenha(password).equalsIgnoreCase(ijtbusu.getSenha())) {
					// se senha igual, autorizar
					retorno.setIsAutorizado(true);
					retorno.setNomeOperador(ijtbusu.getMatricula());
					retorno.setIdOperador(ijtbusu.getCdusuario());
					retorno.setCdUsuario(ijtbusu.getCdusuario());
					retorno.setResultadoAutenticacao(IwsAutenticacaoDTO.Autorizado);
				
			}
		}else if(avaliar == IwsAutenticacaoDTO.AVALIAR_OPERADOR){
			// verifica se operadorestá logado			
			InfoRN iRN = new InfoRN(getDaoInjet(), getDaoPdba());
			retorno=iRN.verificaSeOperadorLogado(log, idLog, Idup, login);			
			// Se estiver, responde como autorizado para que seja possível efetuar o logout
		}

		return retorno;
	}
		
	public boolean isTecnicoQualidade(Ijtbusu ijtbusu){
		boolean retorno = false;
		if (ijtbusu.getIjusudirespecs() != null && ijtbusu.getIjusudirespecs().size() > 0){
			for (Ijusudirespec t : ijtbusu.getIjusudirespecs()){
				if (t.getId().getCdfuncao().equals("000026")){
					retorno = true;
					break;
				}
			}
		}
		return retorno;
	}
	
	public boolean isTecnicoCIP(Ijtbusu ijtbusu){
		boolean retorno = false;
		if (ijtbusu.getIjusudirespecs() != null && ijtbusu.getIjusudirespecs().size() > 0){
			for (Ijusudirespec t : ijtbusu.getIjusudirespecs()){
				if (t.getId().getCdfuncao().equals("000032")){
					retorno = true;
					break;
				}
			}
		}
		return retorno;
	}

	/**
	 * Recuperar usuario de ijtbusu
	 * 
	 * @param cdUsuario
	 *            Código do usuário
	 * @return Usuário
	 * @throws RegistroDesconhecidoException
	 */
	public Ijtbusu getIjtbusu(String cdUsuario) {
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());
		q.append("from Ijtbusu ijtb ");
		q.append("left join fetch ijtb.ijtbusutecespecs ijtbusutecespec ");
		q.append("left join fetch ijtb.ijusudirespecs ijusuDirespecs ");
		q.append("left join fetch ijtb.ijtbusureqtecs ijtbusureqtecs ");
		q.append("where ijtb.cdusuario = :cd and ijtb.cdusuario <> '999999' and ijtb.stusuario = 0 ");
		q.defineParametro("cd", cdUsuario);
		
		Ijtbusu ijtbusu = (Ijtbusu) q.uniqueResult();
		
		return ijtbusu;		

	}
	
	/**
	 * Recuperar usuario de ijtbusu
	 * 
	 * @param dsUsuario
	 *            Descrição do usuário,matricula
	 * @return Usuário
	 * @throws RegistroDesconhecidoException
	 */
	public Ijtbusu getIjtbusuByMatricula(String matricula) {
		MapQuery q = new MapQuery(this.getDaoInjet().getSession());
		q.append("from Ijtbusu ijtb ");
		q.append("left join fetch ijtb.ijtbusutecespecs ijtbusutecespec ");
		q.append("left join fetch ijtb.ijusudirespecs ijusuDirespecs ");
		q.append("left join fetch ijtb.ijtbusureqtecs ijtbusureqtecs ");
		q.append("where ijtb.matricula = :matricula and ijtb.stusuario = 0 ");
		q.defineParametro("matricula", matricula);
		
		Ijtbusu ijtbusu = (Ijtbusu) q.uniqueResult();
		
		return ijtbusu;		

	}
	
	

	/**
	 * Recupera os logins abertos na máquina
	 * 
	 * @param cdInjetora
	 * @return lista de login que ocorreram na máquina
	 * @throws RegistroDesconhecidoException
	 */
	public List<Ijlogope> getIjlogope(String cdInjetora)
			throws RegistroDesconhecidoException {
		return getIjlogope(cdInjetora, null, null);
	}

	/**
	 * Recupera logins da máquina
	 * 
	 * @param dthrLogin
	 *            Data/hora de login. Quando null indica que tem que pega todos
	 *            os login abertos para a máquina
	 * @param cdInjetora
	 *            Código da máquina
	 * @param cdUsuario
	 *            Código do Operador. Quando null só irá considerar os filtros
	 *            dos parametros <code>cdInjetora</code> e
	 *            <code>dtHrLogin</code>
	 * @return Lista dos usuários que já logaram na máquina, de acordo com o
	 *         filtro dos parametros
	 * @throws RegistroDesconhecidoException
	 *  
	 */
	
	public String tentaObterUmOperadorLogado(String cdInjetora){
		return "999999";
	}

	public List<Ijlogope> getIjlogope(String cdInjetora, Date dthrLogin,
			String cdUsuario) throws RegistroDesconhecidoException {
		StringBuilder hql = new StringBuilder();

		hql.append(" SELECT ijlogope FROM Ijlogope");

		// dtHrAlerta não preenchido adquirer todas os logins abertos
		if (dthrLogin == null) {
			hql.append(" WHERE ijlogope.id.cdinjetora = :cdInjetora");
			hql.append(" AND ijlogope.dthrlogout IS NULL");
		} else {
			hql.append(" WHERE ijlogope.id.dthrlogin = :dtHrLogin");
			hql.append(" AND ijlogope.id.cdinjetora = :cdInjetora");
			if (cdUsuario != null) {
				hql.append(" AND ijlogope.id.cdusuario = :cdUsuario");
			}
		}

		Query q = this.getDaoInjet().getSession().createQuery(hql.toString());

		// seta os parametros
		q.setParameter("cdInjetora", cdInjetora);
		if (dthrLogin != null) {
			q.setTimestamp("dtHrLogin", dthrLogin);
			if (cdUsuario != null) {
				q.setParameter("cdUsuario", cdUsuario);
			}
		}
		
		List<Ijlogope> listaIjlogope = null;

		listaIjlogope = q.list();

		return listaIjlogope;

	}
}
