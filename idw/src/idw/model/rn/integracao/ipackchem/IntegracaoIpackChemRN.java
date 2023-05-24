package idw.model.rn.integracao.ipackchem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import idw.idwws.Ijparprog;
import idw.idwws.Ijplanop;
import idw.model.dao.MapQuery;
import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.pojos.injet.Ijfilaopsipackchem;
import idw.model.pojos.injet.Ijintipackchemaltd;
import idw.model.pojos.injet.Ijintipackchemop;
import idw.model.pojos.injet.Ijqldcqipackchem;
import idw.model.pojos.injet.Ijtbpro;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.integracao.ipackchem.dto.IntIpackChemAlteracaoFimPlanejadoDTO;
import idw.model.rn.integracao.ipackchem.dto.IntIpackChemApontamentoProducaoDTO;
import idw.model.rn.integracao.ipackchem.dto.IntIpackChemCGQLiberadoDTO;
import idw.model.rn.integracao.ipackchem.dto.IntIpcRegistroOPDTO;
import idw.model.rn.integracao.ipackchem.dto.IpcOPDTO;
import idw.model.rn.integracao.ipackchem.dto.IpcOPRet;
import idw.model.rn.integracao.ipackchem.dto.IpcProDTO;
import idw.model.rn.integracao.ipackchem.dto.IpcProRet;
import idw.model.rn.integracao.ipackchem.dto.ListaIntIpackChemApontamentosProducaoDTO;
import idw.model.rn.integracao.ipackchem.dto.ListaIntIpackChemLiberacaoCertificadoDTO;
import idw.model.rn.integracao.ipackchem.dto.ListaIntIpackChemListaComAltDataFimPlanDTO;
import ms.util.ConversaoTipos;

public class IntegracaoIpackChemRN extends AbstractRN<DAOGenericoInjet>
{
	public IntegracaoIpackChemRN()
	{
		this(null);
	}
		
	public IntegracaoIpackChemRN(DAOGenericoInjet dao) 
	{
		super(dao);
		if (dao == null) {
			dao = new DAOGenericoInjet();
		}
		this.setDao(dao);
	}
	
	private String validacaoProduto(IpcProDTO produto)
	{
		String retorno = "";
		
		String cdProduto = "";
		String dsProduto = "";
		String operacao = "";
		
		BigDecimal pesoLiquido = BigDecimal.ZERO;
		BigDecimal pesoBruto = BigDecimal.ZERO;
		BigDecimal valor = BigDecimal.ZERO;
		
		if (produto == null)
		{
			retorno = "Registro nulo";
		}
		else
		{
			operacao = produto.getOperacao() == null ? "" : produto.getOperacao().trim(); 
			cdProduto = produto.getCdProduto() == null ? "" : produto.getCdProduto().trim();
			dsProduto = produto.getDsProduto() == null ? "" : produto.getDsProduto().trim();
			pesoLiquido = new BigDecimal((produto.getPesoLiquido() == null ? 0d: produto.getPesoLiquido().doubleValue()));
			pesoBruto = new BigDecimal((produto.getPesoBruto() == null ? 0d: produto.getPesoBruto().doubleValue()));
			valor = new BigDecimal((produto.getVlrProduto() == null ? 0d: produto.getVlrProduto().doubleValue()));
		}
		
		
		if (retorno.equals(""))
		{
			if (!operacao.equals("I") && !operacao.equals("A") && !operacao.equals("E"))
			{
				retorno = "Opera��oo inválida: deve ser I, A ou E";
			}
		}

		
		if (retorno.equals(""))
		{
			if (cdProduto.equals(""))
			{
				retorno = "Código do produto nulo ou vazio";
			}
		}

		if (retorno.equals(""))
		{
			if (dsProduto.equals(""))
			{
				retorno = "Descri��oo do produto nula ou vazia";
			}			
		}
		
		
		if (retorno.equals(""))
		{		
			if ( 
					(cdProduto.contains("-")) ||
					(cdProduto.contains(",")) ||
					(cdProduto.contains("'")) ||
					(cdProduto.contains("\"")) ||
					(cdProduto.contains("|")) 
			   )
			{
				retorno = "Código do produto inválido: contém caracter(es) n�o permtidos";
				
			}
		}
		
		if (retorno.equals(""))
		{
			if ( 
					(dsProduto.contains("-")) ||
					(dsProduto.contains(",")) ||
					(dsProduto.contains("'")) ||
					(dsProduto.contains("\"")) ||
					(dsProduto.contains("|")) 
			   )
			{
				retorno = "Descri��oo do produto inválida: contém caracter(es) n�o permtidos";
				
			}
		}
		
		if (retorno.equals(""))
		{
			if ( pesoLiquido.doubleValue() <= 0d )
			{
				retorno = "Peso líquido inválido";
			}
		}
		
		if (retorno.equals(""))
		{
			if ( pesoBruto.doubleValue() <= 0d )
			{
				retorno = "Peso bruto inválido";
			}
		}
		
		if (retorno.equals(""))
		{
			if ( valor.doubleValue() <= 0d )
			{
				retorno = "Valor do produto inválido";
			}
		}

		
		return retorno;
	}

	private String validacaoOP(IpcOPDTO op)
	{
		String retorno = "";
		
		String nrOPERP = "";
		String cdProduto = "";
		String operacao = "";
		Double qtdPlan = 0d;
		
		if (op == null)
		{
			retorno = "Registro nulo";
		}
		else
		{
			operacao = op.getOperacao() == null ? "" : op.getOperacao().trim();  
			nrOPERP = op.getNrOPERP() == null ? "" : op.getNrOPERP().trim();
			cdProduto = op.getCdProduto() == null ? "" : op.getCdProduto().trim();
			qtdPlan = op.getQtdPlan() == null ? 0d: op.getQtdPlan();
		}
		
		if (retorno.equals(""))
		{
			if (!operacao.equals("I") && !operacao.equals("A") && !operacao.equals("E"))
			{
				retorno = "Opera��oo inválida: deve ser I, A ou E";
			}
		}
		
		
		if (retorno.equals(""))
		{
			if (nrOPERP.equals(""))
			{
				retorno = "Número da OP nulo ou vazio";
			}
		}

		
		if (retorno.equals(""))
		{
			if (cdProduto.equals(""))
			{
				retorno = "Código do produto nulo ou vazio";
			}
		}

		if (retorno.equals(""))
		{		
			if ( 
					(nrOPERP.contains("-")) ||
					(nrOPERP.contains(",")) ||
					(nrOPERP.contains("'")) ||
					(nrOPERP.contains("\"")) ||
					(nrOPERP.contains("|")) 
			   )
			{
				retorno = "Número da OP inválido: contém caracter(es) n�o permtidos";
				
			}
		}
		
		if (retorno.equals(""))
		{
			if ( 
					(cdProduto.contains("-")) ||
					(cdProduto.contains(",")) ||
					(cdProduto.contains("'")) ||
					(cdProduto.contains("\"")) ||
					(cdProduto.contains("|")) 
			   )
			{
				retorno = "Código do produto inválida: contém caracter(es) n�o permtidos";
				
			}
		}
		
		if (retorno.equals(""))
		{
			if (op.getPrioridade() == null)
			{
				retorno = "Prioridade com valor nulo";
			}
		}
		
		if (retorno.equals(""))
		{
			if (op.getDthrTermino() == null)
			{
				retorno = "Data previsto para término com valor nulo";
			}
		}
		
		if (retorno.equals(""))
		{
			if (qtdPlan.doubleValue() <= 0d)
			{
				retorno = "Quantidade planejada inválida";
			}
		}

		
		if (retorno.equals(""))
		{
			MapQuery q = new MapQuery(this.getDao().getSession());
			q.append("SELECT a");
			q.append("  FROM Ijtbpro a");
			q.append(" WHERE a.cdproduto = '" + cdProduto + "'");		
			Ijtbpro registro = (Ijtbpro) q.uniqueResult(); 
	
			if (registro == null)
			{
				retorno = "Produto n�o cadastrado";
			}
			
			q = null;
		}
		
		return retorno;
	}

	public IpcProRet importarProdutoIpcInj(IpcProDTO produto)
	{
		IpcProRet retorno = new IpcProRet();
		
		String stRegistro = "OK";
		String mensagem = "";
		String retornoValidacao = validacaoProduto(produto);

		if (retornoValidacao.equals(""))
		{
			MapQuery q = new MapQuery(this.getDao().getSession());
			BigDecimal pesoBruto = null;
			BigDecimal pesoLiquido = null;
			BigDecimal valorProduto = null;
			
			q.append("SELECT a");
			q.append("  FROM Ijtbpro a");
			q.append(" WHERE a.cdproduto = '" + produto.getCdProduto().trim() + "'");
			Ijtbpro registro = (Ijtbpro) q.uniqueResult();
			
			pesoBruto = new BigDecimal(produto.getPesoBruto()).divide(BigDecimal.ONE, 3, BigDecimal.ROUND_HALF_EVEN);
			pesoLiquido = new BigDecimal(produto.getPesoLiquido()).divide(BigDecimal.ONE, 3, BigDecimal.ROUND_HALF_EVEN);
			valorProduto = new BigDecimal(produto.getVlrProduto()).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_EVEN);
			
			// inclus�o
			if (produto.getOperacao().equals("I"))
			{
				if (registro != null)
				{
					stRegistro = "FALHA";
					mensagem = "Produto já cadastrado";
				}
				else
				{
					// inserir em ijtbpro
					this.getDao().iniciaTransacao();
					registro = new Ijtbpro();
					registro.setCdproduto(produto.getCdProduto().trim().toUpperCase());
					registro.setDsproduto(produto.getDsProduto().trim().toUpperCase());
					registro.setPbrutomedio(pesoBruto);
					registro.setPliquidomedio(pesoLiquido);
					registro.setVlproduto(valorProduto);
					
					// valores default
					registro.setUnproduto("PC");
					registro.setCor("NONE");
					registro.setFatorconversao(0d);
					registro.setTpproduto(new BigDecimal(2));
					registro.setTpinspqld('0');
					registro.setTmpliminspqld(BigDecimal.ZERO);
					registro.setTmptrocaprdt(BigDecimal.ONE);
					registro.setTmptrocapstc(BigDecimal.ONE);
					registro.setTamlotekanban(BigDecimal.ZERO);
					registro.setPerclotekanban(0d);
					registro.setTampulmaopadrao(100d);
					registro.setTampulmaomax(90d);
					registro.setTampulmaomin(50d);
					
					this.getDao().makePersistent(registro);
					this.getDao().finalizaTransacao();
				}
			}
			
			
			// altera��oo
			if (produto.getOperacao().equals("A"))
			{
				if (registro == null)
				{
					stRegistro = "FALHA";
					mensagem = "Produto n�o cadastrado";
				}
				else
				{
					this.getDao().iniciaTransacao();
					registro.setDsproduto(produto.getDsProduto().toUpperCase());
					registro.setPbrutomedio(pesoBruto);
					registro.setPliquidomedio(pesoLiquido);
					registro.setVlproduto(valorProduto);
					this.getDao().makePersistent(registro);
					this.getDao().finalizaTransacao();
				}				
			}

			
			// exclus�o
			if (produto.getOperacao().equals("E"))
			{
				if (registro == null)
				{
					stRegistro = "FALHA";
					mensagem = "Produto n�o cadastrado";
				}
				else
				{
					// operações de exclus�o
					if (!this.getDaoSession().getTransaction().isActive())
					{
						this.getDaoSession().getTransaction().begin();
					}

					try
					{
						this.getDaoSession().createSQLQuery("DELETE FROM ijtbproembalagem WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijtbproinspqldetapa WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijtbprousu WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijproqtope WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijTbProCfgEspQld WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijProTempoLimdbQld WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijdeparapro WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJtbPROCGQ WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJtbProDescont WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJmdoALOCMAQ WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJtbPRO WHERE cdproduto = '" + produto.getCdProduto().trim() + "'").executeUpdate();
						
						this.getDaoSession().getTransaction().commit();
						
					}
					catch(Exception ex)
					{	
						this.getDaoSession().getTransaction().rollback();
						
						stRegistro = "FALHA";
						CharSequence msgErroIntegridade = "REFERENCE constraint";
						if (ex.getMessage().contains(msgErroIntegridade))
						{
							stRegistro = "FALHA";
							mensagem = "Erro de integridade referencial. Tabela já vinculada a outras tabelas";
						}
					}
					
				}
			}
		}
		else
		{
			stRegistro = "FALHA";
			mensagem = retornoValidacao;			
		}
		
		retorno.setStRegistro(stRegistro);
		retorno.setMensagem(mensagem);
		return retorno;
	}
		
	public IpcOPRet importarOPIpcInj(IpcOPDTO op)
	{
		BigDecimal TEMPO_SETUP = new BigDecimal(7200);
		IntIpcRegistroOPDTO regOP = new IntIpcRegistroOPDTO();
		IpcOPRet retorno = new IpcOPRet();

		String stRegistro = "OK";
		String mensagem = "";
		String retornoValidacao = validacaoOP(op);
		String strSQL = "";
		
		byte _cdMaquina = 0;
		byte _nrop = 1;
		byte _cdmolde = 2;
		byte _cdestrutura = 3;
		byte _cdProduto = 4;
		byte _qtcavativas= 5;
		byte _ciclopadrao = 6;
		byte _dthriniReal = 7;
		byte _dthrIniPlan = 8;
		byte _dthrFimPlan = 9;
		
		if (retornoValidacao.equals(""))
		{
			MapQuery q = new MapQuery(this.getDao().getSession());
			MapQuery q2 = new MapQuery(this.getDao().getSession());

			q.append("SELECT a");
			q.append("  FROM Ijfilaopsipackchem a");
			q.append(" WHERE a.nropErp = '" + op.getNrOPERP().trim().toUpperCase() + "'");
			q.setMaxResults(1);
			Ijfilaopsipackchem registro = (Ijfilaopsipackchem) q.uniqueResult();

			strSQL = "SELECT a.cdinjetora, a.nrop, p.cdmolde, p.cdestrutura, p.cdproduto, m.qtcavativas, f.ciclopadrao, c.dthrinicioreal, c.dthriniplan, c.dthrfimplan";
			strSQL = strSQL.concat("  FROM ijop a ");
			strSQL = strSQL.concat("  JOIN ijopprodutos p ON (p.nrop = a.nrop) ");
			strSQL = strSQL.concat("  JOIN ijoproteiro b ON (b.nrop = a.nrop) ");
			strSQL = strSQL.concat("  JOIN ijplanop c ON (c.nrop = a.nrop) ");
			strSQL = strSQL.concat("  JOIN ijfictec f ON (f.cdinjetora = a.cdinjetora AND f.cdmolde = a.cdmolde AND f.cdestrutura = a.cdestrutura AND f.dthrfvalcic IS NULL) ");
			strSQL = strSQL.concat("  JOIN ijmolpro m ON (m.cdmolde = f.cdmolde AND m.cdestrutura = f.cdestrutura AND m.cdproduto = p.cdproduto AND m.dthrival = f.dthrivalestru) ");
			strSQL = strSQL.concat(" WHERE b.nropexibicao = '" + op.getNrOPERP().trim().toUpperCase() + "'");
			strSQL = strSQL.concat("   AND ( (c.dthrinicioreal IS NOT NULL AND  c.situacaoplano = 1) OR (c.dthrinicioreal IS NULL) )");			
			List<Object> lista = this.getDaoSession().createSQLQuery(strSQL).list();
			
			Object[] registroOP = null;
			
			if (lista.size() > 0)
			{
				Object registroAuxOP = (Object) lista.get(0);
				registroOP = (Object[]) registroAuxOP;
		
				regOP.setCdMaquina((String) registroOP[_cdMaquina]);
				regOP.setNrop((String) registroOP[_nrop]);
				regOP.setCdMolde((String) registroOP[_cdmolde]);
				regOP.setCdEstrutura((String) registroOP[_cdestrutura]);
				regOP.setCdProduto((String) registroOP[_cdProduto]);
				regOP.setQtCavAtivas(ConversaoTipos.converterParaBigDecimal(registroOP[_qtcavativas]));
				regOP.setCicloPadrao(ConversaoTipos.converterParaBigDecimal(registroOP[_ciclopadrao]));
				regOP.setDthrIniPlan((Date) registroOP[_dthrIniPlan]);
				regOP.setDthrFimPlan((Date) registroOP[_dthrFimPlan]);
				
				if (registroOP[_dthriniReal] != null)
				{
					regOP.setDthrIniReal((Date) registroOP[_dthriniReal]);
				}		
				
			}
			
			
			// inclus�o
			if (op.getOperacao().equals("I"))
			{
				if (registro != null || registroOP != null)
				{
					stRegistro = "FALHA";
					mensagem = "OP já importada";
				}
				else
				{
					// inserir em Ijfilaopsipackchem
					this.getDao().iniciaTransacao();
					
					registro = new Ijfilaopsipackchem();
					registro.setNropErp(op.getNrOPERP().trim().toUpperCase());
					registro.setCdproduto(op.getCdProduto().trim().toUpperCase());
					registro.setQtdplan(new BigDecimal(op.getQtdPlan()));
					registro.setPrioridade(op.getPrioridade());
					registro.setDthrprevtermino(op.getDthrTermino());
					registro.setStregistro(1);
					registro.setDthrregistro(new Date());
					
					this.getDao().makePersistent(registro);
					this.getDao().finalizaTransacao();
				}
			}
			
			
			// altera��oo
			if (op.getOperacao().equals("A"))
			{
				if (registro == null)
				{
					stRegistro = "FALHA";
					mensagem = "OP n�o importada";
				}
				else
				{
					if (regOP.getNrop() != null)
					{
						if (!regOP.getCdProduto().equals(op.getCdProduto().trim().toUpperCase()))
						{
							stRegistro = "FALHA";
							mensagem = "OP já asspcoiada a outro produto";
						}
						else
						{
							// é o mesmo produto ... verificar se é possível alterar o fim planejado
							
							// calcula qto tempo leva pra produzir
							Long qtdCiclos = registro.getQtdplan().divide(regOP.getQtCavAtivas(), 0, BigDecimal.ROUND_HALF_UP).longValue();
							BigDecimal tempoNec = new BigDecimal(qtdCiclos).multiply(regOP.getCicloPadrao());
							tempoNec = tempoNec.add(TEMPO_SETUP); 
							Date dtHrFim = regOP.getDthrIniPlan();
							Date dthrIni = DataHoraRN.somaSegundos(dtHrFim, tempoNec.intValue() * -1);
							
							
							// verificar se coincide com parada programada
							q2 = new MapQuery(this.getDao().getSession());
							q2.append("SELECT a");
							q2.append("  FROM Ijparprog a");
							q2.append(" WHERE a.id.cdinjetora =:cdmaquina");
							q2.append("  AND (   (a.id.dthrinicio BETWEEN :dthrini AND :dthrfim) ");
							q2.append("       OR (a.dthrfinal BETWEEN :dthrini AND :dthrfim) ");
							q2.append("       OR (:dthrini BETWEEN a.id.dthrinicio AND a.dthrfinal)  )"); 
							q2.defineParametro("cdmaquina", regOP.getCdMaquina().toUpperCase());
							q2.defineParametroTimestamp("dthrini", dthrIni);
							q2.defineParametroTimestamp("dthrfim", dtHrFim);
							List<Ijparprog> listaParProg = q2.list();
							
							if (listaParProg.size() > 0)
							{
								q2 = null;
								stRegistro = "FALHA";
								mensagem = "Final planejado calculado coincide com parada programada";									
							}
							else
							{
								// verificar se coincide com outra op planejada para maq ou molde
								q2 = new MapQuery(this.getDao().getSession());
								q2.append("SELECT a");
								q2.append("  FROM Ijplanop a");
								q2.append(" WHERE (a.ijtbinj.cdinjetora = :cdmaquina OR a.ijestmol.ijtbmol.cdmolde =:cdmolde)");
								q2.append("  AND (   (a.id.dthriniplan BETWEEN :dthrini AND :dthrfim) ");
								q2.append("       OR (a.dthrfimplan BETWEEN :dthrini AND :dthrfim) ");
								q2.append("       OR (:dthrini BETWEEN a.id.dthriniplan AND a.dthrfimplan)  )"); 
								q2.append("  AND ( (a.dthrinicioreal IS NOT NULL AND a.situacaoplano  = 1) OR (a.dthrinicioreal IS NULL) )");
								q2.append("  AND a.ijop.nrop <> :nrop");
								q2.defineParametro("nrop", regOP.getNrop().toUpperCase());
								q2.defineParametro("cdmaquina", regOP.getCdMaquina().toUpperCase());
								q2.defineParametro("cdmolde", regOP.getCdMolde().toUpperCase());
								q2.defineParametroTimestamp("dthrini", dthrIni);
								q2.defineParametroTimestamp("dthrfim", dtHrFim);
	
								List<Ijplanop> listaOP = q2.list();
								
								if (listaOP.size() > 0)
								{
									q2 = null;
									stRegistro = "FALHA";
									mensagem = "Final planejado calculado coincide com outra OP da máquina ou do molde";
								}
								else
								{
									// se n�o coincide, altera o fim planejado									
									
									if (!this.getDaoSession().getTransaction().isActive())
									{
										this.getDaoSession().getTransaction().begin();
									}
									
									// altera qtd planejada
									strSQL = "UPDATE ijopprodutos SET qtpecasproduzir = " + op.getQtdPlan().toString() + " WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'";
									this.getDaoSession().createSQLQuery(strSQL).executeUpdate();
	
									
									// verifica se houve altera��oo de fim planejado
									MapQuery q3 = new MapQuery(this.getDao().getSession());
									q3.append("SELECT a");
									q3.append("  FROM Ijintipackchemaltd a");
									q3.append(" WHERE a.nropInjet =:nropinjet");
									q3.append("   AND a.dtfimplan =:dthrfimplan"); 
									q3.defineParametro("nropinjet", regOP.getNrop().toUpperCase());
									q3.defineParametroTimestamp("dthrfimplan", dtHrFim);
									q3.setMaxResults(1);
									Ijintipackchemaltd reg = (Ijintipackchemaltd) q3.uniqueResult();
									
									if (reg == null)
									{										
										// altera fim planejado
										strSQL = "UPDATE ijplanop ";
										strSQL = strSQL.concat(" SET dthriniplan =:novodthriniplan,  ");
										strSQL = strSQL.concat("     dthrfimplan =:novodthrfimplan  ");
										strSQL = strSQL.concat(" WHERE nrop = '" + regOP.getNrop().toUpperCase() + "'");
										strSQL = strSQL.concat("   AND DtHrIniPlan =:dthriniplan");
										
										this.getDaoSession().createSQLQuery(strSQL)
										.setTimestamp("novodthriniplan", dthrIni)
										.setTimestamp("novodthrfimplan", dtHrFim)
										.setTimestamp("dthriniplan", regOP.getDthrIniPlan()) 
										.executeUpdate();
		
																
		
										// sinalizar altera��oo de fim planejado				           
						                strSQL = "INSERT INTO ijIntIpackChemAltD (nropInjet, nropERP, dtfimplan, stregistro, dthrregistro) ";
						                strSQL = strSQL.concat("  VALUES ('" + regOP.getNrop().toUpperCase() + "',");
						                strSQL = strSQL.concat("		  '" + op.getNrOPERP().toUpperCase() + "',");
						                strSQL = strSQL.concat("          :dtfimplan, ");
						                strSQL = strSQL.concat("          1, ");
						                strSQL = strSQL.concat( "         :dthratual)");
						                this.getDaoSession().createSQLQuery(strSQL)
						                .setTimestamp("dtfimplan", dtHrFim)
						                .setTimestamp("dthratual", DataHoraRN.getDataHoraAtual())
						                .executeUpdate();
									}
									this.getDaoSession().getTransaction().commit();
									
									q3 = null;
								}
							}
						}
					}
					else
					{
						// op ainda n�o associada... pode trocar produto e qtd da fila
						
						this.getDao().iniciaTransacao();
						
						registro.setQtdplan(new BigDecimal(op.getQtdPlan()));
						registro.setCdproduto(op.getCdProduto().trim().toUpperCase());
						
						this.getDao().makePersistent(registro);
						this.getDao().finalizaTransacao();													
					}
				}				
			}

			
			// exclus�o
			if (op.getOperacao().equals("E"))
			{
				if (registro == null)
				{
					stRegistro = "FALHA";
					mensagem = "OP n�o importada";
				}
				else
				{
					if(regOP.getNrop() != null)
					{
						
						if (regOP.getDthrIniReal() != null)
						{
							stRegistro = "FALHA";
							mensagem = "OP já iniciada";
						}
						
					}
					
					if (mensagem.equals(""))
					{
						// operações de exclus�o
						if (!this.getDaoSession().getTransaction().isActive())
						{
							this.getDaoSession().getTransaction().begin();
						}
						
						this.getDaoSession().createSQLQuery("DELETE FROM Ijfilaopsipackchem WHERE NROPERP = '" + op.getNrOPERP().trim() + "'").executeUpdate();
						
						this.getDaoSession().createSQLQuery("DELETE FROM IJMDOALOCOP WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijOPProQtOpe WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijoprotoper WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijoproteiro WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJProUltOP WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
												
						this.getDaoSession().createSQLQuery("DELETE FROM IJOPMPRIMA WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJOPProdutos WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJplanOP WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJOPAgrup WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijOPsAgrupProd WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJOPAGRUPADA WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijembapont WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijetqproduto WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM ijetqfaixa WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJOPCGQ WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJOP WHERE nrop = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						
						
						this.getDaoSession().createSQLQuery("DELETE FROM IJproPLANO WHERE NrPLano = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJPLANO WHERE NrPLano = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();

						this.getDaoSession().createSQLQuery("DELETE FROM IJproCARTEIRA WHERE NrCarteira = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();
						this.getDaoSession().createSQLQuery("DELETE FROM IJCarteira WHERE NrCarteira = '" + op.getNrOPERP().trim().toUpperCase() + "'").executeUpdate();

						
						this.getDaoSession().getTransaction().commit();
					}
				}
			}
			
			q = null;
			q2 = null;			
		}
		else
		{
			stRegistro = "FALHA";
			mensagem = retornoValidacao;			
		}
		
		retorno.setStRegistro(stRegistro);
		retorno.setMensagem(mensagem);
		return retorno;
	}
	
	public ListaIntIpackChemListaComAltDataFimPlanDTO getIntIpackChemListaOPsComAltDataFimPlan()
	{
		ListaIntIpackChemListaComAltDataFimPlanDTO retorno = new ListaIntIpackChemListaComAltDataFimPlanDTO();	
		IntIpackChemAlteracaoFimPlanejadoDTO itemRetorno = new IntIpackChemAlteracaoFimPlanejadoDTO();
		
		List<Ijintipackchemaltd> lista = new ArrayList<Ijintipackchemaltd>();

		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT a");
		q.append("  FROM Ijintipackchemaltd a");
		q.append(" WHERE a.stregistro = 1 ");
		lista = q.list();
		
		retorno.setListaOPsComFimPlanAlterado(new ArrayList<IntIpackChemAlteracaoFimPlanejadoDTO>());
		
		
		for (Ijintipackchemaltd registro : lista)
		{
			itemRetorno = new IntIpackChemAlteracaoFimPlanejadoDTO();
			
			itemRetorno.setIdRegistro(registro.getIdregistro());
			itemRetorno.setNropERP(registro.getNropErp());
			itemRetorno.setDtFimPlan(registro.getDtfimplan());
			itemRetorno.setStRegistro(registro.getStregistro());
			itemRetorno.setObsRegistro(registro.getObsregistro());
			itemRetorno.setDthrRegistro(registro.getDthrregistro());
			
			retorno.getListaOPsComFimPlanAlterado().add(itemRetorno);				
		}
				
		return retorno;
		
	}
	
	public IntIpackChemAlteracaoFimPlanejadoDTO setIntIpackChemAltDataFimPlan(Long idRegistro, Integer stRegistro, String obsRegistro)
	{
		IntIpackChemAlteracaoFimPlanejadoDTO retorno = new IntIpackChemAlteracaoFimPlanejadoDTO(); 
		Ijintipackchemaltd registro = this.getDao().findById(Ijintipackchemaltd.class, idRegistro.longValue(), false);
		
		if (registro != null)
		{
			this.getDao().iniciaTransacao();
			
			registro.setStregistro(stRegistro);
			registro.setObsregistro(obsRegistro);
			registro.setDthrregistro(DataHoraRN.getDataHoraAtual());
			
			this.getDao().makePersistent(registro);
			this.getDao().finalizaTransacao();
			
			retorno.setIdRegistro(registro.getIdregistro());
			
			retorno.setNropERP(registro.getNropErp());
			retorno.setDtFimPlan(retorno.getDtFimPlan());
			
			retorno.setStRegistro(registro.getStregistro());
			retorno.setObsRegistro(registro.getObsregistro());
			retorno.setDthrRegistro(registro.getDthrregistro());
		}
		
		return retorno;
	}
	
	public ListaIntIpackChemLiberacaoCertificadoDTO getIntIpackChemListaLiberacaoCertificado()
	{
		ListaIntIpackChemLiberacaoCertificadoDTO retorno = new ListaIntIpackChemLiberacaoCertificadoDTO();
		IntIpackChemCGQLiberadoDTO itemRetorno = new IntIpackChemCGQLiberadoDTO();
		
		List<Ijqldcqipackchem> lista = new ArrayList<Ijqldcqipackchem>();
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		q.append("SELECT a");
		q.append("  FROM Ijqldcqipackchem a");
		q.append(" WHERE a.stregistro = 1 ");
		lista = q.list();
		
		retorno.setListaCertificadosLiberados(new ArrayList<IntIpackChemCGQLiberadoDTO>());
		
		for (Ijqldcqipackchem registro : lista)
		{		
			itemRetorno = new IntIpackChemCGQLiberadoDTO();
			
			itemRetorno.setIdRegistro(registro.getIdregistro());
			itemRetorno.setNropERP(registro.getNropErp());
			itemRetorno.setStRegistro(registro.getStregistro());
			itemRetorno.setObsRegistro(registro.getObsregistro());
			itemRetorno.setDthrRegistro(registro.getDthrregistro());
			
			retorno.getListaCertificadosLiberados().add(itemRetorno);			
		}

		return retorno;
	}
	
	public IntIpackChemCGQLiberadoDTO setIntIpackChemListaLiberacaoCertificado(Long idRegistro, Integer stRegistro, String obsRegistro)
	{
		IntIpackChemCGQLiberadoDTO retorno = new IntIpackChemCGQLiberadoDTO();
		Ijqldcqipackchem registro = this.getDao().findById(Ijqldcqipackchem.class, idRegistro.longValue(), false);
		
		if (registro != null)
		{
			this.getDao().iniciaTransacao();
			
			registro.setStregistro(stRegistro);
			registro.setObsregistro(obsRegistro);
			registro.setDthrregistro(DataHoraRN.getDataHoraAtual());
			
			this.getDao().makePersistent(registro);
			this.getDao().finalizaTransacao();
			
			retorno.setIdRegistro(registro.getIdregistro());
			
			retorno.setNropERP(registro.getNropErp());
			
			retorno.setStRegistro(registro.getStregistro());
			retorno.setObsRegistro(registro.getObsregistro());
			retorno.setDthrRegistro(registro.getDthrregistro());

			
		}		
		
		return retorno;
	}

	public ListaIntIpackChemApontamentosProducaoDTO getIntIpackChemListaApontamentosProducao()
	{
		ListaIntIpackChemApontamentosProducaoDTO retorno = new ListaIntIpackChemApontamentosProducaoDTO();
		IntIpackChemApontamentoProducaoDTO itemRetorno = new IntIpackChemApontamentoProducaoDTO();

		List<Ijintipackchemop> lista = new ArrayList<Ijintipackchemop>();
		
		MapQuery q = new MapQuery(this.getDao().getSession());
		
		
		q.append("SELECT a");
		q.append("  FROM Ijintipackchemop a");
		q.append(" WHERE a.stregistro = 1 ");
		lista = q.list();

		retorno.setListaApontamentosOP(new ArrayList<IntIpackChemApontamentoProducaoDTO>());
		
		for (Ijintipackchemop registro : lista)
		{
			itemRetorno = new IntIpackChemApontamentoProducaoDTO();
			
			itemRetorno.setIdRegistro(registro.getIdregistro());
			itemRetorno.setOrigemApto(registro.getOrigemapto());

			itemRetorno.setNropERP(registro.getNropErp());
			itemRetorno.setDthrEntradaOP(registro.getDthrentradaOp());
			itemRetorno.setDthrSaidaOP(registro.getDthrsaidaOp());
			
			itemRetorno.setQtdProdBruta(registro.getQtdprodbruta());
			itemRetorno.setQtdProdRefugada(registro.getQtdprodrefugada());
			itemRetorno.setQtdProdRefEstorno(registro.getQtdprodrefestorno());
			
			itemRetorno.setStRegistro(registro.getStregistro());
			itemRetorno.setObsRegistro(registro.getObsregistro());
			itemRetorno.setDthrRegistro(registro.getDthrregistro());
			
			retorno.getListaApontamentosOP().add(itemRetorno);
		}
		return retorno;
	}
	
	public IntIpackChemApontamentoProducaoDTO setIntIpackChemListaApontamentosProducao(Long idRegistro, Integer stRegistro, String obsRegistro)
	{
		IntIpackChemApontamentoProducaoDTO retorno = new IntIpackChemApontamentoProducaoDTO();
		Ijintipackchemop registro = this.getDao().findById(Ijintipackchemop.class, idRegistro, false);
		
		if (registro != null)
		{
			this.getDao().iniciaTransacao();
			
			registro.setStregistro(stRegistro);
			registro.setObsregistro(obsRegistro);
			registro.setDthrregistro(DataHoraRN.getDataHoraAtual());
			
			this.getDao().makePersistent(registro);
			this.getDao().finalizaTransacao();
			
			retorno.setIdRegistro(registro.getIdregistro());
			
			retorno.setNropERP(registro.getNropErp());
			retorno.setOrigemApto(registro.getOrigemapto());
			retorno.setDthrEntradaOP(registro.getDthrentradaOp());
			retorno.setDthrSaidaOP(registro.getDthrsaidaOp());
			
			retorno.setQtdProdBruta(registro.getQtdprodbruta());
			retorno.setQtdProdRefugada(registro.getQtdprodrefugada());
			retorno.setQtdProdRefEstorno(registro.getQtdprodrefestorno());
			
			retorno.setStRegistro(registro.getStregistro());
			retorno.setObsRegistro(registro.getObsregistro());
			retorno.setDthrRegistro(registro.getDthrregistro());
			
		}
		
		return retorno;
	}
	
	public String getIntIpackChemCdMaquina(String nropERP)
	{
		String maquina;
		String strSQL = "";
		strSQL = "SELECT c.cdinjestendido";
		strSQL = strSQL.concat("  FROM ijIntIpackChemAltD a, ijop b, ijtbinj c ");
		strSQL = strSQL.concat(" WHERE a.nropERP = '" +  nropERP.trim()  + "'");
		strSQL = strSQL.concat("   AND b.nrop = a.nropInjet");
		strSQL = strSQL.concat("   AND c.cdinjetora = b.cdinjetora");			
		maquina = (String) this.getDaoSession().createSQLQuery(strSQL).setMaxResults(1).uniqueResult();
		
		return maquina;
	}
}
