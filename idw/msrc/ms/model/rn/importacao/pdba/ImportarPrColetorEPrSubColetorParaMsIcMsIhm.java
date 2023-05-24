package ms.model.rn.importacao.pdba;

import java.math.BigDecimal;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.MsIc;
import idw.model.pojos.MsIhm;
import idw.model.pojos.MsMs;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.MsUp;
import idw.model.pojos.MsUpihm;
import idw.model.pojos.MsUsr;
import idw.model.pojos.injet.Ijtbcoletores;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.Ijtbsubcoletores;
import idw.model.pojos.template.MsIcTemplate;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.pojos.PrUp;
import ms.excessao.IhmDesconhecidoException;
import ms.model.dto.ResultadoMSDTO;
import ms.model.rn.IcRN;
import ms.model.rn.IhmRN;
import ms.model.rn.MsRN;
import ms.model.rn.UpRN;
import ms.model.rn.UsuarioMSRN;
import ms.model.rn.injet.ColetoresInjetRN;
import ms.model.rn.injet.MaquinaInjetRN;

public class ImportarPrColetorEPrSubColetorParaMsIcMsIhm extends ColetoresInjetRN implements IImportaParaPdba{

	private IdwLogger log;
	private DAOGenerico daoPdba;
	private BigDecimal idMs;
	private String login;
	private ResultadoMSDTO resultado = new ResultadoMSDTO(); 

	public ImportarPrColetorEPrSubColetorParaMsIcMsIhm(IdwLogger log, DAOGenericoInjet daoInjet, DAOGenerico daoPdba){
		this.log = log;
		this.setDao(daoInjet);
		this.daoPdba = daoPdba;
	}
	public void setIdMs(BigDecimal idMs){
		this.idMs = idMs;
	}
	public void setLogin(String login){
		this.login = login;
	}
	@Override
	public void importar(List<PrUp> listaPrup) {
		log.iniciaAvaliacao("ImportarPrColetorEPrSubColetorParaMsIcMsIhm");
		log.info("Iniciando ImportarPrColetorEPrSubColetorParaMsIcMsIhm");
		resultado.setIdMensagem(resultado.COM_SUCESSO);

		// Valida Ms, se nao existir retornar
		if (this.idMs == null){
			log.info("Abortando ImportarPrColetorEPrSubColetorParaMsIcMsIhm pois idMs = null");
			resultado.setIdMensagem(resultado.ERRO_CDMS_DESCONHECIDO);
			return;
		}
		
		MsRN msrn = new MsRN();
		msrn.setSession(daoPdba.getSession());
		msrn.setIdMs(idMs);
		List<MsMs> listamsms = msrn.pesquisarMsMsByPojo();
		MsMs msms = null;
		
		if (listamsms != null && listamsms.size() > 0)
			msms = listamsms.get(0);
		
		if (msms == null){
			log.info("Abortando ImportarPrColetorEPrSubColetorParaMsIcMsIhm pois idMs = " + this.idMs + " nao encontrado.");
			resultado.setIdMensagem(resultado.ERRO_CDMS_DESCONHECIDO);
			return;
		}
		
		if (msms.getIsImportouTm() != null && msms.getIsImportouTm()){
			log.info("Abortando ImportarPrColetorEPrSubColetorParaMsIcMsIhm pois ja houve uma importa��o de   " + this.idMs + " .");
	        resultado.setIdMensagem(resultado.ERRO_IMPORTACAO_JA_OCORREU);
	        return;
		}

		// Valida o usuario logado
		if (this.login == null){
			log.info("Abortando ImportarPrColetorEPrSubColetorParaMsIcMsIhm pois idUsr eh null");
			resultado.setIdMensagem(resultado.ERRO_USUARIO_DESCONHECIDO);
			return;
		}
		UsuarioMSRN usuRN = new UsuarioMSRN(daoPdba);
		usuRN.setLogin(login);
		
		MsUsr msusr = null;
		msusr = usuRN.pesquisarMsUsrUsandoLogin();
		
		if (msusr == null){
			log.info("Abortando ImportarPrColetorEPrSubColetorParaMsIcMsIhm pois idUsr = " + this.login + " nao encontrado.");
			resultado.setIdMensagem(resultado.ERRO_USUARIO_DESCONHECIDO);
			return;
		}

		IcRN icrn = null;
		IhmRN ihmrn = null;
		UpRN uprn = null;
		
		// Pesquisa a lista de todos os coletores e sub-coletores
		List<Ijtbcoletores> listaIjtbcoletores = this.pesquisarListaIjtbcoletores();
		resultado.setIdMensagem(resultado.ERRO_LISTA_VAZIA);
		for (Ijtbcoletores ijtbcoletores : listaIjtbcoletores){
			log.info("Iniciando processamento de ijtbcoletor " + ijtbcoletores.getId().getCdmestre() + "/" + ijtbcoletores.getId().getCdcoletor());
			
			// Verifica se ijtbcoletores existe em MsIc
			icrn = new IcRN(daoPdba);
			icrn.setUrl_conexao(ijtbcoletores.getIdalterncoletor());
			List<MsIc> listaMsIc = icrn.pesquisarMsIcByPojo();
			MsIc msic = null;
			if (listaMsIc == null || listaMsIc.size() <= 0) {
				// Verificar se existe um IC com o mesmo codigo de cd coletor. Se existir, atualizar a url_conexao dele
				icrn.setUrl_conexao(null);
				icrn.setCd_ic(ijtbcoletores.getId().getCdcoletor());
				icrn.setRevisao(1);
				listaMsIc = icrn.pesquisarMsIcByPojo();
				if (listaMsIc == null || listaMsIc.size() <= 0) {
					log.info("Nao existe MsIc, incluindo novo");
					// Incluir em MsIc
					msic = new MsIc();
					msic.setCdIc(ijtbcoletores.getId().getCdcoletor());
					msic.setDsIc("IC Importado apartir da base TM do coletor " + ijtbcoletores.getId().getCdmestre() + "/" + ijtbcoletores.getId().getCdcoletor());
					msic.setDthrRevisao(DataHoraRN.getDataHoraAtual());
					msic.setDthrStativo(DataHoraRN.getDataHoraAtual());
					msic.setIdIc(null);
					msic.setMsUsr(msusr);
					msic.setRevisao(BigDecimal.ONE);
					msic.setStAtivo(BigDecimal.ONE);
					/* Dominio para TpIc
					 * 		1 - Adam 6050
							2 - Adam 4055
							3 - Advantech TPC30 (nesse caso a thread nao eh criada, pois a informacao vem pelo Servidor TCP)
							99 - Virual (Testes)
					 
					 * Dominio para ijtpcoletores.MdColetor
					 *     	A1 = 1
						    P2 = 2
						    NE64 = 3
						    MCU_CPFLEX = 4
						    BCM_GP3101 = 5
						    ADVANTEC_TPC30 = 6
					 */
					msic.setTpIc(MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc());
				} else {
					msic = listaMsIc.get(0);
				}
				
				msic.setUrlConexao(ijtbcoletores.getIdalterncoletor());

				daoPdba.makePersistent(msic);
			} else {
				msic = listaMsIc.get(0);
			}
			
			// Verifica se ijtbcoletores existe em MsIhm
			ihmrn = new IhmRN(daoPdba);
			ihmrn.setUrl_Conexao(ijtbcoletores.getIdalterncoletor());
			MsIhm msIhm = null;
			try {
				msIhm = ihmrn.pesquisarMsIhmPorURLConexao();
			} catch (IhmDesconhecidoException e) {
				// Incluir em MsIhm
				msIhm = new MsIhm();
				msIhm.setCdIhm(ijtbcoletores.getId().getCdcoletor());
				msIhm.setDthrCadastro(DataHoraRN.getDataHoraAtual());
				msIhm.setIdIhm(null);
				msIhm.setIsEvttodos(true);
				msIhm.setIsUpreg(true);
				msIhm.setMsUsr(msusr);
				msIhm.setUrlConexao(ihmrn.getUrl_Conexao());
				
				daoPdba.makePersistent(msIhm);
			}

			for (Ijtbsubcoletores ijtbsubcoletores : ijtbcoletores.getIjtbsubcoletoreses()){
				log.info("Iniciando processamento de ijtbsubcoletor " + ijtbsubcoletores.getId().getCdsubcoletor());
				
				// Pesquisar Ijtbinj do 
				MaquinaInjetRN maquinaInjetRN = new MaquinaInjetRN(this.getDao());
				Ijtbinj ijtbinj = null;
				ijtbinj = maquinaInjetRN.pesquisarIjtbinjByCdMestreCdColetorCdSubColetor(
						ijtbcoletores.getId().getCdmestre(), 
						ijtbcoletores.getId().getCdcoletor(), 
						ijtbsubcoletores.getId().getCdsubcoletor());
				
				// Se nao existir injetora para o coletor e subcoletor, passar para o proximo
				if (ijtbinj == null)
					continue;
				
				// Pesquisar MsUp, se nao existir nao importar avisando
				uprn = new UpRN(daoPdba,getDao());
				MsUp msup = null;
				try {
					msup = uprn.pesquisarMsUpPorCdUpStAtivo(ijtbinj.getCdinjestendido());
				} catch (RegistroDesconhecidoException e) {
					log.info("O importarPrColetorEPrSubColetorMsIcMsIhm abortou porque a UP " + ijtbinj.getCdinjestendido() +  " nao foi encontrada em MsUp");
					
					// Se nao existir � porque msUp ainda nao foi importada, entao abortar toda importacao
					resultado.setIdMensagem(resultado.ERRO_CDUP_DESCONHECIDO);
					continue; // A injetora ser� desconsiderada, pois nao foi importada
				}
				
				// Altera o codigo do BC com o codigo do mestre do TM
				msup.setCdBc(ijtbinj.getCdmestre());
				daoPdba.makePersistent(msup);
				
				// Pesquisar se existe a relacao entre MsUp e MsIhm em MsUpihm. Se nao existir, incluir
				MsUpihm msupihm = null;
				msupihm = uprn.pesquisarMsUpihm(msup, msIhm);
				
				if (msupihm == null){
					msupihm = new MsUpihm();
					msupihm.setDthrCadastro(DataHoraRN.getDataHoraAtual());
					msupihm.setIdUpihm(null);
					msupihm.setMsIhm(msIhm);
					msupihm.setMsUp(msup);
					msupihm.setUrlConexao(null);
					daoPdba.makePersistent(msupihm);
				}

				// Pesquisar se existe a relacao entre MsUp, MsIc e MsMs em MsMsicup, se nao existir incluir
				MsMsicup msmsicup = null;
				msmsicup = msrn.pesquisarMsMsIcupByMsUpIc(msms, msup, msic);
				// Se ja esta true entao nao precisa alterar novamente isso evita o SNAPSHOT caso outra sessao altere
				if (msms.getIsImportouTm() == null || msms.getIsImportouTm() == false)
					msms.setIsImportouTm(true);
				
				if (msmsicup == null){
					// Se nao existir incluir
					msmsicup = new MsMsicup();
					msmsicup.setIdMsicup(null);
					msmsicup.setMsIc(msic);
					msmsicup.setMsMs(msms);
					msmsicup.setMsUp(msup);
					msmsicup.setTpConexao(MsMsicup._TP_CONEXAO_TUDO);
					msmsicup.setUrlConexao(String.valueOf(ijtbsubcoletores.getId().getCdsubcoletor()));
					daoPdba.makePersistent(msmsicup);
					resultado.setIdMensagem(resultado.COM_SUCESSO);
				} else {
					// Altera alguns dados prevendo alguma mudanca no cadastro do TM
					if (msmsicup.getUrlConexao().equals(String.valueOf(ijtbsubcoletores.getId().getCdsubcoletor())) == false){
						msmsicup.setUrlConexao(String.valueOf(ijtbsubcoletores.getId().getCdsubcoletor()));
						daoPdba.makePersistent(msmsicup);
						resultado.setIdMensagem(resultado.COM_SUCESSO);
					}
				}
				
				log.info("Finalizando processamento de ijtbsubcoletor " + ijtbsubcoletores.getId().getCdsubcoletor());
			}
			log.info("Finalizando processamento de ijtbcoletor " + ijtbcoletores.getId().getCdmestre() + "/" + ijtbcoletores.getId().getCdcoletor());
		}
		log.paraAvaliacao();
		log.info(log.getAvaliacaoCompleta());

	}
	public ResultadoMSDTO getResultado() {
		return resultado;
	}
}
