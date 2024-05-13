package rs.ac.bg.fon.ai.ProjekatKosarka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjekatKosarkaApplication {

	
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ProjekatKosarkaApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }

}
