
<%@page import="idw.webservices.dto.UsuarioDTO"%>
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

HttpSession sessao = request.getSession(true);
sessao.getAttribute("sessaousuario");
UsuarioDTO sessaoUsuario = null;
sessaoUsuario = (UsuarioDTO) sessao.getAttribute("sessaousuario");
String login = sessaoUsuario.getUsuario().getLogin();
long idUsr = sessaoUsuario.getUsuario().getIdUsr();

String ns = request.getParameter("ns");
String cdpt = "REP_IM";
String cdcp = "OPREPROCESSO";
String posicoesMecanicas = request.getParameter("posicaomecanica");
String cdcausa = request.getParameter("cdcausa");
String acao = request.getParameter("cdacao");
String cdarea = request.getParameter("cdarea");
String cddefeito = request.getParameter("cddefeito");
Long idPassagem = new Long(request.getParameter("idpassagem"));
Long idPassdef = new Long(request.getParameter("idpassdef"));

PassagemDTO passagem = new PassagemDTO();

passagem.setCb(ns);
passagem.setCdPt(cdpt);
passagem.setDtHrEvento(DataHoraRN.getDataHoraAtual());
passagem.setCdOp(cdcp);
passagem.setResultado(new ResultadoDTO());
passagem.getResultado().setIdmensagem(1); // com sucesso
passagem.setPosicoesMecanicas(posicoesMecanicas);
passagem.setTppt((int) OmTpptTemplate.Type.PRE.getId());
passagem.setCdCausa(cdcausa);
passagem.setIdUsr(idUsr);

DefeitoDTO defeitodto = new DefeitoDTO();

defeitodto.setIdPassagem(idPassagem);
defeitodto.setIdPassdef(idPassdef);

defeitodto.setIdTppt(OmTpptTemplate.Type.PRE.getId());
defeitodto.setCdAreaResponsavel(cdarea);
defeitodto.setCdDefeito(cddefeito);
defeitodto.setLogin(login);

AcaoDTO acaodto = new AcaoDTO();
acaodto.setCb(acao); // codigo da acao
acaodto.setComponente(null);
acaodto.setDefeito(defeitodto);
acaodto.setIdTppt(OmTpptTemplate.Type.PRE.getId());

passagem.getListaAcoes().add(acaodto);

try {
	PassagemDTO dto = IdwFacade.getInstancia().postoReprocesso(passagem);
	if (dto.getResultado().getIdmensagem() == dto.getResultado().getCOM_SUCESSO()) {
%>
	<p>Conserto realizado com sucesso.</p>
	<input type="submit" value="Voltar"/>
<%
	} else {
%>
	<p>FALHOU ERRO motivo. <%=dto.getResultado().getDescricaoMensagem()%></p>
	<input type="submit" value="Voltar"/>
<%		
	}
} catch (Exception e) {
		e.printStackTrace();
	%>
		<p>FALHOU ERRO motivo. <%=e.getMessage()%></p>
		<input type="submit" value="Voltar"/>
	<%		
}
%>

</form>