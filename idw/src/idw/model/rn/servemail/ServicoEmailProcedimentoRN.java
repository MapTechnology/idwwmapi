package idw.model.rn.servemail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwProreaativobs;
import idw.model.pojos.MsTrigger;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.MsTpevtTemplate.Type;
import idw.model.rn.DataHoraRN;
import idw.util.Email;
import idw.util.IdwLogger;

public class ServicoEmailProcedimentoRN extends ServicoEmailFactory{

	private DwProreaativobs dwProreaativobs = null;
	private boolean isEnviou=false;

	public ServicoEmailProcedimentoRN(IdwLogger log, int idLog, int identacao, Session session) {
		super(log, idLog, identacao, session);
	}

	@Override
	protected Type getType() {		
		return Type.OBS_PROCEDIMENTO;
	}

	@Override
	protected String complementoAssuntoEmail(DwConsolid dwConsolid) {
		StringBuilder detalhe = new StringBuilder();
		String sHr = DataHoraRN.getHoraFormatoHHMMSS(dwProreaativobs.getDthrObs());
		String sDt = DataHoraRN.dateToString(dwProreaativobs.getDthrObs(), "dd/MM/yyyy");
		detalhe.append(" na Hora ");
		detalhe.append(sHr);
		detalhe.append(" do dia ");
		detalhe.append(sDt);		
		return detalhe.toString();
	}

	@Override
	protected String complementoMensagemEmail(DwConsolid dwConsolid) {
		return "";
	}

	@Override
	public void tratarEnviarEmail(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt ompt, List<OmUsr> listOmUsr) {

		// Decidir se o email sera enviado ou nao baseando-se no st do detector e do evento real
		
		
		// Pegar o email da area responsavel: OK!
		BigDecimal stObs = new BigDecimal(0);
		if(dwProreaativobs.getDwProreaativ().getStProreaativ()==0||dwProreaativobs.getDwProreaativ().getStProreaativ()==1){
			stObs = new BigDecimal(22);
		}else if(dwProreaativobs.getDwProreaativ().getStProreaativ()==2){
			stObs = new BigDecimal(23);
		}else if(dwProreaativobs.getDwProreaativ().getStProreaativ()==3){
			stObs = new BigDecimal(24);
		}
		
		msTrigger = msTrigger.clone(true);
		//if(!isEnviou){//Vin�cius em 25/07/2014 - fiz pois o email estava sendo enviado 3 vezes
			if(msTrigger.getMsInd().getIdInd().equals(stObs)){
				List<String> destinatarios = new ArrayList<String>();
				destinatarios.add(dwProreaativobs.getDwProreaativ().getDwProcativ().getDwTArea().getEmail());
				StringBuilder assunto = new StringBuilder();
				StringBuilder descricao = new StringBuilder();
		
				String sDataHoraAtual = DataHoraRN.dateToString(dwProreaativobs.getDthrObs(), "dd/MM/yyyy HH:mm:ss");
		
				assunto.append("Observa��o Setup: ");
				assunto.append(dwProreaativobs.getDwProreaativ().getDwProcativ().getDwProcedimento().getDsProcedimento());
				assunto.append(this.complementoAssuntoEmail(dwConsolid));
				
				
				descricao.append("Mensagem gerada pelo sistema ao receber Observa��o realizada no aplicativo Setup Mobile as ");
				descricao.append(sDataHoraAtual);
				descricao.append("\nAtividade - ");
				descricao.append(dwProreaativobs.getDwProreaativ().getDwProcativ().getDsProcativ());
				descricao.append("\nEstado atual da atividade - ");
				String st="";
				if(dwProreaativobs.getDwProreaativ().getStProreaativ()==0){
					st="Em Execu��o";
				}else if(dwProreaativobs.getDwProreaativ().getStProreaativ()==1){
					st="Executada";
				}else if(dwProreaativobs.getDwProreaativ().getStProreaativ()==2){
					st="Executada com ressalva";
				}else if(dwProreaativobs.getDwProreaativ().getStProreaativ()==3){
					st="N�o Executada";
				}
				descricao.append(st);
				descricao.append("\nObserva��o - ");
				descricao.append(dwProreaativobs.getDsObs());
				descricao.append(this.complementoMensagemEmail(dwConsolid));
		
				Email email = new Email(this.log, this.idLog, this.identacao, destinatarios, assunto.toString(), descricao.toString());
//				email.start(); alessandre desativei rever futuramente
				isEnviou=true;
			}
		//}
	}

	public void setDwProreaativobs(DwProreaativobs dwProreaativobs) {
		this.dwProreaativobs = dwProreaativobs;
	}

	public void setEnviou(boolean isEnviou) {
		this.isEnviou = isEnviou;
	}
}
