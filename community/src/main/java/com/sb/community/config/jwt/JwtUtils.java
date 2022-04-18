package com.sb.community.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sb.community.config.user.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class.getSimpleName());

    private static final Algorithm ALGORITHM = Algorithm.HMAC256("subo");

    @Value("${subo.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return JWT.create()
                .withSubject((userPrincipal.getUsername()))
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .sign(ALGORITHM);
    }
    public VerifyResult getUserNameFromJwtToken(String token){
        try{
            //파싱
            DecodedJWT verify = JWT.require(ALGORITHM).build().verify(token);
            return VerifyResult.builder().success(true).username(verify.getSubject()).build();
        } catch(Exception ex){
            DecodedJWT decode = JWT.decode(token);
            return VerifyResult.builder().success(false)
                    .username(decode.getSubject()).build();
        }
    }

}
