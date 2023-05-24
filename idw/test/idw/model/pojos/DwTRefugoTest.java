package idw.model.pojos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DwTRefugoTest {

	public DwTRefugo newInstanceDwTRefugo1(){

		DwTRefugo dwTRefugo = new DwTRefugo();

		dwTRefugo.setIdTrefugo(3l);
		dwTRefugo.setOmTppt(new OmTppt());
		dwTRefugo.getOmTppt().setIdTppt(1l);
		dwTRefugo.getOmTppt().setCdTppt("1");
		dwTRefugo.setOmUsrByIdUsrstativo(new OmUsr());
		dwTRefugo.getOmUsrByIdUsrstativo().setIdUsr(1);
		dwTRefugo.getOmUsrByIdUsrstativo().setCdUsr("2");
		dwTRefugo.setOmUsrByIdUsrrevisao(new OmUsr());
		dwTRefugo.getOmUsrByIdUsrrevisao().setIdUsr(3);
		dwTRefugo.getOmUsrByIdUsrrevisao().setCdUsr("4");
		dwTRefugo.setCdTrefugo("2");
		dwTRefugo.setRevisao(1l);
		dwTRefugo.setDsTrefugo("refugo 2");
		dwTRefugo.setDtRevisao(new Date());
		dwTRefugo.setStAtivo((byte)1);
		dwTRefugo.setDtStativo(new Date());
		dwTRefugo.setIsRequerCausa(false);
		dwTRefugo.setIsRequerAcao(true);

		return dwTRefugo;
	}

	public DwTRefugo newInstanceDwTRefugo2(){

		DwTRefugo dwTRefugo = new DwTRefugo();

		dwTRefugo.setIdTrefugo(4l);
		dwTRefugo.setOmTppt(new OmTppt());
		dwTRefugo.getOmTppt().setIdTppt(1l);
		dwTRefugo.getOmTppt().setCdTppt("1");
		dwTRefugo.setOmUsrByIdUsrstativo(new OmUsr());
		dwTRefugo.getOmUsrByIdUsrstativo().setIdUsr(5);
		dwTRefugo.getOmUsrByIdUsrstativo().setCdUsr("6");
		dwTRefugo.setOmUsrByIdUsrrevisao(new OmUsr());
		dwTRefugo.getOmUsrByIdUsrrevisao().setIdUsr(7);
		dwTRefugo.getOmUsrByIdUsrrevisao().setCdUsr("8");
		dwTRefugo.setCdTrefugo("5");
		dwTRefugo.setRevisao(6l);
		dwTRefugo.setDsTrefugo("refugo 7");
		dwTRefugo.setDtRevisao(new Date());
		dwTRefugo.setStAtivo((byte)0);
		dwTRefugo.setDtStativo(new Date());
		dwTRefugo.setIsRequerCausa(true);
		dwTRefugo.setIsRequerAcao(false);

		return dwTRefugo;
	}

	@Test
	public void testEqualsObject() {
		DwTRefugo o1 = null;
		DwTRefugo o2 = null;

		Assert.assertEquals(o1, o2);

		o1 = new DwTRefugo();
		Assert.assertNotSame(o1, o2);

		o2 = new DwTRefugo();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o1 = this.newInstanceDwTRefugo1();
		o2 = this.newInstanceDwTRefugo1();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o2 = this.newInstanceDwTRefugo2();
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setOmTppt(o1.getOmTppt());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setCdTrefugo(o1.getCdTrefugo());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDsTrefugo(o1.getDsTrefugo());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsRequerCausa(o1.getIsRequerCausa());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsRequerAcao(o1.getIsRequerAcao());
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

	}

	@Test
	public void testGetCd() {
		DwTRefugo dwTRefugo = new DwTRefugo();

		dwTRefugo.setCdTrefugo("2");

		Assert.assertTrue(dwTRefugo.getCdTrefugo().equals(dwTRefugo.getCd()));

	}

	@Test
	public void testGetFieldNameCd() {
		DwTRefugo dwTRefugo = new DwTRefugo();
		Assert.assertTrue(dwTRefugo.getFieldNameCd().equals("CdTrefugo"));
	}

	@Test
	public void testSet() {
		DwTRefugo dwTRefugo = new DwTRefugo();

		long idTcau = 0;
		OmTppt omTppt = new OmTppt();
		OmUsr omUsrByIdUsrstativo = new OmUsr();
		OmUsr omUsrByIdUsrrevisao = new OmUsr();
		DwTArea dwTArea = null;
		String cdTcau = "2";
		Long revisao = 1l;
		String dsTcau = "cau1";
		Date dtRevisao = new Date();
		Byte stAtivo = (byte) 1;
		Date dtStativo = new Date();
		Boolean isRequerCausa = true;
		Boolean isRequerAcao = true;
		dwTRefugo.set(idTcau, omTppt, omUsrByIdUsrstativo, dwTArea, omUsrByIdUsrrevisao, cdTcau, revisao, dsTcau, dtRevisao, stAtivo, dtStativo,
				isRequerCausa, isRequerAcao, false);

		// Referencia dos objetos devem ser iguais
		Assert.assertTrue(dwTRefugo.getIdTrefugo().equals(idTcau));
		Assert.assertTrue(dwTRefugo.getOmTppt() == omTppt);
		Assert.assertTrue(dwTRefugo.getOmUsrByIdUsrstativo() == omUsrByIdUsrstativo);
		Assert.assertTrue(dwTRefugo.getOmUsrByIdUsrrevisao() == omUsrByIdUsrrevisao);
		Assert.assertTrue( dwTRefugo.getCdTrefugo() == cdTcau);
		Assert.assertTrue(dwTRefugo.getRevisao() == revisao);
		Assert.assertTrue(dwTRefugo.getDsTrefugo() == dsTcau);
		Assert.assertTrue(dwTRefugo.getDtRevisao() == dtRevisao);
		Assert.assertTrue(dwTRefugo.getStAtivo() == stAtivo);
		Assert.assertTrue(dwTRefugo.getDtStativo() == dtStativo);
		Assert.assertTrue(dwTRefugo.getIsRequerCausa() == isRequerCausa);
		Assert.assertTrue(dwTRefugo.getIsRequerAcao() == isRequerAcao);

	}

	@Test
	public void testClone() {
		DwTRefugo o1 = new DwTRefugo();

		long idTcau = 0;
		OmTppt omTppt = new OmTppt();
		OmUsr omUsrByIdUsrstativo = new OmUsr();
		OmUsr omUsrByIdUsrrevisao = new OmUsr();
		DwTArea dwTArea = null;
		String cdTcau = "2";
		Long revisao = 1l;
		String dsTcau = "cau1";
		Date dtRevisao = new Date();
		Byte stAtivo = (byte) 1;
		Date dtStativo = new Date();
		Boolean isRequerCausa = true;
		Boolean isRequerAcao = false;
		o1.set(idTcau, omTppt, omUsrByIdUsrstativo, dwTArea, omUsrByIdUsrrevisao, cdTcau, revisao, dsTcau, dtRevisao, stAtivo, dtStativo,
				isRequerCausa, isRequerAcao, false);

		DwTRefugo o2 = o1.clone(false);

		Assert.assertTrue(o1.getIdTrefugo().equals(o2.getIdTrefugo()));
		Assert.assertTrue(o2.getOmTppt() == null);
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTrefugo(),o2.getCdTrefugo());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTrefugo(),o2.getDsTrefugo());
		Assert.assertEquals(o1.getDsTrefugo(),o2.getDsTrefugo());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertTrue(o2.getOmUsrByIdUsrstativo() == null);
		Assert.assertTrue(o2.getOmUsrByIdUsrrevisao() == null);
		Assert.assertTrue(o1.getIsRequerCausa().equals(o2.getIsRequerCausa()));
		Assert.assertTrue(o1.getIsRequerAcao().equals(o2.getIsRequerAcao()));

		o2 = o1.clone(true);

		Assert.assertTrue(o1.getIdTrefugo().equals(o2.getIdTrefugo()));
		Assert.assertTrue(o1.getOmTppt().getIdTppt() == o2.getOmTppt().getIdTppt());
		Assert.assertEquals(o1.getOmTppt().getCdTppt(),o2.getOmTppt().getCdTppt());
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTrefugo(),o2.getCdTrefugo());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTrefugo(),o2.getDsTrefugo());
		Assert.assertEquals(o1.getDsTrefugo(),o2.getDsTrefugo());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertEquals(o1.getOmUsrByIdUsrstativo().getCdUsr(),o2.getOmUsrByIdUsrstativo().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrstativo().getIdUsr() == o2.getOmUsrByIdUsrstativo().getIdUsr());
		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao().getCdUsr(),o2.getOmUsrByIdUsrrevisao().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrrevisao().getIdUsr() == o2.getOmUsrByIdUsrrevisao().getIdUsr());
		Assert.assertTrue(o1.getIsRequerCausa().equals(o2.getIsRequerCausa()));
		Assert.assertTrue(o1.getIsRequerAcao().equals(o2.getIsRequerAcao()));

	}

}
