package idw.model.pojos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import idw.model.rn.DataHoraRN;

public class DwTCausaTest {


	@Test
	public void testEqualsObject() {
		DwTCausa o1 = null;
		DwTCausa o2 = null;

		Assert.assertEquals(o1, o2);

		o1 = new DwTCausa();
		Assert.assertNotSame(o1, o2);

		o2 = new DwTCausa();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());


		o1.setCdTcausa("1");
		o1.setOmTppt(new OmTppt());
		o1.setDsTcausa("j1");
		o1.setStAtivo((byte)1);
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTcausa("1");
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTcausa("j1");
		o2.setStAtivo((byte)1);
		Assert.assertEquals(o1,o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o2.setCdTcausa("2");
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTcausa(o1.getDsTcausa());
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTcausa(o1.getCdTcausa());
		o2.setOmTppt(new OmTppt());
		o2.getOmTppt().setCdTppt("321312");
		o2.setDsTcausa(o1.getDsTcausa());
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTcausa(o1.getCdTcausa());
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTcausa("j2");
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTcausa(o1.getCdTcausa());
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTcausa(o1.getDsTcausa());
		o2.setStAtivo((byte) 0);
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

	}

	@Test
	public void testGetCd() {
		DwTCausa dwTCausa = new DwTCausa();

		dwTCausa.setCdTcausa("2");

		Assert.assertTrue(dwTCausa.getCdTcausa().equals(dwTCausa.getCd()));

	}

	@Test
	public void testGetFieldNameCd() {
		DwTCausa dwTCausa = new DwTCausa();
		Assert.assertTrue(dwTCausa.getFieldNameCd().equals("CdTcausa"));
	}

	@Test
	public void testSet() {
		DwTCausa dwTCausa = new DwTCausa();

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
		dwTCausa.set(idTcau, omTppt, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, cdTcau, revisao, dsTcau, dtRevisao, stAtivo, dtStativo);

		Assert.assertTrue(dwTCausa.getIdTcausa() == idTcau);
		Assert.assertTrue(dwTCausa.getOmTppt() == omTppt);
		Assert.assertTrue(dwTCausa.getOmUsrByIdUsrstativo() == omUsrByIdUsrstativo);
		Assert.assertTrue(dwTCausa.getOmUsrByIdUsrrevisao() == omUsrByIdUsrrevisao);
		Assert.assertTrue( dwTCausa.getCdTcausa().equals(cdTcau));
		Assert.assertTrue(dwTCausa.getRevisao().equals(revisao));
		Assert.assertTrue(dwTCausa.getDsTcausa().equals(dsTcau));
		Assert.assertTrue(DataHoraRN.equals(dwTCausa.getDtRevisao(), dtRevisao));
		Assert.assertTrue(dwTCausa.getStAtivo() == stAtivo);
		Assert.assertTrue(DataHoraRN.equals(dwTCausa.getDtStativo(), dtStativo));

	}

	@Test
	public void testClone() {
		DwTCausa o1 = new DwTCausa();

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
		o1.set(idTcau, omTppt, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, cdTcau, revisao, dsTcau, dtRevisao, stAtivo, dtStativo);

		DwTCausa o2 = o1.clone(false);


		Assert.assertTrue(o1.getIdTcausa() == o2.getIdTcausa());
		Assert.assertTrue(o2.getOmTppt() == null);
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTcausa(),o2.getCdTcausa());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTcausa(),o2.getDsTcausa());
		Assert.assertEquals(o1.getDsTcausa(),o2.getDsTcausa());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertTrue(o2.getOmUsrByIdUsrstativo() == null);
		Assert.assertTrue(o2.getOmUsrByIdUsrrevisao() == null);


		o2 = o1.clone(true);

		Assert.assertTrue(o1.getIdTcausa() == o2.getIdTcausa());
		Assert.assertTrue(o1.getOmTppt().getIdTppt() == o2.getOmTppt().getIdTppt());
		Assert.assertEquals(o1.getOmTppt().getCdTppt(),o2.getOmTppt().getCdTppt());
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTcausa(),o2.getCdTcausa());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTcausa(),o2.getDsTcausa());
		Assert.assertEquals(o1.getDsTcausa(),o2.getDsTcausa());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertEquals(o1.getOmUsrByIdUsrstativo().getCdUsr(),o2.getOmUsrByIdUsrstativo().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrstativo().getIdUsr() == o2.getOmUsrByIdUsrstativo().getIdUsr());
		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao().getCdUsr(),o2.getOmUsrByIdUsrrevisao().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrrevisao().getIdUsr() == o2.getOmUsrByIdUsrrevisao().getIdUsr());
	}

}
