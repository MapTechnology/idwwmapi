package ms.coleta.andon;

import java.util.List;
import java.util.ArrayList;

import ms.coleta.dto.*;
import ms.excessao.AndonFalhouException;
import ms.model.dto.UpDTO;

public class AndonUP {
	
	@SuppressWarnings("rawtypes")
	private List<Class> andonDisponiveis = new ArrayList<Class>();
	
	public AndonUP() {
		andonDisponiveis.add(AndonParada.class);					//tpevento 1 - m�quina parada em c�digo espec�fico
		andonDisponiveis.add(AndonAlerta.class);					//tpevento 2 - alertas
		andonDisponiveis.add(AndonInspecaoPendente.class);			//tpevento 3 - inspe��o pendente
		andonDisponiveis.add(AndonResultadoUltimaInpecao.class);	//tpevento 4 - resultado reprovado
		andonDisponiveis.add(AndonResultadoUltimaInpecao.class);	//tpevento 5 - resultado aprovado com restri��o
		andonDisponiveis.add(AndonResultadoUltimaInpecao.class);	//tpevento 6 - resultado aprovado
		andonDisponiveis.add(AndonMaquinaTrabalhando.class);		//tpevento 7 - m�quina trabalhando
		andonDisponiveis.add(AndonEventosComIndicador.class);		//tpevento 8 - efici�ncia do �ltimo ciclo
		andonDisponiveis.add(AndonEventosComIndicador.class);		//tpevento 9 - �ndice de parada
		andonDisponiveis.add(AndonEventosComIndicador.class);		//tpevento 10 - �ndice de refugo
		andonDisponiveis.add(AndonEventosComIndicador.class);		//tpevento 11 - OEE
		andonDisponiveis.add(AndonEventosComIndicador.class);		//tpevento 12 - efici�ncia de realiza��o
		andonDisponiveis.add(AndonTodasParadas.class);				//tpevento 13 - m�quina parada
		andonDisponiveis.add(AndonVariacaoRitmo.class);				//tpevento 14 - solicita��o de varia��o de ritmo pendente
	}
	
    public List<AndonDTO> estadoAndonUp(UpDTO UpDTO, boolean calculoAndonTurno) {
    	AndonDTO eventoAndonParaExecutar;
        List<AndonDTO> listaEventosAndonAltaPrioridade = new ArrayList<AndonDTO>();
        //inicializa a lista de eventos de maior prioridade a serem executados
        for (int i = 0; i < 16; i++)
        {
        	listaEventosAndonAltaPrioridade.add(new AndonDTO());
        	listaEventosAndonAltaPrioridade.get(i).setIdup("");
        	listaEventosAndonAltaPrioridade.get(i).setIdrele(i + 1);
        	listaEventosAndonAltaPrioridade.get(i).setPrioridade(Integer.MAX_VALUE);
        }

        List<AndonDTO> localDadosAndon = new ArrayList<AndonDTO>();
       	localDadosAndon =  UpDTO.getListaEventosAndonUp();
        
        //busca UpDTO para trabalhar com os estados atuais da unidade produtiva
        

        if (localDadosAndon == null || UpDTO.getIdUp() == null || UpDTO.getIsComOP() == false)
        {
            //controle de erro: caso a lista de eventos de ando n�o tenha sido recebida ou inicializada
            return listaEventosAndonAltaPrioridade;
        }

        for (AndonDTO dadosAndon : localDadosAndon) {        
            if (dadosAndon.getStativo() == 0)
                continue;
            
            if (calculoAndonTurno == true)
                dadosAndon.setIndicador(dadosAndon.getIndicadorTurno());	//se a configura��o for por turno, usa o segundo valor (per�odo = 2)
            else
                dadosAndon.setIndicador(dadosAndon.getIndicadorHora());		//se a configura��o for por hora, usa o primeiro valor (per�odo = 1)                      

            eventoAndonParaExecutar = new AndonDTO();

            int idAndon = dadosAndon.getTpeventoandon() - 1;
            boolean isEventoAtivaSaida = false;
            if(idAndon == 7)
            	dadosAndon.setIndicador(UpDTO.getVlEficienciaUltimoCiclo());

   			IAndon andon = null;
			try {
				andon = (IAndon) andonDisponiveis.get(idAndon).newInstance();
			} catch (InstantiationException e) {
				throw new RuntimeException("Nao foi possivel criar o servico: " + idAndon);
			} catch (IllegalAccessException e) {
				throw new RuntimeException("Nao foi possivel criar o servico: " + idAndon);
			}
   			try {
				isEventoAtivaSaida = andon.executaAndon(UpDTO, dadosAndon);
			} catch (AndonFalhouException e) {
				throw new RuntimeException("Nao foi possivel criar o servico: " + idAndon);
			}

    		if(isEventoAtivaSaida == true)
    			eventoAndonParaExecutar.copyAndonDTO(dadosAndon);
    		
            int indRele = eventoAndonParaExecutar.getIdrele();
            if (indRele > 0)
            {
                if (eventoAndonParaExecutar.getPrioridade() <= listaEventosAndonAltaPrioridade.get(indRele - 1).getPrioridade() )
                {
                	listaEventosAndonAltaPrioridade.set(indRele - 1,new AndonDTO(eventoAndonParaExecutar)); 
//                	listaEventosAndonAltaPrioridade.get(indRele - 1).copyAndonDTO(eventoAndonParaExecutar);
                }
            }                
        }
        return listaEventosAndonAltaPrioridade;
    }


}
