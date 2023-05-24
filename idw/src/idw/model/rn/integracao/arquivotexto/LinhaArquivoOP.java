/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idw.model.rn.integracao.arquivotexto;


import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.rn.DataHoraRN;
import idw.model.rn.integracao.erp.OpIntegracaoDTO;
import idw.util.UtilsString;
import idw.webservices.dto.ProdutoDTO;

/**
 *
 * @author Alessandre
 */
public class LinhaArquivoOP {
    private enum Colunas {
        NUMERO_OP(0),
        PRODUTO(1),
        PRODUCAOPLANEJADA(2),
        DATA_INICIAL(3),
        DATA_FINAL(4),
        GT(5);
        
        private final int icoluna;
        
        private Colunas(int icol) {
            this.icoluna = icol;
        }
        public int getId() {
            return this.icoluna;
        }
    }
    private final String linha;
    
    public LinhaArquivoOP(String linha) {
        super();
        this.linha = linha;
    }
    
    public OpIntegracaoDTO getOpIntegracaoDTO() {
        List<String> colunas = UtilsString.quebrarStringEmVetor(linha, ";");
        
        OpIntegracaoDTO retorno = new OpIntegracaoDTO();
        String dthrF = colunas.get(Colunas.DATA_FINAL.getId());
        String dthrI = colunas.get(Colunas.DATA_INICIAL.getId());
        String gt = colunas.get(Colunas.GT.getId());
        
        dthrF = UtilsString.removeCaracteresDeCampos(dthrF);
        dthrI = UtilsString.removeCaracteresDeCampos(dthrI);
        
        try {
            retorno.setDthrFplanejada(DataHoraRN.toDateFromYYYYMMDDHHMISS(dthrF));
            retorno.setDthrIplanejada(DataHoraRN.stringToDate(dthrI, "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException ex) {
            
        }
        retorno.setNrop(UtilsString.removeCaracteresDeCampos(colunas.get(Colunas.NUMERO_OP.getId())));
        
        ProdutoDTO produto = new ProdutoDTO();
        OmProduto omproduto = new OmProduto();
        omproduto.setCdProduto(UtilsString.removeCaracteresDeCampos(colunas.get(Colunas.PRODUTO.getId())));
        produto.setProduto(omproduto);
        produto.setAproduzir(new BigDecimal(colunas.get(Colunas.PRODUCAOPLANEJADA.getId())));
        retorno.getProdutos().add(produto);

        // Adiciona o grupo definido na coluna
        List<OmGt> gts = new ArrayList<>();
        OmGt omgt = new OmGt();
        omgt.setDepara(gt);
        gts.add(omgt);
        retorno.setGrupos(gts);
        
        return retorno;
    }
}
