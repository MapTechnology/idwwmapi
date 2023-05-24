package idw.model.rn;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmProdutoDAO;
import idw.model.dao.OmProgrpDAO;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemConfiguracaoException;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmPrg;
import idw.model.pojos.OmPrgpos;
import idw.model.pojos.OmPrgposproalt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.webservices.dto.ProgramaInsersoraDTO;


public class ProgramaInsersoraRN extends DAOGenerico{	

	@SuppressWarnings("unchecked")
	public ProgramaInsersoraDTO setProgramaInsersoraDTO(ProgramaInsersoraDTO programa, boolean isForcarImportacao){
		ProgramaInsersoraDTO retorno = new ProgramaInsersoraDTO();
		retorno.setResultadoEvento(retorno.getEVENTO_BEM_SUCEDIDO());

		String hql = "";

		// Obtem o registro original
		hql += "select omprg ";
		hql += "from OmPrg omprg ";
		hql += "where omprg.omPt.idPt = ::idpt ";
		hql += "and omprg.cdPrg = '::cdprg' ";
		hql += "and omprg.stAtivo = 1";
		hql = hql.replaceAll("::idpt", String.valueOf(programa.getOmpt().getIdPt()));
		hql = hql.replaceAll("::cdprg", String.valueOf(programa.getOmprg().getCdPrg()));
	

		Query q = getSession().createQuery(hql);

		OmPrg omPrgOriginal = (OmPrg) q.uniqueResult();

		OmPrg omPrgNovo = new OmPrg();

		boolean isInclusao = false;

		if (omPrgOriginal == null){			
			omPrgNovo = (OmPrg)programa.getOmprg().clone();
			omPrgNovo.setRevisao(1l);
			omPrgNovo.setDtRevisao(programa.getOmprg().getDtRevisao());
			omPrgNovo.setStAtivo((byte)1);
			omPrgNovo.setDtStativo(programa.getOmprg().getDtRevisao());
			omPrgNovo.setOmPt(programa.getOmpt());
			isInclusao = true;
		}else{
			// Desativa o pojo original
			omPrgOriginal.setStAtivo((byte)0);
			omPrgOriginal.setDtStativo(programa.getOmprg().getDtRevisao());

			omPrgNovo.copy(omPrgOriginal, false);
			omPrgNovo.setRevisao(omPrgOriginal.getRevisao()+1);
			omPrgNovo.setOmPt(omPrgOriginal.getOmPt());
			omPrgNovo.setIdPrg(0l);
			omPrgNovo.setStAtivo((byte) 1);
			omPrgNovo.setDtRevisao(programa.getDthrRevisao());
			omPrgNovo.setDtStativo(new Date());
		}		

		// Verifica se o codigo do programa ja existe no banco, se exitir retornar ao cliente a excessao
		hql = "";

		hql += "from OmPrg omprg ";
		hql += "where omprg.cdPrg = '::cdprg' ";
		hql += "and omprg.omPt.idPt = ::idpt ";
		hql += "and omprg.stAtivo = 1";
		hql += "order by omprg.revisao desc ";

		hql = hql.replaceAll("::cdprg", omPrgNovo.getCdPrg());
		hql = hql.replaceAll("::idpt", String.valueOf((omPrgNovo.getOmPt().getIdPt())));
		q = getSession().createQuery(hql);

		List<OmPrg> listaOmPrg = q.list();

		if (listaOmPrg.size() > 0){
			// verifica se a ultima revisao tem a mesma data e hora
			OmPrg omprgPesquisado = listaOmPrg.get(0);
			if (isForcarImportacao == false && DataHoraRN.equals(omprgPesquisado.getDtRevisao(), omPrgNovo.getDtRevisao())){
				retorno = programa;
				retorno.setResultadoEvento(retorno.getERRO_PROGRAMA_JA_EXISTE());
				return retorno;
			} else {
				// Desativa o pesquisado
				omprgPesquisado.setStAtivo((byte) 0);
				omprgPesquisado.setDtStativo(DataHoraRN.getDataHoraAtual());
				makePersistent(omprgPesquisado);
				
				// A nova revisao passa a ser a ultima gravada + 1
				omPrgNovo.setRevisao(omprgPesquisado.getRevisao() + 1l);
			}
		}

		if (retorno.getResultadoEvento() == retorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				if (isInclusao == false)
					makePersistent(omPrgOriginal);

				omPrgNovo = (OmPrg) makePersistent(omPrgNovo);

				retorno.setOmpt(omPrgNovo.getOmPt());

				ProdutoRN rnProduto = new ProdutoRN();
				rnProduto.getDao().setSession(getSession());

				DiversosRN rnDiversos = new DiversosRN();
				rnDiversos.setSession(getSession());

				PTRN rnPT = new PTRN();
				rnPT.setDaoSession(getSession());

				OmProgrpDAO progrpDAO = new OmProgrpDAO(getSession());
				OmProgrp omProgrpPadrao = progrpDAO.getOmProgrpPorCdAtivoOrderById("0");
				OmProdutoDAO omProdutoDAO = new OmProdutoDAO(getSession());
				
				OmCfg omcfg = rnDiversos.pesquisaOmcfg();
				for (OmPrgpos omprgpos : programa.getOmprgpos()){
					
					// Alessandre em 29-8-13 foi acrescentado o if abaixo pois na unicoba existem posicoes sem componentes no programa da IAC
					if (
							omprgpos.getOmProduto().getCdProduto() == null || 
							omprgpos.getOmProduto().getCdProduto().trim().equals(""))
						continue;
					
					omprgpos.setOmPrg(omPrgNovo);
					OmProduto omproduto = null;
					
					boolean isProgramaTemDsProduto = omprgpos.getOmProduto().getDsProduto() != null  && !(omprgpos.getOmProduto().getDsProduto().equals(""));
							
					try {
						omproduto = omProdutoDAO.getOmProdutoPorCdAtivoOrderByIdDesc(omprgpos.getOmProduto().getCdProduto());
						
						if (omproduto == null) {
							throw new RegistroDesconhecidoException();
						}
						// Ailton 06/10/2017: caso a descricao do produto seja passada, recadastrar o produto para utiliza-la. Funcionalidade #4658
						if (isProgramaTemDsProduto && ProdutoRN.isDsProdutoPadrao(omproduto)) {
							omproduto = rnProduto.salvarRevisaoOmProduto(omproduto, omproduto, new Date(), omcfg.getOmUsrimpprog());
							omproduto.setDsProduto(omprgpos.getOmProduto().getDsProduto());
						}
						
						
					} catch (RegistroDesconhecidoException e){
							// Produto nao existe, entao providenciar o cadastro
							omproduto = new OmProduto();
							
							omproduto.setCdProduto(omprgpos.getOmProduto().getCdProduto());
							omproduto.setTpProduto(OmProdutoTemplate.TpProduto.COMPONENTE.getId());
							
							omproduto.setDsProduto("Cadastrado na importacao de programa");
							// Ailton 03/10/2017: caso a descricao do produto seja passada, utilizar ela. Funcionalidade #4639
							if (isProgramaTemDsProduto)
								omproduto.setDsProduto(omprgpos.getOmProduto().getDsProduto());
							
							omproduto.setMinValposalim(new BigDecimal(0));
							omproduto.setOmCc(omcfg.getOmCcdefault());
							omproduto.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
							omproduto.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());

							omproduto.setOmProgrp(omProgrpPadrao);
							omproduto = rnProduto.salvarRevisaoOmProduto(null, omproduto, new Date(), omcfg.getOmUsrimpprog());
							
					}
					omprgpos.setOmProduto(omproduto);

					// Verificacao do PA se nao existir entao cadastrar um novo
					OmPa omPa = null;
					try {
						omPa = rnPT.getOmpa(omprgpos);
						omprgpos.setOmPa(omPa);
					} catch (RegistroDesconhecidoException e) {
						// Se nao existir, verifica se existe como L
						try{
							omprgpos.setFeedertrack(omprgpos.getFeedertrack() + "1"); // Acrescenta o left para novo teste
							omPa = rnPT.getOmpa(omprgpos);
							omprgpos.setOmPa(omPa);
						} catch (RegistroDesconhecidoException e1){
							// Entao incluir o PA caso n�o exista
							// 1o remove o "1" acrescentado anteriormente
							omprgpos.setFeedertrack(omprgpos.getFeedertrack().substring(0, omprgpos.getFeedertrack().length() - 1));
							omPa = rnPT.setOmpa(programa.getOmpt(), omcfg, omprgpos);
							omprgpos.setOmPa(omPa);
						}
					}
					
					/* Alessandre em 22-10-21 verifica se existem alternativos para a posicao. Se sim, valida-los */
					if (omprgpos.getOmPrgposproalts() != null && omprgpos.getOmPrgposproalts().isEmpty() == false) {
						for (OmPrgposproalt proalt : omprgpos.getOmPrgposproalts()) {
							// Avalia se o codigo do produto alternativo existe.
							OmProduto omprodutoAux = omProdutoDAO.getOmProdutoPorCdAtivoOrderByIdDesc(proalt.getOmProduto().getCdProduto());
							if (omprodutoAux == null) {
								// Incluir produto
								omprodutoAux = new OmProduto();
								
								omprodutoAux.setCdProduto(proalt.getOmProduto().getCdProduto());
								omprodutoAux.setTpProduto(OmProdutoTemplate.TpProduto.COMPONENTE.getId());
								
								omprodutoAux.setDsProduto("Cadastrado na importacao de programa");
								omprodutoAux.setMinValposalim(new BigDecimal(0));
								omprodutoAux.setOmCc(omcfg.getOmCcdefault());
								omprodutoAux.setOmUsrByIdUsrrevisao(omcfg.getOmUsrimpprog());
								omprodutoAux.setOmUsrByIdUsrstativo(omcfg.getOmUsrimpprog());

								omprodutoAux.setOmProgrp(omProgrpPadrao);
								omprodutoAux = rnProduto.salvarRevisaoOmProduto(null, omprodutoAux, new Date(), omcfg.getOmUsrimpprog());

							}
							proalt.setOmProduto(omprodutoAux);
							proalt.setOmPrgpos(omprgpos);
						}
					}
					
					// Salva a posicao do programa
					getSession().saveOrUpdate(omprgpos);

				}

				// O trecho abaixo nao eh necessario pois programa.omprgpos esta sendo salvo
				// acima.
//				if (omPrgNovo != null){
//					omPrgNovo.setOmPrgposes(programa.getOmprgpos());
//					omPrgNovo = (OmPrg) makePersistent(omPrgNovo);
//				}
		
			} catch (SemConfiguracaoException e2){
//				retorno.setResultadoEvento(retorno.getERRO_SEMCONFIGURACAO());
				throw new RuntimeException(e2.getCause());
			}

			retorno.setOmprg(omPrgNovo);
			retorno.setOmprgpos(programa.getOmprgpos());
		}
		return retorno;
	}
	
	public OmPrg pesquisarOmPrgByCdEPt(String cdPrg, Long idPt){
		MapQuery q = new MapQuery(getSession());
		
		q.append("from OmPrg omprg");
		q.append("where omprg.cdPrg = :cdprg");
		q.append("and omprg.omPt.idPt = :idpt");
		q.append("and omprg.stAtivo = 1");

		q.defineParametro("cdprg", cdPrg);
		q.defineParametro("idpt", idPt);
		
		q.setMaxResults(1);
		
		return (OmPrg) q.uniqueResult();
	}
}
