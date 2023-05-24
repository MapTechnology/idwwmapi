package idw.model.rn.estoque;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwConsolestlocalproDAO;
import idw.model.dao.DwConsolidDAO;
import idw.model.dao.DwEstDAO;
import idw.model.dao.DwEstlocalDAO;
import idw.model.dao.DwEstlocalproDAO;
import idw.model.dao.DwEstmovDAO;
import idw.model.dao.DwEstproDAO;
import idw.model.dao.DwEstsalmaDAO;
import idw.model.dao.MapQuery;
import idw.model.dao.OmProcomestDAO;
import idw.model.dao.OmProdutoDAO;
import idw.model.excessoes.SemConfiguracaoException;
import idw.model.pojos.DwConsolestlocalpro;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstmovRap;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.DwEstsalma;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRpPredecessora;
import idw.model.pojos.DwTpest;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmProcomest;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.DwEstMovTemplate;
import idw.model.pojos.template.DwEstMovTemplate.TpOrigem;
import idw.model.pojos.template.DwEstProTemplate;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.DwRapRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.RoteiroRN;
import idw.model.rn.UsuarioRN;
import idw.util.AritmeticaUtil;
import idw.util.CompareUtils;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.DwEstlocalproDTO;
import idw.webservices.dto.DwEstlocalprosDTO;
import idw.webservices.dto.DwconsolestlocalprosDTO;
import idw.webservices.dto.EstoqueDTO;
import idw.webservices.dto.EstoquesDTO;
import idw.webservices.dto.FiltroConsolLocalEstoqueDTO;
import idw.webservices.dto.FiltroMonitorizacaoLocalEstoque;
import idw.webservices.dto.SucessoDTO;

public class EstoqueRN extends AbstractRN<DAOGenerico>{

	private DwEstmovRap dwestmovrap;
	
	public EstoqueRN(){
		this(null);
	}
	
	public EstoqueRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public EstoquesDTO getEstoquesDTO(EstoqueDTO filtro) {
		DwEstDAO dwEstDAO = new DwEstDAO(getDaoSession());
		List<DwEst> listaPesquisa = null;
		try{
			listaPesquisa = dwEstDAO.getEstoquesDTO(filtro);
		} catch (Exception e){
			e.printStackTrace();
		}

		List<EstoqueDTO> lista = new ArrayList<EstoqueDTO>();

		if (listaPesquisa != null){
			for (DwEst item : listaPesquisa) {
				EstoqueDTO itemDTO = new EstoqueDTO();								
				itemDTO.setEstoque((DwEst)item.clone(false));
				itemDTO.getEstoque().setOmUsrByIdUsrrevisao(item.getOmUsrByIdUsrrevisao().clone(false));
				itemDTO.getEstoque().setOmUsrByIdUsrstativo(item.getOmUsrByIdUsrstativo().clone(false));
				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
		}

		EstoquesDTO dtoRetorno = new EstoquesDTO();
		dtoRetorno.setEstoques(lista);
		return dtoRetorno;
	}
	
	public EstoquesDTO pesquisarEstoqueMateriaPrima(String cdEst, String cdProduto,String cdCliente){
		
		EstoquesDTO retorno = new EstoquesDTO();
		DwEstDAO dwEstDAO = new DwEstDAO(getDaoSession());
		List<DwEst> lista = dwEstDAO.pesquisarEstoqueMateriaPrima(cdEst, cdProduto, cdCliente);
		List<EstoqueDTO> listaRetorno = new ArrayList<EstoqueDTO>();
		
		for (DwEst estoque :lista){
			EstoqueDTO e = new EstoqueDTO();
			e.setEstoque((DwEst) estoque.clone());
			listaRetorno.add(e);
		}
		retorno.setEstoques(listaRetorno);
		
		DwEstsalmaDAO dwEstsalmaDAO = new DwEstsalmaDAO(getDaoSession());
		
		//AGORA PESQUISA OS SALDOS DO MES ANTERIOR CONFORME FILTROS PASSADOS
		List<DwEstsalma> listaSalma = dwEstsalmaDAO.getDwEstsalmaPorCdProduto(cdProduto);
		
		for (DwEstsalma salma : listaSalma){
			retorno.getSaldosAnteriores().add(salma.clone());
		}

		return retorno;
	}

	public DwEstpro pesquisarDwEstproByIdProduto(DwEstpro dwEstpro){
		return pesquisarDwEstproByIdProduto(dwEstpro.getOmProduto().getIdProduto());
	}

	public DwEstpro pesquisarDwEstproByIdProduto(long idProduto){
		DwEstproDAO dwEstproDAO = new DwEstproDAO(getDaoSession());
		List<DwEstpro> lista = dwEstproDAO.pesquisarDwEstproByIdProduto(idProduto);
		DwEstpro dwestpro = null;
		try {
			dwestpro = lista.get(0);
		} catch (Exception e) {
		}
		return dwestpro;
	}
	
	public EstoqueDTO salvarEstoqueMateriaPrima(EstoquesDTO estoquesDTO){
		
		EstoqueDTO dtoRetorno = new EstoqueDTO();
		ProdutoRN pRN = new ProdutoRN(getDao());

		//EXCLUIR O QUE FOI MARCADO PARA EXCLUSAO
		for (DwEstsalma dwestsalma : estoquesDTO.getSaldosAnterioresExcluidos()){
			DwEstsalma apagar = (DwEstsalma) pesquisarDwEstsalmaById(dwestsalma);
			if (apagar != null)
				getDao().makeTransient(apagar);
		}		
		
		//INCLUI OS NOVOS
		for (DwEstsalma dwestsalma : estoquesDTO.getSaldosAnteriores()){
			//SE JA EXISTIR UM ID NAO SALVAR
			if (dwestsalma.getIdEstsalma() != null && dwestsalma.getIdEstsalma() > 0)
				continue;
			
			// VERIFICA SE O PRODUTO EXISTE
			OmProduto omproduto = pRN.getProdutoByCdEStAtivo(dwestsalma.getOmProduto().getCdProduto());
			if (omproduto == null){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				break;
			}
			
			dwestsalma.setOmProduto(omproduto);
			getDao().makePersistent(dwestsalma);
		}
		
		return dtoRetorno;
	}
	
	public EstoqueDTO setEstoqueDTO(EstoqueDTO itemDTO) {
		EstoqueDTO dtoRetorno = new EstoqueDTO();
		dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		if (itemDTO.getEstoque().getCdEst().trim().equals("")) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDESTOQUE_INVALIDO());
			return dtoRetorno;
		}
 
		boolean isInclusao = false;

		DwEstDAO dwEstDAO = new DwEstDAO(getDaoSession());
		List<DwEst> listaDwEsts = dwEstDAO.getEstoquesDTO(itemDTO);
		
		DwEst itemOriginal = null;
		
		try {
			itemOriginal = listaDwEsts.get(0);
		} catch (Exception e) {
		}
		
		DwEst itemAlteracao = null;

		if (itemOriginal == null){			
			itemOriginal = (DwEst)itemDTO.getEstoque().clone();




			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());			
			isInclusao = true;
			
			//VERIFICA SE O CODIGO + REVISAO JA EXISTE NO BANCO, SE EXITIR RETORNAR AO CLIENTE A EXCESSAO
			EstoqueDTO filtro = new EstoqueDTO();
			filtro.setEstoque(new DwEst());
			filtro.getEstoque().setCdEst(itemOriginal.getCdEst());
			
			List<DwEst> lista = dwEstDAO.getEstoquesDTO(filtro);

			if (lista == null){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_ESTOQUE_JA_EXISTE());
				return dtoRetorno;
			}
			
			if (lista.size() > 0) {
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_ESTOQUE_JA_EXISTE());
				return dtoRetorno;
			}
		}else{
			
			//20160926FVA:
			if (itemOriginal != null  && itemOriginal.getIdEst() > 0 && itemOriginal.getStAtivo().equals((byte)0))
			{
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_REATIVACAO_INDISPONIVEL());
				return dtoRetorno;
			}
			
			
			itemAlteracao = new DwEst();
			itemAlteracao.copy(itemOriginal, true);
			itemAlteracao.setIdEst(0l);		
			itemAlteracao.setStAtivo((byte)0);
			itemOriginal.copy(itemDTO.getEstoque(), false);		
			itemOriginal.setDtRevisao(DataHoraRN.getDataHoraAtual());
			itemOriginal.setDtStativo(DataHoraRN.getDataHoraAtual());
			itemOriginal.setStAtivo((byte) 1);
		}			

		//SOMENTE APOS PESQUISAR SE A NOVA REVISAO JA EXISTE JA QUE O POJO ORIGINAL DEVE TER A REVISAO SOMADA, SE FOR ANTES,
		//A PESQUISA ACIMA IRA TRAZER O POJO SOMADO
		if (isInclusao == false){
			 itemOriginal.setRevisao(itemAlteracao.getRevisao() + 1);
		}
				
		try {
			OmUsr omUsrRevisao = (OmUsr) getDao().findById(OmUsr.class,itemDTO.getEstoque().getOmUsrByIdUsrrevisao().getIdUsr() , false);
			itemOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
		}

		try {
			OmUsr omUsrStAtivo = (OmUsr) getDao().findById(OmUsr.class,itemDTO.getEstoque().getOmUsrByIdUsrstativo().getIdUsr() , false);
			itemOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
		}
		
		if (dtoRetorno.getResultadoEvento() == dtoRetorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				itemOriginal = (DwEst) getDao().makePersistent(itemOriginal);
				if (itemAlteracao != null){
					itemAlteracao = (DwEst) getDao().makePersistent(itemAlteracao);
				}
			} catch (Exception e){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}			
			dtoRetorno.setEstoque((DwEst)itemOriginal.clone());
		}
		return dtoRetorno;
	}
	
	public EstoquesDTO removeEstoquesDTO(EstoquesDTO itensDTO){
		List<EstoqueDTO> listaRetorno = new ArrayList<EstoqueDTO>();
		DwEstDAO dwEstDAO = new DwEstDAO(getDaoSession());
		EstoquesDTO itensRetorno = new EstoquesDTO();
		
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(itensDTO);
		itensRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return itensRetorno;
		}
		
		
		for (EstoqueDTO item : itensDTO.getEstoques()){
			EstoqueDTO itemRetorno = new EstoqueDTO();
			
			EstoqueDTO filtro = new EstoqueDTO();
			filtro.setEstoque(new DwEst());
			filtro.getEstoque().setIdEst(item.getEstoque().getIdEst());
			List<DwEst> lista = dwEstDAO.getEstoquesDTO(filtro);
			
			DwEst itemOriginal = null;
			
			try {
				itemOriginal = lista.get(0);
			} catch (Exception e) {
			}

			if (itemOriginal == null){			
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDESTOQUE_INVALIDO());
				itemRetorno.setEstoque(item.getEstoque());				
			}else if (itemOriginal.getStAtivo() == 0){			
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDESTOQUE_INVALIDO());
				itemRetorno.setEstoque((DwEst)itemOriginal.clone());				
			}else{
				itemOriginal.setStAtivo((byte)0);
				itemOriginal.setDtStativo(new Date());				

				try{
					itemOriginal = (DwEst) getDao().makePersistent(itemOriginal);			
				} catch (Exception e){
					e.printStackTrace();
				}				

				itemRetorno.setEstoque((DwEst)itemOriginal.clone());
				itemRetorno.setResultadoEvento(0);
			}									

			listaRetorno.add(itemRetorno);
		}

		
		itensRetorno.setEstoques(listaRetorno);
		return itensRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(EstoquesDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		//campos
		DwEst estoqueLiberadoEmUso = omcfg.getDwEstByIdEstliberado();
		DwEst estoqueProducaoEmUso = omcfg.getDwEstByIdEstproducao();
		DwEst estoqueRefugadoEmUso = omcfg.getDwEstByIdEstrefugo();
		DwEst estoqueExpedicaoEmUso = omcfg.getDwEstByIdEstexpedicao();
		DwEst estoqueMateriaPrimaEmUso = omcfg.getDwEstByIdEstmp();		
		DwEst estoqueAlimentacaoEmUso = omcfg.getDwEstByIdEstAlimentacao();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(EstoqueDTO item: itens.getEstoques()) {
			camposEmUsoOmCfg.setCodigo(item.getEstoque().getCdEst());
			
			if(estoqueLiberadoEmUso != null) {
				if(item.getEstoque().getCdEst().equals(estoqueLiberadoEmUso.getCdEst())) {
					camposEmUsoOmCfg.setEstoqueLiberado(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(estoqueProducaoEmUso != null) {
				if(item.getEstoque().getCdEst().equals(estoqueProducaoEmUso.getCdEst())) {
					camposEmUsoOmCfg.setEstoqueProducao(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(estoqueRefugadoEmUso != null) {
				if(item.getEstoque().getCdEst().equals(estoqueRefugadoEmUso.getCdEst())) {
					camposEmUsoOmCfg.setEstoqueRefugado(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(estoqueExpedicaoEmUso != null) {
				if(item.getEstoque().getCdEst().equals(estoqueExpedicaoEmUso.getCdEst())) {
					camposEmUsoOmCfg.setEstoqueExpedicao(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(estoqueMateriaPrimaEmUso != null) {
				if(item.getEstoque().getCdEst().equals(estoqueMateriaPrimaEmUso.getCdEst())) {
					camposEmUsoOmCfg.setEstoqueMateriaPrima(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(estoqueAlimentacaoEmUso != null) {
				if(item.getEstoque().getCdEst().equals(estoqueAlimentacaoEmUso.getCdEst())) {
					camposEmUsoOmCfg.setEstoqueAlimentacao(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getEstoques() != null && itens.getEstoques().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}
	
	public DwEstmov getDwEstmov(OmProduto omProduto, DwEst dwEst, Date dthrMov){
		DwEstmovDAO dwEstmovDAO = new DwEstmovDAO(getDaoSession());
		DwEstmov retorno = dwEstmovDAO.getDwEstmov(omProduto, dwEst, dthrMov);
		return retorno;
	}
	
	public List<DwEstmov> getDwEstmovPeriodo(Collection<OmProduto> collectionOmProduto, DwEst dwEst, Date dthrInicio, Date dthrFim){
		DwEstmovDAO dwEstmovDAO = new DwEstmovDAO(getDaoSession());
		List<DwEstmov> retorno = dwEstmovDAO.getDwEstmovPeriodo(collectionOmProduto, dwEst, dthrInicio, dthrFim);
		return retorno;		
	}
	
	public List<DwEstmov> getDwEstmovPeriodo(OmProduto omProduto, DwEst dwEst, Date dthrInicio, Date dthrFim){
		DwEstmovDAO dwEstmovDAO = new DwEstmovDAO(getDaoSession());
		List<DwEstmov> retorno = dwEstmovDAO.getDwEstmovPeriodo(omProduto, dwEst, dthrInicio, dthrFim);
		return retorno;
	}

	public List<DwEstmov> getDwEstmovPeriodo(DwEst dwEst, Date dthrInicio, Date dthrFim){
		DwEstmovDAO dwEstmovDAO = new DwEstmovDAO(getDaoSession());
		List<DwEstmov> retorno = dwEstmovDAO.getDwEstmovPeriodo(dwEst, dthrInicio, dthrFim);
		return retorno;
	}
	
	public EstoqueDTO ativaEstoqueDTO(EstoqueDTO itemDTO){
		DwEstDAO dwEstmovDAO = new DwEstDAO(getDaoSession());
		EstoqueDTO filtro = new EstoqueDTO();
		filtro.setEstoque(new DwEst());
		filtro.getEstoque().setCdEst(itemDTO.getEstoque().getCdEst());
		filtro.getEstoque().setRevisao(itemDTO.getEstoque().getRevisao());
		List<DwEst> lista = dwEstmovDAO.getEstoquesDTO(filtro);
		
		EstoqueDTO itemRetorno = new EstoqueDTO();

		if (lista.size() > 0){
			itemRetorno.setResultadoEvento(itemRetorno.getERRO_REATIVACAO_INDISPONIVEL());
			return itemRetorno;
		}
		
		EstoqueDTO filtroId = new EstoqueDTO();
		filtroId.setEstoque(new DwEst());
		filtroId.getEstoque().setIdEst(itemDTO.getEstoque().getIdEst());
		List<DwEst> listaDwEst= dwEstmovDAO.getEstoquesDTO(filtroId);
		
		DwEst itemOriginal = null;
		
		try {
			itemOriginal = listaDwEst.get(0);
		} catch (Exception e) {}
		
		if (itemOriginal == null){			
			itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDESTOQUE_INVALIDO());
			itemRetorno.setEstoque(itemDTO.getEstoque());
			return itemRetorno;
		}else if (itemOriginal.getStAtivo()==1){			
			itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDESTOQUE_INVALIDO());
			itemRetorno.setEstoque((DwEst)itemOriginal.clone());				
		}else{
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());			
		}					

		try{
			itemOriginal = (DwEst) getDao().makePersistent(itemOriginal);			
		} catch (Exception e){
			e.printStackTrace();
		}				

		itemRetorno.setEstoque((DwEst)itemOriginal.clone());
		
		return itemRetorno;
	}

	public void setEstoqueReserva(IdwLogger log, int idLog, int identacao, OmProduto omproduto, double qtReserva){
		
		DwEstpro dwestpro = new DwEstpro();
		dwestpro.setOmProduto(omproduto);
		dwestpro = pesquisarDwEstproByIdProduto(dwestpro);
		
		if (dwestpro != null){
			if (dwestpro.getQtReservada() != null)
				qtReserva += dwestpro.getQtReservada().doubleValue();
			
			log.info(idLog, identacao, "Atualizando estoque em " + qtReserva + " para o produto " + omproduto.getCdProduto());
			dwestpro.setQtReservada(new BigDecimal(qtReserva));

			if (omproduto.getCdProduto().equals("YEP0PT9C00G0-IA"))
				log.info(idLog, identacao, "Salvando reservada para " + omproduto.getCdProduto() + " é " + dwestpro.getQtReservada().doubleValue());

			getDao().makePersistent(dwestpro);
		} else {
			log.info(idLog, identacao, "N�o encontrou dwestpro para atualiza estoque em " + qtReserva + " para o produto " + omproduto.getCdProduto());
		}
	}
	public boolean isExisteProducaoNoMesCorrente(OmProduto omproduto){
		DwConsolidDAO consolidDAO = new DwConsolidDAO(getDaoSession());
		DwConsolid consolid = consolidDAO.getProducaoNoMesCorrente(omproduto);
		boolean isExiste = false;
		if(consolid != null){
			isExiste = true;
		}
		return isExiste;
	}
	
	public double getEstoqueAtualConsiderandoApenasOsPais(IdwLogger log, int idLog, int identacao, OmProduto omproduto){
		
		// PRIMEIRAMENTE VERIFICA SE O PRODUTO JÃ� POSSUI NO CAMPO QT_RESERVADA ALGUM VALOR. SE POSSUI Ã‰ PORQUE SEU ESTOQUE JA FOI ENCONTRADO ANTERIORMENTE,
		// ENTÃƒO DEVE-SE RETORNAR QT_RESERVADA COMO VALOR DE ESTOQUE
		DwEstpro dwestpro = new DwEstpro();
		dwestpro.setOmProduto(omproduto);
		dwestpro = pesquisarDwEstproByIdProduto(dwestpro);
		
		double retorno = 0d;
		log.info(idLog, identacao, "Obtendo a lista de todos os produtos que devem ser considerados para obtencao do estoque atual do produto " + omproduto.getCdProduto());
		List<OmProduto> listaProdutos = new ArrayList<OmProduto>();
		
		OmProcomestDAO omProcomestDAO = new OmProcomestDAO(getDaoSession());
		List<OmProcomest> listaProcomest;
		listaProcomest = omProcomestDAO.getOmProcomestPorProduto(omproduto);;
		
		for (OmProcomest p : listaProcomest){
			log.info(idLog, identacao, "Adicionando o produto " + p.getOmProdutoByIdProduto().getCdProduto() + " para encontrar estoque.");
			listaProdutos.add(p.getOmProdutoByIdProduto());
		}

		for (OmProduto pro : listaProdutos){
			DwEstpro dwestproPar = new DwEstpro();
			dwestproPar.setOmProduto(pro);
			dwestproPar = pesquisarDwEstproByIdProduto(dwestproPar);
			
			double saldo = 0d;
			if (dwestproPar != null){
				if (dwestproPar.getQtEntrada() != null)
					saldo += dwestproPar.getQtEntrada().doubleValue();
				
				if (dwestproPar.getQtSaida() != null)
					saldo -= dwestproPar.getQtSaida().doubleValue();
				
				if (dwestproPar.getQtAjuste() != null)
					saldo += dwestproPar.getQtAjuste().doubleValue();
			}
			log.info(idLog, identacao, "Estoque para " + pro.getCdProduto() + " ï¿½ " + saldo);

			retorno += saldo;
			
		}
		if (dwestpro != null && dwestpro.getQtReservada() != null){
			log.info(idLog, identacao, "O produto " + omproduto.getCdProduto() + " jï¿½ teve seu estoque encontrado anteriormente. Retornando qt_reservado = " + dwestpro.getQtReservada());
			retorno -= dwestpro.getQtReservada().doubleValue();

			log.info(idLog, identacao + 5, "Qt reservada do " + omproduto.getCdProduto() + " ï¿½ " + dwestpro.getQtReservada().doubleValue());
			
			if (retorno < 0)
				retorno = 0;
		}

		return retorno;
	}

	public double getEstoqueAtualNAOConsiderandoEstruturaProduto(IdwLogger log, int idLog, int identacao, OmProduto omproduto){
		double retorno = 0d;
		
		// PRIMEIRAMENTE VERIFICA SE O PRODUTO JA POSSUI NO CAMPO QT_RESERVADA ALGUM VALOR. SE POSSUIR É PORQUE SEU ESTOQUE JA FOI ENCONTRADO ANTERIORMENTE,
		// ENTÃƒO DEVE-SE RETORNAR QT_RESERVADA COMO VALOR DE ESTOQUE
		DwEstpro dwestpro = new DwEstpro();
		dwestpro.setOmProduto(omproduto);
		dwestpro = pesquisarDwEstproByIdProduto(dwestpro);
		
		if (dwestpro != null && dwestpro.getQtAjuste() != null){
			retorno = dwestpro.getQtAjuste().doubleValue();
			if (dwestpro.getQtReservada() != null){
				retorno -= dwestpro.getQtReservada().doubleValue();
				if (retorno < 0)
					retorno = 0;
			}
		}
		return retorno;
	}

	public DwEstsalma pesquisarDwEstsalmaById(DwEstsalma dwestsalmaPar){
		DwEstsalmaDAO dwEstsalmaDAO = new DwEstsalmaDAO(getDaoSession());
		DwEstsalma dwestsalma = dwEstsalmaDAO.getDwEstsalmaPorId(dwestsalmaPar.getIdEstsalma());
		return dwestsalma;
	}
	
	public DwEstpro getDwEstpro(OmProduto omProduto, DwEst dwEst) {
		DwEstproDAO dwEstproDAO = new DwEstproDAO(getDaoSession());
		return (DwEstpro) dwEstproDAO.getDwEstproUnique(omProduto, dwEst);
	}

	public List<DwEstpro> getDwEstpros(OmProduto omProduto, DwEst dwEst){
		DwEstproDAO dwEstproDAO = new DwEstproDAO(getDaoSession());
		List<DwEstpro> lista = dwEstproDAO.getDwEstproList(omProduto, dwEst);
		return lista;	
	}
	
	public BigDecimal getTotalFromOmProdutoWithDwEst(OmProduto omProduto, DwEst dwEst){
		List<DwEstpro> listDewEstpro = getDwEstpros(omProduto, dwEst);		
		return getTotalFromDwEstProsWithDwEst(listDewEstpro, dwEst);
	}
	
	public List<DwEstpro> getEstoquesProdutos(Collection<OmProduto> listProdutos){
		DwEstproDAO dwEstproDAO = new DwEstproDAO(getDaoSession());
		List<DwEstpro> retorno = dwEstproDAO.getEstoquesProdutos(listProdutos);
		return retorno;
	}

	public Map<String, Set<DwEstpro>> getEstoquesProdutos(Collection<OmProduto> listProdutos, DwEst dwEst){
		OmProdutoDAO omProdutoDAO = new OmProdutoDAO(getDaoSession());
		Map<String, Set<DwEstpro>> mapProdutoEstoques = new HashMap<String, Set<DwEstpro>>();
		mapProdutoEstoques = omProdutoDAO.getEstoquesProdutos(listProdutos, dwEst);
		return mapProdutoEstoques;	
	}
	
	public static DwEstpro getDwEstproFromMapProdutoEstoquesWithProdutoAndDwEst(Map<String, Set<DwEstpro>> mapProdutoEstoques, String cdProduto, DwEst dwEst){
		Set<DwEstpro> setDwEstpro = mapProdutoEstoques.get(cdProduto);
		if(setDwEstpro != null){
			return getDwEstproFromCollectionDwEstpro(setDwEstpro, dwEst);
		}
		return null;		
	}
	
	public static BigDecimal getTotalFromMapProdutoEstoquesWithProdutoAndDwEst(Map<String, Set<DwEstpro>> mapProdutoEstoques, String cdProduto, DwEst dwEst){
		Set<DwEstpro> setDwEstpro = mapProdutoEstoques.get(cdProduto);
		return getTotalFromDwEstProsWithDwEst(setDwEstpro, dwEst);	
	}
	
	public static BigDecimal getTotalFromDwEstProsWithDwEst(Collection<DwEstpro> dwEstPros, DwEst dwEst){
		BigDecimal total = BigDecimal.ZERO;
		if(dwEstPros != null){
			for(DwEstpro dwEstpro: dwEstPros){
				if(dwEstpro.getDwEst().getIdEst() == dwEst.getIdEst()){
					total = AritmeticaUtil.somar(total, dwEstpro.getQtTotal());
				}
			}
		}
		return total;
	}
	
	public static DwEstpro getDwEstproFromCollectionDwEstpro(Collection<DwEstpro> collectionDwEstpro, DwEst dwEst){
		for(DwEstpro dwEstpro: collectionDwEstpro){
			if(dwEstpro.getDwEst().getIdEst() == dwEst.getIdEst()){
				return dwEstpro;
			}
		}
		return null;
	}
	
	public List<DwEstpro> getEstoqueProdutos(Collection<OmProduto> listProdutos, DwEst dwEst){
		DwEstproDAO dwEstproDAO = new DwEstproDAO(getDaoSession());
		List<DwEstpro> retorno = dwEstproDAO.getEstoqueProdutos(listProdutos, dwEst);
		return retorno;
	}
	
	public void apagarMovimentacaoEstoque(DwEstpro dwEstpro, DwEstMovTemplate.TpMov tpMov) {
		DwEstmovDAO dwEstmovDAO = new DwEstmovDAO(getDaoSession());
		dwEstmovDAO.apagarMovimentacaoEstoque(dwEstpro, tpMov);
	}
	
	public void apagarMovimentacaoEstoque(DwEst dwEst) {
		DwEstmovDAO dwEstmovDAO = new DwEstmovDAO(getDaoSession());
		dwEstmovDAO.apagarMovimentacaoEstoque(dwEst);
	}
	
	public void apagarTodosEstoqueProduto() {
		DwEstproDAO dwEstproDAO = new DwEstproDAO(getDaoSession());
		dwEstproDAO.apagarTodosEstoqueProduto();		
	}
	
	public void apagarEstoqueProdutos(DwEst dwEst){
		DwEstproDAO dwEstproDAO = new DwEstproDAO(getDaoSession());
		dwEstproDAO.apagarEstoqueProdutos(dwEst);	
	}
	
	public void zerarEstoqueProdutos(DwEst dwEst){
		DwEstproDAO dwEstproDAO = new DwEstproDAO(getDaoSession());
		dwEstproDAO.zerarEstoqueProdutos(dwEst);
	}
	
	public BigDecimal getEstoqueLiberacaoTotalProduto(OmProduto omProduto){
		OmCfg omcfg = Util.getConfigGeral(this.getDaoSession());
		DwEst dwEstLiberacao = omcfg.getDwEstByIdEstliberado();
		
		//return getEstoqueTotalProduto(omProduto, dwEstLiberacao);
		return getTotalFromOmProdutoWithDwEst(omProduto, dwEstLiberacao);
	}

	public BigDecimal getEstoqueProducaoTotalProduto(OmProduto omProduto) throws SemConfiguracaoException{
		OmCfg omcfg = Util.getConfigGeral(this.getDaoSession());
		
		if (omcfg == null) {
			throw new SemConfiguracaoException();
		}
		
		DwEst dwEstProducao = omcfg.getDwEstByIdEstproducao();
		
		return getTotalFromOmProdutoWithDwEst(omProduto, dwEstProducao); 
		//getEstoqueTotalProduto(omProduto, dwEstProducao);
		
	}
	
	public BigDecimal getEstoqueTotalProduto(OmProduto omProduto, DwEst dwEst){
		
		BigDecimal qtTotal = BigDecimal.ZERO;
		
		if(dwEst != null){
			DwEstpro dwEstpro = getDwEstpro(omProduto, dwEst);
			if(dwEstpro != null && dwEstpro.getQtTotal() != null){
				qtTotal = dwEstpro.getQtTotal();
			}
		}
		
		return qtTotal;
		
	}
	
	public DwEstpro getDwEstproSenaoExistirCriar(OmProduto omProduto, DwEst dwEst){
		return getDwEstproSenaoExistirCriar(omProduto, dwEst, BigDecimal.ZERO);
	}
	
	public DwEstpro getDwEstproSenaoExistirCriar(OmProduto omProduto, DwEst dwEst, BigDecimal qtAjuste){
		DwEstpro dwEstpro = getDwEstpro(omProduto, dwEst);
		if(dwEstpro == null){
			dwEstpro = salvarEstoqueProduto(omProduto, dwEst, qtAjuste);			
		}
		return dwEstpro;		
	}
		

	public DwEstpro salvarEstoqueProduto(OmProduto omProduto, DwEst dwEst, BigDecimal qtAjuste){		
		DwEstpro dwEstpro = DwEstProTemplate.newDwEstpro(dwEst, omProduto, qtAjuste);
		return getDao().makePersistent(dwEstpro);			
	}
	
	public DwEstpro salvarEstoqueProduto(OmProduto omProduto, DwEst dwEst){		
		return salvarEstoqueProduto(omProduto, dwEst, BigDecimal.ZERO);		
	}
	
	public void setEstoqueProducaoTotalProduto(OmProduto omProduto, BigDecimal qtTotal, OmUsr omUsr, boolean gerarMovimentacao, Date dthrAtual, DwEstMovTemplate.TpOrigem tpOrigem) throws SemConfiguracaoException{
		OmCfg omcfg = Util.getConfigGeral(this.getDaoSession());
		if (omcfg == null) {
			throw new SemConfiguracaoException();
		}
		DwEst dwEstProducao = omcfg.getDwEstByIdEstproducao();
		setEstoqueTotalProduto(omProduto, dwEstProducao, qtTotal, omUsr, gerarMovimentacao, dthrAtual, tpOrigem);
	}
	
	public void setEstoqueTotalProduto(OmProduto omProduto, DwEst dwEst, BigDecimal qtTotal, OmUsr omUsr, boolean gerarMovimentacao, Date dthrAtual, DwEstMovTemplate.TpOrigem tpOrigem){
		if(dwEst != null && qtTotal != null){
//			DwEstpro dwEstpro = getDwEstproSenaoExistirCriar(omProduto, dwEst);
			DwEstpro dwEstpro = getDwEstproValidoApagandoDwEstprosQueRepeteParaMesmoDwEstEOmProduto(dwEst, omProduto);
			if(dwEstpro == null){
				dwEstpro = salvarEstoqueProduto(omProduto, dwEst);
			}
			if( dwEstpro.getQtTotal() == null || (qtTotal.longValue() != dwEstpro.getQtTotal().longValue())){
				BigDecimal qtTotalAtual = calcularTotalEstoque(dwEstpro.getQtAjuste(), dwEstpro.getQtEntrada(), dwEstpro.getQtSaida());
				BigDecimal qtDiff = qtTotal.subtract(qtTotalAtual);
				atualizarEstoqueProduto(dwEstpro, null, qtDiff, null, null, dthrAtual, omUsr, gerarMovimentacao, tpOrigem);
			}
		}
	}	
	
	private DwEstpro getDwEstproValidoApagandoDwEstprosQueRepeteParaMesmoDwEstEOmProduto(DwEst dwEst, OmProduto omProduto){
		List<DwEstpro> listaDwEstpro = getDwEstpros(omProduto, dwEst);
		DwEstpro dwEstproValido = null;
		for(DwEstpro dwEstpro: listaDwEstpro){
			if(dwEstproValido == null){
				dwEstproValido = dwEstpro;
			}else{
				apagarMovimentacaoEstoque(dwEstpro, null);
				getDao().delete(dwEstpro);
			}			
		}
		return dwEstproValido;
	}
	
	public static BigDecimal calcularTotalEstoque(BigDecimal qtAjuste,
			BigDecimal qtEntrada, BigDecimal qtSaida) {
		qtAjuste = ObjectUtils.defaultIfNull(qtAjuste, BigDecimal.ZERO);
		qtEntrada = ObjectUtils.defaultIfNull(qtEntrada, BigDecimal.ZERO);
		qtSaida = ObjectUtils.defaultIfNull(qtSaida, BigDecimal.ZERO);
		return qtEntrada.subtract(qtSaida).add(qtAjuste);
	}
	
	private OmProduto getProdutoParaEstocarProducao(OmCfg omCfg, PpCp ppCp){
		OmProduto omProduto = null;
		if(ppCp.getPpCpprodutos().isEmpty() == false){
			omProduto = ppCp.getPpCpprodutos().iterator().next().getOmProduto();
			OmProduto omProdutoDefault = omCfg.getOmProduto();
			if(omProdutoDefault != null){
				if(omProdutoDefault.getCdProduto().equals(omProduto.getCdProduto())){
					ProdutoRN produtoRN = new ProdutoRN(getDao());
					OmProduto omProdutoDoCdCp = produtoRN.getProdutoByCdEStAtivo(ppCp.getCdCp());
					if(omProdutoDoCdCp != null){
						omProduto = omProdutoDoCdCp;
					}
				}
			}	
		}
		return omProduto;
	}
	
	/*
	 * Esse metodo fara o lancamento no estoque da produ��o contabilizada no final do ciclo
	 */
	public void addEstoqueProducaoNoCiclo(OmCfg omCfg, OmPt omPt, PpCp ppCp, DwFolha dwFolha, Date dtHrFimCiclo){
		if(omPt.getIsApongt() != null && omPt.getIsApongt()){
			ConsolidaRN consolidaRN = new ConsolidaRN(this.getDao());
			BigDecimal cavAtiva =  consolidaRN.getCavAtivas(dwFolha);
			OmProduto omProduto = getProdutoParaEstocarProducao(omCfg, ppCp);
			if(omProduto != null){			
				DwEst dwEstProducao = omCfg.getDwEstByIdEstproducao();
				
				/* Verificar se existe um roteiro de produ��o para o produto. Se existir verificar se o estoque foi definido, se sim usar
				 * como referencia.
				 */
				RoteiroRN rn = new RoteiroRN(getDao());
				List<DwRotapasso> passos = rn.pesquisarDwRotapassoComCdProdutoNoPasso(omProduto.getCdProduto());
				
				// se encontrou a rota, pegar o estoque no último passo com estoque definido
				if (passos != null) {
					for (DwRotapasso passo : passos) {
						if (passo.getDwEst() != null) {
							dwEstProducao = passo.getDwEst();
						}
					}
				}
				addEstoqueProduto(omProduto, dwEstProducao, null, cavAtiva, null, dtHrFimCiclo, null, false, TpOrigem.APONTAMENTO_AUTO);
			}
		}
	}

	/* Metodo para consumir o estoque de materia-prima conforme o roteiro
	 * 
	 */
	public void subEstoqueProducaoNoCiclo(OmCfg omCfg, OmPt omPt, PpCp ppCp, DwFolha dwFolha, Date dtHrFimCiclo){
		if(omPt.getIsApongt() != null && omPt.getIsApongt()){
			FolhaRN frn = new FolhaRN(getDao());
			
			OmProduto omProduto = getProdutoParaEstocarProducao(omCfg, ppCp);
			
			if (omProduto != null) {
				/* Verificar se existe um roteiro de produ��o para o produto. Se existir verificar se o estoque foi definido, se sim usar
				 * como referencia.
				 */
				RoteiroRN rn = new RoteiroRN(getDao());
				List<DwRotapasso> passos = rn.pesquisarDwRotapassoComCdProdutoNoPasso(omProduto.getCdProduto());
				// se encontrou a rota, pegar o passo para verificar se existe um estoque definido
				if (passos != null) {
					for (DwRotapasso passo : passos) {
						// Pegar os estoques das predecessoras e consumir os
						// produtos semiacabados das predecessoras desses estoques
						for (DwRpPredecessora pre : passo.getDwRpPredecessorasForIdRotapassoPai()) {
							DwEst dwEstMP = null;
							BigDecimal cavAtiva = BigDecimal.ONE;
							DwRotapasso predecessora = pre.getDwRotapassoByIdRotapassoFilho();
							List<OmProduto> listaprodutos = frn.getProdutosFromDwFolha(predecessora.getDwFolha());
							dwEstMP = predecessora.getDwEst();
	
							for (OmProduto folhapre : listaprodutos) {
								
								for (OmProcomest procomest : omProduto.getOmProcomestsForIdProduto()) {
									OmProduto filho = procomest.getOmProdutoByIdProdutomp();
									if (filho.getCdProduto().equals(folhapre.getCdProduto())) {
										cavAtiva = procomest.getQtUsada();
										if (cavAtiva == null)
											cavAtiva = BigDecimal.ONE;
										// se houver um estoque definido
										if (dwEstMP != null) {
											addEstoqueProduto(filho, dwEstMP, null, null, cavAtiva, dtHrFimCiclo, null, false, TpOrigem.APONTAMENTO_AUTO);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	
	/*
	 * Esse metodo fara olancamento de entrada no estoque requerido
	 */
	public DwEstpro addEstoqueProduto(OmProduto omProduto, DwEst dwEst, BigDecimal qtAjuste, BigDecimal qtEntrada, BigDecimal qtSaida, Date dthrMov, OmUsr omUsr, boolean gerarMovimentacao, DwEstMovTemplate.TpOrigem tpOrigem){
		if(dwEst != null){
			/* Pesquisar o local do estoque e o dwestlocalpro para contabilizar neles a producao tambem
			 * a fim de permitir  a consulta no local estoque
			 */
			DwEstpro dwEstpro = getDwEstproSenaoExistirCriar(omProduto, dwEst);
			
			DwEstlocalpro dwestlocalpro = getDwEstlocalproPrimeiroLocalDoEstoque(dwEstpro);
			
			return atualizarEstoqueProduto(dwEstpro, dwestlocalpro, qtAjuste, qtEntrada, qtSaida, dthrMov, omUsr, gerarMovimentacao, tpOrigem);
		}
		return null;
	}
	
	/**
	 * Assumir o 1o local encontrado para o estoque a fim de permitir que aparece na Consulta local estoque
	 */
	private DwEstlocalpro getDwEstlocalproPrimeiroLocalDoEstoque(DwEstpro dwEstpro) {
		DwEstlocal dwEstlocal = null;
		DwEstlocalpro dwestlocalpro = null;

		DwEstlocalDAO dwEstlocalDAO = new DwEstlocalDAO(getDaoSession());
		dwEstlocal = dwEstlocalDAO.getDwEstLocalPrimeiroDoEstoque(dwEstpro.getDwEst());
		if(dwEstlocal != null) {
			DwEstlocalproDAO dwEstlocalproDAO = new DwEstlocalproDAO(getDaoSession());
			dwestlocalpro = dwEstlocalproDAO.getDwEstlocalproSenaoExistirCriar(dwEstlocal, dwEstpro, null);
		}
		return dwestlocalpro;
	}

	public DwEstpro addEstoqueProdutoTrataSeTotalFicarMenorZero(DwEstpro dwEstpro, BigDecimal qtAjuste, BigDecimal qtEntrada, BigDecimal qtSaida, Date dthrMov, OmUsr omUsr, boolean gerarMovimentacao, DwEstMovTemplate.TpOrigem tpOrigem){
		DwEstlocalpro dwestlocalpro = getDwEstlocalproPrimeiroLocalDoEstoque(dwEstpro);
		
		atualizarEstoqueProduto(dwEstpro, dwestlocalpro, qtAjuste, qtEntrada, qtSaida, dthrMov, omUsr, gerarMovimentacao, tpOrigem);
		
		//TOTAL SEMPRE DEVE FICAR >= 0
		if(dwEstpro.getQtTotal().compareTo(BigDecimal.ZERO) < 0 ){
			// AJUSTA PARA O TOTAL FICAR ZERADO
			atualizarEstoqueProduto(dwEstpro, dwestlocalpro, dwEstpro.getQtTotal().negate(), null, null, dthrMov, omUsr, gerarMovimentacao, DwEstMovTemplate.TpOrigem.AJUSTE_AUTO);
		}
		return dwEstpro;
	}	

	/* Alessandre em 16-08-17 ningem chama o metodo
	public DwEstpro atualizarApenasLocalEstoqueProduto(DwEstpro dwEstpro, DwEstlocalpro dwEstlocalpro, BigDecimal qtAjuste, BigDecimal qtEntrada, BigDecimal qtSaida, Date dthrMov, OmUsr omUsr, boolean gerarMovimentacao, DwEstMovTemplate.TpOrigem tpOrigem){

		BigDecimal qtTotalLancamento = BigDecimal.ZERO;
		qtTotalLancamento = calcularTotalEstoque(qtAjuste, qtEntrada, qtSaida);
		
		if(gerarMovimentacao){
			Date dthrAtual = DataHoraRN.getDataHoraAtual();
			DwEstmov dwEstmov = DwEstMovTemplate.newDwEstMovAjuste(dthrAtual, dthrMov, dwEstpro, dwEstlocalpro, omUsr, qtTotalLancamento, qtAjuste, qtEntrada, qtSaida, tpOrigem);			
			getDao().makePersistent(dwEstmov);
		}
						
//		dwEstpro.setQtAjuste(AritmeticaUtil.somar(qtAjuste, dwEstpro.getQtAjuste()));
//		dwEstpro.setQtEntrada(AritmeticaUtil.somar(qtEntrada, dwEstpro.getQtEntrada()));
//		dwEstpro.setQtSaida(AritmeticaUtil.somar(qtSaida, dwEstpro.getQtSaida()));		
//		dwEstpro.setQtTotal(calcularTotalEstoque(dwEstpro.getQtAjuste(), dwEstpro.getQtEntrada(), dwEstpro.getQtSaida()));
		
		if(dwEstlocalpro != null){
			dwEstlocalpro.setQtAjuste(AritmeticaUtil.somar(qtAjuste, dwEstlocalpro.getQtAjuste()));
			dwEstlocalpro.setQtEntrada(AritmeticaUtil.somar(qtEntrada, dwEstlocalpro.getQtEntrada()));
			dwEstlocalpro.setQtSaida(AritmeticaUtil.somar(qtSaida, dwEstlocalpro.getQtSaida()));		
			dwEstlocalpro.setQtTotal(calcularTotalEstoque(dwEstlocalpro.getQtAjuste(), dwEstlocalpro.getQtEntrada(), dwEstlocalpro.getQtSaida()));			
		}
		
//		if(qtEntrada != null){
//			dwEstpro.setDthrEntrada(ObjectUtils.max(dthrMov,dwEstpro.getDthrEntrada()));
//		}
//		if(qtSaida != null){
//			dwEstpro.setDthrSaida(ObjectUtils.max(dthrMov,dwEstpro.getDthrSaida()));
//		}
//		if(qtAjuste != null){
//			dwEstpro.setDthrAjuste(ObjectUtils.max(dthrMov,dwEstpro.getDthrAjuste()));
//		}			
//		
//		dwEstpro.setDthrTotal(ObjectUtils.max(dwEstpro.getDthrAjuste(), dwEstpro.getDthrEntrada(), dwEstpro.getDthrSaida()));
		getDao().makePersistent(dwEstpro);
		
		return dwEstpro;
	}*/	
	
	public DwEstpro atualizarEstoqueProduto(DwEstpro dwEstpro, DwEstlocalpro dwEstlocalpro, BigDecimal qtAjuste, BigDecimal qtEntrada, BigDecimal qtSaida, Date dthrMov, OmUsr omUsr, boolean gerarMovimentacao, DwEstMovTemplate.TpOrigem tpOrigem){

		BigDecimal qtTotalLancamento = BigDecimal.ZERO;
		qtTotalLancamento = calcularTotalEstoque(qtAjuste, qtEntrada, qtSaida);
		
		// gerarMovimentacao sera false quando o apontamento do estoque vier pelo apontamento de producao, se fosse gerar uma moviemntacao
		// rapidamente o banco poderia estourar
		if(gerarMovimentacao){
			Date dthrAtual = DataHoraRN.getDataHoraAtual();
			DwEstmov dwEstmov = DwEstMovTemplate.newDwEstMovAjuste(dthrAtual, dthrMov, dwEstpro, dwEstlocalpro, omUsr, qtTotalLancamento, qtAjuste, qtEntrada, qtSaida, tpOrigem);			
			getDao().makePersistent(dwEstmov);
		}
						
		dwEstpro.setQtAjuste(AritmeticaUtil.somar(qtAjuste, dwEstpro.getQtAjuste()));
		dwEstpro.setQtEntrada(AritmeticaUtil.somar(qtEntrada, dwEstpro.getQtEntrada()));
		dwEstpro.setQtSaida(AritmeticaUtil.somar(qtSaida, dwEstpro.getQtSaida()));		
		dwEstpro.setQtTotal(calcularTotalEstoque(dwEstpro.getQtAjuste(), dwEstpro.getQtEntrada(), dwEstpro.getQtSaida()));
		
		if(dwEstlocalpro != null){
			dwEstlocalpro.setQtAjuste(AritmeticaUtil.somar(qtAjuste, dwEstlocalpro.getQtAjuste()));
			dwEstlocalpro.setQtEntrada(AritmeticaUtil.somar(qtEntrada, dwEstlocalpro.getQtEntrada()));
			dwEstlocalpro.setQtSaida(AritmeticaUtil.somar(qtSaida, dwEstlocalpro.getQtSaida()));
			dwEstlocalpro.setQtTotal(calcularTotalEstoque(dwEstlocalpro.getQtAjuste(), dwEstlocalpro.getQtEntrada(), dwEstlocalpro.getQtSaida()));
		}
		
		if(qtEntrada != null){
			dwEstpro.setDthrEntrada(DataHoraRN.getMaiorData(dthrMov,dwEstpro.getDthrEntrada()));
		}
		if(qtSaida != null){
			dwEstpro.setDthrSaida(DataHoraRN.getMaiorData(dthrMov,dwEstpro.getDthrSaida()));
		}
		if(qtAjuste != null){
			dwEstpro.setDthrAjuste(DataHoraRN.getMaiorData(dthrMov,dwEstpro.getDthrAjuste()));
		}			
		
		dwEstpro.setDthrTotal(DataHoraRN.getMaiorData(dwEstpro.getDthrAjuste(), dwEstpro.getDthrEntrada(), dwEstpro.getDthrSaida()));
		getDao().makePersistent(dwEstpro);
		
		return dwEstpro;
	}	

	
	public DwEstlocalprosDTO getDwEstlocalpros(FiltroConsolLocalEstoqueDTO filtro){
		
		DwEstlocalprosDTO retorno = new DwEstlocalprosDTO();
		retorno.setDwEstlocalproDTOs(new ArrayList<DwEstlocalproDTO>());
		DwEstlocalproDAO dao = new DwEstlocalproDAO(getDaoSession());
		List<DwEstlocalpro> listaPesquisa = dao.getDwEstlocalpros(filtro, true);
		
		for(DwEstlocalpro itemLista : listaPesquisa){

			OmProduto omProduto = new OmProduto();
			omProduto.setCdProduto(itemLista.getDwEstpro().getOmProduto().getCdProduto());
			
			DwEstlocal dwEstlocal = null;
			if(itemLista.getDwEstlocal() != null) {
				dwEstlocal = new DwEstlocal();
				OmPt omPt = null;
				if(itemLista.getDwEstlocal().getOmPt() != null) {
					 omPt = new OmPt();
					omPt.setCdPt(itemLista.getDwEstlocal().getOmPt().getCdPt());
				}
				
				OmPa omPa = null;
				if(itemLista.getDwEstlocal().getOmPa() != null) {
					omPa = new OmPa();
					omPa.setCdPa(itemLista.getDwEstlocal().getOmPa().getCdPa());
				}
				
				dwEstlocal.setCdLocal(itemLista.getDwEstlocal().getCdLocal());
				dwEstlocal.setDsLocal(itemLista.getDwEstlocal().getDsLocal());
				dwEstlocal.setOmPt(omPt);
				dwEstlocal.setOmPa(omPa);
			}
			
			DwEstpro dwEstpro = new DwEstpro();
			dwEstpro.setOmProduto(omProduto);
			
			DwEstlocalpro dwEstlocalpro = new DwEstlocalpro();
			dwEstlocalpro.setQtTotal(itemLista.getQtTotal());
			dwEstlocalpro.setDwEstlocal(dwEstlocal);
			dwEstlocalpro.setDwEstpro(dwEstpro);
			
			DwEstlocalproDTO dto = new DwEstlocalproDTO();
			dto.setDwEstlocalpro(dwEstlocalpro);
			retorno.getDwEstlocalproDTOs().add(dto);
		}
		
		return retorno;
	}
	
	public DwEst pesquisarDwEstEStAtivoByCd(String cdestoque) {
		DwEstDAO dwEstDAO = new DwEstDAO(getDaoSession());
		DwEst dwEst = dwEstDAO.getDwEstPorCdAtivo(cdestoque);
		return dwEst;
	}
	
	public DwEstlocalprosDTO getDwEstlocalpros(FiltroMonitorizacaoLocalEstoque filtro) {
		
		DwEstlocalprosDTO retorno = new DwEstlocalprosDTO();
		retorno.setDwEstlocalproDTOs(new ArrayList<DwEstlocalproDTO>());
		DwEstlocalproDAO dao = new DwEstlocalproDAO(getDaoSession());
		List<DwEstlocalpro> listaPesquisa = dao.getDwEstlocalpros(filtro);
		
		for(DwEstlocalpro estlocalpro : listaPesquisa){
			if(CompareUtils.compareTo(estlocalpro.getQtTotal(), BigDecimal.ZERO) != 0){
				DwEstlocalproDTO dto = new DwEstlocalproDTO();
				dto.setDwEstlocalpro(estlocalpro.clone());
				retorno.getDwEstlocalproDTOs().add(dto);
			}
		}
		
		return retorno;
	}

	
	public DwconsolestlocalprosDTO getConsultaLocalEstoque(FiltroConsolLocalEstoqueDTO filtro){
		DwconsolestlocalprosDTO retorno = new DwconsolestlocalprosDTO();
		retorno.setConsolestlocalpros(new ArrayList<DwConsolestlocalpro>());
		DwConsolestlocalproDAO dao = new DwConsolestlocalproDAO(getDaoSession());
		List<DwConsolestlocalpro> lista = dao.getConsolLocalEstoques(filtro);
		for(DwConsolestlocalpro o : lista){
			DwConsolestlocalpro clone = o.clone(false);
			
			DwTurno dwTurno = o.getDwTurno();
			clone.setDwTurno(new DwTurno());
			clone.getDwTurno().setCdTurno(dwTurno.getCdTurno());
			clone.getDwTurno().setDsTurno(dwTurno.getDsTurno());
			
			clone.setDwEstlocalpro(o.getDwEstlocalpro().clone(false));
			clone.getDwEstlocalpro().setDwEstlocal(new DwEstlocal());
			
			DwEstlocal dwEstlocal = o.getDwEstlocalpro().getDwEstlocal();
			
			clone.getDwEstlocalpro().getDwEstlocal().setCdLocal(dwEstlocal.getCdLocal());
			
			OmPt omPt = dwEstlocal.getOmPt();
			if(omPt != null){
				clone.getDwEstlocalpro().getDwEstlocal().setOmPt(new OmPt());
				clone.getDwEstlocalpro().getDwEstlocal().getOmPt().setCdPt(omPt.getCdPt());					
			}
			
			OmGt omGt = dwEstlocal.getOmGt();
			if(omGt != null){
				clone.getDwEstlocalpro().getDwEstlocal().setOmGt(new OmGt());
				clone.getDwEstlocalpro().getDwEstlocal().getOmGt().setCdGt(omGt.getCdGt());					
			}

			OmPa omPa = dwEstlocal.getOmPa();
			if(omPa != null){
				clone.getDwEstlocalpro().getDwEstlocal().setOmPa(new OmPa());
				clone.getDwEstlocalpro().getDwEstlocal().getOmPa().setCdPa(omPa.getCdPa());
			}
			
			OmProduto omProduto = o.getDwEstlocalpro().getDwEstpro().getOmProduto();
			clone.getDwEstlocalpro().setDwEstpro(new DwEstpro());
			clone.getDwEstlocalpro().getDwEstpro().setOmProduto(new OmProduto());
			clone.getDwEstlocalpro().getDwEstpro().getOmProduto().setCdProduto(omProduto.getCdProduto());
			
			retorno.getConsolestlocalpros().add(clone);
		}
		return retorno;
	}
	
	
	/* Metodo para registrar a movimentacao da ferramenta entre estoques
	 * 
	 */
	public SucessoDTO movimentarFerramenta(String cdLocalOrigem, String cdLocalDestino, String cdrap, String login) {
		SucessoDTO retorno = new SucessoDTO();
		
		DwEstlocalDAO rnL = new DwEstlocalDAO(getDaoSession());
		DwEstlocal dwestlocalOrigem = rnL.getDwEstlocalPorCdAtivoOrderById(cdLocalOrigem);
		DwEstlocal dwestlocalDestino = rnL.getDwEstlocalPorCdAtivoOrderById(cdLocalDestino);
		
		// Localiza a ferramenta
		DwRapRN rn = new DwRapRN(getDao());
		rn.setCdRap(cdrap);
		DwRap dwrap = rn.pesquisarDwRapByCdRap();

		// Localiza usuario
		UsuarioRN urn = new UsuarioRN(getDao());
		OmUsr omusr = urn.getOmUsrByLoginStAtivo(login);
		

		// Valida os dados
		if (dwestlocalOrigem == null && cdLocalOrigem != null && cdLocalOrigem.trim().equals("") == false) {
			retorno.setStatus("400");
			retorno.setTitle("Local origem desconhecido");
		} else if (dwestlocalDestino == null) {
			retorno.setStatus("400");
			retorno.setTitle("Local destino desconhecido");
		} else if (dwrap == null) {
			retorno.setStatus("400");
			retorno.setTitle("Ferramenta desconhecida");
		} else if (omusr == null) {
			retorno.setStatus("400");
			retorno.setTitle("Usuário desconhecido");
		}
		
		

		// Lanca movimentacao
		DwEstmovRap mov = new DwEstmovRap();
		mov.setIdEstmovrap(null);
		mov.setDthrMovimentacao(DataHoraRN.getDataHoraAtual());
		mov.setDwEstlocalDestino(dwestlocalDestino);
		mov.setDwEstlocalOrigem(dwestlocalOrigem);
		mov.setDwRap(dwrap);
		mov.setOmUsr(omusr);
		
		getDao().makePersistent(mov);
		
		dwestmovrap = mov; // guarda aqui para ser resgatado no metodo que registra a execucao da inspecao da ferramenta
		
		// Altera ferramenta para novo local
		dwrap.setDwEstlocal(dwestlocalDestino);
		getDao().makePersistent(dwrap);
		
		
		retorno.setStatus("200");
		retorno.setTitle("Movimentação realizada com sucesso");
		
		return retorno;
	}

	public DwEstmovRap getDwestmovrap() {
		return dwestmovrap;
	}
	

	public TiposEstoqueDTO pesquisarTiposEstoque(String cdds) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwTpest a");
		q.append("where a.stAtivo = 1");
		q.append("and (a.cdTpest like :cd or a.dsTpest like :ds)");
		q.append("order by a.cdTpest");
		
		q.defineParametro("cd", cdds);
		q.defineParametro("ds", cdds);
		
		List<DwTpest> lista = q.list();
		
		TiposEstoqueDTO retorno = new TiposEstoqueDTO();
		retorno.setTiposEstoque(new ArrayList<TipoEstoqueDTO>());
		for (DwTpest dwtpest : lista) {
			TipoEstoqueDTO dto = new TipoEstoqueDTO();
			dto.setTipoEstoque(dwtpest.clone(false));
			retorno.getTiposEstoque().add(dto);
		}

		return retorno;
	}

	public DwTpest pesquisarTiposEstoqueByCd(String cd) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwTpest a");
		q.append("where a.stAtivo = 1");
		q.append("and a.cdTpest = :cd");
		
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		
		return (DwTpest) q.uniqueResult();
	}

	public EstoquesDTO pesquisarEstoque(String cdds) {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from DwEst a");
		q.append("where a.stAtivo = 1");
		q.append("and (a.cdEst like :cd or a.dsEst like :ds)");
		q.append("order by a.cdEst");
		
		q.defineParametro("cd", cdds);
		q.defineParametro("ds", cdds);
		
		List<DwEst> lista = q.list();
		EstoquesDTO retorno = new EstoquesDTO();
		retorno.setEstoques(new ArrayList<EstoqueDTO>());
		for (DwEst est : lista) {
			EstoqueDTO dto = new EstoqueDTO();
			dto.setEstoque(est.clone(false));
			retorno.getEstoques().add(dto);
		}
		return retorno;
	}
}