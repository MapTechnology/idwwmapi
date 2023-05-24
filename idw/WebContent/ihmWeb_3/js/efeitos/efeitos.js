//Efeitos gerais e carregamento dos demais scripts de efeitos e plugins relacionados

$.getScript("js/externos/scrollify.js");
$.getScript("js/externos/jquery.datetimepicker.full.js");
$.getScript("js/externos/moment.js");


function toggleFullScreen() {
	if ((document.fullScreenElement && document.fullScreenElement !== null) ||    
			(!document.mozFullScreen && !document.webkitIsFullScreen)) {
		if (document.documentElement.requestFullScreen) {  
			document.documentElement.requestFullScreen();  
		} else if (document.documentElement.mozRequestFullScreen) {  
			document.documentElement.mozRequestFullScreen();  
		} else if (document.documentElement.webkitRequestFullScreen) {  
			document.documentElement.webkitRequestFullScreen(Element.ALLOW_KEYBOARD_INPUT);  
		}  
	} else {  
		if (document.cancelFullScreen) {  
			document.cancelFullScreen();  
		} else if (document.mozCancelFullScreen) {  
			document.mozCancelFullScreen();  
		} else if (document.webkitCancelFullScreen) {  
			document.webkitCancelFullScreen();  
		}  
	}

}

function habilitaConectar(habilita){
	if(habilita){
		$("#btn_conectar").attr("disabled",false);
		$("#inputSrv").attr("disabled",false);
		$("#inputPorta").attr("disabled",false);
	}
	else{
		$("#btn_conectar").attr("disabled",true);
		$("#inputSrv").attr("disabled",true);
		$("#inputPorta").attr("disabled",true);
	}
}

function pbConectar(porcentagem){
	if(porcentagem < 0){
		$("#div_pb_conectando").css('display', 'none');
	}
	else{
		$("#div_pb_conectando").css('visibility', 'visible');
		$("#div_pb_conectando").css('display', 'block');
		$("#pb_conectando").css('width', porcentagem+'%').attr('aria-valuenow' , porcentagem);
	}
}

function mostraMsgErroConectar(ihmDesconhecido){
	if(ihmDesconhecido){
		if($("#div_msg_erro_conectar").children().size() == 0){
			$("#div_msg_erro_conectar").append("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">"+
					"<button type=\"button\" class=\"close\" data-dismiss=\"alert\""+
					"aria-label=\"Close\">"+
					"<span aria-hidden=\"true\">&times;</span>"+
					"</button>"+
					"<strong>" + ERRO_S + "</strong> " + ERRO_SRV +
					IHM_DESC_S + 
			"</div>");

			if($("#div_msg_erro_conectar").css("display") == "block"){
				$("#div_msg_erro_conectar").css('display' , 'none');
			}
			$("#div_msg_erro_conectar").slideDown();
		}
	}else{
		if($("#div_msg_erro_conectar").children().size() == 0){
			$("#div_msg_erro_conectar").append("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">"+
					"<button type=\"button\" class=\"close\" data-dismiss=\"alert\""+
					"aria-label=\"Close\">"+
					"<span aria-hidden=\"true\">&times;</span>"+
					"</button>"+
					"<strong>" + ERRO_S + "</strong> " + ERRO_SRV +
					VERIFICAR_DADOS_S + 
			"</div>");

			if($("#div_msg_erro_conectar").css("display") == "block"){
				$("#div_msg_erro_conectar").css('display' , 'none');
			}
			$("#div_msg_erro_conectar").slideDown();
		}
	}
}

function trocaPagina(pagina) {
	var div = "#div_ihm_"+ pagina;
	if(paginaAtual_G == null){
		paginaAtual_G = pagina;
		$("#div_ihm_navbar_topo").toggle();
		$("#div_ihm_conectar").toggle();
		$(div).toggle();
		return;
	}
	$("#div_ihm_"+paginaAtual_G).toggle();
	$("#div_ihm_"+pagina).toggle();
	if(pagina == PAG_PROD){
		preencheProducao();
	}
	if(pagina == PAG_PARA){
		preencheTabelaUltimaParada();
		preencheCorrigirParadas();
	}
	if(pagina == PAG_OPER){
		preencheOperadores();
	}
	if(pagina == PAG_REFU){
		preencheTabelaUltRefugo();
	}
	if(pagina == PAG_ALER){
		preencheTabelaAlertas();
	}
	paginaAtual_G = pagina;

}

function trocaPT(numeroPT){
	ptAtual_G = numeroPT;
}

function respostaGenerica(msg , classe){
	$("#span_resposta_generica").html(msg);
	$("#modal_body_resposta_generica").removeClass();
	$("#modal_body_resposta_generica").addClass("modal-body alert-" + classe);
	$("#modal_resposta_generica").modal();
}


//recolapse da navbar
$('.navbar-collapse a').click(function(){
	$(".navbar-collapse").collapse('hide');
});