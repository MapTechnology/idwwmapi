package idw.model.rn.sap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwEstmov;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.TtSapCon;
import idw.model.pojos.TtTmgCon;
import idw.model.rn.ClienteRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.estoque.EstoqueRN;
import idw.util.IdwLogger;
import idw.webservices.dto.ClienteDTO;
import idw.webservices.dto.TmgConhecimentoDTO;
import idw.webservices.dto.TmgConhecimentosDTO;

public class TmgConhecimentos {
	
	private DAOGenerico dao;
	
	public TmgConhecimentos(DAOGenerico dao) {
		this.dao = dao;
	}
	
	public List<TtTmgCon> getListaPojosTmgConhecimentos(TmgConhecimentoDTO filtro) {
		List<TtTmgCon> retorno = null;
		
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select t ");
		q.append("from TtTmgCon t ");
		q.appendWhere(MapQuery._NULL, " (t.isImportado is null) OR  (t.isImportado=0) ", true );
		q.appendWhere(MapQuery._NULL, " AND t.idTmgcon=:idTmgcon ", (filtro!=null && filtro.getTmgconhecimento()!=null && filtro.getTmgconhecimento().getIdTmgcon()!=null && filtro.getTmgconhecimento().getIdTmgcon().intValue() != 0) );
		q.appendWhere(MapQuery._NULL, " AND t.globalcode=':globalcode' ", (filtro!=null && filtro.getTmgconhecimento()!=null && !filtro.getTmgconhecimento().getGlobalcode().equals("")) );
		q.appendWhere(MapQuery._NULL, " AND t.conhecimento=:conhecimento ", (filtro!=null && filtro.getTmgconhecimento()!=null && !filtro.getTmgconhecimento().getConhecimento().equals("")) );
		q.appendWhere(MapQuery._NULL, " AND t.dthrReferencia=:dthrReferencia ", (filtro!=null && filtro.getTmgconhecimento()!=null) );
		q.appendWhere(MapQuery._NULL, " AND t.dtPrevistaentrada=:dtPrevistaentrada ", (filtro!=null && filtro.getTmgconhecimento()!=null && !filtro.getTmgconhecimento().getDtPrevistaEntrada().equals("")) );
		q.appendWhere(MapQuery._NULL, " AND t.qtMaterial=:qtMaterial ", (filtro!=null && filtro.getTmgconhecimento()!=null && !filtro.getTmgconhecimento().getQtMaterial().equals("")) );
		q.appendWhere(MapQuery._NULL, " AND t.isImportado=:isImportado ", (filtro!=null && filtro.getTmgconhecimento()!=null && filtro.getTmgconhecimento().getIsImportado() != null) );
		q.appendWhere(MapQuery._NULL, " AND t.isTransito=:isTransito ", (filtro!=null && filtro.getTmgconhecimento()!=null && filtro.getTmgconhecimento().getIsTransito() != null) );
		q.appendWhere(MapQuery._NULL, " AND t.dsErro= ':dserro' ", (filtro!=null && filtro.getTmgconhecimento()!=null && filtro.getTmgconhecimento().getDsErro() != null) );
		if (filtro!=null && filtro.getTmgconhecimento()!=null){
			q.defineParametro("idTmgcon", String.valueOf(filtro.getTmgconhecimento().getIdTmgcon()));
			q.defineParametro("globalcode", filtro.getTmgconhecimento().getGlobalcode());
			q.defineParametro("conhecimento", String.valueOf(filtro.getTmgconhecimento().getConhecimento()));
			q.defineParametroData("dthrReferencia", filtro.getTmgconhecimento().getDthrReferencia());
			q.defineParametroData("dtPrevistaentrada", filtro.getTmgconhecimento().getDtPrevistaEntrada());
			q.defineParametro("qtMaterial", filtro.getTmgconhecimento().getQtMaterial());
			q.defineParametro("isImportado", String.valueOf(filtro.getTmgconhecimento().getIsImportado()));
			q.defineParametro("isTransito", String.valueOf(filtro.getTmgconhecimento().getIsTransito()));
			q.defineParametro("dserro", filtro.getTmgconhecimento().getDsErro());
		}
		retorno = q.list();
		
		return retorno;
	}
	
	public void importarTmgConhecimentos(IdwLogger log, int idLog, OmCfg omcfg, OmUsr omusr, TmgConhecimentosDTO tmgconhecimentosdto) {
		ProdutoRN produtorn = new ProdutoRN(dao);
		ClienteRN clientern = new ClienteRN(this.dao);
		EstoqueRN estoquern = new EstoqueRN(this.dao);
		
		OmProduto omproduto = null;
		PpCliente ppcliente = null;
		ClienteDTO clientedto = null;
		DwEstpro dwestpro = null;
		DwEstmov dwestmov = null;
		
		//varredura aba D
    	//TODO: concluir apos tirar duvidas quanto referencias a tabelas nao incluidas inicialmnte na varredura.
    	//varrer ptmgconhecimentos{
            List<TtTmgCon> listatmgconhecimentos;
            listatmgconhecimentos = getListaPojosTmgConhecimentos(null);
            if (listatmgconhecimentos!=null)
            {
            	TtTmgCon newpojo = null;
            	TmgConhecimentoDTO newdto = null;
            	List<TmgConhecimentoDTO> newlistadto =  new ArrayList<TmgConhecimentoDTO>();
            	log.info(idLog, 0, "Iniciando avaliacao dos Tmg Conhecimentos");
            	log.iniciaAvaliacao("TmgConhecimentos");
                for (TtTmgCon i : listatmgconhecimentos)
                {
                	//prepara para a resposta DTO
                	newdto = new TmgConhecimentoDTO();
                	newpojo = i;

                	//primeiro verifica se j� est� no Sap...
                	if (isConhecimentoNoSap(newpojo.getConhecimento()))
                	{
                		newpojo.setIsImportado(true);// importado
                		newpojo.setDsErro("Conhecimento j� presente na base SAP.");
                		newpojo = this.dao.makePersistent(newpojo);
                	}
                	else // prossegue apenas se ainda n�o estiver no Sap...
                	{
                    	//pesquisa globalcode em omproduto.cdproduto
                    	omproduto = produtorn.getProdutoByCdEStAtivo(i.getGlobalcode());
                    	if (omproduto!=null && omproduto.getCdProduto()!=null)
                    	{ //sim, encontrou o produto
                    		
                    		if (omproduto.getTpProduto().intValue()!=1) // ..|| !omproduto.getTpProduto().equals("3")
                    		{
                        		newpojo.setIsImportado(false);//nao importado
                        		newpojo.setDsErro("O produto n�o est� cadastrado como materia-prima.");
                        		newpojo = this.dao.makePersistent(newpojo);            		            			
                    		}
                    		else
                    		{//se ainda tudo Ok, prossegue...
                    			
                    			//pesquisa cliente em ppcliente.cdcliente
                            	clientedto = new ClienteDTO();
                            	clientedto.setCdCliente(i.getCentro() );
                    			ppcliente = clientern.pesquisar(clientedto);
                    			clientedto = null;
                        		if (ppcliente==null || ppcliente.getCdCliente()==null)
                        		{ // se cliente n�o encontrado, sinaliza erro e busca proximo registro
                            		newpojo.setIsImportado(false);//nao importado
                            		newpojo.setDsErro("O cliente n�o existe no sistema. � necess�rio cadastra-lo.");
                            		newpojo = this.dao.makePersistent(newpojo);
                        		}
                        		else
                        		{ //se cliente encontrado, prossegue normalmente...
                        			
                        			dwestpro = new DwEstpro();
                        			dwestpro.setOmProduto(omproduto);
                        			dwestpro = estoquern.pesquisarDwEstproByIdProduto(dwestpro);
                        			if (dwestpro==null)
                        			{ // se nao existe, insere . dw_estpro
                            			dwestpro = new DwEstpro();
                            			dwestpro.setOmProduto(omproduto);
                            			dwestpro.setQtEntrada( BigDecimal.ZERO );
                            			dwestpro.setQtSaida(BigDecimal.ZERO);
                            			dwestpro.setQtAjuste(BigDecimal.ZERO);
                            			dwestpro.setQtReservada(BigDecimal.ZERO);
                            			dwestpro.setPpCliente(ppcliente);
                            			//se produto=1
                            			if (omproduto.getTpProduto()==1)
                            			{	//TODO: ver se primeiro dwestpro.getDwEst pra depois set.id
                            				dwestpro.setDwEst(omcfg.getDwEstByIdEstproducao()); //TODO: quem neste caso?
                            			}
                            			//se produto=3
                            			if (omproduto.getTpProduto()==3)
                            			{
                            				dwestpro.setDwEst(omcfg.getDwEstByIdEstexpedicao()); //TODO: quem neste caso?
                            			}
                            			
                                		newpojo.setIsImportado(true);
                                		newpojo.setDsErro("Primeira importacao do produto.");
                                		newpojo = this.dao.makePersistent(newpojo);
                                		dwestpro = this.dao.makePersistent(dwestpro);
                        				
                        			}
                        			else
                        			{// se existe...
                        				//TODO: supondo que se existe, tratamento separado , antes seguir proximo evento

                        				BigDecimal ajustecalculado = BigDecimal.ZERO;
                        				ajustecalculado = i.getQtMaterial().subtract(dwestpro.getQtEntrada());
                    					ajustecalculado = ajustecalculado.subtract(dwestpro.getQtSaida());
                    					ajustecalculado = ajustecalculado.add(dwestpro.getQtAjuste());

                    					//obtendo usuario logado
                    					//omusr = usrlogadodto.getUsuario().clone();
                    					
                    					dwestmov = new DwEstmov();

                    					boolean ibol = false;
                    					if (i.getIsTransito()) {ibol=false;}else{ibol=true;}
                    					
                    					// altera dwestpro...
                    					//dwestpro.setQtAjuste(ajustecalculado);
                    					if (ibol)
                    					{
                    						dwestpro.setQtAjuste(ajustecalculado);
                    					}
                    					dwestpro = this.dao.makePersistent(dwestpro);

                    					//e incluindo novo reg em dw_estmov...
                    					dwestmov.setDthrMov(i.getDthrReferencia());
                    					dwestmov.setDthrCadastro( DataHoraRN.getDataHoraAtual() );
                    					dwestmov.setTpMov(2);
                    					dwestmov.setDwEstpro(dwestpro);
                    					dwestmov.setTpOrigem(2);
                    					dwestmov.setIsEfetivado( ibol );

                    					
                    					if (dwestmov.getIsEfetivado())
                    					{
                        					dwestmov.setQtAjuste(ajustecalculado);                						
                    					}
                    					else
                    					{
                    						dwestmov.setQtAjuste(i.getQtMaterial());
                    					}

                    					dwestmov.setQtEntradaAnt(dwestpro.getQtEntrada());
                    					dwestmov.setQtSaidaAnt(dwestpro.getQtSaida());
                    					dwestmov.setQtReservadaAnt(dwestpro.getQtReservada());
                    					dwestmov.setOmUsr(omusr);


                    					dwestmov = this.dao.makePersistent(dwestmov);

                    					
                    					
                    					//finalmente sinalizando importacao com sucesso
                                		newpojo.setIsImportado(true);
                                		newpojo.setDsErro("Importa��o efetivada com sucesso.");
                                		newpojo = this.dao.makePersistent(newpojo);
                        			}
                        		}
                    			
                        		//segue proximo
                    		}
                    	}
                    	else
                    	{// se produto nao encontrado
                    		newpojo.setIsImportado(false);//nao importado
                    		newpojo.setDsErro("Produto (como globalcode) n�o existe no cadastro. � necess�rio cadastra-lo.");
                    		newpojo = this.dao.makePersistent(newpojo);
                    	}                		
                	}

                	//finalizando a preparacao do retorno DTO

                	newdto.setTmgconhecimento((TtTmgCon)newpojo.clone());
                	newlistadto.add(newdto);
                	log.paraAvaliacao();
                	log.info(idLog, 0, "Finalizando avaliacao dos Tmg Conhecimentos");
                	log.info(idLog, 10, "Avaliacao Completa da avaliacao Tmg Conhecimentos:");
                    log.info(idLog, 20, log.getAvaliacaoCompleta());
                    log.info(idLog, 0, "\n\n");
                }
                tmgconhecimentosdto.setTmgconhecimentos(newlistadto);//"fatiriza"
            }
    		//}
	}
	
	private boolean isConhecimentoNoSap(String parm_conhecimento) {

		boolean retorno;
		MapQuery q = new MapQuery(this.dao.getSession());
		
		retorno = false;
		
		q.append("select t ");
		q.append("from TtSapCon t ");
		q.appendWhere(MapQuery._NULL, "t.conhecimento=:conhecimento ", (parm_conhecimento!=null && !parm_conhecimento.equals("")) );
		if (parm_conhecimento!=null ){
			q.defineParametro("conhecimento", String.valueOf(parm_conhecimento));
		}
		q.setMaxResults(1);
		List<TtSapCon> listaTtSapCon = null;
		try {
			listaTtSapCon = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (listaTtSapCon != null) {
			for (TtSapCon ttSapCon : listaTtSapCon) {
				if (ttSapCon!=null){retorno=true; break;}
			}
		}
		return retorno;
	}

}
