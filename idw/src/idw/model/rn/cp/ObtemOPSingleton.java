package idw.model.rn.cp;

import java.util.HashMap;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.OmPtTemplate;
import ms.model.dto.EventoColetado;
import ms.util.ConversaoTipos;

public class ObtemOPSingleton {
	
	@SuppressWarnings("rawtypes")
	private Map<Byte, Class> tipoSessoes = new HashMap<>();
	
	private static ObtemOPSingleton instancia = null;
	
	private ObtemOPSingleton() {
		super();
		tipoSessoes.put(OmPtTemplate.TipoSessao.TP_RECUPERA_OP_NUMERO.getValue(), ObtemOP_tpNumeroOP.class);
		tipoSessoes.put(OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue(), ObtemOP_tpFerramenta.class);
		tipoSessoes.put(OmPtTemplate.TipoSessao.TP_RECUPERA_OP_PRODUTO.getValue(), ObtemOP_tpProduto.class);
		tipoSessoes.put(OmPtTemplate.TipoSessao.TP_CRIA_OP_PRODUTO.getValue(), CriarOP_tpProdutoProducaoPlanejada.class);
		tipoSessoes.put(OmPtTemplate.TipoSessao.TP_CRIA_OP_PRODUTO_ESTRUTURA.getValue(), CriarOP_tpProdutoEstrutura.class);
		tipoSessoes.put(OmPtTemplate.TipoSessao.TP_CRIA_OP_FERRAMENTA_QTCICLOS.getValue(), CriarOP_tpFerramentaQtdeCiclos.class);
		tipoSessoes.put(OmPtTemplate.TipoSessao.TP_CRIA_OP_FOLHA.getValue(), CriarOP_tpFolha.class);
		tipoSessoes.put(OmPtTemplate.TipoSessao.TP_CRIA_OP_FERRAMENTA_PRODUTO_QTCICLOS.getValue(), CriarOP_tpFerramentaProdutoQtdeCiclos.class);
	}
	
	/* Define o tipo da sessao para o inova
	 * Abaixo os tipos de sessao atualmente disponiveis no Injet
	 * 
	 * Tipos de sessao que procuram uma OP que ja existe

		1 - Pede Molde
		2 - Pede OP
		3 - Produto

					Abaixo tipos de sessao que foram desabilitados para o IDW pois sao especificas de integracoes
						6 - Produto (desabilitar)
						9 - Molde produto e qtde de cartoes (desabilitado)
						11 - OP (desabilitado)
						12 - OP, Molde e estrutura (desabilitad) Arthi
						13 - OP Molde Estrutura Producao Planejada (desabilitado) Fitesa


		Ops criadas no servidor
		
		Ferramenta e producao planejada
		Produto e producao planejada
		4 - Molde e estrutura qtde ciclo (falta)
		5 - Produto estrutura e producao planejada  (contemplada)
		7 - Produto producao planjeada (contemplado)
		8 - Molde produto e qtde ciclos (falta)
		
		
					Tipo de sesssao desabilitadas criados no servidor
					
					10 - OP producao planejada (desabilitado)


	 */
	public static ObtemOPSingleton getInstancia() {
		if (instancia == null)
			instancia = new ObtemOPSingleton();
		
		return instancia;
	}
	
	public PpCp obtem(EventoColetado evento, DAOGenerico dao) {
		IObtemOP obtem;
		try {
			obtem = (IObtemOP) tipoSessoes.get(ConversaoTipos.converterParaByte(evento.getTpSessao().trim())).newInstance();
		} catch (InstantiationException | IllegalAccessException | NullPointerException e) {
			e.printStackTrace();
			return null;
		}
		return obtem.obtem(evento, dao);
	}
	
}
