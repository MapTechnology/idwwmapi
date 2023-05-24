package idw.model.rn.injet.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbgal;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.GalpaoInjetRN;

public class FiltroInjetDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dtInicio = null;
	private Date dtFim = null;
	private List<String> galpoes = new ArrayList<String>();
	private String cdTurno = "";
	private String cdMaquina = "";
	private String cdMaquinaGrupo = "";
	private String cdMolde = "";
	private String cdMoldeGrupo = "";
	private String cdProduto = "";
	private String nrop = "";
	private int tipoDetalhe = 0;
	private int indicador = 0;
	private int order = 0;
	private int semestre = 0;
	private int anoInicio = 0;
	private int mesInicio = 0;
	private int anoFinal = 0;
	private int mesFinal = 0;
	private boolean comHora = false;
	private String erro = "";
	private String cdUsuario;
	private String hrInicio = "";
	private String hrFim = "";
	
	/**
	 * @return the dtInicio
	 */
	public Date getDtInicio() {
		return dtInicio;
	}
	/**
	 * @param dtInicio the dtInicio to set
	 */
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	/**
	 * @return the dtFim
	 */
	public Date getDtFim() {
		return dtFim;
	}
	/**
	 * @param dtFim the dtFim to set
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	/**
	 * @return the galpoes
	 */
	public List<String> getGalpoes() {
		return galpoes;
	}
	/**
	 * @param galpoes the galpoes to set
	 */
	public void setGalpoes(List<String> galpoes) {
		this.galpoes = galpoes;
	}
	/**
	 * @return the cdTurno
	 */
	public String getCdTurno() {
		String retorno = "";
		
		if (cdTurno != null && !cdTurno.equals(""))
			retorno = cdTurno;

		if (retorno.indexOf(" -") > 0)
			retorno = cdTurno.substring(0, cdTurno.indexOf(" -"));
		return retorno;
	}
	/**
	 * @param cdTurno the cdTurno to set
	 */
	public void setCdTurno(String cdTurno) {
		this.cdTurno = cdTurno;
	}
	/**
	 * @return the cdMaquina
	 */
	public String getCdMaquina() {
		String retorno = "";
		
		if (cdMaquina != null && !cdMaquina.equals(""))
			retorno = cdMaquina;
		
		if (retorno.indexOf(" -") > 0)
			retorno = cdMaquina.substring(0, cdMaquina.indexOf(" -"));
		return retorno;
	}
	/**
	 * @param cdMaquina the cdMaquina to set
	 */
	public void setCdMaquina(String cdMaquina) {
		this.cdMaquina = cdMaquina;
	}
	/**
	 * @return the cdMaquinaGrupo
	 */
	public String getCdMaquinaGrupo() {
		return cdMaquinaGrupo;
	}
	/**
	 * @param cdMaquinaGrupo the cdMaquinaGrupo to set
	 */
	public void setCdMaquinaGrupo(String cdMaquinaGrupo) {
		this.cdMaquinaGrupo = cdMaquinaGrupo;
	}
	/**
	 * @return the cdMolde
	 */
	public String getCdMolde() {
		return cdMolde;
	}
	/**
	 * @param cdMolde the cdMolde to set
	 */
	public void setCdMolde(String cdMolde) {
		this.cdMolde = cdMolde;
	}
	/**
	 * @return the cdMoldeGrupo
	 */
	public String getCdMoldeGrupo() {
		return cdMoldeGrupo;
	}
	/**
	 * @param cdMoldeGrupo the cdMoldeGrupo to set
	 */
	public void setCdMoldeGrupo(String cdMoldeGrupo) {
		this.cdMoldeGrupo = cdMoldeGrupo;
	}
	/**
	 * @return the cdProduto
	 */
	public String getCdProduto() {
		return cdProduto;
	}
	/**
	 * @param cdProduto the cdProduto to set
	 */
	public void setCdProduto(String cdProduto) {
		this.cdProduto = cdProduto;
	}
	/**
	 * @return the nrop
	 */
	public String getNrop() {
		return nrop;
	}
	/**
	 * @param nrop the nrop to set
	 */
	public void setNrop(String nrop) {
		this.nrop = nrop;
	}
	/**
	 * @return the tipoDetalhe
	 */
	public int getTipoDetalhe() {
		return tipoDetalhe;
	}
	/**
	 * @param tipoDetalhe the tipoDetalhe to set
	 */
	public void setTipoDetalhe(int tipoDetalhe) {
		this.tipoDetalhe = tipoDetalhe;
	}
	/**
	 * @return the indicador
	 */
	public int getIndicador() {
		return indicador;
	}
	/**
	 * @param indicador the indicador to set
	 */
	public void setIndicador(int indicador) {
		this.indicador = indicador;
	}
	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	
	public List<ArrayList<String>> getFiltro(){
		List<ArrayList<String>> filtro = new ArrayList<ArrayList<String>>();		
		if (!this.gAnoInicio().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Ano inicial");
			valor.add(this.gAnoInicio());
			filtro.add(valor);
		}
		if (!this.gSemestre().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Semestre");
			valor.add(this.gSemestre());
			filtro.add(valor);
		}
		if (!this.gMesInicio().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("M�s inicial");
			valor.add(this.gMesInicio());
			filtro.add(valor);
		}
		if (!this.gAnoFinal().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Ano final");
			valor.add(this.gAnoFinal());
			filtro.add(valor);
		}
		if (!this.gMesFinal().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("M�s final");
			valor.add(this.gMesFinal());
			filtro.add(valor);
		}
		if (!this.gDtInicio().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Data inicial");
			valor.add(this.gDtInicio());
			filtro.add(valor);
		}
		if (!this.gDtFim().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Data final");
			valor.add(this.gDtFim());
			filtro.add(valor);
		}
		if (!this.gGalpoes().isEmpty()){
			ArrayList<String> valor = new ArrayList<String>();			
			valor.add("Galp�es");			
			for (String galpao : this.galpoes){
				valor.add(galpao);
			}			
			filtro.add(valor);
		}
		if (!this.gCdMaquina().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("M�quina");
			valor.add(this.gCdMaquina());
			filtro.add(valor);
		}
		if (!this.gCdMaquinaGrupo().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Grupo de m�quina");
			valor.add(this.gCdMaquinaGrupo());
			filtro.add(valor);
		}
		if (!this.gCdTurno().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Turno");
			valor.add(this.gCdTurno());
			filtro.add(valor);
		}
		if (!this.gCdMolde().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Molde");
			valor.add(this.gCdMolde());
			filtro.add(valor);
		}
		if (!this.gCdMoldeGrupo().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Grupo de molde");
			valor.add(this.gCdMoldeGrupo());
			filtro.add(valor);
		}
		if (!this.gCdProduto().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Produto");
			valor.add(this.gCdProduto());
			filtro.add(valor);
		}
		if (!this.gNrop().toString().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Ordem de produ��o");
			valor.add(this.gNrop());
			filtro.add(valor);
		}
		if (!this.gTipoDetalhe().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Tipo de detalhe");
			valor.add(this.gTipoDetalhe());
			filtro.add(valor);
		}
		if (!this.gIndicador().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Indicador");
			valor.add(this.gIndicador());
			filtro.add(valor);
		}
		if (!this.gOrder().equals("")){
			ArrayList<String> valor = new ArrayList<String>();
			valor.add("Ordenador por");
			valor.add(this.gOrder());
			filtro.add(valor);
		}		
		
		return filtro;
	}
	
	/**
	 * @return the dtInicio
	 */
	public String gDtInicio() {
		try {
			String formato = "dd/MM/yyyy";
			if (this.comHora){
				formato += " HH:mm:ss"; 
			}
	        DateFormat dateFormat = new SimpleDateFormat(formato);        
	        return dateFormat.format(dtInicio);
		} catch (Exception e) {
			//erro = "Data inicial inv�lida";
			return "";
		}				
	}
	/**
	 * @param dtInicio the dtInicio to set
	 */
	public void sDtInicio(String dtInicio, boolean obrigatorio) {
		if (obrigatorio && dtInicio.trim().equals("")){
			erro = "Informe a data inicial";
			return;
		}
		if (!dtInicio.trim().equals("") && !this.comHora && dtInicio.trim().length()<= 10){
			dtInicio = dtInicio.trim() + " 00:00:00";
		}
		DateFormat dateFormat = new SimpleDateFormat();		
		try {			
			this.dtInicio = dateFormat.parse(dtInicio.trim());
		} catch (Exception e) {
			if (!dtInicio.trim().equals("")){
				if (this.comHora){
					erro = "A Data ou hora inicial em branco ou com valor inv�lido. Ajuste os valores e tente novamente.";
				}else{
					erro = "Data inicial inv�lida";
				}
			}
			this.dtInicio = null;
		}			
	}
	/**
	 * @return the dtFim
	 */
	public String gDtFim() {
		try {
			String formato = "dd/MM/yyyy";
			if (this.comHora){
				formato += " HH:mm:ss"; 
			}
	        DateFormat dateFormat = new SimpleDateFormat(formato);        
	        return dateFormat.format(dtFim);
		} catch (Exception e) {
			//erro = "Data final inv�lida";
			return "";
		}		
	}
	/**
	 * @param dtFim the dtFim to set
	 */
	public void sDtFim(String dtFim, boolean obrigatorio) {
		if (obrigatorio && dtFim.trim().equals("")){
			erro = "Informe a data final";
			return;
		}
		if (!dtFim.trim().equals("") && !this.comHora && dtFim.trim().length()<= 10){
			dtFim = dtFim.trim() + " 00:00:00";
		}		
		String formato = "dd/MM/yyyy";
		if (this.comHora){
			formato += " HH:mm:ss"; 
		}
		DateFormat dateFormat = new SimpleDateFormat(formato);		
		try {			
			this.dtFim = dateFormat.parse(dtFim.trim());
		} catch (Exception e) {			
			if (!dtFim.trim().equals("")){
				if (this.comHora){
					erro = "A Data ou  a hora est�o em branco ou com valor inv�lido. Ajuste os valores e tente novamente.";
				}else{
					erro = "Data final inv�lida";
				}				
			}
			this.dtFim = null;
		}	
	}
	/**
	 * @return the galpoes
	 */
	public List<String> gGalpoes() {
		if (this.cdMaquina == null){
			return new ArrayList<String>();
		}
		return galpoes;		
	}
	/**
	 * @param galpoes the galpoes to set
	 */
	public void sGalpoes(Object galpoes, boolean obrigatorio) {		
		this.galpoes = new ArrayList<String>();
		try {
			for(String galpao : (String[]) galpoes){
				this.galpoes.add(galpao);
			}
		} catch (Exception e) {
			this.galpoes = new ArrayList<String>();
		}
		if (obrigatorio && this.galpoes.isEmpty()){
			erro = "Informe um galp�o pelo menos";
			return;
		}
		
	}
	/**
	 * @return the cdTurno
	 */
	public String gCdTurno() {
		if (this.cdTurno == null){
			return "";
		}
		return cdTurno;
	}
	/**
	 * @param cdTurno the cdTurno to set
	 */
	public void sCdTurno(String cdTurno, boolean obrigatorio) {
		if (obrigatorio && cdTurno.trim().equals("")){
			erro = "Informe o turno";
			return;
		}
		this.cdTurno = cdTurno;
	}
	/**
	 * @return the cdMaquina
	 */
	public String gCdMaquina() {
		if (this.cdMaquina == null){
			return "";
		}
		return cdMaquina;
	}
	/**
	 * @param cdMaquina the cdMaquina to set
	 */
	public void sCdMaquina(String cdMaquina, boolean obrigatorio) {
		if (obrigatorio && cdMaquina.trim().equals("")){
			erro = "Informe a m�quina";
			return;
		}
		this.cdMaquina = cdMaquina;
	}
	/**
	 * @return the cdMaquinaGrupo
	 */
	public String gCdMaquinaGrupo() {
		if (this.cdMaquinaGrupo == null){
			return "";
		}
		return cdMaquinaGrupo;
	}
	/**
	 * @param cdMaquinaGrupo the cdMaquinaGrupo to set
	 */
	public void sCdMaquinaGrupo(String cdMaquinaGrupo, boolean obrigatorio) {
		if (obrigatorio && cdMaquinaGrupo.trim().equals("")){
			erro = "Informe o grupo de m�quina";
			return;
		}
		this.cdMaquinaGrupo = cdMaquinaGrupo;
	}
	/**
	 * @return the cdMolde
	 */
	public String gCdMolde() {
		if (this.cdMolde == null){
			return "";
		}
		return cdMolde;
	}
	/**
	 * @param cdMolde the cdMolde to set
	 */
	public void sCdMolde(String cdMolde, boolean obrigatorio) {
		if (obrigatorio && cdMolde.trim().equals("")){
			erro = "Informe o molde";
			return;
		}
		this.cdMolde = cdMolde;
	}
	/**
	 * @return the cdMoldeGrupo
	 */
	public String gCdMoldeGrupo() {
		if (this.cdMoldeGrupo == null){
			return "";
		}
		return cdMoldeGrupo;
	}
	/**
	 * @param cdMoldeGrupo the cdMoldeGrupo to set
	 */
	public void sCdMoldeGrupo(String cdMoldeGrupo, boolean obrigatorio) {
		if (obrigatorio && cdMoldeGrupo.trim().equals("")){
			erro = "Informe o grupo de molde";
			return;
		}
		this.cdMoldeGrupo = cdMoldeGrupo;
	}
	/**
	 * @return the cdProduto
	 */
	public String gCdProduto() {
		if (this.cdProduto == null){
			return "";
		}
		return cdProduto;
	}
	/**
	 * @param cdProduto the cdProduto to set
	 */
	public void sCdProduto(String cdProduto, boolean obrigatorio) {
		if (obrigatorio && cdProduto.trim().equals("")){
			erro = "Informe o produto";
			return;
		}
		this.cdProduto = cdProduto;
	}
	/**
	 * @return the nrop
	 */
	public String gNrop() {
		if (this.nrop == null){
			return "";
		}
		return nrop;
	}
	/**
	 * @param nrop the nrop to set
	 */
	public void sNrop(String nrop, boolean obrigatorio) {
		if (obrigatorio && nrop.trim().equals("")){
			erro = "Informe a ordem de produ��o";
			return;
		}
		this.nrop = nrop;
	}
	/**
	 * @return the tipoDetalhe
	 */
	public String gTipoDetalhe() {		
		if (this.tipoDetalhe == 1){
			return "Motivos de paradas";
		}else if (this.tipoDetalhe == 2){
			return "�reas respons�veis pelas paradas";
		}else if (this.tipoDetalhe == 3){
			return "Sem detalhes";
		}else if(this.tipoDetalhe == 4){
			return "Colunas ocultas";
		}else{
			return "";
		}			
	}
	/**
	 * @param tipoDetalhe the tipoDetalhe to set
	 */
	public void sTipoDetalhe(String tipoDetalhe, boolean obrigatorio) {
		try {
			if (obrigatorio && tipoDetalhe.trim().equals("")){
				erro = "Informe o tipo de detalhe";
				return;
			}
			this.tipoDetalhe = Integer.parseInt(tipoDetalhe);
		} catch (Exception e) {
			if (!tipoDetalhe.trim().equals("")){
				erro = "Tipo de detalhe inv�lido";
			}
			this.tipoDetalhe = 0;
		}
	}
	/**
	 * @return the indicador
	 */
	public String gIndicador() {		
		if (this.indicador == 1){
			return "OEE";
		}else if (this.indicador == 2){
			return "OEE Capital";
		}else if (this.indicador == 3){
			return "Efici�ncia de realiza��o";
		}else if (this.indicador == 4){
			return "�ndice de parada";
		}else if (this.indicador == 5){
			return "�ndice de refugo";
		}else if (this.indicador == 6){
			return "Efici�ncia de ciclo";
		}else if (this.indicador == 7){
			return "�ndice de perda";
		}else{
			return "";
		}	
	}
	/**
	 * @param indicador the indicador to set
	 */
	public void sIndicador(String indicador, boolean obrigatorio) {
		if (obrigatorio && indicador.trim().equals("")){
			erro = "Informe o indicador";
			return;
		}
		try {
			this.indicador = Integer.parseInt(indicador);
		} catch (Exception e) {
			if (!indicador.trim().equals("")){
				erro = "Indicador inv�lido";
			}
			this.indicador = 0;
		}		
	}
	/**
	 * @return the order
	 */
	public String gOrder() {
		if (this.order == 1){
			return "M�quina";
		}else if (this.order == 2){
			return "Data/hora de entrada do molde em produ��o";
		}else{
			return "";
		}	
	}
	/**
	 * @param order the order to set
	 */
	public void sOrder(String order, boolean obrigatorio) {
		if (obrigatorio && order.trim().equals("")){
			erro = "Informe o tipo de ordena��o";
			return;
		}
		try {
			this.order = Integer.parseInt(order);
		} catch (Exception e) {
			if (!order.trim().equals("")){
				erro = "Tipo de ordena��o inv�lida";
			}
			this.order = 0;
		}
	}
	
	/**
	 * @return the semestre
	 */
	public String gSemestre() {
		if (this.semestre == 1){
			return "Primeiro";
		}else if (this.semestre == 2){
			return "Segundo";
		}else{
			return "";
		}	
	}
	/**
	 * @param semestre the semestre to set
	 */
	public void sSemestre(String semestre, boolean obrigatorio) {
		if (obrigatorio && semestre.trim().equals("")){
			erro = "Informe o semestre";
			return;
		}
		try {
			this.semestre = Integer.parseInt(semestre);
		} catch (Exception e) {
			if (!semestre.trim().equals("")){
				erro = "Semestre inv�lido";
			}
			this.semestre = 0;
		}
	}
	/**
	 * @return the anoInicio
	 */
	public String gAnoInicio() {
		if (this.anoInicio == 0) return "";
		return Integer.toString(this.anoInicio);			
	}
	/**
	 * @param anoInicio the anoInicio to set
	 */
	public void sAnoInicio(String anoInicio, boolean obrigatorio) {
		if (obrigatorio && anoInicio.trim().equals("")){
			erro = "Informe o ano inicial";
			return;
		}
		try {
			this.anoInicio = Integer.parseInt(anoInicio);
		} catch (Exception e) {
			if (!anoInicio.trim().equals("")){
				erro = "Ano inicial inv�lido";
			}
			this.anoInicio = 0;
		}
	}
	
	/**
	 * @return the mesInicio
	 */
	public String gMesInicio() {
		if (this.mesInicio == 1){
			return "Janeiro";
		}else if (this.mesInicio == 2){
			return "Fevereiro";
		}else if (this.mesInicio == 3){
			return "Mar�o";
		}else if (this.mesInicio == 4){
			return "Abril";
		}else if (this.mesInicio == 5){
			return "Maio";
		}else if (this.mesInicio == 6){
			return "Junho";
		}else if (this.mesInicio == 7){
			return "Julho";
		}else if (this.mesInicio == 8){
			return "Agosto";
		}else if (this.mesInicio == 9){
			return "Setembro";
		}else if (this.mesInicio == 10){
			return "Outubro";
		}else if (this.mesInicio == 11){
			return "Novembro";
		}else if (this.mesInicio == 12){
			return "Dezembro";
		}else{
			return "";
		}	
	}
	/**
	 * @param mesInicio the mesInicio to set
	 */
	public void sMesInicio(String mesInicio, boolean obrigatorio) {
		if (obrigatorio && mesInicio.trim().equals("")){
			erro = "Informe o m�s inicial";
			return;
		}
		try {
			this.mesInicio = Integer.parseInt(mesInicio);
		} catch (Exception e) {
			if (!mesInicio.trim().equals("")){
				erro = "M�s inicial inv�lido";
			}
			this.mesInicio = 0;
		}
	}
	/**
	 * @return the anoFinal
	 */
	public String gAnoFinal() {
		if (this.anoFinal == 0) return "";
		return Integer.toString(this.anoFinal);			
	}
	
	/**
	 * @param anoFinal the anoFinal to set
	 */
	public void sAnoFinal(String anoFinal, boolean obrigatorio) {
		if (obrigatorio && anoFinal.trim().equals("")){
			erro = "Informe o ano final";
			return;
		}
		try {
			this.anoFinal = Integer.parseInt(anoFinal);
		} catch (Exception e) {
			if (!anoFinal.trim().equals("")){
				erro = "Ano final inv�lido";
			}
			this.anoFinal = 0;
		}
	}
	
	/**
	 * @return the mesFinal
	 */
	public String gMesFinal() {
		if (this.mesFinal == 1){
			return "Janeiro";
		}else if (this.mesFinal == 2){
			return "Fevereiro";
		}else if (this.mesFinal == 3){
			return "Mar�o";
		}else if (this.mesFinal == 4){
			return "Abril";
		}else if (this.mesFinal == 5){
			return "Maio";
		}else if (this.mesFinal == 6){
			return "Junho";
		}else if (this.mesFinal == 7){
			return "Julho";
		}else if (this.mesFinal == 8){
			return "Agosto";
		}else if (this.mesFinal == 9){
			return "Setembro";
		}else if (this.mesFinal == 10){
			return "Outubro";
		}else if (this.mesFinal == 11){
			return "Novembro";
		}else if (this.mesFinal == 12){
			return "Dezembro";
		}else{
			return "";
		}	
	}
	/**
	 * @param mesFinal the mesFinal to set
	 */
	public void sMesFinal(String mesFinal, boolean obrigatorio) {
		if (obrigatorio && mesFinal.trim().equals("")){
			erro = "Informe o m�s final";
			return;
		}
		try {
			this.mesFinal = Integer.parseInt(mesFinal);
		} catch (Exception e) {
			if (!mesFinal.trim().equals("")){
				erro = "M�s final inv�lido";
			}
			this.mesFinal = 0;
		}
	}
	/**
	 * @return the comHora
	 */
	public boolean isComHora() {
		return comHora;
	}
	/**
	 * @param comHora the comHora to set
	 */
	public void setComHora(boolean comHora) {
		this.comHora = comHora;
	}
	/**
	 * @return the erro
	 */
	public String getErro() {
		return erro;
	}
	/**
	 * @param erro the erro to set
	 */
	public void setErro(String erro) {
		this.erro = erro;
	}
	/**
	 * @return the semestre
	 */
	public int getSemestre() {
		return semestre;
	}
	/**
	 * @param semestre the semestre to set
	 */
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public int getAnoAnterior() {
		return anoInicio -1;
	}
	/**
	 * @return the anoInicio
	 */
	public int getAnoInicio() {
		return anoInicio;
	}
	/**
	 * @param anoInicio the anoInicio to set
	 */
	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}
	/**
	 * @return the mesInicio
	 */
	public int getMesInicio() {
		return mesInicio;
	}
	/**
	 * @param mesInicio the mesInicio to set
	 */
	public void setMesInicio(int mesInicio) {
		this.mesInicio = mesInicio;
	}
	/**
	 * @return the anoFinal
	 */
	public int getAnoFinal() {
		return anoFinal;
	}
	/**
	 * @param anoFinal the anoFinal to set
	 */
	public void setAnoFinal(int anoFinal) {
		this.anoFinal = anoFinal;
	}
	/**
	 * @return the mesFinal
	 */
	public int getMesFinal() {
		return mesFinal;
	}
	/**
	 * @param mesFinal the mesFinal to set
	 */
	public void setMesFinal(int mesFinal) {
		this.mesFinal = mesFinal;
	}

	public int getMesInicial(int ordem){
		int imes = this.mesInicio + (ordem - 1);
		
		return imes;
	}
	
	
	public int getMesDaDtInicio(){
		int retorno = 0;
		if (this.dtInicio != null){
			retorno = DataHoraRN.getApenasMes(this.dtInicio);
		}
		return retorno;
	}
	
	
	public Date getDataInicioAno(){
		GregorianCalendar calendario = new GregorianCalendar();
		
		calendario.setTime(new Date());
		calendario.set(this.anoInicio, 0, 1);
		
		Date retorno = null;
		
		retorno = DataHoraRN.getPrimeiroDiaDoMesDaData(calendario.getTime()); 

		return retorno;
	}

	public Date getDataInicioAnoAnterior(){
		GregorianCalendar calendario = new GregorianCalendar();
		
		calendario.setTime(new Date());
		calendario.set(Calendar.YEAR, this.anoInicio - 1);
		calendario.set(Calendar.MONTH, 0);
		calendario.set(Calendar.DAY_OF_MONTH, 1);
//		calendario.set(this.anoInicio - 1, 1, 1);
		
		Date retorno = null;
		
		retorno = DataHoraRN.getPrimeiroDiaDoMesDaData(calendario.getTime()); 

		return retorno;
	}

	public Date getDataFinalAno(){
		GregorianCalendar calendario = new GregorianCalendar();
		
		calendario.setTime(new Date());
		calendario.set(this.anoInicio, 11, 31);
	
		Date retorno = null;
		
		retorno = DataHoraRN.getUltimoDiaDoMesDaData(calendario.getTime());
		
		return retorno;
	}

	public Date getDataFinalAnoAnterior(){
		GregorianCalendar calendario = new GregorianCalendar();
		
		calendario.setTime(new Date());
		calendario.set(this.anoInicio - 1, 11, 31);
	
		Date retorno = null;
		
		retorno = DataHoraRN.getUltimoDiaDoMesDaData(calendario.getTime());
		
		return retorno;
	}
	/**
	 * @return the cdUsuario
	 */
	public String getCdUsuario() {
		return cdUsuario;
	}
	/**
	 * @param cdUsuario the cdUsuario to set
	 */
	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario;
	}
	/**
	 * @return the hrInicio
	 */
	public String getHrInicio() {
		return hrInicio;
	}
	/**
	 * @param hrInicio the hrInicio to set
	 */
	public void setHrInicio(String hrInicio) {
		this.hrInicio = hrInicio;
	}
	/**
	 * @return the hrFim
	 */
	public String getHrFim() {
		return hrFim;
	}
	/**
	 * @param hrFim the hrFim to set
	 */
	public void setHrFim(String hrFim) {
		this.hrFim = hrFim;
	}

	public List<Ijtbgal> getListaDeIjtbgal(DAOGenericoInjet dao){
		List<Ijtbgal> retorno = new ArrayList<Ijtbgal>();
		
		// Verifica se existe algum ou mais de um galpao para ser analisado
		if (this.getGalpoes().size() > 0){
			// Verifica se foi escolhido todos os galpoes. Se sim, obtem uma lista dos galpoes a serem avaliados
			boolean isTodosGalpoes = false;
			for (String cdgalpao : this.getGalpoes()){
				if (cdgalpao.equals("TODOS OS GALPP�ES")){
					isTodosGalpoes = true;
					break;
				}
			}
			GalpaoInjetRN galpaoRN = new GalpaoInjetRN(dao);

			if (isTodosGalpoes == true){
				retorno = galpaoRN.pesquisarIjtbgal(null);
			} else {
				for (String cdgalpao : this.getGalpoes()){
					String codigoGalpao = cdgalpao;
					
					if (cdgalpao.indexOf(" -") > 0)
						codigoGalpao = cdgalpao.substring(0, cdgalpao.indexOf(" -"));
					
					Ijtbgal ijtbgal = null;
					try{
						ijtbgal = galpaoRN.pesquisarIjtbgal(codigoGalpao).get(0);
					} catch(Exception e){}
					if (ijtbgal != null)
						retorno.add(ijtbgal);
				}
			}
		}
		return retorno;
	}
}
