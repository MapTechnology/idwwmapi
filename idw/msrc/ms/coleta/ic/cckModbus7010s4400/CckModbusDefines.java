package ms.coleta.ic.cckModbus7010s4400;


public class CckModbusDefines {
	
	
	public static int _VERSAODRIVER = 1;
	public static int BASE = 1024; //Base holding registers
	public static int SIZE = 123; //Base holding registers
	public static int  i_VERSAO = 0;	//1024 FLOAT Versão de Firmware V secundário
	public static int  i_TENSAOFN_R = 1;//1026 FLOAT Tensão Fase Neutro R V secundário
	public static int  i_TENSAOFN_S = 2;//1028 FLOAT Tensão Fase Neutro S V secundário
	public static int  i_TENSAOFN_T = 3;//1030 FLOAT Tensão Fase Neutro T V secundário
	public static int  i_TENSAOFN_M = 4;//1032 FLOAT Tensão Fase Neutro Média V secundário
	public static int  i_TENSAOFF_RS = 5;//1034 FLOAT Tensão Fase Fase RS V secundário
	public static int  i_TENSAOFF_ST = 6;//1036 FLOAT Tensão Fase Fase ST V secundário
	public static int  i_TENSAOFF_TR = 7;//1038 FLOAT Tensão Fase Fase TR V secundário
	public static int  i_TENSAOFF_M = 8;//1040 FLOAT Tensão Fase Fase Média V secundário
	public static int  i_CORRENTE_R = 9;//1042 FLOAT Corrente Fase R A secundário
	public static int  i_CORRENTE_S = 10;//1044 FLOAT Corrente Fase S A secundário
	public static int  i_CORRENTE_T = 11;//1046 FLOAT Corrente Fase T A secundário
	public static int  i_CORRENTE_M = 12;//1048 FLOAT Corrente Média A secundário
	public static int  i_PA_R = 13;//1050 FLOAT Potência Ativa Fase R W secundário
	public static int  i_PA_S = 14;//1052 FLOAT Potência Ativa Fase T W secundário
	public static int  i_PA_T = 15;//1054 FLOAT Potência Ativa Fase S W secundário
	public static int  i_PA_TT = 16;//1056 FLOAT Potência Ativa Total W secundário
	public static int  i_PR_R = 17;//1058 FLOAT Potência Reativa Fase R VAr secundário
	public static int  i_PR_S = 18;//1060 FLOAT Potência Reativa Fase S VAr secundário
	public static int  i_PR_T = 19;//1062 FLOAT Potência Reativa Fase T VAr secundário
	public static int  i_PR_TT = 20;//1064 FLOAT Potência Reativa Total VAr secundário
	public static int  i_PAP_R = 21;//1066 FLOAT Potência Aparente Fase R VA secundário
	public static int  i_PAP_S = 22;//1068 FLOAT Potência Aparente Fase S VA secundário
	public static int  i_PAP_T = 23;//1070 FLOAT Potência Aparente Fase T VA secundário
	public static int  i_PAP_TT = 24;//1072 FLOAT Potência Aparente Total VA secundário
	public static int  i_FP_R = 25;//1074 FLOAT Fator de Potência Fase R
	public static int  i_FP_S = 26;//1076 FLOAT Fator de Potência Fase S
	public static int  i_FP_T = 27;//1078 FLOAT Fator de Potência Fase T
	public static int  i_FP_TT = 28;//1080 FLOAT Fator de Potência Total
	public static int  i_FREQ = 29;//1082 FLOAT Frequência Hz
	public static int  i_CONSUMO_Rk = 30;//1084 FLOAT Consumo Fase R kWh
	public static int  i_CONSUMO_Rm = 31;//1086 FLOAT Consumo Fase R mWh
	public static int  i_CONSUMO_Sk = 32;//1088 FLOAT Consumo Fase S kWh
	public static int  i_CONSUMO_Sm = 33;//1090 FLOAT Consumo Fase S mWh
	public static int  i_CONSUMO_Tk = 34;//1092 FLOAT Consumo Fase T kWh
	public static int  i_CONSUMO_Tm = 35;//1094 FLOAT Consumo Fase T mWh
	public static int  i_CONSUMO_TTk = 36;//1096 FLOAT Consumo Total kWh
	public static int  i_CONSUMO_TTm = 37;//1098 FLOAT Consumo Total mWh
	public static int  i_EFk = 38;//1100 FLOAT Energia Fornecida Total kWh
	public static int  i_EFm = 39;//1102 FLOAT Energia Fornecida Total mWh
	public static int  i_ERIQ4k = 40;//1104 FLOAT Energia Reativa Indutiva Q4 kWh
	public static int  i_ERIQ4m = 41;//1106 FLOAT Energia Reativa Indutiva Q4 mWh	
	public static int  i_ERCQ1k = 42;//1108 FLOAT Energia Reativa Capacitiva Q1 kWh
	public static int  i_ERCQ1m = 43;//1110 FLOAT Energia Reativa Capacitiva Q1 mWh
	public static int  i_ERQ2k = 44;//1112 FLOAT Energia Reativa Q2 kWh
	public static int  i_ERQ2m = 45;//1114 FLOAT Energia Reativa Q2 mWh
	public static int  i_ERQ3k = 46;//1116 FLOAT Energia Reativa Q3 kWh
	public static int  i_ERQ3m = 47;//1118 FLOAT Energia Reativa Q3 mWh
	public static int  i_AngFaseR = 48;//1120 FLOAT Ângulo de Tensão e Corrente Fase R graus
	public static int  i_AngFaseS = 49;//1122 FLOAT Ângulo de Tensão e Corrente Fase S graus
	public static int  i_AngFaseT = 50;//1124 FLOAT Ângulo de Tensão e Corrente Fase T graus
	public static int  i_AngTFaseR = 51;//1126 FLOAT Ângulo de Tensão Fase R graus
	public static int  i_AngTFaseS = 52;//1128 FLOAT Ângulo de Tensão Fase S graus
	public static int  i_AngTFaseT = 53;//1130 FLOAT Ângulo de Tensão Fase T graus
	public static int  i_DistorcaoHarmTensaoR = 54;//1132 FLOAT Distorção Harmônica de Tensão Fase R percentual
	public static int  i_DistorcaoHarmTensaoS = 55;//1134 FLOAT Distorção Harmônica de Tensão Fase S percentual
	public static int  i_DistorcaoHarmTensaoT = 56;//1136 FLOAT Distorção Harmônica de Tensão Fase T percentual
	public static int  i_DistorcaoHarmCorrenteR = 57;//1138 FLOAT Distorção Harmônica de Corrente Fase R percentual
	public static int  i_DistorcaoHarmCorrenteS = 58;//1140 FLOAT Distorção Harmônica de Corrente Fase S percentual
	public static int  i_DistorcaoHarmCorrenteT = 59;//1142 FLOAT Distorção Harmônica de Corrente Fase T percentual
	//1144 FLOAT Reservado -
	//1146 FLOAT Reservado -
	//
	//512 FLOAT Número de Elementos 0=3 elementos ,1=1 elemento ,2=2 elementos
	//514 FLOAT Modo de Ligação 0=fase-neutro ,1=fase-fase
	//516 FLOAT Tensão de Secundário para Sag volts
	//518 FLOAT Tensão de Secundário para Swell volts
	//520 FLOAT Corrente para evento de Sobrecorrente ampéres
	//522 FLOAT Tempo de Pre Trigger para eventos segundos
	//524 FLOAT Saida 4 a 20mA mA/W (secundário)
	//526 FLOAT Saida de Pulso Wh (secundário) / Pulso
	//528 FLOAT Ciclos para Sag e Swell número de ciclos (180)
	//530 FLOAT não usado -
	//532 FLOAT Primário do TP volts
	//534 FLOAT Secundário do TP volts
	//536 FLOAT Primário do TC ampéres
	//538 DWORD RTU 1 a 254
	//540 DWORD Velocidade 1=4800 ,2=9600 ,3=19200 ,4=38400
	//4096 FLOAT Valor RMS da Fundamental I secundário
	//4098 FLOAT Harmônica de Corrente Fase R de 2a. Ordem percentual
	//4100 FLOAT Harmônica de Corrente Fase R de 3a. Ordem percentual
	//... FLOAT Harmônica de Corrente Fase R de n Ordem percentual
	//4192 FLOAT Harmônica de Corrente Fase R de 49a. Ordem percentual
	//4296 FLOAT Valor RMS da Fundamental I secundário
	//4298 FLOAT Harmônica de Corrente Fase S de 2a. Ordem percentual
	//4300 FLOAT Harmônica de Corrente Fase S de 3a. Ordem percentual
	//... FLOAT Harmônica de Corrente Fase S de n Ordem percentual
	//4396 FLOAT Harmônica de Corrente Fase S de 49a. Ordem percentual
	//4496 FLOAT Valor RMS da Fundamental I secundário
	//4498 FLOAT Harmônica de Corrente Fase T de 2a. Ordem percentual
	//4500 FLOAT Harmônica de Corrente Fase T de 3a. Ordem percentual
	//... FLOAT Harmônica de Corrente Fase T de n Ordem percentual
	//4596 FLOAT Harmônica de Corrente Fase T de 49a. Ordem percentual
	//4696 FLOAT Valor RMS da Fundamental V secundário
	//4698 FLOAT Harmônica de Tensão Fase R de 2a. Ordem percentual
	//4700 FLOAT Harmônica de Tensão Fase R de 3a. Ordem percentual
	//... FLOAT Harmônica de Tensão Fase R de n Ordem percentual
	//4796 FLOAT Harmônica de Tensão Fase R de 49a. Ordem percentual
	//4896 FLOAT Valor RMS da Fundamental V secundário
	//4898 FLOAT Harmônica de Tensão Fase S de 2a. Ordem percentual
	//4900 FLOAT Harmônica de Tensão Fase S de 3a. Ordem percentual
	//... FLOAT Harmônica de Tensão Fase S de n Ordem percentual
	//4996 FLOAT Harmônica de Tensão Fase S de 49a. Ordem percentual
	//5096 FLOAT Valor RMS da Fundamental V secundário
	//5098 FLOAT Harmônica de Tensão Fase T de 2a. Ordem percentual
	//5100 FLOAT Harmônica de Tensão Fase T de 3a. Ordem percentual
	//... FLOAT Harmônica de Tensão Fase T de n Ordem percentual
	//5196 FLOAT Harmônica de Tensão Fase T de 49a. Ordem percentual
}

