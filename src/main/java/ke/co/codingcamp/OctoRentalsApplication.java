package ke.co.codingcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class OctoRentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OctoRentalsApplication.class, args);
	}

	@GetMapping("/")
	public String home(){

		return "home";
	}

}
