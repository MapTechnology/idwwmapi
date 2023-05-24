package idw.webservices.dto;

import java.io.Serializable;

import idw.model.pojos.OmMapa;


@SuppressWarnings("serial")
public class MapaAlimentacaoDTO implements Serializable{
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_MAPA_JA_EXISTE = 1;
	private int ERRO_DESCONHECIDO = 2;
	private int ERRO_PROGRAMA_DESCONHECIDO = 3;
	private int ERRO_PRODUTO_DESCONHECIDO = 4;
	private int ERRO_POSTO_DESCONHECIDO = 5;
	private int ERRO_CDMAPAPA_INVALIDO = 6;	
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 7;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 8;
	private int ERRO_REATIVACAO_INDISPONIVEL = 9;
	private int ERRO_SEM_CONFIGURACAO = 10;
	private int ERRO_FOLHA_DESCONHECIDA = 11;
	
	public int getERRO_SEM_CONFIGURACAO() {
		return ERRO_SEM_CONFIGURACAO;
	}
	public void setERRO_SEM_CONFIGURACAO(int eRROSEMCONFIGURACAO) {
		ERRO_SEM_CONFIGURACAO = eRROSEMCONFIGURACAO;
	}
	private OmMapa ommapa;
	private MapaPAsDTO mapaPas;
    private MapaPAsDTO mapaPasParaExclusao;
    private int resultadoEvento;
	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}
	public void setEVENTO_BEM_SUCEDIDO(int evento_bem_sucedido) {
		EVENTO_BEM_SUCEDIDO = evento_bem_sucedido;
	}
	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}
	public void setERRO_DESCONHECIDO(int erro_desconhecido) {
		ERRO_DESCONHECIDO = erro_desconhecido;
	}
	public OmMapa getOmmapa() {
		return ommapa;
	}
	public void setOmmapa(OmMapa ommapa) {
		this.ommapa = ommapa;
	}
	public int getResultadoEvento() {
		return resultadoEvento;
	}
	public void setResultadoEvento(int resultadoEvento) {
		this.resultadoEvento = resultadoEvento;
	}
	public int getERRO_MAPA_JA_EXISTE() {
		return ERRO_MAPA_JA_EXISTE;
	}
	public void setERRO_MAPA_JA_EXISTE(int erro_mapa_ja_existe) {
		ERRO_MAPA_JA_EXISTE = erro_mapa_ja_existe;
	}
	public int getERRO_PROGRAMA_DESCONHECIDO() {
		return ERRO_PROGRAMA_DESCONHECIDO;
	}
	public void setERRO_PROGRAMA_DESCONHECIDO(int erro_programa_desconhecido) {
		ERRO_PROGRAMA_DESCONHECIDO = erro_programa_desconhecido;
	}
	public int getERRO_PRODUTO_DESCONHECIDO() {
		return ERRO_PRODUTO_DESCONHECIDO;
	}
	public void setERRO_PRODUTO_DESCONHECIDO(int erro_produto_desconhecido) {
		ERRO_PRODUTO_DESCONHECIDO = erro_produto_desconhecido;
	}
	public int getERRO_POSTO_DESCONHECIDO() {
		return ERRO_POSTO_DESCONHECIDO;
	}
	public void setERRO_POSTO_DESCONHECIDO(int erro_posto_desconhecido) {
		ERRO_POSTO_DESCONHECIDO = erro_posto_desconhecido;
	}
	public MapaPAsDTO getMapaPas() {
		return mapaPas;
	}
	public void setMapaPas(MapaPAsDTO mapaPas) {
		this.mapaPas = mapaPas;
	}
	public MapaPAsDTO getMapaPasParaExclusao() {
		return mapaPasParaExclusao;
	}
	public void setMapaPasParaExclusao(MapaPAsDTO mapaPasParaExclusao) {
		this.mapaPasParaExclusao = mapaPasParaExclusao;
	}
	public int getERRO_CDMAPAPA_INVALIDO() {
		return ERRO_CDMAPAPA_INVALIDO;
	}
	public void setERRO_CDMAPAPA_INVALIDO(int erro_cdmapapa_invalido) {
		ERRO_CDMAPAPA_INVALIDO = erro_cdmapapa_invalido;
	}
	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}
	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int erro_usuario_revisao_desconhecido) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = erro_usuario_revisao_desconhecido;
	}
	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}
	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int erro_usuario_status_desconhecido) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = erro_usuario_status_desconhecido;
	}
	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}
	public void setERRO_REATIVACAO_INDISPONIVEL(int erro_reativacao_indisponivel) {
		ERRO_REATIVACAO_INDISPONIVEL = erro_reativacao_indisponivel;
	}
	public int getERRO_FOLHA_DESCONHECIDA() {
		return ERRO_FOLHA_DESCONHECIDA;
	}
	public void setERRO_FOLHA_DESCONHECIDA(int eRRO_FOLHA_DESCONHECIDA) {
		ERRO_FOLHA_DESCONHECIDA = eRRO_FOLHA_DESCONHECIDA;
	}
	
}
