package idw.util;

import java.math.BigDecimal;
import java.util.Date;

import idw.model.pojos.template.AbstractTemplate;

public final class CloneUtil {

	/**
	 * @deprecated tipo primitivo não precisa de clone
	 * @param v
	 * @return
	 */	public static int clone(int v){
		return v;
	}

	/**
	 * @deprecated tipo primitivo não precisa de clone
	 * @param v
	 * @return
	 */	public static byte clone(byte v){
		return v;
	}

	@Deprecated
	public static long clone(long v){
		return v;
	}

	/**
	 * @deprecated tipo primitivo não precisa de clone
	 * @param v
	 * @return
	 */
	public static double clone(double v){
		return v;
	}

	/**
	 * @deprecated objeto imutável não precisa de clone
	 * @param v
	 * @return
	 */
	public static String clone(String v){
		return v;
	}

	/**
	 * @deprecated objeto imutável não precisa de clone
	 * @param v
	 * @return
	 */
	public static Byte clone(Byte v){
		return v;
	}

	/**
	 * @deprecated objeto imutável não precisa de clone
	 * @param v
	 * @return
	 */
	public static Long clone(Long v){
		return v;
	}

	/**
	 * @deprecated objeto imutável não precisa de clone
	 * @param v
	 * @return
	 */
	public static Double clone(Double v){
		return v;
	}

	/**
	 * @deprecated objeto imutável não precisa de clone
	 * @param v
	 * @return
	 */
	public static Integer clone(Integer v){
		return v;
	}

	/**
	 * @deprecated objeto imutável não precisa de clone
	 * @param v
	 * @return
	 */
	public static Float clone(Float v){
		return v;
	}

	/**
	 * @deprecated objeto imutável não precisa de clone
	 * @param v
	 * @return
	 */
	public static Boolean clone(Boolean v){
		return v;
	}

	/**
	 * @deprecated objeto imutável não precisa de clone
	 * @param v
	 * @return
	 */
	public static Short clone(Short v){
		return v;
	}

	/**
	 * @deprecated objeto imutável não precisa de clone
	 * @param v
	 * @return
	 */	
	public static Date clone(Date v){
		return (v == null? null: (Date) v.clone());
	}
	
	/**
	 * @deprecated objeto imutável não precisa de clone
	 * @param v
	 * @return
	 */	 
	public static BigDecimal clone(BigDecimal v){
		return v;
	}


	public static <T> T clone(AbstractTemplate<T> obj, boolean isCopiarFK){
		return (obj == null? null: obj.clone(isCopiarFK));
	}

}
