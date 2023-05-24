package idw.model.rn.impprog.siemens;

import java.util.ArrayList;
import java.util.List;

public class TableMaquinaSiemens {

	public String TableOID;
	public String MachineOID;
	public String TableName;
	public String TableNr;
	public String TableType;
	public String TableIsConstant;
	public List<FeederSiemens> feeders = new ArrayList<FeederSiemens>();
	
	public List<FeederSiemens> getFeeders() {
		return feeders;
	}
	public void setFeeders(List<FeederSiemens> feeders) {
		this.feeders = feeders;
	}
	public String getTableOID() {
		return TableOID;
	}
	public void setTableOID(String tableOID) {
		TableOID = tableOID;
	}
	public String getMachineOID() {
		return MachineOID;
	}
	public void setMachineOID(String machineOID) {
		MachineOID = machineOID;
	}
	public String getTableName() {
		return TableName;
	}
	public void setTableName(String tableName) {
		TableName = tableName;
	}
	public String getTableNr() {
		return TableNr;
	}
	public void setTableNr(String tableNr) {
		TableNr = tableNr;
	}
	public String getTableType() {
		return TableType;
	}
	public void setTableType(String tableType) {
		TableType = tableType;
	}
	public String getTableIsConstant() {
		return TableIsConstant;
	}
	public void setTableIsConstant(String tableIsConstant) {
		TableIsConstant = tableIsConstant;
	}
	public String getTableIsSplitMode() {
		return TableIsSplitMode;
	}
	public void setTableIsSplitMode(String tableIsSplitMode) {
		TableIsSplitMode = tableIsSplitMode;
	}
	public String getTableSplitLevel() {
		return TableSplitLevel;
	}
	public void setTableSplitLevel(String tableSplitLevel) {
		TableSplitLevel = tableSplitLevel;
	}
	public String getHasNozzleChanger() {
		return HasNozzleChanger;
	}
	public void setHasNozzleChanger(String hasNozzleChanger) {
		HasNozzleChanger = hasNozzleChanger;
	}
	public String getNzzChType() {
		return NzzChType;
	}
	public void setNzzChType(String nzzChType) {
		NzzChType = nzzChType;
	}
	public String getTableLocationName() {
		return TableLocationName;
	}
	public void setTableLocationName(String tableLocationName) {
		TableLocationName = tableLocationName;
	}
	public String getHasNozzleChanger2() {
		return HasNozzleChanger2;
	}
	public void setHasNozzleChanger2(String hasNozzleChanger2) {
		HasNozzleChanger2 = hasNozzleChanger2;
	}
	public String getAllMagNozzlesEqual() {
		return AllMagNozzlesEqual;
	}
	public void setAllMagNozzlesEqual(String allMagNozzlesEqual) {
		AllMagNozzlesEqual = allMagNozzlesEqual;
	}
	public String getNzzChType2() {
		return NzzChType2;
	}
	public void setNzzChType2(String nzzChType2) {
		NzzChType2 = nzzChType2;
	}
	public String getNzzChType3() {
		return NzzChType3;
	}
	public void setNzzChType3(String nzzChType3) {
		NzzChType3 = nzzChType3;
	}
	public String getNzzChType4() {
		return NzzChType4;
	}
	public void setNzzChType4(String nzzChType4) {
		NzzChType4 = nzzChType4;
	}
	public String getHasTray() {
		return HasTray;
	}
	public void setHasTray(String hasTray) {
		HasTray = hasTray;
	}
	public String getLocationBarcode1() {
		return LocationBarcode1;
	}
	public void setLocationBarcode1(String locationBarcode1) {
		LocationBarcode1 = locationBarcode1;
	}
	public String getLocationBarcode2() {
		return LocationBarcode2;
	}
	public void setLocationBarcode2(String locationBarcode2) {
		LocationBarcode2 = locationBarcode2;
	}
	public String TableIsSplitMode;
	public String TableSplitLevel;
	public String HasNozzleChanger;
	public String NzzChType;
	public String TableLocationName;
	public String HasNozzleChanger2;
	public String AllMagNozzlesEqual;
	public String NzzChType2;
	public String NzzChType3;
	public String NzzChType4;
	public String HasTray;
	public String LocationBarcode1;
	public String LocationBarcode2;
	  
	
}
