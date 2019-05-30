package rs.raf.si.ctrl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import rs.raf.si.dto.ApplicationMetadata;
import rs.raf.si.service.GatewayService;
import rs.raf.si.service.Registry;

@RestController
public class GatewayCtrl {
	
	private static final String NEW_APP_PREFIX = "/api-gateway/newApp";
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private Registry registry;
	
	@Autowired
	private GatewayService gatewayService;
	
	@RequestMapping(path = "/**", method = RequestMethod.POST)
	public @ResponseBody String router(@RequestBody String body, HttpMethod method, HttpServletRequest request) throws URISyntaxException {
		if(request.getRequestURI().startsWith(NEW_APP_PREFIX)) {
			try {
				ApplicationMetadata applicationMetadata = objectMapper.readValue(body, ApplicationMetadata.class);
				return registry.registerNewApp(applicationMetadata).toString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		URI uri = registry.prepareURI(request);
		return gatewayService.forwardPost(uri, body);
	}
	
	@RequestMapping(path = "/**", method = RequestMethod.GET)
	public @ResponseBody String router(HttpMethod method, HttpServletRequest request) throws URISyntaxException {
		URI uri = registry.prepareURI(request);
		return gatewayService.forwardGet(uri);
	}

}
