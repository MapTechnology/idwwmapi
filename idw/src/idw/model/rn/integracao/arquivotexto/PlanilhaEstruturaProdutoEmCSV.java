/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idw.model.rn.integracao.arquivotexto;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;
import idw.util.ArquivosDiretorios;
import idw.util.UtilsString;
import idw.webservices.dto.ProdutoDTO;
import ms.util.ConversaoTipos;

/**
 *
 * @author Alessandre
 */
public class PlanilhaEstruturaProdutoEmCSV implements IPlanilhaEstruturaProduto {

    private final File arquivo;

    public PlanilhaEstruturaProdutoEmCSV(File file) throws FileNotFoundException, IOException {
        super();
        this.arquivo = file;
    }
    
    @Override
    public List<ProdutoDTO> obtemEstruturaProdutoD() {
        List<ProdutoDTO> retorno = new ArrayList<ProdutoDTO>();

        OmProduto omproduto = null;

        List<String> listabr = getVariosArquivosSeparadosPeloNivel(0, arquivo);
        
        for (String arq : listabr) {
        	
        	int resultado = 0;
        	BufferedReader br = null;
            try {
            	br = new BufferedReader(new FileReader(arq));
				omproduto = obtemOmProdutoRecursivamente(br, null, 0);
			} catch (IOException e) {
				resultado = -1;
			} finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException ex) {

	                }
	            }
	            ArquivosDiretorios.delete(arq);
	            
			}

            ProdutoDTO dto = new ProdutoDTO();
            dto.setResultadoEvento(resultado);
            dto.setProduto(omproduto);
            retorno.add(dto);
        }

        return retorno;
    }

    // Metodo quebra em varios buffers de acordo com o nivel. Isso eh necessario pois no arquivo podem ter varios outros arquivos
    private List<String> getVariosArquivosSeparadosPeloNivel(int nivelEsperado, File arquivo) {
    	List<String> retorno = new ArrayList<>();
    	BufferedReader br = null;
    	try {
			br = new BufferedReader(new FileReader(arquivo));
			String arqNovo = null;
			do {
				String linha = br.readLine();
				
				if (linha == null) {
					// Se arqNovo tem valor entao inicializar o bufferedReader com o arquivo criado
		        	if (arqNovo != null) {
		        		retorno.add(arqNovo);
		        	}
		        	break;
				}
				
		        List<String> campos = UtilsString.quebrarStringEmVetor(linha, ";");

		        String cdProduto = UtilsString.removeCaracteresDeCampos(campos.get(0));
		        String nivel = UtilsString.removeCaracteresDeCampos(campos.get(2));

		        if (ConversaoTipos.converteParaInt(nivel) == nivelEsperado) {
		        	// Se arqNovo tem valor entao inicializar o bufferedReader com o arquivo criado
		        	if (arqNovo != null) {
		        		retorno.add(arqNovo);
		        	}
		        	
		        	
		        	// Cria um novo arquivo
		        	arqNovo = cdProduto;
		        	ArquivosDiretorios.delete(arqNovo);
		        	
		        }
		        linha += "\n";
				Files.write(Paths.get(arqNovo), linha.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
				
			} while (true);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {

                }
            }
		}
    	return retorno;
    }


    /* Metodo le o arquivo e monta OmProduto recursivamente
     */
    private OmProduto obtemOmProdutoRecursivamente(BufferedReader br, OmProduto omprodutopai, int nivelEsperado) throws IOException {

        String linha = br.readLine();

        // Se a linha esta nula é pq chegou ao final do arquivo
        if (linha == null) {
            return omprodutopai;
        }

        List<String> campos = UtilsString.quebrarStringEmVetor(linha, ";");

        String cdProduto = UtilsString.removeCaracteresDeCampos(campos.get(0));
        String dsProduto = UtilsString.removeCaracteresDeCampos(campos.get(1));
        String nivel = UtilsString.removeCaracteresDeCampos(campos.get(2));
        String qtdeUsada = UtilsString.removeCaracteresDeCampos(campos.get(3));
        String tpProduto = UtilsString.removeCaracteresDeCampos(campos.get(4)); // 0-PA, 1=mp, 2=fantasma, 3=semi
        // Linhas abaixo comentadas pois os dados nao sao usados na importacao
        //String unidade = UtilsString.removeCaracteresDeCampos(campos.get(5));
        //String tpSemi = UtilsString.removeCaracteresDeCampos(campos.get(6));
        //String tpOrigem = UtilsString.removeCaracteresDeCampos(campos.get(7));
        String custo = UtilsString.removeCaracteresDeCampos(campos.get(8));

        
        OmProduto retorno = new OmProduto();
        OmProduto omprodutofilho = null;

        retorno.setCdProduto(cdProduto);
        retorno.setDsProduto(dsProduto);
        retorno.setTpProduto(ConversaoTipos.converterParaByte(tpProduto));
        retorno.setVlCustounit(ConversaoTipos.converteHoraParaBigDecimal(custo));
        retorno.setOmUsrByIdUsrrevisao(IdwFacade.getInstancia().getConfiguracaoAtual().getOmUsrimpprog());
        retorno.setOmUsrByIdUsrstativo(IdwFacade.getInstancia().getConfiguracaoAtual().getOmUsrimpprog());

        // Se a estrutura for para o nivel requerente
        if (omprodutopai != null && nivelEsperado == ConversaoTipos.converteParaInt(nivel)) {
            // Inicializa o pojo da estrutura
            OmProcomest omprocomest = new OmProcomest();
            omprocomest.setIdProcomest(null);
            omprocomest.setConjunto(null);
            omprocomest.setOmProdutoByIdProduto(null);
            omprocomest.setOmProdutoByIdProdutomp(retorno);
            omprocomest.setQtUsada(ConversaoTipos.converteParaBigDecimal(qtdeUsada));
            omprocomest.setTpProcomest(null); // A Rn irá pesquisar o cadastro do produto e descobrir o valor para esse campo

            omprodutopai.getOmProcomestsForIdProduto().add(omprocomest);
            
            omprodutofilho = obtemOmProdutoRecursivamente(br, retorno, nivelEsperado + 1);
            
            // Se omprodutofilho for o mesmo do retorno eh pq nao tem filho nenhum. Nesse caso limpa o filho pois ja esta no pai
            if (omprodutofilho == retorno)
            	omprodutofilho = null;

        } else if (omprodutopai == null) {
            // pai foi definido mais os niveis sao diferentes
            omprodutofilho = obtemOmProdutoRecursivamente(br, retorno, nivelEsperado + 1);
        }
        
        // Se o produto filho existir e nao tiver estrutura é pq eh o ultima folha do ramo da arvore
        if (omprodutopai != null && omprodutofilho != null && omprodutofilho.getOmProcomestsForIdProduto().isEmpty() ) {
                        
            // Inicializa o pojo da estrutura
            OmProcomest omprocomest = new OmProcomest();
            omprocomest.setIdProcomest(null);
            omprocomest.setConjunto(null);
            omprocomest.setOmProdutoByIdProduto(null);
            omprocomest.setOmProdutoByIdProdutomp(omprodutofilho);
            omprocomest.setQtUsada(ConversaoTipos.converteParaBigDecimal(qtdeUsada));
            omprocomest.setTpProcomest(null); // A Rn irá pesquisar o cadastro do produto e descobrir o valor para esse campo

            omprodutopai.getOmProcomestsForIdProduto().add(omprocomest);

            retorno = obtemOmProdutoRecursivamente(br, omprodutopai, nivelEsperado);
        }

        return retorno;

    }
}
