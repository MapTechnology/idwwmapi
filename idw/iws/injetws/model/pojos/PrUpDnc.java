package injetws.model.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PR_UP_DNC")
public class PrUpDnc implements java.io.Serializable {
	
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
	private String RecIgnBefFrstEOB;
	private String RecIgnAftLastEOF;	
	private String SndStartProg;    
	private String SndEndProg;   
	private String SndEndBlock;     
	private String SndIgnore;    
	private Integer SndDelayByte;    
	private String SndRTS;   
	private String SndCnvtUCase;    
	private String SndIgnEmptyBlock;

	
	public PrUpDnc(String idUp, String StAtivo, String UploadPath, String UploadExt,
			String DownloadPath, String DownloadExt, String SerialPort,
			Double BaudRate, Integer DataBit, String Parity, Integer StopBit,
			String FlowControl, Double RecTimeOut,String RecIgnBefFrstEOB
			,String RecIgnAftLastEOF, String SndStartProg,String SndEndProg
			,String SndEndBlock, String SndIgnore, Integer SndDelayByte
			,String SndRTS, String SndCnvtUCase,String SndIgnEmptyBlock) {
		this.idUp = idUp;
		this.StAtivo = StAtivo;
		this.UploadPath = UploadPath;
		this.UploadExt = UploadExt;
		this.DownloadPath = DownloadPath;
		this.DownloadExt = DownloadExt;
		this.SerialPort = SerialPort;
		this.BaudRate = BaudRate;
		this.DataBit = DataBit;
		this.Parity = Parity;
		this.StopBit = StopBit;
		this.FlowControl = FlowControl;
		this.RecTimeOut = RecTimeOut;
		this.RecIgnBefFrstEOB=RecIgnBefFrstEOB;
		this.RecIgnAftLastEOF=RecIgnAftLastEOF;	
		this.SndStartProg=SndStartProg;    
		this.SndEndProg=SndEndProg;   
		this.SndEndBlock=SndEndBlock;     
		this.SndIgnore=SndIgnore;    
		this.SndDelayByte=SndDelayByte;    
		this.SndRTS=SndRTS;   
		this.SndCnvtUCase=SndCnvtUCase;    
		this.SndIgnEmptyBlock=SndIgnEmptyBlock;
	}
	
	public PrUpDnc() {
	}
	
	
	@Id
	@Column(name = "IdUP", unique = true, nullable = false, length = 36)
	public String getidUp() {
		return idUp;
	}	

	public void setidUp(String idUp) {
		this.idUp = idUp;
	}
	
	
	@Column(name = "StAtivo", nullable = false, length = 1)
	public String getStAtivo() {
		return StAtivo;
	}	

	public void setStAtivo(String StAtivo) {
		this.StAtivo = StAtivo;
	}
	
	
	@Column(name = "UploadPath", nullable = true, length = 200)
	public String getUploadPath() {
		return UploadPath;
	}	

	public void setUploadPath(String UploadPath) {
		this.UploadPath = UploadPath;
	}
	
	
	@Column(name = "UploadExt", nullable = true, length = 50)
	public String getUploadExt() {
		return UploadExt;
	}	

	public void setUploadExt(String UploadExt) {
		this.UploadExt = UploadExt;
	}
	
	
	@Column(name = "DownloadPath", nullable = true, length = 200)
	public String getDownloadPath() {
		return DownloadPath;
	}	

	public void setDownloadPath(String DownloadPath) {
		this.DownloadPath = DownloadPath;
	}
	

	@Column(name = "DownloadExt", nullable = true, length = 50)
	public String getDownloadExt() {
		return DownloadExt;
	}	

	public void setDownloadExt(String DownloadExt) {
		this.DownloadExt = DownloadExt;
	}
	

	@Column(name = "SerialPort", nullable = false, length = 1)
	public String getSerialPort() {
		return SerialPort;
	}	

	public void setSerialPort(String SerialPort) {
		this.SerialPort = SerialPort;
	}	
	
	@Column(name = "BaudRate", nullable = false, precision = 126, scale = 0)
	public Double getBaudRate() {
		return BaudRate;
	}	

	public void setBaudRate(Double BaudRate) {
		this.BaudRate = BaudRate;
	}
	
	
	@Column(name = "DataBit", nullable = false, length = 10)
	public Integer getDataBit() {
		return DataBit;
	}	

	public void setDataBit(Integer DataBit) {
		this.DataBit = DataBit;
	}
	
	
	@Column(name = "Parity", nullable = false, length = 4)
	public String getParity() {
		return Parity;
	}	

	public void setParity(String Parity) {
		this.Parity = Parity;
	}
	
	
	@Column(name = "StopBit", nullable = false, length = 10)
	public Integer getStopBit() {
		return StopBit;
	}	

	public void setStopBit(Integer StopBit) {
		this.StopBit = StopBit;
	}
	
	
	@Column(name = "FlowControl", nullable = false, length = 20)
	public String getFlowControl() {
		return FlowControl;
	}	

	public void setFlowControl(String FlowControl) {
		this.FlowControl = FlowControl;
	}
	
	
	@Column(name = "RecTimeOut", nullable = false, precision = 126, scale = 0)
	public Double getRecTimeOut() {
		return RecTimeOut;
	}	

	public void setRecTimeOut(Double RecTimeOut) {
		this.RecTimeOut = RecTimeOut;
	}
		
	@Column(name = "RecIgnBefFrstEOB", nullable = false, length = 1)
	public String getRecIgnBefFrstEOB() {
		return RecIgnBefFrstEOB;
	}	

	public void setRecIgnBefFrstEOB(String RecIgnBefFrstEOB) {
		this.RecIgnBefFrstEOB = RecIgnBefFrstEOB;
	}
	
	@Column(name = "RecIgnAftLastEOF", nullable = false, length = 1)
	public String getRecIgnAftLastEOF() {
		return RecIgnAftLastEOF;
	}	

	public void setRecIgnAftLastEOF(String RecIgnAftLastEOF) {
		this.RecIgnAftLastEOF = RecIgnAftLastEOF;
	}
	
	@Column(name = "SndStartProg", nullable = true, length = 50)
	public String getSndStartProg() {
		return SndStartProg;
	}	

	public void setSndStartProg(String SndStartProg) {
		this.SndStartProg = SndStartProg;
	}
	@Column(name = "SndEndProg", nullable = true, length = 50)
	public String getSndEndProg() {
		return SndEndProg;
	}	

	public void setSndEndProg(String SndEndProg) {
		this.SndEndProg = SndEndProg;
	}
	@Column(name = "SndEndBlock", nullable = false, length = 20)
	public String getSndEndBlock() {
		return SndEndBlock;
	}	

	public void setSndEndBlock(String SndEndBlock ) {
		this.SndEndBlock = SndEndBlock;
	}
	@Column(name = "SndIgnore", nullable = true, length = 50)
	public String getSndIgnore() {
		return SndIgnore ;
	}	

	public void setSndIgnore(String SndIgnore) {
		this.SndIgnore =SndIgnore ;
	}
	@Column(name = "SndDelayByte", nullable = false, length =5)
	public Integer getSndDelayByte() {
		return SndDelayByte;
	}	 

	public void setSndDelayByte(Integer SndDelayByte) {
		this.SndDelayByte = SndDelayByte ;
	}
	@Column(name = "SndRTS", nullable = true, length = 20)
	public String getSndRTS() {
		return SndRTS;
	}	

	public void setSndRTS(String SndRTS) {
		this.SndRTS = SndRTS;
	}
	@Column(name = "SndCnvtUCase", nullable = false, length = 1)
	public String getSndCnvtUCase() {
		return SndCnvtUCase;
	}	

	public void setSndCnvtUCase(String SndCnvtUCase) {
		this.SndCnvtUCase =SndCnvtUCase ;
	}
	@Column(name = "SndIgnEmptyBlock", nullable = false, length = 1)
	public String getSndIgnEmptyBlock() {
		return SndIgnEmptyBlock;
	}	

	public void setSndIgnEmptyBlock(String SndIgnEmptyBlock) {
		this.SndIgnEmptyBlock = SndIgnEmptyBlock;
	}
		
}
