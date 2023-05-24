
<%@page import="idw.util.Util"%>
<%@page import="idw.webservices.dto.FiltroExportacaoDTO"%>
<%@page import="idw.model.pojos.DwExpcvs"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="idw.webservices.dto.FiltrosExportacaoDTO"%>

<%@page import="java.text.SimpleDateFormat"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type = "text/javascript" src = "scripts/funcoes.js"></script>
<script type='text/javascript' src='scripts/calendar.js'></script>
<script type='text/javascript' src='scripts/lang/calendar-br.js'></script>
<script type='text/javascript' src='scripts/calendar-setup.js'></script>
<link rel="stylesheet" href="css/estilo-web-ie.css" type="text/css">
<style type='text/css'>@import url(css/skins/aqua/theme.css);</style>

<%@page import="idw.model.IdwFacade"%><form name="filtro" method="post" action="control?estilo=filtroExportacao">
	<%
		String idFiltro = request.getParameter("idfiltro");
		String cdFiltro = "";
		String dsFiltro = "";
		String dtInicial = "";
		String hrInicial = "";
		String dtFinal = "";
		String hrFinal = "";

		String sku = "";
		String tensao = "";
		String nrSerieInicial = "";
		String nrSerieFinal = "";
		String reSupervisor = "";
		String reOperador = "";
		String pt = "";
		String componenteUtilizado = "";

		String etapa = "";
		String defeito = "";
		String fasesComfalha = "";
		String dtInicialSaidaReprocesso = "";
		String hrInicialSaidaReprocesso = "";
		String dtFinalSaidaReprocesso = "";
		String hrFinalSaidaReprocesso = "";
		String defeitoReprocesso = "";
		String acaoReprocesso = "";
		String correnteMin = "";
		String correnteMax = "";
		String tensaoMin = "";
		String tensaoMax = "";

		String fluxoE = "";
		String fluxoS = "";
		String falhas = "";
		String sucessos = "";
		String nrLinhasTotal = "";
		String nrLinhasArquivo = "";

		String modelo1 = "";
		String modelo2 = "";
		String modelo3 = "";

		String plataformasSelecionadas = "<select name='plataformasSel' id='plataformasSel' multiple='multiple' size='2' style='width: 250px;'></select>";

		if (idFiltro != null) {
			FiltroExportacaoDTO filtro = new FiltroExportacaoDTO();
			DwExpcvs dwExpcvs = new DwExpcvs();
			try {
				dwExpcvs.setIdExpcvs(Long.valueOf(idFiltro));
			} catch (Exception e) {
			}
			filtro.setFiltro(dwExpcvs);
			FiltrosExportacaoDTO filtros = IdwFacade.getInstancia().getFiltrosDTO(filtro);
			if (filtros.getFiltros().size() > 0) {
				filtro = filtros.getFiltros().get(0);
				cdFiltro = filtro.getFiltro().getCdExpcvs();
				dsFiltro = filtro.getFiltro().getDsExpcvs();
				SimpleDateFormat formatterData = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:ss");
				try {
					dtInicial = formatterData.format(filtro.getFiltro().getDthrIentrada());
					hrInicial = formatterHora.format(filtro.getFiltro().getDthrIentrada());
				} catch (Exception e) {
				}
				try {
					dtFinal = formatterData.format(filtro.getFiltro().getDthrFentrada());
					hrFinal = formatterHora.format(filtro.getFiltro().getDthrFentrada());
				} catch (Exception e) {
				}
				if (filtro.getFiltro().getSku() != null) {
					sku = filtro.getFiltro().getSku();
				}
				if (filtro.getFiltro().getComplemento() != null) {
					tensao = filtro.getFiltro().getComplemento();
				}
				if (filtro.getFiltro().getNserieincial() != null) {
					nrSerieInicial = filtro.getFiltro().getNserieincial();
				}
				if (filtro.getFiltro().getNseriefinal() != null) {
					nrSerieFinal = filtro.getFiltro().getNseriefinal();
				}
				try {
					reSupervisor = filtro.getFiltro().getOmUsrByIdUsrsupervisor().getCdUsr();
				} catch (Exception e) {
				}
				try {
					reOperador = filtro.getFiltro().getOmUsrByIdUsroperador().getCdUsr();
				} catch (Exception e) {
				}
				try {
					pt = filtro.getFiltro().getOmPt().getCdPt();
				} catch (Exception e) {
				}
				try {
					componenteUtilizado = filtro.getFiltro().getOmProduto().getCdProduto();
				} catch (Exception e) {
				}
				try {
					etapa = filtro.getFiltro().getDwFtEtapa().getCdEtapa();
				} catch (Exception e) {
				}
				try {
					defeito = filtro.getFiltro().getDwTDefeitoByIdTdefeito().getCdTdefeito();
				} catch (Exception e) {
				}
				if (filtro.getFiltro().getIsApenascomfalha() != null) {
					fasesComfalha = filtro.getFiltro().getIsApenascomfalha() ? "checked='checked'" : "";
				}
				try {
					dtInicialSaidaReprocesso = formatterData.format(filtro.getFiltro().getDthrIreprocesso());
					hrInicialSaidaReprocesso = formatterHora.format(filtro.getFiltro().getDthrIreprocesso());
				} catch (Exception e) {
				}
				try {
					dtFinalSaidaReprocesso = formatterData.format(filtro.getFiltro().getDthrFreprocesso());
					hrFinalSaidaReprocesso = formatterHora.format(filtro.getFiltro().getDthrFreprocesso());
				} catch (Exception e) {
				}
				try {
					defeitoReprocesso = filtro.getFiltro().getDwTDefeitoByIdTdefeitoreprocesso().getCdTdefeito();
				} catch (Exception e) {
				}
				try {
					acaoReprocesso = filtro.getFiltro().getDwTAcao().getCdTacao();
				} catch (Exception e) {
				}
				if (filtro.getFiltro().getCorrenteminima() != null) {
					correnteMin = filtro.getFiltro().getCorrenteminima().toString();
				}
				if (filtro.getFiltro().getCorrentemaxima() != null) {
					correnteMax = filtro.getFiltro().getCorrentemaxima().toString();
				}
				if (filtro.getFiltro().getTensaominima() != null) {
					tensaoMin = filtro.getFiltro().getTensaominima().toString();
				}
				if (filtro.getFiltro().getTensaomaxima() != null) {
					tensaoMax = filtro.getFiltro().getTensaomaxima().toString();
				}
				if (filtro.getFiltro().getStFluxoentrada() != null) {
					fluxoE = filtro.getFiltro().getStFluxoentrada().toString();
				}
				if (filtro.getFiltro().getStFluxosaida() != null) {
					fluxoS = filtro.getFiltro().getStFluxosaida().toString();
				}
				if (filtro.getFiltro().getIsApenascomfalhareprocesso() != null) {
					falhas = filtro.getFiltro().getIsApenascomfalhareprocesso() ? "checked='checked'" : "";
				}
				if (filtro.getFiltro().getIsApenassucessoreprocesso() != null) {
					sucessos = filtro.getFiltro().getIsApenassucessoreprocesso() ? "checked='checked'" : "";
				}
				if (filtro.getFiltro().getQtTotallinhas() != null) {
					nrLinhasTotal = filtro.getFiltro().getQtTotallinhas().toString();
				}
				if (filtro.getFiltro().getQtLinhasporarquivo() != null) {
					nrLinhasArquivo = filtro.getFiltro().getQtLinhasporarquivo().toString();
				}
				if (filtro.getFiltro().getTpExportacao() != null) {
					modelo1 = filtro.getFiltro().getTpExportacao().intValue() == 1 ? "selected" : "";
					modelo2 = filtro.getFiltro().getTpExportacao().intValue() == 2 ? "selected" : "";
					modelo3 = filtro.getFiltro().getTpExportacao().intValue() == 3 ? "selected" : "";
				}

				plataformasSelecionadas = filtro.getPlataformasSelecionadas();

			}
		} else {
			idFiltro = "";
		}
	%>
	<div id="filtro1">
		<fieldset>
			<legend>Exportação</legend>
			<table width=100% border=0>
				<tr></tr>
				<tr>
					<td>Id. Filtro</td>
					<td><input name="idfiltro" value="<%=idFiltro%>"></td>
				</tr>
				<tr>
					<td>Cd. Filtro</td>
					<td><input name="cdfiltro" value="<%=cdFiltro%>"></td>
				</tr>
				<tr>
					<td>Descrição</td>
					<td><input name="descricao" value="<%=dsFiltro%>"></td>
				</tr>
				<tr>
					<td>Data inicial</td>
					<td><input name="dtinicial" id="dtinicial"
						value="<%=dtInicial%>">
						<button type="button" id='dataInicial'>...</button></td>
				</tr>
				<tr>
					<td>Hora inicial</td>
					<td><input name="hrinicial" value="<%=hrInicial%>"
						maxlength="8" onchange="verifica_horas(this)"
						onkeypress="valida_horas(this, event)"></td>
				</tr>
				<tr>
					<td>Data final</td>
					<td><input name="dtfinal" id="dtfinal" value="<%=dtFinal%>">
						<button type="button" id='dataFinal'>...</button></td>
				</tr>
				<tr>
					<td>Hora final</td>
					<td><input name="hrfinal" maxlength="8" value="<%=hrFinal%>"
						onchange="verifica_horas(this)"
						onkeypress="valida_horas(this, event)"></td>
				</tr>
				<tr>
					<td>Plataforma</td>
					<td><%=Util.getSelectGrupoProduto()%></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3"><button type="button"
							onclick="javascript:appendOptionLast(document.forms[0].grupoproduto,count2++,'plataformasSel');">Adicionar</button>
						<button type="button"
							onclick="javascript:removeTudo('plataformasSel');appendTudo(document.forms[0].grupoproduto,count2++,'plataformasSel','TODAS AS PLATAFORMAS');">Adicionar
							Todos</button>
						<button type="button"
							onclick="javascript:removeOptionSelected('plataformasSel');">Remover</button>
						<button type="button"
							onclick="javascript:removeTudo('plataformasSel');">Remover
							todos</button></td>
				</tr>
				<tr>
					<td>Plataformas escolhidas</td>
					<td><%=plataformasSelecionadas%></td>
				</tr>
				<tr>
					<td>SKU</td>
					<td><%=Util.getSelectProdutoDePara("sku", sku)%></td>
				</tr>
				<tr>
					<td>Tensão/Cor/Versão</td>
					<td><%=Util.getSelectProdutoComplemento("tensao", tensao)%></td>
				</tr>
				<tr>
					<td>Número de série inicial</td>
					<td><input name="nrserieinicial" value="<%=nrSerieInicial%>"></td>
				</tr>
				<tr>
					<td>Número de série final</td>
					<td><input name="nrseriefinal" value="<%=nrSerieFinal%>"></td>
				</tr>
				<tr>
					<td>RE Supervisor</td>
					<td><input name="resupervisor" id="resupervisor"
						value="<%=reSupervisor%>">
						<button type="button"
							onclick="javascript:pesquisa('resupervisor','RE Supervisor','usuario', '');">...</button></td>
				</tr>
				<tr>
					<td>RE Operador</td>
					<td><input name="reoperador" id="reoperador"
						value="<%=reOperador%>">
						<button type="button"
							onclick="javascript:pesquisa('reoperador','RE Operador','usuario', '');">...</button></td>
				</tr>
				<tr>
					<td>PT</td>
					<td><input name="pt" id="pt" value="<%=pt%>">
						<button type="button"
							onclick="javascript:pesquisa('pt','PT','pt', '');">...</button></td>
				</tr>
				<tr>
					<td>Componente utilizado</td>
					<td><input id="componenteutilizado" name="componenteutilizado"
						value="<%=componenteUtilizado%>">
						<button type="button"
							onclick="javascript:pesquisa('componenteutilizado','Componente utilizado','produto', '');">...</button></td>
				</tr>
				<tr>
					<td>Etapa com falha</td>
					<td><%=Util.getSelectEtapa("etapa", etapa)%></td>
				</tr>
				<tr>
					<td>Defeito</td>
					<td><input name="defeito" id="defeito" value="<%=defeito%>">
						<button type="button"
							onclick="javascript:pesquisa('defeito','Defeito','defeito', '');">...</button></td>
				</tr>
				<tr>
					<td>Apenas as fases com falha</td>
					<td><input type="checkbox" name="fasescomfalha" value="true"
						<%=fasesComfalha%>></td>
				</tr>
			</table>
		</fieldset>
	</div>

	<div id="filtro2">
		<fieldset>
			<legend>Reprocesso</legend>
			<table width=100% border=0>
				<tr></tr>
				<tr>
					<td>Data inicial de saída do Reprocesso</td>
					<td><input name="dtinicialreprocesso" id="dtinicialreprocesso"
						value="<%=dtInicialSaidaReprocesso%>">
						<button type="button" id='dataInicialreprocesso'>...</button></td>
				</tr>
				<tr>
					<td>Hora inicial de saída do Reprocesso</td>
					<td><input name="hrinicialreprocesso"
						value="<%=hrInicialSaidaReprocesso%>" maxlength="8"
						onchange="verifica_horas(this)"
						onkeypress="valida_horas(this, event)"></td>
				</tr>
				<tr>
					<td>Data final de saída do Reprocesso</td>
					<td><input name="dtfinalreprocesso" id="dtfinalreprocesso"
						value="<%=dtFinalSaidaReprocesso%>">
						<button type="button" id='dataFinalreprocesso'>...</button></td>
				</tr>
				<tr>
					<td>Hora final de saída do Reprocesso</td>
					<td><input name="hrfinalreprocesso"
						value="<%=hrFinalSaidaReprocesso%>" maxlength="8"
						onchange="verifica_horas(this)"
						onkeypress="valida_horas(this, event)"></td>
				</tr>
				<tr>
					<td>Defeito no reprocesso</td>
					<td><input name="defeitoreprocesso" id="defeitoreprocesso"
						value="<%=defeitoReprocesso%>">
						<button type="button"
							onclick="javascript:pesquisa('defeitoreprocesso','Defeito no reprocesso','defeito', '');">...</button></td>
				</tr>
				<tr>
					<td>Ação no reprocesso</td>
					<td><input name="acaoreprocesso" id="acaoreprocesso"
						value="<%=acaoReprocesso%>">
						<button type="button"
							onclick="javascript:pesquisa('acaoreprocesso','Ação no reprocesso','acao', '');">...</button></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>Detalhamento dos testes</legend>
			<table width=100% border=0>
				<tr></tr>
				<tr>
					<td>Corrente minima (A)</td>
					<td><input name="correnteminima" value="<%=correnteMin%>"></td>
				</tr>
				<tr>
					<td>Corrente máxima (A)</td>
					<td><input name="correntemaxima" value="<%=correnteMax%>"></td>
				</tr>
				<tr>
					<td>Tensão minima</td>
					<td><input name="tensaominima" value="<%=tensaoMin%>"></td>
				</tr>
				<tr>
					<td>Tensão máxima</td>
					<td><input name="tensaomaxima" value="<%=tensaoMax%>"></td>
				</tr>
				<tr>
					<td>Fluxo entrada</td>
					<td><%=Util.getSelectParamEntrada("fluxoE", fluxoE)%></td>
				</tr>
				<tr>
					<td>Fluxo saída</td>
					<td><%=Util.getSelectParamSaida("fluxoS", fluxoS)%></td>
				</tr>
				<tr>
					<td>Falhas</td>
					<td><input type="checkbox" name="falhas" value="true"
						<%=falhas%>></td>
				</tr>
				<tr>
					<td>Sucessos</td>
					<td><input type="checkbox" name="sucessos" value="true"
						<%=sucessos%>></td>
				</tr>
			</table>
		</fieldset>

		<fieldset>
			<legend>Limites</legend>

			<table width=100% border=0>
				<tr></tr>
				<tr>
					<td>Número de linhas total a serem exportadas</td>
					<td><input name="nrlinhasexportadas"
						value="<%=nrLinhasTotal%>"></td>
				</tr>
				<tr>
					<td>Número de linhas por arquivo</td>
					<td><input name="nrlinhasarquivo" value="<%=nrLinhasArquivo%>"></td>
				</tr>
				<tr>
					<td>Modelo exportação</td>
					<td><select name="modeloexportacao">
							<option value="1" <%=modelo1%>>1 - Modelo resumido
								empilhado</option>
							<option value="2" <%=modelo2%>>2 - Modelo resumido
								horizontal</option>
							<option value="3" <%=modelo3%>>3 - Modelo detalhado dos
								testes</option>
					</select></td>
				</tr>

				<tr>
					<td><input id="acao" name="acao" style="visibility: hidden"></td>
					<td colspan="2"><input name="btnExportar" type="submit"
						onclick="javascript:selecionaTudo('plataformasSel');document.forms[0].acao.value='exportar'"
						value="Exportar"> <input name="btnSalvar" type="submit"
						onclick="javascript:selecionaTudo('plataformasSel');document.forms[0].acao.value='salvar'"
						value="Salvar"> <input name="btnAbrir" type="submit"
						onclick="javascript:selecionaTudo('plataformasSel');document.forms[0].acao.value='abrir'"
						value="Abrir definição prévia"></td>
				</tr>
			</table>
		</fieldset>
	</div>

</form>

<script type='text/javascript'>
	Calendar.setup({
		inputField : 'dtinicial',
		ifFormat : '%d/%m/%Y',
		weekNumbers : false,
		button : 'dataInicial'
	});

	Calendar.setup({
		inputField : 'dtfinal',
		ifFormat : '%d/%m/%Y',
		weekNumbers : false,
		button : 'dataFinal'
	});

	Calendar.setup({
		inputField : 'dtinicialreprocesso',
		ifFormat : '%d/%m/%Y',
		weekNumbers : false,
		button : 'dataInicialreprocesso'
	});

	Calendar.setup({
		inputField : 'dtfinalreprocesso',
		ifFormat : '%d/%m/%Y',
		weekNumbers : false,
		button : 'dataFinalreprocesso'
	});
</script>