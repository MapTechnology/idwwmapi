package injetws.model.rn.coletadiscreta;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.util.UtilsString;
import injetws.model.excessoes.MestreOfflineException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrColetorEventos;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpLoginsEmAberto;
import injetws.model.rn.InfoRN;
import injetws.webservices.dto.IwsColetaDiscretaListaLoginsDTO;
import injetws.webservices.dto.IwsColetaDiscretaListaUPsDTO;
import injetws.webservices.dto.IwsColetaDiscretaLoginDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.model.dao.AbstractPdbaInjetDAO;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;


@SuppressWarnings("unchecked")
public class ColetaDiscretaLoginRN extends AbstractPdbaInjetDAO {

	IdwLogger log;
	
	public ColetaDiscretaLoginRN(IdwLogger log,DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(log);
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.log = log;
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
	public void setTr_ApontaAberturaLoginColetaDiscretaTodasUPs(String mac, Date dthrEvento, String cdOperacao, String cdOperador) throws MestreOfflineException, SemSGBDException {	

		cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

		IwsColetaDiscretaListaUPsDTO listaUPsSemLogin = new IwsColetaDiscretaListaUPsDTO();
		listaUPsSemLogin = getTr_UPsSemLoginOperadorInformado(mac, cdOperador);
		
		for (PrUp registro : listaUPsSemLogin.getLista())
		{
			setTr_ApontaAbertLoginColetaDiscreta(registro.getIdup().toString(), 
					                             dthrEvento, 
					                             cdOperacao, 
					                             cdOperador);
		}	
		
	}		
	
	public void setTr_ApontaFechamentoLoginColetaDiscretaTodasUPs(String mac, Date dthrEvento, String cdOperacao, String cdOperador) throws MestreOfflineException, SemSGBDException {
		
		cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

		IwsColetaDiscretaListaLoginsDTO listaUPsComLogin = new IwsColetaDiscretaListaLoginsDTO();
		listaUPsComLogin = getTr_UPsComLoginAbertoOperadorInformado(mac, cdOperacao, cdOperador);
		
		for (IwsColetaDiscretaLoginDTO registro : listaUPsComLogin.getLista() )
		{
			setTr_FechaLoginColetaDiscreta(registro.getIdUP(), 
					                       dthrEvento, 
					                       registro.getDtHrLogin(), 
					                       cdOperacao, 
					                       cdOperador, 
										   registro.getIdLoginAberto());
		}	
		
	}	
	
	public boolean setTr_ExisteLoginAbertoMaquina(String idUP, String cdOperador)throws SemSGBDException {
		boolean retorno = false;
		
		String hql="";
		hql += "select a ";
		hql += "from PrUpLoginsEmAberto a, PrUpOpsEmAberto b ";		
		hql += "where a.id.idup = '::idUP'";
		hql += "  and a.id.idup = b.prUp.idup ";
		hql += "  and a.cdusuario  = '::cdoperador' ";
		
		hql = hql.replaceAll("::idUP", idUP);
		hql = hql.replaceAll("::cdoperador", cdOperador);
		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUpLoginsEmAberto> listaRegistros = null;
		try {
			listaRegistros = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Existe login em aberto
		if (listaRegistros.size() > 0) {
			retorno = true;
		} else {
			retorno = false;
		}
		
		return retorno;
	}
	

	public IwsColetaDiscretaLoginDTO getTr_LoginAbertoMaquina(String idUP, String cdOperador) throws SemSGBDException {
		IwsColetaDiscretaLoginDTO retorno = new IwsColetaDiscretaLoginDTO();
		
		String hql="";
	
		hql += "select * ";
		hql += " from PR_UP_LOGINS_EM_ABERTO ";		
		hql += "where idup      = '::idUP'";
		hql += "  and cdUsuario = '::cdoperador' ";

		hql = hql.replaceAll("::idUP", idUP);
		hql = hql.replaceAll("::cdoperador", cdOperador);

		Query q = getDaoPdba().getSession().createSQLQuery(hql)
			.addScalar("idloginaberto", StringType.INSTANCE)
			.addScalar("idup", StringType.INSTANCE)
			.addScalar("cdusuario", StringType.INSTANCE)
			.addScalar("dthrlogin", TimestampType.INSTANCE)
			.addScalar("msdthrlogin", DoubleType.INSTANCE)
			.addScalar("cdoperacao", StringType.INSTANCE)
			.setResultTransformer(Transformers.aliasToBean(IwsColetaDiscretaLoginDTO.class));
		
		try {
			List<IwsColetaDiscretaLoginDTO> listaRegistros = q.list();
			if (listaRegistros.size() > 0){
				retorno = listaRegistros.get(0);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retorno;
	}

	public IwsColetaDiscretaListaLoginsDTO getTr_UPsComLoginAbertoOperadorInformado(String mac, String cdOperacao, String cdOperador) throws SemSGBDException {

		cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

		MapQuery q = new MapQuery(getDaoPdba().getSession());
		
		q.append("select logUP");
		q.append("  from PrUpLoginsEmAberto logUP ");		
		q.append("  join fetch logUP.prUp prup ");
		q.append("  join fetch prup.prSubColetor prsubcoletor ");
		q.append("  join fetch prsubcoletor.prColetor prcoletor ");
		
		q.appendWhere(MapQuery._NULL, "prcoletor.idcoletor = :idcoletor", true);
		q.appendWhere(MapQuery._AND, "logUP.cdoperacao = :cdoperacao ", cdOperacao != null);
		q.appendWhere(MapQuery._AND, "logUP.cdusuario  = :cdoperador", true);
		
		q.defineParametro("idcoletor", mac);
		q.defineParametro("cdoperacao", cdOperacao);
		q.defineParametro("cdoperador", cdOperador);
		
		List<PrUpLoginsEmAberto> lista = null;
		List<IwsColetaDiscretaLoginDTO> listaRetorno = new ArrayList<IwsColetaDiscretaLoginDTO>();
		IwsColetaDiscretaLoginDTO itemLista = null;
		IwsColetaDiscretaListaLoginsDTO retorno = new IwsColetaDiscretaListaLoginsDTO();
		
		try {
			lista = q.list();
			if(lista.size() > 0 ){
				
				for (PrUpLoginsEmAberto registro : lista ){
					itemLista = new IwsColetaDiscretaLoginDTO();
					itemLista.setIdUP(registro.getPrUp().getIdup().toString());
					itemLista.setIdLoginAberto(registro.getIdloginaberto());
					itemLista.setDtHrLogin(registro.getDthrlogin());
					itemLista.setMsDtHrLogin(registro.getMsdthrlogin());
					itemLista.setCdOperacao(registro.getCdoperacao());
					itemLista.setCdUsuario(registro.getCdusuario());
					
					listaRetorno.add(itemLista);
				}		

				retorno = new IwsColetaDiscretaListaLoginsDTO();
				retorno.setLista(listaRetorno);
								
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
				
		
		return retorno;
	}
	

	public IwsColetaDiscretaListaLoginsDTO getTr_LoginsAbertosUP(String idUP) throws SemSGBDException {
		String hql="";
				
		hql += "select logUP";
		hql += "  from PrUpLoginsEmAberto logUP ";		
		hql += " where logUP.prUp.idup = '::idUP'";
		
		hql = hql.replaceAll("::idUP", idUP);
		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUpLoginsEmAberto> lista = null;
		List<IwsColetaDiscretaLoginDTO> listaRetorno = new ArrayList<IwsColetaDiscretaLoginDTO>();
		IwsColetaDiscretaLoginDTO itemLista = null;
		IwsColetaDiscretaListaLoginsDTO retorno = new IwsColetaDiscretaListaLoginsDTO();
		
		try {
			lista = q.list();
			if(lista.size() > 0 ){
				
				for (PrUpLoginsEmAberto registro : lista ){
					itemLista = new IwsColetaDiscretaLoginDTO();
					itemLista.setIdUP(registro.getPrUp().getIdup().toString());
					itemLista.setIdLoginAberto(registro.getIdloginaberto());
					itemLista.setDtHrLogin(registro.getDthrlogin());
					itemLista.setMsDtHrLogin(registro.getMsdthrlogin());
					itemLista.setCdOperacao(registro.getCdoperacao());
					itemLista.setCdUsuario(registro.getCdusuario());
					
					listaRetorno.add(itemLista);
				}		

				retorno = new IwsColetaDiscretaListaLoginsDTO();
				retorno.setLista(listaRetorno);
								
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
				
		
		return retorno;
	}

	public IwsColetaDiscretaListaUPsDTO getTr_UPsSemLoginOperadorInformado(String mac, String cdOperador) throws SemSGBDException {
		
		String hql="";

		// recupera UPS
		hql += "select prup ";	
		hql += "  from PrUp prup ";		
		hql += "  join fetch prup.prSubColetor prsubcoletor ";
		hql += "  join fetch prsubcoletor.prColetor prcoletor ";		
		hql += " where prcoletor.idcoletor = '::idcoletor' ";
		
		hql = hql.replaceAll("::idcoletor", mac);
		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUp> lista = null;		
		List<PrUp> listaUPs = new ArrayList<PrUp>();		
		IwsColetaDiscretaListaUPsDTO retorno = new IwsColetaDiscretaListaUPsDTO();
		
		try {
			lista = q.list();
			if(lista.size() > 0 ){
				// Verifica as UPs e verifica se o operador está logado...

				IwsColetaDiscretaLoginDTO loginUP = new IwsColetaDiscretaLoginDTO();
				for (PrUp registro : lista ){
					loginUP = getTr_LoginAbertoMaquina(registro.getIdup().toString(), cdOperador);
					if (loginUP.getCdUsuario() == null){
						listaUPs.add(registro);
					}
				}	
				
				retorno.setLista(listaUPs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return retorno;
		
		
	}

	
	public void setTr_ApontaAbertLoginColetaDiscreta(String idUp, Date dthrEvento, String cdOperacao, String cdOperador) throws MestreOfflineException, SemSGBDException {	
		
		cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);
		
		Date dataHrAtual = dthrEvento;
		
		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = null;
		prup = infoRN.pesquisaPrup(log, 0, idUp);	
		
		long milisegundos = dataHrAtual.getTime()%1000;
		
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(37));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dataHrAtual);
		prcoletoreventos.setMsdthr1evento((double)milisegundos);		
		prcoletoreventos.setDthr2evento(dataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dataHrAtual));

		prcoletoreventos.setInf01(cdOperacao);
		prcoletoreventos.setInf02(cdOperador);
		
		//PrEventosBridgeCollecDb eventoResposta = null;		
		infoRN.lancarEventoEsperaPrEventosBridgeCollecDb(log, 0, prcoletoreventos, false);
		
		//Inserir uma linha da tabela PR_UP_LOGINS_EM_ABERTO
		getDaoPdba().flushReiniciandoTransacao();
		
		String sql = "";
		sql += "insert into Pr_Up_Logins_Em_Aberto (idup, cdusuario, dthrlogin, msdthrlogin, cdoperacao)"; 
		sql += " values ( '::idup', '::cdusuario', :dthrlogin , ::msdthrlogin, '::cdoperacao')";
		sql = sql.replaceAll("::idup",idUp );
		sql = sql.replaceAll("::cdusuario", cdOperador);
		sql = sql.replaceAll("::msdthrlogin", (String.valueOf(milisegundos)));
		sql = sql.replaceAll("::cdoperacao", cdOperacao);
		
		Query q = getDaoPdba().getSession().createSQLQuery(sql);
		q.setTimestamp("dthrlogin", dataHrAtual);
		q.executeUpdate();	
		getDaoPdba().flushReiniciandoTransacao();		
		
	}	

	public void setTr_FechaLoginColetaDiscreta(String idUp, Date dthrEvento, Date dtHrLogin, String cdOperacao, String cdOperador, String idLoginEmAberto) throws MestreOfflineException, SemSGBDException {	
		
		cdOperacao = UtilsString.getZerosAEsquerda(cdOperacao, 6);

		Date dataHrAtual = dthrEvento;
		
		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = null;
		prup = infoRN.pesquisaPrup(log, 0, idUp);	
		
		long milisegundos = dataHrAtual.getTime()%1000;
		
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(38));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setDthr1evento(dataHrAtual);
		prcoletoreventos.setMsdthr1evento((double)milisegundos);		
		prcoletoreventos.setDthr2evento(dataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dataHrAtual));

		prcoletoreventos.setInf01(DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrLogin));
		prcoletoreventos.setInf02(cdOperacao);
		prcoletoreventos.setInf03(cdOperador);
		
		//PrEventosBridgeCollecDb eventoResposta = null;		
		infoRN.lancarEventoEsperaPrEventosBridgeCollecDb(log, 0, prcoletoreventos, false);
		
		//Excluir uma linha da tabela PR_UP_LOGINS_EM_ABERTO
		getDaoPdba().flushReiniciandoTransacao();
		
		String sql = "";
		sql += "delete from Pr_Up_Logins_Em_Aberto "; 
		sql += " where idloginaberto = '::idloginaberto'";
		sql = sql.replaceAll("::idloginaberto",idLoginEmAberto );
		
		Query q = getDaoPdba().getSession().createSQLQuery(sql);
		q.executeUpdate();	
		getDaoPdba().flushReiniciandoTransacao();
		
	}	


}
