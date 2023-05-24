<%@ page contentType="text/html" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="idw.webservices.dto.ProdutosDTO"%>
<%@page import="idw.webservices.dto.ProdutoDTO"%>
<%@page import="idw.model.IdwFacade"%>
<%    
	ProdutosDTO temp = IdwFacade.getInstancia().getRelProdutosSemDePara();
   
%>

<%@page import="idw.model.IdwFacade"%><html>
<head>
<title>Relatório de Produtos sem Componentes De/Para</title>
<link href="css/estilos.css" type="text/css" media="screen" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>

Relatório de Produtos sem Componentes De/Para

<table class="tabelaRelatorio">
	<tr class="linhaCabecalhoTabela">
		<td class="colunaComBordas">ID PRODUTO</td>
		<td class="colunaComBordas">CD PRODUTO</td>
		<td class="colunaComBordas">REVISÃO</td>
		<td class="colunaComBordas">DESCRIÇÃO PRODUTO</td>		
	</tr>
	
<%
	for (ProdutoDTO item : temp.getProdutos()){
	  
	  %>
    <tr class="colunaComBordas">
        <td class="colunaComBordas"><%out.print(item.getProduto().getIdProduto());%></td>
        <td class="colunaComBordas"><%out.print(item.getProduto().getCdProduto());%></td>
       	<td class="colunaComBordas"><%out.print(item.getProduto().getRevisao());%></td>
       	<td class="colunaComBordas"><%out.print(item.getProduto().getDsProduto());%></td>
    </tr>
    <%}

%>

</table>

<p>
    <input type="button" name="Imprimir" value="Imprimir" onclick="javascript:window.print()">
    <input type="button" name="Voltar" value="Voltar" onclick="javascript:history.back()">     
</p>

</body>
</html>
