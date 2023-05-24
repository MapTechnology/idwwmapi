package idw.util;

public class MacUtil {

	public static boolean isHexadecimal(String hex) {        
        return (hex != null && !hex.isEmpty() && hex.matches("^[0-9a-fA-F]+$"));
    }
    
    public static boolean isMACAddress(String macAddress) {
        return macAddress != null && macAddress.length() == 12 && isHexadecimal(macAddress);
    }

}
