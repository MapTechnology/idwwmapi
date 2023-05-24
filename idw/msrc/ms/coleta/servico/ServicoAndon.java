package ms.coleta.servico;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import ms.coleta.andon.AndonIC;
import ms.coleta.andon.AndonRN;
import ms.coleta.dto.AndonDTO;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.dto.ParametroDTO;
import ms.excessao.ServicoFalhouException;

public class ServicoAndon implements IServico {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		IdwLogger log = mensagem.getLog();

		log.info("INICIO - Servico ANDON ");

		List<AndonDTO> dadosAndonProcessados = null;
		if(mensagem.getDadosIcDTO().getUltimosParametrosAndon() == null || mensagem.getDadosIcDTO().getUltimosParametrosAndon().size() <= 0){
			mensagem.getDadosIcDTO().setUltimosParametrosAndon(new ArrayList<AndonDTO>());
			log.info("inicializaParametrosAndon");
			inicializaParametrosAndon(mensagem.getDadosIcDTO().getUltimosParametrosAndon());
		}

		List<AndonDTO> ultimosParametrosAndon = mensagem.getDadosIcDTO().getUltimosParametrosAndon();
		List<ParametroDTO> listaParametrosDriver = new ArrayList<ParametroDTO>();
		AndonIC andonIc = new AndonIC();
		AndonRN andonRn = new AndonRN(mensagem.getIc());

		log.info("Verificando EventosAndonAtivos");

		dadosAndonProcessados = andonIc.verificaEventosAndonAtivos(mensagem.getDadosIcDTO());

		log.info("Qt. EventosAndonAtivos encontrados = " + dadosAndonProcessados.size());

		if(andonRn.processaEventosAndon(dadosAndonProcessados, ultimosParametrosAndon, listaParametrosDriver) == true) {
			log.info("Lista com parametros para o driver criada. Qtde " + listaParametrosDriver.size());
			mensagem.getIc().setDadosParametrosSaida(listaParametrosDriver);
			log.info("Lista de Parametros de Andon atualizada no driver.");
		}
		else{
			log.info("Sem processamentoEventosAndon.");
		}
		
		return null;
	}
	
	private void inicializaParametrosAndon(List<AndonDTO> parametrosAndon) {
	    AndonDTO andonAux;
//	    parametrosAndon = new ArrayList<AndonDTO>();
	    for (int i = 0; i < 16; i++)
	    {
	        andonAux = new AndonDTO();
	        andonAux.setIdeventoandon(0);
	        andonAux.setIdup("");
	        andonAux.setTpeventoandon(0);
	        andonAux.setIdrele(i + 1);
	        andonAux.setIdreleaux("");
	        andonAux.setPrioridade(Integer.MAX_VALUE - 1);
	        andonAux.setStintermitente(0);
	        andonAux.setTmpsinalalto(0);
	        andonAux.setTmpsinalbaixo(0);
	        andonAux.setStativo(0);	        
	        parametrosAndon.add(andonAux);
	    }
	}
}
