	'use strict';

	ihmApp
	.config(function($stateProvider, $urlRouterProvider,$sceProvider){
		$sceProvider.enabled(false);
		$stateProvider
		.state('ihmWeb', {
			url:'/',
			views: {
				'header': {
					templateUrl: ''
				},
				'content@': {
					templateUrl: 'views/entrar.html',
					controller: 'EntrarController'
				}
			}
		})
		.state('ihmWeb.producao', {
			url:'producao',
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/producao.html',
					controller: 'ProducaoController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.paradas', {
			url:'paradas',
			views: {
				'header@': {
					// templateUrl: 'views/navbar_vf-web.html',
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/paradas.html',
					controller: 'ParadasController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.alertas', {
			url:'alertas',
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/alertas.html',
					controller: 'AlertasController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.refugo', {
			url:'refugo',
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/refugo.html',
					controller: 'RefugoController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.operadores', {
			url:'operadores',
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/operadores.html',
					controller: 'OperadoresController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.lancaciclo', {
			url:'lancaciclo',
			 params : { pt: null, ordem: null, idpt: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/producao/lancaCiclo.html',
					controller: 'LancaCicloController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.finalizaop', {
			url:'finalizaop',
			 params : { pt: null, ordem: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/producao/finalizaOp.html',
					controller: 'FinalizaOpController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.iniciaop', {
			url:'iniciaop',
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/producao/iniciaOp.html',
					controller: 'IniciaOpController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.iniciaopinjet', {
			url:'iniciaopinjet',
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/producao/iniciaOpInjet.html',
					controller: 'IniciaOpControllerInjet'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.novoalerta', {
			url:'novoalerta',
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/alertas/novoAlerta.html',
					controller: 'NovoAlertaController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.removealerta', {
			url:'removealerta',
			params : { cdAlerta: null, pt: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/alertas/removeAlerta.html',
					controller: 'RemoveAlertaController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.apagarefugo', {
			url:'apagarefugo',
			params : { refugo: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/refugo/apagaRefugo.html',
					controller: 'ApagaRefugoController'
				}
			},
		      authenticate: true
		})
		.state('ihmWeb.logout', {
			url:'logout',
			params : { operador: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/operadores/logout.html',
					controller: 'LogoutController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.login', {
			url:'login',
			params : { operador: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/operadores/login.html',
					controller: 'LoginController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.novorefugo', {
			url:'novorefugo',
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/refugo/novoRefugo.html',
					//templateUrl: 'views/secundarias/reprocesso/novorefugoreprocesso.html',
					controller: 'NovoRefugoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.finalizaparada', {
			url:'finalizaparada',
			params : { pt: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/paradas/finalizaParada.html',
					controller: 'FinalizaParadaController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.novaparada', {
			url:'novaparada',
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/paradas/novaParada.html',
					controller: 'NovaParadaController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.corrigeultimaparada', {
			url:'corrigeultimaparada',
			params : { pt: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/paradas/corrigeUltimaParada.html',
					controller: 'CorrigeUltimaParadaController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.correcaoparadas', {
			url:'correcaoparadas',
			params : { dto: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/paradas/correcaoParadas.html',
					controller: 'CorrecaoParadasController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.correcaoparadaslogin', {
			url:'correcaoparadaslogin',
			params : { dto: null ,pt: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/paradas/correcaoParadasLogin.html',
					controller: 'CorrecaoParadasLoginController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.correcaoparadascorrige', {
			url:'correcaoparadascorrige',
			params : { dto: null, pt:null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/paradas/correcaoParadasCorrige.html',
					controller: 'CorrecaoParadasCorrigeController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.consulta', {
			url:'consulta',
			params : { dto: null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/consulta.html',
					controller: 'ConsultaController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.sair', {
			url:'sair',
			views: {
				'header@': {
					// templateUrl: 'views/navbar_vf-web.html',
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/sair.html',
					controller: 'SairController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.postoreprocesso', {
			url:'postoreprocesso',
			params : { dto:null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/postoreprocesso.html',
					controller: 'PostoReprocessoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.produtorefugadoreprocesso',{
			params : { dto:null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/produtorefugado.html',
					controller: 'ProdutoRefugadoReprocessoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.serialconformereprocesso',{
			params : { dto:null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/serialconforme.html',
					controller: 'SerialConformeReprocessoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.menumainreprocesso',{
			params : { dto:null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/menumain.html',
					controller: 'MenuMainReprocessoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.situacaocbreprocesso',{
			params : { dto:null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/situacaocb.html',
					controller: 'SituacaoCBReprocessoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.solicitadefeitoreprocesso',{
			params : { dto:null },
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/solicitadefeito.html',
					controller: 'SolicitaDefeitoReprocessoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.solicitamontagemreprocesso',{
			params : { dto:null , folhamoncomps:null},
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/solicitamontagem.html',
					controller: 'SolicitaMontagemReprocessoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.novorefugoreprocesso',{
			params : { dto:null},
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/novorefugo.html',
					controller: 'NovoRefugoReprocessoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.cancelarefugoreprocesso',{
			params : { dto:null},
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/cancelarefugoreprocesso.html',
					controller: 'CancelaRefugoReprocessoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.visualizarncreprocesso',{
			params : { dto:null, passagemDTO: null},
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/visualizarncreprocesso.html',
					controller: 'VisualizarNCReprocessoController'
				}
			},
		      authenticate: true
		})

		.state('ihmWeb.selecionaracaoncreprocesso',{
			params : { dto:null , ncs:null , acoes: null , passagemDTO: null},
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/selecionaracaoncreprocesso.html',
					controller: 'SelecionarAcaoNCReprocessoController'
				}
			},
		      authenticate: true
		})


	.state('ihmWeb.selecionardefeitoncreprocesso',{
			params : { dto:null , ncs:null , passagemDTO: null, acoes: null},
			views: {
				'header@': {
					templateUrl: 'views/navbar_vf-web.html',
					controller: 'NavbarController'
				},
				'content@': {
					templateUrl: 'views/secundarias/reprocesso/selecionardefeitoncreprocesso.html',
					controller: 'SelecionarDefeitoNCReprocessoController'
				}
			},
		      authenticate: true
		});

		$urlRouterProvider.otherwise('/');
	});

	ihmApp.run(function ($rootScope, $state, AuthService) {
		  $rootScope.$on("$stateChangeStart", function(event, toState, toParams, fromState, fromParams){
		    if (toState.authenticate && !AuthService.isAuthenticated()){
		      $state.transitionTo("ihmWeb");
		     event.preventDefault();
		    }
		  });
		});
