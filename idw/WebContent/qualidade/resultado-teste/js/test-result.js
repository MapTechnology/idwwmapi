/*jslint nomen: true */
/*global $, jQuery, console */
$(document).ready(function () {
    "use strict";

    var lastResultStyle,
        tpResult = {
    		"0": { style: "test-disapproved", desc: "REPROVADO" },
            "1": { style: "test-approved", desc: "APROVADO" },            
            none: { style: "test-none", desc: "DESCONHECIDO" }
        };
    
    function waitingProgress() {
    	$(".loading").show();
    	$("input, select, button").prop("disabled", true);
    }
    
    function progressFinished() {
    	$(".loading").hide();
    	$("input, select, button").removeAttr('disabled');
    }
    
    function getTestResultFromRest(barcode, success, fail) {
        var url = window.location.origin + "/idw/rest/resultados-testes?" +            
            "cd-barras=" + barcode;

        $.getJSON(url, success)
            .fail(fail);

    }
    
    function applyResultStyle(style) {
        if (lastResultStyle) {
            $(".main").removeClass(lastResultStyle);
        }
        lastResultStyle = style;
        $(".main").addClass(style);
    }
    
    function showMessage(msg) {    	
        $(".message")
            .text(msg)
            .fadeIn(200)
            .fadeOut(10000);
    }
    
    function showErrorMessage(jqXHR) {
        var msg = "error",
            jsonError;
        if (jqXHR) {
            if (!jqXHR.responseJSON) {
                msg = jqXHR.status + " " + jqXHR.statusText;
            } else if (jqXHR.responseJSON.error) {
                jsonError = jqXHR.responseJSON.error;
                msg = jsonError.message;
            }
        }
        showMessage(msg);
    }
    
    
    function searchBarcode() {
        var barcode = $(".input-barcode").val(),
        	clearMainResult = function () {
        		$(".read-result-result-detail").text("");
	            $(".read-result-result").text("");	            
	            $(".read-result-date").text("");
	            $(".read-result-barcode").text("");
	            $(".read-result-workcenter").text("");        	
        	},
        	setOverallResult = function (response) {
        		var resultado = response.resultadoGeral,
        			tp = tpResult[resultado.resultado.toString()];
        		clearMainResult();
        		if (resultado.detalheResultado) {
        			$(".read-result-result-detail").text(resultado.detalheResultado);
        		}
        		$(".read-result-result").text(tp.desc);
	            $(".read-result-date").text(resultado.dtHr);
	            $(".read-result-barcode").text(resultado.cdBarras);
	            $(".read-result-workcenter").text(resultado.cdPt);
	            applyResultStyle(tp.style);        	
        	},
        	setAllResults = function (response) {
        		var $AllReadResults = $(".all-read-results"),
        			resultados = response.resultados,
        			arrayLength = resultados.length,
        			resultado, tp, item, i;
        		
        		$AllReadResults.empty();
        		
        		for(i = 0; i < arrayLength; i++) {
        			resultado = resultados[i];
        			tp = tpResult[resultado.resultado.toString()];
        			item = tp.desc + " - " + resultado.dtHr + " - " + resultado.cdPt + " - " + resultado.cdBarras;
        			$("<div class='all-read-results-item'>")
        				.appendTo($AllReadResults)
        				.text(item)
        				.addClass(tp.style);
        		}
        		
        	},
            success = function (response) {    
                
                progressFinished();
                
                if (response) {
                    if (response.error) {
                    	$(".read-results").hide();
                        showMessage(response.error.message);                        
                    } else {
                    	
                        $(".message").hide();
                        $(".read-results").show();
                        
                        setOverallResult(response);
                        setAllResults(response);
                        
                        $(".input-barcode")
                        	.val("")
                        	.focus();
                    }
                }
            },
            fail = function (jqXHR, textStatus, errorThrown) {
            	progressFinished();
            	$(".read-results").hide();
                showErrorMessage(jqXHR);
                $(".input-barcode")
            		.val("")
            		.focus();
            };
        
        applyResultStyle(tpResult.none.style);
        
        $(".read-results").hide();
        
        if (!barcode) {
            showMessage("Preencha o código de barras");
        } else {
        	waitingProgress();
            getTestResultFromRest(barcode, success, fail);
        }
        
    }
    

    
    $(".input-barcode").on("keyup", function (event) {
        if (event.keyCode === 13) {
            searchBarcode();
        }
    });
    
    
    $(".search-barcode-button").on("click", searchBarcode);
    
    $(".loading").hide();
    
    $(".message, .read-result").hide();
    
});