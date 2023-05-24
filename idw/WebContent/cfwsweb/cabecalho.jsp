
<%@page import="idw.util.Util"%><head>
<link rel="stylesheet" href="css/estilos.css" type="text/css">
<TITLE>IDW <%=Util.getVersao()%></TITLE>

<style type='text/css'>@import url(css/skins/aqua/theme.css);</style>
<script type='text/javascript' src='scripts/calendar.js'></script>
<script type='text/javascript' src='scripts/lang/calendar-br.js'></script>
<script type='text/javascript' src='scripts/calendar-setup.js'></script>

<script language="Javascript">  
	var javawsInstalled = 0;  
	isIE = "false";  
	if (navigator.mimeTypes && navigator.mimeTypes.length) {  
		x = navigator.mimeTypes['application/x-java-jnlp-file'];
		if (x) javawsInstalled = 1;  
	} else {  
		isIE = "true";  
	}  

	function insertLink() {  
		if (javawsInstalled) {  
			return "<h3>Para os cadastros e monitorização.</h3><h3>Acesse o icone abaixo.</h3>";  
  		} else {  
			return "<h3>Você precisa instalar o Java Web Start para poder acessar o icone abaixo.</h3>";  
		}  
	}  
</script>  

</head>
