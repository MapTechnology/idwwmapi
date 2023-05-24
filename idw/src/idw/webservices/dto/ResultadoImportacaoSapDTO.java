package idw.webservices.dto;

import java.io.Serializable;

/**
*
* @author fredson
*/
@SuppressWarnings("serial")
public class ResultadoImportacaoSapDTO implements Serializable  {

	private int resultadoEvento;

	private SapEstoquesDTO sapestoquesdto;
    private SapConhecimentosDTO sapconhecimentosdto;
    private TmgConhecimentosDTO tmgconhecimentosdto;

    public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public SapEstoquesDTO getSapestoquesdto() {
		return sapestoquesdto;
	}
	public void setSapestoquesdto(SapEstoquesDTO sapestoquesdto) {
		this.sapestoquesdto = sapestoquesdto;
	}
	public SapConhecimentosDTO getSapconhecimentosdto() {
		return sapconhecimentosdto;
	}
	public void setSapconhecimentosdto(SapConhecimentosDTO sapconhecimentosdto) {
		this.sapconhecimentosdto = sapconhecimentosdto;
	}
	public TmgConhecimentosDTO getTmgconhecimentosdto() {
		return tmgconhecimentosdto;
	}
	public void setTmgconhecimentosdto(TmgConhecimentosDTO tmgconhecimentosdto) {
		this.tmgconhecimentosdto = tmgconhecimentosdto;
	}

}
