package ms.coleta.ic.fuji.fujiflexa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import idw.util.IdwLogger;
import ms.coleta.ic.fuji.ICFuji;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.util.UtilsString;

public class LinhaArquivoFujiFlexaMCRELOAD {

	private IdwLogger log;
	private String linha;
	private ICFuji ic;
	private IcUpDTO icUpDTO;
	private String[] linhaSplitada;
	private int forIndex = 0;
	
	// Atributos
	private String identificacaoEvento = null;
	private String dDateTime = null;
	private String sequencial = null;
	private String programa = null;
	private String estagio = null;
	private String origem = null;

	public LinhaArquivoFujiFlexaMCRELOAD(IdwLogger log, ICFuji ic, IcUpDTO icUpDTO, String linha, int forIndex) {
		super();
		this.log = log;
		this.ic = ic;
		this.icUpDTO = icUpDTO;
		this.linha = linha;
		this.forIndex = forIndex;
		parseLinhaTratada();
	}

	private void parseLinhaTratada() {
		// linhas =  idw.util.UtilsString.quebrarStringEmVetor(linha, "\t").toArray(new String[0]);
		linhaSplitada =  linha.split("\t");
		// 00000091	2018040913594710	[CP7L11]<>MCSTATUS:2018040913594710:3	12	APD12W NEW_L11_T00	Super User	0
		// 00000103	2018040915594126	[CP7L11]<>PRODEND:2018040915594126:669	Main	PRODUCT	APD12W NEW_L11_T00	Super User	31
		// 7 e o numero minimo encontrado até agora de campos em uma linha
		if (linhaSplitada.length > 6) { 
			String[] grupoInternoLinha;
			try {
				grupoInternoLinha = linhaSplitada[2].split(":");
				identificacaoEvento = grupoInternoLinha[0];
				dDateTime = grupoInternoLinha[1];
				sequencial = grupoInternoLinha[2];
				// programa = linhaSplitada[4];
				// observou-se que na linha PRODEND o programa fica no 5o grupo do split
				programa = linhaSplitada[5];
				estagio = "1";
				if (linha.contains("LANE2"))
					estagio = "2";
				
				origem = linhaSplitada[2] + " " + programa;
			} catch (Exception e) {
				log.error("LinhaArquivoFujiFlexa: Falha no parser da linha" 
						+ " para posto: " + icUpDTO.getUpDTO().getCd_up()
						+ " origem: " + origem
						+ " linha: " + linha
						+ " excecao: " + e.toString());
			}
		}
		else {
			log.error("LinhaArquivoFujiFlexa: Linha mal formatada para posto: " + icUpDTO.getUpDTO().getCd_up()
					+ " linha: " + linha);
		}
	}

	public boolean isLinhaNoPadraoEsperado() {
		if (identificacaoEvento != null && dDateTime != null
				&& programa != null)
			return true;
		return false;
	}

	public List<EventoColetado> obtemEvento() {
		List<EventoColetado> retorno = new ArrayList<>();
		
		if (identificacaoEvento.contains("PRODEND")) {
			// ------------------------------------------
			// Fim de ciclo
			EventoColetado eventoCiclo = geraEventoFimCiclo();
			if (eventoCiclo != null) {
				retorno.add(eventoCiclo);
				log.info("LinhaArquivoFujiFlex: Gerou evento de fim de ciclo:;"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(eventoCiclo.getDthrEvento())
						+ ";" + eventoCiclo.getCdop() + ";" + eventoCiclo.getOrigem());
			}
			
			if (retorno.size() > 0) {
				ic.getUltimasLinhasProcessadasMCRELOAD().put(icUpDTO.getUpDTO().getCd_up(), this);
			}

		}
		return retorno;
	}

	private EventoColetado geraEventoFimCiclo() {
		EventoColetado eventoColetado = new EventoColetado();

		// Seta campos do objeto eventoColetado

		eventoColetado.setTipoEvento(ServicoFactory._FIM_CICLO); // Fim de Ciclo
		// Formato da data: 2018040915594126
		eventoColetado.setDthrEvento(UtilsString.convertToDateLogFujiFlex(dDateTime));
		eventoColetado.setCdop(programa);
		eventoColetado.setCb("");
		eventoColetado.setIcUpDTO(icUpDTO);
		eventoColetado.setOrigem(origem);
		eventoColetado.setQtde("1");
		eventoColetado.setSequencial(safeParseToInt(sequencial));
		
		// TODO: Setar no eventoColetado o estagio
		// No C# e utilizado o WS setEventoInsert que utiliza objetos EventoDTO
		// Essa coleta usa objetos EventoColetado
		// eventoColetado.setEstagio("1");
		
		return eventoColetado;
	}

	public String getLinha() {
		return linha;
	}
	
	int safeParseToInt(String valor) {
		int retorno = 0;
		try {
			retorno = Integer.parseInt(valor);
		} catch (Exception e) {
			log.error("Falha ao realizar o parser do valor: " + valor + " da linha " + toString());
			log.error("Excecao: " + e.toString());
			retorno = 0;
		}
		return retorno;
	}

}
