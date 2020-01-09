package ke.co.codingcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@SpringBootApplication
public class OctoRentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OctoRentalsApplication.class, args);
	}

	@GetMapping(value="/")
	public String home() {
		return "Home";
	}
	

}
