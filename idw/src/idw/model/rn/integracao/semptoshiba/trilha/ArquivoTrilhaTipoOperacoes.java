package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmTppt;
import idw.model.rn.TpptRN;


public class ArquivoTrilhaTipoOperacoes extends ArquivoTrilha {	
	private final DAOGenerico daoGenerico;
	
	public ArquivoTrilhaTipoOperacoes(DAOGenerico daoGenerico) {
		this.daoGenerico = daoGenerico;
	}
	
	@Override
	protected String getFileName() {
		return "TIPO_OPERACOES.txt";
	}

	@Override
	protected String getHeader() {
		return ArquivoTrilhaUtils.gerarLinha("Codigo","Descricao");
	}
	
	
	@Override
	protected String getBody() {
		
		TpptRN tpPtRN = new TpptRN(daoGenerico);

		List<OmTppt> listaOmTppt = tpPtRN.getOmTpPtsAtivos();		
		
		StringBuilder sb = new StringBuilder();

		for (OmTppt omTppt : listaOmTppt) {
			sb.append(gerarLinhaTipoOperacoes(omTppt.getCdTppt(), omTppt.getDsTppt()));
			sb.append(ArquivoTrilhaUtils.LINHA_EM_BRANCO);
		}

		return sb.toString();
		
	}
	
	private String gerarLinhaTipoOperacoes(String codigo, String descricao){
		return ArquivoTrilhaUtils.gerarLinha(codigo, descricao);
	}

	
}
