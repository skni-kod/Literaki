package SKNI.KOD.Literaki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class LiterakiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiterakiApplication.class, args);
		System.out.println("http://localhost:8080/swagger.html");
	}
}
