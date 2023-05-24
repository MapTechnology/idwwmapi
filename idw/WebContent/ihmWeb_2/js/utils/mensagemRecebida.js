//Funcoes de filtrar a mensagem vinda do servidor para transformar em classes

function getListaProducao(indiceproduto, indice, ordem){
	var listaProducao = [];
	
	var producao               = ProducaoDTO();
	producao.ordem             = ordem;
	producao.produto           = getChave("cdproduto" + indice + "|" + indiceproduto);
	producao.producaoplanejada = getChave("prodplan" + indice + "|" + indiceproduto);
	producao.producaorealizada = getChave("prodliquida" + indice + "|" + indiceproduto);
	producao.cip               = getChave("tipocip" + indice + "|" + indiceproduto);
	
	if(producao.produto == "-1"){
		return listaProducao;
	}
	
	listaProducao.push(producao);
	
	return listaProducao.concat(getListaProducao(indiceproduto, indice+1, ordem));
}

function getListaoperadores(indiceop, indice){
	
	var listaop = [];
	var opLogin = "";
	
	opLogin         = getChave("oplogin" + indice + "|" + indiceop);
	if(opLogin == "-1"){
		return listaop;
	}
	
	op              = OperadoresDTO();
	op.login        = opLogin;
	op.nome         = getChave("opnome" + indice + "|" + indiceop);
	op.dthrLogin    = getChave("inilogin" + indice + "|" + indiceop);
	op.duracaoLogin = getChave("durlogin" + indice + "|" + indiceop);
	
	listaop.push(op);
	
	return listaop.concat(getListaoperadores(indiceop, indice + 1));
	
}

function getListaAlertas(indicealerta , indice){
	var listaAlerta = [];
	
	var alertas = AlertasDTO();
	
	alertas.cdalerta   = getChave("cdalerta" + indice + "|" + indicealerta);
	alertas.dsalerta   = getChave("dsalerta" + indice + "|" + indicealerta);
	alertas.dthralerta = getChave("inialerta" + indice + "|" + indicealerta);
	
	if(alertas.cdalerta == "-1"){
		return listaAlerta;
	}
	
	listaAlerta.push(alertas);
	
	
	return listaAlerta.concat(getListaAlertas(indicealerta , indice + 1));
	
}

function getPts(indice){
	
	var pt       = PtDTO();
	var listapts = [];
	
	pt.dsup               = getChave("dsup" + indice);
	pt.dsgt               = getChave("dsgt" + indice);
	pt.idpt               = getChave("idpt" + indice);
	pt.iduppdba           = getChave("iduppdba" + indice);
	pt.idup               = getChave("idup" + indice);
	pt.idtppt             = getChave("tipopt" + indice);
	pt.indice             = indice;
	pt.isBcOffLine        = Boolean(getChave("bc" + indice)=="true");
	pt.islogonobrigatorio = getChave("islogonobrigatorio" + indice);
	pt.isihmtrocaop       = getChave("isihmtrocaop" + indice);
	pt.isoffline          = Boolean(getChave("isoffline" + indice)=="true");
	if(pt.dsup == -1){
		return listapts;
	}
	
	pt.semop              = getChave("semop" + indice);
	pt.tpSessao           = getChave("tpsessao" + indice);
	pt.isParada           = getChave("isparada" + indice);
	pt.parada.cdparada    = getChave("cdparada" + indice);
	pt.parada.isReqCancel = Boolean(getChave("reqcancel" + indice) == "true");
	try{
		pt.parada.ultp = String(getChave("ultp" + indice), 'UTF-8');
	}
	catch(err){
		pt.parada.ultp = getChave("ultp" + indice);
	}
	pt.parada.indiceParada        = indice;
	pt.parada.inip                = getChave("inip" + indice);
	pt.parada.isPermiteCorrecao   = Boolean(getChave("ispermitecorrecao" + indice) == "true");
	pt.isProduzindo               = Boolean(getChave("cdparada" + indice) == "true");
	pt.producao.ordem             = getChave("nrop" + indice);
	pt.producao.producaoplanejada = getChave("prodplan" + indice);
	pt.producao.producaorealizada = getChave("prodliquida" + indice);
	pt.producao.cip               = getChave("tipocip" + indice);
	pt.refugo.ultref              = getChave("ultref" + indice);
	pt.refugo.dtref               = getChave("dtref" + indice);
	pt.refugo.idrdzproduto        = getChave("idrdzproduto" + indice);
	pt.refugo.msdtref             = getChave("msdtref" + indice);
	pt.refugo.cdrefugo            = getChave("cdrefugo" + indice);
	
	pt.listaAlertas               = getListaAlertas(indice, 1);
	pt.listaOperadores            = getListaoperadores(indice, 1);
	pt.listaProducao              = getListaProducao(indice, 1 , pt.producao.ordem);
	listapts.push(pt);
	
	return listapts.concat(getPts(indice + 1));
	
}

function getServico(){
	if(getChave("ac") == -1){
		if(getChave("inicioparada") != -1){
			return INICIA_NOVA_PARADA; 
		}
		if(getChave("finalciclo") != -1){
			return CICLO;
		}
		return "0";
	} else{
		return ((respostaSessao_G != null) ? getChave("ac") : "0");
	}

}