package idw.model.dao;

import java.util.List;

import org.hibernate.Session;

import idw.model.pojos.OmAlim;
import idw.model.pojos.template.OmAlimreaTemplate;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.AlimentacaoDTO;
import idw.webservices.dto.LeiturasCODTO;

public class OmAlimDAO {
	
	private Session session;
	
	public OmAlimDAO(Session session){
		this.session = session;
	}

	public List<OmAlim> getAlimentacoesDTO(AlimentacaoDTO filtro){

		MapQuery q = new MapQuery(session);

		q.append("SELECT DISTINCT a ");
		q.append("FROM OmAlim a ");
		q.append("LEFT JOIN FETCH a.omAlimreas b");
		
		q.appendWhere(MapQuery._NULL, "exists (select t from OmAlim t join t.omAlimreas omalimrea ", true);


		q.appendWhere(MapQuery._NULL, "join t.omMapa ommapa", true);
		q.appendWhere(MapQuery._NULL, "join ommapa.omPt ompt", true);
		q.appendWhere(MapQuery._NULL, "join omalimrea.omMapapa ommapapa", true);
		q.appendWhere(MapQuery._NULL, "join ommapapa.omProduto omproduto", true);

		q.append("where a.idAlim = t.idAlim");
		q.appendWhere(MapQuery._AND,"t.idAlim = :idAlim", filtro.getAlimentacao().getIdAlim() != 0);
		
		
		boolean isFiltroProduto = filtro.getCdProduto() != null && !filtro.getCdProduto().isEmpty(); 
		if (isFiltroProduto) {
			q.appendWhere(MapQuery._AND, " ( b.cdLido LIKE :cdProduto OR omproduto.cdProduto LIKE :cdProduto )", true);
		}
		
		q.appendWhere(MapQuery._AND, "t.cdAlim = :cdAlim" , !filtro.getAlimentacao().getCdAlim().equals("") );
		q.appendWhere(MapQuery._AND, "t.dsAlim = :dsAlim", !filtro.getAlimentacao().getDsAlim().equals(""));
		q.appendWhere(MapQuery._AND, "t.tpAlim = :tpAlim", filtro.getAlimentacao().getTpAlim() < (byte) 4);
		q.appendWhere(MapQuery._AND, "ommapa.cdMapa = :cdMapa", !filtro.getAlimentacao().getOmMapa().getCdMapa().equals(""));
		q.appendWhere(MapQuery._AND, "ommapa.dsMapa = :dsMapa", !filtro.getAlimentacao().getOmMapa().getDsMapa().equals(""));
		q.appendWhere(MapQuery._AND, "t.omUsr.cdUsr = :cdUsr", !filtro.getAlimentacao().getOmUsr().getCdUsr().equals(""));
		q.appendWhere(MapQuery._AND, "t.omUsr.dsNome = :dsNome", !filtro.getAlimentacao().getOmUsr().getDsNome().equals(""));
		q.appendWhere(MapQuery._AND, "t.stAlim = :stAlim" , filtro.getAlimentacao().getStAlim() < (byte) 3);
		q.appendWhere(MapQuery._AND, "ompt.cdPt = :cdPt", !filtro.getAlimentacao().getOmMapa().getOmPt().getCdPt().equals(""));
		q.appendWhere(MapQuery._AND, "ompt.dsPt = :dsPt", !filtro.getAlimentacao().getOmMapa().getOmPt().getDsPt().equals(""));
		
		q.appendWhere(MapQuery._AND, "omalimrea.dthrLeitura BETWEEN :dtDe AND :dtAte", filtro.getDtILeitura() != null && filtro.getDtFLeitura() != null && filtro.isUltimaAlimentacaoSucesso() == false && filtro.getAlimentacao().getIdAlim() == 0);
		
		boolean isFiltraGt = (filtro.getCdGt() != null && !filtro.getCdGt().isEmpty()); 
		if (isFiltraGt) {
			q.appendWhere(MapQuery._AND, " t.omMapa.omPt.omGt.cdGt = :cdGt", true);
		}
		
		if (filtro.isApenasRealimentacao()) {
			q.appendWhere(MapQuery._AND, " omalimrea.tpLeitura = :tpLeitura", true);
		}
		
		if (filtro.isUltimaAlimentacaoSucesso()) {
			q.appendWhere(MapQuery._AND, "a.tpAlim = 3 and a.stAlim = 1", true);
		}
		
		q.append(") ORDER BY a.idAlim DESC ");

		q.defineParametro("idAlim", filtro.getAlimentacao().getIdAlim());
		q.defineParametro("cdAlim", filtro.getAlimentacao().getCdAlim());
		q.defineParametro("dsAlim", filtro.getAlimentacao().getDsAlim());
		q.defineParametro("tpAlim", filtro.getAlimentacao().getTpAlim());
		q.defineParametro("cdMapa", filtro.getAlimentacao().getOmMapa().getCdMapa());
		q.defineParametro("dsMapa", filtro.getAlimentacao().getOmMapa().getDsMapa());
		q.defineParametro("cdPt", filtro.getAlimentacao().getOmMapa().getOmPt().getCdPt());
		q.defineParametro("dsPt", filtro.getAlimentacao().getOmMapa().getOmPt().getDsPt());
		q.defineParametro("cdUsr", filtro.getAlimentacao().getOmUsr().getCdUsr());
		q.defineParametro("dsNome", filtro.getAlimentacao().getOmUsr().getDsNome());
		q.defineParametro("stAlim", filtro.getAlimentacao().getStAlim());

		if(filtro.getDtILeitura() != null && filtro.getDtFLeitura() != null) {
			q.defineParametroData("dtDe", DataHoraRN.getDataSemHora(filtro.getDtILeitura()));
			q.defineParametroData("dtAte", DataHoraRN.adicionaDiasDaData(filtro.getDtFLeitura(), 1));
		}
		if (isFiltroProduto) {
			q.defineParametro("cdProduto", "%" + filtro.getCdProduto() + "%");
		}
		if (isFiltraGt) {
			q.defineParametro("cdGt", filtro.getCdGt());
		}
		if (filtro.isApenasRealimentacao()) {
			q.defineParametro("tpLeitura", OmAlimreaTemplate.TpLeitura.REALIMENTACAO.getId());
		}

		if (filtro.isUltimaAlimentacaoSucesso())
			q.setMaxResults(1);
		else
			q.setMaxResults(10);

		List<OmAlim> retorno = q.list();

		return retorno;
	}
	
	public List<OmAlim> getRealimentacoes(LeiturasCODTO leituras){
		MapQuery q = new MapQuery(session);
		
		q.append("SELECT distinct omalim ");
		q.append("FROM OmAlim omalim ");
		q.append("JOIN omalim.omMapa ommapa ");
		q.append("JOIN ommapa.omPt ompt ");
		q.append("WHERE ompt.cdPt =:cdPt AND ompt.stAtivo = 1 ");
		q.append("and omalim.stAlim = 1"); // deve jogar a realimentacao em uma alimentacao valida
		q.append("and omalim.tpAlim = 3"); // deve jogar a realimentacao em uma alimentacao e nao conferencia
		q.append("AND ommapa.cdMapa =:cdmapa ");
		
		q.append("ORDER BY omalim.idAlim DESC ");
		
		q.defineParametro("cdPt", leituras.getCdMaquina());
		q.defineParametro("cdmapa", leituras.getMapa().getCdMapa());
		
		return q.list();	
	}

	public OmAlim  getCorrente(Long idAlimCorrente){
		MapQuery q = new MapQuery(session);
		
		q.append("FROM OmAlim omalim ");
		q.append("JOIN FETCH omalim.omUsr omusr ");
		q.append("JOIN FETCH omalim.omMapa ommapa ");
		q.append("WHERE omalim.idAlim =:idalim ");
		
		q.defineParametro("idalim", idAlimCorrente);
		
		return (OmAlim) q.uniqueResult();
	}

}