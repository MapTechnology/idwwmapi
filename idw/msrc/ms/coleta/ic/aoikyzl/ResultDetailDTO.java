package ms.coleta.ic.aoikyzl;

import java.util.Date;


public class ResultDetailDTO {
	//Tabela Result
	private String pcbguid;
	private long pcbid; 
	private String machineId;
	private Date endDateTime;
	private int pcbResultBefore;
	private int pcbResultAfter;
	private int pcbRepair;
	private String allBarCode;
	private String pcbModel;
	//Tabela DefectDetail
	private String componentGuid;
	private int defect;
	
	public ResultDetailDTO(String pcbguid, long pcbid, String machineId, Date endDateTime,
			int pcbResultBefore,int pcbResultAfter,int pcbRepair, String allBarCode,
			String pcbModel, String componentGuid,int defect){

		this.pcbguid = pcbguid;
		this.pcbid = pcbid;
		this.machineId = machineId;
		this.endDateTime = endDateTime;
		this.pcbResultBefore = pcbResultBefore;
		this.pcbResultAfter = pcbResultAfter;
		this.pcbRepair = pcbRepair;
		this.allBarCode = allBarCode;
		this.pcbModel = pcbModel;
		this.componentGuid = componentGuid;
		this.defect = defect;
		
	}
	
	public String getPcbGuid() {
		return this.pcbguid;
	}
	
	public long getPcbId() {
		return this.pcbid;
	}
	
	public String getMAchineId() {
		return this.machineId;
	}
	
	public Date getEndDateTime() {
		return this.endDateTime;
	}
	
	public int getPCBResultBefore() {
		return this.pcbResultBefore;
	}
	
	public int getPCBResultAfter() {
		return this.pcbResultAfter;
	}
	
	public int getPcbRepair() {
		return this.pcbRepair;
	}
	
	public String getAllBarCode() {
		return this.allBarCode;
	}
	
	public String getPcbModel() {
		return this.pcbModel;
	}
	
	public String getComponentGuid() {
		return this.componentGuid;
	}
	
	public int getDefect() {
		return this.defect;
	}
	
	
	
	
	


}
