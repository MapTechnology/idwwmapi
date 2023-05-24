package idw.model.rn;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmEmpresa;
import idw.util.Util;
import idw.webservices.dto.CamposEmUsoOmCfgDTO;
import idw.webservices.dto.OmEmpresaDTO;
import idw.webservices.dto.OmEmpresasDTO;
import idw.webservices.dto.ResultadoDTO;

public class EmpresaRN extends AbstractRN<DAOGenerico> {

	public EmpresaRN() {
		this(null);
	}

	public EmpresaRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public OmEmpresaDTO setEmpresa(OmEmpresaDTO itemDTO) {

		itemDTO.setResultado(new ResultadoDTO());
		
		//setando null para hibernate gerar um id ao salvar
		if(itemDTO.getOmEmpresa().getIdEmpresa() == 0){
			itemDTO.getOmEmpresa().setIdEmpresa(null);
		}
		
		if (itemDTO.getOmEmpresa() == null
				|| itemDTO.getOmEmpresa().getCdEmpresa() == null
				|| itemDTO.getOmEmpresa().getCdEmpresa().equals("")) {
			itemDTO.getResultado().setIdmensagem(
					itemDTO.getResultado().CODIGO_DESCONHECIDO);
			return itemDTO;
		}
		
		OmEmpresa empresaSalva = null;
		if(itemDTO.getOmEmpresa().getIdEmpresa() == null){
			empresaSalva = getOmEmpresa(itemDTO.getOmEmpresa().getCdEmpresa());
			
			if(empresaSalva != null){
				itemDTO.getResultado().setIdmensagem(itemDTO.getResultado().CODIGO_EM_USO);
				return itemDTO;
			}
		}
		
		OmEmpresa itemOriginal = new OmEmpresa();
		itemOriginal = itemDTO.getOmEmpresa().clone();

		itemDTO.setOmEmpresa(this.getDao().makePersistent(itemOriginal));
		return itemDTO;
	}
	
	@SuppressWarnings("unchecked")
	public OmEmpresasDTO getOmEmpresa(OmEmpresaDTO filtro) {
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select empresa ");
		q.append("from OmEmpresa empresa ");
		q.append("where 1=1 ");

		if (filtro.getOmEmpresa().getIdEmpresa() != 0) {
			q.append("AND empresa.idEmpresa=:idEmpresa ");
		} else {
			if (filtro.getOmEmpresa().getCdEmpresa() != null
					&& !filtro.getOmEmpresa().getCdEmpresa().equals("")) {
				q.append("AND empresa.cdEmpresa=:cdEmpresa ");
			}
			if (filtro.getOmEmpresa().getDsEmpresa() != null
					&& !filtro.getOmEmpresa().getDsEmpresa().equals("")) {
				q.append("AND empresa.dsEmpresa=:dsEmpresa ");
			}
			if (filtro.getOmEmpresa().getEndereco() != null
					&& !filtro.getOmEmpresa().getEndereco().equals("")) {
				q.append("AND empresa.endereco=:endereco ");
			}			
			if (filtro.getOmEmpresa().getCidade() != null
					&& !filtro.getOmEmpresa().getCidade().equals("")) {
				q.append("AND empresa.cidade=:cidade ");
			}			
			if (filtro.getOmEmpresa().getEstado() != null
					&& !filtro.getOmEmpresa().getEstado().equals("")) {
				q.append("AND empresa.estado=:estado ");
			}
			if (filtro.getOmEmpresa().getPais() != null
					&& !filtro.getOmEmpresa().getPais().equals("")) {
				q.append("AND empresa.pais=:pais ");
			}
			if (filtro.getOmEmpresa().getChaveVerificacao() != null
					&& !filtro.getOmEmpresa().getChaveVerificacao().equals("")) {
				q.append("AND empresa.chaveVerificacao=:chaveVerificacao ");
			}
		}

		q.defineParametro("idEmpresa", filtro.getOmEmpresa().getIdEmpresa());
		q.defineParametro("cdEmpresa", filtro.getOmEmpresa().getCdEmpresa());
		q.defineParametro("dsEmpresa", filtro.getOmEmpresa().getDsEmpresa());
		q.defineParametro("endereco", filtro.getOmEmpresa().getEndereco());
		q.defineParametro("cidade", filtro.getOmEmpresa().getCidade());
		q.defineParametro("estado", filtro.getOmEmpresa().getEstado());
		q.defineParametro("pais", filtro.getOmEmpresa().getPais());
		q.defineParametro("chaveVerificacao", filtro.getOmEmpresa().getChaveVerificacao());

		List<OmEmpresa> listaPesquisa = null;
		try {
			listaPesquisa = q.query().list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<OmEmpresaDTO> lista = new ArrayList<OmEmpresaDTO>();

		if (listaPesquisa != null) {
			for (OmEmpresa item : listaPesquisa) {
				OmEmpresaDTO dto = new OmEmpresaDTO();
				dto.setOmEmpresa(item.clone());
				lista.add(dto);
			}
		}

		OmEmpresasDTO listaRetorno = new OmEmpresasDTO();
		listaRetorno.setListaEmpresa(lista);

		return listaRetorno;
	}
	
	public OmEmpresasDTO removeOmEmpresa(OmEmpresasDTO itens) {
		List<OmEmpresaDTO> listaRetorno = new ArrayList<OmEmpresaDTO>();
		OmEmpresasDTO itensRetorno = new OmEmpresasDTO();
		
		
		//17/03/2017 Alex: nao remover codigo em uso na configuracao geral.
		CamposEmUsoOmCfgDTO camposEmUsoOmCfgDTO = getCamposEmUsoOmCfg(itens);
		itensRetorno.setCamposEmUsoOmCfg(camposEmUsoOmCfgDTO);
		if(camposEmUsoOmCfgDTO.getStatus() != camposEmUsoOmCfgDTO.getSTATUS_NENHUM_CAMPO_EM_USO()) {
			//se entrar nesse if eh pq existe algum codigo em uso
			return itensRetorno;
		}
				

		for (OmEmpresaDTO item : itens.getListaEmpresa()) {
			this.getDao().delete(item.getOmEmpresa());
			listaRetorno.add(item);
		}

		
		itensRetorno.setListaEmpresa(listaRetorno);
		return itensRetorno;
	}
	
	private CamposEmUsoOmCfgDTO getCamposEmUsoOmCfg(OmEmpresasDTO itens) {
		OmCfg omcfg = Util.getConfigGeral(getDaoSession());
		
		//campos
		OmEmpresa empresaEmUso = omcfg.getOmEmpresa();
		
		CamposEmUsoOmCfgDTO camposEmUsoOmCfg = new CamposEmUsoOmCfgDTO();
		boolean isTemCodigoEmUso = false;
		for(OmEmpresaDTO item: itens.getListaEmpresa()) {
			camposEmUsoOmCfg.setCodigo(item.getOmEmpresa().getCdEmpresa());
			
			if(empresaEmUso != null) {
				if(item.getOmEmpresa().getCdEmpresa().equals(empresaEmUso.getCdEmpresa())) {
					camposEmUsoOmCfg.setEmpresa(true);
					isTemCodigoEmUso = true;
				}
			}
			
		}
		
		if(isTemCodigoEmUso) {
			
			if(itens.getListaEmpresa() != null && itens.getListaEmpresa().size() > 1) {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_EXCLUSAO_ABORTADA());
			} else {
				camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_TEM_CAMPO_EM_USO());
			}
			
		} else {
			camposEmUsoOmCfg.setStatus(camposEmUsoOmCfg.getSTATUS_NENHUM_CAMPO_EM_USO());
		}
		
		return camposEmUsoOmCfg;
	}
	
	/**
	 * Pega {@code OmEmpresa} relacionado com o id
	 * 
	 * @param idEmpresa
	 * @return
	 */
	public OmEmpresa getOmEmpresa(long idEmpresa) {
		return this.getDao().findById(OmEmpresa.class, idEmpresa, false);
	}
	
	public static boolean isEmpresaSemp(OmCfg omCfg) {
		return omCfg != null && isEmpresaSemp(omCfg.getOmEmpresa());
	}
	
	public static boolean isEmpresaFlex(OmCfg omCfg) {
		return omCfg != null && isEmpresaFlex(omCfg.getOmEmpresa());
	}
	
	public static boolean isEmpresaPst(OmCfg omCfg) {
		return omCfg != null && isEmpresaPst(omCfg.getOmEmpresa());
	}
	
	public static boolean isEmpresaSemp(OmEmpresa omempresa) {
		return omempresa != null && omempresa.getCdEmpresa().toLowerCase().equals("semp");
	}
	
	public static boolean isEmpresaFlex(OmEmpresa omempresa) {
		return omempresa != null && 
				( omempresa.getCdEmpresa().toLowerCase().contains("flex")
						|| omempresa.getDsEmpresa().toLowerCase().contains("flex"));
	}

	public static boolean isEmpresaPst(OmEmpresa omempresa) {
		return omempresa != null && omempresa.getCdEmpresa().toLowerCase().equals("pst");		
	}
	
	public OmEmpresa getOmEmpresa(String cdEmpresa){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT empresa FROM OmEmpresa empresa");
		q.append("WHERE empresa.cdEmpresa = :cdEmpresa");
		q.append("ORDER BY empresa.idEmpresa");
		q.defineParametro("cdEmpresa", cdEmpresa);
		q.setMaxResults(1);
		return (OmEmpresa) q.uniqueResult();
	}
	
	public OmEmpresaDTO getEmpresaAtiva() {
		ConfiguracaoRN configuracaoRN = new ConfiguracaoRN();
		configuracaoRN.setSession(getDaoSession());
		OmCfg configuracaoAtiva = configuracaoRN.getConfiguracao();
		OmEmpresaDTO empresaDTO = new OmEmpresaDTO();
		empresaDTO.setOmEmpresa(configuracaoAtiva.getOmEmpresa().clone());		
		empresaDTO.setFlex(isEmpresaFlex(configuracaoAtiva));
		empresaDTO.setSemp(isEmpresaSemp(configuracaoAtiva));
		empresaDTO.setPst(isEmpresaPst(configuracaoAtiva));
		return empresaDTO;
	}
}
