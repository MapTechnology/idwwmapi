package ms.coleta.ic.flex.ssid;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import idw.model.IdwFacade;
import idw.model.dao.DAOGenerico;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.template.PpCpTemplate;
import idw.model.rn.PTRN;
import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;
import idw.webservices.dto.MontagemDTO;
import idw.webservices.dto.MontagensDTO;
import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.coleta.ic.drivercoleta.PararDeProcessarArquivoSemSalvarLinhaException;
import ms.coleta.ic.flex.TrataArquivoRN;
import ms.coleta.ic.mitrastar.ssid.LinhaArquivoMitraStarSSID;
import ms.coleta.ic.mitrastar.ssid.MitraStarSSIDParseException;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcUpDTO;
import ms.model.rn.UpRN;

public class TrataArquivoRNSSID extends TrataArquivoRN {
	private static final int ORDEM_MONTAGEM_SERIAL_PLACA = 1;
	private static final int ORDEM_MONTAGEM_SERIAL_PRODUTO = 2;
	private static final int ORDEM_MONTAGEM_SENHA24G = 3;
	private static final int ORDEM_MONTAGEM_SENHA5G = 4;
	private static final int ORDEM_MONTAGEM_BOSA = 5;

	public TrataArquivoRNSSID(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log, int idLog) {
		super(pathRelativo, icupdto, fileType, log, idLog);
	}	

	/* Se o metodo retornar TRUE o processamento do arquivo é finalizado
	 * (non-Javadoc)
	 * @see ms.coleta.ic.flex.TrataArquivoRN#processaUmaLinhaDoArquivoCustom(java.io.File, java.lang.String, int, java.lang.String)
	 */
	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException {
		boolean retorno = false;
		
		/*
		 * 
		 * 
561800000000	ACC662DE93C4	VIVOFIBRA-93C4	c662de93c4	VIVOFIBRA-93C4-5G	c662de93c4	ACC662DE93C4	d4a21d4e	MSTC2FDCEFE3	A180Y03008483	17/01/18	11:54:26
561803019797	ACC662DE93BA	VIVOFIBRA-93BA	c662de93ba	VIVOFIBRA-93BA-5G	c662de93ba	ACC662DE93BA	934c4ae3	MSTC2FDCEFE2	A180Y03008482	17/01/18	12:03:31
561803017769	ACC662DE93B0	VIVOFIBRA-93B0	c662de93b0	VIVOFIBRA-93B0-5G	c662de93b0	ACC662DE93B0	8479ccd3	MSTC2FDCEFE1	A180Y03008481	17/01/18	12:04:28
561803019806	ACC662DE93A6	VIVOFIBRA-93A6	c662de93a6	VIVOFIBRA-93A6-5G	c662de93a6	ACC662DE93A6	519d7995	MSTC2FDCEFE0	A180Y03008480	17/01/18	12:49:55

		Alessandre em 20-04-18 em alguns casos a data e hora estao vindo no formato AM/PM


Alessandre em 04-05-18 para o produto HGU HPNA, o padrão do SSID está abaixo:

561815000006	ACC662B6B198	VIVOFIBRA-B198	A46A8D2195	VIVOFIBRA-B198-5G	A46A8D2195	ACC662B6B198	492e5c8b	MSTC2CA4D544	S170Z49000004

PCI = 561815000006
NS = ACC662B6B198
senha 24g = VIVOFIBRA-B198	A46A8D2195
senha 5g = VIVOFIBRA-B198-5G	A46A8D2195

Para o produto HPNA abaixo exemplo
0							1							2													3									4						5							6					7							8							9
----------------	-----------------	---------------------------------	----------------------	--------------	----------------	----------		-----------------	-----------------	-------------------
561822000561	A433D71E1638	VIVOFIBRA-1638	7A35ABC8B4	VIVOFIBRA-1638-5G	7A35ABC8B4	A433D71E1638	97825fd4		MSTC30E03AC0	S180Z20001472  29/05/18	14:22:44
561822000626	A433D71E1630	VIVOFIBRA-1630	CE807DEF13	VIVOFIBRA-1630-5G	CE807DEF13	A433D71E1630	6d46b725	MSTC30E03ABF	S180Z20001471  29/05/18	14:23:42
561822000625	A433D71E1628	VIVOFIBRA-1628	A1D23C4031	VIVOFIBRA-1628-5G	A1D23C4031	A433D71E1628	f115f4c3		MSTC30E03ABE	S180Z20001470  29/05/18	14:24:42
561822000619	A433D71E1620	VIVOFIBRA-1620	35B9B7D347	VIVOFIBRA-1620-5G	35B9B7D347	A433D71E1620	b72394b2	MSTC30E03ABD	S180Z20001469  29/05/18	14:25:46
561822000603	A433D71E1618	VIVOFIBRA-1618	F661EF46E0		VIVOFIBRA-1618-5G	F661EF46E0		A433D71E1618	fc2ac22b		MSTC30E03ABC	S180Z20001468  29/05/18	14:26:49
561822000628	A433D71E1610	VIVOFIBRA-1610	90DBD5707E	VIVOFIBRA-1610-5G	90DBD5707E	A433D71E1610	585241d4	MSTC30E03ABB	S180Z20001467  29/05/18	14:27:55
561822000629	A433D71E1608	VIVOFIBRA-1608	49E8ADBFB6	VIVOFIBRA-1608-5G	49E8ADBFB6	A433D71E1608	b3d57363	MSTC30E03ABA	S180Z20001466  29/05/18	14:29:04
561822000569	A433D71E1600	VIVOFIBRA-1600	254CD99A59	VIVOFIBRA-1600-5G	254CD99A59	A433D71E1600	3c8114af		MSTC30E03AB9	S180Z20001465  29/05/18	14:33:49
561822000633	A433D71E15F8	VIVOFIBRA-15F8	F19EC255EF		VIVOFIBRA-15F8-5G	F19EC255EF		A433D71E15F8	2c9f82ea		MSTC30E03AB8	S180Z20001464  29/05/18	14:35:02
561822000637	A433D71E15F0	VIVOFIBRA-15F0	16A4419EF4	VIVOFIBRA-15F0-5G	16A4419EF4	A433D71E15F0	d8149eec	MSTC30E03AB7	S180Z20001463  29/05/18	14:36:22
561822000630	A433D71E15E8	VIVOFIBRA-15E8	C5D0795DBF	VIVOFIBRA-15E8-5G	C5D0795DBF	A433D71E15E8	47afa391		MSTC30E03AB6	S180Z20001462  29/05/18	14:36:52

561851000123	A433D7C1EE98	VIVOFIBRA-EE98	D74F2045E4	VIVOFIBRA-EE98-5G	D74F2045E4	A433D7C1EE98	f92249fe	MSTC32C2AF6C	S180Z51619692	19/12/18 08:07:18
561851000116	A433D7C1EE90	VIVOFIBRA-EE90	9B553677F1	VIVOFIBRA-EE90-5G	9B553677F1	A433D7C1EE90	f391e5ba	MSTC32C2AF6B	S180Z51619691	19/12/18 08:08:46
561851000126	A433D7C1EE88	VIVOFIBRA-EE88	DD728813CB2	VIVOFIBRA-EE88-5G	DD728813CB	A433D7C1EE88	6f36e3fe	MSTC32C2AF6A	S180Z51619690	19/12/18 08:09:58
561851000124	A433D7C1EE80	VIVOFIBRA-EE80	BE62147318	VIVOFIBRA-EE80-5G	BE62147318	A433D7C1EE80	489d35f8	MSTC32C2AF69	S180Z51619689	19/12/18 08:10:57

Abaixo exemplo do SSID do ADSL
0				1				2			3			4				5			6			7		
------------	------------	---------	----------	----------		--------	----------	--------
561851010978	A433D7C11130	VIVO-1130	33D7C11130	A433D7C11130	7bfefa2e	21/12/2018	09:56:24
561851010915	A433D7C1112C	VIVO-112C	33D7C1112C	A433D7C1112C	f2bbefa8	21/12/2018	09:56:41
561851010977	A433D7C11128	VIVO-1128	33D7C11128	A433D7C11128	a2ed4873	21/12/2018	09:57:10
561851011001	A433D7C11124	VIVO-1124	33D7C11124	A433D7C11124	6484412f	21/12/2018	09:57:30
561851010999	A433D7C11120	VIVO-1120	33D7C11120	A433D7C11120	dfb1a88f	21/12/2018	09:57:48
561851010770	A433D7C1111C	VIVO-111C	33D7C1111C	A433D7C1111C	71a4946f	21/12/2018	09:58:22
561851010991	A433D7C11118	VIVO-1118	33D7C11118	A433D7C11118	de9875f8	21/12/2018	09:58:44
561851010988	A433D7C11114	VIVO-1114	33D7C11114	A433D7C11114	921a1be4	21/12/2018	09:59:03

MAC = A433D7C11114

1) PCI = 561851010988 (coluna 0)
2) SERIAL = nao tem
3) SENHA 24G = VIVOFIBRA-EE80	BE62147318 (coluna 2)
4) SENHA 5G = nao tem
5) BOSA = Coluna 7


Abaixo exemplo da montagem que será capturada para a ultima linha do arquivo acima

MAC = A433D7C1EE80

1) PCI = 561851000124 (coluna 0)
2) SERIAL = S180Z51619689 (coluna 8)
3) SENHA 24G = VIVOFIBRA-EE80	BE62147318 (coluna 2)
4) SENHA 5G = VIVOFIBRA-EE80-5G (coluna 3)
5) BOSA = Coluna 7


Para o produto GV abaixo exemplo

0				1				2				3				4			5				6				7					8
------------	-------------	----------		-------------	----------	------------	-----------		--------		---------
561845002785	S180Z42006356	FIBRA-CC4E		FIBRA-CC4E-5G	0Z42006356	A433D78FCC4E	MSTC322FFF54	09/11/18		1:44:22 PM
561845002782	S180Z42006355	FIBRA-CC44		FIBRA-CC44-5G	0Z42006355	A433D78FCC44	MSTC322FFF53	09/11/18		1:49:33 PM
561845002800	S180Z42006354	FIBRA-CC3A		FIBRA-CC3A-5G	0Z42006354	A433D78FCC3A	MSTC322FFF52	09/11/18		1:50:59 PM
561845002805	S180Z42006353	FIBRA-CC30		FIBRA-CC30-5G	0Z42006353	A433D78FCC30	MSTC322FFF51	09/11/18		1:51:42 PM
561845002799	S180Z42006352	FIBRA-CC26		FIBRA-CC26-5G	0Z42006352	A433D78FCC26	MSTC322FFF50	09/11/18		1:52:41 PM
561845002806	S180Z42006351	FIBRA-CC1C		FIBRA-CC1C-5G	0Z42006351	A433D78FCC1C	MSTC322FFF4F	09/11/18		1:53:20 PM

Abaixo exemplo da montagem que será capturada para a ultima linha do arquivo acima

MAC = A433D78FCC1C com montagem abaixo

1) PCI = 561845002806 (coluna 0)
2) SERIAL = S180Z42006351 (esse serial vai impresso na etiqueta) (coluna 1)
3) SENHA 24G = FIBRA-CC1C (coluna 2)
4) SENHA 5G = FIBRA-CC1C-5G (coluna 3)
5) BOSA = 6


VDSL V2
0				1			2			3				4			5			6
A433D7C5DC98	VIVO-DC98	PmqXn4REWX	A433D7C5DC98	semehot0	22/12/2018	14:44:11
A433D7C5DC90	VIVO-DC90	XafYYY3fPj	A433D7C5DC90	lzmk5ele	22/12/2018	14:44:23
A433D7C5DC88	VIVO-DC88	7Ufcj33WM3	A433D7C5DC88	1ibhbxsb	22/12/2018	14:44:38
A433D7C5DC80	VIVO-DC80	j3E9REEV43	A433D7C5DC80	q92ksral	22/12/2018	14:44:52
A433D7C5DC78	VIVO-DC78	3A3nM93VUU	A433D7C5DC78	xhs46k8l	22/12/2018	14:45:07

MAC = A433D7C5DC78

		 */
		LinhaArquivoMitraStarSSID linha;
		try {
			linha = new LinhaArquivoMitraStarSSID(linhaArquivo);

			processarLinha(linha);
			
			retorno = false;
		} catch (MitraStarSSIDParseException e) {
			e.printStackTrace();
			log.info(idLog, 0, "Excesao", e);
			retorno = false;
		}

		
		
		
		
		return retorno;
	}
	
	
	
	
	private void processarLinha(LinhaArquivoMitraStarSSID linhaArquivo) {
		UpRN upRN = new UpRN();
		DAOGenerico dao = new DAOGenerico();
		try {
			dao.iniciaSessao();
			dao.iniciaTransacao();

			upRN.setDaoPdba(dao);

			OmPt omPt = new PTRN(dao).getOmPt(maquina);

			EventoColetado eventoColetado = createEventoColetado(linhaArquivo, omPt);

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

	
	
	private EventoColetado createEventoColetado(LinhaArquivoMitraStarSSID linhaArquivo, OmPt omPt) {

		EventoColetado evento = new EventoColetado();
		evento.setTipoEvento(ServicoFactory._PASSAGEM);
		evento.setIcUpDTO(getIcupdto());
		evento.setCb(linhaArquivo.getMac());
		evento.setNumeroSerie(evento.getCb());
		evento.setDthrEvento(linhaArquivo.getDataHora());
		evento.setLog(this.log);

		List<MontagemDTO> montagens = new ArrayList<MontagemDTO>();

		montagens.add(createMontagemSerialPlaca(linhaArquivo));

		// O campo serial pode ter o mesmo número mac.
		// Quando for diferente indica que tem que o produto tem, além do MAC, o número série de identificação dele.
		if (linhaArquivo.getSerial() != null && linhaArquivo.getSerial().equals(linhaArquivo.getMac()) == false) {
			MontagemDTO serial = createMontagemSerialProduto(linhaArquivo);
			montagens.add(serial);
			evento.setCbserial(serial.getCb());
		}
		
		
		// Para o produto hpna obter tambem as senhas 24 e 5g aleatorias
		if (linhaArquivo.getSenha24g() != null && linhaArquivo.getSenha24g().equals("") == false) {
			montagens.add(createMontagemSenha24g(linhaArquivo));
		}
		if (linhaArquivo.getSenha5g() != null && linhaArquivo.getSenha5g().equals("") == false) {
			montagens.add(createMontagemSenha5g(linhaArquivo));
		}

		if (linhaArquivo.getBosa() != null && linhaArquivo.getBosa().equals("") == false) {
			montagens.add(createMontagemBosa(linhaArquivo));
		}
		
		
		evento.setMontagem(montagens);

		// Indica de qual OP o evento pertence, evitando que isso seja buscado em ms_evt
		if (omPt.getPpCp() != null) {
			evento.setCdop(omPt.getPpCp().getCdCp());
		}
		
		/* Avalia se as partes montadas já foram montadas anteriormente
		 * 
		 */
		PpCp ppcp = IdwFacade.getInstancia().pesquisarPpCpAtualByCdPt(omPt.getCdPt());
		boolean isORetrabalho = ppcp != null && ppcp.getTpCp() != null && ppcp.getTpCp().equals(PpCpTemplate.TpCp.RETRABALHO.getValue());
		if (isORetrabalho == false) {
			// Avaliar cada item montado se ja pertence a um outro produto
			for (MontagemDTO itemMontado : montagens) {
				// Verifica se ja montado
				log.info(idLog, 0, "Verificando montagem de " + itemMontado.getCb());
				MontagensDTO montagensAux = IdwFacade.getInstancia().isCBJaMontado(itemMontado.getCb(), omPt.getCdPt(), ppcp.getNrop());
				// Se ja montado no mesmo PAI, entao lancar NC
				log.info(idLog, 0, "Tem montagem " + (montagensAux.getListaMontagem().isEmpty() == false) + " msevt.cb=" + evento.getCb() + " = cdPai=" + montagensAux.getCbPai());
				if (montagensAux.getListaMontagem().isEmpty() == false && evento.getCb().equals(montagensAux.getCbPai()) == false) {
					log.info(idLog, 0, "Item " + itemMontado.getCb() + " ja montado no produto " + montagensAux.getCbPai() + " nao da para montar em " + evento.getCb());
					if (itemMontado.getCb().contains("MST"))
						evento.setCddefeito("BOSA");
					else if (itemMontado.getCb().length() > 2 && itemMontado.getCb().substring(0, 2).equals("56")) {
						evento.setCddefeito("SERIAL");
					} else {
						evento.setIsCbConforme(true);
						break;
					}
					
					evento.setIsCbConforme(false);
					evento.setOrigem(montagensAux.getCbPai());
					break;
				}
			}
		}


		return evento;

	}

	private MontagemDTO createMontagemSerialPlaca(LinhaArquivoMitraStarSSID linhaArquivo) {
		MontagemDTO montagemDTO = new MontagemDTO();
		montagemDTO.setCb(linhaArquivo.getSerialPlaca());
		montagemDTO.setOrdem(ORDEM_MONTAGEM_SERIAL_PLACA);
		return montagemDTO;
	}

	private MontagemDTO createMontagemSerialProduto(LinhaArquivoMitraStarSSID linhaArquivo) {
		MontagemDTO montagemDTO = new MontagemDTO();
		montagemDTO.setCb(linhaArquivo.getSerial());
		montagemDTO.setOrdem(ORDEM_MONTAGEM_SERIAL_PRODUTO);
		return montagemDTO;
	}

	private MontagemDTO createMontagemSenha24g(LinhaArquivoMitraStarSSID linhaArquivo) {
		MontagemDTO montagemDTO = new MontagemDTO();
		montagemDTO.setCb(linhaArquivo.getSenha24g());
		montagemDTO.setOrdem(ORDEM_MONTAGEM_SENHA24G);
		return montagemDTO;
	}
	
	private MontagemDTO createMontagemSenha5g(LinhaArquivoMitraStarSSID linhaArquivo) {
		MontagemDTO montagemDTO = new MontagemDTO();
		montagemDTO.setCb(linhaArquivo.getSenha5g());
		montagemDTO.setOrdem(ORDEM_MONTAGEM_SENHA5G);
		return montagemDTO;
	}
	
	private MontagemDTO createMontagemBosa(LinhaArquivoMitraStarSSID linhaArquivo) {
		MontagemDTO dto = new MontagemDTO();
		dto.setCb(linhaArquivo.getBosa());
		dto.setOrdem(ORDEM_MONTAGEM_BOSA);
		return dto;
	}
	
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
			log.info(idLog, 0, "Salvando ultimaLinhaProcessada " + lineCounter + " em " + fileName + " = " + ultimaLinhaProcessada);
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(ultimaLinhaProcessada);
			writer.println(String.valueOf(lineCounter));
			writer.println(ultimoArquivoProcessado);
			writer.close();
		} catch (Exception e) {
			log.info(idLog, 0, "Excessao: ", e);
			e.printStackTrace();
		}
	}

	@Override
	protected void tratativaFinalDoArquivo() {
	}
}
