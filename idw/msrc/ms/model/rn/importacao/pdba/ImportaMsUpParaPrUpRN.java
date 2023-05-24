package ms.model.rn.importacao.pdba;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.MsUp;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.pojos.PrColetor;
import injetws.model.pojos.PrConexoesInjet;
import injetws.model.pojos.PrSubColetor;
import injetws.model.pojos.PrUp;
import injetws.model.rn.InfoRN;
import ms.excessao.ServicoFalhouException;
import ms.model.rn.UpRN;
import ms.model.rn.injet.MaquinaInjetRN;
import ms.util.UtilsThreads;

public class ImportaMsUpParaPrUpRN extends UpRN implements IImportaParaPdba {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1314546984564929745L;
	
	private transient IdwLogger log;
	private transient InfoRN infoRN;

	public ImportaMsUpParaPrUpRN(IdwLogger log, DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(log);
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		this.log = log;
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
		this.infoRN= new InfoRN(getDaoInjet(),getDaoPdba());
	}	

	@Override
	public void importar(List<PrUp> listaPrup) {
		log.iniciaAvaliacao("Importacao MsUpParaPrUp");
		log.info("Importando MsUp as " + DataHoraRN.getDataHoraAtualFormatada());
		boolean permiteImportar=true;
		
		permiteImportar=validaCodigoAtualizacao();
		
		if(permiteImportar){
			// Obter a lista completa de MsUp
			MapQuery q = new MapQuery(getDaoPdba().getSession());
			q.append("select distinct msup ");
			q.append("from MsUp msup ");
			// Alessandre: em 29-8-13 removi a clausula left dos joins abaixo pq devemos exportar apenas as que estao em MsMs
			q.append("join fetch msup.msMsicups msmsicup ");
			// Alessandre: em 14-09-17 removi o join abaixo senao apenas as ups que tem ihm terao o prsubcoletor configurados
			// e em algumas instalcoes do injet o IHM nao está definido
			//q.append("join fetch msup.msUpihms msupihm ");
			q.append("join fetch msmsicup.msMs msms");
			q.append("where msup.isLicenciada = :licenciada and msup.stAtivo = :stativo ");
			q.append("and msms.stAtivo = :stativo");
			q.append("and msmsicup.tpConexao < :tp "); // Importar somente TpConexao Tudo e Somente Ciclo
			
			q.defineParametro("stativo", BigDecimal.ONE);
			q.defineParametro("licenciada", true);
			q.defineParametro("tp", new BigDecimal(2));
			List<MsUp> listaMsUp = q.list();
			
			PrConexoesInjet prconexoesinjet = null;
			
			q.novaConsulta();
			
			q.append("from PrConexoesInjet prconexoesinjet where prconexoesinjet.prBridgeCollectorDatabase.idmasterbridgecollecdatabase = :id");
			q.setMaxResults(1);
			
			List<BigDecimal> listaIdupPrUp = new ArrayList<>();
			// Se existirem registros em Msup, interagir sobre eles
			if (listaMsUp != null && listaMsUp.size() > 0){
				for (MsUp msup : listaMsUp){
					q.defineParametro("id", msup.getCdBc());
					prconexoesinjet = (PrConexoesInjet) q.uniqueResult();
					
					// Se nao existir prconexoesinjet eh pq o BC nao eh valido, logar e continuar com proxima
					if (prconexoesinjet == null){
						log.info("A UP " + msup.getCdUp()+" DsUP:"+msup.getDsUp() + " possui o BC " + msup.getCdBc() + " invalido.");
						continue;
					}
					PrUp prup = null;
					prup = this.importarParaPrUp(msup, prconexoesinjet);
					if (prup == null)
						continue;
					
					listaIdupPrUp.add(prup.getIdup());
					UtilsThreads.pausaNaThread(5);
				}
			}else{
				log.info("Consulta por MS_UP Valido nao retornou nenhum resultado");
				
			}
			getDaoPdba().flushReiniciandoTransacao();
			// como PrUP foi alterado logo acima a transa��o precisa ser reiniciada para que n�o haja problemas com o SNAPSHOT do SQL
			
			// Passo1: Obtem todos os registros em PrUp
			List<PrUp> listaPrUp = getDaoPdba().findAll(PrUp.class);
			
			// Passo2: Interage sobre cada registro de maquina
			for (PrUp prup : listaPrUp){
				
				// Nao avaliar nenhum prup desativada
				if (prup.getStativa() == '0')
					continue;
				if(listaIdupPrUp.contains(prup.getIdup())){
					continue;
				}
				
				MsUp msupAval = null;
				// Verifica se existe em MsUp
				try {
					log.info("Verificando se prup.cdMaquina = " + prup.getCdmaquina() + " existe em msup.");
					msupAval = this.pesquisarMsUpTrazendoMsicupPorCdUpStativo(prup.getCdmaqestendido());
				} catch (RegistroDesconhecidoException e) {
					log.info("Desativando PrUp " + prup.getIdup()+" cdMaquina:"+prup.getCdmaqestendido());
					try {
						infoRN.desativaUp(log, 0, prup, true);
						log.info("PrUp " + prup.getIdup() + " desativada.");
					} catch (ServicoFalhouException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						log.info("Excessao", e1);
					}
					continue;
				}
	
				// Se msUpAval nao estiver licensiada, entao desativar a PrUp
				if (msupAval==null || msupAval.getIsLicenciada() == false){
					log.info("Desativando por nao ser licenciada a PrUp " + prup.getIdup()+" cdMaquina:"+prup.getCdmaqestendido());
					try {
						infoRN.desativaUp(log, 0, prup, true);
						log.info("PrUp " + prup.getIdup() + " desativada.");
					} catch (ServicoFalhouException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.info("Excessao", e);
					}
					continue;
				}
				
				// Verifica se a MsUp est� vinculada a um MS, senao remover o idregsubcoletor de PrUp
				if (msupAval.getMsMsicups() == null || msupAval.getMsMsicups().size() <= 0){
					log.info("Tornando NULL PrSubColetor da prup " + prup.getIdup()+" cdMaquina:"+prup.getCdmaqestendido());
					prup.setPrSubColetor(null);
					getDaoPdba().makePersistent(prup);
				}
			}
		}
		log.paraAvaliacao();
		log.info("Fim da Importacao MsUp as " + DataHoraRN.getDataHoraAtualFormatada() + " - " + log.getAvaliacaoCompleta());
	}

	
	
	private PrUp importarParaPrUp(MsUp msup, PrConexoesInjet prconexoesinjet){
		// Pesquisar ijtbinj
		MaquinaInjetRN rnInjet = new MaquinaInjetRN(getDaoInjet());	

		// Procura se existe o MsUp
		UpRN rn = new UpRN(getDaoPdba(),getDaoInjet());

		Ijtbinj ijtbinj = rnInjet.pesquisarIjtbinjByCdInjestendido(msup.getCdUp());
		
		if (ijtbinj == null)
			return null;
		
		PrUp prup = null;
		try {
			prup = rn.pesquisarPrUpPorCdMaquina(ijtbinj.getCdinjetora());
		} catch (RegistroDesconhecidoException e){
			prup = new PrUp();
			prup.setIdup(null);
			prup.setCdmaquina(ijtbinj.getCdinjetora());
			prup.setCdmaqestendido(msup.getDsUp());
			prup.setStativa('1');
		}
		
		PrSubColetor prSubColetor = importarPrSubColetor(msup, prconexoesinjet);
		
		if (prSubColetor == null){			
			log.info("PrSubColetor nao identificado. Passando para o proximo");
			return null;
		}
		

		// As linhas abaixo foram comentadas porque nao � mais necess�rio retornar a alteracao para o TM, pois
		// as mesmas foram removidas do TM
		//
		// Atualizar a base do TM com a informa��o do coletor. A transacao sera aberta e fechada
		//
		//if (prSubColetor != null && prSubColetor.getPrColetor() != null)
		//	rnInjet.atualizarIjtbcoletores(msup.getCdUp(), prSubColetor.getPrColetor().getIdcoletor());
		
		 
		// Altera valores de PrUp
		// Update no banco apenas se houver mudan�a no registro
		boolean isAlterar = false;
		
		if (prup.getCdmaqestendido() == null || prup.getCdmaqestendido().equals(msup.getDsUp()) == false) {			
			prup.setCdmaqestendido(msup.getDsUp());
			log.info(prup.getIdup()+": Alterado Cdmaqestendido para :"+prup.getCdmaqestendido());
			isAlterar = true;
		}
		if (prup.getPrConexoesInjet() == null || prup.getPrConexoesInjet().getIdregconexaoinjet().equals(prconexoesinjet.getIdregconexaoinjet()) == false ){
			prup.setPrConexoesInjet(prconexoesinjet);
			log.info(prup.getIdup()+": Alterado Idregconexaoinjet");
			isAlterar = true;
		}
		
		if (prup.getPrSubColetor() == null || prup.getPrSubColetor().getIdregsubcoletor().equals(prSubColetor.getIdregsubcoletor()) == false){
			prup.setPrSubColetor(prSubColetor);
			log.info(prup.getIdup()+": Alterado idRegSubcoletor para :"+prup.getPrSubColetor().getIdregsubcoletor());
			isAlterar = true;
		}

		Double tempDouble = 0d;
		try {
			tempDouble = rnInjet.getIjTbInjConfigValor(prup.getCdmaquina(), MaquinaInjetRN._CFG_DBC);
		} catch (NullPointerException e){
			log.info(prup.getIdup()+": N�o foi possivel obter cfgDbc");
		}
		if (prup.getCfgdbc() == null || tempDouble == null || prup.getCfgdbc().equals(tempDouble) == false) {			
			prup.setCfgdbc(tempDouble);			
			log.info(prup.getIdup()+": Alterado cfgDbc ");
			isAlterar = true;
		}
		
		Character tempCharacter = null;
		try {
			tempCharacter = rnInjet.pesquisarIjTbInjConfig(prup.getCdmaquina(), MaquinaInjetRN._CFG_INTERRUPCAO_CICLO).getValor().charAt(0);
		} catch (NullPointerException e){
			tempCharacter = null;
		}
		if (prup.getCfginterrupcaociclo() == null || tempCharacter == null || prup.getCfginterrupcaociclo().equals(tempCharacter) == false){
			prup.setCfginterrupcaociclo(tempCharacter);
			log.info(prup.getIdup()+": Alterado cfgInterrupcaoCiclo");
			isAlterar = true;
		}
		
		tempDouble = null;
		try {
			tempDouble = rnInjet.getIjTbInjConfigValor(prup.getCdmaquina(), MaquinaInjetRN._CFG_PERC_TMP_CICLO_INICIALIZACAO);
		} catch (NullPointerException e){
			tempDouble = null;
		}
		if (prup.getCfgperctmpcicloinicializacao() == null || tempDouble == null || prup.getCfgperctmpcicloinicializacao().equals(tempDouble) == false){
			prup.setCfgperctmpcicloinicializacao(tempDouble);
			log.info(prup.getIdup()+": Alterado cfgperctmpcicloinicializacao");
			isAlterar = true;
		}
		
		tempDouble = null;
		try {
			tempDouble = rnInjet.getIjTbInjConfigValor(prup.getCdmaquina(), MaquinaInjetRN._CFG_PERC_TMP_CICLO_PAR_AUTO);
		} catch (NullPointerException e){
			tempDouble = null;
		}
		if (prup.getCfgperctmpcicloparauto() == null || tempDouble == null || prup.getCfgperctmpcicloparauto().equals(tempDouble) == false){
			prup.setCfgperctmpcicloparauto(tempDouble);
			log.info(prup.getIdup()+": Alterado cfgperctmpcicloparauto");
			isAlterar = true;
		}
		
		tempDouble = null;
		try {
			tempDouble = rnInjet.getIjTbInjConfigValor(prup.getCdmaquina(), MaquinaInjetRN._CFG_PERC_TOLERANCIA_SINAL_CICLO);
		} catch (NullPointerException e){
			tempDouble = null;
		}
		if (prup.getCfgperctoleranciasinalciclo() == null || tempDouble == null || prup.getCfgperctoleranciasinalciclo().equals(tempDouble) == false){
			prup.setCfgperctoleranciasinalciclo(tempDouble);
			log.info(prup.getIdup()+": Alterado Cfgperctoleranciasinalciclo");
			isAlterar = true;
		}
		
		tempDouble = null;
		try {
			tempDouble = rnInjet.getIjTbInjConfigValor(prup.getCdmaquina(), MaquinaInjetRN._CFG_TAMANHO_UM_PACOTE_CICLOS);
		} catch (NullPointerException e){
			tempDouble = null;
		}
		if (prup.getCfgtamanhoumpacoteciclos() == null || tempDouble == null || prup.getCfgtamanhoumpacoteciclos().equals(tempDouble) == false){
			prup.setCfgtamanhoumpacoteciclos(tempDouble);
			log.info(prup.getIdup()+": Alterado Cfgtamanhoumpacoteciclos");
			isAlterar = true;
		}
		
		String tempValor = null;
		try {
			tempValor = rnInjet.pesquisarIjTbInjConfig(prup.getCdmaquina(), MaquinaInjetRN._CFG_TP_SESSAO_PRODUCAO).getValor();
		} catch (NullPointerException e){
			e.printStackTrace();
			tempValor = null;
		}
		if (prup.getCfgtpsessaoproducao() == null || tempValor == null || prup.getCfgtpsessaoproducao().equals(tempValor) == false){
			log.info(prup.getIdup()+": Alterado Cfgtpsessaoproducao = " + prup.getCfgtpsessaoproducao() + " tempValor = " + tempValor);
			prup.setCfgtpsessaoproducao(tempValor);
			log.info(prup.getIdup()+": Alterado Cfgtpsessaoproducao");
			isAlterar = true;
		}
		
		Long tempLong = null;
		try {
			tempLong = rnInjet.getIjTbInjConfigValor(prup.getCdmaquina(), MaquinaInjetRN._CFG_TOLERTMPCICLOPARAAUTO).longValue();
		} catch (NullPointerException e){
			tempLong = null;
		}
		if (prup.getCfgtolertmpcicloparauto() == null || tempLong == null || prup.getCfgtolertmpcicloparauto().equals(tempLong) == false){
			prup.setCfgtolertmpcicloparauto(tempLong);
			log.info(prup.getIdup()+": Alterado setCfgtolertmpcicloparauto");
			isAlterar = true;
		}

		// Alessandre> em 3-10-13 removi do if abaixo o teste para entrar somente se tpup <> 1. Tem q entrar qdo for 1 tb.
		if (prup.getTpup() == null){
			prup.setTpup(new BigDecimal(1));
			log.info(prup.getIdup() + ": Alterado TpUP");
			isAlterar = true;
		}
		
		if (prup.getTpup().intValue() == 1 && msup.getTpUp() != null && msup.getTpUp().equals(1) ){
			// coleta discreta
			prup.setTpup(new BigDecimal(2));
			log.info(prup.getIdup() + ": Alterado TpUP");
			isAlterar = true;
		} else if (prup.getTpup().intValue() == 2 && msup.getTpUp() != null && msup.getTpUp().equals(0)) {
			// coleta automatica
			prup.setTpup(new BigDecimal(1));
			log.info(prup.getIdup() + ": Alterado TpUP");
			isAlterar = true;
		}
//		TIPO_COLETA_AUTOMATICA = 1  (sempre essa)
//	    TIPO_COLETA_MANUAL_PRODUCAO = 2
//	    TIPO_COLETA_MANUAL_ACABAMENTO = 3
	    
		// Persiste
		if (isAlterar == true) {
			log.info("salvando prup com: " + prup.toString());
			prup = getDaoPdba().makePersistent(prup);
			log.info("makepersiste em PrUP do up = " + prup.getIdup());
		} 	
		// Atualiza MsUp.iduppdba com o valor de prup.idup
		if (msup.getIduppdba() == null || msup.getIduppdba().equals(prup.getIdup().toString()) == false){
			atualizaIdUpPDBA(msup.getIdUp(), prup.getIdup().toString());
			log.info("salvando iduppdba = " + prup.getIdup() + " para msup = " + msup.getCdUp() + " e idup = " + msup.getIdUp());
		}		
		if (prup.getStativa() != '1') {
			infoRN.ativaUp(prup, false);
			log.info("ATIVANDO up = " + prup.getIdup());
		} 
		return prup;
	}

	private void atualizaIdUpPDBA(BigDecimal idUp, String idUpPdba){
		MapQuery q = new MapQuery(getDaoPdba().getSession());
		
		q.append("update MsUp set iduppdba = :iduppdba where idUp = :idup ");
		
		q.defineParametro("iduppdba", idUpPdba);
		q.defineParametro("idup", idUp);
		
		q.query().executeUpdate();
		
	}
	private PrSubColetor importarPrSubColetor(MsUp msup, PrConexoesInjet prconexoesinjet){
		PrColetor prcoletor = null;
		MsMsicup msicup = null;
		for (MsMsicup t : msup.getMsMsicups()){
			// Se o MS estiver desativado entao descartar e continbuar procurando
			if (t.getMsMs().getStAtivo().equals(BigDecimal.ONE)){
				msicup = t;
				break;
			}
		}

		// Se nao encontrou um msicup eh pq nao existe informacao definida para se criar um PrSubColetor
		if (msicup == null || msicup.getUrlConexao() == null) {
			log.info(0, 15, "Nao foi encontrada nenhum msicup para a msUp " + msup.getCdUp() +"-"+msup.getDsUp());
			return null;
		}
		
		// Se nao for possivel transformar a url de conexao em um numero tambem sai do metodo
		try {
			new BigDecimal(msicup.getUrlConexao());
		} catch (NumberFormatException e){
			log.info(0, 15, "Nao foi possivel converter a urlConexao [" + msicup.getUrlConexao() + "] da msUp " + msup.getCdUp()+"-"+msup.getDsUp());
			return null;
		}
		
		boolean isAlterar = false;
		try {
			prcoletor = infoRN.getPrColetorByIdColetor(msicup.getMsIc().getUrlConexao());
			// Anteriormente prcoletor estava sendo identificado atraves da urlconexao do IHM, entretanto, isso era feito pois o IHM reconhecia quais UPs eram
			// suas usava a relacao pr_coletor -> pr_sub_coletor -> pr_up. Mas, quando a infra-estrutura possui varios adams 6050 com varias UPs sendo gerenciados pelo mesmo IHM
			// A solucao foi modificar o ihm para que ele pegue as UPs gerenciadas via tabela ms_upihm ao inves da pr_coletor.
		} catch (RegistroDesconhecidoException e){	
			prcoletor = new PrColetor();
			prcoletor.setIdregcoletor(null);
			prcoletor.setPrConexoesInjet(prconexoesinjet);
			prcoletor.setIdcoletor(msicup.getMsIc().getUrlConexao());
			prcoletor.setStmonitoraespera(null);
			isAlterar = true;			
		}
		
		// TODO: SENOJ adicionar no cadastro do MS o atributo monitora ciclo em espera
		// prcoletor.setStmonitoraespera(null); 		
		
		// Verificar se IdRegConexao mudou, se sim alterar o valor		
		if (prcoletor.getPrConexoesInjet() == null || prcoletor.getPrConexoesInjet().getIdregconexaoinjet().equals(prconexoesinjet.getIdregconexaoinjet()) == false ){
			prcoletor.setPrConexoesInjet(prconexoesinjet);
			log.info(0, 15, prcoletor.getIdcoletor()+": Alterado Idregconexaoinjet "+ prconexoesinjet.getIdregconexaoinjet() + " para BC:"+ prconexoesinjet.getPrBridgeCollectorDatabase().getIdmasterbridgecollecdatabase() );
			isAlterar = true;
		}

		if (isAlterar == true) {
			prcoletor = getDaoPdba().makePersistent(prcoletor);
			log.info(0, 15, "makePersist em prcoletor foi necessario"+" DsUP:"+msup.getDsUp() );
		} else {
			log.info(0, 15, "NAO foi necessario makePersist em prcoletor"+" DsUP:"+msup.getDsUp() );
		}
		
		getDaoPdba().flushReiniciandoTransacao();
		// TODO: � necess�rio ver uma solu��o para os ids co triggers que conflitam com com os ids dos pojos no SQLserver
		PrSubColetor retorno = null;

		isAlterar = false;
		try {
			retorno = infoRN.getPrSubColetorByIdRegColetorEIdColetor(prcoletor.getIdregcoletor(), msicup.getUrlConexao());
			log.info(0, 15, "Encontrado prSubColetor com o id " + retorno.getIdregsubcoletor()+" MsUP:"+msup.getDsUp());
		} catch (RegistroDesconhecidoException e){
			log.info(0, 15, "Ser� inclu�do novo prSubColetor para o prcoletor " + prcoletor.getIdregcoletor()+" MsUP:"+msup.getDsUp());
			isAlterar = true;
			retorno = new PrSubColetor();
			retorno.setIdregsubcoletor(null);
			retorno.setPrColetor(prcoletor);
		}
		
		if (retorno.getIdsubcoletor() == null || retorno.getIdsubcoletor().equals(new BigDecimal(msicup.getUrlConexao())) == false ){
			isAlterar = true;
			retorno.setIdsubcoletor(new BigDecimal(msicup.getUrlConexao()));
		}
		
		if (retorno.getPrColetor().getIdcoletor().equals(prcoletor.getIdcoletor()) == false){
			isAlterar = true;
			retorno.setPrColetor(prcoletor);
		}
		
		if (isAlterar == true){
			retorno=getDaoPdba().makePersistent(retorno);
			log.info(0, 15, "makePersistent em Prsubcoletor"+" MsUP:"+msup.getDsUp());
		} else {
			log.info(0, 15, "NAO foi necessario o makePersistent em Prsubcoletor"+" MsUP:"+msup.getDsUp());
		}
		getDaoPdba().flushReiniciandoTransacao();
		// TODO: � necess�rio ver uma solu��o para os ids co triggers que conflitam com com os ids dos pojos no SQLserver
		return retorno;
	}
	
	private boolean validaCodigoAtualizacao(){
		boolean retorno=true;
		/*
		 * MapQuery q = new MapQuery(getDao().getSession());
			q.append("select distinct msup ");
		 * 
		 * 
		 */
		return retorno;
	}
}
