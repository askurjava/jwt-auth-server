package com.epam.jwt.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * The type Jwt auth server application.
 */
@EnableEurekaClient
@SpringBootApplication
public class JwtAuthServerApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
        SpringApplication.run(JwtAuthServerApplication.class, args);
    }

}
