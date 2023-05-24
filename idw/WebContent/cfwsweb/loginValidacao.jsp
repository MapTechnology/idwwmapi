<%@ page language="java" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">

<%@page import="idw.webservices.dto.UsuarioDTO"%>
<%@page import="idw.model.pojos.OmUsr"%>
<%@page import="idw.model.rn.HashMD5"%>
<%@page import="idw.model.IdwFacade"%><html>
<head>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
<TITLE>IDW</TITLE>
</head>
<body>

<%
	UsuarioDTO usuario = new UsuarioDTO();

	try {
		usuario.setUsuario(new OmUsr());
		usuario.getUsuario().setLogin(request.getParameter("login"));
		usuario.getUsuario().setSenha(HashMD5.getHashCode(request.getParameter("senha")));
		usuario = IdwFacade.getInstancia().isUsuarioAutenticado(usuario); 
    } catch (Exception ex) {
    	usuario = new UsuarioDTO();
    	usuario.setResultadoEvento(1);
    }
	
	if (usuario.getResultadoEvento() > 0){
		response.sendRedirect("control?estilo=login&erro=Login não autorizado.");
	} else {
		// Inicializa o objeto com os atributos da sessao e a salva no controle de sessoes
        // do navegador
        session.setAttribute("sessaousuario",usuario);
        
		response.sendRedirect("control?estilo=index");
	}
%>

</body>
</html>