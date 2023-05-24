package idw.model.rn;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpCliente;
import idw.model.pojos.template.PpClienteTemplate;
import idw.webservices.dto.ClienteDTO;

public class ClienteRN extends ClienteDTO implements IDao{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private transient DAOGenerico dao;

	public ClienteRN() {
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public ClienteRN(DAOGenerico dao) {
		this.dao = dao;
	}
	public ClienteRN(ClienteDTO clienteDTO) {
		super(clienteDTO);

		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}

	/**
	 * Pesquisa última revisão de {@code PpCliente} que está ativa
	 * @param clienteDTO
	 * @return
	 */
	public PpCliente pesquisar(ClienteDTO clienteDTO) {

		try {
			return this.dao.findByCd(PpCliente.class , clienteDTO.getCdCliente(), PpClienteTemplate._FIELD_NAME_CD, true);
		} catch (RegistroDesconhecidoException e) {
			return null;
		}

	}
	
	public PpCliente getPpClienteGeraNovoSeNaoEncontrar(String cdCliente, boolean isIntegracao, Date dateOperacao, OmUsr omUsrOperacao){
		
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente ");
		sb.append(cdCliente);
		sb.append(" cadastrado pela ");
		sb.append((isIntegracao ? "integração ": "importação"));
		sb.append(" da estrutura produto");				
		String nmCliente = sb.toString();
		
		return getPpClienteGeraNovoSeNaoEncontrar(cdCliente, nmCliente, dateOperacao, omUsrOperacao);
	}
	
	public PpCliente getPpClienteGeraNovoSeNaoEncontrar(String cdCliente, String nmCliente, Date dateOperacao, OmUsr omUsrOperacao){
	
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCdCliente(cdCliente);
		PpCliente ppCliente = null;
		
		ppCliente = this.pesquisar(clienteDTO);
		if (ppCliente == null){
			// Se nao existir o cliente fazer a inclusao
			ppCliente = new PpCliente();
			ppCliente.setCdCliente(cdCliente);
			ppCliente.setRevisao(1l);
			ppCliente.setNmCliente(nmCliente);
			ppCliente.setDtRevisao(dateOperacao);
			ppCliente.setDtStativo(dateOperacao);
			ppCliente.setStAtivo((byte)1);
			ppCliente.setIdCliente(null);
			ppCliente.setTpCliente(0); // pessoa juridica
			ppCliente.setOmUsrByIdUsrrevisao(omUsrOperacao);
			ppCliente.setOmUsrByIdUsrstativo(omUsrOperacao);
			ppCliente.setHrLeadtime(BigDecimal.ZERO);

			this.dao.makePersistent(ppCliente);
		}
		
		return ppCliente;
		
	}
	
	public PpCliente pesquisarByCdClienteEStAtivo(String cdCliente){
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setCdCliente(cdCliente);
		clienteDTO.setStAtivo((byte)1);
		return this.pesquisar(clienteDTO);
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
