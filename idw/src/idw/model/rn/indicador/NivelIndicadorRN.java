package idw.model.rn.indicador;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import idw.util.CompareUtils;
import idw.webservices.dto.IndicadorMinMetaMaxDTO;

/**
 * Tem os ajustes para os limites inferior, superior, meta. E tamb�m se a cor deve ser vermelha, amarela ou verde
 * @author Milton
 * @see IndicadorValorMinMetaMaxDTO
 *
 */
public final class NivelIndicadorRN {
	
	public static void ajustarNivelIndicador(List<IndicadorValorMinMetaMaxDTO> indicadorValorMinMetaMaxDTOs, Boolean aplicarCorParada){
		for(IndicadorValorMinMetaMaxDTO indicadorValorMinMetaMaxDTO: indicadorValorMinMetaMaxDTOs){
			ajustarNivelIndicador(indicadorValorMinMetaMaxDTO, aplicarCorParada);
		}
	}
	
	public static void ajustarNivelIndicador(IndicadorValorMinMetaMaxDTO indicadorValorMinMetaMaxDTO, Boolean aplicarCorParada){
		IndicadorValorDTO indicadorValorDTO = indicadorValorMinMetaMaxDTO.getIndicadorValorDTO();
		IndicadorMinMetaMaxDTO indicadorMinMetaMaxDTO = indicadorValorMinMetaMaxDTO.getIndicadorMinMetaMaxDTO();
		
		if(indicadorValorDTO != null && indicadorMinMetaMaxDTO != null){
			
			BigDecimal valorLimiteInferior =ObjectUtils.defaultIfNull(indicadorMinMetaMaxDTO.getIndInferior(), BigDecimal.ZERO); 
			BigDecimal valorLimiteMeta =ObjectUtils.defaultIfNull(indicadorMinMetaMaxDTO.getIndMeta(), BigDecimal.ZERO);
			BigDecimal valorLimiteSuperior =ObjectUtils.defaultIfNull(indicadorMinMetaMaxDTO.getIndSuperior(), BigDecimal.ZERO);

			// Ajusta n�vel
			indicadorValorMinMetaMaxDTO.setAbaixoMinimo(CompareUtils.compareTo(new BigDecimal(indicadorValorDTO.getValor()), valorLimiteInferior) < 0);
			indicadorValorMinMetaMaxDTO.setAbaixoMeta(CompareUtils.compareTo(new BigDecimal(indicadorValorDTO.getValor()), valorLimiteMeta) < 0);
			indicadorValorMinMetaMaxDTO.setAcimaMeta(CompareUtils.compareTo(new BigDecimal(indicadorValorDTO.getValor()), valorLimiteMeta) > 0);
			indicadorValorMinMetaMaxDTO.setAcimaMaximo(CompareUtils.compareTo(new BigDecimal(indicadorValorDTO.getValor()), valorLimiteSuperior) > 0);

			// Ajustar as cores
            if(indicadorValorMinMetaMaxDTO.getIndicadorValorDTO().getOmInd().isMelhorAcimaMeta()){
            	indicadorValorMinMetaMaxDTO.setCorVermelho(indicadorValorMinMetaMaxDTO.isAbaixoMinimo());
            	indicadorValorMinMetaMaxDTO.setCorAmarelo(indicadorValorMinMetaMaxDTO.isAbaixoMeta() && !indicadorValorMinMetaMaxDTO.isAbaixoMinimo());
            	indicadorValorMinMetaMaxDTO.setCorVerde(indicadorValorMinMetaMaxDTO.isAcimaMeta());
            }else{
            	indicadorValorMinMetaMaxDTO.setCorVermelho(indicadorValorMinMetaMaxDTO.isAcimaMaximo());
            	indicadorValorMinMetaMaxDTO.setCorAmarelo(indicadorValorMinMetaMaxDTO.isAcimaMeta() && !indicadorValorMinMetaMaxDTO.isAcimaMaximo());
            	indicadorValorMinMetaMaxDTO.setCorVerde(indicadorValorMinMetaMaxDTO.isAbaixoMeta());
            }

			indicadorValorMinMetaMaxDTO.setCorPink(false);
			
			if (aplicarCorParada)
			{
				if (indicadorValorMinMetaMaxDTO.isParadaComPeso())
				{
					indicadorValorMinMetaMaxDTO.setCorVermelho(true);
					indicadorValorMinMetaMaxDTO.setCorAmarelo(false);
					indicadorValorMinMetaMaxDTO.setCorVerde(false);
				}
	
				if (indicadorValorMinMetaMaxDTO.isParadaSemPeso())
				{
					indicadorValorMinMetaMaxDTO.setCorVermelho(false);
					indicadorValorMinMetaMaxDTO.setCorAmarelo(false);
					indicadorValorMinMetaMaxDTO.setCorVerde(false);
					indicadorValorMinMetaMaxDTO.setCorPink(true);
				}			
			}
			
		}
		
	}
	
	
	
}
