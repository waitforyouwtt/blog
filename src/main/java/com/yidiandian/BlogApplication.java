package com.yidiandian;

import com.yidiandian.utils.SnowflakeIdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Bean
	public SnowflakeIdWorker snowflakeIdWorker(){
		return new SnowflakeIdWorker(1,1);
	}
}
