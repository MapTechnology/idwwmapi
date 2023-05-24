package idw.model.rn.imp.injet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;

import idw.model.dao.DAOGenerico;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.DigestFileException;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.pojos.OmGt;
import idw.model.pojos.OmPt;
import idw.model.pojos.OmTppt;
import idw.model.pojos.OmUsr;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.IjtbinjTemplate;
import idw.model.pojos.injet.Ijtbmestres;
import idw.model.pojos.template.OmPtTemplate;
import idw.model.pojos.template.OmTpptTemplate;
import idw.model.rn.DataHoraRN;
import idw.model.rn.PTRN;
import idw.model.rn.injet.MaquinaInjetRN;
import idw.util.IdwLogger;
import ms.model.rn.MsRN;

/**
 *
 * @author milton
 *
 */
public class ImportacaoInjetMaquinaRN extends ImportacaoInjetRN {

	private final MaquinaInjetRN maquinaInjetRN;
	private final PTRN ptRN;
	private final MsRN msRN;
	private final static String _CD_TP_PT_COLETAAUTOMATICA = "CIC"; // Grupo de m�quinas c�ciclas;
	private final static String _CD_TP_PT_COLETADISCRETA = "DIS";
	
	public ImportacaoInjetMaquinaRN(IdwLogger log, int idLog, int identacao, DAOGenerico dao, DAOGenericoInjet daoInjet){
		super(log, idLog, identacao, dao, daoInjet);
		this.maquinaInjetRN = new MaquinaInjetRN(daoInjet);
		this.ptRN =  new PTRN(dao);
		this.msRN = new MsRN();
		this.msRN.setDao(dao);
	}

	@Override
	public boolean isPrecisaImportar(Ijtbmestres ijtbmestres){
		Validate.notNull(ijtbmestres,"ijtbmestres");
		return ijtbmestres.getAtualizarcfgandmaq().equals(BigDecimal.ONE);

	}

	@Override
	public void importar(List<Ijtbmestres> listaMestres, List<OmTppt> listaOmTppt, OmUsr omUsr, OmGt omGt) {
		Validate.notNull(listaMestres,"listaMestres");
		Validate.notNull(omUsr,"omUsr");

		this.getLog().iniciaAvaliacao(this.getIdLog(), "Importacao da tabela de maquina");

		// Verifica se precisa
		if( this.isPrecisaImportar(listaMestres) ){

			// Lista de usuario dispon�veis na base do injet
			List<Ijtbinj> listMaquinasInjet = this.maquinaInjetRN.listaMaquinasAtivasLicenciadas();

			if(listMaquinasInjet.size() > 0){

				List<String> listaDosQueDevemFicarAtivos = new ArrayList<String>();

				Date date = DataHoraRN.getDataHoraAtual();

				// Atualiza registros existentes
				for(Ijtbinj ijtbinj: listMaquinasInjet){
					try {
						this.importar(ijtbinj, date, omUsr);
					} catch (RegistroDesconhecidoException e) {
						this.getLog().info(this.getIdLog(), this.getIdentacao(),"M�quina " + ijtbinj.getCdinjestendido() + " n�o importada porque n�o existe TpPt default" );
					}
					listaDosQueDevemFicarAtivos.add(ijtbinj.getCdinjestendido());
				}
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Foram Atualizados:" + listMaquinasInjet.size() + " registros");

				// Desativa registros em desuso
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Desativando registros obsoletos");
				this.ptRN.desativarOmPts(listaDosQueDevemFicarAtivos, date, omUsr);
				this.msRN.desativarMsUps(listaDosQueDevemFicarAtivos, date, omUsr);

			}else {
				this.getLog().info(this.getIdLog(), this.getIdentacao(), "Todos os registros marcados como obsoletos");
				this.ptRN.desativarOmPts(DataHoraRN.getDataHoraAtual(), omUsr);
			}

			this.getDao().flush();
			this.getDao().clear();

		} else {
			this.getLog().info(this.getIdLog(), this.getIdentacao(), "Importacao nao e necessaria. Nao marcado para importacao");
		}
		
		this.getLog().paraAvaliacao(this.getDao());
		this.getLog().info(this.getIdLog(), this.getIdentacao(), this.getLog().getAvaliacaoCompleta());

	}

	/**
	 * Importa os dados de {@code ijtbinj} para {@code omPt}
	 * @param ijtbinj
	 * @param dateOperacao
	 * @param omUsrOperacao
	 * @throws RegistroDesconhecidoException quando grupo para m�quina n�o � encontrado
	 * @throws DigestFileException
	 */
	private void importar(Ijtbinj ijtbinj, Date dateOperacao, OmUsr omUsrOperacao) throws RegistroDesconhecidoException{

		Validate.notNull(ijtbinj, "ijtbinj eh null");
		Validate.notNull(omUsrOperacao, "omUsrOperacao eh null");

		OmPt omPt = new OmPt();

		// Pega os campos que n�o est�o no banco do injet
		OmPt omPtDB = null;
		try {
			// Alessandre: Mudei a pesquisa do OmPt para pesquisar apenas os ativos em 02-10-13 pois quero importar um pt como coleta discreta, mas uma revisao anterior esta como coleta automatica
			//			
			omPtDB = this.getDao().findByCd(OmPt.class, ijtbinj.getCdinjestendido(), OmPtTemplate._FIELD_NAME_CD, true);
			
			// Se nao houve mudanca no cdidentifica entao desconsiederar registro
			if (omPtDB.getDsPt().equals(ijtbinj.getCdidentific()) == true)
				return;
			
			this.getDao().evict(omPtDB);
			omPt.set(null, 
					omPtDB.getOmClp(), 
					omPtDB.getOmTppt(), 
					omPtDB.getOmAlimByIdAlimpre(), 
					omPtDB.getOmAlimByIdAlim(), 
					omPtDB.getOmAlimByIdAlimcorrente(),
					omPtDB.getOmGt(), null, null, 
					omPtDB.getOmCc(), 
					ijtbinj.getCdinjestendido(), null, null, null, null, 
					ijtbinj.getCdidentific(),
					ijtbinj.getCdidentific(), 
					omPtDB.getDepara(), 
					omPtDB.getTpImpprog(), (byte) 1, 
					omPtDB.getEstagio(), 
					omPtDB.getDwFolha(), 
					omPtDB.getIsPlangt(), 
					omPtDB.getIsApongt(), 
					omPtDB.getIndOee(),
					omPtDB.getIsParadalinha(),
					ijtbinj.obtemTpSessaoPadraoIDW(),
					omPtDB.getDsSessao(), false, false, (byte) 0,
					null, null, null, null, null, null, omPtDB.getModulo());
			// Senoj: Este ponto deve ter um flush reinicia transa��o para ja aplicar a mudan�a logo ap�s ser feita, reduzindo a chance de conflitos utilizando o SnapShot
		} catch (RegistroDesconhecidoException e) {

			// Se n�o encontrar dispara RegistroDesconhecidoException
			String cdTppt = "";
			if (ijtbinj.obtemTpLicenca() == IjtbinjTemplate.TiposColeta.COLETA_AUTOMATICA.getTpColeta()) {
				cdTppt = ImportacaoInjetMaquinaRN._CD_TP_PT_COLETAAUTOMATICA;
			}
			if (ijtbinj.obtemTpLicenca() == IjtbinjTemplate.TiposColeta.COLETA_DISCRETA.getTpColeta()) {
				cdTppt = ImportacaoInjetMaquinaRN._CD_TP_PT_COLETADISCRETA;
			}
			OmTppt omTppt = this.getDao().findByCd(OmTppt.class, cdTppt, OmTpptTemplate._FIELD_NAME_CD, true);

			// Atualiza campos
			omPt.set( null, null , omTppt, null, null, null, null, null,null, null, 
					ijtbinj.getCdinjestendido(), null, null, null, null, 
					ijtbinj.getCdidentific(),
					ijtbinj.getCdidentific(), null, (byte) 0, (byte) 1, null, null, null, null, null, null, 
					ijtbinj.obtemTpSessaoPadraoIDW(), 
					null, false, false, (byte) 0,
					null, null, null, null, null, null, null);

		}

		omPt.limitarStrings();

		omPt = this.ptRN.salvarDeixandoOriginal(omPtDB, omPt, dateOperacao, omUsrOperacao);

	}


}
