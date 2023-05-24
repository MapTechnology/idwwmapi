package idw.webservices.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.pojos.OmProduto;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpNec;
import idw.model.rn.geraplano.dtos.PassosDTO;

public class PlanoAcompanhamentoDTO {
	
	private PlanoDTO planoDTO;
	private Long idRota;
	private int idPasso;
	private PpCp ppcp;
	private String cnt;
    private String semiProduto;
    private String descricao;
    private String placa;
    private BigDecimal passo;
    private Long kitTotal;
    private BigDecimal saldoAnterior;
    private Long produzidoMes;
    private Long aProduzirCpsAtuais;
    private Long disponivelProduzir;
    private Double faltaSobra;
    private Double producaoTotal;
    private Integer qtdeProducaoSimulacao;
    private Double somaPlanejada;
    private List<DadosDiaPlanProdDTO> dias = new ArrayList<DadosDiaPlanProdDTO>();
    private Integer mesReferencia;
    private Integer anoReferencia;
    private Integer diaReferencia;
    private int corFrente;
    private int corFundo;
    private List<PpNec> listaPpnec = new ArrayList<PpNec>();
    private boolean isUltimoPasso;
    private Integer saldoRealEstoque;  // o saldo real do estoque serve apenas para a geracao das Ops, a diferenca para o campo kit total � que ele nao possui
    									// o estoque acumulativo do pai
    
    // atributos que nao irao para o cliente ws
    private transient OmProduto omproduto;
    
    public PlanoAcompanhamentoDTO(){
    	for (int i = 0; i<=31; i++){
    		this.dias.add(null);
    	}
    }
    public PlanoAcompanhamentoDTO(PassosDTO passo){
    	this();
    	this.semiProduto = passo.getOmproduto().getOmproduto().getCdProduto();
    	this.descricao = passo.getOmproduto().getOmproduto().getDsProduto();
    	this.placa = passo.getOmproduto().getOmproduto().getDsCurta();
    	this.setPasso(passo.getDwrotapasso().getPasso());
    	this.setProduzidoMes(0l);
    	this.setQtdeProducaoSimulacao(0);
    	if (passo.getOmproduto().getOmproduto().getPpCliente() != null)
    		this.setCnt(passo.getOmproduto().getOmproduto().getPpCliente().getCdCliente());
    	else
    		this.setCnt("-");
    	
    	this.setIdRota(passo.getDwrota().getIdRota());
    	this.mudaOmproduto(passo.getOmproduto().getOmproduto());
    	this.setUltimoPasso(passo.isEoUltimoDoRoteiro());
    }
    
    @Override
    public String toString() {
    	return this.cnt;
    }
    
    public Integer getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(Integer mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	public Integer getAnoReferencia() {
		return anoReferencia;
	}
	public void setAnoReferencia(Integer anoReferencia) {
		this.anoReferencia = anoReferencia;
	}
	public PpCp getPpcp() {
		return ppcp;
	}
	public void setPpcp(PpCp ppcp) {
		this.ppcp = ppcp;
	}
	public String getCnt() {
		if((cnt != null) && (!cnt.isEmpty())) {
			return this.toString();
		}
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getSemiProduto() {
		return semiProduto;
	}
	public void setSemiProduto(String semiProduto) {
		this.semiProduto = semiProduto;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public BigDecimal getPasso() {
		return passo;
	}
	public void setPasso(BigDecimal passo) {
		this.passo = passo;
	}
	public Long getKitTotal() {
		return kitTotal;
	}
	public void setKitTotal(Long kitTotal) {
		this.kitTotal = kitTotal;
	}
	public BigDecimal getSaldoAnterior() {
		return saldoAnterior;
	}
	public void setSaldoAnterior(BigDecimal saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	public Long getProduzidoMes() {
		return produzidoMes;
	}
	public void setProduzidoMes(Long produzidoMes) {
		this.produzidoMes = produzidoMes;
	}
	public Long getDisponivelProduzir() {
		return disponivelProduzir;
	}
	public void setDisponivelProduzir(Long disponivelProduzir) {
		this.disponivelProduzir = disponivelProduzir;
	}
	public Double getFaltaSobra() {
		return faltaSobra;
	}
	public void setFaltaSobra(Double faltaSobra) {
		this.faltaSobra = faltaSobra;
	}
	public Double getProducaoTotal() {
		return producaoTotal;
	}
	public void setProducaoTotal(Double producaoTotal) {
		this.producaoTotal = producaoTotal;
	}
	public Integer getQtdeProducaoSimulacao() {
		return qtdeProducaoSimulacao;
	}
	public void setQtdeProducaoSimulacao(Integer qtdeProducaoSimulacao) {
		this.qtdeProducaoSimulacao = qtdeProducaoSimulacao;
	}
	public Double getSomaPlanejada() {
		return somaPlanejada;
	}
	public void setSomaPlanejada(Double somaPlanejada) {
		this.somaPlanejada = somaPlanejada;
	}
	public List<DadosDiaPlanProdDTO> getDias() {
		return dias;
	}
	public void setDias(List<DadosDiaPlanProdDTO> dias) {
		this.dias = dias;
	}
	public void setPlanoDTO(PlanoDTO planoDTO) {
		this.planoDTO = planoDTO;
	}
	public PlanoDTO getPlanoDTO() {
		return planoDTO;
	}
	public void setDiaReferencia(Integer diaReferencia) {
		this.diaReferencia = diaReferencia;
	}
	public Integer getDiaReferencia() {
		return diaReferencia;
	}
	public Long getIdRota() {
		return idRota;
	}
	public void setIdRota(Long idRota) {
		this.idRota = idRota;
	}
	public int getIdPasso() {
		return idPasso;
	}
	public void setIdPasso(int idPasso) {
		this.idPasso = idPasso;
	}
	public OmProduto obtemOmproduto() {
		return omproduto;
	}
	public void mudaOmproduto(OmProduto omproduto) {
		this.omproduto = omproduto;
	}
	public int getCorFrente() {
		return corFrente;
	}
	public void setCorFrente(int corFrente) {
		this.corFrente = corFrente;
	}
	public int getCorFundo() {
		return corFundo;
	}
	public void setCorFundo(int corFundo) {
		this.corFundo = corFundo;
	}
	public List<PpNec> getListaPpnec() {
		return listaPpnec;
	}
	public void setListaPpnec(List<PpNec> litaPpnec) {
		this.listaPpnec = litaPpnec;
	}
	
	public void addProducaoPlanejadaNoDia(int dia, DadosDiaPlanProdDTO diadto){
		dia--; // para compatibilizar com o indice do vetor
		DadosDiaPlanProdDTO diarec = this.dias.get(dia);
		if (diarec == null) {
			this.dias.set(dia, diadto);
		} else {
			diarec.setValorDia(diarec.getValorDia() + diadto.getValorDia());
			this.dias.set(dia, diarec);
		}
	}
	public boolean isUltimoPasso() {
		return isUltimoPasso;
	}
	public void setUltimoPasso(boolean isUltimoPasso) {
		this.isUltimoPasso = isUltimoPasso;
	}
	public Integer getSaldoRealEstoque() {
		return saldoRealEstoque;
	}
	public void setSaldoRealEstoque(Integer saldoRealEstoque) {
		this.saldoRealEstoque = saldoRealEstoque;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getaProduzirCpsAtuais() {
		return aProduzirCpsAtuais;
	}
	public void setaProduzirCpsAtuais(Long aProduzirCpsAtuais) {
		this.aProduzirCpsAtuais = aProduzirCpsAtuais;
	}
}
