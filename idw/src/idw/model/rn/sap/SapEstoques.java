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
import idw.model.pojos.TtSapEstmppa;
import idw.model.rn.ClienteRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.ProdutoRN;
import idw.model.rn.estoque.EstoqueRN;
import idw.util.IdwLogger;
import idw.webservices.dto.ClienteDTO;
import idw.webservices.dto.SapEstoqueDTO;
import idw.webservices.dto.SapEstoquesDTO;

public class SapEstoques {
	
	private DAOGenerico dao;
	
	public SapEstoques(DAOGenerico dao) {
		this.dao = dao;
	}
	
	public List<TtSapEstmppa> getListaPojosSapEstoques(SapEstoqueDTO filtro) {
		List<TtSapEstmppa> retorno = null;
		
		MapQuery q = new MapQuery(this.dao.getSession());
		
		q.append("select t ");
		q.append("from TtSapEstmppa t ");
		q.appendWhere(MapQuery._NULL, " (t.isImportado is null) OR  (t.isImportado=0) ", true );
		q.appendWhere(MapQuery._NULL, " AND t.idSapestmppa=:idSapestmppa ", (filtro!=null && filtro.getSapestoque()!=null && filtro.getSapestoque().getIdSapestmppa()!=null && filtro.getSapestoque().getIdSapestmppa().intValue() != 0) );
		q.appendWhere(MapQuery._NULL, " AND t.deposito=':deposito' ", (filtro!=null && filtro.getSapestoque()!=null && !filtro.getSapestoque().getDeposito().equals("")) );
		q.appendWhere(MapQuery._NULL, " AND t.globalcode=':globalcode' ", (filtro!=null && filtro.getSapestoque()!=null && !filtro.getSapestoque().getGlobalcode().equals("")) );
		q.appendWhere(MapQuery._NULL, " AND t.qtEstoque=:qtEstoque ", (filtro!=null && filtro.getSapestoque()!=null && !filtro.getSapestoque().getQtEstoque().equals("")) );
		q.appendWhere(MapQuery._NULL, " AND t.dthrReferencia=:dthrReferencia ", (filtro!=null && filtro.getSapestoque()!=null) );
		q.appendWhere(MapQuery._NULL, " AND t.centro= ':centro' ", (filtro!=null && filtro.getSapestoque()!=null && filtro.getSapestoque().getCentro() != null) );
		q.appendWhere(MapQuery._NULL, " AND t.isImportado=:isImportado ", (filtro!=null && filtro.getSapestoque()!=null && filtro.getSapestoque().getIsImportado() != null) );
		q.appendWhere(MapQuery._NULL, " AND t.dsErro= ':dserro' ", (filtro!=null && filtro.getSapestoque()!=null && filtro.getSapestoque().getDsErro() != null) );
		if (filtro!=null && filtro.getSapestoque()!=null){
			q.defineParametro("idSapestmppa", String.valueOf(filtro.getSapestoque().getIdSapestmppa()));
			q.defineParametro("deposito", filtro.getSapestoque().getDeposito());
			q.defineParametro("globalcode", filtro.getSapestoque().getGlobalcode());
			q.defineParametro("qtEstoque", String.valueOf(filtro.getSapestoque().getQtEstoque()));
			q.defineParametroData("dthrReferencia", filtro.getSapestoque().getDthrReferencia());
			q.defineParametro("centro", filtro.getSapestoque().getCentro());
			q.defineParametro("isImportado", String.valueOf(filtro.getSapestoque().getIsImportado()));
			q.defineParametro("dserro", filtro.getSapestoque().getDsErro());
		}
		
		retorno = q.list();
		
		return retorno;
	}
	
	public void importarSapEstoques(IdwLogger log, int idLog, OmCfg omcfg, OmUsr omusr, SapEstoquesDTO sapestoquesdto) {
		ProdutoRN produtorn = new ProdutoRN(dao);
		EstoqueRN estoquern = new EstoqueRN(this.dao);
		ClienteRN clientern = new ClienteRN(this.dao);
		
		OmProduto omproduto = null;
		PpCliente ppcliente = null;
		ClienteDTO clientedto = null;
		DwEstpro dwestpro = null;
		DwEstmov dwestmov = null;
		
		//pegar Estoques SAP do banco
		List<TtSapEstmppa> listasapestoques = getListaPojosSapEstoques(null);

		//varrer listaSapEstoques{
        if (listasapestoques != null)
        {
        	TtSapEstmppa newpojo = null;
        	SapEstoqueDTO newdto = null;
        	List<SapEstoqueDTO> newlistadto =  new ArrayList<SapEstoqueDTO>();
        	
        	log.info(idLog, 0, "Iniciando avaliacao dos estoques do SAP");
        	log.iniciaAvaliacao("SapEstoques");
            for (TtSapEstmppa i : listasapestoques)
            {
            	//prepara para a resposta DTO
            	newdto = new SapEstoqueDTO();
            	newpojo = i;

            	
            	//pesquisa globalcode em omproduto.cdproduto
            	omproduto = produtorn.getProdutoByCdEStAtivo(i.getGlobalcode());
            	if (omproduto!=null && omproduto.getCdProduto()!=null)
            	{ //sim, encontrou produto
            		
            		if ((omproduto.getTpProduto().intValue()!=1) && (omproduto.getTpProduto().intValue()!=3))
            		{
                		newpojo.setIsImportado(false);//nao importado
                		newpojo.setDsErro("O tipo do produto n�o � semi-acabado ou materia-prima. Modifique o tipo do produto.");
                		newpojo = dao.makePersistent(newpojo);            		            			
            		}
            		else
            		{//se ainda tudo Ok, prossegue...
            			
            			//pesquisa centro em ppcliente.cdcliente
                    	clientedto = new ClienteDTO();
            			clientedto.setCdCliente(i.getCentro());
            			ppcliente = clientern.pesquisar(clientedto);
            			clientedto = null;
                		if (ppcliente==null || ppcliente.getCdCliente()==null)
                		{ // se cliente n�o encontrado, sinaliza erro e busca proximo registro
                    		newpojo.setIsImportado(false);//nao importado
                    		newpojo.setDsErro("O cliente n�o existe no sistema. � necess�rio cadastra-lo");
                    		newpojo = this.dao.makePersistent(newpojo);
                		}
                		else
                		{ // se cliente encontrado, prossegue...
                			
                			dwestpro = new DwEstpro();
                			dwestpro.setOmProduto(omproduto);
                			try {
                				dwestpro = estoquern.pesquisarDwEstproByIdProduto(dwestpro);
                			}catch(Exception ex) {
                				log.info(idLog, 0, "erro ocorrido: ", ex);
                			}
                			if (dwestpro == null)
                			{ // se nao existe, insere . dw_estpro
                    			dwestpro = new DwEstpro();
                    			dwestpro.setOmProduto(omproduto);
                    			dwestpro.setQtEntrada( (i.getQtEstoque()) );
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
                        		newpojo.setDsErro("Lan�amento de primeiro estoque.");
                        		newpojo = this.dao.makePersistent(newpojo);
                        		dwestpro = this.dao.makePersistent(dwestpro);
                				
                			}
                			else
                			{// se existe...
                				//TODO: supondo que se existe, tratamento separado , antes seguir proximo evento
                				Integer saldo = 0;
                				saldo =  dwestpro.getQtEntrada().intValue() - dwestpro.getQtSaida().intValue() + dwestpro.getQtAjuste().intValue();
                				
                				//se saldo == tt.saldo...
                				if (saldo.intValue() == i.getQtEstoque().intValue())
                				{
                            		newpojo.setIsImportado(true);
                            		newpojo.setDsErro("Os saldos dos dois sistemas s�o iguais.");
                            		newpojo = this.dao.makePersistent(newpojo);
                            		
                            		//proximo
                				}
                				else
                				{ // se forem saldos diferentes, ajustar
                					//TODO: confirmar; supondo seguir para AjusteCalculado apenas neste else
                					
                					//obtendo usuario logado
                					//omusr = usrlogadodto.getUsuario().clone();
                					
                					dwestmov = new DwEstmov();
                					
                					BigDecimal ajustecalculado = BigDecimal.ZERO;
                					ajustecalculado = i.getQtEstoque().subtract(dwestpro.getQtEntrada());
                					ajustecalculado = ajustecalculado.subtract(dwestpro.getQtSaida());
                					ajustecalculado = ajustecalculado.add(dwestpro.getQtAjuste());
                					
                					// altera dwestpro
                					dwestpro.setQtAjuste(ajustecalculado);
                					dwestpro = this.dao.makePersistent(dwestpro);
                					
                					//e incluindo novo reg em dw_estmov...
                					dwestmov.setDthrMov(i.getDthrReferencia());
                					dwestmov.setDthrCadastro( DataHoraRN.getDataHoraAtual() );
                					dwestmov.setTpMov(2);
                					dwestmov.setDwEstpro(dwestpro);
                					dwestmov.setTpOrigem(2);
                					dwestmov.setIsEfetivado(true);
                					dwestmov.setQtAjuste(ajustecalculado);
                					dwestmov.setQtEntradaAnt(dwestpro.getQtEntrada());
                					dwestmov.setQtSaidaAnt(dwestpro.getQtSaida());
                					dwestmov.setQtReservadaAnt(dwestpro.getQtReservada());
                					dwestmov.setOmUsr(omusr);
                					this.dao.makePersistent(dwestmov);

                					//finalmente sinalizando importacao com sucesso
                            		newpojo.setIsImportado(true);
                            		newpojo.setDsErro("Importa��o efetivada com sucesso.");
                            		this.dao.makePersistent(newpojo);	
                				}                				
                			}
                		}
                		//segue proximo
            		}
            	}
            	else
            	{// se produto nao encontrado
            		newpojo.setIsImportado(false);//nao importado
            		newpojo.setDsErro("O globalcode n�o existe no sistema. � necess�rio cadastra-lo");
            		this.dao.makePersistent(newpojo);
            	}

            	//finalizando a preparacao do retorno DTO
            	//newpojo.setCentro("c11");//teste TODO:
            	//newpojo.setDeposito("d11");//teste TODO:

            	newdto.setSapestoque((TtSapEstmppa)newpojo.clone());
            	newlistadto.add(newdto);
            }
            sapestoquesdto.setSapestoques(newlistadto);//"fatiriza"
            log.paraAvaliacao();
            log.info(idLog, 0, "Finalizando avaliacao dos estoques do SAP");
            log.info(idLog, 10, "Avaliacao Completa da avaliacao estoques SAP:");
            log.info(idLog, 20, log.getAvaliacaoCompleta());
            log.info(idLog, 0, "\n\n");
        }
		//}
	}

}
