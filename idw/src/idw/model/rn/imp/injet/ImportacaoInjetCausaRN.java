package idw.model.rn.imp.injet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwTCausa;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijtbcau;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.rn.CausaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.CausaInjetRN;
import idw.util.IdwLogger;

/**
 *
 * @author milton
 *
 */
public class ImportacaoInjetCausaRN extends ImportacaoInjetRN {

	private final CausaInjetRN causaInjetRN;
	private final CausaRN causaRN;

	public ImportacaoInjetCausaRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.causaInjetRN = new CausaInjetRN(daoInjet);
		this.causaRN = new CausaRN(dao);
	}

	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		return ijtbmestres.getAtualizartabcausas().equals(1);
	}

	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt){
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(listaOmTppt,"listaOmTppt");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importa��o da tabela de causas");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de causas dispon�veis na base do injet
			List<Ijtbcau> listCausaInjet = this.causaInjetRN.listaCausasAtivas();

			if(listCausaInjet.size() > 0){

				List<String> listCdCausaInjet = new ArrayList<String>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijtbcau ijtbcau: listCausaInjet){
					this.importar(ijtbcau, listaOmTppt, date, omUsr);
					listCdCausaInjet.add(ijtbcau.getCdcausas());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listCausaInjet.size() + " registros");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos");
				this.causaRN.desativarCausas(listCdCausaInjet, date, omUsr);

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.causaRN.desativarCausas(DataHoraRN.getDataHoraAtual(), omUsr);
			}

		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importa��o n�o � necess�ria. N�o marcado para importa��o");
		}

		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), this.getIdentacao(), this.getLog().getAvaliacaoCompleta());

	}

	/**
	 * Importa causa para cada {@code OmTppt}
	 * @param ijtbcau
	 * @param listaOmTppt
	 */
	private void importar(Ijtbcau ijtbcau, List<OmTppt> listaOmTppt, Date date, OmUsr omUsr){

		Validate.notEmpty(listaOmTppt);

		for(OmTppt omTppt:listaOmTppt){
			this.importar(ijtbcau, omTppt, date, omUsr);
		}
	}

	/**
	 * Importa os dados de {@code ijtbcau} para {@code dwTCausa}
	 * @param ijtbcau
	 * @param omTppt
	 */
	private void importar(Ijtbcau ijtbcau, OmTppt omTppt, Date date, OmUsr omUsr){

		Validate.notNull(ijtbcau, "ijtbcau");
		Validate.notNull(omTppt, "omTppt");
		Validate.notNull(omUsr, "omUsr");

		DwTCausa dwTCausa = new DwTCausa();

		// Pega os campos que n�o est�o no banco do injet
		DwTCausa dwTCausaDB = null;
		try {
			dwTCausaDB = this.causaRN.getDwTCausa(ijtbcau.getCdcausas(),omTppt);
			dwTCausa.setOmTppt(dwTCausaDB.getOmTppt());
		} catch (RegistroDesconhecidoException e) {
		}

		// Atualiza campos
		dwTCausa.set(
				0, omTppt, omUsr, omUsr, ijtbcau.getCdcausas(),
				(long)0,  ijtbcau.getDscausas(), null, (byte)1, null);

		dwTCausa.limitarStrings();

		this.causaRN.salvarDesativandoOriginal(dwTCausaDB, dwTCausa, date, omUsr);

	}

}
