package com.example.TripManagementApplication;

import com.example.TripManagementApplication.controller.AuthController;
import com.example.TripManagementApplication.model.Route;
import com.example.TripManagementApplication.payload.request.SignupRequest;
import com.example.TripManagementApplication.service.RouteService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "Case study submission by Neeraj Swami"))
public class TripManagementApplication implements CommandLineRunner {

	@Autowired
	AuthController authController;

	@Autowired
	RouteService routeService;

	public static void main(String[] args) {
		SpringApplication.run(TripManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		authController.registerUser(
				new SignupRequest("neeraj", "neeraj@gmail.com", "admin", "neeraj"));

		routeService.addRoute(new Route(1L, "Chennai", "Jaipur"));
	}
}
