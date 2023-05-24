package idw.model.rn.geraplano.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRotapassoPt;
import idw.model.pojos.DwRpPredecessora;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpfaltamp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpPlaneccron;
import idw.model.pojos.PpPlano;
import idw.model.rn.CalendarioRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.PlanoIndisponibilidadeRN;
import idw.model.rn.geraplano.passos.tipoA.TipoAIndisponibilidade;
import idw.util.IdwLogger;

public class PassosDTO {
	private String identificacaoPasso; // serve apenas para o debug
	private ProdutoComparable omproduto;
	private double producaoPlanejada;
	private double segTempoSetup;
	private boolean isEspelho;
	private boolean isPossuiMPSuficiente;
	private CtDTO ctEscolhido;
	private Date inicio;
	private Date fim;
	private PpPlano ppplano;
	private DwFolha dwfolha;
	private DwRotapasso dwrotapasso;
	protected DwRota dwrota;
	private DwCal dwcal;
	private PpCp ppcpAposInclusao;
	private boolean isExcluida = false;
	private PassosDTO passoAoQualFoiVinculado;
	private double tempoProd;
	
	private List<PpPlaneccron> listaPpplaneccron = new ArrayList<PpPlaneccron>();
	private List<PassosDTO> passosPredecessoras = new ArrayList<PassosDTO>();
	private List<CtDTO> ctsPossiveis = new ArrayList<CtDTO>();
	private List<PpCpfaltamp> mpfaltante = new ArrayList<PpCpfaltamp>();
	
	private boolean isCtsPossiveisDefinidosManualmente = false;
	
	public PassosDTO(PpPlano pplano){
		this.ppplano = pplano;
	}
	
	public PassosDTO (DwRotapasso dwrotapasso){
		this.dwrotapasso = dwrotapasso;
	}
	
	public PassosDTO (PpCp cp){

		dwfolha = cp.getDwFolha().clone();
		dwfolha.getPpCps().add(cp.clone());
		inicio = cp.getDthrInicio();
		fim = cp.getDthrFinal();
		
		Iterator<DwRotapasso> i = cp.getDwFolha().getDwRotapassos().iterator();
		if (i.hasNext() == true)
			dwrotapasso = i.next().clone();
		
		if(cp.getPpPlano()!=null){
			ppplano = cp.getPpPlano().clone();
		}
	}
	
	public PassosDTO (PpCpproduto produto){
		
		ProdutoComparable omProduto = new ProdutoComparable();
		omProduto.setOmproduto(produto.getOmProduto().clone());
	
		omproduto = omProduto;
		producaoPlanejada = produto.getPcsProducaoplanejada().doubleValue();
		dwfolha = produto.getPpCp().getDwFolha().clone();
		dwrota = produto.getPpCp().getDwRota().clone();
		inicio = produto.getPpCp().getDthrInicio();
		fim = produto.getPpCp().getDthrFinal();
	}
	
	public PassosDTO getPassoAoQualFoiVinculad() {
		return passoAoQualFoiVinculado;
	}
	public void setPassoAoQualFoiVinculad(PassosDTO passoAoQualFoiVinculad) {
		this.passoAoQualFoiVinculado = passoAoQualFoiVinculad;
	}
	public boolean isExcluida() {
		return isExcluida;
	}
	public void setExcluida(boolean isExcluida) {
		this.isExcluida = isExcluida;
	}
	public PpCp getPpcpAposInclusao() {
		return ppcpAposInclusao;
	}
	public void setPpcpAposInclusao(PpCp ppcpAposInclusao) {
		this.ppcpAposInclusao = ppcpAposInclusao;
	}
	public List<PpPlaneccron> getListaPpplaneccron() {
		return listaPpplaneccron;
	}
	public void setListaPpplaneccron(List<PpPlaneccron> listaPpplaneccron) {
		this.listaPpplaneccron = listaPpplaneccron;
	}
	public DwCal getDwcal() {
		return dwcal;
	}
	public void setDwcal(DwCal dwcal) {
		this.dwcal = dwcal;
	}
	public DwRota getDwrota() {
		return dwrota;
	}
	public void setDwrota(DwRota dwrota) {
		this.dwrota = dwrota;
	}
	public DwRotapasso getDwrotapasso() {
		return dwrotapasso;
	}
	public void setDwrotapasso(DwRotapasso dwrotapasso) {
		this.dwrotapasso = dwrotapasso;
	}
	public boolean isConflitaCom(PassosDTO pAnterior){
		boolean retorno = false;
		
		if (DataHoraRN.isIntersecao(getInicio(), pAnterior.getInicio(), pAnterior.getFim()) == true)
			retorno = true;

		if (DataHoraRN.isIntersecao(DataHoraRN.subtraiSegundosDaData(getFim(), 1), pAnterior.getInicio(), pAnterior.getFim()) == true)
			retorno = true;

		if (DataHoraRN.isIntersecao(pAnterior.getInicio(), getInicio(), DataHoraRN.subtraiSegundosDaData(getFim(), 1) ) == true)
			retorno = true;

		if (DataHoraRN.isIntersecao(pAnterior.getFim(), getInicio(), getFim()) == true)
			retorno = true;

		return retorno;
	}
	public List<CtDTO> getCtsPossiveis() {
		return ctsPossiveis;
	}
	
	public List<CtDTO> getCtsPossiveisOrdenandoPeloCiclo(){
		// Ordena os cts possiveis em velocidade crescente
		Collections.sort(ctsPossiveis, new Comparator<CtDTO>() {
			@Override
			public int compare(CtDTO o1, CtDTO o2) {
				double cicloPadrao1 = 0d;
				double cicloPadrao2 = 0d;

				if (o1.getDwfolhacic() != null && o1.getDwfolhacic().getSegCiclopadrao() != null) {
					cicloPadrao1 = o1.getDwfolhacic().getSegCiclopadrao().doubleValue();
				} else if (o1.getDwfolha() != null && o1.getDwfolha().getSegCiclopadrao() != null) {
					cicloPadrao1 = o1.getDwfolha().getSegCiclopadrao().doubleValue();
				}
				if (o2.getDwfolhacic() != null && o2.getDwfolhacic().getSegCiclopadrao() != null) {
					cicloPadrao2 = o2.getDwfolhacic().getSegCiclopadrao().doubleValue();
				} else  if (o2.getDwfolha() != null && o2.getDwfolha().getSegCiclopadrao() != null) {
					cicloPadrao2 = o2.getDwfolha().getSegCiclopadrao().doubleValue();
				}
				
				return  (cicloPadrao1 < cicloPadrao2 ? -1 : cicloPadrao1 > cicloPadrao2 ? +1 : o1.getId().compareTo(o2.getId()));
			}
		});
		return ctsPossiveis;
	}
	public CtDTO getCtEscolhido() {
		return ctEscolhido;
	}
	public void setCtEscolhido(CtDTO ctEscolhido) {
		this.ctEscolhido = ctEscolhido;
	}
	public List<PassosDTO> getPassosPredecessoras() {
		return passosPredecessoras;
	}
	public List<PassosDTO> getPassosPredecessorasRecursivamente() {
		List<PassosDTO> retorno = new ArrayList<>();
		if (passosPredecessoras != null) {
			retorno.addAll(passosPredecessoras);
			for (PassosDTO p : passosPredecessoras) {
				if (p.getPassosPredecessoras() != null) {
					retorno.addAll(p.getPassosPredecessorasRecursivamente());
				}
			}
		}
		return retorno;
	}

	public void setPassosPredecessoras(List<PassosDTO> passosPredecessorasEspelhos) {
		this.passosPredecessoras = passosPredecessorasEspelhos;
	}
	public int getTempoEstimadoSegundos(){
		return getTempoEstimadoSegundos(producaoPlanejada);
	}
	public int getTempoEstimadoSegundos(double producaoParaOCalculo){
		/* Alessandre o trecho abaixo calcula o tempo estimado considerando o indoee impactando o tempo, mas o cliente ipacta na qt. produzida
		 * Alem disso, acredito que a producaoParaCalculo deveria ser dividida pela qt cav ativas e nao estava sendo
		double indiceAcrescimo = 100 - ppplano.getIndOee().doubleValue();
		
		if (this.ctEscolhido != null && this.ctEscolhido.getId() != null && ctEscolhido.getId().getOmgtEscolhido() != null && ctEscolhido.getId().getOmgtEscolhido().getIndOee() != null){
			indiceAcrescimo = 100 - this.ctEscolhido.getId().getOmgtEscolhido().getIndOee().doubleValue();
		}
		
		indiceAcrescimo /= 100;
		indiceAcrescimo += 1;
		return getCicloPadrao().multiply(new BigDecimal(producaoParaOCalculo)).multiply(new BigDecimal(indiceAcrescimo)).intValue();
		*/
		double indiceOee = 74d;
		
		if (ppplano.getIndOee() != null)
			indiceOee = ppplano.getIndOee().doubleValue(); // Ex: 74%
		
		if (this.ctEscolhido != null && this.ctEscolhido.getId() != null && ctEscolhido.getId().getOmgtEscolhido() != null && ctEscolhido.getId().getOmgtEscolhido().getIndOee() != null){
			indiceOee = this.ctEscolhido.getId().getOmgtEscolhido().getIndOee().doubleValue();
		} else  if (this.ctEscolhido != null && this.ctEscolhido.getId() != null && ctEscolhido.getId().getOmptEscolhido() != null && ctEscolhido.getId().getOmptEscolhido().getIndOee() != null){
			indiceOee = this.ctEscolhido.getId().getOmptEscolhido().getIndOee().doubleValue();
		}
		
		indiceOee /= 100;

		
		double cicloPadrao = getCicloPadrao().doubleValue(); // Ex: 25.3983
		double producaoPorCiclo = this.getQtCavAtivas();
		
		int producao1Hora100 = (int) (3600d / cicloPadrao); // Ex. Qt = 6
		producao1Hora100 *= producaoPorCiclo;
		
		int producao1HoraIndOee = (int) (producao1Hora100 * indiceOee);

		// Horas necessarias para produzir o planejado
		double horasNecessarias = producaoParaOCalculo / producao1HoraIndOee;
		double segundosNecessarios = horasNecessarias * 3600;
		double segundosEstimados = segundosNecessarios + getSegTempoSetup(); 
		setTempoProd(segundosEstimados);
		
		int retorno = (int) segundosEstimados;
		return retorno;
	}
	
	/*
	 * Nao deve ser necessario multiplicar o ciclo padrao pelas cavidades. O ciclo padrao ja representa o tempo independente
	 * das cavidades
	 * Entretanto, para a Panasonic, os tempos importados da planilha sao para uma cavidade
	 * Logo eh necessario multiplicar pelas cavidades, ou na importacao salvar o tempo ja multiplicado
	 *
	 */
	public BigDecimal getCicloPadrao(){
		BigDecimal retorno = BigDecimal.ZERO;
		
		if(getCtEscolhido() == null){
			retorno = dwfolha.getSegCiclopadrao();
		} else {
			// Se o ct estiver definido, pegar o ciclo padrao adequado
			for (DwFolhacic cic : dwfolha.getDwFolhacics()){
				if (getCtEscolhido().getId().getOmgtEscolhido() != null && cic.getOmGt() != null && getCtEscolhido().getId().getOmgtEscolhido().getIdGt().equals(cic.getOmGt().getIdGt())){
					retorno = cic.getSegCiclopadrao();
					break;
				}
				if (getCtEscolhido().getId().getOmptEscolhido() != null && cic.getOmPt() != null && getCtEscolhido().getId().getOmptEscolhido().getIdPt().equals(cic.getOmPt().getIdPt())){
					retorno = cic.getSegCiclopadrao();
					break;
				}
			}
			if ((retorno == null)||(retorno.equals(BigDecimal.ZERO))){
				retorno = dwfolha.getSegCiclopadrao();
			}
		}
		
		//Alessandre: retirei em 12-8-14. Os ciclos devem ser armazenas sempre considerando as cavidades
		//retorno = retorno.multiply(new BigDecimal(this.getQtCavAtivas()) );
		
		return retorno;
	}
	public double getTempoEstimadoHoras(){
		return ((double) getTempoEstimadoSegundos()) / 3600;
	}
	
	public void calculaDatasInicioFim(IdwLogger log, int idLog, int identacao, Date dtReferencia){
		calculaDatasInicioFim(log, idLog, identacao, dtReferencia, true, this.producaoPlanejada, this.producaoPlanejada);
	}
	public void calculaDatasInicioFim(IdwLogger log, int idLog, int identacao, Date dtReferencia, boolean isCalcularPredecessora){
		calculaDatasInicioFim(log, idLog, identacao, dtReferencia, isCalcularPredecessora, this.producaoPlanejada, this.producaoPlanejada);
	}
	
	public void calculaDatasFimDtInicioPrevista(){
		if(getCtEscolhido()!=null){
			setFim(null,DataHoraRN.adicionaSegundosNaData(getInicio(), getTempoEstimadoSegundos()));
			int tmpIndisp = getCtEscolhido().getTempoIndisponibilidadeNoPeriodo(getInicio(), getFim());
			setFim(null, DataHoraRN.adicionaSegundosNaData(getInicio(), getTempoEstimadoSegundos()+tmpIndisp));
		}else{
			setFim(null, DataHoraRN.adicionaSegundosNaData(getInicio(), getTempoEstimadoSegundos()));
		}
	}
	/*
	 * Esse metodo calcula a data de fim considerando os periodos de indisponibilidade da maquina
	 * Isse deve existir tambem para a data de inicio
	 */
	public void calculaDatasFim(){
		setFim(null, DataHoraRN.adicionaSegundosNaData(getInicio(), getTempoEstimadoSegundos()));
	}
	
	public void setInicioInicioPrevista(Date rf){
		List<IndisponibilidadeDTO> lista = ctEscolhido.getHorariosIndisponiveis().getListaIndisponibilidades();
		
		Collections.sort(lista, new Comparator<IndisponibilidadeDTO>() {
			@Override
			public int compare(IndisponibilidadeDTO o1, IndisponibilidadeDTO o2) {
				return DataHoraRN.compareTo(o1.getInicio(), o2.getInicio())  ;
			}
		});
		
		for (IndisponibilidadeDTO l : lista){
			if (DataHoraRN.isIntersecao(getInicio(), l.getInicio(), l.getFim()) == true){
				this.inicio = DataHoraRN.adicionaSegundosNaData(l.getFim(), 1);
				//break;
			}
		}
	}
	
	public void setInicioDtInicioPrevista(Date rf){
		this.inicio = rf;
		
		List<IndisponibilidadeDTO> lista = ctEscolhido.getHorariosIndisponiveis().getListaIndisponibilidades();
		
		Collections.sort(lista, new Comparator<IndisponibilidadeDTO>() {
			@Override
			public int compare(IndisponibilidadeDTO o1, IndisponibilidadeDTO o2) {
				return (DataHoraRN.compareTo(o1.getInicio(), o2.getInicio())) * -1;
			}
		});
		
		for (IndisponibilidadeDTO l : lista){
			if (DataHoraRN.isIntersecao(getInicio(), l.getInicio(), l.getFim()) == true){
				this.inicio = DataHoraRN.subtraiSegundosDaData(l.getInicio(), 1);
				//break;
			}
		}
	}
	
	public boolean setInicioParaAdiantamento(Date rf){
		boolean retorno= true;
		this.inicio = rf;
		
		List<IndisponibilidadeDTO> lista = ctEscolhido.getHorariosIndisponiveis().getListaIndisponibilidades();
		
		Collections.sort(lista, new Comparator<IndisponibilidadeDTO>() {
			@Override
			public int compare(IndisponibilidadeDTO o1, IndisponibilidadeDTO o2) {
				return (DataHoraRN.compareTo(o1.getInicio(), o2.getInicio())) * -1  ;
			}
		});
		
		for (IndisponibilidadeDTO l : lista){
			if (DataHoraRN.isIntersecao(getInicio(), l.getInicio(), l.getFim()) == true){
				retorno = false;
				break;
			}
		}
		
		return retorno;
	}
	
	private void setFimBaseadoNoInicio(IdwLogger log, double qtASerConsideradaParaCalculoDatas, double qtASerProduzida){
		
		mudaFimSemConsiderarIndisponibilidade(DataHoraRN.adicionaSegundosNaData(getInicio(), getTempoEstimadoSegundos(qtASerConsideradaParaCalculoDatas)));
		List<IndisponibilidadeDTO> lista = ctEscolhido.getHorariosIndisponiveis().getListaIndisponibilidades();
		int tempoAnt = 0;
		int tempoIndisp = ctEscolhido.getTempoIndisponibilidadeNoPeriodo(getInicio(), getFim());
		this.fim = DataHoraRN.adicionaSegundosNaData(getFim(), tempoIndisp);
		
		while(true){
			tempoAnt = tempoIndisp;
			tempoIndisp = ctEscolhido.getTempoIndisponibilidadeNoPeriodo(getInicio(), getFim());
			if (tempoIndisp == tempoAnt){
				break;
			}
			this.fim = DataHoraRN.adicionaSegundosNaData(getFim(), tempoIndisp-tempoAnt);
		}

		
		
		Collections.sort(lista, new Comparator<IndisponibilidadeDTO>() {
			@Override
			public int compare(IndisponibilidadeDTO o1, IndisponibilidadeDTO o2) {
				return (DataHoraRN.compareTo(o1.getFim(), o2.getFim())) ;
			}
		});
		
		for (IndisponibilidadeDTO l : lista){
			if (DataHoraRN.isIntersecao(getFim(), l.getInicio(), l.getFim()) == true){
				int diferenca = DataHoraRN.getQuantidadeSegundosNoPeriodo(l.getInicio(),getFim());
				if (diferenca == 0){
					diferenca = 1;
				}
				this.fim = DataHoraRN.adicionaSegundosNaData(l.getFim(), diferenca);
				//break;
			}
		}

	}
	
	/*
	 * Ajusta a data de inicio para a mesma cair em um periodo produtivo
	 */
	private void ajustaDataInicioUsandoIndisponibilidade(){
		if (ctEscolhido != null){
			for (IndisponibilidadeDTO indisp : ctEscolhido.getConflitoComPeriodo(getInicio(), getFim()) ){
				if (DataHoraRN.isIntersecao(this.inicio, indisp.getInicio(), indisp.getFim()) == true) {
					int tempoIndisp = DataHoraRN.getQuantidadeSegundosNoPeriodo(indisp.getInicio(), indisp.getFim());
					this.inicio = DataHoraRN.adicionaSegundosNaData(getInicio(), tempoIndisp);
				}
			}
		}
	}	
	
	/*
	 * Esse metodo eh usado para ajustar a data de fim considerando os periodos de indisponibilidade
	 * quando uma nova data de fim for encontrada, deve-se verificar novamente se existe idisponibilidade entre o novo
	 * periodo. Isso deve ser feito ate nao termos mais indiposnibilidades nao computadas.
	 * Esse metodo deve ser chamado apenas qdo o ct ja estiver definido
	 */
	private void ajustaDataFimUsandoIndisponibilidade(IdwLogger log){
		if (ctEscolhido != null){
			
			if (ctEscolhido.getId().getOmptEscolhido().getCdPt().equals("|00008"))
				System.out.println("deb");
			
			List<IndisponibilidadeDTO> lista = ctEscolhido.getHorariosIndisponiveis().getListaIndisponibilidades();
			
			Collections.sort(lista, new Comparator<IndisponibilidadeDTO>() {
				@Override
				public int compare(IndisponibilidadeDTO o1, IndisponibilidadeDTO o2) {
					return (DataHoraRN.compareTo(o1.getFim(), o2.getFim())) ;
				}
			});
			
			// Monta o list de disponivbilidade a partir da lista de indisponibilidade
			Map<Date, DisponibilidadeDTO> disponibilidade = new HashMap<Date, DisponibilidadeDTO>();
			for (IndisponibilidadeDTO ind : lista){
				Date inicio = ind.getInicio();
				Date fim = ind.getFim();
				do {
					DisponibilidadeDTO dispdto = new DisponibilidadeDTO(ind, inicio);
					if (disponibilidade.containsKey(dispdto.getDtReferencia())) {
						DisponibilidadeDTO dispaux = disponibilidade.get(dispdto.getDtReferencia());
						dispaux.add(dispdto);
					} else {
						disponibilidade.put(dispdto.getDtReferencia(), dispdto);
					}
					inicio = DataHoraRN.adicionaDiasDaData(inicio, 1);
					inicio = DataHoraRN.getDataSemHora(inicio);
				} while (DataHoraRN.before(inicio, fim) );
			}
			
			
			// Soma os tempos indisponiveis no periodo para adicionar ao tempo estimado e recalcular a data de fim
			Integer segTempoDisponivel = getTempoEstimadoSegundos();
			Date dthrfim = getInicio();
			Date dthrFimCalculado = dthrfim;
			
			while (segTempoDisponivel > 0 && disponibilidade.isEmpty() == false) {
				Date dtReferencia = DataHoraRN.getDataSemHora(dthrfim);
				if (disponibilidade.containsKey(dtReferencia)) {
					DisponibilidadeDTO dto = disponibilidade.get(dtReferencia);
					segTempoDisponivel -= (int) (dto.getSegTempoDisponivel() - dto.getSegTempoIndisponivel());
					dthrFimCalculado = DataHoraRN.adicionaSegundosNaData(dthrfim, (int)(dto.getSegTempoDisponivel() - dto.getSegTempoIndisponivel()));
					dthrfim = DataHoraRN.adicionaDiasDaData(dthrfim, 1);
				} else {
					break;
				}
			}
			
			this.fim = dthrFimCalculado;
		}
	}
	
	public void calculaDatasInicioFim(IdwLogger log, int idLog, int identacao, Date dtReferencia, boolean isCalcularPredecessora, double qtASerConsideradaParaCalculoDatas, double qtASerProduzida){
		
		boolean isConsideraIndisponibilidade = false;
		log.debug(idLog, identacao, "0.0 para o pai " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtReferencia) + " - " + this);
		setFim(log, dtReferencia);
		log.debug(idLog, identacao, "0.1 para o pai " + this);
		setInicio(DataHoraRN.subtraiSegundosDaData(getFim(), getTempoEstimadoSegundos(qtASerConsideradaParaCalculoDatas)));
		log.debug(idLog, identacao, "0.2 para o pai " + this);
		
		if(		getCtEscolhido() != null && 
				getCtEscolhido().getHorariosIndisponiveis() != null &&
				getCtEscolhido().getHorariosIndisponiveis().getListaIndisponibilidades() != null &&
				getCtEscolhido().getHorariosIndisponiveis().getListaIndisponibilidades().size() > 0){
			isConsideraIndisponibilidade = true;
			//if (qtASerConsideradaParaCalculoDatas != qtASerProduzida)
				log.debug(idLog, identacao, "1.1 para o pai " + this);
				setFimBaseadoNoInicio(log, getProducaoPlanejada(), getProducaoPlanejada());
				log.debug(idLog, identacao, "1.2 para o pai " + this);
		}else{
			log.debug(idLog, identacao, "2.1 para o pai " + this);
			setFim(log, DataHoraRN.adicionaSegundosNaData(getInicio(), getTempoEstimadoSegundos()));
			log.debug(idLog, identacao, "2.2 para o pai " + this);
		}

		if (isCalcularPredecessora == true){
			// Recalcula para as predecessoras
			for (PassosDTO pre : this.passosPredecessoras){
				if (pre.getOmproduto().getOmproduto().getCdProduto().equals("493400")) {
					log.debug("Avaliar produto que calculou errado as datas");
				}
				// Seta a producao da predecessora igual a producao do passo pai
				// se a producao da predecessora for menor que a ser considerada entao nao se deve mudar.
				// Se a producao for menor eh pq foi abatida do estoque
				// Alessandre: 11-06-12 Removi o if abaixo pq a producao da predecessora ja esta abatida corretamente, isso depois que o estoque
				// passou a ser avaliado com o algoritmo da monitorizacaopprn
//				if (pre.getProducaoPlanejada() > 0)
//					pre.setProducaoPlanejada(qtASerProduzida);
				if(isConsideraIndisponibilidade == true)
					verificaIndisponibilidadePredecessora(log, idLog, identacao, pre);
				
				if (pre.getDwrotapasso() == null)
					log.debug(idLog, identacao, "O rotapasso esta null para o passo " + pre);
				
				if (pre.getDwrotapasso() != null && pre.getDwrotapasso().getTpMovimentacao() == null)
					log.debug(idLog, identacao, "O tipo motivmentacao esta null para o passo " + pre + " do roteiro " + pre.getDwrota().getIdRota());
					
				
				// se a predecessora for espelho ou com a movimentacao do tipo percentual e 100%
				if (pre.isEspelho() == true || 
						(pre.getDwrotapasso().getTpMovimentacao().equals(BigDecimal.ONE) && 
								pre.getDwrotapasso().getQtMovimentacao().equals(100d))){ // tp de movimenta��o baseado na porcentagem
					
					if (getOmproduto().getOmproduto().getCdProduto().equals("493400"))
						log.debug(idLog, identacao, "1. Calculando datas para o passo Espelho ou com 100% na movimentacao " + pre + " para o pai " + this);
					pre.calculaDatasInicioFim(log, idLog, identacao, getInicio(), isCalcularPredecessora, pre.getProducaoPlanejada(), pre.getProducaoPlanejada());
					if (getOmproduto().getOmproduto().getCdProduto().equals("493400"))
						log.debug(idLog, identacao, "1. CALCULADA datas para o passo Espelho ou com 100% na movimentacao " + pre + " para o pai " + this);

				} else {
					// Se a motivmentacao for do tipo de quantidade, encontrar nova data de referencia para calculo da predecessora
					if (pre.getDwrotapasso().getTpMovimentacao().equals(BigDecimal.ZERO)){
						double qtMovimentacao = pre.getDwrotapasso().getQtMovimentacao().doubleValue();
						
						// Se a quantidade de movimentacao for maior que a producao planejada, entao considerar a producaoPlanejada para o calculo
						if (pre.getProducaoPlanejada() < qtMovimentacao){
							qtMovimentacao = pre.getProducaoPlanejada();
						}
						
						if (getOmproduto().getOmproduto().getCdProduto().equals("493400")){
							log.debug(idLog, identacao, "Debugar 493400");
						}
						if (DataHoraRN.getApenasAno(getInicio()) == 2012)
							log.debug("Debug");
						
						// chamar novamente o calculodatainicioefim, mas passando qual a quantidade que se deseja, ou seja nao sera considerada a quantidade total
						if (getOmproduto().getOmproduto().getCdProduto().equals("493400") && qtMovimentacao == 222d)
							log.debug(idLog, identacao, "2. Calculando datas para o passo Espelho ou com 100% na movimentacao " + pre + " para o pai " + this);
						pre.calculaDatasInicioFim(log, idLog, identacao, getInicio(), isCalcularPredecessora, qtMovimentacao, pre.getProducaoPlanejada());
						if (getOmproduto().getOmproduto().getCdProduto().equals("493400"))
							log.debug(idLog, identacao, "2. CALCULADA datas para o passo Espelho ou com 100% na movimentacao " + pre + " para o pai " + this);
						
						/*
						 * Recalcula a data final, a partir da data inicio encontrada
						 * Isso eh feito senao a data final sera = a data inicial da sucessora
						 * Usando-se o tempo estimado total.
						 * Existe dois caminhos para se analisar o setFim abaixo:
						 * 1o a quantidade de movimentacao � igual a producao planejada. Nesse caso n�o tem motivo de se recalcular o fim
						 * 2o a quantidade de movimentacao � menor que a producao planejada. Nesse caso o fim deve ser o inicio encontrado da pre + todo o tempo estimado. Nesse caso se o fim do pre ultrapassar o fim do passo corrente, entao recalcular o inicio 
						 * 
						 * Atencao: na linha abaixo anteriormente era sem o pre no pre.getInicio(). Acrescentei o pre pois o inicio eh do pre e nao do passo corrente
						 */
						//pre.calculaDatasFimDtInicioPrevista();
						
						//pre.calculaDatasInicioFim(log, idLog, identacao, pre.getFim());
						
						// OBS: Como previsto, chamar o metodo acima causou o inicio da predecessora antes da sucessora, mas como a sucessora � rapida
						// seu fim foi anterior ao fim da predecessora. O correto nesse caso � calcular o inicio da predecessora, como base o fim da sucessora
						// menons a quantidade necess�ria do lote de movimentacao, mas faz isso apenas se a data final do passo for anterior ao final da predecessora
						
						
						if ((DataHoraRN.before(getFim(), pre.getFim()) == true)||(DataHoraRN.before(getInicio(), pre.getInicio()) == true)){
							if (getOmproduto().getOmproduto().getCdProduto().equals("493400"))
								log.debug(idLog, identacao, "2. CALCULADA datas para o passo Espelho ou com 100% na movimentacao " + pre + " para o pai " + this);
							recalculaExcecoesDeInicioFim(log, idLog, identacao, isCalcularPredecessora, pre, qtMovimentacao);
							if (getOmproduto().getOmproduto().getCdProduto().equals("493400"))
								log.debug(idLog, identacao, "2. CALCULADA datas para o passo Espelho ou com 100% na movimentacao " + pre + " para o pai " + this);
						}
					} else {
						// Se o tipo movimentacao for percentual e nao for 100%, entao encontrar nova data de referencia
						// TODO nao sera implementado no momemento pois para o cliente o % sempre sera 100%
					}
				}
			}
		}
	}
	
	public void recalculaExcecoesDeInicioFim(IdwLogger log, int idLog, int identacao, boolean isCalcularPredecessora, PassosDTO pre, double qtMovimentacao){
		Date dtReferenciaPre = getFim();
		double tmpEstQtMov = pre.getTempoEstimadoSegundos(qtMovimentacao);
		
		if(pre.getCtEscolhido()!=null){
			Date fimTmpEstQtMov = DataHoraRN.adicionaSegundosNaData(pre.getInicio(),(int)tmpEstQtMov);
			tmpEstQtMov = tmpEstQtMov + pre.getCtEscolhido().getTempoIndisponibilidadeNoPeriodo(pre.getInicio(), fimTmpEstQtMov);
		}
		
		dtReferenciaPre = DataHoraRN.subtraiSegundosDaData(dtReferenciaPre, (int) tmpEstQtMov);
		
		if (getOmproduto().getOmproduto().getCdProduto().equals("TP8NH0993VH-IAC"))
			log.info(idLog, identacao, "3. Calculando datas para o passo Espelho ou com 100% na movimentacao " + pre + " para o pai " + this);
		pre.calculaDatasInicioFim(log, idLog, identacao, dtReferenciaPre, isCalcularPredecessora, pre.getProducaoPlanejada(), pre.getProducaoPlanejada());
		if (getOmproduto().getOmproduto().getCdProduto().equals("TP8NH0993VH-IAC"))
			log.info(idLog, identacao, "3. CALCULADA datas para o passo Espelho ou com 100% na movimentacao " + pre + " para o pai " + this);
	}
	
	public Date getInicio() {
		return inicio;
	}
	public void mudaInicioSemConsiderarIndisponibilidade(Date inicio){
		this.inicio = inicio;
	}
	public void setInicio(Date inicio) {
		mudaInicioSemConsiderarIndisponibilidade(inicio);
		
		// Ajustar a dt de inicio considerando os periodos de indisponibilidade
		ajustaDataInicioUsandoIndisponibilidade();
	}
	public Date getFim() {
		return fim;
	}
	
	public void mudaFimSemConsiderarIndisponibilidade(Date fim){
		this.fim = fim;
	}
	
	public void setFim(IdwLogger log, Date fim) {
			//System.out.println(this);
		mudaFimSemConsiderarIndisponibilidade(fim);
			//System.out.println(this);
		// Ajustar a dt de fim considerando os tempos indisponiveis
		ajustaDataFimUsandoIndisponibilidade(log);
			//System.out.println(this);
	}
	public ProdutoComparable getOmproduto() {
		return omproduto;
	}
	public void setOmproduto(ProdutoComparable omproduto) {
		this.omproduto = omproduto;
	}
	public double getProducaoPlanejada() {
		return producaoPlanejada;
	}
	public void setProducaoPlanejada(double producaoPlanejada) {
		this.producaoPlanejada = producaoPlanejada;
	}
	public boolean isEspelho() {
		return isEspelho;
	}
	public void setEspelho(boolean isEspelho) {
		this.isEspelho = isEspelho;
	}
	public DwFolha getDwfolha() {
		return dwfolha;
	}
	public void setDwfolha(DwFolha dwfolha) {
		this.dwfolha = dwfolha;
	}
	
	public void acumulaPassosComPredecessorasModificandoInicio(PassosDTO somar){
		acumulaPassosComPredecessoras(somar, true);
	}

	public void acumulaPassosComPredecessorasModificandoFim(PassosDTO somar){
		acumulaPassosComPredecessoras(somar, false);
	}

	private void acumulaPassosComPredecessoras(PassosDTO somar, boolean isModificarInicio){
		// Soma-se quando eh o mesmo produto, se nao retorna excessao
		this.producaoPlanejada += somar.getProducaoPlanejada();

		if (isModificarInicio == true)
			setInicio(DataHoraRN.subtraiSegundosDaData(getFim(), getTempoEstimadoSegundos()));
		else
			setFim(null, DataHoraRN.adicionaSegundosNaData(getInicio(), getTempoEstimadoSegundos()));
		
		// Acumula tb os ppPlaneccron. Eles representam as necessidades do cliente para o semi-produto
		if (somar.getListaPpplaneccron() != null && somar.getListaPpplaneccron().size() > 0){
			for (PpPlaneccron p : somar.getListaPpplaneccron()){
				if (this.listaPpplaneccron.contains(p) == false)
					this.listaPpplaneccron.add(p);
			}
		}
		
		// Varrer predecessoras
		if (this.passosPredecessoras != null && this.passosPredecessoras.size() > 0){
			for (PassosDTO predecessora : this.passosPredecessoras){
				// Encontra a predecessora do passo a ser somado
				PassosDTO predecessrasASeremSomadas = getPassoDoProduto(somar.getPassosPredecessoras(), predecessora);
				
				// Se predecessorasASeremSomadas for null eh pq somar nao possui predecessoras que possam ser somadas
				// logo desconsiderar a soma
				if (predecessrasASeremSomadas != null) {
					// Setar o final da predecessora como sendo o incio encontrado para a sucessora. Essa situacao nao mudara para as espelhos, mas para as
					// que tem qt de movimentacao por pe�a isso podera mudar mais a frente no passo ...
					predecessora.setFim(null, getInicio());
		
					// Alessandre: ao inves de passar isModificarInicio que no caso avaliado estava false, (o caso avaliado eh a uniao de cps com tempo inferiores a 8h
					// sera passado sempre true para que a data de inicio da predecessora que seja recalculada
					predecessora.acumulaPassosComPredecessoras(predecessrasASeremSomadas, /*isModificarInicio*/ true);
				}
			}
		} else {
			// Se nao existirem predecessoras no passo, mas existirem predecessoras no que deveria ser somado, entao repassar integralmente esssas predecessoras
			if (somar.getPassosPredecessoras() != null && somar.getPassosPredecessoras().size() > 0){
				this.passosPredecessoras = somar.getPassosPredecessoras();
			}
		}
	}
	
	public void acumulaPassosSemPredecessoras(PassosDTO somar){
		this.producaoPlanejada += somar.getProducaoPlanejada();

		// Alessandre em 10-02-13: entendi o problema. Quando um passo acumlula suas
		// predecessoras
		// tb estavam sendo acumulado, ai qdo se processava a predecessora elas
		// corriam
		// o risco de serem apagadas
		/*
		if (somar.getPassosPredecessoras() != null && somar.getPassosPredecessoras().size() > 0){
			for (PassosDTO p : somar.getPassosPredecessoras()){
				if (this.passosPredecessoras.contains(p) == false)
					this.passosPredecessoras.add(p);
			}
		}*/

		if (somar.getListaPpplaneccron() != null && somar.getListaPpplaneccron().size() > 0){
			for (PpPlaneccron p : somar.getListaPpplaneccron()){
				if (this.listaPpplaneccron.contains(p) == false)
					this.listaPpplaneccron.add(p);
			}
		}
	}
	
	private PassosDTO getPassoDoProduto(List<PassosDTO> lista, PassosDTO passo) {
		PassosDTO retorno = null;
		for (PassosDTO p : lista){
			if (p.getOmproduto().getOmproduto().getIdProduto() == passo.getOmproduto().getOmproduto().getIdProduto()){
				retorno = p;
				break;
			}
		}
		return retorno;
	}
	
	/*
	 * O objetivo desse metodo eh encontrar os CTs possiveis para o passo.
	 * O passo eh para determinado produto. Entao para os CTs possiveis devemos ter quais 
	 * os ciclos para CT
	 */
	public void defineCtsDisponiveis(DwRotapasso dwrotapasso, IdwLogger log, int idLog, int identacao, DAOGenerico dao){
		// Varre os dwrotapassopt, se nao houver, assumir todos os do tipopt da folha
		if (dwrotapasso.getDwRotapassoPts() != null && dwrotapasso.getDwRotapassoPts().size() > 0){
			setCtsPossiveisDefinidosManualmente(true);
			for (DwRotapassoPt pts : dwrotapasso.getDwRotapassoPts()){
				if (pts.getOmPt().getStAtivo() == (byte) 0) {
					// Verificar se o codigo do pt existe e utiliza-lo
					PTRN rn = new PTRN(dao);
					OmPt ompt = rn.pesquisarPtByCdPtStAtivo(pts.getOmPt().getCdPt());
					if (ompt == null)
						continue;
					pts.setOmPt(ompt);
				}
				
				CtDTO ctdto = new CtDTO(pts.getOmPt());
				ctdto.setDwfolha(dwrotapasso.getDwFolha());
				ctdto.setDwfolhacic(dwrotapasso);
				
				if (ctdto.getDwfolhacic() == null && log != null){
					log.info(idLog, identacao, "N�o foi possivel achar a dwfolhacic para o rotapasso da folha " + ctdto.getDwfolha().getCdFolha() + " para o ctdto " + ctdto);
				}
				
				boolean isExiste = false;
				for (CtDTO c : ctsPossiveis){
					if (c.equals(ctdto) == true){
						isExiste = true;
						break;
					}
				}
				if (isExiste == false) {
					ctsPossiveis.add(ctdto);
				}
			}
		} else { 
			for (OmPt ompt : dwfolha.getOmTppt().getOmPts()){
				// Pegar nova versao do PT
				
				if (ompt.getStAtivo() == (byte) 0)
					continue;
				if (ompt.getIsPlangt() == true)
					continue;
				
				CtDTO ctdto = new CtDTO(ompt);
				boolean isExiste = false;
				for (CtDTO c : ctsPossiveis){
					if (c.equals(ctdto) == true){
						isExiste = true;
						break;
					}
				}
				if (isExiste == false) {
					ctdto.setDwfolha(dwrotapasso.getDwFolha());
					ctdto.setDwfolhacic(dwrotapasso);
					ctsPossiveis.add(ctdto);
				}
			}
		}
		if (ctsPossiveis == null || ctsPossiveis.isEmpty() == true)
			if (log != null)
				log.debug("");
		
	}
	
	@Override
	public String toString(){
		String retorno = null;
		
		try {
			retorno = "CT " + getCtEscolhido() + 
			" " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(getInicio()) + " ate " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(getFim()) +
			" (" + DataHoraRN.getQuantidadeHorasNoPeriodo(getInicio(), getFim()) + "hrs)" +
			" produto " + omproduto.getOmproduto().getCdProduto() + 
			" quantidade " + producaoPlanejada + 
			" rota " + dwrotapasso.getPasso() + 
			" qtcavativ " + getQtCavAtivas() +
			" tmpEst " + getTempoEstimadoHoras() +
			(isEspelho ? " - Espelho" : "") +
			(isExcluida ? " - Excluido" : "");
			
			if (getCtEscolhido() != null && getCtEscolhido().getHorariosIndisponiveis() != null && getCtEscolhido().getHorariosIndisponiveis().getListaIndisponibilidades()!=null)
			retorno += " qtde indisponibilidade=" + getCtEscolhido().getHorariosIndisponiveis().getListaIndisponibilidades().size();
		} catch (NullPointerException e){
			retorno = "";
		}
		
		return retorno;
	}
	
	/* Esse metodo verifica se as predecessoras tb estao alocadas para o mesmo CT. Se nao tiverem
	 * nenhum ct alocado entao retornar false
	 * 
	 */
	public boolean isPredecessorasImediatasSaoParaOMesmosCts(){
		boolean retorno = true;
		
		for (PassosDTO p : this.getPassosPredecessoras()){
			for (CtDTO c : p.getCtsPossiveis()){
				boolean isAchou = false;
				for (CtDTO ctdto : this.getCtsPossiveis()){
					if (ctdto.equals(c) == true){
						isAchou = true;
						break;
					}
				}
				if (isAchou == false) {
					retorno = false;
					break;
				}
			}
		}
		return retorno;
	}
	public boolean isPossuiPredecessoraEspelho(){
		boolean retorno = false;
		
		for (PassosDTO p : this.getPassosPredecessoras()){
			if (p.isEspelho == true){
				retorno = true;
				break;
			}
		}
		return retorno;
	}
	public Date getMaiorDataFinalDasPredecessoras(){
		Date retorno = null;
		
		for (PassosDTO p : this.getPassosPredecessoras()){
			if (p.isExcluida() == false) {
				if (retorno == null)
					retorno = p.getFim();
				
				if (DataHoraRN.after(p.getFim(), retorno) == true){
					retorno = p.getFim();
					break;
				}
			}
		}
		return retorno;
		
	}
	public boolean isPossuiPredecessoras(){
		boolean isretorno = false;
		for (PassosDTO p : this.passosPredecessoras){
			if (p.isExcluida() == false){
				isretorno = true;
				break;
			}
		}
		return isretorno;
	}

	public double getQtCavAtivas() {
		double retorno = 1d;
		if (dwfolha.getDwFolhaiacs() != null && dwfolha.getDwFolhaiacs().size() >= 1)
			retorno = dwfolha.getDwFolhaiacs().iterator().next().getQtAtiva().doubleValue();
		else {
			retorno = 0d;
			// Obtem  a producao por ciclo a partir da ferramenta
			for (DwFolharap folharap : dwfolha.getDwFolharaps()) {
				for (DwFolharapcom rapcom : folharap.getDwFolharapcoms()) {
					retorno += rapcom.getQtAtiva().doubleValue();
				}
			}
		}
		return retorno;
	}
	
	public double getSegTempoSetup() {
		return segTempoSetup;
	}

	public void setSegTempoSetup(double segTempoSetup) {
		this.segTempoSetup = segTempoSetup;
	}

	/*
	 * Determina se o passo � ultimo no roteiro
	 */
	public boolean isEoUltimoDoRoteiro(){
		boolean isretorno = true;
		
		for (DwRotapasso rp : getDwrota().getDwRotapassos()){
			for (DwRpPredecessora rppre : rp.getDwRpPredecessorasForIdRotapassoPai()){
				if (rppre.getDwRotapassoByIdRotapassoFilho().getIdRotapasso() == getDwrotapasso().getIdRotapasso()){
					isretorno = false;
					break;
				}
			}
		}
		return isretorno;
	}
	
	/* Determina se o passo eh para linhas de SMD
	 * 
	 */
	public boolean isParaSMD(){
		boolean isretorno = false;
		
		for (CtDTO cpos : getCtsPossiveis()){
			if (cpos.getId().getOmgtEscolhido() != null) {
				isretorno = true;
				break;
			}
		}
		return isretorno;
	}

	/*
	 * Determina se as predecessoras 
	 */
	public boolean isPredecessorasParaSMD(){
		boolean isretorno = false;
		for (PassosDTO papre : getPassosPredecessoras()) {
			if (papre.isParaSMD() == true){
				isretorno = true;
				break;
			}
		}
		return isretorno;
	}

	/*
	 * Obtem o ultimo CT da lista ordenada pela descricao do ct
	 */
	public CtDTO  getCtsPossiveisUltimoCTOrdenadoAlfa() {
		CtDTO retorno = null;
		List<CtDTO> cts = getCtsPossiveis();
		
		Collections.sort(cts, new Comparator<CtDTO>() {

			@Override
			public int compare(CtDTO o1, CtDTO o2) {
				int retorno = 0;
				
				if (o1.getId().getOmgtEscolhido() != null && o2.getId().getOmgtEscolhido() != null){
					OmGt gt1 = o1.getId().getOmgtEscolhido();
					OmGt gt2 = o2.getId().getOmgtEscolhido();
					
					retorno = gt1.getDsGt().compareTo(gt2.getDsGt());
				}
				return retorno;
			}
		});

		retorno = cts.get(cts.size() - 1);
		
		return retorno;
	}


	public CtDTO  getCtsPossiveisPenultimoCTOrdenadoAlfa() {
		CtDTO retorno = null;
		List<CtDTO> cts = getCtsPossiveis();
		
		Collections.sort(cts, new Comparator<CtDTO>() {

			@Override
			public int compare(CtDTO o1, CtDTO o2) {
				int retorno = 0;
				
				if (o1.getId().getOmgtEscolhido() != null && o2.getId().getOmgtEscolhido() != null){
					OmGt gt1 = o1.getId().getOmgtEscolhido();
					OmGt gt2 = o2.getId().getOmgtEscolhido();
					
					retorno = gt1.getDsGt().compareTo(gt2.getDsGt());
				}
				return retorno;
			}
		});

		retorno = cts.get(cts.size() - 2);
		
		return retorno;
	}

	private void verificaIndisponibilidadePredecessora(IdwLogger log, int idLog, int identacao, PassosDTO pre){
		if((pre.getCtEscolhido()!=null)&&
				((pre.getCtEscolhido().getHorariosIndisponiveis() == null)||
				((pre.getCtEscolhido().getHorariosIndisponiveis() != null) &&
				((pre.getCtEscolhido().getHorariosIndisponiveis().getListaIndisponibilidades()==null) ||
				((pre.getCtEscolhido().getHorariosIndisponiveis().getListaIndisponibilidades()!=null)&&
				(pre.getCtEscolhido().getHorariosIndisponiveis().getListaIndisponibilidades().size()==0)))))){
			calculaIndisponibilidade(log, idLog, identacao, pre);
		}
	}
	
	private void calculaIndisponibilidade(IdwLogger log, int idLog, int identacao, PassosDTO pre){
	
		DAOGenerico	daoInd = new DAOGenerico();
		daoInd.iniciaConexaoBanco();
		PlanoIndisponibilidadeRN irn = new PlanoIndisponibilidadeRN(daoInd);
		CalendarioRN crn = new CalendarioRN();
		crn.setSession(daoInd.getSession());
		TipoAIndisponibilidade indRN = new TipoAIndisponibilidade(daoInd);
		indRN.calculandoIndisponibilidade(log, idLog, identacao, irn, crn, pre.getCtEscolhido(), null);
		daoInd.finalizaConexaoBanco();
	}
	
	public boolean isPossuiMPSuficiente() {
		return isPossuiMPSuficiente;
	}

	public void setPossuiMPSuficiente(boolean isPossuiMPSuficiente) {
		this.isPossuiMPSuficiente = isPossuiMPSuficiente;
	}

	public double getTempoProd() {
		return tempoProd;
	}

	public void setTempoProd(double tempoProd) {
		this.tempoProd = tempoProd;
	}

	public List<PpCpfaltamp> getMpfaltante() {
		return mpfaltante;
	}

	public void setMpfaltante(List<PpCpfaltamp> mpfaltante) {
		this.mpfaltante = mpfaltante;
	}
	public PpPlano getPpplano() {
		return ppplano;
	}

	public void setPpplano(PpPlano ppplano) {
		this.ppplano = ppplano;
	}
	
	public int getQtMaxPassos(){
		int retorno = 1; // Um ja contando o proprio passo
		
		int qtmaxpre = 0;
		for (PassosDTO pre : this.getPassosPredecessoras()) {
			int qtmax = pre.getQtMaxPassos();
			if (qtmax > qtmaxpre)
				qtmaxpre = qtmax;
		}
		
		return retorno+qtmaxpre;
	}

	public List<PassosDTO> getPassosNoNivel(int nivel){
		// Um passo eh de determinado nivel quando antes dele existe nivel-1 passos exatamente
		
		List<PassosDTO> retorno = new ArrayList<PassosDTO>();
		
		// Avalia o passo atual, se o mesmo tiver qtMaxNivel = (nivel-1) entao entrar no retorno
		// o -1 do QtMaxPassos eh para tirar o proprio passo avaliado
		if ( (getQtMaxPassos()-1) == (nivel - 1)){
			retorno.add(this);
		}
		
		// Avalia as predevessoras
		for (PassosDTO pre : this.getPassosPredecessoras()){
			retorno.addAll(pre.getPassosNoNivel(nivel));
		}
		
		return retorno;
	}
	
	
	
	public String getIdentificacaoPasso() {
		return identificacaoPasso;
	}

	public void setIdentificacaoPasso(String identificacaoPasso) {
		this.identificacaoPasso = identificacaoPasso;
	}

	public static void main(String[] args) {
		PpPlano plano = new PpPlano();
		
		// Teste de qtmaxpassos
		PassosDTO p4 = new PassosDTO(plano);
		PassosDTO p3A = new PassosDTO(plano);
		PassosDTO p2A = new PassosDTO(plano);
		PassosDTO p1A = new PassosDTO(plano);
		
		PassosDTO p2B = new PassosDTO(plano);
		PassosDTO p1B = new PassosDTO(plano);

		PassosDTO p3C = new PassosDTO(plano);
		PassosDTO p2C = new PassosDTO(plano);
		PassosDTO p1C = new PassosDTO(plano);
		PassosDTO p0C = new PassosDTO(plano);

		// Identificacao dos passos
		p4.setIdentificacaoPasso("p4");
		p3A.setIdentificacaoPasso("p3A");
		p2A.setIdentificacaoPasso("p2A");
		p1A.setIdentificacaoPasso("p1A");

		p2B.setIdentificacaoPasso("p2B");
		p1B.setIdentificacaoPasso("p1B");

		p3C.setIdentificacaoPasso("p3C");
		p2C.setIdentificacaoPasso("p2C");
		p1C.setIdentificacaoPasso("p1C");
		p0C.setIdentificacaoPasso("p0C");

		// Criacao roteiro
		p4.getPassosPredecessoras().add(p3A);
		p3A.getPassosPredecessoras().add(p2A);
		p2A.getPassosPredecessoras().add(p1A);

		p4.getPassosPredecessoras().add(p2B);
		p2B.getPassosPredecessoras().add(p1B);

		p4.getPassosPredecessoras().add(p3C);
		p3C.getPassosPredecessoras().add(p2C);
		p2C.getPassosPredecessoras().add(p1C);
		p1C.getPassosPredecessoras().add(p0C);

	}
	
	
	
	
	public void inicializaPredecessoras(DAOGenerico dao){
		for (DwRpPredecessora pre : this.dwrotapasso.getDwRpPredecessorasForIdRotapassoPai()){
			DwRotapasso dwrotapassoPredecessora = pre.getDwRotapassoByIdRotapassoFilho();
			
			// Encontra a folha do passo da predecessora
			DwFolha dwfolhaPredecessora = null;
			dwfolhaPredecessora = dwrotapassoPredecessora.getDwFolha();
			
			// Encontra a folhaiac da predecessora
			DwFolhaiac dwfolhaiacPredecessora = null;
			dwfolhaiacPredecessora = dwfolhaPredecessora.getDwFolhaiacs().iterator().next();

			// Encontra o produto
			OmProduto omprodutoPredecessora = null;
			omprodutoPredecessora = dwfolhaiacPredecessora.getOmProduto();
			ProdutoComparable pc = new ProdutoComparable();
			pc.setOmproduto(omprodutoPredecessora);

			PassosDTO passoPre = new PassosDTO(ppplano);
			passoPre.setOmproduto(pc);
			passoPre.setProducaoPlanejada(producaoPlanejada);
			passoPre.setDwfolha(dwfolhaPredecessora);
			passoPre.setDwrota(dwrota);
			passoPre.setDwrotapasso(dwrotapassoPredecessora);
			passoPre.setDwcal(null);
			passoPre.setEspelho(pre.getIsEspelho() == null ? false : pre.getIsEspelho());

			passoPre.defineCtsDisponiveis(dwrotapassoPredecessora, null, 0, 0, dao);
			
			this.getPassosPredecessoras().add(passoPre);
			
			// Recursivamente pega as mesmas informacoes para as predecessoras
			passoPre.inicializaPredecessoras(dao);
		}
	}

	public boolean isCtsPossiveisDefinidosManualmente() {
		return isCtsPossiveisDefinidosManualmente;
	}

	public void setCtsPossiveisDefinidosManualmente(
			boolean isCtsPossiveisDefinidosManualmente) {
		this.isCtsPossiveisDefinidosManualmente = isCtsPossiveisDefinidosManualmente;
	}
	
	
}
