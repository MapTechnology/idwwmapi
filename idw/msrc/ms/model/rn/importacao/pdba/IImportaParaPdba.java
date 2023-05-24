package ms.model.rn.importacao.pdba;

import java.util.List;

import injetws.model.pojos.PrUp;

public interface IImportaParaPdba {
	public void importar(List<PrUp> listaPrup);
}
