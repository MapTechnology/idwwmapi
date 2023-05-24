package idw.model.pojos;

import idw.model.pojos.template.OmUsrTemplate;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class OmUsrTest {
	public OmUsr newInstanceOmUsr1(){

		OmUsr omUsr = new OmUsr();

		omUsr.setIdUsr(3);
		omUsr.setOmUsrByIdUsrstativo(new OmUsr());
		omUsr.getOmUsrByIdUsrstativo().setIdUsr(1);
		omUsr.getOmUsrByIdUsrstativo().setCdUsr("2");
		omUsr.setOmUsrByIdUsrrevisao(new OmUsr());
		omUsr.getOmUsrByIdUsrrevisao().setIdUsr(3);
		omUsr.getOmUsrByIdUsrrevisao().setCdUsr("4");
		omUsr.setRevisao(1l);
		omUsr.setDtRevisao(new Date());
		omUsr.setStAtivo((byte)1);
		omUsr.setDtStativo(new Date());

		omUsr.setCdUsr("1");
		omUsr.setDsApelido("ape1");
		omUsr.setDsNome("nome 1");
		omUsr.setLogin("login 1");
		omUsr.setOmCargo(new OmCargo());
		omUsr.getOmCargo().setIdCargo(1);
		omUsr.getOmCargo().setCdCargo("omcargo 1");
		omUsr.setOmCc(new OmCc());
		omUsr.getOmCc().setIdCc(1);
		omUsr.getOmCc().setCdCc("omcc 1");
		omUsr.setOmUsrgrp(new OmUsrgrp(1));
		omUsr.getOmUsrgrp().setCdUsrgrp("usrgrp1");
		omUsr.setSenha("senha1");
		omUsr.setUrlEmail("email@email1");
		omUsr.setUrlSms("sms1");

		return omUsr;
	}

	public OmUsr newInstanceOmUsr2(){

		OmUsr omUsr = new OmUsr();

		omUsr.setIdUsr(4);
		omUsr.setOmUsrByIdUsrstativo(new OmUsr());
		omUsr.getOmUsrByIdUsrstativo().setIdUsr(2);
		omUsr.getOmUsrByIdUsrstativo().setCdUsr("3");
		omUsr.setOmUsrByIdUsrrevisao(new OmUsr());
		omUsr.getOmUsrByIdUsrrevisao().setIdUsr(4);
		omUsr.getOmUsrByIdUsrrevisao().setCdUsr("5");
		omUsr.setRevisao(2l);
		omUsr.setDtRevisao(new Date());
		omUsr.setStAtivo((byte)0);
		omUsr.setDtStativo(new Date());

		omUsr.setCdUsr("2");
		omUsr.setDsApelido("ape2");
		omUsr.setDsNome("nome 2");
		omUsr.setLogin("login 2");
		omUsr.setOmCargo(new OmCargo());
		omUsr.getOmCargo().setIdCargo(2);
		omUsr.getOmCargo().setCdCargo("omcargo 2");
		omUsr.setOmCc(new OmCc());
		omUsr.getOmCc().setIdCc(2);
		omUsr.getOmCc().setCdCc("omcc 2");
		omUsr.setOmUsrgrp(new OmUsrgrp(2));
		omUsr.getOmUsrgrp().setCdUsrgrp("usrgrp2");
		omUsr.setSenha("senha2");
		omUsr.setUrlEmail("email@email2");
		omUsr.setUrlSms("sms2");

		return omUsr;
	}


	@Test
	public void testEqualsObject() {
		OmUsr o1 = null;
		OmUsr o2 = null;

		Assert.assertEquals(o1, o2);

		o1 = new OmUsr();
		Assert.assertNotSame(o1, o2);

		o2 = new OmUsr();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o1 = this.newInstanceOmUsr1();
		o2 = this.newInstanceOmUsr2();
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIdUsr(o1.getIdUsr());
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

		o2.setCdUsr(o1.getCdUsr());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDsApelido(o1.getDsApelido());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDsNome(o1.getDsNome());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setLogin(o1.getLogin());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setOmCc(o1.getOmCc());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setOmUsrgrp(o1.getOmUsrgrp());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setSenha(o1.getSenha());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setUrlEmail(o1.getUrlEmail());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setUrlSms(o1.getUrlSms());
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

	}

	@Test
	public void testGetCd() {
		OmUsr omUsr = new OmUsr();

		omUsr.setCdUsr("2");

		Assert.assertTrue(omUsr.getCdUsr().equals(omUsr.getCd()));

	}

	@Test
	public void testGetFieldNameCd() {
		OmUsr omUsr = new OmUsr();
		Assert.assertTrue(omUsr.getFieldNameCd().equals("CdUsr"));
	}

	@Test
	public void testSet() {
		OmUsr o1 = this.newInstanceOmUsr1();
		OmUsr o2 = new OmUsr();

		o2.set(o1.getIdUsr(), o1.getOmUsrByIdUsrstativo(), o1.getOmUsrgrp(), o1.getOmUsrByIdUsrrevisao(),
				o1.getOmCargo(), o1.getOmCc(), o1.getOmGt(), o1.getCdUsr(), o1.getRevisao(), o1.getDtRevisao(), o1.getDtStativo(),
				o1.getStAtivo(), o1.getLogin(), o1.getSenha(), o1.getDsNome(), o1.getDsApelido(), o1.getUrlSms(),
				o1.getUrlEmail(), o1.getOmGt());

		Assert.assertTrue(o1.getIdUsr() == o2.getIdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrstativo() == o2.getOmUsrByIdUsrstativo());
		Assert.assertTrue(o1.getOmUsrgrp() == o2.getOmUsrgrp());
		Assert.assertTrue(o1.getOmUsrByIdUsrrevisao() == o2.getOmUsrByIdUsrrevisao());
		Assert.assertTrue(o1.getOmCargo() == o2.getOmCargo());
		Assert.assertTrue(o1.getOmCc() == o2.getOmCc());
		Assert.assertTrue(o1.getCdUsr() == o2.getCdUsr());
		Assert.assertTrue(o1.getRevisao() == o2.getRevisao());
		Assert.assertTrue(o1.getDtRevisao() == o2.getDtRevisao());
		Assert.assertTrue(o1.getDtStativo() == o2.getDtStativo());
		Assert.assertTrue(o1.getStAtivo() == o2.getStAtivo());
		Assert.assertTrue(o1.getLogin() == o2.getLogin());
		Assert.assertTrue(o1.getSenha() == o2.getSenha());
		Assert.assertTrue(o1.getDsNome() == o2.getDsNome());
		Assert.assertTrue(o1.getDsApelido() == o2.getDsApelido());
		Assert.assertTrue(o1.getUrlSms() == o2.getUrlSms());
		Assert.assertTrue(o1.getUrlEmail() == o2.getUrlEmail());
		Assert.assertTrue(o1.getOmGt() == o2.getOmGt());
		

	}

	@Test
	public void testClone() {
		OmUsr o1 = this.newInstanceOmUsr1();

		OmUsr o2 = o1.clone(true);

		Assert.assertEquals(o1.getIdUsr(),o2.getIdUsr());
		Assert.assertEquals(o1.getOmUsrByIdUsrstativo(), o2.getOmUsrByIdUsrstativo());
		Assert.assertEquals(o1.getOmUsrgrp(), o2.getOmUsrgrp());
		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao(), o2.getOmUsrByIdUsrrevisao());
		Assert.assertEquals(o1.getOmCargo(), o2.getOmCargo());
		Assert.assertEquals(o1.getOmCc(), o2.getOmCc());
		Assert.assertEquals(o1.getCdUsr(), o2.getCdUsr());
		Assert.assertEquals(o1.getRevisao(), o2.getRevisao());
		Assert.assertEquals(o1.getDtRevisao(), o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(), o2.getDtStativo());
		Assert.assertEquals(o1.getStAtivo(), o2.getStAtivo());
		Assert.assertEquals(o1.getLogin(), o2.getLogin());
		Assert.assertEquals(o1.getSenha(), o2.getSenha());
		Assert.assertEquals(o1.getDsNome(), o2.getDsNome());
		Assert.assertEquals(o1.getDsApelido(), o2.getDsApelido());
		Assert.assertEquals(o1.getUrlSms(), o2.getUrlSms());
		Assert.assertEquals(o1.getUrlEmail(), o2.getUrlEmail());

		o2 = o1.clone(false);

		Assert.assertEquals(o1.getIdUsr(),o2.getIdUsr());
		Assert.assertTrue(o2.getOmUsrByIdUsrstativo() == null);
		Assert.assertTrue(o2.getOmUsrgrp() == null );
		Assert.assertTrue(o2.getOmUsrByIdUsrrevisao() == null);
		Assert.assertTrue(o2.getOmCargo() == null);
		Assert.assertTrue(o2.getOmCc() == null);
		Assert.assertEquals(o1.getCdUsr(), o2.getCdUsr());
		Assert.assertEquals(o1.getRevisao(), o2.getRevisao());
		Assert.assertEquals(o1.getDtRevisao(), o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(), o2.getDtStativo());
		Assert.assertEquals(o1.getStAtivo(), o2.getStAtivo());
		Assert.assertEquals(o1.getLogin(), o2.getLogin());
		Assert.assertEquals(o1.getSenha(), o2.getSenha());
		Assert.assertEquals(o1.getDsNome(), o2.getDsNome());
		Assert.assertEquals(o1.getDsApelido(), o2.getDsApelido());
		Assert.assertEquals(o1.getUrlSms(), o2.getUrlSms());
		Assert.assertEquals(o1.getUrlEmail(), o2.getUrlEmail());
	}

	public void testLimitarStringsNull(){
		OmUsr omUsr = new OmUsr();

		omUsr.set(0, null, null, null,null, null, null, null, 0L,
				null, null, null, null, null, null, null, null, null, null);

		//Testar valores nulos
		omUsr.limitarStrings();

		Assert.assertTrue(omUsr.getCdUsr() == null);
		Assert.assertTrue(omUsr.getDsApelido() == null);
		Assert.assertTrue(omUsr.getDsNome() == null);
		Assert.assertTrue(omUsr.getLogin() == null);
		Assert.assertTrue(omUsr.getSenha() == null);
		Assert.assertTrue(omUsr.getSenha() == null);
		Assert.assertTrue(omUsr.getSenha() == null);


	}

	public void testLimitarStrings1char(){
		// Teste com
		String cdUsr = StringUtils.repeat('c', 1);
		String dsApelido = StringUtils.repeat('n', 1);
		String dsNome = StringUtils.repeat('d', 1);
		String login = StringUtils.repeat('l', 1);
		String senha = StringUtils.repeat('s', 1);
		String urlEmail = StringUtils.repeat('e', 1);
		String urlSMS = StringUtils.repeat('m', 1);

		OmUsr omUsr = new OmUsr();
		omUsr.limitarStrings();

		Assert.assertTrue(omUsr.getCdUsr().equals(cdUsr));
		Assert.assertTrue(omUsr.getDsApelido().equals(dsApelido));
		Assert.assertTrue(omUsr.getDsNome().equals(dsNome));
		Assert.assertTrue(omUsr.getLogin().equals(login));
		Assert.assertTrue(omUsr.getSenha().equals(senha));
		Assert.assertTrue(omUsr.getUrlEmail().equals(urlEmail));
		Assert.assertTrue(omUsr.getUrlSms().equals(urlSMS));

	}

	public void testLimitarStringsLimitando(){
		OmUsr omUsr = new OmUsr();

		String cdUsr = StringUtils.repeat('c', 200);
		String dsApelido = StringUtils.repeat('n', 200);
		String dsNome = StringUtils.repeat('d', 200);
		String login = StringUtils.repeat('l', 200);
		String senha = StringUtils.repeat('s', 200);
		String urlEmail = StringUtils.repeat('e', 200);
		String urlSMS = StringUtils.repeat('m', 200);

		omUsr.set(0, null, null, null,null, null, null, cdUsr, 0L,
				null, null, null, login, senha, dsNome, dsApelido, urlSMS, urlEmail, null);

		omUsr.limitarStrings();

		Assert.assertTrue(omUsr.getCdUsr().equals(StringUtils.left(cdUsr, OmUsrTemplate._MAX_LEN_CD_USR)));
		Assert.assertTrue(omUsr.getDsApelido().equals(StringUtils.left(dsApelido, OmUsrTemplate._MAX_LEN_DS_APELIDO)));
		Assert.assertTrue(omUsr.getDsNome().equals(StringUtils.left(dsNome, OmUsrTemplate._MAX_LEN_DS_NOME)));
		Assert.assertTrue(omUsr.getLogin().equals(StringUtils.left(login, OmUsrTemplate._MAX_LEN_LOGIN)));
		Assert.assertTrue(omUsr.getSenha().equals(StringUtils.left(senha, OmUsrTemplate._MAX_LEN_SENHA)));
		Assert.assertTrue(omUsr.getUrlEmail().equals(StringUtils.left(urlEmail, OmUsrTemplate._MAX_LEN_URL_EMAIL)));
		Assert.assertTrue(omUsr.getUrlSms().equals(StringUtils.left(urlSMS, OmUsrTemplate._MAX_LEN_URL_SMS)));

	}

}
