package injetws.webservices.dto;

import injetws.model.pojos.PrUpDnc;
import idw.model.pojos.injet.Ijtbdnc;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IwsUpDncDTO implements Serializable {
	
	public static Integer SEM_ERRO = 0;
	public static Integer DADOS_AUSENTES = 10;
	public static Integer ERRO_WEBSERVER = 12;
	
	private String idUp;
	private String StAtivo;
	private String UploadPath;
	private String UploadExt;
	private String DownloadPath;
	private String DownloadExt;
	private String SerialPort;
	private Double BaudRate;
	private Integer DataBit;
	private String Parity;
	private Integer StopBit;
	private String FlowControl;
	private Double RecTimeOut;
	private String TpFimArquivo;
	private String TpFimBloco;
	private String TpIniArquivo;
	
	
	private Integer codErro;
	
	
	public String getidUp() {
		return idUp;
	}
	
	public void setidUp(String idUp) {
		this.idUp = idUp;
	}

	public void setTpFimArquivo(String TpFimArquivo) {
		this.TpFimArquivo = TpFimArquivo;
	}
	
	public String getTpFimArquivo() {
		return TpFimArquivo;
	}
	
	public void setTpIniArquivo(String TpIniArquivo) {
		this.TpIniArquivo = TpIniArquivo;
	}
	
	public String getTpIniArquivo() {
		return TpIniArquivo;
	}
	
	public void setTpFimBloco(String TpFimBloco) {
		this.TpFimBloco = TpFimBloco;
	}
	
	public String getTpFimBloco() {
		return TpFimBloco;
	}

	public String getStAtivo() {
		return StAtivo;
	}	

	public void setStAtivo(String StAtivo) {
		this.StAtivo = StAtivo;
	}
	

	public String getUploadPath() {
		return UploadPath;
	}	

	public void setUploadPath(String UploadPath) {
		this.UploadPath = UploadPath;
	}
	

	public String getUploadExt() {
		return UploadExt;
	}	

	public void setUploadExt(String UploadExt) {
		this.UploadExt = UploadExt;
	}
	

	public String getDownloadPath() {
		return DownloadPath;
	}	

	public void setDownloadPath(String DownloadPath) {
		this.DownloadPath = DownloadPath;
	}
	

	public String getDownloadExt() {
		return DownloadExt;
	}	

	public void setDownloadExt(String DownloadExt) {
		this.DownloadExt = DownloadExt;
	}
	

	public String getSerialPort() {
		return SerialPort;
	}	

	public void setSerialPort(String SerialPort) {
		this.SerialPort = SerialPort;
	}
	

	public Double getBaudRate() {
		return BaudRate;
	}	

	public void setBaudRate(Double BaudRate) {
		this.BaudRate = BaudRate;
	}
	
	
	public Integer getDataBit() {
		return DataBit;
	}	

	public void setDataBit(Integer DataBit) {
		this.DataBit = DataBit;
	}
	
	
	public String getParity() {
		return Parity;
	}	

	public void setParity(String Parity) {
		this.Parity = Parity;
	}
	
	
	public Integer getStopBit() {
		return StopBit;
	}	

	public void setStopBit(Integer StopBit) {
		this.StopBit = StopBit;
	}
	
	
	public String getFlowControl() {
		return FlowControl;
	}	

	public void setFlowControl(String FlowControl) {
		this.FlowControl = FlowControl;
	}
	
	
	public Double getRecTimeOut() {
		return RecTimeOut;
	}	

	public void setRecTimeOut(Double RecTimeOut) {
		this.RecTimeOut = RecTimeOut;
	}
	
	
	public Integer getcodErro() {
		return codErro;
	}	

	public void setcodErro(Integer codErro) {
		this.codErro = codErro;
	}
	
	
	
	public void copyPrUp(PrUpDnc prupdnc) {
		this.idUp = prupdnc.getidUp();
		this.StAtivo = prupdnc.getStAtivo();
		this.UploadPath = prupdnc.getUploadPath();
		this.UploadExt = prupdnc.getUploadExt();
		this.DownloadPath = prupdnc.getDownloadPath();
		this.DownloadExt = prupdnc.getDownloadExt();
		this.SerialPort = prupdnc.getSerialPort();
		this.BaudRate = prupdnc.getBaudRate();
		this.DataBit = prupdnc.getDataBit();
		this.Parity = prupdnc.getParity();
		this.StopBit = prupdnc.getStopBit();
		this.FlowControl = prupdnc.getFlowControl();
		this.RecTimeOut = prupdnc.getRecTimeOut();
		this.TpFimBloco = prupdnc.getSndEndBlock();
		this.TpFimArquivo = prupdnc.getSndEndProg();
		this.TpIniArquivo = prupdnc.getSndStartProg();		
	}
	
	public void copyIjtbdnc(Ijtbdnc ijtbdnc) {
		this.idUp = ijtbdnc.getCdinjetora();
		this.StAtivo = ijtbdnc.getStativo()+"";
		this.UploadPath = ijtbdnc.getUploadpath();
		this.UploadExt = ijtbdnc.getUploadext();
		this.DownloadPath = ijtbdnc.getDownloadpath();
		this.DownloadExt = ijtbdnc.getDownloadext();
		this.SerialPort = ijtbdnc.getSerialport()+"";
		this.BaudRate = ijtbdnc.getBaudrate();
		this.DataBit = ijtbdnc.getDatabit().intValue();
		this.Parity = ijtbdnc.getParity();
		this.StopBit = ijtbdnc.getStopbit().intValue();
		this.FlowControl = ijtbdnc.getFlowcontrol().toString();
		this.RecTimeOut = ijtbdnc.getRectimeout();
		this.TpFimBloco = ijtbdnc.getSndendblock();
		this.TpFimArquivo = ijtbdnc.getSndendprog();
		this.TpIniArquivo = ijtbdnc.getSndstartprog();		
	}
	
}
