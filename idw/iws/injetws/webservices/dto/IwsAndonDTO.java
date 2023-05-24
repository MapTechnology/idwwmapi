package injetws.webservices.dto;

import injetws.model.pojos.PrUpAndon;
import injetws.model.pojos.PrUpAndonArg;
import injetws.model.pojos.PrUpCtrlAndon;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class IwsAndonDTO implements Serializable {
	public static int EV_PARADA = 1;
	public static int EV_ALERTA = 2;
	public static int EV_INSPECAO_PENDENTE = 3;
	public static int EV_INSPECAO_REPROVADA = 4;
	public static int EV_INSPECAO_APROVADA_RESTRICAO = 5;
	public static int EV_INSPECAO_APROVADA = 6;
	public static int EV_MAQUINA_TRABALHANDO = 7;
	public static int EV_EFICIENCIA_DE_CICLO = 8;
	public static int EV_INDICE_DE_PARADA = 9;
	public static int EV_INDICE_DE_REFUGO = 10;
	public static int EV_INDICE_DE_OEE = 11;
	public static int EV_EFICIENCIA_REALIZACAO = 12;
	public static int EV_QLQR_PARADA = 13;
	public static int EV_VARIACAO_RITMO = 14;
	public static int EV_LIMITE_CIP_EXTRAPOLADO = 15;
	public static int EV_APONTAMENTO_DBQ_PENDENTE = 16;
	public static int EV_APONTAMENTO_DBQ_EXTRAPOLADO = 17;
	public static int EV_IS_OP_CONCLUIDA = 18;
	
	public static int VL_REF_TEMPO = 3;
	public static int VL_REF_MOLDE_QUE_SAI = 5;
	public static int VL_REF_MOLDE_QUE_ENTRA = 6;

	private double ideventoandon;
	private String idup;
	private BigDecimal tpeventoandon;
	private BigDecimal idrele;
	private String idreleaux;
	private BigDecimal prioridade;
	private BigDecimal stintermitente;
	private BigDecimal tmpsinalalto;
	private BigDecimal tmpsinalbaixo;
	private BigDecimal stativo;
	private List<IwsAndonArgsDTO> andonArgs = new ArrayList<IwsAndonArgsDTO>();
	private IwsAndonIndicadorDTO indicador;	
	private BigDecimal tmpliminspqld;
	
	// Ricardo: 06/03/2023
	private String vlMotivo;
	private Integer sinalMotivo;
	private Integer tpSaida;
	private BigDecimal tmptolerancia;
	
	// Ricardo: 07/03/2023
	private int par9999ativa;
	
	// Ricardo: 06/03/2023
	public String getVlMotivo() {
		return vlMotivo;
	}
	public void setVlMotivo(String vlMotivo) {
		this.vlMotivo = vlMotivo;
	}
	public Integer getSinalMotivo() {
		return sinalMotivo;
	}
	public BigDecimal getTmptolerancia() {
		return tmptolerancia;
	}
	public void setTmptolerancia(BigDecimal tmptolerancia) {
		this.tmptolerancia = tmptolerancia;
	}

	public void setSinalMotivo(Integer sinalMotivo) {
		this.sinalMotivo = sinalMotivo;
	}

	public Integer getTpSaida() {
		return tpSaida;
	}

	public void setTpSaida(Integer tpSaida) {
		this.tpSaida = tpSaida;
	}

	public void copyPrUpAndon(PrUpAndon prupandon) {
		this.setIdeventoandon(prupandon.getId().getIdeventoandon());
		this.setIdup(prupandon.getId().getIdup());
		this.setTpeventoandon(prupandon.getTpeventoandon());
		this.setIdrele(prupandon.getIdrele());
		this.setIdreleaux(prupandon.getIdreleaux());
		this.setPrioridade(prupandon.getPrioridade());
		this.setStintermitente(prupandon.getStintermitente());
		this.setTmpsinalalto(prupandon.getTmpsinalalto());
		this.setTmpsinalbaixo(prupandon.getTmpsinalbaixo());
		this.setStativo(prupandon.getStativo());
		if( (prupandon.getTpeventoandon().intValue() < IwsAndonDTO.EV_INSPECAO_PENDENTE) 
				|| (prupandon.getTpeventoandon().intValue() > IwsAndonDTO.EV_MAQUINA_TRABALHANDO))
		{
			IwsAndonArgsDTO dto=null;
			if(prupandon.getPrUpAndonArgs()!=null){
				for(PrUpAndonArg arg : prupandon.getPrUpAndonArgs()){
					if(arg==null ||
							arg.getTpvlreferencia().equals(IwsAndonDTO.VL_REF_MOLDE_QUE_ENTRA)||
							arg.getTpvlreferencia().equals(IwsAndonDTO.VL_REF_MOLDE_QUE_SAI)){
						continue;
					}
					dto = new IwsAndonArgsDTO();
					dto.copyPrUpAndonArg(arg);
					andonArgs.add(dto);
				}
			}
		}
	}
	
	public void copyPrUpCtrlAndon(PrUpCtrlAndon pupctrlandon) {
		this.ideventoandon = pupctrlandon.getIdeventoandon();
		this.idup = pupctrlandon.getId().getIdup();
		this.tpeventoandon = pupctrlandon.getTpeventoandon();
		this.idrele = pupctrlandon.getId().getIdrele();
		this.idreleaux = pupctrlandon.getIdreleaux();
		this.prioridade = pupctrlandon.getPrioridade();
		this.stintermitente = pupctrlandon.getStintermitente();
		this.tmpsinalalto = pupctrlandon.getTmpsinalalto();
		this.tmpsinalbaixo = pupctrlandon.getTmpsinalbaixo();
	}
	
	public void copyAndonDto(IwsAndonDTO toCopyAndon)
	{
		this.ideventoandon = toCopyAndon.getIdeventoandon();
		this.idup = toCopyAndon.getIdup();
		this.tpeventoandon = toCopyAndon.getTpeventoandon();
		this.idrele = toCopyAndon.getIdrele();
		this.idreleaux = toCopyAndon.getIdreleaux();
		this.prioridade = toCopyAndon.getPrioridade();
		this.stintermitente = toCopyAndon.getStintermitente();
		this.tmpsinalalto = toCopyAndon.getTmpsinalalto();
		this.tmpsinalbaixo = toCopyAndon.getTmpsinalbaixo();
		this.stativo = toCopyAndon.getStativo();
		this.tmpliminspqld = toCopyAndon.getTmpliminspqld() ;
	}
	
	public double getIdeventoandon() {
		return this.ideventoandon;
	}

	public void setIdeventoandon(double ideventoandon) {
		this.ideventoandon = ideventoandon;
	}

	public String getIdup() {
		return this.idup;
	}

	public void setIdup(String idup) {
		this.idup = idup;	
	}
	
	public BigDecimal getTpeventoandon() {
		return this.tpeventoandon;
	}

	public void setTpeventoandon(BigDecimal tpeventoandon) {
		this.tpeventoandon = tpeventoandon;
	}
	
	public BigDecimal getIdrele() {
		return this.idrele;
	}

	public void setIdrele(BigDecimal idrele) {
		this.idrele = idrele;
	}
	
	public String getIdreleaux() {
		return this.idreleaux;
	}

	public void setIdreleaux(String idreleaux) {
		this.idreleaux = idreleaux;
	}

	public BigDecimal getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(BigDecimal prioridade) {
		this.prioridade = prioridade;
	}

	public BigDecimal getStintermitente() {
		return this.stintermitente;
	}

	public void setStintermitente(BigDecimal stintermitente) {
		this.stintermitente = stintermitente;
	}

	public BigDecimal getTmpsinalalto() {
		return this.tmpsinalalto;
	}

	public void setTmpsinalalto(BigDecimal tmpsinalalto) {
		this.tmpsinalalto = tmpsinalalto;
	}

	public BigDecimal getTmpsinalbaixo() {
		return this.tmpsinalbaixo;
	}

	public void setTmpsinalbaixo(BigDecimal tmpsinalbaixo) {
		this.tmpsinalbaixo = tmpsinalbaixo;
	}

	public BigDecimal getStativo() {
		return this.stativo;
	}

	public void setStativo(BigDecimal stativo) {
		this.stativo = stativo;
	}

	public void setTmpliminspqld(BigDecimal tmpliminspqld) {
		this.tmpliminspqld = tmpliminspqld;
	}

	public BigDecimal getTmpliminspqld() {
		return tmpliminspqld;
	}

	public void setIndicador(IwsAndonIndicadorDTO indicador) {
		this.indicador = indicador;
	}

	public IwsAndonIndicadorDTO getIndicador() {
		return this.indicador;
	}
	
	public void setListaAndonArgsDTO(List<IwsAndonArgsDTO> andonargsdto)
	{
		this.andonArgs.addAll(andonargsdto);
	}
	
	public List<IwsAndonArgsDTO> getListaAndonArgsDTO()
	{
		return this.andonArgs;
	}
	
	// Ricardo: 07/03/2023
	public int getPar999999ativa() {
		return par9999ativa;
	}
	
	// Ricardo: 07/03/2023
	public void setPar999999ativa(int par9999ativa) {
		this.par9999ativa = par9999ativa;
	}

}
