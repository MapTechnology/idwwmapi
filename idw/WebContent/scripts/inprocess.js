function a(){
	$("#btn_download").html($("#texto_aguarde").html());
	$("#btn_download").attr("disabled",true);
	var jqxhr  = $.get( ("http://" + window.location.hostname + ":" + window.location.port + "/idw/rest/todo/" + "getDwOperacaoInProcess/") 
			, function() {
	})
	.done(function(success) {
		if(success == "1"){
			$("#btn_download").attr("href" , "http://" + window.location.hostname + ":" + window.location.port + "/idw/" + "inprocess.zip");
			$("#btn_download").attr("onclick" , "");
			$("#btn_download").html($("#texto_download").html());
			$("#btn_download").attr("disabled",false);
		}
		else{
			$("#btn_download").html($("#texto_erro").html());
		}
	});
}