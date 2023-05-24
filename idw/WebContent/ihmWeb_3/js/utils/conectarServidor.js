//Funcoes de conexao ao servidor e efeitos da tela de login. Websockets sao manejados aqui

var wsUri;
var ip;

var sessaoTimer;

function conectar() {
	
	habilitaConectar(false);

	IP    = document.getElementById("inputSrv").value;
	PORTA = document.getElementById("inputPorta").value;

	if (IP == null || IP == '' || PORTA == null  || PORTA =='' ){
		IP = window.location.hostname;
		PORTA = window.location.port;
	}

	// wsUri = "ws://" + document.getElementById("inputSrv").value + ":" + document.getElementById("inputPorta").value + "/idw/websocket;"
	wsUri = "ws://" + IP + ":" + PORTA + "/idw/websocket;";
	
	var promiseLocalIP = getLocalIP();

	promiseLocalIP.then( function(result){
		//ip = success.slice(0 , success.length - 2);
		ip = result;
		IP_L = ip;
		if (ip.indexOf("-") > -1) {
			// se nao foi possivel obter o ip, utilizar o metodo classiso
			// jqxhr = $.get( "http://" + document.getElementById("inputSrv").value + ":" + document.getElementById("inputPorta").value + "/idw/ihmWeb/ip.jsp"
            jqxhr = $.get( "http://" + IP + ":" + PORTA + "/idw/ihmWeb/ip.jsp"
			, function(success) {
			})
			.done(function(success) {
				ip = success.slice(0, success.length - 2);
				IP_L = ip;
			})
			.fail(function(error) {
				erro(false);
			})
			.always(function(success) {

			});
		}
		// debugger;
		try{
			websocket = new WebSocket(wsUri);			
			websocketTime = new WebSocket(wsUri);			
			/*
			websocket.onopen = function(evt) {
				onOpen(evt)
			};
			
			websocket.onmessage = function(evt) {
				onMessage(evt)
			};
			
			websocket.onerror = function(evt) {
				onError(evt)
			};
			*/
			websocketTime.onopen = function(evt) {
				onOpen(evt)
			};
			websocketTime.onmessage = function(evt) {
				onMessage(evt)
			};
			websocketTime.onerror = function(evt) {
				onError(evt)
			};
		}
		catch(err){
			console.log("erro: ", err);
			erro(false);
		}
	});

	sessaoTimer = setInterval(function pegasessao(){
		if(websocketTime.readyState == 1){
			websocketTime.send("ac=0#ihm="+ ip + "#ip=" + ip + "#pt=3005#");
		}
		else{
			websocketTime = new WebSocket(wsUri);
			websocketTime.onopen = function(evt) {
				onOpen(evt)
			};
			websocketTime.onmessage = function(evt) {
				onMessage(evt)
			};
			websocketTime.onerror = function(evt) {
				onError(evt)
			};
		}

	} , 10000);
}

function getLocalIP() {
  return new Promise(function(resolve, reject) {
    // NOTE: window.RTCPeerConnection is "not a constructor" in FF22/23
    var RTCPeerConnection = /*window.RTCPeerConnection ||*/ window.webkitRTCPeerConnection || window.mozRTCPeerConnection;

    if (!RTCPeerConnection) {
      alert("Your browser does not support this API");
      reject('Your browser does not support this API');
    }

    var rtc = new RTCPeerConnection({iceServers:[]});
    var addrs = {};
    addrs["0.0.0.0"] = false;

    function grepSDP(sdp) {
        var hosts = [];
        var finalIP = '';
        sdp.split('\r\n').forEach(function (line) { // c.f. http://tools.ietf.org/html/rfc4566#page-39
            if (~line.indexOf("a=candidate")) {     // http://tools.ietf.org/html/rfc4566#section-5.13
                var parts = line.split(' '),        // http://tools.ietf.org/html/rfc5245#section-15.1
                    addr = parts[4],
                    type = parts[7];
                if (type === 'host') {
                    finalIP = addr;
                }
            } else if (~line.indexOf("c=")) {       // http://tools.ietf.org/html/rfc4566#section-5.7
                var parts = line.split(' '),
                    addr = parts[2];
                finalIP = addr;
            }
        });
        return finalIP;
    }

    if (1 || window.mozRTCPeerConnection) {      // FF [and now Chrome!] needs a channel/stream to proceed
        rtc.createDataChannel('', {reliable:false});
    };

    rtc.onicecandidate = function (evt) {
        // convert the candidate to SDP so we can run it through our general parser
        // see https://twitter.com/lancestout/status/525796175425720320 for details
        if (evt.candidate) {
          var addr = grepSDP("a="+evt.candidate.candidate);
          resolve(addr);
        }
    };
    rtc.createOffer(function (offerDesc) {
        rtc.setLocalDescription(offerDesc);
    }, function (e) { console.warn("offer failed", e); });
  });
}

// Funcao legado, apenas para referencia
function conectarLegado() {
	habilitaConectar(false);

	IP    = document.getElementById("inputSrv").value;
	PORTA = document.getElementById("inputPorta").value;

	if (IP == null || IP == '' 
		|| PORTA == null  || PORTA =='' )
	{
		IP = window.location.hostname;
		PORTA = window.location.port;
	}

	// wsUri = "ws://" + document.getElementById("inputSrv").value + ":" + document.getElementById("inputPorta").value + "/idw/websocket;"
	wsUri = "ws://" + IP + ":" + PORTA + "/idw/websocket;"
	// jqxhr = $.get( "http://" + document.getElementById("inputSrv").value + ":" + document.getElementById("inputPorta").value + "/idw/ihmWeb/ip.jsp"
	jqxhr = $.get( "http://" + IP + ":" + PORTA + "/idw/ihmWeb/ip.jsp"
			, function(success) {
	})
	.done(function(success) {
	})
	.fail(function(error) {
		erro(false);
	})
	.always(function(success) {

		ip = success.slice(0 , success.length - 2);
		IP_L = ip;

		try{
			websocket = new WebSocket(wsUri );
			websocketTime = new WebSocket(wsUri);
			websocket.onopen = function(evt) {
				onOpen(evt)
			};
			websocket.onmessage = function(evt) {

				onMessage(evt)
			};
			websocket.onerror = function(evt) {
				onError(evt)
			};

			websocketTime.onopen = function(evt) {
				onOpen(evt)
			};
			websocketTime.onmessage = function(evt) {

				onMessage(evt)
			};
			websocketTime.onerror = function(evt) {
				onError(evt)
			};
		}
		catch(err){
			erro(false);
		}
	});

	  sessaoTimer = setInterval(function pegasessao(){
		if(websocketTime.readyState == 1){
			websocketTime.send("ac=0#ihm="+ ip + "#ip=" + ip + "#pt=3005#");
		}
		else{
			websocketTime = new WebSocket(wsUri);
			websocketTime.onopen = function(evt) {
				onOpen(evt)
			};
			websocketTime.onmessage = function(evt) {

				onMessage(evt)
			};
			websocketTime.onerror = function(evt) {
				onError(evt)
			};
		}

	} , 10000);
}



function onOpen(evt) {
	pbConectar(30);
	doSend("ac=0#ihm="+ ip + "#ip=" + ip + "#pt=3005#");
}

function onMessage(evt) {
	if(!isConectado_G && evt.data != -1){
		pbConectar(30);
	}
	respostaSessao_G = evt.data;
	var servico = getServico();
	trataEvento(servico);
}

function onError(evt) {
	erro(false);
}

function doSend(message) {
	websocket.send(message);
}

function erro(ihmDesconhecido){

	mostraMsgErroConectar(ihmDesconhecido);
	habilitaConectar(true);
	pbConectar(-1);
}
