package idw.webservices.rest.auth;


import java.util.Date;


import idw.model.rn.DataHoraRN;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtilNIDW {
	private static final int EXPIRATION_TIME = DataHoraRN.SEG_DIA;
	private static final String SECRET = "ld3r04pcj30v74jrnd91";
	private static final String TOKEN_PREFIX = "Bearer";
	//private static final String ISSUER = "MAPTECHNOLOGY";
    public static final String TOKEN_HEADER = "Authorization";
    

    public static String create(String login) throws Exception {
    	try {
    	    String token = Jwts.builder() 
    	        .setSubject(login)
    	        .setExpiration(DataHoraRN.adicionaSegundosNaData(new Date(), EXPIRATION_TIME))
    	        .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    	    return token;
    	} catch (Exception ex){
    		throw new Exception("TOKEN - Error in creation: " + ex.getMessage());
    	}
    }
    
    public static void decode(String token) throws Exception {
    	try {
    	    String login = Jwts.parser() 
        	        .setSigningKey(SECRET)
        	        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
        	        .getBody().getSubject();
    	    
    	    if (login == null) {
    	    	throw new Exception("TOKEN - validation error: invalid login");
    	    }
    	    
		} catch (Exception ex) {
    		throw new Exception("TOKEN - validation error: " + ex.getMessage());
		}
    }
}
