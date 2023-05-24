package idw.model.rn;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.pojos.PpNeccron;
import idw.webservices.dto.PpNeccronDTO;
import idw.webservices.dto.ResultadoDTO;

@SuppressWarnings("serial")
public class PpNeccronRN extends PpNeccronDTO implements IDao {
	
	private DAOGenerico dao;
	
	public PpNeccronRN() {
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public PpNeccronRN(DAOGenerico dao) {
		this.dao = dao;
	}
	public PpNeccronRN(PpNeccronDTO ppneccrondto) {
		super(ppneccrondto);
		
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	
	public int salvarRegistro(PpNeccronDTO ppneccronDTO) {
		PpNeccronDTO retorno = new PpNeccronDTO();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);
		
		PpNeccron ppneccron = new PpNeccron();
		
		ppneccron.setIdNeccron(null);
		ppneccron.setDtDesejada(ppneccronDTO.getDtDesejada());
		ppneccron.setPpNec(ppneccronDTO.getPpNec());
		ppneccron.setQtDesejada(ppneccronDTO.getQtDesejada());
		
		dao.makePersistent(ppneccron);
		
		return 1;
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
