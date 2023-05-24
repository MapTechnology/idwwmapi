package ms.coleta.ic;

import idw.model.pojos.OmCfg;
import idw.util.IdwLogger;

import java.util.List;

import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.excessao.SemComunicacaoICException;

public interface IIC {
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException;
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException;
	public void finalizaIC() throws SemComunicacaoICException;
	public String getVersaoDriver() throws SemComunicacaoICException;
	public String getVersaoIC() throws SemComunicacaoICException;
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros);
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro);
	
	public void setParametro(ParametroDTO parametro);
}
