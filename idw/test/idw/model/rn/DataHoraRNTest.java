package idw.model.rn;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

public class DataHoraRNTest {

	@Test
	public void getTempoIntersecaoEmSegundosComMilisegundosUsandoCalendarTest() {

		Date dtHrIPeriodo1 = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30); // 1478886606030
		Date dtHrFPeriodo1 = DataHoraRN.getDataHora(2016, 11, 11, 13, 53, 35, 290); // 1478886815290
		Date dtHrIPeriodo2 = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30); // 1478886606030
		Date dtHrFPeriodo2 = DataHoraRN.getDataHora(2016, 11, 11, 13, 53, 35, 300);// 1478886815300
		BigDecimal result =
				DataHoraRN.getTempoIntersecaoEmSegundosComMilisegundos(dtHrIPeriodo1, dtHrFPeriodo1, dtHrIPeriodo2, dtHrFPeriodo2);
		System.out.println(result.toString());
		BigDecimal target = new BigDecimal(209.260).setScale(3, RoundingMode.CEILING);
		System.out.println(target.toString());

		assertTrue(result.equals(target));

	}

	@Test
	public void getTempoIntersecaoEmSegundosComMilisegundosPassandoDateTest() {

		Date dtHrIPeriodo1 = new Date(1478886606030L); // 1478886606030
		Date dtHrFPeriodo1 = new Date(1478886815290L); // 1478886815290
		Date dtHrIPeriodo2 = new Date(1478886606030L); // 1478886606030
		Date dtHrFPeriodo2 = new Date(1478886815300L);// 1478886815300
		BigDecimal result =
				DataHoraRN.getTempoIntersecaoEmSegundosComMilisegundos(dtHrIPeriodo1, dtHrFPeriodo1, dtHrIPeriodo2, dtHrFPeriodo2);
		System.out.println(result.toString());
		BigDecimal target = new BigDecimal(209.260).setScale(3, RoundingMode.CEILING);
		System.out.println(target.toString());

		assertTrue(result.equals(target));

	}

	@Test
	public void getTempoIntersecaoEmSegundosComMilisegundosPassandoTimestampTest() {

		Timestamp dtHrIPeriodo1 = new Timestamp(1478886606030L); // 1478886606030
		Timestamp dtHrFPeriodo1 = new Timestamp(1478886815290L); // 1478886815290
		Timestamp dtHrIPeriodo2 = new Timestamp(1478886606030L); // 1478886606030
		Timestamp dtHrFPeriodo2 = new Timestamp(1478886815300L);// 1478886815300
		BigDecimal result =
				DataHoraRN.getTempoIntersecaoEmSegundosComMilisegundos(dtHrIPeriodo1, dtHrFPeriodo1, dtHrIPeriodo2, dtHrFPeriodo2);
		System.out.println(result.toString());
		BigDecimal target = new BigDecimal(209.260).setScale(3, RoundingMode.CEILING);
		System.out.println(target.toString());

		assertTrue(result.equals(target));

	}
	
	@Test 
	public void beforeEntreDateETimestampMesmaData() {		
		Timestamp dt1 = new Timestamp(1478886606030L);
		Date dt2 = new Date(1478886606030L);
		
		assertTrue(!DataHoraRN.before(dt1, dt2));		
		assertTrue(!DataHoraRN.before(dt2, dt1));
		assertTrue(!DataHoraRN.before(dt1, dt1));
		assertTrue(!DataHoraRN.before(dt2, dt2));
	}

	@Test 
	public void before() {
		long l1 = 1478886606030L;
		long l2 = 1478886606031L;
		
		Timestamp ts1 = new Timestamp(l1);
		Timestamp ts2 = new Timestamp(l2);
		Date dt1 = new Date(l1);
		Date dt2 = new Date(l2);		
		
		assertTrue(DataHoraRN.before(ts1, ts2));		
		assertTrue(DataHoraRN.before(dt1, dt2));
		assertTrue(DataHoraRN.before(dt1, ts2));
		assertTrue(DataHoraRN.before(ts1, dt2));
	}	

	@Test 
	public void after() {
		long l1 = 1478886606030L;
		long l2 = 1478886606031L;
		
		Timestamp ts1 = new Timestamp(l1);
		Timestamp ts2 = new Timestamp(l2);
		Date dt1 = new Date(l1);
		Date dt2 = new Date(l2);		
		
		assertTrue(DataHoraRN.after(ts2, ts1));		
		assertTrue(DataHoraRN.after(dt2, dt1));
		assertTrue(DataHoraRN.after(dt2, ts1));
		assertTrue(DataHoraRN.after(ts2, dt1));
	}
	
	@Test
	public void equals() {
		long l1 = 1478886606030L;
		Timestamp ts1 = new Timestamp(l1);
		Date dt1 = new Date(l1);
		
		assertTrue(DataHoraRN.equals(ts1, ts1));
		assertTrue(DataHoraRN.equals(dt1, dt1));
		assertTrue(DataHoraRN.equals(ts1, dt1));
		assertTrue(DataHoraRN.equals(dt1, ts1));
		
	}
	
	@Test 
	public void afterEntreDateETimestampMesmaData() {
		Timestamp dt1 = new Timestamp(1478886606030L);
		Date dt2 = new Date(1478886606030L);
		System.out.println(dt1.getTime());
		System.out.println(dt2.getTime());
		
		assertTrue(!DataHoraRN.after(dt1, dt2));		
		assertTrue(!DataHoraRN.after(dt2, dt1));
		assertTrue(!DataHoraRN.after(dt1, dt1));
		assertTrue(!DataHoraRN.after(dt2, dt2));
	}
	
	@Test 
	public void getTempoIntersecaoEmSegundosComMilisegundosPeriodo1MenorPeriodo2Test() {
		Date dtHrIPeriodo1 = DataHoraRN.getDataHora(2017, 6, 3, 7, 8, 23, 24);
		Date dtHrFPeriodo1 = DataHoraRN.getDataHora(2017, 6, 3, 9, 55, 18, 58);
		Date dtHrIPeriodo2 = DataHoraRN.getDataHora(2017, 6, 2, 16, 17, 14, 0);
		Date dtHrFPeriodo2 = DataHoraRN.getDataHora(2017, 6, 2, 17, 15, 0, 0);
		BigDecimal result =
				DataHoraRN.getTempoIntersecaoEmSegundosComMilisegundos(dtHrIPeriodo1, dtHrFPeriodo1, dtHrIPeriodo2, dtHrFPeriodo2);		
		BigDecimal target = BigDecimal.ZERO;
		assertTrue(result.equals(target));
	}

	@Test 
	public void getTempoIntersecaoEmSegundosComMilisegundosPeriodo1MaiorPeriodo2Test() {
		Date dtHrIPeriodo1 = DataHoraRN.getDataHora(2017, 6, 2, 16, 17, 14, 0);
		Date dtHrFPeriodo1 = DataHoraRN.getDataHora(2017, 6, 2, 17, 15, 0, 0);
		Date dtHrIPeriodo2 = DataHoraRN.getDataHora(2017, 6, 3, 7, 8, 23, 24);
		Date dtHrFPeriodo2 = DataHoraRN.getDataHora(2017, 6, 3, 9, 55, 18, 58);
		BigDecimal result =
				DataHoraRN.getTempoIntersecaoEmSegundosComMilisegundos(dtHrIPeriodo1, dtHrFPeriodo1, dtHrIPeriodo2, dtHrFPeriodo2);		
		BigDecimal target = BigDecimal.ZERO;
		assertTrue(result.equals(target));
	}
	
	@Test
	public void getMenorDataTest() {
		Date dtHr1 = DataHoraRN.getDataHora(2017, 6, 2, 16, 17, 14, 0);
		Date dtHr2 = DataHoraRN.getDataHora(2017, 6, 2, 17, 15, 0, 0);
		Date dtHr3 = DataHoraRN.getDataHora(2017, 6, 3, 7, 8, 23, 24);
		Date dtHr4 = DataHoraRN.getDataHora(2017, 6, 3, 9, 55, 18, 58);
		
		Date dthrMenor = DataHoraRN.getMenorData(dtHr1, dtHr2, dtHr3, dtHr4);
		assertTrue(DataHoraRN.equals(dthrMenor, dtHr1));
		
		dthrMenor = DataHoraRN.getMenorData(dtHr2, dtHr3, dtHr1, dtHr4);
		assertTrue(DataHoraRN.equals(dthrMenor, dtHr1));
		
		dthrMenor = DataHoraRN.getMenorData(dtHr2, dtHr1, dtHr3,null);
		assertTrue(DataHoraRN.equals(dthrMenor, dtHr1));
		
		Timestamp timestamp1 = new Timestamp(1478886606030L); // 1478886606030
		Timestamp timestamp2 = new Timestamp(1478886815290L); // 1478886815290
		Timestamp timestamp3 = new Timestamp(1478886606030L); // 1478886606030
		Timestamp timestamp4 = new Timestamp(1478886815300L);// 1478886815300
		
		dthrMenor = DataHoraRN.getMenorData(timestamp2, timestamp3, timestamp4, timestamp1);
		assertTrue(DataHoraRN.equals(dthrMenor, timestamp1));		
		
		dthrMenor = DataHoraRN.getMenorData(null, null, null);
		assertTrue(dthrMenor == null);
		
	}

	@Test
	public void getMaiorDataTest() {
		Date dtHr1 = DataHoraRN.getDataHora(2017, 6, 2, 16, 17, 14, 0);
		Date dtHr2 = DataHoraRN.getDataHora(2017, 6, 2, 17, 15, 0, 0);
		Date dtHr3 = DataHoraRN.getDataHora(2017, 6, 3, 7, 8, 23, 24);
		Date dtHr4 = DataHoraRN.getDataHora(2017, 6, 3, 9, 55, 18, 58);
		
		Date dthrMaior = DataHoraRN.getMaiorData(dtHr1, dtHr2, dtHr3, dtHr4);
		assertTrue(DataHoraRN.equals(dthrMaior, dtHr4));
		
		dthrMaior = DataHoraRN.getMaiorData(dtHr2, dtHr4, dtHr3, dtHr1);
		assertTrue(DataHoraRN.equals(dthrMaior, dtHr4));
		
		dthrMaior = DataHoraRN.getMaiorData(dtHr3, dtHr2, dtHr1, null);
		assertTrue(DataHoraRN.equals(dthrMaior, dtHr3));
		
		Timestamp timestamp1 = new Timestamp(1478886606030L); // 1478886606030
		Timestamp timestamp2 = new Timestamp(1478886815290L); // 1478886815290
		Timestamp timestamp3 = new Timestamp(1478886606030L); // 1478886606030
		Timestamp timestamp4 = new Timestamp(1478886815300L);// 1478886815300
		
		dthrMaior = DataHoraRN.getMaiorData(timestamp2, timestamp3, timestamp4, timestamp1);
		assertTrue(DataHoraRN.equals(dthrMaior, timestamp4));		
		
		dthrMaior = DataHoraRN.getMaiorData(null, null, null);
		assertTrue(dthrMaior == null);
		
		dthrMaior = DataHoraRN.getMaiorData(null, dtHr1);
		assertTrue(DataHoraRN.equals(dthrMaior, dtHr1));
		
		dthrMaior = DataHoraRN.getMaiorData(dtHr1, null);
		assertTrue(DataHoraRN.equals(dthrMaior, dtHr1));
		
	}
	
}
