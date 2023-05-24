<%@ page language="java" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">

<%@page import="idw.webservices.dto.UsuarioDTO"%>
<%@page import="idw.model.pojos.OmUsr"%>
<%@page import="idw.model.rn.HashMD5"%>
<%@page import="idw.webservices.dto.FiltroExportacaoDTO"%>
<%@page import="idw.model.pojos.DwExpcvs"%>
<%@page import="idw.model.IdwFacade"%><html>
<head>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
<TITLE>IDW</TITLE>
</head>
<body>

<%
	FiltroExportacaoDTO filtro = null;
	filtro = (FiltroExportacaoDTO)session.getAttribute("filtro");
	
	filtro = IdwFacade.getInstancia().setFiltroExportacaoDTO(filtro); 
	session.setAttribute("filtro",filtro);
	
	if (filtro.getResultadoEvento() > 0){
		%>
			<script language="JavaScript" type="text/javascript">
				alert('Erro ao salvar filtro');
			</script>
		<%				
	} else {	
		%>
			<script language="JavaScript" type="text/javascript">
				alert('Filtro salvo com sucesso');				
			</script>
		<%		
	}
	
	response.sendRedirect("control?estilo=exportacao&idfiltro=" + String.valueOf(filtro.getFiltro().getIdExpcvs()));
%>

</body>
</html>