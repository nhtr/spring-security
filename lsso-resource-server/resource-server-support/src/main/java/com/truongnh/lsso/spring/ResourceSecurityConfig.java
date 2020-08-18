package com.truongnh.lsso.spring;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
//    private String jwkSetUri;

	@Override
	protected void configure(HttpSecurity http) throws Exception {// @formatter:off
		http.cors(withDefaults()).authorizeRequests().antMatchers(HttpMethod.GET, "/user/info/**").authenticated()
				.antMatchers(HttpMethod.GET, "/api/projects/**").hasAuthority("SCOPE_read")
				.antMatchers(HttpMethod.POST, "/api/projects").hasAuthority("SCOPE_write").anyRequest().authenticated()
				.and().oauth2ResourceServer().jwt();
	}// @formatter:on

	// TODO: Trust multiple algorithms for signature verifications with java code
//    @Bean
//    JwtDecoder jwtDecoder() {
//        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri)
//            .jwsAlgorithm(SignatureAlgorithm.RS512)
//            .jwsAlgorithm(SignatureAlgorithm.RS256)
//            .build();
//    }

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(singletonList("http://localhost:4200"));
		configuration.setAllowedMethods(asList("GET", "POST"));
		configuration.setAllowedHeaders(asList(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
