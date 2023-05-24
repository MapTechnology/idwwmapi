
<%@page import="idw.model.pojos.template.OmTpptTemplate"%>
<%@page import="idw.webservices.dto.AcaoDTO"%>
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
String cdcp = "OPREPROCESSO";
String cdRefugo = request.getParameter("cdrefugo");

PassagemDTO passagem = new PassagemDTO();

passagem.setCb(ns);
passagem.setCdPt(cdpt);
passagem.setDtHrEvento(DataHoraRN.getDataHoraAtual());
passagem.setCdOp(cdcp);
passagem.setResultado(new ResultadoDTO());
passagem.getResultado().setIdmensagem(1); // com sucesso
passagem.setTppt((int) OmTpptTemplate.Type.PRE.getId());

passagem.setCdRefugo(cdRefugo);
passagem.setEnviarRefugo(1); // setar como refugo. Com isso um evento em ms_evt deve ser lancado

try {
	PassagemDTO dto = IdwFacade.getInstancia().postoReprocesso(passagem);
	if (dto.getResultado().getIdmensagem() == dto.getResultado().getCOM_SUCESSO()) {
%>
	<p>Refugo realizado com sucesso.</p>
		<input type="button" value="Voltar" onclick="javascript:window.close()" />
<%
	} else {
%>
	<p>FALHOU Refugo motivo. <%=dto.getResultado().getDescricaoMensagem()%></p>
		<input type="button" value="Voltar" onclick="javascript:window.close()" />
<%		
	}
} catch (Exception e) {
		e.printStackTrace();
	%>
		<p>FALHOU ERRO motivo. <%=e.getMessage()%></p>
		<input type="button" value="Voltar" onclick="javascript:window.close()" />
	<%		
}
%>

</form>