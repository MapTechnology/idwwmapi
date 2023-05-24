package idw.model.rn;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFtEtapa;
import idw.model.pojos.DwFtParam;
import idw.model.pojos.DwFtSub;
import idw.model.pojos.DwFtSubparam;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.webservices.dto.EtapaDTO;
import idw.webservices.dto.EtapaSubDTO;
import idw.webservices.dto.EtapaSubsDTO;
import idw.webservices.dto.EtapasDTO;


@SuppressWarnings("unchecked")
public class EtapaRN extends DAOGenerico{

	public EtapasDTO getEtapasDTO(EtapaDTO filtro){

		String hql="";
		hql += "select t ";
		hql += "from DwFtEtapa t ";		
		hql += "where 1=1 ";

		if (filtro.getEtapa().getIdFtEtapa()!=0){
			hql += "AND t.idFtEtapa=::idFtEtapa: ";
		}else{
			if (filtro.getEtapa().getCdEtapa() != null && !filtro.getEtapa().getCdEtapa().equals("")){
				hql += "AND t.cdEtapa='::cdEtapa:' ";
			}
			if (filtro.getEtapa().getDsEtapa() != null && !filtro.getEtapa().getDsEtapa().equals("")){
				hql += "AND t.dsEtapa='::dsEtapa:' ";
			}
			if (filtro.getEtapa().getDsMensagemnok() != null && !filtro.getEtapa().getDsMensagemnok().equals("")){
				hql += "AND t.dsMensagemnok='::dsMensagemnok:' ";
			}
			if (filtro.getEtapa().getDsMensagemok() != null && !filtro.getEtapa().getDsMensagemok().equals("")){
				hql += "AND t.dsMensagemok='::dsMensagemok:' ";
			}
			if (filtro.getEtapa().getDtRevisao()!=null){
				hql += "AND t.dtRevisao=:dtRevisao ";
			}
			// Com as linhas abaixo ativas, todos as consultas estavam limitadas ao usuario logado
//			if (filtro.getEtapa().getOmUsrByIdUsrrevisao() != null && !filtro.getEtapa().getOmUsrByIdUsrrevisao().getCdUsr().equals("")){
//				hql += "AND t.omUsrByIdUsrrevisao.cdUsr='::cdUsrRev:' ";
//			}
//			if (filtro.getEtapa().getOmUsrByIdUsrrevisao() != null && !filtro.getEtapa().getOmUsrByIdUsrrevisao().getDsNome().equals("")){
//				hql += "AND t.omUsrByIdUsrrevisao.dsNome='::dsNomeRev:' ";
//			}
//			if (filtro.getEtapa().getOmUsrByIdUsrstativo() != null && !filtro.getEtapa().getOmUsrByIdUsrstativo().getCdUsr().equals("")){
//				hql += "AND t.omUsrByIdUsrstativo.cdUsr='::cdUsrSt:' ";
//			}
//			if (filtro.getEtapa().getOmUsrByIdUsrstativo() != null && !filtro.getEtapa().getOmUsrByIdUsrstativo().getDsNome().equals("")){
//				hql += "AND t.omUsrByIdUsrstativo.dsNome='::dsNomeSt:' ";
//			}
			if (filtro.getEtapa().getDtStativo()!=null){
				hql += "AND t.dtStativo=:dtStativo ";
			}
			if (filtro.getEtapa().getRevisao()!=null){
				hql += "AND t.revisao=::revisao: ";
			}
			if (filtro.getEtapa().getStAtivo() != null && filtro.getEtapa().getStAtivo()<(byte)2){
				hql += "AND t.stAtivo=::stAtivo: ";
			}
		}

		hql = hql.replaceAll("::idFtEtapa:", String.valueOf(filtro.getEtapa().getIdFtEtapa()));		
		hql = hql.replaceAll("::cdEtapa:", filtro.getEtapa().getCdEtapa());
		hql = hql.replaceAll("::dsEtapa:", filtro.getEtapa().getDsEtapa());
		hql = hql.replaceAll("::dsMensagemnok:", filtro.getEtapa().getDsMensagemnok());
		hql = hql.replaceAll("::dsMensagemok:", filtro.getEtapa().getDsMensagemok());
		if (filtro.getEtapa().getOmUsrByIdUsrrevisao()!=null){
			hql = hql.replaceAll("::cdUsrRev:", filtro.getEtapa().getOmUsrByIdUsrrevisao().getCdUsr());
			hql = hql.replaceAll("::dsNomeRev:", filtro.getEtapa().getOmUsrByIdUsrrevisao().getDsNome());
		}
		if (filtro.getEtapa().getOmUsrByIdUsrstativo()!=null){
			hql = hql.replaceAll("::cdUsrSt:", filtro.getEtapa().getOmUsrByIdUsrstativo().getCdUsr());
			hql = hql.replaceAll("::dsNomeSt:", filtro.getEtapa().getOmUsrByIdUsrstativo().getDsNome());
		}
		hql = hql.replaceAll("::revisao:", String.valueOf(filtro.getEtapa().getRevisao()));
		hql = hql.replaceAll("::stAtivo:", String.valueOf(filtro.getEtapa().getStAtivo()));

		Query q = getSession().createQuery(hql);

		try {
			//q.setDate("dtRevisao", filtro.getUsuario().getDtRevisao());			
			q.setTimestamp("dtRevisao", filtro.getEtapa().getDtRevisao());
		} catch (Exception e) {
			
		}		
		try {
			//q.setDate("dtStativo", filtro.getUsuario().getDtStativo());
			q.setTimestamp("dtStativo", filtro.getEtapa().getDtStativo());
		} catch (Exception e) {
			
		}

		List<DwFtEtapa> listaPesquisa = null;
		try{
			listaPesquisa = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}

		List<EtapaDTO> lista = new ArrayList<EtapaDTO>();

		if (listaPesquisa != null){
			for (DwFtEtapa item : listaPesquisa) {
				EtapaDTO itemDTO = new EtapaDTO();								
				itemDTO.setEtapa((DwFtEtapa)item.clone());
				itemDTO.setSubs(new EtapaSubsDTO());	
				
				List<EtapaSubDTO> subs = new ArrayList<EtapaSubDTO>();
				
				//DwFtSubs			
				for (DwFtSub itemList : item.getDwFtSubs()) {					
					DwFtSub dwFtSub = (DwFtSub)itemList.clone();					
					
//					for (DwFtSubparam dwFtSubparam : itemList.getDwFtSubparams()){
//						dwFtSub.getDwFtSubparams().add((DwFtSubparam) dwFtSubparam.clone());
//						//System.out.println(dwFtSubparam.getDwFtParam().getDsParametro());
//					}
					
					EtapaSubDTO sub = new EtapaSubDTO();
					sub.setDwFtSub(dwFtSub);
					
					subs.add(sub);					
				}	
				
				itemDTO.getSubs().setDwFtSubs(subs);
				itemDTO.setSubsParaExclusao(new EtapaSubsDTO());
				itemDTO.getSubsParaExclusao().setDwFtSubs(new ArrayList<EtapaSubDTO>());
				
				itemDTO.setResultadoEvento(0);
				lista.add(itemDTO);
			}
		}

		EtapasDTO dtoRetorno = new EtapasDTO();
		dtoRetorno.setEtapas(lista);
		return dtoRetorno;
	}
	
	private void inclusao(EtapaDTO itemDTO, DwFtEtapa itemOriginal, EtapaDTO dtoRetorno, DwFtEtapa itemAlteracao){
		String hql = "";
		Query q = null;
		
		
		Set<DwFtSub> dwFtSubs = new HashSet<DwFtSub>();
		if (itemDTO.getSubs().getDwFtSubs() != null){
			for (EtapaSubDTO item : itemDTO.getSubs().getDwFtSubs()) {	
				DwFtSub sub = (DwFtSub)item.getDwFtSub().clone();					
				
				// Se for uma subetapa por evento, avaliar se o parametro do evento existe
				if (item.getDwFtSub().getTpFtSub() == 1){
					//id_ft_param
					if (item.getDwFtSub().getDwFtParam() == null || item.getDwFtSub().getDwFtParam().getIdFtParam() == 0){
						//Verifica se o id_ft_param existe			
						try {
							hql = "from DwFtParam t where t.idFtParam = ::idFtParam ";
							
							hql = hql.replaceAll("::idFtParam", String.valueOf(item.getDwFtSub().getDwFtParam().getIdFtParam()));

							q = getSession().createQuery(hql);

							DwFtParam itemParam = (DwFtParam) q.list().get(0);

							sub.setDwFtParam(itemParam);							
							
						} catch (Exception e) {
							dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PARAMETRO_EVENTO_DESCONHECIDO());									
						}						
					}
				}
				
				// Avaliar se o produto existe
				if ( item.getDwFtSub().getOmProduto() != null && 
						item.getDwFtSub().getOmProduto().getCdProduto() != null && 
						!item.getDwFtSub().getOmProduto().getCdProduto().equals("")){
					//Verifica se o id_produto existe			
					try {
						hql = "from OmProduto t where t.cdProduto = '::cdProduto' ";
						hql += "and t.stAtivo = 1 ";
						hql += "order by t.idProduto ";
						
						hql = hql.replaceAll("::cdProduto", String.valueOf(item.getDwFtSub().getOmProduto().getCdProduto()));

						q = getSession().createQuery(hql);

						OmProduto itemProd = (OmProduto) q.list().get(0);

						sub.setOmProduto(itemProd);							
						
					} catch (Exception e) {
						dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_COMPONENTE_DESCONHECIDO());								
					}					
					
				}
				
				
				// Avaliar se os parametros existem.
				if (item.getDwFtSub().getDwFtSubparams() != null){
					Set<DwFtSubparam> params = new HashSet<DwFtSubparam>();
					for (DwFtSubparam dwFtSubparam : item.getDwFtSub().getDwFtSubparams()) {
						dwFtSubparam.setIdSubparam(0l);										
						if (dwFtSubparam.getDwFtParam() != null){
							//Verifica se o idFtParam existe			
							try {
								hql = "from DwFtParam t where t.idFtParam = ::idFtParam ";
								
								hql = hql.replaceAll("::idFtParam", String.valueOf(dwFtSubparam.getDwFtParam().getIdFtParam()));
	
								q = getSession().createQuery(hql);
	
								DwFtParam itemParam = (DwFtParam) q.list().get(0);
	
								dwFtSubparam.setDwFtParam(itemParam);	
								dwFtSubparam.setDwFtSub(sub);
								params.add(dwFtSubparam);
							} catch (Exception e) {
								dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PARAMETRO_MEDICAO_DESCONHECIDO());												
							}
						}										
					}
					sub.setDwFtSubparams(params);
				}
				
				dwFtSubs.add(sub);
			}
		}
		
		// Relaciona as subetapas a etapa
		itemOriginal.setDwFtSubs(dwFtSubs);
		
		// Relaciona a etapa as subetapas
		for (DwFtSub item : itemOriginal.getDwFtSubs()) {				
			item.setDwFtEtapa(itemOriginal);				
		}
	}
	
	private void alteracao(EtapaDTO itemDTO, DwFtEtapa itemOriginal, EtapaDTO dtoRetorno, DwFtEtapa itemAlteracao){
		String hql = "";
		Query q = null;

		// Item Alteracao deve receber um clone do itemOriginal, sem os ids
		itemAlteracao = new DwFtEtapa();
		itemAlteracao.copy(itemOriginal, true);
		itemAlteracao.setIdFtEtapa(0l);			
		itemAlteracao.setStAtivo((byte)0);
		itemAlteracao.setDtStativo(new Date());
		
		// Se vieram subetapas para exclusao, excluir as subetapas
		if (itemDTO.getSubsParaExclusao().getDwFtSubs() != null){
			for (EtapaSubDTO item : itemDTO.getSubsParaExclusao().getDwFtSubs()) {
				for (Iterator<DwFtSub> iterator = itemOriginal.getDwFtSubs().iterator(); iterator.hasNext();) {
					DwFtSub itemSub = (DwFtSub) iterator.next();						
					if (item.getDwFtSub().getIdFtSub()==itemSub.getIdFtSub()){
						// Antes de excluir verificar se esta sendo usada em alguma folha
						// Se sim, enviar mensagem para GUI informando q 1o deve.
						// TODO Viagem piloto
						hql = "select a ";
						hql += "from DwTestesub a ";
						hql += "where a.idTestesub = ::idtestesub ";
						
//						hql = hql.replaceAll("::idtestesub", replacement)
						getSession().delete(itemSub);
						iterator.remove();
						continue;
					}
				}				
			}
		}

		//inclus�o e altera��o
		if (itemDTO.getSubs().getDwFtSubs() != null){
			for (EtapaSubDTO item : itemDTO.getSubs().getDwFtSubs()) {
				//inclus�o
				if (item.getDwFtSub().getIdFtSub()==0){
					DwFtSub dwFtSub = new DwFtSub();
					dwFtSub.copy(item.getDwFtSub(), false);

					dwFtSub.setDwFtEtapa(itemOriginal);

					if (item.getDwFtSub().getTpFtSub() == 1){
						//id_ft_param
						if (item.getDwFtSub().getDwFtParam() == null || item.getDwFtSub().getDwFtParam().getIdFtParam() == 0){
							//Verifica se o id_ft_param existe			
							try {
								hql = "from DwFtParam t where t.idFtParam = ::idFtParam ";
								
								hql = hql.replaceAll("::idFtParam", String.valueOf(item.getDwFtSub().getDwFtParam().getIdFtParam()));

								q = getSession().createQuery(hql);

								DwFtParam itemParam = (DwFtParam) q.list().get(0);

								dwFtSub.setDwFtParam(itemParam);							
								
							} catch (Exception e) {
								dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PARAMETRO_EVENTO_DESCONHECIDO());									
							}						
						}
					}
					if ( item.getDwFtSub().getOmProduto() != null && 
							item.getDwFtSub().getOmProduto().getCdProduto() != null && 
							!item.getDwFtSub().getOmProduto().getCdProduto().equals("")){
						//Verifica se o id_produto existe			
						try {
							hql = "from OmProduto t where t.cdProduto = '::cdProduto' ";
							hql += "and t.stAtivo = 1 ";
							hql += "order by t.idProduto ";
							
							hql = hql.replaceAll("::cdProduto", String.valueOf(item.getDwFtSub().getOmProduto().getCdProduto()));

							q = getSession().createQuery(hql);

							OmProduto itemProd = (OmProduto) q.list().get(0);

							dwFtSub.setOmProduto(itemProd);							
							
						} catch (Exception e) {
							dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_COMPONENTE_DESCONHECIDO());								
						}					
						
					}
					if (item.getDwFtSub().getDwFtSubparams() != null){
						Set<DwFtSubparam> params = new HashSet<DwFtSubparam>();
						for (DwFtSubparam dwFtSubparam : item.getDwFtSub().getDwFtSubparams()) {
							dwFtSubparam.setIdSubparam(0l);										
							if (dwFtSubparam.getDwFtParam() != null){
								//Verifica se o idFtParam existe			
								try {
									hql = "from DwFtParam t where t.idFtParam = ::idFtParam ";
									
									hql = hql.replaceAll("::idFtParam", String.valueOf(dwFtSubparam.getDwFtParam().getIdFtParam()));
		
									q = getSession().createQuery(hql);
		
									DwFtParam itemParam = (DwFtParam) q.list().get(0);
		
									dwFtSubparam.setDwFtParam(itemParam);	
									dwFtSubparam.setDwFtSub(dwFtSub);
									params.add(dwFtSubparam);
								} catch (Exception e) {
									dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PARAMETRO_MEDICAO_DESCONHECIDO());												
								}
							}										
						}
						dwFtSub.setDwFtSubparams(params);
					}
					itemOriginal.getDwFtSubs().add(dwFtSub);
				//altera��o
				}else{
					for (DwFtSub itemSub : itemOriginal.getDwFtSubs()){
						if (item.getDwFtSub().getIdFtSub()==itemSub.getIdFtSub()){
							itemSub.copy(item.getDwFtSub(), false);
							
							if (item.getDwFtSub().getTpFtSub() == 1){ // Evento
								//id_ft_param
								if (item.getDwFtSub().getDwFtParam() == null || item.getDwFtSub().getDwFtParam().getIdFtParam() == 0){
									//Verifica se o id_ft_param existe			
									try {
										hql = "from DwFtParam t where t.idFtParam = ::idFtParam ";
										
										hql = hql.replaceAll("::idFtParam", String.valueOf(item.getDwFtSub().getDwFtParam().getIdFtParam()));

										q = getSession().createQuery(hql);

										DwFtParam itemParam = (DwFtParam) q.list().get(0);

										itemSub.setDwFtParam(itemParam);							
										
									} catch (Exception e) {
										dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PARAMETRO_EVENTO_DESCONHECIDO());									
									}						
								}
							}
							if ( item.getDwFtSub().getOmProduto() != null && 
									item.getDwFtSub().getOmProduto().getCdProduto() != null && 
									!item.getDwFtSub().getOmProduto().getCdProduto().equals("")){
								//Verifica se o id_produto existe			
								try {
									hql = "from OmProduto t where t.cdProduto = '::cdProduto' ";
									hql += "and t.stAtivo = 1 ";
									hql += "order by t.idProduto ";
									
									hql = hql.replaceAll("::cdProduto", String.valueOf(item.getDwFtSub().getOmProduto().getCdProduto()));

									q = getSession().createQuery(hql);

									OmProduto itemProd = (OmProduto) q.list().get(0);

									itemSub.setOmProduto(itemProd);							
									
								} catch (Exception e) {
									dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_COMPONENTE_DESCONHECIDO());								
								}					
								
							}
//							for (Iterator iterator = itemSub.getDwFtSubparams().iterator(); iterator.hasNext();) {
//								DwFtSubparam itemSubParam = (DwFtSubparam) iterator.next();														
//								getSession().delete(itemSubParam);
//								iterator.remove();							
//							}								
							
							if (item.getDwFtSub().getDwFtSubparams() != null){
								// Inclui os novos parametros
								Set<DwFtSubparam> params = new HashSet<DwFtSubparam>();
								for (DwFtSubparam dwFtSubparam : item.getDwFtSub().getDwFtSubparams()) {
									dwFtSubparam.setIdSubparam(0l);										
									if (dwFtSubparam.getDwFtParam() != null){
										//Verifica se o idFtParam existe			
										try {
											hql = "from DwFtParam t where t.idFtParam = ::idFtParam ";
											
											hql = hql.replaceAll("::idFtParam", String.valueOf(dwFtSubparam.getDwFtParam().getIdFtParam()));
				
											q = getSession().createQuery(hql);
				
											DwFtParam itemParam = (DwFtParam) q.list().get(0);
				
											dwFtSubparam.setDwFtParam(itemParam);	
											dwFtSubparam.setDwFtSub(itemSub);
											
										} catch (Exception e) {
											dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_PARAMETRO_MEDICAO_DESCONHECIDO());												
										}
										
										// Verifica se o parametro ja existe no cadastro dos parametros da sub-etapa
										// Se existir, nao incluir novamente
										try {
											hql = "from DwFtSubparam t where t.dwFtSub.idFtSub = ::idftsub and ";
											hql+= "t.dwFtParam.idFtParam = ::idftparam ";
											
											hql = hql.replaceAll("::idftsub", String.valueOf(item.getDwFtSub().getIdFtSub()));
											hql = hql.replaceAll("::idftparam", String.valueOf(dwFtSubparam.getDwFtParam().getIdFtParam()));

											q = getSession().createQuery(hql);

											if (q.list().size() <= 0)
												params.add(dwFtSubparam);
											
										} catch (Exception e){
											e.printStackTrace();
										}
									}										
								}
								itemSub.setDwFtSubparams(params);
								
								// Exclui (se possivel) os parametros solicitados para exclusao
								// 1o Obter todos os parametros gravados
								// 2o Para cada parametro gravado verificar se existe em item.getDwFtSub().getDwFtSubparams()
								// 3o Se nao existir, deletar do banco
								hql = "";
								hql+= "select a ";
								hql+= "from DwFtSubparam a ";
								hql+= "where a.dwFtSub.idFtSub = ::idftsub ";
								
								hql = hql.replaceAll("::idftsub", String.valueOf(item.getDwFtSub().getIdFtSub()));
								
								q = getSession().createQuery(hql);
								
								List<DwFtSubparam> paramsGravados = q.list();
								
								for (DwFtSubparam o : paramsGravados){
									boolean isExiste = false;
									for (DwFtSubparam e : item.getDwFtSub().getDwFtSubparams()){
										if (e.getDwFtParam().getIdFtParam() == o.getDwFtParam().getIdFtParam() &&
											e.getDwFtSub().getIdFtSub() == o.getDwFtSub().getIdFtSub()){
											isExiste = true;
											break;
										}
									}
									if (isExiste == false){
										getSession().delete(o);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private void avaliaSeUsuarioRevisaoExiste(EtapaDTO itemDTO, DwFtEtapa itemOriginal, EtapaDTO dtoRetorno, DwFtEtapa itemAlteracao){
		String hql = "";
		Query q = null;
		
		// Avalia se usuario da revisao existe
		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";

			hql = hql.replaceAll("::cdUsr", itemDTO.getEtapa().getOmUsrByIdUsrrevisao().getCdUsr());

			q = getSession().createQuery(hql);

			OmUsr omUsrRevisao = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrrevisao(omUsrRevisao);

			if (itemAlteracao != null)
				itemAlteracao.setOmUsrByIdUsrstativo(omUsrRevisao);

		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_REVISAO_DESCONHECIDO());
			e.printStackTrace();
		}
	}
	
	private void avaliaSeUsuarioStAtivoExiste(EtapaDTO itemDTO, DwFtEtapa itemOriginal, EtapaDTO dtoRetorno){
		String hql = "";
		Query q = null;
		
		// Avalia se usuario do stativo existe
		try {
			hql = "from OmUsr t where t.cdUsr = '::cdUsr' ";
			hql += "and t.stAtivo = 1 ";
			hql += "order by t.idUsr ";
			hql = hql.replaceAll("::cdUsr", itemDTO.getEtapa().getOmUsrByIdUsrstativo().getCdUsr());

			q = getSession().createQuery(hql);

			OmUsr omUsrStAtivo = (OmUsr) q.list().get(0);

			itemOriginal.setOmUsrByIdUsrstativo(omUsrStAtivo);
		} catch (Exception e) {
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_USUARIO_STATUS_DESCONHECIDO());
			e.printStackTrace();
		}
	}

	
	public EtapaDTO setEtapaDTO(EtapaDTO itemDTO){
		 EtapaDTO dtoRetorno = new EtapaDTO();
		 String hql = "";
		 Query q = null;
		 DwFtEtapa itemOriginal = null;
		 DwFtEtapa itemAlteracao = null;

		 dtoRetorno.setResultadoEvento(dtoRetorno.getEVENTO_BEM_SUCEDIDO());

		if (itemDTO.getEtapa().getCdEtapa().trim().equals("")){
			dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_CDETAPA_INVALIDO());
			return dtoRetorno;
		}
		
		boolean isInclusao = false;

		hql = "from DwFtEtapa t where t.idFtEtapa = ::idFtEtapa ";
		hql = hql.replaceAll("::idFtEtapa", String.valueOf(itemDTO.getEtapa().getIdFtEtapa()));

		q = getSession().createQuery(hql);

		itemOriginal = (DwFtEtapa) q.uniqueResult();
		itemAlteracao = null;

		if (itemOriginal == null){
			itemOriginal = (DwFtEtapa)itemDTO.getEtapa().clone();
			itemOriginal.setRevisao(1l);
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setStAtivo((byte)1);
			itemOriginal.setDtStativo(new Date());			
			
			// Verifica se o codigo + revisao ja existe no banco, se exitir retornar ao cliente a excessao
			hql = "";

			hql += "from DwFtEtapa t ";
			hql += "where t.cdEtapa = '::cdEtapa' and t.stAtivo = 1 ";			

			hql = hql.replaceAll("::cdEtapa", itemOriginal.getCdEtapa());			
			q = getSession().createQuery(hql);

			if (q.list().size() > 0){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_ETAPA_JA_EXISTE());
				return dtoRetorno;
			}
			
			isInclusao = true;
		}else{
			itemOriginal.copy(itemDTO.getEtapa(), false);			
			itemOriginal.setDtRevisao(new Date());
			itemOriginal.setRevisao(itemOriginal.getRevisao()+1);					
		}		

		dtoRetorno.setResultadoEvento(validaEtapa(itemDTO));
		if (dtoRetorno.getResultadoEvento() != dtoRetorno.getEVENTO_BEM_SUCEDIDO()){
			return dtoRetorno;
		}
		
		// Somente apos pesquisar se a nova revisao ja existe � que o pojo original deve ter a revisao somada, se for antes,
		// a pesquisa acima ira trazer o pojo somado
		if (isInclusao == true){
			inclusao(itemDTO, itemOriginal, dtoRetorno, itemAlteracao);
		}else {
			alteracao(itemDTO, itemOriginal, dtoRetorno, itemAlteracao);
		}	

		avaliaSeUsuarioRevisaoExiste(itemDTO, itemOriginal, dtoRetorno, itemAlteracao);
		avaliaSeUsuarioStAtivoExiste(itemDTO, itemOriginal, dtoRetorno);
		

		// Salva registros novos ou altera existentes
		if (dtoRetorno.getResultadoEvento() == dtoRetorno.getEVENTO_BEM_SUCEDIDO()){
			try{
				itemOriginal = (DwFtEtapa) makePersistent(itemOriginal);
				if (itemAlteracao != null){
					makePersistent(itemAlteracao);
				}
			} catch (Exception e){
				dtoRetorno.setResultadoEvento(dtoRetorno.getERRO_DESCONHECIDO());
				e.printStackTrace();
			}

			// Prepara DTO de retorno com o registro incluido ou alterado
			dtoRetorno.setEtapa((DwFtEtapa)itemOriginal.clone());
			dtoRetorno.setSubs(new EtapaSubsDTO());	
			
			List<EtapaSubDTO> subs = new ArrayList<EtapaSubDTO>();
			
			//DwFtSubs			
			for (DwFtSub itemList : itemOriginal.getDwFtSubs()) {					
				DwFtSub dwFtSub = (DwFtSub)itemList.clone();					
				
				dwFtSub.setDwFtSubparams(new HashSet<DwFtSubparam>());
				for (DwFtSubparam dwFtSubparam : itemList.getDwFtSubparams()){
					dwFtSub.getDwFtSubparams().add((DwFtSubparam) dwFtSubparam.clone());
				}
				
				EtapaSubDTO sub = new EtapaSubDTO();
				sub.setDwFtSub(dwFtSub);
				
				subs.add(sub);					
			}	
			
			dtoRetorno.getSubs().setDwFtSubs(subs);
			dtoRetorno.setSubsParaExclusao(new EtapaSubsDTO());
			dtoRetorno.getSubsParaExclusao().setDwFtSubs(new ArrayList<EtapaSubDTO>());			
			
		}

		return dtoRetorno;
	}	

	public EtapasDTO removeEtapasDTO(EtapasDTO itensDTO){

		List<EtapaDTO> listaRetorno = new ArrayList<EtapaDTO>();
		for (EtapaDTO item : itensDTO.getEtapas()){
			EtapaDTO itemRetorno = new EtapaDTO();
			String hql = "";

			hql = "from DwFtEtapa t where t.idFtEtapa = ::idFtEtapa";
			hql = hql.replaceAll("::idFtEtapa", String.valueOf(item.getEtapa().getIdFtEtapa()));

			Query q = getSession().createQuery(hql);

			DwFtEtapa itemOriginal = (DwFtEtapa) q.uniqueResult();

			if (itemOriginal == null){			
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDETAPA_INVALIDO());
				itemRetorno.setEtapa(item.getEtapa());				
			}else if (itemOriginal.getStAtivo()==0){			
				itemRetorno.setResultadoEvento(itemRetorno.getERRO_CDETAPA_INVALIDO());
				itemRetorno.setEtapa((DwFtEtapa)itemOriginal.clone());				
			}else{
				itemOriginal.setStAtivo((byte)0);
				itemOriginal.setDtStativo(new Date());				

				try{
					itemOriginal = (DwFtEtapa) makePersistent(itemOriginal);			
				} catch (Exception e){
					e.printStackTrace();
				}				

				itemRetorno.setEtapa((DwFtEtapa)itemOriginal.clone());
				itemRetorno.setSubs(new EtapaSubsDTO());	
				
				List<EtapaSubDTO> subs = new ArrayList<EtapaSubDTO>();
				
				//DwFtSubs			
				for (DwFtSub itemList : itemOriginal.getDwFtSubs()) {					
					DwFtSub dwFtSub = (DwFtSub)itemList.clone();					
					
					for (DwFtSubparam dwFtSubparam : itemList.getDwFtSubparams()){
						dwFtSub.getDwFtSubparams().add((DwFtSubparam) dwFtSubparam.clone());
					}
					
					EtapaSubDTO sub = new EtapaSubDTO();
					sub.setDwFtSub(dwFtSub);
					
					subs.add(sub);					
				}	
				
				itemRetorno.getSubs().setDwFtSubs(subs);
				itemRetorno.setSubsParaExclusao(new EtapaSubsDTO());
				itemRetorno.getSubsParaExclusao().setDwFtSubs(new ArrayList<EtapaSubDTO>());	
				
				itemRetorno.setResultadoEvento(0);
			}									

			listaRetorno.add(itemRetorno);
		}

		EtapasDTO itensRetorno = new EtapasDTO();
		itensRetorno.setEtapas(listaRetorno);
		return itensRetorno;
	}
	
	private int validaEtapa(EtapaDTO etapa){
		EtapaDTO retorno = new EtapaDTO();
		DwFtEtapa dwFtEtapa = etapa.getEtapa();
		//ds_mensagemok
		if (dwFtEtapa.getDsMensagemok() == null || dwFtEtapa.getDsMensagemok().equals("")){
			return retorno.getERRO_MSGOK_INVALIDA();
		}
		//ds_mensagemnok
		if (dwFtEtapa.getDsMensagemnok() == null || dwFtEtapa.getDsMensagemnok().equals("")){
			return retorno.getERRO_MSGNOK_INVALIDA();
		}
		if (etapa.getSubs().getDwFtSubs() != null){		
			for (EtapaSubDTO itemSubDTO : etapa.getSubs().getDwFtSubs()) {
				DwFtSub dwFtSub = itemSubDTO.getDwFtSub();
				//dwFtSub.setIdFtSub(0l);
//				DwFtSub itemSub = null;
//				if (dwFtSub.getIdFtSub() > 0){
//					try {
//						String hql = "from DwFtSub t where t.idFtSub = ::idFtSub ";						
//						hql = hql.replaceAll("::idFtSub", String.valueOf(dwFtSub.getIdFtSub()));
//						//itemList.setIdFtSub(0l);
//						
//						Query q = getSession().createQuery(hql);
//
//						itemSub = (DwFtSub)q.uniqueResult();
//						dwFtSub.copy(itemSub, false);						
//						//item.setOmProduto(itemList.getOmProduto());
//						//item.setDwFtSubparams(itemList.getDwFtSubparams());
//					} catch (Exception e) {
//						e.printStackTrace();
//						return retorno.getERRO_DESCONHECIDO();						
//					}
//				}else{
//					itemSub = dwFtSub;
//				}
					
				//tp_ft_sub
				if (dwFtSub.getTpFtSub() == null || dwFtSub.getTpFtSub() < 0 || dwFtSub.getTpFtSub() > 2){
					return retorno.getERRO_TIPO_SUBETAPA_DESCONHECIDO();
				}
				//tp_status
				if (dwFtSub.getTpStatus() == null || dwFtSub.getTpStatus() < 0 || dwFtSub.getTpStatus() > 3){
					return retorno.getERRO_CATEGORIA_SUBETAPA_DESCONHECIDA();
				}
				//tp_status VALORES
				if (dwFtSub.getTpStatus() == 1){
					if (dwFtSub.getX41() == null ||
							dwFtSub.getX42() == null ||
							dwFtSub.getY81() == null ||
							dwFtSub.getY82() == null ||
							dwFtSub.getY83() == null ||
							dwFtSub.getY84() == null )
					return retorno.getERRO_PARAMETROS_9998_DESCONHECIDOS();
				}
				//tp_ft_sub VALORES
				if (dwFtSub.getTpFtSub() == 1){
					//id_ft_param
					if (dwFtSub.getDwFtParam() == null || dwFtSub.getDwFtParam().getIdFtParam() == 0){
						//Verifica se o id_ft_param existe			
						try {
							String hql = "from DwFtParam t where t.idFtParam = ::idFtParam ";
							
							hql = hql.replaceAll("::idFtParam", String.valueOf(dwFtSub.getDwFtParam().getIdFtParam()));

							Query q = getSession().createQuery(hql);

							DwFtParam item = (DwFtParam) q.list().get(0);

//							itemSub.setDwFtParam(item);							
							
						} catch (Exception e) {
							return retorno.getERRO_PARAMETRO_EVENTO_DESCONHECIDO();
						}						
					}
					//tp_ft_param
					if (dwFtSub.getTpFtParam() == null || dwFtSub.getTpFtParam() < 1 || dwFtSub.getTpFtParam() > 3){
						return retorno.getERRO_COMPARADOR_INVALIDO();
					}
					//vl_ft_param
					if (dwFtSub.getVlFtParam() != null && dwFtSub.getVlFtParam().intValue() < 0){
						return retorno.getERRO_VALOR_EVENTO_INVALIDO();
					}
					//st_ft_param
					if (dwFtSub.getDwFtParam().getIsCombo()){
						if (dwFtSub.getStFtParam() == null || 
								(dwFtSub.getStFtParam().byteValue() != dwFtSub.getDwFtParam().getStValor1().byteValue() &&
										dwFtSub.getStFtParam().byteValue() != dwFtSub.getDwFtParam().getStValor2().byteValue() &&
										dwFtSub.getStFtParam().byteValue() != dwFtSub.getDwFtParam().getStValor3().byteValue() &&
										dwFtSub.getStFtParam().byteValue() != dwFtSub.getDwFtParam().getStValor4().byteValue())){
							return retorno.getERRO_CONSIDACAO_DESCONHECIDO();
						}
					}
				}
				//id_produto
				if (dwFtSub.getOmProduto() == null || dwFtSub.getOmProduto().getCdProduto() == null || dwFtSub.getOmProduto().getCdProduto().equals("")){
					dwFtSub.setOmProduto(null);
				}
				if ( dwFtSub.getOmProduto() != null && 
						dwFtSub.getOmProduto().getCdProduto() != null && 
						!dwFtSub.getOmProduto().getCdProduto().equals("")){
					//Verifica se o id_produto existe			
					try {
						String hql = "from OmProduto t where t.cdProduto = '::cdProduto' ";
						hql += "and t.stAtivo = 1 ";
						hql += "order by t.idProduto ";
						
						hql = hql.replaceAll("::cdProduto", String.valueOf(dwFtSub.getOmProduto().getCdProduto()));

						Query q = getSession().createQuery(hql);

						OmProduto item = (OmProduto) q.list().get(0);

//						itemSub.setOmProduto(item);							
						
					} catch (Exception e) {
						return retorno.getERRO_COMPONENTE_DESCONHECIDO();
					}					
					
				}
				if (dwFtSub.getDwFtSubparams() != null){
					for (DwFtSubparam dwFtSubparam : dwFtSub.getDwFtSubparams()) {
						dwFtSubparam.setIdSubparam(0l);
						if (dwFtSubparam.getIdSubparam() > 0){
							
						}else{
							if (dwFtSubparam.getDwFtParam() != null){
								//Verifica se o idFtParam existe			
								try {
									String hql = "from DwFtParam t where t.idFtParam = ::idFtParam ";
									
									hql = hql.replaceAll("::idFtParam", String.valueOf(dwFtSubparam.getDwFtParam().getIdFtParam()));
		
									Query q = getSession().createQuery(hql);
		
									DwFtParam item = (DwFtParam) q.list().get(0);
		
//									dwFtSubparam.setDwFtParam(item);	
//									dwFtSubparam.setDwFtSub(itemSub);
									
								} catch (Exception e) {
									return retorno.getERRO_PARAMETRO_MEDICAO_DESCONHECIDO();
								}
							}
						}
					}
				}
//				dwFtSub = itemSub;
			}
		}
		
		return retorno.getEVENTO_BEM_SUCEDIDO();
	}
	
}

