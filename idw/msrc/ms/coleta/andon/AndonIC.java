package ms.coleta.andon;

import java.util.ArrayList;
import java.util.List;

import ms.coleta.dto.AndonDTO;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;

public class AndonIC {
	
	public AndonIC() {
		
	}
	
	public List<AndonDTO> verificaEventosAndonAtivos(IcDTO msicdto) {
		AndonUP andonUp = new AndonUP();
		boolean isPrimeiraUp = true;
		List<AndonDTO> dadosAndonAtivos = new ArrayList<AndonDTO>();
		boolean calculoAndonTurno = msicdto.getTpCalculoAndon() == 1? true : false;
		
	    for (IcUpDTO msupdto : msicdto.getMsIcUpDTOLocais())
	    {
	        int idSaida;
	        List<AndonDTO> dadosAndonParaUp = null;
	        
	        AndonDTO dadosSaidaAtual = null;
	        dadosAndonParaUp = andonUp.estadoAndonUp(msupdto.getUpDTO(), calculoAndonTurno);
	        
	        if (isPrimeiraUp) {
	        	isPrimeiraUp = false;
	        	dadosAndonAtivos = new ArrayList<AndonDTO>(dadosAndonParaUp.size());
	        	dadosAndonAtivos.addAll(dadosAndonParaUp);	           
	        }
	        else
	        {
	        	for (int i = 0; i < dadosAndonAtivos.size(); i++)
	            {
	                dadosSaidaAtual = dadosAndonParaUp.get(i);
	                idSaida = dadosSaidaAtual.getIdrele();
	                if (idSaida == 0)
	                    continue;
	
	                AndonDTO paramAndonAtual = dadosAndonAtivos.get(idSaida - 1);
	
	                if (dadosSaidaAtual.getPrioridade() <= paramAndonAtual.getPrioridade())
	                {
	                    paramAndonAtual = dadosSaidaAtual;
	                    dadosAndonAtivos.set(idSaida - 1, paramAndonAtual);
	                }
	            }//for
	        }        
	    }//for
	    return dadosAndonAtivos;
	}
}
