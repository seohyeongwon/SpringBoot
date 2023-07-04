package org.comstudy;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(DemoApplication.class);
		
		app.setWebApplicationType(WebApplicationType.SERVLET);
		
		app.setBannerMode(Banner.Mode.OFF);
		
		app.run(args);
		
	}

}
