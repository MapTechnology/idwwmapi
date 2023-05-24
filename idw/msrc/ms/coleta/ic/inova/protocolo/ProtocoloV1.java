package ms.coleta.ic.inova.protocolo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import idw.util.IdwLogger;
import ms.util.UtilsThreads;

public class ProtocoloV1 {
	
	public static Protocolo instancia = null;
	
	public ProtocoloV1() {
	}
	
	public static final Protocolo getInstancia() {
		if (instancia == null) {
			instancia = new Protocolo();
		}
		
		return(instancia);
	}
	
	public String RecebeDado(Socket tc, BufferedInputStream nsIn) {
		Boolean recebeu = false;
		TPProtocoloV1R0 Pt = new TPProtocoloV1R0();
		String Dado = "";
		int count = 0;
		Boolean Conectado = tc.isConnected();
		byte lcDado;
		while ((Conectado == true) && (recebeu == false) && (count < 11)) {
			try {
				if (nsIn.available() > 0) {
					
					Pt = new TPProtocoloV1R0();
					
					do {
						lcDado = (byte) nsIn.read();
						Trata_Dado_Recebido(lcDado, Pt);
					} while (lcDado != 8);
					Dado = ObtemDados(Pt);
					recebeu = true;
				}
				else {
					UtilsThreads.pausaNaThread(5);
					count++;
				}
			} catch(IOException e) {
				//System.out.println(e.getClass()+" --- "+e.getCause()+" --- "+e.getMessage());
				// faz nada, somente sleepa e tenta de novo
				count++;
				UtilsThreads.pausaNaThread(100);
				e.printStackTrace();
			}
			
			Conectado = tc.isConnected();
			//Fecha a conex�o com o servidor
		}
		
		return(Dado);
	}
	
	@Deprecated
	public byte[] RecebeDadoDnc(Socket tc, BufferedInputStream nsIn, IdwLogger log, int idLog) {
		Boolean recebeu = false;
		TPProtocoloV1R0 Pt = new TPProtocoloV1R0();
		int count = 0;
		Boolean Conectado = tc.isConnected();
		byte lcDado;
		byte[] bDado = new byte[0];
		while ((Conectado == true) && (recebeu == false) && (count < 23)) {
			try {
				if (nsIn.available() > 0) {
					
					Pt = new TPProtocoloV1R0();
					
					do
					{
						lcDado = (byte) nsIn.read();
						Trata_Dado_Recebido(lcDado, Pt);
					} while (lcDado != 8);
					recebeu = true;
					bDado = new byte[Pt.tamanho_dado];
					bDado = Pt.dados;
				}
				else {
					UtilsThreads.pausaNaThread(5);
					count++;
				}
			} catch(IOException e) {
				log.info(idLog, 0, e.getClass()+" --- "+e.getCause()+" --- "+e.getMessage());
				// faz nada, somente sleepa e tenta de novo
				count++;
				UtilsThreads.pausaNaThread(100);
				e.printStackTrace();
			}
			
			Conectado = tc.isConnected();
			//Fecha a conex�o com o servidor
		}
		
		return bDado;
	}
	
	public Boolean enviaDado(String Dado, BufferedOutputStream nsOut) {
		//int N;
		byte[] Vetor;
		Boolean feito = false;
		int conta = 0;
		//System.out.println("Envia dado: " + Dado);
		try {
			while (!feito && conta < 10) {
				try {
					Vetor = CodString(Dado);
					//N = Vetor.length - 1;
					//nsOut.write(Vetor, 0, N);
					nsOut.write(Vetor);
					nsOut.flush();
					feito = true;
				} catch (IOException e) {
//					log.info(e.getClass()+" --- "+e.getCause()+" --- "+e.getMessage());
					conta++;
					UtilsThreads.pausaNaThread(20);
					e.printStackTrace();
				}
			}
			
			return(feito);
		} catch (Exception e) {
			return(false);
		}
	}
	
	@Deprecated
	public Boolean EnviaDadoDnc(byte[] bDado, BufferedOutputStream nsOut, IdwLogger log, int idLog) {
		//int N;
		byte[] Vetor;
		Boolean feito = false;
		int conta = 0;
		try {
			while (!feito && conta < 10) {
				try {
					Vetor = PreparaDnc(bDado);
					//N = Vetor.length - 1;
					//nsOut.write(Vetor, 0, N);
					nsOut.write(Vetor);
					nsOut.flush();
					feito = true;
				} catch (IOException e) {
					log.info(idLog, 0, e.getClass()+" --- "+e.getCause()+" --- "+e.getMessage());
					conta++;
					UtilsThreads.pausaNaThread(20);
					e.printStackTrace();
				}
			}
			
			return(feito);
		} catch (Exception e) {
			return(false);
		}
	}
	
	// Esta Rotina Recebe um dado, e trata.
	public void Trata_Dado_Recebido(byte dado, TPProtocoloV1R0 p)
	{
		short Dado16 = 0;
		if (p.Recebeu == true) {
			return; // j� tem um dado recebido e que nao foi tratado
		}
		
		if (dado == 7) {
			p.ctrl_start = true;
			p.ctrl_indice_buffer = 0;
			p.ctrl_indice_cabecalho = 0;
			p.ctrl_cs = 0x0;
			p.ctrl_mark = false;
		}
		else if (dado == 8) {
			if (p.ctrl_start) {
				if (p.cs == p.ctrl_cs) {
					// recebeu um dado v�lido
					p.Recebeu = true;
					
				}
			}
		}
		else if (dado == 9) {
			p.ctrl_mark = true;
		}
		else if (dado == 0) {
			p.ctrl_start = false;
		}
		else {
			if (p.ctrl_mark) {
				p.ctrl_mark = false;
				if (dado == 1) {
					dado = 7;
				}
				else if (dado == 2) {
					
					dado = 8;
				}
				else if (dado == 3) {
					
					dado = 9;
				}
				else if (dado == 4) {
					
					dado = 0;
				}
			}
			if (p.ctrl_indice_cabecalho < 7) {
				// dados de cabe�alho
				Dado16 = (short) (dado & 0xFF); // gambi, verificar se funciona - funciona
				if (p.ctrl_indice_cabecalho == 0) {
					Dado16 = (short)(Dado16 << 8);
					p.endereco_fonte = Dado16; // msb
				}
				else if (p.ctrl_indice_cabecalho == 1) {
					p.endereco_fonte = (short)(Dado16 | p.endereco_fonte);
				}
				else if (p.ctrl_indice_cabecalho == 2) {
					Dado16 = (short)(Dado16 << 8);
					p.endereco_destino = Dado16;
				}
				else if (p.ctrl_indice_cabecalho == 3) {
					p.endereco_destino = (short) (p.endereco_destino | dado);
				}
				else if (p.ctrl_indice_cabecalho == 4) {
					Dado16 = (short) (Dado16 << 8);
					p.tamanho_dado = Dado16;
				}
				else if (p.ctrl_indice_cabecalho == 5) {
					p.tamanho_dado = (short) (p.tamanho_dado | dado);
					p.dados = new byte[p.tamanho_dado - 1 + 1];
				}
				else if (p.ctrl_indice_cabecalho == 6) {
					if (dado == 1)
						p.is_pct_dnc = 1;
					else
						p.is_pct_dnc = 0;
				}
				p.ctrl_cs = (short) ((p.ctrl_cs + dado) & 0xFFFF);
				p.ctrl_indice_cabecalho++;
			}
			else {
				//dados
				if (p.ctrl_indice_buffer < p.dados.length && p.ctrl_indice_buffer < p.tamanho_dado) {
					p.dados[p.ctrl_indice_buffer] = dado;
					p.ctrl_cs = (short)((p.ctrl_cs + dado) & 0xFFFF);
				}
				else {
					if (p.ctrl_indice_buffer == p.tamanho_dado) {
						p.cs = (short) (dado & 0xFF); // MSB do CS
						p.cs = (short) (p.cs << 8);
					}
					else if (p.ctrl_indice_buffer == (p.tamanho_dado + 1)) {
						p.cs = (short) (p.cs | dado); // LSB do CS
					}
					else {
						p.ctrl_start = false; // erro
					}
				}
				p.ctrl_indice_buffer++;
			}
		}
	}
	
	private String ObtemDados(TPProtocoloV1R0 TP)
	{
		String Valor = "";
		Valor = new String(TP.dados);
		
		return(Valor);
	}
	
	
	private byte[] CodString(String StrDado) {
		TPProtocoloV1R0 Pt = new TPProtocoloV1R0();
		Pt.dados = new byte[StrDado.length() + 1];
		byte[] oByteTemp;
		byte[] Vetor = null;
		
		//int tamanho;
		//int indice;
		//tamanho = StrDado.length();
		//indice = 0;
		//while (indice < tamanho)
		//{
		//	Pt.dados[indice] = Byte.parseByte(StrDado.substring(indice, indice));
		//	indice++;
		//}
		//Pt.dados = StrDado.getBytes();
		
		oByteTemp = StrDado.getBytes();
		
		Integer cont = 0;
		for(byte oByte : oByteTemp) {
			Pt.dados[cont] = oByte;
			cont++;
		}
		Pt.dados[cont] = (byte) 0;
		
		Pt.cfg_meu_endereco = 0;
		Pt.tamanho_dado = (short) Pt.dados.length;
		Pt.endereco_destino = 999;
		Pt.endereco_fonte = 0;
		
		Vetor = Monta_Dados(Pt);
		
		return Vetor;
	}
	
	// Esta rotina monta a informa��o para ser enviada no formado do protocolo V1R0
	public byte[] Monta_Dados(TPProtocoloV1R0 dadoProtocolo) {
		ConcurrentLinkedQueue<Short> fila = new ConcurrentLinkedQueue<Short>();
		int N, M;
		short CS = 0x0;
		short D;
		
		fila.offer((short)(7)); // Start
		
		short temp_endereco_fonte = dadoProtocolo.endereco_fonte;
		D = (short)(temp_endereco_fonte >> 8);
		CS = (short)((CS + D) & 0xFFFF);
		Monta_Dado_do_Protocolo(D, fila); // MSB do endere�o da fonte
		
		D = (short)(dadoProtocolo.endereco_fonte & 255);
		CS = (short)((CS + D) & 0xFFFF);
		Monta_Dado_do_Protocolo(D, fila); // LSB do endere�o da fonte
		
		short temp_endereco_destino = dadoProtocolo.endereco_destino;
		D = (short)(temp_endereco_destino >> 8);
		CS = (short)((CS + D) & 0xFFFF);
		Monta_Dado_do_Protocolo(D, fila); // MSB do endere�o do destino
		
		D = (short) (dadoProtocolo.endereco_destino & 255);
		CS = (short)((CS + D) & 0xFFFF);
		Monta_Dado_do_Protocolo(D, fila); // LSB do endere�o do destino
		
		short temp_tamanho_dado = dadoProtocolo.tamanho_dado;
		D = (short)(temp_tamanho_dado >> 8);
		CS = (short)((CS + D) & 0xFFFF);
		Monta_Dado_do_Protocolo(D, fila); // MSB
		
		D = (short)(dadoProtocolo.tamanho_dado & 255);
		CS = (short)((CS + D) & 0xFFFF);
		Monta_Dado_do_Protocolo(D, fila); // LSB
		
		
		D = (short)(dadoProtocolo.is_pct_dnc & 255);
		CS = (short)((CS + D) & 0xFFFF);
		Monta_Dado_do_Protocolo(D, fila); // MSB
		
		
		for (N = 0; N <= dadoProtocolo.tamanho_dado - 1; N++) {
			Monta_Dado_do_Protocolo(dadoProtocolo.dados[N], fila);
			CS = (short)((CS + dadoProtocolo.dados[N]) & 0xFFFF);
		}
		// CS
		short temp_CS = CS;
		D = (short)(temp_CS >> 8);
		Monta_Dado_do_Protocolo(D, fila); // CS MSB
		D = (short)(CS & 0xFF);
		Monta_Dado_do_Protocolo(D, fila); // CS LSB
		
		fila.offer((short)(8)); // Stop
		
		byte[] dados_montados = new byte[fila.size() + 1];
		M = fila.size() - 1;
		for (N = 0; N <= M; N++) {
			dados_montados[N] = fila.poll().byteValue();
		}
		
		return(dados_montados);
	}
	
	// Monta o dado a ser enviado
	private void Monta_Dado_do_Protocolo(short dado, ConcurrentLinkedQueue<Short> fila) {
		if (dado == 7) {
			fila.offer((short)(9)); //mark
			dado = 1;
		}
		else if (dado == 8) {
			fila.offer((short)(9)); //mark
			dado = 2;
		}
		else if (dado == 9) {
			fila.offer((short)(9)); //mark
			dado = 3;
		}
		else if (dado == 0) {
			fila.offer((short)(9)); //mark
			dado = 4;
		}
		fila.offer(dado);
	}
	
	private byte[] PreparaDnc(byte[] ByteDado) {
		TPProtocoloV1R0 Pt = new TPProtocoloV1R0();
		Pt.dados = new byte[ByteDado.length + 11];
		byte[] Vetor = null;
		int tamanho = ByteDado.length;
		int indice=0;
		String cmdputdnc = "PUTPCTDNC;";
		
		for(indice = 0; indice < 10; indice++) {
			Pt.dados[indice] = Byte.parseByte(cmdputdnc, indice);
		}
		
		for (indice = 0; indice < tamanho; indice++) {
			Pt.dados[indice+10] = ByteDado[indice];
		}
		
		Pt.cfg_meu_endereco = 0;
		Pt.tamanho_dado = (short)(tamanho+11);
		Pt.endereco_destino = 999;
		Pt.endereco_fonte = 0;
		Pt.is_pct_dnc = 1;
		
		Vetor = Monta_Dados(Pt);
		
		return Vetor;
	}
}
