package rs.raf.si.dto;

public class ApplicationMetadata {
	
	private String protokol;
	
	private String name;
	
	private String host;
	
	private Integer port;
	
	public String getProtokol() {
		return protokol;
	}
	
	public void setProtokol(String protokol) {
		this.protokol = protokol;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public Integer getPort() {
		return port;
	}
	
	public void setPort(Integer port) {
		this.port = port;
	}

}
