package injetws.model.rn;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.rn.DataHoraRN;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpCtrlEventosLoginout;
import injetws.model.pojos.PrUpLoginsEmAberto;
import injetws.model.pojos.PrUpLoginsEmAbertoBc;
import injetws.webservices.dto.IwsListModDTO;
import injetws.webservices.dto.IwsModDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.model.dao.AbstractPdbaInjetDAO;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;


@SuppressWarnings("unchecked")
public class ModRN extends AbstractPdbaInjetDAO{
	
	/*
	 * Para o caso de PrUpRn chamar o metodo de ModRn
	 */
	public ModRN(DAOGenerico daoPdba){  
		Validate.notNull(daoPdba);
		
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(null); 
	}
	
	public ModRN(DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(daoPdba);
		
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
	/**
	 * Recuperar Matricula de ijtbusu
	 * 
	 * @param CdUsuario
	 *           
	 * @return Matricula
	 * @throws RegistroDesconhecidoException
	 */
	public String getMatriculaByCdUsuario(String cdUsuario) {
		if(this.getDaoInjet()!=null){
			MapQuery q = new MapQuery(this.getDaoInjet().getSession());
			q.append("from Ijtbusu ijtb ");	
			q.append("where ijtb.cdusuario = :cd and ijtb.cdusuario <> '999999'");
			q.defineParametro("cd", cdUsuario);		
			Ijtbusu ijtbusu = (Ijtbusu) q.uniqueResult();	
			if (ijtbusu != null)
				return ijtbusu.getMatricula();	
		}
		return cdUsuario;
			
	}

	public IwsListModDTO getTr_operadoresLogados(String idUP) throws RegistroDesconhecidoException{
		if (idUP == null) {
			throw new RegistroDesconhecidoException();
		}
		String hql="";
		hql += "select pruploginsemaberto ";
		hql += "from PrUpLoginsEmAberto pruploginsemaberto ";		
		hql += "where pruploginsemaberto.prUp.idup = '::idup' ";
		
		hql = hql.replaceAll("::idup", idUP);
		
		Query q = getDaoPdba().getSession().createQuery(hql);

		List<PrUpLoginsEmAberto> listaPrUpLoginsEmAberto = null;
		try{
			listaPrUpLoginsEmAberto = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}			
		
		List<IwsModDTO> moddtos = new ArrayList<IwsModDTO>();
		
		for (PrUpLoginsEmAberto pruploginemaberto : listaPrUpLoginsEmAberto ){
			IwsModDTO moddto = new IwsModDTO();
			moddto.setIdUsuario(pruploginemaberto.getCdusuario());
			moddto.setLogin(pruploginemaberto.getCdusuario());
			moddto.setNome(getMatriculaByCdUsuario(pruploginemaberto.getCdusuario()));
			moddto.setDthrLogin(pruploginemaberto.getDthrlogin());	
			moddtos.add(moddto);			
		}		
		IwsListModDTO lstModDTO = new IwsListModDTO();
		lstModDTO.copyListModDTO(moddtos);
		return lstModDTO;
	}
	
	public List<IwsModDTO> getTr_balanceamentoLogin(PrUp prup, Date dtHrAtual,boolean isBcOnline ) {
		List<IwsModDTO> logins_app = null;		
		PrUpCtrlEventosLoginout eventosLoginout = null;
		boolean listaAlterada=false;
		
		String hql = "";
				
		hql += "select prupctrleventosloginout from PrUpCtrlEventosLoginout prupctrleventosloginout ";
		hql += "where prupctrleventosloginout.idup = '::idup' ";
		
		hql = hql.replaceAll("::idup", prup.getIdup().toString()); 
		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		try {
			eventosLoginout = (PrUpCtrlEventosLoginout) q.uniqueResult();
		} catch (Exception e1) {
			e1.printStackTrace();
			eventosLoginout = null;
		}
		
		hql="";
		
		hql += "select pruploginsemaberto ";
		hql += "from PrUpLoginsEmAberto pruploginsemaberto ";		
		hql += "where pruploginsemaberto.prUp.idup = '::idup' ";				
		
		hql = hql.replaceAll("::idup", prup.getIdup().toString());
		
		q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUpLoginsEmAberto> listaPrUpLoginsEmAberto = null;
		try {
			listaPrUpLoginsEmAberto = q.list();
		} catch (Exception e2) {
			e2.printStackTrace();
			listaPrUpLoginsEmAberto = null;
		}		
		
		int diffTmp=0;
		try{
			diffTmp=DataHoraRN.getQuantidadeMinutosNoPeriodo(eventosLoginout.getDthrbalanceamento(),dtHrAtual);
		}catch(Exception e){
			diffTmp=6;// valor maior que 5 para forçar o balanceamento em caso de erro em obter data e hora;
		}
		if(eventosLoginout != null && (eventosLoginout.getDthrbalanceamento() == null || diffTmp >= 5 || diffTmp <=5))
		{			
			if(isBcOnline && 
			   !eventosLoginout.getDthrbc().equals(eventosLoginout.getDthrcoletor()))
			{					
				hql = "";
				
				hql += "select pruploginsemabertobc from PrUpLoginsEmAbertoBc pruploginsemabertobc ";
				hql += "where pruploginsemabertobc.prUp.idup = '::idup' ";
				
				hql = hql.replaceAll("::idup", prup.getIdup().toString());
				
				q = getDaoPdba().getSession().createQuery(hql);
				
				List<PrUpLoginsEmAbertoBc> listaPrUpLoginsEmAbertoBc = null;
				try {
					listaPrUpLoginsEmAbertoBc = q.list();
				} catch (Exception e2) {
					e2.printStackTrace();
					listaPrUpLoginsEmAbertoBc = null;
				}						
				
				if(listaPrUpLoginsEmAbertoBc != null && listaPrUpLoginsEmAbertoBc.size() > 0)
				{
					//se a lista do bc estiver preenchida
					boolean isLoginOk = false;
					
					for(PrUpLoginsEmAbertoBc loginsBc : listaPrUpLoginsEmAbertoBc)
					{
						isLoginOk = false;
						for(PrUpLoginsEmAberto logins : listaPrUpLoginsEmAberto)
						{								
							if(loginsBc.getCdusuario().equals(logins.getCdusuario()))
							{
								isLoginOk = true;
								logins.setDthrlogin(loginsBc.getDthrlogin()); 
							}
						}
						//se o login da lista do bc n�o foi encontrador
						//deve ser adicionado à lista do concentrador
						if(!isLoginOk)
						{	
							// NOTA DE SENOJ:N�o se deve editar a lista que está servindo de referência para o FOR
							//listaPrUpLoginsEmAberto.add(copyLoginBcToApp(prup.getIdup(), loginsBc));
							
							String sql = "";
							sql += "insert into Pr_Up_Logins_Em_Aberto (idUp, cdusuario, DtHrLogin, msDtHrLogin)";
							sql += " values ( '::idup', '::cdusuario', :data , ::msDtHrLogin)";
							sql = sql.replaceAll("::idup", prup.getIdup().toString());
							sql = sql.replaceAll("::cdusuario", loginsBc.getCdusuario());
							sql = sql.replaceAll("::msDtHrLogin", (String.valueOf(loginsBc.getMsdthrlogin())));

							q = getDaoPdba().getSession().createSQLQuery(sql);
							q.setTimestamp("data", loginsBc.getDthrlogin());
							q.executeUpdate();
							getDaoPdba().flushReiniciandoTransacao();
							listaAlterada=true;							
						}							
					}
					
					for(PrUpLoginsEmAberto logins : listaPrUpLoginsEmAberto)
					{
						isLoginOk = false;
						for(PrUpLoginsEmAbertoBc loginsBc : listaPrUpLoginsEmAbertoBc)
						{							
							if(logins.getCdusuario().equals(loginsBc.getCdusuario()))
							{
								isLoginOk = true;								
							}
						}
						//se o login da lista do bc n�o foi encontrador
						//deve ser adicionado à lista do concentrador
						if(!isLoginOk)
						{		
							// NOTA DE SENOJ:N�o se deve editar a lista que está servindo de referência para o FOR
							//listaPrUpLoginsEmAberto.remove(logins);  
							String sql = "";
							sql += "delete from Pr_Up_Logins_Em_Aberto where idUp='::idup' and cdusuario='::cdusuario' ";
							sql = sql.replaceAll("::idup", prup.getIdup().toString());
							sql = sql.replaceAll("::cdusuario", logins.getCdusuario());

							q = getDaoPdba().getSession().createSQLQuery(sql);

							q.executeUpdate();
							getDaoPdba().flushReiniciandoTransacao();
							listaAlterada=true;
						}						
					}					
				}
				else
				{
					if(listaPrUpLoginsEmAberto!=null && listaPrUpLoginsEmAberto.size()>0){
						//se a lista do bc n�o possuir registros
						listaPrUpLoginsEmAberto = null;
						String sql = "";
						sql += "delete from Pr_Up_Logins_Em_Aberto where idUp='::idup' ";
						sql = sql.replaceAll("::idup", prup.getIdup().toString());					
	
						q = getDaoPdba().getSession().createSQLQuery(sql);
	
						q.executeUpdate();
						getDaoPdba().flushReiniciandoTransacao();	
						listaAlterada=true;
					}
				}
				//obtem novamente os logins em aberto caso tenha aletrado algo
				if(listaAlterada==true){
					hql="";
					
					hql += "select pruploginsemaberto ";
					hql += "from PrUpLoginsEmAberto pruploginsemaberto ";		
					hql += "where pruploginsemaberto.prUp.idup = '::idup' ";				
					
					hql = hql.replaceAll("::idup", prup.getIdup().toString());
					
					q = getDaoPdba().getSession().createQuery(hql);				
					
					try {
						listaPrUpLoginsEmAberto = q.list();
					} catch (Exception e2) {
						e2.printStackTrace();
						listaPrUpLoginsEmAberto = null;
					}
				}			
				eventosLoginout.setDthrcoletor(eventosLoginout.getDthrbc());											
			}
			eventosLoginout.setDthrbalanceamento(dtHrAtual);
			getDaoPdba().getSession().merge(eventosLoginout);
		}
		
		if(listaPrUpLoginsEmAberto != null)
		{
			logins_app = new ArrayList<IwsModDTO>();
			IwsModDTO loginDto;
			for(PrUpLoginsEmAberto logins : listaPrUpLoginsEmAberto) {
				loginDto = new IwsModDTO();
				loginDto.setIdUsuario(logins.getCdusuario());
				loginDto.setLogin(logins.getCdusuario());
				loginDto.setNome(getMatriculaByCdUsuario(logins.getCdusuario()));
				loginDto.setDthrLogin(logins.getDthrlogin());
				logins_app.add(loginDto);
			}
		}
		else
		{	
			prup.mudaDeveLiparUsuarios(true);
			logins_app = null;					
		}	
				
		return logins_app;
	}
	
}
