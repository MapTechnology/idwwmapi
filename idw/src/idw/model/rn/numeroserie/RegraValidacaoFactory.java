package idw.model.rn.numeroserie;

import java.util.HashMap;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.pojos.DwFolha;
import idw.model.pojos.DwFolhamoncomp;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.webservices.dto.ResultadoDTO;

public class RegraValidacaoFactory {

	private Map<Integer, Class<?>> validacoes = new HashMap<>();
	
	private int tipoValidacao;
	private DwFolha dwfolha;
	private DwFolhamoncomp dwfolhamoncomp;
	private String ns;
	private OmPt ompt;
	private PpCp ppcp;
	
	private DAOGenerico dao;
	
	public enum _REGRAS{
		SEM_VALIDACAO(0),
		VALIDA_SENHA_4(1),
		VALIDA_SENHA_SERIAL(2),
		VALIDA_HEXADECIMAL(3),
		VALIDA_PRODUTOOUGRUPO(4),
		VALIDA_SENHA_ALEATORIA(5),
		VALIDA_MASCARA(6);
		
		private final int value;
		private _REGRAS(int value){
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}

	
	public RegraValidacaoFactory(int tipoValidacao, PpCp ppcp, DwFolha dwfolha, DwFolhamoncomp dwfolhamoncomp, String ns, OmPt ompt, DAOGenerico dao) {
		super();
		
		this.tipoValidacao = tipoValidacao;
		
		this.tipoValidacao = tipoValidacao;
		this.dwfolha = dwfolha;
		this.ns = ns;
		this.ompt = ompt;
		this.dao = dao;
		this.dwfolhamoncomp = dwfolhamoncomp;
		this.ppcp = ppcp;
		
		
		validacoes.put(_REGRAS.SEM_VALIDACAO.getValue(), RegraValidacaoSemValidacao.class);
		validacoes.put(_REGRAS.VALIDA_SENHA_4.getValue(), RegraValidacaoSenha4Digitos.class);
		validacoes.put(_REGRAS.VALIDA_SENHA_SERIAL.getValue(), RegraValidacaoSenhaSerial.class);
		validacoes.put(_REGRAS.VALIDA_PRODUTOOUGRUPO.getValue(), RegraValidacaoProdutoOuGrupo.class);
		validacoes.put(_REGRAS.VALIDA_HEXADECIMAL.getValue(), RegraValidacaoHexadecimal.class);
		validacoes.put(_REGRAS.VALIDA_SENHA_ALEATORIA.getValue(), RegraValidacaoSemValidacao.class);
		validacoes.put(_REGRAS.VALIDA_MASCARA.getValue(), RegraValidacaoMascara.class);
		
	}
	
	public ResultadoDTO isPassouNaRegra() {
		ResultadoDTO retorno ;
		try {
			IRegraValidacao regra = (IRegraValidacao) validacoes.get(this.tipoValidacao).newInstance();
			retorno = regra.isPassouNoTeste(ppcp, dwfolha, dwfolhamoncomp, ns, ompt, dao);
		} catch (InstantiationException | IllegalAccessException e) {
			retorno = new ResultadoDTO();
			retorno.setIdmensagem(retorno.ERRO_DESCONHECIDO);
		}
		
		return retorno;
	}
}
