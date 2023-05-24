package idw.model.rn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpIndisp;
import idw.model.pojos.PpIndispRappt;
import idw.model.rn.geraplano.dtos.IdCtDTO;
import idw.model.rn.geraplano.dtos.IndisponibilidadeDTO;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoIndisponibilidadeDTO;
import idw.webservices.dto.PlanosIndisponibilidadesDTO;
import idw.webservices.dto.ResultadoDTO;

@SuppressWarnings("serial")
public class PlanoIndisponibilidadeRN extends PlanoIndisponibilidadeDTO implements IDao {

	private DAOGenerico dao;

	public PlanoIndisponibilidadeRN() {
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public PlanoIndisponibilidadeRN(DAOGenerico dao) {
		this.dao = dao;
	}
	public PlanoIndisponibilidadeRN(PlanoIndisponibilidadeDTO planoDTO) {
		super(planoDTO);

		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public PlanosIndisponibilidadesDTO pesquisarPlanos(PlanoIndisponibilidadeDTO plano) {
		PlanosIndisponibilidadesDTO retorno = new PlanosIndisponibilidadesDTO();
		ResultadoDTO resultado = new ResultadoDTO();

		retorno.setResultado(resultado);

		List<PlanoIndisponibilidadeDTO > planos = new ArrayList<PlanoIndisponibilidadeDTO>();

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select distinct ppindisp from PpIndisp ppindisp ");
		q.append("join ppindisp.ppIndispRappts ppindisprappt");

		q.appendWhere(MapQuery._NULL, "ppindisp.stAtivo = :stativo", (plano.getStAtivo() != null));
		q.appendWhere(MapQuery._AND, "ppindisp.cdIndisp = :cdindisp", ((plano.getCdIndisp() != null) && (!plano.getCdIndisp().isEmpty())));
		q.appendWhere(MapQuery._AND, "ppindisp.dsIndisp = :dsindisp", ((plano.getDsIndisp() != null) && (!plano.getDsIndisp().isEmpty())));
		q.appendWhere(MapQuery._AND, "ppindisp.dtRevisao = :dtrevisao", (plano.getDtRevisao() != null));
		q.appendWhere(MapQuery._AND, "ppindisp.dtStativo = :dtstativo", (plano.getDtStativo() != null));
		q.appendWhere(MapQuery._AND, "ppindisp.revisao = :revisao", (plano.getRevisao() != null));
		q.appendWhere(MapQuery._AND, "ppindisp.stIndisp = :stindisp", (plano.getStIndisp() != null));

		q.defineParametro("cdindisp", plano.getCdIndisp());
		q.defineParametro("dsindisp", plano.getDsIndisp());
		q.defineParametro("dtrevisao", plano.getDtRevisao());
		q.defineParametro("dtstativo", plano.getDtStativo());
		q.defineParametro("revisao", plano.getRevisao());
		q.defineParametro("stativo", plano.getStAtivo());
		q.defineParametro("stindisp", plano.getStIndisp());

		List<PpIndisp> listaPojos = null;
		try{
			listaPojos = q.list();	
		}catch(Exception e){
			e.printStackTrace();
		}

		if(listaPojos != null) {
			for(PpIndisp p : listaPojos) {
				PlanoIndisponibilidadeDTO plan = new PlanoIndisponibilidadeDTO(p);

				plan.setPpIndispRappts(new HashSet<PpIndispRappt>());
				for(PpIndispRappt ppindisprappt : p.getPpIndispRappts()) {
					PpIndispRappt ppindisprapptNovo = ppindisprappt.clone();
					ppindisprapptNovo.setPpIndisp(null);
					if (ppindisprappt.getOmPt() != null) {
						ppindisprapptNovo.setOmPt(ppindisprappt.getOmPt().clone());
					}
					if (ppindisprappt.getDwRap() != null) {
						ppindisprapptNovo.setDwRap(ppindisprappt.getDwRap().clone());
					}
					if (ppindisprappt.getDwTParada() != null)
						ppindisprapptNovo.setDwTParada(ppindisprappt.getDwTParada().clone(false));
					
					plan.getPpIndispRappts().add(ppindisprapptNovo);
				}

				planos.add(plan);
			}

			resultado.setIdmensagem(resultado.COM_SUCESSO);
			retorno.setPlanos(planos);
		}

		return retorno;
	}

	public PpIndisp pesquisarPlanoByCdESt() {
		MapQuery q;
		if (this.dao.getSession() != null)
			q = new MapQuery(this.dao.getSession());
		else
			q = new MapQuery(this.dao.getSessionStateless());

		q.append("select ppindisp from PpIndisp ppindisp join fetch ppindisp.ppIndispRappts b join fetch b.omPt c");

		q.appendWhere(MapQuery._NULL, "ppindisp.cdIndisp = :cdindisp", ((this.getCdIndisp() != null) && (!this.getCdIndisp().isEmpty())));
		q.appendWhere(MapQuery._AND, "ppindisp.stAtivo = 1", true);

		q.defineParametro("cdindisp", this.getCdIndisp());

		q.setMaxResults(1);

		return (PpIndisp)q.uniqueResult();
	}

	public PpIndisp pesquisarPlanoById() {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ppindisp from PpIndisp ppindisp");
		q.appendWhere(MapQuery._NULL, "ppindisp.idIndisp = :idindisp", (this.getIdIndisp() != null));

		q.defineParametro("idindisp", this.getIdIndisp());

		q.setMaxResults(1);
		PpIndisp retorno = (PpIndisp)q.uniqueResult();

		return retorno;
	}

	public PlanoIndisponibilidadeDTO salvarRegistro() {
		PlanoIndisponibilidadeDTO retorno = new PlanoIndisponibilidadeDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		//Pesquisar o plano para saber se j� existe, se existir marcar pra excluir
		PpIndisp ppindisp = this.pesquisarPlanoByCdESt();
		if(ppindisp != null) {
			if((this.getIdIndisp() != null) && (this.getIdIndisp() > 0)) {
				PlanoIndisponibilidadeDTO dto = this.excluirRegistro();

				if((dto.getResultadoDTO() != null) && (dto.getResultadoDTO().getIdmensagem() != dto.getResultadoDTO().COM_SUCESSO)) {
					resultadoDTO = dto.getResultadoDTO();
					retorno.setResultadoDTO(resultadoDTO);
					return retorno;
				}
			} else {
				resultadoDTO.setIdmensagem(resultadoDTO.REGISTRO_JA_EXISTE);
				retorno.setResultadoDTO(resultadoDTO);
				return retorno;
			}
		}

		PpIndisp planoNovo = this.clone();

		planoNovo.setIdIndisp(null);
		planoNovo.setStAtivo(1);
		planoNovo.setDtStativo(DataHoraRN.getDataHoraAtual());
		planoNovo.setDtRevisao(DataHoraRN.getDataHoraAtual());

		//verifica a revisao, se ja existe incrementa de 1, seta direto valor 1
		if ((planoNovo.getRevisao() == null) || ((planoNovo.getRevisao() != null) && (planoNovo.getRevisao() <= 0)) ){
			planoNovo.setRevisao(1l);
		} else {
			planoNovo.setRevisao(planoNovo.getRevisao() + 1);
		}

		//verificar usuarios stAtivo e Revisao
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

		planoNovo.setOmUsrByIdUsrstativo(omUsrStAtivo);
		planoNovo.setOmUsrByIdUsrrevisao(omUsrRevisao);


		//verificar PpPlanecs
		Set<PpIndispRappt> lista = null;
		if((this.getPpIndispRappts() != null) && (this.getPpIndispRappts().size() > 0)) {
			lista = new HashSet<PpIndispRappt>();

			for(PpIndispRappt pojo : this.getPpIndispRappts()) {

				OmPt ompt = null;
				DwRap dwrap = null;
				DwTParada dwtparada = null;

				if ((pojo.getTpRecurso() !=null) && (pojo.getTpRecurso().intValue() == 0)){
					PTRN ptrn = new PTRN();
					ptrn.setDaoSession(this.dao.getSession());
					try {
						ompt = ptrn.getOmPt(pojo.getOmPt().getCdPt());
					} catch (RegistroDesconhecidoException e) {
						ompt = null;
					}
					if(ompt == null) {
						resultadoDTO.setIdmensagem(resultadoDTO.PT_DESCONHECIDO);
						return retorno;
					}
				}else{
					DwRapRN rapRN = new DwRapRN(this.dao);
					rapRN.setCdRap(pojo.getDwRap().getCdRap());
					dwrap =  rapRN.pesquisarDwRapByCdRap();
					if(dwrap == null) {
						resultadoDTO.setIdmensagem(resultadoDTO.RAP_DESCONHECIDO);
						return retorno;
					}

				}

				// Determina se a parada existe
				if (pojo.getDwTParada() != null) {
					ParadaRN rn = new ParadaRN(this.dao);
					dwtparada = rn.getDwTParada(pojo.getDwTParada().getIdTparada());
					if (dwtparada == null) {
						resultadoDTO.setIdmensagem(resultadoDTO.ERRO_PARADA_DESCONHECIDA);
						return retorno;
					}
				}



				PpIndispRappt pojoNovo = new PpIndispRappt();

				pojoNovo.setPpIndisp(planoNovo);
				pojoNovo.setDsIndispRappt(pojo.getDsIndispRappt());
				pojoNovo.setDthrFinal(pojo.getDthrFinal());
				pojoNovo.setDthrInicio(pojo.getDthrInicio());
				pojoNovo.setOmPt(ompt);
				pojoNovo.setDwRap(dwrap);
				pojoNovo.setDwTParada(dwtparada);
				pojoNovo.setQtIndisp(pojo.getQtIndisp());
				pojoNovo.setTpRecurso(pojo.getTpRecurso());

				lista.add(pojoNovo);
			}
		}
		planoNovo.setPpIndispRappts(lista);

		planoNovo = this.dao.makePersistent(planoNovo);

		retorno = new PlanoIndisponibilidadeDTO(planoNovo.clone());


		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		retorno.setResultadoDTO(resultadoDTO);

		return retorno;
	}

	public PlanoIndisponibilidadeDTO excluirRegistro() {
		PlanoIndisponibilidadeDTO retorno = this;
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		// Pesquisa o ppnecimp que se deseja excluir
		PpIndisp ppindisp = this.pesquisarPlanoById();

		// Se nao existir o registro desejado para exclusao, entao retornar ao solicitante informando registro desconhecido
		if (ppindisp == null){
			resultadoDTO.setIdmensagem(resultadoDTO.CODIGO_DESCONHECIDO);
			return retorno;
		}

		// Se o registro solicitado para exclusao ja estiver marcado como excluir, retornar ao solicitante informando a situacao
		if(ppindisp.getStAtivo() == 0) {
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
		ppindisp.setStAtivo(0);
		ppindisp.setDtStativo(DataHoraRN.getDataHoraAtual());
		ppindisp.setOmUsrByIdUsrstativo(msusr);

		ppindisp = this.dao.makePersistent(ppindisp);


		retorno = new PlanoIndisponibilidadeDTO(ppindisp);
		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		retorno.setResultadoDTO(resultadoDTO);

		return retorno;
	}
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

	public List<IndisponibilidadeDTO> pesquisarIndisponibilidades(IdwLogger log, int idLog, int identacao, IdCtDTO id){
		List<IndisponibilidadeDTO> retorno = new ArrayList<IndisponibilidadeDTO>();

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ppindisprappt");
		q.append("from PpIndispRappt ppindisprappt");
		q.append("join ppindisprappt.ppIndisp ppindisp");
		q.append("join ppindisprappt.omPt ompt");
		q.append("join ompt.omGt omgt");

		q.appendWhere(MapQuery._NULL, "ppindisp.stIndisp = 1", true);// usar no planejamento
		q.appendWhere(MapQuery._AND, "ppindisprappt.tpRecurso = 0", true);
		q.appendWhere(MapQuery._AND, "ompt = :ompt", id.getOmptEscolhido() != null);
		q.appendWhere(MapQuery._AND, "omgt = :omgt", id.getOmgtEscolhido() != null);


		q.defineParametro("ompt", id.getOmptEscolhido());
		q.defineParametro("omgt", id.getOmgtEscolhido());

		List<PpIndispRappt> lista = q.list();

		for (PpIndispRappt p : lista){
			IndisponibilidadeDTO i = new IndisponibilidadeDTO();

			i.setFim(p.getDthrFinal());
			i.setInicio(p.getDthrInicio());

			retorno.add(i);

			log.info(idLog, identacao, "Encontrada indisponibilidade " + i + " para o ct " + id);
		}

		return retorno;
	}
}
