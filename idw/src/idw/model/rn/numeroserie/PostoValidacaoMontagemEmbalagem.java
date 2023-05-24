package idw.model.rn.numeroserie;

import idw.model.dao.DAOGenerico;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhamon;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.DwNserie;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpnserie;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.CpRN;
import idw.model.rn.NumeroSerieRN;
import idw.model.rn.numeroserie.RegraValidacaoFactory._REGRAS;
import idw.model.rn.numeroserie.ValidaNumeroSerieRN.TpRetornoValidaNS;
import idw.webservices.dto.ResultadoDTO;

public class PostoValidacaoMontagemEmbalagem extends PostoValidacaoFactory{

	/* Metodo principal para avaliacao das regras de validacao */
	@Override
	public int avaliarRegra(DwFolha dwfolha, PpCp ppcp, String ns, boolean isValidarMontagem, DAOGenerico dao) {
		int retorno = TpRetornoValidaNS.RETORNO_NS_INVALIDO.getValue();  // invalido
		
		if (isValidarMontagem)
			retorno = avaliarMontagem(dwfolha, ppcp, ns, dao);
		else
			retorno = avaliarNS(dwfolha, ppcp, ns, dao);
		
		return retorno;
	}
	
	/* Avalia as regras definidas na montagem. Se passar em alguma o NS é valido
	 * 
	 */
	private int avaliarMontagem(DwFolha dwfolha, PpCp ppcp, String ns, DAOGenerico dao) {
		int retorno = TpRetornoValidaNS.RETORNO_NS_INVALIDO.getValue();  // invalido
		for (DwFolhamon mon : dwfolha.getDwFolhamons()) {
			for (DwFolhamoncomp comp : mon.getDwFolhamoncomps()) {
				int tipoValidacao = _REGRAS.SEM_VALIDACAO.getValue();
				if (comp.getTpValidacao() != null) {
					tipoValidacao = comp.getTpValidacao();
				}
				RegraValidacaoFactory regra = new RegraValidacaoFactory(tipoValidacao, ppcp, dwfolha, comp, ns, ppcp.getOmPt(), dao);
				ResultadoDTO resultado = regra.isPassouNaRegra();
				if (resultado.isComSucesso()) {
					retorno = TpRetornoValidaNS.RETORNO_NS_VALIDO.getValue();
					break;
				} else if (resultado.getIdmensagem() == resultado.FORA_FAIXA || resultado.getIdmensagem() == resultado.SEM_MAC_DISPONIVEL) {
					retorno = TpRetornoValidaNS.RETORNO_NS_FORARANGE.getValue();
				} else {
					if (resultado.getIdmensagem() == resultado.FORA_LIMITE) {
						retorno = TpRetornoValidaNS.RETORNO_NS_FORALIMITE.getValue();
					}
				}
			}
		}
		return retorno;
	}

	private int avaliarNS(DwFolha dwfolha, PpCp ppcp, String ns, DAOGenerico dao) {
		int retorno = TpRetornoValidaNS.RETORNO_NS_INVALIDO.getValue();  // invalido
		
		RegraValidacaoFactory regra = new RegraValidacaoFactory(dwfolha.getTpValidacao(), ppcp, dwfolha, null, ns, ppcp.getOmPt(), dao);
		ResultadoDTO resultado = regra.isPassouNaRegra();
		if (resultado.isComSucesso())
			retorno = TpRetornoValidaNS.RETORNO_NS_VALIDO.getValue();
		else if (resultado.getIdmensagem() == resultado.SEM_MAC_DISPONIVEL)
			retorno = TpRetornoValidaNS.RETORNO_NS_FORARANGE.getValue();

		
		if (ppcp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue())) {
			// Avalaiar se o MAC esta na lista das OPs, mas somente se houverem macs definidos na OP
			if (ppcp.getPpCpnseries().isEmpty() == false) {
				CpRN rn = new CpRN(dao);
				PpCpnserie cpns = rn.getPpCpnserie(ppcp, ns);
				if (cpns == null) {
					retorno = TpRetornoValidaNS.RETORNO_NS_INVALIDO_NC.getValue(); // no caso nao existe o mac na lidata da op
				}
			} else {
				// Se nao houver uma relacao de NS avaliar se o NS foi produzido anteriormente. Se nao tiver sido levantar NC
				NumeroSerieRN rn = new NumeroSerieRN(dao);
				DwNserie nserie;
				try {
					nserie = rn.getDwNserieCb(ns);
				} catch (NumeroSerieIrregularException e) {
					nserie = null;
				}
				if (nserie == null) {
					retorno = TpRetornoValidaNS.RETORNO_NS_INVALIDO_NC.getValue(); // no caso nao existe o mac na lidata da op
				}
			}
			
		}

		
		
		return retorno;
	}
}
