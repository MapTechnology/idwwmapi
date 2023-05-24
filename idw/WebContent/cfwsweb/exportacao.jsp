<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<c:if test="${not empty param.lingua}">
	<fmt:setLocale value="${param.lingua}" scope="session" />
</c:if>

<head>

<link href="css/style.css" rel="stylesheet" type="text/css">
<style type="text/css"></style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<!-- #####################   PAGINA   ##################-->

<body>

	<!-- tabela para primeira linha -->
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td id="logo">&nbsp;</td>

			<td id="botaohome"><a class="MenuHome"
				href="control?estilo=index"> <fmt:message key="Home" />
			</a></td>


			<td id="botaoexportacao"><a class="MenuExpo"
				href="control?estilo=exportacao"> <fmt:message key="Exportação" />
			</a></td>


			<td id="botaograficogerencial"><a class="MenuTopoGrafico"
				href="control?estilo=exportacaoRel"> <fmt:message
						key="Gráfico_Gerencial" />
			</a></td>

			<td id="botaorelatproducao"><a class="MenuRelatProducao"
				href="control?estilo=relatorioProducao"> <fmt:message
						key="Relatório_de_Produção" />
			</a></td>

			<td id="botaoreprocesso"><a class="MenuReprocesso"
				href="control?estilo=reprocesso"> <fmt:message key="reprocesso" />
			</a></td>

			<td id="botaologout"><a class="MenuTopoLogout"
				href="control?estilo=logout"> Logout </a></td>


			<td id="botaoembranco">&nbsp;</td>
		</tr>

	</table>


	<!-- tabela para segunda linha -->
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td id="abaixodobotao"></td>
		</tr>

	</table>

	<!-- tabela para terceira linha -->
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td id="linha"></td>
		</tr>

	</table>


	<div>
		<h1><jsp:include page="filtro.jsp" flush="true" /></h1>
	</div>
	
	<div id="footer">
		<jsp:include page="rodape.jsp" flush="true" />
	</div>
</body>
</html>