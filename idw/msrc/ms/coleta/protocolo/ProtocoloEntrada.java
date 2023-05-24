package ms.coleta.protocolo;

import java.util.Date;

import idw.model.IdwFacade;
import idw.model.rn.DataHoraRN;
import ms.coleta.dto.MensagemRecebida;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

/* Essa classe foi substituida pelo ProtocoloEntradaFactory e ProtocoloEntradaNovo */
@Deprecated
public class ProtocoloEntrada extends ProtocoloEntradaFactory {
	private static String _SOLICITACAO = "ac";
	private static String _SOLICITACAO_REGISTRO = "ac=0#";
	private static String _SOLICITACAO_DESREGISTRO = "ac=1#";
	private static String _ENVIANDO_MOTIVO_REGISTRO = "ac=4#";
	private static String _IDENTIFICACAO_IHM = "ihm=";
	private static String _IDENTIFICACAO_UP = "up=";
	private static String _FINAL_DE_VALOR = "#";
	private static String _PORTA_PARA_ESCUTA = "pt=";
	private static String _CODIGO_PARADA = "cdparada=";
	private static String _CAUSA_PARADA = "cdcausa=";
	private static String _ACAO_PARADA = "cdacao=";
	private static String _JUSTIFICATIVA_PARADA = "cdjustificativa=";
    private static String _TECNICORESP_PARADA = "cdusuarioresp=";
    private static String _TECNICOUM_PARADA = "cdusuarioum=";
    private static String _TECNICODOIS_PARADA = "cdusuariodois=";
    private static String _LOCAL_PARADA = "cdLocalparada=";
    /*strings usadas quando IC e IHM estão integrados*/
    private static String _SINAL_PARADA = "ac=3#";        
    private static String _SINAL_CICLO = "ac=2#";
    private static String _DATAHORA_EVENTO = "dthrevento=";
    private static String _DATAHORA_INICIO_EVENTO = "dthrinicioevento=";

    private final MensagemRecebida mensagem;
    
    public ProtocoloEntrada(MensagemRecebida mensagem) {
    	super();
    	this.mensagem = mensagem;
    }
    @Override
	public EventoColetado criarEventoColetado() {
		EventoColetado retorno = new EventoColetado();
		
		String dthrEventoMensagem = UtilsString.getChave(mensagem.getMensagemRecebidaTcp(), ProtocoloEntrada._DATAHORA_EVENTO);
		String dthrInicioEventoMensagem = UtilsString.getChave(mensagem.getMensagemRecebidaTcp(), ProtocoloEntrada._DATAHORA_INICIO_EVENTO);
		Date dthrevento;
		Date dthrInicioEvento = null;
		
		if (dthrEventoMensagem != null && dthrEventoMensagem.equals("") == false) {
			dthrevento = DataHoraRN.stringToDate(dthrEventoMensagem, "yyyy-MM-dd HH:mm:ss.SSS");
		} else {
			dthrevento = IdwFacade.getInstancia().getDataHoraServidorBanco();
		}
		if (dthrInicioEventoMensagem != null && dthrInicioEventoMensagem.equals("") == false) {
			dthrInicioEvento = DataHoraRN.stringToDate(dthrInicioEventoMensagem, "yyyy-MM-dd HH:mm:ss.SSS");
		}
		
		// Alessandre: qual o motivo desse -1 ?? nao removi o -1 mas alterei o ihm desktop para mandar o 19 e o 20 
		retorno.setTipoEvento(mensagem.getServico()); /*- 1 Alessandre: em 26-02-16 removi o -1 para analisar o impacto); */
		retorno.setUp(mensagem.getUp());
		retorno.setDthrEvento(dthrevento);
		retorno.setDthrinicioEvento(dthrInicioEvento);
		retorno.setExisteEvento(true);
		retorno.setCb(mensagem.getCodigoBarras());
		retorno.setLog(mensagem.getLog());
		retorno.setIdentacao(mensagem.getIdentacao());
		retorno.setIdLog(mensagem.getIdLog());
		retorno.setLogin(mensagem.getLogin());
		retorno.setCdacao(mensagem.getCdAcao());
		retorno.setCdalerta(mensagem.getCdAlerta());
		retorno.setCdcausa(mensagem.getCdCausa());
		retorno.setCdconsulta(mensagem.getCdConsulta());
		retorno.setCdestrutura(mensagem.getCdEstrutura());
		retorno.setCdFolha(mensagem.getCdFolha());
		retorno.setTpSessao(mensagem.getTpSessao());
		retorno.setCdjustificativa(mensagem.getCdJust());
		retorno.setCdmolde(mensagem.getCdMolde());
		retorno.setCdop(mensagem.getNrOp());
		retorno.setCdparada(mensagem.getCdParadaIhm());
		retorno.setCdproduto(mensagem.getCdProduto());
		retorno.setDthrUltimoRefugo(mensagem.getDthrUltRefugo());
		retorno.setMilisec(mensagem.getMsDthrUltRefugo());
		retorno.setCdrefugo(mensagem.getCdRefugo());
		retorno.setCdtec1(mensagem.getCdTec1());
		retorno.setCdtec2(mensagem.getCdTec2());
		retorno.setCdtecResponsavel(mensagem.getCdTecResponsavel());
		retorno.setIdRdzProduto(mensagem.getIdRdzProduto());
		retorno.setQtde(mensagem.getQtde());
		retorno.setSenha(mensagem.getSenha());
		retorno.setSenhaTec1(mensagem.getSenhaTec1());
		retorno.setSenhaTec2(mensagem.getSenhaTec2());
		retorno.setSenhaTecResponsavel(mensagem.getSenhaTecResponsavel());
		retorno.setOrigem(mensagem.getMensagemRecebidaTcp());
		retorno.setIdUpPdba(mensagem.getIdup());
		retorno.setNumeroSerie(mensagem.getNumeroSerie());
		retorno.setQtdeciclos(mensagem.getQtdeCiclos());
		
		// Localiza o msicupdto dentro da lista de MsIcDTOLocal.msicupdtolocais
		boolean isEncontrou = false;
		for(IcUpDTO msicupdto : mensagem.getDadosIcDTO().getMsIcUpDTOLocais()) {
			
			// Se nao existir a up definida na mensagem, entao pegar a primeira ocorrencia do vetor. A Up nao existira na mensagem, quando for o
			// servico de registro. A linha abaixa foi comentada, avaliar impacto
			//if(msicupdto.getMsUpDTOLocal().getCd_up() == null) {
			String up = retorno.getUp();
			
			if (up == null || up.equals("")) {
				mensagem.getLog().info("A UP nao foi passada na mensagem, entao assumindo " + msicupdto.getIdIcUp());
				retorno.setIcUpDTO(msicupdto);
				isEncontrou = true;
				break;
			} else if(msicupdto.getUpDTO().getCd_up().equals(up)) {
				mensagem.getLog().info("Encontrou a up " + up);
				retorno.setIcUpDTO(msicupdto);
				isEncontrou = true;
				break;
			} else {
				mensagem.getLog().info("Pesquisando a up " + up + " na lista msicupdtolocais no item msicupdtolocal " + msicupdto.getIdIcUp() + " sem encontrar.");
			}
		}
		if (isEncontrou == true){
			
		}

		return retorno;
	}
    
	@Override
	public String getCdUp(String clientSentence) {
		return UtilsString.getChave(clientSentence, "up");
	}
}
