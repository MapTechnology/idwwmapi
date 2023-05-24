<%@page import="idw.model.pojos.injet.Ijgrpinj"%>
<%@page import="idw.model.rn.injet.IjgrpinjRN"%>
<%@page import="idw.model.dao.injet.DAOGenericoInjet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="idw.model.rn.injet.TurnoInjetRN"%>
<%@page import="idw.model.pojos.injet.Ijtbtur"%>
<%@page import="idw.util.Util"%>
<%@page import="idw.webservices.dto.FiltroExportacaoDTO"%>
<%@page import="idw.model.pojos.DwExpcvs"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="idw.webservices.dto.FiltrosExportacaoDTO"%>
<%@page import="java.util.List" %>

<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form name="filtro" method="post"  onsubmit="return valida_date(this)" action="control?estilo=relProducaoVisualizar">
<div id="filtro1">
<fieldset>
	<legend><h3><fmt:message key="Relatório_de_Produção"/></h3></legend>

<table width=100% border=0>
	<tr></tr>
	<tr><td><fmt:message key="Data_inicial"/></td><td><input name="dtinicial" id="dtinicial"><button type="button" id='dataInicial'>...</button></td></tr>
	<tr><td><fmt:message key="Data_final"/></td><td><input name="dtfinal" id="dtfinal" ><button type="button" id='dataFinal'>...</button></td></tr>
	<tr>
		<td><fmt:message key="Turnos"/></td>
		<td>
			<select name="turnos">
				<%  
 					TurnoInjetRN turno = new TurnoInjetRN(new DAOGenericoInjet());
 					turno.iniciaConexaoBanco();
 					List<Ijtbtur> listaTurnos = turno.getTurnosCombo();  
      				for (Ijtbtur ijtbtur : listaTurnos){  
 	          			 int i = 1; 
         				 out.println("<option value= '" + ijtbtur.getCdturno() + "'>" + ijtbtur.getDsturno() + "</option>");
         				 i++;
     				}
      				turno.finalizaConexaoBanco();
				%>  
			</select>
		</td>
	</tr>

	<tr>
		<td><fmt:message key="Grupos_de_Maquinas"/></td>
		<td>
			<select name="grupoMaquinas">
				<%  
				IjgrpinjRN grupo = new IjgrpinjRN(new DAOGenericoInjet());
 					grupo.iniciaConexaoBanco();
 					List<Ijgrpinj> listaGrupoMaquinas = grupo.getGrupoMaquinasCombo();
      				for (Ijgrpinj ijgrpinj : listaGrupoMaquinas){  
 	          			
      					out.println("<option value= " + ijgrpinj.getCdgrpinj() + ">" + ijgrpinj.getDsgrpinj() + "</option>");
         				 
     				}
      				grupo.finalizaConexaoBanco();

 				%>     
			</select>
		</td>
	</tr>	
		
	<tr>
		<td></td>
		<td><input name="btnVisualizar" type="submit" value='<fmt:message key="Visualizar"/>' ></td>
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

<script type="text/javascript" language="javascript">
function valida_date(){
	if(document.getElementById("dtinicial").value == ""){
		alert('Por favor, preencha o campo Data inicial');
		document.getElementById("dtinicial").focus();
		return false;
	}
	
	if(document.getElementById("dtfinal").value == ""){
		alert('Por favor, preencha o campo Data Final');
		document.getElementById("dtfinal").focus();
		return false;
	}
	return true;
}
</script>