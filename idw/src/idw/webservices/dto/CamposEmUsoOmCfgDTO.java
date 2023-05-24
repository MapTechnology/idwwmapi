package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
*
* @author Alex 17/03/2017
*/
@XmlRootElement
@SuppressWarnings("serial")
public class CamposEmUsoOmCfgDTO implements Serializable {
	
	public final int STATUS_NENHUM_CAMPO_EM_USO = 1;
	public final int STATUS_TEM_CAMPO_EM_USO = 2;
	public final int STATUS_EXCLUSAO_ABORTADA = 3;
	
	private int status;
	private String codigo;
	
	//aba importacao
	private boolean isUsuarioParaImportarProgramasIAC;
	private boolean isProdutoDefaultParaImportacaoIAC;
	private boolean isGT;	
	private boolean isParada;
	private boolean isRefugo;
	private boolean isMotivoPadraoParaVariacaoRitmo;
	private boolean isParadaPadraoPeriodoSemConexao;
	
	//aba alimentacao materia prima
	private boolean isEstoqueAlimentacao;
	private boolean isLocalEstoqueOrigem;
	
	//aba indicadores
	private boolean isClassificacaoABC;
	
	//aba estoque
	private boolean isEstoqueLiberado;
	private boolean isEstoqueProducao;
	private boolean isEstoqueRefugado;
	private boolean isEstoqueExpedicao;
	private boolean isEstoqueMateriaPrima;
	
	//aba variavel resposta
	private boolean isCorrente;
	private boolean isFluxoEntrada;
	private boolean isFluxoSaida;
	private boolean isTensao;
	private boolean isFatorPotencia;
	private boolean isEnergiaConsumida;
	private boolean isTemperatura;
	
	//aba grupo trabalho
	private boolean isEmpresa;
	
	//aba usuario
	private boolean isGrupoUsuarioSupervisor;
	private boolean isGrupoUsuarioOperador;
	
	//aba horarios
	private boolean isCalendario;
	private boolean isParadaPadraoCIP;
	private boolean isAlertaAutomaticoCIP;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isParada() {
		return isParada;
	}
	public void setParada(boolean isParada) {
		this.isParada = isParada;
	}
	public boolean isParadaPadraoPeriodoSemConexao() {
		return isParadaPadraoPeriodoSemConexao;
	}
	public void setParadaPadraoPeriodoSemConexao(
			boolean isParadaPadraoPeriodoSemConexao) {
		this.isParadaPadraoPeriodoSemConexao = isParadaPadraoPeriodoSemConexao;
	}
	public int getSTATUS_NENHUM_CAMPO_EM_USO() {
		return STATUS_NENHUM_CAMPO_EM_USO;
	}
	public int getSTATUS_TEM_CAMPO_EM_USO() {
		return STATUS_TEM_CAMPO_EM_USO;
	}
	public int getSTATUS_EXCLUSAO_ABORTADA() {
		return STATUS_EXCLUSAO_ABORTADA;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isUsuarioParaImportarProgramasIAC() {
		return isUsuarioParaImportarProgramasIAC;
	}
	public void setUsuarioParaImportarProgramasIAC(
			boolean isUsuarioParaImportarProgramasIAC) {
		this.isUsuarioParaImportarProgramasIAC = isUsuarioParaImportarProgramasIAC;
	}
	public boolean isProdutoDefaultParaImportacaoIAC() {
		return isProdutoDefaultParaImportacaoIAC;
	}
	public void setProdutoDefaultParaImportacaoIAC(
			boolean isProdutoDefaultParaImportacaoIAC) {
		this.isProdutoDefaultParaImportacaoIAC = isProdutoDefaultParaImportacaoIAC;
	}
	public boolean isGT() {
		return isGT;
	}
	public void setGT(boolean isGT) {
		this.isGT = isGT;
	}
	public boolean isRefugo() {
		return isRefugo;
	}
	public void setRefugo(boolean isRefugo) {
		this.isRefugo = isRefugo;
	}
	public boolean isMotivoPadraoParaVariacaoRitmo() {
		return isMotivoPadraoParaVariacaoRitmo;
	}
	public void setMotivoPadraoParaVariacaoRitmo(
			boolean isMotivoPadraoParaVariacaoRitmo) {
		this.isMotivoPadraoParaVariacaoRitmo = isMotivoPadraoParaVariacaoRitmo;
	}
	public boolean isGrupoUsuarioSupervisor() {
		return isGrupoUsuarioSupervisor;
	}
	public void setGrupoUsuarioSupervisor(boolean isGrupoUsuarioSupervisor) {
		this.isGrupoUsuarioSupervisor = isGrupoUsuarioSupervisor;
	}
	public boolean isGrupoUsuarioOperador() {
		return isGrupoUsuarioOperador;
	}
	public void setGrupoUsuarioOperador(boolean isGrupoUsuarioOperador) {
		this.isGrupoUsuarioOperador = isGrupoUsuarioOperador;
	}
	public boolean isEstoqueLiberado() {
		return isEstoqueLiberado;
	}
	public void setEstoqueLiberado(boolean isEstoqueLiberado) {
		this.isEstoqueLiberado = isEstoqueLiberado;
	}
	public boolean isEstoqueProducao() {
		return isEstoqueProducao;
	}
	public void setEstoqueProducao(boolean isEstoqueProducao) {
		this.isEstoqueProducao = isEstoqueProducao;
	}
	public boolean isEstoqueRefugado() {
		return isEstoqueRefugado;
	}
	public void setEstoqueRefugado(boolean isEstoqueRefugado) {
		this.isEstoqueRefugado = isEstoqueRefugado;
	}
	public boolean isEstoqueExpedicao() {
		return isEstoqueExpedicao;
	}
	public void setEstoqueExpedicao(boolean isEstoqueExpedicao) {
		this.isEstoqueExpedicao = isEstoqueExpedicao;
	}
	public boolean isEstoqueMateriaPrima() {
		return isEstoqueMateriaPrima;
	}
	public void setEstoqueMateriaPrima(boolean isEstoqueMateriaPrima) {
		this.isEstoqueMateriaPrima = isEstoqueMateriaPrima;
	}
	public boolean isEstoqueAlimentacao() {
		return isEstoqueAlimentacao;
	}
	public void setEstoqueAlimentacao(boolean isEstoqueAlimentacao) {
		this.isEstoqueAlimentacao = isEstoqueAlimentacao;
	}
	public boolean isLocalEstoqueOrigem() {
		return isLocalEstoqueOrigem;
	}
	public void setLocalEstoqueOrigem(boolean isLocalEstoqueOrigem) {
		this.isLocalEstoqueOrigem = isLocalEstoqueOrigem;
	}
	public boolean isClassificacaoABC() {
		return isClassificacaoABC;
	}
	public void setClassificacaoABC(boolean isClassificacaoABC) {
		this.isClassificacaoABC = isClassificacaoABC;
	}
	public boolean isCorrente() {
		return isCorrente;
	}
	public void setCorrente(boolean isCorrente) {
		this.isCorrente = isCorrente;
	}
	public boolean isFluxoEntrada() {
		return isFluxoEntrada;
	}
	public void setFluxoEntrada(boolean isFluxoEntrada) {
		this.isFluxoEntrada = isFluxoEntrada;
	}
	public boolean isFluxoSaida() {
		return isFluxoSaida;
	}
	public void setFluxoSaida(boolean isFluxoSaida) {
		this.isFluxoSaida = isFluxoSaida;
	}
	public boolean isTensao() {
		return isTensao;
	}
	public void setTensao(boolean isTensao) {
		this.isTensao = isTensao;
	}
	public boolean isFatorPotencia() {
		return isFatorPotencia;
	}
	public void setFatorPotencia(boolean isFatorPotencia) {
		this.isFatorPotencia = isFatorPotencia;
	}
	public boolean isEnergiaConsumida() {
		return isEnergiaConsumida;
	}
	public void setEnergiaConsumida(boolean isEnergiaConsumida) {
		this.isEnergiaConsumida = isEnergiaConsumida;
	}
	public boolean isTemperatura() {
		return isTemperatura;
	}
	public void setTemperatura(boolean isTemperatura) {
		this.isTemperatura = isTemperatura;
	}
	public boolean isCalendario() {
		return isCalendario;
	}
	public void setCalendario(boolean isCalendario) {
		this.isCalendario = isCalendario;
	}
	public boolean isParadaPadraoCIP() {
		return isParadaPadraoCIP;
	}
	public void setParadaPadraoCIP(boolean isParadaPadraoCIP) {
		this.isParadaPadraoCIP = isParadaPadraoCIP;
	}
	public boolean isAlertaAutomaticoCIP() {
		return isAlertaAutomaticoCIP;
	}
	public void setAlertaAutomaticoCIP(boolean isAlertaAutomaticoCIP) {
		this.isAlertaAutomaticoCIP = isAlertaAutomaticoCIP;
	}
	public boolean isEmpresa() {
		return isEmpresa;
	}
	public void setEmpresa(boolean isEmpresa) {
		this.isEmpresa = isEmpresa;
	}
	

}
