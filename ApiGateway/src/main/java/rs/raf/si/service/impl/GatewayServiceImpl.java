package rs.raf.si.service.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import rs.raf.si.service.GatewayService;

@Service
public class GatewayServiceImpl implements GatewayService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String forwardGet(URI uri) {
	    return forwardRequest(HttpMethod.GET, new HttpEntity<String>(getDefaultHeader()), uri);
	}

	@Override
	public String forwardPost(URI uri, String body) {
	    return forwardRequest(HttpMethod.POST, new HttpEntity<String>(body, getDefaultHeader()), uri);
	}
	
	private HttpHeaders getDefaultHeader() {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
	}
	
	private String forwardRequest(HttpMethod method, HttpEntity<String> entity, URI uri) {
		ResponseEntity<String> responseEntity =
		        restTemplate.exchange(uri, method, entity, String.class);
		return responseEntity.getBody();
	}

}
