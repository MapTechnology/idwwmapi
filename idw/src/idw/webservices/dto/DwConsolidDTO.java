package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.DwConsol;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwConsolrelog;

@SuppressWarnings("serial")
public class DwConsolidDTO implements Serializable{

	
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_DESCONHECIDO = 1;
	private int ERRO_FOLHA_DESCONHECIDA = 2;
	private int ERRO_PT_DESCONHECIDO = 3;
	private int ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA = 4;
	
	private int resultado;
	private int isProducao = 0;
	private DwConsolid dwConsolid;

	private List<DwFolhaDTO> listaProgramas;
	private double lie;
	private double lse;
	private double eficienciaCiclo;
	
	private List<DwConsolidDTO> idsHoraAHora = new ArrayList<>(); // Usado para armazenar registros hora a hora para o apontamento maual
	
	
	// lista de refugos alterados pelo apontamento manual de refugo
	List<DwConsolrelog> refugosAlterados = new ArrayList<>();
	
	public List<DwConsolrelog> getRefugosAlterados() {
		return refugosAlterados;
	}
	public void setRefugosAlterados(List<DwConsolrelog> refugosAlterados) {
		this.refugosAlterados = refugosAlterados;
	}
	public double getEficienciaCiclo() {
		return eficienciaCiclo;
	}
	public void setEficienciaCiclo(double eficienciaCiclo) {
		this.eficienciaCiclo = eficienciaCiclo;
	}
	public double getLie() {
		return lie;
	}
	public void setLie(double lie) {
		this.lie = lie;
	}
	public double getLse() {
		return lse;
	}
	public void setLse(double lse) {
		this.lse = lse;
	}
	public int getERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA() {
		return ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA;
	}
	public void setERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA(
			int eRROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA) {
		ERROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA = eRROR_FOLHA_NAO_POSSUI_FOLHAIAC_CADASTRADA;
	}
	public void setDwConsolid(DwConsolid dwConsolid) {
		this.dwConsolid = dwConsolid;
	}
	public DwConsolid getDwConsolid() {
		return dwConsolid;
	}
	public void setEVENTO_BEM_SUCEDIDO(int eVENTO_BEM_SUCEDIDO) {
		EVENTO_BEM_SUCEDIDO = eVENTO_BEM_SUCEDIDO;
	}
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setERRO_DESCONHECIDO(int eRRO_DESCONHECIDO) {
		ERRO_DESCONHECIDO = eRRO_DESCONHECIDO;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public int getResultado() {
		return resultado;
	}
	public void setListaProgramas(List<DwFolhaDTO> listaProgramas) {
		this.listaProgramas = listaProgramas;
	}
	public List<DwFolhaDTO> getListaProgramas() {
		return listaProgramas;
	}
	public void setIsProducao(int isProducao) {
		this.isProducao = isProducao;
	}
	public int getIsProducao() {
		return isProducao;
	}
	public int getERRO_FOLHA_DESCONHECIDA() {
		return ERRO_FOLHA_DESCONHECIDA;
	}
	public void setERRO_FOLHA_DESCONHECIDA(int eRRO_FOLHA_DESCONHECIDA) {
		ERRO_FOLHA_DESCONHECIDA = eRRO_FOLHA_DESCONHECIDA;
	}
	public int getERRO_PT_DESCONHECIDO() {
		return ERRO_PT_DESCONHECIDO;
	}
	public void setERRO_PT_DESCONHECIDO(int eRRO_PT_DESCONHECIDO) {
		ERRO_PT_DESCONHECIDO = eRRO_PT_DESCONHECIDO;
	}
	public List<DwConsolidDTO> getIdsHoraAHora() {
		return idsHoraAHora;
	}
	public void setIdsHoraAHora(List<DwConsolidDTO> idsHoraAHora) {
		this.idsHoraAHora = idsHoraAHora;
	}
	
	
	public void addDTO(DwConsolidDTO dto) {
		DwConsol dwconsol = this.getDwConsolid().getDwConsol();
		DwConsol add = dto.getDwConsolid().getDwConsol();

//		BigDecimal pbAnt = dwconsol.getPcsAutoProducaoliquida();
//		BigDecimal pbMai = add.getPcsAutoProducaoliquida();
//		BigDecimal soma = AritmeticaUtil.somar(pbAnt, pbMai);

		dwconsol.addDwConsol(add);
		
		
//		System.out.println(DataHoraRN.dateToStringDDMMYYYYHHMMSS(this.getDwConsolid().getDthrIhora()) + "ant=" + pbAnt + " mais=" + pbMai + " result=" + soma + " soma.gravada=" + dwconsol.getPcsAutoProducaoliquida() );

	}
	
	@Override
	public boolean equals(Object value) {
		DwConsolidDTO id = (DwConsolidDTO) value;
		boolean isRetorno = false;
		if (this.getDwConsolid() != null && this.getDwConsolid().getDthrIhora() != null && id.getDwConsolid() != null && id.getDwConsolid().getDthrIhora() != null) 
			isRetorno = this.getDwConsolid().getDthrIhora().equals(id.getDwConsolid().getDthrIhora());
		
		return isRetorno;
	}
}
