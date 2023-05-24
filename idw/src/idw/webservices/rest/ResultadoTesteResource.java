package idw.webservices.rest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwPassagemDAO;
import idw.model.dao.DwRotaDAO;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwRota;
import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.DwPassagemTemplate.StNserie;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.VerificaPassagemRN;
import idw.webservices.dto.NaoConformidadeDTO;
import idw.webservices.dto.PassagemDTO;
import idw.webservices.dto.ResultadoTesteCodigoBarrasDTO;

@Path("/resultados-testes")
public class ResultadoTesteResource {

	private static final String MSG_ROTEIRO_NAO_ENCONTRADO = "Roteiro não encontrado";
	private static final String JSON_ELEMENT_RESULTADOS = "resultados";
	private static final String JSON_ELEMENT_RESULTADO_GERAL = "resultadoGeral";

	@GET
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(ResourceUtils.MEDIA_TYPE_JSON_UTF8)
	public Response getResultado(@QueryParam("cd-barras") String codigoBarras) {

		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();

		try {

			dao.iniciaSessao();

			DwPassagemDAO dwPassagemDAO = new DwPassagemDAO(dao.getSession());
			List<DwPassagem> listPassagem = dwPassagemDAO.getPassagens(codigoBarras);

			if (listPassagem.isEmpty()) {
				String msg = String.format("Resultados de testes não encontrado para código de barras %s.", codigoBarras);
				throw new ResourceWebApplicationException(Response.Status.NOT_FOUND, msg);
			}

			montarResultados(gson, rootElement, listPassagem);
			montarResultadoGeral(gson, rootElement, dao, codigoBarras, listPassagem);

			dao.commitaTransacao(dao.getSession());

			String json = gson.toJson(rootElement);

			return Response.ok(json).build();

		} catch (Exception e) {
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	private void montarResultados(Gson gson, JsonObject rootElement, List<DwPassagem> listPassagem) {
		Set<ResultadoTesteCodigoBarrasDTO> resultados = new HashSet<>();

		JsonArray resultadosJsonArray = new JsonArray();
		for (DwPassagem dwPassagem : listPassagem) {
			ResultadoTesteCodigoBarrasDTO dto = createResultadoTesteCodigoBarrasDTO(dwPassagem);

			/*
			 * Pode acontecer que aparecer itens repeditos em dw_passagem. Pois na consolidação não existe tratamento para esta situação.
			 * Idenficamos casos onde isso acontece. Relataram que isso pode ocorrer quando o arquivo, com os eventos da máquina é
			 * processado mais de uma vez
			 */
			if (resultados.add(dto)) {
				JsonElement resultado = gson.toJsonTree(dto);
				resultadosJsonArray.add(resultado);
			}

		}

		rootElement.add(JSON_ELEMENT_RESULTADOS, resultadosJsonArray);
	}

	private void montarResultadoGeral(Gson gson, JsonObject rootElement, DAOGenerico dao, String cb, List<DwPassagem> passagens) {

		ResultadoTesteCodigoBarrasDTO dto = null;

		// pegar última passagem
		DwPassagem ultimaPassagem = passagens.get(0);

		OmProduto omProduto = getOmProdutoDoRoteiroAtravesPassagem(ultimaPassagem);

		DwRotaDAO dwRotaDAO = new DwRotaDAO(dao.getSession());
		DwRota dwRota = dwRotaDAO.getDwRotaPorProduto(omProduto.getCdProduto());
		long idRota = 0l;
		if (dwRota != null)
			idRota = dwRota.getIdRota();

		// dto = createResultadoTesteCodigoBarrasDTOSemRoteiro();

		VerificaPassagemRN verificaPassageRN = new VerificaPassagemRN(dao);
		PassagemDTO passagemDTO = verificaPassageRN.obtemNaoConformidadesAtuais(
				ultimaPassagem.getDwNserie().getCb(),
				idRota,
				ultimaPassagem.getOmPt().getOmTppt().getIdTppt().intValue(),
				ultimaPassagem.getOmPt().getPpCp().getNrop(), 
				ultimaPassagem.getOmPt().getPpCp().getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue()));

		List<NaoConformidadeDTO> listaNaoConformidades = passagemDTO.getNaoConformidadesAtuais();
		if (listaNaoConformidades != null && !listaNaoConformidades.isEmpty()) {
			NaoConformidadeDTO primeiraNaoConformidadeDTO = listaNaoConformidades.iterator().next();
			dto = createResultadoTesteCodigoBarrasDTO(primeiraNaoConformidadeDTO, cb);
		} else {
			dto = createResultadoTesteCodigoBarrasDTO(ultimaPassagem);
		}

		JsonElement resultado = gson.toJsonTree(dto);
		rootElement.add(JSON_ELEMENT_RESULTADO_GERAL, resultado);
	}

	private OmProduto getOmProdutoDoRoteiroAtravesPassagem(DwPassagem dwPassagem) {
		DwConsolid dwConsolid = dwPassagem.getDwConsolid();
		PpCp ppCp = dwConsolid.getPpCp();
		PpCpproduto ppCpProduto = ppCp.getPpCpprodutos().iterator().next();
		return ppCpProduto.getOmProduto();
	}

	private ResultadoTesteCodigoBarrasDTO createResultadoTesteCodigoBarrasDTOSemRoteiro() {
		ResultadoTesteCodigoBarrasDTO dto = new ResultadoTesteCodigoBarrasDTO();
		dto.setResultado((int) StNserie.NAO_CONFORME.getValue());
		dto.setDetalheResultado(MSG_ROTEIRO_NAO_ENCONTRADO);
		return dto;
	}

	private ResultadoTesteCodigoBarrasDTO createResultadoTesteCodigoBarrasDTO(DwPassagem dwPassagem) {
		String cdPt = dwPassagem.getOmPt().getCdPt();
		String cdBarras = dwPassagem.getDwNserie().getCb();
		String dtHr = DataHoraRN.dateToStringDDMMYYYYHHMMSS(dwPassagem.getDthr());
		int resultado = dwPassagem.getStNserie();

		return new ResultadoTesteCodigoBarrasDTO(cdBarras, cdPt, dtHr, resultado);
	}

	private ResultadoTesteCodigoBarrasDTO createResultadoTesteCodigoBarrasDTO(NaoConformidadeDTO naoConformidadeDTO, String cb) {
		String cdPt = naoConformidadeDTO.getCdPt();
		String cdBarras = cb;
		String dtHr = DataHoraRN.dateToStringDDMMYYYYHHMMSS(naoConformidadeDTO.getDthrNC());
		int resultado = (int) StNserie.NAO_CONFORME.getValue();
		return new ResultadoTesteCodigoBarrasDTO(cdBarras, cdPt, dtHr, resultado);
	}

}
