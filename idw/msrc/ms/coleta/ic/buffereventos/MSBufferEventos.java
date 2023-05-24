package ms.coleta.ic.buffereventos;
import idw.model.pojos.OmCfg;
import idw.util.IdwLogger;

import java.util.List;

import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.MsBufferEventosIcUpDTO;
	
public class MSBufferEventos implements IIC {
	private IcDTO msgerenciado;

	public MSBufferEventos(IcDTO msgerenciado) {
		this.msgerenciado = msgerenciado;
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) {
		EventosColetados evs = new EventosColetados();	
			// Espera o tempo estipulado entre os eventos (5 segundos)
		try {
			Thread.sleep(10000);
			if(MSBufferEventosFacade.getInstancia().isTratandoMsBufferEventosIcUpDTO()){
				MsBufferEventosIcUpDTO MsBufferEventosIcUpDTO=null;
				for (IcUpDTO icupdto : this.msgerenciado.getMsIcUpDTOLocais()) {	
					MsBufferEventosIcUpDTO=MSBufferEventosFacade.getInstancia().
							getMsBufferEventosIcUpDTO(icupdto.getUpDTO().getIdUpPDBA());
					if(MsBufferEventosIcUpDTO==null)
						continue;
					evs.addEventosColetados(MsBufferEventosIcUpDTO.cropEventosColetados());
				}
			}			
		} catch (Exception e) {
		}		
		return evs;
	}
	
	@Override
	public void inicializaIC(IdwLogger log) {
		// Nao existe necessidade de inicializacao para o driver do IC virtual
	}
	
	@Override
	public void finalizaIC() {
		
	}
	
	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return null;
	}
	
	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		return "MSBufferEventos";
	}
	
	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {
		
	}
	
	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
		
	}
	
	@Override
	public void setParametro(ParametroDTO parametro) {
		// TODO Auto-generated method stub
			
	}
}
