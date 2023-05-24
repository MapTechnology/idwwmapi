package idw.model.rn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwRotaDAO;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.dao.PpNecDAO;
import idw.model.dao.PpPlanecDAO;
import idw.model.dao.PpPlanoDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RoteiroDesconhecidoException;
import idw.model.excessoes.TipoPostoDesconhecidoException;
import idw.model.excessoes.UsuarioDesconhecidoException;
import idw.model.pojos.DwRota;
import idw.model.pojos.DwRotapasso;
import idw.model.pojos.DwRpPredecessora;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpNec;
import idw.model.pojos.PpNeccron;
import idw.model.pojos.PpNecimp;
import idw.model.pojos.PpNecimplog;
import idw.model.pojos.PpNecimpurl;
import idw.model.pojos.PpNecimpurllog;
import idw.model.pojos.PpPlanec;
import idw.model.pojos.PpPlano;
import idw.model.pojos.template.PpPlanoTemplate.TpPlano;
import idw.model.rn.geraplano.dtos.PassosDTO;
import idw.model.rn.geraplano.dtos.ProdutoComparable;
import idw.model.rn.integracao.semptoshiba.IntegracaoEstruturaProduto;
import idw.model.rn.integracao.semptoshiba.trilha.ExportacaoTrilha;
import idw.util.IdwLogger;
import idw.webservices.dto.ClienteDTO;
import idw.webservices.dto.CpDTO;
import idw.webservices.dto.ListaCPDTO;
import idw.webservices.dto.PpNecDTO;
import idw.webservices.dto.PpNecListDTO;
import idw.webservices.dto.PpNeccronDTO;
import idw.webservices.dto.PpNecimpDTO;
import idw.webservices.dto.PpNecimpurlDTO;
import idw.webservices.dto.ProdutoDTO;
import idw.webservices.dto.ProdutoSemiAcabadoDTO;
import idw.webservices.dto.ProdutosSemiAcabadosDTO;
import idw.webservices.dto.ResultadoDTO;

public class PedidoClienteRN extends PpNecDTO implements IDao {

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

	public PedidoClienteRN(){
		if (this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	
	public PedidoClienteRN(DAOGenerico dao){
		this.dao = dao;
	}
	
	public PedidoClienteRN(PpNecDTO ppNecDTO){
		super(ppNecDTO);
		if (this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}

	public PpNecListDTO pesquisar(PpNecDTO ppNecDTO){
		PpNecListDTO retorno = new PpNecListDTO();
		List<PpNecDTO> ppNecDTO_lista = new ArrayList<PpNecDTO>();
		boolean isPesquisarDatas = false;
		Date d1 = null; // d1 pode ser usada para filtrar os pedidos de cliente em um periodo junto com d2
		Date d2 = null;

		if ((ppNecDTO.getNrDoc() != null) && (ppNecDTO.getNrDoc().equals("") == false) &&
				(ppNecDTO.getUrlOrigem() != null) && (ppNecDTO.getUrlOrigem().equals("") == false)){
			int ano = 0;
			int mes = 0;

			ano  = Integer.parseInt(ppNecDTO.getNrDoc());
			mes = Integer.parseInt(ppNecDTO.getUrlOrigem());

			d1 = DataHoraRN.getData(ano, mes, 1);
			d2 = DataHoraRN.adicionaMesNaData(d1, 1);
			d2 = DataHoraRN.subtraiDiasDaData(d2, 1);

			isPesquisarDatas = true;
		}

		PpNecDAO dao = new PpNecDAO(this.dao.getSession());
		List<PpNec> lista = dao.getPpNecs(ppNecDTO, d1, d2, isPesquisarDatas);

		for (PpNec ppNec : lista){
			PpNecDTO p = new PpNecDTO(ppNec.clone());
			ppNecDTO_lista.add(p);
		}
		retorno.setPpNecDTO(ppNecDTO_lista);
		return retorno;
	}

	public PpNecDTO salvarRegistro() {

		PpNecDTO retorno =  new PpNecDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		PpNecDAO ppNecDAO = new PpNecDAO(dao.getSession());
		PpNec ppnec = ppNecDAO.getPpNecPorCdAtivo(this.getCdNec());

		// Se existir o registro, entao marca-lo como removido
		if (ppnec != null) {
			if ((this.getIdNec() == null) || (this.getIdNec() == 0)){
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.REGISTRO_JA_EXISTE).intValue());
				return retorno;
			}
			this.excluirRegistro();
		}

		PpNec ppNecNovo = this.clone();

		ppNecNovo.setIdNec(null);
		ppNecNovo.setStAtivo(1); //(char)'1'
		ppNecNovo.setDtRevisao(DataHoraRN.getDataHoraAtual());
		ppNecNovo.setDtStativo(DataHoraRN.getDataHoraAtual());

		// Define o numero da revisao
		if ((ppNecNovo.getRevisao() == null) || ((ppNecNovo.getRevisao() != null) && (ppNecNovo.getRevisao() <= 0)) ){
			ppNecNovo.setRevisao((long) 1);
		} else {
			ppNecNovo.setRevisao(ppNecNovo.getRevisao() + 1);
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

		ppNecNovo.setOmUsrByIdUsrstativo(omUsrStAtivo);
		ppNecNovo.setOmUsrByIdUsrrevisao(omUsrRevisao);

		//pesquisa o Produto para verificar a consistencia da Chave
		OmProduto omproduto = null;

		if ((this.getOmProduto() != null) && (this.getOmProduto().getCdProduto() != null)){
			ProdutoRN pRN = new ProdutoRN(this.dao);
			
			try {
				omproduto = pRN.getOmProduto(this.getOmProduto().getCdProduto());
			} catch (RegistroDesconhecidoException e) {
				resultadoDTO.setIdmensagem(resultadoDTO.getPRODUTO_DESCONHECIDO());
				return retorno;
			}
		}
		ppNecNovo.setOmProduto(omproduto);


		//pesquisa o Cliente para verificar a consistencia da Chave
		PpCliente ppCliente = null;
		if ((this.getPpCliente() != null) && (this.getPpCliente().getCdCliente() != null) ){
			ClienteRN cRN = new ClienteRN(this.dao);
			ppCliente = cRN.pesquisarByCdClienteEStAtivo(this.getPpCliente().getCdCliente());
			if (ppCliente == null){
				resultadoDTO.setIdmensagem(resultadoDTO.getCODIGO_DESCONHECIDO());
				return retorno;
			}
		}
		ppNecNovo.setPpCliente(ppCliente);


		if((ppNecNovo.getPpNeccrons() != null) && (ppNecNovo.getPpNeccrons().size() > 0)) {
			// Interage sobre os registros para setar o pai com o objetivo de salvar por cascata
			for (PpNeccron pnecron : ppNecNovo.getPpNeccrons()){
				pnecron.setIdNeccron(null);
				pnecron.setPpNec(ppNecNovo);
			}
		}

		this.dao.makePersistent(ppNecNovo);

		// Substitui o idNecNovo em pp_planec, visto que uma nova definicao de necessidade existe
		if (ppnec != null) {
			PpPlanecDAO dao = new PpPlanecDAO(this.dao.getSession());
			dao.atualizarRefDePpNecEmPpPlanec(ppnec, ppNecNovo);
		}

		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		PpNecDTO resultadoPersistent = new PpNecDTO(ppNecNovo.clone());
		resultadoPersistent.setResultadoDTO(resultadoDTO);
		retorno = resultadoPersistent;
		return retorno;
	}
	
	public PpNecListDTO salvarRegistroIntegracao(PpNecListDTO ppnecList) {
		PpNecListDTO ppRetorno = new PpNecListDTO();
		ppRetorno.setPpNecDTO(new ArrayList<PpNecDTO>());
		List<PpNecDTO> listaPlanos = ppnecList.getPpNecDTO();
		TpptRN tpptRN = new TpptRN(dao);
		OmTppt omtpptCIC = new OmTppt();		
		omtpptCIC.setCdTppt("CIC");
		omtpptCIC = tpptRN.getOmTpptDTO(omtpptCIC);
		tpptRN = null;
		for(PpNecDTO ppnec : listaPlanos) {
			ppnec.setResultadoDTO(new ResultadoDTO());
			String cdPt = null;
			if(ppnec.getOmPt() != null){
				cdPt = ppnec.getOmPt().getCdPt();
			}			
			//verificar a existencia do ppnecimpurl antes de continuar
			PpNecDAO ppNecDAO = new PpNecDAO(dao.getSession());
			PpNec ppNecAnterior = ppNecDAO.getPpNecAtivoPorCdOuCdPt(ppnec.getCdNec(), cdPt);

			PpNec ppNecNovo = null;

			// Se existir o registro, entao marca-lo como removido
			if (ppNecAnterior != null) {
				
				PpNecDTO dto = this.excluirRegistroImportacaoSemBusca(ppNecAnterior);
				
				// Se excluiu com sucesso, ele clona o plano excluido, senao retorna erro. Ou seja, o registro anterior eh usado como base para o proximo
				if((dto.getResultadoDTO() != null) && (dto.getResultadoDTO().getIdmensagem() == dto.getResultadoDTO().COM_SUCESSO)) {
					ppNecNovo = ppNecAnterior.clone();
				} else {
					ppRetorno.setResultadoDTO(dto.getResultadoDTO());
				}
			} else {
				ppNecNovo = new PpNec();
			}

			ppNecNovo.setIdNec(null);
			ppNecNovo.setStAtivo(1); //(char)'1'
			ppNecNovo.setDtRevisao(ppnec.getDtRevisao());
			ppNecNovo.setDtStativo(DataHoraRN.getDataHoraAtual());
			ppNecNovo.setUrlOrigem(null);
			ppNecNovo.setCdNec(ppnec.getCdNec());

			//Tipo necessidade do cliente - 0
			ppNecNovo.setTpNec(ppnec.getTpNec());
			ppNecNovo.setNrDoc(ppnec.getNrDoc());

			// Define o numero da revisao
			if ((ppNecNovo.getRevisao() == null) || ((ppNecNovo.getRevisao() != null) && (ppNecNovo.getRevisao() <= 0)) ){
				ppNecNovo.setRevisao((long) 1);
			} else {
				ppNecNovo.setRevisao(ppNecNovo.getRevisao() + 1);
			}

			//pesquisa o Usuario do stativo
			OmUsr omUsrStAtivo = null;
			OmUsr omUsrRevisao = null;
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.setDaoSession(this.dao.getSession());

			omUsrStAtivo = usuarioRN.getDao().findById(OmUsr.class, ppnec.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrStAtivo == null) {
				ppnecList.getResultadoDTO().setIdmensagem(Integer.valueOf(ppnecList.getResultadoDTO().USUARIO_DESCONHECIDO).intValue());
				return ppnecList;
			}

			omUsrRevisao = usuarioRN.getDao().findById(OmUsr.class, ppnec.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrRevisao == null) {
				ppRetorno.getResultadoDTO().setIdmensagem(Integer.valueOf(ppRetorno.getResultadoDTO().USUARIO_DESCONHECIDO).intValue());
				return ppRetorno;
			}

			ppNecNovo.setOmUsrByIdUsrstativo(omUsrStAtivo);
			ppNecNovo.setOmUsrByIdUsrrevisao(omUsrRevisao);

			//pesquisa o Produto para verificar a consistencia da Chave
			ProdutoRN produtoRN = new ProdutoRN(this.dao);
			produtoRN.setDaoSession(this.dao.getSession());
			OmProduto omproduto = new OmProduto();
			try {
				
				omproduto = produtoRN.getOmProduto(ppnec.getOmProduto().getCdProduto());

			// Sen�o encontrar tenta integrar
			} catch (RegistroDesconhecidoException e) {
				
				omproduto = ppnec.getOmProduto();
				omproduto.setTpProduto((byte) 1);
				
				ProdutoDTO prod = new ProdutoDTO();
				prod.setResultadoEvento(prod.getERRO_DESCONHECIDO());
				prod.setProduto(omproduto);
				try{
					prod = IntegracaoEstruturaProduto.integrarProdutoComTransacaoInterna(prod, null, null);
				}catch(Exception e2){
				}					
				
				if(prod.getResultadoEvento() != prod.getEVENTO_BEM_SUCEDIDO()){
					ppnec.getResultadoDTO().setIdmensagem(ppnec.getResultadoDTO().PRODUTO_DESCONHECIDO);
					ppRetorno.getPpNecDTO().add(ppnec);	
					continue;
				}
				
			}

			ppNecNovo.setOmProduto(omproduto);
			ppNecNovo.setHrLeadtime(omproduto.getHrLeadtimesaida());

			// Pesquisar o PT se nao existir incluir um novo automaticamente
			PTRN ptrn = new PTRN(this.dao);
			OmPt ompt = null;
			
			try {
				ompt = ptrn.getOmPtCriaSeNaoExistir(ppnec.getOmPt().getCdPt(), omtpptCIC, omUsrStAtivo, "Pt incluido automaticamente na integracao da necessidade", ExportacaoTrilha.ISPLANGT_PARA_GERAR_ARQUIVO_RECURSOS);
			} catch (UsuarioDesconhecidoException e) {
				ppnec.getResultadoDTO().setIdmensagem(ppnec.getResultadoDTO().USUARIO_DESCONHECIDO);
				ppRetorno.getPpNecDTO().add(ppnec);				
				continue;
			} catch (TipoPostoDesconhecidoException e) {
				ppnec.getResultadoDTO().setIdmensagem(ppnec.getResultadoDTO().TIPO_PT_DESCONHECIDO);
				ppRetorno.getPpNecDTO().add(ppnec);				
				continue;
			}

			ppNecNovo.setOmPt(ompt);
			
			//pesquisa o Cliente para verificar a consistencia da Chave
			ClienteRN clienteRN = new ClienteRN(this.dao);
			ClienteDTO clienteDTO = new ClienteDTO();
				
 			PpCliente ppcliente = null;
			
			// Abaixo foi mudado a origem do cliente de ppnec.getPpCliente().getCdCliente() para o cliente definido no produto
			// Isso foi feito pois a origem do cliente anterior vinha da planilha que em geral é inconsistente
			if (omproduto != null && omproduto.getPpCliente() != null && omproduto.getPpCliente().getCdCliente() != null) {
				clienteDTO.setCdCliente(omproduto.getPpCliente().getCdCliente());
				ppcliente = clienteRN.pesquisar(clienteDTO);
			}

			/* Alessandre em 12-07-16 desabilitado pra seguir na importacao do pedido na inventus
			if(ppcliente == null) {
				ppnec.getResultadoDTO().setIdmensagem(ppnec.getResultadoDTO().IMP_CLIENTE_DESCONHECIDO);
				ppRetorno.getPpNecDTO().add(ppnec);
				continue; 
			}*/
			
			ppNecNovo.setPpCliente(ppcliente);
			ppNecNovo.setPpNeccrons(null);

			boolean isExisteProducao = false;
			
			if((ppnec.getPlano() != null) && (!ppnec.getPlano().isEmpty())) {
				ppNecNovo.setPpNeccrons(new HashSet<PpNeccron>());
				for(PpNeccronDTO neccron : ppnec.getPlano()) {
					PpNeccron ppNeccronNovo = neccron.clone(false);
					ppNeccronNovo.setIdNeccron(null);
					ppNeccronNovo.setPpNec(ppNecNovo);
					isExisteProducao = true;
					ppNecNovo.getPpNeccrons().add(ppNeccronNovo);
				}
			}

			// gera o log de importacao com sucesso
			if (isExisteProducao == true){
				ppNecNovo = this.dao.makePersistent(ppNecNovo);
				ppnec.getResultadoDTO().setIdmensagem(ppnec.getResultadoDTO().COM_SUCESSO);
				ppRetorno.getPpNecDTO().add(ppnec);
				
				// Apos salvar o pedido verificar se existia um anterior. Se existia, entao alterar os ids de ppnec nos planos nec
				if (ppNecAnterior != null) {
					PpPlanoDAO ppPlanoDAO = new PpPlanoDAO(dao.getSession());
					ppPlanoDAO.marcarPlanosParaSeremSimulados(ppNecAnterior, ppNecNovo);
					
					PpPlanecDAO planecDAO = new PpPlanecDAO(dao.getSession());
					planecDAO.atualizarRefDePpNecEmPpPlanec(ppNecAnterior, ppNecNovo);
				}				
			} 
		}

		ppRetorno.getResultadoDTO().setIdmensagem(ppnecList.getResultadoDTO().COM_SUCESSO);

		return ppRetorno;

	}

	/*
	 * Esse metodo eh chamado para salvar os registros de pedidos de cliente vindos pela importacao
	 * das planilhas
	 */
	public PpNecListDTO salvarRegistroImportacao(PpNecListDTO ppnecList) {

		PpNecListDTO retorno =  new PpNecListDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		//verificar primeiro a existencia do Log geral, se nao existir: criar
		PpNecimplogRN ppnecimplogRN = new PpNecimplogRN(this.dao);
		PpNecimplog ppnecimplog = null;

		if (ppnecList.getPpnecimplog() != null){
			ppnecimplog = ppnecimplogRN.pesquisarById(ppnecList.getPpnecimplog().getIdNecimplog());
		}

		if(ppnecimplog == null) {
			ppnecimplog = new PpNecimplog();
			ppnecimplog.setIdNecimplog(null);
			ppnecimplog.setMesReferencia(ppnecList.getMesReferencia());
			ppnecimplog.setAnoReferencia(ppnecList.getAnoReferencia());
			ppnecimplog.setDthrIimportacao(ppnecList.getDthrInicioGeral());
			ppnecimplog.setDthrFimportacao(ppnecList.getDthrFimportacao());

			UsuarioRN usrRN = new UsuarioRN();
			usrRN.setDaoSession(this.dao.getSession());
			OmUsr usrAux = usrRN.getDao().findById(OmUsr.class, ppnecList.getOmusr().getIdUsr(), false);

			if(usrAux == null) {
				resultadoDTO.setIdmensagem(resultadoDTO.USUARIO_DESCONHECIDO);
				return retorno;
			}
			ppnecimplog.setOmUsr(usrAux);

			PpNecimpRN ppnecimpRN = new PpNecimpRN(this.dao);
			PpNecimpDTO ppnecimpDTO = new PpNecimpDTO();
			ppnecimpDTO.setIdNecimp(ppnecList.getPpnecimp().getIdNecimp());
			PpNecimp ppnecimp = ppnecimpRN.pesquisar(ppnecimpDTO);

			if(ppnecimp == null) {
				resultadoDTO.setIdmensagem(resultadoDTO.NECIMP_DESCONHECIDO);
				return retorno;
			}
			ppnecimplog.setPpNecimp(ppnecimp);
			ppnecimplog.setPpNecimpurllogs(null);
			ppnecimplog = this.dao.makePersistent(ppnecimplog);
		} else {
			ppnecimplog.setDthrFimportacao(ppnecList.getDthrFimportacao());
			ppnecimplog = this.dao.makePersistent(ppnecimplog);
		}
		retorno.setPpnecimplog(ppnecimplog.clone());

		//terminou PpNecimpurllog

		List<PpNecDTO> listaPlanos = ppnecList.getPpNecDTO();

		for(PpNecDTO ppnec : listaPlanos) {
			//inserir PpNecimpurllog primeiro
			PpNecimpurllog ppnecimpurllog = new PpNecimpurllog();
			ppnecimpurllog.setIdNecimpurllog(null);
			ppnecimpurllog.setPpNecimplog(ppnecimplog);

			//v/rificar a existencia do ppnecimpurl antes de continuar
			PpNecimpurlRN ppnecimpurlRN = new PpNecimpurlRN(this.dao);
			PpNecimpurlDTO ppnecimpurlDTO = new PpNecimpurlDTO();
			ppnecimpurlDTO.setIdNecimpurl(ppnecList.getPpnecimpurl().getIdNecimpurl());
			PpNecimpurl ppnecimpurl = ppnecimpurlRN.pesquisar(ppnecimpurlDTO);

			if(ppnecimpurl == null) {
				resultadoDTO.setIdmensagem(resultadoDTO.IMP_PPNECIMPURL_DESCONHECIDO);
				return retorno;
			}
			ppnecimpurllog.setPpNecimpurl(ppnecimpurl);
			ppnecimpurllog.setDthrIimportacao(ppnecList.getDthrIimportacao());
			ppnecimpurllog.setDthrFimportacao(ppnecList.getDthrFimportacao());
			ppnecimpurllog.setUrlArquivo(ppnecList.getUrlArquivo());
			ppnecimpurllog.setAba(ppnecList.getAba());

			/*
			 * 09/09/2013 - Milton, adicionei novo parametro para pesquisarPpnecByCdEStImportacao, com o cdPt. 
			 * Se estiver diferente de null, faz filtro pelo Pt. 
			 * Até esta data, vi que ppnec.getOmPt() nunca estará diferente de null
			 */
			String cdPt = null;
			if(ppnec.getOmPt() != null){
				cdPt = ppnec.getOmPt().getCdPt();
			}
			
			PpNecDAO ppNecDAO = new PpNecDAO(dao.getSession());
			PpNec ppNecAnterior = ppNecDAO.getPpNecAtivoPorCdOuCdPt(ppnec.getCdNec(), cdPt);

			PpNec ppNecNovo = null;

			// Se existir o registro, entao marca-lo como removido
			if (ppNecAnterior != null) {
				PpNecDTO dto = this.excluirRegistroImportacaoSemBusca(ppNecAnterior);
				
				// Se excluiu com sucesso, ele clona o plano excluido, senao retorna erro. Ou seja, o registro anterior eh usado como base para o proximo
				if((dto.getResultadoDTO() != null) && (dto.getResultadoDTO().getIdmensagem() == dto.getResultadoDTO().COM_SUCESSO)) {
					ppNecNovo = ppNecAnterior.clone();
				} else {
					resultadoDTO = dto.getResultadoDTO();
					retorno.setResultadoDTO(resultadoDTO);
					return retorno;
				}
			} else {
				ppNecNovo = new PpNec();
			}

			ppNecNovo.setIdNec(null);
			ppNecNovo.setStAtivo(1); //(char)'1'
			ppNecNovo.setDtRevisao(ppnec.getDtRevisao());
			ppNecNovo.setDtStativo(DataHoraRN.getDataHoraAtual());
			ppNecNovo.setUrlOrigem(null);
			ppNecNovo.setCdNec(ppnec.getCdNec());

			//Tipo necessidade do cliente - 0
			ppNecNovo.setTpNec(ppnec.getTpNec());
			ppNecNovo.setNrDoc(ppnec.getNrDoc());

			ppNecNovo.setPpNecimpurllog(ppnecimpurllog);

			// Define o numero da revisao
			if ((ppNecNovo.getRevisao() == null) || ((ppNecNovo.getRevisao() != null) && (ppNecNovo.getRevisao() <= 0)) ){
				ppNecNovo.setRevisao((long) 1);
			} else {
				ppNecNovo.setRevisao(ppNecNovo.getRevisao() + 1);
			}

			//pesquisa o Usuario do stativo
			OmUsr omUsrStAtivo = null;
			OmUsr omUsrRevisao = null;
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.setDaoSession(this.dao.getSession());

			omUsrStAtivo = usuarioRN.getDao().findById(OmUsr.class, ppnec.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrStAtivo == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				ppnecimpurllog.setStImp(0);
				ppnecimpurllog.setDsErro("Usuario St. Ativo desconhecido");
				ppnecimpurllog = this.dao.makePersistent(ppnecimpurllog);
				return retorno;
			}

			omUsrRevisao = usuarioRN.getDao().findById(OmUsr.class, ppnec.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omUsrRevisao == null) {
				resultadoDTO.setIdmensagem(Integer.valueOf(resultadoDTO.USUARIO_DESCONHECIDO).intValue());
				ppnecimpurllog.setStImp(0);
				ppnecimpurllog.setDsErro("Usuario revisao desconhecido");
				ppnecimpurllog = this.dao.makePersistent(ppnecimpurllog);
				return retorno;
			}

			ppNecNovo.setOmUsrByIdUsrstativo(omUsrStAtivo);
			ppNecNovo.setOmUsrByIdUsrrevisao(omUsrRevisao);

			//pesquisa o Produto para verificar a consistencia da Chave
			ProdutoRN produtoRN = new ProdutoRN(this.dao);
			OmProduto omproduto = null;
			try {
				omproduto = produtoRN.getOmProduto(ppnec.getOmProduto().getCdProduto());

			} catch (RegistroDesconhecidoException e) {
				resultadoDTO.setIdmensagem(resultadoDTO.PRODUTO_DESCONHECIDO);

				ppnecimpurllog.setStImp(0);
				ppnecimpurllog.setDsErro("Produto " + ppnec.getOmProduto().getCdProduto() + " desconhecido");
				ppnecimpurllog = this.dao.makePersistent(ppnecimpurllog);

				continue; // qdo for produto desconhecido vai ate o final da iportacao
			}

			ppNecNovo.setOmProduto(omproduto);
			ppNecNovo.setHrLeadtime(omproduto.getHrLeadtimesaida());

			//pesquisa o Cliente para verificar a consistencia da Chave
			ClienteRN clienteRN = new ClienteRN(this.dao);
			ClienteDTO clienteDTO = new ClienteDTO();
			// Abaixo foi mudado a origem do cliente de ppnec.getPpCliente().getCdCliente() para o cliente definido no produto
			// Isso foi feito pois a origem do cliente anterior vinha da planilha que em geral é inconsistente
			clienteDTO.setCdCliente(omproduto.getPpCliente().getCdCliente());

			PpCliente ppcliente = clienteRN.pesquisar(clienteDTO);

			if(ppcliente == null) {
				resultadoDTO.setIdmensagem(resultadoDTO.IMP_CLIENTE_DESCONHECIDO);

				ppnecimpurllog.setStImp(0);
				ppnecimpurllog.setDsErro("Cliente " + omproduto.getPpCliente().getCdCliente() + " desconhecido");
				ppnecimpurllog = this.dao.makePersistent(ppnecimpurllog);
				continue; // tb nao para por esse mtivo
			}
			ppNecNovo.setPpCliente(ppcliente);
			ppNecNovo.setPpNeccrons(null);

			boolean isExisteProducao = false;
			if((ppnec.getPlano() != null) && (!ppnec.getPlano().isEmpty())) {
				ppNecNovo.setPpNeccrons(new HashSet<PpNeccron>());
				for(PpNeccronDTO neccron : ppnec.getPlano()) {
					PpNeccron ppNeccronNovo = neccron.clone(false);
					ppNeccronNovo.setIdNeccron(null);
					ppNeccronNovo.setPpNec(ppNecNovo);
					isExisteProducao = true;
					ppNecNovo.getPpNeccrons().add(ppNeccronNovo);
				}
			}

			// gera o log de importacao com sucesso
			if (isExisteProducao == true){
				ppNecNovo = this.dao.makePersistent(ppNecNovo);
				ppnecimpurllog.setStImp(1);
				ppnecimpurllog.setDsErro("SUCESSO " +  ppnec.getOmProduto().getCdProduto());
				ppnecimpurllog = this.dao.makePersistent(ppnecimpurllog);
				
				// Apos salvar o pedido verificar se existia um anterior. Se existia, entao alterar os ids de ppnec nos planos nec
				if (ppNecAnterior != null) {
					PpPlanoDAO ppPlanoDAO = new PpPlanoDAO(dao.getSession());
					ppPlanoDAO.marcarPlanosParaSeremSimulados(ppNecAnterior, ppNecNovo);
					
					PpPlanecDAO planecDAO = new PpPlanecDAO(dao.getSession());
					planecDAO.atualizarRefDePpNecEmPpPlanec(ppNecAnterior, ppNecNovo);
				}				
			} else {
				ppnecimpurllog.setStImp(0);
				ppnecimpurllog.setDsErro("N�o existe produ��oo para " +  ppnec.getOmProduto().getCdProduto());
				ppnecimpurllog = this.dao.makePersistent(ppnecimpurllog);
			}
		}

		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		return retorno;
	}

	public PpNec pesquisarPpnecById() {
		PpNecDAO ppNecDAO = new PpNecDAO(dao.getSession());
		return ppNecDAO.getPpNecPorId(this.getIdNec());
	}

	public PpNecDTO excluirRegistro() {
		PpNecDTO retorno = this;
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		// Pesquisa o ppnec que se deseja excluir
		PpNec ppnec = this.pesquisarPpnecById();

		// Se nao existir o registro desejado para exclusao, entao retornar ao solicitante informando registro desconhecido
		if (ppnec == null){
			resultadoDTO.setIdmensagem(resultadoDTO.CODIGO_DESCONHECIDO);
			return retorno;
		}

		// Se o registro solicitado para exclusao ja estiver marcado como excluir, retornar ao solicitante informando a situacao
		if(ppnec.getStAtivo() == BigDecimal.ZERO.toString().charAt(0)) {
			resultadoDTO.setIdmensagem(resultadoDTO.ERRO_EXCLUI_STATIVO_ZERO);
			return retorno;
		}

		// Pesquisar o usuario logado
		OmUsr msusr = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		try {
			msusr = usuarioRN.getOmUsr(this.getOmUsrByIdUsrstativo().getCdUsr());

			if(msusr == null){
				resultadoDTO.setIdmensagem(resultadoDTO.USUARIO_DESCONHECIDO);
				return retorno;
			}
		} catch(Exception e) {
			e.printStackTrace();
			resultadoDTO.setIdmensagem(resultadoDTO.USUARIO_DESCONHECIDO);
			return retorno;
		}

		// Marca stAtivo com zero informando que registro foi desativado
		ppnec.setStAtivo(0); //(char) 0
		ppnec.setDtStativo(DataHoraRN.getDataHoraAtual());
		ppnec.setOmUsrByIdUsrstativo(msusr);
		this.dao.makePersistent(ppnec);
		retorno = new PpNecDTO(ppnec.clone());
		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
		return retorno;
	}

	public PpNecDTO excluirRegistroImportacaoSemBusca(PpNec ppnec) {

		PpNecDTO retorno = new PpNecDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		ppnec = this.dao.findById(PpNec.class, ppnec.getIdNec(), false);

		// Pesquisar o usuario logado
		OmUsr omusr = null;
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(this.dao.getSession());

		try {
			omusr = usuarioRN.getDao().findById(OmUsr.class, ppnec.getOmUsrByIdUsrstativo().getIdUsr(), false);

			if(omusr == null){
				resultadoDTO.setIdmensagem(resultadoDTO.USUARIO_DESCONHECIDO);
				return retorno;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		// Marca stAtivo com zero informando que registro foi desativado
		ppnec.setStAtivo(0); //(char) 0
		ppnec.setDtStativo(DataHoraRN.getDataHoraAtual());
		ppnec.setOmUsrByIdUsrstativo(omusr);
		ppnec = this.dao.makePersistent(ppnec);
		retorno = new PpNecDTO(ppnec.clone());
		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);
        retorno.setResultadoDTO(resultadoDTO);
		return retorno;
	}

	/*
	 * Metodo usado incialmente para MonitorizacaoPPRN para descobrir quais os roteiros de determinada necessidade
	 */
	public List<PassosDTO> pesquisarPassosDTO(IdwLogger log, int idLog, int identacao, PpPlano ppplano) throws RoteiroDesconhecidoException{
		List<PassosDTO> retorno = new ArrayList<PassosDTO>();

		DwRotaDAO rotaDAO = new DwRotaDAO(dao.getSession());
		DwRota dwrota = rotaDAO.getDwRotaPorProduto(getOmProduto());
		
		if (dwrota == null || dwrota.getDwRotapassos() == null) {
			throw new RoteiroDesconhecidoException(String.valueOf(getOmProduto().getIdProduto()) + " - " + getOmProduto().getCdProduto());
		}
		
		List<DwRotapasso> listaDwRotapasso = new ArrayList<DwRotapasso>(dwrota.getDwRotapassos());
		
		Collections.sort(listaDwRotapasso, new Comparator<DwRotapasso>() {
			@Override
			public int compare(DwRotapasso o1, DwRotapasso o2) {
				return o1.getIdRotapasso() < o2.getIdRotapasso() ? -1 : o1.getIdRotapasso() > o2.getIdRotapasso() ? +1 : 0;
			}
			
		});
		
		ConsolidaRN crn = new ConsolidaRN(dao);
		for (DwRotapasso dwrotapasso : listaDwRotapasso){
			// Verifica se realmente dwrotapassos esta ordenado por idRotapasso
			log.info(idLog, identacao, "Roteiro " + dwrota.getIdRota() + " idRotapasso " + dwrotapasso.getIdRotapasso());

			// Pega passos que nao tem predecessoras. Esses sao os primeiros passos do roteiro
			if (dwrotapasso.getDwRpPredecessorasForIdRotapassoPai() == null || (dwrotapasso.getDwRpPredecessorasForIdRotapassoPai() != null && dwrotapasso.getDwRpPredecessorasForIdRotapassoPai().isEmpty() == true) ){
				PassosDTO passo = new PassosDTO(ppplano);
				passo.setDwrota(dwrota);
				passo.setDwrotapasso(dwrotapasso);
				passo.setDwfolha(dwrotapasso.getDwFolha());
				passo.setOmproduto(new ProdutoComparable());
				passo.getOmproduto().setOmproduto(crn.obtemPrimeirProduto(dwrotapasso.getDwFolha()));
				passo.setPassosPredecessoras(getPassosPredecessores(ppplano, dwrota, dwrotapasso));
				retorno.add(passo);
			}
		}
		return retorno;
		
	}
	
	/*
	 * Metodo privado de apoio ao metodo pesquisarPassosDTO
	 */
	private List<PassosDTO> getPassosPredecessores(PpPlano ppplano, DwRota dwrota, DwRotapasso dwrotapasso){
		List<PassosDTO> retorno = new ArrayList<PassosDTO>();
		ConsolidaRN crn = new ConsolidaRN(dao);
		for (DwRotapasso dwrotap : dwrota.getDwRotapassos()){
			// Verifica set dwrotapasso eh predecessora de algum dos passos
			for (DwRpPredecessora passopre : dwrotap.getDwRpPredecessorasForIdRotapassoPai()){
				if (passopre.getDwRotapassoByIdRotapassoFilho().getIdRotapasso() == dwrotapasso.getIdRotapasso()){
					PassosDTO passo = new PassosDTO(ppplano);
					passo.setDwrota(dwrota);
					passo.setDwrotapasso(dwrotap);
					passo.setDwfolha(dwrotap.getDwFolha());
					passo.setOmproduto(new ProdutoComparable());
					passo.getOmproduto().setOmproduto(crn.obtemPrimeirProduto(dwrotap.getDwFolha()));
					retorno.add(passo);

					// adiciona recursivamente os passos predecessores da predecessora
					retorno.addAll(getPassosPredecessores(ppplano, dwrota, dwrotap));
				}
			}
		}
		
		return retorno;
	}


	/*
	 * Esse metodo vai ser chamado no momento em que a integracao estiver importanto os pedidos.
	 * Essa desativacao é importante pois na nova importacao pedidos podem ter sumido e os mesmos devem sair do plano
	 */
	public void desativarTodosOsPedidos() {

		PpNecDAO ppNecDAO = new PpNecDAO(dao.getSession());
		List<PpNec> lista = ppNecDAO.getPpNecAtivos();
		
		for (PpNec p : lista){
			p.setStAtivo(0);
			dao.makePersistent(p);
		}
		
		// Nesse momento devemos tambem remover dos planos que tiverem status de cadastrado, todos os pedidos
		// relacionados
		PpPlanoDAO ppPlanoDAO = new PpPlanoDAO(dao.getSession());
		List<PpPlano> listaPlano = ppPlanoDAO.getPpPlanosPorStPlano(TpPlano.CADASTRADO);
		
		for (PpPlano p : listaPlano){
			for (PpPlanec pn : p.getPpPlanecs()){
				dao.makeTransient(pn);
			}
			p.setPpPlanecs(null);
		}
	}
	
	public ListaCPDTO getOrdemDeProducao(PpCp filtro) {
		
		PpCpproduto cpprod = null;
		
		if (filtro.getPpCpprodutos().size() > 0)
			cpprod = filtro.getPpCpprodutos().iterator().next();
		
		String nrOp = "";
		if (cpprod != null)
			nrOp = cpprod.getNrDoc();
		
		PpCliente cliente = filtro.getPpCliente();
		PpNec pedido = filtro.getPpNec();
		OmProduto produto = null;
		if (cpprod != null)
			produto = cpprod.getOmProduto();
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("SELECT DISTINCT");
		q.append("cpProduto.nrDoc,");
		q.append("cliente.cdCliente,");
		q.append("cliente.nmCliente,");
		q.append("pedido.idNec,");
		q.append("produto.idProduto,");
		q.append("produto.cdProduto,");
		q.append("produto.dsProduto,");
		q.append("produto.cdProduto"); //cp.nrLoteMp
		q.append("FROM PpCp cp");
		q.append("JOIN cp.ppCpprodutos cpProduto");
		q.append("LEFT JOIN cp.ppCliente cliente");
		q.append("LEFT JOIN cp.ppNec pedido");
		q.append("LEFT JOIN cp.dwRota rota");
		q.append("LEFT JOIN rota.omProduto produto");
		q.append("WHERE cp.stAtivo = 1");

		if(nrOp != null && !nrOp.equals("")) {
			q.append("AND cpProduto.nrDoc = :nrDoc");
		}
		if(cliente != null) {
			q.append("AND cliente.idCliente = :idCliente");
		}
		if(pedido != null) {
			q.append("AND pedido.idNec = :idPedido");
		}
		if(produto != null) {
			q.append("AND produto.idProduto = :idProduto");
		}
		
		q.defineParametro("nrDoc", nrOp);
		
		if(cliente != null) {
			q.defineParametro("idCliente", cliente.getIdCliente());
		}
		if(pedido != null) {
			q.defineParametro("idPedido", pedido.getIdNec());
		}
		if(produto != null) {
			q.defineParametro("idProduto", produto.getIdProduto());
		}
	
		List<Object> lista = q.list();
		
		final int nr_doc = 0;
		final int cd_cliente = 1;
		final int nm_cliente = 2;
		final int id_pedido = 3;
		final int id_produto_final = 4;
		final int cd_produto_final = 5;
		final int ds_produto_final = 6;
		final int nr_lote_mp = 7;
		
		PpNecDAO necDAO = new PpNecDAO(this.dao.getSession());
		
		List<CpDTO> listaCps = new ArrayList<>();
		for(Object obj : lista) {
			Object[] registro = (Object[]) obj;
		
			PpCpproduto cpproduto = new PpCpproduto();
			cpproduto.setNrDoc((String) registro[nr_doc]);
			
			PpCliente cli = new PpCliente();
			cli.setCdCliente((String) registro[cd_cliente]);
			cli.setNmCliente((String) registro[nm_cliente]);
			
			PpNec nec;
			try {
				nec = necDAO.getPpNecPorId((Long) registro[id_pedido]).clone(true);
			} catch (Exception e) {
				nec = null;
			}
						
			OmProduto prod = new OmProduto();
			try {
				prod.setIdProduto((Long) registro[id_produto_final]);
			} catch (Exception e) {
				prod.setIdProduto(0);
			}
			
			prod.setCdProduto((String) registro[cd_produto_final]);
			prod.setDsProduto((String) registro[ds_produto_final]);
			DwRota rota = new DwRota();
			rota.setOmProduto(prod);
			
			PpCp cp = new PpCp();
			cp.setPpCpprodutos(new HashSet<PpCpproduto>());
			cp.getPpCpprodutos().add(cpproduto);
			cp.setPpCliente(cli);
			cp.setDwRota(rota);
			cp.setPpNec(nec);
			cp.setNrLoteMp((String)registro[nr_lote_mp]);
			CpDTO dto = new CpDTO();
			dto.setCp(cp);
			listaCps.add(dto);
			
		}

		ListaCPDTO retorno = new ListaCPDTO();
		retorno.setListaCps(listaCps);
		
		return retorno;
	}
	
	public ProdutosSemiAcabadosDTO getProdutosSemiAcabados(OmProduto produtoFinal) {
		
		DwRotaDAO rotaDAO = new DwRotaDAO(dao.getSession());		
		List<DwRota> listaRotas = rotaDAO.getDwRotasAtivasPorProdutoFinal(produtoFinal, null);
		List<ProdutoSemiAcabadoDTO> listaOrdensProducao = new ArrayList<>();
		
		if(!listaRotas.isEmpty() && listaRotas.size() == 1) {
			DwRota rota = listaRotas.get(0);
			if(rota.getDwRotapassos() != null) {
				for(DwRotapasso passo : rota.getDwRotapassos()) {
					ProdutoSemiAcabadoDTO dto = new ProdutoSemiAcabadoDTO();
					dto.setDwRotapasso(passo.clone(true));
					listaOrdensProducao.add(dto);
				}
			}
		}
		
		Collections.sort(listaOrdensProducao, new Comparator<ProdutoSemiAcabadoDTO>() {
			@Override
			public int compare(ProdutoSemiAcabadoDTO o1, ProdutoSemiAcabadoDTO o2) {
				Integer passo1 = o1.getDwRotapasso().getPasso().intValue();
				Integer passo2 = o2.getDwRotapasso().getPasso().intValue();
				return passo1.compareTo(passo2);
			}
		});
		
		ProdutosSemiAcabadosDTO retorno = new ProdutosSemiAcabadosDTO();
		retorno.setOrdemProducaoDTO(listaOrdensProducao);
		return retorno;
	}
	
}