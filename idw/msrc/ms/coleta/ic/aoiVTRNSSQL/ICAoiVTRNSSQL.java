package ms.coleta.ic.aoiVTRNSSQL;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import idw.model.dao.aoivtrns.AoiVtrnsRN;
import idw.model.pojos.OmCfg;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class ICAoiVTRNSSQL implements IIC {
	private final IcDTO icdto;
	private final int _INTERVALO_LEITURAS = 10; // 10 segundos

	private Date dthrColeta = null;
	
	private ArquivoUltimoID ultimoID = null;

	public ICAoiVTRNSSQL(IcDTO icdto) {
		super();
		this.icdto = icdto;
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		EventosColetados retorno = new EventosColetados();

		Date dthrAtual = DataHoraRN.getDataHoraAtual();
		if (this.dthrColeta == null) {
			this.dthrColeta = DataHoraRN.getDataHoraAtual();
		}
		int et = DataHoraRN.getQuantidadeSegundosNoPeriodo(this.dthrColeta, dthrAtual);
		if (et > _INTERVALO_LEITURAS) {
			this.dthrColeta = dthrAtual;
			AoiVtrnsRN rn = new AoiVtrnsRN();

			for (IcUpDTO updto : icdto.getMsIcUpDTOLocais()) {
				EventosColetados eventos = rn.obterEventos(updto, updto.getUrlConexao(), ultimoID.getUltimoID(updto.getUpDTO().getCd_up()));
				retorno.addEventosColetados(eventos.getEventosColetados());
				
				
				// Se nao houverem eventos, acrescentar o evento de heartbeat
				if (retorno.getEventosColetados().isEmpty()) {
					EventoColetado evHB = new EventoColetado();
					evHB.setDthrEvento(DataHoraRN.getDataHoraAtual());
					evHB.setTipoEvento(ServicoFactory._IC_HEART_BEAT);
					evHB.setIcUpDTO(updto);
					evHB.setExisteEvento(true);
					retorno.addEventoColetado(evHB);
				} else {
					// Caso tenha eventos entao setar o ultimo id se for maior que zero
					if (eventos.getUltimoID().compareTo(BigDecimal.ZERO) > 0) {
						ultimoID.setUltimoID(updto.getUpDTO().getCd_up(), eventos.getUltimoID());
						ultimoID.saveUltimoID(icdto);
					}
				}
			}
		}
		return retorno;
	}

	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
		this.ultimoID = new ArquivoUltimoID(Stubedelegate.getInstancia().getMsthread().getPathCacheColeta());
		this.ultimoID.loadUltimoID(icdto);
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return getVersaoIC();
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		return "v1.0";
	}

	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {
	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
	}

	@Override
	public void setParametro(ParametroDTO parametro) {
	}

}
