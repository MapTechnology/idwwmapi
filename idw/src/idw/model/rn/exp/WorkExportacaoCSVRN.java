package idw.model.rn.exp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.jdbc.Work;

import idw.model.pojos.DwNserie;
import idw.model.pojos.DwPassagem;
import idw.model.pojos.DwPasscau;
import idw.model.pojos.DwTDefeito;
import idw.model.pojos.OmProduto;
import idw.model.pojos.OmProgrp;
import idw.model.rn.DataHoraRN;
import idw.webservices.dto.FiltroRelDTO;
import idw.webservices.dto.RelIndTesteFinalDTO;
import idw.webservices.dto.SerieParettoDTO;
import idw.webservices.dto.SerieTaxaFalhaDTO;
import ms.util.ConversaoTipos;
import ms.util.UtilsThreads;

public class WorkExportacaoCSVRN implements Work{
	private StringBuilder sql;
	private StringBuilder listaPlataformas;
	private FiltroRelDTO filtro;
	private int iListaPlataforma;
	private RelIndTesteFinalDTO retorno;
	private StringBuilder descricao;

	
	public WorkExportacaoCSVRN(StringBuilder sql, FiltroRelDTO filtro, StringBuilder listaPlataformas, int iListaPlataforma, RelIndTesteFinalDTO retorno) {
		this.sql = sql;
		this.filtro = filtro;
		this.listaPlataformas = listaPlataformas;
		this.iListaPlataforma = iListaPlataforma;
		this.retorno = retorno;
	}

	@Override
	public void execute(Connection connection) throws SQLException {
		PreparedStatement  ps = null;
		
		try {
			ps = connection.prepareStatement(sql.toString(), ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			
			if (filtro.getDataInicial() != null && filtro.getDataFinal() != null){
				ps.setTimestamp(1, new Timestamp(filtro.getDataInicial().getTime()));
				ps.setTimestamp(2, new Timestamp(DataHoraRN.setHoraNaData(filtro.getDataFinal(), 23, 59, 59).getTime() ) );
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (listaPlataformas != null){
			try {
				ps.setString(iListaPlataforma, listaPlataformas.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ResultSet rs = null;
		
		try {
			rs = ps.executeQuery();
	
			retorno.setTaxas(new ArrayList<SerieTaxaFalhaDTO>());
			retorno.setParettos(new ArrayList<SerieParettoDTO>());
			Date inicioPeriodo = null;
			Date fimPeriodo = null;
			List<String> nrSeries = null;
			List<String> nrSeriesComFalha = null;
			int qtdeFalhas = 0;
	
			nrSeries = new ArrayList<String>();
			nrSeriesComFalha = new ArrayList<String>();

			if (rs != null ) {
				Boolean isSair = false;
				Boolean isEntrouLoop = false;
				isSair = !rs.next(); // executa a 1a vez
				DwPassagem dwPassagem = null;
				
				while (isSair == false /*rs.next()*/){
					isEntrouLoop = true;
					dwPassagem = new DwPassagem();
					
					isSair = transformaRsParaDwPassagem(dwPassagem, rs, isSair);
					
					if (pertenceFiltro(dwPassagem, filtro) == false)
						continue;
					
					if (inicioPeriodo == null) {
						inicioPeriodo = dwPassagem.getDthr();
						if (filtro.getDataInicial() == null)
							filtro.setDataInicial(inicioPeriodo);
						if (filtro.getDataFinal() == null)
							filtro.setDataFinal(DataHoraRN.getDataHoraAtual());
					}
	
					Calendar dthr = Calendar.getInstance();
					dthr.setTime(dwPassagem.getDthr());
					descricao = new StringBuilder();
					if (periodoFechou(inicioPeriodo, dthr.getTime(), filtro.getAgrupamento())){
						SerieTaxaFalhaDTO taxa = new SerieTaxaFalhaDTO();
						taxa.setInicioIndice(inicioPeriodo);
						taxa.setFimIndice(fimPeriodo);
						taxa.setProducaoBruta(BigDecimal.valueOf(nrSeries.size()));
						taxa.setQtdeFalhas(BigDecimal.valueOf(nrSeriesComFalha.size()));
						taxa.setDescricao(descricao.toString());
	
						Double indiceFalha = (Double.valueOf(nrSeriesComFalha.size()) / nrSeries.size()) * 100;
						indiceFalha = ConversaoTipos.converteParaDouble(indiceFalha, 2);
						taxa.setIndiceFalha(indiceFalha);
	
						if (retorno.getPiorIndice() == null || indiceFalha < retorno.getPiorIndice() && indiceFalha != 0){
							retorno.setPiorIndice(indiceFalha);
						}
	
						if (retorno.getMelhorIndice() == null || indiceFalha > retorno.getMelhorIndice()){
							retorno.setMelhorIndice(indiceFalha);
						}
	
						// O if abaixo foi comentado pq o select esta filtrando pelas datas
//						if (periodoEscolhido(filtro.getDataInicial(), filtro.getDataFinal(), DataHoraRN.getDataSemHOra(inicioPeriodo), 
//								DataHoraRN.getDataSemHOra(fimPeriodo))){
							if (pertenceFiltro(dwPassagem, filtro)){
								retorno.getTaxas().add(taxa);
								
								// Adiciona a descricao da plataforma no retorno
								String plata = dwPassagem.getDwNserie().getOmProduto().getOmProgrp().getDsProgrp();
								if (retorno.getPlataformasSelecionadas().contains(plata) == false)
									retorno.getPlataformasSelecionadas().add(plata);
									
							}
//						}
	
						
						inicioPeriodo = dwPassagem.getDthr();
						nrSeries = new ArrayList<String>();
						nrSeriesComFalha = new ArrayList<String>();
						qtdeFalhas = 0;
	
					}
					
					if (!DataHoraRN.before(DataHoraRN.getDataSemHora(dwPassagem.getDthr()), filtro.getDataInicial()) && !DataHoraRN.after(DataHoraRN.getDataSemHora(dwPassagem.getDthr()), filtro.getDataFinal()) ){
						if (pertenceFiltro(dwPassagem, filtro)){
							// Monta paretto para reprocesso
							for (DwPasscau dwPasscau : dwPassagem.getDwPasscaus()){
								String elemento = "";
								//defeito
								if (filtro.getApontamento() == 1){
									elemento = dwPasscau.getDwTDefeito().getDsTdefeito();
									//componente
								}else if (filtro.getApontamento() == 2){
									try{
										elemento = dwPasscau.getOmProduto().getDsProduto();
									}catch (Exception e){	
										elemento = "Não definido";
									}						
								}
								addParetto(elemento, retorno.getParettos());
								
								elemento = null;
							}
						}
					}
	
	
					addNrSerie(dwPassagem.getDwNserie().getNs(), nrSeries, nrSeriesComFalha, dwPassagem, qtdeFalhas);
	//				qtdeFalhas += getQtdFalhas(dwPassagem);
					fimPeriodo = dthr.getTime();
										
					UtilsThreads.pausaNaThread(10l);
				}
				
				if (isEntrouLoop == true){
					SerieTaxaFalhaDTO taxa = new SerieTaxaFalhaDTO();
					taxa.setInicioIndice(inicioPeriodo);
					taxa.setFimIndice(fimPeriodo);
					taxa.setProducaoBruta(BigDecimal.valueOf(nrSeries.size()));
					taxa.setQtdeFalhas(BigDecimal.valueOf(nrSeriesComFalha.size()));
					if (descricao == null)
						descricao = new StringBuilder();
					
					taxa.setDescricao(descricao.toString());

					Double indiceFalha = (Double.valueOf(nrSeriesComFalha.size()) / nrSeries.size()) * 100;
					indiceFalha = ConversaoTipos.converteParaDouble(indiceFalha, 2);
					taxa.setIndiceFalha(indiceFalha);

					if (retorno.getPiorIndice() == null || indiceFalha < retorno.getPiorIndice() && indiceFalha != 0){
						retorno.setPiorIndice(indiceFalha);
					}

					if (retorno.getMelhorIndice() == null || indiceFalha > retorno.getMelhorIndice()){
						retorno.setMelhorIndice(indiceFalha);
					}

					// O if abaixo foi comentado pq o select esta filtrando pelas datas
//					if (periodoEscolhido(filtro.getDataInicial(), filtro.getDataFinal(), DataHoraRN.getDataSemHOra(inicioPeriodo), 
//							DataHoraRN.getDataSemHOra(fimPeriodo))){
						if (pertenceFiltro(dwPassagem, filtro)){
							retorno.getTaxas().add(taxa);
							
							// Adiciona a descricao da plataforma no retorno
							String plata = dwPassagem.getDwNserie().getOmProduto().getOmProgrp().getDsProgrp();
							if (retorno.getPlataformasSelecionadas().contains(plata) == false)
								retorno.getPlataformasSelecionadas().add(plata);
								
						}
//					}

					
					inicioPeriodo = null;
					nrSeries = new ArrayList<String>();
					nrSeriesComFalha = new ArrayList<String>();
					qtdeFalhas = 0;

				}
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}


	private boolean periodoFechou(Date data1, Date data2, int agrupamento){
		StringBuilder valor1 = new StringBuilder();
		StringBuilder valor2 = new StringBuilder();
		Calendar cdata1 = Calendar.getInstance();
		cdata1.setTime(data1);
		Calendar cdata2 = Calendar.getInstance();
		cdata2.setTime(data2);
		//di�rio
		if (agrupamento == 1){			
			valor1.append(String.valueOf(cdata1.get(Calendar.DAY_OF_YEAR)));					 
			valor2.append(String.valueOf(cdata2.get(Calendar.DAY_OF_YEAR)));
			SimpleDateFormat f = new SimpleDateFormat("dd/MMM/yy");
			descricao.append(f.format(data1));
			//semanal
		}else if (agrupamento == 2){
			valor1.append(String.valueOf(cdata1.get(Calendar.WEEK_OF_YEAR)));
			valor2.append(String.valueOf(cdata2.get(Calendar.WEEK_OF_YEAR)));				
			descricao.append(valor1);
			descricao.append("/");
			descricao.append(String.valueOf(cdata1.get(Calendar.YEAR)));
			//mensal
		}else if (agrupamento == 3){			
			valor1.append(String.valueOf(cdata1.get(Calendar.MONTH)));
			valor2.append(String.valueOf(cdata2.get(Calendar.MONTH)));
			SimpleDateFormat f = new SimpleDateFormat("MMM/yy");
			descricao.append(f.format(data1));
		}else{
			descricao.append(String.valueOf(cdata1.get(Calendar.YEAR)));
		}
		//anual
		valor1.append(String.valueOf(cdata1.get(Calendar.YEAR)));
		valor2.append(String.valueOf(cdata2.get(Calendar.YEAR)));

		boolean isRetorno = !valor1.toString().equals(valor2.toString());
		
		valor1 = null;
		valor2 = null;
		
		return isRetorno;
	}
	
	private boolean pertenceFiltro(DwPassagem dwPassagem, FiltroRelDTO filtro){
		boolean pertence = true;

		try {
			boolean plataformaOK = false;
			//todas as plataformas
			if ((filtro.getPlataformas().size()== 1 && filtro.getPlataformas().get(0) == null) || (filtro.getPlataformas().size()== 1 && filtro.getPlataformas().get(0).getIdProgrp()==-1)){
				plataformaOK = true;
			}else{
				for (OmProgrp omProgrp : filtro.getPlataformas()){
					if (omProgrp.getCdProgrp().equals(dwPassagem.getDwNserie().getOmProduto().getOmProgrp().getCdProgrp())){
						plataformaOK = true;
						break;
					}
				}
			}
			if (!plataformaOK){
				pertence = false;
			}
		} catch (Exception e) {
			pertence = false;
		}
		return pertence;
	}

	private int addNrSerie(String nrSerie, List<String> nrSeries, List<String> nrSeriesComFalha, DwPassagem dwpassagem, int qtdFalhas){
		boolean existe = false;
		for (String item : nrSeries){
			if (nrSerie.equals(item)){
				existe = true;
				break;
			}
		}
		if (!existe){
			nrSeries.add(nrSerie);
		}
		if (dwpassagem.getStNserie() == (byte) 0){
			existe = false;
			for (String item : nrSeriesComFalha){
				if (nrSerie.equals(item)){
					existe = true;
					break;
				}
			}
			if (!existe){
				nrSeriesComFalha.add(nrSerie);
				qtdFalhas++;
			}
		}
		return qtdFalhas;
	}

	private void addParetto(String elemento, List<SerieParettoDTO> parettos){
		boolean existe = false;
		for (SerieParettoDTO item : parettos){
			if (elemento.equals(item.getElemento())){
				item.setQtdeApontamento(item.getQtdeApontamento() + 1);
				existe = true;
				break;
			}
		}
		if (!existe){
			SerieParettoDTO paretto = new SerieParettoDTO();
			paretto.setElemento(elemento);
			paretto.setQtdeApontamento(1d);
			parettos.add(paretto);
		}
	}
	
	/*
	private boolean periodoEscolhido(Date dataInicio, Date dataFinal, Date dataInicioPeriodo, Date dataFinalPeriodo){
		boolean pertence = true;
		if (dataInicioPeriodo.getTime() < dataInicio.getTime() || dataInicioPeriodo.getTime() > dataFinal.getTime()){
			pertence = false;
		}
		if (dataFinalPeriodo.getTime() < dataInicio.getTime() || dataFinalPeriodo.getTime() > dataFinal.getTime()){
			pertence = false;
		}

		return pertence;
	}*/

	private boolean transformaRsParaDwPassagem(DwPassagem dwpassagem, ResultSet rs, Boolean isSair) throws SQLException{
		dwpassagem.setDthr(rs.getTimestamp("dthr"));
		dwpassagem.setDthrInicio(rs.getTimestamp("dthr_inicio"));
		dwpassagem.setStNserie(rs.getByte("st_nserie"));
		dwpassagem.setSegCiclo(rs.getBigDecimal("seg_ciclo"));
		dwpassagem.setMsDthrinicio(rs.getInt("ms_dthrinicio"));
		dwpassagem.setMsDthr(rs.getInt("ms_dthr"));
		dwpassagem.setIdPassagem(rs.getLong("id_passagem"));
		dwpassagem.setIsTfFinalizado(rs.getBoolean("is_tf_finalizado"));
		
		DwNserie dwnserie = new DwNserie();
		dwnserie.setCb(rs.getString("cb"));
		dwnserie.setIdNserie(rs.getLong("id_nserie"));
		dwnserie.setNs(rs.getString("ns"));
		
		OmProduto omproduto = new OmProduto();
		omproduto.setCdProduto(rs.getString("cd_produto"));
		omproduto.setIdProduto(rs.getLong("id_produto"));
		
		OmProgrp omprogrp = new OmProgrp();
		omprogrp.setIdProgrp(rs.getLong("id_progrp"));
		omprogrp.setCdProgrp(rs.getString("cd_progrp"));
		omprogrp.setDsProgrp(rs.getString("ds_progrp"));
		omproduto.setOmProgrp(omprogrp);
		
		dwnserie.setOmProduto(omproduto);
		
		dwpassagem.setDwNserie(dwnserie);
		
		// interage no resultset para montagem dos DwPasscaus
		dwpassagem.setDwPasscaus(new HashSet<DwPasscau>());
		
		boolean isFimArquivo = true;
		do {
			// Se for outra passagem entao sair do loop
			if (rs.getLong("id_passagem") != dwpassagem.getIdPassagem()) {
				isFimArquivo = false;
				break;
			}
			
			if (rs.getLong("id_tdefeito") == 0)
				continue;
			
			DwTDefeito dwtdefeito = new DwTDefeito();
			dwtdefeito.setCdTdefeito(rs.getString("cd_tdefeito"));
			dwtdefeito.setDsTdefeito(rs.getString("ds_tdefeito"));
			dwtdefeito.setIdTdefeito(rs.getLong("id_tdefeito"));
			
			OmProduto omprodutoPasscau = new OmProduto();
			omprodutoPasscau.setCdProduto(rs.getString("cd_produto_dwpasscau"));
			omprodutoPasscau.setDsProduto(rs.getString("ds_produto_dwpasscau"));
						
			DwPasscau dwPasscau = new DwPasscau();
			dwPasscau.setDwTDefeito(dwtdefeito);
			dwPasscau.setOmProduto(omprodutoPasscau);
			
			dwpassagem.getDwPasscaus().add(dwPasscau);
			
			UtilsThreads.pausaNaThread(10l);
			
		} while (rs.next());

		isSair = isFimArquivo; // faz com que o loop principal finalize
		
		return isSair;
	}
}
