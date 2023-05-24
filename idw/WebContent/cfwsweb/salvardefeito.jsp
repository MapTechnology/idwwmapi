
<%@page import="idw.model.pojos.template.OmTpptTemplate"%>
<%@page import="idw.webservices.dto.DefeitoDTO"%>
<%@page import="idw.webservices.dto.ResultadoDTO"%>
<%@page import="idw.model.rn.DataHoraRN"%>
<%@page import="idw.webservices.dto.PassagemDTO"%>
<%@page import="idw.util.Util"%>
<%@page import="java.math.BigDecimal"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="scripts/funcoes.js"></script>
<link rel="stylesheet" href="css/estilo-web-ie.css" type="text/css">
<style type='text/css'>
@import url(css/skins/aqua/theme.css);
</style>

<%@page import="idw.model.IdwFacade"%>

<form name="filtro" method="post" action="control?estilo=reprocesso">

<%

String ns = request.getParameter("ns");
String cdpt = "REP_IM";
String cdcp = "";
String posicoesMecanicas = request.getParameter("posicaomecanica");
String cdarea = request.getParameter("cdarea");
String cddefeito = request.getParameter("cddefeito");
String qtde = "0"; // Para nao contar producao quando for informado apenas defeito.


try {
	IdwFacade.getInstancia().regristrarTesteDefeito(
			cdpt, 
			cdcp, 
			ns, 
			DataHoraRN.getDataHoraAtual(), 
			cddefeito, 
			qtde, 
			cdarea, 
			posicoesMecanicas);
			
%>
	<p>Novo defeito realizado com sucesso.</p>
		<input type="button" value="Voltar" onclick="javascript:window.close()" />
<%		
} catch (Exception e) {
		e.printStackTrace();
	%>
		<p>FALHOU novo defeito. <%=e.getMessage()%></p>
		<input type="button" value="Voltar" onclick="javascript:window.close()" />
	<%		
}
%>

</form>