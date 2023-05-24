<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="idw.util.Util"%>
<%@page import="idw.util.ArquivosDiretorios"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IDW <%=Util.getVersao()%></title>
</head>
<body>
<h1>Relação dos logs do Tomcat para download</h1>
<%
String caminho = System.getProperty("catalina.base") + "/logs";
String[] arquivos = ArquivosDiretorios.getArquivosNoDiretorio(caminho);
for (String arquivo : arquivos){
%>
	<a href="/idw/control?estilo=salvaexportacao&arquivo=<%=caminho%>/<%=arquivo%>&destino=<%=arquivo%>"><%=arquivo%></a>
	<br>
<%
}
%>
</body>
</html>