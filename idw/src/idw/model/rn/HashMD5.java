/**
 * 
 */
package idw.model.rn;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

import idw.model.excessoes.DigestFileException;


/**
 * @author jairson.rodrigues
 *
 */
public class HashMD5 {
	
	/**
	 * This method should calculate the hash code of a file using the MD5 algorithm.
	 * 
	 * @param originalFile The file which the hash code will be calculated
	 * @return The file hash code
	 * @throws DigestFileException
	 */
	public static String getHashCode(File originalFile) throws DigestFileException {
		String hashCode = "";
		try {
			FileInputStream fis = new FileInputStream(originalFile);
			
			// Digest the file and generate the protocol number
			byte[] buffer = new byte[1024];
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		    int len;
			
		    while((len = fis.read(buffer)) >= 0) {
			  byteArray.write(buffer, 0, len);
		    }
			
		    hashCode = getHashCode(byteArray.toByteArray());
			
			fis.close();
			
		} catch (Throwable e) {
			handleException(e);
		}
		
		return hashCode;
	}
	
	/**
	 * This method should calculate the hash code of a file using the MD5 algorithm.
	 * 
	 * @param originalBytes The chaim of bytes which the hash code will be calculated
	 * @return The file hash code
	 * @throws DigestFileException
	 */
	public static String getHashCode(byte[] pBytes) throws DigestFileException {
		String hashCode = "";
		MessageDigest messageDigest = null;		
		
		try {
			
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(pBytes);
			hashCode = toHex(messageDigest.digest());
			
		} catch (Throwable e) {
			handleException(e);
		}
		
		return hashCode;
	}
	
	/**
	 * This method should calculate the hash code of a file using the MD5 algorithm.
	 * 
	 * @param pTextPlains The chaim of bytes which the hash code will be calculated
	 * @return The String hash code
	 * @throws DigestFileException
	 */
	public static String getHashCode(String pTextPlain) throws DigestFileException {
		String hashCode = "";
		
		if (pTextPlain != null)
			hashCode = HashMD5.getHashCode(pTextPlain.getBytes()); 
		
		return hashCode;
	}
	
	/**
	 * This method must translate an byte array into an Hexadecimal number. This should be used to
	 * translate an digest output into a protocol number. 
	 * 
	 * @param outputBytes The array of bytes outputed from the digest algorithm
	 * @return Hexadecimal representation an array of bytes
	 */
	private static String toHex(byte[] outputBytes) {
		StringBuffer result = new StringBuffer();
		
		for (int i = 0; i < outputBytes.length; i++) {
			//TODO: A codificacao abaixo esta engolindo um zero quando comparado com o metodo correto encontrado na internet
			/*Adicionado por amaury em 13.10.14*/
			result.append(Integer.toHexString((outputBytes[i]) & 0xFF));
		}
		
		return result.toString();
	}
	
	/**
	 * @param pThrowble
	 * @param pErrors
	 * @throws DigestFileException 
	 */
	private static void handleException(Throwable pThrowble) throws DigestFileException {
		
		if (pThrowble instanceof Exception) {
			throw new DigestFileException(pThrowble.getMessage(), pThrowble);
			
		} else {
			pThrowble.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			
			System.out.printf("\n%s -> %s", "codigo", HashMD5.getHashCode("electrolux")); 
			System.out.printf("\n%s -> %s", "descricao", HashMD5.getHashCode("chile"));
			System.out.printf("\n%s -> %s", "endereco", HashMD5.getHashCode("chile"));
			System.out.printf("\n%s -> %s", "cidade", HashMD5.getHashCode("chile"));
			System.out.printf("\n%s -> %s", "estado", HashMD5.getHashCode("chile"));
			System.out.printf("\n%s -> %s", "pais", HashMD5.getHashCode("chile"));			
			
			
		} catch (DigestFileException e) {
			//System.out.println(e.getMessage());
		}
	}

	public static boolean isSenhaValida(String pTextPlain, String pHashCode) throws DigestFileException {

		String hashCodeFromTextPlain = null;
		boolean result = false;
		
		if (pTextPlain == null || pHashCode == null) {
			throw new IllegalArgumentException();
		}
		
		hashCodeFromTextPlain = pTextPlain;
		
		if (hashCodeFromTextPlain.equals(pHashCode)) {
			result = true;
		}
		
		return result;
		
	}
}
