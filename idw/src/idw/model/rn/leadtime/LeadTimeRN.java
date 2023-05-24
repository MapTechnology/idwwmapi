package idw.model.rn.leadtime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.PpCpprodutoDAO;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCpproduto;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.ListaDwPassagemDTO;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;

@SuppressWarnings("unchecked")
public class LeadTimeRN extends DAOGenerico {
	
	/*
	 * Metodo principal para retornar os dados para o grafico de leadtime
	 */
	public ListaDwPassagemDTO getListaLeadTime(String op, String pt, String produto, Date data1,Date data2){

		MapQuery q = new MapQuery(getSession());
		
		q.append("select dwpassagem from DwConsolid dwConsolid ");
		q.append("INNER join dwConsolid.ppCp ppcp ");
		q.append("join ppcp.ppCpprodutos ppcpproduto");
		q.append("INNER join dwConsolid.omPt ompt ");
		q.append("INNER join dwConsolid.dwPassagems dwpassagem ");	
		q.append("INNER join dwpassagem.dwNserie dwnserie ");	
		q.append("INNER join dwnserie.omProduto omproduto ");	
		q.append("where dwConsolid.dtReferencia BETWEEN :data1 and :data2 ");	
		q.append("and dwConsolid.tpId = 1 ");
		q.append("and ppcpproduto.nrDoc = :op ");
		q.append("and ompt.cdPt = :pt ");
		q.append("and omproduto.cdProduto = :produto ");
		q.append("order by dwnserie.ns");
		
		q.defineParametroData("data1", data1);
		q.defineParametroData("data2", DataHoraRN.adicionaDiasDaData(data2, 1) );
		q.defineParametro("op", op);
		q.defineParametro("pt", pt);
		q.defineParametro("produto", produto);
		
		List<DwPassagem> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<DwPassagem> listaDTO = new ArrayList<DwPassagem>();
		
		if (lista != null) {
			for (DwPassagem item : lista) {
				
				listaDTO.add(item.clone(true));
			}
		}
		
		ListaDwPassagemDTO listaRetorno = new ListaDwPassagemDTO();
		listaRetorno.setListaPessagem(listaDTO);
	
		
		return listaRetorno;	
		
	}

	
	public PesquisasDTO pesquisaPpCp(PesquisaDTO pesquisa) {
		PpCpprodutoDAO cpprodutoDAO = new PpCpprodutoDAO(getSession());
		List<PpCpproduto> lista = cpprodutoDAO.getPpCpprodutosDoPpCpAtivo(pesquisa.getCodigo());
		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();
		if (lista != null) {
			for (PpCpproduto item : lista) {
				if (item.getNrDoc() == null || (item.getNrDoc() != null && item.getNrDoc().equals("")) )
					continue;
				
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getNrDoc());
				itemDTO.setDescricao(item.getNrDoc());
				itemDTO.setRegistro(item.clone());
				
				// Verifica se ja esta na lista. Se nao estiver incluir
				boolean isExiste = false;
				for (PesquisaDTO p : listaDTO) {
					if (p.getCodigo().equals(itemDTO.getCodigo()))
						isExiste = true;
				}
				if (isExiste == false)
					listaDTO.add(itemDTO);
			}
		}
		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;
	}
	
	public PesquisasDTO pesquisaPpCpProduto(PesquisaDTO pesquisa,String cdOp) {

		String hql = "";
		hql += "SELECT DISTINCT omProduto from PpCp ppCp ";
		hql += "INNER JOIN ppCp.ppCpprodutos ppCpprodutos ";
		hql += "INNER JOIN ppCpprodutos.omProduto omProduto ";		
		hql += "where ppCpprodutos.nrDoc = ':cdOp' ";	
		hql += "and omProduto.stAtivo = 1 ";	

		hql = hql.replaceAll(":cdOp", cdOp);
		
		Query q = getSession().createQuery(hql);

		List<OmProduto> lista = null;
		try {
			lista = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<PesquisaDTO> listaDTO = new ArrayList<PesquisaDTO>();

		if (lista != null) {
			for (OmProduto item : lista) {
				PesquisaDTO itemDTO = new PesquisaDTO();
				itemDTO.setCodigo(item.getCdProduto().toString());
				itemDTO.setDescricao(item.getDsProduto());
				itemDTO.setRegistro(item.clone());
				listaDTO.add(itemDTO);
			}
		}

		PesquisasDTO pesquisas = new PesquisasDTO();
		pesquisas.setPesquisa(listaDTO);
		return pesquisas;

	}
	
}
