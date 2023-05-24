package idw.webservices.rest.mfv;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmProduto;
import idw.model.rn.ProdutoRN;
import idw.webservices.rest.ResourceWebApplicationException;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/mfv/produtos")
public class ProdutoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdutos(@QueryParam("listaIdGt") String listaIdGt) {
		//fa3getlistaproduto 
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ProdutoRN produtoRN = new ProdutoRN(dao);
			List<OmProduto> produtos = produtoRN.getListaProdutoGts(listaIdGt);

			List<JsonObject> produtosFormatados = new ArrayList<>();
			for(OmProduto produto : produtos) {
				JsonObject produtoJson = new JsonObject();
				produtoJson.addProperty("cd_produto", produto.getCdProduto());
				produtoJson.addProperty("observacao", produto.getDsProduto());
				produtosFormatados.add(produtoJson);
			}

			dao.commitaTransacao(dao.getSession());			
			responseStatus = Response.Status.OK;			
			rootElement.add("produtos", gson.toJsonTree(produtosFormatados));
			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	@GET
	@Path("/produto") //fa3getproduto
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduto( @QueryParam("listaIdGt") String listaIdGt, @QueryParam("cdProduto") String cdProduto) {
		//fa3getlistaproduto 
		DAOGenerico dao = new DAOGenerico();
		Gson gson = new Gson();
		JsonObject rootElement = new JsonObject();
		Response.Status responseStatus;

		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			ProdutoRN produtoRN = new ProdutoRN(dao);
			List<OmProduto> produtos = produtoRN.getListaProdutoGtsCdProduto(listaIdGt, cdProduto);

			List<JsonObject> produtosFormatados = new ArrayList<>();
			for(OmProduto produto : produtos) {
				JsonObject produtoJson = new JsonObject();
				produtoJson.addProperty("cd_produto", produto.getCdProduto());
				produtoJson.addProperty("observacao", produto.getDsProduto());
				produtosFormatados.add(produtoJson);
			}

			dao.commitaTransacao(dao.getSession());			
			responseStatus = Response.Status.OK;			
			rootElement.add("produto", gson.toJsonTree(produtosFormatados));
			String json = gson.toJson(rootElement);			
			return Response.status(responseStatus).entity(json).build();			
		} catch (Exception e) {			
			dao.rollBackTransacaoSemException();
			throw new ResourceWebApplicationException(rootElement, e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}

}
