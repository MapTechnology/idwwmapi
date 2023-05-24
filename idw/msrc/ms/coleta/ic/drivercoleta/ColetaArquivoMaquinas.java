package ms.coleta.ic.drivercoleta;

import java.util.ArrayList;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.model.dto.IcUpDTO;

public class ColetaArquivoMaquinas {
	private List<ColetaArquivoMaquina> coletas;
	private IdwLogger log = null;
	private String pathRelativo = "";
	
	public ColetaArquivoMaquinas(String pathRelativo, IdwLogger log) {
		this.pathRelativo = pathRelativo;
		this.coletas = new ArrayList<ColetaArquivoMaquina>();
		this.log = log;
	}
	
	public ColetaArquivoMaquina getColetaMaquina(IcUpDTO up) {
		for(ColetaArquivoMaquina coletaMaquina : coletas)
		{
			if(coletaMaquina.equals(up))
			{
				return coletaMaquina;
			}
		}
		return null;
	}
	
	public void atualizaColetas(List<IcUpDTO> icupdtos) {
		//IcUpDTO eh o item da lista do cadastro em MS(Modulo de Sinais)
		
		List<ColetaArquivoMaquina> novaLista = new ArrayList<ColetaArquivoMaquina>();
		
		//Preenche a novaLista com as UPs que devem continuar processando
		for (IcUpDTO up : icupdtos) {
			ColetaArquivoMaquina coletaExistente = getColetaMaquina(up);

			if(coletaExistente == null)
			{
				try
				{
					ColetaFileType tipoArquivo = DriverColetaRN.getFileType(up.getUrlAuxiliar());
					// Se o tipo do arquivo for desconhecido entao desconsidera-lo
					if (tipoArquivo.equals(ColetaFileType.UNKOWN) == false) {
						ColetaArquivoMaquina coletaMaquina = new ColetaArquivoMaquina(pathRelativo, tipoArquivo, up, log);
						if(coletaMaquina.iniciarColeta())
							novaLista.add(coletaMaquina);
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			} else {
				coletaExistente.getArquivoMonitorado().checkFiscal();
				novaLista.add(coletaExistente);
			}
		}
		//Remove da lista original as UPs que devem continuar processando, deixando apenas as que devem ser paradas
		for(ColetaArquivoMaquina it : novaLista)
			coletas.remove(it);
		
		//Para as UPs que devem ser paradas
		for(ColetaArquivoMaquina coletaParando : coletas)
			coletaParando.pararExecucao();
		
		coletas.clear();
		coletas = novaLista;
	}

	public List<ColetaArquivoMaquina> getColetas() {
		return coletas;
	}

	public void setColetas(List<ColetaArquivoMaquina> coletas) {
		this.coletas = coletas;
	}
	
	public void setLog(IdwLogger log) {
		this.log = log;
	}
	public IdwLogger getLog() {
		return this.log;
	}
}
