<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="idw.model.rn.DataHoraRN"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Collections" %>
<%@page import="java.util.Comparator" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.text.DateFormat"%>
<%@page import="idw.util.Util"%>
<%@page import="idw.model.IdwFacade"%>
<%@page import="idw.model.pojos.DwConsolid"%>
<%@page import="idw.model.pojos.DwTurno" %>
<%@page import="idw.model.pojos.OmGt" %>
<%@page import="idw.model.pojos.OmPt" %>
<%@page import="idw.model.rn.PTRN" %>
<%@page import="idw.webservices.dto.GTsDTO"%>
<%@page import="idw.webservices.dto.GtDTO"%>
<%@page import="idw.webservices.dto.GtRtDTO" %>
<%@page import="idw.webservices.dto.GtRtMonitorizacaoDTO" %>
<%@page import="idw.webservices.dto.ObjRtMonitorizacaoDTO" %>
<%@page import="idw.webservices.dto.TurnoAtualDTO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IDW <%=Util.getVersao()%></title>
<script type='text/javascript' src='/idw/scripts/getElementsByClassName.js'></script>
<script type='text/javascript' src='/idw/scripts/tvScaleSize.js'></script>
<%
if(request.getParameter("cdgt") != null && !request.getParameter("cdgt").equals("")) {

String cdgt = request.getParameter("cdgt");

OmGt omgtFiltro = new OmGt();
omgtFiltro.setCdGt(cdgt);

GtDTO gtdto = IdwFacade.getInstancia().getOmGtPorIdOuCd(omgtFiltro);

GtRtDTO gtrtFiltro = new GtRtDTO();
gtrtFiltro.setGtDTO(gtdto);

GtRtDTO gtrtDTO = IdwFacade.getInstancia().getGtRtDTO(gtrtFiltro);

Date date = new Date();
TurnoAtualDTO turnoAtual = IdwFacade.getInstancia().getTurnoAtualGtDTO(gtdto.getGt(), date);

gtrtDTO.setDtReferencia(turnoAtual.getDtReferencia());
gtrtDTO.setDwTurno(turnoAtual.getDwturno());
gtrtDTO.setFiltroOP(0);
gtrtDTO.setIsTurnoAtual(true);
boolean is5Celulas=true;
List<ObjRtMonitorizacaoDTO> objs = new ArrayList<ObjRtMonitorizacaoDTO>();
GtRtMonitorizacaoDTO gtrtMonitorizacao = IdwFacade.getInstancia().getGtRtMonitorizacaoDTO(gtrtDTO);
if(gtrtMonitorizacao != null && gtrtMonitorizacao.getObjsRtMonitorizacaoDTO() != null) {
	objs = gtrtMonitorizacao.getObjsRtMonitorizacaoDTO().getObjsRtMonitorizacao();
	if(objs != null)
		is5Celulas = objs.size() <= 5;
}

%>

<style>
html { height:100%; }
body { position:absolute; top:0; bottom:0; right:0; left:0; }
p {
	overflow: hidden; 
	text-overflow: ellipsis;
	white-space: nowrap;
}
p.celulaText {
	font-family: Verdana, sans-serif;
	margin: auto; 
	padding: 0px;
}

p.celulaSize1 {
}
p.celulaSize2 {
}
p.celulaSize3 {
}

p.celulaLeft {
	<%=is5Celulas ? "float: left;width: 50%;" : ""%>
}
p.celulaRight {
	<%=is5Celulas ? "float: right;width: 50%;" : ""%>	
}

span.desc {
	font-size: 70%;
}

div.celula {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
	border: 1px solid black;
	width:<%=is5Celulas ? "50%" : "25%"%>;
	height:33%;
	display: block;
	float: left;
}
.corParada {
	background:#FF3737;
}
.corAcimaDaMedia {
	background:#50FF50;
}
.corAbaixoDaMedia {
	background:#EEEE00;
}
.corSemOP {
	background:#0D6AC8;
	color: white;
}
.corInativa {
	background:#000000;
}
div.turno {
    box-sizing: border-box;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
	border: 1px solid black; 
	background-color: #A4A4A4;
	width:50%;
	height:33%;
	display: block;
	float: left;
}

p.turnoText1 {
	font-family: Verdana;
	margin: 0px; 
	padding: 0px;
}
p.turnoText2 {
	font-family: Verdana, sans-serif;
	margin: 0px; 
	padding: 0px;
}

p.turnoText3 {
	font-family: Verdana, sans-serif;
	margin: 0px; 
	padding: 0px;
}
</style>
</head>
<body style="background:black; padding: 0px; margin: 0px;">
<div style="width: 100%; height: 100%">
<%
Collections.sort(objs, new Comparator<ObjRtMonitorizacaoDTO>() {

    public int compare(ObjRtMonitorizacaoDTO o1, ObjRtMonitorizacaoDTO o2) {
    	//null eh inferior a caracteres
    	if(o1.getCdPt() == null && o2.getCdPt() != null)
    		return -1;
    	else if(o1.getCdPt() != null && o2.getCdPt() == null)
    		return 1;
    	else if(o1.getCdPt() == null && o2.getCdPt() == null)
    		return 0;
    	return o1.getCdPt().compareTo(o2.getCdPt());
    }
});
int i=0;
for(ObjRtMonitorizacaoDTO obj : objs) {
	if(i >= 10) {
		break;
	}
	if(obj == null) {
		//ignorar obj null e nao contar com ele
		//pois ira atrapalhar na geracao das celulas complementares(as pretas)
		continue;
	}
	
	String cdPt = obj.getCdPt();
	if(cdPt == null || cdPt.equals("") == true) {
		//ignorar cdPt null e nao contar com ele
		//pois ira atrapalhar na geracao das celulas complementares(as pretas)
		continue;
	}
	i++;
	//OEE padrao
	Double indiceOEE = obj.getIndOEE();
	if(indiceOEE == null) {
		indiceOEE = new Double("85.00");
	}

	//RN para definir cor do background da celula
	String cor = "corInativa";
	if(obj.isOffline() == true) {
		cor = "corInativa";
	} else if(obj.isTemPlanejamento() == false) {
		cor = "corSemOP";
	} else if(obj.isParada() == true) {
		cor = "corParada";
	} else if(obj.getProdutividadeOEE() >= indiceOEE) {
		cor = "corAcimaDaMedia";
	} else {
		cor = "corAbaixoDaMedia";
	}
	
	//Pegar OEE em execucao com 2 casas decimais
	String oeeBD;
	if(obj.getProdutividadeOEE() != null && obj.isTemPlanejamento() == true) {
		oeeBD = String.format("%.2f", obj.getProdutividadeOEE());
	} else {
		oeeBD = "0.00";
	}
	
	//Sem produto pode significar sem OP, colocar uma msg para nao ficar vazio
	String dsProduto = (obj.getDsProduto() == null || obj.getDsProduto().equals("") == true) ? "SEM PRODUTO" : obj.getDsProduto();
	if(obj.isTemPlanejamento() == false) {
		dsProduto = "SEM OP";
	}
	
	//Producao Bruta e Producao refugada nesse turno da ultima OP
	long prod = 0;
	long ref = 0;
	if(obj.getProducaoLiquida() != null && obj.isTemPlanejamento() == true) {
		prod = obj.getProducaoLiquida().longValue();
	}
	if(obj.getProducaoRefugada() != null && obj.isTemPlanejamento() == true) {
		ref = obj.getProducaoRefugada().longValue();
	}
	
	Date iniTurno = gtrtMonitorizacao.getTurnoReferencia().getDtHrITurno();
	long msPastTime = DataHoraRN.getQuantidadeMilisegundosNoPeriodo(iniTurno, date);

	if(msPastTime < 0)
		System.out.println("JSP inicio turno = " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(iniTurno) + " atual = " + DataHoraRN.dateToStringYYYYMMDDHHMMSS(date) + " msPastTime= " + msPastTime);

	//Pegar a producao desse turno e usar como para calcular media hora
	long prodMedHora =  1000*60*60*prod/msPastTime;
	
	%>
	<div id="pt<%=i%>" class="celula <%=cor%>">
	<p class="celulaText celulaSize1" align="center"><%=obj.getCdPt() %></p>
	<p class="celulaText celulaSize3"><span class="desc">OEE: </span><span><%=oeeBD %>%</span></p>
	<p class="celulaText celulaSize3"><%=dsProduto%></p>
	<p class="celulaText celulaSize3"><span class="desc">MEDIA/HORA: </span><span><%=prodMedHora%></span></p>
	<p class="celulaText celulaSize3 celulaLeft"><span class="desc">APROVADOS: </span><span><%=prod%></span></p>
	<p class="celulaText celulaSize3 celulaRight"><span class="desc">REPROVADOS: </span><span><%=ref%></span></p>
	</div>
	<%
}

//Complementa com celulas pretas(inativas) para fechar a formatacao
for(i++;i<=(is5Celulas ? 5 : 10);i++) {
	%>
	<div id="pt<%=i%>" class="celula corInativa">
	<p class="celulaText celulaSize1" align="center">SEM PT</p>
	<p class="celulaText celulaSize3"><span class="desc">OEE: </span><span>%</span></p>
	<p class="celulaText celulaSize3">SEM PRODUTO</p>
	<p class="celulaText celulaSize3"><span class="desc">MEDIA/HORA: </span><span>0</span></p>
	<p class="celulaText celulaSize3 celulaLeft"><span class="desc">PROD.: </span><span>0</span></p>
	<p class="celulaText celulaSize3 celulaRight"><span class="desc">REF.: </span><span>0</span></p>
	</div>
	<%
	
}
//DateFormat dtFormat = dtFormat.format(date)
//
//
String hora = new SimpleDateFormat("kk:mm").format(date);
String data = new SimpleDateFormat("dd/MM/yyyy").format(date);
%>
	<div id="turno" class="turno">
	<p align="center" class="turnoText1"><%=gtrtMonitorizacao.getTurnoReferencia().getDwturno().getDsTurno() %></p>
	<p align="center" class="turnoText2"><%=hora%></p>
	<p align="center" class="turnoText3"><%=data%></p>
	</div>
	</div>
</body>
<script>
scaleFontSizeCelulas(<%=is5Celulas%>);
window.addEventListener('resize', function(){scaleFontSizeCelulas(<%=is5Celulas%>)}, true);
setTimeout("location.reload(true);",30000);
</script>
<%
}else {
%>
<style>
.botaoGT {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	color: #FFF;
	text-decoration: none;
	text-align: center;
	
	display: block;
	width:45%;
	height:33%;
	float: left;
	margin: 0;
	border: 1px solid #FFF;
	background-color: #025889;
	
}
.headerGTs {
	text-align: center;
}
</style>
</head>
<body style="padding: 0px; margin: 0px;">
<h1 class="headerGTs">Relação de GT's para monitorização</h1>
<%

GTsDTO gts = IdwFacade.getInstancia().getGTsComLayoutDTO(null);
	for (GtDTO gt : gts.getGts()){
	%>
	<a  class="botaoGT" href="/idw/cfwsweb/monitorizacao.jsp?cdgt=<%=gt.getGt().getCdGt()%>">
					<%=gt.getGt().getCdGt()%>
	</a>
		
	<%
	}
	%>
</body>
<script>
scaleSizeMenuGT();
window.addEventListener('resize', function(){scaleSizeMenuGT()}, true);
</script>

<%
}
%>

</html>


