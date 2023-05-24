var getDataAtual = function(horas){
	var retorno = "";
	var d = new Date();
	d.setHours(d.getHours() + horas);
	retorno = zeroEsquerda(d.getDate()) + "-" + zeroEsquerda(d.getMonth()+1) + "-" + zeroEsquerda(d.getFullYear()) +
			  " " + zeroEsquerda(d.getHours()) + ":" + zeroEsquerda(d.getMinutes()) + ":" + zeroEsquerda(d.getSeconds()) + ":00" ;
	return retorno;
}

var zeroEsquerda = function(valor){
	var retorno = valor;
	if(valor < 10 && valor >= 0){
		retorno = "0" + valor;
	}
	return retorno;
}

var getDataAtualRep = function(horas){
	var retorno = "";
	var d = new Date();
	d.setHours(d.getHours() + horas);
	retorno = zeroEsquerda(d.getDate()) + "/" + zeroEsquerda(d.getMonth()+1) + "/" + zeroEsquerda(d.getFullYear()) +
			  " " + zeroEsquerda(d.getHours()) + ":" + zeroEsquerda(d.getMinutes()) + ":" + zeroEsquerda(d.getSeconds()) ;
	return retorno;
}