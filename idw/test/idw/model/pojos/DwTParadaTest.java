package idw.model.pojos;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class DwTParadaTest {

	public DwTParada newInstanceDwTParada1(){

		DwTParada dwTParada = new DwTParada();

		dwTParada.setIdTparada(3L);
		dwTParada.setOmTppt(new OmTppt());
		dwTParada.getOmTppt().setIdTppt(1l);
		dwTParada.getOmTppt().setCdTppt("1");
		dwTParada.setOmUsrByIdUsrstativo(new OmUsr());
		dwTParada.getOmUsrByIdUsrstativo().setIdUsr(1);
		dwTParada.getOmUsrByIdUsrstativo().setCdUsr("2");
		dwTParada.setOmUsrByIdUsrrevisao(new OmUsr());
		dwTParada.getOmUsrByIdUsrrevisao().setIdUsr(3);
		dwTParada.getOmUsrByIdUsrrevisao().setCdUsr("4");
		dwTParada.setCdTparada("2");
		dwTParada.setRevisao(1l);
		dwTParada.setDsTparada("parada 2");
		dwTParada.setDtRevisao(new Date());
		dwTParada.setStAtivo((byte)1);
		dwTParada.setDtStativo(new Date());
		dwTParada.setIsRequerCausa(false);
		dwTParada.setIsRequerAcao(true);
		dwTParada.setIsRequerJust(false);
		dwTParada.setIsPesa(true);
		dwTParada.setIsRegulagem(false);
		dwTParada.setIsFds(true);
		dwTParada.setIsMdo(false);
		dwTParada.setIsMtbf(true);

		dwTParada.setIsPa(true);
		dwTParada.setIsPao(false);
		dwTParada.setIsPrev(true);
		dwTParada.setIsPp(false);
		dwTParada.setIsPtp(true);
		dwTParada.setIsScp(false);
		dwTParada.setQtTec(3);

		return dwTParada;
	}

	public DwTParada newInstanceDwTParada2(){

		DwTParada dwTParada = new DwTParada();

		dwTParada.setIdTparada(4L);
		dwTParada.setOmTppt(new OmTppt());
		dwTParada.getOmTppt().setIdTppt(1l);
		dwTParada.getOmTppt().setCdTppt("1");
		dwTParada.setOmUsrByIdUsrstativo(new OmUsr());
		dwTParada.getOmUsrByIdUsrstativo().setIdUsr(5);
		dwTParada.getOmUsrByIdUsrstativo().setCdUsr("6");
		dwTParada.setOmUsrByIdUsrrevisao(new OmUsr());
		dwTParada.getOmUsrByIdUsrrevisao().setIdUsr(7);
		dwTParada.getOmUsrByIdUsrrevisao().setCdUsr("8");
		dwTParada.setCdTparada("5");
		dwTParada.setRevisao(6l);
		dwTParada.setDsTparada("parada 7");
		dwTParada.setDtRevisao(new Date());
		dwTParada.setStAtivo((byte)0);
		dwTParada.setDtStativo(new Date());
		dwTParada.setIsRequerCausa(true);
		dwTParada.setIsRequerAcao(false);
		dwTParada.setIsRequerJust(true);
		dwTParada.setIsPesa(false);
		dwTParada.setIsRegulagem(true);
		dwTParada.setIsFds(false);
		dwTParada.setIsMdo(true);
		dwTParada.setIsMtbf(false);

		dwTParada.setIsPa(false);
		dwTParada.setIsPao(true);
		dwTParada.setIsPrev(false);
		dwTParada.setIsPp(true);
		dwTParada.setIsPtp(false);
		dwTParada.setIsScp(true);
		dwTParada.setQtTec(4);

		return dwTParada;
	}

	@Test
	public void testEqualsObject() {
		DwTParada o1 = null;
		DwTParada o2 = null;

		Assert.assertEquals(o1, o2);

		o1 = new DwTParada();
		Assert.assertNotSame(o1, o2);

		o2 = new DwTParada();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o1 = this.newInstanceDwTParada1();
		o2 = this.newInstanceDwTParada1();
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

		o2 = this.newInstanceDwTParada2();
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setStAtivo(o1.getStAtivo());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setOmTppt(o1.getOmTppt());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setCdTparada(o1.getCdTparada());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setDsTparada(o1.getDsTparada());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsRequerCausa(o1.getIsRequerCausa());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsRequerAcao(o1.getIsRequerAcao());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsRequerJust(o1.getIsRequerJust());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsPesa(o1.getIsPesa());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsRegulagem(o1.getIsRegulagem());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());


		o2.setIsFds(o1.getIsFds());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsMdo(o1.getIsMdo());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsMtbf(o1.getIsMtbf());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());


		o2.setIsPa(o1.getIsPa());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsPao(o1.getIsPao());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsPrev(o1.getIsPrev());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsPp(o1.getIsPp());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsPtp(o1.getIsPtp());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setIsScp(o1.getIsScp());
		Assert.assertNotSame(o1, o2);
		Assert.assertFalse(o1.hashCode() == o2.hashCode());

		o2.setQtTec(o1.getQtTec());
		Assert.assertEquals(o1, o2);
		Assert.assertTrue(o1.hashCode() == o2.hashCode());

	}

	@Test
	public void testGetCd() {
		DwTParada dwTParada = new DwTParada();

		dwTParada.setCdTparada("2");

		Assert.assertTrue(dwTParada.getCdTparada().equals(dwTParada.getCd()));

	}

	@Test
	public void testGetFieldNameCd() {
		DwTParada dwTParada = new DwTParada();
		Assert.assertTrue(dwTParada.getFieldNameCd().equals("CdTparada"));
	}

	@Test
	public void testSet() {
		DwTParada dwTParada = new DwTParada();

		long idTcau = 0;
		OmTppt omTppt = new OmTppt();
		DwTArea dwTarea = new DwTArea();
		OmUsr omUsrByIdUsrstativo = new OmUsr();
		OmUsr omUsrByIdUsrrevisao = new OmUsr();
		String cdTcau = "2";
		Long revisao = 1l;
		String dsTcau = "cau1";
		Date dtRevisao = new Date();
		Byte stAtivo = (byte) 1;
		Date dtStativo = new Date();
		Boolean isRequerCausa = true;
		Boolean isRequerAcao = true;
		Boolean isRequerJust = true;
		Boolean isPesa = true;
		Boolean isRegulagem = true;
		Boolean isFds = true;
		Boolean isMdo = true;
		Boolean isMtbf = true;

		Boolean isPa = true;
		Boolean isPao = true;
		Boolean isPrev = true;
		Boolean isPp = true;
		Boolean isPtp = true;
		Boolean isScp = true;
		Integer qtTec = 1;
		Boolean isDefault = true; 
		Boolean isSemOp = true;
		Boolean isSemConexao = true;
		Boolean isSemEvento = true;
		Boolean isPermitecorrecao = true;
		Boolean isEntradaRap = true;
		Boolean isSaidaRap = true;
		Boolean isSolicitarOS = false;

		dwTParada.set(idTcau, null, omTppt, dwTarea, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, null, cdTcau, revisao, dsTcau, dtRevisao, stAtivo, dtStativo,
				isRequerCausa, isRequerAcao, isRequerJust, isPesa, isRegulagem, isFds, isMdo, isMtbf, isPa, isPao,isPrev, isPp,
				isPtp, isScp, qtTec, isDefault, isSemOp, isSemConexao, isSemEvento, isPermitecorrecao, isEntradaRap, isSaidaRap, null, null, isSolicitarOS);

		// Referencia dos objetos devem ser iguais
		Assert.assertTrue(dwTParada.getIdTparada() == idTcau);
		Assert.assertTrue(dwTParada.getOmTppt() == omTppt);
		Assert.assertTrue(dwTParada.getDwTArea() == dwTarea);
		Assert.assertTrue(dwTParada.getOmUsrByIdUsrstativo() == omUsrByIdUsrstativo);
		Assert.assertTrue(dwTParada.getOmUsrByIdUsrrevisao() == omUsrByIdUsrrevisao);
		Assert.assertTrue( dwTParada.getCdTparada() == cdTcau);
		Assert.assertTrue(dwTParada.getRevisao() == revisao);
		Assert.assertTrue(dwTParada.getDsTparada() == dsTcau);
		Assert.assertTrue(dwTParada.getDtRevisao() == dtRevisao);
		Assert.assertTrue(dwTParada.getStAtivo() == stAtivo);
		Assert.assertTrue(dwTParada.getDtStativo() == dtStativo);
		Assert.assertTrue(dwTParada.getIsRequerCausa() == isRequerCausa);
		Assert.assertTrue(dwTParada.getIsRequerAcao() == isRequerAcao);
		Assert.assertTrue(dwTParada.getIsRequerJust() == isRequerJust);
		Assert.assertTrue(dwTParada.getIsPesa() == isPesa);
		Assert.assertTrue(dwTParada.getIsRegulagem() == isRegulagem);
		Assert.assertTrue(dwTParada.getIsFds() == isFds);
		Assert.assertTrue(dwTParada.getIsMdo() == isMdo);
		Assert.assertTrue(dwTParada.getIsMtbf() == isMtbf);

		Assert.assertTrue(dwTParada.getIsPa() == isPa);
		Assert.assertTrue(dwTParada.getIsPao() == isPao);
		Assert.assertTrue(dwTParada.getIsPrev() == isPrev);
		Assert.assertTrue(dwTParada.getIsPp() == isPp);
		Assert.assertTrue(dwTParada.getIsPtp() == isPtp);
		Assert.assertTrue(dwTParada.getIsScp() == isScp);
		Assert.assertTrue(dwTParada.getQtTec() == qtTec);
		
		Assert.assertTrue(dwTParada.getIsDefault() == isDefault);
		Assert.assertTrue(dwTParada.getIsSemConexao() == isSemConexao);
		Assert.assertTrue(dwTParada.getIsSemEvento() == isSemEvento);
		Assert.assertTrue(dwTParada.getIsSemOp() == isSemOp);

	}

	@Test
	public void testClone() {
		DwTParada o1 = new DwTParada();

		long idTcau = 0;
		OmTppt omTppt = new OmTppt();
		DwTArea dwTarea = new DwTArea();
		OmUsr omUsrByIdUsrstativo = new OmUsr();
		OmUsr omUsrByIdUsrrevisao = new OmUsr();
		String cdTcau = "2";
		Long revisao = 1l;
		String dsTcau = "cau1";
		Date dtRevisao = new Date();
		Byte stAtivo = (byte) 1;
		Date dtStativo = new Date();
		Boolean isRequerCausa = true;
		Boolean isRequerAcao = false;
		Boolean isRequerJust = true;
		Boolean isPesa = false;
		Boolean isRegulagem = true;
		Boolean isFds = false;
		Boolean isMdo = true;
		Boolean isMtbf = false;

		Boolean isPa = false;
		Boolean isPao = true;
		Boolean isPrev = false;
		Boolean isPp = true;
		Boolean isPtp = false;
		Boolean isScp = true;
		Integer qtTec = 2;
		Boolean isDefault = true; 
		Boolean isSemOp = true;
		Boolean isSemConexao = true;
		Boolean isSemEvento = true;
		Boolean isPermitecorrecao = true;
		Boolean isEntradaRap = true;
		Boolean isSaidaRap = true;
		Boolean isSolicitarOS = false;
		
		o1.set(idTcau, null, omTppt,dwTarea, omUsrByIdUsrstativo, omUsrByIdUsrrevisao, null, cdTcau, revisao, dsTcau, dtRevisao, stAtivo, dtStativo,
				isRequerCausa, isRequerAcao, isRequerJust, isPesa, isRegulagem, isFds, isMdo, isMtbf, isPa, isPao,isPrev, isPp,
				isPtp, isScp, qtTec, isDefault, isSemOp, isSemConexao, isSemEvento, isPermitecorrecao, isEntradaRap, isSaidaRap, null, null, isSolicitarOS);

		DwTParada o2 = o1.clone(false);

		Assert.assertTrue(o1.getIdTparada() == o2.getIdTparada());
		Assert.assertTrue(o2.getOmTppt() == null);
		Assert.assertTrue(o2.getDwTArea() == null);
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTparada(),o2.getCdTparada());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTparada(),o2.getDsTparada());
		Assert.assertEquals(o1.getDsTparada(),o2.getDsTparada());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertTrue(o2.getOmUsrByIdUsrstativo() == null);
		Assert.assertTrue(o2.getOmUsrByIdUsrrevisao() == null);
		Assert.assertTrue(o1.getIsRequerCausa().equals(o2.getIsRequerCausa()));
		Assert.assertTrue(o1.getIsRequerAcao().equals(o2.getIsRequerAcao()));
		Assert.assertTrue(o1.getIsRequerJust().equals(o2.getIsRequerJust()));
		Assert.assertTrue(o1.getIsPesa().equals(o2.getIsPesa()));
		Assert.assertTrue(o1.getIsRegulagem().equals(o2.getIsRegulagem()));
		Assert.assertTrue(o1.getIsFds().equals(o2.getIsFds()));
		Assert.assertTrue(o1.getIsMdo().equals(o2.getIsMdo()));
		Assert.assertTrue(o1.getIsMtbf().equals(o2.getIsMtbf()));

		Assert.assertTrue(o1.getIsPa().equals(o2.getIsPa()));
		Assert.assertTrue(o1.getIsPao().equals(o2.getIsPao()));
		Assert.assertTrue(o1.getIsPrev().equals(o2.getIsPrev()));
		Assert.assertTrue(o1.getIsPp().equals(o2.getIsPp()));
		Assert.assertTrue(o1.getIsPtp().equals(o2.getIsPtp()));
		Assert.assertTrue(o1.getIsScp().equals(o2.getIsScp()));
		Assert.assertTrue(o1.getQtTec().equals(o2.getQtTec()));
		Assert.assertTrue(o1.getIsDefault().equals(o2.getIsDefault()));
		Assert.assertTrue(o1.getIsSemConexao().equals(o2.getIsSemConexao()));
		Assert.assertTrue(o1.getIsSemEvento().equals(o2.getIsSemEvento()));
		Assert.assertTrue(o1.getIsSemEvento().equals(o2.getIsSemEvento()));
		Assert.assertTrue(o1.getIsSemOp().equals(o2.getIsSemOp()));

		o2 = o1.clone(true);

		Assert.assertTrue(o1.getIdTparada() == o2.getIdTparada());
		Assert.assertTrue(o1.getOmTppt().getIdTppt() == o2.getOmTppt().getIdTppt());
		Assert.assertEquals(o1.getOmTppt().getCdTppt(),o2.getOmTppt().getCdTppt());
		Assert.assertEquals(o1.getStAtivo(),o2.getStAtivo());
		Assert.assertEquals(o1.getCdTparada(),o2.getCdTparada());
		Assert.assertEquals(o1.getRevisao(),o2.getRevisao());
		Assert.assertEquals(o1.getDsTparada(),o2.getDsTparada());
		Assert.assertEquals(o1.getDsTparada(),o2.getDsTparada());
		Assert.assertEquals(o1.getDtRevisao(),o2.getDtRevisao());
		Assert.assertEquals(o1.getDtStativo(),o2.getDtStativo());
		Assert.assertEquals(o1.getOmUsrByIdUsrstativo().getCdUsr(),o2.getOmUsrByIdUsrstativo().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrstativo().getIdUsr() == o2.getOmUsrByIdUsrstativo().getIdUsr());
		Assert.assertEquals(o1.getOmUsrByIdUsrrevisao().getCdUsr(),o2.getOmUsrByIdUsrrevisao().getCdUsr());
		Assert.assertTrue(o1.getOmUsrByIdUsrrevisao().getIdUsr() == o2.getOmUsrByIdUsrrevisao().getIdUsr());
		Assert.assertTrue(o1.getIsRequerCausa().equals(o2.getIsRequerCausa()));
		Assert.assertTrue(o1.getIsRequerAcao().equals(o2.getIsRequerAcao()));
		Assert.assertTrue(o1.getIsRequerJust().equals(o2.getIsRequerJust()));
		Assert.assertTrue(o1.getIsPesa().equals(o2.getIsPesa()));
		Assert.assertTrue(o1.getIsRegulagem().equals(o2.getIsRegulagem()));
		Assert.assertTrue(o1.getIsFds().equals(o2.getIsFds()));
		Assert.assertTrue(o1.getIsMdo().equals(o2.getIsMdo()));
		Assert.assertTrue(o1.getIsMtbf().equals(o2.getIsMtbf()));

		Assert.assertTrue(o1.getIsPa().equals(o2.getIsPa()));
		Assert.assertTrue(o1.getIsPao().equals(o2.getIsPao()));
		Assert.assertTrue(o1.getIsPrev().equals(o2.getIsPrev()));
		Assert.assertTrue(o1.getIsPp().equals(o2.getIsPp()));
		Assert.assertTrue(o1.getIsPtp().equals(o2.getIsPtp()));
		Assert.assertTrue(o1.getIsScp().equals(o2.getIsScp()));
		Assert.assertTrue(o1.getQtTec().equals(o2.getQtTec()));
		Assert.assertTrue(o1.getIsDefault().equals(o2.getIsDefault()));
		Assert.assertTrue(o1.getIsSemConexao().equals(o2.getIsSemConexao()));
		Assert.assertTrue(o1.getIsSemEvento().equals(o2.getIsSemEvento()));
		Assert.assertTrue(o1.getIsSemEvento().equals(o2.getIsSemEvento()));
		Assert.assertTrue(o1.getIsSemOp().equals(o2.getIsSemOp()));
		

	}
	
	@Test
	public void testLimitarStrings(){
		DwTParada o1 = new DwTParada(); 
		
		o1.setCdTparada(StringUtils.repeat("1", 200));
		o1.setDsTparada(StringUtils.repeat("1", 200));
		o1.limitarStrings();
		
		Assert.assertEquals(o1.getCdTparada(), StringUtils.repeat("1",30));
		Assert.assertEquals(o1.getDsTparada(), StringUtils.repeat("1",100));
	}
	
	@Test
	public void testSetDefaultValues(){
		DwTParada dwTParada = new DwTParada();
		
		dwTParada.setIsPesa(true);
		dwTParada.setDefaultValues();
		Assert.assertEquals(dwTParada.getIsPesa(), true);
		
		dwTParada.setIsPesa(false);
		dwTParada.setDefaultValues();
		
		Assert.assertEquals(dwTParada.getIsPesa(), true);
		
	}
	
}
