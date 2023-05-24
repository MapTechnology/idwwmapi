package injetws.webservices.dto;

import java.io.Serializable;
import injetws.model.pojos.PrUpExecinspecao;

@SuppressWarnings("serial")
public class IwsInspecaoManualDTO implements Serializable {
	// resultado da solicitação dados inspecao (1-ligado 0-desligado)
	private String inf01;

	// cógigo do produto
	private String inf02;

	// data hora do alerta de inspeção
	private String inf03;

	private boolean isInspEmAndamento;
	
	private boolean isComAlertaProbQualidade=false;
	
	private boolean isSemInspecao;
	
	private boolean erro;
	private String msgErro;
	
	private boolean isMARPOSSDesloc;
	
	private IwsDadosInspDTO prupexecinspecao;
	
	private String idUp;
	
	public IwsInspecaoManualDTO(){
	}

	/**
	 * @return Resultado da solicitação dos dados de inspeção. Se {@code 1} há
	 *         inspeção de qualidade pendente, {@code 0} não há.
	 */
	public String getInf01() {
		return (this.inf01);
	}

	/**
	 * 
	 * @param inf01
	 *            resultado da solicitação de dados de inspeção
	 */
	public void setInf01(String inf01) {
		this.inf01 = inf01;
	}

	/**
	 * @return Código do produto
	 */
	public String getInf02() {
		return (this.inf02);
	}

	/**
	 * 
	 * @param inf02
	 *            código do produto
	 */
	public void setInf02(String inf02) {
		this.inf02 = inf02;
	}

	/**
	 * @return Data/hora do alerta de inspeção
	 */
	public String getInf03() {
		return (this.inf03);
	}

	/**
	 * 
	 * @param inf03
	 *            data hora do alerta de inspeção
	 */
	public void setInf03(String inf03) {
		this.inf03 = inf03;
	}

	public boolean getErro() {
		return (this.erro);
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}
	
	public String getMsgErro() {
		return (this.msgErro);
	}

	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}
	
	/**
	 * @return Up com alerta de problema de qualidade
	 */
	public boolean getIscomalertaprobqualidade() {
		return isComAlertaProbQualidade;
	}
	
	/**
	 * 
	 * @param isComAlertaProbQualidade
	 * Determina a condição de alerta de problema de qualidade
	 */
	public void setIscomalertaprobqualidade(boolean isComAlertaProbQualidade) {
		this.isComAlertaProbQualidade = isComAlertaProbQualidade;
	}
	
	/**
	 * @return Up com inspeção em andamento
	 */
	public boolean getIsinspemandamento() {
		return isInspEmAndamento;
	}
	
	/**
	 * 
	 * @param isInspEmAndamento
	 * Determina a condição de inspeção em andamento
	 */
	public void setIsinspemandamento(boolean isInspEmAndamento) {
		this.isInspEmAndamento = isInspEmAndamento;
	}
	
	/**
	 * @return Up sem inspeção para executar
	 */
	public boolean getIsSemInspecao() {
		return isSemInspecao;
	}
	
	/**
	 * 
	 * @param IsSemInspecao
	 * Determina a condição de inspeção a serem executadas
	 */
	public void setIsSemInspecao(boolean isSemInspecao) {
		this.isSemInspecao = isSemInspecao;
	}

	/**
	 * @return tabela PrUpExecinspecao
	 */
	public IwsDadosInspDTO getPrupexecinspecao() {
		return prupexecinspecao;
	}

	/**
	 * 
	 * @param prupexecinspecao
	 * Determina os parâmetros da tabela prUpExecinspecao
	 */
	public void setPrupexecinspecao(IwsDadosInspDTO prupexecinspecao) {
		this.prupexecinspecao = prupexecinspecao;
	}
	/**
	 * 
	 * @param isMARPOSSDesloc
	 * Determina se a Coluna de medicao esta deslocada
	 */
	public void setIsMARPOSSDesloc(boolean isMARPOSSDesloc) {
		this.isMARPOSSDesloc = isMARPOSSDesloc;
	}
	/**
	 * @return confirmacao de deslocamento da coluna de medicao
	 */
	public boolean getIsMARPOSSDesloc() {
		return isMARPOSSDesloc;
	}	
	
	public void setIdUp(String idUp) {
		this.idUp = idUp;
	}

	public String getIdUp() {
		return idUp;
	}

	public void copyPrUpExecinspecao(PrUpExecinspecao execinsp)
	{
		this.prupexecinspecao = new IwsDadosInspDTO();
		this.prupexecinspecao.setAmostra(execinsp.getAmostra());
		this.prupexecinspecao.setIdExecInpecao(execinsp.getIdExecInpecao());
		this.prupexecinspecao.setIdInspecao(execinsp.getIdInspecao());
		this.prupexecinspecao.setOrdemLeitura(execinsp.getOrdemLeitura());
		this.prupexecinspecao.setIdParametro(execinsp.getIdParametro());
		this.prupexecinspecao.setTpParametro(execinsp.getTpParametro());
		this.prupexecinspecao.setDsParametro(execinsp.getDsParametro());
		this.prupexecinspecao.setCdProduto(execinsp.getCdProduto());
		this.prupexecinspecao.setDsProduto(execinsp.getDsProduto());
		this.prupexecinspecao.setTamAmostra(execinsp.getTamAmostra());
		this.prupexecinspecao.setIdCavidade(execinsp.getIdCavidade());
		this.prupexecinspecao.setNmCavidade(execinsp.getNmCavidade());
		this.prupexecinspecao.setAmostra(execinsp.getAmostra());
		this.prupexecinspecao.setSubAmostra(execinsp.getSubAmostra());
		this.prupexecinspecao.setVlLido(execinsp.getVlLido());
		this.prupexecinspecao.setStExecucao(execinsp.getStExecucao());
		this.prupexecinspecao.setIdParametroComp(execinsp.getIdParametroComp());
		this.prupexecinspecao.setTpEntradaVlr(execinsp.getTpEntradaVlr());
		this.prupexecinspecao.setIdDriver(execinsp.getIdDriver());
		if(execinsp.getLipercTolerancia() != null)
			this.prupexecinspecao.setLipercTolerancia(execinsp.getLipercTolerancia().toString());
		else
			this.prupexecinspecao.setLipercTolerancia(null);
		if(execinsp.getLspercTolerancia() != null)
			this.prupexecinspecao.setLspercTolerancia(execinsp.getLspercTolerancia().toString());
		else
			this.prupexecinspecao.setLspercTolerancia(null);
	}
}
