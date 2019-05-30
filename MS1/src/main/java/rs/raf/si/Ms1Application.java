package rs.raf.si;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rs.raf.si.proxy.HttpClientProxy;
import rs.raf.si.service.Ms2Service;

@SpringBootApplication
public class Ms1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ms1Application.class, args);
	}
	
	@Bean
	public Ms2Service getMs2ServiceBean() {
		return Config.createProxt(Ms2Service.class);
	}

}
