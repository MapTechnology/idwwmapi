package idw.webservices.dto;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.OmObj;

@SuppressWarnings("serial")
public class ObjRtMonitorizacaoDTO implements Serializable {
	
	private boolean isDentroDaMeta;
	private boolean isParada;
	private boolean isParadaExtrapolada;
	private boolean isOffline;
	private boolean isTemOmCfg;
	private boolean isTemOmAlgocor;
	private boolean isTemDwRt;
	private boolean isCIP;
	private boolean isCIPExtrapolado;
	private Double x;
	private Double y;
	private Date dtReferencia;
	private boolean isTemOperador;
	private boolean isTemPlanejamento;
	private boolean isParadaComPeso;
	private boolean isSaidaDaCelula;
	private boolean isGargaloTeorico;
	private boolean isGargaloDinamico;
	private boolean isParadaManutencao;
	private boolean isOpConcluida;
	private boolean isOpConcluida90PorCento;
	private boolean isComAlerta;
	private boolean isParadaNaoInformada;
	private boolean isParadaSemPesoEfic;
	private boolean isIndiceRefugo3porCento;
	private boolean isAlertaVidaUtil;
	private boolean isPerdaSincronismo;
	private boolean isManutencaoPrev;
	private boolean isConsolidacaoPendente;
	private boolean isPerdaSinc;
	
	private int tipoAlgoritmo;
	private int tipoObj;
	private Double x2;
	private Double y2;
	
	
	private OmObj omobj;
	
	private List<DwConsolmolog> dwConsolmologs = new ArrayList<DwConsolmolog>();

	private ColorDTO corFundo;
	private ColorDTO COR_FUNDO_OFFLINE = new ColorDTO(Color.GRAY);
	private ColorDTO COR_FUNDO_DENTRO_META = new ColorDTO(Color.GREEN);
	private ColorDTO COR_FUNDO_FORA_META = new ColorDTO(Color.RED);
	private ColorDTO COR_FUNDO_PARADA = new ColorDTO(Color.YELLOW);
	public static final int ALG_WHP = 2;
	public static final int ALG_INJET = 3;
	public static final int ALG_TEMPERATURA = 4;
	private  int tipoPT = 0;
	private  int tipoGT = 1;

	private String cdTipoPT;
	

	private String cdProduto;
	private String dsProduto;
	private String cdTurno;
	private String dsTurno;
	private long idTurno;
	
	private String dsFolha;
	private String cdFolha;
	private Double producaoBruta;
	private Double producaoLiquida;
	private Double producaoRefugada;
	private Double metaInstatanea;
	private Double indOEE;
	
	private String dsPt;
	private String dsCurta;
	private String cdPt;
	private long idPt;
	private long idGt;
	private long idtppt;
	private Boolean isCIPHabilitado;
	private String cdGt;
	
	private String dsUltimaParada;
	private String ultimaParada;
	private String areaResponsavel;
	private Date iniParada;
	private Date fimParada;
	private String duracaoParada;
	
    private String ultimaOp;
    private Double ultimaOpProducaoPlanejada;
    private Double ultimaOpProducaoRefugada;
    private Double ultimaOpProducaoLiquida;
    private Double ultimaOpSaldoAProduzir;
    private Double ultimaOpIR;
    
    private String ultimoMolde;
    private long idDwConsolId;
    private Double efiRealizacao;
    private Double efiCiclos;
    private Double indiceRefugos;
    private Double indiceCavAtivas;
    private Double produtividadeOEE;
    private Double indiceParadas;
    private Double indiceProducao;
    private Double efiInstantanea;
    private Double indiceDefeito = 0d;
    
    private String cdCp;
    private Long idCp;
    
    private boolean temperaturaZonaCritInf;
    private boolean temperaturaZonaActInf;
    private boolean temperaturaZonaIdeal;
    private boolean temperaturaZonaActSup;
    private boolean temperaturaZonaCritSup;
    private Double ultimaTemperaturaLida;
    private int filtroIndicadorLabel; 
    
    private Double segCicloPadrao;
    private Double segCicloMedio;
    private Double segUltimoCiclo;
    
    private Integer segTempoParadaCP;
    private Integer segTempoAtivo;
	private String dsGt;
	private String urlImg;

    private Double indOEEMeta;
    private Integer qtdePostos;
    private ColorDTO corGt;

    
    private Double indOEEClasseA;
    private Double indOEEMetaClasseA;
    private Integer qtdePostosClasseA;
    private ColorDTO corGtClasseA;
    private List<PtDTO> ptsClasseA;
    
    private Double indOEEClasseB;
    private Double indOEEMetaClasseB;
    private Integer qtdePostosClasseB;
    private ColorDTO corGtClasseb;
    private List<PtDTO> ptsClasseB;
    
    private Double indOEEClasseC;
    private Double indOEEMetaClasseC;
    private Integer qtdePostosClasseC;
    private ColorDTO corGtClasseC;
    private List<PtDTO> ptsClasseC;
    
    public Double getUltimaOpProducaoPlanejada() {
		return ultimaOpProducaoPlanejada;
	}
	public void setUltimaOpProducaoPlanejada(Double ultimaOpProducaoPlanejada) {
		this.ultimaOpProducaoPlanejada = ultimaOpProducaoPlanejada;
	}
	public Double getUltimaOpProducaoRefugada() {
		return ultimaOpProducaoRefugada;
	}
	public void setUltimaOpProducaoRefugada(Double ultimaOpProducaoRefugada) {
		this.ultimaOpProducaoRefugada = ultimaOpProducaoRefugada;
	}
	public Double getUltimaOpProducaoLiquida() {
		return ultimaOpProducaoLiquida;
	}
	public void setUltimaOpProducaoLiquida(Double ultimaOpProducaoLiquida) {
		this.ultimaOpProducaoLiquida = ultimaOpProducaoLiquida;
	}
	public Double getUltimaOpSaldoAProduzir() {
		return ultimaOpSaldoAProduzir;
	}
	public void setUltimaOpSaldoAProduzir(Double ultimaOpSaldoAProduzir) {
		this.ultimaOpSaldoAProduzir = ultimaOpSaldoAProduzir;
	}
	public Double getSegCicloPadrao() {
		return segCicloPadrao;
	}
	public void setSegCicloPadrao(Double segCicloPadrao) {
		this.segCicloPadrao = segCicloPadrao;
	}
	public Double getSegCicloMedio() {
		return segCicloMedio;
	}
	public void setSegCicloMedio(Double segCicloMedio) {
		this.segCicloMedio = segCicloMedio;
	}
	public Double getSegUltimoCiclo() {
		return segUltimoCiclo;
	}
	public void setSegUltimoCiclo(Double segUltimoCiclo) {
		this.segUltimoCiclo = segUltimoCiclo;
	}
	public Integer getSegTempoParadaCP() {
		return segTempoParadaCP;
	}
	public void setSegTempoParadaCP(Integer segTempoParadaCP) {
		this.segTempoParadaCP = segTempoParadaCP;
	}
	public Integer getSegTempoAtivo() {
		return segTempoAtivo;
	}
	public void setSegTempoAtivo(Integer segTempoAtivo) {
		this.segTempoAtivo = segTempoAtivo;
	}
	public boolean isTemperaturaZonaCritInf() {
		return temperaturaZonaCritInf;
	}
	public void setTemperaturaZonaCritInf(boolean temperaturaZonaCritInf) {
		this.temperaturaZonaCritInf = temperaturaZonaCritInf;
	}
	public boolean isTemperaturaZonaActInf() {
		return temperaturaZonaActInf;
	}
	public void setTemperaturaZonaActInf(boolean temperaturaZonaActInf) {
		this.temperaturaZonaActInf = temperaturaZonaActInf;
	}
	public boolean isTemperaturaZonaIdeal() {
		return temperaturaZonaIdeal;
	}
	public void setTemperaturaZonaIdeal(boolean temperaturaZonaIdeal) {
		this.temperaturaZonaIdeal = temperaturaZonaIdeal;
	}
	public boolean isTemperaturaZonaActSup() {
		return temperaturaZonaActSup;
	}
	public void setTemperaturaZonaActSup(boolean temperaturaZonaActSup) {
		this.temperaturaZonaActSup = temperaturaZonaActSup;
	}
	public boolean isTemperaturaZonaCritSup() {
		return temperaturaZonaCritSup;
	}
	public void setTemperaturaZonaCritSup(boolean temperaturaZonaCritSup) {
		this.temperaturaZonaCritSup = temperaturaZonaCritSup;
	}
	public Double getUltimaTemperaturaLida() {
		return ultimaTemperaturaLida;
	}
	public void setUltimaTemperaturaLida(Double ultimaTemperaturaLida) {
		this.ultimaTemperaturaLida = ultimaTemperaturaLida;
	}
	public Double getEfiInstantanea() {
		return efiInstantanea;
	}
	public void setEfiInstantanea(Double efiInstantanea) {
		this.efiInstantanea = efiInstantanea;
	}
	public int getFiltroIndicadorLabel() {
		return filtroIndicadorLabel;
	}
	public void setFiltroIndicadorLabel(int filtroIndicadorLabel) {
		this.filtroIndicadorLabel = filtroIndicadorLabel;
	}
	public Double getEfiRealizacao() {
		return efiRealizacao;
	}
	public void setEfiRealizacao(Double efiRealizacao) {
		this.efiRealizacao = efiRealizacao;
	}
	public Double getEfiCiclos() {
		return efiCiclos;
	}
	public void setEfiCiclos(Double efiCiclos) {
		this.efiCiclos = efiCiclos;
	}
	public Double getIndiceRefugos() {
		return indiceRefugos;
	}
	public void setIndiceRefugos(Double indiceRefugos) {
		this.indiceRefugos = indiceRefugos;
	}
	public Double getIndiceCavAtivas() {
		return indiceCavAtivas;
	}
	public void setIndiceCavAtivas(Double indiceCavAtivas) {
		this.indiceCavAtivas = indiceCavAtivas;
	}
	public Double getProdutividadeOEE() {
		return produtividadeOEE;
	}
	public void setProdutividadeOEE(Double produtividadeOEE) {
		this.produtividadeOEE = produtividadeOEE;
	}
	public Double getIndiceParadas() {
		return indiceParadas;
	}
	public void setIndiceParadas(Double indiceParadas) {
		this.indiceParadas = indiceParadas;
	}
	public Double getIndiceProducao() {
		return indiceProducao;
	}
	public void setIndiceProducao(Double indiceProducao) {
		this.indiceProducao = indiceProducao;
	}
	public long getIdDwConsolId() {
		return idDwConsolId;
	}
	public void setIdDwConsolId(long idDwConsolId) {
		this.idDwConsolId = idDwConsolId;
	}
	public String getDuracaoParada() {
		return duracaoParada;
	}
	public void setDuracaoParada(String duracaoParada) {
		this.duracaoParada = duracaoParada;
	}
	public String getUltimaParada() {
		return ultimaParada;
	}
	public void setUltimaParada(String ultimaParada) {
		this.ultimaParada = ultimaParada;
	}
	public String getAreaResponsavel() {
		return areaResponsavel;
	}
	public void setAreaResponsavel(String areaResponsavel) {
		this.areaResponsavel = areaResponsavel;
	}
	public Date getIniParada() {
		return iniParada;
	}
	public void setIniParada(Date iniParada) {
		this.iniParada = iniParada;
	}
	public Date getFimParada() {
		return fimParada;
	}
	public void setFimParada(Date fimParada) {
		this.fimParada = fimParada;
	}
	public String getUltimaOp() {
		return ultimaOp;
	}
	public void setUltimaOp(String ultimaOp) {
		this.ultimaOp = ultimaOp;
	}
	public String getUltimoMolde() {
		return ultimoMolde;
	}
	public void setUltimoMolde(String ultimoMolde) {
		this.ultimoMolde = ultimoMolde;
	}
	public String getDsProduto() {
		return dsProduto;
	}
	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}
	public String getCdPt() {
		return cdPt;
	}
	public void setCdPt(String cdPt) {
		this.cdPt = cdPt;
	}
	public String getCdGt() {
		return cdGt;
	}
	public void setCdGt(String cdGt) {
		this.cdGt = cdGt;
	}
	public void setTipoPT(int tipoPT) {
		this.tipoPT = tipoPT;
	}
	public void setTipoGT(int tipoGT) {
		this.tipoGT = tipoGT;
	}
	
	public String getDsTurno() {
		return dsTurno;
	}
	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}
	public String getDsPt() {
		return dsPt;
	}
	public void setDsPt(String dsPt) {
		this.dsPt = dsPt;
	}
	public String getDsGt() {
		return dsGt;
	}
	public void setDsGt(String dsGt) {
		this.dsGt = dsGt;
	}
	public String getUrlImg() {
		return urlImg;
	}
	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}
	public ColorDTO getCOR_FUNDO_OFFLINE() {
		return COR_FUNDO_OFFLINE;
	}
	public ColorDTO getCOR_FUNDO_PARADA() {
		return COR_FUNDO_PARADA;
	}
	public void setCOR_FUNDO_PARADA(ColorDTO cORFUNDOPARADA) {
		COR_FUNDO_PARADA = cORFUNDOPARADA;
	}
	public void setCOR_FUNDO_OFFLINE(ColorDTO cORFUNDOOFFLINE) {
		COR_FUNDO_OFFLINE = cORFUNDOOFFLINE;
	}
	public ColorDTO getCOR_FUNDO_DENTRO_META() {
		return COR_FUNDO_DENTRO_META;
	}
	public void setCOR_FUNDO_DENTRO_META(ColorDTO cORFUNDODENTROMETA) {
		COR_FUNDO_DENTRO_META = cORFUNDODENTROMETA;
	}
	public ColorDTO getCOR_FUNDO_FORA_META() {
		return COR_FUNDO_FORA_META;
	}
	public void setCOR_FUNDO_FORA_META(ColorDTO cORFUNDOFORAMETA) {
		COR_FUNDO_FORA_META = cORFUNDOFORAMETA;
	}
	public ColorDTO getCorFundo() {
		return corFundo;
	}
	public void setCorFundo(ColorDTO corFundo) {
		this.corFundo = corFundo;
	}
	public boolean isTemPlanejamento() {
		return isTemPlanejamento;		
	}
	public void setTemPlanejamento(boolean temPlanejamento) {
		this.isTemPlanejamento = temPlanejamento;
	}	
	public List<DwConsolmolog> getDwConsolmologs() {
		return dwConsolmologs;
	}
	public boolean isTemOperador() {
		return isTemOperador;
	}
	public void setTemOperador(boolean operador) {
		this.isTemOperador = operador;
	}
	public boolean isDentroDaMeta() {
		return isDentroDaMeta;
	}
	public void setDentroDaMeta(boolean dentroDaMeta) {
		this.isDentroDaMeta = dentroDaMeta;
	}
	public boolean isParada() {
		return isParada;
	}
	public void setParada(boolean parada) {
		this.isParada = parada;
	}
	public boolean isOffline() {
		return isOffline;
	}
	public void setOffline(boolean offline) {
		this.isOffline = offline;
	}
	public boolean isTemOmCfg() {
		return isTemOmCfg;
	}
	public void setTemOmCfg(boolean temOmCfg) {
		this.isTemOmCfg = temOmCfg;
	}
	public boolean isTemDwRt() {
		return isTemDwRt;
	}
	public void setTemDwRt(boolean temDwRt) {
		this.isTemDwRt = temDwRt;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public void setDwConsolmologs(List<DwConsolmolog> dwConsolmologs) {
		this.dwConsolmologs = dwConsolmologs;		
	}
	public boolean isTemOmAlgocor() {
		return isTemOmAlgocor;
	}
	public void setTemOmAlgocor(boolean temOmAlgocor) {
		this.isTemOmAlgocor = temOmAlgocor;
	}
	public boolean isParadaComPeso() {
		return isParadaComPeso;
	}
	public void setParadaComPeso(boolean paradaComPeso) {
		this.isParadaComPeso = paradaComPeso;
	}
	public boolean isSaidaDaCelula() {
		return isSaidaDaCelula;
	}
	public void setSaidaDaCelula(boolean saidaDaCelula) {
		this.isSaidaDaCelula = saidaDaCelula;
	}
	public boolean isGargaloTeorico() {
		return isGargaloTeorico;
	}
	public void setGargaloTeorico(boolean gargaloTeorico) {
		this.isGargaloTeorico = gargaloTeorico;
	}
	public boolean isGargaloDinamico() {
		return isGargaloDinamico;
	}
	public void setGargaloDinamico(boolean gargaloDinamico) {
		this.isGargaloDinamico = gargaloDinamico;
	}
	public boolean isParadaManutencao() {
		return isParadaManutencao;
	}
	public void setParadaManutencao(boolean paradaManutencao) {
		this.isParadaManutencao = paradaManutencao;
	}
	public boolean isOpConcluida() {
		return isOpConcluida;
	}
	public void setOpConcluida(boolean opConcluida) {
		this.isOpConcluida = opConcluida;
	}
	public boolean isOpConcluida90PorCento() {
		return isOpConcluida90PorCento;
	}
	public void setOpConcluida90PorCento(boolean opConcluida90PorCento) {
		this.isOpConcluida90PorCento = opConcluida90PorCento;
	}
	public int getTipoAlgoritmo() {
		return tipoAlgoritmo;
	}
	public void setTipoAlgoritmo(int tipoAlgoritmo) {
		this.tipoAlgoritmo = tipoAlgoritmo;
	}
	public boolean isComAlerta() {
		return isComAlerta;
	}
	public void setComAlerta(boolean comAlerta) {
		this.isComAlerta = comAlerta;
	}
	public boolean isParadaNaoInformada() {
		return isParadaNaoInformada;
	}
	public void setParadaNaoInformada(boolean paradaNaoInformada) {
		this.isParadaNaoInformada = paradaNaoInformada;
	}
	public boolean isParadaSemPesoEfic() {
		return isParadaSemPesoEfic;
	}
	public void setParadaSemPesoEfic(boolean paradaSemPesoEfic) {
		this.isParadaSemPesoEfic = paradaSemPesoEfic;
	}
	public boolean isIndiceRefugo3porCento() {
		return isIndiceRefugo3porCento;
	}
	public void setIndiceRefugo3porCento(boolean indiceRefugo3porCento) {
		this.isIndiceRefugo3porCento = indiceRefugo3porCento;
	}
	public boolean isAlertaVidaUtil() {
		return isAlertaVidaUtil;
	}
	public void setAlertaVidaUtil(boolean alertaVidaUtil) {
		this.isAlertaVidaUtil = alertaVidaUtil;
	}
	public boolean isPerdaSincronismo() {
		return isPerdaSincronismo;
	}
	public void setPerdaSincronismo(boolean perdaSincronismo) {
		this.isPerdaSincronismo = perdaSincronismo;
	}
	public static int getAlgWhp() {
		return ALG_WHP;
	}
	public static int getAlgInjet() {
		return ALG_INJET;
	}
	public void setManutencaoPrev(boolean manutencaoPrev) {
		this.isManutencaoPrev = manutencaoPrev;
	}
	public boolean isManutencaoPrev() {
		return isManutencaoPrev;
	}
	
	public void setX(Double x) {
		this.x = x;
	}
	public Double getX() {
		return x;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public Double getY() {
		return y;
	}
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	public String getCdProduto() {
		return cdProduto;
	}
	public void setIdtppt(long idtppt) {
		this.idtppt = idtppt;
	}
	public long getIdtppt() {
		return idtppt;
	}
	public void setTipoObj(int tipoObj) {
		this.tipoObj = tipoObj;
	}
	public int getTipoObj() {
		return tipoObj;
	}
	public int getTipoPT() {
		return tipoPT;
	}
	public int getTipoGT() {
		return tipoGT;
	}
	
	public long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}
	public long getIdPt() {
		return idPt;
	}
	public void setIdPt(long idPt) {
		this.idPt = idPt;
	}
	public long getIdGt() {
		return idGt;
	}
	public void setIdGt(long idGt) {
		this.idGt = idGt;
	}
	public String getCdCp() {
		return cdCp;
	}
	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}
	
	public void setX2(Double x2) {
		this.x2 = x2;
	}
	public Double getX2() {
		return x2;
	}
	public void setY2(Double y2) {
		this.y2 = y2;
	}
	public Double getY2() {
		return y2;
	}
	public void setIdCp(Long idCp) {
		this.idCp = idCp;
	}
	public Long getIdCp() {
		return idCp;
	}
	public String getDsFolha() {
		return dsFolha;
	}
	public void setDsFolha(String dsFolha) {
		this.dsFolha = dsFolha;
	}
	public String getCdFolha() {
		return cdFolha;
	}
	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}
	public Double getMetaInstatanea() {
		return metaInstatanea;
	}
	public void setMetaInstatanea(Double metaInstatanea) {
		this.metaInstatanea = metaInstatanea;
	}
	public Double getProducaoLiquida() {
		return producaoLiquida;
	}
	public void setProducaoLiquida(Double producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}
	public Double getIndOEE() {
		return indOEE;
	}
	public void setIndOEE(Double indOEE) {
		this.indOEE = indOEE;
	}
	public Double getProducaoBruta() {
		return producaoBruta;
	}
	public void setProducaoBruta(Double producaoBruta) {
		this.producaoBruta = producaoBruta;
	}
	public Double getProducaoRefugada() {
		return producaoRefugada;
	}
	public void setProducaoRefugada(Double producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}
	public boolean isConsolidacaoPendente() {
		return isConsolidacaoPendente;
	}
	public void setConsolidacaoPendente(boolean isConsolidacaoPendente) {
		this.isConsolidacaoPendente = isConsolidacaoPendente;
	}
	public boolean isPerdaSinc() {
		return isPerdaSinc;
	}
	public void setPerdaSinc(boolean isPerdaSinc) {
		this.isPerdaSinc = isPerdaSinc;
	}

	public String getCdTurno() {
		return cdTurno;
	}
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	public boolean isCIP() {
		return isCIP;
	}
	public void setCIP(boolean isCIP) {
		this.isCIP = isCIP;
	}
	public Boolean getIsCIPHabilitado() {
		return isCIPHabilitado;
	}
	public void setIsCIPHabilitado(Boolean isCIPHabilitado) {
		this.isCIPHabilitado = isCIPHabilitado;
	}
	public boolean isCIPExtrapolado() {
		return isCIPExtrapolado;
	}
	public void setCIPExtrapolado(boolean isCIPExtrapolado) {
		this.isCIPExtrapolado = isCIPExtrapolado;
	}
	public boolean isParadaExtrapolada() {
		return isParadaExtrapolada;
	}
	public void setParadaExtrapolada(boolean isParadaExtrapolada) {
		this.isParadaExtrapolada = isParadaExtrapolada;
	}
	public Double getIndOEEMeta() {
		return indOEEMeta;
	}
	public void setIndOEEMeta(Double indOEEMeta) {
		this.indOEEMeta = indOEEMeta;
	}
	public Integer getQtdePostos() {
		return qtdePostos;
	}
	public void setQtdePostos(Integer qtdePostos) {
		this.qtdePostos = qtdePostos;
	}
	public Double getIndOEEClasseA() {
		return indOEEClasseA;
	}
	public void setIndOEEClasseA(Double indOEEClasseA) {
		this.indOEEClasseA = indOEEClasseA;
	}
	public Double getIndOEEMetaClasseA() {
		return indOEEMetaClasseA;
	}
	public void setIndOEEMetaClasseA(Double indOEEMetaClasseA) {
		this.indOEEMetaClasseA = indOEEMetaClasseA;
	}
	public Integer getQtdePostosClasseA() {
		return qtdePostosClasseA;
	}
	public void setQtdePostosClasseA(Integer qtdePostosClasseA) {
		this.qtdePostosClasseA = qtdePostosClasseA;
	}
	public Double getIndOEEClasseB() {
		return indOEEClasseB;
	}
	public void setIndOEEClasseB(Double indOEEClasseB) {
		this.indOEEClasseB = indOEEClasseB;
	}
	public Double getIndOEEMetaClasseB() {
		return indOEEMetaClasseB;
	}
	public void setIndOEEMetaClasseB(Double indOEEMetaClasseB) {
		this.indOEEMetaClasseB = indOEEMetaClasseB;
	}
	public Integer getQtdePostosClasseB() {
		return qtdePostosClasseB;
	}
	public void setQtdePostosClasseB(Integer qtdePostosClasseB) {
		this.qtdePostosClasseB = qtdePostosClasseB;
	}
	public Double getIndOEEClasseC() {
		return indOEEClasseC;
	}
	public void setIndOEEClasseC(Double indOEEClasseC) {
		this.indOEEClasseC = indOEEClasseC;
	}
	public Double getIndOEEMetaClasseC() {
		return indOEEMetaClasseC;
	}
	public void setIndOEEMetaClasseC(Double indOEEMetaClasseC) {
		this.indOEEMetaClasseC = indOEEMetaClasseC;
	}
	public Integer getQtdePostosClasseC() {
		return qtdePostosClasseC;
	}
	public void setQtdePostosClasseC(Integer qtdePostosClasseC) {
		this.qtdePostosClasseC = qtdePostosClasseC;
	}
	public ColorDTO getCorGt() {
		return corGt;
	}
	public void setCorGt(ColorDTO corGt) {
		this.corGt = corGt;
	}
	public ColorDTO getCorGtClasseA() {
		return corGtClasseA;
	}
	public void setCorGtClasseA(ColorDTO corGtClasseA) {
		this.corGtClasseA = corGtClasseA;
	}
	public ColorDTO getCorGtClasseb() {
		return corGtClasseb;
	}
	public void setCorGtClasseb(ColorDTO corGtClasseb) {
		this.corGtClasseb = corGtClasseb;
	}
	public ColorDTO getCorGtClasseC() {
		return corGtClasseC;
	}
	public void setCorGtClasseC(ColorDTO corGtClasseC) {
		this.corGtClasseC = corGtClasseC;
	}
	public List<PtDTO> getPtsClasseA() {
		return ptsClasseA;
	}
	public void setPtsClasseA(List<PtDTO> ptsClasseA) {
		this.ptsClasseA = ptsClasseA;
	}
	public List<PtDTO> getPtsClasseB() {
		return ptsClasseB;
	}
	public void setPtsClasseB(List<PtDTO> ptsClasseB) {
		this.ptsClasseB = ptsClasseB;
	}
	public List<PtDTO> getPtsClasseC() {
		return ptsClasseC;
	}
	public void setPtsClasseC(List<PtDTO> ptsClasseC) {
		this.ptsClasseC = ptsClasseC;
	}
	public Double getUltimaOpIR() {
		return ultimaOpIR;
	}
	public void setUltimaOpIR(Double ultimaOpIR) {
		this.ultimaOpIR = ultimaOpIR;
	}
	public String getDsUltimaParada() {
		return dsUltimaParada;
	}
	public void setDsUltimaParada(String dsUltimaParada) {
		this.dsUltimaParada = dsUltimaParada;
	}
	public String getDsCurta() {
		return dsCurta;
	}
	public void setDsCurta(String dsCurta) {
		this.dsCurta = dsCurta;
	}

	public String getCdTipoPT() {
		return cdTipoPT;
	}
	public void setCdTipoPT(String cdTipoPT) {
		this.cdTipoPT = cdTipoPT;
	}
	public Double getIndiceDefeito() {
		return indiceDefeito;
	}
	public void setIndiceDefeito(Double indiceDefeito) {
		this.indiceDefeito = indiceDefeito;
	}
	public OmObj getOmobj() {
		return omobj;
	}
	public void setOmobj(OmObj omobj) {
		this.omobj = omobj;
	}

	
}
