package ms.model.rn.importacao.pdba;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.MsUp;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.pojos.PrUp;
import ms.model.dao.AbstractPdbaInjetDAO;
import ms.model.rn.UpRN;
import ms.model.rn.injet.MaquinaInjetRN;
import ms.util.UtilsThreads;

public class ImportaIjtbinjParaMsUpRN extends AbstractPdbaInjetDAO  implements IImportaParaPdba {

	private IdwLogger log;
	
	public ImportaIjtbinjParaMsUpRN(IdwLogger log, DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		Validate.notNull(log);
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.log = log;		
		this.setDaoInjet(daoInjet);
		this.setDaoPdba(daoPdba);
	}
	
	@Override
	public void importar(List<PrUp> listaPrup) {
		log.iniciaAvaliacao("Importacao IjtbinjParaMsUp");
		log.info(0, 10, "Importando Ijtbinj as " + DataHoraRN.getDataHoraAtualFormatada());
		// Obter a lista completa de Ijtbinj
		MapQuery q = new MapQuery(getDaoInjet().getSession());
		q.append("select ijtbinj ");
		q.append("from Ijtbinj ijtbinj ");
		q.append("join ijtbinj.ijtbinjtpcoletors ijtbinjtpcoletor ");
		q.append("where ijtbinj.cdinjetora <> '999999'");
		q.append("and ijtbinjtpcoletor.idtpcoletor = 1");
		
		List<Ijtbinj> listaIjtb = q.list();

		if (listaIjtb != null)
			log.info("Encontrados " + listaIjtb.size() + " em ijtbinj.");
		List<Object> listaIdMsUP =new ArrayList<Object>();
		List<Object> updsDesativadasNoInjet =new ArrayList<Object>();
		MaquinaInjetRN maquinaInjetRN = new MaquinaInjetRN(getDaoInjet());
		// Se existirem registros em Ijtbinj, interagir sobre eles
		if (listaIjtb != null && listaIjtb.size() > 0){
			for (Ijtbinj ijtb : listaIjtb){
				try{
					if(ijtb.getStinjetora().intValue()==1){ // 1 � desativada, L�gica invertida do Injet
						updsDesativadasNoInjet.add(ijtb.getCdinjestendido());
						log.info("Maquina "+ ijtb.getCdinjestendido()+" DESATIVADA.");
						continue;
					}
					// Importa apenas se a maquina estiver licenciada
					if (maquinaInjetRN.isIjtbinjLicenciada(ijtb) == true) {
						listaIdMsUP.add(this.importarParaMsUp(ijtb).getCdUp());
						UtilsThreads.pausaNaThread(5);
						log.info("Maquina "+ ijtb.getCdinjestendido()+" Importada com licença.");
					} else
						log.info("Maquina "+ ijtb.getCdinjestendido()+" NAO LICENCIADA.");
				}catch(Exception e){
					log.info("Maquina "+ ijtb.getCdinjestendido()+" Erro na Importacao.");
					log.info("Excessao", e);
					// Se ocorreu um erro colocar a maquina na lista abaixo para evitar que ela seja desativada
					listaIdMsUP.add(ijtb.getCdinjestendido());
				}
			}
		}
		
		// como MSUP foi alterado logo acima a transa��o precisa ser reiniciada para que n�o haja problemas com o SNAPSHOT do SQL
		if(updsDesativadasNoInjet.size()>0){	
			try{
				q = new MapQuery(getDaoPdba().getSession());
				q.append("update MsUp msup set msup.isLicenciada=:islicenciada where msup.cdUp in (:lista) and msup.isLicenciada <> :islicenciada");
				for (Object maquina : updsDesativadasNoInjet) {
					log.info("....removendo licenca de " + maquina.toString());
				}
				
				q.defineListaParametro("lista",updsDesativadasNoInjet);
				q.defineParametro("islicenciada", false);
				int qtAlterou = q.query().executeUpdate();
				log.info("isLicenciada=0 alterou registros em msup=" + qtAlterou);
			}catch(Exception e){
				log.info("***ERRO ao Desativar Ups");
				e.printStackTrace();
			}
		}	
		
		log.info("Desativando registros obsoletos as " + DataHoraRN.getDataHoraAtual());
		
		q = new MapQuery(getDaoPdba().getSession());
		if(listaIdMsUP.size()>0){				
			q.append("update MsUp msup set msup.isLicenciada='0' where msup.stAtivo = 1 and msup.cdUp not in (:lista) and msup.isLicenciada <> '0' ");
			for (Object item: listaIdMsUP) {
				log.info(".....NAO desativando2 " + item.toString());
			}
			
			q.defineListaParametro("lista",listaIdMsUP);
		}else{
			q.append("update MsUp msup set msup.isLicenciada='0' where msup.stAtivo = 1 and msup.isLicenciada <> '0'");
		}
		try{
			int qtAlterou = q.query().executeUpdate();
			log.info("alterou qt registros=" + qtAlterou);

		}catch(Exception e){
			log.info("***ERRO ao Setar nao licenciadas Ups");
			e.printStackTrace();
		}
		
		log.paraAvaliacao();
		log.info("Fim da Importacao Ijtbinj as " + DataHoraRN.getDataHoraAtualFormatada() + " - " + log.getAvaliacaoCompleta());
	}
		
	private MsUp importarParaMsUp(Ijtbinj ijtbinj){
		// Procura se existe o MsUp
		UpRN rn = new UpRN(getDaoPdba(),getDaoInjet());

		MsUp mspojo = null;
		boolean isAlterou = false;
		try {
			log.info("pesquisando em msup cdinjestendido=" + ijtbinj.getCdinjestendido());
			mspojo = rn.pesquisarMsUpPorCdUpStAtivo(ijtbinj.getCdinjestendido());
			log.info("encontrado msup com id=" + mspojo.getIdUp() + " e stAtivo = " + mspojo.getStAtivo());
		} catch (RegistroDesconhecidoException e){
			log.info("pesquisarMsUpPorCdUpStAtivo nao encontrado para cdup = " + ijtbinj.getCdinjestendido());
			log.info("incluindo a msup com cd = " + ijtbinj.getCdinjestendido());
			mspojo = new MsUp();
			mspojo.setIdUp(null);
			mspojo.setCdUp(ijtbinj.getCdinjestendido());
			mspojo.setRevisao(BigDecimal.ONE);
			mspojo.setMsUsr(null);
			mspojo.setStAtivo(BigDecimal.ONE);
			isAlterou = true;
		}
		if(mspojo!=null){
			// Altera valores de MsUp apenas se houver divergencia em  algum campo
			if ( 	(mspojo.getDsUp() == null && ijtbinj.getCdinjestendido() != null) ||
					(mspojo.getDsUp() != null && ijtbinj.getCdinjestendido() != null && mspojo.getDsUp().equals(ijtbinj.getCdinjestendido()) == false)
					) {
				mspojo.setDsUp(ijtbinj.getCdinjestendido());
				isAlterou = true;
			}
			if ( (mspojo.getIsLicenciada() != null && mspojo.getIsLicenciada() == false) ||
					mspojo.getIsLicenciada() == null) {
				mspojo.setIsLicenciada(true);
				isAlterou = true;
			}
			if ( mspojo.getTpUp() == null || mspojo.getTpUp().equals(ijtbinj.obtemTpLicenca()) == false) {
				mspojo.setTpUp(ijtbinj.obtemTpLicenca());
				isAlterou = true;
			}
			
			/* Verificar se existe uma outra UP com a mesma descricao mas com codigo diferente
			 * Se existir e o codigo do BC da up corrente for vazio, entao a nova UP deve assumir o mesmo BC da UP
			 * que existe com descricao igual. Isso deve ser feito para o Injet que ja pode ter um cadastro previo de UPs com codigo interno.
			 */
			MsUp msupAnterior = null;
			if (mspojo.getCdBc() == null || (mspojo.getCdBc() != null && mspojo.getCdBc().trim().equals("") == false)) {
				// Pesquisar se existe UP com mesma descricao, codigos diferentes e ativa
				try {
					msupAnterior = rn.pesquisaUmMsUpPorDsUpComCdUpDiffComCdBcNotNulleAtivo(mspojo.getCdUp(), mspojo.getDsUp());
				} catch (RegistroDesconhecidoException e) {
					msupAnterior = null;
				}
				if (msupAnterior != null) {
					mspojo.setCdBc(msupAnterior.getCdBc());
					isAlterou = true;
				}
			}

			if (isAlterou == true) {
				mspojo.setDthrRevisao(DataHoraRN.getDataHoraAtual());
				mspojo.setDthrStativo(DataHoraRN.getDataHoraAtual());
				mspojo.setStAtivo(BigDecimal.ONE);
				// Persiste
				getDaoPdba().makePersistent(mspojo);
				

				if (msupAnterior != null) {
					/* Verificar tambem se a UP anterior já está no cadastro de um MS ativo. Se existir substitui-lo pela nova UP
					 * Isso é necessário pq o cadastro anterior do MS está sendo substituido com o novo cadastro da UP
					 * Esse novo cadastro da UP deve ser feito devido as alteracoes feitas no IDW para permitir o 
					 * funcionamento do inova com concentrador C#.
					 */
					MapQuery q = new MapQuery(getDaoPdba().getSession());
					q.append("update MsMsicup a set a.msUp=:msupNova where a.msUp = :msupAntiga and exists (from MsMs b where b.stAtivo = 1 and b.idMs=a.msMs.idMs)");
					q.defineParametro("msupNova", mspojo);
					q.defineParametro("msupAntiga", msupAnterior);
					try{
						int qtdeAlterados = q.query().executeUpdate();
						log.info("MsMsicup alterado de cdUp=" + msupAnterior.getCdUp() + " para cdUp=" + mspojo.getCdUp() + " qtde reg alterados=" + qtdeAlterados);
					} catch (Exception e) {
						e.printStackTrace();
						log.info("Nao alterou MsMsicup por ", e);
						isAlterou = false;
					}
				}
				
			} else {
				getDaoPdba().evict(mspojo);
			}
		}
		return mspojo;
	}
}
