package SKNI.KOD.Literaki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterakiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiterakiApplication.class, args);
		System.out.println("http://localhost:8080/swagger.html");
	}
}
