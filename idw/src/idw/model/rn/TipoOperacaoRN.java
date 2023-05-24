package idw.model.rn;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwTOperacao;
import idw.webservices.dto.DwTOperacaoDTO;
import idw.webservices.dto.DwTOperacoesDTO;

public class TipoOperacaoRN extends AbstractRN<DAOGenerico> {

	public TipoOperacaoRN() {
		this(null);
	}

	public TipoOperacaoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	@SuppressWarnings("unchecked")
	public DwTOperacoesDTO getTiposOperacao() {

		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("SELECT operacao");
		q.append("from DwTOperacao operacao");

		List<DwTOperacao> listaPesquisa = null;
		try {
			listaPesquisa = q.query().list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DwTOperacaoDTO> lista = new ArrayList<DwTOperacaoDTO>();

		if (listaPesquisa != null) {
			for (DwTOperacao item : listaPesquisa) {
				DwTOperacaoDTO dwTOperacaoDTO = new DwTOperacaoDTO();
				
				DwTOperacao operacao = new DwTOperacao();
				operacao.setIdToperacao(item.getIdToperacao());
				operacao.setDsToperacao(item.getDsToperacao());
				
				dwTOperacaoDTO.setDwTOperacao(operacao);
				lista.add(dwTOperacaoDTO);
			}
		}

		DwTOperacoesDTO listaRetorno = new DwTOperacoesDTO();
		listaRetorno.setListaOperacoesDTO(lista);

		return listaRetorno;
	}
	
	public DwTOperacao getDwTOperacao(String descricao){
		if(descricao.equals("")){
			return null;
		}
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		
		q.append("SELECT tipoOperacao");
		q.append("FROM DwTOperacao tipoOperacao");
		q.append("WHERE tipoOperacao.dsToperacao = :dsToperacao");
		
		q.defineParametro("dsToperacao", descricao);
		
		DwTOperacao tipoOperacao = (DwTOperacao) q.query().uniqueResult();		
		
		return tipoOperacao;
	}
	
	public DwTOperacao getTOperacaoById(long id) {
		return this.getDao().findById(DwTOperacao.class, id, false);
	}
}
