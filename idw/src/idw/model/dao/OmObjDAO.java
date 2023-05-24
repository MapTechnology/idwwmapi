package idw.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import idw.model.pojos.OmGt;
import idw.model.pojos.OmObj;

public class OmObjDAO {
	
	private Session session;
	private StatelessSession sessionStatless;

	private static final double TAMANHO_PIXEL_MAXIMO_LINHA = 50;
	private Map<Integer, Double> mapLinha = new HashMap<Integer, Double>();
	private Map<Integer, List<OmObj>> mapLinhaObj = new HashMap<Integer, List<OmObj>>();

	public OmObjDAO(Session session){
		this.session = session;
	}

	public OmObjDAO(StatelessSession session){
		this.sessionStatless = session;
	}
	
	public List<OmObj> getOmObjComCdGt(OmGt omGt, int niveisLoadObj){
		MapQuery q = new MapQuery(session);
		q.append("SELECT omObj FROM OmObj omObj");
		q.append(getHqlJoinOmPt("omObj", "omPt"));
		q.append(getHqlJoinOmGtByIdGt("omObj", "omGtByIdGt"));
		q.append(getHqlJoinOmGtByIdGtFilho("omObj", "omGtByIdGtfilho"));
		q.append(getHqlJoinNivelObj("omObj", niveisLoadObj));
		q.append("WHERE omObj.omGtByIdGt = :omGt");
		q.defineParametro("omGt", omGt);
		List<OmObj> listaObjs = q.list();
		List<OmObj> retorno = new ArrayList<OmObj>();
		for(OmObj obj : listaObjs){
			if(obj.getOmPt() != null){
				if(obj.getOmPt().getStAtivo().intValue() == 1){
					retorno.add(obj);
				}
			}else{
				if(obj.getOmGtByIdGtfilho() != null){
					retorno.add(obj);
				}
			}
		}
		return retorno;
	}
	
	private static String getHqlJoinOmPt(String aliasOmObj, String aliasOmPt){
		return new StringBuilder()
			.append(" LEFT JOIN FETCH ")
			.append(aliasOmObj)
			.append(".omPt ") 
			.append(aliasOmPt)
			.toString();
	}

	private static String getHqlJoinOmGtByIdGt(String aliasOmObj, String aliasOmGtByIdGt){
		return new StringBuilder()
			.append(" LEFT JOIN FETCH ")
			.append(aliasOmObj)
			.append(".omGtByIdGt ") 
			.append(aliasOmGtByIdGt)
			.toString();
	}	

	private static String getHqlJoinOmGtByIdGtFilho(String aliasOmObj, String aliasOmGtByIdGtFilho){
		return new StringBuilder()
			.append(" LEFT JOIN FETCH ")
			.append(aliasOmObj)
			.append(".omGtByIdGtfilho ") 
			.append(aliasOmGtByIdGtFilho)
			.toString();
	}	
	
	private static String getHqlJoinNivelObj(String aliasOmObj, int niveisLoadObj){
		StringBuilder hqlNivelObj = new StringBuilder();
		final String SUFIXO = "N";
		for(int i = 1; i <= niveisLoadObj; i++) {
			String aliasOmGtByIdGtfilho = new StringBuilder("omGtByIdGtfilho").append(SUFIXO).append(i).toString();
			hqlNivelObj.append(getHqlJoinOmGtByIdGtFilho(aliasOmObj, aliasOmGtByIdGtfilho));			
			aliasOmObj = new StringBuilder("omObjs").append(SUFIXO).append(i).toString();
			hqlNivelObj.append(" LEFT JOIN FETCH ");
			hqlNivelObj.append(aliasOmGtByIdGtfilho);
			hqlNivelObj.append(".").append("omObjsForIdGt");
			hqlNivelObj.append(" ").append(aliasOmObj);
		}
		return hqlNivelObj.toString();
	}
	
	public List<OmObj> pesquisarOmObsByOmGt(OmGt omgt) {
		MapQuery q;
		if (session != null)
			q = new MapQuery(session);
		else
			q = new MapQuery(sessionStatless);
		
		q.append("SELECT omobj");
		q.append("FROM OmObj omobj");
		q.append("left join fetch omobj.omPt ompt");
		q.append("WHERE omobj.omGtByIdGt = :omgt");
		q.defineParametro("omgt", omgt);
		return q.list();
	}

	public List<OmObj> pesquisarOmObsByCdGt(String cdGt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT a");
		q.append("  FROM OmObj a");
		q.append("  JOIN FETCH a.omPt b");
		q.append(" WHERE b.stAtivo = 1");
		q.append("   AND a.omGtByIdGt.stAtivo = 1");
		q.append("   AND a.omGtByIdGt.cdGt = :cdgt");
		q.defineParametro("cdgt", cdGt);
		return q.list();
	}
	
	public String getCdPtApontamentoByCdGt(String cdGt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT b.cdPt");
		q.append("  FROM OmObj a");
		q.append("  JOIN a.omPt b");
		q.append(" WHERE b.stAtivo = 1");
		q.append("   AND a.omGtByIdGt.stAtivo = 1");
		q.append("   AND a.omGtByIdGt.cdGt = :cdgt");
		q.append("   AND a.monitoracao = 1");
		q.setMaxResults(1);
		q.defineParametro("cdgt", cdGt);
		String cdPt = (String) q.uniqueResult();
		
		if (cdPt == null) {
			cdPt = getCdPtApontamentoByCdGtComMonitoracaoNULL(cdGt);
		}
		return cdPt;
	}

	private String getCdPtApontamentoByCdGtComMonitoracaoNULL(String cdGt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT a");
		q.append("  FROM OmObj a");
		q.append("  JOIN a.omPt b");
		q.append(" WHERE b.stAtivo = 1");
		q.append("   AND a.omGtByIdGt.stAtivo = 1");
		q.append("   AND a.omGtByIdGt.cdGt = :cdgt");
		q.append("   AND a.monitoracao IS NULL");
		q.defineParametro("cdgt", cdGt);
		
		List<OmObj> listaPts = q.list();
		listaPts = getPostosOrdenados(listaPts);
		
		String cdPt = "";
		
		if (listaPts.size() > 0) {
			cdPt = listaPts.get(listaPts.size()-1).getOmPt().getCdPt();
		}
		return cdPt;
	}	

	public OmObj getObjGt(String cdGt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT a");
		q.append("  FROM OmObj a");
		q.append(" WHERE a.omGtByIdGt.stAtivo = 1");
		q.append("   AND a.omGtByIdGt.cdGt = :cdgt");
		q.setMaxResults(1);
		q.defineParametro("cdgt", cdGt);
		
		OmObj objGT = (OmObj) q.uniqueResult();
		return objGT;
	}	

	public List<OmObj> getPostosOrdenados(List<OmObj> objs) {
		this.mapLinha = new HashMap<Integer, Double>();
		this.mapLinhaObj = new HashMap<Integer, List<OmObj>>();
		
		ordenarXCrescente(objs);
		gerarLinhasVirtuais(objs);
		ordernarYCrescentePorLinha();
		return getPostosFormatadosENumerados();
	}
	
	private void ordenarXCrescente(List<OmObj> objs) {
		Collections.sort(objs, new Comparator<OmObj>() {
		    @Override
		    public int compare(OmObj o1, OmObj o2) {
		        return o1.getX().compareTo(o2.getX());
		    }
		});
	}
	
	private void gerarLinhasVirtuais(List<OmObj> objs) {
		int linhaCount = 1;
		
		for(OmObj obj : objs) {
			
			boolean salvo = false;
			for(Integer linha : mapLinha.keySet()) {
				double min = mapLinha.get(linha);
				double max = min + TAMANHO_PIXEL_MAXIMO_LINHA;
				if(obj.getX().doubleValue() >= min && obj.getX().doubleValue() <= max) {
					add(linha, obj);
					salvo = true;
					break;
				}
			}
			
			if(!salvo) {
				mapLinha.put(linhaCount, obj.getX().doubleValue());
				add(linhaCount, obj);
				linhaCount++;
			}
		}
	}
	
	private void add(Integer linha, OmObj obj) {
		if(mapLinhaObj.get(linha) == null) {
			mapLinhaObj.put(linha, new ArrayList<OmObj>());
		}
		mapLinhaObj.get(linha).add(obj);
	}
	
	private void ordernarYCrescentePorLinha() {
		SortedSet<Integer> keys = new TreeSet<Integer>(mapLinhaObj.keySet());
		for(Integer chave : keys) {
			List<OmObj> listaFinal = mapLinhaObj.get(chave);
			
			Collections.sort(listaFinal, new Comparator<OmObj>() {
			    @Override
			    public int compare(OmObj o1, OmObj o2) {
			        return o1.getY().compareTo(o2.getY());
			    }
			});
		}
	}
	
	private List<OmObj> getPostosFormatadosENumerados() {
		List<OmObj> postos = new ArrayList<OmObj>();
		
		SortedSet<Integer> keys = new TreeSet<Integer>(mapLinhaObj.keySet());
		for(Integer chave : keys) {
			
			List<OmObj> lista = mapLinhaObj.get(chave);
			for(OmObj obj : lista) {
				OmObj posto = new OmObj();
				posto = obj;
				postos.add(posto);
			}
		}
		
		return postos;
	}
		
}