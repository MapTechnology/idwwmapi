package idw.model.pojos;

import idw.model.rn.DataHoraRN;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DwConsolpalogTest {

	@Test
	public void testIsDataHoraDentroParadaComRegulagem() {
		DwConsolpalog dwconsolpalog =  new DwConsolpalog();
		dwconsolpalog.setDwTParada(new DwTParada());
		dwconsolpalog.getDwTParada().setIsRegulagem(true);
		
		Date dtHr = DataHoraRN.getDataHora(2014, 03, 07, 10, 0, 0, 0);
		dwconsolpalog.setDthrIparada(DataHoraRN.getDataHora(2014, 03, 07, 10, 0, 0, 0));		
		Assert.assertTrue(dwconsolpalog.isDtHrDentroParadaComRegulagem(dtHr));
		
		dwconsolpalog.setDthrIparada(DataHoraRN.getDataHora(2014, 03, 07, 10, 0, 1, 0));		
		Assert.assertFalse(dwconsolpalog.isDtHrDentroParadaComRegulagem(dtHr));
		
		
	}
	
	@Test
	public void testIsDataHoraDentroParada() {
		DwConsolpalog dwconsolpalog =  new DwConsolpalog();
		
		Date dtHr = DataHoraRN.getDataHora(2014, 03, 07, 10, 0, 0, 0);
		
		dwconsolpalog.setDthrIparada(dtHr);		
		Assert.assertTrue(dwconsolpalog.isDtHrDentroParadaSemConsiderarIgualAoInicioOuFim(dtHr));
		
		dwconsolpalog.setDthrIparada(DataHoraRN.getDataHora(2014, 03, 07, 10, 0, 1, 0));		
		Assert.assertFalse(dwconsolpalog.isDtHrDentroParadaSemConsiderarIgualAoInicioOuFim(dtHr));
		
		dtHr = DataHoraRN.getDataHora(2014, 03, 07, 10, 50, 0, 0);
		Assert.assertTrue(dwconsolpalog.isDtHrDentroParadaSemConsiderarIgualAoInicioOuFim(dtHr));
		
		dwconsolpalog.setDthrFparada(DataHoraRN.subtraiSegundosDaData(dtHr, 10));
		Assert.assertFalse(dwconsolpalog.isDtHrDentroParadaSemConsiderarIgualAoInicioOuFim(dtHr));		

		dwconsolpalog.setDthrFparada(DataHoraRN.adicionaSegundosNaData(dtHr, 10));
		Assert.assertTrue(dwconsolpalog.isDtHrDentroParadaSemConsiderarIgualAoInicioOuFim(dtHr));
		
	}

}
