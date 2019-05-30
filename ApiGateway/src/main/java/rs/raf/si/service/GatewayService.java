package rs.raf.si.service;

import java.net.URI;

public interface GatewayService {
	
	String forwardGet(URI uri);
	
	String forwardPost(URI uri, String body);

}
