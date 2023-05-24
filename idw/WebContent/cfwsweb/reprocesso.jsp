<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form name="filtro" method="post" action="control?estilo=naoconformidades">
	<div id="filtro1">
		<fieldset>
			<legend><h3><fmt:message key="lerns"/></h3></legend>
			<input name="nsLido"/>
		</fieldset>
		
		<p class="submit">
			<input type="submit" value="Visualizar não conformidades"/>
			<input type="button" value="Voltar" onclick="javascript:history.back()" />
		</p>
		
	</div>
</form>