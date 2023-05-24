package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.PpCliente;

public class PpClienteDAO {
	
	private Session session;
	
	public PpClienteDAO(Session session){
		this.session = session;
	}
	
	public PpCliente getPpClientePorCdAtivo(String cdCliente){
		MapQuery q = new MapQuery(session);
		q.append("FROM PpCliente cliente");
		q.append("WHERE cliente.cdCliente = :cdcliente");
		q.append("AND cliente.stAtivo = :stAtivo");
		q.defineParametro("cdcliente", cdCliente);
		q.defineParametro("stAtivo", (byte)1);
		q.setMaxResults(1);
		return (PpCliente) q.uniqueResult();
	}

	public List<PpCliente> getPpClienteAtivoPorCdOuNm(String cdCliente, String nmCliente) {
		MapQuery q = new MapQuery(session);
		q.append("FROM PpCliente cliente");
		q.append("WHERE cliente.stAtivo = :stAtivo");
		if (cdCliente != null && nmCliente != null && !cdCliente.equals("") && !nmCliente.equals("")) {
			q.append("AND ( cliente.cdCliente = :cdCliente OR cliente.nmCliente = :nmCliente )");
		} else if (cdCliente != null && !cdCliente.equals("")) {
			q.append("AND cliente.cdCliente = :cdCliente");
		} else if (nmCliente != null && !nmCliente.equals("")) {
			q.append("AND cliente.nmCliente = :nmCliente");
		}
		q.defineParametro("stAtivo", (byte)1);
		q.defineParametro("cdCliente", cdCliente);
		q.defineParametro("nmCliente", nmCliente);
		return q.list();
	}
	
	public List<PpCliente> getPpClienteAtivoPorCdNmOuPedido(String cdCliente, String nmCliente, Long idPedido) {
		MapQuery q = new MapQuery(session);
		q.append("SELECT cliente");
		q.append("FROM PpNec pedido");
		q.append("JOIN pedido.ppCliente cliente");
		q.append("WHERE pedido.stAtivo = :pedidoAtivo");
		q.append("AND cliente.stAtivo = :clienteAtivo");
		if (cdCliente != null && nmCliente != null && !cdCliente.equals("") && !nmCliente.equals("")) {
			q.append("AND ( cliente.cdCliente = :cdCliente OR cliente.nmCliente = :nmCliente )");
		} else if (cdCliente != null && !cdCliente.equals("")) {
			q.append("AND cliente.cdCliente = :cdCliente");
		} else if (nmCliente != null && !nmCliente.equals("")) {
			q.append("AND cliente.nmCliente = :nmCliente");
		}
		if(idPedido != null && idPedido != 0){
			q.append("AND pedido.idNec = :idPedido");
			q.defineParametro("idPedido", idPedido);
		}
		q.defineParametro("pedidoAtivo", 1);
		q.defineParametro("clienteAtivo", (byte)1);
		q.defineParametro("cdCliente", cdCliente);
		q.defineParametro("nmCliente", nmCliente);
		return q.list();
	}
	
}