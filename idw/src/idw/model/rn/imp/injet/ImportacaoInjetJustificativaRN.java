package idw.model.rn.imp.injet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwTJust;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijtbjup;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.rn.DataHoraRN;
import idw.model.rn.JustificativaRN;
import idw.model.rn.injet.JustificativaInjetRN;
import idw.util.IdwLogger;

/**
 *
 * @author milton
 *
 */
public class ImportacaoInjetJustificativaRN extends ImportacaoInjetRN {

	private final JustificativaInjetRN justificativaInjetRN;
	private final JustificativaRN justificativaRN;

	public ImportacaoInjetJustificativaRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.justificativaInjetRN = new JustificativaInjetRN(daoInjet);
		this.justificativaRN = new JustificativaRN(dao);
	}


	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		return ijtbmestres.getAtualizartabjustif().equals(1);
	}


	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt){
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(listaOmTppt,"listaOmTppt");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importa��o da tabela de justificativas");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de justificativas dispon�veis na base do injet
			List<Ijtbjup> listJustInjet = this.justificativaInjetRN.listaJustificativasAtivas();

			if(listJustInjet.size() > 0){

				List<String> listCdJustInjet = new ArrayList<String>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijtbjup ijtbjup: listJustInjet){
					this.importar(ijtbjup, listaOmTppt, date, omUsr);
					listCdJustInjet.add(ijtbjup.getCdjustparada());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listJustInjet.size() + " registros ");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos ");
				this.justificativaRN.desativarJustificativas(listCdJustInjet, date, omUsr);

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.justificativaRN.desativarJustificativas(DataHoraRN.getDataHoraAtual(), omUsr);
			}

		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importa��o n�o � necess�ria. N�o marcado para importa��o");
		}
		
		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), this.getIdentacao(), this.getLog().getAvaliacaoCompleta());

	}

	/**
	 * Importa justificativa para cada {@code OmTppt}
	 * @param ijtbjup
	 * @param listaOmTppt
	 */
	private void importar(Ijtbjup ijtbjup, List<OmTppt> listaOmTppt, Date date, OmUsr omUsr){

		Validate.notEmpty(listaOmTppt);

		for(OmTppt omTppt:listaOmTppt){
			this.importar(ijtbjup, omTppt, date, omUsr);
		}
	}

	/**
	 * Importa os dados de {@code ijtbjup} para {@code dwTJust}
	 * @param ijtbjup
	 * @param omTppt
	 */
	private void importar(Ijtbjup ijtbjup, OmTppt omTppt, Date date, OmUsr omUsr){

		Validate.notNull(ijtbjup, "ijtbjup");
		Validate.notNull(omTppt, "omTppt");
		Validate.notNull(omUsr, "omUsr");

		DwTJust dwTJust = new DwTJust();

		// Pega os campos que n�o est�o no banco do injet
		DwTJust dwTJustDB = null;
		try {
			dwTJustDB = this.justificativaRN.getDwTJust(ijtbjup.getCdjustparada(),omTppt);
			dwTJust.setOmTppt(dwTJustDB.getOmTppt());
		} catch (RegistroDesconhecidoException e) {
		}

		// Atualiza campos
		dwTJust.set(
				0l, omTppt, omUsr, omUsr, ijtbjup.getCdjustparada(),
				(long)0,  ijtbjup.getDsjustparada(), null, (byte)1, null);

		dwTJust.limitarStrings();

		this.justificativaRN.salvarDesativandoOriginal(dwTJustDB, dwTJust, date, omUsr);

	}

}
