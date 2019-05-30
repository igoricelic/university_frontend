package rs.raf.si.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import rs.raf.si.dto.ApplicationMetadata;
import rs.raf.si.service.Registry;

@Service
public class RegistryImpl implements Registry {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistryImpl.class);
	
	private Map<String, ApplicationMetadata> registry;
	
	public RegistryImpl() {
		this.registry = new HashMap<String, ApplicationMetadata>();
	}

	@Override
	public Boolean registerNewApp(ApplicationMetadata applicationMetadata) {
		logger.info("New application {} has been registered on host: {} and port: {}", applicationMetadata.getName(), applicationMetadata.getHost(), applicationMetadata.getPort());
		this.registry.put(applicationMetadata.getName(), applicationMetadata);
		return true;
	}

	@Override
	public URI prepareURI(HttpServletRequest request) {
		String applicationName = request.getRequestURI().split("/")[1];
		String uriWithoutServiceName = Arrays.stream(request.getRequestURI().split("/"))
			.filter(el -> !el.equals("") && !el.equals(applicationName))
			.collect(Collectors.joining("/")).toString();
		System.out.println(uriWithoutServiceName);
		ApplicationMetadata applicationMetadata = registry.get(applicationName);
		try {
			URI uri = new URI(applicationMetadata.getProtokol(), null, applicationMetadata.getHost(), applicationMetadata.getPort(), "/" + uriWithoutServiceName, request.getQueryString(), null);
			return uri;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

}
