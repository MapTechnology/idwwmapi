package idw.model.rn;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwTurno;
import idw.webservices.dto.DwTurnoDTO;
import idw.webservices.dto.DwTurnosDTO;

public class DwTurnoRN implements IDao{
	private DAOGenerico dao;
	
    public DwTurnoRN(){
    	if (dao == null){
    		dao = new DAOGenerico();
    	}
    }
	
    public DwTurnoRN(DAOGenerico dao) {
		this.dao = dao;
	}
    
	@Override
	public void finalizaConexaoBanco() {
		dao.finalizaSessao();
		dao.finalizaTransacao();
		
	}

	public void iniciaConexaoBanco() {
		iniciaConexaoBanco(null);
	}
	
	@Override
	public void iniciaConexaoBanco(Session sessao) {
		
		dao.iniciaSessao();
		dao.iniciaTransacao();
		
	}
	
	public DwTurnosDTO pesquisarTurnos() throws RegistroDesconhecidoException{
		List<DwTurnoDTO> listaDTO = new ArrayList<DwTurnoDTO>();
		List<DwTurno> listaTurnos = null;
		
		MapQuery query = new MapQuery(dao.getSession());
		
		query.append("from DwTurno t");
		query.append("where t.stAtivo = 1");
		query.append("and t.cdTurno <> '0'");
		query.append("order by t.idTurno");
		
		listaTurnos = query.list();
		
		if (listaTurnos == null){
			throw new RegistroDesconhecidoException();
		}
		
		for (DwTurno t :listaTurnos){
			DwTurnoDTO dto = new DwTurnoDTO();
			dto.setDwTurno(t.clone());
			listaDTO.add(dto);
		}
					
		DwTurnosDTO retorno = new DwTurnosDTO();
		retorno.setListaDwTurnoDTO(listaDTO);
		retorno.setResultadoEvento(retorno.getBemSucedido());
		return retorno;
	}
	
	public DwTurno pesquisaTurnoPorID(long idTurno){
		DwTurno retorno = (DwTurno) dao.findById(DwTurno.class, idTurno, false);
		return retorno;
	}
	

}
