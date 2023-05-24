package idw.model.rn.geraplano.dtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;

public class CtDTO implements Comparable<CtDTO>{
	private double tempoAlocacao;
	private DwFolha dwfolha;
	private DwFolhacic dwfolhacic;
	private IdCtDTO id;
	private List<PassosDTO> passosAlocados = new ArrayList<PassosDTO>();
	private IndisponibilidadesDTO horariosIndisponiveis = new IndisponibilidadesDTO();

	public IndisponibilidadesDTO getHorariosIndisponiveis() {
		return horariosIndisponiveis;
	}


	public void setHorariosIndisponiveis(IndisponibilidadesDTO horariosIndisponiveis) {
		this.horariosIndisponiveis = horariosIndisponiveis;
	}


	public CtDTO(OmPt ompt){
		id = new IdCtDTO();
		if (ompt.getIsPlangt() != null && ompt.getIsPlangt() == true){
			id.setOmgtEscolhido(ompt.getOmGt());
		} else {
			id.setOmptEscolhido(ompt);
		}
	}
	
	
	public DwFolha getDwfolha() {
		return dwfolha;
	}


	public void setDwfolha(DwFolha dwfolha) {
		this.dwfolha = dwfolha;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public CtDTO(CtDTO somar){
		this.tempoAlocacao = somar.getTempoAlocacao();
		this.dwfolhacic = somar.getDwfolhacic();
		this.dwfolha = somar.getDwfolha();
		this.id = somar.getId();
		this.horariosIndisponiveis = somar.getHorariosIndisponiveis();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CtDTO other = (CtDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public IdCtDTO getId() {
		return id;
	}

	public void setId(IdCtDTO id) {
		this.id = id;
	}

	public List<PassosDTO> getPassosAlocados() {
		return passosAlocados;
	}
	
	public void addPassoAlocado(PassosDTO passo){
		this.passosAlocados.add(passo);
		this.tempoAlocacao += passo.getTempoEstimadoSegundos();
	}

	public List<PassosDTO> getPassosAlocadosJaOrdenadosPeloFimComEspelhoAjustado(IdwLogger log, int idLog, int identacao) {
		List<PassosDTO> listaordenada = passosAlocados;
		
		Collections.sort(listaordenada, new Comparator<PassosDTO>() {
			@Override
			public int compare(PassosDTO o1, PassosDTO o2) {
				return DataHoraRN.before(o1.getFim(), o2.getFim()) ? +1 : (DataHoraRN.after(o1.getFim(), o2.getFim()) ? -1 : 0);
			}
		});
		
		// Reordena as CPs juntado o espelho a principal caso estejam separadas
		List<PassosDTO> novaListaordenada = new ArrayList<PassosDTO>();
		boolean isEncontrouEspelho = false;
		for (PassosDTO p : listaordenada) {
			// Se o passo nao for espelho, entao adicionar a novalista, o espelho sera adicionado se o passo tiver espelhos
			if (p.isEspelho() == false) {
				// adiciona a nova lista
				novaListaordenada.add(p);
			}

			if (p.isPossuiPredecessoraEspelho() == true) {
				// Adiciona o espelho na sequencia
				novaListaordenada.addAll(p.getPassosPredecessoras());
				isEncontrouEspelho = true;
			}
		}

		if (isEncontrouEspelho == true){
			for (PassosDTO p : novaListaordenada){
				log.info(idLog, identacao, "ESPELHO ORDENADO OK? :" + p);
			}
		}
		return novaListaordenada;
	}

	public void setPassosAlocados(List<PassosDTO> passosAlocados) {
		this.passosAlocados = passosAlocados;
	}

	public DwFolhacic getDwfolhacic() {
		return dwfolhacic;
	}
	public void setDwfolhacic(DwFolhacic dwfolhacic) {
		this.dwfolhacic = dwfolhacic;
	}
	public double getTempoAlocacao() {
		return tempoAlocacao;
	}
	public void setTempoAlocacao(double tempoAlocacao) {
		this.tempoAlocacao = tempoAlocacao;
	}
	public void addTempoAlocacao(double tempoAlocacao){
		this.tempoAlocacao += tempoAlocacao;
	}
	@Override
	public String toString(){
		StringBuilder retorno = new StringBuilder();
		retorno.append((id.getOmptEscolhido() != null ? "Pt " + id.getOmptEscolhido().getCdPt() : (id.getOmgtEscolhido() != null ? "Gt " + id.getOmgtEscolhido().getCdGt() : "sem ct")));
		retorno.append(" alocacao:");
		retorno.append(getTempoAlocacao());
		return retorno.toString();
	}
	
	public void setDwfolhacic(DwRotapasso dwrotapass){
		for(DwFolhacic c : dwrotapass.getDwFolha().getDwFolhacics()){
			if (
					c.getOmPt() != null && 
					this.getId().getOmptEscolhido() != null &&
					c.getOmPt().getIdPt().equals(this.getId().getOmptEscolhido().getIdPt()) == true){
				this.dwfolhacic = c;
			}
			if (
					c.getOmGt() != null && 
					this.getId().getOmgtEscolhido() != null &&
					c.getOmGt().getIdGt().equals(this.getId().getOmgtEscolhido().getIdGt()) == true){
				this.dwfolhacic = c;
			}
		}
	}
	
	public boolean isExisteConflitoParaInserir(PassosDTO passo){
		boolean retorno = false;
		for (PassosDTO p : this.passosAlocados){
			if (p.isConflitaCom(passo) == true) {
				retorno = true;
			}
		}
		return retorno;
	}
	public void inserirPasso(PassosDTO passo){
		passo.setCtEscolhido(this);
		this.passosAlocados.add(passo);
		this.tempoAlocacao += passo.getTempoEstimadoSegundos();
	}
	public void removerPasso(PassosDTO passo){
		this.passosAlocados.remove(passo);
		this.tempoAlocacao -= passo.getTempoEstimadoSegundos();
	}
	
	/*
	 * O objetivo desse metodo eh identificar se as datas passadas por parametro
	 * possuem algum tipo de conflito de periodos com os periodos de indisponibilidade do CT
	 */
	public List<IndisponibilidadeDTO> getConflitoComPeriodo(Date inicio, Date fim){
		List<IndisponibilidadeDTO> retorno = new ArrayList<IndisponibilidadeDTO>();
		for (IndisponibilidadeDTO i : horariosIndisponiveis.getListaIndisponibilidades()){
			if (DataHoraRN.isIntersecao(i.getInicio(), inicio, fim) == true || DataHoraRN.isIntersecao(i.getFim(), inicio, fim) == true){
				retorno.add(i);
			} else if (DataHoraRN.isIntersecao(inicio, i.getInicio(), i.getFim()) == true || DataHoraRN.isIntersecao(fim, i.getInicio(), i.getFim()) == true){
				retorno.add(i);
			}
		}
		// Ordena por ordem cronologica
		Collections.sort(retorno, new Comparator<IndisponibilidadeDTO>() {
			@Override
			public int compare(IndisponibilidadeDTO o1, IndisponibilidadeDTO o2) {
				return DataHoraRN.compareTo(o1.getInicio(), o2.getInicio());
			}
		});
		
		return retorno;
	}
	
	
	public int getTempoIndisponibilidadeNoPeriodo(Date inicio, Date fim){
		return getTempoIndisponibilidadeNoPeriodo(inicio, fim, true);
	}
	
	/*
	 * O objetivo desse metodo eh encontrar o tempo de indisponiblidade entre o inicio e fim
	 * a fim de poder somar esse tempo ao tempoestimado
	 */
	public int getTempoIndisponibilidadeNoPeriodo(Date inicio, Date fim, boolean isInicio){
		List<IndisponibilidadeDTO> lista = getConflitoComPeriodo(inicio, fim);
		
		int retorno = 0;
		
		if (lista != null){
			// ordena da menor data de inicio para a maior
			Collections.sort(lista, new Comparator<IndisponibilidadeDTO>() {

				@Override
				public int compare(IndisponibilidadeDTO o1,
						IndisponibilidadeDTO o2) {
					return DataHoraRN.compareTo(o1.getInicio(), o2.getInicio());
				}
			});
			
			
			for (IndisponibilidadeDTO i : lista){
				Date iConsiderado = i.getInicio();
				Date fConsiderado = i.getFim();
				
				/*if (iConsiderado.before(inicio) == true){
					iConsiderado = inicio;
				}
				
				if(fConsiderado.after(fim)==true){
					fConsiderado = fim;
				}*/
								
				int tempIndisp = DataHoraRN.getQuantidadeSegundosNoPeriodo(iConsiderado, fConsiderado);
				
				retorno += tempIndisp;
				
			}
		}
		
		return retorno;
	}

	
	public void addIndisponibilidade(Date inicio, Date fim){
		this.horariosIndisponiveis.addIndisponibilidade(inicio, fim);
	}
	public void addIndisponibilidade(List<IndisponibilidadeDTO> lista){
		this.horariosIndisponiveis.getListaIndisponibilidades().addAll(lista);
	}
/*	public void addCalendarioIndisponbilidade(DwCalsem dwcalsem){
		this.horariosIndisponiveis.addCalendarioIndisponivel(dwcalsem);
	}
	public void addCalendarioIndisponibilidade(List<DwCalsem> lista){
		this.horariosIndisponiveis.getListaDwcalsem().addAll(lista);
	}
*/

	@Override
	public int compareTo(CtDTO o) {
		return id.compareTo(o.getId());
	}
}
