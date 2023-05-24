package ms.coleta.ic.inovastandalone.transferirarquivos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwCal;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;


public class ArquivoSessoes{

	private OmCfg omcfg = null;
	private OmPt ompt = null;
	private DwCal dwcal = null;
	private MsMsicup msmsicup = null;
	private PpCp ppcpAnterior = null;
	private IdwLogger log;
	
	private String mac;
	private BigDecimal segintervaloleitura=null;
	private BigDecimal segintervaloleituraec=null;
	private List<Date> proximasViradasDeTurno = new ArrayList<>(); 
	
	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten("[SESSAO]");
		arquivoInovaSA.addLineToBeWritten("IDPT=" + ompt.getIdPt());
		if (ompt.getOmGt() != null)
			arquivoInovaSA.addLineToBeWritten("IDGT=" + ompt.getOmGt().getIdGt());
		else
			arquivoInovaSA.addLineToBeWritten("IDGT=");
		
		arquivoInovaSA.addLineToBeWritten("DSPT=" + ompt.getCdPt());
		if (ompt.getOmGt() != null)
			arquivoInovaSA.addLineToBeWritten("DSGT=" + ompt.getOmGt().getDsCurta());
		else
			arquivoInovaSA.addLineToBeWritten("DSGT=NULL");

		arquivoInovaSA.addLineToBeWritten("DSSESSAO=" + ompt.getDsSessao());
		
		/* Alessandre em 12-01-17 o cadastro do PT foi modificado para incluir novos tipos de sesao para compatibilizar o idw com o injet
		 * e reaproveitar o conentrador em C# Assim o tipo de sessao 1 (criar op por folha)  do inovaSA passou a ser o 3. O 1 virou recuparar
		 * op pela ferramente e o 2 recuperar op por produto. Para evitar uma manutenção no firmaeew foi acrescentado o if abaixo
		 * para deixar em 1 qq tipo de sessao diferente de 0. Pelo meno ate o inovaSA implementar esses novos tipos de sessao
		 */
		if (ompt.getTpSessao() != null && ompt.getTpSessao().equals((byte) 0))
			arquivoInovaSA.addLineToBeWritten("TPSESSAO=" + ompt.getTpSessao());
		else
			arquivoInovaSA.addLineToBeWritten("TPSESSAO=1");
		arquivoInovaSA.addLineToBeWritten("IDTPPT=" + String.valueOf(ompt.getOmTppt().getIdTppt()));
		arquivoInovaSA.addLineToBeWritten("MAC=" + mac);
		arquivoInovaSA.addLineToBeWritten("SEG_FEED_B_LOG=" + omcfg.getSegFeedbacklogin());
		arquivoInovaSA.addLineToBeWritten("SEG_LOGOUT_AUTO=" + omcfg.getSegAutologout());
		arquivoInovaSA.addLineToBeWritten("IS_LOGON=" + omcfg.getIsLogonobrigatorio());
		arquivoInovaSA.addLineToBeWritten("ID_CAL=" + dwcal.getIdCal());
		arquivoInovaSA.addLineToBeWritten("CB_PRINCIPAL=" + omcfg.getMascaracb());
		arquivoInovaSA.addLineToBeWritten("MASC_CD_PAI=" + omcfg.getMascaraop());
		arquivoInovaSA.addLineToBeWritten("MASC_CD_FILHO=" + omcfg.getMascaraQtd());
		arquivoInovaSA.addLineToBeWritten("MASC_NS=" + omcfg.getMascaracb());
		arquivoInovaSA.addLineToBeWritten("TEMP_CCK=" + segintervaloleitura);
		arquivoInovaSA.addLineToBeWritten("TEMP_CCKEC=" + segintervaloleituraec);
		arquivoInovaSA.addLineToBeWritten("PORTA=" + msmsicup.getUrlConexao());
		if (omcfg.getDwTParada() != null) {
			arquivoInovaSA.addLineToBeWritten("CDPARADADEFAULT=" + omcfg.getDwTParada().getCdTparada());
			arquivoInovaSA.addLineToBeWritten("DSPARADADEFAULT=" + omcfg.getDwTParada().getDsTparada());
		} else {
			arquivoInovaSA.addLineToBeWritten("CDPARADADEFAULT=999999");
			arquivoInovaSA.addLineToBeWritten("DSPARADADEFAULT=PARADA DEFAULT NAO DEFINIDA");
		}
		
		if(ppcpAnterior != null)
			arquivoInovaSA.addLineToBeWritten("ULTIMA_FOLHA="+ppcpAnterior.getDwFolha().getIdFolha());
		arquivoInovaSA.addLineToBeWritten("IS_CIP_ENABLE="+ompt.getIsHabilitaCip());
		arquivoInovaSA.addLineToBeWritten("ISREQTECCIPINI="+omcfg.getIsRequerTecnicoInicioCip());
		arquivoInovaSA.addLineToBeWritten("ISREQTECCIPFIM="+omcfg.getIsRequerTecnicoFimCip());
		if(omcfg.getDwTParadaByIdTparadacip() != null) {
			arquivoInovaSA.addLineToBeWritten("CDPARADACIPDEFAULT="+omcfg.getDwTParadaByIdTparadacip().getCdTparada());
			arquivoInovaSA.addLineToBeWritten("DSPARADACIPDEFAULT="+omcfg.getDwTParadaByIdTparadacip().getDsTparada());
		} else {
			arquivoInovaSA.addLineToBeWritten("CDPARADACIPDEFAULT=999999");
			arquivoInovaSA.addLineToBeWritten("DSPARADACIPDEFAULT=PARADA DEFAULT NAO DEFINIDA");
		}
		if(omcfg.getDwTAlerta() != null) {
			arquivoInovaSA.addLineToBeWritten("CDALERTACIPDEFAULT="+omcfg.getDwTAlerta().getCdTalerta());
		}
		
		arquivoInovaSA.addLineToBeWritten("IS_RITMO_ENABLE="+ompt.getIsHabilitaVaritmo());
		arquivoInovaSA.addLineToBeWritten("TOL_VARRITMO="+ompt.getPercVaritmo());
		arquivoInovaSA.addLineToBeWritten("DEBOUNCE_VARRITMO="+ompt.getQtVaritmo());
		if(omcfg.getDwTRitmo() != null) {
			arquivoInovaSA.addLineToBeWritten("CDRITMODEFAULT="+omcfg.getDwTRitmo().getCdTritmo());
			arquivoInovaSA.addLineToBeWritten("DSRITMODEFAULT="+omcfg.getDwTRitmo().getDsTritmo());
		}
		
		// Escrever no arquivo as proximas viradas de turno do pt que serï¿½ usada para zerar a contagem da producao por hora e por turno
		// afim de refugar apenas a producao da hora
		arquivoInovaSA.addLineToBeWritten("[PROXIMASVIRADASDETURNO]");
		for (Date dthr : this.proximasViradasDeTurno) {
			arquivoInovaSA.addLineToBeWritten(DataHoraRN.dateToStringDDMMYYYYHHMMSS(dthr));
		}
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}

	public OmCfg getOmcfg() {
		return omcfg;
	}

	public void setOmcfg(OmCfg omcfg) {
		this.omcfg = omcfg;
	}

	public OmPt getOmpt() {
		return ompt;
	}

	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}

	public DwCal getDwcal() {
		return dwcal;
	}

	public void setDwcal(DwCal dwcal) {
		this.dwcal = dwcal;
	}

	public MsMsicup getMsmsicup() {
		return msmsicup;
	}

	public void setMsmsicup(MsMsicup msmsicup) {
		this.msmsicup = msmsicup;
	}

	public PpCp getPpcpAnterior() {
		return ppcpAnterior;
	}

	public void setPpcpAnterior(PpCp ppcpAnterior) {
		this.ppcpAnterior = ppcpAnterior;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public BigDecimal getSegintervaloleitura() {
		return segintervaloleitura;
	}

	public void setSegintervaloleitura(BigDecimal segintervaloleitura) {
		this.segintervaloleitura = segintervaloleitura;
	}

	public BigDecimal getSegintervaloleituraec() {
		return segintervaloleituraec;
	}

	public void setSegintervaloleituraec(BigDecimal segintervaloleituraec) {
		this.segintervaloleituraec = segintervaloleituraec;
	}

	public List<Date> getProximasViradasDeTurno() {
		return proximasViradasDeTurno;
	}

	public void setProximasViradasDeTurno(List<Date> proximasViradasDeTurno) {
		this.proximasViradasDeTurno = proximasViradasDeTurno;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

}
