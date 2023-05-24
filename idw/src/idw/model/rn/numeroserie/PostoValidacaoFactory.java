package idw.model.rn.numeroserie;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwRota;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpnserie;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.RoteiroRN;
import idw.model.rn.VerificaPassagemRN;
import idw.model.rn.numeroserie.ValidaNumeroSerieRN.TpRetornoValidaNS;
import idw.webservices.dto.PassagemDTO;

public abstract class PostoValidacaoFactory {
	
	public abstract int avaliarRegra(DwFolha dwfolha, PpCp ppcp, String ns, boolean isAvaliarMontagem, DAOGenerico dao);

	public static PostoValidacaoFactory getInstancia(OmTppt omtppt) {
		if (omtppt.isPostoEmbalgem() || omtppt.isPostoMontagem())
			return new PostoValidacaoMontagemEmbalagem();
		
		return new PostoValidacaoOutrosPostos();
	}
	
	/*
	 * 2) Seguir as regras de montagem definidas na folha detalhe da montagem.
	 */
	protected boolean isCBAtendeRegrasEmDwFolhamoncomp(DwFolha dwfolha, String ns) {
		boolean isretorno = false;
		
		
		
		return isretorno;
	}

	/* 
	 * O CB deve estar dentro das regras definidas em DwFolhaMonComp.
	 * 1) Não pode ser qualquer codigo de barras. Tem que ser um aceitável as configuracoes da folha. Ou no CB tem o codigo do produto, ou o codigo da plataforma
	 */
	protected OmProduto getCBProdutoOuPlataformaValido(PpCp ppcp, String ns) {
		OmProduto retorno = null;
		for (PpCpproduto prod : ppcp.getPpCpprodutos()) {
			OmProgrp grupo = prod.getOmProduto().getOmProgrp();
			// Verifica se o codigo do produto existe no CB ou se a platoforma existe
			if (ns.contains(prod.getOmProduto().getCdProduto()) || (grupo != null && ns.contains(grupo.getCdProgrp())) ) {
				retorno = prod.getOmProduto();
			}
		}
		return retorno;
	}

	protected PpCpnserie createPpCpnserie(DwNserie nserie, PpCp ppcp) {
		PpCpnserie cpnserie = new PpCpnserie();
		cpnserie.setDwNserie(nserie);
		cpnserie.setPpCp(ppcp);
		cpnserie.setIdCpserie(null);
		return cpnserie;
	}

	protected DwNserie createDwNSerie(String ns, OmProduto omproduto) {
		DwNserie nserie;
		nserie = new DwNserie();
		nserie.setIdNserie(0l);
		nserie.setCb(ns);
		nserie.setNs(ns);
		nserie.setOmProduto(omproduto);
		return nserie;
	}

	protected int verificarRoteiro(String ns, OmPt ompt, VerificaPassagemRN rn) {
		PassagemDTO passagem = new PassagemDTO();
		PpCp ppCp = ompt.getPpCp();
		OmTppt omTppt = ompt.getOmTppt();
		DwRota dwRotaDePpCp = (ppCp != null ? ppCp.getDwRota() : null);
		
		// Pesquisa novamente o roteiro pois pode ter tido alteracao
		RoteiroRN rrn = new RoteiroRN(rn.getDao());
		if (dwRotaDePpCp != null)
			dwRotaDePpCp = rrn.pesquisarDwRotaByCdRota(dwRotaDePpCp.getCdRota());

		if (dwRotaDePpCp != null) {
			passagem = rn.obtemNaoConformidadesAtuais(ns, dwRotaDePpCp.getIdRota(), omTppt.getIdTppt().intValue(), ppCp.getNrop(), ppCp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue()));
		} else {
			passagem.setCb(ns);
			passagem.setIdGt(ompt.getOmGt().getIdGt());
			passagem.setIdTppt(omTppt.getIdTppt());
			passagem.setCdPt(ompt.getCdPt());
			if (ppCp != null && ppCp.getDwFolha() != null)
				passagem.setIdFolha(ppCp.getDwFolha().getIdFolha());
			
			// Verificar se existe um roteiro definido para o GT ao qual o posto pertence
			// e se esse roteiro eh referente ao produto que está sendo produzido pela OP
			DwRota dwrotaGtProduto = rrn.getDwRotaByGtProduto(ompt.getCdPt());
//			if (
//					ompt.getCdPt().contains("LIN01") ||
//					ompt.getCdPt().contains("LIN02") ||
//					ompt.getCdPt().contains("LIN03") ||
//					ompt.getCdPt().contains("LIN04") ||
//					//ompt.getCdPt().contains("LIN06") ||
//					ompt.getCdPt().contains("LIN07") ||
//					ompt.getCdPt().contains("LIN08")
//					//ompt.getCdPt().contains("LIN16")
//					) {
			if (dwrotaGtProduto != null) {
				passagem.setIsAvaliarRoteiro(true);
			}
			
			passagem = rn.obtemNaoConformidadesAtuais(passagem);
		}

		if (passagem.getNaoConformidadesAtuais().isEmpty() == false || passagem.getResultado().getIdmensagem() == passagem.getResultado().getROTEIRO_INCONSISTENTE()) {
			return TpRetornoValidaNS.RETORNO_NS_INVALIDO_NC.getValue();
		} else {
			return TpRetornoValidaNS.RETORNO_NS_VALIDO.getValue();
		}
	}
}
