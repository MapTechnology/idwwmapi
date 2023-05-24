var ihmApp = angular.module('ihmWeb', ['ui.router', 'ngCookies']);

var scopesC;
var scopesP;
var scopesA;
var scopesR;
var scopesO;
var scopesL;
var scopesPR;
var servicoG;
var scopesConsulta;

ihmApp.filter('filtroMaquinaIniciaOp', function () {
	return function (sessao) {
		var filtrado = [];
		for (var i = 0; i < sessao.length; i++) {
			var item = sessao[i];
			if (item.pt.semop != '-1' && item.pt.isoffline == false) {
				filtrado.push(item);
			}
		}
		return filtrado;
	};
});
ihmApp.filter('filtroMaquina', function () {
	return function (sessao) {
		var filtrado = [];
		for (var i = 0; i < sessao.length; i++) {
			var item = sessao[i];
			if (item.pt.semop == '-1' && item.pt.isoffline == false) {
				filtrado.push(item);
			}
		}
		return filtrado;
	};
});
ihmApp.filter('filtroMaquinaOnline', function () {
	return function (sessao) {
		var filtrado = [];
		for (var i = 0; i < sessao.length; i++) {
			var item = sessao[i];
			if (item.pt.isoffline == false) {
				filtrado.push(item);
			}
		}
		return filtrado;
	};
});

ihmApp.service('servicoGenerico', function () {
		var service = this;
		this.respostaGenerica = function (msg, classe) {
			$("#resposta_generica").slideUp()
			$("#resposta_generica").html(msg);
			$("#resposta_generica").removeClass();
			$("#resposta_generica").addClass("alert alert-" + classe);
			$("#resposta_generica").slideDown(800, function () {
				setTimeout(function () {
					$("#resposta_generica").slideUp(800);
				}, 1000)
			});
			// Remove o bug de fire twice
			// $("#resposta_generica").slideDown(1000, function () {
			// 	setTimeout(function () {
			// 		$("#resposta_generica").slideUp(1000);
			// 	}, 3000)
			// });
		}
		this.respostaGenericaAguarde = function (abrir) {
			$("#resposta_generica").slideUp() //
			$("#resposta_generica").html(AGUARDE_S);
			$("#resposta_generica").removeClass();
			$("#resposta_generica").addClass("alert alert-warning");
			if (abrir) {
				$("#resposta_generica").slideDown(1000);
			}
			else {
				$("#resposta_generica").slideUp(1000);
			}
		}

		this.enviaMsg = function (msg, dsup) {
			var logon = true;
			var isoffline = false;
			Sessoes_G.forEach(function cadaPt(element, index, array) {
				if (element.pt.dsup == dsup && element.pt.islogonobrigatorio == 'true' && element.pt.listaOperadores.length == 0 && msg.substring(0,4) != 'ac=8') {
					logon = false;
					isoffline = element.pt.isoffline;
					console.error("{f-enviaMsg} nao foi possivel enviar a msg: %s", msg);
					console.error("{f-enviaMsg} Detectado o logon obrigatorio da maquina %s e nenhum operador logado",dsup);
					return;
				}
			});
			var up = getChaveS("up=", msg);
			console.error(up + "{f-enviaMsg} . vou tentar enviar msg " + msg);

			if (up != '-1' || logon) {
				console.error("{f-enviaMsg} executando doSendConnect .x");
				doSendConnect(msg);
				console.error("{f-enviaMsg} executando doSend .x");
				var websocket = doSend(msg);
				setTimeout(function () {
					if(websocket.readyState == 1){
						console.error("{f-enviaMsg} enviada com sucesso");
						logMsgEnviada(msg);
						service.respostaGenerica(ENVIADO_SRV_S, SUCESSO_CLASSE);
					}else if(websocket.readyState == 3){
						console.error("{f-enviaMsg} NAO enviada");
						service.respostaGenerica(ENVIADO_SRV_FAL_S, FALHA_CLASSE)
					}
				}, 2000);
			}
			else {
				if (isoffline) {
					console.error("{f-enviaMsg} isoffline=true");
					window.history.back();
					setTimeout(function () { service.respostaGenerica(MAQ_OFFLINE_S, AVISO_CLASSE); }, 100);
					return;
				}
				console.error("{f-enviaMsg} LOGIN_OBRIGATORIO_S");
				window.history.back();
				setTimeout(function () { service.respostaGenerica(LOGIN_OBRIGATORIO_S, AVISO_CLASSE); }, 100);
			}


		}

		this.enviaMsgReprocesso = function (msg, dtoM, $state) {

			var up = getChaveS("up=", msg);
			
			console.error(up + "{f-enviaMsgReprocesso} . vou tentar enviar msg " + msg);

			if (up != '-1') {
				doSend(msg);
				console.error(up + "{f-enviaMsgReprocesso} . disparou doSend ");
				$state.go('ihmWeb.postoreprocesso', { dto: dtoM });
				setTimeout(function () { service.respostaGenerica(ENVIADO_SRV_S, SUCESSO_CLASSE); }, 100);
			}
			else {
				console.error(up + "{f-enviaMsgReprocesso} . LOGIN_OBRIGATORIO_S ");
				$state.go('ihmWeb.postoreprocesso', { dto: dtoM });
				setTimeout(function () { service.respostaGenerica(LOGIN_OBRIGATORIO_S, AVISO_CLASSE); }, 100);
			}


		}

		this.dataCerta = function (data) {
			var dataSplit = data.split("-");
			return (dataSplit[2] + "-" + dataSplit[1] + "-" + dataSplit[0]);
		}

		this.dataCertaParada = function (data) {
			var dataSplit = data.split("-");
			return (dataSplit[2] + "-" + dataSplit[1] + "-" + dataSplit[0]);
		}

	})

	.service('AuthService', function() {
		var ONE_HOUR = 60 * 60 * 1000;
		var validadeDoLogin = ONE_HOUR;

		var dataHoraDoLogin;
		var usuarioLogado;

		this.logadoComSucesso = function(usuario) {
			console.log("logado com sucesso data: "+ new Date());
			usuarioLogado = {dsNome: usuario.dsNome}
			dataHoraDoLogin = new Date();
		}

		this.isUsuarioLogado = function() {
			console.log("duracaoLogin: "+ this.getDuracaoDoLogin());
			return this.getDuracaoDoLogin() < validadeDoLogin;
		}

		this.getDuracaoDoLogin = function() {
			return ((new Date) - dataHoraDoLogin);
		}

		this.getUsuarioLogado = function() {
			return usuarioLogado;
		}


		this.authenticated = false;
		this.isAuthenticated = function () {
			return this.authenticated;
		}
		this.authenticate = function () {
			return this.authenticated = true;
		}
		this.deauthenticate = function () {
			return this.authenticated = false;
		}
	})

	.controller('EntrarController', ['$scope', '$state', 'AuthService', '$cookieStore', function ($scope, $state, AuthService, $cookieStore) {
		
		setTimeout(function () { montaStringEntrar(); }, 300);

		$scope.salvarDados = $cookieStore.get('salvarDados');
		$scope.inputSrv = $cookieStore.get('servidor');
		$scope.inputPorta = $cookieStore.get('porta');

		$scope.salvarDadosCheck = function () {
			if ($scope.salvarDados) {
				$cookieStore.put('salvarDados', $scope.salvarDados);
				$cookieStore.put('servidor', $scope.inputSrv);
				$cookieStore.put('porta', $scope.inputPorta);
			}
			else {

				$cookieStore.remove('salvarDados');
				$cookieStore.remove('servidor');
				$cookieStore.remove('porta');
			}
			return;
		}

		$scope.entrar = function () {
			AuthService.authenticate();
			$scope.salvarDadosCheck();
			$state.go('ihmWeb.producao');
			$scope.$apply();
		}

		scopesL = $scope;

	}])
	.controller('NavbarController', ['$scope', '$state', function ($scope, $state) {
		
		montaStringNavbar();

		$scope.resize = function () {
			$scope.full = document.fullScreen || document.mozFullScreen || document.webkitIsFullScreen;
			toggleFullScreen();
			if ($scope.full == true) {
				$("#btn_tela span").removeClass("glyphicon-resize-small").addClass("glyphicon-resize-full");
			}
			else {
				$("#btn_tela span").removeClass("glyphicon-resize-full").addClass("glyphicon-resize-small");
			}
		}

		$scope.consulta = function () {
			$state.go('ihmWeb.consulta');
		};
	}])

	.controller('SairController', ['$scope', 'AuthService', '$state', function ($scope, AuthService, $state) {
		montaStringSair();

		$scope.sair = function () {
			AuthService.deauthenticate();
			location.reload(true)
		};

		$scope.voltar = function () {
			window.history.back();
		}

	}])

	//--------------------------------------------------PRODUCAO-------------------------------------------------

	.controller('ProducaoController', ['$scope', 'servicoGenerico', function ($scope, servicoGenerico) {
		servicoG = servicoGenerico;
		$scope.sessao = Sessoes_G;
		$scope.prods = [];
		$scope.dusp = "";
		$scope.ordem = "";
		$scope.botaoFinOp = FINALIZAR_OP_S;
		$scope.botaoLancaCiclo = LANCAR_CICLO_S;

		Sessoes_G.forEach(function cadaPt(element, index, array) {
			element.pt.listaProducao.forEach(function cadaPt(elementLP, indexLP, arrayLP) {
				elementLP.pt = element.pt.dsup;
				elementLP.dusp = element.pt.dusp;
				elementLP.isParada = element.pt.isParada;
				elementLP.isoffline = element.pt.isoffline;
				elementLP.idpt = element.pt.idpt
				elementLP.idtppt = element.pt.idtppt
				$scope.prods.push(elementLP);

			})
		});
		montaStringProducao();
		$scope.atualiza = function () {
			$scope.sessao = Sessoes_G;
			$scope.prods = [];
			Sessoes_G.forEach(function cadaPt(element, index, array) {
				element.pt.listaProducao.forEach(function cadaPt(elementLP, indexLP, arrayLP) {
					elementLP.pt = element.pt.dsup;
					elementLP.isParada = element.pt.isParada;
					elementLP.isoffline = element.pt.isoffline;
					elementLP.idpt = element.pt.idpt
					elementLP.idtppt = element.pt.idtppt
					$scope.prods.push(elementLP);
				})
			});
			$scope.$apply();
		};

		scopesC = $scope;
		//console.log(elementLP);
	}])

	//-------------------------------------------------PARADAS-------------------------------------------------

	.controller('ParadasController', ['$scope', 'servicoGenerico', '$stateParams', function ($scope, servicoGenerico, $stateParams) {
		montaStringParadas();
		$scope.sessao = Sessoes_G;
		$scope.teste = $stateParams.teste;
		$scope.btnFinPar = FINALIZAR_PAR_S;
		$scope.btnCorUltPar = CORRIGIR_S;

		$scope.dataCerta = servicoGenerico.dataCertaParada;

		$scope.tempoParada = function (inicioParada) {
			var _SEG = 1000;
			var _MIN = 1000 * 60;
			var _HORA = 1000 * 3600;
			var dataInicio = new Date(inicioParada);
			var dataFinal = new Date();
			var dif = dataFinal.getTime() - dataInicio.getTime();
			return zeroEsquerda(Math.floor(dif / _HORA)) + "h-" + zeroEsquerda(Math.floor((dif % _HORA) / _MIN)) + "min-" +
				zeroEsquerda(Math.floor(((dif % _HORA) % _MIN) / _SEG)) + "s";

		};

		$scope.atualiza = function () {
			$scope.sessao = Sessoes_G;
			$scope.$apply();
		};
		scopesP = $scope;
	}])

	//-------------------------------------------------ALERTAS-------------------------------------------------

	.controller('AlertasController', ['$scope', 'servicoGenerico', function ($scope, servicoGenerico) {
		montaStringAlertas();
		$scope.alertas = [];
		$scope.dusp = "";
		$scope.cdalerta = "";
		$scope.sessao = Sessoes_G;
		$scope.btnRemAlerta = REMOVER_ALERTA_S;
		$scope.sessao.forEach(function cadaPt(element, index, array) {
			element.pt.listaAlertas.forEach(function cadaPt(elementLP, indexLP, arrayLP) {
				elementLP.pt = element.pt.dsup;
				$scope.alertas.push(elementLP);
			})
		});

		$scope.atualiza = function () {
			$scope.alertas = [];
			$scope.sessao = Sessoes_G;
			$scope.sessao.forEach(function cadaPt(element, index, array) {
				element.pt.listaAlertas.forEach(function cadaPt(elementLP, indexLP, arrayLP) {
					elementLP.pt = element.pt.dsup;
					$scope.alertas.push(elementLP);
				})
			});
			$scope.$apply();
		};
		scopesA = $scope;
	}])

	//-------------------------------------------------REFUGOS-------------------------------------------------

	.controller('RefugoController', ['$scope', 'servicoGenerico', function ($scope, servicoGenerico) {
		montaStringRefugos();
		$scope.sessao = Sessoes_G;
		$scope.btnApagaRef = APAGAR_ULT_REF;
		$scope.refugos = [];

		$scope.sessao.forEach(function pegaRefugo(element, index, array) {
			if (element.pt.refugo.dtref != null && element.pt.refugo.dtref != "null" && element.pt.refugo.cdrefugo != "-1") {
				element.pt.refugo.dsup = element.pt.dsup;
				$scope.refugos.push(element.pt.refugo);
			}
		});

		$scope.atualiza = function () {
			$scope.sessao = Sessoes_G;
			$scope.refugos = [];
			$scope.sessao.forEach(function pegaRefugo(element, index, array) {
				if (element.pt.refugo.dtref != null && element.pt.refugo.dtref != "null" && element.pt.refugo.cdrefugo != "-1") {
					element.pt.refugo.dsup = element.pt.dsup;
					$scope.refugos.push(element.pt.refugo);
				}
			});
			$scope.$apply();
		};
		scopesR = $scope;
	}])

	//-------------------------------------------------OPERADORES-------------------------------------------------

	.controller('OperadoresController', ['$scope', 'servicoGenerico', function ($scope, servicoGenerico) {
		$scope.sessao = Sessoes_G;
		$scope.operadores = [];
		$scope.operador = "";
		$scope.btnLogout = LOGOUT_S;
		$scope.sessao.forEach(function pegaOperadores(element, index, array) {
			if (element.pt.listaOperadores != []) {
				element.pt.listaOperadores.forEach(function pegaOper(elementOper, indexOper, arrayOper) {
					elementOper.dsup = element.pt.dsup;
					$scope.operadores.push(elementOper);
				});
			}
		});

		montaStringOperadores();
		$scope.atualiza = function () {
			var dsup;
			$scope.sessao = Sessoes_G;
			$scope.operadores = [];
			$scope.sessao.forEach(function pegaOperadores(element, index, array) {
				if (element.pt.listaOperadores != []) {
					element.pt.listaOperadores.forEach(function pegaOper(elementOper, indexOper, arrayOper) {
						elementOper.dsup = element.pt.dsup;
						$scope.operadores.push(elementOper);
					});
				}
			});
			$scope.$apply();
		};
		scopesO = $scope;
	}])

	// .controller('LancaCicloController', ['$scope', 'servicoGenerico', '$stateParams', function ($scope, servicoGenerico, $stateParams) {
	.controller('LancaCicloController', ['$scope', 'servicoGenerico', '$stateParams', '$state', 'AuthService', function ($scope, servicoGenerico, $stateParams, $state, AuthService) {
		$scope.sessao = Sessoes_G;
		$scope.dsup = $stateParams.pt;
		$scope.ordem = $stateParams.ordem;
		$scope.idpt = $stateParams.idpt;

		montaStringLancaCiclo($scope.ordem, $scope.dsup);

		$scope.lancaCiclo = function () {
			servicoGenerico.respostaGenericaAguarde(true);
			var qtde    = document.getElementById("inputQtde").value;
			if (! (parseInt(qtde) > 0))
				qtde = '1'
			var data = {};
			data["cdpt"] = $scope.dsup;
			data["cdcp"] = $scope.ordem;
			data["idpt"] = $scope.idpt;
			data["qtde"] = qtde;

			//var url = "http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "lancaCiclo";
			var url = "http://" + IP + ":" + PORTA + "/idw/rest/apontamentos/" + "lancaCiclo";
			$.ajax({
				type: "POST",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				url: url,
				data: data,
				dataType: 'text',
				timeout: 30000,
				success: function (response) {
					$state.go('ihmWeb.producao', { dto: $scope.dto });
					setTimeout(function () { servicoGenerico.respostaGenerica(ENVIADO_SRV_S, SUCESSO_CLASSE); }, 100);
					//window.history.back();
				},
				error: function () {
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				}
			});
		}

		$scope.voltar = function () {
			window.history.back();
		}


	}])
	.controller('FinalizaOpController', ['$scope', 'servicoGenerico', '$stateParams', function ($scope, servicoGenerico, $stateParams) {
		$scope.sessao = Sessoes_G;
		$scope.dsup = $stateParams.pt;
		$scope.ordem = $stateParams.ordem;

		montaStringFinalizaOp($scope.ordem, $scope.dsup);

		$scope.finalizaOp = function () {
			var msg = construirMensagemAserTransmitida($scope.ordem, FINALIZA_OP, $scope.dsup);
			servicoGenerico.enviaMsg(msg, $scope.dsup);
		}

		$scope.voltar = function () {
			window.history.back();
		}


	}])

	.controller('IniciaOpController', ['$scope', 'servicoGenerico', '$state', function ($scope, servicoGenerico, $state) {
		montaStringIniciaOp();
		$scope.sessao = Sessoes_G;
		$scope.ordem = "";

		$scope.iniciaOp = function (nrop) {
			var msg = construirMensagemAserTransmitida(nrop, NOVA_OP, $scope.dsup);
			servicoGenerico.enviaMsg(msg, $scope.dsup);
			// Para impedir que o operador clique duas vezes, removemos as ops consultadas
			$scope.listaCps = [];


			//$state.go('ihmWeb.producao', { dto: $scope.dto });
		}

		$scope.pesquisaPpcp = function () {
			if ($scope.dsup_sel.pt.semop == '-1') {
				servicoGenerico.respostaGenerica(MSG_OP_3_S, FALHA_CLASSE);
			}
			else {
				$scope.dsup = $scope.dsup_sel.pt.dsup;
				servicoGenerico.respostaGenericaAguarde(true);
				//var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "getPpCpByCdPt/" + $scope.dsup_sel.pt.dsup)
				var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/pts/" + "getPpCpByCdPt/" + $scope.dsup_sel.pt.dsup)
					, function () {
					})
					.done(function (success) {
						servicoGenerico.respostaGenericaAguarde(false);
						$("#span_inicia_op").empty();
						if (success.isIhmtrocaop == null || success.isIhmtrocaop == false) {
							$("#span_inicia_op").html(MSG_OP_1_S);
							return;
						}
						if (success.listaCps != null && success.listaCps.length == 0) {
							$("#span_inicia_op").html(MSG_OP_2_S);
							return;
						}
						if (success.isPtSemop == false) {
							$("#span_inicia_op").html(MSG_OP_3_S);
							return;
						}

						if (Array.isArray(success.listaCps)) {
							$scope.listaCps = success.listaCps;
						}
						else {
							$scope.listaCps = [];
							$scope.listaCps.push(success.listaCps);

						}
						//$scope.listaCps = success.listaCps;
						$scope.$apply();

						$("#tabela_inicia_op_corpo").find('tr').click(function () {
							var row = $(this).find('td:first').text();
							$scope.iniciaOp(row);
						});
					})
					.fail(function (error) {
						logConsoleLog(error);
					})
					.always(function (success) {
						logMsgEnviada(this.url);
					});
			}
		}

		$scope.voltar = function () {
			window.history.back();
		}


	}])

	.controller('NovoAlertaController', ['$scope', 'servicoGenerico', function ($scope, servicoGenerico) {
		montaStringNovoAlerta();
		$scope.sessao = Sessoes_G;

		$scope.novoAlerta = function (dsup, cdAlerta) {
			if (cdAlerta == "" || cdAlerta == null || $scope.dsup_sel == null) {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				return;
			}
			if (procuraAlerta(cdAlerta)) {
				servicoGenerico.respostaGenerica(ALERTA_ABERTO_S, AVISO_CLASSE);
				return;
			} else {
				var alerta = AlertasDTO();
				alerta.cdalerta = cdAlerta;
				var msg = construirMensagemAserTransmitida(alerta, INICIA_ALERTA, $scope.dsup_sel.pt.dsup);
				servicoGenerico.enviaMsg(msg, $scope.dsup_sel.pt.dsup);
			}
		}

		function procuraAlerta(cdAlerta) {
			if ($scope.dsup_sel.pt.listaAlertas.length > 0) {
				for (alerta in $scope.dsup_sel.pt.listaAlertas) {
					if ($scope.dsup_sel.pt.listaAlertas[alerta].cdalerta == cdAlerta) {
						return true
					}
				}
				return false;
			}
			return false;
		}

		$scope.voltar = function () {
			window.history.back();
		}

	}])

	.controller('RemoveAlertaController', ['$scope', 'servicoGenerico', '$stateParams', function ($scope, servicoGenerico, $stateParams) {
		montaStringRemoveAlerta();
		$scope.sessao = Sessoes_G;
		$scope.btnRemAlerta = REMOVER_ALERTA_S;
		$scope.dsup = $stateParams.pt;
		$scope.cdAlerta = $stateParams.cdAlerta;

		$scope.removeAlerta = function () {
			var msg = construirMensagemAserTransmitida($scope.cdAlerta, REMOVE_ALERTA, $scope.dsup);
			servicoGenerico.enviaMsg(msg, $scope.dsup);
		}

		$scope.voltar = function () {
			window.history.back();
		}

	}])

	.controller('ApagaRefugoController', ['$scope', 'servicoGenerico', '$stateParams', function ($scope, servicoGenerico, $stateParams) {
		montaStringApagaRefugo();
		$scope.sessao = Sessoes_G;
		$scope.btnApagaRefugo = APAGAR_ULT_REF;
		$scope.refugo = $stateParams.refugo;

		$scope.apagaRefugo = function () {
			var msg = construirMensagemAserTransmitida($scope.refugo, APAGAULTIMOREFUGO, $scope.refugo.dsup);
			servicoGenerico.enviaMsg(msg, $scope.refugo.dsup);
		}

		$scope.voltar = function () {
			window.history.back();
		}

	}])

	.controller('LogoutController', ['$scope', 'servicoGenerico', '$stateParams', function ($scope, servicoGenerico, $stateParams) {
		$scope.sessao = Sessoes_G;
		$scope.operador = $stateParams.operador;

		montaStringLogout($scope.operador.nome);

		$scope.logoutOperador = function () {
			var msg = construirMensagemAserTransmitida($scope.operador, LOGOUT, $scope.operador.dsup);
			servicoGenerico.enviaMsg(msg, $scope.operador.dsup);
		}

		$scope.voltar = function () {
			window.history.back();
		}

	}])

	.controller('LoginController', ['$scope', 'servicoGenerico', function ($scope, servicoGenerico) {
		montaStringLogin();
		$scope.sessao = Sessoes_G;
		$scope.logarOperador = function (login, senha, dsup) {
			if (login == "" || senha == "" || login == null || senha == null || dsup == null) {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				return;
			}
			if (verificaOperador(login)) {
				servicoGenerico.respostaGenerica(LOGADO_S, AVISO_CLASSE);
				return;
			}

			var data = {};
			var userDTO = {login:login, senha:senha};
			data = JSON.stringify(userDTO);
			var url = "http://" + IP + ":" + PORTA + "/idw/rest/usuarios/logar/";
			$.ajax({
				type: "POST",
				contentType: "application/json;charset=utf-8",
				url: url,
				data: data,
				timeout: 30000,
				success: function (response) {
					if (response.cdUsr != null && response.cdUsr != ''
						&& response.token != null && response.token != '' ) {
						var msg = construirMensagemAserTransmitidaLogin(login, senha, dsup, LOGIN);
						//doSend(msg);
						servicoGenerico.enviaMsg(msg, dsup);
					}
					else {
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					}
				},
				error: function () {
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				}
			});
			$scope.loginOperador = "";
			$scope.senhaOperador = "";
		}

		function verificaOperador(loginOp) {
			for (var operador in $scope.dsup_sel.pt.listaOperadores) {
				if ($scope.dsup_sel.pt.listaOperadores[operador].login == loginOp) {
					return true
				}
			}

			return false;
		}

		$scope.voltar = function () {
			window.history.back();
		}

	}])

	.controller('NovoRefugoController', ['$scope', 'servicoGenerico', function ($scope, servicoGenerico) {
		montaStringNovoRefugo();
		$scope.sessao = Sessoes_G;
		$scope.respostaNovoRef = null;
		$scope.causa = null;
		$scope.acao = null;
		$scope.sim = true;



		$scope.verificaNovoRefugo = function () {
			$scope.acao = true;
			$scope.causa = true;
			if ($scope.respostaNovoRef.isRequerAcao == "true" && $scope.respostaNovoRef.dwTAcao != null) {
				$scope.acao = true;
			}
			else {
				if ($scope.respostaNovoRef.isRequerAcao == "true") {
					$scope.acao = false;
				}
				else {
					$scope.respostaNovoRef.isRequerAcao = false;
				}
			}
			if ($scope.respostaNovoRef.isRequerCausa == "true" && $scope.respostaNovoRef.dwTCausa != null) {
				$scope.causa = true;
			}
			else {
				if ($scope.respostaNovoRef.isRequerCausa == "true") {
					$scope.causa = false;
				}
				else {
					$scope.respostaNovoRef.isRequerCausa = false;
				}
			}
			if ($scope.cdRefugo == "") {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				return;
			}
			if ($scope.acao && $scope.causa) {
				$scope.sim = false;
				$scope.$apply();
			}
		}

		$scope.novoRefugo = function () {
			if ($scope.qtdRef == null) {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				return;
			}
			var refugo = RefugoDTO();

			refugo.idrdzproduto = $scope.ref_prod_sel.produto;
			refugo.qtde = $scope.qtdRef;
			refugo.cdrefugo = $scope.respostaNovoRef.cdTrefugo;
			if ($scope.respostaNovoRef.isRequerCausa == "true" && $scope.respostaNovoRef.dwTCausa != null) {
				refugo.causa = $scope.respostaNovoRef.dwTCausa.cdTcausa;
			}
			else {
				refugo.causa = "";
			}

			if ($scope.respostaNovoRef.isRequerAcao == "true" && $scope.respostaNovoRef.dwTAcao != null) {
				refugo.acao = $scope.respostaNovoRef.dwTAcao.cdTacao;
			}
			else {
				refugo.acao = "";
			}

			if ($scope.dsup_sel == null) {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				return;
			}

			var msg = construirMensagemAserTransmitida(refugo, NOVOREFUGO, $scope.dsup_sel.pt.dsup);

			servicoGenerico.enviaMsg(msg, $scope.dsup_sel.pt.dsup);

			setTimeout(function () { servicoGenerico.respostaGenerica(ENVIADO_SRV_S, SUCESSO_CLASSE); }, 100);
		}

		$scope.pesquisaRefugo = function () {
			servicoGenerico.respostaGenericaAguarde(true);
			jqxhr = $.get("http://" + IP + ":" + PORTA + "/idw/rest/refugo/pesquisaRefugo/" + $scope.cdRefugo + "-" +
				$scope.dsup_sel.pt.idtppt
				, function (success) {
					servicoGenerico.respostaGenericaAguarde(false);
					if ($.isEmptyObject(success) || success.pesquisas.length == 0) {
						servicoGenerico.respostaGenericaAguarde(false);
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					}
					else {
						$scope.respostaNovoRef = success.pesquisas[0].registro;
						$scope.cdRefugo = (success.pesquisas[0].codigo + " - " + success.pesquisas[0].descricao);
						$scope.$apply();
						$scope.verificaNovoRefugo();
					}
				})
				.fail(function (error) {
					logConsoleLog(error);
					servicoGenerico.respostaGenericaAguarde(false);
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				})
				.always(function (success) {
					logMsgEnviada(this.url);
				});
		}

		$scope.consultaAcaoRef = function () {
			servicoGenerico.respostaGenericaAguarde(true);
			var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaAcao/" + $scope.acaoRef + "-" +
				$scope.dsup_sel.pt.idtppt)
				, function () {
				})
				.done(function (success) {
					servicoGenerico.respostaGenericaAguarde(false);
					if ($.isEmptyObject(success)) {
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					}
					else {
						$scope.respostaNovoRef.dwTAcao = success.pesquisa.registro;
						$scope.acaoRef = (success.pesquisa.codigo + " - " + success.pesquisa.descricao);
						$scope.$apply();
						$scope.verificaNovoRefugo();
					}
				})
				.fail(function (error) {
					logConsoleLog(error);
					servicoGenerico.respostaGenericaAguarde(false);
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				})
				.always(function (success) {
					logMsgEnviada(this.url);
				});
		}

		$scope.consultaCausaRef = function () {
			servicoGenerico.respostaGenericaAguarde(true)
			var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaCausa/" + $scope.causaRef + "-" +
				$scope.dsup_sel.pt.idtppt)
				, function () {
				})
				.done(function (success) {
					if ($.isEmptyObject(success)) {
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					}
					else {
						$scope.respostaNovoRef.dwTCausa = success.pesquisa.registro;
						$scope.causaRef = (success.pesquisa.codigo + " - " + success.pesquisa.descricao);
						$scope.$apply();
						$scope.verificaNovoRefugo();
					}
				})
				.fail(function (error) {
					logConsoleLog(error);
					servicoGenerico.respostaGenericaAguarde(false);
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				})
				.always(function (success) {
					logMsgEnviada(this.url);
				});
		}

		$scope.voltar = function () {
			window.history.back();
		}

	}])

	.controller('FinalizaParadaController', ['$scope', 'servicoGenerico', '$stateParams', function ($scope, servicoGenerico, $stateParams) {
		montaStringFinalizaParada();
		$scope.sessao = Sessoes_G;
		$scope.pt = $stateParams.pt;
		$scope.maq = MAQUINA_S;

		$scope.finalizaParada = function () {
			var msg = "";
			if ($scope.pt.parada.isReqCancel && $scope.pt.idtppt == "13") {
				msg = construirMensagemAserTransmitida('999', INFORMA_MOTIVO_PARADA, $scope.pt.dsup);
			}
			else {
				msg = construirMensagemAserTransmitida('', FINALIZA_PARADA, $scope.pt.dsup);
			}
			servicoGenerico.enviaMsg(msg, $scope.pt.dsup);
		}

		$scope.voltar = function () {
			window.history.back();
		}

	}])

	.controller('NovaParadaController', ['$scope', 'servicoGenerico', function ($scope, servicoGenerico) {
		montaStringNovaParada();
		$scope.sessao = Sessoes_G;

		$scope.novaParada = function () {
			if ($scope.dsup_sel == null || $scope.dsup_sel.pt.semop == "true") {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
			}
			else {
				msg = construirMensagemAserTransmitida("", INICIA_NOVA_PARADA, $scope.dsup_sel.pt.dsup);
				servicoGenerico.enviaMsg(msg, $scope.dsup_sel.pt.dsup);
			}
		}

		$scope.voltar = function () {
			window.history.back();
		}


	}])

	.controller('CorrigeUltimaParadaController', ['$scope', 'servicoGenerico', '$stateParams', function ($scope, servicoGenerico, $stateParams) {
		$scope.sessao = Sessoes_G;
		$scope.pt = $stateParams.pt;
		$scope.acao = false;
		$scope.causa = false;
		$scope.just = false;
		$scope.tecresp = false;
		$scope.tec = false;
		$scope.tec2 = false;
		$scope.respcdParada = false;
		$scope.cdParadaEnvio = '';

		montaStringCorrigeUltimaParada($scope.pt.dsup);

		$scope.pesquisaParada = function () {
			servicoGenerico.respostaGenericaAguarde(true);
			// var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaParada/" + $scope.cdParada + "-" +
			var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/paradas/" + "pesquisaParada/" + $scope.cdParada + "-" +
				$scope.pt.idtppt)
				, function () {
				})
				.done(function (success) {
					servicoGenerico.respostaGenericaAguarde(false)
					if ($.isEmptyObject(success)) {
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					}
					else {
						var pesquisa;
						if (Array.isArray(success.pesquisas)) {
							pesquisa = $scope.verificaPesquisa(success);
							if (pesquisa == 0) {
								servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
								return;
							}
						}
						else {
							pesquisa = success.pesquisas;
						}
						$scope.cdParadaEnvio = $scope.cdParada;
						$scope.cdParada = (pesquisa.codigo + " - " + pesquisa.descricao);
						$scope.acao = pesquisa.registro.isRequerAcao;
						$scope.causa = pesquisa.registro.isRequerCausa;
						$scope.just = pesquisa.registro.isRequerJust;
						if (pesquisa.registro.qtTec !== undefined) {
							switch (parseInt(pesquisa.registro.qtTec)) {
								case 1:
									$scope.tecresp = true;
									break;
								case 2:
									$scope.tecresp = true;
									$scope.tec1 = true;
									break;
								default:
									$scope.tecresp = true;
									$scope.tec = true;
									$scope.tec2 = true;
									break;
							}
						}
						if ($scope.acao || $scope.causa || $scope.just ) {
							var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaCausasJustificativasAcoes/" + $scope.pt.idtppt
								// + "?isCausa=" + ($scope.causa ? 1 : 0) + "&isAcao=" + ($scope.acao ? 1 : 0) +"&isJustificativa=" +  ($scope.just ? 1 : 0) )
								+ "?isCausa=1&isAcao=1&isJustificativa=1")
							, function () {
							}).done(function (success) {
								$scope.acaoCausaJust = success;
								$scope.$apply();
							}).fail(function (error) {
								logConsoleLog(error);
								servicoGenerico.respostaGenericaAguarde(false);
								servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
							});
						}
						$scope.respcdParada = true;
						$scope.$apply();
					}
				})
				.fail(function (error) {
					logConsoleLog(error);
					servicoGenerico.respostaGenericaAguarde(false);
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				})
				.always(function (success) {
					logMsgEnviada(this.url);
				});
		}

		$scope.verificaPesquisa = function (success) {
			var retorno = 0;
			success.pesquisas.forEach(function (element, index, array) {
				$scope.sessao.forEach(function (elementS, indexS, arrayS) {
					if (elementS.pt.dsup == $scope.pt.dsup) {
						if (element.registro.omTppt.idTppt == elementS.pt.idtppt) {
							retorno = element;
						}
					}
					if (retorno != 0) {
						return retorno;
					}
				});
				if (retorno != 0) {
					return retorno;
				}
			});
			return retorno;
		}

		$scope.corrigirUltimaParada = function () {
			var retorno = true;
			var dto = [$scope.cdParadaEnvio];
			if ($scope.acao) {
				if (typeof $scope.cdAcao.cdTacao !== 'undefined'){
					$scope.cdAcao = $scope.cdAcao.cdTacao;
				}
				if ($scope.cdAcao == "") {
					retorno = false;
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				}
			}
			dto.push($scope.cdAcao == undefined ? "" : $scope.cdAcao);
			if ($scope.causa) {
				if (typeof $scope.cdCausa.dwTCausa.cdTcausa !== 'undefined'){
					$scope.cdCausa = $scope.cdCausa.dwTCausa.cdTcausa;
				}
				if ($scope.cdCausa == "") {
					retorno = false;
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);

				}
			}
			dto.push($scope.cdCausa == undefined ? "" : $scope.cdCausa);
			if ($scope.just) {
				if (typeof $scope.cdJust.dwTJust.cdTjust !== 'undefined'){
					$scope.cdJust = $scope.cdJust.dwTJust.cdTjust;
				}
				if ($scope.cdJust == "") {
					retorno = false;
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);

				}
			}
			dto.push($scope.cdJust == undefined ? "" : $scope.cdJust);
			if ($scope.tecresp) {
				if ($scope.LTecresp == "" || $scope.sTecresp == "") {
					retorno = false;
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);

				}
			}
			dto.push($scope.LTecresp == undefined ? "" : $scope.LTecresp);
			dto.push($scope.sTecresp == undefined ? "" : $scope.sTecresp);
			if ($scope.tec) {
				if ($scope.LTec == "" || $scope.sTec == "") {
					retorno = false;
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);

				}
			}
			dto.push($scope.LTec == undefined ? "" : $scope.LTec);
			dto.push($scope.sTec == undefined ? "" : $scope.sTec);
			if ($scope.tec2) {
				if ($scope.LTec2 == "" || $scope.sTec2 == "") {
					retorno = false;
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				}
			}
			dto.push($scope.LTec2 == undefined ? "" : $scope.LTec2);
			dto.push($scope.sTec2 == undefined ? "" : $scope.sTec2);
			if (retorno) {
				var msg = construirMensagemAserTransmitida(dto, MOTIVO_PARADA, $scope.pt.dsup);
				servicoGenerico.enviaMsg(msg, $scope.pt.dsup);
			}
		}
		$scope.voltar = function () {
			window.history.back();
		}

	}])

	.controller('CorrecaoParadasController', ['$scope', 'servicoGenerico', '$stateParams', '$state', 'AuthService', function ($scope, servicoGenerico, $stateParams, $state, AuthService) {
		montaStringCorrecaoParadas();
		$scope.sessao = Sessoes_G;
		$scope.pesquisando = false;
		$scope.detParDTO = null;
		$scope.dtoRetorno = null;
		$scope.maq = MAQUINA_S;
		$scope.pesq = PESQUISAR_S;

		$scope.dataCerta = servicoGenerico.dataCerta;

		$scope.pesquisarParadas = function () {
			$scope.pesquisando = true;
			if ($scope.dsup_sel == null) {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				return;
			}
			servicoGenerico.respostaGenericaAguarde(true);
			jqxhr = $.post("http://" + IP + ":" + PORTA + "/idw/rest/todo/getOcorrenciasParadas", {
				dataFim: getDataAtual(0),
				dataInicio: getDataAtual(-10),
				dsUp: $scope.dsup_sel.pt.dsup
			}
				, function (success) {
					servicoGenerico.respostaGenericaAguarde(false);
					$scope.pesquisando = false;
					$scope.detParDTO = success;
					if ($.isEmptyObject(success) == false && ($scope.detParDTO.listaparadas.length != null)) {
						$scope.detParDTO.listaparadas.reverse();
					}
					else {
						if ($.isEmptyObject(success) == false) {
							var aux = [];
							aux.push($scope.detParDTO.listaparadas);
							$scope.detParDTO.listaparadas = aux;
						}
					}
					$scope.$apply();
				})
				.fail(function (error) {
					logConsoleLog(error);
					$scope.pesquisando = false;
					servicoGenerico.respostaGenericaAguarde(false);
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				});
		};

		$scope.corrigir = function () {
			if ($scope.detParDTO == null || $scope.dsup_sel == null || $(".checkParada:checked").length == 0) {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
			}
			else {
				$scope.dtoRetorno = DetalhamentoParadaDTO();
				$scope.dtoRetorno.corrigeLogParadas.listaparadas = [];
				var i;
				for (i = 0; i < $(".checkParada:checked").length; i++) {
					$scope.dtoRetorno.corrigeLogParadas.listaparadas.push($scope.detParDTO.listaparadas[$(".checkParada:checked")[i].defaultValue]);
					$scope.dtoRetorno.corrigeLogParadas.listaparadas[i].maquina = $scope.dsup_sel.pt.dsup;
				}
				$scope.dtoRetorno.corrigeLogParadas.dwConsolpalog = $scope.detParDTO.listaparadas[0].dwConsolpaoco;

				if(AuthService.isUsuarioLogado()) {
					$scope.dtoRetorno.corrigeLogParadas.usuarioLogado = AuthService.getUsuarioLogado();
					$state.go('ihmWeb.correcaoparadascorrige', { dto: $scope.dtoRetorno, pt: $scope.dsup_sel.pt });
				} else {
					$state.go('ihmWeb.correcaoparadaslogin', { dto: $scope.dtoRetorno, pt: $scope.dsup_sel.pt });
				}
			}
		}

		$scope.voltar = function () {
			window.history.back();
		}

	}])

	.controller('CorrecaoParadasLoginController', ['$scope', 'servicoGenerico', '$state', '$stateParams','AuthService', function ($scope, servicoGenerico, $state, $stateParams, AuthService) {
		montaStringCorrecaoParadasLogin();
		$scope.sessao = Sessoes_G;
		$scope.dto = $stateParams.dto;
		$scope.pt = $stateParams.pt;
		$scope.logar = function () {

			if ($scope.login == null || $scope.senha == null) {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				return;
			}
			else {
				servicoGenerico.respostaGenericaAguarde(true);
				var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "isUsuarioAutenticado/" + $scope.login + "-" +
					senha($scope.senha))
					, function () {
					})
					.done(function (success) {
						servicoGenerico.respostaGenericaAguarde(false);
						if (success.resultadoEvento == 0) {
							AuthService.logadoComSucesso(success.usuario);
							$scope.dto.corrigeLogParadas.usuarioLogado = AuthService.getUsuarioLogado();
							$state.go('ihmWeb.correcaoparadascorrige', { dto: $scope.dto, pt: $scope.pt });
						}
						else {
							servicoGenerico.respostaGenerica(USUARIO_FAIL_S, FALHA_CLASSE);
						}
					})
					.fail(function (error) {
						logConsoleLog(error);
						servicoGenerico.respostaGenericaAguarde(false);
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					})
					.always(function (success) {
						logMsgEnviada(this.url);
					});
			}
		}

		$scope.voltar = function () {
			$state.go('ihmWeb.paradas');
		}

	}])
	.controller('CorrecaoParadasCorrigeController', ['$scope', 'servicoGenerico', '$state', '$stateParams', function ($scope, servicoGenerico, $state, $stateParams) {
		montaStringCorrecaoParadasCorrige();
		$scope.sessao = Sessoes_G;
		$scope.dto = $stateParams.dto;
		$scope.pt = $stateParams.pt;
		$scope.acao = false;
		$scope.causa = false;
		$scope.just = false;
		$scope.parada = false;
		$scope.corrigir = false;
		$scope.respCdAcao = false;
		$scope.respCdCausa = false;
		$scope.respCdJust = false;

		$scope.corrigirParadasSelecionadas = function () {
			var data = {};
			data["corrigeLogParadas"] = JSON.stringify($scope.dto.corrigeLogParadas);
			var url = "http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "corrigeLogParadas";
			$.ajax({
				type: "POST",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				url: url,
				data: data,
				dataType: 'text',
				timeout: 30000,
				success: function (response) {
					if (response == "1") {
						$state.go('ihmWeb.correcaoparadas');
						setTimeout(function () { servicoGenerico.respostaGenerica(ENVIADO_SRV_S, SUCESSO_CLASSE); }, 500);
					}
					else {
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					}
				},
				error: function () {
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				}
			});
		}

		$scope.pesquisaAcao = function () {
			servicoGenerico.respostaGenericaAguarde(true);
			var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaAcao/" + $scope.cdAcao + "-" +
				$scope.pt.idtppt)
				, function () {
				})
				.done(function (success) {
					servicoGenerico.respostaGenericaAguarde(false);
					if ($.isEmptyObject(success)) {
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					}
					else {
						var pesquisa;
						if (Array.isArray(success.pesquisa)) {
							pesquisa = verificaAcao(success);
							if (pesquisa == 0) {
								servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
								return;
							}
						}
						else {
							pesquisa = success.pesquisa;
							$scope.dto.corrigeLogParadas.dwConsolpalog.dwTAcao = success.pesquisa.registro;
						}
						$scope.cdAcao = (pesquisa.codigo + " - " + pesquisa.descricao);
						$scope.respCdAcao = true;
					}
					verificarParadasSelecionadas();
					$scope.$apply();
				}).fail(function (error) {
					logConsoleLog(error);
					servicoGenerico.respostaGenericaAguarde(false);
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				})
				.always(function (success) {
					logMsgEnviada(this.url);
				});
		}

		$scope.verificaAcao = function (success) {
			var retorno = 0;
			success.pesquisa.forEach(function (element, index, array) {
				$scope.sessao.forEach(function (elementS, indexS, arrayS) {
					if (elementS.pt.dsup == $("#select_corrigir_paradas").val()) {
						if (element.registro.omTppt.idTppt == elementS.pt.idtppt) {
							if ($scope.dto != null) {
								$scope.dto.corrigeLogParadas.dwConsolpalog.dwTAcao = element.registro;
							}
							retorno = element;
						}
					}
					if (retorno != 0) {
						return retorno;
					}
				});
				if (retorno != 0) {
					return retorno;
				}
			});
			return retorno;
		}

		$scope.pesquisaCausa = function () {
			servicoGenerico.respostaGenericaAguarde(true);
			var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaAcao/" + $scope.cdCausa + "-" +
				$scope.pt.idtppt)
				, function () {
				})
				.done(function (success) {
					servicoGenerico.respostaGenericaAguarde(false);
					if ($.isEmptyObject(success)) {
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					}
					else {
						var pesquisa;
						if (Array.isArray(success.pesquisa)) {
							pesquisa = verificaCausa(success);
							if (pesquisa == 0) {
								servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
								return;
							}
						}
						else {
							pesquisa = success.pesquisa;
							$scope.dto.corrigeLogParadas.dwConsolpalog.dwTCausa = success.pesquisa.registro;
						}
						$scope.cdCausa = (pesquisa.codigo + " - " + pesquisa.descricao);
						$scope.respCdCausa = true;
					}
					verificarParadasSelecionadas();
					$scope.$apply();
				}).fail(function (error) {
					logConsoleLog(error);
					servicoGenerico.respostaGenericaAguarde(false);
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				})
				.always(function (success) {
					logMsgEnviada(this.url);
				});
		}

		$scope.verificaCausa = function (success) {
			var retorno = 0;
			success.pesquisa.forEach(function (element, index, array) {
				$scope.sessao.forEach(function (elementS, indexS, arrayS) {
					if (elementS.pt.dsup == $("#select_corrigir_paradas").val()) {
						if (element.registro.omTppt.idTppt == elementS.pt.idtppt) {
							if ($scope.dto != null) {
								$scope.dto.corrigeLogParadas.dwConsolpalog.dwTCausa = element.registro;
							}
							retorno = element;
						}
					}
					if (retorno != 0) {
						return retorno;
					}
				});
				if (retorno != 0) {
					return retorno;
				}
			});
			return retorno;
		}

		$scope.pesquisaJust = function () {
			servicoGenerico.respostaGenericaAguarde(true);
			var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaJustificativa/" + $scope.cdJust + "-" +
				$scope.pt.idtppt)
				, function () {
				})
				.done(function (success) {
					servicoGenerico.respostaGenericaAguarde(false);
					if ($.isEmptyObject(success)) {
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					}
					else {
						var pesquisa;
						if (Array.isArray(success.pesquisa)) {
							pesquisa = verificaJust(success);
							if (pesquisa == 0) {
								servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
								return;
							}
						}
						else {
							pesquisa = success.pesquisa;
							$scope.dto.corrigeLogParadas.dwConsolpalog.dwTJust = success.pesquisa.registro;
						}
						$scope.cdJust = (pesquisa.codigo + " - " + pesquisa.descricao);
						$scope.respCdJust = true;
					}
					verificarParadasSelecionadas();
					$scope.$apply();
				}).fail(function (error) {
					logConsoleLog(error);
					servicoGenerico.respostaGenericaAguarde(false);
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				})
				.always(function (success) {
					logMsgEnviada(this.url);
				});
		}

		$scope.verificaJust = function (success) {
			var retorno = 0;
			success.pesquisa.forEach(function (element, index, array) {
				$scope.sessao.forEach(function (elementS, indexS, arrayS) {
					if (elementS.pt.dsup == $("#select_corrigir_paradas").val()) {
						if (element.registro.omTppt.idTppt == elementS.pt.idtppt) {
							if ($scope.dto != null) {
								$scope.dto.corrigeLogParadas.dwConsolpalog.dwTJust = element.registro;
							}
							retorno = element;
						}
					}
					if (retorno != 0) {
						return retorno;
					}
				});
				if (retorno != 0) {
					return retorno;
				}
			});
			return retorno;
		}

		$scope.pesquisaParada = function () {
			if ($scope.cdParada == "") {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
			}
			else {
				servicoGenerico.respostaGenericaAguarde(true);
				var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaParada/" + $scope.cdParada + "-" + $scope.pt.idtppt)
					, function () {
					})
					.done(function (success) {
						servicoGenerico.respostaGenericaAguarde(false);
						var pesquisa;
						if ($.isEmptyObject(success)) {
							servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
						}
						else {
							if (Array.isArray(success.pesquisa)) {
								pesquisa = verificaPesquisa(success, 0);
								if (pesquisa == 0) {
									servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
									return;
								}
							}
							else {
								pesquisa = success.pesquisa;
								$scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada = success.pesquisa.registro;
							}
							if ($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isPermitecorrecao == "false") {
								servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
								return;
							}
							$scope.cdParada = (pesquisa.codigo + " - " + pesquisa.descricao);
							$scope.respCdParada = true;
							if ($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerAcao == "true") {
								$scope.acao = true;
							}
							if ($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerCausa == "true") {
								$scope.causa = true;
							}
							if ($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerJust == "true") {
								$scope.just = true;
							}
							$scope.$apply();
						}
					})
					.fail(function (error) {
						logConsoleLog(error);
						servicoGenerico.respostaGenericaAguarde(false);
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
					})
					.always(function (success) {
						logMsgEnviada(this.url);
					});
			}
		}

		$scope.verificarParadasSelecionadas = function () {
			var acao = true;
			var causa = true;
			var just = true;
			if ($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerAcao == "true") {
				if ($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerAcao == "true" && $scope.dto.corrigeLogParadas.dwConsolpalog.dwTAcao != null) {
					acao = true;
				}
				else {
					acao = !Boolean($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerAcao);
				}
			}
			else {
				acao = true;
			}
			if ($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerCausa == "true") {
				if ($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerCausa == "true" && $scope.dto.corrigeLogParadas.dwConsolpalog.dwTCausa != null) {
					causa = true;
				}
				else {
					causa = !Boolean($scope.dto.corrigeLogParadas.dwConsolpalog.dwTCausa.isRequerCausa);
				}
			}
			else {
				causa = true;
			}
			if ($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerJust == "true") {
				if ($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerJust == "true" && $scope.dto.corrigeLogParadas.dwConsolpalog.dwTJust != null) {
					just = true;
				}
				else {
					just = !Boolean($scope.dto.corrigeLogParadas.dwConsolpalog.dwTParada.isRequerJust);
				}
			}
			else {
				just = true;
			}
			if (acao && causa && just) {
				$scope.corrigir = true;
			}
		}

		$scope.verificaPesquisa = function (success) {
			var retorno = 0;
			success.pesquisa.forEach(function (element, index, array) {
				$scope.sessao.forEach(function (elementS, indexS, arrayS) {
					if (elementS.pt.dsup == $scope.pt.dsup) {
						if (element.registro.omTppt.idTppt == elementS.pt.idtppt) {
							retorno = element;
						}
					}
					if (retorno != 0) {
						return retorno;
					}
				});
				if (retorno != 0) {
					return retorno;
				}
			});
			return retorno;
		}

		$scope.voltar = function () {
			$state.go('ihmWeb.paradas');
		}

	}])

	.controller('ConsultaController', ['$scope', 'servicoGenerico', function ($scope, servicoGenerico) {
		montaStringConsulta();
		$scope.sessao = Sessoes_G;
		$scope.consultaS = "";
		$scope.listaConsultas = listaDeConsulta;
		$scope.respConsulta = false;
		$scope.resultadoConsulta = "";

		$scope.consultar = function (consultaSelecionada) {

			$scope.consultaS = consultaSelecionada.numero;
			if ($scope.dsup_sel == null) {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
			}
			else {
				var msg = construirMensagemAserTransmitida(consultaSelecionada.numero, CONSULTA, $scope.dsup_sel.pt.dsup);
				doSend(msg);
				servicoGenerico.respostaGenericaAguarde(true);
			}
		}

		$scope.voltar = function () {
			if ($scope.respConsulta == false) {
				window.history.back();
			}
			else {
				$scope.respConsulta = false;
			}

		}

		$scope.trataRespostaConsulta = function (msg) {
			$scope.respConsulta = true;
			if (msg == "fail") {
				servicoGenerico.respostaGenericaAguarde(false);
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
			}
			else {
				servicoGenerico.respostaGenericaAguarde(false);
				var resultado = "";
				resultado = getChaveS(_PROD_LIQ, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + PROD_LIQ_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_EFI_REAL, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + EFI_REAL_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "%</span>");
				}
				resultado = getChaveS(_PROD_REF, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + PROD_REF_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_INDI_REF, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + INDI_REF_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "%</span>");
				}
				resultado = getChaveS(_A_PRODUZIR, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + A_PRODUZIR_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_OP, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + OPC_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_CD_PRODUTO, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + CD_PRODUTO_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_CICLO_PADRAO, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + CICLO_PADRAO_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_CICLO_MEDIO, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + CICLO_MEDIO_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_INDI_PAR_TURNO, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + INDI_PAR_TURNO_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "%</span>");
				}
				resultado = getChaveS(_INDI_PAR_OP, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + INDI_PAR_OP_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "%</span>");
				}
				resultado = getChaveS(_EFI_CIC_TURNO, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + EFI_CIC_TURNO_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "d</span>");
				}
				resultado = getChaveS(_EFI_CIC_OP, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + EFIC_CIC_OP_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "%</span>");
				}
				resultado = getChaveS(_INTERVALO_HR, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + INTERVALO_HR_S + " min</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_DS_TURNO, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + DS_TURNO_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_QTD_PROD, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + QTD_PROD_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_PROD, msg);
				if (resultado !== "-1") {
					var i = 0;
					var resultadoP = getChaveS(_PROD + i, msg);
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + PRODUTOS_S + "</h3>");
					if (resultadoP !== "-1") {
						for (i = 1; resultadoP !== "-1"; i++) {
							$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h4 class='respostaConsulta'>" + resultadoP + "</h4>");
							resultadoP = getChaveS(_PROD + i, msg);
						}
					}
					else {
						$scope.resultadoConsulta = $scope.resultadoConsulta + ("<span class='respostaConsulta'>" + resultado + "</span>");
					}


				}
				resultado = getChaveS(_DTHR, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + DTHR_CIP_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_DURATION, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + DURATION_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "</span>");
				}
				resultado = getChaveS(_PROD_OEE, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + PROD_OEE_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "%</span>");
				}
				resultado = getChaveS(_META_OEE, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + META_OEE_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "%</span>");
				}
				resultado = getChaveS(_IND_QLD, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + IND_QLD_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "%</span>");
				}
				resultado = getChaveS(_IND_UTL, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + IND_UTL_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "%</span>");
				}
				resultado = getChaveS(_IND_EFC, msg);
				if (resultado !== "-1") {
					$scope.resultadoConsulta = $scope.resultadoConsulta + ("<h3>" + INDE_EFC_S + "</h3>" + "<span class='respostaConsulta'> " + resultado + "%</span>");
				}
				$("#link_consulta").html(CONSULTA_S + " - " + $scope.consultaS);
				$scope.$apply();
			}

		}
		scopesConsulta = $scope;

	}])
	.controller('PostoReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {
		montaStringPostoReprocesso();
		$scope.sessao = Sessoes_G;
		$scope.dto = $stateParams.dto;
		if ($scope.dto == null) {
			$scope.dto = ReprocessoDTO();
		} else {
			$scope.pt = $stateParams.dto.pt;
			$("#input_cb_reprocesso").val("");
			$("#input_cb_reprocesso").focus();
		}

		$scope.selecionaPt = function () {
			$scope.pt = $scope.dsup_sel.pt;
			setTimeout(function () { $("#input_cb_reprocesso").focus() }, 1000);
		}

		$scope.myFunct = function (keyEvent) {
			if (keyEvent.which === 13) {
				servicoGenerico.respostaGenericaAguarde(true);

				if ($scope.pt.islogonobrigatorio == 'true' && $scope.pt.listaOperadores.length == 0) {
					servicoGenerico.respostaGenerica(LOGIN_OBRIGATORIO_S, AVISO_CLASSE);
					$("#input_cb_reprocesso").val("");
					return;
				}

				var isRetorno = false;
				var isNsRefugado = false;
				var ompt = null;
				var opcaoValidacao = null;

				var get = $.ajax({
					url: ("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "isNumeroSerieRefugado/" + $scope.cbLido),
					success: function (success) {
						//isNsRefugado = Boolean(success);
						isNsRefugado = (success);
					},
					fail: function (fail) { isRetorno = true },
					//async: false
				}).always(function () {
					get = $.ajax({
						url: ("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "getOmPt/" + $scope.pt.dsup),
						success: function (success) {
							if (success == '-1' || success.pt == null) {
								isRetorno = true;
							}
							// ompt = (success.pt);
							ompt = success.Pt;
							$scope.dto.ompt = ompt;
						},
						fail: function (fail) { isRetorno = true },
						//async: false
					}).always(function () {
						get = $.ajax({
							url: ("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "getValidarNumeroDeSerie/" + $scope.pt.dsup + '----' + $scope.pt.producao.ordem + '----' +
								$scope.cbLido + '----' + $scope.cbLido + '----' + ompt.idPt),
							success: function (success) {
								if (success == '-1') {
									isRetorno = true;
								}
								opcaoValidacao = parseInt(success);
							},
							fail: function (fail) { isRetorno = true },
							// async: false
						}).always(function () {
							$scope.dto.pt = $scope.pt;
							$scope.dto.cbLido = $scope.cbLido;
							$scope.dto.opcaoValidacao = opcaoValidacao;
							// $state.go('ihmWeb.solicitadefeitoreprocesso' , {dto: $scope.dto});
							if (isNsRefugado == true) {
								$state.go('ihmWeb.produtorefugadoreprocesso', { dto: $scope.dto });
							} else {
								// Se opcaoValidacao = 3 entao CB invalido com NAO CONFORMIDADE
								if (opcaoValidacao != 3) {
									$state.go('ihmWeb.serialconformereprocesso', { dto: $scope.dto });
								}
							}
							$scope.dto.isNsRefugado = isNsRefugado;
							$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
						});
					});
				});
			}
		}


		$scope.atualiza = function () {
			$scope.sessao = Sessoes_G;
			$scope.$apply();
		};
		scopesPR = $scope;
	}])

	.controller('ProdutoRefugadoReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {
		montaStringProdutoRefugadoReprocesso();
		$scope.dto = $stateParams.dto;

		$scope.sim = function () {
			$scope.dto.isRefugado = true;
			$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
		}

		$scope.nao = function () {
			$scope.dto.isRefugado = false;
			$state.go('ihmWeb.postoreprocesso', { dto: $scope.dto });
		}

	}])

	.controller('SerialConformeReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {
		montaStringSerialConformeReprocesso();
		$scope.dto = $stateParams.dto;

		$scope.novo_defeito = function () {
			$scope.dto.isInformarNovoDefeito = true;
			$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
		}

		$scope.ok = function () {
			$scope.dto.isInformarNovoDefeito = false;
			$state.go('ihmWeb.postoreprocesso', { dto: $scope.dto });
		}

	}])

	.controller('MenuMainReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {

		$scope.dto = $stateParams.dto;
		montaStringMenuMainReprocesso($scope.dto.isNsRefugado);

		$scope.visualizarNS = function () {
			servicoGenerico.respostaGenericaAguarde(true);
			$scope.dto.isInformarNovoDefeito = true;
			get = $.ajax({
				url: ("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "obtemNaoConformidadesAtuais/" + $scope.dto.cbLido + '----' + $scope.dto.pt.dsup),
				success: function (success) {
					//servicoGenerico.respostaGenericaAguarde(false);
					if (success.naoConformidadesAtuais != null && success.naoConformidadesAtuais.length > 0) {
						$state.go('ihmWeb.visualizarncreprocesso', { dto: $scope.dto, passagemDTO: success });
					}
					servicoGenerico.respostaGenerica(MSG_N_E_N_C_S, AVISO_CLASSE);
				},
				fail: function (fail) { },
				// async: false
			});

		}

		$scope.novoDefeito = function () {

			$state.go('ihmWeb.situacaocbreprocesso', { dto: $scope.dto });
		}

		$scope.novaMontagem = function () {
			var folhamon;
			var muda = false;
			$scope.dto.isInformarNovoDefeito = false;
			servicoGenerico.respostaGenericaAguarde(true);
			get = $.ajax({
				url: ("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "getDwFolhaPassagem/" + $scope.dto.pt.dsup + '----' + $scope.dto.pt.producao.ordem + '----' +
					$scope.dto.cbLido),
				success: function (success) {
					//servicoGenerico.respostaGenericaAguarde(false);
					if (success != null && success.dwFolhamons != null) {
						if (Array.isArray(success.dwFolhamons) && success.dwFolhamons.length > 0) {
							// folhamon = dwfolha.dwFolhamons[0];
							folhamon = success.dwFolhamons[0];
						}
						else {
							folhamon = success.dwFolhamons;
						}
					}
					//if (folhamon == null || folhamon.dwFolhamoncomps == null || folhamon.dwFolhamoncomps.length <= 0) {
					if (folhamon == null || folhamon.dwFolhamoncomps == null) {
						servicoGenerico.respostaGenerica(SEM_REF_MONT_S, AVISO_CLASSE);
						return;
					}
					muda = true;

					if (muda) {
						$state.go('ihmWeb.solicitamontagemreprocesso', { dto: $scope.dto, folhamoncomps: folhamon.dwFolhamoncomps });
					}
				},
				fail: function (fail) { },
				//async: false
			});
			// if(muda){
			// 	$state.go('ihmWeb.solicitamontagemreprocesso' , {dto: $scope.dto , folhamoncomps: folhamon.dwFolhamoncomps});
			// }
			//servicoGenerico.respostaGenerica(SEM_REF_MONT_S , AVISO_CLASSE);
		}

		$scope.refugo = function () {
			if ($scope.dto.isNsRefugado) {
				$state.go('ihmWeb.cancelarefugoreprocesso', { dto: $scope.dto });
			} else
				$state.go('ihmWeb.novorefugoreprocesso', { dto: $scope.dto });
		}

		$scope.voltar = function () {
			$state.go('ihmWeb.postoreprocesso', { dto: $scope.dto });
		}

	}])

	.controller('SituacaoCBReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {
		montaStringSituacaoCBReprocesso();
		$scope.dto = $stateParams.dto;

		$scope.sim = function () {
			$scope.dto.isConforme = true;
			var data = {};
			data["cdPt"] = $scope.dto.pt.dsup;
			data["cdOp"] = $scope.dto.pt.producao.ordem;
			data["cb"] = $scope.dto.cdLido;
			data["dthr"] = getDataAtualRep(0);
			data["stTeste"] = 1;
			data["qtde"] = 1;
			if ($scope.dto.opcaoValidacao == 2 || $scope.dto.opcaoValidacao == 3) {
				data["qtde"] = 0;
			}

			var url = "http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "regristrarTesteSimples";
			$.ajax({
				type: "POST",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				url: url,
				data: data,
				dataType: 'text',
				timeout: 30000,
				success: function (response) {

				},
				error: function () {
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				}
			});

			$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
		}

		$scope.nao = function () {
			$scope.dto.isConforme = false;
			$state.go('ihmWeb.solicitadefeitoreprocesso', { dto: $scope.dto });
		}

	}])

	.controller('SolicitaDefeitoReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {

		$scope.dto = $stateParams.dto;
		$scope.isInformouAlgumDefeito = false;
		$scope.defeitoString = DEFEITO_S;

		//$("#input_defeito_reprocesso").focus();
		$("#input_defeito_reprocesso");

		montaStringSolicitaDefeitoReprocesso();
		servicoGenerico.respostaGenericaAguarde(true);

		var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaDwTDefeitoTppt/" + $scope.dto.pt.idtppt)
			, function () {
			})
			.done(function (success) {
				servicoGenerico.respostaGenericaAguarde(false);
				if ($.isEmptyObject(success)) {
				}
				else {
					$scope.listaDefeitos = success.pesquisas;
					$scope.$apply();
				}
			})
			.fail(function (error) {
				logConsoleLog(error);
				servicoGenerico.respostaGenericaAguarde(false);
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
			})
			.always(function (success) {
				logMsgEnviada(this.url);
			});

		$scope.myFunct = function (keyEvent) {
			if (keyEvent.which === 13) {
				if (Array.isArray($scope.listaDefeitos)) {
					$scope.listaDefeitos.forEach(function cadaPt(element, index, array) {
						if (element.codigo == $scope.defeitoLido) {
							$scope.apontaDefeito(element);
							return
						}
					});
					$("#input_defeito_reprocesso").val('');
					$("#input_defeito_reprocesso").focus();
				}
				else {
					if ($scope.listaDefeitos.codigo == $scope.defeitoLido) {
						$scope.apontaDefeito($scope.listaDefeitos);
						return
					}
					$("#input_defeito_reprocesso").val('');
					$("#input_defeito_reprocesso").focus();
				}
			}
		}

		$scope.apontaDefeito = function (defeito) {

			$scope.dto.isFezAlgumaCoisaNoNS = true;
			servicoGenerico.respostaGenericaAguarde(true);

			var data = {};
			data["cdPt"] = $scope.dto.pt.dsup;
			data["cdOp"] = $scope.dto.pt.producao.ordem;
			data["cb"] = $scope.dto.cbLido;
			data["dthr"] = getDataAtualRep(0);
			data["cdDefeito"] = defeito.registro.cdTdefeito;
			data["qtde"] = 1;
			if ($scope.dto.opcaoValidacao == 2 || $scope.dto.opcaoValidacao == 3) {
				data["qtde"] = 0;
			}

			var url = "http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "registrarTesteDefeito";
			$.ajax({
				type: "POST",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				url: url,
				data: data,
				dataType: 'text',
				timeout: 30000,
				success: function (response) {

				},
				error: function () {
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				}
			});

			$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });

		}

		$scope.voltar = function () {
			$state.go('ihmWeb.postoreprocesso', { dto: $scope.dto });
		}

	}])

	.controller('SolicitaMontagemReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {
		//montaStringSolicitaMontagemReprocesso();
		$scope.dto = $stateParams.dto;
		$scope.folhamoncomps = $stateParams.folhamoncomps;
		$scope.montagemString = CB_S;
		$scope.mascara = null;
		$scope.produto = null;
		$scope.indice = 0;
		$scope.listaDto = [];
		if (Array.isArray($scope.folhamoncomps)) {
			$scope.montagemEsperada = $stateParams.folhamoncomps[$scope.indice].omProduto.idProduto;
		}
		else {
			$scope.montagemEsperada = $stateParams.folhamoncomps.omProduto.idProduto;
		}

		$scope.myFunct = function (keyEvent) {
			if (keyEvent.which === 13) {
				servicoGenerico.respostaGenericaAguarde(true);
				if ($scope.mascara == null) {
					var get = $.ajax({
						url: ("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "getMascaraCdProdutomp"),
						success: function (success) {
							//servicoGenerico.respostaGenericaAguarde(false);
							if (success != '-1') {
								$scope.mascara = success;
							}
						},
						fail: function (fail) { },
						async: false
					});
				}

				var cdProduto = extraiPorMascara($scope.montagemLida, $scope.mascara);

				var get = $.ajax({
					url: ("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "getIdOmProduto/" + cdProduto),
					success: function (success) {
						if (success != '-1') {
							$scope.produto = success;
						}
					},
					fail: function (fail) { },
					async: false
				});

				if ($scope.produto != null) {
					// if($folhamoncomps[$scope.indice].omProduto.idProduto == $scope.produto){
					if (Array.isArray($scope.folhamoncomps)) {
						if ($scope.folhamoncomps[$scope.indice].omProduto.idProduto == $scope.produto) {
							var montDto = MontagemDTO();
							montDto.cb = $scope.montagemLida;
							montDto.dsProdutoEsperado = $scope.folhamoncomps[$scope.indice].dsMon;
							montDto.ordem = $scope.folhamoncomps[$scope.indice].ordem;
							montDto.idProdutoEsperado = $scope.folhamoncomps[$scope.indice].omProduto.idProduto;
							montDto.idProdutoAcoplado = $scope.produto;
							$scope.listaDto.push(montDto);
						}
					}
					else {
						if ($scope.folhamoncomps.omProduto.idProduto == $scope.produto) {
							var montDto = MontagemDTO();
							montDto.cb = $scope.montagemLida;
							montDto.dsProdutoEsperado = $scope.folhamoncomps.dsMon;
							montDto.ordem = $scope.folhamoncomps.ordem;
							montDto.idProdutoEsperado = $scope.folhamoncomps.omProduto.idProduto;
							montDto.idProdutoAcoplado = $scope.produto;
							$scope.listaDto.push(montDto);
						}
					}
				}
				else {
					servicoGenerico.respostaGenerica(MONTAGEM_INVALIDA_S, AVISO_CLASSE);
					$("#input_montagem_reprocesso").val('');
					$("#input_montagem_reprocesso").focus();
					return;
				}
			}
			else {
				servicoGenerico.respostaGenerica(MONTAGEM_INVALIDA_S, AVISO_CLASSE);
				$("#input_montagem_reprocesso").val('');
				$("#input_montagem_reprocesso").focus();
				return;
			}

			if (Array.isArray($scope.folhamoncomps)) {
				$scope.indice++;
				if ($scope.indice < $scope.folhamoncomps.length) {
					$scope.$apply();
					$("#input_montagem_reprocesso").val('');
					$("#input_montagem_reprocesso").focus();
					return;
				}
				else {
					$scope.dto.isMontagemComSucesso = true;

					var montagem = new MontagensDTO();
					montagem.listaMontagem = $scope.listaDto;

					var qtde = 1;
					if ($scope.dto.opcaoValidacao == 2 || $scope.dto.opcaoValidacao == 3) {
						qtde = 0;
					}

					var data = {};
					data["cdPt"] = $scope.dto.pt.dsup;
					data["cdOp"] = $scope.dto.pt.producao.ordem;
					data["cb"] = $scope.dto.cbLido;
					data["dthr"] = getDataAtualRep(0);
					data["lista"] = JSON.stringify(montagem);
					data["qtde"] = 1;
					if ($scope.dto.opcaoValidacao == 2 || $scope.dto.opcaoValidacao == 3) {
						data["qtde"] = 0;
					}

					var url = "http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "registrarMontagem";
					$.ajax({
						type: "POST",
						contentType: "application/x-www-form-urlencoded;charset=utf-8",
						url: url,
						data: data,
						dataType: 'text',
						timeout: 30000,
						success: function (response) {

						},
						error: function () {
							servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
						}
					});

					$scope.dto.isFezAlgumaCoisaNoNS = true;

					$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
				}
			}
			else {
				$scope.dto.isMontagemComSucesso = true;
					var montagem = new MontagensDTO();
					montagem.listaMontagem = $scope.listaDto;

					var qtde = 1;
					if ($scope.dto.opcaoValidacao == 2 || $scope.dto.opcaoValidacao == 3) {
						qtde = 0;
					}

					var data = {};
					data["cdPt"] = $scope.dto.pt.dsup;
					data["cdOp"] = $scope.dto.pt.producao.ordem;
					data["cb"] = $scope.dto.cbLido;
					data["dthr"] = getDataAtualRep(0);
					data["lista"] = JSON.stringify(montagem);
					data["qtde"] = 1;
					if ($scope.dto.opcaoValidacao == 2 || $scope.dto.opcaoValidacao == 3) {
						data["qtde"] = 0;
					}

					var url = "http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "registrarMontagem";
					$.ajax({
						type: "POST",
						contentType: "application/x-www-form-urlencoded;charset=utf-8",
						url: url,
						data: data,
						dataType: 'text',
						timeout: 30000,
						success: function (response) {

						},
						error: function () {
							servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
						}
					});

					$scope.dto.isFezAlgumaCoisaNoNS = true;

					$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
			}

		}
	}])

	.controller('NovoRefugoReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {
		montaStringNovoRefugoReprocesso();
		$scope.dto = $stateParams.dto;

		$scope.novoRefugo = function () {
			if ($scope.qtdRef == null) {
				servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				return;
			}
			var refugo = {};

			refugo.idrdzproduto = $scope.ref_prod_sel.produto;
			refugo.qtde = $scope.qtdRef;
			refugo.cdrefugo = $scope.cdRefugo;
			refugo.cb = $scope.cbLido;

			var msg = construirMensagemAserTransmitidaReprocesso(refugo, NOVOREFUGO, $scope.dto.pt.dsup);


			servicoGenerico.enviaMsgReprocesso(msg, $scope.dto, $state);
		}

		$scope.voltar = function () {
			$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
		}

	}])

	.controller('CancelaRefugoReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {
		montaStringCancelaRefugoReprocesso();
		$scope.dto = $stateParams.dto;

		$scope.apagaRefugo = function () {
			var refugo = {};
			refugo.cb = $scope.dto.cbLido;
			var msg = construirMensagemAserTransmitidaReprocesso(refugo, APAGAULTIMOREFUGO, $scope.dto.pt.dsup);
			servicoGenerico.enviaMsgReprocesso(msg, $scope.dto, $state);
		}

		$scope.voltar = function () {
			$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
		}

	}])

	.controller('VisualizarNCReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {
		montaStringVisualizarNCReprocesso();
		$scope.dto = $stateParams.dto;
		$scope.passagemDTO = $stateParams.passagemDTO;

		$scope.corrigirNC = function () {
			servicoGenerico.respostaGenericaAguarde(true);
			var retorna = false;
			var dtoAcao;

			if ($(".checkNc:checked").length <= 0) {
				servicoGenerico.respostaGenerica(NENHUM_DEFEITO_SEL_S, FALHA_CLASSE);
				return;
			}

			var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaDwTAcao/" + $scope.dto.pt.idtppt)
				, function () {
				})
				.done(function (success) {
					//servicoGenerico.respostaGenericaAguarde(false);
					if ($.isEmptyObject(success)) {
						servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
						retorna = true;
					}
					else {
						dtoAcao = success.pesquisas
						//$state.go('ihmWeb.selecionaracaoncreprocesso' , {dto: $scope.dto , ncs: $(".checkNc:checked") , acoes: dtoAcao , passagemDTO: $scope.passagemDTO  });
						if (Array.isArray($scope.passagemDTO.naoConformidadesAtuais))
							$state.go('ihmWeb.selecionaracaoncreprocesso', { dto: $scope.dto, ncs: $scope.passagemDTO.naoConformidadesAtuais[$(".checkNc:checked")[0].value], acoes: dtoAcao, passagemDTO: $scope.passagemDTO });
						else
							$state.go('ihmWeb.selecionaracaoncreprocesso', { dto: $scope.dto, ncs: $scope.passagemDTO.naoConformidadesAtuais, acoes: dtoAcao, passagemDTO: $scope.passagemDTO });
					}
				})
				.fail(function (error) {
					logConsoleLog(error);
					servicoGenerico.respostaGenericaAguarde(false);
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				})
				.always(function (success) {
				logMsgEnviada(this.url);
			});

			if (retorna) {
				servicoGenerico.respostaGenerica(NAO_TEM_ACAO_S, FALHA_CLASSE);
				return;
			}
			// 	$state.go('ihmWeb.selecionaracaoncreprocesso' , {dto: $scope.dto , ncs: $(".checkNc:checked") , acoes: dtoAcao , passagemDTO: $scope.passagemDTO  });

		}

		$scope.voltar = function () {
			$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
		}

		$scope.ok = function () {
			$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
		}

	}])

	.controller('SelecionarAcaoNCReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {
		montaStringSelecionarAcaoNCReprocesso();
		$scope.dto = $stateParams.dto;
		$scope.ncs = $stateParams.ncs;
		$scope.acoes = $stateParams.acoes;
		$scope.passagensDTO = $stateParams.passagemDTO;
		$scope.dto.pt.idtppt // ENVIAR PARA O WEBSERVICE;

		$scope.corrigirNC = function (acao) {
			// if($scope.ncs.length == null){
			if (!($scope.ncs.constructor === Array)) {
				$scope.isArray = 'false';
				if ($scope.ncs.idTDefeito == null && $scope.ncs.idTDefeito == '01') {
					$state.go('ihmWeb.selecionardefeitoncreprocesso', { dto: $scope.dto, ncs: $scope.ncs, passagensDTO: $scope.passagensDTO, acoes: acao });
				}
			} else {
				$scope.isArray = 'true';
				for (var i = 0; i < $scope.ncs.length; i++) {

					// A informacao id_tdefeito nao e disponibilizada nesse caso
					// if ($scope.passagensDTO.naoConformidadesAtuais[i].idTDefeito == null &&
					// 		$scope.passagensDTO.naoConformidadesAtuais[i].idTDefeito == '01'){
					$state.go('ihmWeb.selecionardefeitoncreprocesso', { dto: $scope.dto, ncs: $scope.ncs, passagensDTO: $scope.passagensDTO, acoes: acao });
					// }
				}
			}

			var data = {};
			data["ns"] = $scope.dto.cbLido.toString();
			data["cdpt"] = $scope.dto.pt.dsup.toString();
			data["cdcp"] = $scope.dto.pt.producao.ordem.toString();
			data["idtppt"] = $scope.dto.pt.idtppt.toString();
			data["acao"] = acao.codigo.toString();
			data["isArray"] = $scope.isArray.toString();
			data["dto"] = $scope.ncs;
			data["ompt"] = $scope.dto.ompt;

			// var url = "http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "postoReprocesso" ;
			// $.ajax({
			// 	type: "POST",
			// 	contentType: "application/x-www-form-urlencoded;charset=utf-8",
			// 	url: url,
			// 	data: data,
			// 	dataType: 'text',
			// 	timeout: 30000,
			// 	success:function(response){

			// 	},
			// 	error: function(){
			// 		servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S , FALHA_CLASSE);
			// 	}
			// });
			//$state.go('ihmWeb.menumainreprocesso' , {dto: $scope.dto});
			//$state.go('ihmWeb.selecionardefeitoncreprocesso' , {dto: $scope.dto, ncs: $scope.ncs , passagensDTO: $scope.passagensDTO, acoes: acao});
			if ($scope.ncs != null)
				$state.go('ihmWeb.selecionardefeitoncreprocesso', { dto: $scope.dto, ncs: $scope.ncs, passagensDTO: $scope.passagensDTO, acoes: acao });
		}

		$scope.voltar = function () {
			$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto, passagensDTO: $scope.passagensDTO });
		}

	}])

	.controller('SelecionarDefeitoNCReprocessoController', ['$scope', 'servicoGenerico', '$stateParams', '$state', function ($scope, servicoGenerico, $stateParams, $state) {
		montaStringSelecionarDefeitoNCReprocesso();
		$scope.dto = $stateParams.dto;
		$scope.acoes = $stateParams.acoes;
		$scope.passagensDTO = $stateParams.passagensDTO;
		$scope.ncs = $stateParams.ncs;
		$scope.index = 0;

		// Geralmente nunca vai cair neste casp
		// if($scope.ncs .length != null){
		if ($scope.ncs.constructor === Array) {
			$scope.tamanho = $scope.passagensDTO.length;
			$scope.nc = $scope.ncs[$scope.index];
			$scope.nc = $scope.ncs;
		}
		else {
			$scope.tamanho = -1;
			$scope.nc = $scope.ncs;
		}



		servicoGenerico.respostaGenericaAguarde(true);
		var jqxhr = $.get(("http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "pesquisaDwTDefeitoTppt/" + $scope.dto.pt.idtppt)
			, function () {
			})
			.done(function (success) {
				servicoGenerico.respostaGenericaAguarde(false);
				if ($.isEmptyObject(success)) {
					setTimeout(function () { servicoGenerico.respostaGenerica(ENVIADO_SRV_FAL_S, FALHA_CLASSE); }, 3000);
					$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
				}
				else {
					$scope.listaDefeitos = success.pesquisas;
					$scope.$apply();
				}
			})
			.fail(function (error) {
				logConsoleLog(error);
				servicoGenerico.respostaGenericaAguarde(false);
				setTimeout(function () { servicoGenerico.respostaGenerica(ENVIADO_SRV_FAL_S, FALHA_CLASSE); }, 3000);
				$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
			})
			.always(function (success) {
				logMsgEnviada(this.url);
			});

		$scope.corrigirNC = function (defeito) {
			servicoGenerico.respostaGenericaAguarde(true);
			$scope.index++;
			if ($scope.index < $scope.tamanho && $scope.tamanho != -1) {
				$scope.ncs[$scope.index - 1].idTDefeito = defeito.registro.idTdefeito;
				$scope.nc = $scope.ncs[$scope.index];
				$scope.isArray = 'true';
				$scope.$apply();
				return;
			} else if ($scope.tamanho == -1) {
				$scope.ncs.idTDefeito = defeito.registro.idTdefeito;
				$scope.isArray = 'false';
			}

			var data = {};
			data["ns"] = $scope.dto.cbLido;
			data["cdpt"] = $scope.dto.pt.dsup;
			data["cdcp"] = $scope.dto.pt.producao.ordem;
			data["idtppt"] = $scope.dto.pt.idtppt;
			data["acao"] = $stateParams.acoes.codigo;
			data["isArray"] = $scope.isArray;
			data["dto"] = $scope.ncs;
			data["ompt"] = $scope.dto.ompt;

			var url = "http://" + IP + ":" + PORTA + "/idw/rest/todo/" + "postoReprocesso";
			$.ajax({
				type: "POST",
				contentType: "application/x-www-form-urlencoded;charset=utf-8",
				url: url,
				data: data,
				dataType: 'text',
				timeout: 30000,
				success: function (response) {
					$state.go('ihmWeb.menumainreprocesso', { dto: $scope.dto });
				},
				error: function () {
					servicoGenerico.respostaGenerica(VERIFICAR_DADOS_S, FALHA_CLASSE);
				}
			});


		}

		$scope.voltar = function () {
			$state.go('ihmWeb.visualizarncreprocesso', { dto: $scope.dto, passagensDTO: $scope.passagensDTO });
		}

	}]);





function atualizaSessoes() {
	if (scopesC != null) {
		scopesC.atualiza();
	}
	if (scopesP != null) {
		scopesP.atualiza();
	}
	if (scopesA != null) {
		scopesA.atualiza();
	}
	if (scopesR != null) {
		scopesR.atualiza();
	}
	if (scopesO != null && !isModalAberto_G) {
		scopesO.atualiza();
	}

}

function atualizaSessaoC() {
	scopesC.atualiza();
}

function atualizaSessaoP() {
	scopesP.atualiza();
}

function atualizaSessaoA() {
	scopesA.atualiza();
}

function atualizaSessaoR() {
	scopesR.atualiza();
}

function atualizaSessaoPR() {
	scopesPR.atualiza();
}

function atualizaSessaoO() {
	if (!isModalAberto_G) {
		scopesO.atualiza();
	}
}
