package idw.webservices.rest.auth;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import java.util.Base64;
import java.util.Base64.Decoder;

public class TokenFilter {
	
	public static void validar(HttpServletRequest request) {
		String token = request.getHeader(TokenUtil.TOKEN_HEADER);

	    if(token == null || token.trim().isEmpty()){
	    	throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	    }
	    
	    try {
			TokenUtil.decode(token);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
	}
	
	
	public static void validarNIDW(HttpServletRequest request) {
		String token = request.getHeader(TokenUtilNIDW.TOKEN_HEADER);

	    if(token == null || token.trim().isEmpty()){
	    	throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	    }
	    
	    try {
			TokenUtilNIDW.decode(token);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
	}

	
	public static void validarBasicAuthNIDW(String authString) { 
		if(!isUserAuthenticated(authString)){
			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
	}
	
   private static boolean isUserAuthenticated(String authString){
         
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        
        byte[] bytes = null;
        try {
           	Decoder decoder = Base64.getDecoder(); 
    		bytes = decoder.decode(authInfo);
    		
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes); 
         
         
        return (decodedAuth.equals(TokenUtil.TOKEN_HEADER_AUTHORIZATION_IHM_MOBILE_USER_PWD));
    }
}
