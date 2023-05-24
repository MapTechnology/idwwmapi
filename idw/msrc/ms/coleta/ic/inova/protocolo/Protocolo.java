package ms.coleta.ic.inova.protocolo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;

import ms.util.UtilsThreads;

//Protocolo INOVA V2

//Formato dos dados
//os dados são transmitidos em formato binário e na seguinte forma:
//7 -> Start
//8 -> Stop
//9 -> MARK serve para codificar os números especiais, que são: 7,8,9,0
//os números reservados são antecedidos por 9 + um código, da seguinte forma:
//número    dado enviado
//7         9 1
//8         9 2
//9         9 3
//0         9 4
//$         9 0x44
//Dessa forma podemos encapsular a informacao e toda informaçào é enviada em formato binário. economizando tempo
//ao invés de enviar informações ASCII

//Formato completo do protocolo V2:
//Descrição                     tamanho em bytes
//Start                         1 
//tamanho do dado               2
//tp                            1
//requisição                    2                    
//dados..                       1 byte cada
//CS                            2 bytes SOMA de todos os dados
//Stop                          1 byte

public class Protocolo {
	public static int SEM_DADO = 0x00;
	public static int OK = 0x01;
	public static int DADO_CORROMPIDO = 0x02;
	public static int PROTOCOLO_INVALIDO_INICIO = 0x03;
	public static int PROTOCOLO_TAMANHO_EXCEDIDO = 0x04;
	public static int PROTOCOLO_INVALIDO_CHECKSUM = 0x05;
	public static int PROTOCOLO_INVALIDO_FIM = 0x06;
	
	private int requisicao;

	private boolean isInicioDePacote = true;
	
	private static Protocolo instancia = null;
	
	public void inicializaEstruturaProtocolo(TPProtocoloV2 p)
	{
		p.dados = new byte[301];
		p.bufferAux = new byte[301];
		p.indiceAux = 0;
	}
	
	public static Protocolo getInstancia()
	{
		if(instancia == null)
		{
			instancia = new Protocolo();
		}
		return instancia;
	}
	
	public void preparaRecebimentoProtocolo(TPProtocoloV2 p)
	{
        p.dados = new byte[301];
        p.bufferAux = new byte[301];
        p.requisicao = 0;
        p.szDado = 0;
        p.status = 0;
        p.tipo = 1;
	}
	
	private byte getEscape(byte[] dado, TPProtocoloV2 p)
	{
		byte retorno = dado[p.indiceGetEscape];
		if (retorno == 0x09)
		{
			p.indiceGetEscape++;
			switch (dado[p.indiceGetEscape])
			{
			case 0x01:
				retorno = 0x07;
				break;
			case 0x02:
				retorno = 0x08;
				break;
			case 0x03:
				retorno = 0x09;
				break;
			case 0x04:
				retorno = 0x00;
				break;
			case 0x44:
				retorno = 0x24;
				break;
			default:
				retorno = dado[p.indiceGetEscape];
				break;
			}
		}
		p.indiceGetEscape++;
		return retorno;
	}
	
	private short putEscape(byte dado, byte[] destino, short indiceDestino)
	{
		switch (dado)
		{
		case 0x00:
			destino[indiceDestino] = 0x09;
			indiceDestino = (short) (indiceDestino + 1);
			destino[indiceDestino] = 0x04;
			break;
		case 0x07:
			destino[indiceDestino] = 0x09;
			indiceDestino = (short) (indiceDestino + 1);
			destino[indiceDestino] = 0x01;
			break;
		case 0x08:
			destino[indiceDestino] = 0x09;
			indiceDestino = (short) (indiceDestino + 1);
			destino[indiceDestino] = 0x02;
			break;
		case 0x09:
			destino[indiceDestino] = 0x09;
			indiceDestino = (short) (indiceDestino + 1);
			destino[indiceDestino] = 0x03;
			break;
		case 0x24:
			destino[indiceDestino] = 0x09;
			indiceDestino = (short) (indiceDestino + 1);
			destino[indiceDestino] = 0x44;
			break;
		default:
			destino[indiceDestino] = dado;
			break;
		}
		return indiceDestino;
	}
	
	short checksumV2(byte[] ptr, short sz)
	{
		short chk = 0;
		int indice = 0;
		while (sz-- != 0)
			chk += ptr[indice++];
		return chk;
	}
	
	private void formataDadosRecebidoV2(TPProtocoloV2 p)
	{
		int szDado = 0, cksum = 0;
		try
		{
			p.indiceGetEscape = 0;
			
			p.szDado = 0;
			
			szDado = (int)(getEscape(p.bufferAux, p) ^ (int)(getEscape(p.bufferAux, p) << 8));
			p.tipo = getEscape(p.bufferAux, p);
			p.requisicao = (int)(getEscape(p.bufferAux, p) ^ (int)(getEscape(p.bufferAux, p) <<8));
			p.requisicao++;
			while (szDado-- > 0)
			{
				p.dados[p.szDado] = getEscape(p.bufferAux, p);
				p.szDado++;
			}
			cksum = (int)(getEscape(p.bufferAux, p) ^ (int)(getEscape(p.bufferAux, p) << 8));
			
			if(p.bufferAux[p.indiceGetEscape] != 0x08)
			{
				if (cksum == checksumV2(p.dados, (short)p.szDado))
				{
					p.dados[p.szDado] = 0x00;
					p.status = OK;
				}
				else
				{
					p.status = PROTOCOLO_INVALIDO_CHECKSUM;
				}
			}
			else
				{
					p.status = PROTOCOLO_INVALIDO_FIM;
				}
		}
			catch(Exception e){
				isInicioDePacote = true;
			}
	
}
	public void Trata_Dado_Recebido(byte dado, TPProtocoloV2 p)
	{
		if (isInicioDePacote == true)
		{
			p.indiceAux = 0;
			if(dado == 0x07)
			{
				isInicioDePacote = false;
			}
		}
		else
		{
			if (dado == 0x08)
			{
				formataDadosRecebidoV2(p);
				isInicioDePacote = true;
			}
			else
			{
				p.bufferAux[p.indiceAux] = dado;
				p.indiceAux++;
			}
		}
	}
	
	public void formataDadosEnvioV2(TPProtocoloV2 p, byte[] dadosParaEnvio)
	{
		short szTemp = 0;
		short checksum = 0;
		short szDado = 0;
		short indiceTmp = 0;
		int i = 0;
		
		checksum = checksumV2(dadosParaEnvio, p.szDado);
		
		while (p.szDado-- > 0)
		{
			szDado = putEscape(dadosParaEnvio[szTemp++], p.bufferAux, szDado);
			szDado++;
		}
		
		if(szDado > 301)
		{
			p.status = PROTOCOLO_TAMANHO_EXCEDIDO;
			return;
		}
		indiceTmp = 0;
		
		p.dados[indiceTmp] = 0x07;
		indiceTmp++;
		
		indiceTmp = putEscape((byte)szTemp, p.dados, indiceTmp);
		indiceTmp++;
		indiceTmp = putEscape((byte)(szTemp >> 8), p.dados, indiceTmp);
		indiceTmp++;
		indiceTmp = putEscape((byte)p.tipo, p.dados, indiceTmp);
		indiceTmp++;
		indiceTmp = putEscape((byte)p.requisicao, p.dados, indiceTmp);
		indiceTmp++;
		indiceTmp = putEscape((byte)(p.requisicao >>8), p.dados, indiceTmp);
		indiceTmp++;
		
		p.szDado = szDado;
		
		while (szDado-- > 0)
		{
			p.dados[indiceTmp++] = p.bufferAux[i++];
		}
		
        indiceTmp = putEscape((byte)checksum, p.dados, indiceTmp);
        indiceTmp++;
        indiceTmp = putEscape((byte)(checksum >> 8), p.dados, indiceTmp);
        indiceTmp++;

        p.dados[indiceTmp] = 0x08;

        indiceTmp++;

        p.szDado = indiceTmp;

        p.status = OK;
	}
	
	public void recebeCharProtocolo(TPProtocoloV2 p, char dado)
	{
		p.bufferAux[p.indiceAux++] = (byte)dado;
	}
	
	private void CodString(TPProtocoloV2 pt, String StrDado)
	{
		inicializaEstruturaProtocolo(pt);
		byte[] buff = new byte[StrDado.length() + 1];
		int indice;
		pt.szDado = (short)StrDado.length();
		indice = 0;
		while (indice < pt.szDado)
		{
			char aux[] = StrDado.toCharArray();
			buff[indice] = (byte) aux[indice];
			indice++;
		}
		pt.requisicao = this.requisicao;
		
		formataDadosEnvioV2(pt, buff);
		
		return;
	}
	
	private String ObtemDados(TPProtocoloV2 TP)
	{
		String Valor = "";
		int N;
		if (TP.dados == null) return Valor;
		for ( N = 0; N <= TP.szDado - 1; N++)
		{
			char charAux = (char) TP.dados[N];
			Valor = Valor + Character.toString(charAux);
		}
		return Valor;
	}
	
	public String RecebeDado(Socket tc, BufferedInputStream ns, boolean Conectado)
	{
		boolean recebeu = false;
		TPProtocoloV2 Pt = new TPProtocoloV2();
		String Dado = "";
		int count = 0;
		try
		{
			while ((Conectado == true) && (recebeu == false) && (count < 50))
			{
				if (ns.available() > 0)
				{
					isInicioDePacote = true;
					Pt = new TPProtocoloV2();
					inicializaEstruturaProtocolo(Pt);
					do
					{
						Trata_Dado_Recebido((byte) ns.read(), Pt);
					} while ((Pt.status != Protocolo.OK) && (ns.available() > 0));
					Dado = ObtemDados(Pt);
					this.requisicao = Pt.requisicao;
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
			Conectado = false;
		}
		return Dado;
	}
	
	public boolean EnviaDado(String Dado, BufferedOutputStream ns)
	{
		int N;
		boolean feito = false;
		int conta = 0;
		
		TPProtocoloV2 Pt = new TPProtocoloV2();
		try
		{
			while (!feito && conta < 10)
			{
				try
				{
					CodString(Pt, Dado);
					N = Pt.szDado;
					ns.write(Pt.dados, 0, N);
					ns.flush();
					feito = true;
				} catch (Exception e)
				{
					System.out.println(e);
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
		
