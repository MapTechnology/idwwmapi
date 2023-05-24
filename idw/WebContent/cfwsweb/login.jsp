<!DOCTYPE HTML PUBLIC "-//W3C//DTD 
HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="idw.servlets.CfwsServlet"%>
<%@page import="java.util.List"%>
<%@page import="idw.util.AlterarLaunchListener"%>
<%@page import="java.util.ArrayList"%>
<%@page import="idw.util.Util"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
<TITLE>IDW <%=Util.getVersao()%></TITLE>

<link href="css/estilosLogin.css" rel="stylesheet" type="text/css">
<style type="text/css">
#centertable {
	color: #000000;
}

.formulariologin {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	font-size: 14px;
	font-style: normal;
	font-weight: normal;
	color: #025889;
	height: 25px;
	border-top-color: #025889;
	border-right-color: #025889;
	border-bottom-color: #025889;
	border-left-color: #025889;
	border-color: #025889;
	width: 166px;
}

.botao {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #FFF;
	background-color: #025889;
	height: 26px;
	border: 0;
}

.form2 {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	font-size: 14px;
	font-style: normal;
	font-weight: normal;
	color: #025889;
	height: 25px;
	border-top-color: #025889;
	border-right-color: #025889;
	border-bottom-color: #025889;
	border-left-color: #025889;
	border-color: #025889;
	width: 234px;
	.
	contato
	{
	font-family
	:
	"Trebuchet MS"
	,
	Arial
	,
	Helvetica
	,
	sans-serif;
}

.contatos {
	font-size: 12px;
	font-style: normal;
	line-height: normal;
	font-weight: normal;
	font-variant: normal;
	color: #05076A;
	text-decoration: none;
}
</style>

<script type='text/javascript' src='scripts/calendar.js'></script>
<script type='text/javascript' src='scripts/lang/calendar-br.js'></script>
<script type='text/javascript' src='scripts/calendar-setup.js'></script>

<script language="Javascript"> 
	var msg = {
		  prop1: "<fmt:message key="mensagem01" />",
		  prop2: "<fmt:message key="mensagem02" />"
		 };
	var javawsInstalled = 0;  
	isIE = "false";  
	if (navigator.mimeTypes && navigator.mimeTypes.length) {  
		x = navigator.mimeTypes['application/x-java-jnlp-file'];
		if (x) javawsInstalled = 1;  
	} else {  
		isIE = "true";  
	}  

	function insertLink() {  
		
		if (javawsInstalled) {  
// 			return "Para os cadastros e monitoriza&ccedil;&atilde;o.<br>Acesse o icone abaixo.";  
			return msg.prop2;
  		} else {  
			return msg.prop1; 
		}  
	}  
</script>

</head>

<!-- #####################   PAGINA   ##################-->
<body onload=javascript:document.forms[0].login.focus();>
	<%
		String mensagem;

		try {
			mensagem = request.getParameter("erro");
			
			if (mensagem.equals(null))
				mensagem = "&nbsp";
		} catch (NullPointerException e) {
			mensagem = "&nbsp";
		}
	%>
	<div id="totalContainer">
		<form action="control?estilo=loginValidacao" method="post"
			name="Form1">
			<div id="page_border">
				<div id="header">
					
					<div id="contato">
					
						<a  class="espanhol"
							href="/idw/mudaidioma?lingua=pt"
							style="text-decoration: none"><fmt:message key="Português"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					
						<a  class="espanhol"
							href="/idw/mudaidioma?lingua=es"
							style="text-decoration: none"><fmt:message key="Espanhol"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					
						<a  class="espanhol"
							href="/idw/mudaidioma?lingua=en"
							style="text-decoration: none"><fmt:message key="Inglês"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>

						<a class="contato"
							href="http://www.maptechnology.com.br/novo/faleconosco.php"
							style="text-decoration: none"><fmt:message key="Contato"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					</div>
					<div id="content_header">
						<div id="versao_titulo">
							<label>IDW <%=Util.getVersao()%></label> <label><fmt:message key="Exportação_e_Relatório"/></label>
						</div>
						<div id="login">
							<span id="login_titulo"><fmt:message key="Login_de_acesso_ao_sistema"/></span> <span
								id="login_texto"><fmt:message key="Login"/></span> <input name="login" type="text"
								class="form2" id="textbox"> <span id="login_texto"><fmt:message key="Senha"/></span>
							<input name="senha" type="password" class="formulariologin"
								id="textbox2"> <input name="Entrar" type="submit"
								class="botao" value='<fmt:message key="Entrar"/>'> <span id="texto_vermelho"><%=mensagem%></span>
						</div>
					</div>
				</div>
				<div id="content">
					<div id="content_body">
						<div id="mensagem">
							<script>document.write(insertLink());</script>
						</div>
						<div id="download">
							<%
							if (AlterarLaunchListener.listaJnlps != null && AlterarLaunchListener.listaJnlps.size() > 0) {
								for (String url : AlterarLaunchListener.listaJnlps) {
 							%> 
									<div id="col1">
										<div id="idw_icon"></div>
										<div id="textoCinza">
											<a class="download"
												href="<%=url%>">&nbsp;IDW<br>
												<i> <fmt:message key="Desktop_via"/><%= " " +url.substring(10)%></i><span> <fmt:message key="msg01"/> </span>
											</a>
										</div>
									</div>
							<%
								} //end for
							} else {
							%>
								<div id="col1">
									<div id="idw_icon"></div>
									<div id="textoCinza">
										<a class="download" href="jws/launch.jnlp">IDW <i>Desktop</i>
											<span> <fmt:message key="msg01"/> </span>
										</a>
									</div>
								</div>
							<% } //endif %>
							
							<div id="col2">
								<div id="referencia_icon"></div>
								<div id="textoCinza">
									<a class="download" href="manuais/GuiaReferenciaIDW.pdf">
										<fmt:message key="Guia_de_referência"/><span><fmt:message key="msg03"/></span>
									</a>
								</div>								
							</div>

							<div id="col3">
								<div id="setup_icon"></div>
								<div id="textoCinza">
									<a class="download" href="install/SetupColetaFujiFlex.msi"><fmt:message key="Setup_coleta_FujiFlex"/>&nbsp;&nbsp;
									<span><fmt:message key="msg04"/> </span>
									</a>
								</div>								
							</div>
							
							<div id="col3">
								<div id="setup_icon"></div>
								<div id="textoCinza">
									<a class="download" href="install/ColetaPanasonicSetup.msi"><fmt:message key="Setup_coleta_Panasonic"/>
									<span> <fmt:message key="msg05"/> </span>
									</a>
								</div>
							</div>
							
							<div id="col1">
								<div id="ce_icon"></div>								
								<div id="textoCinza">
									<a class="download" href="install/CFDeploy.CAB"><fmt:message key="CF_WindowsCE"/>
									<span> <fmt:message key="msg06"/> </span>
									</a>
								</div>
							</div>

							<div id="col1">
								<div id="ce_icon"></div>								
								<div id="textoCinza">
									<a class="download" href="install/CFDeploySYMBOLMC65.CAB"><fmt:message key="CF_SYMBOLMC65"/>
									<span> <fmt:message key="msg22"/> </span>
									</a>
								</div>
							</div>
							
							<div id="col1">
								<div id="ce_icon"></div>								
								<div id="textoCinza">
									<a class="download" href="install/CFDeployPIDION.CAB"><fmt:message key="CF_PIDION"/>
									<span> <fmt:message key="msg21"/> </span>
									</a>
								</div>
							</div>

							
							<div id="col2">
								<div id="setup_icon"></div>
								<div id="textoCinza">
									<a class="download" href="install/ColetaDiscretaSetup.CAB"><fmt:message key="Coleta_Discreta_Setup"/>&nbsp;&nbsp;
									 <span> <fmt:message key="msg07"/> </span>
									</a>
								</div>								
							</div>		
							<div id="col3">
								<div id="java_icon"></div>
								<div id="textoCinza">
									<a class="download" href="jws/jre.zip"><fmt:message key="Java_Runtime_Environment"/>&nbsp;&nbsp;
									<span> <fmt:message key="msg08"/> </span>
									</a>
								</div>
							</div>
								
							<div id="col3">
								<div id="ce_icon"></div>								
								<div id="textoCinza">
									<a class="download" href="install/CLDeploy.CAB"><fmt:message key="CL_WindowsCE"/>
									<span> <fmt:message key="msg10"/> </span>
									</a>
								</div>
							</div>					
							<div id="col3">
								<div id="ce_icon"></div>								
								<div id="textoCinza">
									<a class="download" href="install/CLDeployPIDION.CAB"><fmt:message key="CL_PIDION"/>
									<span> <fmt:message key="msg20"/> </span>
									</a>
								</div>
							</div>					

							<div id="col3">
								<div id="ihmandroid"></div>								
								<div id="textoCinza">
									<a class="download" href="install/IdwAndroid125.1.apk"><fmt:message key="IHM_Android"/>
										<span> <span> <fmt:message key="msg09"/> </span>
									</a>
								</div>
							</div>					

							<div id="col3">
								<div id="smedandroid"></div>								
								<div id="textoCinza">
									<a class="download" href="install/SetupSMED205.apk"><fmt:message key="SMED_para_Android"/>
										<span><fmt:message key="msg11"/> </span>
									</a>
								</div>
							</div>
							<div id="col3">
								<div id="cbihm"></div>								
								<div id="textoCinza">
									<a class="download" href="install/LeitorCBIHM_v112.apk"><fmt:message key="leitor_cb_ihm"/>
										<span><fmt:message key="msg12"/> </span>
									</a>
								</div>
							</div>
							<div id="col3">
								<div id="cfandroid"></div>								
								<div id="textoCinza">
									<a class="download" href="install/CheckFeederV1.9.apk"><fmt:message key="cf_android"/>
										<span><fmt:message key="msg13"/> </span>
									</a>
								</div>
							</div>
							<div id="col3">
								<div id="clandroid"></div>								
								<div id="textoCinza">
									<a class="download" href="install/CheckLevelV1.19.apk"><fmt:message key="cl_android"/>
										<span><fmt:message key="msg14"/> </span>
									</a>
								</div>
							</div>
							
							
							<div id="col3">
								<div id="ihmweb"></div>								
								<div id="textoCinza">
									<a class="download" href="/idw/ihmWeb/indexIHM.html"><fmt:message key="ihmweb"/>
										<span><fmt:message key="msg15"/> </span>
									</a>
								</div>
							</div>
							
							<div id="col3">
								<div id="ihmweb"></div>								
								<div id="textoCinza">
									<a class="download" href="/idw/ihmWeb_2/indexIHM.html"><fmt:message key="ihmweb_2"/>
										<span><fmt:message key="msg15"/> </span>
									</a>
								</div>
							</div>
							
							<div id="col3">
								<div id="ihmweb"></div>								
								<div id="textoCinza">
									<a class="download" href="/idw/ihmWeb_3/indexIHM.html">IHM-Injet 3 via Web
										<span> IHM-Injet 3 via Web </span>
									</a>
								</div>
							</div>
							
							
							<div id="col3">
								<div id="bt"></div>								
								<div id="textoCinza">
									<a class="download" href="install/ColetaBluetoothTXTSetup.msi"><fmt:message key="coletabt"/>
										<span><fmt:message key="msg16"/> </span>
									</a>
								</div>
							</div>
							
							
						</div>						
					</div>

				</div>
				<div id="rodape">Map Technology &nbsp;2006-2019. <span><fmt:message key="Todos_os_direitos_reservados"/></div>
			</div>

		</form>
	</div>
</body>

</html>