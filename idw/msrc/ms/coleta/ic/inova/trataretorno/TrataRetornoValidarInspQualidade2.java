package ms.coleta.ic.inova.trataretorno;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;

public class TrataRetornoValidarInspQualidade2 extends TrataRetorno {

	public TrataRetornoValidarInspQualidade2() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		try {
			log.info(idLog, 0, "O Valor tpParametro = 0 de DadoRecebido[10] = [" + this.ic.icDadosRecebidos[10] + "]");
			log.info(idLog, 0, "O Valor tpParametro = 0 de lipercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia() + "]");
			log.info(idLog, 0, "O Valor tpParametro = 0 de lspercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia() + "]");
			log.info(idLog, 0, "O Valor tpParametro = [" + this.ic.ultimaInspecao.getPrupexecinspecao().getTpParametro() + "]");
			
			if(this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia().contains(",")) {
				this.ic.ultimaInspecao.getPrupexecinspecao().setLipercTolerancia(this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia().replace(",", "."));
			}
			
			if(this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia().contains(",")) {
				this.ic.ultimaInspecao.getPrupexecinspecao().setLspercTolerancia(this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia().replace(",", "."));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if((this.ic.ultimaInspecao == null) || (this.ic.ultimaInspecao.getPrupexecinspecao() == null)) {
			this.ic.ultimaInspecao = Stubdelegate.getInstancia().getTr_DadosInspecao(this.ic.icupdto.getIdUP());
		}
		
		this.ic.ultimaInspecao.setErro(false);
		
		if(this.ic.ultimaInspecao.getPrupexecinspecao().getTpParametro() == '1') {
			int VlLido = 0;
			
			try {
				VlLido = Integer.parseInt(this.ic.icDadosRecebidos[10]);
			} catch(NumberFormatException e) {
				Comando += "RESP;321;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" + "24" + "; ; ; ; ; ; ; ; ;";
				
				this.ic.enviaDado(Comando);
				UtilsThreads.pausaNaThread(10);
				
				try {
					log.info(idLog, 0, "O Valor tpParametro = 1 de DadoRecebido[10] = [" + this.ic.icDadosRecebidos[10] + "]");
					log.info(idLog, 0, "O Valor tpParametro = 1 de lipercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia() + "]");
					log.info(idLog, 0, "O Valor tpParametro = 1 de lspercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia() + "]");
					log.info(idLog, 0, "O Valor tpParametro = [" + this.ic.ultimaInspecao.getPrupexecinspecao().getTpParametro() + "]");
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				
//				break;
				return;
			}
			
			if(VlLido > this.ic.ultimaInspecao.getPrupexecinspecao().getTamAmostra()) {
				log.info(idLog, 0, "O Valor tpParametro = 2 de DadoRecebido[10] = [" + this.ic.icDadosRecebidos[10] + "]");
				log.info(idLog, 0, "O Valor tpParametro = 2 de lipercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia() + "]");
				log.info(idLog, 0, "O Valor tpParametro = 2 de lspercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia() + "]");
				log.info(idLog, 0, "O Valor tpParametro = [" + this.ic.ultimaInspecao.getPrupexecinspecao().getTpParametro() + "]");
				
				//valor inserido inválido
				Comando += "RESP;321;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" + "24" + "; ; ; ; ; ; ; ; ;";
			}
			else {
				Comando += "RESP;321;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + " ; ; ; ; ; ; ; ; ; ;";
				this.ic.ultimaInspecao.getPrupexecinspecao().setVlLido((float) VlLido);
			}
		}
		else if(this.ic.ultimaInspecao.getPrupexecinspecao().getTpParametro() == '2') {
			Double VlLido = 0d;
			
			if(this.ic.icDadosRecebidos[10].contains(",")) {
				this.ic.icDadosRecebidos[10] = this.ic.icDadosRecebidos[10].replace(",", ".");
			}
			
			try {
				VlLido = Double.parseDouble(this.ic.icDadosRecebidos[10]);
			} catch(NumberFormatException e) {
				Comando += "RESP;321;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" + "24" + "; ; ; ; ; ; ; ; ;";
				
				this.ic.enviaDado(Comando);
				UtilsThreads.pausaNaThread(10);
				
				try {
					log.info(idLog, 0, "O Valor tpParametro = 3 de DadoRecebido[10] = [" + this.ic.icDadosRecebidos[10] + "]");
					log.info(idLog, 0, "O Valor tpParametro = 3 de lipercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia() + "]");
					log.info(idLog, 0, "O Valor tpParametro = 3 de lspercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia() + "]");
					log.info(idLog, 0, "O Valor tpParametro = [" + this.ic.ultimaInspecao.getPrupexecinspecao().getTpParametro() + "]");
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				
//				break;
				return;
			}
			
			this.ic.ultimaInspecao.getPrupexecinspecao().setVlLido(VlLido.floatValue());
			
			if((this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia() != null)) {
				
				if(VlLido < Double.parseDouble(this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia())) {
					log.info(idLog, 0, "O Valor tpParametro = 4 de DadoRecebido[10] = [" + this.ic.icDadosRecebidos[10] + "]");
					log.info(idLog, 0, "O Valor tpParametro = 4 de lipercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia() + "]");
					log.info(idLog, 0, "O Valor tpParametro = 4 de lspercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia() + "]");
					log.info(idLog, 0, "O Valor tpParametro = [" + this.ic.ultimaInspecao.getPrupexecinspecao().getTpParametro() + "]");
					log.info(idLog, 0, "Convert.ToDouble(lipercTolerancia) = [" + Double.parseDouble(this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia()) + "]");
					
					//valor inserido inválido
					Comando += "RESP;321;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" + "24" + "; ; ; ; ; ; ; ; ;";
					this.ic.ultimaInspecao.setErro(true);
				}
				
			}
			
			if((this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia() != null)) {
				
				if(VlLido > Double.parseDouble(this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia())) {
					log.info(idLog, 0, "O Valor tpParametro = 5 de DadoRecebido[10] = [" + this.ic.icDadosRecebidos[10] + "]");
					log.info(idLog, 0, "O Valor tpParametro = 5 de lipercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLipercTolerancia() + "]");
					log.info(idLog, 0, "O Valor tpParametro = 5 de lspercTolerancia [" + this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia() + "]");
					log.info(idLog, 0, "O Valor tpParametro = [" + this.ic.ultimaInspecao.getPrupexecinspecao().getTpParametro() + "]");
					log.info(idLog, 0, "VlLido = [" + VlLido.toString() + "]");
					log.info(idLog, 0, "Convert.ToDouble(lspercTolerancia) = [" + Double.parseDouble(this.ic.ultimaInspecao.getPrupexecinspecao().getLspercTolerancia()) + "]");
					
					//valor inserido inválido
					Comando += "RESP;321;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;" + "24" + "; ; ; ; ; ; ; ; ;";
					this.ic.ultimaInspecao.setErro(true);
				}
			}
			
			if(this.ic.ultimaInspecao.getErro() == false) {
				Comando += "RESP;321;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;" + " ; ; ; ; ; ; ; ; ; ;";
				this.ic.ultimaInspecao.getPrupexecinspecao().setVlLido(VlLido.floatValue());
			}
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
