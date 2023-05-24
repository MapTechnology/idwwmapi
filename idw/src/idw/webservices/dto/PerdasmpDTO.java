package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.pojos.DwConsolperdamplog;
import idw.model.pojos.DwRap;
import idw.model.pojos.DwTPerdamp;
import idw.model.pojos.OmMapapa;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;

public class PerdasmpDTO {
	
	private String corBarra;
	private String cdUP;
	private OmPt omPt;
	private DwRap dwRap;
	private DwTPerdamp dwTPerdamp;
	private OmProduto omproduto;
	private BigDecimal preco = BigDecimal.ZERO;
	private Double quantidade;
	private Double quantidadeUtilizada;
	private Double indiceDePerda;
	private Double quantidadePrevistaOP;
	private Double indiceDePerdaOP;
	private Double quantidadeAlimentacao;
	private Double indiceDePerdaAlimentacao;
	private Double consumoPorCiclo;
	private Double qtCiclosExecutados;
	private List<String> cdsRaps;
	private List<DwConsolperdamplog> logs;
	private OmMapapa ommapapa;
	
	private transient Map<Date, Integer> dthr_perda = new HashMap<>();
	
	
	public String getCorBarra() {
		return corBarra;
	}
	public void setCorBarra(String corBarra) {
		this.corBarra = corBarra;
	}
	public DwRap getDwRap() {
		return dwRap;
	}
	public void setDwRap(DwRap dwRap) {
		this.dwRap = dwRap;
	}
	public DwTPerdamp getDwTPerdamp() {
		return dwTPerdamp;
	}
	public void setDwTPerdamp(DwTPerdamp dwTPerdamp) {
		this.dwTPerdamp = dwTPerdamp;
	}
	public OmProduto getOmproduto() {
		return omproduto;
	}
	public void setOmproduto(OmProduto omproduto) {
		this.omproduto = omproduto;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	public Double getIndiceDePerda() {
		return indiceDePerda;
	}
	public void setIndiceDePerda(Double indiceDePerda) {
		this.indiceDePerda = indiceDePerda;
	}
	public List<String> getCdsRaps() {
		return cdsRaps;
	}
	public void setCdsRaps(List<String> cdsRaps) {
		this.cdsRaps = cdsRaps;
	}
	public String getCdUP() {
		return cdUP;
	}
	public void setCdUP(String cdUP) {
		this.cdUP = cdUP;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public OmPt getOmPt() {
		return omPt;
	}
	public void setOmPt(OmPt omPt) {
		this.omPt = omPt;
	}
	public List<DwConsolperdamplog> getLogs() {
		return logs;
	}
	public void setLogs(List<DwConsolperdamplog> logs) {
		this.logs = logs;
	}
	public Double getQuantidadeUtilizada() {
		return quantidadeUtilizada;
	}
	public void setQuantidadeUtilizada(Double quantidadeUtilizada) {
		this.quantidadeUtilizada = quantidadeUtilizada;
	}
	public Double getQuantidadePrevistaOP() {
		return quantidadePrevistaOP;
	}
	public void setQuantidadePrevistaOP(Double quantidadePrevistaOP) {
		this.quantidadePrevistaOP = quantidadePrevistaOP;
	}
	public Double getIndiceDePerdaOP() {
		return indiceDePerdaOP;
	}
	public void setIndiceDePerdaOP(Double indiceDePerdaOP) {
		this.indiceDePerdaOP = indiceDePerdaOP;
	}
	public Double getQuantidadeAlimentacao() {
		return quantidadeAlimentacao;
	}
	public void setQuantidadeAlimentacao(Double quantidadeAlimentacao) {
		this.quantidadeAlimentacao = quantidadeAlimentacao;
	}
	public Double getIndiceDePerdaAlimentacao() {
		return indiceDePerdaAlimentacao;
	}
	public void setIndiceDePerdaAlimentacao(Double indiceDePerdaAlimentacao) {
		this.indiceDePerdaAlimentacao = indiceDePerdaAlimentacao;
	}
	public Double getConsumoPorCiclo() {
		return consumoPorCiclo;
	}
	public void setConsumoPorCiclo(Double consumoPorCiclo) {
		this.consumoPorCiclo = consumoPorCiclo;
	}
	public OmMapapa getOmmapapa() {
		return ommapapa;
	}
	public void setOmmapapa(OmMapapa ommapapa) {
		this.ommapapa = ommapapa;
	}
	
	public boolean incluirDthr(Date dthr, String componente, Integer qtde) {
		if (this.dthr_perda.containsKey(dthr)) {
			Integer qtdeAnt = this.dthr_perda.get(dthr);
			Integer qteSal = qtdeAnt;
			
			// se a nova quantidade for maior, entao acumular
			if (qtde > qtdeAnt) {
				Integer qtdeNova = qtde - qtdeAnt; // calcula a diferenca para realizar o acumulo na qtde atual. Nao se pode apenas substituir pois pode haver outros horarios
				this.quantidade += (double) qtdeNova;
				this.dthr_perda.put(dthr, qtde);
				if (componente.contains("652130"))
					System.out.println("..add: " + componente + " - " + DataHoraRN.dateToStringYYYYDDMMHHMMSS(dthr) + " " + qtdeNova + " antes era " + qtde);
			}
			if (componente.contains("652130"))
				System.out.println("descartando: " + componente + " - " + DataHoraRN.dateToStringYYYYDDMMHHMMSS(dthr) + " qtdeAnt: " + qteSal + " qtde: " + qtde);
			
			
			return false;
		}
		if (componente.contains("652130"))
			System.out.println("incluindo: " + componente + " - " + DataHoraRN.dateToStringYYYYDDMMHHMMSS(dthr) + " " + qtde);
		
		this.dthr_perda.put(dthr, qtde);
		return true;
	}
	public Double getQtCiclosExecutados() {
		return qtCiclosExecutados;
	}
	public void setQtCiclosExecutados(Double qtCiclosExecutados) {
		this.qtCiclosExecutados = qtCiclosExecutados;
	}
	
	
}
