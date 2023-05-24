package idw.model.rn.geraplano.passos.tipoB;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.dao.OmGtDAO;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmObj;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpPlancol;
import idw.model.pojos.PpPlano;
import idw.model.pojos.PpPlanptgt;
import idw.model.rn.PTRN;
import idw.util.Util;

public class TipoBGeraLayout {

	private DAOGenerico dao;
	private List<OmObj> cdPt = new ArrayList<OmObj>();
	private List<OmObj> cdGt = new ArrayList<OmObj>();
	
	public TipoBGeraLayout(DAOGenerico dao){
		this.dao = dao;
	}
	
	public void geraLayout(PpPlano ppplano){
	
		geraLayoutDefinindoColunas(ppplano);
		
		OmCfg omcfg = Util.getConfigGeral(dao.getSession());
		
		Integer tipoLayout = omcfg.getTpLayoutplano();
		
		if (tipoLayout == null)
			tipoLayout = 1; // outros que nao a panasonic
		
		if ( tipoLayout == 0 ){
			inicializaPanasonic();
			geraLayoutParaAba(ppplano, null);
			geraLayoutParaAba(ppplano, "Geral");
		} else {
			inicializaSemp();
			geraLayoutParaAba(ppplano, null);
			geraLayoutParaAba(ppplano, "Geral");
		}
	}
	
	private void inicializaSemp(){
		MapQuery q = new MapQuery(dao.getSession());
		
		q.append("select distinct ompt");
		q.append("from OmPt ompt");
		q.append("where ompt.stAtivo = 1");
		q.append("order by ompt.cdPt");
		
		List<OmPt> lista = q.list();
		
		int linha = 0;
		int coluna = 0;
		
		for (OmPt ompt : lista){
			OmObj ms1 = new OmObj();
			ms1.setX(new BigDecimal(coluna++));
			ms1.setY(new BigDecimal(linha));
			ms1.setOmPt(new OmPt());
			ms1.getOmPt().setCdPt(ompt.getCdPt());
			
			cdPt.add(ms1);

		}
	}
	
	private void inicializaPanasonic(){
		OmObj ms1 = new OmObj();
		ms1.setX(new BigDecimal(0));
		ms1.setY(new BigDecimal(0));
		ms1.setOmPt(new OmPt());
		ms1.getOmPt().setCdPt("MS1");
		
		OmObj ms2 = new OmObj();
		ms2.setX(new BigDecimal(1));
		ms2.setY(new BigDecimal(0));
		ms2.setOmPt(new OmPt());
		ms2.getOmPt().setCdPt("MS2");

		OmObj jvk1 = new OmObj();
		jvk1.setX(new BigDecimal(0));
		jvk1.setY(new BigDecimal(1));
		jvk1.setOmPt(new OmPt());
		jvk1.getOmPt().setCdPt("JVK-1");

		OmObj jvk2 = new OmObj();
		jvk2.setX(new BigDecimal(1));
		jvk2.setY(new BigDecimal(1));
		jvk2.setOmPt(new OmPt());
		jvk2.getOmPt().setCdPt("JVK-2");

		OmObj jvk3 = new OmObj();
		jvk3.setX(new BigDecimal(2));
		jvk3.setY(new BigDecimal(1));
		jvk3.setOmPt(new OmPt());
		jvk3.getOmPt().setCdPt("JVK-3");

		OmObj avk1 = new OmObj();
		avk1.setX(new BigDecimal(0));
		avk1.setY(new BigDecimal(2));
		avk1.setOmPt(new OmPt());
		avk1.getOmPt().setCdPt("AVK-1");

		OmObj avk2 = new OmObj();
		avk2.setX(new BigDecimal(1));
		avk2.setY(new BigDecimal(2));
		avk2.setOmPt(new OmPt());
		avk2.getOmPt().setCdPt("AVK-2");

		OmObj rh1 = new OmObj();
		rh1.setX(new BigDecimal(0));
		rh1.setY(new BigDecimal(3));
		rh1.setOmPt(new OmPt());
		rh1.getOmPt().setCdPt("RH-1");

		OmObj rh2 = new OmObj();
		rh2.setX(new BigDecimal(1));
		rh2.setY(new BigDecimal(3));
		rh2.setOmPt(new OmPt());
		rh2.getOmPt().setCdPt("RH-2");

		OmObj rh4 = new OmObj();
		rh4.setX(new BigDecimal(2));
		rh4.setY(new BigDecimal(3));
		rh4.setOmPt(new OmPt());
		rh4.getOmPt().setCdPt("RH-4");

		OmObj smd1 = new OmObj();
		smd1.setX(new BigDecimal(0));
		smd1.setY(new BigDecimal(4));
		smd1.setOmGtByIdGtfilho(new OmGt());
		smd1.getOmGtByIdGtfilho().setCdGt("SMD_L1");

		OmObj smd2 = new OmObj();
		smd2.setX(new BigDecimal(1));
		smd2.setY(new BigDecimal(4));
		smd2.setOmGtByIdGtfilho(new OmGt());
		smd2.getOmGtByIdGtfilho().setCdGt("SMD_L2");

		OmObj smd3 = new OmObj();
		smd3.setX(new BigDecimal(2));
		smd3.setY(new BigDecimal(4));
		smd3.setOmGtByIdGtfilho(new OmGt());
		smd3.getOmGtByIdGtfilho().setCdGt("SMD_L3");

		OmObj smd4 = new OmObj();
		smd4.setX(new BigDecimal(3));
		smd4.setY(new BigDecimal(4));
		smd4.setOmGtByIdGtfilho(new OmGt());
		smd4.getOmGtByIdGtfilho().setCdGt("SMD_L4");

		OmObj smd5 = new OmObj();
		smd5.setX(new BigDecimal(4));
		smd5.setY(new BigDecimal(4));
		smd5.setOmGtByIdGtfilho(new OmGt());
		smd5.getOmGtByIdGtfilho().setCdGt("SMD_L5");

		OmObj smd6 = new OmObj();
		smd6.setX(new BigDecimal(5));
		smd6.setY(new BigDecimal(4));
		smd6.setOmGtByIdGtfilho(new OmGt());
		smd6.getOmGtByIdGtfilho().setCdGt("SMD_L6");

		cdPt.add(ms1);
		cdPt.add(ms2);
		cdPt.add(jvk1);
		cdPt.add(jvk2);
		cdPt.add(jvk3);
		cdPt.add(avk1);
		cdPt.add(avk2);
		cdPt.add(rh1);
		cdPt.add(rh2);
		cdPt.add(rh4);
		
		cdGt.add(smd1);
		cdGt.add(smd2);
		cdGt.add(smd3);
		cdGt.add(smd4);
		cdGt.add(smd5);
		cdGt.add(smd6);
	}
	
	private void geraLayoutParaAba(PpPlano ppplano, String aba){
		
		// Configura os CTs que ser�o mostrados na interface
		if (ppplano.getPpPlanptgts() == null || ppplano.getPpPlanptgts().size() <= 0){
			
			PTRN ptRN = new PTRN();
			ptRN.setDaoSession(dao.getSession());
			
			OmGtDAO gtDAO = new OmGtDAO(dao.getSession());

			for (OmObj cd : cdPt){
				PpPlanptgt p1 = new PpPlanptgt();

				p1.setIdPlanptgt(null);
				p1.setOmGt(null);
				p1.setOmPt(null);
				p1.setPpPlano(ppplano);
				p1.setIsCoordenadarelativa(true);
				p1.setLinha(cd.getY());
				p1.setColuna(cd.getX());

				OmPt ompt = ptRN.pesquisarPtByCdPtStAtivo(cd.getOmPt().getCdPt());
				p1.setOmPt(ompt);
				
				if (aba == null) {
					if (ompt.getOmTppt().getDsTppt().length() > 40)
						p1.setAba(ompt.getOmTppt().getCdTppt().substring(0, 40));
					else
						p1.setAba(ompt.getOmTppt().getCdTppt());
				} else {
					p1.setAba(aba);
				}

				if (p1.getAba().equals("ILH"))
					p1.setAba("1-ILH");
				else if (p1.getAba().equals("JUP"))
					p1.setAba("2-JUP");
				else if (p1.getAba().equals("AXI"))
					p1.setAba("3-AXI");
				else if (p1.getAba().equals("RAD"))
					p1.setAba("4-RAD");
				else if (p1.getAba().equals("SMD"))
					p1.setAba("5-SMD");
				else if (p1.getAba().equals("IMC"))
					p1.setAba("6-IMC");
				else if (p1.getAba().equals("PMO"))
					p1.setAba("7-LF");
				else
					p1.setAba("8-Geral");
				
				dao.makePersistent(p1);
				
			}

			for (OmObj cd : cdGt){
				PpPlanptgt p1 = new PpPlanptgt();
				p1.setIdPlanptgt(null);
				p1.setLinha(cd.getY());
				p1.setColuna(cd.getX());
				p1.setOmGt(null);
				p1.setOmPt(null);
				p1.setPpPlano(ppplano);
				p1.setIsCoordenadarelativa(true);

				OmGt omgt = gtDAO.getOmGtPorCdAtivo(cd.getOmGtByIdGtfilho().getCdGt());
				
				p1.setOmGt(omgt);
				
				if (aba == null) {
					if (omgt.getOmTpgt().getDsTpgt().length() > 40)
						p1.setAba(omgt.getOmTpgt().getCdTpgt().substring(0, 40));
					else
						p1.setAba(omgt.getOmTpgt().getCdTpgt());
				} else {
					p1.setAba(aba);
				}

				if (p1.getAba().equals("ILH"))
					p1.setAba("1-ILH");
				else if (p1.getAba().equals("JUP"))
					p1.setAba("2-JUP");
				else if (p1.getAba().equals("AXI"))
					p1.setAba("3-AXI");
				else if (p1.getAba().equals("RAD"))
					p1.setAba("4-RAD");
				else if (p1.getAba().equals("SMD"))
					p1.setAba("5-SMD");
				else
					p1.setAba("6-Geral");

				dao.makePersistent(p1);
				
			}
		}
	}


	private void geraLayoutDefinindoColunas(PpPlano ppplano){
		// Configura as colunas que serao mostradas na interface
		PpPlancol ppplancol = null;
		for (PpPlancol p : ppplano.getPpPlancols()){
			ppplancol = p;
		}
		if (ppplancol == null){
			ppplancol = new PpPlancol();
			ppplancol.setIdPlancol(null);
			ppplancol.setPpPlano(ppplano);
		}
		
		ppplancol.setIsAcuml(true);
		ppplancol.setIsDtcobertura(false);
		ppplancol.setIsId(false);
		ppplancol.setIsFim(true);
		ppplancol.setIsInicio(true);
		ppplancol.setIsNcjt(true);
		ppplancol.setIsProdhora(true);
		ppplancol.setIsProduto(true);
		ppplancol.setIsQtcjt(true);
		ppplancol.setIsQtdmagaz(false);
		ppplancol.setIsTurno(false);
		ppplancol.setIsTmpestim(true);
		ppplancol.setIsSt(true);
		ppplancol.setIsApAberta(true);
		ppplancol.setIsQtplan(true);
		ppplancol.setIsRoteiro(true);

		dao.makePersistent(ppplancol);
	}
}
