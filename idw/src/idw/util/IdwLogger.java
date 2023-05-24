package idw.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.RollingFileAppender;
import org.apache.logging.log4j.core.config.Configuration;

import idw.model.dao.AbstractDAOGenerico;
import idw.model.rn.DataHoraRN;
import idw.model.rn.MonitorRN;
import ms.model.dto.EventoColetado;

public class IdwLogger {

	private long especializacaoHabilidata = IdwLogger._Especializacao.RESUMO_CONSOLIDACAO.getValue();

	public enum _Especializacao {
		SEM_ESPECIALIZACAO((long) 0), RESUMO_CONSOLIDACAO((long) 1);

		private final long value;

		private _Especializacao(long value) {
			this.value = value;
		}

		public long getValue() {
			return this.value;
		}

	}

	private Logger log;
	private String name;
	private Stack<String> pilhaAtividade = new Stack<String>();
	private Stack<Date> pilhaDatas = new Stack<Date>();
	private Stack<Long> pilhaConsumoMemoria = new Stack<Long>();
	private Date dtf = null;
	private Date dti = null;
	private String logPathFile = null;
	private Long memoriaLivreInicial = 0l;
	private Long memoriaLivreFinal = 0l;
	private String idAtividade;
	private BigDecimal idEvtUltimo = BigDecimal.ZERO;
	private StringBuilder mensagem = null;

	public IdwLogger() {

	}

	public IdwLogger(String name) {
		
		// Ricardo: 28/02/2023
		name = "idw";
		
		this.name = name;
		this.configuraLogger();

	}

	public boolean isModoDebug() {
		boolean retorno = false;
		try {
			retorno = this.log.isDebugEnabled(); // .equals(Level.TRACE);
		} catch (NullPointerException e) {
			retorno = false;
		}
		return retorno;
	}

	public void iniciaAvaliacao(String idAtividade) {

		this.pilhaDatas.push(DataHoraRN.getDataHoraAtual());
		this.pilhaConsumoMemoria.push(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
		this.pilhaAtividade.push(idAtividade);
	}

	public void paraAvaliacao() {
		this.paraAvaliacao(null, null);
	}

	public void paraAvaliacao(Long idEvt) {
		paraAvaliacao(new BigDecimal(idEvt));
	}

	public void paraAvaliacao(BigDecimal idEvt) {
		this.idEvtUltimo = idEvt;

		this.dti = this.pilhaDatas.pop();
		this.dtf = DataHoraRN.getDataHoraAtual();

		this.memoriaLivreInicial = this.pilhaConsumoMemoria.pop();
		this.memoriaLivreFinal = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		this.idAtividade = this.pilhaAtividade.pop();

	}

	public long getMilisegundosTranscorridos() {
		return DataHoraRN.getQuantidadeMilisegundosNoPeriodo(this.dti, this.dtf);
	}

	public long getSegundosTranscorridos() {
		return DataHoraRN.getQuantidadeSegundosNoPeriodo(this.dti, this.dtf);
	}

	public long getConsumoMemoriaPressumido() {
		return this.memoriaLivreFinal - this.memoriaLivreInicial;
	}

	public String getAtividadeAvalidada() {
		return this.idAtividade;
	}

	public String getAvaliacaoCompleta() {
		return "EventoID:" + this.idEvtUltimo + " - Atividade: " + this.getAtividadeAvalidada() + " - Duracao: "
				+ this.getMilisegundosTranscorridos() + " ms - Consumo memoria: " + this.getConsumoMemoriaPressumido() + " bytes ";
	}

	private void configuraLogger() {
		// Configura o Appender
		/*
		 * LoggerContext context = (LoggerContext) LogManager.getContext(false); Configuration configuration = context.getConfiguration();
		 * Layout<? extends Serializable> old_layout = configuration.getAppender(appender_name).getLayout();
		 * configuration.getAppender(appender_name).stop(); configuration.removeLogger(package_name);
		 * 
		 * LoggerConfig loggerConfig = new LoggerConfig(package_name, Level.INFO, false); FileAppender appender =
		 * FileAppender.createAppender(file_name, "false", "false", appender_name, "true", "true", "true", "8192", old_layout, null,
		 * "false", "", configuration); appender.start(); loggerConfig.addAppender(appender, Level.INFO, null);
		 * configuration.addLogger(package_name, loggerConfig);
		 * 
		 * context.updateLoggers();
		 */

		/*
		 * String dir = System.getProperty("java.io.tmpdir") + "test\\"; final LoggerContext ctx = (LoggerContext)
		 * LogManager.getContext(false); final Configuration config = ctx.getConfiguration(); PatternLayout layout =
		 * PatternLayout.newBuilder().withConfiguration(config).withPattern(PatternLayout.SIMPLE_CONVERSION_PATTERN).build();
		 * SizeBasedTriggeringPolicy policy = SizeBasedTriggeringPolicy.createPolicy("1KB"); DefaultRolloverStrategy strategy =
		 * DefaultRolloverStrategy.createStrategy("10", "0", null, null, config); RollingFileManager fileManager =
		 * RollingFileManager.getFileManager(dir + "log\\test.log", dir + "log\\test-%i.log", false, false, policy, strategy, null, layout,
		 * 128); policy.initialize(fileManager); RollingFileAppender appender = RollingFileAppender.createAppender(dir + "log\\test.log",
		 * dir + "log\\test-%i.log", "false", "File", "false", "128", "true", policy, strategy, layout, (Filter) null, "false", "false",
		 * (String) null, config); appender.start(); config.addAppender(appender); AppenderRef ref = AppenderRef.createAppenderRef("File",
		 * Level.INFO, null); AppenderRef[] refs = new AppenderRef[] { ref }; LoggerConfig loggerConfig = LoggerConfig.createLogger("true",
		 * Level.INFO, LogManager.ROOT_LOGGER_NAME, "true", refs, null, config, null); loggerConfig.addAppender(appender, Level.INFO, null);
		 * config.addLogger(LogManager.ROOT_LOGGER_NAME, loggerConfig); ctx.updateLoggers();
		 */

		final LoggerContext loggerContext = (LoggerContext) LogManager.getContext();
		this.log = loggerContext.getLogger(this.name); // Logger.getLogger(name);

		final Configuration configuration = loggerContext.getConfiguration();
		RollingFileAppender appenderFileLogger = (RollingFileAppender) configuration.getAppender("fileLogger");

		if (appenderFileLogger != null) {
			String fullPath = appenderFileLogger.getFileName();
			if (fullPath == null)
				fullPath = "ERROGRAVE";
			
			int indiceExtensao = fullPath.lastIndexOf("."); // obtém indice da a extensao do arquivo
			if (indiceExtensao <= 0) {
				if (fullPath.length() > 0)
					indiceExtensao = fullPath.length() - 1;
				else
					indiceExtensao = 0;
			}
			String nomeAdicional = UtilsString.removeCarecteresInvalidosDeNomeDeArquivo(this.name);

			
			// Ricardo: 25/02/2023
			// String arqLog = fullPath.substring(0, indiceExtensao) + nomeAdicional + fullPath.substring(indiceExtensao);
			String arqLog = fullPath.substring(0, indiceExtensao - 3) + nomeAdicional + fullPath.substring(indiceExtensao);
			

//			for (String chave : configuration.getAppenders().keySet()) {
//				System.out.println("chave = " + chave);
//			}
			
			if (configuration.getAppender(nomeAdicional) == null) {
//				System.out.println("criando arquivo log " + arqLog);
				// Define estrategia para reciclagem dos arquivos
//				 DefaultRolloverStrategy newStrategy = DefaultRolloverStrategy
//						    .newBuilder()
//						    .withMax("10")
//						    .withCompressionLevelStr(String.valueOf(Deflater.DEFAULT_COMPRESSION))                                                                
//						    .withFileIndex("min")
//						    .withConfig(configuration)
//						    .build();
				
				
				// -----------------------------------------------------------
				// Ricardo: 25/02/2023
				// -----------------------------------------------------------
				
				// Mudou de: .withFilePattern(appenderFileLogger.getFilePattern())
				// Para    : .withFilePattern(newFilePattern)
				
				String filePattern = appenderFileLogger.getFilePattern();
				// ....../idw_%d{yyyyMMdd_HHmm}.log.gz
				int pos = filePattern.lastIndexOf("idw_%d");
				// String newFilePattern = filePattern.substring(0, pos) + "idw" + nomeAdicional + filePattern.substring(pos + 3);
				String newFilePattern = filePattern.substring(0, pos - 1) + nomeAdicional + filePattern.substring(pos + 3);
				// String newFilePattern = filePattern;
				
				// Acredito que tenha alguma coisa errada nisso aqui
				// .setConfiguration(configuration)
				
				// Cria novo appender para o arquivo em questão
				RollingFileAppender appender = RollingFileAppender.newBuilder()
						.setName(nomeAdicional)
						.setLayout(appenderFileLogger.getLayout())
						.withFileName(arqLog)
						.withAppend(true)
						.withBufferedIo(true)
						.setConfiguration(configuration)
						.withFilePattern(newFilePattern)
						.withCreateOnDemand(false) // qdo eh true o arquivo nao eh criado
						.withPolicy(appenderFileLogger.getTriggeringPolicy())
						.withStrategy(appenderFileLogger.getManager().getRolloverStrategy())
						.build();
				
				// -----------------------------------------------------------
				
				appender.start();

				configuration.addLoggerAppender(this.log, (Appender) appender);

				loggerContext.updateLoggers();
				
				this.logPathFile = fullPath.substring(0,indiceExtensao);

				/*
				 * RollingFileAppender oNovoAppender = new RollingFileAppender();
				 * 
				 * oNovoAppender.setName(oAppender.getName() + nomeAdicional); oNovoAppender.setLayout(oAppender.getLayout());
				 * oNovoAppender.setMaxBackupIndex(oAppender.getMaxBackupIndex());
				 * oNovoAppender.setMaximumFileSize(oAppender.getMaximumFileSize());
				 * oNovoAppender.setFile(fullPath.substring(0,indiceExtensao) + nomeAdicional + fullPath.substring(indiceExtensao) );
				 * 
				 * this.logPathFile = fullPath.substring(0,indiceExtensao);
				 * 
				 * oNovoAppender.activateOptions(); this.log.addAppender(oNovoAppender);
				 */
			}

		}
		/*
		 * Comentei a configuracao do appender pois na versao 2.17 aparentemente não eh necessario RollingFileAppender oAppender =
		 * Stubedelegate.getInstancia().getoAppender(); RollingFileAppender oAppender = Logger.getRootLogger().getAppender("fileLog");
		 * 
		 * if (oAppender != null) {
		 * 
		 * String fullPath = oAppender.getFileName(); // obtem o Caminho completo mais o nome base de arquivo com extensao if (fullPath ==
		 * null) fullPath = "ERROGRAVE";
		 * 
		 * int indiceExtensao = fullPath.lastIndexOf("."); // obtém indice da a extensao do arquivo if(indiceExtensao<=0){
		 * if(fullPath.length()>0) indiceExtensao=fullPath.length()-1; else indiceExtensao=0; } String nomeAdicional=
		 * UtilsString.removeCarecteresInvalidosDeNomeDeArquivo(this.name);
		 * 
		 * if (log.getAppender(oAppender.getName() + nomeAdicional ) == null){ RollingFileAppender oNovoAppender = new
		 * RollingFileAppender(); oNovoAppender.setName(oAppender.getName() + nomeAdicional);
		 * oNovoAppender.setLayout(oAppender.getLayout()); oNovoAppender.setMaxBackupIndex(oAppender.getMaxBackupIndex());
		 * oNovoAppender.setMaximumFileSize(oAppender.getMaximumFileSize()); oNovoAppender.setFile(fullPath.substring(0,indiceExtensao) +
		 * nomeAdicional + fullPath.substring(indiceExtensao) );
		 * 
		 * this.logPathFile = fullPath.substring(0,indiceExtensao);
		 * 
		 * oNovoAppender.activateOptions(); this.log.addAppender(oNovoAppender); } }
		 */

	}
	
	

	public void debug(Object message) {
		this.log.debug(message, null);
	}

	public void debug(int idLog, int identacao, Object message) {
		this.log.debug(message, null);
	}

	public void error(Object message) {
		this.log.error(message, null);
	}

	public void error(int idLog, int identacao, Object message) {
		this.log.error(" (#" + idLog + "#) " + StringUtils.repeat(" ", identacao) + message);
	}

	public void error(Object message, Exception e) {
		if (e != null) {
			e.printStackTrace();
		}
		this.log.error(message, e);
	}

	public void info(Object message) {
		this.log.info(message, null);
	}

	public void info(int idLog, int identacao, Object message) {
		this.log.info(" (#" + idLog + "#) " + StringUtils.repeat(" ", identacao) + message);
	}

	public void info(long especializacao, int idLog, int identacao, Object message) {
		if (especializacao == especializacaoHabilidata)
			this.log.info(" (#" + idLog + "#) " + StringUtils.repeat(" ", identacao) + message);
	}

	public void trace(int idLog, int identacao, Object message) {
		this.log.trace(" (#" + idLog + "#) " + StringUtils.repeat(" ", identacao) + message);
	}

	public void info(Object message, Exception e) {
		this.log.info(message, e);
	}

	public void info(int idLog, int identacao, Object message, Exception e) {
		this.log.info(message);
		this.log.info(e);
	}

	public void info() {
		this.info(this.mensagem.toString());
	}

	public void info(int idLog, int identacao) {
		this.info(idLog, identacao, mensagem.toString());
	}

	public String getNomeLog() {
		return this.name;
	}

	public int getIdAleatorio() {
		Random random = new Random(System.currentTimeMillis());
		return random.nextInt();
	}

	public void iniciaAvaliacao(int idLog, String idAtividade) {
		this.iniciaAvaliacao(" (#" + idLog + "#) " + idAtividade);
	}

	public void paraAvaliacao(AbstractDAOGenerico dao) {
		this.paraAvaliacao(null, dao);
	}

	public void paraAvaliacao(boolean isMonitor, BigDecimal idEvt, AbstractDAOGenerico dao) {
		paraAvaliacao(idEvt, dao);

		if (isMonitor == true && isMonitor == false) {
			MonitorRN monitorRN = new MonitorRN(dao);
			try {

				monitorRN.setDao(dao);
				monitorRN.incluirMonitor(this.idAtividade, this.dti, this.dtf,
						new BigDecimal(this.getConsumoMemoriaPressumido()),
						new BigDecimal(this.memoriaLivreFinal),
						new BigDecimal(this.memoriaLivreInicial),
						new BigDecimal(this.getMilisegundosTranscorridos()),
						idEvt);

			} catch (Exception e) {
				e.printStackTrace();
				this.info(e);
			}
			monitorRN = null;
		}
	}

	public void paraAvaliacao(BigDecimal idEvt, AbstractDAOGenerico dao) {
		this.idEvtUltimo = idEvt;

		try {
			this.dti = this.pilhaDatas.pop();
		} catch (EmptyStackException e) {

		}
		this.dtf = DataHoraRN.getDataHoraAtual();

		try {
			this.memoriaLivreInicial = this.pilhaConsumoMemoria.pop();
		} catch (EmptyStackException e) {

		}
		this.memoriaLivreFinal = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		try {
			this.idAtividade = this.pilhaAtividade.pop();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
	}

	public void novaMensagem() {
		this.mensagem = new StringBuilder();
	}

	public void addMensagem(String mensagem) {
		if (this.mensagem == null) {
			this.mensagem = new StringBuilder();
		}
		this.mensagem.append(mensagem);
	}

	public void salvarEventoColetado(EventoColetado evento) {
		if (isModoDebug() == true || evento == null)
			return;

		// Salva evento coletado
		try {
			salvaEventoSemCompactacao(evento, this.logPathFile + evento.getIcUpDTO().getIc().getUrl_conexao() + ".dto", true);
		} catch (NullPointerException e) {
			info(e);
		}
	}

	private void salvaEventoSemCompactacao(EventoColetado evento, String onde, boolean adicionaNoFinal) {
		try {
			// serialize the objects sarah and sam
			FileOutputStream fos = new FileOutputStream(onde, adicionaNoFinal);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(evento);
			oos.flush();
			oos.close();
			fos.close();
		} catch (IOException e) {
			info("Nao foi possivel salvar EventoColetado.");
		}
	}

	public void mostrarAvaliacaoCompleta() {
		paraAvaliacao();
		log.info(getAvaliacaoCompleta());
	}

	public void mostrarAvaliacaoCompleta(int idLog, int identacao) {
		paraAvaliacao();
		info(idLog, identacao, getAvaliacaoCompleta());
	}

}
