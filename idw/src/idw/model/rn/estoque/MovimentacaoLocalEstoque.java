package idw.model.rn.estoque;

import java.math.BigDecimal;
import java.util.Date;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwEstlocalDAO;
import idw.model.dao.DwEstlocalproDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.UsuarioRN;
import idw.model.rn.consolidacao.estoque.ConsolidacaoLocalEstoque;
import idw.model.rn.produto.ProdutoInvalidoException;
import idw.util.CompareUtils;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.ResultadoEntradaLocalProdutoDTO;
import idw.webservices.dto.TurnoAtualDTO;
import ms.excessao.UsuarioDesconhecidoException;

public class MovimentacaoLocalEstoque extends AbstractRN<DAOGenerico> {

	public MovimentacaoLocalEstoque(DAOGenerico dao) {
		super(dao);
	}

	private OmProduto pesquisaOmproduto(String cdProduto) {
		ProdutoRN rn = new ProdutoRN(getDao());

		try {
			return rn.getOmProduto(cdProduto);

		} catch (RegistroDesconhecidoException e) {

			return null;
		}

	}

	private DwEstlocal getEstlocal(String cdLocal) {

		DwEstlocalDAO dwEstlocalDAO = new DwEstlocalDAO(getDaoSession());

		// procurar o id_estlocal pelo cd_local
		return dwEstlocalDAO.pesquisarUniqueDwEstlocalByCdLocal(cdLocal);

	}

	private void entradaLocalProduto(
			IdwLogger log, int idLog,
			String cdProduto, String cdLocalDestino,
			int qtdEntrada, String usuario, Date data)
			throws LocalDestinoNaoEncontradoException,
			ProdutoInvalidoException, UsuarioDesconhecidoException, SemCalendarioException {

		DwEstlocal estlocal = getEstlocal(cdLocalDestino);

		if (estlocal == null) {
			throw new LocalDestinoNaoEncontradoException();
		}

		OmProduto omProduto = pesquisaOmproduto(cdProduto);

		if (omProduto == null) {
			throw new ProdutoInvalidoException();
		}

		UsuarioRN usuarioRN = new UsuarioRN(getDao());
		OmUsr omUsr = null;
		try {
			omUsr = usuarioRN.getOmUsr(usuario);
		} catch (RegistroDesconhecidoException e) {
			throw new UsuarioDesconhecidoException();
		}
		
		OmCfg omCfg = Util.getConfigGeral(getDaoSession());
		
		ConsolidacaoLocalEstoque consolidacaoLocalEstoque = new ConsolidacaoLocalEstoque(getDao());
		TurnoAtualDTO turnoAtualDTO = consolidacaoLocalEstoque.getTurnoAtualDTO(estlocal, data);
		
		consolidacaoLocalEstoque.consolidarLocalEstoqueEntrada(log, idLog, omCfg, turnoAtualDTO, estlocal, omProduto, new BigDecimal(qtdEntrada), data, omUsr);


	}

	
	public void movimentarQtdEntreLocaisProdutosComDwEstlocalproFazAjusteSeSaidaMaiorQueTotal(
			IdwLogger log,
			int idLog,
			OmProduto omProduto, DwEstlocalpro localproOrigem,
			DwEstlocalpro localproDestino, int qtdMov,
			OmUsr omUsr, Date data, OmCfg omCfg) throws  UsuarioDesconhecidoException, SemCalendarioException, EntradaNaoEncontradaException {
		
		
		if(omUsr == null){
			log.info(idLog, 0, "UsuarioDesconhecidoException");
			throw new UsuarioDesconhecidoException();
			
		}
		
		if(localproOrigem != null && localproDestino != null) {
			if (CompareUtils.equals(localproOrigem.getIdEstlocalpro(), localproDestino.getIdEstlocalpro()) == false){
			
				BigDecimal qt = new BigDecimal(qtdMov);
				
				ConsolidacaoLocalEstoque consolidacaoLocalEstoque = new ConsolidacaoLocalEstoque(getDao());
				
				TurnoAtualDTO turnoAtualDTOOrigem = consolidacaoLocalEstoque.getTurnoAtualDTO(localproOrigem.getDwEstlocal(), data);
				
				log.info(idLog, 0, "vou chamar consolidarLocalEstoqueSaidaFazAjusteSeQtdMaiorQueTotal");
				consolidacaoLocalEstoque.consolidarLocalEstoqueSaidaFazAjusteSeQtdMaiorQueTotal(log, idLog, turnoAtualDTOOrigem, omCfg, localproOrigem, qt, data, omUsr);
				
				TurnoAtualDTO turnoAtualDTODestino = consolidacaoLocalEstoque.getTurnoAtualDTO(localproDestino.getDwEstlocal(), data);
				
				log.info(idLog, 0, "vou chamar consolidarLocalEstoqueEntrada");
				consolidacaoLocalEstoque.consolidarLocalEstoqueEntrada(log, idLog, turnoAtualDTODestino, omCfg,  localproDestino, qt, data, omUsr);			
				
			} else {
				log.info(idLog, 0, "Nao movimentou pois origem e destino são iguais");
			}
		} else {
			log.info(idLog, 0, "Estoque oriem ou destino esta nulo");
		}
	}
	
	public void movimentarQtdEntreLocaisProdutosFazAjusteSeSaidaMaiorQueTotal(
			IdwLogger log, int idLog,
			DwEstlocal localOrigem,
			OmProduto omProduto, DwEstlocal localDestino, int qtdMov,
			OmUsr omUsr, Date data) throws LocalOrigemNaoEncontradoException,
			LocalDestinoNaoEncontradoException, ProdutoInvalidoException,
			UsuarioDesconhecidoException, EntradaNaoEncontradaException, SemCalendarioException {
		
		if (localOrigem == null || localOrigem.equals("")) {
			log.info(idLog, 0, "LocalOrigemNaoEncontradoException");
			throw new LocalOrigemNaoEncontradoException();
		}
		
		if (localDestino == null || localDestino.equals("")) {
			log.info(idLog, 0, "LocalDestinoNaoEncontradoException");
			throw new LocalDestinoNaoEncontradoException();
		}
		
		if (omProduto == null) {
			log.info(idLog, 0, "ProdutoInvalidoException");
			throw new ProdutoInvalidoException();
		}
		
		if(omUsr == null){
			log.info(idLog, 0, "UsuarioDesconhecidoException");
			throw new UsuarioDesconhecidoException();
		}

				
		if (localOrigem.getCdLocal().equals(localDestino.getCdLocal()) == false) {

			EstoqueRN estoqueRN = new EstoqueRN(getDao());

			DwEstpro estproOrigem = estoqueRN.getDwEstproSenaoExistirCriar(omProduto, localOrigem.getDwEst());
			
			OmCfg omCfg = Util.getConfigGeral(getDaoSession());
			
			DwEstlocalproDAO estlocalproDAO = new DwEstlocalproDAO(getDaoSession());
			DwEstlocalpro dwEstlocalproOrigem = estlocalproDAO.getDwEstlocalproSenaoExistirCriar(localOrigem, estproOrigem, null);	
			
			DwEstpro estproDestino = estoqueRN.getDwEstproSenaoExistirCriar(omProduto, localDestino.getDwEst());
			DwEstlocalpro dwEstlocalproDestino = estlocalproDAO.getDwEstlocalproSenaoExistirCriar(localDestino, estproDestino, null);	

			log.info(idLog, 0, "vou chamar movimentarQtdEntreLocaisProdutosComDwEstlocalproFazAjusteSeSaidaMaiorQueTotal");
			movimentarQtdEntreLocaisProdutosComDwEstlocalproFazAjusteSeSaidaMaiorQueTotal(log, idLog, omProduto, dwEstlocalproOrigem, dwEstlocalproDestino, qtdMov, omUsr, data, omCfg);
			
		}

	}

	private void movimentarQtdEntreLocaisProdutosComCodigos(
			IdwLogger log, int idLog,
			String cdlocalOrigem,
			String cdProduto, String cdLocalDestino, int qtdEntrada,
			String usuario, Date data)
			throws LocalOrigemNaoEncontradoException,
			LocalDestinoNaoEncontradoException, ProdutoInvalidoException,
			UsuarioDesconhecidoException, EntradaNaoEncontradaException, SemCalendarioException {

		DwEstlocal estlocalOrigem = getEstlocal(cdlocalOrigem);

		DwEstlocal estlocalDestino = getEstlocal(cdLocalDestino);		

		OmProduto omProduto = pesquisaOmproduto(cdProduto);		

		UsuarioRN usuarioRN = new UsuarioRN(getDao());
		
		OmUsr omUsr = null;
		try {
			omUsr = usuarioRN.getOmUsr(usuario);
		} catch (RegistroDesconhecidoException e) {
			throw new UsuarioDesconhecidoException();
		}		
		
		movimentarQtdEntreLocaisProdutosFazAjusteSeSaidaMaiorQueTotal(log, idLog, estlocalOrigem, omProduto, estlocalDestino, qtdEntrada, omUsr, data);

	}

	public ResultadoEntradaLocalProdutoDTO setEntradaLocalProduto(
			String cdProduto, String cdLocalDestino, int qtdEntrada,
			String usuario) {

		IdwLogger log = new IdwLogger("setEntradaLocalProduto");
		int idLog = log.getIdAleatorio();
	
		ResultadoEntradaLocalProdutoDTO resultadoEntradaLocalProdutoDTO = new ResultadoEntradaLocalProdutoDTO();
		resultadoEntradaLocalProdutoDTO.setOk(false);

		try {

			entradaLocalProduto(log, idLog, cdProduto, cdLocalDestino, qtdEntrada, usuario, DataHoraRN.getDataHoraAtual());
			resultadoEntradaLocalProdutoDTO.setOk(true);

		} catch (LocalDestinoNaoEncontradoException e1) {
			e1.printStackTrace();
			resultadoEntradaLocalProdutoDTO.setLocalDestinoNaoEncontrado(true);
			resultadoEntradaLocalProdutoDTO.setIdErro(ResultadoEntradaLocalProdutoDTO._erro_localdestino_desconhecido);
		} catch (ProdutoInvalidoException e1) {
			e1.printStackTrace();
			resultadoEntradaLocalProdutoDTO.setProdutoNaoEncontrado(true);
			resultadoEntradaLocalProdutoDTO.setIdErro(ResultadoEntradaLocalProdutoDTO._erro_produto_desconhecido);
		} catch (UsuarioDesconhecidoException e1) {
			e1.printStackTrace();
			resultadoEntradaLocalProdutoDTO.setUsuarioNaoEncontrado(true);
			resultadoEntradaLocalProdutoDTO.setIdErro(ResultadoEntradaLocalProdutoDTO._erro_usuario_desconhecido);
		} catch (SemCalendarioException e) {
			e.printStackTrace();
			
			resultadoEntradaLocalProdutoDTO.setCalendarioNaoEncontrado(true);
			resultadoEntradaLocalProdutoDTO.setIdErro(ResultadoEntradaLocalProdutoDTO._erro_sem_calendario);
		}

		return resultadoEntradaLocalProdutoDTO;

	}

	public ResultadoEntradaLocalProdutoDTO setMovimentacaoLocalProduto(
			String cdlocalOrigem, String cdProduto, String cdLocalDestino,
			int qtdEntrada, String usuario) {

		IdwLogger log = new IdwLogger("setMovimentacaoLocalProduto");
		int idLog = log.getIdAleatorio();
	
		ResultadoEntradaLocalProdutoDTO resultadoEntradaLocalProdutoDTO = new ResultadoEntradaLocalProdutoDTO();
		resultadoEntradaLocalProdutoDTO.setOk(false);

		try {

			movimentarQtdEntreLocaisProdutosComCodigos(log, idLog, cdlocalOrigem, cdProduto, cdLocalDestino, qtdEntrada, usuario, new Date());
			
			resultadoEntradaLocalProdutoDTO.setOk(true);

		} catch (LocalDestinoNaoEncontradoException e1) {
			resultadoEntradaLocalProdutoDTO.setLocalDestinoNaoEncontrado(true);
			resultadoEntradaLocalProdutoDTO.setIdErro(ResultadoEntradaLocalProdutoDTO._erro_localdestino_desconhecido);
		} catch (ProdutoInvalidoException e1) {
			resultadoEntradaLocalProdutoDTO.setProdutoNaoEncontrado(true);
			resultadoEntradaLocalProdutoDTO.setIdErro(ResultadoEntradaLocalProdutoDTO._erro_produto_desconhecido);
		} catch (UsuarioDesconhecidoException e1) {
			resultadoEntradaLocalProdutoDTO.setUsuarioNaoEncontrado(true);
			resultadoEntradaLocalProdutoDTO.setIdErro(ResultadoEntradaLocalProdutoDTO._erro_usuario_desconhecido);
		} catch (LocalOrigemNaoEncontradoException e1) {
			resultadoEntradaLocalProdutoDTO.setLocalOrigemNaoEncontrado(true);
			resultadoEntradaLocalProdutoDTO.setIdErro(ResultadoEntradaLocalProdutoDTO._erro_localorigem_desconhecido);
		} catch (EntradaNaoEncontradaException e1) {
			resultadoEntradaLocalProdutoDTO.setEntradaNaoEncontrada(true);
			resultadoEntradaLocalProdutoDTO.setIdErro(ResultadoEntradaLocalProdutoDTO._erro_entrada_desconhecido);
		} catch (SemCalendarioException e) {
			resultadoEntradaLocalProdutoDTO.setCalendarioNaoEncontrado(true);
			resultadoEntradaLocalProdutoDTO.setIdErro(ResultadoEntradaLocalProdutoDTO._erro_sem_calendario);
		}

		return resultadoEntradaLocalProdutoDTO;
	}

//	private void setQtdEstoqueProdutoEntrada(OmCfg omCfg, TurnoAtualDTO turnoAtualDTO, DwEstlocal dwEstlocal, OmProduto omProduto,
//			BigDecimal qtEntrada, Date data, OmUsr omUsr) {
//
//		EstoqueRN estoqueRN = new EstoqueRN(getDao());
//
//		DwEstpro estpro = estoqueRN.getDwEstproSenaoExistirCriar(omProduto,
//				dwEstlocal.getDwEst());
//
//		DwEstlocalproDAO estlocalproDAO = new DwEstlocalproDAO(getDaoSession());
//		DwEstlocalpro dwEstlocalpro = estlocalproDAO
//				.getDwEstlocalproSenaoExistirCriar(dwEstlocal, estpro, null);	
//
//		ConsolidacaoLocalEstoque consolidacaoLocalEstoque = new ConsolidacaoLocalEstoque(getDao());
//
//		consolidacaoLocalEstoque.consolidarLocalEstoqueEntrada(turnoAtualDTO, omCfg, dwEstlocalpro, qtEntrada, data, omUsr);
//
//	}



//	private void setQtdEstoqueProdutoSaida(OmCfg omCfg, TurnoAtualDTO turnoAtualDTO, DwEstpro dwEstpro, DwEstlocalpro dwEstlocalpro,
//			OmProduto omProduto, BigDecimal qtSaida, Date data, OmUsr omUsr)
//			throws SaidaMaiorQueTotalException, SemCalendarioException {
//
//		BigDecimal total = dwEstlocalpro.getQtTotal();
//
//		if (CompareUtils.compareTo(total, qtSaida) < 0) {
//			
//			throw new SaidaMaiorQueTotalException();
//
//		} else {
//			
//			ConsolidacaoLocalEstoque consolidacaoLocalEstoque = new ConsolidacaoLocalEstoque(getDao());
//			
//			
//			consolidacaoLocalEstoque.consolidarLocalEstoqueSaidaFazAjusteSeQtdMaiorQueTotal(
//					turnoAtualDTO, omCfg, dwEstlocalpro, qtSaida, data, omUsr);
//			
//		}
//		
//	}
	

}
