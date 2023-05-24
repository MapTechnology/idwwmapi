package ms.coleta.ic.inova.trataretorno;

import java.util.ArrayList;
import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.coleta.ic.inova.Stubdelegate;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;

public class TrataRetornoConfirmarDadosIntegDoal extends TrataRetorno {

	public TrataRetornoConfirmarDadosIntegDoal() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		//ProdMateriaPrimaDTO lcmatprima = consultaMatPrimaEnviadaColetor(idup);
		IwsProdMateriaPrimaDTO evt999_matprima = new IwsProdMateriaPrimaDTO();
		
		if (this.ic.icupdto.getMatPrimaEnviada() != null &&
				this.ic.icupdto.getMatPrimaEnviada().getCdMateriaPrima() != null &&
				this.ic.icupdto.getMatPrimaEnviada().getCdProduto() != null)
		{
			evt999_matprima.setCdMateriaPrima(this.ic.icupdto.getMatPrimaEnviada().getCdMateriaPrima());
			evt999_matprima.setCdProduto(this.ic.icupdto.getMatPrimaEnviada().getCdProduto());
			evt999_matprima.setLote(this.ic.icDadosRecebidos[12]);
			evt999_matprima.setEstoque(this.ic.icDadosRecebidos[13]);
			evt999_matprima.setQtd(Double.parseDouble(this.ic.icDadosRecebidos[14]));
			int evt999_validacaoSap = Stubdelegate.getInstancia().validaDadosSap(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), this.ic.icupdto,
					this.ic.icupdto.getMatPrimaEnviada().getCdProduto(),		 //cdproduto
					this.ic.icupdto.getMatPrimaEnviada().getCdMateriaPrima(),	//cdmateriaprima
					this.ic.icDadosRecebidos[13],						  //estoque
					this.ic.icDadosRecebidos[12],						  //lote
					Double.parseDouble(this.ic.icDadosRecebidos[14]),			//quantidade
					Integer.parseInt(this.ic.icDadosRecebidos[15]),			   //stregistro
					this.ic.icupdto.getMatPrimaEnviada().getControlalote(),	  //isComLote
					this.ic.sapDbDsn,		  //DSN banco SAP
					this.ic.sapDbUser,		 //USER banco SAP
					this.ic.sapDbPass);		 //PASS banco SAP
			
			if (evt999_validacaoSap > 0) {
//				try {
					this.ic.atualizaListaMatPrima(this.ic.icupdto.getIdUP(), Stubdelegate.getInstancia().buscaListaMateriaPrima(this.ic.icupdto.getIdUP(), log, idLog));
					this.ic.icupdto.setComSaldo(true);
//				} catch(SemComunicacaoICException e) {
//				}
				
				evt999_matprima.setStregistro(evt999_validacaoSap);
				if (this.ic.matPrimaParaApontar == null) this.ic.matPrimaParaApontar = new ArrayList<IwsProdMateriaPrimaDTO>();
				this.ic.matPrimaParaApontar.add(evt999_matprima);
				
				if (evt999_validacaoSap == 3)
				{
					this.ic.icupdto.getUltimaMateriaPrimaAtual().setLote("SEM LOTE");
					this.ic.icupdto.getUltimaMateriaPrimaAtual().setEstoque("SEM ESTOQUE");
				}
				
				if (evt999_validacaoSap == 1)
					Stubdelegate.getInstancia().geraLogIntegracaoDoal(this.ic.icupdto.getIdUP(), parametro.getDataHoraEvento(), "Dados validos", false);
				
				Comando = "";
				Comando += "RESP;999;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;";
				if (evt999_validacaoSap == 2)
				{
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
				this.ic.matPrimaParaApontar.clear();
				List<String> lines = this.ic.verificaTxtMensagem(this.ic.icupdto.getTxtMsg());
				Comando = "RESP;999;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
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
			
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
			this.ic.setDoal(this.ic.icupdto);
		}
		else {
			List<String> lines = this.ic.verificaTxtMensagem("ERRO AO TENTAR BUSCAR OS DADOS DE MATERIA PRIMA");
			Comando = "RESP;999;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
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
