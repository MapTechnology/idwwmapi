package ms.coleta.ic.jconcentrador;

import idw.util.IdwLogger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;

import ms.util.UtilsThreads;

public class JThread implements Runnable{
	private int porta = 0;
	private String ip = null;
	private ArrayList<String> listaDeMensagens = new ArrayList<String>();
	private IdwLogger log = null;
	private int idlog = 0;
	private String dadoRecebido = null;
	
	private boolean threadViva = true;
	
	public Socket tc = null;
	private BufferedOutputStream nsOut = null;
	public BufferedInputStream nsIn = null;
	private boolean conectado = false;
	private boolean isBufferDeSaidaComErro;
	int contagem = 0;
	
	public Calendar dataHoraUltimoEvento = null;
	
	public JThread(String ipColetor, int portaColetor, ArrayList<String> buffer, IdwLogger idwlog){
		this.ip = ipColetor;
		this.porta = portaColetor;
		this.listaDeMensagens = buffer;
		this.log = idwlog;
		this.idlog = idwlog.getIdAleatorio();
	}
	
	private void reConectar() throws InterruptedException {
		// System.out.println("reConectar");
		try {
			if (tc == null) {
				tc = new Socket(ip, porta);
			} else {
				tc.close();
				tc = new Socket(ip, porta);
				// Inicia a conex�o TCP com o servidor na porta referenciada
			}
		} catch (UnknownHostException e) {
			 //System.out.println("Host desconhecido.");
			//e.printStackTrace();
			log.info("JThread: Host -" + this.ip + ":" + this.porta + " desconhecido.");
		} catch (IOException e) {
			// System.out.println("Erro de IO.");
			//e.printStackTrace();
			log.info("JThread: Excessao de IO desconhecida.");
		} catch (Exception e) {
			log.info("JThread: Erro de conexao ou desconhecida.");
		}
		if (tc == null) {
			Thread.sleep(10000);
			//reConectar();
			conectado = false;
		}
		else {

		try {
			nsOut = new BufferedOutputStream(tc.getOutputStream());
			nsIn = new BufferedInputStream(tc.getInputStream());
			conectado = tc.isConnected();
		} catch (IOException e) {
			// System.out.println("Erro ao pegar streams.");
			//e.printStackTrace();
			log.info("JThread: Erro ao pegar os buffered de input e output stream do socket.");
			try {
				if (nsOut != null)
					nsOut.close();
				if (nsIn != null)
					nsIn.close();
				if (tc != null)
					tc.close();// linha adicionada para teste de perda de
								// conexao

				nsOut = null;
				nsIn = null;
				tc = null;
			} catch (Exception e1) {
				// N�o faz nada
				log.info("JThread: Erro ao tentar fechar socket com erro.");
			}
			conectado = false;
		}
		}
	}
	@Override
	public void run(){
		int contaErros = 0;
		try {
			conectado = tc.isConnected();
		} catch (Exception e) {
			conectado = false;
		}
		
		while (isThreadViva()){
		if (conectado == false || tc.isClosed() || isBufferDeSaidaComErro || contaErros >= 15) {
			try {
				reConectar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//System.out.println("host desconhecido primeira tentativa");
			}
		}
		if (conectado) {
			leEvento();
			UtilsThreads.pausaNaThread(200);
			dadoRecebido = recebeDado();
			//System.out.println(dadoRecebido);
			if (dadoRecebido == "" || dadoRecebido == null){
				contaErros++;
			}
			else if (dadoRecebido.contains("LIDO")){
				continue;
			}
			else {
				listaDeMensagens.add(dadoRecebido);
				contaErros = 0;
				log.info("JThread: Recebido o evento: " + dadoRecebido + "\n" +
				"do ip: " + this.ip);
				//contagem = contagem + 1;
				//System.out.println("Conta fila =" + contagem);
			}
			if (contaErros >= 5) {
				UtilsThreads.pausaNaThread(2000);
				continue;
			}
			//this.bufferCircular.add(dadoRecebido);
		}
		UtilsThreads.pausaNaThread(100);
		}
	}

	private boolean isThreadViva() {
		// TODO Auto-generated method stub
		
		return threadViva;
	}
	

	private String recebeDado() {
		// TODO Auto-generated method stub
			boolean recebeu = false;
			String Dado = "";
			int count = 0;
			try
			{
				while ((conectado == true) && (recebeu == false) && (count < 50))
				{
					if (nsIn.available() > 0)
					{
						do
						{
							Dado += (char) nsIn.read();
						} while ((nsIn.available() > 0));
						recebeu = true;
					}
					else
					{
						UtilsThreads.pausaNaThread(10);
						count++;
					}
				}
			}
			catch(Exception e)
			{
				conectado = false;
			}
			return Dado;
		}

	private void leEvento() {
		// TODO Auto-generated method stub
		isBufferDeSaidaComErro = !enviaDado("LEEVNT;1;");
	}

	private boolean enviaDado(String string) {
		// TODO Auto-generated method stub
		boolean feito = false;
		int conta = 0;
		
		try
		{
			while (!feito && conta < 10)
			{
				try
				{
					nsOut.write(string.getBytes(), 0, string.length());
					nsOut.flush();
					feito = true;
				} catch (Exception e)
				{
					//System.out.println(e);
					conta++;
					UtilsThreads.pausaNaThread(20);
					feito = false;
				}
 			}
			return feito;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
}
