package idw.model.rn.consolidacao.planejamento;

import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.PpCpentsaiDAO;
import idw.model.pojos.DwConsolid;
import idw.model.pojos.OmPt;
import idw.model.pojos.PpCp;
import idw.model.pojos.PpCpentsai;
import idw.model.pojos.PpCpproduto;
import idw.model.rn.AbstractRN;
import idw.model.rn.ConsolidaRN;
import idw.model.rn.DataHoraRN;

public class ConsolidacaoPlanejamento extends AbstractRN<DAOGenerico> {
	
	private static boolean IS_PP_CPENTSAI_ATIVO = true; 
	
	public ConsolidacaoPlanejamento() {
		this(null);
	}

	public ConsolidacaoPlanejamento(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	public String getUltimaOP(List<DwConsolid> lista) {
		ConsolidaRN consolidaRN = new ConsolidaRN(getDao());
		DwConsolid ultimoDwConsolid = consolidaRN.getUltimoDwConsolid(lista);
		
		if(ultimoDwConsolid != null) {
			PpCp ppcp = getDao().findById(PpCp.class, ultimoDwConsolid.getPpCp().getIdCp(), false);
			if (ppcp != null) {
				String op = "";
				for (PpCpproduto produto : ppcp.getPpCpprodutos()) {
					if (produto.getNrDoc() == null)
						continue;

					if (op.contains(produto.getNrDoc()) == false) {
						if (op.equals("") == false) {
							op += " - ";
						}
						op += produto.getNrDoc();
					}
				}
				if (op.equals("") == true) {
					op = ppcp.getCdCp();
				}
				return op;
			}
		}

		return "DESCONHECIDA";
	}
	
	public void setInicioPpCpentsai(PpCp ppCp, OmPt omPt, Date dthr) {
		
		if (!IS_PP_CPENTSAI_ATIVO) {
			return;
		}
		try {
			PpCpentsaiDAO ppCpentsaiDAO = new PpCpentsaiDAO(getDaoSession());
			PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);
			
			boolean isTemPpCpentsai = (ppCpentsai != null);
			boolean isMesmoPpCp = false;
			boolean isCpFechado = false;
			if (isTemPpCpentsai) {
				
				PpCp ultimoPpCp = ppCpentsai.getPpCp();
				isMesmoPpCp = ultimoPpCp.getCdCp().equals(ppCp.getCdCp()); 
			
				if (!isMesmoPpCp) {
					dthr = setFimPpCpentsai(ppCpentsai, dthr);
				} else {
					isCpFechado = (ppCpentsai.getDthrFim() != null);
					if (isCpFechado) { 
						dthr = DataHoraRN.before(ppCpentsai.getDthrFim(), dthr) 
								? dthr : ppCpentsai.getDthrFim();
					}
				}
				
			}
			
			if ((!isTemPpCpentsai) || (!isMesmoPpCp) || isCpFechado) {
				ppCpentsaiDAO.incluirNovoPpCpentsai(ppCp, omPt, dthr, null);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Marcar o fim de PpCp. <br>
	 * - Se CP for diferente do anterior que está aberto, anterior será fechado com {@code dthr}, 
	 * e nova linha gerada com inicio e fim iguais a {@code dthr}.
	 * @param ppCp
	 * @param omPt
	 * @param dthr
	 */
	public void setFimPpCpentsai(PpCp ppCp, OmPt omPt, Date dthr) {

		if (!IS_PP_CPENTSAI_ATIVO) {
			return;
		}

		PpCpentsaiDAO ppCpentsaiDAO = new PpCpentsaiDAO(getDaoSession());
		PpCpentsai ppCpentsai = ppCpentsaiDAO.getUltimoPpCpentsaiDoPt(omPt);

		boolean isTemPpCpentsai = (ppCpentsai != null);
		boolean isMesmoPpCp = false;
		
		if (isTemPpCpentsai) {
			
			PpCp ultimoPpCp = ppCpentsai.getPpCp();
			isMesmoPpCp = ultimoPpCp.getCdCp().equals(ppCp.getCdCp()); 
			
			if (!isMesmoPpCp) {
				// Fecha anterior
				dthr = setFimPpCpentsai(ppCpentsai, dthr);								
			}			
			
		}
		
		if ( (!isTemPpCpentsai) || (!isMesmoPpCp)) {
			ppCpentsai = ppCpentsaiDAO.incluirNovoPpCpentsai(ppCp, omPt, dthr, dthr);
		} else {
			setFimPpCpentsai(ppCpentsai, dthr);
		}
		
	}
	
	private Date setFimPpCpentsai(PpCpentsai ppCpentsai, Date dthr) {
		if (ppCpentsai.getDthrFim() == null) {
			dthr = DataHoraRN.before(ppCpentsai.getDthrInicio(), dthr) 
					? dthr : ppCpentsai.getDthrInicio();
			ppCpentsai.setDthrFim(dthr);			
		} else {
			dthr = ppCpentsai.getDthrFim(); 
		}
		return dthr;
	}
	
	
}
