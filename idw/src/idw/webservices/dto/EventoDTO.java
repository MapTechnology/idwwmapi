package idw.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.pojos.OmPt;
import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.util.Util;

@SuppressWarnings("serial")
public class EventoDTO implements Serializable {

    public static final int _EVENTO_INICIO_CICLO = 1;
    public static final int _EVENTO_FIM_CICLO = 2;
    public static final int _EVENTO_INICIO_PARADA = 3;
    public static final int _EVENTO_FIM_PARADA = 4;
    public static final int _EVENTO_ERRO = 5;
    public static final int _EVENTO_TROCA_PROGRAMA = 6;
    public static final int _EVENTO_USO_FEEDER = 7;
    public static final int _EVENTO_USO_NOZZLE = 8;

	private String data = "";
    private String codigo = "";
    private String maquina = "";
    private String linha = "";
    private String estagioEvento = "0";
    private String descricaoEvento = "";
   
    private int sequencial;
    
	private ErroInsersoraDTO erroDTO = null;
	private ParadaInsersoraDTO paradaDTO = null;
	private List<FeederDTO> feeders = null;
	private List<NozzleDTO> nozzles = null;

	private boolean eventoMaquina = false;

	private boolean eventoValido = false;
	private boolean eventoErro = false;
	private boolean inicioParada = false;
	private boolean fimParada = false;
	private int tipoEvento; // O tipo de evento j� vir� informado
	private OmPt ompt;

	private IdwLogger log;
	private int idLog;
	private int identacao;
	private String programa;
	private String produto;
	private String origem; //Origem da linha do evento informado
	
	//Luiz - 20190605 - Adicionado quantidade vinda do BOARDCOUNT
	private String quantidade;

	private boolean descartar = false;

	private boolean isConsolidarParaInsert = false;

	private boolean isFimCicloAnterior = false;


	
	public EventoDTO() {

	}

	public EventoDTO(String data, String codigo, String maquina, String Linha,
			String Produto, int TipoEvento) {
		this.data = data;
		this.codigo = codigo;
		this.maquina = maquina;
		this.linha = Linha;
		this.produto = Produto;
		this.tipoEvento = TipoEvento;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return this.data;
	}

	public Date getDataComoData() {
		if (this.data.length() == 23){
			return DataHoraRN.stringToDate(this.data, "yyyy-MM-dd HH:mm:ss.SSS");
		}else{
			return DataHoraRN.stringToDate(this.data, "yyyy-MM-dd HH:mm:ss");
		}
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}

	public String getMaquina() {
		return this.maquina;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getLinha() {
		return this.linha;
	}

	public int getEstagio() {
		int retorno = 1;
		try {
			retorno = Integer.valueOf(estagioEvento);
		} catch (NumberFormatException e){
			//System.out.println("O estagio [" + estagioEvento + "]");
		}
		return retorno;
	}

	public boolean comparaCodigo(String codigo) {
		boolean retorno = false;
		if (this.codigo.equals(codigo)) {
			retorno = true;
		}

		return retorno;
	}

	public String getCt() {
		return getLinha() + "|" + getMaquina();
	}

	public void defineLog(IdwLogger log, int idLog, int identacao) {
		this.log = log;
		this.idLog = idLog;
		this.identacao = identacao;
	}

	public OmPt getOmpt() {
		return this.ompt;
	}

	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}

	public IdwLogger getLog() {
		return this.log;
	}

	public int getIdLog() {
		return idLog;
	}

	public int getIdentacao() {
		return identacao;
	}

	public void setTipoEvento(int tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public int getTipoEvento() {
		return this.tipoEvento;
	}

	public String getPrograma() {
		// Alessandre em 7-6-17 retornando o nome completo do programa. Removi a aplicacao da mascara por op
		// a mesma deve ser aplicada em um 2o momento
		//return Util.extraiPorMascara(programa, IdwFacade.getInstancia().getMascaraPrograma());
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public void setIsInsert(boolean isInsert) {
		this.isConsolidarParaInsert = isInsert;
	}

	public boolean isInsert() {
		return this.isConsolidarParaInsert;
	}

	public void setDescartar(boolean descartar) {
		this.descartar = descartar;
	}

	public boolean isDescartar() {
		return this.descartar;
	}

	@Override
	public String toString() {
		return "CT = " + getCt() + " evento = " + getDescricaoTipoEvento()
				+ " ESTAGIO =" + getEstagioEvento();
	}

	public String getDescricaoTipoEvento() {
		String retorno = null;
		if (this.tipoEvento == 1) {
			retorno = "_EVENTO_INICIO_PARADA";
		} else if (this.tipoEvento == 2) {
			retorno = "_EVENTO_INICIO_CICLO";
		} else if (this.tipoEvento == 3) {
			retorno = "_EVENTO_FIM_CICLO";
		} else if (this.tipoEvento == 4) {
			retorno = "_EVENTO_FIM_PARADA";
		} else if (this.tipoEvento == 5) {
			retorno = "_EVENTO_ERRO";
		} else if (this.tipoEvento == 6) {
			retorno = "_EVENTO_TROCA_PROGRAMA";
		}

		return retorno;
	}

	public String getProduto() {
		return Util.extraiPorMascara(produto, IdwFacade.getInstancia().getMascaraProduto());
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getEstagioEvento() {
		return estagioEvento;
	}

	public void setEstagioEvento(String estagioEvento) {
		this.estagioEvento = estagioEvento;
	}

	public String getDescricaoEvento() {
		return descricaoEvento;
	}

	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}

	public boolean isEventoMaquina() {
		return eventoMaquina;
	}

	public void setEventoMaquina(boolean eventoMaquina) {
		this.eventoMaquina = eventoMaquina;
	}

	public boolean isEventoValido() {
		return eventoValido;
	}

	public void setEventoValido(boolean eventoValido) {
		this.eventoValido = eventoValido;
	}

	public boolean isErro() {
		return eventoErro;
	}

	public void setEventoErro(boolean eventoErro) {
		this.eventoErro = eventoErro;
	}

	public boolean isFimCicloAnterior() {
		return isFimCicloAnterior;
	}

	public void setFimCicloAnterior(boolean isFimCicloAnterior) {
		this.isFimCicloAnterior = isFimCicloAnterior;
	}

	public ErroInsersoraDTO getErroDTO() {
		return erroDTO;
	}

	public void setErroDTO(ErroInsersoraDTO erroDTO) {
		this.erroDTO = erroDTO;
	}

	public boolean isInicioParada() {
		// TODO Auto-generated method stub
		return this.inicioParada;
	}

	public void setInicioParada(boolean inicioParada) {
		this.inicioParada = inicioParada;
	}

	public boolean isFimParada() {
		return fimParada;
	}

	public void setFimParada(boolean fimParada) {
		this.fimParada = fimParada;
	}

	public ParadaInsersoraDTO getParadaDTO() {
		return paradaDTO;
	}

	public void setParadaDTO(ParadaInsersoraDTO paradaDTO) {
		this.paradaDTO = paradaDTO;
	}

	public int getSequencial() {
		return sequencial;
	}

	public void setSequencial(int sequencial) {
		this.sequencial = sequencial;
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

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	
	
}