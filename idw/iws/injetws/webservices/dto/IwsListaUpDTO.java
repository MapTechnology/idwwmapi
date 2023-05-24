package injetws.webservices.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwConsolallog;
import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.MsUp;
import idw.model.pojos.template.MsIcTemplate;
import idw.model.rn.ConsolidaRN;
import idw.util.IdwLogger;
import injetws.model.excessoes.RegistroDesconhecidoException;
import injetws.model.pojos.PrSubColetor;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpAndonPrcsft;
import injetws.model.pojos.PrUpProduto;
import injetws.model.rn.InfoRN;
import injetws.model.rn.injet.InjetParadaRN;


@SuppressWarnings("serial")
public class IwsListaUpDTO implements Serializable {
	

	private List<IwsUpDTO> ups = new ArrayList<IwsUpDTO>();
	private Boolean isFormatoInjet = true;
	private Boolean isSGBDOnline = true;
	private Boolean stAndonProcessoft = null;
	private Boolean stAndonConfiguravel = null;	
	private Date dthrUltimoBeatColetor;
	
	private List<IwsUpAndonPrcsftDTO> listUpAndonPrcsftDTO = new ArrayList<IwsUpAndonPrcsftDTO>();
	
	public IwsListaUpDTO() {
		if (IdwFacade.getInstancia().isIDWAtivo() == true) {
			this.isFormatoInjet=false;
		}		
	}
	
	/**
	 * @return the ups
	 */
	public List<IwsUpDTO> getUps() {
		return ups;
	}

	/**
	 * @param ups the ups to set
	 */
	public void setUps(List<IwsUpDTO> ups) {
		this.ups = ups;
	}		

	public void addPrUp(PrUp prup){ // usado somente para o caso da m�quina estar sem OP
		IwsUpDTO updto = new IwsUpDTO();
		updto.copyPrUp(prup);

		this.ups.add(updto);
	}
	
	public void addFullPrUp(IdwLogger log, int idLog, PrUp prup,List<IwsAndonDTO> listaAndon, DAOGenericoInjet daoInjet,DAOGenerico daoPdba){
		IwsUpDTO updto = new IwsUpDTO();			
		updto.copyPrUp(prup);
		if(prup.obtemDadosBC()!=null){
			updto.setProducaoLiquida(prup.obtemDadosBC().getQtdProducaoLiquida());
			updto.setCavidadesAtivas(prup.obtemDadosBC().getTotalCavAtivas());
		}
		//Adicionado por Senoj
		IwsCpDTO cpdto = new IwsCpDTO();
		
		cpdto.setNrop(prup.getNrop());
		cpdto.setNropestendido(prup.getNropestendido());
		cpdto.setCdmoldeestendido(prup.getCdmolestendido());
		cpdto.setCdmolde(prup.getCdmolde());
		cpdto.setCdestrutura(prup.getCdestrutura());
		cpdto.setDthrIPlanejamento(prup.getDthriniplanejada());
		if (prup.getTmpciclopadrao() != null)
			cpdto.setCicloPadrao(prup.getTmpciclopadrao().floatValue());
		else
			cpdto.setCicloPadrao(0f);

		if (prup.getCfgperctmpcicloparauto() != null)
			cpdto.setCfgPercTmpCicloParAuto(prup.getCfgperctmpcicloparauto().floatValue());
		else
			cpdto.setCfgPercTmpCicloParAuto(0f);

		if (prup.getCfgperctoleranciasinalciclo() != null)
			cpdto.setCfgPercToleranciaSinalCiclo(prup
					.getCfgperctoleranciasinalciclo().floatValue());
		else
			cpdto.setCfgPercToleranciaSinalCiclo(0f);

		if (prup.getCfgtamanhoumpacoteciclos() != null)
			cpdto.setCfgTamanhoUmPacoteCiclos(prup.getCfgtamanhoumpacoteciclos().floatValue());
		else
			cpdto.setCfgTamanhoUmPacoteCiclos(0f);
		
		
		if (prup.getCfgtolertmpcicloparauto() != null)
		{
			if(prup.getCfgtolertmpcicloparauto() != 0) //vlauria 20100203
				cpdto.setCfgTolerTmpCicloParAuto(prup.getCfgtolertmpcicloparauto());
			else
				cpdto.setCfgTolerTmpCicloParAuto(0);
		}
		else
		{
			cpdto.setCfgTolerTmpCicloParAuto(0);
		}
		if(prup.getIsOpSemColeta()!=null && prup.getIsOpSemColeta().equals("1")){
			cpdto.setIsOpSemColeta(true);
		}else
			cpdto.setIsOpSemColeta(false);
		if(prup.getIsBloqueioParadaSemConexao()!=null && prup.getIsBloqueioParadaSemConexao().equals("1") ){
			cpdto.setIsBloqueioParadaSemConexao(true);
		}else
			cpdto.setIsBloqueioParadaSemConexao(false);
		
		
		cpdto.setIsProducaoValida(true);
		cpdto.setIsSGBDOnline(true);
		
		// Ver se a parada eh a 999999
		if( (prup.getCdultimaparada()!=null) && (prup.getCdultimaparada().equals("999999"))){
			IwsParadaDTO paradaDTO = new  IwsParadaDTO();
			paradaDTO.setCdParada("999999");
			paradaDTO.setDsParada("PARADA NAO INFORMADA");
			paradaDTO.setIsPedeAcao(false);
			paradaDTO.setIsPedeCausa(false);
			paradaDTO.setIsPedeJust(false);
			paradaDTO.setIsPesaCalculo(true);
			paradaDTO.setIsPodeAlterarCdPar(true);
			paradaDTO.setIsTecnicoArea(false);
			paradaDTO.setQtMinimaTecnicos(0);
			paradaDTO.setIsPersistente(false);			
			paradaDTO.setDthrIparada(prup.getDthriniultimaparada());
			paradaDTO.setDthrFparada(null);
			updto.setParadaAtualOuUltimaParada(paradaDTO);
		}else{
			// Obtem ultima parada
			if( (prup.getCdultimaparada()!=null) && (!prup.getCdultimaparada().equals(""))){
				//PrParada prparada = null;
				InjetParadaRN rn = new InjetParadaRN(daoInjet,daoPdba);
				try {
					IwsParadaDTO paradaDTO = null;
					paradaDTO = rn.getTr_TabParadaSetaCod(log, idLog, updto.getIdUP(), prup.getCdultimaparada());
					paradaDTO.setDthrIparada(prup.getDthriniultimaparada());
					paradaDTO.setDthrFparada(null);
					updto.setParadaAtualOuUltimaParada(paradaDTO);
				} catch (RegistroDesconhecidoException e) {
					e.printStackTrace();
				}
			}			
		}

		// Obtem lista de produtos
		for (PrUpProduto prupproduto : prup.getPrUpProdutos()){
			IwsProdutoDTO produtoDTO = new IwsProdutoDTO();
			produtoDTO.setCdProduto(prupproduto.getCdproduto());
			produtoDTO.setCdReduzido(String.valueOf(prupproduto.getIdreduzidaproduto()));
			produtoDTO.setDsProduto(prupproduto.getDsproduto());			
			cpdto.addProdutoDTO(produtoDTO);
		}

		if(updto.isStIntegracaoDoal()) {
			InfoRN rn = new InfoRN(daoInjet,daoPdba);
			updto.setUltimaMateriaPrimaAtual(rn.getTr_ultimaMateriaPrima(updto.getIdUP()));			
		}
		updto.setCp(cpdto);

		// adicionar o andonprcsftdto a updto
		for(IwsUpAndonPrcsftDTO oUpAndonPrcsftDTO : listUpAndonPrcsftDTO) {
			// se a idup do andonprcsftdto e da updto forem iguais, coloca o andon dentro da updto
			if(oUpAndonPrcsftDTO.getidup().equals(updto.getIdUP())) {
				updto.setoUpAndonPrcsftDTO(oUpAndonPrcsftDTO);
			}
		}
		if(listaAndon!=null)
			updto.setListaAndonDTO(listaAndon);
			
		this.ups.add(updto);		
	}
	
	private void setPrUps(List<PrUp> ups) {
		for(PrUp prup : ups){
			IwsUpDTO updto = new IwsUpDTO();			
			updto.copyPrUp(prup);
			//Adicionado por Senoj
			IwsCpDTO cpdto = new IwsCpDTO();

			cpdto.setNrop(prup.getNrop());
			cpdto.setNropestendido(prup.getNropestendido());
			cpdto.setCdmoldeestendido(prup.getCdmolestendido());
			cpdto.setCdmolde(prup.getCdmolde());
			cpdto.setCdestrutura(prup.getCdestrutura());
			cpdto.setDthrIPlanejamento(prup.getDthriniplanejada());
			if (prup.getTmpciclopadrao() != null)
				cpdto.setCicloPadrao(prup.getTmpciclopadrao().floatValue());
			else
				cpdto.setCicloPadrao(0f);

			if (prup.getCfgperctmpcicloparauto() != null)
				cpdto.setCfgPercTmpCicloParAuto(prup.getCfgperctmpcicloparauto().floatValue());
			else
				cpdto.setCfgPercTmpCicloParAuto(0f);

			if (prup.getCfgperctoleranciasinalciclo() != null)
				cpdto.setCfgPercToleranciaSinalCiclo(prup.getCfgperctoleranciasinalciclo().floatValue());
			else
				cpdto.setCfgPercToleranciaSinalCiclo(0f);

			if (prup.getCfgtamanhoumpacoteciclos() != null)
				cpdto.setCfgTamanhoUmPacoteCiclos(prup.getCfgtamanhoumpacoteciclos().floatValue());
			else
				cpdto.setCfgTamanhoUmPacoteCiclos(0f);
			
			
			if (prup.getCfgtolertmpcicloparauto() != null){
				if(prup.getCfgtolertmpcicloparauto() != 0) //vlauria 20100203
					cpdto.setCfgTolerTmpCicloParAuto(prup.getCfgtolertmpcicloparauto());
				else
					cpdto.setCfgTolerTmpCicloParAuto(0);
			}
			else{
				cpdto.setCfgTolerTmpCicloParAuto(0);
			}
			
			cpdto.setIsProducaoValida(true);
			cpdto.setIsSGBDOnline(true);
			updto.setCp(cpdto);

			// adicionar o andonprcsftdto a updto
			for(IwsUpAndonPrcsftDTO oUpAndonPrcsftDTO : listUpAndonPrcsftDTO) {
				// se a idup do andonprcsftdto e da updto forem iguais, coloca o andon dentro da updto
				if(oUpAndonPrcsftDTO.getidup().equals(updto.getIdUP())) {
					updto.setoUpAndonPrcsftDTO(oUpAndonPrcsftDTO);
				}
			}
			
			// Determina se o INOVA eh o MINI REMOTO
			if (prup.obtemIsInovaMiniRemoto())
				updto.setInovaMini(true);
			
			this.ups.add(updto);
		}
	}		
	

	public void setPrUpAndonPrcsfts(PrUpAndonPrcsft oPrUpAndonPrcsft) {
		IwsUpAndonPrcsftDTO oUpAndonPrcsftDTO = new IwsUpAndonPrcsftDTO();
		
		oUpAndonPrcsftDTO.copyPrUpAndonPrcsft(oPrUpAndonPrcsft);
		
		listUpAndonPrcsftDTO.add(oUpAndonPrcsftDTO);
	}
	
	public void setRele(IwsReleDTO Rele01, IwsReleDTO Rele02, IwsReleDTO Rele03, IwsReleDTO Rele04, IwsReleDTO Rele05){
		if(ups.size()>0){
			for(IwsUpDTO updtoInsere:ups){
				updtoInsere.setRele01(Rele01);
				updtoInsere.setRele02(Rele02);
				updtoInsere.setRele03(Rele03);
				updtoInsere.setRele04(Rele04);
				updtoInsere.setRele05(Rele05);				
			}
			
		}
		
	}

	/**
	 * @return the isSGBDOnline
	 */
	public Boolean getIsSGBDOnline() {
		return isSGBDOnline;
	}

	/**
	 * @param isSGBDOnline the isSGBDOnline to set
	 */
	public void setIsSGBDOnline(Boolean isSGBDOnline) {
		this.isSGBDOnline = isSGBDOnline;
	}
	//vlauria 20100318
	public void setStAndonProcessoft(Boolean stAndonProcessoft) {
		this.stAndonProcessoft = new Boolean(false);
		this.stAndonProcessoft = stAndonProcessoft;
	}

	public Boolean getStAndonProcessoft() {
		return this.stAndonProcessoft;
	}

	public void setStAndonConfiguravel(Boolean stAndonConfiguravel) {
		this.stAndonConfiguravel = stAndonConfiguravel;
	}

	public Boolean getStAndonConfiguravel() {
		
		return this.stAndonConfiguravel;
	}

	/**
	 * @return the dthrUltimoBeatColetor
	 */
	public Date getDthrUltimoBeatColetor() {
		return dthrUltimoBeatColetor;
	}

	/**
	 * @param dthrUltimoBeatColetor the dthrUltimoBeatColetor to set
	 */
	public void setDthrUltimoBeatColetor(Date dthrUltimoBeatColetor) {
		this.dthrUltimoBeatColetor = dthrUltimoBeatColetor;
	}
	
	/**
	 * @return the isFormatoInjet
	 */
	public Boolean getIsFormatoInjet() {
		return isFormatoInjet;
	}

	/**
	 * @param isFormatoInjet the isFormatoInjet to set
	 */
	public void setIsFormatoInjet(Boolean isFormatoInjet) {
		this.isFormatoInjet = isFormatoInjet;
	}


	

	public void addMsUp(MsUp msup, DAOGenerico dao) {
		/*
		IwsUpDTO up = new IwsUpDTO();
		up.setCavidadesAtivas(1);
		up.setCdMaquina(msup.getCdUp());
		up.setIdUP(msup.getCdUp());
		up.setStCriacaoCP(6);
		ups.add(up);
		setIsSGBDOnline(true);
		*/
		
		PrUp prup = new PrUp();
		prup.setCdmaqestendido(msup.getCdUp());
		prup.setCdmaquina(msup.getCdUp());
		prup.setIdup(msup.getIdUp());
		prup.setNrop(msup.getNrop());
		prup.setCfgtpsessaoproducao("2");
		PrSubColetor prSubColetor = new PrSubColetor();
		
		for (MsMsicup msicup : msup.getMsMsicups()) {
			try {
				prSubColetor.setIdsubcoletor(new BigDecimal(msicup.getUrlConexao()));
			} catch (Exception e) {
				prSubColetor.setIdsubcoletor(BigDecimal.ONE);
			}
		}
		prup.setPrSubColetor(prSubColetor);
		
		prup.setNropestendido(msup.getNrop());
		// Obtem os operadores logados
		ConsolidaRN rn = new ConsolidaRN(dao);
		List<DwConsolmolog> dwconsolmologs = rn.getDwConsolmologComLoginAbertoByCdUp(msup.getCdUp());
		List<IwsModDTO> logins = new ArrayList<IwsModDTO>();
		
		for (DwConsolmolog molog : dwconsolmologs) {
			IwsModDTO dto = new IwsModDTO();
			dto.setDthrLogin(molog.getDthrIlogin());
			dto.setDthrLogout(null);
			dto.setIdGrupoUsu("1");
			dto.setIdUsuario(String.valueOf(molog.getOmUsr().getIdUsr()));
			dto.setLogin(molog.getOmUsr().getLogin());
			dto.setNome(molog.getOmUsr().getDsNome());
			logins.add(dto);
		}
		prup.mudaListaLoginsEmAberto(logins);

		//lista dos alertas em aberto
		List<DwConsolallog> dwconsolallogs = rn.getDwConsolalComAlertaAberto(msup.getCdUp());
		List<IwsAlertaDTO> alertas = new ArrayList<IwsAlertaDTO>();
		
		for (DwConsolallog log : dwconsolallogs) {
			IwsAlertaDTO alerta = new IwsAlertaDTO();
			
			alerta.setCdAlerta(log.getDwTAlerta().getCdTalerta());
			alerta.setDsAlerta(log.getDwTAlerta().getDsTalerta());
			alerta.setdthrinialerta(log.getDthrIalerta());
			alerta.setIdAlerta(String.valueOf(log.getDwTAlerta().getIdTalerta()));
			alerta.setIdRevisao(1);
			alerta.setmsDtHrIniAlerta(0d);
			alerta.setStAlerta(1);
			alerta.setTempolimite(0d);
			alerta.setTpAlerta(1);

			alertas.add(alerta);
		}
		
		prup.mudaListaAlertasEmAberto(alertas);
		
		MsMsicup msicup = msup.getMsMsicups().iterator().next();
		
		if (msicup.getMsIc().getTpIc().equals(MsIcTemplate.TpIc._TP_IC_MINI_REMOTO.getTpIc()))
			prup.mudaInovaMiniRemoto(true);
		
		List<PrUp> lista = new ArrayList<PrUp>();
		
		lista.add(prup);
		
		setPrUps(lista);
	}
}
