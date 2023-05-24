<%@page import="java.util.List"%>

<%
	String strID = request.getParameter("id");	
	String strValor = request.getParameter("valor");
	String strDsCampo = request.getParameter("dscampo");
	String strTipo = request.getParameter("tipo");
	String cdpt = request.getParameter("cdpt");
	
	PesquisasDTO resultado = IdwFacade.getInstancia().getResultadoFiltro(strValor, strTipo, cdpt);	
	
%>



<%@page import="idw.webservices.dto.PesquisasDTO"%>
<%@page import="idw.webservices.dto.PesquisaDTO"%>
<%@page import="idw.model.IdwFacade"%><br>

<div id="esquerda">
	<fieldset>
	<legend>Escolha <%=strDsCampo%></legend>
	
	<table border=1>
		<tr>
			<td></td>
			<td>Código</td>
			<td>Descrição</td>
		</tr>
	<%
		int i;

		if (resultado.getPesquisa() != null){
			for (PesquisaDTO linha : resultado.getPesquisa()) {		
		%>
				<tr>
					<td><a href="javascript:selecionar('<%=linha.getCodigo()%>','<%=linha.getDescricao()%>')"><img src="images/add.ico" alt="" height="10px" /></a></td>				
					<td><%=linha.getCodigo()%></td>
					<td><%=linha.getDescricao()%></td>
				</tr>
				
				<%
			}
		}
		%>
	 </table>
	
	<br>
	<p class="submit"><input type="button" value="Voltar" onclick="javascript:window.close()" /></p>
	
	</fieldset>
	
</div>



<div style='display:none'>
	<img src='css/skins/aqua/active-bg.gif' />
	<img src='css/skins/aqua/dark-bg.gif' />
	<img src='css/skins/aqua/hover-bg.gif' />
	<img src='css/skins/aqua/menuarrow.gif' />
	<img src='css/skins/aqua/normal-bg.gif' />
	<img src='css/skins/aqua/rowhover-bg.gif' />
	<img src='css/skins/aqua/status-bg.gif' />
	<img src='css/skins/aqua/title-bg.gif' />
	<img src='css/skins/aqua/today-bg.gif' />
</div>

<script language="JavaScript" type="text/javascript">
function selecionar(codigo,descricao){		
	window.opener.document.forms[0].<%=strID%>.value = codigo;	
	window.close();
}
</script>

