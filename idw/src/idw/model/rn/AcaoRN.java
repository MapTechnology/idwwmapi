package idw.model.rn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.model.dao.DAOGenerico;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.RegistroJaDesativadoException;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.template.DwTAcaoTemplate;
import idw.webservices.dto.DwTAcoes;

/**
 *
 * @author milton
 *
 */
public class AcaoRN extends AbstractRN<DAOGenerico> {

	public AcaoRN() {
		this(null);
	}

	public AcaoRN(DAOGenerico dao) {
		super(dao);
		if (dao == null) {
			dao = new DAOGenerico();
		}
		this.setDao(dao);
	}

	/**
	 * Desativa todos os registros da tabela de acaos
	 * 
	 * @param dataHoraDesativacao
	 * @param omUsr
	 *            Usu�rio que desativou a acao
	 */
	public void desativarAcoes(Date dataHoraDesativacao, OmUsr omUsr) {
		this.getDao().desativarMuitos(DwTAcao.class, DwTAcaoTemplate._FIELD_NAME_CD, null, false, dataHoraDesativacao,
				omUsr);
	}

	/**
	 * Desativa registros da tabela de acoes
	 * 
	 * @param listaCdAcaoDevemFicarAtivos
	 *            Lista de c�digos de devem ficar permanecer ativos
	 * @param dataHoraDesativacao
	 * @param omUsr
	 *            Usu�rio que desativou a acao
	 */
	public void desativarAcoes(List<String> listaCdAcaoDevemFicarAtivos, Date dataHoraDesativacao, OmUsr omUsr) {
		this.getDao().desativarMuitos(DwTAcao.class, DwTAcaoTemplate._FIELD_NAME_CD, listaCdAcaoDevemFicarAtivos, true,
				dataHoraDesativacao, omUsr);
	}

	/**
	 * Desativa relacionado ao c�digo e tipo do posto de trabalho
	 * 
	 * @param cdAcao
	 * @param omTppt
	 * @param date
	 * @param omUsr
	 *            usu�rio que est� desativando
	 * @throws RegistroJaDesativadoException
	 * @throws RegistroDesconhecidoException
	 */
	public void desativarAcao(String cdAcao, OmTppt omTppt, Date date, OmUsr omUsr)
			throws RegistroDesconhecidoException, RegistroJaDesativadoException {
		this.getDao().desativar(DwTAcao.class, cdAcao, DwTAcaoTemplate._FIELD_NAME_CD, omTppt, date, omUsr);
	}

	/**
	 * Desativa {@code DwTAcao} relacionado ao id da acao
	 * 
	 * @param idAcao
	 * @param dataHoraAtual
	 * @throws RegistroJaDesativadoException
	 */
	public void desativarAcao(long idAcao, Date date, OmUsr omUsr) throws RegistroJaDesativadoException {
		this.getDao().desativar(DwTAcao.class, idAcao, date, omUsr);
	}

	/**
	 * Pega {@code DwTAcao} �ltima revis�o relacionado com o c�digo da acao e
	 * relacionado com o {@code omTppt}
	 * 
	 * @param cdAcao
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTAcao getDwTAcao(String cdAcao, OmTppt omTppt, boolean isFiltroAtivo)
			throws RegistroDesconhecidoException {
		return this.getDao().findByCd(DwTAcao.class, cdAcao, DwTAcaoTemplate._FIELD_NAME_CD, omTppt, isFiltroAtivo);
	}

	/**
	 * Pega {@code DwTAcao} relacionado com o c�digo da acao e que esteja ativo,
	 * relacionado com o {@code omTppt}
	 * 
	 * @param cdAcao
	 * @param omTppt
	 * @return
	 * @throws RegistroDesconhecidoException
	 */
	public DwTAcao getDwTAcao(String cdAcao, OmTppt omTppt) throws RegistroDesconhecidoException {
		return this.getDwTAcao(cdAcao, omTppt, true);
	}

	/**
	 * Pega {@code DwTAcao} relacionado com o id
	 * 
	 * @param idAcao
	 * @return
	 */
	public DwTAcao getDwTAcao(long idAcao) {
		return this.getDao().findById(DwTAcao.class, idAcao, false);
	}

	public DwTAcoes getDwAcao(Long idTppt) {

		MapQuery q = new MapQuery(this.getDao().getSession());

		q.append("select t ");
		q.append("from DwTAcao t ");
		q.append("where t.stAtivo=1 ");
		q.append("AND t.omTppt.idTppt=:idTppt ");
		q.defineParametro("idTppt", idTppt);

		List<DwTAcao> listaPesquisa = null;
		try {
			listaPesquisa = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DwTAcao> lista = new ArrayList<DwTAcao>();

		if (listaPesquisa != null) {
			for (DwTAcao item : listaPesquisa) {
				DwTAcao dwTCausaDTO = new DwTAcao();
				dwTCausaDTO = (item.clone());
				lista.add(dwTCausaDTO);
			}
		}

		DwTAcoes listaRetorno = new DwTAcoes();
		listaRetorno.setListaDwTAcoes(lista);

		return listaRetorno;
	}

	public DwTAcao getDwTAcao(String cdAcao) {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select dwtacao");
		q.append("from DwTAcao dwtacao");
		q.append("where dwtacao.cdTacao = :cdacao");
		q.append("and dwtacao.stAtivo = 1");
		q.setMaxResults(1);
		q.defineParametro("cdacao", cdAcao);
		return (DwTAcao) q.uniqueResult();
	}

	public List<DwTAcao> getDwTAcoes(String cdAcao) {
		MapQuery q = new MapQuery(this.getDaoSession());
		q.append("select dwtacao");
		q.append("from DwTAcao dwtacao");
		q.append("where dwtacao.cdTacao = :cdacao");
		q.append("and dwtacao.stAtivo = 1");
		q.defineParametro("cdacao", cdAcao);
		return q.list();
	}

	public void salvarDesativandoOriginal(DwTAcao dwTAcaoDB, DwTAcao dwTAcao, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwTAcaoDB, dwTAcao, dateOperacao, omUsrOperacao);
	}

	public void salvarDesativandoOriginal(DwTAcao dwTAcao, Date dateOperacao, OmUsr omUsrOperacao) {
		this.getDao().salvarDesativandoOriginal(dwTAcao, dateOperacao, omUsrOperacao);
	}

}
