package idw.model.rn.pdba;

import java.util.List;

import idw.model.pojos.DwTAcao;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.DwTJust;
import idw.model.rn.AcaoRN;
import idw.model.rn.CausaRN;
import idw.model.rn.JustificativaRN;

public class CausaAcaoJustPdbaMsEvtRN extends AbstractPdbaMsEvtRN{

	public static void main(String[] args) {
		CausaAcaoJustPdbaMsEvtRN rn = new CausaAcaoJustPdbaMsEvtRN();
		System.out.println(rn.getTr_validaAcao("3"));
	}
	public boolean getTr_validaAcao(String cdAcao){
		boolean retorno = false;
		
		AcaoRN rn = new AcaoRN();
		rn.iniciaConexaoBanco();

		try {
			List<DwTAcao> lista = rn.getDwTAcoes(cdAcao);
			for (DwTAcao dwtacao : lista) {
				if (dwtacao.getOmTppt().isMaquinaCiclica())
					retorno = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}



	public boolean getTr_validaCausa(String cdCausa){
		boolean retorno = false;
		
		CausaRN rn = new CausaRN();

		try {
			rn.iniciaConexaoBanco();
			List<DwTCausa> lista = rn.getDwTCausas(cdCausa);
			for (DwTCausa dwtcausa : lista) {
				if (dwtcausa.getOmTppt().isMaquinaCiclica())
					retorno = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}



	public boolean getTr_validaJustificativa(String cd){
		boolean retorno = false;
		
		JustificativaRN rn = new JustificativaRN();

		try {
			rn.iniciaConexaoBanco();
			List<DwTJust> lista = rn.getDwTJusts(cd);
			for (DwTJust dwt : lista) {
				if (dwt.getOmTppt().isMaquinaCiclica())
					retorno = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
		} finally {
			rn.finalizaConexaoBanco();
		}
		
		return retorno;
	}
}
