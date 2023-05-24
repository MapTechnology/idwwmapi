package ms.coleta.ic.fuji.fujiflexa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.ic.fuji.ArquivoFuji;
import ms.coleta.ic.fuji.ICFuji;
import ms.model.dto.EventoColetado;

public class ArquivoFujiMCRELOAD extends ArquivoFuji{

	public ArquivoFujiMCRELOAD(IdwLogger log) {
		super(log);
	}

	@Override
	public List<EventoColetado> obtemEvento(ICFuji ic) {
		List<EventoColetado> retorno = new ArrayList<>();
		String ultimaLinhaProcessada = getUltimaLinha(ic, getIcUpDTO().getUpDTO().getCd_up());
		boolean isEncontrouLinha = false;
		int numeroLinhasLidas = 0;
		
		if (ultimaLinhaProcessada == null)
			isEncontrouLinha = true;
		try {
			for (String linha : linhas) {
				if (isEncontrouLinha) {
					processarLinha(ic, retorno, linha, numeroLinhasLidas);
					ultimaLinhaProcessada = linha;
				} else if (linha.equals(ultimaLinhaProcessada))
					isEncontrouLinha = true;
				numeroLinhasLidas++;
			}
			
			 numeroLinhasLidas = 0;
			// Se a ultima linha nunca foi encontrada, entao processar todo arquivo
			if (isEncontrouLinha == false) {
				for (String linha : linhas) {
					processarLinha(ic, retorno, linha, numeroLinhasLidas);
					ultimaLinhaProcessada = linha;
					numeroLinhasLidas++;
				}
			}
		} catch (Exception e) {
			log.error("ArquivoFujiMCRELOAD: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
			e.printStackTrace();
		} finally {
			/* Salva a ultima linha processada */
			setUltimaLinha(ultimaLinhaProcessada);
		}		
		return retorno;
	}

	@Override
	protected void processarLinha(ICFuji ic, List<EventoColetado> retorno, String linha, int forIndex) {
		LinhaArquivoFujiFlexaMCRELOAD linhaTratada = new LinhaArquivoFujiFlexaMCRELOAD(log, ic, getIcUpDTO(), linha, forIndex);
		if (linhaTratada.isLinhaNoPadraoEsperado()) {
			retorno.addAll(linhaTratada.obtemEvento());
		}
	}

	@Override
	protected String getUltimaLinha(ICFuji ic, String cdUp) {
		// Checando em memoria
		if (ic.getUltimasLinhasProcessadasMCRELOAD().containsKey(cdUp)) {
			LinhaArquivoFujiFlexaMCRELOAD ultimaLinhaObtida = ic.getUltimasLinhasProcessadasMCRELOAD().get(cdUp);
			log.info("ArquivoFuji: Ultima linha obtida por getUltimaLinha metodo 1 : "
					+ ultimaLinhaObtida.getLinha());
			return ultimaLinhaObtida.getLinha();
		}

		// Checa em arquivo
		String retorno = null;
		String arquivoUltimaLinha = getPathArquivo() + "//" + getNomeArquivo()
				+ "-ultimalinhaprocessada.txt";
		File arq = new File(arquivoUltimaLinha);
		if (arq.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(arquivoUltimaLinha));
				String linha = null;
				while ((linha = br.readLine()) != null) {
					retorno = linha;
				}
				br.close();
				log.info("ArquivoFuji: Ultima linha obtida por getUltimaLinha metodo 2: "
						+ retorno);
				return retorno;
			} catch (Exception e) {
				log.error("ArquivoFuji: Erro ao obter ultima linha, metodo 2: " + e.toString());
				retorno = null;
			}
		} else {

		} // Fim do IF

		return null;
	}

}
