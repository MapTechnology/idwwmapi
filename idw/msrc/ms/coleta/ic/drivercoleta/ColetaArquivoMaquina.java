package ms.coleta.ic.drivercoleta;

import java.util.List;

import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.model.dto.IcUpDTO;
import idw.util.IdwLogger;

public class ColetaArquivoMaquina {
	private ArquivoMonitorado arquivoMonitorado = null;
	private TrataArquivoRN threadTrataArquivo = null;
	private IdwLogger log = null;
	private ColetaFileType fileType = ColetaFileType.UNKOWN;
	private IcUpDTO icupdto = null;
	private String pathRelativo = "";
	
	public ColetaArquivoMaquina(String pathRelativo, ColetaFileType fileType, IcUpDTO icupdto, IdwLogger log) {
		this.setPathRelativo(pathRelativo);
		this.fileType = fileType;
		this.icupdto = icupdto;
		this.log = log;
		log.info("ColetaArquivoMaquina("+icupdto.getUpDTO().getCd_up()+") CRIADO");
		this.arquivoMonitorado = ArquivoMonitoradoFactory.getInstancia().getArquivoMonitorado(pathRelativo, fileType);
		this.threadTrataArquivo = TrataArquivoRNFactory.getInstancia().getTrataArquivoRN(pathRelativo, icupdto, this.fileType, new IdwLogger("TrataArquivoRN" + icupdto.getUpDTO().getCd_up()));
	}
	
	public boolean iniciarColeta() {
		boolean res = false;
		log.info("iniciarColeta("+icupdto.getUpDTO().getCd_up()+") INI");
		res = arquivoMonitorado.criarFiscalDeArquivo(icupdto.getUrlConexao(), icupdto.getUpDTO().getCd_up());
		if(res == true)
			threadTrataArquivo.inicializaThread();
		log.info("iniciarColeta("+icupdto.getUpDTO().getCd_up()+") FIM");
		return res;
	}
	
	public boolean isColetaPresenteEmListaIcUpDTO(List<IcUpDTO> icupdtos) {
		for(IcUpDTO up : icupdtos) {
			if(this.equals(up))
			{
				return true;
			}
		}
		return false;
	}
	
	public void pararExecucao() {
		log.info("pararExecucao("+icupdto.getUpDTO().getCd_up()+") INI");
		try {
			arquivoMonitorado.pararExecucaoDaThreadFiscal();
		} catch(Exception e) {}
		try {
			threadTrataArquivo.pararExecucaoThread();
		} catch(Exception e) {}
		log.info("pararExecucao("+icupdto.getUpDTO().getCd_up()+") FIM");
	}
	
	public ArquivoMonitorado getArquivoMonitorado() {
		return arquivoMonitorado;
	}
	public void setArquivoMonitorado(ArquivoMonitorado arquivoMonitorado) {
		this.arquivoMonitorado = arquivoMonitorado;
	}
	public TrataArquivoRN getTrataArquivo() {
		return threadTrataArquivo;
	}
	public void setTrataArquivo(TrataArquivoRN trataArquivo) {
		this.threadTrataArquivo = trataArquivo;
	}

	public String getPathRelativo() {
		return pathRelativo;
	}

	public void setPathRelativo(String pathRelativo) {
		this.pathRelativo = pathRelativo;
	}

	public String getNomeMaquina() {
		return icupdto.getUpDTO().getCd_up();
	}
	
	public String getUrlConexao() {
		return icupdto.getUrlConexao();
	}
	
	public String getUrlAuxiliar() {
		return icupdto.getUrlAuxiliar();
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if(IcUpDTO.class.isAssignableFrom(obj.getClass())) {
	    	final IcUpDTO other = (IcUpDTO) obj;
		    if ((this.getNomeMaquina() == null) ? (other.getUpDTO().getCd_up() != null) : !this.getNomeMaquina().equals(other.getUpDTO().getCd_up())) {
		        return false;
		    }
		    if ((this.getUrlConexao() == null) ? (other.getUrlConexao() != null) : !this.getUrlConexao().equals(other.getUrlConexao())) {
		        return false;
		    }
		    if ((this.getUrlAuxiliar() == null) ? (other.getUrlAuxiliar() != null) : !this.getUrlAuxiliar().equals(other.getUrlAuxiliar())) {
		        return false;
		    }
		    return true;
	    }
	    if (ColetaArquivoMaquina.class.isAssignableFrom(obj.getClass())) {
		    final ColetaArquivoMaquina other = (ColetaArquivoMaquina) obj;
		    if ((this.getNomeMaquina() == null) ? (other.getNomeMaquina() != null) : !this.getNomeMaquina().equals(other.getNomeMaquina())) {
		        return false;
		    }
		    if ((this.getUrlConexao() == null) ? (other.getUrlConexao() != null) : !this.getUrlConexao().equals(other.getUrlConexao())) {
		        return false;
		    }
		    if ((this.getUrlAuxiliar() == null) ? (other.getUrlAuxiliar() != null) : !this.getUrlAuxiliar().equals(other.getUrlAuxiliar())) {
		        return false;
		    }
		    return true;
	    }
	    return false;

	}
	
}
