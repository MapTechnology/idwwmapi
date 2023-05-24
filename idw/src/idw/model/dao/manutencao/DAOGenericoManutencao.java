package idw.model.dao.manutencao;

import java.util.List;

import org.hibernate.SessionFactory;

import idw.model.dao.AbstractDAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.pojos.manutencao.ServidorOrdemmanutencao;

public class DAOGenericoManutencao extends AbstractDAOGenerico{
	@Override
	protected SessionFactory getSessionFactory(){
    	return HibernateUtilManutencao.getSessionFactory();
    }
	
	
	/* Teste de conexao ao banco */
	public static void main(String[] args) {
		DAOGenericoManutencao dao = new DAOGenericoManutencao();
		
		dao.iniciaConexaoBanco();
		
		
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select a");
		q.append("from ServidorOrdemmanutencao a");
		q.append("join fetch a.servidorAtividades b");
		q.append("join fetch a.servidorConjuntos c");
//		q.append("where a.tipo = 1");

//		q.append("select a");
//		q.append("from ServidorAtividadesordem a");
		
		List<ServidorOrdemmanutencao> lista = q.list();
//		List<ServidorAtividadesordem> lista = q.list();
		
		System.out.println("size=" + lista.size());
		for (ServidorOrdemmanutencao reg : lista) {
			System.out.println(reg.getId() + " - " + reg.getDescricao() + " - " + reg.getDatacriacao() + reg.getServidorConjuntos().getNome());
		}
		dao.finalizaConexaoBanco();
	}
}