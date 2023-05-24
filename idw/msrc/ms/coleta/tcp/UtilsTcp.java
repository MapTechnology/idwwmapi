package ms.coleta.tcp;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilsTcp {
	public static String getMACAddress() {
		String retorno = null;
		try {
			retorno = searchForMac();
			retorno = retorno.replaceAll("-", ":");
		} catch (NullPointerException | SocketException e) {
			retorno = "desconhecido";
		}
		return retorno;
	}
	
	private static String searchForMac() throws SocketException {
	    String firstInterface = null;        
	    Map<String, String> addressByNetwork = new HashMap<>();
	    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

	    while(networkInterfaces.hasMoreElements()){
	        NetworkInterface network = networkInterfaces.nextElement();

	        byte[] bmac = network.getHardwareAddress();
	        if(bmac != null){
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < bmac.length; i++){
	                sb.append(String.format("%02X%s", bmac[i], (i < bmac.length - 1) ? "-" : ""));        
	            }

	            if(sb.toString().isEmpty()==false){
	                addressByNetwork.put(network.getName(), sb.toString());
	            }

	            if(sb.toString().isEmpty()==false && firstInterface == null){
	                firstInterface = network.getName();
	            }
	        }
	    }

	    if(firstInterface != null){
	        return addressByNetwork.get(firstInterface);
	    }

	    return null;
	}
	
	public static List<String> getIPAddress() {
		List<String> retorno = new ArrayList<String>();
		
		Enumeration<NetworkInterface> e;
		try {
			e = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e1) {
			return retorno;
		}
		while(e.hasMoreElements()) {
		    NetworkInterface n = (NetworkInterface) e.nextElement();
		    Enumeration<InetAddress> ee = n.getInetAddresses();
		    while (ee.hasMoreElements()) {
		        InetAddress i = (InetAddress) ee.nextElement();
		        retorno.add(i.getHostAddress());
		    }
		}
		return retorno;
	}

}
