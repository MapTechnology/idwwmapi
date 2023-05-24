package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwEstlocalDAO;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRapGrupo;
import idw.model.pojos.DwTprap;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.webservices.dto.DwRapDTO;
import idw.webservices.dto.DwRapListDTO;
import idw.webservices.dto.DwTprapDTO;
import idw.webservices.dto.DwTprapsDTO;
import idw.webservices.dto.FerramentaDTO;
import idw.webservices.dto.ResultadoDTO;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaRapsDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import idw.webservices.rest.idw.v2.dto.RapDTO;
import idw.webservices.rest.idw.v2.dto.TurnoDTO2;

public class DwRapRN extends DwRapDTO implements IDao{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private transient DAOGenerico dao;
	

	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}
	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}

	public DwRapRN(){
		if (this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public DwRapRN(DAOGenerico dao){
		this.dao = dao;
	}
	public DwRapRN(DwRapDTO dwRapDTO){
		super(dwRapDTO);
		if (this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}

	public DwRapListDTO getDwRapAtivos() {
		DwRapListDTO retorno = new DwRapListDTO();
		List<DwRapDTO> dwRapDTO_lista = new ArrayList<DwRapDTO>();
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select distinct dwrap from DwRap dwrap ");
		q.append("where dwrap.stAtivo = 1 ");
		q.append("order by dwrap.cdRap");
		
		List<DwRap> lista = q.list();

		for (DwRap dwRap : lista){
			DwRapDTO p = new DwRapDTO(dwRap.clone());
			dwRapDTO_lista.add(p);
		}
		
		retorno.setDwRapDTO(dwRapDTO_lista);
	
		return retorno;
	}
	
	public DwRapListDTO pesquisar(DwRapDTO dwRapDTO){
		DwRapListDTO retorno = new DwRapListDTO();
		List<DwRapDTO> dwRapDTO_lista = new ArrayList<DwRapDTO>();

		//verifica o retorno da comparacao ID
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select distinct dwrap from DwRap dwrap ");

		q.appendWhere(MapQuery._NULL, "dwrap.cdRap = :cdRap", ((dwRapDTO.getCdRap() != null) && (dwRapDTO.getCdRap().equals("") == false)));
		q.appendWhere(MapQuery._AND, "dwrap.idRap = :idRap", ((dwRapDTO.getIdRap() != 0L) && (dwRapDTO.getIdRap() > 0)) );
		q.appendWhere(MapQuery._AND, "dwrap.ppCliente.cdCliente = :cdcliente", dwRapDTO.getPpCliente() != null && dwRapDTO.getPpCliente().getCdCliente()!= null && dwRapDTO.getPpCliente().getCdCliente().equals("") == false);
		if(dwRapDTO.getStAtivo() == null){
			q.appendWhere(MapQuery._AND, "dwrap.stAtivo = 1", true);
		}else{
			q.appendWhere(MapQuery._AND, "dwrap.stAtivo = :stativo", true);
			q.defineParametro("stativo", dwRapDTO.getStAtivo());
		}

		if(dwRapDTO.getDtRevisao()!=null){
			q.appendWhere(MapQuery._AND, "AND dwrap.dtRevisao >= :dtRevisao AND dwrap.dtRevisao <= :dtRevisaoF ", true);
			q.defineParametro("dtRevisao", dwRapDTO.getDtRevisao());
			q.defineParametro("dtRevisaoF", DataHoraRN.getDataHora235959(dwRapDTO.getDtRevisao()));
		}
		if(dwRapDTO.getDtStativo()!=null){
			q.appendWhere(MapQuery._AND, "AND dwrap.dtStativo >= :dtStativo AND dwrap.dtStativo <= :dtStativoF ", true);
			q.defineParametro("dtStativo", dwRapDTO.getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(dwRapDTO.getDtStativo()));
		}
		
		q.defineParametro("cdRap", dwRapDTO.getCdRap());
		q.defineParametro("idRap", dwRapDTO.getIdRap());

		List<DwRap> lista = q.list();

		for (DwRap dwRap : lista){
			DwRap tipoRap = null;
			if(dwRap.getDwRap() != null){
			  tipoRap	= dwRap.getDwRap().clone();
			}


			DwRapDTO p = new DwRapDTO(dwRap.clone());
			p.setDwRap(tipoRap);
			dwRapDTO_lista.add(p);
		}
		retorno.setDwRapDTO(dwRapDTO_lista);
		return retorno;
	}
	
	public DwRapListDTO pesquisarById(Long id){
		DwRapListDTO retorno;
		DwRapDTO filtro = new DwRapDTO();
		filtro.setIdRap(id);
		filtro.setStAtivo((byte)1);
		retorno = pesquisar(filtro);
		return retorno;
	}

	public DwRap pesquisarDwRapByCdRap() {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select dwRap from DwRap dwRap  where dwRap.cdRap = :cdRap ");
		q.append("and dwRap.stAtivo = 1 ");

		q.defineParametro("cdRap", this.getCdRap());
		q.setMaxResults(1);

		return (DwRap) q.uniqueResult();
	}

	public DwRap pesquisarDwRapById() {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select dwRap from DwRap dwRap  where dwRap.idRap = :idRap ");
		q.defineParametro("idRap", this.getIdRap());

		return (DwRap) q.uniqueResult();
	}

	public DwRapDTO excluirRegistro() {

		DwRapDTO retorno = this;
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		// Pesquisa o ppnec que se deseja excluir
		DwRap dwRap = this.pesquisarDwRapById();

		// Se nao existir o registro desejado para exclusao, entao retornar ao solicitante informando registro desconhecido
		if (dwRap == null){
			resultadoDTO.setIdmensagem(resultadoDTO.CODIGO_DESCONHECIDO);
			return retorno;
		}

		// Se o registro solicitado para exclusao ja estiver marcado como excluir, retornar ao solicitante informando a situacao
		if(dwRap.getStAtivo() == BigDecimal.ZERO.toString().charAt(0)) {
			resultadoDTO.setIdmensagem(resultadoDTO.ERRO_EXCLUI_STATIVO_ZERO);
			return retorno;
		}

		// Pesquisar o usuario logado
		OmUsr msusr = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		try {
			msusr = usuarioRN.getDao().findById(OmUsr.class, this.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(msusr == null){
				resultadoDTO.setIdmensagem(resultadoDTO.USUARIO_DESCONHECIDO);
				return retorno;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}


		// Marca stAtivo com zero informando que registro foi desativado
		dwRap.setStAtivo((byte)0); //(char) 0
		dwRap.setDtStativo(DataHoraRN.getDataHoraAtual());
		dwRap.setOmUsrByIdUsrstativo(msusr);

		this.dao.makePersistent(dwRap);

		retorno = new DwRapDTO(dwRap.clone());
		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);

		return retorno;
	}

	public DwRapDTO salvarRegistro() {

		DwRapDTO retorno =  new DwRapDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		DwRap dwRap = this.pesquisarDwRapByCdRap();
		
		
		//20160926FVA:
		if (dwRap != null) {
			if (dwRap != null && dwRap.getIdRap() > 0 && dwRap.getStAtivo().equals((byte)0)){
				ResultadoDTO resultadodto = new ResultadoDTO();
				resultadodto.setIdmensagem(resultadodto.getERRO_REATIVACAO_INDISPONIVEL());
				retorno.setResultadoDTO(resultadodto);
				return retorno;
			}
		}
		

		// Se existir o registro, entao marca-lo como removido
		if (dwRap != null) {
			if ((this.getIdRap() == null) || (this.getIdRap() == 0)){
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.REGISTRO_JA_EXISTE).intValue());
				return retorno;
			}
			this.excluirRegistro();
		}

		DwRap dwRapNovo = this.clone(true);

		dwRapNovo.setIdRap(null);
		dwRapNovo.setStAtivo((byte)1); //(char)'1'
		dwRapNovo.setDtRevisao(DataHoraRN.getDataHoraAtual());
		dwRapNovo.setDtStativo(DataHoraRN.getDataHoraAtual());
		
		if (dwRap != null) {
			dwRapNovo.setQtAutoCiclosDesdeultimaManutencao(dwRap.getQtAutoCiclosDesdeultimaManutencao());
			dwRapNovo.setQtAutoCiclosTotais(dwRap.getQtAutoCiclosTotais());
		}

		// Define o numero da revisao
		if (dwRapNovo.getRevisao() == null || (dwRapNovo.getRevisao() != null && dwRapNovo.getRevisao() <= 0) ){
			dwRapNovo.setRevisao((long) 1);
		} else {
			dwRapNovo.setRevisao(dwRapNovo.getRevisao() + 1);
		}

		//pesquisa o Usuario do stativo
		OmUsr omUsrStAtivo = null;
		OmUsr omUsrRevisao = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		try {
			omUsrStAtivo = usuarioRN.getDao().findById(OmUsr.class, this.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrStAtivo == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				return retorno;
			}
		} catch(Exception e) {
			resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}

		try {
			omUsrRevisao = usuarioRN.getDao().findById(OmUsr.class, this.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrRevisao == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				return retorno;

			}
		} catch(Exception e) {
			resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
			return retorno;
		}
		// Avaliar se cliente existe
		PpCliente ppcliente = null;
		ClienteRN crn = new ClienteRN(this.dao);
		if (this.getPpCliente() != null && this.getPpCliente().getCdCliente() != null && this.getPpCliente().getCdCliente().equals("") == false) {
			ppcliente = crn.pesquisarByCdClienteEStAtivo(this.getPpCliente().getCdCliente());
		}
		dwRapNovo.setPpCliente(ppcliente);
		
		dwRapNovo.setOmUsrByIdUsrstativo(omUsrStAtivo);
		dwRapNovo.setOmUsrByIdUsrrevisao(omUsrRevisao);

		DwRap rap = null;
        if (this.getDwRap() != null){
        	rap =  this.dao.findById(DwRap.class,this.getDwRap().getIdRap() , false);
        }

        for(DwRapGrupo dwRapGrupo : dwRapNovo.getDwRapGrupos()) {
        	dwRapGrupo.setDwRap(dwRapNovo);
        }

		dwRapNovo.setDwRap(rap);

		
		/* Avalia o local da ferramenta e utiliza o mesmo local no registro novo
		 * 
		 */
		DwEstlocal dwestLocal = null;
		if (this.getDwEstlocal() != null) {
			DwEstlocalDAO rn  = new DwEstlocalDAO(dao.getSession());
			dwestLocal = rn.getDwEstlocalPorId(this.getDwEstlocal().getIdEstlocal());
		}
		dwRapNovo.setDwEstlocal(dwestLocal);

		/* Avalia tipo da ferramenta
		 * 
		 */
		DwTprap dwtprap = null;
		if (this.getDwTprap() != null) {
			dwtprap = pesquisarTipoRAPByCd(this.getDwTprap().getCdTprap());
		}
		dwRapNovo.setDwTprap(dwtprap);
		
		
		dwRapNovo = this.dao.makePersistent(dwRapNovo);
		
		/* Eh necess�rio atualizar o novo idRap em dwFolharapcom
		 * 
		 */
		if (dwRap != null && dwRap.getDwFolharaps() != null)
			for (DwFolharap com : dwRap.getDwFolharaps()) {
				com.setDwRap(dwRapNovo);
				dao.makePersistent(com);
			}

		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);



		DwRapDTO resultadoPersistent = new DwRapDTO(dwRapNovo.clone(true));

		if (rap != null ){
			resultadoPersistent.setDwRap(rap.clone());
		}

		resultadoPersistent.setResultadoDTO(resultadoDTO);

		retorno = resultadoPersistent;

		return retorno;
	}

	public DwRapListDTO getListaCdDsRap(){
		DwRapListDTO retorno = new DwRapListDTO();
		List<DwRapDTO> dwRapDTO_lista = new ArrayList<DwRapDTO>();
		MapQuery q = new MapQuery(this.dao.getSession());
		
		final int _codigo = 0;
		final int _descricao = 1;		

		q.append("SELECT DISTINCT rap.cdRap, rap.dsRap FROM DwRap rap WHERE rap.stAtivo = 1 ORDER BY rap.cdRap");
		
		List<Object> lista = q.list();

		for (Object reg : lista) 
		{
			Object[] registro = (Object[]) reg;
			String codigo = (String) registro[_codigo];
			String descricao = (String) registro[_descricao];
			
		    DwRapDTO p = new DwRapDTO();
		    p.setCdRap(codigo);
		    p.setDsRap(descricao);
		    dwRapDTO_lista.add(p);
			
			retorno.setDwRapDTO(dwRapDTO_lista);
		}
		
		retorno.setDwRapDTO(dwRapDTO_lista);
	
		return retorno;
	}

	
	public DwTprapsDTO pesquisarTipoRAP(String variavel) {
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select a");
		q.append("from DwTprap a");
		q.append("where a.stAtivo = 1 and ( a.dsTprap like :ds or");
		q.append("a.cdTprap like :cd )");
		
		q.defineParametro("cd", "%" + variavel + "%");
		q.defineParametro("ds", "%" + variavel + "%");
		
		List<DwTprap> lista = q.list();
		
		DwTprapsDTO retorno = new DwTprapsDTO();
		retorno.setDwtrapsDTO(new ArrayList<DwTprapDTO>());
		for (DwTprap ft : lista) {
			DwTprapDTO parametro = new DwTprapDTO();
			parametro.setDwtprap(ft.clone(false));
			retorno.getDwtrapsDTO().add(parametro);
		}
		
		return retorno;
	}

	
	public DwTprap pesquisarTipoRAPByCd(String cd) {
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select a");
		q.append("from DwTprap a");
		q.append("where a.stAtivo = 1 and ");
		q.append("a.cdTprap = :cd ");
		
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		
		DwTprap retorno = (DwTprap) q.uniqueResult();
		
		return retorno;
	}

	public DwRapListDTO pesquisarRAP(String variavel) {
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select a");
		q.append("from DwRap a");
		q.append("where a.stAtivo = 1 and (a.dsRap like :ds or");
		q.append("a.cdRap like :cd)");
		
		q.defineParametro("cd", "%" + variavel + "%");
		q.defineParametro("ds", "%" + variavel + "%");
		
		List<DwRap> lista = q.list();
		
		DwRapListDTO retorno = new DwRapListDTO();
		retorno.setDwRapDTO(new ArrayList<DwRapDTO>());
		for (DwRap ft : lista) {
			DwRapDTO parametro = new DwRapDTO();
			parametro.setDwRap(ft.clone(false));
			retorno.getDwRapDTO().add(parametro);
		}
		
		return retorno;
	}
	
	
	/* Metodo para retornar as não conformidades de uma ferramenta
	 * 
	 */
	public FerramentaDTO pesquisarNCsFerramentaByCd(String cdrap) {
		FerramentaDTO retorno = new FerramentaDTO();
		setCdRap(cdrap);
		DwRap dwrap = pesquisarDwRapByCdRap();

		if (dwrap != null) {
			retorno.setStatus("200");
			retorno.setCdRap(dwrap.getCdRap());
			retorno.setDsRap(dwrap.getDsRap());
			if (dwrap.getDwEstlocal() != null) {
				retorno.setCdLocalEstoqueAtual(dwrap.getDwEstlocal().getCdLocal());
				if (dwrap.getDwEstlocal().getDwEst() != null)
					retorno.setCdEstoqueAtual(dwrap.getDwEstlocal().getDwEst().getCdEst());
			}
		} else {
			retorno.setStatus("400");
			retorno.setTitle("Ferramenta desconhecida");
			retorno.setCdRap("teste");
		}
		return retorno;
	}
	
	
	

	public ListaRapsDTO getFerramentasDTO(FiltroPesquisaDTO filtro) {
		ListaRapsDTO retorno = new ListaRapsDTO();
		retorno.setItems(new ArrayList<RapDTO>());
		retorno.setMeta(new MetaDTO(filtro));
		
		
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select distinct t ");
		q.append("from DwRap t ");
		q.append("where t.stAtivo = 1 ");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdRap) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.dsRap) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdRap");
		
		
		List<DwRap> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
 		for (DwRap registro : listaPesquisa) {
 			
 			RapDTO regDTO = new RapDTO();
 			
 			regDTO.setIdFerramenta(registro.getIdRap());
 			regDTO.setCdFerramenta(registro.getCdRap());
 			regDTO.setDsFerramenta(registro.getDsRap());
 			regDTO.setQtTotal(BigDecimal.ZERO);
 			regDTO.setQtAlocada(BigDecimal.ZERO);
 			regDTO.setStRegistro(registro.getStAtivo().intValue());
 			
 			if (registro.getQtTotal() != null) {
 				regDTO.setQtTotal(registro.getQtTotal());	
 			}
 			
 			if (registro.getQtTotal() != null) {
 				regDTO.setQtAlocada(registro.getQtAlocada());	
 			}
 			
 			regDTO.setCdGrupoFerramenta("");
 			regDTO.setDsGrupoFerramenta("");
 			for(DwRapGrupo dwRapGrupo : registro.getDwRapGrupos()) {
 	        	if (dwRapGrupo.getDwRap().getIdRap() == registro.getIdRap()) {
 	        		regDTO.setCdGrupoFerramenta(dwRapGrupo.getDwGrupoFerramenta().getCdGrupoFerramenta());
 	        		regDTO.setDsGrupoFerramenta(dwRapGrupo.getDwGrupoFerramenta().getDsGrupoFerramenta());
 	        		break;
 	        	}
 	        }
 			
 			regDTO.setCdCliente("");
 			regDTO.setDsCliente("");
 			if (registro.getPpCliente() != null) {
 				regDTO.setCdCliente(registro.getPpCliente().getCdCliente());
 				regDTO.setDsCliente(registro.getPpCliente().getNmCliente());
 			}
 			
 			retorno.getItems().add(regDTO);
 		}
		
		
 		if (listaPesquisa.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(this.dao);
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, listaPesquisa.size()));
 			resRN = null;
 		}
		
		q = null;
		listaPesquisa = null;

		return retorno;
	}
	
	

	@SuppressWarnings("unused")
	public RapDTO getFerramentaByCd(String cdFerramenta) {
		RapDTO retorno = new RapDTO();
		
		MapQuery q = new MapQuery(this.dao.getSession());
		
		q.append("select distinct t ");
		q.append("from DwRap t "); 
		q.append("where t.stAtivo = 1 ");
		q.append("AND t.cdRap = :cdFerramenta ");
		q.append("order by t.cdRap");

 		q.defineParametro("cdFerramenta", cdFerramenta);
		
 		List<DwRap> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdFerramenta(lista.get(0).getIdRap());
 			retorno.setCdFerramenta(lista.get(0).getCdRap());
 			retorno.setDsFerramenta(lista.get(0).getDsRap());
 			retorno.setQtTotal(BigDecimal.ZERO);
 			retorno.setQtAlocada(BigDecimal.ZERO);
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			
 			if (lista.get(0).getQtTotal() != null) {
 				retorno.setQtTotal(lista.get(0).getQtTotal());	
 			}
 			
 			if (lista.get(0).getQtTotal() != null) {
 				retorno.setQtAlocada(lista.get(0).getQtAlocada());	
 			}
 			
 			retorno.setCdGrupoFerramenta("");
 			retorno.setDsGrupoFerramenta("");
 			for(DwRapGrupo dwRapGrupo : lista.get(0).getDwRapGrupos()) {
 	        	if (dwRapGrupo.getDwRap().getIdRap() == lista.get(0).getIdRap()) {
 	        		retorno.setCdGrupoFerramenta(dwRapGrupo.getDwGrupoFerramenta().getCdGrupoFerramenta());
 	        		retorno.setDsGrupoFerramenta(dwRapGrupo.getDwGrupoFerramenta().getDsGrupoFerramenta());
 	        		break;
 	        	}
 	        }
 			
 			retorno.setCdCliente("");
 			retorno.setDsCliente("");
 			if (lista.get(0).getPpCliente() != null) {
 				retorno.setCdCliente(lista.get(0).getPpCliente().getCdCliente());
 				retorno.setDsCliente(lista.get(0).getPpCliente().getNmCliente());
 			}
 			
 		}
		
		return retorno;
	}
	
	

	public DwRap getDwRapPorCodigo(String cdFerramenta, DAOGenerico dao) {
		
		// MapQuery q = new MapQuery(this.dao.getSession());
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select distinct t ");
		q.append("from DwRap t ");
		q.append("where t.stAtivo = 1 ");
		q.append("AND t.cdRap = :cdFerramenta ");
		
		q.defineParametro("cdFerramenta", cdFerramenta);
		
		return (DwRap) q.uniqueResult();
		
	}
	

	public void rollbackTransacaoConexaoBanco() {
		
		try {
			this.dao.rollbackTransacao();	
		} catch (Exception e) {
			// 
		}
		
		try {
			this.dao.finalizaSessao();	
		} catch (Exception e) {
			// 
		}
		
	}

	public void finalizaSessaoConexaoBanco() {

		try {
			this.dao.finalizaSessao();	
		} catch (Exception e) {
			// 
		}
		
	}

	
	
}
