package raf.si.maticneknjige;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import raf.si.commonhttpclient.Config;

@SpringBootApplication
public class MaticneknjigeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaticneknjigeApplication.class, args);
	}
	
	@Bean
	public void singUp() {
		Config config = new Config(9090, "maticneknjige", "localhost", "9000");
		config.singUp();
	}

}
