package in.net.impulsetech.ImpulseMail.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="in.net.impulsetech.ImpulseMail.config, in.net.impulsetech.ImpulseMail.api")
public class ImpulseMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImpulseMailApplication.class, args);
	}
	

}
