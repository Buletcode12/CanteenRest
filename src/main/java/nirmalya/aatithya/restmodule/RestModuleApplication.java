package nirmalya.aatithya.restmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.MailService;
import nirmalya.aatithya.restmodule.util.DocumentUpload;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class RestModuleApplication { 

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	@Bean
	public EnvironmentVaribles environmentVaribles() {
		EnvironmentVaribles env = new EnvironmentVaribles();
		return env;
	}
	@Bean
	public DocumentUpload documentUpload() {
		DocumentUpload documentUpload = new DocumentUpload();
		return documentUpload;
	}
	public static void main(String[] args) {
		SpringApplication.run(RestModuleApplication.class, args);
	}

}
