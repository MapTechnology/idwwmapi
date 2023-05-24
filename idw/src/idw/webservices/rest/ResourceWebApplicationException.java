package idw.webservices.rest;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import idw.util.ErrorUtils;
import idw.webservices.dto.ErrorDTO;

public class ResourceWebApplicationException extends WebApplicationException{

	private static final long serialVersionUID = 1L;
	private static final String ERROR_ELEMENT = "error";

	private String msg;
	public ResourceWebApplicationException(Response.Status status, String msg) {
		super(status);
		this.msg = msg;		
	}
	
	public ResourceWebApplicationException(JsonObject rootElement, Exception e) {
		super(e, createResponseFromException(rootElement, e));
	}
	
	public ResourceWebApplicationException(Response.Status status, ErrorDTO errorDTO) {
		super(createResponse(status, errorDTO));
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
	
	private static Response createResponseFromException(JsonObject rootElement, Exception e) {
		int responseStatus;
		if (e instanceof WebApplicationException) {
			responseStatus = ((WebApplicationException) e).getResponse().getStatus();
		} else {
			responseStatus = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
		}
		e.printStackTrace();
		
		addErrorElementIfExists(rootElement, Status.fromStatusCode(responseStatus), e);
		String json = new Gson().toJson(rootElement);
		return Response.status(responseStatus).entity(json).build();
	}
	
	private static void addErrorElementIfExists(JsonObject rootElement, Status responseStatus, Throwable e) {
		Gson gson = new Gson();
		String stacktrace = (responseStatus.equals(Response.Status.INTERNAL_SERVER_ERROR) ?
				ErrorUtils.getStackTraceString(e) :
				"");		
		ErrorDTO errorDTO = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), stacktrace);
		rootElement.add(ERROR_ELEMENT, gson.toJsonTree(errorDTO));
	}
	
	private static Response createResponse(Response.Status status, ErrorDTO errorDTO) {
		JsonObject rootElement = new JsonObject();
		Gson gson = new Gson();
		rootElement.add(ERROR_ELEMENT, gson.toJsonTree(errorDTO));
		String json = new Gson().toJson(rootElement);
		return Response.status(status).entity(json).build();
	}
}
