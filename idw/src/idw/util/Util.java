package idw.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StatelessSession;

import idw.model.IdwFacade;
import idw.model.dao.MapQuery;
import idw.model.excessoes.RegistroDesconhecidoException;
import idw.model.excessoes.SemConfiguracaoException;
import idw.model.pojos.OmCfg;
import idw.webservices.dto.PesquisaDTO;
import idw.webservices.dto.PesquisasDTO;
import injetws.model.excessoes.SemSGBDException;


public class Util {


	public static String getVersao(){
		//return "v0.131.10";   //TODO:Favor Mantenham Atualizado este Campo
		//return "v0.132.54-NIDW";   //inc om.jar e libs
		//return "v0.132.55-NIDW";   //IHM: problema na regra que habilitava o botao de refugo
		//return "v0.132.56-NIDW";   //revisão pesquisa de usuários e correção nos filtros dos paretos de parada e refugo do BI
		return "v0.132.57-NIDW";   //implementacao do gráfico de análise de turno e correção de bugs nos filtros dos paretos  de parada e refugo (falhava por dia, por ano ok)
	}


	public static String removeCaracter(String deonde, String oque){
		return deonde.replaceAll(oque, "");
	}


	/**
	 * Funcao que pega a configuracao geral do sistema
	 * @return Retona um objeto (OmCfg) Hibernate com as configuracoes do sistema
	 */
	public static OmCfg getConfigGeral(Session oSession) {
		MapQuery q = new MapQuery(oSession);

		q.append("SELECT omcfg ");
		q.append("FROM OmCfg omcfg ");
		q.append("WHERE omcfg.stAtivo = :stAtivo ");
		q.defineParametro("stAtivo", (byte) 1);

		q.setMaxResults(1);
		q.query().setTimeout(LockOptions.NO_WAIT);
		q.query().setLockOptions(LockOptions.NONE);

		OmCfg oOmCfg = (OmCfg) q.uniqueResult();
		q = null;
		return(oOmCfg);
	}
	public static OmCfg getConfigGeral(StatelessSession oSession) {
		MapQuery q = new MapQuery(oSession);

		q.append("SELECT omcfg ");
		q.append("FROM OmCfg omcfg ");
		q.append("WHERE omcfg.stAtivo = :stAtivo ");
		q.defineParametro("stAtivo", (byte) 1);

		q.query().setMaxResults(1);
		q.query().setTimeout(LockOptions.NO_WAIT);
		q.query().setLockOptions(LockOptions.NONE);

		OmCfg oOmCfg = null;
		oOmCfg = (OmCfg) q.query().uniqueResult();
		q = null;
		return(oOmCfg);
	}

	/**
	 * Funcao generica para executar uma query e retornar um resultado de um tipo
	 * @param <T> - tipo generico que utilize Hibernate (POJO)
	 * @param oGen - novo objeto do tipo T
	 * @param oSession - Sessao do hibernate
	 * @param hql - hql a ser executada
	 * @return Retorna o objeto passado preenchido pela execucao da query passada
	 * @throws SemSGBDException Se deu pau no banco
	 * @throws RegistroDesconhecidoException Se a query passada nao retornar registro algum
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getDadosBanco(T oGen, Session oSession , String hql) throws SemSGBDException, RegistroDesconhecidoException {
		Query q = oSession.createQuery(hql);
		q.setMaxResults(1);
		try{
			oGen = (T) q.uniqueResult();
		} catch (Exception e){
			e.printStackTrace();
			throw new SemSGBDException();
		}

		if (oGen == null)
			throw new RegistroDesconhecidoException();

		return(oGen);
	}


	/**
	 * Funcao generica para executar uma query e retornar um resultado de um tipo
	 * e pode colocar parametros de data na query
	 * @param <T> - tipo generico que utilize Hibernate (POJO)
	 * @param oGen - novo objeto do tipo T
	 * @param oSessao - Sessao do hibernate
	 * @param hql - hql a ser executada
	 * @param saSubQuery - String array contendo as referencias das datas
	 * @param DateParams - Data para colocar da query
	 * @return Retorna o objeto passado preenchido pela execucao da query passada
	 * @throws SemSGBDException Se deu pau no banco
	 * @throws RegistroDesconhecidoException Se a query passada nao retornar registro algum
	 */
	@SuppressWarnings({ "unchecked" })
	public static <T> T getDadosBanco(T oGen, Session oSessao, String hql, String[] saSubQuery, Date... DateParams) throws SemSGBDException, RegistroDesconhecidoException {
		Query q = oSessao.createQuery(hql);

		for(int iCont = 0; iCont < saSubQuery.length; iCont++) {
			String sParam = saSubQuery[iCont];
			Date dParam = DateParams[iCont];

			q.setDate(sParam, dParam);
		}
		q.setMaxResults(1);
		try{
			oGen = (T) q.uniqueResult();
		} catch (Exception e){
			throw new SemSGBDException();
		}

		if (oGen == null)
			throw new RegistroDesconhecidoException();

		return(oGen);
	}

	/**
	 * Funcao generica para executar uma query e retornar uma lista de resultados de um tipo
	 * @param <T> - tipo generico que utilize Hibernate (POJO)
	 * @param oGen - novo objeto do tipo T
	 * @param hql - hql a ser executada
	 * @return Retorna uma lista do objeto passado preenchido pela execucao da query passada
	 * @throws SemSGBDException Se deu pau no banco
	 * @throws RegistroDesconhecidoException Se a query passada nao retornar registro algum
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getDadosBancoLista(T oGen, Session oSession, String hql) throws SemSGBDException, RegistroDesconhecidoException {
		Query q = oSession.createQuery(hql);

		List<T> listaGen = null;
		try{
			listaGen = q.list();
		} catch (Exception e){
			e.printStackTrace();
			throw new SemSGBDException();
		}

		if (listaGen.size() == 0)
			throw new RegistroDesconhecidoException();

		return(listaGen);
	}

	public static String getSelectGrupoProduto(){
		StringBuilder retorno = new StringBuilder();

		retorno.append("<select size='2'");
		retorno.append("name='grupoproduto' style='width: 250px' tabindex='4'>");

		PesquisasDTO lista = IdwFacade.getInstancia().pesquisaGrupoProduto(new PesquisaDTO());
		if (lista != null){
			for (PesquisaDTO item : lista.getPesquisa()){
				retorno.append("<option value='");
				retorno.append(item.getCodigo());
				retorno.append("'>");
				retorno.append(item.getCodigo());
				retorno.append(" - ");
				retorno.append(item.getDescricao());
				retorno.append("</option>");
			}
		}
		retorno.append("</select>");
		return retorno.toString();
	}

	public static String getSelectProdutoDePara(String name, String depara){
		StringBuilder retorno = new StringBuilder();

		retorno.append("<select size='1'");
		retorno.append("name='");
		retorno.append(name);
		retorno.append("' style='width: 250px' tabindex='4'>");

		retorno.append("<option value=''></option>");

		List<String> lista = IdwFacade.getInstancia().pesquisaProdutoDepara();
		if (lista != null){
			for (String item : lista){
				String selected = depara.equals(item) ? "selected" : "";
				retorno.append("<option value='");
				retorno.append(item);
				retorno.append("' ");
				retorno.append(selected);
				retorno.append(">");
				retorno.append(item);
				retorno.append("</option>");
			}
		}
		retorno.append("</select>");
		return retorno.toString();
	}

	public static String getSelectProdutoComplemento(String name, String complemento){
		StringBuilder retorno = new StringBuilder();

		retorno.append("<select size='1'");
		retorno.append("name='");
		retorno.append(name);
		retorno.append("' style='width: 250px' tabindex='4'>");

		retorno.append("<option value=''></option>");

		List<String> lista = IdwFacade.getInstancia().pesquisaProdutoComplemento();
		if (lista != null){
			for (String item : lista){
				String selected = complemento.equals(item) ? "selected" : "";
				retorno.append("<option value='");
				retorno.append(item);
				retorno.append("' ");
				retorno.append(selected);
				retorno.append(">");
				retorno.append(item);
				retorno.append("</option>");
			}
		}
		retorno.append("</select>");
		return retorno.toString();
	}

	public static String getSelectEtapa(String name, String cdetapa){
		StringBuilder retorno = new StringBuilder();

		retorno.append("<select size='1'");
		retorno.append("name='");
		retorno.append(name);
		retorno.append("' style='width: 250px' tabindex='4'>");

		retorno.append("<option value=''></option>");

		PesquisasDTO lista = IdwFacade.getInstancia().pesquisaEtapa(new PesquisaDTO());
		if (lista != null){
			for (PesquisaDTO item : lista.getPesquisa()){
				String selected = cdetapa.equals(item.getCodigo()) ? "selected" : "";
				retorno.append("<option value='");
				retorno.append(item.getCodigo());
				retorno.append("' ");
				retorno.append(selected);
				retorno.append(">");
				retorno.append(item.getCodigo());
				retorno.append(" - ");
				retorno.append(item.getDescricao());
				retorno.append("</option>");
			}
		}
		retorno.append("</select>");
		return retorno.toString();
	}

	public static String getSelectParamEntrada(String name, String stValor){
		String retorno = "";

		retorno += "<select size='1'";
		retorno += "name='"+name+"' style='width: 250px' tabindex='4'>";

		retorno += "<option value=''></option>";

		OmCfg omCfg = null;
		try {
			omCfg = IdwFacade.getInstancia().pesquisaOmcfg();
		} catch (SemConfiguracaoException e){
			omCfg = null;
		}
		if (omCfg != null){
			if (omCfg.getDwFtParamByIdFtParamfluxoe() != null){
				String selected1 = stValor.equals(omCfg.getDwFtParamByIdFtParamfluxoe().getStValor1().toString()) ? "selected" : "";
				String selected2 = stValor.equals(omCfg.getDwFtParamByIdFtParamfluxoe().getStValor2().toString()) ? "selected" : "";
				String selected3 = stValor.equals(omCfg.getDwFtParamByIdFtParamfluxoe().getStValor3().toString()) ? "selected" : "";
				String selected4 = stValor.equals(omCfg.getDwFtParamByIdFtParamfluxoe().getStValor4().toString()) ? "selected" : "";

				retorno += "<option value='" + omCfg.getDwFtParamByIdFtParamfluxoe().getStValor1() + "' " + selected1 + ">" + omCfg.getDwFtParamByIdFtParamfluxoe().getDsValor1() + "</option>";
				retorno += "<option value='" + omCfg.getDwFtParamByIdFtParamfluxoe().getStValor2() + "' " + selected2 + ">" + omCfg.getDwFtParamByIdFtParamfluxoe().getDsValor2() + "</option>";
				retorno += "<option value='" + omCfg.getDwFtParamByIdFtParamfluxoe().getStValor3() + "' " + selected3 + ">" + omCfg.getDwFtParamByIdFtParamfluxoe().getDsValor3() + "</option>";
				retorno += "<option value='" + omCfg.getDwFtParamByIdFtParamfluxoe().getStValor4() + "' " + selected4 + ">" + omCfg.getDwFtParamByIdFtParamfluxoe().getDsValor4() + "</option>";
			}

		}
		retorno += "</select>";
		return retorno;
	}

	/**
	 * Padroniza BigDecimal com scala de 5 usando {@code RoundingMode.FLOOR}
	 * @param o
	 * @return
	 */
	public static BigDecimal getBigDecimalDefault(BigDecimal o){
		return o.setScale(5, RoundingMode.FLOOR);
	}

	public static BigDecimal getBigDecimalComCasas(BigDecimal o, int casas) {
		if (o == null)
			return o;
		return o.setScale(casas, RoundingMode.FLOOR);
	}

	/**
	 * Nova instancia {@code BigDecimal} padronizada {@link Util#getBigDecimalDefault(BigDecimal)}
	 * @param v
	 * @return
	 */
	public static BigDecimal newInstanceBigDecimal(Float v){
		return Util.getBigDecimalDefault(new BigDecimal(v));
	}

	/**
	 * Nova instancia {@code BigDecimal} padronizada {@link Util#getBigDecimalDefault(BigDecimal)}
	 * @param v
	 * @return
	 */
	public static BigDecimal newInstanceBigDecimal(Double v){
		return Util.getBigDecimalDefault(new BigDecimal(v));
	}

	/**
	 * Nova instancia {@code BigDecimal} padronizada {@link Util#getBigDecimalDefault(BigDecimal)}
	 * @param v
	 * @return
	 */
	public static BigDecimal newInstanceBigDecimal(Integer v){
		return Util.getBigDecimalDefault(new BigDecimal(v));
	}

	/**
	 * @deprecated usar equals da classe {@link idw.util.CompareUtils}
	 * @param o1
	 * @param o2
	 * @return
	 */
	@Deprecated
	public static <T> boolean equals(T o1, T o2){
		return ObjectUtils.equals(o1, o2);
	}

	public static String getSelectParamSaida(String name, String stValor){
		String retorno = "";

		retorno += "<select size='1'";
		retorno += "name='"+name+"' style='width: 250px' tabindex='4'>";

		retorno += "<option value=''></option>";

		OmCfg omCfg = null;
		try {
			omCfg = IdwFacade.getInstancia().pesquisaOmcfg();
		} catch (SemConfiguracaoException e) {
			omCfg = null;
		}
		if (omCfg != null){
			if (omCfg.getDwFtParamByIdFtParamflusos() != null){
				String selected1 = stValor.equals(omCfg.getDwFtParamByIdFtParamflusos().getStValor1().toString()) ? "selected" : "";
				String selected2 = stValor.equals(omCfg.getDwFtParamByIdFtParamflusos().getStValor2().toString()) ? "selected" : "";
				String selected3 = stValor.equals(omCfg.getDwFtParamByIdFtParamflusos().getStValor3().toString()) ? "selected" : "";
				String selected4 = stValor.equals(omCfg.getDwFtParamByIdFtParamflusos().getStValor4().toString()) ? "selected" : "";

				retorno += "<option value='" + omCfg.getDwFtParamByIdFtParamflusos().getStValor1() + "' " + selected1 + ">" + omCfg.getDwFtParamByIdFtParamflusos().getDsValor1() + "</option>";
				retorno += "<option value='" + omCfg.getDwFtParamByIdFtParamflusos().getStValor2() + "' " + selected2 + ">" + omCfg.getDwFtParamByIdFtParamflusos().getDsValor2() + "</option>";
				retorno += "<option value='" + omCfg.getDwFtParamByIdFtParamflusos().getStValor3() + "' " + selected3 + ">" + omCfg.getDwFtParamByIdFtParamflusos().getDsValor3() + "</option>";
				retorno += "<option value='" + omCfg.getDwFtParamByIdFtParamflusos().getStValor4() + "' " + selected4 + ">" + omCfg.getDwFtParamByIdFtParamflusos().getDsValor4() + "</option>";
			}

		}
		retorno += "</select>";
		return retorno;
	}
	
	public static int retornaNumeroDeDiasDoMes(){
		
		
		int iYear = Calendar.getInstance().get(Calendar.YEAR);
		int iMonth = Calendar.getInstance().get(Calendar.MONTH);// 1 (months begin with 0)
		int iDay = 1;

		// Create a calendar object and set year and month
		Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);

		// Get the number of days in that month
		int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
		
		return daysInMonth;
	}
	
	public static String diferencaEntreDatas(Date startTime){
			
		long diff = (new Date()).getTime() - startTime.getTime();
		
		long diffSeconds = diff / 1000 % 60;  
		long diffMinutes = diff / (60 * 1000) % 60; 
		long diffHours = diff / (60 * 60 * 1000);
	
		
		return String.valueOf(diffHours)+":"+String.valueOf(diffMinutes)+":"+String.valueOf(diffSeconds);
		
		
	}



	public static String extraiPorMascara(String cb, String mascara) {
		return extraiPorMascara(cb, mascara, 0);
	}

	public static String extraiPorMascara(String cb, String mascara, int grupoRegex) {
		/**
		 * @DEPRECATED O padr?o da etiqueta do produto: a. AAAAA - 5 primeiras
		 *             posi??es = c?digo do produto (sku=modelo) b. B = 1
		 *             posi??o = voltagem A=110 B=220v c. C = 1 posi??o = cor d.
		 *             D = 1 posi??o = vers?o do produto, exemplo A, B, C.
		 *             Quando uma nova vers?o ? criada, a vers?o anterior se
		 *             torna obsoleta e deixa de ser produzida. e. EE = 2
		 *             posi??es = se o produto ? para o mercado NA (nacional) ou
		 *             internacional. f. FFFFFFFFF = 9 posi??es = n?mero de
		 *             s?rie do produto. g. GG = 2 posi??es = uso n?o
		 *             identificado.
		 *
		 *             retornar AAAAA
		 **/

		/**
		 * SessaoDTO deve ter o campo om_cfg.mascaraCdProdutoPai, que ter? o
		 * conteudo
		 *
		 * ??????--??
		 *
		 * assim retorno = CB nas posicoes onde aparece o ?, por exemplo
		 *
		 * CB = 1234567890ABCDEF
		 *
		 * retorno sera = 12345690
		 *
		 */

		/**
		 * Refactory do metodo extraiProduto da classe ProdutoRN
		 *
		 * @author pedro
		 *
		 */

		if (mascara == null)
			return cb;


		// Testar se a mascara eh regex
		if (mascara.contains("@")) {
			// Remove o @ e aspas duplas da mascara
			mascara = mascara.replaceAll("@", "");
			mascara = mascara.replaceAll(Character.toString((char)64), "");
			Pattern padrao = Pattern.compile(mascara);
			Matcher matcher = padrao.matcher(cb);
			if (matcher.find()) {
				return matcher.group(grupoRegex);
			}
			return cb;
		}


		char[] cCb = cb.toCharArray();
		char[] cMascara = mascara.toCharArray();
		StringBuilder sbCdProduto = new StringBuilder();

		String codigoProduto = null;

		try {
			for (int iCont = 0; iCont < cMascara.length; iCont++) {
				if (cMascara[iCont] == '?') {
					sbCdProduto.append(cCb[iCont]);
				}
			}
			codigoProduto = sbCdProduto.toString();
		} catch (Exception e) {
			codigoProduto = cb;
		}

		return (codigoProduto);
	}

	public static void main(String[] args) {
		String padrao = "@\\d{0,10}\\d$";
		String padraoCD = "@^\\w+";
		String valor = "AADFF*102";

		System.out.println("[" + Util.extraiPorMascara(valor, padrao) + "]");
		System.out.println("[" + Util.extraiPorMascara(valor, padraoCD) + "]");

	}
}
