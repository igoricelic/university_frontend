package rs.raf.si.service;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import rs.raf.si.dto.ApplicationMetadata;

public interface Registry {
	
	public Boolean registerNewApp(ApplicationMetadata applicationMetadata);
	
	public URI prepareURI(HttpServletRequest request);

}
