package idw.model.rn.db;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import idw.model.dao.HibernateUtil;
import idw.webservices.dto.ChangeLogBDDTO;
import idw.webservices.dto.ChangeLogsBDDTO;
import idw.webservices.dto.ManipularChangeLogsDTO;
import liquibase.changelog.ChangeLogIterator;
import liquibase.changelog.ChangeLogParameters;
import liquibase.changelog.ChangeSet;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.changelog.RanChangeSet;
import liquibase.changelog.filter.ContextChangeSetFilter;
import liquibase.changelog.filter.DbmsChangeSetFilter;
import liquibase.changelog.filter.ShouldRunChangeSetFilter;
import liquibase.changelog.visitor.UpdateVisitor;
import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.integration.commandline.CommandLineResourceAccessor;
import liquibase.integration.commandline.CommandLineUtils;
import liquibase.lockservice.LockService;
import liquibase.parser.ChangeLogParserFactory;
import liquibase.resource.CompositeResourceAccessor;
import liquibase.resource.FileSystemResourceAccessor;
import liquibase.resource.ResourceAccessor;
import liquibase.util.StringUtils;

public class ManipularChangeLogs {
	private static Database db;
	private static List<RanChangeSet> ranChangeSets;
	private ManipularChangeLogsDTO manipularChangeLogsDTO = new ManipularChangeLogsDTO();
	/**
	 * @param args
	 * @throws Exception 
	 * @throws Exception 
	 */

	public ManipularChangeLogs() throws Exception{
		final List<URL> urls = new ArrayList<URL>();
		String classpathEntry = "WebContent/WEB-INF/lib/ojdbc6.jar;WebContent/WEB-INF/lib/sqljdbc4.jar";
		ClassLoader classLoader;
		urls.add(new File(classpathEntry).toURL());
		classLoader = AccessController.doPrivileged(new PrivilegedAction<URLClassLoader>() {
			@Override
			public URLClassLoader run() {
				return new URLClassLoader(urls.toArray(new URL[urls.size()]), Thread.currentThread().getContextClassLoader());
			}
		});
		String url="";
		String driver="";
		String username="";
		String password="";
		/*try {
	        new HibernateUtil();
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session s = sessionFactory.openSession();
			Transaction tx =s.beginTransaction();  
			AnnotationConfiguration c = new AnnotationConfiguration();
	        url=c.getProperty("hibernate.connection.url");
	        driver=c.getProperty("hibernate.connection.driver_class");
	        username=c.getProperty("hibernate.connection.username");
	       	password=c.getProperty("hibernate.connection.password");
	       	tx.commit();
	       	s.close();
		}catch (Exception e) {
			e.printStackTrace();
		}*/
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session s = sessionFactory.openSession();
		Properties prop = new AnnotationConfiguration().configure().getProperties();
		url=prop.getProperty("hibernate.connection.url");
        driver=prop.getProperty("hibernate.connection.driver_class");
        username=prop.getProperty("hibernate.connection.username");
       	password=prop.getProperty("hibernate.connection.password");

		Database database = CommandLineUtils.createDatabaseObject(classLoader, url, 
				username, password, driver, null, null, null);
		db = database;
		ChangeLogParameters changeLogParameters;
		changeLogParameters = new ChangeLogParameters(database);
		String changeLogFile="main/resources/db/idw/changelogs/changelog.idw.master.xml";
		String contexts= null;
		changeLogFile = changeLogFile.replace('\\', '/');
		ResourceAccessor resourceAccessor;
		FileSystemResourceAccessor fsOpener = new FileSystemResourceAccessor();
		CommandLineResourceAccessor clOpener = new CommandLineResourceAccessor(classLoader);
		CompositeResourceAccessor fileOpener = new CompositeResourceAccessor(fsOpener, clOpener);
		resourceAccessor = fileOpener;
		manipularChangeLogsDTO.setChangeLogFile(changeLogFile);
		manipularChangeLogsDTO.setResourceAccessor(resourceAccessor);
		manipularChangeLogsDTO.setChangeLogParameters(changeLogParameters); 
		manipularChangeLogsDTO.setContexts(contexts); 
		manipularChangeLogsDTO.setDatabase(database);
	}
	public void listarChangeLogs() throws Exception{
		String changeLogFile = manipularChangeLogsDTO.getChangeLogFile();
		ResourceAccessor resourceAccessor= manipularChangeLogsDTO.getResourceAccessor(); 
		ChangeLogParameters changeLogParameters= manipularChangeLogsDTO.getChangeLogParameters();
		String contexts= manipularChangeLogsDTO.getContexts();
		try {
			DatabaseChangeLog changeLog = ChangeLogParserFactory.getInstance().getParser(changeLogFile, resourceAccessor).parse(changeLogFile, changeLogParameters, resourceAccessor);
			checkDatabaseChangeLogTable(true, changeLog, contexts);
			List<ChangeSet> lista = changeLog.getChangeSets();
			listar(listaChangeLogs(lista));

		} finally {

		}
	}
	public ChangeLogsBDDTO listarChangeLogsNaoExecutados() throws Exception{
		String changeLogFile = manipularChangeLogsDTO.getChangeLogFile();
		ResourceAccessor resourceAccessor= manipularChangeLogsDTO.getResourceAccessor(); 
		ChangeLogParameters changeLogParameters= manipularChangeLogsDTO.getChangeLogParameters();
		String contexts= manipularChangeLogsDTO.getContexts();
		Database database= manipularChangeLogsDTO.getDatabase();
		ChangeLogsBDDTO bddto = new ChangeLogsBDDTO();
		try {
			DatabaseChangeLog changeLog = ChangeLogParserFactory.getInstance().getParser(changeLogFile, resourceAccessor).parse(changeLogFile, changeLogParameters, resourceAccessor);
			checkDatabaseChangeLogTable(true, changeLog, contexts);
			List<ChangeSet> lista = changeLog.getChangeSets();
			changeLog.validate(database, contexts);
			ranChangeSets = database.getRanChangeSetList();
			listar(listaChangeLogsNaoExecutados(lista));
			bddto.setChangelog(listaChangeLogsNaoExecutados(lista));
		} finally {

		}
		return bddto;
	}
	public ChangeLogsBDDTO listarChangeLogsExecutados() throws Exception{
		String changeLogFile = manipularChangeLogsDTO.getChangeLogFile();
		ResourceAccessor resourceAccessor= manipularChangeLogsDTO.getResourceAccessor(); 
		ChangeLogParameters changeLogParameters= manipularChangeLogsDTO.getChangeLogParameters();
		String contexts= manipularChangeLogsDTO.getContexts();
		Database database= manipularChangeLogsDTO.getDatabase();
		ChangeLogsBDDTO bddto = new ChangeLogsBDDTO();
		try {
			DatabaseChangeLog changeLog = ChangeLogParserFactory.getInstance().getParser(changeLogFile, resourceAccessor).parse(changeLogFile, changeLogParameters, resourceAccessor);
			checkDatabaseChangeLogTable(true, changeLog, contexts);
			List<ChangeSet> lista = changeLog.getChangeSets();
			changeLog.validate(database, contexts);
			ranChangeSets = database.getRanChangeSetList();
			listar(listaChangeLogsExecutados(lista));
			bddto.setChangelog(listaChangeLogsExecutados(lista));
		} finally {
			
		}
		return bddto;
	}
	public void rodarlistas() throws Exception{
		String changeLogFile = manipularChangeLogsDTO.getChangeLogFile();
		ResourceAccessor resourceAccessor= manipularChangeLogsDTO.getResourceAccessor(); 
		ChangeLogParameters changeLogParameters= manipularChangeLogsDTO.getChangeLogParameters();
		String contexts= manipularChangeLogsDTO.getContexts();
		Database database= manipularChangeLogsDTO.getDatabase();
		try {
			DatabaseChangeLog changeLog = ChangeLogParserFactory.getInstance().getParser(changeLogFile, resourceAccessor).parse(changeLogFile, changeLogParameters, resourceAccessor);
			checkDatabaseChangeLogTable(true, changeLog, contexts);
			List<ChangeSet> lista = changeLog.getChangeSets();
			changeLog.getChangeSets().clear();
			listar(listaChangeLogs(lista));
			changeLog.validate(database, contexts);
			ranChangeSets = database.getRanChangeSetList();
			//listar(listaChangeSetsNaoExecutados(lista));
			listar(listaChangeLogsNaoExecutados(lista));
			ChangeLogIterator changeLogIterator = getStandardChangelogIterator(contexts, changeLog);

			changeLogIterator.run(new UpdateVisitor(database), database);
		} finally {

		}
	}
	public void rodar() throws Exception{
		String changeLogFile = manipularChangeLogsDTO.getChangeLogFile();
		ResourceAccessor resourceAccessor= manipularChangeLogsDTO.getResourceAccessor(); 
		ChangeLogParameters changeLogParameters= manipularChangeLogsDTO.getChangeLogParameters();
		String contexts= manipularChangeLogsDTO.getContexts();
		Database database= manipularChangeLogsDTO.getDatabase();
		try {
			DatabaseChangeLog changeLog = ChangeLogParserFactory.getInstance().getParser(changeLogFile, resourceAccessor).parse(changeLogFile, changeLogParameters, resourceAccessor);
			checkDatabaseChangeLogTable(true, changeLog, contexts);
			changeLog.validate(database, contexts);
			ChangeLogIterator changeLogIterator = getStandardChangelogIterator(contexts, changeLog);
			changeLogIterator.run(new UpdateVisitor(database), database);
		} finally {

		}
	}
	public boolean rodarChangeLog(String changeLogName) throws Exception{
		String changeLogFile = changeLogName.replace('\\', '/');
		ResourceAccessor resourceAccessor= manipularChangeLogsDTO.getResourceAccessor(); 
		ChangeLogParameters changeLogParameters= manipularChangeLogsDTO.getChangeLogParameters();
		String contexts= manipularChangeLogsDTO.getContexts();
		Database database= manipularChangeLogsDTO.getDatabase();
		try {
			DatabaseChangeLog changeLog = ChangeLogParserFactory.getInstance().getParser(changeLogFile, resourceAccessor).parse(changeLogFile, changeLogParameters, resourceAccessor);
			checkDatabaseChangeLogTable(true, changeLog, contexts);
            changeLog.validate(database, contexts);
            ChangeLogIterator changeLogIterator = getStandardChangelogIterator(contexts, changeLog);
            changeLogIterator.run(new UpdateVisitor(database), database);
            return true;
        } finally {
            
        }
	}
	private static List<ChangeLogBDDTO> listaChangeLogs(List<ChangeSet> lista){
		List<ChangeSet> listaChangeSets = new ArrayList<ChangeSet>();
		List<ChangeLogBDDTO> listaChangeLogBDDTOs = new ArrayList<ChangeLogBDDTO>();
		if(lista!=null||lista.size()>0){
			listaChangeSets = lista;
		}
		for(ChangeSet changeSet: listaChangeSets){
			if(listaChangeLogBDDTOs.size()==0){
				ChangeLogBDDTO changeLogBDDTO = new ChangeLogBDDTO();
				changeLogBDDTO.setChangeLog(changeSet.getFilePath());
				listaChangeLogBDDTOs.add(changeLogBDDTO);
			}else{
				boolean flag=false;
				for(ChangeLogBDDTO dto:listaChangeLogBDDTOs){
					if(dto.getChangeLog().equals(changeSet.getFilePath())){
						flag=true;
						break;
					}
				}
				if(!flag){
					ChangeLogBDDTO changeLogBDDTO = new ChangeLogBDDTO();
					changeLogBDDTO.setChangeLog(changeSet.getFilePath());
					listaChangeLogBDDTOs.add(changeLogBDDTO);
				}
			}
		}
		return listaChangeLogBDDTOs;
	}
	private static List<ChangeLogBDDTO> listaChangeLogsNaoExecutados(List<ChangeSet> lista){
		List<ChangeSet> listaChangeSets = new ArrayList<ChangeSet>();
		List<ChangeLogBDDTO> listaChangeLogBDDTOs = new ArrayList<ChangeLogBDDTO>();
		if(lista!=null||lista.size()>0){
			listaChangeSets = lista;
		}
		for(ChangeSet changeSet: listaChangeSets){
			if(accepts(changeSet)){
				if(listaChangeLogBDDTOs.size()==0){
					ChangeLogBDDTO changeLogBDDTO = new ChangeLogBDDTO();
					changeLogBDDTO.setChangeLog(changeSet.getFilePath());
					listaChangeLogBDDTOs.add(changeLogBDDTO);
				}else{
					boolean flag=false;
					for(ChangeLogBDDTO dto:listaChangeLogBDDTOs){
						if(dto.getChangeLog().equals(changeSet.getFilePath())){
							flag=true;
							break;
						}
					}
					if(!flag){
						ChangeLogBDDTO changeLogBDDTO = new ChangeLogBDDTO();
						changeLogBDDTO.setChangeLog(changeSet.getFilePath());
						listaChangeLogBDDTOs.add(changeLogBDDTO);
					}
				}
			}
		}
		return listaChangeLogBDDTOs;
	}
	private static List<ChangeLogBDDTO> listaChangeLogsExecutados(List<ChangeSet> lista){
		List<ChangeSet> listaChangeSets = new ArrayList<ChangeSet>();
		List<ChangeLogBDDTO> listaChangeLogBDDTOs = new ArrayList<ChangeLogBDDTO>();
		if(lista!=null||lista.size()>0){
			listaChangeSets = lista;
		}
		for(ChangeSet changeSet: listaChangeSets){
			if(!accepts(changeSet)){
				if(listaChangeLogBDDTOs.size()==0){
					ChangeLogBDDTO changeLogBDDTO = new ChangeLogBDDTO();
					changeLogBDDTO.setChangeLog(changeSet.getFilePath());
					listaChangeLogBDDTOs.add(changeLogBDDTO);
				}else{
					boolean flag=false;
					for(ChangeLogBDDTO dto:listaChangeLogBDDTOs){
						if(dto.getChangeLog().equals(changeSet.getFilePath())){
							flag=true;
							break;
						}
					}
					if(!flag){
						ChangeLogBDDTO changeLogBDDTO = new ChangeLogBDDTO();
						changeLogBDDTO.setChangeLog(changeSet.getFilePath());
						listaChangeLogBDDTOs.add(changeLogBDDTO);
					}
				}
			}
		}
		return listaChangeLogBDDTOs;
	}
	public static void listar(List<ChangeLogBDDTO> lista){
		for(ChangeLogBDDTO changeLog:lista){
			//System.out.println(changeLog.getChangeLog());
		}
	}
	public static boolean accepts(ChangeSet changeSet) {
		for (RanChangeSet ranChangeSet : ranChangeSets) {
			if (ranChangeSet.getId().equals(changeSet.getId())
					&& ranChangeSet.getAuthor().equals(changeSet.getAuthor())
					&& isPathEquals(changeSet, ranChangeSet)) {
				if (changeSet.shouldAlwaysRun() && ranChangeSet.getLastCheckSum() != null) {
					return true;
				} else if (changeSet.shouldRunOnChange() && !changeSet.generateCheckSum().equals(ranChangeSet.getLastCheckSum())) {
					return true;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	private static boolean isPathEquals(ChangeSet changeSet, RanChangeSet ranChangeSet) {
		if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			return ranChangeSet.getChangeLog().equalsIgnoreCase(changeSet.getFilePath());
		} else {
			return ranChangeSet.getChangeLog().equalsIgnoreCase(changeSet.getFilePath());
		}

	}
	private static ChangeLogIterator getStandardChangelogIterator(String contexts, DatabaseChangeLog changeLog) throws DatabaseException {
		return new ChangeLogIterator(changeLog,
				new ShouldRunChangeSetFilter(db),
				new ContextChangeSetFilter(contexts),
				new DbmsChangeSetFilter(db));
	}
	public static void checkDatabaseChangeLogTable(boolean updateExistingNullChecksums, DatabaseChangeLog databaseChangeLog, String contexts) throws LiquibaseException {
		contexts = StringUtils.trimToNull(contexts);
		if (updateExistingNullChecksums && databaseChangeLog == null) {
			throw new LiquibaseException("changeLog parameter is required if updating existing checksums");
		}
		String[] splitContexts = null;
		if (StringUtils.trimToNull(contexts) != null) {
			splitContexts = contexts.split(",");
		}
		db.checkDatabaseChangeLogTable(updateExistingNullChecksums, databaseChangeLog, splitContexts);
		if (!LockService.getInstance(db).hasChangeLogLock()) {
			db.checkDatabaseChangeLogLockTable();
		}
	}

}
