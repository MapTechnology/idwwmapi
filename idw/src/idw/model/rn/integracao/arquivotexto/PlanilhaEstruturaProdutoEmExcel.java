/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.model.rn.integracao.arquivotexto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;

import idw.model.IdwFacade;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCliente;
import idw.util.PlanilhaExcelAbstract;
import idw.webservices.dto.ProdutoDTO;

/**
 *
 * @author alessandre
 */
public class PlanilhaEstruturaProdutoEmExcel extends PlanilhaExcelAbstract implements IPlanilhaEstruturaProduto{

    private FileInputStream fis;
    private boolean isFinalPlanilha = false;
    private PlanilhaEstruturaProdutoDTO linhaPlanilha = null;

    private int iColunaNComponente = 0;
    private int iColunaNiv = 0;
    private int iColunaTextoBreve = 0;
    private int iColunaQtd = 0;
    
    public PlanilhaEstruturaProdutoEmExcel(File file) throws FileNotFoundException, IOException{
        super(file);
    }

    @Override
    // Metodo principal para da classe, com a funcao de ler a planilha e importar a estrutura do produto principal e de toda a estrutura
    public List<ProdutoDTO> obtemEstruturaProdutoD(){
        String identificacaoInicioDosDados = "Nº componente";
        
        // inicializa o iterator da linha
        this.aba = this.planilha.getSheetAt(0);
        this.iteratorR  = aba.rowIterator();
        
        OmProduto omproduto = new OmProduto();
        PpCliente ppcliente = new PpCliente();

        // Tenta obter o codigo do produto que será importado
        Object cdProduto;
        
        cdProduto = buscarValorAEsquerdaParaTexto("Material");
        
        if ((cdProduto!=null && cdProduto.toString().equals("Nível")) || cdProduto == null){
            this.iteratorR  = aba.rowIterator();
            cdProduto = buscarValorAbaixoDoTexto("Material", HSSFCell.CELL_TYPE_STRING);
        }
                
        if (cdProduto == null) {
            this.iteratorR  = aba.rowIterator();
            cdProduto = buscarValorAbaixoDoTexto("Nº do material", HSSFCell.CELL_TYPE_STRING);
        }
        
        omproduto.setCdProduto(cdProduto.toString());

        // Se nao conseguir identificar qual o produto, então gerar excessao que Planilha esta for do padrão
        if (omproduto.getCdProduto() == null){
            return null;
        }
        // Obtem outras propriedades
        Object cdCliente = buscarValorAEsquerdaParaTexto("Cent./Util./Alt:");
        if (cdCliente == null) {
            // nesse caso procurar pelo 2o estilo de planilha
            this.iteratorR  = aba.rowIterator();
            cdCliente = buscarValorAbaixoDoTexto("Cen.", HSSFCell.CELL_TYPE_STRING);
        }
        if (cdCliente == null) {
            // nesse caso procurar pelo 2o estilo de planilha
            this.iteratorR  = aba.rowIterator();
            cdCliente = buscarValorAbaixoDoTexto("Centro", HSSFCell.CELL_TYPE_STRING);
        }
        if (cdCliente == null) {
            // nesse caso procurar pelo 2o estilo de planilha
            this.iteratorR  = aba.rowIterator();
            cdCliente = buscarValorAbaixoDoTexto("CC", HSSFCell.CELL_TYPE_STRING);
        }
        
        ppcliente.setCdCliente(cdCliente.toString());
        // Pega apenas os 3 primeiros caracteres
        ppcliente.setCdCliente(ppcliente.getCdCliente().substring(0,3));
        omproduto.setPpCliente(ppcliente);
        //
        this.iteratorR  = aba.rowIterator(); // Volta o iterator para pesquisar a denominacao desde o inicio
        Object dsProduto = buscarValorAEsquerdaParaTexto("Denominação");
        if (dsProduto == null){
            this.iteratorR  = aba.rowIterator();
            if(buscarValorAEsquerdaParaTexto("Unit/Total") != null){
                this.iteratorR  = aba.rowIterator();
                dsProduto = omproduto.getCdProduto();
            }
        }
        if (dsProduto == null){
            this.iteratorR  = aba.rowIterator();
            dsProduto = buscarValorAbaixoDoTexto("Texto breve de material", HSSFCell.CELL_TYPE_STRING);
        }
        omproduto.setDsProduto(dsProduto.toString());
        omproduto.setOmUsrByIdUsrrevisao(IdwFacade.getInstancia().getConfiguracaoAtual().getOmUsrimpprog());
        omproduto.setTpProduto((byte) 0); // produto final
        omproduto.setTpProducao(BigDecimal.ZERO);
        omproduto.setRevisao(1l);

        // Obtem os indices das colunas necessarias da planilha
        iColunaNComponente = obtemIndiceColunaPara("Nº componente");
        
        if (iColunaNComponente < 0){
            iColunaNComponente = obtemIndiceColunaPara("Componente");
            identificacaoInicioDosDados = "Componente";
        }
        if (iColunaNComponente < 0){
            iColunaNComponente = obtemIndiceColunaPara("Componente de lista técnica");
            identificacaoInicioDosDados = "Componente de lista técnica";
        }
        
        
        iColunaNiv = obtemIndiceColunaPara("Nív");
        // Se nao encontrar a string Niv, procurar a string Nivel
        if (iColunaNiv == -1){
            iColunaNiv = obtemIndiceColunaPara("Nivel");
        }
        if (iColunaNiv == -1 ){
            iColunaNiv = obtemIndiceColunaPara("Nível");
        }
        
        iColunaQtd = obtemIndiceColunaPara("Qtd.(UMC)");
        // Se nao encontrar a string Qtd. (UMC) procurar por Qtde.
        if (iColunaQtd == -1){
            iColunaQtd = obtemIndiceColunaPara("Qtde.");
        }
        if (iColunaQtd == -1) {
            iColunaQtd = obtemIndiceColunaPara("Quantidade do componente");
        }
        if (iColunaQtd == -1) {
            iColunaQtd = obtemIndiceColunaPara("Unit/Total");
        }
        
        iColunaTextoBreve = obtemIndiceColunaPara("Texto breve objeto");
        if (iColunaTextoBreve == -1){
            iColunaTextoBreve = obtemIndiceColunaPara("Texto breve de material");
        }
         
        if (iColunaTextoBreve == -1){
            iColunaTextoBreve = obtemIndiceColunaPara("Texto breve material");
        }

        // Obtem os subprodutos de forma recursiva
        this.iteratorR  = aba.rowIterator();
        buscarValorAEsquerdaParaTexto(identificacaoInicioDosDados); // Localiza a linha que possue a string "Nº componente"
        obtemEstruturaRecursivamente(omproduto, 1, true);

        // Prepara retorno
        ProdutoDTO produtodto = new ProdutoDTO();
        produtodto.setProduto(omproduto);
        
        List<ProdutoDTO> retorno = new ArrayList<>();
        retorno.add(produtodto);
        return retorno;
    }


    // Metodo usado para transformar HSSFRow no PlanilhaEstruturaProdutoDTO
    private PlanilhaEstruturaProdutoDTO getLinhaDaPlanilha(HSSFRow linha){
        PlanilhaEstruturaProdutoDTO linhaPlanilhaRetorno = new PlanilhaEstruturaProdutoDTO();

        Iterator iteratorC = linha.cellIterator();
        int coluna = 0;
        while (iteratorC.hasNext()) {
            HSSFCell celula = (HSSFCell) iteratorC.next();

            // Obtem o indice da coluna
            coluna = celula.getColumnIndex();

            // Verifica qual a coluna a ser importada
            if (coluna == iColunaNComponente){
                // Avalia se o conteudo é string
                if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    HSSFRichTextString hss = celula.getRichStringCellValue();
                    linhaPlanilhaRetorno.setNroComponente(hss.getString());
                } else if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                    // Se o conteudo for numerico
                    linhaPlanilhaRetorno.setNroComponente(String.valueOf(celula.getNumericCellValue()));
                } //else
                    // TODO O que fazer quando o conteudo da celula nao for acessivel
            } else if (coluna == iColunaNiv){
                // Avalia se o conteudo é string
                if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    HSSFRichTextString hss = celula.getRichStringCellValue();
                    String nivel = hss.getString().replace(".", "").trim();
                    linhaPlanilhaRetorno.setNiv(Integer.parseInt(nivel));
                } else if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                    // Se o conteudo for numerico
                    linhaPlanilhaRetorno.setNiv((int)celula.getNumericCellValue());
                } //else
                    // TODO O que fazer quando o conteudo da celula nao for acessivel
            } else if (coluna == iColunaQtd){
                // Avalia se o conteudo é string
                if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    HSSFRichTextString hss = celula.getRichStringCellValue();
                    String quant = hss.getString();
                    if (quant.contains("/")){
                        int i = quant.lastIndexOf("/");
                        quant = quant.substring(i+1);
                    }
                    if (quant.contains(",")){
                         int i = quant.lastIndexOf(",");
                         quant = quant.substring(0, i) + "." + quant.substring(i+1);
                    };
                    
                   
                    linhaPlanilhaRetorno.setQtd(Double.parseDouble(quant));
                } else if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                    // Se o conteudo for numerico
                    linhaPlanilhaRetorno.setQtd(celula.getNumericCellValue());
                } //else
                    // TODO O que fazer quando o conteudo da celula nao for acessivel
            } else if (coluna == iColunaTextoBreve){
                // Avalia se o conteudo é string
                if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                    HSSFRichTextString hss = celula.getRichStringCellValue();
                    linhaPlanilhaRetorno.setTextoBreveObjeto(hss.getString());
                } else if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                    // Se o conteudo for numerico
                    linhaPlanilhaRetorno.setTextoBreveObjeto(String.valueOf(celula.getNumericCellValue()));
                } //else
                    // TODO O que fazer quando o conteudo da celula nao for acessivel
            }
        }

        return linhaPlanilhaRetorno;
    }
    
    // Metodo que obtem recursivamente a estrutura dos produtos
    private void obtemEstruturaRecursivamente(OmProduto omproduto, int nivel, boolean isAtualizarLinha){
        // Varre as linhas da planilha
        OmProduto omprodutoMP = null; // quarda o produto do nivel imediatamente anterior
        while (this.isFinalPlanilha == false){

            // Se for necessario atualizar a linha
            if (isAtualizarLinha == true){
                this.isFinalPlanilha = !this.iteratorR.hasNext();
                if (this.isFinalPlanilha == true)
                    break;

                HSSFRow linha = (HSSFRow) iteratorR.next();

                // verifica se a linha contem informacao
                if(linha != null) {
                    // Obtem a linha da planilha que será tratada
                    linhaPlanilha = getLinhaDaPlanilha(linha);
                } // fim do linha != null
            }

            // Se a estrutura for para o nivel requerente
            if (linhaPlanilha != null && linhaPlanilha.getNiv() == nivel) {
                // Guarda o produto da linha avaliada
                omprodutoMP = linhaPlanilha.getOmProduto(omproduto);

                // Inicializa o pojo da estrutura
                OmProcomest omprocomest = new OmProcomest();
                omprocomest.setIdProcomest(null);
                omprocomest.setConjunto(null);
                omprocomest.setOmProdutoByIdProduto(null);
                omprocomest.setOmProdutoByIdProdutomp(omprodutoMP);
                omprocomest.setQtUsada(new BigDecimal(linhaPlanilha.getQtd()));
                omprocomest.setTpProcomest(null); // A Rn irá pesquisar o cadastro do produto e descobrir o valor para esse campo

                omproduto.getOmProcomestsForIdProduto().add(omprocomest);

                isAtualizarLinha = true;
            } else {
                // Se voltou para um nivel anterior, sai da recursividade
                if (linhaPlanilha.getNiv() < nivel) {
                    break;
                }

                // Se nao for o mesmo nivel, entao eh a estrutura do omprodutoAnterior
                obtemEstruturaRecursivamente(omprodutoMP, linhaPlanilha.getNiv(), false);

                // Quando retornar de obtemEstruturarecursivamente a linha do iteratorR deve ser reavaliada, se existir
                // pois a linha atual possivelmente retornou para um nivel anterior ou terminor de ler a planilha
                isAtualizarLinha = false;
            }
        } // fim do while
    }

    // Determina qual a coluna que possui o titulo procurado
    private int obtemIndiceColunaPara(String texto){
        int retorno = -1;

        // Varre as linhas da planilha
        boolean isEncontrouTexto = false;
        Iterator iteratorDesdeOInicio = aba.rowIterator();
        while (iteratorDesdeOInicio.hasNext()) {
            HSSFRow linha = (HSSFRow) iteratorDesdeOInicio.next();

            // verifica se a linha contem informacao
            if(linha != null) {
                // Varre as colunas da planilha
                Iterator iteratorC = linha.cellIterator();
                while (iteratorC.hasNext()){
                    HSSFCell celula = (HSSFCell) iteratorC.next();
                    // Verifica o tipo da celula para poder obter o valor corretamente
                    if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_STRING){
                        HSSFRichTextString hss = celula.getRichStringCellValue();
                        // Verifica se o conteudo é igual ao valor procurado
                        if (isEncontrouTexto == false && hss.getString().equals(texto)){
                            retorno = celula.getColumnIndex();
                            isEncontrouTexto = true;
                            break;
                        }
                    }
                }
                if (isEncontrouTexto == true)
                    break;
            }
        }
        return retorno;
    }

    // classe representando uma linha da planilha, usada apenas internamente
    private class PlanilhaEstruturaProdutoDTO{
        private String nroComponente = null;
        private String textoBreveObjeto = null;
        private int niv = 0;
        private double qtd = 0d;
        private String matSub = null;
        private String tMat = null;
        private String um = null;

        public String getMatSub() {
            return matSub;
        }

        public void setMatSub(String matSub) {
            this.matSub = matSub;
        }

        public int getNiv() {
            return niv;
        }

        public void setNiv(int niv) {
            this.niv = niv;
        }

        public String getNroComponente() {
            return nroComponente;
        }

        public void setNroComponente(String nroComponente) {
            this.nroComponente = nroComponente;
        }

        public double getQtd() {
            return qtd;
        }

        public void setQtd(double qtd) {
            this.qtd = qtd;
        }

        public String gettMat() {
            return tMat;
        }

        public void settMat(String tMat) {
            this.tMat = tMat;
        }

        public String getTextoBreveObjeto() {
            return textoBreveObjeto;
        }

        public void setTextoBreveObjeto(String textoBreveObjeto) {
            this.textoBreveObjeto = textoBreveObjeto;
        }

        public String getUm() {
            return um;
        }

        public void setUm(String um) {
            this.um = um;
        }

        public OmProduto getOmProduto(OmProduto omproduto){

            OmProduto omprodutoMP = new OmProduto();
            omprodutoMP.setCdProduto(getNroComponente());
            omprodutoMP.setDepara(getNroComponente());
            omprodutoMP.setDsComplemento(gettMat());
            omprodutoMP.setDsProduto(getTextoBreveObjeto());
            omprodutoMP.setDtRevisao(null);
            omprodutoMP.setDtStativo(null);
            omprodutoMP.setHrLeadtimeentrada(null);
            omprodutoMP.setHrLeadtimesaida(null);
            omprodutoMP.setIdProduto(0);
            omprodutoMP.setIndPerdaproducao(null);
            omprodutoMP.setMinValposalim(null);
            omprodutoMP.setOmCc(null);
            omprodutoMP.setOmFor(null);
            omprodutoMP.setOmProdutoByIdProdutoagru(null);
            omprodutoMP.setOmProgrp(null);
            omprodutoMP.setOmUsrByIdUsrrevisao(IdwFacade.getInstancia().getConfiguracaoAtual().getOmUsrimpprog());
            omprodutoMP.setOmUsrByIdUsrstativo(null);
            omprodutoMP.setPpCliente(omproduto.getPpCliente());
            omprodutoMP.setRevisao(1l);
            omprodutoMP.setStAtivo((byte) 1);
            omprodutoMP.setTpProducao(BigDecimal.ZERO); // producao normal
            omprodutoMP.setTpProduto((byte) 1); // componente

            if (omprodutoMP.getCdProduto().endsWith("IAC") == true){
                omprodutoMP.setTpProduto((byte) 3); //semi-produto
            }
            return omprodutoMP;
        }
    }
}
