package ms.coleta.servico;

import java.util.Date;
import java.util.Map;

import org.hibernate.Session;

import idw.model.pojos.MsEvt;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DadosProdutoSADTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.AndonSADTO;
import ms.coleta.dto.MensagemEnviada;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.dto.SessaoAlertaDTO;
import ms.coleta.dto.SessaoAlertasDTO;
import ms.coleta.dto.SessaoAndonDTO;
import ms.coleta.dto.SessaoCalendarioDTO;
import ms.coleta.dto.SessaoCfgDTO;
import ms.coleta.dto.SessaoICDTO;
import ms.coleta.dto.SessaoOPDTO;
import ms.coleta.dto.SessaoParadaDTO;
import ms.coleta.dto.SessaoRefugoDTO;
import ms.coleta.dto.SessaoUPDTO;
import ms.coleta.dto.SessaoUsuarioDTO;
import ms.coleta.dto.SessaoUsuariosDTO;
import ms.coleta.dto.SessaoVarRitmoDTO;
import ms.coleta.protocolo.IProtocoloNovo;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;

public class ServicoIcHeartBeat implements IServico, IProtocoloNovo{
	
	@Override
	public MsEvt executaServico(Session sessao, MensagemRecebida mensagem) throws ServicoFalhouException {
		try{
			IdwLogger log;
			String cdIc;
			try {
				log = new IdwLogger(mensagem.getEventoColetado().getIcUpDTO().getIc().getCd_ic() + "_HEARTBEAT");
				cdIc = mensagem.getEventoColetado().getIcUpDTO().getIc().getCd_ic();
			} catch (NullPointerException e) {
				return null;
			}
			Stubedelegate.getInstancia().addContador();
			int idLog = log.getIdAleatorio();
			int identacao = mensagem.getIdentacao();
			
			log.iniciaAvaliacao(idLog, "Servico ICHeartBeat para " + cdIc);
			log.info(idLog, 0, "Servico ICHeartBeat - INI para "+ cdIc +" em " + mensagem.getEventoColetado().getDthrEventoFormatadoParaEnvio() + " - " + Stubedelegate.getInstancia().getContador());
			
			EventoColetado ev = mensagem.getEventoColetado();
			ev.setLog(log);
			
			// Chama web-service IcHeartBeat
			String urlIC=mensagem.getEventoColetado().getIcUpDTO().getIc().getCd_ic();

			Stubedelegate.getInstancia().icHeartBeat(idLog, urlIC, ev);
			
			MensagemEnviada mensagemEnviada = new MensagemEnviada(mensagem);
			if(mensagem.isNecessitaResposta() == true) {
				try {
					IcDTO icDTO = mensagem.getEventoColetado().getIcUpDTO().getIc();
					SessaoICDTO sessaoICDTO = Stubedelegate.getInstancia().getSessaoIC(icDTO);
					mensagemEnviada.setSessaoIC(sessaoICDTO);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			Stubedelegate.getInstancia().enviaMensagemRespostaCasoNecessario(mensagem, mensagemEnviada, idLog, identacao);
			
			log.paraAvaliacao(ev.getIdEvt());
			log.info(idLog, 0, "Servico ICHeartBeat - FIM para " + mensagem.getIp() + " em " + ev.getDthrEventoFormatadoParaEnvio() + log.getAvaliacaoCompleta());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void parseEvtArgs(EventoColetado retorno, Map<String, String> evtArgs) {
		//IP do IC
		//evtArgs.get("1");
		retorno.setQtdEventosPendentes(evtArgs.get("2"));
	}

	private String montaMensagemConfiguracaoGeral(SessaoCfgDTO cfg) {
		String mensagem = "";
		mensagem +="[cfgdefault]\n";
		mensagem +="id=" + cfg.getIdCfg() + "\n";
		mensagem +="login_obrigatorio=" + cfg.isLoginObrigatorio() + "\n";
		mensagem +="masc_cb="+ cfg.getMascaraCb() +"\n";
		mensagem +="reqteccipini="+  cfg.isRequerTecnicoInicioCIP() +"\n";
		mensagem +="reqteccipfim="+ cfg.isRequerTecnicoFimCIP() +"\n";
		mensagem +="cdparada=" + cfg.getCdParadaDefault() +"\n";
		mensagem +="dsparada=" + cfg.getDsParadaDefault() +"\n";
		mensagem +="cdparadacip=" + cfg.getCdParadaCIPDefault() +"\n";
		mensagem +="dsparadacip=" + cfg.getDsParadaCIPDefault() +"\n";
		mensagem +="cdalertacip=" + cfg.getCdAlertaCIPDefault() +"\n";
		mensagem +="cdritmo=" + cfg.getCdRitmoDefault() +"\n";
		mensagem +="dsritmo=" + cfg.getDsRitmoDefault() +"\n";
		return mensagem;
	}
	
	private String montaMensagemAndon(SessaoAndonDTO andon) {
		String mensagem = "";
		mensagem +="[andon]\n";
		mensagem +="id=" + andon.getIdAndon() + "\n";
		mensagem +="n=" + andon.getListaAndonSA().size() + "\n";
		int indiceRegraAndon = 1;
		for(AndonSADTO regra : andon.getListaAndonSA())
			mensagem +=indiceRegraAndon++ + "=" + regra.getLinha() + "\n";
		return mensagem;
	}
	
	private String montaMensagemCalendario(SessaoCalendarioDTO calendario, int indicePt) {
		String mensagem = "";
		if(calendario == null || calendario.getViradasDeTurno() == null)
			return mensagem;
		mensagem +="[pt"+ indicePt + "cal]\n";
		mensagem +="id=" + calendario.getIdCal()+"\n";
		int numQuebrasTurnos = calendario.getViradasDeTurno().size();
		mensagem +="n=" + numQuebrasTurnos + "\n";
		int indiceViradaDeTurno = 1;
		for(Date viradaDeTurno : calendario.getViradasDeTurno())
			mensagem +=indiceViradaDeTurno++ + "=" + DataHoraRN.dateToStringDDMMYYYYHHMMSSms(viradaDeTurno) +"\n";
		return mensagem;
	}
	
	private String montaMensagemUsuarios(SessaoUsuariosDTO usuarios, int indicePt) {
		String mensagem = "";
		if(usuarios == null || usuarios.getListaUsuarios() == null)
			return mensagem;
		mensagem +="[pt" + indicePt + "login]\n";
		int numLogins = usuarios.getListaUsuarios().size();
		mensagem +="id=" + usuarios.getMaiorIdConsolmolog() + "\n";
		mensagem +="n=" + numLogins + "\n";
		int indiceLogin = 0;
		for(SessaoUsuarioDTO usuario : usuarios.getListaUsuarios()) {
			indiceLogin++;
			mensagem +="cd" + indiceLogin + "="+ usuario.getCdUsuario() +"\n";
			mensagem +="nome" + indiceLogin + "="+ usuario.getDsNome() +"\n";
			mensagem +="ini" + indiceLogin + "="+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(usuario.getDthrILogin()) +"\n";
			mensagem +="dur" + indiceLogin + "="+ ServicoRegistro.diferencaEmHoras(usuario.getDthrILogin(), DataHoraRN.getDataHoraAtual() ) +"\n";
		}
		return mensagem;
	}
	
	private String montaMensagemOP(SessaoOPDTO op, int indicePt) {
		String mensagem = "";
		if(op == null)
			return mensagem;
		mensagem +="[pt" + indicePt + "op]\n";
		mensagem +="id=" + op.getUltimoIdEvtOP() + "\n";
		if (op.getNrop() != null && op.getNrop().equals("null") == false) {
			mensagem +="nrop="+ op.getNrop() +"\n";
			mensagem +="filial=" + op.getFilial() + "\n";
		} else {
			mensagem +="nrop=SEM OP\n";
			mensagem += "filial=\n";
		}
		mensagem +="cdfolha=" + op.getCdFolha() +"\n";
		mensagem +="idfolha=" + op.getIdFolha() +"\n";
		mensagem +="cdproduto=" + op.getCdproduto() +"\n";
		mensagem +="ciclos="+ op.getQtdeCiclos() +"\n";
		mensagem +="liqui="+ (op.getQtdePro() - op.getQtdeRef()) +"\n";
		mensagem +="plan="+ op.getProducaoPlanejada() +"\n";
		mensagem +="cicpadrao=" + op.getCicloPadrao()*1000 +"\n";
		mensagem +="cictimeout=" + op.getCicloTimeout() +"\n";
		mensagem +="cicmin=" + op.getCicloMinimo()*1000 +"\n";
		mensagem +="qtdporcic=" + op.getQtdPcsPorCiclo() +"\n";
		mensagem +="stcip="+ op.getCipStatus() +"\n";
		mensagem +="inicip="+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(op.getDthrICip()) +"\n";
		mensagem +="timeoutcip=" + op.getTempoSetup() +"\n";
		mensagem +="isalertacipjaaberto=" + op.isAlertaCipJaAberto() +"\n";
		mensagem +="isfinalserie=" + op.isFinalSerie() +"\n";
		mensagem +="fatorcontagem=" + op.getQtFatorContagem() +"\n";
		mensagem +="pacoteciclo=" + op.getQtPacoteCiclo() +"\n";
		
		mensagem +="[pt" + indicePt + "opprod]\n";
		
		int numProdutos = op.getQtdProdutos();
		mensagem +="n=" + numProdutos + "\n";
		int indiceProduto = 0;
		if(op.getListaProdutos() != null) {
			for (DadosProdutoSADTO produto : op.getListaProdutos()){
				indiceProduto++;
				mensagem +="cd" + indiceProduto + "="+ produto.getCdProduto() +"\n";
				mensagem +="plan" + indiceProduto + "="+ produto.getPcsProducaoplanejada() +"\n";
				mensagem +="liqui" + indiceProduto + "="+ produto.getPcsProducaobruta().subtract(produto.getPcsProducaorefugada()) +"\n";
				if(op.getListaProdutosHoraTurno() != null) {
					for(DadosProdutoSADTO produtoHr : op.getListaProdutosHoraTurno()) {
						if(produtoHr.getCdProduto().equals(produto.getCdProduto())) {
							mensagem +="liquihr" + indiceProduto + "="+ produtoHr.getPcsProducaobruta().subtract(produtoHr.getPcsProducaorefugada()) +"\n";
							break;
						}
					}
				}
				mensagem +="idrdz" + indiceProduto + "=" + produto.getIdredzproduto() +"\n";
				mensagem +="qtdporcic" + indiceProduto + "=" + produto.getQtAtiva() +"\n";
			}
		}
		return mensagem;
	}
	
	private String montaMensagemParada(SessaoParadaDTO parada, int indicePt) {
		String mensagem = "";
		if(parada == null)
			return mensagem;
		mensagem +="[pt" + indicePt + "parada]\n";
		mensagem +="id=" + parada.getIdConsolpalog() + "\n";
		mensagem +="st="+ parada.isParado() +"\n";
		mensagem +="idtparada=" + parada.getIdTParada() +"\n";
		mensagem +="cd="+ parada.getCdParada() +"\n";
		mensagem +="ds="+ parada.getDsParada() +"\n";
		mensagem +="ini="+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(parada.getDthrIParada()) +"\n";
		mensagem +="reqcancel="+ parada.isRegulagem() +"\n";
		mensagem +="permitecorrecao="+ parada.isPermiteCorrecao() +"\n";
		mensagem +="regulagem="+ parada.isRegulagem() +"\n";
		mensagem +="emaberto="+ parada.isParado() +"\n";
		mensagem +="timeoutalerta="+ parada.getTimeoutAlerta() +"\n";
		mensagem +="cdalertatimeout="+ parada.getCdAlerta() +"\n";
		mensagem +="extrapolacao="+ parada.getExtrapolacao() +"\n";
		mensagem +="cdparadaextra="+ parada.getCdParadaExtra() +"\n";
		return mensagem;
	}
	
	private String montaMensagemRefugo(SessaoRefugoDTO refugo, int indicePt) {
		String mensagem = "";
		if(refugo == null)
			return mensagem;
		mensagem +="[pt" + indicePt + "ref]\n";
		mensagem +="id=" + refugo.getIdConsolrelog() + "\n";
		mensagem +="idtrefugo=" + refugo.getIdTMotivo() + "\n"; 
		mensagem +="cd="+ refugo.getCdRefugo() +"\n";
		mensagem +="ds="+ refugo.getDsRefugo() +"\n";
		mensagem +="dthr="+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(refugo.getDthrRefugo()) +"\n";
		mensagem +="cdproduto="+ refugo.getCdProduto() +"\n";
		mensagem +="qtd="+ refugo.getQtd() +"\n";
		mensagem +="cb="+ refugo.getCb() +"\n";
		return mensagem;
	}
	
	private String montaMensagemVarRitmo(SessaoVarRitmoDTO varRitmo, int indicePt) {
		String mensagem = "";
		if(varRitmo == null)
			return mensagem;
		mensagem +="[pt" + indicePt + "ritmo]\n";
		mensagem +="id=" + varRitmo.getIdConsolRitmolog() + "\n";
		mensagem +="idtritmo=" + varRitmo.getIdTRitmo() + "\n";
		mensagem +="st="+ varRitmo.isVarRitmoAberto() +"\n";
		mensagem +="ini="+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(varRitmo.getDthrIVarRitmo()) +"\n";
		mensagem +="dur="+ varRitmo.getDuracao() +"\n";
		mensagem +="cd="+ varRitmo.getCdVarRitmo() +"\n";
		mensagem +="ds="+ varRitmo.getDsVarRitmo() +"\n";
		mensagem +="isabaixodotolerado="+ 0 +"\n";
		mensagem +="isacimadotolerado="+ 0 +"\n";
		return mensagem;
	}
	
	private String montaMensagemAlertas(SessaoAlertasDTO alertas, int indicePt){
		String mensagem = "";
		if(alertas == null || alertas.getListaAlertas() == null)
			return mensagem;
		mensagem +="[pt" + indicePt + "alerta]\n";
		int numAlertas = alertas.getListaAlertas().size();
		mensagem +="id=" + alertas.getMaiorIdConsolallog() + "\n";
		mensagem +="n=" + numAlertas + "\n";
		int indiceAlerta = 0;
		for(SessaoAlertaDTO  alerta : alertas.getListaAlertas()){
			indiceAlerta++;
			mensagem +="cd" + indiceAlerta + "="+ alerta.getCdAlerta() +"\n";
			mensagem +="ds" + indiceAlerta + "="+ alerta.getDsAlerta() +"\n";
			mensagem +="ini" + indiceAlerta + "="+ DataHoraRN.dateToStringDDMMYYYYHHMMSSms(alerta.getDthrIAlerta()) +"\n";
		}
		return mensagem;
	}
	
	
	
	private String montaMensagemUP(SessaoUPDTO up, int indicePt) {
		StringBuilder sb = new StringBuilder();
		if(up == null)
			return sb.toString();
		sb.append("[pt" + indicePt + "]\n");
		sb.append("id="+ up.getIdPt() + "\n");
		sb.append("revisao="+ up.getRevisaoPt() + "\n");
		sb.append("ds="+ up.getCdPt() +"\n");
		sb.append("idtp="+ up.getIdTppt() +"\n");
		sb.append("idgt="+ up.getIdGt() +"\n");
		sb.append("dsgt="+ up.getDsGt() +"\n");
		sb.append("ultfolha="+ up.getUltimaFolha() +"\n");
		sb.append("dssessao="+ up.getDsSessao() +"\n");
		sb.append("tpsessao="+ up.getTpSessao() +"\n");
		sb.append("stcip="+ up.isCipHabilitado() +"\n");
		sb.append("stritmo="+  up.isVarRitmoHabilitado() +"\n");
		sb.append("tolritmo="+  up.getToleranciaVarRitmo() +"\n");
		sb.append("debounceritmo="+  up.getDebounceVarRitmo() +"\n");
		sb.append("paradafechaciclo="+  up.isParadaFechaCiclo() +"\n");
		

		sb.append(montaMensagemCalendario(up.getCalendario(), indicePt));
		sb.append(montaMensagemUsuarios(up.getUsuarios(), indicePt));
		
		if(up.getOpDTO() != null) {
			sb.append(montaMensagemOP(up.getOpDTO(), indicePt));
			
			sb.append(montaMensagemParada(up.getParada(), indicePt));
			
			sb.append(montaMensagemRefugo(up.getRefugo(), indicePt));
			
			sb.append(montaMensagemVarRitmo(up.getVarRitmo(), indicePt));
		}
		
		sb.append(montaMensagemAlertas(up.getAlertas(), indicePt));
		
		return sb.toString();
	}
	
	@Override
	public String montaMensagemASerEnviada(MensagemEnviada mensagem) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[resp]\n");
		
		/*
		if (mensagem.getSessaoIC() == null) {
			sb.append("st=-1\n");  // se passar st=-1 a sessao eh descartada pelo coletor
			sb.append("n=0\n");
		} else {*/
			sb.append("st=0\n");  // se passar st=-1 a sessao eh descartada pelo coletor
			sb.append("n=1\n");

			int numPts = 0;
			if(mensagem.getSessaoIC() != null)
				numPts = mensagem.getSessaoIC().getUps().size();
			int indicePt = 0;
			sb.append("1="+ numPts + "\n");
			
			if(numPts > 0) {
				if(mensagem.getSessaoIC().getCfgDefault() != null) {
					sb.append(montaMensagemConfiguracaoGeral(mensagem.getSessaoIC().getCfgDefault()));
				}
				if(mensagem.getSessaoIC().getAndon() != null) {
					sb.append(montaMensagemAndon(mensagem.getSessaoIC().getAndon()));
				}
			
				for (SessaoUPDTO up : mensagem.getSessaoIC().getUps()) {
					indicePt++;
					
					sb.append(montaMensagemUP(up, indicePt));
				}
			}
		//}
		
		IdwLogger log = new IdwLogger("SessaoIcHeartBeat");
		log.info("\n"+sb.toString());
		
		
		return sb.toString();
	}
}
