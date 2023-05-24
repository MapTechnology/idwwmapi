package idw.model.rn.monitorizacao.web.imagem;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import idw.util.Cor;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.rest.dto.monitorizacao.PtIconeDTO;

public class MonitorizacaoIconeForno implements MonitorizacaoIcone {
	
	public static final String SUFIXO_CAMINHO_ZONA_IDEAL = "_ZonaIdeal";
	public static final String SUFIXO_CAMINHO_ZONA_ACEITAVEL_SUPERIOR = "_ZonaActSup";
	public static final String SUFIXO_CAMINHO_ZONA_ACEITAVEL_INFERIOR = "_ZonaActInf";
	public static final String SUFIXO_CAMINHO_ZONA_CRITICA_SUPERIOR = "_ZonaCritSup";
	public static final String SUFIXO_CAMINHO_ZONA_CRITICA_INFERIOR = "_ZonaCritInf";
	
	public static final List<String> postosComSufixo = Arrays.asList(
			"Termometro_32x32",
			"Termometro_48x48",
			"TermometroA_128x128",
			"TermometroB_128x128",
			"Multimetro_128x128");

	@Override
	public PtIconeDTO getIcone(ObjRtMonitorizacaoDTO obj) {
		PtIconeDTO iconeDTO = new PtIconeDTO();
		iconeDTO.setCaminhoIcone(getCaminhoImagem(obj));
		iconeDTO.setListaIconesAdicionais(new ArrayList<String>());
		iconeDTO.setCorTriangulo(Cor.transformarParaCodigoHexadecimal(Color.WHITE));
		iconeDTO.setCorBorda(Cor.transformarParaCodigoHexadecimal(Color.WHITE));
		return iconeDTO;
	}
	
	// Fonte Netbeans: PImagePTForno.getImageInjetByType()
	private String getCaminhoImagem(ObjRtMonitorizacaoDTO obj) {
		if(obj.getUrlImg() == null || obj.getUrlImg().equals("")) {
			return CAMINHO_POSTO_VAZIO;
		}
		
		String caminho = obj.getUrlImg();
		String prefixo = caminho.substring(0, caminho.length() - 4);
		String extensao = caminho.substring(caminho.length() - 4, caminho.length());
		
		if(isPostoPossuiSufixo(caminho) == false) {
			return caminho;
		}
		
		if(obj.isOffline()) {
			return caminho;
		}
		
		if (obj.isTemperaturaZonaCritInf()) {
			return prefixo + SUFIXO_CAMINHO_ZONA_CRITICA_INFERIOR + extensao;
        }

        if (obj.isTemperaturaZonaActInf()) {
        	return prefixo + SUFIXO_CAMINHO_ZONA_ACEITAVEL_INFERIOR + extensao;
        }

        if (obj.isTemperaturaZonaIdeal()) {
        	return prefixo + SUFIXO_CAMINHO_ZONA_IDEAL + extensao;
        }

        if (obj.isTemperaturaZonaActSup()) {
        	return prefixo + SUFIXO_CAMINHO_ZONA_ACEITAVEL_SUPERIOR + extensao;
        } else {
        	return prefixo + SUFIXO_CAMINHO_ZONA_CRITICA_SUPERIOR + extensao;
        }
	}
	
	private boolean isPostoPossuiSufixo(String caminho) {
		for(String posto : MonitorizacaoIconeForno.postosComSufixo) {
			if(caminho.toLowerCase().contains(posto.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

}
