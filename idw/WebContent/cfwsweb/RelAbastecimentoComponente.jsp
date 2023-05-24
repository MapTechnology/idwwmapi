<%@ page contentType="text/html" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="idw.model.rn.EmpresaRN"%>
<%@page import="idw.model.pojos.OmCfg"%>
<%@page import="idw.webservices.dto.RelAbastecimentoComponentesDTO"%>
<%@page import="idw.webservices.dto.RelAbastecimentoComponentesAlimreaDTO"%>
<%    
	Integer idAlimentacao = 0;
   try {	 
	   idAlimentacao = Integer.parseInt(request.getParameter("idAlimentacao"));   
   }catch (Exception e) {
      e.printStackTrace();
   }
   
   RelAbastecimentoComponentesDTO temp = IdwFacade.getInstancia().getRelAbastecimentoComponentes(idAlimentacao);
   
   OmCfg configuracao = IdwFacade.getInstancia().getConfiguracaoAtual();
   
   boolean isEmpresaFlex = EmpresaRN.isEmpresaFlex(configuracao);
%>

<%@page import="idw.model.IdwFacade"%><html>
<head>
<title>Relat�rio de Alimenta��o</title>
<link href="../css/estilos.css" type="text/css" media="screen" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>

Relat�rio de Alimenta��o

<table class="tabelaSemBordas">
	<tr>
		<td>Data da Opera��o: <%=temp.getDataOperacao() %></td>
		<td></td>
	</tr>
	<tr>
		<td>M�quina: <%=temp.getMaquina() %></td>
		<td><%=temp.getDataOperacao() %> </td>
	</tr>
	<tr>
		<td>Mapa de Alimenta��o: <%=temp.getMapa() %></td>
		<td> <%=temp.getVersao() %></td>
	</tr>
</table>
<table class="tabelaRelatorio">
	<tr class="linhaCabecalhoTabela">
		<td rowspan=2 class="colunaComBordas">COMPONENTE</td>
		<% if(isEmpresaFlex) { %>
		<td rowspan=2 class="colunaComBordas">DESCRI��O DO COMPONENTE</td>
		<% } %>
		<td rowspan=2 class="colunaComBordas">POSI��O "Z"</td>
		<td rowspan=2 class="colunaComBordas">QUANTIDADE</td>
		<% if(isEmpresaFlex) { %>
		<td rowspan=2 class="colunaComBordas">MATR�CULA DO OPERADOR</td>
		<% } %>
		<td rowspan=2 class="colunaComBordas">OPERADOR</td>
		<td colspan=6 class="colunaComBordas" align="center">STATUS</td>
		<td rowspan=2 class="colunaComBordas">HORA</td>
	</tr>
	<tr class="linhaCabecalhoTabela">
		<td class="colunaComBordas">ALIM.OK</td>
		<td class="colunaComBordas">ALIM.N OK</td>
		<td class="colunaComBordas">REALIM.OK</td>
		<td class="colunaComBordas">REALIM.N OK</td>
		<td class="colunaComBordas">CONFER.OK</td>
		<td class="colunaComBordas">CONFER.N OK</td>		
	</tr>

<%
	for (RelAbastecimentoComponentesAlimreaDTO item : temp.getAlimRea()){
	  
	  %>
    <tr>
        <td class="colunaComBordas"><%out.print(item.getComponente());%></td>
        <% if(isEmpresaFlex) { %>
        <td class="colunaComBordas"><%out.print(item.getDsComponente());%></td>
        <% } %>
        <td class="colunaComBordas"><%out.print(item.getPosicaoZ());%></td>
        <td class="colunaComBordas"><%out.print(item.getQuantidade());%></td>
        <% if(isEmpresaFlex) { %>
        <td class="colunaComBordas"><%out.print(item.getMatriculaOperador());%></td>
        <% } %>
       	<td class="colunaComBordas"><%out.print(item.getOperador());%></td>
       	<td class="colunaComBordas"><%out.print(item.getAlimOK());%></td>
       	<td class="colunaComBordas"><%out.print(item.getAlimNOK());%></td>
       	<td class="colunaComBordas"><%out.print(item.getRealimOK());%></td>
       	<td class="colunaComBordas"><%out.print(item.getRealimNOK());%></td>
       	<td class="colunaComBordas"><%out.print(item.getConferOK());%></td>
       	<td class="colunaComBordas"><%out.print(item.getConferNOK());%></td>       	
       	<td class="colunaComBordas"><%out.print(item.getHora());%></td>       	
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
