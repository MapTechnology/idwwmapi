package idw.util;

import java.math.BigDecimal;
import java.util.Objects;

import org.apache.commons.lang3.ObjectUtils;

public final class CompareUtils {
	
	public static boolean equals(double a, double b){
		return Objects.equals(a, b);
	}

	public static boolean equals(String a, String b){
		return Objects.equals(a, b);
	}
	
	public static boolean equals(Double a, Double b){
		return Objects.equals(a, b);
	}
	
	public static boolean equals(Long a, Long b){
		return Objects.equals(a, b);
	}

	public static boolean equals(long a, long b){
		return Objects.equals(a, b);
	}
	
	public static boolean equals(byte a, byte b){
		return Objects.equals(a, b);
	}

	public static boolean equals(Byte a, Byte b){
		return Objects.equals(a, b);
	}

	public static boolean equals(int a, int b){
		return Objects.equals(a, b);
	}

	public static boolean equals(Integer a, Integer b){
		return Objects.equals(a, b);
	}

	public static boolean equals(BigDecimal o1, BigDecimal o2){
		o1 = Util.getBigDecimalDefault(ObjectUtils.defaultIfNull(o1, BigDecimal.ZERO));
		o2 = Util.getBigDecimalDefault(ObjectUtils.defaultIfNull(o2, BigDecimal.ZERO));
		return  o1.equals(o2);
	}

	public static int compareTo(BigDecimal o1, BigDecimal o2){
		o1 = Util.getBigDecimalDefault(ObjectUtils.defaultIfNull(o1, BigDecimal.ZERO));
		o2 = Util.getBigDecimalDefault(ObjectUtils.defaultIfNull(o2, BigDecimal.ZERO));
		return o1.compareTo(o2);
	}

	
	
	
}
