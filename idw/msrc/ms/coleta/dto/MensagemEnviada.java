package ms.coleta.dto;

import idw.model.pojos.MsPerfilandon;
import idw.webservices.dto.DadosProdutoSADTO;
import injetws.webservices.dto.IwsConsultaDTO;
import injetws.webservices.dto.IwsCpDTO;
import injetws.webservices.dto.IwsParadaDTO;
import injetws.webservices.dto.IwsRefugoDTO;

import java.util.Date;
import java.util.List;

import ms.coleta.protocolo.ProtocoloSaida;
import ms.coleta.protocolo.ProtocoloSaidaFactory;
import ms.model.dto.MsDTO;

public class MensagemEnviada {
	
	
	private boolean isRecebido = false;
	private MensagemRecebida mensagemRecebida;
	private String msgResposta;
	private MsDTO msDTO;
	private boolean resultadoRefugo;
	private boolean usuarioLogado;
	private boolean loginOperadorAutenticado;
	private boolean logoutEfetuado;
	private boolean alertaIniciado;
	private boolean cipIniciado;
	private boolean varRitmoIniciado;
	private boolean varRitmoFinalizado;
	private boolean motivoVarRitmoAlterado;
	private boolean cipFinalizado;
	private boolean alertaParada;
	private boolean acaovalida;
	private boolean causavalida;
	private boolean justvalida;
	private boolean isParadaFinalizada;
	private boolean tecnico1valido;
	private boolean tecnico2valido;
	private boolean tecnicoResponsavelValido;
	private boolean motivoParada;
	private boolean flagmotivoparada;
	private boolean opfinalizada;
	private int nsValido;
	private boolean refugoValido;
	private boolean opCriadaComSucesso;
	private boolean isConsultaOK;
	
	private boolean flagParada;  
	private boolean ihmDesconhecido = false;
	private boolean servicoFalhou = false;
	
	
	private IwsConsultaDTO consulta;
	private IwsRefugoDTO refugo;
	private IwsParadaDTO parada;
	private IwsCpDTO cp;
	private String nrOp;
	private long qtd;
	private String cdProduto;
	private String cdFolha;
	private long idFolha;
	private String cdCp;
	private String dsTurno;
	private String intervaloHora;
	private long cicloPadrao;
	private long cicloMedio;
	private long cicloTimeout;
	private long cicloMinimo;
	private long timeoutCIP;
	private long qtdPorCiclo;
	private double prodLiquida;
	private double efiRealizacao;
	private double efiCiclos;
	private double efiCiclosTurno;
	private double efiCiclosOP;
	private double producaoRefugada;
	private double indiceRefugo;
	private double indiceQualidade;
	private double indiceParadas;
	private double indiceUtilizacao;
	private double indiceParadasPorOP;
	private double indiceParadasPorTurno;
	private double indiceProducao;
	private double produtividadeOEE;
	private double metaOEE;
	private double metaInstantanea;
	private double metaProdHora;
	private double saldoAProduzir;
	private int tipoServico;
	private boolean isCip;
	private String cipDthrIni;
	private String cipDuration;
	private List<DadosProdutoSADTO> listaProdutosDTO;
	private List<String> listProdutos;
	
	private SessaoICDTO sessaoIC;
	
	private Date dataRefMensagemEnviada;
	// Ailton 2019-08-06: modificacao para permitir a consulta no perfil do andon
	private MsPerfilandon msPerfilAndon;

	public MensagemEnviada() {
	}
	
	public MensagemEnviada(MsDTO msDTO,MensagemRecebida mensagemRecebida ) {
		this.mensagemRecebida = mensagemRecebida;
		this.msDTO = msDTO;
	}

	public MensagemEnviada(MensagemRecebida mensagemRecebida) {
		this.mensagemRecebida = mensagemRecebida;
	}

	public void setRecebidoComSucesso(boolean isRecebido) {
		this.isRecebido = isRecebido;
	}

	public MensagemRecebida getMensagemRecebida() {
		return this.mensagemRecebida;
	}

	public boolean isRecebidoComSucesso() {
		return this.isRecebido;
	}

	public String getMensagemASerTransmitida() {
		try{
			return ProtocoloSaidaFactory.getInstancia(this).parsePacoteDeTransferencia(this);
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getMensagemAndonASerTransmitida(List<ParametroDTO> lista) {
		return ProtocoloSaida.parsePacoteDeTransferenciaAndon(lista);
	}

	public void setMsDTO(MsDTO msDTO) {
		this.msDTO = msDTO;
	}

	public MsDTO getMsDTO() {
		return msDTO;
	}

	public void setMsgResposta(String msgResposta) {
		this.msgResposta = msgResposta;
	}

	public String getMsgResposta() {
		return msgResposta;
	}

	public void setResultadoRefugo(boolean resultadoRefugo) {
		this.resultadoRefugo = resultadoRefugo;
	}

	public boolean getResultadoRefugo() {
		return resultadoRefugo;
	}

	public void setUsuarioLogado(boolean usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public boolean isUsuarioLogado() {
		return usuarioLogado;
	}

	public void setLoginOperadorAutenticado(boolean loginOperadorAutenticado) {
		this.loginOperadorAutenticado = loginOperadorAutenticado;
	}

	public boolean isLoginOperadorAutenticado() {
		return loginOperadorAutenticado;
	}

	public void setLogoutEfetuado(boolean logoutEfetuado) {
		this.logoutEfetuado = logoutEfetuado;
	}

	public boolean isLogoutEfetuado() {
		return logoutEfetuado;
	}

	public void setAlertaIniciado(boolean alertaIniciado) {
		this.alertaIniciado = alertaIniciado;
	}

	public boolean isAlertaIniciado() {
		return alertaIniciado;
	}

	public void setAlertaParada(boolean alertaParada) {
		this.alertaParada = alertaParada;
	}

	public boolean isAlertaParada() {
		return alertaParada;
	}

	public void setConsulta(IwsConsultaDTO consulta) {
		this.consulta = consulta;
	}

	public IwsConsultaDTO getConsulta() {
		return consulta;
	}

	public void setRefugo(IwsRefugoDTO refugo) {
		this.refugo = refugo;
	}

	public IwsRefugoDTO getRefugo() {
		return refugo;
	}

	public void setAcaovalida(boolean acaovalida) {
		this.acaovalida = acaovalida;
	}

	public boolean isAcaovalida() {
		return acaovalida;
	}

	public void setCausavalida(boolean causavalida) {
		this.causavalida = causavalida;
	}

	public boolean isCausavalida() {
		return causavalida;
	}

	public void setJustvalida(boolean justvalida) {
		this.justvalida = justvalida;
	}

	public boolean isJustvalida() {
		return justvalida;
	}

	public void setTecnico1valido(boolean tecnico1valido) {
		this.tecnico1valido = tecnico1valido;
	}

	public boolean isTecnico1valido() {
		return tecnico1valido;
	}

	public void setTecnico2valido(boolean tecnico2valido) {
		this.tecnico2valido = tecnico2valido;
	}

	public boolean isTecnico2valido() {
		return tecnico2valido;
	}

	public void setTecnicoResponsavelValido(boolean tecnicoResponsavelValido) {
		this.tecnicoResponsavelValido = tecnicoResponsavelValido;
	}

	public boolean isTecnicoResponsavelValido() {
		return tecnicoResponsavelValido;
	}

	public void setMotivoParada(boolean motivoParada) {
		this.motivoParada = motivoParada;
	}

	public boolean isMotivoParada() {
		return motivoParada;
	}

	public void setParada(IwsParadaDTO parada) {
		this.parada = parada;
	}

	public IwsParadaDTO getParada() {
		return parada;
	}

	public boolean isFlagParada() {
		return flagParada;
	}

	public void setFlagParada(boolean flagParada) {
		this.flagParada = flagParada;
	}

	public void setCp(IwsCpDTO cp) {
		this.cp = cp;
	}

	public IwsCpDTO getCp() {
		return cp;
	}

	public void setFlagmotivoparada(boolean flagmotivoparada) {
		this.flagmotivoparada = flagmotivoparada;
	}

	public boolean isFlagmotivoparada() {
		return flagmotivoparada;
	}

	public void setIhmDesconhecido(boolean ihmDesconhecido) {
		this.ihmDesconhecido = ihmDesconhecido;
	}

	public boolean isIhmDesconhecido() {
		return ihmDesconhecido;
	}

	public void setServicoFalhou(boolean servicoFalhou) {
		this.servicoFalhou = servicoFalhou;
	}

	public boolean isServicoFalhou() {
		return servicoFalhou;
	}

	public void setOpfinalizada(boolean opfinalizada) {
		this.opfinalizada = opfinalizada;
	}

	public boolean isOpfinalizada() {
		return opfinalizada;
	}

	public void setParadaFinalizada(boolean isParadaFinalizada) {
		this.isParadaFinalizada = isParadaFinalizada;
	}

	public boolean isParadaFinalizada() {
		return isParadaFinalizada;
	}
	
	public int getNSValido() {
		return nsValido;
	}

	public void setNsvalido(int nsValido) {
		this.nsValido = nsValido;
	}

	public boolean isRefugoValido() {
		return refugoValido;
	}

	public void setRefugoValido(boolean refugoValido) {
		this.refugoValido = refugoValido;
	}
	

	public boolean isOpCriadaComSucesso() {
		return opCriadaComSucesso;
	}

	public void setOpCriadaComSucesso(boolean opCriadaComSucesso) {
		this.opCriadaComSucesso = opCriadaComSucesso;
	}

	public String getNrOp() {
		return nrOp;
	}

	public void setNrOp(String nrOp) {
		this.nrOp = nrOp;
	}

	public long getQtd() {
		return qtd;
	}

	public void setQtd(long qtd) {
		this.qtd = qtd;
	}

	public String getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}

	public long getCicloPadrao() {
		return cicloPadrao;
	}

	public void setCicloPadrao(long cicloPadrao) {
		this.cicloPadrao = cicloPadrao;
	}

	public long getQtdPorCiclo() {
		return qtdPorCiclo;
	}

	public void setQtdPorCiclo(long qtdPorCiclo) {
		this.qtdPorCiclo = qtdPorCiclo;
	}

	public long getCicloTimeout() {
		return cicloTimeout;
	}

	public void setCicloTimeout(long cicloTimeout) {
		this.cicloTimeout = cicloTimeout;
	}

	public double getProdLiquida() {
		return prodLiquida;
	}

	public void setProdLiquida(double prodLiquida) {
		this.prodLiquida = prodLiquida;
	}

	public double getEfiRealizacao() {
		return efiRealizacao;
	}

	public void setEfiRealizacao(double efiRealizacao) {
		this.efiRealizacao = efiRealizacao;
	}

	public boolean isConsultaOK() {
		return isConsultaOK;
	}

	public void setConsultaOK(boolean isConsultaOK) {
		this.isConsultaOK = isConsultaOK;
	}

	public double getProducaoRefugada() {
		return producaoRefugada;
	}

	public void setProducaoRefugada(double producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}

	public double getIndiceRefugo() {
		return indiceRefugo;
	}

	public void setIndiceRefugo(double indiceRefugo) {
		this.indiceRefugo = indiceRefugo;
	}

	public double getIndiceParadas() {
		return indiceParadas;
	}

	public void setIndiceParadas(double indiceParadas) {
		this.indiceParadas = indiceParadas;
	}

	public double getIndiceParadasPorOP() {
		return indiceParadasPorOP;
	}

	public void setIndiceParadasPorOP(double indiceParadasPorOP) {
		this.indiceParadasPorOP = indiceParadasPorOP;
	}

	public double getIndiceParadasPorTurno() {
		return indiceParadasPorTurno;
	}

	public void setIndiceParadasPorTurno(double indiceParadasPorTurno) {
		this.indiceParadasPorTurno = indiceParadasPorTurno;
	}

	public double getEfiCiclos() {
		return efiCiclos;
	}

	public void setEfiCiclos(double efiCiclos) {
		this.efiCiclos = efiCiclos;
	}

	public double getEfiCiclosTurno() {
		return efiCiclosTurno;
	}

	public void setEfiCiclosTurno(double efiCiclosTurno) {
		this.efiCiclosTurno = efiCiclosTurno;
	}

	public double getEfiCiclosOP() {
		return efiCiclosOP;
	}

	public void setEfiCiclosOP(double efiCiclosOP) {
		this.efiCiclosOP = efiCiclosOP;
	}

	public int getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(int tipoMensagem) {
		this.tipoServico = tipoMensagem;
	}

	public String getDsTurno() {
		return dsTurno;
	}

	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}

	public double getProdutividadeOEE() {
		return produtividadeOEE;
	}

	public void setProdutividadeOEE(double produtividadeOEE) {
		this.produtividadeOEE = produtividadeOEE;
	}

	public double getMetaOEE() {
		return metaOEE;
	}

	public void setMetaOEE(double metaOEE) {
		this.metaOEE = metaOEE;
	}

	public double getMetaInstantanea() {
		return metaInstantanea;
	}

	public void setMetaInstantanea(double metaInstantanea) {
		this.metaInstantanea = metaInstantanea;
	}

	public String getCdFolha() {
		return cdFolha;
	}

	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}

	public String getCdCp() {
		return cdCp;
	}

	public void setCdCp(String cdCp) {
		this.cdCp = cdCp;
	}

	public String getIntervaloHora() {
		return intervaloHora;
	}

	public void setIntervaloHora(String intervaloHora) {
		this.intervaloHora = intervaloHora;
	}

	public double getIndiceQualidade() {
		return indiceQualidade;
	}

	public void setIndiceQualidade(double indiceQualidade) {
		this.indiceQualidade = indiceQualidade;
	}

	public double getIndiceProducao() {
		return indiceProducao;
	}

	public void setIndiceProducao(double indiceProducao) {
		this.indiceProducao = indiceProducao;
	}

	public double getIndiceUtilizacao() {
		return indiceUtilizacao;
	}

	public void setIndiceUtilizacao(double indiceUtilizacao) {
		this.indiceUtilizacao = indiceUtilizacao;
	}

	public double getSaldoAProduzir() {
		return saldoAProduzir;
	}

	public void setSaldoAProduzir(double saldoAProduzir) {
		this.saldoAProduzir = saldoAProduzir;
	}

	public double getMetaProdHora() {
		return metaProdHora;
	}

	public void setMetaProdHora(double metaProdHora) {
		this.metaProdHora = metaProdHora;
	}

	public List<String> getListProdutos() {
		return listProdutos;
	}

	public void setListProdutos(List<String> listProdutos) {
		this.listProdutos = listProdutos;
	}

	public long getCicloMedio() {
		return cicloMedio;
	}

	public void setCicloMedio(long cicloMedio) {
		this.cicloMedio = cicloMedio;
	}

	public List<DadosProdutoSADTO> getListaProdutosDTO() {
		return listaProdutosDTO;
	}

	public void setListaProdutosDTO(List<DadosProdutoSADTO> listaProdutosDTO) {
		this.listaProdutosDTO = listaProdutosDTO;
	}

	public long getCicloMinimo() {
		return cicloMinimo;
	}

	public void setCicloMinimo(long cicloMinimo) {
		this.cicloMinimo = cicloMinimo;
	}

	public long getTimeoutCIP() {
		return timeoutCIP;
	}

	public void setTimeoutCIP(long timeoutCIP) {
		this.timeoutCIP = timeoutCIP;
	}

	public long getIdFolha() {
		return idFolha;
	}

	public void setIdFolha(long idFolha) {
		this.idFolha = idFolha;
	}

	public boolean isCipIniciado() {
		return cipIniciado;
	}

	public void setCipIniciado(boolean cipIniciado) {
		this.cipIniciado = cipIniciado;
	}

	public boolean isCipFinalizado() {
		return cipFinalizado;
	}

	public void setCipFinalizado(boolean cipFinalizado) {
		this.cipFinalizado = cipFinalizado;
	}

	public boolean isVarRitmoIniciado() {
		return varRitmoIniciado;
	}

	public void setVarRitmoIniciado(boolean varRitmoIniciado) {
		this.varRitmoIniciado = varRitmoIniciado;
	}

	public boolean isVarRitmoFinalizado() {
		return varRitmoFinalizado;
	}

	public void setVarRitmoFinalizado(boolean varRitmoFinalizado) {
		this.varRitmoFinalizado = varRitmoFinalizado;
	}

	public boolean isMotivoVarRitmoAlterado() {
		return motivoVarRitmoAlterado;
	}

	public void setMotivoVarRitmoAlterado(boolean motivoVarRitmoAlterado) {
		this.motivoVarRitmoAlterado = motivoVarRitmoAlterado;
	}

	public boolean isCip() {
		return isCip;
	}

	public void setCip(boolean isCip) {
		this.isCip = isCip;
	}

	public String getCipDthrIni() {
		return cipDthrIni;
	}

	public void setCipDthrIni(String cipDthrIni) {
		this.cipDthrIni = cipDthrIni;
	}

	public String getCipDuration() {
		return cipDuration;
	}

	public void setCipDuration(String cipDuration) {
		this.cipDuration = cipDuration;
	}

	public SessaoICDTO getSessaoIC() {
		return sessaoIC;
	}

	public void setSessaoIC(SessaoICDTO sessaoIC) {
		this.sessaoIC = sessaoIC;
	}

	public Date getDataRefMensagemEnviada() {
		return dataRefMensagemEnviada;
	}

	public void setDataRefMensagemEnviada(Date dataRefMensagemEnviada) {
		this.dataRefMensagemEnviada = dataRefMensagemEnviada;
	}

	public void setMsPerfilAndon(MsPerfilandon msPerfilAndon) {
		this.msPerfilAndon = msPerfilAndon;
	}
	
	public MsPerfilandon getMsPerfilAndon() {
		return msPerfilAndon;
	}
}
