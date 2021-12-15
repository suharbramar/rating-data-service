package io.bramcode.movie.ratingdataservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingDataServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingDataServicesApplication.class, args);
	}

}
