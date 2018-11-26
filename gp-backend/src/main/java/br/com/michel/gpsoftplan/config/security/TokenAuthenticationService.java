package br.com.michel.gpsoftplan.config.security;
import br.com.michel.gpsoftplan.api.v1.dto.UsuarioDto;
import br.com.michel.gpsoftplan.api.v1.dto.UsuarioDtoAssembler;
import br.com.michel.gpsoftplan.domain.model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

public class TokenAuthenticationService {

    // EXPIRATION_TIME = 10 dias
    static final long EXPIRATION_TIME = 860_000_000;
    static final String SECRET = "MySecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse response, Usuario user) {
        String JWT = Jwts.builder()
                .setSubject(user.getUsuario())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        response.addHeader("Content-Type", "application/json");

        UsuarioDtoAssembler usuarioDtoAssembler = new UsuarioDtoAssembler();
        try {
            UsuarioDto usuarioDto = usuarioDtoAssembler.toResource(user);
            usuarioDto.setAccessToken(TOKEN_PREFIX + " " + JWT);
            response.getWriter().write(new ObjectMapper().writeValueAsString(usuarioDto));
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // faz parse do token
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
        }
        return null;
    }
}
