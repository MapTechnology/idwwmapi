<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.io.IOException"%>

<%@page import="idw.webservices.dto.UsuarioDTO"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="author" content="Lineker Souza"/>
<script type = "text/javascript" src = "scripts/funcoes.js"></script>
<script type = "text/javascript">qual_css('/')</script>
<style type='text/css'>@import url(css/skins/aqua/theme.css);</style>
<script type='text/javascript' src='scripts/calendar.js'></script>
<script type='text/javascript' src='scripts/lang/calendar-br.js'></script>
<script type='text/javascript' src='scripts/calendar-setup.js'></script>

<title>IDW</title>

<style type="text/css">

.solidblockmenu {
	margin-top: 0px;
	padding: 0;
	float: left;
	font: bold 13px Arial;
	width: 100%;
	border: 1px solid #625e00;
	border-width: 1px 0;
	background: black url(images/blockdefault.gif) center center repeat-x;
}

.solidblockmenu li{
	margin: 0px;
 	display: inline;
}

.solidblockmenu li a{
	margin: 0px;
	float: left;
	color: white;
	padding: 15px 11px;
	text-decoration: none;
	border-right: 1px solid white;
 }

.solidblockmenu li a:visited{
	color: white;
}

.solidblockmenu li a:hover, .solidblockmenu li .current{
	margin: 0px;            
	color: white;
	background: transparent url(images/blockactive.gif) center center repeat-x;
}
</style>

</head>

<body>
<div id="corpo">
	<div id="content">
		<jsp:include page="relVisualizarresultado.jsp" flush="true"/>		
	</div>
	<div id="sub-section">
	</div>
	<div id="rodape">
		<jsp:include page="rodape.jsp" flush="true"/>
	</div>
</div>
</body>
</html>