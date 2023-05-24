package idw.model.rn.geraplano.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwCalsem;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class IndisponibilidadesDTO {
	private List<IndisponibilidadeDTO> listaIndisponibilidades = new ArrayList<IndisponibilidadeDTO>();
//	private List<DwCalsem> listaDwcalsem = new ArrayList<DwCalsem>();
	
	public void setListaIndisponibilidades(
			List<IndisponibilidadeDTO> listaIndisponibilidades) {
		this.listaIndisponibilidades = listaIndisponibilidades;
	}
	public void addIndisponibilidade(Date inicio, Date fim){
		if (listaIndisponibilidades == null)
			this.listaIndisponibilidades = new ArrayList<IndisponibilidadeDTO>();
		
		IndisponibilidadeDTO indisponibilidade = new IndisponibilidadeDTO();
		indisponibilidade.setInicio(inicio);
		indisponibilidade.setFim(fim);
		this.listaIndisponibilidades.add(indisponibilidade);
		
	}
	/* Alessandre: Remover o dwcalsem pois o algoritmo agora preenche a listaIndisponibilidade apenas
	public void addCalendarioIndisponivel(DwCalsem dwcalsem){
		if (listaDwcalsem != null)
			this.listaDwcalsem = new ArrayList<DwCalsem>();
		
		this.listaDwcalsem.add(dwcalsem);
	}*/
	public List<IndisponibilidadeDTO> getListaIndisponibilidades() {
		return listaIndisponibilidades;
	}
	
	public void removerDwCalsem(Date data, DwCalsem dwcalsem,IdwLogger log){
		int horaI = Integer.parseInt(dwcalsem.getHrInicialGui().substring(0, 2));
		int minutoI = Integer.parseInt(dwcalsem.getHrInicialGui().substring(3));
		int segundoI = 0;
		
		int horaF = Integer.parseInt(dwcalsem.getHrFinalGui().substring(0, 2));
		int minutoF = Integer.parseInt(dwcalsem.getHrFinalGui().substring(3));
		int segundoF = 0;

		// Se a hora tiver um periodo de tempo indisponivel, entao devemos remover esse periodo improdutivo do inicio
		// da hora
		if (dwcalsem.getSegTempocalsempeso() != null && dwcalsem.getSegTempocalsempeso().intValue() > 0){
			int horaSeg = (horaI * 3600) + (minutoI * 60) + segundoI;
//			int horaSeg = (horaF * 3600) + (minutoF * 60) + segundoF;
			
			horaSeg += (dwcalsem.getSegTempocalsempeso().intValue() * 60);
			
			horaI = DataHoraRN.obtemApenasHHDoSegundos(horaSeg);
			minutoI = DataHoraRN.obtemApenasMMDoSegundos(horaSeg);
			segundoI = DataHoraRN.obtemApenasSSDoSegundos(horaSeg);
		}
		
		Date inicio = DataHoraRN.setHoraNaData(data, horaI, minutoI, segundoI, 0);
		Date fim = DataHoraRN.setHoraNaData(data, horaF, minutoF, segundoF, 0);
		
		// Varrer todos os intervalos improdutivos para poder remover deles os horarios produtivos
		List<IndisponibilidadeDTO> novasIndisp = new ArrayList<IndisponibilidadeDTO>();
		
		for (IndisponibilidadeDTO dto : this.listaIndisponibilidades){
			// existe interssao do horario indisponivel para o produtivo???
			if (DataHoraRN.isIntersecao(dto.getInicio(), dto.getFim(), inicio, fim) == true &&
					DataHoraRN.equals(dto.getFim(), inicio) == false
					&& DataHoraRN.equals(dto.getInicio(), fim)==false){
				/*if(data.getDate()!=fim.getDate()){
					IndisponibilidadeDTO novaTempocalsempeso = new IndisponibilidadeDTO();
					novaTempocalsempeso.setInicio(DataHoraRN.getDataSemHora(fim));
					novaTempocalsempeso.setFim(fim);
					
					fim = DataHoraRN.setHoraNaData(data, 23, 59, 59);
					indispTempocalsempeso.add(novaTempocalsempeso);
				}*/
				
				IndisponibilidadeDTO nova = new IndisponibilidadeDTO();
				nova.setInicio(fim);
				nova.setFim(dto.getFim());
				novasIndisp.add(nova);
				//ERRO ao calcular o nao sei o q sem peso, pois pode ser um valor mt grande e ao setar aq, começar no dia 27 e termina dia dias depois
				dto.setFim(inicio);
				
			}
		}
		
		if (listaIndisponibilidades.size()==14){
			log.info("DEBUG");
		}
		this.listaIndisponibilidades.addAll(novasIndisp);
		
		// Remove as indisponibilidade que tiverem o inicio e fim iguais
		/*Iterator<IndisponibilidadeDTO> i = this.listaIndisponibilidades.iterator();
		while (i.hasNext() == true) {
			IndisponibilidadeDTO iIndisp = i.next();
			
			if (iIndisp.getInicio().equals(iIndisp.getFim())  == true)
				i.remove();
			
		}*/
	//	return indispTempocalsempeso;
	}
}
