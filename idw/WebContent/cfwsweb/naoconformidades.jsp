<%@page import="idw.webservices.dto.NaoConformidadeDTO"%>
<%@page import="idw.webservices.dto.PassagemDTO"%>
<%@page import="java.util.List"%>
<%@page import="idw.model.IdwFacade"%><br>

<%
	String nsLido = request.getParameter("nsLido");
	String nsEscolhido = "";

	PassagemDTO passagem = new PassagemDTO();
	
	passagem.setCb(nsLido);
	passagem.setCdPt("REP_IM");
	
	passagem = IdwFacade.getInstancia().obtemNaoConformidadesAtuais(passagem);
%>

<div id="esquerda">
	<fieldset>
		<h1>Não conformidades do <%=nsLido%></h1>
		<legend>Escolher a não conformidade para consertar</legend>

		<table border=1>
			<tr>
				<td></td>
				<td>Número série</td>
				<td>Não conformidade</td>
				<td>Data e hora</td>
				<td>Posto origem</td>
			</tr>

			<%for (NaoConformidadeDTO ncdto : passagem.getNaoConformidadesAtuais())  {%>

				<tr>
					<td><a href="control?estilo=consertar&ns=<%=nsLido%>&nc=<%=ncdto.getDsNaoConformidade()%>&idpassagem=<%=ncdto.getIdPassagem()%>&idpassdef=<%=ncdto.getIdPassdef()%>">Consertar</a></td>
					<td><%=ncdto.getCb()%></td>
					<td><%=ncdto.getDsNaoConformidade()%></td>
					<td><%=ncdto.getDthrNC()%></td>
					<td><%=ncdto.getCdPt() %></td>
				</tr>

			<%}%>
			

		</table>

			<%
			if (passagem.getNaoConformidadesAtuais().isEmpty()) {
			%>
				<h3>Nenhuma não conformidade encontrada.</h3>
			<%	
			}
			%>

		<br>
		
		<p class="submit">
			<input type="button" value="Informar novo defeito" onclick="javascript:window.open('/idw/control?estilo=novodefeito&ns=<%=nsLido%>')" />
			<input type="button" value="Refugar <%=nsLido%>" onclick="javascript:window.open('/idw/control?estilo=refugar&ns=<%=nsLido%>')" />
			<input type="button" value="Voltar" onclick="javascript:history.back()" />
		</p>

	</fieldset>

</div>



<div style='display: none'>
	<img src='css/skins/aqua/active-bg.gif' /> <img
		src='css/skins/aqua/dark-bg.gif' /> <img
		src='css/skins/aqua/hover-bg.gif' /> <img
		src='css/skins/aqua/menuarrow.gif' /> <img
		src='css/skins/aqua/normal-bg.gif' /> <img
		src='css/skins/aqua/rowhover-bg.gif' /> <img
		src='css/skins/aqua/status-bg.gif' /> <img
		src='css/skins/aqua/title-bg.gif' /> <img
		src='css/skins/aqua/today-bg.gif' />
</div>

<script language="JavaScript" type="text/javascript">
	function selecionar(codigo, descricao) {
		window.opener.document.forms[0].<%=nsEscolhido%>.value = codigo;
		window.close();
	}
</script>

