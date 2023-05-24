package idw.model.rn.pdba;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.Validate;
import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemPacoteOuFatorException;
import idw.model.excessoes.SemPcsPorCicloAtivasException;
import idw.model.pojos.DwFolha;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcp;
import idw.model.pojos.PpCp;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.util.IdwLogger;
import idw.util.UtilsString;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.ic.inova.Stubdelegate;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;

public abstract class AbstractPdbaMsEvtRN {

	// Metodo chamado pela maioria dos eventos vindos do JConcentrador
	public MsEvt executarServico(Session sessao, String idUp, String cd, Date dthrFim, Date dthrInicio, IwsDadosApontamentoDTO dados, int tipoEvento, String origem) throws ServicoFalhouException {
		return executarServico(sessao, idUp, cd, dthrFim, dthrInicio, tipoEvento, null, null, null, null, null, null, null, dados, origem);
	}

	/*
	 * Metodo para execucao do servico de inicio de OP
	 */
	public MsEvt executarServico(Session sessao, String idUp, Date dthr, int tipoEvento, IwsCpDTO cpEntrada) throws ServicoFalhouException {
		// Avalia parametros de entrada
		Validate.notNull(Stubedelegate.getInstancia().getMsthread(), "MsThread esta nula, possivelmente o ms nao cadastrado");
		Validate.notNull(idUp, "idUp esta nula");

		// Cria evento para inicio do planejamento
		EventoColetado evento = new EventoColetado();
		evento.setDthrEvento(dthr);
		evento.setTipoEvento(tipoEvento);
		evento.setChamarInjetWs(false);

		
		evento.setTpSessao(cpEntrada.getStCriacaoCP());
		evento.setCdproduto(cpEntrada.getCdProduto());
		evento.setCdop(cpEntrada.getNrop());
		evento.setCdmolde(cpEntrada.getCdmolde());
		evento.setCdestrutura(cpEntrada.getCdestrutura());
		evento.setQtde(cpEntrada.getProducaoPlanejada());
		if (evento.getQtde() == null && cpEntrada.getQtciclos() != null)
			evento.setQtde(cpEntrada.getQtciclos());

		// Alessandre: em 22-2-13 a linha abaixo nao pode ser comentada pois eh
		// ela que encontra o IcUp necessario para a linha seguinte
		evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(idUp));

		evento.setLog(evento.getIcUpDTO().getIc().getLog());
		evento.setIdLog(evento.getLog().getIdAleatorio());
		evento.setIdentacao(0);

		// Inicializa MensagemRecebida
		MensagemRecebida mensagem = new MensagemRecebida(evento);
		mensagem.setLog(evento.getLog());
		mensagem.setIdLog(evento.getIdLog());
		mensagem.setIdentacao(evento.getIdentacao());
		// Alessandre: por algum motivo a linha abaixo estava comentada,
		// descomentei em 04-12-12 para funcionar na AmazonAco
		mensagem.setDadosIcDTO(Stubedelegate.getInstancia().getMsthread().getIcDTOdaListaByIdUpPdba(idUp));

		// Chama o servico de alerta
		return ServicoFactory.getInstancia().executaServico(sessao, mensagem);
	}

	/*
	 * Metodo para execucao do servico do MS referente aos operadores. Todos os
	 * parametros
	 */
	protected MsEvt executarServico(Session sessao, String idUp, String cd,
			Date dthrFim, Date dthrInicio, int tipoEvento, String cdparada,
			String cdacao, String cdcausa, String cdjustificativa,
			String cdtec1, String cdtec2, String cdtecResponsavel,
			IwsDadosApontamentoDTO dados, String origem) throws ServicoFalhouException {

		// Avalia parametros de entrada
		Validate.notNull(Stubedelegate.getInstancia().getMsthread(), "MsThread esta nula, possivelmente o ms nao cadastrado");
		Validate.notNull(idUp, "idUp esta nula");

		// Inicializa evento
		EventoColetado evento = new EventoColetado();
		evento.setDthrEvento(dthrFim);
		evento.setTipoEvento(tipoEvento);
		evento.setIdUpPdba(idUp);
		evento.setPacoteCiclo(dados);
		evento.setOrigem(origem);
		
		// Avaliar se dados e dados.infoAdicional tem valores, se tiver jogar em origem. Sera usada pela consolidacao
		// para consolidar um ciclo com pacote que tenha sido finalizado por REGULAGEM permitindo assim que a consolidacao nao
		// tire a maquina de parada
		if (dados != null && dados.getInfoAdicional() != null && dados.getInfoAdicional().trim().equals("") == false) {
			evento.setOrigem(dados.getInfoAdicional());
		}
		
		/* Se o posto for de pacote de ciclo calcular nesse momento a quantidade de produtos feitos no ciclo
		 * 
		 */
		if (dados != null && dados.getBatidas() > 0) {
			evento.setQtdeciclos(String.valueOf(dados.getBatidas()));
			PTRN rn = new PTRN();
			FolhaRN frn = new FolhaRN();
			rn.setDaoSession(sessao);
			frn.setDaoSession(sessao);
			OmPt ompt;
			try {
				ompt = rn.getOmPt(idUp);
			} catch (RegistroDesconhecidoException e) {
				ompt = null;
			}
			
			DwFolha dwfolha = null;
			if (ompt != null && ompt.getPpCp() != null)
				dwfolha = ompt.getPpCp().getDwFolha();
			
			// Pesquisa a folha para pegar a mais atual
			dwfolha = frn.pesquisaFolhaByCdEStSemRota(dwfolha.getCdFolha());

			if (dwfolha != null){
				
				
				Integer pacoteCiclo;
				try {
					pacoteCiclo = frn.getPacoteCicloFromDwFolha(dwfolha, ompt);
				} catch (SemPacoteOuFatorException e) {
					pacoteCiclo = null;
				}
				BigDecimal fatorContagem;
				try {
					fatorContagem = frn.getFatorContagemFromDwFolha(dwfolha, ompt);
				} catch (SemPacoteOuFatorException e) {
					fatorContagem = null;
				}
				if (pacoteCiclo != null && pacoteCiclo > 1 && fatorContagem != null) {
			
					/* Se a folha possuir mais de um produto, entao pegar a qtde de cavidades maior e usa-la como referencia para lancaer em qtde
					 * pois os valores menores serao recalculado na consolidacao
					 */
					int cavAtivas = 1;
					int batidas = dados.getBatidas();
					double fator = fatorContagem.doubleValue();
					
					/* Obtem a quantidade maior de cavidades
					 * 
					 */
					try {
						BigDecimal cavAtivasAux = frn.getPcsPorCicloAtivas(dwfolha);
						cavAtivas = cavAtivasAux.intValue();
					} catch (SemPcsPorCicloAtivasException e) {
						e.printStackTrace();
					}
					evento.setQtde(String.valueOf( (cavAtivas * batidas * fator) / pacoteCiclo));
				}
			}
		}
		
		evento.setChamarInjetWs(false);
		// Alessandre: em 22-2-13 a linha abaixo nao pode ser comentada pois eh
		// ela que encontra o IcUp necessario para a linha seguinte
		
		evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(idUp));

		try {
			evento.setLog(evento.getIcUpDTO().getIc().getLog());
			evento.setIdLog(evento.getLog().getIdAleatorio());
		} catch (NullPointerException e) {
			evento.setLog(new IdwLogger("AbstractPdbaMsEvtRN"));
			evento.setIdLog(0);
		}
		evento.setIdentacao(0);
		evento.setCdparada(cdparada);

		if (cdacao != null && cdacao.isEmpty() == false) {
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				cdacao = FuncoesApoioInjet.getCodigoPadraoInjet(cdacao);
			evento.setCdacao(cdacao);
		}
		if (cdcausa != null && cdcausa.isEmpty() == false) {
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				cdcausa = FuncoesApoioInjet.getCodigoPadraoInjet(cdcausa);
			evento.setCdcausa(cdcausa);
		}
		if (cdjustificativa != null && cdjustificativa.isEmpty() == false) {
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				cdjustificativa = FuncoesApoioInjet.getCodigoPadraoInjet(cdjustificativa);
			evento.setCdjustificativa(cdjustificativa);
		}
		if (cdtec1 != null && cdtec1.isEmpty() == false) {
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				cdtec1 = FuncoesApoioInjet.getCodigoPadraoInjet(cdtec1);
			evento.setCdtec1(cdtec1);
		}
		if (cdtec2 != null && cdtec2.isEmpty() == false) {
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				cdtec2 = FuncoesApoioInjet.getCodigoPadraoInjet(cdtec2);
			evento.setCdtec2(cdtec2);
		}
		if (cdtecResponsavel != null && cdtecResponsavel.isEmpty() == false) {
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				cdtecResponsavel = FuncoesApoioInjet.getCodigoPadraoInjet(cdtecResponsavel);
			evento.setCdtecResponsavel(cdtecResponsavel);
		}
		if (tipoEvento == ServicoFactory._LOGIN || tipoEvento == ServicoFactory._LOGOUT || tipoEvento == ServicoFactory._INICIAR_CIP_INOVASA || tipoEvento == ServicoFactory._FINALIZAR_CIP_INOVASA) {
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				cd = FuncoesApoioInjet.getCodigoPadraoInjet(cd);
			else if (cd != null)
				cd = UtilsString.removeZerosEsquerda(cd);
			evento.setLogin(cd);
		} else if (tipoEvento == ServicoFactory._INICIA_ALERTA || tipoEvento == ServicoFactory._REMOVE_ALERTA) {
			if (Stubdelegate.getInstancia().isInjetAtivo() == true)
				cd = FuncoesApoioInjet.getCodigoPadraoInjet(cd);
			evento.setCdalerta(cd);
		}

		// Eh necessario que IcUp tenha valor dentro do evento e dentro de IcUp,
		// a Up deve ter valor

		// Inicializa MensagemRecebida
		MensagemRecebida mensagem = new MensagemRecebida(evento);
		mensagem.setLog(evento.getLog());
		mensagem.setIdLog(evento.getIdLog());
		mensagem.setIdentacao(evento.getIdentacao());
		// Alessandre: por algum motivo a linha abaixo estava comentada,
		// descomentei em 04-12-12 para funcionar na AmazonAco
		
		mensagem.setDadosIcDTO(Stubedelegate.getInstancia().getMsthread().getIcDTOdaListaByIdUpPdba(idUp));
		if (mensagem.getDadosIcDTO() == null) {
			try {
				mensagem.setDadosIcDTO(Stubedelegate.getInstancia().getMsthread().getIcDTOdaListaByIdUp(new BigDecimal(idUp)));
			} catch (NumberFormatException e) {
				mensagem.setDadosIcDTO(null);
			}
		}
		if (mensagem.getDadosIcDTO() == null) {
			mensagem.setDadosIcDTO(Stubedelegate.getInstancia().getMsthread().getIcDTOdaListaByCdUp(idUp));
		}
		// Chama o servico de alerta
		// Date inicio = DataHoraRN.getDataHoraAtual();
		return ServicoFactory.getInstancia().executaServico(sessao, mensagem);
	}

	/*
	 * Esse metodo esta sendo chamado pelo heartbeat
	 */
	protected void executarServico(Session sessao, MsUp msup, Date dthrFim, int tipoEvento) throws ServicoFalhouException {
		// Avalia parametros de entrada
		Validate.notNull(Stubedelegate.getInstancia().getMsthread(), "MsThread esta nula, possivelmente o ms nao cadastrado");
		Validate.notNull(msup, "MsUp esta nula");
		Validate.isTrue(Stubedelegate.getInstancia().getMsthread().getIcUp(msup.getCdUp()) != null, "Nao encontrou msicupdto a partir da cdUp " + msup.getCdUp());

		// Define parametros de log que serao usados para todos os procedimentos
		// abaixo

		// Inicializa evento
		EventoColetado evento = new EventoColetado();
		evento.setDthrEvento(dthrFim);
		evento.setTipoEvento(tipoEvento);
		evento.setChamarInjetWs(false);
		// Alessandre: em 22-2-13 a linha abaixo nao pode ser comentada pois eh
		// ela que encontra o IcUp necessario para a linha seguinte
		evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(msup.getCdUp()));
		evento.setLog(evento.getIcUpDTO().getIc().getLog());
		evento.setIdLog(evento.getLog().getIdAleatorio());
		evento.setIdentacao(0);

		// Inicializa MensagemRecebida
		MensagemRecebida mensagem = new MensagemRecebida(evento);
		mensagem.setLog(evento.getLog());
		mensagem.setIdLog(evento.getIdLog());
		mensagem.setIdentacao(evento.getIdentacao());
		// Alessandre: por algum motivo a linha abaixo estava comentada,
		// descomentei em 04-12-12 para funcionar na AmazonAco
		mensagem.setDadosIcDTO(Stubedelegate.getInstancia().getMsthread().getIcDTOdaListaByCdUp(msup.getCdUp()));

		// Chama o servico de alerta
		ServicoFactory.getInstancia().executaServico(sessao, mensagem);
	}

	/*
	 * Esse metodo eh usado exclusivamente para o servico de refugo
	 */
	public MsEvt executarServico(Session sessao, String cdRefugo,
			String cdCausa, String cdAcao, String Quantidade, String idUp,
			String idRdzProduto, Date DataHrAtual)
			throws ServicoFalhouException {
		// Avalia parametros de entrada
		Validate.notNull(Stubedelegate.getInstancia().getMsthread(), "MsThread esta nula, possivelmente o ms nao cadastrado");
		Validate.notNull(idUp, "idUp esta nula");

		// Define parametros de log que serao usados para todos os procedimentos
		// abaixo

		// Inicializa evento
		EventoColetado evento = new EventoColetado();
		evento.setDthrEvento(DataHrAtual);
		evento.setTipoEvento(ServicoFactory._NOVOREFUGO);
		evento.setChamarInjetWs(false);
		// Alessandre: em 22-2-13 a linha abaixo nao pode ser comentada pois eh
		// ela que encontra o IcUp necessario para a linha seguinte
		evento.setIcUpDTO(Stubedelegate.getInstancia().getMsthread().getIcUp(idUp));
		
		evento.setLog(evento.getIcUpDTO().getIc().getLog());
		evento.setIdLog(evento.getLog().getIdAleatorio());
		evento.setIdentacao(0);
		evento.setCdacao(cdAcao);
		evento.setCdrefugo(cdRefugo);
		evento.setCdcausa(cdCausa);
		evento.setQtde(Quantidade);
		evento.setCdproduto(idRdzProduto);
		evento.setIdRdzProduto(idRdzProduto);

		// Inicializa MensagemRecebida
		MensagemRecebida mensagem = new MensagemRecebida(evento);
		mensagem.setLog(evento.getLog());
		mensagem.setIdLog(evento.getIdLog());
		mensagem.setIdentacao(evento.getIdentacao());
		mensagem.setDadosIcDTO(Stubedelegate.getInstancia().getMsthread().getIcDTOdaListaByIdUpPdba(idUp));

		// Chama o servico de alerta
		MsEvt msevt = ServicoFactory.getInstancia().executaServico(null, mensagem);
		
		return msevt;
	}
	
	protected OmPtcp obtemPtCp(OmPt ompt, PpCp ppcp, DAOGenerico dao) {
		MapQuery q = new MapQuery(dao.getSession());
		q.append("select a");
		q.append("from OmPtcp a");
		q.append("where a.omPt = :ompt");
		q.append("and a.ppCp = :ppcp");
		
		q.defineParametro("ompt", ompt);
		q.defineParametro("ppcp", ppcp);
		
		OmPtcp omptcp = (OmPtcp) q.uniqueResult();

		return omptcp;
	}
}
