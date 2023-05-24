package ms.model.rn.injet;

import java.util.List;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.dao.MapQuery;
import idw.model.pojos.injet.Ijtbleader;
import idw.model.pojos.injet.Ijtbinj;

public class LicencaInjetRN extends DAOGenericoInjet {

	public static String _INJETTV_54 = "000054";
	public static String _CONSULTAS_WEB_90 = "000090";
	public static String _ANDON_PROCESSOFT_98 = "000098";
	public static String _ANDON_CONFIGURAVEL_105 = "000105";
	public static String _MODULO_LICENCA_QTD_COLETORES_AUTOMATICOS = "000300";
	public static String _MODULO_JUSTIFIC_CAV_ISOLADAS  = "000055";

	public Ijtbinj pesquisarIjtbinj(String cd){
		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbinj ijtb where ijtb.cdinjetora = :cd and ijtb.cdinjetora <> '999999'");
		q.defineParametro("cd", cd);
		q.setMaxResults(1);
		return (Ijtbinj) q.uniqueResult();
	}
	
	public boolean isModuloLicenciado(String cdmodulo) {
		boolean isAutorizado = false;

		List<Ijtbleader> ijtbleaders = null;

		MapQuery q = new MapQuery(getDao().getSession());
		q.append("from Ijtbleader A");

		ijtbleaders = (q.list());

		if (ijtbleaders != null && ijtbleaders.size() > 0){
			for (Ijtbleader ijtbleader : ijtbleaders){
				String strSerialKey = descriptar(ijtbleader.getId().getCampo1());
				String ativo = descriptar(ijtbleader.getId().getCampo3());

				if (strSerialKey.substring(7, 13).equals(cdmodulo) && !ativo.equals("CERTAMENTE NAO VALIDA")){
					isAutorizado = true;
					break;
				}
			}
		}
		return isAutorizado;
	}

	public static String descriptar(String senha) {
	    String strSenhaDescriptada, strNovaSequencia = "", strTmp;
	    char chrZero = (char)0, chr;

		if (senha == null) {
			return null;
		}
		int tamSenha = senha.length();
		if (tamSenha == 0) {
			return senha;
		}

		if (tamSenha == 1) {
			chr = senha.charAt(0);
			if (chr == chrZero) {
				strSenhaDescriptada = ",";
			} else {
				strSenhaDescriptada = senha;
			}
			return strSenhaDescriptada;
		}

		// tamSenha > 1
		for (int i=0; i<tamSenha; i++) {
			int numBase = 256;
			int numASC = senha.charAt(i);
			if (numASC == 0) {
				numASC = 44;
			}
			numASC = numBase - numASC;
			strNovaSequencia += (char) numASC;
		}

		int numResto = tamSenha % 2;
        int tamSeq = tamSenha / 2;
        // O valor do meio deve ser preservado nesse ponto para senha de tamanho impar
        // Tira o elemento do meio, usado para strings de tamanho impar
        char meio = strNovaSequencia.charAt(tamSeq);
        if (numResto==1) {
        	strTmp = strNovaSequencia.substring(0, tamSeq) + strNovaSequencia.substring(tamSenha-tamSeq);
        	strNovaSequencia = strTmp;
        }
        int nTam = strNovaSequencia.length();

		boolean lTrocar = false;
        char chr1, chr2;
        String strEsq="", strDir="";
		for (int i=0; i<nTam; i+=2) {
			chr1 = strNovaSequencia.charAt(i);
			chr2 = strNovaSequencia.charAt(i+1);
			// troca de posicao quando lTroca for falso
		  	if (lTrocar==true) {
		  		strEsq = chr1 + strEsq;
		  		strDir = strDir + chr2;
		    } else {
		  		strEsq = chr2 + strEsq;
		  		strDir = strDir + chr1;
		    }
		  	lTrocar = !lTrocar;
		}

		strSenhaDescriptada = strEsq;
		if (numResto == 1) {
			strSenhaDescriptada += meio;
		}
		strSenhaDescriptada += strDir;
		return strSenhaDescriptada;
	}
}
