package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.DwConsolid;
import idw.model.pojos.TtSapEstmppa;
import idw.model.rn.DataHoraRN;

/**
*
* @author fredson
*/
@SuppressWarnings("serial")
public class SapEstoqueDTO implements Serializable  {

	private TtSapEstmppa sapestoque;
    private int resultadoEvento;
    private boolean isAjustarEstoque = true; // se false o estoque sera acumulado (contagem de producao)
    private DwConsolid dwconsolid;
    private boolean isFechamentoMes = false;

    @Override
    public String toString(){
    	return sapestoque.getGlobalcode() + " - " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(sapestoque.getDthrReferencia()) + " - " + sapestoque.getQtEstoque();
    }
	public boolean isAjustarEstoque() {
		return isAjustarEstoque;
	}
	public void setAjustarEstoque(boolean isAjustarEstoque) {
		this.isAjustarEstoque = isAjustarEstoque;
	}
	public TtSapEstmppa getSapestoque() {
		return sapestoque;
	}
	public void setSapestoque(TtSapEstmppa sapestoque) {
		this.sapestoque = sapestoque;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public DwConsolid getDwconsolid() {
		return dwconsolid;
	}
	public void setDwconsolid(DwConsolid dwconsolid) {
		this.dwconsolid = dwconsolid;
	}
	public boolean isFechamentoMes() {
		return isFechamentoMes;
	}
	public void setFechamentoMes(boolean isFechamentoMes) {
		this.isFechamentoMes = isFechamentoMes;
	}

}
