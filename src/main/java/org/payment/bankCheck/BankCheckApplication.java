package org.payment.bankCheck;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;


//http://localhost:8080/swagger-ui/index.html#/
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")//chargement du fichier xml qui declarent les beans
public class BankCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCheckApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
       PasswordEncoder passwordEncoder = passwordEncoder();
	   return args -> {
		   if (!jdbcUserDetailsManager.userExists("admin")) {
			   System.out.println("c*************************");
			   UserDetails admin = User.withUsername("admin")
					   .password(passwordEncoder.encode("admin123"))
					   .roles("ADMIN")
					   .build();
			   jdbcUserDetailsManager.createUser(admin);
		   }

		   // Créer l'utilisateur user
		   if (!jdbcUserDetailsManager.userExists("user")) {
			   UserDetails user = User.withUsername("user")
					   .password(passwordEncoder.encode("user123"))
					   .roles("USER")
					   .build();
			   jdbcUserDetailsManager.createUser(user);
		   }
	   };
	}


	// Utiliser BCrypt pour encoder les mots de passe
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
