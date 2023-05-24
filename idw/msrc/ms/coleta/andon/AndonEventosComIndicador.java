package ms.coleta.andon;

import ms.coleta.dto.AndonArgsDTO;
import ms.coleta.dto.AndonDTO;
import ms.model.dto.UpDTO;
import ms.excessao.AndonFalhouException;

public class AndonEventosComIndicador implements IAndon {

	@Override
	public boolean executaAndon(UpDTO UpDTO, AndonDTO andondto) throws AndonFalhouException {
		
		AndonArgsDTO argumentoAndon = andondto.getAndonArgs().get(0);
	    return verificaEventoComIndicadores(argumentoAndon, andondto.getIndicador());	    
	}
	
    private boolean verificaEventoComIndicadores(AndonArgsDTO argumento, Double parametro)
    {          
    	//String equacao = String.valueOf(argumento.getIndicador()) + argumento.getOperadorcalculo() + argumento.getVlreferencianum();
    	
        if (argumento.getOperadorcalculo().compareTo("<=") == 0 && parametro <= argumento.getVlreferencianum())
        	return true;
        else if (argumento.getOperadorcalculo().compareTo(">=") == 0 && parametro >= argumento.getVlreferencianum())
        	return true;
        else if (argumento.getOperadorcalculo().compareTo("<>") == 0 && parametro != argumento.getVlreferencianum())
        	return true;
        else if (argumento.getOperadorcalculo().compareTo(">") == 0 && parametro > argumento.getVlreferencianum())
        	return true;
        else if (argumento.getOperadorcalculo().compareTo("<") == 0 && parametro < argumento.getVlreferencianum())
        	return true;
        else if (argumento.getOperadorcalculo().compareTo("=") == 0 && parametro.equals(argumento.getVlreferencianum()))
        	return true;                    
        else
        	return false;
    }
}