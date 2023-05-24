package injetws.model.rn;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.rn.DataHoraRN;
import idw.model.rn.pdba.ProducaoPdbaMsEvtRN;
import idw.util.IdwLogger;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.excessoes.SemSGBDException;
import injetws.model.pojos.PrColetorEventos;
import injetws.model.pojos.PrEventosBridgeCollecDb;
import injetws.model.pojos.PrUp;
import injetws.model.rn.injet.InjetParadaRN;
import injetws.webservices.dto.IwsCicloDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.webservices.dto.IwsParadaDTO;
import ms.coleta.Stubedelegate;
import ms.coleta.servico.ServicoFactory;
import ms.excessao.ServicoFalhouException;
import ms.model.dao.AbstractPdbaInjetDAO;
import ms.model.dto.UpDTO;

@SuppressWarnings("unchecked")
public class ProducaoRN extends AbstractPdbaInjetDAO {

	public ProducaoRN(DAOGenericoInjet daoInjet, DAOGenerico daoPdba) {
		Validate.notNull(daoInjet);
		Validate.notNull(daoPdba);
		
		this.setDaoPdba(daoPdba);
		this.setDaoInjet(daoInjet);
	}

	public IwsCicloDTO setTr_CicloInicio(IdwLogger log, int idLog, String idUp, Date dthr) throws ServicoFalhouException {
		IwsDadosApontamentoDTO dados = new IwsDadosApontamentoDTO();
		dados.setInfoAdicional("");
		dados.setBatidas(0);
		return setTr_CicloInicio(log, idLog, idUp, dthr, dados);
	}

	public IwsCicloDTO setTr_CicloInicio(IdwLogger log, int idLog, String idUp, Date dthr, String oInfo) throws ServicoFalhouException {
		IwsDadosApontamentoDTO dados = new IwsDadosApontamentoDTO();
		dados.setInfoAdicional("");
		dados.setBatidas(0);
		return setTr_CicloInicio(log, idLog, idUp, dthr, dados);
	}

	public IwsCicloDTO setTr_CicloInicio(IdwLogger log, int idLog, String idUp, Date dthr, IwsDadosApontamentoDTO dados) throws ServicoFalhouException {
		// Boolean retorno = true;
		IwsCicloDTO dadosCic = new IwsCicloDTO();
		Boolean finalizouciclo = false;

		InfoRN rn = new InfoRN(getDaoInjet(), getDaoPdba());

		PrUp prup = rn.pesquisaPrup(log, 0, idUp);

		// Parada aberta?
		// Se sim, Parada de regulagem?
		// Se nao for Parada em regulagem, entao
		if (prup.getStparadaemaberto() == '1') {
			// Obtem ultima parada
			InjetParadaRN paradaRN = new InjetParadaRN(getDaoInjet(), getDaoPdba());
			IwsParadaDTO oParadaDTO = new IwsParadaDTO();
			try {
				oParadaDTO = paradaRN.getTr_TabParadaSetaCod(log, 0, prup.getIdup().toString(), prup.getCdultimaparada());
			} catch (RegistroDesconhecidoException e) {
				oParadaDTO.setIsRegulagem(false);
			}

			if (oParadaDTO.getIsRegulagem() != true) {
				// Fechar Parada
				// Setar a dthr do ultimo heart beat, pois FecharParada usa como
				// referencia para fim da parada
				prup.mudaDtHrUltimoHeartBeat(dthr);
				prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(dthr));
				rn.fecharParada(log, idLog, prup);
				prup.setStparadaemaberto('0');
				getDaoPdba().makePersistent(prup);
			}

			// Finaliza, Preencher in�cio do ciclo em PR_UP
			// DtHrIniCiclo = data hora de fim do ciclo atual
			// MsDtHrIniCiclo = milisegundos do fim de ciclo atual
			// O inicio do ciclo soh sera preenchido caso umas das situacoes
			// abaixo ocorra
			// 1o: o inicio de ciclo esta nulo
			// 2o: se a UP estiver configurada para a parada nao fechar ciclo,
			// siginifica que quando a parada fechar
			// e ja existir um ciclo em aberto
			// esse ciclo nao deve ser inciado novamente
			if (prup.getDthrinicic() != null) {
				Boolean isRegulagem = false;
				if (prup.getStparadaemaberto() == '1' && oParadaDTO.getIsRegulagem() == true)
					isRegulagem = true;
				
				log.info(idLog, 0, "chamando ProducaoRN.fechaCiclo a partir de producaoRN.setTr_CicloInicio");

				dadosCic = fechaCiclo(log, idLog, prup, dthr, isRegulagem, rn,dados);
				if (dadosCic.getCicloValido() == true)					
					finalizouciclo = true;
			}
			if (prup.getDthrinicic() == null || ((prup.getCfginterrupcaociclo().equals('1')) && (prup.getCfgtamanhoumpacoteciclos().doubleValue() == (double) 1))) {
				if(prup.getDthrinicic() == null || finalizouciclo==true){
					prup.setDthrinicic(dthr);
					prup.setMsdthrinicic((double) DataHoraRN.getApenasMilisegundos(dthr));
				}
				// Adicionado para tratamaneto de tempo de espera by Senoj
				prup.setDthrfimcic(null);
				prup.setMsdthrfimcic(0d);
				prup.setStcicloemaberto('1');
				prup.setTmpcicloparcial(0d);
				prup.setTmpcicloparcialaux(0d);

			}
		}
		prup.setInfoAdicional(dados.getInfoAdicional());
		getDaoPdba().getSession().merge(prup);

		// Gera log de inicio de ciclo para efeito de debug
		PrColetorEventos prcoletoreventos = new PrColetorEventos();
		prcoletoreventos.setTpevento(new BigDecimal(99));
		prcoletoreventos.setStevento("3");
		prcoletoreventos.setDthr1evento(dthr);
		prcoletoreventos.setMsdthr1evento(DataHoraRN.getApenasMilisegundos(dthr));
		prcoletoreventos.setDthr2evento(dthr);
		prcoletoreventos.setMsdthr2evento(DataHoraRN.getApenasMilisegundos(dthr));
		prcoletoreventos.setNrop(prup.getNrop());
		prcoletoreventos.setCdestrutura(prup.getCdestrutura());
		prcoletoreventos.setCdmolde(prup.getCdmolde());
		prcoletoreventos.setDthriniplanejada(prup.getDthriniplanejada());
		prcoletoreventos.setPrUp(prup);
		if (finalizouciclo == true)
			prcoletoreventos.setInf01("Fim Ciclo E Parada");
		rn.lancarEventoEsperaPrColetorEventos(log, 0, prcoletoreventos, false);

		// Lancar para o IDW um inicio de ciclo tamb�m
		if (IdwFacade.getInstancia().isIDWAtivo() == true) {
			// Caso ocorra qualquer problema, o processo nao deve parar e seguir em frente pra finalizar execucao do metodo
			try {
				ProducaoPdbaMsEvtRN idwRN = new ProducaoPdbaMsEvtRN();
				idwRN.executarServico(null, prup.getIdup().toString(), null, dthr, null, dados, ServicoFactory._INICIO_CICLO, "setTr_CicloInicio " + DataHoraRN.getDataHoraAtualFormatada());
			} catch (Exception e){
				e.printStackTrace();
			}
		}

		return dadosCic;
	}

	public IwsCicloDTO setTr_CicloFim(IdwLogger log, int idLog, String idUp, Date dthr, IwsDadosApontamentoDTO dados) throws SemSGBDException, ServicoFalhouException {
		InfoRN rn = new InfoRN(getDaoInjet(), getDaoPdba());
		IwsCicloDTO dadosCic = new IwsCicloDTO();

		PrUp prup = rn.pesquisaPrup(log, 0, idUp);
		if (prup.getDthrinicic() != null) {
			log.info(idLog, 0, idUp + " - inicioDeCiclo apos pesquisarPrUp = " + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(prup.getDthrinicic()));
			
			// Se o IDW estiver ativo e a dthrinicic for diferente da que esta em memoria da UPDTO entao pesquisou uma versao antiga de prup
			// assim lancar excessao pra tentar denovo
			if (IdwFacade.getInstancia().isIDWAtivo() == true) {
				UpDTO dto = Stubedelegate.getInstancia().getMsthread().getIcUp(idUp).getUpDTO();
				/* Como existe um BUG no datetime do SQLSERVER acrescentei 2seg a data de prup para garantir que vai funcionar
				
				esta falhando no trecho abaixo
				minha teoria eh que o inicio do ciclo em dto tenha sido atualizado de forma errada, ou seja,
				prup esta sendo lida a correta mas a memoria esta errada
				avaliar essa condicao na 2a feira
				
				analisei, o q esta acontecendo eh que pr_up fica sempre com a dthriniciociclo com um valor antigo
				reativar o Auditor para prup e descobrir pq isso ocorre. Aparentemente nao ocorre nenhum erro no log
				*/
				
				if (dto != null && dto.getDthrEvtInicioCiclo() != null &&  dto.getDthrEvtInicioCiclo().after(DataHoraRN.adicionaSegundosNaData(prup.getDthrinicic(), 2))) {
					log.info(idLog, 0, "prup.dthrinic=" + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(prup.getDthrinicic()) + " < " + DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(dto.getDthrEvtInicioCiclo()));
					throw new SemSGBDException();
				}
			}
		} else
			log.info(idLog, 0, idUp + " com inicio ciclo null");
		
		prup.mudadadosApontamento(dados);
		// Parada aberta?
		// Se sim, Parada de regulagem?
		// Se nao for Parada em regulagem, entao
		if (prup.getStparadaemaberto() == null) {
			log.info(idLog, 0, "stParadaEmaberto == null mudando inicio ciclo para " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthr));
			prup.setDthrinicic(dthr);
			prup.setMsdthrinicic((double) DataHoraRN.getApenasMilisegundos(dthr));
			// Adicionado para tratamaneto de tempo de espera by Senoj
			prup.setDthrfimcic(null);
			prup.setMsdthrfimcic(0d);
			prup.setStcicloemaberto('1');
			prup.setStparadaemaberto('0');

			getDaoPdba().makePersistent(prup);

			dadosCic.setCicloValido(true);
			dadosCic.setVlEficUltCiclo(0.0d);
			return dadosCic;
		}
		// Obtem ultima parada
		InjetParadaRN paradaRN = new InjetParadaRN(getDaoInjet(), getDaoPdba());

		IwsParadaDTO oParadaDTO = new IwsParadaDTO();
		try {
			oParadaDTO = paradaRN.getTr_TabParadaSetaCod(log, 0, prup.getIdup().toString(), prup.getCdultimaparada());
		} catch (RegistroDesconhecidoException e) {
			oParadaDTO.setIsRegulagem(false);
		}

		if (prup.getStparadaemaberto() == '1') {
			if (oParadaDTO.getIsRegulagem() != true) {
				// Fechar Parada
				// Setar a dthr do ultimo heart beat, pois FecharParada usa como
				// referencia para fim da parada
				prup.mudaDtHrUltimoHeartBeat(dthr);
				prup.mudaMsDthrUltimoHeartBeat((double) DataHoraRN.getApenasMilisegundos(dthr));

				rn.fecharParada(log, idLog, prup);

				prup.setStparadaemaberto('0');

				// Inicia ciclo
				log.info(idLog, 0, "stParadaemaberto == 1 e sem regulagem setou inicio ciclo para " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthr));
				prup.setDthrinicic(dthr);
				prup.setMsdthrinicic((double) DataHoraRN.getApenasMilisegundos(dthr));
				// Adicionado para tratamaneto de tempo de espera by Senoj
				prup.setDthrfimcic(null);
				prup.setMsdthrfimcic(0d);
				prup.setStcicloemaberto('1');
				
				getDaoPdba().makePersistent(prup);
			}
		}
		if (prup.getStparadaemaberto() != '1' || (prup.getStparadaemaberto() == '1' && oParadaDTO.getIsRegulagem() == true)) {
			// Inicio de ciclo j� preenchido?DtHrIniCic, msDtHrIniCic
			// preenchidos
			if (prup.getDthrinicic() == null && prup.getMsdthrinicic() == null) {
				// Se n�o, UP Configuracoes Alterado
				upConfiguracoesAlterado(log, idLog, prup);
			} else {
				// Calcula o tempo de ciclo
				Boolean isRegulagem = false;
				if (prup.getStparadaemaberto() == '1' && oParadaDTO.getIsRegulagem() == true)
					isRegulagem = true;

				log.info(idLog, 0, "chamando ProducaoRN.fechaCiclo a partir de producaoRN.setTr_CicloFim");
				dadosCic = fechaCiclo(log, idLog, prup, dthr, isRegulagem, rn,dados);

				if (dadosCic.getCicloValido() == false) {
					return dadosCic;
				}
			}
			// Finaliza, Preencher início do ciclo em PR_UP
			// DtHrIniCiclo = data hora de fim do ciclo atual
			// MsDtHrIniCiclo = milisegundos do fim de ciclo atual
			
			log.info(idLog, 0, "MUDANDO inicio de ciclo para " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dthr) + " para up " + prup.getIdup());
			prup.setDthrinicic(dthr);
			prup.setMsdthrinicic((double) DataHoraRN.getApenasMilisegundos(dthr));
			// Adicionado para tratamaneto de tempo de espera by Senoj
			prup.setDthrfimcic(null);
			prup.setMsdthrfimcic(0d);
			prup.setStcicloemaberto('1');
			if (dados != null)
				prup.setInfoAdicional(dados.getInfoAdicional());
			else
				prup.setInfoAdicional(null);
		}

		// Alessandre em 11-2-15 mudei de merge para makepersist para avaliar pq nao esta salvando o inicio do ciclo corretamente
		getDaoPdba().makePersistent(prup);
		
		log.info(idLog, 0, "Apos o MERGE o valor de prup.dthrinicic = " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(prup.getDthrinicic()));
		dadosCic.setNumeroCiclosCont(prup.getQtdciclosexecutados());
		return dadosCic;
	}

	public IwsCicloDTO fechaCiclo(IdwLogger log, int idLog, PrUp prup, Date dthr, Boolean isregulagem, InfoRN rn,IwsDadosApontamentoDTO dados) throws ServicoFalhouException {
		IwsCicloDTO dadosCiclo = new IwsCicloDTO();
		boolean isCicloFechadoPorParada = false;
		int batidas=prup.getCfgtamanhoumpacoteciclos().intValue();
		if(dados!=null)
			batidas=dados.getBatidas();
			
		log.info(idLog, 0, "chamando fecharCiclo a partir de ProducaoRN.fechaCiclo");
		if (rn.fecharCiclo(log, idLog, prup, dthr, batidas, isregulagem, isCicloFechadoPorParada, "FechaCicloPRN") == true)
			dadosCiclo.setCicloValido(true);
		else
			dadosCiclo.setCicloValido(false);

		dadosCiclo.setVlEficUltCiclo(prup.getvleficultciclo());
		dadosCiclo.setNumeroCiclosCont(prup.getQtdciclosexecutados());

		return dadosCiclo;
	}

	public void upConfiguracoesAlterado(IdwLogger log, int idLog, PrUp prup) {

		// H� dados novos em PR_UP_CONFIGURA��ES.
		String hql = "";
		// Eventos pedendentes de leitura em PR_EVENTOS_BRIDGE_COLLEC_DB
		// TpEvento=5 e StEvento = 0
		hql += "select preventosbridgecollecdb ";
		hql += "from PrEventosBridgeCollecDb preventosbridgecollecdb ";
		hql += "where preventosbridgecollecdb.tpevento = '5' and preventosbridgecollecdb.stevento = '0' and ";
		hql += "preventosbridgecollecdb.prUp.idup = '::idup' ";

		hql = hql.replaceAll("::idup", prup.getIdup().toString());

		Query q = getDaoPdba().getSession().createQuery(hql);

		List<PrEventosBridgeCollecDb> lista = q.list();

		if (lista.size() == 0) {
			// Se nao, sai
			return;
		}

		// Se Sim,
		InfoRN rn = new InfoRN(getDaoInjet(), getDaoPdba());
		for (PrEventosBridgeCollecDb registro : lista) {

			// Transfere os dados que n�o est�o nulos de
			// PR_UP_CONFIGURA��ES para PR_UP.
			// cfgTamanhoUmPacoteCiclos
			// cfgPercTmpCicloParAuto
			// cfgInterrupcaoCiclo
			// cfgPercTmpCicloInicializa��o
			// cfgPercToleranciaSinalCiclo
			// TmpCicloPadrao
			// CfgDbc
			// CfgTolerTmpCicloParAuto
			rn.atualizarPrUpConfiguracoes(log, idLog, prup);

			// Marcar evento com lidoPR_EVENTOS_BRIDGE_COLLEC_DB
			// StEvento = 1
			registro.setStevento("1");
			getDaoPdba().getSession().merge(registro);
		}

		return;
	}

}
