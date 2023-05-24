package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.MsMsicup;
import idw.model.pojos.OmCfg;
import idw.util.IdwLogger;

import org.hibernate.Session;

public abstract class TransferirParaInovaSAFactory {
	
	public enum TpArquivo{
		_SESSAO((byte)0),
		_OPERADORES((byte)1),
		_OPS((byte)2),
		_ALERTA((byte)3),
		_REFUGO((byte)4),
		_PARADA((byte)5),
		_CAUSA((byte)6),
		_ACAO((byte)7),
		_ANDON((byte)8),
		_JUSTIFICATIVA((byte)9),
		_FOLHA((byte)10);

		private final byte value;
		
		private TpArquivo(byte value){
			this.value = value;
		}
		public byte getValue(){
			return this.value;
		}

	}

	public abstract void criarArquivo(); 
	public abstract void criarArquivoStatus();
	
	private OmCfg omcfg = null;
	private String diretorioDestino = null;
	protected IdwLogger log = null;
	protected Session session = null;
	protected MsMsicup msmsicup = null;

	public static TransferirParaInovaSAFactory getInstancia(int tipoArquivo, MsMsicup msmsicup, OmCfg omcfg, String diretorioDestino, IdwLogger log, Session session) {
		TransferirParaInovaSAFactory retorno = null;

		if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._SESSAO.getValue()) // sessao
			retorno = new TransferirParaInovaSASessoes();
		else if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._OPERADORES.getValue()) // usuarios
			retorno = new TransferirParaInovaSAUsuario();
		else if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._OPS.getValue()) // ops
			retorno = new TransferirParaInovaSAOps();
		else if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._ALERTA.getValue()) // alertas
			retorno = new TransferirParaInovaSAAlertas();
		else if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._REFUGO.getValue()) // refugos
			retorno = new TransferirParaInovaSARefugos();
		else if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._PARADA.getValue()) //paradas
			retorno = new TransferirParaInovaSAParadas();
		else if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._CAUSA.getValue()) //causas
			retorno = new TransferirParaInovaSACausas();
		else if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._ACAO.getValue()) //acoes
			retorno = new TransferirParaInovaSAAcoes();
		else if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._ANDON.getValue()) //andon
			retorno = new TransferirParaInovaSAAndon();
		else if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._JUSTIFICATIVA.getValue()) //justificativas
			retorno = new TransferirParaInovaSAJustificativas();
		else if (tipoArquivo == TransferirParaInovaSAFactory.TpArquivo._FOLHA.getValue()) //justificativas
			retorno = new TransferirParaInovaSAFolhas(); 
		
		retorno.setOmCfg(omcfg);
		retorno.setDiretorioDestino(diretorioDestino);
		retorno.setLog(log);
		retorno.setSession(session);
		retorno.setMsmsicup(msmsicup);
		
		return retorno;
	}
	
	public MsMsicup getMsmsicup() {
		return msmsicup;
	}

	public void setMsmsicup(MsMsicup msms) {
		this.msmsicup = msms;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	protected void setOmCfg(OmCfg omcfg) {
		this.omcfg = omcfg;
	}
	protected OmCfg getOmCfg() {
		return this.omcfg;
	}
	protected void setDiretorioDestino(String diretorioDestino) {
		this.diretorioDestino = diretorioDestino;
	}
	protected String getDiretorioDestino() {
		return this.diretorioDestino;
	}
	protected void setLog(IdwLogger log) {
		this.log = log;
	}
}
