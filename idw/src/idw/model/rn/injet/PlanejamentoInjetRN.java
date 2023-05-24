package idw.model.rn.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmPtDAO;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolharap;
import idw.model.pojos.DwFolharapcom;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCliente;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.injet.Ijcarteira;
import idw.model.pojos.injet.Ijcnsmaqop;
import idw.model.pojos.injet.Ijcnsturno;
import idw.model.pojos.injet.Ijestmol;
import idw.model.pojos.injet.Ijfictec;
import idw.model.pojos.injet.Ijop;
import idw.model.pojos.injet.Ijopagrupsulbras;
import idw.model.pojos.injet.Ijopprodutos;
import idw.model.pojos.injet.Ijoproteiro;
import idw.model.pojos.injet.Ijplanop;
import idw.model.pojos.injet.Ijtbcli;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.dto.CavidadePesoInjetDTO;
import idw.model.rn.injet.dto.FiltroMaquinaInjetDTO;
import idw.model.rn.injet.dto.MaquinaInjetDTO;
import idw.model.rn.injet.dto.MaquinaPlanejamentoInjetDTO;
import idw.model.rn.injet.dto.RefugoTempoInjetDTO;
import idw.util.FormulasInjet;
import idw.webservices.dto.CpDTO;
import idw.webservices.dto.ListaCPDTO;
import idw.webservices.dto.PeriodoDTO;
import injetws.model.excessoes.RegistroDesconhecidoException;
import ms.util.ConversaoTipos;


public class PlanejamentoInjetRN extends AbstractRN<DAOGenericoInjet> {
	private enum StOp{
		OPDISPONIVEL("0"), OPPRODUCAOINICIADA("1"), OPSUSPENSA("2"), OPCONCLUIDA("3"), OPCANCELADA("4");
		private final String value;
		StOp(String value){
			this.value = value;
		}
		public String getValue(){
			return this.value;
		}
	}

	public PlanejamentoInjetRN() {
		super(new DAOGenericoInjet());
	}
	
	public PlanejamentoInjetRN(DAOGenericoInjet dao) {
		super(dao);
	}

	public List<Ijop> listaPlanejamentoTodas(){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("select ijop");
		q.append(" from Ijop ijop ");
		q.append(" join fetch ijop.ijtbstop ijtbstop");
		// Alessandre: em 8-9-14 acrescentei o join abaixo e a clausula adicional no where para reduzir a qdt de ops importadas
		// ou seja, nao irei importar as ops das injetoras desativadas.
		q.append("join ijop.ijtbinj ijtbinj");
		q.append(" where ijop.nrop <> :nrop");
		q.append("and ijtbinj.stinjetora <> 1");
		q.append("and ijop.dthriprevista >= :data");
		
		q.defineParametro("nrop", "9999999999");
		q.defineParametroData("data", DataHoraRN.subtraiDiasDaData(DataHoraRN.getDataHoraAtual(), 30));
		

		return q.list();
	}
	
	public List<Ijestmol> pesquisarTodosIjestmol() {
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from Ijestmol a");
		q.append("where a.estruturaativa = 1");
		return q.list();
	}
	
	/**
	 * Lista as ordens de produ��o que est�o com status de dispon�vel
	 * @return
	 */
	public List<Ijop> listaPlanejamentoDisponivelOuIniciado(){

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append(" from Ijop ijop ");
		q.append(" join fetch ijop.ijtbstop ijtbstop");
		q.append(" where ijop.nrop <> :nrop");
		q.append(" and (ijtbstop.stop=:disponivel or ijtbstop.stop=:iniciada)");
		q.defineParametro("nrop", "9999999999");
		q.defineParametro("disponivel",StOp.OPDISPONIVEL.getValue());
		q.defineParametro("iniciada",StOp.OPPRODUCAOINICIADA.getValue());
		

		return q.list();
	}

	/**
	 * Extrai do objeto {@code Ijop} o n�mero de exibi��o da ordem de produ��o
	 * @param ijop
	 * @return
	 */
	public String getNrOpExibicao(Ijop ijop){

		Validate.notNull(ijop, "ijop");

		Validate.notNull(ijop.getIjoproteiros(),"ijop.getIjoproteiros()");
		Validate.isTrue(!ijop.getIjoproteiros().isEmpty());
		Ijoproteiro ijoproteiro =  ijop.getIjoproteiros().iterator().next();

		Validate.notNull(ijoproteiro, "ijoproteiro");

		Validate.notNull(ijoproteiro.getId(), "ijoproteiro.getId()");

		return ijoproteiro.getId().getNropexibicao();

	}

	public Ijfictec getIjfictec(String cdinjetora, Ijestmol ijestmol){

		MapQuery q = new MapQuery(this.getDao().getSession());
		
		q.append("select ijfictec");
		q.append(" from Ijfictec ijfictec ");
		q.append(" join ijfictec.ijtbinj ijtbinj");
		q.append(" where ijfictec.ijestmol = :ijestmol ");
		q.append(" and ijfictec.dthrfvalcic is null ");
		q.append(" and ijtbinj.cdinjetora = :cdinjetora");
		
		q.defineParametro("ijestmol", ijestmol);
		q.defineParametro("cdinjetora", cdinjetora);

		q.setMaxResults(1);

		return (Ijfictec) q.uniqueResult();
	}

	public List<Ijfictec> getTodasIjfictec(Ijestmol ijestmol){

		MapQuery q = new MapQuery(this.getDao().getSession());
		
		q.append("select ijfictec");
		q.append(" from Ijfictec ijfictec ");
		q.append(" join ijfictec.ijtbinj ijtbinj");
		q.append(" where ijfictec.ijestmol = :ijestmol ");
		q.append(" and ijfictec.dthrfvalcic is null ");
		
		q.defineParametro("ijestmol", ijestmol);


		return q.list();
	}


	public List<Ijop> pesquisarListaIjop(FiltroMaquinaInjetDTO filtro) {
		List<Ijop> retorno = new ArrayList<Ijop>();

		String HQL = "";

		//HQL += "select distinct ijcnsturno ";
		HQL += "from Ijcnsturno ijcnsturno ";
		HQL += "join fetch ijcnsturno.ijop ijop ";
		HQL += "join fetch ijop.ijopprodutoses ijopprodutos ";
		HQL += "join fetch ijopprodutos.ijtbpro ijtbpro ";
		HQL += "where  ";
		HQL += "ijcnsturno.id.cdinjetora = '::cdmaquina' ";

		if (filtro.getData() != null){
			HQL += "and ijcnsturno.id.dtturno between :data and :dtfinal ";
		}

		if (filtro.getCdTurno() != null && !filtro.getCdTurno().equals("")){
			HQL += "and ijcnsturno.id.cdturno = '::cdturno' ";
			HQL = HQL.replaceAll("::cdturno", filtro.getCdTurno());
		}

		if (filtro.getNrop() != null && !filtro.getNrop().equals("")){
			HQL += "and ijcnsturno.id.nrop = '::nrop' ";
			HQL = HQL.replaceAll("::nrop", filtro.getNrop());
		}

		if (filtro.isConsiderarMolde()){
			HQL += "and ijcnsturno.id.cdmolde = '::cdmode' ";
			HQL = HQL.replaceAll("::cdmolde", filtro.getCdMolde());
		} else if (filtro.isConsiderarMoldeGrupo() ){
			HQL += "and exists (from Ijgrpdetmol ijgrpdetmol where ijgrpdetmol.cdgrpmol = '::cdmoldegrupo' and ijgrpdetmol.cdmolde = ijcnsturno.id.cdmolde) ";
			HQL = HQL.replaceAll("::cdmoldegrupo", filtro.getCdMoldeGrupo());
		}

		if (filtro.isConsiderarProduto()){
			HQL += "and exists (from Ijmolpro ijmolpro where ijmolpro.id.cdproduto = '::cdproduto' and ijmolpro.id.cdmolde = ijcnsturno.id.cdmolde and ijmolpro.id.cdestrutura = ijcnsturno.id.cdestrutura and ijmolpro.id.dthrival = ijcnsturno.id.dthrivalestru ";
			HQL = HQL.replaceAll("::cdproduto", filtro.getCdProduto());
		}

		HQL += "order by ijcnsturno.id.cdmolde, ijcnsturno.id.cdestrutura";

		HQL = HQL.replaceAll("::cdmaquina", filtro.getCdMaquina());

		List<Ijcnsturno> listIjcnsturno = null;

		Query q = null;

		try{
			q = getDaoSession().createQuery(HQL);
		} catch (Exception e){
			e.printStackTrace();
		}

		if (filtro.getData() != null){
			q.setDate("data", filtro.getData());
			q.setDate("dtfinal", filtro.getDtFinal());
		}
		try{
			listIjcnsturno = q.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		for (Ijcnsturno ijcnsturno : listIjcnsturno){
			Ijop ijop = new Ijop();
			ijop.setNrop(ijcnsturno.getId().getNrop());
			boolean isEncontrou = false;
			for (Ijop reg : retorno){
				if (reg.getNrop().equals(ijop.getNrop()))
					isEncontrou = true;
			}
			if (isEncontrou == false)
				retorno.add(ijop);
		}
		return retorno;
	}
	public List<Ijopprodutos> pesquisarIjopprodutos(Ijop ijop){
		String hql = "";

		hql += "from Ijopprodutos ijopprodutos ";
		hql += "join fetch ijopprodutos.ijtbpro ijtbpro ";
		hql += "where ";
		hql += "ijopprodutos.id.nrop = '::nrop' ";

		hql = hql.replaceAll("::nrop", ijop.getNrop());

		Query q = null;

		try{
			q = getDaoSession().createQuery(hql);
		} catch (Exception e){
			e.printStackTrace();
		}

		List<Ijopprodutos> listaIjopprodutos = null;

		listaIjopprodutos = q.list();

		return listaIjopprodutos;
	}
	public Ijop pesquisarIjop(String nrop) throws RegistroDesconhecidoException{
		String hql = "";

		hql += "select distinct ijop ";
		hql += "from Ijop ijop ";
		hql += "join fetch ijop.ijopprodutoses ijopprodutos ";
		hql += "join fetch ijop.ijplano ijplano ";
		hql += "join fetch ijplano.ijcarteira ijcarteira ";
		hql += "join fetch ijcarteira.ijtbcli ijtbcli ";
		hql += "where ";
		hql += "ijop.nrop = '::nrop' ";

		if (nrop == null)
			throw new RegistroDesconhecidoException();
		
		hql = hql.replaceAll("::nrop", nrop);

		Query q = null;

		try{
			q = getDaoSession().createQuery(hql);
		} catch (Exception e){
			throw new RegistroDesconhecidoException();
		}

		List<Ijop> listaIjop = null;

		listaIjop = q.list();

		if (listaIjop.size() <= 0)
			throw new RegistroDesconhecidoException();

		return listaIjop.get(0);
	}
	public MaquinaPlanejamentoInjetDTO analisarPlanejamento(MaquinaInjetDTO maquinaDTO) throws RegistroDesconhecidoException{
		MaquinaPlanejamentoInjetDTO retorno = new MaquinaPlanejamentoInjetDTO();
		MaquinaInjetRN maquinaRN = new MaquinaInjetRN(getDao());
		maquinaRN.setDaoSession(getDaoSession());
		BigDecimal producaoPlanejadaOP = new BigDecimal(0);
		BigDecimal producaoPrevistaOP = new BigDecimal(0);
		BigDecimal producaoBrutaOP = new BigDecimal(0);
		BigDecimal producaoRefugadaOP = new BigDecimal(0);

		Float cicloPadrao = 0f;

		// Pesquisar OP
		Ijop ijop = null;
		try {
			ijop = pesquisarIjop(maquinaDTO.getIjtbinj().getOpatual());
		} catch (RegistroDesconhecidoException e) {
			throw new RegistroDesconhecidoException();
		}

		// Encontra a producao planejada
		for (Ijopprodutos ijopprodutos : ijop.getIjopprodutoses()){
//			BigDecimal ciclosPlanejadoIjopprodutos = new BigDecimal(0);
//			CavidadePesoDTO cavidadePeso = maquinaRN.totalizaListaIjmolproAPartirDeIjopprodutos(ijopprodutos);
			producaoPlanejadaOP = producaoPlanejadaOP.add(new BigDecimal(ijopprodutos.getQtpecasproduzir()));
		}

		// Encontra o ciclo padrao
		Ijplanop ijplanop = null;
		for (Ijplanop reg : ijop.getIjplanops()){
			ijplanop = reg;
		}
		String cdinjetora = "";
		String cdmolde = "";
		String cdestrutura = "";

		if (ijplanop != null){
			cdinjetora = ijplanop.getIjtbinj().getCdinjetora();
			cdmolde = ijplanop.getIjestmol().getId().getCdmolde();
			cdestrutura = ijplanop.getIjestmol().getId().getCdestrutura();
		}
		Ijfictec ijfictec;
		try {
			ijfictec = maquinaRN.pesquisarIjfictec(cdinjetora, cdmolde, cdestrutura);
			cicloPadrao = (float) ijfictec.getCiclopadrao();
		} catch (RegistroDesconhecidoException e) {
			cicloPadrao = 0f;;
		}

		// Encontrar a producao bruta e refugada
		List<Ijcnsmaqop> ijcnsmaqops = maquinaRN.pesquisarListaIjcnsmaqopAPartirDeIjop(ijop);
		for (Ijcnsmaqop ijcnsmaqop : ijcnsmaqops){
			BigDecimal producaoBrutaIjcnsmaqop = new BigDecimal(0);
			CavidadePesoInjetDTO cavidadePeso = maquinaRN.totalizaListaIjmolproAPartirDeIjcnsmaqop(ijcnsmaqop);
			producaoBrutaIjcnsmaqop = new BigDecimal(ijcnsmaqop.getQtinjnormal() * cavidadePeso.getQtcavidadesAtivas());

			producaoBrutaOP = producaoBrutaOP.add(producaoBrutaIjcnsmaqop);

			// Encontrar a producao prevista
			BigDecimal producaoPrevistaOPIjcnsmaqop = new BigDecimal(0);
			producaoPrevistaOPIjcnsmaqop = ijcnsmaqop.pegarTempoDisponivel();
			// Se o registro em ijcnsmaqop for o da maquina analisada, entao somar o 
			// tempo de parada em aberto
			if (
					ijcnsmaqop.getId().getCdinjetora().equals(maquinaDTO.getIjtbinj().getCdinjetora()) &&
					ijcnsmaqop.getId().getNrop().equals(maquinaDTO.getNrop())
			)
				producaoPrevistaOPIjcnsmaqop = 
					producaoPrevistaOPIjcnsmaqop.add(maquinaDTO.getMaquinaTotalDTO().getTempoParadaEmAbertoSegundos());

			if (cicloPadrao > 0) {
				producaoPrevistaOPIjcnsmaqop = producaoPrevistaOPIjcnsmaqop.divide(new BigDecimal(cicloPadrao), 100, BigDecimal.ROUND_HALF_UP);
				producaoPrevistaOPIjcnsmaqop = producaoPrevistaOPIjcnsmaqop.multiply(new BigDecimal(cavidadePeso.getQtcavidadesAtivas()));
			} else
				producaoPrevistaOPIjcnsmaqop = new BigDecimal(0);

			producaoPrevistaOP = producaoPrevistaOP.add(producaoPrevistaOPIjcnsmaqop);

			// Encontra a producao refugada
			RefugoTempoInjetDTO refugoTempo = maquinaRN.totalizaListaIjcnsmaqopdetrefAPartirDeIjcnsmaqop(ijcnsmaqop);

			producaoRefugadaOP = producaoRefugadaOP.add(refugoTempo.getProducaoRefugada());
		}


		BigDecimal producaoLiquidaOP = producaoBrutaOP.subtract(producaoRefugadaOP);

		Float ipr = FormulasInjet.calcularIndiceProducaoDaOP(producaoLiquidaOP, producaoPlanejadaOP);
		Float er = FormulasInjet.calcularEficienciaRealizacao(producaoLiquidaOP, producaoPrevistaOP).floatValue();

		retorno.setIndiceProducao(ipr);
		retorno.setEficienciaRealizacao(er);
		retorno.setNrop(ijop.getNrop());
		retorno.setDtInicio(ijop.getDthrireal());
		retorno.setCliente(ijop.getIjplano().getIjcarteira().getIjtbcli().getDscliente());
		retorno.setCdMolde(cdmolde);
		retorno.setCdEstrutura(cdestrutura);
//		retorno.setQtcavativas(qtcavativas);
//		retorno.setQtcavidades(qtcavidades);

		// No momento nao eh necessario o calculo dos indicadores abaixo
//		retorno.setEficienciaCiclo(eficienciaCiclo);
//		retorno.setIndiceParada(indiceParada);
//		retorno.setIndiceRefugo(indiceRefugo);

		return retorno;
	}
	public Ijtbcli pesquisarIjtbcli(Ijop ijop){
		String hql = "";

		hql += "select ijcarteira ";
		hql += "from Ijcarteira ijcarteira ";
		hql += "join fetch ijcarteira.ijtbcli ijtbcli ";
		hql += "join ijcarteira.ijplanos ijplano ";
		hql += "join ijplano.ijops ijop ";
		hql += "where ";
		hql += "ijop.id.nrop = '::nrop' ";

		hql = hql.replaceAll("::nrop", ijop.getNrop());

		Query q = null;

		try{
			q = getDaoSession().createQuery(hql);
		} catch (Exception e){
			e.printStackTrace();
		}

		List<Ijcarteira> listaIjcarteira = null;

		listaIjcarteira = q.list();

		Ijtbcli retorno = listaIjcarteira.get(0).getIjtbcli();

		return retorno;
	}
	public String obtemOPDaSulbras(String nrop, String cdproduto){
		String hql = "";

		hql += "select ijopagrupsulbras ";
		hql += "from IjOpagrupSulbras ijopagrupsulbras ";
		hql += "where ";
		hql += "ijopagrupsulbras.id.nrop = '::nrop' ";
		hql += "and ijopagrupsulbras.cdproduto = '::cdproduto' ";

		hql = hql.replaceAll("::nrop", nrop);
		// TODO analisar pq veio null no cdproduto
		hql = hql.replaceAll("::cdproduto", cdproduto);

		Query q = null;

		try{
			q = getDaoSession().createQuery(hql);
		} catch (Exception e){
			e.printStackTrace();
		}

		Ijopagrupsulbras reg = (Ijopagrupsulbras) q.uniqueResult();
		String retorno = "";
		if (reg == null)
			retorno = "";
		else {
			retorno = reg.getId().getNropimp().trim();
//			+ 
//			reg.getId().getCdoperacao().trim() + 
//			reg.getId().getSeqmovto().trim() +
//			reg.getCdproduto().trim();
		}
		return retorno;
	}
	
	
	public ListaCPDTO getPpCpByCdPtInjet(DAOGenericoInjet dao, OmPt ompt) {
		List<PpCp> lista = pesquisarPpCpByCdPtInjet(dao, ompt, null);
		ListaCPDTO retorno = new ListaCPDTO();
		retorno.setListaCps(new ArrayList<CpDTO>());
		for (PpCp ppcp : lista) {
			CpDTO dto = new CpDTO();
			dto.setCp(ppcp);
			retorno.getListaCps().add(dto);
			retorno.setIsPtSemop(false);
		}
		retorno.setIsIhmtrocaop(true);

		return retorno;
	}
	
	public List<PpCp> pesquisarPpCpByCdPtInjet(DAOGenericoInjet dao, OmPt ompt, String nrOP) {
		List<PpCp> retorno = new ArrayList<>();

		int MAX_RETORNO = 100;

		byte _nrop = 0;
		byte _nropexibicao = 1;
		byte _nrplano = 2;
		byte _cdcliente = 3;
		byte _dscliente = 4;
		byte _cdinjetora = 5;
		byte _cdinjestendido = 6;
		byte _cdientific = 7;
		byte _tpabertsessaoprod = 8;
		byte _cdmolde = 9;
		byte _cdmolestendido = 10;
		byte _cdestrutura = 11;
		byte _statusop = 12;
		byte _dthriprevista = 13;
		byte _dthrfprevista = 14;
		byte _dthrinireal = 15;
		byte _dthrfimreal = 16;
		byte _cdproduto = 17;
		byte _dsproduto = 18;
		byte _pbrutomedio = 19;
		byte _pliquidomedio = 20;
		byte _qtproduzir = 21;
		byte _fatorcontagemprod = 22;
		byte _ciclopadrao = 23;
		byte _ciclovarmin = 24;
		byte _ciclovarmax = 25;
		byte _idreduzidoproduto = 26;
		byte _qtpcscicloativas = 27;
		byte _qtpcsciclostotais = 28;
		
		class RegistroLido {
			String nrOp;
			String nrOpExibicao;
			String nrPlano;
			String cdCliente;
			String dsCliente;
			String cdMaquina;
			String cdMaqEstendido;
			String cdIdentificMaq;
			String tpSessaoProd;
			String cdMolde;
			String cdMolEstendido;
			String cdEstrutura;
			String statusOP;
			Date dtHrIniPrev;
			Date dtHrFimPrev;
			Date dtHrIniReal;
			Date dtHrFimReal;
			String cdProduto;
			String dsProduto;
			BigDecimal pBrutoMedio = BigDecimal.ZERO;
			BigDecimal pLiquidoMedio = BigDecimal.ZERO;
			BigDecimal qtProduzir = BigDecimal.ZERO;
			//BigDecimal fatorContagemProd = BigDecimal.ZERO;
			BigDecimal cicloPadrao = BigDecimal.ZERO;
			BigDecimal cicloVarMin = BigDecimal.ZERO;
			BigDecimal cicloVarMax = BigDecimal.ZERO;
			//String idReduzidoProduto;
			BigDecimal qtPcsCicloAtivas = BigDecimal.ZERO;
			BigDecimal qtPcscicloTotais = BigDecimal.ZERO;
			
		}
		
		Map<String, PpCp> mapPpCp = new HashMap<String, PpCp>();
		
		String strSQL = "";
		
		strSQL = strSQL.concat("SELECT a.nrop, b.nropexibicao, a.nrplano, d.cdcliente, e.dscliente,");
		strSQL = strSQL.concat("       a.cdinjetora, f.cdinjestendido, f.cdidentific, f.TpAbertSessaoProd,");
		strSQL = strSQL.concat("       a.cdmolde, g.cdmolestendido, a.cdestrutura,");
		strSQL = strSQL.concat("       a.stop, a.dthriprevista, a.DtHrFPrevista, h.dthrini, h.dthrfim,");
		strSQL = strSQL.concat("       i.cdproduto, j.dsproduto, j.pbrutomedio, j.pliquidomedio, i.qtpecasproduzir,");
		strSQL = strSQL.concat("       l.fatorcontagemprod, l.ciclopadrao, l.VarMin, l.VarMax,");
		strSQL = strSQL.concat("       m.cdidentificacao, m.qtcavativas, m.qtcavidades");
		
		strSQL = strSQL.concat("  FROM ijop a ");
		strSQL = strSQL.concat("  JOIN ijoproteiro b ON (b.nrop = a.nrop) ");
		strSQL = strSQL.concat("  JOIN ijplano c ON (c.nrplano = a.nrplano) ");
		strSQL = strSQL.concat("  JOIN ijcarteira d ON (d.nrcarteira = c.nrcarteira)");
		strSQL = strSQL.concat("  JOIN ijtbcli e ON (e.cdcliente = d.cdcliente)");
		strSQL = strSQL.concat("  JOIN ijtbinj f ON (f.cdinjetora = a.cdinjetora)");
		strSQL = strSQL.concat("  JOIN ijtbmol g ON (g.cdmolde = a.cdmolde)");
		strSQL = strSQL.concat("  JOIN ijopprodutos i ON (i.nrop = a.nrop AND i.cdmolde = a.cdmolde AND i.cdestrutura = i.cdestrutura)");
		strSQL = strSQL.concat("  JOIN ijtbpro j ON (j.cdproduto = i.cdproduto)");
		strSQL = strSQL.concat("  JOIN ijfictec l ON (l.cdinjetora = a.cdinjetora AND l.cdmolde = a.cdmolde AND l.cdestrutura = a.cdestrutura AND l.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat("  JOIN ijmolpro m ON (m.cdmolde = l.cdmolde AND m.cdestrutura = l.cdestrutura AND m.dthrival = l.dthrivalestru)");
		strSQL = strSQL.concat("  LEFT JOIN (SELECT nrop, MIN(DtHrEntrada) as dthrini, MAX(DtHrSaida) as dthrfim FROM IJentsaiOPMAQ GROUP BY nrop) h ON (h.nrop = a.nrop)");

		strSQL = strSQL.concat(" WHERE f.cdinjestendido = '" + ompt.getCdPt() + "'");
		
		if (!nrOP.equals("")) {
			strSQL = strSQL.concat(" AND a.nrop = '" + nrOP + "'");
		}
		
		strSQL = strSQL.concat(" ORDER BY a.nrop, m.cdidentificacao");
		List<Object> lista = dao.getSession().createSQLQuery(strSQL).list();
		
		for (Object reg : lista) {
			RegistroLido regOP = new RegistroLido();
			
			Object[] registroOP = null;
			Object registroAuxOP = (Object) reg;
			registroOP = (Object[]) registroAuxOP;
			
			regOP.nrOp = (String) registroOP[_nrop];
			regOP.nrOpExibicao = (String) registroOP[_nropexibicao];
			regOP.nrPlano = (String) registroOP[_nrplano];
			regOP.cdCliente = (String) registroOP[_cdcliente];
			regOP.dsCliente = (String) registroOP[_dscliente];
			regOP.cdMaquina = (String) registroOP[_cdinjetora];
			regOP.cdMaqEstendido = (String) registroOP[_cdinjestendido];
			regOP.cdIdentificMaq = (String) registroOP[_cdientific];
			regOP.tpSessaoProd = (String) registroOP[_tpabertsessaoprod];
			regOP.cdMolde = (String) registroOP[_cdmolde];
			regOP.cdMolEstendido = (String) registroOP[_cdmolestendido];
			regOP.cdEstrutura = (String) registroOP[_cdestrutura];
			
			
			if (registroOP[_statusop] instanceof Character) {
				regOP.statusOP = ((Character) registroOP[_statusop]).toString();
			}

			if (registroOP[_statusop] instanceof String) { // situacao observada em bancos oracle
				regOP.statusOP = ((String) registroOP[_statusop]).toString();
			}			
			
			
			regOP.dtHrIniPrev = registroOP[_dthriprevista] != null ? (Date) registroOP[_dthriprevista] : null;
			regOP.dtHrFimPrev = registroOP[_dthrfprevista] != null ? (Date) registroOP[_dthrfprevista] : null;
			regOP.dtHrIniReal = registroOP[_dthrinireal] != null ? (Date) registroOP[_dthrinireal] : null;
			regOP.dtHrFimReal = registroOP[_dthrfimreal] != null ? (Date) registroOP[_dthrfimreal] : null;
			regOP.cdProduto = (String) registroOP[_cdproduto];
			regOP.dsProduto = (String) registroOP[_dsproduto];
			regOP.pBrutoMedio = ConversaoTipos.converterParaBigDecimal(registroOP[_pbrutomedio]);
			regOP.pLiquidoMedio = ConversaoTipos.converterParaBigDecimal(registroOP[_pliquidomedio]);

			//regOP.idReduzidoProduto = (String) registroOP[_idreduzidoproduto];
			regOP.qtProduzir  = ConversaoTipos.converterParaBigDecimal(registroOP[_qtproduzir]);
			//regOP.fatorContagemProd  = ConversaoTipos.converterParaBigDecimal(registroOP[_fatorcontagemprod]);
			regOP.cicloPadrao  = ConversaoTipos.converterParaBigDecimal(registroOP[_ciclopadrao]);
			regOP.cicloVarMin = ConversaoTipos.converterParaBigDecimal(registroOP[_ciclovarmin]);
			regOP.cicloVarMax = ConversaoTipos.converterParaBigDecimal(registroOP[_ciclovarmax]);
			regOP.qtPcsCicloAtivas = ConversaoTipos.converterParaBigDecimal(registroOP[_qtpcscicloativas]);
			regOP.qtPcscicloTotais = ConversaoTipos.converterParaBigDecimal(registroOP[_qtpcsciclostotais]);
			
			PpCp ppCp = new PpCp();
			ppCp.setIdCp(ConversaoTipos.converterParaBigDecimal(ConversaoTipos.converteStringParaSequenciaNumericaUniCode(regOP.nrOp)).longValue());
			ppCp.setCdCp(regOP.nrOp);
			ppCp.setDthrInicio(regOP.dtHrIniPrev);
			ppCp.setDthrFinal(regOP.dtHrFimPrev);
			ppCp.setDthrInicioreal(regOP.dtHrIniReal);
			ppCp.setDthrFinalreal(regOP.dtHrFimReal);
			ppCp.setStCp(ConversaoTipos.converteParaInt(regOP.statusOP));
			
			//produto
			OmProduto produto = new OmProduto();
			produto.setCdProduto(regOP.cdProduto);
			produto.setDsProduto(regOP.dsProduto);
			produto.setGPesoBruto(regOP.pBrutoMedio);
			produto.setGPesoLiquido(regOP.pLiquidoMedio);
			
			//pt
			DAOGenerico daoVF = new DAOGenerico();
			daoVF.iniciaSessao();
			OmPtDAO ptDao = new OmPtDAO(daoVF.getSession());
			ppCp.setOmPt(ptDao.getOmPtAtivoComUltimaRevisaoInjet(dao, regOP.cdMaqEstendido));
			daoVF.finalizaSessao();
			
			//folha
			ppCp.setDwFolha(new DwFolha());
			ppCp.getDwFolha().setDwFolharaps(new HashSet<DwFolharap>());
			
			if (regOP.cdMolde.substring(0, 1).equals("|")) {
				ppCp.getDwFolha().setIdFolha(ConversaoTipos.converteParaBigDecimal(regOP.cdMolde.substring(1, 5)).longValue());
			} else {
				ppCp.getDwFolha().setIdFolha(ConversaoTipos.converteParaBigDecimal(regOP.cdMolde).longValue());
			}	
			ppCp.getDwFolha().setCdFolha(regOP.cdMolEstendido + "/" + regOP.cdEstrutura);
			ppCp.getDwFolha().setDsFolha(regOP.cdMolEstendido);
			ppCp.getDwFolha().setSegCiclopadrao(regOP.cicloPadrao);
			ppCp.getDwFolha().setSegCiclominimo(regOP.cicloVarMin);
			ppCp.getDwFolha().setSegCiclotimeout(regOP.cicloVarMax);
			
			//cliente
			ppCp.setPpCliente(new PpCliente());
			ppCp.getPpCliente().setIdCliente(ConversaoTipos.converteParaBigDecimal(regOP.cdCliente).longValue());
			ppCp.getPpCliente().setCdCliente(regOP.cdCliente);
			ppCp.getPpCliente().setNmCliente(regOP.dsCliente);
			
			DwFolharap folhaRap = new DwFolharap();
			folhaRap.setDwFolharapcoms(new HashSet<DwFolharapcom>());
			
			DwRap rap = new DwRap();
			rap.setCdRap(ppCp.getDwFolha().getCdFolha());
			rap.setDsRap(rap.getCdRap());			
			folhaRap.setDwRap(rap);
			
			DwFolharapcom rapCom = new DwFolharapcom();
			rapCom.setOmProduto(produto);
			rapCom.setQtAtiva(regOP.qtPcsCicloAtivas);
			rapCom.setQtTotal(regOP.qtPcscicloTotais);
			rapCom.setIdredzproduto((byte) 1);
			
			folhaRap.getDwFolharapcoms().add(rapCom);			

			if (mapPpCp.containsKey(regOP.nrOp) == false) {
				if (mapPpCp.size() == MAX_RETORNO) {
					break;
				}
								
				ppCp.getDwFolha().getDwFolharaps().add(folhaRap);
				
				//produto OP
				Set<PpCpproduto> listaProdutos = new HashSet<PpCpproduto>();
				PpCpproduto ppcpProduto = new PpCpproduto();

				ppcpProduto.setOmProduto(produto);
				ppcpProduto.setNrDoc(regOP.nrOpExibicao);
				ppcpProduto.setPcsProducaoplanejada(regOP.qtProduzir);
				listaProdutos.add(ppcpProduto);
				
				ppCp.setPpCpprodutos(listaProdutos);	
				
				mapPpCp.put(regOP.nrOp, ppCp);
				
			} else {
				//produto OP
				ppCp = mapPpCp.get(regOP.nrOp);
				mapPpCp.remove(regOP.nrOp);
						
				PpCpproduto ppcpProduto = new PpCpproduto();
				ppcpProduto.setOmProduto(produto);
				ppcpProduto.setNrDoc(regOP.nrOpExibicao);
				ppcpProduto.setPcsProducaoplanejada(regOP.qtProduzir);
				ppCp.getPpCpprodutos().add(ppcpProduto);		
				
				rapCom.setIdredzproduto((byte) ppCp.getPpCpprodutos().size());
				
				ppCp.getDwFolha().getDwFolharaps().iterator().next().getDwFolharapcoms().add(rapCom);
				
				mapPpCp.put(regOP.nrOp, ppCp);
			}
		}
	
		retorno.addAll(mapPpCp.values());
		
		return retorno;
	}
	
	public List<PpCp> pesquisarPpCpByCdPtInjet(DAOGenericoInjet dao, Date dtTurno, DwTurno dwturno, OmPt ompt) {
		List<PpCp> retorno = new ArrayList<>();

		byte _nrop = 0;
		byte _nropexibicao = 1;
		byte _nrplano = 2;
		byte _cdcliente = 3;
		byte _dscliente = 4;
		byte _cdinjetora = 5;
		byte _cdinjestendido = 6;
		byte _cdientific = 7;
		byte _tpabertsessaoprod = 8;
		byte _cdmolde = 9;
		byte _cdmolestendido = 10;
		byte _cdestrutura = 11;
		byte _statusop = 12;
		byte _dthriprevista = 13;
		byte _dthrfprevista = 14;
		byte _dtHrIRealIjOP = 15;
		byte _dthrinireal = 16;
		byte _dthrfimreal = 17;
		byte _cdproduto = 18;
		byte _dsproduto = 19;
		byte _pbrutomedio = 20;
		byte _pliquidomedio = 21;
		byte _qtproduzir = 22;
		byte _fatorcontagemprod = 23;
		byte _ciclopadrao = 24;
		byte _ciclovarmin = 25;
		byte _ciclovarmax = 26;
		byte _idreduzidoproduto = 27;
		byte _qtpcscicloativas = 28;
		byte _qtpcsciclostotais = 29;
		
		class RegistroLido {
			String nrOp;
			String nrOpExibicao;
			String nrPlano;
			String cdCliente;
			String dsCliente;
			String cdMaquina;
			String cdMaqEstendido;
			String cdIdentificMaq;
			String tpSessaoProd;
			String cdMolde;
			String cdMolEstendido;
			String cdEstrutura;
			String statusOP;
			Date dtHrIniPrev;
			Date dtHrFimPrev;
			Date dtHrIRealIjOP;
			Date dtHrIniReal;
			Date dtHrFimReal;
			String cdProduto;
			String dsProduto;
			BigDecimal pBrutoMedio = BigDecimal.ZERO;
			BigDecimal pLiquidoMedio = BigDecimal.ZERO;
			BigDecimal qtProduzir = BigDecimal.ZERO;
			//BigDecimal fatorContagemProd = BigDecimal.ZERO;
			BigDecimal cicloPadrao = BigDecimal.ZERO;
			BigDecimal cicloVarMin = BigDecimal.ZERO;
			BigDecimal cicloVarMax = BigDecimal.ZERO;
			//String idReduzidoProduto;
			BigDecimal qtPcsCicloAtivas = BigDecimal.ZERO;
			BigDecimal qtPcscicloTotais = BigDecimal.ZERO;
			
		}
		
		Map<String, PpCp> mapPpCp = new HashMap<String, PpCp>();
		
		String strSQL = "";
		
		strSQL = strSQL.concat("SELECT DISTINCT a.nrop, b.nropexibicao, a.nrplano, d.cdcliente, e.dscliente,");
		strSQL = strSQL.concat("       a.cdinjetora, f.cdinjestendido, f.cdidentific, f.TpAbertSessaoProd,");
		strSQL = strSQL.concat("       a.cdmolde, g.cdmolestendido, a.cdestrutura,");
		strSQL = strSQL.concat("       a.stop, a.dthriprevista, a.DtHrFPrevista, a.dthrireal, h.dthrini, h.dthrfim,");
		strSQL = strSQL.concat("       i.cdproduto, j.dsproduto, j.pbrutomedio, j.pliquidomedio, i.qtpecasproduzir,");
		strSQL = strSQL.concat("       l.fatorcontagemprod, l.ciclopadrao, l.VarMin, l.VarMax,");
		strSQL = strSQL.concat("       m.cdidentificacao, m.qtcavativas, m.qtcavidades");
		
		strSQL = strSQL.concat("  FROM ijop a ");
		strSQL = strSQL.concat("  JOIN ijcnsturno tr ON (tr.nrop = a.nrop) ");
		strSQL = strSQL.concat("  JOIN ijoproteiro b ON (b.nrop = a.nrop) ");
		strSQL = strSQL.concat("  JOIN ijplano c ON (c.nrplano = a.nrplano) ");
		strSQL = strSQL.concat("  JOIN ijcarteira d ON (d.nrcarteira = c.nrcarteira)");
		strSQL = strSQL.concat("  JOIN ijtbcli e ON (e.cdcliente = d.cdcliente)");
		strSQL = strSQL.concat("  JOIN ijtbinj f ON (f.cdinjetora = a.cdinjetora)");
		strSQL = strSQL.concat("  JOIN ijtbmol g ON (g.cdmolde = a.cdmolde)");
		strSQL = strSQL.concat("  JOIN ijopprodutos i ON (i.nrop = a.nrop AND i.cdmolde = a.cdmolde AND i.cdestrutura = i.cdestrutura)");
		strSQL = strSQL.concat("  JOIN ijtbpro j ON (j.cdproduto = i.cdproduto)");
		strSQL = strSQL.concat("  JOIN ijfictec l ON (l.cdinjetora = a.cdinjetora AND l.cdmolde = a.cdmolde AND l.cdestrutura = a.cdestrutura AND l.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat("  JOIN ijmolpro m ON (m.cdmolde = l.cdmolde AND m.cdestrutura = l.cdestrutura AND m.dthrival = l.dthrivalestru)");
		strSQL = strSQL.concat("  LEFT JOIN (SELECT nrop, MIN(DtHrEntrada) as dthrini, MAX(DtHrSaida) as dthrfim FROM IJentsaiOPMAQ GROUP BY nrop) h ON (h.nrop = a.nrop)");

		strSQL = strSQL.concat(" WHERE a.nrop = a.nrop ");
		
		if (dtTurno != null) {
			strSQL = strSQL.concat("   AND tr.dtturno = :dtref ");
		}
		
		if (dwturno != null) {
			strSQL = strSQL.concat("   AND tr.cdturno = :cdturno ");
		}

		if (ompt != null) {
			strSQL = strSQL.concat("   AND f.cdinjestendido = :cdinjetora ");
		}
		
		strSQL = strSQL.concat(" ORDER BY a.dthrireal");
		
		SQLQuery query = dao.getSession().createSQLQuery(strSQL);
		
		if (dtTurno != null) {
			query.setTimestamp("dtref", dtTurno);
		}
		
		if (dwturno != null) {
			query.setString("cdturno", FuncoesApoioInjet.getStrZero(dwturno.getIdTurno(),6));
		}

		if (ompt != null) {
			query.setString("cdinjetora", ompt.getCdPt());
		}

		
		List<Object> lista = query.list();
		
		for (Object reg : lista) {
			RegistroLido regOP = new RegistroLido();
			
			Object[] registroOP = null;
			Object registroAuxOP = (Object) reg;
			registroOP = (Object[]) registroAuxOP;
			
			regOP.nrOp = (String) registroOP[_nrop];
			regOP.nrOpExibicao = (String) registroOP[_nropexibicao];
			regOP.nrPlano = (String) registroOP[_nrplano];
			regOP.cdCliente = (String) registroOP[_cdcliente];
			regOP.dsCliente = (String) registroOP[_dscliente];
			regOP.cdMaquina = (String) registroOP[_cdinjetora];
			regOP.cdMaqEstendido = (String) registroOP[_cdinjestendido];
			regOP.cdIdentificMaq = (String) registroOP[_cdientific];
			regOP.tpSessaoProd = (String) registroOP[_tpabertsessaoprod];
			regOP.cdMolde = (String) registroOP[_cdmolde];
			regOP.cdMolEstendido = (String) registroOP[_cdmolestendido];
			regOP.cdEstrutura = (String) registroOP[_cdestrutura];
			
			// diferenca de tipo entre oracle e sql server
			if (registroOP[_statusop] instanceof Character) {
				regOP.statusOP = ((Character) registroOP[_statusop]).toString();
			} else {
				regOP.statusOP = ((String) registroOP[_statusop]);
			}
			
			regOP.dtHrIniPrev = registroOP[_dthriprevista] != null ? (Date) registroOP[_dthriprevista] : null;
			regOP.dtHrFimPrev = registroOP[_dthrfprevista] != null ? (Date) registroOP[_dthrfprevista] : null;
			regOP.dtHrIRealIjOP = registroOP[_dthrinireal] != null ? (Date) registroOP[_dtHrIRealIjOP] : null;
			regOP.dtHrIniReal = registroOP[_dthrinireal] != null ? (Date) registroOP[_dthrinireal] : null;
			regOP.dtHrFimReal = registroOP[_dthrfimreal] != null ? (Date) registroOP[_dthrfimreal] : null;
			regOP.cdProduto = (String) registroOP[_cdproduto];
			regOP.dsProduto = (String) registroOP[_dsproduto];
			regOP.pBrutoMedio = ConversaoTipos.converterParaBigDecimal(registroOP[_pbrutomedio]);
			regOP.pLiquidoMedio = ConversaoTipos.converterParaBigDecimal(registroOP[_pliquidomedio]);

			//regOP.idReduzidoProduto = (String) registroOP[_idreduzidoproduto];
			regOP.qtProduzir  = ConversaoTipos.converterParaBigDecimal(registroOP[_qtproduzir]);
			//regOP.fatorContagemProd  = ConversaoTipos.converterParaBigDecimal(registroOP[_fatorcontagemprod]);
			regOP.cicloPadrao  = ConversaoTipos.converterParaBigDecimal(registroOP[_ciclopadrao]);
			regOP.cicloVarMin = ConversaoTipos.converterParaBigDecimal(registroOP[_ciclovarmin]);
			regOP.cicloVarMax = ConversaoTipos.converterParaBigDecimal(registroOP[_ciclovarmax]);
			regOP.qtPcsCicloAtivas = ConversaoTipos.converterParaBigDecimal(registroOP[_qtpcscicloativas]);
			regOP.qtPcscicloTotais = ConversaoTipos.converterParaBigDecimal(registroOP[_qtpcsciclostotais]);
			
			PpCp ppCp = new PpCp();
			ppCp.setCdCp(regOP.nrOp);
			ppCp.setDthrInicio(regOP.dtHrIniPrev);
			ppCp.setDthrFinal(regOP.dtHrFimPrev);
			ppCp.setDthrInicioreal(regOP.dtHrIniReal);
			ppCp.setDthrFinalreal(regOP.dtHrFimReal);
			ppCp.setStCp(ConversaoTipos.converteParaInt(regOP.statusOP));
			
			//produto
			OmProduto produto = new OmProduto();
			produto.setCdProduto(regOP.cdProduto);
			produto.setDsProduto(regOP.dsProduto);
			produto.setGPesoBruto(regOP.pBrutoMedio);
			produto.setGPesoLiquido(regOP.pLiquidoMedio);
			
			//pt
			DAOGenerico daoVF = new DAOGenerico();
			daoVF.iniciaSessao();
			OmPtDAO ptDao = new OmPtDAO(daoVF.getSession());
			ppCp.setOmPt(ptDao.getOmPtAtivoComUltimaRevisaoInjet(dao, regOP.cdMaqEstendido));
			
			//folha
			ppCp.setDwFolha(new DwFolha());
			ppCp.getDwFolha().setDwFolharaps(new HashSet<DwFolharap>());
			
			if (regOP.cdMolde.substring(0, 1).equals("|")) {
				ppCp.getDwFolha().setIdFolha(ConversaoTipos.converteParaBigDecimal(regOP.cdMolde.substring(1, 5)).longValue());
			} else {
				ppCp.getDwFolha().setIdFolha(ConversaoTipos.converteParaBigDecimal(regOP.cdMolde).longValue());
			}	
			ppCp.getDwFolha().setCdFolha(regOP.cdMolEstendido + "/" + regOP.cdEstrutura);
			ppCp.getDwFolha().setDsFolha(regOP.cdMolEstendido);
			ppCp.getDwFolha().setSegCiclopadrao(regOP.cicloPadrao);
			ppCp.getDwFolha().setSegCiclominimo(regOP.cicloVarMin);
			ppCp.getDwFolha().setSegCiclotimeout(regOP.cicloVarMax);
			
			//cliente
			ppCp.setPpCliente(new PpCliente());
			ppCp.getPpCliente().setIdCliente(ConversaoTipos.converteParaBigDecimal(regOP.cdCliente).longValue());
			ppCp.getPpCliente().setCdCliente(regOP.cdCliente);
			ppCp.getPpCliente().setNmCliente(regOP.dsCliente);
			
			DwFolharap folhaRap = new DwFolharap();
			folhaRap.setDwFolharapcoms(new HashSet<DwFolharapcom>());
			
			DwRap rap = new DwRap();
			rap.setCdRap(ppCp.getDwFolha().getCdFolha());
			rap.setDsRap(rap.getCdRap());			
			folhaRap.setDwRap(rap);
			
			DwFolharapcom rapCom = new DwFolharapcom();
			rapCom.setOmProduto(produto);
			rapCom.setQtAtiva(regOP.qtPcsCicloAtivas);
			rapCom.setQtTotal(regOP.qtPcscicloTotais);
			rapCom.setIdredzproduto((byte) 1);
			
			folhaRap.getDwFolharapcoms().add(rapCom);			

			if (mapPpCp.containsKey(regOP.nrOp) == false) {
								
				ppCp.getDwFolha().getDwFolharaps().add(folhaRap);
				
				//produto OP
				Set<PpCpproduto> listaProdutos = new HashSet<PpCpproduto>();
				PpCpproduto ppcpProduto = new PpCpproduto();

				ppcpProduto.setOmProduto(produto);
				ppcpProduto.setNrDoc(regOP.nrOpExibicao);
				ppcpProduto.setPcsProducaoplanejada(regOP.qtProduzir);
				listaProdutos.add(ppcpProduto);
				
				ppCp.setPpCpprodutos(listaProdutos);	
				
				mapPpCp.put(regOP.nrOp, ppCp);
				
			} else {
				ppCp = mapPpCp.get(regOP.nrOp);
				mapPpCp.remove(regOP.nrOp);
				
				//produto OP
				PpCpproduto ppcpProduto = new PpCpproduto();
				ppcpProduto.setOmProduto(produto);
				ppcpProduto.setNrDoc(regOP.nrOpExibicao);
				ppcpProduto.setPcsProducaoplanejada(regOP.qtProduzir);
				ppCp.getPpCpprodutos().add(ppcpProduto);		
				
				rapCom.setIdredzproduto((byte) ppCp.getPpCpprodutos().size());
				
				ppCp.getDwFolha().getDwFolharaps().iterator().next().getDwFolharapcoms().add(rapCom);
				
				mapPpCp.put(regOP.nrOp, ppCp);
			}
		}
	
		retorno.addAll(mapPpCp.values());
		
		return retorno;
	}	

	public List<PpCp> pesquisarPpCpByCdPtInjet(DAOGenericoInjet dao, Date dthrIniUT, Date dthrFimUT, OmPt ompt) {
		List<PpCp> retorno = new ArrayList<>();

		byte _nrop = 0;
		byte _nropexibicao = 1;
		byte _nrplano = 2;
		byte _cdcliente = 3;
		byte _dscliente = 4;
		byte _cdinjetora = 5;
		byte _cdinjestendido = 6;
		byte _cdientific = 7;
		byte _tpabertsessaoprod = 8;
		byte _cdmolde = 9;
		byte _cdmolestendido = 10;
		byte _cdestrutura = 11;
		byte _statusop = 12;
		byte _dthriprevista = 13;
		byte _dthrfprevista = 14;
		byte _dtHrIRealIjOP = 15;
		byte _dthrinireal = 16;
		byte _dthrfimreal = 17;
		byte _cdproduto = 18;
		byte _dsproduto = 19;
		byte _pbrutomedio = 20;
		byte _pliquidomedio = 21;
		byte _qtproduzir = 22;
		byte _fatorcontagemprod = 23;
		byte _ciclopadrao = 24;
		byte _ciclovarmin = 25;
		byte _ciclovarmax = 26;
		byte _idreduzidoproduto = 27;
		byte _qtpcscicloativas = 28;
		byte _qtpcsciclostotais = 29;
		
		class RegistroLido {
			String nrOp;
			String nrOpExibicao;
			String nrPlano;
			String cdCliente;
			String dsCliente;
			String cdMaquina;
			String cdMaqEstendido;
			String cdIdentificMaq;
			String tpSessaoProd;
			String cdMolde;
			String cdMolEstendido;
			String cdEstrutura;
			String statusOP;
			Date dtHrIniPrev;
			Date dtHrFimPrev;
			Date dtHrIRealIjOP;
			Date dtHrIniReal;
			Date dtHrFimReal;
			String cdProduto;
			String dsProduto;
			BigDecimal pBrutoMedio = BigDecimal.ZERO;
			BigDecimal pLiquidoMedio = BigDecimal.ZERO;
			BigDecimal qtProduzir = BigDecimal.ZERO;
			//BigDecimal fatorContagemProd = BigDecimal.ZERO;
			BigDecimal cicloPadrao = BigDecimal.ZERO;
			BigDecimal cicloVarMin = BigDecimal.ZERO;
			BigDecimal cicloVarMax = BigDecimal.ZERO;
			//String idReduzidoProduto;
			BigDecimal qtPcsCicloAtivas = BigDecimal.ZERO;
			BigDecimal qtPcscicloTotais = BigDecimal.ZERO;
			
		}
		
		Map<String, PpCp> mapPpCp = new HashMap<String, PpCp>();
		
		String strSQL = "";
		
		strSQL = strSQL.concat("SELECT DISTINCT a.nrop, b.nropexibicao, a.nrplano, d.cdcliente, e.dscliente,");
		strSQL = strSQL.concat("       a.cdinjetora, f.cdinjestendido, f.cdidentific, f.TpAbertSessaoProd,");
		strSQL = strSQL.concat("       a.cdmolde, g.cdmolestendido, a.cdestrutura,");
		strSQL = strSQL.concat("       a.stop, a.dthriprevista, a.DtHrFPrevista, a.dthrireal, h.dthrini, h.dthrfim,");
		strSQL = strSQL.concat("       i.cdproduto, j.dsproduto, j.pbrutomedio, j.pliquidomedio, i.qtpecasproduzir,");
		strSQL = strSQL.concat("       l.fatorcontagemprod, l.ciclopadrao, l.VarMin, l.VarMax,");
		strSQL = strSQL.concat("       m.cdidentificacao, m.qtcavativas, m.qtcavidades");
		
		strSQL = strSQL.concat("  FROM ijop a ");
		strSQL = strSQL.concat("  JOIN ijcnsUT tr ON (tr.nrop = a.nrop) ");
		strSQL = strSQL.concat("  JOIN ijoproteiro b ON (b.nrop = a.nrop) ");
		strSQL = strSQL.concat("  JOIN ijplano c ON (c.nrplano = a.nrplano) ");
		strSQL = strSQL.concat("  JOIN ijcarteira d ON (d.nrcarteira = c.nrcarteira)");
		strSQL = strSQL.concat("  JOIN ijtbcli e ON (e.cdcliente = d.cdcliente)");
		strSQL = strSQL.concat("  JOIN ijtbinj f ON (f.cdinjetora = a.cdinjetora)");
		strSQL = strSQL.concat("  JOIN ijtbmol g ON (g.cdmolde = a.cdmolde)");
		strSQL = strSQL.concat("  JOIN ijopprodutos i ON (i.nrop = a.nrop AND i.cdmolde = a.cdmolde AND i.cdestrutura = i.cdestrutura)");
		strSQL = strSQL.concat("  JOIN ijtbpro j ON (j.cdproduto = i.cdproduto)");
		strSQL = strSQL.concat("  JOIN ijfictec l ON (l.cdinjetora = a.cdinjetora AND l.cdmolde = a.cdmolde AND l.cdestrutura = a.cdestrutura AND l.dthrfvalcic IS NULL) ");
		strSQL = strSQL.concat("  JOIN ijmolpro m ON (m.cdmolde = l.cdmolde AND m.cdestrutura = l.cdestrutura AND m.dthrival = l.dthrivalestru)");
		strSQL = strSQL.concat("  LEFT JOIN (SELECT nrop, MIN(DtHrEntrada) as dthrini, MAX(DtHrSaida) as dthrfim FROM IJentsaiOPMAQ GROUP BY nrop) h ON (h.nrop = a.nrop)");

		strSQL = strSQL.concat(" WHERE a.nrop = a.nrop ");
		
		if (dthrIniUT != null && dthrFimUT != null) {
			strSQL = strSQL.concat("   AND tr.dthriniintervalo BETWEEN :dthrIni AND :dthrFim");
		}
		
		if (ompt != null) {
			strSQL = strSQL.concat("   AND f.cdinjestendido = :cdinjetora ");
		}
		
		strSQL = strSQL.concat(" ORDER BY a.dthrireal");
		
		SQLQuery query = dao.getSession().createSQLQuery(strSQL);
		
		if (dthrIniUT != null && dthrFimUT != null) {
			query.setTimestamp("dthrIni", dthrIniUT);
			query.setTimestamp("dthrFim", dthrFimUT);
		}
		

		if (ompt != null) {
			query.setString("cdinjetora", ompt.getCdPt());
		}

		
		List<Object> lista = query.list();
		
		for (Object reg : lista) {
			RegistroLido regOP = new RegistroLido();
			
			Object[] registroOP = null;
			Object registroAuxOP = (Object) reg;
			registroOP = (Object[]) registroAuxOP;
			
			regOP.nrOp = (String) registroOP[_nrop];
			regOP.nrOpExibicao = (String) registroOP[_nropexibicao];
			regOP.nrPlano = (String) registroOP[_nrplano];
			regOP.cdCliente = (String) registroOP[_cdcliente];
			regOP.dsCliente = (String) registroOP[_dscliente];
			regOP.cdMaquina = (String) registroOP[_cdinjetora];
			regOP.cdMaqEstendido = (String) registroOP[_cdinjestendido];
			regOP.cdIdentificMaq = (String) registroOP[_cdientific];
			regOP.tpSessaoProd = (String) registroOP[_tpabertsessaoprod];
			regOP.cdMolde = (String) registroOP[_cdmolde];
			regOP.cdMolEstendido = (String) registroOP[_cdmolestendido];
			regOP.cdEstrutura = (String) registroOP[_cdestrutura];
			
			// diferenca de tipo entre oracle e sql server
			if (registroOP[_statusop] instanceof Character) {
				regOP.statusOP = ((Character) registroOP[_statusop]).toString();
			} else {
				regOP.statusOP = ((String) registroOP[_statusop]);
			}
			
			regOP.dtHrIniPrev = registroOP[_dthriprevista] != null ? (Date) registroOP[_dthriprevista] : null;
			regOP.dtHrFimPrev = registroOP[_dthrfprevista] != null ? (Date) registroOP[_dthrfprevista] : null;
			regOP.dtHrIRealIjOP = registroOP[_dthrinireal] != null ? (Date) registroOP[_dtHrIRealIjOP] : null;
			regOP.dtHrIniReal = registroOP[_dthrinireal] != null ? (Date) registroOP[_dthrinireal] : null;
			regOP.dtHrFimReal = registroOP[_dthrfimreal] != null ? (Date) registroOP[_dthrfimreal] : null;
			regOP.cdProduto = (String) registroOP[_cdproduto];
			regOP.dsProduto = (String) registroOP[_dsproduto];
			regOP.pBrutoMedio = ConversaoTipos.converterParaBigDecimal(registroOP[_pbrutomedio]);
			regOP.pLiquidoMedio = ConversaoTipos.converterParaBigDecimal(registroOP[_pliquidomedio]);

			//regOP.idReduzidoProduto = (String) registroOP[_idreduzidoproduto];
			regOP.qtProduzir  = ConversaoTipos.converterParaBigDecimal(registroOP[_qtproduzir]);
			//regOP.fatorContagemProd  = ConversaoTipos.converterParaBigDecimal(registroOP[_fatorcontagemprod]);
			regOP.cicloPadrao  = ConversaoTipos.converterParaBigDecimal(registroOP[_ciclopadrao]);
			regOP.cicloVarMin = ConversaoTipos.converterParaBigDecimal(registroOP[_ciclovarmin]);
			regOP.cicloVarMax = ConversaoTipos.converterParaBigDecimal(registroOP[_ciclovarmax]);
			regOP.qtPcsCicloAtivas = ConversaoTipos.converterParaBigDecimal(registroOP[_qtpcscicloativas]);
			regOP.qtPcscicloTotais = ConversaoTipos.converterParaBigDecimal(registroOP[_qtpcsciclostotais]);
			
			PpCp ppCp = new PpCp();
			ppCp.setCdCp(regOP.nrOp);
			ppCp.setDthrInicio(regOP.dtHrIniPrev);
			ppCp.setDthrFinal(regOP.dtHrFimPrev);
			ppCp.setDthrInicioreal(regOP.dtHrIniReal);
			ppCp.setDthrFinalreal(regOP.dtHrFimReal);
			ppCp.setStCp(ConversaoTipos.converteParaInt(regOP.statusOP));
			
			//produto
			OmProduto produto = new OmProduto();
			produto.setCdProduto(regOP.cdProduto);
			produto.setDsProduto(regOP.dsProduto);
			produto.setGPesoBruto(regOP.pBrutoMedio);
			produto.setGPesoLiquido(regOP.pLiquidoMedio);
			
			//pt
			DAOGenerico daoVF = new DAOGenerico();
			daoVF.iniciaSessao();
			OmPtDAO ptDao = new OmPtDAO(daoVF.getSession());
			ppCp.setOmPt(ptDao.getOmPtAtivoComUltimaRevisaoInjet(dao, regOP.cdMaqEstendido));
			
			//folha
			ppCp.setDwFolha(new DwFolha());
			ppCp.getDwFolha().setDwFolharaps(new HashSet<DwFolharap>());
			
			if (regOP.cdMolde.substring(0, 1).equals("|")) {
				ppCp.getDwFolha().setIdFolha(ConversaoTipos.converteParaBigDecimal(regOP.cdMolde.substring(1, 5)).longValue());
			} else {
				ppCp.getDwFolha().setIdFolha(ConversaoTipos.converteParaBigDecimal(regOP.cdMolde).longValue());
			}	
			ppCp.getDwFolha().setCdFolha(regOP.cdMolEstendido + "/" + regOP.cdEstrutura);
			ppCp.getDwFolha().setDsFolha(regOP.cdMolEstendido);
			ppCp.getDwFolha().setSegCiclopadrao(regOP.cicloPadrao);
			ppCp.getDwFolha().setSegCiclominimo(regOP.cicloVarMin);
			ppCp.getDwFolha().setSegCiclotimeout(regOP.cicloVarMax);
			
			//cliente
			ppCp.setPpCliente(new PpCliente());
			ppCp.getPpCliente().setIdCliente(ConversaoTipos.converteParaBigDecimal(regOP.cdCliente).longValue());
			ppCp.getPpCliente().setCdCliente(regOP.cdCliente);
			ppCp.getPpCliente().setNmCliente(regOP.dsCliente);
			
			DwFolharap folhaRap = new DwFolharap();
			folhaRap.setDwFolharapcoms(new HashSet<DwFolharapcom>());
			
			DwRap rap = new DwRap();
			rap.setCdRap(ppCp.getDwFolha().getCdFolha());
			rap.setDsRap(rap.getCdRap());			
			folhaRap.setDwRap(rap);
			
			DwFolharapcom rapCom = new DwFolharapcom();
			rapCom.setOmProduto(produto);
			rapCom.setQtAtiva(regOP.qtPcsCicloAtivas);
			rapCom.setQtTotal(regOP.qtPcscicloTotais);
			rapCom.setIdredzproduto((byte) 1);
			
			folhaRap.getDwFolharapcoms().add(rapCom);			

			if (mapPpCp.containsKey(regOP.nrOp) == false) {
								
				ppCp.getDwFolha().getDwFolharaps().add(folhaRap);
				
				//produto OP
				Set<PpCpproduto> listaProdutos = new HashSet<PpCpproduto>();
				PpCpproduto ppcpProduto = new PpCpproduto();

				ppcpProduto.setOmProduto(produto);
				ppcpProduto.setNrDoc(regOP.nrOpExibicao);
				ppcpProduto.setPcsProducaoplanejada(regOP.qtProduzir);
				listaProdutos.add(ppcpProduto);
				
				ppCp.setPpCpprodutos(listaProdutos);	
				
				mapPpCp.put(regOP.nrOp, ppCp);
				
			} else {
				ppCp = mapPpCp.get(regOP.nrOp);
				mapPpCp.remove(regOP.nrOp);
				
				//produto OP
				PpCpproduto ppcpProduto = new PpCpproduto();
				ppcpProduto.setOmProduto(produto);
				ppcpProduto.setNrDoc(regOP.nrOpExibicao);
				ppcpProduto.setPcsProducaoplanejada(regOP.qtProduzir);
				ppCp.getPpCpprodutos().add(ppcpProduto);		
				
				rapCom.setIdredzproduto((byte) ppCp.getPpCpprodutos().size());
				
				ppCp.getDwFolha().getDwFolharaps().iterator().next().getDwFolharapcoms().add(rapCom);
				
				mapPpCp.put(regOP.nrOp, ppCp);
			}
		}
	
		retorno.addAll(mapPpCp.values());
		
		return retorno;
	}	

	@SuppressWarnings("unchecked")
	public String getUltimaOP(DAOGenericoInjet dao, List<DwConsolid> listaDwConsolid) {
		Date dthrUltimaOP = null;
		Date dthrOP = null;
		
		String retorno = "";
		
		String strSQL = "";		
		strSQL = strSQL.concat("SELECT a.DtHrEntrada ");
		strSQL = strSQL.concat("  FROM IJentsaiOPMAQ a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE b.cdinjestendido = :cdmaquina ");
		strSQL = strSQL.concat("   AND a.nrop = :nrop ");
		strSQL = strSQL.concat("   AND (" );
		strSQL = strSQL.concat("           (a.DtHrEntrada BETWEEN :dthrini AND :dthrfim)   ");
		strSQL = strSQL.concat("        OR (a.DtHrSaida   BETWEEN :dthrini AND :dthrfim) ");
		strSQL = strSQL.concat("        OR (:dthrini      BETWEEN a.DtHrEntrada AND a.DtHrSaida) ");
		strSQL = strSQL.concat("        OR (:dthrini >= a.DtHrEntrada AND a.DtHrSaida IS NULL) ");
		strSQL = strSQL.concat("       )");
		strSQL = strSQL.concat(" ORDER BY a.DtHrEntrada DESC");
		
		for (DwConsolid id : listaDwConsolid) {
			SQLQuery query = dao.getSession().createSQLQuery(strSQL);
			
			query.setString("cdmaquina", id.getOmPt().getCdPt())
				 .setString("nrop", id.getPpCp().getCdCp())
				 .setTimestamp("dthrini", id.getDthrIturno())
				 .setTimestamp("dthrfim", id.getDthrFturno())
				 .list();
			
			List<Object> lista = query.list();
			if (lista != null && lista.size() > 0) {
				Object reg = lista.get(0);
				dthrOP = (Date) reg;
				
				if (dthrUltimaOP == null) {
					dthrUltimaOP = dthrOP;
					retorno = id.getPpCp().getCdCp();
				} else {
					if (dthrOP.after(dthrUltimaOP)) {
						dthrUltimaOP = dthrOP;
						retorno = id.getPpCp().getCdCp();						
					}
				}
			}
		}
		return retorno;
	}	
	
	@SuppressWarnings("unchecked")
	public String getNrOpExibicao(DAOGenericoInjet dao, String cdCp) {
		String retorno = "";
		
		String strSQL = "";		
		strSQL = strSQL.concat("SELECT a.nropexibicao ");
		strSQL = strSQL.concat("  FROM ijoproteiro a ");
		strSQL = strSQL.concat(" WHERE a.nrop = '" + cdCp + "'");		
		SQLQuery query = dao.getSession().createSQLQuery(strSQL);
		
		List<Object> lista = query.list();
		if (lista != null && lista.size() > 0) {
			Object reg = lista.get(0);
			retorno = (String) reg;
		}
		
		return retorno;
	}	

	@SuppressWarnings("unchecked")
	public List<PeriodoDTO> getPeriodosOPTurno(String cdPt, String cdCp, Date dtHrIniTur, Date dtHrFimTur) {
		List<PeriodoDTO> listaPeriodos = new ArrayList<PeriodoDTO>();
		
		Date dthrAtual = DataHoraRN.getDataHoraAtual();
		
		String strSQL = "";		
		strSQL = strSQL.concat("SELECT a.DtHrEntrada, a.DtHrSaida ");
		strSQL = strSQL.concat("  FROM IJentsaiOPMAQ a ");
		strSQL = strSQL.concat("  JOIN ijtbinj b ON (b.cdinjetora = a.cdinjetora) ");
		strSQL = strSQL.concat(" WHERE b.cdinjestendido = :cdpt ");
		strSQL = strSQL.concat("   AND a.nrop = :cdcp ");
		strSQL = strSQL.concat("   AND ( ");
		strSQL = strSQL.concat("            (a.DtHrEntrada BETWEEN :dthrIniTur   AND :dthrFimTur) "); 
		strSQL = strSQL.concat("         OR (a.DtHrSaida   BETWEEN :dthrIniTur   AND :dthrFimTur) ");  
		strSQL = strSQL.concat("         OR (:dthrIniTur   BETWEEN a.DtHrEntrada AND a.DtHrSaida) ");
		strSQL = strSQL.concat("         OR (a.DtHrSaida IS NULL AND a.DtHrEntrada  <= :dthrIniTur) ");
		strSQL = strSQL.concat("       ) "); 
		SQLQuery query = getDao().getSession().createSQLQuery(strSQL);
		
		query.setString("cdpt", cdPt)
			 .setString("cdcp", cdCp)
			 .setTimestamp("dthrIniTur", dtHrIniTur)
			 .setTimestamp("dthrFimTur", dtHrFimTur)
			 .list();
		
		List<Object> lista = query.list();
		
		for (Object reg : lista) {
			Object[] registro = null;
			Object regAux = (Object) reg;
			registro = (Object[]) regAux;
			
			PeriodoDTO periodo = new PeriodoDTO();
			periodo.setDtHrInicio((Date) registro[0]);
			periodo.setDtHrFim((Date) registro[1]);
			
			
			if (DataHoraRN.after(dtHrIniTur, periodo.getDtHrInicio())) {
				periodo.setDtHrInicio(dtHrIniTur);
			}
			
			if (periodo.getDtHrFim() != null) {    			
    			if (DataHoraRN.before(dtHrFimTur, periodo.getDtHrFim())) {
    				periodo.setDtHrFim(dtHrFimTur);
    			}
			} else {
    			if (DataHoraRN.after(dthrAtual, dtHrFimTur)) {
    				periodo.setDtHrFim(dtHrFimTur);
    			} else {
    				periodo.setDtHrFim(dthrAtual);
    			}
			}    			
			
			listaPeriodos.add(periodo);
		}
		
		return listaPeriodos;
	}	
}
