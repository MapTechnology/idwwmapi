package ms.model.rn.coletaComAndon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ms.coleta.dto.IndicadoresColetaGraficoInjetDTO;
import ms.coleta.dto.IntervaloTempoInjetDTO;
import ms.coleta.dto.ItemGraficoOEEHoraHoraInjetDTO;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimestampType;

import idw.model.dao.injet.DAOGenericoInjet;
import idw.model.excessoes.SemCalendarioException;
import idw.model.rn.AbstractRN;
import idw.model.rn.DataHoraRN;
import idw.model.rn.injet.FuncoesApoioInjet;
import idw.model.rn.injet.TurnoInjetDTO;
import idw.util.FormulasInjet;
import idw.webservices.dto.ConsolidadoHoraInjetDTO;

@SuppressWarnings("unchecked")
public class ColetaGraficoRN extends AbstractRN<DAOGenericoInjet>  {

	public ColetaGraficoRN(DAOGenericoInjet dao) {
		super(dao);
	}
	
	public IndicadoresColetaGraficoInjetDTO getGraficoOEEHoraHora(String cdMaquina, Date dthrAtual)
	{
		
		String hql;
		Date dthriniTur;
		Date dthrfimTur;
		TurnoInjetDTO turnoAtual = new TurnoInjetDTO();
		List<ConsolidadoHoraInjetDTO> listaRegistros = new ArrayList<ConsolidadoHoraInjetDTO>();
		List<IntervaloTempoInjetDTO> listaHoras = new ArrayList<IntervaloTempoInjetDTO>();
		IndicadoresColetaGraficoInjetDTO retorno = new IndicadoresColetaGraficoInjetDTO();
		ItemGraficoOEEHoraHoraInjetDTO itemGrafico = new ItemGraficoOEEHoraHoraInjetDTO();
		

		Double cicloMedio = 0d;
		Double cicloPadrao = 0d;
		Double efiCiclo = 0d;
		
		Double segCicNormal = 0d;
		Double qtdCicNormal= 0d;
		Double producao = 0d;

		Double segCicFinPar = 0d;
		Double segParSemPeso = 0d;
		Double segParComPeso = 0d;
				
		Double segRefugos = 0d;
		Double segRitmo = 0d;
		Double segPCI = 0d;
		
		Double producaoAcum = 0d;
		Double segCicNormalAcum = 0d;
		Double qtdCicNormalAcum = 0d;

		Double segCicFinParAcum = 0d;
		Double segParSemPesoAcum = 0d;
		Double segParComPesoAcum = 0d;
		Double segRefugosAcum = 0d;
		Double segRitmoAcum = 0d;
		Double segPCIAcum = 0d;

		Double segProdutivas = 0d;
		Double segDisponiveis = 0d;
		Double oee = 0d;
		Double meta = 0d;
		
		Integer ordemhora = 0;
		
		String nrop = "";
		
		
		try 
		{
			// recupera data de referencia e turnos atual
			turnoAtual = FuncoesApoioInjet.encontraTurno(this.getDao(), dthrAtual);
			
			// recupera início e fim do turno
			dthriniTur = FuncoesApoioInjet.calcularInicioTurno(this.getDao(), turnoAtual.getDtReferencia(), turnoAtual.getIjtbtur().getCdturno());
			dthrfimTur = FuncoesApoioInjet.calcularFimTurno(this.getDao(), turnoAtual.getDtReferencia(), turnoAtual.getIjtbtur().getCdturno());
			
			// recupera intervalos de hora que façam interseção com o turno
			listaHoras = FuncoesApoioInjet.horasPeriodo(this.getDao(), dthriniTur, dthrfimTur);
			
			// adicionar itens a lista de retorno
			retorno.setListaHoras(new ArrayList<ItemGraficoOEEHoraHoraInjetDTO>());
			ordemhora = 0;
			for (IntervaloTempoInjetDTO hora : listaHoras)
			{
				ordemhora += 1;
				itemGrafico = new ItemGraficoOEEHoraHoraInjetDTO();
				itemGrafico.setMeta(100d);
				itemGrafico.setOee(oee);
				itemGrafico.setOeeAcumulado(oee);
				itemGrafico.setOrdemhora(ordemhora);
				itemGrafico.setIntervalo(hora);
					
				retorno.getListaHoras().add(itemGrafico);
			}
			

			// recuperar registros para cálculo dos indicadores
			hql = "SELECT a.cdinjetora, a.nrop, a.cdmolde, a.cdestrutura, a.dthrivalestru, a.dthrivalcic, ";
			hql = hql.concat("c.ciclopadrao, e.qtcavidades, e.qtcavativas, ");
			hql = hql.concat("a.dthriniintervalo, a.dthrfimintervalo, ");
			hql = hql.concat("a.tmpcicnormal, a.ctcp,  ");
			hql = hql.concat("a.tmpcicfinparada, a.ctci,  ");
			hql = hql.concat("a.tmpparadas,  ");
			hql = hql.concat("a.tmpparadassempeso, "); 
			hql = hql.concat("a.qtinjnormal,  ");
			hql = hql.concat("a.qtinjnaparada, "); 
			hql = hql.concat("a.cta,  ");
			hql = hql.concat("a.ctt, ");
			hql = hql.concat("(SELECT SUM(r.qtPcsRef) as qtpcsref ");
			hql = hql.concat(" FROM ijcnsutdetref r, ijmolpro m ");
			hql = hql.concat(" WHERE r.dthriniintervalo = a.dthriniintervalo ");
			hql = hql.concat("   AND r.cdinjetora = a.cdinjetora ");
			hql = hql.concat("   AND r.nrop = a.nrop ");
			hql = hql.concat("   AND r.cdmolde = a.cdmolde ");
			hql = hql.concat("   AND r.cdestrutura = a.cdestrutura ");
			hql = hql.concat("   AND r.dthrivalestru = a.dthrivalestru ");
			hql = hql.concat("   AND m.cdmolde = r.cdmolde ");
			hql = hql.concat("   AND m.cdestrutura = r.cdestrutura ");
			hql = hql.concat("   AND m.dthrival = r.dthrivalestru ");
			hql = hql.concat("   AND m.cdidentificacao = r.cdidentificacao) as qtPcsRef,  ");
			hql = hql.concat("   (SELECT DISTINCT r.nropexibicao FROM ijoproteiro r WHERE r.nrop = a.nrop) as nropexibicao ");
			hql = hql.concat("  FROM ijcnsut a, ijtbinj b, ijfictec c, ");
			hql = hql.concat("      (SELECT cdmolde, cdestrutura, dthrival FROM ijmolpro WHERE dthrfval is null) d, ");
			hql = hql.concat("      cavidades2 e ");
			hql = hql.concat(" WHERE c.cdinjetora = b.cdinjetora ");
			hql = hql.concat("  AND c.cdmolde = b.cdmoldeatual ");
			hql = hql.concat("  AND c.cdestrutura = b.cdestruturaatual ");
			hql = hql.concat("  AND c.dthrfvalcic IS NULL ");
			hql = hql.concat("  AND d.cdmolde = b.cdmoldeatual ");
			hql = hql.concat("  AND d.cdestrutura = b.cdestruturaatual ");
			hql = hql.concat("  AND a.cdinjetora = b.cdinjetora ");
			hql = hql.concat("  AND a.nrop = b.opatual ");
			hql = hql.concat("  AND a.cdmolde = b.cdmoldeatual ");
			hql = hql.concat("  AND a.cdestrutura = b.cdestruturaatual ");
			hql = hql.concat("  AND a.dthrivalestru = d.dthrival ");
			hql = hql.concat("  AND a.dthrivalcic = c.dthrivalcic ");
			hql = hql.concat("  AND a.dthriniintervalo between ':dthrini' AND ':dthrfim' ");
			hql = hql.concat("  AND b.cdinjetora = ':cdmaq' ");
			hql = hql.concat("  AND e.cdmolde = d.cdmolde ");
			hql = hql.concat("  AND e.cdestrutura = d.cdestrutura ");
			hql = hql.concat("  AND e.dthrival = d.dthrival ");
			hql = hql.concat("ORDER BY a.dthriniintervalo");
			
			hql = hql.replaceAll(":dthrini", DataHoraRN.dateToStringYYYYMMDDHHMMSS(listaHoras.get(0).getDtHrIniPeriodo()));
			hql = hql.replaceAll(":dthrfim", DataHoraRN.dateToStringYYYYMMDDHHMMSS(listaHoras.get(listaHoras.size()-1).getDtHrFimPeriodo()));
			hql = hql.replaceAll(":cdmaq", cdMaquina);
			
			
			Query q = this.getDao().getSession().createSQLQuery(hql)
					.addScalar("cdinjetora", StringType.INSTANCE)
					.addScalar("nrop", StringType.INSTANCE)
					.addScalar("cdmolde", StringType.INSTANCE)
					.addScalar("cdestrutura", StringType.INSTANCE)
					.addScalar("dthrivalestru", TimestampType.INSTANCE)
					.addScalar("dthrivalcic", TimestampType.INSTANCE)
					.addScalar("ciclopadrao", DoubleType.INSTANCE)
					.addScalar("qtcavidades", DoubleType.INSTANCE)
					.addScalar("qtcavativas", DoubleType.INSTANCE)
					.addScalar("dthriniintervalo", TimestampType.INSTANCE)
					.addScalar("dthrfimintervalo", TimestampType.INSTANCE)
					.addScalar("tmpcicnormal", DoubleType.INSTANCE)
					.addScalar("ctcp", DoubleType.INSTANCE)
					.addScalar("tmpcicfinparada", DoubleType.INSTANCE)
					.addScalar("ctci", DoubleType.INSTANCE)
					.addScalar("tmpparadas", DoubleType.INSTANCE)
					.addScalar("tmpparadassempeso", DoubleType.INSTANCE)
					.addScalar("qtinjnormal", DoubleType.INSTANCE)
					.addScalar("qtinjnaparada", DoubleType.INSTANCE)
					.addScalar("cta", DoubleType.INSTANCE)
					.addScalar("ctt", DoubleType.INSTANCE)
					.addScalar("qtpcsref", DoubleType.INSTANCE)		
					.addScalar("nropexibicao", StringType.INSTANCE)
					.setResultTransformer(Transformers.aliasToBean(ConsolidadoHoraInjetDTO.class));
							
			try
			{
				listaRegistros = q.list();
				segCicNormalAcum = 0d;
				qtdCicNormalAcum = 0d;
				for (ConsolidadoHoraInjetDTO itemlista : listaRegistros)
				{
					// número da op
					nrop = itemlista.getNropexibicao().trim();
					
					// ciclos normais
					segCicNormal = itemlista.getTmpcicnormal();
					if (itemlista.getCtcp() != null)
					{
						segCicNormal += itemlista.getCtcp();
					}
					qtdCicNormal = itemlista.getQtinjnormal();
					
					
					// ciclo finalizado por parada
					segCicFinPar = itemlista.getTmpcicfinparada();
					if (itemlista.getCtci() != null)
					{
						segCicFinPar += itemlista.getCtci();
					}

					
					// ciclo padrão, ciclo médio e eficiência de ciclo
					cicloPadrao = itemlista.getCiclopadrao();
					cicloMedio = FormulasInjet.calcularCicloMedio(BigDecimal.valueOf(segCicNormal), BigDecimal.valueOf(qtdCicNormal)).doubleValue();
					
					// produção líquida
					producao = qtdCicNormal * itemlista.getQtcavativas();
					if (itemlista.getQtpcsref() != null)
					{
						producao  = producao - itemlista.getQtpcsref(); 

						// refugos convertidos para segundos
						segRefugos =  FormulasInjet.calcularTempoRefugo(BigDecimal.valueOf(itemlista.getQtpcsref()), BigDecimal.valueOf(cicloMedio), BigDecimal.valueOf(itemlista.getQtcavativas())).doubleValue();
					}
					else
					{
						segRefugos = 0d;
					}
					
					
					// perdas por cavidades inativas converidas para segundos
					segPCI = FormulasInjet.calcularCavidadesInativaSeg(BigDecimal.valueOf(itemlista.getQtcavidades()), BigDecimal.valueOf(itemlista.getQtcavativas()),  BigDecimal.valueOf(segCicNormal)).doubleValue();
					
					
					// ritmo
					segRitmo = FormulasInjet.calcularRitmo(BigDecimal.valueOf(segCicNormal), BigDecimal.valueOf(qtdCicNormal), BigDecimal.valueOf(cicloPadrao), BigDecimal.ZERO, BigDecimal.ZERO).doubleValue();
					
					
					// paradas
					segParComPeso = itemlista.getTmpparadas();
					segParSemPeso = itemlista.getTmpparadassempeso();
					
					
					// indicadores				
					segProdutivas = FormulasInjet.calcularTempoprodutivas(BigDecimal.valueOf(segCicNormal - segRefugos) , BigDecimal.valueOf(segPCI), BigDecimal.valueOf(segRitmo)).doubleValue();
					segDisponiveis = FormulasInjet.calcularTempoAtivo(BigDecimal.valueOf(segCicNormal), BigDecimal.valueOf(segParComPeso), BigDecimal.valueOf(segCicFinPar), BigDecimal.ZERO, BigDecimal.ZERO).doubleValue();
					
					efiCiclo = FormulasInjet.calcularEficienciaCiclo(BigDecimal.valueOf(cicloPadrao), BigDecimal.valueOf(cicloMedio)).doubleValue();
					oee = FormulasInjet.calcularOEE(BigDecimal.valueOf(segProdutivas), BigDecimal.valueOf(segDisponiveis)).doubleValue();
					
					
					// acumula
					segCicNormalAcum += segCicNormal;
					segCicFinParAcum += segCicFinPar;
					segRefugosAcum += segRefugos;
					segPCIAcum += segPCI;
					segRitmoAcum += segRitmo;
					segParComPesoAcum += segParComPeso;
					segParSemPesoAcum += segParSemPeso;
					
					qtdCicNormalAcum += qtdCicNormal;
					producaoAcum += producao;
					
					
					// identificar hora e atualizar
					for (ItemGraficoOEEHoraHoraInjetDTO hora : retorno.getListaHoras())
					{
						if (hora.getIntervalo().getDtHrIniPeriodo().compareTo(itemlista.getDthriniintervalo()) == 0)
						{
							// atualiza e sai do loop
							hora.setOee(oee);
							break;							
						}
					}

					
				}
			}
		    catch (Exception e) 
		    {
				e.printStackTrace();
			}
			
			
		} 
		catch (SemCalendarioException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// calcular indicadores e oee acumulado das horas
		if ( nrop != "" )
		{
		
			cicloMedio = FormulasInjet.calcularCicloMedio(BigDecimal.valueOf(segCicNormalAcum), BigDecimal.valueOf(qtdCicNormalAcum)).doubleValue();
			efiCiclo = FormulasInjet.calcularEficienciaCiclo(BigDecimal.valueOf(cicloPadrao), BigDecimal.valueOf(cicloMedio)).doubleValue();
			segProdutivas = FormulasInjet.calcularTempoprodutivas(BigDecimal.valueOf(segCicNormalAcum - segRefugosAcum) , BigDecimal.valueOf(segPCIAcum), BigDecimal.valueOf(segRitmoAcum)).doubleValue();
			segDisponiveis = FormulasInjet.calcularTempoAtivo(BigDecimal.valueOf(segCicNormalAcum), BigDecimal.valueOf(segParComPesoAcum), BigDecimal.valueOf(segCicFinParAcum), BigDecimal.ZERO, BigDecimal.ZERO).doubleValue();
			oee = FormulasInjet.calcularOEE(BigDecimal.valueOf(segProdutivas), BigDecimal.valueOf(segDisponiveis)).doubleValue();
			
			retorno.setCicloMedio(cicloMedio);
			retorno.setCicloPadrao(cicloPadrao);
			retorno.setEfiCiclo(efiCiclo);
			retorno.setMeta(100d);
			retorno.setNrOP(nrop);
			retorno.setOEE(oee);
			retorno.setProducaoLiquida(producaoAcum);
			
			oee = 0d;
			meta = 0d;
			for (ItemGraficoOEEHoraHoraInjetDTO hora : retorno.getListaHoras())
			{
				oee += hora.getOee();
				meta += 100;
				hora.setOeeAcumulado(oee);
				hora.setMeta(meta);
			}
		}		
		
		return retorno;
	}
	
}
