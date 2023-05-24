package ms.model.rn.injet;

import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijtbboardmach;
import idw.model.pojos.injet.Ijtbinj;
import idw.model.pojos.injet.IjtbinjTemplate;
import idw.model.pojos.injet.Ijtbinjconfig;
import idw.model.pojos.injet.Ijtbmestres;

import java.math.BigDecimal;
import java.util.List;

public class MaquinaInjetRN extends DAOGenericoInjet {	
	
	public MaquinaInjetRN(DAOGenericoInjet daoInjet){		
		this.setDao(daoInjet);
	}
	
	public static String _CFG_TP_SESSAO_PRODUCAO = "CFG001";
	public static String _CFG_TAMANHO_UM_PACOTE_CICLOS = "CFG002";
	public static String _CFG_PERC_TMP_CICLO_PAR_AUTO = "CFG003";
	public static String _CFG_INTERRUPCAO_CICLO = "CFG004";
	public static String _CFG_PERC_TMP_CICLO_INICIALIZACAO = "CFG005";
	public static String _CFG_PERC_TOLERANCIA_SINAL_CICLO = "CFG006";
	public static String _CFG_DBC = "CFG007";
	public static String _CFG_ST_UP = "CFG008";
	public static String _CFG_TOLERTMPCICLOPARAAUTO = "CFG009";

	
	public Ijtbinj pesquisarIjtbinj(String cd){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbinj ijtb where ijtb.cdinjetora = :cd and ijtb.cdinjetora <> '999999'");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbinj) q.uniqueResult();
	}
	public Ijtbinj pesquisarIjtbinjByCdMestreCdColetorCdSubColetor(String cdMestre, String cdColetor, BigDecimal cdSubColetor){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbinj ijtb where ijtb.cdmestre = :cdMestre and ijtb.cdcoletor = :cdColetor and ijtb.cdsubcoletor = :cdSubColetor");
		q.defineParametro("cdMestre", cdMestre);
		q.defineParametro("cdColetor", cdColetor);
		q.defineParametro("cdSubColetor", cdSubColetor);
		q.setMaxResults(1);
		return (Ijtbinj) q.uniqueResult();
	}
	public Ijtbinjconfig pesquisarIjTbInjConfig(String cdInjetora, String idConfig){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbinjconfig ijtb where ijtb.id.cdinjetora = :cd and ijtb.id.idconfig = :id ");
		q.defineParametro("cd", cdInjetora);
		q.defineParametro("id", idConfig);
		q.setMaxResults(1);
		return (Ijtbinjconfig) q.uniqueResult();
	}
	public Double getIjTbInjConfigValor(String cdInjetora, String idConfig){
		double retorno = 0d;
		Ijtbinjconfig ijtbinjconfig = null;
		ijtbinjconfig = pesquisarIjTbInjConfig(cdInjetora, idConfig);
		if (ijtbinjconfig != null){
			retorno = Double.parseDouble(ijtbinjconfig.getValor());
		}
		ijtbinjconfig = null;
		return retorno;
	}
	public boolean isIjtbinjLicenciada(Ijtbinj ijtbinj){
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("from Ijtbboardmach ijtb where ijtb.id.campo01 in (300, 301) and ijtb.id.campo07 = :cd "); // 300 - coleta automatica 301-coleta discreta
		q.defineParametro("cd", ijtbinj.getCdinjetora());
		q.setMaxResults(1);
		Ijtbboardmach ijtbboardmach = (Ijtbboardmach) q.uniqueResult();
		if (ijtbboardmach != null) {
			if (ijtbboardmach.getId().getCampo01() == 300d) {
				// coleta automatica
				ijtbinj.mudaTpLicenca(IjtbinjTemplate.TiposColeta.COLETA_AUTOMATICA.getTpColeta());
			}
			if (ijtbboardmach.getId().getCampo01() == 301d) {
				// coleta discreta
				ijtbinj.mudaTpLicenca(IjtbinjTemplate.TiposColeta.COLETA_DISCRETA.getTpColeta());
			}
		}
		return (ijtbboardmach == null ? false : true);
	}
	
	public void atualizarIjtbcoletores(String cdInjetora, String idColetor){
		MapQuery q = new MapQuery(getDao().getSession());

		Ijtbinj ijtbinj = pesquisarIjtbinj(cdInjetora);
		
		q.append("update Ijtbcoletores");
		q.append("set idalterncoletor = :idalternocoletor");
		q.append("where cdmestre = :cdmestre");
		q.append("and cdcoletor = :cdcoletor");

		q.defineParametro("idalternocoletor", idColetor);
		q.defineParametro("cdmestre", ijtbinj.getCdmestre());
		q.defineParametro("cdcoletor", ijtbinj.getCdcoletor());

		q.query().executeUpdate();
	}
	
	public List<Ijtbmestres> pesquisarIjtbmestres(List<Object> listaCdBc){	
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbmestres ijtbmestres where ijtbmestres.cdmestre in (:listaMestre)");
		q.defineListaParametro("listaMestre", listaCdBc);
		return  q.list();
	}
	public Ijtbinj pesquisarIjtbinjByCdInjestendido(String cd){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbinj ijtb where ijtb.cdinjestendido = :cd and ijtb.cdinjetora <> '999999'");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbinj) q.uniqueResult();
	}
}
