package idw.model.pojos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class OmPtTest {

	public OmPt newInstanceOmPt1(){

		OmPt omPt = new OmPt();

		omPt.setIdPt(3L);
		omPt.setOmUsrByIdUsrstativo(new OmUsr());
		omPt.getOmUsrByIdUsrstativo().setIdUsr(1);
		omPt.getOmUsrByIdUsrstativo().setCdUsr("2");
		omPt.setOmUsrByIdUsrrevisao(new OmUsr());
		omPt.getOmUsrByIdUsrrevisao().setIdUsr(3);
		omPt.getOmUsrByIdUsrrevisao().setCdUsr("4");
		omPt.setRevisao(1l);
		omPt.setDtRevisao(new Date());
		omPt.setStAtivo((byte)1);
		omPt.setDtStativo(new Date());
		omPt.setCdPt("produto1");
		omPt.setDepara("depara 1");
		omPt.setDsPt("pt 1");
		omPt.setDsCurta("Curta 1");
		omPt.setDwFolha( new DwFolha());
		omPt.getDwFolha().setIdFolha(1L);
		omPt.getDwFolha().setCdFolha("1");
		omPt.setEstagio(2);
		omPt.setIsApongt(true);
		omPt.setIsPlangt(false);
		omPt.setOmAlimByIdAlim(new OmAlim());
		omPt.getOmAlimByIdAlim().setIdAlim(2);
		omPt.getOmAlimByIdAlim().setCdAlim("2");
		omPt.setOmAlimByIdAlimcorrente(new OmAlim());
		omPt.getOmAlimByIdAlimcorrente().setIdAlim(2L);
		omPt.getOmAlimByIdAlimcorrente().setCdAlim("3");
		omPt.setOmAlimByIdAlimpre(new OmAlim());
		omPt.getOmAlimByIdAlimpre().setIdAlim(4L);
		omPt.getOmAlimByIdAlimpre().setCdAlim("6");
		omPt.setOmCc(new OmCc());
		omPt.getOmCc().setIdCc(7L);
		omPt.getOmCc().setCdCc("3");
		omPt.setOmClp(new OmClp());
		omPt.getOmClp().setIdClp(5L);
		omPt.getOmClp().setCdClp("8");
		omPt.setOmGt(new OmGt());
		omPt.getOmGt().setIdGt(3L);
		omPt.getOmGt().setCdGt("4");
		omPt.setOmTppt(new OmTppt());
		omPt.getOmTppt().setIdTppt(7l);
		omPt.getOmTppt().setCdTppt("2");
		omPt.setTpImpprog((byte) 1);
		omPt.setUrlConexao("url conexao");

		return omPt;
	}

	public OmPt newInstanceOmPt2(){

		OmPt omPt = new OmPt();

		omPt.setIdPt(4L);
		omPt.setOmUsrByIdUsrstativo(new OmUsr());
		omPt.getOmUsrByIdUsrstativo().setIdUsr(2);
		omPt.getOmUsrByIdUsrstativo().setCdUsr("3");
		omPt.setOmUsrByIdUsrrevisao(new OmUsr());
		omPt.getOmUsrByIdUsrrevisao().setIdUsr(4);
		omPt.getOmUsrByIdUsrrevisao().setCdUsr("5");
		omPt.setRevisao(2l);
		omPt.setDtRevisao(new Date());
		omPt.setStAtivo((byte)0);
		omPt.setDtStativo(new Date());
		omPt.setCdPt("produto2");
		omPt.setDepara("depara 2");
		omPt.setDsPt("pt 2");
		omPt.setDsCurta("Curta 2");
		omPt.setDwFolha( new DwFolha());
		omPt.getDwFolha().setIdFolha(2L);
		omPt.getDwFolha().setCdFolha("3");
		omPt.setEstagio(4);
		omPt.setIsApongt(true);
		omPt.setIsPlangt(false);
		omPt.setOmAlimByIdAlim(new OmAlim());
		omPt.getOmAlimByIdAlim().setIdAlim(3);
		omPt.getOmAlimByIdAlim().setCdAlim("4");
		omPt.setOmAlimByIdAlimcorrente(new OmAlim());
		omPt.getOmAlimByIdAlimcorrente().setIdAlim(4L);
		omPt.getOmAlimByIdAlimcorrente().setCdAlim("4");
		omPt.setOmAlimByIdAlimpre(new OmAlim());
		omPt.getOmAlimByIdAlimpre().setIdAlim(5L);
		omPt.getOmAlimByIdAlimpre().setCdAlim("6");
		omPt.setOmCc(new OmCc());
		omPt.getOmCc().setIdCc(8L);
		omPt.getOmCc().setCdCc("4");
		omPt.setOmClp(new OmClp());
		omPt.getOmClp().setIdClp(6L);
		omPt.getOmClp().setCdClp("9");
		omPt.setOmGt(new OmGt());
		omPt.getOmGt().setIdGt(4L);
		omPt.getOmGt().setCdGt("5");
		omPt.setOmTppt(new OmTppt());
		omPt.getOmTppt().setIdTppt(8l);
		omPt.getOmTppt().setCdTppt("3");
		omPt.setTpImpprog((byte) 2);
		omPt.setUrlConexao("url conexao 2");

		return omPt;
	}


	@Test
	public void testEqualsHashCode() {
		Assert.fail("falta implementar");

//		OmPt o1 = null;
//		OmPt o2 = null;
//
//		Assert.assertEquals(o1, o2);
//
//		o1 = new OmPt();
//		Assert.assertNotSame(o1, o2);
//
//		o2 = new OmPt();
//		Assert.assertEquals(o1, o2);
//		Assert.assertTrue(o1.hashCode() == o2.hashCode());
//
//		o1 = this.newInstanceOmPt1();
//		o2 = this.newInstanceOmPt1();
//		Assert.assertEquals(o1, o2);
//		Assert.assertTrue(o1.hashCode() == o2.hashCode());
//
//		o1 = this.newInstanceOmPt1();
//		o2 = this.newInstanceOmPt2();
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setCdProduto(o1.getCdProduto());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setDepara(o1.getDepara());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setDsComplemento(o1.getDsComplemento());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setDsCurta(o1.getDsCurta());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setDsProduto(o1.getDsProduto());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setDwEst(o1.getDwEst());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setHrLeadtimeentrada(o1.getHrLeadtimeentrada());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//
//		o2.setHrLeadtimesaida(o1.getHrLeadtimesaida());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setIndPerdaproducao(o1.getIndPerdaproducao());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setMinValposalim(o1.getMinValposalim());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setOmCc(o1.getOmCc());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setOmFor(o1.getOmFor());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setOmPtByIdProdutoagru(o1.getOmPtByIdProdutoagru());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setOmProgrp(o1.getOmProgrp());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setPpCliente(o1.getPpCliente());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setTpProducao(o1.getTpProducao());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setTpProduto(o1.getTpProduto());
//		Assert.assertNotSame(o1, o2);
//		Assert.assertFalse(o1.hashCode() == o2.hashCode());
//
//		o2.setStAtivo(o1.getStAtivo());
//		Assert.assertEquals(o1, o2);
//		Assert.assertTrue(o1.hashCode() == o2.hashCode());

	}

	@Test
	public void testGetCd() {
		OmPt omPt = new OmPt();

		omPt.setCdPt("2");

		Assert.assertEquals(omPt.getCdPt(), omPt.getCd());

	}

	@Test
	public void testGetFieldNameCd() {
		OmPt omPt = new OmPt();
		Assert.assertTrue(omPt.getFieldNameCd().equals("CdPt"));
	}

	@Test
	public void testSet() {

		Assert.fail("falta implementar");

//		OmPt o1 = this.newInstanceOmPt1();
//		OmPt o2 = new OmPt();
//
//		o2.set(o1.getIdProduto(), o1.getCdProduto(), o1.getRevisao(), o1.getDsProduto(), o1.getDtRevisao(), o1.getDtStativo(),
//				o1.getStAtivo(), o1.getTpProduto(), o1.getMinValposalim(), o1.getDsComplemento(), o1.getDepara(), o1.getHrLeadtimeentrada(),
//				o1.getHrLeadtimesaida(), o1.getTpProducao(), o1.getIndPerdaproducao(), o1.getDsCurta(), o1.getDwEst(), o1.getOmFor(),
//				o1.getOmUsrByIdUsrstativo(), o1.getOmProgrp(), o1.getOmUsrByIdUsrrevisao(), o1.getOmCc(), o1.getOmPtByIdProdutoagru(),
//				o1.getPpCliente());
//
//		Assert.assertTrue(o1.getIdProduto() == o2.getIdProduto());
//		Assert.assertTrue(o1.getCdProduto() == o2.getCdProduto());
//		Assert.assertTrue(o1.getRevisao() == o2.getRevisao());
//		Assert.assertTrue(o1.getDsProduto() == o2.getDsProduto());
//		Assert.assertTrue(o1.getDtRevisao() == o2.getDtRevisao());
//		Assert.assertTrue(o1.getDtStativo() == o2.getDtStativo());
//		Assert.assertTrue(o1.getStAtivo() == o2.getStAtivo());
//		Assert.assertTrue(o1.getTpProduto() == o2.getTpProduto());
//		Assert.assertTrue(o1.getMinValposalim() == o2.getMinValposalim());
//		Assert.assertTrue(o1.getDsComplemento() == o2.getDsComplemento());
//		Assert.assertTrue(o1.getDepara() == o2.getDepara());
//		Assert.assertTrue(o1.getHrLeadtimeentrada() == o2.getHrLeadtimeentrada());
//		Assert.assertTrue(o1.getHrLeadtimesaida() == o2.getHrLeadtimesaida());
//		Assert.assertTrue(o1.getTpProducao() == o2.getTpProducao());
//		Assert.assertTrue(o1.getIndPerdaproducao() == o2.getIndPerdaproducao());
//		Assert.assertTrue(o1.getDsCurta() == o2.getDsCurta());
//		Assert.assertTrue(o1.getDwEst() == o2.getDwEst());
//		Assert.assertTrue(o1.getOmFor() == o2.getOmFor());
//		Assert.assertTrue(o1.getOmUsrByIdUsrstativo() == o2.getOmUsrByIdUsrstativo());
//		Assert.assertTrue(o1.getOmProgrp() == o2.getOmProgrp());
//		Assert.assertTrue(o1.getOmUsrByIdUsrrevisao() == o2.getOmUsrByIdUsrrevisao());
//		Assert.assertTrue(o1.getOmCc() == o2.getOmCc());
//		Assert.assertTrue(o1.getOmPtByIdProdutoagru() == o2.getOmPtByIdProdutoagru());
//		Assert.assertTrue(o1.getPpCliente() == o1.getPpCliente());

	}

	@Test
	public void testClone() {
		Assert.fail("falta implementar");

//		OmPt o1 = this.newInstanceOmPt1();
//
//		o1.clone(true);

//		Assert.assertEquals(o1.getIdUsr(),o2.getIdUsr());
//		Assert.assertEquals(o1.getOmUsrByIdUsrstativo(), o2.getOmUsrByIdUsrstativo());
//		Assert.assertEquals(o1.getOmPtgrp(), o2.getOmPtgrp());
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
//		Assert.assertEquals(o1.getOmPtByIdUsrstativo(), o2.getOmPtByIdUsrstativo());
//		Assert.assertEquals(o1.getOmPtgrp(), o2.getOmPtgrp());
//		Assert.assertEquals(o1.getOmPtByIdUsrrevisao(), o2.getOmPtByIdUsrrevisao());
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
