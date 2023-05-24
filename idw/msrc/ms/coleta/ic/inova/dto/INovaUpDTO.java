package ms.coleta.ic.inova.dto;

import java.util.ArrayList;
//import java.util.List;

//import injetws.webservices.dto.IwsAlertaDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsModDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;
import injetws.webservices.dto.IwsRefugoDTO;
import injetws.webservices.dto.IwsUpAndonPrcsftDTO;
import injetws.webservices.dto.IwsUpDTO;

@SuppressWarnings("serial")
public class INovaUpDTO extends IwsUpDTO {
	
	public static byte STATUS_FUNCIONAMENTO_PARADA = 0;
	public static byte STATUS_FUNCIONAMENTO_PRODUZINDO = 1;
	public static byte STATUS_FUNCIONAMENTO_SEMPROGRAMA = 2;
	
	private byte stFuncionamento;
	
	private boolean isPedirParada = false;
	private boolean isPedeRefugoAcao = false;
	private boolean isPedeRefugoCausa = false;
	
	private IwsRefugoDTO ultimoRefugoAtual = new IwsRefugoDTO();
	private IwsParadaDTO ultimaParadaAtual = new IwsParadaDTO();
	private boolean tmpIsPesanaeficiencia = false;
	private String tmpDsParada ="";
	private boolean tmpPermiteAlterar = true;
	private boolean isParadaAtualAutomatica = false;
	
//	private List<IwsAlertaDTO> listaAlertasAbertos = new ArrayList<IwsAlertaDTO>(); 
//	private List<IwsModDTO> listaOperadoresLogados = new ArrayList<IwsModDTO>();
//	private List<INovaAndonDTO> listaDadosAndon = new ArrayList<INovaAndonDTO>();
	
	private INovaReleDTO lcRele01 = new INovaReleDTO();
	private INovaReleDTO lcRele02 = new INovaReleDTO();
	private INovaReleDTO lcRele03 = new INovaReleDTO();
	private INovaReleDTO lcRele04 = new INovaReleDTO();
	private INovaReleDTO lcRele05 = new INovaReleDTO();
	private INovaReleDTO lcRele06 = new INovaReleDTO();
	private INovaReleDTO lcRele07 = new INovaReleDTO();
	private INovaReleDTO lcRele08 = new INovaReleDTO();
	
	private IwsUpAndonPrcsftDTO lcUpAndonPrcsftDTO = new IwsUpAndonPrcsftDTO();
	private IwsProdMateriaPrimaDTO matPrimaSaldoZero = new IwsProdMateriaPrimaDTO();
	
	private boolean isParadaDefaultAberta = false;
	private IwsCpDTO cpTemp = new IwsCpDTO();
	private IwsProdMateriaPrimaDTO matPrimaEnviada = null;
	private boolean isComSaldo = true;
	
	public byte getStFuncionamento() {
		return stFuncionamento;
	}
	public void setStFuncionamento(byte stFuncionamento) {
		this.stFuncionamento = stFuncionamento;
	}
	
	public boolean isPedirParada() {
		return isPedirParada;
	}
	public void setPedirParada(boolean isPedirParada) {
		this.isPedirParada = isPedirParada;
	}
	
	public IwsRefugoDTO getUltimoRefugoAtual() {
		return ultimoRefugoAtual;
	}
	public void setUltimoRefugoAtual(IwsRefugoDTO ultimoRefugoAtual) {
		this.ultimoRefugoAtual = ultimoRefugoAtual;
	}
	
	public IwsParadaDTO getUltimaParadaAtual() {
		return ultimaParadaAtual;
	}
	public void setUltimaParadaAtual(IwsParadaDTO ultimaParadaAtual) {
		this.ultimaParadaAtual = ultimaParadaAtual;
	}
	
	public boolean isTmpIsPesanaeficiencia() {
		return tmpIsPesanaeficiencia;
	}
	public void setTmpIsPesanaeficiencia(boolean tmpIsPesanaeficiencia) {
		this.tmpIsPesanaeficiencia = tmpIsPesanaeficiencia;
	}
	
	public String getTmpDsParada() {
		return tmpDsParada;
	}
	public void setTmpDsParada(String tmpDsParada) {
		this.tmpDsParada = tmpDsParada;
	}
	
	public boolean isTmpPermiteAlterar() {
		return tmpPermiteAlterar;
	}
	public void setTmpPermiteAlterar(boolean tmpPermiteAlterar) {
		this.tmpPermiteAlterar = tmpPermiteAlterar;
	}
	
//	public List<IwsAlertaDTO> getListaAlertasAbertos() {
//		return listaAlertasAbertos;
//	}
//	public void setListaAlertasAbertos(List<IwsAlertaDTO> listaAlertasAbertos) {
//		this.listaAlertasAbertos = listaAlertasAbertos;
//	}
//	public void addAlertaDTO(IwsAlertaDTO alertadto)
//	{
//		listaAlertasAbertos.add(alertadto);
//	}
//	public void removeAlertaDTO(IwsAlertaDTO alertadto) {
//		for(int i = 0; i < listaAlertasAbertos.size(); i++) {
//			IwsAlertaDTO Alertascan = listaAlertasAbertos.get(i);
//			
//			if (Alertascan.getCdAlerta().equals(alertadto.getCdAlerta())) {
//				listaAlertasAbertos.remove(i);
////				listaAlertasAbertos.remove(Alertascan);
//				break;
//			}
//		}
//	}
	
//	public List<IwsModDTO> getListaOperadoresLogados() {
//		return listaOperadoresLogados;
//	}
//	public void setListaOperadoresLogados(List<IwsModDTO> listaOperadoresLogados) {
//		this.listaOperadoresLogados = listaOperadoresLogados;
//	}
//	public void removeModDTO(IwsModDTO moddto){
//		for(int i = 0; i < listaOperadoresLogados.size(); i++) {
//			IwsModDTO modscan = listaOperadoresLogados.get(i);
//			
//			if (modscan.getLogin().equals(moddto.getLogin()))
//				listaOperadoresLogados.remove(i);
//		}
//	}
	
//	public List<INovaAndonDTO> getListaDadosAndon() {
//		return listaDadosAndon;
//	}
//	public void setListaDadosAndon(List<INovaAndonDTO> listaDadosAndon) {
//		this.listaDadosAndon = listaDadosAndon;
//	}
	
	public INovaReleDTO getLcRele01() {
		return lcRele01;
	}
	public void setLcRele01(INovaReleDTO lcRele01) {
		this.lcRele01 = lcRele01;
	}
	public INovaReleDTO getLcRele02() {
		return lcRele02;
	}
	public void setLcRele02(INovaReleDTO lcRele02) {
		this.lcRele02 = lcRele02;
	}
	public INovaReleDTO getLcRele03() {
		return lcRele03;
	}
	public void setLcRele03(INovaReleDTO lcRele03) {
		this.lcRele03 = lcRele03;
	}
	public INovaReleDTO getLcRele04() {
		return lcRele04;
	}
	public void setLcRele04(INovaReleDTO lcRele04) {
		this.lcRele04 = lcRele04;
	}
	public INovaReleDTO getLcRele05() {
		return lcRele05;
	}
	public void setLcRele05(INovaReleDTO lcRele05) {
		this.lcRele05 = lcRele05;
	}
	public INovaReleDTO getLcRele06() {
		return lcRele06;
	}
	public void setLcRele06(INovaReleDTO lcRele06) {
		this.lcRele06 = lcRele06;
	}
	public INovaReleDTO getLcRele07() {
		return lcRele07;
	}
	public void setLcRele07(INovaReleDTO lcRele07) {
		this.lcRele07 = lcRele07;
	}
	public INovaReleDTO getLcRele08() {
		return lcRele08;
	}
	public void setLcRele08(INovaReleDTO lcRele08) {
		this.lcRele08 = lcRele08;
	}
	
	public IwsUpAndonPrcsftDTO getLcUpAndonPrcsftDTO() {
		return lcUpAndonPrcsftDTO;
	}
	public void setLcUpAndonPrcsftDTO(IwsUpAndonPrcsftDTO lcUpAndonPrcsftDTO) {
		this.lcUpAndonPrcsftDTO = lcUpAndonPrcsftDTO;
	}
	
	public IwsProdMateriaPrimaDTO getMatPrimaSaldoZero() {
		return matPrimaSaldoZero;
	}
	public void setMatPrimaSaldoZero(IwsProdMateriaPrimaDTO matPrimaSaldoZero) {
		this.matPrimaSaldoZero = matPrimaSaldoZero;
	}
	
	public IwsCpDTO getCpTemp() {
		return cpTemp;
	}
	public void setCpTemp(IwsCpDTO cpTemp) {
		this.cpTemp = cpTemp;
	}
	
	public IwsProdMateriaPrimaDTO getMatPrimaEnviada() {
		if(this.matPrimaEnviada == null)
			this.matPrimaEnviada = new IwsProdMateriaPrimaDTO();
		return matPrimaEnviada;
	}
	public void setMatPrimaEnviada(IwsProdMateriaPrimaDTO matPrimaEnviada) {
		this.matPrimaEnviada = matPrimaEnviada;
	}
	
	public boolean isComSaldo() {
		return isComSaldo;
	}
	public void setComSaldo(boolean isComSaldo) {
		this.isComSaldo = isComSaldo;
	}
	
	
	public void copyUpDTOWs(IwsUpDTO up) {
		this.setIdUP(up.getIdUP());
		this.setIdSubColetor(up.getIdSubColetor());
		this.setCt(up.getCt());
		this.setUp(up.getUp());
		this.setCdMaquina(up.getCdMaquina());
		this.setStCriacaoCP(up.getStCriacaoCP());
		this.setIsSemPrograma(up.getIsSemPrograma());
		this.setIsEmRegulagem(up.getIsEmRegulagem());
		if (up.getProducaoLiquida() != null)
		this.setProducaoLiquida(up.getProducaoLiquida());
		else
		this.setProducaoLiquida(0.0);
		this.setIsParadaEmAberto(up.getIsParadaEmAberto());
		this.setNumeroDeCiclos(up.getNumeroDeCiclos());
		this.setIsUpAtiva(up.getIsUpAtiva());
		this.setDadosCIP(up.getDadosCIP());
		this.setIsCicloAberto(up.getIsCicloAberto());
		this.setCavidadesAtivas(up.getCavidadesAtivas());
		this.setTemOperadorLogado(up.getTemOperadorLogado());
		
		if(this.getIsParadaEmAberto() == true)
			this.stFuncionamento = INovaUpDTO.STATUS_FUNCIONAMENTO_PARADA;
		
		if (this.getIsSemPrograma() == true)
			this.stFuncionamento = INovaUpDTO.STATUS_FUNCIONAMENTO_SEMPROGRAMA;
		
		this.setCp(up.getCp());
		this.setParadaAtualOuUltimaParada(up.getParadaAtualOuUltimaParada());
		//this.ultimaParadaAtual.copyParadaDTOWS(up.getParadaAtualOuUltimaParada());
		this.ultimaParadaAtual = up.getParadaAtualOuUltimaParada();
		
		if(this.getIsParadaEmAberto() == true &&
			(this.ultimaParadaAtual == null ||
			this.ultimaParadaAtual.getCdParada() == null ||
			this.ultimaParadaAtual.getCdParada().equals("") ||
			this.ultimaParadaAtual.getCdParada().equals("99999")))
		{
			this.isPedirParada = true;
		}  
		
		if(up.getRele01() != null) this.lcRele01.copyReleDTOWs(up.getRele01());
		else this.lcRele01 = null;
		if(up.getRele02() != null) this.lcRele02.copyReleDTOWs(up.getRele02());
		else this.lcRele02 = null;
		if(up.getRele03() != null) this.lcRele03.copyReleDTOWs(up.getRele03());
		else this.lcRele03 = null;
		if(up.getRele04() != null) this.lcRele04.copyReleDTOWs(up.getRele04());
		else this.lcRele04 = null;
		if(up.getRele05() != null) this.lcRele05.copyReleDTOWs(up.getRele05());
		else this.lcRele05 = null;
		
		if(up.getStAndonConfiguravel() == false) this.setStAndonConfiguravel(false);
		else this.setStAndonConfiguravel(true);
		
		if(up.getStAndonProcessoft() == false) this.setStAndonProcessoft(false);
		else this.setStAndonProcessoft(true);
		
		if(up.getoUpAndonPrcsftDTO() != null)
			this.lcUpAndonPrcsftDTO = up.getoUpAndonPrcsftDTO();
		
		// Senoj:adicionado para tratar erro de Perda de Molde
		if((this.getCp() != null) && (this.getCp().getNrop() != null) && (this.getCp().getNrop().length() > 0)) this.setIsSemPrograma(false);
		
//		if(up.getListaAndonDTO() != null) {
//			for(int i = 0; i < up.getListaAndonDTO().size(); i++) {
//				if((this.listaDadosAndon.size() == 0) || (this.listaDadosAndon.size() < up.getListaAndonDTO().size())) {
//					INovaAndonDTO local = new INovaAndonDTO();
//					local.copyAndonDTOWS(up.getListaAndonDTO().get(i));
//					
//					this.listaDadosAndon.add(local);
//				}
//				else {
//					this.listaDadosAndon.get(i).copyAndonDTOWS(up.getListaAndonDTO().get(i));
//				}
//			}
//		}
		
//		if(up.getIsComAlertaProbQuali() == true) this.setIsComAlertaProbQuali(true);
//		else this.setIsComAlertaProbQuali(false);
		
		if(up.getIsComInspecaoPendente() == true) this.setIsComInspecaoPendente(true);
		else this.setIsComInspecaoPendente(false);
		
		this.setResultadoUltimaInspecao(up.getResultadoUltimaInspecao());
		
		if(up.getIsApntSapAtivo() != null) {
			if(up.getIsApntSapAtivo().equals("1"))
				this.setIsApntSapAtivo("1");
			else
				this.setIsApntSapAtivo("0");
		}
		else
			this.setIsApntSapAtivo(null);
		
		if(up.getStApntSap() != null) {
			if (up.getStApntSap().equals("1"))
				this.setStApntSap("1");
			else
				this.setStApntSap("0");
		}
		else
			this.setStApntSap(null);
		
		if(up.getTxtMsg() != null) {
			this.setTxtMsg(up.getTxtMsg());
		}
		else
			this.setTxtMsg(null);
		
		if (up.getListaLoginsEmAberto() != null) {
			this.setListaLoginsEmAberto(new ArrayList<IwsModDTO>(up.getListaLoginsEmAberto().size()));
			this.setListaLoginsEmAberto(up.getListaLoginsEmAberto());
		}
		else
			this.setListaLoginsEmAberto(null);
		
		this.setIsParadaFechaCiclo(up.getIsParadaFechaCiclo());
		
		this.setStIntegracaoDoal(up.isStIntegracaoDoal());
		//this.isMateriaApontada = up.stAlimIntegracaoDoal;
		this.setStAlimIntegracaoDoal(up.isStAlimIntegracaoDoal());
		this.setUltimaMateriaPrimaAtual(up.getUltimaMateriaPrimaAtual());
		this.setVisualizaTelaIntegDOal(up.isVisualizaTelaIntegDOal());
	}
	
	public void limparUp() {
		setIsEmRegulagem(false);
		setIsParadaEmAberto(false);
		isPedirParada = false;
		isPedeRefugoAcao = false;
		isPedeRefugoCausa = false;
		setDadosCIP(null);
		setComSaldo(false);
		matPrimaSaldoZero = new IwsProdMateriaPrimaDTO();
		setParadaAtualOuUltimaParada(new IwsParadaDTO());
		ultimoRefugoAtual = new IwsRefugoDTO();
		ultimaParadaAtual = new IwsParadaDTO();
		tmpIsPesanaeficiencia = false;
		isParadaAtualAutomatica = false;
		setIsCicloAberto(false);
		setCavidadesAtivas(1);
		setTemOperadorLogado(false);
		
//		listaAlertasAbertos = new ArrayList<IwsAlertaDTO>();
//		listaOperadoresLogados = new ArrayList<IwsModDTO>();
//		listaDadosAndon = new ArrayList<INovaAndonDTO>(); 
		
		lcRele01 = new INovaReleDTO();
		lcRele02 = new INovaReleDTO();
		lcRele03 = new INovaReleDTO();
		lcRele04 = new INovaReleDTO();
		lcRele05 = new INovaReleDTO();
		lcRele06 = new INovaReleDTO();
		lcRele07 = new INovaReleDTO();
		lcRele08 = new INovaReleDTO();
		
		lcUpAndonPrcsftDTO = new IwsUpAndonPrcsftDTO();
		
		setStAndonProcessoft(false);
		setStAndonConfiguravel(false);
		isParadaDefaultAberta = false;
		setIsComInspecaoPendente(false);
//		setIsComAlertaProbQuali(false);
		setResultadoUltimaInspecao(0);
		setIsApntSapAtivo("0");
	}
	
	public int getMsParadaAutoTimeout()
	{
		float cicloTimeOut = this.getCp().getCicloPadrao() * this.getCp().getCfgPercTmpCicloParAuto() * 10f;
		
		return((int) cicloTimeOut);
	}
}
