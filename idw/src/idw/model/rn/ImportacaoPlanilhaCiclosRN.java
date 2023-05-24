package idw.model.rn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwFolhaiac;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.FolhaDTO;
import idw.webservices.dto.FolhasDTO;
import idw.webservices.dto.UsuarioDTO;

public class ImportacaoPlanilhaCiclosRN implements IDao {
	private transient DAOGenerico dao; //para MapQuery
	
	public ImportacaoPlanilhaCiclosRN() {
		this.dao = new DAOGenerico();
	}
	public ImportacaoPlanilhaCiclosRN(DAOGenerico dao) {
		this.dao = dao;
	}

	public FolhasDTO importarPlanilha(FolhasDTO folhas, UsuarioDTO usrlogadodto){
		FolhasDTO retorno = new FolhasDTO();

		IdwLogger log = new IdwLogger("importacaoPlanilhaCiclos");
		int idLog = log.getIdAleatorio();

		log.iniciaAvaliacao(idLog, "importarPlanilhaCiclos");
		log.info(idLog, 0, "Iniciando importacaoCiclos");

		MapQuery qPt = new MapQuery(dao.getSession());
		// Pesquisa o tipo de posto 13 (SMD)
		OmTppt omtppt = null;
		qPt.append("from OmTppt omtppt");
		qPt.append("where omtppt.idTppt = 13");
		omtppt = (OmTppt) qPt.uniqueResult();

		qPt.novaConsulta();
		qPt.append("from OmPt ompt");
		qPt.append("where ompt.dsCurta = :dscurta");
		qPt.append("and ompt.stAtivo = 1");

		MapQuery qFolha = new MapQuery(dao.getSession());
		qFolha.append("from DwFolha dwfolha");
		qFolha.append("left join fetch dwfolha.dwFolhacics dwfolhacic");
		qFolha.append("where dwfolha.cdFolha = :cdfolha");
		qFolha.append("and dwfolha.stAtivo = 1");

		MapQuery qGt = new MapQuery(dao.getSession());
		qGt.append("from OmGt omgt");
		qGt.append("where omgt.depara = :depara");
		qGt.append("and omgt.stAtivo = 1");

		MapQuery qOmpt = new MapQuery(dao.getSession());
		qOmpt.append("from OmPt ompt");
		qOmpt.append("where ompt.omGt = :omGt");
		qOmpt.append("and ompt.stAtivo = 1");

		// Pesquisa o usuario logado
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.setDaoSession(dao.getSession());
		OmUsr omusr = usuarioRN.getUsuarioByCdEStAtivo(usrlogadodto.getUsuario().getCdUsr());

		OmCfg omcfg = Util.getConfigGeral(dao.getSession());

		MapQuery qProduto = new MapQuery(dao.getSession());
		qProduto.append("from OmProduto omproduto");
		qProduto.append("where omproduto.cdProduto = :cdproduto and omproduto.stAtivo = 1");

		List<String> produtosNaoCadastrados = new ArrayList<String>();

		// Verrer todas as folhas enviadas
		for (FolhaDTO folhadto : folhas.getFolhas()){
			log.info(idLog, 5, "Importando folha " + folhadto.getFolha().getCdFolha() + " para maquina " + folhadto.getFolha().getDsFolha() + " com ciclo " + folhadto.getFolha().getSegCiclopadrao());			
			// Localiza o produto refernte a folha
			OmProduto omproduto = null;
			qProduto.defineParametro("cdproduto", folhadto.getFolha().getCdFolha());
			qProduto.setMaxResults(1);
			omproduto = (OmProduto) qProduto.uniqueResult();

			if (omproduto == null){
				if (produtosNaoCadastrados.contains(folhadto.getFolha().getCdFolha()) == false) {	
					retorno.setMensagem(retorno.getMensagem() + "Produto " + folhadto.getFolha().getCdFolha() + " desconhecido, assumindo produto da configuracao. " + omcfg.getOmProduto().getCdProduto() + "\n");
					produtosNaoCadastrados.add(folhadto.getFolha().getCdFolha());
				}
				log.info(idLog, 5, "Produto " + folhadto.getFolha().getCdFolha() + " desconhecido, assumindo produto da configuracao. " + omcfg.getOmProduto().getCdProduto());
				omproduto = omcfg.getOmProduto();
			}

			// 1. Verifica se a folha existe
			// 1.1 Localiza a lista de OmPt validos para aceita a folha
			qPt.defineParametro("dscurta", folhadto.getFolha().getDsFolha());
			List<OmPt> listaOmpt = qPt.list();
			
			// 1.2 Se n�o existe OmPt, gerar log e verificar se existem Gts para o depara
			if (listaOmpt != null & listaOmpt.size() > 0){
				avaliandoPt(log, idLog, listaOmpt, folhadto, qFolha, omusr, omcfg, omproduto);
			} else {
				
				retorno.setMensagem(retorno.getMensagem() + "N�o existem PTs para o " + folhadto.getFolha().getDsFolha() +". Produto " + folhadto.getFolha().getCdFolha() +  "\n");				
				log.info(idLog, 10, "N�o existem PTs para o ds_curta " + folhadto.getFolha().getDsFolha());
				qGt.defineParametro("depara", folhadto.getFolha().getDsFolha());
				List<OmGt> listaOmgt = qGt.list();

				if (listaOmgt != null && listaOmgt.size() > 0){
					for(OmGt omgt : listaOmgt){
						List<OmPt> omptLista=null;
						// Verifica se existe OmPt para determinado omgt
						qOmpt.defineParametro("omGt",omgt); 
						omptLista = qOmpt.list();

						if(omptLista != null && omptLista.size() > 0){
							for(OmPt ompt : omptLista){
								avaliandoGt(log, idLog, listaOmgt, folhadto, qFolha, omusr, omtppt, omcfg, omproduto, ompt);
							}
						}else{
							avaliandoGt(log, idLog, listaOmgt, folhadto, qFolha, omusr, omtppt, omcfg, omproduto, null);
						}
					}					
				} else {
					retorno.setMensagem(retorno.getMensagem() + "N�o existem GTs para o " + folhadto.getFolha().getDsFolha() +". Produto " + folhadto.getFolha().getCdFolha() + "\n");
					log.info(idLog, 10, "N�o existem GTs para o depara " + folhadto.getFolha().getDsFolha());
				}
			}
		}

		log.paraAvaliacao(dao);
		log.info(idLog, 0, log.getAvaliacaoCompleta());
		return retorno;
	}
	
	private void avaliandoGt(IdwLogger log, int idLog, List<OmGt> listaOmgt, FolhaDTO folhadto, MapQuery qFolha, OmUsr omusr, OmTppt omtppt, OmCfg omcfg, OmProduto omproduto, OmPt ompt){
		
		for (OmGt omgt : listaOmgt){
			//1.3.1 Define qual deve ser o codigo da folha. Nome do programa + cd pt
			String cdFolha = folhadto.getFolha().getCdFolha() + "-" + omgt.getOmTpgt().getCdTpgt();
			qFolha.defineParametro("cdfolha", cdFolha);
			DwFolha dwfolha = (DwFolha) qFolha.uniqueResult();
			
			//1.3.2. Se n�o existir, incluir
			if (dwfolha == null) {
				log.info(idLog, 10, "FOLHA DESCONHECIDA " + folhadto.getFolha().getCdFolha() + ". Inserindo.");
				dwfolha = new DwFolha();
				dwfolha.setCdFolha(cdFolha);
				dwfolha.setDsFolha("Folha importada planilha ciclos");
				dwfolha.setDtRevisao(DataHoraRN.getDataHoraAtual());
				dwfolha.setDtStativo(DataHoraRN.getDataHoraAtual());
				dwfolha.setIdFolha(null);
				dwfolha.setOmTppt(omtppt);
				dwfolha.setOmUsrByIdUsrrevisao(omusr);
				dwfolha.setOmUsrByIdUsrstativo(omusr);
				dwfolha.setOmGt(omcfg.getOmGtimpcic());
				dwfolha.setRevisao(1l);
				dwfolha.setStAtivo((byte)1);
				dwfolha.setTpFolha((byte)6); // programa iac
				dwfolha.setSegSetup(1800);
			} else {
				log.info(idLog, 10, "Encontrou folha " + dwfolha.getIdFolha() + "/" + folhadto.getFolha().getCdFolha() + ". Alterando gt e ciclo padrao.");
				dwfolha.setSegCiclopadrao(folhadto.getFolha().getSegCiclopadrao());
				dwfolha.setOmGt(omcfg.getOmGtimpcic());
			}
			//1.3.3. Se existir ou apos incluir, atualiza o ciclo padrao
			// se existir mais de um pt, verificar se ele esta no set<dwfolhacic> da folha
			boolean isExiste = false;
			for (DwFolhacic dwfolhacic : dwfolha.getDwFolhacics()){
				if (dwfolhacic.getOmGt().getIdGt().equals(omgt.getIdGt()) && dwfolhacic.getOmPt().getIdPt().equals(ompt.getIdPt())){
					isExiste = true;
					dwfolhacic.setSegCiclopadrao(folhadto.getFolha().getSegCiclopadrao());
				}
			}
			if (isExiste == false){
				log.info(idLog, 10, "Inserindo ciclo para folha " + folhadto.getFolha().getCdFolha() + " no Gt " + omgt.getCdGt());
				
				DwFolhacic dwfolhacic = new DwFolhacic();
				dwfolhacic.setDwFolha(dwfolha);
				dwfolhacic.setIdFolhacic(null);
				dwfolhacic.setSegCiclopadrao(folhadto.getFolha().getSegCiclopadrao());
				dwfolhacic.setOmGt(omgt);
				
				//Verifica se existe OmPt e seta na dwfolhacic
				if(ompt != null){
					dwfolhacic.setOmPt(ompt);
					dwfolha.getDwFolhacics().add(dwfolhacic);
				}else{
					dwfolhacic.setOmPt(null);
					dwfolha.getDwFolhacics().add(dwfolhacic);
				}
			}
	
			//1.3.4. Avaliar quais ser�o os produtos para a folha e qual ser� o programa
			isExiste = false;
			for (DwFolhaiac dwfolhaiac : dwfolha.getDwFolhaiacs()){
				if (dwfolhaiac.getOmProduto() != null && dwfolhaiac.getOmProduto().getCdProduto().equals(omproduto.getCdProduto()))
					isExiste = true;
				
				if (dwfolhaiac.getOmProdutodois() != null && dwfolhaiac.getOmProdutodois().getCdProduto().equals(omproduto.getCdProduto()))
					isExiste = true;
			}
			if (isExiste == false){
				log.info(idLog, 10, "Incluindo produto " + omproduto.getCdProduto() + " para a folha " + dwfolha.getCdFolha());
				HashSet<DwFolhaiac> listaFolhaiacs = new HashSet<DwFolhaiac>(); 
			    listaFolhaiacs.addAll(dwfolha.getDwFolhaiacs());
				
			    
				removerDwFolhaiacAnteriores(listaFolhaiacs);
				
				dwfolha.setDwFolhaiacs(new HashSet<DwFolhaiac>());
				
				DwFolhaiac dwfolhaiac = new DwFolhaiac();
				dwfolhaiac.setDwFolha(dwfolha);
				dwfolhaiac.setIdFolhaiac(null);
				dwfolhaiac.setOmProduto(omproduto);
				dwfolhaiac.setOmProdutodois(null);
//				dwfolhaiac.setQtAtiva(BigDecimal.ONE);
				
				Iterator<DwFolhaiac> folhaiac = folhadto.getFolha().getDwFolhaiacs().iterator();
				while(folhaiac.hasNext()){
					DwFolhaiac dw = folhaiac.next();
					dwfolhaiac.setQtAtiva(dw.getQtAtiva()); //setando valor do blank (Producao por Ciclo)
				}
					
				dwfolha.getDwFolhaiacs().add(dwfolhaiac);
			}
			dao.makePersistent(dwfolha);
		}
		
	}
	
	private void removerDwFolhaiacAnteriores(HashSet<DwFolhaiac> listaFolhaiacs){
		for (DwFolhaiac dwfolhaiac : listaFolhaiacs){
			 DwFolhaiac folhaiac =	 dao.findById(DwFolhaiac.class, dwfolhaiac.getIdFolhaiac(), false);
			 if (folhaiac != null){
				 dao.makeTransient(folhaiac);
			 }
			 
		}
		
		
	}

	private void avaliandoPt(IdwLogger log, int idLog, List<OmPt> listaOmpt, FolhaDTO folhadto, MapQuery qFolha, OmUsr omusr, OmCfg omcfg, OmProduto omproduto){
		for (OmPt ompt : listaOmpt){
			//1.3.1 Define qual deve ser o codigo da folha. Nome do programa + cd pt
			String cdFolha = folhadto.getFolha().getCdFolha() + "-" + ompt.getOmTppt().getCdTppt();
			qFolha.defineParametro("cdfolha", cdFolha);
			DwFolha dwfolha = (DwFolha) qFolha.uniqueResult();
			
			//1.3.2. Se n�o existir, incluir
			if (dwfolha == null) {
				log.info(idLog, 10, "FOLHA DESCONHECIDA " + folhadto.getFolha().getCdFolha() + ". Inserindo.");

				dwfolha = new DwFolha();
				dwfolha.setCdFolha(cdFolha);
				dwfolha.setDsFolha("Folha importada planilha ciclos");
				dwfolha.setDtRevisao(DataHoraRN.getDataHoraAtual());
				dwfolha.setDtStativo(DataHoraRN.getDataHoraAtual());
				dwfolha.setIdFolha(null);
				dwfolha.setOmTppt(ompt.getOmTppt());
				dwfolha.setOmUsrByIdUsrrevisao(omusr);
				dwfolha.setOmUsrByIdUsrstativo(omusr);
				dwfolha.setOmGt(omcfg.getOmGtimpcic());
				dwfolha.setRevisao(1l);
				dwfolha.setStAtivo((byte)1);
				dwfolha.setTpFolha((byte)6); // programa iac
				dwfolha.setSegSetup(1800);
			} else {
				log.info(idLog, 10, "Encontrou folha " + folhadto.getFolha().getCdFolha() + ". Alterando gt e ciclo padrao.");
				dwfolha.setOmGt(omcfg.getOmGtimpcic());
				dwfolha.setSegCiclopadrao(folhadto.getFolha().getSegCiclopadrao());
			}
			//1.3.3. Se existir ou apos incluir, atualiza o ciclo padrao
			boolean isExiste = false;
			for (DwFolhacic dwfolhacic : dwfolha.getDwFolhacics()){
				if (dwfolhacic.getOmPt().getIdPt().equals(ompt.getIdPt())){
					isExiste = true;
					dwfolhacic.setSegCiclopadrao(folhadto.getFolha().getSegCiclopadrao());
				}
			}
			if (isExiste == false){
				log.info(idLog, 10, "Inserindo ciclo para folha " + folhadto.getFolha().getCdFolha() + " no Pt " + ompt.getCdPt());
				DwFolhacic dwfolhacic = new DwFolhacic();
				dwfolhacic.setDwFolha(dwfolha);
				dwfolhacic.setIdFolhacic(null);
				dwfolhacic.setSegCiclopadrao(folhadto.getFolha().getSegCiclopadrao());
				dwfolhacic.setOmPt(ompt);
				
				dwfolha.getDwFolhacics().add(dwfolhacic);
			}
			//1.3.4. Avaliar quais ser�o os produtos para a folha e qual ser� o programa
			isExiste = false;
			for (DwFolhaiac dwfolhaiac : dwfolha.getDwFolhaiacs()){
				if (dwfolhaiac.getOmProduto() != null && dwfolhaiac.getOmProduto().getCdProduto().equals(omproduto.getCdProduto()))
					isExiste = true;
				
				if (dwfolhaiac.getOmProdutodois() != null && dwfolhaiac.getOmProdutodois().getCdProduto().equals(omproduto.getCdProduto()))
					isExiste = true;
			}
			if (isExiste == false){
				log.info(idLog, 10, "Incluindo produto " + omproduto.getCdProduto() + " para a folha " + dwfolha.getCdFolha());
				
				HashSet<DwFolhaiac> listaFolhaiacs = new HashSet<DwFolhaiac>(); 
			    listaFolhaiacs.addAll(dwfolha.getDwFolhaiacs());
					   
				removerDwFolhaiacAnteriores(listaFolhaiacs);
				
				dwfolha.setDwFolhaiacs(new HashSet<DwFolhaiac>());
				DwFolhaiac dwfolhaiac = new DwFolhaiac();
				dwfolhaiac.setDwFolha(dwfolha);
				dwfolhaiac.setIdFolhaiac(null);
				//TODO incluir codigo para remover os produtos
								
				dwfolhaiac.setOmProduto(omproduto);
				dwfolhaiac.setOmProdutodois(null);
//				dwfolhaiac.setQtAtiva(BigDecimal.ONE);
				
				Iterator<DwFolhaiac> folhaiac = folhadto.getFolha().getDwFolhaiacs().iterator();
				while(folhaiac.hasNext()){
					DwFolhaiac dw = folhaiac.next();
					dwfolhaiac.setQtAtiva(dw.getQtAtiva()); //setando valor do blank (Producao por Ciclo)
				}
				
				dwfolha.getDwFolhaiacs().add(dwfolhaiac);
			}
			dao.makePersistent(dwfolha);
		}

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
}