<%@ page language="java" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">

<%@page import="idw.webservices.dto.UsuarioDTO"%>
<%@page import="idw.model.pojos.OmUsr"%>
<%@page import="idw.model.rn.HashMD5"%><html>
<head>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
<TITLE>IDW</TITLE>
</head>
<body>

<form name="filtro" method="post" action="control?estilo=exportaProcesso">
    <fieldset>
	<legend>Exportação</legend>
	<table width=100% border=0>
		<tr><th width="150px"></th></tr>
		
		<tr><td>Prefixo</td><td><input name="prefixo" id="prefixo"></td></tr>
	</table>
	<input type="button" onclick="javascript:history.back();" value="Voltar" />
    <input class="button" type="submit" value="Exportar" />
</fieldset>
</form>

</body>
</html>