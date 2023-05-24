package ms.coleta.ic.drivercoleta;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Date;

import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.model.dto.IcUpDTO;

public class TrataArquivoRN24G5G extends TrataArquivoRN {

	private String nsTemp = "";
	private String macTemp = "";
	private int stTesteTemp = 0;
	
	public TrataArquivoRN24G5G(String pathRelativo, IcUpDTO icupdto, ColetaFileType fileType, IdwLogger log) {
		super(pathRelativo, icupdto, fileType, log);
		// TODO Auto-generated constructor stub
	}

	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException
	{
		/*
		 * DUT S/N, 213231213321
		 * DUT MAC, 213231213321
		 */
		boolean retorno = false;
		switch(lineCount) {
		case 1:
			if(linhaArquivo.startsWith("DUT S/N, ")){
				String[] splitted = linhaArquivo.split("DUT S/N, ");
				nsTemp = splitted[1];
				log.info("ns="+nsTemp);
				linhaTemp = new String(linhaArquivo);
			} else {
				retorno = true;
			}
			break;
		case 2:
			if(linhaArquivo.startsWith("DUT MAC, ")){
				String[] splitted = linhaArquivo.split("DUT MAC, ");
				macTemp = splitted[1];
				log.info("mac="+macTemp);
				linhaTemp += "\n" + linhaArquivo;
				if(name.endsWith("_PASS.csv")) {
					stTesteTemp = 1;
				}
				// Adotar esta data causa um bug, o ideal e utilizar a data de dentro do arquivo
				// Date datePassagem = new Date(file.lastModified());
				// Porem, a data de dentro do arquivo e do formato: 04/07 08:52:52.562
				// Ou seja, sem ano
				// Como a diferenca entre as horas correta e errada e de 4 horas, sera feita
				// uma compensacao
//				1 segundo 1000 ms
//				1 minuto 60000 ms
//				1 hora 3600000 ms
//				4 horas 4*3600000 = 14400000
				Date datePassagem = new Date(file.lastModified() - 14400000);
				
				
				//Verificar como usar o mac nesse posto.
				//Verificar quando há a assimilação desse mac na placa.
				lancaTesteSimples(linhaTemp, datePassagem, nsTemp, stTesteTemp);
			}
			retorno = true;
			break;
		default:
			lineCounter = 2;
			throw new PararDeProcessarArquivoSemSalvarLinhaException();
		}
		return retorno;
	}
	
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
