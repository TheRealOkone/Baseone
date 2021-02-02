package com.example.Baseone;

import com.example.Baseone.BACK.JDBCBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.sql.SQLException;

@SpringBootApplication
public class BaseoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseoneApplication.class, args);
	}

}
