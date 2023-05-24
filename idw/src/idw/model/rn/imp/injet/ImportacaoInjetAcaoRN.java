package idw.model.rn.imp.injet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwTAcao;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijtbaco;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.rn.AcaoRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.AcaoInjetRN;
import idw.util.IdwLogger;

/**
 *
 * @author milton
 *
 */
public class ImportacaoInjetAcaoRN extends ImportacaoInjetRN {

	private final AcaoInjetRN acaoInjetRN;
	private final AcaoRN acaoRN;

	public ImportacaoInjetAcaoRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.acaoInjetRN = new AcaoInjetRN(daoInjet);
		this.acaoRN = new AcaoRN(dao);
	}

	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		return ijtbmestres.getAtualizartabacoes().equals(1);
	}

	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt){
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(listaOmTppt,"listaOmTppt");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importa��o da tabela de a��es");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de acaos dispon�veis na base do injet
			List<Ijtbaco> listAcaoInjet = this.acaoInjetRN.listaAcaosAtivas();

			if(listAcaoInjet.size() > 0){

				List<String> listCdAcaoInjet = new ArrayList<String>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijtbaco ijtbaco: listAcaoInjet){
					this.importar(ijtbaco, listaOmTppt, date, omUsr);
					listCdAcaoInjet.add(ijtbaco.getCdacoes());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listAcaoInjet.size() + " registros");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos");
				this.acaoRN.desativarAcoes(listCdAcaoInjet, date, omUsr);

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.acaoRN.desativarAcoes(DataHoraRN.getDataHoraAtual(), omUsr);
			}

		} else {

			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importa��o n�o � necess�ria. N�o marcado para importa��o");
		}

		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), this.getIdentacao(), this.getLog().getAvaliacaoCompleta());

	}

	/**
	 * Importa acao para cada {@code OmTppt}
	 * @param ijtbaco
	 * @param listaOmTppt
	 */
	private void importar(Ijtbaco ijtbaco, List<OmTppt> listaOmTppt, Date date, OmUsr omUsr){

		Validate.notEmpty(listaOmTppt);

		for(OmTppt omTppt:listaOmTppt){
			this.importar(ijtbaco, omTppt, date, omUsr);
		}
	}

	/**
	 * Importa os dados de {@code ijtbaco} para {@code dwTAcao}
	 * @param ijtbaco
	 * @param omTppt
	 */
	private void importar(Ijtbaco ijtbaco, OmTppt omTppt, Date date, OmUsr omUsr){

		Validate.notNull(ijtbaco, "ijtbaco");
		Validate.notNull(omTppt, "omTppt");
		Validate.notNull(omUsr, "omUsr");

		DwTAcao dwTAcao = new DwTAcao();

		// Pega os campos que n�o est�o no banco do injet
		DwTAcao dwTAcaoDB = null;
		try {
			dwTAcaoDB = this.acaoRN.getDwTAcao(ijtbaco.getCdacoes(),omTppt, false);
			dwTAcao.setOmTppt(dwTAcaoDB.getOmTppt());
		} catch (RegistroDesconhecidoException e) {
		}

		// Atualiza campos
		dwTAcao.set(
				0, omTppt, omUsr, omUsr, ijtbaco.getCdacoes(),
				(long)0,  ijtbaco.getDsacoes(), null, (byte)1, null);

		dwTAcao.limitarStrings();

		this.acaoRN.salvarDesativandoOriginal(dwTAcaoDB, dwTAcao, date, omUsr);

	}

}
