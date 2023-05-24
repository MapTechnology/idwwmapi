<%@page import="idw.model.pojos.OmGt"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="idw.webservices.dto.PassagemDTO"%>
<%@page import="idw.webservices.dto.NaoConformidadeDTO"%>
<%@page import="idw.webservices.dto.PassagensDTO"%>
<%@page import="idw.model.IdwFacade"%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../qualidade/resultado-teste/css/test-result.css">
    <script src="../qualidade/resultado-teste/js/jquery.min.js"></script>
    <script src="../qualidade/resultado-teste/js/test-result.js"></script>

    <link rel="stylesheet" href="../qualidade/css/test-result.css">
    <script src="../qualidade/js/jquery.min.js"></script>
    <script src="../qualidade/js/test-result.js"></script>


<script type="text/javascript">

function chamar() {
	var sel = document.getElementById('cdgt');
	var cdgt = sel.options[sel.selectedIndex];
	
	var url = "dashboard-flex.jsp?cdgt=";
	url = url + cdgt.value;
	
	AltWindow = window.open(url, 'dashboard-flex','fullscreen=yes,directories=0,width='+(screen.width-10)+',height='+(screen.height-59)+',status=no,resizable=no,location=no,left=0,top=0,menubar=no,scrollbars=no')

}

</script>

</head>

<%
List<OmGt> gts = IdwFacade.getInstancia().pesquisasrOmGtDosPostosQueApontamProducao();


%>


<body height="100%">
    <div class="main">
        <div class="title center">Escolher uma LINHA para apresentação do DASHBOARD</div> 
        <div class="div-inputs center">
            <div class="div-barcode">
            	<form action = "javascript:chamar()" method="get">
	                
	                <select id="cdgt" name="cdgt" class="title center">
	                	<%for (OmGt omgt : gts) { %>
	                		<option value="<%=omgt.getCdGt()%>"><%=omgt.getCdGt()%> - <%=omgt.getDsGt()%></option>
	                	<%} %>
	                </select>
	                
	                <button class="center" type="submit">Apresentar dashboard</button>
	            </form>
            </div>
        </div>

		<p align="center">Fim da página</p>
        
    </div>
</body>
</html>