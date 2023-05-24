<%@page import="idw.webservices.rest.dto.dashboard.flex.DashboardFlexHoraDTO"%>
<%@page import="idw.webservices.rest.dto.dashboard.flex.DashboardFlexOpProdutoDTO"%>
<%@page import="idw.model.rn.DataHoraRN"%>
<%@page import="idw.webservices.rest.dto.dashboard.flex.DashboardFlexDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="idw.webservices.dto.PassagemDTO"%>
<%@page import="idw.webservices.dto.NaoConformidadeDTO"%>
<%@page import="idw.webservices.dto.PassagensDTO"%>
<%@page import="idw.model.IdwFacade"%>

<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="../runcard/css/test-result.css">
<script src="../runcard/js/jquery.min.js"></script>
<script src="../runcard/js/test-result.js"></script>

<script language="JavaScript">
var sURL = unescape(window.location.pathname);
			
function doLoad()
{
var tempo=60;
setTimeout( "refresh()", tempo*1000 );
}
			
function refresh()
{
var cdgt = '<%=request.getParameter("cdgt")%>';
var url = sURL + "?cdgt=" + cdgt;
window.location.href = url;
}
</script>

</head>

<%
	
String cdGt = request.getParameter("cdgt");
String dthr = DataHoraRN.getDataHoraAtualFormatada();

// Pesquisar dados do dashboard
DashboardFlexDTO dto = IdwFacade.getInstancia().producao(cdGt, dthr);

DashboardFlexOpProdutoDTO prod = dto.getOpsProdutos().iterator().next();

String op = prod.getCdCp();
String modelo = prod.getModelo();
%>


<body height="100%" onload="doLoad()">
	<div class="main">

		<table width="100%">
			<tr>
				<td><%=dto.getCdGt()%></td>
				<td><%=dto.getData()%> - <%=dto.getTurno()%></td>
			</tr>
			<tr>
				<td>OP: <%=op%>
				</td>
				<td><%=modelo%></td>
			</tr>
		</table>

		<div class="div-inputs center">
			<div class="div-barcode">

				<table align="center" style="font-size: 48px">

					<tr>
						<td>Hora</td>
						<td>Meta</td>
						<td>Produção</td>
						<td>Defeitos</td>
						<td>Scraps</td>
						<td>Ind.FOR(%)</td>
						<td>Downtimes</td>
					</tr>


					<%
						for (DashboardFlexOpProdutoDTO produto : dto.getOpsProdutos()) {

						for (DashboardFlexHoraDTO hora : produto.getHoras()) {
					%>
					<tr>
						<td><%=hora.getDthrIhoraFormatado()%></td>
						<td><%=hora.getMeta()%></td>
						<td><%=hora.getProduzidos()%></td>
						<td><%=hora.getDefeitos()%></td>
						<td><%=hora.getScraps()%></td>
						<td><%=hora.getIndfor()%>
						<td><%=hora.getDowntimeFormatado()%>
						<td></td>
					</tr>

					<%
						}
					%>

					<tr>
						<td></td>
						<td><b><%=produto.getMetaDia() %></b></td>
						<td><b><%=produto.getProduzidos()%></b></td>
						<td><b><%=produto.getDefeitos()%></b></td>
						<td><b><%=produto.getScraps()%></b></td>
						<td><b><%=produto.getIndfor()%></b></td>
						<td></td>
					</tr>


					<%
						}
					%>



				</table>


			</div>
		</div>
	</div>
</body>
</html>