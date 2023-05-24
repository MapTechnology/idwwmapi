package idw.model.rn;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.PpTpplano;
import idw.webservices.dto.PpTpplanoDTO;
import idw.webservices.dto.PpTpplanoListDTO;
import idw.webservices.dto.ResultadoDTO;

@SuppressWarnings("serial")
public class PpTpplanoRN extends PpTpplanoDTO implements IDao{
	
	private DAOGenerico dao;
	
	public PpTpplanoRN() {
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public PpTpplanoRN(DAOGenerico dao) {
		this.dao = dao;
	}
	public PpTpplanoRN(PpTpplanoDTO pptpplanoDTO) {
		super(pptpplanoDTO);
		
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	
	public PpTpplanoListDTO pesquisarTpPlanos(PpTpplanoDTO pptpplanoDTO) {
		PpTpplanoListDTO retorno = new PpTpplanoListDTO();
		List<PpTpplano> listaPojos;
		
		ResultadoDTO resultado = new ResultadoDTO();
		retorno.setResultado(resultado);
		
		MapQuery q = new MapQuery(this.dao.getSession());
		
		q.append("select pptpplano from PpTpplano pptpplano");
		
		listaPojos = q.list();
		
		if(listaPojos != null) {
			List<PpTpplanoDTO> listaPpTpplanoDTO = new ArrayList<PpTpplanoDTO>();
			
			for(PpTpplano tpplano : listaPojos) {
				PpTpplanoDTO tpplanoDTO = new PpTpplanoDTO(tpplano);
				
				listaPpTpplanoDTO.add(tpplanoDTO);
			}
			resultado.setIdmensagem(resultado.COM_SUCESSO);
			retorno.setTpPlanos(listaPpTpplanoDTO);
		}
		
		return retorno;
	}
	
	public PpTpplano pesquisarTpPlanoById(PpTpplano tpplano) {
		MapQuery q = new MapQuery(this.dao.getSession());
		
		q.append("select tpplano from PpTpplano tpplano");
		
		q.appendWhere(MapQuery._NULL, "tpplano.idTpplano = :idtpplano", ((tpplano.getIdTpplano() != null) && (tpplano.getIdTpplano() > 0)));
		q.defineParametro("idtpplano", tpplano.getIdTpplano());
		
		q.setMaxResults(1);
		
		return (PpTpplano)q.uniqueResult();
	}

	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}
	@Override
	public void iniciaConexaoBanco(Session sessao) {
		this.dao.iniciaSessao();
		this.dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		this.dao.finalizaTransacao();
		this.dao.finalizaSessao();
	}
}
