
<%@page import="idw.util.Util"%>
<%@page import="java.math.BigDecimal"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="scripts/funcoes.js"></script>
<link rel="stylesheet" href="css/estilo-web-ie.css" type="text/css">
<style type='text/css'>
@import url(css/skins/aqua/theme.css);
</style>

<%@page import="idw.model.IdwFacade"%>
<%
		String ns = request.getParameter("ns");
		String cdrefugo = "";
%>

<form name="refugar" method="post" action="control?estilo=salvarrefugo&ns=<%=ns%>">
	<div id="filtro1">
		<fieldset>
			<legend>
				Refugar NS
				<%=ns%>
			</legend>
			<table width=100% border=0>
				<tr>
					<td>Código refugo *</td>
					<td><input name="cdrefugo" id="cdrefugo"
						value="<%=cdrefugo%>">
						<button type="button"
							onclick="javascript:pesquisa('cdrefugo','Cd Refugo','refugo', 'REP_IM');">...</button></td>
				</tr>
				<tr>
					<td>
						<input name="btnSalvar" type="submit" value="Refugar"> 
						<input type="button" value="Voltar" onclick="javascript:window.close()" />
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
</form>
