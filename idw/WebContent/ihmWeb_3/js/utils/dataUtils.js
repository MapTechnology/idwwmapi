/* Entrada: 1
   Saida 000001
   Para ser utilizado nos lancamentos de motivo map
*/
var zeroEsquerdaMotivo = function(valor){
	var numeroDigitos = 6;
	var retorno = valor;
	var zeros = numeroDigitos - valor.toString().length;
	var i = 0
	// for (i = 1; i < numeroDigitos; i++ ){
	for (i = 0; i < zeros; i++ ){
		retorno = "0" + retorno;
	}
	return retorno;
}

var zeroEsquerda = function(valor){
	var retorno = valor;
	if(valor < 10 && valor >= 0){
		retorno = "0" + valor;
	}
	return retorno;
}

var getDataAtual = function(horas){
	var retorno = "";
	var d = new Date();
	d.setHours(d.getHours() + horas);
	retorno = zeroEsquerda(d.getDate()) + "-" + zeroEsquerda(d.getMonth()+1) + "-" + zeroEsquerda(d.getFullYear()) +
			  " " + zeroEsquerda(d.getHours()) + ":" + zeroEsquerda(d.getMinutes()) + ":" + zeroEsquerda(d.getSeconds()) + ":00" ;
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