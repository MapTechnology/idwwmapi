package ms.coleta.ic.sony.dvd;

public enum EPosicoesDVDLog {
	DateTime(0),
	ToteID(1), // ?
	OrderOKQuantity(3),
	OKQuantity(4),
	ShopOrder(5),
	OrderQuantity(6);

	private int posicao;

	EPosicoesDVDLog(int posicao) {
		this.posicao = posicao;
	}

	public int getValue() {
		return this.posicao;
	}

}
