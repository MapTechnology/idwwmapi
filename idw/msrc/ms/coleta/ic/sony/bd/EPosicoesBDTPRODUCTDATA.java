package ms.coleta.ic.sony.bd;

public enum EPosicoesBDTPRODUCTDATA {
	DataTime(0),
	Prod_Status(3),
	Machine_Id(4),
	Op_Id(8),
	StamperIdA(22),
	StamperIdB(23),
	StartTimeOp(43),
	FinishTimeOp(45),

	// Adicoes, Ailton
	DDateTime(0),
	ProductionStatus(3),
	MachineID(4),
	ShopOrder(16),
	OrderQuantity(17),
	OrderOKQuantity(75),
	OrderNGQuantity(76),
	RemainOrder(79),
	InjectionShots(144),
	
	//TODO: prever NITEM082(84), // Schwab NG-x(LostMissing)
	
	NITEM198(200), // Schwab NG-1(No Barcode)
	NITEM199(201), // Schwab NG-2(Wr BC,OF,TO,Refl)
	NITEM200(202), // Schwab NG-3(RF Inner,LP Inner)
	NITEM201(203), // Schwab NG-4(HC Defect,Low HC)
	NITEM202(204), // Schwab NG-5(Bright)
	NITEM203(205), // Schwab NG-6(LP Defect)
	NITEM204(206), // Schwab NG-7(Accumulation,BEC,RSER)
	NITEM205(207), // Schwab NG-8(Fibre,Bubble)
	NITEM206(208), // Schwab NG-9(L1 Bump)
	NITEM207(209), // Schwab NG-10(Edge Dev,LP Outer)
	NITEM208(210), // Schwab NG-11(Rad/Tang Tilt)
	NITEM209(211), // Schwab NG-12(Cover+Spacer)
	NITEM210(212), // Schwab NG-13(Scratch,Corr, Surf Fibre)
	NITEM211(213), // Schwab NG-14(Blk Spot,Dark,Incl,Silver)
	NITEM212(214), // Schwab NG-15(Top Defect)
	
	WaitTime(53),
	StopTime(54),
	PreparationTime(55),
	RepairTime(56),
	ErrorTime(57),
	EmergencyTime(58),
	
	NID(537);

	private int posicao;

	EPosicoesBDTPRODUCTDATA(int posicao) {
		this.posicao = posicao;
	}

	public int getValue() {
		return this.posicao;
	}

}
