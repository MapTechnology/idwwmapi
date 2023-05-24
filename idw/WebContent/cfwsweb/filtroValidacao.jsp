<%@ page language="java" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">

<%@page import="idw.webservices.dto.UsuarioDTO"%>
<%@page import="idw.model.pojos.OmUsr"%>
<%@page import="idw.model.rn.HashMD5"%>
<%@page import="idw.webservices.dto.FiltroExportacaoDTO"%>
<%@page import="idw.model.pojos.DwExpcvs"%>
<%@page import="idw.util.Util"%>
<%@page import="idw.model.rn.DiversosRN"%>
<%@page import="idw.model.rn.DataHoraRN"%>
<%@page import="idw.model.pojos.OmPt"%>
<%@page import="idw.model.pojos.OmProduto"%>
<%@page import="idw.model.pojos.DwTDefeito"%>
<%@page import="idw.model.pojos.DwTAcao"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="idw.model.pojos.DwFtEtapa"%>
<%@page import="java.util.HashSet"%>
<%@page import="idw.model.pojos.DwExpcvspf"%>
<%@page import="java.util.Set"%>
<%@page import="idw.model.pojos.OmProgrp"%>
<%@page import="idw.model.IdwFacade"%><html>
<head>
<link rel="stylesheet" href="estilos/estilos.css" type="text/css">
<TITLE>IDW</TITLE>
</head>
<body>

<%
	String cdFiltro = request.getParameter("cdfiltro");
	String dsFiltro = request.getParameter("descricao");
	String dtInicial = request.getParameter("dtinicial");
	String hrInicial = request.getParameter("hrinicial");
	String dtFinal = request.getParameter("dtfinal");
	String hrFinal = request.getParameter("hrfinal");
	String sku = request.getParameter("sku");
	String tensao = request.getParameter("tensao");
	String nrSerieInicial = request.getParameter("nrserieinicial");
	String nrSerieFinal = request.getParameter("nrseriefinal");
	String reSupervisor = request.getParameter("resupervisor");
	String reOperador = request.getParameter("reoperador");
	String pt = request.getParameter("pt");
	String componenteUtilizado = request.getParameter("componenteutilizado");
	String etapa = request.getParameter("etapa");
	String defeito = request.getParameter("defeito");
	String fasesComfalha = request.getParameter("fasescomfalha");
	String dtInicialSaidaReprocesso = request.getParameter("dtinicialreprocesso");
	String hrInicialSaidaReprocesso = request.getParameter("hrinicialreprocesso");
	String dtFinalSaidaReprocesso = request.getParameter("dtfinalreprocesso");
	String hrFinalSaidaReprocesso = request.getParameter("hrfinalreprocesso");
	String defeitoReprocesso = request.getParameter("defeitoreprocesso");
	String acaoReprocesso = request.getParameter("acaoreprocesso");
	String correnteMin = request.getParameter("correnteminima");
	String correnteMax = request.getParameter("correntemaxima");
	String tensaoMin = request.getParameter("tensaominima");
	String tensaoMax = request.getParameter("tensaomaxima");
	String fluxoE = request.getParameter("fluxoE");
	String fluxoS = request.getParameter("fluxoS");
	String falhas = request.getParameter("falhas");
	String sucessos = request.getParameter("sucessos");
	String nrLinhasTotal = request.getParameter("nrlinhasexportadas");
	String nrLinhasArquivo = request.getParameter("nrlinhasarquivo");
	String modelo = request.getParameter("modeloexportacao");
	String acao = request.getParameter("acao");
	String[] plataformasSel = request.getParameterValues("plataformasSel");
	
	SimpleDateFormat formatterString = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat formatterStringSimples = new SimpleDateFormat("dd/MM/yyyy");
	
	FiltroExportacaoDTO filtro = new FiltroExportacaoDTO();
	DwExpcvs dwExpcvs = new DwExpcvs();
	dwExpcvs.setCdExpcvs(cdFiltro);
	dwExpcvs.setDsExpcvs(dsFiltro);
	
	try{
		if (hrInicial.equals("")) {
			dwExpcvs.setDthrIentrada(formatterString.parse(dtInicial + " 00:00:00"));
		} else {
			dwExpcvs.setDthrIentrada(formatterString.parse(dtInicial + " " + hrInicial));
		}
	}catch(Exception e){
	}
	try{
		if (hrFinal.equals(""))
			dwExpcvs.setDthrFentrada(formatterString.parse(dtFinal + " 23:59:59"));
		else
			dwExpcvs.setDthrFentrada(formatterString.parse(dtFinal + " " + hrFinal));
	}catch(Exception e){
	}
	dwExpcvs.setSku(sku);
	dwExpcvs.setComplemento(tensao);
	dwExpcvs.setNserieincial(nrSerieInicial);
	dwExpcvs.setNseriefinal(nrSerieFinal);
	dwExpcvs.setOmUsrByIdUsrsupervisor(new OmUsr());
	dwExpcvs.getOmUsrByIdUsrsupervisor().setCdUsr(reSupervisor);
	dwExpcvs.setOmUsrByIdUsroperador(new OmUsr());
	dwExpcvs.getOmUsrByIdUsroperador().setCdUsr(reOperador);
	dwExpcvs.setOmPt(new OmPt());
	dwExpcvs.getOmPt().setCdPt(pt);
	dwExpcvs.setOmProduto(new OmProduto());
	dwExpcvs.getOmProduto().setCdProduto(componenteUtilizado);
	dwExpcvs.setDwTDefeitoByIdTdefeito(new DwTDefeito());
	dwExpcvs.getDwTDefeitoByIdTdefeito().setCdTdefeito(defeito);
	dwExpcvs.setIsApenascomfalha(fasesComfalha != null);
	try{
		dwExpcvs.setDthrIreprocesso(formatterString.parse(dtInicialSaidaReprocesso + " " + hrInicialSaidaReprocesso));
	}catch(Exception e){		
	}
	try{
		dwExpcvs.setDthrFreprocesso(formatterString.parse(dtFinalSaidaReprocesso + " " + hrFinalSaidaReprocesso));
	}catch(Exception e){		
	}
	dwExpcvs.setDwFtEtapa(new DwFtEtapa());
	dwExpcvs.getDwFtEtapa().setCdEtapa(etapa);
	dwExpcvs.setDwTDefeitoByIdTdefeitoreprocesso(new DwTDefeito());
	dwExpcvs.getDwTDefeitoByIdTdefeitoreprocesso().setCdTdefeito(defeitoReprocesso);
	dwExpcvs.setDwTAcao(new DwTAcao());
	dwExpcvs.getDwTAcao().setCdTacao(acaoReprocesso);
	try{
		dwExpcvs.setCorrenteminima(BigDecimal.valueOf(Long.valueOf(correnteMin)));	
	}catch(Exception e){		
	}
	try{
		dwExpcvs.setCorrentemaxima(BigDecimal.valueOf(Long.valueOf(correnteMax)));	
	}catch(Exception e){		
	}
	try{
		dwExpcvs.setTensaominima(BigDecimal.valueOf(Long.valueOf(tensaoMin)));	
	}catch(Exception e){		
	}
	try{
		dwExpcvs.setTensaomaxima(BigDecimal.valueOf(Long.valueOf(tensaoMax)));	
	}catch(Exception e){		
	}
	try{
		dwExpcvs.setStFluxoentrada(BigDecimal.valueOf(Long.valueOf(fluxoE)));	
	}catch(Exception e){		
	}
	try{
		dwExpcvs.setStFluxosaida(BigDecimal.valueOf(Long.valueOf(fluxoS)));	
	}catch(Exception e){		
	}
	dwExpcvs.setIsApenascomfalhareprocesso(falhas != null);
	dwExpcvs.setIsApenassucessoreprocesso(sucessos != null);
	try{
		dwExpcvs.setQtTotallinhas(BigDecimal.valueOf(Long.valueOf(nrLinhasTotal)));	
	}catch(Exception e){		
	}
	try{
		dwExpcvs.setQtLinhasporarquivo(BigDecimal.valueOf(Long.valueOf(nrLinhasArquivo)));	
	}catch(Exception e){		
	}
	try{
		dwExpcvs.setTpExportacao(BigDecimal.valueOf(Long.valueOf(modelo)));	
	}catch(Exception e){		
	}
	if (plataformasSel != null && plataformasSel.length > 0){
		Set<DwExpcvspf> dwExpcvspfs = new HashSet<DwExpcvspf>();
		if (plataformasSel[0].equals("TODAS AS PLATAFORMAS")){
			DwExpcvspf dwExpcvspf = new DwExpcvspf();
			dwExpcvspf.setIdExpcfvpf(1l);
			dwExpcvspfs.add(dwExpcvspf);
		}else{
			for (String pl : plataformasSel){
				DwExpcvspf dwExpcvspf = new DwExpcvspf();
				dwExpcvspf.setIdExpcfvpf(0l);
				OmProgrp omProgrp = new OmProgrp();
				omProgrp.setCdProgrp(pl);
				dwExpcvspf.setOmProgrp(omProgrp);
				dwExpcvspfs.add(dwExpcvspf);
			}
		}
		dwExpcvs.setDwExpcvspfs(dwExpcvspfs);
	}
	
	filtro.setFiltro(dwExpcvs);
	FiltroExportacaoDTO filtroRetorno = IdwFacade.getInstancia().validarFiltro(filtro); 
	session.setAttribute("filtro",filtro);
	
	if (filtroRetorno.getResultadoEvento() > 0){
		if (filtroRetorno.getResultadoEvento() == filtroRetorno.getERRO_CDEXPCVS_INVALIDO()){
			%>
                    <script type='text/javascript'>
                        alert('Código inválido.');
                        history.back();
                    </script>
                    <%     
		}
		if (filtroRetorno.getResultadoEvento() == filtroRetorno.getERRO_DSEXPCVS_INVALIDO()){
			%>
                    <script type='text/javascript'>
                        alert('Descrição inválida.');
                        history.back();
                    </script>
                    <%     
		}		
		if (!acao.equals("exportar")){
			if (filtroRetorno.getResultadoEvento() == filtroRetorno.getERRO_FILTRO_JA_EXISTE()){
				response.sendRedirect("control?estilo=filtroSobrepor");
			}
		}
	} else {		
		if (!acao.equals("exportar")){		
			response.sendRedirect("control?estilo=filtroSalvar");
		}
	}
	if (acao.equals("exportar")){
		response.sendRedirect("control?estilo=exportaInfo");
	}
%>

</body>
</html>
