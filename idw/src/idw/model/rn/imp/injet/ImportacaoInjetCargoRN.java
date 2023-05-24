package idw.model.rn.imp.injet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmCargo;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijtbcar;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.pojos.injet.Ijtbusu;
import idw.model.rn.CargoRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.CargoInjetRN;
import idw.util.IdwLogger;

/**
 *
 * @author milton
 * Alessandre em 1-4-17 tirei do depracated pois eh necessario importar tb os cargos
 */
public class ImportacaoInjetCargoRN extends ImportacaoInjetRN {

	private final CargoInjetRN cargoInjetRN;
	private final CargoRN cargoRN;

	public ImportacaoInjetCargoRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.cargoInjetRN = new CargoInjetRN(daoInjet);
		this.cargoRN = new CargoRN(dao);
	}

	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		return ijtbmestres.getAtualizartabtecnic().equals(1);
	}

	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt){
		this.importar(listaMestres, omUsr, null);
	}

	/**
	 * Importa os dados de {@code ijtbcar} para {@code omCargo}
	 * @param ijtbcar
	 */
	private void importar(Ijtbcar ijtbcar, Date date, OmUsr omUsr){

		Validate.notNull(ijtbcar, "ijtbcar");
		Validate.notNull(omUsr, "omUsr");

		OmCargo omCargo = new OmCargo();

		// Pega os campos que n�o est�o no banco do injet
		OmCargo omCargoDB = null;
		try {
			omCargoDB = this.cargoRN.getOmCargo(ijtbcar.getCdcargo(),false);
		} catch (RegistroDesconhecidoException e) {
		}

		// Atualiza campos
		omCargo.set(
				0, omUsr, omUsr, ijtbcar.getCdcargo(),
				(long)0,  ijtbcar.getDscargo(), null, (byte)1, null);

		omCargo.limitarStrings();

		this.cargoRN.salvarDesativandoOriginal(omCargoDB, omCargo, date, omUsr);

	}

	public void importar(List<Ijtbmestres> listaMestres, OmUsr omUsr, List<Ijtbusu> listUsuarioInjet) {

		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importa��o da tabela de cargo");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de cargo dispon�veis na base do injet
			List<Ijtbcar> listCargoInjet = null;
			if(listUsuarioInjet == null){
				listCargoInjet = this.cargoInjetRN.listaCargos();
			}else {
				listCargoInjet = this.cargoInjetRN.listaCargosUsuariosAtivos(listUsuarioInjet);
			}

			if(listCargoInjet.size() > 0){

				List<String> listCdCargoInjet = new ArrayList<String>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijtbcar ijtbcar: listCargoInjet){
					this.importar(ijtbcar, date, omUsr);
					listCdCargoInjet.add(ijtbcar.getCdcargo());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listCargoInjet.size() + " registros");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos");
				this.cargoRN.desativarCargos(listCdCargoInjet, date, omUsr);

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.cargoRN.desativarCargos(DataHoraRN.getDataHoraAtual(), omUsr);
			}

		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importa��o n�o � necess�ria. N�o marcado para importa��o");
		}

		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), 0, this.getLog().getAvaliacaoCompleta());

	}

}
