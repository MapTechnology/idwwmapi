package idw.model.rn.exp.injet;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.exception.SQLGrammarException;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemPlanejamentoException;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpproduto;
import idw.model.pojos.PpPlano;
import idw.model.pojos.injet.Ijcarteira;
import idw.model.pojos.injet.Ijestmol;
import idw.model.pojos.injet.Ijop;
import idw.model.pojos.injet.Ijopprodutos;
import idw.model.pojos.injet.IjopprodutosId;
import idw.model.pojos.injet.Ijoproteiro;
import idw.model.pojos.injet.IjoproteiroId;
import idw.model.pojos.injet.Ijplano;
import idw.model.pojos.injet.Ijplanop;
import idw.model.pojos.injet.IjplanopId;
import idw.model.pojos.injet.Ijprocarteira;
import idw.model.pojos.injet.IjprocarteiraId;
import idw.model.pojos.injet.Ijproplano;
import idw.model.pojos.injet.IjproplanoId;
import idw.model.pojos.injet.Ijtbcli;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.Ijtbpro;
import idw.model.pojos.injet.Ijtbstop;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.util.UtilsString;

public class ExportacaoInjetOPRN extends ExportacaoInjetFactory{

	private final DAOGenerico dao;
	private DAOGenericoInjet daoInjet;
	private final IdwLogger log;
	private final int idLog;
	private final int identacao;
	
	public ExportacaoInjetOPRN (IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super();
		
		this.dao = dao;
		this.daoInjet = daoInjet;
		this.log = log;
		this.identacao = identacao;
		this.idLog = idLog;
		
	}
	
	@Override
	public void exportar(PpPlano ppplano) throws SemPlanejamentoException{
		
		if (this.daoInjet == null) {
			this.daoInjet = new DAOGenericoInjet();
			this.daoInjet.iniciaConexaoBanco();
		}
		
		try {
			// Varrer as ops do plano exportando para o injet
			for (PpCp ppcp : ppplano.getPpCps()) {
				if (ppcp.getStAtivo().equals((byte) 0))
					continue;
				exportarParaInjet(ppcp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.daoInjet.rollBackTransacao();
			throw new SemPlanejamentoException();
		} finally {
			try {
				this.daoInjet.finalizaConexaoBanco();
			} catch (SQLGrammarException e) {
				e.printStackTrace();
				throw new SemPlanejamentoException();
				
			}
		}
	}
	private void exportarParaInjet2(PpCp ppcp) {
		// ijop, ijoproteiro (permite usar o mesmo nro de op em varias maquians),
		Ijestmol ijestmol;
		Ijplano ijplano = new Ijplano();
		Ijtbstop ijtbstop = new Ijtbstop();
		
		// Localizar ijtbinj
		//ijtbinj2 = pesquisarIjtbinj(ppcp.getOmPt().getCdPt());
		Ijtbinj ijtbinj = new Ijtbinj();
		ijtbinj.setCdinjetora(ppcp.getOmPt().getCdPt());
		
		// Pesquisar estrutura do molde
		List<String> ferramenta = UtilsString.quebrarStringEmVetor(ppcp.getDwFolha().getCdFolha(), "-");
		String cdMolde = ferramenta.get(0);
		String cdEstrutura = ferramenta.get(1);
		
		ijestmol = pesquisarIjestmol(cdMolde, cdEstrutura);
		
		Ijop ijop = new Ijop();
		ijop.setNrop(ppcp.getPpPlano().getCdPlano() + ppcp.getIdCp().toString()); // PK
		ijop.setDtentrega(null);
		ijop.setDthriprevista(DataHoraRN.getDataSemMilisegundos(ppcp.getDthrInicio()));
		ijop.setDthrfprevista(DataHoraRN.getDataSemMilisegundos(ppcp.getDthrFinal()));
		ijop.setIjtbinj(ijtbinj);
		ijop.setIjestmol(ijestmol);
		ijop.setNrseq(999999);
		ijop.setNropcoorp(null);

		ijop.setNropestendido(ijop.getNrop());
		ijop.setOpcritica( '0' );
		ijop.setToleranciaplano(0d);
		ijop.setTpacabamento( '2' );
		ijop.setTpordemproducao( '1' );
		ijop.setNumsmnentrega(BigDecimal.ZERO);
		
		Ijcarteira ijcarteida = new Ijcarteira();
		ijcarteida.setNrcarteira(ijop.getNrop()); //pk limite 10
		ijcarteida.setDoc("");
		ijcarteida.setSolicitante("");
		ijcarteida.setObs("");
		ijcarteida.setDthrpedido(DataHoraRN.getDataSemMilisegundos(ijop.getDthriprevista()));
		Ijtbcli ijtbcli = pesquisarIjtbcli("999999");
		ijcarteida.setIjtbcli(ijtbcli); // 999999
		ijcarteida.setSolicitante(null);
		ijcarteida.setStpedido(BigDecimal.ONE); //1-pedido aceito (default) o 0 eh pedido nao aceito

		daoInjet.makePersistent(ijcarteida);
		
		PpCpproduto cpproduto = null;
		for (PpCpproduto cpp : ppcp.getPpCpprodutos()) {
			cpproduto = cpp;
			break;
		}
		Ijtbpro ijtbpro = pesquisarIjtbpro(cpproduto.getOmProduto().getCdProduto());
		
		Ijprocarteira procart = new Ijprocarteira();
		IjprocarteiraId procartid = new IjprocarteiraId();
		procartid.setCdproduto(cpproduto.getOmProduto().getCdProduto());
		procartid.setNrcarteira(ijcarteida.getNrcarteira());
		procart.setId(procartid);
		procart.setIjcarteira(ijcarteida);
		procart.setIjtbpro(ijtbpro);
		procart.setQtatendida(0d);
		procart.setQtpedida(cpproduto.getPcsProducaoplanejada().doubleValue());
		
		daoInjet.makePersistent(procart);
		
		ijplano.setNrplano(ijop.getNrop());
		ijplano.setDocumento("");
		ijplano.setDthremissao(DataHoraRN.getDataSemMilisegundos(ijop.getDthriprevista()));
		ijplano.setIjcarteira(ijcarteida);
		
		daoInjet.makePersistent(ijplano);

		ijop.setIjplano(ijplano);

		Ijproplano ijproplano = new Ijproplano();
		IjproplanoId proplanoid = new IjproplanoId();
		proplanoid.setCdproduto(ijtbpro.getCdproduto());
		proplanoid.setNrplano(ijplano.getNrplano());
		ijproplano.setId(proplanoid);
		ijproplano.setIjplano(ijplano);
		ijproplano.setIjtbpro(ijtbpro);
		ijproplano.setQtplanejada(cpproduto.getPcsProducaoplanejada().doubleValue());
		ijproplano.setQtproduzida(0d);

		daoInjet.makePersistent(ijproplano);

		// Pesquisar Ijtbstop com a descricao 
		ijtbstop = pesquisarIjtbstop("0"); // 0=Disponivel 1 =normal 2 = suspenso
		ijop.setIjtbstop(ijtbstop);
		
		daoInjet.makePersistent(ijop);
		
		Ijplanop ijplanop = new Ijplanop();
		IjplanopId ijplanopid = new IjplanopId();
		ijplanopid.setDthriniplan(DataHoraRN.getDataSemMilisegundos(ijop.getDthriprevista()));
		ijplanopid.setNrop(ijop.getNrop());
		
		ijplanop.setDthrfimplan(DataHoraRN.getDataSemMilisegundos(ijop.getDthrfprevista()));
		ijplanop.setId(ijplanopid);
		ijplanop.setEficiencia(85d);
		ijplanop.setIjestmol(ijestmol);
		ijplanop.setIjop(ijop);
		ijplanop.setIjtbinj(ijtbinj);
		ijplanop.setSituacaoplano(new BigDecimal(1)); // valor 1=disponivel 2=suspenso
		if (ppcp.getDwFolha().getSegSetup() != null)
			ijplanop.setTmpsetup(new BigDecimal(ppcp.getDwFolha().getSegSetup()).divide(new BigDecimal(60)));
		else
			ijplanop.setTmpsetup(BigDecimal.ZERO);
		
		daoInjet.makePersistent(ijplanop);
		
		Ijoproteiro roteiro = new Ijoproteiro();
		IjoproteiroId id = new IjoproteiroId();
		id.setCdestrutura(ijestmol.getId().getCdestrutura());
		id.setCdinjetora(ijtbinj.getCdinjetora());
		id.setCdmolde(ijestmol.getId().getCdmolde());
		id.setNrop(ijop.getNrop());
		id.setNropexibicao(ijop.getNrop());
		id.setSequencia(BigDecimal.ONE);
		roteiro.setId(id);
		roteiro.setIjestmol(ijestmol);
		roteiro.setIjop(ijop);
		roteiro.setIjtbinj(ijtbinj);
		
		daoInjet.makePersistent(roteiro);

		Ijopprodutos opprod = new Ijopprodutos();
		IjopprodutosId opprodId = new IjopprodutosId();
		opprodId.setCdestrutura(ijestmol.getId().getCdestrutura());
		opprodId.setCdmolde(ijestmol.getId().getCdmolde());
		opprodId.setCdproduto(ijtbpro.getCdproduto());
		opprodId.setNrop(ijop.getNrop());
		opprod.setId(opprodId);
		opprod.setIjestmol(ijestmol);
		opprod.setIjop(ijop);
		opprod.setIjtbpro(ijtbpro);
		opprod.setQtpecasestoque(0d);
		opprod.setQtpecasproduzir(cpproduto.getPcsProducaoplanejada().doubleValue());
		
		daoInjet.makePersistent(opprod);
		
	}
	
	private Ijtbcli pesquisarIjtbcli(String cd) {
		MapQuery q = new MapQuery(daoInjet.getSession());
		q.append("select a from Ijtbcli a where a.cdcliente = :cd");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbcli) q.uniqueResult();
	}
	private Ijtbpro pesquisarIjtbpro(String cd) {
		MapQuery q = new MapQuery(daoInjet.getSession());
		q.append("select a from Ijtbpro a where a.cdproduto = :cd");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbpro) q.uniqueResult();
	}
	
	private Ijtbstop pesquisarIjtbstop(String cd) {
		MapQuery q = new MapQuery(daoInjet.getSession());
		q.append("select a from Ijtbstop a where a.stop = :cd");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbstop) q.uniqueResult();
	}
	
	private Ijestmol pesquisarIjestmol(String cdMolde, String cdEstrutura) {
		MapQuery q = new MapQuery(daoInjet.getSession());
		
		q.append("select a from Ijestmol a where a.ijtbmol.cdmolestendido = :cdmolde");
		q.append("and a.id.cdestrutura = :cdestrutura");
		
		q.defineParametro("cdmolde", cdMolde);
		q.defineParametro("cdestrutura", cdEstrutura);
		q.setMaxResults(1);
		
		return (Ijestmol) q.uniqueResult();
	}
	
	private Ijtbinj pesquisarIjtbinj(String cd) {
		MapQuery q = new MapQuery(daoInjet.getSession());
		q.append("select a from Ijtbinj a where a.cdinjetora = :cd");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbinj) q.uniqueResult();
	}
	
	private void exportarParaInjet(PpCp ppcp) {
		// ijop, ijoproteiro (permite usar o mesmo nro de op em varias maquians),
		Ijestmol ijestmol;
		Ijplano ijplano = new Ijplano();
		Ijtbstop ijtbstop = new Ijtbstop();
		
		// Localizar ijtbinj
		//ijtbinj2 = pesquisarIjtbinj(ppcp.getOmPt().getCdPt());
		Ijtbinj ijtbinj = new Ijtbinj();
		ijtbinj.setCdinjetora(ppcp.getOmPt().getCdPt());
		
		// Pesquisar estrutura do molde
		List<String> ferramenta = UtilsString.quebrarStringEmVetor(ppcp.getDwFolha().getCdFolha(), "-");
		String cdMolde = ferramenta.get(0);
		String cdEstrutura = ferramenta.get(1);
		
		ijestmol = pesquisarIjestmol(cdMolde, cdEstrutura);
		
		Ijop ijop = new Ijop();
		ijop.setNrop(ppcp.getPpPlano().getCdPlano() + ppcp.getIdCp().toString()); // PK
		ijop.setDtentrega(null);
		ijop.setDthriprevista(DataHoraRN.getDataSemMilisegundos(ppcp.getDthrInicio()));
		ijop.setDthrfprevista(DataHoraRN.getDataSemMilisegundos(ppcp.getDthrFinal()));
		ijop.setIjtbinj(ijtbinj);
		ijop.setIjestmol(ijestmol);
		ijop.setNrseq(999999);
		ijop.setNropcoorp(null);
		

		


		Ijcarteira ijcarteida = new Ijcarteira();
		ijcarteida.setNrcarteira(ijop.getNrop()); //pk limite 10
		ijcarteida.setDoc("");
		ijcarteida.setObs("");
		ijcarteida.setDthrpedido(DataHoraRN.getDataSemMilisegundos(ijop.getDthriprevista()));
		Ijtbcli ijtbcli = pesquisarIjtbcli("999999");
		ijcarteida.setIjtbcli(ijtbcli); // 999999
		ijcarteida.setSolicitante(null);
		ijcarteida.setStpedido(BigDecimal.ONE); //1-pedido aceito (default) o 0 eh pedido nao aceito

		MapQuery qcar = new MapQuery(daoInjet.getSession());
		qcar.append("insert into ijcarteira (nrcarteira, doc, solicitante, obs, dthrpedido, cdcliente, stpedido)");
		qcar.append("values (:nrcarteira, :doc, :solicitante, :obs, :dthrpedido, :cdcliente, :stpedido)");
		
		qcar.querySQL().setParameter("nrcarteira", ijop.getNrop());
		qcar.querySQL().setParameter("doc", "");
		qcar.querySQL().setParameter("solicitante", null);
		qcar.querySQL().setParameter("obs", "");
		qcar.querySQL().setParameter("dthrpedido", ijcarteida.getDthrpedido());
		qcar.querySQL().setParameter("cdcliente", "999999");
		qcar.querySQL().setParameter("stpedido", ijcarteida.getStpedido());

		qcar.querySQL().executeUpdate();
		
		PpCpproduto cpproduto = null;
		for (PpCpproduto cpp : ppcp.getPpCpprodutos()) {
			cpproduto = cpp;
			break;
		}
		Ijtbpro ijtbpro = pesquisarIjtbpro(cpproduto.getOmProduto().getCdProduto());
		
		Ijprocarteira procart = new Ijprocarteira();
		IjprocarteiraId procartid = new IjprocarteiraId();
		procartid.setCdproduto(cpproduto.getOmProduto().getCdProduto());
		procartid.setNrcarteira(ijcarteida.getNrcarteira());
		procart.setId(procartid);
		procart.setIjcarteira(ijcarteida);
		procart.setIjtbpro(ijtbpro);
		procart.setQtatendida(0d);
		procart.setQtpedida(cpproduto.getPcsProducaoplanejada().doubleValue());

		MapQuery qpc = new MapQuery(daoInjet.getSession());
		qpc.append("insert into ijprocarteira (cdproduto, nrcarteira, qtatendida, qtpedida)");
		qpc.append("values (:cdproduto, :nrcarteira, :qtatendida, :qtpedida)");
		qpc.querySQL().setParameter("cdproduto", procartid.getCdproduto());
		qpc.querySQL().setParameter("nrcarteira", procartid.getNrcarteira());
		qpc.querySQL().setParameter("qtatendida", procart.getQtatendida());
		qpc.querySQL().setParameter("qtpedida", procart.getQtpedida());

		qpc.querySQL().executeUpdate();
		
		ijplano.setNrplano(ijop.getNrop());
		ijplano.setDocumento("");
		ijplano.setDthremissao(DataHoraRN.getDataSemMilisegundos(ijop.getDthriprevista()));
		ijplano.setIjcarteira(ijcarteida);
		
		MapQuery qpla = new MapQuery(daoInjet.getSession());
		qpla.append("insert into ijplano (nrplano, documento, dthremissao, nrcarteira)");
		qpla.append("values (:nrplano, :documento, :dthremissao, :nrcarteira)");

		qpla.querySQL().setParameter("nrplano", ijplano.getNrplano());
		qpla.querySQL().setParameter("documento", "");
		qpla.querySQL().setParameter("dthremissao", ijplano.getDthremissao());
		qpla.querySQL().setParameter("nrcarteira", ijcarteida.getNrcarteira());
		
		qpla.querySQL().executeUpdate();

		ijop.setIjplano(ijplano);

		ijop.setNropestendido(ijop.getNrop());
		ijop.setOpcritica( '0' );
		ijop.setToleranciaplano(0d);
		ijop.setTpacabamento( '2' );
		ijop.setTpordemproducao( '1' );
		ijop.setNumsmnentrega(BigDecimal.ZERO);

		Ijproplano ijproplano = new Ijproplano();
		IjproplanoId proplanoid = new IjproplanoId();
		proplanoid.setCdproduto(ijtbpro.getCdproduto());
		proplanoid.setNrplano(ijplano.getNrplano());
		ijproplano.setId(proplanoid);
		ijproplano.setIjplano(ijplano);
		ijproplano.setIjtbpro(ijtbpro);
		ijproplano.setQtplanejada(cpproduto.getPcsProducaoplanejada().doubleValue());
		ijproplano.setQtproduzida(0d);

		MapQuery qpp = new MapQuery(daoInjet.getSession());
		qpp.append("insert into ijproplano (cdproduto, nrplano, qtplanejada, qtproduzida)");
		qpp.append("values (:cdproduto, :nrplano, :qtplanejada, :qtproduzida)");
		
		qpp.querySQL().setParameter("cdproduto", ijtbpro.getCdproduto());
		qpp.querySQL().setParameter("nrplano", ijplano.getNrplano());
		qpp.querySQL().setParameter("qtplanejada", ijproplano.getQtplanejada());
		qpp.querySQL().setParameter("qtproduzida", ijproplano.getQtproduzida());

		qpp.querySQL().executeUpdate();
		
		// Pesquisar Ijtbstop com a descricao 
		ijtbstop = pesquisarIjtbstop("0"); // 0=Disponivel 1 =normal 2 = suspenso
		ijop.setIjtbstop(ijtbstop);
		

		MapQuery qop = new MapQuery(daoInjet.getSession());
		qop.append("insert into ijop (nrop, dtentrega, dthriprevista, dthrfprevista, cdinjetora, cdmolde, cdestrutura, nrseq, nropcoorp, nropestendido, opcritica, toleranciaplano, tpacabamento, tpordemproducao, Numsmnentrega, nrplano, stop)");
		qop.append("values (:nrop, :dtentrega, :dthriprevista, :dthrfprevista, :cdinjetora, :cdmolde, :cdestrutura, :nrseq, :nropcoorp, :nropestendido, :opcritica, :toleranciaplano, :tpacabamento, :tpordemproducao, :Numsmnentrega, :nrplano, :stop)");
		
		qop.querySQL().setParameter("nrop", ijop.getNrop()); 
		qop.querySQL().setParameter("dtentrega", null);
		qop.querySQL().setParameter("dthriprevista", ijop.getDthriprevista());
		qop.querySQL().setParameter("dthrfprevista", ijop.getDthrfprevista());
		qop.querySQL().setParameter("cdinjetora", ijtbinj.getCdinjetora());
		qop.querySQL().setParameter("cdmolde", ijestmol.getId().getCdmolde());
		qop.querySQL().setParameter("cdestrutura", ijestmol.getId().getCdestrutura());
		qop.querySQL().setParameter("nrseq", 9999999);
		qop.querySQL().setParameter("nropcoorp", null);
		qop.querySQL().setParameter("nropestendido", ijop.getNropestendido());
		qop.querySQL().setParameter("opcritica", '0');
		qop.querySQL().setParameter("toleranciaplano", 0d); 
		qop.querySQL().setParameter("tpacabamento", '2');
		qop.querySQL().setParameter("tpordemproducao", '1');
		qop.querySQL().setParameter("Numsmnentrega", BigDecimal.ZERO);
		qop.querySQL().setParameter("nrplano", ijplano.getNrplano());
		qop.querySQL().setParameter("stop", 0);

		qop.querySQL().executeUpdate();
		
		
		Ijplanop ijplanop = new Ijplanop();
		IjplanopId ijplanopid = new IjplanopId();
		ijplanopid.setDthriniplan(DataHoraRN.getDataSemMilisegundos(ijop.getDthriprevista()));
		ijplanopid.setNrop(ijop.getNrop());
		
		ijplanop.setDthrfimplan(DataHoraRN.getDataSemMilisegundos(ijop.getDthrfprevista()));
		ijplanop.setId(ijplanopid);
		ijplanop.setEficiencia(85d);
		ijplanop.setIjestmol(ijestmol);
		ijplanop.setIjop(ijop);
		ijplanop.setIjtbinj(ijtbinj);
		ijplanop.setSituacaoplano(new BigDecimal(1)); // valor 1=disponivel 2=suspenso
		if (ppcp.getDwFolha().getSegSetup() != null)
			ijplanop.setTmpsetup(new BigDecimal(ppcp.getDwFolha().getSegSetup()).divide(new BigDecimal(60)));
		else
			ijplanop.setTmpsetup(BigDecimal.ZERO);
		
		MapQuery qpop = new MapQuery(daoInjet.getSession());
		qpop.append("insert into ijplanop (dthriniplan, nrop, dthrfimplan, eficiencia, cdmolde, cdestrutura, cdinjetora, situacaoplano, tmpsetup)");
		qpop.append("values (:dthriniplan, :nrop, :dthrfimplan, :eficiencia, :cdmolde, :cdestrutura, :cdinjetora, :situacaoplano, :tmpsetup)");
		
		qpop.querySQL().setParameter("dthriniplan", ijplanopid.getDthriniplan());
		qpop.querySQL().setParameter("nrop", ijop.getNrop()); 
		qpop.querySQL().setParameter("dthrfimplan", ijplanop.getDthrfimplan()); 
		qpop.querySQL().setParameter("eficiencia", 85);
		qpop.querySQL().setParameter("cdmolde", ijestmol.getId().getCdmolde());
		qpop.querySQL().setParameter("cdestrutura", ijestmol.getId().getCdestrutura());
		qpop.querySQL().setParameter("cdinjetora", ijtbinj.getCdinjetora());
		qpop.querySQL().setParameter("situacaoplano", 1);
		qpop.querySQL().setParameter("tmpsetup", 0);
		
		qpop.querySQL().executeUpdate();
		
		Ijoproteiro roteiro = new Ijoproteiro();
		IjoproteiroId id = new IjoproteiroId();
		id.setCdestrutura(ijestmol.getId().getCdestrutura());
		id.setCdinjetora(ijtbinj.getCdinjetora());
		id.setCdmolde(ijestmol.getId().getCdmolde());
		id.setNrop(ijop.getNrop());
		id.setNropexibicao(ijop.getNrop());
		id.setSequencia(BigDecimal.ONE);
		roteiro.setId(id);
		roteiro.setIjestmol(ijestmol);
		roteiro.setIjop(ijop);
		roteiro.setIjtbinj(ijtbinj);
		
		MapQuery qrot = new MapQuery(daoInjet.getSession());
		qrot.append("insert into ijoproteiro (cdestrutura, cdinjetora, cdmolde, nrop, nropexibicao, sequencia)");
		qrot.append("values (:cdestrutura, :cdinjetora, :cdmolde, :nrop, :nropexibicao, :sequencia)");
		
		qrot.querySQL().setParameter("cdestrutura", id.getCdestrutura());
		qrot.querySQL().setParameter("cdinjetora", ijtbinj.getCdinjetora());
		qrot.querySQL().setParameter("cdmolde", ijestmol.getId().getCdmolde());
		qrot.querySQL().setParameter("nrop", ijop.getNrop());
		qrot.querySQL().setParameter("nropexibicao", ijop.getNrop());
		qrot.querySQL().setParameter("sequencia", 1);
		
		qrot.querySQL().executeUpdate();

		Ijopprodutos opprod = new Ijopprodutos();
		IjopprodutosId opprodId = new IjopprodutosId();
		opprodId.setCdestrutura(ijestmol.getId().getCdestrutura());
		opprodId.setCdmolde(ijestmol.getId().getCdmolde());
		opprodId.setCdproduto(ijtbpro.getCdproduto());
		opprodId.setNrop(ijop.getNrop());
		opprod.setId(opprodId);
		opprod.setIjestmol(ijestmol);
		opprod.setIjop(ijop);
		opprod.setIjtbpro(ijtbpro);
		opprod.setQtpecasestoque(0d);
		opprod.setQtpecasproduzir(cpproduto.getPcsProducaoplanejada().doubleValue());

		MapQuery q = new MapQuery(daoInjet.getSession());
		q.append("insert into Ijopprodutos (cdmolde, cdestrutura, cdproduto, nrop, qtpecasproduzir)");
		q.append("values (:cdmolde, :cdestrutura, :cdproduto, :nrop, :qtpecasproduzir)");
		q.querySQL().setParameter("cdmolde", ijestmol.getId().getCdmolde());
		q.querySQL().setParameter("cdestrutura", ijestmol.getId().getCdestrutura());
		q.querySQL().setParameter("cdproduto", ijtbpro.getCdproduto());
		q.querySQL().setParameter("nrop", ijop.getNrop());
		q.querySQL().setParameter("qtpecasproduzir", cpproduto.getPcsProducaoplanejada().doubleValue());
		
		q.querySQL().executeUpdate();
		
	}
}
