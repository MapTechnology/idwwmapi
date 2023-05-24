package idw.util;

import org.apache.commons.lang.exception.ExceptionUtils;

public final class ErrorUtils {
	public static String getStackTraceString(Throwable e){
		return ExceptionUtils.getStackTrace(e);		
	}
}
