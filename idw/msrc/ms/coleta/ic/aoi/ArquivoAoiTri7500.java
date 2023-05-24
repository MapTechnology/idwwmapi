package ms.coleta.ic.aoi;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class ArquivoAoiTri7500 {
	private IdwLogger log;
	// nomeArquivoDestino
	private String nomeArquivo;
	private Path nomeOriginal;
	// pathDestino
	private String pathArquivo;
	private Path arquivoDestino;
	
	private IcUpDTO icUpDTO;
	
	protected List<String> linhas = new ArrayList<>();

	// Informacoes Parseadas
	// Cd componente e Erro detectado
	private Map<String,String> mwasPosicaoMec_CdComp = new HashMap<String,String>();
	private Map<String,String> mwasPosicaoMec_CdDefeito = new HashMap<String,String>();
	private Date dataHoraFimTeste = null;
	
	
	public ArquivoAoiTri7500(IdwLogger log, String nomeArquivoDestino, String pathDestino) {
		this.log = log;
		this.nomeArquivo = nomeArquivoDestino;
		this.pathArquivo = pathDestino;
	}

	/**
	 * Cada arquivo representa um teste, assim, deve ser processado inteiro
	 * 
	 * @param ic
	 * @return 
	 */
	public EventoColetado obtemEvento(ICAoiTri7500 ic) {
		EventoColetado retorno  = new EventoColetado();
		try {
			if (linhas != null) {
				EventoColetado eventoObtido = processarLog();
				if (eventoObtido != null)
					return null;
			}
		} catch (Exception e) {
			log.error("ArquivoAoiTri7500: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}
	
	public EventoColetado obtemEventos(ICAoiTri7500 ic, String tamanhoDoBlanck) {
		EventoColetado retorno  = new EventoColetado();
		this.setIcUpDTO(ic.getIcdto().getMsIcUpDTOLocais().get(0));
		try {
			if (linhas != null) {
				retorno = processarLogs(tamanhoDoBlanck);
				if (retorno == null)
					return null;
			}
		} catch (Exception e) {
			log.error("ArquivoAoiTri7500: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}
	
	//protected void processarLog(ICAoi ic, List<String> linhas) {
	protected EventoColetado processarLog() {
		EventoColetado retorno = null;
		String ttd = ""; // Data do teste
		String tte = ""; // Hora do fim do teste
		String ocr = "";
		String cdOp = "";
		for (String linha: linhas) {
			if (linha.contains("TTD") && UtilsString.safeSplit(linha, ":") != null) {
				ttd = UtilsString.safeSplit(linha, ":")[1];
			} else if (linha.contains("BDT") && UtilsString.safeSplit(linha, ":") != null) {
				cdOp = UtilsString.safeSplit(linha, ":")[1];
			} else if (linha.contains("TTE") && UtilsString.safeSplit(linha, ":") != null) {
				String tteVector[] = UtilsString.safeSplit(linha, ":"); 
				tte = tteVector[1] + ":" + tteVector[2] + ":" + tteVector[3];
			} else if (linha.contains("MWA") && UtilsString.safeSplit(linha, "\\[") != null) {
				String aux = UtilsString.safeSplit(linha, "\\[")[1];
				if (UtilsString.safeSplit(aux, ",") != null) {
					String posicaoMecanica = UtilsString.safeSplit(aux, ",")[0];
					String cdComponente = UtilsString.safeSplit(aux, ",")[1];
					String errorDs = UtilsString.safeSplit(aux, ",")[2] ;
					errorDs = errorDs.replaceAll("\\]", "");
					mwasPosicaoMec_CdComp.put(posicaoMecanica, cdComponente);
					mwasPosicaoMec_CdDefeito.put(posicaoMecanica, errorDs);
				}
			} else if (linha.equals("FAIL")) {
				ocr = "FAIL";
			} else if (linha.equals("PASSED")) {
				ocr = "PASSED";
			}
		}
		String dateHoraString = ttd + " " + tte;
		dataHoraFimTeste = UtilsString.dateTimeStringToDateAOITRI(dateHoraString);
		String cdUp = icUpDTO.getUpDTO().getCd_up();
		
		if (ocr.equals("PASSED")) {
			// String cdPt, String cdOp, String cb, Date dthr, Integer stTeste, String qtde
			// IdwFacade.getInstancia().regristrarTesteSimples(cdUp, cdOp, "", dataHoraFimTeste, 1, "1");
			retorno = criaEventoColetadoTesteSimples(cdUp, cdOp, "", dataHoraFimTeste, "1", "NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
		} else if (ocr.equals("FAIL")) {
			retorno = criaEventoColetadoTesteDefeito(cdUp, cdOp, "", dataHoraFimTeste, "1", "NS-"+icUpDTO.getUpDTO().getCd_up() +"-" + (new Date()).getTime());
		}
		return retorno;
	}
	
	protected EventoColetado processarLogs(String tamanhoDoBlanck) {
		EventoColetado retorno = new EventoColetado();
		String ttd = ""; // Data do teste
		String tte = ""; // Hora do fim do teste
		String ocr = "";
		String cdOp = "op";
		String cb = "";
		for (String linha: linhas) {
			if (linha.contains("TTD") && UtilsString.safeSplit(linha, ":") != null) {
				ttd = UtilsString.safeSplit(linha, ":")[1];
			} else if (linha.contains("BDT") && UtilsString.safeSplit(linha, ":") != null) {
				// cdOp = UtilsString.safeSplit(linha, ":")[1];
			} else if (linha.contains("SNR") && UtilsString.safeSplit(linha, ":") != null) {
				cb = UtilsString.safeSplit(linha, ":")[1];
			} else if (linha.contains("TTE") && UtilsString.safeSplit(linha, ":") != null) {
				String tteVector[] = UtilsString.safeSplit(linha, ":");
				tte = tteVector[1] + ":" + tteVector[2] + ":" + tteVector[3];
			} else if (linha.contains("MWA") && UtilsString.safeSplit(linha, "\\[") != null) {
				String aux = UtilsString.safeSplit(linha, "\\[")[1];
				if (UtilsString.safeSplit(aux, ",") != null) {
					String posicaoMecanica = UtilsString.safeSplit(aux, ",")[0];
					String cdComponente = UtilsString.safeSplit(aux, ",")[1];
					String errorDs = UtilsString.safeSplit(aux, ",")[2] ;
					errorDs = errorDs.replaceAll("\\]", "");
					mwasPosicaoMec_CdComp.put(posicaoMecanica, cdComponente);
					mwasPosicaoMec_CdDefeito.put(posicaoMecanica, errorDs);
				}
			} else if (linha.equals("FAIL")) {
				ocr = "FAIL";
			} else if (linha.equals("PASSED")) {
				ocr = "PASSED";
			}
		}
		String dateHoraString = ttd + " " + tte;
		dataHoraFimTeste = UtilsString.dateTimeStringToDateAOITRI(dateHoraString);
		String cdUp = icUpDTO.getUpDTO().getCd_up();
		
		if (ocr.equals("PASSED")) {
			// String cdPt, String cdOp, String cb, Date dthr, Integer stTeste, String qtde
			// IdwFacade.getInstancia().regristrarTesteSimples(cdUp, cdOp, "", dataHoraFimTeste, 1, "1");
			retorno = (criaEventoColetadoTesteSimples(cdUp, cdOp, "", dataHoraFimTeste, tamanhoDoBlanck, cb));
		} else if (ocr.equals("FAIL")) {
			retorno = (criaEventoColetadoTesteDefeito(cdUp, cdOp, "", dataHoraFimTeste, tamanhoDoBlanck, cb));
		}
		return retorno;
	}
	
	private EventoColetado criaEventoColetadoTesteSimples(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde, String cb) {
		EventoColetado ev = new EventoColetado();
		
		ev.setCb(cb);
		// A op nao esta sendo passada pq sera deixado para o sistema determinar
		// qual op esta carregada
		// 2018-08-24: Op esta sendo considerada novamente
		ev.setCdop(cdOp);
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(true);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
		ev.setOrigem(nomeArquivo);
		ev.setEventoApenasInformativo(false);
		
		return ev;
	}
	
	private EventoColetado criaEventoColetadoTesteDefeito(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde, String cb) {
		EventoColetado ev = new EventoColetado();		
		ev.setCb(cb);
		// A op nao esta sendo passada pq sera deixado para o sistema determinar
	    // qual op esta carregada
		// 2018-08-24: Op esta sendo considerada novamente
		ev.setCdop(cdOp);
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(false);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // // Passagem
		ev.setOrigem(nomeArquivo);
		ev.setEventoApenasInformativo(false);

		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		// Validacao
		if (mwasPosicaoMec_CdDefeito.size() == 0 || mwasPosicaoMec_CdComp.size() == 0) 
			return null;
		
		for (Map.Entry<String, String> entry : mwasPosicaoMec_CdDefeito.entrySet()) {
			DefeitoDTO defeito = new DefeitoDTO();

			defeito.setCdDefeito(entry.getValue());
			defeito.setDthrDefeito(dataHoraFimTeste);
			defeito.setCb(mwasPosicaoMec_CdComp.get(entry.getKey())); // codigo do componente
			defeito.setPosicoes(entry.getKey()); // Posicao Mecanica
			defeitos.add(defeito);
		}
		
		if (defeitos.size() > 0)
			ev.setDefeitos(defeitos);		
		
		return ev;
	}

	private IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

	public void setLinhas(List<String> retorno) {
		this.linhas = retorno;
		
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getPathArquivo() {
		return pathArquivo;
	}

	public void setPathArquivo(String pathArquivo) {
		this.pathArquivo = pathArquivo;
	}

	public void setIcUpDTO(IcUpDTO icUpDTO) {
		this.icUpDTO = icUpDTO;
	}

	public Path getNomeOriginal() {
		return nomeOriginal;
	}

	public void setNomeOriginal(Path nomeOriginal) {
		this.nomeOriginal = nomeOriginal;
	}

	public Path getArquivoDestino() {
		return arquivoDestino;
	}

	public void setArquivoDestino(Path arquivoDestino) {
		this.arquivoDestino = arquivoDestino;
	}

}

