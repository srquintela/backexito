package org.springframework.samples.exito.system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.session.SessionManagementFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
            .csrf().disable().authorizeRequests().antMatchers("/", "/usuarios/**").permitAll()
				.antMatchers("/", "/fragments/**").permitAll().antMatchers("/", "../static/resources/**").permitAll()
				.antMatchers("/", "/console/**").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/welcome").permitAll().and().logout().permitAll();
		http.headers().frameOptions().disable();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

}
