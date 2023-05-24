//Funcoes pertinentes a comunicacao TCP com o servidor


function adicionarCabecalho(codigo , idPt) {
	var msg = TAG_ACTION + codigo + SEPARADOR + 
	UP + idPt + SEPARADOR + "ip=" + IP_L + SEPARADOR +
	"pt=" + "3001" + SEPARADOR;
	return msg;
}

function construirMensagemAserTransmitidaReprocesso(dto , codigo , idPt) {	
	switch (codigo) {

	case NOVOREFUGO:
		var msg = adicionarCabecalho(LOGOUT , idPt) + "cb=" + dto.cb + SEPARADOR +
		"cdrefugo=" + dto.cdrefugo + SEPARADOR + "idrdzproduto=" + dto.idrdzproduto + SEPARADOR + "qtde=" + dto.qtde + SEPARADOR;
		break;

	case APAGAULTIMOREFUGO:
		var msg = adicionarCabecalho(APAGAULTIMOREFUGO , idPt) + "cb=" + dto.cb + SEPARADOR +
		"msdtref=" + "" + SEPARADOR + "idrdzproduto=" + "" + SEPARADOR + "idrdzproduto=" + "" + SEPARADOR;
		break;
	}

	return msg;
}

function construirMensagemAserTransmitidaLogin(login , senha , idPt) {	
	var msg = adicionarCabecalho(LOGIN , idPt) + "login=" + login + SEPARADOR +
	"senha=" + senha + SEPARADOR;
	return msg;
}

function construirMensagemAserTransmitida(dto , codigo , idPt) {
	switch (codigo) {

	case LOGOUT:
		var msg = adicionarCabecalho(LOGOUT , idPt) + "login=" + dto.login + SEPARADOR +
		"dthrlogin=" + dto.dthrLogin + SEPARADOR + "ip=" + IP + SEPARADOR ;
		break;

	case NOVOREFUGO:
		var msg = adicionarCabecalho(NOVOREFUGO , idPt) + "idup=" + idPt + SEPARADOR + 
		"cdrefugo=" + dto.cdrefugo + SEPARADOR + "idrdzproduto=" + dto.idrdzproduto + 
		SEPARADOR + "qtdeprod=" + dto.qtde + SEPARADOR;
		if(dto.causa !== ""){
			msg = msg + "cdcausa=" + dto.causa + SEPARADOR;
		}
		if(dto.acao !== ""){
			msg = msg + "cdacao=" + dto.acao + SEPARADOR;
		}
		break;

	case APAGAULTIMOREFUGO:
		var msg = adicionarCabecalho(APAGAULTIMOREFUGO , idPt) + "dtref=" + dto.dtref + SEPARADOR +
		"msdtref=" + dto.msdtref + SEPARADOR + "cdrefugo=" + dto.idrdzproduto + SEPARADOR;
		break;

	case VALIDAREFUGO:
		var msg = adicionarCabecalho(VALIDAREFUGO , idPt) + "cdrefugo=" + dto.cdrefugo + SEPARADOR + 
		"idrdzproduto=" + dto.idrdzproduto + SEPARADOR + "qtdeprod=" + dto.qtde + SEPARADOR;
		break;

	case INICIA_ALERTA:
		var msg = adicionarCabecalho(INICIA_ALERTA , idPt) + "cdalerta=" + dto.cdalerta + SEPARADOR;
		break;

	case FINALIZA_PARADA:
		var msg = adicionarCabecalho(FINALIZA_PARADA , idPt);
		break;

	case VALIDAPARADA:
		var msg = adicionarCabecalho(VALIDAPARADA, idPt) + "cdparada=" + dto + SEPARADOR;
		break;

	case MOTIVO_PARADA:
		var msg = adicionarCabecalho(MOTIVO_PARADA, idPt) + "cdparada=" + dto[0] + SEPARADOR + "flagmotivoparada=true" + SEPARADOR +
		"cdacao=" + dto[1] + SEPARADOR + "cdcausa=" + dto[2] + SEPARADOR + "cdjust=" + dto[3] + SEPARADOR + "cdtec1=" + dto[6] + SEPARADOR + 
		"senhatec1=" + dto[7] + SEPARADOR + "cdtec2=" + dto[8] + SEPARADOR + "senhatec2=" + dto[9] + SEPARADOR + "cdtecresponsavel=" + dto[4] + SEPARADOR + 
		"senhatecresponsavel=" + dto[5] + SEPARADOR;
		break;

	case CONSULTA:
		var msg = adicionarCabecalho(CONSULTA, idPt) + "cdconsulta=" + dto + SEPARADOR; 
		break;

	case REMOVE_ALERTA:
		var msg = adicionarCabecalho(REMOVE_ALERTA, idPt) + "cdalerta=" + dto + SEPARADOR;
		break;

	case INICIA_NOVA_PARADA:
		var msg = adicionarCabecalho(INICIA_NOVA_PARADA, idPt) + "dthrevento=" + retornaData() + SEPARADOR;
		break;

	case FINALIZA_OP:
		var msg = adicionarCabecalho(FINALIZA_OP, idPt) + "nrop=" + dto + SEPARADOR;
		break;

	case NOVA_OP:
		var msg = adicionarCabecalho(NOVA_OP, idPt) + "nrop=" + dto + SEPARADOR;
		break;

	case INFORMA_MOTIVO_PARADA:
		var msg = adicionarCabecalho(INFORMA_MOTIVO_PARADA, idPt) + "cdparada=" + dto + SEPARADOR;
		break;
		
	}

	return msg;
}

function retornaData(){
	var data = new Date();
	data.setHours(data.getHours() - 4);
	var retorno = data.toISOString().substr(0,19).replace("T" , "").replaceAll("-","").replaceAll(":" , "");
	return retorno;
}

String.prototype.replaceAll = function(search, replacement) {
	var target = this;
	return target.split(search).join(replacement);
};
