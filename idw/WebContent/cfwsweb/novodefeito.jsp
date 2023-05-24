
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
		String cdDefeito = "";
		String cdArea = "";
		String posicaoMecanica = "";
%>

<form name="consertar" method="post" action="control?estilo=salvardefeito&ns=<%=ns%>">
	<div id="filtro1">
		<fieldset>
			<legend>
				Novo defeito para NS
				<%=ns%>
			</legend>
			<table width=100% border=0>
				<tr>
					<td>C�digo defeito</td>
					<td><input name="cddefeito" id="cddefeito"
						value="<%=cdDefeito%>">
						<button type="button"
							onclick="javascript:pesquisa('cddefeito','Cd Defeito','defeito', 'REP_IM');">...</button></td>
				</tr>
				<tr>
					<td>C�digo �rea respons�vel</td>
					<td><input name="cdarea" id="cdarea" value="<%=cdArea%>">
						<button type="button"
							onclick="javascript:pesquisa('cdarea','Cd �rea','area', '');">...</button></td>
				</tr>
				<tr>
					<td>Posi��es mec�nicas</td>
					<td><input id="posicaomecanica" name="posicaomecanica"
						value="<%=posicaoMecanica%>">
					</td>
				</tr>
				<tr>
					<td>
						<input name="btnSalvar" type="submit" value="Salvar defeito"> 
						<input type="button" value="Voltar" onclick="javascript:window.close()" />
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
</form>
