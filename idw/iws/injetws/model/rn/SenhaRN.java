package injetws.model.rn;

public class SenhaRN {

	public static String criptografarSenha(String senha){
	    String strSequencia1;
	    String strSequencia2;
	    String strNovaSequencia;
	    String strChar1;
	    String strChar2;
	    String strSenha; 
	    String strSenhaCriptada = null;
	    //int numContador;
	    int numTamSenha;
	    int numResto;
	    int numTamSeq;
	    int numBase;
	    int numASC;
	    int i;
	    //int j;
	    boolean lTrocar;

	    strSenha = senha;

		if (strSenha != null) {
		    
		    numTamSenha = strSenha.length();
		    strSenhaCriptada = "";
		    
		    if (numTamSenha == 1) {
		            if (strSenha == ",")
		            	strSenhaCriptada = "" + (char) 0;
		            else
		            	strSenhaCriptada = strSenha;
		    }
		    else {
		            lTrocar = false;

		            //numResto = (numTamSenha mod 2);
		            numResto = numTamSenha % 2;
		            //numTamSeq = int(numTamSenha / 2);
		            numTamSeq = numTamSenha / 2;

		            //strSequencia1 = Left(strSenha, numTamSeq);
		            //strSequencia2 = Right(strSenha, numTamSeq);
		            strSequencia1 = strSenha.substring(0,numTamSeq);
		            strSequencia2 = strSenha.substring(strSenha.length()-numTamSeq,strSenha.length());
		            strNovaSequencia = "";
		            for(i=numTamSeq;i >= 1;i--){
		                if (lTrocar==true) {
		                    //strChar1 = Mid(strSequencia1, i, 1);
		                	strChar1 = strSequencia1.substring(i-1, i);
		                    //strChar2 = Mid(strSequencia2, numTamSeq - i + 1, 1);
							strChar2 = strSequencia2.substring(numTamSeq - i,numTamSeq - i + 1);

		                    lTrocar = false;
		                }
		                else {
		                    //strChar1 = Mid(strSequencia2, numTamSeq - i + 1, 1);
		                	strChar1 = strSequencia2.substring(numTamSeq - i, (numTamSeq - i)+1);
		                    //strChar2 = Mid(strSequencia1, i, 1);
		                	strChar2 = strSequencia1.substring(i-1, i);

		                    lTrocar = true;
		                }

		                strNovaSequencia = strNovaSequencia + strChar1 + strChar2;
		            }

		            if (numResto == 1) {
//		                strNovaSequencia = Left(strNovaSequencia, numTamSeq) _
//                        + Mid(strSenha, numTamSeq + 1, 1) _
//                        + Right(strNovaSequencia, numTamSeq)

		                strNovaSequencia = strNovaSequencia.substring(0,numTamSeq)
		                        + strSenha.substring(numTamSeq, numTamSeq+1)
		                        + strNovaSequencia.substring(strNovaSequencia.length()-numTamSeq, strNovaSequencia.length());
		            }

		            //j = 0;
		            for (i = 1;i<=strNovaSequencia.length();i++){
		                numBase = 256;

		                //numASC = numBase - Asc(strNovaSequencia.substring(i, i+1);
		                numASC = numBase - (int) strNovaSequencia.charAt(i-1);

		                if (numASC == 44)
		                    numASC = 0;
		                

		                strSenhaCriptada = strSenhaCriptada + (char) numASC;
		            }

		    }


		}

		return strSenhaCriptada;
		
	}
	
	public static String descriptografarSenha(String senha) {
	    String strSenhaDescriptada, strNovaSequencia="", strTmp;
	    char chrZero = (char)0, chr;

		if (senha == null) return null;
		int tamSenha = senha.length();
		if (tamSenha == 0) return senha;
				    
		if (tamSenha == 1) {
			chr = senha.charAt(0);
			if (chr == chrZero)
				strSenhaDescriptada = ",";
			else strSenhaDescriptada = senha;
			return strSenhaDescriptada;
		}
			
		// tamSenha > 1
		for (int i=0; i<tamSenha; i++) {
			int numBase = 256;
			int numASC = (int) senha.charAt(i);
			if (numASC == 0) numASC = 44;
			numASC = numBase - numASC;
			strNovaSequencia += (char) numASC;
		}
						
		int numResto = tamSenha % 2;
        int tamSeq = tamSenha / 2;
        // O valor do meio deve ser preservado nesse ponto para senha de tamanho impar
        // Tira o elemento do meio, usado para strings de tamanho impar
        char meio = strNovaSequencia.charAt(tamSeq);
        if (numResto==1) {
        	strTmp = strNovaSequencia.substring(0, tamSeq) + strNovaSequencia.substring(tamSenha-tamSeq);
        	strNovaSequencia = strTmp;
        }
        int nTam = strNovaSequencia.length();
                		
		boolean lTrocar = false;
        char chr1, chr2;
        String strEsq="", strDir="";
		for (int i=0; i<nTam; i+=2) {
			chr1 = strNovaSequencia.charAt(i);
			chr2 = strNovaSequencia.charAt(i+1);
			// troca de posicao quando lTroca for falso
		  	if (lTrocar==true) {
		  		strEsq = chr1 + strEsq;
		  		strDir = strDir + chr2;
		    } else {
		  		strEsq = chr2 + strEsq;
		  		strDir = strDir + chr1;
		    }
		  	lTrocar = !lTrocar;
		}
				
		strSenhaDescriptada = strEsq;
		if (numResto == 1) {
			strSenhaDescriptada += meio;
		}
		strSenhaDescriptada += strDir;
		return strSenhaDescriptada;
	}	
}
