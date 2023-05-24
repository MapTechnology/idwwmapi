package ms.coleta.ic.drivercoleta;

import idw.util.ArquivosDiretorios;
import idw.util.IdwLogger;

import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ms.coleta.ic.drivercoleta.DriverColetaRN.ColetaFileType;
import ms.model.dto.IcUpDTO;

public class TrataArquivoRNFTP extends TrataArquivoRN{
	
	public TrataArquivoRNFTP(String pathRelativo, IcUpDTO icupdto,
			ColetaFileType fileType, IdwLogger log) {
		super(pathRelativo, icupdto, fileType, log);
		// TODO Auto-generated constructor stub
	}

	protected boolean processaUmaLinhaDoArquivoCustom(File file, String name, int lineCount, String linhaArquivo) throws PararDeProcessarArquivoSemSalvarLinhaException
	{
		//W609 4/1/2016 3:23:31 PM 4/1/2016 3:24:50 PM 12:01:19 AM 9897D1DCD3D6              41534                GPT-2541GNAC     
		//W106 4/1/2016 3:35:04 PM 4/1/2016 3:35:56 PM 12:00:52 AM 9897D1DCD3D6              41534                GPT-2541GNAC
		String[] parameters = linhaArquivo.split("\\s+");
		if(parameters.length >= 10) {
			String errorCode = parameters[0];
/*			String dataInicio = parameters[1];
			String horaInicio = parameters[2];
			String ampmInicio = parameters[3];*/
			String dataFim = parameters[4];
			String horaFim = parameters[5];
			String ampmFim = parameters[6];
			String serialNumber = parameters[9];
			String dateStr = dataFim+" "+horaFim+" "+ampmFim;//"4/1/2016 3:35:04 PM"; 
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a"); 
			try {
				Date datePassagem = (Date)formatter.parse(dateStr);

				int stTeste = 0;
				if(errorCode.compareTo("T100")==0)
					stTeste = 1;
				lancaTesteSimples(linhaArquivo, datePassagem, serialNumber, stTeste);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return true;
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