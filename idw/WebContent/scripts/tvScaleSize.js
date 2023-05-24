function scaleFontSizeCelulas(is5Celulas) {
	var w = window,
	d = document,
	e = d.documentElement,
	g = d.getElementsByTagName('body')[0],
	x = w.innerWidth || e.clientWidth || g.clientWidth,
	y = w.innerHeight|| e.clientHeight|| g.clientHeight;
	var ref = x > y ? x : y;
	if(x > y) {
		if(x/y > 1.7) {
			ref = y*1.7;
		} else {
			ref = x;
		}
	} else {
		ref = y;
	}
		
	var celulaSize1 = 0.01*(is5Celulas ? 4 : 3.77)*ref;
	var celulaSize2 = 0.01*(is5Celulas ? 3.6 : 4)*ref;
	var celulaSize3 = 0.01*(is5Celulas ? 2.7 : 2.33)*ref;
	var celulaSize = [celulaSize1, celulaSize2, celulaSize3];

	for(var j = 1; j <= 3; j++) {
		var elements = getElementsByClassName('celulaSize' + j.toString());
		
		for (var i = 0; i < elements.length; i++) {
		  var element = elements[i];
		  element.style.fontSize = celulaSize[j-1].toString() + "px";
		}
	}

	var turnoSize1 = 0.01*3.55*ref;
	var turnoSize2 = 0.01*8*ref;
	var turnoSize3 = 0.01*4.1*ref;
	var turnoSize = [turnoSize1, turnoSize2, turnoSize3];

	for(var j = 1; j <= 3; j++) {
		var elements = getElementsByClassName('turnoText' + j.toString());
		
		for (var i = 0; i < elements.length; i++) {
		  var element = elements[i];
		  element.style.fontSize = turnoSize[j-1].toString() + "px";
		}
	}

}

function scaleSizeMenuGT() {
	var w = window,
	d = document,
	e = d.documentElement,
	g = d.getElementsByTagName('body')[0],
	x = w.innerWidth || e.clientWidth || g.clientWidth,
	y = w.innerHeight|| e.clientHeight|| g.clientHeight;
	var ref = x > y ? x : y;
	if(x > y) {
		if(x/y > 1.7) {
			ref = y*1.7;
		} else {
			ref = x;
		}
	} else {
		ref = y;
	}
		
	var gtFontSize = 0.01*1.7*ref;
	var gtPaddingSize = 0.01*2*ref;

	var elementsBotao = getElementsByClassName('botaoGT');
	
	for (var i = 0; i < elementsBotao.length; i++) {
	  var element = elementsBotao[i];
	  element.style.fontSize = gtFontSize.toString() + "px";
	  element.style.padding = gtPaddingSize.toString() + "px";
	}
	
	var gtHeaderGTSize = 0.01*4*ref;
	
	var elementsHeader = getElementsByClassName('headerGTs');
	
	for (var i = 0; i < elementsHeader.length; i++) {
	  var element = elementsHeader[i];
	  element.style.fontSize = gtHeaderGTSize.toString() + "px";
	}


}