package ms.coleta.servico;

import java.util.Date;
import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.util.IdwLogger;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.ClienteRegistrado;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.IhmDesconhecidoException;
import ms.excessao.MsDesconhecidoException;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.MsDTO;

public class ServicoRegistro implements IServico, IProtocoloNovo {
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		
		IdwLogger log = mensagem.getLog();
		int idLog = log.getIdAleatorio();
		int identacao = mensagem.getIdentacao();
		MsDTO msdto = null;
		
		log.iniciaAvaliacao("Servico Registro " + mensagem.getUrlConexaoIhm());
		log.info(idLog, 10, "Servico REGISTRO - INI");

		ClienteRegistrado cliente = new ClienteRegistrado();
		cliente.setIp(mensagem.getIp());
		cliente.setPorta(mensagem.getPorta());
		
		cliente.setUrlConexao(mensagem.getUrlConexaoIhm());
		if(mensagem.getSessaows() != null){
			cliente.setSessaoWs(mensagem.getSessaows());
		}
		
		if (ServicoFactory.getInstancia().isClienteRegistrado(cliente) == false) {
			// Chama webservice para incluir no banco o registro do IHM
			log.info(idLog, 10, "Registrando NOVO cliente " + cliente.getUrlConexao());
			try {
				msdto = Stubedelegate.getInstancia().registraIhm(cliente);
			} catch (MsDesconhecidoException e) {
				throw new ServicoFalhouException(e);
			} catch (IhmDesconhecidoException e) {
				MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);
				mensagemEnviada.setIhmDesconhecido(true);
				Stubedelegate.getInstancia().enviaMensagemParaClientesDesconhecido(mensagemEnviada);
			}

			ServicoFactory.getInstancia().addClienteRegistrado();
			ServicoFactory.getInstancia().addCliente(cliente);

			// As linhas abaixo foram comentadas pois eh mais eficiente mandar
			// as mensagens para os IHMs registrados
			// sequencialmente ao inves de thread
			//
			//MensagemEnviada mensagemEnviada = new MensagemEnviada();
			//mensagemEnviada.setRecebidoComSucesso(true);
			// ServicoFactory.getInstancia().adicionaMensagemASerEnviadaTcp(mensagemEnviada);
			// new ClienteTcp().enviaParaCliente(cliente, mensagemEnviada);
		} else {
			log.info(idLog, 10, "Registrando novamente cliente " + cliente.getUrlConexao());
			try {
				msdto = Stubedelegate.getInstancia().registraIhm(cliente);
			} catch (MsDesconhecidoException e) {
				throw new ServicoFalhouException(e);
			} catch (IhmDesconhecidoException e) {
				MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);
				mensagemEnviada.setIhmDesconhecido(true);
				Stubedelegate.getInstancia().enviaMensagemParaClientesDesconhecido(mensagemEnviada);
			}

			ServicoFactory.getInstancia().updateCliente(cliente);
		}
		
		// Nesse momento, independente se o cliente foi registrado ou se ja estava registrado devemos mandar a informa��o
		// do status da m�quina parada e o motivo FOR parada nao informada
		// Isso deve ser feito para todas as UPs gerenciadas pelo IHM
		// 1o Passo: Identifica os ics e ups afetados
		// Alessandre: 29-8-14 acredito q o trecho abaixo nao eh mais necessario
		/*
		if (mensagem.getListaDadosIcDTO() != null){ // se for null eh pq nao tem nenhum 
			for (IcDTO dadosicdto : mensagem.getListaDadosIcDTO()){
				for (IcUpDTO icupdto : dadosicdto.getMsIcUpDTOLocais()){
					for (UpIhmDTO upihmdto : icupdto.getUpDTO().getUpihmColetados()){
						if (upihmdto.getIhm().getUrl_Conexao().equals(cliente.getUrlConexao())){
							//System.out.println("Atualizando em clienteregistrado a up " + icupdto.getUpDTO().getCd_up());
							cliente.addUpDTO(icupdto.getUpDTO());
							// 2o Passo: Testa se a Up est� parada sem motivo informado
							if (icupdto.getUpDTO().isUpParada() == true && ( icupdto.getUpDTO().getCdParada() == null || icupdto.getUpDTO().getCdParada().equals("")) ){
							}
						}
					}
				}
			}
		}*/
		
		// Enviar para o ihm a sessao inicializada
		log.info(idLog, 10, "Mandando SESSAO para clientes REGISTRADOS");
		
		MensagemEnviada mensagemEnviada = new MensagemEnviada(msdto, mensagem);
		Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, mensagemEnviada, idLog, identacao);
		//Stubedelegate.getInstancia().enviaMensagemParaIhmSolicitante(mensagem.getIp(), mensagemEnviada);
		//Stubedelegate.getInstancia().enviaMensagemParaClientesRegistrados(idLog, 10, mensagemEnviada);
		
		log.paraAvaliacao();
		log.info(idLog, 10, "Servico REGISTRO - FIM - " + log.getAvaliacaoCompleta());
		
		return null;

	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
	}

	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		return "[resp]\nst=0\n";
	}
	
	public static String diferencaEmHoras(Date dataInicial, Date dataFinal){  
		StringBuilder data = new StringBuilder();

		long diferenca = dataFinal.getTime() - dataInicial.getTime();  
		long diferencaEmHoras = (diferenca /1000) / 60 / 60;  
		long minutosRestantes = (diferenca / 1000)/60 %60;  
		long segundosRestantes = (diferenca / 1000) % (60);  


		data.append(diferencaEmHoras < 10 ? "0" + diferencaEmHoras + ":" : diferencaEmHoras  + ":" ); 	        
		data.append(minutosRestantes < 10 ? "0" + minutosRestantes + ":" : minutosRestantes + ":"  );
		data.append(segundosRestantes < 10 ? "0" + segundosRestantes  : segundosRestantes   );

		return data.toString();  
	}  

}
