package ms.coleta.ic.micrologix.defines;


public interface MicrologixDefines {
	
	  
	/*  
	 * Define endereços dos registradores tipo COIL boolean 
	 */
  public static final int COIL_ISCONECTADO 	= 0;  // Flag somente escrita deve ser setado =true em todo evento 

  	/*  
	 * Define endereços dos registradores tipo WORD 16bits 
	 */
  public static final int WORD_VERSAO	= 0; // Versão N15:0
  public static final int WORD_TEMP1	= 1; // indice da TEMPERATURA do canal 1 N15:1
  public static final int WORD_TEMP2	= 2; // indice da TEMPERATURA do canal 2 N15:2
  public static final int WORD_TEMP3	= 3; // indice da TEMPERATURA do canal 3 N15:3
  public static final int WORD_TEMP4	= 4; // indice da TEMPERATURA do canal 4 N15:4

  
}

