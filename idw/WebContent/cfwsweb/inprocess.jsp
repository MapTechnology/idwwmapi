<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<style>

body {
background-image: url("../images/globo.png");
background-repeat: no-repeat;
background-position: 50% 10%; 
}

.Absolute-Center {
  margin: auto;
  margin-top: 10%;
  top: 0; left: 0; bottom: 0; right: 0;
  align: center;
  text-align: center;
  border-color: #286090;
}

.Absolute-Center.is-Responsive {
  width: 50%; 
  height: 50%;
  min-width: 400px;
  max-width: 800px;
  padding: 40px;
}
</style>
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>MAP InProcess</title>
</head>
<body>
<span id="texto_download" style="display: none"><fmt:message key="download"/></span>
<span id="texto_aguarde" style="display: none"><fmt:message key="aguarde"/></span>
<span id="texto_erro" style="display: none"><fmt:message key="msg_erro_inprocess"/></span>
<div class="panel panel-default Absolute-Center is-Responsive" style="align: center; text-align: center; border-color: #286090;">
<div class="panel-body">
<img src="../images/logo_map.png" />
  <h1 style="font-size: 4vw;"><fmt:message key="map_inprocess"/></h1>
  <p><a class="btn btn-primary btn-lg" id="btn_download" role="button" onclick="a();" download>
  <fmt:message key="gerar"/>
	</a></p>
</div>
</div>
<script type='text/javascript' src='../scripts/jquery-2.2.1.js'></script>
<script type='text/javascript' src='../scripts/bootstrap.js'></script>
<script type='text/javascript' src='../scripts/inprocess.js'></script>
</body>
</html>