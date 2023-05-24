package idw.model.rn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpPlano;
import idw.model.rn.geraplano.dtos.CtDTO;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.model.rn.geraplano.passos.tipoA.TipoAIndisponibilidade;
import idw.util.IdwLogger;
import idw.webservices.dto.AdiantamentoDTO;
import idw.webservices.dto.AlocacaoProdutoMaquinaDTO;
import idw.webservices.dto.CpDTO;
import idw.webservices.dto.CpsDTO;
import idw.webservices.dto.ListaCPDTO;
import idw.webservices.dto.PlanoDTO;

public class AdiantamentoRN implements IDao{

	private AdiantamentoDTO adiantamentoProduto;
	private PlanoDTO plano;
	protected DAOGenerico dao;
	private IdwLogger log;
	private Date dataDeAdiantamentoTemporario = new Date();
	private List<PpCp> cpNaoAdiantado = new ArrayList<PpCp>();
	
	public DAOGenerico getDao(){
		return this.dao;
	}
	
	public AdiantamentoRN(PlanoDTO plano, AdiantamentoDTO adiantamentoProduto){
		if (this.dao == null){
			this.dao = new DAOGenerico();
		}
		this.adiantamentoProduto = adiantamentoProduto;
		this.plano = plano;
		log = new IdwLogger("AdiantamentoRN");	
	}

	public AdiantamentoRN(DAOGenerico dao) {
		this.dao = dao;
		log = new IdwLogger("AdiantamentoRN");
	}
	
	public AdiantamentoDTO getAdiantamentoProduto() {
		return adiantamentoProduto;
	}

	public void setAdiantamentoProduto(AdiantamentoDTO adiantamentoProduto) {
		this.adiantamentoProduto = adiantamentoProduto;
	}
	
	public List<PpCp> getCpNaoAdiantado() {
		return cpNaoAdiantado;
	}

	public void setCpNaoAdiantado(List<PpCp> cpNaoAdiantado) {
		this.cpNaoAdiantado = cpNaoAdiantado;
	}

	public CpsDTO adiantamentoRn(){
		
		log.info("AdiantamentoRN iniciando...");
		
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		PlanoProducaoRN planoRN = new PlanoProducaoRN(dao);
		planoRN.setIdPlano(plano.getIdPlano());
		PpPlano ppplano = planoRN.pesquisarPlanoById();
		
		Date  dataReferencia = adiantamentoProduto.getData();
		
		//1 - ver qual maquina tem disponibilidade para adiantar
		log.info("Verificando as Maquinas que podem realizar o adiantamento");
		verificaDisponibilidadeDaMaquinaParaAdiantamento(this.adiantamentoProduto.getMaquina(), dataReferencia);

		//2 - transformar em passosDTO
		log.info("Recuperando os passos");
		Set<PassosDTO> lista = listaPassos (log, idLog, identacao, ppplano, this.adiantamentoProduto);
		
		//3 - organizar pela predecessora e datas de inicio
		log.info("Ordenando Passos");
		List<PassosDTO> listaPassos = ordenarPassosPeloInicio(lista);
		
		//4 - Adiantar
		log.info("Adiantamento... ");
		adiantamento (log, idLog, identacao, this.adiantamentoProduto.getMaquina(), listaPassos, dataReferencia);
		
		CpsDTO retorno = new CpsDTO();
		List<PpCp> listaCp = new ArrayList<PpCp>();
		listaCp.addAll(getCpNaoAdiantado());
		retorno.setListaCp(listaCp);
		
		return retorno;
		
	}
	
	private void verificaDisponibilidadeDaMaquinaParaAdiantamento(List<AlocacaoProdutoMaquinaDTO> listaMaquinas, Date dataAdiantamento){
		
		List<AlocacaoProdutoMaquinaDTO> excluirMaquina = new ArrayList<AlocacaoProdutoMaquinaDTO>();
		
		for(AlocacaoProdutoMaquinaDTO maquina: listaMaquinas){
			
			ordenarPpCp(maquina.getCps().getListaCp());
			Date anterior = maquina.getCps().getListaCp().get(0).getDthrInicio();
			
			if(DataHoraRN.before(dataAdiantamento, anterior)==true){
				maquina.setTempoExecucaoCps(DataHoraRN.getQuantidadeSegundosNoPeriodo(dataAdiantamento, anterior));
				maquina.getCpReferencia().setCp(maquina.getCps().getListaCp().get(0));
				continue;
			}else{
				
				for(PpCp cp: maquina.getCps().getListaCp()){
					if(DataHoraRN.isIntersecao(dataAdiantamento, cp.getDthrInicio(), cp.getDthrFinal())==true){
						excluirMaquina.add(maquina);
						break;
					}
					if (DataHoraRN.isIntersecao(dataAdiantamento, anterior,cp.getDthrInicio())==true){
						maquina.setTempoExecucaoCps(DataHoraRN.getQuantidadeSegundosNoPeriodo(dataAdiantamento, cp.getDthrInicio()));
						maquina.getCpReferencia().setCp(cp);
						break;
					}
					anterior = cp.getDthrFinal();
				}
				
			}
		}
		
		if(excluirMaquina.size()>0){
			listaMaquinas.removeAll(excluirMaquina);
		}
		
	}
	
	private Set<PassosDTO> listaPassos(IdwLogger log, int idLog, int identacao, PpPlano ppplano, AdiantamentoDTO adiantamentoProduto){
		
		Set<PassosDTO> retorno = new HashSet<PassosDTO>();
		CpRN rn = new CpRN(dao);
		
		for(PpCpproduto produto: this.adiantamentoProduto.getProdutos()){
			
			produto.getPpCp().setCdCp(produto.getOmProduto().getCdProduto());
			
			if (DataHoraRN.after(this.adiantamentoProduto.getData(), produto.getPpCp().getDthrInicio())==true){
				cpNaoAdiantado.add(produto.getPpCp().clone());
				continue;
			}
			
			if(pesquisaNomeMaquina(adiantamentoProduto.getMaquina(),produto)==false){
				cpNaoAdiantado.add(produto.getPpCp().clone());
				continue;
			}
			
			produto.setPpCp(rn.pesquisarPpCpByIdCp(produto.getPpCp()));
			
			CtDTO ctdto = indisponibilidade (log, idLog, identacao, produto.getPpCp());
			
			DwRotapasso rotaPasso = null;
			Iterator<DwRotapasso> i = produto.getPpCp().getDwFolha().getDwRotapassos().iterator();
			if (i.hasNext() == true)
				rotaPasso = i.next();
			
			List<PassosDTO> listaPredecessorasPassos = pesquisandoPredecessoras (log, idLog, identacao, ppplano, produto.getPpCp().getIdCp());
			
			PassosDTO passosdto = new PassosDTO(produto);
			passosdto.setPpcpAposInclusao(produto.getPpCp().clone());
			passosdto.setPpplano(ppplano.clone());
			passosdto.setDwrotapasso(rotaPasso.clone());
			passosdto.setCtEscolhido(ctdto);
			passosdto.setPassosPredecessoras(listaPredecessorasPassos);
			
			//int tmp = passosdto.getTempoEstimadoSegundos();
			retorno.add(passosdto);
		}
		
		return retorno;
	}
	
	private boolean pesquisaNomeMaquina(List<AlocacaoProdutoMaquinaDTO> listaMaquinas, OmGt omgt){
		boolean retorno = false;	
		for (AlocacaoProdutoMaquinaDTO maquina: listaMaquinas){
			if((maquina.getId().getOmgtEscolhido()!= null)
					&&(maquina.getId().getOmgtEscolhido().getCdGt().equals(omgt.getCdGt()))){
				retorno = true;
				break;
			}
		}
		return retorno;
	}
	
	private boolean pesquisaNomeMaquina(List<AlocacaoProdutoMaquinaDTO> listaMaquinas, OmPt ompt){
		boolean retorno = false;
		for (AlocacaoProdutoMaquinaDTO maquina: listaMaquinas){
			if ((maquina.getId().getOmptEscolhido() != null)
					&&(maquina.getId().getOmptEscolhido().getCdPt().equals(ompt.getCdPt()))){
				retorno = true;
				break;
			}
		}
		return retorno;
	}
	
	private boolean pesquisaNomeMaquina(List<AlocacaoProdutoMaquinaDTO> listaMaquinas, PpCpproduto produto){
		boolean retorno = false;
		
		if(produto.getPpCp().getOmGt()!= null){
			retorno = pesquisaNomeMaquina(listaMaquinas, produto.getPpCp().getOmGt());
		}else if (produto.getPpCp().getOmPt() != null){
			retorno = pesquisaNomeMaquina(listaMaquinas, produto.getPpCp().getOmPt());
		}
		
		return retorno;
	}

	private	List<PassosDTO> pesquisandoPredecessoras (IdwLogger log, int idLog, int identacao, PpPlano ppplano, long idProduto){
			
		CpRN rn = new CpRN(dao);
		
		ListaCPDTO listaPre = rn.pesquisaListaPredecessoraCP(idProduto);
		
		List<PassosDTO> listaPredecessorasPassos = new ArrayList<PassosDTO>();
		
		for(CpDTO cpPre: listaPre.getListaCps()){
			
			Long idProdutoPre = (long) 0;
			Double producaoPlanejada = 0.0;
			
			CtDTO ctdto = indisponibilidade(log, idLog, identacao, cpPre.getCp());
			
			ProdutoComparable omprod = new ProdutoComparable();			
			Iterator<PpCpproduto> j = cpPre.getCp().getPpCpprodutos().iterator();
			if (j.hasNext() == true){
				PpCpproduto produtoOm = j.next();
				omprod.setOmproduto(produtoOm.getOmProduto());
				producaoPlanejada = produtoOm.getPcsProducaoplanejada().doubleValue();
				idProdutoPre = produtoOm.getIdCpproduto();
			}
			
			List<PassosDTO> listaPredecessorasPre = pesquisandoPredecessoras (log, idLog, identacao, ppplano, idProdutoPre);
			
			PassosDTO passos = new PassosDTO(cpPre.getCp().clone());
			passos.setCtEscolhido(ctdto);
			passos.setPpcpAposInclusao(cpPre.getCp().clone());
			passos.setProducaoPlanejada(producaoPlanejada);
			passos.setOmproduto(omprod);
			passos.setProducaoPlanejada(producaoPlanejada);
			passos.setPpplano(ppplano.clone());
			
		//	int tmp = passos.getTempoEstimadoSegundos();
			listaPredecessorasPassos.add(passos);
		}
		
		return listaPredecessorasPassos;
	}
	
	public CtDTO indisponibilidade (IdwLogger log, int idLog, int identacao, PpCp ppcp){
		
		CalendarioRN crn = new CalendarioRN();
		crn.setSession(dao.getSession());
		
		TipoAIndisponibilidade indRN = new TipoAIndisponibilidade(dao);
		
		PlanoIndisponibilidadeRN irn = new PlanoIndisponibilidadeRN(dao);
		
		IdCtDTO idctDTO = new IdCtDTO();
		idctDTO.setOmgtEscolhido(ppcp.getOmGt());
		idctDTO.setOmptEscolhido(ppcp.getOmPt());
		OmPt omPT = idctDTO.getOmptEscolhido();
		
		if(omPT == null){
			omPT = new OmPt();
			omPT.setCdPt(ppcp.getOmGt().getCdGt());
		}
		
		CtDTO ctdto = new CtDTO(omPT);
		ctdto.setId(idctDTO);
		
		indRN.calculandoIndisponibilidade(log, idLog, identacao, irn, crn, ctdto, null);
		
		//criado para guardar o PpCp p procurar predecessoras
		DwFolha folha = new DwFolha();
		folha.getPpCps().add(ppcp);
		ctdto.setDwfolha(folha);
		
		return ctdto;
	}

	public void adiantamento (IdwLogger log, int idLog, int identacao, List<AlocacaoProdutoMaquinaDTO> listaProducaoMaquinas, List<PassosDTO> listaPassos, Date dataReferencia){
		
		CpRN rn = new CpRN(dao);		
		
		List<CtDTO> listactDTO = new ArrayList<CtDTO>();
		
		for (PassosDTO passos: listaPassos){
			
			dataDeAdiantamentoTemporario = dataReferencia;
			int index = pesquisarPassosLista(listactDTO, passos);
			
			if(passos.getPassosPredecessoras().size()>0){
				
				if (pesquisaPredecessoraNaListaDeCTDTO(listactDTO, passos)==false){
					cpNaoAdiantado.add(passos.getPpcpAposInclusao().clone());
					continue;
				}
			}
			
			boolean isIndisponivel = passos.setInicioParaAdiantamento(dataDeAdiantamentoTemporario);
			
			if (isIndisponivel == false){
				cpNaoAdiantado.add(passos.getPpcpAposInclusao().clone());
				continue;
			}
			
			passos.calculaDatasFimDtInicioPrevista();
			
			//passos.calculaDatasInicioFim(log, idLog, identacao, passos.getFim());//é necessário? pq o cliente pode querer adiantar a sucessora mas n a predecessora
			//int tmp = passos.getTempoEstimadoSegundos();
			PpCp produtoCp = passos.getPpcpAposInclusao().clone();
			produtoCp.setDthrInicio(passos.getInicio());
			produtoCp.setDthrFinal(passos.getFim());
			
			if ((verificaDatas(passos) == true)&&(verificarDisponibilidadeDaMaquina(listaProducaoMaquinas, produtoCp)==true)){
				
				log.info("Gravando PpCp");
				rn.updatePpCpComNovoInicio(produtoCp);
				
				if (index == -1){
					CtDTO ctdto = new CtDTO(passos.getCtEscolhido());
					ctdto.getPassosAlocados().add(passos);
					listactDTO.add(ctdto);
				}else{
					listactDTO.get(index).getPassosAlocados().add(passos);
				}
			}else{
				cpNaoAdiantado.add(passos.getPpcpAposInclusao().clone());
			}
		}
	}
	
	private boolean verificaDatas(PassosDTO passo){
		boolean retorno = true;
		
		for(PassosDTO predecessora: passo.getPassosPredecessoras()){
			if((DataHoraRN.after(predecessora.getInicio(), passo.getInicio())) 
					|| (DataHoraRN.after(predecessora.getFim(), passo.getFim()))){
				retorno = false;
			}
		}
		
		return retorno;
	}
	
	private int pesquisarPassosLista(List<CtDTO> listactDTO, PassosDTO passos){
		boolean isPossui = false;
		int i = -1;
		for(i=0; i < listactDTO.size(); i++){
			if ((passos.getCtEscolhido().getId().getOmgtEscolhido()!=null) &&
					(listactDTO.get(i).getId().getOmgtEscolhido() != null)&&
					(passos.getCtEscolhido().getId().getOmgtEscolhido().equals(listactDTO.get(i).getId().getOmgtEscolhido())==true)){
					isPossui = true;
					break;
				
			}else if((passos.getCtEscolhido().getId().getOmptEscolhido()!=null) &&
					(listactDTO.get(i).getId().getOmptEscolhido() != null) &&
					(passos.getCtEscolhido().getId().getOmptEscolhido().equals(listactDTO.get(i).getId().getOmptEscolhido())==true)){
					isPossui = true;
					break;
			}
		}
		
		if (isPossui == false){
			i = -1;
		}else{
			int indice = listactDTO.get(i).getPassosAlocados().size() - 1;
			PassosDTO p = listactDTO.get(i).getPassosAlocados().get(indice);
			dataDeAdiantamentoTemporario = DataHoraRN.adicionaSegundosNaData(p.getFim(), 1);
		}
		
		return i;
	}
	
	private boolean pesquisaPredecessoraNaListaDeCTDTO(List<CtDTO> listaCtDTO, PassosDTO passo){
		
		boolean retorno = false;
		PassosDTO rf = null;
		
		for (CtDTO ct: listaCtDTO){
			
			List<PassosDTO> listaPassos = (List<PassosDTO>) ct.getPassosAlocados();
			
			for(PassosDTO passosLista: listaPassos){
				
				for (PassosDTO passosPre: passo.getPassosPredecessoras()){
					if((passosPre.getOmproduto().getOmproduto().getIdProduto() != passosLista.getOmproduto().getOmproduto().getIdProduto())||(passosPre.getPpcpAposInclusao().getIdCp().equals(passosLista.getPpcpAposInclusao().getIdCp())==false)){
						continue;
					}
					rf = passosLista; 
					passosPre.mudaInicioSemConsiderarIndisponibilidade(passosLista.getInicio());
					passosPre.mudaFimSemConsiderarIndisponibilidade(passosLista.getFim());
					retorno = true;
				}
			}
		}
		
		if (rf != null){
			if(DataHoraRN.before(dataDeAdiantamentoTemporario, rf.getFim())){
				dataDeAdiantamentoTemporario = DataHoraRN.adicionaSegundosNaData(rf.getFim(),1);
			}
		}
		
		ordenarPassosPeloInicioDecrescente(passo.getPassosPredecessoras());
		if (DataHoraRN.before(dataDeAdiantamentoTemporario, passo.getPassosPredecessoras().get(0).getInicio())==true){
			retorno = false;
		}else{
			retorno = true;
		}
		
		return retorno;	
	}

	private int excecoesDoTempoDeExecucao(PpCp produto, AlocacaoProdutoMaquinaDTO cps){
		int tempoDeExecucao = cps.getTempoExecucaoCps();
		PpCp anterior  = null;
		
		for (PpCp cp: cps.getCps().getListaCp()){
			if (anterior == null){
				anterior = cp;
				continue;
			}
			if (anterior.getIdCp().equals(produto.getIdCp())){
				tempoDeExecucao = tempoDeExecucao + (DataHoraRN.getQuantidadeSegundosNoPeriodo(anterior.getDthrInicio(), cp.getDthrInicio()));
			}
			anterior = cp;
		}
		if (anterior.getIdCp().equals(produto.getIdCp())){
			tempoDeExecucao = tempoDeExecucao + (DataHoraRN.getQuantidadeSegundosNoPeriodo(anterior.getDthrInicio(), anterior.getDthrFinal()));
		}
		
		return tempoDeExecucao;
	}
	
	private boolean verificarDisponibilidadeDaMaquina(List<AlocacaoProdutoMaquinaDTO> listaProducaoMaquinas, OmGt omGtProduto, int tempoExecucaoProduto, PpCp produto){
		boolean retorno = false;
		
		for(AlocacaoProdutoMaquinaDTO cps: listaProducaoMaquinas){
			if((cps.getId().getOmgtEscolhido()!=null)&&	(cps.getId().getOmgtEscolhido().getCdGt().equals(omGtProduto.getCdGt())==true)){
				
				if(cps.getCpReferencia().getCp().getIdCp().equals(produto.getIdCp())){
					cps.setTempoExecucaoCps(excecoesDoTempoDeExecucao(produto, cps));	
				}
				
				if (cps.getTempoExecucaoCps()>= tempoExecucaoProduto){
					retorno = true;
					cps.setTempoExecucaoCps(cps.getTempoExecucaoCps()-tempoExecucaoProduto);
				}else{
					cps.setTempoExecucaoCps(0);
				}
				
				break;
			}
		}
		
		return retorno;
	}
	
	private boolean verificarDisponibilidadeDaMaquina(List<AlocacaoProdutoMaquinaDTO> listaProducaoMaquinas, OmPt omPtProduto, int tempoExecucaoProduto, PpCp produto){
		boolean retorno = false;
		
		for(AlocacaoProdutoMaquinaDTO cps: listaProducaoMaquinas){
			if((cps.getId().getOmptEscolhido()!=null)&&(cps.getId().getOmptEscolhido().getCdPt().equals(omPtProduto.getCdPt())==true)){
				
				if(cps.getCpReferencia().getCp().getIdCp().equals(produto.getIdCp())){
					cps.setTempoExecucaoCps(excecoesDoTempoDeExecucao(produto, cps));	
				}
				
				if(cps.getTempoExecucaoCps()>=tempoExecucaoProduto){
					cps.setTempoExecucaoCps(cps.getTempoExecucaoCps()-tempoExecucaoProduto);
					retorno = true;
				}else{
					cps.setTempoExecucaoCps(0);
				}
				break;
			}
		}

		return retorno;
	}
	
	private boolean verificarDisponibilidadeDaMaquina(List<AlocacaoProdutoMaquinaDTO> listaProducaoMaquinas, PpCp produtoCp){
		boolean retorno = false;
		int tempoExec = DataHoraRN.getQuantidadeSegundosNoPeriodo(produtoCp.getDthrInicio(), produtoCp.getDthrFinal());
		
		if (produtoCp.getOmGt()!=null){
			retorno = verificarDisponibilidadeDaMaquina(listaProducaoMaquinas, produtoCp.getOmGt(), tempoExec, produtoCp);
		}else if (produtoCp.getOmPt()!=null){
			retorno = verificarDisponibilidadeDaMaquina(listaProducaoMaquinas, produtoCp.getOmPt(), tempoExec, produtoCp);
		}
		
		return retorno;
	}

	private List<PassosDTO> ordenarPassosPeloInicio(Set<PassosDTO> listaPassos){
		List<PassosDTO> listaOrdenada = new ArrayList<PassosDTO>();
		listaOrdenada.addAll(listaPassos);
		Collections.sort(listaOrdenada, new Comparator<PassosDTO>() {
			@Override
			public int compare(PassosDTO o1, PassosDTO o2) {
				return DataHoraRN.compareTo(o1.getInicio(), o2.getInicio());
			}
		});
		
		return listaOrdenada;
	}
	
	private void ordenarPassosPeloInicioDecrescente(List<PassosDTO> listaPassos){
		Collections.sort(listaPassos, new Comparator<PassosDTO>() {
			@Override
			public int compare(PassosDTO o1, PassosDTO o2) {
				return DataHoraRN.compareTo(o1.getInicio(), o2.getInicio())*-1;
			}
		});
	}
	
	private void ordenarPpCp(List<PpCp> lista){
		
		Collections.sort(lista, new Comparator<PpCp>() {
			@Override
			public int compare(PpCp o1, PpCp o2) {
				return DataHoraRN.compareTo(o1.getDthrInicio(), o2.getDthrInicio());
			}
		});
		
	}
	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}
	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.getDao().iniciaSessao();
		this.getDao().iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.getDao().finalizaTransacao();
		this.getDao().finalizaSessao();
	}
}