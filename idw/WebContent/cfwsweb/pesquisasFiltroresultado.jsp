<%@page import="java.util.List"%>

<%
	String strValor = "";
	String strDsCampo = "Filtro";
	String strTipo = "filtro";
	String cdpt = "";
	
	PesquisasDTO resultado = IdwFacade.getInstancia().getResultadoFiltro(
			strValor, strTipo, cdpt);	
	
%>



<%@page import="idw.webservices.dto.PesquisasDTO"%>
<%@page import="idw.webservices.dto.PesquisaDTO"%>
<%@page import="idw.model.pojos.DwExpcvs"%>
<%@page import="idw.model.IdwFacade"%><br>

<div id="esquerda">
	<fieldset>
	<legend>Escolha <%=strDsCampo%></legend>
	
	<table border=1>
		<tr>
			<td></td>
			<td>ID</td>
			<td>Código</td>
			<td>Descrição</td>
		</tr>
	<%
		int i;

		if (resultado.getPesquisa() != null){
			for (PesquisaDTO linha : resultado.getPesquisa()) {
				DwExpcvs filtro = (DwExpcvs)linha.getRegistro();
		%>
				<tr>
					<td><a href="control?estilo=exportacao&idfiltro=<%=String.valueOf(filtro.getIdExpcvs()) %>"><img src="images/add.ico" alt="" height="10px" /></a></td>				
					<td><%=filtro.getIdExpcvs()%></td>
					<td><%=linha.getCodigo()%></td>
					<td><%=linha.getDescricao()%></td>
				</tr>
				
				<%
			}
		}
		%>
	 </table>
	
	<br>
	<p class="submit"><input type="button" value="Voltar" onclick="javascript:history.back();" /></p>
	
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

