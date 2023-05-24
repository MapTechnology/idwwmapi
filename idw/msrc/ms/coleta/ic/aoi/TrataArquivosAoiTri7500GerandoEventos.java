package ms.coleta.ic.aoi;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

//public class TrataArquivosAoiGerandoEventos implements FileListener{
public class TrataArquivosAoiTri7500GerandoEventos extends TratadorArquivos {

	// Prerequisitos
	private ICAoiTri7500 ic;
	private List<IcUpDTO> icUpDTOList;
	// Log
	private IdwLogger log;

	// Usado para se obter o ano corrente fazer a validacao dos arquivos a serem tratados
	Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

	public TrataArquivosAoiTri7500GerandoEventos(IdwLogger log, List<IcUpDTO> icUpDTOList, ICAoiTri7500 ic) {
		this.log = log;
		this.icUpDTOList = icUpDTOList;
		this.ic = ic;
	}

	// public void doJob(Path path) {
	// File arquivo = path.toFile();
	// if (arquivo.exists()) {
	//
	// log.info("Lendo arquivo =" + path.toFile());
	//
	// String absolutePath = arquivo.getAbsolutePath();
	// String pathTratado = Paths.get(absolutePath).getParent().toString();
	//
	// // Pesquisa o icupDTO a partir da url de conexao
	// // que é o diretorio pai do arquivo que teve modificacao/criacao
	// // IcUpDTO icUpDTO = getIcUpDTOFromUrlConexao(pathTratado);
	// IcUpDTO icUpDTO = getIcUpDTOFromUrlConexaoLazy(pathTratado);
	// if (icUpDTO != null) {
	// String nomeMaquina = icUpDTO.getUpDTO().getCd_up();
	//
	// // Ailton 2018-08-22: Alessandre solicitou que o destino dos logs fosse modificado
	// // Prepara o diretorio onde vao ficar as copias dos logs
	// //File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
	//// String diretorioDestino = catalinaBase.getAbsolutePath(); // Path do log salvo
	//// diretorioDestino += "//ColetaAois//";
	//// criaDiretorioSeNaoExistir(diretorioDestino);
	//// log.info("urlDiretorio " + diretorioDestino);
	//
	// String diretorioDestino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
	// criaDiretorioSeNaoExistir(diretorioDestino);
	// log.info("urlDiretorio " + diretorioDestino);
	//
	// TCopiaArquivoAoiTri7500 tCopiaArquivo = new TCopiaArquivoAoiTri7500(nomeMaquina, diretorioDestino, log);
	// // Ailton 2018-06-28 e necessario passar o arg0 para que seja feita
	// // a resolucao e copia correta do arquivo pela rede
	// // ArquivoData arquivoCopia = tCopiaArquivo.doJob(arquivo);
	// // ArquivoAoiTri7500 arquivoCopia = tCopiaArquivo.doJob(arquivo, arg0);
	// ArquivoAoiTri7500 arquivoCopia = tCopiaArquivo.doJob(arquivo);
	// if (arquivoCopia != null) {
	// arquivoCopia.setIcUpDTO(icUpDTO);
	// List<EventoColetado> eventos = arquivoCopia.obtemEvento(ic);
	//
	// if (eventos != null)
	// ic.getBufferEventos().addEventos(eventos);
	//
	// } else {
	// log.error("TrataArquivoAoiGerandoEventos: arquivoCopia nao foi criado com sucesso, arquivoCopia == null");
	// }
	// // if (arquivoCopia != null) {
	// // arquivoCopia.setIcUpDTO(icUpDTO);
	// // arquivoCopia.obtemEvento(ic);
	// // }
	//
	// } else {
	// log.error("TrataArquivosAoiGerandoEventos: ICUPDTO == null para absolutePath: " + absolutePath);
	// }
	//
	// } else {
	// log.error("TrataArquivosAoiGerandoEventos: if (arquivo.exists()) retornou false: " + arquivo);
	// }
	// }

	public void doJob(Path path) {
		File arquivo = path.toFile();
		if (arquivo.exists()) {

			log.info("Lendo arquivo =" + path.toFile());
			String absolutePath = arquivo.getAbsolutePath();
			IcUpDTO icUpDTO = null;

			if (icUpDTOList.size() > 0)
				icUpDTO = icUpDTOList.get(0);

			if (icUpDTO != null) {
				String nomeMaquina = icUpDTO.getUpDTO().getCd_up();

				// Ailton 2018-08-22: Alessandre solicitou que o destino dos logs fosse modificado
				// Prepara o diretorio onde vao ficar as copias dos logs
				// File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
				// String diretorioDestino = catalinaBase.getAbsolutePath(); // Path do log salvo
				// diretorioDestino += "//ColetaAois//";
				// criaDiretorioSeNaoExistir(diretorioDestino);
				// log.info("urlDiretorio " + diretorioDestino);

				String diretorioDestino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
				diretorioDestino += "//ColetaAoisTRI//";
				criaDiretorioSeNaoExistir(diretorioDestino);
				log.info("urlDiretorio " + diretorioDestino);

				TCopiaArquivoAoiTri7500 tCopiaArquivo = new TCopiaArquivoAoiTri7500(nomeMaquina, diretorioDestino, log);
				// Ailton 2018-06-28 e necessario passar o arg0 para que seja feita
				// a resolucao e copia correta do arquivo pela rede
				// ArquivoData arquivoCopia = tCopiaArquivo.doJob(arquivo);
				// ArquivoAoiTri7500 arquivoCopia = tCopiaArquivo.doJob(arquivo, arg0);
				ArquivoAoiTri7500 arquivoCopia = tCopiaArquivo.doJob(arquivo);
				if (arquivoCopia != null) {
					arquivoCopia.setIcUpDTO(icUpDTO);
					EventoColetado evento = arquivoCopia.obtemEvento(ic);

					if (evento != null) {
						List<EventoColetado> eventos = new ArrayList<EventoColetado>();
						eventos.add(evento);
						ic.getBufferEventos().addEventos(eventos);

					} else {
						log.error("TrataArquivoAoiGerandoEventos: arquivoCopia nao foi criado com sucesso, arquivoCopia == null");
					}
					// if (arquivoCopia != null) {
					// arquivoCopia.setIcUpDTO(icUpDTO);
					// arquivoCopia.obtemEvento(ic);
					// }

				} else {
					log.error("TrataArquivosAoiGerandoEventos: ICUPDTO == null para absolutePath: " + absolutePath);
				}

			} else {
				log.error("TrataArquivosAoiGerandoEventos: if (arquivo.exists()) retornou false: " + arquivo);
			}
		}
	}

	public ArquivoAoiTri7500 doJobSemGerarEvento(Path path) {
		File arquivo = path.toFile();
		if (arquivo.exists()) {

			log.info("Lendo arquivo =" + path.toFile());
			String absolutePath = arquivo.getAbsolutePath();
			IcUpDTO icUpDTO = null;

			if (icUpDTOList.size() > 0)
				icUpDTO = icUpDTOList.get(0);

			if (icUpDTO != null) {
				String nomeMaquina = icUpDTO.getUpDTO().getCd_up();

				// Ailton 2018-08-22: Alessandre solicitou que o destino dos logs fosse modificado
				// Prepara o diretorio onde vao ficar as copias dos logs
				// File catalinaBase = new File(System.getProperty("catalina.base")).getAbsoluteFile();
				// String diretorioDestino = catalinaBase.getAbsolutePath(); // Path do log salvo
				// diretorioDestino += "//ColetaAois//";
				// criaDiretorioSeNaoExistir(diretorioDestino);
				// log.info("urlDiretorio " + diretorioDestino);

				String diretorioDestino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
				diretorioDestino += "//ColetaAoisTRI//";
				criaDiretorioSeNaoExistir(diretorioDestino);
				log.info("urlDiretorio " + diretorioDestino);

				TCopiaArquivoAoiTri7500 tCopiaArquivo = new TCopiaArquivoAoiTri7500(nomeMaquina, diretorioDestino, log);
				// Ailton 2018-06-28 e necessario passar o arg0 para que seja feita
				// a resolucao e copia correta do arquivo pela rede
				// ArquivoData arquivoCopia = tCopiaArquivo.doJob(arquivo);
				// ArquivoAoiTri7500 arquivoCopia = tCopiaArquivo.doJob(arquivo, arg0);
				ArquivoAoiTri7500 arquivoCopia = tCopiaArquivo.doJob(arquivo);
				if (arquivoCopia != null) {
					return arquivoCopia;
				} else {
					log.error("TrataArquivoAoiGerandoEventos: arquivoCopia nao foi criado com sucesso, arquivoCopia == null");
					return null;
				}
				// if (arquivoCopia != null) {
				// arquivoCopia.setIcUpDTO(icUpDTO);
				// arquivoCopia.obtemEvento(ic);
				// }

			} else {
				log.error("TrataArquivosAoiGerandoEventos: ICUPDTO == null para absolutePath: " + absolutePath);
				return null;
			}

		} else {
			log.error("TrataArquivosAoiGerandoEventos: if (arquivo.exists()) retornou false: " + arquivo);
			return null;
		}
	}

	public void trataTodosOsArquivos(List<ArquivoAoiTri7500> listaDeArquivos) {
		// TODO Auto-generated method stub
		List<String> listaDeBlancks = new ArrayList<String>();
		if (listaDeArquivos == null && listaDeArquivos.size() == 0) {
			return;
		}
		while (listaDeArquivos.remove(null)){
			
		}
		for (ArquivoAoiTri7500 arquivoCopia : listaDeArquivos) {
			String nomeOriginal = UtilsString.safeSplit(arquivoCopia.getNomeArquivo(), "--")[0];
			String cdBlanck = new String();
			if (nomeOriginal.length() < 18) {
				// Luiz - 20200217 - Provavelmente este log não possui codigo de barras, então é processado com a mesma regra de antes
				List<EventoColetado> eventos = new ArrayList<EventoColetado>();
				EventoColetado evento = arquivoCopia.obtemEvento(ic);

				if (evento != null) {
					eventos.add(arquivoCopia.obtemEvento(ic));
					ic.getBufferEventos().addEventos(eventos);
					if (arquivoCopia.getNomeOriginal().toFile().delete() == false) {
						log.info("Nao foi possivel deletar o arquivo de origem:" + arquivoCopia.getNomeOriginal().toString());
					}
					listaDeArquivos.remove(arquivoCopia);
					continue;
				} else {
					// deleta o arquivo novo
					continue;
				}
			} else {
				cdBlanck = getSufixo(nomeOriginal);
			}
			if (listaDeBlancks.size() == 0) {
				listaDeBlancks.add(cdBlanck);
			} else if (arquivoPossuiBlanckNaLista(cdBlanck, listaDeBlancks) == false) {
				listaDeBlancks.add(cdBlanck);
			}
		}
		processaTodosOsBlancksAgrupados(listaDeArquivos, listaDeBlancks);

	}

	private void processaTodosOsBlancksAgrupados(List<ArquivoAoiTri7500> listaDeArquivos, List<String> listaDeBlancks) {
		// TODO Auto-generated method stub
		for (String blanck : listaDeBlancks) {
			List<ArquivoAoiTri7500> placasDoBlanck = new ArrayList<ArquivoAoiTri7500>();
			for (ArquivoAoiTri7500 placa : listaDeArquivos) {
				if (placa.getNomeArquivo().contains(blanck) == true) {
					placasDoBlanck.add(placa);
				}
			}
			processaUmBlanck(placasDoBlanck);
		}
	}

	private void processaUmBlanck(List<ArquivoAoiTri7500> placasDoBlanck) {
		// TODO Auto-generated method stub
		int NumeroDaPlacaNoBlanck = 0;
		List<EventoColetado> eventosDoBlanck = new ArrayList<EventoColetado>();
		for (ArquivoAoiTri7500 placa : placasDoBlanck) {
			EventoColetado evento = new EventoColetado();
			evento = placa.obtemEventos(ic, Integer.toString(placasDoBlanck.size()));
			if (evento != null) {
				evento.setDthrEvento(DataHoraRN.adicionaMilisegundosNaData(evento.getDthrEvento(), NumeroDaPlacaNoBlanck*10));
				eventosDoBlanck.add(evento);
				if(placa.getNomeOriginal().toFile().delete() == false) {
					log.info("Não foi possivel deletar o arquivo de log da máquina: " + placa.getNomeArquivo().toString());
				}
				if (placa.getArquivoDestino().toFile().delete() == false) {
					log.info("Não foi possivel deletar o arquivo copia do diretorio temp do idw: " + placa.getArquivoDestino().toString());
				}
			} else
				log.info("Nao foi possivel obter evento do log: "+ placa.getNomeOriginal().toString());
			NumeroDaPlacaNoBlanck +=1;
		}
		if (eventosDoBlanck != null && eventosDoBlanck.size() != 0) {
			ic.getBufferEventos().addEventos(eventosDoBlanck);
		}
	}

	public String getSufixo(String arq) {
		return arq.substring(arq.length() - 18);
	}

	public boolean arquivoPossuiBlanckNaLista(String sufixo, List<String> lista) {
		for (String texto : lista) {
			if (texto.contains(sufixo)) {
				return true;
			}
		}
		return false;
	}

	public boolean arquivoPossuiSufixoDaLista(File sufixo, List<String> lista) {
		for (String texto : lista) {
			if (sufixo.getName().contains(texto)) {
				return true;
			}
		}
		return false;
	}
	/*
	 * private IcUpDTO getIcUpDTOFromUrlConexaoLazy(String urlConexao) { // Se nao for um caminho do windows, usa a versao tradicional if
	 * (!urlConexao.contains("\\")) return getIcUpDTOFromUrlConexao(urlConexao); String urlConexaoResumida = new File(urlConexao).getName();
	 * for (IcUpDTO icUpDTOAux : icUpDTOList) { if (icUpDTOAux.getUrlConexao().contains(urlConexaoResumida)) { return icUpDTOAux; } } return
	 * null; } private IcUpDTO getIcUpDTOFromUrlConexao(String urlConexao) { for (IcUpDTO icUpDTOAux : icUpDTOList) { if
	 * (icUpDTOAux.getUrlConexao().equals(urlConexao)) { return icUpDTOAux; } } return null; }
	 */

}
