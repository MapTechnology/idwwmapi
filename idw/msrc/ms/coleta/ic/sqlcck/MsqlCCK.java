package ms.coleta.ic.sqlcck;

import idw.model.dao.cck.DAOGenericoCck;
import idw.model.pojos.OmCfg;
import idw.model.pojos.cck.CampoMemoria;
import idw.model.pojos.cck.Equipamento;
import idw.model.pojos.cck.Medicao;
import idw.model.pojos.cck.MemoriaMassa;
import idw.util.IdwLogger;

import java.math.BigDecimal;
import java.util.List;

import ms.coleta.dto.EventosColetados;
import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.IIC;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.SemComunicacaoICException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class MsqlCCK implements IIC{

	private IcDTO icdto = null;
	
	public MsqlCCK(IcDTO icdto) {
		this.icdto = icdto;
	}
	
	@Override
	public EventosColetados getEventos(OmCfg omcfg) throws SemComunicacaoICException {
		EventosColetados retorno = new EventosColetados();
		Equipamento equipamento;
		Medicao medicao;
		CampoMemoria campoMemoria = null;
		CckRN rn = new CckRN(new DAOGenericoCck());
		
		rn.iniciaConexaoBanco();
		
		for (IcUpDTO icupdto : icdto.getMsIcUpDTOLocais()) {
			EventoColetado evento = new EventoColetado();
			
			equipamento = rn.getEquipamentos(icupdto);
			if(equipamento != null){
				medicao = rn.getRegistrosMedicao(equipamento);
				if (medicao != null){
					campoMemoria = rn.getCampoMemoria(medicao);
				}
			}
			
			List<MemoriaMassa> listaMemoriaMassa = rn.getMemoriaMassa(campoMemoria);
			for(MemoriaMassa memoria : listaMemoriaMassa){
				try{
					evento.setParametroLido(new BigDecimal(memoria.getValor()));
					evento.setDthrEvento(memoria.getId().getDatahora());
					evento.setTipoEvento(ServicoFactory._MEDICAO_TEMPERATURA);
					evento.setIcUpDTO(icupdto);
					retorno.addEventoColetado(evento);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		rn.finalizaConexaoBanco();
		
		return retorno;
	}

	@Override
	public void inicializaIC(IdwLogger log) throws SemComunicacaoICException {
	}

	@Override
	public void finalizaIC() throws SemComunicacaoICException {
	}

	@Override
	public String getVersaoDriver() throws SemComunicacaoICException {
		return "v.1.0";
	}

	@Override
	public String getVersaoIC() throws SemComunicacaoICException {
		return "desconhecido";
	}

	@Override
	public void setDadosParametrosSaida(List<ParametroDTO> listaParametros) {
	}

	@Override
	public void setUnicoDadoParametroParametroSaida(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParametro(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		
	}

}
