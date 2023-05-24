package idw.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class ArquivoEscrita extends BufferedWriter{

	public ArquivoEscrita(Writer out) {
		super(out);
	}

	public void writeLine(String conteudo) throws IOException {
		write(conteudo);
		newLine();
	}
}
