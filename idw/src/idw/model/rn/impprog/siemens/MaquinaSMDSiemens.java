package idw.model.rn.impprog.siemens;

import java.util.ArrayList;
import java.util.List;

public class MaquinaSMDSiemens {

	public String MachineOID;
    public String LineOID;
    public String MachineName;
    public String MachineType;
    public String MachineNr;
    public List<TableMaquinaSiemens> tablesmaquinas = new ArrayList<TableMaquinaSiemens>();
    
	public String getMachineOID() {
		return MachineOID;
	}
	public void setMachineOID(String machineOID) {
		MachineOID = machineOID;
	}
	public String getLineOID() {
		return LineOID;
	}
	public void setLineOID(String lineOID) {
		LineOID = lineOID;
	}
	public String getMachineName() {
		return MachineName;
	}
	public void setMachineName(String machineName) {
		MachineName = machineName;
	}
	public String getMachineType() {
		return MachineType;
	}
	public void setMachineType(String machineType) {
		MachineType = machineType;
	}
	public String getMachineNr() {
		return MachineNr;
	}
	public void setMachineNr(String machineNr) {
		MachineNr = machineNr;
	}
    public List<TableMaquinaSiemens> getTablesmaquinas() {
		return tablesmaquinas;
	}
	public void setTablesmaquinas(List<TableMaquinaSiemens> tablesmaquinas) {
		this.tablesmaquinas = tablesmaquinas;
	}
}
