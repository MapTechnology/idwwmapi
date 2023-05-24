package ms.coleta.ic.inova.trataretorno;

import java.util.ArrayList;
import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;

public class TrataRetornoValidarDadosSap extends TrataRetorno {

	public TrataRetornoValidarDadosSap() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		IwsProdMateriaPrimaDTO evt45_matprima = new IwsProdMateriaPrimaDTO();
		
		if(this.ic.icupdto.getMatPrimaEnviada() != null &&
				this.ic.icupdto.getMatPrimaEnviada().getCdMateriaPrima() != null &&
				this.ic.icupdto.getMatPrimaEnviada().getCdProduto() != null)
		{
			evt45_matprima.setCdMateriaPrima(this.ic.icupdto.getMatPrimaEnviada().getCdMateriaPrima());
			evt45_matprima.setCdProduto(this.ic.icupdto.getMatPrimaEnviada().getCdProduto());
			evt45_matprima.setLote(this.ic.icDadosRecebidos[10]);
			evt45_matprima.setEstoque(this.ic.icDadosRecebidos[11]);
			evt45_matprima.setQtd(Double.parseDouble(this.ic.icDadosRecebidos[12]));
			
			int evt45_validacaoSap = Stubdelegate.getInstancia().validaDadosSap(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.icupdto,
					this.ic.icupdto.getMatPrimaEnviada().getCdProduto(),	  //cdproduto
					this.ic.icupdto.getMatPrimaEnviada().getCdMateriaPrima(), //cdmateriaprima
					this.ic.icDadosRecebidos[11],					   //estoque
					this.ic.icDadosRecebidos[10],					   //lote
					Double.parseDouble(this.ic.icDadosRecebidos[12]),		 //quantidade
					Integer.parseInt(this.ic.icDadosRecebidos[13]),				   //stregistro
					this.ic.icupdto.getMatPrimaEnviada().getControlalote(),   //isComLote
					this.ic.sapDbDsn,		  //DSN banco SAP
					this.ic.sapDbUser,		 //USER banco SAP
					this.ic.sapDbPass);		 //PASS banco SAP
			
			if(evt45_validacaoSap > 0) {
				try {
					this.ic.atualizaListaMatPrima(this.ic.icupdto.getIdUP(), Stubdelegate.getInstancia().buscaListaMateriaPrima(this.ic.icupdto.getIdUP(), log, idLog));
					this.ic.icupdto.setComSaldo(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				evt45_matprima.setStregistro(evt45_validacaoSap);
				List<IwsProdMateriaPrimaDTO> listaParaApontar = new ArrayList<IwsProdMateriaPrimaDTO>();
				
				listaParaApontar.add(evt45_matprima);
				
				Stubdelegate.getInstancia().enviaListaMatPrima(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.icupdto, listaParaApontar);
				
				if(evt45_validacaoSap == 3) {
					this.ic.icupdto.getUltimaMateriaPrimaAtual().setLote("SEM LOTE");
					this.ic.icupdto.getUltimaMateriaPrimaAtual().setEstoque("SEM ESTOQUE");
				}
				
				this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
				this.ic.setDoal(this.ic.icupdto);
				
				if (evt45_validacaoSap == 1)
					Stubdelegate.getInstancia().geraLogIntegracaoDoal(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(),
					"Dados validos", false);
				
				Comando = "";
				Comando += "RESP;45;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;";
				
				if(evt45_validacaoSap == 2) {
					Comando += "1;";
					List<String> lines = this.ic.verificaTxtMensagem(this.ic.icupdto.getTxtMsg());
					if (lines.size() >= 1) Comando += lines.get(0) + ";";
					else Comando += " ;";
					if (lines.size() >= 2) Comando += lines.get(1) + ";";
					else Comando += " ;";
					if (lines.size() >= 3) Comando += lines.get(2) + ";";
					else Comando += " ;";
					if (lines.size() >= 4) Comando += lines.get(3) + ";";
					else Comando += " ;";
					Comando += "; ; ; ;";
				}
				else
					Comando += "0; ; ; ; ; ; ; ;";
			}
			else {
				List<String> lines = this.ic.verificaTxtMensagem(this.ic.icupdto.getTxtMsg());
				Comando = "RESP;45;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
				if (lines.size() >= 1) Comando += lines.get(0) + ";";
				else Comando += " ;";
				if (lines.size() >= 2) Comando += lines.get(1) + ";";
				else Comando += " ;";
				if (lines.size() >= 3) Comando += lines.get(2) + ";";
				else Comando += " ;";
				if (lines.size() >= 4) Comando += lines.get(3) + ";";
				else Comando += " ;";
				Comando += " ; ; ; ; ; ;";
			}
		}
		else {
			List<String> lines = this.ic.verificaTxtMensagem("ERRO AO TENTAR BUSCAR OS DADOS DE MATERIA PRIMA");
			Comando = "RESP;45;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
			if (lines.size() >= 1) Comando += lines.get(0) + ";";
			else Comando += " ;";
			if (lines.size() >= 2) Comando += lines.get(1) + ";";
			else Comando += " ;";
			if (lines.size() >= 3) Comando += lines.get(2) + ";";
			else Comando += " ;";
			if (lines.size() >= 4) Comando += lines.get(3) + ";";
			else Comando += " ;";
			Comando += " ; ; ; ; ; ;";
		}
		
		this.ic.enviaDado(Comando);
		UtilsThreads.pausaNaThread(10);
	}

}
