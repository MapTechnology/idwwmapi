package idw.model.rn.alimentacao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ObjectUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmpaproDao;
import idw.model.excessoes.SemCalendarioException;
import idw.model.pojos.OmAlimrea;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmPapro;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmPtcnc;
import idw.model.pojos.OmReel;
import idw.model.rn.AbstractRN;
import idw.model.rn.TurnoRN;
import idw.model.rn.consolidacao.estoque.ConsolidacaoLocalEstoque;
import idw.model.rn.estoque.TipoAjusteEstoque;
import idw.util.CompareUtils;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.dto.TurnoAtualDTO;


public class ConsumoAlimentacaoRN extends AbstractRN<DAOGenerico> {
	
	private final OmCfg omCfg;
	
	public ConsumoAlimentacaoRN(DAOGenerico dao) {
		this(dao, null);
	}
	
	public ConsumoAlimentacaoRN(DAOGenerico dao, OmCfg omCfg) {
		super(dao);
		if(omCfg == null){
			omCfg = Util.getConfigGeral(dao.getSession());
		}
		this.omCfg = omCfg;
	}
	
	public Map<String, BigDecimal> getQtdParaConsumoDoPA(List<OmPapro> componentesNoPaDoPt, BigDecimal producaoPorCiclo){
		
		Map<String, BigDecimal> qtdParaConsumoDoPAs = new HashMap<String, BigDecimal>();
		
		for(OmPapro omPapro : componentesNoPaDoPt){
			
			String cdPA = omPapro.getOmPa().getCdPa();	
			if(qtdParaConsumoDoPAs.containsKey(cdPA) == false){				
				BigDecimal qtd = getQtdConsumidoPorCiclo(omPapro, producaoPorCiclo);
				qtdParaConsumoDoPAs.put(cdPA, qtd);				
			}
		
		}
		
		return qtdParaConsumoDoPAs;
		
	}
	
	public void consumirPorCiclo(OmPt omPt, Date dtHrFimCiclo, BigDecimal producaoPorCiclo) throws SemCalendarioException{
		
		if(isPodeConsumir()){
			
			/* Consumir  a materia prima que foi alimentada no posto de trabalho
			 * 
			 */
			OmpaproDao ompaproDao = new OmpaproDao(getDaoSession());
			List<OmPapro> componentesNoPaDoPtOrdenadoIdOmpapro =  ompaproDao.getTodosProdutosDoPaDoPt(omPt);

			Set<OmPapro> omPaprosZerados = new HashSet<OmPapro>(0);
			Map<String, BigDecimal> qtdParaConsumoDoPA = getQtdParaConsumoDoPA(componentesNoPaDoPtOrdenadoIdOmpapro, producaoPorCiclo);

			TurnoRN turnoRN = new TurnoRN(getDao());				
			TurnoAtualDTO turnoAtualDTO = turnoRN.getTurnoAtualDTOSemClone(omPt, dtHrFimCiclo);
			
			consumirQtd(omPt, componentesNoPaDoPtOrdenadoIdOmpapro, qtdParaConsumoDoPA, omPaprosZerados, dtHrFimCiclo, TipoAjusteEstoque.CONSUMO_POR_CICLO, turnoAtualDTO, dtHrFimCiclo);
			
		}
		
	}

	public void consumirPorPerdaComponente(IdwLogger log, int idLog, OmPt omPt, OmProduto omProduto, String cdRap, BigDecimal qtdPerdida, Date dthrPerda) throws SemCalendarioException{
		
		if(isPodeConsumir()){
		
			OmpaproDao ompaproDao = new OmpaproDao(getDaoSession());
			List<OmPapro> omPapros = ompaproDao.getProdutosDaPosicaoNaOrdem(omPt, cdRap);//, omProduto.getIdProduto());
						
			if(omPapros != null && (omPapros.isEmpty() == false)){		
				
				Map<String, BigDecimal> qtdParaConsumirNoPA = new HashMap<String, BigDecimal>(0);
				
				qtdParaConsumirNoPA.put(omPapros.get(0).getOmPa().getCdPa(), qtdPerdida);
								
				Set<OmPapro> omPaprosZerados = new HashSet<OmPapro>(0);
				
				TurnoRN turnoRN = new TurnoRN(getDao());				
				TurnoAtualDTO turnoAtualDTO = turnoRN.getTurnoAtualDTOSemClone(omPt, dthrPerda);
				
				consumirQtd(omPt, omPapros, qtdParaConsumirNoPA, omPaprosZerados, dthrPerda, TipoAjusteEstoque.CONSUMO_POR_PERDA, turnoAtualDTO, dthrPerda);
				
				consumirAlimentacao(log, idLog, ompaproDao, omPt, qtdParaConsumirNoPA, TipoAjusteEstoque.CONSUMO_POR_PERDA, qtdPerdida);
			}
			
		}
		
	}
	
	private OmAlimrea getUltimaOmAlimreaPtPa(MapQuery q, String cdpt, String cdpa) {
		OmAlimrea retorno = null;
		
		q.defineParametro("cdpt", cdpt);
		q.defineParametro("cdpa", cdpa);
		
		retorno = (OmAlimrea) q.uniqueResult();
		
		return retorno;
	}

	/* Metodo para consumir a alimentacao que foi registrada em omalimrea
	 * Essa alimentacao tem o Lote do fabricante associado entao sera usada para 
	 * registrar  na rastreabilidade qual foram as materias primas usadas e o lote do fabricante
	 */
	private void consumirAlimentacao(IdwLogger log, int idLog, OmpaproDao ompaproDao, OmPt omPt, Map<String, BigDecimal> qtdParaConsumoPAs, TipoAjusteEstoque tipoAjusteEstoque, BigDecimal producaoPorCiclo) {
		
		MapQuery q = new MapQuery(getDaoSession());
		q.append("select a");
		q.append("from OmAlimrea a");
		q.append("join a.omAlim b");
		q.append("join b.omMapa c");
		q.append("join c.omPt d");
		q.append("join a.omMapapa e");
		q.append("join e.omPa f");
		q.append("where d.cdPt = :cdpt");
		q.append("and f.cdPa = :cdpa");
		q.append("and b.stAlim = 1"); // Alimentacao com sucesso
		q.append("and b.tpAlim = 3"); // alimentacao
		q.append("and (a.qtAtual is null or a.qtAtual < a.qtAlimentada)");
		// talvez seja necessario considerar idAlim na consulta pois poderao haver varios antigos que atendam o criteirio
		q.append("order by a.idAlimrea");
		
		q.setMaxResults(1);
		
		AlimentacaoRN rn = new AlimentacaoRN();
		rn.setDao(getDao());
		
		// Como o posto pode não ter nenhuma alimentacao associada, entao devemos obter quais serão os postos que consideraremos para obter as alimentacoes
		// para tanto obter a lista de postos no cadastr
		for (OmPtcnc cnc : omPt.getOmPtcncsForIdPt()) {
			OmPt omptAux = cnc.getOmPtByIdPtFilho();
			List<OmPapro> componentesNoPaDoPtOrdenadoIdOmpapro =  ompaproDao.getTodosProdutosDoPaDoPt(omptAux);
			Map<String, BigDecimal> qtdParaConsumoDoPAux = getQtdParaConsumoDoPA(componentesNoPaDoPtOrdenadoIdOmpapro, producaoPorCiclo);
			qtdParaConsumoPAs.putAll(qtdParaConsumoDoPAux);
		
			for (String cdpa : qtdParaConsumoPAs.keySet()) {
				
				BigDecimal qtde = qtdParaConsumoPAs.get(cdpa);
				// Localizar o OmAlimRea
				OmAlimrea omalimrea = getUltimaOmAlimreaPtPa(q, cnc.getOmPtByIdPtFilho().getCdPt(), cdpa);
				
				// O q fazer se nao existir uma alimentacao do CF??
				if (omalimrea == null)
					continue;
	
					
				
				// Consumir a alimentacao
				if (tipoAjusteEstoque.equals(TipoAjusteEstoque.CONSUMO_POR_CICLO)) {
					if (omalimrea.getQtPorplaca() == null || (omalimrea.getQtPorplaca().compareTo(BigDecimal.ZERO) == 0 && qtde.compareTo(BigDecimal.ZERO) > 0) )
						omalimrea.setQtPorplaca(qtde);
					
					BigDecimal qtUsada = omalimrea.getQtUsada();
					if (qtUsada == null)
						qtUsada = BigDecimal.ZERO;
					
					qtUsada = qtUsada.add(qtde);
					
					omalimrea.setQtUsada(qtUsada);
				} else {
					BigDecimal qtPerdida = omalimrea.getQtPerdida();
					if (qtPerdida == null)
						qtPerdida = BigDecimal.ZERO;
					
					qtPerdida = qtPerdida.add(qtde);
					
					omalimrea.setQtPerdida(qtPerdida);
					
					
					/* atualizar a quantidade perdida do reel
					 * 
					 */
					OmReel omreel = rn.pesquisarEstoqueReelIdOuIncluir(log, idLog, omalimrea);
					if (omreel != null) {
						BigDecimal qtPerdidaReel = omreel.getQtPerdida();
						if (qtPerdidaReel == null)
							qtPerdidaReel = BigDecimal.ZERO;
						
						qtPerdidaReel = qtPerdidaReel.add(qtde);
						
						getDao().makePersistent(omreel);
					}
					

				}
				
				BigDecimal qtAtual = new BigDecimal(omalimrea.getQtAlimentada());
				qtAtual = qtAtual.subtract(omalimrea.getQtUsada());
				if (omalimrea.getQtPerdida() != null)
					qtAtual = qtAtual.subtract(omalimrea.getQtPerdida());
				omalimrea.setQtAtual(qtAtual);
				
				getDao().makePersistent(omalimrea);
			}
				
		}
	}
	

	private void consumirQtd(OmPt omPt, List<OmPapro> omPapros, Map<String, BigDecimal> qtdParaConsumoPAs, Set<OmPapro> omPaprosZerados,  Date dtHrParaEmbalagemZerada, TipoAjusteEstoque tipoAjusteEstoque, TurnoAtualDTO turnoAtualDTO, Date data){
		
		for(OmPapro omPapro : omPapros){

			if(omPapro.getOmProduto() != null){
				consumirQtd(omPapro, qtdParaConsumoPAs, omPaprosZerados, tipoAjusteEstoque, turnoAtualDTO, data);
			}
		
		}
		
		tratarOmPaprosZerados(omPaprosZerados, dtHrParaEmbalagemZerada);
		
		// TODO tratar se teve quantidades pendente de consumo. Provalmente ajustar quantidade, e fazer o consumo, atualizando tabela de local de estoque
		for(String cdPa: qtdParaConsumoPAs.keySet()){
			
			BigDecimal qtd = qtdParaConsumoPAs.get(cdPa);
			if(CompareUtils.compareTo(qtd, BigDecimal.ZERO) > 0 ){

				//System.out.print("Não foi possível consumir por " + tipoAjusteEstoque + " para pt " + omPt.getCdPt() + "." + " Faltou " + qtd.toString());
				
			}else if(CompareUtils.compareTo(qtd, BigDecimal.ZERO) < 0){

				//System.out.print("Qt pendente para consumo ficou negativo, ao consumir por " + tipoAjusteEstoque + " para pt " + omPt.getCdPt() + " " + "qt " + qtd.toString());
				
			}
			
		}
		
	}	
	
	private void tratarOmPaprosZerados(Collection<OmPapro> omPaprosZerados, Date dthrTermino){
		OmpaproDao ompaproDao = new OmpaproDao(this.getDaoSession());
		
		AlimentacaoRN alimentacaoRN = new AlimentacaoRN();
		alimentacaoRN.setDao(getDao());
		
		for(OmPapro omPapro: omPaprosZerados){
			
			ompaproDao.removerOmpapro(omPapro);

			alimentacaoRN.tratarTerminoConsumo(omPapro.getOmPt(), omPapro.getOmPa(), omPapro.getOmMapapa(), dthrTermino, omPapro.getOmProduto());
			
		}	
		
	}

	
	private void consumirQtd(OmPapro omPapro, Map<String, BigDecimal> qtdParaConsumoPAs, Set<OmPapro> omPaprosZerados, 
			TipoAjusteEstoque tipoAjusteEstoque, TurnoAtualDTO turnoAtualDTO, Date data){
		
		String cdPa = omPapro.getOmPa().getCdPa();
				
		BigDecimal qtdParaConsumo = qtdParaConsumoPAs.get(cdPa);
		BigDecimal qtdQueFaltaConsumir = qtdParaConsumo;
		
		if(qtdParaConsumo == null || CompareUtils.compareTo(qtdParaConsumo, BigDecimal.ZERO) == 0){
			// Não precisa consumir
			return;
		}
//		
		if(CompareUtils.compareTo(omPapro.getQtAtual(), qtdParaConsumo) < 0){
			// Se não tiver quantidade suficiente para consumo, usa toda a quantidade atual da posição
			// o restante ficará registrado que faltou consumir
			qtdParaConsumo = omPapro.getQtAtual();
		}

		// chamar consolidacao de consumo de MP do local de estoque
		ConsolidacaoLocalEstoque consolidacaoLocalEstoque = new ConsolidacaoLocalEstoque(getDao());
		consolidacaoLocalEstoque.consolidarLocalEstoqueConsumoOuPerdaMPThreadSafe(tipoAjusteEstoque, turnoAtualDTO, omCfg, omPapro.getOmPt(), omPapro.getOmPa(), 
				omPapro.getOmProduto(), qtdParaConsumo, omPapro.getQtAtual(), data);
		
		omPapro.setQtAtual(omPapro.getQtAtual().subtract(qtdParaConsumo));
		
		
		qtdQueFaltaConsumir = qtdQueFaltaConsumir.subtract(qtdParaConsumo);		
		qtdParaConsumoPAs.put(cdPa, qtdQueFaltaConsumir);

		if(CompareUtils.compareTo(omPapro.getQtAtual(), BigDecimal.ZERO) <= 0){
			omPaprosZerados.add(omPapro);
		}
		
		getDao().makePersistent(omPapro);
		
	}
	
	private BigDecimal getQtdConsumidoPorCiclo(OmPapro omPapro, BigDecimal producaoPorCiclo){
		BigDecimal qtdPorCiclo = BigDecimal.ONE;
		OmMapapa omMapapa = null;
		if(omPapro != null){
			omMapapa = omPapro.getOmMapapa();
			if(omMapapa.getQtUsada() != null && omMapapa.getQtUsada().compareTo(BigDecimal.ZERO) > 0){
				qtdPorCiclo = omMapapa.getQtUsada(); 
			}
		}
		if (omMapapa == null || omMapapa.getIsCiclounico() == null || omMapapa.getIsCiclounico() == false)
			qtdPorCiclo = qtdPorCiclo.multiply(producaoPorCiclo);
		return qtdPorCiclo;
	}

	private boolean isPodeConsumir(){
		return ObjectUtils.defaultIfNull(omCfg.getIsNivelfeeder(), false);
	}
	
}
