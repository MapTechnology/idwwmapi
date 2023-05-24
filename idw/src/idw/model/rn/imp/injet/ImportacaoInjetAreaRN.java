package idw.model.rn.imp.injet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwTArea;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijareres;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.rn.AreaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.AreaInjetRN;
import idw.util.IdwLogger;

public class ImportacaoInjetAreaRN extends ImportacaoInjetRN {

	private final AreaInjetRN areaInjetRN;
	private final AreaRN areaRN;

	public ImportacaoInjetAreaRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.areaInjetRN = new AreaInjetRN(daoInjet);
		this.areaRN = new AreaRN(dao);
	}

	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		return ijtbmestres.getAtualizartabparada().equals(1) || ijtbmestres.getAtualizartabrefugo().equals(1);
	}

	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt,  OmUsr omUsr, OmGt omGt){
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importa��o da tabela de areas");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de causas dispon�veis na base do injet
			List<Ijareres> listAreaInjet = this.areaInjetRN.listaAreasAtivas();

			if(listAreaInjet.size() > 0){

				List<String> listCdAreaInjet = new ArrayList<String>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijareres ijareres: listAreaInjet){
					this.importar(ijareres, date, omUsr);
					listCdAreaInjet.add(ijareres.getCdarea());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listAreaInjet.size() + " registros");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos");
				this.areaRN.desativarAreas(listCdAreaInjet, date, omUsr);

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.areaRN.desativarAreas(DataHoraRN.getDataHoraAtual(), omUsr);
			}

		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importa��o n�o � necess�ria. N�o marcado para importa��o");
		}

		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), this.getIdentacao(), this.getLog().getAvaliacaoCompleta());

	}
	
	/**
	 * Importa os dados de {@code ijareres} para {@code dwTArea}
	 * @param ijareres
	 * @param omTppt
	 */
	private void importar(Ijareres ijareres, Date date, OmUsr omUsr){

		Validate.notNull(ijareres, "ijareres");
		Validate.notNull(omUsr, "omUsr");

		DwTArea dwTArea = new DwTArea();

		// Pega os campos que n�o est�o no banco do injet
		DwTArea dwTAreaDB = null;
		try {
			dwTAreaDB = this.areaRN.getDwTArea(ijareres.getCdarea(),false);
		} catch (RegistroDesconhecidoException e) {
		}

		// Atualiza campos
		dwTArea.set(
				0, omUsr, omUsr, ijareres.getCdarea(),
				(long)0,  ijareres.getDsarea(), null, (byte)1, null,null);

		dwTArea.limitarStrings();

		this.areaRN.salvarDesativandoOriginal(dwTAreaDB, dwTArea, date, omUsr);

	}

}
