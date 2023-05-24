package ms.coleta.ic.spiKY2;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.rn.DataHoraRN;
import idw.util.IdwLogger;
import idw.util.UtilsString;
import idw.webservices.dto.DefeitoDTO;
import ms.coleta.dto.EventosColetados;
import ms.coleta.ic.aoiVTRNSSQL.ArquivoUltimoID;
import ms.coleta.servico.ServicoFactory;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
//import java.sql.*;
import ms.util.ConversaoTipos;

public class TrataBD {

	String url, ano, mes;
	private IdwLogger log;
	private IcDTO icdto;
	private IcUpDTO icUpDTO;
	private Connection conn;
	private Statement s;
	private String idno, pcbName, user, result, db, barCode;
	private Date dateTime, date, eTime;

	private ArquivoUltimoID ultimoID = null;

	public TrataBD(String urlAuxiliar, Date dateTime, String ano, String mes, IdwLogger log, IcDTO icdto, IcUpDTO icUpDTO, ArquivoUltimoID ultimoID) throws Exception {
		this.url = urlAuxiliar;
		this.ano = ano;
		this.mes = mes;
		this.dateTime = dateTime;
		this.log = log;
		this.icdto = icdto;
		this.icUpDTO = icUpDTO;
		this.ultimoID = ultimoID;

		StringBuilder urlDatabase = new StringBuilder();

		try {
			// a linha abaixo foi comantada pois o jdbc do java foi descontinuado na versao 8
			// java.sql.Driver d = (java.sql.Driver) Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); // necessario fazer esse acesso para que o driver seja carregado em
																	// memoria

			if (Integer.parseInt(mes) < 10) {
				mes = UtilsString.getZerosAEsquerda(mes, 2);
			}

			urlDatabase.append("jdbc:ucanaccess://");
			urlDatabase.append(url);
			urlDatabase.append("/");
			urlDatabase.append(this.ano);
			urlDatabase.append("/");
			urlDatabase.append(mes);
			urlDatabase.append("/");
			urlDatabase.append(this.ano);
			urlDatabase.append(mes);
			urlDatabase.append(".mdb;");

			// E://Kohyoung//KY-3030//data//2022//04//202204.mdb";

			// conn = DriverManager.getConnection(database, "", "");
			conn = DriverManager.getConnection(urlDatabase.toString());
			// conn = d.connect(database, new Properties());

			s = conn.createStatement();
			log.info("Conexão com o banco " + urlDatabase.toString() + " efetuada com sucesso");
		} catch (Exception e) {
			log.info("Erro ao tentar abrir o banco .mdb: " + urlDatabase.toString() + " " + e);
			throw e;
		}
	}

	public List<EventoColetado> obtemEvento() {

		List<EventoColetado> retorno = new ArrayList<>();

		try {

			EventosColetados eventosObtido = processarLinha();

			/* Se o evento for muito antigo entao não deve ser incluido na lista de retorno */
			Date dthrReferencia = DataHoraRN.getDataHoraAtual();
			dthrReferencia = DataHoraRN.subtraiDiasDaData(dthrReferencia, 1);

			retorno.addAll(eventosObtido.getEventosColetados());
			
		} catch (Exception e) {
			log.info("TrataBD: Excessao em obtemEvento da maquina: "
					+ getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
		}
		return retorno;
	}

	protected EventosColetados processarLinha() {
		EventosColetados retorno = new EventosColetados();

		try {
			
			// Verificar se houve virada de mês
			// para isso vê qual o ano e mes de referencia do ultimo ID no arquivo properties
			if (ultimoID.isAnoMesReferencia(icUpDTO.getUpDTO().getCd_up(), this.ano, this.mes) == false) {
				System.out.println("zerando ID para cdup " + icUpDTO.getUpDTO().getCd_up() + " pois ano=" + this.ano + " mes=" + this.mes);
				ultimoID.setUltimoID(icUpDTO.getUpDTO().getCd_up(), BigDecimal.ZERO);
				ultimoID.setAnoMesReferencia(icUpDTO.getUpDTO().getCd_up(), this.ano, this.mes);
				ultimoID.saveUltimoID(icdto);
			}
			
			
			
			
			
			
			/*
			 * Alessandre em 20-05-22 comentei toda a pesquisa e a interação no select, pois do jeito que tá apenas o ultimo registro é
			 * importado. Alem disso, o arquivo que disparou a leitura do MDB é alterado quando um grupo de placas é testado e não a cada
			 * placa. E a data e hora desse MDB parece estar sem atualização correta. Utilizarei a data e hora do MDB e sempre salvarei o
			 * ulitmo ID lido para garantir que todas as placas sejam lidas. Mas o disparo ainda continuara com a alteracao do arquivo
			 * apesar de não utilizar mais a data e hora desse arquivo String selTable =
			 * "SELECT TOP 1 IDNO, PCBNAME, USER, RESULT, LOGDB, BARCODE FROM PCBRESULT ORDER BY IDNO DESC"; s.setMaxRows(1); // Alessandre
			 * mudei para 1, ja que o top acima eh 1. Era 10 s.execute(selTable); ResultSet rs = s.getResultSet();
			 */
			Date dtReferencia = DataHoraRN.getDataHoraAtual();
			dtReferencia = DataHoraRN.subtraiDiasDaData(dtReferencia, 1);
			
			StringBuilder select = new StringBuilder();
			select.append("SELECT IDNO, PCBNAME, RESULT, LOGDB, BARCODE, DATE, ETIME FROM PCBRESULT WHERE IDNO > ");
			select.append(ultimoID.getUltimoID(icUpDTO.getUpDTO().getCd_up()));
			select.append(" and DATE > '");
			select.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(dtReferencia));
			select.append("' ORDER BY IDNO");
			
			String selTable =  select.toString();
			s.setMaxRows(5);
			s.execute(selTable);
			ResultSet rs = s.getResultSet();
			
			
			log.info("msacess: " + selTable);

			// Alessandre Limpei as variaveis antes de fazer a leitura do banco para evitar valores anteriores. Estou obtendo result sempra
			// FAIL
			idno = "";
			pcbName = "";
			user = "";
			result = "";
			db = "";
			barCode = "";

			int qt = 0;
			
			
			// Como o select retorna apenas um registro então o loop abaixo vai ler apenas esse registro
			while ((rs != null) && (rs.next())) {

				qt++;
				
				idno = rs.getString(1);
				pcbName = rs.getString(2);
				user = "coluna reservada"; //rs.getString(3);
				result = rs.getString(3);
				db = rs.getString(4);
				barCode = rs.getString(5);
				date = rs.getDate(6);
				eTime = rs.getTime(7);
				
				dateTime = DataHoraRN.setHoraNaData(date, DataHoraRN.getApenasHoras(eTime), DataHoraRN.getApenasMinutos(eTime), DataHoraRN.getApenasSegundos(eTime), DataHoraRN.getApenasMilisegundos(eTime));

				log.info("Origem: " + getOrigem(idno, pcbName, user, result, db, barCode, dateTime));

				// No caso o db sera o nome de outro MDB que tera os codigos dos defeitos ocorridos
				if (db.length() == 3) {
					db = "0" + db;
				}

				if (db.length() == 2) {
					db = "00" + db;
				}

				if (db.length() == 1) {
					db = "000" + db;
				}

				String cdUp = icUpDTO.getUpDTO().getCd_up();

				log.info("Dados obtidos com sucesso na primeira consulta result = " + result + " para IDNO = " + idno);

				// Finalização da conexão com o banco da SPI
				EventoColetado dto;

				if (result.equals("FAIL")) {

					dto = criaEventoColetadoTesteDefeito(cdUp, pcbName, "", dateTime, "1");

				} else
					dto = criaEventoColetadoTesteSimples(cdUp, pcbName, "", dateTime, "1");

				// Alessandre define nova origem como sendo o registro lido a fim de debugar
				dto.setOrigem(getOrigem(idno, pcbName, user, result, db, barCode, dateTime));
				
				retorno.addEventoColetado(dto);
				
				// Salva referencia do ultimo ID processado para pegarmos a diferenca na proxima alteração.
				if (ConversaoTipos.converteParaBigDecimal(idno).compareTo(ultimoID.getUltimoID(icUpDTO.getUpDTO().getCd_up())) > 0) {
					ultimoID.setUltimoID(icUpDTO.getUpDTO().getCd_up(), ConversaoTipos.converteParaBigDecimal(idno));
					ultimoID.saveUltimoID(icdto);
					retorno.setUltimoID(ConversaoTipos.converteParaBigDecimal(idno));
				}
			}
			
			log.info("Total de registros: " + qt);
			
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			log.info("TrataBD: Excessao em obtemEvento da maquina: " + getIcUpDTO().getUpDTO().getCd_up() + " - " + e);
			log.info("Excessao em processaLinha", e);

		} finally {
			try {
				if (s != null)
					s.close();
				s = null;
			} catch (SQLException e) {
				e.printStackTrace();
				log.info("Excessao s.close", e);
			}
			try {
				if (conn != null)
					conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
				log.info("Excessao conn.close", e);
			}
		}

		return retorno;

	}

	private String getOrigem(String idno, String pcbName, String user, String result, String db, String barCode, Date eTime) {
		StringBuilder retorno = new StringBuilder();
		
		retorno.append("IDNO:");
		retorno.append(idno);
		retorno.append(" pcbName:");
		retorno.append(pcbName);
		retorno.append(" user:");
		retorno.append(user);
		retorno.append(" result:");
		retorno.append(result);
		retorno.append(" db:");
		retorno.append(db);
		retorno.append(" barCode:");
		retorno.append(barCode);
		retorno.append(" eTime:");
		retorno.append(DataHoraRN.dateToStringYYYYMMDDHHMMSS(eTime));
		
		return retorno.toString();
	}

	private IcUpDTO getIcUpDTO() {
		return icUpDTO;
	}

	private EventoColetado criaEventoColetadoTesteSimples(String cdUp, String cdOp, String string, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();

		ev.setCb(barCode);

		if (ev.getCb().equals("") || ev.getCb().equals("Fail")) {
			ev.setCb("NS-" + icUpDTO.getUpDTO().getCd_up() + "-" + dataHoraFimTeste.toString());
		}

		ev.setCdop(cdOp);
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(true);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // Passagem
		ev.setOrigem(dataHoraFimTeste + " " + barCode + " " + result);

		log.info("Criação de teste simples:" + " " + dataHoraFimTeste + " " + barCode + " " + result);

		return ev;
	}

	// Estão sendo lançados como defeitos somente placas cujo resultado é FAIL

	private EventoColetado criaEventoColetadoTesteDefeito(String cdUp, String cdOp, String qualUso, Date dataHoraFimTeste, String qtde) {
		EventoColetado ev = new EventoColetado();
		ev.setCb(barCode);

		if (ev.getCb().equals("") || ev.getCb().equals("Fail")) {
			ev.setCb("NS-" + icUpDTO.getUpDTO().getCd_up() + "-" + DataHoraRN.dateToStringYYYYMMDDHHMMSS(dataHoraFimTeste));
		}

		ev.setCdop(cdOp);
		ev.setUp(cdUp);
		ev.setIcUpDTO(icUpDTO);
		ev.setQtde(qtde);
		ev.setIsCbConforme(false);
		ev.setDthrEvento(dataHoraFimTeste);
		ev.setLog(log);
		ev.setTipoEvento(ServicoFactory._PASSAGEM); // // Passagem
		ev.setOrigem(dataHoraFimTeste + " " + barCode + " " + result);

		List<DefeitoDTO> defeitos = new ArrayList<DefeitoDTO>();
		// Validacao
		StringBuilder urlDatabase = new StringBuilder();
		
		
		Connection connAux = null;
		Statement sAux = null;		
		
		try {
			// a linha abaixo foi comantada pois o jdbc do java foi descontinuado na versao 8
			// java.sql.Driver d = (java.sql.Driver) Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); // necessario fazer esse acesso para que o driver seja carregado em
																	// memoria

			if (Integer.parseInt(mes) < 10) {
				mes = UtilsString.getZerosAEsquerda(mes, 2);
			}

			urlDatabase.append("jdbc:ucanaccess://");
			urlDatabase.append(url);
			urlDatabase.append("/");
			urlDatabase.append(this.ano);
			urlDatabase.append("/");
			urlDatabase.append(mes);
			urlDatabase.append("/");
			// urlDatabase.append(this.ano); Alessandre comentei as tres linhas em 19-05-22 pois tambem nao existem no path da GBR
			// urlDatabase.append(mes);
			// urlDatabase.append("/");
			urlDatabase.append(db);
			// urlDatabase.append("/"); Alessandre comentei em 19-05-22 sem isso o mdb sempre tem nome vazio
			urlDatabase.append(".mdb;");


			log.info("Tentando Conexão com o banco " + urlDatabase);

			// conn = DriverManager.getConnection(database, "", "");
			connAux = DriverManager.getConnection(urlDatabase.toString());
			
			sAux = connAux.createStatement();

			log.info("Conexão com o banco " + urlDatabase + "efetuada com sucesso");

			String selTable = "SELECT ComponentID,Result from PadResult where IDNO = " + idno + " and Result <> 1 ";

			sAux.setMaxRows(10);
			sAux.execute(selTable);
			ResultSet rsAux = sAux.getResultSet();

			while ((rsAux != null) && (rsAux.next())) {

				DefeitoDTO defeito = new DefeitoDTO();
				defeito.setCdDefeito(rsAux.getString(2));
				defeito.setDthrDefeito(dataHoraFimTeste);
				defeito.setCb(barCode); // codigo de barras
				defeito.setPosicoes(rsAux.getString(1)); // Posicao Mecanica
				defeitos.add(defeito);

			}
			
			rsAux.close();

			log.info("Dados de defeitos obtidos com a segunda consulta");

			if (defeitos.size() > 0)
				ev.setDefeitos(defeitos);

		} catch (Exception e) {
			log.info("Erro ao tentar abrir o banco .mdb para teste com defeito:" + urlDatabase + " " + e);
			log.info("Escessao em tratabd", e);
			e.printStackTrace();

		} finally {
			try {
				if (sAux != null)
					sAux.close();
			} catch (Exception e) {
				log.info("Excessao no sAux.close", e);
				e.printStackTrace();
			}
			try {
				if (connAux != null)
					connAux.close();
			} catch (Exception e) {
				log.info("Excessao no connAux.close", e);
				e.printStackTrace();
			}

			
		}
		
		log.info("saindo do criaEcentoColetado");

		return ev;
	}

}
