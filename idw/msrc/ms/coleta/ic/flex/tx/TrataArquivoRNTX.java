package ms.coleta.ic.flex.tx;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.MontagensDTO;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.model.rn.UpRN;

public class TrataArquivoRNTX extends TrataArquivoRN {
	
	public TrataArquivoRNTX(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
	}

	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		// 0			1			 2	  3	   4	5	  6	   7	8	 9	  10	   11	 12
		// 561612000120 872601001780 0168 0006 2.88 12.73 49.2 60.0 0.00 0.00 00:00:29 False T908 0 12 1 2 0.0 0.0 0.0 0.0 0
		// 872601002354 872601002354 0286 -0005 -42.99 0.00 00.0 00.0 0.00 0.00 00:00:13 False F110 0 12 3 0 0.0 0.0 0.0 0.0 0
		String[] parameters = linhaArquivo.split("\\s+");
		if (parameters.length >= 13) {
			String serialNumber = parameters[0];
			String gabon = parameters[1]; // será usado no acoplamento no serialNumber
			// String partNumber = parameters[1]; sems uso no momento
			String errorCode = parameters[12];
			
			Date datePassagem = DataHoraRN.getDataHoraAtual(); //new Date(file.lastModified());
			
			// aqui devemos pegar a 2a coluna do txt e lancar como momntagem
			
			int stTeste = 0;
			if (errorCode.compareTo("T908") == 0) {
				stTeste = 1;
				//Teste com sucesso será lancado como montagem
				processarLinha(linhaArquivo, datePassagem, serialNumber, gabon, stTeste);
			} else {
				lancaTesteComDefeito(linhaArquivo, datePassagem, serialNumber, stTeste, errorCode);
			}
		}
		// Resolucao de bug
		// Processa apenas uma linha
		// return true;
		return false;
	}

	@Override
	protected boolean obtemInformacoesNecessarias(String arquivoProcessado) {
		boolean retorno = false;

		String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";

		if (ArquivosDiretorios.isExisteArquivo(fileName) == true) {
			try (RandomAccessFile reader = new RandomAccessFile(fileName, "r")) {
				this.ultimaLinhaProcessada = reader.readLine();
				this.lineCounter = Integer.parseInt(reader.readLine());
				this.ultimoArquivoProcessado = reader.readLine();
				retorno = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	@Override
	protected void salvaInformacoesNecessarias(String arquivoProcessado) {
		try {
			String fileName = pathDirParaProcessamento + maquina + "-" + arquivoProcessado + ".txt";
			log.info("Salvando ultimaLinhaProcessada" + lineCounter + " em " + fileName);
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(ultimaLinhaProcessada);
			writer.println(String.valueOf(lineCounter));
			writer.println(ultimoArquivoProcessado);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void tratativaFinalDoArquivo() {
	}









	// Processa a montagem quando o teste for realizado com sucesso
	private void processarLinha(String linha, Date horaPassagem, String serialNumber, String gabon, int stTeste) {
		UpRN upRN = new UpRN();
		DAOGenerico dao = new DAOGenerico();
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			upRN.setDaoPdba(dao);

			OmPt omPt = new PTRN(dao).getOmPt(maquina);

			EventoColetado eventoColetado = createEventoColetado(linha, horaPassagem, serialNumber, gabon, omPt);

			upRN.registrarPassagem(idLog, 10, eventoColetado);

			dao.commitaTransacao(dao.getSession());
		} catch (Exception e) {
			e.printStackTrace();
			dao.rollBackTransacaoSemException();
			log.info(idLog, 0, "Erro processarLinha:", e);
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			dao.finalizaSessaoSemException();
		}

	}

	
	
	private EventoColetado createEventoColetado(String linha, Date horaPassagem, String serialNumber, String gabon, OmPt omPt) {

		EventoColetado evento = new EventoColetado();
		evento.setTipoEvento(ServicoFactory._PASSAGEM);
		evento.setIcUpDTO(getIcupdto());
		evento.setCb(serialNumber);
		evento.setNumeroSerie(evento.getCb());
		evento.setDthrEvento(horaPassagem);
		evento.setLog(this.log);

		List<MontagemDTO> montagens = new ArrayList<>();

		montagens.add(createMontagemSerialPlaca(gabon));

		evento.setMontagem(montagens);

		// Indica de qual OP o evento pertence, evitando que isso seja buscado em ms_evt
		if (omPt.getPpCp() != null) {
			evento.setCdop(omPt.getPpCp().getCdCp());
		}
		
		
		/* Verificar se o GPON foi utilizado em outro produto. Se sim a montagem deve ser enviada com erro e defeito = GPON
		 * 
		 */
		PpCp ppcp = IdwFacade.getInstancia().pesquisarPpCpAtualByCdPt(omPt.getCdPt());
		boolean isORetrabalho = ppcp != null && ppcp.getTpCp() != null && ppcp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue());
		if (isORetrabalho == false) {
			// Avaliar cada item montado se ja pertence a um outro produto
			for (MontagemDTO itemMontado : montagens) {
				// Verifica se ja montado
				MontagensDTO montagensAux = IdwFacade.getInstancia().isCBJaMontado(itemMontado.getCb());
				// Se ja montado no mesmo PAI, entao lancar NC
				if (montagensAux.getListaMontagem().isEmpty() == false && serialNumber.equals(montagensAux.getCbPai()) == false) {
					log.info(idLog, 0, "Item " + itemMontado.getCb() + " ja montado no produto " + montagensAux.getCbPai() + " nao da para montar em " + serialNumber);
					evento.setCddefeito("GPON");
					evento.setIsCbConforme(false);
					evento.setOrigem(montagensAux.getCbPai());
					break;
				}
			}
		}

		
		

		return evento;

	}

	private MontagemDTO createMontagemSerialPlaca(String gabon) {
		MontagemDTO montagemDTO = new MontagemDTO();
		montagemDTO.setCb(gabon);
		montagemDTO.setOrdem(1);
		return montagemDTO;
	}

}
