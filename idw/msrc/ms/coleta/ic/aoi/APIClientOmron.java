package ms.coleta.ic.aoi;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import idw.util.IdwLogger;

public class APIClientOmron {
	public String ipHostAPI = new String();
	public String resourcesPATH = "prismRest/resources/";
	public String pcbInfo = "GetPcbInfoByBarcode";
	public String getSegment = "GetSegmentInfo";
	private IdwLogger log;

	public APIClientOmron(IdwLogger log, String ipHostAPI) {
		this.log = log;
		this.ipHostAPI = "http://" + ipHostAPI + "/";
		this.log.info("Instanciei um novo cliente para a API: " + this.ipHostAPI);
	}

	public List<String> getBarcodesFromBlanck(String blanck, String machName, String botOrTop) {
		// Luiz - O board ID do xml equivale ao código de barras retornado pelo log
		// Luiz - O log também retorna se o processo é top ou bottom
		// Luiz - botOrTop = 1 caso seja bottom e 0 caso seja top
		String xmlAPI1 = ("<?xml version='1.0' encoding='UTF-8' standalone='yes'?>" +
				"<parameterUM>" +
				"<params>" +
				"<param name='inspection_end_time_from' value='' />" +
				"<param name='inspection_end_time_to' value='' />" +
				"<param name='system_machine_name' value='" + machName + "' />" +
				"<param name='board_id' value='" + blanck + "' />" +
				"<param name='board_side' value='" + botOrTop + "' />" +
				"<param name='lang_type' value='0' />" +
				"<param name='result_category_type' value='' />" +
				"</params>" +
				"</parameterUM>");

		MultivaluedMapImpl queryParamsAPI1 = new MultivaluedMapImpl();
		queryParamsAPI1.add("param", xmlAPI1);
		String response1 = null;
		String inspectionID = null;
		String response2 = null;
		try {
			Client cliente = Client.create();
			WebResource webResource1 = cliente.resource(this.ipHostAPI + this.resourcesPATH + this.pcbInfo);
			// String s = webResource1.type(MediaType.APPLICATION_XML).get(String.class);
			response1 = webResource1.queryParams(queryParamsAPI1).get(String.class);
			
			log.info("chamadno url " + this.ipHostAPI + this.resourcesPATH + this.pcbInfo);
			
		} catch (Exception e) {
			log.info("Não foi possível obter o inspection ID da API-1");
			log.info("ArquivoAoiAPI: Excessao ao obter inspectionID da maquina: " + machName + " barcode: " + blanck + e);
		}
		if (response1 != null && response1.length() >= 1) {
			log.info("Recebi uma resposta válida da maq: " + machName + " com o codigo de barras do blanck: " + blanck + " e fase: " + botOrTop);
			inspectionID = getInspectionIDfromAPI1Result(response1);
		} else {
			log.info("Não recebi uma resposta válida da maq: " + machName + " com o codigo de barras do blanck: " + blanck);
			return null;
		}
		if (inspectionID == null || inspectionID.length() <= 0) {
			log.info("inspectionID está nulo ou vazio. maquina = " + machName + " barcode: " + blanck);
			return null;
		}

		String xmlAPI27 = ("<?xml version='1.0' encoding='UTF-8' standalone='yes'?>" +
				"<parameterUM>" +
				"<params>" +
				"<param name='inspection_id' value='" + inspectionID + "' />" +
				"<param name='system_machine_name' value='" + machName + "' />" +
				"<param name='lang_type' value='0' />" +
				"<param name='result_category_type' value='' />" +
				"</params>" +
				"</parameterUM>");

		MultivaluedMapImpl queryParamsAPI27 = new MultivaluedMapImpl();
		queryParamsAPI27.add("param", xmlAPI27);
		try {
			Client cliente = Client.create();
			WebResource webResource1 = cliente.resource(this.ipHostAPI + this.resourcesPATH + this.getSegment);
			// String s = webResource1.type(MediaType.APPLICATION_XML).get(String.class);
			response2 = webResource1.queryParams(queryParamsAPI27).get(String.class);
		} catch (Exception e) {
			log.info("ArquivoAoiAPI: Excessao em lista de codigos de barras lidos do blanck da maquina: " + machName + "inspectionID: " + inspectionID + e);

		}
		if (response2 == null || response2.length() <= 0)
			return null;

		List<String> listaCodigosDoBlanck = getListaDeCodigosDoBlanck(response2);
		if (listaCodigosDoBlanck != null && listaCodigosDoBlanck.size() > 0) {
			String listaCBsAux = "";
			for (String cbObtidoAPI : listaCodigosDoBlanck) {
				listaCBsAux = listaCBsAux + cbObtidoAPI + ";";
			}
			log.info("Recebi uma segunda resposta válida da maq: " + machName + " com o codigo de barras do blanck: " + blanck + ", fase: " + botOrTop + " e lista de CBsObtidos da API: " + listaCBsAux);
			return orderBarcodesWithTheMainByLast(listaCodigosDoBlanck, blanck);
		} else {
			log.info("Nao recebi segunda resposta válida da maq: " + machName + " com o codigo de barras do blanck: " + blanck);
		}
		
		return null;

	}

	private String getInspectionIDfromAPI1Result(String response1) {
		List<String> datas = obtemChaves("data", response1);
		if (datas != null && datas.size() > 0) {
			String[] dataSplited = datas.get(datas.size() - 1).split("/>");
			if (dataSplited != null && dataSplited.length > 0)
				for (String campo : dataSplited) {
					if (campo.contains("inspection_id")) {
						String retorno = campo.substring(campo.indexOf("\"") + 1);
						retorno = retorno.substring(0, retorno.indexOf("\""));
						return retorno;
					}
				}
		}
		return null;
	}

	private List<String> getListaDeCodigosDoBlanck(String response2) {
		List<String> data = obtemChaves("data", response2);
		List<String> retorno = new ArrayList<String>();
		for (String eachData : data) {
			String[] dataSplited = eachData.split("/>");
			if (dataSplited != null && dataSplited.length > 0)
				for (String campo : dataSplited) {
					if (campo.contains("segment_code")) {
						String cb = campo.substring(campo.indexOf("\"") + 1);
						cb = cb.substring(0, cb.indexOf("\""));
						retorno.add(cb);
					}
				}
		}
		return retorno;
	}

	public String obtemChaveUnica(String chave, String conteudo) {
		String retorno = new String("");

		int posicaoChave = conteudo.indexOf("<" + chave + ">");
		String resto = conteudo;
		if (posicaoChave >= 0) {

			resto = resto.substring(posicaoChave + chave.length() + 2);
			String ateC = "</" + chave + ">";

			int ate = resto.indexOf(ateC);
			if (ate >= 0) {
				String valor = resto.substring(0, ate);
				retorno = valor;
			}
		}

		return retorno;
	}

	public List<String> obtemChaves(String chave, String conteudo) {
		List<String> retorno = new ArrayList<String>();

		int posicaoChave = conteudo.indexOf("<" + chave + ">");
		String resto = conteudo;
		while (posicaoChave >= 0) {

			resto = resto.substring(posicaoChave + chave.length() + 1);
			String ateC = "</" + chave + ">";

			int ate = resto.indexOf(ateC);
			String valor = resto.substring(0, ate);
			resto = resto.substring(ate + ateC.length());

			if (valor.equals(chave) == false)
				retorno.add(valor);

			posicaoChave = resto.indexOf(chave);
		}

		return retorno;
	}
	
	
	
	
	
	// Esse metodo retorna a lista dos CBs lidos do webservice e  coloca por ulitmo na lista o CB principal.
	// Isso é importante para a consolidacao
	private List<String> orderBarcodesWithTheMainByLast(List<String> lista, String blanck) {
		List<String> retorno = new ArrayList<>();
		for (String cb : lista) {
			if (cb.equals(blanck) == false) {
				log.info("o CB do http " + cb + " será retornado.");
				retorno.add(cb);
			}
		}
		retorno.add(blanck);
		log.info("adicionando o CB principal na lista  " + blanck);
		return retorno;
	}

	
	
	
	
	
	
	
	public List<String> removeCodigosDuplicados(List<String> lista) {
		List<String> retorno = new ArrayList<String>();
		Set<String> s = new LinkedHashSet<String>(lista);
		retorno.addAll(s);
		return retorno;
	}
}
