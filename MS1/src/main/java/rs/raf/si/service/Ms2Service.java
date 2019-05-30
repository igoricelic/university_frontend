package rs.raf.si.service;

import java.util.List;

import org.springframework.http.HttpMethod;

import rs.raf.si.annotations.Body;
import rs.raf.si.annotations.RemoteService;
import rs.raf.si.annotations.RequestMapping;
import rs.raf.si.dto.User;

@RemoteService(name = "ms2")
public interface Ms2Service {
	
	@RequestMapping(path = "/addUser", method = HttpMethod.POST)
	User addUser(@Body User user);
	
	@RequestMapping(path = "/getUsers", method = HttpMethod.GET)
	List<User> getUsers();

}
