package idw.webservices.rest.dto.monitorizacao.injet.manutencao;

import java.util.List;

public class DetalheCheckListDTO {
	private int sequencia;
	private int nivel;
	private int stObrigatorio;
	private TarefaManutDTO tarefa;
	private List<DetalheCheckListDTO> tarefasFilhas;
	
	public int getSequencia() {
		return sequencia;
	}
	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getStObrigatorio() {
		return stObrigatorio;
	}
	public void setStObrigatorio(int stObrigatorio) {
		this.stObrigatorio = stObrigatorio;
	}
	public TarefaManutDTO getTarefa() {
		return tarefa;
	}
	public void setTarefa(TarefaManutDTO tarefa) {
		this.tarefa = tarefa;
	}
	public List<DetalheCheckListDTO> getTarefasFilhas() {
		return tarefasFilhas;
	}
	public void setTarefasFilhas(List<DetalheCheckListDTO> tarefasFilhas) {
		this.tarefasFilhas = tarefasFilhas;
	}
	
}
