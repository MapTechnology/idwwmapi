// Eyenet Web Menu - R0X 2003 - 4.0

/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Ajuste - Cores, Bordas, Divisores, e outros ajustes...
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	eyemenu__sub_menu_width = 130;							//Largura Default dos Sub-Menus
 	eyemenu__sub_xy = "0,0";									//Coordenadas Padr�es dos Sub-Menus (X,Y)

	eyemenu__codebase = "scripts/";						//Pasta padrao onde se encontram os Arquivos JS
	eyemenu__urltarget = "_self";							//Target Padr�o das URLS: _self, _parent, _new, ou 'nome do frame'

	eyemenu__border_width = 1;								//Largura da Borda dos SubMenus
	eyemenu__divider_height = 1;								//Largura do Separador de �tens dos SubMenus

	eyemenu__border_color = "#CCCCCC";						//Cor da Borda do SubMenu, valor Hexa ou 'Transparent'
	eyemenu__menu_bgcolor = "#E3E3E3";						//Cor do Fundo do SubMenu, valor Hexa ou 'Transparent'
	eyemenu__hl_bgcolor = "#303478";							//Cor do Over do SubMenu, valor Hexa

	eyemenu__mouse_off_delay = 10;							//Define em Milisegundos (o aparecimento do menu depois que o mouse estiver parado)
	eyemenu__nn4_mouse_off_delay = 0;						//Define em Milisegundos (o tempo para o menu sumir depois de tirar o mouse de cima dele)
/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Ajuste - Fontes e Margens
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
    //Defini��o da Fonte (Cor, Tipo, Formata��o)

	eyemenu__textcolor = "#B29E72";
	eyemenu__fontfamily = "Tahoma, Arial, Helvetica";		//Qualquer fonte do Sistema
	eyemenu__fontsize = 10;									//Definido em Pixel
	eyemenu__fontsize_ie4 = 9;								//Definido em Point
	eyemenu__textdecoration = "normal";						//Valores Permitidos para: 'normal', ou 'underline'
	eyemenu__fontweight = "bold";							//Valores Permitidos para: 'normal', ou 'bold'
	eyemenu__fontstyle = "normal";							//Valores Permitidos para: 'normal', ou 'italic'

    //Defini��o para o Rollover de Fontes

	eyemenu__hl_textcolor = "#FFFFFF";
	eyemenu__hl_textdecoration = "normal";					//Valores Permitidos para: 'normal', ou 'underline'

    //Margens e Alinhamento de Textos

	eyemenu__text_alignment = "left";						//Valores Permitidos para: 'left', 'center' ou 'right'
	eyemenu__margin_top = 2;
	eyemenu__margin_bottom = 3;
	eyemenu__margin_left = 5;
	eyemenu__margin_right = 4;

/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: O Uso de �cones e Bullets � Ilimitado, voc� tamb�m pode definir abaixo imagens e associar a
::: largura de qualquer �tem do sub-menu e associar ela para toda estrutura dos menus
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Efeitos de Transi��o para Internet Explorer
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
    //Op��es do Menu - none | fade | pixelate | iris | slide | gradientwipe | checkerboard | radialwipe | randombars | randomdissolve |stretch

	eyemenu__sub_menu_effect = "fade";
	eyemenu__sub_item_effect = "fade";

    //Define a dura��o do Efeito em Segundos

	eyemenu__sub_menu_effect_duration = .3;
	eyemenu__sub_item_effect_duration = .3;

    //Especif�ca as Configura��es de Transi��o

	eyemenu__effect_pixelate_maxsqare = 25;
	eyemenu__effect_iris_irisstyle = "CIRCLE";						//CROSS, CIRCLE, PLUS, SQUARE, or STAR;
	eyemenu__effect_checkerboard_squaresx = 14;
	eyemenu__effect_checkerboard_squaresY = 14;
	eyemenu__effect_checkerboard_direction = "RIGHT";				//UP, DOWN, LEFT, RIGHT

    //Opacidade e Sombra

	eyemenu__sub_menu_opacity = 100;									//1 a 100
	eyemenu__dropshadow_color = "none";								//Valor Hexa da Cor ou 'none'
	eyemenu__dropshadow_offx = 5;									//Largura da Sombra
	eyemenu__dropshadow_offy = 5;									//Altura da Sombra

/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Ajuste de Bugs para que o menu funcione em TODOS os Navegadores
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
    //Ajustes para MAC - (Mac offset fixes, adjust until sub menus position correctly.)

	eyemenu__os9_ie5mac_offset_X = 10;
	eyemenu__os9_ie5mac_offset_Y = 15;

	eyemenu__osx_ie5mac_offset_X = 0;
	eyemenu__osx_ie5mac_offset_Y = 0;

	eyemenu__ie4mac_offset_X = -8;
	eyemenu__ie4mac_offset_Y = -50;

    //Ajustes para Netscape 4 - (Netscape 4 resize bug workaround.)

	eyemenu__nn4_reaload_after_resize = true;
	eyemenu__nn4_resize_prompt_user = false;
	eyemenu__nn4_resize_prompt_message = "Para Reinicializar o Menu de Navega��o, clique no bot�o Atualizar do seu Browser";

	//Sete para 'true' se o menu for o �nico �tem na p�gina

	eyemenu__use_opera_div_detect_fix = false;

    //Ajustes dos Sub-Menus - (Pr�-Define a altura dos �tens nos sub-menus para o Espial Escape browser.)

	eyemenu__escape_item_height = 20;
	eyemenu__escape_item_height0_0 = 70;
	eyemenu__escape_item_height0_1 = 70;
/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Eventos expostos do menu
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	//Referencia Adicional, para saber se o menu carregou ok

	//eyemenu__onload_code = "alert('custom function - onload')"
	//O 'X' indica o n�mero (index) no �tem ou no grupo do sub-menu.

	//eyemenu__showmenu_codeX = "status = 'custom show menu function call - menu0'"
	//eyemenu__hidemenu_codeX = "status = 'custom hide menu function call - menu0'"
	//eyemenu__clickitem_codeX_X = "alert('custom Function - Menu Item 0_0')"
/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Defini��es Espec�ficas dos Sub-Menus
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	//Abaixo voc� pode definir os ajustes dos sub-menus.
	//O 'X' representa o n�mero (index) do sub-menu.

	eyemenu__border_widthX = 10;
	eyemenu__divider_heightX = 5;
	eyemenu__border_colorX = "#0000ff";
	eyemenu__menu_bgcolorX = "#ff0000";
	eyemenu__hl_bgcolorX = "#00ff00";
	eyemenu__hl_textcolorX = "#FFFFFF";
	eyemenu__text_alignmentX = "left";

    //Abaixo voc� pode definir os ajustes dos �tens dos sub-menus.
    //O 'X' representa o n�mero (index) do �tem grupo do sub-menu.

	eyemenu__hl_subdescX = "custom highlight text";
	eyemenu__urltargetX = "_new";
//________________________________________________________________________________________________
//################################################################################################
//################# Configura��o do Menu Principal - Rollover de Imagens e Links #################
//################################################################################################
/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Menu Principal �tem 0 - PREFERENCIAS
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	eyemenu__rollover_image0 = "images/plastico/pt_BR/bt_pref_on.gif";
	eyemenu__rollover_wh0 = "80,29";
	eyemenu__url0 = "monitor?action=1";
/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Menu Principal �tem 1 - PRODUTOS
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	eyemenu__rollover_image1 = "images/plastico/pt_BR/bt_monitor_on.gif";
	eyemenu__rollover_wh1 = "80,29";
	eyemenu__url1 = "monitor?action=2";
/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Menu Principal �tem 2 - TURNO ATUAL
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	eyemenu__rollover_image2 = "images/plastico/pt_BR/bt_turno_on.gif";
	eyemenu__rollover_wh2 = "80,29";
	eyemenu__url2 = "monitor?action=3";
/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Menu Principal �tem 3 - ANALISE
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	eyemenu__rollover_image3 = "images/plastico/pt_BR/bt_periodo_on.gif";
	eyemenu__rollover_wh3 = "80,29";
	eyemenu__url3 = "monitor?action=4&subaction=8";

	/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Menu Principal �tem 4 - LEGENDA
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	eyemenu__rollover_image4 = "images/plastico/pt_BR/bt_legenda_on.gif";
	eyemenu__rollover_wh4 = "80,29";
	eyemenu__url4 = "javascript:menulegenda();";

	/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Menu Principal �tem 5 - IMPRIMIR
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	eyemenu__rollover_image5 = "images/plastico/pt_BR/bt_impressora_on.gif";
	eyemenu__rollover_wh5 = "80,29";
	eyemenu__url5 = "javascript:window.print();";

	/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Menu Principal �tem 6 - SAIR
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	eyemenu__rollover_image6 = "images/plastico/pt_BR/bt_sair_on.gif";
	eyemenu__rollover_wh6 = "80,29";
	eyemenu__url6 = "monitor?action=6";

	/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Menu Principal �tem 7 - ATUALIZAR
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	eyemenu__rollover_image7 = "images/plastico/pt_BR/bt_refresh_on.gif";
	eyemenu__rollover_wh7 = "80,29";
	eyemenu__url7 = "javascript:location.reload();";

	/*
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
::: Menu Principal �tem 8 - CARREIRA
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
*/
	eyemenu__rollover_image8 = "images/plastico/pt_BR/bt_voltar_on.gif";
	eyemenu__rollover_wh8 = "80,29";
	eyemenu__url8 = "javascript:history.back();";
