package idw.model.rn.integracao.semptoshiba.trilha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import idw.model.rn.DataHoraRN;

public class LinhaImportacaoTrilhaDTO {
	private List<String> campos;
	
	public LinhaImportacaoTrilhaDTO(String linha) {
		this.campos = new ArrayList<String>(Arrays.asList(linha.split(";")) );
	}
	
	public String getMaquina() {
		return campos.get(1).replaceAll("\"", "");
	}
	public String getSemiacabado() {
		return campos.get(2).replaceAll("\"", "");
	}
	public Date getDthrInicio() {
		return DataHoraRN.stringToDate(campos.get(3).replaceAll("\"", ""), "dd/MM/yyyy HH:mm:ss");
	}

	public Date getDthrFim() {
		return DataHoraRN.stringToDate(campos.get(4).replaceAll("\"", ""), "dd/MM/yyyy HH:mm:ss");
	}

	public double getQuantidade() {
		return Double.valueOf(campos.get(5).replaceAll("\"", ""));
	}
	public String getNroDoc() {
		return campos.get(6).replaceAll("\"", "");
	}
}
