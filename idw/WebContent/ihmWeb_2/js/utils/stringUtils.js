function extraiPorMascara(cb , mascara){
	
	if (mascara == null) {
        return cb;
    }
	
	var codigoProduto = "";
	var iCont = 0;
	
	for ( iCont = 0; iCont < mascara.length; iCont++) {
        if (mascara[iCont] == '?') {
        	if(cb[iCont] == null){
        		return cb;
        	}
        	codigoProduto = codigoProduto + (cb[iCont]);
        }
    }
	
	return codigoProduto;
	
}

 // Local Storage para Persistencia
// https://zenorocha.com/html5-local-storage/
// Limits: https://www.html5rocks.com/en/tutorials/offline/quota-research/
// Entorno de 100Kb de tamanho dos 10Mb disponiveis
function logMsgEnviada(msgEnviada) {
	var dateTime = new Date();
	var msgsEnviadasAsString = localStorage.getItem("msgsEnviadas");
	if (msgsEnviadasAsString != null) {
		var msgsEnviadas =  JSON.parse(msgsEnviadasAsString);
		msgsEnviadas.push(dateTime.toLocaleString() + "-" + msgEnviada);
		if (msgsEnviadas.length > 1000)
			msgsEnviadas.splice(0, 1);
		msgsEnviadasAsString = JSON.stringify(msgsEnviadas);
		localStorage.setItem("msgsEnviadas", msgsEnviadasAsString);
	} else {
		var msgsEnviadas = [];
		msgsEnviadas.push(dateTime.toLocaleString() + "-" + msgEnviada);
		msgsEnviadasAsString = JSON.stringify(msgsEnviadas);
		localStorage.setItem("msgsEnviadas", msgsEnviadasAsString)
	}
}

function logConsoleLog(consoleLog) {
	var consoleLogsAsString = localStorage.getItem("consoleLogs");
	var dateTime = new Date();
	if (consoleLogsAsString != null) {
		var consoleLogs =  JSON.parse(consoleLogsAsString);
		consoleLogs.push(dateTime.toLocaleString() + "-" + consoleLog);
		if (consoleLogs.length > 500)
			consoleLogs.splice(0, 1);
		consoleLogsAsString = JSON.stringify(consoleLogs);
		localStorage.setItem("consoleLogs", consoleLogsAsString);
	} else {
		var consoleLogs = [];
		consoleLogs.push(dateTime.toLocaleString() + "-" + consoleLog);
		consoleLogsAsString = JSON.stringify(consoleLogs);
		localStorage.setItem("consoleLogs", consoleLogsAsString)
	}
}

function readLogsMsgsEnviadas(){
	var msgsEnviadasAsString = localStorage.getItem("msgsEnviadas");
	if (msgsEnviadasAsString != null) {
		return JSON.parse(msgsEnviadasAsString);
	}
	return null;
}