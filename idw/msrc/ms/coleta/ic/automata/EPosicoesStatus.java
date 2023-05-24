package ms.coleta.ic.automata;

public enum EPosicoesStatus {
	ALARME_EM_ANDAMENTO(0),
	INICIO_DE_CICLO(1),
	MAQUINA_EM_AMBIENTE_MANUTENCAO(2),
	INICIO_DE_INJECAO(3);

	private int posicao;

	EPosicoesStatus(int posicao) {
		this.posicao = posicao;
	}

	public int getValue() {
		return this.posicao;
	}

}
