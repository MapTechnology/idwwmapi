package idw.model.rn.integracao.erp;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import idw.model.dao.IDao;
import idw.model.dao.erp.DAOGenericoErp;
import idw.model.pojos.OmCfg;
import idw.model.pojos.OmProduto;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.ProdutoDTO;

public class IntegracaoOPRN  extends AbstractRN<DAOGenericoErp> implements IDao {

	public IntegracaoOPRN() {
		super(new DAOGenericoErp());
	}
	
	public IntegracaoOPRN(DAOGenericoErp dao) {
		super(dao);
	}

	public OpsIntegracaoDTO getOpsParaIntegrar(OmCfg omcfg, String cdop) {
		OpsIntegracaoDTO retorno = new OpsIntegracaoDTO();
		
		Query query = null;
		
		// Se flex (no futuro criar um factory)
		if (omcfg.getOmEmpresa().getDsEmpresa().toUpperCase().contains("FLEX")) {
			String sql = "select * from VW_MAP_OP";
			if (cdop != null && cdop.trim().equals("") == false) {
				sql += " where OP = '" + cdop + "'";
			}
			query = getDaoSession().createSQLQuery(sql);
		} else {
			query = getDao().createSQLQueryBaseadoStoreProcedure("spc_MapOrdensProducao", 0);
		}
		
		List<Object> lista = query.list();
		
		for (Object linha : lista) {
			Object[] registro = (Object[])linha;

			String nrop;
			String cdProduto;
			Double producaoPlanejada;
			Date dtI;
			Date dtF;
			String nrLoteMp;
			String dtLoteMp;
			String tipoOP;
			String cdGt;

			if (omcfg.getOmEmpresa().getDsEmpresa().toUpperCase().contains("FLEX")) {
				cdGt = registro[0].toString().trim();
				nrop = registro[2].toString().trim();
				cdProduto = registro[5].toString().trim();
				producaoPlanejada = (Double) registro[15];
				nrLoteMp = registro[10].toString().trim();
				dtLoteMp = registro[11].toString().trim();
				tipoOP = registro[20].toString().trim();
				
				if (tipoOP != null && tipoOP.equals("Interna"))
					tipoOP = "op";
				else
					tipoOP = "or";

				try {
					dtI = DataHoraRN.toDateFrom("dd/MM/yyyy", registro[7].toString());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}
				dtF = dtI;
			} else {
				cdGt = "";
				nrop = registro[1].toString().trim();
				cdProduto = registro[2].toString().trim();
				producaoPlanejada = (Double) registro[3];
				dtI = (Date) registro[4];
				dtF = (Date) registro[5];
				nrLoteMp = "";
				dtLoteMp = "";
				tipoOP = "op";
			}
			
			OpIntegracaoDTO op = new OpIntegracaoDTO();

			op.setCdGt(cdGt);
			op.setDthrFplanejada(dtF);
			op.setDthrIplanejada(dtI);
			op.setNrop(nrop);
			op.setNrLoteMp(nrLoteMp);
			op.setDtLoteMp(dtLoteMp);
			op.setTipoOP(tipoOP);
			
			List<ProdutoDTO> produtos = new ArrayList<>();
			ProdutoDTO produtodto = new ProdutoDTO();
			produtodto.setAproduzir(new BigDecimal(producaoPlanejada));
			OmProduto omproduto = new OmProduto();
			omproduto.setCdProduto(cdProduto);
			produtodto.setProduto(omproduto);
			produtos.add(produtodto);
			op.setProdutos(produtos);
			retorno.getOps().add(op);
		}
		return retorno;
	}
}
