package ms.coleta.ic.aoikyza;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class TrataArquivosAoiKYZAGerandoEventos extends TratadorArquivos {

	// Prerequisitos 
	private ICAoiKYZA ic;
	private List<IcUpDTO> icUpDTOList;
	// Log
	private IdwLogger log;
	private ArrayList<String> listaArquivosIgnorados = new ArrayList<String>();
	private Date ultimaExecucao = new Date();

	// Usado para se obter o ano corrente fazer a validacao dos arquivos a serem tratados
	Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

	public TrataArquivosAoiKYZAGerandoEventos(IdwLogger log, List<IcUpDTO> icUpDTOList, ICAoiKYZA ic) {
		this.log = log;
		this.icUpDTOList = icUpDTOList;
		this.ic = ic;
	}

	public void doJob(Path path) {
		boolean deveDeletar = false;
		File arquivo = path.toFile();
		if (arquivo.exists()) {

			log.info("Lendo arquivo =" + path.toFile());
			String absolutePath = arquivo.getAbsolutePath();
			IcUpDTO icUpDTO = null;

			if (icUpDTOList.size() > 0)
				icUpDTO = icUpDTOList.get(0);

			if (icUpDTO != null) {
				String nomeMaquina = icUpDTO.getUpDTO().getCd_up();

				String diretorioDestino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
				diretorioDestino += "ColetaAoisKYZA/";
				criaDiretorioSeNaoExistir(diretorioDestino);
				log.info("urlDiretorio " + diretorioDestino);

				TCopiaArquivoAoiKYZA tCopiaArquivo = new TCopiaArquivoAoiKYZA(nomeMaquina, diretorioDestino, log);
				ArquivoAoiKYZA arquivoCopia = null;
				if (!listaArquivosIgnorados.contains(arquivo.getName())) {
					arquivoCopia = tCopiaArquivo.doJob(arquivo);
				}

				if (arquivoCopia != null) {
					arquivoCopia.setIcUpDTO(icUpDTO);
					List<EventoColetado> eventos = arquivoCopia.obtemEvento(ic);

					if (eventos != null) {
						ic.getBufferEventos().addEventos(eventos);
						deveDeletar = true; // NAOAPAGARARQUIVOAOI - mudar pra true para apagar o arquivo
					} else {
						deveDeletar = false;
						this.listaArquivosIgnorados.add(arquivo.getName());
						log.info("Arquivo não parece ser um log da AOI S500. Adicionando na lista de ignorados o arquivo: "
								+ arquivo.getName());
					}

				} else {
					log.info(
							"TrataArquivoAoiGerandoEventos: arquivoCopia nao foi criado com sucesso, arquivoCopia == null, para o arquivo:"
									+ arquivo.getName());
				}

				// Luiz 2019-05-23 Após copiar o arquivo o arquivo de origem devera ser deletado
				// Em conversa com a Fuji e o Ale foi decidido que o mesmo será deletado
				// Caso algum eventa tenha sido retornado então o mesmo deverá ser deletado, caso contrário deverá ser ignorado
				if (deveDeletar) {
					try {
						if (arquivo.delete())
							log.info("Foi copiado e deletado o arquivo: " + arquivo.getAbsolutePath());
						else
							log.info("Nao foi possivel deletar o arquivo:" + arquivo.getAbsolutePath());
					} catch (Exception e) {
						log.info("Não consegui deletar o arquivo de log : " + arquivo.getAbsolutePath() + "Com a excecao: "
								+ e.getMessage());
					}
				}
				if ((ultimaExecucao.getTime() - (new Date()).getTime()) >= 60 * 1000 * 30) {
					this.limpaListaIgnorados();
					this.ultimaExecucao = new Date();
				}
			} else {
				log.info("TrataArquivosAoiGerandoEventos: ICUPDTO == null para absolutePath: " + absolutePath);
			}

		} else {
			log.info("TrataArquivosAoiGerandoEventos: if (arquivo.exists()) retornou false: " + arquivo);
		}
	}

	public void limpaListaIgnorados() {
		this.listaArquivosIgnorados.clear();
	}

}
