package com.dmcelligott.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {
	private final static Logger logger = LoggerFactory.getLogger(UserServiceApplication.class);
	
    public static void main(String[] args) {
    	logger.info("Pre-start");
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
