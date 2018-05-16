package hh.fi.name404.Kyselypalvelu404;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import hh.fi.name404.Kyselypalvelu404.domain.Ryhma;
import hh.fi.name404.Kyselypalvelu404.domain.User;
import hh.fi.name404.Kyselypalvelu404.domain.UserRepository;

/*
@SpringBootApplication
public class Kyselypalvelu404Application extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(Kyselypalvelu404Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder	application) {
		return application.sources(Kyselypalvelu404Application.class);
	}

}
*/

@SpringBootApplication
public class Kyselypalvelu404Application  {

	public static void main(String[] args) {
		SpringApplication.run(Kyselypalvelu404Application.class, args);
	}
	/*
	@Bean
	public CommandLineRunner addUser(UserRepository urepository) {
		return (args) -> {
			urepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
			urepository.save(new User("Ryhma4", "$2a$10$K3mDmN67IMgay.A.5PoJu.u18Cr4jJeB6XZjYPXwAYIo.Vr2nD8Su", "USER"));
			urepository.save(new User("Digibox", "$2a$10$dmO4HssjKwYJi5fuH5jr3eFKaFY5EAPCYO/F57frxTUZe0uCFVtga", "USER"));
			
		};
	}
	*/
}

