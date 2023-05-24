package idw.model.pojos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import idw.model.rn.DataHoraRN;

public class DwTAlertaTest {


	@Test
	public void testEqualsObject() {
		DwTAlerta o1 = null;
		DwTAlerta o2 = null;

		Assert.assertEquals(o1, o2);

		o1 = new DwTAlerta();
		Assert.assertNotSame(o1, o2);

		o2 = new DwTAlerta();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());


		o1.setCdTalerta("1");
		o1.setOmTppt(new OmTppt());
		o1.setDsTalerta("j1");
		o1.setStAtivo((byte)1);
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTalerta("1");
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTalerta("j1");
		o2.setStAtivo((byte)1);
		Assert.assertEquals(o1,o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o2.setCdTalerta("2");
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTalerta(o1.getDsTalerta());
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTalerta(o1.getCdTalerta());
		o2.setOmTppt(new OmTppt());
		o2.getOmTppt().setCdTppt("321312");
		o2.setDsTalerta(o1.getDsTalerta());
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTalerta(o1.getCdTalerta());
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTalerta("j2");
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTalerta(o1.getCdTalerta());
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTalerta(o1.getDsTalerta());
		o2.setStAtivo((byte) 0);
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

	}

	@Test
	public void testGetCd() {
		DwTAlerta dwTAlerta = new DwTAlerta();

		dwTAlerta.setCdTalerta("2");

		Assert.assertTrue(dwTAlerta.getCdTalerta().equals(dwTAlerta.getCd()));

	}

	@Test
	public void testGetFieldNameCd() {
		DwTAlerta dwTAlerta = new DwTAlerta();
		Assert.assertTrue(dwTAlerta.getFieldNameCd().equals("CdTalerta"));
	}

	@Test
	public void testSet() {
		DwTAlerta dwTAlerta = new DwTAlerta();

		long idTcau = 0;
		OmTppt omTppt = new OmTppt();
		OmUsr omUsrByIdUsrstativo = new OmUsr();
		OmUsr omUsrByIdUsrrevisao = new OmUsr();
		String cdTcau = "2";
		Long revisao = 1l;
		String dsTcau = "cau1";
		Date dtRevisao = new Date();
		Byte stAtivo = (byte) 1;
		Date dtStativo = new Date();
		dwTAlerta.set(idTcau, omTppt, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, cdTcau, 
				      revisao, dsTcau, dtRevisao, stAtivo, dtStativo, false, false);

		Assert.assertTrue(dwTAlerta.getIdTalerta() == idTcau);
		Assert.assertTrue(dwTAlerta.getOmTppt() == omTppt);
		Assert.assertTrue(dwTAlerta.getOmUsrByIdUsrstativo() == omUsrByIdUsrstativo);
		Assert.assertTrue(dwTAlerta.getOmUsrByIdUsrrevisao() == omUsrByIdUsrrevisao);
		Assert.assertTrue( dwTAlerta.getCdTalerta().equals(cdTcau));
		Assert.assertTrue(dwTAlerta.getRevisao().equals(revisao));
		Assert.assertTrue(dwTAlerta.getDsTalerta().equals(dsTcau));
		Assert.assertTrue(DataHoraRN.equals(dwTAlerta.getDtRevisao(), dtRevisao));
		Assert.assertTrue(dwTAlerta.getStAtivo() == stAtivo);
		Assert.assertTrue(DataHoraRN.equals(dwTAlerta.getDtStativo(), dtStativo));

	}

	@Test
	public void testClone() {
		DwTAlerta o1 = new DwTAlerta();

		long idTcau = 0;
		OmTppt omTppt = new OmTppt();
		OmUsr omUsrByIdUsrstativo = new OmUsr();
		OmUsr omUsrByIdUsrrevisao = new OmUsr();
		String cdTcau = "2";
		Long revisao = 1l;
		String dsTcau = "cau1";
		Date dtRevisao = new Date();
		Byte stAtivo = (byte) 1;
		Date dtStativo = new Date();
		o1.set(idTcau, omTppt, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, cdTcau, 
			   revisao, dsTcau, dtRevisao, stAtivo, dtStativo, false, false);

		DwTAlerta o2 = o1.clone(false);


		Assert.assertTrue(o1.getIdTalerta() == o2.getIdTalerta());
		Assert.assertTrue(o2.getOmTppt() == null);
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTalerta(),o2.getCdTalerta());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTalerta(),o2.getDsTalerta());
		Assert.assertEquals(o1.getDsTalerta(),o2.getDsTalerta());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertTrue(o2.getOmUsrByIdUsrstativo() == null);
		Assert.assertTrue(o2.getOmUsrByIdUsrrevisao() == null);

		o2 = o1.clone(true);

		Assert.assertTrue(o1.getIdTalerta() == o2.getIdTalerta());
		Assert.assertTrue(o1.getOmTppt().getIdTppt() == o2.getOmTppt().getIdTppt());
		Assert.assertEquals(o1.getOmTppt().getCdTppt(),o2.getOmTppt().getCdTppt());
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTalerta(),o2.getCdTalerta());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTalerta(),o2.getDsTalerta());
		Assert.assertEquals(o1.getDsTalerta(),o2.getDsTalerta());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertEquals(o1.getOmUsrByIdUsrstativo().getCdUsr(),o2.getOmUsrByIdUsrstativo().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrstativo().getIdUsr() == o2.getOmUsrByIdUsrstativo().getIdUsr());
		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao().getCdUsr(),o2.getOmUsrByIdUsrrevisao().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrrevisao().getIdUsr() == o2.getOmUsrByIdUsrrevisao().getIdUsr());
	}

}
