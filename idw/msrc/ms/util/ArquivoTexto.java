package ms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoTexto{

	private File file = null;
	private FileReader fileReader = null;
	private boolean isErro = false;
	
	public ArquivoTexto(String arquivo) throws FileNotFoundException {
		file = new File(arquivo);
		fileReader = new FileReader(file.getAbsoluteFile());
	}
	
	public File getFile(){
		return this.file;
	}

	public boolean isErro() {
		return isErro;
	}

	public void setErro(boolean isErro) {
		this.isErro = isErro;
	}
	public FileReader getFileReader(){
		return this.fileReader;
	}
	public void close() throws IOException{
		this.fileReader.close();
	}
}
