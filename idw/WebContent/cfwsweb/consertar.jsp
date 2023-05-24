
<%@page import="idw.util.Util"%>
<%@page import="java.math.BigDecimal"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="scripts/funcoes.js"></script>
<link rel="stylesheet" href="css/estilo-web-ie.css" type="text/css">
<style type='text/css'>@import url(css/skins/aqua/theme.css);</style>

<%@page import="idw.model.IdwFacade"%>
<%
		String ns = request.getParameter("ns");
		String nc = request.getParameter("nc");
		String cdCausa = "";
		String cdAcao = "";
		String cdDefeito = "";
		String cdArea = "";
		String posicaoMecanica = "";
		String idpassagem = request.getParameter("idpassagem");
		String idpassdef = request.getParameter("idpassdef");
%>

<form name="consertar" method="post" action="control?estilo=salvarconserto&ns=<%=ns%>&idpassagem=<%=idpassagem%>&idpassdef=<%=idpassdef%>">
	<div id="filtro1">
		<fieldset>
			<legend>
				Consertar NS
				<%=ns%>
				para NC
				<%=nc%></legend>
			<table width=100% border=0>
				<tr>
					<td>C�digo causa *</td>
					<td><input name="cdcausa" id="cdcausa"
						value="<%=cdCausa%>">
						<button type="button"
							onclick="javascript:pesquisa('cdcausa','Cd Causa','causa', 'REP_IM');">...</button></td>
				</tr>
				<tr>
					<td>C�digo a��o *</td>
					<td><input name="cdacao" id="cdacao"
						value="<%=cdAcao%>">
						<button type="button"
							onclick="javascript:pesquisa('cdacao','Cd Acao','acao', 'REP_IM');">...</button></td>
				</tr>
				<tr>
					<td>C�digo defeito *</td>
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
						<input name="btnSalvar" type="submit" value="Consertar"> 
						<input type="button" value="Voltar" onclick="javascript:history.back()" />
					</td>
				</tr>
			</table>
		</fieldset>
	</div>
</form>
