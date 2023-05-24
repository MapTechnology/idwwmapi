package idw.builders;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.PpCliente;

public class PpClienteBuilder  extends AbstractPojoPersistentBuilder<PpCliente, DAOGenericoTest>{

	private String cdCliente = BuilderDefaults.CODIGO;
	private byte stAtivo = BuilderDefaults.ST_ATIVO;
	private Long revisao = BuilderDefaults.REVISAO;
	
	public PpClienteBuilder withCdCliente(String cdCliente){
		this.cdCliente = cdCliente;
		return this;
	}
	
	public PpClienteBuilder withStAtivo(byte stAtivo){
		this.stAtivo = stAtivo;
		return this;
	}
	
	public PpClienteBuilder withRevisao(Long revisao){
		this.revisao = revisao;
		return this;
	}
	
	@Override
	public PpCliente build() {
		PpCliente cliente = new PpCliente();
		cliente.setCdCliente(cdCliente);
		cliente.setStAtivo(stAtivo);
		cliente.setRevisao(revisao);
		return cliente;
	}

}
