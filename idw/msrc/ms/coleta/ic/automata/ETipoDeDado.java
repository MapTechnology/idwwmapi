package ms.coleta.ic.automata;

public enum ETipoDeDado {
	STATUS_DA_MAQUINA("Status"),
	DADOS_DO_PROCESSO("SPC"),
	ALARME("Alarm"),
	CODIGO_DE_PARADA("Code");

	private String label;

	ETipoDeDado(String label) {
		this.label = label;
	}

	public String getValue() {
		return this.label;
	}

}
