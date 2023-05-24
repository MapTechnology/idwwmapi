package idw.model.rn.imp.injet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTRefugo;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.pojos.injet.Ijtbref;
import idw.model.rn.AreaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.RefugoRN;
import idw.model.rn.injet.RefugoInjetRN;
import idw.util.IdwLogger;

/**
 *
 * @author milton
 *
 */
public class ImportacaoInjetRefugoRN extends ImportacaoInjetRN {

	private final RefugoInjetRN refugoInjetRN;
	private final RefugoRN refugoRN;
	private final AreaRN areaRN;

	public ImportacaoInjetRefugoRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.refugoInjetRN = new RefugoInjetRN(daoInjet);
		this.refugoRN = new RefugoRN(dao);
		this.areaRN = new AreaRN(dao);
	}

	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		return ijtbmestres.getAtualizartabrefugo().equals(1);
	}

	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt){
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(listaOmTppt,"listaOmTppt");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importa��o da tabela de refugos");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de refugos dispon�veis na base do injet
			List<Ijtbref> listRefugoInjet = this.refugoInjetRN.listaRefugosAtivas();

			if(listRefugoInjet.size() > 0){

				List<String> listCdRefugoInjet = new ArrayList<String>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijtbref ijtbref: listRefugoInjet){
					this.importar(ijtbref, listaOmTppt, date, omUsr);
					listCdRefugoInjet.add(ijtbref.getCdrefugo());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listRefugoInjet.size() + " registros");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos");
				this.refugoRN.desativarRefugos(listCdRefugoInjet, date, omUsr);

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.refugoRN.desativarRefugos(DataHoraRN.getDataHoraAtual(), omUsr);
			}

		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importacao nao e necess�ria. Nao marcado para importacao");
		}
		
		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), this.getIdentacao(), this.getLog().getAvaliacaoCompleta());

	}

	/**
	 * Importa refugo para cada {@code OmTppt}
	 * @param ijtbref
	 * @param listaOmTppt
	 */
	private void importar(Ijtbref ijtbref, List<OmTppt> listaOmTppt, Date date, OmUsr omUsr){

		Validate.notEmpty(listaOmTppt);

		for(OmTppt omTppt:listaOmTppt){
			this.importar(ijtbref, omTppt, date, omUsr);
		}
	}

	/**
	 * Importa os dados de {@code ijtbref} para {@code dwTRefugo}
	 * @param ijtbref
	 * @param omTppt
	 */
	private void importar(Ijtbref ijtbref, OmTppt omTppt, Date date, OmUsr omUsr){

		Validate.notNull(ijtbref, "ijtbref");
		Validate.notNull(omTppt, "omTppt");
		Validate.notNull(omUsr, "omUsr");


		DwTRefugo dwTRefugo = new DwTRefugo();
		// Pega os campos que nao estao no banco do injet
		DwTRefugo dwTRefugoDB = null;
		try {
			dwTRefugoDB = this.refugoRN.getDwTRefugo(ijtbref.getCdrefugo(),omTppt, false);
			dwTRefugo.setOmTppt(dwTRefugoDB.getOmTppt());
		} catch (RegistroDesconhecidoException e) {
			dwTRefugoDB = null;
		}

		DwTArea dwTArea = null;
		if(ijtbref.getIjareres() != null){
			try {
				dwTArea = areaRN.getDwTArea(ijtbref.getIjareres().getCdarea(), true);
			} catch (RegistroDesconhecidoException e) {
			}
		}

		// Atualiza campos
		dwTRefugo.set(
				0l, omTppt, omUsr, dwTArea, omUsr, ijtbref.getCdrefugo(),
				(long)0,  ijtbref.getDsrefugo(), null, (byte)1, null,
				ObjectUtils.equals(ijtbref.getLrequercausa(), Integer.valueOf(0)),
				ObjectUtils.equals(ijtbref.getLrequeracao(), Integer.valueOf(0)), false);

		dwTRefugo.limitarStrings();

		this.refugoRN.salvarDesativandoOriginal(dwTRefugoDB, dwTRefugo, date, omUsr);
	}

}
