package ms.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ConversaoTipos {

	public static char converterParaChar(double valor) {
		return (char) valor;
	}

	public static long converterParaLong(double valor) {
		return (long) valor;
	}

	public static long converterParaLong(String valor) {
		return Long.parseLong(valor);
	}
	
	public static String converteParaStringUsandoVirgula(BigDecimal x, int casasDecimais) {
		if(x == null || x.doubleValue() == 0) {
			return "0";
		}
		
		try {
			return String.format("%." + casasDecimais + "f", x);
		} catch (Exception e) {
			return "0";
		}
	}

	public static String converteParaString(Double x, int casasDecimais) {
		try {
			// limita o n�mero de casas decimais
			String string = String.format("%." + casasDecimais + "f", x);
			if (string.equals("NaN")) {
				string = String.format("%." + casasDecimais + "f", 0.0);
			}
						
			return string.replaceAll(",", ".");
		} catch (Exception e) {
			return String.format("%." + casasDecimais + "f", 0.0);
		}
	}

	public static String converteParaString(Integer x) {
		try {
			return String.valueOf(x);
		} catch (Exception e) {
			return "0";
		}
	}
	public static String converteParaString(Long x) {
		try {
			return String.valueOf(x);
		} catch (Exception e) {
			return "0";
		}
	}

	public static String converteParaString(BigInteger x) {
		try {
			return String.valueOf(x);
		} catch (Exception e) {
			return "0";
		}
	}
	
	public static String converteParaString(Double x, int casasDecimais, boolean isRetornarStringVaziaSeValorForNulo) {
		if(x == null && isRetornarStringVaziaSeValorForNulo) {
			return "";
		}
		return converteParaString(x, casasDecimais);
	}
	
	public static String converteParaString(String xx, int casasDecimais) {
		try {
			// limita o n�mero de casas decimais
			Double x = Double.parseDouble(xx);
			String string = String.format("%." + casasDecimais + "f", x);
			return string.replaceAll(",", ".");
		} catch (Exception e) {
			return "0.0";
		}
	}
	
	public static String converteParaString(Float x, int casasDecimais) {
		if (x != null)
			return converteParaString((double) x, casasDecimais);
		return "0.0";
	}

	public static String converteDecimalParaString(Double x, int casasDecimais) {
		if (x != null) {

			BigDecimal bd = new BigDecimal(x);
			bd = bd.setScale(casasDecimais, BigDecimal.ROUND_HALF_EVEN);
			return bd.toString();
		}
		return "0.0";
	}

	public static Double converteParaDouble(Double x, int casasDecimais) {
		String valor = converteParaString(x, casasDecimais);
		valor = valor.replaceAll(",", ".");
		return Double.valueOf(valor);
	}

	public static Double converteParaDouble(String x) {
		x = x.replaceAll(",", ".");
		if (x.isEmpty())
			return 0d;
		return Double.valueOf(x);
	}

	public static String converteParaString(BigDecimal x, int casasDecimais) {
		if (x != null)
			return converteParaString(x.doubleValue(), casasDecimais);
		return "0.0";
	}

    // Usado para remover os decimais quando forem zerados
    public static String converteParaStringCasasOpcionais(Double x, int casas) {
        String retorno = converteParaStringComFormat(x, casas);
        if (retorno.substring(retorno.length()-casas).equals(UtilsString.repeat("0", casas)))
            retorno = retorno.substring(0, retorno.length()-casas-1);
        return retorno;
    }
    public static String converteParaStringCasasOpcionais(BigDecimal x, int casas) {
        String retorno = converteParaString(x, casas);
        if (retorno.substring(retorno.length()-casas).equals(UtilsString.repeat("0", casas)))
            retorno = retorno.substring(0, retorno.length()-casas-1);
        return retorno;
    }
	
	public static char converterParaChar(Byte b) {
		return (char)b.byteValue();
	}
	
	public static String converterParaString(Byte b) {
		return b.toString();
	}

	public static Byte converterParaByte(Character valor) {
		return (byte) valor.charValue();
	}

	public static Byte converterParaByte(String valor) {
		Byte retorno;
		try {
			retorno = new Byte(valor);
		} catch (NumberFormatException e) {
			retorno = (byte) valor.charAt(0);
		}

		return retorno;
	}

	public static BigDecimal converterParaBigDecimal(Object objNumerico) {
		BigDecimal retorno = null;

		if (objNumerico == null) {
			retorno = BigDecimal.ZERO;
		} else {
			if (objNumerico instanceof Byte) {
				retorno = new BigDecimal((Byte) objNumerico);
			}

			if (objNumerico instanceof BigInteger) {
				retorno = new BigDecimal((BigInteger) objNumerico);
			}

			if (objNumerico instanceof Integer) {
				retorno = new BigDecimal((Integer) objNumerico);
			}

			if (objNumerico instanceof Short) {
				retorno = new BigDecimal((Short) objNumerico);
			}

			
			if (objNumerico instanceof Long) {
				retorno = new BigDecimal((Long) objNumerico);
			}

			if (objNumerico instanceof Double) {
				retorno = new BigDecimal((Double) objNumerico);
			}

			if (objNumerico instanceof Float) {
				retorno = new BigDecimal((Float) objNumerico);
			}

			
			if (objNumerico instanceof BigDecimal) {
				retorno = (BigDecimal) objNumerico;
			}

			if (objNumerico instanceof String) {
				
				return new BigDecimal(objNumerico.toString().replaceAll(",", "."));
			}

			if (objNumerico instanceof Character) {
				
				return new BigDecimal(objNumerico.toString());
			}
		}
		
		

		
		return retorno;
	}
	
    public static int converterParaInt(String valor) {
        valor = valor.replaceAll("\\D+","");
        return Integer.valueOf(valor);
    }

    public static BigDecimal converteHoraParaBigDecimal(String hora) {
        BigDecimal n3600 = new BigDecimal(3600);
        BigDecimal n60 = new BigDecimal(60);

        BigDecimal nHor, nMin, nSeg, retorno;
        Integer nTamStrHora, nNegativo;

        nNegativo = 1;

        nHor = BigDecimal.ZERO;
        nMin = BigDecimal.ZERO;
        nSeg = BigDecimal.ZERO;
        retorno = BigDecimal.ZERO;

        try {
            if (hora.matches("-")) {
                if (hora.indexOf("-1") == 0) {
                    nNegativo = -1;
                } else {
                    // posição do sinal negativo está errada. Formato de hora inválido
                    return null;
                }
            }

            nTamStrHora = hora.indexOf(":");
            nHor = converteParaBigDecimal(hora.substring(0, nTamStrHora));
            hora = hora.substring(nTamStrHora + 1);
            nMin = converteParaBigDecimal(hora.substring(0, 2));
            hora = hora.substring(3); // hora.substring(nTamStrHora + 1);
            nSeg = converteParaBigDecimal(hora.substring(0, 2));

            retorno = retorno.add(nHor.multiply(n3600));
            retorno = retorno.add(nMin.multiply(n60));
            retorno = retorno.add(nSeg);
            retorno = retorno.multiply(new BigDecimal(nNegativo));

            return retorno;

        } catch (Exception e) {
            return null;
        }

    }
    public static int converteParaInt(String valor) {
        valor = valor.replaceAll("\\D+","");
        return Integer.valueOf(valor);
    }
    public static BigDecimal converteParaBigDecimal(String valor) {
        BigDecimal retorno;
        try {
            if (valor.contains(",")) {
                valor = valor.replace(",", ".");
            }
            retorno = new BigDecimal(valor);
        } catch (NumberFormatException e) {
            retorno = null;
        }
        return retorno;
    }

    public static BigInteger converteParaBigInteger(String valor) {
        BigInteger retorno;
        try {
               if (valor.contains(",")) {
                valor = valor.replace(",", ".");
            }
            retorno = new BigInteger(valor);
        } catch (NumberFormatException e) {
            retorno = null;
        }
        return retorno;
    }
    
	public static String converteParaStringComFormat(Double x, int casasDecimais) {
		String string = "";
	
		if (x == null) {
			x = 0d;
		}
		
		// limita o numero de casas decimais
		string = String.format("%." + casasDecimais + "f", x);
		
		return string;			
	}
	
	public static String converteStringParaSequenciaNumericaUniCode(String texto) {
		String retorno = "";
		
		for (int i= 0 ; i < texto.length(); i++) {
			Integer codUniCode = (int) texto.charAt(i);
			retorno = retorno.concat(codUniCode.toString().trim()) ;
		}		
		
		return retorno;
	}

	public static BigInteger converteHexParaDecimal(String hex) {
		return new BigInteger(hex, 16);
	}

	public static String converteDecimalParaHex(BigInteger valor) {
		return String.format("%X", valor);
	}
}
