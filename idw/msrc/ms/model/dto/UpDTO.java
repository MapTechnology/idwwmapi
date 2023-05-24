package ms.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.pojos.MsUp;
import idw.model.pojos.OmPt;
import idw.model.pojos.template.PpCpTemplate;
import idw.util.IdwLogger;
import injetws.model.pojos.PrUp;
import injetws.model.pojos.PrUpProduto;
import injetws.webservices.dto.IwsAlertaDTO;
import ms.coleta.dto.AndonDTO;

@SuppressWarnings("serial")
public class UpDTO implements Serializable{
	private BigDecimal idUp;
	private BigDecimal revisao;
	private BigDecimal stAtivo;
	private BigDecimal idParada;	
	
	private Boolean isManterHistoricoAntesEnvio = false;
	private Boolean isManterRegistroAposTimeout = false;
	private Boolean isEnviarDadosParaWS = true;
	private Boolean isEnviarDadosParaIHM = true;
	private Boolean isIhmtrocaOP = null; // utilizado no protocolo de saida para ser enviado a sessao

	private boolean isInspecaoPendenteExecucao = false;
	private boolean isAlertaProblemaQualidade = false;
	private boolean isComOP = false;
	private boolean isComVariacaoRitmoPend=false;
	private boolean isComOpSemProducao=false;
	private boolean bloqPorParadaSemConexao=false;
	private boolean isParadaSemConexao=false;
	private boolean isParadaPermiteCorrecao=true;
	private boolean isBcOffLine = false;
	private boolean isCip = false;
	private boolean isCipIniciado = false;
	private boolean permCancelamento;
	private boolean isuptrabalhando = false;
	private boolean isparadarequerconfirmacaoparafinalizar = false;
	private boolean issinalcicloalto = false;
	private boolean isparadaregulagem = false;
	private boolean isparadapersistente = false;
	private boolean bloqPeriodoSemCon=false;
	private boolean isOPSemProducao=false;
	private boolean isVerificaParadaAutomatica = true;
	private boolean upParada;
	private boolean reqCancel;
	private boolean isOffline;

	private boolean isLerCB;
	
	private double segCicloPadrao;	
	private double msAdcParaAberturaParada;
	private double percCicloPadraoTimeout=0;
	private double vlEficienciaUltimoCiclo = 0d;
	
	private List<AndonDTO> listaEventosAndonUp = new ArrayList<AndonDTO>();
	private List<MSalertaDTO> listaAlertasEmAberto = new ArrayList<MSalertaDTO>();
	private List<UpIhmDTO> upihmColetados = new ArrayList<UpIhmDTO>();
	private List<UsuarioMSDTO> listaOperadoresLogados;
	private List<PrUpProduto> listaProdutos;
	
	

	private int resultadoUltimaInspecao = 0;
	private int tpSessao;
	private int debounce=5;

	
	private String loginUsuario;
	private String idUpPDBA; // id de Pr_up.idUp
	private String cd_up;
	private String ds_up;
	private String dsParada;
	private String cdRefugo;
	private String dsRefugo;
	private String idRdzProduto;
	private String msdthrIRefugo;
	private String cdmaqestendido;
	private String producaoliquida;
	private String nropestendido;
	private String filial;
	private String cdproduto;
	private String producaoplanejada;
	private String cdBc;
	private String cdparada = "";
	private String idAcao = "";
	private String idCausa = "";
	private String idJustificativa = "";
	private String idTecnicoResponsavel = "";
	private String idTecnicoUm = "";
	private String idTecnicoDois = "";
	private String idLocal ="";	

	private Long idTppt;
	private Long idEvtInicioCicloAnteriorAoFlush; // esse atributo tera o idEvt anterior ao update. e caso o flush falhe o idEvtInicioCiclo deve receber de volta esse valor
	private Long idEvtInicioCiclo;

	private Date dthrStativo;
	private Date dthrRevisao;
	private Date dthrIParada;
	private Date dthrFParada;
	private Date dthrIRefugo;
	private Date dtHrInicioCiclo = new Date();
	private Date dthrEvtInicioCicloAnteriorAoFlush;
	private Date dthrEvtInicioCiclo;
	
	private Float tamanhoPacoteCiclo=1f;
	
	
	
	private boolean isOPReprocesso = false;
	
	/*
	 * 0 - sem resultado
	 * 1 - aprovado
	 * 2 - reprovado
	 * 3 - aprovado com restrição
	 * */
	
	private byte paradaEmAberto;
	
	private transient IdwLogger log;
	
	
	private Integer filtroModulo = 0;
	private Integer filtroEstagio = 0;
	
	
	public UpDTO() {
	}
	
	public UpDTO(MsUp msup, OmPt ompt	) {
		this.setIdUp(msup.getIdUp());
		this.setCd_up(msup.getCdUp());
		if (ompt != null && ompt.getOmTppt() != null) {
			this.setIdTppt(ompt.getOmTppt().getIdTppt());
			if (ompt.getOmTppt().getIsIhmtrocaop() != null)
				this.isIhmtrocaOP = ompt.getOmTppt().getIsIhmtrocaop();
			
			this.setFiltroModulo(ompt.getModulo());
			this.setFiltroEstagio(ompt.getEstagio());
		} else
			this.setIdTppt(0l);
		
		this.setIdUpPDBA(msup.getIduppdba());
		this.setDs_up(msup.getDsUp());
		this.setRevisao(msup.getRevisao());
		this.setDthrRevisao(msup.getDthrRevisao());
		this.setDthrStativo(msup.getDthrStativo());
		this.setStAtivo(msup.getStAtivo());
		this.setCdBc(msup.getCdBc());
		
		if (ompt != null && ompt.getPpCp() != null) {
			if (ompt.getPpCp().obtemPrimeiroProduto() != null && ompt.getPpCp().obtemPrimeiroProduto().getIsRastreabilidade() != null)
				this.setLerCB(ompt.getPpCp().obtemPrimeiroProduto().getIsRastreabilidade());
			if (ompt.getPpCp().obtemPrimeiroProduto() != null)
				this.setCdproduto(ompt.getPpCp().obtemPrimeiroProduto().getCdProduto());

			this.setNropestendido(ompt.getPpCp().getNrop());
			if (ompt.getPpCp().getOmGt() != null)
				this.setFilial(ompt.getPpCp().getOmGt().getCdGt());
			else
				this.setFilial("SF");
			this.setIsOPReprocesso(ompt.getPpCp().getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue()));
			
		}
		
		if (msup.getMsUsr() != null)
			this.setLoginUsuario(msup.getMsUsr().getLogin());
	}
	
	private void copiaListaAndonWs(List<injetws.webservices.dto.IwsAndonDTO> listaAndon) {
		if(listaEventosAndonUp != null)
			listaEventosAndonUp.clear();
					
		if(listaAndon != null && listaAndon.size() > 0) {
			for(injetws.webservices.dto.IwsAndonDTO eventoAndon : listaAndon) {
				AndonDTO andonLocal = new AndonDTO(eventoAndon);
				listaEventosAndonUp.add(andonLocal);
			}
		}
	}
	
	private void copiaListaAlertasWs(List<IwsAlertaDTO> listaAlertas) {
		if(listaAlertasEmAberto != null)
			listaAlertasEmAberto.clear();
					
		if(listaAlertas != null && listaAlertas.size() > 0) {
			for(IwsAlertaDTO alerta : listaAlertas) {
				listaAlertasEmAberto.add(new MSalertaDTO(alerta));
			}
		}
	}
	
	public void atualizaUPWS(injetws.webservices.dto.IwsUpDTO upDTO) {
		copiaListaAlertasWs(upDTO.getListaAlertasEmAberto());
		copiaListaAndonWs(upDTO.getListaAndonDTO());
		this.setIsInspecaoPendenteExecucao(upDTO.getIsComInspecaoPendente());
		this.setIsAlertaProblemaQualidade(upDTO.getIsComAlertaProbQuali());
		this.setResultadoUltimaInspecao(upDTO.getResultadoUltimaInspecao());		
		this.setTamanhoPacoteCiclos(upDTO.getCp()!= null? upDTO.getCp().getCfgTamanhoUmPacoteCiclos() : 1f);
		this.setmsAdcParaAberturaParada(upDTO.getCp()!= null? upDTO.getCp().getCfgTolerTmpCicloParAuto() : 0);		
		this.setIsComOP(upDTO.getCp() != null && upDTO.getCp().getNrop() != null? true : false);
		this.setIsComOpSemProducao((upDTO.getCp() != null && upDTO.getCp().getIsOpSemColeta()? true : false));
		this.setBloqPorParadaSemConexao((upDTO.getCp() != null && upDTO.getCp().getIsBloqueioParadaSemConexao()? true : false));
		
		if(upDTO.getVariacaoRitmoDTO()!=null)
			this.setIsComVariacaoRitmoPend((upDTO.getVariacaoRitmoDTO().getIsComVariacaoRitmoPend()? true : false));
		
	}
	
	public void setFromPrUP(PrUp prup) {
		// estão sendo setados somente os dados necessários para o correto9 funcionadmento da rotina da coleta
		if(prup!=null){
			this.setSegCicloPadrao(prup.getTmpciclopadrao()!=null? prup.getTmpciclopadrao(): 0d);
			this.setPercCicloPadraoTimeout(prup.getCfgperctmpcicloparauto()!=null? prup.getCfgperctmpcicloparauto(): 0d);
			this.setTamanhoPacoteCiclos(prup.getCfgtamanhoumpacoteciclos()!=null? prup.getCfgtamanhoumpacoteciclos().intValue() : 1f);
			this.setDebounce(prup.getCfgdbc()!=null? prup.getCfgdbc().intValue() : 5);
			this.setmsAdcParaAberturaParada(prup.getCfgtolertmpcicloparauto()!=null? prup.getCfgdbc().intValue() : 0);
			this.setIsComOP(prup.getNrop()!=null? true : false);
			if (prup.obtemDadosCIPDTO() != null) {
				this.setCip(prup.obtemDadosCIPDTO().getIsEmCIP());
				this.setCipIniciado(prup.obtemDadosCIPDTO().getIsCIPPendente() == false);
			} else {
				this.setCip(false);
				this.setCipIniciado(false);
			}
			if(prup.getIsOpSemColeta()!=null)
				this.setIsComOpSemProducao(prup.getIsOpSemColeta().equals('1')? true : false);
			if(prup.getIsBloqueioParadaSemConexao()!=null)
				this.setBloqPorParadaSemConexao(prup.getIsBloqueioParadaSemConexao().equals('1')? true : false);			
		}		
	}
	
	public double getSegCicloPadrao() {
		return segCicloPadrao;
	}
	public void setSegCicloPadrao(double segCicloPadrao) {
		this.segCicloPadrao = segCicloPadrao;
	}
	public double getPercCicloPadraoTimeout() {
		return percCicloPadraoTimeout;
	}
	public void setPercCicloPadraoTimeout(double percCicloPadraoTimeout) {
		this.percCicloPadraoTimeout = percCicloPadraoTimeout;
	}
	public double getmsAdcParaAberturaParada() {
		return msAdcParaAberturaParada;
	}
	public void setmsAdcParaAberturaParada(double msAdcParaAberturaParada) {
		this.msAdcParaAberturaParada = msAdcParaAberturaParada;
	}
	public BigDecimal getIdUp() {
		return idUp;
	}
	public void setIdUp(BigDecimal idUp) {
		this.idUp = idUp;
	}
	public Boolean getIsManterHistoricoAntesEnvio() {
		return isManterHistoricoAntesEnvio;
	}
	public void setIsManterHistoricoAntesEnvio(Boolean isManterHistoricoAntesEnvio) {
		this.isManterHistoricoAntesEnvio = isManterHistoricoAntesEnvio;
	}
	public Boolean getIsManterRegistroAposTimeout() {
		return isManterRegistroAposTimeout;
	}
	public void setIsManterRegistroAposTimeout(Boolean isManterRegistroAposTimeout) {
		this.isManterRegistroAposTimeout = isManterRegistroAposTimeout;
	}
	public Boolean getIsEnviarDadosParaWS() {
		return isEnviarDadosParaWS;
	}
	public void setIsEnviarDadosParaWS(Boolean isEnviarDadosParaWS) {
		this.isEnviarDadosParaWS = isEnviarDadosParaWS;
	}
	public Boolean getIsEnviarDadosParaIHM() {
		return isEnviarDadosParaIHM;
	}
	public void setIsEnviarDadosParaIHM(Boolean isEnviarDadosParaIHM) {
		this.isEnviarDadosParaIHM = isEnviarDadosParaIHM;
	}
	public void setListaEventosAndonUp(List<AndonDTO> listaEventosAndonUp) {
		this.listaEventosAndonUp = listaEventosAndonUp;
	}
	public List<AndonDTO> getListaEventosAndonUp() {
		return listaEventosAndonUp;
	}

	public void setListaAlertasEmAberto(List<MSalertaDTO> listaAlertasEmAberto) {
		this.listaAlertasEmAberto = listaAlertasEmAberto;
	}

	public List<MSalertaDTO> getListaAlertasEmAberto() {
		return listaAlertasEmAberto;
	}

	public void setIsInspecaoPendenteExecucao(boolean isInspecaoPendenteExecucao) {
		this.isInspecaoPendenteExecucao = isInspecaoPendenteExecucao;
	}

	public boolean getIsInspecaoPendenteExecucao() {
		return isInspecaoPendenteExecucao;
	}

	public void setIsAlertaProblemaQualidade(boolean isAlertaProblemaQualidade) {
		this.isAlertaProblemaQualidade = isAlertaProblemaQualidade;
	}

	public boolean getIsAlertaProblemaQualidade() {
		return isAlertaProblemaQualidade;
	}

	public void setResultadoUltimaInspecao(int resultadoUltimaInspecao) {
		this.resultadoUltimaInspecao = resultadoUltimaInspecao;
	}

	public int getResultadoUltimaInspecao() {
		return resultadoUltimaInspecao;
	}

	public void setIsComOP(boolean isComOP) {
		this.isComOP = isComOP;
	}

	public boolean getIsComOP() {
		return isComOP;
	}

	public void setCd_up(String cd_up) {
		this.cd_up = cd_up;
	}

	public String getCd_up() {
		return cd_up;
	}
	public void setRevisao(BigDecimal revisao) {
		this.revisao = revisao;
	}
	public BigDecimal getRevisao() {
		return revisao;
	}
	public void setDs_up(String ds_up) {
		this.ds_up = ds_up;
	}
	public String getDs_up() {
		return ds_up;
	}
	public void setDthrStativo(Date dthrStativo) {
		this.dthrStativo = dthrStativo;
	}
	public Date getDthrStativo() {
		return dthrStativo;
	}
	public void setDthrRevisao(Date dthrRevisao) {
		this.dthrRevisao = dthrRevisao;
	}
	public Date getDthrRevisao() {
		return dthrRevisao;
	}
	public void setStAtivo(BigDecimal stAtivo) {
		this.stAtivo = stAtivo;
	}
	public BigDecimal getStAtivo() {
		return stAtivo;
	}
	public void setUpihmColetados(List<UpIhmDTO> upihmColetados) {
		this.upihmColetados = upihmColetados;
	}
	public List<UpIhmDTO> getUpihmColetados() {
		return upihmColetados;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
	public String getLoginUsuario() {
		return loginUsuario;
	}
	public String getIdUpPDBA() {
		return idUpPDBA;
	}
	public void setIdUpPDBA(String idUpPDBA) {
		this.idUpPDBA = idUpPDBA;
	}
	public BigDecimal getIdParada() {
		return idParada;
	}
	public void setIdParada(BigDecimal idParada) {
		this.idParada = idParada;
	}
	public Date getDthrIParada() {
		return dthrIParada;
	}
	public void setDthrIParada(Date dthrIParada) {
		this.dthrIParada = dthrIParada;
	}
	public String getDsParada() {
		return dsParada;
	}
	public void setDsParada(String dsParada) {
		this.dsParada = dsParada;
	}
	
	public void setPermCancelamento(boolean permCancelamento){
		this.permCancelamento = permCancelamento;
	}
	
	public boolean getPermCancelamento(){
		return permCancelamento;
	}

	public void setCdRefugo(String cdRefugo) {
		this.cdRefugo = cdRefugo;
	}

	public String getCdRefugo() {
		return cdRefugo;
	}

	public void setDsRefugo(String dsRefugo) {
		this.dsRefugo = dsRefugo;
	}

	public String getDsRefugo() {
		return dsRefugo;
	}

	public void setDthrIRefugo(Date dthrIRefugo) {
		this.dthrIRefugo = dthrIRefugo;
	}

	public Date getDthrIRefugo() {
		return dthrIRefugo;
	}

	public List<UsuarioMSDTO> getListaOperadoresLogados() {
		return listaOperadoresLogados;
	}

	public void setListaOperadoresLogados(List<UsuarioMSDTO> listaOperadoresLogados) {
		this.listaOperadoresLogados = listaOperadoresLogados;
	}

	public void setIdRdzProduto(String idRdzProduto) {
		System.out.println("setIdProduto: " + idRdzProduto);
		this.idRdzProduto = idRdzProduto;
	}

	public String getIdRdzProduto() {
		return idRdzProduto;
	}

	public void setMsdthrIRefugo(String msdthrIRefugo) {
		this.msdthrIRefugo = msdthrIRefugo;
	}

	public String getMsdthrIRefugo() {
		return msdthrIRefugo;
	}

	public void setCdmaqestendido(String cdmaqestendido) {
		this.cdmaqestendido = cdmaqestendido;
	}

	public String getCdmaqestendido() {
		return cdmaqestendido;
	}

	public int getTpSessao() {
		return tpSessao;
	}

	public void setTpSessao(int tpSessao) {
		this.tpSessao = tpSessao;
	}

	public void setNropestendido(String nropestendido) {
		this.nropestendido = nropestendido;
	}

	public String getNropestendido() {
		return nropestendido;
	}

	public void setProducaoliquida(String producaoliquida) {
		this.producaoliquida = producaoliquida;
	}

	public String getProducaoliquida() {
		return producaoliquida;
	}

	public void setCdproduto(String cdproduto) {
		this.cdproduto = cdproduto;
	}

	public String getCdproduto() {
		return cdproduto;
	}

	public void setProducaoplanejada(String producaoplanejada) {
		this.producaoplanejada = producaoplanejada;
	}

	public String getProducaoplanejada() {
		return producaoplanejada;
	}
	public Boolean getIsComOpSemProducao(){
		return this.isComOpSemProducao;
	}
	public void setIsComOpSemProducao(Boolean isComOpSemProducao){
		this.isComOpSemProducao=isComOpSemProducao;
	}
	public Boolean getBloqPorParadaSemConexao(){
		return this.bloqPorParadaSemConexao;
	}
	public void setBloqPorParadaSemConexao(Boolean bloqPorParadaSemConexao){
		this.bloqPorParadaSemConexao=bloqPorParadaSemConexao;
	}

	public void setUpParada(boolean upParada) {
		this.upParada = upParada;
	}
	public boolean getUpParada() {
		return this.upParada;
	}

	public String getCdBc() {
		return cdBc;
	}

	public void setCdBc(String cdBc) {
		this.cdBc = cdBc;
	}


	public List<PrUpProduto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<PrUpProduto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Float getTamanhoPacoteCiclos() {
		return tamanhoPacoteCiclo;
	}

	public void setTamanhoPacoteCiclos(Float tamanhoPacoteCiclo) {
		this.tamanhoPacoteCiclo = tamanhoPacoteCiclo;
	}
	
	public int getDebounce() {
		return debounce;
	}

	public void setDebounce(int debounce) {
		this.debounce = debounce;
	}

	public void setParadaEmAberto(byte paradaEmAberto) {
		this.paradaEmAberto = paradaEmAberto;
	}

	public byte getParadaEmAberto() {
		return paradaEmAberto;
	}

	public void setParadaPermiteCorrecao(boolean isParadaPermiteCorrecao) {
		this.isParadaPermiteCorrecao = isParadaPermiteCorrecao;
	}

	public boolean isParadaPermiteCorrecao() {
		return isParadaPermiteCorrecao;
	}	
	
	public IdwLogger getLog() {
		return log;
	}

	public void setLog(IdwLogger log) {
		this.log = log;
	}
	
	public void setCdParada(String cdparadaParametro) {
		this.cdparada = cdparadaParametro;
	}

	public String getCdParada() {
		return this.cdparada;
	}
	
	public void setReqCancel(boolean reqCancel){
		this.reqCancel = reqCancel;
	}
	
	public boolean isReqCancel(){
		return reqCancel;
	}

	public String getIdTecnicoDois() {
		return this.idTecnicoDois;
	}

	public void setIdTecnicoDois(String idTecnicoDois) {
		this.idTecnicoDois = idTecnicoDois;
	}

	public String getIdTecnicoUm() {
		return this.idTecnicoUm;
	}

	public void setIdTecnicoUm(String idTecnicoUm) {
		this.idTecnicoUm = idTecnicoUm;
	}

	public String getIdTecnicoResponsavel() {
		return this.idTecnicoResponsavel;
	}

	public void setIdTecnicoResponsavel(String idTecnicoResponsavel) {
		this.idTecnicoResponsavel = idTecnicoResponsavel;
	}

	public String getIdJustificativa() {
		return this.idJustificativa;
	}

	public void setIdJustificativa(String idJustificativa) {
		this.idJustificativa = idJustificativa;
	}

	public void setIdLocal(String idLocal) {
		this.idLocal = idLocal;
	}

	public String getIdLocal() {
		return this.idLocal;
	}	
	
	public String getIdCausa() {
		return this.idCausa;
	}

	public void setIdCausa(String idCausa) {
		this.idCausa = idCausa;
	}

	public String getIdAcao() {
		return this.idAcao;
	}

	public void setIdAcao(String idAcao) {
		this.idAcao = idAcao;
	}

	public boolean isVerificaParadaAutomatica() {
		return this.isVerificaParadaAutomatica;
	}

	public void setIsVerificaParadaAutomatica(boolean isverificaparadaautomatica) {
		this.isVerificaParadaAutomatica = isverificaparadaautomatica;
	}
	public boolean isSinalCicloAlto() {
		return this.issinalcicloalto;
	}

	public boolean isParadaRegulagem() {
		return this.isparadaregulagem;
	}

	public void setParadaRegulagem(boolean isparadaregulagem) {
		this.isparadaregulagem = isparadaregulagem;
	}
	
	public Boolean getIsParadaSemConexao() {
		return this.isParadaSemConexao;
	}

	public void setIsParadaSemConexao(Boolean isParadaSemConexao) {
		this.isParadaSemConexao = isParadaSemConexao;
	}
	
	public boolean getIsOPSemProducao() {
		return this.isOPSemProducao;
	}

	public void setIsOPSemProducao(Boolean isOPSemProducao) {
		this.isOPSemProducao = isOPSemProducao;
	}
	
	public Boolean getBloqPorParSemConexao() {
		return this.bloqPeriodoSemCon;
	}

	public void setBloqPorParSemConexao(boolean bloqPeriodoSemCon) {
		this.bloqPeriodoSemCon = bloqPeriodoSemCon;
	}
	
	public Boolean getIsComVariacaoRitmoPend() {
		return this.isComVariacaoRitmoPend;
	}

	public void setIsComVariacaoRitmoPend(Boolean isComVariacaoRitmoPend) {
		this.isComVariacaoRitmoPend = isComVariacaoRitmoPend;
	}

	public boolean isParadaPersistente() {
		return this.isparadapersistente;
	}

	public void setParadaPersistente(boolean isparadapersistente) {
		this.isparadapersistente = isparadapersistente;
	}

	public void setSinalCicloAlto(boolean issinalcicloalto) {
		this.issinalcicloalto = issinalcicloalto;
	}

	public void setVlEficienciaUltimoCiclo(double vlEficienciaUltimoCiclo) {
		this.vlEficienciaUltimoCiclo = vlEficienciaUltimoCiclo;
	}

	public double getVlEficienciaUltimoCiclo() {
		return vlEficienciaUltimoCiclo;
	}

	public void setDtHrInicioCiclo(Date dtHrInicioCiclo) {
		this.dtHrInicioCiclo = dtHrInicioCiclo;
	}

	public Date getDtHrInicioCiclo() {
		return dtHrInicioCiclo;
	}

	public boolean isUpTrabalhando() {
		return this.isuptrabalhando;
	}

	public void setUpTrabalhando(boolean isUpTrabalhando) {
		this.isuptrabalhando = isUpTrabalhando;
	}

	public boolean isUpParada() {
		return !this.isuptrabalhando;
	}

	public boolean isParadaRequerConfirmacaoParaFinalizar() {
		return this.isparadarequerconfirmacaoparafinalizar;
	}

	public void setParadaRequerConfirmacaoParaFinalizar(
			boolean isParadaRequerConfirmacaoParaFinalizar) {
		this.isparadarequerconfirmacaoparafinalizar = isParadaRequerConfirmacaoParaFinalizar;
	}

	public void setBcOffLine(boolean isBcOffLine) {
		this.isBcOffLine = isBcOffLine;
	}

	public boolean isBcOffLine() {
		return isBcOffLine;
	}
	
	/*
	 * Esse metodo foi criado para servir de apoio ao heartbeat do ms que estava trocando as referencia do objeto UP
	 * Assim o que iremos atualizar no original eh apenas o BC e acrescentar o que for necessario
	 */
	public void atualizaFromUpDTO(UpDTO from){
		this.cdBc = from.getCd_up();
		this.cdmaqestendido = from.getCdmaqestendido();
		this.isCip = from.isCip;
		this.isCipIniciado = from.isCipIniciado;
		
		this.upihmColetados = from.getUpihmColetados();
	}

	public boolean isCip() {
		return isCip;
	}

	public void setCip(boolean isCip) {
		this.isCip = isCip;
	}

	public boolean isCipIniciado() {
		return isCipIniciado;
	}

	public void setCipIniciado(boolean isCipIniciado) {
		this.isCipIniciado = isCipIniciado;
	}

	public Long getIdEvtInicioCiclo() {
		return idEvtInicioCiclo;
	}
	
	public Date getDthrEvtInicioCiclo() {
		return this.dthrEvtInicioCiclo;
	}

	public void setIdEvtInicioCiclo(Long idEvtInicioCiclo, Date dthrEvtInicioCiclo) {
		this.idEvtInicioCiclo = idEvtInicioCiclo;
		this.dthrEvtInicioCiclo = dthrEvtInicioCiclo;
	}

	public void atualizarIdEvtInicioCicloAnteriorAoFlush() {
		this.idEvtInicioCicloAnteriorAoFlush = this.idEvtInicioCiclo;
		this.dthrEvtInicioCicloAnteriorAoFlush = this.dthrEvtInicioCiclo;
	}
	
	public void desfazerIdEvetInicioCiclo() {
		this.idEvtInicioCiclo = this.idEvtInicioCicloAnteriorAoFlush;
		this.dthrEvtInicioCiclo = this.dthrEvtInicioCicloAnteriorAoFlush;
	}

	public Long getIdTppt() {
		return idTppt;
	}

	public void setIdTppt(Long idTppt) {
		this.idTppt = idTppt;
	}

	public Date getDthrFParada() {
		return dthrFParada;
	}

	public void setDthrFParada(Date dthrFParada) {
		this.dthrFParada = dthrFParada;
	}

	public boolean isOffline() {
		return isOffline;
	}

	public void setOffline(boolean isOffline) {
		this.isOffline = isOffline;
	}
	public Boolean getIsIhmtrocaOP() {
		return isIhmtrocaOP;
	}
	public void setIsIhmtrocaOP(Boolean isIhmtrocaOP) {
		this.isIhmtrocaOP = isIhmtrocaOP;
	}

	public boolean isLerCB() {
		return isLerCB;
	}

	public void setLerCB(boolean isLerCB) {
		this.isLerCB = isLerCB;
	}

	public boolean getIsOPReprocesso() {
		return isOPReprocesso;
	}

	public void setIsOPReprocesso(boolean isOPReprocesso) {
		this.isOPReprocesso = isOPReprocesso;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public Integer getFiltroModulo() {
		return filtroModulo;
	}

	public void setFiltroModulo(Integer filtroModulo) {
		this.filtroModulo = filtroModulo;
	}

	public Integer getFiltroEstagio() {
		return filtroEstagio;
	}

	public void setFiltroEstagio(Integer filtroEstagio) {
		this.filtroEstagio = filtroEstagio;
	}
	
	
}
