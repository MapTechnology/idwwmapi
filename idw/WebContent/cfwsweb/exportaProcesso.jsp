<%@ page language="java" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">

<%@page import="idw.webservices.dto.UsuarioDTO"%>
<%@page import="idw.model.pojos.OmUsr"%>
<%@page import="idw.model.rn.HashMD5"%>
<%@page import="idw.webservices.dto.FiltroExportacaoDTO"%>
<%@page import="idw.model.pojos.DwExpcvs"%>
<%@page import="idw.webservices.dto.ExportacaoDTO"%>
<%@page import="idw.webservices.dto.ExpArquivoExportadoDTO"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="idw.model.IdwFacade"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="idw.util.Compress"%><html>
<head>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
<TITLE>IDW</TITLE>
</head>
<body>

<%
	FiltroExportacaoDTO filtro = null;
	filtro = (FiltroExportacaoDTO)session.getAttribute("filtro");
	filtro.setPath(System.getProperty("catalina.base") + "/logs");
	filtro.setPrefixo(request.getParameter("prefixo"));
	
	ExportacaoDTO exportacao = IdwFacade.getInstancia().exportaCVS(filtro); 
	session.setAttribute("filtro",filtro);
	
	if (exportacao.getResultadoEvento() == 4){
		%>
			<script language="JavaScript" type="text/javascript">
				alert('Nenhum dado encontrado com o filtro');
			</script>
			<a href="control?estilo=exportacao&idfiltro=<%=String.valueOf(filtro.getFiltro().getIdExpcvs()) %>">Voltar</a>
		<%				
	} else 	if (exportacao.getResultadoEvento() > 0){
		%>
		<script language="JavaScript" type="text/javascript">
			alert('Erro na exportação. ErroNu = ' + exportacao.getResultadoEvento());
		</script>
			<a href="control?estilo=exportacao&idfiltro=<%=String.valueOf(filtro.getFiltro().getIdExpcvs()) %>">Voltar</a>
	<%				
	} else {
		String caminho = filtro.getPath();
		if (!caminho.endsWith("/")){
			caminho += "/";
		}
		
		try {
			/*
			for (ExpArquivoExportadoDTO arquivo : exportacao.getArquivos()){			
				//System.out.println("Escrevendo arquivo " + caminho + arquivo.getNomeArquivo() + ".csv"); 
				//OutputStream retorno = new FileOutputStream(caminho + arquivo.getNomeArquivo() + ".csv");
				BufferedWriter retorno = new BufferedWriter(new FileWriter(caminho + arquivo.getNomeArquivo() + ".csv"));
				retorno.write(arquivo.getConteudo());			
				retorno.close();
			}
			*/
			exportacao = null;
			
			// Compacta arquivos para download
			//System.out.println("Compactando arquivo " + caminho + filtro.getPrefixo() + ".csv");
			%>
			<script language="JavaScript" type="text/javascript">
				alert('Exportação realizada com sucesso. Selecione o link para download.');				
			</script>
			<a href="control?estilo=salvaexportacao&arquivo=<%=caminho + filtro.getPrefixo()%>.zip&destino=<%=filtro.getPrefixo()%>.zip">Download do arquivo</a>
			<br>
			<a href="control?estilo=exportacao&idfiltro=<%=String.valueOf(filtro.getFiltro().getIdExpcvs()) %>">Voltar</a>
			<%		
		} catch (FileNotFoundException e){
			%>
			<script language="JavaScript" type="text/javascript">
				alert('Informe um nome válido para o arquivo.');
			</script>
			<%				
		}
	}
	
	//response.sendRedirect("control?estilo=exportacao&idfiltro=" + String.valueOf(filtro.getFiltro().getIdExpcvs()));
%>

</body>
</html>