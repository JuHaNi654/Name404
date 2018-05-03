package hh.fi.name404.Kyselypalvelu404;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/kyselyt/*").allowedOrigins("*");
                
            }
        };
    }

}

