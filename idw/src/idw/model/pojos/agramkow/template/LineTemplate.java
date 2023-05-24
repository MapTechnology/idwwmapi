package idw.model.pojos.agramkow.template;

import idw.model.pojos.agramkow.Line;

public abstract class LineTemplate implements Cloneable{
	
	@Override
	public Object clone() {
		Line objetoPojo = (Line) this;
		
		Line clone = new Line();
		
		clone.setChangedBy(objetoPojo.getChangedBy());
		clone.setChangedDate(objetoPojo.getCreatedDate());
		clone.setCreatedBy(objetoPojo.getCreatedBy());
		clone.setCreatedDate(objetoPojo.getCreatedDate());
		clone.setDeleted(objetoPojo.getDeleted());
		clone.setDescription(objetoPojo.getDescription());
		clone.setDescriptor(objetoPojo.getDescriptor());
		//clone.setFactoryId(objetoPojo.getFactoryId());
		//clone.setLineId(objetoPojo.getLineId());
		clone.setId(objetoPojo.getId());
		
		clone.setNote(objetoPojo.getNote());
		//clone.setServer(objetoPojo.getServer());
		clone.setServers(objetoPojo.getServers());
		
		return clone;

	  }
	
	public void copy(Line omFrom,boolean copiarFK){

		Line omTo = (Line) this;
		
		omTo.setChangedBy(omFrom.getChangedBy());
		omTo.setChangedDate(omFrom.getCreatedDate());
		omTo.setCreatedBy(omFrom.getCreatedBy());
		omTo.setCreatedDate(omFrom.getCreatedDate());
		omTo.setDeleted(omFrom.getDeleted());
		omTo.setDescription(omFrom.getDescription());
		omTo.setDescriptor(omFrom.getDescriptor());
		//omTo.setFactoryId(omFrom.getFactoryId());
		//omTo.setLineId(omFrom.getLineId());
		omTo.setId(omFrom.getId());
		omTo.setNote(omFrom.getNote());
		//omTo.setServer(omFrom.getServer());		
		omTo.setServers(omFrom.getServers());
		if (copiarFK){
		}
	}
}
