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

<form name="filtro" method="post" action="control?estilo=filtroSalvar">
    <p>O código já existe. Deseja sobrepor filtro?</p>
    <input type="button" onclick="javascript:history.back();" value="Não" />
    <input class="button" type="submit" value="Sim" />
    <br/>
</form>

</body>
</html>