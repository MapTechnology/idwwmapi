package ms.model.rn.importacao.mws;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.mws.DAOGenericoMws;
import idw.model.dao.tdba.DAOGenericoTdba;

import idw.model.pojos.mws.Movimento;
import idw.model.pojos.tdba.ApontPesagens;
import idw.model.pojos.tdba.ApontPesagensCbMp;
import idw.model.pojos.tdba.SbOpsMp;
import idw.model.rn.DataHoraRN;


import ms.model.dao.AbstractMwsTdbaInjetDAO; 

import idw.util.IdwLogger;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;


public class ImportaMovimentacaoParaTdba extends AbstractMwsTdbaInjetDAO implements IImportaParaTdba {

	//private DAOGenericoInjet daoInjet;
	//private DAOGenericoMws daoMws;
	//private DAOGenericoTdba daoTdba;
	private IdwLogger log;
	public ImportaMovimentacaoParaTdba(IdwLogger log, DAOGenericoMws daoMws, DAOGenericoTdba daoTdba, DAOGenericoInjet daoInjet){
		Validate.notNull(daoMws);
		Validate.notNull(daoInjet);
		Validate.notNull(daoTdba);
		Validate.notNull(log);
		this.log = log;
		this.setDaoInjet(daoInjet) ;
		this.setDaoMws(daoMws);
		this.setDaoTdba(daoTdba);
		
		
	}
	
	@Override
	public void importar(List<Movimento> lstMovimento) {
		// TODO Auto-generated method stub
		int idLog = log.getIdAleatorio();
		Date dthrAtual = DataHoraRN.getDataHoraAtual();
		
		try{
			//Faço a pesquisa inicial pra saber onde foi q parei 
			MapQuery qTdba = new MapQuery(this.getDaoTdba().getSession());
			qTdba.append("select apontpesagens");
			qTdba.append("from ApontPesagens apontpesagens");
			qTdba.append("where apontpesagens.movIdt IS NOT NULL");  
			qTdba.append("order by apontpesagens.movIdt desc");

			qTdba.setMaxResults(1);
			ApontPesagens apont = null;
			try{
				apont = (ApontPesagens) qTdba.uniqueResult();
			}catch(Exception exc){
				log.error(idLog,0, exc.getMessage() );
				exc.printStackTrace();
				
			}

			//Não existe apontamento cadastrado.. pegar todos os dados cadastrados
			//Somente para montar a pesquisa correta

			MapQuery qMws = new MapQuery(this.getDaoMws().getSession());
		
			
			//Faço a pesquisa no banco mws tabela movimento
			qMws.append("select movimento");
			qMws.append("from Movimento movimento");
			
			//Caso não for nulo o ultimo apontamento,
			//pego o id do ultimo movimento cadastrado
			if(apont != null){
				if(apont.getMovIdt() != null){
					qMws.append("where movimento.movIdt > " + apont.getMovIdt());
				}
			}	
			qMws.append("order by movimento.movIdt");

			List<Movimento> listaMovimento = qMws.list();
			
			if(listaMovimento != null && listaMovimento.size() > 0){
				MapQuery qInjet = new MapQuery(this.getDaoInjet().getSession());
				qInjet.append("select a.cdidentific,b.id.nropexibicao,c.cdmolestendido,d.id.cdproduto,");
				qInjet.append(" a.cdinjetora, a.opatual, a.cdmoldeatual, a.cdestruturaatual ");
				qInjet.append(" from Ijtbinj as a, Ijoproteiro as b, Ijtbmol as c, Ijmolpro as d "); 
				qInjet.append(" where b.id.nrop = a.opatual ");
				qInjet.append(" and b.id.cdinjetora = a.cdinjetora ");
				qInjet.append(" and b.id.cdestrutura = a.cdestruturaatual ");
				qInjet.append(" and b.id.cdmolde = a.cdmoldeatual ");
				qInjet.append(" and c.cdmolde = a.cdmoldeatual ");
				qInjet.append(" and d.id.cdmolde = a.cdmoldeatual ");
				qInjet.append(" and d.id.cdestrutura = a.cdestruturaatual ");
				qInjet.append(" and d.dthrfval is null ");
				qInjet.append(" and a.cdidentific = :cdMaquina ");
				
				for(Movimento movimento: listaMovimento){
					
					//Realizo a pesquisa pra saber se a maquina está cadastrada
					try{
						if(movimento.getMovPes().compareTo(new BigDecimal("0")) == -1){
							continue;
						}
						qInjet.defineParametro("cdMaquina", movimento.getCentroTrabalho().getCtrNom().trim());
						qInjet.setMaxResults(1);
						Object[] resultado = (Object[]) qInjet.uniqueResult();
						
						ApontPesagens apontamento = new ApontPesagens();
						if(resultado == null){
							apontamento.setNrOp("CONTROLE");
							apontamento.setCodMaquina("CONTROLE");
							apontamento.setFerramenta("CONTROLE");
							apontamento.setItCodigo("CONTROLE");
							apontamento.setVlAferido(new BigDecimal(0));
							apontamento.setTpApont(new BigDecimal(0));
							apontamento.setDtHrPesagem(dthrAtual);
							apontamento.setDtHrProcessamento(dthrAtual); 
							apontamento.setStRegistro(new BigDecimal(3));
							apontamento.setMovIdt( new BigDecimal(movimento.getMovIdt()));
							
							try{
								this.getDaoTdba().makePersistent(apontamento);
							}catch(Exception exc){
								log.error(idLog,0, exc.getMessage() );
								exc.printStackTrace();
							}
							continue;
						}
						
						/*
						 * resultado retorna um array de tamanho 4 onde:
						 * posiçao 0 - Ijoproteiro.nropexibicao
						 * posicao 1 - Ijtbinj.cdidentific
						 * posicao 2 - Ijtbmol.cdmolestendido
						 * posicao 3 - Ijmolpro.cdproduto
						 * posicao 4 - Ijtbinj.cdinjetora
						 * posicao 5 - Ijtbinj.optual, 
						 * posicao 6 - Ijtbinj.cdmoldeatual
						 * posicao 7 - Ijtbinj.cdestruturaatual
						 */
						apontamento.setNrOp((String) resultado[1]); ///Ijoproteiro.nropexibicao
						apontamento.setCodMaquina((String) resultado[0]); //Ijtbinj.cdinjestendido
						apontamento.setFerramenta((String) resultado[2]); //Ijtbmol.cdmolestendido
						apontamento.setItCodigo((String) resultado[3]); //Ijmolpro.cdproduto
						apontamento.setVlAferido(movimento.getMovPes());
						apontamento.setTpApont(new BigDecimal(1)); // apontamento normal
						apontamento.setDtHrPesagem(movimento.getMovDta());
						apontamento.setDtHrProcessamento(dthrAtual); 
						apontamento.setStRegistro(new BigDecimal(1));
						apontamento.setMovIdt( new BigDecimal(movimento.getMovIdt()));
						
						try{
							this.getDaoTdba().makePersistent(apontamento);
							qTdba.novaConsulta();
							qTdba.append("select sb from SbOpsMp sb where sb.idRegistro in ");
							qTdba.append(" ( select max(sbOpsMp.idRegistro) from SbOpsMp sbOpsMp ");
							qTdba.append(" where sbOpsMp.tipoOperacao <> 3 ");
							qTdba.append(" and sbOpsMp.codBarras is not null ");
							qTdba.append(" and sbOpsMp.nrOp = :nrOp ");
							qTdba.append(" group by cod_mp) ");
							qTdba.append(" order by sb.idRegistro ");
							qTdba.defineParametro("nrOp", apontamento.getNrOp());


							List<SbOpsMp> lstSbOpsMp = qTdba.list();
							if(lstSbOpsMp != null && lstSbOpsMp.size() > 0){
								for(SbOpsMp sbOpsMp: lstSbOpsMp){
									try{
										ApontPesagensCbMp apontPesagensCbMp = new ApontPesagensCbMp();
										apontPesagensCbMp.setIdRegistroPai(apontamento.getIdRegistro());
										apontPesagensCbMp.setCodMp(sbOpsMp.getCodMp());
										apontPesagensCbMp.setVlAferido(movimento.getMovPes());
										apontPesagensCbMp.setCodBarras(sbOpsMp.getCodBarras());
										apontPesagensCbMp.setStRegistro(new BigDecimal(1));
										apontPesagensCbMp.setDtHrProcessamento(dthrAtual);  
										
										this.getDaoTdba().makePersistent(apontPesagensCbMp);
									}catch(Exception exx){
										log.error(idLog,0, exx.getMessage() );
										exx.printStackTrace();
									}
								}
							}
							
							
							// atualizar quantidade aferida (atualizar base Injet, tabela ijopIntAACtrl
							String sql;
							sql = "UPDATE ijopIntAACtrl ";
							sql = sql.concat(" SET vlaferido = vlaferido + :movpes ");
							sql = sql.concat(" WHERE nrop        = ':nrop' ");
							sql = sql.concat("   AND cdinjetora  = ':cdinjetora' ");
							sql = sql.concat("   AND cdmolde     = ':cdmolde' ");
							sql = sql.concat("   AND cdestrutura = ':cdestrutura'");
							
							sql = sql.replaceAll(":movpes", movimento.getMovPes().toString());
							sql = sql.replaceAll(":nrop", (String) resultado[5]);
							sql = sql.replaceAll(":cdinjetora", (String) resultado[4]);
							sql = sql.replaceAll(":cdmolde", (String) resultado[6] );
							sql = sql.replaceAll(":cdestrutura", (String) resultado[7]);							

							Query q = getDaoInjet().getSession().createSQLQuery(sql);
							q.executeUpdate();
							
							
						}catch(Exception ex){
							log.error(idLog,0, ex.getMessage() );
							ex.printStackTrace();
						}
					}catch(Exception exc){
						log.error(idLog,0, exc.getMessage() );
						exc.printStackTrace();
					}
				}
			}
			
		}catch(Exception e){
			log.error(idLog,0, e.getMessage() );
			e.printStackTrace();
		}
	}

}
