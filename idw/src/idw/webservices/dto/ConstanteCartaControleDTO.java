package idw.webservices.dto;


public class ConstanteCartaControleDTO {

	public Double A2;
	public Double D3;
	public Double D4;

	public static ConstanteCartaControleDTO get(int n) {
		
		if(n < 1 || n > 25) {
			return null;
		}
		
		ConstanteCartaControleDTO retorno = new ConstanteCartaControleDTO();
		
		if(n == 1) {
			retorno.A2 = 2.66;
			retorno.D3 = 0.0;
			retorno.D4 = 3.267;
		}
		if(n == 2) {
			retorno.A2 = 1.88;
			retorno.D3 = 0.0;
			retorno.D4 = 3.267;
		}
		if(n == 3) {
			retorno.A2 = 1.023;
			retorno.D3 = 0.0;
			retorno.D4 = 2.575;
		}
		if(n == 4) {
			retorno.A2 = 0.729;
			retorno.D3 = 0.0;
			retorno.D4 = 2.282;
		}
		if(n == 5) {
			retorno.A2 = 0.577;
			retorno.D3 = 0.0;
			retorno.D4 = 2.115;
		}
		if(n == 6) {
			retorno.A2 = 0.483;
			retorno.D3 = 0.0;
			retorno.D4 = 2.004;
		}
		if(n == 7) {
			retorno.A2 = 0.419;
			retorno.D3 = 0.076;
			retorno.D4 = 1.924;
		}
		if(n == 8) {
			retorno.A2 = 0.373;
			retorno.D3 = 0.136;
			retorno.D4 = 1.864;
		}
		if(n == 9) {
			retorno.A2 = 0.337;
			retorno.D3 = 0.184;
			retorno.D4 = 1.816;
		}
		if(n == 10) {
			retorno.A2 = 0.308;
			retorno.D3 = 0.223;
			retorno.D4 = 1.777;
		}
		if(n == 11) {
			retorno.A2 = 0.285;
			retorno.D3 = 0.256;
			retorno.D4 = 1.744;
		}
		if(n == 12) {
			retorno.A2 = 0.266;
			retorno.D3 = 0.283;
			retorno.D4 = 1.717;
		}
		if(n == 13) {
			retorno.A2 = 0.249;
			retorno.D3 = 0.307;
			retorno.D4 = 1.693;
		}
		if(n == 14) {
			retorno.A2 = 0.235;
			retorno.D3 = 0.328;
			retorno.D4 = 1.672;
		}
		if(n == 15) {
			retorno.A2 = 0.223;
			retorno.D3 = 0.347;
			retorno.D4 = 1.653;
		}
		if(n == 16) {
			retorno.A2 = 0.212;
			retorno.D3 = 0.363;
			retorno.D4 = 1.637;
		}
		if(n == 17) {
			retorno.A2 = 0.203;
			retorno.D3 = 0.378;
			retorno.D4 = 1.622;
		}
		if(n == 18) {
			retorno.A2 = 0.194;
			retorno.D3 = 0.391;
			retorno.D4 = 1.608;
		}
		if(n == 19) {
			retorno.A2 = 0.187;
			retorno.D3 = 0.403;
			retorno.D4 = 1.597;
		}
		if(n == 20) {
			retorno.A2 = 0.18;
			retorno.D3 = 0.415;
			retorno.D4 = 1.585;
		}
		if(n == 21) {
			retorno.A2 = 0.173;
			retorno.D3 = 0.425;
			retorno.D4 = 1.575;
		}
		if(n == 22) {
			retorno.A2 = 0.167;
			retorno.D3 = 0.434;
			retorno.D4 = 1.566;
		}
		if(n == 23) {
			retorno.A2 = 0.162;
			retorno.D3 = 0.443;
			retorno.D4 = 1.557;
		}
		if(n == 24) {
			retorno.A2 = 0.157;
			retorno.D3 = 0.451;
			retorno.D4 = 1.548;
		}
		if(n == 25) {
			retorno.A2 = 0.153;
			retorno.D3 = 0.459;
			retorno.D4 = 1.541;
		}
		
		return retorno;
	}

}
