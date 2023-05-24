package idw.model.rn.imp.injet;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.util.IdwLogger;

public abstract class ImportacaoInjetFactory {
	public enum TipoImportacao{
		JUSTIFICATIVA, //
		CAUSA, //
		ACAO, //
		CARGO, //
		AREA,
		PARADA, //
		REFUGO, //
		ALERTA, //
		USUARIO, //
		MOLDE, //
		CICLO, //
		MAQUINA, //
		PRODUTO, //
		PLANEJAMENTO;
	}

	public static ImportacaoInjetRN getInstance(TipoImportacao type, IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		switch (type) {

		case JUSTIFICATIVA:
			return new ImportacaoInjetJustificativaRN(log, idLog, identacao, dao, daoInjet);

		case CAUSA:
			return new ImportacaoInjetCausaRN(log, idLog, identacao, dao, daoInjet);

		case ACAO:
			return new ImportacaoInjetAcaoRN(log, idLog, identacao, dao, daoInjet);

		case AREA:
			return new ImportacaoInjetAreaRN(log, idLog, identacao, dao, daoInjet);
			
		case PARADA:
			return new ImportacaoInjetParadaRN(log, idLog, identacao, dao, daoInjet);

		case ALERTA:
			return new ImportacaoInjetAlertaRN(log, idLog, identacao, dao, daoInjet);

		case REFUGO:
			return new ImportacaoInjetRefugoRN(log, idLog, identacao, dao, daoInjet);

		case USUARIO:
			return new ImportacaoInjetUsuarioRN(log, idLog, identacao, dao, daoInjet);

		case MAQUINA:
			return new ImportacaoInjetMaquinaRN(log, idLog, identacao, dao, daoInjet);

		case PRODUTO:
			return new ImportacaoInjetProdutoRN(log, idLog, identacao, dao, daoInjet);

		case PLANEJAMENTO:
			return new ImportacaoInjetPlanejamentoRN(log,  idLog, identacao, dao, daoInjet);
		
		case MOLDE:
			return new ImportacaoInjetFerramentaRN(log, idLog, identacao, dao, daoInjet);

		case CARGO:
			return new ImportacaoInjetCargoRN(log, idLog, identacao, dao, daoInjet);

		default:
			break;

		}

		return null;

	}

}
