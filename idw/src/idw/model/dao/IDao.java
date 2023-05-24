package idw.model.dao;

import org.hibernate.Session;

public interface IDao {
	public void iniciaConexaoBanco(Session sessao);
	public void finalizaConexaoBanco();
}
