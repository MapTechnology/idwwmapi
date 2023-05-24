package idw.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MaquinaDTO implements Serializable{

	public static int FRENTE_NAMETA = 0; 
	public static int FRENTE_SEMCONEXAO = 1;
	public static int FRENTE_PARADA = 2;
	public static int FRENTE_FORAMETA = 3;

	public static String DS_FRENTE_NAMETA = "NAMETA"; 
	public static String DS_FRENTE_SEMCONEXAO = "SEMCONEXAO";
	public static String DS_FRENTE_PARADA = "PARADA";
	public static String DS_FRENTE_FORAMETA = "FORAMETA";
	public static String DS_FRENTE_TODAS = "TODAS";

	public static int FUNDO_PARADASEMPESO = 4;
	public static int FUNDO_AGUARDANDOMOLDE = 5;
	public static int FUNDO_PARADANAOINFORMADA = 6;
	public static int FUNDO_OPCONCLUIDA = 7;
	public static int FUNDO_IRMAIOR = 8;
	public static int FUNDO_ALERTA = 9;
	public static int FUNDO_ALERTAINSPECAO = 10;
	public static int FUNDO_OPA90 = 11;
	public static int FUNDO_VAZIO = 12;

	public static String DS_FUNDO_PARADASEMPESO = "PARADASEMPESO";
	public static String DS_FUNDO_AGUARDANDOMOLDE = "AGUARDANDOMOLDE";
	public static String DS_FUNDO_PARADANAOINFORMADA = "PARADANAOINFORMADA";
	public static String DS_FUNDO_OPCONCLUIDA = "OPCONCLUIDA";
	public static String DS_FUNDO_IRMAIOR = "IRMAIOR";
	public static String DS_FUNDO_ALERTA = "ALERTA";
	public static String DS_FUNDO_ALERTAINSPECAO = "ALERTAINSPECAO";
	public static String DS_FUNDO_OPA90 = "OPA90";
	public static String DS_FUNDO_VAZIO = "VAZIO";
	public static String DS_FUNDO_TODAS = "TODAS";

	public static String DS_OPERADOR_COM = "COMOPERADOR";
	public static String DS_OPERADOR_SEM = "SEMOPERADOR";
	public static String DS_OPERADOR_TODOS = "TODOSOPERADORES";

//	private String cdMaquina;
//	private String dsMaquina;
//	private String nrop;
	
//	private int corFrente;
//	private int corFundo;
	
	private List<SerieParettoDTO> parettos = new ArrayList<SerieParettoDTO>();
	
//	private String cdLingua;
//	private BigDecimal eo_padrao;
//	private BigDecimal ec_padrao;
//	private BigDecimal ir_padrao;
//	private Date dthrITurno;
//	private Date dthrFTurno;
		
	public List<SerieParettoDTO> getParettos() {
		return parettos;
	}

	public void setParettos(List<SerieParettoDTO> parettos) {
		this.parettos = parettos;
	}
}
