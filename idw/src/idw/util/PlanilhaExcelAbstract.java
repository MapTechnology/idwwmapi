/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idw.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author alessandre
 */
public class PlanilhaExcelAbstract {
    protected File file;
    protected FileInputStream arquivo;
    protected HSSFWorkbook planilha;
    protected HSSFSheet aba;
    
    private int iAbaAtual = 0;

    protected Iterator iteratorR;
    protected HSSFRow linha;

    public PlanilhaExcelAbstract(File file) throws FileNotFoundException, IOException{
        this.file = file;
        this.arquivo = new FileInputStream(file.getAbsoluteFile());
        this.planilha = new HSSFWorkbook(arquivo);
    }

    public void vaiPrimeiraAba(){
        this.aba = planilha.getSheetAt(0);
        this.iteratorR  = aba.rowIterator();
        this.iAbaAtual = 0;
    }
    
    public boolean vaiProximaAba(){
        boolean isExisteProximaAba = false;
        
        if ((this.iAbaAtual + 1) < this.planilha.getNumberOfSheets()) {
            isExisteProximaAba = true;
            this.iAbaAtual++;
            this.aba = this.planilha.getSheetAt(this.iAbaAtual);
            this.iteratorR  = aba.rowIterator();
        }
        
        return isExisteProximaAba;
    }
    
    public String getNomeArquivo(){
        return file.getName();
    }
    
    protected int buscarColunaParaOTexto(String texto){
        // Varre da 1a linha ate encontrar ou terminarem as linhas
        int retorno;

        // vai para a primeira linha da aba
        this.iteratorR  = aba.rowIterator();
        
        linha = (HSSFRow) iteratorR.next();
        retorno = buscarColunaParaOTexto(this.linha, texto);

        return retorno;
    }
    
    // buscar numero da coluna que contem o texto solicitado
    protected int buscarColunaParaOTexto(HSSFRow linhaParametro, String texto) {
        int retorno = -1;
        boolean isPrimeiraVez = true; // usado para evitar de ler a linha na primeira vez

        // Varre as linhas da planilha
        while (iteratorR.hasNext()) {
            if (isPrimeiraVez == true)
                isPrimeiraVez = false;
            else
                linhaParametro = (HSSFRow) iteratorR.next();

            // verifica se a linha contem informacao
            if(linhaParametro != null) {
                // Varre as colunas da planilha
                Iterator iteratorC = linhaParametro.cellIterator();
                while (iteratorC.hasNext()){
                    HSSFCell celula = (HSSFCell) iteratorC.next();
                    // Verifica o tipo da celula para poder obter o valor corretamente
                    if (celula != null && (celula.getCellType() == HSSFCell.CELL_TYPE_STRING || celula.getCellType() == HSSFCell.CELL_TYPE_STRING) ){
                        HSSFRichTextString hss = celula.getRichStringCellValue();
                        // Verifica se o conteudo é igual ao valor procurado
                        if (hss.getString().equals(texto)){
                            retorno = celula.getColumnIndex();
                            break;
                        }
                    }
                }
                if (retorno != -1) // se encontrou nao verrer a proxima linha
                    break;
            }
        }
        return retorno;
    }
    
    // buscar numero da Linha que contem o texto solicitado
    protected int buscarLinhaParaTexto(String texto) {
        int retorno = -1;
        boolean isPrimeiraVez = true; // usado para evitar de ler a linha na primeira vez
        Iterator iterator = aba.rowIterator();

        // Varre as linhas da planilha
        while (iterator.hasNext()) {
            if (isPrimeiraVez == true) {
                isPrimeiraVez = false;
            } else {
                linha = (HSSFRow) iterator.next();
            }

            // verifica se a linha contem informacao
            if (linha != null) {
                // Varre as colunas da planilha
                Iterator iteratorC = linha.cellIterator();
                while (iteratorC.hasNext()) {
                    HSSFCell celula = (HSSFCell) iteratorC.next();
                    // Verifica o tipo da celula para poder obter o valor corretamente
                    if (celula != null && (celula.getCellType() == HSSFCell.CELL_TYPE_STRING || celula.getCellType() == HSSFCell.CELL_TYPE_STRING)) {
                        HSSFRichTextString hss = celula.getRichStringCellValue();
                        // Verifica se o conteudo é igual ao valor procurado
                        if (hss.getString().equals(texto)) {
                            retorno = celula.getRowIndex();
                            break;
                        }
                    }
                }
            }
            if (retorno != -1) // se encontrou nao verrer a proxima linha
            {
                break;
            }
        }
        return retorno;
    }

    // buscar numero da coluna que contem o texto solicitado
    protected int buscarColunaParaMaquina(String texto, int colunaReal) {
        int retorno = -1;
        boolean isPrimeiraVez = true; // usado para evitar de ler a linha na primeira vez
        Iterator iterator = aba.rowIterator();

        // Varre as linhas da planilha
        while (iterator.hasNext()) {
            if (isPrimeiraVez == true) {
                isPrimeiraVez = false;
            } else {
                linha = (HSSFRow) iterator.next();
            }

            // verifica se a linha contem informacao
            if (linha != null) {
                // Varre as colunas da planilha
                Iterator iteratorC = linha.cellIterator();
                while (iteratorC.hasNext()) {
                    HSSFCell celula = (HSSFCell) iteratorC.next();
                    // Verifica o tipo da celula para poder obter o valor corretamente
                    if (celula != null && (celula.getCellType() == HSSFCell.CELL_TYPE_STRING || celula.getCellType() == HSSFCell.CELL_TYPE_STRING)) {
                        HSSFRichTextString hss = celula.getRichStringCellValue();
                        // Verifica se o conteudo é igual ao valor procurado
                        if (hss.getString().equals(texto)) {
                            if (celula.getColumnIndex() >= colunaReal) {
                                retorno = celula.getColumnIndex();
                                break;
                            }
                        }
                    }
                }
                if (retorno != -1) // se encontrou nao verrer a proxima linha
                {
                    break;
                }
            }
        }
        return retorno;
    }
    
    // Vai para a primeira linha da aba corrente
    protected void vaiPrimeiraLinha(){
        this.iteratorR  = aba.rowIterator();
    }
    
    // Metodo usado para pesquisar nsa celulas de uma linha da planilha excel
    protected Object buscarValorAEsquerdaParaTexto(String texto) {
        Object retorno = null;

        // Varre as linhas da planilha
        boolean isEncontrouTexto = false;
        while (iteratorR.hasNext()) {
            linha = (HSSFRow) iteratorR.next();

            // verifica se a linha contem informacao
            if(linha != null) {
                // Varre as colunas da linha
                Iterator iteratorC = linha.cellIterator();
                while (iteratorC.hasNext()){
                    HSSFCell celula = (HSSFCell) iteratorC.next();
                    // Verifica o tipo da celula para poder obter o valor corretamente
                    if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_STRING){
                        HSSFRichTextString hss = celula.getRichStringCellValue();
                        // Verifica se o conteudo é igual ao valor procurado
                        System.out.println("planilha= [" + hss.getString() + "] = [" + texto + "]");
                        if (isEncontrouTexto == false && hss.getString().equals(texto)){
                            // Seta flag informando que o valor foi encontrado assim, o proximo valor a ser procurado eh o conteudo
                            isEncontrouTexto = true;
                        } else if (isEncontrouTexto == true){
                            retorno = hss.getString();
                            break;
                        }
                    }
                }
                if (isEncontrouTexto == true && retorno != null)
                    break;
            }
        }
        return retorno;
    }

    protected Object buscarValorParaColuna(int coluna, int tipoColunaEsperado){
        Object retorno = null;
        if (linha != null) {
            // Varre as colunas da linha
            Iterator iteratorC = linha.cellIterator();
            while (iteratorC.hasNext()) {
                HSSFCell celula = (HSSFCell) iteratorC.next();
                
                // Se for a coluna desejada, entao obter o valor da mesma
                if (celula != null && celula.getColumnIndex() == coluna) {
                    // Verificar se eh um valor string
                    if (celula.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        HSSFRichTextString hss = celula.getRichStringCellValue();
                        retorno = hss.getString();
                        break;
                    }
                    if (celula.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                        if (tipoColunaEsperado == HSSFCell.CELL_TYPE_NUMERIC)
                            retorno = celula.getNumericCellValue();
                        else
                            retorno = celula.getDateCellValue();
                        break;
                    }
                }
            }
        }

        return retorno;
    }
    
    
    // Metodo usado para pesquisar nsa celulas de uma linha da planilha excel
    protected Object buscarValorAbaixoDoTexto(String texto, int tipoColuna) {
        Object retorno = null;

        // Varre as linhas da planilha
        boolean isEncontrouTexto = false;
        int iColunaEncontrada = -1;
        while (iteratorR.hasNext()) {
            linha = (HSSFRow) iteratorR.next();

            // verifica se a linha contem informacao
            if(linha != null) {

                // Varifica se ja encontrou o valor
                if (iColunaEncontrada != -1) {
                    retorno = buscarValorParaColuna(iColunaEncontrada, tipoColuna);
                    if (retorno != null)
                        break;
                } else {
                    // Varre as colunas da linha
                    Iterator iteratorC = linha.cellIterator();
                    while (iteratorC.hasNext()){
                        HSSFCell celula = (HSSFCell) iteratorC.next();
                        // Verifica o tipo da celula para poder obter o valor corretamente
                        if (celula != null && celula.getCellType() == HSSFCell.CELL_TYPE_STRING){
                            HSSFRichTextString hss = celula.getRichStringCellValue();
                            // Verifica se o conteudo é igual ao valor procurado
                            if (isEncontrouTexto == false && hss.getString().equals(texto)){
                                // Seta flag informando que o valor foi encontrado assim, o proximo valor a ser procurado eh o conteudo
                                isEncontrouTexto = true;
                                iColunaEncontrada = celula.getColumnIndex();
                                break;
                            }
                        }
                    }
                }
            }
        }
        return retorno;
    }

}
