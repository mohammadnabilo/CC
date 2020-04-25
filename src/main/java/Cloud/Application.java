package Cloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class Application implements WebMvcConfigurer {
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/container").setViewName("ContainerPage");
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	

}
	



