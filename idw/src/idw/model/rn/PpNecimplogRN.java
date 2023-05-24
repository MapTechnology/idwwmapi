package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import idw.model.dao.DAOGenerico;
import idw.model.dao.IDao;
import idw.model.dao.MapQuery;
import idw.model.pojos.OmUsr;
import idw.model.pojos.PpNecimp;
import idw.model.pojos.PpNecimplog;
import idw.model.pojos.PpNecimpurllog;
import idw.webservices.dto.PpNecimpDTO;
import idw.webservices.dto.PpNecimplogDTO;
import idw.webservices.dto.PpNecimplogListDTO;
import idw.webservices.dto.PpNecimpurllogDTO;
import idw.webservices.dto.PpNecimpurllogListDTO;
import idw.webservices.dto.ResultadoDTO;

@SuppressWarnings("serial")
public class PpNecimplogRN extends PpNecimplogDTO implements IDao {

	private DAOGenerico dao;

	public PpNecimplogRN() {
		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
	}
	public PpNecimplogRN(DAOGenerico dao) {
		this.dao = dao;
	}
	public PpNecimplogRN(PpNecimplogDTO ppnecimplog) {
		super(ppnecimplog);

		if(this.dao == null) {
			this.dao = new DAOGenerico();
		}
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

	public void salvarRegistro() {
		try {
			PpNecimplog ppnecimplogNovo = this.clone();

			ppnecimplogNovo.setIdNecimplog(null);
			ppnecimplogNovo.setMesReferencia(this.getMesReferencia());
			ppnecimplogNovo.setAnoReferencia(this.getAnoReferencia());
			ppnecimplogNovo.setDthrIimportacao(this.getDthrIimportacao());
			ppnecimplogNovo.setDthrFimportacao(null);

			//Pesquisar usuario atual
			OmUsr usuarioLogado = null;
			UsuarioRN usuarioRn = new UsuarioRN();
			usuarioRn.setDaoSession(this.dao.getSession());

			try {
				usuarioLogado = usuarioRn.getDao().findById(OmUsr.class, this.getOmUsr().getIdUsr(), false);

				if(usuarioLogado == null) {
					//retorna mensagem de erro
				}
			}catch(Exception e) {
				e.printStackTrace();
				//retorna mesma mnsagem
			}

			ppnecimplogNovo.setOmUsr(usuarioLogado.clone());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PpNecimplog pesquisarByDate(Date dataInicio) {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ppnecimplog from PpNecimplog ppnecimplog ");

		q.appendWhere(MapQuery._NULL, "ppnecimplog.dthrIimportacao = :data", (dataInicio != null));

		q.defineParametro("data", dataInicio);

		q.setMaxResults(1);

		return (PpNecimplog)q.uniqueResult();
	}

	public PpNecimplog pesquisarById(Long id) {
		MapQuery q = new MapQuery(this.dao.getSession());

		q.append("select ppnecimplog from PpNecimplog ppnecimplog ");

		q.appendWhere(MapQuery._NULL, "ppnecimplog.idNecimplog = :id", true);

		q.defineParametro("id", id);

		q.setMaxResults(1);

		return (PpNecimplog)q.uniqueResult();
	}

	public PpNecimplogListDTO pesquisarLogsRealizadosByIdNecimp(Long idNecimp, int limiteMaximo) {
		PpNecimplogListDTO retorno = new PpNecimplogListDTO();
		ResultadoDTO resultado = new ResultadoDTO();
		retorno.setResultado(resultado);

		if((idNecimp != null) && (idNecimp > 0) && (limiteMaximo > 0)) {
			PpNecimpDTO ppnecimpDTO = new PpNecimpDTO();
			ppnecimpDTO.setIdNecimp(idNecimp);

			PpNecimpRN ppnecimpRN = new PpNecimpRN(this.dao);
			PpNecimp ppnecimp = ppnecimpRN.pesquisar(ppnecimpDTO);

			if(ppnecimp != null) {
				List<PpNecimplogDTO> listaDTO = new ArrayList<PpNecimplogDTO>();
				List<PpNecimplog> listaPojos;

				MapQuery q = new MapQuery(this.dao.getSession());

				q.append("select distinct ppnecimplog from PpNecimplog ppnecimplog ");
				q.append("left join fetch ppnecimplog.ppNecimpurllogs ppnecimpurllogs");

				q.appendWhere(MapQuery._NULL, "ppnecimplog.ppNecimp = :ppnecimp", true);
				q.append("order by ppnecimplog.dthrIimportacao desc ");

				q.defineParametro("ppnecimp", ppnecimp);

				q.setMaxResults(limiteMaximo);

				listaPojos = q.list();

				for(PpNecimplog pojo : listaPojos) {
					PpNecimplogDTO dto = new PpNecimplogDTO(pojo);

					dto.setOmUsr(pojo.getOmUsr().clone());
					dto.setPpNecimp(null);

					Set<PpNecimpurllog> ppnecimpurllogs = this.clonaPpNecimpurllogs(pojo.getPpNecimpurllogs());

					dto.setPpNecimpurllogs(ppnecimpurllogs);

					listaDTO.add(dto);
				}

				resultado.setIdmensagem(resultado.COM_SUCESSO);
				retorno.setLogs(listaDTO);
			}
			else {
				resultado.setIdmensagem(resultado.CONFIGURACAO_DESCONHECIDA);
			}
		}

		return retorno;
	}

	public Set<PpNecimpurllog> clonaPpNecimpurllogs(Set<PpNecimpurllog> lista) {
		Set<PpNecimpurllog> retorno = new HashSet<PpNecimpurllog>();

		Iterator<PpNecimpurllog> it = lista.iterator();

		while(it.hasNext()) {
			retorno.add(it.next().clone(true));
		}

		return retorno;
	}

	public PpNecimpurllogListDTO pesquisarAbasByUrlLog(PpNecimpurllogListDTO logDTO) {
		PpNecimpurllogListDTO retorno = new PpNecimpurllogListDTO();
		retorno.setListaPpNecimpurllogDTO(new ArrayList<PpNecimpurllogDTO>());
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		retorno.setResultadoDTO(resultadoDTO);

		List<String> listaArquivos = logDTO.getListaArquivos();

		if(!listaArquivos.isEmpty()) {
			MapQuery q = new MapQuery(this.dao.getSession());

			q.append("select max(necimpurllog.idNecimpurllog) from PpNecimpurllog necimpurllog ");

			int i;
			for(i = 0;i < listaArquivos.size();i++) {
				String parametro = "param" + i;
				q.appendWhere(MapQuery._OR, "necimpurllog.urlArquivo=:" + parametro, true);
			}
			q.append("group by necimpurllog.urlArquivo");

			for(i = 0;i < listaArquivos.size();i++) {
				String parametro = "param" + i;
				q.defineParametro(parametro, listaArquivos.get(i));
			}

			List<Long> listaIds = q.list();

			if((listaIds != null) && (!listaIds.isEmpty())) {
				for(Long id : listaIds) {
					q.novaConsulta();
					q.append("select necimpurllog from PpNecimpurllog necimpurllog ");
					q.appendWhere(MapQuery._NULL, "necimpurllog.idNecimpurllog=:idnecimp", true);
					q.defineParametro("idnecimp", id);
					q.setMaxResults(1);

					PpNecimpurllog urlLog = (PpNecimpurllog)q.uniqueResult();

					PpNecimpurllogDTO logRetorno = new PpNecimpurllogDTO(urlLog.clone(false));
					retorno.getListaPpNecimpurllogDTO().add(logRetorno);
				}
			}

		}

		resultadoDTO.setIdmensagem(resultadoDTO.COM_SUCESSO);

		return retorno;
	}

}
