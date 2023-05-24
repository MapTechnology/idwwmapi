package idw.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class HashCodeBuilderIdw extends HashCodeBuilder{
	
	
	public HashCodeBuilder appendBigDecimal(BigDecimal o) {
		if(o != null){
			return super.append(Util.getBigDecimalDefault(o));
		}
	
		return super.append(o);
	}

	@Override
	public HashCodeBuilder append(Object object) {
		if(object != null){
			if(object instanceof BigDecimal){
				return appendBigDecimal((BigDecimal)object);
			}
		}
		return super.append(object);
	}

}
