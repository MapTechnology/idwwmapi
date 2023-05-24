package injetws.model.rn.coletadiscreta;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.model.IwsFacadeColetaDiscreta;
import injetws.model.excessoes.MestreOfflineException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrColetorEventos;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpParadasEmAberto;
import injetws.model.rn.InfoRN;
import injetws.webservices.dto.IwsColetaDiscretaListaOPsDTO;
import injetws.webservices.dto.IwsColetaDiscretaListaParadaEmAbertoDTO;
import injetws.webservices.dto.IwsColetaDiscretaOPEmAbertoDTO;
import injetws.webservices.dto.IwsColetaDiscretaParadaEmAbertoDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.model.dao.AbstractPdbaInjetDAO;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;

@SuppressWarnings("unchecked")
public class ColetaDiscretaParadasRN extends AbstractPdbaInjetDAO {

	IdwLogger log;
	
	public ColetaDiscretaParadasRN(IdwLogger log,DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(log);
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.log = log;
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
	public boolean getTr_ExisteParadaEmAbertoMaquina (String idUP) throws SemSGBDException {
		boolean retorno = false;
		
		String hql="";
		hql += "select a ";
		hql += "from PrUpParadasEmAberto a, PrUpOpsEmAberto b ";		
		hql += "where a.id.idup = '::idUP'";
		hql += "  and a.id.idup = b.prUp.idup ";
		
		hql = hql.replaceAll("::idUP", idUP);
		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUpParadasEmAberto> listaRegistros = null;
		try {
			listaRegistros = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Existe parada em aberto
		if (listaRegistros.size() > 0) {
			retorno = true;
		} else {
			retorno = false;
		}
				
		return retorno;
	}
	
	public boolean getTr_ParadaJaAbertaMaquina (String idUP, String cdOperacao)  throws SemSGBDException {
		boolean retorno = false;
		
		String hql="";
		hql += "select a ";
		hql += "from PrUpParadasEmAberto a, PrUpOpsEmAberto b ";		
		hql += "where a.id.idup  = '::idUP'";
		hql += "  and a.cdparada = '::cdOperacao'";
		hql += "  and a.id.idup  = b.prUp.idup ";
		
		hql = hql.replaceAll("::idUP", idUP);
		hql = hql.replaceAll("::cdOperacao", cdOperacao);
		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUpParadasEmAberto> listaRegistros = null;
		try {
			listaRegistros = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Existe parada em aberto
		if (listaRegistros.size() > 0) {
			retorno = true;
		} else {
			retorno = false;
		}
				
		return retorno;
	}

	
	public IwsColetaDiscretaListaParadaEmAbertoDTO getTr_UPsComParadaEmAbertoOperacaoInformada(String mac, String cdOperacao) throws SemSGBDException  {
		String hql="";
		
				
		hql += "select par";
		hql += "  from PrUpParadasEmAberto par ";
		hql += "  join fetch par.prUpOpsEmAberto op "; 
		hql += "  join fetch op.prUp prup ";		
		hql += "  join fetch prup.prSubColetor prsubcoletor ";
		hql += "  join fetch prsubcoletor.prColetor prcoletor ";		
		hql += " where prcoletor.idcoletor = '::idcoletor'";
		hql += "   and par.cdparada = '::cdoperacao' ";

		hql = hql.replaceAll("::idcoletor", mac);
		hql = hql.replaceAll("::cdoperacao", cdOperacao);
		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUpParadasEmAberto> lista = null;
		List<IwsColetaDiscretaParadaEmAbertoDTO> listaRetorno = new ArrayList<IwsColetaDiscretaParadaEmAbertoDTO>();
		IwsColetaDiscretaParadaEmAbertoDTO itemLista = null;
		IwsColetaDiscretaListaParadaEmAbertoDTO retorno = new IwsColetaDiscretaListaParadaEmAbertoDTO() ;
		
		try {
			lista = q.list();
			if(lista.size() > 0 ){
				
				for (PrUpParadasEmAberto registro : lista ){
					itemLista = new IwsColetaDiscretaParadaEmAbertoDTO();
					
					itemLista.setIdUP(registro.getId().getIdup());
					itemLista.setIdOPEmAberto(registro.getId().getIdopemaberto() );
					itemLista.setDtHrIParada(registro.getDthriparada());
					itemLista.setMsDtHrIParada(registro.getMsdthriparada());
					itemLista.setCdParada(registro.getCdparada());
					itemLista.setNrOP(registro.getPrUpOpsEmAberto().getNrop());
					
					listaRetorno.add(itemLista);
				}		

				retorno = new IwsColetaDiscretaListaParadaEmAbertoDTO();
				retorno.setLista(listaRetorno);
								
			}
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
				
		
		return retorno;
	}
	
	public IwsColetaDiscretaListaOPsDTO getTr_UPsSemParadaEmAberto(String mac) throws SemSGBDException {
		
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

		List<IwsColetaDiscretaOPEmAbertoDTO> listaUPs = new ArrayList<IwsColetaDiscretaOPEmAbertoDTO>();	
		IwsColetaDiscretaListaOPsDTO retorno = new IwsColetaDiscretaListaOPsDTO();
		
		
		try {
			lista = q.list();
			if(lista.size() > 0 ){
				// Verifica se a UP tem parada aberta...

				IwsColetaDiscretaListaOPsDTO opsAbertas = new IwsColetaDiscretaListaOPsDTO();

				for (PrUp registroUP : lista ){
					if (getTr_ExisteParadaEmAbertoMaquina(registroUP.getIdup().toString()) == false) { 

						/*
						 * Quando se tratar de coleta discreta de produção, apenas uma linha será retornada.
						 * Coleta discreta de acabamento podem ter mais de uma OP carregada mas não realizam
						 *  operações de pareada.
						 */
						//TODO:  SENOJ Verificar o método abaixo
						opsAbertas = IwsFacadeColetaDiscreta.getInstancia().getTr_OPsEmAbertoMaquina(registroUP.getIdup().toString());
						
						if (opsAbertas.getTotalOPs() > 0){
							listaUPs.add(opsAbertas.getLista().get(0));
						}
					}
				}	
				
				retorno.setLista(listaUPs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return retorno;
		
	}

	public IwsColetaDiscretaParadaEmAbertoDTO getTr_ParadaEmAbertoMaquina (String idUP, String idOPemAberto) throws SemSGBDException  {
		IwsColetaDiscretaParadaEmAbertoDTO retorno = new IwsColetaDiscretaParadaEmAbertoDTO();
		
		String hql="";
		hql += "select a ";
		hql += "from PrUpParadasEmAberto a ";		
		hql += "where a.id.idup  = '::idUP'";
		hql += "  and a.id.idopemaberto = '::idopemaberto'";
		
		hql = hql.replaceAll("::idUP", idUP);
		hql = hql.replaceAll("::idopemaberto", idOPemAberto);
		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUpParadasEmAberto> listaRegistros = null;
		try {
			listaRegistros = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PrUpParadasEmAberto registro = new PrUpParadasEmAberto();
		
		if (listaRegistros.size() > 0) {
			registro = listaRegistros.get(0);
			retorno.setIdUP(registro.getId().getIdup());
			retorno.setNrOP(registro.getPrUpOpsEmAberto().getNrop());
			retorno.setIdOPEmAberto(registro.getPrUpOpsEmAberto().getIdopemaberto());
			retorno.setDtHrIParada(registro.getDthriparada());
			retorno.setMsDtHrIParada(retorno.getMsDtHrIParada());
			retorno.setCdParada(registro.getCdparada());
		} 	
		
		return retorno;
	}
	
	
	public void setTr_ApontaAberturaParadaColetaDiscretaTodasUPs(String mac, Date dthrEvento, String cdOperacao) throws MestreOfflineException, SemSGBDException {	
		IwsColetaDiscretaListaOPsDTO listaUPsSemParadaAberta = new IwsColetaDiscretaListaOPsDTO();
		listaUPsSemParadaAberta = getTr_UPsSemParadaEmAberto(mac);
		
		for (IwsColetaDiscretaOPEmAbertoDTO  registro : listaUPsSemParadaAberta.getLista())
		{
			setTr_ApontaAbertParadaColetaDiscreta(registro.getIdUP(), 
												  dthrEvento, 
												  registro.getNrOP(),
												  cdOperacao, 
												  registro.getIdOPEmAberto());
		}	
		
	}		
	
	public void setTr_ApontaFechamentoParadaColetaDiscretaTodasUPs(String mac, Date dthrEvento, String cdOperacao) throws MestreOfflineException, SemSGBDException {	
		IwsColetaDiscretaListaParadaEmAbertoDTO listaUPsComParadaAberta = new IwsColetaDiscretaListaParadaEmAbertoDTO();
		listaUPsComParadaAberta = getTr_UPsComParadaEmAbertoOperacaoInformada(mac, cdOperacao);
		
		for (IwsColetaDiscretaParadaEmAbertoDTO registro : listaUPsComParadaAberta.getLista() )
		{
			setTr_ApontaFechamParadaColetaDiscreta(registro.getIdUP(), 
												   dthrEvento, 
												   registro.getDtHrIParada(), 
												   registro.getNrOP(),
												   cdOperacao, 
												   registro.getIdOPEmAberto());
		}	
		
	}	
	
	
	public void setTr_ApontaAbertParadaColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao, String idOPEmAberto) throws MestreOfflineException, SemSGBDException {	
		
		Date dataHrAtual = dthrEvento;
		
		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = null;
		prup = infoRN.pesquisaPrup(log, 0, idUp);	
		
		long milisegundos = dataHrAtual.getTime()%1000;
		
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(35));

		prcoletoreventos.setDthr1evento(dataHrAtual);
		prcoletoreventos.setMsdthr1evento((double)milisegundos);		
		prcoletoreventos.setDthr2evento(dataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dataHrAtual));

		prcoletoreventos.setNrop(nrOP);
		prcoletoreventos.setInf01(cdOperacao);
		
		//PrEventosBridgeCollecDb eventoResposta = null;		
		infoRN.lancarEventoEsperaPrEventosBridgeCollecDb(log, 0, prcoletoreventos, false);
		
		//Inserir uma linha na tabela PR_UP_PARADAS_EM_ABERTO
		getDaoPdba().flushReiniciandoTransacao();
		

		String sql = "";
		sql += "insert into Pr_Up_Paradas_Em_Aberto (idup, idopemaberto, dthriparada, msdthriparada, cdparada)"; 
		sql += " values ( '::idup', '::idopemaberto', :dthriparada , ::msdthriparada, '::cdparada')";
		sql = sql.replaceAll("::idup",idUp );
		sql = sql.replaceAll("::idopemaberto", idOPEmAberto);
		sql = sql.replaceAll("::msdthriparada", (String.valueOf(milisegundos)));
		sql = sql.replaceAll("::cdparada", cdOperacao);
		
		Query q = getDaoPdba().getSession().createSQLQuery(sql);
		q.setTimestamp("dthriparada", dataHrAtual);
		q.executeUpdate();	
		getDaoPdba().flushReiniciandoTransacao();

		
	}		

	public void setTr_ApontaFechamParadaColetaDiscreta(String idUp, Date dthrEvento, Date dtHrIParada, String nrOP, String cdOperacao, String idOPEmAberto) throws MestreOfflineException, SemSGBDException {	
		
		Date dataHrAtual = dthrEvento;
		
		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = null;
		prup = infoRN.pesquisaPrup(log, 0, idUp);	
		
		long milisegundos = dataHrAtual.getTime()%1000;
		
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(36));

		prcoletoreventos.setDthr1evento(dataHrAtual);
		prcoletoreventos.setMsdthr1evento((double)milisegundos);		
		prcoletoreventos.setDthr2evento(dataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dataHrAtual));
		
		prcoletoreventos.setNrop(nrOP);
		prcoletoreventos.setInf01(cdOperacao);
		prcoletoreventos.setInf02(DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtHrIParada));
		
		//PrEventosBridgeCollecDb eventoResposta = null;		
		infoRN.lancarEventoEsperaPrEventosBridgeCollecDb(log, 0, prcoletoreventos, false);
		
		//Excluir uma linha da tabela PR_UP_PARADAS_EM_ABERTO
		getDaoPdba().flushReiniciandoTransacao();
		
		String sql = "";
		sql += "delete from Pr_Up_Paradas_Em_Aberto "; 
		sql += " where idup         = '::idup' ";
		sql += "   and idopemaberto = '::idopemaberto'";
		sql = sql.replaceAll("::idup",idUp );
		sql = sql.replaceAll("::idopemaberto", idOPEmAberto);
		
		Query q = getDaoPdba().getSession().createSQLQuery(sql);
		q.executeUpdate();	
		getDaoPdba().flushReiniciandoTransacao();
		
	}	
}
