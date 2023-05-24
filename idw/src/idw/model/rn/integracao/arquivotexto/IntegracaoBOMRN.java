package idw.model.rn.integracao.arquivotexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmJobdet;
import idw.model.pojos.OmJobdetlog;
import idw.model.pojos.OmJoblog;
import idw.model.pojos.template.OmJobdetlogTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.ArquivosDiretorios;
import idw.webservices.dto.ProdutoDTO;

public class IntegracaoBOMRN {

	public boolean integrarBOM(OmJoblog log, OmJobdet det, String arquivo, DAOGenerico dao) {
		boolean isRetorno = true;
		
		OmJobdetlog detlog = new OmJobdetlog();
		
		detlog.setDthrIexecucao(DataHoraRN.getDataHoraAtual());
		detlog.setIdJobdetlog(null);
		detlog.setOmJobdet(det);
		detlog.setOmJoblog(log);
		detlog.setStExecucao(OmJobdetlogTemplate._StExecucao.SUCESSO.getValue());
		
		String dthrCriacao = DataHoraRN.dateToStringYYYYMMDDHHMMSS(ArquivosDiretorios.getDtHrModificacao(arquivo));

		detlog.setUrlOrigem(arquivo + dthrCriacao);

		/* Ler o arquivo para incluir na base
		 * 
		 */
		File arqleitura = null;
		arqleitura = new File(arquivo);
		if (arqleitura.exists()) {
			int resultado = lerArquivo(arqleitura);
			if (resultado == 0) // sucesso
				detlog.setDsExecucao("Importação BOM ok do arquivo " + arquivo);
			else if (resultado == -1)
				detlog.setDsExecucao("Arquivo BOM não existe. " + arquivo);
			else if (resultado == -2)
				detlog.setDsExecucao("Erro de leitura do arquivo BOM. " + arquivo);
			else {
				ProdutoDTO dto = new ProdutoDTO();
				detlog.setDsExecucao("Erro no BOM " + dto.getDescricaoResultado(resultado));
			}
		} else {
			detlog.setDsExecucao("Arquivo BOM desconhecido. " + arquivo);
			isRetorno = false;
		}
		detlog.setDthrFexecucao(DataHoraRN.getDataHoraAtual());		
		dao.makePersistent(detlog);
		
		return isRetorno;
	}
	
	
    private int lerArquivo(File arquivo){
        IPlanilhaEstruturaProduto planilha;
        try {
            planilha = new PlanilhaEstruturaProdutoEmExcel(arquivo);
        } catch (FileNotFoundException ex) {
            return -1;
        } catch (IOException ex) {
            // Talvez o formato seja CSV
            try {
                planilha = new PlanilhaEstruturaProdutoEmCSV(arquivo);
            } catch (IOException ex1) {
                ex.printStackTrace();
                return -2;
            }
        }

        List<ProdutoDTO> resultado = null;
        try {
        	resultado = planilha.obtemEstruturaProdutoD();
        } catch (NullPointerException e) {
        	return -2;
        }
        ProdutoDTO retorno = new ProdutoDTO();
        for (ProdutoDTO produtodto : resultado) {
			// imprimir(resultado.getProduto(), 0);
			retorno = IdwFacade.getInstancia().importarPlanilhaEstruturaProduto(produtodto);
			if (retorno.getResultadoEvento() != retorno.getEVENTO_BEM_SUCEDIDO()) {
				return retorno.getResultadoEvento();
			}
        }
        
        return retorno.getEVENTO_BEM_SUCEDIDO();
    }

}
