package ms.coleta.ic.aoiVTRNS;

import java.io.File;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;

public class TrataArquivosAoiVTRNSGerandoEventos extends TratadorArquivos{

	// Prerequisitos
	private ICAoiVTRNS ic;
	private List<IcUpDTO> icUpDTOList;
	// Log
	private IdwLogger log;

	// Usado para se obter o ano corrente fazer a validacao dos arquivos a serem tratados
	Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

	public TrataArquivosAoiVTRNSGerandoEventos(IdwLogger log, List<IcUpDTO> icUpDTOList, ICAoiVTRNS ic) {
		this.log = log;
		this.icUpDTOList = icUpDTOList;
		this.ic = ic;
	}

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
				
				String diretorioDestino = Stubedelegate.getInstancia().getMsthread().getPathCacheColeta();
				diretorioDestino += "//ColetaAoisOMRON//";
				criaDiretorioSeNaoExistir(diretorioDestino);
				log.info("urlDiretorio " + diretorioDestino);

				TCopiaArquivoAoiVTRNS tCopiaArquivo = new TCopiaArquivoAoiVTRNS(nomeMaquina, diretorioDestino, log);
				ArquivoAoiOmron arquivoCopia = tCopiaArquivo.doJob(arquivo);
				
				if (arquivoCopia != null) {
					arquivoCopia.setIcUpDTO(icUpDTO);
					List<EventoColetado> eventos = arquivoCopia.obtemEvento(ic);

					if (eventos != null)
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

