package idw.webservices.rest;

import javax.ws.rs.core.MediaType;

public final class ResourceUtils {	
	
	public static final String MEDIA_TYPE_JSON_UTF8 = MediaType.APPLICATION_JSON + ";charset=utf-8";
//	private static final String ERROR_ELEMENT = "error";
//	
//	public static ErrorDTO createErrorDTO(Status tp, String msg, String stacktrace) {
//		ErrorDTO errorDTO = new ErrorDTO(tp.getStatusCode(), msg, stacktrace);
//		return errorDTO;
//	}
//
//	public static void addErrorElementIfExists(JsonObject rootElement, Status responseStatus, Throwable e) {
//		Gson gson = new Gson();
//		String stacktrace = (responseStatus.equals(Response.Status.INTERNAL_SERVER_ERROR) ?
//				ErrorUtils.getStackTraceString(e) :
//				"");		
//		ErrorDTO errorDTO = new ErrorDTO(responseStatus.getStatusCode(), e.getMessage(), stacktrace);
//		rootElement.add(ERROR_ELEMENT, gson.toJsonTree(errorDTO));
//	}
//	
//	public static Response createResponseFromException(JsonObject rootElement, Exception e) {
//		int responseStatus;
//		if (e instanceof WebApplicationException) {
//			responseStatus = ((WebApplicationException) e).getResponse().getStatus();
//		} else {
//			responseStatus = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
//		}
//		e.printStackTrace();
//		
//		ResourceUtils.addErrorElementIfExists(rootElement, Status.fromStatusCode(responseStatus), e);
//		String json = new Gson().toJson(rootElement);
//		return Response.status(responseStatus).entity(json).build();
//	}
	
	
}
