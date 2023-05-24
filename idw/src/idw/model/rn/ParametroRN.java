package idw.model.rn;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwFtParamDAO;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwFtParam;
import idw.model.pojos.OmCfg;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.ParametroDTO;
import idw.webservices.dto.ParametrosDTO;


@SuppressWarnings("unchecked")
public class ParametroRN extends DAOGenerico{
	
	public ParametroRN(){
		
	}
	
	public ParametroRN(DAOGenerico dao){
		this.setDao(dao);
	}

	public ParametrosDTO getParametrosDTO(ParametroDTO filtro){

		String hql="";
		hql += "select t ";
		hql += "from DwFtParam t ";		
		hql += "where 1=1 ";

		if (filtro.getParametro().getIdFtParam()!=0){
			hql += "AND t.idFtParam=::idFtParam: ";
		}else{
			if (filtro.getParametro().getDsParametro() != null && !filtro.getParametro().getDsParametro().equals("")){
				hql += "AND t.dsParametro='::dsParametro:' ";
			}			
		}

		hql = hql.replaceAll("::idFtParam:", String.valueOf(filtro.getParametro().getIdFtParam()));		
		hql = hql.replaceAll("::dsParametro:", filtro.getParametro().getDsParametro());
		
		Query q = getSession().createQuery(hql);

		List<DwFtParam> listaParametro = null;
		try{
			listaParametro = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<ParametroDTO> lista = new ArrayList<ParametroDTO>();

		if (listaParametro != null){
			for (DwFtParam dwFtParam : listaParametro) {
				ParametroDTO parametro = new ParametroDTO();								
				parametro.setParametro((DwFtParam)dwFtParam.clone());
				
				parametro.setResultadoEvento(0);
				lista.add(parametro);
			}
		}

		ParametrosDTO parametros = new ParametrosDTO();
		parametros.setParametros(lista);
		return parametros;
	}
	
	
	public ParametrosDTO getParametrosDTOComoListaGeral(){

		String hql="";
		hql += "select t ";
		hql += "from DwFtParam t ";		
		hql += "where 1=1 ";
		
		Query q = getSession().createQuery(hql);

		List<DwFtParam> listaParametro = null;
		try{
			listaParametro = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<ParametroDTO> lista = new ArrayList<ParametroDTO>();

		if (listaParametro != null){
			for (DwFtParam dwFtParam : listaParametro) {
				ParametroDTO parametro = new ParametroDTO();								
				parametro.setParametro((DwFtParam)dwFtParam.clone());
				
				parametro.setResultadoEvento(0);
				lista.add(parametro);
			}
		}

		ParametrosDTO parametros = new ParametrosDTO();
		parametros.setParametros(lista);
		return parametros;
	}
	
	
	public ParametroDTO setParametroDTO(ParametroDTO parametro){
		ParametroDTO parametroRetorno = new ParametroDTO();
		parametroRetorno.setResultadoEvento(parametroRetorno.getEVENTO_BEM_SUCEDIDO());

		MapQuery q = new MapQuery(getSession());

		q.append("from DwFtParam omparametro where omparametro.idFtParam = :idparametro ");
		q.defineParametro("idparametro", parametro.getParametro().getIdFtParam());

		DwFtParam dwFtParamOriginal = (DwFtParam) q.uniqueResult();
		// Verifica se a descricao ja foi cadastrada
		DwFtParamDAO dao = new DwFtParamDAO(getSession());
		DwFtParam ds = dao.getDwFtParamPorDs(parametro.getParametro().getDsParametro());
		
		if (dwFtParamOriginal == null){
			if (ds != null) {
				parametroRetorno.setResultadoEvento(parametroRetorno.getERRO_PARAMETRO_SENDO_USADO());
				return parametroRetorno;
			}
			dwFtParamOriginal = (DwFtParam)parametro.getParametro().clone();					
		}else{
			if (ds != null && ds.getIdFtParam() != dwFtParamOriginal.getIdFtParam()) {
				parametroRetorno.setResultadoEvento(parametroRetorno.getERRO_PARAMETRO_SENDO_USADO());
				return parametroRetorno;
			}
			
			dwFtParamOriginal.copy(parametro.getParametro(), false);			
		}		

		if (parametroRetorno.getResultadoEvento() == parametroRetorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				dwFtParamOriginal = (DwFtParam) makePersistent(dwFtParamOriginal);				
			} catch (Exception e){
				parametroRetorno.setResultadoEvento(parametroRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			parametroRetorno.setParametro((DwFtParam)dwFtParamOriginal.clone());
			
		}

		return parametroRetorno;
	}	
	
	public DwFtParam getDwFtParam(long idFtParam){		
		return (DwFtParam) this.getDao().getSession().get(DwFtParam.class, idFtParam);
	}
	
	public ParametroDTO getDwFtParamPeloDs(String dsFtParam){
		DwFtParam dwFtParam = new DwFtParam();
		ParametroDTO parametro = new ParametroDTO();
		
		String hql="";
		hql += "select t ";
		hql += "from DwFtParam t ";		
		hql += "where t.dsParametro = ::dsFtParam";
		
		hql = hql.replaceAll("::dsFtParam", dsFtParam);
		
		Query q = getSession().createQuery(hql);
		
		dwFtParam = (DwFtParam) q.uniqueResult();
		
		parametro.setParametro(dwFtParam);
		
		return parametro;
		
		
	}
	
	public ParametrosDTO pesquisarVariavelMedicao(String variavel) {
		MapQuery q = new MapQuery(getSession());
		
		q.append("select a");
		q.append("from DwFtParam a");
		q.append("where  a.dsParametro like :ds");
		
		q.defineParametro("ds", "%" + variavel + "%");
		
		List<DwFtParam> lista = q.list();
		
		ParametrosDTO retorno = new ParametrosDTO();
		retorno.setParametros(new ArrayList<ParametroDTO>());
		for (DwFtParam ft : lista) {
			ParametroDTO parametro = new ParametroDTO();
			parametro.setParametro(ft.clone(false));
			retorno.getParametros().add(parametro);
		}
		
		return retorno;
	}
	
	
	public ParametrosDTO removeParametrosDTO(ParametrosDTO parametros){
		List<ParametroDTO> listaRetorno = new ArrayList<ParametroDTO>();
		ParametrosDTO parametrosRetorno = new ParametrosDTO();
		
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(parametros);
		parametrosRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return parametrosRetorno;
		}
				
		
		for (ParametroDTO parametro : parametros.getParametros()){
			ParametroDTO parametroRetorno = new ParametroDTO();
			String hql = "";

			hql = "from DwFtParam omparametro where omparametro.idFtParam = ::idparametro";
			hql = hql.replaceAll("::idparametro", String.valueOf(parametro.getParametro().getIdFtParam()));

			Query q = getSession().createQuery(hql);

			DwFtParam dwFtParam = (DwFtParam) q.uniqueResult();

			if (dwFtParam == null){			
				parametroRetorno.setResultadoEvento(parametroRetorno.getERRO_PARAMETRO_DESCONHECIDO());
				parametroRetorno.setParametro(parametro.getParametro());				
			}else if ((dwFtParam.getDwFtSubparams() != null && dwFtParam.getDwFtSubparams().size() > 0) || (dwFtParam.getDwFtSubs() != null && dwFtParam.getDwFtSubs().size() > 0)){			
				parametroRetorno.setResultadoEvento(parametroRetorno.getERRO_PARAMETRO_SENDO_USADO());
				parametroRetorno.setParametro((DwFtParam)dwFtParam.clone());				
			}else{
				parametroRetorno.setParametro((DwFtParam)dwFtParam.clone());
				try{
					getSession().delete(dwFtParam);								
				} catch (Exception e){
					e.printStackTrace();
				}				
			}		
			
			listaRetorno.add(parametroRetorno);
			
		}

		
		parametrosRetorno.setParametros(listaRetorno);
		return parametrosRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(ParametrosDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getSession());
		
		//campos
		DwFtParam correnteEmUso = omcfg.getDwFtParamByIdFtParamcorrente();
		DwFtParam fluxoEntradaEmUso = omcfg.getDwFtParamByIdFtParamfluxoe();
		DwFtParam fluxoSaidaEmUso = omcfg.getDwFtParamByIdFtParamflusos();		
		DwFtParam tensaoEmUso = omcfg.getDwFtParamByIdFtParamtensao();		
		DwFtParam fatorPotenciaEmUso = omcfg.getDwFtParamByIdFtParamfp();		
		DwFtParam energiaConsumidaEmUso = omcfg.getDwFtParamByIdFtParamec();
		DwFtParam temperaturaEmUso = omcfg.getDwFtParamByIdFtParamTemp();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(ParametroDTO item : itens.getParametros()) {			
			
			camposEmUsoOmCfg.setCodigo(String.valueOf(item.getParametro().getIdFtParam()));
			
			if(correnteEmUso != null) {
				if(item.getParametro().getIdFtParam() == correnteEmUso.getIdFtParam()) {
					camposEmUsoOmCfg.setCorrente(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(fluxoEntradaEmUso != null) {
				if(item.getParametro().getIdFtParam() == fluxoEntradaEmUso.getIdFtParam()) {
					camposEmUsoOmCfg.setFluxoEntrada(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(fluxoSaidaEmUso != null) {
				if(item.getParametro().getIdFtParam() == fluxoSaidaEmUso.getIdFtParam()) {
					camposEmUsoOmCfg.setFluxoSaida(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(tensaoEmUso != null) {
				if(item.getParametro().getIdFtParam() == tensaoEmUso.getIdFtParam()) {
					camposEmUsoOmCfg.setTensao(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(fatorPotenciaEmUso != null) {
				if(item.getParametro().getIdFtParam() == fatorPotenciaEmUso.getIdFtParam()) {
					camposEmUsoOmCfg.setFatorPotencia(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(energiaConsumidaEmUso != null) {
				if(item.getParametro().getIdFtParam() == energiaConsumidaEmUso.getIdFtParam()) {
					camposEmUsoOmCfg.setEnergiaConsumida(true);
					isTemCodigoEmUso = true;
				}
			}
			
			if(temperaturaEmUso != null) {
				if(item.getParametro().getIdFtParam() == temperaturaEmUso.getIdFtParam()) {
					camposEmUsoOmCfg.setTemperatura(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getParametros() != null && itens.getParametros().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}
		
}

