package idw.model.rn.monitorizacao.web.imagem;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import idw.util.Cor;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.PtIconeDTO;

public class MonitorizacaoIconeDefault implements MonitorizacaoIcone {
	
	public static final String SUFIXO_CAMINHO_IMAGEM_PARADA = "_Parada";
	public static final String SUFIXO_CAMINHO_IMAGEM_DENTRO_DA_META = "_NaMeta";
	public static final String SUFIXO_CAMINHO_IMAGEM_ABAIXO_DA_META = "_AbaixoMeta";
	
	public static final String CAMINHO_IMAGEM_OPERADOR = "om/img/monitorizacao/adicionais/Operador_48x48.gif";
	public static final String CAMINHO_IMAGEM_PARADA_MANUTENCAO = "om/img/monitorizacao/adicionais/ParadaManutencao_48x48.gif";
	public static final String CAMINHO_IMAGEM_PERDA_SINCRONISMO = "om/img/monitorizacao/adicionais/PerdaSincronismo_48x48.gif";
	public static final String CAMINHO_IMAGEM_MANUTENCAO_PREVENTIVA = "om/img/monitorizacao/adicionais/Manutencao_48x48.gif";
	public static final String CAMINHO_IMAGEM_ALERTA_VIDA_UTIL = "om/img/monitorizacao/adicionais/Manutencao_Vida_Util_Molde_48x48.gif";
	public static final String CAMINHO_IMAGEM_CONSOLIDANDO = "om/img/monitorizacao/adicionais/Consolidando_48x48.gif";
	
	public static final Color COR_SEM_MOLDE = Color.BLUE;
	public static final Color COR_OP_CONCLUIDA = Color.CYAN;
	public static final Color COR_OP_CONCLUIDA_90_PORCENTO = new Color(0x0404B4);
	public static final Color COR_ALERTAS = Color.ORANGE;
	public static final Color COR_INDICE_REFUGO = Color.GRAY;
	public static final Color COR_PARADA_NAO_INFORMADA = Color.BLACK;
	public static final Color COR_PARADA_SEM_PESO_EFICIENCIA = Color.MAGENTA;
	public static final Color COR_CIP = new Color(190, 255, 189);	
	public static final Color COR_OFFLINE = Color.WHITE;
	
	public static final Color COR_BORDA_PADRAO = Color.WHITE;
	public static final Color COR_BORDA_SAIDA_DA_CELULA = Color.RED;
	public static final Color COR_BORDA_GARGALO_TEORICO = Color.BLUE;
	public static final Color COR_BORDA_GARGALO_DINAMICO = Color.ORANGE;
	public static final Color COR_BORDA_PARADA = Color.BLACK;	
	
	@Override
	public PtIconeDTO getIcone(ObjRtMonitorizacaoDTO obj) {

		/*
		int i=0;
		if(obj.getCdPt().equals("INJ_off_5526")){
			i=1;
		}
		*/
				
		
		PtIconeDTO iconeDTO = new PtIconeDTO();
		iconeDTO.setCaminhoIcone(getCaminhoImagem(obj));
		iconeDTO.setListaIconesAdicionais(getCaminhoIconesAdicionais(obj));
		iconeDTO.setCorTriangulo(getCorFundo(obj));
		iconeDTO.setCorBorda(getCorBorda(obj));
		return iconeDTO;
	}
	
	private String getCaminhoImagem(ObjRtMonitorizacaoDTO obj) {
		if(obj.getUrlImg() == null || obj.getUrlImg().equals("")) {
			return CAMINHO_POSTO_VAZIO;
		}
		
		String caminho = obj.getUrlImg();
		String prefixo = caminho.substring(0, caminho.length() - 4);
		String extensao = caminho.substring(caminho.length() - 4, caminho.length());
		
		if(obj.isOffline()) {
			return caminho;
		}
		
		if(obj.isParada() || obj.isTemPlanejamento() == false) {
			return prefixo + SUFIXO_CAMINHO_IMAGEM_PARADA + extensao;
		}
		
		if(obj.isDentroDaMeta()) {
			return prefixo + SUFIXO_CAMINHO_IMAGEM_DENTRO_DA_META + extensao;
		} else {
			return prefixo + SUFIXO_CAMINHO_IMAGEM_ABAIXO_DA_META + extensao;
		}
	}
	
	private List<String> getCaminhoIconesAdicionais(ObjRtMonitorizacaoDTO obj) {
		List<String> iconesAdicionais = new ArrayList<String>();
		
		if (obj.isOffline() == false && obj.isTemPlanejamento()) {
			
			if (obj.isTemOperador()) {
            	iconesAdicionais.add(CAMINHO_IMAGEM_OPERADOR);
            }
			
			if (obj.isParadaManutencao()) {
				iconesAdicionais.add(CAMINHO_IMAGEM_PARADA_MANUTENCAO);
            }
			
			if (obj.isPerdaSincronismo()) {
				iconesAdicionais.add(CAMINHO_IMAGEM_PERDA_SINCRONISMO);
            }
            
			if (obj.isConsolidacaoPendente()) {
				iconesAdicionais.add(CAMINHO_IMAGEM_CONSOLIDANDO);
            }
			
            if (obj.isAlertaVidaUtil()) {
            	iconesAdicionais.add(CAMINHO_IMAGEM_ALERTA_VIDA_UTIL);
            }
            
            if (obj.isManutencaoPrev()) {
            	iconesAdicionais.add(CAMINHO_IMAGEM_MANUTENCAO_PREVENTIVA);
            }
        }
		return iconesAdicionais;
	}
	
	private String getCorFundo(ObjRtMonitorizacaoDTO obj) {

		
		/*
		int i=0;
		if(obj.getCdPt().equals("INJ_off_5526")){
			i=1;
		}		
		*/
		
		
		Color cor = COR_OFFLINE;
		if (obj.isOffline() == false) {
			// Os ifs mais acima sao menos prioritarios, ou seja se o ultimo if for true entao ele sera usado
            if (obj.isOpConcluida90PorCento()) {
            	cor = COR_OP_CONCLUIDA_90_PORCENTO;
            }
            if (obj.isOpConcluida()) {
            	cor = COR_OP_CONCLUIDA;
            }
            if (obj.isComAlerta()) {
            	cor = COR_ALERTAS;
            }
            if (obj.isIndiceRefugo3porCento()) {
            	cor = COR_INDICE_REFUGO;
            }
            if (obj.isParada() && obj.isParadaSemPesoEfic()) {
            	cor = COR_PARADA_SEM_PESO_EFICIENCIA;
            }
            if (obj.isParadaNaoInformada()) {
            	cor = COR_PARADA_NAO_INFORMADA;
            }
            if (obj.isCIP()) {
                if (obj.isCIPExtrapolado()) {
                	cor = COR_ALERTAS;
                } else {
                	cor = COR_CIP;
                }
            }
            if (obj.isTemPlanejamento() == false) {
            	cor = COR_SEM_MOLDE;
            }
		}
		return Cor.transformarParaCodigoHexadecimal(cor);
	}
	
	private String getCorBorda(ObjRtMonitorizacaoDTO obj) {
		
		/*
		int i=0;
		if(obj.getCdPt().equals("INJ_off_5526")){
			i=1;
		}
		*/
		
		Color cor = COR_BORDA_PADRAO;
		if (obj.isOffline() == false && obj.isTemPlanejamento()) {
            if (obj.isSaidaDaCelula()) {
            	cor = COR_BORDA_SAIDA_DA_CELULA;
            }
            if (obj.isGargaloTeorico()) {
            	cor = COR_BORDA_GARGALO_TEORICO;
            }
            if (obj.isGargaloDinamico()) {
            	cor = COR_BORDA_GARGALO_DINAMICO;
            }
            if (obj.isParada() && obj.isParadaSemPesoEfic() == false) {
            	cor = COR_BORDA_PARADA;
            }
        }
		return Cor.transformarParaCodigoHexadecimal(cor);
	}

}
