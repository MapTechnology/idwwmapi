package ms.coleta.servico;

import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import idw.webservices.dto.DadosProdutoSADTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.MsFacade;
import ms.model.dto.EventoColetado;
import ms.model.dto.OPAutomaticaDTO;

public class ServicoCriaOPAutomatica implements IServico, IProtocoloNovo {

	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {

		if(mensagem.getEventoColetado().getQtde() == null || mensagem.getEventoColetado().getCdFolha() == null || mensagem.getEventoColetado().getUp() == null || mensagem.getEventoColetado().getDthrEvento() == null) {
			throw new ServicoFalhouException(null);
		}
		
		IdwLogger log = mensagem.getLog();
		int idLog = mensagem.getIdLog();
		int identacao = mensagem.getIdentacao();
		
		log.iniciaAvaliacao(idLog, "Chamando ServicoCriaOPAutomatica");
		
		log.info(idLog, identacao,"ServicoCriaOPAutomatica INI");
		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		Date iniDate = mensagem.getEventoColetado().getDthrEvento();
		
		//System.out.println("qtde="+mensagem.getEventoColetado().getQtde());
		//System.out.println("cdfolha="+mensagem.getEventoColetado().getCdFolha());
		//System.out.println("up="+mensagem.getEventoColetado().getUp());
		//System.out.println("dthrevento="+mensagem.getEventoColetado().getDthrEvento());
		
		EventoColetado evt = mensagem.getEventoColetado();
//		evt.setQtde(mensagem.getQtde());
//		evt.setCdFolha(mensagem.getCdFolha());
//		evt.setUp(mensagem.getUp());
//		evt.setDthrEvento(iniDate);
		
		OPAutomaticaDTO opDTO = MsFacade.getInstancia().criaOPAutomatica(evt);
		
		MensagemEnviada m = new MensagemEnviada(mensagem);
		
		if(opDTO != null) {
			m.setNrOp(opDTO.getNrDoc());
			m.setQtd(opDTO.getQtdPlanejada());
			m.setCdProduto(opDTO.getCdProduto());
			m.setCdFolha(opDTO.getCdFolha());
			m.setIdFolha(opDTO.getIdFolha());
			m.setCicloPadrao(opDTO.getCicloPadrao());
			m.setCicloTimeout(opDTO.getCicloTimeout());
			m.setCicloMinimo(opDTO.getCicloMinimo());
			m.setTimeoutCIP(opDTO.getTimeoutCIP());
			m.setQtdPorCiclo(opDTO.getQtdPcsPorCiclo());
			m.setListaProdutosDTO(opDTO.getListaProdutos());
			m.setOpCriadaComSucesso(true);
		} else {
			m.setOpCriadaComSucesso(false);
		}
		
		log.info(idLog, identacao, "ServicoCriaOPAutomatica para " + mensagem.getIp() );

		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, m, idLog, identacao);

		log.paraAvaliacao();
		log.info("ServicoCriaOPAutomatica - FIM " + log.getAvaliacaoCompleta());
		
		return null;
	}


	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		retorno.setCdFolha(evtArgs.get("1"));
		retorno.setQtde(evtArgs.get("2"));
		//System.out.println("CdFolha=" + retorno.getCdFolha());
		//System.out.println("Qtde=" + retorno.getQtde());
	}
	

	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		if(mensagem.isOpCriadaComSucesso() == true) {
			StringBuilder sb = new StringBuilder();
			sb.append("[resp]\nst=0\nn=10\n");
			sb.append("1=").append(mensagem.getNrOp() + "\n");
			sb.append("2=").append(mensagem.getCdProduto() + "\n");
			sb.append("3=").append(mensagem.getIdFolha() + "\n");
			sb.append("4=").append(mensagem.getCdFolha() + "\n");
			sb.append("5=").append(mensagem.getCicloPadrao() + "\n");
			sb.append("6=").append(mensagem.getCicloTimeout() + "\n");
			sb.append("7=").append(mensagem.getCicloMinimo() + "\n");
			sb.append("8=").append(mensagem.getQtdPorCiclo() + "\n");
			if(mensagem.getListaProdutosDTO() != null)
				sb.append("9=").append(mensagem.getListaProdutosDTO().size() + "\n");
			else
				sb.append("9=").append("0\n");
			sb.append("10=").append(mensagem.getTimeoutCIP() + "\n");
			for(int i = 0; i<mensagem.getListaProdutosDTO().size(); i++) {
				DadosProdutoSADTO produto = mensagem.getListaProdutosDTO().get(i);
				sb.append("[prod").append((i+1) + "]\n");
				sb.append("cd=").append(produto.getCdProduto() + "\n");
				sb.append("idrdz=").append(produto.getIdredzproduto() + "\n");
				sb.append("qtdporcic=").append(produto.getQtAtiva() + "\n");
			}
			return sb.toString();
		} else {
			return "[resp]\nst=1\n";
		}
	}

}
