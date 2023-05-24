package idw.webservices.dto;

public class ErrorDTO {
	private long code;
	private String message;
	private String stacktrace;
	
	public ErrorDTO() {		
	}
	
	public ErrorDTO(long code, String message, String stacktrace) {	
		this.code = code;
		this.message = message;
		this.stacktrace = stacktrace;
	}
	
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}
	
}
