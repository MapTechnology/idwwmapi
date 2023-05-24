package idw.model.pojos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import idw.model.rn.DataHoraRN;

public class DwTJustTest {


	@Test
	public void testEqualsObject() {
		DwTJust o1 = null;
		DwTJust o2 = null;

		Assert.assertEquals(o1, o2);

		o1 = new DwTJust();
		Assert.assertNotSame(o1, o2);

		o2 = new DwTJust();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());


		o1.setCdTjust("1");
		o1.setOmTppt(new OmTppt());
		o1.setDsTjust("j1");
		o1.setStAtivo((byte)1);
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTjust("1");
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTjust("j1");
		o2.setStAtivo((byte)1);
		Assert.assertEquals(o1,o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o2.setCdTjust("2");
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTjust(o1.getDsTjust());
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTjust(o1.getCdTjust());
		o2.setOmTppt(new OmTppt());
		o2.getOmTppt().setCdTppt("321312");
		o2.setDsTjust(o1.getDsTjust());
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTjust(o1.getCdTjust());
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTjust("j2");
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTjust(o1.getCdTjust());
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTjust(o1.getDsTjust());
		o2.setStAtivo((byte) 0);
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

	}

	@Test
	public void testGetCd() {
		DwTJust dwTJust = new DwTJust();

		dwTJust.setCdTjust("2");

		Assert.assertTrue(dwTJust.getCdTjust().equals(dwTJust.getCd()));

	}

	@Test
	public void testGetFieldNameCd() {
		DwTJust dwTJust = new DwTJust();
		Assert.assertTrue(dwTJust.getFieldNameCd().equals("CdTjust"));
	}

	@Test
	public void testSet() {
		DwTJust dwTJust = new DwTJust();

		long idTjust = 0;
		OmTppt omTppt = new OmTppt();
		OmUsr omUsrByIdUsrstativo = new OmUsr();
		OmUsr omUsrByIdUsrrevisao = new OmUsr();
		String cdTjust = "2";
		Long revisao = 1l;
		String dsTjust = "just1";
		Date dtRevisao = new Date();
		Byte stAtivo = (byte) 1;
		Date dtStativo = new Date();
		dwTJust.set(idTjust, omTppt, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, cdTjust, revisao, dsTjust, dtRevisao, stAtivo, dtStativo);

		Assert.assertTrue(dwTJust.getIdTjust() == idTjust);
		Assert.assertTrue(dwTJust.getOmTppt() == omTppt);
		Assert.assertTrue(dwTJust.getOmUsrByIdUsrstativo() == omUsrByIdUsrstativo);
		Assert.assertTrue(dwTJust.getOmUsrByIdUsrrevisao() == omUsrByIdUsrrevisao);
		Assert.assertTrue( dwTJust.getCdTjust().equals(cdTjust));
		Assert.assertTrue(dwTJust.getRevisao().equals(revisao));
		Assert.assertTrue(dwTJust.getDsTjust().equals(dsTjust));
		Assert.assertTrue(DataHoraRN.equals(dwTJust.getDtRevisao(), dtRevisao));
		Assert.assertTrue(dwTJust.getStAtivo() == stAtivo);
		Assert.assertTrue(DataHoraRN.equals(dwTJust.getDtStativo(), dtStativo));

	}

	@Test
	public void testClone() {
		DwTJust o1 = new DwTJust();

		long idTjust = 0;
		OmTppt omTppt = new OmTppt();
		OmUsr omUsrByIdUsrstativo = new OmUsr();
		OmUsr omUsrByIdUsrrevisao = new OmUsr();
		String cdTjust = "2";
		Long revisao = 1l;
		String dsTjust = "just1";
		Date dtRevisao = new Date();
		Byte stAtivo = (byte) 1;
		Date dtStativo = new Date();
		o1.set(idTjust, omTppt, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, cdTjust, revisao, dsTjust, dtRevisao, stAtivo, dtStativo);

		DwTJust o2 = o1.clone(false);


		Assert.assertTrue(o1.getIdTjust() == o2.getIdTjust());
		Assert.assertTrue(o2.getOmTppt() == null);
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTjust(),o2.getCdTjust());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTjust(),o2.getDsTjust());
		Assert.assertEquals(o1.getDsTjust(),o2.getDsTjust());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertTrue(o2.getOmUsrByIdUsrstativo() == null);
		Assert.assertTrue(o2.getOmUsrByIdUsrrevisao() == null);

		o2 = o1.clone(true);

		Assert.assertTrue(o1.getIdTjust() == o2.getIdTjust());
		Assert.assertTrue(o1.getOmTppt().getIdTppt() == o2.getOmTppt().getIdTppt());
		Assert.assertEquals(o1.getOmTppt().getCdTppt(),o2.getOmTppt().getCdTppt());
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTjust(),o2.getCdTjust());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTjust(),o2.getDsTjust());
		Assert.assertEquals(o1.getDsTjust(),o2.getDsTjust());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertEquals(o1.getOmUsrByIdUsrstativo().getCdUsr(),o2.getOmUsrByIdUsrstativo().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrstativo().getIdUsr() == o2.getOmUsrByIdUsrstativo().getIdUsr());
		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao().getCdUsr(),o2.getOmUsrByIdUsrrevisao().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrrevisao().getIdUsr() == o2.getOmUsrByIdUsrrevisao().getIdUsr());
	}

}
