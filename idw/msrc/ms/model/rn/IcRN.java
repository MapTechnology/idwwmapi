package ms.model.rn;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.dao.MsIcDAO;
import idw.model.dao.MsPerfilandonDAO;
import idw.model.pojos.DwTParada;
import idw.model.pojos.MsEvt;
import idw.model.pojos.MsIc;
import idw.model.pojos.MsIhm;
import idw.model.pojos.MsMs;
import idw.model.pojos.MsMsicup;
import idw.model.pojos.MsPerfilandon;
import idw.model.pojos.MsPerfilregras;
import idw.model.pojos.MsPtColeta;
import idw.model.pojos.MsUp;
import idw.model.pojos.MsUpihm;
import idw.model.pojos.MsUsr;
import idw.model.pojos.OmCfg; 
import idw.model.pojos.OmPt;
import idw.model.pojos.template.MsIcTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.ResumoRetornoRegistrosRN;
import idw.util.IdwLogger;
import idw.util.Util;
import idw.webservices.rest.idw.v2.dto.FiltroPesquisaDTO; 
import idw.webservices.rest.idw.v2.dto.IcDTO2;
import idw.webservices.rest.idw.v2.dto.ListaICsDTO;
import idw.webservices.rest.idw.v2.dto.MetaDTO;
import injetws.model.IwsFacade;
import injetws.model.excessoes.RegistroDesconhecidoException;
import ms.coleta.dto.AndonSADTO;
import ms.coleta.dto.MensagemRecebida;
import ms.coleta.dto.TAndonSADTO;
import ms.coleta.servico.ServicoFactory;
import ms.coleta.tcp.UtilsTcp;
import ms.excessao.IcDesconhecidoException;
import ms.excessao.ServicoFalhouException;
import ms.model.dto.EventoColetado;
import ms.model.dto.IcDTO;
import ms.model.dto.IcUpDTO;
import ms.model.dto.ListaIcDTO;
import ms.model.dto.MsicupDTO;
import ms.model.dto.MsicupsDTO;
import ms.model.dto.ResultadoMSDTO;
import ms.model.dto.UpDTO;
import ms.model.ic.FirmwareDTO;
import ms.model.ic.FirmwaresDTO;

public class IcRN extends IcDTO implements IDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5413327670437447018L;

	private transient DAOGenerico dao = null;

	public IcRN() {
		if (this.dao == null) {
			dao = new DAOGenerico();
		}
	}

	public IcRN(DAOGenerico dao) {
		this.dao = dao;
	}

	@Override
	public void iniciaConexaoBanco(Session sessao) {
		dao.iniciaTransacao();
	}

	@Override
	public void finalizaConexaoBanco() {
		dao.finalizaTransacao();
		dao.finalizaSessao();
	}

	public DAOGenerico getDao() {
		return this.dao;
	}

	public void setIcDTO(IcDTO icDTO) {
		if (icDTO != null) {
			this.setIdIc(icDTO.getIdIc());
			this.setCd_ic(icDTO.getCd_ic());
			this.setDs_ic(icDTO.getDs_ic());
			this.setUrl_conexao(icDTO.getUrl_conexao());
			this.setTp_ic(icDTO.getTp_ic());
			this.setRevisao(icDTO.getRevisao());
			this.setDthr_stativo(icDTO.getDthr_stativo());
			this.setDthr_revisao(icDTO.getDthr_revisao());
			this.setSt_ativo(icDTO.getSt_ativo());
			this.setLoginUsuario(icDTO.getLoginUsuario());
			this.setFirmware(icDTO.getFirmware());
			this.setCdPerfilAndon(icDTO.getCdPerfilAndon());
			this.setLoginAD(icDTO.getLoginAD());
			this.setSernhaAD(icDTO.getSernhaAD());
			this.setIsAutenticacao(icDTO.getIsAutenticacao());
		}
	}

	public ListaIcDTO getListaIcDTO() throws IcDesconhecidoException {
		List<MsIc> lista = null;
		ArrayList<IcDTO> listaicdto = new ArrayList<>();
		ListaIcDTO listaIcDTO = new ListaIcDTO();
		IcDTO icDTO = null;
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();

		lista = pesquisarMsIcByPojo();
		if (lista.isEmpty()) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_LISTA_VAZIA);
		} else {
			for (MsIc msic : lista) {
				icDTO = new IcDTO();
				icDTO.setIdIc(msic.getIdIc().intValue());
				icDTO.setCd_ic(msic.getCdIc());
				icDTO.setDs_ic(msic.getDsIc());
				icDTO.setUrl_conexao(msic.getUrlConexao());
				icDTO.setFirmware(msic.getFirmware());
				icDTO.setLoginUsuario(msic.getMsUsr().getLogin());
				icDTO.setLoginAD(msic.getLogin());
				icDTO.setSernhaAD(msic.getSenha());
				icDTO.setIsAutenticacao(msic.getIsAutenticacao());

				if (msic.getMsPerfilandon() != null) {
					icDTO.setCdPerfilAndon(msic.getMsPerfilandon().getCdPerfilandon());
				}
				if (msic.getTpIc() != null) {
					icDTO.setTp_ic(msic.getTpIc().intValue());
				}

				icDTO.setRevisao(msic.getRevisao().intValue());
				icDTO.setDthr_revisao(msic.getDthrRevisao());
				icDTO.setDthr_stativo(msic.getDthrStativo());
				icDTO.setSt_ativo(msic.getStAtivo().intValue());

				// Inicializar tambem as portas do IC para o cadastro
				// simplificado
				icDTO.setPortas(new ArrayList<IcUpDTO>());
				for (MsMsicup msicup : msic.getMsMsicups()) {
					MsUp msup = msicup.getMsUp();
					MsMs msms = msicup.getMsMs();

					// Se a up estiver desativado entao passar para o proximo
					if (msup.getStAtivo().equals(BigDecimal.ZERO))
						continue;

					// Se o ms estiver desativado ou for diferente do rodando no
					// tomcat
					if (msms.getStAtivo().equals(BigDecimal.ZERO) == true) // ||
						// msms.getUrlConexao().equals(UtilsTcp.getMACAddress())
						// == false)
						continue;

					IcUpDTO novo = new IcUpDTO();
					novo.setIc(null);
					novo.setIdIcUp(msicup.getIdMsicup().intValue());
					UpDTO up = new UpDTO();
					up.setCd_up(msup.getCdUp());
					up.setIdUp(msup.getIdUp());
					up.setDs_up(msup.getDsUp());
					up.setCdBc(msup.getCdBc());
					novo.setUpDTO(up);
					novo.setTpConexao(msicup.getTpConexao().intValue());
					novo.setUrlConexao(msicup.getUrlConexao());
					novo.setUrlAuxiliar(msicup.getUrlAuxiliar());
					novo.setColetaAtiva(msicup.getIsAtivo());
					icDTO.getPortas().add(novo);
				}

				listaicdto.add(icDTO);
			}
			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		}

		listaIcDTO.setResultadoDTO(resultadoDTO);
		listaIcDTO.setListaIcDTO(listaicdto);

		return listaIcDTO;

	}

	public List<MsIc> pesquisarMsIcByPojo() {
		MapQuery q = new MapQuery(dao.getSession());

		Date dthrRevisao1 = null;
		Date dthrRevisao2 = null;
		Date dthrStAtivo1 = null;
		Date dthrStAtivo2 = null;

		if (this.getDthr_stativo() != null) {
			dthrStAtivo1 = DataHoraRN.setHoraNaData(this.getDthr_stativo(), 0, 0, 0);
			dthrStAtivo2 = DataHoraRN.setHoraNaData(this.getDthr_stativo(), 23, 59, 59);
		}
		if (this.getDthr_revisao() != null) {
			dthrRevisao1 = DataHoraRN.setHoraNaData(this.getDthr_revisao(), 0, 0, 0);
			dthrRevisao2 = DataHoraRN.setHoraNaData(this.getDthr_revisao(), 23, 59, 59);
		}

		q.append("select msic ");
		q.append("from MsIc msic ");

		q.appendWhere(MapQuery._NULL, "msic.cdIc like :cdic ", this.getCd_ic() != null && !this.getCd_ic().equals(""));
		q.appendWhere(MapQuery._AND, "msic.dsIc = :dsic ", this.getDs_ic() != null && !this.getDs_ic().equals(""));
		q.appendWhere(MapQuery._AND, "msic.urlConexao like :urlconexao ", this.getUrl_conexao() != null && !this.getUrl_conexao().equals(""));
		q.appendWhere(MapQuery._AND, "msic.tpIc = :tpic ", this.getTp_ic() != null && this.getTp_ic() > 0);
		q.appendWhere(MapQuery._AND, "msic.revisao = :revisao ", this.getRevisao() != null);
		q.appendWhere(MapQuery._AND, "msic.dthrStativo between :dthrstativo1 and :dthrstativo2 ", this.getDthr_stativo() != null);
		q.appendWhere(MapQuery._AND, "msic.dthrRevisao between :dthrrevisao1 and :dthrrevisao2 ", this.getDthr_revisao() != null);
		q.appendWhere(MapQuery._AND, "msic.stAtivo = :stativo ", this.getSt_ativo() != null);
		q.appendWhere(MapQuery._AND, "msic.stAtivo = 1 ", this.getSt_ativo() == null);

		q.defineParametro("cdic", this.getCd_ic());
		q.defineParametro("dsic", this.getDs_ic());
		q.defineParametro("urlconexao", "%" + this.getUrl_conexao() + "%");

		if (this.getTp_ic() != null && this.getTp_ic() > 0)
			q.defineParametro("tpic", new BigDecimal(this.getTp_ic()));

		if (this.getRevisao() != null)
			q.defineParametro("revisao", new BigDecimal(this.getRevisao()));

		if (this.getSt_ativo() != null)
			q.defineParametro("stativo", new BigDecimal(this.getSt_ativo()));

		q.defineParametro("dthrstativo1", dthrStAtivo1);
		q.defineParametro("dthrstativo2", dthrStAtivo2);
		q.defineParametro("dthrrevisao1", dthrRevisao1);
		q.defineParametro("dthrrevisao2", dthrRevisao2);

		return q.list();
	}

	public MsIc pesquisarMsIcByURLConexao() throws IcDesconhecidoException {
		MapQuery q = new MapQuery(dao.getSession());

		q.append("select distinct msic from MsIc msic");

		/*
		 * Quando for inova considerar exatamente o valor de url_conexao, pois
		 * serÃ¡ IP. Estava conflitando os ips 170.10.10.100 e 170.10.10.10
		 */
		if (this.getTp_ic().equals(MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc().intValue())) {
			q.append("where msic.urlConexao = :urlConexao");
		} else {
			q.append("where msic.urlConexao like :urlConexao");
		}
		q.append("and msic.stAtivo = 1");
		if (this.getTp_ic().equals(MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc().intValue())) {
			q.defineParametro("urlConexao", this.getUrl_conexao().toUpperCase());
		} else {
			q.defineParametro("urlConexao", "%" + this.getUrl_conexao().toUpperCase() + "%");
		}
		q.setMaxResults(1);

		MsIc exemplo = null;

		exemplo = (MsIc) q.uniqueResult();
		if (exemplo == null) {
			throw new IcDesconhecidoException();
		}
		return exemplo;
	}

	//20180727
	public MsMsicup pesquisarMsIcUpByCdUp(String cdupparam) throws IcDesconhecidoException {

		MapQuery q = null;
		try{
			q = new MapQuery(dao.getSession());
		}
		catch(Exception e)
		{
			dao.iniciaConexaoBanco();
			q = new MapQuery(dao.getSession());
		}

		q.append("select msicup ");
		q.append("from MsMsicup msicup ");
		q.append("join msicup.msIc msic");
		q.append("join msicup.msUp msup");
		q.append("join msicup.msMs msms");

		q.append("where msup.cdUp = :cdupparam");
		
		q.append("and msic.stAtivo = 1");
		q.append("and msms.stAtivo = 1");
		q.append("and msup.stAtivo = 1");
		q.defineParametro("cdupparam", cdupparam);
		
		q.setMaxResults(1);

		MsMsicup exemplo = null;

		exemplo = (MsMsicup) q.uniqueResult();
		if (exemplo == null) {
			throw new IcDesconhecidoException();
		}
		return exemplo;
	}

	
	public MsMsicup pesquisarMsIcUpByURLConexao() throws IcDesconhecidoException {
		MapQuery q = new MapQuery(dao.getSession());

		q.append("select msicup ");
		q.append("from MsMsicup msicup ");
		q.append("join msicup.msIc msic");
		q.append("join msicup.msMs msms");

		/*
		 * Quando for inova considerar exatamente o valor de url_conexao, pois
		 * serÃ¡ IP. Estava conflitando os ips 170.10.10.100 e 170.10.10.10
		 */
		if (this.getTp_ic().equals(MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc().intValue())) {
			q.append("where msic.urlConexao = :urlConexao");
		} else {
			q.append("where msic.urlConexao like :urlConexao");
		}
		q.append("and msic.stAtivo = 1");
		q.append("and msms.stAtivo = 1");
		if (this.getTp_ic().equals(MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc().intValue())) {
			q.defineParametro("urlConexao", this.getUrl_conexao().toUpperCase());
		} else {
			q.defineParametro("urlConexao", "%" + this.getUrl_conexao().toUpperCase() + "%");
		}
		q.setMaxResults(1);

		MsMsicup exemplo = null;

		exemplo = (MsMsicup) q.uniqueResult();
		if (exemplo == null) {
			throw new IcDesconhecidoException();
		}
		return exemplo;
	}

	public MsIc pesquisarMsIcByCdEStAtivo() throws IcDesconhecidoException {
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("select distinct msic from MsIc msic");
		q.append("where msic.cdIc = :cdic");
		q.append("and msic.stAtivo = 1");
		// Alessandre em 29-01-15 comentei o define abaixo que tem o toUpperCase
		// e substitui pelo seguinte sem upperCase. Qual a necessidade do
		// upercase
		// q.defineParametro("cdic", this.getCd_ic().toUpperCase());
		q.defineParametro("cdic", this.getCd_ic());
		q.setMaxResults(1);

		MsIc exemplo = null;

		exemplo = (MsIc) q.uniqueResult();
		if (exemplo == null) {
			throw new IcDesconhecidoException();
		}
		return exemplo;
	}

	public MsIc pesquisarMsIcByCdEStInativo() throws IcDesconhecidoException {
		MapQuery q = new MapQuery(dao.getSession());
		q.append("select distinct msic from MsIc msic");
		q.append("where msic.cdIc = :cdic");
		q.append("and msic.stAtivo = 0");
		q.append("order by msic.revisao desc");

		q.defineParametro("cdic", this.getCd_ic().toUpperCase());
		q.setMaxResults(1);

		MsIc exemplo = null;

		exemplo = (MsIc) q.uniqueResult();
		if (exemplo == null) {
			throw new IcDesconhecidoException();
		}
		return exemplo;
	}

	private Boolean validarURLConexao(IcDTO icdto, List<IcDTO> lista, ListaIcDTO listaIcDTO,
			ResultadoMSDTO resultadoDTO) {
		MsIc msicAux = null;
		if (getUrl_conexao() == null || getUrl_conexao().equals("")) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_URL_DESCONHECIDA);
			listaIcDTO.setResultadoDTO(resultadoDTO);
			return false;
		}
		try {
			msicAux = pesquisarMsIcByURLConexao();
			if (msicAux != null) {
				resultadoDTO.setIdMensagem(resultadoDTO.ERRO_URL_CONEXAO_JA_CADASTRADA);
				icdto.setCd_ic(msicAux.getCdIc());
				lista.add(icdto);
				listaIcDTO.setListaIcDTO(lista);
				listaIcDTO.setResultadoDTO(resultadoDTO);
				return false;
			}
		} catch (IcDesconhecidoException e) {
		}
		return true;
	}

	/*
	 * 
	 */
	private boolean validarIC(IcDTO icdto, List<IcDTO> lista, ListaIcDTO listaIcDTO, ResultadoMSDTO resultadoDTO) {
		MsIc msicAux = null;
		try {
			msicAux = pesquisarMsIcByCdEStAtivo();
			if (msicAux != null
					&& (getIdIc() == null || getIdIc().equals(0) || getIdIc().equals(msicAux.getIdIc()) == true)) {
				resultadoDTO.setIdMensagem(resultadoDTO.ERRO_IC_JA_CADASTRADO);
				icdto.setCd_ic(msicAux.getCdIc());
				lista.add(icdto);
				listaIcDTO.setListaIcDTO(lista);
				listaIcDTO.setResultadoDTO(resultadoDTO);
				return false;
			}
		} catch (IcDesconhecidoException e) {
		}
		return true;
	}

	public ListaIcDTO salvarIcDTO() {
		MsIc msic = null;
		MsIc msicnovo = new MsIc();
		MsUsr msusr = null;
		BigDecimal valorRevisao = null;
		IcDTO icdto = new IcDTO();
		List<IcDTO> lista = new ArrayList<IcDTO>();
		ListaIcDTO listaIcDTO = new ListaIcDTO();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		Date data = new Date();

		// Alessandre: entendo que se validarIC retornar TRUE eh porque o
		// registro eh valido para ser salvo
		// entao mudei o if para false ao inves de true.
		// Alem disso metodo em java comeca com minusculo.
		// se o salvar recebeu um id entao eh uma ALTERACAO, logo nao podemos
		// VALIDAR se o codigo existe, pois,
		// sendo uma alteracao o codigo sempre existira
		// foi modificado o validarIC
		if (validarIC(icdto, lista, listaIcDTO, resultadoDTO) == false) {
			return listaIcDTO;
		}

		if (this.getCd_ic() == null || (this.getCd_ic() != null && this.getCd_ic().equals(""))) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDIC_DESCONHECIDO);
			listaIcDTO.setResultadoDTO(resultadoDTO);
			lista.add(icdto);
			listaIcDTO.setListaIcDTO(lista);
			return listaIcDTO;
		} else if (this.getTp_ic() == null) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_TPIC_INVALIDO);
			listaIcDTO.setResultadoDTO(resultadoDTO);
			lista.add(icdto);
			listaIcDTO.setListaIcDTO(lista);
			return listaIcDTO;
		} else {
			msic = consultaMsIc();

			if (msic == null) {
				msicnovo.setRevisao(BigDecimal.ONE);
				if (validarURLConexao(icdto, lista, listaIcDTO, resultadoDTO) == false) {
					return listaIcDTO;
				}
			} else {
				msic.setStAtivo(BigDecimal.ZERO);
				valorRevisao = msic.getRevisao().add(BigDecimal.ONE);
				msicnovo.setRevisao(valorRevisao);
			}
			msicnovo.setCdIc(this.getCd_ic());
			msicnovo.setStAtivo(BigDecimal.ONE);
			msicnovo.setDthrRevisao(data);
			msicnovo.setDthrStativo(data);

			MsPerfilandonDAO perfilAndonDAO = new MsPerfilandonDAO(dao.getSession());
			MsPerfilandon msPerfilandon = perfilAndonDAO.getMsPerfilAndonPorCdAtivo(this.getCdPerfilAndon());
			msicnovo.setMsPerfilandon(msPerfilandon);

			msusr = pesquisarMsUsr();
			if (msusr == null) {
				resultadoDTO.setIdMensagem(resultadoDTO.ERRO_USUARIO_DESCONHECIDO);
				listaIcDTO.setResultadoDTO(resultadoDTO);
				lista.add(icdto);
				listaIcDTO.setListaIcDTO(lista);
				return listaIcDTO;
			}
			msicnovo.setMsUsr(msusr);
			if (this.getFirmware() != null) {
				msicnovo.setFirmware(this.getFirmware());
			}
			if (this.getDs_ic() != null) {
				msicnovo.setDsIc(this.getDs_ic());
			}
			if (this.getUrl_conexao() != null) {
				msicnovo.setUrlConexao(this.getUrl_conexao());
			}
			if (this.getTp_ic() != null) {
				msicnovo.setTpIc(BigDecimal.valueOf(this.getTp_ic()));
			}
			msicnovo.setIsAutenticacao(getIsAutenticacao());
			msicnovo.setLogin(getLoginAD());
			msicnovo.setSenha(getSernhaAD());

			dao.iniciaTransacao();
			msicnovo = dao.makePersistent(msicnovo);

			// Alterar onde idIc antigo aparece para o idIcNovo
			if (msic != null && msic.getMsMsicups() != null && msic.getMsMsicups().size() > 0) {
				for (MsMsicup m : msic.getMsMsicups()) {
					m.setMsIc(msicnovo);
				}
				dao.makePersistent(msic);
			}

			dao.commitaTransacao(dao.getSession());

			icdto.setIdIc(msicnovo.getIdIc().intValue());
			icdto.setCd_ic(msicnovo.getCdIc());
			icdto.setDs_ic(msicnovo.getDsIc());
			icdto.setUrl_conexao(msicnovo.getUrlConexao());
			icdto.setFirmware(msicnovo.getFirmware());
			icdto.setTp_ic(msicnovo.getTpIc().intValue());
			icdto.setRevisao(msicnovo.getRevisao().intValue());
			icdto.setDthr_revisao(msicnovo.getDthrRevisao());
			icdto.setDthr_stativo(msicnovo.getDthrStativo());
			icdto.setSt_ativo(msicnovo.getStAtivo().intValue());
			icdto.setCdPerfilAndon(msicnovo.getMsPerfilandon() != null ? msicnovo.getMsPerfilandon().getCdPerfilandon() : null);
			icdto.setIsAutenticacao(msicnovo.getIsAutenticacao());
			icdto.setLoginAD(msicnovo.getLogin());
			icdto.setSernhaAD(msicnovo.getSenha());

			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		}

		lista.add(icdto);
		listaIcDTO.setListaIcDTO(lista);
		listaIcDTO.setResultadoDTO(resultadoDTO);

		return listaIcDTO;
	}

	// Deve sair daqui
	private MsUsr pesquisarMsUsr() {
		MapQuery q = new MapQuery(dao.getSession());

		q.append("select msusr ");
		q.append("from MsUsr msusr ");
		q.append("where msusr.login = :login ");
		q.append("and msusr.stAtivo = 1 ");

		q.defineParametro("login", this.getLoginUsuario());
		q.setMaxResults(1);

		return (MsUsr) q.uniqueResult();

	}

	private MsIc consultaMsIc() {
		MapQuery q = new MapQuery(dao.getSession());

		q.append("select msic ");
		q.append("from MsIc msic ");
		q.append("where msic.cdIc = :cdic ");

		// A linha abaixo foi comentada porque se tentou cadastrar um IC que
		// existiu anteriormente mas foi desativado.
		// Assim, esse metodo irÃ¡ pesquisar independente se o registro estÃ¡
		// desativado ou não.
		// O order by foi incluido para se pegar sempre a ultima revisao
		// q.append("and msic.stAtivo = 1");
		q.append("order by msic.revisao desc");

		q.defineParametro("cdic", this.getCd_ic());
		q.setMaxResults(1);

		return (MsIc) q.uniqueResult();
	}

	private MsIhm consultaMsIHM(String msihm) {
		MapQuery q = new MapQuery(dao.getSession());

		q.append("select msihm ");
		q.append("from MsIhm msihm ");
		q.append("where msihm.cdIhm = :cdihm ");

		q.defineParametro("cdihm", msihm);
		q.setMaxResults(1);

		return (MsIhm) q.uniqueResult();
	}

	public ListaIcDTO removeIcDTO() {
		ListaIcDTO listaIcDTO = null;

		listaIcDTO = removeRegistro();

		return listaIcDTO;
	}

	private ListaIcDTO removeRegistro() {
		MsIc msic = null;

		IcDTO icdto = new IcDTO();
		ArrayList<IcDTO> lista = new ArrayList<IcDTO>();
		ListaIcDTO listaIcDTO = new ListaIcDTO();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		Date data = null;
		data = new Date();

		MsIcDAO icDAO = new MsIcDAO(dao.getSession());

		msic = icDAO.getMsIc(this.getIdIc());

		if (msic == null) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_CDIC_DESCONHECIDO);
			listaIcDTO.setResultadoDTO(resultadoDTO);
			return listaIcDTO;
		}

		if (msic.getStAtivo() == BigDecimal.ZERO) {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_EXCLUI_STATIVO_ZERO);
			listaIcDTO.setResultadoDTO(resultadoDTO);
			return listaIcDTO;
		} else {
			if (msic.getCdIc() == null) {
				msic.setCdIc("");
			}

			msic.setStAtivo(BigDecimal.ZERO);
			msic.setDthrStativo(data);

			dao.iniciaTransacao();

			// Alessandre: comentei em 29-07-15 removi a linha abaixo pois nao
			// da pra apagar o msmsicup pois podem existir msEvt com a
			// referencia de msmsicup
			// removeMsicupsDoIc(msic);

			dao.makePersistent(msic);

			icdto.setIdIc(msic.getIdIc().intValue());
			icdto.setCd_ic(msic.getCdIc());
			icdto.setDs_ic(msic.getDsIc());
			icdto.setUrl_conexao(msic.getUrlConexao());
			icdto.setTp_ic(msic.getTpIc().intValue());
			icdto.setRevisao(msic.getRevisao().intValue());
			icdto.setDthr_revisao(msic.getDthrRevisao());
			icdto.setDthr_stativo(msic.getDthrStativo());
			icdto.setSt_ativo(msic.getStAtivo().intValue());
			icdto.setIsAutenticacao(msic.getIsAutenticacao());
			icdto.setLoginAD(msic.getLogin());
			icdto.setSernhaAD(msic.getSenha());

			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		}

		dao.commitaTransacao(dao.getSession());
		lista.add(icdto);
		listaIcDTO.setListaIcDTO(lista);
		listaIcDTO.setResultadoDTO(resultadoDTO);

		return listaIcDTO;
	}

	public ListaIcDTO getTodosIcDTO() {

		List<MsIc> listamsic = null;
		ArrayList<IcDTO> listaicdto = new ArrayList<IcDTO>();
		ResultadoMSDTO resultadoDTO = new ResultadoMSDTO();
		ListaIcDTO listaicDTO = new ListaIcDTO();
		IcDTO icDTO = null;

		MapQuery q = new MapQuery(dao.getSession());

		q.append("select msic from MsIc msic ");
		q.append("where msic.stAtivo = 1");

		listamsic = q.list();

		if (listamsic != null) {
			for (MsIc msic : listamsic) {
				icDTO = null;
				icDTO = new IcDTO();
				icDTO.setIdIc(msic.getIdIc().intValue());
				icDTO.setCd_ic(msic.getCdIc());

				listaicdto.add(icDTO);
			}
			resultadoDTO.setIdMensagem(resultadoDTO.COM_SUCESSO);
		} else {
			resultadoDTO.setIdMensagem(resultadoDTO.ERRO_LISTA_VAZIA);
		}

		listaicDTO.setListaIcDTO(listaicdto);
		listaicDTO.setResultadoDTO(resultadoDTO);

		return listaicDTO;
	}

	/*
	 * Esse metodo sera chamado pelo webservice do ColetaFujiFlex para
	 * identificar quais UPs devem ser gerenciadas pelo coletor e em qual
	 * diretorio
	 */
	public IcDTO pesquisarMsIcPorUrlConexao(String urlconexao) {
		MapQuery q = new MapQuery(dao.getSession());

		q.append("select msic ");
		q.append("from MsIc msic ");
		q.append("join fetch msic.msMsicups msicup");
		q.append("join fetch msicup.msUp msup");
		q.append("join fetch msup.msUsr msusr");
		q.append("join msicup.msMs msms");
		q.append("where msic.urlConexao like :urlconexao and msic.stAtivo = 1");
		q.append("and msup.stAtivo = 1");
		q.append("and msms.stAtivo = 1");

		q.defineParametro("urlconexao", "%" + urlconexao + "%");
		q.setMaxResults(1);

		MsIc msic = (MsIc) q.uniqueResult();

		IcDTO retorno = new IcDTO(msic);
		PTRN rn = new PTRN(getDao());

		if (msic == null)
			return null;
		
		retorno.inicializarIcUpDTOComMsIc(msic, rn);

		return retorno;
	}

	// lista para o modelo de combo do IC
	public ListaIcDTO getListaMsIC() {
		List<MsIc> listaMsIC;
		List<IcDTO> listaIcDtoRetorno = new ArrayList<IcDTO>();
		MapQuery query = new MapQuery(getDao().getSession());
		query.append("SELECT msic ");
		query.append("FROM MsIc msic");
		query.append("WHERE msic.stAtivo = 1");
		listaMsIC = query.list();
		if (listaMsIC != null) {
			for (MsIc msic : listaMsIC) {
				IcDTO icdto = new IcDTO();
				icdto.setIdIc(msic.getIdIc().intValue());
				icdto.setCd_ic(msic.getCdIc());
				icdto.setDs_ic(msic.getDsIc());
				icdto.setUrl_conexao(msic.getUrlConexao());
				icdto.setFirmware(msic.getFirmware());
				listaIcDtoRetorno.add(icdto);
			}

		}
		ListaIcDTO listaIcDto = new ListaIcDTO();
		listaIcDto.setListaIcDTO(listaIcDtoRetorno);
		return listaIcDto;
	}

	public MsicupsDTO getListaMsicup() {
		List<MsMsicup> listaMsicup;
		List<MsicupDTO> listaMsicupDtoRetorno = new ArrayList<MsicupDTO>();
		MapQuery query = new MapQuery(getDao().getSession());
		query.append("SELECT msicup ");
		query.append("FROM MsMsicup msicup");
		listaMsicup = query.list();
		if (listaMsicup != null) {
			for (MsMsicup msicup : listaMsicup) {
				MsicupDTO msicupdto = new MsicupDTO();
				msicupdto.setMsicup(msicup.clone(true));
				listaMsicupDtoRetorno.add(msicupdto);
			}

		}
		MsicupsDTO msicupsdto = new MsicupsDTO();
		msicupsdto.setMsicups(listaMsicupDtoRetorno);
		return msicupsdto;
	}

	/*
	 * Para salvar dados do IC de forma simplicada Ã© necessario que apenas
	 * alguns dados sejam pedidos: BC, Maquina, Porta. Os demais dados devem ser
	 * salvos de forma transparente para o usuario, ou seja, as relacoes serao
	 * 'setadas' e salvas diretamente no codigo.
	 */
	public IcDTO salvarIcSimplificado(IcDTO icDTO, IcDTO icDTOParaRemocao) {
		MsIc icPesquisado = null;
		MsUp msUp = null;
		Date data = new Date();

		UpRN upRN = new UpRN(getDao(), null);
		UsuarioRN usuRN = new UsuarioRN(getDao());
		MsRN msRN = new MsRN();
		msRN.setDao(getDao());

		setCd_ic(icDTO.getCd_ic());
		BigDecimal revisao = BigDecimal.ONE;

		// Pesquisa o IC. Se existir desativa
		icPesquisado = consultaMsIc();
		if (icPesquisado != null) {
			revisao = icPesquisado.getRevisao().add(BigDecimal.ONE);
			MapQuery q = new MapQuery(dao.getSession());
			q.append("update MsIc set stAtivo = 0 where idIc = :id");
			q.defineParametro("id", icPesquisado.getIdIc());
			q.query().executeUpdate();
		}

		/* Setando dados nivel 1: MSIC */
		MsIc icNovo = new MsIc();
		icNovo.setCdIc(icDTO.getCd_ic());
		icNovo.setRevisao((revisao));
		icNovo.setDsIc(icDTO.getDs_ic());
		icNovo.setDthrHeartbeat(null);
		icNovo.setDthrRevisao(data);
		icNovo.setDthrStativo(data);
		icNovo.setIdIc(null);

		usuRN.setLogin(icDTO.getLoginUsuario());
		MsUsr usuario = usuRN.pesquisarMsUsrUsandoLogin();

		icNovo.setMsUsr(usuario);
		icNovo.setUrlConexao(icDTO.getUrl_conexao());
		icNovo.setTpIc(new BigDecimal(icDTO.getTp_ic()));
		icNovo.setFirmware(icDTO.getFirmware());
		icNovo.setStAtivo(BigDecimal.ONE);
		dao.makePersistent(icNovo);

		List<MsMsicup> listaMsmsicup = new ArrayList<MsMsicup>();

		// Pesquisa IHM se nao existir inclui um novo
		/* Setando dados nivel 2: MSIHM */
		MsIhm msIhm = consultaMsIHM(icNovo.getCdIc());
		if (msIhm == null) {
			msIhm = new MsIhm();
			msIhm.setIdIhm(null);
			msIhm.setCdIhm(icNovo.getCdIc());
			msIhm.setDthrCadastro(data);
			msIhm.setDthrHeartbeat(null);
			msIhm.setMsUsr(icNovo.getMsUsr());
			msIhm.setUrlConexao(icNovo.getUrlConexao());
			msIhm.setUrlIp(icNovo.getUrlConexao());
			msIhm.setIsUpreg(true);
			msIhm.setIsEvttodos(true);

			dao.makePersistent(msIhm);
		}

		// Relaciona o IHM com a UP
		if (icDTO.getPortas() != null) {
			for (IcUpDTO porta : icDTO.getPortas()) {
				MsUpihm msupihm = new MsUpihm();
				msupihm.setMsIhm(msIhm);

				/* Setando dados nivel 3: MSUP */
				msUp = null;

				try {
					msUp = upRN.pesquisarMsUpPorCdUpStAtivo(porta.getUpDTO().getCd_up());
				} catch (RegistroDesconhecidoException e) {
					msUp = null;
				}

				if (msUp == null) {
					msUp = new MsUp();
					msUp.setIdUp(null);
					msUp.setMsUsr(usuario);
					msUp.setCdUp(porta.getUpDTO().getCd_up());

					msUp.setRevisao((BigDecimal.ONE));
					msUp.setDthrRevisao(data);
					msUp.setDthrStativo(data);
					msUp.setDsUp(icDTO.getCd_ic());
					msUp.setIduppdba(null);
					msUp.setStAtivo(BigDecimal.ONE);

					dao.makePersistent(msUp);

				}

				// dao.makePersistent(msUp);

				MapQuery q = new MapQuery(dao.getSession());
				q.append("update MsUp a set a.cdBc = :cdBc where a.idUp = :id");
				q.defineParametro("id", msUp.getIdUp());
				q.defineParametro("cdBc", porta.getUpDTO().getCdBc());
				q.query().executeUpdate();

				msupihm.setMsUp(msUp);
				msupihm.setDthrCadastro(icDTO.getDthr_revisao());
				msupihm.setIdUpihm(null);
				// Saber se o IHM ja esta ou nao associado a UP
				boolean isExiste = false;
				for (MsUpihm msupihmteste : msUp.getMsUpihms()) {
					if (msupihmteste.getMsIhm().getCdIhm().equals(msIhm.getCdIhm())) {
						isExiste = true;
						break;
					}
				}
				if (isExiste == false) {
					dao.makePersistent(msupihm);
				}

				MsMsicup msMsIcUp = new MsMsicup();
				msMsIcUp.setMsIc(icNovo);
				msMsIcUp.setMsUp(msUp);
				msMsIcUp.setUrlConexao(porta.getUrlConexao());
				msMsIcUp.setUrlAuxiliar(porta.getUrlAuxiliar());
				msMsIcUp.setTpConexao(BigDecimal.ZERO);
				listaMsmsicup.add(msMsIcUp);

			}
		}

		/* Setando dados nivel 4: MSMS */
		MsMs msms = null;

		String macAdress = UtilsTcp.getMACAddress();

		msms = msRN.pesquisarMsMsPorURLConexaoComParametro(macAdress);

		if (msms == null) {
			msms = msRN.pesquisarUmMsMsPorStAtivo();
			if (msms == null) {
				msms = new MsMs();
				msms.setCdMs(icDTO.getCd_ic());
				msms.setDsMs(icDTO.getDs_ic());
				msms.setDthrHeartbeat(null);
				msms.setDthrRevisao(data);
				msms.setDthrStativo(data);
				msms.setIdMs(null);

				msms.setMsUsr(usuario);
				msms.setRevisao(null);
				msms.setStAtivo(BigDecimal.ONE);
				msms.setUrlConexao(macAdress);

				msms.setRevisao(BigDecimal.ONE);
				msms.setMsMsicups(null);
				msms = dao.makePersistent(msms);
			}
		}

		/* Setando dados nivel 5: MSICUP */
		for (MsMsicup msmsicup : listaMsmsicup) {
			// Pesquisar se ja existe msmsicup. Se existir alterar a urlConexao.
			// Se nao exisitr incluir
			MsMsicup msmsicupPesq = null;
			if (icPesquisado != null)
				msmsicupPesq = msRN.pesquisarMsMsIcupByMsUpIc(msms, msmsicup.getMsUp(), icPesquisado);

			if (msmsicupPesq == null) {
				msmsicup.setIdMsicup(null);
				msmsicup.setMsMs(msms);
				dao.makePersistent(msmsicup);
			} else {
				MapQuery q = new MapQuery(dao.getSession());
				q.append("update MsMsicup a set a.msIc = :ic, a.urlConexao = :url where a.idMsicup = :id");
				q.defineParametro("id", msmsicupPesq.getIdMsicup());
				q.defineParametro("ic", icNovo);
				q.defineParametro("url", msmsicup.getUrlConexao());
				q.query().executeUpdate();
			}
		}

		// INterage sobre a lista de portas para exclusao
		if (icDTOParaRemocao.getPortas() != null) {
			for (IcUpDTO icupdto : icDTOParaRemocao.getPortas()) {
				MsMsicup msmsicupParaExclusao = null;
				if (icupdto.getIdIcUp() != null) {
					msmsicupParaExclusao = msRN.pesquisarMsMsIcupById(new BigDecimal(icupdto.getIdIcUp()));
					if (msmsicupParaExclusao != null) {
						MapQuery q = new MapQuery(dao.getSession());
						q.append("delete from MsMsicup a where a.idMsicup = :id");
						q.defineParametro("id", msmsicupParaExclusao.getIdMsicup());
						q.query().executeUpdate();
					}
				}
			}
		}

		return icDTO;
	}

	public String obtemFirmwareToIC() throws IcDesconhecidoException {
		MsIc msic = pesquisarMsIcByURLConexao();
		return msic.getFirmware();
	}

	public void isICCadastrado() throws IcDesconhecidoException {
		pesquisarMsIcByURLConexao();
	}

	public void existeUPParaIC() throws IcDesconhecidoException {
		pesquisarMsIcUpByURLConexao();
	}

	/**
	 * @return
	 */
	public FirmwaresDTO listaFirmwares() {
		String pathname = IwsFacade.getRealRootPath() + "/firmware";
		File file = new File(pathname);
		File arquivos[] = file.listFiles();
		FirmwaresDTO firmwaresDTO = new FirmwaresDTO();
		List<FirmwareDTO> listFirmwares = new ArrayList<FirmwareDTO>();

		if (arquivos != null) {
			for (int i = 0; i < arquivos.length; i++) {
				FirmwareDTO dto = new FirmwareDTO();
				dto.setNomeFirmware(arquivos[i].getName());
				listFirmwares.add(dto);
				firmwaresDTO.setListaFirmwares(listFirmwares);
			}
		} else {
			if (getLog() != null)
				getLog().info("Erro ao obter lista de firmwares");
		}
		return firmwaresDTO;
	}

	public ListaIcDTO getMsIcsPorTp() {
		ListaIcDTO retorno = new ListaIcDTO();
		retorno.setListaIcDTO(new ArrayList<IcDTO>());
		MsIcDAO dao = new MsIcDAO(this.dao.getSession());
		List<MsIc> listaIcs = dao.getMsIcsStandalone(MsIcTemplate.TpIc._TP_IC_Nao_gerenciavel_por_driver.getTpIc().intValue());
		for (MsIc ic : listaIcs) {
			IcDTO item = new IcDTO();
			item.setIdIc(ic.getIdIc().intValue());
			item.setCd_ic(ic.getCdIc());
			retorno.getListaIcDTO().add(item);
		}
		return retorno;
	}

	public TAndonSADTO getAndonsSA(Long idPa) {

		MapQuery q = new MapQuery(dao.getSession());

		q.append("select perfil ");
		q.append("from MsPerfilregras perfil ");
		q.append("where perfil.msPerfilandon.idPerfilandon=:idPa ");
		q.append("and perfil.msPerfilandon.stAtivo=1 ");
		q.append("order by perfil.porta,perfil.prioridade ");

		q.defineParametro("idPa", idPa);

		List<MsPerfilregras> listaPesquisa = null;
		try {
			listaPesquisa = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<AndonSADTO> lista = new ArrayList<AndonSADTO>();

		if (listaPesquisa != null) {
			for (MsPerfilregras item : listaPesquisa) {
				AndonSADTO andonSADTO = new AndonSADTO(item);
				lista.add(andonSADTO);
			}
		}

		TAndonSADTO listaRetorno = new TAndonSADTO();
		listaRetorno.setListaAndonSA(lista);

		return listaRetorno;
	}

	public MsPerfilandon getListaAndonSADTOByCdIc(String cdIc) {

		MapQuery q = new MapQuery(dao.getSession());

		q.append("select perfilAndon ");
		q.append("from MsIc msic ");
		q.append("join msic.msPerfilandon perfilAndon");
		q.append("where msic.cdIc=:cdIc ");
		q.append("and msic.stAtivo=1 ");
		q.append("and perfilAndon.stAtivo=1 ");

		q.setMaxResults(1);

		q.defineParametro("cdIc", cdIc);

		MsPerfilandon retorno = null;

		try {
			retorno = (MsPerfilandon) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	/*
	 * Metodo responsável e/m lancar parada sem conexao para cada UP do IC
	 * 
	 */
	public void lancaParadaSemConexao(IdwLogger log, int idLog, int identacao, MensagemRecebida mensagem) {
		// Obtem motivo de parada referencia
		OmCfg omcfg = Util.getConfigGeral(getDao().getSession());
		String cdParada = null;
		if (omcfg.getDwTParadasemconexao() != null)
			cdParada = omcfg.getDwTParadasemconexao().getCdTparada();
		else if (omcfg.getDwTParada() != null)
			cdParada = omcfg.getDwTParada().getCdTparada();

		DwTParada dwtparada = omcfg.getDwTParadasemconexao();
		if (dwtparada == null) {
			dwtparada = omcfg.getDwTParada();
		}
		if (dwtparada == null)
			return;

		EventoRN rn = new EventoRN();
		rn.setDao(getDao());

		PTRN prn = new PTRN(getDao());

		Date dthrFParada = mensagem.getEventoColetado().getDthrEvento();

		OmPt ompt = prn.pesquisarPtByCdPtStAtivo(mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up());

		// Obtem o ultimo evento da UP
		MsEvt msevt = rn.pesquisarMsEvtUltimoEventoLancado(mensagem.getEventoColetado().getIcUpDTO().getUpDTO().getCd_up());
		if (msevt == null)
			log.info(idLog, identacao, "msevt null");
		else
			log.info(idLog, identacao, "msevt encontrado");
					
		/*
		 * Alessandre em 19/12/16 se o pT estiver sem op nao lancar evento
		 * 
		 */
		if (ompt == null || (ompt.getIsSemop() != null && ompt.getIsSemop() == true) || ompt.getPpCp() == null || ompt.getIsSemop() == null)
			return;

		// Obtem o ultimo heartbeat da UP
		MsPtColeta msptcoleta = ompt.getMsPtColeta();

		/*
		 * Alessandre em 20-12-16 se o posto estiver parado em regulagem nao
		 * lancar a parada por perda de sem conexao Na teoria se tiver parado
		 * nao eh necessario mandar uma parada de perda de conexao
		 */
		if (msptcoleta != null && msptcoleta.getIsParada() != null && msptcoleta.getIsParada())
			return;

		// Escolhe qual data sera usada como inicio de parada
		Date dthrIParada = msevt.getDthrEvento();

		log.info(idLog, identacao, "dthrInicio = " + dthrIParada);
		// Se nao tiver referencia de inicio entao passar para proxima UP
		if (dthrIParada == null)
			return;

		// Lanca inicio de parada
		log.info("enviando inicio parada");
		// Alexandre 15-07-2016: Criei uma nova MensagemRecebida e um novo
		// EventoColetado.
		// Para que o mesmo nao fique com vestigios de informacoes das outras
		// UPs(setadas pelos metodos chamados).
		// Tivemos problemas quando uma maquina do IC setava a OP em
		// EventoColetado
		// e mais a frente quando pegava as outras maquinas, e elas estavam sem
		// OP,
		// ele inseria em msevt com a mesma OP do outro posto.
		// Isso fez uma OP nao cadastrada pra um coletor ser aberta pela
		// consolidacao.
		EventoColetado evtColetado = new EventoColetado();
		evtColetado.setIcUpDTO(mensagem.getEventoColetado().getIcUpDTO());
		evtColetado.setChamarInjetWs(mensagem.getEventoColetado().isChamarInjetWs());

		MensagemRecebida mensagemRecebida = new MensagemRecebida();
		mensagemRecebida.setLog(mensagem.getLog());
		mensagemRecebida.setIdLog(mensagem.getIdLog());
		mensagemRecebida.setIdentacao(mensagem.getIdentacao());
		mensagemRecebida.setDadosIcDTO(mensagem.getDadosIcDTO());

		mensagemRecebida.setIc(mensagem.getIc());
		mensagemRecebida.setMensagem(null);
		mensagemRecebida.setEventoColetado(evtColetado);

		evtColetado.setDthrEvento(dthrIParada);
		evtColetado.setTipoEvento(ServicoFactory._INICIO_PARADA);
		evtColetado.setCdparada(cdParada);
		try {
			ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
		} catch (ServicoFalhouException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info(idLog, identacao, "enviando motivo parada");
		// Lanca motivo de parada
		evtColetado.setTipoEvento(ServicoFactory._MOTIVO_PARADA);
		evtColetado.setCdparada(cdParada);
		try {
			ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
		} catch (ServicoFalhouException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info(idLog, identacao, "enviando fim parada");
		// Lanca fim de parada
		evtColetado.setDthrEvento(dthrFParada);
		evtColetado.setTipoEvento(ServicoFactory._FIM_PARADA);
		try {
			ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
		} catch (ServicoFalhouException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/* Alessandre em 13-05-22 lancamento do inicio de ciclo com final de parada caso a parada feche o ciclo
		 * 
		 */
		if (ompt.getIsParadaFechaciclo() != null && ompt.getIsParadaFechaciclo()) {
			// Lancar inicio de ciclo
			evtColetado.setTipoEvento(ServicoFactory._INICIO_CICLO);
			try {
				ServicoFactory.getInstancia().executaServico(null, mensagemRecebida);
			} catch (ServicoFalhouException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	

	@SuppressWarnings("unused")
	public ListaICsDTO getICsDTO(FiltroPesquisaDTO filtro) {
		ListaICsDTO retorno = new ListaICsDTO();
		retorno.setItems(new ArrayList<IcDTO2>());
		retorno.setMeta(new MetaDTO(filtro));
				
		MapQuery q = new MapQuery(dao.getSession());
		q.append("SELECT t");
		q.append("FROM MsIc t");
		q.append("WHERE t.stAtivo = 1");
		q.append(" AND t.tpIc = 3"); // coleta dinamica
 
				
		if (filtro.getConteudoPesquisa() != null && !filtro.getConteudoPesquisa().equals("")){			
			q.append("AND (");
			q.append(" upper(t.cdIc) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%' OR upper(t.urlConexao) LIKE '%" + filtro.getConteudoPesquisa().toUpperCase() + "%'");
			q.append( ")");		 
		}
 
 		q.append("ORDER BY t.cdIc");
 		

 		List<MsIc> lista =  q.listComPaginacao(filtro.getPagina(), filtro.getRegistrosPorPagina());
 		for (MsIc reg : lista) {
 			IcDTO2 dto = new IcDTO2();
 			dto.setIdIC(reg.getIdIc().intValue());
 			dto.setCdIC(reg.getCdIc());
 			dto.setDsIC(reg.getDsIc());
 			dto.setUrl(reg.getUrlConexao());
 			dto.setStRegistro(reg.getStAtivo().intValue());
 			dto.setRevisao(reg.getRevisao().intValue());
 			dto.setTpConexao(reg.getTpIc().intValue());
 			
 			retorno.getItems().add(dto);
 		}
		
		
 		if (lista.size() > 0) {
 			ResumoRetornoRegistrosRN resRN = new ResumoRetornoRegistrosRN(getDao());
 			retorno.setMeta(resRN.getMetaDTO(filtro, q, lista.size()));
 			resRN = null;
 		}
		
		q = null;
		lista = null;		
		
		return retorno;
	}

	@SuppressWarnings("unused")
	public IcDTO2 getICByCd(String cdIC) {
		IcDTO2 retorno = new IcDTO2();
		
		MapQuery q = new MapQuery(dao.getSession());
		q.append("SELECT t");
		q.append("FROM MsIc t");
		q.append("WHERE t.stAtivo = 1");
		q.append(" AND t.tpIc = 3"); // coleta dinamica
		q.append("AND t.cdIc = :cdIc");
 		q.append("ORDER BY t.cdIc");
 		q.defineParametro("cdIc", cdIC);
 		

 		List<MsIc> lista =  q.list();
 		if (lista.size() == 1) { 
 			retorno.setIdIC(lista.get(0).getIdIc().intValue());
 			retorno.setCdIC(lista.get(0).getCdIc());
 			retorno.setDsIC(lista.get(0).getDsIc());
 			retorno.setUrl(lista.get(0).getUrlConexao());
 			retorno.setStRegistro(lista.get(0).getStAtivo().intValue());	
 			retorno.setRevisao(lista.get(0).getRevisao().intValue());
 			retorno.setTpConexao(lista.get(0).getTpIc().intValue());
 		}
		
		return retorno;
	}

}
