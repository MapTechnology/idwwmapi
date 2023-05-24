package ms.coleta.ic.drivercoleta;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Date;

import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.model.dto.IcUpDTO;

public class TrataArquivoRNTX extends TrataArquivoRN{
	
	public TrataArquivoRNTX(String pathRelativo, IcUpDTO icupdto,
			ColetaFileType fileType, IdwLogger log) {
		super(pathRelativo, icupdto, fileType, log);
		// TODO Auto-generated constructor stub
	}

	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException
	{
		//561612000120  872601001780    0168  0006  2.88  12.73  49.2  60.0  0.00  0.00  00:00:29  False   T908  0  12  1  2 0.0 0.0 0.0 0.0      0     
		//872601002354  872601002354    0286  -0005  -42.99  0.00  00.0  00.0  0.00  0.00  00:00:13  False   F110  0  12  3  0 0.0 0.0 0.0 0.0      0
		String[] parameters = linhaArquivo.split("\\s+");
		if(parameters.length >= 13) {
			String serialNumber = parameters[0];
			//String partNumber = parameters[1];
			String errorCode = parameters[12];
			Date datePassagem = new Date(file.lastModified());
			int stTeste = 0;
			if(errorCode.compareTo("T908")==0)
				stTeste = 1;
			lancaTesteSimples(linhaArquivo, datePassagem, serialNumber, stTeste);
		}
		// Resolucao de bug
		// Processa apenas uma linha
		// return true;
		return false;
	}
	
	@Override
    protected boolean obtemInformacoesNecessarias()
    {
        boolean retorno = false;
        
        String fileName = pathDirParaProcessamento + maquina + ".txt";
        
        if (ArquivosDiretorios.isExisteArquivo(fileName) == true)
        {
            try(RandomAccessFile reader = new RandomAccessFile(fileName, "r"))
            {
                this.ultimaLinhaProcessada = reader.readLine();
                this.lineCounter = Integer.parseInt(reader.readLine());
                this.ultimoArquivoProcessado = reader.readLine();
                retorno = true;
            }
            catch (Exception e)
            {
            	e.printStackTrace();
            }
        }
        return retorno;
    }

	@Override
	protected void salvaInformacoesNecessarias() 
	{
		try
		{
			String fileName = pathDirParaProcessamento + maquina + ".txt";
			log.info("Salvando ultimaLinhaProcessada"+lineCounter+" em "+fileName);
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.println(ultimaLinhaProcessada);
			writer.println(String.valueOf(lineCounter));
			writer.println(ultimoArquivoProcessado);
			writer.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
