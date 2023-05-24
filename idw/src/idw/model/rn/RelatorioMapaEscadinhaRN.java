package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.PpNec;
import idw.webservices.dto.DadosRelatorioDTO;
import idw.webservices.dto.RelatorioDTO;
import idw.webservices.dto.RelatoriosDTO;

public class RelatorioMapaEscadinhaRN extends AbstractRN<DAOGenerico>{

    private Date dateInicioApont;
    private Date dateFimApont;
    private Date dateInicioPlan;
    private Date dateFimPlan;
    private PpNec ppnec;

    public RelatorioMapaEscadinhaRN(DadosRelatorioDTO dados){
    	super(new DAOGenerico());
    	this.dateInicioApont = dados.getDateInicioApont();
	    this.dateFimApont = dados.getDateFimApont();
	    this.dateInicioPlan = dados.getDateInicioPlan();
	    this.dateFimPlan = dados.getDateFimPlan();
	    this.ppnec = dados.getPpnec();
    }
	
	public RelatorioMapaEscadinhaRN(DAOGenerico dao){
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public DadosRelatorioDTO geraRelatorioEscadinha(){
		
		DadosRelatorioDTO retorno = new DadosRelatorioDTO();
		
		if(this.dateInicioApont != null && this.dateFimApont != null){
			this.dateInicioApont = DataHoraRN.setHoraNaData(this.dateInicioApont,0,0,0,0);
			this.dateFimApont = DataHoraRN.setHoraNaData(this.dateFimApont, 23, 59, 59, 59);
		}
		
		if (this.ppnec == null){
			//retorno = geraRelatorio();
		}else 
			retorno = geraRelatorioPpNec(this.ppnec);
		
		return retorno;
	}
	
	private DadosRelatorioDTO geraRelatorio(){
		RelatorioDiarioTurnoHoraRN relRN = new RelatorioDiarioTurnoHoraRN(getDao());
		relRN.setCalculaApont(true, dateInicioApont,dateFimApont);
		DadosRelatorioDTO retorno = relRN.relatorioPlanejadoRealizado(dateInicioPlan, dateFimPlan);
		//reorganizar p ver quem é predecessora de quem
		//pesquisaListaPredecessoraCP
		return retorno;
	}
	
	private DadosRelatorioDTO geraRelatorioPpNec(PpNec ppnecDto){
		RelatorioDiarioTurnoHoraRN relRN = new RelatorioDiarioTurnoHoraRN(getDao());
		DadosRelatorioDTO retorno = relRN.relatorioPlanejadoRealizadoByProdutoFinal(dateInicioPlan, dateFimPlan, ppnecDto, false, true, dateInicioApont, dateFimApont);
		retorno = filtraCps(retorno);
		return retorno;
	}
	
	private DadosRelatorioDTO filtraCps(DadosRelatorioDTO relatorio){
		DadosRelatorioDTO retorno = new DadosRelatorioDTO();
		List<RelatoriosDTO> relat = new ArrayList<RelatoriosDTO>();
		
		for(RelatoriosDTO relLista: relatorio.getListaRelatorios()){
			if(relat.isEmpty()){
				relat.add(relLista);
				continue;
			}
			List<RelatoriosDTO> listaAddRelat = new ArrayList<RelatoriosDTO>();
			for(RelatoriosDTO relNovaLista: relat){
				if(relNovaLista.getProduto().getCdProduto().equals(relLista.getProduto().getCdProduto())){
					if(relNovaLista.getPpcp().getIdCp().compareTo(relLista.getPpcp().getIdCp())==0)
						continue;
					relNovaLista.setQtdApont(relNovaLista.getQtdApont().add(relLista.getQtdApont()));
					
					if((relNovaLista == null)||(relNovaLista.getRel()==null)){
						continue;
					}
					List<RelatorioDTO> listaAdd = new ArrayList<RelatorioDTO>();
					 for (RelatorioDTO relatorioRelNovaLista:relNovaLista.getRel()){
						 for(int i =0; i< relLista.getRel().size(); i++){
							 if(DataHoraRN.isDiaMesAnoIguais(relatorioRelNovaLista.getData(),relLista.getRel().get(i).getData())==false){
								 if(DataHoraRN.before(relatorioRelNovaLista.getData(), relLista.getRel().get(i).getData()))
									 continue;
								 else{
									 listaAdd.add(relLista.getRel().get(i));
								 	continue;}
						 	}			  
							 
							for(int j =0; j< relatorioRelNovaLista.getQtdTurnos().getTurnos().size(); j++){
								relatorioRelNovaLista.getQtdTurnos().getTurnos().get(j).setQuantidade(relatorioRelNovaLista.getQtdTurnos().getTurnos().get(j).getQuantidade().add(relLista.getRel().get(i).getQtdTurnos().getTurnos().get(j).getQuantidade()));
								relatorioRelNovaLista.getQtdTurnoReal().getTurnos().get(j).setQuantidade(relatorioRelNovaLista.getQtdTurnoReal().getTurnos().get(j).getQuantidade().add((relLista.getRel().get(i).getQtdTurnoReal().getTurnos().get(j).getQuantidade())));
							}
						 }
					 }
					 relNovaLista.getRel().addAll(listaAdd);
				}else{
					if(containLista(relat, listaAddRelat, relLista)==false){
						listaAddRelat.add(relLista);
					}
				}
				
			}
			relat.addAll(listaAddRelat);
				
		}
		retorno = relatorio;
		retorno.setListaRelatorios(relat);
		return retorno;
	}
	
	private boolean containLista(List<RelatoriosDTO>relat,List<RelatoriosDTO>listaAddRelat, RelatoriosDTO relLista){
		boolean retorno = false;
		for(RelatoriosDTO relatorio: relat){
			if(relatorio.getProduto().getCdProduto().equals(relLista.getProduto().getCdProduto())){
				retorno = true;
				break;
			}
		}
		if(retorno == false){
			for(RelatoriosDTO relatorio: listaAddRelat){
				if(relatorio.getProduto().getCdProduto().equals(relLista.getProduto().getCdProduto())){
					retorno = true;
					break;
				}
			}
		}
		return retorno;
	}
}
