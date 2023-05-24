package ms.coleta.ic.virtual;

import java.util.List;

import idw.model.pojos.OmCfg;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class MSVirtual implements IIC {
	private IcDTO msgerenciado;
	private int ponteiroEvento = -1;

	public MSVirtual(IcDTO msgerenciado) {
		this.msgerenciado = msgerenciado;
	}

	@Override
	public EventosColetados getEventos(OmCfg omcfg) {
		// Espera o tempo estipulado entre os eventos (5 segundos)
		try {
			Thread.sleep(10000);
			//Thread.sleep(300000);
		} catch (Exception e) {
		}

		EventosColetados evs = new EventosColetados();

		for (IcUpDTO IcUpDTO : this.msgerenciado.getMsIcUpDTOLocais()) {
			
			// Envia o evento determinado para a vez
			ponteiroEvento++;
			
			switch (ponteiroEvento){
			case 0:
//				EventoColetado evCiclo = new EventoColetado();
//				evCiclo.setTipoEvento(ServicoFactory._FIM_CICLO);
//				evCiclo.setDthrEvento(DataHoraRN.getDataHoraAtual());
//				evCiclo.setIcUpDTO(IcUpDTO);
//				evCiclo.setExisteEvento(true);
//				evCiclo.setQtde("6");
//				evs.addEventoColetado(evCiclo);
				
				break;
			case 1:
				EventoColetado evCiclo2 = new EventoColetado();
				evCiclo2.setTipoEvento(ServicoFactory._FIM_CICLO);
				evCiclo2.setDthrEvento(DataHoraRN.getDataHoraAtual());
				evCiclo2.setIcUpDTO(IcUpDTO);
				evCiclo2.setExisteEvento(true);
				evCiclo2.setQtde("6");
				evs.addEventoColetado(evCiclo2);
				break;
			case 2:
				EventoColetado evCiclo3 = new EventoColetado();
				evCiclo3.setTipoEvento(ServicoFactory._FIM_CICLO);
				evCiclo3.setDthrEvento(DataHoraRN.getDataHoraAtual());
				evCiclo3.setIcUpDTO(IcUpDTO);
				evCiclo3.setExisteEvento(true);
				evCiclo3.setQtde("6");
				evs.addEventoColetado(evCiclo3);
				//ponteiroEvento = 0;
				break;
			case 3:
				EventoColetado evParada = new EventoColetado();
				evParada.setTipoEvento(ServicoFactory._INICIO_PARADA);
				evParada.setDthrEvento(DataHoraRN.getDataHoraAtual());
				evParada.setIcUpDTO(IcUpDTO);
				evParada.setExisteEvento(true);
				evs.addEventoColetado(evParada);
				break;
			case 4:
//				EventoColetado evTemp = new EventoColetado();
//				evTemp.setTipoEvento(ServicoFactory._MEDICAO_CCK);
//				evTemp.setDthrEvento(DataHoraRN.getDataHoraAtual());
//				Random gerador = new Random();
//				IwsDadosCCKDTO dadosCCK = new IwsDadosCCKDTO(
//						new BigDecimal(gerador.nextInt(1000)),
//						new BigDecimal(1),
//						new BigDecimal(gerador.nextInt(1000)),
//				new BigDecimal(gerador.nextInt(1000)),new BigDecimal(gerador.nextInt(1000)),new BigDecimal(gerador.nextInt(1000)),new BigDecimal(gerador.nextInt(1000)),
//				new BigDecimal(gerador.nextInt(1000)),new BigDecimal(gerador.nextInt(1000)),new BigDecimal(gerador.nextInt(1000)),
//				new BigDecimal(gerador.nextInt(1000)),new BigDecimal(gerador.nextInt(1000)),new BigDecimal(gerador.nextInt(1000)), new BigDecimal(gerador.nextInt(1000)));
//				evTemp.setDadosCCK(dadosCCK);
//				evTemp.setIcUpDTO(IcUpDTO);
//				evTemp.setExisteEvento(true);
////				evs.addEventoColetado(evTemp);
				break;
			case 5:
				EventoColetado evParada2 = new EventoColetado();
				evParada2.setTipoEvento(ServicoFactory._FIM_PARADA);
				evParada2.setDthrEvento(DataHoraRN.getDataHoraAtual());
				evParada2.setIcUpDTO(IcUpDTO);
				evParada2.setExisteEvento(true);
				evs.addEventoColetado(evParada2);
				break;
			case 6:
				EventoColetado evHB = new EventoColetado();
				evHB.setTipoEvento(ServicoFactory._IC_HEART_BEAT);
				evHB.setDthrEvento(DataHoraRN.getDataHoraAtual());
				evHB.setIcUpDTO(IcUpDTO);
				evHB.setExisteEvento(true);
				evs.addEventoColetado(evHB);
				break;			
			default:
				ponteiroEvento = -1;
			}
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
		return "MSVirtual";
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
