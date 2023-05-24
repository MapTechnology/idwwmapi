<%@page import="java.util.List"%>

<%
	
	String dtInicial = request.getParameter("dtinicial");
	String dtFinal = request.getParameter("dtfinal");
	String[] plataformasSel = request.getParameterValues("plataformasSel");
	String agrupamento = request.getParameter("agrupamento");
	String apontamento = request.getParameter("apontamento");
	String dsAgrupamento = "";
	String dsApontamento = "";
	String graphURLTime1 = "";
	String graphURLTime2 = "";	

	FiltroRelDTO filtro = new FiltroRelDTO();
	
	SimpleDateFormat formatterString = new SimpleDateFormat("dd/MM/yyyy");
	
	try{
		filtro.setDataInicial(formatterString.parse(dtInicial));
	}catch(Exception e){		
	}
	try{
		filtro.setDataFinal(formatterString.parse(dtFinal));
	}catch(Exception e){		
	}
	
	StringBuilder s = new StringBuilder();
	if (plataformasSel != null && plataformasSel.length > 0){
		List<OmProgrp> listaPlataformas = new ArrayList<OmProgrp>();
		if (plataformasSel[0].equals("TODAS AS PLATAFORMAS")){
			OmProgrp omProgrp = new OmProgrp();
			omProgrp.setIdProgrp(1l);
			listaPlataformas.add(omProgrp);
			s.append(plataformasSel[0]);
		}else{
			for (String pl : plataformasSel){
				OmProgrp omProgrp = new OmProgrp();
				omProgrp.setCdProgrp(pl);
				listaPlataformas.add(omProgrp);
				if (s.length() > 0)
					s.append(",");
				s.append(pl);
			}
		}
		filtro.setPlataformas(listaPlataformas);
	}
	try{
		filtro.setAgrupamento(Integer.valueOf(agrupamento));
		if (Integer.valueOf(agrupamento) == 1){
			dsAgrupamento = "Diário";	
		}else if (Integer.valueOf(agrupamento) == 2){
			dsAgrupamento = "Semanal";	
		}else if (Integer.valueOf(agrupamento) == 3){
			dsAgrupamento = "Mensal";	
		}else{
			dsAgrupamento = "Anual";
		}
		
	}catch(Exception e){		
	}
	try{
		filtro.setApontamento(Integer.valueOf(apontamento));	
		dsApontamento = Integer.valueOf(apontamento) == 1 ? "Defeito" : "Componente";
	}catch(Exception e){		
	}
	

	RelIndTesteFinalDTO resultado = IdwFacade.getInstancia().getRelIndTesteFinal(filtro);
	
	try{
		filtro.setApontamento(Integer.valueOf(apontamento));	
	}catch(Exception e){		
	}

//	FiltroGraficoDTO filtroGraf = new FiltroGraficoDTO();
	
	
	// Definir o filtro a ser usado
	
	FiltroGraficoDTO filtro1 = new FiltroGraficoDTO();

	filtro1.setIdGrafico(new BigDecimal(1));

	filtro1.setGrafico(resultado.getGraficoTaxas());

	
	GraficosCfwswebFactory graficoTaxas = GraficosCfwswebFactory.getGraficosFactory(filtro1.getIdGrafico().intValue());

	
	graficoTaxas.setLarguraGraficoEmPixel(700);
	graficoTaxas.setAlturaGraficoEmPixel(200);

	filtro1.setTurnoDefault(filtro1.getTurnoDefault01());
	graficoTaxas.setFiltroGraficoDTO(filtro1);
	graficoTaxas.setCorFundo(Color.getColor("#6FB7FF"));
	graficoTaxas.setTituloLimiteInferior("Melhor índice histórico");
	graficoTaxas.setTituloLimiteSuperior("Pior índice histórico");
	graficoTaxas.setCoresEspecificasParaAsBarras(true);
	Color[] cores = {Color.gray};
	graficoTaxas.setCoresBarras(cores);
	graficoTaxas.setMostraLegenda(false);
	try{
		graficoTaxas.setLimiteSuperior(resultado.getMelhorIndice());
		graficoTaxas.setLimiteInferior(resultado.getPiorIndice());	
	}catch (Exception e){		
	}			

	try {
		graphURLTime1 = graficoTaxas.mostraGraficoNaWeb(session, response
		.getWriter());
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	GraficoParettoReprocesso graficoParettoReprocesso = new GraficoParettoReprocesso();
	
	graficoParettoReprocesso.setLarguraGraficoEmPixel(700);
	graficoParettoReprocesso.setAlturaGraficoEmPixel(150);

	graficoParettoReprocesso.setParettos(resultado.getParettos());
	
	try {
		graphURLTime2 = graficoParettoReprocesso.mostraGraficoNaWeb(session,
		response.getWriter());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
%>

<%@page import="idw.webservices.dto.PesquisasDTO"%>
<%@page import="idw.webservices.dto.PesquisaDTO"%>
<%@page import="idw.model.pojos.DwExpcvs"%>
<%@page import="idw.webservices.dto.FiltroRelDTO"%>
<%@page import="idw.webservices.dto.RelIndTesteFinalDTO"%>
<%@page import="idw.webservices.dto.FiltroGraficoDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="idw.model.pojos.OmProgrp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="idw.view.grafico.GraficosCfwswebFactory"%>
<%@page import="java.io.IOException"%>
<%@page import="java.awt.Color"%>
<%@page import="idw.view.grafico.GraficoParettoReprocesso"%>
<%@page import="idw.webservices.dto.SerieTaxaFalhaDTO"%>
<%@page import="idw.model.IdwFacade"%><br>

<div id="esquerda">
	
	<table>
		<tr>
			<td width="100%">
				<table border=1 width="100%" bgcolor="gray" style="border-width: 1px;border-spacing: 0px;border-color: black">
				<tr><td align="center"><font color="white"><b>INDICADORES DO TESTE FINAL - LAVANDERIA</b></font></td></tr></table>
			</td>
			<td><br><br><br><br></td>			
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2">
				<table width="100%">
					<tr>
						<td width="20%">
							<table border=1 width="100%" style="border-width: 0.5px;border-spacing: 0px;border-color: black">
								<tr bgcolor="lightblue" >
									<td align="center">Plataforma</td>									
								</tr>
								<tr bgcolor="white" >
								<td>
								<%
								for (String ps : resultado.getPlataformasSelecionadas()){
								%>
									<%=ps%>
								<%}%>
								</td>
								</tr>
							</table>
							<br><br>
						</td>
						<td width="10%" rowspan="8"></td>
						<td width="70%" rowspan="8">
							<table width="100%" height="100%">
								<tr>
									<td><img alt="Taxa de falha" src="<%=graphURLTime1 %>"><img alt="Taxa de falha" src="images/legendaGra.png" WIDTH=190 HEIGHT=90></td>
								</tr>
								<tr>
									<td>
										<table border=1 width="700px" style="border-width: 1px;border-spacing: 0px;border-color: black">
											<tr>	
												<td></td>										
									<% for (SerieTaxaFalhaDTO taxa : resultado.getTaxas()){ %>
												<td><%=taxa.getDescricao() %></td>
									<%} %>
											</tr>
											<tr>	
												<td>Qtde Falha</td>										
									<% for (SerieTaxaFalhaDTO taxa : resultado.getTaxas()){ %>
												<td><%=taxa.getQtdeFalhas().intValue() %></td>
									<%} %>
											</tr>
											<tr>	
												<td>Produção</td>										
									<% for (SerieTaxaFalhaDTO taxa : resultado.getTaxas()){ %>
												<td><%=taxa.getProducaoBruta().intValue() %></td>
									<%} %>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td><img alt="Pareto do Reprocesso" src="<%=graphURLTime2 %>"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr><td></td></tr>					
					<tr>
						<td>
							<table border=1 width="100%" style="border-width: 0.5px;border-spacing: 0px;border-color: black">
								<tr bgcolor="lightblue">
									<td align="center">Período</td>									
								</tr>
								<tr bgcolor="white">
									<td><%=dtInicial %></td>
								</tr>
								<tr bgcolor="white">
									<td><%=dtFinal %></td>
								</tr>
							</table>
							<br><br>
						</td>						
					</tr>
					<tr><td></td></tr>
					<tr>
						<td>
							<table border=1 width="100%" style="border-width: 0.5px;border-spacing: 0px;border-color: black">
								<tr bgcolor="lightblue">
									<td align="center">Escala do eixo X</td>									
								</tr>
								<tr>
									<td><%=dsAgrupamento %></td>
								</tr>
							</table>
							<br><br>
						</td>						
					</tr>
					<tr><td></td></tr>
					<tr>
						<td>
							<table border=1 width="100%" style="border-width: 0.5px;border-spacing: 0px;border-color: black">
								<tr bgcolor="lightblue">
									<td align="center">Apontamento Reprocesso</td>									
								</tr>
								<tr bgcolor="white">
									<td><%=dsApontamento %></td>
								</tr>
							</table>
							<br><br>
						</td>						
					</tr>
					<tr><td></td></tr>
				</table>				
			</td>			
		</tr>	
	 </table>
	
	<br>
	<p class="submit"><input type="button" value="Voltar" onclick="javascript:history.back();" /></p>	
	
	
</div>



<div style='display:none'>
	<img src='css/skins/aqua/active-bg.gif' />
	<img src='css/skins/aqua/dark-bg.gif' />
	<img src='css/skins/aqua/hover-bg.gif' />
	<img src='css/skins/aqua/menuarrow.gif' />
	<img src='css/skins/aqua/normal-bg.gif' />
	<img src='css/skins/aqua/rowhover-bg.gif' />
	<img src='css/skins/aqua/status-bg.gif' />
	<img src='css/skins/aqua/title-bg.gif' />
	<img src='css/skins/aqua/today-bg.gif' />
</div>

