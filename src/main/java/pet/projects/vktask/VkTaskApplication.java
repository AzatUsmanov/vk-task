package pet.projects.vktask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class VkTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(VkTaskApplication.class, args);
	}

}
