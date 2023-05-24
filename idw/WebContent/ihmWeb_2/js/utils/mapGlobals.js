//Globais do sistema
//----------------------------------------------------------------- Constantes -----------------------------------------------------------------

var REGISTRO_CLIENTES     = "0";
var DESREGISTRO_CLIENTES  = "1";
var CICLO                 = "2";
var PARADA                = "3";
var MOTIVO_PARADA         = "4";
var ANDON                 = "5";
var INICIA_NOVA_PARADA    = "6";
var SESSAO                = "7";
var LOGIN                 = "8";
var LOGOUT                = "9";
var INICIA_ALERTA         = "10";
var REMOVE_ALERTA         = "11";
var CONSULTA              = "12";
var APAGAULTIMOREFUGO     = "13";
var VALIDAREFUGO          = "14";
var NOVOREFUGO            = "15";
var VALIDAPARADA          = "16";
var INFORMA_MOTIVO_PARADA = "17";
var IC_HEART_BEAT         = "18";
var NOVA_OP               = "19";
var NOVA_OP_MOLDE         = "19_1";
var NOVA_OP_PRODUTO       = "19_3";
var NOVA_OP_MOLDE_ESTRUTURA = "19_4"
var NOVA_OP_PRODUTO_ESTRUTURA = "19_5"
var NOVA_OP_PRODUTO_MONTAGEM = "19_6"
var NOVA_OP_COM_OPCRIACAOMASTER = "19_7"
var NOVA_OP_MOLDE_PRODUTO = "19_8"
var FINALIZA_OP           = "20";
var RESPOSTA              = "21";
var RESP_CONSULTA         = "22";
var RESP_VALIDA_REFUGO    = "23";
var RESP_VALIDA_PARADA    = "24";
var FINALIZA_PARADA       = "25";
var FIM_PARADA            = "29";
var INICIA_CIP            = "126";
var FINALIZA_CIP          = "127";
var SEPARADOR             = "#";
var TAG_ACTION            = "ac=";
var IDUP                  = "idup=";
var UP                    = "up=";

var TAG_RESPOSTA         ="#resposta" 

var ACTION_VALIDA_REFUGO = "ac=23";
var ACTION_VALIDA_PARADA = "ac=24";
var LOGIN_EM_ABERTO = "LOGINMSG1";
var LOGIN_SUCESSO = "LOGINMSG2";
var LOGIN_FALHA = "LOGINMSG3";
var LOGOUT_SUCESSO = "LOGOUTMSG1";
var LOGOUT_FALHA = "LOGOUTMSG2";
var ALERTA_INICIADA_SUCESSO = "ALERTAIMSG1";
var ALERTA_INICIADA_FALHA = "ALERTAIMSG2";
var ALERTA_PARADA_SUCESSO = "ALERTAPMSG1";
var ALERTA_PARADA_FALHA = "ALERTAPMSG2";
var CONSULTA_FALHA = "CONSULTAMSG1";
var BC_OFFLINE = "BCOFFLINEMSG1";
var REFUGO_INVALIDO = "VALIDAREFMSG1";
var REFUGO_SUCESSO = "NOVOREFMSG1";
var REFUGO_FALHA = "NOVOREFMSG2#";
var VALIDA_PARADA_FALHA = "VALIDAPARADAMSG1";
var INFORMA_MOTIVO_PARADA_SUCESSO = "PARADAMSG1";
var INFORMA_MOTIVO_PARADA_FALHA = "PARADAMSG2";
var NOVA_OP_SUCESSO = "NOVAOPMSG1";
var NOVA_OP_FALHA = "NOVAOPMSG2";
var FINALIZAOP_SUCESSO = "FINALIZAOPMSG1";
var FINALIZAOP_FALHA = "FINALIZAOPMSG2";
var IHM_DESCONHECIDO = "IHMDESCONHECIDOMSG1";
var SERVICO_FALHOU = "SERVICOFALHOUMSG1";
var FINALIZAPARADA_SUCESSO = "FINALIZAPARADAMSG1";
var FINALIZAPARADA_FALHA = "FINALIZAPARADAMSG2";
var PARADA_ACAO_INVALIDA = "PARADAACAOINVALIDA=1";
var PARADA_CAUSA_INVALIDA = "PARADACAUSAINVALIDA=1";
var PARADA_JUST_INVALIDA = "PARADAJUSTINVALIDA=1";
var PARADA_TEC1_INVALIDA = "PARADATEC1INVALIDA=1";
var PARADA_TEC2_INVALIDA = "PARADATEC2INVALIDA=1";
var PARADA_TEC_RESP_INVALIDA = "PARADATECRESPINVALIDA=1";
var NUMERO_DE_SERIE_VALIDO = "NSOK";
var NUMERO_DE_SERIE_INVALIDO = "NSFAIL";
var NUMERO_DE_SERIE_VALIDO_N = "NSOKPFAIL";
var REFUGO_VALIDO = "REFOK";
var REFUGO_NAO_VALIDO = "REFFAIL";
var NUMERO_DE_SERIE_INVALIDO_ROTEIRO = "NSFAILROT";
var REQUER_QUANTIDADE = "REQQNT";
var REQUER_QUANTIDADE_REFUGO = "REFREQQNT";
var REFUGO_PRODUTO_JA_REFUGADO = "REFFAILJAREF";
var NUMERO_DE_SERIE_REFUGADO = "NSREFUGADO";
var CRIA_OP_AUTOMATICA_FAIL = "CRIAOPAUTOFAIL";
var CRIA_OP_AUTOMATICA_OK = "CRIAOPAUTOOK";
var CONSULTA_OK = "CONSULTAOK";
var CONSULTA_FAIL = "CONSULTAFAIL";

var REFMSG1 = "REFMSG1";
var REFMSG2 = "REFMSG2";

var  _RECEBIDO_COM_SUCESSO = "rs#";
var  _ID_UP = "up=";
var  _FINAL_CICLO = "finalciclo=";
var  _INICIO_PARADA = "inicioparada=";
var  _RELE = "rele=";
var  _ATIVO = "ativo=";
var  _INTERMITENCIA = "pisca=";
var  _TEMPO_LIGADO = "tmpalto=";
var  _TEMPO_DESLIGADO = "tmpbaixo=";
var  _FIM_CONFIG_RELE = "fimrele#";
var  _LISTA_RELES = "listarele=";
var  _QUANTIDADE = "qtd=";
var  _OP = "op=";
var  _CD_PRODUTO = "cdproduto=";
var  _CD_FOLHA = "cdfolha=";
var  _ID_FOLHA = "idfolha=";
var  _CICLO_PADRAO = "ciclopadrao=";
var  _CICLO_MEDIO = "ciclomedio=";
var  _CICLO_TIMEOUT = "ciclotimeout=";
var  _CICLO_MINIMO = "ciclominimo=";
var  _TIMEOUT_CIP = "timeoutcip=";
var  _QUANTIDADE_POR_CICLO = "qtdporciclo=";
var  _PROD_LIQ = "prodliq=";
var  _EFI_REAL = "efireal=";
var  _PROD_REF = "prodref=";
var  _INDI_REF = "indiref=";
var  _INDI_PAR_TURNO = "indipartur=";
var  _INDI_PAR_OP = "indiparop=";
var  _EFI_CIC_TURNO = "eficictur=";
var  _EFI_CIC_OP = "eficicop=";
var  _DS_TURNO = "dsturno=";
var  _PROD_OEE = "prodoee=";
var  _META_OEE = "metaoee=";
var  _A_PRODUZIR = "aproduzir=";
var  _INTERVALO_HR = "intervalohr=";
var  _IND_QLD = "indqld=";
var  _IND_UTL = "indutl=";
var  _IND_EFC = "indefc=";
var  _QTD_PROD = "qtdprod=";
var  _PROD = "prod=";
var  _PROD_CD = "prodcd=";
var  _PROD_IDRDZ = "prodidrdz=";
var  _PROD_QTDPORCICLO = "prodqtdporciclo=";
var  _IS_CIP = "iscip=";
var  _DTHR = "dthr=";
var  _DURATION = "duration="; 

var PAG_CONN = "conectar";
var PAG_PROD = "producao";
var PAG_PARA = "paradas";
var PAG_ALER = "alertas";
var PAG_REFU = "refugos";
var PAG_OPER = "operadores";
var PAG_MAQN = "maquinas";
var NAV_TOPO = "navbar_topo";

var SUCESSO_CLASSE = "success";
var FALHA_CLASSE   = "danger";
var AVISO_CLASSE   = "warning";

//-------------------------------------------------------------- Variaveis Globais -------------------------------------------------------------

var respostaSessao_G;
var isModalAberto_G       = false;
var Sessoes_G             = [];
var isConectado_G         = false;
var paginaAtual_G         = null;
var ptAtual_G             = 0;
var operadorSelecionado_G = null;
var refugoSelecionado_G   = null;
var refreshPagina_G       = false;
var detParDTO_G           = null;
var respostaCorParDTO_G   = null;
var respostaNovoRef_G     = null;
var IP                    = null;
var PORTA                 = null;
var IP_L                  = null;
var IsIDWAtivo            = null;

//-------------------------------------------------------------- Scripts Adicionais ------------------------------------------------------------
$.getScript("js/lang/stringsPTBR.js");
$.getScript("js/utils/montaStrings.js");
$.getScript("js/utils/objetos.js");
$.getScript("js/efeitos/efeitos.js");
$.getScript("js/utils/dataUtils.js");
$.getScript("js/utils/mensagemRecebida.js");
$.getScript("js/utils/trataEventos.js");
$.getScript("js/utils/funcoesTcp.js");
$.getScript("js/utils/senha.js");
$.getScript("js/utils/stringUtils.js");
