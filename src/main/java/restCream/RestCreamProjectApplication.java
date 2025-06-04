package restCream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import restCream.config.DBCredentials;

@SpringBootApplication
@RestController
public class RestCreamProjectApplication {
	public static void main(String[] args) {
		DBCredentials.getDBCredentials();
		SpringApplication.run(RestCreamProjectApplication.class, args);
	}

	@GetMapping()
	public String home() {
		return "RestCream home page";
	}
}