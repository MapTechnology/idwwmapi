			function isFireFox(){
					var d, dom, ie, ie4, ie5x, moz, mac, win, lin, old, ie5mac, ie5xwin, op;
					
					d = document;
					n = navigator;
					na = n.appVersion;
					nua = n.userAgent;
					win = ( na.indexOf( 'Win' ) != -1 );
					mac = ( na.indexOf( 'Mac' ) != -1 );
					lin = ( nua.indexOf( 'Linux' ) != -1 );
					
					if ( !d.layers ){
						dom = ( d.getElementById );
						op = ( nua.indexOf( 'Opera' ) != -1 );
						konq = ( nua.indexOf( 'Konqueror' ) != -1 );
						saf = ( nua.indexOf( 'Safari' ) != -1 );
						moz = ( nua.indexOf( 'Gecko' ) != -1 && !saf && !konq);
						ie = ( d.all && !op );
						ie4 = ( ie && !dom );
					
						/*
						ie5x tests only for functionality. ( dom||ie5x ) would be default settings. 
						Opera will register true in this test if set to identify as IE 5
						*/
					
						ie5x = ( d.all && dom );
						ie5mac = ( mac && ie5x );
						ie5xwin = ( win && ie5x );
					}
					
					return moz;
			}

			function isIE(){
					var d, dom, ie, ie4, ie5x, moz, mac, win, lin, old, ie5mac, ie5xwin, op;
					
					d = document;
					n = navigator;
					na = n.appVersion;
					nua = n.userAgent;
					win = ( na.indexOf( 'Win' ) != -1 );
					mac = ( na.indexOf( 'Mac' ) != -1 );
					lin = ( nua.indexOf( 'Linux' ) != -1 );
					
					if ( !d.layers ){
						dom = ( d.getElementById );
						op = ( nua.indexOf( 'Opera' ) != -1 );
						konq = ( nua.indexOf( 'Konqueror' ) != -1 );
						saf = ( nua.indexOf( 'Safari' ) != -1 );
						moz = ( nua.indexOf( 'Gecko' ) != -1 && !saf && !konq);
						ie = ( d.all && !op );
						ie4 = ( ie && !dom );
					
						/*
						ie5x tests only for functionality. ( dom||ie5x ) would be default settings. 
						Opera will register true in this test if set to identify as IE 5
						*/
					
						ie5x = ( d.all && dom );
						ie5mac = ( mac && ie5x );
						ie5xwin = ( win && ie5x );
					}
					
					return ie;
			}

			function isIEFireFox(){
					var d, dom, ie, ie4, ie5x, moz, mac, win, lin, old, ie5mac, ie5xwin, op;
					
					d = document;
					n = navigator;
					na = n.appVersion;
					nua = n.userAgent;
					win = ( na.indexOf( 'Win' ) != -1 );
					mac = ( na.indexOf( 'Mac' ) != -1 );
					lin = ( nua.indexOf( 'Linux' ) != -1 );
					
					if ( !d.layers ){
						dom = ( d.getElementById );
						op = ( nua.indexOf( 'Opera' ) != -1 );
						konq = ( nua.indexOf( 'Konqueror' ) != -1 );
						saf = ( nua.indexOf( 'Safari' ) != -1 );
						moz = ( nua.indexOf( 'Gecko' ) != -1 && !saf && !konq);
						ie = ( d.all && !op );
						ie4 = ( ie && !dom );
					
						/*
						ie5x tests only for functionality. ( dom||ie5x ) would be default settings. 
						Opera will register true in this test if set to identify as IE 5
						*/
					
						ie5x = ( d.all && dom );
						ie5mac = ( mac && ie5x );
						ie5xwin = ( win && ie5x );
					}
					
					return moz || ie;
			}
			


			function qual_css( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					//d.write('<link rel = "stylesheet" type = "text\/css" href = "/css/celula-ctgargalo-completo-ie.css" />');
					d.write('<style type="text/css" media="all">@import "css/estilo-ie.css";</style>');
				}
				
				if ( isFireFox() ){
					//d.write('<link rel = "stylesheet" type = "text\/css" href = "/css/celula-ctgargalo-completo-ff.css" />');
					d.write('<style type="text/css" media="all">@import "css/estilo-ff.css";</style>');
				}
			}

			function qual_web_css( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					//d.write('<link rel = "stylesheet" type = "text\/css" href = "/css/celula-ctgargalo-completo-ie.css" />');
					d.write('<style type="text/css" media="all">@import "css/estilo-web-ie.css";</style>');
				}
				
				if ( isFireFox() ){
					//d.write('<link rel = "stylesheet" type = "text\/css" href = "/css/celula-ctgargalo-completo-ff.css" />');
					d.write('<style type="text/css" media="all">@import "css/estilo-ff.css";</style>');
				}
			}

function move(index,to) {
	var list = document.forms[0].galpoes;
	var total = list.options.length-1;
	if (index == -1) return false;
	if (to == +1 && index == total) return false;
	if (to == -1 && index == 0) return false;
	var items = new Array;
	var values = new Array;
	for (i = total; i >= 0; i--) {
		items[i] = list.options[i].text;
		values[i] = list.options[i].value;
	}
	for (i = total; i >= 0; i--) {
		if (index == i) {
			list.options[i + to] = new Option(items[i],values[i + to], 0, 1);
			list.options[i] = new Option(items[i + to], values[i]);
			i--;
		}
		else {
			list.options[i] = new Option(items[i], values[i]);
   		}
	}
	list.focus();
}


function submitForm() {
var list = document.form.list;
var theList = "?";
// start with a "?" to make it look like a real query-string
for (i = 0; i <= list.options.length-1; i++) { 
theList += "list" + list.options[i].value + "=" + list.options[i].text;
// a "&" only BETWEEN the items, so not at the end
if (i != list.options.length-1) theList += "&";
}
location.href = document.form.action + theList;
}

function verifica_horas(obj)
{
	if(obj.value.length < 8)
		obj.value = '';
	else
	{
		hr = parseInt(obj.value.substring(0,2));
		mi = parseInt(obj.value.substring(3,5));
		se = parseInt(obj.value.substring(6,8));
		if((hr < 0 || hr > 23) || (mi < 0 || mi > 60) || (se < 0 || se > 60 )||
		   (hr != obj.value.substring(0,2)) || (mi != obj.value.substring(3,5)) || (se != obj.value.substring(6,8)))
		{
			obj.value = '';
			alert('Hora inv�lida');
		}
	}
}

function valida_horas(edit, ev)
{
	li = new Array(':');
	liE = new Array(58);
	
	somenteNumero(edit,ev,li,liE);
	
	if(edit.value.length == 2 || edit.value.length == 5)
	edit.value += ":";
}

function somenteNumero(obj,e,liberado,liberadoE)
{

	var valor, val;
	
	if(liberado == '')
		liberado = new Array(',','.');
	if(liberadoE == '')
		liberadoE = new Array(188,190,8);

	valor = obj.value;
	if(document.all)
	{
		if(!((e.keyCode > 47 && e.keyCode < 58) || Array.find(liberadoE,e.keyCode) != '-1' ))
		{
			obj.value = valor.substr(0,valor.length - 1);
		}
	}
	else
	{
		val = '';
		
		for (x = 0; x < valor.length; x++)
		{
			if(!isNaN(valor[x]) || Array.find(liberado,valor[x]) != '-1')
			{
				val += valor[x];
			}
		}
		obj.value = val;
	}
}

Array.find = function(ary, element)
{
    for(var i=0; i<ary.length; i++)
	{
        if(ary[i] == element)
		{
            return i;
        }
    }
    return '-1';
};

var count1 = 0;
var count2 = 0;

function insertOptionBefore(num,elemento)
{
  var elSel = document.getElementById(elemento);
  if (elSel.selectedIndex >= 0) {
    var elOptNew = document.createElement('option');
    elOptNew.text = document.forms[0].galpao.value;
    elOptNew.value = document.forms[0].galpao.value;
    var elOptOld = elSel.options[elSel.selectedIndex];  
    try {
      elSel.add(elOptNew, elOptOld); // standards compliant; doesn't work in IE
    }
    catch(ex) {
      elSel.add(elOptNew, elSel.selectedIndex); // IE only
    }
  }
}

function removeOptionSelected(elemento)
{
  var elSel = document.getElementById(elemento);  
  var i;
  for (i = elSel.length - 1; i>=0; i--) {
    if (elSel.options[i].selected) {
      elSel.remove(i);
    }
  }
}

function appendOptionLast(origem,num,destino)
{
  var elOptNew = document.createElement('option');
  var bolAdd = 1;
  
  var indice = origem.selectedIndex;
  var valor = origem.options[indice].value;
  
  elOptNew.text = origem.options[indice].text;
  elOptNew.value = valor;
  
  var elSel = document.getElementById(destino);
  
  var i;
  
  if (elOptNew.text == ''){
  	bolAdd = 0;
  }else{
	  for (i = elSel.length - 1; i>=0; i--) {
	    if (elSel.options[i].value == origem.value) {
	      bolAdd = 0;
	    }
	  }
  }
  
  

  if (bolAdd){
	  try {
	    elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
	  }
	  catch(ex) {
	    elSel.add(elOptNew); // IE only
	  }
  }
}

function removeOptionLast(elemento)
{
  var elSel = document.getElementById(elemento);
  if (elSel.length > 0)
  {
    elSel.remove(elSel.length - 1);
  }
}

function pesquisa(strID, strDsCampo, strTipo, cdpt){	
	var el = document.getElementById(strID);  
	window.open('/idw/control?estilo=pesquisas&id=' + strID + '&valor=' + el.value + '&dscampo=' + strDsCampo + '&tipo=' + strTipo + "&cdpt=" + cdpt);
}

function removeTudo(elemento)
{
  var elSel = document.getElementById(elemento);  
  var i;
  for (i = elSel.length ; i>0; i = elSel.length) {    
      removeOptionLast(elemento);    
  }
}

function appendTudo(origem,num,destino,valor){

  var elOptNew = document.createElement('option');
  var bolAdd = 1;
  
  elOptNew.text = valor;
  elOptNew.value = valor;
  
  var elSel = document.getElementById(destino);
  
  var i;
  
  if (elOptNew.text == ''){
  	bolAdd = 0;
  }else{
	  for (i = elSel.length - 1; i>=0; i--) {
	    if (elSel.options[i].value == valor) {
	      bolAdd = 0;
	    }
	  }
	}
	
	if (bolAdd){
	  try {
	    elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
	  }
	  catch(ex) {
	    elSel.add(elOptNew); // IE only
	  }
  }
}

function selecionaTudo(elemento)
{
  var elSel = document.getElementById(elemento);  
  var i;
  for (i = elSel.length - 1; i>=0; i--) {
    elSel.options[i].selected = 1;
  }
}




			function usa_css_resumido( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					d.write('<style type="text/css" media="all">@import "css/celula-ctgargalo-resumido-ie.css";</style>');
				}
				
				if ( isFireFox() ){
					d.write('<style type="text/css" media="all">@import "css/celula-ctgargalo-resumido-ff.css";</style>');
				}
			}
			
			function usa_css_completo( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					//d.write('<link rel = "stylesheet" type = "text\/css" href = "/css/celula-ctgargalo-completo-ie.css" />');
					d.write('<style type="text/css" media="all">@import "css/celula-ctgargalo-completo-ie.css";</style>');
				}
				
				if ( isFireFox() ){
					//d.write('<link rel = "stylesheet" type = "text\/css" href = "/css/celula-ctgargalo-completo-ff.css" />');
					d.write('<style type="text/css" media="all">@import "css/celula-ctgargalo-completo-ff.css";</style>');
				}
			}

			function usa_css_extra( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					//d.write('<link rel = "stylesheet" type = "text\/css" href = "/css/celula-ctgargalo-completo-ie.css" />');
					d.write('<style type="text/css" media="all">@import "css/celula-ctgargalo-extra-ie.css";</style>');
				}
				
				if ( isFireFox() ){
					//d.write('<link rel = "stylesheet" type = "text\/css" href = "/css/celula-ctgargalo-completo-ff.css" />');
					d.write('<style type="text/css" media="all">@import "css/celula-ctgargalo-extra-ff.css";</style>');
				}
			}
			
			function usa_css_multiextra( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					d.write('<style type="text/css" media="all">@import "css/multi-celula-extra-ie.css";</style>');
				}
				
				if ( isFireFox() ){
					d.write('<style type="text/css" media="all">@import "css/multi-celula-extra-ff.css";</style>');
				}
			}
			
			function usa_css_ct_crescimento( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					d.write('<style type="text/css" media="all">@import "css/ct-crescimento-ie.css";</style>');
				}
				
				if ( isFireFox() ){
					d.write('<style type="text/css" media="all">@import "css/ct-crescimento-ff.css";</style>');
				}
			}
			
			function usa_css_gal_taxautilizacao( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					d.write('<style type="text/css" media="all">@import "css/gal-taxautilizacao-ie.css";</style>');
				}
				
				if ( isFireFox() ){
					d.write('<style type="text/css" media="all">@import "css/gal-taxautilizacao-ff.css";</style>');
				}
			}

			function usa_css_ct_rt_resumido( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					d.write('<style type="text/css" media="all">@import "css/ct-rt-resumido-ie.css";</style>');
				}
				
				if ( isFireFox() ){
					d.write('<style type="text/css" media="all">@import "css/ct-rt-resumido-ff.css";</style>');
				}
			}
			
			function usa_css_gal_oee( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					d.write('<style type="text/css" media="all">@import "css/gal-oee-ie.css";</style>');
				}
				
				if ( isFireFox() ){
					d.write('<style type="text/css" media="all">@import "css/gal-oee-ff.css";</style>');
				}
			}

			function usa_css_ct_compara_turno( ) {
				d = document;// shorthand so we don't have to write out document each time..

				if ( isIE() ){
					//d.write('<link rel = "stylesheet" type = "text\/css" href = "/css/celula-ctgargalo-completo-ie.css" />');
					d.write('<style type="text/css" media="all">@import "css/ct-compara-turno-er-ff.css";</style>');
				}
				
				if ( isFireFox() ){
					//d.write('<link rel = "stylesheet" type = "text\/css" href = "/css/celula-ctgargalo-completo-ff.css" />');
					d.write('<style type="text/css" media="all">@import "css/ct-compara-turno-er-ff.css";</style>');
				}
			}
