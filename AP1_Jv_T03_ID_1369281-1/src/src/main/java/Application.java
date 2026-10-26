import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"web", "domain", "datasource", "di"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}