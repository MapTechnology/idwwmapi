package idw.model.pojos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import idw.model.rn.DataHoraRN;

public class OmCargoTest {


	@Test
	public void testEqualsObject() {
		OmCargo o1 = null;
		OmCargo o2 = null;

		Assert.assertEquals(o1, o2);

		o1 = new OmCargo();
		Assert.assertNotSame(o1, o2);

		o2 = new OmCargo();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());


		o1.setCdCargo("1");
		o1.setDsCargo("j1");
		o1.setStAtivo((byte)1);
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdCargo("1");
		o2.setDsCargo("j1");
		o2.setStAtivo((byte)1);
		Assert.assertEquals(o1,o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o2.setCdCargo("2");
		o2.setDsCargo(o1.getDsCargo());
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() != o2.hashCode());

		o2.setCdCargo(o1.getCdCargo());
		o2.setDsCargo(o1.getDsCargo());
		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

	}

	@Test
	public void testGetCd() {
		OmCargo omCausa = new OmCargo();

		omCausa.setCdCargo("2");

		Assert.assertTrue(omCausa.getCdCargo().equals(omCausa.getCd()));

	}

	@Test
	public void testGetFieldNameCd() {
		OmCargo omCausa = new OmCargo();
		Assert.assertTrue(omCausa.getFieldNameCd().equals("CdCargo"));
	}

	@Test
	public void testSet() {
		OmCargo omCausa = new OmCargo();

		long idCargo = 0;
		new OmTppt();
		OmUsr omUsrByIdUsrstativo = new OmUsr();
		OmUsr omUsrByIdUsrrevisao = new OmUsr();
		String cdCargo = "2";
		Long revisao = 1l;
		String dsCargo = "cau1";
		Date dtRevisao = new Date();
		Byte stAtivo = (byte) 1;
		Date dtStativo = new Date();
		omCausa.set(idCargo, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, cdCargo, revisao, dsCargo, dtRevisao, stAtivo, dtStativo);

		Assert.assertTrue(omCausa.getIdCargo() == idCargo);
		Assert.assertTrue(omCausa.getOmUsrByIdUsrstativo() == omUsrByIdUsrstativo);
		Assert.assertTrue(omCausa.getOmUsrByIdUsrrevisao() == omUsrByIdUsrrevisao);
		Assert.assertTrue( omCausa.getCdCargo().equals(cdCargo));
		Assert.assertTrue(omCausa.getRevisao().equals(revisao));
		Assert.assertTrue(omCausa.getDsCargo().equals(dsCargo));
		Assert.assertTrue(DataHoraRN.equals(omCausa.getDtRevisao(), dtRevisao));
		Assert.assertTrue(omCausa.getStAtivo() == stAtivo);
		Assert.assertTrue(DataHoraRN.equals(omCausa.getDtStativo(), dtStativo));

	}

	@Test
	public void testClone() {
		OmCargo o1 = new OmCargo();

		long idCargo = 0;
		new OmTppt();
		OmUsr omUsrByIdUsrstativo = new OmUsr();
		OmUsr omUsrByIdUsrrevisao = new OmUsr();
		String cdCargo = "2";
		Long revisao = 1l;
		String dsCargo = "cau1";
		Date dtRevisao = new Date();
		Byte stAtivo = (byte) 1;
		Date dtStativo = new Date();
		o1.set(idCargo, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, cdCargo, revisao, dsCargo, dtRevisao, stAtivo, dtStativo);

		OmCargo o2 = o1.clone(false);


		Assert.assertTrue(o1.getIdCargo() == o2.getIdCargo());
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdCargo(),o2.getCdCargo());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsCargo(),o2.getDsCargo());
		Assert.assertEquals(o1.getDsCargo(),o2.getDsCargo());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertTrue(o2.getOmUsrByIdUsrstativo() == null);
		Assert.assertTrue(o2.getOmUsrByIdUsrrevisao() == null);

		o2 = o1.clone(true);

		Assert.assertTrue(o1.getIdCargo() == o2.getIdCargo());
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdCargo(),o2.getCdCargo());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsCargo(),o2.getDsCargo());
		Assert.assertEquals(o1.getDsCargo(),o2.getDsCargo());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertEquals(o1.getOmUsrByIdUsrstativo().getCdUsr(),o2.getOmUsrByIdUsrstativo().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrstativo().getIdUsr() == o2.getOmUsrByIdUsrstativo().getIdUsr());
		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao().getCdUsr(),o2.getOmUsrByIdUsrrevisao().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrrevisao().getIdUsr() == o2.getOmUsrByIdUsrrevisao().getIdUsr());
	}

}
