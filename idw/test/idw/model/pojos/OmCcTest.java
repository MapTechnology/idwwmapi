package idw.model.pojos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class OmCcTest {
	public OmCc newInstanceOmCc1(){

		OmCc omCc = new OmCc();

		omCc.setIdCc(3);
		omCc.setOmUsrByIdUsrstativo(new OmUsr());
		omCc.getOmUsrByIdUsrstativo().setIdUsr(1);
		omCc.getOmUsrByIdUsrstativo().setCdUsr("2");
		omCc.setOmUsrByIdUsrrevisao(new OmUsr());
		omCc.getOmUsrByIdUsrrevisao().setIdUsr(3);
		omCc.getOmUsrByIdUsrrevisao().setCdUsr("4");
		omCc.setRevisao(1l);
		omCc.setDtRevisao(new Date());
		omCc.setStAtivo((byte)1);
		omCc.setDtStativo(new Date());
		omCc.setCdCc("3");
		omCc.setDsCc("ds cc 1");

		return omCc;
	}

	public OmCc newInstanceOmCc2(){

		OmCc omCc = new OmCc();

		omCc.setIdCc(4);
		omCc.setOmUsrByIdUsrstativo(new OmUsr());
		omCc.getOmUsrByIdUsrstativo().setIdUsr(2);
		omCc.getOmUsrByIdUsrstativo().setCdUsr("3");
		omCc.setOmUsrByIdUsrrevisao(new OmUsr());
		omCc.getOmUsrByIdUsrrevisao().setIdUsr(4);
		omCc.getOmUsrByIdUsrrevisao().setCdUsr("5");
		omCc.setRevisao(2l);
		omCc.setDtRevisao(new Date());
		omCc.setStAtivo((byte)0);
		omCc.setDtStativo(new Date());
		omCc.setCdCc("4");
		omCc.setDsCc("ds cc 2");
		return omCc;
	}


	@Test
	public void testEqualsObject() {
		OmCc o1 = null;
		OmCc o2 = null;

		Assert.assertEquals(o1, o2);

		o1 = new OmCc();
		Assert.assertNotSame(o1, o2);

		o2 = new OmCc();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o1 = this.newInstanceOmCc1();
		o2 = this.newInstanceOmCc2();
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIdCc(o1.getIdCc());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setOmUsrByIdUsrstativo(o1.getOmUsrByIdUsrstativo());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setOmUsrByIdUsrrevisao(o1.getOmUsrByIdUsrrevisao());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setRevisao(o1.getRevisao());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDtRevisao(o1.getDtRevisao());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDtStativo(o1.getDtStativo());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setCdCc(o1.getCdCc());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDsCc(o1.getDsCc());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() != o2.hashCode());

	}

	@Test
	public void testGetCd() {
		OmCc omCc = new OmCc();

		omCc.setCdCc("2");

		Assert.assertTrue(omCc.getCdCc().equals(omCc.getCd()));

	}

	@Test
	public void testGetFieldNameCd() {
		OmCc omCc = new OmCc();
		Assert.assertTrue(omCc.getFieldNameCd().equals("CdUsr"));
	}


	@Test
	public void testClone() {
		OmCc o1 = this.newInstanceOmCc1();

		OmCc o2 = o1.clone(true);

		Assert.assertEquals(o1.getIdCc(),o2.getIdCc());
		Assert.assertEquals(o1.getOmUsrByIdUsrstativo(), o2.getOmUsrByIdUsrstativo());
		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao(), o2.getOmUsrByIdUsrrevisao());
		Assert.assertEquals(o1.getCdCc(), o2.getCdCc());
		Assert.assertEquals(o1.getRevisao(), o2.getRevisao());
		Assert.assertEquals(o1.getDtRevisao(), o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(), o2.getDtStativo());
		Assert.assertEquals(o1.getStAtivo(), o2.getStAtivo());
		Assert.assertEquals(o1.getDsCc(), o2.getDsCc());

		o2 = o1.clone(false);

		Assert.assertEquals(o1.getIdCc(),o2.getIdCc());
		Assert.assertEquals(o1.getOmUsrByIdUsrstativo(), o2.getOmUsrByIdUsrstativo());
		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao(), o2.getOmUsrByIdUsrrevisao());
		Assert.assertEquals(o1.getCdCc(), o2.getCdCc());
		Assert.assertEquals(o1.getRevisao(), o2.getRevisao());
		Assert.assertEquals(o1.getDtRevisao(), o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(), o2.getDtStativo());
		Assert.assertEquals(o1.getStAtivo(), o2.getStAtivo());
		Assert.assertEquals(o1.getDsCc(), o2.getDsCc());
	}

}
