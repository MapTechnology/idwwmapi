package idw.model.pojos.injet;

import idw.model.pojos.template.OmPtTemplate;

public abstract class IjtbinjTemplate {
	public abstract Character getTpabertsessaoprod();
	public abstract void setTpabertsessaoprod(Character tpabertsessaoprod);

	
	public enum TiposColeta {
		COLETA_AUTOMATICA(0),
		COLETA_DISCRETA(1);
		
		private int tpColeta;
		
		private TiposColeta(int tpColeta) {
			this.tpColeta = tpColeta;
		}
		
		public int getTpColeta() {
			return this.tpColeta;
		}
	}
	
	public enum TpSessao {
		SESSAO_PRODUCAO_MOLDE(1, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()),
		SESSAO_PRODUCAO_ORDEM_PRODUCAO(2, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_NUMERO.getValue()),
		SESSAO_PRODUCAO_PRODUTO(3, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_PRODUTO.getValue()),
		SESSAO_PRODUCAO_MOLDE_OP(4, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()),
		SESSAO_PRODUCAO_PRODUTO_ESTRUTURA_OP(5, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()),
		SESSAO_PRODUCAO_PRODUTO_OP_MONTAGEM(6, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()),
		SESSAO_PRODUCAO_PRODUTO_OP(7, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()),
		SESSAO_PRODUCAO_MOLDE_PRODUTO(8, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()),
		SESSAO_PRODUCAO_FILA_KANBAN_OP(9, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()),
		SESSAO_PRODUCAO_CDM(10, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()),
		SESSAO_PRODUCAO_OP_FIM_AUTO(11, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()),
		SESSAO_PRODUCAO_OP_INT_ARTHI(12, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue()),
		SESSAO_PRODUCAO_OP_FITESA_QTD_INC(13, OmPtTemplate.TipoSessao.TP_RECUPERA_OP_FERRAMENTA.getValue());
		
		private int tpInjet;
		private byte tpIdw;
		
		private TpSessao(int tpInjet, byte tpIdw) {
			this.tpInjet = tpInjet;
			this.tpIdw = tpIdw;
		}
		public int getTpSessaoInjet() {
			return this.tpInjet;
		}
		public byte getTpSessaoIdw() {
			return this.tpIdw;
		}
	}

	private int tpLicenca; // 0 - coleta automatica, 1 - coleta discreta
	
	public int obtemTpLicenca() {
		return this.tpLicenca;
	}
	
	public void mudaTpLicenca(int tpLicenca) {
		this.tpLicenca = tpLicenca;
	}
	
	
	public Byte obtemTpSessaoPadraoIDW() {
		Byte retorno = null;
		Character entrada = getTpabertsessaoprod();
		int entradaInt = Character.getNumericValue(entrada);
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_MOLDE.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_MOLDE.getTpSessaoIdw();
		}
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_ORDEM_PRODUCAO.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_ORDEM_PRODUCAO.getTpSessaoIdw();
		}
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_PRODUTO.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_PRODUTO.getTpSessaoIdw();
		}
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_PRODUTO_ESTRUTURA_OP.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_PRODUTO_ESTRUTURA_OP.getTpSessaoIdw();
		}
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_PRODUTO_OP_MONTAGEM.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_PRODUTO_OP_MONTAGEM.getTpSessaoIdw();
		}
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_PRODUTO_OP.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_PRODUTO_OP.getTpSessaoIdw();
		}
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_FILA_KANBAN_OP.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_FILA_KANBAN_OP.getTpSessaoIdw();
		}
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_CDM.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_CDM.getTpSessaoIdw();
		}
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_OP_FIM_AUTO.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_OP_FIM_AUTO.getTpSessaoIdw();
		}
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_OP_INT_ARTHI.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_OP_INT_ARTHI.getTpSessaoIdw();
		}
		if  (entradaInt  == TpSessao.SESSAO_PRODUCAO_OP_FITESA_QTD_INC.getTpSessaoInjet()) {
			retorno = TpSessao.SESSAO_PRODUCAO_OP_FITESA_QTD_INC.getTpSessaoIdw();
		}
		return retorno;
	}
}
