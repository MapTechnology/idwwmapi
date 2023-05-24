/**
 * CalendarioDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package idw.idwws;

public class CalendarioDTO  implements java.io.Serializable {
    private idw.idwws.DwCal calendario;

    private idw.idwws.CalendarioPtsDTO calendarioPts;

    private idw.idwws.CalendariosSemanaisDTO calendariosSemanais;

    private int ERRO_CALENDARIO_JA_EXISTE;

    private int ERRO_CDCALENDARIO_INVALIDO;

    private int ERRO_DATAFINAL_INFERIOR;

    private int ERRO_DATAINICIAL_INVALIDA;

    private int ERRO_DESCONHECIDO;

    private int ERRO_DIADASEMANA_DESCONHECIDO;

    private int ERRO_EXISTE_CALENDARIO_EM_ABERTO;

    private int ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO;

    private int ERRO_FIMTURNO_SEM_INICIO_ANTERIOR;

    private int ERRO_HORAFINAL_MENOR_HORAINICIAL;

    private int ERRO_INICIOTURNO_SEM_FIM_ANTERIOR;

    private int ERRO_PERIODO_CALENDARIO_CONFLITA;

    private int ERRO_REATIVACAO_INDISPONIVEL;

    private int ERRO_TEMPOCALENDARIO_INVALIDO;

    private int ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO;

    private int ERRO_TIPODATAREFERENCIA_INVALIDO;

    private int ERRO_TURNO_DESCONHECIDO;

    private int ERRO_USUARIO_REVISAO_DESCONHECIDO;

    private int ERRO_USUARIO_STATUS_DESCONHECIDO;

    private int EVENTO_BEM_SUCEDIDO;

    private int resultadoEvento;

    public CalendarioDTO() {
    }

    public CalendarioDTO(
           idw.idwws.DwCal calendario,
           idw.idwws.CalendarioPtsDTO calendarioPts,
           idw.idwws.CalendariosSemanaisDTO calendariosSemanais,
           int ERRO_CALENDARIO_JA_EXISTE,
           int ERRO_CDCALENDARIO_INVALIDO,
           int ERRO_DATAFINAL_INFERIOR,
           int ERRO_DATAINICIAL_INVALIDA,
           int ERRO_DESCONHECIDO,
           int ERRO_DIADASEMANA_DESCONHECIDO,
           int ERRO_EXISTE_CALENDARIO_EM_ABERTO,
           int ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO,
           int ERRO_FIMTURNO_SEM_INICIO_ANTERIOR,
           int ERRO_HORAFINAL_MENOR_HORAINICIAL,
           int ERRO_INICIOTURNO_SEM_FIM_ANTERIOR,
           int ERRO_PERIODO_CALENDARIO_CONFLITA,
           int ERRO_REATIVACAO_INDISPONIVEL,
           int ERRO_TEMPOCALENDARIO_INVALIDO,
           int ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO,
           int ERRO_TIPODATAREFERENCIA_INVALIDO,
           int ERRO_TURNO_DESCONHECIDO,
           int ERRO_USUARIO_REVISAO_DESCONHECIDO,
           int ERRO_USUARIO_STATUS_DESCONHECIDO,
           int EVENTO_BEM_SUCEDIDO,
           int resultadoEvento) {
           this.calendario = calendario;
           this.calendarioPts = calendarioPts;
           this.calendariosSemanais = calendariosSemanais;
           this.ERRO_CALENDARIO_JA_EXISTE = ERRO_CALENDARIO_JA_EXISTE;
           this.ERRO_CDCALENDARIO_INVALIDO = ERRO_CDCALENDARIO_INVALIDO;
           this.ERRO_DATAFINAL_INFERIOR = ERRO_DATAFINAL_INFERIOR;
           this.ERRO_DATAINICIAL_INVALIDA = ERRO_DATAINICIAL_INVALIDA;
           this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
           this.ERRO_DIADASEMANA_DESCONHECIDO = ERRO_DIADASEMANA_DESCONHECIDO;
           this.ERRO_EXISTE_CALENDARIO_EM_ABERTO = ERRO_EXISTE_CALENDARIO_EM_ABERTO;
           this.ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO = ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO;
           this.ERRO_FIMTURNO_SEM_INICIO_ANTERIOR = ERRO_FIMTURNO_SEM_INICIO_ANTERIOR;
           this.ERRO_HORAFINAL_MENOR_HORAINICIAL = ERRO_HORAFINAL_MENOR_HORAINICIAL;
           this.ERRO_INICIOTURNO_SEM_FIM_ANTERIOR = ERRO_INICIOTURNO_SEM_FIM_ANTERIOR;
           this.ERRO_PERIODO_CALENDARIO_CONFLITA = ERRO_PERIODO_CALENDARIO_CONFLITA;
           this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
           this.ERRO_TEMPOCALENDARIO_INVALIDO = ERRO_TEMPOCALENDARIO_INVALIDO;
           this.ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO = ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO;
           this.ERRO_TIPODATAREFERENCIA_INVALIDO = ERRO_TIPODATAREFERENCIA_INVALIDO;
           this.ERRO_TURNO_DESCONHECIDO = ERRO_TURNO_DESCONHECIDO;
           this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
           this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
           this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
           this.resultadoEvento = resultadoEvento;
    }


    /**
     * Gets the calendario value for this CalendarioDTO.
     * 
     * @return calendario
     */
    public idw.idwws.DwCal getCalendario() {
        return calendario;
    }


    /**
     * Sets the calendario value for this CalendarioDTO.
     * 
     * @param calendario
     */
    public void setCalendario(idw.idwws.DwCal calendario) {
        this.calendario = calendario;
    }


    /**
     * Gets the calendarioPts value for this CalendarioDTO.
     * 
     * @return calendarioPts
     */
    public idw.idwws.CalendarioPtsDTO getCalendarioPts() {
        return calendarioPts;
    }


    /**
     * Sets the calendarioPts value for this CalendarioDTO.
     * 
     * @param calendarioPts
     */
    public void setCalendarioPts(idw.idwws.CalendarioPtsDTO calendarioPts) {
        this.calendarioPts = calendarioPts;
    }


    /**
     * Gets the calendariosSemanais value for this CalendarioDTO.
     * 
     * @return calendariosSemanais
     */
    public idw.idwws.CalendariosSemanaisDTO getCalendariosSemanais() {
        return calendariosSemanais;
    }


    /**
     * Sets the calendariosSemanais value for this CalendarioDTO.
     * 
     * @param calendariosSemanais
     */
    public void setCalendariosSemanais(idw.idwws.CalendariosSemanaisDTO calendariosSemanais) {
        this.calendariosSemanais = calendariosSemanais;
    }


    /**
     * Gets the ERRO_CALENDARIO_JA_EXISTE value for this CalendarioDTO.
     * 
     * @return ERRO_CALENDARIO_JA_EXISTE
     */
    public int getERRO_CALENDARIO_JA_EXISTE() {
        return ERRO_CALENDARIO_JA_EXISTE;
    }


    /**
     * Sets the ERRO_CALENDARIO_JA_EXISTE value for this CalendarioDTO.
     * 
     * @param ERRO_CALENDARIO_JA_EXISTE
     */
    public void setERRO_CALENDARIO_JA_EXISTE(int ERRO_CALENDARIO_JA_EXISTE) {
        this.ERRO_CALENDARIO_JA_EXISTE = ERRO_CALENDARIO_JA_EXISTE;
    }


    /**
     * Gets the ERRO_CDCALENDARIO_INVALIDO value for this CalendarioDTO.
     * 
     * @return ERRO_CDCALENDARIO_INVALIDO
     */
    public int getERRO_CDCALENDARIO_INVALIDO() {
        return ERRO_CDCALENDARIO_INVALIDO;
    }


    /**
     * Sets the ERRO_CDCALENDARIO_INVALIDO value for this CalendarioDTO.
     * 
     * @param ERRO_CDCALENDARIO_INVALIDO
     */
    public void setERRO_CDCALENDARIO_INVALIDO(int ERRO_CDCALENDARIO_INVALIDO) {
        this.ERRO_CDCALENDARIO_INVALIDO = ERRO_CDCALENDARIO_INVALIDO;
    }


    /**
     * Gets the ERRO_DATAFINAL_INFERIOR value for this CalendarioDTO.
     * 
     * @return ERRO_DATAFINAL_INFERIOR
     */
    public int getERRO_DATAFINAL_INFERIOR() {
        return ERRO_DATAFINAL_INFERIOR;
    }


    /**
     * Sets the ERRO_DATAFINAL_INFERIOR value for this CalendarioDTO.
     * 
     * @param ERRO_DATAFINAL_INFERIOR
     */
    public void setERRO_DATAFINAL_INFERIOR(int ERRO_DATAFINAL_INFERIOR) {
        this.ERRO_DATAFINAL_INFERIOR = ERRO_DATAFINAL_INFERIOR;
    }


    /**
     * Gets the ERRO_DATAINICIAL_INVALIDA value for this CalendarioDTO.
     * 
     * @return ERRO_DATAINICIAL_INVALIDA
     */
    public int getERRO_DATAINICIAL_INVALIDA() {
        return ERRO_DATAINICIAL_INVALIDA;
    }


    /**
     * Sets the ERRO_DATAINICIAL_INVALIDA value for this CalendarioDTO.
     * 
     * @param ERRO_DATAINICIAL_INVALIDA
     */
    public void setERRO_DATAINICIAL_INVALIDA(int ERRO_DATAINICIAL_INVALIDA) {
        this.ERRO_DATAINICIAL_INVALIDA = ERRO_DATAINICIAL_INVALIDA;
    }


    /**
     * Gets the ERRO_DESCONHECIDO value for this CalendarioDTO.
     * 
     * @return ERRO_DESCONHECIDO
     */
    public int getERRO_DESCONHECIDO() {
        return ERRO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DESCONHECIDO value for this CalendarioDTO.
     * 
     * @param ERRO_DESCONHECIDO
     */
    public void setERRO_DESCONHECIDO(int ERRO_DESCONHECIDO) {
        this.ERRO_DESCONHECIDO = ERRO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_DIADASEMANA_DESCONHECIDO value for this CalendarioDTO.
     * 
     * @return ERRO_DIADASEMANA_DESCONHECIDO
     */
    public int getERRO_DIADASEMANA_DESCONHECIDO() {
        return ERRO_DIADASEMANA_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_DIADASEMANA_DESCONHECIDO value for this CalendarioDTO.
     * 
     * @param ERRO_DIADASEMANA_DESCONHECIDO
     */
    public void setERRO_DIADASEMANA_DESCONHECIDO(int ERRO_DIADASEMANA_DESCONHECIDO) {
        this.ERRO_DIADASEMANA_DESCONHECIDO = ERRO_DIADASEMANA_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_EXISTE_CALENDARIO_EM_ABERTO value for this CalendarioDTO.
     * 
     * @return ERRO_EXISTE_CALENDARIO_EM_ABERTO
     */
    public int getERRO_EXISTE_CALENDARIO_EM_ABERTO() {
        return ERRO_EXISTE_CALENDARIO_EM_ABERTO;
    }


    /**
     * Sets the ERRO_EXISTE_CALENDARIO_EM_ABERTO value for this CalendarioDTO.
     * 
     * @param ERRO_EXISTE_CALENDARIO_EM_ABERTO
     */
    public void setERRO_EXISTE_CALENDARIO_EM_ABERTO(int ERRO_EXISTE_CALENDARIO_EM_ABERTO) {
        this.ERRO_EXISTE_CALENDARIO_EM_ABERTO = ERRO_EXISTE_CALENDARIO_EM_ABERTO;
    }


    /**
     * Gets the ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO value for this CalendarioDTO.
     * 
     * @return ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO
     */
    public int getERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO() {
        return ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO;
    }


    /**
     * Sets the ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO value for this CalendarioDTO.
     * 
     * @param ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO
     */
    public void setERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO(int ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO) {
        this.ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO = ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO;
    }


    /**
     * Gets the ERRO_FIMTURNO_SEM_INICIO_ANTERIOR value for this CalendarioDTO.
     * 
     * @return ERRO_FIMTURNO_SEM_INICIO_ANTERIOR
     */
    public int getERRO_FIMTURNO_SEM_INICIO_ANTERIOR() {
        return ERRO_FIMTURNO_SEM_INICIO_ANTERIOR;
    }


    /**
     * Sets the ERRO_FIMTURNO_SEM_INICIO_ANTERIOR value for this CalendarioDTO.
     * 
     * @param ERRO_FIMTURNO_SEM_INICIO_ANTERIOR
     */
    public void setERRO_FIMTURNO_SEM_INICIO_ANTERIOR(int ERRO_FIMTURNO_SEM_INICIO_ANTERIOR) {
        this.ERRO_FIMTURNO_SEM_INICIO_ANTERIOR = ERRO_FIMTURNO_SEM_INICIO_ANTERIOR;
    }


    /**
     * Gets the ERRO_HORAFINAL_MENOR_HORAINICIAL value for this CalendarioDTO.
     * 
     * @return ERRO_HORAFINAL_MENOR_HORAINICIAL
     */
    public int getERRO_HORAFINAL_MENOR_HORAINICIAL() {
        return ERRO_HORAFINAL_MENOR_HORAINICIAL;
    }


    /**
     * Sets the ERRO_HORAFINAL_MENOR_HORAINICIAL value for this CalendarioDTO.
     * 
     * @param ERRO_HORAFINAL_MENOR_HORAINICIAL
     */
    public void setERRO_HORAFINAL_MENOR_HORAINICIAL(int ERRO_HORAFINAL_MENOR_HORAINICIAL) {
        this.ERRO_HORAFINAL_MENOR_HORAINICIAL = ERRO_HORAFINAL_MENOR_HORAINICIAL;
    }


    /**
     * Gets the ERRO_INICIOTURNO_SEM_FIM_ANTERIOR value for this CalendarioDTO.
     * 
     * @return ERRO_INICIOTURNO_SEM_FIM_ANTERIOR
     */
    public int getERRO_INICIOTURNO_SEM_FIM_ANTERIOR() {
        return ERRO_INICIOTURNO_SEM_FIM_ANTERIOR;
    }


    /**
     * Sets the ERRO_INICIOTURNO_SEM_FIM_ANTERIOR value for this CalendarioDTO.
     * 
     * @param ERRO_INICIOTURNO_SEM_FIM_ANTERIOR
     */
    public void setERRO_INICIOTURNO_SEM_FIM_ANTERIOR(int ERRO_INICIOTURNO_SEM_FIM_ANTERIOR) {
        this.ERRO_INICIOTURNO_SEM_FIM_ANTERIOR = ERRO_INICIOTURNO_SEM_FIM_ANTERIOR;
    }


    /**
     * Gets the ERRO_PERIODO_CALENDARIO_CONFLITA value for this CalendarioDTO.
     * 
     * @return ERRO_PERIODO_CALENDARIO_CONFLITA
     */
    public int getERRO_PERIODO_CALENDARIO_CONFLITA() {
        return ERRO_PERIODO_CALENDARIO_CONFLITA;
    }


    /**
     * Sets the ERRO_PERIODO_CALENDARIO_CONFLITA value for this CalendarioDTO.
     * 
     * @param ERRO_PERIODO_CALENDARIO_CONFLITA
     */
    public void setERRO_PERIODO_CALENDARIO_CONFLITA(int ERRO_PERIODO_CALENDARIO_CONFLITA) {
        this.ERRO_PERIODO_CALENDARIO_CONFLITA = ERRO_PERIODO_CALENDARIO_CONFLITA;
    }


    /**
     * Gets the ERRO_REATIVACAO_INDISPONIVEL value for this CalendarioDTO.
     * 
     * @return ERRO_REATIVACAO_INDISPONIVEL
     */
    public int getERRO_REATIVACAO_INDISPONIVEL() {
        return ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Sets the ERRO_REATIVACAO_INDISPONIVEL value for this CalendarioDTO.
     * 
     * @param ERRO_REATIVACAO_INDISPONIVEL
     */
    public void setERRO_REATIVACAO_INDISPONIVEL(int ERRO_REATIVACAO_INDISPONIVEL) {
        this.ERRO_REATIVACAO_INDISPONIVEL = ERRO_REATIVACAO_INDISPONIVEL;
    }


    /**
     * Gets the ERRO_TEMPOCALENDARIO_INVALIDO value for this CalendarioDTO.
     * 
     * @return ERRO_TEMPOCALENDARIO_INVALIDO
     */
    public int getERRO_TEMPOCALENDARIO_INVALIDO() {
        return ERRO_TEMPOCALENDARIO_INVALIDO;
    }


    /**
     * Sets the ERRO_TEMPOCALENDARIO_INVALIDO value for this CalendarioDTO.
     * 
     * @param ERRO_TEMPOCALENDARIO_INVALIDO
     */
    public void setERRO_TEMPOCALENDARIO_INVALIDO(int ERRO_TEMPOCALENDARIO_INVALIDO) {
        this.ERRO_TEMPOCALENDARIO_INVALIDO = ERRO_TEMPOCALENDARIO_INVALIDO;
    }


    /**
     * Gets the ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO value for this CalendarioDTO.
     * 
     * @return ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO
     */
    public int getERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO() {
        return ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO;
    }


    /**
     * Sets the ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO value for this CalendarioDTO.
     * 
     * @param ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO
     */
    public void setERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO(int ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO) {
        this.ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO = ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO;
    }


    /**
     * Gets the ERRO_TIPODATAREFERENCIA_INVALIDO value for this CalendarioDTO.
     * 
     * @return ERRO_TIPODATAREFERENCIA_INVALIDO
     */
    public int getERRO_TIPODATAREFERENCIA_INVALIDO() {
        return ERRO_TIPODATAREFERENCIA_INVALIDO;
    }


    /**
     * Sets the ERRO_TIPODATAREFERENCIA_INVALIDO value for this CalendarioDTO.
     * 
     * @param ERRO_TIPODATAREFERENCIA_INVALIDO
     */
    public void setERRO_TIPODATAREFERENCIA_INVALIDO(int ERRO_TIPODATAREFERENCIA_INVALIDO) {
        this.ERRO_TIPODATAREFERENCIA_INVALIDO = ERRO_TIPODATAREFERENCIA_INVALIDO;
    }


    /**
     * Gets the ERRO_TURNO_DESCONHECIDO value for this CalendarioDTO.
     * 
     * @return ERRO_TURNO_DESCONHECIDO
     */
    public int getERRO_TURNO_DESCONHECIDO() {
        return ERRO_TURNO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_TURNO_DESCONHECIDO value for this CalendarioDTO.
     * 
     * @param ERRO_TURNO_DESCONHECIDO
     */
    public void setERRO_TURNO_DESCONHECIDO(int ERRO_TURNO_DESCONHECIDO) {
        this.ERRO_TURNO_DESCONHECIDO = ERRO_TURNO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this CalendarioDTO.
     * 
     * @return ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
        return ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_REVISAO_DESCONHECIDO value for this CalendarioDTO.
     * 
     * @param ERRO_USUARIO_REVISAO_DESCONHECIDO
     */
    public void setERRO_USUARIO_REVISAO_DESCONHECIDO(int ERRO_USUARIO_REVISAO_DESCONHECIDO) {
        this.ERRO_USUARIO_REVISAO_DESCONHECIDO = ERRO_USUARIO_REVISAO_DESCONHECIDO;
    }


    /**
     * Gets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this CalendarioDTO.
     * 
     * @return ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
        return ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Sets the ERRO_USUARIO_STATUS_DESCONHECIDO value for this CalendarioDTO.
     * 
     * @param ERRO_USUARIO_STATUS_DESCONHECIDO
     */
    public void setERRO_USUARIO_STATUS_DESCONHECIDO(int ERRO_USUARIO_STATUS_DESCONHECIDO) {
        this.ERRO_USUARIO_STATUS_DESCONHECIDO = ERRO_USUARIO_STATUS_DESCONHECIDO;
    }


    /**
     * Gets the EVENTO_BEM_SUCEDIDO value for this CalendarioDTO.
     * 
     * @return EVENTO_BEM_SUCEDIDO
     */
    public int getEVENTO_BEM_SUCEDIDO() {
        return EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Sets the EVENTO_BEM_SUCEDIDO value for this CalendarioDTO.
     * 
     * @param EVENTO_BEM_SUCEDIDO
     */
    public void setEVENTO_BEM_SUCEDIDO(int EVENTO_BEM_SUCEDIDO) {
        this.EVENTO_BEM_SUCEDIDO = EVENTO_BEM_SUCEDIDO;
    }


    /**
     * Gets the resultadoEvento value for this CalendarioDTO.
     * 
     * @return resultadoEvento
     */
    public int getResultadoEvento() {
        return resultadoEvento;
    }


    /**
     * Sets the resultadoEvento value for this CalendarioDTO.
     * 
     * @param resultadoEvento
     */
    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CalendarioDTO)) return false;
        CalendarioDTO other = (CalendarioDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.calendario==null && other.getCalendario()==null) || 
             (this.calendario!=null &&
              this.calendario.equals(other.getCalendario()))) &&
            ((this.calendarioPts==null && other.getCalendarioPts()==null) || 
             (this.calendarioPts!=null &&
              this.calendarioPts.equals(other.getCalendarioPts()))) &&
            ((this.calendariosSemanais==null && other.getCalendariosSemanais()==null) || 
             (this.calendariosSemanais!=null &&
              this.calendariosSemanais.equals(other.getCalendariosSemanais()))) &&
            this.ERRO_CALENDARIO_JA_EXISTE == other.getERRO_CALENDARIO_JA_EXISTE() &&
            this.ERRO_CDCALENDARIO_INVALIDO == other.getERRO_CDCALENDARIO_INVALIDO() &&
            this.ERRO_DATAFINAL_INFERIOR == other.getERRO_DATAFINAL_INFERIOR() &&
            this.ERRO_DATAINICIAL_INVALIDA == other.getERRO_DATAINICIAL_INVALIDA() &&
            this.ERRO_DESCONHECIDO == other.getERRO_DESCONHECIDO() &&
            this.ERRO_DIADASEMANA_DESCONHECIDO == other.getERRO_DIADASEMANA_DESCONHECIDO() &&
            this.ERRO_EXISTE_CALENDARIO_EM_ABERTO == other.getERRO_EXISTE_CALENDARIO_EM_ABERTO() &&
            this.ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO == other.getERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO() &&
            this.ERRO_FIMTURNO_SEM_INICIO_ANTERIOR == other.getERRO_FIMTURNO_SEM_INICIO_ANTERIOR() &&
            this.ERRO_HORAFINAL_MENOR_HORAINICIAL == other.getERRO_HORAFINAL_MENOR_HORAINICIAL() &&
            this.ERRO_INICIOTURNO_SEM_FIM_ANTERIOR == other.getERRO_INICIOTURNO_SEM_FIM_ANTERIOR() &&
            this.ERRO_PERIODO_CALENDARIO_CONFLITA == other.getERRO_PERIODO_CALENDARIO_CONFLITA() &&
            this.ERRO_REATIVACAO_INDISPONIVEL == other.getERRO_REATIVACAO_INDISPONIVEL() &&
            this.ERRO_TEMPOCALENDARIO_INVALIDO == other.getERRO_TEMPOCALENDARIO_INVALIDO() &&
            this.ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO == other.getERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO() &&
            this.ERRO_TIPODATAREFERENCIA_INVALIDO == other.getERRO_TIPODATAREFERENCIA_INVALIDO() &&
            this.ERRO_TURNO_DESCONHECIDO == other.getERRO_TURNO_DESCONHECIDO() &&
            this.ERRO_USUARIO_REVISAO_DESCONHECIDO == other.getERRO_USUARIO_REVISAO_DESCONHECIDO() &&
            this.ERRO_USUARIO_STATUS_DESCONHECIDO == other.getERRO_USUARIO_STATUS_DESCONHECIDO() &&
            this.EVENTO_BEM_SUCEDIDO == other.getEVENTO_BEM_SUCEDIDO() &&
            this.resultadoEvento == other.getResultadoEvento();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCalendario() != null) {
            _hashCode += getCalendario().hashCode();
        }
        if (getCalendarioPts() != null) {
            _hashCode += getCalendarioPts().hashCode();
        }
        if (getCalendariosSemanais() != null) {
            _hashCode += getCalendariosSemanais().hashCode();
        }
        _hashCode += getERRO_CALENDARIO_JA_EXISTE();
        _hashCode += getERRO_CDCALENDARIO_INVALIDO();
        _hashCode += getERRO_DATAFINAL_INFERIOR();
        _hashCode += getERRO_DATAINICIAL_INVALIDA();
        _hashCode += getERRO_DESCONHECIDO();
        _hashCode += getERRO_DIADASEMANA_DESCONHECIDO();
        _hashCode += getERRO_EXISTE_CALENDARIO_EM_ABERTO();
        _hashCode += getERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO();
        _hashCode += getERRO_FIMTURNO_SEM_INICIO_ANTERIOR();
        _hashCode += getERRO_HORAFINAL_MENOR_HORAINICIAL();
        _hashCode += getERRO_INICIOTURNO_SEM_FIM_ANTERIOR();
        _hashCode += getERRO_PERIODO_CALENDARIO_CONFLITA();
        _hashCode += getERRO_REATIVACAO_INDISPONIVEL();
        _hashCode += getERRO_TEMPOCALENDARIO_INVALIDO();
        _hashCode += getERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO();
        _hashCode += getERRO_TIPODATAREFERENCIA_INVALIDO();
        _hashCode += getERRO_TURNO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_REVISAO_DESCONHECIDO();
        _hashCode += getERRO_USUARIO_STATUS_DESCONHECIDO();
        _hashCode += getEVENTO_BEM_SUCEDIDO();
        _hashCode += getResultadoEvento();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CalendarioDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "calendarioDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "calendario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "dwCal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendarioPts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "calendarioPts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "calendarioPtsDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("calendariosSemanais");
        elemField.setXmlName(new javax.xml.namespace.QName("", "calendariosSemanais"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://idw/idwws", "calendariosSemanaisDTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CALENDARIO_JA_EXISTE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CALENDARIO_JA_EXISTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_CDCALENDARIO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_CDCALENDARIO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DATAFINAL_INFERIOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DATAFINAL_INFERIOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DATAINICIAL_INVALIDA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DATAINICIAL_INVALIDA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_DIADASEMANA_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_DIADASEMANA_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_EXISTE_CALENDARIO_EM_ABERTO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_EXISTE_CALENDARIO_EM_ABERTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_FIMTURNO_DIFERENTE_TURNOAVALIADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_FIMTURNO_SEM_INICIO_ANTERIOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_FIMTURNO_SEM_INICIO_ANTERIOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_HORAFINAL_MENOR_HORAINICIAL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_HORAFINAL_MENOR_HORAINICIAL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_INICIOTURNO_SEM_FIM_ANTERIOR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_INICIOTURNO_SEM_FIM_ANTERIOR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_PERIODO_CALENDARIO_CONFLITA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_PERIODO_CALENDARIO_CONFLITA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_REATIVACAO_INDISPONIVEL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_REATIVACAO_INDISPONIVEL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TEMPOCALENDARIO_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TEMPOCALENDARIO_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TEMPOSEMPESO_MAIOR_TEMPOCALENDARIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TIPODATAREFERENCIA_INVALIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TIPODATAREFERENCIA_INVALIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_TURNO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_TURNO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_REVISAO_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_REVISAO_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO_USUARIO_STATUS_DESCONHECIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO_USUARIO_STATUS_DESCONHECIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EVENTO_BEM_SUCEDIDO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "EVENTO_BEM_SUCEDIDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resultadoEvento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resultadoEvento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
