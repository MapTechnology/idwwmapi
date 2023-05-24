package idw.model.rn.impprog;

import java.util.Date;
import java.util.List;

import idw.model.excessoes.SemCategoriaException;
import idw.model.excessoes.SemFeedersException;

public abstract class AProgramaSMD {

	public abstract List<MaquinaSMDPanasonic> obtemMaquinas() throws SemCategoriaException;
	public abstract String getPrograma();
	public abstract Date obtemDataHoraPrograma() throws SemCategoriaException;
	public abstract List<MaquinaSMDFeeder> obtemFeeders(MaquinaSMDPanasonic maquinaSMD) throws SemFeedersException;

	public static AProgramaSMD getInstancia(String arquivo, String conteudo) throws SemCategoriaException{
		if (arquivo.toUpperCase().contains(".DAT") == true){
			return new ProgramaSMDPanasonic(arquivo, conteudo);
		} else if (arquivo.toUpperCase().contains(".XML") == true){
			if (arquivo.toUpperCase().contains("REPORT_") == true)
				return new ProgramaSMDSiemens(arquivo,conteudo);
			else
				return new ProgramaSMDFuji(arquivo, conteudo);
			
		} else if (arquivo.toUpperCase().contains(".XLSX")) {
			return new ProgramaSMDAssembleonAX(arquivo, conteudo);
		}else{
			return new ProgramaSMDPanaSemp(arquivo, conteudo);
		}
		//return null;
	}
	
	public static AProgramaSMD getInstancia(String arquivo, byte[] conteudo) throws SemCategoriaException{

		if(arquivo.toUpperCase().endsWith(".PDF") == true) {
			return new ProgramaSMDAssembleon(arquivo, conteudo);
		} else {
			return new ProgramaSMDPanaSemp(arquivo, new String(conteudo));
		}
		//return null;
	}
}
