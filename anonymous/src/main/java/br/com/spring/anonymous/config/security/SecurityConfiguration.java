package br.com.spring.anonymous.config.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutentificacaoService autenticacaoService;		
	
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
	    return new HttpSessionEventPublisher();
	}
	
	//configurações de autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	
	}	
	

	//configurações de acesso
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers(HttpMethod.POST,"/").permitAll()
		.antMatchers(HttpMethod.GET,"/").permitAll()
		.antMatchers(HttpMethod.DELETE,"/").permitAll();
		//.anyRequest().authenticated()
		//.and()
		//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		//.and().addFilterBefore(new AutenticacaoTokenFilter(tokenService,usuarioRepository), UsernamePasswordAuthenticationFilter.class);
	
	}
	
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		.invalidSessionUrl("/invalidSession.html");              
		
		http.authorizeRequests()
		// .antMatchers("/resetPassword").permitAll()
		.antMatchers("/expiredSession.html").permitAll()
		.anyRequest().authenticated()		
		.and().csrf().disable()
		.formLogin(); 	
	}*/
	
	//configuração de recursos estáticos
	@Override
	public void configure(WebSecurity web) throws Exception {
	
	}


}
