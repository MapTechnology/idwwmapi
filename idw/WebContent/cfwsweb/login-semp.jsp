<!DOCTYPE HTML PUBLIC "-//W3C//DTD 
HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="idw.servlets.CfwsServlet"%>
<%@page import="java.util.List"%>
<%@page import="idw.util.AlterarLaunchListener"%>
<%@page import="java.util.ArrayList"%>
<%@page import="idw.util.Util"%>


<html>

<head>
<TITLE>Semp-Toshiba IDW <%=Util.getVersao()%></TITLE>

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
			return "Para os cadastros e monitoriza&ccedil;&atilde;o.<br>Acesse o icone abaixo.";  
  		} else {  
			return "Você precisa instalar o Java Web Start para poder acessar o icone abaixo.";  
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
						<a class="contato"
							href="http://www.maptechnology.com.br/novo/faleconosco.php"
							style="text-decoration: none">Contato&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					</div>
					<div id="content_header">
						<div id="versao_titulo">
							<label>Semp-Toshiba-IDW <%=Util.getVersao()%></label> <label>Exporta&ccedil;&atilde;o
								e Relat&oacute;rio</label>
						</div>
						<div id="login">
							<span id="login_titulo">Login de acesso ao sistema</span> <span
								id="login_texto">Login</span> <input name="login" type="text"
								class="form2" id="textbox"> <span id="login_texto">Senha</span>
							<input name="senha" type="password" class="formulariologin"
								id="textbox2"> <input name="Entrar" type="submit"
								class="botao" value="Entrar"> <span id="texto_vermelho"><%=mensagem%></span>
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
												href="<%=url%>">&nbsp;Semp-Toshiba IDW<br>
												&nbsp;<i>Desktop via <%=url.substring(4, 20)%></i><span> "Acionar esse icone para acessar a versão 
												Desktop do Semp-Toshiba IDW. Nessa versão será possível acessar todos
												os recursos do sistema." </span>
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
										<a class="download" href="jws/launch.jnlp">Semp-Toshiba IDW <i>Desktop</i>
											<span> "Acionar esse icone para acessar a versão
												Desktop do Semp-Toshiba IDW. Nessa versão será possível acessar todos
												os recursos do sistema." </span>
										</a>
									</div>
								</div>
							<% } //endif %>
							
							<div id="col1">
								<div id="referencia_icon"></div>
								<div id="textoCinza">
									<a class="download" href="manuais/GuiaReferenciaIDW.pdf">
										Guia&nbsp;de&nbsp;refer&ecirc;ncia<span>"Manual
										Completo para utilização da versão desktop do Semp-Toshiba IDW."</span>
									</a>
								</div>								
							</div>

							<div id="col2">
								<div id="setup_icon"></div>
								<div id="textoCinza">
									<a class="download" href="install/ColetaFujiFlexSetup.msi">Setup
										coleta FujiFlex&nbsp;&nbsp;<span>"Instalador para
											Windows do módulo de coleta das máquinas de inserção
											automática de componentes da marca Fuji." </span>
									</a>
								</div>								
							</div>
							
							<div id="col3">
								<div id="setup_icon"></div>
								<div id="textoCinza">
									<a class="download" href="install/ColetaPanasonicSetup.msi">Setup
										coleta Panasonic<span>"Instalador para Windows do
											módulo de coleta das máquinas de inserção automática da marca
											Panasonic ." </span>
									</a>
								</div>
							</div>
							
							<div id="col1">
								<div id="ce_icon"></div>								
								<div id="textoCinza">
									<a class="download" href="install/CFDeploy.CAB">CF
										WindowsCE<span>"Instalador para o programa de
										coleta do módulo CheckFeeder. Esse instalador serve apenas
										para o Windows CE 5.0." </span>
									</a>
								</div>
							</div>
							
							<div id="col2">
								<div id="setup_icon"></div>
								<div id="textoCinza">
									<a class="download" href="install/ColetaDiscretaSetup.CAB">Coleta
										Discreta Setup&nbsp;&nbsp; <span>"Instalador para
											Windows CE da app Coleta Discreta para o Semp-Toshiba IDW." </span>
									</a>
								</div>								
							</div>		
							<div id="col3">
								<div id="java_icon"></div>
								<div id="textoCinza">
									<a class="download" href="jws/jre.zip">Java Runtime
										Environment&nbsp;&nbsp;<span>"Instalador JRE para
											executação de aplicativos Java"</span>
									</a>
								</div>
							</div>
								
							<div id="col3">
								<div id="ce_icon"></div>								
								<div id="textoCinza">
									<a class="download" href="install/CLDeploy.CAB">CL
										WindowsCE<span>"Instalador para o CheckLevel. Esse instalador serve apenas
										para o Windows CE 5.0." </span>
									</a>
								</div>
							</div>					

							<div id="col3">
								<div id="ihmandroid"></div>								
								<div id="textoCinza">
									<a class="download" href="install/Idw Android_1.15.apk">IHM Android
										<span>"Instalador para o IHM em android. Esse instalador serve apenas para o Android 4.2 ou superior." </span>
									</a>
								</div>
							</div>					

						</div>						
					</div>

				</div>
				<div id="rodape">Semp-Toshiba &nbsp;2006-2014. Todos os
					direitos reservados</div>
			</div>

		</form>
	</div>
</body>

</html>