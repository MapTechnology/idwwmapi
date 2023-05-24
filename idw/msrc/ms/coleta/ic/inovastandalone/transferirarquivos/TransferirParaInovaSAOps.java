package ms.coleta.ic.inovastandalone.transferirarquivos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.excessoes.SemCicloPadraoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.rn.FolhaRN;
import idw.util.ArquivosDiretorios;
import idw.webservices.dto.DadosProdutoSADTO;
import ms.coleta.dto.SessaoUPDTO;

/*

[id]
dthriplanejado=yyyy-mm-dd hh:mm:ss
producaoplanejada=999999
cdproduto=xxxxxxxxxxx
ciclopadrao=999
isaceitarnc=true

 */
public class TransferirParaInovaSAOps extends TransferirParaInovaSAFactory{

	private PpCp ppcp;
	private OmPt ompt;
	private SessaoUPDTO sessaoUP;
	
	@Override
	public void criarArquivo() {
		if(ppcp == null || ompt == null)
			return;
		
		String urlConexao = msmsicup.getMsIc().getUrlConexao();

		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e) {
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/reg/op/";


		if (ppcp.getDwFolha() == null)
			return;

		String nrDoc = "";
		for (PpCpproduto ppcpproduto : ppcp.getPpCpprodutos()) {
			if(ppcpproduto.getNrDoc() != null) {
				nrDoc = ppcpproduto.getNrDoc();
				break;
			}
		}
		String fileName = ompt.getIdPt() + "-" + nrDoc;
		// Se o arquivo existir nao precisa criar denovo
		if(ArquivosDiretorios.isExisteArquivo(dir + fileName) == false) {

			FolhaRN frn = new FolhaRN();
			frn.setDaoSession(session);
			double cicloPadrao = 0d;
			try {
				cicloPadrao = frn.getCicloPadraoFromDwFolhacisOuDwFolha(ppcp.getDwFolha(), ompt).doubleValue();
			} catch (SemCicloPadraoException e) {
				cicloPadrao = 0d;
			}
			
			BigDecimal fatorContagem;
			try {
				fatorContagem = frn.getFatorContagemFromDwFolha(ppcp.getDwFolha(), ompt);
			} catch (SemPacoteOuFatorException e) {
				fatorContagem = BigDecimal.ZERO;
			}
			
			int pacoteCiclo = 0;
			try {
				pacoteCiclo = frn.getPacoteCicloFromDwFolha(ppcp.getDwFolha(), ompt);
			} catch (SemPacoteOuFatorException e) {
				pacoteCiclo = 0;
			}
			
			double qtdPcsPorCiclo = 1d;
			
			try{
				qtdPcsPorCiclo = frn.getPcsPorCicloAtivasFromDwFolha(ppcp.getDwFolha()).doubleValue();
			} catch(Exception e) {
				qtdPcsPorCiclo = 1d;
			}
			
			List<DadosProdutoSADTO> listaProdutos = null;
			try{
				listaProdutos = frn.getDadosDeProdutoDaOPStandAlone(ppcp.getIdCp(), ompt.getIdPt());
			} catch(Exception e) {
				listaProdutos = new ArrayList<DadosProdutoSADTO>();
			}
			
			double cicloTimeout = 0d;
			
			if(ppcp.getDwFolha() != null && ppcp.getDwFolha().getSegCiclotimeout() != null)
				cicloTimeout = ppcp.getDwFolha().getSegCiclotimeout().doubleValue();
			else
				cicloTimeout = 0d;
			
			double cicloMinimo = 0d;
			
			if(ppcp.getDwFolha() != null && ppcp.getDwFolha().getSegCiclominimo() != null)
				cicloMinimo = ppcp.getDwFolha().getSegCiclominimo().doubleValue();
			else
				cicloMinimo = 0d;
			
			boolean isFinalSerie = false;
			if(ppcp.getIsFinalserie() != null)
				isFinalSerie = ppcp.getIsFinalserie();

			boolean isAceitaNC = true;
			
			if (ppcp.getDwRota() != null && ppcp.getDwRota().getIsPassaadiante() != null)
				isAceitaNC = ppcp.getDwRota().getIsPassaadiante();

			// Se isAceitaNC = false entao verificar se o passo tem predecessora. Se nao tiver entao mudar isAceitaNC pra true, pois eh o 1o passo
			if (isAceitaNC == false) {
				for (DwRotapasso passo : ppcp.getDwRota().getDwRotapassos()) {
					if (passo.getDwFolha().getCdFolha().equals(ppcp.getDwFolha().getCdFolha())) {
						// Verificar se existe predecessora
						if (passo.getDwRpPredecessorasForIdRotapassoPai() == null || passo.getDwRpPredecessorasForIdRotapassoPai().size() <= 0) {
							isAceitaNC = true;
						}
					}
				}
			}
		
			log.info("Gerando arquivo em " + dir + fileName);
			
			ArquivoOps op = new ArquivoOps();
			op.setLog(log);
			op.setPpcp(ppcp);
			op.setDwFolha(ppcp.getDwFolha());
			op.setCicloPadrao(cicloPadrao);
			op.setCicloMinimo(cicloMinimo);
			op.setCicloTimeout(cicloTimeout);
			op.setFatorContagem(fatorContagem.intValue());
			op.setPacoteCiclo(pacoteCiclo);
			op.setAceitaNC(isAceitaNC);
			op.setFinalSerie(isFinalSerie);
			op.setQtdPcsPorCiclo(qtdPcsPorCiclo);
			if(listaProdutos != null)
				op.setQtdProdutos(listaProdutos.size());
			else
				op.setQtdProdutos(0);
			op.setListaProdutos(listaProdutos);
			op.gerarArquivo(dir, fileName);
		
		}
		
		TransferirParaInovaSAFolhas folha = new TransferirParaInovaSAFolhas();
		folha.setDwFolha(ppcp.getDwFolha());
		folha.setDiretorioDestino(getDiretorioDestino());
		folha.setLog(log);
		folha.setOmCfg(getOmCfg());
		folha.setSession(session);
		folha.setMsmsicup(msmsicup);
		folha.criarArquivo();
			
		
	}

	@Override
	public void criarArquivoStatus() {
		String urlConexao = msmsicup.getMsIc().getUrlConexao();
		try {
			urlConexao = urlConexao.substring(0, urlConexao.indexOf(":"));
		} catch (IndexOutOfBoundsException e) {
			urlConexao = msmsicup.getMsIc().getUrlConexao();
		}
		String dir = getDiretorioDestino() + "/" + urlConexao + "/status/op/";	

		String fileName = "op" + sessaoUP.getIdPt(); 
		
		ArquivoOps op = new ArquivoOps();
		op.setLog(log);
		op.setSessaoOP(sessaoUP.getOpDTO());
		op.gerarArquivoStatus(dir, fileName);
	}
	
	
	public PpCp getPpcp() {
		return ppcp;
	}

	public void setPpcp(PpCp ppcp) {
		this.ppcp = ppcp;
	}

	public OmPt getOmpt() {
		return ompt;
	}

	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}

	public SessaoUPDTO getSessaoUP() {
		return sessaoUP;
	}

	public void setSessaoUP(SessaoUPDTO sessaoUP) {
		this.sessaoUP = sessaoUP;
	}

}
