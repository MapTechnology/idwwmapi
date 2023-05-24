package idw.model.rn.imp.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.DwTArea;
import idw.model.pojos.DwTParada;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.pojos.injet.Ijtbpar;
import idw.model.rn.AreaRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.ParadaRN;
import idw.model.rn.injet.ParadaInjetRN;
import idw.util.IdwLogger;

public class ImportacaoInjetParadaRN extends ImportacaoInjetRN {

	private final ParadaInjetRN ParadaInjetRN;
	private final ParadaRN ParadaRN;
	private final AreaRN areaRN;

	public ImportacaoInjetParadaRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.ParadaInjetRN = new ParadaInjetRN(daoInjet);
		this.ParadaRN = new ParadaRN(dao);
		this.areaRN = new AreaRN(dao);
	}

	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		boolean retorno = ijtbmestres.getAtualizartabparada().equals(1);
		return retorno;
	}

	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt){
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(listaOmTppt,"listaOmTppt");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importa��oo da tabela de Paradas");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de Paradas disponíveis na base do injet
			List<Ijtbpar> listParadaInjet = this.ParadaInjetRN.listaParadasAtivas();

			if(listParadaInjet.size() > 0){

				List<String> listCdParadaInjet = new ArrayList<String>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijtbpar ijtbpar: listParadaInjet){
					this.importar(ijtbpar, listaOmTppt, date, omUsr);
					listCdParadaInjet.add(ijtbpar.getCdparada());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listParadaInjet.size() + " registros");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos");
				this.ParadaRN.desativarParadas(listCdParadaInjet, date, omUsr);

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.ParadaRN.desativarParadas(DataHoraRN.getDataHoraAtual(), omUsr);
			}

		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importa��oo n�o é necessária. N�o marcado para importa��oo");
		}
		
		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), this.getIdentacao(), this.getLog().getAvaliacaoCompleta());

	}

	/**
	 * Importa Parada para cada {@code OmTppt}
	 * @param ijtbpar
	 * @param listaOmTppt
	 */
	private void importar(Ijtbpar ijtbpar, List<OmTppt> listaOmTppt, Date date, OmUsr omUsr){

		Validate.notEmpty(listaOmTppt);

		for(OmTppt omTppt:listaOmTppt){
			this.importar(ijtbpar, omTppt, date, omUsr);
		}
	}

	/**
	 * Importa os dados de {@code ijtbpar} para {@code dwTParada}
	 * @param ijtbpar
	 * @param omTppt
	 */
	private void importar(Ijtbpar ijtbpar, OmTppt omTppt, Date date, OmUsr omUsr){

		Validate.notNull(ijtbpar, "ijtbpar");
		Validate.notNull(omTppt, "omTppt");
		Validate.notNull(omUsr, "omUsr");

		DwTParada dwTParada = new DwTParada();

		// Pega os campos que n�o est�o no banco do injet
		DwTParada dwTParadaDB = null;
		try {
			dwTParadaDB = this.ParadaRN.getDwTParada(ijtbpar.getCdparada(),omTppt, false);
			dwTParada.setOmTppt(dwTParadaDB.getOmTppt());
		} catch (RegistroDesconhecidoException e) {
		}
		
		DwTArea dwTArea = null;
		if(ijtbpar.getIjareres() != null){
			//dwTArea = new DwTArea();
			try {
				dwTArea = areaRN.getDwTArea(ijtbpar.getIjareres().getCdarea(), true);
			} catch (RegistroDesconhecidoException e) {
			}
		}

		// Atualiza campos
		dwTParada.set(
						0l, null, omTppt, dwTArea, omUsr, omUsr, null, ijtbpar.getCdparada(),
						(long)0,  ijtbpar.getDsparada(), null, (byte)1, null,
						ObjectUtils.equals(ijtbpar.getRequercausa(), BigDecimal.ZERO),
						ObjectUtils.equals(ijtbpar.getRequeracao(), BigDecimal.ZERO),
						ObjectUtils.equals(ijtbpar.getRequerjustificativ(), BigDecimal.ZERO),
						ObjectUtils.equals(ijtbpar.getSaidademolde(), BigDecimal.ONE),
						ObjectUtils.equals(ijtbpar.getRequercancelamento(), BigDecimal.ZERO),
						ObjectUtils.equals(ijtbpar.getFds(), new Character('1')),
						ObjectUtils.equals(ijtbpar.getMdo(), new Character('1')),
						ObjectUtils.equals(ijtbpar.getCalcmtbfmttr(), '1'),

						ObjectUtils.equals(ijtbpar.getPa(), new Character('1')),
						ObjectUtils.equals(ijtbpar.getPao(), new Character('1')),
						ObjectUtils.equals(ijtbpar.getReqparadaprep(), BigDecimal.ONE) ,
						ObjectUtils.equals(ijtbpar.getParadaprevista(), BigDecimal.ONE) ,
						ObjectUtils.equals(ijtbpar.getPtp(), new Character('1')),
						ObjectUtils.equals(ijtbpar.getScp(), new Character('1')),
						0, null, null, null, null,
						ObjectUtils.equals(ijtbpar.getPermitecorrecao(), BigDecimal.ZERO), // Alessandre alterei em 26-6-14 para 0 ao inves de 1
						ObjectUtils.equals(ijtbpar.getEntradademolde(), BigDecimal.ONE),
						ObjectUtils.equals(ijtbpar.getSaidademolde(), BigDecimal.ONE),
						null,
						null,
						false
						);

		int qtTec = 0;
		if(ObjectUtils.equals(ijtbpar.getPededrtresponsa(), Integer.valueOf(0))){
			qtTec++;
		}

		if(ObjectUtils.equals(ijtbpar.getPededrttecnico1(), Integer.valueOf(0))){
			qtTec++;
		}
		if(ObjectUtils.equals(ijtbpar.getPededrttecnico2(), Integer.valueOf(0))){
			qtTec++;
		}

		dwTParada.setQtTec(qtTec);

		dwTParada.limitarStrings();

		getLog().info("importando parada " + dwTParada.getCdTparada() + " permiteCorrecao " + dwTParada.getIsPermitecorrecao() + " valor original=" + ijtbpar.getPermitecorrecao() );
		this.ParadaRN.salvarDesativandoOriginal(dwTParadaDB, dwTParada, date, omUsr);

	}

}
