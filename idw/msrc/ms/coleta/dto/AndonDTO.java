package ms.coleta.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import ms.coleta.andon.IniciaEventoAgendadoTimerTask;
import ms.coleta.ic.IIC;

public class AndonDTO {
	public static final int _EVENTO_ANDON_PARADA = 1;
	public static final int _EVENTO_ANDON_INSPECAO_PENDENTE = 3;
	public static final int _EVENTO_ANDON_PARADA_TODAS = 13;
	
    private double idEventoandon;
    private String idUp;
    private int tpEventoandon;
    private int idRele;
    private String idReleaux;
    private int prioridade;
    private int stIntermitente;
    private int tmpSinalalto;
    private int tmpSinalbaixo;
    private int stAtivo;
    private int tmpLimInspQld = 0;
    private List<AndonArgsDTO> listaAndonArgs = new ArrayList<AndonArgsDTO>();
    private Double indicador = 0d;
    private Double indicadorTurno = 0d;
    private Double indicadorHora = 0d;
    private Date dtHrInicio = new Date();
    private boolean timerIniciado = false;   

	private Timer agendador;

    public AndonDTO() {    	
    }
    
    public AndonDTO(injetws.webservices.dto.IwsAndonDTO andonDTO)        
    {            
        if (andonDTO != null)
        {
            AndonArgsDTO newArgs;
            this.idEventoandon = andonDTO.getIdeventoandon();
            this.idUp = andonDTO.getIdup();
            if(andonDTO.getTpeventoandon() != null)
            	this.tpEventoandon = andonDTO.getTpeventoandon().intValue();
            if(andonDTO.getIdrele() != null)
            	this.idRele = andonDTO.getIdrele().intValue();
            this.idReleaux = andonDTO.getIdreleaux();
            if(andonDTO.getPrioridade() != null)
            	this.prioridade = andonDTO.getPrioridade().intValue();
            if(andonDTO.getStintermitente() != null)
            	this.stIntermitente = andonDTO.getStintermitente().intValue();
            if(andonDTO.getTmpsinalalto() != null)
            	this.tmpSinalalto = andonDTO.getTmpsinalalto().intValue();
            if(andonDTO.getTmpsinalbaixo() != null)
            	this.tmpSinalbaixo = andonDTO.getTmpsinalbaixo().intValue();
            if(andonDTO.getStativo() != null)
            this.stAtivo = andonDTO.getStativo().intValue();
            if (andonDTO.getIndicador() != null)
            {
            	this.indicadorHora = andonDTO.getIndicador().getVlindicadorHora();
            	this.indicadorTurno = andonDTO.getIndicador().getVlindicadorHora();            	
            }
            if(andonDTO.getTmpliminspqld() != null)
            	this.tmpLimInspQld = andonDTO.getTmpliminspqld().intValue();
            this.listaAndonArgs = new ArrayList<AndonArgsDTO>();
            if (andonDTO.getListaAndonArgsDTO() != null)
            {
                for (int i = 0; i < andonDTO.getListaAndonArgsDTO().size(); i++)
                {
                    newArgs = new AndonArgsDTO(andonDTO.getListaAndonArgsDTO().get(i));
                    //newArgs.copyAndonArgsDTOWS();
                    this.listaAndonArgs.add(newArgs);
                }
            }
        }
    }

    public AndonDTO(AndonDTO andonAux)
    {
    	this.idEventoandon = andonAux.getIdeventoandon();
        this.idUp = andonAux.getIdup();
        this.tpEventoandon = andonAux.getTpeventoandon();
        this.idRele = andonAux.getIdrele();
        this.idReleaux = andonAux.getIdreleaux();
        this.prioridade =andonAux.getPrioridade();
        this.stIntermitente = andonAux.getStintermitente();
        this.tmpSinalalto = andonAux.getTmpsinalalto();
        this.tmpSinalbaixo = andonAux.getTmpsinalbaixo();
        this.stAtivo  = andonAux.getStativo();
        this.indicadorHora = andonAux.getIndicadorHora();
        this.indicadorTurno = andonAux.getIndicadorTurno();
        this.indicador = andonAux.getIndicador();
        this.tmpLimInspQld = andonAux.getTmpLiminspqld();
        this.listaAndonArgs = andonAux.getAndonArgs();
        this.timerIniciado = andonAux.getTimerIniciado();
        this.agendador = andonAux.getAgendador();
        this.dtHrInicio = andonAux.getDtHrInicio();
    }
    
    public void copyAndonDTO(AndonDTO andonAux)
    {
    	//a verificação finaliza apenas se o evento copiado for diferente deste objeto
    	verificaFinalizacaoEventoAgendado(andonAux);
    	
       	this.setIdeventoandon(andonAux.getIdeventoandon());
        this.setIdup(andonAux.getIdup());
        this.setTpeventoandon(andonAux.getTpeventoandon());
        this.setIdrele(andonAux.getIdrele());
        this.setIdreleaux(andonAux.getIdreleaux());
        this.setPrioridade(andonAux.getPrioridade());
        this.setStintermitente(andonAux.getStintermitente());
        this.setTmpsinalalto(andonAux.getTmpsinalalto());
        this.setTmpsinalbaixo(andonAux.getTmpsinalbaixo());
        this.setStativo(andonAux.getStativo());
        this.setIndicadorHora(andonAux.getIndicadorHora());
        this.setIndicadorTurno(andonAux.getIndicadorTurno());
        this.setIndicador(andonAux.getIndicador());
        this.settmpLiminspqld(andonAux.getTmpLiminspqld());
        this.setListAndonArgsDto(andonAux.getAndonArgs());
        this.setAgendador(andonAux.getAgendador());
    }
    
    public ParametroDTO converteDadosAndon() {
    	ParametroDTO parametro = new ParametroDTO();
    	parametro.setNrIcDO(this.idRele);
    	parametro.setStAtivo(this.stAtivo == 0 ? false : true);
    	parametro.setStPiscando(this.stIntermitente == 0 ? false : true);
    	parametro.setTempoOff(this.tmpSinalbaixo);
    	parametro.setTempoOn(this.tmpSinalalto);
    	return parametro;
    }

    public double getIdeventoandon()
    {
        return this.idEventoandon;
    }

    public void setIdeventoandon(double ideventoandon)
    {
        this.idEventoandon = ideventoandon;
    }

    public String getIdup()
    {
        return this.idUp;
    }

    public void setIdup(String idup)
    {
        this.idUp = idup;
    }

    public int getTpeventoandon()
    {
        return this.tpEventoandon;
    }

    public void setTpeventoandon(int tpeventoandon)
    {
        this.tpEventoandon = tpeventoandon;
    }

    public int getIdrele()
    {
        return this.idRele;
    }

    public void setIdrele(int idrele)
    {
        this.idRele = idrele;
    }

    public String getIdreleaux()
    {
        return this.idReleaux;
    }

    public void setIdreleaux(String idreleaux)
    {
        this.idReleaux = idreleaux;
    }

    public int getPrioridade()
    {
        return this.prioridade;
    }

    public void setPrioridade(int prioridade)
    {
        this.prioridade = prioridade;
    }

    public int getStintermitente()
    {
        return this.stIntermitente;
    }

    public void setStintermitente(int stintermitente)
    {
        this.stIntermitente = stintermitente;
    }

    public int getTmpsinalalto()
    {
        return this.tmpSinalalto;
    }

    public void setTmpsinalalto(int tmpsinalalto)
    {
        this.tmpSinalalto = tmpsinalalto;
    }

    public int getTmpsinalbaixo()
    {
        return this.tmpSinalbaixo;
    }

    public void setTmpsinalbaixo(int tmpsinalbaixo)
    {
        this.tmpSinalbaixo = tmpsinalbaixo;
    }

    public int getStativo()
    {
        return this.stAtivo;
    }

    public void setStativo(int stativo)
    {
        this.stAtivo = stativo;
    }

    public List<AndonArgsDTO> getAndonArgs()
    {
        return this.listaAndonArgs;
    }

    public void setListAndonArgsDto(List<AndonArgsDTO> andonArgsDto)
    {
        this.listaAndonArgs = new ArrayList<AndonArgsDTO>();
        this.listaAndonArgs.addAll(andonArgsDto);
    }

    //vlauria 20100324
    public Date getDtHrInicio()
    {
        return this.dtHrInicio;
    }

    public void setDtHrInicio(Date dtHr)
    {
        this.dtHrInicio = dtHr;
    }
    //vlauria 20100324
    public boolean getTimerIniciado()
    {
        return this.timerIniciado;
    }

    public void setTimerIniciado(boolean timeriniciado)
    {
        this.timerIniciado = timeriniciado;
    }

    //vlauria 20100324
    public int getTmpLiminspqld()
    {
        return this.tmpLimInspQld;
    }

    public void settmpLiminspqld(int tmpliminspqld)
    {
        this.tmpLimInspQld = tmpliminspqld;
    }

    public Timer getAgendador()
    {
        return this.agendador;
    }

    public void setAgendador(Timer ind)
    {
        this.agendador = ind;
    }

	public void setIndicadorTurno(Double indicadorTurno) {
		this.indicadorTurno = indicadorTurno;
	}

	public Double getIndicadorTurno() {
		return indicadorTurno;
	}

	public void setIndicadorHora(Double indicadorHora) {
		this.indicadorHora = indicadorHora;
	}

	public Double getIndicadorHora() {
		return indicadorHora;
	}

	public void setIndicador(Double indicador) {
		this.indicador = indicador;
	}

	public Double getIndicador() {
		return indicador;
	}

	public boolean isAndonParada(){
		return (this.tpEventoandon == _EVENTO_ANDON_PARADA || this.tpEventoandon == _EVENTO_ANDON_PARADA_TODAS);
	}

	public boolean isAndonInspecaoPendente() {
		return (this.tpEventoandon == _EVENTO_ANDON_INSPECAO_PENDENTE);
	}
	
	@Override
	public boolean equals(Object o){
		if (o != null && o.getClass() == this.getClass()) {
			AndonDTO c = (AndonDTO) o;
			return getIdeventoandon() == c.getIdeventoandon() && getIdup().equals(c.getIdup());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((agendador == null) ? 0 : agendador.hashCode());
		result = prime * result
				+ ((dtHrInicio == null) ? 0 : dtHrInicio.hashCode());
		long temp;
		temp = Double.doubleToLongBits(idEventoandon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + idRele;
		result = prime * result
				+ ((idReleaux == null) ? 0 : idReleaux.hashCode());
		result = prime * result + ((idUp == null) ? 0 : idUp.hashCode());
		result = prime * result
				+ ((indicador == null) ? 0 : indicador.hashCode());
		result = prime * result
				+ ((indicadorHora == null) ? 0 : indicadorHora.hashCode());
		result = prime * result
				+ ((indicadorTurno == null) ? 0 : indicadorTurno.hashCode());
		result = prime * result
				+ ((listaAndonArgs == null) ? 0 : listaAndonArgs.hashCode());
		result = prime * result + prioridade;
		result = prime * result + stAtivo;
		result = prime * result + stIntermitente;
		result = prime * result + (timerIniciado ? 1231 : 1237);
		result = prime * result + tmpLimInspQld;
		result = prime * result + tmpSinalalto;
		result = prime * result + tmpSinalbaixo;
		result = prime * result + tpEventoandon;
		return result;
	}

	public boolean verificaMudancaDeParametros(AndonDTO andon) {
		return (getTmpsinalalto() !=  andon.getTmpsinalalto() || 
				getTmpsinalbaixo() != andon.getTmpsinalbaixo() ||
				getStintermitente() != andon.getStintermitente() ||
				getStativo() != andon.getStativo());
	}
	
	public void verificaFinalizacaoEventoAgendado(AndonDTO eventoAndon) {
		if(!this.equals(eventoAndon)) {
			finalizaVerificacaoEventoAgendado();
		}
	}
	
	public void finalizaVerificacaoEventoAgendado(){
		if (agendador != null){
			agendador.cancel();
			agendador = null;
		}
		timerIniciado = false;
	}
	public void iniciaVerificacaoEventoAgendado(IIC adam) {
		if ( this.tpEventoandon == AndonDTO._EVENTO_ANDON_PARADA || this.tpEventoandon == AndonDTO._EVENTO_ANDON_INSPECAO_PENDENTE){
			// Parar o schedule atual
			finalizaVerificacaoEventoAgendado();
			
			// Inicia novo schedule para detecao da parada automatica
			IniciaEventoAgendadoTimerTask tarefaAgendada = new IniciaEventoAgendadoTimerTask(this, adam);
			agendador = new Timer();
			if (isAndonParada()){
				double tempo = 0;
				for (AndonArgsDTO ar : this.listaAndonArgs){
					if (ar.getTpvlreferencia() == AndonArgsDTO._ARG_TEMPO_PARADA){
						tempo = ar.getVlreferencianum();
						break;
					}
				}				
				agendador.schedule(tarefaAgendada, (int)tempo*1000);
			}
			if(isAndonInspecaoPendente()) {			
				agendador.schedule(tarefaAgendada, (long) this.tmpLimInspQld*60000, (long) this.tmpLimInspQld*60000);				
			}
		}
	}
}
