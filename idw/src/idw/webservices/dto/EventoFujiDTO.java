package idw.webservices.dto;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import idw.model.pojos.OmPt;
import idw.util.IdwLogger;
import idw.util.Util;

@SuppressWarnings("serial")
public class EventoFujiDTO implements Serializable {
	
	public static final int _EVENTO_INICIO_PARADA = 1;
	public static final int _EVENTO_INICIO_CICLO = 2;
	public static final int _EVENTO_FIM_CICLO = 3;
	public static final int _EVENTO_FIM_PARADA = 4;
	
	public static final int _EVENTO_INICIO_PARADA_TDBA = 1;
	public static final int _EVENTO_INICIO_CICLO_TDBA = 2;
	public static final int _EVENTO_FIM_CICLO_TDBA =3;
	public static final int _EVENTO_FIM_PARADA_TDBA = 4;
	public static final int _EVENTO_ERRO_TDBA = 5;
	
	private String linha;
	private String maquina;
	private String evento;
	private String data;
	private String complemento;
	
    private IdwLogger log;
    private int idLog;
    private int identacao;

    private String programa;
    private String produto;
    
    /**
     * Mascaras
     */
    private String mascaraPrograma = "??????";
    private String mascaraProduto = "??????";
    @SuppressWarnings("unused")
	private String mascaraComponente = "??????";
    
    private OmPt ompt;
	
	public EventoFujiDTO(){
		
	}
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public String getData() {
		String dtRetorno = data;
		if (this.data.length() == 16){
			Pattern pattern = Pattern.compile("([0-9]{4})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(this.data);
			if(matcher.find()){
				dtRetorno = matcher.group(1)+"-"+matcher.group(2)+"-"+matcher.group(3)+" "+matcher.group(4)+":" + matcher.group(5)+":"+matcher.group(6);
			}
			
			
		}
		
		return dtRetorno;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	
	public String getCt(){
		return  getLinha() + "|" + getMaquina();
	}
	
	public void defineLog(IdwLogger log, int idLog, int identacao){
		this.log = log;
		this.idLog = idLog;
		this.identacao = identacao;
	}
	
	public OmPt getOmpt() {
		return ompt;
	}

	public void setOmpt(OmPt ompt) {
		this.ompt = ompt;
	}

	public IdwLogger getLog() {
		return log;
	}

	public int getIdLog() {
		return idLog;
	}

	public int getIdentacao() {
		return identacao;
	}
	
	public String getPrograma() {
		return Util.extraiPorMascara(programa, mascaraPrograma);
	}
	
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	
	public String getProduto() {
		return Util.extraiPorMascara(produto, mascaraProduto);
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	
	public boolean isErro(){
		boolean retorno = false;
		return retorno;
	}
	
	public boolean isInicioParada(){
		boolean retorno = false;
		if (this.evento == "PRODSTART"){
			retorno = true;
		}
		return retorno;
		
	}
	
	public boolean isInicioCiclo(){
		boolean retorno = true;
		
		
		return retorno;
	}
	
	public int getTipoEventoTdba(){
		int retorno = 0;
		if(this.getEvento().equals("PRODSTART")){
			retorno = _EVENTO_INICIO_CICLO_TDBA;
		}else if(this.getEvento().equals("PRODEND")){
			retorno = _EVENTO_FIM_CICLO_TDBA;
		}else if(this.getEvento().equals("PDERROR")){
			retorno = _EVENTO_ERRO_TDBA;
		}
		
		return retorno;
	}
	
	public String getCodError(){
		String retorno = "";
		Pattern pattern = Pattern.compile("", Pattern.CASE_INSENSITIVE);
		@SuppressWarnings("unused")
		Matcher matcher = pattern.matcher(this.complemento);
		return retorno;
				
	}
	
	
	public String getProgramaComplemento(){
		String retorno  ="";
		Pattern pattern = Pattern.compile("([0-9]*)(\t)([a-z0-9]+)(\t)([0-9]+)(\t)([a-z0-9\\_\\- ]+)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(this.complemento);
		if(matcher.find()){
			
			retorno = matcher.group(7);
		}
		
		return retorno;
	}
	
	public int getTipoEventoIdw(){
		return 0;
	}
	public boolean isEventoValido(){
		//TODO
		
		
		return true;
	}
	public String getComponente() {
		// TODO Auto-generated method stub
		String retorno = "";
		Pattern pattern = Pattern.compile("([0-9]+)(:)([0-9]+)(\t)([a-z0-9]+)(\t)([a-z0-9_]+)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)*)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(this.complemento);
		if(matcher.find()){
			//System.out.println("getComponente: "+ matcher.groupCount());
			for(int i = 0; i <= matcher.groupCount(); i++){
				//System.out.println("posicao ["+ i +"] - " + matcher.group(i) );
			}
			retorno = matcher.group(7);
		}
		return retorno;
	}
	public String getFeeder() {
		// TODO Auto-generated method stub
		String retorno = "";
		Pattern pattern = Pattern.compile("([0-9]+)(:)([0-9]+)(\t)([a-z0-9]+)(\t)([a-z0-9_]+)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(this.complemento);
		if(matcher.find()){
			
			retorno = matcher.group(7);
		}
		return retorno;
	}
	public String getCdPerda() {
		// TODO Auto-generated method stub
		String retorno = "";
	
		Pattern pattern = Pattern.compile("([0-9]+)(:)([0-9]+)(\t)([a-z0-9]+)(\t)([a-z0-9_]+)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)(\t)([0-9a-z ]*)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(this.complemento);
		if(matcher.find()){
			
			retorno = matcher.group(7);
		}
		return retorno;
		
	}
}
