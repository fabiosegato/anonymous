package br.com.spring.anonymous.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.spring.anonymous.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${anonymous.jwt.expiration}")
	private String expiration;
	
	@Value("${anonymous.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authenticate) {
		
		Usuario logado = (Usuario) authenticate.getPrincipal();
		Date hoje = new Date();
			
		//@SuppressWarnings("deprecation")
		Date dataExpiracao = new Date(hoje.getTime()+Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API anonymous")
				.setSubject(logado.getNome())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, this.secret)
				.compact();
	
	}

	public boolean isTokenValid(String token) {
		
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
			
		} catch (Exception e) {
			return false;
		}		
		
	}

	public String getUsuario(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return body.getSubject();
		
	}

}
