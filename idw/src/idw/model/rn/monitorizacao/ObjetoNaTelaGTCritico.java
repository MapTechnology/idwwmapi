package idw.model.rn.monitorizacao;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idw.model.dao.DAOGenerico;
import idw.model.dao.OmObjDAO;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.DwTurno;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmCfgabclim;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmObj;
import idw.model.pojos.template.DwConsolidTemplate;
import idw.model.pojos.template.OmCfgabclimTemplate.TpClasseABC;
import idw.model.pojos.template.OmPtTemplate.TpClasseABCCritica;
import idw.model.rn.classificacaoabc.ClassificacaoABCRN;
import idw.model.rn.detalhemonitorizacao.DetalheMonitorizacaoPTInsertRN;
import idw.util.IdwLogger;
import idw.webservices.dto.ColorDTO;
import idw.webservices.dto.FiltroDetalhePTInjetDTO;
import idw.webservices.dto.ObjRtMonitorizacaoDTO;
import idw.webservices.dto.PtDTO;

public class ObjetoNaTelaGTCritico {
	private final ClassificacaoABCRN classificacaoABCRN;
	private final IdwLogger log;
	private final DAOGenerico dao;
	private final Map<TpClasseABC, OmCfgabclim> limitesAbc;
	
	public ObjetoNaTelaGTCritico(DAOGenerico dao, IdwLogger log, OmCfg omcfg) {
		this.log = log;
		this.dao = dao;
		this.classificacaoABCRN = new ClassificacaoABCRN(dao);
		this.limitesAbc = classificacaoABCRN.getLimitesClassesABC(omcfg.getOmCfgabc());
	}
	
	public void criarDadosParaGtCritico(ObjRtMonitorizacaoDTO retorno, OmObj omobj,  
			Date dtreferencia, DwTurno dwturno, DwConsolidTemplate.TpId tpId, 
			boolean isTurnoAtual, Integer filtroOp) {
	
		List<DwConsolid> ids;
		DetalheMonitorizacaoPTInsertRN rnid =  new DetalheMonitorizacaoPTInsertRN(this.dao);
		FiltroDetalhePTInjetDTO filtro = new FiltroDetalhePTInjetDTO();
		
		filtro.setDtReferencia(dtreferencia);
		filtro.setDwTurno(dwturno);
		filtro.setTpId(tpId.getValue());
		filtro.setOmGt(omobj.getOmGtByIdGtfilho());
		filtro.setFiltroOp(filtroOp);
		
		ids = rnid.pesquisarDwConsolids(log, filtro);
		
		BigDecimal oeeInfClasseA = limitesAbc.get(TpClasseABC.CLASSE_A).getLimiteInf();
		BigDecimal oeeSupClasseA = limitesAbc.get(TpClasseABC.CLASSE_A).getLimiteSup();
		BigDecimal oeeInfClasseB = limitesAbc.get(TpClasseABC.CLASSE_B).getLimiteInf();
		BigDecimal oeeSupClasseB = limitesAbc.get(TpClasseABC.CLASSE_B).getLimiteSup();
		BigDecimal oeeInfClasseC = limitesAbc.get(TpClasseABC.CLASSE_C).getLimiteInf();
		BigDecimal oeeSupClasseC = limitesAbc.get(TpClasseABC.CLASSE_C).getLimiteSup();
		
		Map<Byte, List<DwConsolid>> listaSeparadaDeIds = new HashMap<>();
		Map<Byte, List<PtDTO>> pts = new HashMap<>();
		
		/* Separar dwconsolid por tipo de classificacao abc
		 * 
		 */
		separaIdsPorClasse(ids, pts, listaSeparadaDeIds);
		

		/*
		 * Verre os ids conforme a classe do PT
		 */
		for (Byte tpClasseABC : listaSeparadaDeIds.keySet()) {
			List<DwConsolid> listaAux = listaSeparadaDeIds.get(tpClasseABC);
			
			// Calcula o oee com base nos ids
			BigDecimal oee = classificacaoABCRN.calcularOEE(listaAux);
			
			
			// Inicializa retorno conforme a classe ABC
			// Calcular oee
			if (tpClasseABC == null || TpClasseABCCritica.CLASSE_A.equals(tpClasseABC)) { // classe A
				retorno.setIndOEEClasseA(oee.doubleValue());
				// Determina a cor do GT
				if (retorno.getIndOEEClasseA() <= oeeInfClasseA.doubleValue()) {
					retorno.setCorGtClasseA(new ColorDTO(Color.RED));
				} else if (retorno.getIndOEEClasseA() > oeeInfClasseA.doubleValue() && retorno.getIndOEEClasseA() <= oeeSupClasseA.doubleValue()) {
					retorno.setCorGtClasseA(new ColorDTO(Color.YELLOW));
				} else if (retorno.getIndOEEClasseA() > oeeSupClasseA.doubleValue()) {
					retorno.setCorGtClasseA(new ColorDTO(Color.GREEN));
				}
				retorno.setIndOEEMetaClasseA(oeeSupClasseA.doubleValue());

			} else if (TpClasseABCCritica.CLASSE_B.equals(tpClasseABC)) { // classe B
				retorno.setIndOEEClasseB(oee.doubleValue());
				// Determina a cor do GT
				if (retorno.getIndOEEClasseB() <= oeeInfClasseB.doubleValue()) {
					retorno.setCorGtClasseb(new ColorDTO(Color.RED));
				} else if (retorno.getIndOEEClasseB() > oeeInfClasseB.doubleValue() && retorno.getIndOEEClasseB() <= oeeSupClasseB.doubleValue()) {
					retorno.setCorGtClasseb(new ColorDTO(Color.YELLOW));
				} else if (retorno.getIndOEEClasseB() > oeeSupClasseB.doubleValue()) {
					retorno.setCorGtClasseb(new ColorDTO(Color.GREEN));
				}
				retorno.setIndOEEMetaClasseB(oeeSupClasseB.doubleValue());

			} else if (TpClasseABCCritica.CLASSE_C.equals(tpClasseABC)) { // classe C
				retorno.setIndOEEClasseC(oee.doubleValue());
				// Determina a cor do GT
				if (retorno.getIndOEEClasseC() <= oeeInfClasseC.doubleValue()) {
					retorno.setCorGtClasseC(new ColorDTO(Color.RED));
				} else if (retorno.getIndOEEClasseC() > oeeInfClasseC.doubleValue() && retorno.getIndOEEClasseC() <= oeeSupClasseC.doubleValue()) {
					retorno.setCorGtClasseC(new ColorDTO(Color.YELLOW));
				} else if (retorno.getIndOEEClasseC() > oeeSupClasseC.doubleValue()) {
					retorno.setCorGtClasseC(new ColorDTO(Color.GREEN));
				}
				retorno.setIndOEEMetaClasseC(oeeSupClasseC.doubleValue());

			}
		}

		// Contabiliza a quantidade de postos por classe
		contabilizaQtdePostosPorClasse(retorno, omobj.getOmGtByIdGtfilho(), pts);
	}

	
	private void contabilizaQtdePostosPorClasse(ObjRtMonitorizacaoDTO retorno, OmGt omgt, Map<Byte, List<PtDTO>> pts) {
		// Pesquisar os objetos do OmObj
		OmObjDAO objDAO = new OmObjDAO(this.dao.getSession());
		List<OmObj> listaobj = objDAO.pesquisarOmObsByOmGt(omgt);

		int classeA = 0;
		int classeB = 0;
		int classeC = 0;
		
		for (OmObj obj : listaobj) {
			if (obj.getOmPt() != null && obj.getOmPt().getTpClasseabc().equals(TpClasseABCCritica.CLASSE_A.getValue())) {
				classeA++;
				retorno.setQtdePostosClasseA(classeA);
				retorno.setPtsClasseA(pts.get(TpClasseABCCritica.CLASSE_A.getValue()));
				
				if (!isMaquinaNaClasse(pts.get(TpClasseABCCritica.CLASSE_A.getValue()), obj)){
					//Marcos Sardinha: 2017-06-01 pts provavelmente sem conexao ou dados no periodo
					PtDTO ptAux = new PtDTO();
					ptAux.setPt(obj.getOmPt().clone(false));
					
					if (retorno.getPtsClasseA() == null){
						retorno.setPtsClasseA(new ArrayList<PtDTO>());
					}
					
					retorno.getPtsClasseA().add(ptAux); 
				}
				
			} else if (obj.getOmPt() != null && obj.getOmPt().getTpClasseabc().equals(TpClasseABCCritica.CLASSE_B.getValue())) {
				classeB++;
				retorno.setQtdePostosClasseB(classeB);
				retorno.setPtsClasseB(pts.get(TpClasseABCCritica.CLASSE_B.getValue()));
				
				if (!isMaquinaNaClasse(pts.get(TpClasseABCCritica.CLASSE_B.getValue()), obj)){
					//Marcos Sardinha: 2017-06-01 pts provavelmente sem conexao ou dados no periodo
					PtDTO ptAux = new PtDTO();
					ptAux.setPt(obj.getOmPt().clone(false));

					if (retorno.getPtsClasseB() == null){
						retorno.setPtsClasseB(new ArrayList<PtDTO>());
					}
					
					retorno.getPtsClasseB().add(ptAux); 
				}
				
			} if (obj.getOmPt() != null && obj.getOmPt().getTpClasseabc().equals(TpClasseABCCritica.CLASSE_C.getValue())) {
				classeC++;
				retorno.setQtdePostosClasseC(classeC);
				retorno.setPtsClasseC(pts.get(TpClasseABCCritica.CLASSE_C.getValue()));
				
				if (!isMaquinaNaClasse(pts.get(TpClasseABCCritica.CLASSE_C.getValue()), obj)){
					//Marcos Sardinha: 2017-06-01 pts provavelmente sem conexao ou dados no periodo
					PtDTO ptAux = new PtDTO();
					ptAux.setPt(obj.getOmPt().clone(false));
					
					if (retorno.getPtsClasseC() == null){
						retorno.setPtsClasseC(new ArrayList<PtDTO>());
					}
					
					retorno.getPtsClasseC().add(ptAux); 
				}				
			}
		}
	}
	
	private boolean isMaquinaNaClasse(List<PtDTO> pts, OmObj obj) {
		boolean achou = false;
		if (pts != null){
			for (PtDTO pt : pts) {
				if (pt.getPt().getCdPt().equals(obj.getOmPt().getCdPt())) {
					achou = true;
					break;
				}
			}		
		}
		return achou;
	}
		
	private void separaIdsPorClasse(List<DwConsolid> ids, Map<Byte, List<PtDTO>> pts, Map<Byte, List<DwConsolid>> listaSeparadaDeIds) {
		for (DwConsolid id : ids) {
			Byte tpClasseabc = TpClasseABCCritica.CLASSE_C.getValue(); // classe c. Se o PT nao tiver uma classificacao ele vai para classe C
			

			// Separa os postos por classe
			if (id.getOmPt() != null) {
				if (id.getOmPt().getTpClasseabc() != null)
					tpClasseabc = id.getOmPt().getTpClasseabc();

				// Contabiliza os pts
				if ( pts.containsKey(tpClasseabc) ) {
					List<PtDTO> ptsAux = pts.get(tpClasseabc);
					// Verificar se ja existe na lista
					boolean isExiste = false;
					for (PtDTO ptdto : ptsAux) {
						if (ptdto.getPt().getCdPt().equals(id.getOmPt().getCdPt())) {
							isExiste = true;
							break;
						}
					}
					if (isExiste == false) {
						PtDTO ptdto = new PtDTO();
						ptdto.setPt(id.getOmPt().clone(false));
						ptsAux.add(ptdto);
						pts.put(tpClasseabc, ptsAux);
					}
				} else {
					List<PtDTO> ptsAux = new ArrayList<>();
					PtDTO ptdto = new PtDTO();
					ptdto.setPt(id.getOmPt().clone(false));
					ptsAux.add(ptdto);
					pts.put(tpClasseabc, ptsAux);
				}
			}
			// separa os ids por classe
			if (listaSeparadaDeIds.containsKey(tpClasseabc)) {
				// separa dwconsolid por tipo de classe
				List<DwConsolid> listaAux = listaSeparadaDeIds.get(tpClasseabc);
				listaAux.add(id);
				listaSeparadaDeIds.put(tpClasseabc, listaAux);
			} else {
				List<DwConsolid> listaAux = new ArrayList<>();
				listaAux.add(id);
				listaSeparadaDeIds.put(tpClasseabc, listaAux);
			}
		}
	}
}
