package idw.model.rn.monitorizacao.rastreamentons;

import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPassmon;
import idw.model.pojos.OmGt;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.DwNserieDTO;
import idw.webservices.dto.DwNseriesDTO;
import idw.webservices.dto.FiltroRastreamentoNSDTO;
import idw.webservices.dto.RastreamentoCompAtualDTO;
import idw.webservices.dto.RastreamentoLocalDTO;
import idw.webservices.dto.RastreamentoNSDTO;
import idw.webservices.dto.RastreamentoNaoLidoDTO;
import idw.webservices.dto.RastreamentoNaoLidosDTO;

public class RastreamentoNSRN extends AbstractRN<DAOGenerico> {

	public RastreamentoNSRN() {
		this(null);
	}

	public RastreamentoNSRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public DwNseriesDTO getDwNserie(FiltroRastreamentoNSDTO filtro){
		DwNseriesDTO retorno= new DwNseriesDTO();
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select distinct a");
		q.append("from DwNserie a");
		q.append("join a.dwPassagems b");
		q.append("join b.dwConsolid c");
		q.append("join c.ppCp d");
		q.append("join d.ppCpprodutos e");
		q.append("join e.omProduto f");
		q.appendWhere(MapQuery._NULL, "a.ns like :ns ", filtro.getNs() != null && filtro.getNs().equals("") == false);
		q.appendWhere(MapQuery._AND, "e.nrDoc=:nrDoc ", filtro.getNrDoc()!= null&&filtro.getNrDoc().equals("")==false);
		
		if(filtro.getNs()==null){
			filtro.setNs("");
		}
		q.defineParametro("ns", "%"+filtro.getNs()+"%");
		q.defineParametro("nrDoc", filtro.getNrDoc());
		q.setMaxResults(100);
		
		List<DwNserie> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		List<DwNserieDTO> listaRetorno = new ArrayList<DwNserieDTO>();
		//a.id_nserie, a.ns, d.cd_produto
		for(DwNserie dwNserie:listaPesquisa){
			DwNserieDTO dto = new DwNserieDTO(); //dwNserie.getOmProduto().getCdProduto()
			dto.setDwNserie(dwNserie.clone(true));
			listaRetorno.add(dto);
		}
		retorno.setListaDwNserieDTO(listaRetorno);
		return retorno;
	}
	public RastreamentoNSDTO getRastreamentoNS(FiltroRastreamentoNSDTO filtro){
		RastreamentoNSDTO retorno = new RastreamentoNSDTO();
		MapQuery q = new MapQuery(this.getDao().getSession());
	/*	select i.cd_gt, f.cd_folha, a.dthr, e.cd_turno, c.ds_pt, g.ds_nome
		from dw_passagem a
		join dw_nserie b on b.id_nserie = a.id_nserie
		join om_pt c on c.id_pt = a.id_pt
		join dw_consolid d on d.id_consolid = a.id_consolid
		join dw_turno e on e.id_turno = d.id_turno
		join dw_folha f on f.id_folha = d.id_folha
		join om_usr g on g.id_usr = a.id_usroperador
		join om_gt h on h.id_gt = c.id_gt
		join om_gt i on i.id_gt = h.id_gtfase
		where
		b.id_nserie = idEscolhidoNaPesquisa
		and d.st_ativo is not null
		and d.tp_id = 1*/
		q.append("select a");
		q.append("from DwPassagem a");
		q.append("join a.dwNserie b");
		q.append("join a.omPt c");
		q.append("join a.dwConsolid d");
		q.append("join d.dwTurno e");
		q.append("join d.dwFolha f");
		q.append("left join a.omUsrByIdUsroperador g");
		q.append("left join c.omGt h");
		q.append("left join h.omGtfase i");
		q.append("left join d.ppCp ppcp");
		q.append("left join ppcp.ppCpprodutos ppcpproduto");
		
		if (filtro.getIdNs() != null && filtro.getIdNs() != 0) {
			q.append("where b.idNserie=:ns ");
		} else {
			q.append("where b.cb=:cb ");
		}
		q.append("and d.tpId = 1 ");
		if (filtro.getNrDoc() != null && filtro.getNrDoc().equals("") == false) {
			q.append("and ppcpproduto.nrDoc = :doc");
		}
		
		q.defineParametro("ns", filtro.getIdNs());
		q.defineParametro("cb", filtro.getNs());
		q.defineParametro("doc", filtro.getNrDoc());
		
		List<DwPassagem> lpassagemPesquisa =  null;
		try{
			lpassagemPesquisa = q.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		List<RastreamentoLocalDTO>localDTOs = new ArrayList<RastreamentoLocalDTO>();
		for(DwPassagem passagemPesquisa:lpassagemPesquisa){
			DwPassagem passagem = passagemPesquisa.clone(true);
			DwConsolid dwConsolid = passagemPesquisa.getDwConsolid().clone(true);
			OmGt gt = new OmGt();
			if(passagemPesquisa.getOmPt().getOmGt()!=null && passagemPesquisa.getOmPt().getOmGt().getOmGtfase()!=null){
				gt = passagemPesquisa.getOmPt().getOmGt().getOmGtfase().clone(false);
			}
			RastreamentoLocalDTO localDTO = new RastreamentoLocalDTO();
			localDTO.setFase(gt.getDsGt());
			localDTO.setEtapa(dwConsolid.getDwFolha().getCdFolha());
			localDTO.setDthr(DataHoraRN.dateToStringYYYYMMDDHHMMSS(passagem.getDthr()));
			localDTO.setTurno(dwConsolid.getDwTurno().getDsTurno());
			if (passagem.getOmUsrByIdUsroperador() != null)
				localDTO.setOperador(passagem.getOmUsrByIdUsroperador().getDsNome());
			else
				localDTO.setOperador("");
			localDTO.setPosto(passagem.getOmPt().getDsPt());
			localDTOs.add(localDTO);
		}
		retorno.setListalocalDTO(localDTOs);
		
		//select i.cd_gt, b.cb, d.cd_produto, d.ds_produto
		//from dw_passagem a
		//join dw_passmon b on b.id_passagem = a.id_passagem
		//join dw_nserie c on c.id_nserie = a.id_nserie
		//join om_produto d on d.id_produto = b.id_produto
		//join om_pt e on e.id_pt = a.id_pt
		//join om_gt h on h.id_gt = e.id_gt
		//join om_gt i on i.id_gt = h.id_gtfase
		//where
		//c.id_nserie = XXXXx
		//order by a.id_passagem desc

		//obs: a composicao do produto é a soma de todos os dados em dwpassmon
		q.append("select a");
		q.append("from DwPassagem a");
		q.append("join a.dwNserie c");
		q.append("join a.dwPassmons b");
		q.append("join b.omProduto d");
		q.append("join a.omPt e");
		q.append("join c.omGt h");
		q.append("join h.omGtfase i");
		q.append("where c.idNserie=:ns ");
		q.append("order by a.idPassagem desc ");
		
		q.defineParametro("ns", filtro.getIdNs());
		try{
			lpassagemPesquisa = q.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		List<RastreamentoCompAtualDTO>compAtualDTOs = new ArrayList<RastreamentoCompAtualDTO>();
		for(DwPassagem passagemPesquisa:lpassagemPesquisa){
			DwPassagem passagem = passagemPesquisa.clone(true);
			passagem.getOmPt().setOmGt(passagemPesquisa.getOmPt().getOmGt().clone(true));
			for(DwPassmon dwPassmonPesquisa:passagemPesquisa.getDwPassmons()){
				DwPassmon dwPassmon = dwPassmonPesquisa.clone(true); 
				RastreamentoCompAtualDTO compAtualDTO = new RastreamentoCompAtualDTO();
				compAtualDTO.setCdModelo(dwPassmon.getOmProduto().getCdProduto());
				compAtualDTO.setDsModelo(dwPassmon.getOmProduto().getDsProduto());
				compAtualDTO.setNs(passagem.getDwNserie().getCb());
				if (passagem != null && passagem.getOmPt() != null && passagem.getOmPt().getOmGt() != null && passagem.getOmPt().getOmGt().getOmGtfase() != null)
					compAtualDTO.setFase(passagem.getOmPt().getOmGt().getOmGtfase().getCdGt());
				else
					compAtualDTO.setFase("");
				compAtualDTO.setDthr(passagem.getDthr());
				compAtualDTOs.add(compAtualDTO);
			}
			
		}
		retorno.setListacompAtualDTO(compAtualDTOs);
		
		
		return retorno;
	}

	public RastreamentoNaoLidosDTO getRastreamentoNSNaoLido(String nsInicial, String nsFinal) {
		
		RastreamentoNaoLidosDTO retorno = new RastreamentoNaoLidosDTO();
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		/*
		 select a.id_nserie, a.ns, a.id_produto, b.cd_produto, b.ds_produto
		   from dw_nserie a, om_produto b
		  where a.ns between '166164965' and '166164970' 
		    and a.id_nserie not in (select id_nserie from dw_passagem)
		    and a.id_produto = b.id_produto
		order by a.ns asc  
		*/
		q.append("select a");
		q.append("from DwNserie a");
		q.append("join a.omProduto b");
		q.append("where a.ns between :nsini and :nsfim");
		q.append("and a.idNserie not in (select c.dwNserie.idNserie from DwPassagem c)");
		
		q.defineParametro("nsini", nsInicial);
		q.defineParametro("nsfim", nsFinal);
		
		List<DwNserie> listaDwNSerie =  null;
		
		try{
			listaDwNSerie = q.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		List<RastreamentoNaoLidoDTO> nsNaoLidosDTO = new ArrayList<RastreamentoNaoLidoDTO>();
		
		for(DwNserie nseriepesquisa:listaDwNSerie){
			
			DwNserie nserie = nseriepesquisa.clone(true);
			
			RastreamentoNaoLidoDTO nsNaoLidoDTO = new RastreamentoNaoLidoDTO();
			
			nsNaoLidoDTO.setCdmodelo(nserie.getOmProduto().getCdProduto());
			nsNaoLidoDTO.setDsmodelo(nserie.getOmProduto().getDsProduto());
			nsNaoLidoDTO.setNsnaolido(nserie.getNs());
			
			nsNaoLidosDTO.add(nsNaoLidoDTO);
		
		}
		
		retorno.setListaNumeroSerieNaoLidosDTO(nsNaoLidosDTO);
		
		return retorno;

	}

}