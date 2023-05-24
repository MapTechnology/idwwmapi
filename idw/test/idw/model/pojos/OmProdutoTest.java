package idw.model.pojos;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class OmProdutoTest {
	private DwEst dwEst1 = new DwEst();
	private OmFor omFor1 = new OmFor();
	private PpCliente ppCliente1 = new PpCliente();
	private OmProgrp omProgrp1 = new OmProgrp();
	private OmProduto omProdutoByIdProdutoagru = new OmProduto();
	private OmCc omCc1 = new OmCc();

	public OmProduto newInstanceOmProduto1(){

		OmProduto omProduto = new OmProduto();

		omProduto.setIdProduto(3);
		omProduto.setOmUsrByIdUsrstativo(new OmUsr());
		omProduto.getOmUsrByIdUsrstativo().setIdUsr(1);
		omProduto.getOmUsrByIdUsrstativo().setCdUsr("2");
		omProduto.setOmUsrByIdUsrrevisao(new OmUsr());
		omProduto.getOmUsrByIdUsrrevisao().setIdUsr(3);
		omProduto.getOmUsrByIdUsrrevisao().setCdUsr("4");
		omProduto.setRevisao(1l);
		omProduto.setDtRevisao(new Date());
		omProduto.setStAtivo((byte)1);
		omProduto.setDtStativo(new Date());
		omProduto.setCdProduto("produto1");
		omProduto.setDepara("depara 1");
		omProduto.setDsComplemento("complemento 1");
		omProduto.setDsCurta("Curta 1");
		omProduto.setDsProduto("dsproduto 1");
		omProduto.setDwEst(this.dwEst1);
		omProduto.getDwEst().setIdEst(1);
		omProduto.getDwEst().setCdEst("2");
		omProduto.setHrLeadtimeentrada(new BigDecimal(3));
		omProduto.setHrLeadtimesaida(new BigDecimal(4));
		omProduto.setIndPerdaproducao(new BigDecimal(5));
		omProduto.setMinValposalim(new BigDecimal(6));
		omProduto.setOmCc(this.omCc1);
		omProduto.getOmCc().setIdCc(2);
		omProduto.getOmCc().setCdCc("4");
		omProduto.setOmFor(this.omFor1);
		omProduto.getOmFor().setIdFor(4);
		omProduto.getOmFor().setCdFor("5");
		omProduto.setOmProdutoByIdProdutoagru(this.omProdutoByIdProdutoagru);
		omProduto.getOmProdutoByIdProdutoagru().setIdProduto(6);
		omProduto.getOmProdutoByIdProdutoagru().setCdProduto("4");
		omProduto.setOmProgrp(this.omProgrp1);
		omProduto.getOmProgrp().setIdProgrp(7);
		omProduto.setPpCliente(this.ppCliente1);
		omProduto.getPpCliente().setIdCliente(1L);
		omProduto.setTpProducao(new BigDecimal(1));
		omProduto.setTpProduto((byte)1);

		return omProduto;
	}

	public OmProduto newInstanceOmProduto2(){

		OmProduto omProduto = new OmProduto();

		omProduto.setIdProduto(4);
		omProduto.setOmUsrByIdUsrstativo(new OmUsr());
		omProduto.getOmUsrByIdUsrstativo().setIdUsr(2);
		omProduto.getOmUsrByIdUsrstativo().setCdUsr("3");
		omProduto.setOmUsrByIdUsrrevisao(new OmUsr());
		omProduto.getOmUsrByIdUsrrevisao().setIdUsr(4);
		omProduto.getOmUsrByIdUsrrevisao().setCdUsr("5");
		omProduto.setRevisao(2l);
		omProduto.setDtRevisao(new Date());
		omProduto.setStAtivo((byte)0);
		omProduto.setDtStativo(new Date());
		omProduto.setCdProduto("produto2");
		omProduto.setDepara("depara 2");
		omProduto.setDsComplemento("complemento 2");
		omProduto.setDsCurta("Curta 2");
		omProduto.setDsProduto("dsproduto 2");
		omProduto.setDwEst(new DwEst());
		omProduto.getDwEst().setIdEst(2);
		omProduto.getDwEst().setCdEst("2");
		omProduto.setHrLeadtimeentrada(new BigDecimal(4));
		omProduto.setHrLeadtimesaida(new BigDecimal(5));
		omProduto.setIndPerdaproducao(new BigDecimal(6));
		omProduto.setMinValposalim(new BigDecimal(7));
		omProduto.setOmCc(new OmCc());
		omProduto.getOmCc().setIdCc(8);
		omProduto.getOmCc().setCdCc("5");
		omProduto.setOmFor(new OmFor());
		omProduto.getOmFor().setIdFor(5);
		omProduto.getOmFor().setCdFor("6");
		omProduto.setOmProdutoByIdProdutoagru(new OmProduto());
		omProduto.getOmProdutoByIdProdutoagru().setIdProduto(7);
		omProduto.getOmProdutoByIdProdutoagru().setCdProduto("5");
		omProduto.setOmProgrp(new OmProgrp());
		omProduto.getOmProgrp().setIdProgrp(8);
		omProduto.setPpCliente(new PpCliente());
		omProduto.getPpCliente().setIdCliente(2L);
		omProduto.setTpProducao(new BigDecimal(2));
		omProduto.setTpProduto((byte)2);

		return omProduto;
	}


	@Test
	public void testEqualsHashCode() {
		OmProduto o1 = null;
		OmProduto o2 = null;

		Assert.assertEquals(o1, o2);

		o1 = new OmProduto();
		Assert.assertNotSame(o1, o2);

		o2 = new OmProduto();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o1 = this.newInstanceOmProduto1();
		o2 = this.newInstanceOmProduto1();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o1 = this.newInstanceOmProduto1();
		o2 = this.newInstanceOmProduto2();
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setCdProduto(o1.getCdProduto());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDepara(o1.getDepara());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDsComplemento(o1.getDsComplemento());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDsCurta(o1.getDsCurta());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDsProduto(o1.getDsProduto());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDwEst(o1.getDwEst());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setHrLeadtimeentrada(o1.getHrLeadtimeentrada());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());


		o2.setHrLeadtimesaida(o1.getHrLeadtimesaida());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIndPerdaproducao(o1.getIndPerdaproducao());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setMinValposalim(o1.getMinValposalim());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setOmCc(o1.getOmCc());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setOmFor(o1.getOmFor());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setOmProdutoByIdProdutoagru(o1.getOmProdutoByIdProdutoagru());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setOmProgrp(o1.getOmProgrp());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setPpCliente(o1.getPpCliente());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setTpProducao(o1.getTpProducao());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setTpProduto(o1.getTpProduto());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setStAtivo(o1.getStAtivo());
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

	}

	@Test
	public void testGetCd() {
		OmProduto omProduto = new OmProduto();

		omProduto.setCdProduto("2");

		Assert.assertEquals(omProduto.getCdProduto(), omProduto.getCd());

	}

	@Test
	public void testGetFieldNameCd() {
		OmProduto omProduto = new OmProduto();
		Assert.assertTrue(omProduto.getFieldNameCd().equals("CdProduto"));
	}

	@Test
	public void testSet() {
		OmProduto o1 = this.newInstanceOmProduto1();
		OmProduto o2 = new OmProduto();
/*
		o2.set(o1.getIdProduto(), o1.getCdProduto(), o1.getRevisao(), o1.getDsProduto(), o1.getDtRevisao(), o1.getDtStativo(),
				o1.getStAtivo(), o1.getTpProduto(), o1.getMinValposalim(), o1.getDsComplemento(), o1.getDepara(), o1.getHrLeadtimeentrada(),
				o1.getHrLeadtimesaida(), o1.getTpProducao(), o1.getIndPerdaproducao(), o1.getDsCurta(), o1.getGPesoBruto(), o1.getGPesoLiquido(),
				o1.getDwEst(), o1.getOmFor(),
				o1.getOmUsrByIdUsrstativo(), o1.getOmProgrp(), o1.getOmUsrByIdUsrrevisao(), o1.getOmCc(), o1.getOmProdutoByIdProdutoagru(),
				o1.getPpCliente());
*/
		Assert.assertTrue(o1.getIdProduto() == o2.getIdProduto());
		Assert.assertTrue(o1.getCdProduto() == o2.getCdProduto());
		Assert.assertTrue(o1.getRevisao() == o2.getRevisao());
		Assert.assertTrue(o1.getDsProduto() == o2.getDsProduto());
		Assert.assertTrue(o1.getDtRevisao() == o2.getDtRevisao());
		Assert.assertTrue(o1.getDtStativo() == o2.getDtStativo());
		Assert.assertTrue(o1.getStAtivo() == o2.getStAtivo());
		Assert.assertTrue(o1.getTpProduto() == o2.getTpProduto());
		Assert.assertTrue(o1.getMinValposalim() == o2.getMinValposalim());
		Assert.assertTrue(o1.getDsComplemento() == o2.getDsComplemento());
		Assert.assertTrue(o1.getDepara() == o2.getDepara());
		Assert.assertTrue(o1.getHrLeadtimeentrada() == o2.getHrLeadtimeentrada());
		Assert.assertTrue(o1.getHrLeadtimesaida() == o2.getHrLeadtimesaida());
		Assert.assertTrue(o1.getTpProducao() == o2.getTpProducao());
		Assert.assertTrue(o1.getIndPerdaproducao() == o2.getIndPerdaproducao());
		Assert.assertTrue(o1.getDsCurta() == o2.getDsCurta());
		Assert.assertTrue(o1.getDwEst() == o2.getDwEst());
		Assert.assertTrue(o1.getOmFor() == o2.getOmFor());
		Assert.assertTrue(o1.getOmUsrByIdUsrstativo() == o2.getOmUsrByIdUsrstativo());
		Assert.assertTrue(o1.getOmProgrp() == o2.getOmProgrp());
		Assert.assertTrue(o1.getOmUsrByIdUsrrevisao() == o2.getOmUsrByIdUsrrevisao());
		Assert.assertTrue(o1.getOmCc() == o2.getOmCc());
		Assert.assertTrue(o1.getOmProdutoByIdProdutoagru() == o2.getOmProdutoByIdProdutoagru());
		Assert.assertTrue(o1.getPpCliente() == o1.getPpCliente());

	}

	@Test
	public void testClone() {
		Assert.fail("falta implementar");
//		OmProduto o1 = this.newInstanceOmProduto1();
//
//		o1.clone(true);

//		Assert.assertEquals(o1.getIdUsr(),o2.getIdUsr());
//		Assert.assertEquals(o1.getOmUsrByIdUsrstativo(), o2.getOmUsrByIdUsrstativo());
//		Assert.assertEquals(o1.getOmProdutogrp(), o2.getOmProdutogrp());
//		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao(), o2.getOmUsrByIdUsrrevisao());
//		Assert.assertEquals(o1.getOmCc(), o2.getOmCc());
//		Assert.assertEquals(o1.getCdUsr(), o2.getCdUsr());
//		Assert.assertEquals(o1.getRevisao(), o2.getRevisao());
//		Assert.assertEquals(o1.getDtRevisao(), o2.getDtRevisao());
//		Assert.assertEquals(o1.getDtStativo(), o2.getDtStativo());
//		Assert.assertEquals(o1.getStAtivo(), o2.getStAtivo());
//		Assert.assertEquals(o1.getLogin(), o2.getLogin());
//		Assert.assertEquals(o1.getSenha(), o2.getSenha());
//		Assert.assertEquals(o1.getDsNome(), o2.getDsNome());
//		Assert.assertEquals(o1.getDsApelido(), o2.getDsApelido());
//		Assert.assertEquals(o1.getUrlSms(), o2.getUrlSms());
//		Assert.assertEquals(o1.getUrlEmail(), o2.getUrlEmail());
//
//		o2 = o1.clone(false);
//
//		Assert.assertEquals(o1.getIdUsr(),o2.getIdUsr());
//		Assert.assertEquals(o1.getOmProdutoByIdUsrstativo(), o2.getOmProdutoByIdUsrstativo());
//		Assert.assertEquals(o1.getOmProdutogrp(), o2.getOmProdutogrp());
//		Assert.assertEquals(o1.getOmProdutoByIdUsrrevisao(), o2.getOmProdutoByIdUsrrevisao());
//		Assert.assertEquals(o1.getOmCc(), o2.getOmCc());
//		Assert.assertEquals(o1.getCdUsr(), o2.getCdUsr());
//		Assert.assertEquals(o1.getRevisao(), o2.getRevisao());
//		Assert.assertEquals(o1.getDtRevisao(), o2.getDtRevisao());
//		Assert.assertEquals(o1.getDtStativo(), o2.getDtStativo());
//		Assert.assertEquals(o1.getStAtivo(), o2.getStAtivo());
//		Assert.assertEquals(o1.getLogin(), o2.getLogin());
//		Assert.assertEquals(o1.getSenha(), o2.getSenha());
//		Assert.assertEquals(o1.getDsNome(), o2.getDsNome());
//		Assert.assertEquals(o1.getDsApelido(), o2.getDsApelido());
//		Assert.assertEquals(o1.getUrlSms(), o2.getUrlSms());
//		Assert.assertEquals(o1.getUrlEmail(), o2.getUrlEmail());
	}

}
