package idw.model.rn.relatorios.opprocessada;

import idw.model.pojos.DwConsolpr;
import idw.model.pojos.template.DwPeproTemplate;
import idw.util.AritmeticaUtil;
import idw.util.FormulasInjet;

public class GeraLinhaDetalheProduto {
	
	public void acumulaProduto(DwConsolpr produto, RelatorioOrdemProducaoProcessadaDetalheDTO linha) {
		
		//  Encontra dto com o produto desejado
		RelatorioOrdemProducaoProcessadaProdutoDTO linhaProduto = null;
		for (RelatorioOrdemProducaoProcessadaProdutoDTO dto : linha.getProdutos()) {
			if (dto.getCdProduto().equals(produto.getOmProduto().getCdProduto())) {
				linhaProduto = dto;
				break;
			}
		}
		
		// adicina valores acumulados
		if (linhaProduto == null) {
			linhaProduto = new RelatorioOrdemProducaoProcessadaProdutoDTO();
			linhaProduto.setCdProduto(produto.getOmProduto().getCdProduto());
			linhaProduto.setDsProduto(produto.getOmProduto().getDsProduto());
			linha.getProdutos().add(linhaProduto);
		}
		
		if (produto.getDwConsol().getDwConsolid().getDwPepro().getIdPepro() == DwPeproTemplate.Type.REGULAGEM.getId()) {
			linhaProduto.setProducaoBrutaEmRegulagem(AritmeticaUtil.somar(linhaProduto.getProducaoBrutaEmRegulagem(), produto.getPcsProducaoBruta()));
		} else {
			linhaProduto.setProducaoBruta(AritmeticaUtil.somar(linhaProduto.getProducaoBruta(), produto.getPcsProducaoBruta()));
			linhaProduto.setProducaoRefugada(AritmeticaUtil.somar(linhaProduto.getProducaoRefugada(), produto.getPcsProducaoRefugada()));
			linhaProduto.setProducaoLiquida(AritmeticaUtil.diminuir(linhaProduto.getProducaoBruta(), linhaProduto.getProducaoRefugada()));
		}
		
		linhaProduto.setProducaoBrutaMaisProducaoEmRegulagem(AritmeticaUtil.somar(linhaProduto.getProducaoBruta(), linhaProduto.getProducaoBrutaEmRegulagem()));
		linhaProduto.setProducaoRefugadaMaiProducaoEmRegulagem(AritmeticaUtil.somar(linhaProduto.getProducaoRefugada(), linhaProduto.getProducaoBrutaEmRegulagem()));


		linhaProduto.setIndiceRefugo(FormulasInjet.calcularIndiceRefugo(linhaProduto.getProducaoRefugada(), linhaProduto.getProducaoBruta()).doubleValue());
		linhaProduto.setIndiceRefugoEmRegulagem(FormulasInjet.calcularIndiceRefugo(linhaProduto.getProducaoRefugadaMaiProducaoEmRegulagem(), linhaProduto.getProducaoBrutaMaisProducaoEmRegulagem()).doubleValue()); 
	}

}
