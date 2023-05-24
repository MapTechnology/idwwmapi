package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwRapGrupo;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.webservices.dto.PpClienteDTO;
import idw.webservices.dto.PpClientesDTO;
import idw.webservices.rest.idw.v2.dto.ClienteDTO2;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO;
import idw.webservices.rest.idw.v2.dto.ListaClientesDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;

public class PpClienteRN extends AbstractRN<DAOGenerico>{

	public PpClienteRN() {
		this(null);
	}

	public PpClienteRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public void desativarCliente(long idCliente,  Date date, OmUsr omUsr) throws RegistroJaDesativadoException{
		this.getDao().desativar(PpCliente.class, idCliente, date, omUsr);
	}

	public void salvarDesativandoOriginal(PpCliente ppCliente, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(ppCliente, dateOperacao, omUsrOperacao);
	}

	public PpClientesDTO getPpClientesDTO(PpClienteDTO filtro){
		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from PpCliente t ");
		q.append("where 1=1 ");

		if(filtro.getPpCliente().getIdCliente() != null){
			q.append("AND t.idCliente=:idCliente ");
		}else{
			if(filtro.getPpCliente().getCdCliente() !=null && !filtro.getPpCliente().getCdCliente().equals("")){
				q.append("AND t.cdCliente=:cdCliente ");
			}
			if(filtro.getPpCliente().getNmCliente() !=null &&
					!filtro.getPpCliente().getNmCliente().equals("")){
				q.append("AND t.nmCliente=:nmCliente ");
			}
			
			if(filtro.getPpCliente().getCidade() != null && !filtro.getPpCliente().getCidade().equals("")){
				q.append("AND t.cidade =:cidade");
			}
			
			if(filtro.getPpCliente().getCnpjCpf() != null && !filtro.getPpCliente().getCnpjCpf().equals("")){
				q.append("AND t.cnpjCpf=:cnpjCpf");
			}
			
			if(filtro.getPpCliente().getContato() != null && !filtro.getPpCliente().getContato().equals("")){
				q.append("AND t.contato=:contato");
			}
			
			if(filtro.getPpCliente().getDepara() != null && !filtro.getPpCliente().getDepara().equals("")){
				q.append("AND t.depara=:depara");
			}
			
			if(filtro.getPpCliente().getEndereco() != null && !filtro.getPpCliente().getEndereco().equals("")){
				q.append("AND t.endereco=:endereco");
			}
			
			if(filtro.getPpCliente().getEstado() != null && !filtro.getPpCliente().getEstado().equals("")){
				q.append("AND t.estado=:estado");
			}
			
			if(filtro.getPpCliente().getHrLeadtime() != null && filtro.getPpCliente().getHrLeadtime().compareTo(BigDecimal.ZERO) > 0 ){
				q.append("AND t.hrLeadtime=:hrLeadtime");
			}
			
			if(filtro.getPpCliente().getPais() != null && !filtro.getPpCliente().getPais().equals("")){
				q.append("AND t.pais=:pais");
			}
			
			if(filtro.getPpCliente().getTelefonedois() != null && !filtro.getPpCliente().getTelefonedois().equals("")){
				q.append("AND t.telefonedois=:telefonedois");
			}
			
			if(filtro.getPpCliente().getTelefonetres() != null && !filtro.getPpCliente().getTelefonetres().equals("")){
				q.append("AND t.telefonetres=:telefonetres");
			}
			
			if(filtro.getPpCliente().getTelefoneum() != null && !filtro.getPpCliente().getTelefoneum().equals("")){
				q.append("AND t.telefoneum=:telefoneum");
			}
			
			if(filtro.getPpCliente().getTpCliente() != null && !filtro.getPpCliente().getTpCliente().equals("")){
				q.append("AND t.tpCliente=:tpCliente");
			}
			
			if(filtro.getPpCliente().getUrlSite() != null && !filtro.getPpCliente().getUrlSite().equals("")){
				q.append("AND t.urlSite=:urlSite");
			}
			
			if((filtro.getPpCliente().getOmUsrByIdUsrstativo()!= null)
					&& (filtro.getPpCliente().getOmUsrByIdUsrstativo().getCdUsr() != null)
					&& (!filtro.getPpCliente().getOmUsrByIdUsrstativo().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.cdUsr=:cdUsrSt ");
			}
			if((filtro.getPpCliente().getOmUsrByIdUsrstativo() != null)
					&& (filtro.getPpCliente().getOmUsrByIdUsrstativo().getDsNome() != null)
					&& (!filtro.getPpCliente().getOmUsrByIdUsrstativo().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrstativo.dsNome=:dsNomeSt ");
			}
			if((filtro.getPpCliente().getOmUsrByIdUsrrevisao()!= null)
					&& (filtro.getPpCliente().getOmUsrByIdUsrrevisao().getCdUsr() != null)
					&& (!filtro.getPpCliente().getOmUsrByIdUsrrevisao().getCdUsr().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.cdUsr=:cdUsrRev ");
			}
			if((filtro.getPpCliente().getOmUsrByIdUsrrevisao() != null)
					&& (filtro.getPpCliente().getOmUsrByIdUsrrevisao().getDsNome() != null)
					&& (!filtro.getPpCliente().getOmUsrByIdUsrrevisao().getDsNome().equals(""))){
				q.append("AND t.omUsrByIdUsrrevisao.dsNome=:dsNomeRev ");
			}
			if(filtro.getPpCliente().getDtRevisao() != null){
				q.append("AND t.dtRevisao >= :dtRevisao AND t.dtRevisao <= :dtRevisaoF ");
			}
			if(filtro.getPpCliente().getDtStativo() != null){
				q.append("AND t.dtStativo >= :dtStativo AND t.dtStativo <= :dtStativoF ");
			}
			if (filtro.getPpCliente().getRevisao()==null){
				q.append("AND t.revisao = (SELECT max(tr.revisao) as Revisao from PpCliente tr where tr.cdCliente = t.cdCliente ) ");
		    }else{
				q.append("AND t.revisao=:revisao ");
			}
			if (filtro.getPpCliente().getStAtivo() != null && filtro.getPpCliente().getStAtivo()<(byte)2){
				q.append("AND t.stAtivo=:stAtivo ");
			}
		}
		
		if(filtro.getPpCliente().getIdCliente()!=null){
			q.defineParametro("idCliente", filtro.getPpCliente().getIdCliente());
		}
		if(filtro.getPpCliente().getCdCliente() != null){
			q.defineParametro("cdCliente", filtro.getPpCliente().getCdCliente());
		}
		if(filtro.getPpCliente().getNmCliente() != null){
			q.defineParametro("nmCliente", filtro.getPpCliente().getNmCliente());
		}
		if(filtro.getPpCliente().getCidade() != null){
			q.defineParametro("cidade", filtro.getPpCliente().getCidade());
		}
		if(filtro.getPpCliente().getCnpjCpf() != null){
			q.defineParametro("cnpjCpf", filtro.getPpCliente().getCnpjCpf());
		}
		if(filtro.getPpCliente().getContato() != null){
			q.defineParametro("contato", filtro.getPpCliente().getContato());
		}
		if(filtro.getPpCliente().getDepara() != null){
			q.defineParametro("depara", filtro.getPpCliente().getDepara());
		}
		if(filtro.getPpCliente().getEndereco() != null){
			q.defineParametro("endereco", filtro.getPpCliente().getEndereco());
		}
		if(filtro.getPpCliente().getEstado() != null){
			q.defineParametro("estado", filtro.getPpCliente().getEstado());
		}
		if(filtro.getPpCliente().getHrLeadtime() != null){
			q.defineParametro("hrLeadtime", filtro.getPpCliente().getHrLeadtime());
		}
		if(filtro.getPpCliente().getPais() != null){
			q.defineParametro("pais", filtro.getPpCliente().getPais());
		}
		if(filtro.getPpCliente().getTelefonedois() != null){
			q.defineParametro("telefonedois", filtro.getPpCliente().getTelefonedois());
		}
		if(filtro.getPpCliente().getTelefonetres() != null){
			q.defineParametro("telefonetres", filtro.getPpCliente().getTelefonetres());
		}
		if(filtro.getPpCliente().getTelefoneum() != null){
			q.defineParametro("telefoneum", filtro.getPpCliente().getTelefoneum());
		}
		if(filtro.getPpCliente().getTpCliente() != null){
			q.defineParametro("tpCliente", filtro.getPpCliente().getTpCliente() );
		}
		if(filtro.getPpCliente().getUrlSite() != null){
			q.defineParametro("urlSite", filtro.getPpCliente().getUrlSite());
		}
		
		if(filtro.getPpCliente().getDtRevisao()!=null){
			q.defineParametro("dtRevisao", filtro.getPpCliente().getDtRevisao());
			q.defineParametro("dtRevisaoF",DataHoraRN.getDataHora235959(filtro.getPpCliente().getDtRevisao()));
		}

		if(filtro.getPpCliente().getDtStativo()!=null){
			q.defineParametro("dtStativo", filtro.getPpCliente().getDtStativo());
			q.defineParametro("dtStativoF",DataHoraRN.getDataHora235959(filtro.getPpCliente().getDtStativo()));
		}

		q.defineParametro("revisao", filtro.getPpCliente().getRevisao());
		q.defineParametro("stAtivo", filtro.getPpCliente().getStAtivo());

		if (filtro.getPpCliente().getOmUsrByIdUsrrevisao() != null) {
			q.defineParametro("cdUsrRev", filtro.getPpCliente().getOmUsrByIdUsrrevisao().getCdUsr());
			q.defineParametro("dsNomeRev", filtro.getPpCliente().getOmUsrByIdUsrrevisao().getDsNome());
		}

		if (filtro.getPpCliente().getOmUsrByIdUsrstativo() != null){
			q.defineParametro("cdUsrSt", filtro.getPpCliente().getOmUsrByIdUsrstativo().getCdUsr());
			q.defineParametro("dsNomeSt", filtro.getPpCliente().getOmUsrByIdUsrstativo().getDsNome());
		}

		List<PpCliente> listaPesquisa = null;
		try{
			listaPesquisa = q.query().list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<PpClienteDTO> lista = new ArrayList<PpClienteDTO>();

		if (listaPesquisa != null) {
			for (PpCliente item : listaPesquisa) {
				PpClienteDTO ppClienteDTO = new PpClienteDTO();
				ppClienteDTO.setPpCliente(item.clone());
				lista.add(ppClienteDTO);
			}
		}

		PpClientesDTO listaRetorno = new PpClientesDTO();
		listaRetorno.setListaPpClientesDTO(lista);

		return listaRetorno;
	}

	
	public PpClienteDTO setPpClienteDTO(PpClienteDTO itemDTO) {
		PpCliente itemOriginal = new PpCliente();
		itemOriginal = itemDTO.getPpCliente().clone();

		OmUsr omUser = new OmUsr();
		UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
		try {
			omUser = usuarioRN.getOmUsr(itemOriginal.getOmUsrByIdUsrrevisao().getCdUsr());
		} catch (RegistroDesconhecidoException e) {
			e.printStackTrace();
		}
		salvarDesativandoOriginal(itemOriginal, new Date(), omUser);
		return itemDTO;
	}

	
	public PpClientesDTO removePpClientesDTO(PpClientesDTO itens){
	List<PpClienteDTO> listaRetorno = new ArrayList<PpClienteDTO>();

		for(PpClienteDTO item: itens.getListaPpClientesDTO()){
			OmUsr omUser = new OmUsr();
			UsuarioRN usuarioRN = new UsuarioRN(this.getDao());
			try {
				omUser = usuarioRN.getOmUsr(item.getPpCliente().getOmUsrByIdUsrrevisao().getCdUsr());
			} catch (RegistroDesconhecidoException e) {
				e.printStackTrace();
			}
			try {
				desativarCliente(item.getPpCliente().getIdCliente(),new Date(), omUser);
			} catch (RegistroJaDesativadoException e) {
				e.printStackTrace();
			}
			listaRetorno.add(item);
		}

		PpClientesDTO itensRetorno = new PpClientesDTO();
		itensRetorno.setListaPpClientesDTO(listaRetorno);
		return itensRetorno;
	}

	

	@SuppressWarnings("unused")
	public ListaClientesDTO getClientesDTO(FiltroPesquisaDTO filtro) {
		ListaClientesDTO retorno = new ListaClientesDTO();
		retorno.setItems(new ArrayList<ClienteDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
		
		MapQuery q = new MapQuery(this.getDaoSession());
		
		q.append("select t ");
		q.append("from PpCliente t ");
		q.append("where t.stAtivo = 1 ");
		
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){
			q.append("AND (");
			q.append(" upper(t.cdCliente) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.nmCliente) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
		
		q.append("order by t.cdCliente");
		
		// Lista do pojo
		List<PpCliente> listaPesquisa = q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
		
 		for (PpCliente registro : listaPesquisa) {
 			
 			ClienteDTO2 regDTO = new ClienteDTO2();
 			
 			regDTO.setIdCliente(registro.getIdCliente());
 			regDTO.setCdCliente(registro.getCdCliente());
 			regDTO.setNmCliente(registro.getNmCliente());
 			regDTO.setTpCliente(registro.getTpCliente());
 			regDTO.setCnpjcpf(registro.getCnpjCpf());
 			regDTO.setStRegistro(registro.getStAtivo().intValue());
 			
 			retorno.getItems().add(regDTO);
 		}
		
		
 		if (listaPesquisa.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, listaPesquisa.size()));
 			resRN = null;
 		}
		
		q = null;
		listaPesquisa = null;
		
		return retorno;
		
	}
	
	

	@SuppressWarnings("unused")
	public ClienteDTO2 getClienteByCd(String cdCliente) {
		ClienteDTO2 retorno = new ClienteDTO2();
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select t ");
		q.append("from PpCliente t ");
		q.append("where t.stAtivo = 1 ");
		q.append("and t.cdCliente = :cdCliente ");
		q.append("order by t.cdCliente");
		
 		q.defineParametro("cdCliente", cdCliente);

 		// Lista do pojo
 		List<PpCliente> lista = q.list();
 		
 		if (lista.size() == 1) {
 			
 			retorno.setIdCliente(lista.get(0).getIdCliente());
 			retorno.setCdCliente(lista.get(0).getCdCliente());
 			retorno.setNmCliente(lista.get(0).getNmCliente());
 			retorno.setTpCliente(lista.get(0).getTpCliente());
 			retorno.setCnpjcpf(lista.get(0).getCnpjCpf());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());
 			
 		}
		
		return retorno;
	}
	
	public PpCliente getPpCliente(String cdCliente){
		
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("FROM PpCliente t ");
		q.append("where t.stAtivo = 1 ");
		q.append("  and t.cdCliente = :cdCliente ");
		q.defineParametro("cdCliente", cdCliente);
		return (PpCliente) q.uniqueResult();
		
	}
	
}
