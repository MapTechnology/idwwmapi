package ms.coleta.ic.inovastandalone.transferirarquivos;

import idw.model.pojos.DwConsolmolog;
import idw.util.IdwLogger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import ms.coleta.dto.SessaoUsuarioDTO;
import ms.coleta.dto.SessaoUsuariosDTO;

public class ArquivoOperadores{

	private int tipoUsr;
	private String senha;
	private String nome;
	private Boolean isOperador;
	private Boolean isTecnico;
	private Boolean isTecnicoCIP;
	private IdwLogger log;
	private List<DwConsolmolog> dwconsolmolog;
	
	private SessaoUsuariosDTO usuarios;

	public boolean gerarArquivo(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten("[DADOS]");
		arquivoInovaSA.addLineToBeWritten("TIPO=" + tipoUsr);
		arquivoInovaSA.addLineToBeWritten("ISOPERADOR=" + isOperador);
		arquivoInovaSA.addLineToBeWritten("ISTECNICO=" + isTecnico);
		arquivoInovaSA.addLineToBeWritten("ISTECNICOCIP=" + isTecnicoCIP);
		arquivoInovaSA.addLineToBeWritten("NOME=" + nome);
		arquivoInovaSA.addLineToBeWritten("SENHA=" + senha);
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}
	
	
	public boolean gerarArquivoStatus(String diretorio, String nomeArquivo) {
		ArquivoInovaSA arquivoInovaSA = new ArquivoInovaSA(diretorio, nomeArquivo, log);
		
		if(arquivoInovaSA.openOrCreateFile() == false)
			return false;

		arquivoInovaSA.addLineToBeWritten("[DADOSUSUARIOS]");
		arquivoInovaSA.addLineToBeWritten("QNT=" + usuarios.getListaUsuarios().size());
		int i = 1;
		for(SessaoUsuarioDTO item : usuarios.getListaUsuarios()){
			
			arquivoInovaSA.addLineToBeWritten("[USUARIO" + i + "]");
			arquivoInovaSA.addLineToBeWritten("RE=" + item.getCdUsuario());
			arquivoInovaSA.addLineToBeWritten("NOME=" + item.getDsNome());
			arquivoInovaSA.addLineToBeWritten("TIPO=" + item.getIdGrupoUsuario());
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
			arquivoInovaSA.addLineToBeWritten("DATA=" + dateFormat.format(item.getDthrILogin()));
			i++;
		}
		
		if(arquivoInovaSA.writeLinesToFile() == false) {
			arquivoInovaSA.close();
			return false;
		}
		
		if(arquivoInovaSA.close() == false)
			return false;
		
		return true;
	}
	
	
	
	public List<DwConsolmolog> getDwconsolmolog() {
		return dwconsolmolog;
	}


	public void setDwconsolmolog(List<DwConsolmolog> dwconsolmolog) {
		this.dwconsolmolog = dwconsolmolog;
	}


	public void setTipoUsr(int tipoUsr) {
		this.tipoUsr = tipoUsr;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public Boolean getIsOperador() {
		return isOperador;
	}


	public void setIsOperador(Boolean isOperador) {
		this.isOperador = isOperador;
	}


	public Boolean getIsTecnico() {
		return isTecnico;
	}


	public void setIsTecnico(Boolean isTecnico) {
		this.isTecnico = isTecnico;
	}


	public Boolean getIsTecnicoCIP() {
		return isTecnicoCIP;
	}


	public void setIsTecnicoCIP(Boolean isTecnicoCIP) {
		this.isTecnicoCIP = isTecnicoCIP;
	}


	public IdwLogger getLog() {
		return log;
	}


	public void setLog(IdwLogger log) {
		this.log = log;
	}


	public int getTipoUsr() {
		return tipoUsr;
	}


	public String getSenha() {
		return senha;
	}


	public String getNome() {
		return nome;
	}


	public SessaoUsuariosDTO getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(SessaoUsuariosDTO usuarios) {
		this.usuarios = usuarios;
	}
	
}
