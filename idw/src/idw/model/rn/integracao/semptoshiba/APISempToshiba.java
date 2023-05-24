package idw.model.rn.integracao.semptoshiba;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.Query;
import org.hibernate.exception.SQLGrammarException;

import idw.model.dao.erp.DAOGenericoErp;
import idw.model.rn.DataHoraRN;
import idw.util.AritmeticaUtil;

/** 
 * Estruturas das store procedures da Semp Toshiba 
 * 
 * */
public abstract class APISempToshiba {

	/**
	 * Tipo de item do produto relacionado a origem {@link SPEstruturaProduto#TIPO_ORIGEM}
	 * <br>L = Local
	 * <br>I = Importado
	 * <br>N = Nacional
	 */
	public enum TipoOrigem{
		/** Origem Local */
		L,
		/** Origem Importado */
		I, 
		/** Origem Nacional */
		N;
	}
	
	public enum TipoSemiAcabado{
		/** IAC - Inser��o autom�tica de componente */
		I,
		/** IMC - Inser��o manual de componente */
		M; 
	}
		
	/**
	 * Tipo do produto do campo {@link SPEstruturaProduto#TP_PRODUTO}
	 * TODO colocar o restante dos itens
	 */
	public enum TpProduto{
		/** Semi acababado = 1*/
		SEMI_ACABADO(1),
		/** Componente  = 0*/
		COMPONENTE(0);
		
		private final int id;
		TpProduto(final int id){
			this.id = id;
		}
		
		public int getId(){
			return this.id;
		}

	}
	
	/**
	 * Tipo da produ��o se � para produto final ou para assistencia t�cnica
	 * tipo usado em {@link SPPlanoProducao#TIPO_PRODUCAO}
	 * 
	 */
	public enum TpProducao{
		
		/** Plano de produ��o para produto Acabado (PA) */
		PA,
		/** Plano de produ��o para assit�ncia t�cnica */
		DAT;
	}
	/**
	 * 
	 * Procedure de grupos de produtos
	 *
	 */
	public enum SPGrupo{
		
		/** C�digo do produto */
		CD_PRODUTO(0),
		/** C�digo do grupo */
		CD_GRUPO(1),
		/** Descri��o do produto */
		DS_PRODUTO(2),
		/** Tipo do produto. Atualmente em desuso. Est� retornando o tipo produto que � passado para a SP */
		TP_PRODUTO_OBSOLETO_NAO_USAR(3),
		/** Unidade medida TODO tratar campo*/
		UNIDADE_MEDIDA(4),
		/** Tipo do produto  {@link TpProduto} */
		TP_PRODUTO_2(5),
		/** Tipo semiacabado {@link TipoSemiAcabado} */
		TP_SEMIACABADO(6),
		/** Tipo Origem {@link TipoOrigem}*/
		TP_ORIGEM(7),		
		VALOR_UNITARIO(8)
		;
		
		private final int id;
		
		//private static String PROCEDURE_NAME = "{call spc_MAPCliente(?, ?)}";
		/** Nome da store procedure */
		private static final String STORE_PROCEDURE_NAME = "spc_MAPCliente";
		
		/** N�mero de argumentos da store procedure */
		private static final int TOTAL_ARG = 2;
		
		SPGrupo(final int id){
			this.id = id; 
		}
		
		/** 
		 * Nome da store procedure que retorna os campos listado no {@code EStoreProcedureMapCliente} 
		 */
		public static String getSPName(){
			return STORE_PROCEDURE_NAME;
		}
		
		/**
		 * Pega a query da store procedure, com os parametros j� indicados
		 * @param dao
		 * @param cdProduto
		 * @param tpProduto
		 * @return
		 */
		public static Query getQuery(DAOGenericoErp dao, String cdProduto, String tpProduto ){
			  Query query = dao.createSQLQueryBaseadoStoreProcedure(
					  STORE_PROCEDURE_NAME,
					  TOTAL_ARG);
			  query.setString(0, cdProduto);
			  query.setString(1, tpProduto);
			  return query;			  
		}
						
		/** Posi��o da coluna da store procedure */
		public int getId(){
			return this.id;
			
		}

	}
	

	
	
	
	/**
	 * 
	 * Procedure da estrutura do produto
	 *
	 */
	public enum SPEstruturaProduto{
		
		/** C�digo do grupo do produto */		
		CD_PRODUTO(0),		
		/** Tipo do produto */
		DS_PRODUTO(1),
		/** N�vel */
		NIVEL(2),
		/** Quantidade usada */
		QT_USADA(3),
		/** Tipo do produto */
		TP_PRODUTO(4),
		/** Unidade de medida  TODO tratar campo*/
		UNIDADE_MEDIDA(5),
		/** Tipo semi acabado TODO tratar campo*/
		TIPO_SEMI_ACABADO(6),
		
		/** Tipo de origem do produto {@link TipoItem} TODO tratar campo */
		TIPO_ORIGEM(7),
		
		/** Valor unit�rio TODO nova campo*/
		VALOR_UNITARIO(8);
		
		
		private final int id;

		private static final String STORE_PROCEDURE_NAME = "spc_MapEstrutura2";
		private static final int TOTAL_ARG = 1;
		
		private SPEstruturaProduto(final int id){
			this.id = id;
		}
		
		/** 
		 * Nome da store procedure que retorna os campos listado no {@code EStoreProcedureMapEstruturaProduto} 
		 */
		public static String getSPName(){
			return STORE_PROCEDURE_NAME;
		}
		
		/**
		 * Pega a query da store procedure, com os parametros j� indicados
		 * @param dao
		 * @param cdProduto
		 * @param tpProduto
		 * @return
		 */
		public static Query getQuery(DAOGenericoErp dao, String cdProduto ){
			  Query query = dao.createSQLQueryBaseadoStoreProcedure(
					  STORE_PROCEDURE_NAME,
					  TOTAL_ARG);
			  query.setString(0, cdProduto);
			  //query.setString(1, "");
			  
			  return query;	
		}
		
		
		/** Posi��o da coluna da store procedure */
		public int getId(){
			return this.id;			
		}

	}
	
	
	
	
	
	
	
	
	/**
	 * Store procedure para o plano de produ��o
	 * USE [dtb_SIM]
GO

-- Object:  StoredProcedure [dbo].[spc_MAPPlanoProducao2]    Script Date: 27/08/2013 16:11:37 
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

ALTER PROCEDURE [dbo].[spc_MAPPlanoProducao2]
	@DatProducao	CHAR(7),
	@CodLinha		CHAR(8) = NULL
	
AS

-- EXEC spc_MAPPlanoProducao2 '2013-06', '101.03-0'

SET NOCOUNT ON

IF ISNULL(@CodLinha, '') = ''
	SELECT Linha = CodLinhaDest, MODELO = CodModelo, Qtde = SUM(ISNULL(QtdProducao, QtdProdPM)), DatProducao, TipoProducao = CASE WHEN FlagTP = 'D' THEN 'DAT' ELSE 'PA' END
	FROM tbl_ProgDiaJit
	LEFT JOIN tbl_LinhaTurno ON CodLinhaOri = CodLinha
	WHERE CONVERT(VARCHAR(7), DatProducao, 121) = @DatProducao --AND CodLinhaDest = @CodLinha
	GROUP BY CodLinhaDest, CodModelo, DatProducao, FlagTP
	ORDER BY CodLinhaDest, Modelo, DatProducao

ELSE

	SELECT Linha = CodLinhaDest, MODELO = CodModelo, Qtde = SUM(ISNULL(QtdProducao, QtdProdPM)), DatProducao, TipoProducao = CASE WHEN FlagTP = 'D' THEN 'DAT' ELSE 'PA' END
	FROM tbl_ProgDiaJit
	LEFT JOIN tbl_LinhaTurno ON CodLinhaOri = CodLinha
	WHERE CONVERT(VARCHAR(7), DatProducao, 121) = @DatProducao AND CodLinhaDest = @CodLinha
	GROUP BY CodLinhaDest, CodModelo, DatProducao, FlagTP
	ORDER BY CodLinhaDest, Modelo, DatProducao



GO


exec spc_MapPlanoProducao2 '2013-08' , 0
Linha    MODELO Qtde                                    DatProducao             TipoProducao
-------- ------ --------------------------------------- ----------------------- ------------
101.01-0 921248 900                                     2013-08-29 00:00:00     PA
101.01-0 921248 100                                     2013-08-30 00:00:00     PA
101.01-0 922176 1614                                    2013-08-01 00:00:00     PA
101.01-0 922176 1605                                    2013-08-02 00:00:00     PA
101.01-0 922176 1800                                    2013-08-05 00:00:00     PA
101.01-0 922176 1850                                    2013-08-06 00:00:00     PA
101.01-0 922176 1850                                    2013-08-07 00:00:00     PA
101.01-0 922176 1650                                    2013-08-08 00:00:00     PA
101.01-0 922176 1631                                    2013-08-09 00:00:00     PA
101.01-0 922639 981                                     2013-08-21 00:00:00     PA
101.01-0 922639 1910                                    2013-08-22 00:00:00     PA
101.01-0 922639 1840                                    2013-08-23 00:00:00     PA

	 */
	public enum SPPlanoProducao{
		/** C�digo da linha */
		CD_LINHA(0),
		/** C�digo do produto */
		CD_PRODUTO(1),
		/** Quantidade desejada */
		QT_DESEJADA(2),
		/** Data desejada */
		DT_DESEJADA(3),
		/** Tipo da produ��o: se � para produto final ou semiacabado. {@link APISempToshiba.TpProducao}*/
		TIPO_PRODUCAO(4);
		
		private final int id;
		private final static String STORE_PROCEDURE_NAME = "spc_MapPlanoProducao2";
		private final static int TOTAL_ARGS = 1;
		
		SPPlanoProducao(final int id){
			this.id = id;
		}
		
		/**
		 * Nome da store procedure
		 * @return
		 */
		public static String getStoreProcedureName() {
			return STORE_PROCEDURE_NAME;
		}
		
		/**
		 * Total de argumento da store procedure
		 * @return
		 */
		public static int getTotalArg() {
			return TOTAL_ARGS;
		}

		/**
		 * Posi��o do campo
		 * @return
		 */
		public int getId(){
			return this.id;
		}
		
		/**
		 * Pega os planos de produ��o baseado apenas na data
		 * Setando a {@code Query} da store procedure, com os parametros j� indicados
		 * @see APISempToshiba.SPPlanoProducao#getQuery(DAOGenericoErp, String, String)
		 * @param dao
		 * @param dt - formato "yyyy-mm"
		 * @return
		 */
		public static Query getQuery(DAOGenericoErp dao, String dt){
			  Query query = dao.createSQLQueryBaseadoStoreProcedure(
					  STORE_PROCEDURE_NAME,
					  TOTAL_ARGS);
			  query.setString(0, dt);
			  //query.setString(1, "");
			  return query;			  
		}			
		
		/**
		 * Pega a {@code Query} da store procedure, com os parametros j� indicados
		 * @param dao
		 * @param dt - formato "yyyy-mm"
		 * @param linha para todas as linhas passar vazio ''
		 * @return
		 */
		public static Query getQuery(DAOGenericoErp dao, String dt, String linha ){
//			if(linha == null || linha.isEmpty()){
//				args = 1;
//			}
			if(linha == null){
				linha = "";
			}
			Query query = dao.createSQLQueryBaseadoStoreProcedure(
				  STORE_PROCEDURE_NAME,
				  TOTAL_ARGS);
			  query.setString(0, dt);
			  //query.setString(1, linha);
			  return query;			  
		}	
		
		/**
		 * Pega a lista de planos de produ��o para a data e linha
		 * @param dao
		 * @param dt formato "yyyy-mm"
		 * @param linha se for vazio, pega de todas as linhas
		 * @param dtIni
		 * @param dtFim
		 * @return
		 */
		public static List<PlanoProducao> getResultado(DAOGenericoErp dao, String dt, String linha, Date dtIni, Date dtFim){
			
			List<PlanoProducao> listaPlanoProducao = new ArrayList<PlanoProducao>();
			Query resul = SPPlanoProducao.getQuery(dao, dt, linha);
			
			// ResultSet res = resul.executeQuery();
			Iterator res = resul.list().iterator();

			while (res.hasNext()) {
				Object[] registro = (Object[]) res.next();
				Date dtDesejada;
				if (registro[APISempToshiba.SPPlanoProducao.DT_DESEJADA.getId()] instanceof Date) {
					dtDesejada = (Date) registro[APISempToshiba.SPPlanoProducao.DT_DESEJADA.getId()];
				} else {
					dtDesejada = new Date(((Timestamp) registro[APISempToshiba.SPPlanoProducao.DT_DESEJADA.getId()]).getTime());
				}

				// Pegar planos que est�o entre datas de in�cio e fim
				if(DataHoraRN.compareTo(dtDesejada, dtIni) >= 0 && DataHoraRN.compareTo(dtDesejada, dtFim) <=0){
					String cdLinha = (String) registro[APISempToshiba.SPPlanoProducao.CD_LINHA.getId()];
					String cdProduto = (String) registro[APISempToshiba.SPPlanoProducao.CD_PRODUTO.getId()];
					BigDecimal qtDesejada;
					if (registro[APISempToshiba.SPPlanoProducao.QT_DESEJADA.getId()] instanceof Double)
						qtDesejada = new BigDecimal( ( (Double) registro[APISempToshiba.SPPlanoProducao.QT_DESEJADA.getId()] ) );
					else
						qtDesejada = (BigDecimal) registro[APISempToshiba.SPPlanoProducao.QT_DESEJADA.getId()];
					String tipoProducao = (String) registro[APISempToshiba.SPPlanoProducao.TIPO_PRODUCAO.getId()];
					
					if(cdLinha != null && cdProduto != null && qtDesejada != null && tipoProducao != null){
						if(tipoProducao.equals(APISempToshiba.TpProducao.DAT.toString())){
							cdProduto = IntegracaoEstruturaProduto.adicionarComplementoDATEmCdProduto(cdProduto);
						}
						
						PlanoProducao planoProducao = new PlanoProducao(cdLinha, cdProduto, dtDesejada, qtDesejada, tipoProducao);
						listaPlanoProducao.add(planoProducao);
					}
				}

			}
			

			
			return listaPlanoProducao;
		}			

	}
	
	
	
	
	/**
	 * Store procedure para ordem de compra de componentes. 
	 * <br> Estes dados s�o usado na exporta��o da trilha, "ORDENS_COMPRA_COMPONENTES.txt"  
	 */
	public enum SPPedido{
		/** C�digo do item (semiacabado, materia-prima) */
		CD_PRODUTO(0),
		/** Data prevista para chegada */
		DATA_PREVISTA(1),
		/** Quantidade prevista */
		QTD_PREVISTA(2),
		/** Tipo pedido */
		TIPO_PEDIDO(3); 
		
		final int id;
		private final static String STORE_PROCEDURE_NAME = "spc_MapPedidos";
		private static final int TOTAL_ARGS = 2;
		
		SPPedido(final int id){
			this.id = id;
		}
		
		/** Id da coluna */
		public int getId(){
			return this.id;
		}
		
		/**
		 * Nome da store procedure
		 * @return
		 */
		public static String getStoreProcedureName() {
			return STORE_PROCEDURE_NAME;
		}
		
		/**
		 * Total de argumento da store procedure
		 * @return
		 */
		public static int getTotalArg() {
			return TOTAL_ARGS;
		}
		
		/**
		 * Pega a query da store procedure
		 * @param dao
		 * @return
		 */
		public static Query getQuery(DAOGenericoErp dao, Date inicio, Date fim){
			  Query query = dao.createSQLQueryBaseadoStoreProcedure(
					  STORE_PROCEDURE_NAME,
					  TOTAL_ARGS);
			  query.setDate(0, inicio);
			  query.setDate(1, fim);
			  return query;			  
		}
		
		/**
		 * Lista com o pedido de produto
		 * @param dao
		 * @param inicio
		 * @param fim
		 * @return
		 */
		public static List<PedidoProduto> getResultado(DAOGenericoErp dao, Date inicio, Date fim){
			
			List<PedidoProduto> listaPedidoProdutoDaStoreProcedure = new ArrayList<PedidoProduto>();
			
			Query q = APISempToshiba.SPPedido.getQuery(dao, inicio,fim);

			Iterator rs = q.list().iterator();
			while (rs.hasNext()){
				Object[] registro = (Object[]) rs.next();
				String cdProduto = (String) registro[APISempToshiba.SPPedido.CD_PRODUTO.getId()];
				Date dtPrevista =  (Date) registro[APISempToshiba.SPPedido.DATA_PREVISTA.getId()];
				BigDecimal qtde = null;
				try {
					qtde = (BigDecimal) registro[APISempToshiba.SPPedido.QTD_PREVISTA.getId()];
				} catch (ClassCastException e) {
					qtde = new BigDecimal( (Double) registro[APISempToshiba.SPPedido.QTD_PREVISTA.getId()]);
				}
				String tpPedido =  (String) registro[APISempToshiba.SPPedido.TIPO_PEDIDO.getId()];

				PedidoProduto pedidoProduto = new PedidoProduto(cdProduto, dtPrevista, qtde, tpPedido);
				listaPedidoProdutoDaStoreProcedure.add(pedidoProduto);
			}
			
			List<PedidoProduto> listaPedidoProdutoAgrupado = new ArrayList<PedidoProduto>();
			HashMap<Integer, PedidoProduto> mapPedidoProdutoAgrupado = new HashMap<Integer, PedidoProduto>();
			
			for(PedidoProduto pedidoProduto: listaPedidoProdutoDaStoreProcedure){
				List<Object> listaParaKey = new ArrayList<Object>();
				Collections.addAll(listaParaKey, pedidoProduto.cdProduto, pedidoProduto.getDtPrevista());
				Integer key = listaParaKey.hashCode();
				PedidoProduto itemMap = mapPedidoProdutoAgrupado.get(key);
				if(itemMap == null){
					mapPedidoProdutoAgrupado.put(key, pedidoProduto);
					listaPedidoProdutoAgrupado.add(pedidoProduto);
				}else{
					BigDecimal qtSomada = AritmeticaUtil.somar(pedidoProduto.getQtdPrevista(), itemMap.getQtdPrevista());
					PedidoProduto itemMapAtualizado = new PedidoProduto(pedidoProduto.getCdProduto(), pedidoProduto.getDtPrevista(), qtSomada, pedidoProduto.getTpPedido());
					mapPedidoProdutoAgrupado.put(key, itemMapAtualizado);
				}
			}
			
			return listaPedidoProdutoAgrupado;
		}
		
	}


	/**
	 * Store procedure que faz a carga do estoque do in�cio do m�s. 
	 * <br> Estes dados s�o usado na exporta��o da trilha, "ESTOQUES.txt"  
	 * 
	 * 
	 * USE [dtb_SIM]
		GO

		-- Object:  StoredProcedure [dbo].[spc_MAPSaldoInicial]    Script Date: 27/08/2013 15:34:37 
		SET ANSI_NULLS ON
		GO

		SET QUOTED_IDENTIFIER ON
		GO

		ALTER PROCEDURE [dbo].[spc_MAPSaldoInicial]
			@MesRef CHAR(7)
		AS

		-- EXEC spc_MAPSaldoInicial '2013-08'
		
		
		SELECT CodItem = CodPlaca, QtdSaldo = Sum(QtdSaldoAnt)
		INTO #tmp
		FROM tbl_IAMCEstudoMesPlaca
		WHERE ISNULL(QtdSaldoAnt, 0) > 0 AND CONVERT(CHAR(7), DatProducao, 121) = @MesRef AND NumEstudo = 23
		GROUP BY CodPlaca
		
		--UNION ALL
		
		SELECT E.CodItem, QtdEstoque = SUM(QtdEstoque), QtdSaldoIni = QtdSaldo
		FROM tbl_Estoque E (NOLOCK)
		INNER JOIN tbl_Item I ON I.CodItem = E.CodItem AND FlgAtivoItem = 'S'
		INNER JOIN tbl_IAMCPontoEstoque P ON P.Ponto = E.CodLocal AND P.FlgAtivo = 'S'
		LEFT JOIN #tmp T ON T.CodItem = E.CodItem
		WHERE QtdEstoque > 0 AND E.CodItem <> '' --AND E.CodItem NOT IN (SELECT CodPlaca FROM tbl_IAMCEstudoMesPlaca WHERE ISNULL(QtdSaldoAnt, 0) > 0 AND CONVERT(CHAR(7), DatProducao, 121) = @MesRef AND NumEstudo = 23 GROUP BY CodPlaca)
		GROUP BY E.CodItem, T.QtdSaldo
		ORDER BY E.CodItem
		GO
		
		
		Exemplo de resultado
		CodItem QtdEstoque                              QtdSaldoIni
		------- --------------------------------------- ---------------------------------------
		012179  2236.0000                               NULL
		012181  3071.0000                               NULL
		012182  2066.0000                               NULL
		012183  2122.0000                               NULL
		012184  232.0000                                NULL
		012185  2769.0000                               NULL
		012186  2151.0000                               NULL
		012187  2117.0000                               NULL
		012188  61.0000                                 NULL
		012192  2067.0000                               NULL
		012193  2332.0000                               NULL
		012195  2179.0000                               NULL
		012196  127.0000                                NULL
		012197  1928.0000                               NULL
		012201  2500.0000                               NULL
		012202  2217.0000                               NULL
		532635  4392.0000                               NULL
		532644  4392.0000                               NULL
		532653  4354.0000                               NULL
		532662  4392.0000                               NULL
		532715  32.0000                                 24
		532724  211.0000                                847
		532864  3900.0000                               NULL
		532939  10044.0000                              NULL		
	 */
	public enum SPSaldoInicial{
		/** C�digo do item  */
		CD_PRODUTO(0),
		/** Saldo atual */
		QTD_ESTOQUE(1),
		/** Saldo inicial do m�s */
		QTD_SALDO_INI(2); 
		
		final int id;
		private final static String STORE_PROCEDURE_NAME = "spc_MAPSaldoInicial";
		private final static int TOTAL_ARGS_SEMP = 1;
		
		/**
		 * @see #getTotalArgs(boolean) 
		 */
		private final static int TOTAL_ARGS_INVENTUS = 2;
		SPSaldoInicial(final int id){
			this.id = id;
		}
		
		/** Id da coluna */
		public int getId(){
			return this.id;
		}
		
		/**
		 * Nome da store procedure
		 * @return
		 */
		public static String getStoreProcedureName() {
			return STORE_PROCEDURE_NAME;
		}
		
		/**
		 * Retorna a quantidade de paradametro para a chamada da store procedure. <br>
		 * Inicialmente esta ela só tinha um parametro que era o mês e ano concatenados, exemplo: <br>
		 *  {@code 12-2017} <br>
		 * Mas foi feita uma alteração para estes dados em parametros separados. Analisando os logs de alteração 
		 * no repositório, isso aconteceu em setembro de 2016, mesmo períodos que teve uma modificações com descrição de integração
		 * Inventus. Suspeito que esta mesma classe {@link APISempToshiba}, também estaria sendo usada por lá, e considerando 
		 * esta hipótese, eles tinha a procedure com o padrão de 2 parametros.<br>
		 * O ideal seria ter criado uma outra classe, baseada nessa para isso.<br>    
		 * TODO Será necessário estudar a integração da Inventus para saber se spc_MAPSaldoInicial é realmente usada, e fazer 
		 * uma implementação mais adequada.
		 * Por enquanto, este trecho será adaptado para funcionar nos dois cenários.
		 * 
		 * @param isEmpresaSemp
		 * @return
		 */
		public static int getTotalArgs(boolean isEmpresaSemp) {
			return isEmpresaSemp ? TOTAL_ARGS_SEMP : TOTAL_ARGS_INVENTUS; 

		}
		
		/**
		 * Pega a query da store procedure
		 * 
		 * @param dao
		 * @parada isEmpresaSemp - Apesar da classe ser destinada apenas a Semp.
		 * 			Em algum momento ela foi usada para outro cliente, e quando isso aconteceu, foi 
		 * @return
		 */
		public static Query getQuery(DAOGenericoErp dao, boolean isEmpresaSemp, int mes, int ano){
			int totalArgs = getTotalArgs(isEmpresaSemp);
			Query query = dao.createSQLQueryBaseadoStoreProcedure(
					  STORE_PROCEDURE_NAME,
					  totalArgs);
			
			String strAno = Integer.toString(ano);
			String strMes = Integer.toString(mes);
			
			if(strMes.length()==1){
				strMes = "0" + strMes;
			}
			
			if (isEmpresaSemp) {
				String data = strAno + "-" + strMes;
				query.setString(0, data);
			} else {
				query.setString(0, strMes);
				query.setString(1, strAno);
			}
			
		    return query;
		    
		}
		
		
		public static List<EstoqueProduto> getResultado(DAOGenericoErp dao, boolean isEmpresaSemp, int mes, int ano){
			List<EstoqueProduto> listaEstoqueProduto = new ArrayList<EstoqueProduto>();
			
			Query q = APISempToshiba.SPSaldoInicial.getQuery(dao, isEmpresaSemp, mes, ano);

			Iterator rs = q.list().iterator();
			while (rs.hasNext()){
				Object[] registro = (Object[]) rs.next();				
				EstoqueProduto estoqueProduto = new EstoqueProduto(registro);				
				listaEstoqueProduto.add(estoqueProduto);
			}
			
			return listaEstoqueProduto;
		}
		
	}
	
	
	
	/**
	 * Referente a chamada da store procedure
		ALTER PROCEDURE [dbo].[spc_MAPTempoPadrao]
		AS
		
		--segue query implosao
		SET NOCOUNT ON
		
		
		select distinct CodItem=a.codmodelo,tempopadrao
		INTO #tmpTemPadrao
		from tbl_tempopadrao A
		left join tbl_item B ON b.coditem = a.codmodelo
		--where left(codmodelo,1) <> '9'
		
		select distinct CodItem
		INTO #tmpitem
		from #tmpTemPadrao 
		
		
		DECLARE @CodItem CHAR(6),
		  @CodAparelho CHAR(6),
		  @DataBase SMALLDATETIME
		
		SET @DataBase = GETDATE()
		
		CREATE TABLE #ItemModelos( FlgAlt VARCHAR(10),
		        Aparelho VARCHAR(100),
		        CodModelo VARCHAR(100),        
		        Sigla VARCHAR(10),
		        DesStatus VARCHAR(20),        
		        QtdFreq NUMERIC(10,4),        
		        CodItem VARCHAR(70),
		        CodItemParam VARCHAR(70))
		CREATE NONCLUSTERED INDEX #idx#ItemModelos ON #ItemModelos (Aparelho, CodModelo, CodItem)
		
		CREATE TABLE #tmpAUX (Aparelho CHAR(6),
		       CodItem CHAR(6),
		       FlgAtivo CHAR(1))
		
		CREATE TABLE #ItemModeloLinha (CodItem CHAR(6),
		          Aparelho VARCHAR(8000))
		                 
		--FAZ A IMPLOS�O
		WHILE EXISTS (SELECT CodItem FROM #tmpitem) 
		BEGIN
		 SELECT TOP 1 @CodItem = CodItem FROM #tmpitem
		 
		 EXEC spc_Plano112Aux  @CodItem, @DataBase, 0, 0
		   
		 DELETE FROM #tmpitem WHERE CodItem = @CodItem
		END
		
		
		select aparelho,DesModelo=dbo.fun_desmodelo(aparelho),Coditem=coditemparam,desitem
		INTO #tmpModItem
		from #ItemModelos A
		left join tbl_item B on a.coditemparam = b.coditem
		where a.coditem = coditemparam 
		and aparelho is not null
		and desstatus <> 'Inativo' and sigla in('STA','STPCI')
		group by aparelho,coditemparam,desitem
		order by aparelho,coditemparam
		
		
		-- INSERE PLACA IMC
		select distinct codlinha,CodItem=a.codmodelo,tempopadrao, aparelho, FASE='IMC'
		INTO #tmpModLinha
		from tbl_CapacLinha A
		inner join tbl_item B ON b.coditem = a.codmodelo
		left join #tmpTemPadrao C ON c.coditem = a.codmodelo
		left join #tmpModItem D ON d.coditem = a.codmodelo
		where left(codmodelo,1) <> '9'
		AND flgativoitem = 'S'
		
		
		-- INSERE PLACA FEC
		INSERT INTO #tmpModLinha
		select distinct codlinha,CodItem=a.codmodelo,tempopadrao, aparelho=a.codmodelo,'FEC'
		from tbl_CapacLinha A
		inner join tbl_item B ON b.coditem = a.codmodelo
		left join #tmpTemPadrao C ON c.coditem = a.codmodelo
		left join #tmpModItem D ON d.coditem = a.codmodelo
		where left(codmodelo,1) = '9'
		AND flgativoitem = 'S'
		
		select * from #tmpModLinha
		order by coditem
				
	 * @author milton
	 *
	 */
	public enum SPOperacao{
		/** C�digo da linha */
		CD_LINHA(0),
		/** C�digo do produto semiacabado*/
		CD_PRODUTO_SEMIACABADO(1),
		/** Tempo padr�o */
		TEMPO_PADRAO(2),
		/** C�digo do produto final*/
		CD_PRODUTO_ACABADO(3),
		/** Fase pode ser IMC ou FEC */
		FASE(4);
		
		private final int id;
		private final static String STORE_PROCEDURE_NAME = "spc_MAPTempoPadrao";
		
		SPOperacao(final int id){
			this.id = id;
		}
		
		/**
		 * Nome da store procedure
		 * @return
		 */
		public static String getStoreProcedureName() {
			return STORE_PROCEDURE_NAME;
		}

		/**
		 * Posi��o do campo
		 * @return
		 */
		public int getId(){
			return this.id;
		}
		
		public static Query getQuery(DAOGenericoErp dao){
			  Query query = dao.createSQLQueryBaseadoStoreProcedure(
					  STORE_PROCEDURE_NAME,
					  0);
			  
			  return query;			  
		}			
		
		
		/**
		 * Retorna a lista de opera��es dos produtos, para as fases do IMC e montagem final
		 * @param dao
		 * @return
		 */
		public static List<OperacaoProduto> getResultado(DAOGenericoErp dao){
			
			List<OperacaoProduto> listaOperacaoProduto = new ArrayList<OperacaoProduto>();
			Query resul = SPOperacao.getQuery(dao);
			
			// ResultSet res = resul.executeQuery();
			Iterator res = resul.list().iterator();

			while (res.hasNext()) {
				
				Object[] registro = (Object[]) res.next();
				
				
				String fase = (String) registro[APISempToshiba.SPOperacao.FASE.getId()];
				if(fase != null && fase.equals("IMC")){
					String linha = (String) registro[APISempToshiba.SPOperacao.CD_LINHA.getId()];
					String produtoAcabado = (String) registro[APISempToshiba.SPOperacao.CD_PRODUTO_ACABADO.getId()];
					String produtoSemiAcabado = (String) registro[APISempToshiba.SPOperacao.CD_PRODUTO_SEMIACABADO.getId()];
					BigDecimal tempoPadrao = (BigDecimal) registro[APISempToshiba.SPOperacao.TEMPO_PADRAO.getId()];
					
					if(linha != null && produtoAcabado != null && produtoSemiAcabado != null && tempoPadrao != null){
						OperacaoProduto operacaoProduto = new OperacaoProduto(linha, produtoAcabado, produtoSemiAcabado, tempoPadrao, fase);
						listaOperacaoProduto .add(operacaoProduto);
					}
					
				}
				
			}
			
			return listaOperacaoProduto;
			
		}			

	}	
	
	
	
	/**
	 * Classe para a estrutura da chamada da {@link APISempToshiba.SPPlanoProducao}
	 * <p>
	 * Definida como {@code static} para permitir fazer {@code new PlanoProducao(...)} dentro de m�todo est�tico de {@link APISempToshiba}.
	 * <br> Inner classes s� podem ser instanciadas dentro da classe que as contem, se for usado uma instancia da classe que as contem.
	 *
	 */
	public static class PlanoProducao{
		private final String cdLinha;
		private final String cdProduto;
		private final Date dtDesejada;
		private final BigDecimal qtDesejada;
		private final String tipoProducao;

		public PlanoProducao(final String cdLinha, final String cdProduto, 
				final Date dtDesejada, final BigDecimal qtDesejada, final String tipoProducao) {		
			
			this.cdLinha = cdLinha;
			this.cdProduto = cdProduto;

			this.dtDesejada = dtDesejada;
			this.qtDesejada = qtDesejada;
			this.tipoProducao = tipoProducao;
		}

		public String getCdLinha() {
			return cdLinha;
		}
		public String getCdProduto() {
			return cdProduto;
		}
		public Date getDtDesejada() {
			return dtDesejada;
		}
		public BigDecimal getQtDesejada() {
			return qtDesejada;
		}
		public String getTipoProducao() {
			return tipoProducao;
		}
		
	}
	
	/**
	 * Classe com a estrutura de {@link APISempToshiba.SPPedido}
	 * @author milton
	 *
	 */
	public static class PedidoProduto{
		private final String cdProduto;
		private final Date dtPrevista;
		private final BigDecimal qtdPrevista;
		private final String tpPedido;
				
		public PedidoProduto(final String cdProduto, final Date dtPrevista,
				final BigDecimal qtdPrevista, final String tpPedido) {			
			this.cdProduto = cdProduto;
			this.dtPrevista = dtPrevista;
			this.qtdPrevista = qtdPrevista;
			this.tpPedido = tpPedido;
		}


		public String getCdProduto() {
			return cdProduto;
		}

		public Date getDtPrevista() {
			return dtPrevista;
		}

		public BigDecimal getQtdPrevista() {
			return qtdPrevista;
		}

		public String getTpPedido() {
			return tpPedido;
		}
		
		
	}
	

	/**
	 * Classe para a estrutura da chamada de {@link APISempToshiba.SPSaldoInicial}
	 *
	 */
	public static final class EstoqueProduto{
		private String cdProduto;
		private BigDecimal qtEstoque;
		private BigDecimal qtSaldoIni;
		
		public EstoqueProduto(Object[] registro){
			super();
			
			String cdProduto = (String) registro[APISempToshiba.SPSaldoInicial.CD_PRODUTO.getId()];
			BigDecimal qtEstoque = BigDecimal.ZERO;
			BigDecimal qtSaldoIni = BigDecimal.ZERO;
			
			if (cdProduto != null)
				cdProduto = cdProduto.trim();
			
			try {
				qtEstoque = (BigDecimal) registro[APISempToshiba.SPSaldoInicial.QTD_ESTOQUE.getId()];
			} catch (ClassCastException e) {
				qtEstoque = new BigDecimal((Double) registro[APISempToshiba.SPSaldoInicial.QTD_ESTOQUE.getId()]);
			}
			try {
				qtSaldoIni = (BigDecimal) registro[APISempToshiba.SPSaldoInicial.QTD_SALDO_INI.getId()];
			} catch (ClassCastException e) {
				qtSaldoIni = new BigDecimal((Double) registro[APISempToshiba.SPSaldoInicial.QTD_SALDO_INI.getId()]);
			}
			
			
			setEstoqueProduto(cdProduto, qtEstoque, qtSaldoIni);
		}
		
		private void setEstoqueProduto(String cdProduto, BigDecimal qtEstoque, BigDecimal qtSaldoIni) {
			this.cdProduto = cdProduto;
			this.qtEstoque = qtEstoque;
			this.qtSaldoIni = qtSaldoIni;
		}
		
		public String getCdProduto() {
			return cdProduto;
		}
		public BigDecimal getQtEstoque() {
			return qtEstoque;
		}
		public BigDecimal getQtSaldoIni() {
			return qtSaldoIni;
		}
		
	}
	
	public static class OperacaoProduto{
		private final String linha;
		private final String produtoAcabado;
		private final String produtoSemiAcabado;
		private final BigDecimal tempoPadraoEmHoras;
		private final String fase;
		
		public OperacaoProduto(String linha, String produtoAcabado,
				String produtoSemiAcabado, BigDecimal tempoPadrao, String fase) {
			super();
			this.linha = linha;
			this.produtoAcabado = produtoAcabado;
			this.produtoSemiAcabado = produtoSemiAcabado;
			this.tempoPadraoEmHoras = tempoPadrao;
			this.fase = fase;
		}

		public String getLinha() {
			return linha;
		}

		public String getProdutoAcabado() {
			return produtoAcabado;
		}

		public String getProdutoSemiAcabado() {
			return produtoSemiAcabado;
		}

		public BigDecimal getTempoPadraoEmHoras() {
			return tempoPadraoEmHoras;
		}

		public String getFase() {
			return fase;
		}

		@Override
		public String toString() {
			
			return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
					.append("linha", this.linha)
					.append("produtoAcabado", this.produtoAcabado)
					.append("produtoSemiacabado", this.produtoSemiAcabado)
					.append("fase")
					.append("tempoPadrao", this.tempoPadraoEmHoras)
					.toString();
			
		}
		
	}


	/*
	 * exec spc_MAPAltera
	 * 
(376 row(s) affected)

(370 row(s) affected)
NumNA      CodModelo Posicao    DatPrevista             CodItemSai CodItemEntra QtdSai                                  QtdEntra                                Observacao
---------- --------- ---------- ----------------------- ---------- ------------ --------------------------------------- --------------------------------------- ----------------------------------------------------------------------------------------------------
10003/2014 548147    NW950      2014-05-12 00:00:00     399806     527160       1.0000                                  1.0000                                  NULL
10003/2014 548147    NW957      2014-05-12 00:00:00     399806     527160       1.0000                                  1.0000                                  NULL
10003/2014 553531    NW950      2014-05-12 00:00:00     399806     527160       1.0000                                  1.0000                                  NULL
10003/2014 553531    NW957      2014-05-12 00:00:00     399806     527160       1.0000                                  1.0000                                  NULL
10004/2014 548717    D102       2014-04-30 00:00:00     542651     567553       1.0000                                  1.0000                                  NULL
10004/2014 548717    D103       2014-04-30 00:00:00     542651     567553       1.0000                                  1.0000                                  NULL
10004/2014 561844    D102       2014-04-30 00:00:00     542651     567553       1.0000                                  1.0000                                  NULL
10004/2014 561844    D103       2014-04-30 00:00:00     542651     567553       1.0000                                  1.0000                                  NULL
10004/2014 562022    D102       2014-04-30 00:00:00     542651     567553       1.0000                                  1.0000                                  NULL
10004/2014 562022    D103       2014-04-30 00:00:00     542651     567553       1.0000                                  1.0000                                  NULL
10004/2014 566340    D102       2014-04-30 00:00:00     542651     567553       1.0000                                  1.0000                                  NULL
10004/2014 566340    D103       2014-04-30 00:00:00     542651     567553       1.0000                                  1.0000                                  NULL
10004/2014 567198    D102       2014-04-30 00:00:00     542651     567553       1.0000                                  1.0000                                  NULL
10004/2014 567198    D103       2014-04-30 00:00:00     542651     567553       1.0000                                  1.0000                                  NULL
10010/2014 561862    CP11       2014-05-30 00:00:00     560159     568080       1.0000                                  1.0000                                  NULL
10010/2014 562040    CP11       2014-05-30 00:00:00     560159     568080       1.0000                                  1.0000                                  NULL
10010/2014 567214    CP11       2014-05-30 00:00:00     560159     568080       1.0000                                  1.0000                                  NULL
10027/2014 562558    A401B      2014-05-12 00:00:00     562415     569873       1.0000                                  1.0000                                  NULL
10029/2014 923567    A201       2014-04-23 00:00:00     559759     569882       1.0000                                  1.0000                                  NULL
10029/2014 924254    A201       2014-04-23 00:00:00     559759     569882       1.0000                                  1.0000                                  NULL
10436/2013 545756    VW921      2014-02-19 00:00:00     319466     556477       1.0000                                  1.0000                                  NULL
10436/2013 545765    V205       2014-02-19 00:00:00     319466     556477       1.0000                                  1.0000                                  NULL
10436/2013 545765    V206       2014-02-19 00:00:00     319466     556477       1.0000                                  1.0000                                  NULL
10436/2013 545765    V401       2014-02-19 00:00:00     319466     556477       1.0000                                  1.0000                                  NULL
10436/2013 545765    V402       2014-02-19 00:00:00     319466     556477       1.0000                                  1.0000                                  NULL
10436/2013 545765    V403       2014-02-19 00:00:00     319466     556477       1.0000                                  1.0000                                  NULL
10436/2013 545765    V501       2014-02-19 00:00:00     319475     556486       1.0000                                  1.0000                                  NULL
10436/2013 545765    V502       2014-02-19 00:00:00     319475     556486       1.0000                                  1.0000                                  NULL

	 */
	
	public enum SPItemAlternativoNA{
		Num_NA(0),		
		COD_MODELO(1),		
		POSICAO(2),
		DATA_PREVISTA(3),
		COD_ITEM_SAI(4),
		COD_ITEM_ENTRA(5),
		QTD_SAI(6),
		QTD_ENTRA(7),
		OBS(8), 
		DATA_ENTRA(9),
		DATA_SAI(10);
		
		private final int id;
		private final static String STORE_PROCEDURE_NAME = "spc_MAPAltera";
		private static final int TOTAL_ARGS = 0;
		
		SPItemAlternativoNA(final int id){
			this.id = id;
		}

		public static String getStoreProcedureName() {
			return STORE_PROCEDURE_NAME;
		}

		public int getId(){
			return this.id;
		}
		
		private static Query getQuery(DAOGenericoErp dao){
			  Query query = dao.createSQLQueryBaseadoStoreProcedure(
					  STORE_PROCEDURE_NAME,
					  TOTAL_ARGS);
			  return query;			  
		}			

		public static List<ItemAlternativoNA> getResultado(){
			DAOGenericoErp dao = new DAOGenericoErp();
			List<ItemAlternativoNA> listaItemAlternativoNA = new ArrayList<ItemAlternativoNA>();
			
			try{
				dao.iniciaConexaoBanco(null);
				listaItemAlternativoNA = getResultado(dao);
			}catch(Exception e){
				e.printStackTrace();
				dao.rollBackTransacaoSemException();
			}finally{
				dao.finalizaConexaoBancoSemException();
			}
			return listaItemAlternativoNA;
		}
		
		public static List<ItemAlternativoNA> getResultado(DAOGenericoErp dao){
			
			List<ItemAlternativoNA> listaItemAlternativoNa = new ArrayList<ItemAlternativoNA>();
			Query resul = getQuery(dao);

			Iterator res = resul.list().iterator();

			while (res.hasNext()) {
				
				Object[] registro = (Object[]) res.next();
				
				String numNA = (String) registro[SPItemAlternativoNA.Num_NA.getId()];
				String codModelo = (String) registro[SPItemAlternativoNA.COD_MODELO.getId()];
				Date dataPrevista = (Date) registro[SPItemAlternativoNA.DATA_PREVISTA.getId()];
				String codItemSai = (String) registro[SPItemAlternativoNA.COD_ITEM_SAI.getId()];
				String codItemEntra = (String) registro[SPItemAlternativoNA.COD_ITEM_ENTRA.getId()];
				Integer qtdSaiInt = (Integer) registro[SPItemAlternativoNA.QTD_SAI.getId()];
				Integer qtdEntraInt = (Integer) registro[SPItemAlternativoNA.QTD_ENTRA.getId()];
				
				BigDecimal qtdSai = BigDecimal.ZERO;
				if(qtdSaiInt != null){
					qtdSai = new BigDecimal(qtdSaiInt.intValue());
				}
				BigDecimal qtdEntra = BigDecimal.ZERO;
				if(qtdEntraInt != null){
					qtdEntra = new BigDecimal(qtdEntraInt.intValue());
				}
				
				String posicao = (String) registro[SPItemAlternativoNA.POSICAO.getId()];
				String obs = (String) registro[SPItemAlternativoNA.OBS.getId()];
				Date dataEntra = (Date) registro[SPItemAlternativoNA.DATA_ENTRA.getId()];
				Date dataSai = (Date) registro[SPItemAlternativoNA.DATA_SAI.getId()];
				
				if(numNA != null && 
						codModelo != null && 
						dataEntra != null && 
						qtdSai != null && 
						qtdEntra != null){
					
					ItemAlternativoNA itemAlternativoNA = new ItemAlternativoNA(numNA, codModelo, dataPrevista, 
								codItemSai, codItemEntra, qtdSai, qtdEntra, posicao, obs, dataEntra, dataSai);
					listaItemAlternativoNa.add(itemAlternativoNA);
				}
				
			}
			
			return listaItemAlternativoNa;
			
		}			

	}	

	public static class ItemAlternativoNA{
		
		private final String numNA;		
		private final String codModelo;		
		private final Date dataPrevista;		
		private final String codItemSai;
		private final String codItemEntra;
		private final BigDecimal qtdSai;
		private final BigDecimal qtdEntra;
		private final String posicao;
		private final String obs;
		private final Date dataEntra;
		private final Date dataSai;
		
		public ItemAlternativoNA(String numNA, String codModelo,
				Date dataPrevista, String codItemSai, String codItemEntra,
				BigDecimal qtdSai, BigDecimal qtdEntra, String posicao, String obs, Date dataEntra, Date dataSai) {
			super();
			this.numNA = numNA;
			this.codModelo = codModelo;
			this.dataPrevista = dataPrevista;
			this.codItemSai = codItemSai;
			this.codItemEntra = codItemEntra;
			this.qtdSai = qtdSai;
			this.qtdEntra = qtdEntra;
			this.posicao = posicao;
			this.obs = obs;
			this.dataEntra = dataEntra;
			this.dataSai = dataSai;
		}

		public String getNumNA() {
			return numNA;
		}

		public String getCodModelo() {
			return codModelo;
		}

		public Date getDataPrevista() {
			return dataPrevista;
		}

		public String getCodItemSai() {
			return codItemSai;
		}

		public String getCodItemEntra() {
			return codItemEntra;
		}

		public BigDecimal getQtdSai() {
			return qtdSai;
		}

		public BigDecimal getQtdEntra() {
			return qtdEntra;
		}
		
		public String getPosicao() {
			return posicao;
		}

		public String getObs() {
			return obs;
		}

		public Date getDataEntra() {
			return dataEntra;
		}

		public Date getDataSai() {
			return dataSai;
		}

		
	}

	
	
	public enum SPItemAlternativoDireto{
		COD_MODELO(0),		
		DE(1),		
		PARA(2),
		FREQUENCIA(3),
		PRIORIDADE(4);
		
		private final int id;
		private final static String STORE_PROCEDURE_NAME = "spc_MAP_DEPARA";
		private static final int TOTAL_ARGS = 0;
		
		SPItemAlternativoDireto(final int id){
			this.id = id;
		}

		public static String getStoreProcedureName() {
			return STORE_PROCEDURE_NAME;
		}

		public int getId(){
			return this.id;
		}
		
		private static Query getQuery(DAOGenericoErp dao){
			  Query query = dao.createSQLQueryBaseadoStoreProcedure(
					  STORE_PROCEDURE_NAME,
					  TOTAL_ARGS);
			  return query;			  
		}			

		public static List<ItemAlternativoDireto> getResultado(){
			DAOGenericoErp dao = new DAOGenericoErp();
			List<ItemAlternativoDireto> listaItemAlternativoDiretos = new ArrayList<ItemAlternativoDireto>();
			
			try{
				dao.iniciaConexaoBanco(null);
				listaItemAlternativoDiretos = getResultado(dao);
			}catch(Exception e){
				e.printStackTrace();
				dao.rollBackTransacaoSemException();
			}finally{
				dao.finalizaConexaoBancoSemException();
			}
			return listaItemAlternativoDiretos;
		}
		
		public static List<ItemAlternativoDireto> getResultado(DAOGenericoErp dao){
			
			List<ItemAlternativoDireto> listaItemAlternativoDireto = new ArrayList<ItemAlternativoDireto>();
			Query resul = getQuery(dao);

			Iterator res = resul.list().iterator();

			while (res.hasNext()) {
				
				Object[] registro = (Object[]) res.next();
				
				String codModelo = (String) registro[SPItemAlternativoDireto.COD_MODELO.getId()];
				String de = (String) registro[SPItemAlternativoDireto.DE.getId()];
				String para = (String) registro[SPItemAlternativoDireto.PARA.getId()];
				
				Integer frequencia = (Integer) registro[SPItemAlternativoDireto.FREQUENCIA.getId()];
				
				Integer prioridade = (Integer) registro[SPItemAlternativoDireto.PRIORIDADE.getId()];
				
				if(codModelo != null && de != null && para != null){
					ItemAlternativoDireto itemAlternativoDireto = new ItemAlternativoDireto(codModelo, de, para, frequencia, prioridade) ;
					listaItemAlternativoDireto.add(itemAlternativoDireto);
				}
				
			}
			
			return listaItemAlternativoDireto;
			
		}			

	}	

	public static class ItemAlternativoDireto{
		
		private final String codModelo;
		private final String de;
		private final String para;
		private final Integer frequencia;
		private final Integer prioridade;
		
		public ItemAlternativoDireto(String codModelo, String de, String para, Integer frequencia, Integer prioridade) {
			this.codModelo = codModelo;
			this.de = de;
			this.para = para;
			this.frequencia = frequencia;
			this.prioridade = prioridade;
		}
		
		public String getCodModelo() {
			return codModelo;
		}
		public String getDe() {
			return de;
		}
		public String getPara() {
			return para;
		}
		
		public Integer getFrequencia(){
			return frequencia;
		}
		public Integer  getPrioridade(){
			return prioridade;
		}
		
	}

	public enum SPProdutoConjugado{
		ACABADO_COD(0),		
		ITEM_COD(1);
		
		private final int id;
		private final static String STORE_PROCEDURE_NAME = "spc_MAPConjugados";
		private static final int TOTAL_ARGS = 0;
		
		SPProdutoConjugado(final int id){
			this.id = id;
		}

		public static String getStoreProcedureName() {
			return STORE_PROCEDURE_NAME;
		}

		public int getId(){
			return this.id;
		}
		
		private static Query getQuery(DAOGenericoErp dao){
			  Query query = dao.createSQLQueryBaseadoStoreProcedure(
					  STORE_PROCEDURE_NAME,
					  TOTAL_ARGS);
			  return query;			  
		}			

		public static List<ProdutoConjugado> getResultado(){
			DAOGenericoErp dao = new DAOGenericoErp();
			List<ProdutoConjugado> listaConjugadas = new ArrayList<ProdutoConjugado>();
			
			try{
				dao.iniciaConexaoBanco(null);
				listaConjugadas = getResultado(dao);
			}catch(Exception e){
				e.printStackTrace();
				dao.rollBackTransacaoSemException();
			}finally{
				dao.finalizaConexaoBancoSemException();
			}
			return listaConjugadas;
		}
		
		public static List<ProdutoConjugado> getResultado(DAOGenericoErp dao){
			
			List<ProdutoConjugado> listaConjugadas = new ArrayList<ProdutoConjugado>();
			Query resul = getQuery(dao);

			Iterator res;
			
			try {
				res = resul.list().iterator();
			} catch (SQLGrammarException e) {
				res = null;
			}

			while (res != null && res.hasNext()) {
				
				Object[] registro = (Object[]) res.next();
				
				String codModelo = (String) registro[SPProdutoConjugado.ACABADO_COD.getId()];
				String placa = (String) registro[SPProdutoConjugado.ITEM_COD.getId()];
				
				
				if(codModelo != null && placa != null){
					ProdutoConjugado conjugada = new ProdutoConjugado(codModelo, placa) ;
					listaConjugadas.add(conjugada);
				}
				
			}
			
			return listaConjugadas;
			
		}			

	}	
	
	public static class ProdutoConjugado{
		private final String cdProdutoPai;
		private final String cdProdutoFilho;
		
		public ProdutoConjugado(String cdProdutoPai, String cdProdutoFilho){
			this.cdProdutoPai = cdProdutoPai;
			this.cdProdutoFilho = cdProdutoFilho;
		}
			
		public String getCdProdutoPai() {
			return cdProdutoPai;
		}
		public String getCdProdutoFilho() {
			return cdProdutoFilho;
		}
		
		@Override
		public String toString() {
			
			return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
					.append("produtoPai", this.cdProdutoPai)
					.append("produtoFilho", this.cdProdutoFilho)
					.toString();
			
		}
		
		
	}
}
