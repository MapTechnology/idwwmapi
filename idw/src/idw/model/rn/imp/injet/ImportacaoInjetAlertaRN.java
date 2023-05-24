package idw.model.rn.imp.injet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwTAlerta;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijtbale;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.rn.AlertaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.AlertaInjetRN;
import idw.util.IdwLogger;

/**
 *
 * @author milton
 *
 */
public class ImportacaoInjetAlertaRN extends ImportacaoInjetRN {

	private final AlertaInjetRN alertaInjetRN;
	private final AlertaRN alertaRN;

	public ImportacaoInjetAlertaRN(IdwLogger log, int idLog, int identalerta, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identalerta, dao, daoInjet);
		this.alertaInjetRN = new AlertaInjetRN(daoInjet);
		this.alertaRN = new AlertaRN(dao);
	}

	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		return ijtbmestres.getAtualizartabalerta().equals(1);
	}

	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt){
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(listaOmTppt,"listaOmTppt");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importa��oo da tabela de alertas");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de alertas disponíveis na base do injet
			List<Ijtbale> listAlertaInjet = this.alertaInjetRN.listaAlertasAtivas();

			if(listAlertaInjet.size() > 0){

				List<String> listCdAlertaInjet = new ArrayList<String>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijtbale ijtbale: listAlertaInjet){
					this.importar(ijtbale, listaOmTppt, date, omUsr);
					listCdAlertaInjet.add(ijtbale.getCdalerta());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listAlertaInjet.size() + " registros");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos");

				this.alertaRN.desativarAlertas(listCdAlertaInjet, date, omUsr);

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.alertaRN.desativarAlertas(DataHoraRN.getDataHoraAtual(), omUsr);
			}

		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importa��oo n�o é necessária. N�o marcado para importa��oo");
		}

		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), this.getIdentacao(), this.getLog().getAvaliacaoCompleta());

	}

	/**
	 * Importa alerta para cada {@code OmTppt}
	 * @param ijtbale
	 * @param listaOmTppt
	 */
	private void importar(Ijtbale ijtbale, List<OmTppt> listaOmTppt, Date date, OmUsr omUsr){

		Validate.notEmpty(listaOmTppt);

		for(OmTppt omTppt:listaOmTppt){
			this.importar(ijtbale, omTppt, date, omUsr);
		}
	}

	/**
	 * Importa os dados de {@code ijtbale} para {@code dwTAlerta}
	 * @param ijtbale
	 * @param omTppt
	 */
	private void importar(Ijtbale ijtbale, OmTppt omTppt, Date date, OmUsr omUsr){

		Validate.notNull(ijtbale, "ijtbale");
		Validate.notNull(omTppt, "omTppt");
		Validate.notNull(omUsr, "omUsr");

		DwTAlerta dwTAlerta = new DwTAlerta();

		// Pega os campos que n�o est�o no banco do injet
		DwTAlerta dwTAlertaDB = null;
		try {
			dwTAlertaDB = this.alertaRN.getDwTAlerta(ijtbale.getCdalerta(),omTppt, false);
			dwTAlerta.setOmTppt(dwTAlertaDB.getOmTppt());
		} catch (RegistroDesconhecidoException e) {
		}

		// Atualiza campos
		dwTAlerta.set(
				0, omTppt, omUsr, omUsr, ijtbale.getCdalerta(),
				(long)0,  ijtbale.getDsalerta(), null, (byte)1, null, false, false);

		dwTAlerta.limitarStrings();

		this.alertaRN.salvarDesativandoOriginal(dwTAlertaDB, dwTAlerta, date, omUsr);

	}

}
