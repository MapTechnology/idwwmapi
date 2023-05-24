package idw.builders;

import java.math.BigDecimal;

import idw.model.dao.DAOGenericoTest;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.DwEstlocalpro;
import idw.model.pojos.DwEstpro;
import idw.model.pojos.PpCp;

public class DwEstlocalproBuilder extends AbstractPojoPersistentBuilder<DwEstlocalpro, DAOGenericoTest>{

	private DwEstlocal dwEstlocal = new DwEstlocalBuilder().build();
	private DwEstpro dwEstpro = new DwEstproBuilder().build();
	private PpCp ppCp = new PpCpBuilder().build();
	private BigDecimal qtAjuste = BuilderDefaults.QUANTIDADE;
	private BigDecimal qtEntrada = BuilderDefaults.QUANTIDADE;
	private BigDecimal qtSaida = BuilderDefaults.QUANTIDADE;
	private BigDecimal qtTotal = BuilderDefaults.QUANTIDADE;
	
	public DwEstlocalproBuilder withDwEstlocal(DwEstlocal dwEstlocal){
		this.dwEstlocal = dwEstlocal;
		return this;
	}
	
	public DwEstlocalproBuilder withDwEstpro(DwEstpro dwEstpro){
		this.dwEstpro = dwEstpro;
		return this;
	}
	
	public DwEstlocalproBuilder withPpCp(PpCp ppCp){
		this.ppCp = ppCp;
		return this;
	}
	
	//
	
	public DwEstlocalproBuilder withQtAjuste(BigDecimal qtAjuste){
		this.qtAjuste = qtAjuste;
		return this;
	}
	
	public DwEstlocalproBuilder withQtEntrada(BigDecimal qtEntrada){
		this.qtEntrada = qtEntrada;
		return this;
	}
	
	public DwEstlocalproBuilder withQtSaida(BigDecimal qtSaida){
		this.qtSaida = qtSaida;
		return this;
	}
	
	public DwEstlocalproBuilder withQtTotal(BigDecimal qtTotal){
		this.qtTotal = qtTotal;
		return this;
	}
	
	@Override
	public DwEstlocalpro build() {
		DwEstlocalpro estlocalpro = new DwEstlocalpro();
		estlocalpro.setDwEstlocal(dwEstlocal);
		estlocalpro.setDwEstpro(dwEstpro);
		estlocalpro.setPpCp(ppCp);
		estlocalpro.setQtAjuste(qtAjuste);
		estlocalpro.setQtEntrada(qtEntrada);
		estlocalpro.setQtSaida(qtSaida);
		estlocalpro.setQtTotal(qtTotal);
		return estlocalpro;
	}

}