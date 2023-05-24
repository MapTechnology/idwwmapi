package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpNec;
import idw.model.pojos.PpPlanec;
import idw.model.pojos.PpPlaneccron;
import idw.model.pojos.PpPlano;
import idw.model.pojos.PpTpplano;
import idw.model.rn.exp.injet.ExportacaoInjetFactory;
import idw.util.IdwLogger;
import idw.webservices.dto.PlanoDTO;
import idw.webservices.dto.PlanoListDTO;
import idw.webservices.dto.PpNecDTO;
import idw.webservices.dto.PpNecListDTO;
import idw.webservices.dto.ResultadoDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;

public class PlanoProducaoRN extends PlanoDTO implements IDao {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected transient DAOGenerico dao;

	public DAOGenerico getDao(){
		return this.dao;
	}

	public PlanoProducaoRN() {
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public PlanoProducaoRN(DAOGenerico dao) {
		this.dao = dao;
	}
	
	public void setDao(DAOGenerico dao) {
		this.dao = dao;
	}
	
	public PlanoProducaoRN(PlanoDTO planoDTO) {
		super(planoDTO, null);

 		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}

	public PpPlano pesquisarPlanoByCdESt() {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ppplano from PpPlano ppplano");

		q.appendWhere(MapQuery._NULL, "ppplano.cdPlano = :cdplano", ((this.getCdPlano() != null) && (!this.getCdPlano().isEmpty())));
		q.appendWhere(MapQuery._AND, "ppplano.stAtivo = 1", true);

		q.defineParametro("cdplano", this.getCdPlano());

		q.setMaxResults(1);

		return (PpPlano)q.uniqueResult();
	}

	public PpPlano pesquisarPlanoById() {
		if (this.getIdPlano() == null) {
			return null;
		}

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ppplano from PpPlano ppplano");
		q.appendWhere(MapQuery._NULL, "ppplano.idPlano = :idplano", (this.getIdPlano() != null));

		q.defineParametro("idplano", this.getIdPlano());

		q.setMaxResults(1);
		PpPlano retorno = (PpPlano)q.uniqueResult();

		return retorno;
	}

	public PlanoListDTO pesquisarPlanos(PlanoDTO plano) {
		PlanoListDTO retorno = new PlanoListDTO();
		ResultadoDTO resultado = new ResultadoDTO();

		retorno.setResultado(resultado);

		List<PlanoDTO> planos = new ArrayList<PlanoDTO>();

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select distinct ppplano from PpPlano ppplano ");
		q.append("left join fetch ppplano.ppTpplano pptpplano ");
		q.append("left join fetch ppplano.ppPlanecs ppplanecs ");
		q.append("left join fetch ppplano.dwCal dwcal");

		q.appendWhere(MapQuery._NULL, "ppplano.cdPlano = :cdplano", ((plano.getCdPlano() != null) && (!plano.getCdPlano().isEmpty())));
		q.appendWhere(MapQuery._AND, "ppplano.dsPlano = :dsplano", ((plano.getDsPlano() != null) && (!plano.getDsPlano().isEmpty())));
		q.appendWhere(MapQuery._AND, "ppplano.dthrPrevisaoinicio = :previsaoinicio", (plano.getDthrPrevisaoinicio() != null));
		q.appendWhere(MapQuery._AND, "ppplano.dtRevisao = :dtrevisao", (plano.getDtRevisao() != null));
		q.appendWhere(MapQuery._AND, "ppplano.dtStativo = :dtstativo", (plano.getDtStativo() != null));
		q.appendWhere(MapQuery._AND, "ppplano.revisao = :revisao", (plano.getRevisao() != null));
		q.appendWhere(MapQuery._AND, "ppplano.stAtivo = :stativo", (plano.getStAtivo() != null));
		q.appendWhere(MapQuery._AND, "ppplano.stPlano = :stplano", (plano.getStPlano() != null));
		q.appendWhere(MapQuery._AND, "ppplano.indOee = :indoee", (plano.getIndOee() != null));
		q.appendWhere(MapQuery._AND, "ppplano.ppTpplano = :pptpplano", (plano.getPpTpplano() != null));
		q.appendWhere(MapQuery._AND, "ppplano.isConsiderarrap = :rap", (plano.getIsConsiderarrap() != null));
		q.appendWhere(MapQuery._AND, "ppplano.isConsiderarmp = :mp", (plano.getIsConsiderarmp() != null));
		q.appendWhere(MapQuery._AND, "ppplano.isConsiderarcal = :cal", (plano.getIsConsiderarcal() != null));
		q.appendWhere(MapQuery._AND, "ppplano.isConsiderarindisp = :indisp", (plano.getIsConsiderarindisp() != null));
		q.appendWhere(MapQuery._AND, "ppplano.isConsideraroeefinalserie = :oeefinal", (plano.getIsConsideraroeefinalserie() != null));
		q.appendWhere(MapQuery._AND, "ppplano.isConsiderarprodutoturno = :turno", (plano.getIsConsiderarprodutoturno() != null));
		q.appendWhere(MapQuery._AND, "ppplano.isConsiderarest = :estoque", (plano.getIsConsiderarest() != null));
		q.appendWhere(MapQuery._AND, "ppplano.isConsiderarmo = :maodeobra", (plano.getIsConsiderarmo() != null));
		q.appendWhere(MapQuery._AND, "ppplano.isConsiderarcm = :cm", (plano.getIsConsiderarcm() != null));
		q.appendWhere(MapQuery._AND, "ppplano.isDeterminadocal = :determinadocal", (plano.getIsDeterminadocal() != null));
		q.appendWhere(MapQuery._AND, "dwcal.cdCal = :dwcal_cdcal", ((plano.getDwCal() != null) && (plano.getDwCal().getCdCal() != null)));
		q.appendWhere(MapQuery._AND, "dwcal.dsCal = :dwcal_dscal", ((plano.getDwCal() != null) && (plano.getDwCal().getDsCal() != null)));
		q.appendWhere(MapQuery._AND, "dwcal.stAtivo = 1", ((plano.getDwCal() != null) && ((plano.getDwCal().getCdCal() != null) || (plano.getDwCal().getDsCal() != null))));

		q.defineParametro("cdplano", plano.getCdPlano());
		q.defineParametro("dsplano", plano.getDsPlano());
		q.defineParametro("previsaoinicio", plano.getDthrPrevisaoinicio());
		q.defineParametro("dtrevisao", plano.getDtRevisao());
		q.defineParametro("dtstativo", plano.getDtStativo());
		q.defineParametro("revisao", plano.getRevisao());
		q.defineParametro("stativo", plano.getStAtivo());
		q.defineParametro("stplano", plano.getStPlano());
		q.defineParametro("indoee", plano.getIndOee());
		q.defineParametro("pptpplano", plano.getPpTpplano());
		q.defineParametro("rap", plano.getIsConsiderarrap());
		q.defineParametro("mp", plano.getIsConsiderarmp());
		q.defineParametro("cal", plano.getIsConsiderarcal());
		q.defineParametro("indisp", plano.getIsConsiderarindisp());
		q.defineParametro("oeefinal", plano.getIsConsideraroeefinalserie());
		q.defineParametro("turno", plano.getIsConsiderarprodutoturno());
		q.defineParametro("estoque", plano.getIsConsiderarest());
		q.defineParametro("maodeobra", plano.getIsConsiderarmo());
		q.defineParametro("cm", plano.getIsConsiderarcm());
		q.defineParametro("determinadocal", plano.getIsDeterminadocal());
		if(plano.getDwCal() != null) {
			q.defineParametro("dwcal_cdcal", plano.getDwCal().getCdCal());
			q.defineParametro("dwcal_dscal", plano.getDwCal().getDsCal());
		}

		List<PpPlano> listaPojos = q.list();

		if(listaPojos != null) {
			for(PpPlano p : listaPojos) {
				PlanoDTO plan = new PlanoDTO(p, this.dao);

				plan.setPpPlanecs(new HashSet<PpPlanec>());
				for(PpPlanec planec : p.getPpPlanecs()) {
					PpPlanec ppplanec = planec.clone();
					ppplanec.setPpPlano(null);
					if (planec.getPpNec() != null) {
						ppplanec.setPpNec(planec.getPpNec().clone());
						ppplanec.getPpNec().setOmProduto(planec.getPpNec().getOmProduto().clone());
						ppplanec.getPpNec().setOmUsrByIdUsrrevisao(null);
						ppplanec.getPpNec().setOmUsrByIdUsrstativo(null);
						ppplanec.getPpNec().setPpCliente(null);
						ppplanec.getPpNec().setPpNeccrons(null);
						ppplanec.getPpNec().setPpNecimpurllog(null);
						ppplanec.getPpNec().setPpPlanecs(null);
					}
					plan.getPpPlanecs().add(ppplanec);
				}

				planos.add(plan);
			}

			resultado.setIdmensagem(resultado.COM_SUCESSO);
			retorno.setPlanos(planos);
		}

		return retorno;
	}

	public PlanoDTO firmarPlano(boolean isForcarFirmar) throws SemPlanejamentoException{
		IdwLogger log = new IdwLogger("firmarPlano");
		int idLog = log.getIdAleatorio();
		int identacao = 0;
		
		PlanoDTO retorno = new PlanoDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ppcp");
		q.append("from PpCp ppcp");
		q.append("join fetch ppcp.ppPlano ppplano");
		q.append("where ppplano.idPlano = :idplano");
		q.append("and ppcp.stAtivo = 1");
		q.append("order by ppcp.dthrInicio");

		q.defineParametro("idplano", this.getIdPlano());
		q.setMaxResults(1);

		PpCp ppcp = (PpCp) q.uniqueResult();

		if (ppcp == null) {
			resultadoDTO.setIdmensagem(resultadoDTO.ERROR_PLANO_SEM_CP);
		} else if (ppcp != null && ppcp.getPpPlano() == null) {
			resultadoDTO.setIdmensagem(resultadoDTO.PLANO_DESCONHECIDO);
		} else if (ppcp != null && ppcp.getPpPlano().getStPlano() == 1) { // plano ja esta firmado
			resultadoDTO.setIdmensagem(resultadoDTO.ERROR_PLANO_JA_FIRMADO);
		} else if (ppcp != null && DataHoraRN.before(ppcp.getDthrInicio(), DataHoraRN.getDataHoraAtual()) && isForcarFirmar == false){
			resultadoDTO.setIdmensagem(resultadoDTO.ERROR_PLANO_MUITO_ANTIGO);
		} else {
			resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);

			PpPlano ppplano = ppcp.getPpPlano();

			ppplano.setStPlano(1); // firmado

			this.dao.makePersistent(ppplano);
			
			// desativar todos os outros planos que estejam firmados e ativos
			q = new MapQuery(dao.getSession());
			q.append("update PpPlano ppplano set ppplano.stAtivo = 0 where ppplano.stAtivo = '1' and ppplano.idPlano <> :idplano and ppplano.stPlano = 1");
			q.defineParametro("idplano", ppplano.getIdPlano());
			q.query().executeUpdate();
			
			
			// Se o injet estiver ativo entao exportar as ops para o injet
			if (Stubdelegate.getInstancia().isInjetAtivo() == true) {
				boolean isExportouComSucesso = false;
				int nTentativas = 0;
				do {
					UtilsThreads.pausaNaThread(1500);
					try {
						ExportacaoInjetFactory exp = ExportacaoInjetFactory.getInstance(ExportacaoInjetFactory.Type.OP, 
								log, 
								idLog, 
								identacao, 
								getDao(), 
								null);
						
						exp.exportar(ppplano);
						isExportouComSucesso = true;
					} catch (SemPlanejamentoException e) {
						e.printStackTrace();
						nTentativas++;
					}
					if (nTentativas > 5)
						break;
				} while (isExportouComSucesso == false);
				
				if (isExportouComSucesso == false) {
					// Aborta firmacao do plano
					throw new SemPlanejamentoException();
				}
			}
		}

		return retorno;
	}
	public PlanoDTO salvarRegistro() {
		PlanoDTO retorno = new PlanoDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		//Pesquisar o plano para saber se já existe, se existir marcar pra excluir
		PpPlano ppplano = this.pesquisarPlanoByCdESt();
		if(ppplano != null) {
			if((this.getIdPlano() != null) && (this.getIdPlano() > 0)) {
				PlanoDTO dto = this.excluirRegistro();

				if((dto.getResultadoDTO() != null) && (dto.getResultadoDTO().getIdmensagem() != dto.getResultadoDTO().COM_SUCESSO)) {
					retorno.setResultadoDTO(dto.getResultadoDTO());
					return retorno;
				}
			} else {
				resultadoDTO.setIdmensagem(resultadoDTO.REGISTRO_JA_EXISTE);
				return retorno;
			}
		}

		PpPlano planoNovo = this.clone();

		planoNovo.setIdPlano(null);
		planoNovo.setStAtivo(1);
		planoNovo.setDtStativo(DataHoraRN.getDataHoraAtual());
		planoNovo.setDtRevisao(DataHoraRN.getDataHoraAtual());
		planoNovo.setIsSimular(true); // toda vez que salvar o plano setar a necessidade de uma nova simulacao

		//verifica a revisao, se ja existe incrementa de 1, seta direto valor 1
		if ((planoNovo.getRevisao() == null) || ((planoNovo.getRevisao() != null) && (planoNovo.getRevisao() <= 0)) ){
			planoNovo.setRevisao(1);
		} else {
			planoNovo.setRevisao(planoNovo.getRevisao() + 1);
		}

		//verificar a existencia do DwCal
		DwCal dwcal = null;
		if(this.getDwCal() != null) {
			CalendarioRN calRN = new CalendarioRN();
			calRN.setSession(this.dao.getSession());
			dwcal = calRN.pesquisarDwCalByCdESt(this.getDwCal());

			if(dwcal == null) {
				resultadoDTO.setIdmensagem(resultadoDTO.CALENDARIO_DESCONHECIDO);
				return retorno;
			}
		}
		planoNovo.setDwCal(dwcal);

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

		//verificar o PpTpplano
		PpTpplano tpplano = null;
		if(this.getPpTpplano() != null) {
			PpTpplanoRN tpplanoRN = new PpTpplanoRN(this.dao);
			tpplano = tpplanoRN.pesquisarTpPlanoById(this.getPpTpplano());

			if(tpplano == null) {
				resultadoDTO.setIdmensagem(resultadoDTO.TIPO_PLANO_DESCONHECIDO);
				return retorno;
			}
		}
		planoNovo.setPpTpplano(tpplano);

		//verificar PpPlanecs
		Set<PpPlanec> listaPlanecs = null;
		if((this.getPpPlanecs() != null) && (this.getPpPlanecs().size() > 0)) {
			listaPlanecs = new HashSet<PpPlanec>();

			for(PpPlanec planec : this.getPpPlanecs()) {
				PpNec ppnec = this.pesquisarNecById(planec.getPpNec());

				if(ppnec == null) {
					resultadoDTO.setIdmensagem(resultadoDTO.NECESSIDADE_DESCONHECIDA);
					return retorno;
				}

				PpPlanec ppplanec = new PpPlanec();
				ppplanec.setPpPlano(planoNovo);
				ppplanec.setPpNec(ppnec);
				ppplanec.setPrioridade(planec.getPrioridade());

				listaPlanecs.add(ppplanec);
			}
		}
		planoNovo.setPpPlanecs(listaPlanecs);

		planoNovo = this.dao.makePersistent(planoNovo);

		retorno = new PlanoDTO(planoNovo, this.dao);
		retorno.setPpPlanecs(new HashSet<PpPlanec>());

		if(planoNovo.getPpPlanecs() != null) {
			for(PpPlanec planec : planoNovo.getPpPlanecs()) {
				PpPlanec ppplanec = planec.clone();
				ppplanec.setPpPlano(null);
				if (planec.getPpNec() != null) {
					ppplanec.setPpNec(planec.getPpNec().clone());
					ppplanec.getPpNec().setOmProduto(planec.getPpNec().getOmProduto().clone());
					ppplanec.getPpNec().setOmUsrByIdUsrrevisao(null);
					ppplanec.getPpNec().setOmUsrByIdUsrstativo(null);
					ppplanec.getPpNec().setPpCliente(null);
					ppplanec.getPpNec().setPpNeccrons(null);
					ppplanec.getPpNec().setPpNecimpurllog(null);
					ppplanec.getPpNec().setPpPlanecs(null);
				}
				retorno.getPpPlanecs().add(ppplanec);
			}
		}

		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		retorno.setResultadoDTO(resultadoDTO);

		return retorno;
	}

	public PlanoDTO excluirRegistro() {
		PlanoDTO retorno = this;
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		// Pesquisa o ppnecimp que se deseja excluir
		PpPlano ppplano = this.pesquisarPlanoById();

		// Se nao existir o registro desejado para exclusao, entao retornar ao solicitante informando registro desconhecido
		if (ppplano == null){
			resultadoDTO.setIdmensagem(resultadoDTO.CODIGO_DESCONHECIDO);
			return retorno;
		}

		// Se o registro solicitado para exclusao ja estiver marcado como excluir, retornar ao solicitante informando a situacao
		if(ppplano.getStAtivo() == 0) {
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
		ppplano.setStAtivo(0);
		ppplano.setDtStativo(DataHoraRN.getDataHoraAtual());
		ppplano.setOmUsrByIdUsrstativo(msusr);

		ppplano = this.dao.makePersistent(ppplano);


		retorno = new PlanoDTO(ppplano.clone(), this.dao);
		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		retorno.setResultadoDTO(resultadoDTO);

		return retorno;
	}

	public PpNec pesquisarNecById(PpNec ppnec) {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ppnec from PpNec ppnec");

		q.appendWhere(MapQuery._NULL, "ppnec.idNec = :idnec", ((ppnec.getIdNec() != null) && (ppnec.getIdNec() > 0)));

		q.defineParametro("idnec", ppnec.getIdNec());

		q.setMaxResults(1);

		return (PpNec)q.uniqueResult();
	}

	public PpNecListDTO pesquisarPpNecs(Date dtReferencia) {
		boolean isPesquisarDatas = false;
		Date d1 = null; // d1 pode ser usada para filtrar os pedidos de cliente em um periodo junto com d2
		Date d2 = null;

		if (dtReferencia != null){

			d1 = DataHoraRN.setDiaNaData(dtReferencia, 1);
			d2 = DataHoraRN.adicionaMesNaData(d1, 1);
			d2 = DataHoraRN.subtraiDiasDaData(d2, 1);
			
			d1 = DataHoraRN.getDataSemHora(d1);
			d2 = DataHoraRN.setHoraNaData(d2, 23, 59, 59, 59);

			isPesquisarDatas = true;
		}

		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select distinct ppnec ");
		q.append("from PpNec ppnec");
		q.append("left join ppnec.ppNeccrons ppneccron");
		q.append("left join fetch ppnec.omProduto omproduto");

		q.appendWhere(MapQuery._NULL,"ppneccron.dtDesejada between ? and ? ", isPesquisarDatas == true);
		q.appendWhere(MapQuery._AND, "ppnec.stAtivo = 1", true);

		q.query().setTimestamp(0, d1);
		q.query().setTimestamp(1, d2);

		List<PpNec> listaPpNec = q.list();

		PpNecListDTO retorno = new PpNecListDTO();
		retorno.setPpNecDTO(new ArrayList<PpNecDTO>());
		
		RoteiroRN roteiroRN = new RoteiroRN();
		//roteiroRN.setSession(this.dao.getSession());
		roteiroRN.setDaoSession(this.dao.getSession());

		for(PpNec ppnec : listaPpNec) {
			
			PpNecDTO ppNecDTO = new PpNecDTO(ppnec);
			ppNecDTO.setPpPlanecs(null);
			ppNecDTO.setOmUsrByIdUsrrevisao(null);
			ppNecDTO.setOmUsrByIdUsrstativo(null);
			ppNecDTO.setPpNeccrons(null);
			ppNecDTO.setPpCliente(null);
			ppNecDTO.setOmProduto(ppnec.getOmProduto().clone());
			ppNecDTO.getResultadoDTO().setIdmensagem(ppNecDTO.getResultadoDTO().getCOM_SUCESSO());
			// Verifica se o produto possui roteiro, se possuir, ent�o a necessidade está apta a ser usada
			if (roteiroRN.pesquisarDwRotaByIdProduto(ppNecDTO.getOmProduto(),false) == null){
				ppNecDTO.getResultadoDTO().setIdmensagem(ppNecDTO.getResultadoDTO().getROTEIRO_INCONSISTENTE());
			}
			retorno.getPpNecDTO().add(ppNecDTO);
		}

		return retorno;
	}

	public void excluirTodosOsPpPlaneccron(PpPlano ppplano){
		Iterator<PpPlaneccron> i = ppplano.getPpPlaneccrons().iterator();
		while (i.hasNext() == true){
			PpPlaneccron p = i.next();
			this.dao.makeTransient(p);
			i.remove();
		}
		
		this.dao.flushReiniciandoTransacao();
	}

	public void excluirTodosAsCps(PpPlano ppplano){
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("update PpCp ppcp set ppcp.stAtivo = 0 where ppcp.stAtivo = '1' and ppcp.ppPlano.idPlano = " + ppplano.getIdPlano());
		q.query().executeUpdate();
	}
	
	public void cancelarPlanosFirmados() {
		MapQuery q = new MapQuery(this.dao.getSession());
		q.append("update PpPlano ppplano set ppplano.stPlano = 2 where ppplano.stPlano = 1");
		q.query().executeUpdate();
	}
	public void limparTodasAsReservasNoEstoque(){
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("update DwEstpro dwestpro set dwestpro.qtReservada = null where dwestpro.qtReservada is not null");
		q.query().executeUpdate();
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
	
	public PpPlano getUltimoPlanoAtivoStPlano0(){
		MapQuery q;
		if (dao.getSession() != null)
			q = new MapQuery(this.dao.getSession());
		else
			q = new MapQuery(dao.getSessionStateless());
		
		q.append("FROM PpPlano plano");
		q.append("WHERE plano.stAtivo = :stAtivo");
		q.append("AND plano.stPlano = :stPlano");
		q.append("ORDER BY plano.idPlano DESC");
		q.defineParametro("stAtivo", 1);
		q.defineParametro("stPlano", 0);
		q.setMaxResults(1);
		return (PpPlano) q.uniqueResult();
	}

}
