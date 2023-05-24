package idw.model.rn.integracao;

import java.util.HashMap;
import java.util.Map;

import idw.model.pojos.OmJob;
import idw.model.pojos.template.OmJobTemplate;
import idw.model.rn.integracao.arquivotexto.IntegracaoArquivoTextoRN;
import idw.model.rn.integracao.flex.IntegracaoERPFlex;
import idw.model.rn.integracao.manutencao.IntegracaoModuloManutencao;
import idw.model.rn.integracao.tdba.IntegracaoTDBARN;

public class IntegracaoBackgroundFactory {
	
	private static IntegracaoBackgroundFactory instancia = null;

	private Map<Integer, Class<? extends AIntegracaoBackground>> integracoesDisponiveis = new HashMap<>();
	
	private IntegracaoBackgroundFactory() {
		super();
		
		integracoesDisponiveis.put(OmJobTemplate._TpIntegracao.TDBA.getValue(), IntegracaoTDBARN.class);
		integracoesDisponiveis.put(OmJobTemplate._TpIntegracao.ARQUIVOTEXTO.getValue(), IntegracaoArquivoTextoRN.class);
		integracoesDisponiveis.put(OmJobTemplate._TpIntegracao.ERP_FLEX.getValue(), IntegracaoERPFlex.class);
		integracoesDisponiveis.put(OmJobTemplate._TpIntegracao.MANUTENCAO.getValue(), IntegracaoModuloManutencao.class);
	}
	
	public static AIntegracaoBackground getIntegracao(OmJob omjob) {
		if (instancia == null) {
			instancia = new IntegracaoBackgroundFactory();
		}
		AIntegracaoBackground retorno = null;
		try {
			retorno = instancia.integracoesDisponiveis.get(omjob.getTpIntegracao()).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retorno.setOmjob(omjob);
		
		return retorno;
	}
}
