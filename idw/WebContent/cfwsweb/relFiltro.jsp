
<%@page import="idw.util.Util"%>
<%@page import="idw.webservices.dto.FiltroExportacaoDTO"%>
<%@page import="idw.model.pojos.DwExpcvs"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="idw.webservices.dto.FiltrosExportacaoDTO"%>

<%@page import="java.text.SimpleDateFormat"%>
<form name="filtro" method="post" action="control?estilo=relVisualizar">
<div id="filtro1">
<fieldset>
	<legend>Gráfico</legend>
<table width=100% border=0>
	<tr></tr>
	<tr><td>Data inicial</td><td><input name="dtinicial" id="dtinicial"><button type="button" id='dataInicial'>...</button></td></tr>
	<tr><td>Data final</td><td><input name="dtfinal" id="dtfinal" ><button type="button" id='dataFinal'>...</button></td></tr>
	<tr><td>Plataforma</td><td><%=Util.getSelectGrupoProduto()%></td></tr>
	<tr>
		<td></td>
		<td colspan="3"><button type="button" onclick="javascript:appendOptionLast(document.forms[0].grupoproduto,count2++,'plataformasSel');">Adicionar</button>
		<button type="button" onclick="javascript:removeTudo('plataformasSel');appendTudo(document.forms[0].grupoproduto,count2++,'plataformasSel','TODAS AS PLATAFORMAS');">Adicionar Todos</button>		
		<button type="button" onclick="javascript:removeOptionSelected('plataformasSel');">Remover</button>
		<button type="button" onclick="javascript:removeTudo('plataformasSel');">Remover todos</button></td>
	</tr>
	<tr><td>Plataformas escolhidas</td><td><select name='plataformasSel' id='plataformasSel' multiple='multiple' size='2' style='width: 250px;'></select></td></tr>
	<tr>
		<td>Agrupamento do período</td>
		<td>
			<select name="agrupamento">
				<option value="1">Diário</option>
				<option value="2">Semanal</option>
				<option value="3">Mensal</option>
				<option value="4">Anual</option>
			</select>
		</td>
	</tr>		
	<tr></tr>
	<tr>
		<td>Apontamento no reprocesso</td>
		<td>
			<select name="apontamento">
				<option value="1">Defeito</option>
				<option value="2">Componente</option>				
			</select>
		</td>
	</tr>	
		
	<tr>
		<td></td>
		<td><input name="btnVisualizar" type="submit"  value="Visualizar"></td>
	</tr>
</table>
</fieldset>
</div>
</form>

<script type='text/javascript'>

Calendar.setup(
	{
	inputField  : 'dtinicial',
	ifFormat    : '%d/%m/%Y',
	weekNumbers : false,
	button      : 'dataInicial'
	}
);

Calendar.setup(
	{
	inputField  : 'dtfinal',
	ifFormat    : '%d/%m/%Y',
	weekNumbers : false,
	button      : 'dataFinal'
	}
);

</script>