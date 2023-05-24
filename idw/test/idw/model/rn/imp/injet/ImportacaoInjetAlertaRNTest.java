package idw.model.rn.imp.injet;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbmestres;
import idw.util.IdwLogger;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImportacaoInjetAlertaRNTest {
//	private final IdwLogger log = new IdwLogger("ImportacaoInjetAlertaRNTest");
//	private final int idLog = 1;
//	int identacao
//	DAOGenerico dao
//	DAOGenericoInjet daoInjet
	IdwLogger log = new IdwLogger("ImportacaoInjetAlertaRNTest");
	DAOGenerico dao = new DAOGenerico();
	DAOGenericoInjet daoInjet = new DAOGenericoInjet();
	private ImportacaoInjetRN importacaoInjetAlertaRN = ImportacaoInjetFactory.getInstance(ImportacaoInjetFactory.TipoImportacao.ALERTA, this.log, 0, 0, this.dao, this.daoInjet);
	private final int FLAG_LIGADA = 0;
	private final int FLAG_DESLIGADA = 1;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		this.log = null;
		this.dao = null;
		this.daoInjet = null;
		this.importacaoInjetAlertaRN = null;
	}

	@Test
	public void testIsPrecisaImportarIjtbmestres() {
		Ijtbmestres ijtbmestres = new Ijtbmestres();

		ijtbmestres.setAtualizartabalerta(this.FLAG_LIGADA);
		Assert.assertTrue(this.importacaoInjetAlertaRN.isPrecisaImportar(ijtbmestres));

		ijtbmestres.setAtualizartabalerta(this.FLAG_DESLIGADA);
		Assert.assertFalse(this.importacaoInjetAlertaRN.isPrecisaImportar(ijtbmestres));

	}

	@Test
	public void testIsPrecisaImportarListOfIjtbmestres() {
		List<Ijtbmestres> listIjtbmestres = new ArrayList<Ijtbmestres>();
		listIjtbmestres.add(new Ijtbmestres());
		listIjtbmestres.add(new Ijtbmestres());
		listIjtbmestres.add(new Ijtbmestres());

		// todas as flags ligadas
		for(Ijtbmestres ijtbMestres: listIjtbmestres){
			ijtbMestres.setAtualizartabalerta(this.FLAG_LIGADA);
		}

		Assert.assertTrue(this.importacaoInjetAlertaRN.isPrecisaImportar(listIjtbmestres));

		// todas as flags desliga
		for(Ijtbmestres ijtbMestres: listIjtbmestres){
			ijtbMestres.setAtualizartabalerta(this.FLAG_DESLIGADA);
		}

		Assert.assertFalse(this.importacaoInjetAlertaRN.isPrecisaImportar(listIjtbmestres));

		// Apenas 1 item ativo
		listIjtbmestres.get(1).setAtualizartabalerta(this.FLAG_LIGADA);
		Assert.assertTrue(this.importacaoInjetAlertaRN.isPrecisaImportar(listIjtbmestres));

	}

}
