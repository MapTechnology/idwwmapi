package idw.model.rn.servemail;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.MsTrigger;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.MsTpevtTemplate.Type;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import ms.coleta.servico.ServicoFactory;

public class ServicoEmailAlertaParametroRN extends ServicoEmailFactory {

	

	private String parametroAferido;
	private Date dtAfericaoParametro;
	private int tpParametroAferido;
	
	private String faixaMinima;
	private String faixaMaxima;
	


	public ServicoEmailAlertaParametroRN(IdwLogger log, int idLog, int identacao, Session session) {
		super(log, idLog, identacao, session);
	}

	@Override
	protected Type getType() {		
		return Type.PARAMETRO_MEDICAO;
	}

	@Override
	protected String complementoAssuntoEmail(DwConsolid dwConsolid) {
		StringBuilder detalhe = new StringBuilder();
		String sDtHrIHora = "";
		String sDtHrFHora = "";
		if (dwConsolid.getDthrIhora() != null) {
			sDtHrIHora = DataHoraRN.dateToString(dwConsolid.getDthrIhora(), "dd/MM/yyyy HH:mm:ss");
			sDtHrFHora = DataHoraRN.dateToString(dwConsolid.getDthrFhora(), "dd/MM/yyyy HH:mm:ss");
		}
		String sDtReferecia = DataHoraRN.dateToString(dwConsolid.getDtReferencia(), "dd/MM/yyyy");
		detalhe.append(" na Hora ");
		detalhe.append(sDtHrIHora);
		detalhe.append(" - ");
		detalhe.append(sDtHrFHora);
		detalhe.append(" do dia ");
		detalhe.append(sDtReferecia);		
		return detalhe.toString();
	}

	@Override
	protected String complementoMensagemEmail(DwConsolid dwConsolid) {
		return "";
	}

	@Override
	public void tratarEnviarEmail(DwConsolid dwConsolid, MsTrigger msTrigger, OmPt ompt, List<OmUsr> listOmUsr) {
		StringBuilder assunto = new StringBuilder();
		StringBuilder descricao = new StringBuilder();
		
		if (this.getTpParametroAferido()==ServicoFactory._ALERTA_CONSUMO_ATIVO || this.getTpParametroAferido()==ServicoFactory._ALERTA_FATOR_DE_POTENCIA) {
			assunto.append("Posto de trabalho ");
		}else {
			assunto.append("Forno ");	
		}

		assunto.append(ompt.getCdPt());

		assunto.append(this.complementoAssuntoEmail(dwConsolid));
		assunto.append(" fora da tolerância");

		descricao.append("Mensagem automática gerada pelo sistema IDW - ");
		descricao.append(DataHoraRN.getDataHoraAtualFormatada());
		if (this.getTpParametroAferido()==ServicoFactory._ALERTA_CONSUMO_ATIVO) {
			descricao.append("\nEnergia Consumida: ");
		} else if (this.getTpParametroAferido()==ServicoFactory._ALERTA_FATOR_DE_POTENCIA ) {
			descricao.append("\nFator de potência medido: ");
		}else {
			descricao.append("\nTemperatura aferida: ");	
		}
		descricao.append(this.getParametroAferido());
		
		descricao.append(" Data e hora da medição - ");
		descricao.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(this.getDtAfericaoParametro()));
		descricao.append(this.complementoMensagemEmail(dwConsolid));
		
		descricao.append("\nValores inferiores a ");
		descricao.append(faixaMinima);
		descricao.append(" e superiores a ");
		descricao.append(faixaMaxima);
		descricao.append(" disparam esse e-mail.");
		
		if (dwConsolid != null && dwConsolid.getDwFolha() != null) {
			descricao.append("\nFolha utilizada: ");
			descricao.append(dwConsolid.getDwFolha().getCdFolha());
		}
		

		log.info(idLog, identacao, "Enviando email assunto: [" + assunto.toString() + "] com descricao: [" + descricao.toString() + "]. Para destinatarios:");
		for (OmUsr omusr : listOmUsr) {
			log.info(idLog, identacao, "Destinatario: " + omusr.getLogin() + " - email:" + omusr.getUrlEmail());
		}
		this.enviarEmail(listOmUsr, assunto.toString(), descricao.toString());
		
	}

	public String getParametroAferido() {
		return parametroAferido;
	}

	public void setParametroAferido(String parametroAferido) {
		this.parametroAferido = parametroAferido;
	}

	public Date getDtAfericaoParametro() {
		return dtAfericaoParametro;
	}

	public void setDtAfericaoParametro(Date dtAfericaoParametro) {
		this.dtAfericaoParametro = dtAfericaoParametro;
	}

	public int getTpParametroAferido() {
		return tpParametroAferido;
	}

	public void setTpParametroAferido(int tpParametroAferido) {
		this.tpParametroAferido = tpParametroAferido;
	}

	public String getFaixaMinima() {
		return faixaMinima;
	}

	public void setFaixaMinima(String faixaMinima) {
		this.faixaMinima = faixaMinima;
	}

	public String getFaixaMaxima() {
		return faixaMaxima;
	}

	public void setFaixaMaxima(String faixaMaxima) {
		this.faixaMaxima = faixaMaxima;
	}
}
