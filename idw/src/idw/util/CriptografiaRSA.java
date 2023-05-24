package idw.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;

import idw.model.excessoes.CriptografiaException;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;


public class CriptografiaRSA {
	private final String ALGORITHM = "RSA";
	private static StringBuilder vChavePublica = new StringBuilder();

	/**
	 * Local da chave privada no sistema de arquivos.
	 */
	private final String PATH_CHAVE_PRIVADA = "C:/keys/private.key";
	private final String PATH_CHAVE_PUBLICA = "C:/keys/public.key";


	public CriptografiaRSA() {
		super();
		vChavePublica.append("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjcRbmII7dqEuVmax7Uhe2fYIlCrjJp5YUHzvQ\n");
		vChavePublica.append("9dSu970hPD0xAXgVyagdRxUyX5MU3v1M2P9jBuBN/nM4e2tnmqkUYAu2DwSqNLm/6VejWHwI8xwL\n");
		vChavePublica.append("1Jz33R7osEAb5F+7Q1ULOrj5sMzcX24SdT5R2hqzqh/pC+sTxs6vYigZGwIDAQAB\n");
	}
	
	private byte[] fromHexString(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	public String descriptografar(String valorcriptografado) throws CriptografiaException{
		//BASE64Decoder decoder = new BASE64Decoder();
		Decoder decoder = Base64.getDecoder();
		byte[] sigBytes2;
		try {
			//sigBytes2 = decoder.decodeBuffer(vChavePublica.toString());
			sigBytes2 = decoder.decode(vChavePublica.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new CriptografiaException();
		}

		// Converte o array de byte em um PublicKey
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(sigBytes2);
		KeyFactory keyFact;
		try {
			keyFact = KeyFactory.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new CriptografiaException();
		}
		PublicKey pubKey;
		try {
			pubKey = keyFact.generatePublic(x509KeySpec);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			throw new CriptografiaException();
		}
		
		byte[] valorEmByte;
		try {
			//valorEmByte = decoder.decodeBuffer(valorcriptografado);
			valorEmByte = decoder.decode(valorcriptografado);
		} catch (Exception e) {
			throw new CriptografiaException();
		}

		return decriptografa(valorEmByte, pubKey);
	}

	/**
	 * Gera a chave que cont�m um par de chave Privada e P�blica usando 1025
	 * bytes. Armazena o conjunto de chaves nos arquivos private.key e
	 * public.key
	 */
	private void geraChave() {
		try {
			final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
			keyGen.initialize(1024);
			final KeyPair key = keyGen.generateKeyPair();

			File chavePrivadaFile = new File(PATH_CHAVE_PRIVADA);
			File chavePublicaFile = new File(PATH_CHAVE_PUBLICA);

			// Cria os arquivos para armazenar a chave Privada e a chave Publica
			if (chavePrivadaFile.getParentFile() != null) {
				chavePrivadaFile.getParentFile().mkdirs();
			}

			chavePrivadaFile.createNewFile();

			if (chavePublicaFile.getParentFile() != null) {
				chavePublicaFile.getParentFile().mkdirs();
			}

			chavePublicaFile.createNewFile();

			// Salva a Chave P�blica no arquivo
			ObjectOutputStream chavePublicaOS = new ObjectOutputStream(new FileOutputStream(chavePublicaFile));
			chavePublicaOS.writeObject(key.getPublic());
			chavePublicaOS.close();

			// Salva a Chave Privada no arquivo
			ObjectOutputStream chavePrivadaOS = new ObjectOutputStream(new FileOutputStream(chavePrivadaFile));
			chavePrivadaOS.writeObject(key.getPrivate());
			chavePrivadaOS.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Verifica se o par de chaves P�blica e Privada j� foram geradas.
	 */
	private boolean verificaSeExisteChavesNoSO() {

		File chavePrivada = new File(PATH_CHAVE_PRIVADA);
		File chavePublica = new File(PATH_CHAVE_PUBLICA);

		if (chavePrivada.exists() && chavePublica.exists()) {
			return true;
		}

		return false;
	}

	/**
	 * Criptografa o texto puro usando chave p�blica.
	 */
	private byte[] criptografa(String texto, PublicKey chave) {
		byte[] cipherText = null;

		try {
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			// Criptografa o texto puro usando a chave P�lica
			cipher.init(Cipher.ENCRYPT_MODE, chave);
			cipherText = cipher.doFinal(texto.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cipherText;
	}

	/*
	 * Criptografa usando a chave privada
	 */
	private byte[] criptografa(String texto, PrivateKey chave) {
		byte[] cipherText = null;

		try {
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			// Criptografa o texto puro usando a chave P�lica
			cipher.init(Cipher.ENCRYPT_MODE, chave);
			cipherText = cipher.doFinal(texto.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cipherText;
	}

	/**
	 * Decriptografa o texto puro usando chave privada.
	 */
	private String decriptografa(byte[] texto, PrivateKey chave) {
		byte[] dectyptedText = null;

		try {
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			// Decriptografa o texto puro usando a chave Privada
			cipher.init(Cipher.DECRYPT_MODE, chave);
			dectyptedText = cipher.doFinal(texto);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new String(dectyptedText);
	}

	/*
	 * Descriptografar usando a chave publica
	 */
	private String decriptografa(byte[] texto, PublicKey chave) {
		byte[] dectyptedText = null;

		try {
			final Cipher cipher = Cipher.getInstance(ALGORITHM);
			// Decriptografa o texto puro usando a chave Privada
			cipher.init(Cipher.DECRYPT_MODE, chave);
			dectyptedText = cipher.doFinal(texto);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new String(dectyptedText);
	}

	/**
	 * Testa o Algoritmo
	 */
	public static void main(String[] args) {
		CriptografiaRSA rn = new CriptografiaRSA();

		try {

			// Verifica se j� existe um par de chaves, caso contr�rio gera-se as
			// chaves..
			if (!rn.verificaSeExisteChavesNoSO()) {
				// M�todo respons�vel por gerar um par de chaves usando o
				// algoritmo RSA e
				// armazena as chaves nos seus respectivos arquivos.
				rn.geraChave();
			}
			List<String> mensagens = new ArrayList<>();
			/*mensagens.add("TestesIDW17|Testes do idw inovaSA Injet|Rua 44, 991|Manaus|AM|Brasil|");
			mensagens.add("1|licen�a de modulo / recurso|null|");
			mensagens.add("2|licen�a de posto injet|1|");
			mensagens.add("3|licen�a de posto insert|13|");
			mensagens.add("4|licen�a de posto inline verifica��o|8|");
			mensagens.add("5|licen�a de posto inline teste passa-n�o-passa|6|");
			mensagens.add("6|licen�a de posto inline teste com motivos de defeitos|7|");
			mensagens.add("7|licen�a de posto inline montagem|3|");
			mensagens.add("8|licen�a de posto inline teste funcional|4|");
			mensagens.add("9|licen�a de posto inline reprocesso|5|");
			mensagens.add("10|licen�a de posto CEP processo|14|");
			mensagens.add("11|licen�a de posto coleta discreta|15|");
			mensagens.add("12|licen�a de ponto de acesso TM|null|");
			mensagens.add("13|licen�a contrato manuten��o|null|");

			StringBuilder chaveEmpresa = new StringBuilder();
			chaveEmpresa.append("TestesIDW17");
			
			mensagens.add("1|1|" + chaveEmpresa + "|DEMO BASICO/BI|2016-01-18 09:45:00|2016-12-31 00:00:00|1|0|1|");
			mensagens.add("2|1|" + chaveEmpresa + "|DEMO 5 PONTOS INJET|2016-01-18 09:45:00|2016-12-31 00:00:00|1|5|2|");
*/
			StringBuilder chaveLicenca = new StringBuilder();
			chaveLicenca.append("DEMO 5 PONTOS INJET");
			mensagens.add("1|1|" + chaveLicenca + "|");
			//BASE64Encoder encoder = new BASE64Encoder();
			Encoder encoder = Base64.getEncoder();
			ObjectInputStream inputStream = null;

			// Criptografa a Mensagem usando a Chave P�blica
			inputStream = new ObjectInputStream(new FileInputStream(rn.PATH_CHAVE_PUBLICA));
			final PublicKey chavePublica = (PublicKey) inputStream.readObject();
			inputStream.close();

			// Decriptografa a Mensagem usando a Chave Pirvada
			inputStream = new ObjectInputStream(new FileInputStream(rn.PATH_CHAVE_PRIVADA));
			final PrivateKey chavePrivada = (PrivateKey) inputStream.readObject();
			inputStream.close();

			for (String msgOriginal : mensagens) {
				System.out.println("tamanho a criptografar=" + msgOriginal.length());

				byte[] textoCriptografado = rn.criptografa(msgOriginal, chavePrivada);
				/*
				int i = 0;
				for (Byte c : textoCriptografado) {
					char ca = (char) c.byteValue();
					System.out.println(i + " = " + c + " = " + ca);
					i++;
				}*/
				String textoPuro = rn.decriptografa(textoCriptografado, chavePublica);
				//String textoCriptografado2 = encoder.encode(textoCriptografado);
				String textoCriptografado2 = encoder.encodeToString(textoCriptografado);
	
				// Imprime o texto original, o texto criptografado e
				// o texto descriptografado.
				System.out.println("Mensagem Original: " + msgOriginal + " Mensagem Criptografada: " + textoCriptografado2.toString());
				System.out.println("Mensagem Decriptografada: " + textoPuro);
			}
			
			/*
			 * Convertendo a chave public para uma string
			 * 
			 */
			byte[] publicKeyBytes = chavePublica.getEncoded();
			
			//String pubKeyStr = encoder.encode(publicKeyBytes);
			String pubKeyStr = encoder.encodeToString(publicKeyBytes);

			//System.out.println(pubKeyStr);

			// Converter a string para uma nova chave publica e tentar
			// descriptografar
			
			//BASE64Decoder decoder = new BASE64Decoder();
			//Decoder decoder = Base64.getDecoder();
			Decoder decoder = Base64.getMimeDecoder();
			
			//byte[] sigBytes2 = decoder.decodeBuffer(vChavePublica.toString());
			//byte[] sigBytes2 = decoder.decode(vChavePublica.toString().replace("\n", ""));
			byte[] sigBytes2 = decoder.decode(vChavePublica.toString()); 
				
			String textoCriptografado = "[B@2cd0a9b2\n";
			// Converte o array de byte em um PublicKey
			X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(sigBytes2);
			KeyFactory keyFact = KeyFactory.getInstance("RSA");
			PublicKey pubKey2 = keyFact.generatePublic(x509KeySpec);
			
			//byte[] byteCV = decoder.decodeBuffer(textoCriptografado);
			//byte[] byteCV = Base64.getDecoder().decode(textoCriptografado.replace("\n", ""));
					
			final String textoPuro2 = rn.decriptografa(textoCriptografado.getBytes(), pubKey2);
			System.out.println("resultado chave publica em string = " + textoPuro2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
