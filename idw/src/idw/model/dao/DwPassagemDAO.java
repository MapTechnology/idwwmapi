package idw.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPassmon;
import idw.model.rn.DataHoraRN;

public class DwPassagemDAO {
	private final Session session;

	public DwPassagemDAO(Session session) {
		this.session = session;
	}

	public DwPassagem getUltimoResultadoByCbEPt(String codigoBarras, String cdPt, boolean isFetchOmPt) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT dwPassagem FROM DwPassagem dwPassagem");
		q.append("JOIN").append(isFetchOmPt ? "FETCH" : "").append("dwPassagem.omPt omPt");
		q.append("JOIN dwPassagem.dwNserie dwNserie");
		q.append("WHERE dwNserie.cb = :codigoBarras");
		q.append("and omPt.cdPt = :cdPt");
		q.append("ORDER BY dwPassagem.idPassagem DESC");
		q.defineParametro("codigoBarras", codigoBarras);
		q.defineParametro("cdPt", cdPt);
		q.setMaxResults(1);
		return (DwPassagem) q.uniqueResult();
	}

	// Esse metodo deve retornar as passagens do codigoBarras e as passagens dos itens que foram montados nesse codigoBarras
	// Alessandre em 28-11-2018. Alem disso deve retornar onde o codigo de cbarras foi montado
	public List<DwPassagem> getPassagens(String codigoBarras) {
		MapQuery q = new MapQuery(session);

		// Select abaixo retorna as passagens diretas do codigo de barras
		q.append("SELECT distinct dwPassagem");
		q.append("from DwPassagem dwPassagem");
		q.append("JOIN FETCH dwPassagem.omPt omPt");
		q.append("JOIN fetch omPt.omTppt omTppt");
		q.append("JOIN fetch dwPassagem.dwNserie dwNserie");
		q.append("WHERE dwNserie.cb = :codigoBarras");
		q.append("ORDER BY dwPassagem.dthr DESC");
		q.defineParametro("codigoBarras", codigoBarras);
		q.setMaxResults(50);
		List<DwPassagem> retorno = q.list();
		

		// O select abaixo retorna as montagens do codigo de barras
		MapQuery q2 = new MapQuery(session);
		q2.append("SELECT distinct dwPassagem");
		q2.append(" FROM DwPassagem dwPassagem");
		q2.append("JOIN FETCH dwPassagem.omPt omPt");
		q2.append("JOIN fetch omPt.omTppt omTppt");
		q2.append("JOIN fetch dwPassagem.dwNserie dwNserie");
		q2.append("join fetch dwPassagem.dwPassmons dwpassmon");
		q2.append("where dwNserie.cb = :codigoBarras");
		q2.append("ORDER BY dwPassagem.dthr DESC");
		q2.defineParametro("codigoBarras", codigoBarras);
		q2.setMaxResults(50);
		List<DwPassagem> retorno2 = q2.list();


		// O select abaixo retorna os numeros de series que possuem o codigo de barras passado como montagem
		MapQuery q3 = new MapQuery(session);
		q3.append("select distinct a");
		q3.append("from DwPassagem a");
		q3.append("join fetch a.omPt b");
		q3.append("join fetch b.omTppt c");
		q3.append("join fetch a.dwNserie d");
		q3.append("join fetch a.dwPassmons e");
		q3.append("where e.cb =:codigoBarras");
		// q3.append("and d.cb <> :codigoBarras");
		q3.append("order by a.dthr desc");
		q3.defineParametro("codigoBarras", codigoBarras);
		q3.setMaxResults(50);
		List<DwPassagem> retorno3 = q3.list();
		


		// Para cada item montado obter as passagens
		List<DwPassagem> lista = new ArrayList<>();
		for (DwPassagem dwpassagem : retorno2) {
			for (DwPassmon mon : dwpassagem.getDwPassmons()) {
				q.defineParametro("codigoBarras", mon.getCb());
				List<DwPassagem> montados = q.list();
				
				lista.addAll(montados);
			}
		}

		// Para cada item que possue o codigo de barras como item montado, obter as passagens
		List<DwPassagem> lista2 = new ArrayList<>();
		for (DwPassagem dwpassagem : retorno3) {
			q.defineParametro("codigoBarras", dwpassagem.getDwNserie().getCb());
			List<DwPassagem> montados = q.list();
			lista2.addAll(montados);
		}
		// Vou pegar mais um nivel acima mas o ideal eh implementar uma pesquisa recursiva
		List<DwPassagem> lista3 = new ArrayList<>();
		for (DwPassagem dwpassagem : lista2) {
			q2.defineParametro("codigoBarras", dwpassagem.getDwNserie().getCb());
			List<DwPassagem> montados = q.list();
			lista3.addAll(montados);
		}
		

		for (DwPassagem paux : lista) {
			boolean isExiste = false;
			for (DwPassagem raux : retorno) {
				if (DataHoraRN.equal(raux.getDthr(), paux.getDthr())  && raux.getOmPt().getIdPt().equals(paux.getOmPt().getIdPt())) {
					isExiste = true;
					break;
				}
			}
			if (isExiste == false) {
				retorno.add(paux);
			}
		}
		
		// Adicionar apenas os que não existem
		for (DwPassagem paux : lista2) {
			boolean isExiste = false;
			for (DwPassagem raux : retorno) {
				if (DataHoraRN.equal(raux.getDthr(), paux.getDthr())  && raux.getOmPt().getIdPt().equals(paux.getOmPt().getIdPt())) {
					isExiste = true;
					break;
				}
			}
			if (isExiste == false) {
				retorno.add(paux);
			}
		}

		for (DwPassagem paux : lista3) {
			boolean isExiste = false;
			for (DwPassagem raux : retorno) {
				if (DataHoraRN.equal(raux.getDthr(), paux.getDthr()) && raux.getOmPt().getIdPt().equals(paux.getOmPt().getIdPt())) {
					isExiste = true;
					break;
				}
			}
			if (isExiste == false) {
				retorno.add(paux);
			}
		}

		Collections.sort(retorno, new Comparator<DwPassagem>() {

			@Override
			public int compare(DwPassagem o1, DwPassagem o2) {
				Long id1 = o1.getIdPassagem();
				Long id2 = o2.getIdPassagem();
				return id1.compareTo(id2) * -1;
			}
		});

		return retorno;
	}

}
