package 	ms.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.webservices.dto.DefeitoDTO;
import idw.webservices.dto.ErroInsersoraDTO;
import idw.webservices.dto.FeederDTO;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.NozzleDTO;
import injetws.webservices.dto.IwsDadosApontamentoDTO;
import injetws.webservices.dto.IwsDadosCCKDTO;
import ms.coleta.Stubedelegate;
import ms.util.UtilsThreads;

public class EventoColetado {
	private IdwLogger log;
	private int idLog;
	private int identacao;
	
	private BigDecimal idEvt;
	private int tipoEvento;
	private IcUpDTO icUpDTO;
	private Date dthrEvento;
	private String qtdEventosPendentes;

	private boolean isExiste = false;
	private boolean isChamarInjetWs = false;

	private String tpSessao;
	private String milisec;
	private String dthrUltimoRefugo;
	private String idUpPdba;
	private String login;
	private String qtdeciclos;
	private String cdalerta;
	private String cddefeito;
	private String cdconsulta;
	private String cdacao;
	private String cdparada;
	private String cdjustificativa;
	private String cdarearesponsavel;
	private String cdcausa;
	private String cdorigem;
	private String cdtecResponsavel;
	private String senhaTecResponsavel;
	private String cdtec1;
	private String senhaTec1;
	private String cdtec2;
	private String senhaTec2;
	private String cdproduto;
	private String cdop;
	private String cdmolde;
	private String cdestrutura;
	private String cdrefugo;
	private String idRdzProduto;
	private String qtde;
	private String origem; //Informa��o da linha do evento que foi enviado
	// Alessandre: Inclui o sequencial abaixo em 17-10-12 para permitir registrar o sequencial das placas da coleta do insert
	private Integer sequencial;
	private String senha;
	private String cb;
	private String cbserial;
	private String ns;
	private String cdFolha;
	private String up;
	private Date dthrinicioEvento; // esse atributo sera usado para o evento de motivo parada
	private int pepro;
	private Boolean isCbConforme = true; // Se false o produto esta nao conforme
	
	private Integer paradaDefault = null;	
	private BigDecimal parametroLido=null;
	private BigDecimal pressao;
	private BigDecimal temperatura;
	private BigDecimal velocidade;
	
	private BigDecimal segCiclopadrao; // sera usado por alguns IC IHMs que querem criar a folha com o ciclo certo
	
	private String foraFaixaInicial; // fora Faixa vai conter a faixa que o parametro de medicao saiu gernado um email
	private String foraFaixaFinal;
	
	//PH: Adicionando a informa��o do feeder e do nozzle
	private List<FeederDTO> feeders = null;
	private List<NozzleDTO> nozzles = null;
	private List<MontagemDTO> montagem = null;
	
	private Boolean isMontagemFechadaAntecipadamente = false;
	
	private ErroInsersoraDTO erroInsersora = null;
	private IwsDadosApontamentoDTO pacoteCiclo; // pacote de ciclo do injet
	
	private boolean isEventoApenasInformativo = false; // Se true o evento sera salvo com stEvt = 3 deixando de ser processado
	
	private IwsDadosCCKDTO dadosCCK = null;
	
	/* Atributos para a coleta da producao liquida e producao refugada vindas dos drivers da Sony
	 * 
	 */
	private BigDecimal producaoLiquida;
	private BigDecimal producaoRefugada;
	
//	 Atributo utilizado para indicar a zona do forno a que 
//   o evento se refere
	private byte zona;
	
	// Ailton 2018-08-15: Lista de defeitos de uma passagem
	private List<DefeitoDTO> defeitos = null;
	
	private Long seqbigint;
	
	public EventoColetado() {
		super();
	}
	
	public EventoColetado(EventoColetado ev) {
		super();
		
		this.cb = ev.getCb();
		this.dthrEvento = ev.getDthrEvento();
		this.origem = ev.getOrigem();
		this.cdacao = ev.getCdacao();
		this.cdalerta = ev.getCdalerta();
		this.cdarearesponsavel = ev.getCdarearesponsavel();
		this.cdcausa = ev.getCdcausa();
		this.cdorigem = ev.getCdorigem();
		this.cdconsulta = ev.getCdconsulta();
		this.cddefeito = ev.getCddefeito();
		this.cdestrutura = ev.getCdestrutura();
		this.cdFolha = ev.getCdFolha();
		this.cdjustificativa = ev.getCdjustificativa();
		this.cdmolde = ev.getCdmolde();
		this.cdop = ev.getCdop();
		this.cdparada = ev.getCdparada();
		this.cdrefugo = ev.getCdrefugo();
		this.cdtec1 = ev.getCdtec1();
		this.cdtec2 = ev.getCdtec2();
		this.cdtecResponsavel = ev.getCdtecResponsavel();
		this.log = ev.getLog();
		this.idLog = ev.getIdLog();
		this.identacao = ev.getIdentacao();
		this.isChamarInjetWs = ev.isChamarInjetWs();
		this.pacoteCiclo = ev.getPacoteCiclo();
		this.isCbConforme = ev.getIsCbConforme();
		this.isEventoApenasInformativo = ev.isEventoApenasInformativo();
		this.isExiste = ev.isExiste;
		this.isMontagemFechadaAntecipadamente = ev.getIsMontagemFechadaAntecipadamente();
		this.milisec = ev.getMilisec();
		this.cbserial = ev.getCbserial();
		this.cdconsulta = ev.getCdconsulta();
		this.cdestrutura = ev.getCdestrutura();
		this.dthrinicioEvento = ev.getDthrinicioEvento();
		this.dthrUltimoRefugo = ev.getDthrUltimoRefugo();
		this.idRdzProduto = ev.getIdRdzProduto();
		this.idUpPdba = ev.getIdUpPdba();
		this.parametroLido = ev.getParametroLido();
	}
	
	public String getNumeroSerie(){
		return ns;
	}
	
	public void setNumeroSerie(String ns){
		this.ns=ns;
	}
	
	public Integer getSequencial() {
		return sequencial;
	}

	
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public String getIdUpPdba(){
		return this.idUpPdba;
	}
	
	public void setIdUpPdba(String idUpPdba) {
		this.idUpPdba = idUpPdba;
		// MSThread sera null quando a thread nao tiver sido inicializa
		int ntentativas = 0;
		do {
			try {

				if (Stubedelegate.getInstancia().getMsthread() != null) {
					for (Iterator<IcDTO> iDadosicdto = Stubedelegate.getInstancia().getMsthread().getListaDadosIcDto().iterator() ; iDadosicdto.hasNext() ; ) {
						IcDTO dadosicdto = iDadosicdto.next();
						for (Iterator<IcUpDTO> iicup = dadosicdto.getMsIcUpDTOLocais().iterator() ; iicup.hasNext() ; ){
							IcUpDTO icup = iicup.next();
							if (icup != null && icup.getUpDTO() != null && icup.getUpDTO().getIdUpPDBA() != null && icup.getUpDTO().getIdUpPDBA().equals(idUpPdba) == true) {
								icUpDTO = icup;
								return;
							}
						}
					}
				}
				ntentativas = 10;
				break;
			} catch (Exception e) {
				e.printStackTrace();
				UtilsThreads.pausaNaThread(300);
				ntentativas++;
			}
		} while (ntentativas < 3);

	}

	public String getCdrefugo() {
		return cdrefugo;
	}

	public void setCdrefugo(String cdrefugo) {
		this.cdrefugo = cdrefugo;
	}

	public String getIdRdzProduto() {
		return idRdzProduto;
	}

	public void setIdRdzProduto(String idRdzProduto) {
		this.idRdzProduto = idRdzProduto;
	}

	public String getQtde() {
		return qtde;
	}

	public void setQtde(String qtde) {
		this.qtde = qtde;
	}

	public String getCdproduto() {
		return cdproduto;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	public String getCdop() {
		return cdop;
	}

	public void setCdop(String cdop) {
		this.cdop = cdop;
	}

	public String getCdmolde() {
		return cdmolde;
	}

	public void setCdmolde(String cdmolde) {
		this.cdmolde = cdmolde;
	}

	public String getCdestrutura() {
		return cdestrutura;
	}

	public void setCdestrutura(String cdestrutura) {
		this.cdestrutura = cdestrutura;
	}

	public String getTpSessao() {
		return tpSessao;
	}

	public void setTpSessao(String tpSessao) {
		this.tpSessao = tpSessao;
	}

	public String getQtdeciclos() {
		return qtdeciclos;
	}

	public void setQtdeciclos(String qtdeciclos) {
		this.qtdeciclos = qtdeciclos;
	}

	public String getCdacao() {
		return cdacao;
	}

	public void setCdacao(String cdacao) {
		this.cdacao = cdacao;
	}

	public String getCdparada() {
		return cdparada;
	}

	public void setCdparada(String cdparada) {
		this.cdparada = cdparada;
	}

	public String getCdjustificativa() {
		return cdjustificativa;
	}

	public void setCdjustificativa(String cdjustificativa) {
		this.cdjustificativa = cdjustificativa;
	}

	public String getCdcausa() {
		return cdcausa;
	}

	public void setCdcausa(String cdcausa) {
		this.cdcausa = cdcausa;
	}

	public String getCdorigem() {
		return cdorigem;
	}

	public void setCdorigem(String cdorigem) {
		this.cdorigem = cdorigem;
	}

	public String getCdtecResponsavel() {
		return cdtecResponsavel;
	}

	public void setCdtecResponsavel(String cdtecResponsavel) {
		this.cdtecResponsavel = cdtecResponsavel;
	}
	
	public String getSenhaTecResponsavel(){
		return senhaTecResponsavel;
	}
	
	public void setSenhaTecResponsavel(String senhaTecResponsavel){
		this.senhaTecResponsavel = senhaTecResponsavel;
	}

	public String getCdtec1() {
		return cdtec1;
	}

	public void setCdtec1(String cdtec1) {
		this.cdtec1 = cdtec1;
	}
	
	public String getSenhaTec1(){
		return senhaTec1;
	}
	
	public void setSenhaTec1(String senhaTec1){
		this.senhaTec1 = senhaTec1;
	}

	public String getCdtec2() {
		return cdtec2;
	}

	public void setCdtec2(String cdtec2) {
		this.cdtec2 = cdtec2;
	}
	
	public String getSenhaTec2(){
		return senhaTec2;
	}
	
	public void setSenhaTec2(String senhaTec2){
		this.senhaTec2 = senhaTec2;
	}

	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}

	public BigDecimal getIdEvt() {
		return idEvt;
	}

	public void setIdEvt(BigDecimal idEvt) {
		this.idEvt = idEvt;
	}

	public void setDthrEvento(Date dthr) {
		this.dthrEvento = dthr;
	}

	public Date getDthrEvento() {
		return this.dthrEvento;
	}

	public IcUpDTO getIcUpDTO() {
		return this.icUpDTO;
	}

	public void setIcUpDTO(IcUpDTO msgerenciado) {
		this.icUpDTO = msgerenciado;
	}

	public int getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(int tipo) {
		this.tipoEvento = tipo;
	}

	public void setCdalerta(String cdalerta) {
		this.cdalerta = cdalerta;
	}

	public String getCdalerta() {
		return cdalerta;
	}

	public void setCdconsulta(String cdconsulta) {
		this.cdconsulta = cdconsulta;
	}

	public String getCdconsulta() {
		return cdconsulta;
	}

	public void setDthrUltimoRefugo(String dthrUltimoRefugo) {
		this.dthrUltimoRefugo = dthrUltimoRefugo;
	}

	public String getDthrUltimoRefugo() {
		return dthrUltimoRefugo;
	}

	public void setMilisec(String milisec) {
		this.milisec = milisec;
	}

	public String getMilisec() {
		return milisec;
	}

	public boolean isExisteEvento() {
		return isExiste;
	}

	public void setExisteEvento(boolean isExiste) {
		this.isExiste = isExiste;
	}
	
	public IwsDadosCCKDTO getDadosCCK() {
		return dadosCCK;
	}

	public void setDadosCCK(IwsDadosCCKDTO dadosCCK) {
		this.dadosCCK = dadosCCK;
	}

	public String getDthrEventoFormatadoParaEnvio() {
		return DataHoraRN.dateToStringYYYYMMDDHHMMSSmili(this.dthrEvento);
	}

	public boolean isChamarInjetWs() {
		return isChamarInjetWs;
	}

	public void setChamarInjetWs(boolean isChamarInjetWs) {
		this.isChamarInjetWs = isChamarInjetWs;
	}

	public int getIdLog() {
		return idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public int getIdentacao() {
		return identacao;
	}

	public void setIdentacao(int identacao) {
		this.identacao = identacao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getParadaDefault() {
		return paradaDefault;
	}
	public void setParadaDefault(Integer paradaDefault) {
		this.paradaDefault = paradaDefault;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public List<FeederDTO> getFeeders() {
		return feeders;
	}

	public void setFeeders(List<FeederDTO> feeders) {
		this.feeders = feeders;
	}

	public List<NozzleDTO> getNozzles() {
		return nozzles;
	}

	public void setNozzles(List<NozzleDTO> nozzles) {
		this.nozzles = nozzles;
	}

	public BigDecimal getParametroLido() {
		return parametroLido;
	}

	public void setParametroLido(BigDecimal parametroLido) {
		this.parametroLido = parametroLido;
	}

	public ErroInsersoraDTO getErroInsersora() {
		return erroInsersora;
	}

	public void setErroInsersora(ErroInsersoraDTO erroInsersora) {
		this.erroInsersora = erroInsersora;
	}
	
	@Override
	public String toString(){
		StringBuilder retorno = new StringBuilder();
		retorno.append(" TipoEvento=");
		retorno.append(getTipoEvento());
		retorno.append(" Maquina=" + getIcUpDTO().getIdIcUp());
		retorno.append(" DtHrEvento=");
		retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(this.dthrEvento));
		retorno.append(" cdParada=");
		retorno.append(getCdparada());
		retorno.append(" cdTecnicoUm=");
		retorno.append(getCdtec1());
		retorno.append(" cdTecnicoDois=");
		retorno.append(getCdtec2());
		retorno.append(" cdResp=");
		retorno.append(getCdtecResponsavel());
		retorno.append(" origem=");
		retorno.append(getOrigem());
		return retorno.toString();
	}


	public IwsDadosApontamentoDTO getPacoteCiclo() {
		return pacoteCiclo;
	}


	public void setPacoteCiclo(IwsDadosApontamentoDTO pacoteCiclo) {
		this.pacoteCiclo = pacoteCiclo;
	}


	public boolean isEventoApenasInformativo() {
		return isEventoApenasInformativo;
	}


	public void setEventoApenasInformativo(boolean isEventoApenasInformativo) {
		this.isEventoApenasInformativo = isEventoApenasInformativo;
	}


	public String getCb() {
		return cb;
	}


	public void setCb(String cb) {
		this.cb = cb;
	}

	public String getCdFolha() {
		return cdFolha;
	}

	public void setCdFolha(String cdFolha) {
		this.cdFolha = cdFolha;
	}

	public String getUp() {
		return up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public int getPepro() {
		return pepro;
	}

	public void setPepro(int pepro) {
		this.pepro = pepro;
	}

	public Boolean getIsCbConforme() {
		return isCbConforme;
	}

	public void setIsCbConforme(Boolean isCbConforme) {
		this.isCbConforme = isCbConforme;
	}

	public String getCddefeito() {
		return cddefeito;
	}

	public void setCddefeito(String cddefeito) {
		this.cddefeito = cddefeito;
	}

	public List<MontagemDTO> getMontagem() {
		return montagem;
	}

	public void setMontagem(List<MontagemDTO> montagem) {
		this.montagem = montagem;
	}

	public String getQtdEventosPendentes() {
		return qtdEventosPendentes;
	}

	public void setQtdEventosPendentes(String qtdEventosPendentes) {
		this.qtdEventosPendentes = qtdEventosPendentes;
	}

	public String getCdarearesponsavel() {
		return cdarearesponsavel;
	}

	public void setCdarearesponsavel(String cdarearesponsavel) {
		this.cdarearesponsavel = cdarearesponsavel;
	}

	public Date getDthrinicioEvento() {
		return dthrinicioEvento;
	}

	public void setDthrinicioEvento(Date dthrinicioEvento) {
		this.dthrinicioEvento = dthrinicioEvento;
	}

	public BigDecimal getProducaoLiquida() {
		return producaoLiquida;
	}

	public void setProducaoLiquida(BigDecimal producaoLiquida) {
		this.producaoLiquida = producaoLiquida;
	}

	public BigDecimal getProducaoRefugada() {
		return producaoRefugada;
	}

	public void setProducaoRefugada(BigDecimal producaoRefugada) {
		this.producaoRefugada = producaoRefugada;
	}

	public Boolean getIsMontagemFechadaAntecipadamente() {
		return isMontagemFechadaAntecipadamente;
	}

	public void setIsMontagemFechadaAntecipadamente(Boolean isMontagemFechadaAntecipadamente) {
		this.isMontagemFechadaAntecipadamente = isMontagemFechadaAntecipadamente;
	}

	public byte getZona() {
		return zona;
	}

	public void setZona(byte zona) {
		this.zona = zona;
	}

	public String getCbserial() {
		return cbserial;
	}

	public void setCbserial(String cbserial) {
		this.cbserial = cbserial;
	}

	public List<DefeitoDTO> getDefeitos() {
		return defeitos;
	}

	public void setDefeitos(List<DefeitoDTO> defeitos) {
		this.defeitos = defeitos;
	}

	public BigDecimal getPressao() {
		return pressao;
	}

	public void setPressao(BigDecimal pressao) {
		this.pressao = pressao;
	}

	public BigDecimal getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(BigDecimal temperatura) {
		this.temperatura = temperatura;
	}

	public BigDecimal getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(BigDecimal velocidade) {
		this.velocidade = velocidade;
	}
	
	
	public Long getSeqbigint() {
		return seqbigint;
	}
	public void setSeqbigint(Long seqbigint) {
		this.seqbigint = seqbigint;
	}

	public String getForaFaixaInicial() {
		return foraFaixaInicial;
	}

	public void setForaFaixaInicial(String foraFaixaInicial) {
		this.foraFaixaInicial = foraFaixaInicial;
	}

	public String getForaFaixaFinal() {
		return foraFaixaFinal;
	}

	public void setForaFaixaFinal(String foraFaixaFinal) {
		this.foraFaixaFinal = foraFaixaFinal;
	}

	public BigDecimal getSegCiclopadrao() {
		return segCiclopadrao;
	}

	public void setSegCiclopadrao(BigDecimal segCiclopadrao) {
		this.segCiclopadrao = segCiclopadrao;
	}

	
}
