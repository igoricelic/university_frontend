package rs.raf.si;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import rs.raf.si.domain.ApplicationMetadata;
import rs.raf.si.proxy.HttpClientProxy;

@Configuration
public class Config {
	
private static final String API_GATEWAY_SINGUP_PATH = "/api-gateway/newApp";
	
	@Value("${server.port}")
	private int port;
	
	@Value("${spring.application.name}")
	private String name;
	
	@Value("${si.cloud.api-gateway.host}")
	private String apiGatewayHost;
	
	@Value("${si.cloud.api-gateway.port}")
	private String apiGatewayPort;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static <T> T createProxt(Class<T> interfaceClass) {
		return (T) HttpClientProxy.newInstance("http://localhost:9000", interfaceClass);
	}
	
	public String getApiGatewayAddress() {
		return "http://" + apiGatewayHost+":"+apiGatewayPort;
	}
	
	@PostConstruct
	public void singUp() {
		RestTemplate restTemplate = getRestTemplate();
		String address = getApiGatewayAddress() + API_GATEWAY_SINGUP_PATH;
		ApplicationMetadata applicationMetadata = new ApplicationMetadata("http", name, "localhost", port);
		ResponseEntity<Boolean> response = restTemplate.postForEntity(address, applicationMetadata, Boolean.class);
	}

}
