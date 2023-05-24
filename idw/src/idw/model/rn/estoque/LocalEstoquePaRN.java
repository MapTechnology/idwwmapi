package idw.model.rn.estoque;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import idw.model.dao.DAOGenerico;
import idw.model.dao.DwDesalimpendcontagDAO;
import idw.model.dao.DwEstlocalDAO;
import idw.model.dao.DwEstlocalproDAO;
import idw.model.dao.DwEstproDAO;
import idw.model.dao.OmProdutoDAO;
import idw.model.dao.OmpaproDao;
import idw.model.pojos.DwEst;
import idw.model.pojos.DwEstlocal;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmPa;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwEstlocalTemplate;
import idw.model.rn.AbstractRN;
import idw.util.Util;

public class LocalEstoquePaRN extends AbstractRN<DAOGenerico>{

	public LocalEstoquePaRN(){
		this(null);
	}
	
	public LocalEstoquePaRN(DAOGenerico dao) {
		super(dao);
		if(dao == null){
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}
	
	public DwEstlocal getDwEstlocalAlimentacaoCriaSenaoExistir(DwEst dwEstAlimentacao, OmPt omPt, OmPa omPa, OmUsr omUsr, Date data) {
		return getDwEstlocalAlimDesalimCriaSenaoExistir(DwEstlocalTemplate.TpLocalEstoque.ALIMENTACAO, dwEstAlimentacao, omPt, omPa, omUsr, data);
	}

	public DwEstlocal getDwEstlocalDesalimentacaoCriaSenaoExistir(DwEst dwEstAlimentacao, OmPt omPt, OmPa omPa, OmUsr omUsr, Date data) {
		return getDwEstlocalAlimDesalimCriaSenaoExistir(DwEstlocalTemplate.TpLocalEstoque.DESALIMENTACAO, dwEstAlimentacao, omPt, omPa, omUsr, data);
	}

	public void removerProdutosSemConsumoDoEstoqueAlimentacao(){
		
		OmProdutoDAO omProdutoDAO = new OmProdutoDAO(getDaoSession());
		List<OmProduto> listaProdutosSemConsumo = omProdutoDAO.getProdutosSemConsumo();
		
		OmCfg omCfg = Util.getConfigGeral(getDaoSession());
		
		DwEst dwEstAlim = omCfg.getDwEstByIdEstAlimentacao();
		
		DwEstlocalproDAO dwEstlocalproDAO = new DwEstlocalproDAO(getDaoSession());
		DwEstproDAO dwEstproDAO = new DwEstproDAO(getDaoSession());
		OmpaproDao ompaproDao = new OmpaproDao(getDaoSession());
		DwDesalimpendcontagDAO dwDesalimpendcontagDAO = new DwDesalimpendcontagDAO(getDaoSession());
		
		if(dwEstAlim != null){

			for(OmProduto omProduto: listaProdutosSemConsumo){
				
				dwEstlocalproDAO.zerarEstoqueProduto(dwEstAlim, omProduto);
				dwEstproDAO.zerarEstoqueProduto(dwEstAlim, omProduto);
				dwDesalimpendcontagDAO.removerProdutoDeDesalimpendcontag(omProduto);
				ompaproDao.removerProdutoTodosOmPapro(omProduto);				
				
			}
			
		}
		
		
	}
	
	private DwEstlocal getDwEstlocalAlimDesalimCriaSenaoExistir(DwEstlocalTemplate.TpLocalEstoque tpLocalEstoque, DwEst dwEstAlimentacao, OmPt omPt, OmPa omPa, OmUsr omUsr, Date data) {
		
		DwEstlocalDAO dwEstlocalDAO = new DwEstlocalDAO(getDaoSession());
		
		DwEstlocal dwEstlocalAlimentacao = dwEstlocalDAO.getDwEstLocalPeloPtCdPaTpLocalEstoque(dwEstAlimentacao, omPt, omPa.getCdPa(), tpLocalEstoque);
				
		if(dwEstlocalAlimentacao == null){
			dwEstlocalAlimentacao = newDwEstlocalAlimDesalim(tpLocalEstoque, dwEstAlimentacao, omPt, omPa, omUsr, data);
			getDao().makePersistent(dwEstlocalAlimentacao);			
		}

		return dwEstlocalAlimentacao;

	}

	private String criarCdLocalAlimDesalim(DwEstlocalTemplate.TpLocalEstoque tpLocalEstoque, String cdPt, String cdPa){
		if(tpLocalEstoque.equals(DwEstlocalTemplate.TpLocalEstoque.ALIMENTACAO)){
			return StringUtils.left(cdPt + cdPa, 60);
		}else{
			return StringUtils.left("DESALIM" + cdPt + cdPa, 60);
		}
	}
	
	
	
	private DwEstlocal newDwEstlocalAlimDesalim(DwEstlocalTemplate.TpLocalEstoque tpLocalEstoque, DwEst dwEstAlimentacao, OmPt omPt, OmPa omPa, OmUsr omUsr, Date data){

		DwEstlocal dwEstlocal = new DwEstlocal();
		dwEstlocal.setAutomatico(true);
		dwEstlocal.setCdLocal(criarCdLocalAlimDesalim(tpLocalEstoque, omPt.getCdPt(), omPa.getCdPa()));
		dwEstlocal.setDsLocal(dwEstlocal.getCdLocal());
		dwEstlocal.setDtRevisao(data);
		dwEstlocal.setDtStativo(data);
		dwEstlocal.setDwEst(dwEstAlimentacao);
		dwEstlocal.setIdEstlocal(null);
		dwEstlocal.setOmGt(null);
		dwEstlocal.setOmPt(omPt);
		dwEstlocal.setOmPa(omPa);
		dwEstlocal.setOmUsrByIdUsrrevisao(omUsr);
		dwEstlocal.setOmUsrByIdUsrstativo(omUsr);
		dwEstlocal.setRevisao(1L);
		dwEstlocal.setStAtivo((byte) 1);
		dwEstlocal.setTpLocalEstoque(tpLocalEstoque.getId());
		
		return dwEstlocal;
		
	}
	
}
