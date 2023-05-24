package idw.webservices.dto;

import liquibase.changelog.ChangeLogParameters;
import liquibase.database.Database;
import liquibase.resource.ResourceAccessor;

public class ManipularChangeLogsDTO {

	private String changeLogFile;
	private ResourceAccessor resourceAccessor;
	private ChangeLogParameters changeLogParameters; 
	private String contexts;
	private Database database;
	public String getChangeLogFile() {
		return changeLogFile;
	}
	public void setChangeLogFile(String changeLogFile) {
		this.changeLogFile = changeLogFile;
	}
	public ResourceAccessor getResourceAccessor() {
		return resourceAccessor;
	}
	public void setResourceAccessor(ResourceAccessor resourceAccessor) {
		this.resourceAccessor = resourceAccessor;
	}
	public ChangeLogParameters getChangeLogParameters() {
		return changeLogParameters;
	}
	public void setChangeLogParameters(ChangeLogParameters changeLogParameters) {
		this.changeLogParameters = changeLogParameters;
	}
	public String getContexts() {
		return contexts;
	}
	public void setContexts(String contexts) {
		this.contexts = contexts;
	}
	public Database getDatabase() {
		return database;
	}
	public void setDatabase(Database database) {
		this.database = database;
	}

}
