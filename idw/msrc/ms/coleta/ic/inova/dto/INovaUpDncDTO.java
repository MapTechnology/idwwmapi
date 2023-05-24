package ms.coleta.ic.inova.dto;

import injetws.webservices.dto.IwsUpDncDTO;

@SuppressWarnings("serial")
public class INovaUpDncDTO extends IwsUpDncDTO {
	private String codArquivo;
	private int Tpfimdebloco = 5;
	private boolean isEXT;

	void setisEXT(boolean isEXT) {
		this.isEXT = isEXT;
	}
	public boolean getisEXT() {
		return this.isEXT;
	}

	public int getTpfimdebloco() {
		return this.Tpfimdebloco;
	}
	
	public String getcodArquivo() {
		return codArquivo;
	}
	public void setcodArquivo(String codArquivo) {
		this.codArquivo = codArquivo;
	}

	public void copyUpDncDTOWs(IwsUpDncDTO oUpDncDTOWs) {
		this.setidUp(oUpDncDTOWs.getidUp());
		this.setStAtivo(oUpDncDTOWs.getStAtivo());
		this.setUploadPath(oUpDncDTOWs.getUploadPath());
		this.setUploadExt(oUpDncDTOWs.getUploadExt());
		this.setDownloadPath(oUpDncDTOWs.getDownloadPath());
		this.setDownloadExt(oUpDncDTOWs.getDownloadExt());
		this.setBaudRate(oUpDncDTOWs.getBaudRate());
		this.setDataBit(oUpDncDTOWs.getDataBit());
		this.setStopBit(oUpDncDTOWs.getStopBit());
		this.setParity(oUpDncDTOWs.getParity());
		this.setFlowControl(oUpDncDTOWs.getFlowControl());
		this.setSerialPort(oUpDncDTOWs.getSerialPort());
		this.setTpFimArquivo(oUpDncDTOWs.getTpFimArquivo());
		this.setTpIniArquivo(oUpDncDTOWs.getTpIniArquivo());
		
		if(oUpDncDTOWs.getTpFimBloco().equals("CR"))
			this.Tpfimdebloco = 1;
		else if(oUpDncDTOWs.getTpFimBloco().equals("LF"))
			this.Tpfimdebloco = 2;
		else if(oUpDncDTOWs.getTpFimBloco().equals("CR LF"))
			this.Tpfimdebloco = 3;
		else if(oUpDncDTOWs.getTpFimBloco().equals("LF CR"))
			this.Tpfimdebloco = 4;
		else if(oUpDncDTOWs.getTpFimBloco().equals("LF CR CR"))
			this.Tpfimdebloco = 5;
		
		this.setcodErro(oUpDncDTOWs.getcodErro());
	}
}
