var IE = document.all?true:false;

if (!IE){
	document.captureEvents(Event.MOUSEMOVE);
}
document.onmousemove = getMouseXY;
document.txtCdInjetora='';
var tempX = 0;
var tempY = 0;
var sobreinjetora = 0;
var mostrarlegenda = 1;




function funMenuInjetora()
{
	if (sobreinjetora==1)
		window.FW_showMenu(window.menuInjetora, tempX-30, tempY-5);
}

function funMenuIndicador()
{
	window.FW_showMenu(window.menuIndicador, tempX-30, tempY-5);
}

function funMenuTurno()
{
	window.FW_showMenu(window.menuTurnoA, tempX-120, tempY);
}

function funMenuPeso()
{
	window.FW_showMenu(window.menuPeso, tempX-235, tempY-5);
}

function funMenuOrdenacao()
{
	window.FW_showMenu(window.menuOrdenacao, tempX, tempY-5);
}


function getMouseXY(e) {
	if (IE) {
		tempX = event.clientX + document.body.scrollLeft;   
		tempY = event.clientY + document.body.scrollTop;
	} 
	else {
		tempX = e.pageX;
		tempY = e.pageY;
	}
	if (tempX < 0){
		tempX = 0;
	}
	if (tempY < 0){
		tempY = 0;
	}
	return true;
}


function hidePopUp(injetora){
		sobreinjetora = 0;
		 injetora.style.visibility='hidden';
}


function showPopUp(injetora, CdInjetora){
	sobreinjetora=1;
	 document.txtCdInjetora = CdInjetora;
   if (tempX + 300 > document.body.clientWidth)
        tempX = document.body.clientWidth-310;
	 if(IE) {
     injetora.style.pixelLeft=tempX;
     injetora.style.pixelTop=tempY;
     injetora.style.visibility='visible';
    }else {
      injetora.style.left=tempX;
      injetora.style.top=tempY;
      injetora.style.visibility='visible';
     }
}


isIE=document.all;
isNN=!document.all&&document.getElementById;
isN4=document.layers;
if (isIE||isNN){
	document.oncontextmenu=checkV;
}else{
	document.captureEvents(Event.MOUSEDOWN || Event.MOUSEUP);
	document.onmousedown=checkV;
}

var legendavisivel = false;

function checkV(e){
	if (isN4){
		if (e.which==2||e.which==3){
			funMenuInjetora();
			return false;
		}
	}else{
		funMenuInjetora();
		return false;
	}
}


function funMenuEscolhido(opcao)
{
	return ('monitor?action=2&subaction=' + opcao + '&cdinjetora='+document.txtCdInjetora);
}


function funIndicadorEscolhido(opcao)
{
	return ('monitor?action=2&subaction=20&indicador='+opcao);
}

function funTurnoEscolhido(opcao)
{
	return ('monitor?action=2&subaction=21&view='+opcao);
}

function funTurnoEscolhidoGrafico(opcao, grafico, indicador)
{
	if (grafico==124)
		return ('monitor?action=4&mostrarrefugo=true&cdturno=' + opcao + '&subaction=' + grafico + '&indicador=' + indicador + '&atualizar=2');
	else
		return ('monitor?action=4&cdturno=' + opcao + '&subaction=' + grafico + '&indicador=' + indicador + '&atualizar=2');
}



function funQuantidadeEscolhidaGrafico(opcao, grafico, indicador)
{
	return ('monitor?action=4&unidade=' + opcao + '&subaction=' + grafico + '&indicador=' + indicador);
}

function funTempoEscolhidoGrafico(opcao, grafico, indicador)
{
	return ('monitor?action=4&unidadetempo=' + opcao + '&scope=2&subaction=' + grafico + '&indicador=' + indicador);
}



function showAlerta(descricao){
	alert(descricao);
	escondeDIV(corpovazio_texto);
}

function showLegenda(le){
    le.style.visibility='visible';
   	if(IE){
   		le.style.pixelTop=document.body.clientHeight;
   		le.style.pixelLeft=document.body.clientWidth - 394;
		showLeg = setInterval("desenhaLegenda(legenda)",1);
	}
	else {
	   	le.style.top=document.body.clientHeight - 306;
	   	le.style.left=document.body.clientWidth - 394;
		legendavisivel = true;
	}
}

function hideLegenda(le){
	if(IE){
		le.style.pixelLeft=document.body.clientWidth - 394;
	  	le.style.pixelTop=document.body.clientHeight - 302;
		clearInterval(showLeg);
		showLeg = setInterval("apagaLegenda(legenda)",1);
		le.style.visibility='visible';
	}
	else{
		le.style.left=document.body.clientWidth - 394;
	  	le.style.top=document.body.clientHeight - 306;
	    le.style.visibility='hidden';
	    legendavisivel = false;
    }
}


function desenhaLegenda(le){
		if(IE) {
			le.style.pixelTop-=6;
			if (le.style.pixelTop + 302 <= document.body.clientHeight){
				legendavisivel = true;
				clearInterval(showLeg);
			}
	    }else {
		      le.style.left+=6;;
		      if (le.style.left >= 1) clearInterval(showLeg);
	    }

}

function apagaLegenda(le){
		if(IE) {
			le.style.pixelTop+=6;
			if (le.style.pixelTop >= document.body.clientHeight){
				le.style.visibility='hidden';
				le.style.pixelLeft=document.body.clientWidth - 394;
			  	le.style.pixelTop=document.body.clientHeight - 302;
				legendavisivel = false;
				clearInterval(showLeg);
			}
	    }else {
		      le.style.left-=6;
		      if (le.style.left <= -394) {
		      	le.style.visibility='hidden';
		      	clearInterval(showLeg);
		      	legendavisivel = false;
		      }
	    }

}

function menulegenda(){
	if (mostrarlegenda==1 && !legendavisivel){
		mostrarlegenda=2;
		showLegenda(legenda);
		}
	else
		if (mostrarlegenda==2 && legendavisivel){
			mostrarlegenda=1;
			hideLegenda(legenda);
		}
}

function menuparada()
{
	window.FW_showMenu(window.menuParada, tempX-235, tempY-5);
}


function funmenuproducao()
{
	window.FW_showMenu(window.menuProducao, tempX-235, tempY-5);
}

function menutempo()
{
	window.FW_showMenu(window.menuTempo, tempX-235, tempY-5);
}

function menuciclo()
{
	window.FW_showMenu(window.menuCiclo, tempX-235, tempY-5);
}

function menuperda()
{
	window.FW_showMenu(window.menuPerda, tempX-235, tempY-5);
}

function menurefugo()
{
	window.FW_showMenu(window.menuRefugo, tempX-235, tempY-5);
}


function funMenuParada(opcao)
{
	if (opcao == 134 || opcao == 135 || opcao==200)
		return ('monitor?action=4&mostrarparada=true&subaction=' + opcao);
	else
		return ('monitor?action=4&subaction=' + opcao);
}

function funMenuCiclo(opcao)
{
	return ('monitor?action=4&subaction=' + opcao);
}

function funMenuPerda(opcao)
{
	return ('monitor?action=4&subaction=' + opcao);
}

function funMenuRefugo(opcao)
{
	if (opcao >= 123 && opcao <= 124 || opcao == 301 || opcao==1240)
		return ('monitor?action=4&mostrarrefugo=true&subaction=' + opcao);
	else
		return ('monitor?action=4&subaction=' + opcao);
}


function escondeDIV(le){
    le.style.visibility='hidden';
}


function toggleLayer( whichLayer )
{
  var elem=0, vis;
  if( document.getElementById ) // this is the way the standards work
    elem = document.getElementById( whichLayer );
  else if( document.all ) // this is the way old msie versions work
      elem = document.all[whichLayer];
  else if( document.layers ) // this is the way nn4 works
    elem = document.layers[whichLayer];
  vis = elem.style;
  // if the style.display value is blank we try to figure it out here
  if(vis.display==''&&elem.offsetWidth!=undefined&&elem.offsetHeight!=undefined)
    vis.display = (elem.offsetWidth!=0&&elem.offsetHeight!=0)?'block':'none';
  vis.display = (vis.display==''||vis.display=='block')?'none':'block';
}