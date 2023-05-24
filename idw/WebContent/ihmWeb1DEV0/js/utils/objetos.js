//Criacao dos objetos utilizados

function MontagensDTO(){
	var retorno = {
			listaMontagem : null,
			resultado     : null
	}
}

function MontagemDTO(){
	var retorno = {
			cb                : null,
			dsProdutoEsperado : null,
		    idProdutoAcoplado : null,
		    idProdutoAgrupado : null,
		    idProdutoEsperado : null,
		    ordem             : null
	}
	
	return retorno;
}

function ReprocessoDTO(){
	var retorno = {
			pt                           : null,
			isSelecionouRefugo           : false,
			isInformarNovoDefeito        : false,
			isNsRefugado                 : false,
			isConforme                   : false,
			cbLido                       : null,
			opcaoValidacao               : 0,
			isFezAlgumaCoisaNoNS         : false
	}
	return retorno;
}

function RespostaCorrigeParadasDTO(){
	var retorno = {
			dwTCausa:   null,
			dwTAcao:    null,
			dwTCausa:   null,
			dwTParada:  null,
			usuarioDTO: null
	}
	return retorno;
}

function DetalhamentoParadaDTO(){
	var dto = {
			listaparadas:  null,
			usuarioLogado: null,
			dwConsolpalog: null
	}
	var retorno = {
			corrigeLogParadas: dto
	}
	return retorno;
}

function PesquisaDTO(){
	var retorno = {
			codigo:    "",
			descricao: "",
			registo:   null
			
	}
	return retorno;
}

function RefugoDTO(){
	var retorno = {
		ultref:       "",
		dtref:        "",
		msdtref:      "",
		idrdzproduto: "",
		cdrefugo:     "",
		qtde:         "",
		acao:         "",
		causa:        ""
		}
	return retorno;
} 

function ParadaDTO() {
	var retorno = {
		ultp:                 "",
		inip:                 "",
		cdparada:             "",
		isPermiteCorrecao:    false,
		isReqCancel:          false,
		indiceParada:         0,
		ApontouparadaNaoInfo: false
	}
	return retorno;
}

function OperadoresDTO() {
	var retorno = {
		login:        "",
		nome:         "",
		dthrLogin:    "",
		duracaoLogin: ""
	}
	return retorno;
}

function ProducaoDTO() {
	var retorno = {
		ordem:             "",
		produto:           "",
		producaoplanejada: "",
		producaorealizada: "",
		cip:               ""
	}
	return retorno;
}

function AlertasDTO() {
	var retorno = {
		cdalerta:   "",
		dsalerta:   "",
		dthralerta: ""
	}
	return retorno;
}

function PtDTO() {
	var retorno = {
		idpt:                "",
		idup:                "",
		iduppdba:            "",
		dsup:                "",
		dsgt:                "",
		idtppt:              "",
		islogonobrigatorio : "",
		isihmtrocaop:        "",
	
		parada:   ParadaDTO(),
		refugo:   RefugoDTO(),
		producao: ProducaoDTO(),
	
		isProduzindo: false,
		isBcOffLine:  false,
		isParada:     false,
		tpSessao:     false,
	 	indicePt:     0,
	
		semop:  "",
	
		listaAlertas:    [],
		listaOperadores: [],
		listaProducao:   []
	
	};
	return retorno;
}

function SessaoDTO(ptDto){
	var retorno = {
			pt: ptDto
	}
	return retorno;
}