package idw.protocolomap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MsEvtDAO;
import idw.model.pojos.MsEvt;
import idw.model.pojos.template.MsEvtTemplate.StEvt;
import ms.model.MsFacade;

public class ProtocoloMapFacade {

	private String urlProtocoloMap = "http://localhost:8080/idw"; // a consolidacao pegara os dados dos eventos via REST nesse endereco

	private static ProtocoloMapFacade instancia = null;
	
	private ProtocoloMapFacade() {
		super();
	}
	
	public static ProtocoloMapFacade getInstancia() {
		if (instancia == null) {
			instancia = new ProtocoloMapFacade();
		}

		return instancia;
	}
	
	public String getUrlProtocoloMap() {
		return urlProtocoloMap;
	}

	public void setUrlProtocoloMap(String urlProtocoloMap) {
		this.urlProtocoloMap = urlProtocoloMap;
	}
	
	/* Metodo para retornar o Connectio do REST recebendo o nome do rest a ser chamado
	 * 
	 */
	private StringBuilder getJson(String urlParcial, String tipoConexao) throws Throwable {
		String urlCompleta = this.urlProtocoloMap + urlParcial;
		urlCompleta = urlCompleta.replaceAll(" ", "%20"); // ainda nao resolvi o problema do espaco em branco, acho q tem q mudar para POST
		
		HttpURLConnection conn = null;
		StringBuilder retorno = new StringBuilder();
		
		try {
			URL url = new URL(urlCompleta);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(4000);
			conn.setRequestMethod(tipoConexao);

	        int resposta = conn.getResponseCode();
	        if(resposta != HttpURLConnection.HTTP_OK) {
	        	throw new Throwable();
	        }

        	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        	String inputLine;

			while ((inputLine = in.readLine()) != null) {
				retorno.append(inputLine);
			}
			in.close();        

		} catch (Exception e) {
			e.printStackTrace();
			throw new Throwable(e);
		} finally {
			conn.disconnect();
		}
		return retorno;
	}
	
	
	/* Metodo deve acessar o REST para obter a lista de UPs que devem ser consolidadas
	 * 
	 */
	public List<Object> pesquisarUps(String mac) {
		return MsFacade.getInstancia().pesquisarUps(mac);
		/*
		List<Object> retorno = new ArrayList<>();
		String json;
		try {
			json = getJson("/rest/coleta/mapConsumirPesquisarUps?mac="+mac, "GET").toString();
		} catch (Throwable e) {
			return new ArrayList<Object>();
		}
        
        if(json != null && json.equals("") == false) {
			JsonParser parser = new JsonParser();
	        JsonArray jsonArray = (JsonArray) parser.parse(json.toString());
	        
	        for(Object o: jsonArray) {
	        	JsonPrimitive jsonPrimite = (JsonPrimitive) o;
	        	
	        	// Obter os dados do json
            	retorno.add(jsonPrimite.getAsString());
	        }
        }
        return retorno;
        */
	}

	
	public List<Long> getIdsEventosPendentesProcessamento(String cdUp, int qtEventosParaProcessar, DAOGenerico dao) {
		MsEvtDAO msEvtDAO = new MsEvtDAO(dao.getSession());
		List<Long> idsEvts = msEvtDAO.getIdsEventosPendentesProcessamento(cdUp, qtEventosParaProcessar);
		return idsEvts;
		

		/* Alessandre em 30-11-21
		List<Long> retorno = new ArrayList<>();
		String json;
		try {
			json = getJson("/rest/coleta/mapConsumirPesquisarIdsPendentes?cdup="+cdUp+"&qtRegistros=" + ConversaoTipos.converteParaString(qtEventosParaProcessar), "GET").toString();
		} catch (Throwable e) {
			return new ArrayList<Long>();
		}
        
        if(json != null && json.equals("") == false) {
			JsonParser parser = new JsonParser();
	        JsonArray jsonArray = (JsonArray) parser.parse(json.toString());
	        
	        for(Object o: jsonArray) {
	        	JsonPrimitive jsonPrimite = (JsonPrimitive) o;
	        	
	        	// Obter os dados do json
            	retorno.add(jsonPrimite.getAsLong());
	        }
        }
        return retorno;
		*/
		
		
	}
	
	public MsEvt pesquisarMsEvt(Long idEvt, DAOGenerico dao) {
		MsEvtDAO msEvtDAO = new MsEvtDAO(dao.getSession());
		MsEvt msEvt = msEvtDAO.getMsEvt(idEvt);
		return msEvt;
		
		/* Alessandre em 30-11-21 comentei o trecho abaixo pois nao está ok para a producao. Nao esta trazendo por exmeplo o dstpevt
		MsEvt retorno = null;
		String json;
		try {
			json = getJson("/rest/coleta/mapConsumirPesquisarEvento?idevt=" + ConversaoTipos.converteParaString(idEvt), "GET").toString();
		} catch (Throwable e) {
			return new MsEvt();
		}
        
        if(json != null && json.equals("") == false) {
			JsonParser parser = new JsonParser();
	        JsonObject jsonObject = (JsonObject) parser.parse(json.toString());
	        retorno = new MsEvt();
	        
	        retorno.setIdEvt( jsonObject.get("idEvt").getAsLong() );
	        
	        // Obtem mstpevt
	        JsonObject jsonMstpevt = (JsonObject) jsonObject.get("msTpevt");
	        MsTpevt mstpevt = new MsTpevt();
	        mstpevt.setIdTpevt(jsonMstpevt.get("idTpevt").getAsLong());
	        retorno.setMsTpevt(mstpevt);

	        
	        // Obtem msmsicup
	        JsonObject jsonMsMsicup = (JsonObject) jsonObject.get("msMsicup");
	        MsMsicup msmsicup = new MsMsicup();
	        msmsicup.setIdMsicup(jsonMsMsicup.get("idMsicup").getAsBigDecimal());
	        try {
	        	msmsicup.setIsAtivo(jsonMsMsicup.get("isAtivo").getAsBoolean());
	        } catch (NullPointerException e) {}
	        // Obtem msUp
	        JsonObject jsonMsUp = (JsonObject) jsonMsMsicup.get("msUp");
	        MsUp msUp = new MsUp();
	        msUp.setIdUp(jsonMsUp.get("idUp").getAsBigDecimal());

	        msmsicup.setMsUp(msUp);
	        msmsicup.setTpConexao(jsonMsMsicup.get("tpConexao").getAsBigDecimal());
	        try {
	        	msmsicup.setUrlAuxiliar(jsonMsMsicup.get("urlAuxiliar").getAsString());
	        } catch (NullPointerException e) {}
	        msmsicup.setUrlConexao(jsonMsMsicup.get("urlConexao").getAsString());
	        retorno.setMsMsicup(msmsicup);
	        
	        // MsEvt inicial
	        JsonObject jsonMsEvt = (JsonObject) jsonObject.get("msEvt");
	        try {
		        MsEvt msevtAnt = new MsEvt();
		        msevtAnt.setIdEvt(jsonMsEvt.get("idEvt").getAsLong());
		        msevtAnt.setDthrEvento( DataHoraRN.stringToDate(jsonMsEvt.get("dthrEvento").getAsString(), "MM d, YYYY HH:mm:ss a") ); // "Oct 7, 2021 2:06:02 PM"
		        retorno.setMsEvt(msevtAnt);
	        } catch  (NullPointerException e) {}	        
	        // DwPePro
	        JsonObject jsonDwPepro = (JsonObject) jsonObject.get("dwPepro");
	        DwPepro dwpepro = new DwPepro();
	        dwpepro.setIdPepro(jsonDwPepro.get("idPepro").getAsLong());
	        retorno.setDwPepro(dwpepro);
	        
	        retorno.setCdUp(jsonObject.get("cdUp").getAsString());
	        retorno.setDthrEvento( DataHoraRN.stringToDate(jsonObject.get("dthrEvento").getAsString(), "MM d, YYYY HH:mm:ss a") ); // "Oct 7, 2021 2:06:02 PM"
	        retorno.setStEvt(jsonObject.get("stEvt").getAsBigDecimal());
	        try {
	        	retorno.setDthrEventoanterior( DataHoraRN.stringToDate(jsonObject.get("dthrEventoanterior").getAsString(),  "MM d, YYYY HH:mm:ss a") );
	        } catch (NullPointerException e) {}
	        retorno.setNrop(jsonObject.get("nrop").getAsString());
	        retorno.setTpErromontagem(jsonObject.get("tpErromontagem").getAsInt());
	        
	        try {
	        	retorno.setCdParada(jsonObject.get("cdParada").getAsString());
	        } catch (Exception e) {}
	        
        }
        return retorno;
		*/
	
	}
	
	public void setResultadoProcessamento(Long idEvt, StEvt stEvt, Date dtHrIProcessamento, Date dtHrFimProcessamento, String erroConsol, DAOGenerico dao) {

		/* Alessandre em 08-10-21 comentei o trecho abaixo e substitui pela chamada do rest
		 * comentar o trecho abaixo qdo o protocolo map for usado
		 */
		/* Alessandre em 06-04-22 transacao comentada pois impactava na transacao principal ##7708
		 * 
		 */
//		Transaction tx = null;

		try {

//			try {
//				tx = dao.getSession().beginTransaction();
//			} catch (TransactionException e) {}
//
			MsEvtDAO msEvtDAO = new MsEvtDAO(dao.getSession());
			
			msEvtDAO.setStEvt(idEvt, stEvt, dtHrIProcessamento, erroConsol);

//			try {
//			tx.commit();
//			} catch(Exception e) {}
//
		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
			throw e;
		} finally {
//			dao.clear();
		}
		
		
		/* Alessandre em 30-11-21 comentei o protocoloMap
		StringBuilder url = new StringBuilder();
		String json;
		
		url.append("/rest/coleta/mapConsumirFinalizarEvento?idevt=");
		url.append(ConversaoTipos.converteParaString(idEvt));
		url.append("&stevt=");
		url.append(ConversaoTipos.converteParaString(stEvt.getValue()));
		url.append("&dthriprocessamento=");
		url.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSparaREST(dtHrIProcessamento));
		url.append("&dthrfprocessamento=");
		url.append(DataHoraRN.dateToStringYYYYMMDDHHMMSSparaREST(dtHrFimProcessamento));
		url.append("&erroconsol=");
		if (erroConsol != null) {
			url.append((char)34);
			url.append(erroConsol);
			url.append((char)34);
		} else {
			url.append(erroConsol);
		}
		try {
			json = getJson(url.toString(), "GET").toString();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		*/
		
		// Fazer um tratamento do retorno
		

	}
}
