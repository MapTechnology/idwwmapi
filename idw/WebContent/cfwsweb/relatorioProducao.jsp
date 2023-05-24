<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="ms.coleta.ic.inova.Stubdelegate"%>
<%@page import="idw.model.IdwFacade"%>
<%@page import="java.io.IOException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	UsuarioDTO sessaoUsuario = null;
        sessaoUsuario = (UsuarioDTO) session.getAttribute("sessaousuario");

        if (sessaoUsuario == null){
	        response.sendRedirect("control?estilo=login&erro=Sessão expirada. Necessário novo login.");
        }
%>


<%@page import="idw.webservices.dto.UsuarioDTO"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="author" content="Lineker Souza"/>
<script type = "text/javascript" src = "scripts/funcoes.js"></script>
 <link href="css/style.css" rel="stylesheet" type="text/css">
<TITLE>IDW</TITLE>

<style type='text/css'>@import url(css/skins/aqua/theme.css);</style>
<script type='text/javascript' src='scripts/calendar.js'></script>
<script type='text/javascript' src='scripts/lang/calendar-br.js'></script>
<script type='text/javascript' src='scripts/calendar-setup.js'></script>
<style type="text/css">
.solidblockmenu {
	margin: 0;
	padding: 0;
	float: left;
	font: bold 13px Arial;
	width: 100%;
	border: 1px solid #625e00;
	border-width: 1px 0;
	background: black url(images/blockdefault.gif) center center repeat-x;
}

.solidblockmenu li{
 	display: inline;
}

.solidblockmenu li a{
	float: left;
	color: white;
	padding: 9px 11px;
	text-decoration: none;
	border-right: 1px solid white;
 }

.solidblockmenu li a:visited{
	color: white;
}

.solidblockmenu li a:hover, .solidblockmenu li .current{            
	color: white;
	background: transparent url(images/blockactive.gif) center center repeat-x;
}
</style>
</head>

<body>
<table border="0" cellpadding="0" cellspacing="0">



       	  <tr>
            	<td id="logo">&nbsp;
                	
                </td>
           
            <td id="botaohome">
                 <a class="MenuHome" href="control?estilo=index">
                        <fmt:message key="Home"/>  
                        </a>
                 </td>
            
                
<td id="botaoexportacao">
                 <a class="MenuExpo" href="control?estilo=exportacao">
                    	<fmt:message key="Exportação"/>
                    </a>
                       
                </td>
                
                             
<td id="botaograficogerencial">
<a class="MenuTopoGrafico" href="control?estilo=exportacaoRel">
                    	<fmt:message key="Gráfico_Gerencial"/>
                    </a>
            </td>
                
			<td id="botaorelatproducao">
			<a class="MenuRelatProducao" href="control?estilo=relatorioProducao">
                    	<fmt:message key="Relatório_de_Produção"/>
                    </a>
            </td>
                
            <td id="botaoreprocesso"><a class="MenuReprocesso"
				href="control?estilo=reprocesso"> <fmt:message key="reprocesso" />
			</a></td>
                
			<td id="botaologout">
			<a class="MenuTopoLogout" href="control?estilo=logout">Logout</a>
            </td>
                 
                 
            <td id="botaoembranco">&nbsp;
            </td>
  </tr>
            
        </table>
        
        
        <!-- tabela para segunda linha -->
		<table border="0" cellpadding="0" cellspacing="0">
        	<tr>
            	<td id="abaixodobotao">
                	
                </td>
             </tr>
           
         </table>
         
         <!-- tabela para terceira linha -->
		<table border="0" cellpadding="0" cellspacing="0">
        	<tr>
           	  <td id="linha">
                	
                </td>
          </tr>
           
    </table>
         
         <%
         // Mostrar o filtro somente se o injet estiver ativo
         if (true) {
         %>
          <!-- tabela para quarta linha -->
		<table border="0" cellpadding="0" cellspacing="0">
        	<tr>
            
                      
            	<td align="left" valign="top" id="areaexportacao">   
            		<jsp:include page="relProducaoFiltro.jsp" flush="true"/>       
                </td>
               
                                                       
          </tr>
          
		<!-- tabela para decima linha -->
		<table border="0" cellpadding="0" cellspacing="0">
	        	<tr>
	            	<td id="rodape">&nbsp;
	                </td>
	           </tr>
	    </table>

			<% } else {
			%>
				<p>Este relatório é valido apenas para o Injet 3.x</p>
			<%}
			%>
    </table>

</body>
</html>