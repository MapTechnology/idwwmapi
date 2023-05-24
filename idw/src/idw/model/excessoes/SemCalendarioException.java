package idw.model.excessoes;

@SuppressWarnings("serial")
public class SemCalendarioException extends Exception {
	
	private String msg = "Sem calendário exception";
	
	public SemCalendarioException(){
		
	}
	
	public SemCalendarioException(String msg){
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return (msg == null? super.getMessage():msg);
	}
		
	
}
