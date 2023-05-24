package idw.model.rn.imp.injet;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.Validate;
import org.hibernate.exception.SQLGrammarException;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwGrupoFerramentaDAO;
import idw.model.dao.DwRapGrupoDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroInvalido;
import idw.model.excessoes.RegistroJaExiste;
import idw.model.excessoes.SemCicloPadraoException;
import idw.model.pojos.DwCal;
import idw.model.pojos.DwCalpt;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhacic;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwGrupoFerramenta;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwRapGrupo;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.injet.Ijestmol;
import idw.model.pojos.injet.Ijfictec;
import idw.model.pojos.injet.Ijgrpdetmol;
import idw.model.pojos.injet.Ijgrpmol;
import idw.model.pojos.injet.Ijmolpro;
import idw.model.pojos.injet.Ijop;
import idw.model.pojos.injet.Ijopprodutos;
import idw.model.pojos.injet.Ijtbcli;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.pojos.injet.Ijtbmol;
import idw.model.pojos.template.DwFolhaTemplate;
import idw.model.pojos.template.OmProdutoTemplate;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.FolhaRN;
import idw.model.rn.PTRN;
import idw.model.rn.PlanejamentoProducaoRN;
import idw.model.rn.injet.PlanejamentoInjetRN;
import idw.util.CompareUtils;
import idw.util.IdwLogger;
import idw.util.Util;

/**
 *
 * @author milton
 *
 */
public class ImportacaoInjetPlanejamentoRN extends ImportacaoInjetRN {

	private final PlanejamentoInjetRN planejamentoInjetRN;
	private final PlanejamentoProducaoRN planejamentoRN;
	private final PTRN ptRN;
	private final FolhaRN folhaRN;
	private final OmCfg omCfg;

	public ImportacaoInjetPlanejamentoRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.planejamentoInjetRN = new PlanejamentoInjetRN(daoInjet);
		this.planejamentoRN = new PlanejamentoProducaoRN(dao);
		this.ptRN = new PTRN(dao);
		this.folhaRN = new FolhaRN(dao);

		this.omCfg = Util.getConfigGeral(dao.getSession());

	}


	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		return true;
	}


	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt){
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importacao da tabela de planejamento");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de planejamentos disponíveis na base do injet
			List<Ijop> listPlanejamentoInjet = this.planejamentoInjetRN.listaPlanejamentoTodas();

			if(listPlanejamentoInjet.size() > 0){

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijop ijop: listPlanejamentoInjet){
					try {
						this.importar(ijop, date, omUsr, omGt);
					} catch (RegistroDesconhecidoException e) {
						this.getLog().info(this.getIdLog(), this.getIdentacao(), "Registro desconhecido. " + e.getMessage());
					} catch (RegistroJaExiste e) {
						this.getLog().info(this.getIdLog(), this.getIdentacao(), "Registro ja existe. " + e.getMessage());
					} catch (RegistroInvalido e) {
						this.getLog().info(this.getIdLog(), this.getIdentacao(), "Registro invalido. " + e.getMessage());
					} finally {
						getDao().flushReiniciandoTransacao();
						getDaoInjet().flushReiniciandoTransacao();
					}
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram lidos:" + listPlanejamentoInjet.size() + " registros");

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
			}

		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(),"Importa��oo n�o é necessária. N�o marcado para importa��oo");
		}
		
		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), this.getIdentacao(), this.getLog().getAvaliacaoCompleta());

	}
	
	/**
	 * Importa os dados de {@code Ijop} para {@code PpCp}
	 * @param ijop
	 * @param omTppt
	 * @param date
	 * @param omUsr
	 * @param omGt
	 * @throws RegistroDesconhecidoException
	 * @throws RegistroJaExiste
	 * @throws RegistroInvalido
	 */
	private void importar(Ijop ijop, Date date, OmUsr omUsr, OmGt omGt) throws RegistroDesconhecidoException, RegistroJaExiste, RegistroInvalido{

		Validate.notNull(ijop, "ijop");
		Validate.notNull(omUsr, "omUsr");

		PpCp ppCp = new PpCp();
		String nrOpExibicao = this.planejamentoInjetRN.getNrOpExibicao(ijop);
		String nrOp = ijop.getNrop();
		
		Validate.notBlank(nrOpExibicao, "nrOpExibicao");

		PpCp ppCpDB = null;

		// Pega OmPt
		OmPt omPt;
		try {
			// Procura OmPt pelo código interno da injetora
			omPt = this.ptRN.getOmPt(ijop.getIjtbinj().getCdinjestendido());
		} catch (RegistroDesconhecidoException e) {
			throw new RegistroDesconhecidoException("Planejamento " + nrOpExibicao + " " + "Máquina " + ijop.getIjtbinj().getCdinjestendido() + " nao encontrada. Precisa ser importada.");
		}

		Validate.validState(ijop.getIjestmol() != null, "ijop.getIjestmol() != null");
		Ijestmol ijestmol = ijop.getIjestmol();
		
		Ijfictec ijfictec = this.planejamentoInjetRN.getIjfictec(omPt.getCdPt(), ijestmol);

		if (ijfictec == null) {
			System.out.println("nao encontrou ijfictec " + omPt.getCdPt() + " cdmolde " + ijestmol.getId().getCdmolde() + " cdestrutura " + ijestmol.getId().getCdestrutura());
			return;
		}
		Validate.validState(ijfictec.getIjestmol() != null, "ijfictec.getIjestmol() != null");
		Validate.validState(ijfictec.getIjestmol().getIjtbmol() != null, "ijfictec.getIjestmol().getIjtbmol() != null");
		Validate.validState(ijfictec.getIjestmol().getIjtbmol().getIjtbcli() != null, "ijfictec.getIjestmol().getIjtbmol().getIjtbcli() != null" );


		Ijtbmol ijtbmol = ijfictec.getIjestmol().getIjtbmol();
		
		// Verifica se planejamento já existe. No caso alem da CP estar ativa nao deve ter havido nenhuma mudanca no ciclo padr�o e na cavidades ativas
		try {
			ppCpDB = this.planejamentoRN.findPpCpByCdCp(nrOp);

			// Verifica se está ativo
			if(ppCpDB.getStAtivo().equals((byte) 1)){
				// Se estiver ativo e o ciclo e a cavidade for a mesma entao nao importar. Procurar a folha
				String cdFolha = ijtbmol.getCdmolestendido() + "-" + ijestmol.getId().getCdestrutura();
				DwFolha dwFolhaDB = this.getDao().findByCd(DwFolha.class, cdFolha, DwFolhaTemplate._FIELD_NAME_CD, true);
				
				// Alessandre em 27-11-14 a linha abaixo foi comentada e substituida pela seguinte
				// Isso foi feito pq o ciclo padrao retornado era o de dwfolha qdo nao existia em dwfolhacic. Entretanto é necesspario que retorne 
				// exclusivamente quando for de determinado omPt
				//Double cicloPadrao = IdwFacade.getInstancia().getCicloPadrao(dwFolhaDB, omPt);
				Double cicloPadrao = this.folhaRN.getFolhacic(dwFolhaDB, omPt).getSegCiclopadrao().doubleValue();
				boolean isMudouCavidade = false;

				for(Ijmolpro ijmolpro: ijfictec.getIjestmol().getIjmolpros()){
					if (ijmolpro.getDthrfval() != null)
						continue;
					
					DwFolharapcom dwFolharapcom = null;
					
					for (DwFolharap dwfolharap : dwFolhaDB.getDwFolharaps()) {
						for (DwFolharapcom dwfolharapcomm : dwfolharap.getDwFolharapcoms()) {
							if (ijmolpro.getIjtbpro().getCdproduto().equals(dwfolharapcomm.getOmProduto().getCdProduto()) == true) {
								dwFolharapcom = dwfolharapcomm;
							}
						}
					}
					
					if(
							dwFolharapcom == null
							|| (dwFolharapcom.getQtAtiva() == null)
							|| (dwFolharapcom.getQtTotal() == null)
							|| (dwFolharapcom.getQtAtiva().doubleValue() != ijmolpro.getQtcavativas().doubleValue())
							|| (dwFolharapcom.getQtTotal().doubleValue() != ijmolpro.getQtcavidades().doubleValue())){


						isMudouCavidade = true;
					}
				}

				// Se NAO mudou ciclo nem cavidade entao nao precisa importar a op
				if ( cicloPadrao.equals(ijfictec.getCiclopadrao()) == true && isMudouCavidade == false ) {
					boolean isImportarOP = false;
					
					if(omCfg.getOmProduto() != null){
						/*
						 *  Se ppCp estiver relacionado a um produto padr�o da configura��oo geral
						 *  indica que planejamento n�o foi inserido na importa��oo
						 *  Desta forma, a importa��oo desta op deverá ser gerada agora
						 */					
						isImportarOP = ppCpDB.getPpCpproduto(omCfg.getOmProduto().getCdProduto()) != null;
						
					}

					int stCP = PpCpTemplate.StCp.CADASTRADA.getValue(); 

					if (ijop.getDthrireal() != null)
						stCP = PpCpTemplate.StCp.CONCLUIDA.getValue();

					if (ppCpDB.getStCp().equals(stCP) == false) {
						ppCpDB.setStCp(stCP);
						getDao().makePersistent(ppCpDB);
					}
					
					if(isImportarOP == false){
						throw new RegistroJaExiste("Planejamento " + nrOpExibicao);
					}
				}
			}

		} catch (RegistroDesconhecidoException e) {
		} catch (SemCicloPadraoException e) {
		}

			
		// importa folha
		DwFolha dwFolha = this.importarFolha(ijestmol, date, omUsr, omGt, omPt.getOmTppt(), ijfictec.getCiclopadrao());
		this.importarFolhacic(dwFolha, omPt, ijfictec.getCiclopadrao());

		DwRap dwRap = this.importarRap(ijtbmol, date, omUsr);
		DwFolharap dwFolharap = this.importarFolhaRap(ijtbmol, dwFolha, dwRap);

		for(Ijmolpro ijmolpro: ijfictec.getIjestmol().getIjmolpros()){
			if (ijmolpro.getDthrfval() != null)
				continue;
			this.importarFolhaRapcom(ijmolpro, dwFolharap);
		}

		// Baixar cliente
		PpCliente ppCliente = this.importarCliente(ijfictec.getIjestmol().getIjtbmol().getIjtbcli(), date, omUsr);

		DwCal dwCal = null;
		// Pega o calendário de OmPt
		if((omPt.getDwCalpts() != null) &&
			omPt.getDwCalpts().iterator().hasNext()){

			// Pega calendário válido da máquina
			for(DwCalpt dwCalpt: omPt.getDwCalpts()){
				if((dwCalpt.getDwCal() != null) && dwCalpt.getDwCal().getStAtivo().equals((byte)1)){
					dwCal = dwCalpt.getDwCal();
					break;
				}
			}
		}

		// Se n�o encontrar calendário atrelado a OmPt, pega o calendário do OmCfg
		if(dwCal == null){
			dwCal = this.omCfg.getDwCal();
		}
		
		int stCP = PpCpTemplate.StCp.CADASTRADA.getValue(); 

		if (ijop.getDthrsaida() != null)
			stCP = PpCpTemplate.StCp.CONCLUIDA.getValue();
		
		ppCp.set(null, nrOp, null, null, null, null, null, null, null, false,
				stCP,
				ijop.getDthriprevista(), ijop.getDthrfprevista(),ijop.getDthrireal(), ijop.getDthrsaida(), PpCpTemplate.TpCp.PRODUCAO.getValue(),
				false, false, false, false, false, null,
				BigDecimal.ZERO, omPt, null, null, dwCal, dwFolha, null, null, ppCliente);

		//Inclui produtos da OP, mas somente em ppCp para ao incluir o ppCp incluir por cascata o ppcpproduto
		for(Ijopprodutos ijopprodutos: ijop.getIjopprodutoses()){
			this.importarProdutoPlan(ppCp, nrOpExibicao, ijopprodutos);
		}

		ppCp = this.planejamentoRN.salvarDesativandoOriginal(ppCp, date, omUsr);


	}

	private PpCpproduto importarProdutoPlan(PpCp ppCp, String nropExibicao, Ijopprodutos ijopprodutos) throws RegistroDesconhecidoException{
		PpCpproduto ppCpproduto = new PpCpproduto();
		OmProduto omProduto = null;
		// Produto deve existir
		try{
			omProduto = this.getDao().findByCd(OmProduto.class, ijopprodutos.getIjtbpro().getCdproduto(), OmProdutoTemplate._FIELD_NAME_CD, true);
		}catch(RegistroDesconhecidoException e){
			throw new RegistroDesconhecidoException("Produto " + ijopprodutos.getIjtbpro().getCdproduto() + " n�o encontrado");
		}
		
		ppCpproduto.set(
				null,
				nropExibicao,
				ijopprodutos.getQtpecasproduzir(),
				0d,
				omProduto, ppCp);

		// Alessandre em 01-07-14 comentei a linha abaixo para evitar de incluir o ppcpproduto em separado a inclusao do ppcp
		// com o objetivo de incluir os dois pojos simultaneamente mais a frente (durante o makepersiste de ppcp)
		//ppCpproduto = this.getDao().makePersistent(ppCpproduto);
		ppCp.getPpCpprodutos().add(ppCpproduto);
		
		return ppCpproduto;

	}

	public PpCliente importarCliente(Ijtbcli ijtbcli, Date dateOperacao, OmUsr omUsrOperacao){
		PpCliente ppCliente = new PpCliente();
		PpCliente ppClienteDB = null;
		try {
			ppClienteDB = this.planejamentoRN.findPpClienteByCdCliente(ijtbcli.getCdcliente());
			ppCliente.set(null,null,null,ijtbcli.getCdcliente(), null, null, null, null,
					ijtbcli.getDscliente(), ppClienteDB.getTpCliente(), ppClienteDB.getCnpjCpf(), ppClienteDB.getEndereco(),
					ppClienteDB.getCidade(), ppClienteDB.getEstado(), ppClienteDB.getPais(), ppClienteDB.getTelefoneum(),
					ppClienteDB.getTelefonedois(), ppClienteDB.getTelefonetres(), ppClienteDB.getContato(), ppClienteDB.getHrLeadtime(),
					ppClienteDB.getUrlSite());

		} catch (RegistroDesconhecidoException e) {
			ppCliente.set(null,null,null,ijtbcli.getCdcliente(), null, null, null, null,
					ijtbcli.getDscliente(), null, null, null, null, null,
					null, null, null, null, null, null, null);

		}

		ppCliente.limitarStrings();

		ppCliente = this.planejamentoRN.salvarDesativandoOriginal(ppClienteDB, ppCliente, dateOperacao, omUsrOperacao);
		return ppCliente;
	}

	public DwFolhacic importarFolhacic(DwFolha dwFolha, OmPt omPt, double segCiclopadrao){
		DwFolhacic dwFolhacic = new DwFolhacic();
		
		try {
			dwFolhacic = this.folhaRN.getFolhacic(dwFolha, omPt);
			if((dwFolhacic.getSegCiclopadrao() != null) && (dwFolhacic.getSegCiclopadrao().doubleValue() != segCiclopadrao)){
				dwFolhacic.setSegCiclopadrao(Util.newInstanceBigDecimal(segCiclopadrao));
				dwFolhacic = this.getDao().makePersistent(dwFolhacic);
			}

		} catch (SemCicloPadraoException e) {
			dwFolhacic.setDwFolha(dwFolha);
			dwFolhacic.setOmPt(omPt);
			dwFolhacic.setSegCiclopadrao(Util.newInstanceBigDecimal(segCiclopadrao));
			dwFolhacic = this.getDao().makePersistent(dwFolhacic);
		}

		return dwFolhacic;

	}

	private DwFolha importarFolha(Ijestmol ijestmol, Date dateOperacao, OmUsr omUsrOperacao, OmGt omGt, OmTppt omTppt, double cicloPadrao){

		DwFolha dwFolha = new DwFolha();
		DwFolha dwFolhaDB = null;
		
		Ijtbmol ijtbmol = ijestmol.getIjtbmol();
		String cdFolha = ijtbmol.getCdmolestendido() + "-" + ijestmol.getId().getCdestrutura();
		BigDecimal cicloPadraoBigDecimal = Util.getBigDecimalDefault(Util.newInstanceBigDecimal(cicloPadrao));
		
		try {
			dwFolhaDB = this.getDao().findByCd(DwFolha.class, cdFolha, DwFolhaTemplate._FIELD_NAME_CD, true);
			
			// Verificar se a folha está atualizada. Para tanto a mesma precisa ter seu Cd, Ds tpPt e Gt iguais
			// Removi dessa comparacao o ciclo pois o mesmo esta sendo guardado em dwfolhacic
			// Removi tb o tipo de posto
			if(isFolhaIgualAoInjet(dwFolhaDB, omGt, cdFolha,  ijtbmol.getDsmolde())){
				dwFolha = dwFolhaDB;
			}else{			
				dwFolha.set(null, omTppt, omGt, null, null, cdFolha ,
						null, null, null, null, ijtbmol.getDsmolde(), cicloPadraoBigDecimal, dwFolhaDB.getSegCiclotimeout(),
						dwFolhaDB.getSegCiclominimo(), dwFolhaDB.getIsModelo(), dwFolhaDB.getTpFolha(),
						dwFolhaDB.getIsLogonobrigatorio(), dwFolhaDB.getSegLogoutauto(), dwFolhaDB.getSegSetup(),null,null, null, null, false, 0, 0, 0, false, null);
			}
			
		} catch (RegistroDesconhecidoException e) {
			dwFolha.set(null, omTppt, omGt, null, null, cdFolha,
					null, null, null, null, ijtbmol.getDsmolde(), cicloPadraoBigDecimal, null,
					null, null, null, null, null, null,null,null, null, null, false, 0, 0, 0, false, null);
		}
		
		// só salva se forem diferentes
		if (dwFolhaDB != dwFolha)
			dwFolha = this.getDao().salvarDesativandoOriginal(dwFolhaDB, dwFolha, dateOperacao, omUsrOperacao);

		return dwFolha;
	}
	
	private boolean isFolhaIgualAoInjet(DwFolha dwFolha, OmGt omGt, String cdFolha, String dsMolde){
		return Objects.equals(dwFolha.getOmGt().getIdGt(), omGt.getIdGt())
				&& CompareUtils.equals(dwFolha.getCdFolha(), cdFolha)
				&& CompareUtils.equals(dwFolha.getDsFolha(), dsMolde);
	}
	
	public DwFolharap importarFolhaRap(Ijtbmol ijtbmol, DwFolha dwFolha, DwRap dwRap){
		DwFolharap dwFolharap = null;
		try {
			dwFolharap = this.folhaRN.getFolharap(dwFolha, dwRap);
			if(
					dwFolharap.getQtUsada() != null && 
					dwFolharap.getQtUsada().doubleValue() != ijtbmol.getQtcavativas() )
			{
				dwFolharap.setQtUsada( Util.newInstanceBigDecimal(ijtbmol.getQtcavativas()));
				dwFolharap = this.getDao().makePersistent(dwFolharap);
			}
		} catch (RegistroDesconhecidoException e) {
			dwFolharap = new DwFolharap();
			dwFolharap.setDwFolha(dwFolha);
			dwFolharap.setDwRap(dwRap);
			dwFolharap.setQtUsada(Util.newInstanceBigDecimal(ijtbmol.getQtcavativas()));
			dwFolharap = this.getDao().makePersistent(dwFolharap);
		} catch (SQLGrammarException e) {
			e.printStackTrace();
		}

		return dwFolharap;
	}

	private DwFolharapcom importarFolhaRapcom(Ijmolpro ijmolpro, DwFolharap dwFolharap ) throws RegistroDesconhecidoException{
		DwFolharapcom dwFolharapcom;

		OmProduto omProduto = null;
		// Produto deve existir
		try{
			omProduto = this.getDao().findByCd(OmProduto.class, ijmolpro.getIjtbpro().getCdproduto(), OmProdutoTemplate._FIELD_NAME_CD, true);
		}catch(RegistroDesconhecidoException e){
			throw new RegistroDesconhecidoException("Produto " + ijmolpro.getIjtbpro().getCdproduto() + " n�o encontrado");
		}

		try {
			dwFolharapcom = this.folhaRN.getFolharapcom(dwFolharap, omProduto);
			if((dwFolharapcom.getQtAtiva() == null)
				|| (dwFolharapcom.getQtTotal() == null)
				|| (dwFolharapcom.getQtAtiva().doubleValue() != ijmolpro.getQtcavativas().doubleValue())
				|| (dwFolharapcom.getQtTotal().doubleValue() != ijmolpro.getQtcavidades().doubleValue())){

				dwFolharapcom.setQtAtiva(Util.newInstanceBigDecimal(ijmolpro.getQtcavativas()));
				dwFolharapcom.setQtTotal( Util.newInstanceBigDecimal(ijmolpro.getQtcavidades()));
				dwFolharapcom.setIdredzproduto( (byte) ijmolpro.getCdidentificacao().charAt(0));

				dwFolharapcom = this.getDao().makePersistent(dwFolharapcom);
			}

		} catch (RegistroDesconhecidoException e) {
			dwFolharapcom = new DwFolharapcom();
			dwFolharapcom.setDwFolharap(dwFolharap);
			dwFolharapcom.setOmProduto(omProduto);
			dwFolharapcom.setQtAtiva(Util.newInstanceBigDecimal(ijmolpro.getQtcavativas()));
			dwFolharapcom.setQtTotal(Util.newInstanceBigDecimal(ijmolpro.getQtcavidades()));
			dwFolharapcom.setIdredzproduto( (byte) ijmolpro.getCdidentificacao().charAt(0));

			dwFolharapcom = this.getDao().makePersistent(dwFolharapcom);
		}

		return dwFolharapcom;
	}

	private DwRap importarRap(Ijtbmol ijtbmol, Date dateOperacao, OmUsr omUsrOperacao){

		DwRap dwRap = new DwRap();
		DwRap dwRapDB = null;
		try {

			dwRapDB = this.planejamentoRN.findDwRapByCdRap(ijtbmol.getCdmolestendido(), true);
			
			if(isDwRapIgualAoDoInjet(
					dwRapDB, 
					ijtbmol.getCdmolestendido(), 
					ijtbmol.getDsmolde(), 
					Util.newInstanceBigDecimal(ijtbmol.getQtcavidades()), 
					Util.newInstanceBigDecimal(ijtbmol.getQtcavativas()))){
				
				dwRap = dwRapDB;
				
			}else{
				dwRap.set(
						null,
						ijtbmol.getCdmolestendido(),
						null, null, null, null,
						ijtbmol.getDsmolde(),
						Util.newInstanceBigDecimal(ijtbmol.getQtcavidades()),
						Util.newInstanceBigDecimal(ijtbmol.getQtcavativas()),
						dwRapDB.getDepara(),
						dwRapDB.getSegTempoliberacao(),
						dwRapDB.getDwRap(), null, null, (byte) 1 /*molde*/, null, null, null, null,
						null, null, null, null, null);
			}
		} catch (RegistroDesconhecidoException e) {
			dwRap.set(
					null,
					ijtbmol.getCdmolestendido(),
					null, null, null, null,
					ijtbmol.getDsmolde(),
					Util.newInstanceBigDecimal(ijtbmol.getQtcavidades()),
					Util.newInstanceBigDecimal(ijtbmol.getQtcavativas()),
					null, null, null, null, null, (byte) 1 /*molde*/, null, null, null, null,
					null, null, null, null, null);
		}

		
		
		dwRap.limitarStrings();
		dwRap = this.planejamentoRN.salvarDesativandoOriginal(dwRapDB, dwRap, dateOperacao, omUsrOperacao);

		// Importar o grupo de moldes desse rap, criando a estrutura
		// dw_grupo_ferramenta e dw_rap_grupo
		DwGrupoFerramentaDAO gpFerramentaDAO = new DwGrupoFerramentaDAO(getDao().getSession());
		DwRapGrupoDAO rapGpDAO = new DwRapGrupoDAO(getDao().getSession());
		for (Ijgrpdetmol ijgrpdetmol : ijtbmol.getIjgrpdetmols() ) {
			Ijgrpmol ijgrpmol = ijgrpdetmol.getIjgrpmol();
			
			// Verificar se o grupo ja esta no cadastro em dw_grupo_ferramenta
			DwGrupoFerramenta dwgrupo = gpFerramentaDAO.getDwGrupoFerramentatPorCdAtivoOrderById(ijgrpmol.getCdgrpmol());
			
			// Alterar o registro se houver alguma modificacao ou nao existir
			if (dwgrupo != null) {
				// Houve alteracao
				if (isDwGrupoFerramentaIgualDoInjet(dwgrupo, ijgrpmol.getCdgrpmol(), ijgrpmol.getDsgrpmol())) {
					continue;
				}

			} else {
				dwgrupo = new DwGrupoFerramenta();
				dwgrupo.set(null, ijgrpmol.getCdgrpmol(), 1L, DataHoraRN.getDataHoraAtual(), DataHoraRN.getDataHoraAtual(), (byte)1, ijgrpmol.getDsgrpmol());
				dwgrupo.setOmUsrByIdUsrrevisao(omUsrOperacao);
				dwgrupo.setOmUsrByIdUsrstativo(omUsrOperacao);
				getDao().makePersistent(dwgrupo);
				getDao().flushReiniciandoTransacao();
			}
			// Pesquisar se ja existe no cadastr dw_rap_grupo
			DwRapGrupo dwrapgrupo = rapGpDAO.getDwRapGrupo(dwgrupo, dwRap);
			if (dwrapgrupo == null) {
				dwrapgrupo = new DwRapGrupo();
				dwrapgrupo.setDwGrupoFerramenta(dwgrupo);
				dwrapgrupo.setDwRap(dwRap);
				dwrapgrupo.setIdRapGrupo(null);
				getDao().makePersistent(dwrapgrupo);
			}

		}
		
		return dwRap;

	}
	
	private boolean isDwGrupoFerramentaIgualDoInjet(DwGrupoFerramenta dwgrupo, String cdGrupo, String dsGrupo) {
		return 
				CompareUtils.equals(dwgrupo.getCdGrupoFerramenta(), cdGrupo) && 
				CompareUtils.equals(dwgrupo.getDsGrupoFerramenta(), dsGrupo);
	}
	private boolean isDwRapIgualAoDoInjet(DwRap dwRap, String cdMoldeEstendido, String dsMolde, BigDecimal qtcavidades, BigDecimal qtcavativas){
		return CompareUtils.equals(dwRap.getCdRap(), cdMoldeEstendido)
				&& CompareUtils.equals(dwRap.getDsRap(), dsMolde)
				&& CompareUtils.equals(dwRap.getQtTotal(), qtcavidades)
				&& CompareUtils.equals(dwRap.getQtAlocada(), qtcavativas)
				&& CompareUtils.equals(dwRap.getTpRap(), Util.newInstanceBigDecimal(1));
	}
	
}

