package idw.webservices.dto;

import java.awt.Color;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import idw.model.pojos.DwConsolmolog;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmProduto;

@SuppressWarnings("serial")
public class ObjRtDTO implements Serializable {
	
	private boolean dentroDaMeta;
	private boolean parada;
	private boolean offline;
	private boolean temOmCfg;
	private boolean temOmAlgocor;
	private boolean temDwRt;
	private ObjDTO objDTO;
	private Date dtReferencia;
	private DwTurno dwTurno;
	private boolean temOperador;
	private boolean temPlanejamento;
	private boolean paradaComPeso;
	private boolean saidaDaCelula;
	private boolean gargaloTeorico;
	private boolean gargaloDinamico;
	private boolean paradaManutencao;
	private boolean semMolde;
	private boolean opConcluida;
	private boolean opConcluida90PorCento;
	private boolean comAlerta;
	private boolean paradaNaoInformada;
	private boolean paradaSemPesoEfic;
	private boolean indiceRefugo3porCento;
	private boolean consolidacaoEmAtraso;
	private boolean alertaVidaUtil;
	private boolean perdaSincronismo;
	
	
	private int tipoAlgoritmo;
	
	
	private List<DwConsolmolog> dwConsolmologs;
	private ColorDTO corFundo;
	private ColorDTO COR_FUNDO_OFFLINE = new ColorDTO(Color.GRAY);
	private ColorDTO COR_FUNDO_DENTRO_META = new ColorDTO(Color.GREEN);
	private ColorDTO COR_FUNDO_FORA_META = new ColorDTO(Color.RED);
	private ColorDTO COR_FUNDO_PARADA = new ColorDTO(Color.YELLOW);
	public static final int ALG_WHP = 2;
	public static final int ALG_INJET = 3;
	private OmProduto omproduto;
	
	public OmProduto getOmproduto() {
		return omproduto;
	}
	public void setOmproduto(OmProduto omproduto) {
		this.omproduto = omproduto;
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
		return temPlanejamento;		
	}
	public void setTemPlanejamento(boolean temPlanejamento) {
		this.temPlanejamento = temPlanejamento;
	}	
	public List<DwConsolmolog> getDwConsolmologs() {
		return dwConsolmologs;
	}
	public boolean isTemOperador() {
		return temOperador;
	}
	public void setTemOperador(boolean operador) {
		this.temOperador = operador;
	}
	public boolean isDentroDaMeta() {
		return dentroDaMeta;
	}
	public void setDentroDaMeta(boolean dentroDaMeta) {
		this.dentroDaMeta = dentroDaMeta;
	}
	public boolean isParada() {
		return parada;
	}
	public void setParada(boolean parada) {
		this.parada = parada;
	}
	public boolean isOffline() {
		return offline;
	}
	public void setOffline(boolean offline) {
		this.offline = offline;
	}
	public boolean isTemOmCfg() {
		return temOmCfg;
	}
	public void setTemOmCfg(boolean temOmCfg) {
		this.temOmCfg = temOmCfg;
	}
	public boolean isTemDwRt() {
		return temDwRt;
	}
	public void setTemDwRt(boolean temDwRt) {
		this.temDwRt = temDwRt;
	}
	public ObjDTO getObjDTO() {
		return objDTO;
	}
	public void setObjDTO(ObjDTO objDTO) {
		this.objDTO = objDTO;
	}
	public Date getDtReferencia() {
		return dtReferencia;
	}
	public void setDtReferencia(Date dtReferencia) {
		this.dtReferencia = dtReferencia;
	}
	public DwTurno getDwTurno(){
		return this.dwTurno;
	}
	public void setDwTurno(DwTurno dwTurno) {
		this.dwTurno = dwTurno;
	}
	public void setDwConsolmologs(List<DwConsolmolog> dwConsolmologs) {
		this.dwConsolmologs = dwConsolmologs;		
	}
	public boolean isTemOmAlgocor() {
		return temOmAlgocor;
	}
	public void setTemOmAlgocor(boolean temOmAlgocor) {
		this.temOmAlgocor = temOmAlgocor;
	}
	public boolean isParadaComPeso() {
		return paradaComPeso;
	}
	public void setParadaComPeso(boolean paradaComPeso) {
		this.paradaComPeso = paradaComPeso;
	}
	public boolean isSaidaDaCelula() {
		return saidaDaCelula;
	}
	public void setSaidaDaCelula(boolean saidaDaCelula) {
		this.saidaDaCelula = saidaDaCelula;
	}
	public boolean isGargaloTeorico() {
		return gargaloTeorico;
	}
	public void setGargaloTeorico(boolean gargaloTeorico) {
		this.gargaloTeorico = gargaloTeorico;
	}
	public boolean isGargaloDinamico() {
		return gargaloDinamico;
	}
	public void setGargaloDinamico(boolean gargaloDinamico) {
		this.gargaloDinamico = gargaloDinamico;
	}
	public boolean isParadaManutencao() {
		return paradaManutencao;
	}
	public void setParadaManutencao(boolean paradaManutencao) {
		this.paradaManutencao = paradaManutencao;
	}
	public boolean isSemMolde() {
		return semMolde;
	}
	public void setSemMolde(boolean semMolde) {
		this.semMolde = semMolde;
	}
	public boolean isOpConcluida() {
		return opConcluida;
	}
	public void setOpConcluida(boolean opConcluida) {
		this.opConcluida = opConcluida;
	}
	public boolean isOpConcluida90PorCento() {
		return opConcluida90PorCento;
	}
	public void setOpConcluida90PorCento(boolean opConcluida90PorCento) {
		this.opConcluida90PorCento = opConcluida90PorCento;
	}
	public int getTipoAlgoritmo() {
		return tipoAlgoritmo;
	}
	public void setTipoAlgoritmo(int tipoAlgoritmo) {
		this.tipoAlgoritmo = tipoAlgoritmo;
	}
	public boolean isComAlerta() {
		return comAlerta;
	}
	public void setComAlerta(boolean comAlerta) {
		this.comAlerta = comAlerta;
	}
	public boolean isParadaNaoInformada() {
		return paradaNaoInformada;
	}
	public void setParadaNaoInformada(boolean paradaNaoInformada) {
		this.paradaNaoInformada = paradaNaoInformada;
	}
	public boolean isParadaSemPesoEfic() {
		return paradaSemPesoEfic;
	}
	public void setParadaSemPesoEfic(boolean paradaSemPesoEfic) {
		this.paradaSemPesoEfic = paradaSemPesoEfic;
	}
	public boolean isIndiceRefugo3porCento() {
		return indiceRefugo3porCento;
	}
	public void setIndiceRefugo3porCento(boolean indiceRefugo3porCento) {
		this.indiceRefugo3porCento = indiceRefugo3porCento;
	}
	public boolean isConsolidacaoEmAtraso() {
		return consolidacaoEmAtraso;
	}
	public void setConsolidacaoEmAtraso(boolean consolidacaoEmAtraso) {
		this.consolidacaoEmAtraso = consolidacaoEmAtraso;
	}
	public boolean isAlertaVidaUtil() {
		return alertaVidaUtil;
	}
	public void setAlertaVidaUtil(boolean alertaVidaUtil) {
		this.alertaVidaUtil = alertaVidaUtil;
	}
	public boolean isPerdaSincronismo() {
		return perdaSincronismo;
	}
	public void setPerdaSincronismo(boolean perdaSincronismo) {
		this.perdaSincronismo = perdaSincronismo;
	}
	public static int getAlgWhp() {
		return ALG_WHP;
	}
	public static int getAlgInjet() {
		return ALG_INJET;
	}
	
	
	
	
	
}
