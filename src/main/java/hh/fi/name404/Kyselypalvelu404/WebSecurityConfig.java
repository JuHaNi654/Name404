package hh.fi.name404.Kyselypalvelu404;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.fi.name404.Kyselypalvelu404.web.UserDetailServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserDetailServiceImpl userDetailsService;	
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
	        .and()
	        .authorizeRequests().antMatchers("/kyselyt/**").permitAll()
	        .and()
	        .authorizeRequests().antMatchers("/ryhmat/**").permitAll()
	        .and()
	        .authorizeRequests().antMatchers("/kysymykset/**").permitAll()
	        .and()
	        .authorizeRequests().antMatchers("/index").permitAll()
	        .and()
	        .authorizeRequests().antMatchers("/addvastaus").permitAll()
	        .and()
	        .authorizeRequests().anyRequest().authenticated()
	        .and()
	      .formLogin()
	          .loginPage("/login")
	          .defaultSuccessUrl("/kaikkikyselyt")
	          .permitAll()
	          .and()
	      .logout()
	          .permitAll();
	    }

	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	    }
	}
