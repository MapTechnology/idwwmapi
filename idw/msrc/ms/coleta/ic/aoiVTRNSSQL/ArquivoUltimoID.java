package ms.coleta.ic.aoiVTRNSSQL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import ms.model.dto.IcDTO;
import ms.util.ConversaoTipos;

public class ArquivoUltimoID {

	private final String dir;

	public ArquivoUltimoID(String dir) {
		super();
		this.dir = dir;
	}

	Map<String, IDDTO> ultimosIDs = new HashMap<>();

	public BigDecimal getUltimoID(String cdposto) {
		BigDecimal retorno = BigDecimal.ZERO;

		if (ultimosIDs.containsKey(cdposto))
			retorno = ultimosIDs.get(cdposto).getId();
		else {
			IDDTO dto = new IDDTO();
			dto.setId(BigDecimal.ZERO);
			dto.setReferencia(null);
			ultimosIDs.put(cdposto, dto);
		}

		return retorno;
	}

	public void loadUltimoID(IcDTO icdto) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(this.dir + "/" + icdto.getCd_ic() + ".properties"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		IDDTO dto = new IDDTO();
		for (String key : properties.stringPropertyNames()) {

			if (key.equals("id"))
				dto.setId(ConversaoTipos.converteParaBigDecimal(properties.get(key).toString()));
			else
				dto.setReferencia(properties.getProperty(key));

		}
		System.out.println("leitura ultimoID para " + icdto.getCd_ic() + " onde dto.id=" + dto.getId());
		this.ultimosIDs.put(icdto.getMsIcUpDTOLocais().get(0).getUpDTO().getCd_up(), dto);
	}

	public void saveUltimoID(IcDTO icdto) {
		Properties properties = new Properties();

		for (Map.Entry<String, IDDTO> entry : this.ultimosIDs.entrySet()) {
			properties.put("id", ConversaoTipos.converteParaString(entry.getValue().getId(), 0));
			properties.put("referencia", entry.getValue().getReferencia());
		}

		try {
			properties.store(new FileOutputStream(this.dir + "/" + icdto.getCd_ic() + ".properties"), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setUltimoID(String cdposto, BigDecimal id) {
		IDDTO dto;
		if (ultimosIDs.containsKey(cdposto))
			dto = ultimosIDs.get(cdposto);
		else
			dto = new IDDTO();

		dto.setId(id);
		ultimosIDs.put(cdposto, dto);
	}

	public boolean isAnoMesReferencia(String cdposto, String ano, String mes) {
		if (this.ultimosIDs.containsKey(cdposto)) {
			IDDTO dto = this.ultimosIDs.get(cdposto);
			String referencia = ano + mes;
			if (dto.getReferencia() != null && dto.getReferencia().equals(referencia))
				return true;
			else
				System.out.println("dto.getReferencia = " + dto.getReferencia() + " = " + referencia);
		} else
			System.out.println("nao contem " + cdposto);
		
		return false;
	}

	public void setAnoMesReferencia(String cdposto, String ano, String mes) {
		IDDTO dto;
		if (this.ultimosIDs.containsKey(cdposto)) {
			dto = this.ultimosIDs.get(cdposto);
		} else {
			dto = new IDDTO();
			dto.setId(BigDecimal.ZERO);
		}

		dto.setReferencia(ano + mes);
		this.ultimosIDs.put(cdposto, dto);

	}

	private class IDDTO {
		private BigDecimal id;
		private String referencia;

		public BigDecimal getId() {
			return id;
		}

		public void setId(BigDecimal id) {
			this.id = id;
		}

		public String getReferencia() {
			return referencia;
		}

		public void setReferencia(String referencia) {
			this.referencia = referencia;
		}

	}

}
