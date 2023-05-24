package injetws.model.rn.coletadiscreta;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.model.dao.AbstractPdbaInjetDAO;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.util.IdwLogger;
import injetws.model.excessoes.MestreOfflineException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrColetorEventos;
import injetws.model.pojos.PrEventosBridgeCollecDb;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpOpsEmAberto;
import idw.model.rn.DataHoraRN;
import injetws.model.rn.InfoRN;
import injetws.webservices.dto.IwsColetaDiscretaListaOPsDTO;
import injetws.webservices.dto.IwsColetaDiscretaOPEmAbertoDTO;
import injetws.webservices.dto.IwsColetaDiscretaParadaEmAbertoDTO;

@SuppressWarnings("unchecked")
public class ColetaDiscretaOPsRN extends AbstractPdbaInjetDAO {

	IdwLogger log;
	
	public ColetaDiscretaOPsRN(IdwLogger log,DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(log);
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.log = log;
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}
	
	public IwsColetaDiscretaListaOPsDTO getTr_OPsEmAbertoMaquina(String idUP) throws SemSGBDException {
		
		String hql="";
		hql += "select a ";
		hql += "from PrUpOpsEmAberto a ";		
		hql += "where a.prUp.idup = '::idUP'";
		
		hql = hql.replaceAll("::idUP", idUP);		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUpOpsEmAberto> lista = null;
		List<IwsColetaDiscretaOPEmAbertoDTO> listaRetorno = new ArrayList<IwsColetaDiscretaOPEmAbertoDTO>();
		IwsColetaDiscretaOPEmAbertoDTO itemLista = null;
		IwsColetaDiscretaListaOPsDTO retorno = new IwsColetaDiscretaListaOPsDTO();
		
		try {
			lista = q.list();
			if(lista.size() > 0 ){
				for (PrUpOpsEmAberto registro : lista){
					itemLista = new IwsColetaDiscretaOPEmAbertoDTO();

					itemLista.setIdUP(idUP);
					itemLista.setIdOPEmAberto(registro.getIdopemaberto());
					itemLista.setNrOP(registro.getNrop());
					itemLista.setNrOPEstendido(registro.getNropestendido());
					itemLista.setDtHrIniPlanejada(registro.getDthriniplanejada());
					itemLista.setCdMolde(registro.getCdmolde());
					itemLista.setCdMolEstendido(registro.getCdmolestendido());
					itemLista.setCdEstrutura(registro.getCdestrutura());
					itemLista.setCdOperacao(registro.getCdoperacao());
					
					listaRetorno.add(itemLista);
				}
				
				retorno = new IwsColetaDiscretaListaOPsDTO();
				retorno.setLista(listaRetorno);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return retorno;
		
	}
	
	
	public boolean getTr_ExisteOPCarregadaMaquina (String idUP) throws SemSGBDException  {
		boolean retorno = false;
		
		String hql="";
		hql += "select a ";
		hql += "from PrUpOpsEmAberto a ";		
		hql += "where a.prUp.idup = '::idUP'";
		
		hql = hql.replaceAll("::idUP", idUP);
		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUpOpsEmAberto> listaRegistros = null;
		try {
			listaRegistros = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Existe OP carregada 
		if (listaRegistros.size() > 0) {
			retorno = true;
		} else {
			retorno = false;
		}
				
		return retorno;
	}

	public boolean getTr_OpCarregadaEmMaquina (String idUP, String nrOPEstendido) throws SemSGBDException {
		boolean retorno = false;
		
		String hql="";
		hql += "select a ";
		hql += "from PrUpOpsEmAberto a ";		
		hql += "where a.prUp.idup = '::idUP'";
		hql += "  and a.prUp.nropestendido = '::nrOPEstendido'";
		
		hql = hql.replaceAll("::idUP", idUP);
		hql = hql.replaceAll("::nrOPEstendido", nrOPEstendido);
		
		Query q = getDaoPdba().getSession().createQuery(hql);
		
		List<PrUpOpsEmAberto> listaRegistros = null;
		try {
			listaRegistros = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// OP já carregada 
		if (listaRegistros.size() > 0) {
			retorno = true;
		} else {
			retorno = false;
		}
				
		return retorno;
	}	
	
	
	public void setTr_FechaOPColetaDiscreta(String  idUp, 
										    Date    dthrEvento, 
										    String  nrOP,
										    Date    dthrIniPlan,
											String  cdOperacao, 
											String  tpFuncOperacao,
											String  qtdApontada, 
											String  idOPEmAberto) throws MestreOfflineException, SemSGBDException {	
		
		IwsColetaDiscretaParadaEmAbertoDTO paradaEmAberto = new IwsColetaDiscretaParadaEmAbertoDTO();
		
		Date dataHrAtual = dthrEvento;
		
		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = null;
		prup = infoRN.pesquisaPrup(log, 0, idUp);	
		
		long milisegundos = dataHrAtual.getTime()%1000;

		
		if (tpFuncOperacao.equals(ColetaDiscretaOperacaoRN.OPERACAO_PRODUCAO_CARGA_OP)) {
			//Fechar paradas 
			ColetaDiscretaParadasRN paradaRN = new ColetaDiscretaParadasRN(log,getDaoInjet(),getDaoPdba());
			paradaEmAberto = paradaRN.getTr_ParadaEmAbertoMaquina(idUp, idOPEmAberto);
		
			if ( paradaEmAberto.getCdParada() !=  null) {
				// Existe parada aberta
				paradaRN.setTr_ApontaFechamParadaColetaDiscreta(paradaEmAberto.getIdUP(), 
															    dthrEvento, 
															    paradaEmAberto.getDtHrIParada(), 
															    paradaEmAberto.getNrOP(),
															    paradaEmAberto.getCdParada(), 
															    paradaEmAberto.getIdOPEmAberto());
				getDaoPdba().flushReiniciandoTransacao();
			}
			
						
			//Excluir itens em PR_UP_OPS_EM_ABERTO/PR_UP_OPS_EM_ABERTO_PROD
			String sql = "";
			sql += "DELETE FROM PR_UP_OPS_EM_ABERTO_PROD "; 
			sql += " WHERE idopemaberto = '::idopemaberto'";
			sql = sql.replaceAll("::idopemaberto",idOPEmAberto );			
			Query q = getDaoPdba().getSession().createSQLQuery(sql);
			q.executeUpdate();	
			getDaoPdba().flushReiniciandoTransacao();
			
			sql  = "DELETE FROM PR_UP_OPS_EM_ABERTO "; 
			sql += " WHERE idopemaberto = '::idopemaberto'";
			sql = sql.replaceAll("::idopemaberto",idOPEmAberto );			
			q = getDaoPdba().getSession().createSQLQuery(sql);
			q.executeUpdate();	
			getDaoPdba().flushReiniciandoTransacao();			
		} 		

		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(40));

		prcoletoreventos.setDthr1evento(dataHrAtual);
		prcoletoreventos.setMsdthr1evento((double)milisegundos);		
		prcoletoreventos.setDthr2evento(dataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dataHrAtual));

		prcoletoreventos.setNrop(nrOP);
		prcoletoreventos.setInf01(cdOperacao);
		prcoletoreventos.setInf02(qtdApontada);
		
		if (tpFuncOperacao.equals(ColetaDiscretaOperacaoRN.OPERACAO_PRODUCAO_CARGA_OP)) {
			prcoletoreventos.setInf03(DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthrIniPlan));
		}
		
		//PrEventosBridgeCollecDb eventoResposta = null;		
		infoRN.lancarEventoEsperaPrEventosBridgeCollecDb(log, 0, prcoletoreventos, false);
		getDaoPdba().flushReiniciandoTransacao();
		
				
		
	}		

	public String getTr_ValidacaoNovaOPColetaDiscreta(String idUp, Date dthrEvento, String nrOP, String cdOperacao) throws MestreOfflineException, SemSGBDException {
		String retorno = "";
		
		Date dataHrAtual = dthrEvento;
		
		InfoRN infoRN = new InfoRN(getDaoInjet(),getDaoPdba());
		
		PrUp prup = null;
		prup = infoRN.pesquisaPrup(log, 0, idUp);	
		
		long milisegundos = dataHrAtual.getTime()%1000;
		
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setPrUp(prup);
		prcoletoreventos.setTpevento(new BigDecimal(39));
 
		prcoletoreventos.setDthr1evento(dataHrAtual);
		prcoletoreventos.setMsdthr1evento((double)milisegundos);		
		prcoletoreventos.setDthr2evento(dataHrAtual);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dataHrAtual)); 
		prcoletoreventos.setInf01(nrOP);
		prcoletoreventos.setInf02(cdOperacao);
		
		PrEventosBridgeCollecDb eventoResposta = null;
		
		eventoResposta = infoRN.lancarEventoEsperaPrEventosBridgeCollecDb(log, 0, prcoletoreventos, true);
		retorno = eventoResposta.getInf01();
		
		return  retorno;
	}	
}
