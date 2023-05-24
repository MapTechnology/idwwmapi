//Monta todas as Strings utilizadas em seus respectivos lugares.

function montaStringProducao(){
	$("#h1_ihm_producao").html(PRODUCAO_S);
	$("#link_tabela_producao").html(TABELA_PRODUCAO_S);
	$("#btn_iniciar_op").html(INICIAR_OP_S);
	$("#btn_iniciar_op_injet").html(INICIAR_OP_S);
	if (IsIDWAtivo == "true")
		$("#btn_iniciar_op_injet").hide();
	else
		$("#btn_iniciar_op").hide();
	$("#tabela_producao_cabecalho").append("<tr>" + "<th>" + MAQUINA_S + "</th>" +
			"<th>" + OP_S + "</th>" +
			"<th>" + PRODUTO_S + "</th>" +
			"<th>" + PROD_PLAN_S + "</th>" +
			"<th>" + PROD_LIQ_S + "</th>" +"</tr>");

}
function montaStringLancaCiclo(op , up){
	$("#link_finaliza_op").html(LANCAR_CICLO_S + " - " + up );
	$("#btn_finaliza_op").html(LANCAR_CICLO_S);
	$("#btn_voltar_finaliza_op").html(VOLTAR_S);
	$("#span_finaliza_op").html(LANCAR_CICLO_MSG_S + " : " + op + " ?");
	$("#html_quantidade").html(QTD_PROD_S);
	//$("#inputQtde").attr("placeholder" , QTD_PROD_S);
	$("#inputQtde").attr("placeholder" , "1");
}
function montaStringIniciaOp(){
	$("#span_inicia_op").empty();
	$("#link_inicia_op").html(INICIAR_OP_S);
	$("#html_h3_inicia_op").html(MAQUINA_S);
	$("#btn_pesquisa_inicia_op").html(PESQUISAR_S);
	$("#btn_voltar_inicia_op").html(VOLTAR_S);
	$("#tabela_inicia_op_cabecalho").append("<tr>" + "<th>" + DESCRICAO_S + "</th>" +
			"<th>" + CODIGO_S + "</th>" + "</tr>");
}
function montaStringIniciaOpInjet(){
	$("#span_inicia_op").empty();
	$("#link_inicia_op").html(INICIAR_OP_S);
	$("#html_h3_inicia_op").html(MAQUINA_S);
	$("#btn_pesquisa_inicia_op").html(INICIAR_OP_S);
	$("#btn_voltar_inicia_op").html(VOLTAR_S);
	$("#tabela_inicia_op_cabecalho").append("<tr>" + "<th>" + DESCRICAO_S + "</th>" +
			"<th>" + CODIGO_S + "</th>" + "</tr>");

	$("#html_h3_tp_sessao_inf01").hide();
	$("#tp_sessao_object_inf01").hide();
	$("#html_h3_tp_sessao_inf02").hide();
	$("#tp_sessao_object_inf02").hide();
}

function montaStringpTSessao(tpSessaoInteger) {
	switch (tpSessaoInteger) {
		case "0":
			$("#html_h3_tp_sessao").html(TP_SESSAO_RECUPERA_OP_NUMERO);
		break;
		case "1":
			//$("#html_h3_tp_sessao").html(TP_SESSAO_RECUPERA_OP_FERRAMENTA);
			$("#html_h3_tp_sessao").html(TP_SESSAO_RECUPERA_OP_MOLDE);
		break;
		case "2":
			//$("#html_h3_tp_sessao").html(TP_SESSAO_RECUPERA_OP_PRODUTO);
			$("#html_h3_tp_sessao").html(TP_SESSAO_RECUPERA_OP_NUMERO);
		break;
		case "3":
			$("#html_h3_tp_sessao").html(TP_SESSAO_RECUPERA_OP_PRODUTO);
		break;
		case "4":
			$("#html_h3_tp_sessao").html(TP_SESSAO_MOLDE_ESTRUTURA_COM_OPCRIACAONOMASTER);
			$("#html_h3_tp_sessao_inf01").html(CD_ESTRUTURA);
			$("#html_h3_tp_sessao_inf01").show();
			$("#html_h3_tp_sessao_inf02").html(QTD_PROD_S);
			$("#html_h3_tp_sessao_inf02").show();

			$("#tp_sessao_object_inf01").show();
			$("#tp_sessao_object_inf02").show();
		break;
		case "5":
			$("#html_h3_tp_sessao").html(TP_SESSAO_PRODUTO_ESTRUTURA_COM_OPCRIACAONOMASTER);
			$("#html_h3_tp_sessao_inf01").html(CD_ESTRUTURA);
			$("#html_h3_tp_sessao_inf01").show();
			$("#html_h3_tp_sessao_inf02").html(QTD_PROD_S);
			$("#html_h3_tp_sessao_inf02").show();

			$("#tp_sessao_object_inf01").show();
			$("#tp_sessao_object_inf02").show();
		break;
		case "6":
			$("#html_h3_tp_sessao").html(TP_SESSAO_PRODUTO_MONTAGEM);
		break;
		case "7":
			$("#html_h3_tp_sessao").html(TP_SESSAO_PRODUTO_OP_COM_OPCRIACAOMASTER);
			$("#html_h3_tp_sessao_inf01").html(QTD_PROD_S);
			$("#html_h3_tp_sessao_inf01").show();
			$("#tp_sessao_object_inf01").show();
		break;
		case "8":
			$("#html_h3_tp_sessao").html(TP_SESSAO_MOLDE_PRODUTO_QTCICLOS);
			$("#html_h3_tp_sessao_inf01").html(TP_SESSAO_RECUPERA_OP_PRODUTO); // Cd do Molde
			$("#html_h3_tp_sessao_inf01").show();
			$("#html_h3_tp_sessao_inf02").html(QTD_PROD_S);
			$("#html_h3_tp_sessao_inf02").show();

			$("#tp_sessao_object_inf01").show();
			$("#tp_sessao_object_inf02").show();
		break;
		default:
			$("#html_h3_tp_sessao").html(TP_SESSAO_RECUPERA_OP_NUMERO);
		break;
	}
}

function montaStringFinalizaOp(op , up){
	$("#link_finaliza_op").html(FINALIZAR_OP_S + " - " + up );
	$("#btn_finaliza_op").html(FINALIZAR_OP_S);
	$("#btn_voltar_finaliza_op").html(VOLTAR_S);
	$("#span_finaliza_op").html(FINALIZAR_OP_MSG_S + " - " + op);
}

function montaStringParadas(){
	$("#h1_ihm_paradas").html(PARADAS_S);
	$("#link_ultima_parada").html(TAB_ULT_PAR_S);
	$("#tabela_ultima_parada_cabecalho").empty();
	$("#tabela_ultima_parada_cabecalho").append("<tr>" + "<th>" + MAQUINA_S + "</th>" +
			"<th>" + MOT_UL_PAR_S + "</th>" +
			"<th>" + PAR_INF_S + "</th>" +
			"<th>" + TEMPO_PARADA_S + "</th>" + "</tr>");
	$("#btn_nova_parada").html(NOVA_PARADA_S);
	$("#btn_correcao_de_paradas").html(COR_DE_PAR_S);
}
function monstaStringCorrecaoDeParadas(){
	$("#link_corrigir_paradas").html(CORR_PAR_S);
	$("#btn_pesquisar_corrigir_paradas").html(PESQUISAR_S);
	$("#btn_corrigir_paradas").html(CORRIGIR_S);
	$("#btn_voltar_correcao_de_paradas").html(VOLTAR_S);
}
function montaStringNovaParada(){
	$("#link_nova_parada").html(NOVA_PARADA_S);
	$("#span_nova_parada").html(NOVA_PARADA_MSG_S);
	$("#btn_nova_parada_2").html(NOVA_PARADA_S);
	$("#btn_voltar_nova_parada").html(VOLTAR_S);
}
function montaStringCorrecaoParadas(){
	$("#link_correcao_de_paradas").html(COR_DE_PAR_S);
	$("#btn_corrigir_paradas_modal").html(CORRIGIR_S);
	$("#btn_voltar_correcao_de_paradas").html(VOLTAR_S);
	$("#cabecalho_tabela_correcao_de_paradas").append("<tr>" + "<th></th>" +
			"<th>Código</th>" +
			"<th>Motivo</th>" +
			"<th>Início</th>" +
			"<th>Fim</th>" +
			"<th>Duração</th>" +
			"<th>Turno</th>" + "</tr>");

}
function montaStringCorrecaoParadasLogin(){
	$("#link_correcao_de_paradas_login").html(COR_DE_PAR_S);
	$("#btn_correcao_de_paradas_login").html(LOGIN_S);
	$("#btn_voltar_correcao_de_paradas_login").html(VOLTAR_S);
	$("#html_h3_correcao_de_paradas_login").html(LOGIN_S);
	$("#html_h3_senha_correcao_de_paradas_login").html(SENHA_S);

}
function montaStringCorrecaoParadasCorrige(){
	$("#link_correcao_de_paradas_corrige").html(COR_DE_PAR_S);
	$("#btn_consulta_cd_parada_correcao_de_paradas_corrige").html(CONSULTAR_S);
	$("#btn_causa_correcao_de_paradas_corrige").html(CONSULTAR_S);
	$("#btn_acao_correcao_de_paradas_corrige").html(CONSULTAR_S);
	$("#btn_just_correcao_de_paradas_corrige").html(CONSULTAR_S);
	$("#h3_cd_correcao_de_paradas_corrige").html(CODIGO_S);
	$("#h3_acao_correcao_de_paradas_corrige").html(ACAO_S);
	$("#h3_causa_correcao_de_paradas_corrige").html(CAUSA_S);
	$("#h3_just_correcao_de_paradas_corrige").html(JUSTIFICATIVA_S);
	$("#btn_correcao_de_paradas_corrige").html(CORRIGIR_S);
	$("#btn_voltar_correcao_de_paradas_corrige").html(VOLTAR_S);
}
function montaStringCorrigeUltimaParada(up){
	$("#link_corrigir_ultima_parada").html(COR_ULT_PAR_S + " - " + up);
	$("#btn_corrigir_ultima_parada_2").html(CORRIGIR_S);
	$("#h3_cd_corrige_parada").html(CODIGO_S);
	$("#h3_causa_corrige_parada").html(CAUSA_S);
	$("#h3_acao_corrige_parada").html(ACAO_S);
	$("#h3_justificativa_corrigir_ultima_parada").html(JUSTIFICATIVA_S);
	$("#h3_cd_corrigir_ultima_parada").html(CODIGO_S);
	$("#h3_causa_corrigir_ultima_parada").html(CAUSA_S);
	$("#h3_acao_corrigir_ultima_parada").html(ACAO_S);
	$("#h3_tecresp_corrigir_ultima_parada").html(TECNICORESP_S);
	$("#h3_tec_corrigir_ultima_parada").html(TECNICO_S);
	$("#h3_tec2_corrigir_ultima_parada").html(TECNICO2_S);
	$("#h3_stecresp_corrigir_ultima_parada").html(STECNICORESP_S);
	$("#h3_stec_corrigir_ultima_parada").html(STECNICO_S);
	$("#h3_stec2_corrigir_ultima_parada").html(STECNICO2_S);
	$("#btn_cd_parada").html(CONSULTAR_S);
	$("#btn_voltar_corrigir_ultima_parada").html(VOLTAR_S);

}
function montaStringFinalizaParada(){
	$("#link_finaliza_parada").html(FINALIZAR_PAR_S);
	$("#btn_finalizar_parada").html(FINALIZAR_PAR_S);
	$("#span_finaliza_parada").html(FIN_PARADA_MSG_S);
	$("#btn_voltar_finaliza_parada").html(VOLTAR_S);

}

function montaStringAlertas(){
	$("#html_h3_cod_alerta").html(CODIGO_S);
	$("#h1_ihm_alertas").html(ALERTAS_S);
	$("#link_alertas").html(TABELA_ALERTAS_S);
	$("#btn_novo_alerta").html(NOVO_ALERTA_S);
	$("#cabecalho_tabela_alertas").append("<tr>" + 
		// "<th>" + MAQUINA_S + "</th>" +
		"<th>" + CODIGO_S + "</th>" +
		"<th>" + DESCRICAO_S + "</th>" +
		"<th>" + DATA_HORA_S + "</th>" + "</tr>");

}
function montaStringNovoAlerta(){
	$("#html_h3_maq_alerta").html(MAQUINA_S);
	$("#html_h3_cod_alerta").html(COD_ALERTA_S);
	$("#btn_novo_alerta_2").html(NOVO_ALERTA_S);
	$("#link_novo_alerta").html(NOVO_ALERTA_S);
	$("#btn_voltar_novo_alerta").html(VOLTAR_S);

	$("#btn_consulta_alerta").html(CONSULTAR_S);
}
function montaStringRemoveAlerta(codAlerta){
	$("#link_remove_alerta").html(REMOVER_ALERTA_S);
	$("#btn_remove_alerta").html(REMOVER_ALERTA_S);
	$("#span_remove_alerta").html(REM_ALERTA_MSG_S + codAlerta + '?');
	$("#btn_voltar_remove_alerta").html(VOLTAR_S);
}

function montaStringRefugos(){
	$("#h1_ihm_refugos").html(REFUGOS_S);
	$("#link_refugos").html(TABELA_ULT_REF_S);
	$("#btn_novo_refugo").html(NOVO_REFUGO_S);
	$("#btn_modal_novo_refugo").html(NOVO_REFUGO_S);
	$("#cabecalho_ult_tabela_refugos").append("<tr>" + 
		// "<th>" + MAQUINA_S + "</th>" +
		"<th>" + COD_ULT_REF_S + "</th>" +
		// "<th>" + COD_RED_PROD_S + "</th>" +
		"<th>" + DS_ULT_REF_S + "</th>" +
		"<th>" + DATA_HORA_REF_S + "</th>" +"</tr>");

}
function montaStringCorrigeRefugo(){

}
function montaStringApagaRefugo(){
	$("#link_apaga_refugo").html(APAGAR_ULT_REF);
	$("#btn_apaga_refugo").html(SIM_S);
	$("#span_apaga_refugo").html(APAGAR_REF_MSG);
	$("#btn_voltar_apaga_refugo").html(VOLTAR_S);
}
function montaStringNovoRefugo(){
	$("#link_novo_refugo").html(NOVO_REFUGO_S);
	$("#h3_cd_novo_refugo").html(COD_REF_S);
	if (IsIDWAtivo == "true")
		$("#h3_idprod_novo_refugo").html(ID_PROD_S);
	else
		$("#h3_idprod_novo_refugo").html(ID_RDZ_PROD_S);
	$("#h3_causa_novo_refugo").html(CAUSA_S);
	$("#h3_acao_novo_refugo").html(ACAO_S);
	$("#h3_maquina_novo_refugo").html(MAQUINA_S);
	$("#h3_qtd_novo_refugo").html(QTD_PROD_S);
	$("#btn_cd_novo_refugo").html(CONSULTAR_S);
	$("#btn_acao_novo_refugo").html(CONSULTAR_S);
	$("#btn_causa_novo_refugo").html(CONSULTAR_S);
	$("#html_h3_cod_ref").html(COD_REF_S);
	$("#html_h3_id_prod").html(ID_PROD_S);
	$("#hmtl_h3_qnt_ref").html(QNT_REF_S);
	$("#html_h3_maq_ref").html(MAQUINA_S);
	$("#btn_voltar_novo_refugo").html(VOLTAR_S);
	$("#btn_novo_refugo_2").html(NOVO_REFUGO_S);
}

function montaStringOperadores(){
	$("#h1_ihm_operadores").html(OPERADORES_S);
	$("#link_operadores").html(TABELA_OPERADORES_S);
	$("#btn_login").html(LOGIN_S);
	$("#cabecalho_tabela_operadores").append("<tr>" + 
		// "<th>" + MAQUINA_S + "</th>" +
		"<th>" + OPERADOR_S + "</th>" +
		"<th>" + DATA_HORA_LOGIN_S + "</th>" +
		"<th>" + DURACAO_LOGIN_S + "</th>" + "</tr>");

}
function montaStringLogin(){
	$("#btn_login_operador").html(LOGIN_S);
	$("#btn_voltar_login_operador").html(VOLTAR_S);
	$("#link_login").html(LOGIN_OPER_S);
	$("#html_h3_login_oper").html(LOGIN_S);
	$("#html_h3_senha_oper").html(SENHA_S);
	$("#html_h3_maquina_oper").html(MAQUINA_S);

}
function montaStringLogout(operador){
	$("#btn_logout_operador").html(SIM_S);
	$("#btn_voltar_logout").html(VOLTAR_S);
	$("#link_logout").html(LOGOUT_OPER_S);
	$("#span_logout").html(LOGOU_OPER_MSG_S + " - " + operador);

}

function montaStringNavbar(){
	$("#html_producao").html(PRODUCAO_S);
	$("#html_operadores").html(OPERADORES_S);
	$("#html_paradas").html(PARADAS_S);
	$("#html_alertas").html(ALERTAS_S);
	$("#html_refugo").html(REFUGOS_S);
	$("#html_consulta").html(CONSULTA_S);
	$("#html_postoreprocesso").html(REPROCESSO_S);


}

function montaStringEntrar(){
	$("#html_dados_servidor").html(DADOS_SERVIDOR_S);
	$("#html_endereco").html(ENDERECO_S);
	$("#html_conectar").html(CONECTAR_S);
	// $("#inputPorta").attr("placeholder" , PORTA_S);
	$("#inputPorta").attr("placeholder", window.location.port);
	//$("#inputSrv").attr("placeholder" , ENDERECO_S);
	$("#inputSrv").attr("placeholder", window.location.hostname);
	$("#lembrar_dados").val(LEMBRAR_S);

}

function montaStringSair(){
	$("#btn_voltar_sair").html(NAO_S);
	$("#span_sair").html(DESEJA_SAIR_S);
	$("#btn_sair_2").html(SAIR_S);
	$("#link_sair").html(SAIR_S);
}

function montaStringConsulta(){
	$("#link_consulta").html(CONSULTA_S);
	$("#html_h3_maq_consulta").html(SELECIONA_MAQ_CONSULTA_S);
	$("#btn_consultar").html(CONSULTAR_S);
	$("#resultado_consulta").html(RESULTADO_CONSULTA_S);
	$("#span_consulta").html(CONS_LISTA_S);
	$("#btn_voltar_consulta").html(VOLTAR_S);
	$("#maquina_consulta").html(MAQUINA_S);
	$("#tabela_lista_consulta_cabecalho").append("<tr>" + "<th>" + CODIGO_S + "</th>" +
			"<th>" + DESCRICAO_S + "</th>" + "</tr>");

	$("#html_h3_cod_consulta").html(COD_CONSULTA_S);
	$("#btn_pesquisar_consulta").html(PESQUISAR_S);
	$("#modal_closeButton").html(FECHAR_S);




}

var listaDeConsulta = [
{
	   numero: 1 ,
	   consulta: CONS_001_S
},
{
	   numero: 2 ,
	   consulta: CONS_002_S
},
{
	   numero: 3 ,
	   consulta: CONS_003_S
},
{
	   numero: 4 ,
	   consulta: CONS_004_S
},
{
	   numero: 5 ,
	   consulta: CONS_005_S
},
{
	   numero: 6 ,
	   consulta: CONS_006_S
},
{
	   numero: 7,
	   consulta: CONS_007_S
},
{
	   numero: 8,
	   consulta: CONS_008_S
},
{
	   numero: 9,
	   consulta: CONS_009_S
},
{
	   numero: 10,
	   consulta: CONS_010_S
},
{
	   numero: 11,
	   consulta: CONS_011_S
},
{
	   numero: 12,
	   consulta: CONS_012_S
},
{
	   numero: 14,
	   consulta: CONS_014_S
},
{
	   numero: 15,
	   consulta: CONS_015_S
},
{
	   numero: 16,
	   consulta: CONS_016_S
}

                    	   ];

function montaStringPostoReprocesso(){
	$("#link_reprocesso").html(POSTO_REPROCESSO_S);
	$("#selecione_maquina_reprocesso").html(SEL_MAQ_S);
	$("#btn_selecionar_pt_reprocesso").html(SELECIONAR_S);
	$("#input_cb_reprocesso").attr("placeholder" , CODIGO_BARRAS_S);
}

function montaStringProdutoRefugadoReprocesso(){
	$("#link_reprocesso_produto_refugado").html(PROD_REF_S);
	$("#msg_ihm_reprocesso_produto_refugado").html(PROD_REF_PRE_S);
	$("#btn_sim_ihm_reprocesso_produto_refugado").html(SIM_S);
	$("#btn_nao_ihm_reprocesso_produto_refugado").html(NAO_S);
}

function montaStringSerialConformeReprocesso(){
	$("#link_reprocesso_serial_conforme").html(SERIAL_CONFORME_S);
	$("#msg_ihm_reprocesso_serial_conforme").html(SERIAL_CONFORME_MSG_S);
	$("#btn_ihm_reprocesso_serial_conforme").html(INF_NOVO_DEF_S);
	$("#btn_ok_ihm_reprocesso_serial_conforme").html(OK_S);
}

function montaStringSituacaoCBReprocesso(){
	$("#link_reprocesso_situacao_cb").html(SITUACAO_CB_S);
	$("#msg_ihm_reprocesso_situacao_cb").html(MSG_CB_CONFORME_S);
	$("#btn_sim_ihm_reprocesso_situacao_cb").html(SIM_S);
	$("#btn_nao_ihm_reprocesso_situacao_cb").html(NAO_S);
}

function montaStringMenuMainReprocesso(refugado){
	$("#link_reprocesso_menu_main").html(POSTO_REPROCESSO_S);
	$("#btn_visualizar_ns_ihm_reprocesso_menu_main").html(VISUALIZAR_NS_S);
	$("#btn_nova_montagem_ihm_reprocesso_menu_main").html(NOVA_MONTAGEM_S);
	$("#btn_novo_defeito_ihm_reprocesso_menu_main").html(NOVO_DEFEITO_S);
	$("#btn_voltar_ihm_reprocesso_menu_main").html(VOLTAR_S);
	if(refugado){
		$("#btn_refugo_ihm_reprocesso_menu_main").html(CANCELAR_REF_S);
	}else{
		$("#btn_refugo_ihm_reprocesso_menu_main").html(REF_PRODUTO_S);
	}
}

function montaStringSolicitaDefeitoReprocesso(){
	$("#link_reprocesso_solicita_defeito").html(DEFEITOS_S);
	$("#tabela_defeitos_reprocesso_cabecalho").append("<tr>" + "<th>" + CODIGO_S + "</th>" + "<th>" + DESCRICAO_S + "</th>" + "</tr>");
}

function montaStringNovoRefugoReprocesso(){
	$("#link_novo_refugo_reprocesso").html(NOVO_REFUGO_S);
	$("#h3_cd_novo_refugo_reprocesso").html(COD_REF_S);
	$("#h3_idprod_novo_refugo_reprocesso").html(ID_PROD_S);
	$("#h3_qtd_novo_refugo_reprocesso").html(QTD_PROD_S);
	$("#btn_cd_novo_refugo_reprocesso").html(CONSULTA_S);
	$("#html_h3_cod_ref_reprocesso").html(COD_REF_S);
	$("#html_h3_id_prod_reprocesso").html(ID_PROD_S);
	$("#hmtl_h3_qnt_ref_reprocesso").html(QNT_REF_S);
	$("#btn_voltar_novo_refugo_reprocesso").html(VOLTAR_S);
	$("#btn_novo_refugo_reprocesso").html(NOVO_REFUGO_S);
}

function montaStringCancelaRefugoReprocesso(){
	$("#link_apaga_refugo_reprocesso").html(APAGAR_ULT_REF);
	$("#btn_apaga_refugo_reprocesso").html(SIM_S);
	$("#span_apaga_refugo_reprocesso").html(APAGAR_REF_MSG);
	$("#btn_voltar_apaga_refugo_reprocesso").html(VOLTAR_S);
}

function montaStringVisualizarNCReprocesso(){
	$("#link_visualizar_nc_reprocesso").html(VISUZALISAR_NC_S);
	$("#tabela_visualizar_nc_reprocesso_cabecalho").append("<tr>" + "<th>" + " " + "</th>"
																  + "<th>" + DEFEITO_S + "</th>"
																  + "<th>" + POSTO_ORIGEM_S + "</th>"
																  + "<th>" + DATA_HORA_S + "</th>" + "</tr>");
	$("#btn_corrigir_visualizar_nc_reprocesso").html(CORRIGIR_S);
	$("#btn_voltar_visualizar_nc_reprocesso").html(VOLTAR_S);
}

function montaStringSelecionarAcaoNCReprocesso(){
	$("#link_selecionar_acao_nc_reprocesso").html(SEL_ACAO_S);
	$("#tabela_selecionar_acao_nc_reprocesso_cabecalho").append("<tr>" + "<th>" + CODIGO_S + "</th>"
			  + "<th>" + DESCRICAO_S + "</th>" + "</tr>");
	$("#btn_corrigir_selecionar_acao_nc_reprocesso").html(CORRIGIR_S);
	$("#btn_voltar_selecionar_acao_nc_reprocesso").html(VOLTAR_S);
}

function montaStringSelecionarDefeitoNCReprocesso(){
	$("#link_selecionar_defeito_nc_reprocesso").html(SEL_DEF_S);
	$("#tabela_selecionar_defeito_nc_reprocesso_cabecalho").append("<tr>" + "<th>" + CODIGO_S + "</th>"
			  + "<th>" + DESCRICAO_S + "</th>" + "</tr>");
	$("#btn_voltar_selecionar_defeito_nc_reprocesso").html(VOLTAR_S);
}

function montaStringTudo() {

	$(".nao").html(NAO_S);
	$(".pesquisa-filtro").val(FILTRO_S);
	$(".fechar").html(FECHAR_S);
	$(".option-default").html(SEL_MAQ_S);
	$(".logout").html(LOGOUT_S);

}
