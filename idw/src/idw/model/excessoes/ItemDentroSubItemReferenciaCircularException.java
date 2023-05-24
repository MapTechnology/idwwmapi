package idw.model.excessoes;

@SuppressWarnings("serial")
public class ItemDentroSubItemReferenciaCircularException extends Exception{
	public ItemDentroSubItemReferenciaCircularException(){		
	}
	public ItemDentroSubItemReferenciaCircularException(String message) {
		super(message);
	}
}
