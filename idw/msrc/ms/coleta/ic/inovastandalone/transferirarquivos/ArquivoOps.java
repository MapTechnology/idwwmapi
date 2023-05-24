package ms.coleta.ic.inovastandalone.transferirarquivos;

import java.math.BigDecimal;
import java.util.List;

import ms.coleta.dto.SessaoOPDTO;
import idw.model.pojos.DwConsolciplog;
import idw.model.pojos.DwFolha;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DadosProdutoSADTO;
import ms.util.ConversaoTipos;

/*

[id]
dthriplanejado=yyyy-mm-dd hh:mm:ss
producaoplanejada=999999
cdproduto=xxxxxxxxxxx
ciclopadrao=999
isaceitarnc=true

[seriais]
AAAAAAAAAAAAAAAAAAAAAAA
BBBBBBBBBBBBBBBBBBBBBBB
CCCCCCCCCCCCCCCCCCCCCCC

 */

public class ArquivoOps{

	private PpCp ppcp;
	private DwFolha dwFolha;
	private boolean isAceitaNC;
	private boolean isFinalSerie;
	private double cicloPadrao;
	private double cicloTimeout;
	private double cicloMinimo;
	private double qtdPcsPorCiclo;
	private int pacoteCiclo;
	private int fatorContagem;
	private Long qtdeRef;
	private Long qtdePro;
	private Integer qtdeCiclos;
	private Integer qtdProdutos;
	private DwConsolciplog dwConsolciplog;
	private IdwLogger log;
	List<DadosProdutoSADTO> listaProdutos;
	List<DadosProdutoSADTO> listaProdutosHoraTurno;
	
	private SessaoOPDTO sessaoOP;

	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		
		String cdproduto = null;
		BigDecimal producaoPlanejada = BigDecimal.ZERO;

		for (PpCpproduto p : ppcp.getPpCpprodutos()) {
			if (p.getPcsProducaoplanejada() != null)
				producaoPlanejada.add(p.getPcsProducaoplanejada());
			if (p.getOmProduto() != null && cdproduto == null)
					cdproduto = p.getOmProduto().getCdProduto();
		}
		
		if(cdproduto == null)
			cdproduto = "desconhecido";
		
		arquivoInovaSA.addLineToBeWritten("[DADOSOP]");
		arquivoInovaSA.addLineToBeWritten("DTHR_IPLANEJADO=" + DataHoraRN.dateToString(ppcp.getDthrInicio(), "yyyy.MM.dd-HH:mm:ss"));
		arquivoInovaSA.addLineToBeWritten("PRODUCAO_PLANEJADA=" + producaoPlanejada);
		arquivoInovaSA.addLineToBeWritten("CD_PRODUTO=" + cdproduto);
		arquivoInovaSA.addLineToBeWritten("CICLO_PADRAO=" + cicloPadrao*1000);
		arquivoInovaSA.addLineToBeWritten("CICLO_MINIMO=" + cicloMinimo*1000);
		arquivoInovaSA.addLineToBeWritten("QTD_POR_CICLO=" + qtdPcsPorCiclo);
		arquivoInovaSA.addLineToBeWritten("PACOTE_CICLO=" + pacoteCiclo);
		arquivoInovaSA.addLineToBeWritten("FATOR_CONTAGEM=" + fatorContagem);
		arquivoInovaSA.addLineToBeWritten("CICLO_TIMEOUT=" + cicloTimeout);
		arquivoInovaSA.addLineToBeWritten("IS_ACEITAR_NC=" + isAceitaNC);
		arquivoInovaSA.addLineToBeWritten("IS_FINAL_SERIE=" + isFinalSerie);
		
		//Variaveis necessarias para o CIP
		arquivoInovaSA.addLineToBeWritten("CD_FOLHA=" + dwFolha.getCdFolha());
		arquivoInovaSA.addLineToBeWritten("ID_FOLHA=" + dwFolha.getIdFolha());
		arquivoInovaSA.addLineToBeWritten("TIMEOUT_CIP=" + dwFolha.getSegSetup());
		
		arquivoInovaSA.addLineToBeWritten("QTD_PRODUTOS=" + qtdProdutos);
		
		if(listaProdutos != null) {
			int i=1;
			for(DadosProdutoSADTO produto : listaProdutos){
				if( produto != null && produto.getCdProduto() != null) {
					
					long qtdPorCiclo = 1l;
					long cavidadesTotal = 1l;
					if(produto.getQtAtiva() != null)
						qtdPorCiclo = produto.getQtAtiva().longValue();
					if(produto.getQtTotal() != null)
						cavidadesTotal = produto.getQtTotal().longValue();
					
					arquivoInovaSA.addLineToBeWritten("[PRODUTO" + i + "]");
					arquivoInovaSA.addLineToBeWritten("CD=" + produto.getCdProduto());
					if(produto.getIdredzproduto() != null)
						arquivoInovaSA.addLineToBeWritten("IDREDZ=" + ConversaoTipos.converterParaChar(produto.getIdredzproduto()));
					arquivoInovaSA.addLineToBeWritten("QTDPORCICLO=" + qtdPorCiclo);
					arquivoInovaSA.addLineToBeWritten("CAVTOTAL=" + cavidadesTotal);
					
					i++;
				}
			}
		}
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;

	}


	public boolean gerarArquivoStatus(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten("[DADOSOP]");
		arquivoInovaSA.addLineToBeWritten("CD_OP=" + sessaoOP.getNrop());
		
		arquivoInovaSA.addLineToBeWritten("DTHR_IPLANEJADO=" + sessaoOP.getDthrIOp());
		arquivoInovaSA.addLineToBeWritten("PRODUCAO_PLANEJADA=" + sessaoOP.getProducaoPlanejada());
		arquivoInovaSA.addLineToBeWritten("CD_PRODUTO=" + sessaoOP.getCdproduto());
		arquivoInovaSA.addLineToBeWritten("CICLO_PADRAO=" + sessaoOP.getCicloPadrao()*1000);
		arquivoInovaSA.addLineToBeWritten("CICLO_MINIMO=" + sessaoOP.getCicloMinimo()*1000);
		arquivoInovaSA.addLineToBeWritten("QTD_POR_CICLO=" + sessaoOP.getQtdPcsPorCiclo());
		arquivoInovaSA.addLineToBeWritten("FATOR_CONTAGEM=" + sessaoOP.getQtFatorContagem());
		arquivoInovaSA.addLineToBeWritten("PACOTE_CICLO=" + sessaoOP.getQtPacoteCiclo());
		arquivoInovaSA.addLineToBeWritten("CICLO_TIMEOUT=" + sessaoOP.getCicloTimeout());
		arquivoInovaSA.addLineToBeWritten("QTD_CICLOS=" + sessaoOP.getQtdeCiclos() );
		arquivoInovaSA.addLineToBeWritten("QTD_PROD=" + (sessaoOP.getQtdePro() - sessaoOP.getQtdeRef()));
		arquivoInovaSA.addLineToBeWritten("QTD_PRODUTOS=" + sessaoOP.getQtdProdutos());
		arquivoInovaSA.addLineToBeWritten("IS_FINAL_SERIE=" + sessaoOP.isFinalSerie());
		
		//Variaveis necessarias para o CIP
		arquivoInovaSA.addLineToBeWritten("CD_FOLHA=" + sessaoOP.getCdFolha());
		arquivoInovaSA.addLineToBeWritten("ID_FOLHA=" + sessaoOP.getIdFolha());
		arquivoInovaSA.addLineToBeWritten("TIMEOUT_CIP=" + sessaoOP.getTempoSetup());
		arquivoInovaSA.addLineToBeWritten("STATUS_CIP=" + sessaoOP.getCipStatus());//0=NAO_INICIADO, 1=EM_ANDAMENTO, 2=FINALIZADO
		if(dwConsolciplog != null && dwConsolciplog.getDthrIcip() != null) {
			arquivoInovaSA.addLineToBeWritten("DTHR_INI_CIP=" + DataHoraRN.dateToString(sessaoOP.getDthrIOp(), "dd/MM/yyy HH:mm:ss.SSS") );//DD/MM/AAAA HH:mm:SS.sss
		}
		
		if(sessaoOP.getListaProdutos() != null) {
			int i=1;
			for(DadosProdutoSADTO produto : sessaoOP.getListaProdutos()){
				if( produto != null && produto.getCdProduto() != null) {
					arquivoInovaSA.addLineToBeWritten("[PRODUTO" + i + "]");
					arquivoInovaSA.addLineToBeWritten("CD=" + produto.getCdProduto());
					if(produto.getIdredzproduto() != null)
						arquivoInovaSA.addLineToBeWritten("IDREDZ=" + (char)(produto.getIdredzproduto() & 0xFF));
					if(produto.getQtAtiva() != null)
						arquivoInovaSA.addLineToBeWritten("QTDPORCICLO=" + produto.getQtAtiva().longValue());
					if(produto.getQtTotal() != null)
						arquivoInovaSA.addLineToBeWritten("CAVTOTAL=" + produto.getQtTotal().longValue());
					arquivoInovaSA.addLineToBeWritten("QTDPRODLIQ=" + produto.getPcsProducaobruta().subtract(produto.getPcsProducaorefugada()));
					i++;
				}
			}
		}
			
		if(sessaoOP.getListaProdutosHoraTurno() != null) {
			int i=1;
			for(DadosProdutoSADTO produto : sessaoOP.getListaProdutosHoraTurno()){
				if( produto != null && produto.getCdProduto() != null) {
					arquivoInovaSA.addLineToBeWritten("[PRODUTOHORATURNO" + i + "]");
					arquivoInovaSA.addLineToBeWritten("CD=" + produto.getCdProduto());
					arquivoInovaSA.addLineToBeWritten("QTDPORCICLO=" + produto.getQtAtiva().longValue());
					arquivoInovaSA.addLineToBeWritten("QTDPRODLIQ=" + produto.getPcsProducaobruta().subtract(produto.getPcsProducaorefugada()).longValue());
					i++;
				}
			}
		}
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}
	
	public PpCp getPpcp() {
		return ppcp;
	}

	public void setPpcp(PpCp ppcp) {
		this.ppcp = ppcp;
	}

	public boolean isAceitaNC() {
		return isAceitaNC;
	}

	public void setAceitaNC(boolean isAceitaNC) {
		this.isAceitaNC = isAceitaNC;
	}

	public double getCicloPadrao() {
		return cicloPadrao;
	}

	public void setCicloPadrao(double cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}

	public Long getQtdeRef() {
		return qtdeRef;
	}

	public void setQtdeRef(Long qtdeRef) {
		this.qtdeRef = qtdeRef;
	}

	public Long getQtdePro() {
		return qtdePro;
	}

	public void setQtdePro(Long qtdePro) {
		this.qtdePro = qtdePro;
	}

	public Integer getQtdeCiclos() {
		return qtdeCiclos;
	}

	public void setQtdeCiclos(Integer qtdeCiclos) {
		this.qtdeCiclos = qtdeCiclos;
	}

	public double getQtdPcsPorCiclo() {
		return qtdPcsPorCiclo;
	}

	public void setQtdPcsPorCiclo(double qtdPcsPorCiclo) {
		this.qtdPcsPorCiclo = qtdPcsPorCiclo;
	}

	public double getCicloTimeout() {
		return cicloTimeout;
	}

	public void setCicloTimeout(double cicloTimeout) {
		this.cicloTimeout = cicloTimeout;
	}

	public Integer getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(Integer qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

	public List<DadosProdutoSADTO> getListaProdutos() {
		return this.listaProdutos;
	}
	
	public void setListaProdutos(List<DadosProdutoSADTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public List<DadosProdutoSADTO> getListaProdutosHoraTurno() {
		return this.listaProdutosHoraTurno;
	}
	
	public void setListaProdutosHoraTurno(List<DadosProdutoSADTO> listaProdutosHoraTurno) {
		this.listaProdutosHoraTurno = listaProdutosHoraTurno;
	}

	public double getCicloMinimo() {
		return cicloMinimo;
	}

	public void setCicloMinimo(double cicloMinimo) {
		this.cicloMinimo = cicloMinimo;
	}

	public DwFolha getDwFolha() {
		return dwFolha;
	}

	public void setDwFolha(DwFolha dwFolha) {
		this.dwFolha = dwFolha;
	}

	public DwConsolciplog getDwConsolciplog() {
		return dwConsolciplog;
	}

	public void setDwConsolciplog(DwConsolciplog dwConsolciplog) {
		this.dwConsolciplog = dwConsolciplog;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

	public SessaoOPDTO getSessaoOP() {
		return sessaoOP;
	}

	public void setSessaoOP(SessaoOPDTO sessaoOP) {
		this.sessaoOP = sessaoOP;
	}


	public int getFatorContagem() {
		return fatorContagem;
	}


	public void setFatorContagem(int fatorContagem) {
		this.fatorContagem = fatorContagem;
	}


	public int getPacoteCiclo() {
		return pacoteCiclo;
	}


	public void setPacoteCiclo(int pacoteCiclo) {
		this.pacoteCiclo = pacoteCiclo;
	}


	public boolean isFinalSerie() {
		return isFinalSerie;
	}


	public void setFinalSerie(boolean isFinalSerie) {
		this.isFinalSerie = isFinalSerie;
	}

}
