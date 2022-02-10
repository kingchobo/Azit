package com.ssafy.Azit;

import com.ssafy.Azit.controller.SampleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {"com.ssafy.Azit.controller"})
public class AzitApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzitApplication.class, args);
	}

}
