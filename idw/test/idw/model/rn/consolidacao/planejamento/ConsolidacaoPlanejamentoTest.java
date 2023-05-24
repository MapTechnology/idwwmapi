package idw.model.rn.consolidacao.planejamento;

import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import idw.builders.DwCalBuilder;
import idw.builders.OmAlgocorBuilder;
import idw.builders.OmCcBuilder;
import idw.builders.OmPtBuilder;
import idw.builders.OmTpptBuilder;
import idw.builders.OmUsrBuilder;
import idw.builders.OmUsrgrpBuilder;
import idw.builders.PpCpBuilder;
import idw.model.dao.DAOGenericoTest;
import idw.model.dao.PpCpentsaiDAO;
import idw.model.pojos.DwCal;
import idw.model.pojos.OmAlgocor;
import idw.model.pojos.OmCc;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.OmUsrgrp;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpentsai;
import idw.model.rn.DataHoraRN;

public class ConsolidacaoPlanejamentoTest {

	private static DAOGenericoTest daoGenericoTest;
	private static OmUsrgrp omUsrgrp;
	private static OmUsr omUsr;
	private static OmPt omPt;
	private static OmTppt omTppt;
	private static OmAlgocor omAlgocor;
	private static OmCc omCc;
	private static PpCp ppCp;
	private static PpCpentsaiDAO ppCpentsaiDAO;
	private static ConsolidacaoPlanejamento consolidacaoPlanejamento;
	private static DwCal dwCal;
	private static PpCp ppCp2;

	@BeforeClass
	public static void setUp() throws Exception {
		daoGenericoTest = new DAOGenericoTest();
		daoGenericoTest.iniciaSessao();
		//daoGenericoTest.iniciaConexaoBanco();
		
		Transaction tx = daoGenericoTest.getSession().beginTransaction();
		
		daoGenericoTest.iniciaTransacao();
		omUsrgrp = new OmUsrgrpBuilder().buildAndPersist(daoGenericoTest);		
		omUsr = new OmUsrBuilder().withOmUsrgrp(omUsrgrp).buildAndPersist(daoGenericoTest);
		omCc = new OmCcBuilder().withOmUsrrevisao(omUsr).withOmUsrstativo(omUsr).buildAndPersist(daoGenericoTest);		
		omAlgocor = new OmAlgocorBuilder().buildAndPersist(daoGenericoTest);
		omTppt = new OmTpptBuilder().withOmAlgocor(omAlgocor).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		omPt = new OmPtBuilder().withOmCc(omCc).withOmTppt(omTppt).withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).withStAtivo((byte)1).buildAndPersist(daoGenericoTest);
		dwCal = new DwCalBuilder().withOmUsrRevisao(omUsr).withOmUsrStAtivo(omUsr).buildAndPersist(daoGenericoTest);
		ppCp = new PpCpBuilder().withOmPt(omPt).withDwCal(dwCal).buildAndPersist(daoGenericoTest);
		ppCp2 = new PpCpBuilder().withCdPpCp("2").withOmPt(omPt).withDwCal(dwCal).buildAndPersist(daoGenericoTest);

		
		ppCpentsaiDAO = new PpCpentsaiDAO(daoGenericoTest.getSession());
		consolidacaoPlanejamento = new ConsolidacaoPlanejamento(daoGenericoTest);
		
		tx.commit();
		
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		daoGenericoTest.finalizaSessao();
		daoGenericoTest = null;
	}
	
	@Test
	public void setInicioPpCpentsaiComTabelaVazia() {
		try {
			daoGenericoTest.iniciaTransacao();
			
			Date dthrInicio = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30);			
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio);
			
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			Assert.assertEquals(ppCpentsai.getDthrInicio(), dthrInicio);
			Assert.assertEquals(ppCpentsai.getDthrFim(), null);			
			
		} finally {
			daoGenericoTest.rollBackTransacao();
		}
	}

	
	@Test
	public void setInicioPpCpentsaiQuandoJaTemParaMesmoCp() {
		try {
			daoGenericoTest.iniciaTransacao();
			
			Date dthrInicio = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30);			
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio);
			
			Date dthrInicio2 = DataHoraRN.getDataHora(2016, 11, 12, 13, 50, 6, 30);
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio2);
			
			Date dthrInicio3 = DataHoraRN.getDataHora(2016, 11, 10, 13, 50, 6, 30);
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio3);
			
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			Assert.assertEquals(dthrInicio, ppCpentsai.getDthrInicio());
			Assert.assertEquals(null, ppCpentsai.getDthrFim());
			
		} finally {
			daoGenericoTest.rollBackTransacao();
		}
	}
	
	@Test
	public void setInicioPpCpentsaiComMesmoCpFechado() {
		try {
			daoGenericoTest.iniciaTransacao();
			
			// novo PpCpentsai com fim
			Date dthrInicio = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30);			
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio);
			Date dthrFim = DataHoraRN.getDataHora(2016, 11, 12, 13, 50, 6, 30);
			consolidacaoPlanejamento.setFimPpCpentsai(ppCp, omPt, dthrFim);
			
			Date dthrInicio2 = DataHoraRN.getDataHora(2016, 11, 13, 13, 50, 6, 30);
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio2);
			
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			Assert.assertEquals(dthrInicio2, ppCpentsai.getDthrInicio());
			Assert.assertEquals(null, ppCpentsai.getDthrFim());
			
		} finally {
			daoGenericoTest.rollBackTransacao();
		}
	}

	@Test
	public void setInicioPpCpentsaiComMesmoCpFechadoInicioAnterior() {
		try {
			daoGenericoTest.iniciaTransacao();
			
			// novo PpCpentsai com fim
			Date dthrInicio = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30);			
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio);
			Date dthrFim = DataHoraRN.getDataHora(2016, 11, 12, 13, 50, 6, 30);
			consolidacaoPlanejamento.setFimPpCpentsai(ppCp, omPt, dthrFim);
			
			Date dthrInicio2 = DataHoraRN.getDataHora(2016, 11, 12, 10, 50, 6, 30);
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio2);
			
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			Assert.assertEquals(dthrFim, ppCpentsai.getDthrInicio());
			Assert.assertEquals(null, ppCpentsai.getDthrFim());
			
		} finally {
			daoGenericoTest.rollBackTransacao();
		}
	}

	@Test
	public void setInicioPpCpentsaiComMesmoCpDiferenteAberto() {
		try {
			daoGenericoTest.iniciaTransacao();

			Date dthrInicio = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30);			
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio);
			
			Date dthrInicio2 = DataHoraRN.getDataHora(2016, 11, 13, 13, 50, 6, 30);
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp2, omPt, dthrInicio2);
			
			List<PpCpentsai> lista = ppCpentsaiDAO.getPpCpentsai(omPt);
			Assert.assertEquals(2, lista.size());
			PpCpentsai ppCpentsaiAnterior = lista.get(1);
			Assert.assertEquals(ppCpentsaiAnterior.getDthrInicio(), dthrInicio);
			Assert.assertEquals(ppCpentsaiAnterior.getDthrFim(), dthrInicio2);
			
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			Assert.assertEquals(dthrInicio2, ppCpentsai.getDthrInicio());
			Assert.assertEquals(null, ppCpentsai.getDthrFim());
			
		} finally {
			daoGenericoTest.rollBackTransacao();
		}
	}
	
	@Test
	public void setFimPpCpentsaiComTabelaVazia() {
		try {
			daoGenericoTest.iniciaTransacao();
			
			Date dthrFim = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30);			
			consolidacaoPlanejamento.setFimPpCpentsai(ppCp, omPt, dthrFim);
			
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			Assert.assertEquals(ppCpentsai.getDthrInicio(), dthrFim);
			Assert.assertEquals(ppCpentsai.getDthrFim(), dthrFim);			
			
		} finally {
			daoGenericoTest.rollBackTransacao();
		}
	}

	@Test
	public void setFimPpCpentsai() {
		try {
			daoGenericoTest.iniciaTransacao();
			
			Date dthrInicio = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30);			
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio);
			Date dthrFim = DataHoraRN.getDataHora(2016, 11, 12, 13, 50, 6, 30);
			consolidacaoPlanejamento.setFimPpCpentsai(ppCp, omPt, dthrFim);
			
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			Assert.assertEquals(ppCpentsai.getDthrInicio(), dthrInicio);
			Assert.assertEquals(ppCpentsai.getDthrFim(), dthrFim);			
			
		} finally {
			daoGenericoTest.rollBackTransacao();
		}
	}

	@Test
	public void setFimPpCpentsaiMenorInicio() {
		try {
			daoGenericoTest.iniciaTransacao();
			
			Date dthrInicio = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30);			
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio);
			Date dthrFim = DataHoraRN.getDataHora(2016, 11, 10, 13, 50, 6, 30);
			consolidacaoPlanejamento.setFimPpCpentsai(ppCp, omPt, dthrFim);
			
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			Assert.assertEquals(ppCpentsai.getDthrInicio(), dthrInicio);
			Assert.assertEquals(ppCpentsai.getDthrFim(), dthrInicio);			
			
		} finally {
			daoGenericoTest.rollBackTransacao();
		}
	}

	@Test
	public void setFimPpCpentsaiCpDiferente() {
		try {
			daoGenericoTest.iniciaTransacao();
			
			Date dthrInicio = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30);			
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio);
			Date dthrFim = DataHoraRN.getDataHora(2016, 11, 12, 13, 50, 6, 30);
			consolidacaoPlanejamento.setFimPpCpentsai(ppCp2, omPt, dthrFim);
			
			List<PpCpentsai> lista = ppCpentsaiDAO.getPpCpentsai(omPt);
			Assert.assertEquals(2, lista.size());
			PpCpentsai ppCpentsaiAnterior = lista.get(1);
			Assert.assertEquals(ppCpentsaiAnterior.getDthrInicio(), dthrInicio);
			Assert.assertEquals(ppCpentsaiAnterior.getDthrFim(), dthrFim);
			
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			Assert.assertEquals(ppCpentsai.getDthrInicio(), dthrFim);
			Assert.assertEquals(ppCpentsai.getDthrFim(), dthrFim);
			Assert.assertEquals(ppCp2.getIdCp(), ppCpentsai.getPpCp().getIdCp());	
			
		} finally {
			daoGenericoTest.rollBackTransacao();
		}
	}
	
	@Test
	public void setFimPpCpentsaiMesmoFimEnviadoMaisUmVez() {
		try {
			daoGenericoTest.iniciaTransacao();
			
			Date dthrInicio = DataHoraRN.getDataHora(2016, 11, 11, 13, 50, 6, 30);			
			consolidacaoPlanejamento.setInicioPpCpentsai(ppCp, omPt, dthrInicio);
			Date dthrFim = DataHoraRN.getDataHora(2016, 11, 12, 13, 50, 6, 30);
			consolidacaoPlanejamento.setFimPpCpentsai(ppCp, omPt, dthrFim);
			 
			consolidacaoPlanejamento.setFimPpCpentsai(ppCp, omPt, dthrFim);
			
			List<PpCpentsai> lista = ppCpentsaiDAO.getPpCpentsai(omPt);
			Assert.assertEquals(1, lista.size());
			
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			Assert.assertEquals(ppCpentsai.getDthrInicio(), dthrInicio);
			Assert.assertEquals(ppCpentsai.getDthrFim(), dthrFim);
			Assert.assertEquals(ppCp.getIdCp(), ppCpentsai.getPpCp().getIdCp());	
			
		} finally {
			daoGenericoTest.rollBackTransacao();
		}
	}
}
