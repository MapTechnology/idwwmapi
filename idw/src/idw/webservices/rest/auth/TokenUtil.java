package idw.webservices.rest.auth;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import idw.model.rn.DataHoraRN;

/**
 * Classe utilitária que será a responsável pela manipulação do token.
 * 
 * @author Alex
 *
 */
public class TokenUtil {
	
	private static final int EXPIRATION_TIME = DataHoraRN.SEG_DIA;
	private static final String SECRET = "ld3r04pcj30v74jrnd91";
	private static final String ISSUER = "MAPTECHNOLOGY";
    public static final String TOKEN_HEADER = "Authentication";
    public static final String TOKEN_HEADER_AUTHORIZATION_IHM_MOBILE_USER_PWD = "IhmWeb:MapConecthus";
    

    public static String create(String login) throws Exception {
    	try {
    	    Algorithm algorithm = Algorithm.HMAC256(SECRET);
    	    String token = JWT.create()
    	        .withIssuer(ISSUER)
    	        .withClaim("login", login)
    	        .withExpiresAt(DataHoraRN.adicionaSegundosNaData(new Date(), EXPIRATION_TIME))
    	        .sign(algorithm);
    	    return token;
    	} catch (UnsupportedEncodingException exception){
    		throw new Exception("UTF-8 encoding not supported");
    	} catch (JWTCreationException exception){
    		throw new Exception("Invalid Signing configuration / Couldn't convert Claims.");
    	}
    }
    
    public static void decode(String token) throws Exception {
    	try {
    	    Algorithm algorithm = Algorithm.HMAC256(SECRET);
    	    JWTVerifier verifier = JWT.require(algorithm)
    	        .withIssuer(ISSUER)
    	        .build();
    	    DecodedJWT jwt = verifier.verify(token);
    	    // System.out.println(jwt.getClaim("login").asString() + " expira: " +jwt.getExpiresAt().toString());
    	} catch (UnsupportedEncodingException exception){
    		throw new Exception("UTF-8 encoding not supported");
    	} catch (JWTVerificationException exception){
    		throw new Exception("Token inválido");
    	}
    }

}
