package idw.model.rn.servemail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwRtcic;
import idw.model.pojos.MsDetector;
import idw.model.pojos.MsTrigger;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.model.pojos.template.MsTriggerTemplate;
import idw.model.pojos.template.MsTriggerTemplate.TypeOperadorLogico;
import idw.model.rn.DataHoraRN;
import idw.util.Email;
import idw.util.IdwLogger;

public abstract class ServicoEmailRN {

	protected abstract MsTpevtTemplate.Type getType();
	protected abstract String complementoAssuntoEmail(DwConsolid dwConsolid);
	protected abstract String  complementoMensagemEmail(DwConsolid dwConsolid);
	protected IdwLogger log;
	protected int idLog;
	protected int identacao;
	protected Session session;

	public ServicoEmailRN(IdwLogger log, int idLog, int identacao, Session session){
		this.log = log;
		this.idLog = idLog;
		this.identacao = identacao;
		this.setSession(session);
	}

	public void setSession(Session session){
		this.session = session;
	}

	public Session getSession(){
		return this.session;
	}

	protected void enviarEmail(List<OmUsr>listOmUsr, String subject, String message){
		List<String> destinatarios = new ArrayList<>();
		for(OmUsr omUsr:listOmUsr){
			log.info(idLog, identacao, "avaliando login " + omUsr.getLogin() + " email:" + omUsr.getUrlEmail());
			if (omUsr.getUrlEmail() != null && omUsr.getUrlEmail().trim().equals("") == false)
				destinatarios.add(omUsr.getUrlEmail());
		}

		Email email = new Email(this.log, this.idLog, this.identacao, destinatarios, subject, message);
		email.start();

	}
	
	private  void enviarEmailProducaoBrutaPercentual(
			List<OmUsr>listOmUsr, DwConsolid dwConsolid, OmPt omPt, double producaoBruta,
			double producaoPrevista, double vlInd,
			MsTriggerTemplate.TypeOperadorLogico typeOperadorLogico, Date dataHoraAtual){

		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();

		String sDataHoraAtual = DataHoraRN.dateToString(dataHoraAtual, "dd/MM/yyyy HH:mm:ss");

		assunto.append("M�quina ");
		assunto.append(omPt.getCdPt());

		assunto.append(this.complementoAssuntoEmail(dwConsolid));

		assunto.append(" com Produ��o Bruta(%) ");
		assunto.append(typeOperadorLogico.getDescricao());
		assunto.append(" ");
		assunto.append(vlInd);
		assunto.append("%");

		descricao.append("Mensagem autom�tica gerada pelo detector de eventos do sistema de planejamento as ");
		descricao.append(sDataHoraAtual);
		descricao.append("\nProdu��o bruta - ");
		descricao.append(producaoBruta);
		descricao.append("\nProdu��o prevista - ");
		descricao.append(producaoPrevista);
		descricao.append("\nProdu��o bruta percentual - ");
		descricao.append(producaoBruta / producaoPrevista * 100);
		descricao.append("%");
		descricao.append(this.complementoMensagemEmail(dwConsolid));

		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());

	}

	private void enviarEmailEficienciaCicloMedio(
			List<OmUsr>listOmUsr, DwConsolid dwConsolid, OmPt omPt, double qtdCiclos,
			double tempoAtivo, double vlInd,
			MsTriggerTemplate.TypeOperadorLogico typeOperadorLogico, Date dataHoraAtual){

		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();

		String sDataHoraAtual = DataHoraRN.dateToString(dataHoraAtual, "dd/MM/yyyy HH:mm:ss");

		assunto.append("M�quina ");
		assunto.append(omPt.getCdPt());

		assunto.append(this.complementoAssuntoEmail(dwConsolid));

		assunto.append(" com Efici�ncia do ciclo m�dio(%) ");
		assunto.append(typeOperadorLogico.getDescricao());
		assunto.append(" ");
		assunto.append(vlInd);
		assunto.append("%");

		descricao.append("Mensagem autom�tica gerada pelo detector de eventos do sistema de planejamento as ");
		descricao.append(sDataHoraAtual);
		descricao.append("\nTempo ativo - ");
		descricao.append(tempoAtivo);
		descricao.append("\nQtde. ciclos - ");
		descricao.append(qtdCiclos);
		descricao.append("\nEfici�ncia de ciclo m�dio = ");
		descricao.append(tempoAtivo / qtdCiclos * 100);
		descricao.append("%");
		descricao.append(this.complementoMensagemEmail(dwConsolid));

		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());

	}

	private void enviarEmailEficienciaUltimosCiclos(
			List<OmUsr>listOmUsr, DwConsolid dwConsolid, OmPt omPt, double totalSegDuracao,
			double triggerQtCiclos, double vlInd,
			MsTriggerTemplate.TypeOperadorLogico typeOperadorLogico, Date dataHoraAtual){

		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();

		String sDataHoraAtual = DataHoraRN.dateToString(dataHoraAtual, "dd/MM/yyyy HH:mm:ss");

		assunto.append("M�quina ");
		assunto.append(omPt.getCdPt());
		assunto.append(this.complementoAssuntoEmail(dwConsolid));
		assunto.append(" com Efici�ncia do ciclo m�dio(%) ");
		assunto.append(typeOperadorLogico.getDescricao());
		assunto.append(" ");
		assunto.append(vlInd);
		assunto.append("%");

		descricao.append("Mensagem autom�tica gerada pelo detector de eventos do sistema de planejamento as ");
		descricao.append(sDataHoraAtual);
		descricao.append("\nTempo ativo - ");
		descricao.append(totalSegDuracao);
		descricao.append("\nQtde. ciclos - ");
		descricao.append(triggerQtCiclos);
		descricao.append("\nEfici�ncia de ciclo m�dio = ");
		descricao.append(totalSegDuracao / triggerQtCiclos * 100);
		descricao.append("%");
		descricao.append(this.complementoMensagemEmail(dwConsolid));

		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());

	}

	private void enviarEmailProgramaMaquinaDiferente(List<OmUsr>listOmUsr, DwConsolid dwConsolid, OmPt omPt, PpCp ppCp, Date dataHoraAtual){
		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();

		String sDataHoraAtual = DataHoraRN.dateToString(dataHoraAtual, "dd/MM/yyyy HH:mm:ss");

		assunto.append("M�quina ");
		assunto.append(omPt.getCdPt());
		assunto.append(this.complementoAssuntoEmail(dwConsolid));
		assunto.append(" com programa diferente do planejado \n");

		descricao.append("Mensagem autom�tica gerada pelo detector de eventos do sistema de planejamento as ");
		descricao.append(sDataHoraAtual);
		descricao.append("\nIdentifica��o de programa em m�quina: ");
		descricao.append(dwConsolid.getDwFolha().getCdFolha());
		descricao.append("\nIdentifica��o de programa planejado: ");
		descricao.append(ppCp.getDwFolha().getCdFolha());

		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());

	}

	private void enviarEmailChegadaMateriaPrima(List<OmUsr>listOmUsr, Date dtHrAtual, Date dtPrevista){
		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();

		String sDataHoraAtual = DataHoraRN.dateToString(dtHrAtual, "dd/MM/yyyy HH:mm:ss");
		String sDtPrevista = DataHoraRN.dateToString(dtPrevista, "dd/MM/yyyy HH:mm:ss");
		assunto.append("Previs�o de chegada de mat�ria-prima em ");
		assunto.append(sDtPrevista);

		descricao.append("Mensagem autom�tica gerada pelo detector de eventos do sistema de planejamento as ");
		descricao.append(sDataHoraAtual);

		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());

	}

	private void enviarEmailGargalo(List<OmUsr>listOmUsr, DwConsolid dwConsolid, OmPt omPt, double gargalo, double producaoA, double producaoB,
			double cicloMedio, double cicloPadrao, double cavAtivas, double vlInd, MsTriggerTemplate.TypeOperadorLogico typeOperadorLogico, Date dataHoraAtual ){

		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();

		String sDataHoraAtual = DataHoraRN.dateToString(dataHoraAtual, "dd/MM/yyyy HH:mm:ss");

		assunto.append("M�quina ");
		assunto.append(omPt.getCdPt());
		assunto.append(this.complementoAssuntoEmail(dwConsolid));
		assunto.append(" com Gargalo(%) ");
		assunto.append(typeOperadorLogico.getDescricao());
		assunto.append(" ");
		assunto.append(vlInd);
		assunto.append("%");

		descricao.append("Mensagem autom�tica gerada pelo detector de eventos do sistema de planejamento as ");
		descricao.append(sDataHoraAtual);
		descricao.append("\nCiclo m�dio - ");
		descricao.append(cicloMedio);
		descricao.append("\nCiclo padr�o - ");
		descricao.append(cicloPadrao);
		descricao.append("\nQtd. blanck - ");
		descricao.append(cavAtivas);
		descricao.append("\nProdu��o restante considerando ciclo m�dio - ");
		descricao.append(producaoA);
		descricao.append("\nProdu��o restante considerando ciclo padr�o - ");
		descricao.append(producaoB);
		descricao.append("\nGargalo - ");
		descricao.append(gargalo);
		descricao.append(this.complementoMensagemEmail(dwConsolid));

		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());

	}

	private void enviarEmailDataEntregaClienteInviavel(List<OmUsr>listOmUsr, PpCp ppCp, double z, Date y, Date dtHrAtual){
		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();

		String sDataHoraAtual = DataHoraRN.dateToString(dtHrAtual, "dd/MM/yyyy HH:mm:ss");

		assunto.append("O pedido do cliente ");
		assunto.append(ppCp.getPpCliente().getNmCliente());
		assunto.append(" para a data ");
		assunto.append(y);
		assunto.append(" na quantidade de ");
		assunto.append(z);
		assunto.append(" n�o ser� atendido");

		descricao.append("Mensagem autom�tica gerada pelo detector de eventos do sistema de planejamento as ");
		descricao.append(sDataHoraAtual);

		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());

	}

	private void enviarEmailMudancaEstruturaProgramaIAC(List<OmUsr>listOmUsr, DwConsolid dwConsolid, Date dtHrAtual){

		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();

		String sDataHoraAtual = DataHoraRN.dateToString(dtHrAtual, "dd/MM/yyyy HH:mm:ss");

		assunto.append("A estrutura do programa ");
		assunto.append(dwConsolid.getDwFolha().getCdFolha());
		assunto.append(" para a m�quina ");
		assunto.append(dwConsolid.getOmPt().getCdPt());
		assunto.append(" foi modificado ");

		descricao.append("Mensagem autom�tica gerada pelo detector de eventos do sistema de planejamento as ");
		descricao.append(sDataHoraAtual);

		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());

	}

	private void enviarEmailFolhaDesconhecida(List<OmUsr>listOmUsr, DwConsolid dwConsolid, Date dtHrAtual){

		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();

		String sDataHoraAtual = DataHoraRN.dateToString(dtHrAtual, "dd/MM/yyyy HH:mm:ss");

		assunto.append("O Programa (Folha de processo) � desconhecido ");
		assunto.append(dwConsolid.getDwFolha().getCdFolha());
		assunto.append(" para a m�quina ");
		assunto.append(dwConsolid.getOmPt().getCdPt());

		descricao.append("Mensagem autom�tica gerada pelo detector de eventos do sistema de planejamento as ");
		descricao.append(sDataHoraAtual);

		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());

	}

	private void tratarEnviarEmailChegadaMateriaPrima(DwConsolid dwConsolid,	MsTrigger msTrigger, OmPt omPt, List<OmUsr> listOmUsr){
		if((msTrigger.getVlInd() == null) || (msTrigger.getVlInd().intValue() == 0)){
			return;
		}
		// Pega a data atual
		Date dtHrAtual = DataHoraRN.getDataHoraSgbd(this.getSession());

		Calendar dtHrPrevisaoChegada1 = new GregorianCalendar();
		// Calcular qual a data de previsao de chegada da materia-prima a partir da data de hoje
		dtHrPrevisaoChegada1.setTime((Date) dtHrAtual.clone());
		dtHrPrevisaoChegada1.add(Calendar.DATE, msTrigger.getVlInd().intValue());

		// Zera a data do inicio do intervalo
		dtHrPrevisaoChegada1.set(Calendar.HOUR, 0);
		dtHrPrevisaoChegada1.set(Calendar.MINUTE, 0);
		dtHrPrevisaoChegada1.set(Calendar.SECOND, 0);

		// Monta o fim da data prevista
		Calendar dtHrPrevisaoChegada2 = new GregorianCalendar();
		dtHrPrevisaoChegada2.setTime((Date) dtHrPrevisaoChegada1.getTime().clone());
		dtHrPrevisaoChegada2.set(Calendar.HOUR, 23);
		dtHrPrevisaoChegada2.set(Calendar.MINUTE, 59);
		dtHrPrevisaoChegada2.set(Calendar.SECOND, 59);

		MapQuery q = new MapQuery(this.getSession());

		q.append("select dwEstmov FROM DwEstmov dwEstmov");
		q.append("where dwEstmov.dthrMov between :dtHr1 and :dtHr2 ");
		q.append("and dwEstmov.tpMov :tpMov ");
		q.append("and dwEstmov.isEfetivado :isEfetivado ");
		q.defineParametro("dtHr1", dtHrPrevisaoChegada1.getTime());
		q.defineParametro("dtHr2", dtHrPrevisaoChegada2.getTime());
		q.defineParametro("tpMov", 0);
		q.defineParametro("isEfetivado", 1);
		q.setMaxResults(1);

		DwEstmov dwEstmov = (DwEstmov) q.uniqueResult();
		if(dwEstmov != null){
			this.enviarEmailChegadaMateriaPrima(listOmUsr, dtHrAtual,dtHrPrevisaoChegada1.getTime());
		}

	}

	private void tratarEnviarEmailDataEntregaClienteInviavel(DwConsolid dwConsolid,	MsTrigger msTrigger, OmPt omPt, List<OmUsr> listOmUsr){

		// Pega a data atual
		Date dtHrAtual = DataHoraRN.getDataHoraSgbd(this.getSession());

		// TODO Alessandre Avaliar a CP atual e todas as subsequentes para determinar se o prazo de entrega ser� cumprido. Para tanto, chamar o algoritmo de planejamento.
		double z = 0;
		Date y = null;
		this.enviarEmailDataEntregaClienteInviavel(listOmUsr, dwConsolid.getPpCp(), z, y ,  dtHrAtual );

	}

	private void tratarEnviarEmailMudancaEstruturaProgramaIAC(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt omPt, List<OmUsr> listOmUsr){

		Date dtHrAtual = DataHoraRN.getDataHoraSgbd(this.getSession());

		MapQuery q = new MapQuery(this.getSession());

		q.append("select count(*) FROM DwConsolid dwConsolid");
		q.append("where dwConsolid.dtReferencia = :dtReferencia");
		q.append("and  dwConsolid.dthrIhora = :dthrIhora");
		q.append("and  dwConsolid.dthrFIhora = :dthrFhora");
		q.append("and  dwConsolid.dwFolha.idFolha != :idFolha");
		q.defineParametro("dtReferencia", dwConsolid.getDtReferencia());
		q.defineParametro("dthrIhora", dwConsolid.getDthrIhora());
		q.defineParametro("idFolha", dwConsolid.getDwFolha().getIdFolha().longValue());
		q.setMaxResults(1);

		Object obj = q.uniqueResult();
		if(obj != null ){
			if(((Long) obj).longValue() > 0l ){
				this.enviarEmailMudancaEstruturaProgramaIAC(listOmUsr, dwConsolid, dtHrAtual);
			}
		}
	}

	private void tratarEnviarEmailProgramaMaquinaDiferente(DwConsolid dwConsolid,	MsTrigger msTrigger, OmPt omPt, List<OmUsr> listOmUsr){

		Date dtHrAtual = DataHoraRN.getDataHoraSgbd(this.getSession());

		MapQuery q = new MapQuery(this.getSession());

		q.append("select ppCp FROM PpCp ppCp");
		q.append("where ppCp.omPt.idPt = :idPt");
		q.append("and :dtHrAtual betweeb ppCp.dthrInicio and ppCp.dthrFinal and ppCp.stCp = :stCp");
		q.defineParametro("idPt", dwConsolid.getOmPt().getIdPt());
		q.defineParametro("dtHrAtual", dtHrAtual);
		q.defineParametro("stCp", 1);
		q.setMaxResults(1);

		PpCp ppCp = (PpCp) q.uniqueResult();

		if(!ppCp.getDwFolha().getIdFolha().equals(dwConsolid.getDwFolha().getIdFolha())){
			this.enviarEmailProgramaMaquinaDiferente(listOmUsr, dwConsolid, omPt, ppCp, dtHrAtual );
		}

	}

	private void tratarEnviarEmailGargalo(DwConsolid dwConsolid,	MsTrigger msTrigger, OmPt omPt, List<OmUsr> listOmUsr){

		DwConsolAgrupado dwConsolAgrupado = new DwConsolAgrupado(this.getSession(), dwConsolid.getIdConsolid());
		Date dataHoraAtual = DataHoraRN.getDataHoraSgbd(this.getSession());
		double tempoFinalHora = DataHoraRN.getQuantidadeSegundosNoPeriodo(dataHoraAtual, dwConsolid.getDthrFhora()) ;
		double producaoA = tempoFinalHora / dwConsolAgrupado.getCicloMedio() * dwConsolAgrupado.getCavAtivas();
		double producaoB = tempoFinalHora / dwConsolAgrupado.getCicloPadrao() * dwConsolAgrupado.getCavAtivas();
		double gargalo = producaoB - producaoA;

		TypeOperadorLogico typeOperadorLogico = this.operadorLogigoValido(gargalo,msTrigger);
		if(typeOperadorLogico == null){
			return;
		}

		this.enviarEmailGargalo(listOmUsr, dwConsolid, omPt, gargalo, producaoA, producaoB,
				dwConsolAgrupado.getCicloMedio(), dwConsolAgrupado.getCicloPadrao(), dwConsolAgrupado.getCavAtivas(),
				msTrigger.getVlInd().doubleValue(), typeOperadorLogico,  dataHoraAtual );

	}

	private void tratarEnviarEmailEficienciaUltimosCiclos(DwConsolid dwConsolid,	MsTrigger msTrigger, OmPt omPt, List<OmUsr> listOmUsr){
		double totalSegDuracao = new Long(0);

		if((msTrigger.getQtCiclos() == null) || (msTrigger.getQtCiclos().doubleValue() == 0)){
			return;
		}

		MapQuery q = new MapQuery(this.getSession());
		q.append("from DwRtcic dwRtcic");
		q.append("where dwRtcic.dwRt.dwConsolids.idConsolid = :idDwConsolid");
		q.defineParametro("idDwConsolid", dwConsolid.getIdConsolid());
		List<DwRtcic> listDwRtcic = q.list();

		if (listDwRtcic != null) {

			// Contabiliza o total da dura��o
			for (DwRtcic dwRtcic : listDwRtcic) {
				if (dwRtcic.getSegDuracao() != null) {
					totalSegDuracao += dwRtcic.getSegDuracao().doubleValue();
				}
			}

		}

		Date dataHoraAtual = DataHoraRN.getDataHoraSgbd(this.getSession());
		double vlInd = (totalSegDuracao / msTrigger.getQtCiclos().doubleValue() * 100);
		TypeOperadorLogico typeOperadorLogico = this.operadorLogigoValido(vlInd,msTrigger);
		if(typeOperadorLogico == null){
			return;
		}
		this.enviarEmailEficienciaUltimosCiclos(listOmUsr, dwConsolid, omPt, totalSegDuracao,
				msTrigger.getQtCiclos().doubleValue(),msTrigger.getVlInd().doubleValue(), typeOperadorLogico, dataHoraAtual);

	}

	private void tratarEnviarEmailEficienciaCicloMedio(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt omPt, List<OmUsr> listOmUsr){

		Date dataHoraAtual = DataHoraRN.getDataHoraSgbd(this.getSession());

		// Pega dados do ciclo m�dio
		DwConsolAgrupado dwConsolidAgrupado = new DwConsolAgrupado(this.getSession(), dwConsolid.getIdConsolid());

		double vlInd = (dwConsolidAgrupado.getCicloMedio() * 100);
		TypeOperadorLogico typeOperadorLogico = this.operadorLogigoValido(vlInd,msTrigger);
		if(typeOperadorLogico == null){
			return;
		}
		this.enviarEmailEficienciaCicloMedio(listOmUsr, dwConsolid, omPt, dwConsolidAgrupado.getQtdCiclos(),
				dwConsolidAgrupado.getTempoAtivo(), msTrigger.getVlInd().doubleValue(),  typeOperadorLogico, dataHoraAtual);

	}

	private void tratarEnviarEmailProducaoBruta(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt omPt, List<OmUsr> listOmUsr) {

		double producaoBruta = 0;
		double producaoPrevista = 0;

		Date dataHoraAtual = DataHoraRN.getDataHoraSgbd(this.getSession());

		MapQuery q = new MapQuery(this.getSession());
		q.append("from DwConsol dwConsol");
		q.append("where dwConsol.dwConsolid.idConsolid = :idDwConsolid");
		q.defineParametro("idDwConsolid", dwConsolid.getIdConsolid());
		List<DwConsol> listDwConsol = q.list();

		if (listDwConsol != null) {

			// Contabiliza o total de produ��o bruta e l�quida
			for (DwConsol dwConsol : listDwConsol) {
				if (dwConsol.getPcsAutoProducaobruta() != null) {
					producaoBruta += dwConsol.getPcsAutoProducaobruta().doubleValue();
				}
				if (dwConsol.getPcsManuProducaobruta() != null) {
					producaoBruta += dwConsol.getPcsManuProducaobruta().doubleValue();
				}
				if (dwConsol.getPcsAutoProducaoprevista() != null) {
					producaoPrevista += dwConsol.getPcsAutoProducaoprevista().doubleValue();
				}
				if (dwConsol.getPcsManuProducaoprevista() != null) {
					producaoPrevista += dwConsol.getPcsManuProducaoprevista().doubleValue();
				}
			}

		}

		double vlInd = (producaoBruta/ producaoPrevista * 100);
		TypeOperadorLogico typeOperadorLogico = this.operadorLogigoValido(vlInd,msTrigger);
		if(typeOperadorLogico == null){
			return;
		}
		this.enviarEmailProducaoBrutaPercentual(listOmUsr, dwConsolid, omPt, producaoBruta, producaoPrevista, msTrigger.getVlInd().doubleValue(), typeOperadorLogico, dataHoraAtual);
	}

	


	protected List<OmUsr> getUsuariosParaEnviarEmail(MsDetector msDetector){
		MapQuery q = new MapQuery(this.getSession());
		q.append("from OmUsr omUsr");
		q.append("where omUsr.omUsrgrp.idUsrgrp = :idUsrgrp and omUsr.stAtivo = 1");
		q.defineParametro("idUsrgrp", msDetector.getOmUsrgrp().getIdUsrgrp());
		return q.list();
	}

	protected void marcaDwConsolIdEmailEnviado(DwConsolid dwConsolid) {

		// Quando for um evento (sem folha de processo) que gerou o dwconsolid apenas com fins de compatibilidade o id ser� 0
		// nesse caso nao sera necessario atualizar o consolid
		if (dwConsolid != null && dwConsolid.getIdConsolid() != 0){
			// Busca registro no banco
			dwConsolid.setIsAlertasenviados((byte) 1);

			// Atualiza registro
			this.getSession().saveOrUpdate(dwConsolid);
		}
	}

	private TypeOperadorLogico operadorLogigoValido(double vlInd, MsTrigger msTrigger){
		if(msTrigger == null){
			return null;
		}
		if(msTrigger.getTypeOperadorLogico() == null){
			return null;
		}

		switch(msTrigger.getTypeOperadorLogico()){
		case DIFERENTE:
			if(vlInd != msTrigger.getVlInd().doubleValue()){
				return msTrigger.getTypeOperadorLogico();
			}
			break;
		case IGUAL:
			if(vlInd == msTrigger.getVlInd().doubleValue()){
				return msTrigger.getTypeOperadorLogico();
			}
			break;
		case MAIOR:
			if(vlInd > msTrigger.getVlInd().doubleValue()){
				return msTrigger.getTypeOperadorLogico();
			}
			break;
		case MAIOR_IGUAL:
			if(vlInd >= msTrigger.getVlInd().doubleValue()){
				return msTrigger.getTypeOperadorLogico();
			}
			break;
		case MENOR:
			if(vlInd < msTrigger.getVlInd().doubleValue()){
				return msTrigger.getTypeOperadorLogico();
			}
			break;
		case MENOR_IGUAL:
			if(vlInd <= msTrigger.getVlInd().doubleValue()){
				return msTrigger.getTypeOperadorLogico();
			}
			break;
		}
		return null;
	}

	protected List<MsDetector> loadDetectores() {

		MapQuery q = new MapQuery(this.getSession());
		q.append("select distinct msDetector ");
		q.append("from MsDetector msDetector ");
		q.append("join fetch msDetector.msTriggers msTrigger ");
		q.append("where msDetector.stAtivo = :stAtivo ");
		q.append("and msDetector.isEmail = :isEmail ");
		q.append("and msTrigger.msTpevt.idTpevt = :idTpEvt ");

		q.defineParametro("stAtivo", BigDecimal.ONE);
		q.defineParametro("isEmail", true);
		q.defineParametro("idTpEvt", (long) this.getType().getId());

		List<MsDetector> lista = q.list();

		return lista;

	}

	private class DwConsolAgrupado{

		private double tempoAtivo = 0;
		private double qtdCiclos = 0;
		private double cicloMedio = 0;
		private double cicloPadrao = 0;
		private double cavAtivas = 0;

		public DwConsolAgrupado(Session session, long idConsolid){

			MapQuery q = new MapQuery(session);
			q.append("from DwConsol dwConsol");
			q.append("where dwConsol.dwConsolid.idConsolid = :idDwConsolid");
			q.defineParametro("idDwConsolid", idConsolid);
			List<DwConsol> listDwConsol = q.list();

			if (listDwConsol != null) {

				// Contabiliza o total de tempo ativo e quantidade de inje��es
				for (DwConsol dwConsol : listDwConsol) {
					if (dwConsol.getSegAutoTempoativo() != null) {
						this.tempoAtivo += dwConsol.getSegAutoTempoativo().doubleValue();
					}
					if (dwConsol.getSegManuTempoativo() != null) {
						this.tempoAtivo += dwConsol.getSegManuTempoativo().doubleValue();
					}					
					if (dwConsol.getQtAutoCicloprodutivo() != null) {
						this.qtdCiclos += dwConsol.getQtAutoCicloprodutivo().doubleValue();
					}
					if (dwConsol.getQtManuCicloprodutivo() != null) {
						this.qtdCiclos += dwConsol.getQtManuCicloprodutivo().doubleValue();
					}
					if (dwConsol.getSegAutoCiclopadrao() != null){
						this.cicloPadrao += dwConsol.getSegAutoCiclopadrao().doubleValue();
					}
					if (dwConsol.getPcsAutoCavAtivas() != null){
						this.cavAtivas += dwConsol.getPcsAutoCavAtivas().doubleValue();
					}
					if (dwConsol.getPcsManuCavAtivas() != null){
						this.cavAtivas += dwConsol.getPcsManuCavAtivas().doubleValue();
					}					
				}

			}

			if((this.tempoAtivo != 0) && (this.qtdCiclos != 0)){
				this.cicloMedio = (this.tempoAtivo / this.qtdCiclos);
			}

		}

		public double getTempoAtivo() {
			return this.tempoAtivo;
		}

		public double getQtdCiclos() {
			return this.qtdCiclos;
		}

		public double getCicloMedio() {
			return this.cicloMedio;
		}

		public double getCicloPadrao() {
			return this.cicloPadrao;
		}

		public double getCavAtivas() {
			return this.cavAtivas;
		}

	}


	private void tratarEnviarEmailFolhaDesconhecida(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt omPt, List<OmUsr> listOmUsr){
		if ((dwConsolid.getDwFolha() == null) || ((dwConsolid.getDwFolha() != null) && (dwConsolid.getDwFolha().getIdFolha() == null))) {
			Date dtHrAtual = DataHoraRN.getDataHoraSgbd(this.getSession());
			this.enviarEmailFolhaDesconhecida(listOmUsr, dwConsolid, dtHrAtual);
		}
	}
}
