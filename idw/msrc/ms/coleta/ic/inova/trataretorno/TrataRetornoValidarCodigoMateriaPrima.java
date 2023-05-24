package ms.coleta.ic.inova.trataretorno;

import java.util.List;

import ms.coleta.dto.ParametroDTO;
import ms.util.UtilsThreads;
import injetws.model.excessoes.SemSGBDException;
import injetws.webservices.dto.IwsProdMateriaPrimaDTO;
import injetws.webservices.dto.IwsProdutoDTO;

public class TrataRetornoValidarCodigoMateriaPrima extends TrataRetorno {

	public TrataRetornoValidarCodigoMateriaPrima() {
	}

	@Override
	public void trataRetorno() throws SemSGBDException {
		String Comando = "";
		
		String idRedProduto = this.ic.icDadosRecebidos[11];
		String produto = "";
		
		if(idRedProduto.equals(""))
			produto = this.ic.icupdto.getCp().getProdutos().get(0).getCdProduto();
		else {
			List<IwsProdutoDTO> listaProdutos = this.ic.icupdto.getCp().getProdutos();
			for(IwsProdutoDTO prod : listaProdutos)  {
				if(prod.getCdReduzido().equals(idRedProduto))
					produto = prod.getCdProduto();
			}
		}
		
		IwsProdMateriaPrimaDTO matp = this.ic.validaCodMatPrima(this.ic.icupdto.getIdUP(), this.ic.icDadosRecebidos[10], produto);
		
		if(matp != null) {
			//ProdMateriaPrimaDTO lcmatp = buscaCdMatPrimaProdIdup(idup,DadoRecebido[10],produto);
			Comando = "";
			Comando += "RESP;451;" + this.ic.icupdto.getIdSubColetor().toString() + ";1;";
			
			if (matp.getControlalote())
				Comando += "1;";
			else
				Comando += "0;";
			
			this.ic.icupdto.setMatPrimaEnviada(new IwsProdMateriaPrimaDTO());
			this.ic.icupdto.getMatPrimaEnviada().setCdMateriaPrima(matp.getCdMateriaPrima());
			this.ic.icupdto.getMatPrimaEnviada().setCdProduto(matp.getCdProduto());
			this.ic.icupdto.getMatPrimaEnviada().setControlalote(matp.getControlalote());
			this.ic.setUP(this.ic.icupdto.getIdSubColetor(), this.ic.icupdto);
		}
		else {
			List<String> lines = this.ic.verificaTxtMensagem("MATERIA PRIMA INEXISTENTE OU INVALIDA PARA ESTA OP");
			
			Comando = "RESP;451;" + this.ic.icupdto.getIdSubColetor().toString() + ";0;255;";
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
