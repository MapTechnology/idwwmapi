package idw.model.rn;

import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.NumeroSerieIrregularException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPassmon;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.MsUp;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.MsTpevtTemplate;
import idw.util.IdwLogger;
import idw.webservices.dto.AcaoDTO;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.MontagensDTO;
import idw.webservices.dto.OrigemDTO;
import idw.webservices.dto.PassagemDTO;
import ms.coleta.Stubedelegate;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.model.dto.UpDTO;
import ms.model.rn.EventoRN;


public class PostoMontagemRN extends PostoPassagemRNAbs {

	public PostoMontagemRN() {
		super(new DAOGenerico());
	}
	
	public PostoMontagemRN(DAOGenerico dao) {
		super(dao);
	}

	@Override
	protected void postoMontagem(List<MontagemDTO> listaMontagem, DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) {
		// se listaDeAcoplamento n�o estiver vazia, entar salvar acoplamento
		if(listaMontagem != null) {
			// interagir sobre a listaDeAcomplamento
			for(MontagemDTO montagem : listaMontagem) {
				this.salvaMontagem(montagem, oDwPassagem);
			}
			
			// atualiza o numero de serie para identificar a comnposi��o de montagem
			// dw_nserie.id_passagem = com o id do dw_passagem inserido anteriormente
			oDwNserie.setDwPassagem(oDwPassagem);
			//merge no dw_nserie
			this.getDaoSession().merge(oDwNserie);
		}
		
	}
	
	private void salvaMontagem(MontagemDTO montagem, DwPassagem dwPassagem) {
		// Pesquisa produto
		OmProduto omproduto = null;
		
		ProdutoRN rn = new ProdutoRN();
		rn.getDao().setSession(getDaoSession());
		
		omproduto = (OmProduto) rn.getDao().findById(OmProduto.class, montagem.getIdProdutoAcoplado(), false);
		
		// insert into dw_passmon (id_passagem, id_produto, is_alternativo)
		// values (inserido acima, itemDaListaDeAcomplamento.id_produtoAcoplado,
		// (itemDaListaDeAcoplamento.id_produtoAcoplado == itemDaListaDeAcoplamento.id_produtoEsperado ? true : false));
		
		DwPassmon dwpassmon = new DwPassmon();
		dwpassmon.setDwPassagem(dwPassagem);
		dwpassmon.setIsAlternativo((montagem.getIdProdutoAcoplado() == montagem.getIdProdutoEsperado() ? false : true));
		dwpassmon.setOmProduto(omproduto);
		dwpassmon.setDsMon(montagem.getDsProdutoEsperado());
		dwpassmon.setCb(montagem.getCb());

		getDaoSession().merge(dwpassmon);
		
		rn = null;
		omproduto = null;
		dwpassmon = null;
	}

	@Override
	protected void postoTesteVisual(List<DefeitoDTO> listaDefeitos,
			DwPassagem passagem) {
		// faz nada
	}

	@Override
	protected void postoReprocesso(List<AcaoDTO> listaAcoes, List<OrigemDTO> listaOrigens, DwPassagem passagem, PassagemDTO retorno) {
	}

	@Override
	protected void postoTesteFuncional(IdwLogger log, PassagemDTO passagem,
			DwPassagem oDwPassagem, DwNserie oDwNserie, PassagemDTO retorno) {
	}
	
	
	
	/* Metodo para cancelamento do palete, permitindo assim remontar os itens internos que já estavam no palete
	 * 
	 */
	public MontagensDTO cancelarPalete(MontagensDTO palete) {
		MontagensDTO retorno = new MontagensDTO();
		NumeroSerieRN rn = new NumeroSerieRN(getDao());
		EventoRN ern = new EventoRN();
		ern.setDao(getDao());

		retorno.getResultado().setIdmensagem(retorno.getResultado().COM_SUCESSO);

		IdwLogger log = new IdwLogger("cancelarpalete");
		int idLog = log.getIdAleatorio();
		
		/* Remover a montagem do palete a fim de permitir que o que esta dentro dele seja montado novamente
		 * 
		 */
		DwNserie nsPalete;
		try {
			nsPalete = rn.getDwNserieCb(palete.getCbPai());
			
			
			
			/* Nao cancelar se o NS estiver montado em uma embalagem pai
			 * nao entrar no if se for mac dentro de mac
			 */
			MontagensDTO montadoEm = rn.isCBJaMontadoNoTppt(palete.getCbPai(), palete.getListaMontagem().get(0).getCdPt(), palete.getListaMontagem().get(0).getCdCp());
			if (montadoEm != null && montadoEm.getListaMontagem().isEmpty() == false && montadoEm.getCbPai().equals(palete.getCbPai()) == false) {
				montadoEm.getResultado().setIdmensagem(montadoEm.getResultado().COMPONENTE_NAO_PERTENCE_AO_PRODUTO);;
				return montadoEm;
			}
			
			nsPalete.setDwPassagem(null);
			getDao().makePersistent(nsPalete);
			
			
			/* Modificar st_ativo para 0 e informar motivo no ds_diario
			 * 
			 */
			List<DwPassagem> listaPassagem = getMontagensAtivas(palete.getCbPai(), palete.getListaMontagem().get(0).getCdPt());
			
			if (listaPassagem != null) {
				for (DwPassagem passagem : listaPassagem) {
					passagem.setStAtivo((byte) 0);
					passagem.setDsDiariobordo(palete.getLoginSupervisor() + " - " + DataHoraRN.getDataHoraAtualFormatada() + " - usado cpalete");
					
					getDao().makePersistent(passagem);
				}
			}

			
			/* Inserir em msevt um evento de lancamento de refugo mas com status apenas de informacao, ou seja,
			 * stEvt = 4
			 */
			EventoColetado evento = new EventoColetado();
			evento.setEventoApenasInformativo(true);
			evento.setDthrEvento(DataHoraRN.getDataHoraAtual());
			evento.setCb(palete.getCbPai());
			evento.setIcUpDTO(getIcUpDTO(palete.getListaMontagem().get(0).getCdPt()));
			evento.setOrigem("cpalete " + palete.getCbPai());
			evento.setTipoEvento(MsTpevtTemplate.Type.MOTIVO_REFUGO.getId());
			evento.setLogin(palete.getLoginSupervisor());
			
			ern.incluirEvento(log, idLog, 0, evento, MsTpevtTemplate.Type.MOTIVO_REFUGO.getId(), null);
		} catch (NumeroSerieIrregularException e1) {
			nsPalete = null;
		}
		
		// Alessandre em 30-09-19 trecho comentado pois o cpalete não deve mais executar o ccaixa evitando assim
		// que as fontes sejam desvinculadas dos produtos
//		if (nsPalete != null) {
//			for (MontagemDTO dto : palete.getListaMontagem()) {
//				// Cancelar montagem do item no campo DwNSerie idPassagem
//				try {
//					DwNserie ns = rn.getDwNserieCb(dto.getCb());
//					if (ns != null) {
//						ns.setDwPassagem(null);
//						getDao().makePersistent(ns);
//
//						/*
//						 * Inserir em msevt um evento de lancamento de refugo mas com status apenas de informacao, ou seja, stEvt = 4
//						 */
//						EventoColetado evento = new EventoColetado();
//						evento.setEventoApenasInformativo(true);
//						evento.setDthrEvento(DataHoraRN.getDataHoraAtual());
//						evento.setCb(dto.getCb());
//						evento.setIcUpDTO(getIcUpDTO(dto.getCdPt()));
//						evento.setOrigem("cpalete " + palete.getCbPai());
//						evento.setTipoEvento(MsTpevtTemplate.Type.MOTIVO_REFUGO.getId());
//						evento.setLogin(palete.getLoginSupervisor());
//
//						ern.incluirEvento(log, idLog, 0, evento, MsTpevtTemplate.Type.MOTIVO_REFUGO.getId(), null);
//
//					}
//				} catch (NumeroSerieIrregularException e) {
//					retorno.getListaMontagem().add(dto);
//					retorno.getResultado().setIdmensagem(retorno.getResultado().CODIGO_DESCONHECIDO);
//				}
//			}
//		}
		return retorno;
	}
	
	private IcUpDTO getIcUpDTO(String cdpt) {
		IcUpDTO retorno = null;
		
		/* Primeiro tenta obter os dados atraves do MSThread
		 * 
		 */
		retorno = Stubedelegate.getInstancia().getMsthread().getIcUp(cdpt);
		if (retorno != null)
			return retorno;
		
		retorno = new IcUpDTO();
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from MsUp a");
		q.append("join a.msMsicups b");
		q.append("join b.msMs c");
		q.append("where c.stAtivo = 1");
		q.append("and a.stAtivo = 1");
		q.append("and a.cdUp = :cdup");
		q.defineParametro("cdup", cdpt);
		q.setMaxResults(1);
		
		MsUp msup = (MsUp) q.uniqueResult();

		if (msup != null) {
			
			UpDTO up = new UpDTO();
			up.setIdUp(msup.getIdUp());
			up.setCd_up(cdpt);
			
			retorno.setUpDTO(up);
			MsMsicup msicup = null;
			for (MsMsicup msicupAux : msup.getMsMsicups()) {
				msicup = msicupAux;
			}
			retorno.setIdIcUp(msicup.getIdMsicup().intValue()); // pega primeira ocorrencia. Em geral devera ter apenas 1 oco
		} else {
			retorno = null;
		}
		return retorno;
	}
	
	private List<DwPassagem> getMontagensAtivas(String cb, String cdpt) {
		List<DwPassagem> retorno;
		PTRN prn = new PTRN(getDao());
		OmPt ompt;
		try {
			ompt = prn.getOmPt(cdpt);
		} catch (RegistroDesconhecidoException e) {
			return null;
		}
		
		MapQuery q = new MapQuery(getDaoSession());
		
		q.append("select a");
		q.append("from DwPassagem a");
		q.append("join a.dwPassmons b");
		q.append("join a.omPt c");
		q.append("join a.dwNserie d");
		q.append("where d.cb = :cb");
		q.append("and c.omTppt = :omtppt");
		q.append("and a.stNserie = 1");
		
		q.defineParametro("cb", cb);
		q.defineParametro("omtppt", ompt.getOmTppt());
		
		retorno = q.list();
		
		return retorno;
	}
	public MontagensDTO cancelarCaixa(String cbCaixa, String cdPt, String login, String motivo, String cdcp) {
		MontagensDTO retorno = new MontagensDTO();
		NumeroSerieRN rn = new NumeroSerieRN(getDao());
		EventoRN ern = new EventoRN();
		ern.setDao(getDao());
		
		IdwLogger log = new IdwLogger("cancelarcaixa");
		int idLog = log.getIdAleatorio();
		try {
			DwNserie ns = rn.getDwNserieCb(cbCaixa);
			if (ns != null) {
				
				/* Se o NS tiver sido montado em um produto maior entao ele nao poderá ser cancelado */
				MontagensDTO montadoEm = rn.isCBJaMontadoNoTppt(cbCaixa, cdPt, cdcp);
				if (montadoEm != null && montadoEm.getListaMontagem().isEmpty() == false && montadoEm.getCbPai().equals(cbCaixa) == false) {
					montadoEm.getResultado().setIdmensagem(montadoEm.getResultado().COMPONENTE_NAO_PERTENCE_AO_PRODUTO);;
					return montadoEm;
				}
				
				
				
				
				ns.setDwPassagem(null);
				getDao().makePersistent(ns);
				
				/* Modificar st_ativo para 0 e informar motivo no ds_diario
				 * 
				 */
				List<DwPassagem> listaPassagem = getMontagensAtivas(cbCaixa, cdPt);
				
				if (listaPassagem != null) {
					for (DwPassagem passagem : listaPassagem) {
						passagem.setStAtivo((byte) 0);
						passagem.setDsDiariobordo(login + " - " + DataHoraRN.getDataHoraAtualFormatada() + " - " + motivo);
						
						getDao().makePersistent(passagem);
					}
				}
				
				/* Inserir em msevt um evento de lancamento de refugo mas com status apenas de informacao, ou seja,
				 * stEvt = 4
				 */
				EventoColetado evento = new EventoColetado();
				evento.setEventoApenasInformativo(true);
				evento.setDthrEvento(DataHoraRN.getDataHoraAtual());
				evento.setCb(cbCaixa);
				evento.setIcUpDTO(getIcUpDTO(cdPt));
				evento.setOrigem("ccaixa " + cbCaixa + " - " + motivo);
				evento.setTipoEvento(MsTpevtTemplate.Type.MOTIVO_REFUGO.getId());
				evento.setLogin(login);
				
				ern.incluirEvento(log, idLog, 0, evento, MsTpevtTemplate.Type.MOTIVO_REFUGO.getId(), null);

			} else {
				retorno.getResultado().setIdmensagem(retorno.getResultado().CODIGO_DESCONHECIDO);
			}
		} catch (NumeroSerieIrregularException e) {
			retorno.getResultado().setIdmensagem(retorno.getResultado().CODIGO_DESCONHECIDO);
		}
		return retorno;
	}

}
