package idw.webservices.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import idw.model.pojos.OmGt;

@XmlRootElement
@SuppressWarnings("serial")
public class GtDTO implements Serializable {
	
	public final static int TESTE = 1;
	private int EVENTO_BEM_SUCEDIDO = 0;
	private int ERRO_GT_JA_EXISTE = 1;
	private int ERRO_IMG_DESCONHECIDO = 2;
	private int ERRO_CC_DESCONHECIDO = 3;
	private int ERRO_USUARIO_REVISAO_DESCONHECIDO = 4;
	private int ERRO_USUARIO_STATUS_DESCONHECIDO = 5;
	private int ERRO_DESCONHECIDO = 6;
	private int ERRO_CDGT_INVALIDO = 7;
	private int ERRO_REATIVACAO_INDISPONIVEL = 8;
	private int ERRO_TIPOGT_DESCONHECIDO = 9;
	private int ERRO_SALVAR_OBJETOS = 10;
	private int ERRO_GT_EM_USO_NA_COFIGURACAO_GERAL = 11;
	@Expose
	private OmGt gt;
	@Expose
	private HomologacoesDTO homologacoes;
    private int resultadoEvento;
    private boolean isConsiderarObjs = true;

    public boolean isConsiderarObjs() {
		return isConsiderarObjs;
	}

	public void setConsiderarObjs(boolean isConsiderarObjs) {
		this.isConsiderarObjs = isConsiderarObjs;
	}

    public OmGt getGt() {
        return gt;
    }

    public void setGt(OmGt gt) {
        this.gt = gt;
    }

    public int getResultadoEvento() {
        return resultadoEvento;
    }

    public void setResultadoEvento(int resultadoEvento) {
        this.resultadoEvento = resultadoEvento;
    }

	public int getEVENTO_BEM_SUCEDIDO() {
		return EVENTO_BEM_SUCEDIDO;
	}

	public int getERRO_GT_JA_EXISTE() {
		return ERRO_GT_JA_EXISTE;
	}
	
	public int getERRO_CC_DESCONHECIDO() {
		return ERRO_CC_DESCONHECIDO;
	}

	public int getERRO_USUARIO_REVISAO_DESCONHECIDO() {
		return ERRO_USUARIO_REVISAO_DESCONHECIDO;
	}

	public int getERRO_USUARIO_STATUS_DESCONHECIDO() {
		return ERRO_USUARIO_STATUS_DESCONHECIDO;
	}

	public int getERRO_DESCONHECIDO() {
		return ERRO_DESCONHECIDO;
	}

	public void setEVENTO_BEM_SUCEDIDO(int evento_bem_sucedido) {
		EVENTO_BEM_SUCEDIDO = evento_bem_sucedido;
	}

	public void setERRO_GT_JA_EXISTE(int erro_gt_ja_existe) {
		ERRO_GT_JA_EXISTE = erro_gt_ja_existe;
	}
	
	public void setERRO_CC_DESCONHECIDO(int erro_cc_desconhecido) {
		ERRO_CC_DESCONHECIDO = erro_cc_desconhecido;
	}

	public void setERRO_USUARIO_REVISAO_DESCONHECIDO(
			int erro_usuario_revisao_desconhecido) {
		ERRO_USUARIO_REVISAO_DESCONHECIDO = erro_usuario_revisao_desconhecido;
	}

	public void setERRO_USUARIO_STATUS_DESCONHECIDO(
			int erro_usuario_status_desconhecido) {
		ERRO_USUARIO_STATUS_DESCONHECIDO = erro_usuario_status_desconhecido;
	}

	public void setERRO_DESCONHECIDO(int erro_desconhecido) {
		ERRO_DESCONHECIDO = erro_desconhecido;
	}

	public int getERRO_IMG_DESCONHECIDO() {
		return ERRO_IMG_DESCONHECIDO;
	}

	public void setERRO_IMG_DESCONHECIDO(int erro_img_desconhecido) {
		ERRO_IMG_DESCONHECIDO = erro_img_desconhecido;
	}

	public int getERRO_CDGT_INVALIDO() {
		return ERRO_CDGT_INVALIDO;
	}

	public void setERRO_CDGT_INVALIDO(int erro_cdgt_invalido) {
		ERRO_CDGT_INVALIDO = erro_cdgt_invalido;
	}

	public int getERRO_REATIVACAO_INDISPONIVEL() {
		return ERRO_REATIVACAO_INDISPONIVEL;
	}

	public void setERRO_REATIVACAO_INDISPONIVEL(int erro_reativacao_indisponivel) {
		ERRO_REATIVACAO_INDISPONIVEL = erro_reativacao_indisponivel;
	}

	public int getERRO_TIPOGT_DESCONHECIDO() {
		return ERRO_TIPOGT_DESCONHECIDO;
	}

	public void setERRO_TIPOGT_DESCONHECIDO(int eRROTIPOGTDESCONHECIDO) {
		ERRO_TIPOGT_DESCONHECIDO = eRROTIPOGTDESCONHECIDO;
	}

	public void setERRO_SALVAR_OBJETOS(int eRROSALVAROBJETOS) {
		ERRO_SALVAR_OBJETOS = eRROSALVAROBJETOS;
	}

	public HomologacoesDTO getHomologacoes() {
		return homologacoes;
	}

	public void setHomologacoes(HomologacoesDTO homologacoes) {
		this.homologacoes = homologacoes;
	}

	public int getERRO_SALVAR_OBJETOS() {
		return ERRO_SALVAR_OBJETOS;
	}

	public int getERRO_GT_EM_USO_NA_COFIGURACAO_GERAL() {
		return ERRO_GT_EM_USO_NA_COFIGURACAO_GERAL;
	}

	public void setERRO_GT_EM_USO_NA_COFIGURACAO_GERAL(
			int eRRO_GT_EM_USO_NA_COFIGURACAO_GERAL) {
		ERRO_GT_EM_USO_NA_COFIGURACAO_GERAL = eRRO_GT_EM_USO_NA_COFIGURACAO_GERAL;
	}

}