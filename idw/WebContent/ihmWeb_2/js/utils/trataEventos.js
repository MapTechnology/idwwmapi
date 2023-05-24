//Funcoes de GetChave e Switch dos eventos do servidor sao tratados aqui

$.getScript("js/utils/conectarServidor.js");

function getChave(chave) {
	var mensagemTemp = "";
	if (respostaSessao_G.indexOf(chave) >= 0) {
		mensagemTemp = respostaSessao_G.substring(respostaSessao_G.indexOf(chave));
		valorVariavelLida = mensagemTemp.substring(0, mensagemTemp.indexOf("="));
		if(valorVariavelLida !== chave) {
			return "-1";
		}
		
		mensagemTemp = mensagemTemp.substring(mensagemTemp.indexOf("=") + 1);
		mensagemTemp = mensagemTemp.substring(0, mensagemTemp.indexOf("#"));
		
		//console.log(respostaSessao_G);
		//console.log(mensagemTemp);

		return mensagemTemp;
	}

	return "-1";
}

//metodo com possivel defeito de leitura, faltar avaliar, se basear metodo acima.
function getChaveS(chave , mensagem) {
	var mensagemTemp = "";
	if (mensagem.indexOf("#" + chave) >= 0) {
		mensagemTemp = mensagem.substring(mensagem.indexOf("#" + chave) + 1);		
		mensagemTemp = mensagemTemp.substring(mensagemTemp.indexOf("=") + 1);
		mensagemTemp = mensagemTemp.substring(0, mensagemTemp.indexOf("#"));
		console.log('chave original:' + chave + ' | chave lida:' + mensagem);

		return mensagemTemp;
	}

	return "-1";
}

function trataEvento(evento){
	switch (evento) {
	case SESSAO:
		iniciaSessao();
		break;

	case RESPOSTA:
		trataResposta();
		break;

	case RESP_CONSULTA:
		trataRespostaConsulta();
		break;

	case INICIA_NOVA_PARADA:
		break;

	case CICLO:
		break;

	case RESP_VALIDA_PARADA:
		break;

	default:
		if(getChave(CONSULTA_OK) !== "-1"){
			scopesConsulta.trataRespostaConsulta(respostaSessao_G);
		}
	if(getChave(CONSULTA_FAIL) !== "-1"){
		scopesConsulta.trataRespostaConsulta("fail");
	}
	break;
	}

}

function iniciaSessao() {
	// Verifico se a sessao não pertence ao IHM
	if(respostaSessao_G.indexOf(IP_L) == -1){
		console.error("Sessao nao pertence ao ihm; respostaSessao_G = " + respostaSessao_G);
		return;
	}

	Sessoes_G = [];

	var listaPt = getPts(1);

	if(!isConectado_G){
		pbConectar(80);
	}

	isExisteMaquinaParada = false;
	for(ipt = 0 ; ipt < listaPt.length ; ipt++){
		Sessoes_G.push(SessaoDTO(listaPt[ipt]));
		if (listaPt[ipt].isParada == "true")
			isExisteMaquinaParada = true;
	}

	Sessoes_G.sort(function(a, b){
		var pt1 = a.pt.dsup.toLowerCase(), pt2 = b.pt.dsup.toLowerCase()
		if (pt1 < pt2)
			return -1; 
		if (pt1 > pt2)
			return 1;
		return 0; 
	})

	if(!isConectado_G){
		window.location.hash = '#/producao';
		scopesL.entrar();
	}

	isConectado_G = true;

	atualizaSessoes();

	if (isExisteMaquinaParada){
		var audio = new Audio('sounds/vibration_reduzido.mp3');
		audio.play();
		navigator.vibrate = navigator.vibrate || navigator.webkitVibrate || navigator.mozVibrate || navigator.msVibrate;
		if (navigator.vibrate) {
			navigator.vibrate([1000, 300, 1000, 300, 1000, 300, 1000]);
		} else {
			console.log("Navegador nao e compativel com a API vibration");
		}
	}
}
function trataRespostaConsulta(){
	respostaConsulta;
	debugger;
}
function trataResposta() {
	var resposta = getChave(TAG_RESPOSTA);
	switch(resposta.toString()){
	case LOGIN_EM_ABERTO:
		//servicoG.respostaGenerica(LOGIN_ABERTO_S , "warning");
		break;

	case LOGIN_SUCESSO:
		//servicoG.respostaGenerica(SUCESSO_S , "success");
		break;

	case LOGIN_FALHA:
		//servicoG.respostaGenerica(LOGIN_ABERTO_S , "danger");
		break;

	case LOGOUT_SUCESSO:
		//servicoG.respostaGenerica(SUCESSO_S , "success");
		break;

	case LOGOUT_FALHA:
		//servicoG.respostaGenerica(FALHA_S , "danger");
		break;

	case ALERTA_INICIADA_SUCESSO:
		setTimeout(function () { servicoG.respostaGenerica(ALERTA_INICIO_MSG_SUCESSO_S , "success");}, 2000);
		break;

	case ALERTA_INICIADA_FALHA:
		servicoG.respostaGenerica(ALERTA_INICIO_MSG_FALHA_S , "danger");
		break;

	case ALERTA_PARADA_SUCESSO:
		setTimeout(function () { servicoG.respostaGenerica(ALERTA_FIM_MSG_SUCESSO_S , "success");},2000);
		break;

	case ALERTA_PARADA_FALHA:
		servicoG.respostaGenerica(ALERTA_FIM_MSG_FALHA_S , "danger");
		break;

	case CONSULTA_FALHA:
		servicoG.respostaGenerica(CONSULTA_MSG_FALHA_S , "danger");
		break;

	case REFUGO_INVALIDO:
		servicoG.respostaGenerica(REFUGO_INICIO_MSG_INV_S , "danger");
		break;

	case REFUGO_SUCESSO:
		servicoG.respostaGenerica(REFUGO_INICIO_MSG_SUCESSO_S , "success");
		break;

	case REFUGO_FALHA:
		servicoG.respostaGenerica(REFUGO_INICIO_MSG_FALHA_S , "danger");
		break;

	case VALIDA_PARADA_FALHA:
		servicoG.respostaGenerica(VALIDA_PARADA_MSG_FALHA_S , "danger");
		break;

	case INFORMA_MOTIVO_PARADA_SUCESSO:
		servicoG.respostaGenerica(INF_MOTIVO_PARADA_MSG_SUC_S , "success");
		break;

	case INFORMA_MOTIVO_PARADA_FALHA:
		servicoG.respostaGenerica(INF_MOTIVO_PARADA_MSG_FAL_S , "danger");
		break;

	case NOVA_OP_SUCESSO:
		//servicoG.respostaGenerica(ABRE_OP_MSG_SUCESSO_S , "success");
		break;

	case NOVA_OP_FALHA:
		servicoG.respostaGenerica(ABRE_OP_MSG_FALHA_S , "danger");
		break;

	case FINALIZAOP_SUCESSO:
		servicoG.respostaGenerica(FINALIZA_OP_MSG_SUCESSO_S , "success");
		break;

	case FINALIZAOP_FALHA:
		servicoG.respostaGenerica(FINALIZA_OP_MSG_FALHA_S , "danger");
		break;

	// case BC_OFFLINE:
	// 	servicoG.respostaGenerica(BC_OFFLINE_S , "danger");
	// 	break;
	case REFMSG1:
		servicoG.respostaGenerica(REFUGO_APAGADO_COM_SUCESSO_S , "danger");
	 	break;

	case REFMSG2:
		servicoG.respostaGenerica(ERRO_APAGAR_REFUGO_S , "danger");
	 	break;

	case IHM_DESCONHECIDO:
		if(scopesC != null){
			location.reload(true)
		}
		else{
			clearInterval(sessaoTimer);
			erro(true);
		}
		break;

	case SERVICO_FALHOU:
		servicoG.respostaGenerica(SERVICO_FALHOU_MSG_S , "danger");
		break;

	case FINALIZAPARADA_SUCESSO:
		servicoG.respostaGenerica(FINALIZA_PARADA_MSG_SUC_S , "success");
		break;

	case FINALIZAPARADA_FALHA:
		servicoG.respostaGenerica(FINALIZA_PARADA_MSG_FAL_S , "danger");
		break;

	case PARADA_ACAO_INVALIDA:
		servicoG.respostaGenerica(PARADA_ACAO_INVALIDA_MSG_S , "danger");
		break;

	case PARADA_CAUSA_INVALIDA:
		servicoG.respostaGenerica(PARADA_ACAO_INVALIDA_MSG_S , "danger");
		break;

	case PARADA_JUST_INVALIDA:
		servicoG.respostaGenerica(PARADA_ACAO_INVALIDA_MSG_S , "danger");
		break;

	case PARADA_TEC1_INVALIDA:
		servicoG.respostaGenerica(PARADA_ACAO_INVALIDA_MSG_S , "danger");
		break;

	case PARADA_TEC2_INVALIDA:
		servicoG.respostaGenerica(PARADA_ACAO_INVALIDA_MSG_S , "danger");
		break;

	case PARADA_TEC_RESP_INVALIDA:
		servicoG.respostaGenerica(PARADA_ACAO_INVALIDA_MSG_S , "danger");
		break;

	case CONSULTA_FAIL:
		servicoG.respostaGenerica(CONSULTA_MSG_FALHA_S , "danger");
		break;

	}


}
