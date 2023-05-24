package ms.model.rn.importacao.mws;

import idw.model.pojos.mws.Movimento;
import injetws.model.pojos.PrUp;

import java.util.List;

public interface IImportaParaTdba {
	public void importar(List<Movimento> lstMovimento);
}
