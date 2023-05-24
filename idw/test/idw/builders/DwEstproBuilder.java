package idw.builders;

import java.math.BigDecimal;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCliente;

public class DwEstproBuilder  extends AbstractPojoPersistentBuilder<DwEstpro, DAOGenericoTest> {
	
	private DwEst dwEst = new  DwEstBuilder().build();
	private BigDecimal qtEntrada = BuilderDefaults.QUANTIDADE;
	private OmProduto omProduto = new OmProdutoBuilder().build();
	private PpCliente ppCliente = new PpClienteBuilder().build();
	
	public DwEstproBuilder withDwEst(DwEst dwEst){
		this.dwEst = dwEst;
		return this;
	}
	
	public DwEstproBuilder withQtEntrada(BigDecimal qtEntrada){
		this.qtEntrada = qtEntrada;
		return this;
	}
	
	public DwEstproBuilder withOmProduto(OmProduto omProduto){
		this.omProduto = omProduto;
		return this;
	}
	
	public DwEstproBuilder withPpCliente(PpCliente ppCliente){
		this.ppCliente = ppCliente;
		return this;
	}
	
	@Override
	public DwEstpro build() {
		DwEstpro dwEstpro = new DwEstpro(); 
		dwEstpro.setDwEst(dwEst);
		dwEstpro.setQtEntrada(qtEntrada);
		dwEstpro.setOmProduto(omProduto);
		dwEstpro.setPpCliente(ppCliente);
		return dwEstpro;
	}

}