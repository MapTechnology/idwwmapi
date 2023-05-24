package idw.model.rn.impprog.siemens;

import java.util.ArrayList;
import java.util.List;

public class FeederSiemens {
	public String FeederOID;
	public String TableOID;
	public String TrackNr;
	public String Feedertype;
	public String FeederSortNr;
	public String IsTray;
	public List<DivisionSiemens> componentes = new ArrayList<DivisionSiemens>();
	public String getFeederOID() {
		return FeederOID;
	}
	public void setFeederOID(String feederOID) {
		FeederOID = feederOID;
	}
	public String getTableOID() {
		return TableOID;
	}
	public void setTableOID(String tableOID) {
		TableOID = tableOID;
	}
	public String getTrackNr() {
		return TrackNr;
	}
	public void setTrackNr(String trackNr) {
		TrackNr = trackNr;
	}
	public String getFeedertype() {
		return Feedertype;
	}
	public void setFeedertype(String feedertype) {
		Feedertype = feedertype;
	}
	public String getFeederSortNr() {
		return FeederSortNr;
	}
	public void setFeederSortNr(String feederSortNr) {
		FeederSortNr = feederSortNr;
	}
	public String getIsTray() {
		return IsTray;
	}
	public void setIsTray(String isTray) {
		IsTray = isTray;
	}
	public List<DivisionSiemens> getComponentes() {
		return componentes;
	}
	public void setComponentes(List<DivisionSiemens> componentes) {
		this.componentes = componentes;
	}
	
	
}
