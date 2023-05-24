package ms.coleta.ic.sony.bd;

public enum EPosicoesBDTALARM {
	DSTARTDATETIME(0),
	DENDDATETIME(1),
	SSTATUS(3),
	SALARMCODE(4),
	SSUBCODE(5),
	SAREANAME(6),
	SUNITNAME(7),
	SALARMMESSAGE(8),
	NCOLOR(9),
	NTROUBLE(10),
	SSHOPORDERNUMBER(11),
	SBUCKETNUMBER(12),
	SLOTNUMBER(13),
	SIDUSERIALNUMBER(14),
	SMACHINEID(15),
	DDATETIMEREADPLAS(16),
	NSHOTS(17),
	NRUNORSTOP(18),
	SFCTRANSMIT(19);

	private int posicao;

	EPosicoesBDTALARM(int posicao) {
		this.posicao = posicao;
	}

	public int getValue() {
		return this.posicao;
	}

}
