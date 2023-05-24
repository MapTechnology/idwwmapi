package ms.excessao;

@SuppressWarnings("serial")
public class AndonFalhouException extends Exception {
	Exception e;
	public AndonFalhouException(Exception e) {
		this.e = e;
	}
}
