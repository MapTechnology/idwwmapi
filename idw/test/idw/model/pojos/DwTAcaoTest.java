package idw.model.pojos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import idw.model.rn.DataHoraRN;

public class DwTAcaoTest {

	@Test
	public void testEqualsObject() {
		DwTAcao o1 = null;
		DwTAcao o2 = null;

		Assert.assertEquals(o1, o2);

		o1 = new DwTAcao();
		Assert.assertNotSame(o1, o2);

		o2 = new DwTAcao();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());


		o1.setCdTacao("1");
		o1.setOmTppt(new OmTppt());
		o1.setDsTacao("j1");
		o1.setStAtivo((byte)1);
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTacao("1");
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTacao("j1");
		o2.setStAtivo((byte)1);
		Assert.assertEquals(o1,o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o2.setCdTacao("2");
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTacao(o1.getDsTacao());
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTacao(o1.getCdTacao());
		o2.setOmTppt(new OmTppt());
		o2.getOmTppt().setCdTppt("321312");
		o2.setDsTacao(o1.getDsTacao());
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTacao(o1.getCdTacao());
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTacao("j2");
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdTacao(o1.getCdTacao());
		o2.setOmTppt(o1.getOmTppt());
		o2.setDsTacao(o1.getDsTacao());
		o2.setStAtivo((byte) 0);
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

	}

	@Test
	public void testGetCd() {
		DwTAcao dwTAcao = new DwTAcao();

		dwTAcao.setCdTacao("2");

		Assert.assertTrue(dwTAcao.getCdTacao().equals(dwTAcao.getCd()));

	}

	@Test
	public void testGetFieldNameCd() {
		DwTAcao dwTAcao = new DwTAcao();
		Assert.assertTrue(dwTAcao.getFieldNameCd().equals("CdTacao"));
	}

	@Test
	public void testSet() {
		DwTAcao dwTAcao = new DwTAcao();

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
		dwTAcao.set(idTcau, omTppt, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, cdTcau, revisao, dsTcau, dtRevisao, stAtivo, dtStativo);

		Assert.assertTrue(dwTAcao.getIdTacao() == idTcau);
		Assert.assertTrue(dwTAcao.getOmTppt() == omTppt);
		Assert.assertTrue(dwTAcao.getOmUsrByIdUsrstativo() == omUsrByIdUsrstativo);
		Assert.assertTrue(dwTAcao.getOmUsrByIdUsrrevisao() == omUsrByIdUsrrevisao);
		Assert.assertTrue( dwTAcao.getCdTacao().equals(cdTcau));
		Assert.assertTrue(dwTAcao.getRevisao().equals(revisao));
		Assert.assertTrue(dwTAcao.getDsTacao().equals(dsTcau));
		Assert.assertTrue(DataHoraRN.equals(dwTAcao.getDtRevisao(), dtRevisao));
		Assert.assertTrue(dwTAcao.getStAtivo() == stAtivo);
		Assert.assertTrue(DataHoraRN.equals(dwTAcao.getDtStativo(), dtStativo));

	}

	@Test
	public void testClone() {
		DwTAcao o1 = new DwTAcao();

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

		DwTAcao o2 = o1.clone(false);


		Assert.assertTrue(o1.getIdTacao() == o2.getIdTacao());
		Assert.assertTrue(o2.getOmTppt() == null);
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTacao(),o2.getCdTacao());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTacao(),o2.getDsTacao());
		Assert.assertEquals(o1.getDsTacao(),o2.getDsTacao());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertTrue(o2.getOmUsrByIdUsrstativo() == null);
		Assert.assertTrue(o2.getOmUsrByIdUsrrevisao() == null);

		o2 = o1.clone(true);

		Assert.assertTrue(o1.getIdTacao() == o2.getIdTacao());
		Assert.assertTrue(o1.getOmTppt().getIdTppt() == o2.getOmTppt().getIdTppt());
		Assert.assertEquals(o1.getOmTppt().getCdTppt(),o2.getOmTppt().getCdTppt());
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTacao(),o2.getCdTacao());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTacao(),o2.getDsTacao());
		Assert.assertEquals(o1.getDsTacao(),o2.getDsTacao());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertEquals(o1.getOmUsrByIdUsrstativo().getCdUsr(),o2.getOmUsrByIdUsrstativo().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrstativo().getIdUsr() == o2.getOmUsrByIdUsrstativo().getIdUsr());
		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao().getCdUsr(),o2.getOmUsrByIdUsrrevisao().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrrevisao().getIdUsr() == o2.getOmUsrByIdUsrrevisao().getIdUsr());
	}

}
