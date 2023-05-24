package idw.webservices.dto;

import java.util.List;

public class MapaCPDTO 
{
	private static final Byte ID_LISTA_CPS_TODAS = 1;
	private static final Byte ID_LISTA_CPS_INICIADAS = 2;
	private static final Byte ID_LISTA_CPS_NAO_INICIADAS = 3;
	private static final Byte ID_LISTA_CPS_EM_PRODUCAO = 4;
	private static final Byte ID_LISTA_CPS_PRODUCAO_ENCERRADA = 5;
	private static final Byte ID_LISTA_CPS_EM_PRODUCAO_NO_PRAZO = 6;
	private static final Byte ID_LISTA_CPS_EM_PRODUCAO_FORA_DO_PRAZO = 7;
	
	private Byte idListaCPs;
	private List<MapaCPDetDTO> listaCPs;
	private MapaCPDetDTO resumo;
		
	public Byte getIdListaCPs() {
		return idListaCPs;
	}
	public void setIdListaCPs(Byte idListaCPs) {
		this.idListaCPs = idListaCPs;
	}
	public List<MapaCPDetDTO> getListaCPs() {
		return listaCPs;
	}
	public void setListaCPs(List<MapaCPDetDTO> listaCPs) {
		this.listaCPs = listaCPs;
	}
	public static Byte getIdListaCpsTodas() {
		return ID_LISTA_CPS_TODAS;
	}
	public static Byte getIdListaCpsIniciadas() {
		return ID_LISTA_CPS_INICIADAS;
	}
	public static Byte getIdListaCpsNaoIniciadas() {
		return ID_LISTA_CPS_NAO_INICIADAS;
	}
	public static Byte getIdListaCpsEmProducao() {
		return ID_LISTA_CPS_EM_PRODUCAO;
	}
	public static Byte getIdListaCpsProducaoEncerrada() {
		return ID_LISTA_CPS_PRODUCAO_ENCERRADA;
	}
	public static Byte getIdListaCpsEmProducaoNoPrazo() {
		return ID_LISTA_CPS_EM_PRODUCAO_NO_PRAZO;
	}
	public static Byte getIdListaCpsEmProducaoForaDoPrazo() {
		return ID_LISTA_CPS_EM_PRODUCAO_FORA_DO_PRAZO;
	}
	public MapaCPDetDTO getResumo() {
		return resumo;
	}
	public void setResumo(MapaCPDetDTO resumo) {
		this.resumo = resumo;
	}
		
}
